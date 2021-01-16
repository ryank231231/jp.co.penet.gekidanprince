package com.google.internal.firebase.inappmessaging.v1;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class RolloutExperimentResponse extends GeneratedMessageLite<RolloutExperimentResponse, RolloutExperimentResponse.Builder> implements RolloutExperimentResponseOrBuilder {
  public static final int CAMPAIGN_FIELD_NUMBER = 1;
  
  private static final RolloutExperimentResponse DEFAULT_INSTANCE = new RolloutExperimentResponse();
  
  private static volatile Parser<RolloutExperimentResponse> PARSER;
  
  private Internal.ProtobufList<CampaignProto.Campaign> campaign_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllCampaign(Iterable<? extends CampaignProto.Campaign> paramIterable) {
    ensureCampaignIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.campaign_);
  }
  
  private void addCampaign(int paramInt, CampaignProto.Campaign.Builder paramBuilder) {
    ensureCampaignIsMutable();
    this.campaign_.add(paramInt, paramBuilder.build());
  }
  
  private void addCampaign(int paramInt, CampaignProto.Campaign paramCampaign) {
    if (paramCampaign != null) {
      ensureCampaignIsMutable();
      this.campaign_.add(paramInt, paramCampaign);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addCampaign(CampaignProto.Campaign.Builder paramBuilder) {
    ensureCampaignIsMutable();
    this.campaign_.add(paramBuilder.build());
  }
  
  private void addCampaign(CampaignProto.Campaign paramCampaign) {
    if (paramCampaign != null) {
      ensureCampaignIsMutable();
      this.campaign_.add(paramCampaign);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearCampaign() {
    this.campaign_ = emptyProtobufList();
  }
  
  private void ensureCampaignIsMutable() {
    if (!this.campaign_.isModifiable())
      this.campaign_ = GeneratedMessageLite.mutableCopy(this.campaign_); 
  }
  
  public static RolloutExperimentResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(RolloutExperimentResponse paramRolloutExperimentResponse) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramRolloutExperimentResponse);
  }
  
  public static RolloutExperimentResponse parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (RolloutExperimentResponse)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static RolloutExperimentResponse parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RolloutExperimentResponse)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static RolloutExperimentResponse parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (RolloutExperimentResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static RolloutExperimentResponse parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (RolloutExperimentResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static RolloutExperimentResponse parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (RolloutExperimentResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static RolloutExperimentResponse parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RolloutExperimentResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static RolloutExperimentResponse parseFrom(InputStream paramInputStream) throws IOException {
    return (RolloutExperimentResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static RolloutExperimentResponse parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RolloutExperimentResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static RolloutExperimentResponse parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (RolloutExperimentResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static RolloutExperimentResponse parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (RolloutExperimentResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<RolloutExperimentResponse> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeCampaign(int paramInt) {
    ensureCampaignIsMutable();
    this.campaign_.remove(paramInt);
  }
  
  private void setCampaign(int paramInt, CampaignProto.Campaign.Builder paramBuilder) {
    ensureCampaignIsMutable();
    this.campaign_.set(paramInt, paramBuilder.build());
  }
  
  private void setCampaign(int paramInt, CampaignProto.Campaign paramCampaign) {
    if (paramCampaign != null) {
      ensureCampaignIsMutable();
      this.campaign_.set(paramInt, paramCampaign);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/internal/firebase/inappmessaging/v1/RolloutExperimentResponse$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 326, 2 -> 322, 3 -> 311, 4 -> 302, 5 -> 268, 6 -> 110, 7 -> 264, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/internal/firebase/inappmessaging/v1/RolloutExperimentResponse.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/internal/firebase/inappmessaging/v1/RolloutExperimentResponse
    //   72: monitorenter
    //   73: getstatic com/google/internal/firebase/inappmessaging/v1/RolloutExperimentResponse.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/internal/firebase/inappmessaging/v1/RolloutExperimentResponse.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/RolloutExperimentResponse;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/internal/firebase/inappmessaging/v1/RolloutExperimentResponse.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/internal/firebase/inappmessaging/v1/RolloutExperimentResponse
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/internal/firebase/inappmessaging/v1/RolloutExperimentResponse
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/internal/firebase/inappmessaging/v1/RolloutExperimentResponse.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 264
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 208
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
    //   162: getfield campaign_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   165: invokeinterface isModifiable : ()Z
    //   170: ifne -> 184
    //   173: aload_0
    //   174: aload_0
    //   175: getfield campaign_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   178: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   181: putfield campaign_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   184: aload_0
    //   185: getfield campaign_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   188: aload_1
    //   189: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   192: aload_2
    //   193: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   196: checkcast com/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign
    //   199: invokeinterface add : (Ljava/lang/Object;)Z
    //   204: pop
    //   205: goto -> 123
    //   208: iconst_1
    //   209: istore #4
    //   211: goto -> 123
    //   214: astore_1
    //   215: goto -> 262
    //   218: astore_1
    //   219: new java/lang/RuntimeException
    //   222: astore_3
    //   223: new com/google/protobuf/InvalidProtocolBufferException
    //   226: astore_2
    //   227: aload_2
    //   228: aload_1
    //   229: invokevirtual getMessage : ()Ljava/lang/String;
    //   232: invokespecial <init> : (Ljava/lang/String;)V
    //   235: aload_3
    //   236: aload_2
    //   237: aload_0
    //   238: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   241: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   244: aload_3
    //   245: athrow
    //   246: astore_2
    //   247: new java/lang/RuntimeException
    //   250: astore_1
    //   251: aload_1
    //   252: aload_2
    //   253: aload_0
    //   254: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   257: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   260: aload_1
    //   261: athrow
    //   262: aload_1
    //   263: athrow
    //   264: getstatic com/google/internal/firebase/inappmessaging/v1/RolloutExperimentResponse.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/RolloutExperimentResponse;
    //   267: areturn
    //   268: aload_2
    //   269: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   272: astore_1
    //   273: aload_3
    //   274: checkcast com/google/internal/firebase/inappmessaging/v1/RolloutExperimentResponse
    //   277: astore_2
    //   278: aload_0
    //   279: aload_1
    //   280: aload_0
    //   281: getfield campaign_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   284: aload_2
    //   285: getfield campaign_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   288: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   293: putfield campaign_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   296: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   299: astore_1
    //   300: aload_0
    //   301: areturn
    //   302: new com/google/internal/firebase/inappmessaging/v1/RolloutExperimentResponse$Builder
    //   305: dup
    //   306: aconst_null
    //   307: invokespecial <init> : (Lcom/google/internal/firebase/inappmessaging/v1/RolloutExperimentResponse$1;)V
    //   310: areturn
    //   311: aload_0
    //   312: getfield campaign_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   315: invokeinterface makeImmutable : ()V
    //   320: aconst_null
    //   321: areturn
    //   322: getstatic com/google/internal/firebase/inappmessaging/v1/RolloutExperimentResponse.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/RolloutExperimentResponse;
    //   325: areturn
    //   326: new com/google/internal/firebase/inappmessaging/v1/RolloutExperimentResponse
    //   329: dup
    //   330: invokespecial <init> : ()V
    //   333: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	246	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	218	java/io/IOException
    //   128	134	214	finally
    //   146	155	246	com/google/protobuf/InvalidProtocolBufferException
    //   146	155	218	java/io/IOException
    //   146	155	214	finally
    //   161	184	246	com/google/protobuf/InvalidProtocolBufferException
    //   161	184	218	java/io/IOException
    //   161	184	214	finally
    //   184	205	246	com/google/protobuf/InvalidProtocolBufferException
    //   184	205	218	java/io/IOException
    //   184	205	214	finally
    //   219	246	214	finally
    //   247	262	214	finally
  }
  
  public CampaignProto.Campaign getCampaign(int paramInt) {
    return (CampaignProto.Campaign)this.campaign_.get(paramInt);
  }
  
  public int getCampaignCount() {
    return this.campaign_.size();
  }
  
  public List<CampaignProto.Campaign> getCampaignList() {
    return (List<CampaignProto.Campaign>)this.campaign_;
  }
  
  public CampaignProto.CampaignOrBuilder getCampaignOrBuilder(int paramInt) {
    return (CampaignProto.CampaignOrBuilder)this.campaign_.get(paramInt);
  }
  
  public List<? extends CampaignProto.CampaignOrBuilder> getCampaignOrBuilderList() {
    return (List)this.campaign_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    int j = 0;
    while (i < this.campaign_.size()) {
      j += CodedOutputStream.computeMessageSize(1, (MessageLite)this.campaign_.get(i));
      i++;
    } 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (byte b = 0; b < this.campaign_.size(); b++)
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.campaign_.get(b)); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<RolloutExperimentResponse, Builder> implements RolloutExperimentResponseOrBuilder {
    private Builder() {
      super(RolloutExperimentResponse.DEFAULT_INSTANCE);
    }
    
    public Builder addAllCampaign(Iterable<? extends CampaignProto.Campaign> param1Iterable) {
      copyOnWrite();
      ((RolloutExperimentResponse)this.instance).addAllCampaign(param1Iterable);
      return this;
    }
    
    public Builder addCampaign(int param1Int, CampaignProto.Campaign.Builder param1Builder) {
      copyOnWrite();
      ((RolloutExperimentResponse)this.instance).addCampaign(param1Int, param1Builder);
      return this;
    }
    
    public Builder addCampaign(int param1Int, CampaignProto.Campaign param1Campaign) {
      copyOnWrite();
      ((RolloutExperimentResponse)this.instance).addCampaign(param1Int, param1Campaign);
      return this;
    }
    
    public Builder addCampaign(CampaignProto.Campaign.Builder param1Builder) {
      copyOnWrite();
      ((RolloutExperimentResponse)this.instance).addCampaign(param1Builder);
      return this;
    }
    
    public Builder addCampaign(CampaignProto.Campaign param1Campaign) {
      copyOnWrite();
      ((RolloutExperimentResponse)this.instance).addCampaign(param1Campaign);
      return this;
    }
    
    public Builder clearCampaign() {
      copyOnWrite();
      ((RolloutExperimentResponse)this.instance).clearCampaign();
      return this;
    }
    
    public CampaignProto.Campaign getCampaign(int param1Int) {
      return ((RolloutExperimentResponse)this.instance).getCampaign(param1Int);
    }
    
    public int getCampaignCount() {
      return ((RolloutExperimentResponse)this.instance).getCampaignCount();
    }
    
    public List<CampaignProto.Campaign> getCampaignList() {
      return Collections.unmodifiableList(((RolloutExperimentResponse)this.instance).getCampaignList());
    }
    
    public Builder removeCampaign(int param1Int) {
      copyOnWrite();
      ((RolloutExperimentResponse)this.instance).removeCampaign(param1Int);
      return this;
    }
    
    public Builder setCampaign(int param1Int, CampaignProto.Campaign.Builder param1Builder) {
      copyOnWrite();
      ((RolloutExperimentResponse)this.instance).setCampaign(param1Int, param1Builder);
      return this;
    }
    
    public Builder setCampaign(int param1Int, CampaignProto.Campaign param1Campaign) {
      copyOnWrite();
      ((RolloutExperimentResponse)this.instance).setCampaign(param1Int, param1Campaign);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\internal\firebase\inappmessaging\v1\RolloutExperimentResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */