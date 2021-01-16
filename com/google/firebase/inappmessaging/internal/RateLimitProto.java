package com.google.firebase.inappmessaging.internal;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

public final class RateLimitProto {
  static {
  
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class Counter extends GeneratedMessageLite<Counter, Counter.Builder> implements CounterOrBuilder {
    private static final Counter DEFAULT_INSTANCE = new Counter();
    
    private static volatile Parser<Counter> PARSER;
    
    public static final int START_TIME_EPOCH_FIELD_NUMBER = 2;
    
    public static final int VALUE_FIELD_NUMBER = 1;
    
    private long startTimeEpoch_;
    
    private long value_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearStartTimeEpoch() {
      this.startTimeEpoch_ = 0L;
    }
    
    private void clearValue() {
      this.value_ = 0L;
    }
    
    public static Counter getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Counter param1Counter) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1Counter);
    }
    
    public static Counter parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Counter)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Counter parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Counter)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Counter parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Counter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static Counter parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Counter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Counter parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Counter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static Counter parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Counter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Counter parseFrom(InputStream param1InputStream) throws IOException {
      return (Counter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Counter parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Counter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Counter parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Counter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static Counter parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Counter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Counter> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setStartTimeEpoch(long param1Long) {
      this.startTimeEpoch_ = param1Long;
    }
    
    private void setValue(long param1Long) {
      this.value_ = param1Long;
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firebase/inappmessaging/internal/RateLimitProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: istore #4
      //   10: iconst_0
      //   11: istore #5
      //   13: iload #4
      //   15: tableswitch default -> 60, 1 -> 406, 2 -> 402, 3 -> 400, 4 -> 391, 5 -> 251, 6 -> 114, 7 -> 247, 8 -> 68
      //   60: new java/lang/UnsupportedOperationException
      //   63: dup
      //   64: invokespecial <init> : ()V
      //   67: athrow
      //   68: getstatic com/google/firebase/inappmessaging/internal/RateLimitProto$Counter.PARSER : Lcom/google/protobuf/Parser;
      //   71: ifnonnull -> 110
      //   74: ldc com/google/firebase/inappmessaging/internal/RateLimitProto$Counter
      //   76: monitorenter
      //   77: getstatic com/google/firebase/inappmessaging/internal/RateLimitProto$Counter.PARSER : Lcom/google/protobuf/Parser;
      //   80: ifnonnull -> 98
      //   83: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   86: astore_1
      //   87: aload_1
      //   88: getstatic com/google/firebase/inappmessaging/internal/RateLimitProto$Counter.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/internal/RateLimitProto$Counter;
      //   91: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   94: aload_1
      //   95: putstatic com/google/firebase/inappmessaging/internal/RateLimitProto$Counter.PARSER : Lcom/google/protobuf/Parser;
      //   98: ldc com/google/firebase/inappmessaging/internal/RateLimitProto$Counter
      //   100: monitorexit
      //   101: goto -> 110
      //   104: astore_1
      //   105: ldc com/google/firebase/inappmessaging/internal/RateLimitProto$Counter
      //   107: monitorexit
      //   108: aload_1
      //   109: athrow
      //   110: getstatic com/google/firebase/inappmessaging/internal/RateLimitProto$Counter.PARSER : Lcom/google/protobuf/Parser;
      //   113: areturn
      //   114: aload_2
      //   115: checkcast com/google/protobuf/CodedInputStream
      //   118: astore_1
      //   119: aload_3
      //   120: checkcast com/google/protobuf/ExtensionRegistryLite
      //   123: astore_2
      //   124: iload #5
      //   126: ifne -> 247
      //   129: aload_1
      //   130: invokevirtual readTag : ()I
      //   133: istore #4
      //   135: iload #4
      //   137: ifeq -> 191
      //   140: iload #4
      //   142: bipush #8
      //   144: if_icmpeq -> 180
      //   147: iload #4
      //   149: bipush #16
      //   151: if_icmpeq -> 169
      //   154: aload_1
      //   155: iload #4
      //   157: invokevirtual skipField : (I)Z
      //   160: ifne -> 124
      //   163: iconst_1
      //   164: istore #5
      //   166: goto -> 124
      //   169: aload_0
      //   170: aload_1
      //   171: invokevirtual readInt64 : ()J
      //   174: putfield startTimeEpoch_ : J
      //   177: goto -> 124
      //   180: aload_0
      //   181: aload_1
      //   182: invokevirtual readInt64 : ()J
      //   185: putfield value_ : J
      //   188: goto -> 124
      //   191: iconst_1
      //   192: istore #5
      //   194: goto -> 124
      //   197: astore_1
      //   198: goto -> 245
      //   201: astore_3
      //   202: new java/lang/RuntimeException
      //   205: astore_2
      //   206: new com/google/protobuf/InvalidProtocolBufferException
      //   209: astore_1
      //   210: aload_1
      //   211: aload_3
      //   212: invokevirtual getMessage : ()Ljava/lang/String;
      //   215: invokespecial <init> : (Ljava/lang/String;)V
      //   218: aload_2
      //   219: aload_1
      //   220: aload_0
      //   221: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   224: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   227: aload_2
      //   228: athrow
      //   229: astore_1
      //   230: new java/lang/RuntimeException
      //   233: astore_2
      //   234: aload_2
      //   235: aload_1
      //   236: aload_0
      //   237: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   240: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   243: aload_2
      //   244: athrow
      //   245: aload_1
      //   246: athrow
      //   247: getstatic com/google/firebase/inappmessaging/internal/RateLimitProto$Counter.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/internal/RateLimitProto$Counter;
      //   250: areturn
      //   251: aload_2
      //   252: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   255: astore_1
      //   256: aload_3
      //   257: checkcast com/google/firebase/inappmessaging/internal/RateLimitProto$Counter
      //   260: astore_2
      //   261: aload_0
      //   262: getfield value_ : J
      //   265: lconst_0
      //   266: lcmp
      //   267: ifeq -> 276
      //   270: iconst_1
      //   271: istore #6
      //   273: goto -> 279
      //   276: iconst_0
      //   277: istore #6
      //   279: aload_0
      //   280: getfield value_ : J
      //   283: lstore #7
      //   285: aload_2
      //   286: getfield value_ : J
      //   289: lconst_0
      //   290: lcmp
      //   291: ifeq -> 300
      //   294: iconst_1
      //   295: istore #9
      //   297: goto -> 303
      //   300: iconst_0
      //   301: istore #9
      //   303: aload_0
      //   304: aload_1
      //   305: iload #6
      //   307: lload #7
      //   309: iload #9
      //   311: aload_2
      //   312: getfield value_ : J
      //   315: invokeinterface visitLong : (ZJZJ)J
      //   320: putfield value_ : J
      //   323: aload_0
      //   324: getfield startTimeEpoch_ : J
      //   327: lconst_0
      //   328: lcmp
      //   329: ifeq -> 338
      //   332: iconst_1
      //   333: istore #6
      //   335: goto -> 341
      //   338: iconst_0
      //   339: istore #6
      //   341: aload_0
      //   342: getfield startTimeEpoch_ : J
      //   345: lstore #7
      //   347: aload_2
      //   348: getfield startTimeEpoch_ : J
      //   351: lconst_0
      //   352: lcmp
      //   353: ifeq -> 362
      //   356: iconst_1
      //   357: istore #9
      //   359: goto -> 365
      //   362: iconst_0
      //   363: istore #9
      //   365: aload_0
      //   366: aload_1
      //   367: iload #6
      //   369: lload #7
      //   371: iload #9
      //   373: aload_2
      //   374: getfield startTimeEpoch_ : J
      //   377: invokeinterface visitLong : (ZJZJ)J
      //   382: putfield startTimeEpoch_ : J
      //   385: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   388: astore_1
      //   389: aload_0
      //   390: areturn
      //   391: new com/google/firebase/inappmessaging/internal/RateLimitProto$Counter$Builder
      //   394: dup
      //   395: aconst_null
      //   396: invokespecial <init> : (Lcom/google/firebase/inappmessaging/internal/RateLimitProto$1;)V
      //   399: areturn
      //   400: aconst_null
      //   401: areturn
      //   402: getstatic com/google/firebase/inappmessaging/internal/RateLimitProto$Counter.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/internal/RateLimitProto$Counter;
      //   405: areturn
      //   406: new com/google/firebase/inappmessaging/internal/RateLimitProto$Counter
      //   409: dup
      //   410: invokespecial <init> : ()V
      //   413: areturn
      // Exception table:
      //   from	to	target	type
      //   77	98	104	finally
      //   98	101	104	finally
      //   105	108	104	finally
      //   129	135	229	com/google/protobuf/InvalidProtocolBufferException
      //   129	135	201	java/io/IOException
      //   129	135	197	finally
      //   154	163	229	com/google/protobuf/InvalidProtocolBufferException
      //   154	163	201	java/io/IOException
      //   154	163	197	finally
      //   169	177	229	com/google/protobuf/InvalidProtocolBufferException
      //   169	177	201	java/io/IOException
      //   169	177	197	finally
      //   180	188	229	com/google/protobuf/InvalidProtocolBufferException
      //   180	188	201	java/io/IOException
      //   180	188	197	finally
      //   202	229	197	finally
      //   230	245	197	finally
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      long l = this.value_;
      if (l != 0L)
        i = 0 + CodedOutputStream.computeInt64Size(1, l); 
      l = this.startTimeEpoch_;
      int j = i;
      if (l != 0L)
        j = i + CodedOutputStream.computeInt64Size(2, l); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public long getStartTimeEpoch() {
      return this.startTimeEpoch_;
    }
    
    public long getValue() {
      return this.value_;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      long l = this.value_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(1, l); 
      l = this.startTimeEpoch_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(2, l); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Counter, Builder> implements RateLimitProto.CounterOrBuilder {
      private Builder() {
        super(RateLimitProto.Counter.DEFAULT_INSTANCE);
      }
      
      public Builder clearStartTimeEpoch() {
        copyOnWrite();
        ((RateLimitProto.Counter)this.instance).clearStartTimeEpoch();
        return this;
      }
      
      public Builder clearValue() {
        copyOnWrite();
        ((RateLimitProto.Counter)this.instance).clearValue();
        return this;
      }
      
      public long getStartTimeEpoch() {
        return ((RateLimitProto.Counter)this.instance).getStartTimeEpoch();
      }
      
      public long getValue() {
        return ((RateLimitProto.Counter)this.instance).getValue();
      }
      
      public Builder setStartTimeEpoch(long param2Long) {
        copyOnWrite();
        ((RateLimitProto.Counter)this.instance).setStartTimeEpoch(param2Long);
        return this;
      }
      
      public Builder setValue(long param2Long) {
        copyOnWrite();
        ((RateLimitProto.Counter)this.instance).setValue(param2Long);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Counter, Counter.Builder> implements CounterOrBuilder {
    private Builder() {
      super(RateLimitProto.Counter.DEFAULT_INSTANCE);
    }
    
    public Builder clearStartTimeEpoch() {
      copyOnWrite();
      ((RateLimitProto.Counter)this.instance).clearStartTimeEpoch();
      return this;
    }
    
    public Builder clearValue() {
      copyOnWrite();
      ((RateLimitProto.Counter)this.instance).clearValue();
      return this;
    }
    
    public long getStartTimeEpoch() {
      return ((RateLimitProto.Counter)this.instance).getStartTimeEpoch();
    }
    
    public long getValue() {
      return ((RateLimitProto.Counter)this.instance).getValue();
    }
    
    public Builder setStartTimeEpoch(long param1Long) {
      copyOnWrite();
      ((RateLimitProto.Counter)this.instance).setStartTimeEpoch(param1Long);
      return this;
    }
    
    public Builder setValue(long param1Long) {
      copyOnWrite();
      ((RateLimitProto.Counter)this.instance).setValue(param1Long);
      return this;
    }
  }
  
  public static interface CounterOrBuilder extends MessageLiteOrBuilder {
    long getStartTimeEpoch();
    
    long getValue();
  }
  
  public static final class RateLimit extends GeneratedMessageLite<RateLimit, RateLimit.Builder> implements RateLimitOrBuilder {
    private static final RateLimit DEFAULT_INSTANCE = new RateLimit();
    
    public static final int LIMITS_FIELD_NUMBER = 1;
    
    private static volatile Parser<RateLimit> PARSER;
    
    private MapFieldLite<String, RateLimitProto.Counter> limits_ = MapFieldLite.emptyMapField();
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    public static RateLimit getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private Map<String, RateLimitProto.Counter> getMutableLimitsMap() {
      return (Map<String, RateLimitProto.Counter>)internalGetMutableLimits();
    }
    
    private MapFieldLite<String, RateLimitProto.Counter> internalGetLimits() {
      return this.limits_;
    }
    
    private MapFieldLite<String, RateLimitProto.Counter> internalGetMutableLimits() {
      if (!this.limits_.isMutable())
        this.limits_ = this.limits_.mutableCopy(); 
      return this.limits_;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(RateLimit param1RateLimit) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1RateLimit);
    }
    
    public static RateLimit parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (RateLimit)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static RateLimit parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (RateLimit)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static RateLimit parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (RateLimit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static RateLimit parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (RateLimit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static RateLimit parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (RateLimit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static RateLimit parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (RateLimit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static RateLimit parseFrom(InputStream param1InputStream) throws IOException {
      return (RateLimit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static RateLimit parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (RateLimit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static RateLimit parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (RateLimit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static RateLimit parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (RateLimit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<RateLimit> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    public boolean containsLimits(String param1String) {
      if (param1String != null)
        return internalGetLimits().containsKey(param1String); 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firebase/inappmessaging/internal/RateLimitProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 313, 2 -> 309, 3 -> 300, 4 -> 291, 5 -> 257, 6 -> 110, 7 -> 253, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/firebase/inappmessaging/internal/RateLimitProto$RateLimit.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/firebase/inappmessaging/internal/RateLimitProto$RateLimit
      //   72: monitorenter
      //   73: getstatic com/google/firebase/inappmessaging/internal/RateLimitProto$RateLimit.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/firebase/inappmessaging/internal/RateLimitProto$RateLimit.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/internal/RateLimitProto$RateLimit;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/firebase/inappmessaging/internal/RateLimitProto$RateLimit.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/firebase/inappmessaging/internal/RateLimitProto$RateLimit
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/firebase/inappmessaging/internal/RateLimitProto$RateLimit
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/firebase/inappmessaging/internal/RateLimitProto$RateLimit.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 253
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 197
      //   139: iload #5
      //   141: bipush #10
      //   143: if_icmpeq -> 161
      //   146: aload_1
      //   147: iload #5
      //   149: invokevirtual skipField : (I)Z
      //   152: ifne -> 123
      //   155: iconst_1
      //   156: istore #4
      //   158: goto -> 123
      //   161: aload_0
      //   162: getfield limits_ : Lcom/google/protobuf/MapFieldLite;
      //   165: invokevirtual isMutable : ()Z
      //   168: ifne -> 182
      //   171: aload_0
      //   172: aload_0
      //   173: getfield limits_ : Lcom/google/protobuf/MapFieldLite;
      //   176: invokevirtual mutableCopy : ()Lcom/google/protobuf/MapFieldLite;
      //   179: putfield limits_ : Lcom/google/protobuf/MapFieldLite;
      //   182: getstatic com/google/firebase/inappmessaging/internal/RateLimitProto$RateLimit$LimitsDefaultEntryHolder.defaultEntry : Lcom/google/protobuf/MapEntryLite;
      //   185: aload_0
      //   186: getfield limits_ : Lcom/google/protobuf/MapFieldLite;
      //   189: aload_1
      //   190: aload_2
      //   191: invokevirtual parseInto : (Lcom/google/protobuf/MapFieldLite;Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)V
      //   194: goto -> 123
      //   197: iconst_1
      //   198: istore #4
      //   200: goto -> 123
      //   203: astore_1
      //   204: goto -> 251
      //   207: astore_1
      //   208: new java/lang/RuntimeException
      //   211: astore_3
      //   212: new com/google/protobuf/InvalidProtocolBufferException
      //   215: astore_2
      //   216: aload_2
      //   217: aload_1
      //   218: invokevirtual getMessage : ()Ljava/lang/String;
      //   221: invokespecial <init> : (Ljava/lang/String;)V
      //   224: aload_3
      //   225: aload_2
      //   226: aload_0
      //   227: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   230: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   233: aload_3
      //   234: athrow
      //   235: astore_1
      //   236: new java/lang/RuntimeException
      //   239: astore_2
      //   240: aload_2
      //   241: aload_1
      //   242: aload_0
      //   243: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   246: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   249: aload_2
      //   250: athrow
      //   251: aload_1
      //   252: athrow
      //   253: getstatic com/google/firebase/inappmessaging/internal/RateLimitProto$RateLimit.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/internal/RateLimitProto$RateLimit;
      //   256: areturn
      //   257: aload_2
      //   258: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   261: astore_1
      //   262: aload_3
      //   263: checkcast com/google/firebase/inappmessaging/internal/RateLimitProto$RateLimit
      //   266: astore_2
      //   267: aload_0
      //   268: aload_1
      //   269: aload_0
      //   270: getfield limits_ : Lcom/google/protobuf/MapFieldLite;
      //   273: aload_2
      //   274: invokespecial internalGetLimits : ()Lcom/google/protobuf/MapFieldLite;
      //   277: invokeinterface visitMap : (Lcom/google/protobuf/MapFieldLite;Lcom/google/protobuf/MapFieldLite;)Lcom/google/protobuf/MapFieldLite;
      //   282: putfield limits_ : Lcom/google/protobuf/MapFieldLite;
      //   285: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   288: astore_1
      //   289: aload_0
      //   290: areturn
      //   291: new com/google/firebase/inappmessaging/internal/RateLimitProto$RateLimit$Builder
      //   294: dup
      //   295: aconst_null
      //   296: invokespecial <init> : (Lcom/google/firebase/inappmessaging/internal/RateLimitProto$1;)V
      //   299: areturn
      //   300: aload_0
      //   301: getfield limits_ : Lcom/google/protobuf/MapFieldLite;
      //   304: invokevirtual makeImmutable : ()V
      //   307: aconst_null
      //   308: areturn
      //   309: getstatic com/google/firebase/inappmessaging/internal/RateLimitProto$RateLimit.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/internal/RateLimitProto$RateLimit;
      //   312: areturn
      //   313: new com/google/firebase/inappmessaging/internal/RateLimitProto$RateLimit
      //   316: dup
      //   317: invokespecial <init> : ()V
      //   320: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	235	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	207	java/io/IOException
      //   128	134	203	finally
      //   146	155	235	com/google/protobuf/InvalidProtocolBufferException
      //   146	155	207	java/io/IOException
      //   146	155	203	finally
      //   161	182	235	com/google/protobuf/InvalidProtocolBufferException
      //   161	182	207	java/io/IOException
      //   161	182	203	finally
      //   182	194	235	com/google/protobuf/InvalidProtocolBufferException
      //   182	194	207	java/io/IOException
      //   182	194	203	finally
      //   208	235	203	finally
      //   236	251	203	finally
    }
    
    @Deprecated
    public Map<String, RateLimitProto.Counter> getLimits() {
      return getLimitsMap();
    }
    
    public int getLimitsCount() {
      return internalGetLimits().size();
    }
    
    public Map<String, RateLimitProto.Counter> getLimitsMap() {
      return Collections.unmodifiableMap((Map<? extends String, ? extends RateLimitProto.Counter>)internalGetLimits());
    }
    
    public RateLimitProto.Counter getLimitsOrDefault(String param1String, RateLimitProto.Counter param1Counter) {
      if (param1String != null) {
        MapFieldLite<String, RateLimitProto.Counter> mapFieldLite = internalGetLimits();
        if (mapFieldLite.containsKey(param1String))
          param1Counter = mapFieldLite.get(param1String); 
        return param1Counter;
      } 
      throw new NullPointerException();
    }
    
    public RateLimitProto.Counter getLimitsOrThrow(String param1String) {
      if (param1String != null) {
        MapFieldLite<String, RateLimitProto.Counter> mapFieldLite = internalGetLimits();
        if (mapFieldLite.containsKey(param1String))
          return mapFieldLite.get(param1String); 
        throw new IllegalArgumentException();
      } 
      throw new NullPointerException();
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      for (Map.Entry entry : internalGetLimits().entrySet())
        i += LimitsDefaultEntryHolder.defaultEntry.computeMessageSize(1, entry.getKey(), entry.getValue()); 
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      for (Map.Entry entry : internalGetLimits().entrySet())
        LimitsDefaultEntryHolder.defaultEntry.serializeTo(param1CodedOutputStream, 1, entry.getKey(), entry.getValue()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<RateLimit, Builder> implements RateLimitProto.RateLimitOrBuilder {
      private Builder() {
        super(RateLimitProto.RateLimit.DEFAULT_INSTANCE);
      }
      
      public Builder clearLimits() {
        copyOnWrite();
        ((RateLimitProto.RateLimit)this.instance).getMutableLimitsMap().clear();
        return this;
      }
      
      public boolean containsLimits(String param2String) {
        if (param2String != null)
          return ((RateLimitProto.RateLimit)this.instance).getLimitsMap().containsKey(param2String); 
        throw new NullPointerException();
      }
      
      @Deprecated
      public Map<String, RateLimitProto.Counter> getLimits() {
        return getLimitsMap();
      }
      
      public int getLimitsCount() {
        return ((RateLimitProto.RateLimit)this.instance).getLimitsMap().size();
      }
      
      public Map<String, RateLimitProto.Counter> getLimitsMap() {
        return Collections.unmodifiableMap(((RateLimitProto.RateLimit)this.instance).getLimitsMap());
      }
      
      public RateLimitProto.Counter getLimitsOrDefault(String param2String, RateLimitProto.Counter param2Counter) {
        if (param2String != null) {
          Map<String, RateLimitProto.Counter> map = ((RateLimitProto.RateLimit)this.instance).getLimitsMap();
          if (map.containsKey(param2String))
            param2Counter = map.get(param2String); 
          return param2Counter;
        } 
        throw new NullPointerException();
      }
      
      public RateLimitProto.Counter getLimitsOrThrow(String param2String) {
        if (param2String != null) {
          Map<String, RateLimitProto.Counter> map = ((RateLimitProto.RateLimit)this.instance).getLimitsMap();
          if (map.containsKey(param2String))
            return map.get(param2String); 
          throw new IllegalArgumentException();
        } 
        throw new NullPointerException();
      }
      
      public Builder putAllLimits(Map<String, RateLimitProto.Counter> param2Map) {
        copyOnWrite();
        ((RateLimitProto.RateLimit)this.instance).getMutableLimitsMap().putAll(param2Map);
        return this;
      }
      
      public Builder putLimits(String param2String, RateLimitProto.Counter param2Counter) {
        if (param2String != null) {
          if (param2Counter != null) {
            copyOnWrite();
            ((RateLimitProto.RateLimit)this.instance).getMutableLimitsMap().put(param2String, param2Counter);
            return this;
          } 
          throw new NullPointerException();
        } 
        throw new NullPointerException();
      }
      
      public Builder removeLimits(String param2String) {
        if (param2String != null) {
          copyOnWrite();
          ((RateLimitProto.RateLimit)this.instance).getMutableLimitsMap().remove(param2String);
          return this;
        } 
        throw new NullPointerException();
      }
    }
    
    private static final class LimitsDefaultEntryHolder {
      static final MapEntryLite<String, RateLimitProto.Counter> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, RateLimitProto.Counter.getDefaultInstance());
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<RateLimit, RateLimit.Builder> implements RateLimitOrBuilder {
    private Builder() {
      super(RateLimitProto.RateLimit.DEFAULT_INSTANCE);
    }
    
    public Builder clearLimits() {
      copyOnWrite();
      ((RateLimitProto.RateLimit)this.instance).getMutableLimitsMap().clear();
      return this;
    }
    
    public boolean containsLimits(String param1String) {
      if (param1String != null)
        return ((RateLimitProto.RateLimit)this.instance).getLimitsMap().containsKey(param1String); 
      throw new NullPointerException();
    }
    
    @Deprecated
    public Map<String, RateLimitProto.Counter> getLimits() {
      return getLimitsMap();
    }
    
    public int getLimitsCount() {
      return ((RateLimitProto.RateLimit)this.instance).getLimitsMap().size();
    }
    
    public Map<String, RateLimitProto.Counter> getLimitsMap() {
      return Collections.unmodifiableMap(((RateLimitProto.RateLimit)this.instance).getLimitsMap());
    }
    
    public RateLimitProto.Counter getLimitsOrDefault(String param1String, RateLimitProto.Counter param1Counter) {
      if (param1String != null) {
        Map<String, RateLimitProto.Counter> map = ((RateLimitProto.RateLimit)this.instance).getLimitsMap();
        if (map.containsKey(param1String))
          param1Counter = map.get(param1String); 
        return param1Counter;
      } 
      throw new NullPointerException();
    }
    
    public RateLimitProto.Counter getLimitsOrThrow(String param1String) {
      if (param1String != null) {
        Map<String, RateLimitProto.Counter> map = ((RateLimitProto.RateLimit)this.instance).getLimitsMap();
        if (map.containsKey(param1String))
          return map.get(param1String); 
        throw new IllegalArgumentException();
      } 
      throw new NullPointerException();
    }
    
    public Builder putAllLimits(Map<String, RateLimitProto.Counter> param1Map) {
      copyOnWrite();
      ((RateLimitProto.RateLimit)this.instance).getMutableLimitsMap().putAll(param1Map);
      return this;
    }
    
    public Builder putLimits(String param1String, RateLimitProto.Counter param1Counter) {
      if (param1String != null) {
        if (param1Counter != null) {
          copyOnWrite();
          ((RateLimitProto.RateLimit)this.instance).getMutableLimitsMap().put(param1String, param1Counter);
          return this;
        } 
        throw new NullPointerException();
      } 
      throw new NullPointerException();
    }
    
    public Builder removeLimits(String param1String) {
      if (param1String != null) {
        copyOnWrite();
        ((RateLimitProto.RateLimit)this.instance).getMutableLimitsMap().remove(param1String);
        return this;
      } 
      throw new NullPointerException();
    }
  }
  
  private static final class LimitsDefaultEntryHolder {
    static final MapEntryLite<String, RateLimitProto.Counter> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, RateLimitProto.Counter.getDefaultInstance());
  }
  
  public static interface RateLimitOrBuilder extends MessageLiteOrBuilder {
    boolean containsLimits(String param1String);
    
    @Deprecated
    Map<String, RateLimitProto.Counter> getLimits();
    
    int getLimitsCount();
    
    Map<String, RateLimitProto.Counter> getLimitsMap();
    
    RateLimitProto.Counter getLimitsOrDefault(String param1String, RateLimitProto.Counter param1Counter);
    
    RateLimitProto.Counter getLimitsOrThrow(String param1String);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\RateLimitProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */