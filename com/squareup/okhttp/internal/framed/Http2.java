package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.Protocol;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

public final class Http2 implements Variant {
  private static final ByteString CONNECTION_PREFACE;
  
  static final byte FLAG_ACK = 1;
  
  static final byte FLAG_COMPRESSED = 32;
  
  static final byte FLAG_END_HEADERS = 4;
  
  static final byte FLAG_END_PUSH_PROMISE = 4;
  
  static final byte FLAG_END_STREAM = 1;
  
  static final byte FLAG_NONE = 0;
  
  static final byte FLAG_PADDED = 8;
  
  static final byte FLAG_PRIORITY = 32;
  
  static final int INITIAL_MAX_FRAME_SIZE = 16384;
  
  static final byte TYPE_CONTINUATION = 9;
  
  static final byte TYPE_DATA = 0;
  
  static final byte TYPE_GOAWAY = 7;
  
  static final byte TYPE_HEADERS = 1;
  
  static final byte TYPE_PING = 6;
  
  static final byte TYPE_PRIORITY = 2;
  
  static final byte TYPE_PUSH_PROMISE = 5;
  
  static final byte TYPE_RST_STREAM = 3;
  
  static final byte TYPE_SETTINGS = 4;
  
  static final byte TYPE_WINDOW_UPDATE = 8;
  
  private static final Logger logger = Logger.getLogger(FrameLogger.class.getName());
  
  static {
    CONNECTION_PREFACE = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
  }
  
  private static IllegalArgumentException illegalArgument(String paramString, Object... paramVarArgs) {
    throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
  }
  
  private static IOException ioException(String paramString, Object... paramVarArgs) throws IOException {
    throw new IOException(String.format(paramString, paramVarArgs));
  }
  
  private static int lengthWithoutPadding(int paramInt, byte paramByte, short paramShort) throws IOException {
    int i = paramInt;
    if ((paramByte & 0x8) != 0)
      i = paramInt - 1; 
    if (paramShort <= i)
      return (short)(i - paramShort); 
    throw ioException("PROTOCOL_ERROR padding %s > remaining length %s", new Object[] { Short.valueOf(paramShort), Integer.valueOf(i) });
  }
  
  private static int readMedium(BufferedSource paramBufferedSource) throws IOException {
    byte b1 = paramBufferedSource.readByte();
    byte b2 = paramBufferedSource.readByte();
    return paramBufferedSource.readByte() & 0xFF | (b1 & 0xFF) << 16 | (b2 & 0xFF) << 8;
  }
  
  private static void writeMedium(BufferedSink paramBufferedSink, int paramInt) throws IOException {
    paramBufferedSink.writeByte(paramInt >>> 16 & 0xFF);
    paramBufferedSink.writeByte(paramInt >>> 8 & 0xFF);
    paramBufferedSink.writeByte(paramInt & 0xFF);
  }
  
  public Protocol getProtocol() {
    return Protocol.HTTP_2;
  }
  
  public FrameReader newReader(BufferedSource paramBufferedSource, boolean paramBoolean) {
    return new Reader(paramBufferedSource, 4096, paramBoolean);
  }
  
  public FrameWriter newWriter(BufferedSink paramBufferedSink, boolean paramBoolean) {
    return new Writer(paramBufferedSink, paramBoolean);
  }
  
  static final class ContinuationSource implements Source {
    byte flags;
    
    int left;
    
    int length;
    
    short padding;
    
    private final BufferedSource source;
    
    int streamId;
    
    public ContinuationSource(BufferedSource param1BufferedSource) {
      this.source = param1BufferedSource;
    }
    
    private void readContinuationHeader() throws IOException {
      int i = this.streamId;
      int j = Http2.readMedium(this.source);
      this.left = j;
      this.length = j;
      byte b = (byte)(this.source.readByte() & 0xFF);
      this.flags = (byte)(byte)(this.source.readByte() & 0xFF);
      if (Http2.logger.isLoggable(Level.FINE))
        Http2.logger.fine(Http2.FrameLogger.formatHeader(true, this.streamId, this.length, b, this.flags)); 
      this.streamId = this.source.readInt() & Integer.MAX_VALUE;
      if (b == 9) {
        if (this.streamId == i)
          return; 
        throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
      } 
      throw Http2.ioException("%s != TYPE_CONTINUATION", new Object[] { Byte.valueOf(b) });
    }
    
    public void close() throws IOException {}
    
    public long read(Buffer param1Buffer, long param1Long) throws IOException {
      while (true) {
        int i = this.left;
        if (i == 0) {
          this.source.skip(this.padding);
          this.padding = (short)0;
          if ((this.flags & 0x4) != 0)
            return -1L; 
          readContinuationHeader();
          continue;
        } 
        param1Long = this.source.read(param1Buffer, Math.min(param1Long, i));
        if (param1Long == -1L)
          return -1L; 
        this.left = (int)(this.left - param1Long);
        return param1Long;
      } 
    }
    
    public Timeout timeout() {
      return this.source.timeout();
    }
  }
  
  static final class FrameLogger {
    private static final String[] BINARY;
    
    private static final String[] FLAGS = new String[64];
    
    private static final String[] TYPES = new String[] { "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION" };
    
    static {
      BINARY = new String[256];
      byte b = 0;
      while (true) {
        String[] arrayOfString1 = BINARY;
        if (b < arrayOfString1.length) {
          arrayOfString1[b] = String.format("%8s", new Object[] { Integer.toBinaryString(b) }).replace(' ', '0');
          b++;
          continue;
        } 
        String[] arrayOfString2 = FLAGS;
        arrayOfString2[0] = "";
        arrayOfString2[1] = "END_STREAM";
        int[] arrayOfInt1 = new int[1];
        arrayOfInt1[0] = 1;
        arrayOfString2[8] = "PADDED";
        int i = arrayOfInt1.length;
        for (b = 0; b < i; b++) {
          int k = arrayOfInt1[b];
          arrayOfString2 = FLAGS;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(FLAGS[k]);
          stringBuilder.append("|PADDED");
          arrayOfString2[k | 0x8] = stringBuilder.toString();
        } 
        arrayOfString2 = FLAGS;
        arrayOfString2[4] = "END_HEADERS";
        arrayOfString2[32] = "PRIORITY";
        arrayOfString2[36] = "END_HEADERS|PRIORITY";
        int[] arrayOfInt2 = new int[3];
        arrayOfInt2[0] = 4;
        arrayOfInt2[1] = 32;
        arrayOfInt2[2] = 36;
        int j = arrayOfInt2.length;
        b = 0;
        while (true) {
          i = bool;
          if (b < j) {
            int k = arrayOfInt2[b];
            int m = arrayOfInt1.length;
            for (i = 0; i < m; i++) {
              int n = arrayOfInt1[i];
              String[] arrayOfString = FLAGS;
              int i1 = n | k;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(FLAGS[n]);
              stringBuilder.append('|');
              stringBuilder.append(FLAGS[k]);
              arrayOfString[i1] = stringBuilder.toString();
              arrayOfString = FLAGS;
              stringBuilder = new StringBuilder();
              stringBuilder.append(FLAGS[n]);
              stringBuilder.append('|');
              stringBuilder.append(FLAGS[k]);
              stringBuilder.append("|PADDED");
              arrayOfString[i1 | 0x8] = stringBuilder.toString();
            } 
            b++;
            continue;
          } 
          break;
        } 
        while (true) {
          String[] arrayOfString = FLAGS;
          if (i < arrayOfString.length) {
            if (arrayOfString[i] == null)
              arrayOfString[i] = BINARY[i]; 
            i++;
            continue;
          } 
          break;
        } 
        return;
      } 
    }
    
    static String formatFlags(byte param1Byte1, byte param1Byte2) {
      // Byte code:
      //   0: iload_1
      //   1: ifne -> 7
      //   4: ldc ''
      //   6: areturn
      //   7: iload_0
      //   8: tableswitch default -> 52, 2 -> 88, 3 -> 88, 4 -> 69, 5 -> 52, 6 -> 69, 7 -> 88, 8 -> 88
      //   52: getstatic com/squareup/okhttp/internal/framed/Http2$FrameLogger.FLAGS : [Ljava/lang/String;
      //   55: astore_2
      //   56: iload_1
      //   57: aload_2
      //   58: arraylength
      //   59: if_icmpge -> 94
      //   62: aload_2
      //   63: iload_1
      //   64: aaload
      //   65: astore_2
      //   66: goto -> 100
      //   69: iload_1
      //   70: iconst_1
      //   71: if_icmpne -> 80
      //   74: ldc 'ACK'
      //   76: astore_2
      //   77: goto -> 86
      //   80: getstatic com/squareup/okhttp/internal/framed/Http2$FrameLogger.BINARY : [Ljava/lang/String;
      //   83: iload_1
      //   84: aaload
      //   85: astore_2
      //   86: aload_2
      //   87: areturn
      //   88: getstatic com/squareup/okhttp/internal/framed/Http2$FrameLogger.BINARY : [Ljava/lang/String;
      //   91: iload_1
      //   92: aaload
      //   93: areturn
      //   94: getstatic com/squareup/okhttp/internal/framed/Http2$FrameLogger.BINARY : [Ljava/lang/String;
      //   97: iload_1
      //   98: aaload
      //   99: astore_2
      //   100: iload_0
      //   101: iconst_5
      //   102: if_icmpne -> 120
      //   105: iload_1
      //   106: iconst_4
      //   107: iand
      //   108: ifeq -> 120
      //   111: aload_2
      //   112: ldc 'HEADERS'
      //   114: ldc 'PUSH_PROMISE'
      //   116: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      //   119: areturn
      //   120: iload_0
      //   121: ifne -> 140
      //   124: iload_1
      //   125: bipush #32
      //   127: iand
      //   128: ifeq -> 140
      //   131: aload_2
      //   132: ldc 'PRIORITY'
      //   134: ldc 'COMPRESSED'
      //   136: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      //   139: areturn
      //   140: aload_2
      //   141: areturn
    }
    
    static String formatHeader(boolean param1Boolean, int param1Int1, int param1Int2, byte param1Byte1, byte param1Byte2) {
      String str1;
      String str3;
      String[] arrayOfString = TYPES;
      if (param1Byte1 < arrayOfString.length) {
        str1 = arrayOfString[param1Byte1];
      } else {
        str1 = String.format("0x%02x", new Object[] { Byte.valueOf(param1Byte1) });
      } 
      String str2 = formatFlags(param1Byte1, param1Byte2);
      if (param1Boolean) {
        str3 = "<<";
      } else {
        str3 = ">>";
      } 
      return String.format("%s 0x%08x %5d %-13s %s", new Object[] { str3, Integer.valueOf(param1Int1), Integer.valueOf(param1Int2), str1, str2 });
    }
    
    static {
      boolean bool = false;
    }
  }
  
  static final class Reader implements FrameReader {
    private final boolean client;
    
    private final Http2.ContinuationSource continuation;
    
    final Hpack.Reader hpackReader;
    
    private final BufferedSource source;
    
    Reader(BufferedSource param1BufferedSource, int param1Int, boolean param1Boolean) {
      this.source = param1BufferedSource;
      this.client = param1Boolean;
      this.continuation = new Http2.ContinuationSource(this.source);
      this.hpackReader = new Hpack.Reader(param1Int, this.continuation);
    }
    
    private void readData(FrameReader.Handler param1Handler, int param1Int1, byte param1Byte, int param1Int2) throws IOException {
      boolean bool;
      short s1 = 1;
      short s2 = 0;
      if ((param1Byte & 0x1) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      if ((param1Byte & 0x20) == 0)
        s1 = 0; 
      if (!s1) {
        short s = s2;
        if ((param1Byte & 0x8) != 0) {
          s1 = (short)(this.source.readByte() & 0xFF);
          s = s1;
        } 
        param1Int1 = Http2.lengthWithoutPadding(param1Int1, param1Byte, s);
        param1Handler.data(bool, param1Int2, this.source, param1Int1);
        this.source.skip(s);
        return;
      } 
      throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
    }
    
    private void readGoAway(FrameReader.Handler param1Handler, int param1Int1, byte param1Byte, int param1Int2) throws IOException {
      if (param1Int1 >= 8) {
        if (param1Int2 == 0) {
          param1Int2 = this.source.readInt();
          int i = this.source.readInt();
          param1Int1 -= 8;
          ErrorCode errorCode = ErrorCode.fromHttp2(i);
          if (errorCode != null) {
            ByteString byteString = ByteString.EMPTY;
            if (param1Int1 > 0)
              byteString = this.source.readByteString(param1Int1); 
            param1Handler.goAway(param1Int2, errorCode, byteString);
            return;
          } 
          throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", new Object[] { Integer.valueOf(i) });
        } 
        throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
      } 
      throw Http2.ioException("TYPE_GOAWAY length < 8: %s", new Object[] { Integer.valueOf(param1Int1) });
    }
    
    private List<Header> readHeaderBlock(int param1Int1, short param1Short, byte param1Byte, int param1Int2) throws IOException {
      Http2.ContinuationSource continuationSource = this.continuation;
      continuationSource.left = param1Int1;
      continuationSource.length = param1Int1;
      continuationSource.padding = (short)param1Short;
      continuationSource.flags = (byte)param1Byte;
      continuationSource.streamId = param1Int2;
      this.hpackReader.readHeaders();
      return this.hpackReader.getAndResetHeaderList();
    }
    
    private void readHeaders(FrameReader.Handler param1Handler, int param1Int1, byte param1Byte, int param1Int2) throws IOException {
      int i = 0;
      if (param1Int2 != 0) {
        boolean bool;
        if ((param1Byte & 0x1) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        int j = i;
        if ((param1Byte & 0x8) != 0) {
          i = (short)(this.source.readByte() & 0xFF);
          j = i;
        } 
        i = param1Int1;
        if ((param1Byte & 0x20) != 0) {
          readPriority(param1Handler, param1Int2);
          i = param1Int1 - 5;
        } 
        param1Handler.headers(false, bool, param1Int2, -1, readHeaderBlock(Http2.lengthWithoutPadding(i, param1Byte, j), j, param1Byte, param1Int2), HeadersMode.HTTP_20_HEADERS);
        return;
      } 
      throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }
    
    private void readPing(FrameReader.Handler param1Handler, int param1Int1, byte param1Byte, int param1Int2) throws IOException {
      boolean bool = false;
      if (param1Int1 == 8) {
        if (param1Int2 == 0) {
          param1Int2 = this.source.readInt();
          param1Int1 = this.source.readInt();
          if ((param1Byte & 0x1) != 0)
            bool = true; 
          param1Handler.ping(bool, param1Int2, param1Int1);
          return;
        } 
        throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
      } 
      throw Http2.ioException("TYPE_PING length != 8: %s", new Object[] { Integer.valueOf(param1Int1) });
    }
    
    private void readPriority(FrameReader.Handler param1Handler, int param1Int) throws IOException {
      boolean bool;
      int i = this.source.readInt();
      if ((Integer.MIN_VALUE & i) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      param1Handler.priority(param1Int, i & Integer.MAX_VALUE, (this.source.readByte() & 0xFF) + 1, bool);
    }
    
    private void readPriority(FrameReader.Handler param1Handler, int param1Int1, byte param1Byte, int param1Int2) throws IOException {
      if (param1Int1 == 5) {
        if (param1Int2 != 0) {
          readPriority(param1Handler, param1Int2);
          return;
        } 
        throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
      } 
      throw Http2.ioException("TYPE_PRIORITY length: %d != 5", new Object[] { Integer.valueOf(param1Int1) });
    }
    
    private void readPushPromise(FrameReader.Handler param1Handler, int param1Int1, byte param1Byte, int param1Int2) throws IOException {
      short s = 0;
      if (param1Int2 != 0) {
        short s1 = s;
        if ((param1Byte & 0x8) != 0) {
          s = (short)(this.source.readByte() & 0xFF);
          s1 = s;
        } 
        param1Handler.pushPromise(param1Int2, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(Http2.lengthWithoutPadding(param1Int1 - 4, param1Byte, s1), s1, param1Byte, param1Int2));
        return;
      } 
      throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }
    
    private void readRstStream(FrameReader.Handler param1Handler, int param1Int1, byte param1Byte, int param1Int2) throws IOException {
      if (param1Int1 == 4) {
        if (param1Int2 != 0) {
          param1Int1 = this.source.readInt();
          ErrorCode errorCode = ErrorCode.fromHttp2(param1Int1);
          if (errorCode != null) {
            param1Handler.rstStream(param1Int2, errorCode);
            return;
          } 
          throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", new Object[] { Integer.valueOf(param1Int1) });
        } 
        throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
      } 
      throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", new Object[] { Integer.valueOf(param1Int1) });
    }
    
    private void readSettings(FrameReader.Handler param1Handler, int param1Int1, byte param1Byte, int param1Int2) throws IOException {
      if (param1Int2 == 0) {
        if ((param1Byte & 0x1) != 0) {
          if (param1Int1 == 0) {
            param1Handler.ackSettings();
            return;
          } 
          throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        } 
        if (param1Int1 % 6 == 0) {
          Settings settings = new Settings();
          for (param1Byte = 0; param1Byte < param1Int1; param1Byte += 6) {
            short s = this.source.readShort();
            int i = this.source.readInt();
            param1Int2 = s;
            switch (s) {
              default:
                throw Http2.ioException("PROTOCOL_ERROR invalid settings id: %s", new Object[] { Short.valueOf(s) });
              case 5:
                if (i >= 16384 && i <= 16777215) {
                  param1Int2 = s;
                  break;
                } 
                throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[] { Integer.valueOf(i) });
              case 4:
                param1Int2 = 7;
                if (i >= 0)
                  break; 
                throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
              case 3:
                param1Int2 = 4;
                break;
              case 2:
                param1Int2 = s;
                if (i != 0) {
                  if (i == 1) {
                    param1Int2 = s;
                    break;
                  } 
                  throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                } 
                break;
              case 1:
              case 6:
                break;
            } 
            settings.set(param1Int2, 0, i);
          } 
          param1Handler.settings(false, settings);
          if (settings.getHeaderTableSize() >= 0)
            this.hpackReader.headerTableSizeSetting(settings.getHeaderTableSize()); 
          return;
        } 
        throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", new Object[] { Integer.valueOf(param1Int1) });
      } 
      throw Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
    }
    
    private void readWindowUpdate(FrameReader.Handler param1Handler, int param1Int1, byte param1Byte, int param1Int2) throws IOException {
      if (param1Int1 == 4) {
        long l = this.source.readInt() & 0x7FFFFFFFL;
        if (l != 0L) {
          param1Handler.windowUpdate(param1Int2, l);
          return;
        } 
        throw Http2.ioException("windowSizeIncrement was 0", new Object[] { Long.valueOf(l) });
      } 
      throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", new Object[] { Integer.valueOf(param1Int1) });
    }
    
    public void close() throws IOException {
      this.source.close();
    }
    
    public boolean nextFrame(FrameReader.Handler param1Handler) throws IOException {
      try {
        this.source.require(9L);
        int i = Http2.readMedium(this.source);
        if (i >= 0 && i <= 16384) {
          byte b1 = (byte)(this.source.readByte() & 0xFF);
          byte b2 = (byte)(this.source.readByte() & 0xFF);
          int j = this.source.readInt() & Integer.MAX_VALUE;
          if (Http2.logger.isLoggable(Level.FINE))
            Http2.logger.fine(Http2.FrameLogger.formatHeader(true, j, i, b1, b2)); 
          switch (b1) {
            default:
              this.source.skip(i);
              return true;
            case 8:
              readWindowUpdate(param1Handler, i, b2, j);
              return true;
            case 7:
              readGoAway(param1Handler, i, b2, j);
              return true;
            case 6:
              readPing(param1Handler, i, b2, j);
              return true;
            case 5:
              readPushPromise(param1Handler, i, b2, j);
              return true;
            case 4:
              readSettings(param1Handler, i, b2, j);
              return true;
            case 3:
              readRstStream(param1Handler, i, b2, j);
              return true;
            case 2:
              readPriority(param1Handler, i, b2, j);
              return true;
            case 1:
              readHeaders(param1Handler, i, b2, j);
              return true;
            case 0:
              break;
          } 
          readData(param1Handler, i, b2, j);
          return true;
        } 
        throw Http2.ioException("FRAME_SIZE_ERROR: %s", new Object[] { Integer.valueOf(i) });
      } catch (IOException iOException) {
        return false;
      } 
    }
    
    public void readConnectionPreface() throws IOException {
      if (this.client)
        return; 
      ByteString byteString = this.source.readByteString(Http2.CONNECTION_PREFACE.size());
      if (Http2.logger.isLoggable(Level.FINE))
        Http2.logger.fine(String.format("<< CONNECTION %s", new Object[] { byteString.hex() })); 
      if (Http2.CONNECTION_PREFACE.equals(byteString))
        return; 
      throw Http2.ioException("Expected a connection header but was %s", new Object[] { byteString.utf8() });
    }
  }
  
  static final class Writer implements FrameWriter {
    private final boolean client;
    
    private boolean closed;
    
    private final Buffer hpackBuffer;
    
    private final Hpack.Writer hpackWriter;
    
    private int maxFrameSize;
    
    private final BufferedSink sink;
    
    Writer(BufferedSink param1BufferedSink, boolean param1Boolean) {
      this.sink = param1BufferedSink;
      this.client = param1Boolean;
      this.hpackBuffer = new Buffer();
      this.hpackWriter = new Hpack.Writer(this.hpackBuffer);
      this.maxFrameSize = 16384;
    }
    
    private void writeContinuationFrames(int param1Int, long param1Long) throws IOException {
      while (param1Long > 0L) {
        boolean bool;
        int i = (int)Math.min(this.maxFrameSize, param1Long);
        long l = i;
        param1Long -= l;
        if (param1Long == 0L) {
          byte b = 4;
          bool = b;
        } else {
          boolean bool1 = false;
          bool = bool1;
        } 
        frameHeader(param1Int, i, (byte)9, bool);
        this.sink.write(this.hpackBuffer, l);
      } 
    }
    
    public void ackSettings(Settings param1Settings) throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield closed : Z
      //   6: ifne -> 41
      //   9: aload_0
      //   10: aload_1
      //   11: aload_0
      //   12: getfield maxFrameSize : I
      //   15: invokevirtual getMaxFrameSize : (I)I
      //   18: putfield maxFrameSize : I
      //   21: aload_0
      //   22: iconst_0
      //   23: iconst_0
      //   24: iconst_4
      //   25: iconst_1
      //   26: invokevirtual frameHeader : (IIBB)V
      //   29: aload_0
      //   30: getfield sink : Lokio/BufferedSink;
      //   33: invokeinterface flush : ()V
      //   38: aload_0
      //   39: monitorexit
      //   40: return
      //   41: new java/io/IOException
      //   44: astore_1
      //   45: aload_1
      //   46: ldc 'closed'
      //   48: invokespecial <init> : (Ljava/lang/String;)V
      //   51: aload_1
      //   52: athrow
      //   53: astore_1
      //   54: aload_0
      //   55: monitorexit
      //   56: aload_1
      //   57: athrow
      // Exception table:
      //   from	to	target	type
      //   2	38	53	finally
      //   41	53	53	finally
    }
    
    public void close() throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iconst_1
      //   4: putfield closed : Z
      //   7: aload_0
      //   8: getfield sink : Lokio/BufferedSink;
      //   11: invokeinterface close : ()V
      //   16: aload_0
      //   17: monitorexit
      //   18: return
      //   19: astore_1
      //   20: aload_0
      //   21: monitorexit
      //   22: aload_1
      //   23: athrow
      // Exception table:
      //   from	to	target	type
      //   2	16	19	finally
    }
    
    public void connectionPreface() throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield closed : Z
      //   6: ifne -> 85
      //   9: aload_0
      //   10: getfield client : Z
      //   13: istore_1
      //   14: iload_1
      //   15: ifne -> 21
      //   18: aload_0
      //   19: monitorexit
      //   20: return
      //   21: invokestatic access$100 : ()Ljava/util/logging/Logger;
      //   24: getstatic java/util/logging/Level.FINE : Ljava/util/logging/Level;
      //   27: invokevirtual isLoggable : (Ljava/util/logging/Level;)Z
      //   30: ifeq -> 57
      //   33: invokestatic access$100 : ()Ljava/util/logging/Logger;
      //   36: ldc '>> CONNECTION %s'
      //   38: iconst_1
      //   39: anewarray java/lang/Object
      //   42: dup
      //   43: iconst_0
      //   44: invokestatic access$000 : ()Lokio/ByteString;
      //   47: invokevirtual hex : ()Ljava/lang/String;
      //   50: aastore
      //   51: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   54: invokevirtual fine : (Ljava/lang/String;)V
      //   57: aload_0
      //   58: getfield sink : Lokio/BufferedSink;
      //   61: invokestatic access$000 : ()Lokio/ByteString;
      //   64: invokevirtual toByteArray : ()[B
      //   67: invokeinterface write : ([B)Lokio/BufferedSink;
      //   72: pop
      //   73: aload_0
      //   74: getfield sink : Lokio/BufferedSink;
      //   77: invokeinterface flush : ()V
      //   82: aload_0
      //   83: monitorexit
      //   84: return
      //   85: new java/io/IOException
      //   88: astore_2
      //   89: aload_2
      //   90: ldc 'closed'
      //   92: invokespecial <init> : (Ljava/lang/String;)V
      //   95: aload_2
      //   96: athrow
      //   97: astore_2
      //   98: aload_0
      //   99: monitorexit
      //   100: aload_2
      //   101: athrow
      // Exception table:
      //   from	to	target	type
      //   2	14	97	finally
      //   21	57	97	finally
      //   57	82	97	finally
      //   85	97	97	finally
    }
    
    public void data(boolean param1Boolean, int param1Int1, Buffer param1Buffer, int param1Int2) throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield closed : Z
      //   6: ifne -> 41
      //   9: iconst_0
      //   10: istore #5
      //   12: iload #5
      //   14: istore #6
      //   16: iload_1
      //   17: ifeq -> 28
      //   20: iconst_1
      //   21: i2b
      //   22: istore #5
      //   24: iload #5
      //   26: istore #6
      //   28: aload_0
      //   29: iload_2
      //   30: iload #6
      //   32: aload_3
      //   33: iload #4
      //   35: invokevirtual dataFrame : (IBLokio/Buffer;I)V
      //   38: aload_0
      //   39: monitorexit
      //   40: return
      //   41: new java/io/IOException
      //   44: astore_3
      //   45: aload_3
      //   46: ldc 'closed'
      //   48: invokespecial <init> : (Ljava/lang/String;)V
      //   51: aload_3
      //   52: athrow
      //   53: astore_3
      //   54: aload_0
      //   55: monitorexit
      //   56: aload_3
      //   57: athrow
      // Exception table:
      //   from	to	target	type
      //   2	9	53	finally
      //   28	38	53	finally
      //   41	53	53	finally
    }
    
    void dataFrame(int param1Int1, byte param1Byte, Buffer param1Buffer, int param1Int2) throws IOException {
      frameHeader(param1Int1, param1Int2, (byte)0, param1Byte);
      if (param1Int2 > 0)
        this.sink.write(param1Buffer, param1Int2); 
    }
    
    public void flush() throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield closed : Z
      //   6: ifne -> 21
      //   9: aload_0
      //   10: getfield sink : Lokio/BufferedSink;
      //   13: invokeinterface flush : ()V
      //   18: aload_0
      //   19: monitorexit
      //   20: return
      //   21: new java/io/IOException
      //   24: astore_1
      //   25: aload_1
      //   26: ldc 'closed'
      //   28: invokespecial <init> : (Ljava/lang/String;)V
      //   31: aload_1
      //   32: athrow
      //   33: astore_1
      //   34: aload_0
      //   35: monitorexit
      //   36: aload_1
      //   37: athrow
      // Exception table:
      //   from	to	target	type
      //   2	18	33	finally
      //   21	33	33	finally
    }
    
    void frameHeader(int param1Int1, int param1Int2, byte param1Byte1, byte param1Byte2) throws IOException {
      if (Http2.logger.isLoggable(Level.FINE))
        Http2.logger.fine(Http2.FrameLogger.formatHeader(false, param1Int1, param1Int2, param1Byte1, param1Byte2)); 
      int i = this.maxFrameSize;
      if (param1Int2 <= i) {
        if ((Integer.MIN_VALUE & param1Int1) == 0) {
          Http2.writeMedium(this.sink, param1Int2);
          this.sink.writeByte(param1Byte1 & 0xFF);
          this.sink.writeByte(param1Byte2 & 0xFF);
          this.sink.writeInt(param1Int1 & Integer.MAX_VALUE);
          return;
        } 
        throw Http2.illegalArgument("reserved bit set: %s", new Object[] { Integer.valueOf(param1Int1) });
      } 
      throw Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(param1Int2) });
    }
    
    public void goAway(int param1Int, ErrorCode param1ErrorCode, byte[] param1ArrayOfbyte) throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield closed : Z
      //   6: ifne -> 93
      //   9: aload_2
      //   10: getfield httpCode : I
      //   13: iconst_m1
      //   14: if_icmpeq -> 83
      //   17: aload_0
      //   18: iconst_0
      //   19: aload_3
      //   20: arraylength
      //   21: bipush #8
      //   23: iadd
      //   24: bipush #7
      //   26: iconst_0
      //   27: invokevirtual frameHeader : (IIBB)V
      //   30: aload_0
      //   31: getfield sink : Lokio/BufferedSink;
      //   34: iload_1
      //   35: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   40: pop
      //   41: aload_0
      //   42: getfield sink : Lokio/BufferedSink;
      //   45: aload_2
      //   46: getfield httpCode : I
      //   49: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   54: pop
      //   55: aload_3
      //   56: arraylength
      //   57: ifle -> 71
      //   60: aload_0
      //   61: getfield sink : Lokio/BufferedSink;
      //   64: aload_3
      //   65: invokeinterface write : ([B)Lokio/BufferedSink;
      //   70: pop
      //   71: aload_0
      //   72: getfield sink : Lokio/BufferedSink;
      //   75: invokeinterface flush : ()V
      //   80: aload_0
      //   81: monitorexit
      //   82: return
      //   83: ldc 'errorCode.httpCode == -1'
      //   85: iconst_0
      //   86: anewarray java/lang/Object
      //   89: invokestatic access$500 : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/IllegalArgumentException;
      //   92: athrow
      //   93: new java/io/IOException
      //   96: astore_2
      //   97: aload_2
      //   98: ldc 'closed'
      //   100: invokespecial <init> : (Ljava/lang/String;)V
      //   103: aload_2
      //   104: athrow
      //   105: astore_2
      //   106: aload_0
      //   107: monitorexit
      //   108: aload_2
      //   109: athrow
      // Exception table:
      //   from	to	target	type
      //   2	71	105	finally
      //   71	80	105	finally
      //   83	93	105	finally
      //   93	105	105	finally
    }
    
    public void headers(int param1Int, List<Header> param1List) throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield closed : Z
      //   6: ifne -> 19
      //   9: aload_0
      //   10: iconst_0
      //   11: iload_1
      //   12: aload_2
      //   13: invokevirtual headers : (ZILjava/util/List;)V
      //   16: aload_0
      //   17: monitorexit
      //   18: return
      //   19: new java/io/IOException
      //   22: astore_2
      //   23: aload_2
      //   24: ldc 'closed'
      //   26: invokespecial <init> : (Ljava/lang/String;)V
      //   29: aload_2
      //   30: athrow
      //   31: astore_2
      //   32: aload_0
      //   33: monitorexit
      //   34: aload_2
      //   35: athrow
      // Exception table:
      //   from	to	target	type
      //   2	16	31	finally
      //   19	31	31	finally
    }
    
    void headers(boolean param1Boolean, int param1Int, List<Header> param1List) throws IOException {
      if (!this.closed) {
        byte b1;
        this.hpackWriter.writeHeaders(param1List);
        long l1 = this.hpackBuffer.size();
        int i = (int)Math.min(this.maxFrameSize, l1);
        long l2 = i;
        if (l1 == l2) {
          b1 = 4;
        } else {
          b1 = 0;
        } 
        byte b2 = b1;
        if (param1Boolean) {
          b1 = (byte)(b1 | 0x1);
          b2 = b1;
        } 
        frameHeader(param1Int, i, (byte)1, b2);
        this.sink.write(this.hpackBuffer, l2);
        if (l1 > l2)
          writeContinuationFrames(param1Int, l1 - l2); 
        return;
      } 
      throw new IOException("closed");
    }
    
    public int maxDataLength() {
      return this.maxFrameSize;
    }
    
    public void ping(boolean param1Boolean, int param1Int1, int param1Int2) throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield closed : Z
      //   6: ifne -> 75
      //   9: iload_1
      //   10: ifeq -> 23
      //   13: iconst_1
      //   14: istore #4
      //   16: iload #4
      //   18: istore #5
      //   20: goto -> 30
      //   23: iconst_0
      //   24: istore #4
      //   26: iload #4
      //   28: istore #5
      //   30: aload_0
      //   31: iconst_0
      //   32: bipush #8
      //   34: bipush #6
      //   36: iload #5
      //   38: invokevirtual frameHeader : (IIBB)V
      //   41: aload_0
      //   42: getfield sink : Lokio/BufferedSink;
      //   45: iload_2
      //   46: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   51: pop
      //   52: aload_0
      //   53: getfield sink : Lokio/BufferedSink;
      //   56: iload_3
      //   57: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   62: pop
      //   63: aload_0
      //   64: getfield sink : Lokio/BufferedSink;
      //   67: invokeinterface flush : ()V
      //   72: aload_0
      //   73: monitorexit
      //   74: return
      //   75: new java/io/IOException
      //   78: astore #6
      //   80: aload #6
      //   82: ldc 'closed'
      //   84: invokespecial <init> : (Ljava/lang/String;)V
      //   87: aload #6
      //   89: athrow
      //   90: astore #6
      //   92: aload_0
      //   93: monitorexit
      //   94: aload #6
      //   96: athrow
      // Exception table:
      //   from	to	target	type
      //   2	9	90	finally
      //   30	72	90	finally
      //   75	90	90	finally
    }
    
    public void pushPromise(int param1Int1, int param1Int2, List<Header> param1List) throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield closed : Z
      //   6: ifne -> 133
      //   9: aload_0
      //   10: getfield hpackWriter : Lcom/squareup/okhttp/internal/framed/Hpack$Writer;
      //   13: aload_3
      //   14: invokevirtual writeHeaders : (Ljava/util/List;)V
      //   17: aload_0
      //   18: getfield hpackBuffer : Lokio/Buffer;
      //   21: invokevirtual size : ()J
      //   24: lstore #4
      //   26: aload_0
      //   27: getfield maxFrameSize : I
      //   30: iconst_4
      //   31: isub
      //   32: i2l
      //   33: lload #4
      //   35: invokestatic min : (JJ)J
      //   38: l2i
      //   39: istore #6
      //   41: iload #6
      //   43: i2l
      //   44: lstore #7
      //   46: lload #4
      //   48: lload #7
      //   50: lcmp
      //   51: ifne -> 64
      //   54: iconst_4
      //   55: istore #9
      //   57: iload #9
      //   59: istore #10
      //   61: goto -> 71
      //   64: iconst_0
      //   65: istore #9
      //   67: iload #9
      //   69: istore #10
      //   71: aload_0
      //   72: iload_1
      //   73: iload #6
      //   75: iconst_4
      //   76: iadd
      //   77: iconst_5
      //   78: iload #10
      //   80: invokevirtual frameHeader : (IIBB)V
      //   83: aload_0
      //   84: getfield sink : Lokio/BufferedSink;
      //   87: iload_2
      //   88: ldc 2147483647
      //   90: iand
      //   91: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   96: pop
      //   97: aload_0
      //   98: getfield sink : Lokio/BufferedSink;
      //   101: aload_0
      //   102: getfield hpackBuffer : Lokio/Buffer;
      //   105: lload #7
      //   107: invokeinterface write : (Lokio/Buffer;J)V
      //   112: lload #4
      //   114: lload #7
      //   116: lcmp
      //   117: ifle -> 130
      //   120: aload_0
      //   121: iload_1
      //   122: lload #4
      //   124: lload #7
      //   126: lsub
      //   127: invokespecial writeContinuationFrames : (IJ)V
      //   130: aload_0
      //   131: monitorexit
      //   132: return
      //   133: new java/io/IOException
      //   136: astore_3
      //   137: aload_3
      //   138: ldc 'closed'
      //   140: invokespecial <init> : (Ljava/lang/String;)V
      //   143: aload_3
      //   144: athrow
      //   145: astore_3
      //   146: aload_0
      //   147: monitorexit
      //   148: aload_3
      //   149: athrow
      // Exception table:
      //   from	to	target	type
      //   2	41	145	finally
      //   71	112	145	finally
      //   120	130	145	finally
      //   133	145	145	finally
    }
    
    public void rstStream(int param1Int, ErrorCode param1ErrorCode) throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield closed : Z
      //   6: ifne -> 61
      //   9: aload_2
      //   10: getfield httpCode : I
      //   13: iconst_m1
      //   14: if_icmpeq -> 51
      //   17: aload_0
      //   18: iload_1
      //   19: iconst_4
      //   20: iconst_3
      //   21: iconst_0
      //   22: invokevirtual frameHeader : (IIBB)V
      //   25: aload_0
      //   26: getfield sink : Lokio/BufferedSink;
      //   29: aload_2
      //   30: getfield httpCode : I
      //   33: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   38: pop
      //   39: aload_0
      //   40: getfield sink : Lokio/BufferedSink;
      //   43: invokeinterface flush : ()V
      //   48: aload_0
      //   49: monitorexit
      //   50: return
      //   51: new java/lang/IllegalArgumentException
      //   54: astore_2
      //   55: aload_2
      //   56: invokespecial <init> : ()V
      //   59: aload_2
      //   60: athrow
      //   61: new java/io/IOException
      //   64: astore_2
      //   65: aload_2
      //   66: ldc 'closed'
      //   68: invokespecial <init> : (Ljava/lang/String;)V
      //   71: aload_2
      //   72: athrow
      //   73: astore_2
      //   74: aload_0
      //   75: monitorexit
      //   76: aload_2
      //   77: athrow
      // Exception table:
      //   from	to	target	type
      //   2	48	73	finally
      //   51	61	73	finally
      //   61	73	73	finally
    }
    
    public void settings(Settings param1Settings) throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield closed : Z
      //   6: ifne -> 111
      //   9: aload_1
      //   10: invokevirtual size : ()I
      //   13: istore_2
      //   14: iconst_0
      //   15: istore_3
      //   16: aload_0
      //   17: iconst_0
      //   18: iload_2
      //   19: bipush #6
      //   21: imul
      //   22: iconst_4
      //   23: iconst_0
      //   24: invokevirtual frameHeader : (IIBB)V
      //   27: iload_3
      //   28: bipush #10
      //   30: if_icmpge -> 99
      //   33: aload_1
      //   34: iload_3
      //   35: invokevirtual isSet : (I)Z
      //   38: ifne -> 44
      //   41: goto -> 93
      //   44: iload_3
      //   45: iconst_4
      //   46: if_icmpne -> 54
      //   49: iconst_3
      //   50: istore_2
      //   51: goto -> 67
      //   54: iload_3
      //   55: bipush #7
      //   57: if_icmpne -> 65
      //   60: iconst_4
      //   61: istore_2
      //   62: goto -> 67
      //   65: iload_3
      //   66: istore_2
      //   67: aload_0
      //   68: getfield sink : Lokio/BufferedSink;
      //   71: iload_2
      //   72: invokeinterface writeShort : (I)Lokio/BufferedSink;
      //   77: pop
      //   78: aload_0
      //   79: getfield sink : Lokio/BufferedSink;
      //   82: aload_1
      //   83: iload_3
      //   84: invokevirtual get : (I)I
      //   87: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   92: pop
      //   93: iinc #3, 1
      //   96: goto -> 27
      //   99: aload_0
      //   100: getfield sink : Lokio/BufferedSink;
      //   103: invokeinterface flush : ()V
      //   108: aload_0
      //   109: monitorexit
      //   110: return
      //   111: new java/io/IOException
      //   114: astore_1
      //   115: aload_1
      //   116: ldc 'closed'
      //   118: invokespecial <init> : (Ljava/lang/String;)V
      //   121: aload_1
      //   122: athrow
      //   123: astore_1
      //   124: aload_0
      //   125: monitorexit
      //   126: aload_1
      //   127: athrow
      // Exception table:
      //   from	to	target	type
      //   2	14	123	finally
      //   16	27	123	finally
      //   33	41	123	finally
      //   67	93	123	finally
      //   99	108	123	finally
      //   111	123	123	finally
    }
    
    public void synReply(boolean param1Boolean, int param1Int, List<Header> param1List) throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield closed : Z
      //   6: ifne -> 19
      //   9: aload_0
      //   10: iload_1
      //   11: iload_2
      //   12: aload_3
      //   13: invokevirtual headers : (ZILjava/util/List;)V
      //   16: aload_0
      //   17: monitorexit
      //   18: return
      //   19: new java/io/IOException
      //   22: astore_3
      //   23: aload_3
      //   24: ldc 'closed'
      //   26: invokespecial <init> : (Ljava/lang/String;)V
      //   29: aload_3
      //   30: athrow
      //   31: astore_3
      //   32: aload_0
      //   33: monitorexit
      //   34: aload_3
      //   35: athrow
      // Exception table:
      //   from	to	target	type
      //   2	16	31	finally
      //   19	31	31	finally
    }
    
    public void synStream(boolean param1Boolean1, boolean param1Boolean2, int param1Int1, int param1Int2, List<Header> param1List) throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: iload_2
      //   3: ifne -> 44
      //   6: aload_0
      //   7: getfield closed : Z
      //   10: ifne -> 24
      //   13: aload_0
      //   14: iload_1
      //   15: iload_3
      //   16: aload #5
      //   18: invokevirtual headers : (ZILjava/util/List;)V
      //   21: aload_0
      //   22: monitorexit
      //   23: return
      //   24: new java/io/IOException
      //   27: astore #5
      //   29: aload #5
      //   31: ldc 'closed'
      //   33: invokespecial <init> : (Ljava/lang/String;)V
      //   36: aload #5
      //   38: athrow
      //   39: astore #5
      //   41: goto -> 57
      //   44: new java/lang/UnsupportedOperationException
      //   47: astore #5
      //   49: aload #5
      //   51: invokespecial <init> : ()V
      //   54: aload #5
      //   56: athrow
      //   57: aload_0
      //   58: monitorexit
      //   59: aload #5
      //   61: athrow
      // Exception table:
      //   from	to	target	type
      //   6	21	39	finally
      //   24	39	39	finally
      //   44	57	39	finally
    }
    
    public void windowUpdate(int param1Int, long param1Long) throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield closed : Z
      //   6: ifne -> 73
      //   9: lload_2
      //   10: lconst_0
      //   11: lcmp
      //   12: ifeq -> 56
      //   15: lload_2
      //   16: ldc2_w 2147483647
      //   19: lcmp
      //   20: ifgt -> 56
      //   23: aload_0
      //   24: iload_1
      //   25: iconst_4
      //   26: bipush #8
      //   28: iconst_0
      //   29: invokevirtual frameHeader : (IIBB)V
      //   32: aload_0
      //   33: getfield sink : Lokio/BufferedSink;
      //   36: lload_2
      //   37: l2i
      //   38: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   43: pop
      //   44: aload_0
      //   45: getfield sink : Lokio/BufferedSink;
      //   48: invokeinterface flush : ()V
      //   53: aload_0
      //   54: monitorexit
      //   55: return
      //   56: ldc 'windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s'
      //   58: iconst_1
      //   59: anewarray java/lang/Object
      //   62: dup
      //   63: iconst_0
      //   64: lload_2
      //   65: invokestatic valueOf : (J)Ljava/lang/Long;
      //   68: aastore
      //   69: invokestatic access$500 : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/IllegalArgumentException;
      //   72: athrow
      //   73: new java/io/IOException
      //   76: astore #4
      //   78: aload #4
      //   80: ldc 'closed'
      //   82: invokespecial <init> : (Ljava/lang/String;)V
      //   85: aload #4
      //   87: athrow
      //   88: astore #4
      //   90: aload_0
      //   91: monitorexit
      //   92: aload #4
      //   94: athrow
      // Exception table:
      //   from	to	target	type
      //   2	9	88	finally
      //   23	53	88	finally
      //   56	73	88	finally
      //   73	88	88	finally
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\okhttp\internal\framed\Http2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */