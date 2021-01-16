package com.google.internal.firebase.inappmessaging.v1.sdkserving;

import com.google.developers.mobile.targeting.proto.ClientSignalsProto;
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

public final class FetchEligibleCampaignsRequest extends GeneratedMessageLite<FetchEligibleCampaignsRequest, FetchEligibleCampaignsRequest.Builder> implements FetchEligibleCampaignsRequestOrBuilder {
  public static final int ALREADY_SEEN_CAMPAIGNS_FIELD_NUMBER = 3;
  
  public static final int CLIENT_SIGNALS_FIELD_NUMBER = 4;
  
  private static final FetchEligibleCampaignsRequest DEFAULT_INSTANCE = new FetchEligibleCampaignsRequest();
  
  private static volatile Parser<FetchEligibleCampaignsRequest> PARSER;
  
  public static final int PROJECT_NUMBER_FIELD_NUMBER = 1;
  
  public static final int REQUESTING_CLIENT_APP_FIELD_NUMBER = 2;
  
  private Internal.ProtobufList<CampaignImpression> alreadySeenCampaigns_ = emptyProtobufList();
  
  private int bitField0_;
  
  private ClientSignalsProto.ClientSignals clientSignals_;
  
  private String projectNumber_ = "";
  
  private ClientAppInfo requestingClientApp_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllAlreadySeenCampaigns(Iterable<? extends CampaignImpression> paramIterable) {
    ensureAlreadySeenCampaignsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.alreadySeenCampaigns_);
  }
  
  private void addAlreadySeenCampaigns(int paramInt, CampaignImpression.Builder paramBuilder) {
    ensureAlreadySeenCampaignsIsMutable();
    this.alreadySeenCampaigns_.add(paramInt, paramBuilder.build());
  }
  
  private void addAlreadySeenCampaigns(int paramInt, CampaignImpression paramCampaignImpression) {
    if (paramCampaignImpression != null) {
      ensureAlreadySeenCampaignsIsMutable();
      this.alreadySeenCampaigns_.add(paramInt, paramCampaignImpression);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addAlreadySeenCampaigns(CampaignImpression.Builder paramBuilder) {
    ensureAlreadySeenCampaignsIsMutable();
    this.alreadySeenCampaigns_.add(paramBuilder.build());
  }
  
  private void addAlreadySeenCampaigns(CampaignImpression paramCampaignImpression) {
    if (paramCampaignImpression != null) {
      ensureAlreadySeenCampaignsIsMutable();
      this.alreadySeenCampaigns_.add(paramCampaignImpression);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearAlreadySeenCampaigns() {
    this.alreadySeenCampaigns_ = emptyProtobufList();
  }
  
  private void clearClientSignals() {
    this.clientSignals_ = null;
  }
  
  private void clearProjectNumber() {
    this.projectNumber_ = getDefaultInstance().getProjectNumber();
  }
  
  private void clearRequestingClientApp() {
    this.requestingClientApp_ = null;
  }
  
  private void ensureAlreadySeenCampaignsIsMutable() {
    if (!this.alreadySeenCampaigns_.isModifiable())
      this.alreadySeenCampaigns_ = GeneratedMessageLite.mutableCopy(this.alreadySeenCampaigns_); 
  }
  
  public static FetchEligibleCampaignsRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeClientSignals(ClientSignalsProto.ClientSignals paramClientSignals) {
    ClientSignalsProto.ClientSignals clientSignals = this.clientSignals_;
    if (clientSignals != null && clientSignals != ClientSignalsProto.ClientSignals.getDefaultInstance()) {
      this.clientSignals_ = (ClientSignalsProto.ClientSignals)((ClientSignalsProto.ClientSignals.Builder)ClientSignalsProto.ClientSignals.newBuilder(this.clientSignals_).mergeFrom((GeneratedMessageLite)paramClientSignals)).buildPartial();
    } else {
      this.clientSignals_ = paramClientSignals;
    } 
  }
  
  private void mergeRequestingClientApp(ClientAppInfo paramClientAppInfo) {
    ClientAppInfo clientAppInfo = this.requestingClientApp_;
    if (clientAppInfo != null && clientAppInfo != ClientAppInfo.getDefaultInstance()) {
      this.requestingClientApp_ = (ClientAppInfo)((ClientAppInfo.Builder)ClientAppInfo.newBuilder(this.requestingClientApp_).mergeFrom(paramClientAppInfo)).buildPartial();
    } else {
      this.requestingClientApp_ = paramClientAppInfo;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(FetchEligibleCampaignsRequest paramFetchEligibleCampaignsRequest) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramFetchEligibleCampaignsRequest);
  }
  
  public static FetchEligibleCampaignsRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (FetchEligibleCampaignsRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static FetchEligibleCampaignsRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (FetchEligibleCampaignsRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FetchEligibleCampaignsRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (FetchEligibleCampaignsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static FetchEligibleCampaignsRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (FetchEligibleCampaignsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static FetchEligibleCampaignsRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (FetchEligibleCampaignsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static FetchEligibleCampaignsRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (FetchEligibleCampaignsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static FetchEligibleCampaignsRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (FetchEligibleCampaignsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static FetchEligibleCampaignsRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (FetchEligibleCampaignsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FetchEligibleCampaignsRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (FetchEligibleCampaignsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static FetchEligibleCampaignsRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (FetchEligibleCampaignsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<FetchEligibleCampaignsRequest> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeAlreadySeenCampaigns(int paramInt) {
    ensureAlreadySeenCampaignsIsMutable();
    this.alreadySeenCampaigns_.remove(paramInt);
  }
  
  private void setAlreadySeenCampaigns(int paramInt, CampaignImpression.Builder paramBuilder) {
    ensureAlreadySeenCampaignsIsMutable();
    this.alreadySeenCampaigns_.set(paramInt, paramBuilder.build());
  }
  
  private void setAlreadySeenCampaigns(int paramInt, CampaignImpression paramCampaignImpression) {
    if (paramCampaignImpression != null) {
      ensureAlreadySeenCampaignsIsMutable();
      this.alreadySeenCampaigns_.set(paramInt, paramCampaignImpression);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setClientSignals(ClientSignalsProto.ClientSignals.Builder paramBuilder) {
    this.clientSignals_ = (ClientSignalsProto.ClientSignals)paramBuilder.build();
  }
  
  private void setClientSignals(ClientSignalsProto.ClientSignals paramClientSignals) {
    if (paramClientSignals != null) {
      this.clientSignals_ = paramClientSignals;
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
  
  private void setRequestingClientApp(ClientAppInfo.Builder paramBuilder) {
    this.requestingClientApp_ = (ClientAppInfo)paramBuilder.build();
  }
  
  private void setRequestingClientApp(ClientAppInfo paramClientAppInfo) {
    if (paramClientAppInfo != null) {
      this.requestingClientApp_ = paramClientAppInfo;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 582, 2 -> 578, 3 -> 567, 4 -> 558, 5 -> 430, 6 -> 110, 7 -> 426, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsRequest.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsRequest
    //   72: monitorenter
    //   73: getstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsRequest.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsRequest.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsRequest;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsRequest.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsRequest
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsRequest
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsRequest.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 426
    //   128: aload_2
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 370
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 359
    //   146: iload #5
    //   148: bipush #18
    //   150: if_icmpeq -> 294
    //   153: iload #5
    //   155: bipush #26
    //   157: if_icmpeq -> 247
    //   160: iload #5
    //   162: bipush #34
    //   164: if_icmpeq -> 182
    //   167: aload_2
    //   168: iload #5
    //   170: invokevirtual skipField : (I)Z
    //   173: ifne -> 123
    //   176: iconst_1
    //   177: istore #4
    //   179: goto -> 123
    //   182: aload_0
    //   183: getfield clientSignals_ : Lcom/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals;
    //   186: ifnull -> 203
    //   189: aload_0
    //   190: getfield clientSignals_ : Lcom/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals;
    //   193: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   196: checkcast com/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals$Builder
    //   199: astore_1
    //   200: goto -> 205
    //   203: aconst_null
    //   204: astore_1
    //   205: aload_0
    //   206: aload_2
    //   207: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   210: aload_3
    //   211: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   214: checkcast com/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals
    //   217: putfield clientSignals_ : Lcom/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals;
    //   220: aload_1
    //   221: ifnull -> 123
    //   224: aload_1
    //   225: aload_0
    //   226: getfield clientSignals_ : Lcom/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals;
    //   229: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   232: pop
    //   233: aload_0
    //   234: aload_1
    //   235: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   238: checkcast com/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals
    //   241: putfield clientSignals_ : Lcom/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals;
    //   244: goto -> 123
    //   247: aload_0
    //   248: getfield alreadySeenCampaigns_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   251: invokeinterface isModifiable : ()Z
    //   256: ifne -> 270
    //   259: aload_0
    //   260: aload_0
    //   261: getfield alreadySeenCampaigns_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   264: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   267: putfield alreadySeenCampaigns_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   270: aload_0
    //   271: getfield alreadySeenCampaigns_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   274: aload_2
    //   275: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   278: aload_3
    //   279: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   282: checkcast com/google/internal/firebase/inappmessaging/v1/sdkserving/CampaignImpression
    //   285: invokeinterface add : (Ljava/lang/Object;)Z
    //   290: pop
    //   291: goto -> 123
    //   294: aload_0
    //   295: getfield requestingClientApp_ : Lcom/google/internal/firebase/inappmessaging/v1/sdkserving/ClientAppInfo;
    //   298: ifnull -> 315
    //   301: aload_0
    //   302: getfield requestingClientApp_ : Lcom/google/internal/firebase/inappmessaging/v1/sdkserving/ClientAppInfo;
    //   305: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   308: checkcast com/google/internal/firebase/inappmessaging/v1/sdkserving/ClientAppInfo$Builder
    //   311: astore_1
    //   312: goto -> 317
    //   315: aconst_null
    //   316: astore_1
    //   317: aload_0
    //   318: aload_2
    //   319: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   322: aload_3
    //   323: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   326: checkcast com/google/internal/firebase/inappmessaging/v1/sdkserving/ClientAppInfo
    //   329: putfield requestingClientApp_ : Lcom/google/internal/firebase/inappmessaging/v1/sdkserving/ClientAppInfo;
    //   332: aload_1
    //   333: ifnull -> 123
    //   336: aload_1
    //   337: aload_0
    //   338: getfield requestingClientApp_ : Lcom/google/internal/firebase/inappmessaging/v1/sdkserving/ClientAppInfo;
    //   341: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   344: pop
    //   345: aload_0
    //   346: aload_1
    //   347: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   350: checkcast com/google/internal/firebase/inappmessaging/v1/sdkserving/ClientAppInfo
    //   353: putfield requestingClientApp_ : Lcom/google/internal/firebase/inappmessaging/v1/sdkserving/ClientAppInfo;
    //   356: goto -> 123
    //   359: aload_0
    //   360: aload_2
    //   361: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   364: putfield projectNumber_ : Ljava/lang/String;
    //   367: goto -> 123
    //   370: iconst_1
    //   371: istore #4
    //   373: goto -> 123
    //   376: astore_1
    //   377: goto -> 424
    //   380: astore_1
    //   381: new java/lang/RuntimeException
    //   384: astore_3
    //   385: new com/google/protobuf/InvalidProtocolBufferException
    //   388: astore_2
    //   389: aload_2
    //   390: aload_1
    //   391: invokevirtual getMessage : ()Ljava/lang/String;
    //   394: invokespecial <init> : (Ljava/lang/String;)V
    //   397: aload_3
    //   398: aload_2
    //   399: aload_0
    //   400: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   403: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   406: aload_3
    //   407: athrow
    //   408: astore_1
    //   409: new java/lang/RuntimeException
    //   412: astore_2
    //   413: aload_2
    //   414: aload_1
    //   415: aload_0
    //   416: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   419: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   422: aload_2
    //   423: athrow
    //   424: aload_1
    //   425: athrow
    //   426: getstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsRequest.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsRequest;
    //   429: areturn
    //   430: aload_2
    //   431: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   434: astore_1
    //   435: aload_3
    //   436: checkcast com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsRequest
    //   439: astore_2
    //   440: aload_0
    //   441: aload_1
    //   442: aload_0
    //   443: getfield projectNumber_ : Ljava/lang/String;
    //   446: invokevirtual isEmpty : ()Z
    //   449: iconst_1
    //   450: ixor
    //   451: aload_0
    //   452: getfield projectNumber_ : Ljava/lang/String;
    //   455: iconst_1
    //   456: aload_2
    //   457: getfield projectNumber_ : Ljava/lang/String;
    //   460: invokevirtual isEmpty : ()Z
    //   463: ixor
    //   464: aload_2
    //   465: getfield projectNumber_ : Ljava/lang/String;
    //   468: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   473: putfield projectNumber_ : Ljava/lang/String;
    //   476: aload_0
    //   477: aload_1
    //   478: aload_0
    //   479: getfield requestingClientApp_ : Lcom/google/internal/firebase/inappmessaging/v1/sdkserving/ClientAppInfo;
    //   482: aload_2
    //   483: getfield requestingClientApp_ : Lcom/google/internal/firebase/inappmessaging/v1/sdkserving/ClientAppInfo;
    //   486: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   491: checkcast com/google/internal/firebase/inappmessaging/v1/sdkserving/ClientAppInfo
    //   494: putfield requestingClientApp_ : Lcom/google/internal/firebase/inappmessaging/v1/sdkserving/ClientAppInfo;
    //   497: aload_0
    //   498: aload_1
    //   499: aload_0
    //   500: getfield alreadySeenCampaigns_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   503: aload_2
    //   504: getfield alreadySeenCampaigns_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   507: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   512: putfield alreadySeenCampaigns_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   515: aload_0
    //   516: aload_1
    //   517: aload_0
    //   518: getfield clientSignals_ : Lcom/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals;
    //   521: aload_2
    //   522: getfield clientSignals_ : Lcom/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals;
    //   525: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   530: checkcast com/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals
    //   533: putfield clientSignals_ : Lcom/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals;
    //   536: aload_1
    //   537: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   540: if_acmpne -> 556
    //   543: aload_0
    //   544: aload_0
    //   545: getfield bitField0_ : I
    //   548: aload_2
    //   549: getfield bitField0_ : I
    //   552: ior
    //   553: putfield bitField0_ : I
    //   556: aload_0
    //   557: areturn
    //   558: new com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsRequest$Builder
    //   561: dup
    //   562: aconst_null
    //   563: invokespecial <init> : (Lcom/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsRequest$1;)V
    //   566: areturn
    //   567: aload_0
    //   568: getfield alreadySeenCampaigns_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   571: invokeinterface makeImmutable : ()V
    //   576: aconst_null
    //   577: areturn
    //   578: getstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsRequest.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsRequest;
    //   581: areturn
    //   582: new com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsRequest
    //   585: dup
    //   586: invokespecial <init> : ()V
    //   589: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	408	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	380	java/io/IOException
    //   128	134	376	finally
    //   167	176	408	com/google/protobuf/InvalidProtocolBufferException
    //   167	176	380	java/io/IOException
    //   167	176	376	finally
    //   182	200	408	com/google/protobuf/InvalidProtocolBufferException
    //   182	200	380	java/io/IOException
    //   182	200	376	finally
    //   205	220	408	com/google/protobuf/InvalidProtocolBufferException
    //   205	220	380	java/io/IOException
    //   205	220	376	finally
    //   224	244	408	com/google/protobuf/InvalidProtocolBufferException
    //   224	244	380	java/io/IOException
    //   224	244	376	finally
    //   247	270	408	com/google/protobuf/InvalidProtocolBufferException
    //   247	270	380	java/io/IOException
    //   247	270	376	finally
    //   270	291	408	com/google/protobuf/InvalidProtocolBufferException
    //   270	291	380	java/io/IOException
    //   270	291	376	finally
    //   294	312	408	com/google/protobuf/InvalidProtocolBufferException
    //   294	312	380	java/io/IOException
    //   294	312	376	finally
    //   317	332	408	com/google/protobuf/InvalidProtocolBufferException
    //   317	332	380	java/io/IOException
    //   317	332	376	finally
    //   336	356	408	com/google/protobuf/InvalidProtocolBufferException
    //   336	356	380	java/io/IOException
    //   336	356	376	finally
    //   359	367	408	com/google/protobuf/InvalidProtocolBufferException
    //   359	367	380	java/io/IOException
    //   359	367	376	finally
    //   381	408	376	finally
    //   409	424	376	finally
  }
  
  public CampaignImpression getAlreadySeenCampaigns(int paramInt) {
    return (CampaignImpression)this.alreadySeenCampaigns_.get(paramInt);
  }
  
  public int getAlreadySeenCampaignsCount() {
    return this.alreadySeenCampaigns_.size();
  }
  
  public List<CampaignImpression> getAlreadySeenCampaignsList() {
    return (List<CampaignImpression>)this.alreadySeenCampaigns_;
  }
  
  public CampaignImpressionOrBuilder getAlreadySeenCampaignsOrBuilder(int paramInt) {
    return (CampaignImpressionOrBuilder)this.alreadySeenCampaigns_.get(paramInt);
  }
  
  public List<? extends CampaignImpressionOrBuilder> getAlreadySeenCampaignsOrBuilderList() {
    return (List)this.alreadySeenCampaigns_;
  }
  
  public ClientSignalsProto.ClientSignals getClientSignals() {
    ClientSignalsProto.ClientSignals clientSignals1 = this.clientSignals_;
    ClientSignalsProto.ClientSignals clientSignals2 = clientSignals1;
    if (clientSignals1 == null)
      clientSignals2 = ClientSignalsProto.ClientSignals.getDefaultInstance(); 
    return clientSignals2;
  }
  
  public String getProjectNumber() {
    return this.projectNumber_;
  }
  
  public ByteString getProjectNumberBytes() {
    return ByteString.copyFromUtf8(this.projectNumber_);
  }
  
  public ClientAppInfo getRequestingClientApp() {
    ClientAppInfo clientAppInfo1 = this.requestingClientApp_;
    ClientAppInfo clientAppInfo2 = clientAppInfo1;
    if (clientAppInfo1 == null)
      clientAppInfo2 = ClientAppInfo.getDefaultInstance(); 
    return clientAppInfo2;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    boolean bool = this.projectNumber_.isEmpty();
    byte b1 = 0;
    if (!bool) {
      j = CodedOutputStream.computeStringSize(1, getProjectNumber()) + 0;
    } else {
      j = 0;
    } 
    i = j;
    byte b2 = b1;
    if (this.requestingClientApp_ != null) {
      i = j + CodedOutputStream.computeMessageSize(2, (MessageLite)getRequestingClientApp());
      b2 = b1;
    } 
    while (b2 < this.alreadySeenCampaigns_.size()) {
      i += CodedOutputStream.computeMessageSize(3, (MessageLite)this.alreadySeenCampaigns_.get(b2));
      b2++;
    } 
    int j = i;
    if (this.clientSignals_ != null)
      j = i + CodedOutputStream.computeMessageSize(4, (MessageLite)getClientSignals()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public boolean hasClientSignals() {
    boolean bool;
    if (this.clientSignals_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasRequestingClientApp() {
    boolean bool;
    if (this.requestingClientApp_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.projectNumber_.isEmpty())
      paramCodedOutputStream.writeString(1, getProjectNumber()); 
    if (this.requestingClientApp_ != null)
      paramCodedOutputStream.writeMessage(2, (MessageLite)getRequestingClientApp()); 
    for (byte b = 0; b < this.alreadySeenCampaigns_.size(); b++)
      paramCodedOutputStream.writeMessage(3, (MessageLite)this.alreadySeenCampaigns_.get(b)); 
    if (this.clientSignals_ != null)
      paramCodedOutputStream.writeMessage(4, (MessageLite)getClientSignals()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<FetchEligibleCampaignsRequest, Builder> implements FetchEligibleCampaignsRequestOrBuilder {
    private Builder() {
      super(FetchEligibleCampaignsRequest.DEFAULT_INSTANCE);
    }
    
    public Builder addAllAlreadySeenCampaigns(Iterable<? extends CampaignImpression> param1Iterable) {
      copyOnWrite();
      ((FetchEligibleCampaignsRequest)this.instance).addAllAlreadySeenCampaigns(param1Iterable);
      return this;
    }
    
    public Builder addAlreadySeenCampaigns(int param1Int, CampaignImpression.Builder param1Builder) {
      copyOnWrite();
      ((FetchEligibleCampaignsRequest)this.instance).addAlreadySeenCampaigns(param1Int, param1Builder);
      return this;
    }
    
    public Builder addAlreadySeenCampaigns(int param1Int, CampaignImpression param1CampaignImpression) {
      copyOnWrite();
      ((FetchEligibleCampaignsRequest)this.instance).addAlreadySeenCampaigns(param1Int, param1CampaignImpression);
      return this;
    }
    
    public Builder addAlreadySeenCampaigns(CampaignImpression.Builder param1Builder) {
      copyOnWrite();
      ((FetchEligibleCampaignsRequest)this.instance).addAlreadySeenCampaigns(param1Builder);
      return this;
    }
    
    public Builder addAlreadySeenCampaigns(CampaignImpression param1CampaignImpression) {
      copyOnWrite();
      ((FetchEligibleCampaignsRequest)this.instance).addAlreadySeenCampaigns(param1CampaignImpression);
      return this;
    }
    
    public Builder clearAlreadySeenCampaigns() {
      copyOnWrite();
      ((FetchEligibleCampaignsRequest)this.instance).clearAlreadySeenCampaigns();
      return this;
    }
    
    public Builder clearClientSignals() {
      copyOnWrite();
      ((FetchEligibleCampaignsRequest)this.instance).clearClientSignals();
      return this;
    }
    
    public Builder clearProjectNumber() {
      copyOnWrite();
      ((FetchEligibleCampaignsRequest)this.instance).clearProjectNumber();
      return this;
    }
    
    public Builder clearRequestingClientApp() {
      copyOnWrite();
      ((FetchEligibleCampaignsRequest)this.instance).clearRequestingClientApp();
      return this;
    }
    
    public CampaignImpression getAlreadySeenCampaigns(int param1Int) {
      return ((FetchEligibleCampaignsRequest)this.instance).getAlreadySeenCampaigns(param1Int);
    }
    
    public int getAlreadySeenCampaignsCount() {
      return ((FetchEligibleCampaignsRequest)this.instance).getAlreadySeenCampaignsCount();
    }
    
    public List<CampaignImpression> getAlreadySeenCampaignsList() {
      return Collections.unmodifiableList(((FetchEligibleCampaignsRequest)this.instance).getAlreadySeenCampaignsList());
    }
    
    public ClientSignalsProto.ClientSignals getClientSignals() {
      return ((FetchEligibleCampaignsRequest)this.instance).getClientSignals();
    }
    
    public String getProjectNumber() {
      return ((FetchEligibleCampaignsRequest)this.instance).getProjectNumber();
    }
    
    public ByteString getProjectNumberBytes() {
      return ((FetchEligibleCampaignsRequest)this.instance).getProjectNumberBytes();
    }
    
    public ClientAppInfo getRequestingClientApp() {
      return ((FetchEligibleCampaignsRequest)this.instance).getRequestingClientApp();
    }
    
    public boolean hasClientSignals() {
      return ((FetchEligibleCampaignsRequest)this.instance).hasClientSignals();
    }
    
    public boolean hasRequestingClientApp() {
      return ((FetchEligibleCampaignsRequest)this.instance).hasRequestingClientApp();
    }
    
    public Builder mergeClientSignals(ClientSignalsProto.ClientSignals param1ClientSignals) {
      copyOnWrite();
      ((FetchEligibleCampaignsRequest)this.instance).mergeClientSignals(param1ClientSignals);
      return this;
    }
    
    public Builder mergeRequestingClientApp(ClientAppInfo param1ClientAppInfo) {
      copyOnWrite();
      ((FetchEligibleCampaignsRequest)this.instance).mergeRequestingClientApp(param1ClientAppInfo);
      return this;
    }
    
    public Builder removeAlreadySeenCampaigns(int param1Int) {
      copyOnWrite();
      ((FetchEligibleCampaignsRequest)this.instance).removeAlreadySeenCampaigns(param1Int);
      return this;
    }
    
    public Builder setAlreadySeenCampaigns(int param1Int, CampaignImpression.Builder param1Builder) {
      copyOnWrite();
      ((FetchEligibleCampaignsRequest)this.instance).setAlreadySeenCampaigns(param1Int, param1Builder);
      return this;
    }
    
    public Builder setAlreadySeenCampaigns(int param1Int, CampaignImpression param1CampaignImpression) {
      copyOnWrite();
      ((FetchEligibleCampaignsRequest)this.instance).setAlreadySeenCampaigns(param1Int, param1CampaignImpression);
      return this;
    }
    
    public Builder setClientSignals(ClientSignalsProto.ClientSignals.Builder param1Builder) {
      copyOnWrite();
      ((FetchEligibleCampaignsRequest)this.instance).setClientSignals(param1Builder);
      return this;
    }
    
    public Builder setClientSignals(ClientSignalsProto.ClientSignals param1ClientSignals) {
      copyOnWrite();
      ((FetchEligibleCampaignsRequest)this.instance).setClientSignals(param1ClientSignals);
      return this;
    }
    
    public Builder setProjectNumber(String param1String) {
      copyOnWrite();
      ((FetchEligibleCampaignsRequest)this.instance).setProjectNumber(param1String);
      return this;
    }
    
    public Builder setProjectNumberBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((FetchEligibleCampaignsRequest)this.instance).setProjectNumberBytes(param1ByteString);
      return this;
    }
    
    public Builder setRequestingClientApp(ClientAppInfo.Builder param1Builder) {
      copyOnWrite();
      ((FetchEligibleCampaignsRequest)this.instance).setRequestingClientApp(param1Builder);
      return this;
    }
    
    public Builder setRequestingClientApp(ClientAppInfo param1ClientAppInfo) {
      copyOnWrite();
      ((FetchEligibleCampaignsRequest)this.instance).setRequestingClientApp(param1ClientAppInfo);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\internal\firebase\inappmessaging\v1\sdkserving\FetchEligibleCampaignsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */