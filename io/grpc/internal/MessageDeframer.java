package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.Codec;
import io.grpc.Decompressor;
import io.grpc.Status;
import java.io.Closeable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class MessageDeframer implements Closeable, Deframer {
  private static final int COMPRESSED_FLAG_MASK = 1;
  
  private static final int HEADER_LENGTH = 5;
  
  private static final int MAX_BUFFER_SIZE = 2097152;
  
  private static final int RESERVED_MASK = 254;
  
  private boolean closeWhenComplete = false;
  
  private boolean compressedFlag;
  
  private int currentMessageSeqNo = -1;
  
  private Decompressor decompressor;
  
  private GzipInflatingBuffer fullStreamDecompressor;
  
  private boolean inDelivery = false;
  
  private int inboundBodyWireSize;
  
  private byte[] inflatedBuffer;
  
  private int inflatedIndex;
  
  private Listener listener;
  
  private int maxInboundMessageSize;
  
  private CompositeReadableBuffer nextFrame;
  
  private long pendingDeliveries;
  
  private int requiredLength = 5;
  
  private State state = State.HEADER;
  
  private final StatsTraceContext statsTraceCtx;
  
  private volatile boolean stopDelivery = false;
  
  private final TransportTracer transportTracer;
  
  private CompositeReadableBuffer unprocessed = new CompositeReadableBuffer();
  
  public MessageDeframer(Listener paramListener, Decompressor paramDecompressor, int paramInt, StatsTraceContext paramStatsTraceContext, TransportTracer paramTransportTracer) {
    this.listener = (Listener)Preconditions.checkNotNull(paramListener, "sink");
    this.decompressor = (Decompressor)Preconditions.checkNotNull(paramDecompressor, "decompressor");
    this.maxInboundMessageSize = paramInt;
    this.statsTraceCtx = (StatsTraceContext)Preconditions.checkNotNull(paramStatsTraceContext, "statsTraceCtx");
    this.transportTracer = (TransportTracer)Preconditions.checkNotNull(paramTransportTracer, "transportTracer");
  }
  
  private void deliver() {
    if (this.inDelivery)
      return; 
    this.inDelivery = true;
    try {
      while (!this.stopDelivery && this.pendingDeliveries > 0L && readRequiredBytes()) {
        AssertionError assertionError;
        StringBuilder stringBuilder;
        switch (this.state) {
          default:
            assertionError = new AssertionError();
            stringBuilder = new StringBuilder();
            this();
            stringBuilder.append("Invalid state: ");
            stringBuilder.append(this.state);
            this(stringBuilder.toString());
            throw assertionError;
          case BODY:
            processBody();
            this.pendingDeliveries--;
            continue;
          case HEADER:
            break;
        } 
        processHeader();
      } 
      if (this.stopDelivery) {
        close();
        return;
      } 
      if (this.closeWhenComplete && isStalled())
        close(); 
      return;
    } finally {
      this.inDelivery = false;
    } 
  }
  
  private InputStream getCompressedBody() {
    if (this.decompressor != Codec.Identity.NONE)
      try {
        return new SizeEnforcingInputStream(this.decompressor.decompress(ReadableBuffers.openStream(this.nextFrame, true)), this.maxInboundMessageSize, this.statsTraceCtx);
      } catch (IOException iOException) {
        throw new RuntimeException(iOException);
      }  
    throw Status.INTERNAL.withDescription("Can't decode compressed gRPC message as compression not configured").asRuntimeException();
  }
  
  private InputStream getUncompressedBody() {
    this.statsTraceCtx.inboundUncompressedSize(this.nextFrame.readableBytes());
    return ReadableBuffers.openStream(this.nextFrame, true);
  }
  
  private boolean isClosedOrScheduledToClose() {
    return (isClosed() || this.closeWhenComplete);
  }
  
  private boolean isStalled() {
    boolean bool;
    GzipInflatingBuffer gzipInflatingBuffer = this.fullStreamDecompressor;
    if (gzipInflatingBuffer != null)
      return gzipInflatingBuffer.isStalled(); 
    if (this.unprocessed.readableBytes() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private void processBody() {
    InputStream inputStream;
    this.statsTraceCtx.inboundMessageRead(this.currentMessageSeqNo, this.inboundBodyWireSize, -1L);
    this.inboundBodyWireSize = 0;
    if (this.compressedFlag) {
      inputStream = getCompressedBody();
    } else {
      inputStream = getUncompressedBody();
    } 
    this.nextFrame = null;
    this.listener.messagesAvailable(new SingleMessageProducer(inputStream));
    this.state = State.HEADER;
    this.requiredLength = 5;
  }
  
  private void processHeader() {
    int i = this.nextFrame.readUnsignedByte();
    if ((i & 0xFE) == 0) {
      boolean bool;
      if ((i & 0x1) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.compressedFlag = bool;
      this.requiredLength = this.nextFrame.readInt();
      i = this.requiredLength;
      if (i >= 0 && i <= this.maxInboundMessageSize) {
        this.currentMessageSeqNo++;
        this.statsTraceCtx.inboundMessage(this.currentMessageSeqNo);
        this.transportTracer.reportMessageReceived();
        this.state = State.BODY;
        return;
      } 
      throw Status.RESOURCE_EXHAUSTED.withDescription(String.format("gRPC message exceeds maximum size %d: %d", new Object[] { Integer.valueOf(this.maxInboundMessageSize), Integer.valueOf(this.requiredLength) })).asRuntimeException();
    } 
    throw Status.INTERNAL.withDescription("gRPC frame header malformed: reserved bits not zero").asRuntimeException();
  }
  
  private boolean readRequiredBytes() {
    // Byte code:
    //   0: aload_0
    //   1: getfield nextFrame : Lio/grpc/internal/CompositeReadableBuffer;
    //   4: ifnonnull -> 20
    //   7: new io/grpc/internal/CompositeReadableBuffer
    //   10: astore_1
    //   11: aload_1
    //   12: invokespecial <init> : ()V
    //   15: aload_0
    //   16: aload_1
    //   17: putfield nextFrame : Lio/grpc/internal/CompositeReadableBuffer;
    //   20: iconst_0
    //   21: istore_2
    //   22: iconst_0
    //   23: istore_3
    //   24: iload_2
    //   25: istore #4
    //   27: iload_3
    //   28: istore #5
    //   30: aload_0
    //   31: getfield requiredLength : I
    //   34: aload_0
    //   35: getfield nextFrame : Lio/grpc/internal/CompositeReadableBuffer;
    //   38: invokevirtual readableBytes : ()I
    //   41: isub
    //   42: istore #6
    //   44: iload #6
    //   46: ifle -> 675
    //   49: iload_2
    //   50: istore #4
    //   52: iload_3
    //   53: istore #5
    //   55: aload_0
    //   56: getfield fullStreamDecompressor : Lio/grpc/internal/GzipInflatingBuffer;
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull -> 531
    //   64: iload_2
    //   65: istore #7
    //   67: iload_3
    //   68: istore #8
    //   70: iload_2
    //   71: istore #9
    //   73: iload_3
    //   74: istore #10
    //   76: iload_2
    //   77: istore #4
    //   79: iload_3
    //   80: istore #5
    //   82: aload_0
    //   83: getfield inflatedBuffer : [B
    //   86: ifnull -> 119
    //   89: iload_2
    //   90: istore #7
    //   92: iload_3
    //   93: istore #8
    //   95: iload_2
    //   96: istore #9
    //   98: iload_3
    //   99: istore #10
    //   101: iload_2
    //   102: istore #4
    //   104: iload_3
    //   105: istore #5
    //   107: aload_0
    //   108: getfield inflatedIndex : I
    //   111: aload_0
    //   112: getfield inflatedBuffer : [B
    //   115: arraylength
    //   116: if_icmpne -> 173
    //   119: iload_2
    //   120: istore #7
    //   122: iload_3
    //   123: istore #8
    //   125: iload_2
    //   126: istore #9
    //   128: iload_3
    //   129: istore #10
    //   131: iload_2
    //   132: istore #4
    //   134: iload_3
    //   135: istore #5
    //   137: aload_0
    //   138: iload #6
    //   140: ldc 2097152
    //   142: invokestatic min : (II)I
    //   145: newarray byte
    //   147: putfield inflatedBuffer : [B
    //   150: iload_2
    //   151: istore #7
    //   153: iload_3
    //   154: istore #8
    //   156: iload_2
    //   157: istore #9
    //   159: iload_3
    //   160: istore #10
    //   162: iload_2
    //   163: istore #4
    //   165: iload_3
    //   166: istore #5
    //   168: aload_0
    //   169: iconst_0
    //   170: putfield inflatedIndex : I
    //   173: iload_2
    //   174: istore #7
    //   176: iload_3
    //   177: istore #8
    //   179: iload_2
    //   180: istore #9
    //   182: iload_3
    //   183: istore #10
    //   185: iload_2
    //   186: istore #4
    //   188: iload_3
    //   189: istore #5
    //   191: iload #6
    //   193: aload_0
    //   194: getfield inflatedBuffer : [B
    //   197: arraylength
    //   198: aload_0
    //   199: getfield inflatedIndex : I
    //   202: isub
    //   203: invokestatic min : (II)I
    //   206: istore #6
    //   208: iload_2
    //   209: istore #7
    //   211: iload_3
    //   212: istore #8
    //   214: iload_2
    //   215: istore #9
    //   217: iload_3
    //   218: istore #10
    //   220: iload_2
    //   221: istore #4
    //   223: iload_3
    //   224: istore #5
    //   226: aload_0
    //   227: getfield fullStreamDecompressor : Lio/grpc/internal/GzipInflatingBuffer;
    //   230: aload_0
    //   231: getfield inflatedBuffer : [B
    //   234: aload_0
    //   235: getfield inflatedIndex : I
    //   238: iload #6
    //   240: invokevirtual inflateBytes : ([BII)I
    //   243: istore #6
    //   245: iload_2
    //   246: istore #7
    //   248: iload_3
    //   249: istore #8
    //   251: iload_2
    //   252: istore #9
    //   254: iload_3
    //   255: istore #10
    //   257: iload_2
    //   258: istore #4
    //   260: iload_3
    //   261: istore #5
    //   263: iload_2
    //   264: aload_0
    //   265: getfield fullStreamDecompressor : Lio/grpc/internal/GzipInflatingBuffer;
    //   268: invokevirtual getAndResetBytesConsumed : ()I
    //   271: iadd
    //   272: istore_2
    //   273: iload_2
    //   274: istore #7
    //   276: iload_3
    //   277: istore #8
    //   279: iload_2
    //   280: istore #9
    //   282: iload_3
    //   283: istore #10
    //   285: iload_2
    //   286: istore #4
    //   288: iload_3
    //   289: istore #5
    //   291: aload_0
    //   292: getfield fullStreamDecompressor : Lio/grpc/internal/GzipInflatingBuffer;
    //   295: invokevirtual getAndResetDeflatedBytesConsumed : ()I
    //   298: istore #11
    //   300: iload_3
    //   301: iload #11
    //   303: iadd
    //   304: istore_3
    //   305: iload #6
    //   307: ifne -> 384
    //   310: iload_2
    //   311: ifle -> 382
    //   314: aload_0
    //   315: getfield listener : Lio/grpc/internal/MessageDeframer$Listener;
    //   318: iload_2
    //   319: invokeinterface bytesRead : (I)V
    //   324: aload_0
    //   325: getfield state : Lio/grpc/internal/MessageDeframer$State;
    //   328: getstatic io/grpc/internal/MessageDeframer$State.BODY : Lio/grpc/internal/MessageDeframer$State;
    //   331: if_acmpne -> 382
    //   334: aload_0
    //   335: getfield fullStreamDecompressor : Lio/grpc/internal/GzipInflatingBuffer;
    //   338: ifnull -> 363
    //   341: aload_0
    //   342: getfield statsTraceCtx : Lio/grpc/internal/StatsTraceContext;
    //   345: iload_3
    //   346: i2l
    //   347: invokevirtual inboundWireSize : (J)V
    //   350: aload_0
    //   351: aload_0
    //   352: getfield inboundBodyWireSize : I
    //   355: iload_3
    //   356: iadd
    //   357: putfield inboundBodyWireSize : I
    //   360: goto -> 382
    //   363: aload_0
    //   364: getfield statsTraceCtx : Lio/grpc/internal/StatsTraceContext;
    //   367: iload_2
    //   368: i2l
    //   369: invokevirtual inboundWireSize : (J)V
    //   372: aload_0
    //   373: aload_0
    //   374: getfield inboundBodyWireSize : I
    //   377: iload_2
    //   378: iadd
    //   379: putfield inboundBodyWireSize : I
    //   382: iconst_0
    //   383: ireturn
    //   384: iload_2
    //   385: istore #7
    //   387: iload_3
    //   388: istore #8
    //   390: iload_2
    //   391: istore #9
    //   393: iload_3
    //   394: istore #10
    //   396: iload_2
    //   397: istore #4
    //   399: iload_3
    //   400: istore #5
    //   402: aload_0
    //   403: getfield nextFrame : Lio/grpc/internal/CompositeReadableBuffer;
    //   406: aload_0
    //   407: getfield inflatedBuffer : [B
    //   410: aload_0
    //   411: getfield inflatedIndex : I
    //   414: iload #6
    //   416: invokestatic wrap : ([BII)Lio/grpc/internal/ReadableBuffer;
    //   419: invokevirtual addBuffer : (Lio/grpc/internal/ReadableBuffer;)V
    //   422: iload_2
    //   423: istore #7
    //   425: iload_3
    //   426: istore #8
    //   428: iload_2
    //   429: istore #9
    //   431: iload_3
    //   432: istore #10
    //   434: iload_2
    //   435: istore #4
    //   437: iload_3
    //   438: istore #5
    //   440: aload_0
    //   441: aload_0
    //   442: getfield inflatedIndex : I
    //   445: iload #6
    //   447: iadd
    //   448: putfield inflatedIndex : I
    //   451: goto -> 24
    //   454: astore #12
    //   456: iload #7
    //   458: istore #4
    //   460: iload #8
    //   462: istore #5
    //   464: new java/lang/RuntimeException
    //   467: astore_1
    //   468: iload #7
    //   470: istore #4
    //   472: iload #8
    //   474: istore #5
    //   476: aload_1
    //   477: aload #12
    //   479: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   482: iload #7
    //   484: istore #4
    //   486: iload #8
    //   488: istore #5
    //   490: aload_1
    //   491: athrow
    //   492: astore_1
    //   493: iload #9
    //   495: istore #4
    //   497: iload #10
    //   499: istore #5
    //   501: new java/lang/RuntimeException
    //   504: astore #12
    //   506: iload #9
    //   508: istore #4
    //   510: iload #10
    //   512: istore #5
    //   514: aload #12
    //   516: aload_1
    //   517: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   520: iload #9
    //   522: istore #4
    //   524: iload #10
    //   526: istore #5
    //   528: aload #12
    //   530: athrow
    //   531: iload_2
    //   532: istore #4
    //   534: iload_3
    //   535: istore #5
    //   537: aload_0
    //   538: getfield unprocessed : Lio/grpc/internal/CompositeReadableBuffer;
    //   541: invokevirtual readableBytes : ()I
    //   544: istore #9
    //   546: iload #9
    //   548: ifne -> 625
    //   551: iload_2
    //   552: ifle -> 623
    //   555: aload_0
    //   556: getfield listener : Lio/grpc/internal/MessageDeframer$Listener;
    //   559: iload_2
    //   560: invokeinterface bytesRead : (I)V
    //   565: aload_0
    //   566: getfield state : Lio/grpc/internal/MessageDeframer$State;
    //   569: getstatic io/grpc/internal/MessageDeframer$State.BODY : Lio/grpc/internal/MessageDeframer$State;
    //   572: if_acmpne -> 623
    //   575: aload_0
    //   576: getfield fullStreamDecompressor : Lio/grpc/internal/GzipInflatingBuffer;
    //   579: ifnull -> 604
    //   582: aload_0
    //   583: getfield statsTraceCtx : Lio/grpc/internal/StatsTraceContext;
    //   586: iload_3
    //   587: i2l
    //   588: invokevirtual inboundWireSize : (J)V
    //   591: aload_0
    //   592: aload_0
    //   593: getfield inboundBodyWireSize : I
    //   596: iload_3
    //   597: iadd
    //   598: putfield inboundBodyWireSize : I
    //   601: goto -> 623
    //   604: aload_0
    //   605: getfield statsTraceCtx : Lio/grpc/internal/StatsTraceContext;
    //   608: iload_2
    //   609: i2l
    //   610: invokevirtual inboundWireSize : (J)V
    //   613: aload_0
    //   614: aload_0
    //   615: getfield inboundBodyWireSize : I
    //   618: iload_2
    //   619: iadd
    //   620: putfield inboundBodyWireSize : I
    //   623: iconst_0
    //   624: ireturn
    //   625: iload_2
    //   626: istore #4
    //   628: iload_3
    //   629: istore #5
    //   631: iload #6
    //   633: aload_0
    //   634: getfield unprocessed : Lio/grpc/internal/CompositeReadableBuffer;
    //   637: invokevirtual readableBytes : ()I
    //   640: invokestatic min : (II)I
    //   643: istore #9
    //   645: iload_2
    //   646: iload #9
    //   648: iadd
    //   649: istore_2
    //   650: iload_2
    //   651: istore #4
    //   653: iload_3
    //   654: istore #5
    //   656: aload_0
    //   657: getfield nextFrame : Lio/grpc/internal/CompositeReadableBuffer;
    //   660: aload_0
    //   661: getfield unprocessed : Lio/grpc/internal/CompositeReadableBuffer;
    //   664: iload #9
    //   666: invokevirtual readBytes : (I)Lio/grpc/internal/CompositeReadableBuffer;
    //   669: invokevirtual addBuffer : (Lio/grpc/internal/ReadableBuffer;)V
    //   672: goto -> 24
    //   675: iload_2
    //   676: ifle -> 747
    //   679: aload_0
    //   680: getfield listener : Lio/grpc/internal/MessageDeframer$Listener;
    //   683: iload_2
    //   684: invokeinterface bytesRead : (I)V
    //   689: aload_0
    //   690: getfield state : Lio/grpc/internal/MessageDeframer$State;
    //   693: getstatic io/grpc/internal/MessageDeframer$State.BODY : Lio/grpc/internal/MessageDeframer$State;
    //   696: if_acmpne -> 747
    //   699: aload_0
    //   700: getfield fullStreamDecompressor : Lio/grpc/internal/GzipInflatingBuffer;
    //   703: ifnull -> 728
    //   706: aload_0
    //   707: getfield statsTraceCtx : Lio/grpc/internal/StatsTraceContext;
    //   710: iload_3
    //   711: i2l
    //   712: invokevirtual inboundWireSize : (J)V
    //   715: aload_0
    //   716: aload_0
    //   717: getfield inboundBodyWireSize : I
    //   720: iload_3
    //   721: iadd
    //   722: putfield inboundBodyWireSize : I
    //   725: goto -> 747
    //   728: aload_0
    //   729: getfield statsTraceCtx : Lio/grpc/internal/StatsTraceContext;
    //   732: iload_2
    //   733: i2l
    //   734: invokevirtual inboundWireSize : (J)V
    //   737: aload_0
    //   738: aload_0
    //   739: getfield inboundBodyWireSize : I
    //   742: iload_2
    //   743: iadd
    //   744: putfield inboundBodyWireSize : I
    //   747: iconst_1
    //   748: ireturn
    //   749: astore_1
    //   750: goto -> 760
    //   753: astore_1
    //   754: iconst_0
    //   755: istore #4
    //   757: iconst_0
    //   758: istore #5
    //   760: iload #4
    //   762: ifle -> 838
    //   765: aload_0
    //   766: getfield listener : Lio/grpc/internal/MessageDeframer$Listener;
    //   769: iload #4
    //   771: invokeinterface bytesRead : (I)V
    //   776: aload_0
    //   777: getfield state : Lio/grpc/internal/MessageDeframer$State;
    //   780: getstatic io/grpc/internal/MessageDeframer$State.BODY : Lio/grpc/internal/MessageDeframer$State;
    //   783: if_acmpne -> 838
    //   786: aload_0
    //   787: getfield fullStreamDecompressor : Lio/grpc/internal/GzipInflatingBuffer;
    //   790: ifnull -> 817
    //   793: aload_0
    //   794: getfield statsTraceCtx : Lio/grpc/internal/StatsTraceContext;
    //   797: iload #5
    //   799: i2l
    //   800: invokevirtual inboundWireSize : (J)V
    //   803: aload_0
    //   804: aload_0
    //   805: getfield inboundBodyWireSize : I
    //   808: iload #5
    //   810: iadd
    //   811: putfield inboundBodyWireSize : I
    //   814: goto -> 838
    //   817: aload_0
    //   818: getfield statsTraceCtx : Lio/grpc/internal/StatsTraceContext;
    //   821: iload #4
    //   823: i2l
    //   824: invokevirtual inboundWireSize : (J)V
    //   827: aload_0
    //   828: aload_0
    //   829: getfield inboundBodyWireSize : I
    //   832: iload #4
    //   834: iadd
    //   835: putfield inboundBodyWireSize : I
    //   838: aload_1
    //   839: athrow
    // Exception table:
    //   from	to	target	type
    //   0	20	753	finally
    //   30	44	749	finally
    //   55	60	749	finally
    //   82	89	492	java/io/IOException
    //   82	89	454	java/util/zip/DataFormatException
    //   82	89	749	finally
    //   107	119	492	java/io/IOException
    //   107	119	454	java/util/zip/DataFormatException
    //   107	119	749	finally
    //   137	150	492	java/io/IOException
    //   137	150	454	java/util/zip/DataFormatException
    //   137	150	749	finally
    //   168	173	492	java/io/IOException
    //   168	173	454	java/util/zip/DataFormatException
    //   168	173	749	finally
    //   191	208	492	java/io/IOException
    //   191	208	454	java/util/zip/DataFormatException
    //   191	208	749	finally
    //   226	245	492	java/io/IOException
    //   226	245	454	java/util/zip/DataFormatException
    //   226	245	749	finally
    //   263	273	492	java/io/IOException
    //   263	273	454	java/util/zip/DataFormatException
    //   263	273	749	finally
    //   291	300	492	java/io/IOException
    //   291	300	454	java/util/zip/DataFormatException
    //   291	300	749	finally
    //   402	422	492	java/io/IOException
    //   402	422	454	java/util/zip/DataFormatException
    //   402	422	749	finally
    //   440	451	492	java/io/IOException
    //   440	451	454	java/util/zip/DataFormatException
    //   440	451	749	finally
    //   464	468	749	finally
    //   476	482	749	finally
    //   490	492	749	finally
    //   501	506	749	finally
    //   514	520	749	finally
    //   528	531	749	finally
    //   537	546	749	finally
    //   631	645	749	finally
    //   656	672	749	finally
  }
  
  public void close() {
    boolean bool1;
    if (isClosed())
      return; 
    null = this.nextFrame;
    if (null != null && null.readableBytes() > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    boolean bool2 = bool1;
    try {
      if (this.fullStreamDecompressor != null) {
        if (bool1 || this.fullStreamDecompressor.hasPartialData()) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        this.fullStreamDecompressor.close();
        bool2 = bool1;
      } 
      if (this.unprocessed != null)
        this.unprocessed.close(); 
      if (this.nextFrame != null)
        this.nextFrame.close(); 
      this.fullStreamDecompressor = null;
      return;
    } finally {
      this.fullStreamDecompressor = null;
      this.unprocessed = null;
      this.nextFrame = null;
    } 
  }
  
  public void closeWhenComplete() {
    if (isClosed())
      return; 
    if (isStalled()) {
      close();
    } else {
      this.closeWhenComplete = true;
    } 
  }
  
  public void deframe(ReadableBuffer paramReadableBuffer) {
    Preconditions.checkNotNull(paramReadableBuffer, "data");
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool3 = bool1;
    try {
      if (!isClosedOrScheduledToClose()) {
        bool3 = bool1;
        if (this.fullStreamDecompressor != null) {
          bool3 = bool1;
          this.fullStreamDecompressor.addGzippedBytes(paramReadableBuffer);
        } else {
          bool3 = bool1;
          this.unprocessed.addBuffer(paramReadableBuffer);
        } 
        bool3 = false;
        bool2 = false;
        deliver();
      } 
      return;
    } finally {
      if (bool3)
        paramReadableBuffer.close(); 
    } 
  }
  
  public boolean isClosed() {
    boolean bool;
    if (this.unprocessed == null && this.fullStreamDecompressor == null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void request(int paramInt) {
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "numMessages must be > 0");
    if (isClosed())
      return; 
    this.pendingDeliveries += paramInt;
    deliver();
  }
  
  public void setDecompressor(Decompressor paramDecompressor) {
    boolean bool;
    if (this.fullStreamDecompressor == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "Already set full stream decompressor");
    this.decompressor = (Decompressor)Preconditions.checkNotNull(paramDecompressor, "Can't pass an empty decompressor");
  }
  
  public void setFullStreamDecompressor(GzipInflatingBuffer paramGzipInflatingBuffer) {
    boolean bool2;
    Decompressor decompressor = this.decompressor;
    Codec codec = Codec.Identity.NONE;
    boolean bool1 = true;
    if (decompressor == codec) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2, "per-message decompressor already set");
    if (this.fullStreamDecompressor == null) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2, "full stream decompressor already set");
    this.fullStreamDecompressor = (GzipInflatingBuffer)Preconditions.checkNotNull(paramGzipInflatingBuffer, "Can't pass a null full stream decompressor");
    this.unprocessed = null;
  }
  
  void setListener(Listener paramListener) {
    this.listener = paramListener;
  }
  
  public void setMaxInboundMessageSize(int paramInt) {
    this.maxInboundMessageSize = paramInt;
  }
  
  void stopDelivery() {
    this.stopDelivery = true;
  }
  
  public static interface Listener {
    void bytesRead(int param1Int);
    
    void deframeFailed(Throwable param1Throwable);
    
    void deframerClosed(boolean param1Boolean);
    
    void messagesAvailable(StreamListener.MessageProducer param1MessageProducer);
  }
  
  private static class SingleMessageProducer implements StreamListener.MessageProducer {
    private InputStream message;
    
    private SingleMessageProducer(InputStream param1InputStream) {
      this.message = param1InputStream;
    }
    
    @Nullable
    public InputStream next() {
      InputStream inputStream = this.message;
      this.message = null;
      return inputStream;
    }
  }
  
  @VisibleForTesting
  static final class SizeEnforcingInputStream extends FilterInputStream {
    private long count;
    
    private long mark = -1L;
    
    private long maxCount;
    
    private final int maxMessageSize;
    
    private final StatsTraceContext statsTraceCtx;
    
    SizeEnforcingInputStream(InputStream param1InputStream, int param1Int, StatsTraceContext param1StatsTraceContext) {
      super(param1InputStream);
      this.maxMessageSize = param1Int;
      this.statsTraceCtx = param1StatsTraceContext;
    }
    
    private void reportCount() {
      long l1 = this.count;
      long l2 = this.maxCount;
      if (l1 > l2) {
        this.statsTraceCtx.inboundUncompressedSize(l1 - l2);
        this.maxCount = this.count;
      } 
    }
    
    private void verifySize() {
      if (this.count <= this.maxMessageSize)
        return; 
      throw Status.RESOURCE_EXHAUSTED.withDescription(String.format("Compressed gRPC message exceeds maximum size %d: %d bytes read", new Object[] { Integer.valueOf(this.maxMessageSize), Long.valueOf(this.count) })).asRuntimeException();
    }
    
    public void mark(int param1Int) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield in : Ljava/io/InputStream;
      //   6: iload_1
      //   7: invokevirtual mark : (I)V
      //   10: aload_0
      //   11: aload_0
      //   12: getfield count : J
      //   15: putfield mark : J
      //   18: aload_0
      //   19: monitorexit
      //   20: return
      //   21: astore_2
      //   22: aload_0
      //   23: monitorexit
      //   24: aload_2
      //   25: athrow
      // Exception table:
      //   from	to	target	type
      //   2	18	21	finally
    }
    
    public int read() throws IOException {
      int i = this.in.read();
      if (i != -1)
        this.count++; 
      verifySize();
      reportCount();
      return i;
    }
    
    public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      param1Int1 = this.in.read(param1ArrayOfbyte, param1Int1, param1Int2);
      if (param1Int1 != -1)
        this.count += param1Int1; 
      verifySize();
      reportCount();
      return param1Int1;
    }
    
    public void reset() throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield in : Ljava/io/InputStream;
      //   6: invokevirtual markSupported : ()Z
      //   9: ifeq -> 53
      //   12: aload_0
      //   13: getfield mark : J
      //   16: ldc2_w -1
      //   19: lcmp
      //   20: ifeq -> 41
      //   23: aload_0
      //   24: getfield in : Ljava/io/InputStream;
      //   27: invokevirtual reset : ()V
      //   30: aload_0
      //   31: aload_0
      //   32: getfield mark : J
      //   35: putfield count : J
      //   38: aload_0
      //   39: monitorexit
      //   40: return
      //   41: new java/io/IOException
      //   44: astore_1
      //   45: aload_1
      //   46: ldc 'Mark not set'
      //   48: invokespecial <init> : (Ljava/lang/String;)V
      //   51: aload_1
      //   52: athrow
      //   53: new java/io/IOException
      //   56: astore_1
      //   57: aload_1
      //   58: ldc 'Mark not supported'
      //   60: invokespecial <init> : (Ljava/lang/String;)V
      //   63: aload_1
      //   64: athrow
      //   65: astore_1
      //   66: aload_0
      //   67: monitorexit
      //   68: aload_1
      //   69: athrow
      // Exception table:
      //   from	to	target	type
      //   2	38	65	finally
      //   41	53	65	finally
      //   53	65	65	finally
    }
    
    public long skip(long param1Long) throws IOException {
      param1Long = this.in.skip(param1Long);
      this.count += param1Long;
      verifySize();
      reportCount();
      return param1Long;
    }
  }
  
  private enum State {
    BODY, HEADER;
    
    static {
      $VALUES = new State[] { HEADER, BODY };
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\MessageDeframer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */