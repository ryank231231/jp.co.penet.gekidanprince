package com.google.firebase.inappmessaging;

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

public final class CampaignAnalytics extends GeneratedMessageLite<CampaignAnalytics, CampaignAnalytics.Builder> implements CampaignAnalyticsOrBuilder {
  public static final int CAMPAIGN_ID_FIELD_NUMBER = 2;
  
  public static final int CLEARCUT_DELIVERY_RETRY_COUNT_FIELD_NUMBER = 10;
  
  public static final int CLIENT_APP_FIELD_NUMBER = 3;
  
  public static final int CLIENT_TIMESTAMP_MILLIS_FIELD_NUMBER = 4;
  
  private static final CampaignAnalytics DEFAULT_INSTANCE = new CampaignAnalytics();
  
  public static final int DISMISS_TYPE_FIELD_NUMBER = 6;
  
  public static final int EVENT_TYPE_FIELD_NUMBER = 5;
  
  public static final int FETCH_ERROR_REASON_FIELD_NUMBER = 8;
  
  public static final int FIAM_SDK_VERSION_FIELD_NUMBER = 9;
  
  private static volatile Parser<CampaignAnalytics> PARSER;
  
  public static final int PROJECT_NUMBER_FIELD_NUMBER = 1;
  
  public static final int RENDER_ERROR_REASON_FIELD_NUMBER = 7;
  
  private int bitField0_;
  
  private String campaignId_ = "";
  
  private int clearcutDeliveryRetryCount_;
  
  private ClientAppInfo clientApp_;
  
  private long clientTimestampMillis_;
  
  private int eventCase_ = 0;
  
  private Object event_;
  
  private String fiamSdkVersion_ = "";
  
  private String projectNumber_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearCampaignId() {
    this.bitField0_ &= 0xFFFFFFFD;
    this.campaignId_ = getDefaultInstance().getCampaignId();
  }
  
  private void clearClearcutDeliveryRetryCount() {
    this.bitField0_ &= 0xFFFFFDFF;
    this.clearcutDeliveryRetryCount_ = 0;
  }
  
  private void clearClientApp() {
    this.clientApp_ = null;
    this.bitField0_ &= 0xFFFFFFFB;
  }
  
  private void clearClientTimestampMillis() {
    this.bitField0_ &= 0xFFFFFFF7;
    this.clientTimestampMillis_ = 0L;
  }
  
  private void clearDismissType() {
    if (this.eventCase_ == 6) {
      this.eventCase_ = 0;
      this.event_ = null;
    } 
  }
  
  private void clearEvent() {
    this.eventCase_ = 0;
    this.event_ = null;
  }
  
  private void clearEventType() {
    if (this.eventCase_ == 5) {
      this.eventCase_ = 0;
      this.event_ = null;
    } 
  }
  
  private void clearFetchErrorReason() {
    if (this.eventCase_ == 8) {
      this.eventCase_ = 0;
      this.event_ = null;
    } 
  }
  
  private void clearFiamSdkVersion() {
    this.bitField0_ &= 0xFFFFFEFF;
    this.fiamSdkVersion_ = getDefaultInstance().getFiamSdkVersion();
  }
  
  private void clearProjectNumber() {
    this.bitField0_ &= 0xFFFFFFFE;
    this.projectNumber_ = getDefaultInstance().getProjectNumber();
  }
  
  private void clearRenderErrorReason() {
    if (this.eventCase_ == 7) {
      this.eventCase_ = 0;
      this.event_ = null;
    } 
  }
  
  public static CampaignAnalytics getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeClientApp(ClientAppInfo paramClientAppInfo) {
    ClientAppInfo clientAppInfo = this.clientApp_;
    if (clientAppInfo != null && clientAppInfo != ClientAppInfo.getDefaultInstance()) {
      this.clientApp_ = (ClientAppInfo)((ClientAppInfo.Builder)ClientAppInfo.newBuilder(this.clientApp_).mergeFrom(paramClientAppInfo)).buildPartial();
    } else {
      this.clientApp_ = paramClientAppInfo;
    } 
    this.bitField0_ |= 0x4;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(CampaignAnalytics paramCampaignAnalytics) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramCampaignAnalytics);
  }
  
  public static CampaignAnalytics parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (CampaignAnalytics)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static CampaignAnalytics parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (CampaignAnalytics)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static CampaignAnalytics parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (CampaignAnalytics)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static CampaignAnalytics parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (CampaignAnalytics)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static CampaignAnalytics parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (CampaignAnalytics)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static CampaignAnalytics parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (CampaignAnalytics)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static CampaignAnalytics parseFrom(InputStream paramInputStream) throws IOException {
    return (CampaignAnalytics)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static CampaignAnalytics parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (CampaignAnalytics)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static CampaignAnalytics parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (CampaignAnalytics)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static CampaignAnalytics parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (CampaignAnalytics)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<CampaignAnalytics> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setCampaignId(String paramString) {
    if (paramString != null) {
      this.bitField0_ |= 0x2;
      this.campaignId_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setCampaignIdBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      this.bitField0_ |= 0x2;
      this.campaignId_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setClearcutDeliveryRetryCount(int paramInt) {
    this.bitField0_ |= 0x200;
    this.clearcutDeliveryRetryCount_ = paramInt;
  }
  
  private void setClientApp(ClientAppInfo.Builder paramBuilder) {
    this.clientApp_ = (ClientAppInfo)paramBuilder.build();
    this.bitField0_ |= 0x4;
  }
  
  private void setClientApp(ClientAppInfo paramClientAppInfo) {
    if (paramClientAppInfo != null) {
      this.clientApp_ = paramClientAppInfo;
      this.bitField0_ |= 0x4;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setClientTimestampMillis(long paramLong) {
    this.bitField0_ |= 0x8;
    this.clientTimestampMillis_ = paramLong;
  }
  
  private void setDismissType(DismissType paramDismissType) {
    if (paramDismissType != null) {
      this.eventCase_ = 6;
      this.event_ = Integer.valueOf(paramDismissType.getNumber());
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setEventType(EventType paramEventType) {
    if (paramEventType != null) {
      this.eventCase_ = 5;
      this.event_ = Integer.valueOf(paramEventType.getNumber());
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setFetchErrorReason(FetchErrorReason paramFetchErrorReason) {
    if (paramFetchErrorReason != null) {
      this.eventCase_ = 8;
      this.event_ = Integer.valueOf(paramFetchErrorReason.getNumber());
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setFiamSdkVersion(String paramString) {
    if (paramString != null) {
      this.bitField0_ |= 0x100;
      this.fiamSdkVersion_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setFiamSdkVersionBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      this.bitField0_ |= 0x100;
      this.fiamSdkVersion_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setProjectNumber(String paramString) {
    if (paramString != null) {
      this.bitField0_ |= 0x1;
      this.projectNumber_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setProjectNumberBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      this.bitField0_ |= 0x1;
      this.projectNumber_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRenderErrorReason(RenderErrorReason paramRenderErrorReason) {
    if (paramRenderErrorReason != null) {
      this.eventCase_ = 7;
      this.event_ = Integer.valueOf(paramRenderErrorReason.getNumber());
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firebase/inappmessaging/CampaignAnalytics$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iconst_0
    //   17: istore #7
    //   19: iconst_0
    //   20: istore #8
    //   22: iconst_0
    //   23: istore #9
    //   25: iconst_0
    //   26: istore #10
    //   28: iload #4
    //   30: tableswitch default -> 76, 1 -> 1134, 2 -> 1130, 3 -> 1128, 4 -> 1119, 5 -> 699, 6 -> 130, 7 -> 695, 8 -> 84
    //   76: new java/lang/UnsupportedOperationException
    //   79: dup
    //   80: invokespecial <init> : ()V
    //   83: athrow
    //   84: getstatic com/google/firebase/inappmessaging/CampaignAnalytics.PARSER : Lcom/google/protobuf/Parser;
    //   87: ifnonnull -> 126
    //   90: ldc com/google/firebase/inappmessaging/CampaignAnalytics
    //   92: monitorenter
    //   93: getstatic com/google/firebase/inappmessaging/CampaignAnalytics.PARSER : Lcom/google/protobuf/Parser;
    //   96: ifnonnull -> 114
    //   99: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   102: astore_1
    //   103: aload_1
    //   104: getstatic com/google/firebase/inappmessaging/CampaignAnalytics.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/CampaignAnalytics;
    //   107: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   110: aload_1
    //   111: putstatic com/google/firebase/inappmessaging/CampaignAnalytics.PARSER : Lcom/google/protobuf/Parser;
    //   114: ldc com/google/firebase/inappmessaging/CampaignAnalytics
    //   116: monitorexit
    //   117: goto -> 126
    //   120: astore_1
    //   121: ldc com/google/firebase/inappmessaging/CampaignAnalytics
    //   123: monitorexit
    //   124: aload_1
    //   125: athrow
    //   126: getstatic com/google/firebase/inappmessaging/CampaignAnalytics.PARSER : Lcom/google/protobuf/Parser;
    //   129: areturn
    //   130: aload_2
    //   131: checkcast com/google/protobuf/CodedInputStream
    //   134: astore_2
    //   135: aload_3
    //   136: checkcast com/google/protobuf/ExtensionRegistryLite
    //   139: astore_3
    //   140: iload #10
    //   142: ifne -> 695
    //   145: aload_2
    //   146: invokevirtual readTag : ()I
    //   149: istore #4
    //   151: iload #4
    //   153: lookupswitch default -> 252, 0 -> 628, 10 -> 605, 18 -> 582, 26 -> 504, 32 -> 482, 40 -> 441, 48 -> 398, 56 -> 355, 64 -> 312, 74 -> 287, 80 -> 264
    //   252: aload_0
    //   253: iload #4
    //   255: aload_2
    //   256: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
    //   259: istore #5
    //   261: goto -> 634
    //   264: aload_0
    //   265: aload_0
    //   266: getfield bitField0_ : I
    //   269: sipush #512
    //   272: ior
    //   273: putfield bitField0_ : I
    //   276: aload_0
    //   277: aload_2
    //   278: invokevirtual readInt32 : ()I
    //   281: putfield clearcutDeliveryRetryCount_ : I
    //   284: goto -> 140
    //   287: aload_2
    //   288: invokevirtual readString : ()Ljava/lang/String;
    //   291: astore_1
    //   292: aload_0
    //   293: aload_0
    //   294: getfield bitField0_ : I
    //   297: sipush #256
    //   300: ior
    //   301: putfield bitField0_ : I
    //   304: aload_0
    //   305: aload_1
    //   306: putfield fiamSdkVersion_ : Ljava/lang/String;
    //   309: goto -> 140
    //   312: aload_2
    //   313: invokevirtual readEnum : ()I
    //   316: istore #4
    //   318: iload #4
    //   320: invokestatic forNumber : (I)Lcom/google/firebase/inappmessaging/FetchErrorReason;
    //   323: ifnonnull -> 337
    //   326: aload_0
    //   327: bipush #8
    //   329: iload #4
    //   331: invokespecial mergeVarintField : (II)V
    //   334: goto -> 140
    //   337: aload_0
    //   338: bipush #8
    //   340: putfield eventCase_ : I
    //   343: aload_0
    //   344: iload #4
    //   346: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   349: putfield event_ : Ljava/lang/Object;
    //   352: goto -> 140
    //   355: aload_2
    //   356: invokevirtual readEnum : ()I
    //   359: istore #4
    //   361: iload #4
    //   363: invokestatic forNumber : (I)Lcom/google/firebase/inappmessaging/RenderErrorReason;
    //   366: ifnonnull -> 380
    //   369: aload_0
    //   370: bipush #7
    //   372: iload #4
    //   374: invokespecial mergeVarintField : (II)V
    //   377: goto -> 140
    //   380: aload_0
    //   381: bipush #7
    //   383: putfield eventCase_ : I
    //   386: aload_0
    //   387: iload #4
    //   389: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   392: putfield event_ : Ljava/lang/Object;
    //   395: goto -> 140
    //   398: aload_2
    //   399: invokevirtual readEnum : ()I
    //   402: istore #4
    //   404: iload #4
    //   406: invokestatic forNumber : (I)Lcom/google/firebase/inappmessaging/DismissType;
    //   409: ifnonnull -> 423
    //   412: aload_0
    //   413: bipush #6
    //   415: iload #4
    //   417: invokespecial mergeVarintField : (II)V
    //   420: goto -> 140
    //   423: aload_0
    //   424: bipush #6
    //   426: putfield eventCase_ : I
    //   429: aload_0
    //   430: iload #4
    //   432: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   435: putfield event_ : Ljava/lang/Object;
    //   438: goto -> 140
    //   441: aload_2
    //   442: invokevirtual readEnum : ()I
    //   445: istore #4
    //   447: iload #4
    //   449: invokestatic forNumber : (I)Lcom/google/firebase/inappmessaging/EventType;
    //   452: ifnonnull -> 465
    //   455: aload_0
    //   456: iconst_5
    //   457: iload #4
    //   459: invokespecial mergeVarintField : (II)V
    //   462: goto -> 140
    //   465: aload_0
    //   466: iconst_5
    //   467: putfield eventCase_ : I
    //   470: aload_0
    //   471: iload #4
    //   473: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   476: putfield event_ : Ljava/lang/Object;
    //   479: goto -> 140
    //   482: aload_0
    //   483: aload_0
    //   484: getfield bitField0_ : I
    //   487: bipush #8
    //   489: ior
    //   490: putfield bitField0_ : I
    //   493: aload_0
    //   494: aload_2
    //   495: invokevirtual readInt64 : ()J
    //   498: putfield clientTimestampMillis_ : J
    //   501: goto -> 140
    //   504: aload_0
    //   505: getfield bitField0_ : I
    //   508: iconst_4
    //   509: iand
    //   510: iconst_4
    //   511: if_icmpne -> 528
    //   514: aload_0
    //   515: getfield clientApp_ : Lcom/google/firebase/inappmessaging/ClientAppInfo;
    //   518: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   521: checkcast com/google/firebase/inappmessaging/ClientAppInfo$Builder
    //   524: astore_1
    //   525: goto -> 530
    //   528: aconst_null
    //   529: astore_1
    //   530: aload_0
    //   531: aload_2
    //   532: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   535: aload_3
    //   536: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   539: checkcast com/google/firebase/inappmessaging/ClientAppInfo
    //   542: putfield clientApp_ : Lcom/google/firebase/inappmessaging/ClientAppInfo;
    //   545: aload_1
    //   546: ifnull -> 569
    //   549: aload_1
    //   550: aload_0
    //   551: getfield clientApp_ : Lcom/google/firebase/inappmessaging/ClientAppInfo;
    //   554: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   557: pop
    //   558: aload_0
    //   559: aload_1
    //   560: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   563: checkcast com/google/firebase/inappmessaging/ClientAppInfo
    //   566: putfield clientApp_ : Lcom/google/firebase/inappmessaging/ClientAppInfo;
    //   569: aload_0
    //   570: aload_0
    //   571: getfield bitField0_ : I
    //   574: iconst_4
    //   575: ior
    //   576: putfield bitField0_ : I
    //   579: goto -> 140
    //   582: aload_2
    //   583: invokevirtual readString : ()Ljava/lang/String;
    //   586: astore_1
    //   587: aload_0
    //   588: aload_0
    //   589: getfield bitField0_ : I
    //   592: iconst_2
    //   593: ior
    //   594: putfield bitField0_ : I
    //   597: aload_0
    //   598: aload_1
    //   599: putfield campaignId_ : Ljava/lang/String;
    //   602: goto -> 140
    //   605: aload_2
    //   606: invokevirtual readString : ()Ljava/lang/String;
    //   609: astore_1
    //   610: aload_0
    //   611: aload_0
    //   612: getfield bitField0_ : I
    //   615: iconst_1
    //   616: ior
    //   617: putfield bitField0_ : I
    //   620: aload_0
    //   621: aload_1
    //   622: putfield projectNumber_ : Ljava/lang/String;
    //   625: goto -> 140
    //   628: iconst_1
    //   629: istore #10
    //   631: goto -> 140
    //   634: iload #5
    //   636: ifne -> 140
    //   639: iconst_1
    //   640: istore #10
    //   642: goto -> 140
    //   645: astore_1
    //   646: goto -> 693
    //   649: astore_3
    //   650: new java/lang/RuntimeException
    //   653: astore_2
    //   654: new com/google/protobuf/InvalidProtocolBufferException
    //   657: astore_1
    //   658: aload_1
    //   659: aload_3
    //   660: invokevirtual getMessage : ()Ljava/lang/String;
    //   663: invokespecial <init> : (Ljava/lang/String;)V
    //   666: aload_2
    //   667: aload_1
    //   668: aload_0
    //   669: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   672: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   675: aload_2
    //   676: athrow
    //   677: astore_2
    //   678: new java/lang/RuntimeException
    //   681: astore_1
    //   682: aload_1
    //   683: aload_2
    //   684: aload_0
    //   685: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   688: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   691: aload_1
    //   692: athrow
    //   693: aload_1
    //   694: athrow
    //   695: getstatic com/google/firebase/inappmessaging/CampaignAnalytics.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/CampaignAnalytics;
    //   698: areturn
    //   699: aload_2
    //   700: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   703: astore_1
    //   704: aload_3
    //   705: checkcast com/google/firebase/inappmessaging/CampaignAnalytics
    //   708: astore_2
    //   709: aload_0
    //   710: aload_1
    //   711: aload_0
    //   712: invokevirtual hasProjectNumber : ()Z
    //   715: aload_0
    //   716: getfield projectNumber_ : Ljava/lang/String;
    //   719: aload_2
    //   720: invokevirtual hasProjectNumber : ()Z
    //   723: aload_2
    //   724: getfield projectNumber_ : Ljava/lang/String;
    //   727: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   732: putfield projectNumber_ : Ljava/lang/String;
    //   735: aload_0
    //   736: aload_1
    //   737: aload_0
    //   738: invokevirtual hasCampaignId : ()Z
    //   741: aload_0
    //   742: getfield campaignId_ : Ljava/lang/String;
    //   745: aload_2
    //   746: invokevirtual hasCampaignId : ()Z
    //   749: aload_2
    //   750: getfield campaignId_ : Ljava/lang/String;
    //   753: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   758: putfield campaignId_ : Ljava/lang/String;
    //   761: aload_0
    //   762: aload_1
    //   763: aload_0
    //   764: getfield clientApp_ : Lcom/google/firebase/inappmessaging/ClientAppInfo;
    //   767: aload_2
    //   768: getfield clientApp_ : Lcom/google/firebase/inappmessaging/ClientAppInfo;
    //   771: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   776: checkcast com/google/firebase/inappmessaging/ClientAppInfo
    //   779: putfield clientApp_ : Lcom/google/firebase/inappmessaging/ClientAppInfo;
    //   782: aload_0
    //   783: aload_1
    //   784: aload_0
    //   785: invokevirtual hasClientTimestampMillis : ()Z
    //   788: aload_0
    //   789: getfield clientTimestampMillis_ : J
    //   792: aload_2
    //   793: invokevirtual hasClientTimestampMillis : ()Z
    //   796: aload_2
    //   797: getfield clientTimestampMillis_ : J
    //   800: invokeinterface visitLong : (ZJZJ)J
    //   805: putfield clientTimestampMillis_ : J
    //   808: aload_0
    //   809: aload_1
    //   810: aload_0
    //   811: invokevirtual hasFiamSdkVersion : ()Z
    //   814: aload_0
    //   815: getfield fiamSdkVersion_ : Ljava/lang/String;
    //   818: aload_2
    //   819: invokevirtual hasFiamSdkVersion : ()Z
    //   822: aload_2
    //   823: getfield fiamSdkVersion_ : Ljava/lang/String;
    //   826: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   831: putfield fiamSdkVersion_ : Ljava/lang/String;
    //   834: aload_0
    //   835: aload_1
    //   836: aload_0
    //   837: invokevirtual hasClearcutDeliveryRetryCount : ()Z
    //   840: aload_0
    //   841: getfield clearcutDeliveryRetryCount_ : I
    //   844: aload_2
    //   845: invokevirtual hasClearcutDeliveryRetryCount : ()Z
    //   848: aload_2
    //   849: getfield clearcutDeliveryRetryCount_ : I
    //   852: invokeinterface visitInt : (ZIZI)I
    //   857: putfield clearcutDeliveryRetryCount_ : I
    //   860: getstatic com/google/firebase/inappmessaging/CampaignAnalytics$1.$SwitchMap$com$google$firebase$inappmessaging$CampaignAnalytics$EventCase : [I
    //   863: aload_2
    //   864: invokevirtual getEventCase : ()Lcom/google/firebase/inappmessaging/CampaignAnalytics$EventCase;
    //   867: invokevirtual ordinal : ()I
    //   870: iaload
    //   871: tableswitch default -> 904, 1 -> 1045, 2 -> 1006, 3 -> 967, 4 -> 928, 5 -> 907
    //   904: goto -> 1080
    //   907: aload_0
    //   908: getfield eventCase_ : I
    //   911: ifeq -> 917
    //   914: iconst_1
    //   915: istore #5
    //   917: aload_1
    //   918: iload #5
    //   920: invokeinterface visitOneofNotSet : (Z)V
    //   925: goto -> 1080
    //   928: iload #6
    //   930: istore #5
    //   932: aload_0
    //   933: getfield eventCase_ : I
    //   936: bipush #8
    //   938: if_icmpne -> 944
    //   941: iconst_1
    //   942: istore #5
    //   944: aload_0
    //   945: aload_1
    //   946: iload #5
    //   948: aload_0
    //   949: getfield event_ : Ljava/lang/Object;
    //   952: aload_2
    //   953: getfield event_ : Ljava/lang/Object;
    //   956: invokeinterface visitOneofInt : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   961: putfield event_ : Ljava/lang/Object;
    //   964: goto -> 1080
    //   967: iload #7
    //   969: istore #5
    //   971: aload_0
    //   972: getfield eventCase_ : I
    //   975: bipush #7
    //   977: if_icmpne -> 983
    //   980: iconst_1
    //   981: istore #5
    //   983: aload_0
    //   984: aload_1
    //   985: iload #5
    //   987: aload_0
    //   988: getfield event_ : Ljava/lang/Object;
    //   991: aload_2
    //   992: getfield event_ : Ljava/lang/Object;
    //   995: invokeinterface visitOneofInt : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1000: putfield event_ : Ljava/lang/Object;
    //   1003: goto -> 1080
    //   1006: iload #8
    //   1008: istore #5
    //   1010: aload_0
    //   1011: getfield eventCase_ : I
    //   1014: bipush #6
    //   1016: if_icmpne -> 1022
    //   1019: iconst_1
    //   1020: istore #5
    //   1022: aload_0
    //   1023: aload_1
    //   1024: iload #5
    //   1026: aload_0
    //   1027: getfield event_ : Ljava/lang/Object;
    //   1030: aload_2
    //   1031: getfield event_ : Ljava/lang/Object;
    //   1034: invokeinterface visitOneofInt : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1039: putfield event_ : Ljava/lang/Object;
    //   1042: goto -> 1080
    //   1045: iload #9
    //   1047: istore #5
    //   1049: aload_0
    //   1050: getfield eventCase_ : I
    //   1053: iconst_5
    //   1054: if_icmpne -> 1060
    //   1057: iconst_1
    //   1058: istore #5
    //   1060: aload_0
    //   1061: aload_1
    //   1062: iload #5
    //   1064: aload_0
    //   1065: getfield event_ : Ljava/lang/Object;
    //   1068: aload_2
    //   1069: getfield event_ : Ljava/lang/Object;
    //   1072: invokeinterface visitOneofInt : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1077: putfield event_ : Ljava/lang/Object;
    //   1080: aload_1
    //   1081: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   1084: if_acmpne -> 1117
    //   1087: aload_2
    //   1088: getfield eventCase_ : I
    //   1091: istore #10
    //   1093: iload #10
    //   1095: ifeq -> 1104
    //   1098: aload_0
    //   1099: iload #10
    //   1101: putfield eventCase_ : I
    //   1104: aload_0
    //   1105: aload_0
    //   1106: getfield bitField0_ : I
    //   1109: aload_2
    //   1110: getfield bitField0_ : I
    //   1113: ior
    //   1114: putfield bitField0_ : I
    //   1117: aload_0
    //   1118: areturn
    //   1119: new com/google/firebase/inappmessaging/CampaignAnalytics$Builder
    //   1122: dup
    //   1123: aconst_null
    //   1124: invokespecial <init> : (Lcom/google/firebase/inappmessaging/CampaignAnalytics$1;)V
    //   1127: areturn
    //   1128: aconst_null
    //   1129: areturn
    //   1130: getstatic com/google/firebase/inappmessaging/CampaignAnalytics.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/CampaignAnalytics;
    //   1133: areturn
    //   1134: new com/google/firebase/inappmessaging/CampaignAnalytics
    //   1137: dup
    //   1138: invokespecial <init> : ()V
    //   1141: areturn
    // Exception table:
    //   from	to	target	type
    //   93	114	120	finally
    //   114	117	120	finally
    //   121	124	120	finally
    //   145	151	677	com/google/protobuf/InvalidProtocolBufferException
    //   145	151	649	java/io/IOException
    //   145	151	645	finally
    //   252	261	677	com/google/protobuf/InvalidProtocolBufferException
    //   252	261	649	java/io/IOException
    //   252	261	645	finally
    //   264	284	677	com/google/protobuf/InvalidProtocolBufferException
    //   264	284	649	java/io/IOException
    //   264	284	645	finally
    //   287	309	677	com/google/protobuf/InvalidProtocolBufferException
    //   287	309	649	java/io/IOException
    //   287	309	645	finally
    //   312	334	677	com/google/protobuf/InvalidProtocolBufferException
    //   312	334	649	java/io/IOException
    //   312	334	645	finally
    //   337	352	677	com/google/protobuf/InvalidProtocolBufferException
    //   337	352	649	java/io/IOException
    //   337	352	645	finally
    //   355	377	677	com/google/protobuf/InvalidProtocolBufferException
    //   355	377	649	java/io/IOException
    //   355	377	645	finally
    //   380	395	677	com/google/protobuf/InvalidProtocolBufferException
    //   380	395	649	java/io/IOException
    //   380	395	645	finally
    //   398	420	677	com/google/protobuf/InvalidProtocolBufferException
    //   398	420	649	java/io/IOException
    //   398	420	645	finally
    //   423	438	677	com/google/protobuf/InvalidProtocolBufferException
    //   423	438	649	java/io/IOException
    //   423	438	645	finally
    //   441	462	677	com/google/protobuf/InvalidProtocolBufferException
    //   441	462	649	java/io/IOException
    //   441	462	645	finally
    //   465	479	677	com/google/protobuf/InvalidProtocolBufferException
    //   465	479	649	java/io/IOException
    //   465	479	645	finally
    //   482	501	677	com/google/protobuf/InvalidProtocolBufferException
    //   482	501	649	java/io/IOException
    //   482	501	645	finally
    //   504	525	677	com/google/protobuf/InvalidProtocolBufferException
    //   504	525	649	java/io/IOException
    //   504	525	645	finally
    //   530	545	677	com/google/protobuf/InvalidProtocolBufferException
    //   530	545	649	java/io/IOException
    //   530	545	645	finally
    //   549	569	677	com/google/protobuf/InvalidProtocolBufferException
    //   549	569	649	java/io/IOException
    //   549	569	645	finally
    //   569	579	677	com/google/protobuf/InvalidProtocolBufferException
    //   569	579	649	java/io/IOException
    //   569	579	645	finally
    //   582	602	677	com/google/protobuf/InvalidProtocolBufferException
    //   582	602	649	java/io/IOException
    //   582	602	645	finally
    //   605	625	677	com/google/protobuf/InvalidProtocolBufferException
    //   605	625	649	java/io/IOException
    //   605	625	645	finally
    //   650	677	645	finally
    //   678	693	645	finally
  }
  
  public String getCampaignId() {
    return this.campaignId_;
  }
  
  public ByteString getCampaignIdBytes() {
    return ByteString.copyFromUtf8(this.campaignId_);
  }
  
  public int getClearcutDeliveryRetryCount() {
    return this.clearcutDeliveryRetryCount_;
  }
  
  public ClientAppInfo getClientApp() {
    ClientAppInfo clientAppInfo1 = this.clientApp_;
    ClientAppInfo clientAppInfo2 = clientAppInfo1;
    if (clientAppInfo1 == null)
      clientAppInfo2 = ClientAppInfo.getDefaultInstance(); 
    return clientAppInfo2;
  }
  
  public long getClientTimestampMillis() {
    return this.clientTimestampMillis_;
  }
  
  public DismissType getDismissType() {
    if (this.eventCase_ == 6) {
      DismissType dismissType1 = DismissType.forNumber(((Integer)this.event_).intValue());
      DismissType dismissType2 = dismissType1;
      if (dismissType1 == null)
        dismissType2 = DismissType.UNKNOWN_DISMISS_TYPE; 
      return dismissType2;
    } 
    return DismissType.UNKNOWN_DISMISS_TYPE;
  }
  
  public EventCase getEventCase() {
    return EventCase.forNumber(this.eventCase_);
  }
  
  public EventType getEventType() {
    if (this.eventCase_ == 5) {
      EventType eventType1 = EventType.forNumber(((Integer)this.event_).intValue());
      EventType eventType2 = eventType1;
      if (eventType1 == null)
        eventType2 = EventType.UNKNOWN_EVENT_TYPE; 
      return eventType2;
    } 
    return EventType.UNKNOWN_EVENT_TYPE;
  }
  
  public FetchErrorReason getFetchErrorReason() {
    if (this.eventCase_ == 8) {
      FetchErrorReason fetchErrorReason1 = FetchErrorReason.forNumber(((Integer)this.event_).intValue());
      FetchErrorReason fetchErrorReason2 = fetchErrorReason1;
      if (fetchErrorReason1 == null)
        fetchErrorReason2 = FetchErrorReason.UNSPECIFIED_FETCH_ERROR; 
      return fetchErrorReason2;
    } 
    return FetchErrorReason.UNSPECIFIED_FETCH_ERROR;
  }
  
  public String getFiamSdkVersion() {
    return this.fiamSdkVersion_;
  }
  
  public ByteString getFiamSdkVersionBytes() {
    return ByteString.copyFromUtf8(this.fiamSdkVersion_);
  }
  
  public String getProjectNumber() {
    return this.projectNumber_;
  }
  
  public ByteString getProjectNumberBytes() {
    return ByteString.copyFromUtf8(this.projectNumber_);
  }
  
  public RenderErrorReason getRenderErrorReason() {
    if (this.eventCase_ == 7) {
      RenderErrorReason renderErrorReason1 = RenderErrorReason.forNumber(((Integer)this.event_).intValue());
      RenderErrorReason renderErrorReason2 = renderErrorReason1;
      if (renderErrorReason1 == null)
        renderErrorReason2 = RenderErrorReason.UNSPECIFIED_RENDER_ERROR; 
      return renderErrorReason2;
    } 
    return RenderErrorReason.UNSPECIFIED_RENDER_ERROR;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if ((this.bitField0_ & 0x1) == 1)
      i = 0 + CodedOutputStream.computeStringSize(1, getProjectNumber()); 
    int j = i;
    if ((this.bitField0_ & 0x2) == 2)
      j = i + CodedOutputStream.computeStringSize(2, getCampaignId()); 
    i = j;
    if ((this.bitField0_ & 0x4) == 4)
      i = j + CodedOutputStream.computeMessageSize(3, (MessageLite)getClientApp()); 
    j = i;
    if ((this.bitField0_ & 0x8) == 8)
      j = i + CodedOutputStream.computeInt64Size(4, this.clientTimestampMillis_); 
    int k = j;
    if (this.eventCase_ == 5)
      k = j + CodedOutputStream.computeEnumSize(5, ((Integer)this.event_).intValue()); 
    i = k;
    if (this.eventCase_ == 6)
      i = k + CodedOutputStream.computeEnumSize(6, ((Integer)this.event_).intValue()); 
    j = i;
    if (this.eventCase_ == 7)
      j = i + CodedOutputStream.computeEnumSize(7, ((Integer)this.event_).intValue()); 
    i = j;
    if (this.eventCase_ == 8)
      i = j + CodedOutputStream.computeEnumSize(8, ((Integer)this.event_).intValue()); 
    j = i;
    if ((this.bitField0_ & 0x100) == 256)
      j = i + CodedOutputStream.computeStringSize(9, getFiamSdkVersion()); 
    i = j;
    if ((this.bitField0_ & 0x200) == 512)
      i = j + CodedOutputStream.computeInt32Size(10, this.clearcutDeliveryRetryCount_); 
    i += this.unknownFields.getSerializedSize();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public boolean hasCampaignId() {
    boolean bool;
    if ((this.bitField0_ & 0x2) == 2) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasClearcutDeliveryRetryCount() {
    boolean bool;
    if ((this.bitField0_ & 0x200) == 512) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasClientApp() {
    boolean bool;
    if ((this.bitField0_ & 0x4) == 4) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasClientTimestampMillis() {
    boolean bool;
    if ((this.bitField0_ & 0x8) == 8) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasDismissType() {
    boolean bool;
    if (this.eventCase_ == 6) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasEventType() {
    boolean bool;
    if (this.eventCase_ == 5) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasFetchErrorReason() {
    boolean bool;
    if (this.eventCase_ == 8) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasFiamSdkVersion() {
    boolean bool;
    if ((this.bitField0_ & 0x100) == 256) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasProjectNumber() {
    int i = this.bitField0_;
    boolean bool = true;
    if ((i & 0x1) != 1)
      bool = false; 
    return bool;
  }
  
  public boolean hasRenderErrorReason() {
    boolean bool;
    if (this.eventCase_ == 7) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if ((this.bitField0_ & 0x1) == 1)
      paramCodedOutputStream.writeString(1, getProjectNumber()); 
    if ((this.bitField0_ & 0x2) == 2)
      paramCodedOutputStream.writeString(2, getCampaignId()); 
    if ((this.bitField0_ & 0x4) == 4)
      paramCodedOutputStream.writeMessage(3, (MessageLite)getClientApp()); 
    if ((this.bitField0_ & 0x8) == 8)
      paramCodedOutputStream.writeInt64(4, this.clientTimestampMillis_); 
    if (this.eventCase_ == 5)
      paramCodedOutputStream.writeEnum(5, ((Integer)this.event_).intValue()); 
    if (this.eventCase_ == 6)
      paramCodedOutputStream.writeEnum(6, ((Integer)this.event_).intValue()); 
    if (this.eventCase_ == 7)
      paramCodedOutputStream.writeEnum(7, ((Integer)this.event_).intValue()); 
    if (this.eventCase_ == 8)
      paramCodedOutputStream.writeEnum(8, ((Integer)this.event_).intValue()); 
    if ((this.bitField0_ & 0x100) == 256)
      paramCodedOutputStream.writeString(9, getFiamSdkVersion()); 
    if ((this.bitField0_ & 0x200) == 512)
      paramCodedOutputStream.writeInt32(10, this.clearcutDeliveryRetryCount_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<CampaignAnalytics, Builder> implements CampaignAnalyticsOrBuilder {
    private Builder() {
      super(CampaignAnalytics.DEFAULT_INSTANCE);
    }
    
    public Builder clearCampaignId() {
      copyOnWrite();
      ((CampaignAnalytics)this.instance).clearCampaignId();
      return this;
    }
    
    public Builder clearClearcutDeliveryRetryCount() {
      copyOnWrite();
      ((CampaignAnalytics)this.instance).clearClearcutDeliveryRetryCount();
      return this;
    }
    
    public Builder clearClientApp() {
      copyOnWrite();
      ((CampaignAnalytics)this.instance).clearClientApp();
      return this;
    }
    
    public Builder clearClientTimestampMillis() {
      copyOnWrite();
      ((CampaignAnalytics)this.instance).clearClientTimestampMillis();
      return this;
    }
    
    public Builder clearDismissType() {
      copyOnWrite();
      ((CampaignAnalytics)this.instance).clearDismissType();
      return this;
    }
    
    public Builder clearEvent() {
      copyOnWrite();
      ((CampaignAnalytics)this.instance).clearEvent();
      return this;
    }
    
    public Builder clearEventType() {
      copyOnWrite();
      ((CampaignAnalytics)this.instance).clearEventType();
      return this;
    }
    
    public Builder clearFetchErrorReason() {
      copyOnWrite();
      ((CampaignAnalytics)this.instance).clearFetchErrorReason();
      return this;
    }
    
    public Builder clearFiamSdkVersion() {
      copyOnWrite();
      ((CampaignAnalytics)this.instance).clearFiamSdkVersion();
      return this;
    }
    
    public Builder clearProjectNumber() {
      copyOnWrite();
      ((CampaignAnalytics)this.instance).clearProjectNumber();
      return this;
    }
    
    public Builder clearRenderErrorReason() {
      copyOnWrite();
      ((CampaignAnalytics)this.instance).clearRenderErrorReason();
      return this;
    }
    
    public String getCampaignId() {
      return ((CampaignAnalytics)this.instance).getCampaignId();
    }
    
    public ByteString getCampaignIdBytes() {
      return ((CampaignAnalytics)this.instance).getCampaignIdBytes();
    }
    
    public int getClearcutDeliveryRetryCount() {
      return ((CampaignAnalytics)this.instance).getClearcutDeliveryRetryCount();
    }
    
    public ClientAppInfo getClientApp() {
      return ((CampaignAnalytics)this.instance).getClientApp();
    }
    
    public long getClientTimestampMillis() {
      return ((CampaignAnalytics)this.instance).getClientTimestampMillis();
    }
    
    public DismissType getDismissType() {
      return ((CampaignAnalytics)this.instance).getDismissType();
    }
    
    public CampaignAnalytics.EventCase getEventCase() {
      return ((CampaignAnalytics)this.instance).getEventCase();
    }
    
    public EventType getEventType() {
      return ((CampaignAnalytics)this.instance).getEventType();
    }
    
    public FetchErrorReason getFetchErrorReason() {
      return ((CampaignAnalytics)this.instance).getFetchErrorReason();
    }
    
    public String getFiamSdkVersion() {
      return ((CampaignAnalytics)this.instance).getFiamSdkVersion();
    }
    
    public ByteString getFiamSdkVersionBytes() {
      return ((CampaignAnalytics)this.instance).getFiamSdkVersionBytes();
    }
    
    public String getProjectNumber() {
      return ((CampaignAnalytics)this.instance).getProjectNumber();
    }
    
    public ByteString getProjectNumberBytes() {
      return ((CampaignAnalytics)this.instance).getProjectNumberBytes();
    }
    
    public RenderErrorReason getRenderErrorReason() {
      return ((CampaignAnalytics)this.instance).getRenderErrorReason();
    }
    
    public boolean hasCampaignId() {
      return ((CampaignAnalytics)this.instance).hasCampaignId();
    }
    
    public boolean hasClearcutDeliveryRetryCount() {
      return ((CampaignAnalytics)this.instance).hasClearcutDeliveryRetryCount();
    }
    
    public boolean hasClientApp() {
      return ((CampaignAnalytics)this.instance).hasClientApp();
    }
    
    public boolean hasClientTimestampMillis() {
      return ((CampaignAnalytics)this.instance).hasClientTimestampMillis();
    }
    
    public boolean hasDismissType() {
      return ((CampaignAnalytics)this.instance).hasDismissType();
    }
    
    public boolean hasEventType() {
      return ((CampaignAnalytics)this.instance).hasEventType();
    }
    
    public boolean hasFetchErrorReason() {
      return ((CampaignAnalytics)this.instance).hasFetchErrorReason();
    }
    
    public boolean hasFiamSdkVersion() {
      return ((CampaignAnalytics)this.instance).hasFiamSdkVersion();
    }
    
    public boolean hasProjectNumber() {
      return ((CampaignAnalytics)this.instance).hasProjectNumber();
    }
    
    public boolean hasRenderErrorReason() {
      return ((CampaignAnalytics)this.instance).hasRenderErrorReason();
    }
    
    public Builder mergeClientApp(ClientAppInfo param1ClientAppInfo) {
      copyOnWrite();
      ((CampaignAnalytics)this.instance).mergeClientApp(param1ClientAppInfo);
      return this;
    }
    
    public Builder setCampaignId(String param1String) {
      copyOnWrite();
      ((CampaignAnalytics)this.instance).setCampaignId(param1String);
      return this;
    }
    
    public Builder setCampaignIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((CampaignAnalytics)this.instance).setCampaignIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setClearcutDeliveryRetryCount(int param1Int) {
      copyOnWrite();
      ((CampaignAnalytics)this.instance).setClearcutDeliveryRetryCount(param1Int);
      return this;
    }
    
    public Builder setClientApp(ClientAppInfo.Builder param1Builder) {
      copyOnWrite();
      ((CampaignAnalytics)this.instance).setClientApp(param1Builder);
      return this;
    }
    
    public Builder setClientApp(ClientAppInfo param1ClientAppInfo) {
      copyOnWrite();
      ((CampaignAnalytics)this.instance).setClientApp(param1ClientAppInfo);
      return this;
    }
    
    public Builder setClientTimestampMillis(long param1Long) {
      copyOnWrite();
      ((CampaignAnalytics)this.instance).setClientTimestampMillis(param1Long);
      return this;
    }
    
    public Builder setDismissType(DismissType param1DismissType) {
      copyOnWrite();
      ((CampaignAnalytics)this.instance).setDismissType(param1DismissType);
      return this;
    }
    
    public Builder setEventType(EventType param1EventType) {
      copyOnWrite();
      ((CampaignAnalytics)this.instance).setEventType(param1EventType);
      return this;
    }
    
    public Builder setFetchErrorReason(FetchErrorReason param1FetchErrorReason) {
      copyOnWrite();
      ((CampaignAnalytics)this.instance).setFetchErrorReason(param1FetchErrorReason);
      return this;
    }
    
    public Builder setFiamSdkVersion(String param1String) {
      copyOnWrite();
      ((CampaignAnalytics)this.instance).setFiamSdkVersion(param1String);
      return this;
    }
    
    public Builder setFiamSdkVersionBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((CampaignAnalytics)this.instance).setFiamSdkVersionBytes(param1ByteString);
      return this;
    }
    
    public Builder setProjectNumber(String param1String) {
      copyOnWrite();
      ((CampaignAnalytics)this.instance).setProjectNumber(param1String);
      return this;
    }
    
    public Builder setProjectNumberBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((CampaignAnalytics)this.instance).setProjectNumberBytes(param1ByteString);
      return this;
    }
    
    public Builder setRenderErrorReason(RenderErrorReason param1RenderErrorReason) {
      copyOnWrite();
      ((CampaignAnalytics)this.instance).setRenderErrorReason(param1RenderErrorReason);
      return this;
    }
  }
  
  public enum EventCase implements Internal.EnumLite {
    DISMISS_TYPE,
    EVENT_NOT_SET,
    EVENT_TYPE(5),
    FETCH_ERROR_REASON(5),
    RENDER_ERROR_REASON(5);
    
    private final int value;
    
    static {
      FETCH_ERROR_REASON = new EventCase("FETCH_ERROR_REASON", 3, 8);
      EVENT_NOT_SET = new EventCase("EVENT_NOT_SET", 4, 0);
      $VALUES = new EventCase[] { EVENT_TYPE, DISMISS_TYPE, RENDER_ERROR_REASON, FETCH_ERROR_REASON, EVENT_NOT_SET };
    }
    
    EventCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static EventCase forNumber(int param1Int) {
      if (param1Int != 0) {
        switch (param1Int) {
          default:
            return null;
          case 8:
            return FETCH_ERROR_REASON;
          case 7:
            return RENDER_ERROR_REASON;
          case 6:
            return DISMISS_TYPE;
          case 5:
            break;
        } 
        return EVENT_TYPE;
      } 
      return EVENT_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\CampaignAnalytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */