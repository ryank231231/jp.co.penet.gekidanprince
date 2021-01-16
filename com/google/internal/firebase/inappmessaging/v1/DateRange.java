package com.google.internal.firebase.inappmessaging.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class DateRange extends GeneratedMessageLite<DateRange, DateRange.Builder> implements DateRangeOrBuilder {
  private static final DateRange DEFAULT_INSTANCE = new DateRange();
  
  public static final int END_DATE_MS_FIELD_NUMBER = 2;
  
  private static volatile Parser<DateRange> PARSER;
  
  public static final int START_DATE_MS_FIELD_NUMBER = 1;
  
  private long endDateMs_;
  
  private long startDateMs_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearEndDateMs() {
    this.endDateMs_ = 0L;
  }
  
  private void clearStartDateMs() {
    this.startDateMs_ = 0L;
  }
  
  public static DateRange getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(DateRange paramDateRange) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramDateRange);
  }
  
  public static DateRange parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (DateRange)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static DateRange parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DateRange)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DateRange parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (DateRange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static DateRange parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (DateRange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static DateRange parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (DateRange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static DateRange parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DateRange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static DateRange parseFrom(InputStream paramInputStream) throws IOException {
    return (DateRange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static DateRange parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DateRange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DateRange parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (DateRange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static DateRange parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (DateRange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<DateRange> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setEndDateMs(long paramLong) {
    this.endDateMs_ = paramLong;
  }
  
  private void setStartDateMs(long paramLong) {
    this.startDateMs_ = paramLong;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/internal/firebase/inappmessaging/v1/DateRange$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
    //   68: getstatic com/google/internal/firebase/inappmessaging/v1/DateRange.PARSER : Lcom/google/protobuf/Parser;
    //   71: ifnonnull -> 110
    //   74: ldc com/google/internal/firebase/inappmessaging/v1/DateRange
    //   76: monitorenter
    //   77: getstatic com/google/internal/firebase/inappmessaging/v1/DateRange.PARSER : Lcom/google/protobuf/Parser;
    //   80: ifnonnull -> 98
    //   83: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   86: astore_1
    //   87: aload_1
    //   88: getstatic com/google/internal/firebase/inappmessaging/v1/DateRange.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/DateRange;
    //   91: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   94: aload_1
    //   95: putstatic com/google/internal/firebase/inappmessaging/v1/DateRange.PARSER : Lcom/google/protobuf/Parser;
    //   98: ldc com/google/internal/firebase/inappmessaging/v1/DateRange
    //   100: monitorexit
    //   101: goto -> 110
    //   104: astore_1
    //   105: ldc com/google/internal/firebase/inappmessaging/v1/DateRange
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    //   110: getstatic com/google/internal/firebase/inappmessaging/v1/DateRange.PARSER : Lcom/google/protobuf/Parser;
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
    //   174: putfield endDateMs_ : J
    //   177: goto -> 124
    //   180: aload_0
    //   181: aload_1
    //   182: invokevirtual readInt64 : ()J
    //   185: putfield startDateMs_ : J
    //   188: goto -> 124
    //   191: iconst_1
    //   192: istore #5
    //   194: goto -> 124
    //   197: astore_1
    //   198: goto -> 245
    //   201: astore_1
    //   202: new java/lang/RuntimeException
    //   205: astore_3
    //   206: new com/google/protobuf/InvalidProtocolBufferException
    //   209: astore_2
    //   210: aload_2
    //   211: aload_1
    //   212: invokevirtual getMessage : ()Ljava/lang/String;
    //   215: invokespecial <init> : (Ljava/lang/String;)V
    //   218: aload_3
    //   219: aload_2
    //   220: aload_0
    //   221: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   224: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   227: aload_3
    //   228: athrow
    //   229: astore_2
    //   230: new java/lang/RuntimeException
    //   233: astore_1
    //   234: aload_1
    //   235: aload_2
    //   236: aload_0
    //   237: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   240: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   243: aload_1
    //   244: athrow
    //   245: aload_1
    //   246: athrow
    //   247: getstatic com/google/internal/firebase/inappmessaging/v1/DateRange.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/DateRange;
    //   250: areturn
    //   251: aload_2
    //   252: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   255: astore_1
    //   256: aload_3
    //   257: checkcast com/google/internal/firebase/inappmessaging/v1/DateRange
    //   260: astore_2
    //   261: aload_0
    //   262: getfield startDateMs_ : J
    //   265: lconst_0
    //   266: lcmp
    //   267: ifeq -> 276
    //   270: iconst_1
    //   271: istore #6
    //   273: goto -> 279
    //   276: iconst_0
    //   277: istore #6
    //   279: aload_0
    //   280: getfield startDateMs_ : J
    //   283: lstore #7
    //   285: aload_2
    //   286: getfield startDateMs_ : J
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
    //   312: getfield startDateMs_ : J
    //   315: invokeinterface visitLong : (ZJZJ)J
    //   320: putfield startDateMs_ : J
    //   323: aload_0
    //   324: getfield endDateMs_ : J
    //   327: lconst_0
    //   328: lcmp
    //   329: ifeq -> 338
    //   332: iconst_1
    //   333: istore #6
    //   335: goto -> 341
    //   338: iconst_0
    //   339: istore #6
    //   341: aload_0
    //   342: getfield endDateMs_ : J
    //   345: lstore #7
    //   347: aload_2
    //   348: getfield endDateMs_ : J
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
    //   374: getfield endDateMs_ : J
    //   377: invokeinterface visitLong : (ZJZJ)J
    //   382: putfield endDateMs_ : J
    //   385: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   388: astore_1
    //   389: aload_0
    //   390: areturn
    //   391: new com/google/internal/firebase/inappmessaging/v1/DateRange$Builder
    //   394: dup
    //   395: aconst_null
    //   396: invokespecial <init> : (Lcom/google/internal/firebase/inappmessaging/v1/DateRange$1;)V
    //   399: areturn
    //   400: aconst_null
    //   401: areturn
    //   402: getstatic com/google/internal/firebase/inappmessaging/v1/DateRange.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/DateRange;
    //   405: areturn
    //   406: new com/google/internal/firebase/inappmessaging/v1/DateRange
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
  
  public long getEndDateMs() {
    return this.endDateMs_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    long l = this.startDateMs_;
    if (l != 0L)
      i = 0 + CodedOutputStream.computeInt64Size(1, l); 
    l = this.endDateMs_;
    int j = i;
    if (l != 0L)
      j = i + CodedOutputStream.computeInt64Size(2, l); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public long getStartDateMs() {
    return this.startDateMs_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    long l = this.startDateMs_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(1, l); 
    l = this.endDateMs_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(2, l); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<DateRange, Builder> implements DateRangeOrBuilder {
    private Builder() {
      super(DateRange.DEFAULT_INSTANCE);
    }
    
    public Builder clearEndDateMs() {
      copyOnWrite();
      ((DateRange)this.instance).clearEndDateMs();
      return this;
    }
    
    public Builder clearStartDateMs() {
      copyOnWrite();
      ((DateRange)this.instance).clearStartDateMs();
      return this;
    }
    
    public long getEndDateMs() {
      return ((DateRange)this.instance).getEndDateMs();
    }
    
    public long getStartDateMs() {
      return ((DateRange)this.instance).getStartDateMs();
    }
    
    public Builder setEndDateMs(long param1Long) {
      copyOnWrite();
      ((DateRange)this.instance).setEndDateMs(param1Long);
      return this;
    }
    
    public Builder setStartDateMs(long param1Long) {
      copyOnWrite();
      ((DateRange)this.instance).setStartDateMs(param1Long);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\internal\firebase\inappmessaging\v1\DateRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */