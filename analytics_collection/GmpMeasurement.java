package analytics_collection;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class GmpMeasurement {
  static {
  
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class AudienceLeafFilterResult extends GeneratedMessageLite<AudienceLeafFilterResult, AudienceLeafFilterResult.Builder> implements AudienceLeafFilterResultOrBuilder {
    public static final int AUDIENCE_ID_FIELD_NUMBER = 1;
    
    public static final int CURRENT_DATA_FIELD_NUMBER = 2;
    
    private static final AudienceLeafFilterResult DEFAULT_INSTANCE = new AudienceLeafFilterResult();
    
    public static final int NEW_AUDIENCE_FIELD_NUMBER = 4;
    
    private static volatile Parser<AudienceLeafFilterResult> PARSER;
    
    public static final int PREVIOUS_DATA_FIELD_NUMBER = 3;
    
    private int audienceId_;
    
    private int bitField0_;
    
    private GmpMeasurement.ResultData currentData_;
    
    private boolean newAudience_;
    
    private GmpMeasurement.ResultData previousData_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearAudienceId() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.audienceId_ = 0;
    }
    
    private void clearCurrentData() {
      this.currentData_ = null;
      this.bitField0_ &= 0xFFFFFFFD;
    }
    
    private void clearNewAudience() {
      this.bitField0_ &= 0xFFFFFFF7;
      this.newAudience_ = false;
    }
    
    private void clearPreviousData() {
      this.previousData_ = null;
      this.bitField0_ &= 0xFFFFFFFB;
    }
    
    public static AudienceLeafFilterResult getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeCurrentData(GmpMeasurement.ResultData param1ResultData) {
      GmpMeasurement.ResultData resultData = this.currentData_;
      if (resultData != null && resultData != GmpMeasurement.ResultData.getDefaultInstance()) {
        this.currentData_ = (GmpMeasurement.ResultData)((GmpMeasurement.ResultData.Builder)GmpMeasurement.ResultData.newBuilder(this.currentData_).mergeFrom(param1ResultData)).buildPartial();
      } else {
        this.currentData_ = param1ResultData;
      } 
      this.bitField0_ |= 0x2;
    }
    
    private void mergePreviousData(GmpMeasurement.ResultData param1ResultData) {
      GmpMeasurement.ResultData resultData = this.previousData_;
      if (resultData != null && resultData != GmpMeasurement.ResultData.getDefaultInstance()) {
        this.previousData_ = (GmpMeasurement.ResultData)((GmpMeasurement.ResultData.Builder)GmpMeasurement.ResultData.newBuilder(this.previousData_).mergeFrom(param1ResultData)).buildPartial();
      } else {
        this.previousData_ = param1ResultData;
      } 
      this.bitField0_ |= 0x4;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(AudienceLeafFilterResult param1AudienceLeafFilterResult) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1AudienceLeafFilterResult);
    }
    
    public static AudienceLeafFilterResult parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (AudienceLeafFilterResult)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static AudienceLeafFilterResult parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (AudienceLeafFilterResult)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static AudienceLeafFilterResult parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (AudienceLeafFilterResult)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static AudienceLeafFilterResult parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (AudienceLeafFilterResult)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static AudienceLeafFilterResult parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (AudienceLeafFilterResult)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static AudienceLeafFilterResult parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (AudienceLeafFilterResult)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static AudienceLeafFilterResult parseFrom(InputStream param1InputStream) throws IOException {
      return (AudienceLeafFilterResult)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static AudienceLeafFilterResult parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (AudienceLeafFilterResult)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static AudienceLeafFilterResult parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (AudienceLeafFilterResult)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static AudienceLeafFilterResult parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (AudienceLeafFilterResult)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<AudienceLeafFilterResult> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setAudienceId(int param1Int) {
      this.bitField0_ |= 0x1;
      this.audienceId_ = param1Int;
    }
    
    private void setCurrentData(GmpMeasurement.ResultData.Builder param1Builder) {
      this.currentData_ = (GmpMeasurement.ResultData)param1Builder.build();
      this.bitField0_ |= 0x2;
    }
    
    private void setCurrentData(GmpMeasurement.ResultData param1ResultData) {
      if (param1ResultData != null) {
        this.currentData_ = param1ResultData;
        this.bitField0_ |= 0x2;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setNewAudience(boolean param1Boolean) {
      this.bitField0_ |= 0x8;
      this.newAudience_ = param1Boolean;
    }
    
    private void setPreviousData(GmpMeasurement.ResultData.Builder param1Builder) {
      this.previousData_ = (GmpMeasurement.ResultData)param1Builder.build();
      this.bitField0_ |= 0x4;
    }
    
    private void setPreviousData(GmpMeasurement.ResultData param1ResultData) {
      if (param1ResultData != null) {
        this.previousData_ = param1ResultData;
        this.bitField0_ |= 0x4;
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic analytics_collection/GmpMeasurement$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 583, 2 -> 579, 3 -> 577, 4 -> 568, 5 -> 442, 6 -> 110, 7 -> 438, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic analytics_collection/GmpMeasurement$AudienceLeafFilterResult.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc analytics_collection/GmpMeasurement$AudienceLeafFilterResult
      //   72: monitorenter
      //   73: getstatic analytics_collection/GmpMeasurement$AudienceLeafFilterResult.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic analytics_collection/GmpMeasurement$AudienceLeafFilterResult.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$AudienceLeafFilterResult;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic analytics_collection/GmpMeasurement$AudienceLeafFilterResult.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc analytics_collection/GmpMeasurement$AudienceLeafFilterResult
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc analytics_collection/GmpMeasurement$AudienceLeafFilterResult
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic analytics_collection/GmpMeasurement$AudienceLeafFilterResult.PARSER : Lcom/google/protobuf/Parser;
      //   109: areturn
      //   110: aload_2
      //   111: checkcast com/google/protobuf/CodedInputStream
      //   114: astore_2
      //   115: aload_3
      //   116: checkcast com/google/protobuf/ExtensionRegistryLite
      //   119: astore_3
      //   120: iconst_0
      //   121: istore #4
      //   123: iload #4
      //   125: ifne -> 438
      //   128: aload_2
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 382
      //   139: iload #5
      //   141: bipush #8
      //   143: if_icmpeq -> 361
      //   146: iload #5
      //   148: bipush #18
      //   150: if_icmpeq -> 283
      //   153: iload #5
      //   155: bipush #26
      //   157: if_icmpeq -> 205
      //   160: iload #5
      //   162: bipush #32
      //   164: if_icmpeq -> 183
      //   167: aload_0
      //   168: iload #5
      //   170: aload_2
      //   171: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   174: ifne -> 123
      //   177: iconst_1
      //   178: istore #4
      //   180: goto -> 123
      //   183: aload_0
      //   184: aload_0
      //   185: getfield bitField0_ : I
      //   188: bipush #8
      //   190: ior
      //   191: putfield bitField0_ : I
      //   194: aload_0
      //   195: aload_2
      //   196: invokevirtual readBool : ()Z
      //   199: putfield newAudience_ : Z
      //   202: goto -> 123
      //   205: aload_0
      //   206: getfield bitField0_ : I
      //   209: iconst_4
      //   210: iand
      //   211: iconst_4
      //   212: if_icmpne -> 229
      //   215: aload_0
      //   216: getfield previousData_ : Lanalytics_collection/GmpMeasurement$ResultData;
      //   219: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   222: checkcast analytics_collection/GmpMeasurement$ResultData$Builder
      //   225: astore_1
      //   226: goto -> 231
      //   229: aconst_null
      //   230: astore_1
      //   231: aload_0
      //   232: aload_2
      //   233: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   236: aload_3
      //   237: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   240: checkcast analytics_collection/GmpMeasurement$ResultData
      //   243: putfield previousData_ : Lanalytics_collection/GmpMeasurement$ResultData;
      //   246: aload_1
      //   247: ifnull -> 270
      //   250: aload_1
      //   251: aload_0
      //   252: getfield previousData_ : Lanalytics_collection/GmpMeasurement$ResultData;
      //   255: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   258: pop
      //   259: aload_0
      //   260: aload_1
      //   261: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   264: checkcast analytics_collection/GmpMeasurement$ResultData
      //   267: putfield previousData_ : Lanalytics_collection/GmpMeasurement$ResultData;
      //   270: aload_0
      //   271: aload_0
      //   272: getfield bitField0_ : I
      //   275: iconst_4
      //   276: ior
      //   277: putfield bitField0_ : I
      //   280: goto -> 123
      //   283: aload_0
      //   284: getfield bitField0_ : I
      //   287: iconst_2
      //   288: iand
      //   289: iconst_2
      //   290: if_icmpne -> 307
      //   293: aload_0
      //   294: getfield currentData_ : Lanalytics_collection/GmpMeasurement$ResultData;
      //   297: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   300: checkcast analytics_collection/GmpMeasurement$ResultData$Builder
      //   303: astore_1
      //   304: goto -> 309
      //   307: aconst_null
      //   308: astore_1
      //   309: aload_0
      //   310: aload_2
      //   311: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   314: aload_3
      //   315: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   318: checkcast analytics_collection/GmpMeasurement$ResultData
      //   321: putfield currentData_ : Lanalytics_collection/GmpMeasurement$ResultData;
      //   324: aload_1
      //   325: ifnull -> 348
      //   328: aload_1
      //   329: aload_0
      //   330: getfield currentData_ : Lanalytics_collection/GmpMeasurement$ResultData;
      //   333: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   336: pop
      //   337: aload_0
      //   338: aload_1
      //   339: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   342: checkcast analytics_collection/GmpMeasurement$ResultData
      //   345: putfield currentData_ : Lanalytics_collection/GmpMeasurement$ResultData;
      //   348: aload_0
      //   349: aload_0
      //   350: getfield bitField0_ : I
      //   353: iconst_2
      //   354: ior
      //   355: putfield bitField0_ : I
      //   358: goto -> 123
      //   361: aload_0
      //   362: aload_0
      //   363: getfield bitField0_ : I
      //   366: iconst_1
      //   367: ior
      //   368: putfield bitField0_ : I
      //   371: aload_0
      //   372: aload_2
      //   373: invokevirtual readInt32 : ()I
      //   376: putfield audienceId_ : I
      //   379: goto -> 123
      //   382: iconst_1
      //   383: istore #4
      //   385: goto -> 123
      //   388: astore_1
      //   389: goto -> 436
      //   392: astore_1
      //   393: new java/lang/RuntimeException
      //   396: astore_2
      //   397: new com/google/protobuf/InvalidProtocolBufferException
      //   400: astore_3
      //   401: aload_3
      //   402: aload_1
      //   403: invokevirtual getMessage : ()Ljava/lang/String;
      //   406: invokespecial <init> : (Ljava/lang/String;)V
      //   409: aload_2
      //   410: aload_3
      //   411: aload_0
      //   412: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   415: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   418: aload_2
      //   419: athrow
      //   420: astore_1
      //   421: new java/lang/RuntimeException
      //   424: astore_2
      //   425: aload_2
      //   426: aload_1
      //   427: aload_0
      //   428: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   431: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   434: aload_2
      //   435: athrow
      //   436: aload_1
      //   437: athrow
      //   438: getstatic analytics_collection/GmpMeasurement$AudienceLeafFilterResult.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$AudienceLeafFilterResult;
      //   441: areturn
      //   442: aload_2
      //   443: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   446: astore_1
      //   447: aload_3
      //   448: checkcast analytics_collection/GmpMeasurement$AudienceLeafFilterResult
      //   451: astore_2
      //   452: aload_0
      //   453: aload_1
      //   454: aload_0
      //   455: invokevirtual hasAudienceId : ()Z
      //   458: aload_0
      //   459: getfield audienceId_ : I
      //   462: aload_2
      //   463: invokevirtual hasAudienceId : ()Z
      //   466: aload_2
      //   467: getfield audienceId_ : I
      //   470: invokeinterface visitInt : (ZIZI)I
      //   475: putfield audienceId_ : I
      //   478: aload_0
      //   479: aload_1
      //   480: aload_0
      //   481: getfield currentData_ : Lanalytics_collection/GmpMeasurement$ResultData;
      //   484: aload_2
      //   485: getfield currentData_ : Lanalytics_collection/GmpMeasurement$ResultData;
      //   488: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   493: checkcast analytics_collection/GmpMeasurement$ResultData
      //   496: putfield currentData_ : Lanalytics_collection/GmpMeasurement$ResultData;
      //   499: aload_0
      //   500: aload_1
      //   501: aload_0
      //   502: getfield previousData_ : Lanalytics_collection/GmpMeasurement$ResultData;
      //   505: aload_2
      //   506: getfield previousData_ : Lanalytics_collection/GmpMeasurement$ResultData;
      //   509: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   514: checkcast analytics_collection/GmpMeasurement$ResultData
      //   517: putfield previousData_ : Lanalytics_collection/GmpMeasurement$ResultData;
      //   520: aload_0
      //   521: aload_1
      //   522: aload_0
      //   523: invokevirtual hasNewAudience : ()Z
      //   526: aload_0
      //   527: getfield newAudience_ : Z
      //   530: aload_2
      //   531: invokevirtual hasNewAudience : ()Z
      //   534: aload_2
      //   535: getfield newAudience_ : Z
      //   538: invokeinterface visitBoolean : (ZZZZ)Z
      //   543: putfield newAudience_ : Z
      //   546: aload_1
      //   547: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   550: if_acmpne -> 566
      //   553: aload_0
      //   554: aload_0
      //   555: getfield bitField0_ : I
      //   558: aload_2
      //   559: getfield bitField0_ : I
      //   562: ior
      //   563: putfield bitField0_ : I
      //   566: aload_0
      //   567: areturn
      //   568: new analytics_collection/GmpMeasurement$AudienceLeafFilterResult$Builder
      //   571: dup
      //   572: aconst_null
      //   573: invokespecial <init> : (Lanalytics_collection/GmpMeasurement$1;)V
      //   576: areturn
      //   577: aconst_null
      //   578: areturn
      //   579: getstatic analytics_collection/GmpMeasurement$AudienceLeafFilterResult.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$AudienceLeafFilterResult;
      //   582: areturn
      //   583: new analytics_collection/GmpMeasurement$AudienceLeafFilterResult
      //   586: dup
      //   587: invokespecial <init> : ()V
      //   590: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	420	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	392	java/io/IOException
      //   128	134	388	finally
      //   167	177	420	com/google/protobuf/InvalidProtocolBufferException
      //   167	177	392	java/io/IOException
      //   167	177	388	finally
      //   183	202	420	com/google/protobuf/InvalidProtocolBufferException
      //   183	202	392	java/io/IOException
      //   183	202	388	finally
      //   205	226	420	com/google/protobuf/InvalidProtocolBufferException
      //   205	226	392	java/io/IOException
      //   205	226	388	finally
      //   231	246	420	com/google/protobuf/InvalidProtocolBufferException
      //   231	246	392	java/io/IOException
      //   231	246	388	finally
      //   250	270	420	com/google/protobuf/InvalidProtocolBufferException
      //   250	270	392	java/io/IOException
      //   250	270	388	finally
      //   270	280	420	com/google/protobuf/InvalidProtocolBufferException
      //   270	280	392	java/io/IOException
      //   270	280	388	finally
      //   283	304	420	com/google/protobuf/InvalidProtocolBufferException
      //   283	304	392	java/io/IOException
      //   283	304	388	finally
      //   309	324	420	com/google/protobuf/InvalidProtocolBufferException
      //   309	324	392	java/io/IOException
      //   309	324	388	finally
      //   328	348	420	com/google/protobuf/InvalidProtocolBufferException
      //   328	348	392	java/io/IOException
      //   328	348	388	finally
      //   348	358	420	com/google/protobuf/InvalidProtocolBufferException
      //   348	358	392	java/io/IOException
      //   348	358	388	finally
      //   361	379	420	com/google/protobuf/InvalidProtocolBufferException
      //   361	379	392	java/io/IOException
      //   361	379	388	finally
      //   393	420	388	finally
      //   421	436	388	finally
    }
    
    public int getAudienceId() {
      return this.audienceId_;
    }
    
    public GmpMeasurement.ResultData getCurrentData() {
      GmpMeasurement.ResultData resultData1 = this.currentData_;
      GmpMeasurement.ResultData resultData2 = resultData1;
      if (resultData1 == null)
        resultData2 = GmpMeasurement.ResultData.getDefaultInstance(); 
      return resultData2;
    }
    
    public boolean getNewAudience() {
      return this.newAudience_;
    }
    
    public GmpMeasurement.ResultData getPreviousData() {
      GmpMeasurement.ResultData resultData1 = this.previousData_;
      GmpMeasurement.ResultData resultData2 = resultData1;
      if (resultData1 == null)
        resultData2 = GmpMeasurement.ResultData.getDefaultInstance(); 
      return resultData2;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if ((this.bitField0_ & 0x1) == 1)
        j = 0 + CodedOutputStream.computeInt32Size(1, this.audienceId_); 
      i = j;
      if ((this.bitField0_ & 0x2) == 2)
        i = j + CodedOutputStream.computeMessageSize(2, (MessageLite)getCurrentData()); 
      j = i;
      if ((this.bitField0_ & 0x4) == 4)
        j = i + CodedOutputStream.computeMessageSize(3, (MessageLite)getPreviousData()); 
      i = j;
      if ((this.bitField0_ & 0x8) == 8)
        i = j + CodedOutputStream.computeBoolSize(4, this.newAudience_); 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasAudienceId() {
      int i = this.bitField0_;
      boolean bool = true;
      if ((i & 0x1) != 1)
        bool = false; 
      return bool;
    }
    
    public boolean hasCurrentData() {
      boolean bool;
      if ((this.bitField0_ & 0x2) == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasNewAudience() {
      boolean bool;
      if ((this.bitField0_ & 0x8) == 8) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasPreviousData() {
      boolean bool;
      if ((this.bitField0_ & 0x4) == 4) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if ((this.bitField0_ & 0x1) == 1)
        param1CodedOutputStream.writeInt32(1, this.audienceId_); 
      if ((this.bitField0_ & 0x2) == 2)
        param1CodedOutputStream.writeMessage(2, (MessageLite)getCurrentData()); 
      if ((this.bitField0_ & 0x4) == 4)
        param1CodedOutputStream.writeMessage(3, (MessageLite)getPreviousData()); 
      if ((this.bitField0_ & 0x8) == 8)
        param1CodedOutputStream.writeBool(4, this.newAudience_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AudienceLeafFilterResult, Builder> implements GmpMeasurement.AudienceLeafFilterResultOrBuilder {
      private Builder() {
        super(GmpMeasurement.AudienceLeafFilterResult.DEFAULT_INSTANCE);
      }
      
      public Builder clearAudienceId() {
        copyOnWrite();
        ((GmpMeasurement.AudienceLeafFilterResult)this.instance).clearAudienceId();
        return this;
      }
      
      public Builder clearCurrentData() {
        copyOnWrite();
        ((GmpMeasurement.AudienceLeafFilterResult)this.instance).clearCurrentData();
        return this;
      }
      
      public Builder clearNewAudience() {
        copyOnWrite();
        ((GmpMeasurement.AudienceLeafFilterResult)this.instance).clearNewAudience();
        return this;
      }
      
      public Builder clearPreviousData() {
        copyOnWrite();
        ((GmpMeasurement.AudienceLeafFilterResult)this.instance).clearPreviousData();
        return this;
      }
      
      public int getAudienceId() {
        return ((GmpMeasurement.AudienceLeafFilterResult)this.instance).getAudienceId();
      }
      
      public GmpMeasurement.ResultData getCurrentData() {
        return ((GmpMeasurement.AudienceLeafFilterResult)this.instance).getCurrentData();
      }
      
      public boolean getNewAudience() {
        return ((GmpMeasurement.AudienceLeafFilterResult)this.instance).getNewAudience();
      }
      
      public GmpMeasurement.ResultData getPreviousData() {
        return ((GmpMeasurement.AudienceLeafFilterResult)this.instance).getPreviousData();
      }
      
      public boolean hasAudienceId() {
        return ((GmpMeasurement.AudienceLeafFilterResult)this.instance).hasAudienceId();
      }
      
      public boolean hasCurrentData() {
        return ((GmpMeasurement.AudienceLeafFilterResult)this.instance).hasCurrentData();
      }
      
      public boolean hasNewAudience() {
        return ((GmpMeasurement.AudienceLeafFilterResult)this.instance).hasNewAudience();
      }
      
      public boolean hasPreviousData() {
        return ((GmpMeasurement.AudienceLeafFilterResult)this.instance).hasPreviousData();
      }
      
      public Builder mergeCurrentData(GmpMeasurement.ResultData param2ResultData) {
        copyOnWrite();
        ((GmpMeasurement.AudienceLeafFilterResult)this.instance).mergeCurrentData(param2ResultData);
        return this;
      }
      
      public Builder mergePreviousData(GmpMeasurement.ResultData param2ResultData) {
        copyOnWrite();
        ((GmpMeasurement.AudienceLeafFilterResult)this.instance).mergePreviousData(param2ResultData);
        return this;
      }
      
      public Builder setAudienceId(int param2Int) {
        copyOnWrite();
        ((GmpMeasurement.AudienceLeafFilterResult)this.instance).setAudienceId(param2Int);
        return this;
      }
      
      public Builder setCurrentData(GmpMeasurement.ResultData.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.AudienceLeafFilterResult)this.instance).setCurrentData(param2Builder);
        return this;
      }
      
      public Builder setCurrentData(GmpMeasurement.ResultData param2ResultData) {
        copyOnWrite();
        ((GmpMeasurement.AudienceLeafFilterResult)this.instance).setCurrentData(param2ResultData);
        return this;
      }
      
      public Builder setNewAudience(boolean param2Boolean) {
        copyOnWrite();
        ((GmpMeasurement.AudienceLeafFilterResult)this.instance).setNewAudience(param2Boolean);
        return this;
      }
      
      public Builder setPreviousData(GmpMeasurement.ResultData.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.AudienceLeafFilterResult)this.instance).setPreviousData(param2Builder);
        return this;
      }
      
      public Builder setPreviousData(GmpMeasurement.ResultData param2ResultData) {
        copyOnWrite();
        ((GmpMeasurement.AudienceLeafFilterResult)this.instance).setPreviousData(param2ResultData);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<AudienceLeafFilterResult, AudienceLeafFilterResult.Builder> implements AudienceLeafFilterResultOrBuilder {
    private Builder() {
      super(GmpMeasurement.AudienceLeafFilterResult.DEFAULT_INSTANCE);
    }
    
    public Builder clearAudienceId() {
      copyOnWrite();
      ((GmpMeasurement.AudienceLeafFilterResult)this.instance).clearAudienceId();
      return this;
    }
    
    public Builder clearCurrentData() {
      copyOnWrite();
      ((GmpMeasurement.AudienceLeafFilterResult)this.instance).clearCurrentData();
      return this;
    }
    
    public Builder clearNewAudience() {
      copyOnWrite();
      ((GmpMeasurement.AudienceLeafFilterResult)this.instance).clearNewAudience();
      return this;
    }
    
    public Builder clearPreviousData() {
      copyOnWrite();
      ((GmpMeasurement.AudienceLeafFilterResult)this.instance).clearPreviousData();
      return this;
    }
    
    public int getAudienceId() {
      return ((GmpMeasurement.AudienceLeafFilterResult)this.instance).getAudienceId();
    }
    
    public GmpMeasurement.ResultData getCurrentData() {
      return ((GmpMeasurement.AudienceLeafFilterResult)this.instance).getCurrentData();
    }
    
    public boolean getNewAudience() {
      return ((GmpMeasurement.AudienceLeafFilterResult)this.instance).getNewAudience();
    }
    
    public GmpMeasurement.ResultData getPreviousData() {
      return ((GmpMeasurement.AudienceLeafFilterResult)this.instance).getPreviousData();
    }
    
    public boolean hasAudienceId() {
      return ((GmpMeasurement.AudienceLeafFilterResult)this.instance).hasAudienceId();
    }
    
    public boolean hasCurrentData() {
      return ((GmpMeasurement.AudienceLeafFilterResult)this.instance).hasCurrentData();
    }
    
    public boolean hasNewAudience() {
      return ((GmpMeasurement.AudienceLeafFilterResult)this.instance).hasNewAudience();
    }
    
    public boolean hasPreviousData() {
      return ((GmpMeasurement.AudienceLeafFilterResult)this.instance).hasPreviousData();
    }
    
    public Builder mergeCurrentData(GmpMeasurement.ResultData param1ResultData) {
      copyOnWrite();
      ((GmpMeasurement.AudienceLeafFilterResult)this.instance).mergeCurrentData(param1ResultData);
      return this;
    }
    
    public Builder mergePreviousData(GmpMeasurement.ResultData param1ResultData) {
      copyOnWrite();
      ((GmpMeasurement.AudienceLeafFilterResult)this.instance).mergePreviousData(param1ResultData);
      return this;
    }
    
    public Builder setAudienceId(int param1Int) {
      copyOnWrite();
      ((GmpMeasurement.AudienceLeafFilterResult)this.instance).setAudienceId(param1Int);
      return this;
    }
    
    public Builder setCurrentData(GmpMeasurement.ResultData.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.AudienceLeafFilterResult)this.instance).setCurrentData(param1Builder);
      return this;
    }
    
    public Builder setCurrentData(GmpMeasurement.ResultData param1ResultData) {
      copyOnWrite();
      ((GmpMeasurement.AudienceLeafFilterResult)this.instance).setCurrentData(param1ResultData);
      return this;
    }
    
    public Builder setNewAudience(boolean param1Boolean) {
      copyOnWrite();
      ((GmpMeasurement.AudienceLeafFilterResult)this.instance).setNewAudience(param1Boolean);
      return this;
    }
    
    public Builder setPreviousData(GmpMeasurement.ResultData.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.AudienceLeafFilterResult)this.instance).setPreviousData(param1Builder);
      return this;
    }
    
    public Builder setPreviousData(GmpMeasurement.ResultData param1ResultData) {
      copyOnWrite();
      ((GmpMeasurement.AudienceLeafFilterResult)this.instance).setPreviousData(param1ResultData);
      return this;
    }
  }
  
  public static interface AudienceLeafFilterResultOrBuilder extends MessageLiteOrBuilder {
    int getAudienceId();
    
    GmpMeasurement.ResultData getCurrentData();
    
    boolean getNewAudience();
    
    GmpMeasurement.ResultData getPreviousData();
    
    boolean hasAudienceId();
    
    boolean hasCurrentData();
    
    boolean hasNewAudience();
    
    boolean hasPreviousData();
  }
  
  public static final class DynamicFilterResultTimestamp extends GeneratedMessageLite<DynamicFilterResultTimestamp, DynamicFilterResultTimestamp.Builder> implements DynamicFilterResultTimestampOrBuilder {
    private static final DynamicFilterResultTimestamp DEFAULT_INSTANCE = new DynamicFilterResultTimestamp();
    
    public static final int EVAL_TIMESTAMP_FIELD_NUMBER = 2;
    
    public static final int INDEX_FIELD_NUMBER = 1;
    
    private static volatile Parser<DynamicFilterResultTimestamp> PARSER;
    
    private int bitField0_;
    
    private long evalTimestamp_;
    
    private int index_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearEvalTimestamp() {
      this.bitField0_ &= 0xFFFFFFFD;
      this.evalTimestamp_ = 0L;
    }
    
    private void clearIndex() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.index_ = 0;
    }
    
    public static DynamicFilterResultTimestamp getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(DynamicFilterResultTimestamp param1DynamicFilterResultTimestamp) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1DynamicFilterResultTimestamp);
    }
    
    public static DynamicFilterResultTimestamp parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (DynamicFilterResultTimestamp)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static DynamicFilterResultTimestamp parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (DynamicFilterResultTimestamp)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static DynamicFilterResultTimestamp parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (DynamicFilterResultTimestamp)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static DynamicFilterResultTimestamp parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (DynamicFilterResultTimestamp)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static DynamicFilterResultTimestamp parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (DynamicFilterResultTimestamp)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static DynamicFilterResultTimestamp parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (DynamicFilterResultTimestamp)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static DynamicFilterResultTimestamp parseFrom(InputStream param1InputStream) throws IOException {
      return (DynamicFilterResultTimestamp)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static DynamicFilterResultTimestamp parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (DynamicFilterResultTimestamp)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static DynamicFilterResultTimestamp parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (DynamicFilterResultTimestamp)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static DynamicFilterResultTimestamp parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (DynamicFilterResultTimestamp)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<DynamicFilterResultTimestamp> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setEvalTimestamp(long param1Long) {
      this.bitField0_ |= 0x2;
      this.evalTimestamp_ = param1Long;
    }
    
    private void setIndex(int param1Int) {
      this.bitField0_ |= 0x1;
      this.index_ = param1Int;
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic analytics_collection/GmpMeasurement$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 370, 2 -> 366, 3 -> 364, 4 -> 355, 5 -> 271, 6 -> 110, 7 -> 267, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic analytics_collection/GmpMeasurement$DynamicFilterResultTimestamp.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc analytics_collection/GmpMeasurement$DynamicFilterResultTimestamp
      //   72: monitorenter
      //   73: getstatic analytics_collection/GmpMeasurement$DynamicFilterResultTimestamp.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic analytics_collection/GmpMeasurement$DynamicFilterResultTimestamp.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$DynamicFilterResultTimestamp;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic analytics_collection/GmpMeasurement$DynamicFilterResultTimestamp.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc analytics_collection/GmpMeasurement$DynamicFilterResultTimestamp
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc analytics_collection/GmpMeasurement$DynamicFilterResultTimestamp
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic analytics_collection/GmpMeasurement$DynamicFilterResultTimestamp.PARSER : Lcom/google/protobuf/Parser;
      //   109: areturn
      //   110: aload_2
      //   111: checkcast com/google/protobuf/CodedInputStream
      //   114: astore_1
      //   115: aload_3
      //   116: checkcast com/google/protobuf/ExtensionRegistryLite
      //   119: astore_2
      //   120: iconst_0
      //   121: istore #4
      //   123: iload #4
      //   125: ifne -> 267
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 211
      //   139: iload #5
      //   141: bipush #8
      //   143: if_icmpeq -> 190
      //   146: iload #5
      //   148: bipush #16
      //   150: if_icmpeq -> 169
      //   153: aload_0
      //   154: iload #5
      //   156: aload_1
      //   157: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   160: ifne -> 123
      //   163: iconst_1
      //   164: istore #4
      //   166: goto -> 123
      //   169: aload_0
      //   170: aload_0
      //   171: getfield bitField0_ : I
      //   174: iconst_2
      //   175: ior
      //   176: putfield bitField0_ : I
      //   179: aload_0
      //   180: aload_1
      //   181: invokevirtual readInt64 : ()J
      //   184: putfield evalTimestamp_ : J
      //   187: goto -> 123
      //   190: aload_0
      //   191: aload_0
      //   192: getfield bitField0_ : I
      //   195: iconst_1
      //   196: ior
      //   197: putfield bitField0_ : I
      //   200: aload_0
      //   201: aload_1
      //   202: invokevirtual readInt32 : ()I
      //   205: putfield index_ : I
      //   208: goto -> 123
      //   211: iconst_1
      //   212: istore #4
      //   214: goto -> 123
      //   217: astore_1
      //   218: goto -> 265
      //   221: astore_2
      //   222: new java/lang/RuntimeException
      //   225: astore_3
      //   226: new com/google/protobuf/InvalidProtocolBufferException
      //   229: astore_1
      //   230: aload_1
      //   231: aload_2
      //   232: invokevirtual getMessage : ()Ljava/lang/String;
      //   235: invokespecial <init> : (Ljava/lang/String;)V
      //   238: aload_3
      //   239: aload_1
      //   240: aload_0
      //   241: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   244: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   247: aload_3
      //   248: athrow
      //   249: astore_2
      //   250: new java/lang/RuntimeException
      //   253: astore_1
      //   254: aload_1
      //   255: aload_2
      //   256: aload_0
      //   257: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   260: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   263: aload_1
      //   264: athrow
      //   265: aload_1
      //   266: athrow
      //   267: getstatic analytics_collection/GmpMeasurement$DynamicFilterResultTimestamp.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$DynamicFilterResultTimestamp;
      //   270: areturn
      //   271: aload_2
      //   272: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   275: astore_1
      //   276: aload_3
      //   277: checkcast analytics_collection/GmpMeasurement$DynamicFilterResultTimestamp
      //   280: astore_2
      //   281: aload_0
      //   282: aload_1
      //   283: aload_0
      //   284: invokevirtual hasIndex : ()Z
      //   287: aload_0
      //   288: getfield index_ : I
      //   291: aload_2
      //   292: invokevirtual hasIndex : ()Z
      //   295: aload_2
      //   296: getfield index_ : I
      //   299: invokeinterface visitInt : (ZIZI)I
      //   304: putfield index_ : I
      //   307: aload_0
      //   308: aload_1
      //   309: aload_0
      //   310: invokevirtual hasEvalTimestamp : ()Z
      //   313: aload_0
      //   314: getfield evalTimestamp_ : J
      //   317: aload_2
      //   318: invokevirtual hasEvalTimestamp : ()Z
      //   321: aload_2
      //   322: getfield evalTimestamp_ : J
      //   325: invokeinterface visitLong : (ZJZJ)J
      //   330: putfield evalTimestamp_ : J
      //   333: aload_1
      //   334: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   337: if_acmpne -> 353
      //   340: aload_0
      //   341: aload_0
      //   342: getfield bitField0_ : I
      //   345: aload_2
      //   346: getfield bitField0_ : I
      //   349: ior
      //   350: putfield bitField0_ : I
      //   353: aload_0
      //   354: areturn
      //   355: new analytics_collection/GmpMeasurement$DynamicFilterResultTimestamp$Builder
      //   358: dup
      //   359: aconst_null
      //   360: invokespecial <init> : (Lanalytics_collection/GmpMeasurement$1;)V
      //   363: areturn
      //   364: aconst_null
      //   365: areturn
      //   366: getstatic analytics_collection/GmpMeasurement$DynamicFilterResultTimestamp.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$DynamicFilterResultTimestamp;
      //   369: areturn
      //   370: new analytics_collection/GmpMeasurement$DynamicFilterResultTimestamp
      //   373: dup
      //   374: invokespecial <init> : ()V
      //   377: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	249	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	221	java/io/IOException
      //   128	134	217	finally
      //   153	163	249	com/google/protobuf/InvalidProtocolBufferException
      //   153	163	221	java/io/IOException
      //   153	163	217	finally
      //   169	187	249	com/google/protobuf/InvalidProtocolBufferException
      //   169	187	221	java/io/IOException
      //   169	187	217	finally
      //   190	208	249	com/google/protobuf/InvalidProtocolBufferException
      //   190	208	221	java/io/IOException
      //   190	208	217	finally
      //   222	249	217	finally
      //   250	265	217	finally
    }
    
    public long getEvalTimestamp() {
      return this.evalTimestamp_;
    }
    
    public int getIndex() {
      return this.index_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if ((this.bitField0_ & 0x1) == 1)
        i = 0 + CodedOutputStream.computeInt32Size(1, this.index_); 
      int j = i;
      if ((this.bitField0_ & 0x2) == 2)
        j = i + CodedOutputStream.computeInt64Size(2, this.evalTimestamp_); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasEvalTimestamp() {
      boolean bool;
      if ((this.bitField0_ & 0x2) == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasIndex() {
      int i = this.bitField0_;
      boolean bool = true;
      if ((i & 0x1) != 1)
        bool = false; 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if ((this.bitField0_ & 0x1) == 1)
        param1CodedOutputStream.writeInt32(1, this.index_); 
      if ((this.bitField0_ & 0x2) == 2)
        param1CodedOutputStream.writeInt64(2, this.evalTimestamp_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<DynamicFilterResultTimestamp, Builder> implements GmpMeasurement.DynamicFilterResultTimestampOrBuilder {
      private Builder() {
        super(GmpMeasurement.DynamicFilterResultTimestamp.DEFAULT_INSTANCE);
      }
      
      public Builder clearEvalTimestamp() {
        copyOnWrite();
        ((GmpMeasurement.DynamicFilterResultTimestamp)this.instance).clearEvalTimestamp();
        return this;
      }
      
      public Builder clearIndex() {
        copyOnWrite();
        ((GmpMeasurement.DynamicFilterResultTimestamp)this.instance).clearIndex();
        return this;
      }
      
      public long getEvalTimestamp() {
        return ((GmpMeasurement.DynamicFilterResultTimestamp)this.instance).getEvalTimestamp();
      }
      
      public int getIndex() {
        return ((GmpMeasurement.DynamicFilterResultTimestamp)this.instance).getIndex();
      }
      
      public boolean hasEvalTimestamp() {
        return ((GmpMeasurement.DynamicFilterResultTimestamp)this.instance).hasEvalTimestamp();
      }
      
      public boolean hasIndex() {
        return ((GmpMeasurement.DynamicFilterResultTimestamp)this.instance).hasIndex();
      }
      
      public Builder setEvalTimestamp(long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.DynamicFilterResultTimestamp)this.instance).setEvalTimestamp(param2Long);
        return this;
      }
      
      public Builder setIndex(int param2Int) {
        copyOnWrite();
        ((GmpMeasurement.DynamicFilterResultTimestamp)this.instance).setIndex(param2Int);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<DynamicFilterResultTimestamp, DynamicFilterResultTimestamp.Builder> implements DynamicFilterResultTimestampOrBuilder {
    private Builder() {
      super(GmpMeasurement.DynamicFilterResultTimestamp.DEFAULT_INSTANCE);
    }
    
    public Builder clearEvalTimestamp() {
      copyOnWrite();
      ((GmpMeasurement.DynamicFilterResultTimestamp)this.instance).clearEvalTimestamp();
      return this;
    }
    
    public Builder clearIndex() {
      copyOnWrite();
      ((GmpMeasurement.DynamicFilterResultTimestamp)this.instance).clearIndex();
      return this;
    }
    
    public long getEvalTimestamp() {
      return ((GmpMeasurement.DynamicFilterResultTimestamp)this.instance).getEvalTimestamp();
    }
    
    public int getIndex() {
      return ((GmpMeasurement.DynamicFilterResultTimestamp)this.instance).getIndex();
    }
    
    public boolean hasEvalTimestamp() {
      return ((GmpMeasurement.DynamicFilterResultTimestamp)this.instance).hasEvalTimestamp();
    }
    
    public boolean hasIndex() {
      return ((GmpMeasurement.DynamicFilterResultTimestamp)this.instance).hasIndex();
    }
    
    public Builder setEvalTimestamp(long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.DynamicFilterResultTimestamp)this.instance).setEvalTimestamp(param1Long);
      return this;
    }
    
    public Builder setIndex(int param1Int) {
      copyOnWrite();
      ((GmpMeasurement.DynamicFilterResultTimestamp)this.instance).setIndex(param1Int);
      return this;
    }
  }
  
  public static interface DynamicFilterResultTimestampOrBuilder extends MessageLiteOrBuilder {
    long getEvalTimestamp();
    
    int getIndex();
    
    boolean hasEvalTimestamp();
    
    boolean hasIndex();
  }
  
  public static final class Event extends GeneratedMessageLite<Event, Event.Builder> implements EventOrBuilder {
    public static final int COUNT_FIELD_NUMBER = 5;
    
    private static final Event DEFAULT_INSTANCE = new Event();
    
    public static final int NAME_FIELD_NUMBER = 2;
    
    public static final int PARAMS_FIELD_NUMBER = 1;
    
    private static volatile Parser<Event> PARSER;
    
    public static final int PREVIOUS_TIMESTAMP_MILLIS_FIELD_NUMBER = 4;
    
    public static final int TIMESTAMP_MILLIS_FIELD_NUMBER = 3;
    
    private int bitField0_;
    
    private int count_;
    
    private String name_ = "";
    
    private Internal.ProtobufList<GmpMeasurement.EventParam> params_ = emptyProtobufList();
    
    private long previousTimestampMillis_;
    
    private long timestampMillis_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllParams(Iterable<? extends GmpMeasurement.EventParam> param1Iterable) {
      ensureParamsIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.params_);
    }
    
    private void addParams(int param1Int, GmpMeasurement.EventParam.Builder param1Builder) {
      ensureParamsIsMutable();
      this.params_.add(param1Int, param1Builder.build());
    }
    
    private void addParams(int param1Int, GmpMeasurement.EventParam param1EventParam) {
      if (param1EventParam != null) {
        ensureParamsIsMutable();
        this.params_.add(param1Int, param1EventParam);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addParams(GmpMeasurement.EventParam.Builder param1Builder) {
      ensureParamsIsMutable();
      this.params_.add(param1Builder.build());
    }
    
    private void addParams(GmpMeasurement.EventParam param1EventParam) {
      if (param1EventParam != null) {
        ensureParamsIsMutable();
        this.params_.add(param1EventParam);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearCount() {
      this.bitField0_ &= 0xFFFFFFF7;
      this.count_ = 0;
    }
    
    private void clearName() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.name_ = getDefaultInstance().getName();
    }
    
    private void clearParams() {
      this.params_ = emptyProtobufList();
    }
    
    private void clearPreviousTimestampMillis() {
      this.bitField0_ &= 0xFFFFFFFB;
      this.previousTimestampMillis_ = 0L;
    }
    
    private void clearTimestampMillis() {
      this.bitField0_ &= 0xFFFFFFFD;
      this.timestampMillis_ = 0L;
    }
    
    private void ensureParamsIsMutable() {
      if (!this.params_.isModifiable())
        this.params_ = GeneratedMessageLite.mutableCopy(this.params_); 
    }
    
    public static Event getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Event param1Event) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1Event);
    }
    
    public static Event parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Event)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Event parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Event)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Event parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Event)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static Event parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Event)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Event parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Event)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static Event parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Event)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Event parseFrom(InputStream param1InputStream) throws IOException {
      return (Event)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Event parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Event)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Event parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Event)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static Event parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Event)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Event> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeParams(int param1Int) {
      ensureParamsIsMutable();
      this.params_.remove(param1Int);
    }
    
    private void setCount(int param1Int) {
      this.bitField0_ |= 0x8;
      this.count_ = param1Int;
    }
    
    private void setName(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x1;
        this.name_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x1;
        this.name_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setParams(int param1Int, GmpMeasurement.EventParam.Builder param1Builder) {
      ensureParamsIsMutable();
      this.params_.set(param1Int, param1Builder.build());
    }
    
    private void setParams(int param1Int, GmpMeasurement.EventParam param1EventParam) {
      if (param1EventParam != null) {
        ensureParamsIsMutable();
        this.params_.set(param1Int, param1EventParam);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setPreviousTimestampMillis(long param1Long) {
      this.bitField0_ |= 0x4;
      this.previousTimestampMillis_ = param1Long;
    }
    
    private void setTimestampMillis(long param1Long) {
      this.bitField0_ |= 0x2;
      this.timestampMillis_ = param1Long;
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic analytics_collection/GmpMeasurement$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 562, 2 -> 558, 3 -> 547, 4 -> 538, 5 -> 384, 6 -> 110, 7 -> 380, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic analytics_collection/GmpMeasurement$Event.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc analytics_collection/GmpMeasurement$Event
      //   72: monitorenter
      //   73: getstatic analytics_collection/GmpMeasurement$Event.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic analytics_collection/GmpMeasurement$Event.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$Event;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic analytics_collection/GmpMeasurement$Event.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc analytics_collection/GmpMeasurement$Event
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc analytics_collection/GmpMeasurement$Event
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic analytics_collection/GmpMeasurement$Event.PARSER : Lcom/google/protobuf/Parser;
      //   109: areturn
      //   110: aload_2
      //   111: checkcast com/google/protobuf/CodedInputStream
      //   114: astore_1
      //   115: aload_3
      //   116: checkcast com/google/protobuf/ExtensionRegistryLite
      //   119: astore_3
      //   120: iconst_0
      //   121: istore #4
      //   123: iload #4
      //   125: ifne -> 380
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 324
      //   139: iload #5
      //   141: bipush #10
      //   143: if_icmpeq -> 277
      //   146: iload #5
      //   148: bipush #18
      //   150: if_icmpeq -> 254
      //   153: iload #5
      //   155: bipush #24
      //   157: if_icmpeq -> 233
      //   160: iload #5
      //   162: bipush #32
      //   164: if_icmpeq -> 212
      //   167: iload #5
      //   169: bipush #40
      //   171: if_icmpeq -> 190
      //   174: aload_0
      //   175: iload #5
      //   177: aload_1
      //   178: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   181: ifne -> 123
      //   184: iconst_1
      //   185: istore #4
      //   187: goto -> 123
      //   190: aload_0
      //   191: aload_0
      //   192: getfield bitField0_ : I
      //   195: bipush #8
      //   197: ior
      //   198: putfield bitField0_ : I
      //   201: aload_0
      //   202: aload_1
      //   203: invokevirtual readInt32 : ()I
      //   206: putfield count_ : I
      //   209: goto -> 123
      //   212: aload_0
      //   213: aload_0
      //   214: getfield bitField0_ : I
      //   217: iconst_4
      //   218: ior
      //   219: putfield bitField0_ : I
      //   222: aload_0
      //   223: aload_1
      //   224: invokevirtual readInt64 : ()J
      //   227: putfield previousTimestampMillis_ : J
      //   230: goto -> 123
      //   233: aload_0
      //   234: aload_0
      //   235: getfield bitField0_ : I
      //   238: iconst_2
      //   239: ior
      //   240: putfield bitField0_ : I
      //   243: aload_0
      //   244: aload_1
      //   245: invokevirtual readInt64 : ()J
      //   248: putfield timestampMillis_ : J
      //   251: goto -> 123
      //   254: aload_1
      //   255: invokevirtual readString : ()Ljava/lang/String;
      //   258: astore_2
      //   259: aload_0
      //   260: iconst_1
      //   261: aload_0
      //   262: getfield bitField0_ : I
      //   265: ior
      //   266: putfield bitField0_ : I
      //   269: aload_0
      //   270: aload_2
      //   271: putfield name_ : Ljava/lang/String;
      //   274: goto -> 123
      //   277: aload_0
      //   278: getfield params_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   281: invokeinterface isModifiable : ()Z
      //   286: ifne -> 300
      //   289: aload_0
      //   290: aload_0
      //   291: getfield params_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   294: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   297: putfield params_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   300: aload_0
      //   301: getfield params_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   304: aload_1
      //   305: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   308: aload_3
      //   309: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   312: checkcast analytics_collection/GmpMeasurement$EventParam
      //   315: invokeinterface add : (Ljava/lang/Object;)Z
      //   320: pop
      //   321: goto -> 123
      //   324: iconst_1
      //   325: istore #4
      //   327: goto -> 123
      //   330: astore_1
      //   331: goto -> 378
      //   334: astore_1
      //   335: new java/lang/RuntimeException
      //   338: astore_2
      //   339: new com/google/protobuf/InvalidProtocolBufferException
      //   342: astore_3
      //   343: aload_3
      //   344: aload_1
      //   345: invokevirtual getMessage : ()Ljava/lang/String;
      //   348: invokespecial <init> : (Ljava/lang/String;)V
      //   351: aload_2
      //   352: aload_3
      //   353: aload_0
      //   354: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   357: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   360: aload_2
      //   361: athrow
      //   362: astore_2
      //   363: new java/lang/RuntimeException
      //   366: astore_1
      //   367: aload_1
      //   368: aload_2
      //   369: aload_0
      //   370: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   373: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   376: aload_1
      //   377: athrow
      //   378: aload_1
      //   379: athrow
      //   380: getstatic analytics_collection/GmpMeasurement$Event.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$Event;
      //   383: areturn
      //   384: aload_2
      //   385: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   388: astore_1
      //   389: aload_3
      //   390: checkcast analytics_collection/GmpMeasurement$Event
      //   393: astore_2
      //   394: aload_0
      //   395: aload_1
      //   396: aload_0
      //   397: getfield params_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   400: aload_2
      //   401: getfield params_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   404: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   409: putfield params_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   412: aload_0
      //   413: aload_1
      //   414: aload_0
      //   415: invokevirtual hasName : ()Z
      //   418: aload_0
      //   419: getfield name_ : Ljava/lang/String;
      //   422: aload_2
      //   423: invokevirtual hasName : ()Z
      //   426: aload_2
      //   427: getfield name_ : Ljava/lang/String;
      //   430: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   435: putfield name_ : Ljava/lang/String;
      //   438: aload_0
      //   439: aload_1
      //   440: aload_0
      //   441: invokevirtual hasTimestampMillis : ()Z
      //   444: aload_0
      //   445: getfield timestampMillis_ : J
      //   448: aload_2
      //   449: invokevirtual hasTimestampMillis : ()Z
      //   452: aload_2
      //   453: getfield timestampMillis_ : J
      //   456: invokeinterface visitLong : (ZJZJ)J
      //   461: putfield timestampMillis_ : J
      //   464: aload_0
      //   465: aload_1
      //   466: aload_0
      //   467: invokevirtual hasPreviousTimestampMillis : ()Z
      //   470: aload_0
      //   471: getfield previousTimestampMillis_ : J
      //   474: aload_2
      //   475: invokevirtual hasPreviousTimestampMillis : ()Z
      //   478: aload_2
      //   479: getfield previousTimestampMillis_ : J
      //   482: invokeinterface visitLong : (ZJZJ)J
      //   487: putfield previousTimestampMillis_ : J
      //   490: aload_0
      //   491: aload_1
      //   492: aload_0
      //   493: invokevirtual hasCount : ()Z
      //   496: aload_0
      //   497: getfield count_ : I
      //   500: aload_2
      //   501: invokevirtual hasCount : ()Z
      //   504: aload_2
      //   505: getfield count_ : I
      //   508: invokeinterface visitInt : (ZIZI)I
      //   513: putfield count_ : I
      //   516: aload_1
      //   517: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   520: if_acmpne -> 536
      //   523: aload_0
      //   524: aload_0
      //   525: getfield bitField0_ : I
      //   528: aload_2
      //   529: getfield bitField0_ : I
      //   532: ior
      //   533: putfield bitField0_ : I
      //   536: aload_0
      //   537: areturn
      //   538: new analytics_collection/GmpMeasurement$Event$Builder
      //   541: dup
      //   542: aconst_null
      //   543: invokespecial <init> : (Lanalytics_collection/GmpMeasurement$1;)V
      //   546: areturn
      //   547: aload_0
      //   548: getfield params_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   551: invokeinterface makeImmutable : ()V
      //   556: aconst_null
      //   557: areturn
      //   558: getstatic analytics_collection/GmpMeasurement$Event.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$Event;
      //   561: areturn
      //   562: new analytics_collection/GmpMeasurement$Event
      //   565: dup
      //   566: invokespecial <init> : ()V
      //   569: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	362	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	334	java/io/IOException
      //   128	134	330	finally
      //   174	184	362	com/google/protobuf/InvalidProtocolBufferException
      //   174	184	334	java/io/IOException
      //   174	184	330	finally
      //   190	209	362	com/google/protobuf/InvalidProtocolBufferException
      //   190	209	334	java/io/IOException
      //   190	209	330	finally
      //   212	230	362	com/google/protobuf/InvalidProtocolBufferException
      //   212	230	334	java/io/IOException
      //   212	230	330	finally
      //   233	251	362	com/google/protobuf/InvalidProtocolBufferException
      //   233	251	334	java/io/IOException
      //   233	251	330	finally
      //   254	274	362	com/google/protobuf/InvalidProtocolBufferException
      //   254	274	334	java/io/IOException
      //   254	274	330	finally
      //   277	300	362	com/google/protobuf/InvalidProtocolBufferException
      //   277	300	334	java/io/IOException
      //   277	300	330	finally
      //   300	321	362	com/google/protobuf/InvalidProtocolBufferException
      //   300	321	334	java/io/IOException
      //   300	321	330	finally
      //   335	362	330	finally
      //   363	378	330	finally
    }
    
    public int getCount() {
      return this.count_;
    }
    
    public String getName() {
      return this.name_;
    }
    
    public ByteString getNameBytes() {
      return ByteString.copyFromUtf8(this.name_);
    }
    
    public GmpMeasurement.EventParam getParams(int param1Int) {
      return (GmpMeasurement.EventParam)this.params_.get(param1Int);
    }
    
    public int getParamsCount() {
      return this.params_.size();
    }
    
    public List<GmpMeasurement.EventParam> getParamsList() {
      return (List<GmpMeasurement.EventParam>)this.params_;
    }
    
    public GmpMeasurement.EventParamOrBuilder getParamsOrBuilder(int param1Int) {
      return (GmpMeasurement.EventParamOrBuilder)this.params_.get(param1Int);
    }
    
    public List<? extends GmpMeasurement.EventParamOrBuilder> getParamsOrBuilderList() {
      return (List)this.params_;
    }
    
    public long getPreviousTimestampMillis() {
      return this.previousTimestampMillis_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      int j = 0;
      i = 0;
      while (j < this.params_.size()) {
        i += CodedOutputStream.computeMessageSize(1, (MessageLite)this.params_.get(j));
        j++;
      } 
      j = i;
      if ((this.bitField0_ & 0x1) == 1)
        j = i + CodedOutputStream.computeStringSize(2, getName()); 
      i = j;
      if ((this.bitField0_ & 0x2) == 2)
        i = j + CodedOutputStream.computeInt64Size(3, this.timestampMillis_); 
      j = i;
      if ((this.bitField0_ & 0x4) == 4)
        j = i + CodedOutputStream.computeInt64Size(4, this.previousTimestampMillis_); 
      i = j;
      if ((this.bitField0_ & 0x8) == 8)
        i = j + CodedOutputStream.computeInt32Size(5, this.count_); 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public long getTimestampMillis() {
      return this.timestampMillis_;
    }
    
    public boolean hasCount() {
      boolean bool;
      if ((this.bitField0_ & 0x8) == 8) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasName() {
      int i = this.bitField0_;
      boolean bool = true;
      if ((i & 0x1) != 1)
        bool = false; 
      return bool;
    }
    
    public boolean hasPreviousTimestampMillis() {
      boolean bool;
      if ((this.bitField0_ & 0x4) == 4) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasTimestampMillis() {
      boolean bool;
      if ((this.bitField0_ & 0x2) == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      for (byte b = 0; b < this.params_.size(); b++)
        param1CodedOutputStream.writeMessage(1, (MessageLite)this.params_.get(b)); 
      if ((this.bitField0_ & 0x1) == 1)
        param1CodedOutputStream.writeString(2, getName()); 
      if ((this.bitField0_ & 0x2) == 2)
        param1CodedOutputStream.writeInt64(3, this.timestampMillis_); 
      if ((this.bitField0_ & 0x4) == 4)
        param1CodedOutputStream.writeInt64(4, this.previousTimestampMillis_); 
      if ((this.bitField0_ & 0x8) == 8)
        param1CodedOutputStream.writeInt32(5, this.count_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Event, Builder> implements GmpMeasurement.EventOrBuilder {
      private Builder() {
        super(GmpMeasurement.Event.DEFAULT_INSTANCE);
      }
      
      public Builder addAllParams(Iterable<? extends GmpMeasurement.EventParam> param2Iterable) {
        copyOnWrite();
        ((GmpMeasurement.Event)this.instance).addAllParams(param2Iterable);
        return this;
      }
      
      public Builder addParams(int param2Int, GmpMeasurement.EventParam.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.Event)this.instance).addParams(param2Int, param2Builder);
        return this;
      }
      
      public Builder addParams(int param2Int, GmpMeasurement.EventParam param2EventParam) {
        copyOnWrite();
        ((GmpMeasurement.Event)this.instance).addParams(param2Int, param2EventParam);
        return this;
      }
      
      public Builder addParams(GmpMeasurement.EventParam.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.Event)this.instance).addParams(param2Builder);
        return this;
      }
      
      public Builder addParams(GmpMeasurement.EventParam param2EventParam) {
        copyOnWrite();
        ((GmpMeasurement.Event)this.instance).addParams(param2EventParam);
        return this;
      }
      
      public Builder clearCount() {
        copyOnWrite();
        ((GmpMeasurement.Event)this.instance).clearCount();
        return this;
      }
      
      public Builder clearName() {
        copyOnWrite();
        ((GmpMeasurement.Event)this.instance).clearName();
        return this;
      }
      
      public Builder clearParams() {
        copyOnWrite();
        ((GmpMeasurement.Event)this.instance).clearParams();
        return this;
      }
      
      public Builder clearPreviousTimestampMillis() {
        copyOnWrite();
        ((GmpMeasurement.Event)this.instance).clearPreviousTimestampMillis();
        return this;
      }
      
      public Builder clearTimestampMillis() {
        copyOnWrite();
        ((GmpMeasurement.Event)this.instance).clearTimestampMillis();
        return this;
      }
      
      public int getCount() {
        return ((GmpMeasurement.Event)this.instance).getCount();
      }
      
      public String getName() {
        return ((GmpMeasurement.Event)this.instance).getName();
      }
      
      public ByteString getNameBytes() {
        return ((GmpMeasurement.Event)this.instance).getNameBytes();
      }
      
      public GmpMeasurement.EventParam getParams(int param2Int) {
        return ((GmpMeasurement.Event)this.instance).getParams(param2Int);
      }
      
      public int getParamsCount() {
        return ((GmpMeasurement.Event)this.instance).getParamsCount();
      }
      
      public List<GmpMeasurement.EventParam> getParamsList() {
        return Collections.unmodifiableList(((GmpMeasurement.Event)this.instance).getParamsList());
      }
      
      public long getPreviousTimestampMillis() {
        return ((GmpMeasurement.Event)this.instance).getPreviousTimestampMillis();
      }
      
      public long getTimestampMillis() {
        return ((GmpMeasurement.Event)this.instance).getTimestampMillis();
      }
      
      public boolean hasCount() {
        return ((GmpMeasurement.Event)this.instance).hasCount();
      }
      
      public boolean hasName() {
        return ((GmpMeasurement.Event)this.instance).hasName();
      }
      
      public boolean hasPreviousTimestampMillis() {
        return ((GmpMeasurement.Event)this.instance).hasPreviousTimestampMillis();
      }
      
      public boolean hasTimestampMillis() {
        return ((GmpMeasurement.Event)this.instance).hasTimestampMillis();
      }
      
      public Builder removeParams(int param2Int) {
        copyOnWrite();
        ((GmpMeasurement.Event)this.instance).removeParams(param2Int);
        return this;
      }
      
      public Builder setCount(int param2Int) {
        copyOnWrite();
        ((GmpMeasurement.Event)this.instance).setCount(param2Int);
        return this;
      }
      
      public Builder setName(String param2String) {
        copyOnWrite();
        ((GmpMeasurement.Event)this.instance).setName(param2String);
        return this;
      }
      
      public Builder setNameBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurement.Event)this.instance).setNameBytes(param2ByteString);
        return this;
      }
      
      public Builder setParams(int param2Int, GmpMeasurement.EventParam.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.Event)this.instance).setParams(param2Int, param2Builder);
        return this;
      }
      
      public Builder setParams(int param2Int, GmpMeasurement.EventParam param2EventParam) {
        copyOnWrite();
        ((GmpMeasurement.Event)this.instance).setParams(param2Int, param2EventParam);
        return this;
      }
      
      public Builder setPreviousTimestampMillis(long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.Event)this.instance).setPreviousTimestampMillis(param2Long);
        return this;
      }
      
      public Builder setTimestampMillis(long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.Event)this.instance).setTimestampMillis(param2Long);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Event, Event.Builder> implements EventOrBuilder {
    private Builder() {
      super(GmpMeasurement.Event.DEFAULT_INSTANCE);
    }
    
    public Builder addAllParams(Iterable<? extends GmpMeasurement.EventParam> param1Iterable) {
      copyOnWrite();
      ((GmpMeasurement.Event)this.instance).addAllParams(param1Iterable);
      return this;
    }
    
    public Builder addParams(int param1Int, GmpMeasurement.EventParam.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.Event)this.instance).addParams(param1Int, param1Builder);
      return this;
    }
    
    public Builder addParams(int param1Int, GmpMeasurement.EventParam param1EventParam) {
      copyOnWrite();
      ((GmpMeasurement.Event)this.instance).addParams(param1Int, param1EventParam);
      return this;
    }
    
    public Builder addParams(GmpMeasurement.EventParam.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.Event)this.instance).addParams(param1Builder);
      return this;
    }
    
    public Builder addParams(GmpMeasurement.EventParam param1EventParam) {
      copyOnWrite();
      ((GmpMeasurement.Event)this.instance).addParams(param1EventParam);
      return this;
    }
    
    public Builder clearCount() {
      copyOnWrite();
      ((GmpMeasurement.Event)this.instance).clearCount();
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      ((GmpMeasurement.Event)this.instance).clearName();
      return this;
    }
    
    public Builder clearParams() {
      copyOnWrite();
      ((GmpMeasurement.Event)this.instance).clearParams();
      return this;
    }
    
    public Builder clearPreviousTimestampMillis() {
      copyOnWrite();
      ((GmpMeasurement.Event)this.instance).clearPreviousTimestampMillis();
      return this;
    }
    
    public Builder clearTimestampMillis() {
      copyOnWrite();
      ((GmpMeasurement.Event)this.instance).clearTimestampMillis();
      return this;
    }
    
    public int getCount() {
      return ((GmpMeasurement.Event)this.instance).getCount();
    }
    
    public String getName() {
      return ((GmpMeasurement.Event)this.instance).getName();
    }
    
    public ByteString getNameBytes() {
      return ((GmpMeasurement.Event)this.instance).getNameBytes();
    }
    
    public GmpMeasurement.EventParam getParams(int param1Int) {
      return ((GmpMeasurement.Event)this.instance).getParams(param1Int);
    }
    
    public int getParamsCount() {
      return ((GmpMeasurement.Event)this.instance).getParamsCount();
    }
    
    public List<GmpMeasurement.EventParam> getParamsList() {
      return Collections.unmodifiableList(((GmpMeasurement.Event)this.instance).getParamsList());
    }
    
    public long getPreviousTimestampMillis() {
      return ((GmpMeasurement.Event)this.instance).getPreviousTimestampMillis();
    }
    
    public long getTimestampMillis() {
      return ((GmpMeasurement.Event)this.instance).getTimestampMillis();
    }
    
    public boolean hasCount() {
      return ((GmpMeasurement.Event)this.instance).hasCount();
    }
    
    public boolean hasName() {
      return ((GmpMeasurement.Event)this.instance).hasName();
    }
    
    public boolean hasPreviousTimestampMillis() {
      return ((GmpMeasurement.Event)this.instance).hasPreviousTimestampMillis();
    }
    
    public boolean hasTimestampMillis() {
      return ((GmpMeasurement.Event)this.instance).hasTimestampMillis();
    }
    
    public Builder removeParams(int param1Int) {
      copyOnWrite();
      ((GmpMeasurement.Event)this.instance).removeParams(param1Int);
      return this;
    }
    
    public Builder setCount(int param1Int) {
      copyOnWrite();
      ((GmpMeasurement.Event)this.instance).setCount(param1Int);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      ((GmpMeasurement.Event)this.instance).setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurement.Event)this.instance).setNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setParams(int param1Int, GmpMeasurement.EventParam.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.Event)this.instance).setParams(param1Int, param1Builder);
      return this;
    }
    
    public Builder setParams(int param1Int, GmpMeasurement.EventParam param1EventParam) {
      copyOnWrite();
      ((GmpMeasurement.Event)this.instance).setParams(param1Int, param1EventParam);
      return this;
    }
    
    public Builder setPreviousTimestampMillis(long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.Event)this.instance).setPreviousTimestampMillis(param1Long);
      return this;
    }
    
    public Builder setTimestampMillis(long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.Event)this.instance).setTimestampMillis(param1Long);
      return this;
    }
  }
  
  public static interface EventOrBuilder extends MessageLiteOrBuilder {
    int getCount();
    
    String getName();
    
    ByteString getNameBytes();
    
    GmpMeasurement.EventParam getParams(int param1Int);
    
    int getParamsCount();
    
    List<GmpMeasurement.EventParam> getParamsList();
    
    long getPreviousTimestampMillis();
    
    long getTimestampMillis();
    
    boolean hasCount();
    
    boolean hasName();
    
    boolean hasPreviousTimestampMillis();
    
    boolean hasTimestampMillis();
  }
  
  public static final class EventParam extends GeneratedMessageLite<EventParam, EventParam.Builder> implements EventParamOrBuilder {
    private static final EventParam DEFAULT_INSTANCE = new EventParam();
    
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 5;
    
    public static final int FLOAT_VALUE_FIELD_NUMBER = 4;
    
    public static final int INT_VALUE_FIELD_NUMBER = 3;
    
    public static final int NAME_FIELD_NUMBER = 1;
    
    private static volatile Parser<EventParam> PARSER;
    
    public static final int STRING_VALUE_FIELD_NUMBER = 2;
    
    private int bitField0_;
    
    private double doubleValue_;
    
    private float floatValue_;
    
    private long intValue_;
    
    private String name_ = "";
    
    private String stringValue_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearDoubleValue() {
      this.bitField0_ &= 0xFFFFFFEF;
      this.doubleValue_ = 0.0D;
    }
    
    private void clearFloatValue() {
      this.bitField0_ &= 0xFFFFFFF7;
      this.floatValue_ = 0.0F;
    }
    
    private void clearIntValue() {
      this.bitField0_ &= 0xFFFFFFFB;
      this.intValue_ = 0L;
    }
    
    private void clearName() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.name_ = getDefaultInstance().getName();
    }
    
    private void clearStringValue() {
      this.bitField0_ &= 0xFFFFFFFD;
      this.stringValue_ = getDefaultInstance().getStringValue();
    }
    
    public static EventParam getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(EventParam param1EventParam) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1EventParam);
    }
    
    public static EventParam parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (EventParam)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static EventParam parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (EventParam)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static EventParam parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (EventParam)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static EventParam parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (EventParam)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static EventParam parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (EventParam)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static EventParam parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (EventParam)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static EventParam parseFrom(InputStream param1InputStream) throws IOException {
      return (EventParam)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static EventParam parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (EventParam)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static EventParam parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (EventParam)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static EventParam parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (EventParam)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<EventParam> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setDoubleValue(double param1Double) {
      this.bitField0_ |= 0x10;
      this.doubleValue_ = param1Double;
    }
    
    private void setFloatValue(float param1Float) {
      this.bitField0_ |= 0x8;
      this.floatValue_ = param1Float;
    }
    
    private void setIntValue(long param1Long) {
      this.bitField0_ |= 0x4;
      this.intValue_ = param1Long;
    }
    
    private void setName(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x1;
        this.name_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x1;
        this.name_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setStringValue(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x2;
        this.stringValue_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setStringValueBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x2;
        this.stringValue_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic analytics_collection/GmpMeasurement$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 538, 2 -> 534, 3 -> 532, 4 -> 523, 5 -> 361, 6 -> 110, 7 -> 357, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic analytics_collection/GmpMeasurement$EventParam.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc analytics_collection/GmpMeasurement$EventParam
      //   72: monitorenter
      //   73: getstatic analytics_collection/GmpMeasurement$EventParam.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic analytics_collection/GmpMeasurement$EventParam.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$EventParam;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic analytics_collection/GmpMeasurement$EventParam.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc analytics_collection/GmpMeasurement$EventParam
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc analytics_collection/GmpMeasurement$EventParam
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic analytics_collection/GmpMeasurement$EventParam.PARSER : Lcom/google/protobuf/Parser;
      //   109: areturn
      //   110: aload_2
      //   111: checkcast com/google/protobuf/CodedInputStream
      //   114: astore_1
      //   115: aload_3
      //   116: checkcast com/google/protobuf/ExtensionRegistryLite
      //   119: astore_2
      //   120: iconst_0
      //   121: istore #4
      //   123: iload #4
      //   125: ifne -> 357
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 301
      //   139: iload #5
      //   141: bipush #10
      //   143: if_icmpeq -> 278
      //   146: iload #5
      //   148: bipush #18
      //   150: if_icmpeq -> 255
      //   153: iload #5
      //   155: bipush #24
      //   157: if_icmpeq -> 234
      //   160: iload #5
      //   162: bipush #37
      //   164: if_icmpeq -> 212
      //   167: iload #5
      //   169: bipush #41
      //   171: if_icmpeq -> 190
      //   174: aload_0
      //   175: iload #5
      //   177: aload_1
      //   178: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   181: ifne -> 123
      //   184: iconst_1
      //   185: istore #4
      //   187: goto -> 123
      //   190: aload_0
      //   191: aload_0
      //   192: getfield bitField0_ : I
      //   195: bipush #16
      //   197: ior
      //   198: putfield bitField0_ : I
      //   201: aload_0
      //   202: aload_1
      //   203: invokevirtual readDouble : ()D
      //   206: putfield doubleValue_ : D
      //   209: goto -> 123
      //   212: aload_0
      //   213: aload_0
      //   214: getfield bitField0_ : I
      //   217: bipush #8
      //   219: ior
      //   220: putfield bitField0_ : I
      //   223: aload_0
      //   224: aload_1
      //   225: invokevirtual readFloat : ()F
      //   228: putfield floatValue_ : F
      //   231: goto -> 123
      //   234: aload_0
      //   235: aload_0
      //   236: getfield bitField0_ : I
      //   239: iconst_4
      //   240: ior
      //   241: putfield bitField0_ : I
      //   244: aload_0
      //   245: aload_1
      //   246: invokevirtual readInt64 : ()J
      //   249: putfield intValue_ : J
      //   252: goto -> 123
      //   255: aload_1
      //   256: invokevirtual readString : ()Ljava/lang/String;
      //   259: astore_2
      //   260: aload_0
      //   261: aload_0
      //   262: getfield bitField0_ : I
      //   265: iconst_2
      //   266: ior
      //   267: putfield bitField0_ : I
      //   270: aload_0
      //   271: aload_2
      //   272: putfield stringValue_ : Ljava/lang/String;
      //   275: goto -> 123
      //   278: aload_1
      //   279: invokevirtual readString : ()Ljava/lang/String;
      //   282: astore_2
      //   283: aload_0
      //   284: iconst_1
      //   285: aload_0
      //   286: getfield bitField0_ : I
      //   289: ior
      //   290: putfield bitField0_ : I
      //   293: aload_0
      //   294: aload_2
      //   295: putfield name_ : Ljava/lang/String;
      //   298: goto -> 123
      //   301: iconst_1
      //   302: istore #4
      //   304: goto -> 123
      //   307: astore_1
      //   308: goto -> 355
      //   311: astore_3
      //   312: new java/lang/RuntimeException
      //   315: astore_2
      //   316: new com/google/protobuf/InvalidProtocolBufferException
      //   319: astore_1
      //   320: aload_1
      //   321: aload_3
      //   322: invokevirtual getMessage : ()Ljava/lang/String;
      //   325: invokespecial <init> : (Ljava/lang/String;)V
      //   328: aload_2
      //   329: aload_1
      //   330: aload_0
      //   331: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   334: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   337: aload_2
      //   338: athrow
      //   339: astore_1
      //   340: new java/lang/RuntimeException
      //   343: astore_2
      //   344: aload_2
      //   345: aload_1
      //   346: aload_0
      //   347: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   350: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   353: aload_2
      //   354: athrow
      //   355: aload_1
      //   356: athrow
      //   357: getstatic analytics_collection/GmpMeasurement$EventParam.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$EventParam;
      //   360: areturn
      //   361: aload_2
      //   362: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   365: astore_1
      //   366: aload_3
      //   367: checkcast analytics_collection/GmpMeasurement$EventParam
      //   370: astore_2
      //   371: aload_0
      //   372: aload_1
      //   373: aload_0
      //   374: invokevirtual hasName : ()Z
      //   377: aload_0
      //   378: getfield name_ : Ljava/lang/String;
      //   381: aload_2
      //   382: invokevirtual hasName : ()Z
      //   385: aload_2
      //   386: getfield name_ : Ljava/lang/String;
      //   389: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   394: putfield name_ : Ljava/lang/String;
      //   397: aload_0
      //   398: aload_1
      //   399: aload_0
      //   400: invokevirtual hasStringValue : ()Z
      //   403: aload_0
      //   404: getfield stringValue_ : Ljava/lang/String;
      //   407: aload_2
      //   408: invokevirtual hasStringValue : ()Z
      //   411: aload_2
      //   412: getfield stringValue_ : Ljava/lang/String;
      //   415: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   420: putfield stringValue_ : Ljava/lang/String;
      //   423: aload_0
      //   424: aload_1
      //   425: aload_0
      //   426: invokevirtual hasIntValue : ()Z
      //   429: aload_0
      //   430: getfield intValue_ : J
      //   433: aload_2
      //   434: invokevirtual hasIntValue : ()Z
      //   437: aload_2
      //   438: getfield intValue_ : J
      //   441: invokeinterface visitLong : (ZJZJ)J
      //   446: putfield intValue_ : J
      //   449: aload_0
      //   450: aload_1
      //   451: aload_0
      //   452: invokevirtual hasFloatValue : ()Z
      //   455: aload_0
      //   456: getfield floatValue_ : F
      //   459: aload_2
      //   460: invokevirtual hasFloatValue : ()Z
      //   463: aload_2
      //   464: getfield floatValue_ : F
      //   467: invokeinterface visitFloat : (ZFZF)F
      //   472: putfield floatValue_ : F
      //   475: aload_0
      //   476: aload_1
      //   477: aload_0
      //   478: invokevirtual hasDoubleValue : ()Z
      //   481: aload_0
      //   482: getfield doubleValue_ : D
      //   485: aload_2
      //   486: invokevirtual hasDoubleValue : ()Z
      //   489: aload_2
      //   490: getfield doubleValue_ : D
      //   493: invokeinterface visitDouble : (ZDZD)D
      //   498: putfield doubleValue_ : D
      //   501: aload_1
      //   502: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   505: if_acmpne -> 521
      //   508: aload_0
      //   509: aload_0
      //   510: getfield bitField0_ : I
      //   513: aload_2
      //   514: getfield bitField0_ : I
      //   517: ior
      //   518: putfield bitField0_ : I
      //   521: aload_0
      //   522: areturn
      //   523: new analytics_collection/GmpMeasurement$EventParam$Builder
      //   526: dup
      //   527: aconst_null
      //   528: invokespecial <init> : (Lanalytics_collection/GmpMeasurement$1;)V
      //   531: areturn
      //   532: aconst_null
      //   533: areturn
      //   534: getstatic analytics_collection/GmpMeasurement$EventParam.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$EventParam;
      //   537: areturn
      //   538: new analytics_collection/GmpMeasurement$EventParam
      //   541: dup
      //   542: invokespecial <init> : ()V
      //   545: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	339	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	311	java/io/IOException
      //   128	134	307	finally
      //   174	184	339	com/google/protobuf/InvalidProtocolBufferException
      //   174	184	311	java/io/IOException
      //   174	184	307	finally
      //   190	209	339	com/google/protobuf/InvalidProtocolBufferException
      //   190	209	311	java/io/IOException
      //   190	209	307	finally
      //   212	231	339	com/google/protobuf/InvalidProtocolBufferException
      //   212	231	311	java/io/IOException
      //   212	231	307	finally
      //   234	252	339	com/google/protobuf/InvalidProtocolBufferException
      //   234	252	311	java/io/IOException
      //   234	252	307	finally
      //   255	275	339	com/google/protobuf/InvalidProtocolBufferException
      //   255	275	311	java/io/IOException
      //   255	275	307	finally
      //   278	298	339	com/google/protobuf/InvalidProtocolBufferException
      //   278	298	311	java/io/IOException
      //   278	298	307	finally
      //   312	339	307	finally
      //   340	355	307	finally
    }
    
    public double getDoubleValue() {
      return this.doubleValue_;
    }
    
    public float getFloatValue() {
      return this.floatValue_;
    }
    
    public long getIntValue() {
      return this.intValue_;
    }
    
    public String getName() {
      return this.name_;
    }
    
    public ByteString getNameBytes() {
      return ByteString.copyFromUtf8(this.name_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if ((this.bitField0_ & 0x1) == 1)
        j = 0 + CodedOutputStream.computeStringSize(1, getName()); 
      i = j;
      if ((this.bitField0_ & 0x2) == 2)
        i = j + CodedOutputStream.computeStringSize(2, getStringValue()); 
      j = i;
      if ((this.bitField0_ & 0x4) == 4)
        j = i + CodedOutputStream.computeInt64Size(3, this.intValue_); 
      i = j;
      if ((this.bitField0_ & 0x8) == 8)
        i = j + CodedOutputStream.computeFloatSize(4, this.floatValue_); 
      j = i;
      if ((this.bitField0_ & 0x10) == 16)
        j = i + CodedOutputStream.computeDoubleSize(5, this.doubleValue_); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public String getStringValue() {
      return this.stringValue_;
    }
    
    public ByteString getStringValueBytes() {
      return ByteString.copyFromUtf8(this.stringValue_);
    }
    
    public boolean hasDoubleValue() {
      boolean bool;
      if ((this.bitField0_ & 0x10) == 16) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasFloatValue() {
      boolean bool;
      if ((this.bitField0_ & 0x8) == 8) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasIntValue() {
      boolean bool;
      if ((this.bitField0_ & 0x4) == 4) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasName() {
      int i = this.bitField0_;
      boolean bool = true;
      if ((i & 0x1) != 1)
        bool = false; 
      return bool;
    }
    
    public boolean hasStringValue() {
      boolean bool;
      if ((this.bitField0_ & 0x2) == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if ((this.bitField0_ & 0x1) == 1)
        param1CodedOutputStream.writeString(1, getName()); 
      if ((this.bitField0_ & 0x2) == 2)
        param1CodedOutputStream.writeString(2, getStringValue()); 
      if ((this.bitField0_ & 0x4) == 4)
        param1CodedOutputStream.writeInt64(3, this.intValue_); 
      if ((this.bitField0_ & 0x8) == 8)
        param1CodedOutputStream.writeFloat(4, this.floatValue_); 
      if ((this.bitField0_ & 0x10) == 16)
        param1CodedOutputStream.writeDouble(5, this.doubleValue_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<EventParam, Builder> implements GmpMeasurement.EventParamOrBuilder {
      private Builder() {
        super(GmpMeasurement.EventParam.DEFAULT_INSTANCE);
      }
      
      public Builder clearDoubleValue() {
        copyOnWrite();
        ((GmpMeasurement.EventParam)this.instance).clearDoubleValue();
        return this;
      }
      
      public Builder clearFloatValue() {
        copyOnWrite();
        ((GmpMeasurement.EventParam)this.instance).clearFloatValue();
        return this;
      }
      
      public Builder clearIntValue() {
        copyOnWrite();
        ((GmpMeasurement.EventParam)this.instance).clearIntValue();
        return this;
      }
      
      public Builder clearName() {
        copyOnWrite();
        ((GmpMeasurement.EventParam)this.instance).clearName();
        return this;
      }
      
      public Builder clearStringValue() {
        copyOnWrite();
        ((GmpMeasurement.EventParam)this.instance).clearStringValue();
        return this;
      }
      
      public double getDoubleValue() {
        return ((GmpMeasurement.EventParam)this.instance).getDoubleValue();
      }
      
      public float getFloatValue() {
        return ((GmpMeasurement.EventParam)this.instance).getFloatValue();
      }
      
      public long getIntValue() {
        return ((GmpMeasurement.EventParam)this.instance).getIntValue();
      }
      
      public String getName() {
        return ((GmpMeasurement.EventParam)this.instance).getName();
      }
      
      public ByteString getNameBytes() {
        return ((GmpMeasurement.EventParam)this.instance).getNameBytes();
      }
      
      public String getStringValue() {
        return ((GmpMeasurement.EventParam)this.instance).getStringValue();
      }
      
      public ByteString getStringValueBytes() {
        return ((GmpMeasurement.EventParam)this.instance).getStringValueBytes();
      }
      
      public boolean hasDoubleValue() {
        return ((GmpMeasurement.EventParam)this.instance).hasDoubleValue();
      }
      
      public boolean hasFloatValue() {
        return ((GmpMeasurement.EventParam)this.instance).hasFloatValue();
      }
      
      public boolean hasIntValue() {
        return ((GmpMeasurement.EventParam)this.instance).hasIntValue();
      }
      
      public boolean hasName() {
        return ((GmpMeasurement.EventParam)this.instance).hasName();
      }
      
      public boolean hasStringValue() {
        return ((GmpMeasurement.EventParam)this.instance).hasStringValue();
      }
      
      public Builder setDoubleValue(double param2Double) {
        copyOnWrite();
        ((GmpMeasurement.EventParam)this.instance).setDoubleValue(param2Double);
        return this;
      }
      
      public Builder setFloatValue(float param2Float) {
        copyOnWrite();
        ((GmpMeasurement.EventParam)this.instance).setFloatValue(param2Float);
        return this;
      }
      
      public Builder setIntValue(long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.EventParam)this.instance).setIntValue(param2Long);
        return this;
      }
      
      public Builder setName(String param2String) {
        copyOnWrite();
        ((GmpMeasurement.EventParam)this.instance).setName(param2String);
        return this;
      }
      
      public Builder setNameBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurement.EventParam)this.instance).setNameBytes(param2ByteString);
        return this;
      }
      
      public Builder setStringValue(String param2String) {
        copyOnWrite();
        ((GmpMeasurement.EventParam)this.instance).setStringValue(param2String);
        return this;
      }
      
      public Builder setStringValueBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurement.EventParam)this.instance).setStringValueBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<EventParam, EventParam.Builder> implements EventParamOrBuilder {
    private Builder() {
      super(GmpMeasurement.EventParam.DEFAULT_INSTANCE);
    }
    
    public Builder clearDoubleValue() {
      copyOnWrite();
      ((GmpMeasurement.EventParam)this.instance).clearDoubleValue();
      return this;
    }
    
    public Builder clearFloatValue() {
      copyOnWrite();
      ((GmpMeasurement.EventParam)this.instance).clearFloatValue();
      return this;
    }
    
    public Builder clearIntValue() {
      copyOnWrite();
      ((GmpMeasurement.EventParam)this.instance).clearIntValue();
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      ((GmpMeasurement.EventParam)this.instance).clearName();
      return this;
    }
    
    public Builder clearStringValue() {
      copyOnWrite();
      ((GmpMeasurement.EventParam)this.instance).clearStringValue();
      return this;
    }
    
    public double getDoubleValue() {
      return ((GmpMeasurement.EventParam)this.instance).getDoubleValue();
    }
    
    public float getFloatValue() {
      return ((GmpMeasurement.EventParam)this.instance).getFloatValue();
    }
    
    public long getIntValue() {
      return ((GmpMeasurement.EventParam)this.instance).getIntValue();
    }
    
    public String getName() {
      return ((GmpMeasurement.EventParam)this.instance).getName();
    }
    
    public ByteString getNameBytes() {
      return ((GmpMeasurement.EventParam)this.instance).getNameBytes();
    }
    
    public String getStringValue() {
      return ((GmpMeasurement.EventParam)this.instance).getStringValue();
    }
    
    public ByteString getStringValueBytes() {
      return ((GmpMeasurement.EventParam)this.instance).getStringValueBytes();
    }
    
    public boolean hasDoubleValue() {
      return ((GmpMeasurement.EventParam)this.instance).hasDoubleValue();
    }
    
    public boolean hasFloatValue() {
      return ((GmpMeasurement.EventParam)this.instance).hasFloatValue();
    }
    
    public boolean hasIntValue() {
      return ((GmpMeasurement.EventParam)this.instance).hasIntValue();
    }
    
    public boolean hasName() {
      return ((GmpMeasurement.EventParam)this.instance).hasName();
    }
    
    public boolean hasStringValue() {
      return ((GmpMeasurement.EventParam)this.instance).hasStringValue();
    }
    
    public Builder setDoubleValue(double param1Double) {
      copyOnWrite();
      ((GmpMeasurement.EventParam)this.instance).setDoubleValue(param1Double);
      return this;
    }
    
    public Builder setFloatValue(float param1Float) {
      copyOnWrite();
      ((GmpMeasurement.EventParam)this.instance).setFloatValue(param1Float);
      return this;
    }
    
    public Builder setIntValue(long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.EventParam)this.instance).setIntValue(param1Long);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      ((GmpMeasurement.EventParam)this.instance).setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurement.EventParam)this.instance).setNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setStringValue(String param1String) {
      copyOnWrite();
      ((GmpMeasurement.EventParam)this.instance).setStringValue(param1String);
      return this;
    }
    
    public Builder setStringValueBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurement.EventParam)this.instance).setStringValueBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface EventParamOrBuilder extends MessageLiteOrBuilder {
    double getDoubleValue();
    
    float getFloatValue();
    
    long getIntValue();
    
    String getName();
    
    ByteString getNameBytes();
    
    String getStringValue();
    
    ByteString getStringValueBytes();
    
    boolean hasDoubleValue();
    
    boolean hasFloatValue();
    
    boolean hasIntValue();
    
    boolean hasName();
    
    boolean hasStringValue();
  }
  
  public static final class GaiaInfo extends GeneratedMessageLite<GaiaInfo, GaiaInfo.Builder> implements GaiaInfoOrBuilder {
    private static final GaiaInfo DEFAULT_INSTANCE = new GaiaInfo();
    
    public static final int ENCRYPTED_GAIA_ID_REQUIRES_PRIVACY_REVIEW_FIELD_NUMBER = 1;
    
    public static final int LOW_LEVEL_INFO_REQUIRES_PRIVACY_REVIEW_FIELD_NUMBER = 4;
    
    private static volatile Parser<GaiaInfo> PARSER;
    
    public static final int PRIVACY_MODIFIERS_REQUIRES_PRIVACY_REVIEW_FIELD_NUMBER = 2;
    
    public static final int PUBLISHER_PRIVACY_MODIFIERS_REQUIRES_PRIVACY_REVIEW_FIELD_NUMBER = 3;
    
    private int bitField0_;
    
    private String encryptedGaiaIdRequiresPrivacyReview_ = "";
    
    private LoggedLowLevelPrivacyInfo lowLevelInfoRequiresPrivacyReview_;
    
    private long privacyModifiersRequiresPrivacyReview_;
    
    private long publisherPrivacyModifiersRequiresPrivacyReview_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearEncryptedGaiaIdRequiresPrivacyReview() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.encryptedGaiaIdRequiresPrivacyReview_ = getDefaultInstance().getEncryptedGaiaIdRequiresPrivacyReview();
    }
    
    private void clearLowLevelInfoRequiresPrivacyReview() {
      this.lowLevelInfoRequiresPrivacyReview_ = null;
      this.bitField0_ &= 0xFFFFFFF7;
    }
    
    private void clearPrivacyModifiersRequiresPrivacyReview() {
      this.bitField0_ &= 0xFFFFFFFD;
      this.privacyModifiersRequiresPrivacyReview_ = 0L;
    }
    
    private void clearPublisherPrivacyModifiersRequiresPrivacyReview() {
      this.bitField0_ &= 0xFFFFFFFB;
      this.publisherPrivacyModifiersRequiresPrivacyReview_ = 0L;
    }
    
    public static GaiaInfo getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeLowLevelInfoRequiresPrivacyReview(LoggedLowLevelPrivacyInfo param1LoggedLowLevelPrivacyInfo) {
      LoggedLowLevelPrivacyInfo loggedLowLevelPrivacyInfo = this.lowLevelInfoRequiresPrivacyReview_;
      if (loggedLowLevelPrivacyInfo != null && loggedLowLevelPrivacyInfo != LoggedLowLevelPrivacyInfo.getDefaultInstance()) {
        this.lowLevelInfoRequiresPrivacyReview_ = (LoggedLowLevelPrivacyInfo)((LoggedLowLevelPrivacyInfo.Builder)LoggedLowLevelPrivacyInfo.newBuilder(this.lowLevelInfoRequiresPrivacyReview_).mergeFrom(param1LoggedLowLevelPrivacyInfo)).buildPartial();
      } else {
        this.lowLevelInfoRequiresPrivacyReview_ = param1LoggedLowLevelPrivacyInfo;
      } 
      this.bitField0_ |= 0x8;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(GaiaInfo param1GaiaInfo) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1GaiaInfo);
    }
    
    public static GaiaInfo parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (GaiaInfo)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static GaiaInfo parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (GaiaInfo)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static GaiaInfo parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (GaiaInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static GaiaInfo parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (GaiaInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static GaiaInfo parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (GaiaInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static GaiaInfo parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (GaiaInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static GaiaInfo parseFrom(InputStream param1InputStream) throws IOException {
      return (GaiaInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static GaiaInfo parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (GaiaInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static GaiaInfo parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (GaiaInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static GaiaInfo parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (GaiaInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<GaiaInfo> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setEncryptedGaiaIdRequiresPrivacyReview(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x1;
        this.encryptedGaiaIdRequiresPrivacyReview_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setEncryptedGaiaIdRequiresPrivacyReviewBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x1;
        this.encryptedGaiaIdRequiresPrivacyReview_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setLowLevelInfoRequiresPrivacyReview(LoggedLowLevelPrivacyInfo.Builder param1Builder) {
      this.lowLevelInfoRequiresPrivacyReview_ = (LoggedLowLevelPrivacyInfo)param1Builder.build();
      this.bitField0_ |= 0x8;
    }
    
    private void setLowLevelInfoRequiresPrivacyReview(LoggedLowLevelPrivacyInfo param1LoggedLowLevelPrivacyInfo) {
      if (param1LoggedLowLevelPrivacyInfo != null) {
        this.lowLevelInfoRequiresPrivacyReview_ = param1LoggedLowLevelPrivacyInfo;
        this.bitField0_ |= 0x8;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setPrivacyModifiersRequiresPrivacyReview(long param1Long) {
      this.bitField0_ |= 0x2;
      this.privacyModifiersRequiresPrivacyReview_ = param1Long;
    }
    
    private void setPublisherPrivacyModifiersRequiresPrivacyReview(long param1Long) {
      this.bitField0_ |= 0x4;
      this.publisherPrivacyModifiersRequiresPrivacyReview_ = param1Long;
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic analytics_collection/GmpMeasurement$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 535, 2 -> 531, 3 -> 529, 4 -> 520, 5 -> 389, 6 -> 110, 7 -> 385, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic analytics_collection/GmpMeasurement$GaiaInfo.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc analytics_collection/GmpMeasurement$GaiaInfo
      //   72: monitorenter
      //   73: getstatic analytics_collection/GmpMeasurement$GaiaInfo.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic analytics_collection/GmpMeasurement$GaiaInfo.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$GaiaInfo;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic analytics_collection/GmpMeasurement$GaiaInfo.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc analytics_collection/GmpMeasurement$GaiaInfo
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc analytics_collection/GmpMeasurement$GaiaInfo
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic analytics_collection/GmpMeasurement$GaiaInfo.PARSER : Lcom/google/protobuf/Parser;
      //   109: areturn
      //   110: aload_2
      //   111: checkcast com/google/protobuf/CodedInputStream
      //   114: astore_2
      //   115: aload_3
      //   116: checkcast com/google/protobuf/ExtensionRegistryLite
      //   119: astore_3
      //   120: iconst_0
      //   121: istore #4
      //   123: iload #4
      //   125: ifne -> 385
      //   128: aload_2
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 329
      //   139: iload #5
      //   141: bipush #10
      //   143: if_icmpeq -> 306
      //   146: iload #5
      //   148: bipush #16
      //   150: if_icmpeq -> 285
      //   153: iload #5
      //   155: bipush #24
      //   157: if_icmpeq -> 264
      //   160: iload #5
      //   162: bipush #34
      //   164: if_icmpeq -> 183
      //   167: aload_0
      //   168: iload #5
      //   170: aload_2
      //   171: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   174: ifne -> 123
      //   177: iconst_1
      //   178: istore #4
      //   180: goto -> 123
      //   183: aload_0
      //   184: getfield bitField0_ : I
      //   187: bipush #8
      //   189: iand
      //   190: bipush #8
      //   192: if_icmpne -> 209
      //   195: aload_0
      //   196: getfield lowLevelInfoRequiresPrivacyReview_ : Lanalytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo;
      //   199: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   202: checkcast analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo$Builder
      //   205: astore_1
      //   206: goto -> 211
      //   209: aconst_null
      //   210: astore_1
      //   211: aload_0
      //   212: aload_2
      //   213: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   216: aload_3
      //   217: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   220: checkcast analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo
      //   223: putfield lowLevelInfoRequiresPrivacyReview_ : Lanalytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo;
      //   226: aload_1
      //   227: ifnull -> 250
      //   230: aload_1
      //   231: aload_0
      //   232: getfield lowLevelInfoRequiresPrivacyReview_ : Lanalytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo;
      //   235: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   238: pop
      //   239: aload_0
      //   240: aload_1
      //   241: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   244: checkcast analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo
      //   247: putfield lowLevelInfoRequiresPrivacyReview_ : Lanalytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo;
      //   250: aload_0
      //   251: aload_0
      //   252: getfield bitField0_ : I
      //   255: bipush #8
      //   257: ior
      //   258: putfield bitField0_ : I
      //   261: goto -> 123
      //   264: aload_0
      //   265: aload_0
      //   266: getfield bitField0_ : I
      //   269: iconst_4
      //   270: ior
      //   271: putfield bitField0_ : I
      //   274: aload_0
      //   275: aload_2
      //   276: invokevirtual readUInt64 : ()J
      //   279: putfield publisherPrivacyModifiersRequiresPrivacyReview_ : J
      //   282: goto -> 123
      //   285: aload_0
      //   286: aload_0
      //   287: getfield bitField0_ : I
      //   290: iconst_2
      //   291: ior
      //   292: putfield bitField0_ : I
      //   295: aload_0
      //   296: aload_2
      //   297: invokevirtual readUInt64 : ()J
      //   300: putfield privacyModifiersRequiresPrivacyReview_ : J
      //   303: goto -> 123
      //   306: aload_2
      //   307: invokevirtual readString : ()Ljava/lang/String;
      //   310: astore_1
      //   311: aload_0
      //   312: iconst_1
      //   313: aload_0
      //   314: getfield bitField0_ : I
      //   317: ior
      //   318: putfield bitField0_ : I
      //   321: aload_0
      //   322: aload_1
      //   323: putfield encryptedGaiaIdRequiresPrivacyReview_ : Ljava/lang/String;
      //   326: goto -> 123
      //   329: iconst_1
      //   330: istore #4
      //   332: goto -> 123
      //   335: astore_1
      //   336: goto -> 383
      //   339: astore_1
      //   340: new java/lang/RuntimeException
      //   343: astore_2
      //   344: new com/google/protobuf/InvalidProtocolBufferException
      //   347: astore_3
      //   348: aload_3
      //   349: aload_1
      //   350: invokevirtual getMessage : ()Ljava/lang/String;
      //   353: invokespecial <init> : (Ljava/lang/String;)V
      //   356: aload_2
      //   357: aload_3
      //   358: aload_0
      //   359: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   362: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   365: aload_2
      //   366: athrow
      //   367: astore_2
      //   368: new java/lang/RuntimeException
      //   371: astore_1
      //   372: aload_1
      //   373: aload_2
      //   374: aload_0
      //   375: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   378: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   381: aload_1
      //   382: athrow
      //   383: aload_1
      //   384: athrow
      //   385: getstatic analytics_collection/GmpMeasurement$GaiaInfo.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$GaiaInfo;
      //   388: areturn
      //   389: aload_2
      //   390: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   393: astore_1
      //   394: aload_3
      //   395: checkcast analytics_collection/GmpMeasurement$GaiaInfo
      //   398: astore_2
      //   399: aload_0
      //   400: aload_1
      //   401: aload_0
      //   402: invokevirtual hasEncryptedGaiaIdRequiresPrivacyReview : ()Z
      //   405: aload_0
      //   406: getfield encryptedGaiaIdRequiresPrivacyReview_ : Ljava/lang/String;
      //   409: aload_2
      //   410: invokevirtual hasEncryptedGaiaIdRequiresPrivacyReview : ()Z
      //   413: aload_2
      //   414: getfield encryptedGaiaIdRequiresPrivacyReview_ : Ljava/lang/String;
      //   417: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   422: putfield encryptedGaiaIdRequiresPrivacyReview_ : Ljava/lang/String;
      //   425: aload_0
      //   426: aload_1
      //   427: aload_0
      //   428: invokevirtual hasPrivacyModifiersRequiresPrivacyReview : ()Z
      //   431: aload_0
      //   432: getfield privacyModifiersRequiresPrivacyReview_ : J
      //   435: aload_2
      //   436: invokevirtual hasPrivacyModifiersRequiresPrivacyReview : ()Z
      //   439: aload_2
      //   440: getfield privacyModifiersRequiresPrivacyReview_ : J
      //   443: invokeinterface visitLong : (ZJZJ)J
      //   448: putfield privacyModifiersRequiresPrivacyReview_ : J
      //   451: aload_0
      //   452: aload_1
      //   453: aload_0
      //   454: invokevirtual hasPublisherPrivacyModifiersRequiresPrivacyReview : ()Z
      //   457: aload_0
      //   458: getfield publisherPrivacyModifiersRequiresPrivacyReview_ : J
      //   461: aload_2
      //   462: invokevirtual hasPublisherPrivacyModifiersRequiresPrivacyReview : ()Z
      //   465: aload_2
      //   466: getfield publisherPrivacyModifiersRequiresPrivacyReview_ : J
      //   469: invokeinterface visitLong : (ZJZJ)J
      //   474: putfield publisherPrivacyModifiersRequiresPrivacyReview_ : J
      //   477: aload_0
      //   478: aload_1
      //   479: aload_0
      //   480: getfield lowLevelInfoRequiresPrivacyReview_ : Lanalytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo;
      //   483: aload_2
      //   484: getfield lowLevelInfoRequiresPrivacyReview_ : Lanalytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo;
      //   487: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   492: checkcast analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo
      //   495: putfield lowLevelInfoRequiresPrivacyReview_ : Lanalytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo;
      //   498: aload_1
      //   499: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   502: if_acmpne -> 518
      //   505: aload_0
      //   506: aload_0
      //   507: getfield bitField0_ : I
      //   510: aload_2
      //   511: getfield bitField0_ : I
      //   514: ior
      //   515: putfield bitField0_ : I
      //   518: aload_0
      //   519: areturn
      //   520: new analytics_collection/GmpMeasurement$GaiaInfo$Builder
      //   523: dup
      //   524: aconst_null
      //   525: invokespecial <init> : (Lanalytics_collection/GmpMeasurement$1;)V
      //   528: areturn
      //   529: aconst_null
      //   530: areturn
      //   531: getstatic analytics_collection/GmpMeasurement$GaiaInfo.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$GaiaInfo;
      //   534: areturn
      //   535: new analytics_collection/GmpMeasurement$GaiaInfo
      //   538: dup
      //   539: invokespecial <init> : ()V
      //   542: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	367	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	339	java/io/IOException
      //   128	134	335	finally
      //   167	177	367	com/google/protobuf/InvalidProtocolBufferException
      //   167	177	339	java/io/IOException
      //   167	177	335	finally
      //   183	206	367	com/google/protobuf/InvalidProtocolBufferException
      //   183	206	339	java/io/IOException
      //   183	206	335	finally
      //   211	226	367	com/google/protobuf/InvalidProtocolBufferException
      //   211	226	339	java/io/IOException
      //   211	226	335	finally
      //   230	250	367	com/google/protobuf/InvalidProtocolBufferException
      //   230	250	339	java/io/IOException
      //   230	250	335	finally
      //   250	261	367	com/google/protobuf/InvalidProtocolBufferException
      //   250	261	339	java/io/IOException
      //   250	261	335	finally
      //   264	282	367	com/google/protobuf/InvalidProtocolBufferException
      //   264	282	339	java/io/IOException
      //   264	282	335	finally
      //   285	303	367	com/google/protobuf/InvalidProtocolBufferException
      //   285	303	339	java/io/IOException
      //   285	303	335	finally
      //   306	326	367	com/google/protobuf/InvalidProtocolBufferException
      //   306	326	339	java/io/IOException
      //   306	326	335	finally
      //   340	367	335	finally
      //   368	383	335	finally
    }
    
    public String getEncryptedGaiaIdRequiresPrivacyReview() {
      return this.encryptedGaiaIdRequiresPrivacyReview_;
    }
    
    public ByteString getEncryptedGaiaIdRequiresPrivacyReviewBytes() {
      return ByteString.copyFromUtf8(this.encryptedGaiaIdRequiresPrivacyReview_);
    }
    
    public LoggedLowLevelPrivacyInfo getLowLevelInfoRequiresPrivacyReview() {
      LoggedLowLevelPrivacyInfo loggedLowLevelPrivacyInfo1 = this.lowLevelInfoRequiresPrivacyReview_;
      LoggedLowLevelPrivacyInfo loggedLowLevelPrivacyInfo2 = loggedLowLevelPrivacyInfo1;
      if (loggedLowLevelPrivacyInfo1 == null)
        loggedLowLevelPrivacyInfo2 = LoggedLowLevelPrivacyInfo.getDefaultInstance(); 
      return loggedLowLevelPrivacyInfo2;
    }
    
    public long getPrivacyModifiersRequiresPrivacyReview() {
      return this.privacyModifiersRequiresPrivacyReview_;
    }
    
    public long getPublisherPrivacyModifiersRequiresPrivacyReview() {
      return this.publisherPrivacyModifiersRequiresPrivacyReview_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if ((this.bitField0_ & 0x1) == 1)
        j = 0 + CodedOutputStream.computeStringSize(1, getEncryptedGaiaIdRequiresPrivacyReview()); 
      i = j;
      if ((this.bitField0_ & 0x2) == 2)
        i = j + CodedOutputStream.computeUInt64Size(2, this.privacyModifiersRequiresPrivacyReview_); 
      j = i;
      if ((this.bitField0_ & 0x4) == 4)
        j = i + CodedOutputStream.computeUInt64Size(3, this.publisherPrivacyModifiersRequiresPrivacyReview_); 
      i = j;
      if ((this.bitField0_ & 0x8) == 8)
        i = j + CodedOutputStream.computeMessageSize(4, (MessageLite)getLowLevelInfoRequiresPrivacyReview()); 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasEncryptedGaiaIdRequiresPrivacyReview() {
      int i = this.bitField0_;
      boolean bool = true;
      if ((i & 0x1) != 1)
        bool = false; 
      return bool;
    }
    
    public boolean hasLowLevelInfoRequiresPrivacyReview() {
      boolean bool;
      if ((this.bitField0_ & 0x8) == 8) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasPrivacyModifiersRequiresPrivacyReview() {
      boolean bool;
      if ((this.bitField0_ & 0x2) == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasPublisherPrivacyModifiersRequiresPrivacyReview() {
      boolean bool;
      if ((this.bitField0_ & 0x4) == 4) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if ((this.bitField0_ & 0x1) == 1)
        param1CodedOutputStream.writeString(1, getEncryptedGaiaIdRequiresPrivacyReview()); 
      if ((this.bitField0_ & 0x2) == 2)
        param1CodedOutputStream.writeUInt64(2, this.privacyModifiersRequiresPrivacyReview_); 
      if ((this.bitField0_ & 0x4) == 4)
        param1CodedOutputStream.writeUInt64(3, this.publisherPrivacyModifiersRequiresPrivacyReview_); 
      if ((this.bitField0_ & 0x8) == 8)
        param1CodedOutputStream.writeMessage(4, (MessageLite)getLowLevelInfoRequiresPrivacyReview()); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<GaiaInfo, Builder> implements GmpMeasurement.GaiaInfoOrBuilder {
      private Builder() {
        super(GmpMeasurement.GaiaInfo.DEFAULT_INSTANCE);
      }
      
      public Builder clearEncryptedGaiaIdRequiresPrivacyReview() {
        copyOnWrite();
        ((GmpMeasurement.GaiaInfo)this.instance).clearEncryptedGaiaIdRequiresPrivacyReview();
        return this;
      }
      
      public Builder clearLowLevelInfoRequiresPrivacyReview() {
        copyOnWrite();
        ((GmpMeasurement.GaiaInfo)this.instance).clearLowLevelInfoRequiresPrivacyReview();
        return this;
      }
      
      public Builder clearPrivacyModifiersRequiresPrivacyReview() {
        copyOnWrite();
        ((GmpMeasurement.GaiaInfo)this.instance).clearPrivacyModifiersRequiresPrivacyReview();
        return this;
      }
      
      public Builder clearPublisherPrivacyModifiersRequiresPrivacyReview() {
        copyOnWrite();
        ((GmpMeasurement.GaiaInfo)this.instance).clearPublisherPrivacyModifiersRequiresPrivacyReview();
        return this;
      }
      
      public String getEncryptedGaiaIdRequiresPrivacyReview() {
        return ((GmpMeasurement.GaiaInfo)this.instance).getEncryptedGaiaIdRequiresPrivacyReview();
      }
      
      public ByteString getEncryptedGaiaIdRequiresPrivacyReviewBytes() {
        return ((GmpMeasurement.GaiaInfo)this.instance).getEncryptedGaiaIdRequiresPrivacyReviewBytes();
      }
      
      public GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo getLowLevelInfoRequiresPrivacyReview() {
        return ((GmpMeasurement.GaiaInfo)this.instance).getLowLevelInfoRequiresPrivacyReview();
      }
      
      public long getPrivacyModifiersRequiresPrivacyReview() {
        return ((GmpMeasurement.GaiaInfo)this.instance).getPrivacyModifiersRequiresPrivacyReview();
      }
      
      public long getPublisherPrivacyModifiersRequiresPrivacyReview() {
        return ((GmpMeasurement.GaiaInfo)this.instance).getPublisherPrivacyModifiersRequiresPrivacyReview();
      }
      
      public boolean hasEncryptedGaiaIdRequiresPrivacyReview() {
        return ((GmpMeasurement.GaiaInfo)this.instance).hasEncryptedGaiaIdRequiresPrivacyReview();
      }
      
      public boolean hasLowLevelInfoRequiresPrivacyReview() {
        return ((GmpMeasurement.GaiaInfo)this.instance).hasLowLevelInfoRequiresPrivacyReview();
      }
      
      public boolean hasPrivacyModifiersRequiresPrivacyReview() {
        return ((GmpMeasurement.GaiaInfo)this.instance).hasPrivacyModifiersRequiresPrivacyReview();
      }
      
      public boolean hasPublisherPrivacyModifiersRequiresPrivacyReview() {
        return ((GmpMeasurement.GaiaInfo)this.instance).hasPublisherPrivacyModifiersRequiresPrivacyReview();
      }
      
      public Builder mergeLowLevelInfoRequiresPrivacyReview(GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo param2LoggedLowLevelPrivacyInfo) {
        copyOnWrite();
        ((GmpMeasurement.GaiaInfo)this.instance).mergeLowLevelInfoRequiresPrivacyReview(param2LoggedLowLevelPrivacyInfo);
        return this;
      }
      
      public Builder setEncryptedGaiaIdRequiresPrivacyReview(String param2String) {
        copyOnWrite();
        ((GmpMeasurement.GaiaInfo)this.instance).setEncryptedGaiaIdRequiresPrivacyReview(param2String);
        return this;
      }
      
      public Builder setEncryptedGaiaIdRequiresPrivacyReviewBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurement.GaiaInfo)this.instance).setEncryptedGaiaIdRequiresPrivacyReviewBytes(param2ByteString);
        return this;
      }
      
      public Builder setLowLevelInfoRequiresPrivacyReview(GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.GaiaInfo)this.instance).setLowLevelInfoRequiresPrivacyReview(param2Builder);
        return this;
      }
      
      public Builder setLowLevelInfoRequiresPrivacyReview(GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo param2LoggedLowLevelPrivacyInfo) {
        copyOnWrite();
        ((GmpMeasurement.GaiaInfo)this.instance).setLowLevelInfoRequiresPrivacyReview(param2LoggedLowLevelPrivacyInfo);
        return this;
      }
      
      public Builder setPrivacyModifiersRequiresPrivacyReview(long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.GaiaInfo)this.instance).setPrivacyModifiersRequiresPrivacyReview(param2Long);
        return this;
      }
      
      public Builder setPublisherPrivacyModifiersRequiresPrivacyReview(long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.GaiaInfo)this.instance).setPublisherPrivacyModifiersRequiresPrivacyReview(param2Long);
        return this;
      }
    }
    
    public static final class LoggedLowLevelPrivacyInfo extends GeneratedMessageLite<LoggedLowLevelPrivacyInfo, LoggedLowLevelPrivacyInfo.Builder> implements LoggedLowLevelPrivacyInfoOrBuilder {
      private static final LoggedLowLevelPrivacyInfo DEFAULT_INSTANCE = new LoggedLowLevelPrivacyInfo();
      
      private static volatile Parser<LoggedLowLevelPrivacyInfo> PARSER;
      
      public static final int PARTICIPATION_LEVEL_FIELD_NUMBER = 2;
      
      public static final int USER_CONTROLS_FIELD_NUMBER = 1;
      
      private int bitField0_;
      
      private long participationLevel_;
      
      private long userControls_;
      
      static {
        DEFAULT_INSTANCE.makeImmutable();
      }
      
      private void clearParticipationLevel() {
        this.bitField0_ &= 0xFFFFFFFD;
        this.participationLevel_ = 0L;
      }
      
      private void clearUserControls() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.userControls_ = 0L;
      }
      
      public static LoggedLowLevelPrivacyInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
      }
      
      public static Builder newBuilder() {
        return (Builder)DEFAULT_INSTANCE.toBuilder();
      }
      
      public static Builder newBuilder(LoggedLowLevelPrivacyInfo param2LoggedLowLevelPrivacyInfo) {
        return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param2LoggedLowLevelPrivacyInfo);
      }
      
      public static LoggedLowLevelPrivacyInfo parseDelimitedFrom(InputStream param2InputStream) throws IOException {
        return (LoggedLowLevelPrivacyInfo)parseDelimitedFrom(DEFAULT_INSTANCE, param2InputStream);
      }
      
      public static LoggedLowLevelPrivacyInfo parseDelimitedFrom(InputStream param2InputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (LoggedLowLevelPrivacyInfo)parseDelimitedFrom(DEFAULT_INSTANCE, param2InputStream, param2ExtensionRegistryLite);
      }
      
      public static LoggedLowLevelPrivacyInfo parseFrom(ByteString param2ByteString) throws InvalidProtocolBufferException {
        return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ByteString);
      }
      
      public static LoggedLowLevelPrivacyInfo parseFrom(ByteString param2ByteString, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ByteString, param2ExtensionRegistryLite);
      }
      
      public static LoggedLowLevelPrivacyInfo parseFrom(CodedInputStream param2CodedInputStream) throws IOException {
        return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2CodedInputStream);
      }
      
      public static LoggedLowLevelPrivacyInfo parseFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2CodedInputStream, param2ExtensionRegistryLite);
      }
      
      public static LoggedLowLevelPrivacyInfo parseFrom(InputStream param2InputStream) throws IOException {
        return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2InputStream);
      }
      
      public static LoggedLowLevelPrivacyInfo parseFrom(InputStream param2InputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2InputStream, param2ExtensionRegistryLite);
      }
      
      public static LoggedLowLevelPrivacyInfo parseFrom(byte[] param2ArrayOfbyte) throws InvalidProtocolBufferException {
        return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ArrayOfbyte);
      }
      
      public static LoggedLowLevelPrivacyInfo parseFrom(byte[] param2ArrayOfbyte, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ArrayOfbyte, param2ExtensionRegistryLite);
      }
      
      public static Parser<LoggedLowLevelPrivacyInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
      }
      
      private void setParticipationLevel(long param2Long) {
        this.bitField0_ |= 0x2;
        this.participationLevel_ = param2Long;
      }
      
      private void setUserControls(long param2Long) {
        this.bitField0_ |= 0x1;
        this.userControls_ = param2Long;
      }
      
      protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param2MethodToInvoke, Object param2Object1, Object param2Object2) {
        // Byte code:
        //   0: getstatic analytics_collection/GmpMeasurement$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
        //   3: aload_1
        //   4: invokevirtual ordinal : ()I
        //   7: iaload
        //   8: tableswitch default -> 56, 1 -> 370, 2 -> 366, 3 -> 364, 4 -> 355, 5 -> 271, 6 -> 110, 7 -> 267, 8 -> 64
        //   56: new java/lang/UnsupportedOperationException
        //   59: dup
        //   60: invokespecial <init> : ()V
        //   63: athrow
        //   64: getstatic analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo.PARSER : Lcom/google/protobuf/Parser;
        //   67: ifnonnull -> 106
        //   70: ldc analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo
        //   72: monitorenter
        //   73: getstatic analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo.PARSER : Lcom/google/protobuf/Parser;
        //   76: ifnonnull -> 94
        //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
        //   82: astore_1
        //   83: aload_1
        //   84: getstatic analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo;
        //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
        //   90: aload_1
        //   91: putstatic analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo.PARSER : Lcom/google/protobuf/Parser;
        //   94: ldc analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo
        //   96: monitorexit
        //   97: goto -> 106
        //   100: astore_1
        //   101: ldc analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo
        //   103: monitorexit
        //   104: aload_1
        //   105: athrow
        //   106: getstatic analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo.PARSER : Lcom/google/protobuf/Parser;
        //   109: areturn
        //   110: aload_2
        //   111: checkcast com/google/protobuf/CodedInputStream
        //   114: astore_1
        //   115: aload_3
        //   116: checkcast com/google/protobuf/ExtensionRegistryLite
        //   119: astore_2
        //   120: iconst_0
        //   121: istore #4
        //   123: iload #4
        //   125: ifne -> 267
        //   128: aload_1
        //   129: invokevirtual readTag : ()I
        //   132: istore #5
        //   134: iload #5
        //   136: ifeq -> 211
        //   139: iload #5
        //   141: bipush #8
        //   143: if_icmpeq -> 190
        //   146: iload #5
        //   148: bipush #16
        //   150: if_icmpeq -> 169
        //   153: aload_0
        //   154: iload #5
        //   156: aload_1
        //   157: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
        //   160: ifne -> 123
        //   163: iconst_1
        //   164: istore #4
        //   166: goto -> 123
        //   169: aload_0
        //   170: aload_0
        //   171: getfield bitField0_ : I
        //   174: iconst_2
        //   175: ior
        //   176: putfield bitField0_ : I
        //   179: aload_0
        //   180: aload_1
        //   181: invokevirtual readUInt64 : ()J
        //   184: putfield participationLevel_ : J
        //   187: goto -> 123
        //   190: aload_0
        //   191: aload_0
        //   192: getfield bitField0_ : I
        //   195: iconst_1
        //   196: ior
        //   197: putfield bitField0_ : I
        //   200: aload_0
        //   201: aload_1
        //   202: invokevirtual readUInt64 : ()J
        //   205: putfield userControls_ : J
        //   208: goto -> 123
        //   211: iconst_1
        //   212: istore #4
        //   214: goto -> 123
        //   217: astore_1
        //   218: goto -> 265
        //   221: astore_2
        //   222: new java/lang/RuntimeException
        //   225: astore_1
        //   226: new com/google/protobuf/InvalidProtocolBufferException
        //   229: astore_3
        //   230: aload_3
        //   231: aload_2
        //   232: invokevirtual getMessage : ()Ljava/lang/String;
        //   235: invokespecial <init> : (Ljava/lang/String;)V
        //   238: aload_1
        //   239: aload_3
        //   240: aload_0
        //   241: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
        //   244: invokespecial <init> : (Ljava/lang/Throwable;)V
        //   247: aload_1
        //   248: athrow
        //   249: astore_1
        //   250: new java/lang/RuntimeException
        //   253: astore_2
        //   254: aload_2
        //   255: aload_1
        //   256: aload_0
        //   257: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
        //   260: invokespecial <init> : (Ljava/lang/Throwable;)V
        //   263: aload_2
        //   264: athrow
        //   265: aload_1
        //   266: athrow
        //   267: getstatic analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo;
        //   270: areturn
        //   271: aload_2
        //   272: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
        //   275: astore_1
        //   276: aload_3
        //   277: checkcast analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo
        //   280: astore_2
        //   281: aload_0
        //   282: aload_1
        //   283: aload_0
        //   284: invokevirtual hasUserControls : ()Z
        //   287: aload_0
        //   288: getfield userControls_ : J
        //   291: aload_2
        //   292: invokevirtual hasUserControls : ()Z
        //   295: aload_2
        //   296: getfield userControls_ : J
        //   299: invokeinterface visitLong : (ZJZJ)J
        //   304: putfield userControls_ : J
        //   307: aload_0
        //   308: aload_1
        //   309: aload_0
        //   310: invokevirtual hasParticipationLevel : ()Z
        //   313: aload_0
        //   314: getfield participationLevel_ : J
        //   317: aload_2
        //   318: invokevirtual hasParticipationLevel : ()Z
        //   321: aload_2
        //   322: getfield participationLevel_ : J
        //   325: invokeinterface visitLong : (ZJZJ)J
        //   330: putfield participationLevel_ : J
        //   333: aload_1
        //   334: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
        //   337: if_acmpne -> 353
        //   340: aload_0
        //   341: aload_0
        //   342: getfield bitField0_ : I
        //   345: aload_2
        //   346: getfield bitField0_ : I
        //   349: ior
        //   350: putfield bitField0_ : I
        //   353: aload_0
        //   354: areturn
        //   355: new analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo$Builder
        //   358: dup
        //   359: aconst_null
        //   360: invokespecial <init> : (Lanalytics_collection/GmpMeasurement$1;)V
        //   363: areturn
        //   364: aconst_null
        //   365: areturn
        //   366: getstatic analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo;
        //   369: areturn
        //   370: new analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo
        //   373: dup
        //   374: invokespecial <init> : ()V
        //   377: areturn
        // Exception table:
        //   from	to	target	type
        //   73	94	100	finally
        //   94	97	100	finally
        //   101	104	100	finally
        //   128	134	249	com/google/protobuf/InvalidProtocolBufferException
        //   128	134	221	java/io/IOException
        //   128	134	217	finally
        //   153	163	249	com/google/protobuf/InvalidProtocolBufferException
        //   153	163	221	java/io/IOException
        //   153	163	217	finally
        //   169	187	249	com/google/protobuf/InvalidProtocolBufferException
        //   169	187	221	java/io/IOException
        //   169	187	217	finally
        //   190	208	249	com/google/protobuf/InvalidProtocolBufferException
        //   190	208	221	java/io/IOException
        //   190	208	217	finally
        //   222	249	217	finally
        //   250	265	217	finally
      }
      
      public long getParticipationLevel() {
        return this.participationLevel_;
      }
      
      public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1)
          return i; 
        i = 0;
        if ((this.bitField0_ & 0x1) == 1)
          i = 0 + CodedOutputStream.computeUInt64Size(1, this.userControls_); 
        int j = i;
        if ((this.bitField0_ & 0x2) == 2)
          j = i + CodedOutputStream.computeUInt64Size(2, this.participationLevel_); 
        i = j + this.unknownFields.getSerializedSize();
        this.memoizedSerializedSize = i;
        return i;
      }
      
      public long getUserControls() {
        return this.userControls_;
      }
      
      public boolean hasParticipationLevel() {
        boolean bool;
        if ((this.bitField0_ & 0x2) == 2) {
          bool = true;
        } else {
          bool = false;
        } 
        return bool;
      }
      
      public boolean hasUserControls() {
        int i = this.bitField0_;
        boolean bool = true;
        if ((i & 0x1) != 1)
          bool = false; 
        return bool;
      }
      
      public void writeTo(CodedOutputStream param2CodedOutputStream) throws IOException {
        if ((this.bitField0_ & 0x1) == 1)
          param2CodedOutputStream.writeUInt64(1, this.userControls_); 
        if ((this.bitField0_ & 0x2) == 2)
          param2CodedOutputStream.writeUInt64(2, this.participationLevel_); 
        this.unknownFields.writeTo(param2CodedOutputStream);
      }
      
      public static final class Builder extends GeneratedMessageLite.Builder<LoggedLowLevelPrivacyInfo, Builder> implements GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfoOrBuilder {
        private Builder() {
          super(GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo.DEFAULT_INSTANCE);
        }
        
        public Builder clearParticipationLevel() {
          copyOnWrite();
          ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).clearParticipationLevel();
          return this;
        }
        
        public Builder clearUserControls() {
          copyOnWrite();
          ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).clearUserControls();
          return this;
        }
        
        public long getParticipationLevel() {
          return ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).getParticipationLevel();
        }
        
        public long getUserControls() {
          return ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).getUserControls();
        }
        
        public boolean hasParticipationLevel() {
          return ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).hasParticipationLevel();
        }
        
        public boolean hasUserControls() {
          return ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).hasUserControls();
        }
        
        public Builder setParticipationLevel(long param3Long) {
          copyOnWrite();
          ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).setParticipationLevel(param3Long);
          return this;
        }
        
        public Builder setUserControls(long param3Long) {
          copyOnWrite();
          ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).setUserControls(param3Long);
          return this;
        }
      }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<LoggedLowLevelPrivacyInfo, LoggedLowLevelPrivacyInfo.Builder> implements LoggedLowLevelPrivacyInfoOrBuilder {
      private Builder() {
        super(GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo.DEFAULT_INSTANCE);
      }
      
      public Builder clearParticipationLevel() {
        copyOnWrite();
        ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).clearParticipationLevel();
        return this;
      }
      
      public Builder clearUserControls() {
        copyOnWrite();
        ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).clearUserControls();
        return this;
      }
      
      public long getParticipationLevel() {
        return ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).getParticipationLevel();
      }
      
      public long getUserControls() {
        return ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).getUserControls();
      }
      
      public boolean hasParticipationLevel() {
        return ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).hasParticipationLevel();
      }
      
      public boolean hasUserControls() {
        return ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).hasUserControls();
      }
      
      public Builder setParticipationLevel(long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).setParticipationLevel(param2Long);
        return this;
      }
      
      public Builder setUserControls(long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).setUserControls(param2Long);
        return this;
      }
    }
    
    public static interface LoggedLowLevelPrivacyInfoOrBuilder extends MessageLiteOrBuilder {
      long getParticipationLevel();
      
      long getUserControls();
      
      boolean hasParticipationLevel();
      
      boolean hasUserControls();
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<GaiaInfo, GaiaInfo.Builder> implements GaiaInfoOrBuilder {
    private Builder() {
      super(GmpMeasurement.GaiaInfo.DEFAULT_INSTANCE);
    }
    
    public Builder clearEncryptedGaiaIdRequiresPrivacyReview() {
      copyOnWrite();
      ((GmpMeasurement.GaiaInfo)this.instance).clearEncryptedGaiaIdRequiresPrivacyReview();
      return this;
    }
    
    public Builder clearLowLevelInfoRequiresPrivacyReview() {
      copyOnWrite();
      ((GmpMeasurement.GaiaInfo)this.instance).clearLowLevelInfoRequiresPrivacyReview();
      return this;
    }
    
    public Builder clearPrivacyModifiersRequiresPrivacyReview() {
      copyOnWrite();
      ((GmpMeasurement.GaiaInfo)this.instance).clearPrivacyModifiersRequiresPrivacyReview();
      return this;
    }
    
    public Builder clearPublisherPrivacyModifiersRequiresPrivacyReview() {
      copyOnWrite();
      ((GmpMeasurement.GaiaInfo)this.instance).clearPublisherPrivacyModifiersRequiresPrivacyReview();
      return this;
    }
    
    public String getEncryptedGaiaIdRequiresPrivacyReview() {
      return ((GmpMeasurement.GaiaInfo)this.instance).getEncryptedGaiaIdRequiresPrivacyReview();
    }
    
    public ByteString getEncryptedGaiaIdRequiresPrivacyReviewBytes() {
      return ((GmpMeasurement.GaiaInfo)this.instance).getEncryptedGaiaIdRequiresPrivacyReviewBytes();
    }
    
    public GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo getLowLevelInfoRequiresPrivacyReview() {
      return ((GmpMeasurement.GaiaInfo)this.instance).getLowLevelInfoRequiresPrivacyReview();
    }
    
    public long getPrivacyModifiersRequiresPrivacyReview() {
      return ((GmpMeasurement.GaiaInfo)this.instance).getPrivacyModifiersRequiresPrivacyReview();
    }
    
    public long getPublisherPrivacyModifiersRequiresPrivacyReview() {
      return ((GmpMeasurement.GaiaInfo)this.instance).getPublisherPrivacyModifiersRequiresPrivacyReview();
    }
    
    public boolean hasEncryptedGaiaIdRequiresPrivacyReview() {
      return ((GmpMeasurement.GaiaInfo)this.instance).hasEncryptedGaiaIdRequiresPrivacyReview();
    }
    
    public boolean hasLowLevelInfoRequiresPrivacyReview() {
      return ((GmpMeasurement.GaiaInfo)this.instance).hasLowLevelInfoRequiresPrivacyReview();
    }
    
    public boolean hasPrivacyModifiersRequiresPrivacyReview() {
      return ((GmpMeasurement.GaiaInfo)this.instance).hasPrivacyModifiersRequiresPrivacyReview();
    }
    
    public boolean hasPublisherPrivacyModifiersRequiresPrivacyReview() {
      return ((GmpMeasurement.GaiaInfo)this.instance).hasPublisherPrivacyModifiersRequiresPrivacyReview();
    }
    
    public Builder mergeLowLevelInfoRequiresPrivacyReview(GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo param1LoggedLowLevelPrivacyInfo) {
      copyOnWrite();
      ((GmpMeasurement.GaiaInfo)this.instance).mergeLowLevelInfoRequiresPrivacyReview(param1LoggedLowLevelPrivacyInfo);
      return this;
    }
    
    public Builder setEncryptedGaiaIdRequiresPrivacyReview(String param1String) {
      copyOnWrite();
      ((GmpMeasurement.GaiaInfo)this.instance).setEncryptedGaiaIdRequiresPrivacyReview(param1String);
      return this;
    }
    
    public Builder setEncryptedGaiaIdRequiresPrivacyReviewBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurement.GaiaInfo)this.instance).setEncryptedGaiaIdRequiresPrivacyReviewBytes(param1ByteString);
      return this;
    }
    
    public Builder setLowLevelInfoRequiresPrivacyReview(GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.GaiaInfo)this.instance).setLowLevelInfoRequiresPrivacyReview(param1Builder);
      return this;
    }
    
    public Builder setLowLevelInfoRequiresPrivacyReview(GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo param1LoggedLowLevelPrivacyInfo) {
      copyOnWrite();
      ((GmpMeasurement.GaiaInfo)this.instance).setLowLevelInfoRequiresPrivacyReview(param1LoggedLowLevelPrivacyInfo);
      return this;
    }
    
    public Builder setPrivacyModifiersRequiresPrivacyReview(long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.GaiaInfo)this.instance).setPrivacyModifiersRequiresPrivacyReview(param1Long);
      return this;
    }
    
    public Builder setPublisherPrivacyModifiersRequiresPrivacyReview(long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.GaiaInfo)this.instance).setPublisherPrivacyModifiersRequiresPrivacyReview(param1Long);
      return this;
    }
  }
  
  public static final class LoggedLowLevelPrivacyInfo extends GeneratedMessageLite<GaiaInfo.LoggedLowLevelPrivacyInfo, GaiaInfo.LoggedLowLevelPrivacyInfo.Builder> implements GaiaInfo.LoggedLowLevelPrivacyInfoOrBuilder {
    private static final LoggedLowLevelPrivacyInfo DEFAULT_INSTANCE = new LoggedLowLevelPrivacyInfo();
    
    private static volatile Parser<LoggedLowLevelPrivacyInfo> PARSER;
    
    public static final int PARTICIPATION_LEVEL_FIELD_NUMBER = 2;
    
    public static final int USER_CONTROLS_FIELD_NUMBER = 1;
    
    private int bitField0_;
    
    private long participationLevel_;
    
    private long userControls_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearParticipationLevel() {
      this.bitField0_ &= 0xFFFFFFFD;
      this.participationLevel_ = 0L;
    }
    
    private void clearUserControls() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.userControls_ = 0L;
    }
    
    public static LoggedLowLevelPrivacyInfo getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(LoggedLowLevelPrivacyInfo param1LoggedLowLevelPrivacyInfo) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1LoggedLowLevelPrivacyInfo);
    }
    
    public static LoggedLowLevelPrivacyInfo parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (LoggedLowLevelPrivacyInfo)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static LoggedLowLevelPrivacyInfo parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LoggedLowLevelPrivacyInfo)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LoggedLowLevelPrivacyInfo parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static LoggedLowLevelPrivacyInfo parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static LoggedLowLevelPrivacyInfo parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static LoggedLowLevelPrivacyInfo parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static LoggedLowLevelPrivacyInfo parseFrom(InputStream param1InputStream) throws IOException {
      return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static LoggedLowLevelPrivacyInfo parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LoggedLowLevelPrivacyInfo parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static LoggedLowLevelPrivacyInfo parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<LoggedLowLevelPrivacyInfo> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setParticipationLevel(long param1Long) {
      this.bitField0_ |= 0x2;
      this.participationLevel_ = param1Long;
    }
    
    private void setUserControls(long param1Long) {
      this.bitField0_ |= 0x1;
      this.userControls_ = param1Long;
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic analytics_collection/GmpMeasurement$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 370, 2 -> 366, 3 -> 364, 4 -> 355, 5 -> 271, 6 -> 110, 7 -> 267, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo
      //   72: monitorenter
      //   73: getstatic analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo.PARSER : Lcom/google/protobuf/Parser;
      //   109: areturn
      //   110: aload_2
      //   111: checkcast com/google/protobuf/CodedInputStream
      //   114: astore_1
      //   115: aload_3
      //   116: checkcast com/google/protobuf/ExtensionRegistryLite
      //   119: astore_2
      //   120: iconst_0
      //   121: istore #4
      //   123: iload #4
      //   125: ifne -> 267
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 211
      //   139: iload #5
      //   141: bipush #8
      //   143: if_icmpeq -> 190
      //   146: iload #5
      //   148: bipush #16
      //   150: if_icmpeq -> 169
      //   153: aload_0
      //   154: iload #5
      //   156: aload_1
      //   157: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   160: ifne -> 123
      //   163: iconst_1
      //   164: istore #4
      //   166: goto -> 123
      //   169: aload_0
      //   170: aload_0
      //   171: getfield bitField0_ : I
      //   174: iconst_2
      //   175: ior
      //   176: putfield bitField0_ : I
      //   179: aload_0
      //   180: aload_1
      //   181: invokevirtual readUInt64 : ()J
      //   184: putfield participationLevel_ : J
      //   187: goto -> 123
      //   190: aload_0
      //   191: aload_0
      //   192: getfield bitField0_ : I
      //   195: iconst_1
      //   196: ior
      //   197: putfield bitField0_ : I
      //   200: aload_0
      //   201: aload_1
      //   202: invokevirtual readUInt64 : ()J
      //   205: putfield userControls_ : J
      //   208: goto -> 123
      //   211: iconst_1
      //   212: istore #4
      //   214: goto -> 123
      //   217: astore_1
      //   218: goto -> 265
      //   221: astore_2
      //   222: new java/lang/RuntimeException
      //   225: astore_1
      //   226: new com/google/protobuf/InvalidProtocolBufferException
      //   229: astore_3
      //   230: aload_3
      //   231: aload_2
      //   232: invokevirtual getMessage : ()Ljava/lang/String;
      //   235: invokespecial <init> : (Ljava/lang/String;)V
      //   238: aload_1
      //   239: aload_3
      //   240: aload_0
      //   241: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   244: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   247: aload_1
      //   248: athrow
      //   249: astore_1
      //   250: new java/lang/RuntimeException
      //   253: astore_2
      //   254: aload_2
      //   255: aload_1
      //   256: aload_0
      //   257: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   260: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   263: aload_2
      //   264: athrow
      //   265: aload_1
      //   266: athrow
      //   267: getstatic analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo;
      //   270: areturn
      //   271: aload_2
      //   272: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   275: astore_1
      //   276: aload_3
      //   277: checkcast analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo
      //   280: astore_2
      //   281: aload_0
      //   282: aload_1
      //   283: aload_0
      //   284: invokevirtual hasUserControls : ()Z
      //   287: aload_0
      //   288: getfield userControls_ : J
      //   291: aload_2
      //   292: invokevirtual hasUserControls : ()Z
      //   295: aload_2
      //   296: getfield userControls_ : J
      //   299: invokeinterface visitLong : (ZJZJ)J
      //   304: putfield userControls_ : J
      //   307: aload_0
      //   308: aload_1
      //   309: aload_0
      //   310: invokevirtual hasParticipationLevel : ()Z
      //   313: aload_0
      //   314: getfield participationLevel_ : J
      //   317: aload_2
      //   318: invokevirtual hasParticipationLevel : ()Z
      //   321: aload_2
      //   322: getfield participationLevel_ : J
      //   325: invokeinterface visitLong : (ZJZJ)J
      //   330: putfield participationLevel_ : J
      //   333: aload_1
      //   334: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   337: if_acmpne -> 353
      //   340: aload_0
      //   341: aload_0
      //   342: getfield bitField0_ : I
      //   345: aload_2
      //   346: getfield bitField0_ : I
      //   349: ior
      //   350: putfield bitField0_ : I
      //   353: aload_0
      //   354: areturn
      //   355: new analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo$Builder
      //   358: dup
      //   359: aconst_null
      //   360: invokespecial <init> : (Lanalytics_collection/GmpMeasurement$1;)V
      //   363: areturn
      //   364: aconst_null
      //   365: areturn
      //   366: getstatic analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo;
      //   369: areturn
      //   370: new analytics_collection/GmpMeasurement$GaiaInfo$LoggedLowLevelPrivacyInfo
      //   373: dup
      //   374: invokespecial <init> : ()V
      //   377: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	249	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	221	java/io/IOException
      //   128	134	217	finally
      //   153	163	249	com/google/protobuf/InvalidProtocolBufferException
      //   153	163	221	java/io/IOException
      //   153	163	217	finally
      //   169	187	249	com/google/protobuf/InvalidProtocolBufferException
      //   169	187	221	java/io/IOException
      //   169	187	217	finally
      //   190	208	249	com/google/protobuf/InvalidProtocolBufferException
      //   190	208	221	java/io/IOException
      //   190	208	217	finally
      //   222	249	217	finally
      //   250	265	217	finally
    }
    
    public long getParticipationLevel() {
      return this.participationLevel_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if ((this.bitField0_ & 0x1) == 1)
        i = 0 + CodedOutputStream.computeUInt64Size(1, this.userControls_); 
      int j = i;
      if ((this.bitField0_ & 0x2) == 2)
        j = i + CodedOutputStream.computeUInt64Size(2, this.participationLevel_); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public long getUserControls() {
      return this.userControls_;
    }
    
    public boolean hasParticipationLevel() {
      boolean bool;
      if ((this.bitField0_ & 0x2) == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasUserControls() {
      int i = this.bitField0_;
      boolean bool = true;
      if ((i & 0x1) != 1)
        bool = false; 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if ((this.bitField0_ & 0x1) == 1)
        param1CodedOutputStream.writeUInt64(1, this.userControls_); 
      if ((this.bitField0_ & 0x2) == 2)
        param1CodedOutputStream.writeUInt64(2, this.participationLevel_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<LoggedLowLevelPrivacyInfo, Builder> implements GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfoOrBuilder {
      private Builder() {
        super(GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo.DEFAULT_INSTANCE);
      }
      
      public Builder clearParticipationLevel() {
        copyOnWrite();
        ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).clearParticipationLevel();
        return this;
      }
      
      public Builder clearUserControls() {
        copyOnWrite();
        ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).clearUserControls();
        return this;
      }
      
      public long getParticipationLevel() {
        return ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).getParticipationLevel();
      }
      
      public long getUserControls() {
        return ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).getUserControls();
      }
      
      public boolean hasParticipationLevel() {
        return ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).hasParticipationLevel();
      }
      
      public boolean hasUserControls() {
        return ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).hasUserControls();
      }
      
      public Builder setParticipationLevel(long param3Long) {
        copyOnWrite();
        ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).setParticipationLevel(param3Long);
        return this;
      }
      
      public Builder setUserControls(long param3Long) {
        copyOnWrite();
        ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).setUserControls(param3Long);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<GaiaInfo.LoggedLowLevelPrivacyInfo, GaiaInfo.LoggedLowLevelPrivacyInfo.Builder> implements GaiaInfo.LoggedLowLevelPrivacyInfoOrBuilder {
    private Builder() {
      super(GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo.DEFAULT_INSTANCE);
    }
    
    public Builder clearParticipationLevel() {
      copyOnWrite();
      ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).clearParticipationLevel();
      return this;
    }
    
    public Builder clearUserControls() {
      copyOnWrite();
      ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).clearUserControls();
      return this;
    }
    
    public long getParticipationLevel() {
      return ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).getParticipationLevel();
    }
    
    public long getUserControls() {
      return ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).getUserControls();
    }
    
    public boolean hasParticipationLevel() {
      return ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).hasParticipationLevel();
    }
    
    public boolean hasUserControls() {
      return ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).hasUserControls();
    }
    
    public Builder setParticipationLevel(long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).setParticipationLevel(param1Long);
      return this;
    }
    
    public Builder setUserControls(long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo)this.instance).setUserControls(param1Long);
      return this;
    }
  }
  
  public static interface LoggedLowLevelPrivacyInfoOrBuilder extends MessageLiteOrBuilder {
    long getParticipationLevel();
    
    long getUserControls();
    
    boolean hasParticipationLevel();
    
    boolean hasUserControls();
  }
  
  public static interface GaiaInfoOrBuilder extends MessageLiteOrBuilder {
    String getEncryptedGaiaIdRequiresPrivacyReview();
    
    ByteString getEncryptedGaiaIdRequiresPrivacyReviewBytes();
    
    GmpMeasurement.GaiaInfo.LoggedLowLevelPrivacyInfo getLowLevelInfoRequiresPrivacyReview();
    
    long getPrivacyModifiersRequiresPrivacyReview();
    
    long getPublisherPrivacyModifiersRequiresPrivacyReview();
    
    boolean hasEncryptedGaiaIdRequiresPrivacyReview();
    
    boolean hasLowLevelInfoRequiresPrivacyReview();
    
    boolean hasPrivacyModifiersRequiresPrivacyReview();
    
    boolean hasPublisherPrivacyModifiersRequiresPrivacyReview();
  }
  
  public static final class MeasurementBatch extends GeneratedMessageLite<MeasurementBatch, MeasurementBatch.Builder> implements MeasurementBatchOrBuilder {
    public static final int API_REQUESTS_FIELD_NUMBER = 2;
    
    public static final int BUNDLES_FIELD_NUMBER = 1;
    
    private static final MeasurementBatch DEFAULT_INSTANCE = new MeasurementBatch();
    
    private static volatile Parser<MeasurementBatch> PARSER;
    
    private Internal.ProtobufList<GmpMeasurementPublic.FirebaseAnalyticsApiRequest> apiRequests_ = emptyProtobufList();
    
    private Internal.ProtobufList<GmpMeasurement.MeasurementBundle> bundles_ = emptyProtobufList();
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllApiRequests(Iterable<? extends GmpMeasurementPublic.FirebaseAnalyticsApiRequest> param1Iterable) {
      ensureApiRequestsIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.apiRequests_);
    }
    
    private void addAllBundles(Iterable<? extends GmpMeasurement.MeasurementBundle> param1Iterable) {
      ensureBundlesIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.bundles_);
    }
    
    private void addApiRequests(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsApiRequest.Builder param1Builder) {
      ensureApiRequestsIsMutable();
      this.apiRequests_.add(param1Int, param1Builder.build());
    }
    
    private void addApiRequests(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsApiRequest param1FirebaseAnalyticsApiRequest) {
      if (param1FirebaseAnalyticsApiRequest != null) {
        ensureApiRequestsIsMutable();
        this.apiRequests_.add(param1Int, param1FirebaseAnalyticsApiRequest);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addApiRequests(GmpMeasurementPublic.FirebaseAnalyticsApiRequest.Builder param1Builder) {
      ensureApiRequestsIsMutable();
      this.apiRequests_.add(param1Builder.build());
    }
    
    private void addApiRequests(GmpMeasurementPublic.FirebaseAnalyticsApiRequest param1FirebaseAnalyticsApiRequest) {
      if (param1FirebaseAnalyticsApiRequest != null) {
        ensureApiRequestsIsMutable();
        this.apiRequests_.add(param1FirebaseAnalyticsApiRequest);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addBundles(int param1Int, GmpMeasurement.MeasurementBundle.Builder param1Builder) {
      ensureBundlesIsMutable();
      this.bundles_.add(param1Int, param1Builder.build());
    }
    
    private void addBundles(int param1Int, GmpMeasurement.MeasurementBundle param1MeasurementBundle) {
      if (param1MeasurementBundle != null) {
        ensureBundlesIsMutable();
        this.bundles_.add(param1Int, param1MeasurementBundle);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addBundles(GmpMeasurement.MeasurementBundle.Builder param1Builder) {
      ensureBundlesIsMutable();
      this.bundles_.add(param1Builder.build());
    }
    
    private void addBundles(GmpMeasurement.MeasurementBundle param1MeasurementBundle) {
      if (param1MeasurementBundle != null) {
        ensureBundlesIsMutable();
        this.bundles_.add(param1MeasurementBundle);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearApiRequests() {
      this.apiRequests_ = emptyProtobufList();
    }
    
    private void clearBundles() {
      this.bundles_ = emptyProtobufList();
    }
    
    private void ensureApiRequestsIsMutable() {
      if (!this.apiRequests_.isModifiable())
        this.apiRequests_ = GeneratedMessageLite.mutableCopy(this.apiRequests_); 
    }
    
    private void ensureBundlesIsMutable() {
      if (!this.bundles_.isModifiable())
        this.bundles_ = GeneratedMessageLite.mutableCopy(this.bundles_); 
    }
    
    public static MeasurementBatch getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(MeasurementBatch param1MeasurementBatch) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1MeasurementBatch);
    }
    
    public static MeasurementBatch parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (MeasurementBatch)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static MeasurementBatch parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (MeasurementBatch)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static MeasurementBatch parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (MeasurementBatch)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static MeasurementBatch parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (MeasurementBatch)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static MeasurementBatch parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (MeasurementBatch)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static MeasurementBatch parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (MeasurementBatch)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static MeasurementBatch parseFrom(InputStream param1InputStream) throws IOException {
      return (MeasurementBatch)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static MeasurementBatch parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (MeasurementBatch)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static MeasurementBatch parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (MeasurementBatch)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static MeasurementBatch parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (MeasurementBatch)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<MeasurementBatch> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeApiRequests(int param1Int) {
      ensureApiRequestsIsMutable();
      this.apiRequests_.remove(param1Int);
    }
    
    private void removeBundles(int param1Int) {
      ensureBundlesIsMutable();
      this.bundles_.remove(param1Int);
    }
    
    private void setApiRequests(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsApiRequest.Builder param1Builder) {
      ensureApiRequestsIsMutable();
      this.apiRequests_.set(param1Int, param1Builder.build());
    }
    
    private void setApiRequests(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsApiRequest param1FirebaseAnalyticsApiRequest) {
      if (param1FirebaseAnalyticsApiRequest != null) {
        ensureApiRequestsIsMutable();
        this.apiRequests_.set(param1Int, param1FirebaseAnalyticsApiRequest);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setBundles(int param1Int, GmpMeasurement.MeasurementBundle.Builder param1Builder) {
      ensureBundlesIsMutable();
      this.bundles_.set(param1Int, param1Builder.build());
    }
    
    private void setBundles(int param1Int, GmpMeasurement.MeasurementBundle param1MeasurementBundle) {
      if (param1MeasurementBundle != null) {
        ensureBundlesIsMutable();
        this.bundles_.set(param1Int, param1MeasurementBundle);
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic analytics_collection/GmpMeasurement$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 408, 2 -> 404, 3 -> 384, 4 -> 375, 5 -> 323, 6 -> 110, 7 -> 319, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic analytics_collection/GmpMeasurement$MeasurementBatch.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc analytics_collection/GmpMeasurement$MeasurementBatch
      //   72: monitorenter
      //   73: getstatic analytics_collection/GmpMeasurement$MeasurementBatch.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic analytics_collection/GmpMeasurement$MeasurementBatch.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$MeasurementBatch;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic analytics_collection/GmpMeasurement$MeasurementBatch.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc analytics_collection/GmpMeasurement$MeasurementBatch
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc analytics_collection/GmpMeasurement$MeasurementBatch
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic analytics_collection/GmpMeasurement$MeasurementBatch.PARSER : Lcom/google/protobuf/Parser;
      //   109: areturn
      //   110: aload_2
      //   111: checkcast com/google/protobuf/CodedInputStream
      //   114: astore_1
      //   115: aload_3
      //   116: checkcast com/google/protobuf/ExtensionRegistryLite
      //   119: astore_2
      //   120: iconst_0
      //   121: istore #4
      //   123: iload #4
      //   125: ifne -> 319
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 263
      //   139: iload #5
      //   141: bipush #10
      //   143: if_icmpeq -> 216
      //   146: iload #5
      //   148: bipush #18
      //   150: if_icmpeq -> 169
      //   153: aload_0
      //   154: iload #5
      //   156: aload_1
      //   157: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   160: ifne -> 123
      //   163: iconst_1
      //   164: istore #4
      //   166: goto -> 123
      //   169: aload_0
      //   170: getfield apiRequests_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   173: invokeinterface isModifiable : ()Z
      //   178: ifne -> 192
      //   181: aload_0
      //   182: aload_0
      //   183: getfield apiRequests_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   186: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   189: putfield apiRequests_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   192: aload_0
      //   193: getfield apiRequests_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   196: aload_1
      //   197: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   200: aload_2
      //   201: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   204: checkcast analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsApiRequest
      //   207: invokeinterface add : (Ljava/lang/Object;)Z
      //   212: pop
      //   213: goto -> 123
      //   216: aload_0
      //   217: getfield bundles_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   220: invokeinterface isModifiable : ()Z
      //   225: ifne -> 239
      //   228: aload_0
      //   229: aload_0
      //   230: getfield bundles_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   233: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   236: putfield bundles_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   239: aload_0
      //   240: getfield bundles_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   243: aload_1
      //   244: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   247: aload_2
      //   248: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   251: checkcast analytics_collection/GmpMeasurement$MeasurementBundle
      //   254: invokeinterface add : (Ljava/lang/Object;)Z
      //   259: pop
      //   260: goto -> 123
      //   263: iconst_1
      //   264: istore #4
      //   266: goto -> 123
      //   269: astore_1
      //   270: goto -> 317
      //   273: astore_3
      //   274: new java/lang/RuntimeException
      //   277: astore_2
      //   278: new com/google/protobuf/InvalidProtocolBufferException
      //   281: astore_1
      //   282: aload_1
      //   283: aload_3
      //   284: invokevirtual getMessage : ()Ljava/lang/String;
      //   287: invokespecial <init> : (Ljava/lang/String;)V
      //   290: aload_2
      //   291: aload_1
      //   292: aload_0
      //   293: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   296: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   299: aload_2
      //   300: athrow
      //   301: astore_2
      //   302: new java/lang/RuntimeException
      //   305: astore_1
      //   306: aload_1
      //   307: aload_2
      //   308: aload_0
      //   309: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   312: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   315: aload_1
      //   316: athrow
      //   317: aload_1
      //   318: athrow
      //   319: getstatic analytics_collection/GmpMeasurement$MeasurementBatch.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$MeasurementBatch;
      //   322: areturn
      //   323: aload_2
      //   324: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   327: astore_1
      //   328: aload_3
      //   329: checkcast analytics_collection/GmpMeasurement$MeasurementBatch
      //   332: astore_2
      //   333: aload_0
      //   334: aload_1
      //   335: aload_0
      //   336: getfield bundles_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   339: aload_2
      //   340: getfield bundles_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   343: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   348: putfield bundles_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   351: aload_0
      //   352: aload_1
      //   353: aload_0
      //   354: getfield apiRequests_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   357: aload_2
      //   358: getfield apiRequests_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   361: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   366: putfield apiRequests_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   369: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   372: astore_1
      //   373: aload_0
      //   374: areturn
      //   375: new analytics_collection/GmpMeasurement$MeasurementBatch$Builder
      //   378: dup
      //   379: aconst_null
      //   380: invokespecial <init> : (Lanalytics_collection/GmpMeasurement$1;)V
      //   383: areturn
      //   384: aload_0
      //   385: getfield bundles_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   388: invokeinterface makeImmutable : ()V
      //   393: aload_0
      //   394: getfield apiRequests_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   397: invokeinterface makeImmutable : ()V
      //   402: aconst_null
      //   403: areturn
      //   404: getstatic analytics_collection/GmpMeasurement$MeasurementBatch.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$MeasurementBatch;
      //   407: areturn
      //   408: new analytics_collection/GmpMeasurement$MeasurementBatch
      //   411: dup
      //   412: invokespecial <init> : ()V
      //   415: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	301	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	273	java/io/IOException
      //   128	134	269	finally
      //   153	163	301	com/google/protobuf/InvalidProtocolBufferException
      //   153	163	273	java/io/IOException
      //   153	163	269	finally
      //   169	192	301	com/google/protobuf/InvalidProtocolBufferException
      //   169	192	273	java/io/IOException
      //   169	192	269	finally
      //   192	213	301	com/google/protobuf/InvalidProtocolBufferException
      //   192	213	273	java/io/IOException
      //   192	213	269	finally
      //   216	239	301	com/google/protobuf/InvalidProtocolBufferException
      //   216	239	273	java/io/IOException
      //   216	239	269	finally
      //   239	260	301	com/google/protobuf/InvalidProtocolBufferException
      //   239	260	273	java/io/IOException
      //   239	260	269	finally
      //   274	301	269	finally
      //   302	317	269	finally
    }
    
    public GmpMeasurementPublic.FirebaseAnalyticsApiRequest getApiRequests(int param1Int) {
      return (GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.apiRequests_.get(param1Int);
    }
    
    public int getApiRequestsCount() {
      return this.apiRequests_.size();
    }
    
    public List<GmpMeasurementPublic.FirebaseAnalyticsApiRequest> getApiRequestsList() {
      return (List<GmpMeasurementPublic.FirebaseAnalyticsApiRequest>)this.apiRequests_;
    }
    
    public GmpMeasurementPublic.FirebaseAnalyticsApiRequestOrBuilder getApiRequestsOrBuilder(int param1Int) {
      return (GmpMeasurementPublic.FirebaseAnalyticsApiRequestOrBuilder)this.apiRequests_.get(param1Int);
    }
    
    public List<? extends GmpMeasurementPublic.FirebaseAnalyticsApiRequestOrBuilder> getApiRequestsOrBuilderList() {
      return (List)this.apiRequests_;
    }
    
    public GmpMeasurement.MeasurementBundle getBundles(int param1Int) {
      return (GmpMeasurement.MeasurementBundle)this.bundles_.get(param1Int);
    }
    
    public int getBundlesCount() {
      return this.bundles_.size();
    }
    
    public List<GmpMeasurement.MeasurementBundle> getBundlesList() {
      return (List<GmpMeasurement.MeasurementBundle>)this.bundles_;
    }
    
    public GmpMeasurement.MeasurementBundleOrBuilder getBundlesOrBuilder(int param1Int) {
      return (GmpMeasurement.MeasurementBundleOrBuilder)this.bundles_.get(param1Int);
    }
    
    public List<? extends GmpMeasurement.MeasurementBundleOrBuilder> getBundlesOrBuilderList() {
      return (List)this.bundles_;
    }
    
    public int getSerializedSize() {
      byte b3;
      int j;
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      byte b1 = 0;
      byte b2 = 0;
      i = 0;
      while (true) {
        b3 = b1;
        j = i;
        if (b2 < this.bundles_.size()) {
          i += CodedOutputStream.computeMessageSize(1, (MessageLite)this.bundles_.get(b2));
          b2++;
          continue;
        } 
        break;
      } 
      while (b3 < this.apiRequests_.size()) {
        j += CodedOutputStream.computeMessageSize(2, (MessageLite)this.apiRequests_.get(b3));
        b3++;
      } 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      byte b3;
      byte b1 = 0;
      byte b2 = 0;
      while (true) {
        b3 = b1;
        if (b2 < this.bundles_.size()) {
          param1CodedOutputStream.writeMessage(1, (MessageLite)this.bundles_.get(b2));
          b2++;
          continue;
        } 
        break;
      } 
      while (b3 < this.apiRequests_.size()) {
        param1CodedOutputStream.writeMessage(2, (MessageLite)this.apiRequests_.get(b3));
        b3++;
      } 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<MeasurementBatch, Builder> implements GmpMeasurement.MeasurementBatchOrBuilder {
      private Builder() {
        super(GmpMeasurement.MeasurementBatch.DEFAULT_INSTANCE);
      }
      
      public Builder addAllApiRequests(Iterable<? extends GmpMeasurementPublic.FirebaseAnalyticsApiRequest> param2Iterable) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBatch)this.instance).addAllApiRequests(param2Iterable);
        return this;
      }
      
      public Builder addAllBundles(Iterable<? extends GmpMeasurement.MeasurementBundle> param2Iterable) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBatch)this.instance).addAllBundles(param2Iterable);
        return this;
      }
      
      public Builder addApiRequests(int param2Int, GmpMeasurementPublic.FirebaseAnalyticsApiRequest.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBatch)this.instance).addApiRequests(param2Int, param2Builder);
        return this;
      }
      
      public Builder addApiRequests(int param2Int, GmpMeasurementPublic.FirebaseAnalyticsApiRequest param2FirebaseAnalyticsApiRequest) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBatch)this.instance).addApiRequests(param2Int, param2FirebaseAnalyticsApiRequest);
        return this;
      }
      
      public Builder addApiRequests(GmpMeasurementPublic.FirebaseAnalyticsApiRequest.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBatch)this.instance).addApiRequests(param2Builder);
        return this;
      }
      
      public Builder addApiRequests(GmpMeasurementPublic.FirebaseAnalyticsApiRequest param2FirebaseAnalyticsApiRequest) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBatch)this.instance).addApiRequests(param2FirebaseAnalyticsApiRequest);
        return this;
      }
      
      public Builder addBundles(int param2Int, GmpMeasurement.MeasurementBundle.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBatch)this.instance).addBundles(param2Int, param2Builder);
        return this;
      }
      
      public Builder addBundles(int param2Int, GmpMeasurement.MeasurementBundle param2MeasurementBundle) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBatch)this.instance).addBundles(param2Int, param2MeasurementBundle);
        return this;
      }
      
      public Builder addBundles(GmpMeasurement.MeasurementBundle.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBatch)this.instance).addBundles(param2Builder);
        return this;
      }
      
      public Builder addBundles(GmpMeasurement.MeasurementBundle param2MeasurementBundle) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBatch)this.instance).addBundles(param2MeasurementBundle);
        return this;
      }
      
      public Builder clearApiRequests() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBatch)this.instance).clearApiRequests();
        return this;
      }
      
      public Builder clearBundles() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBatch)this.instance).clearBundles();
        return this;
      }
      
      public GmpMeasurementPublic.FirebaseAnalyticsApiRequest getApiRequests(int param2Int) {
        return ((GmpMeasurement.MeasurementBatch)this.instance).getApiRequests(param2Int);
      }
      
      public int getApiRequestsCount() {
        return ((GmpMeasurement.MeasurementBatch)this.instance).getApiRequestsCount();
      }
      
      public List<GmpMeasurementPublic.FirebaseAnalyticsApiRequest> getApiRequestsList() {
        return Collections.unmodifiableList(((GmpMeasurement.MeasurementBatch)this.instance).getApiRequestsList());
      }
      
      public GmpMeasurement.MeasurementBundle getBundles(int param2Int) {
        return ((GmpMeasurement.MeasurementBatch)this.instance).getBundles(param2Int);
      }
      
      public int getBundlesCount() {
        return ((GmpMeasurement.MeasurementBatch)this.instance).getBundlesCount();
      }
      
      public List<GmpMeasurement.MeasurementBundle> getBundlesList() {
        return Collections.unmodifiableList(((GmpMeasurement.MeasurementBatch)this.instance).getBundlesList());
      }
      
      public Builder removeApiRequests(int param2Int) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBatch)this.instance).removeApiRequests(param2Int);
        return this;
      }
      
      public Builder removeBundles(int param2Int) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBatch)this.instance).removeBundles(param2Int);
        return this;
      }
      
      public Builder setApiRequests(int param2Int, GmpMeasurementPublic.FirebaseAnalyticsApiRequest.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBatch)this.instance).setApiRequests(param2Int, param2Builder);
        return this;
      }
      
      public Builder setApiRequests(int param2Int, GmpMeasurementPublic.FirebaseAnalyticsApiRequest param2FirebaseAnalyticsApiRequest) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBatch)this.instance).setApiRequests(param2Int, param2FirebaseAnalyticsApiRequest);
        return this;
      }
      
      public Builder setBundles(int param2Int, GmpMeasurement.MeasurementBundle.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBatch)this.instance).setBundles(param2Int, param2Builder);
        return this;
      }
      
      public Builder setBundles(int param2Int, GmpMeasurement.MeasurementBundle param2MeasurementBundle) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBatch)this.instance).setBundles(param2Int, param2MeasurementBundle);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<MeasurementBatch, MeasurementBatch.Builder> implements MeasurementBatchOrBuilder {
    private Builder() {
      super(GmpMeasurement.MeasurementBatch.DEFAULT_INSTANCE);
    }
    
    public Builder addAllApiRequests(Iterable<? extends GmpMeasurementPublic.FirebaseAnalyticsApiRequest> param1Iterable) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBatch)this.instance).addAllApiRequests(param1Iterable);
      return this;
    }
    
    public Builder addAllBundles(Iterable<? extends GmpMeasurement.MeasurementBundle> param1Iterable) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBatch)this.instance).addAllBundles(param1Iterable);
      return this;
    }
    
    public Builder addApiRequests(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsApiRequest.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBatch)this.instance).addApiRequests(param1Int, param1Builder);
      return this;
    }
    
    public Builder addApiRequests(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsApiRequest param1FirebaseAnalyticsApiRequest) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBatch)this.instance).addApiRequests(param1Int, param1FirebaseAnalyticsApiRequest);
      return this;
    }
    
    public Builder addApiRequests(GmpMeasurementPublic.FirebaseAnalyticsApiRequest.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBatch)this.instance).addApiRequests(param1Builder);
      return this;
    }
    
    public Builder addApiRequests(GmpMeasurementPublic.FirebaseAnalyticsApiRequest param1FirebaseAnalyticsApiRequest) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBatch)this.instance).addApiRequests(param1FirebaseAnalyticsApiRequest);
      return this;
    }
    
    public Builder addBundles(int param1Int, GmpMeasurement.MeasurementBundle.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBatch)this.instance).addBundles(param1Int, param1Builder);
      return this;
    }
    
    public Builder addBundles(int param1Int, GmpMeasurement.MeasurementBundle param1MeasurementBundle) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBatch)this.instance).addBundles(param1Int, param1MeasurementBundle);
      return this;
    }
    
    public Builder addBundles(GmpMeasurement.MeasurementBundle.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBatch)this.instance).addBundles(param1Builder);
      return this;
    }
    
    public Builder addBundles(GmpMeasurement.MeasurementBundle param1MeasurementBundle) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBatch)this.instance).addBundles(param1MeasurementBundle);
      return this;
    }
    
    public Builder clearApiRequests() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBatch)this.instance).clearApiRequests();
      return this;
    }
    
    public Builder clearBundles() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBatch)this.instance).clearBundles();
      return this;
    }
    
    public GmpMeasurementPublic.FirebaseAnalyticsApiRequest getApiRequests(int param1Int) {
      return ((GmpMeasurement.MeasurementBatch)this.instance).getApiRequests(param1Int);
    }
    
    public int getApiRequestsCount() {
      return ((GmpMeasurement.MeasurementBatch)this.instance).getApiRequestsCount();
    }
    
    public List<GmpMeasurementPublic.FirebaseAnalyticsApiRequest> getApiRequestsList() {
      return Collections.unmodifiableList(((GmpMeasurement.MeasurementBatch)this.instance).getApiRequestsList());
    }
    
    public GmpMeasurement.MeasurementBundle getBundles(int param1Int) {
      return ((GmpMeasurement.MeasurementBatch)this.instance).getBundles(param1Int);
    }
    
    public int getBundlesCount() {
      return ((GmpMeasurement.MeasurementBatch)this.instance).getBundlesCount();
    }
    
    public List<GmpMeasurement.MeasurementBundle> getBundlesList() {
      return Collections.unmodifiableList(((GmpMeasurement.MeasurementBatch)this.instance).getBundlesList());
    }
    
    public Builder removeApiRequests(int param1Int) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBatch)this.instance).removeApiRequests(param1Int);
      return this;
    }
    
    public Builder removeBundles(int param1Int) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBatch)this.instance).removeBundles(param1Int);
      return this;
    }
    
    public Builder setApiRequests(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsApiRequest.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBatch)this.instance).setApiRequests(param1Int, param1Builder);
      return this;
    }
    
    public Builder setApiRequests(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsApiRequest param1FirebaseAnalyticsApiRequest) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBatch)this.instance).setApiRequests(param1Int, param1FirebaseAnalyticsApiRequest);
      return this;
    }
    
    public Builder setBundles(int param1Int, GmpMeasurement.MeasurementBundle.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBatch)this.instance).setBundles(param1Int, param1Builder);
      return this;
    }
    
    public Builder setBundles(int param1Int, GmpMeasurement.MeasurementBundle param1MeasurementBundle) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBatch)this.instance).setBundles(param1Int, param1MeasurementBundle);
      return this;
    }
  }
  
  public static interface MeasurementBatchOrBuilder extends MessageLiteOrBuilder {
    GmpMeasurementPublic.FirebaseAnalyticsApiRequest getApiRequests(int param1Int);
    
    int getApiRequestsCount();
    
    List<GmpMeasurementPublic.FirebaseAnalyticsApiRequest> getApiRequestsList();
    
    GmpMeasurement.MeasurementBundle getBundles(int param1Int);
    
    int getBundlesCount();
    
    List<GmpMeasurement.MeasurementBundle> getBundlesList();
  }
  
  public static final class MeasurementBundle extends GeneratedMessageLite<MeasurementBundle, MeasurementBundle.Builder> implements MeasurementBundleOrBuilder {
    public static final int ADMOB_APP_ID_FIELD_NUMBER = 41;
    
    public static final int APP_ID_FIELD_NUMBER = 14;
    
    public static final int APP_ID_NUMERIC_FIELD_NUMBER = 15;
    
    public static final int APP_INSTANCE_ID_FIELD_NUMBER = 21;
    
    public static final int APP_STORE_FIELD_NUMBER = 13;
    
    public static final int APP_VERSION_FIELD_NUMBER = 16;
    
    public static final int APP_VERSION_MAJOR_FIELD_NUMBER = 31;
    
    public static final int APP_VERSION_MINOR_FIELD_NUMBER = 32;
    
    public static final int APP_VERSION_RELEASE_FIELD_NUMBER = 33;
    
    public static final int AUDIENCE_EVALUATION_RESULTS_FIELD_NUMBER = 29;
    
    public static final int BUNDLE_ALSO_LOGGED_IN_GAIA_FIELD_NUMBER = 42;
    
    public static final int BUNDLE_SEQUENTIAL_INDEX_FIELD_NUMBER = 23;
    
    public static final int CONFIG_VERSION_FIELD_NUMBER = 35;
    
    private static final MeasurementBundle DEFAULT_INSTANCE = new MeasurementBundle();
    
    public static final int DEVICE_MODEL_FIELD_NUMBER = 10;
    
    public static final int DEV_CERT_HASH_FIELD_NUMBER = 22;
    
    public static final int DSID_FIELD_NUMBER = 37;
    
    public static final int END_TIMESTAMP_MILLIS_FIELD_NUMBER = 6;
    
    public static final int EVENTS_FIELD_NUMBER = 2;
    
    public static final int EXTERNAL_STREAM_ID_FIELD_NUMBER = 38;
    
    public static final int FIREBASE_INSTANCE_ID_FIELD_NUMBER = 30;
    
    public static final int GAIA_INFO_FIELD_NUMBER = 40;
    
    public static final int GMP_APP_ID_FIELD_NUMBER = 25;
    
    public static final int GMP_VERSION_FIELD_NUMBER = 17;
    
    public static final int HEALTH_MONITOR_FIELD_NUMBER = 24;
    
    public static final int LIMITED_AD_TRACKING_FIELD_NUMBER = 20;
    
    public static final int OS_VERSION_FIELD_NUMBER = 9;
    
    private static volatile Parser<MeasurementBundle> PARSER;
    
    public static final int PLATFORM_FIELD_NUMBER = 8;
    
    public static final int PREVIOUS_BUNDLE_END_TIMESTAMP_MILLIS_FIELD_NUMBER = 7;
    
    public static final int PREVIOUS_BUNDLE_START_TIMESTAMP_MILLIS_FIELD_NUMBER = 26;
    
    public static final int PROTOCOL_VERSION_FIELD_NUMBER = 1;
    
    public static final int PSEUDONYMOUS_PRIVACY_INFO_REQUIRES_PRIVACY_REVIEW_FIELD_NUMBER = 43;
    
    public static final int RESETTABLE_DEVICE_ID_FIELD_NUMBER = 19;
    
    public static final int RETRY_COUNTER_FIELD_NUMBER = 39;
    
    public static final int SERVICE_UPLOAD_FIELD_NUMBER = 28;
    
    public static final int SSAID_FIELD_NUMBER = 34;
    
    public static final int START_TIMESTAMP_MILLIS_FIELD_NUMBER = 5;
    
    public static final int TIME_ZONE_OFFSET_MINUTES_FIELD_NUMBER = 12;
    
    public static final int UPLOADING_GMP_VERSION_FIELD_NUMBER = 18;
    
    public static final int UPLOAD_TIMESTAMP_MILLIS_FIELD_NUMBER = 4;
    
    public static final int USER_ATTRIBUTES_FIELD_NUMBER = 3;
    
    public static final int USER_DEFAULT_LANGUAGE_FIELD_NUMBER = 11;
    
    public static final int VENDOR_DEVICE_ID_FIELD_NUMBER = 27;
    
    private String admobAppId_ = "";
    
    private long appIdNumeric_;
    
    private String appId_ = "";
    
    private String appInstanceId_ = "";
    
    private String appStore_ = "";
    
    private int appVersionMajor_;
    
    private int appVersionMinor_;
    
    private int appVersionRelease_;
    
    private String appVersion_ = "";
    
    private Internal.ProtobufList<GmpMeasurement.AudienceLeafFilterResult> audienceEvaluationResults_ = emptyProtobufList();
    
    private int bitField0_;
    
    private int bitField1_;
    
    private boolean bundleAlsoLoggedInGaia_;
    
    private int bundleSequentialIndex_;
    
    private long configVersion_;
    
    private long devCertHash_;
    
    private String deviceModel_ = "";
    
    private String dsid_ = "";
    
    private long endTimestampMillis_;
    
    private Internal.ProtobufList<GmpMeasurement.Event> events_ = emptyProtobufList();
    
    private String externalStreamId_ = "";
    
    private String firebaseInstanceId_ = "";
    
    private GmpMeasurement.GaiaInfo gaiaInfo_;
    
    private String gmpAppId_ = "";
    
    private long gmpVersion_;
    
    private String healthMonitor_ = "";
    
    private boolean limitedAdTracking_;
    
    private String osVersion_ = "";
    
    private String platform_ = "";
    
    private long previousBundleEndTimestampMillis_;
    
    private long previousBundleStartTimestampMillis_;
    
    private int protocolVersion_;
    
    private GmpMeasurement.PseudonymousPrivacyInfo pseudonymousPrivacyInfoRequiresPrivacyReview_;
    
    private String resettableDeviceId_ = "";
    
    private int retryCounter_;
    
    private boolean serviceUpload_;
    
    private String ssaid_ = "";
    
    private long startTimestampMillis_;
    
    private int timeZoneOffsetMinutes_;
    
    private long uploadTimestampMillis_;
    
    private long uploadingGmpVersion_;
    
    private Internal.ProtobufList<GmpMeasurement.UserAttribute> userAttributes_ = emptyProtobufList();
    
    private String userDefaultLanguage_ = "";
    
    private String vendorDeviceId_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllAudienceEvaluationResults(Iterable<? extends GmpMeasurement.AudienceLeafFilterResult> param1Iterable) {
      ensureAudienceEvaluationResultsIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.audienceEvaluationResults_);
    }
    
    private void addAllEvents(Iterable<? extends GmpMeasurement.Event> param1Iterable) {
      ensureEventsIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.events_);
    }
    
    private void addAllUserAttributes(Iterable<? extends GmpMeasurement.UserAttribute> param1Iterable) {
      ensureUserAttributesIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.userAttributes_);
    }
    
    private void addAudienceEvaluationResults(int param1Int, GmpMeasurement.AudienceLeafFilterResult.Builder param1Builder) {
      ensureAudienceEvaluationResultsIsMutable();
      this.audienceEvaluationResults_.add(param1Int, param1Builder.build());
    }
    
    private void addAudienceEvaluationResults(int param1Int, GmpMeasurement.AudienceLeafFilterResult param1AudienceLeafFilterResult) {
      if (param1AudienceLeafFilterResult != null) {
        ensureAudienceEvaluationResultsIsMutable();
        this.audienceEvaluationResults_.add(param1Int, param1AudienceLeafFilterResult);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addAudienceEvaluationResults(GmpMeasurement.AudienceLeafFilterResult.Builder param1Builder) {
      ensureAudienceEvaluationResultsIsMutable();
      this.audienceEvaluationResults_.add(param1Builder.build());
    }
    
    private void addAudienceEvaluationResults(GmpMeasurement.AudienceLeafFilterResult param1AudienceLeafFilterResult) {
      if (param1AudienceLeafFilterResult != null) {
        ensureAudienceEvaluationResultsIsMutable();
        this.audienceEvaluationResults_.add(param1AudienceLeafFilterResult);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addEvents(int param1Int, GmpMeasurement.Event.Builder param1Builder) {
      ensureEventsIsMutable();
      this.events_.add(param1Int, param1Builder.build());
    }
    
    private void addEvents(int param1Int, GmpMeasurement.Event param1Event) {
      if (param1Event != null) {
        ensureEventsIsMutable();
        this.events_.add(param1Int, param1Event);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addEvents(GmpMeasurement.Event.Builder param1Builder) {
      ensureEventsIsMutable();
      this.events_.add(param1Builder.build());
    }
    
    private void addEvents(GmpMeasurement.Event param1Event) {
      if (param1Event != null) {
        ensureEventsIsMutable();
        this.events_.add(param1Event);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addUserAttributes(int param1Int, GmpMeasurement.UserAttribute.Builder param1Builder) {
      ensureUserAttributesIsMutable();
      this.userAttributes_.add(param1Int, param1Builder.build());
    }
    
    private void addUserAttributes(int param1Int, GmpMeasurement.UserAttribute param1UserAttribute) {
      if (param1UserAttribute != null) {
        ensureUserAttributesIsMutable();
        this.userAttributes_.add(param1Int, param1UserAttribute);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addUserAttributes(GmpMeasurement.UserAttribute.Builder param1Builder) {
      ensureUserAttributesIsMutable();
      this.userAttributes_.add(param1Builder.build());
    }
    
    private void addUserAttributes(GmpMeasurement.UserAttribute param1UserAttribute) {
      if (param1UserAttribute != null) {
        ensureUserAttributesIsMutable();
        this.userAttributes_.add(param1UserAttribute);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearAdmobAppId() {
      this.bitField1_ &= 0xFFFFFFEF;
      this.admobAppId_ = getDefaultInstance().getAdmobAppId();
    }
    
    private void clearAppId() {
      this.bitField0_ &= 0xFFFFEFFF;
      this.appId_ = getDefaultInstance().getAppId();
    }
    
    private void clearAppIdNumeric() {
      this.bitField0_ &= 0xFFFFDFFF;
      this.appIdNumeric_ = 0L;
    }
    
    private void clearAppInstanceId() {
      this.bitField0_ &= 0xFFEFFFFF;
      this.appInstanceId_ = getDefaultInstance().getAppInstanceId();
    }
    
    private void clearAppStore() {
      this.bitField0_ &= 0xFFFFF7FF;
      this.appStore_ = getDefaultInstance().getAppStore();
    }
    
    private void clearAppVersion() {
      this.bitField0_ &= 0xFFFFBFFF;
      this.appVersion_ = getDefaultInstance().getAppVersion();
    }
    
    private void clearAppVersionMajor() {
      this.bitField0_ &= 0xF7FFFFFF;
      this.appVersionMajor_ = 0;
    }
    
    private void clearAppVersionMinor() {
      this.bitField0_ &= 0xEFFFFFFF;
      this.appVersionMinor_ = 0;
    }
    
    private void clearAppVersionRelease() {
      this.bitField0_ &= 0xDFFFFFFF;
      this.appVersionRelease_ = 0;
    }
    
    private void clearAudienceEvaluationResults() {
      this.audienceEvaluationResults_ = emptyProtobufList();
    }
    
    private void clearBundleAlsoLoggedInGaia() {
      this.bitField1_ &= 0xFFFFFFDF;
      this.bundleAlsoLoggedInGaia_ = false;
    }
    
    private void clearBundleSequentialIndex() {
      this.bitField0_ &= 0xFFBFFFFF;
      this.bundleSequentialIndex_ = 0;
    }
    
    private void clearConfigVersion() {
      this.bitField0_ &= Integer.MAX_VALUE;
      this.configVersion_ = 0L;
    }
    
    private void clearDevCertHash() {
      this.bitField0_ &= 0xFFDFFFFF;
      this.devCertHash_ = 0L;
    }
    
    private void clearDeviceModel() {
      this.bitField0_ &= 0xFFFFFEFF;
      this.deviceModel_ = getDefaultInstance().getDeviceModel();
    }
    
    private void clearDsid() {
      this.bitField1_ &= 0xFFFFFFFE;
      this.dsid_ = getDefaultInstance().getDsid();
    }
    
    private void clearEndTimestampMillis() {
      this.bitField0_ &= 0xFFFFFFF7;
      this.endTimestampMillis_ = 0L;
    }
    
    private void clearEvents() {
      this.events_ = emptyProtobufList();
    }
    
    private void clearExternalStreamId() {
      this.bitField1_ &= 0xFFFFFFFD;
      this.externalStreamId_ = getDefaultInstance().getExternalStreamId();
    }
    
    private void clearFirebaseInstanceId() {
      this.bitField0_ &= 0xFBFFFFFF;
      this.firebaseInstanceId_ = getDefaultInstance().getFirebaseInstanceId();
    }
    
    private void clearGaiaInfo() {
      this.gaiaInfo_ = null;
      this.bitField1_ &= 0xFFFFFFF7;
    }
    
    private void clearGmpAppId() {
      this.bitField0_ &= 0xFEFFFFFF;
      this.gmpAppId_ = getDefaultInstance().getGmpAppId();
    }
    
    private void clearGmpVersion() {
      this.bitField0_ &= 0xFFFF7FFF;
      this.gmpVersion_ = 0L;
    }
    
    private void clearHealthMonitor() {
      this.bitField0_ &= 0xFF7FFFFF;
      this.healthMonitor_ = getDefaultInstance().getHealthMonitor();
    }
    
    private void clearLimitedAdTracking() {
      this.bitField0_ &= 0xFFF7FFFF;
      this.limitedAdTracking_ = false;
    }
    
    private void clearOsVersion() {
      this.bitField0_ &= 0xFFFFFF7F;
      this.osVersion_ = getDefaultInstance().getOsVersion();
    }
    
    private void clearPlatform() {
      this.bitField0_ &= 0xFFFFFFBF;
      this.platform_ = getDefaultInstance().getPlatform();
    }
    
    private void clearPreviousBundleEndTimestampMillis() {
      this.bitField0_ &= 0xFFFFFFDF;
      this.previousBundleEndTimestampMillis_ = 0L;
    }
    
    private void clearPreviousBundleStartTimestampMillis() {
      this.bitField0_ &= 0xFFFFFFEF;
      this.previousBundleStartTimestampMillis_ = 0L;
    }
    
    private void clearProtocolVersion() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.protocolVersion_ = 0;
    }
    
    private void clearPseudonymousPrivacyInfoRequiresPrivacyReview() {
      this.pseudonymousPrivacyInfoRequiresPrivacyReview_ = null;
      this.bitField1_ &= 0xFFFFFFBF;
    }
    
    private void clearResettableDeviceId() {
      this.bitField0_ &= 0xFFFDFFFF;
      this.resettableDeviceId_ = getDefaultInstance().getResettableDeviceId();
    }
    
    private void clearRetryCounter() {
      this.bitField1_ &= 0xFFFFFFFB;
      this.retryCounter_ = 0;
    }
    
    private void clearServiceUpload() {
      this.bitField0_ &= 0xFDFFFFFF;
      this.serviceUpload_ = false;
    }
    
    private void clearSsaid() {
      this.bitField0_ &= 0xBFFFFFFF;
      this.ssaid_ = getDefaultInstance().getSsaid();
    }
    
    private void clearStartTimestampMillis() {
      this.bitField0_ &= 0xFFFFFFFB;
      this.startTimestampMillis_ = 0L;
    }
    
    private void clearTimeZoneOffsetMinutes() {
      this.bitField0_ &= 0xFFFFFBFF;
      this.timeZoneOffsetMinutes_ = 0;
    }
    
    private void clearUploadTimestampMillis() {
      this.bitField0_ &= 0xFFFFFFFD;
      this.uploadTimestampMillis_ = 0L;
    }
    
    private void clearUploadingGmpVersion() {
      this.bitField0_ &= 0xFFFEFFFF;
      this.uploadingGmpVersion_ = 0L;
    }
    
    private void clearUserAttributes() {
      this.userAttributes_ = emptyProtobufList();
    }
    
    private void clearUserDefaultLanguage() {
      this.bitField0_ &= 0xFFFFFDFF;
      this.userDefaultLanguage_ = getDefaultInstance().getUserDefaultLanguage();
    }
    
    private void clearVendorDeviceId() {
      this.bitField0_ &= 0xFFFBFFFF;
      this.vendorDeviceId_ = getDefaultInstance().getVendorDeviceId();
    }
    
    private void ensureAudienceEvaluationResultsIsMutable() {
      if (!this.audienceEvaluationResults_.isModifiable())
        this.audienceEvaluationResults_ = GeneratedMessageLite.mutableCopy(this.audienceEvaluationResults_); 
    }
    
    private void ensureEventsIsMutable() {
      if (!this.events_.isModifiable())
        this.events_ = GeneratedMessageLite.mutableCopy(this.events_); 
    }
    
    private void ensureUserAttributesIsMutable() {
      if (!this.userAttributes_.isModifiable())
        this.userAttributes_ = GeneratedMessageLite.mutableCopy(this.userAttributes_); 
    }
    
    public static MeasurementBundle getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeGaiaInfo(GmpMeasurement.GaiaInfo param1GaiaInfo) {
      GmpMeasurement.GaiaInfo gaiaInfo = this.gaiaInfo_;
      if (gaiaInfo != null && gaiaInfo != GmpMeasurement.GaiaInfo.getDefaultInstance()) {
        this.gaiaInfo_ = (GmpMeasurement.GaiaInfo)((GmpMeasurement.GaiaInfo.Builder)GmpMeasurement.GaiaInfo.newBuilder(this.gaiaInfo_).mergeFrom(param1GaiaInfo)).buildPartial();
      } else {
        this.gaiaInfo_ = param1GaiaInfo;
      } 
      this.bitField1_ |= 0x8;
    }
    
    private void mergePseudonymousPrivacyInfoRequiresPrivacyReview(GmpMeasurement.PseudonymousPrivacyInfo param1PseudonymousPrivacyInfo) {
      GmpMeasurement.PseudonymousPrivacyInfo pseudonymousPrivacyInfo = this.pseudonymousPrivacyInfoRequiresPrivacyReview_;
      if (pseudonymousPrivacyInfo != null && pseudonymousPrivacyInfo != GmpMeasurement.PseudonymousPrivacyInfo.getDefaultInstance()) {
        this.pseudonymousPrivacyInfoRequiresPrivacyReview_ = (GmpMeasurement.PseudonymousPrivacyInfo)((GmpMeasurement.PseudonymousPrivacyInfo.Builder)GmpMeasurement.PseudonymousPrivacyInfo.newBuilder(this.pseudonymousPrivacyInfoRequiresPrivacyReview_).mergeFrom(param1PseudonymousPrivacyInfo)).buildPartial();
      } else {
        this.pseudonymousPrivacyInfoRequiresPrivacyReview_ = param1PseudonymousPrivacyInfo;
      } 
      this.bitField1_ |= 0x40;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(MeasurementBundle param1MeasurementBundle) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1MeasurementBundle);
    }
    
    public static MeasurementBundle parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (MeasurementBundle)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static MeasurementBundle parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (MeasurementBundle)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static MeasurementBundle parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (MeasurementBundle)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static MeasurementBundle parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (MeasurementBundle)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static MeasurementBundle parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (MeasurementBundle)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static MeasurementBundle parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (MeasurementBundle)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static MeasurementBundle parseFrom(InputStream param1InputStream) throws IOException {
      return (MeasurementBundle)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static MeasurementBundle parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (MeasurementBundle)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static MeasurementBundle parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (MeasurementBundle)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static MeasurementBundle parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (MeasurementBundle)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<MeasurementBundle> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeAudienceEvaluationResults(int param1Int) {
      ensureAudienceEvaluationResultsIsMutable();
      this.audienceEvaluationResults_.remove(param1Int);
    }
    
    private void removeEvents(int param1Int) {
      ensureEventsIsMutable();
      this.events_.remove(param1Int);
    }
    
    private void removeUserAttributes(int param1Int) {
      ensureUserAttributesIsMutable();
      this.userAttributes_.remove(param1Int);
    }
    
    private void setAdmobAppId(String param1String) {
      if (param1String != null) {
        this.bitField1_ |= 0x10;
        this.admobAppId_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAdmobAppIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField1_ |= 0x10;
        this.admobAppId_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAppId(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x1000;
        this.appId_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAppIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x1000;
        this.appId_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAppIdNumeric(long param1Long) {
      this.bitField0_ |= 0x2000;
      this.appIdNumeric_ = param1Long;
    }
    
    private void setAppInstanceId(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x100000;
        this.appInstanceId_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAppInstanceIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x100000;
        this.appInstanceId_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAppStore(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x800;
        this.appStore_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAppStoreBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x800;
        this.appStore_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAppVersion(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x4000;
        this.appVersion_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAppVersionBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x4000;
        this.appVersion_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAppVersionMajor(int param1Int) {
      this.bitField0_ |= 0x8000000;
      this.appVersionMajor_ = param1Int;
    }
    
    private void setAppVersionMinor(int param1Int) {
      this.bitField0_ |= 0x10000000;
      this.appVersionMinor_ = param1Int;
    }
    
    private void setAppVersionRelease(int param1Int) {
      this.bitField0_ |= 0x20000000;
      this.appVersionRelease_ = param1Int;
    }
    
    private void setAudienceEvaluationResults(int param1Int, GmpMeasurement.AudienceLeafFilterResult.Builder param1Builder) {
      ensureAudienceEvaluationResultsIsMutable();
      this.audienceEvaluationResults_.set(param1Int, param1Builder.build());
    }
    
    private void setAudienceEvaluationResults(int param1Int, GmpMeasurement.AudienceLeafFilterResult param1AudienceLeafFilterResult) {
      if (param1AudienceLeafFilterResult != null) {
        ensureAudienceEvaluationResultsIsMutable();
        this.audienceEvaluationResults_.set(param1Int, param1AudienceLeafFilterResult);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setBundleAlsoLoggedInGaia(boolean param1Boolean) {
      this.bitField1_ |= 0x20;
      this.bundleAlsoLoggedInGaia_ = param1Boolean;
    }
    
    private void setBundleSequentialIndex(int param1Int) {
      this.bitField0_ |= 0x400000;
      this.bundleSequentialIndex_ = param1Int;
    }
    
    private void setConfigVersion(long param1Long) {
      this.bitField0_ |= Integer.MIN_VALUE;
      this.configVersion_ = param1Long;
    }
    
    private void setDevCertHash(long param1Long) {
      this.bitField0_ |= 0x200000;
      this.devCertHash_ = param1Long;
    }
    
    private void setDeviceModel(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x100;
        this.deviceModel_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setDeviceModelBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x100;
        this.deviceModel_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setDsid(String param1String) {
      if (param1String != null) {
        this.bitField1_ |= 0x1;
        this.dsid_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setDsidBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField1_ |= 0x1;
        this.dsid_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setEndTimestampMillis(long param1Long) {
      this.bitField0_ |= 0x8;
      this.endTimestampMillis_ = param1Long;
    }
    
    private void setEvents(int param1Int, GmpMeasurement.Event.Builder param1Builder) {
      ensureEventsIsMutable();
      this.events_.set(param1Int, param1Builder.build());
    }
    
    private void setEvents(int param1Int, GmpMeasurement.Event param1Event) {
      if (param1Event != null) {
        ensureEventsIsMutable();
        this.events_.set(param1Int, param1Event);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setExternalStreamId(String param1String) {
      if (param1String != null) {
        this.bitField1_ |= 0x2;
        this.externalStreamId_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setExternalStreamIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField1_ |= 0x2;
        this.externalStreamId_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setFirebaseInstanceId(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x4000000;
        this.firebaseInstanceId_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setFirebaseInstanceIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x4000000;
        this.firebaseInstanceId_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setGaiaInfo(GmpMeasurement.GaiaInfo.Builder param1Builder) {
      this.gaiaInfo_ = (GmpMeasurement.GaiaInfo)param1Builder.build();
      this.bitField1_ |= 0x8;
    }
    
    private void setGaiaInfo(GmpMeasurement.GaiaInfo param1GaiaInfo) {
      if (param1GaiaInfo != null) {
        this.gaiaInfo_ = param1GaiaInfo;
        this.bitField1_ |= 0x8;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setGmpAppId(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x1000000;
        this.gmpAppId_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setGmpAppIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x1000000;
        this.gmpAppId_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setGmpVersion(long param1Long) {
      this.bitField0_ |= 0x8000;
      this.gmpVersion_ = param1Long;
    }
    
    private void setHealthMonitor(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x800000;
        this.healthMonitor_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setHealthMonitorBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x800000;
        this.healthMonitor_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setLimitedAdTracking(boolean param1Boolean) {
      this.bitField0_ |= 0x80000;
      this.limitedAdTracking_ = param1Boolean;
    }
    
    private void setOsVersion(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x80;
        this.osVersion_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setOsVersionBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x80;
        this.osVersion_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setPlatform(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x40;
        this.platform_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setPlatformBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x40;
        this.platform_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setPreviousBundleEndTimestampMillis(long param1Long) {
      this.bitField0_ |= 0x20;
      this.previousBundleEndTimestampMillis_ = param1Long;
    }
    
    private void setPreviousBundleStartTimestampMillis(long param1Long) {
      this.bitField0_ |= 0x10;
      this.previousBundleStartTimestampMillis_ = param1Long;
    }
    
    private void setProtocolVersion(int param1Int) {
      this.bitField0_ |= 0x1;
      this.protocolVersion_ = param1Int;
    }
    
    private void setPseudonymousPrivacyInfoRequiresPrivacyReview(GmpMeasurement.PseudonymousPrivacyInfo.Builder param1Builder) {
      this.pseudonymousPrivacyInfoRequiresPrivacyReview_ = (GmpMeasurement.PseudonymousPrivacyInfo)param1Builder.build();
      this.bitField1_ |= 0x40;
    }
    
    private void setPseudonymousPrivacyInfoRequiresPrivacyReview(GmpMeasurement.PseudonymousPrivacyInfo param1PseudonymousPrivacyInfo) {
      if (param1PseudonymousPrivacyInfo != null) {
        this.pseudonymousPrivacyInfoRequiresPrivacyReview_ = param1PseudonymousPrivacyInfo;
        this.bitField1_ |= 0x40;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setResettableDeviceId(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x20000;
        this.resettableDeviceId_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setResettableDeviceIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x20000;
        this.resettableDeviceId_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setRetryCounter(int param1Int) {
      this.bitField1_ |= 0x4;
      this.retryCounter_ = param1Int;
    }
    
    private void setServiceUpload(boolean param1Boolean) {
      this.bitField0_ |= 0x2000000;
      this.serviceUpload_ = param1Boolean;
    }
    
    private void setSsaid(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x40000000;
        this.ssaid_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setSsaidBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x40000000;
        this.ssaid_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setStartTimestampMillis(long param1Long) {
      this.bitField0_ |= 0x4;
      this.startTimestampMillis_ = param1Long;
    }
    
    private void setTimeZoneOffsetMinutes(int param1Int) {
      this.bitField0_ |= 0x400;
      this.timeZoneOffsetMinutes_ = param1Int;
    }
    
    private void setUploadTimestampMillis(long param1Long) {
      this.bitField0_ |= 0x2;
      this.uploadTimestampMillis_ = param1Long;
    }
    
    private void setUploadingGmpVersion(long param1Long) {
      this.bitField0_ |= 0x10000;
      this.uploadingGmpVersion_ = param1Long;
    }
    
    private void setUserAttributes(int param1Int, GmpMeasurement.UserAttribute.Builder param1Builder) {
      ensureUserAttributesIsMutable();
      this.userAttributes_.set(param1Int, param1Builder.build());
    }
    
    private void setUserAttributes(int param1Int, GmpMeasurement.UserAttribute param1UserAttribute) {
      if (param1UserAttribute != null) {
        ensureUserAttributesIsMutable();
        this.userAttributes_.set(param1Int, param1UserAttribute);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setUserDefaultLanguage(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x200;
        this.userDefaultLanguage_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setUserDefaultLanguageBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x200;
        this.userDefaultLanguage_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setVendorDeviceId(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x40000;
        this.vendorDeviceId_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setVendorDeviceIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x40000;
        this.vendorDeviceId_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic analytics_collection/GmpMeasurement$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 2890, 2 -> 2886, 3 -> 2857, 4 -> 2848, 5 -> 1745, 6 -> 110, 7 -> 1741, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic analytics_collection/GmpMeasurement$MeasurementBundle.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc analytics_collection/GmpMeasurement$MeasurementBundle
      //   72: monitorenter
      //   73: getstatic analytics_collection/GmpMeasurement$MeasurementBundle.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic analytics_collection/GmpMeasurement$MeasurementBundle.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$MeasurementBundle;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic analytics_collection/GmpMeasurement$MeasurementBundle.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc analytics_collection/GmpMeasurement$MeasurementBundle
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc analytics_collection/GmpMeasurement$MeasurementBundle
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic analytics_collection/GmpMeasurement$MeasurementBundle.PARSER : Lcom/google/protobuf/Parser;
      //   109: areturn
      //   110: aload_2
      //   111: checkcast com/google/protobuf/CodedInputStream
      //   114: astore_2
      //   115: aload_3
      //   116: checkcast com/google/protobuf/ExtensionRegistryLite
      //   119: astore_3
      //   120: iconst_0
      //   121: istore #4
      //   123: iload #4
      //   125: ifne -> 1741
      //   128: aload_2
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: lookupswitch default -> 492, 0 -> 1674, 8 -> 1653, 18 -> 1606, 26 -> 1559, 32 -> 1538, 40 -> 1517, 48 -> 1495, 56 -> 1473, 66 -> 1449, 74 -> 1424, 82 -> 1399, 90 -> 1374, 96 -> 1351, 106 -> 1326, 114 -> 1301, 120 -> 1278, 130 -> 1253, 136 -> 1230, 144 -> 1207, 154 -> 1182, 160 -> 1159, 170 -> 1134, 176 -> 1111, 184 -> 1088, 194 -> 1063, 202 -> 1038, 208 -> 1016, 218 -> 991, 224 -> 968, 234 -> 921, 242 -> 896, 248 -> 873, 256 -> 850, 264 -> 827, 274 -> 802, 280 -> 779, 298 -> 756, 306 -> 733, 312 -> 712, 322 -> 631, 330 -> 607, 336 -> 585, 346 -> 504
      //   492: aload_0
      //   493: iload #5
      //   495: aload_2
      //   496: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   499: istore #6
      //   501: goto -> 1680
      //   504: aload_0
      //   505: getfield bitField1_ : I
      //   508: bipush #64
      //   510: iand
      //   511: bipush #64
      //   513: if_icmpne -> 530
      //   516: aload_0
      //   517: getfield pseudonymousPrivacyInfoRequiresPrivacyReview_ : Lanalytics_collection/GmpMeasurement$PseudonymousPrivacyInfo;
      //   520: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   523: checkcast analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$Builder
      //   526: astore_1
      //   527: goto -> 532
      //   530: aconst_null
      //   531: astore_1
      //   532: aload_0
      //   533: aload_2
      //   534: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   537: aload_3
      //   538: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   541: checkcast analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo
      //   544: putfield pseudonymousPrivacyInfoRequiresPrivacyReview_ : Lanalytics_collection/GmpMeasurement$PseudonymousPrivacyInfo;
      //   547: aload_1
      //   548: ifnull -> 571
      //   551: aload_1
      //   552: aload_0
      //   553: getfield pseudonymousPrivacyInfoRequiresPrivacyReview_ : Lanalytics_collection/GmpMeasurement$PseudonymousPrivacyInfo;
      //   556: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   559: pop
      //   560: aload_0
      //   561: aload_1
      //   562: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   565: checkcast analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo
      //   568: putfield pseudonymousPrivacyInfoRequiresPrivacyReview_ : Lanalytics_collection/GmpMeasurement$PseudonymousPrivacyInfo;
      //   571: aload_0
      //   572: aload_0
      //   573: getfield bitField1_ : I
      //   576: bipush #64
      //   578: ior
      //   579: putfield bitField1_ : I
      //   582: goto -> 123
      //   585: aload_0
      //   586: aload_0
      //   587: getfield bitField1_ : I
      //   590: bipush #32
      //   592: ior
      //   593: putfield bitField1_ : I
      //   596: aload_0
      //   597: aload_2
      //   598: invokevirtual readBool : ()Z
      //   601: putfield bundleAlsoLoggedInGaia_ : Z
      //   604: goto -> 123
      //   607: aload_2
      //   608: invokevirtual readString : ()Ljava/lang/String;
      //   611: astore_1
      //   612: aload_0
      //   613: aload_0
      //   614: getfield bitField1_ : I
      //   617: bipush #16
      //   619: ior
      //   620: putfield bitField1_ : I
      //   623: aload_0
      //   624: aload_1
      //   625: putfield admobAppId_ : Ljava/lang/String;
      //   628: goto -> 123
      //   631: aload_0
      //   632: getfield bitField1_ : I
      //   635: bipush #8
      //   637: iand
      //   638: bipush #8
      //   640: if_icmpne -> 657
      //   643: aload_0
      //   644: getfield gaiaInfo_ : Lanalytics_collection/GmpMeasurement$GaiaInfo;
      //   647: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   650: checkcast analytics_collection/GmpMeasurement$GaiaInfo$Builder
      //   653: astore_1
      //   654: goto -> 659
      //   657: aconst_null
      //   658: astore_1
      //   659: aload_0
      //   660: aload_2
      //   661: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   664: aload_3
      //   665: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   668: checkcast analytics_collection/GmpMeasurement$GaiaInfo
      //   671: putfield gaiaInfo_ : Lanalytics_collection/GmpMeasurement$GaiaInfo;
      //   674: aload_1
      //   675: ifnull -> 698
      //   678: aload_1
      //   679: aload_0
      //   680: getfield gaiaInfo_ : Lanalytics_collection/GmpMeasurement$GaiaInfo;
      //   683: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   686: pop
      //   687: aload_0
      //   688: aload_1
      //   689: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   692: checkcast analytics_collection/GmpMeasurement$GaiaInfo
      //   695: putfield gaiaInfo_ : Lanalytics_collection/GmpMeasurement$GaiaInfo;
      //   698: aload_0
      //   699: aload_0
      //   700: getfield bitField1_ : I
      //   703: bipush #8
      //   705: ior
      //   706: putfield bitField1_ : I
      //   709: goto -> 123
      //   712: aload_0
      //   713: aload_0
      //   714: getfield bitField1_ : I
      //   717: iconst_4
      //   718: ior
      //   719: putfield bitField1_ : I
      //   722: aload_0
      //   723: aload_2
      //   724: invokevirtual readInt32 : ()I
      //   727: putfield retryCounter_ : I
      //   730: goto -> 123
      //   733: aload_2
      //   734: invokevirtual readString : ()Ljava/lang/String;
      //   737: astore_1
      //   738: aload_0
      //   739: aload_0
      //   740: getfield bitField1_ : I
      //   743: iconst_2
      //   744: ior
      //   745: putfield bitField1_ : I
      //   748: aload_0
      //   749: aload_1
      //   750: putfield externalStreamId_ : Ljava/lang/String;
      //   753: goto -> 123
      //   756: aload_2
      //   757: invokevirtual readString : ()Ljava/lang/String;
      //   760: astore_1
      //   761: aload_0
      //   762: aload_0
      //   763: getfield bitField1_ : I
      //   766: iconst_1
      //   767: ior
      //   768: putfield bitField1_ : I
      //   771: aload_0
      //   772: aload_1
      //   773: putfield dsid_ : Ljava/lang/String;
      //   776: goto -> 123
      //   779: aload_0
      //   780: aload_0
      //   781: getfield bitField0_ : I
      //   784: ldc_w -2147483648
      //   787: ior
      //   788: putfield bitField0_ : I
      //   791: aload_0
      //   792: aload_2
      //   793: invokevirtual readInt64 : ()J
      //   796: putfield configVersion_ : J
      //   799: goto -> 123
      //   802: aload_2
      //   803: invokevirtual readString : ()Ljava/lang/String;
      //   806: astore_1
      //   807: aload_0
      //   808: aload_0
      //   809: getfield bitField0_ : I
      //   812: ldc_w 1073741824
      //   815: ior
      //   816: putfield bitField0_ : I
      //   819: aload_0
      //   820: aload_1
      //   821: putfield ssaid_ : Ljava/lang/String;
      //   824: goto -> 123
      //   827: aload_0
      //   828: aload_0
      //   829: getfield bitField0_ : I
      //   832: ldc_w 536870912
      //   835: ior
      //   836: putfield bitField0_ : I
      //   839: aload_0
      //   840: aload_2
      //   841: invokevirtual readInt32 : ()I
      //   844: putfield appVersionRelease_ : I
      //   847: goto -> 123
      //   850: aload_0
      //   851: aload_0
      //   852: getfield bitField0_ : I
      //   855: ldc_w 268435456
      //   858: ior
      //   859: putfield bitField0_ : I
      //   862: aload_0
      //   863: aload_2
      //   864: invokevirtual readInt32 : ()I
      //   867: putfield appVersionMinor_ : I
      //   870: goto -> 123
      //   873: aload_0
      //   874: aload_0
      //   875: getfield bitField0_ : I
      //   878: ldc_w 134217728
      //   881: ior
      //   882: putfield bitField0_ : I
      //   885: aload_0
      //   886: aload_2
      //   887: invokevirtual readInt32 : ()I
      //   890: putfield appVersionMajor_ : I
      //   893: goto -> 123
      //   896: aload_2
      //   897: invokevirtual readString : ()Ljava/lang/String;
      //   900: astore_1
      //   901: aload_0
      //   902: aload_0
      //   903: getfield bitField0_ : I
      //   906: ldc_w 67108864
      //   909: ior
      //   910: putfield bitField0_ : I
      //   913: aload_0
      //   914: aload_1
      //   915: putfield firebaseInstanceId_ : Ljava/lang/String;
      //   918: goto -> 123
      //   921: aload_0
      //   922: getfield audienceEvaluationResults_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   925: invokeinterface isModifiable : ()Z
      //   930: ifne -> 944
      //   933: aload_0
      //   934: aload_0
      //   935: getfield audienceEvaluationResults_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   938: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   941: putfield audienceEvaluationResults_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   944: aload_0
      //   945: getfield audienceEvaluationResults_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   948: aload_2
      //   949: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   952: aload_3
      //   953: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   956: checkcast analytics_collection/GmpMeasurement$AudienceLeafFilterResult
      //   959: invokeinterface add : (Ljava/lang/Object;)Z
      //   964: pop
      //   965: goto -> 123
      //   968: aload_0
      //   969: aload_0
      //   970: getfield bitField0_ : I
      //   973: ldc_w 33554432
      //   976: ior
      //   977: putfield bitField0_ : I
      //   980: aload_0
      //   981: aload_2
      //   982: invokevirtual readBool : ()Z
      //   985: putfield serviceUpload_ : Z
      //   988: goto -> 123
      //   991: aload_2
      //   992: invokevirtual readString : ()Ljava/lang/String;
      //   995: astore_1
      //   996: aload_0
      //   997: aload_0
      //   998: getfield bitField0_ : I
      //   1001: ldc_w 262144
      //   1004: ior
      //   1005: putfield bitField0_ : I
      //   1008: aload_0
      //   1009: aload_1
      //   1010: putfield vendorDeviceId_ : Ljava/lang/String;
      //   1013: goto -> 123
      //   1016: aload_0
      //   1017: aload_0
      //   1018: getfield bitField0_ : I
      //   1021: bipush #16
      //   1023: ior
      //   1024: putfield bitField0_ : I
      //   1027: aload_0
      //   1028: aload_2
      //   1029: invokevirtual readInt64 : ()J
      //   1032: putfield previousBundleStartTimestampMillis_ : J
      //   1035: goto -> 123
      //   1038: aload_2
      //   1039: invokevirtual readString : ()Ljava/lang/String;
      //   1042: astore_1
      //   1043: aload_0
      //   1044: aload_0
      //   1045: getfield bitField0_ : I
      //   1048: ldc_w 16777216
      //   1051: ior
      //   1052: putfield bitField0_ : I
      //   1055: aload_0
      //   1056: aload_1
      //   1057: putfield gmpAppId_ : Ljava/lang/String;
      //   1060: goto -> 123
      //   1063: aload_2
      //   1064: invokevirtual readString : ()Ljava/lang/String;
      //   1067: astore_1
      //   1068: aload_0
      //   1069: aload_0
      //   1070: getfield bitField0_ : I
      //   1073: ldc_w 8388608
      //   1076: ior
      //   1077: putfield bitField0_ : I
      //   1080: aload_0
      //   1081: aload_1
      //   1082: putfield healthMonitor_ : Ljava/lang/String;
      //   1085: goto -> 123
      //   1088: aload_0
      //   1089: aload_0
      //   1090: getfield bitField0_ : I
      //   1093: ldc_w 4194304
      //   1096: ior
      //   1097: putfield bitField0_ : I
      //   1100: aload_0
      //   1101: aload_2
      //   1102: invokevirtual readInt32 : ()I
      //   1105: putfield bundleSequentialIndex_ : I
      //   1108: goto -> 123
      //   1111: aload_0
      //   1112: aload_0
      //   1113: getfield bitField0_ : I
      //   1116: ldc_w 2097152
      //   1119: ior
      //   1120: putfield bitField0_ : I
      //   1123: aload_0
      //   1124: aload_2
      //   1125: invokevirtual readInt64 : ()J
      //   1128: putfield devCertHash_ : J
      //   1131: goto -> 123
      //   1134: aload_2
      //   1135: invokevirtual readString : ()Ljava/lang/String;
      //   1138: astore_1
      //   1139: aload_0
      //   1140: aload_0
      //   1141: getfield bitField0_ : I
      //   1144: ldc_w 1048576
      //   1147: ior
      //   1148: putfield bitField0_ : I
      //   1151: aload_0
      //   1152: aload_1
      //   1153: putfield appInstanceId_ : Ljava/lang/String;
      //   1156: goto -> 123
      //   1159: aload_0
      //   1160: aload_0
      //   1161: getfield bitField0_ : I
      //   1164: ldc_w 524288
      //   1167: ior
      //   1168: putfield bitField0_ : I
      //   1171: aload_0
      //   1172: aload_2
      //   1173: invokevirtual readBool : ()Z
      //   1176: putfield limitedAdTracking_ : Z
      //   1179: goto -> 123
      //   1182: aload_2
      //   1183: invokevirtual readString : ()Ljava/lang/String;
      //   1186: astore_1
      //   1187: aload_0
      //   1188: aload_0
      //   1189: getfield bitField0_ : I
      //   1192: ldc_w 131072
      //   1195: ior
      //   1196: putfield bitField0_ : I
      //   1199: aload_0
      //   1200: aload_1
      //   1201: putfield resettableDeviceId_ : Ljava/lang/String;
      //   1204: goto -> 123
      //   1207: aload_0
      //   1208: aload_0
      //   1209: getfield bitField0_ : I
      //   1212: ldc_w 65536
      //   1215: ior
      //   1216: putfield bitField0_ : I
      //   1219: aload_0
      //   1220: aload_2
      //   1221: invokevirtual readInt64 : ()J
      //   1224: putfield uploadingGmpVersion_ : J
      //   1227: goto -> 123
      //   1230: aload_0
      //   1231: aload_0
      //   1232: getfield bitField0_ : I
      //   1235: ldc_w 32768
      //   1238: ior
      //   1239: putfield bitField0_ : I
      //   1242: aload_0
      //   1243: aload_2
      //   1244: invokevirtual readInt64 : ()J
      //   1247: putfield gmpVersion_ : J
      //   1250: goto -> 123
      //   1253: aload_2
      //   1254: invokevirtual readString : ()Ljava/lang/String;
      //   1257: astore_1
      //   1258: aload_0
      //   1259: aload_0
      //   1260: getfield bitField0_ : I
      //   1263: sipush #16384
      //   1266: ior
      //   1267: putfield bitField0_ : I
      //   1270: aload_0
      //   1271: aload_1
      //   1272: putfield appVersion_ : Ljava/lang/String;
      //   1275: goto -> 123
      //   1278: aload_0
      //   1279: aload_0
      //   1280: getfield bitField0_ : I
      //   1283: sipush #8192
      //   1286: ior
      //   1287: putfield bitField0_ : I
      //   1290: aload_0
      //   1291: aload_2
      //   1292: invokevirtual readInt64 : ()J
      //   1295: putfield appIdNumeric_ : J
      //   1298: goto -> 123
      //   1301: aload_2
      //   1302: invokevirtual readString : ()Ljava/lang/String;
      //   1305: astore_1
      //   1306: aload_0
      //   1307: aload_0
      //   1308: getfield bitField0_ : I
      //   1311: sipush #4096
      //   1314: ior
      //   1315: putfield bitField0_ : I
      //   1318: aload_0
      //   1319: aload_1
      //   1320: putfield appId_ : Ljava/lang/String;
      //   1323: goto -> 123
      //   1326: aload_2
      //   1327: invokevirtual readString : ()Ljava/lang/String;
      //   1330: astore_1
      //   1331: aload_0
      //   1332: aload_0
      //   1333: getfield bitField0_ : I
      //   1336: sipush #2048
      //   1339: ior
      //   1340: putfield bitField0_ : I
      //   1343: aload_0
      //   1344: aload_1
      //   1345: putfield appStore_ : Ljava/lang/String;
      //   1348: goto -> 123
      //   1351: aload_0
      //   1352: aload_0
      //   1353: getfield bitField0_ : I
      //   1356: sipush #1024
      //   1359: ior
      //   1360: putfield bitField0_ : I
      //   1363: aload_0
      //   1364: aload_2
      //   1365: invokevirtual readInt32 : ()I
      //   1368: putfield timeZoneOffsetMinutes_ : I
      //   1371: goto -> 123
      //   1374: aload_2
      //   1375: invokevirtual readString : ()Ljava/lang/String;
      //   1378: astore_1
      //   1379: aload_0
      //   1380: aload_0
      //   1381: getfield bitField0_ : I
      //   1384: sipush #512
      //   1387: ior
      //   1388: putfield bitField0_ : I
      //   1391: aload_0
      //   1392: aload_1
      //   1393: putfield userDefaultLanguage_ : Ljava/lang/String;
      //   1396: goto -> 123
      //   1399: aload_2
      //   1400: invokevirtual readString : ()Ljava/lang/String;
      //   1403: astore_1
      //   1404: aload_0
      //   1405: aload_0
      //   1406: getfield bitField0_ : I
      //   1409: sipush #256
      //   1412: ior
      //   1413: putfield bitField0_ : I
      //   1416: aload_0
      //   1417: aload_1
      //   1418: putfield deviceModel_ : Ljava/lang/String;
      //   1421: goto -> 123
      //   1424: aload_2
      //   1425: invokevirtual readString : ()Ljava/lang/String;
      //   1428: astore_1
      //   1429: aload_0
      //   1430: aload_0
      //   1431: getfield bitField0_ : I
      //   1434: sipush #128
      //   1437: ior
      //   1438: putfield bitField0_ : I
      //   1441: aload_0
      //   1442: aload_1
      //   1443: putfield osVersion_ : Ljava/lang/String;
      //   1446: goto -> 123
      //   1449: aload_2
      //   1450: invokevirtual readString : ()Ljava/lang/String;
      //   1453: astore_1
      //   1454: aload_0
      //   1455: bipush #64
      //   1457: aload_0
      //   1458: getfield bitField0_ : I
      //   1461: ior
      //   1462: putfield bitField0_ : I
      //   1465: aload_0
      //   1466: aload_1
      //   1467: putfield platform_ : Ljava/lang/String;
      //   1470: goto -> 123
      //   1473: aload_0
      //   1474: aload_0
      //   1475: getfield bitField0_ : I
      //   1478: bipush #32
      //   1480: ior
      //   1481: putfield bitField0_ : I
      //   1484: aload_0
      //   1485: aload_2
      //   1486: invokevirtual readInt64 : ()J
      //   1489: putfield previousBundleEndTimestampMillis_ : J
      //   1492: goto -> 123
      //   1495: aload_0
      //   1496: aload_0
      //   1497: getfield bitField0_ : I
      //   1500: bipush #8
      //   1502: ior
      //   1503: putfield bitField0_ : I
      //   1506: aload_0
      //   1507: aload_2
      //   1508: invokevirtual readInt64 : ()J
      //   1511: putfield endTimestampMillis_ : J
      //   1514: goto -> 123
      //   1517: aload_0
      //   1518: aload_0
      //   1519: getfield bitField0_ : I
      //   1522: iconst_4
      //   1523: ior
      //   1524: putfield bitField0_ : I
      //   1527: aload_0
      //   1528: aload_2
      //   1529: invokevirtual readInt64 : ()J
      //   1532: putfield startTimestampMillis_ : J
      //   1535: goto -> 123
      //   1538: aload_0
      //   1539: aload_0
      //   1540: getfield bitField0_ : I
      //   1543: iconst_2
      //   1544: ior
      //   1545: putfield bitField0_ : I
      //   1548: aload_0
      //   1549: aload_2
      //   1550: invokevirtual readInt64 : ()J
      //   1553: putfield uploadTimestampMillis_ : J
      //   1556: goto -> 123
      //   1559: aload_0
      //   1560: getfield userAttributes_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1563: invokeinterface isModifiable : ()Z
      //   1568: ifne -> 1582
      //   1571: aload_0
      //   1572: aload_0
      //   1573: getfield userAttributes_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1576: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   1579: putfield userAttributes_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1582: aload_0
      //   1583: getfield userAttributes_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1586: aload_2
      //   1587: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   1590: aload_3
      //   1591: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   1594: checkcast analytics_collection/GmpMeasurement$UserAttribute
      //   1597: invokeinterface add : (Ljava/lang/Object;)Z
      //   1602: pop
      //   1603: goto -> 123
      //   1606: aload_0
      //   1607: getfield events_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1610: invokeinterface isModifiable : ()Z
      //   1615: ifne -> 1629
      //   1618: aload_0
      //   1619: aload_0
      //   1620: getfield events_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1623: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   1626: putfield events_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1629: aload_0
      //   1630: getfield events_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1633: aload_2
      //   1634: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   1637: aload_3
      //   1638: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   1641: checkcast analytics_collection/GmpMeasurement$Event
      //   1644: invokeinterface add : (Ljava/lang/Object;)Z
      //   1649: pop
      //   1650: goto -> 123
      //   1653: aload_0
      //   1654: aload_0
      //   1655: getfield bitField0_ : I
      //   1658: iconst_1
      //   1659: ior
      //   1660: putfield bitField0_ : I
      //   1663: aload_0
      //   1664: aload_2
      //   1665: invokevirtual readInt32 : ()I
      //   1668: putfield protocolVersion_ : I
      //   1671: goto -> 123
      //   1674: iconst_1
      //   1675: istore #4
      //   1677: goto -> 123
      //   1680: iload #6
      //   1682: ifne -> 123
      //   1685: iconst_1
      //   1686: istore #4
      //   1688: goto -> 123
      //   1691: astore_1
      //   1692: goto -> 1739
      //   1695: astore_1
      //   1696: new java/lang/RuntimeException
      //   1699: astore_2
      //   1700: new com/google/protobuf/InvalidProtocolBufferException
      //   1703: astore_3
      //   1704: aload_3
      //   1705: aload_1
      //   1706: invokevirtual getMessage : ()Ljava/lang/String;
      //   1709: invokespecial <init> : (Ljava/lang/String;)V
      //   1712: aload_2
      //   1713: aload_3
      //   1714: aload_0
      //   1715: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   1718: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   1721: aload_2
      //   1722: athrow
      //   1723: astore_1
      //   1724: new java/lang/RuntimeException
      //   1727: astore_2
      //   1728: aload_2
      //   1729: aload_1
      //   1730: aload_0
      //   1731: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   1734: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   1737: aload_2
      //   1738: athrow
      //   1739: aload_1
      //   1740: athrow
      //   1741: getstatic analytics_collection/GmpMeasurement$MeasurementBundle.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$MeasurementBundle;
      //   1744: areturn
      //   1745: aload_2
      //   1746: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   1749: astore_1
      //   1750: aload_3
      //   1751: checkcast analytics_collection/GmpMeasurement$MeasurementBundle
      //   1754: astore_2
      //   1755: aload_0
      //   1756: aload_1
      //   1757: aload_0
      //   1758: invokevirtual hasProtocolVersion : ()Z
      //   1761: aload_0
      //   1762: getfield protocolVersion_ : I
      //   1765: aload_2
      //   1766: invokevirtual hasProtocolVersion : ()Z
      //   1769: aload_2
      //   1770: getfield protocolVersion_ : I
      //   1773: invokeinterface visitInt : (ZIZI)I
      //   1778: putfield protocolVersion_ : I
      //   1781: aload_0
      //   1782: aload_1
      //   1783: aload_0
      //   1784: getfield events_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1787: aload_2
      //   1788: getfield events_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1791: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   1796: putfield events_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1799: aload_0
      //   1800: aload_1
      //   1801: aload_0
      //   1802: getfield userAttributes_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1805: aload_2
      //   1806: getfield userAttributes_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1809: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   1814: putfield userAttributes_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1817: aload_0
      //   1818: aload_1
      //   1819: aload_0
      //   1820: invokevirtual hasUploadTimestampMillis : ()Z
      //   1823: aload_0
      //   1824: getfield uploadTimestampMillis_ : J
      //   1827: aload_2
      //   1828: invokevirtual hasUploadTimestampMillis : ()Z
      //   1831: aload_2
      //   1832: getfield uploadTimestampMillis_ : J
      //   1835: invokeinterface visitLong : (ZJZJ)J
      //   1840: putfield uploadTimestampMillis_ : J
      //   1843: aload_0
      //   1844: aload_1
      //   1845: aload_0
      //   1846: invokevirtual hasStartTimestampMillis : ()Z
      //   1849: aload_0
      //   1850: getfield startTimestampMillis_ : J
      //   1853: aload_2
      //   1854: invokevirtual hasStartTimestampMillis : ()Z
      //   1857: aload_2
      //   1858: getfield startTimestampMillis_ : J
      //   1861: invokeinterface visitLong : (ZJZJ)J
      //   1866: putfield startTimestampMillis_ : J
      //   1869: aload_0
      //   1870: aload_1
      //   1871: aload_0
      //   1872: invokevirtual hasEndTimestampMillis : ()Z
      //   1875: aload_0
      //   1876: getfield endTimestampMillis_ : J
      //   1879: aload_2
      //   1880: invokevirtual hasEndTimestampMillis : ()Z
      //   1883: aload_2
      //   1884: getfield endTimestampMillis_ : J
      //   1887: invokeinterface visitLong : (ZJZJ)J
      //   1892: putfield endTimestampMillis_ : J
      //   1895: aload_0
      //   1896: aload_1
      //   1897: aload_0
      //   1898: invokevirtual hasPreviousBundleStartTimestampMillis : ()Z
      //   1901: aload_0
      //   1902: getfield previousBundleStartTimestampMillis_ : J
      //   1905: aload_2
      //   1906: invokevirtual hasPreviousBundleStartTimestampMillis : ()Z
      //   1909: aload_2
      //   1910: getfield previousBundleStartTimestampMillis_ : J
      //   1913: invokeinterface visitLong : (ZJZJ)J
      //   1918: putfield previousBundleStartTimestampMillis_ : J
      //   1921: aload_0
      //   1922: aload_1
      //   1923: aload_0
      //   1924: invokevirtual hasPreviousBundleEndTimestampMillis : ()Z
      //   1927: aload_0
      //   1928: getfield previousBundleEndTimestampMillis_ : J
      //   1931: aload_2
      //   1932: invokevirtual hasPreviousBundleEndTimestampMillis : ()Z
      //   1935: aload_2
      //   1936: getfield previousBundleEndTimestampMillis_ : J
      //   1939: invokeinterface visitLong : (ZJZJ)J
      //   1944: putfield previousBundleEndTimestampMillis_ : J
      //   1947: aload_0
      //   1948: aload_1
      //   1949: aload_0
      //   1950: invokevirtual hasPlatform : ()Z
      //   1953: aload_0
      //   1954: getfield platform_ : Ljava/lang/String;
      //   1957: aload_2
      //   1958: invokevirtual hasPlatform : ()Z
      //   1961: aload_2
      //   1962: getfield platform_ : Ljava/lang/String;
      //   1965: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   1970: putfield platform_ : Ljava/lang/String;
      //   1973: aload_0
      //   1974: aload_1
      //   1975: aload_0
      //   1976: invokevirtual hasOsVersion : ()Z
      //   1979: aload_0
      //   1980: getfield osVersion_ : Ljava/lang/String;
      //   1983: aload_2
      //   1984: invokevirtual hasOsVersion : ()Z
      //   1987: aload_2
      //   1988: getfield osVersion_ : Ljava/lang/String;
      //   1991: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   1996: putfield osVersion_ : Ljava/lang/String;
      //   1999: aload_0
      //   2000: aload_1
      //   2001: aload_0
      //   2002: invokevirtual hasDeviceModel : ()Z
      //   2005: aload_0
      //   2006: getfield deviceModel_ : Ljava/lang/String;
      //   2009: aload_2
      //   2010: invokevirtual hasDeviceModel : ()Z
      //   2013: aload_2
      //   2014: getfield deviceModel_ : Ljava/lang/String;
      //   2017: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   2022: putfield deviceModel_ : Ljava/lang/String;
      //   2025: aload_0
      //   2026: aload_1
      //   2027: aload_0
      //   2028: invokevirtual hasUserDefaultLanguage : ()Z
      //   2031: aload_0
      //   2032: getfield userDefaultLanguage_ : Ljava/lang/String;
      //   2035: aload_2
      //   2036: invokevirtual hasUserDefaultLanguage : ()Z
      //   2039: aload_2
      //   2040: getfield userDefaultLanguage_ : Ljava/lang/String;
      //   2043: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   2048: putfield userDefaultLanguage_ : Ljava/lang/String;
      //   2051: aload_0
      //   2052: aload_1
      //   2053: aload_0
      //   2054: invokevirtual hasTimeZoneOffsetMinutes : ()Z
      //   2057: aload_0
      //   2058: getfield timeZoneOffsetMinutes_ : I
      //   2061: aload_2
      //   2062: invokevirtual hasTimeZoneOffsetMinutes : ()Z
      //   2065: aload_2
      //   2066: getfield timeZoneOffsetMinutes_ : I
      //   2069: invokeinterface visitInt : (ZIZI)I
      //   2074: putfield timeZoneOffsetMinutes_ : I
      //   2077: aload_0
      //   2078: aload_1
      //   2079: aload_0
      //   2080: invokevirtual hasAppStore : ()Z
      //   2083: aload_0
      //   2084: getfield appStore_ : Ljava/lang/String;
      //   2087: aload_2
      //   2088: invokevirtual hasAppStore : ()Z
      //   2091: aload_2
      //   2092: getfield appStore_ : Ljava/lang/String;
      //   2095: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   2100: putfield appStore_ : Ljava/lang/String;
      //   2103: aload_0
      //   2104: aload_1
      //   2105: aload_0
      //   2106: invokevirtual hasAppId : ()Z
      //   2109: aload_0
      //   2110: getfield appId_ : Ljava/lang/String;
      //   2113: aload_2
      //   2114: invokevirtual hasAppId : ()Z
      //   2117: aload_2
      //   2118: getfield appId_ : Ljava/lang/String;
      //   2121: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   2126: putfield appId_ : Ljava/lang/String;
      //   2129: aload_0
      //   2130: aload_1
      //   2131: aload_0
      //   2132: invokevirtual hasAppIdNumeric : ()Z
      //   2135: aload_0
      //   2136: getfield appIdNumeric_ : J
      //   2139: aload_2
      //   2140: invokevirtual hasAppIdNumeric : ()Z
      //   2143: aload_2
      //   2144: getfield appIdNumeric_ : J
      //   2147: invokeinterface visitLong : (ZJZJ)J
      //   2152: putfield appIdNumeric_ : J
      //   2155: aload_0
      //   2156: aload_1
      //   2157: aload_0
      //   2158: invokevirtual hasAppVersion : ()Z
      //   2161: aload_0
      //   2162: getfield appVersion_ : Ljava/lang/String;
      //   2165: aload_2
      //   2166: invokevirtual hasAppVersion : ()Z
      //   2169: aload_2
      //   2170: getfield appVersion_ : Ljava/lang/String;
      //   2173: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   2178: putfield appVersion_ : Ljava/lang/String;
      //   2181: aload_0
      //   2182: aload_1
      //   2183: aload_0
      //   2184: invokevirtual hasGmpVersion : ()Z
      //   2187: aload_0
      //   2188: getfield gmpVersion_ : J
      //   2191: aload_2
      //   2192: invokevirtual hasGmpVersion : ()Z
      //   2195: aload_2
      //   2196: getfield gmpVersion_ : J
      //   2199: invokeinterface visitLong : (ZJZJ)J
      //   2204: putfield gmpVersion_ : J
      //   2207: aload_0
      //   2208: aload_1
      //   2209: aload_0
      //   2210: invokevirtual hasUploadingGmpVersion : ()Z
      //   2213: aload_0
      //   2214: getfield uploadingGmpVersion_ : J
      //   2217: aload_2
      //   2218: invokevirtual hasUploadingGmpVersion : ()Z
      //   2221: aload_2
      //   2222: getfield uploadingGmpVersion_ : J
      //   2225: invokeinterface visitLong : (ZJZJ)J
      //   2230: putfield uploadingGmpVersion_ : J
      //   2233: aload_0
      //   2234: aload_1
      //   2235: aload_0
      //   2236: invokevirtual hasResettableDeviceId : ()Z
      //   2239: aload_0
      //   2240: getfield resettableDeviceId_ : Ljava/lang/String;
      //   2243: aload_2
      //   2244: invokevirtual hasResettableDeviceId : ()Z
      //   2247: aload_2
      //   2248: getfield resettableDeviceId_ : Ljava/lang/String;
      //   2251: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   2256: putfield resettableDeviceId_ : Ljava/lang/String;
      //   2259: aload_0
      //   2260: aload_1
      //   2261: aload_0
      //   2262: invokevirtual hasVendorDeviceId : ()Z
      //   2265: aload_0
      //   2266: getfield vendorDeviceId_ : Ljava/lang/String;
      //   2269: aload_2
      //   2270: invokevirtual hasVendorDeviceId : ()Z
      //   2273: aload_2
      //   2274: getfield vendorDeviceId_ : Ljava/lang/String;
      //   2277: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   2282: putfield vendorDeviceId_ : Ljava/lang/String;
      //   2285: aload_0
      //   2286: aload_1
      //   2287: aload_0
      //   2288: invokevirtual hasLimitedAdTracking : ()Z
      //   2291: aload_0
      //   2292: getfield limitedAdTracking_ : Z
      //   2295: aload_2
      //   2296: invokevirtual hasLimitedAdTracking : ()Z
      //   2299: aload_2
      //   2300: getfield limitedAdTracking_ : Z
      //   2303: invokeinterface visitBoolean : (ZZZZ)Z
      //   2308: putfield limitedAdTracking_ : Z
      //   2311: aload_0
      //   2312: aload_1
      //   2313: aload_0
      //   2314: invokevirtual hasAppInstanceId : ()Z
      //   2317: aload_0
      //   2318: getfield appInstanceId_ : Ljava/lang/String;
      //   2321: aload_2
      //   2322: invokevirtual hasAppInstanceId : ()Z
      //   2325: aload_2
      //   2326: getfield appInstanceId_ : Ljava/lang/String;
      //   2329: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   2334: putfield appInstanceId_ : Ljava/lang/String;
      //   2337: aload_0
      //   2338: aload_1
      //   2339: aload_0
      //   2340: invokevirtual hasDevCertHash : ()Z
      //   2343: aload_0
      //   2344: getfield devCertHash_ : J
      //   2347: aload_2
      //   2348: invokevirtual hasDevCertHash : ()Z
      //   2351: aload_2
      //   2352: getfield devCertHash_ : J
      //   2355: invokeinterface visitLong : (ZJZJ)J
      //   2360: putfield devCertHash_ : J
      //   2363: aload_0
      //   2364: aload_1
      //   2365: aload_0
      //   2366: invokevirtual hasBundleSequentialIndex : ()Z
      //   2369: aload_0
      //   2370: getfield bundleSequentialIndex_ : I
      //   2373: aload_2
      //   2374: invokevirtual hasBundleSequentialIndex : ()Z
      //   2377: aload_2
      //   2378: getfield bundleSequentialIndex_ : I
      //   2381: invokeinterface visitInt : (ZIZI)I
      //   2386: putfield bundleSequentialIndex_ : I
      //   2389: aload_0
      //   2390: aload_1
      //   2391: aload_0
      //   2392: invokevirtual hasHealthMonitor : ()Z
      //   2395: aload_0
      //   2396: getfield healthMonitor_ : Ljava/lang/String;
      //   2399: aload_2
      //   2400: invokevirtual hasHealthMonitor : ()Z
      //   2403: aload_2
      //   2404: getfield healthMonitor_ : Ljava/lang/String;
      //   2407: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   2412: putfield healthMonitor_ : Ljava/lang/String;
      //   2415: aload_0
      //   2416: aload_1
      //   2417: aload_0
      //   2418: invokevirtual hasGmpAppId : ()Z
      //   2421: aload_0
      //   2422: getfield gmpAppId_ : Ljava/lang/String;
      //   2425: aload_2
      //   2426: invokevirtual hasGmpAppId : ()Z
      //   2429: aload_2
      //   2430: getfield gmpAppId_ : Ljava/lang/String;
      //   2433: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   2438: putfield gmpAppId_ : Ljava/lang/String;
      //   2441: aload_0
      //   2442: aload_1
      //   2443: aload_0
      //   2444: invokevirtual hasServiceUpload : ()Z
      //   2447: aload_0
      //   2448: getfield serviceUpload_ : Z
      //   2451: aload_2
      //   2452: invokevirtual hasServiceUpload : ()Z
      //   2455: aload_2
      //   2456: getfield serviceUpload_ : Z
      //   2459: invokeinterface visitBoolean : (ZZZZ)Z
      //   2464: putfield serviceUpload_ : Z
      //   2467: aload_0
      //   2468: aload_1
      //   2469: aload_0
      //   2470: getfield audienceEvaluationResults_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   2473: aload_2
      //   2474: getfield audienceEvaluationResults_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   2477: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   2482: putfield audienceEvaluationResults_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   2485: aload_0
      //   2486: aload_1
      //   2487: aload_0
      //   2488: invokevirtual hasFirebaseInstanceId : ()Z
      //   2491: aload_0
      //   2492: getfield firebaseInstanceId_ : Ljava/lang/String;
      //   2495: aload_2
      //   2496: invokevirtual hasFirebaseInstanceId : ()Z
      //   2499: aload_2
      //   2500: getfield firebaseInstanceId_ : Ljava/lang/String;
      //   2503: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   2508: putfield firebaseInstanceId_ : Ljava/lang/String;
      //   2511: aload_0
      //   2512: aload_1
      //   2513: aload_0
      //   2514: invokevirtual hasAppVersionMajor : ()Z
      //   2517: aload_0
      //   2518: getfield appVersionMajor_ : I
      //   2521: aload_2
      //   2522: invokevirtual hasAppVersionMajor : ()Z
      //   2525: aload_2
      //   2526: getfield appVersionMajor_ : I
      //   2529: invokeinterface visitInt : (ZIZI)I
      //   2534: putfield appVersionMajor_ : I
      //   2537: aload_0
      //   2538: aload_1
      //   2539: aload_0
      //   2540: invokevirtual hasAppVersionMinor : ()Z
      //   2543: aload_0
      //   2544: getfield appVersionMinor_ : I
      //   2547: aload_2
      //   2548: invokevirtual hasAppVersionMinor : ()Z
      //   2551: aload_2
      //   2552: getfield appVersionMinor_ : I
      //   2555: invokeinterface visitInt : (ZIZI)I
      //   2560: putfield appVersionMinor_ : I
      //   2563: aload_0
      //   2564: aload_1
      //   2565: aload_0
      //   2566: invokevirtual hasAppVersionRelease : ()Z
      //   2569: aload_0
      //   2570: getfield appVersionRelease_ : I
      //   2573: aload_2
      //   2574: invokevirtual hasAppVersionRelease : ()Z
      //   2577: aload_2
      //   2578: getfield appVersionRelease_ : I
      //   2581: invokeinterface visitInt : (ZIZI)I
      //   2586: putfield appVersionRelease_ : I
      //   2589: aload_0
      //   2590: aload_1
      //   2591: aload_0
      //   2592: invokevirtual hasSsaid : ()Z
      //   2595: aload_0
      //   2596: getfield ssaid_ : Ljava/lang/String;
      //   2599: aload_2
      //   2600: invokevirtual hasSsaid : ()Z
      //   2603: aload_2
      //   2604: getfield ssaid_ : Ljava/lang/String;
      //   2607: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   2612: putfield ssaid_ : Ljava/lang/String;
      //   2615: aload_0
      //   2616: aload_1
      //   2617: aload_0
      //   2618: invokevirtual hasConfigVersion : ()Z
      //   2621: aload_0
      //   2622: getfield configVersion_ : J
      //   2625: aload_2
      //   2626: invokevirtual hasConfigVersion : ()Z
      //   2629: aload_2
      //   2630: getfield configVersion_ : J
      //   2633: invokeinterface visitLong : (ZJZJ)J
      //   2638: putfield configVersion_ : J
      //   2641: aload_0
      //   2642: aload_1
      //   2643: aload_0
      //   2644: invokevirtual hasDsid : ()Z
      //   2647: aload_0
      //   2648: getfield dsid_ : Ljava/lang/String;
      //   2651: aload_2
      //   2652: invokevirtual hasDsid : ()Z
      //   2655: aload_2
      //   2656: getfield dsid_ : Ljava/lang/String;
      //   2659: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   2664: putfield dsid_ : Ljava/lang/String;
      //   2667: aload_0
      //   2668: aload_1
      //   2669: aload_0
      //   2670: invokevirtual hasExternalStreamId : ()Z
      //   2673: aload_0
      //   2674: getfield externalStreamId_ : Ljava/lang/String;
      //   2677: aload_2
      //   2678: invokevirtual hasExternalStreamId : ()Z
      //   2681: aload_2
      //   2682: getfield externalStreamId_ : Ljava/lang/String;
      //   2685: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   2690: putfield externalStreamId_ : Ljava/lang/String;
      //   2693: aload_0
      //   2694: aload_1
      //   2695: aload_0
      //   2696: invokevirtual hasRetryCounter : ()Z
      //   2699: aload_0
      //   2700: getfield retryCounter_ : I
      //   2703: aload_2
      //   2704: invokevirtual hasRetryCounter : ()Z
      //   2707: aload_2
      //   2708: getfield retryCounter_ : I
      //   2711: invokeinterface visitInt : (ZIZI)I
      //   2716: putfield retryCounter_ : I
      //   2719: aload_0
      //   2720: aload_1
      //   2721: aload_0
      //   2722: getfield gaiaInfo_ : Lanalytics_collection/GmpMeasurement$GaiaInfo;
      //   2725: aload_2
      //   2726: getfield gaiaInfo_ : Lanalytics_collection/GmpMeasurement$GaiaInfo;
      //   2729: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   2734: checkcast analytics_collection/GmpMeasurement$GaiaInfo
      //   2737: putfield gaiaInfo_ : Lanalytics_collection/GmpMeasurement$GaiaInfo;
      //   2740: aload_0
      //   2741: aload_1
      //   2742: aload_0
      //   2743: invokevirtual hasAdmobAppId : ()Z
      //   2746: aload_0
      //   2747: getfield admobAppId_ : Ljava/lang/String;
      //   2750: aload_2
      //   2751: invokevirtual hasAdmobAppId : ()Z
      //   2754: aload_2
      //   2755: getfield admobAppId_ : Ljava/lang/String;
      //   2758: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   2763: putfield admobAppId_ : Ljava/lang/String;
      //   2766: aload_0
      //   2767: aload_1
      //   2768: aload_0
      //   2769: invokevirtual hasBundleAlsoLoggedInGaia : ()Z
      //   2772: aload_0
      //   2773: getfield bundleAlsoLoggedInGaia_ : Z
      //   2776: aload_2
      //   2777: invokevirtual hasBundleAlsoLoggedInGaia : ()Z
      //   2780: aload_2
      //   2781: getfield bundleAlsoLoggedInGaia_ : Z
      //   2784: invokeinterface visitBoolean : (ZZZZ)Z
      //   2789: putfield bundleAlsoLoggedInGaia_ : Z
      //   2792: aload_0
      //   2793: aload_1
      //   2794: aload_0
      //   2795: getfield pseudonymousPrivacyInfoRequiresPrivacyReview_ : Lanalytics_collection/GmpMeasurement$PseudonymousPrivacyInfo;
      //   2798: aload_2
      //   2799: getfield pseudonymousPrivacyInfoRequiresPrivacyReview_ : Lanalytics_collection/GmpMeasurement$PseudonymousPrivacyInfo;
      //   2802: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   2807: checkcast analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo
      //   2810: putfield pseudonymousPrivacyInfoRequiresPrivacyReview_ : Lanalytics_collection/GmpMeasurement$PseudonymousPrivacyInfo;
      //   2813: aload_1
      //   2814: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   2817: if_acmpne -> 2846
      //   2820: aload_0
      //   2821: aload_0
      //   2822: getfield bitField0_ : I
      //   2825: aload_2
      //   2826: getfield bitField0_ : I
      //   2829: ior
      //   2830: putfield bitField0_ : I
      //   2833: aload_0
      //   2834: aload_0
      //   2835: getfield bitField1_ : I
      //   2838: aload_2
      //   2839: getfield bitField1_ : I
      //   2842: ior
      //   2843: putfield bitField1_ : I
      //   2846: aload_0
      //   2847: areturn
      //   2848: new analytics_collection/GmpMeasurement$MeasurementBundle$Builder
      //   2851: dup
      //   2852: aconst_null
      //   2853: invokespecial <init> : (Lanalytics_collection/GmpMeasurement$1;)V
      //   2856: areturn
      //   2857: aload_0
      //   2858: getfield events_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   2861: invokeinterface makeImmutable : ()V
      //   2866: aload_0
      //   2867: getfield userAttributes_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   2870: invokeinterface makeImmutable : ()V
      //   2875: aload_0
      //   2876: getfield audienceEvaluationResults_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   2879: invokeinterface makeImmutable : ()V
      //   2884: aconst_null
      //   2885: areturn
      //   2886: getstatic analytics_collection/GmpMeasurement$MeasurementBundle.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$MeasurementBundle;
      //   2889: areturn
      //   2890: new analytics_collection/GmpMeasurement$MeasurementBundle
      //   2893: dup
      //   2894: invokespecial <init> : ()V
      //   2897: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	1723	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	1695	java/io/IOException
      //   128	134	1691	finally
      //   492	501	1723	com/google/protobuf/InvalidProtocolBufferException
      //   492	501	1695	java/io/IOException
      //   492	501	1691	finally
      //   504	527	1723	com/google/protobuf/InvalidProtocolBufferException
      //   504	527	1695	java/io/IOException
      //   504	527	1691	finally
      //   532	547	1723	com/google/protobuf/InvalidProtocolBufferException
      //   532	547	1695	java/io/IOException
      //   532	547	1691	finally
      //   551	571	1723	com/google/protobuf/InvalidProtocolBufferException
      //   551	571	1695	java/io/IOException
      //   551	571	1691	finally
      //   571	582	1723	com/google/protobuf/InvalidProtocolBufferException
      //   571	582	1695	java/io/IOException
      //   571	582	1691	finally
      //   585	604	1723	com/google/protobuf/InvalidProtocolBufferException
      //   585	604	1695	java/io/IOException
      //   585	604	1691	finally
      //   607	628	1723	com/google/protobuf/InvalidProtocolBufferException
      //   607	628	1695	java/io/IOException
      //   607	628	1691	finally
      //   631	654	1723	com/google/protobuf/InvalidProtocolBufferException
      //   631	654	1695	java/io/IOException
      //   631	654	1691	finally
      //   659	674	1723	com/google/protobuf/InvalidProtocolBufferException
      //   659	674	1695	java/io/IOException
      //   659	674	1691	finally
      //   678	698	1723	com/google/protobuf/InvalidProtocolBufferException
      //   678	698	1695	java/io/IOException
      //   678	698	1691	finally
      //   698	709	1723	com/google/protobuf/InvalidProtocolBufferException
      //   698	709	1695	java/io/IOException
      //   698	709	1691	finally
      //   712	730	1723	com/google/protobuf/InvalidProtocolBufferException
      //   712	730	1695	java/io/IOException
      //   712	730	1691	finally
      //   733	753	1723	com/google/protobuf/InvalidProtocolBufferException
      //   733	753	1695	java/io/IOException
      //   733	753	1691	finally
      //   756	776	1723	com/google/protobuf/InvalidProtocolBufferException
      //   756	776	1695	java/io/IOException
      //   756	776	1691	finally
      //   779	799	1723	com/google/protobuf/InvalidProtocolBufferException
      //   779	799	1695	java/io/IOException
      //   779	799	1691	finally
      //   802	824	1723	com/google/protobuf/InvalidProtocolBufferException
      //   802	824	1695	java/io/IOException
      //   802	824	1691	finally
      //   827	847	1723	com/google/protobuf/InvalidProtocolBufferException
      //   827	847	1695	java/io/IOException
      //   827	847	1691	finally
      //   850	870	1723	com/google/protobuf/InvalidProtocolBufferException
      //   850	870	1695	java/io/IOException
      //   850	870	1691	finally
      //   873	893	1723	com/google/protobuf/InvalidProtocolBufferException
      //   873	893	1695	java/io/IOException
      //   873	893	1691	finally
      //   896	918	1723	com/google/protobuf/InvalidProtocolBufferException
      //   896	918	1695	java/io/IOException
      //   896	918	1691	finally
      //   921	944	1723	com/google/protobuf/InvalidProtocolBufferException
      //   921	944	1695	java/io/IOException
      //   921	944	1691	finally
      //   944	965	1723	com/google/protobuf/InvalidProtocolBufferException
      //   944	965	1695	java/io/IOException
      //   944	965	1691	finally
      //   968	988	1723	com/google/protobuf/InvalidProtocolBufferException
      //   968	988	1695	java/io/IOException
      //   968	988	1691	finally
      //   991	1013	1723	com/google/protobuf/InvalidProtocolBufferException
      //   991	1013	1695	java/io/IOException
      //   991	1013	1691	finally
      //   1016	1035	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1016	1035	1695	java/io/IOException
      //   1016	1035	1691	finally
      //   1038	1060	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1038	1060	1695	java/io/IOException
      //   1038	1060	1691	finally
      //   1063	1085	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1063	1085	1695	java/io/IOException
      //   1063	1085	1691	finally
      //   1088	1108	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1088	1108	1695	java/io/IOException
      //   1088	1108	1691	finally
      //   1111	1131	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1111	1131	1695	java/io/IOException
      //   1111	1131	1691	finally
      //   1134	1156	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1134	1156	1695	java/io/IOException
      //   1134	1156	1691	finally
      //   1159	1179	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1159	1179	1695	java/io/IOException
      //   1159	1179	1691	finally
      //   1182	1204	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1182	1204	1695	java/io/IOException
      //   1182	1204	1691	finally
      //   1207	1227	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1207	1227	1695	java/io/IOException
      //   1207	1227	1691	finally
      //   1230	1250	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1230	1250	1695	java/io/IOException
      //   1230	1250	1691	finally
      //   1253	1275	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1253	1275	1695	java/io/IOException
      //   1253	1275	1691	finally
      //   1278	1298	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1278	1298	1695	java/io/IOException
      //   1278	1298	1691	finally
      //   1301	1323	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1301	1323	1695	java/io/IOException
      //   1301	1323	1691	finally
      //   1326	1348	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1326	1348	1695	java/io/IOException
      //   1326	1348	1691	finally
      //   1351	1371	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1351	1371	1695	java/io/IOException
      //   1351	1371	1691	finally
      //   1374	1396	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1374	1396	1695	java/io/IOException
      //   1374	1396	1691	finally
      //   1399	1421	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1399	1421	1695	java/io/IOException
      //   1399	1421	1691	finally
      //   1424	1446	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1424	1446	1695	java/io/IOException
      //   1424	1446	1691	finally
      //   1449	1470	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1449	1470	1695	java/io/IOException
      //   1449	1470	1691	finally
      //   1473	1492	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1473	1492	1695	java/io/IOException
      //   1473	1492	1691	finally
      //   1495	1514	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1495	1514	1695	java/io/IOException
      //   1495	1514	1691	finally
      //   1517	1535	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1517	1535	1695	java/io/IOException
      //   1517	1535	1691	finally
      //   1538	1556	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1538	1556	1695	java/io/IOException
      //   1538	1556	1691	finally
      //   1559	1582	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1559	1582	1695	java/io/IOException
      //   1559	1582	1691	finally
      //   1582	1603	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1582	1603	1695	java/io/IOException
      //   1582	1603	1691	finally
      //   1606	1629	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1606	1629	1695	java/io/IOException
      //   1606	1629	1691	finally
      //   1629	1650	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1629	1650	1695	java/io/IOException
      //   1629	1650	1691	finally
      //   1653	1671	1723	com/google/protobuf/InvalidProtocolBufferException
      //   1653	1671	1695	java/io/IOException
      //   1653	1671	1691	finally
      //   1696	1723	1691	finally
      //   1724	1739	1691	finally
    }
    
    public String getAdmobAppId() {
      return this.admobAppId_;
    }
    
    public ByteString getAdmobAppIdBytes() {
      return ByteString.copyFromUtf8(this.admobAppId_);
    }
    
    public String getAppId() {
      return this.appId_;
    }
    
    public ByteString getAppIdBytes() {
      return ByteString.copyFromUtf8(this.appId_);
    }
    
    public long getAppIdNumeric() {
      return this.appIdNumeric_;
    }
    
    public String getAppInstanceId() {
      return this.appInstanceId_;
    }
    
    public ByteString getAppInstanceIdBytes() {
      return ByteString.copyFromUtf8(this.appInstanceId_);
    }
    
    public String getAppStore() {
      return this.appStore_;
    }
    
    public ByteString getAppStoreBytes() {
      return ByteString.copyFromUtf8(this.appStore_);
    }
    
    public String getAppVersion() {
      return this.appVersion_;
    }
    
    public ByteString getAppVersionBytes() {
      return ByteString.copyFromUtf8(this.appVersion_);
    }
    
    public int getAppVersionMajor() {
      return this.appVersionMajor_;
    }
    
    public int getAppVersionMinor() {
      return this.appVersionMinor_;
    }
    
    public int getAppVersionRelease() {
      return this.appVersionRelease_;
    }
    
    public GmpMeasurement.AudienceLeafFilterResult getAudienceEvaluationResults(int param1Int) {
      return (GmpMeasurement.AudienceLeafFilterResult)this.audienceEvaluationResults_.get(param1Int);
    }
    
    public int getAudienceEvaluationResultsCount() {
      return this.audienceEvaluationResults_.size();
    }
    
    public List<GmpMeasurement.AudienceLeafFilterResult> getAudienceEvaluationResultsList() {
      return (List<GmpMeasurement.AudienceLeafFilterResult>)this.audienceEvaluationResults_;
    }
    
    public GmpMeasurement.AudienceLeafFilterResultOrBuilder getAudienceEvaluationResultsOrBuilder(int param1Int) {
      return (GmpMeasurement.AudienceLeafFilterResultOrBuilder)this.audienceEvaluationResults_.get(param1Int);
    }
    
    public List<? extends GmpMeasurement.AudienceLeafFilterResultOrBuilder> getAudienceEvaluationResultsOrBuilderList() {
      return (List)this.audienceEvaluationResults_;
    }
    
    public boolean getBundleAlsoLoggedInGaia() {
      return this.bundleAlsoLoggedInGaia_;
    }
    
    public int getBundleSequentialIndex() {
      return this.bundleSequentialIndex_;
    }
    
    public long getConfigVersion() {
      return this.configVersion_;
    }
    
    public long getDevCertHash() {
      return this.devCertHash_;
    }
    
    public String getDeviceModel() {
      return this.deviceModel_;
    }
    
    public ByteString getDeviceModelBytes() {
      return ByteString.copyFromUtf8(this.deviceModel_);
    }
    
    public String getDsid() {
      return this.dsid_;
    }
    
    public ByteString getDsidBytes() {
      return ByteString.copyFromUtf8(this.dsid_);
    }
    
    public long getEndTimestampMillis() {
      return this.endTimestampMillis_;
    }
    
    public GmpMeasurement.Event getEvents(int param1Int) {
      return (GmpMeasurement.Event)this.events_.get(param1Int);
    }
    
    public int getEventsCount() {
      return this.events_.size();
    }
    
    public List<GmpMeasurement.Event> getEventsList() {
      return (List<GmpMeasurement.Event>)this.events_;
    }
    
    public GmpMeasurement.EventOrBuilder getEventsOrBuilder(int param1Int) {
      return (GmpMeasurement.EventOrBuilder)this.events_.get(param1Int);
    }
    
    public List<? extends GmpMeasurement.EventOrBuilder> getEventsOrBuilderList() {
      return (List)this.events_;
    }
    
    public String getExternalStreamId() {
      return this.externalStreamId_;
    }
    
    public ByteString getExternalStreamIdBytes() {
      return ByteString.copyFromUtf8(this.externalStreamId_);
    }
    
    public String getFirebaseInstanceId() {
      return this.firebaseInstanceId_;
    }
    
    public ByteString getFirebaseInstanceIdBytes() {
      return ByteString.copyFromUtf8(this.firebaseInstanceId_);
    }
    
    public GmpMeasurement.GaiaInfo getGaiaInfo() {
      GmpMeasurement.GaiaInfo gaiaInfo1 = this.gaiaInfo_;
      GmpMeasurement.GaiaInfo gaiaInfo2 = gaiaInfo1;
      if (gaiaInfo1 == null)
        gaiaInfo2 = GmpMeasurement.GaiaInfo.getDefaultInstance(); 
      return gaiaInfo2;
    }
    
    public String getGmpAppId() {
      return this.gmpAppId_;
    }
    
    public ByteString getGmpAppIdBytes() {
      return ByteString.copyFromUtf8(this.gmpAppId_);
    }
    
    public long getGmpVersion() {
      return this.gmpVersion_;
    }
    
    public String getHealthMonitor() {
      return this.healthMonitor_;
    }
    
    public ByteString getHealthMonitorBytes() {
      return ByteString.copyFromUtf8(this.healthMonitor_);
    }
    
    public boolean getLimitedAdTracking() {
      return this.limitedAdTracking_;
    }
    
    public String getOsVersion() {
      return this.osVersion_;
    }
    
    public ByteString getOsVersionBytes() {
      return ByteString.copyFromUtf8(this.osVersion_);
    }
    
    public String getPlatform() {
      return this.platform_;
    }
    
    public ByteString getPlatformBytes() {
      return ByteString.copyFromUtf8(this.platform_);
    }
    
    public long getPreviousBundleEndTimestampMillis() {
      return this.previousBundleEndTimestampMillis_;
    }
    
    public long getPreviousBundleStartTimestampMillis() {
      return this.previousBundleStartTimestampMillis_;
    }
    
    public int getProtocolVersion() {
      return this.protocolVersion_;
    }
    
    public GmpMeasurement.PseudonymousPrivacyInfo getPseudonymousPrivacyInfoRequiresPrivacyReview() {
      GmpMeasurement.PseudonymousPrivacyInfo pseudonymousPrivacyInfo1 = this.pseudonymousPrivacyInfoRequiresPrivacyReview_;
      GmpMeasurement.PseudonymousPrivacyInfo pseudonymousPrivacyInfo2 = pseudonymousPrivacyInfo1;
      if (pseudonymousPrivacyInfo1 == null)
        pseudonymousPrivacyInfo2 = GmpMeasurement.PseudonymousPrivacyInfo.getDefaultInstance(); 
      return pseudonymousPrivacyInfo2;
    }
    
    public String getResettableDeviceId() {
      return this.resettableDeviceId_;
    }
    
    public ByteString getResettableDeviceIdBytes() {
      return ByteString.copyFromUtf8(this.resettableDeviceId_);
    }
    
    public int getRetryCounter() {
      return this.retryCounter_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = this.bitField0_;
      boolean bool = false;
      if ((i & 0x1) == 1) {
        i = CodedOutputStream.computeInt32Size(1, this.protocolVersion_) + 0;
      } else {
        i = 0;
      } 
      int j;
      for (j = 0; j < this.events_.size(); j++)
        i += CodedOutputStream.computeMessageSize(2, (MessageLite)this.events_.get(j)); 
      for (j = 0; j < this.userAttributes_.size(); j++)
        i += CodedOutputStream.computeMessageSize(3, (MessageLite)this.userAttributes_.get(j)); 
      j = i;
      if ((this.bitField0_ & 0x2) == 2)
        j = i + CodedOutputStream.computeInt64Size(4, this.uploadTimestampMillis_); 
      i = j;
      if ((this.bitField0_ & 0x4) == 4)
        i = j + CodedOutputStream.computeInt64Size(5, this.startTimestampMillis_); 
      int k = i;
      if ((this.bitField0_ & 0x8) == 8)
        k = i + CodedOutputStream.computeInt64Size(6, this.endTimestampMillis_); 
      j = k;
      if ((this.bitField0_ & 0x20) == 32)
        j = k + CodedOutputStream.computeInt64Size(7, this.previousBundleEndTimestampMillis_); 
      i = j;
      if ((this.bitField0_ & 0x40) == 64)
        i = j + CodedOutputStream.computeStringSize(8, getPlatform()); 
      j = i;
      if ((this.bitField0_ & 0x80) == 128)
        j = i + CodedOutputStream.computeStringSize(9, getOsVersion()); 
      i = j;
      if ((this.bitField0_ & 0x100) == 256)
        i = j + CodedOutputStream.computeStringSize(10, getDeviceModel()); 
      k = i;
      if ((this.bitField0_ & 0x200) == 512)
        k = i + CodedOutputStream.computeStringSize(11, getUserDefaultLanguage()); 
      j = k;
      if ((this.bitField0_ & 0x400) == 1024)
        j = k + CodedOutputStream.computeInt32Size(12, this.timeZoneOffsetMinutes_); 
      i = j;
      if ((this.bitField0_ & 0x800) == 2048)
        i = j + CodedOutputStream.computeStringSize(13, getAppStore()); 
      j = i;
      if ((this.bitField0_ & 0x1000) == 4096)
        j = i + CodedOutputStream.computeStringSize(14, getAppId()); 
      i = j;
      if ((this.bitField0_ & 0x2000) == 8192)
        i = j + CodedOutputStream.computeInt64Size(15, this.appIdNumeric_); 
      j = i;
      if ((this.bitField0_ & 0x4000) == 16384)
        j = i + CodedOutputStream.computeStringSize(16, getAppVersion()); 
      i = j;
      if ((this.bitField0_ & 0x8000) == 32768)
        i = j + CodedOutputStream.computeInt64Size(17, this.gmpVersion_); 
      j = i;
      if ((this.bitField0_ & 0x10000) == 65536)
        j = i + CodedOutputStream.computeInt64Size(18, this.uploadingGmpVersion_); 
      k = j;
      if ((this.bitField0_ & 0x20000) == 131072)
        k = j + CodedOutputStream.computeStringSize(19, getResettableDeviceId()); 
      i = k;
      if ((this.bitField0_ & 0x80000) == 524288)
        i = k + CodedOutputStream.computeBoolSize(20, this.limitedAdTracking_); 
      j = i;
      if ((this.bitField0_ & 0x100000) == 1048576)
        j = i + CodedOutputStream.computeStringSize(21, getAppInstanceId()); 
      i = j;
      if ((this.bitField0_ & 0x200000) == 2097152)
        i = j + CodedOutputStream.computeInt64Size(22, this.devCertHash_); 
      j = i;
      if ((this.bitField0_ & 0x400000) == 4194304)
        j = i + CodedOutputStream.computeInt32Size(23, this.bundleSequentialIndex_); 
      i = j;
      if ((this.bitField0_ & 0x800000) == 8388608)
        i = j + CodedOutputStream.computeStringSize(24, getHealthMonitor()); 
      j = i;
      if ((this.bitField0_ & 0x1000000) == 16777216)
        j = i + CodedOutputStream.computeStringSize(25, getGmpAppId()); 
      i = j;
      if ((this.bitField0_ & 0x10) == 16)
        i = j + CodedOutputStream.computeInt64Size(26, this.previousBundleStartTimestampMillis_); 
      j = i;
      if ((this.bitField0_ & 0x40000) == 262144)
        j = i + CodedOutputStream.computeStringSize(27, getVendorDeviceId()); 
      k = bool;
      i = j;
      if ((this.bitField0_ & 0x2000000) == 33554432) {
        i = j + CodedOutputStream.computeBoolSize(28, this.serviceUpload_);
        k = bool;
      } 
      while (k < this.audienceEvaluationResults_.size()) {
        i += CodedOutputStream.computeMessageSize(29, (MessageLite)this.audienceEvaluationResults_.get(k));
        k++;
      } 
      j = i;
      if ((this.bitField0_ & 0x4000000) == 67108864)
        j = i + CodedOutputStream.computeStringSize(30, getFirebaseInstanceId()); 
      i = j;
      if ((this.bitField0_ & 0x8000000) == 134217728)
        i = j + CodedOutputStream.computeInt32Size(31, this.appVersionMajor_); 
      j = i;
      if ((this.bitField0_ & 0x10000000) == 268435456)
        j = i + CodedOutputStream.computeInt32Size(32, this.appVersionMinor_); 
      i = j;
      if ((this.bitField0_ & 0x20000000) == 536870912)
        i = j + CodedOutputStream.computeInt32Size(33, this.appVersionRelease_); 
      j = i;
      if ((this.bitField0_ & 0x40000000) == 1073741824)
        j = i + CodedOutputStream.computeStringSize(34, getSsaid()); 
      k = j;
      if ((this.bitField0_ & Integer.MIN_VALUE) == Integer.MIN_VALUE)
        k = j + CodedOutputStream.computeInt64Size(35, this.configVersion_); 
      i = k;
      if ((this.bitField1_ & 0x1) == 1)
        i = k + CodedOutputStream.computeStringSize(37, getDsid()); 
      j = i;
      if ((this.bitField1_ & 0x2) == 2)
        j = i + CodedOutputStream.computeStringSize(38, getExternalStreamId()); 
      k = j;
      if ((this.bitField1_ & 0x4) == 4)
        k = j + CodedOutputStream.computeInt32Size(39, this.retryCounter_); 
      i = k;
      if ((this.bitField1_ & 0x8) == 8)
        i = k + CodedOutputStream.computeMessageSize(40, (MessageLite)getGaiaInfo()); 
      j = i;
      if ((this.bitField1_ & 0x10) == 16)
        j = i + CodedOutputStream.computeStringSize(41, getAdmobAppId()); 
      i = j;
      if ((this.bitField1_ & 0x20) == 32)
        i = j + CodedOutputStream.computeBoolSize(42, this.bundleAlsoLoggedInGaia_); 
      j = i;
      if ((this.bitField1_ & 0x40) == 64)
        j = i + CodedOutputStream.computeMessageSize(43, (MessageLite)getPseudonymousPrivacyInfoRequiresPrivacyReview()); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean getServiceUpload() {
      return this.serviceUpload_;
    }
    
    public String getSsaid() {
      return this.ssaid_;
    }
    
    public ByteString getSsaidBytes() {
      return ByteString.copyFromUtf8(this.ssaid_);
    }
    
    public long getStartTimestampMillis() {
      return this.startTimestampMillis_;
    }
    
    public int getTimeZoneOffsetMinutes() {
      return this.timeZoneOffsetMinutes_;
    }
    
    public long getUploadTimestampMillis() {
      return this.uploadTimestampMillis_;
    }
    
    public long getUploadingGmpVersion() {
      return this.uploadingGmpVersion_;
    }
    
    public GmpMeasurement.UserAttribute getUserAttributes(int param1Int) {
      return (GmpMeasurement.UserAttribute)this.userAttributes_.get(param1Int);
    }
    
    public int getUserAttributesCount() {
      return this.userAttributes_.size();
    }
    
    public List<GmpMeasurement.UserAttribute> getUserAttributesList() {
      return (List<GmpMeasurement.UserAttribute>)this.userAttributes_;
    }
    
    public GmpMeasurement.UserAttributeOrBuilder getUserAttributesOrBuilder(int param1Int) {
      return (GmpMeasurement.UserAttributeOrBuilder)this.userAttributes_.get(param1Int);
    }
    
    public List<? extends GmpMeasurement.UserAttributeOrBuilder> getUserAttributesOrBuilderList() {
      return (List)this.userAttributes_;
    }
    
    public String getUserDefaultLanguage() {
      return this.userDefaultLanguage_;
    }
    
    public ByteString getUserDefaultLanguageBytes() {
      return ByteString.copyFromUtf8(this.userDefaultLanguage_);
    }
    
    public String getVendorDeviceId() {
      return this.vendorDeviceId_;
    }
    
    public ByteString getVendorDeviceIdBytes() {
      return ByteString.copyFromUtf8(this.vendorDeviceId_);
    }
    
    public boolean hasAdmobAppId() {
      boolean bool;
      if ((this.bitField1_ & 0x10) == 16) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasAppId() {
      boolean bool;
      if ((this.bitField0_ & 0x1000) == 4096) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasAppIdNumeric() {
      boolean bool;
      if ((this.bitField0_ & 0x2000) == 8192) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasAppInstanceId() {
      boolean bool;
      if ((this.bitField0_ & 0x100000) == 1048576) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasAppStore() {
      boolean bool;
      if ((this.bitField0_ & 0x800) == 2048) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasAppVersion() {
      boolean bool;
      if ((this.bitField0_ & 0x4000) == 16384) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasAppVersionMajor() {
      boolean bool;
      if ((this.bitField0_ & 0x8000000) == 134217728) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasAppVersionMinor() {
      boolean bool;
      if ((this.bitField0_ & 0x10000000) == 268435456) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasAppVersionRelease() {
      boolean bool;
      if ((this.bitField0_ & 0x20000000) == 536870912) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasBundleAlsoLoggedInGaia() {
      boolean bool;
      if ((this.bitField1_ & 0x20) == 32) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasBundleSequentialIndex() {
      boolean bool;
      if ((this.bitField0_ & 0x400000) == 4194304) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasConfigVersion() {
      boolean bool;
      if ((this.bitField0_ & Integer.MIN_VALUE) == Integer.MIN_VALUE) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasDevCertHash() {
      boolean bool;
      if ((this.bitField0_ & 0x200000) == 2097152) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasDeviceModel() {
      boolean bool;
      if ((this.bitField0_ & 0x100) == 256) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasDsid() {
      int i = this.bitField1_;
      boolean bool = true;
      if ((i & 0x1) != 1)
        bool = false; 
      return bool;
    }
    
    public boolean hasEndTimestampMillis() {
      boolean bool;
      if ((this.bitField0_ & 0x8) == 8) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasExternalStreamId() {
      boolean bool;
      if ((this.bitField1_ & 0x2) == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasFirebaseInstanceId() {
      boolean bool;
      if ((this.bitField0_ & 0x4000000) == 67108864) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasGaiaInfo() {
      boolean bool;
      if ((this.bitField1_ & 0x8) == 8) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasGmpAppId() {
      boolean bool;
      if ((this.bitField0_ & 0x1000000) == 16777216) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasGmpVersion() {
      boolean bool;
      if ((this.bitField0_ & 0x8000) == 32768) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasHealthMonitor() {
      boolean bool;
      if ((this.bitField0_ & 0x800000) == 8388608) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasLimitedAdTracking() {
      boolean bool;
      if ((this.bitField0_ & 0x80000) == 524288) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasOsVersion() {
      boolean bool;
      if ((this.bitField0_ & 0x80) == 128) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasPlatform() {
      boolean bool;
      if ((this.bitField0_ & 0x40) == 64) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasPreviousBundleEndTimestampMillis() {
      boolean bool;
      if ((this.bitField0_ & 0x20) == 32) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasPreviousBundleStartTimestampMillis() {
      boolean bool;
      if ((this.bitField0_ & 0x10) == 16) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasProtocolVersion() {
      int i = this.bitField0_;
      boolean bool = true;
      if ((i & 0x1) != 1)
        bool = false; 
      return bool;
    }
    
    public boolean hasPseudonymousPrivacyInfoRequiresPrivacyReview() {
      boolean bool;
      if ((this.bitField1_ & 0x40) == 64) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasResettableDeviceId() {
      boolean bool;
      if ((this.bitField0_ & 0x20000) == 131072) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasRetryCounter() {
      boolean bool;
      if ((this.bitField1_ & 0x4) == 4) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasServiceUpload() {
      boolean bool;
      if ((this.bitField0_ & 0x2000000) == 33554432) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasSsaid() {
      boolean bool;
      if ((this.bitField0_ & 0x40000000) == 1073741824) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasStartTimestampMillis() {
      boolean bool;
      if ((this.bitField0_ & 0x4) == 4) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasTimeZoneOffsetMinutes() {
      boolean bool;
      if ((this.bitField0_ & 0x400) == 1024) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasUploadTimestampMillis() {
      boolean bool;
      if ((this.bitField0_ & 0x2) == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasUploadingGmpVersion() {
      boolean bool;
      if ((this.bitField0_ & 0x10000) == 65536) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasUserDefaultLanguage() {
      boolean bool;
      if ((this.bitField0_ & 0x200) == 512) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasVendorDeviceId() {
      boolean bool;
      if ((this.bitField0_ & 0x40000) == 262144) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if ((this.bitField0_ & 0x1) == 1)
        param1CodedOutputStream.writeInt32(1, this.protocolVersion_); 
      boolean bool = false;
      byte b;
      for (b = 0; b < this.events_.size(); b++)
        param1CodedOutputStream.writeMessage(2, (MessageLite)this.events_.get(b)); 
      for (b = 0; b < this.userAttributes_.size(); b++)
        param1CodedOutputStream.writeMessage(3, (MessageLite)this.userAttributes_.get(b)); 
      if ((this.bitField0_ & 0x2) == 2)
        param1CodedOutputStream.writeInt64(4, this.uploadTimestampMillis_); 
      if ((this.bitField0_ & 0x4) == 4)
        param1CodedOutputStream.writeInt64(5, this.startTimestampMillis_); 
      if ((this.bitField0_ & 0x8) == 8)
        param1CodedOutputStream.writeInt64(6, this.endTimestampMillis_); 
      if ((this.bitField0_ & 0x20) == 32)
        param1CodedOutputStream.writeInt64(7, this.previousBundleEndTimestampMillis_); 
      if ((this.bitField0_ & 0x40) == 64)
        param1CodedOutputStream.writeString(8, getPlatform()); 
      if ((this.bitField0_ & 0x80) == 128)
        param1CodedOutputStream.writeString(9, getOsVersion()); 
      if ((this.bitField0_ & 0x100) == 256)
        param1CodedOutputStream.writeString(10, getDeviceModel()); 
      if ((this.bitField0_ & 0x200) == 512)
        param1CodedOutputStream.writeString(11, getUserDefaultLanguage()); 
      if ((this.bitField0_ & 0x400) == 1024)
        param1CodedOutputStream.writeInt32(12, this.timeZoneOffsetMinutes_); 
      if ((this.bitField0_ & 0x800) == 2048)
        param1CodedOutputStream.writeString(13, getAppStore()); 
      if ((this.bitField0_ & 0x1000) == 4096)
        param1CodedOutputStream.writeString(14, getAppId()); 
      if ((this.bitField0_ & 0x2000) == 8192)
        param1CodedOutputStream.writeInt64(15, this.appIdNumeric_); 
      if ((this.bitField0_ & 0x4000) == 16384)
        param1CodedOutputStream.writeString(16, getAppVersion()); 
      if ((this.bitField0_ & 0x8000) == 32768)
        param1CodedOutputStream.writeInt64(17, this.gmpVersion_); 
      if ((this.bitField0_ & 0x10000) == 65536)
        param1CodedOutputStream.writeInt64(18, this.uploadingGmpVersion_); 
      if ((this.bitField0_ & 0x20000) == 131072)
        param1CodedOutputStream.writeString(19, getResettableDeviceId()); 
      if ((this.bitField0_ & 0x80000) == 524288)
        param1CodedOutputStream.writeBool(20, this.limitedAdTracking_); 
      if ((this.bitField0_ & 0x100000) == 1048576)
        param1CodedOutputStream.writeString(21, getAppInstanceId()); 
      if ((this.bitField0_ & 0x200000) == 2097152)
        param1CodedOutputStream.writeInt64(22, this.devCertHash_); 
      if ((this.bitField0_ & 0x400000) == 4194304)
        param1CodedOutputStream.writeInt32(23, this.bundleSequentialIndex_); 
      if ((this.bitField0_ & 0x800000) == 8388608)
        param1CodedOutputStream.writeString(24, getHealthMonitor()); 
      if ((this.bitField0_ & 0x1000000) == 16777216)
        param1CodedOutputStream.writeString(25, getGmpAppId()); 
      if ((this.bitField0_ & 0x10) == 16)
        param1CodedOutputStream.writeInt64(26, this.previousBundleStartTimestampMillis_); 
      if ((this.bitField0_ & 0x40000) == 262144)
        param1CodedOutputStream.writeString(27, getVendorDeviceId()); 
      b = bool;
      if ((this.bitField0_ & 0x2000000) == 33554432) {
        param1CodedOutputStream.writeBool(28, this.serviceUpload_);
        b = bool;
      } 
      while (b < this.audienceEvaluationResults_.size()) {
        param1CodedOutputStream.writeMessage(29, (MessageLite)this.audienceEvaluationResults_.get(b));
        b++;
      } 
      if ((this.bitField0_ & 0x4000000) == 67108864)
        param1CodedOutputStream.writeString(30, getFirebaseInstanceId()); 
      if ((this.bitField0_ & 0x8000000) == 134217728)
        param1CodedOutputStream.writeInt32(31, this.appVersionMajor_); 
      if ((this.bitField0_ & 0x10000000) == 268435456)
        param1CodedOutputStream.writeInt32(32, this.appVersionMinor_); 
      if ((this.bitField0_ & 0x20000000) == 536870912)
        param1CodedOutputStream.writeInt32(33, this.appVersionRelease_); 
      if ((this.bitField0_ & 0x40000000) == 1073741824)
        param1CodedOutputStream.writeString(34, getSsaid()); 
      if ((this.bitField0_ & Integer.MIN_VALUE) == Integer.MIN_VALUE)
        param1CodedOutputStream.writeInt64(35, this.configVersion_); 
      if ((this.bitField1_ & 0x1) == 1)
        param1CodedOutputStream.writeString(37, getDsid()); 
      if ((this.bitField1_ & 0x2) == 2)
        param1CodedOutputStream.writeString(38, getExternalStreamId()); 
      if ((this.bitField1_ & 0x4) == 4)
        param1CodedOutputStream.writeInt32(39, this.retryCounter_); 
      if ((this.bitField1_ & 0x8) == 8)
        param1CodedOutputStream.writeMessage(40, (MessageLite)getGaiaInfo()); 
      if ((this.bitField1_ & 0x10) == 16)
        param1CodedOutputStream.writeString(41, getAdmobAppId()); 
      if ((this.bitField1_ & 0x20) == 32)
        param1CodedOutputStream.writeBool(42, this.bundleAlsoLoggedInGaia_); 
      if ((this.bitField1_ & 0x40) == 64)
        param1CodedOutputStream.writeMessage(43, (MessageLite)getPseudonymousPrivacyInfoRequiresPrivacyReview()); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<MeasurementBundle, Builder> implements GmpMeasurement.MeasurementBundleOrBuilder {
      private Builder() {
        super(GmpMeasurement.MeasurementBundle.DEFAULT_INSTANCE);
      }
      
      public Builder addAllAudienceEvaluationResults(Iterable<? extends GmpMeasurement.AudienceLeafFilterResult> param2Iterable) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).addAllAudienceEvaluationResults(param2Iterable);
        return this;
      }
      
      public Builder addAllEvents(Iterable<? extends GmpMeasurement.Event> param2Iterable) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).addAllEvents(param2Iterable);
        return this;
      }
      
      public Builder addAllUserAttributes(Iterable<? extends GmpMeasurement.UserAttribute> param2Iterable) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).addAllUserAttributes(param2Iterable);
        return this;
      }
      
      public Builder addAudienceEvaluationResults(int param2Int, GmpMeasurement.AudienceLeafFilterResult.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).addAudienceEvaluationResults(param2Int, param2Builder);
        return this;
      }
      
      public Builder addAudienceEvaluationResults(int param2Int, GmpMeasurement.AudienceLeafFilterResult param2AudienceLeafFilterResult) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).addAudienceEvaluationResults(param2Int, param2AudienceLeafFilterResult);
        return this;
      }
      
      public Builder addAudienceEvaluationResults(GmpMeasurement.AudienceLeafFilterResult.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).addAudienceEvaluationResults(param2Builder);
        return this;
      }
      
      public Builder addAudienceEvaluationResults(GmpMeasurement.AudienceLeafFilterResult param2AudienceLeafFilterResult) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).addAudienceEvaluationResults(param2AudienceLeafFilterResult);
        return this;
      }
      
      public Builder addEvents(int param2Int, GmpMeasurement.Event.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).addEvents(param2Int, param2Builder);
        return this;
      }
      
      public Builder addEvents(int param2Int, GmpMeasurement.Event param2Event) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).addEvents(param2Int, param2Event);
        return this;
      }
      
      public Builder addEvents(GmpMeasurement.Event.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).addEvents(param2Builder);
        return this;
      }
      
      public Builder addEvents(GmpMeasurement.Event param2Event) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).addEvents(param2Event);
        return this;
      }
      
      public Builder addUserAttributes(int param2Int, GmpMeasurement.UserAttribute.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).addUserAttributes(param2Int, param2Builder);
        return this;
      }
      
      public Builder addUserAttributes(int param2Int, GmpMeasurement.UserAttribute param2UserAttribute) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).addUserAttributes(param2Int, param2UserAttribute);
        return this;
      }
      
      public Builder addUserAttributes(GmpMeasurement.UserAttribute.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).addUserAttributes(param2Builder);
        return this;
      }
      
      public Builder addUserAttributes(GmpMeasurement.UserAttribute param2UserAttribute) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).addUserAttributes(param2UserAttribute);
        return this;
      }
      
      public Builder clearAdmobAppId() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearAdmobAppId();
        return this;
      }
      
      public Builder clearAppId() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearAppId();
        return this;
      }
      
      public Builder clearAppIdNumeric() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearAppIdNumeric();
        return this;
      }
      
      public Builder clearAppInstanceId() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearAppInstanceId();
        return this;
      }
      
      public Builder clearAppStore() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearAppStore();
        return this;
      }
      
      public Builder clearAppVersion() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearAppVersion();
        return this;
      }
      
      public Builder clearAppVersionMajor() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearAppVersionMajor();
        return this;
      }
      
      public Builder clearAppVersionMinor() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearAppVersionMinor();
        return this;
      }
      
      public Builder clearAppVersionRelease() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearAppVersionRelease();
        return this;
      }
      
      public Builder clearAudienceEvaluationResults() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearAudienceEvaluationResults();
        return this;
      }
      
      public Builder clearBundleAlsoLoggedInGaia() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearBundleAlsoLoggedInGaia();
        return this;
      }
      
      public Builder clearBundleSequentialIndex() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearBundleSequentialIndex();
        return this;
      }
      
      public Builder clearConfigVersion() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearConfigVersion();
        return this;
      }
      
      public Builder clearDevCertHash() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearDevCertHash();
        return this;
      }
      
      public Builder clearDeviceModel() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearDeviceModel();
        return this;
      }
      
      public Builder clearDsid() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearDsid();
        return this;
      }
      
      public Builder clearEndTimestampMillis() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearEndTimestampMillis();
        return this;
      }
      
      public Builder clearEvents() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearEvents();
        return this;
      }
      
      public Builder clearExternalStreamId() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearExternalStreamId();
        return this;
      }
      
      public Builder clearFirebaseInstanceId() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearFirebaseInstanceId();
        return this;
      }
      
      public Builder clearGaiaInfo() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearGaiaInfo();
        return this;
      }
      
      public Builder clearGmpAppId() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearGmpAppId();
        return this;
      }
      
      public Builder clearGmpVersion() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearGmpVersion();
        return this;
      }
      
      public Builder clearHealthMonitor() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearHealthMonitor();
        return this;
      }
      
      public Builder clearLimitedAdTracking() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearLimitedAdTracking();
        return this;
      }
      
      public Builder clearOsVersion() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearOsVersion();
        return this;
      }
      
      public Builder clearPlatform() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearPlatform();
        return this;
      }
      
      public Builder clearPreviousBundleEndTimestampMillis() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearPreviousBundleEndTimestampMillis();
        return this;
      }
      
      public Builder clearPreviousBundleStartTimestampMillis() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearPreviousBundleStartTimestampMillis();
        return this;
      }
      
      public Builder clearProtocolVersion() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearProtocolVersion();
        return this;
      }
      
      public Builder clearPseudonymousPrivacyInfoRequiresPrivacyReview() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearPseudonymousPrivacyInfoRequiresPrivacyReview();
        return this;
      }
      
      public Builder clearResettableDeviceId() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearResettableDeviceId();
        return this;
      }
      
      public Builder clearRetryCounter() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearRetryCounter();
        return this;
      }
      
      public Builder clearServiceUpload() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearServiceUpload();
        return this;
      }
      
      public Builder clearSsaid() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearSsaid();
        return this;
      }
      
      public Builder clearStartTimestampMillis() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearStartTimestampMillis();
        return this;
      }
      
      public Builder clearTimeZoneOffsetMinutes() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearTimeZoneOffsetMinutes();
        return this;
      }
      
      public Builder clearUploadTimestampMillis() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearUploadTimestampMillis();
        return this;
      }
      
      public Builder clearUploadingGmpVersion() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearUploadingGmpVersion();
        return this;
      }
      
      public Builder clearUserAttributes() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearUserAttributes();
        return this;
      }
      
      public Builder clearUserDefaultLanguage() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearUserDefaultLanguage();
        return this;
      }
      
      public Builder clearVendorDeviceId() {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).clearVendorDeviceId();
        return this;
      }
      
      public String getAdmobAppId() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getAdmobAppId();
      }
      
      public ByteString getAdmobAppIdBytes() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getAdmobAppIdBytes();
      }
      
      public String getAppId() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getAppId();
      }
      
      public ByteString getAppIdBytes() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getAppIdBytes();
      }
      
      public long getAppIdNumeric() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getAppIdNumeric();
      }
      
      public String getAppInstanceId() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getAppInstanceId();
      }
      
      public ByteString getAppInstanceIdBytes() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getAppInstanceIdBytes();
      }
      
      public String getAppStore() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getAppStore();
      }
      
      public ByteString getAppStoreBytes() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getAppStoreBytes();
      }
      
      public String getAppVersion() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getAppVersion();
      }
      
      public ByteString getAppVersionBytes() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getAppVersionBytes();
      }
      
      public int getAppVersionMajor() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getAppVersionMajor();
      }
      
      public int getAppVersionMinor() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getAppVersionMinor();
      }
      
      public int getAppVersionRelease() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getAppVersionRelease();
      }
      
      public GmpMeasurement.AudienceLeafFilterResult getAudienceEvaluationResults(int param2Int) {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getAudienceEvaluationResults(param2Int);
      }
      
      public int getAudienceEvaluationResultsCount() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getAudienceEvaluationResultsCount();
      }
      
      public List<GmpMeasurement.AudienceLeafFilterResult> getAudienceEvaluationResultsList() {
        return Collections.unmodifiableList(((GmpMeasurement.MeasurementBundle)this.instance).getAudienceEvaluationResultsList());
      }
      
      public boolean getBundleAlsoLoggedInGaia() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getBundleAlsoLoggedInGaia();
      }
      
      public int getBundleSequentialIndex() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getBundleSequentialIndex();
      }
      
      public long getConfigVersion() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getConfigVersion();
      }
      
      public long getDevCertHash() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getDevCertHash();
      }
      
      public String getDeviceModel() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getDeviceModel();
      }
      
      public ByteString getDeviceModelBytes() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getDeviceModelBytes();
      }
      
      public String getDsid() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getDsid();
      }
      
      public ByteString getDsidBytes() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getDsidBytes();
      }
      
      public long getEndTimestampMillis() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getEndTimestampMillis();
      }
      
      public GmpMeasurement.Event getEvents(int param2Int) {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getEvents(param2Int);
      }
      
      public int getEventsCount() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getEventsCount();
      }
      
      public List<GmpMeasurement.Event> getEventsList() {
        return Collections.unmodifiableList(((GmpMeasurement.MeasurementBundle)this.instance).getEventsList());
      }
      
      public String getExternalStreamId() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getExternalStreamId();
      }
      
      public ByteString getExternalStreamIdBytes() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getExternalStreamIdBytes();
      }
      
      public String getFirebaseInstanceId() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getFirebaseInstanceId();
      }
      
      public ByteString getFirebaseInstanceIdBytes() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getFirebaseInstanceIdBytes();
      }
      
      public GmpMeasurement.GaiaInfo getGaiaInfo() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getGaiaInfo();
      }
      
      public String getGmpAppId() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getGmpAppId();
      }
      
      public ByteString getGmpAppIdBytes() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getGmpAppIdBytes();
      }
      
      public long getGmpVersion() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getGmpVersion();
      }
      
      public String getHealthMonitor() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getHealthMonitor();
      }
      
      public ByteString getHealthMonitorBytes() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getHealthMonitorBytes();
      }
      
      public boolean getLimitedAdTracking() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getLimitedAdTracking();
      }
      
      public String getOsVersion() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getOsVersion();
      }
      
      public ByteString getOsVersionBytes() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getOsVersionBytes();
      }
      
      public String getPlatform() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getPlatform();
      }
      
      public ByteString getPlatformBytes() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getPlatformBytes();
      }
      
      public long getPreviousBundleEndTimestampMillis() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getPreviousBundleEndTimestampMillis();
      }
      
      public long getPreviousBundleStartTimestampMillis() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getPreviousBundleStartTimestampMillis();
      }
      
      public int getProtocolVersion() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getProtocolVersion();
      }
      
      public GmpMeasurement.PseudonymousPrivacyInfo getPseudonymousPrivacyInfoRequiresPrivacyReview() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getPseudonymousPrivacyInfoRequiresPrivacyReview();
      }
      
      public String getResettableDeviceId() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getResettableDeviceId();
      }
      
      public ByteString getResettableDeviceIdBytes() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getResettableDeviceIdBytes();
      }
      
      public int getRetryCounter() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getRetryCounter();
      }
      
      public boolean getServiceUpload() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getServiceUpload();
      }
      
      public String getSsaid() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getSsaid();
      }
      
      public ByteString getSsaidBytes() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getSsaidBytes();
      }
      
      public long getStartTimestampMillis() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getStartTimestampMillis();
      }
      
      public int getTimeZoneOffsetMinutes() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getTimeZoneOffsetMinutes();
      }
      
      public long getUploadTimestampMillis() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getUploadTimestampMillis();
      }
      
      public long getUploadingGmpVersion() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getUploadingGmpVersion();
      }
      
      public GmpMeasurement.UserAttribute getUserAttributes(int param2Int) {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getUserAttributes(param2Int);
      }
      
      public int getUserAttributesCount() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getUserAttributesCount();
      }
      
      public List<GmpMeasurement.UserAttribute> getUserAttributesList() {
        return Collections.unmodifiableList(((GmpMeasurement.MeasurementBundle)this.instance).getUserAttributesList());
      }
      
      public String getUserDefaultLanguage() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getUserDefaultLanguage();
      }
      
      public ByteString getUserDefaultLanguageBytes() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getUserDefaultLanguageBytes();
      }
      
      public String getVendorDeviceId() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getVendorDeviceId();
      }
      
      public ByteString getVendorDeviceIdBytes() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).getVendorDeviceIdBytes();
      }
      
      public boolean hasAdmobAppId() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasAdmobAppId();
      }
      
      public boolean hasAppId() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasAppId();
      }
      
      public boolean hasAppIdNumeric() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasAppIdNumeric();
      }
      
      public boolean hasAppInstanceId() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasAppInstanceId();
      }
      
      public boolean hasAppStore() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasAppStore();
      }
      
      public boolean hasAppVersion() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasAppVersion();
      }
      
      public boolean hasAppVersionMajor() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasAppVersionMajor();
      }
      
      public boolean hasAppVersionMinor() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasAppVersionMinor();
      }
      
      public boolean hasAppVersionRelease() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasAppVersionRelease();
      }
      
      public boolean hasBundleAlsoLoggedInGaia() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasBundleAlsoLoggedInGaia();
      }
      
      public boolean hasBundleSequentialIndex() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasBundleSequentialIndex();
      }
      
      public boolean hasConfigVersion() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasConfigVersion();
      }
      
      public boolean hasDevCertHash() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasDevCertHash();
      }
      
      public boolean hasDeviceModel() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasDeviceModel();
      }
      
      public boolean hasDsid() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasDsid();
      }
      
      public boolean hasEndTimestampMillis() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasEndTimestampMillis();
      }
      
      public boolean hasExternalStreamId() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasExternalStreamId();
      }
      
      public boolean hasFirebaseInstanceId() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasFirebaseInstanceId();
      }
      
      public boolean hasGaiaInfo() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasGaiaInfo();
      }
      
      public boolean hasGmpAppId() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasGmpAppId();
      }
      
      public boolean hasGmpVersion() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasGmpVersion();
      }
      
      public boolean hasHealthMonitor() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasHealthMonitor();
      }
      
      public boolean hasLimitedAdTracking() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasLimitedAdTracking();
      }
      
      public boolean hasOsVersion() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasOsVersion();
      }
      
      public boolean hasPlatform() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasPlatform();
      }
      
      public boolean hasPreviousBundleEndTimestampMillis() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasPreviousBundleEndTimestampMillis();
      }
      
      public boolean hasPreviousBundleStartTimestampMillis() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasPreviousBundleStartTimestampMillis();
      }
      
      public boolean hasProtocolVersion() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasProtocolVersion();
      }
      
      public boolean hasPseudonymousPrivacyInfoRequiresPrivacyReview() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasPseudonymousPrivacyInfoRequiresPrivacyReview();
      }
      
      public boolean hasResettableDeviceId() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasResettableDeviceId();
      }
      
      public boolean hasRetryCounter() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasRetryCounter();
      }
      
      public boolean hasServiceUpload() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasServiceUpload();
      }
      
      public boolean hasSsaid() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasSsaid();
      }
      
      public boolean hasStartTimestampMillis() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasStartTimestampMillis();
      }
      
      public boolean hasTimeZoneOffsetMinutes() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasTimeZoneOffsetMinutes();
      }
      
      public boolean hasUploadTimestampMillis() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasUploadTimestampMillis();
      }
      
      public boolean hasUploadingGmpVersion() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasUploadingGmpVersion();
      }
      
      public boolean hasUserDefaultLanguage() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasUserDefaultLanguage();
      }
      
      public boolean hasVendorDeviceId() {
        return ((GmpMeasurement.MeasurementBundle)this.instance).hasVendorDeviceId();
      }
      
      public Builder mergeGaiaInfo(GmpMeasurement.GaiaInfo param2GaiaInfo) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).mergeGaiaInfo(param2GaiaInfo);
        return this;
      }
      
      public Builder mergePseudonymousPrivacyInfoRequiresPrivacyReview(GmpMeasurement.PseudonymousPrivacyInfo param2PseudonymousPrivacyInfo) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).mergePseudonymousPrivacyInfoRequiresPrivacyReview(param2PseudonymousPrivacyInfo);
        return this;
      }
      
      public Builder removeAudienceEvaluationResults(int param2Int) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).removeAudienceEvaluationResults(param2Int);
        return this;
      }
      
      public Builder removeEvents(int param2Int) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).removeEvents(param2Int);
        return this;
      }
      
      public Builder removeUserAttributes(int param2Int) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).removeUserAttributes(param2Int);
        return this;
      }
      
      public Builder setAdmobAppId(String param2String) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setAdmobAppId(param2String);
        return this;
      }
      
      public Builder setAdmobAppIdBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setAdmobAppIdBytes(param2ByteString);
        return this;
      }
      
      public Builder setAppId(String param2String) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setAppId(param2String);
        return this;
      }
      
      public Builder setAppIdBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setAppIdBytes(param2ByteString);
        return this;
      }
      
      public Builder setAppIdNumeric(long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setAppIdNumeric(param2Long);
        return this;
      }
      
      public Builder setAppInstanceId(String param2String) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setAppInstanceId(param2String);
        return this;
      }
      
      public Builder setAppInstanceIdBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setAppInstanceIdBytes(param2ByteString);
        return this;
      }
      
      public Builder setAppStore(String param2String) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setAppStore(param2String);
        return this;
      }
      
      public Builder setAppStoreBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setAppStoreBytes(param2ByteString);
        return this;
      }
      
      public Builder setAppVersion(String param2String) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setAppVersion(param2String);
        return this;
      }
      
      public Builder setAppVersionBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setAppVersionBytes(param2ByteString);
        return this;
      }
      
      public Builder setAppVersionMajor(int param2Int) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setAppVersionMajor(param2Int);
        return this;
      }
      
      public Builder setAppVersionMinor(int param2Int) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setAppVersionMinor(param2Int);
        return this;
      }
      
      public Builder setAppVersionRelease(int param2Int) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setAppVersionRelease(param2Int);
        return this;
      }
      
      public Builder setAudienceEvaluationResults(int param2Int, GmpMeasurement.AudienceLeafFilterResult.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setAudienceEvaluationResults(param2Int, param2Builder);
        return this;
      }
      
      public Builder setAudienceEvaluationResults(int param2Int, GmpMeasurement.AudienceLeafFilterResult param2AudienceLeafFilterResult) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setAudienceEvaluationResults(param2Int, param2AudienceLeafFilterResult);
        return this;
      }
      
      public Builder setBundleAlsoLoggedInGaia(boolean param2Boolean) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setBundleAlsoLoggedInGaia(param2Boolean);
        return this;
      }
      
      public Builder setBundleSequentialIndex(int param2Int) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setBundleSequentialIndex(param2Int);
        return this;
      }
      
      public Builder setConfigVersion(long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setConfigVersion(param2Long);
        return this;
      }
      
      public Builder setDevCertHash(long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setDevCertHash(param2Long);
        return this;
      }
      
      public Builder setDeviceModel(String param2String) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setDeviceModel(param2String);
        return this;
      }
      
      public Builder setDeviceModelBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setDeviceModelBytes(param2ByteString);
        return this;
      }
      
      public Builder setDsid(String param2String) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setDsid(param2String);
        return this;
      }
      
      public Builder setDsidBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setDsidBytes(param2ByteString);
        return this;
      }
      
      public Builder setEndTimestampMillis(long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setEndTimestampMillis(param2Long);
        return this;
      }
      
      public Builder setEvents(int param2Int, GmpMeasurement.Event.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setEvents(param2Int, param2Builder);
        return this;
      }
      
      public Builder setEvents(int param2Int, GmpMeasurement.Event param2Event) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setEvents(param2Int, param2Event);
        return this;
      }
      
      public Builder setExternalStreamId(String param2String) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setExternalStreamId(param2String);
        return this;
      }
      
      public Builder setExternalStreamIdBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setExternalStreamIdBytes(param2ByteString);
        return this;
      }
      
      public Builder setFirebaseInstanceId(String param2String) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setFirebaseInstanceId(param2String);
        return this;
      }
      
      public Builder setFirebaseInstanceIdBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setFirebaseInstanceIdBytes(param2ByteString);
        return this;
      }
      
      public Builder setGaiaInfo(GmpMeasurement.GaiaInfo.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setGaiaInfo(param2Builder);
        return this;
      }
      
      public Builder setGaiaInfo(GmpMeasurement.GaiaInfo param2GaiaInfo) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setGaiaInfo(param2GaiaInfo);
        return this;
      }
      
      public Builder setGmpAppId(String param2String) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setGmpAppId(param2String);
        return this;
      }
      
      public Builder setGmpAppIdBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setGmpAppIdBytes(param2ByteString);
        return this;
      }
      
      public Builder setGmpVersion(long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setGmpVersion(param2Long);
        return this;
      }
      
      public Builder setHealthMonitor(String param2String) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setHealthMonitor(param2String);
        return this;
      }
      
      public Builder setHealthMonitorBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setHealthMonitorBytes(param2ByteString);
        return this;
      }
      
      public Builder setLimitedAdTracking(boolean param2Boolean) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setLimitedAdTracking(param2Boolean);
        return this;
      }
      
      public Builder setOsVersion(String param2String) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setOsVersion(param2String);
        return this;
      }
      
      public Builder setOsVersionBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setOsVersionBytes(param2ByteString);
        return this;
      }
      
      public Builder setPlatform(String param2String) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setPlatform(param2String);
        return this;
      }
      
      public Builder setPlatformBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setPlatformBytes(param2ByteString);
        return this;
      }
      
      public Builder setPreviousBundleEndTimestampMillis(long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setPreviousBundleEndTimestampMillis(param2Long);
        return this;
      }
      
      public Builder setPreviousBundleStartTimestampMillis(long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setPreviousBundleStartTimestampMillis(param2Long);
        return this;
      }
      
      public Builder setProtocolVersion(int param2Int) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setProtocolVersion(param2Int);
        return this;
      }
      
      public Builder setPseudonymousPrivacyInfoRequiresPrivacyReview(GmpMeasurement.PseudonymousPrivacyInfo.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setPseudonymousPrivacyInfoRequiresPrivacyReview(param2Builder);
        return this;
      }
      
      public Builder setPseudonymousPrivacyInfoRequiresPrivacyReview(GmpMeasurement.PseudonymousPrivacyInfo param2PseudonymousPrivacyInfo) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setPseudonymousPrivacyInfoRequiresPrivacyReview(param2PseudonymousPrivacyInfo);
        return this;
      }
      
      public Builder setResettableDeviceId(String param2String) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setResettableDeviceId(param2String);
        return this;
      }
      
      public Builder setResettableDeviceIdBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setResettableDeviceIdBytes(param2ByteString);
        return this;
      }
      
      public Builder setRetryCounter(int param2Int) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setRetryCounter(param2Int);
        return this;
      }
      
      public Builder setServiceUpload(boolean param2Boolean) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setServiceUpload(param2Boolean);
        return this;
      }
      
      public Builder setSsaid(String param2String) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setSsaid(param2String);
        return this;
      }
      
      public Builder setSsaidBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setSsaidBytes(param2ByteString);
        return this;
      }
      
      public Builder setStartTimestampMillis(long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setStartTimestampMillis(param2Long);
        return this;
      }
      
      public Builder setTimeZoneOffsetMinutes(int param2Int) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setTimeZoneOffsetMinutes(param2Int);
        return this;
      }
      
      public Builder setUploadTimestampMillis(long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setUploadTimestampMillis(param2Long);
        return this;
      }
      
      public Builder setUploadingGmpVersion(long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setUploadingGmpVersion(param2Long);
        return this;
      }
      
      public Builder setUserAttributes(int param2Int, GmpMeasurement.UserAttribute.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setUserAttributes(param2Int, param2Builder);
        return this;
      }
      
      public Builder setUserAttributes(int param2Int, GmpMeasurement.UserAttribute param2UserAttribute) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setUserAttributes(param2Int, param2UserAttribute);
        return this;
      }
      
      public Builder setUserDefaultLanguage(String param2String) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setUserDefaultLanguage(param2String);
        return this;
      }
      
      public Builder setUserDefaultLanguageBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setUserDefaultLanguageBytes(param2ByteString);
        return this;
      }
      
      public Builder setVendorDeviceId(String param2String) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setVendorDeviceId(param2String);
        return this;
      }
      
      public Builder setVendorDeviceIdBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurement.MeasurementBundle)this.instance).setVendorDeviceIdBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<MeasurementBundle, MeasurementBundle.Builder> implements MeasurementBundleOrBuilder {
    private Builder() {
      super(GmpMeasurement.MeasurementBundle.DEFAULT_INSTANCE);
    }
    
    public Builder addAllAudienceEvaluationResults(Iterable<? extends GmpMeasurement.AudienceLeafFilterResult> param1Iterable) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).addAllAudienceEvaluationResults(param1Iterable);
      return this;
    }
    
    public Builder addAllEvents(Iterable<? extends GmpMeasurement.Event> param1Iterable) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).addAllEvents(param1Iterable);
      return this;
    }
    
    public Builder addAllUserAttributes(Iterable<? extends GmpMeasurement.UserAttribute> param1Iterable) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).addAllUserAttributes(param1Iterable);
      return this;
    }
    
    public Builder addAudienceEvaluationResults(int param1Int, GmpMeasurement.AudienceLeafFilterResult.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).addAudienceEvaluationResults(param1Int, param1Builder);
      return this;
    }
    
    public Builder addAudienceEvaluationResults(int param1Int, GmpMeasurement.AudienceLeafFilterResult param1AudienceLeafFilterResult) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).addAudienceEvaluationResults(param1Int, param1AudienceLeafFilterResult);
      return this;
    }
    
    public Builder addAudienceEvaluationResults(GmpMeasurement.AudienceLeafFilterResult.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).addAudienceEvaluationResults(param1Builder);
      return this;
    }
    
    public Builder addAudienceEvaluationResults(GmpMeasurement.AudienceLeafFilterResult param1AudienceLeafFilterResult) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).addAudienceEvaluationResults(param1AudienceLeafFilterResult);
      return this;
    }
    
    public Builder addEvents(int param1Int, GmpMeasurement.Event.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).addEvents(param1Int, param1Builder);
      return this;
    }
    
    public Builder addEvents(int param1Int, GmpMeasurement.Event param1Event) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).addEvents(param1Int, param1Event);
      return this;
    }
    
    public Builder addEvents(GmpMeasurement.Event.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).addEvents(param1Builder);
      return this;
    }
    
    public Builder addEvents(GmpMeasurement.Event param1Event) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).addEvents(param1Event);
      return this;
    }
    
    public Builder addUserAttributes(int param1Int, GmpMeasurement.UserAttribute.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).addUserAttributes(param1Int, param1Builder);
      return this;
    }
    
    public Builder addUserAttributes(int param1Int, GmpMeasurement.UserAttribute param1UserAttribute) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).addUserAttributes(param1Int, param1UserAttribute);
      return this;
    }
    
    public Builder addUserAttributes(GmpMeasurement.UserAttribute.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).addUserAttributes(param1Builder);
      return this;
    }
    
    public Builder addUserAttributes(GmpMeasurement.UserAttribute param1UserAttribute) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).addUserAttributes(param1UserAttribute);
      return this;
    }
    
    public Builder clearAdmobAppId() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearAdmobAppId();
      return this;
    }
    
    public Builder clearAppId() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearAppId();
      return this;
    }
    
    public Builder clearAppIdNumeric() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearAppIdNumeric();
      return this;
    }
    
    public Builder clearAppInstanceId() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearAppInstanceId();
      return this;
    }
    
    public Builder clearAppStore() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearAppStore();
      return this;
    }
    
    public Builder clearAppVersion() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearAppVersion();
      return this;
    }
    
    public Builder clearAppVersionMajor() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearAppVersionMajor();
      return this;
    }
    
    public Builder clearAppVersionMinor() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearAppVersionMinor();
      return this;
    }
    
    public Builder clearAppVersionRelease() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearAppVersionRelease();
      return this;
    }
    
    public Builder clearAudienceEvaluationResults() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearAudienceEvaluationResults();
      return this;
    }
    
    public Builder clearBundleAlsoLoggedInGaia() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearBundleAlsoLoggedInGaia();
      return this;
    }
    
    public Builder clearBundleSequentialIndex() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearBundleSequentialIndex();
      return this;
    }
    
    public Builder clearConfigVersion() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearConfigVersion();
      return this;
    }
    
    public Builder clearDevCertHash() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearDevCertHash();
      return this;
    }
    
    public Builder clearDeviceModel() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearDeviceModel();
      return this;
    }
    
    public Builder clearDsid() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearDsid();
      return this;
    }
    
    public Builder clearEndTimestampMillis() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearEndTimestampMillis();
      return this;
    }
    
    public Builder clearEvents() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearEvents();
      return this;
    }
    
    public Builder clearExternalStreamId() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearExternalStreamId();
      return this;
    }
    
    public Builder clearFirebaseInstanceId() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearFirebaseInstanceId();
      return this;
    }
    
    public Builder clearGaiaInfo() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearGaiaInfo();
      return this;
    }
    
    public Builder clearGmpAppId() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearGmpAppId();
      return this;
    }
    
    public Builder clearGmpVersion() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearGmpVersion();
      return this;
    }
    
    public Builder clearHealthMonitor() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearHealthMonitor();
      return this;
    }
    
    public Builder clearLimitedAdTracking() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearLimitedAdTracking();
      return this;
    }
    
    public Builder clearOsVersion() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearOsVersion();
      return this;
    }
    
    public Builder clearPlatform() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearPlatform();
      return this;
    }
    
    public Builder clearPreviousBundleEndTimestampMillis() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearPreviousBundleEndTimestampMillis();
      return this;
    }
    
    public Builder clearPreviousBundleStartTimestampMillis() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearPreviousBundleStartTimestampMillis();
      return this;
    }
    
    public Builder clearProtocolVersion() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearProtocolVersion();
      return this;
    }
    
    public Builder clearPseudonymousPrivacyInfoRequiresPrivacyReview() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearPseudonymousPrivacyInfoRequiresPrivacyReview();
      return this;
    }
    
    public Builder clearResettableDeviceId() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearResettableDeviceId();
      return this;
    }
    
    public Builder clearRetryCounter() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearRetryCounter();
      return this;
    }
    
    public Builder clearServiceUpload() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearServiceUpload();
      return this;
    }
    
    public Builder clearSsaid() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearSsaid();
      return this;
    }
    
    public Builder clearStartTimestampMillis() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearStartTimestampMillis();
      return this;
    }
    
    public Builder clearTimeZoneOffsetMinutes() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearTimeZoneOffsetMinutes();
      return this;
    }
    
    public Builder clearUploadTimestampMillis() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearUploadTimestampMillis();
      return this;
    }
    
    public Builder clearUploadingGmpVersion() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearUploadingGmpVersion();
      return this;
    }
    
    public Builder clearUserAttributes() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearUserAttributes();
      return this;
    }
    
    public Builder clearUserDefaultLanguage() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearUserDefaultLanguage();
      return this;
    }
    
    public Builder clearVendorDeviceId() {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).clearVendorDeviceId();
      return this;
    }
    
    public String getAdmobAppId() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getAdmobAppId();
    }
    
    public ByteString getAdmobAppIdBytes() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getAdmobAppIdBytes();
    }
    
    public String getAppId() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getAppId();
    }
    
    public ByteString getAppIdBytes() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getAppIdBytes();
    }
    
    public long getAppIdNumeric() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getAppIdNumeric();
    }
    
    public String getAppInstanceId() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getAppInstanceId();
    }
    
    public ByteString getAppInstanceIdBytes() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getAppInstanceIdBytes();
    }
    
    public String getAppStore() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getAppStore();
    }
    
    public ByteString getAppStoreBytes() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getAppStoreBytes();
    }
    
    public String getAppVersion() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getAppVersion();
    }
    
    public ByteString getAppVersionBytes() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getAppVersionBytes();
    }
    
    public int getAppVersionMajor() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getAppVersionMajor();
    }
    
    public int getAppVersionMinor() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getAppVersionMinor();
    }
    
    public int getAppVersionRelease() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getAppVersionRelease();
    }
    
    public GmpMeasurement.AudienceLeafFilterResult getAudienceEvaluationResults(int param1Int) {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getAudienceEvaluationResults(param1Int);
    }
    
    public int getAudienceEvaluationResultsCount() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getAudienceEvaluationResultsCount();
    }
    
    public List<GmpMeasurement.AudienceLeafFilterResult> getAudienceEvaluationResultsList() {
      return Collections.unmodifiableList(((GmpMeasurement.MeasurementBundle)this.instance).getAudienceEvaluationResultsList());
    }
    
    public boolean getBundleAlsoLoggedInGaia() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getBundleAlsoLoggedInGaia();
    }
    
    public int getBundleSequentialIndex() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getBundleSequentialIndex();
    }
    
    public long getConfigVersion() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getConfigVersion();
    }
    
    public long getDevCertHash() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getDevCertHash();
    }
    
    public String getDeviceModel() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getDeviceModel();
    }
    
    public ByteString getDeviceModelBytes() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getDeviceModelBytes();
    }
    
    public String getDsid() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getDsid();
    }
    
    public ByteString getDsidBytes() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getDsidBytes();
    }
    
    public long getEndTimestampMillis() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getEndTimestampMillis();
    }
    
    public GmpMeasurement.Event getEvents(int param1Int) {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getEvents(param1Int);
    }
    
    public int getEventsCount() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getEventsCount();
    }
    
    public List<GmpMeasurement.Event> getEventsList() {
      return Collections.unmodifiableList(((GmpMeasurement.MeasurementBundle)this.instance).getEventsList());
    }
    
    public String getExternalStreamId() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getExternalStreamId();
    }
    
    public ByteString getExternalStreamIdBytes() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getExternalStreamIdBytes();
    }
    
    public String getFirebaseInstanceId() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getFirebaseInstanceId();
    }
    
    public ByteString getFirebaseInstanceIdBytes() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getFirebaseInstanceIdBytes();
    }
    
    public GmpMeasurement.GaiaInfo getGaiaInfo() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getGaiaInfo();
    }
    
    public String getGmpAppId() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getGmpAppId();
    }
    
    public ByteString getGmpAppIdBytes() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getGmpAppIdBytes();
    }
    
    public long getGmpVersion() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getGmpVersion();
    }
    
    public String getHealthMonitor() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getHealthMonitor();
    }
    
    public ByteString getHealthMonitorBytes() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getHealthMonitorBytes();
    }
    
    public boolean getLimitedAdTracking() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getLimitedAdTracking();
    }
    
    public String getOsVersion() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getOsVersion();
    }
    
    public ByteString getOsVersionBytes() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getOsVersionBytes();
    }
    
    public String getPlatform() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getPlatform();
    }
    
    public ByteString getPlatformBytes() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getPlatformBytes();
    }
    
    public long getPreviousBundleEndTimestampMillis() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getPreviousBundleEndTimestampMillis();
    }
    
    public long getPreviousBundleStartTimestampMillis() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getPreviousBundleStartTimestampMillis();
    }
    
    public int getProtocolVersion() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getProtocolVersion();
    }
    
    public GmpMeasurement.PseudonymousPrivacyInfo getPseudonymousPrivacyInfoRequiresPrivacyReview() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getPseudonymousPrivacyInfoRequiresPrivacyReview();
    }
    
    public String getResettableDeviceId() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getResettableDeviceId();
    }
    
    public ByteString getResettableDeviceIdBytes() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getResettableDeviceIdBytes();
    }
    
    public int getRetryCounter() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getRetryCounter();
    }
    
    public boolean getServiceUpload() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getServiceUpload();
    }
    
    public String getSsaid() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getSsaid();
    }
    
    public ByteString getSsaidBytes() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getSsaidBytes();
    }
    
    public long getStartTimestampMillis() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getStartTimestampMillis();
    }
    
    public int getTimeZoneOffsetMinutes() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getTimeZoneOffsetMinutes();
    }
    
    public long getUploadTimestampMillis() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getUploadTimestampMillis();
    }
    
    public long getUploadingGmpVersion() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getUploadingGmpVersion();
    }
    
    public GmpMeasurement.UserAttribute getUserAttributes(int param1Int) {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getUserAttributes(param1Int);
    }
    
    public int getUserAttributesCount() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getUserAttributesCount();
    }
    
    public List<GmpMeasurement.UserAttribute> getUserAttributesList() {
      return Collections.unmodifiableList(((GmpMeasurement.MeasurementBundle)this.instance).getUserAttributesList());
    }
    
    public String getUserDefaultLanguage() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getUserDefaultLanguage();
    }
    
    public ByteString getUserDefaultLanguageBytes() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getUserDefaultLanguageBytes();
    }
    
    public String getVendorDeviceId() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getVendorDeviceId();
    }
    
    public ByteString getVendorDeviceIdBytes() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).getVendorDeviceIdBytes();
    }
    
    public boolean hasAdmobAppId() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasAdmobAppId();
    }
    
    public boolean hasAppId() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasAppId();
    }
    
    public boolean hasAppIdNumeric() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasAppIdNumeric();
    }
    
    public boolean hasAppInstanceId() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasAppInstanceId();
    }
    
    public boolean hasAppStore() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasAppStore();
    }
    
    public boolean hasAppVersion() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasAppVersion();
    }
    
    public boolean hasAppVersionMajor() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasAppVersionMajor();
    }
    
    public boolean hasAppVersionMinor() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasAppVersionMinor();
    }
    
    public boolean hasAppVersionRelease() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasAppVersionRelease();
    }
    
    public boolean hasBundleAlsoLoggedInGaia() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasBundleAlsoLoggedInGaia();
    }
    
    public boolean hasBundleSequentialIndex() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasBundleSequentialIndex();
    }
    
    public boolean hasConfigVersion() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasConfigVersion();
    }
    
    public boolean hasDevCertHash() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasDevCertHash();
    }
    
    public boolean hasDeviceModel() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasDeviceModel();
    }
    
    public boolean hasDsid() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasDsid();
    }
    
    public boolean hasEndTimestampMillis() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasEndTimestampMillis();
    }
    
    public boolean hasExternalStreamId() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasExternalStreamId();
    }
    
    public boolean hasFirebaseInstanceId() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasFirebaseInstanceId();
    }
    
    public boolean hasGaiaInfo() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasGaiaInfo();
    }
    
    public boolean hasGmpAppId() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasGmpAppId();
    }
    
    public boolean hasGmpVersion() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasGmpVersion();
    }
    
    public boolean hasHealthMonitor() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasHealthMonitor();
    }
    
    public boolean hasLimitedAdTracking() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasLimitedAdTracking();
    }
    
    public boolean hasOsVersion() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasOsVersion();
    }
    
    public boolean hasPlatform() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasPlatform();
    }
    
    public boolean hasPreviousBundleEndTimestampMillis() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasPreviousBundleEndTimestampMillis();
    }
    
    public boolean hasPreviousBundleStartTimestampMillis() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasPreviousBundleStartTimestampMillis();
    }
    
    public boolean hasProtocolVersion() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasProtocolVersion();
    }
    
    public boolean hasPseudonymousPrivacyInfoRequiresPrivacyReview() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasPseudonymousPrivacyInfoRequiresPrivacyReview();
    }
    
    public boolean hasResettableDeviceId() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasResettableDeviceId();
    }
    
    public boolean hasRetryCounter() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasRetryCounter();
    }
    
    public boolean hasServiceUpload() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasServiceUpload();
    }
    
    public boolean hasSsaid() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasSsaid();
    }
    
    public boolean hasStartTimestampMillis() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasStartTimestampMillis();
    }
    
    public boolean hasTimeZoneOffsetMinutes() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasTimeZoneOffsetMinutes();
    }
    
    public boolean hasUploadTimestampMillis() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasUploadTimestampMillis();
    }
    
    public boolean hasUploadingGmpVersion() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasUploadingGmpVersion();
    }
    
    public boolean hasUserDefaultLanguage() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasUserDefaultLanguage();
    }
    
    public boolean hasVendorDeviceId() {
      return ((GmpMeasurement.MeasurementBundle)this.instance).hasVendorDeviceId();
    }
    
    public Builder mergeGaiaInfo(GmpMeasurement.GaiaInfo param1GaiaInfo) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).mergeGaiaInfo(param1GaiaInfo);
      return this;
    }
    
    public Builder mergePseudonymousPrivacyInfoRequiresPrivacyReview(GmpMeasurement.PseudonymousPrivacyInfo param1PseudonymousPrivacyInfo) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).mergePseudonymousPrivacyInfoRequiresPrivacyReview(param1PseudonymousPrivacyInfo);
      return this;
    }
    
    public Builder removeAudienceEvaluationResults(int param1Int) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).removeAudienceEvaluationResults(param1Int);
      return this;
    }
    
    public Builder removeEvents(int param1Int) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).removeEvents(param1Int);
      return this;
    }
    
    public Builder removeUserAttributes(int param1Int) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).removeUserAttributes(param1Int);
      return this;
    }
    
    public Builder setAdmobAppId(String param1String) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setAdmobAppId(param1String);
      return this;
    }
    
    public Builder setAdmobAppIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setAdmobAppIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setAppId(String param1String) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setAppId(param1String);
      return this;
    }
    
    public Builder setAppIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setAppIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setAppIdNumeric(long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setAppIdNumeric(param1Long);
      return this;
    }
    
    public Builder setAppInstanceId(String param1String) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setAppInstanceId(param1String);
      return this;
    }
    
    public Builder setAppInstanceIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setAppInstanceIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setAppStore(String param1String) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setAppStore(param1String);
      return this;
    }
    
    public Builder setAppStoreBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setAppStoreBytes(param1ByteString);
      return this;
    }
    
    public Builder setAppVersion(String param1String) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setAppVersion(param1String);
      return this;
    }
    
    public Builder setAppVersionBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setAppVersionBytes(param1ByteString);
      return this;
    }
    
    public Builder setAppVersionMajor(int param1Int) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setAppVersionMajor(param1Int);
      return this;
    }
    
    public Builder setAppVersionMinor(int param1Int) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setAppVersionMinor(param1Int);
      return this;
    }
    
    public Builder setAppVersionRelease(int param1Int) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setAppVersionRelease(param1Int);
      return this;
    }
    
    public Builder setAudienceEvaluationResults(int param1Int, GmpMeasurement.AudienceLeafFilterResult.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setAudienceEvaluationResults(param1Int, param1Builder);
      return this;
    }
    
    public Builder setAudienceEvaluationResults(int param1Int, GmpMeasurement.AudienceLeafFilterResult param1AudienceLeafFilterResult) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setAudienceEvaluationResults(param1Int, param1AudienceLeafFilterResult);
      return this;
    }
    
    public Builder setBundleAlsoLoggedInGaia(boolean param1Boolean) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setBundleAlsoLoggedInGaia(param1Boolean);
      return this;
    }
    
    public Builder setBundleSequentialIndex(int param1Int) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setBundleSequentialIndex(param1Int);
      return this;
    }
    
    public Builder setConfigVersion(long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setConfigVersion(param1Long);
      return this;
    }
    
    public Builder setDevCertHash(long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setDevCertHash(param1Long);
      return this;
    }
    
    public Builder setDeviceModel(String param1String) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setDeviceModel(param1String);
      return this;
    }
    
    public Builder setDeviceModelBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setDeviceModelBytes(param1ByteString);
      return this;
    }
    
    public Builder setDsid(String param1String) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setDsid(param1String);
      return this;
    }
    
    public Builder setDsidBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setDsidBytes(param1ByteString);
      return this;
    }
    
    public Builder setEndTimestampMillis(long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setEndTimestampMillis(param1Long);
      return this;
    }
    
    public Builder setEvents(int param1Int, GmpMeasurement.Event.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setEvents(param1Int, param1Builder);
      return this;
    }
    
    public Builder setEvents(int param1Int, GmpMeasurement.Event param1Event) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setEvents(param1Int, param1Event);
      return this;
    }
    
    public Builder setExternalStreamId(String param1String) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setExternalStreamId(param1String);
      return this;
    }
    
    public Builder setExternalStreamIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setExternalStreamIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setFirebaseInstanceId(String param1String) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setFirebaseInstanceId(param1String);
      return this;
    }
    
    public Builder setFirebaseInstanceIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setFirebaseInstanceIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setGaiaInfo(GmpMeasurement.GaiaInfo.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setGaiaInfo(param1Builder);
      return this;
    }
    
    public Builder setGaiaInfo(GmpMeasurement.GaiaInfo param1GaiaInfo) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setGaiaInfo(param1GaiaInfo);
      return this;
    }
    
    public Builder setGmpAppId(String param1String) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setGmpAppId(param1String);
      return this;
    }
    
    public Builder setGmpAppIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setGmpAppIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setGmpVersion(long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setGmpVersion(param1Long);
      return this;
    }
    
    public Builder setHealthMonitor(String param1String) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setHealthMonitor(param1String);
      return this;
    }
    
    public Builder setHealthMonitorBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setHealthMonitorBytes(param1ByteString);
      return this;
    }
    
    public Builder setLimitedAdTracking(boolean param1Boolean) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setLimitedAdTracking(param1Boolean);
      return this;
    }
    
    public Builder setOsVersion(String param1String) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setOsVersion(param1String);
      return this;
    }
    
    public Builder setOsVersionBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setOsVersionBytes(param1ByteString);
      return this;
    }
    
    public Builder setPlatform(String param1String) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setPlatform(param1String);
      return this;
    }
    
    public Builder setPlatformBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setPlatformBytes(param1ByteString);
      return this;
    }
    
    public Builder setPreviousBundleEndTimestampMillis(long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setPreviousBundleEndTimestampMillis(param1Long);
      return this;
    }
    
    public Builder setPreviousBundleStartTimestampMillis(long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setPreviousBundleStartTimestampMillis(param1Long);
      return this;
    }
    
    public Builder setProtocolVersion(int param1Int) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setProtocolVersion(param1Int);
      return this;
    }
    
    public Builder setPseudonymousPrivacyInfoRequiresPrivacyReview(GmpMeasurement.PseudonymousPrivacyInfo.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setPseudonymousPrivacyInfoRequiresPrivacyReview(param1Builder);
      return this;
    }
    
    public Builder setPseudonymousPrivacyInfoRequiresPrivacyReview(GmpMeasurement.PseudonymousPrivacyInfo param1PseudonymousPrivacyInfo) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setPseudonymousPrivacyInfoRequiresPrivacyReview(param1PseudonymousPrivacyInfo);
      return this;
    }
    
    public Builder setResettableDeviceId(String param1String) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setResettableDeviceId(param1String);
      return this;
    }
    
    public Builder setResettableDeviceIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setResettableDeviceIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setRetryCounter(int param1Int) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setRetryCounter(param1Int);
      return this;
    }
    
    public Builder setServiceUpload(boolean param1Boolean) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setServiceUpload(param1Boolean);
      return this;
    }
    
    public Builder setSsaid(String param1String) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setSsaid(param1String);
      return this;
    }
    
    public Builder setSsaidBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setSsaidBytes(param1ByteString);
      return this;
    }
    
    public Builder setStartTimestampMillis(long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setStartTimestampMillis(param1Long);
      return this;
    }
    
    public Builder setTimeZoneOffsetMinutes(int param1Int) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setTimeZoneOffsetMinutes(param1Int);
      return this;
    }
    
    public Builder setUploadTimestampMillis(long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setUploadTimestampMillis(param1Long);
      return this;
    }
    
    public Builder setUploadingGmpVersion(long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setUploadingGmpVersion(param1Long);
      return this;
    }
    
    public Builder setUserAttributes(int param1Int, GmpMeasurement.UserAttribute.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setUserAttributes(param1Int, param1Builder);
      return this;
    }
    
    public Builder setUserAttributes(int param1Int, GmpMeasurement.UserAttribute param1UserAttribute) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setUserAttributes(param1Int, param1UserAttribute);
      return this;
    }
    
    public Builder setUserDefaultLanguage(String param1String) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setUserDefaultLanguage(param1String);
      return this;
    }
    
    public Builder setUserDefaultLanguageBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setUserDefaultLanguageBytes(param1ByteString);
      return this;
    }
    
    public Builder setVendorDeviceId(String param1String) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setVendorDeviceId(param1String);
      return this;
    }
    
    public Builder setVendorDeviceIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurement.MeasurementBundle)this.instance).setVendorDeviceIdBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface MeasurementBundleOrBuilder extends MessageLiteOrBuilder {
    String getAdmobAppId();
    
    ByteString getAdmobAppIdBytes();
    
    String getAppId();
    
    ByteString getAppIdBytes();
    
    long getAppIdNumeric();
    
    String getAppInstanceId();
    
    ByteString getAppInstanceIdBytes();
    
    String getAppStore();
    
    ByteString getAppStoreBytes();
    
    String getAppVersion();
    
    ByteString getAppVersionBytes();
    
    int getAppVersionMajor();
    
    int getAppVersionMinor();
    
    int getAppVersionRelease();
    
    GmpMeasurement.AudienceLeafFilterResult getAudienceEvaluationResults(int param1Int);
    
    int getAudienceEvaluationResultsCount();
    
    List<GmpMeasurement.AudienceLeafFilterResult> getAudienceEvaluationResultsList();
    
    boolean getBundleAlsoLoggedInGaia();
    
    int getBundleSequentialIndex();
    
    long getConfigVersion();
    
    long getDevCertHash();
    
    String getDeviceModel();
    
    ByteString getDeviceModelBytes();
    
    String getDsid();
    
    ByteString getDsidBytes();
    
    long getEndTimestampMillis();
    
    GmpMeasurement.Event getEvents(int param1Int);
    
    int getEventsCount();
    
    List<GmpMeasurement.Event> getEventsList();
    
    String getExternalStreamId();
    
    ByteString getExternalStreamIdBytes();
    
    String getFirebaseInstanceId();
    
    ByteString getFirebaseInstanceIdBytes();
    
    GmpMeasurement.GaiaInfo getGaiaInfo();
    
    String getGmpAppId();
    
    ByteString getGmpAppIdBytes();
    
    long getGmpVersion();
    
    String getHealthMonitor();
    
    ByteString getHealthMonitorBytes();
    
    boolean getLimitedAdTracking();
    
    String getOsVersion();
    
    ByteString getOsVersionBytes();
    
    String getPlatform();
    
    ByteString getPlatformBytes();
    
    long getPreviousBundleEndTimestampMillis();
    
    long getPreviousBundleStartTimestampMillis();
    
    int getProtocolVersion();
    
    GmpMeasurement.PseudonymousPrivacyInfo getPseudonymousPrivacyInfoRequiresPrivacyReview();
    
    String getResettableDeviceId();
    
    ByteString getResettableDeviceIdBytes();
    
    int getRetryCounter();
    
    boolean getServiceUpload();
    
    String getSsaid();
    
    ByteString getSsaidBytes();
    
    long getStartTimestampMillis();
    
    int getTimeZoneOffsetMinutes();
    
    long getUploadTimestampMillis();
    
    long getUploadingGmpVersion();
    
    GmpMeasurement.UserAttribute getUserAttributes(int param1Int);
    
    int getUserAttributesCount();
    
    List<GmpMeasurement.UserAttribute> getUserAttributesList();
    
    String getUserDefaultLanguage();
    
    ByteString getUserDefaultLanguageBytes();
    
    String getVendorDeviceId();
    
    ByteString getVendorDeviceIdBytes();
    
    boolean hasAdmobAppId();
    
    boolean hasAppId();
    
    boolean hasAppIdNumeric();
    
    boolean hasAppInstanceId();
    
    boolean hasAppStore();
    
    boolean hasAppVersion();
    
    boolean hasAppVersionMajor();
    
    boolean hasAppVersionMinor();
    
    boolean hasAppVersionRelease();
    
    boolean hasBundleAlsoLoggedInGaia();
    
    boolean hasBundleSequentialIndex();
    
    boolean hasConfigVersion();
    
    boolean hasDevCertHash();
    
    boolean hasDeviceModel();
    
    boolean hasDsid();
    
    boolean hasEndTimestampMillis();
    
    boolean hasExternalStreamId();
    
    boolean hasFirebaseInstanceId();
    
    boolean hasGaiaInfo();
    
    boolean hasGmpAppId();
    
    boolean hasGmpVersion();
    
    boolean hasHealthMonitor();
    
    boolean hasLimitedAdTracking();
    
    boolean hasOsVersion();
    
    boolean hasPlatform();
    
    boolean hasPreviousBundleEndTimestampMillis();
    
    boolean hasPreviousBundleStartTimestampMillis();
    
    boolean hasProtocolVersion();
    
    boolean hasPseudonymousPrivacyInfoRequiresPrivacyReview();
    
    boolean hasResettableDeviceId();
    
    boolean hasRetryCounter();
    
    boolean hasServiceUpload();
    
    boolean hasSsaid();
    
    boolean hasStartTimestampMillis();
    
    boolean hasTimeZoneOffsetMinutes();
    
    boolean hasUploadTimestampMillis();
    
    boolean hasUploadingGmpVersion();
    
    boolean hasUserDefaultLanguage();
    
    boolean hasVendorDeviceId();
  }
  
  public static final class PseudonymousPrivacyInfo extends GeneratedMessageLite<PseudonymousPrivacyInfo, PseudonymousPrivacyInfo.Builder> implements PseudonymousPrivacyInfoOrBuilder {
    private static final PseudonymousPrivacyInfo DEFAULT_INSTANCE = new PseudonymousPrivacyInfo();
    
    public static final int LOW_LEVEL_INFO_FIELD_NUMBER = 2;
    
    private static volatile Parser<PseudonymousPrivacyInfo> PARSER;
    
    public static final int PRIVACY_MODIFIERS_FIELD_NUMBER = 1;
    
    private int bitField0_;
    
    private LoggedLowLevelPrivacyInfo lowLevelInfo_;
    
    private long privacyModifiers_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearLowLevelInfo() {
      this.lowLevelInfo_ = null;
      this.bitField0_ &= 0xFFFFFFFD;
    }
    
    private void clearPrivacyModifiers() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.privacyModifiers_ = 0L;
    }
    
    public static PseudonymousPrivacyInfo getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeLowLevelInfo(LoggedLowLevelPrivacyInfo param1LoggedLowLevelPrivacyInfo) {
      LoggedLowLevelPrivacyInfo loggedLowLevelPrivacyInfo = this.lowLevelInfo_;
      if (loggedLowLevelPrivacyInfo != null && loggedLowLevelPrivacyInfo != LoggedLowLevelPrivacyInfo.getDefaultInstance()) {
        this.lowLevelInfo_ = (LoggedLowLevelPrivacyInfo)((LoggedLowLevelPrivacyInfo.Builder)LoggedLowLevelPrivacyInfo.newBuilder(this.lowLevelInfo_).mergeFrom(param1LoggedLowLevelPrivacyInfo)).buildPartial();
      } else {
        this.lowLevelInfo_ = param1LoggedLowLevelPrivacyInfo;
      } 
      this.bitField0_ |= 0x2;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(PseudonymousPrivacyInfo param1PseudonymousPrivacyInfo) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1PseudonymousPrivacyInfo);
    }
    
    public static PseudonymousPrivacyInfo parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (PseudonymousPrivacyInfo)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static PseudonymousPrivacyInfo parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PseudonymousPrivacyInfo)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static PseudonymousPrivacyInfo parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (PseudonymousPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static PseudonymousPrivacyInfo parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (PseudonymousPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static PseudonymousPrivacyInfo parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (PseudonymousPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static PseudonymousPrivacyInfo parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PseudonymousPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static PseudonymousPrivacyInfo parseFrom(InputStream param1InputStream) throws IOException {
      return (PseudonymousPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static PseudonymousPrivacyInfo parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PseudonymousPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static PseudonymousPrivacyInfo parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (PseudonymousPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static PseudonymousPrivacyInfo parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (PseudonymousPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<PseudonymousPrivacyInfo> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setLowLevelInfo(LoggedLowLevelPrivacyInfo.Builder param1Builder) {
      this.lowLevelInfo_ = (LoggedLowLevelPrivacyInfo)param1Builder.build();
      this.bitField0_ |= 0x2;
    }
    
    private void setLowLevelInfo(LoggedLowLevelPrivacyInfo param1LoggedLowLevelPrivacyInfo) {
      if (param1LoggedLowLevelPrivacyInfo != null) {
        this.lowLevelInfo_ = param1LoggedLowLevelPrivacyInfo;
        this.bitField0_ |= 0x2;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setPrivacyModifiers(long param1Long) {
      this.bitField0_ |= 0x1;
      this.privacyModifiers_ = param1Long;
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic analytics_collection/GmpMeasurement$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 422, 2 -> 418, 3 -> 416, 4 -> 407, 5 -> 328, 6 -> 110, 7 -> 324, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo
      //   72: monitorenter
      //   73: getstatic analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$PseudonymousPrivacyInfo;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo.PARSER : Lcom/google/protobuf/Parser;
      //   109: areturn
      //   110: aload_2
      //   111: checkcast com/google/protobuf/CodedInputStream
      //   114: astore_2
      //   115: aload_3
      //   116: checkcast com/google/protobuf/ExtensionRegistryLite
      //   119: astore_3
      //   120: iconst_0
      //   121: istore #4
      //   123: iload #4
      //   125: ifne -> 324
      //   128: aload_2
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 268
      //   139: iload #5
      //   141: bipush #8
      //   143: if_icmpeq -> 247
      //   146: iload #5
      //   148: bipush #18
      //   150: if_icmpeq -> 169
      //   153: aload_0
      //   154: iload #5
      //   156: aload_2
      //   157: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   160: ifne -> 123
      //   163: iconst_1
      //   164: istore #4
      //   166: goto -> 123
      //   169: aload_0
      //   170: getfield bitField0_ : I
      //   173: iconst_2
      //   174: iand
      //   175: iconst_2
      //   176: if_icmpne -> 193
      //   179: aload_0
      //   180: getfield lowLevelInfo_ : Lanalytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo;
      //   183: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   186: checkcast analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo$Builder
      //   189: astore_1
      //   190: goto -> 195
      //   193: aconst_null
      //   194: astore_1
      //   195: aload_0
      //   196: aload_2
      //   197: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   200: aload_3
      //   201: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   204: checkcast analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo
      //   207: putfield lowLevelInfo_ : Lanalytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo;
      //   210: aload_1
      //   211: ifnull -> 234
      //   214: aload_1
      //   215: aload_0
      //   216: getfield lowLevelInfo_ : Lanalytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo;
      //   219: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   222: pop
      //   223: aload_0
      //   224: aload_1
      //   225: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   228: checkcast analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo
      //   231: putfield lowLevelInfo_ : Lanalytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo;
      //   234: aload_0
      //   235: aload_0
      //   236: getfield bitField0_ : I
      //   239: iconst_2
      //   240: ior
      //   241: putfield bitField0_ : I
      //   244: goto -> 123
      //   247: aload_0
      //   248: aload_0
      //   249: getfield bitField0_ : I
      //   252: iconst_1
      //   253: ior
      //   254: putfield bitField0_ : I
      //   257: aload_0
      //   258: aload_2
      //   259: invokevirtual readUInt64 : ()J
      //   262: putfield privacyModifiers_ : J
      //   265: goto -> 123
      //   268: iconst_1
      //   269: istore #4
      //   271: goto -> 123
      //   274: astore_1
      //   275: goto -> 322
      //   278: astore_2
      //   279: new java/lang/RuntimeException
      //   282: astore_1
      //   283: new com/google/protobuf/InvalidProtocolBufferException
      //   286: astore_3
      //   287: aload_3
      //   288: aload_2
      //   289: invokevirtual getMessage : ()Ljava/lang/String;
      //   292: invokespecial <init> : (Ljava/lang/String;)V
      //   295: aload_1
      //   296: aload_3
      //   297: aload_0
      //   298: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   301: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   304: aload_1
      //   305: athrow
      //   306: astore_1
      //   307: new java/lang/RuntimeException
      //   310: astore_2
      //   311: aload_2
      //   312: aload_1
      //   313: aload_0
      //   314: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   317: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   320: aload_2
      //   321: athrow
      //   322: aload_1
      //   323: athrow
      //   324: getstatic analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$PseudonymousPrivacyInfo;
      //   327: areturn
      //   328: aload_2
      //   329: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   332: astore_1
      //   333: aload_3
      //   334: checkcast analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo
      //   337: astore_2
      //   338: aload_0
      //   339: aload_1
      //   340: aload_0
      //   341: invokevirtual hasPrivacyModifiers : ()Z
      //   344: aload_0
      //   345: getfield privacyModifiers_ : J
      //   348: aload_2
      //   349: invokevirtual hasPrivacyModifiers : ()Z
      //   352: aload_2
      //   353: getfield privacyModifiers_ : J
      //   356: invokeinterface visitLong : (ZJZJ)J
      //   361: putfield privacyModifiers_ : J
      //   364: aload_0
      //   365: aload_1
      //   366: aload_0
      //   367: getfield lowLevelInfo_ : Lanalytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo;
      //   370: aload_2
      //   371: getfield lowLevelInfo_ : Lanalytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo;
      //   374: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   379: checkcast analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo
      //   382: putfield lowLevelInfo_ : Lanalytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo;
      //   385: aload_1
      //   386: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   389: if_acmpne -> 405
      //   392: aload_0
      //   393: aload_0
      //   394: getfield bitField0_ : I
      //   397: aload_2
      //   398: getfield bitField0_ : I
      //   401: ior
      //   402: putfield bitField0_ : I
      //   405: aload_0
      //   406: areturn
      //   407: new analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$Builder
      //   410: dup
      //   411: aconst_null
      //   412: invokespecial <init> : (Lanalytics_collection/GmpMeasurement$1;)V
      //   415: areturn
      //   416: aconst_null
      //   417: areturn
      //   418: getstatic analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$PseudonymousPrivacyInfo;
      //   421: areturn
      //   422: new analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo
      //   425: dup
      //   426: invokespecial <init> : ()V
      //   429: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	306	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	278	java/io/IOException
      //   128	134	274	finally
      //   153	163	306	com/google/protobuf/InvalidProtocolBufferException
      //   153	163	278	java/io/IOException
      //   153	163	274	finally
      //   169	190	306	com/google/protobuf/InvalidProtocolBufferException
      //   169	190	278	java/io/IOException
      //   169	190	274	finally
      //   195	210	306	com/google/protobuf/InvalidProtocolBufferException
      //   195	210	278	java/io/IOException
      //   195	210	274	finally
      //   214	234	306	com/google/protobuf/InvalidProtocolBufferException
      //   214	234	278	java/io/IOException
      //   214	234	274	finally
      //   234	244	306	com/google/protobuf/InvalidProtocolBufferException
      //   234	244	278	java/io/IOException
      //   234	244	274	finally
      //   247	265	306	com/google/protobuf/InvalidProtocolBufferException
      //   247	265	278	java/io/IOException
      //   247	265	274	finally
      //   279	306	274	finally
      //   307	322	274	finally
    }
    
    public LoggedLowLevelPrivacyInfo getLowLevelInfo() {
      LoggedLowLevelPrivacyInfo loggedLowLevelPrivacyInfo1 = this.lowLevelInfo_;
      LoggedLowLevelPrivacyInfo loggedLowLevelPrivacyInfo2 = loggedLowLevelPrivacyInfo1;
      if (loggedLowLevelPrivacyInfo1 == null)
        loggedLowLevelPrivacyInfo2 = LoggedLowLevelPrivacyInfo.getDefaultInstance(); 
      return loggedLowLevelPrivacyInfo2;
    }
    
    public long getPrivacyModifiers() {
      return this.privacyModifiers_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if ((this.bitField0_ & 0x1) == 1)
        i = 0 + CodedOutputStream.computeUInt64Size(1, this.privacyModifiers_); 
      int j = i;
      if ((this.bitField0_ & 0x2) == 2)
        j = i + CodedOutputStream.computeMessageSize(2, (MessageLite)getLowLevelInfo()); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasLowLevelInfo() {
      boolean bool;
      if ((this.bitField0_ & 0x2) == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasPrivacyModifiers() {
      int i = this.bitField0_;
      boolean bool = true;
      if ((i & 0x1) != 1)
        bool = false; 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if ((this.bitField0_ & 0x1) == 1)
        param1CodedOutputStream.writeUInt64(1, this.privacyModifiers_); 
      if ((this.bitField0_ & 0x2) == 2)
        param1CodedOutputStream.writeMessage(2, (MessageLite)getLowLevelInfo()); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<PseudonymousPrivacyInfo, Builder> implements GmpMeasurement.PseudonymousPrivacyInfoOrBuilder {
      private Builder() {
        super(GmpMeasurement.PseudonymousPrivacyInfo.DEFAULT_INSTANCE);
      }
      
      public Builder clearLowLevelInfo() {
        copyOnWrite();
        ((GmpMeasurement.PseudonymousPrivacyInfo)this.instance).clearLowLevelInfo();
        return this;
      }
      
      public Builder clearPrivacyModifiers() {
        copyOnWrite();
        ((GmpMeasurement.PseudonymousPrivacyInfo)this.instance).clearPrivacyModifiers();
        return this;
      }
      
      public GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo getLowLevelInfo() {
        return ((GmpMeasurement.PseudonymousPrivacyInfo)this.instance).getLowLevelInfo();
      }
      
      public long getPrivacyModifiers() {
        return ((GmpMeasurement.PseudonymousPrivacyInfo)this.instance).getPrivacyModifiers();
      }
      
      public boolean hasLowLevelInfo() {
        return ((GmpMeasurement.PseudonymousPrivacyInfo)this.instance).hasLowLevelInfo();
      }
      
      public boolean hasPrivacyModifiers() {
        return ((GmpMeasurement.PseudonymousPrivacyInfo)this.instance).hasPrivacyModifiers();
      }
      
      public Builder mergeLowLevelInfo(GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo param2LoggedLowLevelPrivacyInfo) {
        copyOnWrite();
        ((GmpMeasurement.PseudonymousPrivacyInfo)this.instance).mergeLowLevelInfo(param2LoggedLowLevelPrivacyInfo);
        return this;
      }
      
      public Builder setLowLevelInfo(GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.PseudonymousPrivacyInfo)this.instance).setLowLevelInfo(param2Builder);
        return this;
      }
      
      public Builder setLowLevelInfo(GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo param2LoggedLowLevelPrivacyInfo) {
        copyOnWrite();
        ((GmpMeasurement.PseudonymousPrivacyInfo)this.instance).setLowLevelInfo(param2LoggedLowLevelPrivacyInfo);
        return this;
      }
      
      public Builder setPrivacyModifiers(long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.PseudonymousPrivacyInfo)this.instance).setPrivacyModifiers(param2Long);
        return this;
      }
    }
    
    public static final class LoggedLowLevelPrivacyInfo extends GeneratedMessageLite<LoggedLowLevelPrivacyInfo, LoggedLowLevelPrivacyInfo.Builder> implements LoggedLowLevelPrivacyInfoOrBuilder {
      private static final LoggedLowLevelPrivacyInfo DEFAULT_INSTANCE = new LoggedLowLevelPrivacyInfo();
      
      private static volatile Parser<LoggedLowLevelPrivacyInfo> PARSER;
      
      public static final int USER_CONTROLS_FIELD_NUMBER = 1;
      
      private int bitField0_;
      
      private long userControls_;
      
      static {
        DEFAULT_INSTANCE.makeImmutable();
      }
      
      private void clearUserControls() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.userControls_ = 0L;
      }
      
      public static LoggedLowLevelPrivacyInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
      }
      
      public static Builder newBuilder() {
        return (Builder)DEFAULT_INSTANCE.toBuilder();
      }
      
      public static Builder newBuilder(LoggedLowLevelPrivacyInfo param2LoggedLowLevelPrivacyInfo) {
        return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param2LoggedLowLevelPrivacyInfo);
      }
      
      public static LoggedLowLevelPrivacyInfo parseDelimitedFrom(InputStream param2InputStream) throws IOException {
        return (LoggedLowLevelPrivacyInfo)parseDelimitedFrom(DEFAULT_INSTANCE, param2InputStream);
      }
      
      public static LoggedLowLevelPrivacyInfo parseDelimitedFrom(InputStream param2InputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (LoggedLowLevelPrivacyInfo)parseDelimitedFrom(DEFAULT_INSTANCE, param2InputStream, param2ExtensionRegistryLite);
      }
      
      public static LoggedLowLevelPrivacyInfo parseFrom(ByteString param2ByteString) throws InvalidProtocolBufferException {
        return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ByteString);
      }
      
      public static LoggedLowLevelPrivacyInfo parseFrom(ByteString param2ByteString, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ByteString, param2ExtensionRegistryLite);
      }
      
      public static LoggedLowLevelPrivacyInfo parseFrom(CodedInputStream param2CodedInputStream) throws IOException {
        return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2CodedInputStream);
      }
      
      public static LoggedLowLevelPrivacyInfo parseFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2CodedInputStream, param2ExtensionRegistryLite);
      }
      
      public static LoggedLowLevelPrivacyInfo parseFrom(InputStream param2InputStream) throws IOException {
        return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2InputStream);
      }
      
      public static LoggedLowLevelPrivacyInfo parseFrom(InputStream param2InputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2InputStream, param2ExtensionRegistryLite);
      }
      
      public static LoggedLowLevelPrivacyInfo parseFrom(byte[] param2ArrayOfbyte) throws InvalidProtocolBufferException {
        return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ArrayOfbyte);
      }
      
      public static LoggedLowLevelPrivacyInfo parseFrom(byte[] param2ArrayOfbyte, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ArrayOfbyte, param2ExtensionRegistryLite);
      }
      
      public static Parser<LoggedLowLevelPrivacyInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
      }
      
      private void setUserControls(long param2Long) {
        this.bitField0_ |= 0x1;
        this.userControls_ = param2Long;
      }
      
      protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param2MethodToInvoke, Object param2Object1, Object param2Object2) {
        // Byte code:
        //   0: getstatic analytics_collection/GmpMeasurement$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
        //   3: aload_1
        //   4: invokevirtual ordinal : ()I
        //   7: iaload
        //   8: tableswitch default -> 56, 1 -> 316, 2 -> 312, 3 -> 310, 4 -> 301, 5 -> 243, 6 -> 110, 7 -> 239, 8 -> 64
        //   56: new java/lang/UnsupportedOperationException
        //   59: dup
        //   60: invokespecial <init> : ()V
        //   63: athrow
        //   64: getstatic analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo.PARSER : Lcom/google/protobuf/Parser;
        //   67: ifnonnull -> 106
        //   70: ldc analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo
        //   72: monitorenter
        //   73: getstatic analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo.PARSER : Lcom/google/protobuf/Parser;
        //   76: ifnonnull -> 94
        //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
        //   82: astore_1
        //   83: aload_1
        //   84: getstatic analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo;
        //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
        //   90: aload_1
        //   91: putstatic analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo.PARSER : Lcom/google/protobuf/Parser;
        //   94: ldc analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo
        //   96: monitorexit
        //   97: goto -> 106
        //   100: astore_1
        //   101: ldc analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo
        //   103: monitorexit
        //   104: aload_1
        //   105: athrow
        //   106: getstatic analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo.PARSER : Lcom/google/protobuf/Parser;
        //   109: areturn
        //   110: aload_2
        //   111: checkcast com/google/protobuf/CodedInputStream
        //   114: astore_1
        //   115: aload_3
        //   116: checkcast com/google/protobuf/ExtensionRegistryLite
        //   119: astore_2
        //   120: iconst_0
        //   121: istore #4
        //   123: iload #4
        //   125: ifne -> 239
        //   128: aload_1
        //   129: invokevirtual readTag : ()I
        //   132: istore #5
        //   134: iload #5
        //   136: ifeq -> 183
        //   139: iload #5
        //   141: bipush #8
        //   143: if_icmpeq -> 162
        //   146: aload_0
        //   147: iload #5
        //   149: aload_1
        //   150: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
        //   153: ifne -> 123
        //   156: iconst_1
        //   157: istore #4
        //   159: goto -> 123
        //   162: aload_0
        //   163: aload_0
        //   164: getfield bitField0_ : I
        //   167: iconst_1
        //   168: ior
        //   169: putfield bitField0_ : I
        //   172: aload_0
        //   173: aload_1
        //   174: invokevirtual readUInt64 : ()J
        //   177: putfield userControls_ : J
        //   180: goto -> 123
        //   183: iconst_1
        //   184: istore #4
        //   186: goto -> 123
        //   189: astore_1
        //   190: goto -> 237
        //   193: astore_3
        //   194: new java/lang/RuntimeException
        //   197: astore_2
        //   198: new com/google/protobuf/InvalidProtocolBufferException
        //   201: astore_1
        //   202: aload_1
        //   203: aload_3
        //   204: invokevirtual getMessage : ()Ljava/lang/String;
        //   207: invokespecial <init> : (Ljava/lang/String;)V
        //   210: aload_2
        //   211: aload_1
        //   212: aload_0
        //   213: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
        //   216: invokespecial <init> : (Ljava/lang/Throwable;)V
        //   219: aload_2
        //   220: athrow
        //   221: astore_1
        //   222: new java/lang/RuntimeException
        //   225: astore_2
        //   226: aload_2
        //   227: aload_1
        //   228: aload_0
        //   229: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
        //   232: invokespecial <init> : (Ljava/lang/Throwable;)V
        //   235: aload_2
        //   236: athrow
        //   237: aload_1
        //   238: athrow
        //   239: getstatic analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo;
        //   242: areturn
        //   243: aload_2
        //   244: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
        //   247: astore_1
        //   248: aload_3
        //   249: checkcast analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo
        //   252: astore_2
        //   253: aload_0
        //   254: aload_1
        //   255: aload_0
        //   256: invokevirtual hasUserControls : ()Z
        //   259: aload_0
        //   260: getfield userControls_ : J
        //   263: aload_2
        //   264: invokevirtual hasUserControls : ()Z
        //   267: aload_2
        //   268: getfield userControls_ : J
        //   271: invokeinterface visitLong : (ZJZJ)J
        //   276: putfield userControls_ : J
        //   279: aload_1
        //   280: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
        //   283: if_acmpne -> 299
        //   286: aload_0
        //   287: aload_0
        //   288: getfield bitField0_ : I
        //   291: aload_2
        //   292: getfield bitField0_ : I
        //   295: ior
        //   296: putfield bitField0_ : I
        //   299: aload_0
        //   300: areturn
        //   301: new analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo$Builder
        //   304: dup
        //   305: aconst_null
        //   306: invokespecial <init> : (Lanalytics_collection/GmpMeasurement$1;)V
        //   309: areturn
        //   310: aconst_null
        //   311: areturn
        //   312: getstatic analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo;
        //   315: areturn
        //   316: new analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo
        //   319: dup
        //   320: invokespecial <init> : ()V
        //   323: areturn
        // Exception table:
        //   from	to	target	type
        //   73	94	100	finally
        //   94	97	100	finally
        //   101	104	100	finally
        //   128	134	221	com/google/protobuf/InvalidProtocolBufferException
        //   128	134	193	java/io/IOException
        //   128	134	189	finally
        //   146	156	221	com/google/protobuf/InvalidProtocolBufferException
        //   146	156	193	java/io/IOException
        //   146	156	189	finally
        //   162	180	221	com/google/protobuf/InvalidProtocolBufferException
        //   162	180	193	java/io/IOException
        //   162	180	189	finally
        //   194	221	189	finally
        //   222	237	189	finally
      }
      
      public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1)
          return i; 
        i = 0;
        if ((this.bitField0_ & 0x1) == 1)
          i = 0 + CodedOutputStream.computeUInt64Size(1, this.userControls_); 
        i += this.unknownFields.getSerializedSize();
        this.memoizedSerializedSize = i;
        return i;
      }
      
      public long getUserControls() {
        return this.userControls_;
      }
      
      public boolean hasUserControls() {
        int i = this.bitField0_;
        boolean bool = true;
        if ((i & 0x1) != 1)
          bool = false; 
        return bool;
      }
      
      public void writeTo(CodedOutputStream param2CodedOutputStream) throws IOException {
        if ((this.bitField0_ & 0x1) == 1)
          param2CodedOutputStream.writeUInt64(1, this.userControls_); 
        this.unknownFields.writeTo(param2CodedOutputStream);
      }
      
      public static final class Builder extends GeneratedMessageLite.Builder<LoggedLowLevelPrivacyInfo, Builder> implements GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfoOrBuilder {
        private Builder() {
          super(GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo.DEFAULT_INSTANCE);
        }
        
        public Builder clearUserControls() {
          copyOnWrite();
          ((GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo)this.instance).clearUserControls();
          return this;
        }
        
        public long getUserControls() {
          return ((GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo)this.instance).getUserControls();
        }
        
        public boolean hasUserControls() {
          return ((GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo)this.instance).hasUserControls();
        }
        
        public Builder setUserControls(long param3Long) {
          copyOnWrite();
          ((GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo)this.instance).setUserControls(param3Long);
          return this;
        }
      }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<LoggedLowLevelPrivacyInfo, LoggedLowLevelPrivacyInfo.Builder> implements LoggedLowLevelPrivacyInfoOrBuilder {
      private Builder() {
        super(GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo.DEFAULT_INSTANCE);
      }
      
      public Builder clearUserControls() {
        copyOnWrite();
        ((GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo)this.instance).clearUserControls();
        return this;
      }
      
      public long getUserControls() {
        return ((GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo)this.instance).getUserControls();
      }
      
      public boolean hasUserControls() {
        return ((GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo)this.instance).hasUserControls();
      }
      
      public Builder setUserControls(long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo)this.instance).setUserControls(param2Long);
        return this;
      }
    }
    
    public static interface LoggedLowLevelPrivacyInfoOrBuilder extends MessageLiteOrBuilder {
      long getUserControls();
      
      boolean hasUserControls();
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<PseudonymousPrivacyInfo, PseudonymousPrivacyInfo.Builder> implements PseudonymousPrivacyInfoOrBuilder {
    private Builder() {
      super(GmpMeasurement.PseudonymousPrivacyInfo.DEFAULT_INSTANCE);
    }
    
    public Builder clearLowLevelInfo() {
      copyOnWrite();
      ((GmpMeasurement.PseudonymousPrivacyInfo)this.instance).clearLowLevelInfo();
      return this;
    }
    
    public Builder clearPrivacyModifiers() {
      copyOnWrite();
      ((GmpMeasurement.PseudonymousPrivacyInfo)this.instance).clearPrivacyModifiers();
      return this;
    }
    
    public GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo getLowLevelInfo() {
      return ((GmpMeasurement.PseudonymousPrivacyInfo)this.instance).getLowLevelInfo();
    }
    
    public long getPrivacyModifiers() {
      return ((GmpMeasurement.PseudonymousPrivacyInfo)this.instance).getPrivacyModifiers();
    }
    
    public boolean hasLowLevelInfo() {
      return ((GmpMeasurement.PseudonymousPrivacyInfo)this.instance).hasLowLevelInfo();
    }
    
    public boolean hasPrivacyModifiers() {
      return ((GmpMeasurement.PseudonymousPrivacyInfo)this.instance).hasPrivacyModifiers();
    }
    
    public Builder mergeLowLevelInfo(GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo param1LoggedLowLevelPrivacyInfo) {
      copyOnWrite();
      ((GmpMeasurement.PseudonymousPrivacyInfo)this.instance).mergeLowLevelInfo(param1LoggedLowLevelPrivacyInfo);
      return this;
    }
    
    public Builder setLowLevelInfo(GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.PseudonymousPrivacyInfo)this.instance).setLowLevelInfo(param1Builder);
      return this;
    }
    
    public Builder setLowLevelInfo(GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo param1LoggedLowLevelPrivacyInfo) {
      copyOnWrite();
      ((GmpMeasurement.PseudonymousPrivacyInfo)this.instance).setLowLevelInfo(param1LoggedLowLevelPrivacyInfo);
      return this;
    }
    
    public Builder setPrivacyModifiers(long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.PseudonymousPrivacyInfo)this.instance).setPrivacyModifiers(param1Long);
      return this;
    }
  }
  
  public static final class LoggedLowLevelPrivacyInfo extends GeneratedMessageLite<PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo, PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo.Builder> implements PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfoOrBuilder {
    private static final LoggedLowLevelPrivacyInfo DEFAULT_INSTANCE = new LoggedLowLevelPrivacyInfo();
    
    private static volatile Parser<LoggedLowLevelPrivacyInfo> PARSER;
    
    public static final int USER_CONTROLS_FIELD_NUMBER = 1;
    
    private int bitField0_;
    
    private long userControls_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearUserControls() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.userControls_ = 0L;
    }
    
    public static LoggedLowLevelPrivacyInfo getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(LoggedLowLevelPrivacyInfo param1LoggedLowLevelPrivacyInfo) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1LoggedLowLevelPrivacyInfo);
    }
    
    public static LoggedLowLevelPrivacyInfo parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (LoggedLowLevelPrivacyInfo)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static LoggedLowLevelPrivacyInfo parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LoggedLowLevelPrivacyInfo)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LoggedLowLevelPrivacyInfo parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static LoggedLowLevelPrivacyInfo parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static LoggedLowLevelPrivacyInfo parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static LoggedLowLevelPrivacyInfo parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static LoggedLowLevelPrivacyInfo parseFrom(InputStream param1InputStream) throws IOException {
      return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static LoggedLowLevelPrivacyInfo parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LoggedLowLevelPrivacyInfo parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static LoggedLowLevelPrivacyInfo parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LoggedLowLevelPrivacyInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<LoggedLowLevelPrivacyInfo> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setUserControls(long param1Long) {
      this.bitField0_ |= 0x1;
      this.userControls_ = param1Long;
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic analytics_collection/GmpMeasurement$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 316, 2 -> 312, 3 -> 310, 4 -> 301, 5 -> 243, 6 -> 110, 7 -> 239, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo
      //   72: monitorenter
      //   73: getstatic analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo.PARSER : Lcom/google/protobuf/Parser;
      //   109: areturn
      //   110: aload_2
      //   111: checkcast com/google/protobuf/CodedInputStream
      //   114: astore_1
      //   115: aload_3
      //   116: checkcast com/google/protobuf/ExtensionRegistryLite
      //   119: astore_2
      //   120: iconst_0
      //   121: istore #4
      //   123: iload #4
      //   125: ifne -> 239
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 183
      //   139: iload #5
      //   141: bipush #8
      //   143: if_icmpeq -> 162
      //   146: aload_0
      //   147: iload #5
      //   149: aload_1
      //   150: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   153: ifne -> 123
      //   156: iconst_1
      //   157: istore #4
      //   159: goto -> 123
      //   162: aload_0
      //   163: aload_0
      //   164: getfield bitField0_ : I
      //   167: iconst_1
      //   168: ior
      //   169: putfield bitField0_ : I
      //   172: aload_0
      //   173: aload_1
      //   174: invokevirtual readUInt64 : ()J
      //   177: putfield userControls_ : J
      //   180: goto -> 123
      //   183: iconst_1
      //   184: istore #4
      //   186: goto -> 123
      //   189: astore_1
      //   190: goto -> 237
      //   193: astore_3
      //   194: new java/lang/RuntimeException
      //   197: astore_2
      //   198: new com/google/protobuf/InvalidProtocolBufferException
      //   201: astore_1
      //   202: aload_1
      //   203: aload_3
      //   204: invokevirtual getMessage : ()Ljava/lang/String;
      //   207: invokespecial <init> : (Ljava/lang/String;)V
      //   210: aload_2
      //   211: aload_1
      //   212: aload_0
      //   213: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   216: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   219: aload_2
      //   220: athrow
      //   221: astore_1
      //   222: new java/lang/RuntimeException
      //   225: astore_2
      //   226: aload_2
      //   227: aload_1
      //   228: aload_0
      //   229: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   232: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   235: aload_2
      //   236: athrow
      //   237: aload_1
      //   238: athrow
      //   239: getstatic analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo;
      //   242: areturn
      //   243: aload_2
      //   244: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   247: astore_1
      //   248: aload_3
      //   249: checkcast analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo
      //   252: astore_2
      //   253: aload_0
      //   254: aload_1
      //   255: aload_0
      //   256: invokevirtual hasUserControls : ()Z
      //   259: aload_0
      //   260: getfield userControls_ : J
      //   263: aload_2
      //   264: invokevirtual hasUserControls : ()Z
      //   267: aload_2
      //   268: getfield userControls_ : J
      //   271: invokeinterface visitLong : (ZJZJ)J
      //   276: putfield userControls_ : J
      //   279: aload_1
      //   280: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   283: if_acmpne -> 299
      //   286: aload_0
      //   287: aload_0
      //   288: getfield bitField0_ : I
      //   291: aload_2
      //   292: getfield bitField0_ : I
      //   295: ior
      //   296: putfield bitField0_ : I
      //   299: aload_0
      //   300: areturn
      //   301: new analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo$Builder
      //   304: dup
      //   305: aconst_null
      //   306: invokespecial <init> : (Lanalytics_collection/GmpMeasurement$1;)V
      //   309: areturn
      //   310: aconst_null
      //   311: areturn
      //   312: getstatic analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo;
      //   315: areturn
      //   316: new analytics_collection/GmpMeasurement$PseudonymousPrivacyInfo$LoggedLowLevelPrivacyInfo
      //   319: dup
      //   320: invokespecial <init> : ()V
      //   323: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	221	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	193	java/io/IOException
      //   128	134	189	finally
      //   146	156	221	com/google/protobuf/InvalidProtocolBufferException
      //   146	156	193	java/io/IOException
      //   146	156	189	finally
      //   162	180	221	com/google/protobuf/InvalidProtocolBufferException
      //   162	180	193	java/io/IOException
      //   162	180	189	finally
      //   194	221	189	finally
      //   222	237	189	finally
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if ((this.bitField0_ & 0x1) == 1)
        i = 0 + CodedOutputStream.computeUInt64Size(1, this.userControls_); 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public long getUserControls() {
      return this.userControls_;
    }
    
    public boolean hasUserControls() {
      int i = this.bitField0_;
      boolean bool = true;
      if ((i & 0x1) != 1)
        bool = false; 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if ((this.bitField0_ & 0x1) == 1)
        param1CodedOutputStream.writeUInt64(1, this.userControls_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<LoggedLowLevelPrivacyInfo, Builder> implements GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfoOrBuilder {
      private Builder() {
        super(GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo.DEFAULT_INSTANCE);
      }
      
      public Builder clearUserControls() {
        copyOnWrite();
        ((GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo)this.instance).clearUserControls();
        return this;
      }
      
      public long getUserControls() {
        return ((GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo)this.instance).getUserControls();
      }
      
      public boolean hasUserControls() {
        return ((GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo)this.instance).hasUserControls();
      }
      
      public Builder setUserControls(long param3Long) {
        copyOnWrite();
        ((GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo)this.instance).setUserControls(param3Long);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo, PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo.Builder> implements PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfoOrBuilder {
    private Builder() {
      super(GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo.DEFAULT_INSTANCE);
    }
    
    public Builder clearUserControls() {
      copyOnWrite();
      ((GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo)this.instance).clearUserControls();
      return this;
    }
    
    public long getUserControls() {
      return ((GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo)this.instance).getUserControls();
    }
    
    public boolean hasUserControls() {
      return ((GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo)this.instance).hasUserControls();
    }
    
    public Builder setUserControls(long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo)this.instance).setUserControls(param1Long);
      return this;
    }
  }
  
  public static interface LoggedLowLevelPrivacyInfoOrBuilder extends MessageLiteOrBuilder {
    long getUserControls();
    
    boolean hasUserControls();
  }
  
  public static interface PseudonymousPrivacyInfoOrBuilder extends MessageLiteOrBuilder {
    GmpMeasurement.PseudonymousPrivacyInfo.LoggedLowLevelPrivacyInfo getLowLevelInfo();
    
    long getPrivacyModifiers();
    
    boolean hasLowLevelInfo();
    
    boolean hasPrivacyModifiers();
  }
  
  public static final class ResultData extends GeneratedMessageLite<ResultData, ResultData.Builder> implements ResultDataOrBuilder {
    private static final ResultData DEFAULT_INSTANCE = new ResultData();
    
    public static final int DYNAMIC_FILTER_TIMESTAMPS_FIELD_NUMBER = 3;
    
    private static volatile Parser<ResultData> PARSER;
    
    public static final int RESULTS_FIELD_NUMBER = 2;
    
    public static final int SEQUENCE_FILTER_TIMESTAMPS_FIELD_NUMBER = 4;
    
    public static final int STATUS_FIELD_NUMBER = 1;
    
    private Internal.ProtobufList<GmpMeasurement.DynamicFilterResultTimestamp> dynamicFilterTimestamps_ = emptyProtobufList();
    
    private Internal.LongList results_ = emptyLongList();
    
    private Internal.ProtobufList<GmpMeasurement.SequenceFilterResultTimestamp> sequenceFilterTimestamps_ = emptyProtobufList();
    
    private Internal.LongList status_ = emptyLongList();
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllDynamicFilterTimestamps(Iterable<? extends GmpMeasurement.DynamicFilterResultTimestamp> param1Iterable) {
      ensureDynamicFilterTimestampsIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.dynamicFilterTimestamps_);
    }
    
    private void addAllResults(Iterable<? extends Long> param1Iterable) {
      ensureResultsIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.results_);
    }
    
    private void addAllSequenceFilterTimestamps(Iterable<? extends GmpMeasurement.SequenceFilterResultTimestamp> param1Iterable) {
      ensureSequenceFilterTimestampsIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.sequenceFilterTimestamps_);
    }
    
    private void addAllStatus(Iterable<? extends Long> param1Iterable) {
      ensureStatusIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.status_);
    }
    
    private void addDynamicFilterTimestamps(int param1Int, GmpMeasurement.DynamicFilterResultTimestamp.Builder param1Builder) {
      ensureDynamicFilterTimestampsIsMutable();
      this.dynamicFilterTimestamps_.add(param1Int, param1Builder.build());
    }
    
    private void addDynamicFilterTimestamps(int param1Int, GmpMeasurement.DynamicFilterResultTimestamp param1DynamicFilterResultTimestamp) {
      if (param1DynamicFilterResultTimestamp != null) {
        ensureDynamicFilterTimestampsIsMutable();
        this.dynamicFilterTimestamps_.add(param1Int, param1DynamicFilterResultTimestamp);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addDynamicFilterTimestamps(GmpMeasurement.DynamicFilterResultTimestamp.Builder param1Builder) {
      ensureDynamicFilterTimestampsIsMutable();
      this.dynamicFilterTimestamps_.add(param1Builder.build());
    }
    
    private void addDynamicFilterTimestamps(GmpMeasurement.DynamicFilterResultTimestamp param1DynamicFilterResultTimestamp) {
      if (param1DynamicFilterResultTimestamp != null) {
        ensureDynamicFilterTimestampsIsMutable();
        this.dynamicFilterTimestamps_.add(param1DynamicFilterResultTimestamp);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addResults(long param1Long) {
      ensureResultsIsMutable();
      this.results_.addLong(param1Long);
    }
    
    private void addSequenceFilterTimestamps(int param1Int, GmpMeasurement.SequenceFilterResultTimestamp.Builder param1Builder) {
      ensureSequenceFilterTimestampsIsMutable();
      this.sequenceFilterTimestamps_.add(param1Int, param1Builder.build());
    }
    
    private void addSequenceFilterTimestamps(int param1Int, GmpMeasurement.SequenceFilterResultTimestamp param1SequenceFilterResultTimestamp) {
      if (param1SequenceFilterResultTimestamp != null) {
        ensureSequenceFilterTimestampsIsMutable();
        this.sequenceFilterTimestamps_.add(param1Int, param1SequenceFilterResultTimestamp);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addSequenceFilterTimestamps(GmpMeasurement.SequenceFilterResultTimestamp.Builder param1Builder) {
      ensureSequenceFilterTimestampsIsMutable();
      this.sequenceFilterTimestamps_.add(param1Builder.build());
    }
    
    private void addSequenceFilterTimestamps(GmpMeasurement.SequenceFilterResultTimestamp param1SequenceFilterResultTimestamp) {
      if (param1SequenceFilterResultTimestamp != null) {
        ensureSequenceFilterTimestampsIsMutable();
        this.sequenceFilterTimestamps_.add(param1SequenceFilterResultTimestamp);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addStatus(long param1Long) {
      ensureStatusIsMutable();
      this.status_.addLong(param1Long);
    }
    
    private void clearDynamicFilterTimestamps() {
      this.dynamicFilterTimestamps_ = emptyProtobufList();
    }
    
    private void clearResults() {
      this.results_ = emptyLongList();
    }
    
    private void clearSequenceFilterTimestamps() {
      this.sequenceFilterTimestamps_ = emptyProtobufList();
    }
    
    private void clearStatus() {
      this.status_ = emptyLongList();
    }
    
    private void ensureDynamicFilterTimestampsIsMutable() {
      if (!this.dynamicFilterTimestamps_.isModifiable())
        this.dynamicFilterTimestamps_ = GeneratedMessageLite.mutableCopy(this.dynamicFilterTimestamps_); 
    }
    
    private void ensureResultsIsMutable() {
      if (!this.results_.isModifiable())
        this.results_ = GeneratedMessageLite.mutableCopy(this.results_); 
    }
    
    private void ensureSequenceFilterTimestampsIsMutable() {
      if (!this.sequenceFilterTimestamps_.isModifiable())
        this.sequenceFilterTimestamps_ = GeneratedMessageLite.mutableCopy(this.sequenceFilterTimestamps_); 
    }
    
    private void ensureStatusIsMutable() {
      if (!this.status_.isModifiable())
        this.status_ = GeneratedMessageLite.mutableCopy(this.status_); 
    }
    
    public static ResultData getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ResultData param1ResultData) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1ResultData);
    }
    
    public static ResultData parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (ResultData)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static ResultData parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ResultData)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ResultData parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (ResultData)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static ResultData parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ResultData)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static ResultData parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (ResultData)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static ResultData parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ResultData)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static ResultData parseFrom(InputStream param1InputStream) throws IOException {
      return (ResultData)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static ResultData parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ResultData)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ResultData parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (ResultData)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static ResultData parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ResultData)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<ResultData> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeDynamicFilterTimestamps(int param1Int) {
      ensureDynamicFilterTimestampsIsMutable();
      this.dynamicFilterTimestamps_.remove(param1Int);
    }
    
    private void removeSequenceFilterTimestamps(int param1Int) {
      ensureSequenceFilterTimestampsIsMutable();
      this.sequenceFilterTimestamps_.remove(param1Int);
    }
    
    private void setDynamicFilterTimestamps(int param1Int, GmpMeasurement.DynamicFilterResultTimestamp.Builder param1Builder) {
      ensureDynamicFilterTimestampsIsMutable();
      this.dynamicFilterTimestamps_.set(param1Int, param1Builder.build());
    }
    
    private void setDynamicFilterTimestamps(int param1Int, GmpMeasurement.DynamicFilterResultTimestamp param1DynamicFilterResultTimestamp) {
      if (param1DynamicFilterResultTimestamp != null) {
        ensureDynamicFilterTimestampsIsMutable();
        this.dynamicFilterTimestamps_.set(param1Int, param1DynamicFilterResultTimestamp);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setResults(int param1Int, long param1Long) {
      ensureResultsIsMutable();
      this.results_.setLong(param1Int, param1Long);
    }
    
    private void setSequenceFilterTimestamps(int param1Int, GmpMeasurement.SequenceFilterResultTimestamp.Builder param1Builder) {
      ensureSequenceFilterTimestampsIsMutable();
      this.sequenceFilterTimestamps_.set(param1Int, param1Builder.build());
    }
    
    private void setSequenceFilterTimestamps(int param1Int, GmpMeasurement.SequenceFilterResultTimestamp param1SequenceFilterResultTimestamp) {
      if (param1SequenceFilterResultTimestamp != null) {
        ensureSequenceFilterTimestampsIsMutable();
        this.sequenceFilterTimestamps_.set(param1Int, param1SequenceFilterResultTimestamp);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setStatus(int param1Int, long param1Long) {
      ensureStatusIsMutable();
      this.status_.setLong(param1Int, param1Long);
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic analytics_collection/GmpMeasurement$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 712, 2 -> 708, 3 -> 670, 4 -> 661, 5 -> 573, 6 -> 110, 7 -> 569, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic analytics_collection/GmpMeasurement$ResultData.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc analytics_collection/GmpMeasurement$ResultData
      //   72: monitorenter
      //   73: getstatic analytics_collection/GmpMeasurement$ResultData.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic analytics_collection/GmpMeasurement$ResultData.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$ResultData;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic analytics_collection/GmpMeasurement$ResultData.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc analytics_collection/GmpMeasurement$ResultData
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc analytics_collection/GmpMeasurement$ResultData
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic analytics_collection/GmpMeasurement$ResultData.PARSER : Lcom/google/protobuf/Parser;
      //   109: areturn
      //   110: aload_2
      //   111: checkcast com/google/protobuf/CodedInputStream
      //   114: astore_1
      //   115: aload_3
      //   116: checkcast com/google/protobuf/ExtensionRegistryLite
      //   119: astore_2
      //   120: iconst_0
      //   121: istore #4
      //   123: iload #4
      //   125: ifne -> 569
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 513
      //   139: iload #5
      //   141: bipush #8
      //   143: if_icmpeq -> 474
      //   146: iload #5
      //   148: bipush #10
      //   150: if_icmpeq -> 402
      //   153: iload #5
      //   155: bipush #16
      //   157: if_icmpeq -> 363
      //   160: iload #5
      //   162: bipush #18
      //   164: if_icmpeq -> 291
      //   167: iload #5
      //   169: bipush #26
      //   171: if_icmpeq -> 244
      //   174: iload #5
      //   176: bipush #34
      //   178: if_icmpeq -> 197
      //   181: aload_0
      //   182: iload #5
      //   184: aload_1
      //   185: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   188: ifne -> 123
      //   191: iconst_1
      //   192: istore #4
      //   194: goto -> 123
      //   197: aload_0
      //   198: getfield sequenceFilterTimestamps_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   201: invokeinterface isModifiable : ()Z
      //   206: ifne -> 220
      //   209: aload_0
      //   210: aload_0
      //   211: getfield sequenceFilterTimestamps_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   214: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   217: putfield sequenceFilterTimestamps_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   220: aload_0
      //   221: getfield sequenceFilterTimestamps_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   224: aload_1
      //   225: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   228: aload_2
      //   229: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   232: checkcast analytics_collection/GmpMeasurement$SequenceFilterResultTimestamp
      //   235: invokeinterface add : (Ljava/lang/Object;)Z
      //   240: pop
      //   241: goto -> 123
      //   244: aload_0
      //   245: getfield dynamicFilterTimestamps_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   248: invokeinterface isModifiable : ()Z
      //   253: ifne -> 267
      //   256: aload_0
      //   257: aload_0
      //   258: getfield dynamicFilterTimestamps_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   261: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   264: putfield dynamicFilterTimestamps_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   267: aload_0
      //   268: getfield dynamicFilterTimestamps_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   271: aload_1
      //   272: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   275: aload_2
      //   276: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   279: checkcast analytics_collection/GmpMeasurement$DynamicFilterResultTimestamp
      //   282: invokeinterface add : (Ljava/lang/Object;)Z
      //   287: pop
      //   288: goto -> 123
      //   291: aload_1
      //   292: aload_1
      //   293: invokevirtual readRawVarint32 : ()I
      //   296: invokevirtual pushLimit : (I)I
      //   299: istore #5
      //   301: aload_0
      //   302: getfield results_ : Lcom/google/protobuf/Internal$LongList;
      //   305: invokeinterface isModifiable : ()Z
      //   310: ifne -> 331
      //   313: aload_1
      //   314: invokevirtual getBytesUntilLimit : ()I
      //   317: ifle -> 331
      //   320: aload_0
      //   321: aload_0
      //   322: getfield results_ : Lcom/google/protobuf/Internal$LongList;
      //   325: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$LongList;)Lcom/google/protobuf/Internal$LongList;
      //   328: putfield results_ : Lcom/google/protobuf/Internal$LongList;
      //   331: aload_1
      //   332: invokevirtual getBytesUntilLimit : ()I
      //   335: ifle -> 354
      //   338: aload_0
      //   339: getfield results_ : Lcom/google/protobuf/Internal$LongList;
      //   342: aload_1
      //   343: invokevirtual readUInt64 : ()J
      //   346: invokeinterface addLong : (J)V
      //   351: goto -> 331
      //   354: aload_1
      //   355: iload #5
      //   357: invokevirtual popLimit : (I)V
      //   360: goto -> 123
      //   363: aload_0
      //   364: getfield results_ : Lcom/google/protobuf/Internal$LongList;
      //   367: invokeinterface isModifiable : ()Z
      //   372: ifne -> 386
      //   375: aload_0
      //   376: aload_0
      //   377: getfield results_ : Lcom/google/protobuf/Internal$LongList;
      //   380: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$LongList;)Lcom/google/protobuf/Internal$LongList;
      //   383: putfield results_ : Lcom/google/protobuf/Internal$LongList;
      //   386: aload_0
      //   387: getfield results_ : Lcom/google/protobuf/Internal$LongList;
      //   390: aload_1
      //   391: invokevirtual readUInt64 : ()J
      //   394: invokeinterface addLong : (J)V
      //   399: goto -> 123
      //   402: aload_1
      //   403: aload_1
      //   404: invokevirtual readRawVarint32 : ()I
      //   407: invokevirtual pushLimit : (I)I
      //   410: istore #5
      //   412: aload_0
      //   413: getfield status_ : Lcom/google/protobuf/Internal$LongList;
      //   416: invokeinterface isModifiable : ()Z
      //   421: ifne -> 442
      //   424: aload_1
      //   425: invokevirtual getBytesUntilLimit : ()I
      //   428: ifle -> 442
      //   431: aload_0
      //   432: aload_0
      //   433: getfield status_ : Lcom/google/protobuf/Internal$LongList;
      //   436: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$LongList;)Lcom/google/protobuf/Internal$LongList;
      //   439: putfield status_ : Lcom/google/protobuf/Internal$LongList;
      //   442: aload_1
      //   443: invokevirtual getBytesUntilLimit : ()I
      //   446: ifle -> 465
      //   449: aload_0
      //   450: getfield status_ : Lcom/google/protobuf/Internal$LongList;
      //   453: aload_1
      //   454: invokevirtual readUInt64 : ()J
      //   457: invokeinterface addLong : (J)V
      //   462: goto -> 442
      //   465: aload_1
      //   466: iload #5
      //   468: invokevirtual popLimit : (I)V
      //   471: goto -> 123
      //   474: aload_0
      //   475: getfield status_ : Lcom/google/protobuf/Internal$LongList;
      //   478: invokeinterface isModifiable : ()Z
      //   483: ifne -> 497
      //   486: aload_0
      //   487: aload_0
      //   488: getfield status_ : Lcom/google/protobuf/Internal$LongList;
      //   491: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$LongList;)Lcom/google/protobuf/Internal$LongList;
      //   494: putfield status_ : Lcom/google/protobuf/Internal$LongList;
      //   497: aload_0
      //   498: getfield status_ : Lcom/google/protobuf/Internal$LongList;
      //   501: aload_1
      //   502: invokevirtual readUInt64 : ()J
      //   505: invokeinterface addLong : (J)V
      //   510: goto -> 123
      //   513: iconst_1
      //   514: istore #4
      //   516: goto -> 123
      //   519: astore_1
      //   520: goto -> 567
      //   523: astore_3
      //   524: new java/lang/RuntimeException
      //   527: astore_1
      //   528: new com/google/protobuf/InvalidProtocolBufferException
      //   531: astore_2
      //   532: aload_2
      //   533: aload_3
      //   534: invokevirtual getMessage : ()Ljava/lang/String;
      //   537: invokespecial <init> : (Ljava/lang/String;)V
      //   540: aload_1
      //   541: aload_2
      //   542: aload_0
      //   543: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   546: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   549: aload_1
      //   550: athrow
      //   551: astore_1
      //   552: new java/lang/RuntimeException
      //   555: astore_2
      //   556: aload_2
      //   557: aload_1
      //   558: aload_0
      //   559: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   562: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   565: aload_2
      //   566: athrow
      //   567: aload_1
      //   568: athrow
      //   569: getstatic analytics_collection/GmpMeasurement$ResultData.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$ResultData;
      //   572: areturn
      //   573: aload_2
      //   574: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   577: astore_1
      //   578: aload_3
      //   579: checkcast analytics_collection/GmpMeasurement$ResultData
      //   582: astore_2
      //   583: aload_0
      //   584: aload_1
      //   585: aload_0
      //   586: getfield status_ : Lcom/google/protobuf/Internal$LongList;
      //   589: aload_2
      //   590: getfield status_ : Lcom/google/protobuf/Internal$LongList;
      //   593: invokeinterface visitLongList : (Lcom/google/protobuf/Internal$LongList;Lcom/google/protobuf/Internal$LongList;)Lcom/google/protobuf/Internal$LongList;
      //   598: putfield status_ : Lcom/google/protobuf/Internal$LongList;
      //   601: aload_0
      //   602: aload_1
      //   603: aload_0
      //   604: getfield results_ : Lcom/google/protobuf/Internal$LongList;
      //   607: aload_2
      //   608: getfield results_ : Lcom/google/protobuf/Internal$LongList;
      //   611: invokeinterface visitLongList : (Lcom/google/protobuf/Internal$LongList;Lcom/google/protobuf/Internal$LongList;)Lcom/google/protobuf/Internal$LongList;
      //   616: putfield results_ : Lcom/google/protobuf/Internal$LongList;
      //   619: aload_0
      //   620: aload_1
      //   621: aload_0
      //   622: getfield dynamicFilterTimestamps_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   625: aload_2
      //   626: getfield dynamicFilterTimestamps_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   629: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   634: putfield dynamicFilterTimestamps_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   637: aload_0
      //   638: aload_1
      //   639: aload_0
      //   640: getfield sequenceFilterTimestamps_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   643: aload_2
      //   644: getfield sequenceFilterTimestamps_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   647: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   652: putfield sequenceFilterTimestamps_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   655: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   658: astore_1
      //   659: aload_0
      //   660: areturn
      //   661: new analytics_collection/GmpMeasurement$ResultData$Builder
      //   664: dup
      //   665: aconst_null
      //   666: invokespecial <init> : (Lanalytics_collection/GmpMeasurement$1;)V
      //   669: areturn
      //   670: aload_0
      //   671: getfield status_ : Lcom/google/protobuf/Internal$LongList;
      //   674: invokeinterface makeImmutable : ()V
      //   679: aload_0
      //   680: getfield results_ : Lcom/google/protobuf/Internal$LongList;
      //   683: invokeinterface makeImmutable : ()V
      //   688: aload_0
      //   689: getfield dynamicFilterTimestamps_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   692: invokeinterface makeImmutable : ()V
      //   697: aload_0
      //   698: getfield sequenceFilterTimestamps_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   701: invokeinterface makeImmutable : ()V
      //   706: aconst_null
      //   707: areturn
      //   708: getstatic analytics_collection/GmpMeasurement$ResultData.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$ResultData;
      //   711: areturn
      //   712: new analytics_collection/GmpMeasurement$ResultData
      //   715: dup
      //   716: invokespecial <init> : ()V
      //   719: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	551	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	523	java/io/IOException
      //   128	134	519	finally
      //   181	191	551	com/google/protobuf/InvalidProtocolBufferException
      //   181	191	523	java/io/IOException
      //   181	191	519	finally
      //   197	220	551	com/google/protobuf/InvalidProtocolBufferException
      //   197	220	523	java/io/IOException
      //   197	220	519	finally
      //   220	241	551	com/google/protobuf/InvalidProtocolBufferException
      //   220	241	523	java/io/IOException
      //   220	241	519	finally
      //   244	267	551	com/google/protobuf/InvalidProtocolBufferException
      //   244	267	523	java/io/IOException
      //   244	267	519	finally
      //   267	288	551	com/google/protobuf/InvalidProtocolBufferException
      //   267	288	523	java/io/IOException
      //   267	288	519	finally
      //   291	331	551	com/google/protobuf/InvalidProtocolBufferException
      //   291	331	523	java/io/IOException
      //   291	331	519	finally
      //   331	351	551	com/google/protobuf/InvalidProtocolBufferException
      //   331	351	523	java/io/IOException
      //   331	351	519	finally
      //   354	360	551	com/google/protobuf/InvalidProtocolBufferException
      //   354	360	523	java/io/IOException
      //   354	360	519	finally
      //   363	386	551	com/google/protobuf/InvalidProtocolBufferException
      //   363	386	523	java/io/IOException
      //   363	386	519	finally
      //   386	399	551	com/google/protobuf/InvalidProtocolBufferException
      //   386	399	523	java/io/IOException
      //   386	399	519	finally
      //   402	442	551	com/google/protobuf/InvalidProtocolBufferException
      //   402	442	523	java/io/IOException
      //   402	442	519	finally
      //   442	462	551	com/google/protobuf/InvalidProtocolBufferException
      //   442	462	523	java/io/IOException
      //   442	462	519	finally
      //   465	471	551	com/google/protobuf/InvalidProtocolBufferException
      //   465	471	523	java/io/IOException
      //   465	471	519	finally
      //   474	497	551	com/google/protobuf/InvalidProtocolBufferException
      //   474	497	523	java/io/IOException
      //   474	497	519	finally
      //   497	510	551	com/google/protobuf/InvalidProtocolBufferException
      //   497	510	523	java/io/IOException
      //   497	510	519	finally
      //   524	551	519	finally
      //   552	567	519	finally
    }
    
    public GmpMeasurement.DynamicFilterResultTimestamp getDynamicFilterTimestamps(int param1Int) {
      return (GmpMeasurement.DynamicFilterResultTimestamp)this.dynamicFilterTimestamps_.get(param1Int);
    }
    
    public int getDynamicFilterTimestampsCount() {
      return this.dynamicFilterTimestamps_.size();
    }
    
    public List<GmpMeasurement.DynamicFilterResultTimestamp> getDynamicFilterTimestampsList() {
      return (List<GmpMeasurement.DynamicFilterResultTimestamp>)this.dynamicFilterTimestamps_;
    }
    
    public GmpMeasurement.DynamicFilterResultTimestampOrBuilder getDynamicFilterTimestampsOrBuilder(int param1Int) {
      return (GmpMeasurement.DynamicFilterResultTimestampOrBuilder)this.dynamicFilterTimestamps_.get(param1Int);
    }
    
    public List<? extends GmpMeasurement.DynamicFilterResultTimestampOrBuilder> getDynamicFilterTimestampsOrBuilderList() {
      return (List)this.dynamicFilterTimestamps_;
    }
    
    public long getResults(int param1Int) {
      return this.results_.getLong(param1Int);
    }
    
    public int getResultsCount() {
      return this.results_.size();
    }
    
    public List<Long> getResultsList() {
      return (List<Long>)this.results_;
    }
    
    public GmpMeasurement.SequenceFilterResultTimestamp getSequenceFilterTimestamps(int param1Int) {
      return (GmpMeasurement.SequenceFilterResultTimestamp)this.sequenceFilterTimestamps_.get(param1Int);
    }
    
    public int getSequenceFilterTimestampsCount() {
      return this.sequenceFilterTimestamps_.size();
    }
    
    public List<GmpMeasurement.SequenceFilterResultTimestamp> getSequenceFilterTimestampsList() {
      return (List<GmpMeasurement.SequenceFilterResultTimestamp>)this.sequenceFilterTimestamps_;
    }
    
    public GmpMeasurement.SequenceFilterResultTimestampOrBuilder getSequenceFilterTimestampsOrBuilder(int param1Int) {
      return (GmpMeasurement.SequenceFilterResultTimestampOrBuilder)this.sequenceFilterTimestamps_.get(param1Int);
    }
    
    public List<? extends GmpMeasurement.SequenceFilterResultTimestampOrBuilder> getSequenceFilterTimestampsOrBuilderList() {
      return (List)this.sequenceFilterTimestamps_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      boolean bool = false;
      byte b = 0;
      i = 0;
      while (b < this.status_.size()) {
        i += CodedOutputStream.computeUInt64SizeNoTag(this.status_.getLong(b));
        b++;
      } 
      int j = getStatusList().size();
      b = 0;
      int k = 0;
      while (b < this.results_.size()) {
        k += CodedOutputStream.computeUInt64SizeNoTag(this.results_.getLong(b));
        b++;
      } 
      i = i + 0 + j * 1 + k + getResultsList().size() * 1;
      b = 0;
      while (true) {
        k = bool;
        j = i;
        if (b < this.dynamicFilterTimestamps_.size()) {
          i += CodedOutputStream.computeMessageSize(3, (MessageLite)this.dynamicFilterTimestamps_.get(b));
          b++;
          continue;
        } 
        break;
      } 
      while (k < this.sequenceFilterTimestamps_.size()) {
        j += CodedOutputStream.computeMessageSize(4, (MessageLite)this.sequenceFilterTimestamps_.get(k));
        k++;
      } 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public long getStatus(int param1Int) {
      return this.status_.getLong(param1Int);
    }
    
    public int getStatusCount() {
      return this.status_.size();
    }
    
    public List<Long> getStatusList() {
      return (List<Long>)this.status_;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      byte b3;
      byte b1 = 0;
      byte b2;
      for (b2 = 0; b2 < this.status_.size(); b2++)
        param1CodedOutputStream.writeUInt64(1, this.status_.getLong(b2)); 
      for (b2 = 0; b2 < this.results_.size(); b2++)
        param1CodedOutputStream.writeUInt64(2, this.results_.getLong(b2)); 
      b2 = 0;
      while (true) {
        b3 = b1;
        if (b2 < this.dynamicFilterTimestamps_.size()) {
          param1CodedOutputStream.writeMessage(3, (MessageLite)this.dynamicFilterTimestamps_.get(b2));
          b2++;
          continue;
        } 
        break;
      } 
      while (b3 < this.sequenceFilterTimestamps_.size()) {
        param1CodedOutputStream.writeMessage(4, (MessageLite)this.sequenceFilterTimestamps_.get(b3));
        b3++;
      } 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<ResultData, Builder> implements GmpMeasurement.ResultDataOrBuilder {
      private Builder() {
        super(GmpMeasurement.ResultData.DEFAULT_INSTANCE);
      }
      
      public Builder addAllDynamicFilterTimestamps(Iterable<? extends GmpMeasurement.DynamicFilterResultTimestamp> param2Iterable) {
        copyOnWrite();
        ((GmpMeasurement.ResultData)this.instance).addAllDynamicFilterTimestamps(param2Iterable);
        return this;
      }
      
      public Builder addAllResults(Iterable<? extends Long> param2Iterable) {
        copyOnWrite();
        ((GmpMeasurement.ResultData)this.instance).addAllResults(param2Iterable);
        return this;
      }
      
      public Builder addAllSequenceFilterTimestamps(Iterable<? extends GmpMeasurement.SequenceFilterResultTimestamp> param2Iterable) {
        copyOnWrite();
        ((GmpMeasurement.ResultData)this.instance).addAllSequenceFilterTimestamps(param2Iterable);
        return this;
      }
      
      public Builder addAllStatus(Iterable<? extends Long> param2Iterable) {
        copyOnWrite();
        ((GmpMeasurement.ResultData)this.instance).addAllStatus(param2Iterable);
        return this;
      }
      
      public Builder addDynamicFilterTimestamps(int param2Int, GmpMeasurement.DynamicFilterResultTimestamp.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.ResultData)this.instance).addDynamicFilterTimestamps(param2Int, param2Builder);
        return this;
      }
      
      public Builder addDynamicFilterTimestamps(int param2Int, GmpMeasurement.DynamicFilterResultTimestamp param2DynamicFilterResultTimestamp) {
        copyOnWrite();
        ((GmpMeasurement.ResultData)this.instance).addDynamicFilterTimestamps(param2Int, param2DynamicFilterResultTimestamp);
        return this;
      }
      
      public Builder addDynamicFilterTimestamps(GmpMeasurement.DynamicFilterResultTimestamp.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.ResultData)this.instance).addDynamicFilterTimestamps(param2Builder);
        return this;
      }
      
      public Builder addDynamicFilterTimestamps(GmpMeasurement.DynamicFilterResultTimestamp param2DynamicFilterResultTimestamp) {
        copyOnWrite();
        ((GmpMeasurement.ResultData)this.instance).addDynamicFilterTimestamps(param2DynamicFilterResultTimestamp);
        return this;
      }
      
      public Builder addResults(long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.ResultData)this.instance).addResults(param2Long);
        return this;
      }
      
      public Builder addSequenceFilterTimestamps(int param2Int, GmpMeasurement.SequenceFilterResultTimestamp.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.ResultData)this.instance).addSequenceFilterTimestamps(param2Int, param2Builder);
        return this;
      }
      
      public Builder addSequenceFilterTimestamps(int param2Int, GmpMeasurement.SequenceFilterResultTimestamp param2SequenceFilterResultTimestamp) {
        copyOnWrite();
        ((GmpMeasurement.ResultData)this.instance).addSequenceFilterTimestamps(param2Int, param2SequenceFilterResultTimestamp);
        return this;
      }
      
      public Builder addSequenceFilterTimestamps(GmpMeasurement.SequenceFilterResultTimestamp.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.ResultData)this.instance).addSequenceFilterTimestamps(param2Builder);
        return this;
      }
      
      public Builder addSequenceFilterTimestamps(GmpMeasurement.SequenceFilterResultTimestamp param2SequenceFilterResultTimestamp) {
        copyOnWrite();
        ((GmpMeasurement.ResultData)this.instance).addSequenceFilterTimestamps(param2SequenceFilterResultTimestamp);
        return this;
      }
      
      public Builder addStatus(long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.ResultData)this.instance).addStatus(param2Long);
        return this;
      }
      
      public Builder clearDynamicFilterTimestamps() {
        copyOnWrite();
        ((GmpMeasurement.ResultData)this.instance).clearDynamicFilterTimestamps();
        return this;
      }
      
      public Builder clearResults() {
        copyOnWrite();
        ((GmpMeasurement.ResultData)this.instance).clearResults();
        return this;
      }
      
      public Builder clearSequenceFilterTimestamps() {
        copyOnWrite();
        ((GmpMeasurement.ResultData)this.instance).clearSequenceFilterTimestamps();
        return this;
      }
      
      public Builder clearStatus() {
        copyOnWrite();
        ((GmpMeasurement.ResultData)this.instance).clearStatus();
        return this;
      }
      
      public GmpMeasurement.DynamicFilterResultTimestamp getDynamicFilterTimestamps(int param2Int) {
        return ((GmpMeasurement.ResultData)this.instance).getDynamicFilterTimestamps(param2Int);
      }
      
      public int getDynamicFilterTimestampsCount() {
        return ((GmpMeasurement.ResultData)this.instance).getDynamicFilterTimestampsCount();
      }
      
      public List<GmpMeasurement.DynamicFilterResultTimestamp> getDynamicFilterTimestampsList() {
        return Collections.unmodifiableList(((GmpMeasurement.ResultData)this.instance).getDynamicFilterTimestampsList());
      }
      
      public long getResults(int param2Int) {
        return ((GmpMeasurement.ResultData)this.instance).getResults(param2Int);
      }
      
      public int getResultsCount() {
        return ((GmpMeasurement.ResultData)this.instance).getResultsCount();
      }
      
      public List<Long> getResultsList() {
        return Collections.unmodifiableList(((GmpMeasurement.ResultData)this.instance).getResultsList());
      }
      
      public GmpMeasurement.SequenceFilterResultTimestamp getSequenceFilterTimestamps(int param2Int) {
        return ((GmpMeasurement.ResultData)this.instance).getSequenceFilterTimestamps(param2Int);
      }
      
      public int getSequenceFilterTimestampsCount() {
        return ((GmpMeasurement.ResultData)this.instance).getSequenceFilterTimestampsCount();
      }
      
      public List<GmpMeasurement.SequenceFilterResultTimestamp> getSequenceFilterTimestampsList() {
        return Collections.unmodifiableList(((GmpMeasurement.ResultData)this.instance).getSequenceFilterTimestampsList());
      }
      
      public long getStatus(int param2Int) {
        return ((GmpMeasurement.ResultData)this.instance).getStatus(param2Int);
      }
      
      public int getStatusCount() {
        return ((GmpMeasurement.ResultData)this.instance).getStatusCount();
      }
      
      public List<Long> getStatusList() {
        return Collections.unmodifiableList(((GmpMeasurement.ResultData)this.instance).getStatusList());
      }
      
      public Builder removeDynamicFilterTimestamps(int param2Int) {
        copyOnWrite();
        ((GmpMeasurement.ResultData)this.instance).removeDynamicFilterTimestamps(param2Int);
        return this;
      }
      
      public Builder removeSequenceFilterTimestamps(int param2Int) {
        copyOnWrite();
        ((GmpMeasurement.ResultData)this.instance).removeSequenceFilterTimestamps(param2Int);
        return this;
      }
      
      public Builder setDynamicFilterTimestamps(int param2Int, GmpMeasurement.DynamicFilterResultTimestamp.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.ResultData)this.instance).setDynamicFilterTimestamps(param2Int, param2Builder);
        return this;
      }
      
      public Builder setDynamicFilterTimestamps(int param2Int, GmpMeasurement.DynamicFilterResultTimestamp param2DynamicFilterResultTimestamp) {
        copyOnWrite();
        ((GmpMeasurement.ResultData)this.instance).setDynamicFilterTimestamps(param2Int, param2DynamicFilterResultTimestamp);
        return this;
      }
      
      public Builder setResults(int param2Int, long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.ResultData)this.instance).setResults(param2Int, param2Long);
        return this;
      }
      
      public Builder setSequenceFilterTimestamps(int param2Int, GmpMeasurement.SequenceFilterResultTimestamp.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurement.ResultData)this.instance).setSequenceFilterTimestamps(param2Int, param2Builder);
        return this;
      }
      
      public Builder setSequenceFilterTimestamps(int param2Int, GmpMeasurement.SequenceFilterResultTimestamp param2SequenceFilterResultTimestamp) {
        copyOnWrite();
        ((GmpMeasurement.ResultData)this.instance).setSequenceFilterTimestamps(param2Int, param2SequenceFilterResultTimestamp);
        return this;
      }
      
      public Builder setStatus(int param2Int, long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.ResultData)this.instance).setStatus(param2Int, param2Long);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ResultData, ResultData.Builder> implements ResultDataOrBuilder {
    private Builder() {
      super(GmpMeasurement.ResultData.DEFAULT_INSTANCE);
    }
    
    public Builder addAllDynamicFilterTimestamps(Iterable<? extends GmpMeasurement.DynamicFilterResultTimestamp> param1Iterable) {
      copyOnWrite();
      ((GmpMeasurement.ResultData)this.instance).addAllDynamicFilterTimestamps(param1Iterable);
      return this;
    }
    
    public Builder addAllResults(Iterable<? extends Long> param1Iterable) {
      copyOnWrite();
      ((GmpMeasurement.ResultData)this.instance).addAllResults(param1Iterable);
      return this;
    }
    
    public Builder addAllSequenceFilterTimestamps(Iterable<? extends GmpMeasurement.SequenceFilterResultTimestamp> param1Iterable) {
      copyOnWrite();
      ((GmpMeasurement.ResultData)this.instance).addAllSequenceFilterTimestamps(param1Iterable);
      return this;
    }
    
    public Builder addAllStatus(Iterable<? extends Long> param1Iterable) {
      copyOnWrite();
      ((GmpMeasurement.ResultData)this.instance).addAllStatus(param1Iterable);
      return this;
    }
    
    public Builder addDynamicFilterTimestamps(int param1Int, GmpMeasurement.DynamicFilterResultTimestamp.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.ResultData)this.instance).addDynamicFilterTimestamps(param1Int, param1Builder);
      return this;
    }
    
    public Builder addDynamicFilterTimestamps(int param1Int, GmpMeasurement.DynamicFilterResultTimestamp param1DynamicFilterResultTimestamp) {
      copyOnWrite();
      ((GmpMeasurement.ResultData)this.instance).addDynamicFilterTimestamps(param1Int, param1DynamicFilterResultTimestamp);
      return this;
    }
    
    public Builder addDynamicFilterTimestamps(GmpMeasurement.DynamicFilterResultTimestamp.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.ResultData)this.instance).addDynamicFilterTimestamps(param1Builder);
      return this;
    }
    
    public Builder addDynamicFilterTimestamps(GmpMeasurement.DynamicFilterResultTimestamp param1DynamicFilterResultTimestamp) {
      copyOnWrite();
      ((GmpMeasurement.ResultData)this.instance).addDynamicFilterTimestamps(param1DynamicFilterResultTimestamp);
      return this;
    }
    
    public Builder addResults(long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.ResultData)this.instance).addResults(param1Long);
      return this;
    }
    
    public Builder addSequenceFilterTimestamps(int param1Int, GmpMeasurement.SequenceFilterResultTimestamp.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.ResultData)this.instance).addSequenceFilterTimestamps(param1Int, param1Builder);
      return this;
    }
    
    public Builder addSequenceFilterTimestamps(int param1Int, GmpMeasurement.SequenceFilterResultTimestamp param1SequenceFilterResultTimestamp) {
      copyOnWrite();
      ((GmpMeasurement.ResultData)this.instance).addSequenceFilterTimestamps(param1Int, param1SequenceFilterResultTimestamp);
      return this;
    }
    
    public Builder addSequenceFilterTimestamps(GmpMeasurement.SequenceFilterResultTimestamp.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.ResultData)this.instance).addSequenceFilterTimestamps(param1Builder);
      return this;
    }
    
    public Builder addSequenceFilterTimestamps(GmpMeasurement.SequenceFilterResultTimestamp param1SequenceFilterResultTimestamp) {
      copyOnWrite();
      ((GmpMeasurement.ResultData)this.instance).addSequenceFilterTimestamps(param1SequenceFilterResultTimestamp);
      return this;
    }
    
    public Builder addStatus(long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.ResultData)this.instance).addStatus(param1Long);
      return this;
    }
    
    public Builder clearDynamicFilterTimestamps() {
      copyOnWrite();
      ((GmpMeasurement.ResultData)this.instance).clearDynamicFilterTimestamps();
      return this;
    }
    
    public Builder clearResults() {
      copyOnWrite();
      ((GmpMeasurement.ResultData)this.instance).clearResults();
      return this;
    }
    
    public Builder clearSequenceFilterTimestamps() {
      copyOnWrite();
      ((GmpMeasurement.ResultData)this.instance).clearSequenceFilterTimestamps();
      return this;
    }
    
    public Builder clearStatus() {
      copyOnWrite();
      ((GmpMeasurement.ResultData)this.instance).clearStatus();
      return this;
    }
    
    public GmpMeasurement.DynamicFilterResultTimestamp getDynamicFilterTimestamps(int param1Int) {
      return ((GmpMeasurement.ResultData)this.instance).getDynamicFilterTimestamps(param1Int);
    }
    
    public int getDynamicFilterTimestampsCount() {
      return ((GmpMeasurement.ResultData)this.instance).getDynamicFilterTimestampsCount();
    }
    
    public List<GmpMeasurement.DynamicFilterResultTimestamp> getDynamicFilterTimestampsList() {
      return Collections.unmodifiableList(((GmpMeasurement.ResultData)this.instance).getDynamicFilterTimestampsList());
    }
    
    public long getResults(int param1Int) {
      return ((GmpMeasurement.ResultData)this.instance).getResults(param1Int);
    }
    
    public int getResultsCount() {
      return ((GmpMeasurement.ResultData)this.instance).getResultsCount();
    }
    
    public List<Long> getResultsList() {
      return Collections.unmodifiableList(((GmpMeasurement.ResultData)this.instance).getResultsList());
    }
    
    public GmpMeasurement.SequenceFilterResultTimestamp getSequenceFilterTimestamps(int param1Int) {
      return ((GmpMeasurement.ResultData)this.instance).getSequenceFilterTimestamps(param1Int);
    }
    
    public int getSequenceFilterTimestampsCount() {
      return ((GmpMeasurement.ResultData)this.instance).getSequenceFilterTimestampsCount();
    }
    
    public List<GmpMeasurement.SequenceFilterResultTimestamp> getSequenceFilterTimestampsList() {
      return Collections.unmodifiableList(((GmpMeasurement.ResultData)this.instance).getSequenceFilterTimestampsList());
    }
    
    public long getStatus(int param1Int) {
      return ((GmpMeasurement.ResultData)this.instance).getStatus(param1Int);
    }
    
    public int getStatusCount() {
      return ((GmpMeasurement.ResultData)this.instance).getStatusCount();
    }
    
    public List<Long> getStatusList() {
      return Collections.unmodifiableList(((GmpMeasurement.ResultData)this.instance).getStatusList());
    }
    
    public Builder removeDynamicFilterTimestamps(int param1Int) {
      copyOnWrite();
      ((GmpMeasurement.ResultData)this.instance).removeDynamicFilterTimestamps(param1Int);
      return this;
    }
    
    public Builder removeSequenceFilterTimestamps(int param1Int) {
      copyOnWrite();
      ((GmpMeasurement.ResultData)this.instance).removeSequenceFilterTimestamps(param1Int);
      return this;
    }
    
    public Builder setDynamicFilterTimestamps(int param1Int, GmpMeasurement.DynamicFilterResultTimestamp.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.ResultData)this.instance).setDynamicFilterTimestamps(param1Int, param1Builder);
      return this;
    }
    
    public Builder setDynamicFilterTimestamps(int param1Int, GmpMeasurement.DynamicFilterResultTimestamp param1DynamicFilterResultTimestamp) {
      copyOnWrite();
      ((GmpMeasurement.ResultData)this.instance).setDynamicFilterTimestamps(param1Int, param1DynamicFilterResultTimestamp);
      return this;
    }
    
    public Builder setResults(int param1Int, long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.ResultData)this.instance).setResults(param1Int, param1Long);
      return this;
    }
    
    public Builder setSequenceFilterTimestamps(int param1Int, GmpMeasurement.SequenceFilterResultTimestamp.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurement.ResultData)this.instance).setSequenceFilterTimestamps(param1Int, param1Builder);
      return this;
    }
    
    public Builder setSequenceFilterTimestamps(int param1Int, GmpMeasurement.SequenceFilterResultTimestamp param1SequenceFilterResultTimestamp) {
      copyOnWrite();
      ((GmpMeasurement.ResultData)this.instance).setSequenceFilterTimestamps(param1Int, param1SequenceFilterResultTimestamp);
      return this;
    }
    
    public Builder setStatus(int param1Int, long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.ResultData)this.instance).setStatus(param1Int, param1Long);
      return this;
    }
  }
  
  public static interface ResultDataOrBuilder extends MessageLiteOrBuilder {
    GmpMeasurement.DynamicFilterResultTimestamp getDynamicFilterTimestamps(int param1Int);
    
    int getDynamicFilterTimestampsCount();
    
    List<GmpMeasurement.DynamicFilterResultTimestamp> getDynamicFilterTimestampsList();
    
    long getResults(int param1Int);
    
    int getResultsCount();
    
    List<Long> getResultsList();
    
    GmpMeasurement.SequenceFilterResultTimestamp getSequenceFilterTimestamps(int param1Int);
    
    int getSequenceFilterTimestampsCount();
    
    List<GmpMeasurement.SequenceFilterResultTimestamp> getSequenceFilterTimestampsList();
    
    long getStatus(int param1Int);
    
    int getStatusCount();
    
    List<Long> getStatusList();
  }
  
  public static final class SequenceFilterResultTimestamp extends GeneratedMessageLite<SequenceFilterResultTimestamp, SequenceFilterResultTimestamp.Builder> implements SequenceFilterResultTimestampOrBuilder {
    private static final SequenceFilterResultTimestamp DEFAULT_INSTANCE = new SequenceFilterResultTimestamp();
    
    public static final int EVAL_TIMESTAMPS_FIELD_NUMBER = 2;
    
    public static final int INDEX_FIELD_NUMBER = 1;
    
    private static volatile Parser<SequenceFilterResultTimestamp> PARSER;
    
    private int bitField0_;
    
    private Internal.LongList evalTimestamps_ = emptyLongList();
    
    private int index_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllEvalTimestamps(Iterable<? extends Long> param1Iterable) {
      ensureEvalTimestampsIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.evalTimestamps_);
    }
    
    private void addEvalTimestamps(long param1Long) {
      ensureEvalTimestampsIsMutable();
      this.evalTimestamps_.addLong(param1Long);
    }
    
    private void clearEvalTimestamps() {
      this.evalTimestamps_ = emptyLongList();
    }
    
    private void clearIndex() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.index_ = 0;
    }
    
    private void ensureEvalTimestampsIsMutable() {
      if (!this.evalTimestamps_.isModifiable())
        this.evalTimestamps_ = GeneratedMessageLite.mutableCopy(this.evalTimestamps_); 
    }
    
    public static SequenceFilterResultTimestamp getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(SequenceFilterResultTimestamp param1SequenceFilterResultTimestamp) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1SequenceFilterResultTimestamp);
    }
    
    public static SequenceFilterResultTimestamp parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (SequenceFilterResultTimestamp)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static SequenceFilterResultTimestamp parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (SequenceFilterResultTimestamp)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static SequenceFilterResultTimestamp parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (SequenceFilterResultTimestamp)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static SequenceFilterResultTimestamp parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (SequenceFilterResultTimestamp)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static SequenceFilterResultTimestamp parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (SequenceFilterResultTimestamp)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static SequenceFilterResultTimestamp parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (SequenceFilterResultTimestamp)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static SequenceFilterResultTimestamp parseFrom(InputStream param1InputStream) throws IOException {
      return (SequenceFilterResultTimestamp)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static SequenceFilterResultTimestamp parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (SequenceFilterResultTimestamp)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static SequenceFilterResultTimestamp parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (SequenceFilterResultTimestamp)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static SequenceFilterResultTimestamp parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (SequenceFilterResultTimestamp)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<SequenceFilterResultTimestamp> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setEvalTimestamps(int param1Int, long param1Long) {
      ensureEvalTimestampsIsMutable();
      this.evalTimestamps_.setLong(param1Int, param1Long);
    }
    
    private void setIndex(int param1Int) {
      this.bitField0_ |= 0x1;
      this.index_ = param1Int;
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic analytics_collection/GmpMeasurement$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 468, 2 -> 464, 3 -> 453, 4 -> 444, 5 -> 368, 6 -> 110, 7 -> 364, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic analytics_collection/GmpMeasurement$SequenceFilterResultTimestamp.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc analytics_collection/GmpMeasurement$SequenceFilterResultTimestamp
      //   72: monitorenter
      //   73: getstatic analytics_collection/GmpMeasurement$SequenceFilterResultTimestamp.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic analytics_collection/GmpMeasurement$SequenceFilterResultTimestamp.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$SequenceFilterResultTimestamp;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic analytics_collection/GmpMeasurement$SequenceFilterResultTimestamp.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc analytics_collection/GmpMeasurement$SequenceFilterResultTimestamp
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc analytics_collection/GmpMeasurement$SequenceFilterResultTimestamp
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic analytics_collection/GmpMeasurement$SequenceFilterResultTimestamp.PARSER : Lcom/google/protobuf/Parser;
      //   109: areturn
      //   110: aload_2
      //   111: checkcast com/google/protobuf/CodedInputStream
      //   114: astore_1
      //   115: aload_3
      //   116: checkcast com/google/protobuf/ExtensionRegistryLite
      //   119: astore_2
      //   120: iconst_0
      //   121: istore #4
      //   123: iload #4
      //   125: ifne -> 364
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 308
      //   139: iload #5
      //   141: bipush #8
      //   143: if_icmpeq -> 287
      //   146: iload #5
      //   148: bipush #16
      //   150: if_icmpeq -> 248
      //   153: iload #5
      //   155: bipush #18
      //   157: if_icmpeq -> 176
      //   160: aload_0
      //   161: iload #5
      //   163: aload_1
      //   164: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   167: ifne -> 123
      //   170: iconst_1
      //   171: istore #4
      //   173: goto -> 123
      //   176: aload_1
      //   177: aload_1
      //   178: invokevirtual readRawVarint32 : ()I
      //   181: invokevirtual pushLimit : (I)I
      //   184: istore #5
      //   186: aload_0
      //   187: getfield evalTimestamps_ : Lcom/google/protobuf/Internal$LongList;
      //   190: invokeinterface isModifiable : ()Z
      //   195: ifne -> 216
      //   198: aload_1
      //   199: invokevirtual getBytesUntilLimit : ()I
      //   202: ifle -> 216
      //   205: aload_0
      //   206: aload_0
      //   207: getfield evalTimestamps_ : Lcom/google/protobuf/Internal$LongList;
      //   210: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$LongList;)Lcom/google/protobuf/Internal$LongList;
      //   213: putfield evalTimestamps_ : Lcom/google/protobuf/Internal$LongList;
      //   216: aload_1
      //   217: invokevirtual getBytesUntilLimit : ()I
      //   220: ifle -> 239
      //   223: aload_0
      //   224: getfield evalTimestamps_ : Lcom/google/protobuf/Internal$LongList;
      //   227: aload_1
      //   228: invokevirtual readInt64 : ()J
      //   231: invokeinterface addLong : (J)V
      //   236: goto -> 216
      //   239: aload_1
      //   240: iload #5
      //   242: invokevirtual popLimit : (I)V
      //   245: goto -> 123
      //   248: aload_0
      //   249: getfield evalTimestamps_ : Lcom/google/protobuf/Internal$LongList;
      //   252: invokeinterface isModifiable : ()Z
      //   257: ifne -> 271
      //   260: aload_0
      //   261: aload_0
      //   262: getfield evalTimestamps_ : Lcom/google/protobuf/Internal$LongList;
      //   265: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$LongList;)Lcom/google/protobuf/Internal$LongList;
      //   268: putfield evalTimestamps_ : Lcom/google/protobuf/Internal$LongList;
      //   271: aload_0
      //   272: getfield evalTimestamps_ : Lcom/google/protobuf/Internal$LongList;
      //   275: aload_1
      //   276: invokevirtual readInt64 : ()J
      //   279: invokeinterface addLong : (J)V
      //   284: goto -> 123
      //   287: aload_0
      //   288: aload_0
      //   289: getfield bitField0_ : I
      //   292: iconst_1
      //   293: ior
      //   294: putfield bitField0_ : I
      //   297: aload_0
      //   298: aload_1
      //   299: invokevirtual readInt32 : ()I
      //   302: putfield index_ : I
      //   305: goto -> 123
      //   308: iconst_1
      //   309: istore #4
      //   311: goto -> 123
      //   314: astore_1
      //   315: goto -> 362
      //   318: astore_1
      //   319: new java/lang/RuntimeException
      //   322: astore_2
      //   323: new com/google/protobuf/InvalidProtocolBufferException
      //   326: astore_3
      //   327: aload_3
      //   328: aload_1
      //   329: invokevirtual getMessage : ()Ljava/lang/String;
      //   332: invokespecial <init> : (Ljava/lang/String;)V
      //   335: aload_2
      //   336: aload_3
      //   337: aload_0
      //   338: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   341: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   344: aload_2
      //   345: athrow
      //   346: astore_1
      //   347: new java/lang/RuntimeException
      //   350: astore_2
      //   351: aload_2
      //   352: aload_1
      //   353: aload_0
      //   354: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   357: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   360: aload_2
      //   361: athrow
      //   362: aload_1
      //   363: athrow
      //   364: getstatic analytics_collection/GmpMeasurement$SequenceFilterResultTimestamp.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$SequenceFilterResultTimestamp;
      //   367: areturn
      //   368: aload_2
      //   369: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   372: astore_1
      //   373: aload_3
      //   374: checkcast analytics_collection/GmpMeasurement$SequenceFilterResultTimestamp
      //   377: astore_2
      //   378: aload_0
      //   379: aload_1
      //   380: aload_0
      //   381: invokevirtual hasIndex : ()Z
      //   384: aload_0
      //   385: getfield index_ : I
      //   388: aload_2
      //   389: invokevirtual hasIndex : ()Z
      //   392: aload_2
      //   393: getfield index_ : I
      //   396: invokeinterface visitInt : (ZIZI)I
      //   401: putfield index_ : I
      //   404: aload_0
      //   405: aload_1
      //   406: aload_0
      //   407: getfield evalTimestamps_ : Lcom/google/protobuf/Internal$LongList;
      //   410: aload_2
      //   411: getfield evalTimestamps_ : Lcom/google/protobuf/Internal$LongList;
      //   414: invokeinterface visitLongList : (Lcom/google/protobuf/Internal$LongList;Lcom/google/protobuf/Internal$LongList;)Lcom/google/protobuf/Internal$LongList;
      //   419: putfield evalTimestamps_ : Lcom/google/protobuf/Internal$LongList;
      //   422: aload_1
      //   423: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   426: if_acmpne -> 442
      //   429: aload_0
      //   430: aload_0
      //   431: getfield bitField0_ : I
      //   434: aload_2
      //   435: getfield bitField0_ : I
      //   438: ior
      //   439: putfield bitField0_ : I
      //   442: aload_0
      //   443: areturn
      //   444: new analytics_collection/GmpMeasurement$SequenceFilterResultTimestamp$Builder
      //   447: dup
      //   448: aconst_null
      //   449: invokespecial <init> : (Lanalytics_collection/GmpMeasurement$1;)V
      //   452: areturn
      //   453: aload_0
      //   454: getfield evalTimestamps_ : Lcom/google/protobuf/Internal$LongList;
      //   457: invokeinterface makeImmutable : ()V
      //   462: aconst_null
      //   463: areturn
      //   464: getstatic analytics_collection/GmpMeasurement$SequenceFilterResultTimestamp.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$SequenceFilterResultTimestamp;
      //   467: areturn
      //   468: new analytics_collection/GmpMeasurement$SequenceFilterResultTimestamp
      //   471: dup
      //   472: invokespecial <init> : ()V
      //   475: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	346	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	318	java/io/IOException
      //   128	134	314	finally
      //   160	170	346	com/google/protobuf/InvalidProtocolBufferException
      //   160	170	318	java/io/IOException
      //   160	170	314	finally
      //   176	216	346	com/google/protobuf/InvalidProtocolBufferException
      //   176	216	318	java/io/IOException
      //   176	216	314	finally
      //   216	236	346	com/google/protobuf/InvalidProtocolBufferException
      //   216	236	318	java/io/IOException
      //   216	236	314	finally
      //   239	245	346	com/google/protobuf/InvalidProtocolBufferException
      //   239	245	318	java/io/IOException
      //   239	245	314	finally
      //   248	271	346	com/google/protobuf/InvalidProtocolBufferException
      //   248	271	318	java/io/IOException
      //   248	271	314	finally
      //   271	284	346	com/google/protobuf/InvalidProtocolBufferException
      //   271	284	318	java/io/IOException
      //   271	284	314	finally
      //   287	305	346	com/google/protobuf/InvalidProtocolBufferException
      //   287	305	318	java/io/IOException
      //   287	305	314	finally
      //   319	346	314	finally
      //   347	362	314	finally
    }
    
    public long getEvalTimestamps(int param1Int) {
      return this.evalTimestamps_.getLong(param1Int);
    }
    
    public int getEvalTimestampsCount() {
      return this.evalTimestamps_.size();
    }
    
    public List<Long> getEvalTimestampsList() {
      return (List<Long>)this.evalTimestamps_;
    }
    
    public int getIndex() {
      return this.index_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = this.bitField0_;
      byte b = 0;
      if ((i & 0x1) == 1) {
        i = CodedOutputStream.computeInt32Size(1, this.index_) + 0;
      } else {
        i = 0;
      } 
      int j = 0;
      while (b < this.evalTimestamps_.size()) {
        j += CodedOutputStream.computeInt64SizeNoTag(this.evalTimestamps_.getLong(b));
        b++;
      } 
      i = i + j + getEvalTimestampsList().size() * 1 + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasIndex() {
      int i = this.bitField0_;
      boolean bool = true;
      if ((i & 0x1) != 1)
        bool = false; 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if ((this.bitField0_ & 0x1) == 1)
        param1CodedOutputStream.writeInt32(1, this.index_); 
      for (byte b = 0; b < this.evalTimestamps_.size(); b++)
        param1CodedOutputStream.writeInt64(2, this.evalTimestamps_.getLong(b)); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<SequenceFilterResultTimestamp, Builder> implements GmpMeasurement.SequenceFilterResultTimestampOrBuilder {
      private Builder() {
        super(GmpMeasurement.SequenceFilterResultTimestamp.DEFAULT_INSTANCE);
      }
      
      public Builder addAllEvalTimestamps(Iterable<? extends Long> param2Iterable) {
        copyOnWrite();
        ((GmpMeasurement.SequenceFilterResultTimestamp)this.instance).addAllEvalTimestamps(param2Iterable);
        return this;
      }
      
      public Builder addEvalTimestamps(long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.SequenceFilterResultTimestamp)this.instance).addEvalTimestamps(param2Long);
        return this;
      }
      
      public Builder clearEvalTimestamps() {
        copyOnWrite();
        ((GmpMeasurement.SequenceFilterResultTimestamp)this.instance).clearEvalTimestamps();
        return this;
      }
      
      public Builder clearIndex() {
        copyOnWrite();
        ((GmpMeasurement.SequenceFilterResultTimestamp)this.instance).clearIndex();
        return this;
      }
      
      public long getEvalTimestamps(int param2Int) {
        return ((GmpMeasurement.SequenceFilterResultTimestamp)this.instance).getEvalTimestamps(param2Int);
      }
      
      public int getEvalTimestampsCount() {
        return ((GmpMeasurement.SequenceFilterResultTimestamp)this.instance).getEvalTimestampsCount();
      }
      
      public List<Long> getEvalTimestampsList() {
        return Collections.unmodifiableList(((GmpMeasurement.SequenceFilterResultTimestamp)this.instance).getEvalTimestampsList());
      }
      
      public int getIndex() {
        return ((GmpMeasurement.SequenceFilterResultTimestamp)this.instance).getIndex();
      }
      
      public boolean hasIndex() {
        return ((GmpMeasurement.SequenceFilterResultTimestamp)this.instance).hasIndex();
      }
      
      public Builder setEvalTimestamps(int param2Int, long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.SequenceFilterResultTimestamp)this.instance).setEvalTimestamps(param2Int, param2Long);
        return this;
      }
      
      public Builder setIndex(int param2Int) {
        copyOnWrite();
        ((GmpMeasurement.SequenceFilterResultTimestamp)this.instance).setIndex(param2Int);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<SequenceFilterResultTimestamp, SequenceFilterResultTimestamp.Builder> implements SequenceFilterResultTimestampOrBuilder {
    private Builder() {
      super(GmpMeasurement.SequenceFilterResultTimestamp.DEFAULT_INSTANCE);
    }
    
    public Builder addAllEvalTimestamps(Iterable<? extends Long> param1Iterable) {
      copyOnWrite();
      ((GmpMeasurement.SequenceFilterResultTimestamp)this.instance).addAllEvalTimestamps(param1Iterable);
      return this;
    }
    
    public Builder addEvalTimestamps(long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.SequenceFilterResultTimestamp)this.instance).addEvalTimestamps(param1Long);
      return this;
    }
    
    public Builder clearEvalTimestamps() {
      copyOnWrite();
      ((GmpMeasurement.SequenceFilterResultTimestamp)this.instance).clearEvalTimestamps();
      return this;
    }
    
    public Builder clearIndex() {
      copyOnWrite();
      ((GmpMeasurement.SequenceFilterResultTimestamp)this.instance).clearIndex();
      return this;
    }
    
    public long getEvalTimestamps(int param1Int) {
      return ((GmpMeasurement.SequenceFilterResultTimestamp)this.instance).getEvalTimestamps(param1Int);
    }
    
    public int getEvalTimestampsCount() {
      return ((GmpMeasurement.SequenceFilterResultTimestamp)this.instance).getEvalTimestampsCount();
    }
    
    public List<Long> getEvalTimestampsList() {
      return Collections.unmodifiableList(((GmpMeasurement.SequenceFilterResultTimestamp)this.instance).getEvalTimestampsList());
    }
    
    public int getIndex() {
      return ((GmpMeasurement.SequenceFilterResultTimestamp)this.instance).getIndex();
    }
    
    public boolean hasIndex() {
      return ((GmpMeasurement.SequenceFilterResultTimestamp)this.instance).hasIndex();
    }
    
    public Builder setEvalTimestamps(int param1Int, long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.SequenceFilterResultTimestamp)this.instance).setEvalTimestamps(param1Int, param1Long);
      return this;
    }
    
    public Builder setIndex(int param1Int) {
      copyOnWrite();
      ((GmpMeasurement.SequenceFilterResultTimestamp)this.instance).setIndex(param1Int);
      return this;
    }
  }
  
  public static interface SequenceFilterResultTimestampOrBuilder extends MessageLiteOrBuilder {
    long getEvalTimestamps(int param1Int);
    
    int getEvalTimestampsCount();
    
    List<Long> getEvalTimestampsList();
    
    int getIndex();
    
    boolean hasIndex();
  }
  
  public static final class UserAttribute extends GeneratedMessageLite<UserAttribute, UserAttribute.Builder> implements UserAttributeOrBuilder {
    private static final UserAttribute DEFAULT_INSTANCE = new UserAttribute();
    
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 6;
    
    public static final int FLOAT_VALUE_FIELD_NUMBER = 5;
    
    public static final int INT_VALUE_FIELD_NUMBER = 4;
    
    public static final int NAME_FIELD_NUMBER = 2;
    
    private static volatile Parser<UserAttribute> PARSER;
    
    public static final int SET_TIMESTAMP_MILLIS_FIELD_NUMBER = 1;
    
    public static final int STRING_VALUE_FIELD_NUMBER = 3;
    
    private int bitField0_;
    
    private double doubleValue_;
    
    private float floatValue_;
    
    private long intValue_;
    
    private String name_ = "";
    
    private long setTimestampMillis_;
    
    private String stringValue_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearDoubleValue() {
      this.bitField0_ &= 0xFFFFFFDF;
      this.doubleValue_ = 0.0D;
    }
    
    private void clearFloatValue() {
      this.bitField0_ &= 0xFFFFFFEF;
      this.floatValue_ = 0.0F;
    }
    
    private void clearIntValue() {
      this.bitField0_ &= 0xFFFFFFF7;
      this.intValue_ = 0L;
    }
    
    private void clearName() {
      this.bitField0_ &= 0xFFFFFFFD;
      this.name_ = getDefaultInstance().getName();
    }
    
    private void clearSetTimestampMillis() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.setTimestampMillis_ = 0L;
    }
    
    private void clearStringValue() {
      this.bitField0_ &= 0xFFFFFFFB;
      this.stringValue_ = getDefaultInstance().getStringValue();
    }
    
    public static UserAttribute getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(UserAttribute param1UserAttribute) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1UserAttribute);
    }
    
    public static UserAttribute parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (UserAttribute)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static UserAttribute parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (UserAttribute)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static UserAttribute parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (UserAttribute)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static UserAttribute parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (UserAttribute)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static UserAttribute parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (UserAttribute)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static UserAttribute parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (UserAttribute)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static UserAttribute parseFrom(InputStream param1InputStream) throws IOException {
      return (UserAttribute)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static UserAttribute parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (UserAttribute)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static UserAttribute parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (UserAttribute)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static UserAttribute parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (UserAttribute)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<UserAttribute> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setDoubleValue(double param1Double) {
      this.bitField0_ |= 0x20;
      this.doubleValue_ = param1Double;
    }
    
    private void setFloatValue(float param1Float) {
      this.bitField0_ |= 0x10;
      this.floatValue_ = param1Float;
    }
    
    private void setIntValue(long param1Long) {
      this.bitField0_ |= 0x8;
      this.intValue_ = param1Long;
    }
    
    private void setName(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x2;
        this.name_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x2;
        this.name_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setSetTimestampMillis(long param1Long) {
      this.bitField0_ |= 0x1;
      this.setTimestampMillis_ = param1Long;
    }
    
    private void setStringValue(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x4;
        this.stringValue_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setStringValueBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x4;
        this.stringValue_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic analytics_collection/GmpMeasurement$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 593, 2 -> 589, 3 -> 587, 4 -> 578, 5 -> 390, 6 -> 110, 7 -> 386, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic analytics_collection/GmpMeasurement$UserAttribute.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc analytics_collection/GmpMeasurement$UserAttribute
      //   72: monitorenter
      //   73: getstatic analytics_collection/GmpMeasurement$UserAttribute.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic analytics_collection/GmpMeasurement$UserAttribute.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$UserAttribute;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic analytics_collection/GmpMeasurement$UserAttribute.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc analytics_collection/GmpMeasurement$UserAttribute
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc analytics_collection/GmpMeasurement$UserAttribute
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic analytics_collection/GmpMeasurement$UserAttribute.PARSER : Lcom/google/protobuf/Parser;
      //   109: areturn
      //   110: aload_2
      //   111: checkcast com/google/protobuf/CodedInputStream
      //   114: astore_1
      //   115: aload_3
      //   116: checkcast com/google/protobuf/ExtensionRegistryLite
      //   119: astore_2
      //   120: iconst_0
      //   121: istore #4
      //   123: iload #4
      //   125: ifne -> 386
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 330
      //   139: iload #5
      //   141: bipush #8
      //   143: if_icmpeq -> 309
      //   146: iload #5
      //   148: bipush #18
      //   150: if_icmpeq -> 286
      //   153: iload #5
      //   155: bipush #26
      //   157: if_icmpeq -> 263
      //   160: iload #5
      //   162: bipush #32
      //   164: if_icmpeq -> 241
      //   167: iload #5
      //   169: bipush #45
      //   171: if_icmpeq -> 219
      //   174: iload #5
      //   176: bipush #49
      //   178: if_icmpeq -> 197
      //   181: aload_0
      //   182: iload #5
      //   184: aload_1
      //   185: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   188: ifne -> 123
      //   191: iconst_1
      //   192: istore #4
      //   194: goto -> 123
      //   197: aload_0
      //   198: aload_0
      //   199: getfield bitField0_ : I
      //   202: bipush #32
      //   204: ior
      //   205: putfield bitField0_ : I
      //   208: aload_0
      //   209: aload_1
      //   210: invokevirtual readDouble : ()D
      //   213: putfield doubleValue_ : D
      //   216: goto -> 123
      //   219: aload_0
      //   220: aload_0
      //   221: getfield bitField0_ : I
      //   224: bipush #16
      //   226: ior
      //   227: putfield bitField0_ : I
      //   230: aload_0
      //   231: aload_1
      //   232: invokevirtual readFloat : ()F
      //   235: putfield floatValue_ : F
      //   238: goto -> 123
      //   241: aload_0
      //   242: aload_0
      //   243: getfield bitField0_ : I
      //   246: bipush #8
      //   248: ior
      //   249: putfield bitField0_ : I
      //   252: aload_0
      //   253: aload_1
      //   254: invokevirtual readInt64 : ()J
      //   257: putfield intValue_ : J
      //   260: goto -> 123
      //   263: aload_1
      //   264: invokevirtual readString : ()Ljava/lang/String;
      //   267: astore_2
      //   268: aload_0
      //   269: aload_0
      //   270: getfield bitField0_ : I
      //   273: iconst_4
      //   274: ior
      //   275: putfield bitField0_ : I
      //   278: aload_0
      //   279: aload_2
      //   280: putfield stringValue_ : Ljava/lang/String;
      //   283: goto -> 123
      //   286: aload_1
      //   287: invokevirtual readString : ()Ljava/lang/String;
      //   290: astore_2
      //   291: aload_0
      //   292: aload_0
      //   293: getfield bitField0_ : I
      //   296: iconst_2
      //   297: ior
      //   298: putfield bitField0_ : I
      //   301: aload_0
      //   302: aload_2
      //   303: putfield name_ : Ljava/lang/String;
      //   306: goto -> 123
      //   309: aload_0
      //   310: aload_0
      //   311: getfield bitField0_ : I
      //   314: iconst_1
      //   315: ior
      //   316: putfield bitField0_ : I
      //   319: aload_0
      //   320: aload_1
      //   321: invokevirtual readInt64 : ()J
      //   324: putfield setTimestampMillis_ : J
      //   327: goto -> 123
      //   330: iconst_1
      //   331: istore #4
      //   333: goto -> 123
      //   336: astore_1
      //   337: goto -> 384
      //   340: astore_1
      //   341: new java/lang/RuntimeException
      //   344: astore_2
      //   345: new com/google/protobuf/InvalidProtocolBufferException
      //   348: astore_3
      //   349: aload_3
      //   350: aload_1
      //   351: invokevirtual getMessage : ()Ljava/lang/String;
      //   354: invokespecial <init> : (Ljava/lang/String;)V
      //   357: aload_2
      //   358: aload_3
      //   359: aload_0
      //   360: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   363: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   366: aload_2
      //   367: athrow
      //   368: astore_2
      //   369: new java/lang/RuntimeException
      //   372: astore_1
      //   373: aload_1
      //   374: aload_2
      //   375: aload_0
      //   376: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   379: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   382: aload_1
      //   383: athrow
      //   384: aload_1
      //   385: athrow
      //   386: getstatic analytics_collection/GmpMeasurement$UserAttribute.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$UserAttribute;
      //   389: areturn
      //   390: aload_2
      //   391: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   394: astore_1
      //   395: aload_3
      //   396: checkcast analytics_collection/GmpMeasurement$UserAttribute
      //   399: astore_2
      //   400: aload_0
      //   401: aload_1
      //   402: aload_0
      //   403: invokevirtual hasSetTimestampMillis : ()Z
      //   406: aload_0
      //   407: getfield setTimestampMillis_ : J
      //   410: aload_2
      //   411: invokevirtual hasSetTimestampMillis : ()Z
      //   414: aload_2
      //   415: getfield setTimestampMillis_ : J
      //   418: invokeinterface visitLong : (ZJZJ)J
      //   423: putfield setTimestampMillis_ : J
      //   426: aload_0
      //   427: aload_1
      //   428: aload_0
      //   429: invokevirtual hasName : ()Z
      //   432: aload_0
      //   433: getfield name_ : Ljava/lang/String;
      //   436: aload_2
      //   437: invokevirtual hasName : ()Z
      //   440: aload_2
      //   441: getfield name_ : Ljava/lang/String;
      //   444: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   449: putfield name_ : Ljava/lang/String;
      //   452: aload_0
      //   453: aload_1
      //   454: aload_0
      //   455: invokevirtual hasStringValue : ()Z
      //   458: aload_0
      //   459: getfield stringValue_ : Ljava/lang/String;
      //   462: aload_2
      //   463: invokevirtual hasStringValue : ()Z
      //   466: aload_2
      //   467: getfield stringValue_ : Ljava/lang/String;
      //   470: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   475: putfield stringValue_ : Ljava/lang/String;
      //   478: aload_0
      //   479: aload_1
      //   480: aload_0
      //   481: invokevirtual hasIntValue : ()Z
      //   484: aload_0
      //   485: getfield intValue_ : J
      //   488: aload_2
      //   489: invokevirtual hasIntValue : ()Z
      //   492: aload_2
      //   493: getfield intValue_ : J
      //   496: invokeinterface visitLong : (ZJZJ)J
      //   501: putfield intValue_ : J
      //   504: aload_0
      //   505: aload_1
      //   506: aload_0
      //   507: invokevirtual hasFloatValue : ()Z
      //   510: aload_0
      //   511: getfield floatValue_ : F
      //   514: aload_2
      //   515: invokevirtual hasFloatValue : ()Z
      //   518: aload_2
      //   519: getfield floatValue_ : F
      //   522: invokeinterface visitFloat : (ZFZF)F
      //   527: putfield floatValue_ : F
      //   530: aload_0
      //   531: aload_1
      //   532: aload_0
      //   533: invokevirtual hasDoubleValue : ()Z
      //   536: aload_0
      //   537: getfield doubleValue_ : D
      //   540: aload_2
      //   541: invokevirtual hasDoubleValue : ()Z
      //   544: aload_2
      //   545: getfield doubleValue_ : D
      //   548: invokeinterface visitDouble : (ZDZD)D
      //   553: putfield doubleValue_ : D
      //   556: aload_1
      //   557: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   560: if_acmpne -> 576
      //   563: aload_0
      //   564: aload_0
      //   565: getfield bitField0_ : I
      //   568: aload_2
      //   569: getfield bitField0_ : I
      //   572: ior
      //   573: putfield bitField0_ : I
      //   576: aload_0
      //   577: areturn
      //   578: new analytics_collection/GmpMeasurement$UserAttribute$Builder
      //   581: dup
      //   582: aconst_null
      //   583: invokespecial <init> : (Lanalytics_collection/GmpMeasurement$1;)V
      //   586: areturn
      //   587: aconst_null
      //   588: areturn
      //   589: getstatic analytics_collection/GmpMeasurement$UserAttribute.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurement$UserAttribute;
      //   592: areturn
      //   593: new analytics_collection/GmpMeasurement$UserAttribute
      //   596: dup
      //   597: invokespecial <init> : ()V
      //   600: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	368	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	340	java/io/IOException
      //   128	134	336	finally
      //   181	191	368	com/google/protobuf/InvalidProtocolBufferException
      //   181	191	340	java/io/IOException
      //   181	191	336	finally
      //   197	216	368	com/google/protobuf/InvalidProtocolBufferException
      //   197	216	340	java/io/IOException
      //   197	216	336	finally
      //   219	238	368	com/google/protobuf/InvalidProtocolBufferException
      //   219	238	340	java/io/IOException
      //   219	238	336	finally
      //   241	260	368	com/google/protobuf/InvalidProtocolBufferException
      //   241	260	340	java/io/IOException
      //   241	260	336	finally
      //   263	283	368	com/google/protobuf/InvalidProtocolBufferException
      //   263	283	340	java/io/IOException
      //   263	283	336	finally
      //   286	306	368	com/google/protobuf/InvalidProtocolBufferException
      //   286	306	340	java/io/IOException
      //   286	306	336	finally
      //   309	327	368	com/google/protobuf/InvalidProtocolBufferException
      //   309	327	340	java/io/IOException
      //   309	327	336	finally
      //   341	368	336	finally
      //   369	384	336	finally
    }
    
    public double getDoubleValue() {
      return this.doubleValue_;
    }
    
    public float getFloatValue() {
      return this.floatValue_;
    }
    
    public long getIntValue() {
      return this.intValue_;
    }
    
    public String getName() {
      return this.name_;
    }
    
    public ByteString getNameBytes() {
      return ByteString.copyFromUtf8(this.name_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if ((this.bitField0_ & 0x1) == 1)
        j = 0 + CodedOutputStream.computeInt64Size(1, this.setTimestampMillis_); 
      i = j;
      if ((this.bitField0_ & 0x2) == 2)
        i = j + CodedOutputStream.computeStringSize(2, getName()); 
      int k = i;
      if ((this.bitField0_ & 0x4) == 4)
        k = i + CodedOutputStream.computeStringSize(3, getStringValue()); 
      j = k;
      if ((this.bitField0_ & 0x8) == 8)
        j = k + CodedOutputStream.computeInt64Size(4, this.intValue_); 
      i = j;
      if ((this.bitField0_ & 0x10) == 16)
        i = j + CodedOutputStream.computeFloatSize(5, this.floatValue_); 
      j = i;
      if ((this.bitField0_ & 0x20) == 32)
        j = i + CodedOutputStream.computeDoubleSize(6, this.doubleValue_); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public long getSetTimestampMillis() {
      return this.setTimestampMillis_;
    }
    
    public String getStringValue() {
      return this.stringValue_;
    }
    
    public ByteString getStringValueBytes() {
      return ByteString.copyFromUtf8(this.stringValue_);
    }
    
    public boolean hasDoubleValue() {
      boolean bool;
      if ((this.bitField0_ & 0x20) == 32) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasFloatValue() {
      boolean bool;
      if ((this.bitField0_ & 0x10) == 16) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasIntValue() {
      boolean bool;
      if ((this.bitField0_ & 0x8) == 8) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasName() {
      boolean bool;
      if ((this.bitField0_ & 0x2) == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasSetTimestampMillis() {
      int i = this.bitField0_;
      boolean bool = true;
      if ((i & 0x1) != 1)
        bool = false; 
      return bool;
    }
    
    public boolean hasStringValue() {
      boolean bool;
      if ((this.bitField0_ & 0x4) == 4) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if ((this.bitField0_ & 0x1) == 1)
        param1CodedOutputStream.writeInt64(1, this.setTimestampMillis_); 
      if ((this.bitField0_ & 0x2) == 2)
        param1CodedOutputStream.writeString(2, getName()); 
      if ((this.bitField0_ & 0x4) == 4)
        param1CodedOutputStream.writeString(3, getStringValue()); 
      if ((this.bitField0_ & 0x8) == 8)
        param1CodedOutputStream.writeInt64(4, this.intValue_); 
      if ((this.bitField0_ & 0x10) == 16)
        param1CodedOutputStream.writeFloat(5, this.floatValue_); 
      if ((this.bitField0_ & 0x20) == 32)
        param1CodedOutputStream.writeDouble(6, this.doubleValue_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<UserAttribute, Builder> implements GmpMeasurement.UserAttributeOrBuilder {
      private Builder() {
        super(GmpMeasurement.UserAttribute.DEFAULT_INSTANCE);
      }
      
      public Builder clearDoubleValue() {
        copyOnWrite();
        ((GmpMeasurement.UserAttribute)this.instance).clearDoubleValue();
        return this;
      }
      
      public Builder clearFloatValue() {
        copyOnWrite();
        ((GmpMeasurement.UserAttribute)this.instance).clearFloatValue();
        return this;
      }
      
      public Builder clearIntValue() {
        copyOnWrite();
        ((GmpMeasurement.UserAttribute)this.instance).clearIntValue();
        return this;
      }
      
      public Builder clearName() {
        copyOnWrite();
        ((GmpMeasurement.UserAttribute)this.instance).clearName();
        return this;
      }
      
      public Builder clearSetTimestampMillis() {
        copyOnWrite();
        ((GmpMeasurement.UserAttribute)this.instance).clearSetTimestampMillis();
        return this;
      }
      
      public Builder clearStringValue() {
        copyOnWrite();
        ((GmpMeasurement.UserAttribute)this.instance).clearStringValue();
        return this;
      }
      
      public double getDoubleValue() {
        return ((GmpMeasurement.UserAttribute)this.instance).getDoubleValue();
      }
      
      public float getFloatValue() {
        return ((GmpMeasurement.UserAttribute)this.instance).getFloatValue();
      }
      
      public long getIntValue() {
        return ((GmpMeasurement.UserAttribute)this.instance).getIntValue();
      }
      
      public String getName() {
        return ((GmpMeasurement.UserAttribute)this.instance).getName();
      }
      
      public ByteString getNameBytes() {
        return ((GmpMeasurement.UserAttribute)this.instance).getNameBytes();
      }
      
      public long getSetTimestampMillis() {
        return ((GmpMeasurement.UserAttribute)this.instance).getSetTimestampMillis();
      }
      
      public String getStringValue() {
        return ((GmpMeasurement.UserAttribute)this.instance).getStringValue();
      }
      
      public ByteString getStringValueBytes() {
        return ((GmpMeasurement.UserAttribute)this.instance).getStringValueBytes();
      }
      
      public boolean hasDoubleValue() {
        return ((GmpMeasurement.UserAttribute)this.instance).hasDoubleValue();
      }
      
      public boolean hasFloatValue() {
        return ((GmpMeasurement.UserAttribute)this.instance).hasFloatValue();
      }
      
      public boolean hasIntValue() {
        return ((GmpMeasurement.UserAttribute)this.instance).hasIntValue();
      }
      
      public boolean hasName() {
        return ((GmpMeasurement.UserAttribute)this.instance).hasName();
      }
      
      public boolean hasSetTimestampMillis() {
        return ((GmpMeasurement.UserAttribute)this.instance).hasSetTimestampMillis();
      }
      
      public boolean hasStringValue() {
        return ((GmpMeasurement.UserAttribute)this.instance).hasStringValue();
      }
      
      public Builder setDoubleValue(double param2Double) {
        copyOnWrite();
        ((GmpMeasurement.UserAttribute)this.instance).setDoubleValue(param2Double);
        return this;
      }
      
      public Builder setFloatValue(float param2Float) {
        copyOnWrite();
        ((GmpMeasurement.UserAttribute)this.instance).setFloatValue(param2Float);
        return this;
      }
      
      public Builder setIntValue(long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.UserAttribute)this.instance).setIntValue(param2Long);
        return this;
      }
      
      public Builder setName(String param2String) {
        copyOnWrite();
        ((GmpMeasurement.UserAttribute)this.instance).setName(param2String);
        return this;
      }
      
      public Builder setNameBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurement.UserAttribute)this.instance).setNameBytes(param2ByteString);
        return this;
      }
      
      public Builder setSetTimestampMillis(long param2Long) {
        copyOnWrite();
        ((GmpMeasurement.UserAttribute)this.instance).setSetTimestampMillis(param2Long);
        return this;
      }
      
      public Builder setStringValue(String param2String) {
        copyOnWrite();
        ((GmpMeasurement.UserAttribute)this.instance).setStringValue(param2String);
        return this;
      }
      
      public Builder setStringValueBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurement.UserAttribute)this.instance).setStringValueBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<UserAttribute, UserAttribute.Builder> implements UserAttributeOrBuilder {
    private Builder() {
      super(GmpMeasurement.UserAttribute.DEFAULT_INSTANCE);
    }
    
    public Builder clearDoubleValue() {
      copyOnWrite();
      ((GmpMeasurement.UserAttribute)this.instance).clearDoubleValue();
      return this;
    }
    
    public Builder clearFloatValue() {
      copyOnWrite();
      ((GmpMeasurement.UserAttribute)this.instance).clearFloatValue();
      return this;
    }
    
    public Builder clearIntValue() {
      copyOnWrite();
      ((GmpMeasurement.UserAttribute)this.instance).clearIntValue();
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      ((GmpMeasurement.UserAttribute)this.instance).clearName();
      return this;
    }
    
    public Builder clearSetTimestampMillis() {
      copyOnWrite();
      ((GmpMeasurement.UserAttribute)this.instance).clearSetTimestampMillis();
      return this;
    }
    
    public Builder clearStringValue() {
      copyOnWrite();
      ((GmpMeasurement.UserAttribute)this.instance).clearStringValue();
      return this;
    }
    
    public double getDoubleValue() {
      return ((GmpMeasurement.UserAttribute)this.instance).getDoubleValue();
    }
    
    public float getFloatValue() {
      return ((GmpMeasurement.UserAttribute)this.instance).getFloatValue();
    }
    
    public long getIntValue() {
      return ((GmpMeasurement.UserAttribute)this.instance).getIntValue();
    }
    
    public String getName() {
      return ((GmpMeasurement.UserAttribute)this.instance).getName();
    }
    
    public ByteString getNameBytes() {
      return ((GmpMeasurement.UserAttribute)this.instance).getNameBytes();
    }
    
    public long getSetTimestampMillis() {
      return ((GmpMeasurement.UserAttribute)this.instance).getSetTimestampMillis();
    }
    
    public String getStringValue() {
      return ((GmpMeasurement.UserAttribute)this.instance).getStringValue();
    }
    
    public ByteString getStringValueBytes() {
      return ((GmpMeasurement.UserAttribute)this.instance).getStringValueBytes();
    }
    
    public boolean hasDoubleValue() {
      return ((GmpMeasurement.UserAttribute)this.instance).hasDoubleValue();
    }
    
    public boolean hasFloatValue() {
      return ((GmpMeasurement.UserAttribute)this.instance).hasFloatValue();
    }
    
    public boolean hasIntValue() {
      return ((GmpMeasurement.UserAttribute)this.instance).hasIntValue();
    }
    
    public boolean hasName() {
      return ((GmpMeasurement.UserAttribute)this.instance).hasName();
    }
    
    public boolean hasSetTimestampMillis() {
      return ((GmpMeasurement.UserAttribute)this.instance).hasSetTimestampMillis();
    }
    
    public boolean hasStringValue() {
      return ((GmpMeasurement.UserAttribute)this.instance).hasStringValue();
    }
    
    public Builder setDoubleValue(double param1Double) {
      copyOnWrite();
      ((GmpMeasurement.UserAttribute)this.instance).setDoubleValue(param1Double);
      return this;
    }
    
    public Builder setFloatValue(float param1Float) {
      copyOnWrite();
      ((GmpMeasurement.UserAttribute)this.instance).setFloatValue(param1Float);
      return this;
    }
    
    public Builder setIntValue(long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.UserAttribute)this.instance).setIntValue(param1Long);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      ((GmpMeasurement.UserAttribute)this.instance).setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurement.UserAttribute)this.instance).setNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setSetTimestampMillis(long param1Long) {
      copyOnWrite();
      ((GmpMeasurement.UserAttribute)this.instance).setSetTimestampMillis(param1Long);
      return this;
    }
    
    public Builder setStringValue(String param1String) {
      copyOnWrite();
      ((GmpMeasurement.UserAttribute)this.instance).setStringValue(param1String);
      return this;
    }
    
    public Builder setStringValueBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurement.UserAttribute)this.instance).setStringValueBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface UserAttributeOrBuilder extends MessageLiteOrBuilder {
    double getDoubleValue();
    
    float getFloatValue();
    
    long getIntValue();
    
    String getName();
    
    ByteString getNameBytes();
    
    long getSetTimestampMillis();
    
    String getStringValue();
    
    ByteString getStringValueBytes();
    
    boolean hasDoubleValue();
    
    boolean hasFloatValue();
    
    boolean hasIntValue();
    
    boolean hasName();
    
    boolean hasSetTimestampMillis();
    
    boolean hasStringValue();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\analytics_collection\GmpMeasurement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */