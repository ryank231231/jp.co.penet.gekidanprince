package com.google.internal.firebase.inappmessaging.v1;

import com.google.firebase.inappmessaging.CommonTypesProto;
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

public final class CampaignAnalyticsSummary extends GeneratedMessageLite<CampaignAnalyticsSummary, CampaignAnalyticsSummary.Builder> implements CampaignAnalyticsSummaryOrBuilder {
  public static final int CAMPAIGN_ID_FIELD_NUMBER = 1;
  
  public static final int DAILY_ANALYTICS_SUMMARY_FIELD_NUMBER = 5;
  
  public static final int DAILY_CONVERSION_SUMMARY_FIELD_NUMBER = 7;
  
  public static final int DATE_RANGE_FIELD_NUMBER = 2;
  
  private static final CampaignAnalyticsSummary DEFAULT_INSTANCE = new CampaignAnalyticsSummary();
  
  private static volatile Parser<CampaignAnalyticsSummary> PARSER;
  
  public static final int TOTAL_CLICKS_FIELD_NUMBER = 4;
  
  public static final int TOTAL_CONVERSIONS_FIELD_NUMBER = 6;
  
  public static final int TOTAL_IMPRESSIONS_FIELD_NUMBER = 3;
  
  private int bitField0_;
  
  private String campaignId_ = "";
  
  private Internal.ProtobufList<CommonTypesProto.DailyAnalyticsSummary> dailyAnalyticsSummary_ = emptyProtobufList();
  
  private Internal.ProtobufList<CommonTypesProto.DailyConversionSummary> dailyConversionSummary_ = emptyProtobufList();
  
  private DateRange dateRange_;
  
  private int totalClicks_;
  
  private int totalConversions_;
  
  private int totalImpressions_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllDailyAnalyticsSummary(Iterable<? extends CommonTypesProto.DailyAnalyticsSummary> paramIterable) {
    ensureDailyAnalyticsSummaryIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.dailyAnalyticsSummary_);
  }
  
  private void addAllDailyConversionSummary(Iterable<? extends CommonTypesProto.DailyConversionSummary> paramIterable) {
    ensureDailyConversionSummaryIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.dailyConversionSummary_);
  }
  
  private void addDailyAnalyticsSummary(int paramInt, CommonTypesProto.DailyAnalyticsSummary.Builder paramBuilder) {
    ensureDailyAnalyticsSummaryIsMutable();
    this.dailyAnalyticsSummary_.add(paramInt, paramBuilder.build());
  }
  
  private void addDailyAnalyticsSummary(int paramInt, CommonTypesProto.DailyAnalyticsSummary paramDailyAnalyticsSummary) {
    if (paramDailyAnalyticsSummary != null) {
      ensureDailyAnalyticsSummaryIsMutable();
      this.dailyAnalyticsSummary_.add(paramInt, paramDailyAnalyticsSummary);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addDailyAnalyticsSummary(CommonTypesProto.DailyAnalyticsSummary.Builder paramBuilder) {
    ensureDailyAnalyticsSummaryIsMutable();
    this.dailyAnalyticsSummary_.add(paramBuilder.build());
  }
  
  private void addDailyAnalyticsSummary(CommonTypesProto.DailyAnalyticsSummary paramDailyAnalyticsSummary) {
    if (paramDailyAnalyticsSummary != null) {
      ensureDailyAnalyticsSummaryIsMutable();
      this.dailyAnalyticsSummary_.add(paramDailyAnalyticsSummary);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addDailyConversionSummary(int paramInt, CommonTypesProto.DailyConversionSummary.Builder paramBuilder) {
    ensureDailyConversionSummaryIsMutable();
    this.dailyConversionSummary_.add(paramInt, paramBuilder.build());
  }
  
  private void addDailyConversionSummary(int paramInt, CommonTypesProto.DailyConversionSummary paramDailyConversionSummary) {
    if (paramDailyConversionSummary != null) {
      ensureDailyConversionSummaryIsMutable();
      this.dailyConversionSummary_.add(paramInt, paramDailyConversionSummary);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addDailyConversionSummary(CommonTypesProto.DailyConversionSummary.Builder paramBuilder) {
    ensureDailyConversionSummaryIsMutable();
    this.dailyConversionSummary_.add(paramBuilder.build());
  }
  
  private void addDailyConversionSummary(CommonTypesProto.DailyConversionSummary paramDailyConversionSummary) {
    if (paramDailyConversionSummary != null) {
      ensureDailyConversionSummaryIsMutable();
      this.dailyConversionSummary_.add(paramDailyConversionSummary);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearCampaignId() {
    this.campaignId_ = getDefaultInstance().getCampaignId();
  }
  
  private void clearDailyAnalyticsSummary() {
    this.dailyAnalyticsSummary_ = emptyProtobufList();
  }
  
  private void clearDailyConversionSummary() {
    this.dailyConversionSummary_ = emptyProtobufList();
  }
  
  private void clearDateRange() {
    this.dateRange_ = null;
  }
  
  private void clearTotalClicks() {
    this.totalClicks_ = 0;
  }
  
  private void clearTotalConversions() {
    this.totalConversions_ = 0;
  }
  
  private void clearTotalImpressions() {
    this.totalImpressions_ = 0;
  }
  
  private void ensureDailyAnalyticsSummaryIsMutable() {
    if (!this.dailyAnalyticsSummary_.isModifiable())
      this.dailyAnalyticsSummary_ = GeneratedMessageLite.mutableCopy(this.dailyAnalyticsSummary_); 
  }
  
  private void ensureDailyConversionSummaryIsMutable() {
    if (!this.dailyConversionSummary_.isModifiable())
      this.dailyConversionSummary_ = GeneratedMessageLite.mutableCopy(this.dailyConversionSummary_); 
  }
  
  public static CampaignAnalyticsSummary getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeDateRange(DateRange paramDateRange) {
    DateRange dateRange = this.dateRange_;
    if (dateRange != null && dateRange != DateRange.getDefaultInstance()) {
      this.dateRange_ = (DateRange)((DateRange.Builder)DateRange.newBuilder(this.dateRange_).mergeFrom(paramDateRange)).buildPartial();
    } else {
      this.dateRange_ = paramDateRange;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(CampaignAnalyticsSummary paramCampaignAnalyticsSummary) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramCampaignAnalyticsSummary);
  }
  
  public static CampaignAnalyticsSummary parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (CampaignAnalyticsSummary)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static CampaignAnalyticsSummary parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (CampaignAnalyticsSummary)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static CampaignAnalyticsSummary parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (CampaignAnalyticsSummary)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static CampaignAnalyticsSummary parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (CampaignAnalyticsSummary)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static CampaignAnalyticsSummary parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (CampaignAnalyticsSummary)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static CampaignAnalyticsSummary parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (CampaignAnalyticsSummary)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static CampaignAnalyticsSummary parseFrom(InputStream paramInputStream) throws IOException {
    return (CampaignAnalyticsSummary)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static CampaignAnalyticsSummary parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (CampaignAnalyticsSummary)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static CampaignAnalyticsSummary parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (CampaignAnalyticsSummary)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static CampaignAnalyticsSummary parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (CampaignAnalyticsSummary)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<CampaignAnalyticsSummary> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeDailyAnalyticsSummary(int paramInt) {
    ensureDailyAnalyticsSummaryIsMutable();
    this.dailyAnalyticsSummary_.remove(paramInt);
  }
  
  private void removeDailyConversionSummary(int paramInt) {
    ensureDailyConversionSummaryIsMutable();
    this.dailyConversionSummary_.remove(paramInt);
  }
  
  private void setCampaignId(String paramString) {
    if (paramString != null) {
      this.campaignId_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setCampaignIdBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.campaignId_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDailyAnalyticsSummary(int paramInt, CommonTypesProto.DailyAnalyticsSummary.Builder paramBuilder) {
    ensureDailyAnalyticsSummaryIsMutable();
    this.dailyAnalyticsSummary_.set(paramInt, paramBuilder.build());
  }
  
  private void setDailyAnalyticsSummary(int paramInt, CommonTypesProto.DailyAnalyticsSummary paramDailyAnalyticsSummary) {
    if (paramDailyAnalyticsSummary != null) {
      ensureDailyAnalyticsSummaryIsMutable();
      this.dailyAnalyticsSummary_.set(paramInt, paramDailyAnalyticsSummary);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDailyConversionSummary(int paramInt, CommonTypesProto.DailyConversionSummary.Builder paramBuilder) {
    ensureDailyConversionSummaryIsMutable();
    this.dailyConversionSummary_.set(paramInt, paramBuilder.build());
  }
  
  private void setDailyConversionSummary(int paramInt, CommonTypesProto.DailyConversionSummary paramDailyConversionSummary) {
    if (paramDailyConversionSummary != null) {
      ensureDailyConversionSummaryIsMutable();
      this.dailyConversionSummary_.set(paramInt, paramDailyConversionSummary);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDateRange(DateRange.Builder paramBuilder) {
    this.dateRange_ = (DateRange)paramBuilder.build();
  }
  
  private void setDateRange(DateRange paramDateRange) {
    if (paramDateRange != null) {
      this.dateRange_ = paramDateRange;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setTotalClicks(int paramInt) {
    this.totalClicks_ = paramInt;
  }
  
  private void setTotalConversions(int paramInt) {
    this.totalConversions_ = paramInt;
  }
  
  private void setTotalImpressions(int paramInt) {
    this.totalImpressions_ = paramInt;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignAnalyticsSummary$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 801, 2 -> 797, 3 -> 777, 4 -> 768, 5 -> 471, 6 -> 118, 7 -> 467, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignAnalyticsSummary.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/internal/firebase/inappmessaging/v1/CampaignAnalyticsSummary
    //   80: monitorenter
    //   81: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignAnalyticsSummary.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignAnalyticsSummary.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/CampaignAnalyticsSummary;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/internal/firebase/inappmessaging/v1/CampaignAnalyticsSummary.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/internal/firebase/inappmessaging/v1/CampaignAnalyticsSummary
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/internal/firebase/inappmessaging/v1/CampaignAnalyticsSummary
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignAnalyticsSummary.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_2
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_3
    //   128: iload #6
    //   130: ifne -> 467
    //   133: aload_2
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 411
    //   144: iload #4
    //   146: bipush #10
    //   148: if_icmpeq -> 400
    //   151: iload #4
    //   153: bipush #18
    //   155: if_icmpeq -> 335
    //   158: iload #4
    //   160: bipush #24
    //   162: if_icmpeq -> 324
    //   165: iload #4
    //   167: bipush #32
    //   169: if_icmpeq -> 313
    //   172: iload #4
    //   174: bipush #42
    //   176: if_icmpeq -> 266
    //   179: iload #4
    //   181: bipush #48
    //   183: if_icmpeq -> 255
    //   186: iload #4
    //   188: bipush #58
    //   190: if_icmpeq -> 208
    //   193: aload_2
    //   194: iload #4
    //   196: invokevirtual skipField : (I)Z
    //   199: ifne -> 128
    //   202: iconst_1
    //   203: istore #6
    //   205: goto -> 128
    //   208: aload_0
    //   209: getfield dailyConversionSummary_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   212: invokeinterface isModifiable : ()Z
    //   217: ifne -> 231
    //   220: aload_0
    //   221: aload_0
    //   222: getfield dailyConversionSummary_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   225: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   228: putfield dailyConversionSummary_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   231: aload_0
    //   232: getfield dailyConversionSummary_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   235: aload_2
    //   236: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   239: aload_3
    //   240: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   243: checkcast com/google/firebase/inappmessaging/CommonTypesProto$DailyConversionSummary
    //   246: invokeinterface add : (Ljava/lang/Object;)Z
    //   251: pop
    //   252: goto -> 128
    //   255: aload_0
    //   256: aload_2
    //   257: invokevirtual readInt32 : ()I
    //   260: putfield totalConversions_ : I
    //   263: goto -> 128
    //   266: aload_0
    //   267: getfield dailyAnalyticsSummary_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   270: invokeinterface isModifiable : ()Z
    //   275: ifne -> 289
    //   278: aload_0
    //   279: aload_0
    //   280: getfield dailyAnalyticsSummary_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   283: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   286: putfield dailyAnalyticsSummary_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   289: aload_0
    //   290: getfield dailyAnalyticsSummary_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   293: aload_2
    //   294: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   297: aload_3
    //   298: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   301: checkcast com/google/firebase/inappmessaging/CommonTypesProto$DailyAnalyticsSummary
    //   304: invokeinterface add : (Ljava/lang/Object;)Z
    //   309: pop
    //   310: goto -> 128
    //   313: aload_0
    //   314: aload_2
    //   315: invokevirtual readInt32 : ()I
    //   318: putfield totalClicks_ : I
    //   321: goto -> 128
    //   324: aload_0
    //   325: aload_2
    //   326: invokevirtual readInt32 : ()I
    //   329: putfield totalImpressions_ : I
    //   332: goto -> 128
    //   335: aload_0
    //   336: getfield dateRange_ : Lcom/google/internal/firebase/inappmessaging/v1/DateRange;
    //   339: ifnull -> 356
    //   342: aload_0
    //   343: getfield dateRange_ : Lcom/google/internal/firebase/inappmessaging/v1/DateRange;
    //   346: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   349: checkcast com/google/internal/firebase/inappmessaging/v1/DateRange$Builder
    //   352: astore_1
    //   353: goto -> 358
    //   356: aconst_null
    //   357: astore_1
    //   358: aload_0
    //   359: aload_2
    //   360: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   363: aload_3
    //   364: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   367: checkcast com/google/internal/firebase/inappmessaging/v1/DateRange
    //   370: putfield dateRange_ : Lcom/google/internal/firebase/inappmessaging/v1/DateRange;
    //   373: aload_1
    //   374: ifnull -> 128
    //   377: aload_1
    //   378: aload_0
    //   379: getfield dateRange_ : Lcom/google/internal/firebase/inappmessaging/v1/DateRange;
    //   382: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   385: pop
    //   386: aload_0
    //   387: aload_1
    //   388: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   391: checkcast com/google/internal/firebase/inappmessaging/v1/DateRange
    //   394: putfield dateRange_ : Lcom/google/internal/firebase/inappmessaging/v1/DateRange;
    //   397: goto -> 128
    //   400: aload_0
    //   401: aload_2
    //   402: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   405: putfield campaignId_ : Ljava/lang/String;
    //   408: goto -> 128
    //   411: iconst_1
    //   412: istore #6
    //   414: goto -> 128
    //   417: astore_1
    //   418: goto -> 465
    //   421: astore_2
    //   422: new java/lang/RuntimeException
    //   425: astore_3
    //   426: new com/google/protobuf/InvalidProtocolBufferException
    //   429: astore_1
    //   430: aload_1
    //   431: aload_2
    //   432: invokevirtual getMessage : ()Ljava/lang/String;
    //   435: invokespecial <init> : (Ljava/lang/String;)V
    //   438: aload_3
    //   439: aload_1
    //   440: aload_0
    //   441: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   444: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   447: aload_3
    //   448: athrow
    //   449: astore_1
    //   450: new java/lang/RuntimeException
    //   453: astore_2
    //   454: aload_2
    //   455: aload_1
    //   456: aload_0
    //   457: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   460: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   463: aload_2
    //   464: athrow
    //   465: aload_1
    //   466: athrow
    //   467: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignAnalyticsSummary.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/CampaignAnalyticsSummary;
    //   470: areturn
    //   471: aload_2
    //   472: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   475: astore_1
    //   476: aload_3
    //   477: checkcast com/google/internal/firebase/inappmessaging/v1/CampaignAnalyticsSummary
    //   480: astore_2
    //   481: aload_0
    //   482: aload_1
    //   483: aload_0
    //   484: getfield campaignId_ : Ljava/lang/String;
    //   487: invokevirtual isEmpty : ()Z
    //   490: iconst_1
    //   491: ixor
    //   492: aload_0
    //   493: getfield campaignId_ : Ljava/lang/String;
    //   496: aload_2
    //   497: getfield campaignId_ : Ljava/lang/String;
    //   500: invokevirtual isEmpty : ()Z
    //   503: iconst_1
    //   504: ixor
    //   505: aload_2
    //   506: getfield campaignId_ : Ljava/lang/String;
    //   509: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   514: putfield campaignId_ : Ljava/lang/String;
    //   517: aload_0
    //   518: aload_1
    //   519: aload_0
    //   520: getfield dateRange_ : Lcom/google/internal/firebase/inappmessaging/v1/DateRange;
    //   523: aload_2
    //   524: getfield dateRange_ : Lcom/google/internal/firebase/inappmessaging/v1/DateRange;
    //   527: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   532: checkcast com/google/internal/firebase/inappmessaging/v1/DateRange
    //   535: putfield dateRange_ : Lcom/google/internal/firebase/inappmessaging/v1/DateRange;
    //   538: aload_0
    //   539: getfield totalImpressions_ : I
    //   542: ifeq -> 551
    //   545: iconst_1
    //   546: istore #7
    //   548: goto -> 554
    //   551: iconst_0
    //   552: istore #7
    //   554: aload_0
    //   555: getfield totalImpressions_ : I
    //   558: istore #6
    //   560: aload_2
    //   561: getfield totalImpressions_ : I
    //   564: ifeq -> 573
    //   567: iconst_1
    //   568: istore #8
    //   570: goto -> 576
    //   573: iconst_0
    //   574: istore #8
    //   576: aload_0
    //   577: aload_1
    //   578: iload #7
    //   580: iload #6
    //   582: iload #8
    //   584: aload_2
    //   585: getfield totalImpressions_ : I
    //   588: invokeinterface visitInt : (ZIZI)I
    //   593: putfield totalImpressions_ : I
    //   596: aload_0
    //   597: getfield totalClicks_ : I
    //   600: ifeq -> 609
    //   603: iconst_1
    //   604: istore #7
    //   606: goto -> 612
    //   609: iconst_0
    //   610: istore #7
    //   612: aload_0
    //   613: getfield totalClicks_ : I
    //   616: istore #6
    //   618: aload_2
    //   619: getfield totalClicks_ : I
    //   622: ifeq -> 631
    //   625: iconst_1
    //   626: istore #8
    //   628: goto -> 634
    //   631: iconst_0
    //   632: istore #8
    //   634: aload_0
    //   635: aload_1
    //   636: iload #7
    //   638: iload #6
    //   640: iload #8
    //   642: aload_2
    //   643: getfield totalClicks_ : I
    //   646: invokeinterface visitInt : (ZIZI)I
    //   651: putfield totalClicks_ : I
    //   654: aload_0
    //   655: aload_1
    //   656: aload_0
    //   657: getfield dailyAnalyticsSummary_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   660: aload_2
    //   661: getfield dailyAnalyticsSummary_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   664: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   669: putfield dailyAnalyticsSummary_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   672: aload_0
    //   673: getfield totalConversions_ : I
    //   676: ifeq -> 685
    //   679: iconst_1
    //   680: istore #7
    //   682: goto -> 688
    //   685: iconst_0
    //   686: istore #7
    //   688: aload_0
    //   689: getfield totalConversions_ : I
    //   692: istore #6
    //   694: iload #5
    //   696: istore #8
    //   698: aload_2
    //   699: getfield totalConversions_ : I
    //   702: ifeq -> 708
    //   705: iconst_1
    //   706: istore #8
    //   708: aload_0
    //   709: aload_1
    //   710: iload #7
    //   712: iload #6
    //   714: iload #8
    //   716: aload_2
    //   717: getfield totalConversions_ : I
    //   720: invokeinterface visitInt : (ZIZI)I
    //   725: putfield totalConversions_ : I
    //   728: aload_0
    //   729: aload_1
    //   730: aload_0
    //   731: getfield dailyConversionSummary_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   734: aload_2
    //   735: getfield dailyConversionSummary_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   738: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   743: putfield dailyConversionSummary_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   746: aload_1
    //   747: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   750: if_acmpne -> 766
    //   753: aload_0
    //   754: aload_0
    //   755: getfield bitField0_ : I
    //   758: aload_2
    //   759: getfield bitField0_ : I
    //   762: ior
    //   763: putfield bitField0_ : I
    //   766: aload_0
    //   767: areturn
    //   768: new com/google/internal/firebase/inappmessaging/v1/CampaignAnalyticsSummary$Builder
    //   771: dup
    //   772: aconst_null
    //   773: invokespecial <init> : (Lcom/google/internal/firebase/inappmessaging/v1/CampaignAnalyticsSummary$1;)V
    //   776: areturn
    //   777: aload_0
    //   778: getfield dailyAnalyticsSummary_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   781: invokeinterface makeImmutable : ()V
    //   786: aload_0
    //   787: getfield dailyConversionSummary_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   790: invokeinterface makeImmutable : ()V
    //   795: aconst_null
    //   796: areturn
    //   797: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignAnalyticsSummary.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/CampaignAnalyticsSummary;
    //   800: areturn
    //   801: new com/google/internal/firebase/inappmessaging/v1/CampaignAnalyticsSummary
    //   804: dup
    //   805: invokespecial <init> : ()V
    //   808: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	449	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	421	java/io/IOException
    //   133	139	417	finally
    //   193	202	449	com/google/protobuf/InvalidProtocolBufferException
    //   193	202	421	java/io/IOException
    //   193	202	417	finally
    //   208	231	449	com/google/protobuf/InvalidProtocolBufferException
    //   208	231	421	java/io/IOException
    //   208	231	417	finally
    //   231	252	449	com/google/protobuf/InvalidProtocolBufferException
    //   231	252	421	java/io/IOException
    //   231	252	417	finally
    //   255	263	449	com/google/protobuf/InvalidProtocolBufferException
    //   255	263	421	java/io/IOException
    //   255	263	417	finally
    //   266	289	449	com/google/protobuf/InvalidProtocolBufferException
    //   266	289	421	java/io/IOException
    //   266	289	417	finally
    //   289	310	449	com/google/protobuf/InvalidProtocolBufferException
    //   289	310	421	java/io/IOException
    //   289	310	417	finally
    //   313	321	449	com/google/protobuf/InvalidProtocolBufferException
    //   313	321	421	java/io/IOException
    //   313	321	417	finally
    //   324	332	449	com/google/protobuf/InvalidProtocolBufferException
    //   324	332	421	java/io/IOException
    //   324	332	417	finally
    //   335	353	449	com/google/protobuf/InvalidProtocolBufferException
    //   335	353	421	java/io/IOException
    //   335	353	417	finally
    //   358	373	449	com/google/protobuf/InvalidProtocolBufferException
    //   358	373	421	java/io/IOException
    //   358	373	417	finally
    //   377	397	449	com/google/protobuf/InvalidProtocolBufferException
    //   377	397	421	java/io/IOException
    //   377	397	417	finally
    //   400	408	449	com/google/protobuf/InvalidProtocolBufferException
    //   400	408	421	java/io/IOException
    //   400	408	417	finally
    //   422	449	417	finally
    //   450	465	417	finally
  }
  
  public String getCampaignId() {
    return this.campaignId_;
  }
  
  public ByteString getCampaignIdBytes() {
    return ByteString.copyFromUtf8(this.campaignId_);
  }
  
  public CommonTypesProto.DailyAnalyticsSummary getDailyAnalyticsSummary(int paramInt) {
    return (CommonTypesProto.DailyAnalyticsSummary)this.dailyAnalyticsSummary_.get(paramInt);
  }
  
  public int getDailyAnalyticsSummaryCount() {
    return this.dailyAnalyticsSummary_.size();
  }
  
  public List<CommonTypesProto.DailyAnalyticsSummary> getDailyAnalyticsSummaryList() {
    return (List<CommonTypesProto.DailyAnalyticsSummary>)this.dailyAnalyticsSummary_;
  }
  
  public CommonTypesProto.DailyAnalyticsSummaryOrBuilder getDailyAnalyticsSummaryOrBuilder(int paramInt) {
    return (CommonTypesProto.DailyAnalyticsSummaryOrBuilder)this.dailyAnalyticsSummary_.get(paramInt);
  }
  
  public List<? extends CommonTypesProto.DailyAnalyticsSummaryOrBuilder> getDailyAnalyticsSummaryOrBuilderList() {
    return (List)this.dailyAnalyticsSummary_;
  }
  
  public CommonTypesProto.DailyConversionSummary getDailyConversionSummary(int paramInt) {
    return (CommonTypesProto.DailyConversionSummary)this.dailyConversionSummary_.get(paramInt);
  }
  
  public int getDailyConversionSummaryCount() {
    return this.dailyConversionSummary_.size();
  }
  
  public List<CommonTypesProto.DailyConversionSummary> getDailyConversionSummaryList() {
    return (List<CommonTypesProto.DailyConversionSummary>)this.dailyConversionSummary_;
  }
  
  public CommonTypesProto.DailyConversionSummaryOrBuilder getDailyConversionSummaryOrBuilder(int paramInt) {
    return (CommonTypesProto.DailyConversionSummaryOrBuilder)this.dailyConversionSummary_.get(paramInt);
  }
  
  public List<? extends CommonTypesProto.DailyConversionSummaryOrBuilder> getDailyConversionSummaryOrBuilderList() {
    return (List)this.dailyConversionSummary_;
  }
  
  public DateRange getDateRange() {
    DateRange dateRange1 = this.dateRange_;
    DateRange dateRange2 = dateRange1;
    if (dateRange1 == null)
      dateRange2 = DateRange.getDefaultInstance(); 
    return dateRange2;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    boolean bool = this.campaignId_.isEmpty();
    boolean bool1 = false;
    if (!bool) {
      i = CodedOutputStream.computeStringSize(1, getCampaignId()) + 0;
    } else {
      i = 0;
    } 
    int j = i;
    if (this.dateRange_ != null)
      j = i + CodedOutputStream.computeMessageSize(2, (MessageLite)getDateRange()); 
    int k = this.totalImpressions_;
    i = j;
    if (k != 0)
      i = j + CodedOutputStream.computeInt32Size(3, k); 
    k = this.totalClicks_;
    j = i;
    if (k != 0)
      j = i + CodedOutputStream.computeInt32Size(4, k); 
    i = j;
    for (j = 0; j < this.dailyAnalyticsSummary_.size(); j++)
      i += CodedOutputStream.computeMessageSize(5, (MessageLite)this.dailyAnalyticsSummary_.get(j)); 
    int m = this.totalConversions_;
    k = bool1;
    j = i;
    if (m != 0) {
      j = i + CodedOutputStream.computeInt32Size(6, m);
      k = bool1;
    } 
    while (k < this.dailyConversionSummary_.size()) {
      j += CodedOutputStream.computeMessageSize(7, (MessageLite)this.dailyConversionSummary_.get(k));
      k++;
    } 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public int getTotalClicks() {
    return this.totalClicks_;
  }
  
  public int getTotalConversions() {
    return this.totalConversions_;
  }
  
  public int getTotalImpressions() {
    return this.totalImpressions_;
  }
  
  public boolean hasDateRange() {
    boolean bool;
    if (this.dateRange_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.campaignId_.isEmpty())
      paramCodedOutputStream.writeString(1, getCampaignId()); 
    if (this.dateRange_ != null)
      paramCodedOutputStream.writeMessage(2, (MessageLite)getDateRange()); 
    int i = this.totalImpressions_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(3, i); 
    i = this.totalClicks_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(4, i); 
    boolean bool = false;
    for (i = 0; i < this.dailyAnalyticsSummary_.size(); i++)
      paramCodedOutputStream.writeMessage(5, (MessageLite)this.dailyAnalyticsSummary_.get(i)); 
    int j = this.totalConversions_;
    i = bool;
    if (j != 0) {
      paramCodedOutputStream.writeInt32(6, j);
      i = bool;
    } 
    while (i < this.dailyConversionSummary_.size()) {
      paramCodedOutputStream.writeMessage(7, (MessageLite)this.dailyConversionSummary_.get(i));
      i++;
    } 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<CampaignAnalyticsSummary, Builder> implements CampaignAnalyticsSummaryOrBuilder {
    private Builder() {
      super(CampaignAnalyticsSummary.DEFAULT_INSTANCE);
    }
    
    public Builder addAllDailyAnalyticsSummary(Iterable<? extends CommonTypesProto.DailyAnalyticsSummary> param1Iterable) {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).addAllDailyAnalyticsSummary(param1Iterable);
      return this;
    }
    
    public Builder addAllDailyConversionSummary(Iterable<? extends CommonTypesProto.DailyConversionSummary> param1Iterable) {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).addAllDailyConversionSummary(param1Iterable);
      return this;
    }
    
    public Builder addDailyAnalyticsSummary(int param1Int, CommonTypesProto.DailyAnalyticsSummary.Builder param1Builder) {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).addDailyAnalyticsSummary(param1Int, param1Builder);
      return this;
    }
    
    public Builder addDailyAnalyticsSummary(int param1Int, CommonTypesProto.DailyAnalyticsSummary param1DailyAnalyticsSummary) {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).addDailyAnalyticsSummary(param1Int, param1DailyAnalyticsSummary);
      return this;
    }
    
    public Builder addDailyAnalyticsSummary(CommonTypesProto.DailyAnalyticsSummary.Builder param1Builder) {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).addDailyAnalyticsSummary(param1Builder);
      return this;
    }
    
    public Builder addDailyAnalyticsSummary(CommonTypesProto.DailyAnalyticsSummary param1DailyAnalyticsSummary) {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).addDailyAnalyticsSummary(param1DailyAnalyticsSummary);
      return this;
    }
    
    public Builder addDailyConversionSummary(int param1Int, CommonTypesProto.DailyConversionSummary.Builder param1Builder) {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).addDailyConversionSummary(param1Int, param1Builder);
      return this;
    }
    
    public Builder addDailyConversionSummary(int param1Int, CommonTypesProto.DailyConversionSummary param1DailyConversionSummary) {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).addDailyConversionSummary(param1Int, param1DailyConversionSummary);
      return this;
    }
    
    public Builder addDailyConversionSummary(CommonTypesProto.DailyConversionSummary.Builder param1Builder) {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).addDailyConversionSummary(param1Builder);
      return this;
    }
    
    public Builder addDailyConversionSummary(CommonTypesProto.DailyConversionSummary param1DailyConversionSummary) {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).addDailyConversionSummary(param1DailyConversionSummary);
      return this;
    }
    
    public Builder clearCampaignId() {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).clearCampaignId();
      return this;
    }
    
    public Builder clearDailyAnalyticsSummary() {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).clearDailyAnalyticsSummary();
      return this;
    }
    
    public Builder clearDailyConversionSummary() {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).clearDailyConversionSummary();
      return this;
    }
    
    public Builder clearDateRange() {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).clearDateRange();
      return this;
    }
    
    public Builder clearTotalClicks() {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).clearTotalClicks();
      return this;
    }
    
    public Builder clearTotalConversions() {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).clearTotalConversions();
      return this;
    }
    
    public Builder clearTotalImpressions() {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).clearTotalImpressions();
      return this;
    }
    
    public String getCampaignId() {
      return ((CampaignAnalyticsSummary)this.instance).getCampaignId();
    }
    
    public ByteString getCampaignIdBytes() {
      return ((CampaignAnalyticsSummary)this.instance).getCampaignIdBytes();
    }
    
    public CommonTypesProto.DailyAnalyticsSummary getDailyAnalyticsSummary(int param1Int) {
      return ((CampaignAnalyticsSummary)this.instance).getDailyAnalyticsSummary(param1Int);
    }
    
    public int getDailyAnalyticsSummaryCount() {
      return ((CampaignAnalyticsSummary)this.instance).getDailyAnalyticsSummaryCount();
    }
    
    public List<CommonTypesProto.DailyAnalyticsSummary> getDailyAnalyticsSummaryList() {
      return Collections.unmodifiableList(((CampaignAnalyticsSummary)this.instance).getDailyAnalyticsSummaryList());
    }
    
    public CommonTypesProto.DailyConversionSummary getDailyConversionSummary(int param1Int) {
      return ((CampaignAnalyticsSummary)this.instance).getDailyConversionSummary(param1Int);
    }
    
    public int getDailyConversionSummaryCount() {
      return ((CampaignAnalyticsSummary)this.instance).getDailyConversionSummaryCount();
    }
    
    public List<CommonTypesProto.DailyConversionSummary> getDailyConversionSummaryList() {
      return Collections.unmodifiableList(((CampaignAnalyticsSummary)this.instance).getDailyConversionSummaryList());
    }
    
    public DateRange getDateRange() {
      return ((CampaignAnalyticsSummary)this.instance).getDateRange();
    }
    
    public int getTotalClicks() {
      return ((CampaignAnalyticsSummary)this.instance).getTotalClicks();
    }
    
    public int getTotalConversions() {
      return ((CampaignAnalyticsSummary)this.instance).getTotalConversions();
    }
    
    public int getTotalImpressions() {
      return ((CampaignAnalyticsSummary)this.instance).getTotalImpressions();
    }
    
    public boolean hasDateRange() {
      return ((CampaignAnalyticsSummary)this.instance).hasDateRange();
    }
    
    public Builder mergeDateRange(DateRange param1DateRange) {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).mergeDateRange(param1DateRange);
      return this;
    }
    
    public Builder removeDailyAnalyticsSummary(int param1Int) {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).removeDailyAnalyticsSummary(param1Int);
      return this;
    }
    
    public Builder removeDailyConversionSummary(int param1Int) {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).removeDailyConversionSummary(param1Int);
      return this;
    }
    
    public Builder setCampaignId(String param1String) {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).setCampaignId(param1String);
      return this;
    }
    
    public Builder setCampaignIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).setCampaignIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setDailyAnalyticsSummary(int param1Int, CommonTypesProto.DailyAnalyticsSummary.Builder param1Builder) {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).setDailyAnalyticsSummary(param1Int, param1Builder);
      return this;
    }
    
    public Builder setDailyAnalyticsSummary(int param1Int, CommonTypesProto.DailyAnalyticsSummary param1DailyAnalyticsSummary) {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).setDailyAnalyticsSummary(param1Int, param1DailyAnalyticsSummary);
      return this;
    }
    
    public Builder setDailyConversionSummary(int param1Int, CommonTypesProto.DailyConversionSummary.Builder param1Builder) {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).setDailyConversionSummary(param1Int, param1Builder);
      return this;
    }
    
    public Builder setDailyConversionSummary(int param1Int, CommonTypesProto.DailyConversionSummary param1DailyConversionSummary) {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).setDailyConversionSummary(param1Int, param1DailyConversionSummary);
      return this;
    }
    
    public Builder setDateRange(DateRange.Builder param1Builder) {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).setDateRange(param1Builder);
      return this;
    }
    
    public Builder setDateRange(DateRange param1DateRange) {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).setDateRange(param1DateRange);
      return this;
    }
    
    public Builder setTotalClicks(int param1Int) {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).setTotalClicks(param1Int);
      return this;
    }
    
    public Builder setTotalConversions(int param1Int) {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).setTotalConversions(param1Int);
      return this;
    }
    
    public Builder setTotalImpressions(int param1Int) {
      copyOnWrite();
      ((CampaignAnalyticsSummary)this.instance).setTotalImpressions(param1Int);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\internal\firebase\inappmessaging\v1\CampaignAnalyticsSummary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */