package com.google.internal.firebase.inappmessaging.v1;

import com.google.developers.mobile.targeting.proto.Conditions;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class GetConditionEstimationRequest extends GeneratedMessageLite<GetConditionEstimationRequest, GetConditionEstimationRequest.Builder> implements GetConditionEstimationRequestOrBuilder {
  private static final GetConditionEstimationRequest DEFAULT_INSTANCE = new GetConditionEstimationRequest();
  
  private static volatile Parser<GetConditionEstimationRequest> PARSER;
  
  public static final int PROJECT_NUMBER_FIELD_NUMBER = 1;
  
  public static final int TARGETING_CONDITION_FIELD_NUMBER = 2;
  
  private String projectNumber_ = "";
  
  private Conditions.Condition targetingCondition_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearProjectNumber() {
    this.projectNumber_ = getDefaultInstance().getProjectNumber();
  }
  
  private void clearTargetingCondition() {
    this.targetingCondition_ = null;
  }
  
  public static GetConditionEstimationRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeTargetingCondition(Conditions.Condition paramCondition) {
    Conditions.Condition condition = this.targetingCondition_;
    if (condition != null && condition != Conditions.Condition.getDefaultInstance()) {
      this.targetingCondition_ = (Conditions.Condition)((Conditions.Condition.Builder)Conditions.Condition.newBuilder(this.targetingCondition_).mergeFrom((GeneratedMessageLite)paramCondition)).buildPartial();
    } else {
      this.targetingCondition_ = paramCondition;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(GetConditionEstimationRequest paramGetConditionEstimationRequest) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramGetConditionEstimationRequest);
  }
  
  public static GetConditionEstimationRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (GetConditionEstimationRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static GetConditionEstimationRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (GetConditionEstimationRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static GetConditionEstimationRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (GetConditionEstimationRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static GetConditionEstimationRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (GetConditionEstimationRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static GetConditionEstimationRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (GetConditionEstimationRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static GetConditionEstimationRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (GetConditionEstimationRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static GetConditionEstimationRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (GetConditionEstimationRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static GetConditionEstimationRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (GetConditionEstimationRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static GetConditionEstimationRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (GetConditionEstimationRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static GetConditionEstimationRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (GetConditionEstimationRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<GetConditionEstimationRequest> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setProjectNumber(String paramString) {
    if (paramString != null) {
      this.projectNumber_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setProjectNumberBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.projectNumber_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setTargetingCondition(Conditions.Condition.Builder paramBuilder) {
    this.targetingCondition_ = (Conditions.Condition)paramBuilder.build();
  }
  
  private void setTargetingCondition(Conditions.Condition paramCondition) {
    if (paramCondition != null) {
      this.targetingCondition_ = paramCondition;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 392, 2 -> 388, 3 -> 386, 4 -> 377, 5 -> 304, 6 -> 110, 7 -> 300, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationRequest.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationRequest
    //   72: monitorenter
    //   73: getstatic com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationRequest.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationRequest.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/GetConditionEstimationRequest;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationRequest.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationRequest
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationRequest
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationRequest.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 300
    //   128: aload_2
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 244
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 233
    //   146: iload #5
    //   148: bipush #18
    //   150: if_icmpeq -> 168
    //   153: aload_2
    //   154: iload #5
    //   156: invokevirtual skipField : (I)Z
    //   159: ifne -> 123
    //   162: iconst_1
    //   163: istore #4
    //   165: goto -> 123
    //   168: aload_0
    //   169: getfield targetingCondition_ : Lcom/google/developers/mobile/targeting/proto/Conditions$Condition;
    //   172: ifnull -> 189
    //   175: aload_0
    //   176: getfield targetingCondition_ : Lcom/google/developers/mobile/targeting/proto/Conditions$Condition;
    //   179: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   182: checkcast com/google/developers/mobile/targeting/proto/Conditions$Condition$Builder
    //   185: astore_1
    //   186: goto -> 191
    //   189: aconst_null
    //   190: astore_1
    //   191: aload_0
    //   192: aload_2
    //   193: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   196: aload_3
    //   197: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   200: checkcast com/google/developers/mobile/targeting/proto/Conditions$Condition
    //   203: putfield targetingCondition_ : Lcom/google/developers/mobile/targeting/proto/Conditions$Condition;
    //   206: aload_1
    //   207: ifnull -> 123
    //   210: aload_1
    //   211: aload_0
    //   212: getfield targetingCondition_ : Lcom/google/developers/mobile/targeting/proto/Conditions$Condition;
    //   215: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   218: pop
    //   219: aload_0
    //   220: aload_1
    //   221: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   224: checkcast com/google/developers/mobile/targeting/proto/Conditions$Condition
    //   227: putfield targetingCondition_ : Lcom/google/developers/mobile/targeting/proto/Conditions$Condition;
    //   230: goto -> 123
    //   233: aload_0
    //   234: aload_2
    //   235: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   238: putfield projectNumber_ : Ljava/lang/String;
    //   241: goto -> 123
    //   244: iconst_1
    //   245: istore #4
    //   247: goto -> 123
    //   250: astore_1
    //   251: goto -> 298
    //   254: astore_1
    //   255: new java/lang/RuntimeException
    //   258: astore_3
    //   259: new com/google/protobuf/InvalidProtocolBufferException
    //   262: astore_2
    //   263: aload_2
    //   264: aload_1
    //   265: invokevirtual getMessage : ()Ljava/lang/String;
    //   268: invokespecial <init> : (Ljava/lang/String;)V
    //   271: aload_3
    //   272: aload_2
    //   273: aload_0
    //   274: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   277: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   280: aload_3
    //   281: athrow
    //   282: astore_2
    //   283: new java/lang/RuntimeException
    //   286: astore_1
    //   287: aload_1
    //   288: aload_2
    //   289: aload_0
    //   290: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   293: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   296: aload_1
    //   297: athrow
    //   298: aload_1
    //   299: athrow
    //   300: getstatic com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationRequest.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/GetConditionEstimationRequest;
    //   303: areturn
    //   304: aload_2
    //   305: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   308: astore_1
    //   309: aload_3
    //   310: checkcast com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationRequest
    //   313: astore_2
    //   314: aload_0
    //   315: aload_1
    //   316: aload_0
    //   317: getfield projectNumber_ : Ljava/lang/String;
    //   320: invokevirtual isEmpty : ()Z
    //   323: iconst_1
    //   324: ixor
    //   325: aload_0
    //   326: getfield projectNumber_ : Ljava/lang/String;
    //   329: iconst_1
    //   330: aload_2
    //   331: getfield projectNumber_ : Ljava/lang/String;
    //   334: invokevirtual isEmpty : ()Z
    //   337: ixor
    //   338: aload_2
    //   339: getfield projectNumber_ : Ljava/lang/String;
    //   342: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   347: putfield projectNumber_ : Ljava/lang/String;
    //   350: aload_0
    //   351: aload_1
    //   352: aload_0
    //   353: getfield targetingCondition_ : Lcom/google/developers/mobile/targeting/proto/Conditions$Condition;
    //   356: aload_2
    //   357: getfield targetingCondition_ : Lcom/google/developers/mobile/targeting/proto/Conditions$Condition;
    //   360: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   365: checkcast com/google/developers/mobile/targeting/proto/Conditions$Condition
    //   368: putfield targetingCondition_ : Lcom/google/developers/mobile/targeting/proto/Conditions$Condition;
    //   371: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   374: astore_1
    //   375: aload_0
    //   376: areturn
    //   377: new com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationRequest$Builder
    //   380: dup
    //   381: aconst_null
    //   382: invokespecial <init> : (Lcom/google/internal/firebase/inappmessaging/v1/GetConditionEstimationRequest$1;)V
    //   385: areturn
    //   386: aconst_null
    //   387: areturn
    //   388: getstatic com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationRequest.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/GetConditionEstimationRequest;
    //   391: areturn
    //   392: new com/google/internal/firebase/inappmessaging/v1/GetConditionEstimationRequest
    //   395: dup
    //   396: invokespecial <init> : ()V
    //   399: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	282	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	254	java/io/IOException
    //   128	134	250	finally
    //   153	162	282	com/google/protobuf/InvalidProtocolBufferException
    //   153	162	254	java/io/IOException
    //   153	162	250	finally
    //   168	186	282	com/google/protobuf/InvalidProtocolBufferException
    //   168	186	254	java/io/IOException
    //   168	186	250	finally
    //   191	206	282	com/google/protobuf/InvalidProtocolBufferException
    //   191	206	254	java/io/IOException
    //   191	206	250	finally
    //   210	230	282	com/google/protobuf/InvalidProtocolBufferException
    //   210	230	254	java/io/IOException
    //   210	230	250	finally
    //   233	241	282	com/google/protobuf/InvalidProtocolBufferException
    //   233	241	254	java/io/IOException
    //   233	241	250	finally
    //   255	282	250	finally
    //   283	298	250	finally
  }
  
  public String getProjectNumber() {
    return this.projectNumber_;
  }
  
  public ByteString getProjectNumberBytes() {
    return ByteString.copyFromUtf8(this.projectNumber_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!this.projectNumber_.isEmpty())
      i = 0 + CodedOutputStream.computeStringSize(1, getProjectNumber()); 
    int j = i;
    if (this.targetingCondition_ != null)
      j = i + CodedOutputStream.computeMessageSize(2, (MessageLite)getTargetingCondition()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public Conditions.Condition getTargetingCondition() {
    Conditions.Condition condition1 = this.targetingCondition_;
    Conditions.Condition condition2 = condition1;
    if (condition1 == null)
      condition2 = Conditions.Condition.getDefaultInstance(); 
    return condition2;
  }
  
  public boolean hasTargetingCondition() {
    boolean bool;
    if (this.targetingCondition_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.projectNumber_.isEmpty())
      paramCodedOutputStream.writeString(1, getProjectNumber()); 
    if (this.targetingCondition_ != null)
      paramCodedOutputStream.writeMessage(2, (MessageLite)getTargetingCondition()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<GetConditionEstimationRequest, Builder> implements GetConditionEstimationRequestOrBuilder {
    private Builder() {
      super(GetConditionEstimationRequest.DEFAULT_INSTANCE);
    }
    
    public Builder clearProjectNumber() {
      copyOnWrite();
      ((GetConditionEstimationRequest)this.instance).clearProjectNumber();
      return this;
    }
    
    public Builder clearTargetingCondition() {
      copyOnWrite();
      ((GetConditionEstimationRequest)this.instance).clearTargetingCondition();
      return this;
    }
    
    public String getProjectNumber() {
      return ((GetConditionEstimationRequest)this.instance).getProjectNumber();
    }
    
    public ByteString getProjectNumberBytes() {
      return ((GetConditionEstimationRequest)this.instance).getProjectNumberBytes();
    }
    
    public Conditions.Condition getTargetingCondition() {
      return ((GetConditionEstimationRequest)this.instance).getTargetingCondition();
    }
    
    public boolean hasTargetingCondition() {
      return ((GetConditionEstimationRequest)this.instance).hasTargetingCondition();
    }
    
    public Builder mergeTargetingCondition(Conditions.Condition param1Condition) {
      copyOnWrite();
      ((GetConditionEstimationRequest)this.instance).mergeTargetingCondition(param1Condition);
      return this;
    }
    
    public Builder setProjectNumber(String param1String) {
      copyOnWrite();
      ((GetConditionEstimationRequest)this.instance).setProjectNumber(param1String);
      return this;
    }
    
    public Builder setProjectNumberBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GetConditionEstimationRequest)this.instance).setProjectNumberBytes(param1ByteString);
      return this;
    }
    
    public Builder setTargetingCondition(Conditions.Condition.Builder param1Builder) {
      copyOnWrite();
      ((GetConditionEstimationRequest)this.instance).setTargetingCondition(param1Builder);
      return this;
    }
    
    public Builder setTargetingCondition(Conditions.Condition param1Condition) {
      copyOnWrite();
      ((GetConditionEstimationRequest)this.instance).setTargetingCondition(param1Condition);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\internal\firebase\inappmessaging\v1\GetConditionEstimationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */