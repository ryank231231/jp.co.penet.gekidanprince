package com.google.internal.firebase.inappmessaging.v1;

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

public final class RolloutExperimentRequest extends GeneratedMessageLite<RolloutExperimentRequest, RolloutExperimentRequest.Builder> implements RolloutExperimentRequestOrBuilder {
  private static final RolloutExperimentRequest DEFAULT_INSTANCE = new RolloutExperimentRequest();
  
  public static final int EXPERIMENT_ID_FIELD_NUMBER = 2;
  
  private static volatile Parser<RolloutExperimentRequest> PARSER;
  
  public static final int PROJECT_NUMBER_FIELD_NUMBER = 1;
  
  public static final int ROLLOUT_DETAILS_FIELD_NUMBER = 3;
  
  private String experimentId_ = "";
  
  private String projectNumber_ = "";
  
  private CampaignProto.ExperimentalCampaignRollout rolloutDetails_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearExperimentId() {
    this.experimentId_ = getDefaultInstance().getExperimentId();
  }
  
  private void clearProjectNumber() {
    this.projectNumber_ = getDefaultInstance().getProjectNumber();
  }
  
  private void clearRolloutDetails() {
    this.rolloutDetails_ = null;
  }
  
  public static RolloutExperimentRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeRolloutDetails(CampaignProto.ExperimentalCampaignRollout paramExperimentalCampaignRollout) {
    CampaignProto.ExperimentalCampaignRollout experimentalCampaignRollout = this.rolloutDetails_;
    if (experimentalCampaignRollout != null && experimentalCampaignRollout != CampaignProto.ExperimentalCampaignRollout.getDefaultInstance()) {
      this.rolloutDetails_ = (CampaignProto.ExperimentalCampaignRollout)((CampaignProto.ExperimentalCampaignRollout.Builder)CampaignProto.ExperimentalCampaignRollout.newBuilder(this.rolloutDetails_).mergeFrom(paramExperimentalCampaignRollout)).buildPartial();
    } else {
      this.rolloutDetails_ = paramExperimentalCampaignRollout;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(RolloutExperimentRequest paramRolloutExperimentRequest) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramRolloutExperimentRequest);
  }
  
  public static RolloutExperimentRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (RolloutExperimentRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static RolloutExperimentRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RolloutExperimentRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static RolloutExperimentRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (RolloutExperimentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static RolloutExperimentRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (RolloutExperimentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static RolloutExperimentRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (RolloutExperimentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static RolloutExperimentRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RolloutExperimentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static RolloutExperimentRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (RolloutExperimentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static RolloutExperimentRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RolloutExperimentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static RolloutExperimentRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (RolloutExperimentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static RolloutExperimentRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (RolloutExperimentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<RolloutExperimentRequest> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setExperimentId(String paramString) {
    if (paramString != null) {
      this.experimentId_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setExperimentIdBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.experimentId_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
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
  
  private void setRolloutDetails(CampaignProto.ExperimentalCampaignRollout.Builder paramBuilder) {
    this.rolloutDetails_ = (CampaignProto.ExperimentalCampaignRollout)paramBuilder.build();
  }
  
  private void setRolloutDetails(CampaignProto.ExperimentalCampaignRollout paramExperimentalCampaignRollout) {
    if (paramExperimentalCampaignRollout != null) {
      this.rolloutDetails_ = paramExperimentalCampaignRollout;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/internal/firebase/inappmessaging/v1/RolloutExperimentRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 446, 2 -> 442, 3 -> 440, 4 -> 431, 5 -> 322, 6 -> 110, 7 -> 318, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/internal/firebase/inappmessaging/v1/RolloutExperimentRequest.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/internal/firebase/inappmessaging/v1/RolloutExperimentRequest
    //   72: monitorenter
    //   73: getstatic com/google/internal/firebase/inappmessaging/v1/RolloutExperimentRequest.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/internal/firebase/inappmessaging/v1/RolloutExperimentRequest.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/RolloutExperimentRequest;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/internal/firebase/inappmessaging/v1/RolloutExperimentRequest.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/internal/firebase/inappmessaging/v1/RolloutExperimentRequest
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/internal/firebase/inappmessaging/v1/RolloutExperimentRequest
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/internal/firebase/inappmessaging/v1/RolloutExperimentRequest.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 318
    //   128: aload_2
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 262
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 251
    //   146: iload #5
    //   148: bipush #18
    //   150: if_icmpeq -> 240
    //   153: iload #5
    //   155: bipush #26
    //   157: if_icmpeq -> 175
    //   160: aload_2
    //   161: iload #5
    //   163: invokevirtual skipField : (I)Z
    //   166: ifne -> 123
    //   169: iconst_1
    //   170: istore #4
    //   172: goto -> 123
    //   175: aload_0
    //   176: getfield rolloutDetails_ : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout;
    //   179: ifnull -> 196
    //   182: aload_0
    //   183: getfield rolloutDetails_ : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout;
    //   186: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   189: checkcast com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout$Builder
    //   192: astore_1
    //   193: goto -> 198
    //   196: aconst_null
    //   197: astore_1
    //   198: aload_0
    //   199: aload_2
    //   200: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   203: aload_3
    //   204: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   207: checkcast com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout
    //   210: putfield rolloutDetails_ : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout;
    //   213: aload_1
    //   214: ifnull -> 123
    //   217: aload_1
    //   218: aload_0
    //   219: getfield rolloutDetails_ : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout;
    //   222: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   225: pop
    //   226: aload_0
    //   227: aload_1
    //   228: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   231: checkcast com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout
    //   234: putfield rolloutDetails_ : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout;
    //   237: goto -> 123
    //   240: aload_0
    //   241: aload_2
    //   242: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   245: putfield experimentId_ : Ljava/lang/String;
    //   248: goto -> 123
    //   251: aload_0
    //   252: aload_2
    //   253: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   256: putfield projectNumber_ : Ljava/lang/String;
    //   259: goto -> 123
    //   262: iconst_1
    //   263: istore #4
    //   265: goto -> 123
    //   268: astore_1
    //   269: goto -> 316
    //   272: astore_1
    //   273: new java/lang/RuntimeException
    //   276: astore_3
    //   277: new com/google/protobuf/InvalidProtocolBufferException
    //   280: astore_2
    //   281: aload_2
    //   282: aload_1
    //   283: invokevirtual getMessage : ()Ljava/lang/String;
    //   286: invokespecial <init> : (Ljava/lang/String;)V
    //   289: aload_3
    //   290: aload_2
    //   291: aload_0
    //   292: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   295: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   298: aload_3
    //   299: athrow
    //   300: astore_1
    //   301: new java/lang/RuntimeException
    //   304: astore_2
    //   305: aload_2
    //   306: aload_1
    //   307: aload_0
    //   308: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   311: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   314: aload_2
    //   315: athrow
    //   316: aload_1
    //   317: athrow
    //   318: getstatic com/google/internal/firebase/inappmessaging/v1/RolloutExperimentRequest.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/RolloutExperimentRequest;
    //   321: areturn
    //   322: aload_2
    //   323: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   326: astore_1
    //   327: aload_3
    //   328: checkcast com/google/internal/firebase/inappmessaging/v1/RolloutExperimentRequest
    //   331: astore_2
    //   332: aload_0
    //   333: aload_1
    //   334: aload_0
    //   335: getfield projectNumber_ : Ljava/lang/String;
    //   338: invokevirtual isEmpty : ()Z
    //   341: iconst_1
    //   342: ixor
    //   343: aload_0
    //   344: getfield projectNumber_ : Ljava/lang/String;
    //   347: aload_2
    //   348: getfield projectNumber_ : Ljava/lang/String;
    //   351: invokevirtual isEmpty : ()Z
    //   354: iconst_1
    //   355: ixor
    //   356: aload_2
    //   357: getfield projectNumber_ : Ljava/lang/String;
    //   360: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   365: putfield projectNumber_ : Ljava/lang/String;
    //   368: aload_0
    //   369: aload_1
    //   370: aload_0
    //   371: getfield experimentId_ : Ljava/lang/String;
    //   374: invokevirtual isEmpty : ()Z
    //   377: iconst_1
    //   378: ixor
    //   379: aload_0
    //   380: getfield experimentId_ : Ljava/lang/String;
    //   383: iconst_1
    //   384: aload_2
    //   385: getfield experimentId_ : Ljava/lang/String;
    //   388: invokevirtual isEmpty : ()Z
    //   391: ixor
    //   392: aload_2
    //   393: getfield experimentId_ : Ljava/lang/String;
    //   396: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   401: putfield experimentId_ : Ljava/lang/String;
    //   404: aload_0
    //   405: aload_1
    //   406: aload_0
    //   407: getfield rolloutDetails_ : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout;
    //   410: aload_2
    //   411: getfield rolloutDetails_ : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout;
    //   414: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   419: checkcast com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout
    //   422: putfield rolloutDetails_ : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout;
    //   425: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   428: astore_1
    //   429: aload_0
    //   430: areturn
    //   431: new com/google/internal/firebase/inappmessaging/v1/RolloutExperimentRequest$Builder
    //   434: dup
    //   435: aconst_null
    //   436: invokespecial <init> : (Lcom/google/internal/firebase/inappmessaging/v1/RolloutExperimentRequest$1;)V
    //   439: areturn
    //   440: aconst_null
    //   441: areturn
    //   442: getstatic com/google/internal/firebase/inappmessaging/v1/RolloutExperimentRequest.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/RolloutExperimentRequest;
    //   445: areturn
    //   446: new com/google/internal/firebase/inappmessaging/v1/RolloutExperimentRequest
    //   449: dup
    //   450: invokespecial <init> : ()V
    //   453: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	300	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	272	java/io/IOException
    //   128	134	268	finally
    //   160	169	300	com/google/protobuf/InvalidProtocolBufferException
    //   160	169	272	java/io/IOException
    //   160	169	268	finally
    //   175	193	300	com/google/protobuf/InvalidProtocolBufferException
    //   175	193	272	java/io/IOException
    //   175	193	268	finally
    //   198	213	300	com/google/protobuf/InvalidProtocolBufferException
    //   198	213	272	java/io/IOException
    //   198	213	268	finally
    //   217	237	300	com/google/protobuf/InvalidProtocolBufferException
    //   217	237	272	java/io/IOException
    //   217	237	268	finally
    //   240	248	300	com/google/protobuf/InvalidProtocolBufferException
    //   240	248	272	java/io/IOException
    //   240	248	268	finally
    //   251	259	300	com/google/protobuf/InvalidProtocolBufferException
    //   251	259	272	java/io/IOException
    //   251	259	268	finally
    //   273	300	268	finally
    //   301	316	268	finally
  }
  
  public String getExperimentId() {
    return this.experimentId_;
  }
  
  public ByteString getExperimentIdBytes() {
    return ByteString.copyFromUtf8(this.experimentId_);
  }
  
  public String getProjectNumber() {
    return this.projectNumber_;
  }
  
  public ByteString getProjectNumberBytes() {
    return ByteString.copyFromUtf8(this.projectNumber_);
  }
  
  public CampaignProto.ExperimentalCampaignRollout getRolloutDetails() {
    CampaignProto.ExperimentalCampaignRollout experimentalCampaignRollout1 = this.rolloutDetails_;
    CampaignProto.ExperimentalCampaignRollout experimentalCampaignRollout2 = experimentalCampaignRollout1;
    if (experimentalCampaignRollout1 == null)
      experimentalCampaignRollout2 = CampaignProto.ExperimentalCampaignRollout.getDefaultInstance(); 
    return experimentalCampaignRollout2;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!this.projectNumber_.isEmpty())
      j = 0 + CodedOutputStream.computeStringSize(1, getProjectNumber()); 
    i = j;
    if (!this.experimentId_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(2, getExperimentId()); 
    j = i;
    if (this.rolloutDetails_ != null)
      j = i + CodedOutputStream.computeMessageSize(3, (MessageLite)getRolloutDetails()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public boolean hasRolloutDetails() {
    boolean bool;
    if (this.rolloutDetails_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.projectNumber_.isEmpty())
      paramCodedOutputStream.writeString(1, getProjectNumber()); 
    if (!this.experimentId_.isEmpty())
      paramCodedOutputStream.writeString(2, getExperimentId()); 
    if (this.rolloutDetails_ != null)
      paramCodedOutputStream.writeMessage(3, (MessageLite)getRolloutDetails()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<RolloutExperimentRequest, Builder> implements RolloutExperimentRequestOrBuilder {
    private Builder() {
      super(RolloutExperimentRequest.DEFAULT_INSTANCE);
    }
    
    public Builder clearExperimentId() {
      copyOnWrite();
      ((RolloutExperimentRequest)this.instance).clearExperimentId();
      return this;
    }
    
    public Builder clearProjectNumber() {
      copyOnWrite();
      ((RolloutExperimentRequest)this.instance).clearProjectNumber();
      return this;
    }
    
    public Builder clearRolloutDetails() {
      copyOnWrite();
      ((RolloutExperimentRequest)this.instance).clearRolloutDetails();
      return this;
    }
    
    public String getExperimentId() {
      return ((RolloutExperimentRequest)this.instance).getExperimentId();
    }
    
    public ByteString getExperimentIdBytes() {
      return ((RolloutExperimentRequest)this.instance).getExperimentIdBytes();
    }
    
    public String getProjectNumber() {
      return ((RolloutExperimentRequest)this.instance).getProjectNumber();
    }
    
    public ByteString getProjectNumberBytes() {
      return ((RolloutExperimentRequest)this.instance).getProjectNumberBytes();
    }
    
    public CampaignProto.ExperimentalCampaignRollout getRolloutDetails() {
      return ((RolloutExperimentRequest)this.instance).getRolloutDetails();
    }
    
    public boolean hasRolloutDetails() {
      return ((RolloutExperimentRequest)this.instance).hasRolloutDetails();
    }
    
    public Builder mergeRolloutDetails(CampaignProto.ExperimentalCampaignRollout param1ExperimentalCampaignRollout) {
      copyOnWrite();
      ((RolloutExperimentRequest)this.instance).mergeRolloutDetails(param1ExperimentalCampaignRollout);
      return this;
    }
    
    public Builder setExperimentId(String param1String) {
      copyOnWrite();
      ((RolloutExperimentRequest)this.instance).setExperimentId(param1String);
      return this;
    }
    
    public Builder setExperimentIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((RolloutExperimentRequest)this.instance).setExperimentIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setProjectNumber(String param1String) {
      copyOnWrite();
      ((RolloutExperimentRequest)this.instance).setProjectNumber(param1String);
      return this;
    }
    
    public Builder setProjectNumberBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((RolloutExperimentRequest)this.instance).setProjectNumberBytes(param1ByteString);
      return this;
    }
    
    public Builder setRolloutDetails(CampaignProto.ExperimentalCampaignRollout.Builder param1Builder) {
      copyOnWrite();
      ((RolloutExperimentRequest)this.instance).setRolloutDetails(param1Builder);
      return this;
    }
    
    public Builder setRolloutDetails(CampaignProto.ExperimentalCampaignRollout param1ExperimentalCampaignRollout) {
      copyOnWrite();
      ((RolloutExperimentRequest)this.instance).setRolloutDetails(param1ExperimentalCampaignRollout);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\internal\firebase\inappmessaging\v1\RolloutExperimentRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */