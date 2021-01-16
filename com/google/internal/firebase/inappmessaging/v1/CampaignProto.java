package com.google.internal.firebase.inappmessaging.v1;

import com.google.developers.mobile.targeting.proto.Conditions;
import com.google.firebase.inappmessaging.CommonTypesProto;
import com.google.firebase.inappmessaging.MessagesProto;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import developers.mobile.abt.FirebaseAbt;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class CampaignProto {
  static {
  
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class Campaign extends GeneratedMessageLite<Campaign, Campaign.Builder> implements CampaignOrBuilder {
    public static final int CAMPAIGN_ID_FIELD_NUMBER = 2;
    
    public static final int CONTENT_FIELD_NUMBER = 11;
    
    public static final int CONVERSION_EVENT_FIELD_NUMBER = 12;
    
    private static final Campaign DEFAULT_INSTANCE = new Campaign();
    
    public static final int DESCRIPTION_FIELD_NUMBER = 5;
    
    public static final int DISPLAY_NAME_FIELD_NUMBER = 4;
    
    private static volatile Parser<Campaign> PARSER;
    
    public static final int PRIORITY_FIELD_NUMBER = 10;
    
    public static final int PROJECT_NUMBER_FIELD_NUMBER = 1;
    
    public static final int SCHEDULED_END_TIMESTAMP_FIELD_NUMBER = 14;
    
    public static final int SCHEDULED_END_TIME_FIELD_NUMBER = 7;
    
    public static final int SCHEDULED_START_TIMESTAMP_FIELD_NUMBER = 13;
    
    public static final int SCHEDULED_START_TIME_FIELD_NUMBER = 6;
    
    public static final int STATE_FIELD_NUMBER = 3;
    
    public static final int TARGETING_CONDITION_FIELD_NUMBER = 8;
    
    public static final int TRIGGERING_CONDITIONS_FIELD_NUMBER = 9;
    
    private int bitField0_;
    
    private String campaignId_ = "";
    
    private MessagesProto.Content content_;
    
    private Internal.ProtobufList<CommonTypesProto.ScionConversionEvent> conversionEvent_ = emptyProtobufList();
    
    private String description_ = "";
    
    private String displayName_ = "";
    
    private CommonTypesProto.Priority priority_;
    
    private String projectNumber_ = "";
    
    private CommonTypesProto.CampaignTime scheduledEndTime_;
    
    private Timestamp scheduledEndTimestamp_;
    
    private CommonTypesProto.CampaignTime scheduledStartTime_;
    
    private Timestamp scheduledStartTimestamp_;
    
    private int state_;
    
    private Conditions.Condition targetingCondition_;
    
    private Internal.ProtobufList<CommonTypesProto.TriggeringCondition> triggeringConditions_ = emptyProtobufList();
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllConversionEvent(Iterable<? extends CommonTypesProto.ScionConversionEvent> param1Iterable) {
      ensureConversionEventIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.conversionEvent_);
    }
    
    private void addAllTriggeringConditions(Iterable<? extends CommonTypesProto.TriggeringCondition> param1Iterable) {
      ensureTriggeringConditionsIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.triggeringConditions_);
    }
    
    private void addConversionEvent(int param1Int, CommonTypesProto.ScionConversionEvent.Builder param1Builder) {
      ensureConversionEventIsMutable();
      this.conversionEvent_.add(param1Int, param1Builder.build());
    }
    
    private void addConversionEvent(int param1Int, CommonTypesProto.ScionConversionEvent param1ScionConversionEvent) {
      if (param1ScionConversionEvent != null) {
        ensureConversionEventIsMutable();
        this.conversionEvent_.add(param1Int, param1ScionConversionEvent);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addConversionEvent(CommonTypesProto.ScionConversionEvent.Builder param1Builder) {
      ensureConversionEventIsMutable();
      this.conversionEvent_.add(param1Builder.build());
    }
    
    private void addConversionEvent(CommonTypesProto.ScionConversionEvent param1ScionConversionEvent) {
      if (param1ScionConversionEvent != null) {
        ensureConversionEventIsMutable();
        this.conversionEvent_.add(param1ScionConversionEvent);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addTriggeringConditions(int param1Int, CommonTypesProto.TriggeringCondition.Builder param1Builder) {
      ensureTriggeringConditionsIsMutable();
      this.triggeringConditions_.add(param1Int, param1Builder.build());
    }
    
    private void addTriggeringConditions(int param1Int, CommonTypesProto.TriggeringCondition param1TriggeringCondition) {
      if (param1TriggeringCondition != null) {
        ensureTriggeringConditionsIsMutable();
        this.triggeringConditions_.add(param1Int, param1TriggeringCondition);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addTriggeringConditions(CommonTypesProto.TriggeringCondition.Builder param1Builder) {
      ensureTriggeringConditionsIsMutable();
      this.triggeringConditions_.add(param1Builder.build());
    }
    
    private void addTriggeringConditions(CommonTypesProto.TriggeringCondition param1TriggeringCondition) {
      if (param1TriggeringCondition != null) {
        ensureTriggeringConditionsIsMutable();
        this.triggeringConditions_.add(param1TriggeringCondition);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearCampaignId() {
      this.campaignId_ = getDefaultInstance().getCampaignId();
    }
    
    private void clearContent() {
      this.content_ = null;
    }
    
    private void clearConversionEvent() {
      this.conversionEvent_ = emptyProtobufList();
    }
    
    private void clearDescription() {
      this.description_ = getDefaultInstance().getDescription();
    }
    
    private void clearDisplayName() {
      this.displayName_ = getDefaultInstance().getDisplayName();
    }
    
    private void clearPriority() {
      this.priority_ = null;
    }
    
    private void clearProjectNumber() {
      this.projectNumber_ = getDefaultInstance().getProjectNumber();
    }
    
    private void clearScheduledEndTime() {
      this.scheduledEndTime_ = null;
    }
    
    private void clearScheduledEndTimestamp() {
      this.scheduledEndTimestamp_ = null;
    }
    
    private void clearScheduledStartTime() {
      this.scheduledStartTime_ = null;
    }
    
    private void clearScheduledStartTimestamp() {
      this.scheduledStartTimestamp_ = null;
    }
    
    private void clearState() {
      this.state_ = 0;
    }
    
    private void clearTargetingCondition() {
      this.targetingCondition_ = null;
    }
    
    private void clearTriggeringConditions() {
      this.triggeringConditions_ = emptyProtobufList();
    }
    
    private void ensureConversionEventIsMutable() {
      if (!this.conversionEvent_.isModifiable())
        this.conversionEvent_ = GeneratedMessageLite.mutableCopy(this.conversionEvent_); 
    }
    
    private void ensureTriggeringConditionsIsMutable() {
      if (!this.triggeringConditions_.isModifiable())
        this.triggeringConditions_ = GeneratedMessageLite.mutableCopy(this.triggeringConditions_); 
    }
    
    public static Campaign getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeContent(MessagesProto.Content param1Content) {
      MessagesProto.Content content = this.content_;
      if (content != null && content != MessagesProto.Content.getDefaultInstance()) {
        this.content_ = (MessagesProto.Content)((MessagesProto.Content.Builder)MessagesProto.Content.newBuilder(this.content_).mergeFrom((GeneratedMessageLite)param1Content)).buildPartial();
      } else {
        this.content_ = param1Content;
      } 
    }
    
    private void mergePriority(CommonTypesProto.Priority param1Priority) {
      CommonTypesProto.Priority priority = this.priority_;
      if (priority != null && priority != CommonTypesProto.Priority.getDefaultInstance()) {
        this.priority_ = (CommonTypesProto.Priority)((CommonTypesProto.Priority.Builder)CommonTypesProto.Priority.newBuilder(this.priority_).mergeFrom((GeneratedMessageLite)param1Priority)).buildPartial();
      } else {
        this.priority_ = param1Priority;
      } 
    }
    
    private void mergeScheduledEndTime(CommonTypesProto.CampaignTime param1CampaignTime) {
      CommonTypesProto.CampaignTime campaignTime = this.scheduledEndTime_;
      if (campaignTime != null && campaignTime != CommonTypesProto.CampaignTime.getDefaultInstance()) {
        this.scheduledEndTime_ = (CommonTypesProto.CampaignTime)((CommonTypesProto.CampaignTime.Builder)CommonTypesProto.CampaignTime.newBuilder(this.scheduledEndTime_).mergeFrom((GeneratedMessageLite)param1CampaignTime)).buildPartial();
      } else {
        this.scheduledEndTime_ = param1CampaignTime;
      } 
    }
    
    private void mergeScheduledEndTimestamp(Timestamp param1Timestamp) {
      Timestamp timestamp = this.scheduledEndTimestamp_;
      if (timestamp != null && timestamp != Timestamp.getDefaultInstance()) {
        this.scheduledEndTimestamp_ = (Timestamp)((Timestamp.Builder)Timestamp.newBuilder(this.scheduledEndTimestamp_).mergeFrom((GeneratedMessageLite)param1Timestamp)).buildPartial();
      } else {
        this.scheduledEndTimestamp_ = param1Timestamp;
      } 
    }
    
    private void mergeScheduledStartTime(CommonTypesProto.CampaignTime param1CampaignTime) {
      CommonTypesProto.CampaignTime campaignTime = this.scheduledStartTime_;
      if (campaignTime != null && campaignTime != CommonTypesProto.CampaignTime.getDefaultInstance()) {
        this.scheduledStartTime_ = (CommonTypesProto.CampaignTime)((CommonTypesProto.CampaignTime.Builder)CommonTypesProto.CampaignTime.newBuilder(this.scheduledStartTime_).mergeFrom((GeneratedMessageLite)param1CampaignTime)).buildPartial();
      } else {
        this.scheduledStartTime_ = param1CampaignTime;
      } 
    }
    
    private void mergeScheduledStartTimestamp(Timestamp param1Timestamp) {
      Timestamp timestamp = this.scheduledStartTimestamp_;
      if (timestamp != null && timestamp != Timestamp.getDefaultInstance()) {
        this.scheduledStartTimestamp_ = (Timestamp)((Timestamp.Builder)Timestamp.newBuilder(this.scheduledStartTimestamp_).mergeFrom((GeneratedMessageLite)param1Timestamp)).buildPartial();
      } else {
        this.scheduledStartTimestamp_ = param1Timestamp;
      } 
    }
    
    private void mergeTargetingCondition(Conditions.Condition param1Condition) {
      Conditions.Condition condition = this.targetingCondition_;
      if (condition != null && condition != Conditions.Condition.getDefaultInstance()) {
        this.targetingCondition_ = (Conditions.Condition)((Conditions.Condition.Builder)Conditions.Condition.newBuilder(this.targetingCondition_).mergeFrom((GeneratedMessageLite)param1Condition)).buildPartial();
      } else {
        this.targetingCondition_ = param1Condition;
      } 
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Campaign param1Campaign) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1Campaign);
    }
    
    public static Campaign parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Campaign)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Campaign parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Campaign)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Campaign parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Campaign)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static Campaign parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Campaign)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Campaign parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Campaign)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static Campaign parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Campaign)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Campaign parseFrom(InputStream param1InputStream) throws IOException {
      return (Campaign)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Campaign parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Campaign)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Campaign parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Campaign)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static Campaign parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Campaign)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Campaign> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeConversionEvent(int param1Int) {
      ensureConversionEventIsMutable();
      this.conversionEvent_.remove(param1Int);
    }
    
    private void removeTriggeringConditions(int param1Int) {
      ensureTriggeringConditionsIsMutable();
      this.triggeringConditions_.remove(param1Int);
    }
    
    private void setCampaignId(String param1String) {
      if (param1String != null) {
        this.campaignId_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setCampaignIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.campaignId_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setContent(MessagesProto.Content.Builder param1Builder) {
      this.content_ = (MessagesProto.Content)param1Builder.build();
    }
    
    private void setContent(MessagesProto.Content param1Content) {
      if (param1Content != null) {
        this.content_ = param1Content;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setConversionEvent(int param1Int, CommonTypesProto.ScionConversionEvent.Builder param1Builder) {
      ensureConversionEventIsMutable();
      this.conversionEvent_.set(param1Int, param1Builder.build());
    }
    
    private void setConversionEvent(int param1Int, CommonTypesProto.ScionConversionEvent param1ScionConversionEvent) {
      if (param1ScionConversionEvent != null) {
        ensureConversionEventIsMutable();
        this.conversionEvent_.set(param1Int, param1ScionConversionEvent);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setDescription(String param1String) {
      if (param1String != null) {
        this.description_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setDescriptionBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.description_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setDisplayName(String param1String) {
      if (param1String != null) {
        this.displayName_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setDisplayNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.displayName_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setPriority(CommonTypesProto.Priority.Builder param1Builder) {
      this.priority_ = (CommonTypesProto.Priority)param1Builder.build();
    }
    
    private void setPriority(CommonTypesProto.Priority param1Priority) {
      if (param1Priority != null) {
        this.priority_ = param1Priority;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setProjectNumber(String param1String) {
      if (param1String != null) {
        this.projectNumber_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setProjectNumberBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.projectNumber_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setScheduledEndTime(CommonTypesProto.CampaignTime.Builder param1Builder) {
      this.scheduledEndTime_ = (CommonTypesProto.CampaignTime)param1Builder.build();
    }
    
    private void setScheduledEndTime(CommonTypesProto.CampaignTime param1CampaignTime) {
      if (param1CampaignTime != null) {
        this.scheduledEndTime_ = param1CampaignTime;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setScheduledEndTimestamp(Timestamp.Builder param1Builder) {
      this.scheduledEndTimestamp_ = (Timestamp)param1Builder.build();
    }
    
    private void setScheduledEndTimestamp(Timestamp param1Timestamp) {
      if (param1Timestamp != null) {
        this.scheduledEndTimestamp_ = param1Timestamp;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setScheduledStartTime(CommonTypesProto.CampaignTime.Builder param1Builder) {
      this.scheduledStartTime_ = (CommonTypesProto.CampaignTime)param1Builder.build();
    }
    
    private void setScheduledStartTime(CommonTypesProto.CampaignTime param1CampaignTime) {
      if (param1CampaignTime != null) {
        this.scheduledStartTime_ = param1CampaignTime;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setScheduledStartTimestamp(Timestamp.Builder param1Builder) {
      this.scheduledStartTimestamp_ = (Timestamp)param1Builder.build();
    }
    
    private void setScheduledStartTimestamp(Timestamp param1Timestamp) {
      if (param1Timestamp != null) {
        this.scheduledStartTimestamp_ = param1Timestamp;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setState(CommonTypesProto.CampaignState param1CampaignState) {
      if (param1CampaignState != null) {
        this.state_ = param1CampaignState.getNumber();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setStateValue(int param1Int) {
      this.state_ = param1Int;
    }
    
    private void setTargetingCondition(Conditions.Condition.Builder param1Builder) {
      this.targetingCondition_ = (Conditions.Condition)param1Builder.build();
    }
    
    private void setTargetingCondition(Conditions.Condition param1Condition) {
      if (param1Condition != null) {
        this.targetingCondition_ = param1Condition;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTriggeringConditions(int param1Int, CommonTypesProto.TriggeringCondition.Builder param1Builder) {
      ensureTriggeringConditionsIsMutable();
      this.triggeringConditions_.set(param1Int, param1Builder.build());
    }
    
    private void setTriggeringConditions(int param1Int, CommonTypesProto.TriggeringCondition param1TriggeringCondition) {
      if (param1TriggeringCondition != null) {
        ensureTriggeringConditionsIsMutable();
        this.triggeringConditions_.set(param1Int, param1TriggeringCondition);
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: istore #4
      //   10: iconst_0
      //   11: istore #5
      //   13: iconst_0
      //   14: istore #6
      //   16: iload #4
      //   18: tableswitch default -> 64, 1 -> 1402, 2 -> 1398, 3 -> 1378, 4 -> 1369, 5 -> 958, 6 -> 118, 7 -> 954, 8 -> 72
      //   64: new java/lang/UnsupportedOperationException
      //   67: dup
      //   68: invokespecial <init> : ()V
      //   71: athrow
      //   72: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign.PARSER : Lcom/google/protobuf/Parser;
      //   75: ifnonnull -> 114
      //   78: ldc com/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign
      //   80: monitorenter
      //   81: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign.PARSER : Lcom/google/protobuf/Parser;
      //   84: ifnonnull -> 102
      //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   90: astore_1
      //   91: aload_1
      //   92: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign;
      //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   98: aload_1
      //   99: putstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign.PARSER : Lcom/google/protobuf/Parser;
      //   102: ldc com/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign
      //   104: monitorexit
      //   105: goto -> 114
      //   108: astore_1
      //   109: ldc com/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign
      //   111: monitorexit
      //   112: aload_1
      //   113: athrow
      //   114: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign.PARSER : Lcom/google/protobuf/Parser;
      //   117: areturn
      //   118: aload_2
      //   119: checkcast com/google/protobuf/CodedInputStream
      //   122: astore_2
      //   123: aload_3
      //   124: checkcast com/google/protobuf/ExtensionRegistryLite
      //   127: astore_3
      //   128: iload #6
      //   130: ifne -> 954
      //   133: aload_2
      //   134: invokevirtual readTag : ()I
      //   137: istore #4
      //   139: iload #4
      //   141: lookupswitch default -> 272, 0 -> 887, 10 -> 876, 18 -> 865, 24 -> 854, 34 -> 843, 42 -> 832, 50 -> 767, 58 -> 702, 66 -> 637, 74 -> 590, 82 -> 525, 90 -> 460, 98 -> 413, 106 -> 348, 114 -> 283
      //   272: aload_2
      //   273: iload #4
      //   275: invokevirtual skipField : (I)Z
      //   278: istore #7
      //   280: goto -> 893
      //   283: aload_0
      //   284: getfield scheduledEndTimestamp_ : Lcom/google/protobuf/Timestamp;
      //   287: ifnull -> 304
      //   290: aload_0
      //   291: getfield scheduledEndTimestamp_ : Lcom/google/protobuf/Timestamp;
      //   294: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   297: checkcast com/google/protobuf/Timestamp$Builder
      //   300: astore_1
      //   301: goto -> 306
      //   304: aconst_null
      //   305: astore_1
      //   306: aload_0
      //   307: aload_2
      //   308: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   311: aload_3
      //   312: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   315: checkcast com/google/protobuf/Timestamp
      //   318: putfield scheduledEndTimestamp_ : Lcom/google/protobuf/Timestamp;
      //   321: aload_1
      //   322: ifnull -> 128
      //   325: aload_1
      //   326: aload_0
      //   327: getfield scheduledEndTimestamp_ : Lcom/google/protobuf/Timestamp;
      //   330: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   333: pop
      //   334: aload_0
      //   335: aload_1
      //   336: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   339: checkcast com/google/protobuf/Timestamp
      //   342: putfield scheduledEndTimestamp_ : Lcom/google/protobuf/Timestamp;
      //   345: goto -> 128
      //   348: aload_0
      //   349: getfield scheduledStartTimestamp_ : Lcom/google/protobuf/Timestamp;
      //   352: ifnull -> 369
      //   355: aload_0
      //   356: getfield scheduledStartTimestamp_ : Lcom/google/protobuf/Timestamp;
      //   359: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   362: checkcast com/google/protobuf/Timestamp$Builder
      //   365: astore_1
      //   366: goto -> 371
      //   369: aconst_null
      //   370: astore_1
      //   371: aload_0
      //   372: aload_2
      //   373: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   376: aload_3
      //   377: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   380: checkcast com/google/protobuf/Timestamp
      //   383: putfield scheduledStartTimestamp_ : Lcom/google/protobuf/Timestamp;
      //   386: aload_1
      //   387: ifnull -> 128
      //   390: aload_1
      //   391: aload_0
      //   392: getfield scheduledStartTimestamp_ : Lcom/google/protobuf/Timestamp;
      //   395: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   398: pop
      //   399: aload_0
      //   400: aload_1
      //   401: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   404: checkcast com/google/protobuf/Timestamp
      //   407: putfield scheduledStartTimestamp_ : Lcom/google/protobuf/Timestamp;
      //   410: goto -> 128
      //   413: aload_0
      //   414: getfield conversionEvent_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   417: invokeinterface isModifiable : ()Z
      //   422: ifne -> 436
      //   425: aload_0
      //   426: aload_0
      //   427: getfield conversionEvent_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   430: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   433: putfield conversionEvent_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   436: aload_0
      //   437: getfield conversionEvent_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   440: aload_2
      //   441: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   444: aload_3
      //   445: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   448: checkcast com/google/firebase/inappmessaging/CommonTypesProto$ScionConversionEvent
      //   451: invokeinterface add : (Ljava/lang/Object;)Z
      //   456: pop
      //   457: goto -> 128
      //   460: aload_0
      //   461: getfield content_ : Lcom/google/firebase/inappmessaging/MessagesProto$Content;
      //   464: ifnull -> 481
      //   467: aload_0
      //   468: getfield content_ : Lcom/google/firebase/inappmessaging/MessagesProto$Content;
      //   471: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   474: checkcast com/google/firebase/inappmessaging/MessagesProto$Content$Builder
      //   477: astore_1
      //   478: goto -> 483
      //   481: aconst_null
      //   482: astore_1
      //   483: aload_0
      //   484: aload_2
      //   485: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   488: aload_3
      //   489: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   492: checkcast com/google/firebase/inappmessaging/MessagesProto$Content
      //   495: putfield content_ : Lcom/google/firebase/inappmessaging/MessagesProto$Content;
      //   498: aload_1
      //   499: ifnull -> 128
      //   502: aload_1
      //   503: aload_0
      //   504: getfield content_ : Lcom/google/firebase/inappmessaging/MessagesProto$Content;
      //   507: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   510: pop
      //   511: aload_0
      //   512: aload_1
      //   513: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   516: checkcast com/google/firebase/inappmessaging/MessagesProto$Content
      //   519: putfield content_ : Lcom/google/firebase/inappmessaging/MessagesProto$Content;
      //   522: goto -> 128
      //   525: aload_0
      //   526: getfield priority_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$Priority;
      //   529: ifnull -> 546
      //   532: aload_0
      //   533: getfield priority_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$Priority;
      //   536: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   539: checkcast com/google/firebase/inappmessaging/CommonTypesProto$Priority$Builder
      //   542: astore_1
      //   543: goto -> 548
      //   546: aconst_null
      //   547: astore_1
      //   548: aload_0
      //   549: aload_2
      //   550: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   553: aload_3
      //   554: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   557: checkcast com/google/firebase/inappmessaging/CommonTypesProto$Priority
      //   560: putfield priority_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$Priority;
      //   563: aload_1
      //   564: ifnull -> 128
      //   567: aload_1
      //   568: aload_0
      //   569: getfield priority_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$Priority;
      //   572: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   575: pop
      //   576: aload_0
      //   577: aload_1
      //   578: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   581: checkcast com/google/firebase/inappmessaging/CommonTypesProto$Priority
      //   584: putfield priority_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$Priority;
      //   587: goto -> 128
      //   590: aload_0
      //   591: getfield triggeringConditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   594: invokeinterface isModifiable : ()Z
      //   599: ifne -> 613
      //   602: aload_0
      //   603: aload_0
      //   604: getfield triggeringConditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   607: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   610: putfield triggeringConditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   613: aload_0
      //   614: getfield triggeringConditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   617: aload_2
      //   618: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   621: aload_3
      //   622: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   625: checkcast com/google/firebase/inappmessaging/CommonTypesProto$TriggeringCondition
      //   628: invokeinterface add : (Ljava/lang/Object;)Z
      //   633: pop
      //   634: goto -> 128
      //   637: aload_0
      //   638: getfield targetingCondition_ : Lcom/google/developers/mobile/targeting/proto/Conditions$Condition;
      //   641: ifnull -> 658
      //   644: aload_0
      //   645: getfield targetingCondition_ : Lcom/google/developers/mobile/targeting/proto/Conditions$Condition;
      //   648: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   651: checkcast com/google/developers/mobile/targeting/proto/Conditions$Condition$Builder
      //   654: astore_1
      //   655: goto -> 660
      //   658: aconst_null
      //   659: astore_1
      //   660: aload_0
      //   661: aload_2
      //   662: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   665: aload_3
      //   666: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   669: checkcast com/google/developers/mobile/targeting/proto/Conditions$Condition
      //   672: putfield targetingCondition_ : Lcom/google/developers/mobile/targeting/proto/Conditions$Condition;
      //   675: aload_1
      //   676: ifnull -> 128
      //   679: aload_1
      //   680: aload_0
      //   681: getfield targetingCondition_ : Lcom/google/developers/mobile/targeting/proto/Conditions$Condition;
      //   684: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   687: pop
      //   688: aload_0
      //   689: aload_1
      //   690: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   693: checkcast com/google/developers/mobile/targeting/proto/Conditions$Condition
      //   696: putfield targetingCondition_ : Lcom/google/developers/mobile/targeting/proto/Conditions$Condition;
      //   699: goto -> 128
      //   702: aload_0
      //   703: getfield scheduledEndTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   706: ifnull -> 723
      //   709: aload_0
      //   710: getfield scheduledEndTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   713: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   716: checkcast com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime$Builder
      //   719: astore_1
      //   720: goto -> 725
      //   723: aconst_null
      //   724: astore_1
      //   725: aload_0
      //   726: aload_2
      //   727: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   730: aload_3
      //   731: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   734: checkcast com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime
      //   737: putfield scheduledEndTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   740: aload_1
      //   741: ifnull -> 128
      //   744: aload_1
      //   745: aload_0
      //   746: getfield scheduledEndTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   749: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   752: pop
      //   753: aload_0
      //   754: aload_1
      //   755: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   758: checkcast com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime
      //   761: putfield scheduledEndTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   764: goto -> 128
      //   767: aload_0
      //   768: getfield scheduledStartTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   771: ifnull -> 788
      //   774: aload_0
      //   775: getfield scheduledStartTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   778: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   781: checkcast com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime$Builder
      //   784: astore_1
      //   785: goto -> 790
      //   788: aconst_null
      //   789: astore_1
      //   790: aload_0
      //   791: aload_2
      //   792: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   795: aload_3
      //   796: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   799: checkcast com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime
      //   802: putfield scheduledStartTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   805: aload_1
      //   806: ifnull -> 128
      //   809: aload_1
      //   810: aload_0
      //   811: getfield scheduledStartTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   814: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   817: pop
      //   818: aload_0
      //   819: aload_1
      //   820: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   823: checkcast com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime
      //   826: putfield scheduledStartTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   829: goto -> 128
      //   832: aload_0
      //   833: aload_2
      //   834: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   837: putfield description_ : Ljava/lang/String;
      //   840: goto -> 128
      //   843: aload_0
      //   844: aload_2
      //   845: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   848: putfield displayName_ : Ljava/lang/String;
      //   851: goto -> 128
      //   854: aload_0
      //   855: aload_2
      //   856: invokevirtual readEnum : ()I
      //   859: putfield state_ : I
      //   862: goto -> 128
      //   865: aload_0
      //   866: aload_2
      //   867: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   870: putfield campaignId_ : Ljava/lang/String;
      //   873: goto -> 128
      //   876: aload_0
      //   877: aload_2
      //   878: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   881: putfield projectNumber_ : Ljava/lang/String;
      //   884: goto -> 128
      //   887: iconst_1
      //   888: istore #6
      //   890: goto -> 128
      //   893: iload #7
      //   895: ifne -> 128
      //   898: iconst_1
      //   899: istore #6
      //   901: goto -> 128
      //   904: astore_1
      //   905: goto -> 952
      //   908: astore_1
      //   909: new java/lang/RuntimeException
      //   912: astore_2
      //   913: new com/google/protobuf/InvalidProtocolBufferException
      //   916: astore_3
      //   917: aload_3
      //   918: aload_1
      //   919: invokevirtual getMessage : ()Ljava/lang/String;
      //   922: invokespecial <init> : (Ljava/lang/String;)V
      //   925: aload_2
      //   926: aload_3
      //   927: aload_0
      //   928: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   931: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   934: aload_2
      //   935: athrow
      //   936: astore_2
      //   937: new java/lang/RuntimeException
      //   940: astore_1
      //   941: aload_1
      //   942: aload_2
      //   943: aload_0
      //   944: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   947: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   950: aload_1
      //   951: athrow
      //   952: aload_1
      //   953: athrow
      //   954: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign;
      //   957: areturn
      //   958: aload_2
      //   959: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   962: astore_1
      //   963: aload_3
      //   964: checkcast com/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign
      //   967: astore_2
      //   968: aload_0
      //   969: aload_1
      //   970: aload_0
      //   971: getfield projectNumber_ : Ljava/lang/String;
      //   974: invokevirtual isEmpty : ()Z
      //   977: iconst_1
      //   978: ixor
      //   979: aload_0
      //   980: getfield projectNumber_ : Ljava/lang/String;
      //   983: aload_2
      //   984: getfield projectNumber_ : Ljava/lang/String;
      //   987: invokevirtual isEmpty : ()Z
      //   990: iconst_1
      //   991: ixor
      //   992: aload_2
      //   993: getfield projectNumber_ : Ljava/lang/String;
      //   996: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   1001: putfield projectNumber_ : Ljava/lang/String;
      //   1004: aload_0
      //   1005: aload_1
      //   1006: aload_0
      //   1007: getfield campaignId_ : Ljava/lang/String;
      //   1010: invokevirtual isEmpty : ()Z
      //   1013: iconst_1
      //   1014: ixor
      //   1015: aload_0
      //   1016: getfield campaignId_ : Ljava/lang/String;
      //   1019: aload_2
      //   1020: getfield campaignId_ : Ljava/lang/String;
      //   1023: invokevirtual isEmpty : ()Z
      //   1026: iconst_1
      //   1027: ixor
      //   1028: aload_2
      //   1029: getfield campaignId_ : Ljava/lang/String;
      //   1032: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   1037: putfield campaignId_ : Ljava/lang/String;
      //   1040: aload_0
      //   1041: getfield state_ : I
      //   1044: ifeq -> 1053
      //   1047: iconst_1
      //   1048: istore #7
      //   1050: goto -> 1056
      //   1053: iconst_0
      //   1054: istore #7
      //   1056: aload_0
      //   1057: getfield state_ : I
      //   1060: istore #6
      //   1062: aload_2
      //   1063: getfield state_ : I
      //   1066: ifeq -> 1072
      //   1069: iconst_1
      //   1070: istore #5
      //   1072: aload_0
      //   1073: aload_1
      //   1074: iload #7
      //   1076: iload #6
      //   1078: iload #5
      //   1080: aload_2
      //   1081: getfield state_ : I
      //   1084: invokeinterface visitInt : (ZIZI)I
      //   1089: putfield state_ : I
      //   1092: aload_0
      //   1093: aload_1
      //   1094: aload_0
      //   1095: getfield displayName_ : Ljava/lang/String;
      //   1098: invokevirtual isEmpty : ()Z
      //   1101: iconst_1
      //   1102: ixor
      //   1103: aload_0
      //   1104: getfield displayName_ : Ljava/lang/String;
      //   1107: aload_2
      //   1108: getfield displayName_ : Ljava/lang/String;
      //   1111: invokevirtual isEmpty : ()Z
      //   1114: iconst_1
      //   1115: ixor
      //   1116: aload_2
      //   1117: getfield displayName_ : Ljava/lang/String;
      //   1120: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   1125: putfield displayName_ : Ljava/lang/String;
      //   1128: aload_0
      //   1129: aload_1
      //   1130: aload_0
      //   1131: getfield description_ : Ljava/lang/String;
      //   1134: invokevirtual isEmpty : ()Z
      //   1137: iconst_1
      //   1138: ixor
      //   1139: aload_0
      //   1140: getfield description_ : Ljava/lang/String;
      //   1143: aload_2
      //   1144: getfield description_ : Ljava/lang/String;
      //   1147: invokevirtual isEmpty : ()Z
      //   1150: iconst_1
      //   1151: ixor
      //   1152: aload_2
      //   1153: getfield description_ : Ljava/lang/String;
      //   1156: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   1161: putfield description_ : Ljava/lang/String;
      //   1164: aload_0
      //   1165: aload_1
      //   1166: aload_0
      //   1167: getfield scheduledStartTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   1170: aload_2
      //   1171: getfield scheduledStartTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   1174: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   1179: checkcast com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime
      //   1182: putfield scheduledStartTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   1185: aload_0
      //   1186: aload_1
      //   1187: aload_0
      //   1188: getfield scheduledEndTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   1191: aload_2
      //   1192: getfield scheduledEndTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   1195: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   1200: checkcast com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime
      //   1203: putfield scheduledEndTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   1206: aload_0
      //   1207: aload_1
      //   1208: aload_0
      //   1209: getfield targetingCondition_ : Lcom/google/developers/mobile/targeting/proto/Conditions$Condition;
      //   1212: aload_2
      //   1213: getfield targetingCondition_ : Lcom/google/developers/mobile/targeting/proto/Conditions$Condition;
      //   1216: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   1221: checkcast com/google/developers/mobile/targeting/proto/Conditions$Condition
      //   1224: putfield targetingCondition_ : Lcom/google/developers/mobile/targeting/proto/Conditions$Condition;
      //   1227: aload_0
      //   1228: aload_1
      //   1229: aload_0
      //   1230: getfield triggeringConditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1233: aload_2
      //   1234: getfield triggeringConditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1237: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   1242: putfield triggeringConditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1245: aload_0
      //   1246: aload_1
      //   1247: aload_0
      //   1248: getfield priority_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$Priority;
      //   1251: aload_2
      //   1252: getfield priority_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$Priority;
      //   1255: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   1260: checkcast com/google/firebase/inappmessaging/CommonTypesProto$Priority
      //   1263: putfield priority_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$Priority;
      //   1266: aload_0
      //   1267: aload_1
      //   1268: aload_0
      //   1269: getfield content_ : Lcom/google/firebase/inappmessaging/MessagesProto$Content;
      //   1272: aload_2
      //   1273: getfield content_ : Lcom/google/firebase/inappmessaging/MessagesProto$Content;
      //   1276: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   1281: checkcast com/google/firebase/inappmessaging/MessagesProto$Content
      //   1284: putfield content_ : Lcom/google/firebase/inappmessaging/MessagesProto$Content;
      //   1287: aload_0
      //   1288: aload_1
      //   1289: aload_0
      //   1290: getfield conversionEvent_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1293: aload_2
      //   1294: getfield conversionEvent_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1297: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   1302: putfield conversionEvent_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1305: aload_0
      //   1306: aload_1
      //   1307: aload_0
      //   1308: getfield scheduledStartTimestamp_ : Lcom/google/protobuf/Timestamp;
      //   1311: aload_2
      //   1312: getfield scheduledStartTimestamp_ : Lcom/google/protobuf/Timestamp;
      //   1315: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   1320: checkcast com/google/protobuf/Timestamp
      //   1323: putfield scheduledStartTimestamp_ : Lcom/google/protobuf/Timestamp;
      //   1326: aload_0
      //   1327: aload_1
      //   1328: aload_0
      //   1329: getfield scheduledEndTimestamp_ : Lcom/google/protobuf/Timestamp;
      //   1332: aload_2
      //   1333: getfield scheduledEndTimestamp_ : Lcom/google/protobuf/Timestamp;
      //   1336: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   1341: checkcast com/google/protobuf/Timestamp
      //   1344: putfield scheduledEndTimestamp_ : Lcom/google/protobuf/Timestamp;
      //   1347: aload_1
      //   1348: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   1351: if_acmpne -> 1367
      //   1354: aload_0
      //   1355: aload_0
      //   1356: getfield bitField0_ : I
      //   1359: aload_2
      //   1360: getfield bitField0_ : I
      //   1363: ior
      //   1364: putfield bitField0_ : I
      //   1367: aload_0
      //   1368: areturn
      //   1369: new com/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign$Builder
      //   1372: dup
      //   1373: aconst_null
      //   1374: invokespecial <init> : (Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$1;)V
      //   1377: areturn
      //   1378: aload_0
      //   1379: getfield triggeringConditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1382: invokeinterface makeImmutable : ()V
      //   1387: aload_0
      //   1388: getfield conversionEvent_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1391: invokeinterface makeImmutable : ()V
      //   1396: aconst_null
      //   1397: areturn
      //   1398: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign;
      //   1401: areturn
      //   1402: new com/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign
      //   1405: dup
      //   1406: invokespecial <init> : ()V
      //   1409: areturn
      // Exception table:
      //   from	to	target	type
      //   81	102	108	finally
      //   102	105	108	finally
      //   109	112	108	finally
      //   133	139	936	com/google/protobuf/InvalidProtocolBufferException
      //   133	139	908	java/io/IOException
      //   133	139	904	finally
      //   272	280	936	com/google/protobuf/InvalidProtocolBufferException
      //   272	280	908	java/io/IOException
      //   272	280	904	finally
      //   283	301	936	com/google/protobuf/InvalidProtocolBufferException
      //   283	301	908	java/io/IOException
      //   283	301	904	finally
      //   306	321	936	com/google/protobuf/InvalidProtocolBufferException
      //   306	321	908	java/io/IOException
      //   306	321	904	finally
      //   325	345	936	com/google/protobuf/InvalidProtocolBufferException
      //   325	345	908	java/io/IOException
      //   325	345	904	finally
      //   348	366	936	com/google/protobuf/InvalidProtocolBufferException
      //   348	366	908	java/io/IOException
      //   348	366	904	finally
      //   371	386	936	com/google/protobuf/InvalidProtocolBufferException
      //   371	386	908	java/io/IOException
      //   371	386	904	finally
      //   390	410	936	com/google/protobuf/InvalidProtocolBufferException
      //   390	410	908	java/io/IOException
      //   390	410	904	finally
      //   413	436	936	com/google/protobuf/InvalidProtocolBufferException
      //   413	436	908	java/io/IOException
      //   413	436	904	finally
      //   436	457	936	com/google/protobuf/InvalidProtocolBufferException
      //   436	457	908	java/io/IOException
      //   436	457	904	finally
      //   460	478	936	com/google/protobuf/InvalidProtocolBufferException
      //   460	478	908	java/io/IOException
      //   460	478	904	finally
      //   483	498	936	com/google/protobuf/InvalidProtocolBufferException
      //   483	498	908	java/io/IOException
      //   483	498	904	finally
      //   502	522	936	com/google/protobuf/InvalidProtocolBufferException
      //   502	522	908	java/io/IOException
      //   502	522	904	finally
      //   525	543	936	com/google/protobuf/InvalidProtocolBufferException
      //   525	543	908	java/io/IOException
      //   525	543	904	finally
      //   548	563	936	com/google/protobuf/InvalidProtocolBufferException
      //   548	563	908	java/io/IOException
      //   548	563	904	finally
      //   567	587	936	com/google/protobuf/InvalidProtocolBufferException
      //   567	587	908	java/io/IOException
      //   567	587	904	finally
      //   590	613	936	com/google/protobuf/InvalidProtocolBufferException
      //   590	613	908	java/io/IOException
      //   590	613	904	finally
      //   613	634	936	com/google/protobuf/InvalidProtocolBufferException
      //   613	634	908	java/io/IOException
      //   613	634	904	finally
      //   637	655	936	com/google/protobuf/InvalidProtocolBufferException
      //   637	655	908	java/io/IOException
      //   637	655	904	finally
      //   660	675	936	com/google/protobuf/InvalidProtocolBufferException
      //   660	675	908	java/io/IOException
      //   660	675	904	finally
      //   679	699	936	com/google/protobuf/InvalidProtocolBufferException
      //   679	699	908	java/io/IOException
      //   679	699	904	finally
      //   702	720	936	com/google/protobuf/InvalidProtocolBufferException
      //   702	720	908	java/io/IOException
      //   702	720	904	finally
      //   725	740	936	com/google/protobuf/InvalidProtocolBufferException
      //   725	740	908	java/io/IOException
      //   725	740	904	finally
      //   744	764	936	com/google/protobuf/InvalidProtocolBufferException
      //   744	764	908	java/io/IOException
      //   744	764	904	finally
      //   767	785	936	com/google/protobuf/InvalidProtocolBufferException
      //   767	785	908	java/io/IOException
      //   767	785	904	finally
      //   790	805	936	com/google/protobuf/InvalidProtocolBufferException
      //   790	805	908	java/io/IOException
      //   790	805	904	finally
      //   809	829	936	com/google/protobuf/InvalidProtocolBufferException
      //   809	829	908	java/io/IOException
      //   809	829	904	finally
      //   832	840	936	com/google/protobuf/InvalidProtocolBufferException
      //   832	840	908	java/io/IOException
      //   832	840	904	finally
      //   843	851	936	com/google/protobuf/InvalidProtocolBufferException
      //   843	851	908	java/io/IOException
      //   843	851	904	finally
      //   854	862	936	com/google/protobuf/InvalidProtocolBufferException
      //   854	862	908	java/io/IOException
      //   854	862	904	finally
      //   865	873	936	com/google/protobuf/InvalidProtocolBufferException
      //   865	873	908	java/io/IOException
      //   865	873	904	finally
      //   876	884	936	com/google/protobuf/InvalidProtocolBufferException
      //   876	884	908	java/io/IOException
      //   876	884	904	finally
      //   909	936	904	finally
      //   937	952	904	finally
    }
    
    public String getCampaignId() {
      return this.campaignId_;
    }
    
    public ByteString getCampaignIdBytes() {
      return ByteString.copyFromUtf8(this.campaignId_);
    }
    
    public MessagesProto.Content getContent() {
      MessagesProto.Content content1 = this.content_;
      MessagesProto.Content content2 = content1;
      if (content1 == null)
        content2 = MessagesProto.Content.getDefaultInstance(); 
      return content2;
    }
    
    public CommonTypesProto.ScionConversionEvent getConversionEvent(int param1Int) {
      return (CommonTypesProto.ScionConversionEvent)this.conversionEvent_.get(param1Int);
    }
    
    public int getConversionEventCount() {
      return this.conversionEvent_.size();
    }
    
    public List<CommonTypesProto.ScionConversionEvent> getConversionEventList() {
      return (List<CommonTypesProto.ScionConversionEvent>)this.conversionEvent_;
    }
    
    public CommonTypesProto.ScionConversionEventOrBuilder getConversionEventOrBuilder(int param1Int) {
      return (CommonTypesProto.ScionConversionEventOrBuilder)this.conversionEvent_.get(param1Int);
    }
    
    public List<? extends CommonTypesProto.ScionConversionEventOrBuilder> getConversionEventOrBuilderList() {
      return (List)this.conversionEvent_;
    }
    
    public String getDescription() {
      return this.description_;
    }
    
    public ByteString getDescriptionBytes() {
      return ByteString.copyFromUtf8(this.description_);
    }
    
    public String getDisplayName() {
      return this.displayName_;
    }
    
    public ByteString getDisplayNameBytes() {
      return ByteString.copyFromUtf8(this.displayName_);
    }
    
    public CommonTypesProto.Priority getPriority() {
      CommonTypesProto.Priority priority1 = this.priority_;
      CommonTypesProto.Priority priority2 = priority1;
      if (priority1 == null)
        priority2 = CommonTypesProto.Priority.getDefaultInstance(); 
      return priority2;
    }
    
    public String getProjectNumber() {
      return this.projectNumber_;
    }
    
    public ByteString getProjectNumberBytes() {
      return ByteString.copyFromUtf8(this.projectNumber_);
    }
    
    public CommonTypesProto.CampaignTime getScheduledEndTime() {
      CommonTypesProto.CampaignTime campaignTime1 = this.scheduledEndTime_;
      CommonTypesProto.CampaignTime campaignTime2 = campaignTime1;
      if (campaignTime1 == null)
        campaignTime2 = CommonTypesProto.CampaignTime.getDefaultInstance(); 
      return campaignTime2;
    }
    
    public Timestamp getScheduledEndTimestamp() {
      Timestamp timestamp1 = this.scheduledEndTimestamp_;
      Timestamp timestamp2 = timestamp1;
      if (timestamp1 == null)
        timestamp2 = Timestamp.getDefaultInstance(); 
      return timestamp2;
    }
    
    public CommonTypesProto.CampaignTime getScheduledStartTime() {
      CommonTypesProto.CampaignTime campaignTime1 = this.scheduledStartTime_;
      CommonTypesProto.CampaignTime campaignTime2 = campaignTime1;
      if (campaignTime1 == null)
        campaignTime2 = CommonTypesProto.CampaignTime.getDefaultInstance(); 
      return campaignTime2;
    }
    
    public Timestamp getScheduledStartTimestamp() {
      Timestamp timestamp1 = this.scheduledStartTimestamp_;
      Timestamp timestamp2 = timestamp1;
      if (timestamp1 == null)
        timestamp2 = Timestamp.getDefaultInstance(); 
      return timestamp2;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      boolean bool = this.projectNumber_.isEmpty();
      boolean bool1 = false;
      if (!bool) {
        i = CodedOutputStream.computeStringSize(1, getProjectNumber()) + 0;
      } else {
        i = 0;
      } 
      int j = i;
      if (!this.campaignId_.isEmpty())
        j = i + CodedOutputStream.computeStringSize(2, getCampaignId()); 
      i = j;
      if (this.state_ != CommonTypesProto.CampaignState.UNKNOWN_CAMPAIGN_STATE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(3, this.state_); 
      j = i;
      if (!this.displayName_.isEmpty())
        j = i + CodedOutputStream.computeStringSize(4, getDisplayName()); 
      int k = j;
      if (!this.description_.isEmpty())
        k = j + CodedOutputStream.computeStringSize(5, getDescription()); 
      i = k;
      if (this.scheduledStartTime_ != null)
        i = k + CodedOutputStream.computeMessageSize(6, (MessageLite)getScheduledStartTime()); 
      j = i;
      if (this.scheduledEndTime_ != null)
        j = i + CodedOutputStream.computeMessageSize(7, (MessageLite)getScheduledEndTime()); 
      i = j;
      if (this.targetingCondition_ != null)
        i = j + CodedOutputStream.computeMessageSize(8, (MessageLite)getTargetingCondition()); 
      for (j = 0; j < this.triggeringConditions_.size(); j++)
        i += CodedOutputStream.computeMessageSize(9, (MessageLite)this.triggeringConditions_.get(j)); 
      j = i;
      if (this.priority_ != null)
        j = i + CodedOutputStream.computeMessageSize(10, (MessageLite)getPriority()); 
      k = bool1;
      i = j;
      if (this.content_ != null) {
        i = j + CodedOutputStream.computeMessageSize(11, (MessageLite)getContent());
        k = bool1;
      } 
      while (k < this.conversionEvent_.size()) {
        i += CodedOutputStream.computeMessageSize(12, (MessageLite)this.conversionEvent_.get(k));
        k++;
      } 
      j = i;
      if (this.scheduledStartTimestamp_ != null)
        j = i + CodedOutputStream.computeMessageSize(13, (MessageLite)getScheduledStartTimestamp()); 
      i = j;
      if (this.scheduledEndTimestamp_ != null)
        i = j + CodedOutputStream.computeMessageSize(14, (MessageLite)getScheduledEndTimestamp()); 
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public CommonTypesProto.CampaignState getState() {
      CommonTypesProto.CampaignState campaignState1 = CommonTypesProto.CampaignState.forNumber(this.state_);
      CommonTypesProto.CampaignState campaignState2 = campaignState1;
      if (campaignState1 == null)
        campaignState2 = CommonTypesProto.CampaignState.UNRECOGNIZED; 
      return campaignState2;
    }
    
    public int getStateValue() {
      return this.state_;
    }
    
    public Conditions.Condition getTargetingCondition() {
      Conditions.Condition condition1 = this.targetingCondition_;
      Conditions.Condition condition2 = condition1;
      if (condition1 == null)
        condition2 = Conditions.Condition.getDefaultInstance(); 
      return condition2;
    }
    
    public CommonTypesProto.TriggeringCondition getTriggeringConditions(int param1Int) {
      return (CommonTypesProto.TriggeringCondition)this.triggeringConditions_.get(param1Int);
    }
    
    public int getTriggeringConditionsCount() {
      return this.triggeringConditions_.size();
    }
    
    public List<CommonTypesProto.TriggeringCondition> getTriggeringConditionsList() {
      return (List<CommonTypesProto.TriggeringCondition>)this.triggeringConditions_;
    }
    
    public CommonTypesProto.TriggeringConditionOrBuilder getTriggeringConditionsOrBuilder(int param1Int) {
      return (CommonTypesProto.TriggeringConditionOrBuilder)this.triggeringConditions_.get(param1Int);
    }
    
    public List<? extends CommonTypesProto.TriggeringConditionOrBuilder> getTriggeringConditionsOrBuilderList() {
      return (List)this.triggeringConditions_;
    }
    
    public boolean hasContent() {
      boolean bool;
      if (this.content_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasPriority() {
      boolean bool;
      if (this.priority_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasScheduledEndTime() {
      boolean bool;
      if (this.scheduledEndTime_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasScheduledEndTimestamp() {
      boolean bool;
      if (this.scheduledEndTimestamp_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasScheduledStartTime() {
      boolean bool;
      if (this.scheduledStartTime_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasScheduledStartTimestamp() {
      boolean bool;
      if (this.scheduledStartTimestamp_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
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
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.projectNumber_.isEmpty())
        param1CodedOutputStream.writeString(1, getProjectNumber()); 
      if (!this.campaignId_.isEmpty())
        param1CodedOutputStream.writeString(2, getCampaignId()); 
      if (this.state_ != CommonTypesProto.CampaignState.UNKNOWN_CAMPAIGN_STATE.getNumber())
        param1CodedOutputStream.writeEnum(3, this.state_); 
      if (!this.displayName_.isEmpty())
        param1CodedOutputStream.writeString(4, getDisplayName()); 
      if (!this.description_.isEmpty())
        param1CodedOutputStream.writeString(5, getDescription()); 
      if (this.scheduledStartTime_ != null)
        param1CodedOutputStream.writeMessage(6, (MessageLite)getScheduledStartTime()); 
      if (this.scheduledEndTime_ != null)
        param1CodedOutputStream.writeMessage(7, (MessageLite)getScheduledEndTime()); 
      if (this.targetingCondition_ != null)
        param1CodedOutputStream.writeMessage(8, (MessageLite)getTargetingCondition()); 
      boolean bool = false;
      byte b;
      for (b = 0; b < this.triggeringConditions_.size(); b++)
        param1CodedOutputStream.writeMessage(9, (MessageLite)this.triggeringConditions_.get(b)); 
      if (this.priority_ != null)
        param1CodedOutputStream.writeMessage(10, (MessageLite)getPriority()); 
      b = bool;
      if (this.content_ != null) {
        param1CodedOutputStream.writeMessage(11, (MessageLite)getContent());
        b = bool;
      } 
      while (b < this.conversionEvent_.size()) {
        param1CodedOutputStream.writeMessage(12, (MessageLite)this.conversionEvent_.get(b));
        b++;
      } 
      if (this.scheduledStartTimestamp_ != null)
        param1CodedOutputStream.writeMessage(13, (MessageLite)getScheduledStartTimestamp()); 
      if (this.scheduledEndTimestamp_ != null)
        param1CodedOutputStream.writeMessage(14, (MessageLite)getScheduledEndTimestamp()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Campaign, Builder> implements CampaignProto.CampaignOrBuilder {
      private Builder() {
        super(CampaignProto.Campaign.DEFAULT_INSTANCE);
      }
      
      public Builder addAllConversionEvent(Iterable<? extends CommonTypesProto.ScionConversionEvent> param2Iterable) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).addAllConversionEvent(param2Iterable);
        return this;
      }
      
      public Builder addAllTriggeringConditions(Iterable<? extends CommonTypesProto.TriggeringCondition> param2Iterable) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).addAllTriggeringConditions(param2Iterable);
        return this;
      }
      
      public Builder addConversionEvent(int param2Int, CommonTypesProto.ScionConversionEvent.Builder param2Builder) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).addConversionEvent(param2Int, param2Builder);
        return this;
      }
      
      public Builder addConversionEvent(int param2Int, CommonTypesProto.ScionConversionEvent param2ScionConversionEvent) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).addConversionEvent(param2Int, param2ScionConversionEvent);
        return this;
      }
      
      public Builder addConversionEvent(CommonTypesProto.ScionConversionEvent.Builder param2Builder) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).addConversionEvent(param2Builder);
        return this;
      }
      
      public Builder addConversionEvent(CommonTypesProto.ScionConversionEvent param2ScionConversionEvent) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).addConversionEvent(param2ScionConversionEvent);
        return this;
      }
      
      public Builder addTriggeringConditions(int param2Int, CommonTypesProto.TriggeringCondition.Builder param2Builder) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).addTriggeringConditions(param2Int, param2Builder);
        return this;
      }
      
      public Builder addTriggeringConditions(int param2Int, CommonTypesProto.TriggeringCondition param2TriggeringCondition) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).addTriggeringConditions(param2Int, param2TriggeringCondition);
        return this;
      }
      
      public Builder addTriggeringConditions(CommonTypesProto.TriggeringCondition.Builder param2Builder) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).addTriggeringConditions(param2Builder);
        return this;
      }
      
      public Builder addTriggeringConditions(CommonTypesProto.TriggeringCondition param2TriggeringCondition) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).addTriggeringConditions(param2TriggeringCondition);
        return this;
      }
      
      public Builder clearCampaignId() {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).clearCampaignId();
        return this;
      }
      
      public Builder clearContent() {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).clearContent();
        return this;
      }
      
      public Builder clearConversionEvent() {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).clearConversionEvent();
        return this;
      }
      
      public Builder clearDescription() {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).clearDescription();
        return this;
      }
      
      public Builder clearDisplayName() {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).clearDisplayName();
        return this;
      }
      
      public Builder clearPriority() {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).clearPriority();
        return this;
      }
      
      public Builder clearProjectNumber() {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).clearProjectNumber();
        return this;
      }
      
      public Builder clearScheduledEndTime() {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).clearScheduledEndTime();
        return this;
      }
      
      public Builder clearScheduledEndTimestamp() {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).clearScheduledEndTimestamp();
        return this;
      }
      
      public Builder clearScheduledStartTime() {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).clearScheduledStartTime();
        return this;
      }
      
      public Builder clearScheduledStartTimestamp() {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).clearScheduledStartTimestamp();
        return this;
      }
      
      public Builder clearState() {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).clearState();
        return this;
      }
      
      public Builder clearTargetingCondition() {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).clearTargetingCondition();
        return this;
      }
      
      public Builder clearTriggeringConditions() {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).clearTriggeringConditions();
        return this;
      }
      
      public String getCampaignId() {
        return ((CampaignProto.Campaign)this.instance).getCampaignId();
      }
      
      public ByteString getCampaignIdBytes() {
        return ((CampaignProto.Campaign)this.instance).getCampaignIdBytes();
      }
      
      public MessagesProto.Content getContent() {
        return ((CampaignProto.Campaign)this.instance).getContent();
      }
      
      public CommonTypesProto.ScionConversionEvent getConversionEvent(int param2Int) {
        return ((CampaignProto.Campaign)this.instance).getConversionEvent(param2Int);
      }
      
      public int getConversionEventCount() {
        return ((CampaignProto.Campaign)this.instance).getConversionEventCount();
      }
      
      public List<CommonTypesProto.ScionConversionEvent> getConversionEventList() {
        return Collections.unmodifiableList(((CampaignProto.Campaign)this.instance).getConversionEventList());
      }
      
      public String getDescription() {
        return ((CampaignProto.Campaign)this.instance).getDescription();
      }
      
      public ByteString getDescriptionBytes() {
        return ((CampaignProto.Campaign)this.instance).getDescriptionBytes();
      }
      
      public String getDisplayName() {
        return ((CampaignProto.Campaign)this.instance).getDisplayName();
      }
      
      public ByteString getDisplayNameBytes() {
        return ((CampaignProto.Campaign)this.instance).getDisplayNameBytes();
      }
      
      public CommonTypesProto.Priority getPriority() {
        return ((CampaignProto.Campaign)this.instance).getPriority();
      }
      
      public String getProjectNumber() {
        return ((CampaignProto.Campaign)this.instance).getProjectNumber();
      }
      
      public ByteString getProjectNumberBytes() {
        return ((CampaignProto.Campaign)this.instance).getProjectNumberBytes();
      }
      
      public CommonTypesProto.CampaignTime getScheduledEndTime() {
        return ((CampaignProto.Campaign)this.instance).getScheduledEndTime();
      }
      
      public Timestamp getScheduledEndTimestamp() {
        return ((CampaignProto.Campaign)this.instance).getScheduledEndTimestamp();
      }
      
      public CommonTypesProto.CampaignTime getScheduledStartTime() {
        return ((CampaignProto.Campaign)this.instance).getScheduledStartTime();
      }
      
      public Timestamp getScheduledStartTimestamp() {
        return ((CampaignProto.Campaign)this.instance).getScheduledStartTimestamp();
      }
      
      public CommonTypesProto.CampaignState getState() {
        return ((CampaignProto.Campaign)this.instance).getState();
      }
      
      public int getStateValue() {
        return ((CampaignProto.Campaign)this.instance).getStateValue();
      }
      
      public Conditions.Condition getTargetingCondition() {
        return ((CampaignProto.Campaign)this.instance).getTargetingCondition();
      }
      
      public CommonTypesProto.TriggeringCondition getTriggeringConditions(int param2Int) {
        return ((CampaignProto.Campaign)this.instance).getTriggeringConditions(param2Int);
      }
      
      public int getTriggeringConditionsCount() {
        return ((CampaignProto.Campaign)this.instance).getTriggeringConditionsCount();
      }
      
      public List<CommonTypesProto.TriggeringCondition> getTriggeringConditionsList() {
        return Collections.unmodifiableList(((CampaignProto.Campaign)this.instance).getTriggeringConditionsList());
      }
      
      public boolean hasContent() {
        return ((CampaignProto.Campaign)this.instance).hasContent();
      }
      
      public boolean hasPriority() {
        return ((CampaignProto.Campaign)this.instance).hasPriority();
      }
      
      public boolean hasScheduledEndTime() {
        return ((CampaignProto.Campaign)this.instance).hasScheduledEndTime();
      }
      
      public boolean hasScheduledEndTimestamp() {
        return ((CampaignProto.Campaign)this.instance).hasScheduledEndTimestamp();
      }
      
      public boolean hasScheduledStartTime() {
        return ((CampaignProto.Campaign)this.instance).hasScheduledStartTime();
      }
      
      public boolean hasScheduledStartTimestamp() {
        return ((CampaignProto.Campaign)this.instance).hasScheduledStartTimestamp();
      }
      
      public boolean hasTargetingCondition() {
        return ((CampaignProto.Campaign)this.instance).hasTargetingCondition();
      }
      
      public Builder mergeContent(MessagesProto.Content param2Content) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).mergeContent(param2Content);
        return this;
      }
      
      public Builder mergePriority(CommonTypesProto.Priority param2Priority) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).mergePriority(param2Priority);
        return this;
      }
      
      public Builder mergeScheduledEndTime(CommonTypesProto.CampaignTime param2CampaignTime) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).mergeScheduledEndTime(param2CampaignTime);
        return this;
      }
      
      public Builder mergeScheduledEndTimestamp(Timestamp param2Timestamp) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).mergeScheduledEndTimestamp(param2Timestamp);
        return this;
      }
      
      public Builder mergeScheduledStartTime(CommonTypesProto.CampaignTime param2CampaignTime) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).mergeScheduledStartTime(param2CampaignTime);
        return this;
      }
      
      public Builder mergeScheduledStartTimestamp(Timestamp param2Timestamp) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).mergeScheduledStartTimestamp(param2Timestamp);
        return this;
      }
      
      public Builder mergeTargetingCondition(Conditions.Condition param2Condition) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).mergeTargetingCondition(param2Condition);
        return this;
      }
      
      public Builder removeConversionEvent(int param2Int) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).removeConversionEvent(param2Int);
        return this;
      }
      
      public Builder removeTriggeringConditions(int param2Int) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).removeTriggeringConditions(param2Int);
        return this;
      }
      
      public Builder setCampaignId(String param2String) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setCampaignId(param2String);
        return this;
      }
      
      public Builder setCampaignIdBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setCampaignIdBytes(param2ByteString);
        return this;
      }
      
      public Builder setContent(MessagesProto.Content.Builder param2Builder) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setContent(param2Builder);
        return this;
      }
      
      public Builder setContent(MessagesProto.Content param2Content) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setContent(param2Content);
        return this;
      }
      
      public Builder setConversionEvent(int param2Int, CommonTypesProto.ScionConversionEvent.Builder param2Builder) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setConversionEvent(param2Int, param2Builder);
        return this;
      }
      
      public Builder setConversionEvent(int param2Int, CommonTypesProto.ScionConversionEvent param2ScionConversionEvent) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setConversionEvent(param2Int, param2ScionConversionEvent);
        return this;
      }
      
      public Builder setDescription(String param2String) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setDescription(param2String);
        return this;
      }
      
      public Builder setDescriptionBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setDescriptionBytes(param2ByteString);
        return this;
      }
      
      public Builder setDisplayName(String param2String) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setDisplayName(param2String);
        return this;
      }
      
      public Builder setDisplayNameBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setDisplayNameBytes(param2ByteString);
        return this;
      }
      
      public Builder setPriority(CommonTypesProto.Priority.Builder param2Builder) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setPriority(param2Builder);
        return this;
      }
      
      public Builder setPriority(CommonTypesProto.Priority param2Priority) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setPriority(param2Priority);
        return this;
      }
      
      public Builder setProjectNumber(String param2String) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setProjectNumber(param2String);
        return this;
      }
      
      public Builder setProjectNumberBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setProjectNumberBytes(param2ByteString);
        return this;
      }
      
      public Builder setScheduledEndTime(CommonTypesProto.CampaignTime.Builder param2Builder) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setScheduledEndTime(param2Builder);
        return this;
      }
      
      public Builder setScheduledEndTime(CommonTypesProto.CampaignTime param2CampaignTime) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setScheduledEndTime(param2CampaignTime);
        return this;
      }
      
      public Builder setScheduledEndTimestamp(Timestamp.Builder param2Builder) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setScheduledEndTimestamp(param2Builder);
        return this;
      }
      
      public Builder setScheduledEndTimestamp(Timestamp param2Timestamp) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setScheduledEndTimestamp(param2Timestamp);
        return this;
      }
      
      public Builder setScheduledStartTime(CommonTypesProto.CampaignTime.Builder param2Builder) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setScheduledStartTime(param2Builder);
        return this;
      }
      
      public Builder setScheduledStartTime(CommonTypesProto.CampaignTime param2CampaignTime) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setScheduledStartTime(param2CampaignTime);
        return this;
      }
      
      public Builder setScheduledStartTimestamp(Timestamp.Builder param2Builder) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setScheduledStartTimestamp(param2Builder);
        return this;
      }
      
      public Builder setScheduledStartTimestamp(Timestamp param2Timestamp) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setScheduledStartTimestamp(param2Timestamp);
        return this;
      }
      
      public Builder setState(CommonTypesProto.CampaignState param2CampaignState) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setState(param2CampaignState);
        return this;
      }
      
      public Builder setStateValue(int param2Int) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setStateValue(param2Int);
        return this;
      }
      
      public Builder setTargetingCondition(Conditions.Condition.Builder param2Builder) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setTargetingCondition(param2Builder);
        return this;
      }
      
      public Builder setTargetingCondition(Conditions.Condition param2Condition) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setTargetingCondition(param2Condition);
        return this;
      }
      
      public Builder setTriggeringConditions(int param2Int, CommonTypesProto.TriggeringCondition.Builder param2Builder) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setTriggeringConditions(param2Int, param2Builder);
        return this;
      }
      
      public Builder setTriggeringConditions(int param2Int, CommonTypesProto.TriggeringCondition param2TriggeringCondition) {
        copyOnWrite();
        ((CampaignProto.Campaign)this.instance).setTriggeringConditions(param2Int, param2TriggeringCondition);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Campaign, Campaign.Builder> implements CampaignOrBuilder {
    private Builder() {
      super(CampaignProto.Campaign.DEFAULT_INSTANCE);
    }
    
    public Builder addAllConversionEvent(Iterable<? extends CommonTypesProto.ScionConversionEvent> param1Iterable) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).addAllConversionEvent(param1Iterable);
      return this;
    }
    
    public Builder addAllTriggeringConditions(Iterable<? extends CommonTypesProto.TriggeringCondition> param1Iterable) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).addAllTriggeringConditions(param1Iterable);
      return this;
    }
    
    public Builder addConversionEvent(int param1Int, CommonTypesProto.ScionConversionEvent.Builder param1Builder) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).addConversionEvent(param1Int, param1Builder);
      return this;
    }
    
    public Builder addConversionEvent(int param1Int, CommonTypesProto.ScionConversionEvent param1ScionConversionEvent) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).addConversionEvent(param1Int, param1ScionConversionEvent);
      return this;
    }
    
    public Builder addConversionEvent(CommonTypesProto.ScionConversionEvent.Builder param1Builder) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).addConversionEvent(param1Builder);
      return this;
    }
    
    public Builder addConversionEvent(CommonTypesProto.ScionConversionEvent param1ScionConversionEvent) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).addConversionEvent(param1ScionConversionEvent);
      return this;
    }
    
    public Builder addTriggeringConditions(int param1Int, CommonTypesProto.TriggeringCondition.Builder param1Builder) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).addTriggeringConditions(param1Int, param1Builder);
      return this;
    }
    
    public Builder addTriggeringConditions(int param1Int, CommonTypesProto.TriggeringCondition param1TriggeringCondition) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).addTriggeringConditions(param1Int, param1TriggeringCondition);
      return this;
    }
    
    public Builder addTriggeringConditions(CommonTypesProto.TriggeringCondition.Builder param1Builder) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).addTriggeringConditions(param1Builder);
      return this;
    }
    
    public Builder addTriggeringConditions(CommonTypesProto.TriggeringCondition param1TriggeringCondition) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).addTriggeringConditions(param1TriggeringCondition);
      return this;
    }
    
    public Builder clearCampaignId() {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).clearCampaignId();
      return this;
    }
    
    public Builder clearContent() {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).clearContent();
      return this;
    }
    
    public Builder clearConversionEvent() {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).clearConversionEvent();
      return this;
    }
    
    public Builder clearDescription() {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).clearDescription();
      return this;
    }
    
    public Builder clearDisplayName() {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).clearDisplayName();
      return this;
    }
    
    public Builder clearPriority() {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).clearPriority();
      return this;
    }
    
    public Builder clearProjectNumber() {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).clearProjectNumber();
      return this;
    }
    
    public Builder clearScheduledEndTime() {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).clearScheduledEndTime();
      return this;
    }
    
    public Builder clearScheduledEndTimestamp() {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).clearScheduledEndTimestamp();
      return this;
    }
    
    public Builder clearScheduledStartTime() {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).clearScheduledStartTime();
      return this;
    }
    
    public Builder clearScheduledStartTimestamp() {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).clearScheduledStartTimestamp();
      return this;
    }
    
    public Builder clearState() {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).clearState();
      return this;
    }
    
    public Builder clearTargetingCondition() {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).clearTargetingCondition();
      return this;
    }
    
    public Builder clearTriggeringConditions() {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).clearTriggeringConditions();
      return this;
    }
    
    public String getCampaignId() {
      return ((CampaignProto.Campaign)this.instance).getCampaignId();
    }
    
    public ByteString getCampaignIdBytes() {
      return ((CampaignProto.Campaign)this.instance).getCampaignIdBytes();
    }
    
    public MessagesProto.Content getContent() {
      return ((CampaignProto.Campaign)this.instance).getContent();
    }
    
    public CommonTypesProto.ScionConversionEvent getConversionEvent(int param1Int) {
      return ((CampaignProto.Campaign)this.instance).getConversionEvent(param1Int);
    }
    
    public int getConversionEventCount() {
      return ((CampaignProto.Campaign)this.instance).getConversionEventCount();
    }
    
    public List<CommonTypesProto.ScionConversionEvent> getConversionEventList() {
      return Collections.unmodifiableList(((CampaignProto.Campaign)this.instance).getConversionEventList());
    }
    
    public String getDescription() {
      return ((CampaignProto.Campaign)this.instance).getDescription();
    }
    
    public ByteString getDescriptionBytes() {
      return ((CampaignProto.Campaign)this.instance).getDescriptionBytes();
    }
    
    public String getDisplayName() {
      return ((CampaignProto.Campaign)this.instance).getDisplayName();
    }
    
    public ByteString getDisplayNameBytes() {
      return ((CampaignProto.Campaign)this.instance).getDisplayNameBytes();
    }
    
    public CommonTypesProto.Priority getPriority() {
      return ((CampaignProto.Campaign)this.instance).getPriority();
    }
    
    public String getProjectNumber() {
      return ((CampaignProto.Campaign)this.instance).getProjectNumber();
    }
    
    public ByteString getProjectNumberBytes() {
      return ((CampaignProto.Campaign)this.instance).getProjectNumberBytes();
    }
    
    public CommonTypesProto.CampaignTime getScheduledEndTime() {
      return ((CampaignProto.Campaign)this.instance).getScheduledEndTime();
    }
    
    public Timestamp getScheduledEndTimestamp() {
      return ((CampaignProto.Campaign)this.instance).getScheduledEndTimestamp();
    }
    
    public CommonTypesProto.CampaignTime getScheduledStartTime() {
      return ((CampaignProto.Campaign)this.instance).getScheduledStartTime();
    }
    
    public Timestamp getScheduledStartTimestamp() {
      return ((CampaignProto.Campaign)this.instance).getScheduledStartTimestamp();
    }
    
    public CommonTypesProto.CampaignState getState() {
      return ((CampaignProto.Campaign)this.instance).getState();
    }
    
    public int getStateValue() {
      return ((CampaignProto.Campaign)this.instance).getStateValue();
    }
    
    public Conditions.Condition getTargetingCondition() {
      return ((CampaignProto.Campaign)this.instance).getTargetingCondition();
    }
    
    public CommonTypesProto.TriggeringCondition getTriggeringConditions(int param1Int) {
      return ((CampaignProto.Campaign)this.instance).getTriggeringConditions(param1Int);
    }
    
    public int getTriggeringConditionsCount() {
      return ((CampaignProto.Campaign)this.instance).getTriggeringConditionsCount();
    }
    
    public List<CommonTypesProto.TriggeringCondition> getTriggeringConditionsList() {
      return Collections.unmodifiableList(((CampaignProto.Campaign)this.instance).getTriggeringConditionsList());
    }
    
    public boolean hasContent() {
      return ((CampaignProto.Campaign)this.instance).hasContent();
    }
    
    public boolean hasPriority() {
      return ((CampaignProto.Campaign)this.instance).hasPriority();
    }
    
    public boolean hasScheduledEndTime() {
      return ((CampaignProto.Campaign)this.instance).hasScheduledEndTime();
    }
    
    public boolean hasScheduledEndTimestamp() {
      return ((CampaignProto.Campaign)this.instance).hasScheduledEndTimestamp();
    }
    
    public boolean hasScheduledStartTime() {
      return ((CampaignProto.Campaign)this.instance).hasScheduledStartTime();
    }
    
    public boolean hasScheduledStartTimestamp() {
      return ((CampaignProto.Campaign)this.instance).hasScheduledStartTimestamp();
    }
    
    public boolean hasTargetingCondition() {
      return ((CampaignProto.Campaign)this.instance).hasTargetingCondition();
    }
    
    public Builder mergeContent(MessagesProto.Content param1Content) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).mergeContent(param1Content);
      return this;
    }
    
    public Builder mergePriority(CommonTypesProto.Priority param1Priority) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).mergePriority(param1Priority);
      return this;
    }
    
    public Builder mergeScheduledEndTime(CommonTypesProto.CampaignTime param1CampaignTime) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).mergeScheduledEndTime(param1CampaignTime);
      return this;
    }
    
    public Builder mergeScheduledEndTimestamp(Timestamp param1Timestamp) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).mergeScheduledEndTimestamp(param1Timestamp);
      return this;
    }
    
    public Builder mergeScheduledStartTime(CommonTypesProto.CampaignTime param1CampaignTime) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).mergeScheduledStartTime(param1CampaignTime);
      return this;
    }
    
    public Builder mergeScheduledStartTimestamp(Timestamp param1Timestamp) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).mergeScheduledStartTimestamp(param1Timestamp);
      return this;
    }
    
    public Builder mergeTargetingCondition(Conditions.Condition param1Condition) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).mergeTargetingCondition(param1Condition);
      return this;
    }
    
    public Builder removeConversionEvent(int param1Int) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).removeConversionEvent(param1Int);
      return this;
    }
    
    public Builder removeTriggeringConditions(int param1Int) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).removeTriggeringConditions(param1Int);
      return this;
    }
    
    public Builder setCampaignId(String param1String) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setCampaignId(param1String);
      return this;
    }
    
    public Builder setCampaignIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setCampaignIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setContent(MessagesProto.Content.Builder param1Builder) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setContent(param1Builder);
      return this;
    }
    
    public Builder setContent(MessagesProto.Content param1Content) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setContent(param1Content);
      return this;
    }
    
    public Builder setConversionEvent(int param1Int, CommonTypesProto.ScionConversionEvent.Builder param1Builder) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setConversionEvent(param1Int, param1Builder);
      return this;
    }
    
    public Builder setConversionEvent(int param1Int, CommonTypesProto.ScionConversionEvent param1ScionConversionEvent) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setConversionEvent(param1Int, param1ScionConversionEvent);
      return this;
    }
    
    public Builder setDescription(String param1String) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setDescription(param1String);
      return this;
    }
    
    public Builder setDescriptionBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setDescriptionBytes(param1ByteString);
      return this;
    }
    
    public Builder setDisplayName(String param1String) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setDisplayName(param1String);
      return this;
    }
    
    public Builder setDisplayNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setDisplayNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setPriority(CommonTypesProto.Priority.Builder param1Builder) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setPriority(param1Builder);
      return this;
    }
    
    public Builder setPriority(CommonTypesProto.Priority param1Priority) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setPriority(param1Priority);
      return this;
    }
    
    public Builder setProjectNumber(String param1String) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setProjectNumber(param1String);
      return this;
    }
    
    public Builder setProjectNumberBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setProjectNumberBytes(param1ByteString);
      return this;
    }
    
    public Builder setScheduledEndTime(CommonTypesProto.CampaignTime.Builder param1Builder) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setScheduledEndTime(param1Builder);
      return this;
    }
    
    public Builder setScheduledEndTime(CommonTypesProto.CampaignTime param1CampaignTime) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setScheduledEndTime(param1CampaignTime);
      return this;
    }
    
    public Builder setScheduledEndTimestamp(Timestamp.Builder param1Builder) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setScheduledEndTimestamp(param1Builder);
      return this;
    }
    
    public Builder setScheduledEndTimestamp(Timestamp param1Timestamp) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setScheduledEndTimestamp(param1Timestamp);
      return this;
    }
    
    public Builder setScheduledStartTime(CommonTypesProto.CampaignTime.Builder param1Builder) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setScheduledStartTime(param1Builder);
      return this;
    }
    
    public Builder setScheduledStartTime(CommonTypesProto.CampaignTime param1CampaignTime) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setScheduledStartTime(param1CampaignTime);
      return this;
    }
    
    public Builder setScheduledStartTimestamp(Timestamp.Builder param1Builder) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setScheduledStartTimestamp(param1Builder);
      return this;
    }
    
    public Builder setScheduledStartTimestamp(Timestamp param1Timestamp) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setScheduledStartTimestamp(param1Timestamp);
      return this;
    }
    
    public Builder setState(CommonTypesProto.CampaignState param1CampaignState) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setState(param1CampaignState);
      return this;
    }
    
    public Builder setStateValue(int param1Int) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setStateValue(param1Int);
      return this;
    }
    
    public Builder setTargetingCondition(Conditions.Condition.Builder param1Builder) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setTargetingCondition(param1Builder);
      return this;
    }
    
    public Builder setTargetingCondition(Conditions.Condition param1Condition) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setTargetingCondition(param1Condition);
      return this;
    }
    
    public Builder setTriggeringConditions(int param1Int, CommonTypesProto.TriggeringCondition.Builder param1Builder) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setTriggeringConditions(param1Int, param1Builder);
      return this;
    }
    
    public Builder setTriggeringConditions(int param1Int, CommonTypesProto.TriggeringCondition param1TriggeringCondition) {
      copyOnWrite();
      ((CampaignProto.Campaign)this.instance).setTriggeringConditions(param1Int, param1TriggeringCondition);
      return this;
    }
  }
  
  public static interface CampaignOrBuilder extends MessageLiteOrBuilder {
    String getCampaignId();
    
    ByteString getCampaignIdBytes();
    
    MessagesProto.Content getContent();
    
    CommonTypesProto.ScionConversionEvent getConversionEvent(int param1Int);
    
    int getConversionEventCount();
    
    List<CommonTypesProto.ScionConversionEvent> getConversionEventList();
    
    String getDescription();
    
    ByteString getDescriptionBytes();
    
    String getDisplayName();
    
    ByteString getDisplayNameBytes();
    
    CommonTypesProto.Priority getPriority();
    
    String getProjectNumber();
    
    ByteString getProjectNumberBytes();
    
    CommonTypesProto.CampaignTime getScheduledEndTime();
    
    Timestamp getScheduledEndTimestamp();
    
    CommonTypesProto.CampaignTime getScheduledStartTime();
    
    Timestamp getScheduledStartTimestamp();
    
    CommonTypesProto.CampaignState getState();
    
    int getStateValue();
    
    Conditions.Condition getTargetingCondition();
    
    CommonTypesProto.TriggeringCondition getTriggeringConditions(int param1Int);
    
    int getTriggeringConditionsCount();
    
    List<CommonTypesProto.TriggeringCondition> getTriggeringConditionsList();
    
    boolean hasContent();
    
    boolean hasPriority();
    
    boolean hasScheduledEndTime();
    
    boolean hasScheduledEndTimestamp();
    
    boolean hasScheduledStartTime();
    
    boolean hasScheduledStartTimestamp();
    
    boolean hasTargetingCondition();
  }
  
  public static final class ExperimentalCampaignPayload extends GeneratedMessageLite<ExperimentalCampaignPayload, ExperimentalCampaignPayload.Builder> implements ExperimentalCampaignPayloadOrBuilder {
    public static final int CAMPAIGN_ID_FIELD_NUMBER = 1;
    
    private static final ExperimentalCampaignPayload DEFAULT_INSTANCE = new ExperimentalCampaignPayload();
    
    public static final int EXPERIMENT_PAYLOAD_FIELD_NUMBER = 2;
    
    private static volatile Parser<ExperimentalCampaignPayload> PARSER;
    
    private String campaignId_ = "";
    
    private FirebaseAbt.ExperimentPayload experimentPayload_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearCampaignId() {
      this.campaignId_ = getDefaultInstance().getCampaignId();
    }
    
    private void clearExperimentPayload() {
      this.experimentPayload_ = null;
    }
    
    public static ExperimentalCampaignPayload getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeExperimentPayload(FirebaseAbt.ExperimentPayload param1ExperimentPayload) {
      FirebaseAbt.ExperimentPayload experimentPayload = this.experimentPayload_;
      if (experimentPayload != null && experimentPayload != FirebaseAbt.ExperimentPayload.getDefaultInstance()) {
        this.experimentPayload_ = (FirebaseAbt.ExperimentPayload)((FirebaseAbt.ExperimentPayload.Builder)FirebaseAbt.ExperimentPayload.newBuilder(this.experimentPayload_).mergeFrom((GeneratedMessageLite)param1ExperimentPayload)).buildPartial();
      } else {
        this.experimentPayload_ = param1ExperimentPayload;
      } 
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ExperimentalCampaignPayload param1ExperimentalCampaignPayload) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1ExperimentalCampaignPayload);
    }
    
    public static ExperimentalCampaignPayload parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (ExperimentalCampaignPayload)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static ExperimentalCampaignPayload parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ExperimentalCampaignPayload)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ExperimentalCampaignPayload parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (ExperimentalCampaignPayload)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static ExperimentalCampaignPayload parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ExperimentalCampaignPayload)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static ExperimentalCampaignPayload parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (ExperimentalCampaignPayload)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static ExperimentalCampaignPayload parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ExperimentalCampaignPayload)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static ExperimentalCampaignPayload parseFrom(InputStream param1InputStream) throws IOException {
      return (ExperimentalCampaignPayload)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static ExperimentalCampaignPayload parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ExperimentalCampaignPayload)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ExperimentalCampaignPayload parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (ExperimentalCampaignPayload)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static ExperimentalCampaignPayload parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ExperimentalCampaignPayload)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<ExperimentalCampaignPayload> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setCampaignId(String param1String) {
      if (param1String != null) {
        this.campaignId_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setCampaignIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.campaignId_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setExperimentPayload(FirebaseAbt.ExperimentPayload.Builder param1Builder) {
      this.experimentPayload_ = (FirebaseAbt.ExperimentPayload)param1Builder.build();
    }
    
    private void setExperimentPayload(FirebaseAbt.ExperimentPayload param1ExperimentPayload) {
      if (param1ExperimentPayload != null) {
        this.experimentPayload_ = param1ExperimentPayload;
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 392, 2 -> 388, 3 -> 386, 4 -> 377, 5 -> 304, 6 -> 110, 7 -> 300, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignPayload.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignPayload
      //   72: monitorenter
      //   73: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignPayload.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignPayload.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignPayload;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignPayload.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignPayload
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignPayload
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignPayload.PARSER : Lcom/google/protobuf/Parser;
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
      //   169: getfield experimentPayload_ : Ldevelopers/mobile/abt/FirebaseAbt$ExperimentPayload;
      //   172: ifnull -> 189
      //   175: aload_0
      //   176: getfield experimentPayload_ : Ldevelopers/mobile/abt/FirebaseAbt$ExperimentPayload;
      //   179: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   182: checkcast developers/mobile/abt/FirebaseAbt$ExperimentPayload$Builder
      //   185: astore_1
      //   186: goto -> 191
      //   189: aconst_null
      //   190: astore_1
      //   191: aload_0
      //   192: aload_2
      //   193: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   196: aload_3
      //   197: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   200: checkcast developers/mobile/abt/FirebaseAbt$ExperimentPayload
      //   203: putfield experimentPayload_ : Ldevelopers/mobile/abt/FirebaseAbt$ExperimentPayload;
      //   206: aload_1
      //   207: ifnull -> 123
      //   210: aload_1
      //   211: aload_0
      //   212: getfield experimentPayload_ : Ldevelopers/mobile/abt/FirebaseAbt$ExperimentPayload;
      //   215: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   218: pop
      //   219: aload_0
      //   220: aload_1
      //   221: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   224: checkcast developers/mobile/abt/FirebaseAbt$ExperimentPayload
      //   227: putfield experimentPayload_ : Ldevelopers/mobile/abt/FirebaseAbt$ExperimentPayload;
      //   230: goto -> 123
      //   233: aload_0
      //   234: aload_2
      //   235: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   238: putfield campaignId_ : Ljava/lang/String;
      //   241: goto -> 123
      //   244: iconst_1
      //   245: istore #4
      //   247: goto -> 123
      //   250: astore_1
      //   251: goto -> 298
      //   254: astore_1
      //   255: new java/lang/RuntimeException
      //   258: astore_2
      //   259: new com/google/protobuf/InvalidProtocolBufferException
      //   262: astore_3
      //   263: aload_3
      //   264: aload_1
      //   265: invokevirtual getMessage : ()Ljava/lang/String;
      //   268: invokespecial <init> : (Ljava/lang/String;)V
      //   271: aload_2
      //   272: aload_3
      //   273: aload_0
      //   274: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   277: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   280: aload_2
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
      //   300: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignPayload.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignPayload;
      //   303: areturn
      //   304: aload_2
      //   305: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   308: astore_1
      //   309: aload_3
      //   310: checkcast com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignPayload
      //   313: astore_2
      //   314: aload_0
      //   315: aload_1
      //   316: aload_0
      //   317: getfield campaignId_ : Ljava/lang/String;
      //   320: invokevirtual isEmpty : ()Z
      //   323: iconst_1
      //   324: ixor
      //   325: aload_0
      //   326: getfield campaignId_ : Ljava/lang/String;
      //   329: iconst_1
      //   330: aload_2
      //   331: getfield campaignId_ : Ljava/lang/String;
      //   334: invokevirtual isEmpty : ()Z
      //   337: ixor
      //   338: aload_2
      //   339: getfield campaignId_ : Ljava/lang/String;
      //   342: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   347: putfield campaignId_ : Ljava/lang/String;
      //   350: aload_0
      //   351: aload_1
      //   352: aload_0
      //   353: getfield experimentPayload_ : Ldevelopers/mobile/abt/FirebaseAbt$ExperimentPayload;
      //   356: aload_2
      //   357: getfield experimentPayload_ : Ldevelopers/mobile/abt/FirebaseAbt$ExperimentPayload;
      //   360: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   365: checkcast developers/mobile/abt/FirebaseAbt$ExperimentPayload
      //   368: putfield experimentPayload_ : Ldevelopers/mobile/abt/FirebaseAbt$ExperimentPayload;
      //   371: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   374: astore_1
      //   375: aload_0
      //   376: areturn
      //   377: new com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignPayload$Builder
      //   380: dup
      //   381: aconst_null
      //   382: invokespecial <init> : (Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$1;)V
      //   385: areturn
      //   386: aconst_null
      //   387: areturn
      //   388: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignPayload.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignPayload;
      //   391: areturn
      //   392: new com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignPayload
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
    
    public String getCampaignId() {
      return this.campaignId_;
    }
    
    public ByteString getCampaignIdBytes() {
      return ByteString.copyFromUtf8(this.campaignId_);
    }
    
    public FirebaseAbt.ExperimentPayload getExperimentPayload() {
      FirebaseAbt.ExperimentPayload experimentPayload1 = this.experimentPayload_;
      FirebaseAbt.ExperimentPayload experimentPayload2 = experimentPayload1;
      if (experimentPayload1 == null)
        experimentPayload2 = FirebaseAbt.ExperimentPayload.getDefaultInstance(); 
      return experimentPayload2;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (!this.campaignId_.isEmpty())
        i = 0 + CodedOutputStream.computeStringSize(1, getCampaignId()); 
      int j = i;
      if (this.experimentPayload_ != null)
        j = i + CodedOutputStream.computeMessageSize(2, (MessageLite)getExperimentPayload()); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public boolean hasExperimentPayload() {
      boolean bool;
      if (this.experimentPayload_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.campaignId_.isEmpty())
        param1CodedOutputStream.writeString(1, getCampaignId()); 
      if (this.experimentPayload_ != null)
        param1CodedOutputStream.writeMessage(2, (MessageLite)getExperimentPayload()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<ExperimentalCampaignPayload, Builder> implements CampaignProto.ExperimentalCampaignPayloadOrBuilder {
      private Builder() {
        super(CampaignProto.ExperimentalCampaignPayload.DEFAULT_INSTANCE);
      }
      
      public Builder clearCampaignId() {
        copyOnWrite();
        ((CampaignProto.ExperimentalCampaignPayload)this.instance).clearCampaignId();
        return this;
      }
      
      public Builder clearExperimentPayload() {
        copyOnWrite();
        ((CampaignProto.ExperimentalCampaignPayload)this.instance).clearExperimentPayload();
        return this;
      }
      
      public String getCampaignId() {
        return ((CampaignProto.ExperimentalCampaignPayload)this.instance).getCampaignId();
      }
      
      public ByteString getCampaignIdBytes() {
        return ((CampaignProto.ExperimentalCampaignPayload)this.instance).getCampaignIdBytes();
      }
      
      public FirebaseAbt.ExperimentPayload getExperimentPayload() {
        return ((CampaignProto.ExperimentalCampaignPayload)this.instance).getExperimentPayload();
      }
      
      public boolean hasExperimentPayload() {
        return ((CampaignProto.ExperimentalCampaignPayload)this.instance).hasExperimentPayload();
      }
      
      public Builder mergeExperimentPayload(FirebaseAbt.ExperimentPayload param2ExperimentPayload) {
        copyOnWrite();
        ((CampaignProto.ExperimentalCampaignPayload)this.instance).mergeExperimentPayload(param2ExperimentPayload);
        return this;
      }
      
      public Builder setCampaignId(String param2String) {
        copyOnWrite();
        ((CampaignProto.ExperimentalCampaignPayload)this.instance).setCampaignId(param2String);
        return this;
      }
      
      public Builder setCampaignIdBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((CampaignProto.ExperimentalCampaignPayload)this.instance).setCampaignIdBytes(param2ByteString);
        return this;
      }
      
      public Builder setExperimentPayload(FirebaseAbt.ExperimentPayload.Builder param2Builder) {
        copyOnWrite();
        ((CampaignProto.ExperimentalCampaignPayload)this.instance).setExperimentPayload(param2Builder);
        return this;
      }
      
      public Builder setExperimentPayload(FirebaseAbt.ExperimentPayload param2ExperimentPayload) {
        copyOnWrite();
        ((CampaignProto.ExperimentalCampaignPayload)this.instance).setExperimentPayload(param2ExperimentPayload);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ExperimentalCampaignPayload, ExperimentalCampaignPayload.Builder> implements ExperimentalCampaignPayloadOrBuilder {
    private Builder() {
      super(CampaignProto.ExperimentalCampaignPayload.DEFAULT_INSTANCE);
    }
    
    public Builder clearCampaignId() {
      copyOnWrite();
      ((CampaignProto.ExperimentalCampaignPayload)this.instance).clearCampaignId();
      return this;
    }
    
    public Builder clearExperimentPayload() {
      copyOnWrite();
      ((CampaignProto.ExperimentalCampaignPayload)this.instance).clearExperimentPayload();
      return this;
    }
    
    public String getCampaignId() {
      return ((CampaignProto.ExperimentalCampaignPayload)this.instance).getCampaignId();
    }
    
    public ByteString getCampaignIdBytes() {
      return ((CampaignProto.ExperimentalCampaignPayload)this.instance).getCampaignIdBytes();
    }
    
    public FirebaseAbt.ExperimentPayload getExperimentPayload() {
      return ((CampaignProto.ExperimentalCampaignPayload)this.instance).getExperimentPayload();
    }
    
    public boolean hasExperimentPayload() {
      return ((CampaignProto.ExperimentalCampaignPayload)this.instance).hasExperimentPayload();
    }
    
    public Builder mergeExperimentPayload(FirebaseAbt.ExperimentPayload param1ExperimentPayload) {
      copyOnWrite();
      ((CampaignProto.ExperimentalCampaignPayload)this.instance).mergeExperimentPayload(param1ExperimentPayload);
      return this;
    }
    
    public Builder setCampaignId(String param1String) {
      copyOnWrite();
      ((CampaignProto.ExperimentalCampaignPayload)this.instance).setCampaignId(param1String);
      return this;
    }
    
    public Builder setCampaignIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((CampaignProto.ExperimentalCampaignPayload)this.instance).setCampaignIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setExperimentPayload(FirebaseAbt.ExperimentPayload.Builder param1Builder) {
      copyOnWrite();
      ((CampaignProto.ExperimentalCampaignPayload)this.instance).setExperimentPayload(param1Builder);
      return this;
    }
    
    public Builder setExperimentPayload(FirebaseAbt.ExperimentPayload param1ExperimentPayload) {
      copyOnWrite();
      ((CampaignProto.ExperimentalCampaignPayload)this.instance).setExperimentPayload(param1ExperimentPayload);
      return this;
    }
  }
  
  public static interface ExperimentalCampaignPayloadOrBuilder extends MessageLiteOrBuilder {
    String getCampaignId();
    
    ByteString getCampaignIdBytes();
    
    FirebaseAbt.ExperimentPayload getExperimentPayload();
    
    boolean hasExperimentPayload();
  }
  
  public static final class ExperimentalCampaignRollout extends GeneratedMessageLite<ExperimentalCampaignRollout, ExperimentalCampaignRollout.Builder> implements ExperimentalCampaignRolloutOrBuilder {
    private static final ExperimentalCampaignRollout DEFAULT_INSTANCE = new ExperimentalCampaignRollout();
    
    public static final int END_TIME_FIELD_NUMBER = 5;
    
    public static final int EXPERIMENT_ID_FIELD_NUMBER = 1;
    
    private static volatile Parser<ExperimentalCampaignRollout> PARSER;
    
    public static final int PRIORITY_FIELD_NUMBER = 3;
    
    public static final int SELECTED_VARIANT_INDEX_FIELD_NUMBER = 2;
    
    public static final int START_TIME_FIELD_NUMBER = 4;
    
    private CommonTypesProto.CampaignTime endTime_;
    
    private String experimentId_ = "";
    
    private CommonTypesProto.Priority priority_;
    
    private int selectedVariantIndex_;
    
    private CommonTypesProto.CampaignTime startTime_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearEndTime() {
      this.endTime_ = null;
    }
    
    private void clearExperimentId() {
      this.experimentId_ = getDefaultInstance().getExperimentId();
    }
    
    private void clearPriority() {
      this.priority_ = null;
    }
    
    private void clearSelectedVariantIndex() {
      this.selectedVariantIndex_ = 0;
    }
    
    private void clearStartTime() {
      this.startTime_ = null;
    }
    
    public static ExperimentalCampaignRollout getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeEndTime(CommonTypesProto.CampaignTime param1CampaignTime) {
      CommonTypesProto.CampaignTime campaignTime = this.endTime_;
      if (campaignTime != null && campaignTime != CommonTypesProto.CampaignTime.getDefaultInstance()) {
        this.endTime_ = (CommonTypesProto.CampaignTime)((CommonTypesProto.CampaignTime.Builder)CommonTypesProto.CampaignTime.newBuilder(this.endTime_).mergeFrom((GeneratedMessageLite)param1CampaignTime)).buildPartial();
      } else {
        this.endTime_ = param1CampaignTime;
      } 
    }
    
    private void mergePriority(CommonTypesProto.Priority param1Priority) {
      CommonTypesProto.Priority priority = this.priority_;
      if (priority != null && priority != CommonTypesProto.Priority.getDefaultInstance()) {
        this.priority_ = (CommonTypesProto.Priority)((CommonTypesProto.Priority.Builder)CommonTypesProto.Priority.newBuilder(this.priority_).mergeFrom((GeneratedMessageLite)param1Priority)).buildPartial();
      } else {
        this.priority_ = param1Priority;
      } 
    }
    
    private void mergeStartTime(CommonTypesProto.CampaignTime param1CampaignTime) {
      CommonTypesProto.CampaignTime campaignTime = this.startTime_;
      if (campaignTime != null && campaignTime != CommonTypesProto.CampaignTime.getDefaultInstance()) {
        this.startTime_ = (CommonTypesProto.CampaignTime)((CommonTypesProto.CampaignTime.Builder)CommonTypesProto.CampaignTime.newBuilder(this.startTime_).mergeFrom((GeneratedMessageLite)param1CampaignTime)).buildPartial();
      } else {
        this.startTime_ = param1CampaignTime;
      } 
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ExperimentalCampaignRollout param1ExperimentalCampaignRollout) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1ExperimentalCampaignRollout);
    }
    
    public static ExperimentalCampaignRollout parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (ExperimentalCampaignRollout)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static ExperimentalCampaignRollout parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ExperimentalCampaignRollout)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ExperimentalCampaignRollout parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (ExperimentalCampaignRollout)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static ExperimentalCampaignRollout parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ExperimentalCampaignRollout)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static ExperimentalCampaignRollout parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (ExperimentalCampaignRollout)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static ExperimentalCampaignRollout parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ExperimentalCampaignRollout)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static ExperimentalCampaignRollout parseFrom(InputStream param1InputStream) throws IOException {
      return (ExperimentalCampaignRollout)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static ExperimentalCampaignRollout parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ExperimentalCampaignRollout)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ExperimentalCampaignRollout parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (ExperimentalCampaignRollout)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static ExperimentalCampaignRollout parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ExperimentalCampaignRollout)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<ExperimentalCampaignRollout> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setEndTime(CommonTypesProto.CampaignTime.Builder param1Builder) {
      this.endTime_ = (CommonTypesProto.CampaignTime)param1Builder.build();
    }
    
    private void setEndTime(CommonTypesProto.CampaignTime param1CampaignTime) {
      if (param1CampaignTime != null) {
        this.endTime_ = param1CampaignTime;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setExperimentId(String param1String) {
      if (param1String != null) {
        this.experimentId_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setExperimentIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.experimentId_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setPriority(CommonTypesProto.Priority.Builder param1Builder) {
      this.priority_ = (CommonTypesProto.Priority)param1Builder.build();
    }
    
    private void setPriority(CommonTypesProto.Priority param1Priority) {
      if (param1Priority != null) {
        this.priority_ = param1Priority;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setSelectedVariantIndex(int param1Int) {
      this.selectedVariantIndex_ = param1Int;
    }
    
    private void setStartTime(CommonTypesProto.CampaignTime.Builder param1Builder) {
      this.startTime_ = (CommonTypesProto.CampaignTime)param1Builder.build();
    }
    
    private void setStartTime(CommonTypesProto.CampaignTime param1CampaignTime) {
      if (param1CampaignTime != null) {
        this.startTime_ = param1CampaignTime;
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: istore #4
      //   10: iconst_0
      //   11: istore #5
      //   13: iconst_0
      //   14: istore #6
      //   16: iload #4
      //   18: tableswitch default -> 64, 1 -> 653, 2 -> 649, 3 -> 647, 4 -> 638, 5 -> 471, 6 -> 118, 7 -> 467, 8 -> 72
      //   64: new java/lang/UnsupportedOperationException
      //   67: dup
      //   68: invokespecial <init> : ()V
      //   71: athrow
      //   72: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout.PARSER : Lcom/google/protobuf/Parser;
      //   75: ifnonnull -> 114
      //   78: ldc com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout
      //   80: monitorenter
      //   81: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout.PARSER : Lcom/google/protobuf/Parser;
      //   84: ifnonnull -> 102
      //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   90: astore_1
      //   91: aload_1
      //   92: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout;
      //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   98: aload_1
      //   99: putstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout.PARSER : Lcom/google/protobuf/Parser;
      //   102: ldc com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout
      //   104: monitorexit
      //   105: goto -> 114
      //   108: astore_1
      //   109: ldc com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout
      //   111: monitorexit
      //   112: aload_1
      //   113: athrow
      //   114: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout.PARSER : Lcom/google/protobuf/Parser;
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
      //   153: bipush #16
      //   155: if_icmpeq -> 389
      //   158: iload #4
      //   160: bipush #26
      //   162: if_icmpeq -> 324
      //   165: iload #4
      //   167: bipush #34
      //   169: if_icmpeq -> 259
      //   172: iload #4
      //   174: bipush #42
      //   176: if_icmpeq -> 194
      //   179: aload_2
      //   180: iload #4
      //   182: invokevirtual skipField : (I)Z
      //   185: ifne -> 128
      //   188: iconst_1
      //   189: istore #6
      //   191: goto -> 128
      //   194: aload_0
      //   195: getfield endTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   198: ifnull -> 215
      //   201: aload_0
      //   202: getfield endTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   205: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   208: checkcast com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime$Builder
      //   211: astore_1
      //   212: goto -> 217
      //   215: aconst_null
      //   216: astore_1
      //   217: aload_0
      //   218: aload_2
      //   219: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   222: aload_3
      //   223: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   226: checkcast com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime
      //   229: putfield endTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   232: aload_1
      //   233: ifnull -> 128
      //   236: aload_1
      //   237: aload_0
      //   238: getfield endTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   241: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   244: pop
      //   245: aload_0
      //   246: aload_1
      //   247: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   250: checkcast com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime
      //   253: putfield endTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   256: goto -> 128
      //   259: aload_0
      //   260: getfield startTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   263: ifnull -> 280
      //   266: aload_0
      //   267: getfield startTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   270: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   273: checkcast com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime$Builder
      //   276: astore_1
      //   277: goto -> 282
      //   280: aconst_null
      //   281: astore_1
      //   282: aload_0
      //   283: aload_2
      //   284: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   287: aload_3
      //   288: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   291: checkcast com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime
      //   294: putfield startTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   297: aload_1
      //   298: ifnull -> 128
      //   301: aload_1
      //   302: aload_0
      //   303: getfield startTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   306: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   309: pop
      //   310: aload_0
      //   311: aload_1
      //   312: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   315: checkcast com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime
      //   318: putfield startTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   321: goto -> 128
      //   324: aload_0
      //   325: getfield priority_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$Priority;
      //   328: ifnull -> 345
      //   331: aload_0
      //   332: getfield priority_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$Priority;
      //   335: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   338: checkcast com/google/firebase/inappmessaging/CommonTypesProto$Priority$Builder
      //   341: astore_1
      //   342: goto -> 347
      //   345: aconst_null
      //   346: astore_1
      //   347: aload_0
      //   348: aload_2
      //   349: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   352: aload_3
      //   353: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   356: checkcast com/google/firebase/inappmessaging/CommonTypesProto$Priority
      //   359: putfield priority_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$Priority;
      //   362: aload_1
      //   363: ifnull -> 128
      //   366: aload_1
      //   367: aload_0
      //   368: getfield priority_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$Priority;
      //   371: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   374: pop
      //   375: aload_0
      //   376: aload_1
      //   377: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   380: checkcast com/google/firebase/inappmessaging/CommonTypesProto$Priority
      //   383: putfield priority_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$Priority;
      //   386: goto -> 128
      //   389: aload_0
      //   390: aload_2
      //   391: invokevirtual readInt32 : ()I
      //   394: putfield selectedVariantIndex_ : I
      //   397: goto -> 128
      //   400: aload_0
      //   401: aload_2
      //   402: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   405: putfield experimentId_ : Ljava/lang/String;
      //   408: goto -> 128
      //   411: iconst_1
      //   412: istore #6
      //   414: goto -> 128
      //   417: astore_1
      //   418: goto -> 465
      //   421: astore_1
      //   422: new java/lang/RuntimeException
      //   425: astore_2
      //   426: new com/google/protobuf/InvalidProtocolBufferException
      //   429: astore_3
      //   430: aload_3
      //   431: aload_1
      //   432: invokevirtual getMessage : ()Ljava/lang/String;
      //   435: invokespecial <init> : (Ljava/lang/String;)V
      //   438: aload_2
      //   439: aload_3
      //   440: aload_0
      //   441: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   444: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   447: aload_2
      //   448: athrow
      //   449: astore_2
      //   450: new java/lang/RuntimeException
      //   453: astore_1
      //   454: aload_1
      //   455: aload_2
      //   456: aload_0
      //   457: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   460: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   463: aload_1
      //   464: athrow
      //   465: aload_1
      //   466: athrow
      //   467: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout;
      //   470: areturn
      //   471: aload_2
      //   472: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   475: astore_1
      //   476: aload_3
      //   477: checkcast com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout
      //   480: astore_2
      //   481: aload_0
      //   482: aload_1
      //   483: aload_0
      //   484: getfield experimentId_ : Ljava/lang/String;
      //   487: invokevirtual isEmpty : ()Z
      //   490: iconst_1
      //   491: ixor
      //   492: aload_0
      //   493: getfield experimentId_ : Ljava/lang/String;
      //   496: aload_2
      //   497: getfield experimentId_ : Ljava/lang/String;
      //   500: invokevirtual isEmpty : ()Z
      //   503: iconst_1
      //   504: ixor
      //   505: aload_2
      //   506: getfield experimentId_ : Ljava/lang/String;
      //   509: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   514: putfield experimentId_ : Ljava/lang/String;
      //   517: aload_0
      //   518: getfield selectedVariantIndex_ : I
      //   521: ifeq -> 530
      //   524: iconst_1
      //   525: istore #7
      //   527: goto -> 533
      //   530: iconst_0
      //   531: istore #7
      //   533: aload_0
      //   534: getfield selectedVariantIndex_ : I
      //   537: istore #6
      //   539: aload_2
      //   540: getfield selectedVariantIndex_ : I
      //   543: ifeq -> 549
      //   546: iconst_1
      //   547: istore #5
      //   549: aload_0
      //   550: aload_1
      //   551: iload #7
      //   553: iload #6
      //   555: iload #5
      //   557: aload_2
      //   558: getfield selectedVariantIndex_ : I
      //   561: invokeinterface visitInt : (ZIZI)I
      //   566: putfield selectedVariantIndex_ : I
      //   569: aload_0
      //   570: aload_1
      //   571: aload_0
      //   572: getfield priority_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$Priority;
      //   575: aload_2
      //   576: getfield priority_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$Priority;
      //   579: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   584: checkcast com/google/firebase/inappmessaging/CommonTypesProto$Priority
      //   587: putfield priority_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$Priority;
      //   590: aload_0
      //   591: aload_1
      //   592: aload_0
      //   593: getfield startTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   596: aload_2
      //   597: getfield startTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   600: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   605: checkcast com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime
      //   608: putfield startTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   611: aload_0
      //   612: aload_1
      //   613: aload_0
      //   614: getfield endTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   617: aload_2
      //   618: getfield endTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   621: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   626: checkcast com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime
      //   629: putfield endTime_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   632: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   635: astore_1
      //   636: aload_0
      //   637: areturn
      //   638: new com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout$Builder
      //   641: dup
      //   642: aconst_null
      //   643: invokespecial <init> : (Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$1;)V
      //   646: areturn
      //   647: aconst_null
      //   648: areturn
      //   649: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout;
      //   652: areturn
      //   653: new com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignRollout
      //   656: dup
      //   657: invokespecial <init> : ()V
      //   660: areturn
      // Exception table:
      //   from	to	target	type
      //   81	102	108	finally
      //   102	105	108	finally
      //   109	112	108	finally
      //   133	139	449	com/google/protobuf/InvalidProtocolBufferException
      //   133	139	421	java/io/IOException
      //   133	139	417	finally
      //   179	188	449	com/google/protobuf/InvalidProtocolBufferException
      //   179	188	421	java/io/IOException
      //   179	188	417	finally
      //   194	212	449	com/google/protobuf/InvalidProtocolBufferException
      //   194	212	421	java/io/IOException
      //   194	212	417	finally
      //   217	232	449	com/google/protobuf/InvalidProtocolBufferException
      //   217	232	421	java/io/IOException
      //   217	232	417	finally
      //   236	256	449	com/google/protobuf/InvalidProtocolBufferException
      //   236	256	421	java/io/IOException
      //   236	256	417	finally
      //   259	277	449	com/google/protobuf/InvalidProtocolBufferException
      //   259	277	421	java/io/IOException
      //   259	277	417	finally
      //   282	297	449	com/google/protobuf/InvalidProtocolBufferException
      //   282	297	421	java/io/IOException
      //   282	297	417	finally
      //   301	321	449	com/google/protobuf/InvalidProtocolBufferException
      //   301	321	421	java/io/IOException
      //   301	321	417	finally
      //   324	342	449	com/google/protobuf/InvalidProtocolBufferException
      //   324	342	421	java/io/IOException
      //   324	342	417	finally
      //   347	362	449	com/google/protobuf/InvalidProtocolBufferException
      //   347	362	421	java/io/IOException
      //   347	362	417	finally
      //   366	386	449	com/google/protobuf/InvalidProtocolBufferException
      //   366	386	421	java/io/IOException
      //   366	386	417	finally
      //   389	397	449	com/google/protobuf/InvalidProtocolBufferException
      //   389	397	421	java/io/IOException
      //   389	397	417	finally
      //   400	408	449	com/google/protobuf/InvalidProtocolBufferException
      //   400	408	421	java/io/IOException
      //   400	408	417	finally
      //   422	449	417	finally
      //   450	465	417	finally
    }
    
    public CommonTypesProto.CampaignTime getEndTime() {
      CommonTypesProto.CampaignTime campaignTime1 = this.endTime_;
      CommonTypesProto.CampaignTime campaignTime2 = campaignTime1;
      if (campaignTime1 == null)
        campaignTime2 = CommonTypesProto.CampaignTime.getDefaultInstance(); 
      return campaignTime2;
    }
    
    public String getExperimentId() {
      return this.experimentId_;
    }
    
    public ByteString getExperimentIdBytes() {
      return ByteString.copyFromUtf8(this.experimentId_);
    }
    
    public CommonTypesProto.Priority getPriority() {
      CommonTypesProto.Priority priority1 = this.priority_;
      CommonTypesProto.Priority priority2 = priority1;
      if (priority1 == null)
        priority2 = CommonTypesProto.Priority.getDefaultInstance(); 
      return priority2;
    }
    
    public int getSelectedVariantIndex() {
      return this.selectedVariantIndex_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (!this.experimentId_.isEmpty())
        j = 0 + CodedOutputStream.computeStringSize(1, getExperimentId()); 
      int k = this.selectedVariantIndex_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(2, k); 
      j = i;
      if (this.priority_ != null)
        j = i + CodedOutputStream.computeMessageSize(3, (MessageLite)getPriority()); 
      i = j;
      if (this.startTime_ != null)
        i = j + CodedOutputStream.computeMessageSize(4, (MessageLite)getStartTime()); 
      j = i;
      if (this.endTime_ != null)
        j = i + CodedOutputStream.computeMessageSize(5, (MessageLite)getEndTime()); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public CommonTypesProto.CampaignTime getStartTime() {
      CommonTypesProto.CampaignTime campaignTime1 = this.startTime_;
      CommonTypesProto.CampaignTime campaignTime2 = campaignTime1;
      if (campaignTime1 == null)
        campaignTime2 = CommonTypesProto.CampaignTime.getDefaultInstance(); 
      return campaignTime2;
    }
    
    public boolean hasEndTime() {
      boolean bool;
      if (this.endTime_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasPriority() {
      boolean bool;
      if (this.priority_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasStartTime() {
      boolean bool;
      if (this.startTime_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.experimentId_.isEmpty())
        param1CodedOutputStream.writeString(1, getExperimentId()); 
      int i = this.selectedVariantIndex_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(2, i); 
      if (this.priority_ != null)
        param1CodedOutputStream.writeMessage(3, (MessageLite)getPriority()); 
      if (this.startTime_ != null)
        param1CodedOutputStream.writeMessage(4, (MessageLite)getStartTime()); 
      if (this.endTime_ != null)
        param1CodedOutputStream.writeMessage(5, (MessageLite)getEndTime()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<ExperimentalCampaignRollout, Builder> implements CampaignProto.ExperimentalCampaignRolloutOrBuilder {
      private Builder() {
        super(CampaignProto.ExperimentalCampaignRollout.DEFAULT_INSTANCE);
      }
      
      public Builder clearEndTime() {
        copyOnWrite();
        ((CampaignProto.ExperimentalCampaignRollout)this.instance).clearEndTime();
        return this;
      }
      
      public Builder clearExperimentId() {
        copyOnWrite();
        ((CampaignProto.ExperimentalCampaignRollout)this.instance).clearExperimentId();
        return this;
      }
      
      public Builder clearPriority() {
        copyOnWrite();
        ((CampaignProto.ExperimentalCampaignRollout)this.instance).clearPriority();
        return this;
      }
      
      public Builder clearSelectedVariantIndex() {
        copyOnWrite();
        ((CampaignProto.ExperimentalCampaignRollout)this.instance).clearSelectedVariantIndex();
        return this;
      }
      
      public Builder clearStartTime() {
        copyOnWrite();
        ((CampaignProto.ExperimentalCampaignRollout)this.instance).clearStartTime();
        return this;
      }
      
      public CommonTypesProto.CampaignTime getEndTime() {
        return ((CampaignProto.ExperimentalCampaignRollout)this.instance).getEndTime();
      }
      
      public String getExperimentId() {
        return ((CampaignProto.ExperimentalCampaignRollout)this.instance).getExperimentId();
      }
      
      public ByteString getExperimentIdBytes() {
        return ((CampaignProto.ExperimentalCampaignRollout)this.instance).getExperimentIdBytes();
      }
      
      public CommonTypesProto.Priority getPriority() {
        return ((CampaignProto.ExperimentalCampaignRollout)this.instance).getPriority();
      }
      
      public int getSelectedVariantIndex() {
        return ((CampaignProto.ExperimentalCampaignRollout)this.instance).getSelectedVariantIndex();
      }
      
      public CommonTypesProto.CampaignTime getStartTime() {
        return ((CampaignProto.ExperimentalCampaignRollout)this.instance).getStartTime();
      }
      
      public boolean hasEndTime() {
        return ((CampaignProto.ExperimentalCampaignRollout)this.instance).hasEndTime();
      }
      
      public boolean hasPriority() {
        return ((CampaignProto.ExperimentalCampaignRollout)this.instance).hasPriority();
      }
      
      public boolean hasStartTime() {
        return ((CampaignProto.ExperimentalCampaignRollout)this.instance).hasStartTime();
      }
      
      public Builder mergeEndTime(CommonTypesProto.CampaignTime param2CampaignTime) {
        copyOnWrite();
        ((CampaignProto.ExperimentalCampaignRollout)this.instance).mergeEndTime(param2CampaignTime);
        return this;
      }
      
      public Builder mergePriority(CommonTypesProto.Priority param2Priority) {
        copyOnWrite();
        ((CampaignProto.ExperimentalCampaignRollout)this.instance).mergePriority(param2Priority);
        return this;
      }
      
      public Builder mergeStartTime(CommonTypesProto.CampaignTime param2CampaignTime) {
        copyOnWrite();
        ((CampaignProto.ExperimentalCampaignRollout)this.instance).mergeStartTime(param2CampaignTime);
        return this;
      }
      
      public Builder setEndTime(CommonTypesProto.CampaignTime.Builder param2Builder) {
        copyOnWrite();
        ((CampaignProto.ExperimentalCampaignRollout)this.instance).setEndTime(param2Builder);
        return this;
      }
      
      public Builder setEndTime(CommonTypesProto.CampaignTime param2CampaignTime) {
        copyOnWrite();
        ((CampaignProto.ExperimentalCampaignRollout)this.instance).setEndTime(param2CampaignTime);
        return this;
      }
      
      public Builder setExperimentId(String param2String) {
        copyOnWrite();
        ((CampaignProto.ExperimentalCampaignRollout)this.instance).setExperimentId(param2String);
        return this;
      }
      
      public Builder setExperimentIdBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((CampaignProto.ExperimentalCampaignRollout)this.instance).setExperimentIdBytes(param2ByteString);
        return this;
      }
      
      public Builder setPriority(CommonTypesProto.Priority.Builder param2Builder) {
        copyOnWrite();
        ((CampaignProto.ExperimentalCampaignRollout)this.instance).setPriority(param2Builder);
        return this;
      }
      
      public Builder setPriority(CommonTypesProto.Priority param2Priority) {
        copyOnWrite();
        ((CampaignProto.ExperimentalCampaignRollout)this.instance).setPriority(param2Priority);
        return this;
      }
      
      public Builder setSelectedVariantIndex(int param2Int) {
        copyOnWrite();
        ((CampaignProto.ExperimentalCampaignRollout)this.instance).setSelectedVariantIndex(param2Int);
        return this;
      }
      
      public Builder setStartTime(CommonTypesProto.CampaignTime.Builder param2Builder) {
        copyOnWrite();
        ((CampaignProto.ExperimentalCampaignRollout)this.instance).setStartTime(param2Builder);
        return this;
      }
      
      public Builder setStartTime(CommonTypesProto.CampaignTime param2CampaignTime) {
        copyOnWrite();
        ((CampaignProto.ExperimentalCampaignRollout)this.instance).setStartTime(param2CampaignTime);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ExperimentalCampaignRollout, ExperimentalCampaignRollout.Builder> implements ExperimentalCampaignRolloutOrBuilder {
    private Builder() {
      super(CampaignProto.ExperimentalCampaignRollout.DEFAULT_INSTANCE);
    }
    
    public Builder clearEndTime() {
      copyOnWrite();
      ((CampaignProto.ExperimentalCampaignRollout)this.instance).clearEndTime();
      return this;
    }
    
    public Builder clearExperimentId() {
      copyOnWrite();
      ((CampaignProto.ExperimentalCampaignRollout)this.instance).clearExperimentId();
      return this;
    }
    
    public Builder clearPriority() {
      copyOnWrite();
      ((CampaignProto.ExperimentalCampaignRollout)this.instance).clearPriority();
      return this;
    }
    
    public Builder clearSelectedVariantIndex() {
      copyOnWrite();
      ((CampaignProto.ExperimentalCampaignRollout)this.instance).clearSelectedVariantIndex();
      return this;
    }
    
    public Builder clearStartTime() {
      copyOnWrite();
      ((CampaignProto.ExperimentalCampaignRollout)this.instance).clearStartTime();
      return this;
    }
    
    public CommonTypesProto.CampaignTime getEndTime() {
      return ((CampaignProto.ExperimentalCampaignRollout)this.instance).getEndTime();
    }
    
    public String getExperimentId() {
      return ((CampaignProto.ExperimentalCampaignRollout)this.instance).getExperimentId();
    }
    
    public ByteString getExperimentIdBytes() {
      return ((CampaignProto.ExperimentalCampaignRollout)this.instance).getExperimentIdBytes();
    }
    
    public CommonTypesProto.Priority getPriority() {
      return ((CampaignProto.ExperimentalCampaignRollout)this.instance).getPriority();
    }
    
    public int getSelectedVariantIndex() {
      return ((CampaignProto.ExperimentalCampaignRollout)this.instance).getSelectedVariantIndex();
    }
    
    public CommonTypesProto.CampaignTime getStartTime() {
      return ((CampaignProto.ExperimentalCampaignRollout)this.instance).getStartTime();
    }
    
    public boolean hasEndTime() {
      return ((CampaignProto.ExperimentalCampaignRollout)this.instance).hasEndTime();
    }
    
    public boolean hasPriority() {
      return ((CampaignProto.ExperimentalCampaignRollout)this.instance).hasPriority();
    }
    
    public boolean hasStartTime() {
      return ((CampaignProto.ExperimentalCampaignRollout)this.instance).hasStartTime();
    }
    
    public Builder mergeEndTime(CommonTypesProto.CampaignTime param1CampaignTime) {
      copyOnWrite();
      ((CampaignProto.ExperimentalCampaignRollout)this.instance).mergeEndTime(param1CampaignTime);
      return this;
    }
    
    public Builder mergePriority(CommonTypesProto.Priority param1Priority) {
      copyOnWrite();
      ((CampaignProto.ExperimentalCampaignRollout)this.instance).mergePriority(param1Priority);
      return this;
    }
    
    public Builder mergeStartTime(CommonTypesProto.CampaignTime param1CampaignTime) {
      copyOnWrite();
      ((CampaignProto.ExperimentalCampaignRollout)this.instance).mergeStartTime(param1CampaignTime);
      return this;
    }
    
    public Builder setEndTime(CommonTypesProto.CampaignTime.Builder param1Builder) {
      copyOnWrite();
      ((CampaignProto.ExperimentalCampaignRollout)this.instance).setEndTime(param1Builder);
      return this;
    }
    
    public Builder setEndTime(CommonTypesProto.CampaignTime param1CampaignTime) {
      copyOnWrite();
      ((CampaignProto.ExperimentalCampaignRollout)this.instance).setEndTime(param1CampaignTime);
      return this;
    }
    
    public Builder setExperimentId(String param1String) {
      copyOnWrite();
      ((CampaignProto.ExperimentalCampaignRollout)this.instance).setExperimentId(param1String);
      return this;
    }
    
    public Builder setExperimentIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((CampaignProto.ExperimentalCampaignRollout)this.instance).setExperimentIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setPriority(CommonTypesProto.Priority.Builder param1Builder) {
      copyOnWrite();
      ((CampaignProto.ExperimentalCampaignRollout)this.instance).setPriority(param1Builder);
      return this;
    }
    
    public Builder setPriority(CommonTypesProto.Priority param1Priority) {
      copyOnWrite();
      ((CampaignProto.ExperimentalCampaignRollout)this.instance).setPriority(param1Priority);
      return this;
    }
    
    public Builder setSelectedVariantIndex(int param1Int) {
      copyOnWrite();
      ((CampaignProto.ExperimentalCampaignRollout)this.instance).setSelectedVariantIndex(param1Int);
      return this;
    }
    
    public Builder setStartTime(CommonTypesProto.CampaignTime.Builder param1Builder) {
      copyOnWrite();
      ((CampaignProto.ExperimentalCampaignRollout)this.instance).setStartTime(param1Builder);
      return this;
    }
    
    public Builder setStartTime(CommonTypesProto.CampaignTime param1CampaignTime) {
      copyOnWrite();
      ((CampaignProto.ExperimentalCampaignRollout)this.instance).setStartTime(param1CampaignTime);
      return this;
    }
  }
  
  public static interface ExperimentalCampaignRolloutOrBuilder extends MessageLiteOrBuilder {
    CommonTypesProto.CampaignTime getEndTime();
    
    String getExperimentId();
    
    ByteString getExperimentIdBytes();
    
    CommonTypesProto.Priority getPriority();
    
    int getSelectedVariantIndex();
    
    CommonTypesProto.CampaignTime getStartTime();
    
    boolean hasEndTime();
    
    boolean hasPriority();
    
    boolean hasStartTime();
  }
  
  public static final class ThickContent extends GeneratedMessageLite<ThickContent, ThickContent.Builder> implements ThickContentOrBuilder {
    public static final int CONTENT_FIELD_NUMBER = 3;
    
    private static final ThickContent DEFAULT_INSTANCE = new ThickContent();
    
    public static final int EXPERIMENTAL_PAYLOAD_FIELD_NUMBER = 2;
    
    public static final int IS_TEST_CAMPAIGN_FIELD_NUMBER = 7;
    
    private static volatile Parser<ThickContent> PARSER;
    
    public static final int PRIORITY_FIELD_NUMBER = 4;
    
    public static final int TRIGGERING_CONDITIONS_FIELD_NUMBER = 5;
    
    public static final int VANILLA_PAYLOAD_FIELD_NUMBER = 1;
    
    private int bitField0_;
    
    private MessagesProto.Content content_;
    
    private boolean isTestCampaign_;
    
    private int payloadCase_ = 0;
    
    private Object payload_;
    
    private CommonTypesProto.Priority priority_;
    
    private Internal.ProtobufList<CommonTypesProto.TriggeringCondition> triggeringConditions_ = emptyProtobufList();
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllTriggeringConditions(Iterable<? extends CommonTypesProto.TriggeringCondition> param1Iterable) {
      ensureTriggeringConditionsIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.triggeringConditions_);
    }
    
    private void addTriggeringConditions(int param1Int, CommonTypesProto.TriggeringCondition.Builder param1Builder) {
      ensureTriggeringConditionsIsMutable();
      this.triggeringConditions_.add(param1Int, param1Builder.build());
    }
    
    private void addTriggeringConditions(int param1Int, CommonTypesProto.TriggeringCondition param1TriggeringCondition) {
      if (param1TriggeringCondition != null) {
        ensureTriggeringConditionsIsMutable();
        this.triggeringConditions_.add(param1Int, param1TriggeringCondition);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addTriggeringConditions(CommonTypesProto.TriggeringCondition.Builder param1Builder) {
      ensureTriggeringConditionsIsMutable();
      this.triggeringConditions_.add(param1Builder.build());
    }
    
    private void addTriggeringConditions(CommonTypesProto.TriggeringCondition param1TriggeringCondition) {
      if (param1TriggeringCondition != null) {
        ensureTriggeringConditionsIsMutable();
        this.triggeringConditions_.add(param1TriggeringCondition);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearContent() {
      this.content_ = null;
    }
    
    private void clearExperimentalPayload() {
      if (this.payloadCase_ == 2) {
        this.payloadCase_ = 0;
        this.payload_ = null;
      } 
    }
    
    private void clearIsTestCampaign() {
      this.isTestCampaign_ = false;
    }
    
    private void clearPayload() {
      this.payloadCase_ = 0;
      this.payload_ = null;
    }
    
    private void clearPriority() {
      this.priority_ = null;
    }
    
    private void clearTriggeringConditions() {
      this.triggeringConditions_ = emptyProtobufList();
    }
    
    private void clearVanillaPayload() {
      if (this.payloadCase_ == 1) {
        this.payloadCase_ = 0;
        this.payload_ = null;
      } 
    }
    
    private void ensureTriggeringConditionsIsMutable() {
      if (!this.triggeringConditions_.isModifiable())
        this.triggeringConditions_ = GeneratedMessageLite.mutableCopy(this.triggeringConditions_); 
    }
    
    public static ThickContent getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeContent(MessagesProto.Content param1Content) {
      MessagesProto.Content content = this.content_;
      if (content != null && content != MessagesProto.Content.getDefaultInstance()) {
        this.content_ = (MessagesProto.Content)((MessagesProto.Content.Builder)MessagesProto.Content.newBuilder(this.content_).mergeFrom((GeneratedMessageLite)param1Content)).buildPartial();
      } else {
        this.content_ = param1Content;
      } 
    }
    
    private void mergeExperimentalPayload(CampaignProto.ExperimentalCampaignPayload param1ExperimentalCampaignPayload) {
      if (this.payloadCase_ == 2 && this.payload_ != CampaignProto.ExperimentalCampaignPayload.getDefaultInstance()) {
        this.payload_ = ((CampaignProto.ExperimentalCampaignPayload.Builder)CampaignProto.ExperimentalCampaignPayload.newBuilder((CampaignProto.ExperimentalCampaignPayload)this.payload_).mergeFrom(param1ExperimentalCampaignPayload)).buildPartial();
      } else {
        this.payload_ = param1ExperimentalCampaignPayload;
      } 
      this.payloadCase_ = 2;
    }
    
    private void mergePriority(CommonTypesProto.Priority param1Priority) {
      CommonTypesProto.Priority priority = this.priority_;
      if (priority != null && priority != CommonTypesProto.Priority.getDefaultInstance()) {
        this.priority_ = (CommonTypesProto.Priority)((CommonTypesProto.Priority.Builder)CommonTypesProto.Priority.newBuilder(this.priority_).mergeFrom((GeneratedMessageLite)param1Priority)).buildPartial();
      } else {
        this.priority_ = param1Priority;
      } 
    }
    
    private void mergeVanillaPayload(CampaignProto.VanillaCampaignPayload param1VanillaCampaignPayload) {
      if (this.payloadCase_ == 1 && this.payload_ != CampaignProto.VanillaCampaignPayload.getDefaultInstance()) {
        this.payload_ = ((CampaignProto.VanillaCampaignPayload.Builder)CampaignProto.VanillaCampaignPayload.newBuilder((CampaignProto.VanillaCampaignPayload)this.payload_).mergeFrom(param1VanillaCampaignPayload)).buildPartial();
      } else {
        this.payload_ = param1VanillaCampaignPayload;
      } 
      this.payloadCase_ = 1;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ThickContent param1ThickContent) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1ThickContent);
    }
    
    public static ThickContent parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (ThickContent)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static ThickContent parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ThickContent)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ThickContent parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (ThickContent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static ThickContent parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ThickContent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static ThickContent parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (ThickContent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static ThickContent parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ThickContent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static ThickContent parseFrom(InputStream param1InputStream) throws IOException {
      return (ThickContent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static ThickContent parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ThickContent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ThickContent parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (ThickContent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static ThickContent parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ThickContent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<ThickContent> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeTriggeringConditions(int param1Int) {
      ensureTriggeringConditionsIsMutable();
      this.triggeringConditions_.remove(param1Int);
    }
    
    private void setContent(MessagesProto.Content.Builder param1Builder) {
      this.content_ = (MessagesProto.Content)param1Builder.build();
    }
    
    private void setContent(MessagesProto.Content param1Content) {
      if (param1Content != null) {
        this.content_ = param1Content;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setExperimentalPayload(CampaignProto.ExperimentalCampaignPayload.Builder param1Builder) {
      this.payload_ = param1Builder.build();
      this.payloadCase_ = 2;
    }
    
    private void setExperimentalPayload(CampaignProto.ExperimentalCampaignPayload param1ExperimentalCampaignPayload) {
      if (param1ExperimentalCampaignPayload != null) {
        this.payload_ = param1ExperimentalCampaignPayload;
        this.payloadCase_ = 2;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setIsTestCampaign(boolean param1Boolean) {
      this.isTestCampaign_ = param1Boolean;
    }
    
    private void setPriority(CommonTypesProto.Priority.Builder param1Builder) {
      this.priority_ = (CommonTypesProto.Priority)param1Builder.build();
    }
    
    private void setPriority(CommonTypesProto.Priority param1Priority) {
      if (param1Priority != null) {
        this.priority_ = param1Priority;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTriggeringConditions(int param1Int, CommonTypesProto.TriggeringCondition.Builder param1Builder) {
      ensureTriggeringConditionsIsMutable();
      this.triggeringConditions_.set(param1Int, param1Builder.build());
    }
    
    private void setTriggeringConditions(int param1Int, CommonTypesProto.TriggeringCondition param1TriggeringCondition) {
      if (param1TriggeringCondition != null) {
        ensureTriggeringConditionsIsMutable();
        this.triggeringConditions_.set(param1Int, param1TriggeringCondition);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setVanillaPayload(CampaignProto.VanillaCampaignPayload.Builder param1Builder) {
      this.payload_ = param1Builder.build();
      this.payloadCase_ = 1;
    }
    
    private void setVanillaPayload(CampaignProto.VanillaCampaignPayload param1VanillaCampaignPayload) {
      if (param1VanillaCampaignPayload != null) {
        this.payload_ = param1VanillaCampaignPayload;
        this.payloadCase_ = 1;
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
      //   22: iload #4
      //   24: tableswitch default -> 72, 1 -> 896, 2 -> 892, 3 -> 881, 4 -> 872, 5 -> 599, 6 -> 126, 7 -> 595, 8 -> 80
      //   72: new java/lang/UnsupportedOperationException
      //   75: dup
      //   76: invokespecial <init> : ()V
      //   79: athrow
      //   80: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$ThickContent.PARSER : Lcom/google/protobuf/Parser;
      //   83: ifnonnull -> 122
      //   86: ldc com/google/internal/firebase/inappmessaging/v1/CampaignProto$ThickContent
      //   88: monitorenter
      //   89: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$ThickContent.PARSER : Lcom/google/protobuf/Parser;
      //   92: ifnonnull -> 110
      //   95: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   98: astore_1
      //   99: aload_1
      //   100: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$ThickContent.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$ThickContent;
      //   103: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   106: aload_1
      //   107: putstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$ThickContent.PARSER : Lcom/google/protobuf/Parser;
      //   110: ldc com/google/internal/firebase/inappmessaging/v1/CampaignProto$ThickContent
      //   112: monitorexit
      //   113: goto -> 122
      //   116: astore_1
      //   117: ldc com/google/internal/firebase/inappmessaging/v1/CampaignProto$ThickContent
      //   119: monitorexit
      //   120: aload_1
      //   121: athrow
      //   122: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$ThickContent.PARSER : Lcom/google/protobuf/Parser;
      //   125: areturn
      //   126: aload_2
      //   127: checkcast com/google/protobuf/CodedInputStream
      //   130: astore_2
      //   131: aload_3
      //   132: checkcast com/google/protobuf/ExtensionRegistryLite
      //   135: astore_3
      //   136: iload #8
      //   138: ifne -> 595
      //   141: aload_2
      //   142: invokevirtual readTag : ()I
      //   145: istore #4
      //   147: iload #4
      //   149: ifeq -> 539
      //   152: iload #4
      //   154: bipush #10
      //   156: if_icmpeq -> 468
      //   159: iload #4
      //   161: bipush #18
      //   163: if_icmpeq -> 397
      //   166: iload #4
      //   168: bipush #26
      //   170: if_icmpeq -> 332
      //   173: iload #4
      //   175: bipush #34
      //   177: if_icmpeq -> 267
      //   180: iload #4
      //   182: bipush #42
      //   184: if_icmpeq -> 220
      //   187: iload #4
      //   189: bipush #56
      //   191: if_icmpeq -> 209
      //   194: aload_2
      //   195: iload #4
      //   197: invokevirtual skipField : (I)Z
      //   200: ifne -> 136
      //   203: iconst_1
      //   204: istore #8
      //   206: goto -> 136
      //   209: aload_0
      //   210: aload_2
      //   211: invokevirtual readBool : ()Z
      //   214: putfield isTestCampaign_ : Z
      //   217: goto -> 136
      //   220: aload_0
      //   221: getfield triggeringConditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   224: invokeinterface isModifiable : ()Z
      //   229: ifne -> 243
      //   232: aload_0
      //   233: aload_0
      //   234: getfield triggeringConditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   237: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   240: putfield triggeringConditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   243: aload_0
      //   244: getfield triggeringConditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   247: aload_2
      //   248: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   251: aload_3
      //   252: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   255: checkcast com/google/firebase/inappmessaging/CommonTypesProto$TriggeringCondition
      //   258: invokeinterface add : (Ljava/lang/Object;)Z
      //   263: pop
      //   264: goto -> 136
      //   267: aload_0
      //   268: getfield priority_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$Priority;
      //   271: ifnull -> 288
      //   274: aload_0
      //   275: getfield priority_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$Priority;
      //   278: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   281: checkcast com/google/firebase/inappmessaging/CommonTypesProto$Priority$Builder
      //   284: astore_1
      //   285: goto -> 290
      //   288: aconst_null
      //   289: astore_1
      //   290: aload_0
      //   291: aload_2
      //   292: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   295: aload_3
      //   296: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   299: checkcast com/google/firebase/inappmessaging/CommonTypesProto$Priority
      //   302: putfield priority_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$Priority;
      //   305: aload_1
      //   306: ifnull -> 136
      //   309: aload_1
      //   310: aload_0
      //   311: getfield priority_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$Priority;
      //   314: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   317: pop
      //   318: aload_0
      //   319: aload_1
      //   320: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   323: checkcast com/google/firebase/inappmessaging/CommonTypesProto$Priority
      //   326: putfield priority_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$Priority;
      //   329: goto -> 136
      //   332: aload_0
      //   333: getfield content_ : Lcom/google/firebase/inappmessaging/MessagesProto$Content;
      //   336: ifnull -> 353
      //   339: aload_0
      //   340: getfield content_ : Lcom/google/firebase/inappmessaging/MessagesProto$Content;
      //   343: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   346: checkcast com/google/firebase/inappmessaging/MessagesProto$Content$Builder
      //   349: astore_1
      //   350: goto -> 355
      //   353: aconst_null
      //   354: astore_1
      //   355: aload_0
      //   356: aload_2
      //   357: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   360: aload_3
      //   361: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   364: checkcast com/google/firebase/inappmessaging/MessagesProto$Content
      //   367: putfield content_ : Lcom/google/firebase/inappmessaging/MessagesProto$Content;
      //   370: aload_1
      //   371: ifnull -> 136
      //   374: aload_1
      //   375: aload_0
      //   376: getfield content_ : Lcom/google/firebase/inappmessaging/MessagesProto$Content;
      //   379: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   382: pop
      //   383: aload_0
      //   384: aload_1
      //   385: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   388: checkcast com/google/firebase/inappmessaging/MessagesProto$Content
      //   391: putfield content_ : Lcom/google/firebase/inappmessaging/MessagesProto$Content;
      //   394: goto -> 136
      //   397: aload_0
      //   398: getfield payloadCase_ : I
      //   401: iconst_2
      //   402: if_icmpne -> 422
      //   405: aload_0
      //   406: getfield payload_ : Ljava/lang/Object;
      //   409: checkcast com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignPayload
      //   412: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   415: checkcast com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignPayload$Builder
      //   418: astore_1
      //   419: goto -> 424
      //   422: aconst_null
      //   423: astore_1
      //   424: aload_0
      //   425: aload_2
      //   426: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   429: aload_3
      //   430: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   433: putfield payload_ : Ljava/lang/Object;
      //   436: aload_1
      //   437: ifnull -> 460
      //   440: aload_1
      //   441: aload_0
      //   442: getfield payload_ : Ljava/lang/Object;
      //   445: checkcast com/google/internal/firebase/inappmessaging/v1/CampaignProto$ExperimentalCampaignPayload
      //   448: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   451: pop
      //   452: aload_0
      //   453: aload_1
      //   454: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   457: putfield payload_ : Ljava/lang/Object;
      //   460: aload_0
      //   461: iconst_2
      //   462: putfield payloadCase_ : I
      //   465: goto -> 136
      //   468: aload_0
      //   469: getfield payloadCase_ : I
      //   472: iconst_1
      //   473: if_icmpne -> 493
      //   476: aload_0
      //   477: getfield payload_ : Ljava/lang/Object;
      //   480: checkcast com/google/internal/firebase/inappmessaging/v1/CampaignProto$VanillaCampaignPayload
      //   483: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   486: checkcast com/google/internal/firebase/inappmessaging/v1/CampaignProto$VanillaCampaignPayload$Builder
      //   489: astore_1
      //   490: goto -> 495
      //   493: aconst_null
      //   494: astore_1
      //   495: aload_0
      //   496: aload_2
      //   497: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   500: aload_3
      //   501: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   504: putfield payload_ : Ljava/lang/Object;
      //   507: aload_1
      //   508: ifnull -> 531
      //   511: aload_1
      //   512: aload_0
      //   513: getfield payload_ : Ljava/lang/Object;
      //   516: checkcast com/google/internal/firebase/inappmessaging/v1/CampaignProto$VanillaCampaignPayload
      //   519: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   522: pop
      //   523: aload_0
      //   524: aload_1
      //   525: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   528: putfield payload_ : Ljava/lang/Object;
      //   531: aload_0
      //   532: iconst_1
      //   533: putfield payloadCase_ : I
      //   536: goto -> 136
      //   539: iconst_1
      //   540: istore #8
      //   542: goto -> 136
      //   545: astore_1
      //   546: goto -> 593
      //   549: astore_3
      //   550: new java/lang/RuntimeException
      //   553: astore_2
      //   554: new com/google/protobuf/InvalidProtocolBufferException
      //   557: astore_1
      //   558: aload_1
      //   559: aload_3
      //   560: invokevirtual getMessage : ()Ljava/lang/String;
      //   563: invokespecial <init> : (Ljava/lang/String;)V
      //   566: aload_2
      //   567: aload_1
      //   568: aload_0
      //   569: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   572: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   575: aload_2
      //   576: athrow
      //   577: astore_1
      //   578: new java/lang/RuntimeException
      //   581: astore_2
      //   582: aload_2
      //   583: aload_1
      //   584: aload_0
      //   585: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   588: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   591: aload_2
      //   592: athrow
      //   593: aload_1
      //   594: athrow
      //   595: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$ThickContent.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$ThickContent;
      //   598: areturn
      //   599: aload_2
      //   600: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   603: astore_1
      //   604: aload_3
      //   605: checkcast com/google/internal/firebase/inappmessaging/v1/CampaignProto$ThickContent
      //   608: astore_2
      //   609: aload_0
      //   610: aload_1
      //   611: aload_0
      //   612: getfield content_ : Lcom/google/firebase/inappmessaging/MessagesProto$Content;
      //   615: aload_2
      //   616: getfield content_ : Lcom/google/firebase/inappmessaging/MessagesProto$Content;
      //   619: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   624: checkcast com/google/firebase/inappmessaging/MessagesProto$Content
      //   627: putfield content_ : Lcom/google/firebase/inappmessaging/MessagesProto$Content;
      //   630: aload_0
      //   631: aload_1
      //   632: aload_0
      //   633: getfield priority_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$Priority;
      //   636: aload_2
      //   637: getfield priority_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$Priority;
      //   640: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   645: checkcast com/google/firebase/inappmessaging/CommonTypesProto$Priority
      //   648: putfield priority_ : Lcom/google/firebase/inappmessaging/CommonTypesProto$Priority;
      //   651: aload_0
      //   652: aload_1
      //   653: aload_0
      //   654: getfield triggeringConditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   657: aload_2
      //   658: getfield triggeringConditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   661: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   666: putfield triggeringConditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   669: aload_0
      //   670: getfield isTestCampaign_ : Z
      //   673: istore #9
      //   675: aload_2
      //   676: getfield isTestCampaign_ : Z
      //   679: istore #10
      //   681: aload_0
      //   682: aload_1
      //   683: iload #9
      //   685: iload #9
      //   687: iload #10
      //   689: iload #10
      //   691: invokeinterface visitBoolean : (ZZZZ)Z
      //   696: putfield isTestCampaign_ : Z
      //   699: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$1.$SwitchMap$com$google$internal$firebase$inappmessaging$v1$CampaignProto$ThickContent$PayloadCase : [I
      //   702: aload_2
      //   703: invokevirtual getPayloadCase : ()Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$ThickContent$PayloadCase;
      //   706: invokevirtual ordinal : ()I
      //   709: iaload
      //   710: tableswitch default -> 736, 1 -> 798, 2 -> 760, 3 -> 739
      //   736: goto -> 833
      //   739: aload_0
      //   740: getfield payloadCase_ : I
      //   743: ifeq -> 749
      //   746: iconst_1
      //   747: istore #5
      //   749: aload_1
      //   750: iload #5
      //   752: invokeinterface visitOneofNotSet : (Z)V
      //   757: goto -> 833
      //   760: iload #6
      //   762: istore #5
      //   764: aload_0
      //   765: getfield payloadCase_ : I
      //   768: iconst_2
      //   769: if_icmpne -> 775
      //   772: iconst_1
      //   773: istore #5
      //   775: aload_0
      //   776: aload_1
      //   777: iload #5
      //   779: aload_0
      //   780: getfield payload_ : Ljava/lang/Object;
      //   783: aload_2
      //   784: getfield payload_ : Ljava/lang/Object;
      //   787: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   792: putfield payload_ : Ljava/lang/Object;
      //   795: goto -> 833
      //   798: iload #7
      //   800: istore #5
      //   802: aload_0
      //   803: getfield payloadCase_ : I
      //   806: iconst_1
      //   807: if_icmpne -> 813
      //   810: iconst_1
      //   811: istore #5
      //   813: aload_0
      //   814: aload_1
      //   815: iload #5
      //   817: aload_0
      //   818: getfield payload_ : Ljava/lang/Object;
      //   821: aload_2
      //   822: getfield payload_ : Ljava/lang/Object;
      //   825: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   830: putfield payload_ : Ljava/lang/Object;
      //   833: aload_1
      //   834: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   837: if_acmpne -> 870
      //   840: aload_2
      //   841: getfield payloadCase_ : I
      //   844: istore #8
      //   846: iload #8
      //   848: ifeq -> 857
      //   851: aload_0
      //   852: iload #8
      //   854: putfield payloadCase_ : I
      //   857: aload_0
      //   858: aload_0
      //   859: getfield bitField0_ : I
      //   862: aload_2
      //   863: getfield bitField0_ : I
      //   866: ior
      //   867: putfield bitField0_ : I
      //   870: aload_0
      //   871: areturn
      //   872: new com/google/internal/firebase/inappmessaging/v1/CampaignProto$ThickContent$Builder
      //   875: dup
      //   876: aconst_null
      //   877: invokespecial <init> : (Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$1;)V
      //   880: areturn
      //   881: aload_0
      //   882: getfield triggeringConditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   885: invokeinterface makeImmutable : ()V
      //   890: aconst_null
      //   891: areturn
      //   892: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$ThickContent.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$ThickContent;
      //   895: areturn
      //   896: new com/google/internal/firebase/inappmessaging/v1/CampaignProto$ThickContent
      //   899: dup
      //   900: invokespecial <init> : ()V
      //   903: areturn
      // Exception table:
      //   from	to	target	type
      //   89	110	116	finally
      //   110	113	116	finally
      //   117	120	116	finally
      //   141	147	577	com/google/protobuf/InvalidProtocolBufferException
      //   141	147	549	java/io/IOException
      //   141	147	545	finally
      //   194	203	577	com/google/protobuf/InvalidProtocolBufferException
      //   194	203	549	java/io/IOException
      //   194	203	545	finally
      //   209	217	577	com/google/protobuf/InvalidProtocolBufferException
      //   209	217	549	java/io/IOException
      //   209	217	545	finally
      //   220	243	577	com/google/protobuf/InvalidProtocolBufferException
      //   220	243	549	java/io/IOException
      //   220	243	545	finally
      //   243	264	577	com/google/protobuf/InvalidProtocolBufferException
      //   243	264	549	java/io/IOException
      //   243	264	545	finally
      //   267	285	577	com/google/protobuf/InvalidProtocolBufferException
      //   267	285	549	java/io/IOException
      //   267	285	545	finally
      //   290	305	577	com/google/protobuf/InvalidProtocolBufferException
      //   290	305	549	java/io/IOException
      //   290	305	545	finally
      //   309	329	577	com/google/protobuf/InvalidProtocolBufferException
      //   309	329	549	java/io/IOException
      //   309	329	545	finally
      //   332	350	577	com/google/protobuf/InvalidProtocolBufferException
      //   332	350	549	java/io/IOException
      //   332	350	545	finally
      //   355	370	577	com/google/protobuf/InvalidProtocolBufferException
      //   355	370	549	java/io/IOException
      //   355	370	545	finally
      //   374	394	577	com/google/protobuf/InvalidProtocolBufferException
      //   374	394	549	java/io/IOException
      //   374	394	545	finally
      //   397	419	577	com/google/protobuf/InvalidProtocolBufferException
      //   397	419	549	java/io/IOException
      //   397	419	545	finally
      //   424	436	577	com/google/protobuf/InvalidProtocolBufferException
      //   424	436	549	java/io/IOException
      //   424	436	545	finally
      //   440	460	577	com/google/protobuf/InvalidProtocolBufferException
      //   440	460	549	java/io/IOException
      //   440	460	545	finally
      //   460	465	577	com/google/protobuf/InvalidProtocolBufferException
      //   460	465	549	java/io/IOException
      //   460	465	545	finally
      //   468	490	577	com/google/protobuf/InvalidProtocolBufferException
      //   468	490	549	java/io/IOException
      //   468	490	545	finally
      //   495	507	577	com/google/protobuf/InvalidProtocolBufferException
      //   495	507	549	java/io/IOException
      //   495	507	545	finally
      //   511	531	577	com/google/protobuf/InvalidProtocolBufferException
      //   511	531	549	java/io/IOException
      //   511	531	545	finally
      //   531	536	577	com/google/protobuf/InvalidProtocolBufferException
      //   531	536	549	java/io/IOException
      //   531	536	545	finally
      //   550	577	545	finally
      //   578	593	545	finally
    }
    
    public MessagesProto.Content getContent() {
      MessagesProto.Content content1 = this.content_;
      MessagesProto.Content content2 = content1;
      if (content1 == null)
        content2 = MessagesProto.Content.getDefaultInstance(); 
      return content2;
    }
    
    public CampaignProto.ExperimentalCampaignPayload getExperimentalPayload() {
      return (this.payloadCase_ == 2) ? (CampaignProto.ExperimentalCampaignPayload)this.payload_ : CampaignProto.ExperimentalCampaignPayload.getDefaultInstance();
    }
    
    public boolean getIsTestCampaign() {
      return this.isTestCampaign_;
    }
    
    public PayloadCase getPayloadCase() {
      return PayloadCase.forNumber(this.payloadCase_);
    }
    
    public CommonTypesProto.Priority getPriority() {
      CommonTypesProto.Priority priority1 = this.priority_;
      CommonTypesProto.Priority priority2 = priority1;
      if (priority1 == null)
        priority2 = CommonTypesProto.Priority.getDefaultInstance(); 
      return priority2;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = this.payloadCase_;
      byte b1 = 0;
      if (i == 1) {
        j = CodedOutputStream.computeMessageSize(1, (MessageLite)this.payload_) + 0;
      } else {
        j = 0;
      } 
      i = j;
      if (this.payloadCase_ == 2)
        i = j + CodedOutputStream.computeMessageSize(2, (MessageLite)this.payload_); 
      int j = i;
      if (this.content_ != null)
        j = i + CodedOutputStream.computeMessageSize(3, (MessageLite)getContent()); 
      i = j;
      byte b2 = b1;
      if (this.priority_ != null) {
        i = j + CodedOutputStream.computeMessageSize(4, (MessageLite)getPriority());
        b2 = b1;
      } 
      while (b2 < this.triggeringConditions_.size()) {
        i += CodedOutputStream.computeMessageSize(5, (MessageLite)this.triggeringConditions_.get(b2));
        b2++;
      } 
      boolean bool = this.isTestCampaign_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(7, bool); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public CommonTypesProto.TriggeringCondition getTriggeringConditions(int param1Int) {
      return (CommonTypesProto.TriggeringCondition)this.triggeringConditions_.get(param1Int);
    }
    
    public int getTriggeringConditionsCount() {
      return this.triggeringConditions_.size();
    }
    
    public List<CommonTypesProto.TriggeringCondition> getTriggeringConditionsList() {
      return (List<CommonTypesProto.TriggeringCondition>)this.triggeringConditions_;
    }
    
    public CommonTypesProto.TriggeringConditionOrBuilder getTriggeringConditionsOrBuilder(int param1Int) {
      return (CommonTypesProto.TriggeringConditionOrBuilder)this.triggeringConditions_.get(param1Int);
    }
    
    public List<? extends CommonTypesProto.TriggeringConditionOrBuilder> getTriggeringConditionsOrBuilderList() {
      return (List)this.triggeringConditions_;
    }
    
    public CampaignProto.VanillaCampaignPayload getVanillaPayload() {
      return (this.payloadCase_ == 1) ? (CampaignProto.VanillaCampaignPayload)this.payload_ : CampaignProto.VanillaCampaignPayload.getDefaultInstance();
    }
    
    public boolean hasContent() {
      boolean bool;
      if (this.content_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasPriority() {
      boolean bool;
      if (this.priority_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.payloadCase_ == 1)
        param1CodedOutputStream.writeMessage(1, (MessageLite)this.payload_); 
      if (this.payloadCase_ == 2)
        param1CodedOutputStream.writeMessage(2, (MessageLite)this.payload_); 
      if (this.content_ != null)
        param1CodedOutputStream.writeMessage(3, (MessageLite)getContent()); 
      if (this.priority_ != null)
        param1CodedOutputStream.writeMessage(4, (MessageLite)getPriority()); 
      for (byte b = 0; b < this.triggeringConditions_.size(); b++)
        param1CodedOutputStream.writeMessage(5, (MessageLite)this.triggeringConditions_.get(b)); 
      boolean bool = this.isTestCampaign_;
      if (bool)
        param1CodedOutputStream.writeBool(7, bool); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<ThickContent, Builder> implements CampaignProto.ThickContentOrBuilder {
      private Builder() {
        super(CampaignProto.ThickContent.DEFAULT_INSTANCE);
      }
      
      public Builder addAllTriggeringConditions(Iterable<? extends CommonTypesProto.TriggeringCondition> param2Iterable) {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).addAllTriggeringConditions(param2Iterable);
        return this;
      }
      
      public Builder addTriggeringConditions(int param2Int, CommonTypesProto.TriggeringCondition.Builder param2Builder) {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).addTriggeringConditions(param2Int, param2Builder);
        return this;
      }
      
      public Builder addTriggeringConditions(int param2Int, CommonTypesProto.TriggeringCondition param2TriggeringCondition) {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).addTriggeringConditions(param2Int, param2TriggeringCondition);
        return this;
      }
      
      public Builder addTriggeringConditions(CommonTypesProto.TriggeringCondition.Builder param2Builder) {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).addTriggeringConditions(param2Builder);
        return this;
      }
      
      public Builder addTriggeringConditions(CommonTypesProto.TriggeringCondition param2TriggeringCondition) {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).addTriggeringConditions(param2TriggeringCondition);
        return this;
      }
      
      public Builder clearContent() {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).clearContent();
        return this;
      }
      
      public Builder clearExperimentalPayload() {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).clearExperimentalPayload();
        return this;
      }
      
      public Builder clearIsTestCampaign() {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).clearIsTestCampaign();
        return this;
      }
      
      public Builder clearPayload() {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).clearPayload();
        return this;
      }
      
      public Builder clearPriority() {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).clearPriority();
        return this;
      }
      
      public Builder clearTriggeringConditions() {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).clearTriggeringConditions();
        return this;
      }
      
      public Builder clearVanillaPayload() {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).clearVanillaPayload();
        return this;
      }
      
      public MessagesProto.Content getContent() {
        return ((CampaignProto.ThickContent)this.instance).getContent();
      }
      
      public CampaignProto.ExperimentalCampaignPayload getExperimentalPayload() {
        return ((CampaignProto.ThickContent)this.instance).getExperimentalPayload();
      }
      
      public boolean getIsTestCampaign() {
        return ((CampaignProto.ThickContent)this.instance).getIsTestCampaign();
      }
      
      public CampaignProto.ThickContent.PayloadCase getPayloadCase() {
        return ((CampaignProto.ThickContent)this.instance).getPayloadCase();
      }
      
      public CommonTypesProto.Priority getPriority() {
        return ((CampaignProto.ThickContent)this.instance).getPriority();
      }
      
      public CommonTypesProto.TriggeringCondition getTriggeringConditions(int param2Int) {
        return ((CampaignProto.ThickContent)this.instance).getTriggeringConditions(param2Int);
      }
      
      public int getTriggeringConditionsCount() {
        return ((CampaignProto.ThickContent)this.instance).getTriggeringConditionsCount();
      }
      
      public List<CommonTypesProto.TriggeringCondition> getTriggeringConditionsList() {
        return Collections.unmodifiableList(((CampaignProto.ThickContent)this.instance).getTriggeringConditionsList());
      }
      
      public CampaignProto.VanillaCampaignPayload getVanillaPayload() {
        return ((CampaignProto.ThickContent)this.instance).getVanillaPayload();
      }
      
      public boolean hasContent() {
        return ((CampaignProto.ThickContent)this.instance).hasContent();
      }
      
      public boolean hasPriority() {
        return ((CampaignProto.ThickContent)this.instance).hasPriority();
      }
      
      public Builder mergeContent(MessagesProto.Content param2Content) {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).mergeContent(param2Content);
        return this;
      }
      
      public Builder mergeExperimentalPayload(CampaignProto.ExperimentalCampaignPayload param2ExperimentalCampaignPayload) {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).mergeExperimentalPayload(param2ExperimentalCampaignPayload);
        return this;
      }
      
      public Builder mergePriority(CommonTypesProto.Priority param2Priority) {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).mergePriority(param2Priority);
        return this;
      }
      
      public Builder mergeVanillaPayload(CampaignProto.VanillaCampaignPayload param2VanillaCampaignPayload) {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).mergeVanillaPayload(param2VanillaCampaignPayload);
        return this;
      }
      
      public Builder removeTriggeringConditions(int param2Int) {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).removeTriggeringConditions(param2Int);
        return this;
      }
      
      public Builder setContent(MessagesProto.Content.Builder param2Builder) {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).setContent(param2Builder);
        return this;
      }
      
      public Builder setContent(MessagesProto.Content param2Content) {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).setContent(param2Content);
        return this;
      }
      
      public Builder setExperimentalPayload(CampaignProto.ExperimentalCampaignPayload.Builder param2Builder) {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).setExperimentalPayload(param2Builder);
        return this;
      }
      
      public Builder setExperimentalPayload(CampaignProto.ExperimentalCampaignPayload param2ExperimentalCampaignPayload) {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).setExperimentalPayload(param2ExperimentalCampaignPayload);
        return this;
      }
      
      public Builder setIsTestCampaign(boolean param2Boolean) {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).setIsTestCampaign(param2Boolean);
        return this;
      }
      
      public Builder setPriority(CommonTypesProto.Priority.Builder param2Builder) {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).setPriority(param2Builder);
        return this;
      }
      
      public Builder setPriority(CommonTypesProto.Priority param2Priority) {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).setPriority(param2Priority);
        return this;
      }
      
      public Builder setTriggeringConditions(int param2Int, CommonTypesProto.TriggeringCondition.Builder param2Builder) {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).setTriggeringConditions(param2Int, param2Builder);
        return this;
      }
      
      public Builder setTriggeringConditions(int param2Int, CommonTypesProto.TriggeringCondition param2TriggeringCondition) {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).setTriggeringConditions(param2Int, param2TriggeringCondition);
        return this;
      }
      
      public Builder setVanillaPayload(CampaignProto.VanillaCampaignPayload.Builder param2Builder) {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).setVanillaPayload(param2Builder);
        return this;
      }
      
      public Builder setVanillaPayload(CampaignProto.VanillaCampaignPayload param2VanillaCampaignPayload) {
        copyOnWrite();
        ((CampaignProto.ThickContent)this.instance).setVanillaPayload(param2VanillaCampaignPayload);
        return this;
      }
    }
    
    public enum PayloadCase implements Internal.EnumLite {
      EXPERIMENTAL_PAYLOAD,
      PAYLOAD_NOT_SET,
      VANILLA_PAYLOAD(1);
      
      private final int value;
      
      static {
      
      }
      
      PayloadCase(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static PayloadCase forNumber(int param2Int) {
        switch (param2Int) {
          default:
            return null;
          case 2:
            return EXPERIMENTAL_PAYLOAD;
          case 1:
            return VANILLA_PAYLOAD;
          case 0:
            break;
        } 
        return PAYLOAD_NOT_SET;
      }
      
      public int getNumber() {
        return this.value;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ThickContent, ThickContent.Builder> implements ThickContentOrBuilder {
    private Builder() {
      super(CampaignProto.ThickContent.DEFAULT_INSTANCE);
    }
    
    public Builder addAllTriggeringConditions(Iterable<? extends CommonTypesProto.TriggeringCondition> param1Iterable) {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).addAllTriggeringConditions(param1Iterable);
      return this;
    }
    
    public Builder addTriggeringConditions(int param1Int, CommonTypesProto.TriggeringCondition.Builder param1Builder) {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).addTriggeringConditions(param1Int, param1Builder);
      return this;
    }
    
    public Builder addTriggeringConditions(int param1Int, CommonTypesProto.TriggeringCondition param1TriggeringCondition) {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).addTriggeringConditions(param1Int, param1TriggeringCondition);
      return this;
    }
    
    public Builder addTriggeringConditions(CommonTypesProto.TriggeringCondition.Builder param1Builder) {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).addTriggeringConditions(param1Builder);
      return this;
    }
    
    public Builder addTriggeringConditions(CommonTypesProto.TriggeringCondition param1TriggeringCondition) {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).addTriggeringConditions(param1TriggeringCondition);
      return this;
    }
    
    public Builder clearContent() {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).clearContent();
      return this;
    }
    
    public Builder clearExperimentalPayload() {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).clearExperimentalPayload();
      return this;
    }
    
    public Builder clearIsTestCampaign() {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).clearIsTestCampaign();
      return this;
    }
    
    public Builder clearPayload() {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).clearPayload();
      return this;
    }
    
    public Builder clearPriority() {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).clearPriority();
      return this;
    }
    
    public Builder clearTriggeringConditions() {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).clearTriggeringConditions();
      return this;
    }
    
    public Builder clearVanillaPayload() {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).clearVanillaPayload();
      return this;
    }
    
    public MessagesProto.Content getContent() {
      return ((CampaignProto.ThickContent)this.instance).getContent();
    }
    
    public CampaignProto.ExperimentalCampaignPayload getExperimentalPayload() {
      return ((CampaignProto.ThickContent)this.instance).getExperimentalPayload();
    }
    
    public boolean getIsTestCampaign() {
      return ((CampaignProto.ThickContent)this.instance).getIsTestCampaign();
    }
    
    public CampaignProto.ThickContent.PayloadCase getPayloadCase() {
      return ((CampaignProto.ThickContent)this.instance).getPayloadCase();
    }
    
    public CommonTypesProto.Priority getPriority() {
      return ((CampaignProto.ThickContent)this.instance).getPriority();
    }
    
    public CommonTypesProto.TriggeringCondition getTriggeringConditions(int param1Int) {
      return ((CampaignProto.ThickContent)this.instance).getTriggeringConditions(param1Int);
    }
    
    public int getTriggeringConditionsCount() {
      return ((CampaignProto.ThickContent)this.instance).getTriggeringConditionsCount();
    }
    
    public List<CommonTypesProto.TriggeringCondition> getTriggeringConditionsList() {
      return Collections.unmodifiableList(((CampaignProto.ThickContent)this.instance).getTriggeringConditionsList());
    }
    
    public CampaignProto.VanillaCampaignPayload getVanillaPayload() {
      return ((CampaignProto.ThickContent)this.instance).getVanillaPayload();
    }
    
    public boolean hasContent() {
      return ((CampaignProto.ThickContent)this.instance).hasContent();
    }
    
    public boolean hasPriority() {
      return ((CampaignProto.ThickContent)this.instance).hasPriority();
    }
    
    public Builder mergeContent(MessagesProto.Content param1Content) {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).mergeContent(param1Content);
      return this;
    }
    
    public Builder mergeExperimentalPayload(CampaignProto.ExperimentalCampaignPayload param1ExperimentalCampaignPayload) {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).mergeExperimentalPayload(param1ExperimentalCampaignPayload);
      return this;
    }
    
    public Builder mergePriority(CommonTypesProto.Priority param1Priority) {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).mergePriority(param1Priority);
      return this;
    }
    
    public Builder mergeVanillaPayload(CampaignProto.VanillaCampaignPayload param1VanillaCampaignPayload) {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).mergeVanillaPayload(param1VanillaCampaignPayload);
      return this;
    }
    
    public Builder removeTriggeringConditions(int param1Int) {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).removeTriggeringConditions(param1Int);
      return this;
    }
    
    public Builder setContent(MessagesProto.Content.Builder param1Builder) {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).setContent(param1Builder);
      return this;
    }
    
    public Builder setContent(MessagesProto.Content param1Content) {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).setContent(param1Content);
      return this;
    }
    
    public Builder setExperimentalPayload(CampaignProto.ExperimentalCampaignPayload.Builder param1Builder) {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).setExperimentalPayload(param1Builder);
      return this;
    }
    
    public Builder setExperimentalPayload(CampaignProto.ExperimentalCampaignPayload param1ExperimentalCampaignPayload) {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).setExperimentalPayload(param1ExperimentalCampaignPayload);
      return this;
    }
    
    public Builder setIsTestCampaign(boolean param1Boolean) {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).setIsTestCampaign(param1Boolean);
      return this;
    }
    
    public Builder setPriority(CommonTypesProto.Priority.Builder param1Builder) {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).setPriority(param1Builder);
      return this;
    }
    
    public Builder setPriority(CommonTypesProto.Priority param1Priority) {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).setPriority(param1Priority);
      return this;
    }
    
    public Builder setTriggeringConditions(int param1Int, CommonTypesProto.TriggeringCondition.Builder param1Builder) {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).setTriggeringConditions(param1Int, param1Builder);
      return this;
    }
    
    public Builder setTriggeringConditions(int param1Int, CommonTypesProto.TriggeringCondition param1TriggeringCondition) {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).setTriggeringConditions(param1Int, param1TriggeringCondition);
      return this;
    }
    
    public Builder setVanillaPayload(CampaignProto.VanillaCampaignPayload.Builder param1Builder) {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).setVanillaPayload(param1Builder);
      return this;
    }
    
    public Builder setVanillaPayload(CampaignProto.VanillaCampaignPayload param1VanillaCampaignPayload) {
      copyOnWrite();
      ((CampaignProto.ThickContent)this.instance).setVanillaPayload(param1VanillaCampaignPayload);
      return this;
    }
  }
  
  public enum PayloadCase implements Internal.EnumLite {
    EXPERIMENTAL_PAYLOAD(1),
    PAYLOAD_NOT_SET(1),
    VANILLA_PAYLOAD(1);
    
    private final int value;
    
    static {
      $VALUES = new PayloadCase[] { VANILLA_PAYLOAD, EXPERIMENTAL_PAYLOAD, PAYLOAD_NOT_SET };
    }
    
    PayloadCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static PayloadCase forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 2:
          return EXPERIMENTAL_PAYLOAD;
        case 1:
          return VANILLA_PAYLOAD;
        case 0:
          break;
      } 
      return PAYLOAD_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
  
  public static interface ThickContentOrBuilder extends MessageLiteOrBuilder {
    MessagesProto.Content getContent();
    
    CampaignProto.ExperimentalCampaignPayload getExperimentalPayload();
    
    boolean getIsTestCampaign();
    
    CampaignProto.ThickContent.PayloadCase getPayloadCase();
    
    CommonTypesProto.Priority getPriority();
    
    CommonTypesProto.TriggeringCondition getTriggeringConditions(int param1Int);
    
    int getTriggeringConditionsCount();
    
    List<CommonTypesProto.TriggeringCondition> getTriggeringConditionsList();
    
    CampaignProto.VanillaCampaignPayload getVanillaPayload();
    
    boolean hasContent();
    
    boolean hasPriority();
  }
  
  public static final class VanillaCampaignPayload extends GeneratedMessageLite<VanillaCampaignPayload, VanillaCampaignPayload.Builder> implements VanillaCampaignPayloadOrBuilder {
    public static final int CAMPAIGN_END_TIME_MILLIS_FIELD_NUMBER = 4;
    
    public static final int CAMPAIGN_ID_FIELD_NUMBER = 1;
    
    public static final int CAMPAIGN_NAME_FIELD_NUMBER = 5;
    
    public static final int CAMPAIGN_START_TIME_MILLIS_FIELD_NUMBER = 3;
    
    private static final VanillaCampaignPayload DEFAULT_INSTANCE = new VanillaCampaignPayload();
    
    public static final int EXPERIMENTAL_CAMPAIGN_ID_FIELD_NUMBER = 2;
    
    private static volatile Parser<VanillaCampaignPayload> PARSER;
    
    private long campaignEndTimeMillis_;
    
    private String campaignId_ = "";
    
    private String campaignName_ = "";
    
    private long campaignStartTimeMillis_;
    
    private String experimentalCampaignId_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearCampaignEndTimeMillis() {
      this.campaignEndTimeMillis_ = 0L;
    }
    
    private void clearCampaignId() {
      this.campaignId_ = getDefaultInstance().getCampaignId();
    }
    
    private void clearCampaignName() {
      this.campaignName_ = getDefaultInstance().getCampaignName();
    }
    
    private void clearCampaignStartTimeMillis() {
      this.campaignStartTimeMillis_ = 0L;
    }
    
    private void clearExperimentalCampaignId() {
      this.experimentalCampaignId_ = getDefaultInstance().getExperimentalCampaignId();
    }
    
    public static VanillaCampaignPayload getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(VanillaCampaignPayload param1VanillaCampaignPayload) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1VanillaCampaignPayload);
    }
    
    public static VanillaCampaignPayload parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (VanillaCampaignPayload)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static VanillaCampaignPayload parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (VanillaCampaignPayload)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static VanillaCampaignPayload parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (VanillaCampaignPayload)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static VanillaCampaignPayload parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (VanillaCampaignPayload)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static VanillaCampaignPayload parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (VanillaCampaignPayload)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static VanillaCampaignPayload parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (VanillaCampaignPayload)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static VanillaCampaignPayload parseFrom(InputStream param1InputStream) throws IOException {
      return (VanillaCampaignPayload)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static VanillaCampaignPayload parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (VanillaCampaignPayload)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static VanillaCampaignPayload parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (VanillaCampaignPayload)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static VanillaCampaignPayload parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (VanillaCampaignPayload)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<VanillaCampaignPayload> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setCampaignEndTimeMillis(long param1Long) {
      this.campaignEndTimeMillis_ = param1Long;
    }
    
    private void setCampaignId(String param1String) {
      if (param1String != null) {
        this.campaignId_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setCampaignIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.campaignId_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setCampaignName(String param1String) {
      if (param1String != null) {
        this.campaignName_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setCampaignNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.campaignName_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setCampaignStartTimeMillis(long param1Long) {
      this.campaignStartTimeMillis_ = param1Long;
    }
    
    private void setExperimentalCampaignId(String param1String) {
      if (param1String != null) {
        this.experimentalCampaignId_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setExperimentalCampaignIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.experimentalCampaignId_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: istore #4
      //   10: iconst_0
      //   11: istore #5
      //   13: iload #4
      //   15: tableswitch default -> 60, 1 -> 568, 2 -> 564, 3 -> 562, 4 -> 553, 5 -> 305, 6 -> 114, 7 -> 301, 8 -> 68
      //   60: new java/lang/UnsupportedOperationException
      //   63: dup
      //   64: invokespecial <init> : ()V
      //   67: athrow
      //   68: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$VanillaCampaignPayload.PARSER : Lcom/google/protobuf/Parser;
      //   71: ifnonnull -> 110
      //   74: ldc com/google/internal/firebase/inappmessaging/v1/CampaignProto$VanillaCampaignPayload
      //   76: monitorenter
      //   77: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$VanillaCampaignPayload.PARSER : Lcom/google/protobuf/Parser;
      //   80: ifnonnull -> 98
      //   83: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   86: astore_1
      //   87: aload_1
      //   88: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$VanillaCampaignPayload.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$VanillaCampaignPayload;
      //   91: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   94: aload_1
      //   95: putstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$VanillaCampaignPayload.PARSER : Lcom/google/protobuf/Parser;
      //   98: ldc com/google/internal/firebase/inappmessaging/v1/CampaignProto$VanillaCampaignPayload
      //   100: monitorexit
      //   101: goto -> 110
      //   104: astore_1
      //   105: ldc com/google/internal/firebase/inappmessaging/v1/CampaignProto$VanillaCampaignPayload
      //   107: monitorexit
      //   108: aload_1
      //   109: athrow
      //   110: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$VanillaCampaignPayload.PARSER : Lcom/google/protobuf/Parser;
      //   113: areturn
      //   114: aload_2
      //   115: checkcast com/google/protobuf/CodedInputStream
      //   118: astore_1
      //   119: aload_3
      //   120: checkcast com/google/protobuf/ExtensionRegistryLite
      //   123: astore_2
      //   124: iload #5
      //   126: ifne -> 301
      //   129: aload_1
      //   130: invokevirtual readTag : ()I
      //   133: istore #4
      //   135: iload #4
      //   137: ifeq -> 245
      //   140: iload #4
      //   142: bipush #10
      //   144: if_icmpeq -> 234
      //   147: iload #4
      //   149: bipush #18
      //   151: if_icmpeq -> 223
      //   154: iload #4
      //   156: bipush #24
      //   158: if_icmpeq -> 212
      //   161: iload #4
      //   163: bipush #32
      //   165: if_icmpeq -> 201
      //   168: iload #4
      //   170: bipush #42
      //   172: if_icmpeq -> 190
      //   175: aload_1
      //   176: iload #4
      //   178: invokevirtual skipField : (I)Z
      //   181: ifne -> 124
      //   184: iconst_1
      //   185: istore #5
      //   187: goto -> 124
      //   190: aload_0
      //   191: aload_1
      //   192: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   195: putfield campaignName_ : Ljava/lang/String;
      //   198: goto -> 124
      //   201: aload_0
      //   202: aload_1
      //   203: invokevirtual readInt64 : ()J
      //   206: putfield campaignEndTimeMillis_ : J
      //   209: goto -> 124
      //   212: aload_0
      //   213: aload_1
      //   214: invokevirtual readInt64 : ()J
      //   217: putfield campaignStartTimeMillis_ : J
      //   220: goto -> 124
      //   223: aload_0
      //   224: aload_1
      //   225: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   228: putfield experimentalCampaignId_ : Ljava/lang/String;
      //   231: goto -> 124
      //   234: aload_0
      //   235: aload_1
      //   236: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   239: putfield campaignId_ : Ljava/lang/String;
      //   242: goto -> 124
      //   245: iconst_1
      //   246: istore #5
      //   248: goto -> 124
      //   251: astore_1
      //   252: goto -> 299
      //   255: astore_1
      //   256: new java/lang/RuntimeException
      //   259: astore_2
      //   260: new com/google/protobuf/InvalidProtocolBufferException
      //   263: astore_3
      //   264: aload_3
      //   265: aload_1
      //   266: invokevirtual getMessage : ()Ljava/lang/String;
      //   269: invokespecial <init> : (Ljava/lang/String;)V
      //   272: aload_2
      //   273: aload_3
      //   274: aload_0
      //   275: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   278: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   281: aload_2
      //   282: athrow
      //   283: astore_1
      //   284: new java/lang/RuntimeException
      //   287: astore_2
      //   288: aload_2
      //   289: aload_1
      //   290: aload_0
      //   291: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   294: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   297: aload_2
      //   298: athrow
      //   299: aload_1
      //   300: athrow
      //   301: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$VanillaCampaignPayload.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$VanillaCampaignPayload;
      //   304: areturn
      //   305: aload_2
      //   306: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   309: astore_1
      //   310: aload_3
      //   311: checkcast com/google/internal/firebase/inappmessaging/v1/CampaignProto$VanillaCampaignPayload
      //   314: astore_2
      //   315: aload_0
      //   316: aload_1
      //   317: aload_0
      //   318: getfield campaignId_ : Ljava/lang/String;
      //   321: invokevirtual isEmpty : ()Z
      //   324: iconst_1
      //   325: ixor
      //   326: aload_0
      //   327: getfield campaignId_ : Ljava/lang/String;
      //   330: aload_2
      //   331: getfield campaignId_ : Ljava/lang/String;
      //   334: invokevirtual isEmpty : ()Z
      //   337: iconst_1
      //   338: ixor
      //   339: aload_2
      //   340: getfield campaignId_ : Ljava/lang/String;
      //   343: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   348: putfield campaignId_ : Ljava/lang/String;
      //   351: aload_0
      //   352: aload_1
      //   353: aload_0
      //   354: getfield experimentalCampaignId_ : Ljava/lang/String;
      //   357: invokevirtual isEmpty : ()Z
      //   360: iconst_1
      //   361: ixor
      //   362: aload_0
      //   363: getfield experimentalCampaignId_ : Ljava/lang/String;
      //   366: aload_2
      //   367: getfield experimentalCampaignId_ : Ljava/lang/String;
      //   370: invokevirtual isEmpty : ()Z
      //   373: iconst_1
      //   374: ixor
      //   375: aload_2
      //   376: getfield experimentalCampaignId_ : Ljava/lang/String;
      //   379: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   384: putfield experimentalCampaignId_ : Ljava/lang/String;
      //   387: aload_0
      //   388: getfield campaignStartTimeMillis_ : J
      //   391: lconst_0
      //   392: lcmp
      //   393: ifeq -> 402
      //   396: iconst_1
      //   397: istore #6
      //   399: goto -> 405
      //   402: iconst_0
      //   403: istore #6
      //   405: aload_0
      //   406: getfield campaignStartTimeMillis_ : J
      //   409: lstore #7
      //   411: aload_2
      //   412: getfield campaignStartTimeMillis_ : J
      //   415: lconst_0
      //   416: lcmp
      //   417: ifeq -> 426
      //   420: iconst_1
      //   421: istore #9
      //   423: goto -> 429
      //   426: iconst_0
      //   427: istore #9
      //   429: aload_0
      //   430: aload_1
      //   431: iload #6
      //   433: lload #7
      //   435: iload #9
      //   437: aload_2
      //   438: getfield campaignStartTimeMillis_ : J
      //   441: invokeinterface visitLong : (ZJZJ)J
      //   446: putfield campaignStartTimeMillis_ : J
      //   449: aload_0
      //   450: getfield campaignEndTimeMillis_ : J
      //   453: lconst_0
      //   454: lcmp
      //   455: ifeq -> 464
      //   458: iconst_1
      //   459: istore #6
      //   461: goto -> 467
      //   464: iconst_0
      //   465: istore #6
      //   467: aload_0
      //   468: getfield campaignEndTimeMillis_ : J
      //   471: lstore #7
      //   473: aload_2
      //   474: getfield campaignEndTimeMillis_ : J
      //   477: lconst_0
      //   478: lcmp
      //   479: ifeq -> 488
      //   482: iconst_1
      //   483: istore #9
      //   485: goto -> 491
      //   488: iconst_0
      //   489: istore #9
      //   491: aload_0
      //   492: aload_1
      //   493: iload #6
      //   495: lload #7
      //   497: iload #9
      //   499: aload_2
      //   500: getfield campaignEndTimeMillis_ : J
      //   503: invokeinterface visitLong : (ZJZJ)J
      //   508: putfield campaignEndTimeMillis_ : J
      //   511: aload_0
      //   512: aload_1
      //   513: aload_0
      //   514: getfield campaignName_ : Ljava/lang/String;
      //   517: invokevirtual isEmpty : ()Z
      //   520: iconst_1
      //   521: ixor
      //   522: aload_0
      //   523: getfield campaignName_ : Ljava/lang/String;
      //   526: aload_2
      //   527: getfield campaignName_ : Ljava/lang/String;
      //   530: invokevirtual isEmpty : ()Z
      //   533: iconst_1
      //   534: ixor
      //   535: aload_2
      //   536: getfield campaignName_ : Ljava/lang/String;
      //   539: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   544: putfield campaignName_ : Ljava/lang/String;
      //   547: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   550: astore_1
      //   551: aload_0
      //   552: areturn
      //   553: new com/google/internal/firebase/inappmessaging/v1/CampaignProto$VanillaCampaignPayload$Builder
      //   556: dup
      //   557: aconst_null
      //   558: invokespecial <init> : (Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$1;)V
      //   561: areturn
      //   562: aconst_null
      //   563: areturn
      //   564: getstatic com/google/internal/firebase/inappmessaging/v1/CampaignProto$VanillaCampaignPayload.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$VanillaCampaignPayload;
      //   567: areturn
      //   568: new com/google/internal/firebase/inappmessaging/v1/CampaignProto$VanillaCampaignPayload
      //   571: dup
      //   572: invokespecial <init> : ()V
      //   575: areturn
      // Exception table:
      //   from	to	target	type
      //   77	98	104	finally
      //   98	101	104	finally
      //   105	108	104	finally
      //   129	135	283	com/google/protobuf/InvalidProtocolBufferException
      //   129	135	255	java/io/IOException
      //   129	135	251	finally
      //   175	184	283	com/google/protobuf/InvalidProtocolBufferException
      //   175	184	255	java/io/IOException
      //   175	184	251	finally
      //   190	198	283	com/google/protobuf/InvalidProtocolBufferException
      //   190	198	255	java/io/IOException
      //   190	198	251	finally
      //   201	209	283	com/google/protobuf/InvalidProtocolBufferException
      //   201	209	255	java/io/IOException
      //   201	209	251	finally
      //   212	220	283	com/google/protobuf/InvalidProtocolBufferException
      //   212	220	255	java/io/IOException
      //   212	220	251	finally
      //   223	231	283	com/google/protobuf/InvalidProtocolBufferException
      //   223	231	255	java/io/IOException
      //   223	231	251	finally
      //   234	242	283	com/google/protobuf/InvalidProtocolBufferException
      //   234	242	255	java/io/IOException
      //   234	242	251	finally
      //   256	283	251	finally
      //   284	299	251	finally
    }
    
    public long getCampaignEndTimeMillis() {
      return this.campaignEndTimeMillis_;
    }
    
    public String getCampaignId() {
      return this.campaignId_;
    }
    
    public ByteString getCampaignIdBytes() {
      return ByteString.copyFromUtf8(this.campaignId_);
    }
    
    public String getCampaignName() {
      return this.campaignName_;
    }
    
    public ByteString getCampaignNameBytes() {
      return ByteString.copyFromUtf8(this.campaignName_);
    }
    
    public long getCampaignStartTimeMillis() {
      return this.campaignStartTimeMillis_;
    }
    
    public String getExperimentalCampaignId() {
      return this.experimentalCampaignId_;
    }
    
    public ByteString getExperimentalCampaignIdBytes() {
      return ByteString.copyFromUtf8(this.experimentalCampaignId_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (!this.campaignId_.isEmpty())
        j = 0 + CodedOutputStream.computeStringSize(1, getCampaignId()); 
      i = j;
      if (!this.experimentalCampaignId_.isEmpty())
        i = j + CodedOutputStream.computeStringSize(2, getExperimentalCampaignId()); 
      long l = this.campaignStartTimeMillis_;
      j = i;
      if (l != 0L)
        j = i + CodedOutputStream.computeInt64Size(3, l); 
      l = this.campaignEndTimeMillis_;
      i = j;
      if (l != 0L)
        i = j + CodedOutputStream.computeInt64Size(4, l); 
      j = i;
      if (!this.campaignName_.isEmpty())
        j = i + CodedOutputStream.computeStringSize(5, getCampaignName()); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.campaignId_.isEmpty())
        param1CodedOutputStream.writeString(1, getCampaignId()); 
      if (!this.experimentalCampaignId_.isEmpty())
        param1CodedOutputStream.writeString(2, getExperimentalCampaignId()); 
      long l = this.campaignStartTimeMillis_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(3, l); 
      l = this.campaignEndTimeMillis_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(4, l); 
      if (!this.campaignName_.isEmpty())
        param1CodedOutputStream.writeString(5, getCampaignName()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<VanillaCampaignPayload, Builder> implements CampaignProto.VanillaCampaignPayloadOrBuilder {
      private Builder() {
        super(CampaignProto.VanillaCampaignPayload.DEFAULT_INSTANCE);
      }
      
      public Builder clearCampaignEndTimeMillis() {
        copyOnWrite();
        ((CampaignProto.VanillaCampaignPayload)this.instance).clearCampaignEndTimeMillis();
        return this;
      }
      
      public Builder clearCampaignId() {
        copyOnWrite();
        ((CampaignProto.VanillaCampaignPayload)this.instance).clearCampaignId();
        return this;
      }
      
      public Builder clearCampaignName() {
        copyOnWrite();
        ((CampaignProto.VanillaCampaignPayload)this.instance).clearCampaignName();
        return this;
      }
      
      public Builder clearCampaignStartTimeMillis() {
        copyOnWrite();
        ((CampaignProto.VanillaCampaignPayload)this.instance).clearCampaignStartTimeMillis();
        return this;
      }
      
      public Builder clearExperimentalCampaignId() {
        copyOnWrite();
        ((CampaignProto.VanillaCampaignPayload)this.instance).clearExperimentalCampaignId();
        return this;
      }
      
      public long getCampaignEndTimeMillis() {
        return ((CampaignProto.VanillaCampaignPayload)this.instance).getCampaignEndTimeMillis();
      }
      
      public String getCampaignId() {
        return ((CampaignProto.VanillaCampaignPayload)this.instance).getCampaignId();
      }
      
      public ByteString getCampaignIdBytes() {
        return ((CampaignProto.VanillaCampaignPayload)this.instance).getCampaignIdBytes();
      }
      
      public String getCampaignName() {
        return ((CampaignProto.VanillaCampaignPayload)this.instance).getCampaignName();
      }
      
      public ByteString getCampaignNameBytes() {
        return ((CampaignProto.VanillaCampaignPayload)this.instance).getCampaignNameBytes();
      }
      
      public long getCampaignStartTimeMillis() {
        return ((CampaignProto.VanillaCampaignPayload)this.instance).getCampaignStartTimeMillis();
      }
      
      public String getExperimentalCampaignId() {
        return ((CampaignProto.VanillaCampaignPayload)this.instance).getExperimentalCampaignId();
      }
      
      public ByteString getExperimentalCampaignIdBytes() {
        return ((CampaignProto.VanillaCampaignPayload)this.instance).getExperimentalCampaignIdBytes();
      }
      
      public Builder setCampaignEndTimeMillis(long param2Long) {
        copyOnWrite();
        ((CampaignProto.VanillaCampaignPayload)this.instance).setCampaignEndTimeMillis(param2Long);
        return this;
      }
      
      public Builder setCampaignId(String param2String) {
        copyOnWrite();
        ((CampaignProto.VanillaCampaignPayload)this.instance).setCampaignId(param2String);
        return this;
      }
      
      public Builder setCampaignIdBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((CampaignProto.VanillaCampaignPayload)this.instance).setCampaignIdBytes(param2ByteString);
        return this;
      }
      
      public Builder setCampaignName(String param2String) {
        copyOnWrite();
        ((CampaignProto.VanillaCampaignPayload)this.instance).setCampaignName(param2String);
        return this;
      }
      
      public Builder setCampaignNameBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((CampaignProto.VanillaCampaignPayload)this.instance).setCampaignNameBytes(param2ByteString);
        return this;
      }
      
      public Builder setCampaignStartTimeMillis(long param2Long) {
        copyOnWrite();
        ((CampaignProto.VanillaCampaignPayload)this.instance).setCampaignStartTimeMillis(param2Long);
        return this;
      }
      
      public Builder setExperimentalCampaignId(String param2String) {
        copyOnWrite();
        ((CampaignProto.VanillaCampaignPayload)this.instance).setExperimentalCampaignId(param2String);
        return this;
      }
      
      public Builder setExperimentalCampaignIdBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((CampaignProto.VanillaCampaignPayload)this.instance).setExperimentalCampaignIdBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<VanillaCampaignPayload, VanillaCampaignPayload.Builder> implements VanillaCampaignPayloadOrBuilder {
    private Builder() {
      super(CampaignProto.VanillaCampaignPayload.DEFAULT_INSTANCE);
    }
    
    public Builder clearCampaignEndTimeMillis() {
      copyOnWrite();
      ((CampaignProto.VanillaCampaignPayload)this.instance).clearCampaignEndTimeMillis();
      return this;
    }
    
    public Builder clearCampaignId() {
      copyOnWrite();
      ((CampaignProto.VanillaCampaignPayload)this.instance).clearCampaignId();
      return this;
    }
    
    public Builder clearCampaignName() {
      copyOnWrite();
      ((CampaignProto.VanillaCampaignPayload)this.instance).clearCampaignName();
      return this;
    }
    
    public Builder clearCampaignStartTimeMillis() {
      copyOnWrite();
      ((CampaignProto.VanillaCampaignPayload)this.instance).clearCampaignStartTimeMillis();
      return this;
    }
    
    public Builder clearExperimentalCampaignId() {
      copyOnWrite();
      ((CampaignProto.VanillaCampaignPayload)this.instance).clearExperimentalCampaignId();
      return this;
    }
    
    public long getCampaignEndTimeMillis() {
      return ((CampaignProto.VanillaCampaignPayload)this.instance).getCampaignEndTimeMillis();
    }
    
    public String getCampaignId() {
      return ((CampaignProto.VanillaCampaignPayload)this.instance).getCampaignId();
    }
    
    public ByteString getCampaignIdBytes() {
      return ((CampaignProto.VanillaCampaignPayload)this.instance).getCampaignIdBytes();
    }
    
    public String getCampaignName() {
      return ((CampaignProto.VanillaCampaignPayload)this.instance).getCampaignName();
    }
    
    public ByteString getCampaignNameBytes() {
      return ((CampaignProto.VanillaCampaignPayload)this.instance).getCampaignNameBytes();
    }
    
    public long getCampaignStartTimeMillis() {
      return ((CampaignProto.VanillaCampaignPayload)this.instance).getCampaignStartTimeMillis();
    }
    
    public String getExperimentalCampaignId() {
      return ((CampaignProto.VanillaCampaignPayload)this.instance).getExperimentalCampaignId();
    }
    
    public ByteString getExperimentalCampaignIdBytes() {
      return ((CampaignProto.VanillaCampaignPayload)this.instance).getExperimentalCampaignIdBytes();
    }
    
    public Builder setCampaignEndTimeMillis(long param1Long) {
      copyOnWrite();
      ((CampaignProto.VanillaCampaignPayload)this.instance).setCampaignEndTimeMillis(param1Long);
      return this;
    }
    
    public Builder setCampaignId(String param1String) {
      copyOnWrite();
      ((CampaignProto.VanillaCampaignPayload)this.instance).setCampaignId(param1String);
      return this;
    }
    
    public Builder setCampaignIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((CampaignProto.VanillaCampaignPayload)this.instance).setCampaignIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setCampaignName(String param1String) {
      copyOnWrite();
      ((CampaignProto.VanillaCampaignPayload)this.instance).setCampaignName(param1String);
      return this;
    }
    
    public Builder setCampaignNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((CampaignProto.VanillaCampaignPayload)this.instance).setCampaignNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setCampaignStartTimeMillis(long param1Long) {
      copyOnWrite();
      ((CampaignProto.VanillaCampaignPayload)this.instance).setCampaignStartTimeMillis(param1Long);
      return this;
    }
    
    public Builder setExperimentalCampaignId(String param1String) {
      copyOnWrite();
      ((CampaignProto.VanillaCampaignPayload)this.instance).setExperimentalCampaignId(param1String);
      return this;
    }
    
    public Builder setExperimentalCampaignIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((CampaignProto.VanillaCampaignPayload)this.instance).setExperimentalCampaignIdBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface VanillaCampaignPayloadOrBuilder extends MessageLiteOrBuilder {
    long getCampaignEndTimeMillis();
    
    String getCampaignId();
    
    ByteString getCampaignIdBytes();
    
    String getCampaignName();
    
    ByteString getCampaignNameBytes();
    
    long getCampaignStartTimeMillis();
    
    String getExperimentalCampaignId();
    
    ByteString getExperimentalCampaignIdBytes();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\internal\firebase\inappmessaging\v1\CampaignProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */