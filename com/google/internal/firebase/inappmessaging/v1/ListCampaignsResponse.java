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

public final class ListCampaignsResponse extends GeneratedMessageLite<ListCampaignsResponse, ListCampaignsResponse.Builder> implements ListCampaignsResponseOrBuilder {
  public static final int CAMPAIGNS_FIELD_NUMBER = 1;
  
  public static final int CAMPAIGN_ANALYTICS_SUMMARY_FIELD_NUMBER = 2;
  
  private static final ListCampaignsResponse DEFAULT_INSTANCE = new ListCampaignsResponse();
  
  private static volatile Parser<ListCampaignsResponse> PARSER;
  
  private Internal.ProtobufList<CampaignAnalyticsSummary> campaignAnalyticsSummary_ = emptyProtobufList();
  
  private Internal.ProtobufList<CampaignProto.Campaign> campaigns_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllCampaignAnalyticsSummary(Iterable<? extends CampaignAnalyticsSummary> paramIterable) {
    ensureCampaignAnalyticsSummaryIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.campaignAnalyticsSummary_);
  }
  
  private void addAllCampaigns(Iterable<? extends CampaignProto.Campaign> paramIterable) {
    ensureCampaignsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.campaigns_);
  }
  
  private void addCampaignAnalyticsSummary(int paramInt, CampaignAnalyticsSummary.Builder paramBuilder) {
    ensureCampaignAnalyticsSummaryIsMutable();
    this.campaignAnalyticsSummary_.add(paramInt, paramBuilder.build());
  }
  
  private void addCampaignAnalyticsSummary(int paramInt, CampaignAnalyticsSummary paramCampaignAnalyticsSummary) {
    if (paramCampaignAnalyticsSummary != null) {
      ensureCampaignAnalyticsSummaryIsMutable();
      this.campaignAnalyticsSummary_.add(paramInt, paramCampaignAnalyticsSummary);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addCampaignAnalyticsSummary(CampaignAnalyticsSummary.Builder paramBuilder) {
    ensureCampaignAnalyticsSummaryIsMutable();
    this.campaignAnalyticsSummary_.add(paramBuilder.build());
  }
  
  private void addCampaignAnalyticsSummary(CampaignAnalyticsSummary paramCampaignAnalyticsSummary) {
    if (paramCampaignAnalyticsSummary != null) {
      ensureCampaignAnalyticsSummaryIsMutable();
      this.campaignAnalyticsSummary_.add(paramCampaignAnalyticsSummary);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addCampaigns(int paramInt, CampaignProto.Campaign.Builder paramBuilder) {
    ensureCampaignsIsMutable();
    this.campaigns_.add(paramInt, paramBuilder.build());
  }
  
  private void addCampaigns(int paramInt, CampaignProto.Campaign paramCampaign) {
    if (paramCampaign != null) {
      ensureCampaignsIsMutable();
      this.campaigns_.add(paramInt, paramCampaign);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addCampaigns(CampaignProto.Campaign.Builder paramBuilder) {
    ensureCampaignsIsMutable();
    this.campaigns_.add(paramBuilder.build());
  }
  
  private void addCampaigns(CampaignProto.Campaign paramCampaign) {
    if (paramCampaign != null) {
      ensureCampaignsIsMutable();
      this.campaigns_.add(paramCampaign);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearCampaignAnalyticsSummary() {
    this.campaignAnalyticsSummary_ = emptyProtobufList();
  }
  
  private void clearCampaigns() {
    this.campaigns_ = emptyProtobufList();
  }
  
  private void ensureCampaignAnalyticsSummaryIsMutable() {
    if (!this.campaignAnalyticsSummary_.isModifiable())
      this.campaignAnalyticsSummary_ = GeneratedMessageLite.mutableCopy(this.campaignAnalyticsSummary_); 
  }
  
  private void ensureCampaignsIsMutable() {
    if (!this.campaigns_.isModifiable())
      this.campaigns_ = GeneratedMessageLite.mutableCopy(this.campaigns_); 
  }
  
  public static ListCampaignsResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ListCampaignsResponse paramListCampaignsResponse) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramListCampaignsResponse);
  }
  
  public static ListCampaignsResponse parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ListCampaignsResponse)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ListCampaignsResponse parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListCampaignsResponse)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListCampaignsResponse parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (ListCampaignsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static ListCampaignsResponse parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListCampaignsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static ListCampaignsResponse parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (ListCampaignsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static ListCampaignsResponse parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListCampaignsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ListCampaignsResponse parseFrom(InputStream paramInputStream) throws IOException {
    return (ListCampaignsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ListCampaignsResponse parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListCampaignsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListCampaignsResponse parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (ListCampaignsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static ListCampaignsResponse parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListCampaignsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ListCampaignsResponse> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeCampaignAnalyticsSummary(int paramInt) {
    ensureCampaignAnalyticsSummaryIsMutable();
    this.campaignAnalyticsSummary_.remove(paramInt);
  }
  
  private void removeCampaigns(int paramInt) {
    ensureCampaignsIsMutable();
    this.campaigns_.remove(paramInt);
  }
  
  private void setCampaignAnalyticsSummary(int paramInt, CampaignAnalyticsSummary.Builder paramBuilder) {
    ensureCampaignAnalyticsSummaryIsMutable();
    this.campaignAnalyticsSummary_.set(paramInt, paramBuilder.build());
  }
  
  private void setCampaignAnalyticsSummary(int paramInt, CampaignAnalyticsSummary paramCampaignAnalyticsSummary) {
    if (paramCampaignAnalyticsSummary != null) {
      ensureCampaignAnalyticsSummaryIsMutable();
      this.campaignAnalyticsSummary_.set(paramInt, paramCampaignAnalyticsSummary);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setCampaigns(int paramInt, CampaignProto.Campaign.Builder paramBuilder) {
    ensureCampaignsIsMutable();
    this.campaigns_.set(paramInt, paramBuilder.build());
  }
  
  private void setCampaigns(int paramInt, CampaignProto.Campaign paramCampaign) {
    if (paramCampaign != null) {
      ensureCampaignsIsMutable();
      this.campaigns_.set(paramInt, paramCampaign);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/internal/firebase/inappmessaging/v1/ListCampaignsResponse$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 407, 2 -> 403, 3 -> 383, 4 -> 374, 5 -> 322, 6 -> 110, 7 -> 318, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/internal/firebase/inappmessaging/v1/ListCampaignsResponse.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/internal/firebase/inappmessaging/v1/ListCampaignsResponse
    //   72: monitorenter
    //   73: getstatic com/google/internal/firebase/inappmessaging/v1/ListCampaignsResponse.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/internal/firebase/inappmessaging/v1/ListCampaignsResponse.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/ListCampaignsResponse;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/internal/firebase/inappmessaging/v1/ListCampaignsResponse.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/internal/firebase/inappmessaging/v1/ListCampaignsResponse
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/internal/firebase/inappmessaging/v1/ListCampaignsResponse
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/internal/firebase/inappmessaging/v1/ListCampaignsResponse.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 318
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 262
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 215
    //   146: iload #5
    //   148: bipush #18
    //   150: if_icmpeq -> 168
    //   153: aload_1
    //   154: iload #5
    //   156: invokevirtual skipField : (I)Z
    //   159: ifne -> 123
    //   162: iconst_1
    //   163: istore #4
    //   165: goto -> 123
    //   168: aload_0
    //   169: getfield campaignAnalyticsSummary_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   172: invokeinterface isModifiable : ()Z
    //   177: ifne -> 191
    //   180: aload_0
    //   181: aload_0
    //   182: getfield campaignAnalyticsSummary_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   185: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   188: putfield campaignAnalyticsSummary_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   191: aload_0
    //   192: getfield campaignAnalyticsSummary_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   195: aload_1
    //   196: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   199: aload_2
    //   200: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   203: checkcast com/google/internal/firebase/inappmessaging/v1/CampaignAnalyticsSummary
    //   206: invokeinterface add : (Ljava/lang/Object;)Z
    //   211: pop
    //   212: goto -> 123
    //   215: aload_0
    //   216: getfield campaigns_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   219: invokeinterface isModifiable : ()Z
    //   224: ifne -> 238
    //   227: aload_0
    //   228: aload_0
    //   229: getfield campaigns_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   232: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   235: putfield campaigns_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   238: aload_0
    //   239: getfield campaigns_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   242: aload_1
    //   243: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   246: aload_2
    //   247: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   250: checkcast com/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign
    //   253: invokeinterface add : (Ljava/lang/Object;)Z
    //   258: pop
    //   259: goto -> 123
    //   262: iconst_1
    //   263: istore #4
    //   265: goto -> 123
    //   268: astore_1
    //   269: goto -> 316
    //   272: astore_3
    //   273: new java/lang/RuntimeException
    //   276: astore_2
    //   277: new com/google/protobuf/InvalidProtocolBufferException
    //   280: astore_1
    //   281: aload_1
    //   282: aload_3
    //   283: invokevirtual getMessage : ()Ljava/lang/String;
    //   286: invokespecial <init> : (Ljava/lang/String;)V
    //   289: aload_2
    //   290: aload_1
    //   291: aload_0
    //   292: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   295: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   298: aload_2
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
    //   318: getstatic com/google/internal/firebase/inappmessaging/v1/ListCampaignsResponse.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/ListCampaignsResponse;
    //   321: areturn
    //   322: aload_2
    //   323: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   326: astore_1
    //   327: aload_3
    //   328: checkcast com/google/internal/firebase/inappmessaging/v1/ListCampaignsResponse
    //   331: astore_2
    //   332: aload_0
    //   333: aload_1
    //   334: aload_0
    //   335: getfield campaigns_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   338: aload_2
    //   339: getfield campaigns_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   342: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   347: putfield campaigns_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   350: aload_0
    //   351: aload_1
    //   352: aload_0
    //   353: getfield campaignAnalyticsSummary_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   356: aload_2
    //   357: getfield campaignAnalyticsSummary_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   360: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   365: putfield campaignAnalyticsSummary_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   368: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   371: astore_1
    //   372: aload_0
    //   373: areturn
    //   374: new com/google/internal/firebase/inappmessaging/v1/ListCampaignsResponse$Builder
    //   377: dup
    //   378: aconst_null
    //   379: invokespecial <init> : (Lcom/google/internal/firebase/inappmessaging/v1/ListCampaignsResponse$1;)V
    //   382: areturn
    //   383: aload_0
    //   384: getfield campaigns_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   387: invokeinterface makeImmutable : ()V
    //   392: aload_0
    //   393: getfield campaignAnalyticsSummary_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   396: invokeinterface makeImmutable : ()V
    //   401: aconst_null
    //   402: areturn
    //   403: getstatic com/google/internal/firebase/inappmessaging/v1/ListCampaignsResponse.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/ListCampaignsResponse;
    //   406: areturn
    //   407: new com/google/internal/firebase/inappmessaging/v1/ListCampaignsResponse
    //   410: dup
    //   411: invokespecial <init> : ()V
    //   414: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	300	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	272	java/io/IOException
    //   128	134	268	finally
    //   153	162	300	com/google/protobuf/InvalidProtocolBufferException
    //   153	162	272	java/io/IOException
    //   153	162	268	finally
    //   168	191	300	com/google/protobuf/InvalidProtocolBufferException
    //   168	191	272	java/io/IOException
    //   168	191	268	finally
    //   191	212	300	com/google/protobuf/InvalidProtocolBufferException
    //   191	212	272	java/io/IOException
    //   191	212	268	finally
    //   215	238	300	com/google/protobuf/InvalidProtocolBufferException
    //   215	238	272	java/io/IOException
    //   215	238	268	finally
    //   238	259	300	com/google/protobuf/InvalidProtocolBufferException
    //   238	259	272	java/io/IOException
    //   238	259	268	finally
    //   273	300	268	finally
    //   301	316	268	finally
  }
  
  public CampaignAnalyticsSummary getCampaignAnalyticsSummary(int paramInt) {
    return (CampaignAnalyticsSummary)this.campaignAnalyticsSummary_.get(paramInt);
  }
  
  public int getCampaignAnalyticsSummaryCount() {
    return this.campaignAnalyticsSummary_.size();
  }
  
  public List<CampaignAnalyticsSummary> getCampaignAnalyticsSummaryList() {
    return (List<CampaignAnalyticsSummary>)this.campaignAnalyticsSummary_;
  }
  
  public CampaignAnalyticsSummaryOrBuilder getCampaignAnalyticsSummaryOrBuilder(int paramInt) {
    return (CampaignAnalyticsSummaryOrBuilder)this.campaignAnalyticsSummary_.get(paramInt);
  }
  
  public List<? extends CampaignAnalyticsSummaryOrBuilder> getCampaignAnalyticsSummaryOrBuilderList() {
    return (List)this.campaignAnalyticsSummary_;
  }
  
  public CampaignProto.Campaign getCampaigns(int paramInt) {
    return (CampaignProto.Campaign)this.campaigns_.get(paramInt);
  }
  
  public int getCampaignsCount() {
    return this.campaigns_.size();
  }
  
  public List<CampaignProto.Campaign> getCampaignsList() {
    return (List<CampaignProto.Campaign>)this.campaigns_;
  }
  
  public CampaignProto.CampaignOrBuilder getCampaignsOrBuilder(int paramInt) {
    return (CampaignProto.CampaignOrBuilder)this.campaigns_.get(paramInt);
  }
  
  public List<? extends CampaignProto.CampaignOrBuilder> getCampaignsOrBuilderList() {
    return (List)this.campaigns_;
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
      if (b2 < this.campaigns_.size()) {
        i += CodedOutputStream.computeMessageSize(1, (MessageLite)this.campaigns_.get(b2));
        b2++;
        continue;
      } 
      break;
    } 
    while (b3 < this.campaignAnalyticsSummary_.size()) {
      j += CodedOutputStream.computeMessageSize(2, (MessageLite)this.campaignAnalyticsSummary_.get(b3));
      b3++;
    } 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    byte b3;
    byte b1 = 0;
    byte b2 = 0;
    while (true) {
      b3 = b1;
      if (b2 < this.campaigns_.size()) {
        paramCodedOutputStream.writeMessage(1, (MessageLite)this.campaigns_.get(b2));
        b2++;
        continue;
      } 
      break;
    } 
    while (b3 < this.campaignAnalyticsSummary_.size()) {
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.campaignAnalyticsSummary_.get(b3));
      b3++;
    } 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ListCampaignsResponse, Builder> implements ListCampaignsResponseOrBuilder {
    private Builder() {
      super(ListCampaignsResponse.DEFAULT_INSTANCE);
    }
    
    public Builder addAllCampaignAnalyticsSummary(Iterable<? extends CampaignAnalyticsSummary> param1Iterable) {
      copyOnWrite();
      ((ListCampaignsResponse)this.instance).addAllCampaignAnalyticsSummary(param1Iterable);
      return this;
    }
    
    public Builder addAllCampaigns(Iterable<? extends CampaignProto.Campaign> param1Iterable) {
      copyOnWrite();
      ((ListCampaignsResponse)this.instance).addAllCampaigns(param1Iterable);
      return this;
    }
    
    public Builder addCampaignAnalyticsSummary(int param1Int, CampaignAnalyticsSummary.Builder param1Builder) {
      copyOnWrite();
      ((ListCampaignsResponse)this.instance).addCampaignAnalyticsSummary(param1Int, param1Builder);
      return this;
    }
    
    public Builder addCampaignAnalyticsSummary(int param1Int, CampaignAnalyticsSummary param1CampaignAnalyticsSummary) {
      copyOnWrite();
      ((ListCampaignsResponse)this.instance).addCampaignAnalyticsSummary(param1Int, param1CampaignAnalyticsSummary);
      return this;
    }
    
    public Builder addCampaignAnalyticsSummary(CampaignAnalyticsSummary.Builder param1Builder) {
      copyOnWrite();
      ((ListCampaignsResponse)this.instance).addCampaignAnalyticsSummary(param1Builder);
      return this;
    }
    
    public Builder addCampaignAnalyticsSummary(CampaignAnalyticsSummary param1CampaignAnalyticsSummary) {
      copyOnWrite();
      ((ListCampaignsResponse)this.instance).addCampaignAnalyticsSummary(param1CampaignAnalyticsSummary);
      return this;
    }
    
    public Builder addCampaigns(int param1Int, CampaignProto.Campaign.Builder param1Builder) {
      copyOnWrite();
      ((ListCampaignsResponse)this.instance).addCampaigns(param1Int, param1Builder);
      return this;
    }
    
    public Builder addCampaigns(int param1Int, CampaignProto.Campaign param1Campaign) {
      copyOnWrite();
      ((ListCampaignsResponse)this.instance).addCampaigns(param1Int, param1Campaign);
      return this;
    }
    
    public Builder addCampaigns(CampaignProto.Campaign.Builder param1Builder) {
      copyOnWrite();
      ((ListCampaignsResponse)this.instance).addCampaigns(param1Builder);
      return this;
    }
    
    public Builder addCampaigns(CampaignProto.Campaign param1Campaign) {
      copyOnWrite();
      ((ListCampaignsResponse)this.instance).addCampaigns(param1Campaign);
      return this;
    }
    
    public Builder clearCampaignAnalyticsSummary() {
      copyOnWrite();
      ((ListCampaignsResponse)this.instance).clearCampaignAnalyticsSummary();
      return this;
    }
    
    public Builder clearCampaigns() {
      copyOnWrite();
      ((ListCampaignsResponse)this.instance).clearCampaigns();
      return this;
    }
    
    public CampaignAnalyticsSummary getCampaignAnalyticsSummary(int param1Int) {
      return ((ListCampaignsResponse)this.instance).getCampaignAnalyticsSummary(param1Int);
    }
    
    public int getCampaignAnalyticsSummaryCount() {
      return ((ListCampaignsResponse)this.instance).getCampaignAnalyticsSummaryCount();
    }
    
    public List<CampaignAnalyticsSummary> getCampaignAnalyticsSummaryList() {
      return Collections.unmodifiableList(((ListCampaignsResponse)this.instance).getCampaignAnalyticsSummaryList());
    }
    
    public CampaignProto.Campaign getCampaigns(int param1Int) {
      return ((ListCampaignsResponse)this.instance).getCampaigns(param1Int);
    }
    
    public int getCampaignsCount() {
      return ((ListCampaignsResponse)this.instance).getCampaignsCount();
    }
    
    public List<CampaignProto.Campaign> getCampaignsList() {
      return Collections.unmodifiableList(((ListCampaignsResponse)this.instance).getCampaignsList());
    }
    
    public Builder removeCampaignAnalyticsSummary(int param1Int) {
      copyOnWrite();
      ((ListCampaignsResponse)this.instance).removeCampaignAnalyticsSummary(param1Int);
      return this;
    }
    
    public Builder removeCampaigns(int param1Int) {
      copyOnWrite();
      ((ListCampaignsResponse)this.instance).removeCampaigns(param1Int);
      return this;
    }
    
    public Builder setCampaignAnalyticsSummary(int param1Int, CampaignAnalyticsSummary.Builder param1Builder) {
      copyOnWrite();
      ((ListCampaignsResponse)this.instance).setCampaignAnalyticsSummary(param1Int, param1Builder);
      return this;
    }
    
    public Builder setCampaignAnalyticsSummary(int param1Int, CampaignAnalyticsSummary param1CampaignAnalyticsSummary) {
      copyOnWrite();
      ((ListCampaignsResponse)this.instance).setCampaignAnalyticsSummary(param1Int, param1CampaignAnalyticsSummary);
      return this;
    }
    
    public Builder setCampaigns(int param1Int, CampaignProto.Campaign.Builder param1Builder) {
      copyOnWrite();
      ((ListCampaignsResponse)this.instance).setCampaigns(param1Int, param1Builder);
      return this;
    }
    
    public Builder setCampaigns(int param1Int, CampaignProto.Campaign param1Campaign) {
      copyOnWrite();
      ((ListCampaignsResponse)this.instance).setCampaigns(param1Int, param1Campaign);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\internal\firebase\inappmessaging\v1\ListCampaignsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */