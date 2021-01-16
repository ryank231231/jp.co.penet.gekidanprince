package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Duration;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class RetryInfo extends GeneratedMessageLite<RetryInfo, RetryInfo.Builder> implements RetryInfoOrBuilder {
  private static final RetryInfo DEFAULT_INSTANCE = new RetryInfo();
  
  private static volatile Parser<RetryInfo> PARSER;
  
  public static final int RETRY_DELAY_FIELD_NUMBER = 1;
  
  private Duration retryDelay_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearRetryDelay() {
    this.retryDelay_ = null;
  }
  
  public static RetryInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeRetryDelay(Duration paramDuration) {
    Duration duration = this.retryDelay_;
    if (duration != null && duration != Duration.getDefaultInstance()) {
      this.retryDelay_ = (Duration)((Duration.Builder)Duration.newBuilder(this.retryDelay_).mergeFrom((GeneratedMessageLite)paramDuration)).buildPartial();
    } else {
      this.retryDelay_ = paramDuration;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(RetryInfo paramRetryInfo) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramRetryInfo);
  }
  
  public static RetryInfo parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (RetryInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static RetryInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RetryInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static RetryInfo parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (RetryInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static RetryInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (RetryInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static RetryInfo parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (RetryInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static RetryInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RetryInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static RetryInfo parseFrom(InputStream paramInputStream) throws IOException {
    return (RetryInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static RetryInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RetryInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static RetryInfo parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (RetryInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static RetryInfo parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (RetryInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<RetryInfo> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setRetryDelay(Duration.Builder paramBuilder) {
    this.retryDelay_ = (Duration)paramBuilder.build();
  }
  
  private void setRetryDelay(Duration paramDuration) {
    if (paramDuration != null) {
      this.retryDelay_ = paramDuration;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/rpc/RetryInfo$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 338, 2 -> 334, 3 -> 332, 4 -> 323, 5 -> 286, 6 -> 110, 7 -> 282, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/rpc/RetryInfo.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/rpc/RetryInfo
    //   72: monitorenter
    //   73: getstatic com/google/rpc/RetryInfo.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/rpc/RetryInfo.DEFAULT_INSTANCE : Lcom/google/rpc/RetryInfo;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/rpc/RetryInfo.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/rpc/RetryInfo
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/rpc/RetryInfo
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/rpc/RetryInfo.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 282
    //   128: aload_2
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 226
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 161
    //   146: aload_2
    //   147: iload #5
    //   149: invokevirtual skipField : (I)Z
    //   152: ifne -> 123
    //   155: iconst_1
    //   156: istore #4
    //   158: goto -> 123
    //   161: aload_0
    //   162: getfield retryDelay_ : Lcom/google/protobuf/Duration;
    //   165: ifnull -> 182
    //   168: aload_0
    //   169: getfield retryDelay_ : Lcom/google/protobuf/Duration;
    //   172: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   175: checkcast com/google/protobuf/Duration$Builder
    //   178: astore_1
    //   179: goto -> 184
    //   182: aconst_null
    //   183: astore_1
    //   184: aload_0
    //   185: aload_2
    //   186: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   189: aload_3
    //   190: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   193: checkcast com/google/protobuf/Duration
    //   196: putfield retryDelay_ : Lcom/google/protobuf/Duration;
    //   199: aload_1
    //   200: ifnull -> 123
    //   203: aload_1
    //   204: aload_0
    //   205: getfield retryDelay_ : Lcom/google/protobuf/Duration;
    //   208: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   211: pop
    //   212: aload_0
    //   213: aload_1
    //   214: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   217: checkcast com/google/protobuf/Duration
    //   220: putfield retryDelay_ : Lcom/google/protobuf/Duration;
    //   223: goto -> 123
    //   226: iconst_1
    //   227: istore #4
    //   229: goto -> 123
    //   232: astore_1
    //   233: goto -> 280
    //   236: astore_2
    //   237: new java/lang/RuntimeException
    //   240: astore_1
    //   241: new com/google/protobuf/InvalidProtocolBufferException
    //   244: astore_3
    //   245: aload_3
    //   246: aload_2
    //   247: invokevirtual getMessage : ()Ljava/lang/String;
    //   250: invokespecial <init> : (Ljava/lang/String;)V
    //   253: aload_1
    //   254: aload_3
    //   255: aload_0
    //   256: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   259: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   262: aload_1
    //   263: athrow
    //   264: astore_2
    //   265: new java/lang/RuntimeException
    //   268: astore_1
    //   269: aload_1
    //   270: aload_2
    //   271: aload_0
    //   272: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   275: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   278: aload_1
    //   279: athrow
    //   280: aload_1
    //   281: athrow
    //   282: getstatic com/google/rpc/RetryInfo.DEFAULT_INSTANCE : Lcom/google/rpc/RetryInfo;
    //   285: areturn
    //   286: aload_2
    //   287: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   290: astore_1
    //   291: aload_3
    //   292: checkcast com/google/rpc/RetryInfo
    //   295: astore_2
    //   296: aload_0
    //   297: aload_1
    //   298: aload_0
    //   299: getfield retryDelay_ : Lcom/google/protobuf/Duration;
    //   302: aload_2
    //   303: getfield retryDelay_ : Lcom/google/protobuf/Duration;
    //   306: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   311: checkcast com/google/protobuf/Duration
    //   314: putfield retryDelay_ : Lcom/google/protobuf/Duration;
    //   317: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   320: astore_1
    //   321: aload_0
    //   322: areturn
    //   323: new com/google/rpc/RetryInfo$Builder
    //   326: dup
    //   327: aconst_null
    //   328: invokespecial <init> : (Lcom/google/rpc/RetryInfo$1;)V
    //   331: areturn
    //   332: aconst_null
    //   333: areturn
    //   334: getstatic com/google/rpc/RetryInfo.DEFAULT_INSTANCE : Lcom/google/rpc/RetryInfo;
    //   337: areturn
    //   338: new com/google/rpc/RetryInfo
    //   341: dup
    //   342: invokespecial <init> : ()V
    //   345: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	264	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	236	java/io/IOException
    //   128	134	232	finally
    //   146	155	264	com/google/protobuf/InvalidProtocolBufferException
    //   146	155	236	java/io/IOException
    //   146	155	232	finally
    //   161	179	264	com/google/protobuf/InvalidProtocolBufferException
    //   161	179	236	java/io/IOException
    //   161	179	232	finally
    //   184	199	264	com/google/protobuf/InvalidProtocolBufferException
    //   184	199	236	java/io/IOException
    //   184	199	232	finally
    //   203	223	264	com/google/protobuf/InvalidProtocolBufferException
    //   203	223	236	java/io/IOException
    //   203	223	232	finally
    //   237	264	232	finally
    //   265	280	232	finally
  }
  
  public Duration getRetryDelay() {
    Duration duration1 = this.retryDelay_;
    Duration duration2 = duration1;
    if (duration1 == null)
      duration2 = Duration.getDefaultInstance(); 
    return duration2;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (this.retryDelay_ != null)
      i = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)getRetryDelay()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public boolean hasRetryDelay() {
    boolean bool;
    if (this.retryDelay_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (this.retryDelay_ != null)
      paramCodedOutputStream.writeMessage(1, (MessageLite)getRetryDelay()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<RetryInfo, Builder> implements RetryInfoOrBuilder {
    private Builder() {
      super(RetryInfo.DEFAULT_INSTANCE);
    }
    
    public Builder clearRetryDelay() {
      copyOnWrite();
      ((RetryInfo)this.instance).clearRetryDelay();
      return this;
    }
    
    public Duration getRetryDelay() {
      return ((RetryInfo)this.instance).getRetryDelay();
    }
    
    public boolean hasRetryDelay() {
      return ((RetryInfo)this.instance).hasRetryDelay();
    }
    
    public Builder mergeRetryDelay(Duration param1Duration) {
      copyOnWrite();
      ((RetryInfo)this.instance).mergeRetryDelay(param1Duration);
      return this;
    }
    
    public Builder setRetryDelay(Duration.Builder param1Builder) {
      copyOnWrite();
      ((RetryInfo)this.instance).setRetryDelay(param1Builder);
      return this;
    }
    
    public Builder setRetryDelay(Duration param1Duration) {
      copyOnWrite();
      ((RetryInfo)this.instance).setRetryDelay(param1Duration);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\rpc\RetryInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */