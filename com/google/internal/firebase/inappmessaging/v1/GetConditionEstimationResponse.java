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

public final class GetConditionEstimationResponse extends GeneratedMessageLite<GetConditionEstimationResponse, GetConditionEstimationResponse.Builder> implements GetConditionEstimationResponseOrBuilder {
  private static final GetConditionEstimationResponse DEFAULT_INSTANCE = new GetConditionEstimationResponse();
  
  public static final int ESTIMATION_PERCENTAGE_FIELD_NUMBER = 2;
  
  public static final int ESTIMATION_SIZE_FIELD_NUMBER = 1;
  
  private static volatile Parser<GetConditionEstimationResponse> PARSER;
  
  private int estimationPercentage_;
  
  private long estimationSize_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearEstimationPercentage() {
    this.estimationPercentage_ = 0;
  }
  
  private void clearEstimationSize() {
    this.estimationSize_ = 0L;
  }
  
  public static GetConditionEstimationResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(GetConditionEstimationResponse paramGetConditionEstimationResponse) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramGetConditionEstimationResponse);
  }
  
  public static GetConditionEstimationResponse parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (GetConditionEstimationResponse)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static GetConditionEstimationResponse parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (GetConditionEstimationResponse)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static GetConditionEstimationResponse parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (GetConditionEstimationResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static GetConditionEstimationResponse parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (GetConditionEstimationResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static GetConditionEstimationResponse parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (GetConditionEstimationResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static GetConditionEstimationResponse parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (GetConditionEstimationResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static GetConditionEstimationResponse parseFrom(InputStream paramInputStream) throws IOException {
    return (GetConditionEstimationResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static GetConditionEstimationResponse parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (GetConditionEstimationResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static GetConditionEstimationResponse parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (GetConditionEstimationResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static GetConditionEstimationResponse parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (GetConditionEstimationResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<GetConditionEstimationResponse> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setEstimationPercentage(int paramInt) {
    this.estimationPercentage_ = paramInt;
  }
  
  private void setEstimationSize(long paramLong) {
    this.estimationSize_ = paramLong;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationResponse$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 404, 2 -> 400, 3 -> 398, 4 -> 389, 5 -> 255, 6 -> 118, 7 -> 251, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationResponse.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationResponse
    //   80: monitorenter
    //   81: getstatic com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationResponse.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationResponse.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/GetConditionEstimationResponse;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationResponse.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationResponse
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationResponse
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationResponse.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_1
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_2
    //   128: iload #6
    //   130: ifne -> 251
    //   133: aload_1
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 195
    //   144: iload #4
    //   146: bipush #8
    //   148: if_icmpeq -> 184
    //   151: iload #4
    //   153: bipush #16
    //   155: if_icmpeq -> 173
    //   158: aload_1
    //   159: iload #4
    //   161: invokevirtual skipField : (I)Z
    //   164: ifne -> 128
    //   167: iconst_1
    //   168: istore #6
    //   170: goto -> 128
    //   173: aload_0
    //   174: aload_1
    //   175: invokevirtual readInt32 : ()I
    //   178: putfield estimationPercentage_ : I
    //   181: goto -> 128
    //   184: aload_0
    //   185: aload_1
    //   186: invokevirtual readInt64 : ()J
    //   189: putfield estimationSize_ : J
    //   192: goto -> 128
    //   195: iconst_1
    //   196: istore #6
    //   198: goto -> 128
    //   201: astore_1
    //   202: goto -> 249
    //   205: astore_1
    //   206: new java/lang/RuntimeException
    //   209: astore_2
    //   210: new com/google/protobuf/InvalidProtocolBufferException
    //   213: astore_3
    //   214: aload_3
    //   215: aload_1
    //   216: invokevirtual getMessage : ()Ljava/lang/String;
    //   219: invokespecial <init> : (Ljava/lang/String;)V
    //   222: aload_2
    //   223: aload_3
    //   224: aload_0
    //   225: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   228: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   231: aload_2
    //   232: athrow
    //   233: astore_2
    //   234: new java/lang/RuntimeException
    //   237: astore_1
    //   238: aload_1
    //   239: aload_2
    //   240: aload_0
    //   241: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   244: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   247: aload_1
    //   248: athrow
    //   249: aload_1
    //   250: athrow
    //   251: getstatic com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationResponse.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/GetConditionEstimationResponse;
    //   254: areturn
    //   255: aload_2
    //   256: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   259: astore_1
    //   260: aload_3
    //   261: checkcast com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationResponse
    //   264: astore_2
    //   265: aload_0
    //   266: getfield estimationSize_ : J
    //   269: lconst_0
    //   270: lcmp
    //   271: ifeq -> 280
    //   274: iconst_1
    //   275: istore #7
    //   277: goto -> 283
    //   280: iconst_0
    //   281: istore #7
    //   283: aload_0
    //   284: getfield estimationSize_ : J
    //   287: lstore #8
    //   289: aload_2
    //   290: getfield estimationSize_ : J
    //   293: lconst_0
    //   294: lcmp
    //   295: ifeq -> 304
    //   298: iconst_1
    //   299: istore #10
    //   301: goto -> 307
    //   304: iconst_0
    //   305: istore #10
    //   307: aload_0
    //   308: aload_1
    //   309: iload #7
    //   311: lload #8
    //   313: iload #10
    //   315: aload_2
    //   316: getfield estimationSize_ : J
    //   319: invokeinterface visitLong : (ZJZJ)J
    //   324: putfield estimationSize_ : J
    //   327: aload_0
    //   328: getfield estimationPercentage_ : I
    //   331: ifeq -> 340
    //   334: iconst_1
    //   335: istore #7
    //   337: goto -> 343
    //   340: iconst_0
    //   341: istore #7
    //   343: aload_0
    //   344: getfield estimationPercentage_ : I
    //   347: istore #6
    //   349: iload #5
    //   351: istore #10
    //   353: aload_2
    //   354: getfield estimationPercentage_ : I
    //   357: ifeq -> 363
    //   360: iconst_1
    //   361: istore #10
    //   363: aload_0
    //   364: aload_1
    //   365: iload #7
    //   367: iload #6
    //   369: iload #10
    //   371: aload_2
    //   372: getfield estimationPercentage_ : I
    //   375: invokeinterface visitInt : (ZIZI)I
    //   380: putfield estimationPercentage_ : I
    //   383: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   386: astore_1
    //   387: aload_0
    //   388: areturn
    //   389: new com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationResponse$Builder
    //   392: dup
    //   393: aconst_null
    //   394: invokespecial <init> : (Lcom/google/internal/firebase/inappmessaging/v1/GetConditionEstimationResponse$1;)V
    //   397: areturn
    //   398: aconst_null
    //   399: areturn
    //   400: getstatic com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationResponse.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/GetConditionEstimationResponse;
    //   403: areturn
    //   404: new com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationResponse
    //   407: dup
    //   408: invokespecial <init> : ()V
    //   411: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	233	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	205	java/io/IOException
    //   133	139	201	finally
    //   158	167	233	com/google/protobuf/InvalidProtocolBufferException
    //   158	167	205	java/io/IOException
    //   158	167	201	finally
    //   173	181	233	com/google/protobuf/InvalidProtocolBufferException
    //   173	181	205	java/io/IOException
    //   173	181	201	finally
    //   184	192	233	com/google/protobuf/InvalidProtocolBufferException
    //   184	192	205	java/io/IOException
    //   184	192	201	finally
    //   206	233	201	finally
    //   234	249	201	finally
  }
  
  public int getEstimationPercentage() {
    return this.estimationPercentage_;
  }
  
  public long getEstimationSize() {
    return this.estimationSize_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    long l = this.estimationSize_;
    if (l != 0L)
      i = 0 + CodedOutputStream.computeInt64Size(1, l); 
    int j = this.estimationPercentage_;
    int k = i;
    if (j != 0)
      k = i + CodedOutputStream.computeInt32Size(2, j); 
    this.memoizedSerializedSize = k;
    return k;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    long l = this.estimationSize_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(1, l); 
    int i = this.estimationPercentage_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(2, i); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<GetConditionEstimationResponse, Builder> implements GetConditionEstimationResponseOrBuilder {
    private Builder() {
      super(GetConditionEstimationResponse.DEFAULT_INSTANCE);
    }
    
    public Builder clearEstimationPercentage() {
      copyOnWrite();
      ((GetConditionEstimationResponse)this.instance).clearEstimationPercentage();
      return this;
    }
    
    public Builder clearEstimationSize() {
      copyOnWrite();
      ((GetConditionEstimationResponse)this.instance).clearEstimationSize();
      return this;
    }
    
    public int getEstimationPercentage() {
      return ((GetConditionEstimationResponse)this.instance).getEstimationPercentage();
    }
    
    public long getEstimationSize() {
      return ((GetConditionEstimationResponse)this.instance).getEstimationSize();
    }
    
    public Builder setEstimationPercentage(int param1Int) {
      copyOnWrite();
      ((GetConditionEstimationResponse)this.instance).setEstimationPercentage(param1Int);
      return this;
    }
    
    public Builder setEstimationSize(long param1Long) {
      copyOnWrite();
      ((GetConditionEstimationResponse)this.instance).setEstimationSize(param1Long);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\internal\firebase\inappmessaging\v1\GetConditionEstimationResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */