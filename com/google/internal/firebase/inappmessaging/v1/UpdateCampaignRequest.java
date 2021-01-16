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

public final class UpdateCampaignRequest extends GeneratedMessageLite<UpdateCampaignRequest, UpdateCampaignRequest.Builder> implements UpdateCampaignRequestOrBuilder {
  public static final int CAMPAIGN_FIELD_NUMBER = 1;
  
  private static final UpdateCampaignRequest DEFAULT_INSTANCE = new UpdateCampaignRequest();
  
  private static volatile Parser<UpdateCampaignRequest> PARSER;
  
  private CampaignProto.Campaign campaign_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearCampaign() {
    this.campaign_ = null;
  }
  
  public static UpdateCampaignRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeCampaign(CampaignProto.Campaign paramCampaign) {
    CampaignProto.Campaign campaign = this.campaign_;
    if (campaign != null && campaign != CampaignProto.Campaign.getDefaultInstance()) {
      this.campaign_ = (CampaignProto.Campaign)((CampaignProto.Campaign.Builder)CampaignProto.Campaign.newBuilder(this.campaign_).mergeFrom(paramCampaign)).buildPartial();
    } else {
      this.campaign_ = paramCampaign;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(UpdateCampaignRequest paramUpdateCampaignRequest) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramUpdateCampaignRequest);
  }
  
  public static UpdateCampaignRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (UpdateCampaignRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static UpdateCampaignRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (UpdateCampaignRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static UpdateCampaignRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (UpdateCampaignRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static UpdateCampaignRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (UpdateCampaignRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static UpdateCampaignRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (UpdateCampaignRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static UpdateCampaignRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (UpdateCampaignRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static UpdateCampaignRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (UpdateCampaignRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static UpdateCampaignRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (UpdateCampaignRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static UpdateCampaignRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (UpdateCampaignRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static UpdateCampaignRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (UpdateCampaignRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<UpdateCampaignRequest> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setCampaign(CampaignProto.Campaign.Builder paramBuilder) {
    this.campaign_ = (CampaignProto.Campaign)paramBuilder.build();
  }
  
  private void setCampaign(CampaignProto.Campaign paramCampaign) {
    if (paramCampaign != null) {
      this.campaign_ = paramCampaign;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/internal/firebase/inappmessaging/v1/UpdateCampaignRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 338, 2 -> 334, 3 -> 332, 4 -> 323, 5 -> 286, 6 -> 110, 7 -> 282, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/internal/firebase/inappmessaging/v1/UpdateCampaignRequest.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/internal/firebase/inappmessaging/v1/UpdateCampaignRequest
    //   72: monitorenter
    //   73: getstatic com/google/internal/firebase/inappmessaging/v1/UpdateCampaignRequest.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/internal/firebase/inappmessaging/v1/UpdateCampaignRequest.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/UpdateCampaignRequest;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/internal/firebase/inappmessaging/v1/UpdateCampaignRequest.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/internal/firebase/inappmessaging/v1/UpdateCampaignRequest
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/internal/firebase/inappmessaging/v1/UpdateCampaignRequest
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/internal/firebase/inappmessaging/v1/UpdateCampaignRequest.PARSER : Lcom/google/protobuf/Parser;
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
    //   162: getfield campaign_ : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign;
    //   165: ifnull -> 182
    //   168: aload_0
    //   169: getfield campaign_ : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign;
    //   172: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   175: checkcast com/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign$Builder
    //   178: astore_1
    //   179: goto -> 184
    //   182: aconst_null
    //   183: astore_1
    //   184: aload_0
    //   185: aload_2
    //   186: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   189: aload_3
    //   190: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   193: checkcast com/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign
    //   196: putfield campaign_ : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign;
    //   199: aload_1
    //   200: ifnull -> 123
    //   203: aload_1
    //   204: aload_0
    //   205: getfield campaign_ : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign;
    //   208: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   211: pop
    //   212: aload_0
    //   213: aload_1
    //   214: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   217: checkcast com/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign
    //   220: putfield campaign_ : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign;
    //   223: goto -> 123
    //   226: iconst_1
    //   227: istore #4
    //   229: goto -> 123
    //   232: astore_1
    //   233: goto -> 280
    //   236: astore_1
    //   237: new java/lang/RuntimeException
    //   240: astore_2
    //   241: new com/google/protobuf/InvalidProtocolBufferException
    //   244: astore_3
    //   245: aload_3
    //   246: aload_1
    //   247: invokevirtual getMessage : ()Ljava/lang/String;
    //   250: invokespecial <init> : (Ljava/lang/String;)V
    //   253: aload_2
    //   254: aload_3
    //   255: aload_0
    //   256: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   259: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   262: aload_2
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
    //   282: getstatic com/google/internal/firebase/inappmessaging/v1/UpdateCampaignRequest.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/UpdateCampaignRequest;
    //   285: areturn
    //   286: aload_2
    //   287: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   290: astore_1
    //   291: aload_3
    //   292: checkcast com/google/internal/firebase/inappmessaging/v1/UpdateCampaignRequest
    //   295: astore_2
    //   296: aload_0
    //   297: aload_1
    //   298: aload_0
    //   299: getfield campaign_ : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign;
    //   302: aload_2
    //   303: getfield campaign_ : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign;
    //   306: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   311: checkcast com/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign
    //   314: putfield campaign_ : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign;
    //   317: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   320: astore_1
    //   321: aload_0
    //   322: areturn
    //   323: new com/google/internal/firebase/inappmessaging/v1/UpdateCampaignRequest$Builder
    //   326: dup
    //   327: aconst_null
    //   328: invokespecial <init> : (Lcom/google/internal/firebase/inappmessaging/v1/UpdateCampaignRequest$1;)V
    //   331: areturn
    //   332: aconst_null
    //   333: areturn
    //   334: getstatic com/google/internal/firebase/inappmessaging/v1/UpdateCampaignRequest.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/UpdateCampaignRequest;
    //   337: areturn
    //   338: new com/google/internal/firebase/inappmessaging/v1/UpdateCampaignRequest
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
  
  public CampaignProto.Campaign getCampaign() {
    CampaignProto.Campaign campaign1 = this.campaign_;
    CampaignProto.Campaign campaign2 = campaign1;
    if (campaign1 == null)
      campaign2 = CampaignProto.Campaign.getDefaultInstance(); 
    return campaign2;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (this.campaign_ != null)
      i = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)getCampaign()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public boolean hasCampaign() {
    boolean bool;
    if (this.campaign_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (this.campaign_ != null)
      paramCodedOutputStream.writeMessage(1, (MessageLite)getCampaign()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<UpdateCampaignRequest, Builder> implements UpdateCampaignRequestOrBuilder {
    private Builder() {
      super(UpdateCampaignRequest.DEFAULT_INSTANCE);
    }
    
    public Builder clearCampaign() {
      copyOnWrite();
      ((UpdateCampaignRequest)this.instance).clearCampaign();
      return this;
    }
    
    public CampaignProto.Campaign getCampaign() {
      return ((UpdateCampaignRequest)this.instance).getCampaign();
    }
    
    public boolean hasCampaign() {
      return ((UpdateCampaignRequest)this.instance).hasCampaign();
    }
    
    public Builder mergeCampaign(CampaignProto.Campaign param1Campaign) {
      copyOnWrite();
      ((UpdateCampaignRequest)this.instance).mergeCampaign(param1Campaign);
      return this;
    }
    
    public Builder setCampaign(CampaignProto.Campaign.Builder param1Builder) {
      copyOnWrite();
      ((UpdateCampaignRequest)this.instance).setCampaign(param1Builder);
      return this;
    }
    
    public Builder setCampaign(CampaignProto.Campaign param1Campaign) {
      copyOnWrite();
      ((UpdateCampaignRequest)this.instance).setCampaign(param1Campaign);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\internal\firebase\inappmessaging\v1\UpdateCampaignRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */