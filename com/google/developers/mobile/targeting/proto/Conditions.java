package com.google.developers.mobile.targeting.proto;

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
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class Conditions {
  static {
  
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class AbtExperimentCondition extends GeneratedMessageLite<AbtExperimentCondition, AbtExperimentCondition.Builder> implements AbtExperimentConditionOrBuilder {
    private static final AbtExperimentCondition DEFAULT_INSTANCE = new AbtExperimentCondition();
    
    public static final int EXPERIMENT_ID_FIELD_NUMBER = 1;
    
    private static volatile Parser<AbtExperimentCondition> PARSER;
    
    private Internal.ProtobufList<String> experimentId_ = GeneratedMessageLite.emptyProtobufList();
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllExperimentId(Iterable<String> param1Iterable) {
      ensureExperimentIdIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.experimentId_);
    }
    
    private void addExperimentId(String param1String) {
      if (param1String != null) {
        ensureExperimentIdIsMutable();
        this.experimentId_.add(param1String);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addExperimentIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        ensureExperimentIdIsMutable();
        this.experimentId_.add(param1ByteString.toStringUtf8());
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearExperimentId() {
      this.experimentId_ = GeneratedMessageLite.emptyProtobufList();
    }
    
    private void ensureExperimentIdIsMutable() {
      if (!this.experimentId_.isModifiable())
        this.experimentId_ = GeneratedMessageLite.mutableCopy(this.experimentId_); 
    }
    
    public static AbtExperimentCondition getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(AbtExperimentCondition param1AbtExperimentCondition) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1AbtExperimentCondition);
    }
    
    public static AbtExperimentCondition parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (AbtExperimentCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static AbtExperimentCondition parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (AbtExperimentCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static AbtExperimentCondition parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (AbtExperimentCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static AbtExperimentCondition parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (AbtExperimentCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static AbtExperimentCondition parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (AbtExperimentCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static AbtExperimentCondition parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (AbtExperimentCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static AbtExperimentCondition parseFrom(InputStream param1InputStream) throws IOException {
      return (AbtExperimentCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static AbtExperimentCondition parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (AbtExperimentCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static AbtExperimentCondition parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (AbtExperimentCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static AbtExperimentCondition parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (AbtExperimentCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<AbtExperimentCondition> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setExperimentId(int param1Int, String param1String) {
      if (param1String != null) {
        ensureExperimentIdIsMutable();
        this.experimentId_.set(param1Int, param1String);
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/developers/mobile/targeting/proto/Conditions$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 321, 2 -> 317, 3 -> 306, 4 -> 297, 5 -> 263, 6 -> 110, 7 -> 259, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/developers/mobile/targeting/proto/Conditions$AbtExperimentCondition.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/developers/mobile/targeting/proto/Conditions$AbtExperimentCondition
      //   72: monitorenter
      //   73: getstatic com/google/developers/mobile/targeting/proto/Conditions$AbtExperimentCondition.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/developers/mobile/targeting/proto/Conditions$AbtExperimentCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$AbtExperimentCondition;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/developers/mobile/targeting/proto/Conditions$AbtExperimentCondition.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/developers/mobile/targeting/proto/Conditions$AbtExperimentCondition
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/developers/mobile/targeting/proto/Conditions$AbtExperimentCondition
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/developers/mobile/targeting/proto/Conditions$AbtExperimentCondition.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 259
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 203
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
      //   161: aload_1
      //   162: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   165: astore_2
      //   166: aload_0
      //   167: getfield experimentId_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   170: invokeinterface isModifiable : ()Z
      //   175: ifne -> 189
      //   178: aload_0
      //   179: aload_0
      //   180: getfield experimentId_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   183: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   186: putfield experimentId_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   189: aload_0
      //   190: getfield experimentId_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   193: aload_2
      //   194: invokeinterface add : (Ljava/lang/Object;)Z
      //   199: pop
      //   200: goto -> 123
      //   203: iconst_1
      //   204: istore #4
      //   206: goto -> 123
      //   209: astore_1
      //   210: goto -> 257
      //   213: astore_2
      //   214: new java/lang/RuntimeException
      //   217: astore_3
      //   218: new com/google/protobuf/InvalidProtocolBufferException
      //   221: astore_1
      //   222: aload_1
      //   223: aload_2
      //   224: invokevirtual getMessage : ()Ljava/lang/String;
      //   227: invokespecial <init> : (Ljava/lang/String;)V
      //   230: aload_3
      //   231: aload_1
      //   232: aload_0
      //   233: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   236: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   239: aload_3
      //   240: athrow
      //   241: astore_2
      //   242: new java/lang/RuntimeException
      //   245: astore_1
      //   246: aload_1
      //   247: aload_2
      //   248: aload_0
      //   249: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   252: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   255: aload_1
      //   256: athrow
      //   257: aload_1
      //   258: athrow
      //   259: getstatic com/google/developers/mobile/targeting/proto/Conditions$AbtExperimentCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$AbtExperimentCondition;
      //   262: areturn
      //   263: aload_2
      //   264: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   267: astore_1
      //   268: aload_3
      //   269: checkcast com/google/developers/mobile/targeting/proto/Conditions$AbtExperimentCondition
      //   272: astore_2
      //   273: aload_0
      //   274: aload_1
      //   275: aload_0
      //   276: getfield experimentId_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   279: aload_2
      //   280: getfield experimentId_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   283: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   288: putfield experimentId_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   291: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   294: astore_1
      //   295: aload_0
      //   296: areturn
      //   297: new com/google/developers/mobile/targeting/proto/Conditions$AbtExperimentCondition$Builder
      //   300: dup
      //   301: aconst_null
      //   302: invokespecial <init> : (Lcom/google/developers/mobile/targeting/proto/Conditions$1;)V
      //   305: areturn
      //   306: aload_0
      //   307: getfield experimentId_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   310: invokeinterface makeImmutable : ()V
      //   315: aconst_null
      //   316: areturn
      //   317: getstatic com/google/developers/mobile/targeting/proto/Conditions$AbtExperimentCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$AbtExperimentCondition;
      //   320: areturn
      //   321: new com/google/developers/mobile/targeting/proto/Conditions$AbtExperimentCondition
      //   324: dup
      //   325: invokespecial <init> : ()V
      //   328: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	241	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	213	java/io/IOException
      //   128	134	209	finally
      //   146	155	241	com/google/protobuf/InvalidProtocolBufferException
      //   146	155	213	java/io/IOException
      //   146	155	209	finally
      //   161	189	241	com/google/protobuf/InvalidProtocolBufferException
      //   161	189	213	java/io/IOException
      //   161	189	209	finally
      //   189	200	241	com/google/protobuf/InvalidProtocolBufferException
      //   189	200	213	java/io/IOException
      //   189	200	209	finally
      //   214	241	209	finally
      //   242	257	209	finally
    }
    
    public String getExperimentId(int param1Int) {
      return (String)this.experimentId_.get(param1Int);
    }
    
    public ByteString getExperimentIdBytes(int param1Int) {
      return ByteString.copyFromUtf8((String)this.experimentId_.get(param1Int));
    }
    
    public int getExperimentIdCount() {
      return this.experimentId_.size();
    }
    
    public List<String> getExperimentIdList() {
      return (List<String>)this.experimentId_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      int j = 0;
      while (i < this.experimentId_.size()) {
        j += CodedOutputStream.computeStringSizeNoTag((String)this.experimentId_.get(i));
        i++;
      } 
      i = 0 + j + getExperimentIdList().size() * 1;
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      for (byte b = 0; b < this.experimentId_.size(); b++)
        param1CodedOutputStream.writeString(1, (String)this.experimentId_.get(b)); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AbtExperimentCondition, Builder> implements Conditions.AbtExperimentConditionOrBuilder {
      private Builder() {
        super(Conditions.AbtExperimentCondition.DEFAULT_INSTANCE);
      }
      
      public Builder addAllExperimentId(Iterable<String> param2Iterable) {
        copyOnWrite();
        ((Conditions.AbtExperimentCondition)this.instance).addAllExperimentId(param2Iterable);
        return this;
      }
      
      public Builder addExperimentId(String param2String) {
        copyOnWrite();
        ((Conditions.AbtExperimentCondition)this.instance).addExperimentId(param2String);
        return this;
      }
      
      public Builder addExperimentIdBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((Conditions.AbtExperimentCondition)this.instance).addExperimentIdBytes(param2ByteString);
        return this;
      }
      
      public Builder clearExperimentId() {
        copyOnWrite();
        ((Conditions.AbtExperimentCondition)this.instance).clearExperimentId();
        return this;
      }
      
      public String getExperimentId(int param2Int) {
        return ((Conditions.AbtExperimentCondition)this.instance).getExperimentId(param2Int);
      }
      
      public ByteString getExperimentIdBytes(int param2Int) {
        return ((Conditions.AbtExperimentCondition)this.instance).getExperimentIdBytes(param2Int);
      }
      
      public int getExperimentIdCount() {
        return ((Conditions.AbtExperimentCondition)this.instance).getExperimentIdCount();
      }
      
      public List<String> getExperimentIdList() {
        return Collections.unmodifiableList(((Conditions.AbtExperimentCondition)this.instance).getExperimentIdList());
      }
      
      public Builder setExperimentId(int param2Int, String param2String) {
        copyOnWrite();
        ((Conditions.AbtExperimentCondition)this.instance).setExperimentId(param2Int, param2String);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<AbtExperimentCondition, AbtExperimentCondition.Builder> implements AbtExperimentConditionOrBuilder {
    private Builder() {
      super(Conditions.AbtExperimentCondition.DEFAULT_INSTANCE);
    }
    
    public Builder addAllExperimentId(Iterable<String> param1Iterable) {
      copyOnWrite();
      ((Conditions.AbtExperimentCondition)this.instance).addAllExperimentId(param1Iterable);
      return this;
    }
    
    public Builder addExperimentId(String param1String) {
      copyOnWrite();
      ((Conditions.AbtExperimentCondition)this.instance).addExperimentId(param1String);
      return this;
    }
    
    public Builder addExperimentIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Conditions.AbtExperimentCondition)this.instance).addExperimentIdBytes(param1ByteString);
      return this;
    }
    
    public Builder clearExperimentId() {
      copyOnWrite();
      ((Conditions.AbtExperimentCondition)this.instance).clearExperimentId();
      return this;
    }
    
    public String getExperimentId(int param1Int) {
      return ((Conditions.AbtExperimentCondition)this.instance).getExperimentId(param1Int);
    }
    
    public ByteString getExperimentIdBytes(int param1Int) {
      return ((Conditions.AbtExperimentCondition)this.instance).getExperimentIdBytes(param1Int);
    }
    
    public int getExperimentIdCount() {
      return ((Conditions.AbtExperimentCondition)this.instance).getExperimentIdCount();
    }
    
    public List<String> getExperimentIdList() {
      return Collections.unmodifiableList(((Conditions.AbtExperimentCondition)this.instance).getExperimentIdList());
    }
    
    public Builder setExperimentId(int param1Int, String param1String) {
      copyOnWrite();
      ((Conditions.AbtExperimentCondition)this.instance).setExperimentId(param1Int, param1String);
      return this;
    }
  }
  
  public static interface AbtExperimentConditionOrBuilder extends MessageLiteOrBuilder {
    String getExperimentId(int param1Int);
    
    ByteString getExperimentIdBytes(int param1Int);
    
    int getExperimentIdCount();
    
    List<String> getExperimentIdList();
  }
  
  public static final class AnalyticsAudienceCondition extends GeneratedMessageLite<AnalyticsAudienceCondition, AnalyticsAudienceCondition.Builder> implements AnalyticsAudienceConditionOrBuilder {
    private static final AnalyticsAudienceCondition DEFAULT_INSTANCE = new AnalyticsAudienceCondition();
    
    public static final int OPERATOR_FIELD_NUMBER = 1;
    
    private static volatile Parser<AnalyticsAudienceCondition> PARSER;
    
    public static final int TARGET_AUDIENCE_ENTITY_ID_FIELD_NUMBER = 3;
    
    public static final int TARGET_AUDIENCE_NAMES_FIELD_NUMBER = 2;
    
    private int bitField0_;
    
    private int operator_;
    
    private Internal.LongList targetAudienceEntityId_ = emptyLongList();
    
    private Internal.ProtobufList<String> targetAudienceNames_ = GeneratedMessageLite.emptyProtobufList();
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllTargetAudienceEntityId(Iterable<? extends Long> param1Iterable) {
      ensureTargetAudienceEntityIdIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.targetAudienceEntityId_);
    }
    
    private void addAllTargetAudienceNames(Iterable<String> param1Iterable) {
      ensureTargetAudienceNamesIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.targetAudienceNames_);
    }
    
    private void addTargetAudienceEntityId(long param1Long) {
      ensureTargetAudienceEntityIdIsMutable();
      this.targetAudienceEntityId_.addLong(param1Long);
    }
    
    private void addTargetAudienceNames(String param1String) {
      if (param1String != null) {
        ensureTargetAudienceNamesIsMutable();
        this.targetAudienceNames_.add(param1String);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addTargetAudienceNamesBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        ensureTargetAudienceNamesIsMutable();
        this.targetAudienceNames_.add(param1ByteString.toStringUtf8());
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearOperator() {
      this.operator_ = 0;
    }
    
    private void clearTargetAudienceEntityId() {
      this.targetAudienceEntityId_ = emptyLongList();
    }
    
    private void clearTargetAudienceNames() {
      this.targetAudienceNames_ = GeneratedMessageLite.emptyProtobufList();
    }
    
    private void ensureTargetAudienceEntityIdIsMutable() {
      if (!this.targetAudienceEntityId_.isModifiable())
        this.targetAudienceEntityId_ = GeneratedMessageLite.mutableCopy(this.targetAudienceEntityId_); 
    }
    
    private void ensureTargetAudienceNamesIsMutable() {
      if (!this.targetAudienceNames_.isModifiable())
        this.targetAudienceNames_ = GeneratedMessageLite.mutableCopy(this.targetAudienceNames_); 
    }
    
    public static AnalyticsAudienceCondition getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(AnalyticsAudienceCondition param1AnalyticsAudienceCondition) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1AnalyticsAudienceCondition);
    }
    
    public static AnalyticsAudienceCondition parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (AnalyticsAudienceCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static AnalyticsAudienceCondition parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (AnalyticsAudienceCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static AnalyticsAudienceCondition parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (AnalyticsAudienceCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static AnalyticsAudienceCondition parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (AnalyticsAudienceCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static AnalyticsAudienceCondition parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (AnalyticsAudienceCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static AnalyticsAudienceCondition parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (AnalyticsAudienceCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static AnalyticsAudienceCondition parseFrom(InputStream param1InputStream) throws IOException {
      return (AnalyticsAudienceCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static AnalyticsAudienceCondition parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (AnalyticsAudienceCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static AnalyticsAudienceCondition parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (AnalyticsAudienceCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static AnalyticsAudienceCondition parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (AnalyticsAudienceCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<AnalyticsAudienceCondition> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setOperator(AnalyticsAudienceOperator param1AnalyticsAudienceOperator) {
      if (param1AnalyticsAudienceOperator != null) {
        this.operator_ = param1AnalyticsAudienceOperator.getNumber();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setOperatorValue(int param1Int) {
      this.operator_ = param1Int;
    }
    
    private void setTargetAudienceEntityId(int param1Int, long param1Long) {
      ensureTargetAudienceEntityIdIsMutable();
      this.targetAudienceEntityId_.setLong(param1Int, param1Long);
    }
    
    private void setTargetAudienceNames(int param1Int, String param1String) {
      if (param1String != null) {
        ensureTargetAudienceNamesIsMutable();
        this.targetAudienceNames_.set(param1Int, param1String);
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/developers/mobile/targeting/proto/Conditions$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: istore #4
      //   10: iconst_0
      //   11: istore #5
      //   13: iconst_0
      //   14: istore #6
      //   16: iload #4
      //   18: tableswitch default -> 64, 1 -> 564, 2 -> 560, 3 -> 540, 4 -> 531, 5 -> 411, 6 -> 118, 7 -> 407, 8 -> 72
      //   64: new java/lang/UnsupportedOperationException
      //   67: dup
      //   68: invokespecial <init> : ()V
      //   71: athrow
      //   72: getstatic com/google/developers/mobile/targeting/proto/Conditions$AnalyticsAudienceCondition.PARSER : Lcom/google/protobuf/Parser;
      //   75: ifnonnull -> 114
      //   78: ldc com/google/developers/mobile/targeting/proto/Conditions$AnalyticsAudienceCondition
      //   80: monitorenter
      //   81: getstatic com/google/developers/mobile/targeting/proto/Conditions$AnalyticsAudienceCondition.PARSER : Lcom/google/protobuf/Parser;
      //   84: ifnonnull -> 102
      //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   90: astore_1
      //   91: aload_1
      //   92: getstatic com/google/developers/mobile/targeting/proto/Conditions$AnalyticsAudienceCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$AnalyticsAudienceCondition;
      //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   98: aload_1
      //   99: putstatic com/google/developers/mobile/targeting/proto/Conditions$AnalyticsAudienceCondition.PARSER : Lcom/google/protobuf/Parser;
      //   102: ldc com/google/developers/mobile/targeting/proto/Conditions$AnalyticsAudienceCondition
      //   104: monitorexit
      //   105: goto -> 114
      //   108: astore_1
      //   109: ldc com/google/developers/mobile/targeting/proto/Conditions$AnalyticsAudienceCondition
      //   111: monitorexit
      //   112: aload_1
      //   113: athrow
      //   114: getstatic com/google/developers/mobile/targeting/proto/Conditions$AnalyticsAudienceCondition.PARSER : Lcom/google/protobuf/Parser;
      //   117: areturn
      //   118: aload_2
      //   119: checkcast com/google/protobuf/CodedInputStream
      //   122: astore_1
      //   123: aload_3
      //   124: checkcast com/google/protobuf/ExtensionRegistryLite
      //   127: astore_2
      //   128: iload #6
      //   130: ifne -> 407
      //   133: aload_1
      //   134: invokevirtual readTag : ()I
      //   137: istore #4
      //   139: iload #4
      //   141: ifeq -> 351
      //   144: iload #4
      //   146: bipush #8
      //   148: if_icmpeq -> 340
      //   151: iload #4
      //   153: bipush #18
      //   155: if_icmpeq -> 298
      //   158: iload #4
      //   160: bipush #24
      //   162: if_icmpeq -> 259
      //   165: iload #4
      //   167: bipush #26
      //   169: if_icmpeq -> 187
      //   172: aload_1
      //   173: iload #4
      //   175: invokevirtual skipField : (I)Z
      //   178: ifne -> 128
      //   181: iconst_1
      //   182: istore #6
      //   184: goto -> 128
      //   187: aload_1
      //   188: aload_1
      //   189: invokevirtual readRawVarint32 : ()I
      //   192: invokevirtual pushLimit : (I)I
      //   195: istore #4
      //   197: aload_0
      //   198: getfield targetAudienceEntityId_ : Lcom/google/protobuf/Internal$LongList;
      //   201: invokeinterface isModifiable : ()Z
      //   206: ifne -> 227
      //   209: aload_1
      //   210: invokevirtual getBytesUntilLimit : ()I
      //   213: ifle -> 227
      //   216: aload_0
      //   217: aload_0
      //   218: getfield targetAudienceEntityId_ : Lcom/google/protobuf/Internal$LongList;
      //   221: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$LongList;)Lcom/google/protobuf/Internal$LongList;
      //   224: putfield targetAudienceEntityId_ : Lcom/google/protobuf/Internal$LongList;
      //   227: aload_1
      //   228: invokevirtual getBytesUntilLimit : ()I
      //   231: ifle -> 250
      //   234: aload_0
      //   235: getfield targetAudienceEntityId_ : Lcom/google/protobuf/Internal$LongList;
      //   238: aload_1
      //   239: invokevirtual readInt64 : ()J
      //   242: invokeinterface addLong : (J)V
      //   247: goto -> 227
      //   250: aload_1
      //   251: iload #4
      //   253: invokevirtual popLimit : (I)V
      //   256: goto -> 128
      //   259: aload_0
      //   260: getfield targetAudienceEntityId_ : Lcom/google/protobuf/Internal$LongList;
      //   263: invokeinterface isModifiable : ()Z
      //   268: ifne -> 282
      //   271: aload_0
      //   272: aload_0
      //   273: getfield targetAudienceEntityId_ : Lcom/google/protobuf/Internal$LongList;
      //   276: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$LongList;)Lcom/google/protobuf/Internal$LongList;
      //   279: putfield targetAudienceEntityId_ : Lcom/google/protobuf/Internal$LongList;
      //   282: aload_0
      //   283: getfield targetAudienceEntityId_ : Lcom/google/protobuf/Internal$LongList;
      //   286: aload_1
      //   287: invokevirtual readInt64 : ()J
      //   290: invokeinterface addLong : (J)V
      //   295: goto -> 128
      //   298: aload_1
      //   299: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   302: astore_2
      //   303: aload_0
      //   304: getfield targetAudienceNames_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   307: invokeinterface isModifiable : ()Z
      //   312: ifne -> 326
      //   315: aload_0
      //   316: aload_0
      //   317: getfield targetAudienceNames_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   320: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   323: putfield targetAudienceNames_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   326: aload_0
      //   327: getfield targetAudienceNames_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   330: aload_2
      //   331: invokeinterface add : (Ljava/lang/Object;)Z
      //   336: pop
      //   337: goto -> 128
      //   340: aload_0
      //   341: aload_1
      //   342: invokevirtual readEnum : ()I
      //   345: putfield operator_ : I
      //   348: goto -> 128
      //   351: iconst_1
      //   352: istore #6
      //   354: goto -> 128
      //   357: astore_1
      //   358: goto -> 405
      //   361: astore_2
      //   362: new java/lang/RuntimeException
      //   365: astore_1
      //   366: new com/google/protobuf/InvalidProtocolBufferException
      //   369: astore_3
      //   370: aload_3
      //   371: aload_2
      //   372: invokevirtual getMessage : ()Ljava/lang/String;
      //   375: invokespecial <init> : (Ljava/lang/String;)V
      //   378: aload_1
      //   379: aload_3
      //   380: aload_0
      //   381: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   384: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   387: aload_1
      //   388: athrow
      //   389: astore_1
      //   390: new java/lang/RuntimeException
      //   393: astore_2
      //   394: aload_2
      //   395: aload_1
      //   396: aload_0
      //   397: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   400: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   403: aload_2
      //   404: athrow
      //   405: aload_1
      //   406: athrow
      //   407: getstatic com/google/developers/mobile/targeting/proto/Conditions$AnalyticsAudienceCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$AnalyticsAudienceCondition;
      //   410: areturn
      //   411: aload_2
      //   412: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   415: astore_1
      //   416: aload_3
      //   417: checkcast com/google/developers/mobile/targeting/proto/Conditions$AnalyticsAudienceCondition
      //   420: astore_2
      //   421: aload_0
      //   422: getfield operator_ : I
      //   425: ifeq -> 434
      //   428: iconst_1
      //   429: istore #7
      //   431: goto -> 437
      //   434: iconst_0
      //   435: istore #7
      //   437: aload_0
      //   438: getfield operator_ : I
      //   441: istore #6
      //   443: aload_2
      //   444: getfield operator_ : I
      //   447: ifeq -> 453
      //   450: iconst_1
      //   451: istore #5
      //   453: aload_0
      //   454: aload_1
      //   455: iload #7
      //   457: iload #6
      //   459: iload #5
      //   461: aload_2
      //   462: getfield operator_ : I
      //   465: invokeinterface visitInt : (ZIZI)I
      //   470: putfield operator_ : I
      //   473: aload_0
      //   474: aload_1
      //   475: aload_0
      //   476: getfield targetAudienceNames_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   479: aload_2
      //   480: getfield targetAudienceNames_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   483: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   488: putfield targetAudienceNames_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   491: aload_0
      //   492: aload_1
      //   493: aload_0
      //   494: getfield targetAudienceEntityId_ : Lcom/google/protobuf/Internal$LongList;
      //   497: aload_2
      //   498: getfield targetAudienceEntityId_ : Lcom/google/protobuf/Internal$LongList;
      //   501: invokeinterface visitLongList : (Lcom/google/protobuf/Internal$LongList;Lcom/google/protobuf/Internal$LongList;)Lcom/google/protobuf/Internal$LongList;
      //   506: putfield targetAudienceEntityId_ : Lcom/google/protobuf/Internal$LongList;
      //   509: aload_1
      //   510: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   513: if_acmpne -> 529
      //   516: aload_0
      //   517: aload_0
      //   518: getfield bitField0_ : I
      //   521: aload_2
      //   522: getfield bitField0_ : I
      //   525: ior
      //   526: putfield bitField0_ : I
      //   529: aload_0
      //   530: areturn
      //   531: new com/google/developers/mobile/targeting/proto/Conditions$AnalyticsAudienceCondition$Builder
      //   534: dup
      //   535: aconst_null
      //   536: invokespecial <init> : (Lcom/google/developers/mobile/targeting/proto/Conditions$1;)V
      //   539: areturn
      //   540: aload_0
      //   541: getfield targetAudienceNames_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   544: invokeinterface makeImmutable : ()V
      //   549: aload_0
      //   550: getfield targetAudienceEntityId_ : Lcom/google/protobuf/Internal$LongList;
      //   553: invokeinterface makeImmutable : ()V
      //   558: aconst_null
      //   559: areturn
      //   560: getstatic com/google/developers/mobile/targeting/proto/Conditions$AnalyticsAudienceCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$AnalyticsAudienceCondition;
      //   563: areturn
      //   564: new com/google/developers/mobile/targeting/proto/Conditions$AnalyticsAudienceCondition
      //   567: dup
      //   568: invokespecial <init> : ()V
      //   571: areturn
      // Exception table:
      //   from	to	target	type
      //   81	102	108	finally
      //   102	105	108	finally
      //   109	112	108	finally
      //   133	139	389	com/google/protobuf/InvalidProtocolBufferException
      //   133	139	361	java/io/IOException
      //   133	139	357	finally
      //   172	181	389	com/google/protobuf/InvalidProtocolBufferException
      //   172	181	361	java/io/IOException
      //   172	181	357	finally
      //   187	227	389	com/google/protobuf/InvalidProtocolBufferException
      //   187	227	361	java/io/IOException
      //   187	227	357	finally
      //   227	247	389	com/google/protobuf/InvalidProtocolBufferException
      //   227	247	361	java/io/IOException
      //   227	247	357	finally
      //   250	256	389	com/google/protobuf/InvalidProtocolBufferException
      //   250	256	361	java/io/IOException
      //   250	256	357	finally
      //   259	282	389	com/google/protobuf/InvalidProtocolBufferException
      //   259	282	361	java/io/IOException
      //   259	282	357	finally
      //   282	295	389	com/google/protobuf/InvalidProtocolBufferException
      //   282	295	361	java/io/IOException
      //   282	295	357	finally
      //   298	326	389	com/google/protobuf/InvalidProtocolBufferException
      //   298	326	361	java/io/IOException
      //   298	326	357	finally
      //   326	337	389	com/google/protobuf/InvalidProtocolBufferException
      //   326	337	361	java/io/IOException
      //   326	337	357	finally
      //   340	348	389	com/google/protobuf/InvalidProtocolBufferException
      //   340	348	361	java/io/IOException
      //   340	348	357	finally
      //   362	389	357	finally
      //   390	405	357	finally
    }
    
    public AnalyticsAudienceOperator getOperator() {
      AnalyticsAudienceOperator analyticsAudienceOperator1 = AnalyticsAudienceOperator.forNumber(this.operator_);
      AnalyticsAudienceOperator analyticsAudienceOperator2 = analyticsAudienceOperator1;
      if (analyticsAudienceOperator1 == null)
        analyticsAudienceOperator2 = AnalyticsAudienceOperator.UNRECOGNIZED; 
      return analyticsAudienceOperator2;
    }
    
    public int getOperatorValue() {
      return this.operator_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      int j = this.operator_;
      i = AnalyticsAudienceOperator.UNKNOWN.getNumber();
      int k = 0;
      if (j != i) {
        i = CodedOutputStream.computeEnumSize(1, this.operator_) + 0;
      } else {
        i = 0;
      } 
      int m = 0;
      j = 0;
      while (m < this.targetAudienceNames_.size()) {
        j += CodedOutputStream.computeStringSizeNoTag((String)this.targetAudienceNames_.get(m));
        m++;
      } 
      int n = getTargetAudienceNamesList().size();
      byte b = 0;
      m = k;
      k = b;
      while (m < this.targetAudienceEntityId_.size()) {
        k += CodedOutputStream.computeInt64SizeNoTag(this.targetAudienceEntityId_.getLong(m));
        m++;
      } 
      i = i + j + n * 1 + k + getTargetAudienceEntityIdList().size() * 1;
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public long getTargetAudienceEntityId(int param1Int) {
      return this.targetAudienceEntityId_.getLong(param1Int);
    }
    
    public int getTargetAudienceEntityIdCount() {
      return this.targetAudienceEntityId_.size();
    }
    
    public List<Long> getTargetAudienceEntityIdList() {
      return (List<Long>)this.targetAudienceEntityId_;
    }
    
    public String getTargetAudienceNames(int param1Int) {
      return (String)this.targetAudienceNames_.get(param1Int);
    }
    
    public ByteString getTargetAudienceNamesBytes(int param1Int) {
      return ByteString.copyFromUtf8((String)this.targetAudienceNames_.get(param1Int));
    }
    
    public int getTargetAudienceNamesCount() {
      return this.targetAudienceNames_.size();
    }
    
    public List<String> getTargetAudienceNamesList() {
      return (List<String>)this.targetAudienceNames_;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      byte b3;
      getSerializedSize();
      if (this.operator_ != AnalyticsAudienceOperator.UNKNOWN.getNumber())
        param1CodedOutputStream.writeEnum(1, this.operator_); 
      byte b1 = 0;
      byte b2 = 0;
      while (true) {
        b3 = b1;
        if (b2 < this.targetAudienceNames_.size()) {
          param1CodedOutputStream.writeString(2, (String)this.targetAudienceNames_.get(b2));
          b2++;
          continue;
        } 
        break;
      } 
      while (b3 < this.targetAudienceEntityId_.size()) {
        param1CodedOutputStream.writeInt64(3, this.targetAudienceEntityId_.getLong(b3));
        b3++;
      } 
    }
    
    public enum AnalyticsAudienceOperator implements Internal.EnumLite {
      IN_ALL,
      IN_AT_LEAST_ONE,
      IN_NONE,
      NOT_IN_AT_LEAST_ONE,
      UNKNOWN(0),
      UNRECOGNIZED(0);
      
      public static final int IN_ALL_VALUE = 3;
      
      public static final int IN_AT_LEAST_ONE_VALUE = 1;
      
      public static final int IN_NONE_VALUE = 4;
      
      public static final int NOT_IN_AT_LEAST_ONE_VALUE = 2;
      
      public static final int UNKNOWN_VALUE = 0;
      
      private static final Internal.EnumLiteMap<AnalyticsAudienceOperator> internalValueMap;
      
      private final int value;
      
      static {
        $VALUES = new AnalyticsAudienceOperator[] { UNKNOWN, IN_AT_LEAST_ONE, NOT_IN_AT_LEAST_ONE, IN_ALL, IN_NONE, UNRECOGNIZED };
        internalValueMap = new Internal.EnumLiteMap<AnalyticsAudienceOperator>() {
            public Conditions.AnalyticsAudienceCondition.AnalyticsAudienceOperator findValueByNumber(int param3Int) {
              return Conditions.AnalyticsAudienceCondition.AnalyticsAudienceOperator.forNumber(param3Int);
            }
          };
      }
      
      AnalyticsAudienceOperator(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static AnalyticsAudienceOperator forNumber(int param2Int) {
        switch (param2Int) {
          default:
            return null;
          case 4:
            return IN_NONE;
          case 3:
            return IN_ALL;
          case 2:
            return NOT_IN_AT_LEAST_ONE;
          case 1:
            return IN_AT_LEAST_ONE;
          case 0:
            break;
        } 
        return UNKNOWN;
      }
      
      public static Internal.EnumLiteMap<AnalyticsAudienceOperator> internalGetValueMap() {
        return internalValueMap;
      }
      
      public final int getNumber() {
        return this.value;
      }
    }
    
    class null implements Internal.EnumLiteMap<AnalyticsAudienceOperator> {
      public Conditions.AnalyticsAudienceCondition.AnalyticsAudienceOperator findValueByNumber(int param2Int) {
        return Conditions.AnalyticsAudienceCondition.AnalyticsAudienceOperator.forNumber(param2Int);
      }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AnalyticsAudienceCondition, Builder> implements Conditions.AnalyticsAudienceConditionOrBuilder {
      private Builder() {
        super(Conditions.AnalyticsAudienceCondition.DEFAULT_INSTANCE);
      }
      
      public Builder addAllTargetAudienceEntityId(Iterable<? extends Long> param2Iterable) {
        copyOnWrite();
        ((Conditions.AnalyticsAudienceCondition)this.instance).addAllTargetAudienceEntityId(param2Iterable);
        return this;
      }
      
      public Builder addAllTargetAudienceNames(Iterable<String> param2Iterable) {
        copyOnWrite();
        ((Conditions.AnalyticsAudienceCondition)this.instance).addAllTargetAudienceNames(param2Iterable);
        return this;
      }
      
      public Builder addTargetAudienceEntityId(long param2Long) {
        copyOnWrite();
        ((Conditions.AnalyticsAudienceCondition)this.instance).addTargetAudienceEntityId(param2Long);
        return this;
      }
      
      public Builder addTargetAudienceNames(String param2String) {
        copyOnWrite();
        ((Conditions.AnalyticsAudienceCondition)this.instance).addTargetAudienceNames(param2String);
        return this;
      }
      
      public Builder addTargetAudienceNamesBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((Conditions.AnalyticsAudienceCondition)this.instance).addTargetAudienceNamesBytes(param2ByteString);
        return this;
      }
      
      public Builder clearOperator() {
        copyOnWrite();
        ((Conditions.AnalyticsAudienceCondition)this.instance).clearOperator();
        return this;
      }
      
      public Builder clearTargetAudienceEntityId() {
        copyOnWrite();
        ((Conditions.AnalyticsAudienceCondition)this.instance).clearTargetAudienceEntityId();
        return this;
      }
      
      public Builder clearTargetAudienceNames() {
        copyOnWrite();
        ((Conditions.AnalyticsAudienceCondition)this.instance).clearTargetAudienceNames();
        return this;
      }
      
      public Conditions.AnalyticsAudienceCondition.AnalyticsAudienceOperator getOperator() {
        return ((Conditions.AnalyticsAudienceCondition)this.instance).getOperator();
      }
      
      public int getOperatorValue() {
        return ((Conditions.AnalyticsAudienceCondition)this.instance).getOperatorValue();
      }
      
      public long getTargetAudienceEntityId(int param2Int) {
        return ((Conditions.AnalyticsAudienceCondition)this.instance).getTargetAudienceEntityId(param2Int);
      }
      
      public int getTargetAudienceEntityIdCount() {
        return ((Conditions.AnalyticsAudienceCondition)this.instance).getTargetAudienceEntityIdCount();
      }
      
      public List<Long> getTargetAudienceEntityIdList() {
        return Collections.unmodifiableList(((Conditions.AnalyticsAudienceCondition)this.instance).getTargetAudienceEntityIdList());
      }
      
      public String getTargetAudienceNames(int param2Int) {
        return ((Conditions.AnalyticsAudienceCondition)this.instance).getTargetAudienceNames(param2Int);
      }
      
      public ByteString getTargetAudienceNamesBytes(int param2Int) {
        return ((Conditions.AnalyticsAudienceCondition)this.instance).getTargetAudienceNamesBytes(param2Int);
      }
      
      public int getTargetAudienceNamesCount() {
        return ((Conditions.AnalyticsAudienceCondition)this.instance).getTargetAudienceNamesCount();
      }
      
      public List<String> getTargetAudienceNamesList() {
        return Collections.unmodifiableList(((Conditions.AnalyticsAudienceCondition)this.instance).getTargetAudienceNamesList());
      }
      
      public Builder setOperator(Conditions.AnalyticsAudienceCondition.AnalyticsAudienceOperator param2AnalyticsAudienceOperator) {
        copyOnWrite();
        ((Conditions.AnalyticsAudienceCondition)this.instance).setOperator(param2AnalyticsAudienceOperator);
        return this;
      }
      
      public Builder setOperatorValue(int param2Int) {
        copyOnWrite();
        ((Conditions.AnalyticsAudienceCondition)this.instance).setOperatorValue(param2Int);
        return this;
      }
      
      public Builder setTargetAudienceEntityId(int param2Int, long param2Long) {
        copyOnWrite();
        ((Conditions.AnalyticsAudienceCondition)this.instance).setTargetAudienceEntityId(param2Int, param2Long);
        return this;
      }
      
      public Builder setTargetAudienceNames(int param2Int, String param2String) {
        copyOnWrite();
        ((Conditions.AnalyticsAudienceCondition)this.instance).setTargetAudienceNames(param2Int, param2String);
        return this;
      }
    }
  }
  
  public enum AnalyticsAudienceOperator implements Internal.EnumLite {
    IN_ALL(0),
    IN_AT_LEAST_ONE(0),
    IN_NONE(0),
    NOT_IN_AT_LEAST_ONE(0),
    UNKNOWN(0),
    UNRECOGNIZED(0);
    
    public static final int IN_ALL_VALUE = 3;
    
    public static final int IN_AT_LEAST_ONE_VALUE = 1;
    
    public static final int IN_NONE_VALUE = 4;
    
    public static final int NOT_IN_AT_LEAST_ONE_VALUE = 2;
    
    public static final int UNKNOWN_VALUE = 0;
    
    private static final Internal.EnumLiteMap<AnalyticsAudienceOperator> internalValueMap;
    
    private final int value;
    
    static {
      IN_ALL = new AnalyticsAudienceOperator("IN_ALL", 3, 3);
      IN_NONE = new AnalyticsAudienceOperator("IN_NONE", 4, 4);
      UNRECOGNIZED = new AnalyticsAudienceOperator("UNRECOGNIZED", 5, -1);
      $VALUES = new AnalyticsAudienceOperator[] { UNKNOWN, IN_AT_LEAST_ONE, NOT_IN_AT_LEAST_ONE, IN_ALL, IN_NONE, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<AnalyticsAudienceOperator>() {
          public Conditions.AnalyticsAudienceCondition.AnalyticsAudienceOperator findValueByNumber(int param3Int) {
            return Conditions.AnalyticsAudienceCondition.AnalyticsAudienceOperator.forNumber(param3Int);
          }
        };
    }
    
    AnalyticsAudienceOperator(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static AnalyticsAudienceOperator forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 4:
          return IN_NONE;
        case 3:
          return IN_ALL;
        case 2:
          return NOT_IN_AT_LEAST_ONE;
        case 1:
          return IN_AT_LEAST_ONE;
        case 0:
          break;
      } 
      return UNKNOWN;
    }
    
    public static Internal.EnumLiteMap<AnalyticsAudienceOperator> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<AnalyticsAudienceCondition.AnalyticsAudienceOperator> {
    public Conditions.AnalyticsAudienceCondition.AnalyticsAudienceOperator findValueByNumber(int param1Int) {
      return Conditions.AnalyticsAudienceCondition.AnalyticsAudienceOperator.forNumber(param1Int);
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<AnalyticsAudienceCondition, AnalyticsAudienceCondition.Builder> implements AnalyticsAudienceConditionOrBuilder {
    private Builder() {
      super(Conditions.AnalyticsAudienceCondition.DEFAULT_INSTANCE);
    }
    
    public Builder addAllTargetAudienceEntityId(Iterable<? extends Long> param1Iterable) {
      copyOnWrite();
      ((Conditions.AnalyticsAudienceCondition)this.instance).addAllTargetAudienceEntityId(param1Iterable);
      return this;
    }
    
    public Builder addAllTargetAudienceNames(Iterable<String> param1Iterable) {
      copyOnWrite();
      ((Conditions.AnalyticsAudienceCondition)this.instance).addAllTargetAudienceNames(param1Iterable);
      return this;
    }
    
    public Builder addTargetAudienceEntityId(long param1Long) {
      copyOnWrite();
      ((Conditions.AnalyticsAudienceCondition)this.instance).addTargetAudienceEntityId(param1Long);
      return this;
    }
    
    public Builder addTargetAudienceNames(String param1String) {
      copyOnWrite();
      ((Conditions.AnalyticsAudienceCondition)this.instance).addTargetAudienceNames(param1String);
      return this;
    }
    
    public Builder addTargetAudienceNamesBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Conditions.AnalyticsAudienceCondition)this.instance).addTargetAudienceNamesBytes(param1ByteString);
      return this;
    }
    
    public Builder clearOperator() {
      copyOnWrite();
      ((Conditions.AnalyticsAudienceCondition)this.instance).clearOperator();
      return this;
    }
    
    public Builder clearTargetAudienceEntityId() {
      copyOnWrite();
      ((Conditions.AnalyticsAudienceCondition)this.instance).clearTargetAudienceEntityId();
      return this;
    }
    
    public Builder clearTargetAudienceNames() {
      copyOnWrite();
      ((Conditions.AnalyticsAudienceCondition)this.instance).clearTargetAudienceNames();
      return this;
    }
    
    public Conditions.AnalyticsAudienceCondition.AnalyticsAudienceOperator getOperator() {
      return ((Conditions.AnalyticsAudienceCondition)this.instance).getOperator();
    }
    
    public int getOperatorValue() {
      return ((Conditions.AnalyticsAudienceCondition)this.instance).getOperatorValue();
    }
    
    public long getTargetAudienceEntityId(int param1Int) {
      return ((Conditions.AnalyticsAudienceCondition)this.instance).getTargetAudienceEntityId(param1Int);
    }
    
    public int getTargetAudienceEntityIdCount() {
      return ((Conditions.AnalyticsAudienceCondition)this.instance).getTargetAudienceEntityIdCount();
    }
    
    public List<Long> getTargetAudienceEntityIdList() {
      return Collections.unmodifiableList(((Conditions.AnalyticsAudienceCondition)this.instance).getTargetAudienceEntityIdList());
    }
    
    public String getTargetAudienceNames(int param1Int) {
      return ((Conditions.AnalyticsAudienceCondition)this.instance).getTargetAudienceNames(param1Int);
    }
    
    public ByteString getTargetAudienceNamesBytes(int param1Int) {
      return ((Conditions.AnalyticsAudienceCondition)this.instance).getTargetAudienceNamesBytes(param1Int);
    }
    
    public int getTargetAudienceNamesCount() {
      return ((Conditions.AnalyticsAudienceCondition)this.instance).getTargetAudienceNamesCount();
    }
    
    public List<String> getTargetAudienceNamesList() {
      return Collections.unmodifiableList(((Conditions.AnalyticsAudienceCondition)this.instance).getTargetAudienceNamesList());
    }
    
    public Builder setOperator(Conditions.AnalyticsAudienceCondition.AnalyticsAudienceOperator param1AnalyticsAudienceOperator) {
      copyOnWrite();
      ((Conditions.AnalyticsAudienceCondition)this.instance).setOperator(param1AnalyticsAudienceOperator);
      return this;
    }
    
    public Builder setOperatorValue(int param1Int) {
      copyOnWrite();
      ((Conditions.AnalyticsAudienceCondition)this.instance).setOperatorValue(param1Int);
      return this;
    }
    
    public Builder setTargetAudienceEntityId(int param1Int, long param1Long) {
      copyOnWrite();
      ((Conditions.AnalyticsAudienceCondition)this.instance).setTargetAudienceEntityId(param1Int, param1Long);
      return this;
    }
    
    public Builder setTargetAudienceNames(int param1Int, String param1String) {
      copyOnWrite();
      ((Conditions.AnalyticsAudienceCondition)this.instance).setTargetAudienceNames(param1Int, param1String);
      return this;
    }
  }
  
  public static interface AnalyticsAudienceConditionOrBuilder extends MessageLiteOrBuilder {
    Conditions.AnalyticsAudienceCondition.AnalyticsAudienceOperator getOperator();
    
    int getOperatorValue();
    
    long getTargetAudienceEntityId(int param1Int);
    
    int getTargetAudienceEntityIdCount();
    
    List<Long> getTargetAudienceEntityIdList();
    
    String getTargetAudienceNames(int param1Int);
    
    ByteString getTargetAudienceNamesBytes(int param1Int);
    
    int getTargetAudienceNamesCount();
    
    List<String> getTargetAudienceNamesList();
  }
  
  public static final class AnalyticsUserPropertyCondition extends GeneratedMessageLite<AnalyticsUserPropertyCondition, AnalyticsUserPropertyCondition.Builder> implements AnalyticsUserPropertyConditionOrBuilder {
    private static final AnalyticsUserPropertyCondition DEFAULT_INSTANCE = new AnalyticsUserPropertyCondition();
    
    public static final int OPERATOR_FIELD_NUMBER = 1;
    
    private static volatile Parser<AnalyticsUserPropertyCondition> PARSER;
    
    public static final int TARGET_USER_PROPERTY_ENTITY_ID_FIELD_NUMBER = 4;
    
    public static final int TARGET_USER_PROPERTY_NAME_FIELD_NUMBER = 3;
    
    public static final int TARGET_USER_PROPERTY_VALUES_FIELD_NUMBER = 5;
    
    public static final int TARGET_USER_PROPERTY_VALUE_FIELD_NUMBER = 2;
    
    private int bitField0_;
    
    private int operator_;
    
    private long targetUserPropertyEntityId_;
    
    private String targetUserPropertyName_ = "";
    
    private String targetUserPropertyValue_ = "";
    
    private Internal.ProtobufList<String> targetUserPropertyValues_ = GeneratedMessageLite.emptyProtobufList();
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllTargetUserPropertyValues(Iterable<String> param1Iterable) {
      ensureTargetUserPropertyValuesIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.targetUserPropertyValues_);
    }
    
    private void addTargetUserPropertyValues(String param1String) {
      if (param1String != null) {
        ensureTargetUserPropertyValuesIsMutable();
        this.targetUserPropertyValues_.add(param1String);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addTargetUserPropertyValuesBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        ensureTargetUserPropertyValuesIsMutable();
        this.targetUserPropertyValues_.add(param1ByteString.toStringUtf8());
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearOperator() {
      this.operator_ = 0;
    }
    
    private void clearTargetUserPropertyEntityId() {
      this.targetUserPropertyEntityId_ = 0L;
    }
    
    private void clearTargetUserPropertyName() {
      this.targetUserPropertyName_ = getDefaultInstance().getTargetUserPropertyName();
    }
    
    private void clearTargetUserPropertyValue() {
      this.targetUserPropertyValue_ = getDefaultInstance().getTargetUserPropertyValue();
    }
    
    private void clearTargetUserPropertyValues() {
      this.targetUserPropertyValues_ = GeneratedMessageLite.emptyProtobufList();
    }
    
    private void ensureTargetUserPropertyValuesIsMutable() {
      if (!this.targetUserPropertyValues_.isModifiable())
        this.targetUserPropertyValues_ = GeneratedMessageLite.mutableCopy(this.targetUserPropertyValues_); 
    }
    
    public static AnalyticsUserPropertyCondition getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(AnalyticsUserPropertyCondition param1AnalyticsUserPropertyCondition) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1AnalyticsUserPropertyCondition);
    }
    
    public static AnalyticsUserPropertyCondition parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (AnalyticsUserPropertyCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static AnalyticsUserPropertyCondition parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (AnalyticsUserPropertyCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static AnalyticsUserPropertyCondition parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (AnalyticsUserPropertyCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static AnalyticsUserPropertyCondition parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (AnalyticsUserPropertyCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static AnalyticsUserPropertyCondition parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (AnalyticsUserPropertyCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static AnalyticsUserPropertyCondition parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (AnalyticsUserPropertyCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static AnalyticsUserPropertyCondition parseFrom(InputStream param1InputStream) throws IOException {
      return (AnalyticsUserPropertyCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static AnalyticsUserPropertyCondition parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (AnalyticsUserPropertyCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static AnalyticsUserPropertyCondition parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (AnalyticsUserPropertyCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static AnalyticsUserPropertyCondition parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (AnalyticsUserPropertyCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<AnalyticsUserPropertyCondition> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setOperator(UserPropertyOperator param1UserPropertyOperator) {
      if (param1UserPropertyOperator != null) {
        this.operator_ = param1UserPropertyOperator.getNumber();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setOperatorValue(int param1Int) {
      this.operator_ = param1Int;
    }
    
    private void setTargetUserPropertyEntityId(long param1Long) {
      this.targetUserPropertyEntityId_ = param1Long;
    }
    
    private void setTargetUserPropertyName(String param1String) {
      if (param1String != null) {
        this.targetUserPropertyName_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTargetUserPropertyNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.targetUserPropertyName_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTargetUserPropertyValue(String param1String) {
      if (param1String != null) {
        this.targetUserPropertyValue_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTargetUserPropertyValueBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.targetUserPropertyValue_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTargetUserPropertyValues(int param1Int, String param1String) {
      if (param1String != null) {
        ensureTargetUserPropertyValuesIsMutable();
        this.targetUserPropertyValues_.set(param1Int, param1String);
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/developers/mobile/targeting/proto/Conditions$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: istore #4
      //   10: iconst_0
      //   11: istore #5
      //   13: iconst_0
      //   14: istore #6
      //   16: iload #4
      //   18: tableswitch default -> 64, 1 -> 604, 2 -> 600, 3 -> 589, 4 -> 580, 5 -> 340, 6 -> 118, 7 -> 336, 8 -> 72
      //   64: new java/lang/UnsupportedOperationException
      //   67: dup
      //   68: invokespecial <init> : ()V
      //   71: athrow
      //   72: getstatic com/google/developers/mobile/targeting/proto/Conditions$AnalyticsUserPropertyCondition.PARSER : Lcom/google/protobuf/Parser;
      //   75: ifnonnull -> 114
      //   78: ldc com/google/developers/mobile/targeting/proto/Conditions$AnalyticsUserPropertyCondition
      //   80: monitorenter
      //   81: getstatic com/google/developers/mobile/targeting/proto/Conditions$AnalyticsUserPropertyCondition.PARSER : Lcom/google/protobuf/Parser;
      //   84: ifnonnull -> 102
      //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   90: astore_1
      //   91: aload_1
      //   92: getstatic com/google/developers/mobile/targeting/proto/Conditions$AnalyticsUserPropertyCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$AnalyticsUserPropertyCondition;
      //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   98: aload_1
      //   99: putstatic com/google/developers/mobile/targeting/proto/Conditions$AnalyticsUserPropertyCondition.PARSER : Lcom/google/protobuf/Parser;
      //   102: ldc com/google/developers/mobile/targeting/proto/Conditions$AnalyticsUserPropertyCondition
      //   104: monitorexit
      //   105: goto -> 114
      //   108: astore_1
      //   109: ldc com/google/developers/mobile/targeting/proto/Conditions$AnalyticsUserPropertyCondition
      //   111: monitorexit
      //   112: aload_1
      //   113: athrow
      //   114: getstatic com/google/developers/mobile/targeting/proto/Conditions$AnalyticsUserPropertyCondition.PARSER : Lcom/google/protobuf/Parser;
      //   117: areturn
      //   118: aload_2
      //   119: checkcast com/google/protobuf/CodedInputStream
      //   122: astore_1
      //   123: aload_3
      //   124: checkcast com/google/protobuf/ExtensionRegistryLite
      //   127: astore_2
      //   128: iload #6
      //   130: ifne -> 336
      //   133: aload_1
      //   134: invokevirtual readTag : ()I
      //   137: istore #4
      //   139: iload #4
      //   141: ifeq -> 280
      //   144: iload #4
      //   146: bipush #8
      //   148: if_icmpeq -> 269
      //   151: iload #4
      //   153: bipush #18
      //   155: if_icmpeq -> 258
      //   158: iload #4
      //   160: bipush #26
      //   162: if_icmpeq -> 247
      //   165: iload #4
      //   167: bipush #32
      //   169: if_icmpeq -> 236
      //   172: iload #4
      //   174: bipush #42
      //   176: if_icmpeq -> 194
      //   179: aload_1
      //   180: iload #4
      //   182: invokevirtual skipField : (I)Z
      //   185: ifne -> 128
      //   188: iconst_1
      //   189: istore #6
      //   191: goto -> 128
      //   194: aload_1
      //   195: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   198: astore_2
      //   199: aload_0
      //   200: getfield targetUserPropertyValues_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   203: invokeinterface isModifiable : ()Z
      //   208: ifne -> 222
      //   211: aload_0
      //   212: aload_0
      //   213: getfield targetUserPropertyValues_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   216: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   219: putfield targetUserPropertyValues_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   222: aload_0
      //   223: getfield targetUserPropertyValues_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   226: aload_2
      //   227: invokeinterface add : (Ljava/lang/Object;)Z
      //   232: pop
      //   233: goto -> 128
      //   236: aload_0
      //   237: aload_1
      //   238: invokevirtual readInt64 : ()J
      //   241: putfield targetUserPropertyEntityId_ : J
      //   244: goto -> 128
      //   247: aload_0
      //   248: aload_1
      //   249: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   252: putfield targetUserPropertyName_ : Ljava/lang/String;
      //   255: goto -> 128
      //   258: aload_0
      //   259: aload_1
      //   260: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   263: putfield targetUserPropertyValue_ : Ljava/lang/String;
      //   266: goto -> 128
      //   269: aload_0
      //   270: aload_1
      //   271: invokevirtual readEnum : ()I
      //   274: putfield operator_ : I
      //   277: goto -> 128
      //   280: iconst_1
      //   281: istore #6
      //   283: goto -> 128
      //   286: astore_1
      //   287: goto -> 334
      //   290: astore_1
      //   291: new java/lang/RuntimeException
      //   294: astore_3
      //   295: new com/google/protobuf/InvalidProtocolBufferException
      //   298: astore_2
      //   299: aload_2
      //   300: aload_1
      //   301: invokevirtual getMessage : ()Ljava/lang/String;
      //   304: invokespecial <init> : (Ljava/lang/String;)V
      //   307: aload_3
      //   308: aload_2
      //   309: aload_0
      //   310: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   313: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   316: aload_3
      //   317: athrow
      //   318: astore_1
      //   319: new java/lang/RuntimeException
      //   322: astore_2
      //   323: aload_2
      //   324: aload_1
      //   325: aload_0
      //   326: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   329: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   332: aload_2
      //   333: athrow
      //   334: aload_1
      //   335: athrow
      //   336: getstatic com/google/developers/mobile/targeting/proto/Conditions$AnalyticsUserPropertyCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$AnalyticsUserPropertyCondition;
      //   339: areturn
      //   340: aload_2
      //   341: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   344: astore_1
      //   345: aload_3
      //   346: checkcast com/google/developers/mobile/targeting/proto/Conditions$AnalyticsUserPropertyCondition
      //   349: astore_2
      //   350: aload_0
      //   351: getfield operator_ : I
      //   354: ifeq -> 363
      //   357: iconst_1
      //   358: istore #7
      //   360: goto -> 366
      //   363: iconst_0
      //   364: istore #7
      //   366: aload_0
      //   367: getfield operator_ : I
      //   370: istore #6
      //   372: aload_2
      //   373: getfield operator_ : I
      //   376: ifeq -> 385
      //   379: iconst_1
      //   380: istore #8
      //   382: goto -> 388
      //   385: iconst_0
      //   386: istore #8
      //   388: aload_0
      //   389: aload_1
      //   390: iload #7
      //   392: iload #6
      //   394: iload #8
      //   396: aload_2
      //   397: getfield operator_ : I
      //   400: invokeinterface visitInt : (ZIZI)I
      //   405: putfield operator_ : I
      //   408: aload_0
      //   409: aload_1
      //   410: aload_0
      //   411: getfield targetUserPropertyName_ : Ljava/lang/String;
      //   414: invokevirtual isEmpty : ()Z
      //   417: iconst_1
      //   418: ixor
      //   419: aload_0
      //   420: getfield targetUserPropertyName_ : Ljava/lang/String;
      //   423: aload_2
      //   424: getfield targetUserPropertyName_ : Ljava/lang/String;
      //   427: invokevirtual isEmpty : ()Z
      //   430: iconst_1
      //   431: ixor
      //   432: aload_2
      //   433: getfield targetUserPropertyName_ : Ljava/lang/String;
      //   436: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   441: putfield targetUserPropertyName_ : Ljava/lang/String;
      //   444: aload_0
      //   445: getfield targetUserPropertyEntityId_ : J
      //   448: lconst_0
      //   449: lcmp
      //   450: ifeq -> 459
      //   453: iconst_1
      //   454: istore #7
      //   456: goto -> 462
      //   459: iconst_0
      //   460: istore #7
      //   462: aload_0
      //   463: getfield targetUserPropertyEntityId_ : J
      //   466: lstore #9
      //   468: iload #5
      //   470: istore #8
      //   472: aload_2
      //   473: getfield targetUserPropertyEntityId_ : J
      //   476: lconst_0
      //   477: lcmp
      //   478: ifeq -> 484
      //   481: iconst_1
      //   482: istore #8
      //   484: aload_0
      //   485: aload_1
      //   486: iload #7
      //   488: lload #9
      //   490: iload #8
      //   492: aload_2
      //   493: getfield targetUserPropertyEntityId_ : J
      //   496: invokeinterface visitLong : (ZJZJ)J
      //   501: putfield targetUserPropertyEntityId_ : J
      //   504: aload_0
      //   505: aload_1
      //   506: aload_0
      //   507: getfield targetUserPropertyValue_ : Ljava/lang/String;
      //   510: invokevirtual isEmpty : ()Z
      //   513: iconst_1
      //   514: ixor
      //   515: aload_0
      //   516: getfield targetUserPropertyValue_ : Ljava/lang/String;
      //   519: aload_2
      //   520: getfield targetUserPropertyValue_ : Ljava/lang/String;
      //   523: invokevirtual isEmpty : ()Z
      //   526: iconst_1
      //   527: ixor
      //   528: aload_2
      //   529: getfield targetUserPropertyValue_ : Ljava/lang/String;
      //   532: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   537: putfield targetUserPropertyValue_ : Ljava/lang/String;
      //   540: aload_0
      //   541: aload_1
      //   542: aload_0
      //   543: getfield targetUserPropertyValues_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   546: aload_2
      //   547: getfield targetUserPropertyValues_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   550: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   555: putfield targetUserPropertyValues_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   558: aload_1
      //   559: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   562: if_acmpne -> 578
      //   565: aload_0
      //   566: aload_0
      //   567: getfield bitField0_ : I
      //   570: aload_2
      //   571: getfield bitField0_ : I
      //   574: ior
      //   575: putfield bitField0_ : I
      //   578: aload_0
      //   579: areturn
      //   580: new com/google/developers/mobile/targeting/proto/Conditions$AnalyticsUserPropertyCondition$Builder
      //   583: dup
      //   584: aconst_null
      //   585: invokespecial <init> : (Lcom/google/developers/mobile/targeting/proto/Conditions$1;)V
      //   588: areturn
      //   589: aload_0
      //   590: getfield targetUserPropertyValues_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   593: invokeinterface makeImmutable : ()V
      //   598: aconst_null
      //   599: areturn
      //   600: getstatic com/google/developers/mobile/targeting/proto/Conditions$AnalyticsUserPropertyCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$AnalyticsUserPropertyCondition;
      //   603: areturn
      //   604: new com/google/developers/mobile/targeting/proto/Conditions$AnalyticsUserPropertyCondition
      //   607: dup
      //   608: invokespecial <init> : ()V
      //   611: areturn
      // Exception table:
      //   from	to	target	type
      //   81	102	108	finally
      //   102	105	108	finally
      //   109	112	108	finally
      //   133	139	318	com/google/protobuf/InvalidProtocolBufferException
      //   133	139	290	java/io/IOException
      //   133	139	286	finally
      //   179	188	318	com/google/protobuf/InvalidProtocolBufferException
      //   179	188	290	java/io/IOException
      //   179	188	286	finally
      //   194	222	318	com/google/protobuf/InvalidProtocolBufferException
      //   194	222	290	java/io/IOException
      //   194	222	286	finally
      //   222	233	318	com/google/protobuf/InvalidProtocolBufferException
      //   222	233	290	java/io/IOException
      //   222	233	286	finally
      //   236	244	318	com/google/protobuf/InvalidProtocolBufferException
      //   236	244	290	java/io/IOException
      //   236	244	286	finally
      //   247	255	318	com/google/protobuf/InvalidProtocolBufferException
      //   247	255	290	java/io/IOException
      //   247	255	286	finally
      //   258	266	318	com/google/protobuf/InvalidProtocolBufferException
      //   258	266	290	java/io/IOException
      //   258	266	286	finally
      //   269	277	318	com/google/protobuf/InvalidProtocolBufferException
      //   269	277	290	java/io/IOException
      //   269	277	286	finally
      //   291	318	286	finally
      //   319	334	286	finally
    }
    
    public UserPropertyOperator getOperator() {
      UserPropertyOperator userPropertyOperator1 = UserPropertyOperator.forNumber(this.operator_);
      UserPropertyOperator userPropertyOperator2 = userPropertyOperator1;
      if (userPropertyOperator1 == null)
        userPropertyOperator2 = UserPropertyOperator.UNRECOGNIZED; 
      return userPropertyOperator2;
    }
    
    public int getOperatorValue() {
      return this.operator_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = this.operator_;
      int j = UserPropertyOperator.UNKNOWN.getNumber();
      int k = 0;
      if (i != j) {
        j = CodedOutputStream.computeEnumSize(1, this.operator_) + 0;
      } else {
        j = 0;
      } 
      i = j;
      if (!this.targetUserPropertyValue_.isEmpty())
        i = j + CodedOutputStream.computeStringSize(2, getTargetUserPropertyValue()); 
      j = i;
      if (!this.targetUserPropertyName_.isEmpty())
        j = i + CodedOutputStream.computeStringSize(3, getTargetUserPropertyName()); 
      long l = this.targetUserPropertyEntityId_;
      i = j;
      if (l != 0L)
        i = j + CodedOutputStream.computeInt64Size(4, l); 
      byte b = 0;
      j = k;
      k = b;
      while (j < this.targetUserPropertyValues_.size()) {
        k += CodedOutputStream.computeStringSizeNoTag((String)this.targetUserPropertyValues_.get(j));
        j++;
      } 
      i = i + k + getTargetUserPropertyValuesList().size() * 1;
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public long getTargetUserPropertyEntityId() {
      return this.targetUserPropertyEntityId_;
    }
    
    public String getTargetUserPropertyName() {
      return this.targetUserPropertyName_;
    }
    
    public ByteString getTargetUserPropertyNameBytes() {
      return ByteString.copyFromUtf8(this.targetUserPropertyName_);
    }
    
    @Deprecated
    public String getTargetUserPropertyValue() {
      return this.targetUserPropertyValue_;
    }
    
    @Deprecated
    public ByteString getTargetUserPropertyValueBytes() {
      return ByteString.copyFromUtf8(this.targetUserPropertyValue_);
    }
    
    public String getTargetUserPropertyValues(int param1Int) {
      return (String)this.targetUserPropertyValues_.get(param1Int);
    }
    
    public ByteString getTargetUserPropertyValuesBytes(int param1Int) {
      return ByteString.copyFromUtf8((String)this.targetUserPropertyValues_.get(param1Int));
    }
    
    public int getTargetUserPropertyValuesCount() {
      return this.targetUserPropertyValues_.size();
    }
    
    public List<String> getTargetUserPropertyValuesList() {
      return (List<String>)this.targetUserPropertyValues_;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.operator_ != UserPropertyOperator.UNKNOWN.getNumber())
        param1CodedOutputStream.writeEnum(1, this.operator_); 
      if (!this.targetUserPropertyValue_.isEmpty())
        param1CodedOutputStream.writeString(2, getTargetUserPropertyValue()); 
      if (!this.targetUserPropertyName_.isEmpty())
        param1CodedOutputStream.writeString(3, getTargetUserPropertyName()); 
      long l = this.targetUserPropertyEntityId_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(4, l); 
      for (byte b = 0; b < this.targetUserPropertyValues_.size(); b++)
        param1CodedOutputStream.writeString(5, (String)this.targetUserPropertyValues_.get(b)); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AnalyticsUserPropertyCondition, Builder> implements Conditions.AnalyticsUserPropertyConditionOrBuilder {
      private Builder() {
        super(Conditions.AnalyticsUserPropertyCondition.DEFAULT_INSTANCE);
      }
      
      public Builder addAllTargetUserPropertyValues(Iterable<String> param2Iterable) {
        copyOnWrite();
        ((Conditions.AnalyticsUserPropertyCondition)this.instance).addAllTargetUserPropertyValues(param2Iterable);
        return this;
      }
      
      public Builder addTargetUserPropertyValues(String param2String) {
        copyOnWrite();
        ((Conditions.AnalyticsUserPropertyCondition)this.instance).addTargetUserPropertyValues(param2String);
        return this;
      }
      
      public Builder addTargetUserPropertyValuesBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((Conditions.AnalyticsUserPropertyCondition)this.instance).addTargetUserPropertyValuesBytes(param2ByteString);
        return this;
      }
      
      public Builder clearOperator() {
        copyOnWrite();
        ((Conditions.AnalyticsUserPropertyCondition)this.instance).clearOperator();
        return this;
      }
      
      public Builder clearTargetUserPropertyEntityId() {
        copyOnWrite();
        ((Conditions.AnalyticsUserPropertyCondition)this.instance).clearTargetUserPropertyEntityId();
        return this;
      }
      
      public Builder clearTargetUserPropertyName() {
        copyOnWrite();
        ((Conditions.AnalyticsUserPropertyCondition)this.instance).clearTargetUserPropertyName();
        return this;
      }
      
      @Deprecated
      public Builder clearTargetUserPropertyValue() {
        copyOnWrite();
        ((Conditions.AnalyticsUserPropertyCondition)this.instance).clearTargetUserPropertyValue();
        return this;
      }
      
      public Builder clearTargetUserPropertyValues() {
        copyOnWrite();
        ((Conditions.AnalyticsUserPropertyCondition)this.instance).clearTargetUserPropertyValues();
        return this;
      }
      
      public Conditions.AnalyticsUserPropertyCondition.UserPropertyOperator getOperator() {
        return ((Conditions.AnalyticsUserPropertyCondition)this.instance).getOperator();
      }
      
      public int getOperatorValue() {
        return ((Conditions.AnalyticsUserPropertyCondition)this.instance).getOperatorValue();
      }
      
      public long getTargetUserPropertyEntityId() {
        return ((Conditions.AnalyticsUserPropertyCondition)this.instance).getTargetUserPropertyEntityId();
      }
      
      public String getTargetUserPropertyName() {
        return ((Conditions.AnalyticsUserPropertyCondition)this.instance).getTargetUserPropertyName();
      }
      
      public ByteString getTargetUserPropertyNameBytes() {
        return ((Conditions.AnalyticsUserPropertyCondition)this.instance).getTargetUserPropertyNameBytes();
      }
      
      @Deprecated
      public String getTargetUserPropertyValue() {
        return ((Conditions.AnalyticsUserPropertyCondition)this.instance).getTargetUserPropertyValue();
      }
      
      @Deprecated
      public ByteString getTargetUserPropertyValueBytes() {
        return ((Conditions.AnalyticsUserPropertyCondition)this.instance).getTargetUserPropertyValueBytes();
      }
      
      public String getTargetUserPropertyValues(int param2Int) {
        return ((Conditions.AnalyticsUserPropertyCondition)this.instance).getTargetUserPropertyValues(param2Int);
      }
      
      public ByteString getTargetUserPropertyValuesBytes(int param2Int) {
        return ((Conditions.AnalyticsUserPropertyCondition)this.instance).getTargetUserPropertyValuesBytes(param2Int);
      }
      
      public int getTargetUserPropertyValuesCount() {
        return ((Conditions.AnalyticsUserPropertyCondition)this.instance).getTargetUserPropertyValuesCount();
      }
      
      public List<String> getTargetUserPropertyValuesList() {
        return Collections.unmodifiableList(((Conditions.AnalyticsUserPropertyCondition)this.instance).getTargetUserPropertyValuesList());
      }
      
      public Builder setOperator(Conditions.AnalyticsUserPropertyCondition.UserPropertyOperator param2UserPropertyOperator) {
        copyOnWrite();
        ((Conditions.AnalyticsUserPropertyCondition)this.instance).setOperator(param2UserPropertyOperator);
        return this;
      }
      
      public Builder setOperatorValue(int param2Int) {
        copyOnWrite();
        ((Conditions.AnalyticsUserPropertyCondition)this.instance).setOperatorValue(param2Int);
        return this;
      }
      
      public Builder setTargetUserPropertyEntityId(long param2Long) {
        copyOnWrite();
        ((Conditions.AnalyticsUserPropertyCondition)this.instance).setTargetUserPropertyEntityId(param2Long);
        return this;
      }
      
      public Builder setTargetUserPropertyName(String param2String) {
        copyOnWrite();
        ((Conditions.AnalyticsUserPropertyCondition)this.instance).setTargetUserPropertyName(param2String);
        return this;
      }
      
      public Builder setTargetUserPropertyNameBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((Conditions.AnalyticsUserPropertyCondition)this.instance).setTargetUserPropertyNameBytes(param2ByteString);
        return this;
      }
      
      @Deprecated
      public Builder setTargetUserPropertyValue(String param2String) {
        copyOnWrite();
        ((Conditions.AnalyticsUserPropertyCondition)this.instance).setTargetUserPropertyValue(param2String);
        return this;
      }
      
      @Deprecated
      public Builder setTargetUserPropertyValueBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((Conditions.AnalyticsUserPropertyCondition)this.instance).setTargetUserPropertyValueBytes(param2ByteString);
        return this;
      }
      
      public Builder setTargetUserPropertyValues(int param2Int, String param2String) {
        copyOnWrite();
        ((Conditions.AnalyticsUserPropertyCondition)this.instance).setTargetUserPropertyValues(param2Int, param2String);
        return this;
      }
    }
    
    public enum UserPropertyOperator implements Internal.EnumLite {
      NUMERIC_EQUAL(0),
      NUMERIC_GREATER_EQUAL(0),
      NUMERIC_GREATER_THAN(0),
      NUMERIC_LESS_EQUAL(0),
      NUMERIC_LESS_THAN(0),
      NUMERIC_NOT_EQUAL(0),
      STRING_CONTAINS(0),
      STRING_CONTAINS_REGEX(0),
      STRING_DOES_NOT_CONTAIN(0),
      STRING_EXACTLY_MATCHES(0),
      UNKNOWN(0),
      UNRECOGNIZED(0);
      
      public static final int NUMERIC_EQUAL_VALUE = 3;
      
      public static final int NUMERIC_GREATER_EQUAL_VALUE = 5;
      
      public static final int NUMERIC_GREATER_THAN_VALUE = 4;
      
      public static final int NUMERIC_LESS_EQUAL_VALUE = 2;
      
      public static final int NUMERIC_LESS_THAN_VALUE = 1;
      
      public static final int NUMERIC_NOT_EQUAL_VALUE = 10;
      
      public static final int STRING_CONTAINS_REGEX_VALUE = 9;
      
      public static final int STRING_CONTAINS_VALUE = 6;
      
      public static final int STRING_DOES_NOT_CONTAIN_VALUE = 7;
      
      public static final int STRING_EXACTLY_MATCHES_VALUE = 8;
      
      public static final int UNKNOWN_VALUE = 0;
      
      private static final Internal.EnumLiteMap<UserPropertyOperator> internalValueMap;
      
      private final int value;
      
      static {
        NUMERIC_EQUAL = new UserPropertyOperator("NUMERIC_EQUAL", 3, 3);
        NUMERIC_NOT_EQUAL = new UserPropertyOperator("NUMERIC_NOT_EQUAL", 4, 10);
        NUMERIC_GREATER_THAN = new UserPropertyOperator("NUMERIC_GREATER_THAN", 5, 4);
        NUMERIC_GREATER_EQUAL = new UserPropertyOperator("NUMERIC_GREATER_EQUAL", 6, 5);
        STRING_CONTAINS = new UserPropertyOperator("STRING_CONTAINS", 7, 6);
        STRING_DOES_NOT_CONTAIN = new UserPropertyOperator("STRING_DOES_NOT_CONTAIN", 8, 7);
        STRING_EXACTLY_MATCHES = new UserPropertyOperator("STRING_EXACTLY_MATCHES", 9, 8);
        STRING_CONTAINS_REGEX = new UserPropertyOperator("STRING_CONTAINS_REGEX", 10, 9);
        UNRECOGNIZED = new UserPropertyOperator("UNRECOGNIZED", 11, -1);
        $VALUES = new UserPropertyOperator[] { 
            UNKNOWN, NUMERIC_LESS_THAN, NUMERIC_LESS_EQUAL, NUMERIC_EQUAL, NUMERIC_NOT_EQUAL, NUMERIC_GREATER_THAN, NUMERIC_GREATER_EQUAL, STRING_CONTAINS, STRING_DOES_NOT_CONTAIN, STRING_EXACTLY_MATCHES, 
            STRING_CONTAINS_REGEX, UNRECOGNIZED };
        internalValueMap = new Internal.EnumLiteMap<UserPropertyOperator>() {
            public Conditions.AnalyticsUserPropertyCondition.UserPropertyOperator findValueByNumber(int param3Int) {
              return Conditions.AnalyticsUserPropertyCondition.UserPropertyOperator.forNumber(param3Int);
            }
          };
      }
      
      UserPropertyOperator(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static UserPropertyOperator forNumber(int param2Int) {
        switch (param2Int) {
          default:
            return null;
          case 10:
            return NUMERIC_NOT_EQUAL;
          case 9:
            return STRING_CONTAINS_REGEX;
          case 8:
            return STRING_EXACTLY_MATCHES;
          case 7:
            return STRING_DOES_NOT_CONTAIN;
          case 6:
            return STRING_CONTAINS;
          case 5:
            return NUMERIC_GREATER_EQUAL;
          case 4:
            return NUMERIC_GREATER_THAN;
          case 3:
            return NUMERIC_EQUAL;
          case 2:
            return NUMERIC_LESS_EQUAL;
          case 1:
            return NUMERIC_LESS_THAN;
          case 0:
            break;
        } 
        return UNKNOWN;
      }
      
      public static Internal.EnumLiteMap<UserPropertyOperator> internalGetValueMap() {
        return internalValueMap;
      }
      
      public final int getNumber() {
        return this.value;
      }
    }
    
    class null implements Internal.EnumLiteMap<UserPropertyOperator> {
      public Conditions.AnalyticsUserPropertyCondition.UserPropertyOperator findValueByNumber(int param2Int) {
        return Conditions.AnalyticsUserPropertyCondition.UserPropertyOperator.forNumber(param2Int);
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<AnalyticsUserPropertyCondition, AnalyticsUserPropertyCondition.Builder> implements AnalyticsUserPropertyConditionOrBuilder {
    private Builder() {
      super(Conditions.AnalyticsUserPropertyCondition.DEFAULT_INSTANCE);
    }
    
    public Builder addAllTargetUserPropertyValues(Iterable<String> param1Iterable) {
      copyOnWrite();
      ((Conditions.AnalyticsUserPropertyCondition)this.instance).addAllTargetUserPropertyValues(param1Iterable);
      return this;
    }
    
    public Builder addTargetUserPropertyValues(String param1String) {
      copyOnWrite();
      ((Conditions.AnalyticsUserPropertyCondition)this.instance).addTargetUserPropertyValues(param1String);
      return this;
    }
    
    public Builder addTargetUserPropertyValuesBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Conditions.AnalyticsUserPropertyCondition)this.instance).addTargetUserPropertyValuesBytes(param1ByteString);
      return this;
    }
    
    public Builder clearOperator() {
      copyOnWrite();
      ((Conditions.AnalyticsUserPropertyCondition)this.instance).clearOperator();
      return this;
    }
    
    public Builder clearTargetUserPropertyEntityId() {
      copyOnWrite();
      ((Conditions.AnalyticsUserPropertyCondition)this.instance).clearTargetUserPropertyEntityId();
      return this;
    }
    
    public Builder clearTargetUserPropertyName() {
      copyOnWrite();
      ((Conditions.AnalyticsUserPropertyCondition)this.instance).clearTargetUserPropertyName();
      return this;
    }
    
    @Deprecated
    public Builder clearTargetUserPropertyValue() {
      copyOnWrite();
      ((Conditions.AnalyticsUserPropertyCondition)this.instance).clearTargetUserPropertyValue();
      return this;
    }
    
    public Builder clearTargetUserPropertyValues() {
      copyOnWrite();
      ((Conditions.AnalyticsUserPropertyCondition)this.instance).clearTargetUserPropertyValues();
      return this;
    }
    
    public Conditions.AnalyticsUserPropertyCondition.UserPropertyOperator getOperator() {
      return ((Conditions.AnalyticsUserPropertyCondition)this.instance).getOperator();
    }
    
    public int getOperatorValue() {
      return ((Conditions.AnalyticsUserPropertyCondition)this.instance).getOperatorValue();
    }
    
    public long getTargetUserPropertyEntityId() {
      return ((Conditions.AnalyticsUserPropertyCondition)this.instance).getTargetUserPropertyEntityId();
    }
    
    public String getTargetUserPropertyName() {
      return ((Conditions.AnalyticsUserPropertyCondition)this.instance).getTargetUserPropertyName();
    }
    
    public ByteString getTargetUserPropertyNameBytes() {
      return ((Conditions.AnalyticsUserPropertyCondition)this.instance).getTargetUserPropertyNameBytes();
    }
    
    @Deprecated
    public String getTargetUserPropertyValue() {
      return ((Conditions.AnalyticsUserPropertyCondition)this.instance).getTargetUserPropertyValue();
    }
    
    @Deprecated
    public ByteString getTargetUserPropertyValueBytes() {
      return ((Conditions.AnalyticsUserPropertyCondition)this.instance).getTargetUserPropertyValueBytes();
    }
    
    public String getTargetUserPropertyValues(int param1Int) {
      return ((Conditions.AnalyticsUserPropertyCondition)this.instance).getTargetUserPropertyValues(param1Int);
    }
    
    public ByteString getTargetUserPropertyValuesBytes(int param1Int) {
      return ((Conditions.AnalyticsUserPropertyCondition)this.instance).getTargetUserPropertyValuesBytes(param1Int);
    }
    
    public int getTargetUserPropertyValuesCount() {
      return ((Conditions.AnalyticsUserPropertyCondition)this.instance).getTargetUserPropertyValuesCount();
    }
    
    public List<String> getTargetUserPropertyValuesList() {
      return Collections.unmodifiableList(((Conditions.AnalyticsUserPropertyCondition)this.instance).getTargetUserPropertyValuesList());
    }
    
    public Builder setOperator(Conditions.AnalyticsUserPropertyCondition.UserPropertyOperator param1UserPropertyOperator) {
      copyOnWrite();
      ((Conditions.AnalyticsUserPropertyCondition)this.instance).setOperator(param1UserPropertyOperator);
      return this;
    }
    
    public Builder setOperatorValue(int param1Int) {
      copyOnWrite();
      ((Conditions.AnalyticsUserPropertyCondition)this.instance).setOperatorValue(param1Int);
      return this;
    }
    
    public Builder setTargetUserPropertyEntityId(long param1Long) {
      copyOnWrite();
      ((Conditions.AnalyticsUserPropertyCondition)this.instance).setTargetUserPropertyEntityId(param1Long);
      return this;
    }
    
    public Builder setTargetUserPropertyName(String param1String) {
      copyOnWrite();
      ((Conditions.AnalyticsUserPropertyCondition)this.instance).setTargetUserPropertyName(param1String);
      return this;
    }
    
    public Builder setTargetUserPropertyNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Conditions.AnalyticsUserPropertyCondition)this.instance).setTargetUserPropertyNameBytes(param1ByteString);
      return this;
    }
    
    @Deprecated
    public Builder setTargetUserPropertyValue(String param1String) {
      copyOnWrite();
      ((Conditions.AnalyticsUserPropertyCondition)this.instance).setTargetUserPropertyValue(param1String);
      return this;
    }
    
    @Deprecated
    public Builder setTargetUserPropertyValueBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Conditions.AnalyticsUserPropertyCondition)this.instance).setTargetUserPropertyValueBytes(param1ByteString);
      return this;
    }
    
    public Builder setTargetUserPropertyValues(int param1Int, String param1String) {
      copyOnWrite();
      ((Conditions.AnalyticsUserPropertyCondition)this.instance).setTargetUserPropertyValues(param1Int, param1String);
      return this;
    }
  }
  
  public enum UserPropertyOperator implements Internal.EnumLite {
    NUMERIC_EQUAL(0),
    NUMERIC_GREATER_EQUAL(0),
    NUMERIC_GREATER_THAN(0),
    NUMERIC_LESS_EQUAL(0),
    NUMERIC_LESS_THAN(0),
    NUMERIC_NOT_EQUAL(0),
    STRING_CONTAINS(0),
    STRING_CONTAINS_REGEX(0),
    STRING_DOES_NOT_CONTAIN(0),
    STRING_EXACTLY_MATCHES(0),
    UNKNOWN(0),
    UNRECOGNIZED(0);
    
    public static final int NUMERIC_EQUAL_VALUE = 3;
    
    public static final int NUMERIC_GREATER_EQUAL_VALUE = 5;
    
    public static final int NUMERIC_GREATER_THAN_VALUE = 4;
    
    public static final int NUMERIC_LESS_EQUAL_VALUE = 2;
    
    public static final int NUMERIC_LESS_THAN_VALUE = 1;
    
    public static final int NUMERIC_NOT_EQUAL_VALUE = 10;
    
    public static final int STRING_CONTAINS_REGEX_VALUE = 9;
    
    public static final int STRING_CONTAINS_VALUE = 6;
    
    public static final int STRING_DOES_NOT_CONTAIN_VALUE = 7;
    
    public static final int STRING_EXACTLY_MATCHES_VALUE = 8;
    
    public static final int UNKNOWN_VALUE = 0;
    
    private static final Internal.EnumLiteMap<UserPropertyOperator> internalValueMap;
    
    private final int value;
    
    static {
      NUMERIC_LESS_EQUAL = new UserPropertyOperator("NUMERIC_LESS_EQUAL", 2, 2);
      NUMERIC_EQUAL = new UserPropertyOperator("NUMERIC_EQUAL", 3, 3);
      NUMERIC_NOT_EQUAL = new UserPropertyOperator("NUMERIC_NOT_EQUAL", 4, 10);
      NUMERIC_GREATER_THAN = new UserPropertyOperator("NUMERIC_GREATER_THAN", 5, 4);
      NUMERIC_GREATER_EQUAL = new UserPropertyOperator("NUMERIC_GREATER_EQUAL", 6, 5);
      STRING_CONTAINS = new UserPropertyOperator("STRING_CONTAINS", 7, 6);
      STRING_DOES_NOT_CONTAIN = new UserPropertyOperator("STRING_DOES_NOT_CONTAIN", 8, 7);
      STRING_EXACTLY_MATCHES = new UserPropertyOperator("STRING_EXACTLY_MATCHES", 9, 8);
      STRING_CONTAINS_REGEX = new UserPropertyOperator("STRING_CONTAINS_REGEX", 10, 9);
      UNRECOGNIZED = new UserPropertyOperator("UNRECOGNIZED", 11, -1);
      $VALUES = new UserPropertyOperator[] { 
          UNKNOWN, NUMERIC_LESS_THAN, NUMERIC_LESS_EQUAL, NUMERIC_EQUAL, NUMERIC_NOT_EQUAL, NUMERIC_GREATER_THAN, NUMERIC_GREATER_EQUAL, STRING_CONTAINS, STRING_DOES_NOT_CONTAIN, STRING_EXACTLY_MATCHES, 
          STRING_CONTAINS_REGEX, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<UserPropertyOperator>() {
          public Conditions.AnalyticsUserPropertyCondition.UserPropertyOperator findValueByNumber(int param3Int) {
            return Conditions.AnalyticsUserPropertyCondition.UserPropertyOperator.forNumber(param3Int);
          }
        };
    }
    
    UserPropertyOperator(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static UserPropertyOperator forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 10:
          return NUMERIC_NOT_EQUAL;
        case 9:
          return STRING_CONTAINS_REGEX;
        case 8:
          return STRING_EXACTLY_MATCHES;
        case 7:
          return STRING_DOES_NOT_CONTAIN;
        case 6:
          return STRING_CONTAINS;
        case 5:
          return NUMERIC_GREATER_EQUAL;
        case 4:
          return NUMERIC_GREATER_THAN;
        case 3:
          return NUMERIC_EQUAL;
        case 2:
          return NUMERIC_LESS_EQUAL;
        case 1:
          return NUMERIC_LESS_THAN;
        case 0:
          break;
      } 
      return UNKNOWN;
    }
    
    public static Internal.EnumLiteMap<UserPropertyOperator> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<AnalyticsUserPropertyCondition.UserPropertyOperator> {
    public Conditions.AnalyticsUserPropertyCondition.UserPropertyOperator findValueByNumber(int param1Int) {
      return Conditions.AnalyticsUserPropertyCondition.UserPropertyOperator.forNumber(param1Int);
    }
  }
  
  public static interface AnalyticsUserPropertyConditionOrBuilder extends MessageLiteOrBuilder {
    Conditions.AnalyticsUserPropertyCondition.UserPropertyOperator getOperator();
    
    int getOperatorValue();
    
    long getTargetUserPropertyEntityId();
    
    String getTargetUserPropertyName();
    
    ByteString getTargetUserPropertyNameBytes();
    
    @Deprecated
    String getTargetUserPropertyValue();
    
    @Deprecated
    ByteString getTargetUserPropertyValueBytes();
    
    String getTargetUserPropertyValues(int param1Int);
    
    ByteString getTargetUserPropertyValuesBytes(int param1Int);
    
    int getTargetUserPropertyValuesCount();
    
    List<String> getTargetUserPropertyValuesList();
  }
  
  public static final class AndCondition extends GeneratedMessageLite<AndCondition, AndCondition.Builder> implements AndConditionOrBuilder {
    public static final int CONDITIONS_FIELD_NUMBER = 1;
    
    private static final AndCondition DEFAULT_INSTANCE = new AndCondition();
    
    private static volatile Parser<AndCondition> PARSER;
    
    private Internal.ProtobufList<Conditions.Condition> conditions_ = emptyProtobufList();
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllConditions(Iterable<? extends Conditions.Condition> param1Iterable) {
      ensureConditionsIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.conditions_);
    }
    
    private void addConditions(int param1Int, Conditions.Condition.Builder param1Builder) {
      ensureConditionsIsMutable();
      this.conditions_.add(param1Int, param1Builder.build());
    }
    
    private void addConditions(int param1Int, Conditions.Condition param1Condition) {
      if (param1Condition != null) {
        ensureConditionsIsMutable();
        this.conditions_.add(param1Int, param1Condition);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addConditions(Conditions.Condition.Builder param1Builder) {
      ensureConditionsIsMutable();
      this.conditions_.add(param1Builder.build());
    }
    
    private void addConditions(Conditions.Condition param1Condition) {
      if (param1Condition != null) {
        ensureConditionsIsMutable();
        this.conditions_.add(param1Condition);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearConditions() {
      this.conditions_ = emptyProtobufList();
    }
    
    private void ensureConditionsIsMutable() {
      if (!this.conditions_.isModifiable())
        this.conditions_ = GeneratedMessageLite.mutableCopy(this.conditions_); 
    }
    
    public static AndCondition getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(AndCondition param1AndCondition) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1AndCondition);
    }
    
    public static AndCondition parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (AndCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static AndCondition parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (AndCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static AndCondition parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (AndCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static AndCondition parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (AndCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static AndCondition parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (AndCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static AndCondition parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (AndCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static AndCondition parseFrom(InputStream param1InputStream) throws IOException {
      return (AndCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static AndCondition parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (AndCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static AndCondition parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (AndCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static AndCondition parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (AndCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<AndCondition> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeConditions(int param1Int) {
      ensureConditionsIsMutable();
      this.conditions_.remove(param1Int);
    }
    
    private void setConditions(int param1Int, Conditions.Condition.Builder param1Builder) {
      ensureConditionsIsMutable();
      this.conditions_.set(param1Int, param1Builder.build());
    }
    
    private void setConditions(int param1Int, Conditions.Condition param1Condition) {
      if (param1Condition != null) {
        ensureConditionsIsMutable();
        this.conditions_.set(param1Int, param1Condition);
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/developers/mobile/targeting/proto/Conditions$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 326, 2 -> 322, 3 -> 311, 4 -> 302, 5 -> 268, 6 -> 110, 7 -> 264, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/developers/mobile/targeting/proto/Conditions$AndCondition.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/developers/mobile/targeting/proto/Conditions$AndCondition
      //   72: monitorenter
      //   73: getstatic com/google/developers/mobile/targeting/proto/Conditions$AndCondition.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/developers/mobile/targeting/proto/Conditions$AndCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$AndCondition;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/developers/mobile/targeting/proto/Conditions$AndCondition.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/developers/mobile/targeting/proto/Conditions$AndCondition
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/developers/mobile/targeting/proto/Conditions$AndCondition
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/developers/mobile/targeting/proto/Conditions$AndCondition.PARSER : Lcom/google/protobuf/Parser;
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
      //   162: getfield conditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   165: invokeinterface isModifiable : ()Z
      //   170: ifne -> 184
      //   173: aload_0
      //   174: aload_0
      //   175: getfield conditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   178: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   181: putfield conditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   184: aload_0
      //   185: getfield conditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   188: aload_1
      //   189: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   192: aload_2
      //   193: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   196: checkcast com/google/developers/mobile/targeting/proto/Conditions$Condition
      //   199: invokeinterface add : (Ljava/lang/Object;)Z
      //   204: pop
      //   205: goto -> 123
      //   208: iconst_1
      //   209: istore #4
      //   211: goto -> 123
      //   214: astore_1
      //   215: goto -> 262
      //   218: astore_3
      //   219: new java/lang/RuntimeException
      //   222: astore_2
      //   223: new com/google/protobuf/InvalidProtocolBufferException
      //   226: astore_1
      //   227: aload_1
      //   228: aload_3
      //   229: invokevirtual getMessage : ()Ljava/lang/String;
      //   232: invokespecial <init> : (Ljava/lang/String;)V
      //   235: aload_2
      //   236: aload_1
      //   237: aload_0
      //   238: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   241: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   244: aload_2
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
      //   264: getstatic com/google/developers/mobile/targeting/proto/Conditions$AndCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$AndCondition;
      //   267: areturn
      //   268: aload_2
      //   269: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   272: astore_1
      //   273: aload_3
      //   274: checkcast com/google/developers/mobile/targeting/proto/Conditions$AndCondition
      //   277: astore_2
      //   278: aload_0
      //   279: aload_1
      //   280: aload_0
      //   281: getfield conditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   284: aload_2
      //   285: getfield conditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   288: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   293: putfield conditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   296: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   299: astore_1
      //   300: aload_0
      //   301: areturn
      //   302: new com/google/developers/mobile/targeting/proto/Conditions$AndCondition$Builder
      //   305: dup
      //   306: aconst_null
      //   307: invokespecial <init> : (Lcom/google/developers/mobile/targeting/proto/Conditions$1;)V
      //   310: areturn
      //   311: aload_0
      //   312: getfield conditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   315: invokeinterface makeImmutable : ()V
      //   320: aconst_null
      //   321: areturn
      //   322: getstatic com/google/developers/mobile/targeting/proto/Conditions$AndCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$AndCondition;
      //   325: areturn
      //   326: new com/google/developers/mobile/targeting/proto/Conditions$AndCondition
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
    
    public Conditions.Condition getConditions(int param1Int) {
      return (Conditions.Condition)this.conditions_.get(param1Int);
    }
    
    public int getConditionsCount() {
      return this.conditions_.size();
    }
    
    public List<Conditions.Condition> getConditionsList() {
      return (List<Conditions.Condition>)this.conditions_;
    }
    
    public Conditions.ConditionOrBuilder getConditionsOrBuilder(int param1Int) {
      return (Conditions.ConditionOrBuilder)this.conditions_.get(param1Int);
    }
    
    public List<? extends Conditions.ConditionOrBuilder> getConditionsOrBuilderList() {
      return (List)this.conditions_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      byte b = 0;
      i = 0;
      while (b < this.conditions_.size()) {
        i += CodedOutputStream.computeMessageSize(1, (MessageLite)this.conditions_.get(b));
        b++;
      } 
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      for (byte b = 0; b < this.conditions_.size(); b++)
        param1CodedOutputStream.writeMessage(1, (MessageLite)this.conditions_.get(b)); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AndCondition, Builder> implements Conditions.AndConditionOrBuilder {
      private Builder() {
        super(Conditions.AndCondition.DEFAULT_INSTANCE);
      }
      
      public Builder addAllConditions(Iterable<? extends Conditions.Condition> param2Iterable) {
        copyOnWrite();
        ((Conditions.AndCondition)this.instance).addAllConditions(param2Iterable);
        return this;
      }
      
      public Builder addConditions(int param2Int, Conditions.Condition.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.AndCondition)this.instance).addConditions(param2Int, param2Builder);
        return this;
      }
      
      public Builder addConditions(int param2Int, Conditions.Condition param2Condition) {
        copyOnWrite();
        ((Conditions.AndCondition)this.instance).addConditions(param2Int, param2Condition);
        return this;
      }
      
      public Builder addConditions(Conditions.Condition.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.AndCondition)this.instance).addConditions(param2Builder);
        return this;
      }
      
      public Builder addConditions(Conditions.Condition param2Condition) {
        copyOnWrite();
        ((Conditions.AndCondition)this.instance).addConditions(param2Condition);
        return this;
      }
      
      public Builder clearConditions() {
        copyOnWrite();
        ((Conditions.AndCondition)this.instance).clearConditions();
        return this;
      }
      
      public Conditions.Condition getConditions(int param2Int) {
        return ((Conditions.AndCondition)this.instance).getConditions(param2Int);
      }
      
      public int getConditionsCount() {
        return ((Conditions.AndCondition)this.instance).getConditionsCount();
      }
      
      public List<Conditions.Condition> getConditionsList() {
        return Collections.unmodifiableList(((Conditions.AndCondition)this.instance).getConditionsList());
      }
      
      public Builder removeConditions(int param2Int) {
        copyOnWrite();
        ((Conditions.AndCondition)this.instance).removeConditions(param2Int);
        return this;
      }
      
      public Builder setConditions(int param2Int, Conditions.Condition.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.AndCondition)this.instance).setConditions(param2Int, param2Builder);
        return this;
      }
      
      public Builder setConditions(int param2Int, Conditions.Condition param2Condition) {
        copyOnWrite();
        ((Conditions.AndCondition)this.instance).setConditions(param2Int, param2Condition);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<AndCondition, AndCondition.Builder> implements AndConditionOrBuilder {
    private Builder() {
      super(Conditions.AndCondition.DEFAULT_INSTANCE);
    }
    
    public Builder addAllConditions(Iterable<? extends Conditions.Condition> param1Iterable) {
      copyOnWrite();
      ((Conditions.AndCondition)this.instance).addAllConditions(param1Iterable);
      return this;
    }
    
    public Builder addConditions(int param1Int, Conditions.Condition.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.AndCondition)this.instance).addConditions(param1Int, param1Builder);
      return this;
    }
    
    public Builder addConditions(int param1Int, Conditions.Condition param1Condition) {
      copyOnWrite();
      ((Conditions.AndCondition)this.instance).addConditions(param1Int, param1Condition);
      return this;
    }
    
    public Builder addConditions(Conditions.Condition.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.AndCondition)this.instance).addConditions(param1Builder);
      return this;
    }
    
    public Builder addConditions(Conditions.Condition param1Condition) {
      copyOnWrite();
      ((Conditions.AndCondition)this.instance).addConditions(param1Condition);
      return this;
    }
    
    public Builder clearConditions() {
      copyOnWrite();
      ((Conditions.AndCondition)this.instance).clearConditions();
      return this;
    }
    
    public Conditions.Condition getConditions(int param1Int) {
      return ((Conditions.AndCondition)this.instance).getConditions(param1Int);
    }
    
    public int getConditionsCount() {
      return ((Conditions.AndCondition)this.instance).getConditionsCount();
    }
    
    public List<Conditions.Condition> getConditionsList() {
      return Collections.unmodifiableList(((Conditions.AndCondition)this.instance).getConditionsList());
    }
    
    public Builder removeConditions(int param1Int) {
      copyOnWrite();
      ((Conditions.AndCondition)this.instance).removeConditions(param1Int);
      return this;
    }
    
    public Builder setConditions(int param1Int, Conditions.Condition.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.AndCondition)this.instance).setConditions(param1Int, param1Builder);
      return this;
    }
    
    public Builder setConditions(int param1Int, Conditions.Condition param1Condition) {
      copyOnWrite();
      ((Conditions.AndCondition)this.instance).setConditions(param1Int, param1Condition);
      return this;
    }
  }
  
  public static interface AndConditionOrBuilder extends MessageLiteOrBuilder {
    Conditions.Condition getConditions(int param1Int);
    
    int getConditionsCount();
    
    List<Conditions.Condition> getConditionsList();
  }
  
  public static final class AppVersionCondition extends GeneratedMessageLite<AppVersionCondition, AppVersionCondition.Builder> implements AppVersionConditionOrBuilder {
    private static final AppVersionCondition DEFAULT_INSTANCE = new AppVersionCondition();
    
    public static final int OPERATOR_FIELD_NUMBER = 1;
    
    private static volatile Parser<AppVersionCondition> PARSER;
    
    public static final int TARGET_APP_VERSIONS_FIELD_NUMBER = 3;
    
    public static final int TARGET_VALUE_FIELD_NUMBER = 2;
    
    private int bitField0_;
    
    private int operator_;
    
    private Internal.ProtobufList<String> targetAppVersions_ = GeneratedMessageLite.emptyProtobufList();
    
    private String targetValue_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllTargetAppVersions(Iterable<String> param1Iterable) {
      ensureTargetAppVersionsIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.targetAppVersions_);
    }
    
    private void addTargetAppVersions(String param1String) {
      if (param1String != null) {
        ensureTargetAppVersionsIsMutable();
        this.targetAppVersions_.add(param1String);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addTargetAppVersionsBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        ensureTargetAppVersionsIsMutable();
        this.targetAppVersions_.add(param1ByteString.toStringUtf8());
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearOperator() {
      this.operator_ = 0;
    }
    
    private void clearTargetAppVersions() {
      this.targetAppVersions_ = GeneratedMessageLite.emptyProtobufList();
    }
    
    private void clearTargetValue() {
      this.targetValue_ = getDefaultInstance().getTargetValue();
    }
    
    private void ensureTargetAppVersionsIsMutable() {
      if (!this.targetAppVersions_.isModifiable())
        this.targetAppVersions_ = GeneratedMessageLite.mutableCopy(this.targetAppVersions_); 
    }
    
    public static AppVersionCondition getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(AppVersionCondition param1AppVersionCondition) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1AppVersionCondition);
    }
    
    public static AppVersionCondition parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (AppVersionCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static AppVersionCondition parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (AppVersionCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static AppVersionCondition parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (AppVersionCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static AppVersionCondition parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (AppVersionCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static AppVersionCondition parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (AppVersionCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static AppVersionCondition parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (AppVersionCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static AppVersionCondition parseFrom(InputStream param1InputStream) throws IOException {
      return (AppVersionCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static AppVersionCondition parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (AppVersionCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static AppVersionCondition parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (AppVersionCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static AppVersionCondition parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (AppVersionCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<AppVersionCondition> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setOperator(AppVersionOperator param1AppVersionOperator) {
      if (param1AppVersionOperator != null) {
        this.operator_ = param1AppVersionOperator.getNumber();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setOperatorValue(int param1Int) {
      this.operator_ = param1Int;
    }
    
    private void setTargetAppVersions(int param1Int, String param1String) {
      if (param1String != null) {
        ensureTargetAppVersionsIsMutable();
        this.targetAppVersions_.set(param1Int, param1String);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTargetValue(String param1String) {
      if (param1String != null) {
        this.targetValue_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTargetValueBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.targetValue_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/developers/mobile/targeting/proto/Conditions$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: istore #4
      //   10: iconst_0
      //   11: istore #5
      //   13: iconst_0
      //   14: istore #6
      //   16: iload #4
      //   18: tableswitch default -> 64, 1 -> 466, 2 -> 462, 3 -> 451, 4 -> 442, 5 -> 304, 6 -> 118, 7 -> 300, 8 -> 72
      //   64: new java/lang/UnsupportedOperationException
      //   67: dup
      //   68: invokespecial <init> : ()V
      //   71: athrow
      //   72: getstatic com/google/developers/mobile/targeting/proto/Conditions$AppVersionCondition.PARSER : Lcom/google/protobuf/Parser;
      //   75: ifnonnull -> 114
      //   78: ldc com/google/developers/mobile/targeting/proto/Conditions$AppVersionCondition
      //   80: monitorenter
      //   81: getstatic com/google/developers/mobile/targeting/proto/Conditions$AppVersionCondition.PARSER : Lcom/google/protobuf/Parser;
      //   84: ifnonnull -> 102
      //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   90: astore_1
      //   91: aload_1
      //   92: getstatic com/google/developers/mobile/targeting/proto/Conditions$AppVersionCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$AppVersionCondition;
      //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   98: aload_1
      //   99: putstatic com/google/developers/mobile/targeting/proto/Conditions$AppVersionCondition.PARSER : Lcom/google/protobuf/Parser;
      //   102: ldc com/google/developers/mobile/targeting/proto/Conditions$AppVersionCondition
      //   104: monitorexit
      //   105: goto -> 114
      //   108: astore_1
      //   109: ldc com/google/developers/mobile/targeting/proto/Conditions$AppVersionCondition
      //   111: monitorexit
      //   112: aload_1
      //   113: athrow
      //   114: getstatic com/google/developers/mobile/targeting/proto/Conditions$AppVersionCondition.PARSER : Lcom/google/protobuf/Parser;
      //   117: areturn
      //   118: aload_2
      //   119: checkcast com/google/protobuf/CodedInputStream
      //   122: astore_1
      //   123: aload_3
      //   124: checkcast com/google/protobuf/ExtensionRegistryLite
      //   127: astore_2
      //   128: iload #6
      //   130: ifne -> 300
      //   133: aload_1
      //   134: invokevirtual readTag : ()I
      //   137: istore #4
      //   139: iload #4
      //   141: ifeq -> 244
      //   144: iload #4
      //   146: bipush #8
      //   148: if_icmpeq -> 233
      //   151: iload #4
      //   153: bipush #18
      //   155: if_icmpeq -> 222
      //   158: iload #4
      //   160: bipush #26
      //   162: if_icmpeq -> 180
      //   165: aload_1
      //   166: iload #4
      //   168: invokevirtual skipField : (I)Z
      //   171: ifne -> 128
      //   174: iconst_1
      //   175: istore #6
      //   177: goto -> 128
      //   180: aload_1
      //   181: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   184: astore_2
      //   185: aload_0
      //   186: getfield targetAppVersions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   189: invokeinterface isModifiable : ()Z
      //   194: ifne -> 208
      //   197: aload_0
      //   198: aload_0
      //   199: getfield targetAppVersions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   202: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   205: putfield targetAppVersions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   208: aload_0
      //   209: getfield targetAppVersions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   212: aload_2
      //   213: invokeinterface add : (Ljava/lang/Object;)Z
      //   218: pop
      //   219: goto -> 128
      //   222: aload_0
      //   223: aload_1
      //   224: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   227: putfield targetValue_ : Ljava/lang/String;
      //   230: goto -> 128
      //   233: aload_0
      //   234: aload_1
      //   235: invokevirtual readEnum : ()I
      //   238: putfield operator_ : I
      //   241: goto -> 128
      //   244: iconst_1
      //   245: istore #6
      //   247: goto -> 128
      //   250: astore_1
      //   251: goto -> 298
      //   254: astore_3
      //   255: new java/lang/RuntimeException
      //   258: astore_2
      //   259: new com/google/protobuf/InvalidProtocolBufferException
      //   262: astore_1
      //   263: aload_1
      //   264: aload_3
      //   265: invokevirtual getMessage : ()Ljava/lang/String;
      //   268: invokespecial <init> : (Ljava/lang/String;)V
      //   271: aload_2
      //   272: aload_1
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
      //   300: getstatic com/google/developers/mobile/targeting/proto/Conditions$AppVersionCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$AppVersionCondition;
      //   303: areturn
      //   304: aload_2
      //   305: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   308: astore_1
      //   309: aload_3
      //   310: checkcast com/google/developers/mobile/targeting/proto/Conditions$AppVersionCondition
      //   313: astore_2
      //   314: aload_0
      //   315: getfield operator_ : I
      //   318: ifeq -> 327
      //   321: iconst_1
      //   322: istore #7
      //   324: goto -> 330
      //   327: iconst_0
      //   328: istore #7
      //   330: aload_0
      //   331: getfield operator_ : I
      //   334: istore #6
      //   336: aload_2
      //   337: getfield operator_ : I
      //   340: ifeq -> 346
      //   343: iconst_1
      //   344: istore #5
      //   346: aload_0
      //   347: aload_1
      //   348: iload #7
      //   350: iload #6
      //   352: iload #5
      //   354: aload_2
      //   355: getfield operator_ : I
      //   358: invokeinterface visitInt : (ZIZI)I
      //   363: putfield operator_ : I
      //   366: aload_0
      //   367: aload_1
      //   368: aload_0
      //   369: getfield targetValue_ : Ljava/lang/String;
      //   372: invokevirtual isEmpty : ()Z
      //   375: iconst_1
      //   376: ixor
      //   377: aload_0
      //   378: getfield targetValue_ : Ljava/lang/String;
      //   381: aload_2
      //   382: getfield targetValue_ : Ljava/lang/String;
      //   385: invokevirtual isEmpty : ()Z
      //   388: iconst_1
      //   389: ixor
      //   390: aload_2
      //   391: getfield targetValue_ : Ljava/lang/String;
      //   394: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   399: putfield targetValue_ : Ljava/lang/String;
      //   402: aload_0
      //   403: aload_1
      //   404: aload_0
      //   405: getfield targetAppVersions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   408: aload_2
      //   409: getfield targetAppVersions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   412: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   417: putfield targetAppVersions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   420: aload_1
      //   421: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   424: if_acmpne -> 440
      //   427: aload_0
      //   428: aload_0
      //   429: getfield bitField0_ : I
      //   432: aload_2
      //   433: getfield bitField0_ : I
      //   436: ior
      //   437: putfield bitField0_ : I
      //   440: aload_0
      //   441: areturn
      //   442: new com/google/developers/mobile/targeting/proto/Conditions$AppVersionCondition$Builder
      //   445: dup
      //   446: aconst_null
      //   447: invokespecial <init> : (Lcom/google/developers/mobile/targeting/proto/Conditions$1;)V
      //   450: areturn
      //   451: aload_0
      //   452: getfield targetAppVersions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   455: invokeinterface makeImmutable : ()V
      //   460: aconst_null
      //   461: areturn
      //   462: getstatic com/google/developers/mobile/targeting/proto/Conditions$AppVersionCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$AppVersionCondition;
      //   465: areturn
      //   466: new com/google/developers/mobile/targeting/proto/Conditions$AppVersionCondition
      //   469: dup
      //   470: invokespecial <init> : ()V
      //   473: areturn
      // Exception table:
      //   from	to	target	type
      //   81	102	108	finally
      //   102	105	108	finally
      //   109	112	108	finally
      //   133	139	282	com/google/protobuf/InvalidProtocolBufferException
      //   133	139	254	java/io/IOException
      //   133	139	250	finally
      //   165	174	282	com/google/protobuf/InvalidProtocolBufferException
      //   165	174	254	java/io/IOException
      //   165	174	250	finally
      //   180	208	282	com/google/protobuf/InvalidProtocolBufferException
      //   180	208	254	java/io/IOException
      //   180	208	250	finally
      //   208	219	282	com/google/protobuf/InvalidProtocolBufferException
      //   208	219	254	java/io/IOException
      //   208	219	250	finally
      //   222	230	282	com/google/protobuf/InvalidProtocolBufferException
      //   222	230	254	java/io/IOException
      //   222	230	250	finally
      //   233	241	282	com/google/protobuf/InvalidProtocolBufferException
      //   233	241	254	java/io/IOException
      //   233	241	250	finally
      //   255	282	250	finally
      //   283	298	250	finally
    }
    
    public AppVersionOperator getOperator() {
      AppVersionOperator appVersionOperator1 = AppVersionOperator.forNumber(this.operator_);
      AppVersionOperator appVersionOperator2 = appVersionOperator1;
      if (appVersionOperator1 == null)
        appVersionOperator2 = AppVersionOperator.UNRECOGNIZED; 
      return appVersionOperator2;
    }
    
    public int getOperatorValue() {
      return this.operator_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      int j = this.operator_;
      i = AppVersionOperator.UNKNOWN.getNumber();
      int k = 0;
      if (j != i) {
        i = CodedOutputStream.computeEnumSize(1, this.operator_) + 0;
      } else {
        i = 0;
      } 
      j = i;
      if (!this.targetValue_.isEmpty())
        j = i + CodedOutputStream.computeStringSize(2, getTargetValue()); 
      byte b = 0;
      i = k;
      k = b;
      while (i < this.targetAppVersions_.size()) {
        k += CodedOutputStream.computeStringSizeNoTag((String)this.targetAppVersions_.get(i));
        i++;
      } 
      i = j + k + getTargetAppVersionsList().size() * 1;
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public String getTargetAppVersions(int param1Int) {
      return (String)this.targetAppVersions_.get(param1Int);
    }
    
    public ByteString getTargetAppVersionsBytes(int param1Int) {
      return ByteString.copyFromUtf8((String)this.targetAppVersions_.get(param1Int));
    }
    
    public int getTargetAppVersionsCount() {
      return this.targetAppVersions_.size();
    }
    
    public List<String> getTargetAppVersionsList() {
      return (List<String>)this.targetAppVersions_;
    }
    
    @Deprecated
    public String getTargetValue() {
      return this.targetValue_;
    }
    
    @Deprecated
    public ByteString getTargetValueBytes() {
      return ByteString.copyFromUtf8(this.targetValue_);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.operator_ != AppVersionOperator.UNKNOWN.getNumber())
        param1CodedOutputStream.writeEnum(1, this.operator_); 
      if (!this.targetValue_.isEmpty())
        param1CodedOutputStream.writeString(2, getTargetValue()); 
      for (byte b = 0; b < this.targetAppVersions_.size(); b++)
        param1CodedOutputStream.writeString(3, (String)this.targetAppVersions_.get(b)); 
    }
    
    public enum AppVersionOperator implements Internal.EnumLite {
      CONTAINS(0),
      CONTAINS_REGEX(0),
      DOES_NOT_CONTAIN(0),
      EXACTLY_MATCHES(0),
      UNKNOWN(0),
      UNRECOGNIZED(0);
      
      public static final int CONTAINS_REGEX_VALUE = 4;
      
      public static final int CONTAINS_VALUE = 1;
      
      public static final int DOES_NOT_CONTAIN_VALUE = 2;
      
      public static final int EXACTLY_MATCHES_VALUE = 3;
      
      public static final int UNKNOWN_VALUE = 0;
      
      private static final Internal.EnumLiteMap<AppVersionOperator> internalValueMap;
      
      private final int value;
      
      static {
        $VALUES = new AppVersionOperator[] { UNKNOWN, CONTAINS, DOES_NOT_CONTAIN, EXACTLY_MATCHES, CONTAINS_REGEX, UNRECOGNIZED };
        internalValueMap = new Internal.EnumLiteMap<AppVersionOperator>() {
            public Conditions.AppVersionCondition.AppVersionOperator findValueByNumber(int param3Int) {
              return Conditions.AppVersionCondition.AppVersionOperator.forNumber(param3Int);
            }
          };
      }
      
      AppVersionOperator(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static AppVersionOperator forNumber(int param2Int) {
        switch (param2Int) {
          default:
            return null;
          case 4:
            return CONTAINS_REGEX;
          case 3:
            return EXACTLY_MATCHES;
          case 2:
            return DOES_NOT_CONTAIN;
          case 1:
            return CONTAINS;
          case 0:
            break;
        } 
        return UNKNOWN;
      }
      
      public static Internal.EnumLiteMap<AppVersionOperator> internalGetValueMap() {
        return internalValueMap;
      }
      
      public final int getNumber() {
        return this.value;
      }
    }
    
    class null implements Internal.EnumLiteMap<AppVersionOperator> {
      public Conditions.AppVersionCondition.AppVersionOperator findValueByNumber(int param2Int) {
        return Conditions.AppVersionCondition.AppVersionOperator.forNumber(param2Int);
      }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AppVersionCondition, Builder> implements Conditions.AppVersionConditionOrBuilder {
      private Builder() {
        super(Conditions.AppVersionCondition.DEFAULT_INSTANCE);
      }
      
      public Builder addAllTargetAppVersions(Iterable<String> param2Iterable) {
        copyOnWrite();
        ((Conditions.AppVersionCondition)this.instance).addAllTargetAppVersions(param2Iterable);
        return this;
      }
      
      public Builder addTargetAppVersions(String param2String) {
        copyOnWrite();
        ((Conditions.AppVersionCondition)this.instance).addTargetAppVersions(param2String);
        return this;
      }
      
      public Builder addTargetAppVersionsBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((Conditions.AppVersionCondition)this.instance).addTargetAppVersionsBytes(param2ByteString);
        return this;
      }
      
      public Builder clearOperator() {
        copyOnWrite();
        ((Conditions.AppVersionCondition)this.instance).clearOperator();
        return this;
      }
      
      public Builder clearTargetAppVersions() {
        copyOnWrite();
        ((Conditions.AppVersionCondition)this.instance).clearTargetAppVersions();
        return this;
      }
      
      @Deprecated
      public Builder clearTargetValue() {
        copyOnWrite();
        ((Conditions.AppVersionCondition)this.instance).clearTargetValue();
        return this;
      }
      
      public Conditions.AppVersionCondition.AppVersionOperator getOperator() {
        return ((Conditions.AppVersionCondition)this.instance).getOperator();
      }
      
      public int getOperatorValue() {
        return ((Conditions.AppVersionCondition)this.instance).getOperatorValue();
      }
      
      public String getTargetAppVersions(int param2Int) {
        return ((Conditions.AppVersionCondition)this.instance).getTargetAppVersions(param2Int);
      }
      
      public ByteString getTargetAppVersionsBytes(int param2Int) {
        return ((Conditions.AppVersionCondition)this.instance).getTargetAppVersionsBytes(param2Int);
      }
      
      public int getTargetAppVersionsCount() {
        return ((Conditions.AppVersionCondition)this.instance).getTargetAppVersionsCount();
      }
      
      public List<String> getTargetAppVersionsList() {
        return Collections.unmodifiableList(((Conditions.AppVersionCondition)this.instance).getTargetAppVersionsList());
      }
      
      @Deprecated
      public String getTargetValue() {
        return ((Conditions.AppVersionCondition)this.instance).getTargetValue();
      }
      
      @Deprecated
      public ByteString getTargetValueBytes() {
        return ((Conditions.AppVersionCondition)this.instance).getTargetValueBytes();
      }
      
      public Builder setOperator(Conditions.AppVersionCondition.AppVersionOperator param2AppVersionOperator) {
        copyOnWrite();
        ((Conditions.AppVersionCondition)this.instance).setOperator(param2AppVersionOperator);
        return this;
      }
      
      public Builder setOperatorValue(int param2Int) {
        copyOnWrite();
        ((Conditions.AppVersionCondition)this.instance).setOperatorValue(param2Int);
        return this;
      }
      
      public Builder setTargetAppVersions(int param2Int, String param2String) {
        copyOnWrite();
        ((Conditions.AppVersionCondition)this.instance).setTargetAppVersions(param2Int, param2String);
        return this;
      }
      
      @Deprecated
      public Builder setTargetValue(String param2String) {
        copyOnWrite();
        ((Conditions.AppVersionCondition)this.instance).setTargetValue(param2String);
        return this;
      }
      
      @Deprecated
      public Builder setTargetValueBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((Conditions.AppVersionCondition)this.instance).setTargetValueBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public enum AppVersionOperator implements Internal.EnumLite {
    CONTAINS(0),
    CONTAINS_REGEX(0),
    DOES_NOT_CONTAIN(0),
    EXACTLY_MATCHES(0),
    UNKNOWN(0),
    UNRECOGNIZED(0);
    
    public static final int CONTAINS_REGEX_VALUE = 4;
    
    public static final int CONTAINS_VALUE = 1;
    
    public static final int DOES_NOT_CONTAIN_VALUE = 2;
    
    public static final int EXACTLY_MATCHES_VALUE = 3;
    
    public static final int UNKNOWN_VALUE = 0;
    
    private static final Internal.EnumLiteMap<AppVersionOperator> internalValueMap;
    
    private final int value;
    
    static {
      CONTAINS_REGEX = new AppVersionOperator("CONTAINS_REGEX", 4, 4);
      UNRECOGNIZED = new AppVersionOperator("UNRECOGNIZED", 5, -1);
      $VALUES = new AppVersionOperator[] { UNKNOWN, CONTAINS, DOES_NOT_CONTAIN, EXACTLY_MATCHES, CONTAINS_REGEX, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<AppVersionOperator>() {
          public Conditions.AppVersionCondition.AppVersionOperator findValueByNumber(int param3Int) {
            return Conditions.AppVersionCondition.AppVersionOperator.forNumber(param3Int);
          }
        };
    }
    
    AppVersionOperator(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static AppVersionOperator forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 4:
          return CONTAINS_REGEX;
        case 3:
          return EXACTLY_MATCHES;
        case 2:
          return DOES_NOT_CONTAIN;
        case 1:
          return CONTAINS;
        case 0:
          break;
      } 
      return UNKNOWN;
    }
    
    public static Internal.EnumLiteMap<AppVersionOperator> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<AppVersionCondition.AppVersionOperator> {
    public Conditions.AppVersionCondition.AppVersionOperator findValueByNumber(int param1Int) {
      return Conditions.AppVersionCondition.AppVersionOperator.forNumber(param1Int);
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<AppVersionCondition, AppVersionCondition.Builder> implements AppVersionConditionOrBuilder {
    private Builder() {
      super(Conditions.AppVersionCondition.DEFAULT_INSTANCE);
    }
    
    public Builder addAllTargetAppVersions(Iterable<String> param1Iterable) {
      copyOnWrite();
      ((Conditions.AppVersionCondition)this.instance).addAllTargetAppVersions(param1Iterable);
      return this;
    }
    
    public Builder addTargetAppVersions(String param1String) {
      copyOnWrite();
      ((Conditions.AppVersionCondition)this.instance).addTargetAppVersions(param1String);
      return this;
    }
    
    public Builder addTargetAppVersionsBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Conditions.AppVersionCondition)this.instance).addTargetAppVersionsBytes(param1ByteString);
      return this;
    }
    
    public Builder clearOperator() {
      copyOnWrite();
      ((Conditions.AppVersionCondition)this.instance).clearOperator();
      return this;
    }
    
    public Builder clearTargetAppVersions() {
      copyOnWrite();
      ((Conditions.AppVersionCondition)this.instance).clearTargetAppVersions();
      return this;
    }
    
    @Deprecated
    public Builder clearTargetValue() {
      copyOnWrite();
      ((Conditions.AppVersionCondition)this.instance).clearTargetValue();
      return this;
    }
    
    public Conditions.AppVersionCondition.AppVersionOperator getOperator() {
      return ((Conditions.AppVersionCondition)this.instance).getOperator();
    }
    
    public int getOperatorValue() {
      return ((Conditions.AppVersionCondition)this.instance).getOperatorValue();
    }
    
    public String getTargetAppVersions(int param1Int) {
      return ((Conditions.AppVersionCondition)this.instance).getTargetAppVersions(param1Int);
    }
    
    public ByteString getTargetAppVersionsBytes(int param1Int) {
      return ((Conditions.AppVersionCondition)this.instance).getTargetAppVersionsBytes(param1Int);
    }
    
    public int getTargetAppVersionsCount() {
      return ((Conditions.AppVersionCondition)this.instance).getTargetAppVersionsCount();
    }
    
    public List<String> getTargetAppVersionsList() {
      return Collections.unmodifiableList(((Conditions.AppVersionCondition)this.instance).getTargetAppVersionsList());
    }
    
    @Deprecated
    public String getTargetValue() {
      return ((Conditions.AppVersionCondition)this.instance).getTargetValue();
    }
    
    @Deprecated
    public ByteString getTargetValueBytes() {
      return ((Conditions.AppVersionCondition)this.instance).getTargetValueBytes();
    }
    
    public Builder setOperator(Conditions.AppVersionCondition.AppVersionOperator param1AppVersionOperator) {
      copyOnWrite();
      ((Conditions.AppVersionCondition)this.instance).setOperator(param1AppVersionOperator);
      return this;
    }
    
    public Builder setOperatorValue(int param1Int) {
      copyOnWrite();
      ((Conditions.AppVersionCondition)this.instance).setOperatorValue(param1Int);
      return this;
    }
    
    public Builder setTargetAppVersions(int param1Int, String param1String) {
      copyOnWrite();
      ((Conditions.AppVersionCondition)this.instance).setTargetAppVersions(param1Int, param1String);
      return this;
    }
    
    @Deprecated
    public Builder setTargetValue(String param1String) {
      copyOnWrite();
      ((Conditions.AppVersionCondition)this.instance).setTargetValue(param1String);
      return this;
    }
    
    @Deprecated
    public Builder setTargetValueBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Conditions.AppVersionCondition)this.instance).setTargetValueBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface AppVersionConditionOrBuilder extends MessageLiteOrBuilder {
    Conditions.AppVersionCondition.AppVersionOperator getOperator();
    
    int getOperatorValue();
    
    String getTargetAppVersions(int param1Int);
    
    ByteString getTargetAppVersionsBytes(int param1Int);
    
    int getTargetAppVersionsCount();
    
    List<String> getTargetAppVersionsList();
    
    @Deprecated
    String getTargetValue();
    
    @Deprecated
    ByteString getTargetValueBytes();
  }
  
  public static final class Condition extends GeneratedMessageLite<Condition, Condition.Builder> implements ConditionOrBuilder {
    public static final int ABT_EXPERIMENT_FIELD_NUMBER = 18;
    
    public static final int ALWAYS_FALSE_FIELD_NUMBER = 17;
    
    public static final int ALWAYS_TRUE_FIELD_NUMBER = 16;
    
    public static final int ANALYTICS_AUDIENCES_FIELD_NUMBER = 7;
    
    public static final int ANALYTICS_USER_PROPERTY_FIELD_NUMBER = 12;
    
    public static final int AND_FIELD_NUMBER = 1;
    
    public static final int APP_ID_FIELD_NUMBER = 6;
    
    public static final int APP_VERSION_FIELD_NUMBER = 5;
    
    public static final int COUNTRIES_FIELD_NUMBER = 9;
    
    private static final Condition DEFAULT_INSTANCE = new Condition();
    
    public static final int FIREBASE_FUNCTION_FIELD_NUMBER = 19;
    
    public static final int LANGUAGES_FIELD_NUMBER = 8;
    
    public static final int NOT_FIELD_NUMBER = 3;
    
    public static final int OR_FIELD_NUMBER = 2;
    
    public static final int OS_TYPE_FIELD_NUMBER = 10;
    
    private static volatile Parser<Condition> PARSER;
    
    public static final int PERCENT_FIELD_NUMBER = 14;
    
    public static final int PREDICTIONS_FIELD_NUMBER = 15;
    
    public static final int TIME_FIELD_NUMBER = 4;
    
    public static final int TOPIC_FIELD_NUMBER = 13;
    
    private int conditionCase_ = 0;
    
    private Object condition_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearAbtExperiment() {
      if (this.conditionCase_ == 18) {
        this.conditionCase_ = 0;
        this.condition_ = null;
      } 
    }
    
    private void clearAlwaysFalse() {
      if (this.conditionCase_ == 17) {
        this.conditionCase_ = 0;
        this.condition_ = null;
      } 
    }
    
    private void clearAlwaysTrue() {
      if (this.conditionCase_ == 16) {
        this.conditionCase_ = 0;
        this.condition_ = null;
      } 
    }
    
    private void clearAnalyticsAudiences() {
      if (this.conditionCase_ == 7) {
        this.conditionCase_ = 0;
        this.condition_ = null;
      } 
    }
    
    private void clearAnalyticsUserProperty() {
      if (this.conditionCase_ == 12) {
        this.conditionCase_ = 0;
        this.condition_ = null;
      } 
    }
    
    private void clearAnd() {
      if (this.conditionCase_ == 1) {
        this.conditionCase_ = 0;
        this.condition_ = null;
      } 
    }
    
    private void clearAppId() {
      if (this.conditionCase_ == 6) {
        this.conditionCase_ = 0;
        this.condition_ = null;
      } 
    }
    
    private void clearAppVersion() {
      if (this.conditionCase_ == 5) {
        this.conditionCase_ = 0;
        this.condition_ = null;
      } 
    }
    
    private void clearCondition() {
      this.conditionCase_ = 0;
      this.condition_ = null;
    }
    
    private void clearCountries() {
      if (this.conditionCase_ == 9) {
        this.conditionCase_ = 0;
        this.condition_ = null;
      } 
    }
    
    private void clearFirebaseFunction() {
      if (this.conditionCase_ == 19) {
        this.conditionCase_ = 0;
        this.condition_ = null;
      } 
    }
    
    private void clearLanguages() {
      if (this.conditionCase_ == 8) {
        this.conditionCase_ = 0;
        this.condition_ = null;
      } 
    }
    
    private void clearNot() {
      if (this.conditionCase_ == 3) {
        this.conditionCase_ = 0;
        this.condition_ = null;
      } 
    }
    
    private void clearOr() {
      if (this.conditionCase_ == 2) {
        this.conditionCase_ = 0;
        this.condition_ = null;
      } 
    }
    
    private void clearOsType() {
      if (this.conditionCase_ == 10) {
        this.conditionCase_ = 0;
        this.condition_ = null;
      } 
    }
    
    private void clearPercent() {
      if (this.conditionCase_ == 14) {
        this.conditionCase_ = 0;
        this.condition_ = null;
      } 
    }
    
    private void clearPredictions() {
      if (this.conditionCase_ == 15) {
        this.conditionCase_ = 0;
        this.condition_ = null;
      } 
    }
    
    private void clearTime() {
      if (this.conditionCase_ == 4) {
        this.conditionCase_ = 0;
        this.condition_ = null;
      } 
    }
    
    private void clearTopic() {
      if (this.conditionCase_ == 13) {
        this.conditionCase_ = 0;
        this.condition_ = null;
      } 
    }
    
    public static Condition getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeAbtExperiment(Conditions.AbtExperimentCondition param1AbtExperimentCondition) {
      if (this.conditionCase_ == 18 && this.condition_ != Conditions.AbtExperimentCondition.getDefaultInstance()) {
        this.condition_ = ((Conditions.AbtExperimentCondition.Builder)Conditions.AbtExperimentCondition.newBuilder((Conditions.AbtExperimentCondition)this.condition_).mergeFrom(param1AbtExperimentCondition)).buildPartial();
      } else {
        this.condition_ = param1AbtExperimentCondition;
      } 
      this.conditionCase_ = 18;
    }
    
    private void mergeAlwaysFalse(Conditions.FalseCondition param1FalseCondition) {
      if (this.conditionCase_ == 17 && this.condition_ != Conditions.FalseCondition.getDefaultInstance()) {
        this.condition_ = ((Conditions.FalseCondition.Builder)Conditions.FalseCondition.newBuilder((Conditions.FalseCondition)this.condition_).mergeFrom(param1FalseCondition)).buildPartial();
      } else {
        this.condition_ = param1FalseCondition;
      } 
      this.conditionCase_ = 17;
    }
    
    private void mergeAlwaysTrue(Conditions.TrueCondition param1TrueCondition) {
      if (this.conditionCase_ == 16 && this.condition_ != Conditions.TrueCondition.getDefaultInstance()) {
        this.condition_ = ((Conditions.TrueCondition.Builder)Conditions.TrueCondition.newBuilder((Conditions.TrueCondition)this.condition_).mergeFrom(param1TrueCondition)).buildPartial();
      } else {
        this.condition_ = param1TrueCondition;
      } 
      this.conditionCase_ = 16;
    }
    
    private void mergeAnalyticsAudiences(Conditions.AnalyticsAudienceCondition param1AnalyticsAudienceCondition) {
      if (this.conditionCase_ == 7 && this.condition_ != Conditions.AnalyticsAudienceCondition.getDefaultInstance()) {
        this.condition_ = ((Conditions.AnalyticsAudienceCondition.Builder)Conditions.AnalyticsAudienceCondition.newBuilder((Conditions.AnalyticsAudienceCondition)this.condition_).mergeFrom(param1AnalyticsAudienceCondition)).buildPartial();
      } else {
        this.condition_ = param1AnalyticsAudienceCondition;
      } 
      this.conditionCase_ = 7;
    }
    
    private void mergeAnalyticsUserProperty(Conditions.AnalyticsUserPropertyCondition param1AnalyticsUserPropertyCondition) {
      if (this.conditionCase_ == 12 && this.condition_ != Conditions.AnalyticsUserPropertyCondition.getDefaultInstance()) {
        this.condition_ = ((Conditions.AnalyticsUserPropertyCondition.Builder)Conditions.AnalyticsUserPropertyCondition.newBuilder((Conditions.AnalyticsUserPropertyCondition)this.condition_).mergeFrom(param1AnalyticsUserPropertyCondition)).buildPartial();
      } else {
        this.condition_ = param1AnalyticsUserPropertyCondition;
      } 
      this.conditionCase_ = 12;
    }
    
    private void mergeAnd(Conditions.AndCondition param1AndCondition) {
      if (this.conditionCase_ == 1 && this.condition_ != Conditions.AndCondition.getDefaultInstance()) {
        this.condition_ = ((Conditions.AndCondition.Builder)Conditions.AndCondition.newBuilder((Conditions.AndCondition)this.condition_).mergeFrom(param1AndCondition)).buildPartial();
      } else {
        this.condition_ = param1AndCondition;
      } 
      this.conditionCase_ = 1;
    }
    
    private void mergeAppId(Conditions.FirebaseAppIdCondition param1FirebaseAppIdCondition) {
      if (this.conditionCase_ == 6 && this.condition_ != Conditions.FirebaseAppIdCondition.getDefaultInstance()) {
        this.condition_ = ((Conditions.FirebaseAppIdCondition.Builder)Conditions.FirebaseAppIdCondition.newBuilder((Conditions.FirebaseAppIdCondition)this.condition_).mergeFrom(param1FirebaseAppIdCondition)).buildPartial();
      } else {
        this.condition_ = param1FirebaseAppIdCondition;
      } 
      this.conditionCase_ = 6;
    }
    
    private void mergeAppVersion(Conditions.AppVersionCondition param1AppVersionCondition) {
      if (this.conditionCase_ == 5 && this.condition_ != Conditions.AppVersionCondition.getDefaultInstance()) {
        this.condition_ = ((Conditions.AppVersionCondition.Builder)Conditions.AppVersionCondition.newBuilder((Conditions.AppVersionCondition)this.condition_).mergeFrom(param1AppVersionCondition)).buildPartial();
      } else {
        this.condition_ = param1AppVersionCondition;
      } 
      this.conditionCase_ = 5;
    }
    
    private void mergeCountries(Conditions.DeviceCountryCondition param1DeviceCountryCondition) {
      if (this.conditionCase_ == 9 && this.condition_ != Conditions.DeviceCountryCondition.getDefaultInstance()) {
        this.condition_ = ((Conditions.DeviceCountryCondition.Builder)Conditions.DeviceCountryCondition.newBuilder((Conditions.DeviceCountryCondition)this.condition_).mergeFrom(param1DeviceCountryCondition)).buildPartial();
      } else {
        this.condition_ = param1DeviceCountryCondition;
      } 
      this.conditionCase_ = 9;
    }
    
    private void mergeFirebaseFunction(Conditions.FunctionCondition param1FunctionCondition) {
      if (this.conditionCase_ == 19 && this.condition_ != Conditions.FunctionCondition.getDefaultInstance()) {
        this.condition_ = ((Conditions.FunctionCondition.Builder)Conditions.FunctionCondition.newBuilder((Conditions.FunctionCondition)this.condition_).mergeFrom(param1FunctionCondition)).buildPartial();
      } else {
        this.condition_ = param1FunctionCondition;
      } 
      this.conditionCase_ = 19;
    }
    
    private void mergeLanguages(Conditions.DeviceLanguageCondition param1DeviceLanguageCondition) {
      if (this.conditionCase_ == 8 && this.condition_ != Conditions.DeviceLanguageCondition.getDefaultInstance()) {
        this.condition_ = ((Conditions.DeviceLanguageCondition.Builder)Conditions.DeviceLanguageCondition.newBuilder((Conditions.DeviceLanguageCondition)this.condition_).mergeFrom(param1DeviceLanguageCondition)).buildPartial();
      } else {
        this.condition_ = param1DeviceLanguageCondition;
      } 
      this.conditionCase_ = 8;
    }
    
    private void mergeNot(Conditions.NotCondition param1NotCondition) {
      if (this.conditionCase_ == 3 && this.condition_ != Conditions.NotCondition.getDefaultInstance()) {
        this.condition_ = ((Conditions.NotCondition.Builder)Conditions.NotCondition.newBuilder((Conditions.NotCondition)this.condition_).mergeFrom(param1NotCondition)).buildPartial();
      } else {
        this.condition_ = param1NotCondition;
      } 
      this.conditionCase_ = 3;
    }
    
    private void mergeOr(Conditions.OrCondition param1OrCondition) {
      if (this.conditionCase_ == 2 && this.condition_ != Conditions.OrCondition.getDefaultInstance()) {
        this.condition_ = ((Conditions.OrCondition.Builder)Conditions.OrCondition.newBuilder((Conditions.OrCondition)this.condition_).mergeFrom(param1OrCondition)).buildPartial();
      } else {
        this.condition_ = param1OrCondition;
      } 
      this.conditionCase_ = 2;
    }
    
    private void mergeOsType(Conditions.OsTypeCondition param1OsTypeCondition) {
      if (this.conditionCase_ == 10 && this.condition_ != Conditions.OsTypeCondition.getDefaultInstance()) {
        this.condition_ = ((Conditions.OsTypeCondition.Builder)Conditions.OsTypeCondition.newBuilder((Conditions.OsTypeCondition)this.condition_).mergeFrom(param1OsTypeCondition)).buildPartial();
      } else {
        this.condition_ = param1OsTypeCondition;
      } 
      this.conditionCase_ = 10;
    }
    
    private void mergePercent(Conditions.PercentCondition param1PercentCondition) {
      if (this.conditionCase_ == 14 && this.condition_ != Conditions.PercentCondition.getDefaultInstance()) {
        this.condition_ = ((Conditions.PercentCondition.Builder)Conditions.PercentCondition.newBuilder((Conditions.PercentCondition)this.condition_).mergeFrom(param1PercentCondition)).buildPartial();
      } else {
        this.condition_ = param1PercentCondition;
      } 
      this.conditionCase_ = 14;
    }
    
    private void mergePredictions(Conditions.PredictionsCondition param1PredictionsCondition) {
      if (this.conditionCase_ == 15 && this.condition_ != Conditions.PredictionsCondition.getDefaultInstance()) {
        this.condition_ = ((Conditions.PredictionsCondition.Builder)Conditions.PredictionsCondition.newBuilder((Conditions.PredictionsCondition)this.condition_).mergeFrom(param1PredictionsCondition)).buildPartial();
      } else {
        this.condition_ = param1PredictionsCondition;
      } 
      this.conditionCase_ = 15;
    }
    
    private void mergeTime(Conditions.DateTimeCondition param1DateTimeCondition) {
      if (this.conditionCase_ == 4 && this.condition_ != Conditions.DateTimeCondition.getDefaultInstance()) {
        this.condition_ = ((Conditions.DateTimeCondition.Builder)Conditions.DateTimeCondition.newBuilder((Conditions.DateTimeCondition)this.condition_).mergeFrom(param1DateTimeCondition)).buildPartial();
      } else {
        this.condition_ = param1DateTimeCondition;
      } 
      this.conditionCase_ = 4;
    }
    
    private void mergeTopic(Conditions.TopicCondition param1TopicCondition) {
      if (this.conditionCase_ == 13 && this.condition_ != Conditions.TopicCondition.getDefaultInstance()) {
        this.condition_ = ((Conditions.TopicCondition.Builder)Conditions.TopicCondition.newBuilder((Conditions.TopicCondition)this.condition_).mergeFrom(param1TopicCondition)).buildPartial();
      } else {
        this.condition_ = param1TopicCondition;
      } 
      this.conditionCase_ = 13;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Condition param1Condition) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1Condition);
    }
    
    public static Condition parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Condition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Condition parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Condition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Condition parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Condition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static Condition parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Condition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Condition parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Condition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static Condition parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Condition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Condition parseFrom(InputStream param1InputStream) throws IOException {
      return (Condition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Condition parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Condition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Condition parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Condition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static Condition parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Condition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Condition> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setAbtExperiment(Conditions.AbtExperimentCondition.Builder param1Builder) {
      this.condition_ = param1Builder.build();
      this.conditionCase_ = 18;
    }
    
    private void setAbtExperiment(Conditions.AbtExperimentCondition param1AbtExperimentCondition) {
      if (param1AbtExperimentCondition != null) {
        this.condition_ = param1AbtExperimentCondition;
        this.conditionCase_ = 18;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAlwaysFalse(Conditions.FalseCondition.Builder param1Builder) {
      this.condition_ = param1Builder.build();
      this.conditionCase_ = 17;
    }
    
    private void setAlwaysFalse(Conditions.FalseCondition param1FalseCondition) {
      if (param1FalseCondition != null) {
        this.condition_ = param1FalseCondition;
        this.conditionCase_ = 17;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAlwaysTrue(Conditions.TrueCondition.Builder param1Builder) {
      this.condition_ = param1Builder.build();
      this.conditionCase_ = 16;
    }
    
    private void setAlwaysTrue(Conditions.TrueCondition param1TrueCondition) {
      if (param1TrueCondition != null) {
        this.condition_ = param1TrueCondition;
        this.conditionCase_ = 16;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAnalyticsAudiences(Conditions.AnalyticsAudienceCondition.Builder param1Builder) {
      this.condition_ = param1Builder.build();
      this.conditionCase_ = 7;
    }
    
    private void setAnalyticsAudiences(Conditions.AnalyticsAudienceCondition param1AnalyticsAudienceCondition) {
      if (param1AnalyticsAudienceCondition != null) {
        this.condition_ = param1AnalyticsAudienceCondition;
        this.conditionCase_ = 7;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAnalyticsUserProperty(Conditions.AnalyticsUserPropertyCondition.Builder param1Builder) {
      this.condition_ = param1Builder.build();
      this.conditionCase_ = 12;
    }
    
    private void setAnalyticsUserProperty(Conditions.AnalyticsUserPropertyCondition param1AnalyticsUserPropertyCondition) {
      if (param1AnalyticsUserPropertyCondition != null) {
        this.condition_ = param1AnalyticsUserPropertyCondition;
        this.conditionCase_ = 12;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAnd(Conditions.AndCondition.Builder param1Builder) {
      this.condition_ = param1Builder.build();
      this.conditionCase_ = 1;
    }
    
    private void setAnd(Conditions.AndCondition param1AndCondition) {
      if (param1AndCondition != null) {
        this.condition_ = param1AndCondition;
        this.conditionCase_ = 1;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAppId(Conditions.FirebaseAppIdCondition.Builder param1Builder) {
      this.condition_ = param1Builder.build();
      this.conditionCase_ = 6;
    }
    
    private void setAppId(Conditions.FirebaseAppIdCondition param1FirebaseAppIdCondition) {
      if (param1FirebaseAppIdCondition != null) {
        this.condition_ = param1FirebaseAppIdCondition;
        this.conditionCase_ = 6;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAppVersion(Conditions.AppVersionCondition.Builder param1Builder) {
      this.condition_ = param1Builder.build();
      this.conditionCase_ = 5;
    }
    
    private void setAppVersion(Conditions.AppVersionCondition param1AppVersionCondition) {
      if (param1AppVersionCondition != null) {
        this.condition_ = param1AppVersionCondition;
        this.conditionCase_ = 5;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setCountries(Conditions.DeviceCountryCondition.Builder param1Builder) {
      this.condition_ = param1Builder.build();
      this.conditionCase_ = 9;
    }
    
    private void setCountries(Conditions.DeviceCountryCondition param1DeviceCountryCondition) {
      if (param1DeviceCountryCondition != null) {
        this.condition_ = param1DeviceCountryCondition;
        this.conditionCase_ = 9;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setFirebaseFunction(Conditions.FunctionCondition.Builder param1Builder) {
      this.condition_ = param1Builder.build();
      this.conditionCase_ = 19;
    }
    
    private void setFirebaseFunction(Conditions.FunctionCondition param1FunctionCondition) {
      if (param1FunctionCondition != null) {
        this.condition_ = param1FunctionCondition;
        this.conditionCase_ = 19;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setLanguages(Conditions.DeviceLanguageCondition.Builder param1Builder) {
      this.condition_ = param1Builder.build();
      this.conditionCase_ = 8;
    }
    
    private void setLanguages(Conditions.DeviceLanguageCondition param1DeviceLanguageCondition) {
      if (param1DeviceLanguageCondition != null) {
        this.condition_ = param1DeviceLanguageCondition;
        this.conditionCase_ = 8;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setNot(Conditions.NotCondition.Builder param1Builder) {
      this.condition_ = param1Builder.build();
      this.conditionCase_ = 3;
    }
    
    private void setNot(Conditions.NotCondition param1NotCondition) {
      if (param1NotCondition != null) {
        this.condition_ = param1NotCondition;
        this.conditionCase_ = 3;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setOr(Conditions.OrCondition.Builder param1Builder) {
      this.condition_ = param1Builder.build();
      this.conditionCase_ = 2;
    }
    
    private void setOr(Conditions.OrCondition param1OrCondition) {
      if (param1OrCondition != null) {
        this.condition_ = param1OrCondition;
        this.conditionCase_ = 2;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setOsType(Conditions.OsTypeCondition.Builder param1Builder) {
      this.condition_ = param1Builder.build();
      this.conditionCase_ = 10;
    }
    
    private void setOsType(Conditions.OsTypeCondition param1OsTypeCondition) {
      if (param1OsTypeCondition != null) {
        this.condition_ = param1OsTypeCondition;
        this.conditionCase_ = 10;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setPercent(Conditions.PercentCondition.Builder param1Builder) {
      this.condition_ = param1Builder.build();
      this.conditionCase_ = 14;
    }
    
    private void setPercent(Conditions.PercentCondition param1PercentCondition) {
      if (param1PercentCondition != null) {
        this.condition_ = param1PercentCondition;
        this.conditionCase_ = 14;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setPredictions(Conditions.PredictionsCondition.Builder param1Builder) {
      this.condition_ = param1Builder.build();
      this.conditionCase_ = 15;
    }
    
    private void setPredictions(Conditions.PredictionsCondition param1PredictionsCondition) {
      if (param1PredictionsCondition != null) {
        this.condition_ = param1PredictionsCondition;
        this.conditionCase_ = 15;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTime(Conditions.DateTimeCondition.Builder param1Builder) {
      this.condition_ = param1Builder.build();
      this.conditionCase_ = 4;
    }
    
    private void setTime(Conditions.DateTimeCondition param1DateTimeCondition) {
      if (param1DateTimeCondition != null) {
        this.condition_ = param1DateTimeCondition;
        this.conditionCase_ = 4;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTopic(Conditions.TopicCondition.Builder param1Builder) {
      this.condition_ = param1Builder.build();
      this.conditionCase_ = 13;
    }
    
    private void setTopic(Conditions.TopicCondition param1TopicCondition) {
      if (param1TopicCondition != null) {
        this.condition_ = param1TopicCondition;
        this.conditionCase_ = 13;
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/developers/mobile/targeting/proto/Conditions$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 2613, 2 -> 2609, 3 -> 2607, 4 -> 2598, 5 -> 1695, 6 -> 110, 7 -> 1691, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/developers/mobile/targeting/proto/Conditions$Condition.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/developers/mobile/targeting/proto/Conditions$Condition
      //   72: monitorenter
      //   73: getstatic com/google/developers/mobile/targeting/proto/Conditions$Condition.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/developers/mobile/targeting/proto/Conditions$Condition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$Condition;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/developers/mobile/targeting/proto/Conditions$Condition.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/developers/mobile/targeting/proto/Conditions$Condition
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/developers/mobile/targeting/proto/Conditions$Condition
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/developers/mobile/targeting/proto/Conditions$Condition.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 1691
      //   128: aload_2
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: lookupswitch default -> 300, 0 -> 1624, 10 -> 1550, 18 -> 1476, 26 -> 1402, 34 -> 1331, 42 -> 1260, 50 -> 1187, 58 -> 1114, 66 -> 1041, 74 -> 968, 82 -> 895, 98 -> 822, 106 -> 749, 114 -> 676, 122 -> 603, 130 -> 530, 138 -> 457, 146 -> 384, 154 -> 311
      //   300: aload_2
      //   301: iload #5
      //   303: invokevirtual skipField : (I)Z
      //   306: istore #6
      //   308: goto -> 1630
      //   311: aload_0
      //   312: getfield conditionCase_ : I
      //   315: bipush #19
      //   317: if_icmpne -> 337
      //   320: aload_0
      //   321: getfield condition_ : Ljava/lang/Object;
      //   324: checkcast com/google/developers/mobile/targeting/proto/Conditions$FunctionCondition
      //   327: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   330: checkcast com/google/developers/mobile/targeting/proto/Conditions$FunctionCondition$Builder
      //   333: astore_1
      //   334: goto -> 339
      //   337: aconst_null
      //   338: astore_1
      //   339: aload_0
      //   340: aload_2
      //   341: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   344: aload_3
      //   345: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   348: putfield condition_ : Ljava/lang/Object;
      //   351: aload_1
      //   352: ifnull -> 375
      //   355: aload_1
      //   356: aload_0
      //   357: getfield condition_ : Ljava/lang/Object;
      //   360: checkcast com/google/developers/mobile/targeting/proto/Conditions$FunctionCondition
      //   363: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   366: pop
      //   367: aload_0
      //   368: aload_1
      //   369: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   372: putfield condition_ : Ljava/lang/Object;
      //   375: aload_0
      //   376: bipush #19
      //   378: putfield conditionCase_ : I
      //   381: goto -> 123
      //   384: aload_0
      //   385: getfield conditionCase_ : I
      //   388: bipush #18
      //   390: if_icmpne -> 410
      //   393: aload_0
      //   394: getfield condition_ : Ljava/lang/Object;
      //   397: checkcast com/google/developers/mobile/targeting/proto/Conditions$AbtExperimentCondition
      //   400: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   403: checkcast com/google/developers/mobile/targeting/proto/Conditions$AbtExperimentCondition$Builder
      //   406: astore_1
      //   407: goto -> 412
      //   410: aconst_null
      //   411: astore_1
      //   412: aload_0
      //   413: aload_2
      //   414: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   417: aload_3
      //   418: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   421: putfield condition_ : Ljava/lang/Object;
      //   424: aload_1
      //   425: ifnull -> 448
      //   428: aload_1
      //   429: aload_0
      //   430: getfield condition_ : Ljava/lang/Object;
      //   433: checkcast com/google/developers/mobile/targeting/proto/Conditions$AbtExperimentCondition
      //   436: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   439: pop
      //   440: aload_0
      //   441: aload_1
      //   442: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   445: putfield condition_ : Ljava/lang/Object;
      //   448: aload_0
      //   449: bipush #18
      //   451: putfield conditionCase_ : I
      //   454: goto -> 123
      //   457: aload_0
      //   458: getfield conditionCase_ : I
      //   461: bipush #17
      //   463: if_icmpne -> 483
      //   466: aload_0
      //   467: getfield condition_ : Ljava/lang/Object;
      //   470: checkcast com/google/developers/mobile/targeting/proto/Conditions$FalseCondition
      //   473: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   476: checkcast com/google/developers/mobile/targeting/proto/Conditions$FalseCondition$Builder
      //   479: astore_1
      //   480: goto -> 485
      //   483: aconst_null
      //   484: astore_1
      //   485: aload_0
      //   486: aload_2
      //   487: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   490: aload_3
      //   491: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   494: putfield condition_ : Ljava/lang/Object;
      //   497: aload_1
      //   498: ifnull -> 521
      //   501: aload_1
      //   502: aload_0
      //   503: getfield condition_ : Ljava/lang/Object;
      //   506: checkcast com/google/developers/mobile/targeting/proto/Conditions$FalseCondition
      //   509: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   512: pop
      //   513: aload_0
      //   514: aload_1
      //   515: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   518: putfield condition_ : Ljava/lang/Object;
      //   521: aload_0
      //   522: bipush #17
      //   524: putfield conditionCase_ : I
      //   527: goto -> 123
      //   530: aload_0
      //   531: getfield conditionCase_ : I
      //   534: bipush #16
      //   536: if_icmpne -> 556
      //   539: aload_0
      //   540: getfield condition_ : Ljava/lang/Object;
      //   543: checkcast com/google/developers/mobile/targeting/proto/Conditions$TrueCondition
      //   546: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   549: checkcast com/google/developers/mobile/targeting/proto/Conditions$TrueCondition$Builder
      //   552: astore_1
      //   553: goto -> 558
      //   556: aconst_null
      //   557: astore_1
      //   558: aload_0
      //   559: aload_2
      //   560: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   563: aload_3
      //   564: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   567: putfield condition_ : Ljava/lang/Object;
      //   570: aload_1
      //   571: ifnull -> 594
      //   574: aload_1
      //   575: aload_0
      //   576: getfield condition_ : Ljava/lang/Object;
      //   579: checkcast com/google/developers/mobile/targeting/proto/Conditions$TrueCondition
      //   582: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   585: pop
      //   586: aload_0
      //   587: aload_1
      //   588: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   591: putfield condition_ : Ljava/lang/Object;
      //   594: aload_0
      //   595: bipush #16
      //   597: putfield conditionCase_ : I
      //   600: goto -> 123
      //   603: aload_0
      //   604: getfield conditionCase_ : I
      //   607: bipush #15
      //   609: if_icmpne -> 629
      //   612: aload_0
      //   613: getfield condition_ : Ljava/lang/Object;
      //   616: checkcast com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition
      //   619: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   622: checkcast com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$Builder
      //   625: astore_1
      //   626: goto -> 631
      //   629: aconst_null
      //   630: astore_1
      //   631: aload_0
      //   632: aload_2
      //   633: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   636: aload_3
      //   637: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   640: putfield condition_ : Ljava/lang/Object;
      //   643: aload_1
      //   644: ifnull -> 667
      //   647: aload_1
      //   648: aload_0
      //   649: getfield condition_ : Ljava/lang/Object;
      //   652: checkcast com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition
      //   655: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   658: pop
      //   659: aload_0
      //   660: aload_1
      //   661: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   664: putfield condition_ : Ljava/lang/Object;
      //   667: aload_0
      //   668: bipush #15
      //   670: putfield conditionCase_ : I
      //   673: goto -> 123
      //   676: aload_0
      //   677: getfield conditionCase_ : I
      //   680: bipush #14
      //   682: if_icmpne -> 702
      //   685: aload_0
      //   686: getfield condition_ : Ljava/lang/Object;
      //   689: checkcast com/google/developers/mobile/targeting/proto/Conditions$PercentCondition
      //   692: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   695: checkcast com/google/developers/mobile/targeting/proto/Conditions$PercentCondition$Builder
      //   698: astore_1
      //   699: goto -> 704
      //   702: aconst_null
      //   703: astore_1
      //   704: aload_0
      //   705: aload_2
      //   706: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   709: aload_3
      //   710: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   713: putfield condition_ : Ljava/lang/Object;
      //   716: aload_1
      //   717: ifnull -> 740
      //   720: aload_1
      //   721: aload_0
      //   722: getfield condition_ : Ljava/lang/Object;
      //   725: checkcast com/google/developers/mobile/targeting/proto/Conditions$PercentCondition
      //   728: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   731: pop
      //   732: aload_0
      //   733: aload_1
      //   734: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   737: putfield condition_ : Ljava/lang/Object;
      //   740: aload_0
      //   741: bipush #14
      //   743: putfield conditionCase_ : I
      //   746: goto -> 123
      //   749: aload_0
      //   750: getfield conditionCase_ : I
      //   753: bipush #13
      //   755: if_icmpne -> 775
      //   758: aload_0
      //   759: getfield condition_ : Ljava/lang/Object;
      //   762: checkcast com/google/developers/mobile/targeting/proto/Conditions$TopicCondition
      //   765: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   768: checkcast com/google/developers/mobile/targeting/proto/Conditions$TopicCondition$Builder
      //   771: astore_1
      //   772: goto -> 777
      //   775: aconst_null
      //   776: astore_1
      //   777: aload_0
      //   778: aload_2
      //   779: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   782: aload_3
      //   783: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   786: putfield condition_ : Ljava/lang/Object;
      //   789: aload_1
      //   790: ifnull -> 813
      //   793: aload_1
      //   794: aload_0
      //   795: getfield condition_ : Ljava/lang/Object;
      //   798: checkcast com/google/developers/mobile/targeting/proto/Conditions$TopicCondition
      //   801: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   804: pop
      //   805: aload_0
      //   806: aload_1
      //   807: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   810: putfield condition_ : Ljava/lang/Object;
      //   813: aload_0
      //   814: bipush #13
      //   816: putfield conditionCase_ : I
      //   819: goto -> 123
      //   822: aload_0
      //   823: getfield conditionCase_ : I
      //   826: bipush #12
      //   828: if_icmpne -> 848
      //   831: aload_0
      //   832: getfield condition_ : Ljava/lang/Object;
      //   835: checkcast com/google/developers/mobile/targeting/proto/Conditions$AnalyticsUserPropertyCondition
      //   838: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   841: checkcast com/google/developers/mobile/targeting/proto/Conditions$AnalyticsUserPropertyCondition$Builder
      //   844: astore_1
      //   845: goto -> 850
      //   848: aconst_null
      //   849: astore_1
      //   850: aload_0
      //   851: aload_2
      //   852: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   855: aload_3
      //   856: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   859: putfield condition_ : Ljava/lang/Object;
      //   862: aload_1
      //   863: ifnull -> 886
      //   866: aload_1
      //   867: aload_0
      //   868: getfield condition_ : Ljava/lang/Object;
      //   871: checkcast com/google/developers/mobile/targeting/proto/Conditions$AnalyticsUserPropertyCondition
      //   874: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   877: pop
      //   878: aload_0
      //   879: aload_1
      //   880: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   883: putfield condition_ : Ljava/lang/Object;
      //   886: aload_0
      //   887: bipush #12
      //   889: putfield conditionCase_ : I
      //   892: goto -> 123
      //   895: aload_0
      //   896: getfield conditionCase_ : I
      //   899: bipush #10
      //   901: if_icmpne -> 921
      //   904: aload_0
      //   905: getfield condition_ : Ljava/lang/Object;
      //   908: checkcast com/google/developers/mobile/targeting/proto/Conditions$OsTypeCondition
      //   911: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   914: checkcast com/google/developers/mobile/targeting/proto/Conditions$OsTypeCondition$Builder
      //   917: astore_1
      //   918: goto -> 923
      //   921: aconst_null
      //   922: astore_1
      //   923: aload_0
      //   924: aload_2
      //   925: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   928: aload_3
      //   929: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   932: putfield condition_ : Ljava/lang/Object;
      //   935: aload_1
      //   936: ifnull -> 959
      //   939: aload_1
      //   940: aload_0
      //   941: getfield condition_ : Ljava/lang/Object;
      //   944: checkcast com/google/developers/mobile/targeting/proto/Conditions$OsTypeCondition
      //   947: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   950: pop
      //   951: aload_0
      //   952: aload_1
      //   953: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   956: putfield condition_ : Ljava/lang/Object;
      //   959: aload_0
      //   960: bipush #10
      //   962: putfield conditionCase_ : I
      //   965: goto -> 123
      //   968: aload_0
      //   969: getfield conditionCase_ : I
      //   972: bipush #9
      //   974: if_icmpne -> 994
      //   977: aload_0
      //   978: getfield condition_ : Ljava/lang/Object;
      //   981: checkcast com/google/developers/mobile/targeting/proto/Conditions$DeviceCountryCondition
      //   984: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   987: checkcast com/google/developers/mobile/targeting/proto/Conditions$DeviceCountryCondition$Builder
      //   990: astore_1
      //   991: goto -> 996
      //   994: aconst_null
      //   995: astore_1
      //   996: aload_0
      //   997: aload_2
      //   998: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   1001: aload_3
      //   1002: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   1005: putfield condition_ : Ljava/lang/Object;
      //   1008: aload_1
      //   1009: ifnull -> 1032
      //   1012: aload_1
      //   1013: aload_0
      //   1014: getfield condition_ : Ljava/lang/Object;
      //   1017: checkcast com/google/developers/mobile/targeting/proto/Conditions$DeviceCountryCondition
      //   1020: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   1023: pop
      //   1024: aload_0
      //   1025: aload_1
      //   1026: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   1029: putfield condition_ : Ljava/lang/Object;
      //   1032: aload_0
      //   1033: bipush #9
      //   1035: putfield conditionCase_ : I
      //   1038: goto -> 123
      //   1041: aload_0
      //   1042: getfield conditionCase_ : I
      //   1045: bipush #8
      //   1047: if_icmpne -> 1067
      //   1050: aload_0
      //   1051: getfield condition_ : Ljava/lang/Object;
      //   1054: checkcast com/google/developers/mobile/targeting/proto/Conditions$DeviceLanguageCondition
      //   1057: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   1060: checkcast com/google/developers/mobile/targeting/proto/Conditions$DeviceLanguageCondition$Builder
      //   1063: astore_1
      //   1064: goto -> 1069
      //   1067: aconst_null
      //   1068: astore_1
      //   1069: aload_0
      //   1070: aload_2
      //   1071: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   1074: aload_3
      //   1075: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   1078: putfield condition_ : Ljava/lang/Object;
      //   1081: aload_1
      //   1082: ifnull -> 1105
      //   1085: aload_1
      //   1086: aload_0
      //   1087: getfield condition_ : Ljava/lang/Object;
      //   1090: checkcast com/google/developers/mobile/targeting/proto/Conditions$DeviceLanguageCondition
      //   1093: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   1096: pop
      //   1097: aload_0
      //   1098: aload_1
      //   1099: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   1102: putfield condition_ : Ljava/lang/Object;
      //   1105: aload_0
      //   1106: bipush #8
      //   1108: putfield conditionCase_ : I
      //   1111: goto -> 123
      //   1114: aload_0
      //   1115: getfield conditionCase_ : I
      //   1118: bipush #7
      //   1120: if_icmpne -> 1140
      //   1123: aload_0
      //   1124: getfield condition_ : Ljava/lang/Object;
      //   1127: checkcast com/google/developers/mobile/targeting/proto/Conditions$AnalyticsAudienceCondition
      //   1130: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   1133: checkcast com/google/developers/mobile/targeting/proto/Conditions$AnalyticsAudienceCondition$Builder
      //   1136: astore_1
      //   1137: goto -> 1142
      //   1140: aconst_null
      //   1141: astore_1
      //   1142: aload_0
      //   1143: aload_2
      //   1144: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   1147: aload_3
      //   1148: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   1151: putfield condition_ : Ljava/lang/Object;
      //   1154: aload_1
      //   1155: ifnull -> 1178
      //   1158: aload_1
      //   1159: aload_0
      //   1160: getfield condition_ : Ljava/lang/Object;
      //   1163: checkcast com/google/developers/mobile/targeting/proto/Conditions$AnalyticsAudienceCondition
      //   1166: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   1169: pop
      //   1170: aload_0
      //   1171: aload_1
      //   1172: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   1175: putfield condition_ : Ljava/lang/Object;
      //   1178: aload_0
      //   1179: bipush #7
      //   1181: putfield conditionCase_ : I
      //   1184: goto -> 123
      //   1187: aload_0
      //   1188: getfield conditionCase_ : I
      //   1191: bipush #6
      //   1193: if_icmpne -> 1213
      //   1196: aload_0
      //   1197: getfield condition_ : Ljava/lang/Object;
      //   1200: checkcast com/google/developers/mobile/targeting/proto/Conditions$FirebaseAppIdCondition
      //   1203: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   1206: checkcast com/google/developers/mobile/targeting/proto/Conditions$FirebaseAppIdCondition$Builder
      //   1209: astore_1
      //   1210: goto -> 1215
      //   1213: aconst_null
      //   1214: astore_1
      //   1215: aload_0
      //   1216: aload_2
      //   1217: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   1220: aload_3
      //   1221: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   1224: putfield condition_ : Ljava/lang/Object;
      //   1227: aload_1
      //   1228: ifnull -> 1251
      //   1231: aload_1
      //   1232: aload_0
      //   1233: getfield condition_ : Ljava/lang/Object;
      //   1236: checkcast com/google/developers/mobile/targeting/proto/Conditions$FirebaseAppIdCondition
      //   1239: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   1242: pop
      //   1243: aload_0
      //   1244: aload_1
      //   1245: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   1248: putfield condition_ : Ljava/lang/Object;
      //   1251: aload_0
      //   1252: bipush #6
      //   1254: putfield conditionCase_ : I
      //   1257: goto -> 123
      //   1260: aload_0
      //   1261: getfield conditionCase_ : I
      //   1264: iconst_5
      //   1265: if_icmpne -> 1285
      //   1268: aload_0
      //   1269: getfield condition_ : Ljava/lang/Object;
      //   1272: checkcast com/google/developers/mobile/targeting/proto/Conditions$AppVersionCondition
      //   1275: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   1278: checkcast com/google/developers/mobile/targeting/proto/Conditions$AppVersionCondition$Builder
      //   1281: astore_1
      //   1282: goto -> 1287
      //   1285: aconst_null
      //   1286: astore_1
      //   1287: aload_0
      //   1288: aload_2
      //   1289: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   1292: aload_3
      //   1293: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   1296: putfield condition_ : Ljava/lang/Object;
      //   1299: aload_1
      //   1300: ifnull -> 1323
      //   1303: aload_1
      //   1304: aload_0
      //   1305: getfield condition_ : Ljava/lang/Object;
      //   1308: checkcast com/google/developers/mobile/targeting/proto/Conditions$AppVersionCondition
      //   1311: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   1314: pop
      //   1315: aload_0
      //   1316: aload_1
      //   1317: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   1320: putfield condition_ : Ljava/lang/Object;
      //   1323: aload_0
      //   1324: iconst_5
      //   1325: putfield conditionCase_ : I
      //   1328: goto -> 123
      //   1331: aload_0
      //   1332: getfield conditionCase_ : I
      //   1335: iconst_4
      //   1336: if_icmpne -> 1356
      //   1339: aload_0
      //   1340: getfield condition_ : Ljava/lang/Object;
      //   1343: checkcast com/google/developers/mobile/targeting/proto/Conditions$DateTimeCondition
      //   1346: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   1349: checkcast com/google/developers/mobile/targeting/proto/Conditions$DateTimeCondition$Builder
      //   1352: astore_1
      //   1353: goto -> 1358
      //   1356: aconst_null
      //   1357: astore_1
      //   1358: aload_0
      //   1359: aload_2
      //   1360: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   1363: aload_3
      //   1364: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   1367: putfield condition_ : Ljava/lang/Object;
      //   1370: aload_1
      //   1371: ifnull -> 1394
      //   1374: aload_1
      //   1375: aload_0
      //   1376: getfield condition_ : Ljava/lang/Object;
      //   1379: checkcast com/google/developers/mobile/targeting/proto/Conditions$DateTimeCondition
      //   1382: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   1385: pop
      //   1386: aload_0
      //   1387: aload_1
      //   1388: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   1391: putfield condition_ : Ljava/lang/Object;
      //   1394: aload_0
      //   1395: iconst_4
      //   1396: putfield conditionCase_ : I
      //   1399: goto -> 123
      //   1402: aload_0
      //   1403: getfield conditionCase_ : I
      //   1406: iconst_3
      //   1407: if_icmpne -> 1427
      //   1410: aload_0
      //   1411: getfield condition_ : Ljava/lang/Object;
      //   1414: checkcast com/google/developers/mobile/targeting/proto/Conditions$NotCondition
      //   1417: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   1420: checkcast com/google/developers/mobile/targeting/proto/Conditions$NotCondition$Builder
      //   1423: astore_1
      //   1424: goto -> 1429
      //   1427: aconst_null
      //   1428: astore_1
      //   1429: aload_0
      //   1430: aload_2
      //   1431: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   1434: aload_3
      //   1435: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   1438: putfield condition_ : Ljava/lang/Object;
      //   1441: aload_1
      //   1442: ifnull -> 1468
      //   1445: aload_1
      //   1446: aload_0
      //   1447: getfield condition_ : Ljava/lang/Object;
      //   1450: checkcast com/google/developers/mobile/targeting/proto/Conditions$NotCondition
      //   1453: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   1456: pop
      //   1457: aload_0
      //   1458: aload_1
      //   1459: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   1462: putfield condition_ : Ljava/lang/Object;
      //   1465: goto -> 1468
      //   1468: aload_0
      //   1469: iconst_3
      //   1470: putfield conditionCase_ : I
      //   1473: goto -> 123
      //   1476: aload_0
      //   1477: getfield conditionCase_ : I
      //   1480: iconst_2
      //   1481: if_icmpne -> 1501
      //   1484: aload_0
      //   1485: getfield condition_ : Ljava/lang/Object;
      //   1488: checkcast com/google/developers/mobile/targeting/proto/Conditions$OrCondition
      //   1491: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   1494: checkcast com/google/developers/mobile/targeting/proto/Conditions$OrCondition$Builder
      //   1497: astore_1
      //   1498: goto -> 1503
      //   1501: aconst_null
      //   1502: astore_1
      //   1503: aload_0
      //   1504: aload_2
      //   1505: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   1508: aload_3
      //   1509: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   1512: putfield condition_ : Ljava/lang/Object;
      //   1515: aload_1
      //   1516: ifnull -> 1542
      //   1519: aload_1
      //   1520: aload_0
      //   1521: getfield condition_ : Ljava/lang/Object;
      //   1524: checkcast com/google/developers/mobile/targeting/proto/Conditions$OrCondition
      //   1527: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   1530: pop
      //   1531: aload_0
      //   1532: aload_1
      //   1533: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   1536: putfield condition_ : Ljava/lang/Object;
      //   1539: goto -> 1542
      //   1542: aload_0
      //   1543: iconst_2
      //   1544: putfield conditionCase_ : I
      //   1547: goto -> 123
      //   1550: aload_0
      //   1551: getfield conditionCase_ : I
      //   1554: iconst_1
      //   1555: if_icmpne -> 1575
      //   1558: aload_0
      //   1559: getfield condition_ : Ljava/lang/Object;
      //   1562: checkcast com/google/developers/mobile/targeting/proto/Conditions$AndCondition
      //   1565: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   1568: checkcast com/google/developers/mobile/targeting/proto/Conditions$AndCondition$Builder
      //   1571: astore_1
      //   1572: goto -> 1577
      //   1575: aconst_null
      //   1576: astore_1
      //   1577: aload_0
      //   1578: aload_2
      //   1579: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   1582: aload_3
      //   1583: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   1586: putfield condition_ : Ljava/lang/Object;
      //   1589: aload_1
      //   1590: ifnull -> 1616
      //   1593: aload_1
      //   1594: aload_0
      //   1595: getfield condition_ : Ljava/lang/Object;
      //   1598: checkcast com/google/developers/mobile/targeting/proto/Conditions$AndCondition
      //   1601: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   1604: pop
      //   1605: aload_0
      //   1606: aload_1
      //   1607: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   1610: putfield condition_ : Ljava/lang/Object;
      //   1613: goto -> 1616
      //   1616: aload_0
      //   1617: iconst_1
      //   1618: putfield conditionCase_ : I
      //   1621: goto -> 123
      //   1624: iconst_1
      //   1625: istore #4
      //   1627: goto -> 123
      //   1630: iload #6
      //   1632: ifne -> 123
      //   1635: iconst_1
      //   1636: istore #4
      //   1638: goto -> 123
      //   1641: astore_1
      //   1642: goto -> 1689
      //   1645: astore_2
      //   1646: new java/lang/RuntimeException
      //   1649: astore_1
      //   1650: new com/google/protobuf/InvalidProtocolBufferException
      //   1653: astore_3
      //   1654: aload_3
      //   1655: aload_2
      //   1656: invokevirtual getMessage : ()Ljava/lang/String;
      //   1659: invokespecial <init> : (Ljava/lang/String;)V
      //   1662: aload_1
      //   1663: aload_3
      //   1664: aload_0
      //   1665: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   1668: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   1671: aload_1
      //   1672: athrow
      //   1673: astore_2
      //   1674: new java/lang/RuntimeException
      //   1677: astore_1
      //   1678: aload_1
      //   1679: aload_2
      //   1680: aload_0
      //   1681: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   1684: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   1687: aload_1
      //   1688: athrow
      //   1689: aload_1
      //   1690: athrow
      //   1691: getstatic com/google/developers/mobile/targeting/proto/Conditions$Condition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$Condition;
      //   1694: areturn
      //   1695: aload_2
      //   1696: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   1699: astore_1
      //   1700: aload_3
      //   1701: checkcast com/google/developers/mobile/targeting/proto/Conditions$Condition
      //   1704: astore_2
      //   1705: getstatic com/google/developers/mobile/targeting/proto/Conditions$1.$SwitchMap$com$google$developers$mobile$targeting$proto$Conditions$Condition$ConditionCase : [I
      //   1708: aload_2
      //   1709: invokevirtual getConditionCase : ()Lcom/google/developers/mobile/targeting/proto/Conditions$Condition$ConditionCase;
      //   1712: invokevirtual ordinal : ()I
      //   1715: iaload
      //   1716: tableswitch default -> 1808, 1 -> 2531, 2 -> 2491, 3 -> 2451, 4 -> 2410, 5 -> 2369, 6 -> 2329, 7 -> 2289, 8 -> 2248, 9 -> 2207, 10 -> 2166, 11 -> 2125, 12 -> 2084, 13 -> 2043, 14 -> 2002, 15 -> 1961, 16 -> 1920, 17 -> 1879, 18 -> 1838, 19 -> 1811
      //   1808: goto -> 2572
      //   1811: aload_0
      //   1812: getfield conditionCase_ : I
      //   1815: ifeq -> 1824
      //   1818: iconst_1
      //   1819: istore #6
      //   1821: goto -> 1827
      //   1824: iconst_0
      //   1825: istore #6
      //   1827: aload_1
      //   1828: iload #6
      //   1830: invokeinterface visitOneofNotSet : (Z)V
      //   1835: goto -> 2572
      //   1838: aload_0
      //   1839: getfield conditionCase_ : I
      //   1842: bipush #19
      //   1844: if_icmpne -> 1853
      //   1847: iconst_1
      //   1848: istore #6
      //   1850: goto -> 1856
      //   1853: iconst_0
      //   1854: istore #6
      //   1856: aload_0
      //   1857: aload_1
      //   1858: iload #6
      //   1860: aload_0
      //   1861: getfield condition_ : Ljava/lang/Object;
      //   1864: aload_2
      //   1865: getfield condition_ : Ljava/lang/Object;
      //   1868: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1873: putfield condition_ : Ljava/lang/Object;
      //   1876: goto -> 2572
      //   1879: aload_0
      //   1880: getfield conditionCase_ : I
      //   1883: bipush #18
      //   1885: if_icmpne -> 1894
      //   1888: iconst_1
      //   1889: istore #6
      //   1891: goto -> 1897
      //   1894: iconst_0
      //   1895: istore #6
      //   1897: aload_0
      //   1898: aload_1
      //   1899: iload #6
      //   1901: aload_0
      //   1902: getfield condition_ : Ljava/lang/Object;
      //   1905: aload_2
      //   1906: getfield condition_ : Ljava/lang/Object;
      //   1909: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1914: putfield condition_ : Ljava/lang/Object;
      //   1917: goto -> 2572
      //   1920: aload_0
      //   1921: getfield conditionCase_ : I
      //   1924: bipush #15
      //   1926: if_icmpne -> 1935
      //   1929: iconst_1
      //   1930: istore #6
      //   1932: goto -> 1938
      //   1935: iconst_0
      //   1936: istore #6
      //   1938: aload_0
      //   1939: aload_1
      //   1940: iload #6
      //   1942: aload_0
      //   1943: getfield condition_ : Ljava/lang/Object;
      //   1946: aload_2
      //   1947: getfield condition_ : Ljava/lang/Object;
      //   1950: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1955: putfield condition_ : Ljava/lang/Object;
      //   1958: goto -> 2572
      //   1961: aload_0
      //   1962: getfield conditionCase_ : I
      //   1965: bipush #14
      //   1967: if_icmpne -> 1976
      //   1970: iconst_1
      //   1971: istore #6
      //   1973: goto -> 1979
      //   1976: iconst_0
      //   1977: istore #6
      //   1979: aload_0
      //   1980: aload_1
      //   1981: iload #6
      //   1983: aload_0
      //   1984: getfield condition_ : Ljava/lang/Object;
      //   1987: aload_2
      //   1988: getfield condition_ : Ljava/lang/Object;
      //   1991: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1996: putfield condition_ : Ljava/lang/Object;
      //   1999: goto -> 2572
      //   2002: aload_0
      //   2003: getfield conditionCase_ : I
      //   2006: bipush #13
      //   2008: if_icmpne -> 2017
      //   2011: iconst_1
      //   2012: istore #6
      //   2014: goto -> 2020
      //   2017: iconst_0
      //   2018: istore #6
      //   2020: aload_0
      //   2021: aload_1
      //   2022: iload #6
      //   2024: aload_0
      //   2025: getfield condition_ : Ljava/lang/Object;
      //   2028: aload_2
      //   2029: getfield condition_ : Ljava/lang/Object;
      //   2032: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2037: putfield condition_ : Ljava/lang/Object;
      //   2040: goto -> 2572
      //   2043: aload_0
      //   2044: getfield conditionCase_ : I
      //   2047: bipush #12
      //   2049: if_icmpne -> 2058
      //   2052: iconst_1
      //   2053: istore #6
      //   2055: goto -> 2061
      //   2058: iconst_0
      //   2059: istore #6
      //   2061: aload_0
      //   2062: aload_1
      //   2063: iload #6
      //   2065: aload_0
      //   2066: getfield condition_ : Ljava/lang/Object;
      //   2069: aload_2
      //   2070: getfield condition_ : Ljava/lang/Object;
      //   2073: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2078: putfield condition_ : Ljava/lang/Object;
      //   2081: goto -> 2572
      //   2084: aload_0
      //   2085: getfield conditionCase_ : I
      //   2088: bipush #10
      //   2090: if_icmpne -> 2099
      //   2093: iconst_1
      //   2094: istore #6
      //   2096: goto -> 2102
      //   2099: iconst_0
      //   2100: istore #6
      //   2102: aload_0
      //   2103: aload_1
      //   2104: iload #6
      //   2106: aload_0
      //   2107: getfield condition_ : Ljava/lang/Object;
      //   2110: aload_2
      //   2111: getfield condition_ : Ljava/lang/Object;
      //   2114: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2119: putfield condition_ : Ljava/lang/Object;
      //   2122: goto -> 2572
      //   2125: aload_0
      //   2126: getfield conditionCase_ : I
      //   2129: bipush #9
      //   2131: if_icmpne -> 2140
      //   2134: iconst_1
      //   2135: istore #6
      //   2137: goto -> 2143
      //   2140: iconst_0
      //   2141: istore #6
      //   2143: aload_0
      //   2144: aload_1
      //   2145: iload #6
      //   2147: aload_0
      //   2148: getfield condition_ : Ljava/lang/Object;
      //   2151: aload_2
      //   2152: getfield condition_ : Ljava/lang/Object;
      //   2155: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2160: putfield condition_ : Ljava/lang/Object;
      //   2163: goto -> 2572
      //   2166: aload_0
      //   2167: getfield conditionCase_ : I
      //   2170: bipush #8
      //   2172: if_icmpne -> 2181
      //   2175: iconst_1
      //   2176: istore #6
      //   2178: goto -> 2184
      //   2181: iconst_0
      //   2182: istore #6
      //   2184: aload_0
      //   2185: aload_1
      //   2186: iload #6
      //   2188: aload_0
      //   2189: getfield condition_ : Ljava/lang/Object;
      //   2192: aload_2
      //   2193: getfield condition_ : Ljava/lang/Object;
      //   2196: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2201: putfield condition_ : Ljava/lang/Object;
      //   2204: goto -> 2572
      //   2207: aload_0
      //   2208: getfield conditionCase_ : I
      //   2211: bipush #7
      //   2213: if_icmpne -> 2222
      //   2216: iconst_1
      //   2217: istore #6
      //   2219: goto -> 2225
      //   2222: iconst_0
      //   2223: istore #6
      //   2225: aload_0
      //   2226: aload_1
      //   2227: iload #6
      //   2229: aload_0
      //   2230: getfield condition_ : Ljava/lang/Object;
      //   2233: aload_2
      //   2234: getfield condition_ : Ljava/lang/Object;
      //   2237: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2242: putfield condition_ : Ljava/lang/Object;
      //   2245: goto -> 2572
      //   2248: aload_0
      //   2249: getfield conditionCase_ : I
      //   2252: bipush #6
      //   2254: if_icmpne -> 2263
      //   2257: iconst_1
      //   2258: istore #6
      //   2260: goto -> 2266
      //   2263: iconst_0
      //   2264: istore #6
      //   2266: aload_0
      //   2267: aload_1
      //   2268: iload #6
      //   2270: aload_0
      //   2271: getfield condition_ : Ljava/lang/Object;
      //   2274: aload_2
      //   2275: getfield condition_ : Ljava/lang/Object;
      //   2278: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2283: putfield condition_ : Ljava/lang/Object;
      //   2286: goto -> 2572
      //   2289: aload_0
      //   2290: getfield conditionCase_ : I
      //   2293: iconst_5
      //   2294: if_icmpne -> 2303
      //   2297: iconst_1
      //   2298: istore #6
      //   2300: goto -> 2306
      //   2303: iconst_0
      //   2304: istore #6
      //   2306: aload_0
      //   2307: aload_1
      //   2308: iload #6
      //   2310: aload_0
      //   2311: getfield condition_ : Ljava/lang/Object;
      //   2314: aload_2
      //   2315: getfield condition_ : Ljava/lang/Object;
      //   2318: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2323: putfield condition_ : Ljava/lang/Object;
      //   2326: goto -> 2572
      //   2329: aload_0
      //   2330: getfield conditionCase_ : I
      //   2333: iconst_4
      //   2334: if_icmpne -> 2343
      //   2337: iconst_1
      //   2338: istore #6
      //   2340: goto -> 2346
      //   2343: iconst_0
      //   2344: istore #6
      //   2346: aload_0
      //   2347: aload_1
      //   2348: iload #6
      //   2350: aload_0
      //   2351: getfield condition_ : Ljava/lang/Object;
      //   2354: aload_2
      //   2355: getfield condition_ : Ljava/lang/Object;
      //   2358: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2363: putfield condition_ : Ljava/lang/Object;
      //   2366: goto -> 2572
      //   2369: aload_0
      //   2370: getfield conditionCase_ : I
      //   2373: bipush #17
      //   2375: if_icmpne -> 2384
      //   2378: iconst_1
      //   2379: istore #6
      //   2381: goto -> 2387
      //   2384: iconst_0
      //   2385: istore #6
      //   2387: aload_0
      //   2388: aload_1
      //   2389: iload #6
      //   2391: aload_0
      //   2392: getfield condition_ : Ljava/lang/Object;
      //   2395: aload_2
      //   2396: getfield condition_ : Ljava/lang/Object;
      //   2399: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2404: putfield condition_ : Ljava/lang/Object;
      //   2407: goto -> 2572
      //   2410: aload_0
      //   2411: getfield conditionCase_ : I
      //   2414: bipush #16
      //   2416: if_icmpne -> 2425
      //   2419: iconst_1
      //   2420: istore #6
      //   2422: goto -> 2428
      //   2425: iconst_0
      //   2426: istore #6
      //   2428: aload_0
      //   2429: aload_1
      //   2430: iload #6
      //   2432: aload_0
      //   2433: getfield condition_ : Ljava/lang/Object;
      //   2436: aload_2
      //   2437: getfield condition_ : Ljava/lang/Object;
      //   2440: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2445: putfield condition_ : Ljava/lang/Object;
      //   2448: goto -> 2572
      //   2451: aload_0
      //   2452: getfield conditionCase_ : I
      //   2455: iconst_3
      //   2456: if_icmpne -> 2465
      //   2459: iconst_1
      //   2460: istore #6
      //   2462: goto -> 2468
      //   2465: iconst_0
      //   2466: istore #6
      //   2468: aload_0
      //   2469: aload_1
      //   2470: iload #6
      //   2472: aload_0
      //   2473: getfield condition_ : Ljava/lang/Object;
      //   2476: aload_2
      //   2477: getfield condition_ : Ljava/lang/Object;
      //   2480: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2485: putfield condition_ : Ljava/lang/Object;
      //   2488: goto -> 2572
      //   2491: aload_0
      //   2492: getfield conditionCase_ : I
      //   2495: iconst_2
      //   2496: if_icmpne -> 2505
      //   2499: iconst_1
      //   2500: istore #6
      //   2502: goto -> 2508
      //   2505: iconst_0
      //   2506: istore #6
      //   2508: aload_0
      //   2509: aload_1
      //   2510: iload #6
      //   2512: aload_0
      //   2513: getfield condition_ : Ljava/lang/Object;
      //   2516: aload_2
      //   2517: getfield condition_ : Ljava/lang/Object;
      //   2520: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2525: putfield condition_ : Ljava/lang/Object;
      //   2528: goto -> 2572
      //   2531: aload_0
      //   2532: getfield conditionCase_ : I
      //   2535: istore #4
      //   2537: iconst_1
      //   2538: istore #6
      //   2540: iload #4
      //   2542: iconst_1
      //   2543: if_icmpne -> 2549
      //   2546: goto -> 2552
      //   2549: iconst_0
      //   2550: istore #6
      //   2552: aload_0
      //   2553: aload_1
      //   2554: iload #6
      //   2556: aload_0
      //   2557: getfield condition_ : Ljava/lang/Object;
      //   2560: aload_2
      //   2561: getfield condition_ : Ljava/lang/Object;
      //   2564: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2569: putfield condition_ : Ljava/lang/Object;
      //   2572: aload_1
      //   2573: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   2576: if_acmpne -> 2596
      //   2579: aload_2
      //   2580: getfield conditionCase_ : I
      //   2583: istore #4
      //   2585: iload #4
      //   2587: ifeq -> 2596
      //   2590: aload_0
      //   2591: iload #4
      //   2593: putfield conditionCase_ : I
      //   2596: aload_0
      //   2597: areturn
      //   2598: new com/google/developers/mobile/targeting/proto/Conditions$Condition$Builder
      //   2601: dup
      //   2602: aconst_null
      //   2603: invokespecial <init> : (Lcom/google/developers/mobile/targeting/proto/Conditions$1;)V
      //   2606: areturn
      //   2607: aconst_null
      //   2608: areturn
      //   2609: getstatic com/google/developers/mobile/targeting/proto/Conditions$Condition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$Condition;
      //   2612: areturn
      //   2613: new com/google/developers/mobile/targeting/proto/Conditions$Condition
      //   2616: dup
      //   2617: invokespecial <init> : ()V
      //   2620: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	1673	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	1645	java/io/IOException
      //   128	134	1641	finally
      //   300	308	1673	com/google/protobuf/InvalidProtocolBufferException
      //   300	308	1645	java/io/IOException
      //   300	308	1641	finally
      //   311	334	1673	com/google/protobuf/InvalidProtocolBufferException
      //   311	334	1645	java/io/IOException
      //   311	334	1641	finally
      //   339	351	1673	com/google/protobuf/InvalidProtocolBufferException
      //   339	351	1645	java/io/IOException
      //   339	351	1641	finally
      //   355	375	1673	com/google/protobuf/InvalidProtocolBufferException
      //   355	375	1645	java/io/IOException
      //   355	375	1641	finally
      //   375	381	1673	com/google/protobuf/InvalidProtocolBufferException
      //   375	381	1645	java/io/IOException
      //   375	381	1641	finally
      //   384	407	1673	com/google/protobuf/InvalidProtocolBufferException
      //   384	407	1645	java/io/IOException
      //   384	407	1641	finally
      //   412	424	1673	com/google/protobuf/InvalidProtocolBufferException
      //   412	424	1645	java/io/IOException
      //   412	424	1641	finally
      //   428	448	1673	com/google/protobuf/InvalidProtocolBufferException
      //   428	448	1645	java/io/IOException
      //   428	448	1641	finally
      //   448	454	1673	com/google/protobuf/InvalidProtocolBufferException
      //   448	454	1645	java/io/IOException
      //   448	454	1641	finally
      //   457	480	1673	com/google/protobuf/InvalidProtocolBufferException
      //   457	480	1645	java/io/IOException
      //   457	480	1641	finally
      //   485	497	1673	com/google/protobuf/InvalidProtocolBufferException
      //   485	497	1645	java/io/IOException
      //   485	497	1641	finally
      //   501	521	1673	com/google/protobuf/InvalidProtocolBufferException
      //   501	521	1645	java/io/IOException
      //   501	521	1641	finally
      //   521	527	1673	com/google/protobuf/InvalidProtocolBufferException
      //   521	527	1645	java/io/IOException
      //   521	527	1641	finally
      //   530	553	1673	com/google/protobuf/InvalidProtocolBufferException
      //   530	553	1645	java/io/IOException
      //   530	553	1641	finally
      //   558	570	1673	com/google/protobuf/InvalidProtocolBufferException
      //   558	570	1645	java/io/IOException
      //   558	570	1641	finally
      //   574	594	1673	com/google/protobuf/InvalidProtocolBufferException
      //   574	594	1645	java/io/IOException
      //   574	594	1641	finally
      //   594	600	1673	com/google/protobuf/InvalidProtocolBufferException
      //   594	600	1645	java/io/IOException
      //   594	600	1641	finally
      //   603	626	1673	com/google/protobuf/InvalidProtocolBufferException
      //   603	626	1645	java/io/IOException
      //   603	626	1641	finally
      //   631	643	1673	com/google/protobuf/InvalidProtocolBufferException
      //   631	643	1645	java/io/IOException
      //   631	643	1641	finally
      //   647	667	1673	com/google/protobuf/InvalidProtocolBufferException
      //   647	667	1645	java/io/IOException
      //   647	667	1641	finally
      //   667	673	1673	com/google/protobuf/InvalidProtocolBufferException
      //   667	673	1645	java/io/IOException
      //   667	673	1641	finally
      //   676	699	1673	com/google/protobuf/InvalidProtocolBufferException
      //   676	699	1645	java/io/IOException
      //   676	699	1641	finally
      //   704	716	1673	com/google/protobuf/InvalidProtocolBufferException
      //   704	716	1645	java/io/IOException
      //   704	716	1641	finally
      //   720	740	1673	com/google/protobuf/InvalidProtocolBufferException
      //   720	740	1645	java/io/IOException
      //   720	740	1641	finally
      //   740	746	1673	com/google/protobuf/InvalidProtocolBufferException
      //   740	746	1645	java/io/IOException
      //   740	746	1641	finally
      //   749	772	1673	com/google/protobuf/InvalidProtocolBufferException
      //   749	772	1645	java/io/IOException
      //   749	772	1641	finally
      //   777	789	1673	com/google/protobuf/InvalidProtocolBufferException
      //   777	789	1645	java/io/IOException
      //   777	789	1641	finally
      //   793	813	1673	com/google/protobuf/InvalidProtocolBufferException
      //   793	813	1645	java/io/IOException
      //   793	813	1641	finally
      //   813	819	1673	com/google/protobuf/InvalidProtocolBufferException
      //   813	819	1645	java/io/IOException
      //   813	819	1641	finally
      //   822	845	1673	com/google/protobuf/InvalidProtocolBufferException
      //   822	845	1645	java/io/IOException
      //   822	845	1641	finally
      //   850	862	1673	com/google/protobuf/InvalidProtocolBufferException
      //   850	862	1645	java/io/IOException
      //   850	862	1641	finally
      //   866	886	1673	com/google/protobuf/InvalidProtocolBufferException
      //   866	886	1645	java/io/IOException
      //   866	886	1641	finally
      //   886	892	1673	com/google/protobuf/InvalidProtocolBufferException
      //   886	892	1645	java/io/IOException
      //   886	892	1641	finally
      //   895	918	1673	com/google/protobuf/InvalidProtocolBufferException
      //   895	918	1645	java/io/IOException
      //   895	918	1641	finally
      //   923	935	1673	com/google/protobuf/InvalidProtocolBufferException
      //   923	935	1645	java/io/IOException
      //   923	935	1641	finally
      //   939	959	1673	com/google/protobuf/InvalidProtocolBufferException
      //   939	959	1645	java/io/IOException
      //   939	959	1641	finally
      //   959	965	1673	com/google/protobuf/InvalidProtocolBufferException
      //   959	965	1645	java/io/IOException
      //   959	965	1641	finally
      //   968	991	1673	com/google/protobuf/InvalidProtocolBufferException
      //   968	991	1645	java/io/IOException
      //   968	991	1641	finally
      //   996	1008	1673	com/google/protobuf/InvalidProtocolBufferException
      //   996	1008	1645	java/io/IOException
      //   996	1008	1641	finally
      //   1012	1032	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1012	1032	1645	java/io/IOException
      //   1012	1032	1641	finally
      //   1032	1038	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1032	1038	1645	java/io/IOException
      //   1032	1038	1641	finally
      //   1041	1064	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1041	1064	1645	java/io/IOException
      //   1041	1064	1641	finally
      //   1069	1081	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1069	1081	1645	java/io/IOException
      //   1069	1081	1641	finally
      //   1085	1105	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1085	1105	1645	java/io/IOException
      //   1085	1105	1641	finally
      //   1105	1111	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1105	1111	1645	java/io/IOException
      //   1105	1111	1641	finally
      //   1114	1137	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1114	1137	1645	java/io/IOException
      //   1114	1137	1641	finally
      //   1142	1154	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1142	1154	1645	java/io/IOException
      //   1142	1154	1641	finally
      //   1158	1178	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1158	1178	1645	java/io/IOException
      //   1158	1178	1641	finally
      //   1178	1184	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1178	1184	1645	java/io/IOException
      //   1178	1184	1641	finally
      //   1187	1210	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1187	1210	1645	java/io/IOException
      //   1187	1210	1641	finally
      //   1215	1227	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1215	1227	1645	java/io/IOException
      //   1215	1227	1641	finally
      //   1231	1251	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1231	1251	1645	java/io/IOException
      //   1231	1251	1641	finally
      //   1251	1257	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1251	1257	1645	java/io/IOException
      //   1251	1257	1641	finally
      //   1260	1282	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1260	1282	1645	java/io/IOException
      //   1260	1282	1641	finally
      //   1287	1299	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1287	1299	1645	java/io/IOException
      //   1287	1299	1641	finally
      //   1303	1323	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1303	1323	1645	java/io/IOException
      //   1303	1323	1641	finally
      //   1323	1328	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1323	1328	1645	java/io/IOException
      //   1323	1328	1641	finally
      //   1331	1353	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1331	1353	1645	java/io/IOException
      //   1331	1353	1641	finally
      //   1358	1370	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1358	1370	1645	java/io/IOException
      //   1358	1370	1641	finally
      //   1374	1394	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1374	1394	1645	java/io/IOException
      //   1374	1394	1641	finally
      //   1394	1399	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1394	1399	1645	java/io/IOException
      //   1394	1399	1641	finally
      //   1402	1424	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1402	1424	1645	java/io/IOException
      //   1402	1424	1641	finally
      //   1429	1441	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1429	1441	1645	java/io/IOException
      //   1429	1441	1641	finally
      //   1445	1465	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1445	1465	1645	java/io/IOException
      //   1445	1465	1641	finally
      //   1468	1473	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1468	1473	1645	java/io/IOException
      //   1468	1473	1641	finally
      //   1476	1498	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1476	1498	1645	java/io/IOException
      //   1476	1498	1641	finally
      //   1503	1515	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1503	1515	1645	java/io/IOException
      //   1503	1515	1641	finally
      //   1519	1539	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1519	1539	1645	java/io/IOException
      //   1519	1539	1641	finally
      //   1542	1547	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1542	1547	1645	java/io/IOException
      //   1542	1547	1641	finally
      //   1550	1572	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1550	1572	1645	java/io/IOException
      //   1550	1572	1641	finally
      //   1577	1589	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1577	1589	1645	java/io/IOException
      //   1577	1589	1641	finally
      //   1593	1613	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1593	1613	1645	java/io/IOException
      //   1593	1613	1641	finally
      //   1616	1621	1673	com/google/protobuf/InvalidProtocolBufferException
      //   1616	1621	1645	java/io/IOException
      //   1616	1621	1641	finally
      //   1646	1673	1641	finally
      //   1674	1689	1641	finally
    }
    
    public Conditions.AbtExperimentCondition getAbtExperiment() {
      return (this.conditionCase_ == 18) ? (Conditions.AbtExperimentCondition)this.condition_ : Conditions.AbtExperimentCondition.getDefaultInstance();
    }
    
    public Conditions.FalseCondition getAlwaysFalse() {
      return (this.conditionCase_ == 17) ? (Conditions.FalseCondition)this.condition_ : Conditions.FalseCondition.getDefaultInstance();
    }
    
    public Conditions.TrueCondition getAlwaysTrue() {
      return (this.conditionCase_ == 16) ? (Conditions.TrueCondition)this.condition_ : Conditions.TrueCondition.getDefaultInstance();
    }
    
    public Conditions.AnalyticsAudienceCondition getAnalyticsAudiences() {
      return (this.conditionCase_ == 7) ? (Conditions.AnalyticsAudienceCondition)this.condition_ : Conditions.AnalyticsAudienceCondition.getDefaultInstance();
    }
    
    public Conditions.AnalyticsUserPropertyCondition getAnalyticsUserProperty() {
      return (this.conditionCase_ == 12) ? (Conditions.AnalyticsUserPropertyCondition)this.condition_ : Conditions.AnalyticsUserPropertyCondition.getDefaultInstance();
    }
    
    public Conditions.AndCondition getAnd() {
      return (this.conditionCase_ == 1) ? (Conditions.AndCondition)this.condition_ : Conditions.AndCondition.getDefaultInstance();
    }
    
    public Conditions.FirebaseAppIdCondition getAppId() {
      return (this.conditionCase_ == 6) ? (Conditions.FirebaseAppIdCondition)this.condition_ : Conditions.FirebaseAppIdCondition.getDefaultInstance();
    }
    
    public Conditions.AppVersionCondition getAppVersion() {
      return (this.conditionCase_ == 5) ? (Conditions.AppVersionCondition)this.condition_ : Conditions.AppVersionCondition.getDefaultInstance();
    }
    
    public ConditionCase getConditionCase() {
      return ConditionCase.forNumber(this.conditionCase_);
    }
    
    public Conditions.DeviceCountryCondition getCountries() {
      return (this.conditionCase_ == 9) ? (Conditions.DeviceCountryCondition)this.condition_ : Conditions.DeviceCountryCondition.getDefaultInstance();
    }
    
    public Conditions.FunctionCondition getFirebaseFunction() {
      return (this.conditionCase_ == 19) ? (Conditions.FunctionCondition)this.condition_ : Conditions.FunctionCondition.getDefaultInstance();
    }
    
    public Conditions.DeviceLanguageCondition getLanguages() {
      return (this.conditionCase_ == 8) ? (Conditions.DeviceLanguageCondition)this.condition_ : Conditions.DeviceLanguageCondition.getDefaultInstance();
    }
    
    public Conditions.NotCondition getNot() {
      return (this.conditionCase_ == 3) ? (Conditions.NotCondition)this.condition_ : Conditions.NotCondition.getDefaultInstance();
    }
    
    public Conditions.OrCondition getOr() {
      return (this.conditionCase_ == 2) ? (Conditions.OrCondition)this.condition_ : Conditions.OrCondition.getDefaultInstance();
    }
    
    public Conditions.OsTypeCondition getOsType() {
      return (this.conditionCase_ == 10) ? (Conditions.OsTypeCondition)this.condition_ : Conditions.OsTypeCondition.getDefaultInstance();
    }
    
    public Conditions.PercentCondition getPercent() {
      return (this.conditionCase_ == 14) ? (Conditions.PercentCondition)this.condition_ : Conditions.PercentCondition.getDefaultInstance();
    }
    
    public Conditions.PredictionsCondition getPredictions() {
      return (this.conditionCase_ == 15) ? (Conditions.PredictionsCondition)this.condition_ : Conditions.PredictionsCondition.getDefaultInstance();
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.conditionCase_ == 1)
        j = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)this.condition_); 
      i = j;
      if (this.conditionCase_ == 2)
        i = j + CodedOutputStream.computeMessageSize(2, (MessageLite)this.condition_); 
      int k = i;
      if (this.conditionCase_ == 3)
        k = i + CodedOutputStream.computeMessageSize(3, (MessageLite)this.condition_); 
      j = k;
      if (this.conditionCase_ == 4)
        j = k + CodedOutputStream.computeMessageSize(4, (MessageLite)this.condition_); 
      i = j;
      if (this.conditionCase_ == 5)
        i = j + CodedOutputStream.computeMessageSize(5, (MessageLite)this.condition_); 
      j = i;
      if (this.conditionCase_ == 6)
        j = i + CodedOutputStream.computeMessageSize(6, (MessageLite)this.condition_); 
      i = j;
      if (this.conditionCase_ == 7)
        i = j + CodedOutputStream.computeMessageSize(7, (MessageLite)this.condition_); 
      j = i;
      if (this.conditionCase_ == 8)
        j = i + CodedOutputStream.computeMessageSize(8, (MessageLite)this.condition_); 
      i = j;
      if (this.conditionCase_ == 9)
        i = j + CodedOutputStream.computeMessageSize(9, (MessageLite)this.condition_); 
      j = i;
      if (this.conditionCase_ == 10)
        j = i + CodedOutputStream.computeMessageSize(10, (MessageLite)this.condition_); 
      i = j;
      if (this.conditionCase_ == 12)
        i = j + CodedOutputStream.computeMessageSize(12, (MessageLite)this.condition_); 
      j = i;
      if (this.conditionCase_ == 13)
        j = i + CodedOutputStream.computeMessageSize(13, (MessageLite)this.condition_); 
      i = j;
      if (this.conditionCase_ == 14)
        i = j + CodedOutputStream.computeMessageSize(14, (MessageLite)this.condition_); 
      j = i;
      if (this.conditionCase_ == 15)
        j = i + CodedOutputStream.computeMessageSize(15, (MessageLite)this.condition_); 
      i = j;
      if (this.conditionCase_ == 16)
        i = j + CodedOutputStream.computeMessageSize(16, (MessageLite)this.condition_); 
      j = i;
      if (this.conditionCase_ == 17)
        j = i + CodedOutputStream.computeMessageSize(17, (MessageLite)this.condition_); 
      i = j;
      if (this.conditionCase_ == 18)
        i = j + CodedOutputStream.computeMessageSize(18, (MessageLite)this.condition_); 
      j = i;
      if (this.conditionCase_ == 19)
        j = i + CodedOutputStream.computeMessageSize(19, (MessageLite)this.condition_); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public Conditions.DateTimeCondition getTime() {
      return (this.conditionCase_ == 4) ? (Conditions.DateTimeCondition)this.condition_ : Conditions.DateTimeCondition.getDefaultInstance();
    }
    
    public Conditions.TopicCondition getTopic() {
      return (this.conditionCase_ == 13) ? (Conditions.TopicCondition)this.condition_ : Conditions.TopicCondition.getDefaultInstance();
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.conditionCase_ == 1)
        param1CodedOutputStream.writeMessage(1, (MessageLite)this.condition_); 
      if (this.conditionCase_ == 2)
        param1CodedOutputStream.writeMessage(2, (MessageLite)this.condition_); 
      if (this.conditionCase_ == 3)
        param1CodedOutputStream.writeMessage(3, (MessageLite)this.condition_); 
      if (this.conditionCase_ == 4)
        param1CodedOutputStream.writeMessage(4, (MessageLite)this.condition_); 
      if (this.conditionCase_ == 5)
        param1CodedOutputStream.writeMessage(5, (MessageLite)this.condition_); 
      if (this.conditionCase_ == 6)
        param1CodedOutputStream.writeMessage(6, (MessageLite)this.condition_); 
      if (this.conditionCase_ == 7)
        param1CodedOutputStream.writeMessage(7, (MessageLite)this.condition_); 
      if (this.conditionCase_ == 8)
        param1CodedOutputStream.writeMessage(8, (MessageLite)this.condition_); 
      if (this.conditionCase_ == 9)
        param1CodedOutputStream.writeMessage(9, (MessageLite)this.condition_); 
      if (this.conditionCase_ == 10)
        param1CodedOutputStream.writeMessage(10, (MessageLite)this.condition_); 
      if (this.conditionCase_ == 12)
        param1CodedOutputStream.writeMessage(12, (MessageLite)this.condition_); 
      if (this.conditionCase_ == 13)
        param1CodedOutputStream.writeMessage(13, (MessageLite)this.condition_); 
      if (this.conditionCase_ == 14)
        param1CodedOutputStream.writeMessage(14, (MessageLite)this.condition_); 
      if (this.conditionCase_ == 15)
        param1CodedOutputStream.writeMessage(15, (MessageLite)this.condition_); 
      if (this.conditionCase_ == 16)
        param1CodedOutputStream.writeMessage(16, (MessageLite)this.condition_); 
      if (this.conditionCase_ == 17)
        param1CodedOutputStream.writeMessage(17, (MessageLite)this.condition_); 
      if (this.conditionCase_ == 18)
        param1CodedOutputStream.writeMessage(18, (MessageLite)this.condition_); 
      if (this.conditionCase_ == 19)
        param1CodedOutputStream.writeMessage(19, (MessageLite)this.condition_); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Condition, Builder> implements Conditions.ConditionOrBuilder {
      private Builder() {
        super(Conditions.Condition.DEFAULT_INSTANCE);
      }
      
      public Builder clearAbtExperiment() {
        copyOnWrite();
        ((Conditions.Condition)this.instance).clearAbtExperiment();
        return this;
      }
      
      public Builder clearAlwaysFalse() {
        copyOnWrite();
        ((Conditions.Condition)this.instance).clearAlwaysFalse();
        return this;
      }
      
      public Builder clearAlwaysTrue() {
        copyOnWrite();
        ((Conditions.Condition)this.instance).clearAlwaysTrue();
        return this;
      }
      
      public Builder clearAnalyticsAudiences() {
        copyOnWrite();
        ((Conditions.Condition)this.instance).clearAnalyticsAudiences();
        return this;
      }
      
      public Builder clearAnalyticsUserProperty() {
        copyOnWrite();
        ((Conditions.Condition)this.instance).clearAnalyticsUserProperty();
        return this;
      }
      
      public Builder clearAnd() {
        copyOnWrite();
        ((Conditions.Condition)this.instance).clearAnd();
        return this;
      }
      
      public Builder clearAppId() {
        copyOnWrite();
        ((Conditions.Condition)this.instance).clearAppId();
        return this;
      }
      
      public Builder clearAppVersion() {
        copyOnWrite();
        ((Conditions.Condition)this.instance).clearAppVersion();
        return this;
      }
      
      public Builder clearCondition() {
        copyOnWrite();
        ((Conditions.Condition)this.instance).clearCondition();
        return this;
      }
      
      public Builder clearCountries() {
        copyOnWrite();
        ((Conditions.Condition)this.instance).clearCountries();
        return this;
      }
      
      public Builder clearFirebaseFunction() {
        copyOnWrite();
        ((Conditions.Condition)this.instance).clearFirebaseFunction();
        return this;
      }
      
      public Builder clearLanguages() {
        copyOnWrite();
        ((Conditions.Condition)this.instance).clearLanguages();
        return this;
      }
      
      public Builder clearNot() {
        copyOnWrite();
        ((Conditions.Condition)this.instance).clearNot();
        return this;
      }
      
      public Builder clearOr() {
        copyOnWrite();
        ((Conditions.Condition)this.instance).clearOr();
        return this;
      }
      
      public Builder clearOsType() {
        copyOnWrite();
        ((Conditions.Condition)this.instance).clearOsType();
        return this;
      }
      
      public Builder clearPercent() {
        copyOnWrite();
        ((Conditions.Condition)this.instance).clearPercent();
        return this;
      }
      
      public Builder clearPredictions() {
        copyOnWrite();
        ((Conditions.Condition)this.instance).clearPredictions();
        return this;
      }
      
      public Builder clearTime() {
        copyOnWrite();
        ((Conditions.Condition)this.instance).clearTime();
        return this;
      }
      
      public Builder clearTopic() {
        copyOnWrite();
        ((Conditions.Condition)this.instance).clearTopic();
        return this;
      }
      
      public Conditions.AbtExperimentCondition getAbtExperiment() {
        return ((Conditions.Condition)this.instance).getAbtExperiment();
      }
      
      public Conditions.FalseCondition getAlwaysFalse() {
        return ((Conditions.Condition)this.instance).getAlwaysFalse();
      }
      
      public Conditions.TrueCondition getAlwaysTrue() {
        return ((Conditions.Condition)this.instance).getAlwaysTrue();
      }
      
      public Conditions.AnalyticsAudienceCondition getAnalyticsAudiences() {
        return ((Conditions.Condition)this.instance).getAnalyticsAudiences();
      }
      
      public Conditions.AnalyticsUserPropertyCondition getAnalyticsUserProperty() {
        return ((Conditions.Condition)this.instance).getAnalyticsUserProperty();
      }
      
      public Conditions.AndCondition getAnd() {
        return ((Conditions.Condition)this.instance).getAnd();
      }
      
      public Conditions.FirebaseAppIdCondition getAppId() {
        return ((Conditions.Condition)this.instance).getAppId();
      }
      
      public Conditions.AppVersionCondition getAppVersion() {
        return ((Conditions.Condition)this.instance).getAppVersion();
      }
      
      public Conditions.Condition.ConditionCase getConditionCase() {
        return ((Conditions.Condition)this.instance).getConditionCase();
      }
      
      public Conditions.DeviceCountryCondition getCountries() {
        return ((Conditions.Condition)this.instance).getCountries();
      }
      
      public Conditions.FunctionCondition getFirebaseFunction() {
        return ((Conditions.Condition)this.instance).getFirebaseFunction();
      }
      
      public Conditions.DeviceLanguageCondition getLanguages() {
        return ((Conditions.Condition)this.instance).getLanguages();
      }
      
      public Conditions.NotCondition getNot() {
        return ((Conditions.Condition)this.instance).getNot();
      }
      
      public Conditions.OrCondition getOr() {
        return ((Conditions.Condition)this.instance).getOr();
      }
      
      public Conditions.OsTypeCondition getOsType() {
        return ((Conditions.Condition)this.instance).getOsType();
      }
      
      public Conditions.PercentCondition getPercent() {
        return ((Conditions.Condition)this.instance).getPercent();
      }
      
      public Conditions.PredictionsCondition getPredictions() {
        return ((Conditions.Condition)this.instance).getPredictions();
      }
      
      public Conditions.DateTimeCondition getTime() {
        return ((Conditions.Condition)this.instance).getTime();
      }
      
      public Conditions.TopicCondition getTopic() {
        return ((Conditions.Condition)this.instance).getTopic();
      }
      
      public Builder mergeAbtExperiment(Conditions.AbtExperimentCondition param2AbtExperimentCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).mergeAbtExperiment(param2AbtExperimentCondition);
        return this;
      }
      
      public Builder mergeAlwaysFalse(Conditions.FalseCondition param2FalseCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).mergeAlwaysFalse(param2FalseCondition);
        return this;
      }
      
      public Builder mergeAlwaysTrue(Conditions.TrueCondition param2TrueCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).mergeAlwaysTrue(param2TrueCondition);
        return this;
      }
      
      public Builder mergeAnalyticsAudiences(Conditions.AnalyticsAudienceCondition param2AnalyticsAudienceCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).mergeAnalyticsAudiences(param2AnalyticsAudienceCondition);
        return this;
      }
      
      public Builder mergeAnalyticsUserProperty(Conditions.AnalyticsUserPropertyCondition param2AnalyticsUserPropertyCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).mergeAnalyticsUserProperty(param2AnalyticsUserPropertyCondition);
        return this;
      }
      
      public Builder mergeAnd(Conditions.AndCondition param2AndCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).mergeAnd(param2AndCondition);
        return this;
      }
      
      public Builder mergeAppId(Conditions.FirebaseAppIdCondition param2FirebaseAppIdCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).mergeAppId(param2FirebaseAppIdCondition);
        return this;
      }
      
      public Builder mergeAppVersion(Conditions.AppVersionCondition param2AppVersionCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).mergeAppVersion(param2AppVersionCondition);
        return this;
      }
      
      public Builder mergeCountries(Conditions.DeviceCountryCondition param2DeviceCountryCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).mergeCountries(param2DeviceCountryCondition);
        return this;
      }
      
      public Builder mergeFirebaseFunction(Conditions.FunctionCondition param2FunctionCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).mergeFirebaseFunction(param2FunctionCondition);
        return this;
      }
      
      public Builder mergeLanguages(Conditions.DeviceLanguageCondition param2DeviceLanguageCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).mergeLanguages(param2DeviceLanguageCondition);
        return this;
      }
      
      public Builder mergeNot(Conditions.NotCondition param2NotCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).mergeNot(param2NotCondition);
        return this;
      }
      
      public Builder mergeOr(Conditions.OrCondition param2OrCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).mergeOr(param2OrCondition);
        return this;
      }
      
      public Builder mergeOsType(Conditions.OsTypeCondition param2OsTypeCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).mergeOsType(param2OsTypeCondition);
        return this;
      }
      
      public Builder mergePercent(Conditions.PercentCondition param2PercentCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).mergePercent(param2PercentCondition);
        return this;
      }
      
      public Builder mergePredictions(Conditions.PredictionsCondition param2PredictionsCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).mergePredictions(param2PredictionsCondition);
        return this;
      }
      
      public Builder mergeTime(Conditions.DateTimeCondition param2DateTimeCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).mergeTime(param2DateTimeCondition);
        return this;
      }
      
      public Builder mergeTopic(Conditions.TopicCondition param2TopicCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).mergeTopic(param2TopicCondition);
        return this;
      }
      
      public Builder setAbtExperiment(Conditions.AbtExperimentCondition.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setAbtExperiment(param2Builder);
        return this;
      }
      
      public Builder setAbtExperiment(Conditions.AbtExperimentCondition param2AbtExperimentCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setAbtExperiment(param2AbtExperimentCondition);
        return this;
      }
      
      public Builder setAlwaysFalse(Conditions.FalseCondition.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setAlwaysFalse(param2Builder);
        return this;
      }
      
      public Builder setAlwaysFalse(Conditions.FalseCondition param2FalseCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setAlwaysFalse(param2FalseCondition);
        return this;
      }
      
      public Builder setAlwaysTrue(Conditions.TrueCondition.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setAlwaysTrue(param2Builder);
        return this;
      }
      
      public Builder setAlwaysTrue(Conditions.TrueCondition param2TrueCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setAlwaysTrue(param2TrueCondition);
        return this;
      }
      
      public Builder setAnalyticsAudiences(Conditions.AnalyticsAudienceCondition.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setAnalyticsAudiences(param2Builder);
        return this;
      }
      
      public Builder setAnalyticsAudiences(Conditions.AnalyticsAudienceCondition param2AnalyticsAudienceCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setAnalyticsAudiences(param2AnalyticsAudienceCondition);
        return this;
      }
      
      public Builder setAnalyticsUserProperty(Conditions.AnalyticsUserPropertyCondition.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setAnalyticsUserProperty(param2Builder);
        return this;
      }
      
      public Builder setAnalyticsUserProperty(Conditions.AnalyticsUserPropertyCondition param2AnalyticsUserPropertyCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setAnalyticsUserProperty(param2AnalyticsUserPropertyCondition);
        return this;
      }
      
      public Builder setAnd(Conditions.AndCondition.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setAnd(param2Builder);
        return this;
      }
      
      public Builder setAnd(Conditions.AndCondition param2AndCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setAnd(param2AndCondition);
        return this;
      }
      
      public Builder setAppId(Conditions.FirebaseAppIdCondition.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setAppId(param2Builder);
        return this;
      }
      
      public Builder setAppId(Conditions.FirebaseAppIdCondition param2FirebaseAppIdCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setAppId(param2FirebaseAppIdCondition);
        return this;
      }
      
      public Builder setAppVersion(Conditions.AppVersionCondition.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setAppVersion(param2Builder);
        return this;
      }
      
      public Builder setAppVersion(Conditions.AppVersionCondition param2AppVersionCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setAppVersion(param2AppVersionCondition);
        return this;
      }
      
      public Builder setCountries(Conditions.DeviceCountryCondition.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setCountries(param2Builder);
        return this;
      }
      
      public Builder setCountries(Conditions.DeviceCountryCondition param2DeviceCountryCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setCountries(param2DeviceCountryCondition);
        return this;
      }
      
      public Builder setFirebaseFunction(Conditions.FunctionCondition.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setFirebaseFunction(param2Builder);
        return this;
      }
      
      public Builder setFirebaseFunction(Conditions.FunctionCondition param2FunctionCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setFirebaseFunction(param2FunctionCondition);
        return this;
      }
      
      public Builder setLanguages(Conditions.DeviceLanguageCondition.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setLanguages(param2Builder);
        return this;
      }
      
      public Builder setLanguages(Conditions.DeviceLanguageCondition param2DeviceLanguageCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setLanguages(param2DeviceLanguageCondition);
        return this;
      }
      
      public Builder setNot(Conditions.NotCondition.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setNot(param2Builder);
        return this;
      }
      
      public Builder setNot(Conditions.NotCondition param2NotCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setNot(param2NotCondition);
        return this;
      }
      
      public Builder setOr(Conditions.OrCondition.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setOr(param2Builder);
        return this;
      }
      
      public Builder setOr(Conditions.OrCondition param2OrCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setOr(param2OrCondition);
        return this;
      }
      
      public Builder setOsType(Conditions.OsTypeCondition.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setOsType(param2Builder);
        return this;
      }
      
      public Builder setOsType(Conditions.OsTypeCondition param2OsTypeCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setOsType(param2OsTypeCondition);
        return this;
      }
      
      public Builder setPercent(Conditions.PercentCondition.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setPercent(param2Builder);
        return this;
      }
      
      public Builder setPercent(Conditions.PercentCondition param2PercentCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setPercent(param2PercentCondition);
        return this;
      }
      
      public Builder setPredictions(Conditions.PredictionsCondition.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setPredictions(param2Builder);
        return this;
      }
      
      public Builder setPredictions(Conditions.PredictionsCondition param2PredictionsCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setPredictions(param2PredictionsCondition);
        return this;
      }
      
      public Builder setTime(Conditions.DateTimeCondition.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setTime(param2Builder);
        return this;
      }
      
      public Builder setTime(Conditions.DateTimeCondition param2DateTimeCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setTime(param2DateTimeCondition);
        return this;
      }
      
      public Builder setTopic(Conditions.TopicCondition.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setTopic(param2Builder);
        return this;
      }
      
      public Builder setTopic(Conditions.TopicCondition param2TopicCondition) {
        copyOnWrite();
        ((Conditions.Condition)this.instance).setTopic(param2TopicCondition);
        return this;
      }
    }
    
    public enum ConditionCase implements Internal.EnumLite {
      ABT_EXPERIMENT(0),
      ALWAYS_FALSE(0),
      ALWAYS_TRUE(0),
      ANALYTICS_AUDIENCES(0),
      ANALYTICS_USER_PROPERTY(0),
      AND(1),
      APP_ID(1),
      APP_VERSION(1),
      CONDITION_NOT_SET(1),
      COUNTRIES(1),
      FIREBASE_FUNCTION(1),
      LANGUAGES(1),
      NOT(1),
      OR(2),
      OS_TYPE(2),
      PERCENT(2),
      PREDICTIONS(2),
      TIME(2),
      TOPIC(2);
      
      private final int value;
      
      static {
        ALWAYS_FALSE = new ConditionCase("ALWAYS_FALSE", 4, 17);
        TIME = new ConditionCase("TIME", 5, 4);
        APP_VERSION = new ConditionCase("APP_VERSION", 6, 5);
        APP_ID = new ConditionCase("APP_ID", 7, 6);
        ANALYTICS_AUDIENCES = new ConditionCase("ANALYTICS_AUDIENCES", 8, 7);
        LANGUAGES = new ConditionCase("LANGUAGES", 9, 8);
        COUNTRIES = new ConditionCase("COUNTRIES", 10, 9);
        OS_TYPE = new ConditionCase("OS_TYPE", 11, 10);
        ANALYTICS_USER_PROPERTY = new ConditionCase("ANALYTICS_USER_PROPERTY", 12, 12);
        TOPIC = new ConditionCase("TOPIC", 13, 13);
        PERCENT = new ConditionCase("PERCENT", 14, 14);
        PREDICTIONS = new ConditionCase("PREDICTIONS", 15, 15);
        ABT_EXPERIMENT = new ConditionCase("ABT_EXPERIMENT", 16, 18);
        FIREBASE_FUNCTION = new ConditionCase("FIREBASE_FUNCTION", 17, 19);
        CONDITION_NOT_SET = new ConditionCase("CONDITION_NOT_SET", 18, 0);
        $VALUES = new ConditionCase[] { 
            AND, OR, NOT, ALWAYS_TRUE, ALWAYS_FALSE, TIME, APP_VERSION, APP_ID, ANALYTICS_AUDIENCES, LANGUAGES, 
            COUNTRIES, OS_TYPE, ANALYTICS_USER_PROPERTY, TOPIC, PERCENT, PREDICTIONS, ABT_EXPERIMENT, FIREBASE_FUNCTION, CONDITION_NOT_SET };
      }
      
      ConditionCase(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static ConditionCase forNumber(int param2Int) {
        switch (param2Int) {
          default:
            return null;
          case 19:
            return FIREBASE_FUNCTION;
          case 18:
            return ABT_EXPERIMENT;
          case 17:
            return ALWAYS_FALSE;
          case 16:
            return ALWAYS_TRUE;
          case 15:
            return PREDICTIONS;
          case 14:
            return PERCENT;
          case 13:
            return TOPIC;
          case 12:
            return ANALYTICS_USER_PROPERTY;
          case 10:
            return OS_TYPE;
          case 9:
            return COUNTRIES;
          case 8:
            return LANGUAGES;
          case 7:
            return ANALYTICS_AUDIENCES;
          case 6:
            return APP_ID;
          case 5:
            return APP_VERSION;
          case 4:
            return TIME;
          case 3:
            return NOT;
          case 2:
            return OR;
          case 1:
            return AND;
          case 0:
            break;
        } 
        return CONDITION_NOT_SET;
      }
      
      public int getNumber() {
        return this.value;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Condition, Condition.Builder> implements ConditionOrBuilder {
    private Builder() {
      super(Conditions.Condition.DEFAULT_INSTANCE);
    }
    
    public Builder clearAbtExperiment() {
      copyOnWrite();
      ((Conditions.Condition)this.instance).clearAbtExperiment();
      return this;
    }
    
    public Builder clearAlwaysFalse() {
      copyOnWrite();
      ((Conditions.Condition)this.instance).clearAlwaysFalse();
      return this;
    }
    
    public Builder clearAlwaysTrue() {
      copyOnWrite();
      ((Conditions.Condition)this.instance).clearAlwaysTrue();
      return this;
    }
    
    public Builder clearAnalyticsAudiences() {
      copyOnWrite();
      ((Conditions.Condition)this.instance).clearAnalyticsAudiences();
      return this;
    }
    
    public Builder clearAnalyticsUserProperty() {
      copyOnWrite();
      ((Conditions.Condition)this.instance).clearAnalyticsUserProperty();
      return this;
    }
    
    public Builder clearAnd() {
      copyOnWrite();
      ((Conditions.Condition)this.instance).clearAnd();
      return this;
    }
    
    public Builder clearAppId() {
      copyOnWrite();
      ((Conditions.Condition)this.instance).clearAppId();
      return this;
    }
    
    public Builder clearAppVersion() {
      copyOnWrite();
      ((Conditions.Condition)this.instance).clearAppVersion();
      return this;
    }
    
    public Builder clearCondition() {
      copyOnWrite();
      ((Conditions.Condition)this.instance).clearCondition();
      return this;
    }
    
    public Builder clearCountries() {
      copyOnWrite();
      ((Conditions.Condition)this.instance).clearCountries();
      return this;
    }
    
    public Builder clearFirebaseFunction() {
      copyOnWrite();
      ((Conditions.Condition)this.instance).clearFirebaseFunction();
      return this;
    }
    
    public Builder clearLanguages() {
      copyOnWrite();
      ((Conditions.Condition)this.instance).clearLanguages();
      return this;
    }
    
    public Builder clearNot() {
      copyOnWrite();
      ((Conditions.Condition)this.instance).clearNot();
      return this;
    }
    
    public Builder clearOr() {
      copyOnWrite();
      ((Conditions.Condition)this.instance).clearOr();
      return this;
    }
    
    public Builder clearOsType() {
      copyOnWrite();
      ((Conditions.Condition)this.instance).clearOsType();
      return this;
    }
    
    public Builder clearPercent() {
      copyOnWrite();
      ((Conditions.Condition)this.instance).clearPercent();
      return this;
    }
    
    public Builder clearPredictions() {
      copyOnWrite();
      ((Conditions.Condition)this.instance).clearPredictions();
      return this;
    }
    
    public Builder clearTime() {
      copyOnWrite();
      ((Conditions.Condition)this.instance).clearTime();
      return this;
    }
    
    public Builder clearTopic() {
      copyOnWrite();
      ((Conditions.Condition)this.instance).clearTopic();
      return this;
    }
    
    public Conditions.AbtExperimentCondition getAbtExperiment() {
      return ((Conditions.Condition)this.instance).getAbtExperiment();
    }
    
    public Conditions.FalseCondition getAlwaysFalse() {
      return ((Conditions.Condition)this.instance).getAlwaysFalse();
    }
    
    public Conditions.TrueCondition getAlwaysTrue() {
      return ((Conditions.Condition)this.instance).getAlwaysTrue();
    }
    
    public Conditions.AnalyticsAudienceCondition getAnalyticsAudiences() {
      return ((Conditions.Condition)this.instance).getAnalyticsAudiences();
    }
    
    public Conditions.AnalyticsUserPropertyCondition getAnalyticsUserProperty() {
      return ((Conditions.Condition)this.instance).getAnalyticsUserProperty();
    }
    
    public Conditions.AndCondition getAnd() {
      return ((Conditions.Condition)this.instance).getAnd();
    }
    
    public Conditions.FirebaseAppIdCondition getAppId() {
      return ((Conditions.Condition)this.instance).getAppId();
    }
    
    public Conditions.AppVersionCondition getAppVersion() {
      return ((Conditions.Condition)this.instance).getAppVersion();
    }
    
    public Conditions.Condition.ConditionCase getConditionCase() {
      return ((Conditions.Condition)this.instance).getConditionCase();
    }
    
    public Conditions.DeviceCountryCondition getCountries() {
      return ((Conditions.Condition)this.instance).getCountries();
    }
    
    public Conditions.FunctionCondition getFirebaseFunction() {
      return ((Conditions.Condition)this.instance).getFirebaseFunction();
    }
    
    public Conditions.DeviceLanguageCondition getLanguages() {
      return ((Conditions.Condition)this.instance).getLanguages();
    }
    
    public Conditions.NotCondition getNot() {
      return ((Conditions.Condition)this.instance).getNot();
    }
    
    public Conditions.OrCondition getOr() {
      return ((Conditions.Condition)this.instance).getOr();
    }
    
    public Conditions.OsTypeCondition getOsType() {
      return ((Conditions.Condition)this.instance).getOsType();
    }
    
    public Conditions.PercentCondition getPercent() {
      return ((Conditions.Condition)this.instance).getPercent();
    }
    
    public Conditions.PredictionsCondition getPredictions() {
      return ((Conditions.Condition)this.instance).getPredictions();
    }
    
    public Conditions.DateTimeCondition getTime() {
      return ((Conditions.Condition)this.instance).getTime();
    }
    
    public Conditions.TopicCondition getTopic() {
      return ((Conditions.Condition)this.instance).getTopic();
    }
    
    public Builder mergeAbtExperiment(Conditions.AbtExperimentCondition param1AbtExperimentCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).mergeAbtExperiment(param1AbtExperimentCondition);
      return this;
    }
    
    public Builder mergeAlwaysFalse(Conditions.FalseCondition param1FalseCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).mergeAlwaysFalse(param1FalseCondition);
      return this;
    }
    
    public Builder mergeAlwaysTrue(Conditions.TrueCondition param1TrueCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).mergeAlwaysTrue(param1TrueCondition);
      return this;
    }
    
    public Builder mergeAnalyticsAudiences(Conditions.AnalyticsAudienceCondition param1AnalyticsAudienceCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).mergeAnalyticsAudiences(param1AnalyticsAudienceCondition);
      return this;
    }
    
    public Builder mergeAnalyticsUserProperty(Conditions.AnalyticsUserPropertyCondition param1AnalyticsUserPropertyCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).mergeAnalyticsUserProperty(param1AnalyticsUserPropertyCondition);
      return this;
    }
    
    public Builder mergeAnd(Conditions.AndCondition param1AndCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).mergeAnd(param1AndCondition);
      return this;
    }
    
    public Builder mergeAppId(Conditions.FirebaseAppIdCondition param1FirebaseAppIdCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).mergeAppId(param1FirebaseAppIdCondition);
      return this;
    }
    
    public Builder mergeAppVersion(Conditions.AppVersionCondition param1AppVersionCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).mergeAppVersion(param1AppVersionCondition);
      return this;
    }
    
    public Builder mergeCountries(Conditions.DeviceCountryCondition param1DeviceCountryCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).mergeCountries(param1DeviceCountryCondition);
      return this;
    }
    
    public Builder mergeFirebaseFunction(Conditions.FunctionCondition param1FunctionCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).mergeFirebaseFunction(param1FunctionCondition);
      return this;
    }
    
    public Builder mergeLanguages(Conditions.DeviceLanguageCondition param1DeviceLanguageCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).mergeLanguages(param1DeviceLanguageCondition);
      return this;
    }
    
    public Builder mergeNot(Conditions.NotCondition param1NotCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).mergeNot(param1NotCondition);
      return this;
    }
    
    public Builder mergeOr(Conditions.OrCondition param1OrCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).mergeOr(param1OrCondition);
      return this;
    }
    
    public Builder mergeOsType(Conditions.OsTypeCondition param1OsTypeCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).mergeOsType(param1OsTypeCondition);
      return this;
    }
    
    public Builder mergePercent(Conditions.PercentCondition param1PercentCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).mergePercent(param1PercentCondition);
      return this;
    }
    
    public Builder mergePredictions(Conditions.PredictionsCondition param1PredictionsCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).mergePredictions(param1PredictionsCondition);
      return this;
    }
    
    public Builder mergeTime(Conditions.DateTimeCondition param1DateTimeCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).mergeTime(param1DateTimeCondition);
      return this;
    }
    
    public Builder mergeTopic(Conditions.TopicCondition param1TopicCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).mergeTopic(param1TopicCondition);
      return this;
    }
    
    public Builder setAbtExperiment(Conditions.AbtExperimentCondition.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setAbtExperiment(param1Builder);
      return this;
    }
    
    public Builder setAbtExperiment(Conditions.AbtExperimentCondition param1AbtExperimentCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setAbtExperiment(param1AbtExperimentCondition);
      return this;
    }
    
    public Builder setAlwaysFalse(Conditions.FalseCondition.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setAlwaysFalse(param1Builder);
      return this;
    }
    
    public Builder setAlwaysFalse(Conditions.FalseCondition param1FalseCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setAlwaysFalse(param1FalseCondition);
      return this;
    }
    
    public Builder setAlwaysTrue(Conditions.TrueCondition.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setAlwaysTrue(param1Builder);
      return this;
    }
    
    public Builder setAlwaysTrue(Conditions.TrueCondition param1TrueCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setAlwaysTrue(param1TrueCondition);
      return this;
    }
    
    public Builder setAnalyticsAudiences(Conditions.AnalyticsAudienceCondition.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setAnalyticsAudiences(param1Builder);
      return this;
    }
    
    public Builder setAnalyticsAudiences(Conditions.AnalyticsAudienceCondition param1AnalyticsAudienceCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setAnalyticsAudiences(param1AnalyticsAudienceCondition);
      return this;
    }
    
    public Builder setAnalyticsUserProperty(Conditions.AnalyticsUserPropertyCondition.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setAnalyticsUserProperty(param1Builder);
      return this;
    }
    
    public Builder setAnalyticsUserProperty(Conditions.AnalyticsUserPropertyCondition param1AnalyticsUserPropertyCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setAnalyticsUserProperty(param1AnalyticsUserPropertyCondition);
      return this;
    }
    
    public Builder setAnd(Conditions.AndCondition.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setAnd(param1Builder);
      return this;
    }
    
    public Builder setAnd(Conditions.AndCondition param1AndCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setAnd(param1AndCondition);
      return this;
    }
    
    public Builder setAppId(Conditions.FirebaseAppIdCondition.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setAppId(param1Builder);
      return this;
    }
    
    public Builder setAppId(Conditions.FirebaseAppIdCondition param1FirebaseAppIdCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setAppId(param1FirebaseAppIdCondition);
      return this;
    }
    
    public Builder setAppVersion(Conditions.AppVersionCondition.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setAppVersion(param1Builder);
      return this;
    }
    
    public Builder setAppVersion(Conditions.AppVersionCondition param1AppVersionCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setAppVersion(param1AppVersionCondition);
      return this;
    }
    
    public Builder setCountries(Conditions.DeviceCountryCondition.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setCountries(param1Builder);
      return this;
    }
    
    public Builder setCountries(Conditions.DeviceCountryCondition param1DeviceCountryCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setCountries(param1DeviceCountryCondition);
      return this;
    }
    
    public Builder setFirebaseFunction(Conditions.FunctionCondition.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setFirebaseFunction(param1Builder);
      return this;
    }
    
    public Builder setFirebaseFunction(Conditions.FunctionCondition param1FunctionCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setFirebaseFunction(param1FunctionCondition);
      return this;
    }
    
    public Builder setLanguages(Conditions.DeviceLanguageCondition.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setLanguages(param1Builder);
      return this;
    }
    
    public Builder setLanguages(Conditions.DeviceLanguageCondition param1DeviceLanguageCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setLanguages(param1DeviceLanguageCondition);
      return this;
    }
    
    public Builder setNot(Conditions.NotCondition.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setNot(param1Builder);
      return this;
    }
    
    public Builder setNot(Conditions.NotCondition param1NotCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setNot(param1NotCondition);
      return this;
    }
    
    public Builder setOr(Conditions.OrCondition.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setOr(param1Builder);
      return this;
    }
    
    public Builder setOr(Conditions.OrCondition param1OrCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setOr(param1OrCondition);
      return this;
    }
    
    public Builder setOsType(Conditions.OsTypeCondition.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setOsType(param1Builder);
      return this;
    }
    
    public Builder setOsType(Conditions.OsTypeCondition param1OsTypeCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setOsType(param1OsTypeCondition);
      return this;
    }
    
    public Builder setPercent(Conditions.PercentCondition.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setPercent(param1Builder);
      return this;
    }
    
    public Builder setPercent(Conditions.PercentCondition param1PercentCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setPercent(param1PercentCondition);
      return this;
    }
    
    public Builder setPredictions(Conditions.PredictionsCondition.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setPredictions(param1Builder);
      return this;
    }
    
    public Builder setPredictions(Conditions.PredictionsCondition param1PredictionsCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setPredictions(param1PredictionsCondition);
      return this;
    }
    
    public Builder setTime(Conditions.DateTimeCondition.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setTime(param1Builder);
      return this;
    }
    
    public Builder setTime(Conditions.DateTimeCondition param1DateTimeCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setTime(param1DateTimeCondition);
      return this;
    }
    
    public Builder setTopic(Conditions.TopicCondition.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setTopic(param1Builder);
      return this;
    }
    
    public Builder setTopic(Conditions.TopicCondition param1TopicCondition) {
      copyOnWrite();
      ((Conditions.Condition)this.instance).setTopic(param1TopicCondition);
      return this;
    }
  }
  
  public enum ConditionCase implements Internal.EnumLite {
    AND(1),
    APP_ID(1),
    APP_VERSION(1),
    CONDITION_NOT_SET(1),
    COUNTRIES(1),
    FIREBASE_FUNCTION(1),
    LANGUAGES(1),
    NOT(1),
    ABT_EXPERIMENT(2),
    ALWAYS_FALSE(2),
    ALWAYS_TRUE(2),
    ANALYTICS_AUDIENCES(2),
    ANALYTICS_USER_PROPERTY(2),
    OR(2),
    OS_TYPE(2),
    PERCENT(2),
    PREDICTIONS(2),
    TIME(2),
    TOPIC(2);
    
    private final int value;
    
    static {
      ALWAYS_TRUE = new ConditionCase("ALWAYS_TRUE", 3, 16);
      ALWAYS_FALSE = new ConditionCase("ALWAYS_FALSE", 4, 17);
      TIME = new ConditionCase("TIME", 5, 4);
      APP_VERSION = new ConditionCase("APP_VERSION", 6, 5);
      APP_ID = new ConditionCase("APP_ID", 7, 6);
      ANALYTICS_AUDIENCES = new ConditionCase("ANALYTICS_AUDIENCES", 8, 7);
      LANGUAGES = new ConditionCase("LANGUAGES", 9, 8);
      COUNTRIES = new ConditionCase("COUNTRIES", 10, 9);
      OS_TYPE = new ConditionCase("OS_TYPE", 11, 10);
      ANALYTICS_USER_PROPERTY = new ConditionCase("ANALYTICS_USER_PROPERTY", 12, 12);
      TOPIC = new ConditionCase("TOPIC", 13, 13);
      PERCENT = new ConditionCase("PERCENT", 14, 14);
      PREDICTIONS = new ConditionCase("PREDICTIONS", 15, 15);
      ABT_EXPERIMENT = new ConditionCase("ABT_EXPERIMENT", 16, 18);
      FIREBASE_FUNCTION = new ConditionCase("FIREBASE_FUNCTION", 17, 19);
      CONDITION_NOT_SET = new ConditionCase("CONDITION_NOT_SET", 18, 0);
      $VALUES = new ConditionCase[] { 
          AND, OR, NOT, ALWAYS_TRUE, ALWAYS_FALSE, TIME, APP_VERSION, APP_ID, ANALYTICS_AUDIENCES, LANGUAGES, 
          COUNTRIES, OS_TYPE, ANALYTICS_USER_PROPERTY, TOPIC, PERCENT, PREDICTIONS, ABT_EXPERIMENT, FIREBASE_FUNCTION, CONDITION_NOT_SET };
    }
    
    ConditionCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ConditionCase forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 19:
          return FIREBASE_FUNCTION;
        case 18:
          return ABT_EXPERIMENT;
        case 17:
          return ALWAYS_FALSE;
        case 16:
          return ALWAYS_TRUE;
        case 15:
          return PREDICTIONS;
        case 14:
          return PERCENT;
        case 13:
          return TOPIC;
        case 12:
          return ANALYTICS_USER_PROPERTY;
        case 10:
          return OS_TYPE;
        case 9:
          return COUNTRIES;
        case 8:
          return LANGUAGES;
        case 7:
          return ANALYTICS_AUDIENCES;
        case 6:
          return APP_ID;
        case 5:
          return APP_VERSION;
        case 4:
          return TIME;
        case 3:
          return NOT;
        case 2:
          return OR;
        case 1:
          return AND;
        case 0:
          break;
      } 
      return CONDITION_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
  
  public static interface ConditionOrBuilder extends MessageLiteOrBuilder {
    Conditions.AbtExperimentCondition getAbtExperiment();
    
    Conditions.FalseCondition getAlwaysFalse();
    
    Conditions.TrueCondition getAlwaysTrue();
    
    Conditions.AnalyticsAudienceCondition getAnalyticsAudiences();
    
    Conditions.AnalyticsUserPropertyCondition getAnalyticsUserProperty();
    
    Conditions.AndCondition getAnd();
    
    Conditions.FirebaseAppIdCondition getAppId();
    
    Conditions.AppVersionCondition getAppVersion();
    
    Conditions.Condition.ConditionCase getConditionCase();
    
    Conditions.DeviceCountryCondition getCountries();
    
    Conditions.FunctionCondition getFirebaseFunction();
    
    Conditions.DeviceLanguageCondition getLanguages();
    
    Conditions.NotCondition getNot();
    
    Conditions.OrCondition getOr();
    
    Conditions.OsTypeCondition getOsType();
    
    Conditions.PercentCondition getPercent();
    
    Conditions.PredictionsCondition getPredictions();
    
    Conditions.DateTimeCondition getTime();
    
    Conditions.TopicCondition getTopic();
  }
  
  public enum ConditionUseCase implements Internal.EnumLite {
    USE_CASE_NOT_SPECIFIED(0),
    DIGITAL_GOODS(2),
    IN_APP_MESSAGING(2),
    NOTIFICATIONS_ABT_EXPERIMENT(2),
    REMOTE_CONFIG(2),
    REMOTE_CONFIG_ABT_EXPERIMENT(2),
    UNIVERSAL(2),
    UNRECOGNIZED(2);
    
    public static final int DIGITAL_GOODS_VALUE = 4;
    
    public static final int IN_APP_MESSAGING_VALUE = 5;
    
    public static final int NOTIFICATIONS_ABT_EXPERIMENT_VALUE = 3;
    
    public static final int REMOTE_CONFIG_ABT_EXPERIMENT_VALUE = 2;
    
    public static final int REMOTE_CONFIG_VALUE = 6;
    
    public static final int UNIVERSAL_VALUE = 1;
    
    public static final int USE_CASE_NOT_SPECIFIED_VALUE = 0;
    
    private static final Internal.EnumLiteMap<ConditionUseCase> internalValueMap;
    
    private final int value;
    
    static {
      REMOTE_CONFIG_ABT_EXPERIMENT = new ConditionUseCase("REMOTE_CONFIG_ABT_EXPERIMENT", 2, 2);
      NOTIFICATIONS_ABT_EXPERIMENT = new ConditionUseCase("NOTIFICATIONS_ABT_EXPERIMENT", 3, 3);
      DIGITAL_GOODS = new ConditionUseCase("DIGITAL_GOODS", 4, 4);
      IN_APP_MESSAGING = new ConditionUseCase("IN_APP_MESSAGING", 5, 5);
      REMOTE_CONFIG = new ConditionUseCase("REMOTE_CONFIG", 6, 6);
      UNRECOGNIZED = new ConditionUseCase("UNRECOGNIZED", 7, -1);
      $VALUES = new ConditionUseCase[] { USE_CASE_NOT_SPECIFIED, UNIVERSAL, REMOTE_CONFIG_ABT_EXPERIMENT, NOTIFICATIONS_ABT_EXPERIMENT, DIGITAL_GOODS, IN_APP_MESSAGING, REMOTE_CONFIG, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<ConditionUseCase>() {
          public Conditions.ConditionUseCase findValueByNumber(int param2Int) {
            return Conditions.ConditionUseCase.forNumber(param2Int);
          }
        };
    }
    
    ConditionUseCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ConditionUseCase forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 6:
          return REMOTE_CONFIG;
        case 5:
          return IN_APP_MESSAGING;
        case 4:
          return DIGITAL_GOODS;
        case 3:
          return NOTIFICATIONS_ABT_EXPERIMENT;
        case 2:
          return REMOTE_CONFIG_ABT_EXPERIMENT;
        case 1:
          return UNIVERSAL;
        case 0:
          break;
      } 
      return USE_CASE_NOT_SPECIFIED;
    }
    
    public static Internal.EnumLiteMap<ConditionUseCase> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<ConditionUseCase> {
    public Conditions.ConditionUseCase findValueByNumber(int param1Int) {
      return Conditions.ConditionUseCase.forNumber(param1Int);
    }
  }
  
  public static final class DateTimeCondition extends GeneratedMessageLite<DateTimeCondition, DateTimeCondition.Builder> implements DateTimeConditionOrBuilder {
    private static final DateTimeCondition DEFAULT_INSTANCE = new DateTimeCondition();
    
    public static final int OPERATOR_FIELD_NUMBER = 1;
    
    private static volatile Parser<DateTimeCondition> PARSER;
    
    public static final int TARGET_DATE_TIME_ZONE_FIELD_NUMBER = 2;
    
    private int operator_;
    
    private Conditions.TargetDateTimeZone targetDateTimeZone_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearOperator() {
      this.operator_ = 0;
    }
    
    private void clearTargetDateTimeZone() {
      this.targetDateTimeZone_ = null;
    }
    
    public static DateTimeCondition getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeTargetDateTimeZone(Conditions.TargetDateTimeZone param1TargetDateTimeZone) {
      Conditions.TargetDateTimeZone targetDateTimeZone = this.targetDateTimeZone_;
      if (targetDateTimeZone != null && targetDateTimeZone != Conditions.TargetDateTimeZone.getDefaultInstance()) {
        this.targetDateTimeZone_ = (Conditions.TargetDateTimeZone)((Conditions.TargetDateTimeZone.Builder)Conditions.TargetDateTimeZone.newBuilder(this.targetDateTimeZone_).mergeFrom(param1TargetDateTimeZone)).buildPartial();
      } else {
        this.targetDateTimeZone_ = param1TargetDateTimeZone;
      } 
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(DateTimeCondition param1DateTimeCondition) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1DateTimeCondition);
    }
    
    public static DateTimeCondition parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (DateTimeCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static DateTimeCondition parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (DateTimeCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static DateTimeCondition parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (DateTimeCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static DateTimeCondition parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (DateTimeCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static DateTimeCondition parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (DateTimeCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static DateTimeCondition parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (DateTimeCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static DateTimeCondition parseFrom(InputStream param1InputStream) throws IOException {
      return (DateTimeCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static DateTimeCondition parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (DateTimeCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static DateTimeCondition parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (DateTimeCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static DateTimeCondition parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (DateTimeCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<DateTimeCondition> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setOperator(TimeOperator param1TimeOperator) {
      if (param1TimeOperator != null) {
        this.operator_ = param1TimeOperator.getNumber();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setOperatorValue(int param1Int) {
      this.operator_ = param1Int;
    }
    
    private void setTargetDateTimeZone(Conditions.TargetDateTimeZone.Builder param1Builder) {
      this.targetDateTimeZone_ = (Conditions.TargetDateTimeZone)param1Builder.build();
    }
    
    private void setTargetDateTimeZone(Conditions.TargetDateTimeZone param1TargetDateTimeZone) {
      if (param1TargetDateTimeZone != null) {
        this.targetDateTimeZone_ = param1TargetDateTimeZone;
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/developers/mobile/targeting/proto/Conditions$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: istore #4
      //   10: iconst_0
      //   11: istore #5
      //   13: iconst_0
      //   14: istore #6
      //   16: iload #4
      //   18: tableswitch default -> 64, 1 -> 413, 2 -> 409, 3 -> 407, 4 -> 398, 5 -> 309, 6 -> 118, 7 -> 305, 8 -> 72
      //   64: new java/lang/UnsupportedOperationException
      //   67: dup
      //   68: invokespecial <init> : ()V
      //   71: athrow
      //   72: getstatic com/google/developers/mobile/targeting/proto/Conditions$DateTimeCondition.PARSER : Lcom/google/protobuf/Parser;
      //   75: ifnonnull -> 114
      //   78: ldc com/google/developers/mobile/targeting/proto/Conditions$DateTimeCondition
      //   80: monitorenter
      //   81: getstatic com/google/developers/mobile/targeting/proto/Conditions$DateTimeCondition.PARSER : Lcom/google/protobuf/Parser;
      //   84: ifnonnull -> 102
      //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   90: astore_1
      //   91: aload_1
      //   92: getstatic com/google/developers/mobile/targeting/proto/Conditions$DateTimeCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$DateTimeCondition;
      //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   98: aload_1
      //   99: putstatic com/google/developers/mobile/targeting/proto/Conditions$DateTimeCondition.PARSER : Lcom/google/protobuf/Parser;
      //   102: ldc com/google/developers/mobile/targeting/proto/Conditions$DateTimeCondition
      //   104: monitorexit
      //   105: goto -> 114
      //   108: astore_1
      //   109: ldc com/google/developers/mobile/targeting/proto/Conditions$DateTimeCondition
      //   111: monitorexit
      //   112: aload_1
      //   113: athrow
      //   114: getstatic com/google/developers/mobile/targeting/proto/Conditions$DateTimeCondition.PARSER : Lcom/google/protobuf/Parser;
      //   117: areturn
      //   118: aload_2
      //   119: checkcast com/google/protobuf/CodedInputStream
      //   122: astore_2
      //   123: aload_3
      //   124: checkcast com/google/protobuf/ExtensionRegistryLite
      //   127: astore_3
      //   128: iload #6
      //   130: ifne -> 305
      //   133: aload_2
      //   134: invokevirtual readTag : ()I
      //   137: istore #4
      //   139: iload #4
      //   141: ifeq -> 249
      //   144: iload #4
      //   146: bipush #8
      //   148: if_icmpeq -> 238
      //   151: iload #4
      //   153: bipush #18
      //   155: if_icmpeq -> 173
      //   158: aload_2
      //   159: iload #4
      //   161: invokevirtual skipField : (I)Z
      //   164: ifne -> 128
      //   167: iconst_1
      //   168: istore #6
      //   170: goto -> 128
      //   173: aload_0
      //   174: getfield targetDateTimeZone_ : Lcom/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone;
      //   177: ifnull -> 194
      //   180: aload_0
      //   181: getfield targetDateTimeZone_ : Lcom/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone;
      //   184: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   187: checkcast com/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone$Builder
      //   190: astore_1
      //   191: goto -> 196
      //   194: aconst_null
      //   195: astore_1
      //   196: aload_0
      //   197: aload_2
      //   198: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   201: aload_3
      //   202: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   205: checkcast com/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone
      //   208: putfield targetDateTimeZone_ : Lcom/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone;
      //   211: aload_1
      //   212: ifnull -> 128
      //   215: aload_1
      //   216: aload_0
      //   217: getfield targetDateTimeZone_ : Lcom/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone;
      //   220: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   223: pop
      //   224: aload_0
      //   225: aload_1
      //   226: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   229: checkcast com/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone
      //   232: putfield targetDateTimeZone_ : Lcom/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone;
      //   235: goto -> 128
      //   238: aload_0
      //   239: aload_2
      //   240: invokevirtual readEnum : ()I
      //   243: putfield operator_ : I
      //   246: goto -> 128
      //   249: iconst_1
      //   250: istore #6
      //   252: goto -> 128
      //   255: astore_1
      //   256: goto -> 303
      //   259: astore_1
      //   260: new java/lang/RuntimeException
      //   263: astore_2
      //   264: new com/google/protobuf/InvalidProtocolBufferException
      //   267: astore_3
      //   268: aload_3
      //   269: aload_1
      //   270: invokevirtual getMessage : ()Ljava/lang/String;
      //   273: invokespecial <init> : (Ljava/lang/String;)V
      //   276: aload_2
      //   277: aload_3
      //   278: aload_0
      //   279: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   282: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   285: aload_2
      //   286: athrow
      //   287: astore_1
      //   288: new java/lang/RuntimeException
      //   291: astore_2
      //   292: aload_2
      //   293: aload_1
      //   294: aload_0
      //   295: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   298: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   301: aload_2
      //   302: athrow
      //   303: aload_1
      //   304: athrow
      //   305: getstatic com/google/developers/mobile/targeting/proto/Conditions$DateTimeCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$DateTimeCondition;
      //   308: areturn
      //   309: aload_2
      //   310: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   313: astore_1
      //   314: aload_3
      //   315: checkcast com/google/developers/mobile/targeting/proto/Conditions$DateTimeCondition
      //   318: astore_2
      //   319: aload_0
      //   320: getfield operator_ : I
      //   323: ifeq -> 332
      //   326: iconst_1
      //   327: istore #7
      //   329: goto -> 335
      //   332: iconst_0
      //   333: istore #7
      //   335: aload_0
      //   336: getfield operator_ : I
      //   339: istore #6
      //   341: aload_2
      //   342: getfield operator_ : I
      //   345: ifeq -> 351
      //   348: iconst_1
      //   349: istore #5
      //   351: aload_0
      //   352: aload_1
      //   353: iload #7
      //   355: iload #6
      //   357: iload #5
      //   359: aload_2
      //   360: getfield operator_ : I
      //   363: invokeinterface visitInt : (ZIZI)I
      //   368: putfield operator_ : I
      //   371: aload_0
      //   372: aload_1
      //   373: aload_0
      //   374: getfield targetDateTimeZone_ : Lcom/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone;
      //   377: aload_2
      //   378: getfield targetDateTimeZone_ : Lcom/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone;
      //   381: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   386: checkcast com/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone
      //   389: putfield targetDateTimeZone_ : Lcom/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone;
      //   392: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   395: astore_1
      //   396: aload_0
      //   397: areturn
      //   398: new com/google/developers/mobile/targeting/proto/Conditions$DateTimeCondition$Builder
      //   401: dup
      //   402: aconst_null
      //   403: invokespecial <init> : (Lcom/google/developers/mobile/targeting/proto/Conditions$1;)V
      //   406: areturn
      //   407: aconst_null
      //   408: areturn
      //   409: getstatic com/google/developers/mobile/targeting/proto/Conditions$DateTimeCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$DateTimeCondition;
      //   412: areturn
      //   413: new com/google/developers/mobile/targeting/proto/Conditions$DateTimeCondition
      //   416: dup
      //   417: invokespecial <init> : ()V
      //   420: areturn
      // Exception table:
      //   from	to	target	type
      //   81	102	108	finally
      //   102	105	108	finally
      //   109	112	108	finally
      //   133	139	287	com/google/protobuf/InvalidProtocolBufferException
      //   133	139	259	java/io/IOException
      //   133	139	255	finally
      //   158	167	287	com/google/protobuf/InvalidProtocolBufferException
      //   158	167	259	java/io/IOException
      //   158	167	255	finally
      //   173	191	287	com/google/protobuf/InvalidProtocolBufferException
      //   173	191	259	java/io/IOException
      //   173	191	255	finally
      //   196	211	287	com/google/protobuf/InvalidProtocolBufferException
      //   196	211	259	java/io/IOException
      //   196	211	255	finally
      //   215	235	287	com/google/protobuf/InvalidProtocolBufferException
      //   215	235	259	java/io/IOException
      //   215	235	255	finally
      //   238	246	287	com/google/protobuf/InvalidProtocolBufferException
      //   238	246	259	java/io/IOException
      //   238	246	255	finally
      //   260	287	255	finally
      //   288	303	255	finally
    }
    
    public TimeOperator getOperator() {
      TimeOperator timeOperator1 = TimeOperator.forNumber(this.operator_);
      TimeOperator timeOperator2 = timeOperator1;
      if (timeOperator1 == null)
        timeOperator2 = TimeOperator.UNRECOGNIZED; 
      return timeOperator2;
    }
    
    public int getOperatorValue() {
      return this.operator_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (this.operator_ != TimeOperator.UNKNOWN.getNumber())
        i = 0 + CodedOutputStream.computeEnumSize(1, this.operator_); 
      int j = i;
      if (this.targetDateTimeZone_ != null)
        j = i + CodedOutputStream.computeMessageSize(2, (MessageLite)getTargetDateTimeZone()); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public Conditions.TargetDateTimeZone getTargetDateTimeZone() {
      Conditions.TargetDateTimeZone targetDateTimeZone1 = this.targetDateTimeZone_;
      Conditions.TargetDateTimeZone targetDateTimeZone2 = targetDateTimeZone1;
      if (targetDateTimeZone1 == null)
        targetDateTimeZone2 = Conditions.TargetDateTimeZone.getDefaultInstance(); 
      return targetDateTimeZone2;
    }
    
    public boolean hasTargetDateTimeZone() {
      boolean bool;
      if (this.targetDateTimeZone_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.operator_ != TimeOperator.UNKNOWN.getNumber())
        param1CodedOutputStream.writeEnum(1, this.operator_); 
      if (this.targetDateTimeZone_ != null)
        param1CodedOutputStream.writeMessage(2, (MessageLite)getTargetDateTimeZone()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<DateTimeCondition, Builder> implements Conditions.DateTimeConditionOrBuilder {
      private Builder() {
        super(Conditions.DateTimeCondition.DEFAULT_INSTANCE);
      }
      
      public Builder clearOperator() {
        copyOnWrite();
        ((Conditions.DateTimeCondition)this.instance).clearOperator();
        return this;
      }
      
      public Builder clearTargetDateTimeZone() {
        copyOnWrite();
        ((Conditions.DateTimeCondition)this.instance).clearTargetDateTimeZone();
        return this;
      }
      
      public Conditions.DateTimeCondition.TimeOperator getOperator() {
        return ((Conditions.DateTimeCondition)this.instance).getOperator();
      }
      
      public int getOperatorValue() {
        return ((Conditions.DateTimeCondition)this.instance).getOperatorValue();
      }
      
      public Conditions.TargetDateTimeZone getTargetDateTimeZone() {
        return ((Conditions.DateTimeCondition)this.instance).getTargetDateTimeZone();
      }
      
      public boolean hasTargetDateTimeZone() {
        return ((Conditions.DateTimeCondition)this.instance).hasTargetDateTimeZone();
      }
      
      public Builder mergeTargetDateTimeZone(Conditions.TargetDateTimeZone param2TargetDateTimeZone) {
        copyOnWrite();
        ((Conditions.DateTimeCondition)this.instance).mergeTargetDateTimeZone(param2TargetDateTimeZone);
        return this;
      }
      
      public Builder setOperator(Conditions.DateTimeCondition.TimeOperator param2TimeOperator) {
        copyOnWrite();
        ((Conditions.DateTimeCondition)this.instance).setOperator(param2TimeOperator);
        return this;
      }
      
      public Builder setOperatorValue(int param2Int) {
        copyOnWrite();
        ((Conditions.DateTimeCondition)this.instance).setOperatorValue(param2Int);
        return this;
      }
      
      public Builder setTargetDateTimeZone(Conditions.TargetDateTimeZone.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.DateTimeCondition)this.instance).setTargetDateTimeZone(param2Builder);
        return this;
      }
      
      public Builder setTargetDateTimeZone(Conditions.TargetDateTimeZone param2TargetDateTimeZone) {
        copyOnWrite();
        ((Conditions.DateTimeCondition)this.instance).setTargetDateTimeZone(param2TargetDateTimeZone);
        return this;
      }
    }
    
    public enum TimeOperator implements Internal.EnumLite {
      AFTER_OR_EQUAL(0),
      BEFORE(0),
      UNKNOWN(0),
      UNRECOGNIZED(0);
      
      public static final int AFTER_OR_EQUAL_VALUE = 2;
      
      public static final int BEFORE_VALUE = 1;
      
      public static final int UNKNOWN_VALUE = 0;
      
      private static final Internal.EnumLiteMap<TimeOperator> internalValueMap;
      
      private final int value;
      
      static {
        $VALUES = new TimeOperator[] { UNKNOWN, BEFORE, AFTER_OR_EQUAL, UNRECOGNIZED };
        internalValueMap = new Internal.EnumLiteMap<TimeOperator>() {
            public Conditions.DateTimeCondition.TimeOperator findValueByNumber(int param3Int) {
              return Conditions.DateTimeCondition.TimeOperator.forNumber(param3Int);
            }
          };
      }
      
      TimeOperator(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static TimeOperator forNumber(int param2Int) {
        switch (param2Int) {
          default:
            return null;
          case 2:
            return AFTER_OR_EQUAL;
          case 1:
            return BEFORE;
          case 0:
            break;
        } 
        return UNKNOWN;
      }
      
      public static Internal.EnumLiteMap<TimeOperator> internalGetValueMap() {
        return internalValueMap;
      }
      
      public final int getNumber() {
        return this.value;
      }
    }
    
    class null implements Internal.EnumLiteMap<TimeOperator> {
      public Conditions.DateTimeCondition.TimeOperator findValueByNumber(int param2Int) {
        return Conditions.DateTimeCondition.TimeOperator.forNumber(param2Int);
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<DateTimeCondition, DateTimeCondition.Builder> implements DateTimeConditionOrBuilder {
    private Builder() {
      super(Conditions.DateTimeCondition.DEFAULT_INSTANCE);
    }
    
    public Builder clearOperator() {
      copyOnWrite();
      ((Conditions.DateTimeCondition)this.instance).clearOperator();
      return this;
    }
    
    public Builder clearTargetDateTimeZone() {
      copyOnWrite();
      ((Conditions.DateTimeCondition)this.instance).clearTargetDateTimeZone();
      return this;
    }
    
    public Conditions.DateTimeCondition.TimeOperator getOperator() {
      return ((Conditions.DateTimeCondition)this.instance).getOperator();
    }
    
    public int getOperatorValue() {
      return ((Conditions.DateTimeCondition)this.instance).getOperatorValue();
    }
    
    public Conditions.TargetDateTimeZone getTargetDateTimeZone() {
      return ((Conditions.DateTimeCondition)this.instance).getTargetDateTimeZone();
    }
    
    public boolean hasTargetDateTimeZone() {
      return ((Conditions.DateTimeCondition)this.instance).hasTargetDateTimeZone();
    }
    
    public Builder mergeTargetDateTimeZone(Conditions.TargetDateTimeZone param1TargetDateTimeZone) {
      copyOnWrite();
      ((Conditions.DateTimeCondition)this.instance).mergeTargetDateTimeZone(param1TargetDateTimeZone);
      return this;
    }
    
    public Builder setOperator(Conditions.DateTimeCondition.TimeOperator param1TimeOperator) {
      copyOnWrite();
      ((Conditions.DateTimeCondition)this.instance).setOperator(param1TimeOperator);
      return this;
    }
    
    public Builder setOperatorValue(int param1Int) {
      copyOnWrite();
      ((Conditions.DateTimeCondition)this.instance).setOperatorValue(param1Int);
      return this;
    }
    
    public Builder setTargetDateTimeZone(Conditions.TargetDateTimeZone.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.DateTimeCondition)this.instance).setTargetDateTimeZone(param1Builder);
      return this;
    }
    
    public Builder setTargetDateTimeZone(Conditions.TargetDateTimeZone param1TargetDateTimeZone) {
      copyOnWrite();
      ((Conditions.DateTimeCondition)this.instance).setTargetDateTimeZone(param1TargetDateTimeZone);
      return this;
    }
  }
  
  public enum TimeOperator implements Internal.EnumLite {
    AFTER_OR_EQUAL(0),
    BEFORE(0),
    UNKNOWN(0),
    UNRECOGNIZED(0);
    
    public static final int AFTER_OR_EQUAL_VALUE = 2;
    
    public static final int BEFORE_VALUE = 1;
    
    public static final int UNKNOWN_VALUE = 0;
    
    private static final Internal.EnumLiteMap<TimeOperator> internalValueMap;
    
    private final int value;
    
    static {
      AFTER_OR_EQUAL = new TimeOperator("AFTER_OR_EQUAL", 2, 2);
      UNRECOGNIZED = new TimeOperator("UNRECOGNIZED", 3, -1);
      $VALUES = new TimeOperator[] { UNKNOWN, BEFORE, AFTER_OR_EQUAL, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<TimeOperator>() {
          public Conditions.DateTimeCondition.TimeOperator findValueByNumber(int param3Int) {
            return Conditions.DateTimeCondition.TimeOperator.forNumber(param3Int);
          }
        };
    }
    
    TimeOperator(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static TimeOperator forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 2:
          return AFTER_OR_EQUAL;
        case 1:
          return BEFORE;
        case 0:
          break;
      } 
      return UNKNOWN;
    }
    
    public static Internal.EnumLiteMap<TimeOperator> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<DateTimeCondition.TimeOperator> {
    public Conditions.DateTimeCondition.TimeOperator findValueByNumber(int param1Int) {
      return Conditions.DateTimeCondition.TimeOperator.forNumber(param1Int);
    }
  }
  
  public static interface DateTimeConditionOrBuilder extends MessageLiteOrBuilder {
    Conditions.DateTimeCondition.TimeOperator getOperator();
    
    int getOperatorValue();
    
    Conditions.TargetDateTimeZone getTargetDateTimeZone();
    
    boolean hasTargetDateTimeZone();
  }
  
  public static final class DeviceCountryCondition extends GeneratedMessageLite<DeviceCountryCondition, DeviceCountryCondition.Builder> implements DeviceCountryConditionOrBuilder {
    private static final DeviceCountryCondition DEFAULT_INSTANCE = new DeviceCountryCondition();
    
    private static volatile Parser<DeviceCountryCondition> PARSER;
    
    public static final int TARGET_COUNTRY_CODES_FIELD_NUMBER = 1;
    
    private Internal.ProtobufList<String> targetCountryCodes_ = GeneratedMessageLite.emptyProtobufList();
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllTargetCountryCodes(Iterable<String> param1Iterable) {
      ensureTargetCountryCodesIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.targetCountryCodes_);
    }
    
    private void addTargetCountryCodes(String param1String) {
      if (param1String != null) {
        ensureTargetCountryCodesIsMutable();
        this.targetCountryCodes_.add(param1String);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addTargetCountryCodesBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        ensureTargetCountryCodesIsMutable();
        this.targetCountryCodes_.add(param1ByteString.toStringUtf8());
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearTargetCountryCodes() {
      this.targetCountryCodes_ = GeneratedMessageLite.emptyProtobufList();
    }
    
    private void ensureTargetCountryCodesIsMutable() {
      if (!this.targetCountryCodes_.isModifiable())
        this.targetCountryCodes_ = GeneratedMessageLite.mutableCopy(this.targetCountryCodes_); 
    }
    
    public static DeviceCountryCondition getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(DeviceCountryCondition param1DeviceCountryCondition) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1DeviceCountryCondition);
    }
    
    public static DeviceCountryCondition parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (DeviceCountryCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static DeviceCountryCondition parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (DeviceCountryCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static DeviceCountryCondition parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (DeviceCountryCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static DeviceCountryCondition parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (DeviceCountryCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static DeviceCountryCondition parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (DeviceCountryCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static DeviceCountryCondition parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (DeviceCountryCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static DeviceCountryCondition parseFrom(InputStream param1InputStream) throws IOException {
      return (DeviceCountryCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static DeviceCountryCondition parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (DeviceCountryCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static DeviceCountryCondition parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (DeviceCountryCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static DeviceCountryCondition parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (DeviceCountryCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<DeviceCountryCondition> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setTargetCountryCodes(int param1Int, String param1String) {
      if (param1String != null) {
        ensureTargetCountryCodesIsMutable();
        this.targetCountryCodes_.set(param1Int, param1String);
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/developers/mobile/targeting/proto/Conditions$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 321, 2 -> 317, 3 -> 306, 4 -> 297, 5 -> 263, 6 -> 110, 7 -> 259, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/developers/mobile/targeting/proto/Conditions$DeviceCountryCondition.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/developers/mobile/targeting/proto/Conditions$DeviceCountryCondition
      //   72: monitorenter
      //   73: getstatic com/google/developers/mobile/targeting/proto/Conditions$DeviceCountryCondition.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/developers/mobile/targeting/proto/Conditions$DeviceCountryCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$DeviceCountryCondition;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/developers/mobile/targeting/proto/Conditions$DeviceCountryCondition.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/developers/mobile/targeting/proto/Conditions$DeviceCountryCondition
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/developers/mobile/targeting/proto/Conditions$DeviceCountryCondition
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/developers/mobile/targeting/proto/Conditions$DeviceCountryCondition.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 259
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 203
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
      //   161: aload_1
      //   162: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   165: astore_2
      //   166: aload_0
      //   167: getfield targetCountryCodes_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   170: invokeinterface isModifiable : ()Z
      //   175: ifne -> 189
      //   178: aload_0
      //   179: aload_0
      //   180: getfield targetCountryCodes_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   183: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   186: putfield targetCountryCodes_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   189: aload_0
      //   190: getfield targetCountryCodes_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   193: aload_2
      //   194: invokeinterface add : (Ljava/lang/Object;)Z
      //   199: pop
      //   200: goto -> 123
      //   203: iconst_1
      //   204: istore #4
      //   206: goto -> 123
      //   209: astore_1
      //   210: goto -> 257
      //   213: astore_2
      //   214: new java/lang/RuntimeException
      //   217: astore_3
      //   218: new com/google/protobuf/InvalidProtocolBufferException
      //   221: astore_1
      //   222: aload_1
      //   223: aload_2
      //   224: invokevirtual getMessage : ()Ljava/lang/String;
      //   227: invokespecial <init> : (Ljava/lang/String;)V
      //   230: aload_3
      //   231: aload_1
      //   232: aload_0
      //   233: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   236: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   239: aload_3
      //   240: athrow
      //   241: astore_2
      //   242: new java/lang/RuntimeException
      //   245: astore_1
      //   246: aload_1
      //   247: aload_2
      //   248: aload_0
      //   249: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   252: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   255: aload_1
      //   256: athrow
      //   257: aload_1
      //   258: athrow
      //   259: getstatic com/google/developers/mobile/targeting/proto/Conditions$DeviceCountryCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$DeviceCountryCondition;
      //   262: areturn
      //   263: aload_2
      //   264: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   267: astore_1
      //   268: aload_3
      //   269: checkcast com/google/developers/mobile/targeting/proto/Conditions$DeviceCountryCondition
      //   272: astore_2
      //   273: aload_0
      //   274: aload_1
      //   275: aload_0
      //   276: getfield targetCountryCodes_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   279: aload_2
      //   280: getfield targetCountryCodes_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   283: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   288: putfield targetCountryCodes_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   291: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   294: astore_1
      //   295: aload_0
      //   296: areturn
      //   297: new com/google/developers/mobile/targeting/proto/Conditions$DeviceCountryCondition$Builder
      //   300: dup
      //   301: aconst_null
      //   302: invokespecial <init> : (Lcom/google/developers/mobile/targeting/proto/Conditions$1;)V
      //   305: areturn
      //   306: aload_0
      //   307: getfield targetCountryCodes_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   310: invokeinterface makeImmutable : ()V
      //   315: aconst_null
      //   316: areturn
      //   317: getstatic com/google/developers/mobile/targeting/proto/Conditions$DeviceCountryCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$DeviceCountryCondition;
      //   320: areturn
      //   321: new com/google/developers/mobile/targeting/proto/Conditions$DeviceCountryCondition
      //   324: dup
      //   325: invokespecial <init> : ()V
      //   328: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	241	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	213	java/io/IOException
      //   128	134	209	finally
      //   146	155	241	com/google/protobuf/InvalidProtocolBufferException
      //   146	155	213	java/io/IOException
      //   146	155	209	finally
      //   161	189	241	com/google/protobuf/InvalidProtocolBufferException
      //   161	189	213	java/io/IOException
      //   161	189	209	finally
      //   189	200	241	com/google/protobuf/InvalidProtocolBufferException
      //   189	200	213	java/io/IOException
      //   189	200	209	finally
      //   214	241	209	finally
      //   242	257	209	finally
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      byte b = 0;
      i = 0;
      while (b < this.targetCountryCodes_.size()) {
        i += CodedOutputStream.computeStringSizeNoTag((String)this.targetCountryCodes_.get(b));
        b++;
      } 
      i = 0 + i + getTargetCountryCodesList().size() * 1;
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public String getTargetCountryCodes(int param1Int) {
      return (String)this.targetCountryCodes_.get(param1Int);
    }
    
    public ByteString getTargetCountryCodesBytes(int param1Int) {
      return ByteString.copyFromUtf8((String)this.targetCountryCodes_.get(param1Int));
    }
    
    public int getTargetCountryCodesCount() {
      return this.targetCountryCodes_.size();
    }
    
    public List<String> getTargetCountryCodesList() {
      return (List<String>)this.targetCountryCodes_;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      for (byte b = 0; b < this.targetCountryCodes_.size(); b++)
        param1CodedOutputStream.writeString(1, (String)this.targetCountryCodes_.get(b)); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<DeviceCountryCondition, Builder> implements Conditions.DeviceCountryConditionOrBuilder {
      private Builder() {
        super(Conditions.DeviceCountryCondition.DEFAULT_INSTANCE);
      }
      
      public Builder addAllTargetCountryCodes(Iterable<String> param2Iterable) {
        copyOnWrite();
        ((Conditions.DeviceCountryCondition)this.instance).addAllTargetCountryCodes(param2Iterable);
        return this;
      }
      
      public Builder addTargetCountryCodes(String param2String) {
        copyOnWrite();
        ((Conditions.DeviceCountryCondition)this.instance).addTargetCountryCodes(param2String);
        return this;
      }
      
      public Builder addTargetCountryCodesBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((Conditions.DeviceCountryCondition)this.instance).addTargetCountryCodesBytes(param2ByteString);
        return this;
      }
      
      public Builder clearTargetCountryCodes() {
        copyOnWrite();
        ((Conditions.DeviceCountryCondition)this.instance).clearTargetCountryCodes();
        return this;
      }
      
      public String getTargetCountryCodes(int param2Int) {
        return ((Conditions.DeviceCountryCondition)this.instance).getTargetCountryCodes(param2Int);
      }
      
      public ByteString getTargetCountryCodesBytes(int param2Int) {
        return ((Conditions.DeviceCountryCondition)this.instance).getTargetCountryCodesBytes(param2Int);
      }
      
      public int getTargetCountryCodesCount() {
        return ((Conditions.DeviceCountryCondition)this.instance).getTargetCountryCodesCount();
      }
      
      public List<String> getTargetCountryCodesList() {
        return Collections.unmodifiableList(((Conditions.DeviceCountryCondition)this.instance).getTargetCountryCodesList());
      }
      
      public Builder setTargetCountryCodes(int param2Int, String param2String) {
        copyOnWrite();
        ((Conditions.DeviceCountryCondition)this.instance).setTargetCountryCodes(param2Int, param2String);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<DeviceCountryCondition, DeviceCountryCondition.Builder> implements DeviceCountryConditionOrBuilder {
    private Builder() {
      super(Conditions.DeviceCountryCondition.DEFAULT_INSTANCE);
    }
    
    public Builder addAllTargetCountryCodes(Iterable<String> param1Iterable) {
      copyOnWrite();
      ((Conditions.DeviceCountryCondition)this.instance).addAllTargetCountryCodes(param1Iterable);
      return this;
    }
    
    public Builder addTargetCountryCodes(String param1String) {
      copyOnWrite();
      ((Conditions.DeviceCountryCondition)this.instance).addTargetCountryCodes(param1String);
      return this;
    }
    
    public Builder addTargetCountryCodesBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Conditions.DeviceCountryCondition)this.instance).addTargetCountryCodesBytes(param1ByteString);
      return this;
    }
    
    public Builder clearTargetCountryCodes() {
      copyOnWrite();
      ((Conditions.DeviceCountryCondition)this.instance).clearTargetCountryCodes();
      return this;
    }
    
    public String getTargetCountryCodes(int param1Int) {
      return ((Conditions.DeviceCountryCondition)this.instance).getTargetCountryCodes(param1Int);
    }
    
    public ByteString getTargetCountryCodesBytes(int param1Int) {
      return ((Conditions.DeviceCountryCondition)this.instance).getTargetCountryCodesBytes(param1Int);
    }
    
    public int getTargetCountryCodesCount() {
      return ((Conditions.DeviceCountryCondition)this.instance).getTargetCountryCodesCount();
    }
    
    public List<String> getTargetCountryCodesList() {
      return Collections.unmodifiableList(((Conditions.DeviceCountryCondition)this.instance).getTargetCountryCodesList());
    }
    
    public Builder setTargetCountryCodes(int param1Int, String param1String) {
      copyOnWrite();
      ((Conditions.DeviceCountryCondition)this.instance).setTargetCountryCodes(param1Int, param1String);
      return this;
    }
  }
  
  public static interface DeviceCountryConditionOrBuilder extends MessageLiteOrBuilder {
    String getTargetCountryCodes(int param1Int);
    
    ByteString getTargetCountryCodesBytes(int param1Int);
    
    int getTargetCountryCodesCount();
    
    List<String> getTargetCountryCodesList();
  }
  
  public static final class DeviceLanguageCondition extends GeneratedMessageLite<DeviceLanguageCondition, DeviceLanguageCondition.Builder> implements DeviceLanguageConditionOrBuilder {
    private static final DeviceLanguageCondition DEFAULT_INSTANCE = new DeviceLanguageCondition();
    
    private static volatile Parser<DeviceLanguageCondition> PARSER;
    
    public static final int TARGET_LANGUAGE_CODES_FIELD_NUMBER = 1;
    
    private Internal.ProtobufList<String> targetLanguageCodes_ = GeneratedMessageLite.emptyProtobufList();
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllTargetLanguageCodes(Iterable<String> param1Iterable) {
      ensureTargetLanguageCodesIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.targetLanguageCodes_);
    }
    
    private void addTargetLanguageCodes(String param1String) {
      if (param1String != null) {
        ensureTargetLanguageCodesIsMutable();
        this.targetLanguageCodes_.add(param1String);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addTargetLanguageCodesBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        ensureTargetLanguageCodesIsMutable();
        this.targetLanguageCodes_.add(param1ByteString.toStringUtf8());
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearTargetLanguageCodes() {
      this.targetLanguageCodes_ = GeneratedMessageLite.emptyProtobufList();
    }
    
    private void ensureTargetLanguageCodesIsMutable() {
      if (!this.targetLanguageCodes_.isModifiable())
        this.targetLanguageCodes_ = GeneratedMessageLite.mutableCopy(this.targetLanguageCodes_); 
    }
    
    public static DeviceLanguageCondition getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(DeviceLanguageCondition param1DeviceLanguageCondition) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1DeviceLanguageCondition);
    }
    
    public static DeviceLanguageCondition parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (DeviceLanguageCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static DeviceLanguageCondition parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (DeviceLanguageCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static DeviceLanguageCondition parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (DeviceLanguageCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static DeviceLanguageCondition parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (DeviceLanguageCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static DeviceLanguageCondition parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (DeviceLanguageCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static DeviceLanguageCondition parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (DeviceLanguageCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static DeviceLanguageCondition parseFrom(InputStream param1InputStream) throws IOException {
      return (DeviceLanguageCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static DeviceLanguageCondition parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (DeviceLanguageCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static DeviceLanguageCondition parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (DeviceLanguageCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static DeviceLanguageCondition parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (DeviceLanguageCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<DeviceLanguageCondition> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setTargetLanguageCodes(int param1Int, String param1String) {
      if (param1String != null) {
        ensureTargetLanguageCodesIsMutable();
        this.targetLanguageCodes_.set(param1Int, param1String);
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/developers/mobile/targeting/proto/Conditions$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 321, 2 -> 317, 3 -> 306, 4 -> 297, 5 -> 263, 6 -> 110, 7 -> 259, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/developers/mobile/targeting/proto/Conditions$DeviceLanguageCondition.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/developers/mobile/targeting/proto/Conditions$DeviceLanguageCondition
      //   72: monitorenter
      //   73: getstatic com/google/developers/mobile/targeting/proto/Conditions$DeviceLanguageCondition.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/developers/mobile/targeting/proto/Conditions$DeviceLanguageCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$DeviceLanguageCondition;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/developers/mobile/targeting/proto/Conditions$DeviceLanguageCondition.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/developers/mobile/targeting/proto/Conditions$DeviceLanguageCondition
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/developers/mobile/targeting/proto/Conditions$DeviceLanguageCondition
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/developers/mobile/targeting/proto/Conditions$DeviceLanguageCondition.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 259
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 203
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
      //   161: aload_1
      //   162: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   165: astore_2
      //   166: aload_0
      //   167: getfield targetLanguageCodes_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   170: invokeinterface isModifiable : ()Z
      //   175: ifne -> 189
      //   178: aload_0
      //   179: aload_0
      //   180: getfield targetLanguageCodes_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   183: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   186: putfield targetLanguageCodes_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   189: aload_0
      //   190: getfield targetLanguageCodes_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   193: aload_2
      //   194: invokeinterface add : (Ljava/lang/Object;)Z
      //   199: pop
      //   200: goto -> 123
      //   203: iconst_1
      //   204: istore #4
      //   206: goto -> 123
      //   209: astore_1
      //   210: goto -> 257
      //   213: astore_3
      //   214: new java/lang/RuntimeException
      //   217: astore_1
      //   218: new com/google/protobuf/InvalidProtocolBufferException
      //   221: astore_2
      //   222: aload_2
      //   223: aload_3
      //   224: invokevirtual getMessage : ()Ljava/lang/String;
      //   227: invokespecial <init> : (Ljava/lang/String;)V
      //   230: aload_1
      //   231: aload_2
      //   232: aload_0
      //   233: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   236: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   239: aload_1
      //   240: athrow
      //   241: astore_1
      //   242: new java/lang/RuntimeException
      //   245: astore_2
      //   246: aload_2
      //   247: aload_1
      //   248: aload_0
      //   249: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   252: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   255: aload_2
      //   256: athrow
      //   257: aload_1
      //   258: athrow
      //   259: getstatic com/google/developers/mobile/targeting/proto/Conditions$DeviceLanguageCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$DeviceLanguageCondition;
      //   262: areturn
      //   263: aload_2
      //   264: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   267: astore_1
      //   268: aload_3
      //   269: checkcast com/google/developers/mobile/targeting/proto/Conditions$DeviceLanguageCondition
      //   272: astore_2
      //   273: aload_0
      //   274: aload_1
      //   275: aload_0
      //   276: getfield targetLanguageCodes_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   279: aload_2
      //   280: getfield targetLanguageCodes_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   283: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   288: putfield targetLanguageCodes_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   291: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   294: astore_1
      //   295: aload_0
      //   296: areturn
      //   297: new com/google/developers/mobile/targeting/proto/Conditions$DeviceLanguageCondition$Builder
      //   300: dup
      //   301: aconst_null
      //   302: invokespecial <init> : (Lcom/google/developers/mobile/targeting/proto/Conditions$1;)V
      //   305: areturn
      //   306: aload_0
      //   307: getfield targetLanguageCodes_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   310: invokeinterface makeImmutable : ()V
      //   315: aconst_null
      //   316: areturn
      //   317: getstatic com/google/developers/mobile/targeting/proto/Conditions$DeviceLanguageCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$DeviceLanguageCondition;
      //   320: areturn
      //   321: new com/google/developers/mobile/targeting/proto/Conditions$DeviceLanguageCondition
      //   324: dup
      //   325: invokespecial <init> : ()V
      //   328: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	241	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	213	java/io/IOException
      //   128	134	209	finally
      //   146	155	241	com/google/protobuf/InvalidProtocolBufferException
      //   146	155	213	java/io/IOException
      //   146	155	209	finally
      //   161	189	241	com/google/protobuf/InvalidProtocolBufferException
      //   161	189	213	java/io/IOException
      //   161	189	209	finally
      //   189	200	241	com/google/protobuf/InvalidProtocolBufferException
      //   189	200	213	java/io/IOException
      //   189	200	209	finally
      //   214	241	209	finally
      //   242	257	209	finally
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      int j = 0;
      while (i < this.targetLanguageCodes_.size()) {
        j += CodedOutputStream.computeStringSizeNoTag((String)this.targetLanguageCodes_.get(i));
        i++;
      } 
      i = 0 + j + getTargetLanguageCodesList().size() * 1;
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public String getTargetLanguageCodes(int param1Int) {
      return (String)this.targetLanguageCodes_.get(param1Int);
    }
    
    public ByteString getTargetLanguageCodesBytes(int param1Int) {
      return ByteString.copyFromUtf8((String)this.targetLanguageCodes_.get(param1Int));
    }
    
    public int getTargetLanguageCodesCount() {
      return this.targetLanguageCodes_.size();
    }
    
    public List<String> getTargetLanguageCodesList() {
      return (List<String>)this.targetLanguageCodes_;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      for (byte b = 0; b < this.targetLanguageCodes_.size(); b++)
        param1CodedOutputStream.writeString(1, (String)this.targetLanguageCodes_.get(b)); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<DeviceLanguageCondition, Builder> implements Conditions.DeviceLanguageConditionOrBuilder {
      private Builder() {
        super(Conditions.DeviceLanguageCondition.DEFAULT_INSTANCE);
      }
      
      public Builder addAllTargetLanguageCodes(Iterable<String> param2Iterable) {
        copyOnWrite();
        ((Conditions.DeviceLanguageCondition)this.instance).addAllTargetLanguageCodes(param2Iterable);
        return this;
      }
      
      public Builder addTargetLanguageCodes(String param2String) {
        copyOnWrite();
        ((Conditions.DeviceLanguageCondition)this.instance).addTargetLanguageCodes(param2String);
        return this;
      }
      
      public Builder addTargetLanguageCodesBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((Conditions.DeviceLanguageCondition)this.instance).addTargetLanguageCodesBytes(param2ByteString);
        return this;
      }
      
      public Builder clearTargetLanguageCodes() {
        copyOnWrite();
        ((Conditions.DeviceLanguageCondition)this.instance).clearTargetLanguageCodes();
        return this;
      }
      
      public String getTargetLanguageCodes(int param2Int) {
        return ((Conditions.DeviceLanguageCondition)this.instance).getTargetLanguageCodes(param2Int);
      }
      
      public ByteString getTargetLanguageCodesBytes(int param2Int) {
        return ((Conditions.DeviceLanguageCondition)this.instance).getTargetLanguageCodesBytes(param2Int);
      }
      
      public int getTargetLanguageCodesCount() {
        return ((Conditions.DeviceLanguageCondition)this.instance).getTargetLanguageCodesCount();
      }
      
      public List<String> getTargetLanguageCodesList() {
        return Collections.unmodifiableList(((Conditions.DeviceLanguageCondition)this.instance).getTargetLanguageCodesList());
      }
      
      public Builder setTargetLanguageCodes(int param2Int, String param2String) {
        copyOnWrite();
        ((Conditions.DeviceLanguageCondition)this.instance).setTargetLanguageCodes(param2Int, param2String);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<DeviceLanguageCondition, DeviceLanguageCondition.Builder> implements DeviceLanguageConditionOrBuilder {
    private Builder() {
      super(Conditions.DeviceLanguageCondition.DEFAULT_INSTANCE);
    }
    
    public Builder addAllTargetLanguageCodes(Iterable<String> param1Iterable) {
      copyOnWrite();
      ((Conditions.DeviceLanguageCondition)this.instance).addAllTargetLanguageCodes(param1Iterable);
      return this;
    }
    
    public Builder addTargetLanguageCodes(String param1String) {
      copyOnWrite();
      ((Conditions.DeviceLanguageCondition)this.instance).addTargetLanguageCodes(param1String);
      return this;
    }
    
    public Builder addTargetLanguageCodesBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Conditions.DeviceLanguageCondition)this.instance).addTargetLanguageCodesBytes(param1ByteString);
      return this;
    }
    
    public Builder clearTargetLanguageCodes() {
      copyOnWrite();
      ((Conditions.DeviceLanguageCondition)this.instance).clearTargetLanguageCodes();
      return this;
    }
    
    public String getTargetLanguageCodes(int param1Int) {
      return ((Conditions.DeviceLanguageCondition)this.instance).getTargetLanguageCodes(param1Int);
    }
    
    public ByteString getTargetLanguageCodesBytes(int param1Int) {
      return ((Conditions.DeviceLanguageCondition)this.instance).getTargetLanguageCodesBytes(param1Int);
    }
    
    public int getTargetLanguageCodesCount() {
      return ((Conditions.DeviceLanguageCondition)this.instance).getTargetLanguageCodesCount();
    }
    
    public List<String> getTargetLanguageCodesList() {
      return Collections.unmodifiableList(((Conditions.DeviceLanguageCondition)this.instance).getTargetLanguageCodesList());
    }
    
    public Builder setTargetLanguageCodes(int param1Int, String param1String) {
      copyOnWrite();
      ((Conditions.DeviceLanguageCondition)this.instance).setTargetLanguageCodes(param1Int, param1String);
      return this;
    }
  }
  
  public static interface DeviceLanguageConditionOrBuilder extends MessageLiteOrBuilder {
    String getTargetLanguageCodes(int param1Int);
    
    ByteString getTargetLanguageCodesBytes(int param1Int);
    
    int getTargetLanguageCodesCount();
    
    List<String> getTargetLanguageCodesList();
  }
  
  public static final class FalseCondition extends GeneratedMessageLite<FalseCondition, FalseCondition.Builder> implements FalseConditionOrBuilder {
    private static final FalseCondition DEFAULT_INSTANCE = new FalseCondition();
    
    private static volatile Parser<FalseCondition> PARSER;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    public static FalseCondition getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(FalseCondition param1FalseCondition) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1FalseCondition);
    }
    
    public static FalseCondition parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (FalseCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static FalseCondition parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FalseCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FalseCondition parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (FalseCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static FalseCondition parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FalseCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static FalseCondition parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (FalseCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static FalseCondition parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FalseCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static FalseCondition parseFrom(InputStream param1InputStream) throws IOException {
      return (FalseCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static FalseCondition parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FalseCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FalseCondition parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (FalseCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static FalseCondition parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FalseCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<FalseCondition> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/developers/mobile/targeting/proto/Conditions$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 249, 2 -> 245, 3 -> 243, 4 -> 234, 5 -> 218, 6 -> 110, 7 -> 214, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/developers/mobile/targeting/proto/Conditions$FalseCondition.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/developers/mobile/targeting/proto/Conditions$FalseCondition
      //   72: monitorenter
      //   73: getstatic com/google/developers/mobile/targeting/proto/Conditions$FalseCondition.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/developers/mobile/targeting/proto/Conditions$FalseCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$FalseCondition;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/developers/mobile/targeting/proto/Conditions$FalseCondition.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/developers/mobile/targeting/proto/Conditions$FalseCondition
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/developers/mobile/targeting/proto/Conditions$FalseCondition
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/developers/mobile/targeting/proto/Conditions$FalseCondition.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 214
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 158
      //   139: aload_1
      //   140: iload #5
      //   142: invokevirtual skipField : (I)Z
      //   145: istore #6
      //   147: iload #6
      //   149: ifne -> 123
      //   152: iconst_1
      //   153: istore #4
      //   155: goto -> 123
      //   158: iconst_1
      //   159: istore #4
      //   161: goto -> 123
      //   164: astore_1
      //   165: goto -> 212
      //   168: astore_2
      //   169: new java/lang/RuntimeException
      //   172: astore_1
      //   173: new com/google/protobuf/InvalidProtocolBufferException
      //   176: astore_3
      //   177: aload_3
      //   178: aload_2
      //   179: invokevirtual getMessage : ()Ljava/lang/String;
      //   182: invokespecial <init> : (Ljava/lang/String;)V
      //   185: aload_1
      //   186: aload_3
      //   187: aload_0
      //   188: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   191: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   194: aload_1
      //   195: athrow
      //   196: astore_1
      //   197: new java/lang/RuntimeException
      //   200: astore_2
      //   201: aload_2
      //   202: aload_1
      //   203: aload_0
      //   204: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   207: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   210: aload_2
      //   211: athrow
      //   212: aload_1
      //   213: athrow
      //   214: getstatic com/google/developers/mobile/targeting/proto/Conditions$FalseCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$FalseCondition;
      //   217: areturn
      //   218: aload_2
      //   219: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   222: astore_1
      //   223: aload_3
      //   224: checkcast com/google/developers/mobile/targeting/proto/Conditions$FalseCondition
      //   227: astore_1
      //   228: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   231: astore_1
      //   232: aload_0
      //   233: areturn
      //   234: new com/google/developers/mobile/targeting/proto/Conditions$FalseCondition$Builder
      //   237: dup
      //   238: aconst_null
      //   239: invokespecial <init> : (Lcom/google/developers/mobile/targeting/proto/Conditions$1;)V
      //   242: areturn
      //   243: aconst_null
      //   244: areturn
      //   245: getstatic com/google/developers/mobile/targeting/proto/Conditions$FalseCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$FalseCondition;
      //   248: areturn
      //   249: new com/google/developers/mobile/targeting/proto/Conditions$FalseCondition
      //   252: dup
      //   253: invokespecial <init> : ()V
      //   256: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	196	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	168	java/io/IOException
      //   128	134	164	finally
      //   139	147	196	com/google/protobuf/InvalidProtocolBufferException
      //   139	147	168	java/io/IOException
      //   139	147	164	finally
      //   169	196	164	finally
      //   197	212	164	finally
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      this.memoizedSerializedSize = 0;
      return 0;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {}
    
    public static final class Builder extends GeneratedMessageLite.Builder<FalseCondition, Builder> implements Conditions.FalseConditionOrBuilder {
      private Builder() {
        super(Conditions.FalseCondition.DEFAULT_INSTANCE);
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<FalseCondition, FalseCondition.Builder> implements FalseConditionOrBuilder {
    private Builder() {
      super(Conditions.FalseCondition.DEFAULT_INSTANCE);
    }
  }
  
  public static interface FalseConditionOrBuilder extends MessageLiteOrBuilder {}
  
  public static final class FirebaseAppIdCondition extends GeneratedMessageLite<FirebaseAppIdCondition, FirebaseAppIdCondition.Builder> implements FirebaseAppIdConditionOrBuilder {
    private static final FirebaseAppIdCondition DEFAULT_INSTANCE = new FirebaseAppIdCondition();
    
    private static volatile Parser<FirebaseAppIdCondition> PARSER;
    
    public static final int TARGET_GMP_APP_ID_FIELD_NUMBER = 1;
    
    private String targetGmpAppId_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearTargetGmpAppId() {
      this.targetGmpAppId_ = getDefaultInstance().getTargetGmpAppId();
    }
    
    public static FirebaseAppIdCondition getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(FirebaseAppIdCondition param1FirebaseAppIdCondition) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1FirebaseAppIdCondition);
    }
    
    public static FirebaseAppIdCondition parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (FirebaseAppIdCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static FirebaseAppIdCondition parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FirebaseAppIdCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FirebaseAppIdCondition parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (FirebaseAppIdCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static FirebaseAppIdCondition parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FirebaseAppIdCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static FirebaseAppIdCondition parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (FirebaseAppIdCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static FirebaseAppIdCondition parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FirebaseAppIdCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static FirebaseAppIdCondition parseFrom(InputStream param1InputStream) throws IOException {
      return (FirebaseAppIdCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static FirebaseAppIdCondition parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FirebaseAppIdCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FirebaseAppIdCondition parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (FirebaseAppIdCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static FirebaseAppIdCondition parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FirebaseAppIdCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<FirebaseAppIdCondition> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setTargetGmpAppId(String param1String) {
      if (param1String != null) {
        this.targetGmpAppId_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTargetGmpAppIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.targetGmpAppId_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/developers/mobile/targeting/proto/Conditions$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 299, 2 -> 295, 3 -> 293, 4 -> 284, 5 -> 232, 6 -> 110, 7 -> 228, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/developers/mobile/targeting/proto/Conditions$FirebaseAppIdCondition.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/developers/mobile/targeting/proto/Conditions$FirebaseAppIdCondition
      //   72: monitorenter
      //   73: getstatic com/google/developers/mobile/targeting/proto/Conditions$FirebaseAppIdCondition.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/developers/mobile/targeting/proto/Conditions$FirebaseAppIdCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$FirebaseAppIdCondition;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/developers/mobile/targeting/proto/Conditions$FirebaseAppIdCondition.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/developers/mobile/targeting/proto/Conditions$FirebaseAppIdCondition
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/developers/mobile/targeting/proto/Conditions$FirebaseAppIdCondition
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/developers/mobile/targeting/proto/Conditions$FirebaseAppIdCondition.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 228
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 172
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
      //   162: aload_1
      //   163: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   166: putfield targetGmpAppId_ : Ljava/lang/String;
      //   169: goto -> 123
      //   172: iconst_1
      //   173: istore #4
      //   175: goto -> 123
      //   178: astore_1
      //   179: goto -> 226
      //   182: astore_3
      //   183: new java/lang/RuntimeException
      //   186: astore_1
      //   187: new com/google/protobuf/InvalidProtocolBufferException
      //   190: astore_2
      //   191: aload_2
      //   192: aload_3
      //   193: invokevirtual getMessage : ()Ljava/lang/String;
      //   196: invokespecial <init> : (Ljava/lang/String;)V
      //   199: aload_1
      //   200: aload_2
      //   201: aload_0
      //   202: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   205: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   208: aload_1
      //   209: athrow
      //   210: astore_1
      //   211: new java/lang/RuntimeException
      //   214: astore_2
      //   215: aload_2
      //   216: aload_1
      //   217: aload_0
      //   218: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   221: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   224: aload_2
      //   225: athrow
      //   226: aload_1
      //   227: athrow
      //   228: getstatic com/google/developers/mobile/targeting/proto/Conditions$FirebaseAppIdCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$FirebaseAppIdCondition;
      //   231: areturn
      //   232: aload_2
      //   233: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   236: astore_1
      //   237: aload_3
      //   238: checkcast com/google/developers/mobile/targeting/proto/Conditions$FirebaseAppIdCondition
      //   241: astore_2
      //   242: aload_0
      //   243: aload_1
      //   244: aload_0
      //   245: getfield targetGmpAppId_ : Ljava/lang/String;
      //   248: invokevirtual isEmpty : ()Z
      //   251: iconst_1
      //   252: ixor
      //   253: aload_0
      //   254: getfield targetGmpAppId_ : Ljava/lang/String;
      //   257: iconst_1
      //   258: aload_2
      //   259: getfield targetGmpAppId_ : Ljava/lang/String;
      //   262: invokevirtual isEmpty : ()Z
      //   265: ixor
      //   266: aload_2
      //   267: getfield targetGmpAppId_ : Ljava/lang/String;
      //   270: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   275: putfield targetGmpAppId_ : Ljava/lang/String;
      //   278: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   281: astore_1
      //   282: aload_0
      //   283: areturn
      //   284: new com/google/developers/mobile/targeting/proto/Conditions$FirebaseAppIdCondition$Builder
      //   287: dup
      //   288: aconst_null
      //   289: invokespecial <init> : (Lcom/google/developers/mobile/targeting/proto/Conditions$1;)V
      //   292: areturn
      //   293: aconst_null
      //   294: areturn
      //   295: getstatic com/google/developers/mobile/targeting/proto/Conditions$FirebaseAppIdCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$FirebaseAppIdCondition;
      //   298: areturn
      //   299: new com/google/developers/mobile/targeting/proto/Conditions$FirebaseAppIdCondition
      //   302: dup
      //   303: invokespecial <init> : ()V
      //   306: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	210	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	182	java/io/IOException
      //   128	134	178	finally
      //   146	155	210	com/google/protobuf/InvalidProtocolBufferException
      //   146	155	182	java/io/IOException
      //   146	155	178	finally
      //   161	169	210	com/google/protobuf/InvalidProtocolBufferException
      //   161	169	182	java/io/IOException
      //   161	169	178	finally
      //   183	210	178	finally
      //   211	226	178	finally
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (!this.targetGmpAppId_.isEmpty())
        i = 0 + CodedOutputStream.computeStringSize(1, getTargetGmpAppId()); 
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public String getTargetGmpAppId() {
      return this.targetGmpAppId_;
    }
    
    public ByteString getTargetGmpAppIdBytes() {
      return ByteString.copyFromUtf8(this.targetGmpAppId_);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.targetGmpAppId_.isEmpty())
        param1CodedOutputStream.writeString(1, getTargetGmpAppId()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<FirebaseAppIdCondition, Builder> implements Conditions.FirebaseAppIdConditionOrBuilder {
      private Builder() {
        super(Conditions.FirebaseAppIdCondition.DEFAULT_INSTANCE);
      }
      
      public Builder clearTargetGmpAppId() {
        copyOnWrite();
        ((Conditions.FirebaseAppIdCondition)this.instance).clearTargetGmpAppId();
        return this;
      }
      
      public String getTargetGmpAppId() {
        return ((Conditions.FirebaseAppIdCondition)this.instance).getTargetGmpAppId();
      }
      
      public ByteString getTargetGmpAppIdBytes() {
        return ((Conditions.FirebaseAppIdCondition)this.instance).getTargetGmpAppIdBytes();
      }
      
      public Builder setTargetGmpAppId(String param2String) {
        copyOnWrite();
        ((Conditions.FirebaseAppIdCondition)this.instance).setTargetGmpAppId(param2String);
        return this;
      }
      
      public Builder setTargetGmpAppIdBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((Conditions.FirebaseAppIdCondition)this.instance).setTargetGmpAppIdBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<FirebaseAppIdCondition, FirebaseAppIdCondition.Builder> implements FirebaseAppIdConditionOrBuilder {
    private Builder() {
      super(Conditions.FirebaseAppIdCondition.DEFAULT_INSTANCE);
    }
    
    public Builder clearTargetGmpAppId() {
      copyOnWrite();
      ((Conditions.FirebaseAppIdCondition)this.instance).clearTargetGmpAppId();
      return this;
    }
    
    public String getTargetGmpAppId() {
      return ((Conditions.FirebaseAppIdCondition)this.instance).getTargetGmpAppId();
    }
    
    public ByteString getTargetGmpAppIdBytes() {
      return ((Conditions.FirebaseAppIdCondition)this.instance).getTargetGmpAppIdBytes();
    }
    
    public Builder setTargetGmpAppId(String param1String) {
      copyOnWrite();
      ((Conditions.FirebaseAppIdCondition)this.instance).setTargetGmpAppId(param1String);
      return this;
    }
    
    public Builder setTargetGmpAppIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Conditions.FirebaseAppIdCondition)this.instance).setTargetGmpAppIdBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface FirebaseAppIdConditionOrBuilder extends MessageLiteOrBuilder {
    String getTargetGmpAppId();
    
    ByteString getTargetGmpAppIdBytes();
  }
  
  public static final class FunctionCondition extends GeneratedMessageLite<FunctionCondition, FunctionCondition.Builder> implements FunctionConditionOrBuilder {
    private static final FunctionCondition DEFAULT_INSTANCE = new FunctionCondition();
    
    public static final int FUNCTION_URL_FIELD_NUMBER = 1;
    
    private static volatile Parser<FunctionCondition> PARSER;
    
    private String functionUrl_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearFunctionUrl() {
      this.functionUrl_ = getDefaultInstance().getFunctionUrl();
    }
    
    public static FunctionCondition getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(FunctionCondition param1FunctionCondition) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1FunctionCondition);
    }
    
    public static FunctionCondition parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (FunctionCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static FunctionCondition parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FunctionCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FunctionCondition parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (FunctionCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static FunctionCondition parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FunctionCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static FunctionCondition parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (FunctionCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static FunctionCondition parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FunctionCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static FunctionCondition parseFrom(InputStream param1InputStream) throws IOException {
      return (FunctionCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static FunctionCondition parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FunctionCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FunctionCondition parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (FunctionCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static FunctionCondition parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FunctionCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<FunctionCondition> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setFunctionUrl(String param1String) {
      if (param1String != null) {
        this.functionUrl_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setFunctionUrlBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.functionUrl_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/developers/mobile/targeting/proto/Conditions$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 299, 2 -> 295, 3 -> 293, 4 -> 284, 5 -> 232, 6 -> 110, 7 -> 228, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/developers/mobile/targeting/proto/Conditions$FunctionCondition.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/developers/mobile/targeting/proto/Conditions$FunctionCondition
      //   72: monitorenter
      //   73: getstatic com/google/developers/mobile/targeting/proto/Conditions$FunctionCondition.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/developers/mobile/targeting/proto/Conditions$FunctionCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$FunctionCondition;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/developers/mobile/targeting/proto/Conditions$FunctionCondition.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/developers/mobile/targeting/proto/Conditions$FunctionCondition
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/developers/mobile/targeting/proto/Conditions$FunctionCondition
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/developers/mobile/targeting/proto/Conditions$FunctionCondition.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 228
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 172
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
      //   162: aload_1
      //   163: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   166: putfield functionUrl_ : Ljava/lang/String;
      //   169: goto -> 123
      //   172: iconst_1
      //   173: istore #4
      //   175: goto -> 123
      //   178: astore_1
      //   179: goto -> 226
      //   182: astore_1
      //   183: new java/lang/RuntimeException
      //   186: astore_3
      //   187: new com/google/protobuf/InvalidProtocolBufferException
      //   190: astore_2
      //   191: aload_2
      //   192: aload_1
      //   193: invokevirtual getMessage : ()Ljava/lang/String;
      //   196: invokespecial <init> : (Ljava/lang/String;)V
      //   199: aload_3
      //   200: aload_2
      //   201: aload_0
      //   202: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   205: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   208: aload_3
      //   209: athrow
      //   210: astore_1
      //   211: new java/lang/RuntimeException
      //   214: astore_2
      //   215: aload_2
      //   216: aload_1
      //   217: aload_0
      //   218: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   221: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   224: aload_2
      //   225: athrow
      //   226: aload_1
      //   227: athrow
      //   228: getstatic com/google/developers/mobile/targeting/proto/Conditions$FunctionCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$FunctionCondition;
      //   231: areturn
      //   232: aload_2
      //   233: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   236: astore_1
      //   237: aload_3
      //   238: checkcast com/google/developers/mobile/targeting/proto/Conditions$FunctionCondition
      //   241: astore_2
      //   242: aload_0
      //   243: aload_1
      //   244: aload_0
      //   245: getfield functionUrl_ : Ljava/lang/String;
      //   248: invokevirtual isEmpty : ()Z
      //   251: iconst_1
      //   252: ixor
      //   253: aload_0
      //   254: getfield functionUrl_ : Ljava/lang/String;
      //   257: iconst_1
      //   258: aload_2
      //   259: getfield functionUrl_ : Ljava/lang/String;
      //   262: invokevirtual isEmpty : ()Z
      //   265: ixor
      //   266: aload_2
      //   267: getfield functionUrl_ : Ljava/lang/String;
      //   270: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   275: putfield functionUrl_ : Ljava/lang/String;
      //   278: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   281: astore_1
      //   282: aload_0
      //   283: areturn
      //   284: new com/google/developers/mobile/targeting/proto/Conditions$FunctionCondition$Builder
      //   287: dup
      //   288: aconst_null
      //   289: invokespecial <init> : (Lcom/google/developers/mobile/targeting/proto/Conditions$1;)V
      //   292: areturn
      //   293: aconst_null
      //   294: areturn
      //   295: getstatic com/google/developers/mobile/targeting/proto/Conditions$FunctionCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$FunctionCondition;
      //   298: areturn
      //   299: new com/google/developers/mobile/targeting/proto/Conditions$FunctionCondition
      //   302: dup
      //   303: invokespecial <init> : ()V
      //   306: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	210	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	182	java/io/IOException
      //   128	134	178	finally
      //   146	155	210	com/google/protobuf/InvalidProtocolBufferException
      //   146	155	182	java/io/IOException
      //   146	155	178	finally
      //   161	169	210	com/google/protobuf/InvalidProtocolBufferException
      //   161	169	182	java/io/IOException
      //   161	169	178	finally
      //   183	210	178	finally
      //   211	226	178	finally
    }
    
    public String getFunctionUrl() {
      return this.functionUrl_;
    }
    
    public ByteString getFunctionUrlBytes() {
      return ByteString.copyFromUtf8(this.functionUrl_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (!this.functionUrl_.isEmpty())
        i = 0 + CodedOutputStream.computeStringSize(1, getFunctionUrl()); 
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.functionUrl_.isEmpty())
        param1CodedOutputStream.writeString(1, getFunctionUrl()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<FunctionCondition, Builder> implements Conditions.FunctionConditionOrBuilder {
      private Builder() {
        super(Conditions.FunctionCondition.DEFAULT_INSTANCE);
      }
      
      public Builder clearFunctionUrl() {
        copyOnWrite();
        ((Conditions.FunctionCondition)this.instance).clearFunctionUrl();
        return this;
      }
      
      public String getFunctionUrl() {
        return ((Conditions.FunctionCondition)this.instance).getFunctionUrl();
      }
      
      public ByteString getFunctionUrlBytes() {
        return ((Conditions.FunctionCondition)this.instance).getFunctionUrlBytes();
      }
      
      public Builder setFunctionUrl(String param2String) {
        copyOnWrite();
        ((Conditions.FunctionCondition)this.instance).setFunctionUrl(param2String);
        return this;
      }
      
      public Builder setFunctionUrlBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((Conditions.FunctionCondition)this.instance).setFunctionUrlBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<FunctionCondition, FunctionCondition.Builder> implements FunctionConditionOrBuilder {
    private Builder() {
      super(Conditions.FunctionCondition.DEFAULT_INSTANCE);
    }
    
    public Builder clearFunctionUrl() {
      copyOnWrite();
      ((Conditions.FunctionCondition)this.instance).clearFunctionUrl();
      return this;
    }
    
    public String getFunctionUrl() {
      return ((Conditions.FunctionCondition)this.instance).getFunctionUrl();
    }
    
    public ByteString getFunctionUrlBytes() {
      return ((Conditions.FunctionCondition)this.instance).getFunctionUrlBytes();
    }
    
    public Builder setFunctionUrl(String param1String) {
      copyOnWrite();
      ((Conditions.FunctionCondition)this.instance).setFunctionUrl(param1String);
      return this;
    }
    
    public Builder setFunctionUrlBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Conditions.FunctionCondition)this.instance).setFunctionUrlBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface FunctionConditionOrBuilder extends MessageLiteOrBuilder {
    String getFunctionUrl();
    
    ByteString getFunctionUrlBytes();
  }
  
  public static final class NotCondition extends GeneratedMessageLite<NotCondition, NotCondition.Builder> implements NotConditionOrBuilder {
    public static final int CONDITION_FIELD_NUMBER = 1;
    
    private static final NotCondition DEFAULT_INSTANCE = new NotCondition();
    
    private static volatile Parser<NotCondition> PARSER;
    
    private Conditions.Condition condition_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearCondition() {
      this.condition_ = null;
    }
    
    public static NotCondition getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeCondition(Conditions.Condition param1Condition) {
      Conditions.Condition condition = this.condition_;
      if (condition != null && condition != Conditions.Condition.getDefaultInstance()) {
        this.condition_ = (Conditions.Condition)((Conditions.Condition.Builder)Conditions.Condition.newBuilder(this.condition_).mergeFrom(param1Condition)).buildPartial();
      } else {
        this.condition_ = param1Condition;
      } 
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(NotCondition param1NotCondition) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1NotCondition);
    }
    
    public static NotCondition parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (NotCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static NotCondition parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (NotCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static NotCondition parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (NotCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static NotCondition parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (NotCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static NotCondition parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (NotCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static NotCondition parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (NotCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static NotCondition parseFrom(InputStream param1InputStream) throws IOException {
      return (NotCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static NotCondition parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (NotCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static NotCondition parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (NotCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static NotCondition parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (NotCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<NotCondition> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setCondition(Conditions.Condition.Builder param1Builder) {
      this.condition_ = (Conditions.Condition)param1Builder.build();
    }
    
    private void setCondition(Conditions.Condition param1Condition) {
      if (param1Condition != null) {
        this.condition_ = param1Condition;
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/developers/mobile/targeting/proto/Conditions$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 338, 2 -> 334, 3 -> 332, 4 -> 323, 5 -> 286, 6 -> 110, 7 -> 282, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/developers/mobile/targeting/proto/Conditions$NotCondition.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/developers/mobile/targeting/proto/Conditions$NotCondition
      //   72: monitorenter
      //   73: getstatic com/google/developers/mobile/targeting/proto/Conditions$NotCondition.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/developers/mobile/targeting/proto/Conditions$NotCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$NotCondition;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/developers/mobile/targeting/proto/Conditions$NotCondition.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/developers/mobile/targeting/proto/Conditions$NotCondition
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/developers/mobile/targeting/proto/Conditions$NotCondition
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/developers/mobile/targeting/proto/Conditions$NotCondition.PARSER : Lcom/google/protobuf/Parser;
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
      //   162: getfield condition_ : Lcom/google/developers/mobile/targeting/proto/Conditions$Condition;
      //   165: ifnull -> 182
      //   168: aload_0
      //   169: getfield condition_ : Lcom/google/developers/mobile/targeting/proto/Conditions$Condition;
      //   172: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   175: checkcast com/google/developers/mobile/targeting/proto/Conditions$Condition$Builder
      //   178: astore_1
      //   179: goto -> 184
      //   182: aconst_null
      //   183: astore_1
      //   184: aload_0
      //   185: aload_2
      //   186: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   189: aload_3
      //   190: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   193: checkcast com/google/developers/mobile/targeting/proto/Conditions$Condition
      //   196: putfield condition_ : Lcom/google/developers/mobile/targeting/proto/Conditions$Condition;
      //   199: aload_1
      //   200: ifnull -> 123
      //   203: aload_1
      //   204: aload_0
      //   205: getfield condition_ : Lcom/google/developers/mobile/targeting/proto/Conditions$Condition;
      //   208: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   211: pop
      //   212: aload_0
      //   213: aload_1
      //   214: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   217: checkcast com/google/developers/mobile/targeting/proto/Conditions$Condition
      //   220: putfield condition_ : Lcom/google/developers/mobile/targeting/proto/Conditions$Condition;
      //   223: goto -> 123
      //   226: iconst_1
      //   227: istore #4
      //   229: goto -> 123
      //   232: astore_1
      //   233: goto -> 280
      //   236: astore_1
      //   237: new java/lang/RuntimeException
      //   240: astore_3
      //   241: new com/google/protobuf/InvalidProtocolBufferException
      //   244: astore_2
      //   245: aload_2
      //   246: aload_1
      //   247: invokevirtual getMessage : ()Ljava/lang/String;
      //   250: invokespecial <init> : (Ljava/lang/String;)V
      //   253: aload_3
      //   254: aload_2
      //   255: aload_0
      //   256: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   259: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   262: aload_3
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
      //   282: getstatic com/google/developers/mobile/targeting/proto/Conditions$NotCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$NotCondition;
      //   285: areturn
      //   286: aload_2
      //   287: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   290: astore_1
      //   291: aload_3
      //   292: checkcast com/google/developers/mobile/targeting/proto/Conditions$NotCondition
      //   295: astore_2
      //   296: aload_0
      //   297: aload_1
      //   298: aload_0
      //   299: getfield condition_ : Lcom/google/developers/mobile/targeting/proto/Conditions$Condition;
      //   302: aload_2
      //   303: getfield condition_ : Lcom/google/developers/mobile/targeting/proto/Conditions$Condition;
      //   306: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   311: checkcast com/google/developers/mobile/targeting/proto/Conditions$Condition
      //   314: putfield condition_ : Lcom/google/developers/mobile/targeting/proto/Conditions$Condition;
      //   317: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   320: astore_1
      //   321: aload_0
      //   322: areturn
      //   323: new com/google/developers/mobile/targeting/proto/Conditions$NotCondition$Builder
      //   326: dup
      //   327: aconst_null
      //   328: invokespecial <init> : (Lcom/google/developers/mobile/targeting/proto/Conditions$1;)V
      //   331: areturn
      //   332: aconst_null
      //   333: areturn
      //   334: getstatic com/google/developers/mobile/targeting/proto/Conditions$NotCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$NotCondition;
      //   337: areturn
      //   338: new com/google/developers/mobile/targeting/proto/Conditions$NotCondition
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
    
    public Conditions.Condition getCondition() {
      Conditions.Condition condition1 = this.condition_;
      Conditions.Condition condition2 = condition1;
      if (condition1 == null)
        condition2 = Conditions.Condition.getDefaultInstance(); 
      return condition2;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (this.condition_ != null)
        i = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)getCondition()); 
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasCondition() {
      boolean bool;
      if (this.condition_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.condition_ != null)
        param1CodedOutputStream.writeMessage(1, (MessageLite)getCondition()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<NotCondition, Builder> implements Conditions.NotConditionOrBuilder {
      private Builder() {
        super(Conditions.NotCondition.DEFAULT_INSTANCE);
      }
      
      public Builder clearCondition() {
        copyOnWrite();
        ((Conditions.NotCondition)this.instance).clearCondition();
        return this;
      }
      
      public Conditions.Condition getCondition() {
        return ((Conditions.NotCondition)this.instance).getCondition();
      }
      
      public boolean hasCondition() {
        return ((Conditions.NotCondition)this.instance).hasCondition();
      }
      
      public Builder mergeCondition(Conditions.Condition param2Condition) {
        copyOnWrite();
        ((Conditions.NotCondition)this.instance).mergeCondition(param2Condition);
        return this;
      }
      
      public Builder setCondition(Conditions.Condition.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.NotCondition)this.instance).setCondition(param2Builder);
        return this;
      }
      
      public Builder setCondition(Conditions.Condition param2Condition) {
        copyOnWrite();
        ((Conditions.NotCondition)this.instance).setCondition(param2Condition);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<NotCondition, NotCondition.Builder> implements NotConditionOrBuilder {
    private Builder() {
      super(Conditions.NotCondition.DEFAULT_INSTANCE);
    }
    
    public Builder clearCondition() {
      copyOnWrite();
      ((Conditions.NotCondition)this.instance).clearCondition();
      return this;
    }
    
    public Conditions.Condition getCondition() {
      return ((Conditions.NotCondition)this.instance).getCondition();
    }
    
    public boolean hasCondition() {
      return ((Conditions.NotCondition)this.instance).hasCondition();
    }
    
    public Builder mergeCondition(Conditions.Condition param1Condition) {
      copyOnWrite();
      ((Conditions.NotCondition)this.instance).mergeCondition(param1Condition);
      return this;
    }
    
    public Builder setCondition(Conditions.Condition.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.NotCondition)this.instance).setCondition(param1Builder);
      return this;
    }
    
    public Builder setCondition(Conditions.Condition param1Condition) {
      copyOnWrite();
      ((Conditions.NotCondition)this.instance).setCondition(param1Condition);
      return this;
    }
  }
  
  public static interface NotConditionOrBuilder extends MessageLiteOrBuilder {
    Conditions.Condition getCondition();
    
    boolean hasCondition();
  }
  
  public static final class OrCondition extends GeneratedMessageLite<OrCondition, OrCondition.Builder> implements OrConditionOrBuilder {
    public static final int CONDITIONS_FIELD_NUMBER = 1;
    
    private static final OrCondition DEFAULT_INSTANCE = new OrCondition();
    
    private static volatile Parser<OrCondition> PARSER;
    
    private Internal.ProtobufList<Conditions.Condition> conditions_ = emptyProtobufList();
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllConditions(Iterable<? extends Conditions.Condition> param1Iterable) {
      ensureConditionsIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.conditions_);
    }
    
    private void addConditions(int param1Int, Conditions.Condition.Builder param1Builder) {
      ensureConditionsIsMutable();
      this.conditions_.add(param1Int, param1Builder.build());
    }
    
    private void addConditions(int param1Int, Conditions.Condition param1Condition) {
      if (param1Condition != null) {
        ensureConditionsIsMutable();
        this.conditions_.add(param1Int, param1Condition);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addConditions(Conditions.Condition.Builder param1Builder) {
      ensureConditionsIsMutable();
      this.conditions_.add(param1Builder.build());
    }
    
    private void addConditions(Conditions.Condition param1Condition) {
      if (param1Condition != null) {
        ensureConditionsIsMutable();
        this.conditions_.add(param1Condition);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearConditions() {
      this.conditions_ = emptyProtobufList();
    }
    
    private void ensureConditionsIsMutable() {
      if (!this.conditions_.isModifiable())
        this.conditions_ = GeneratedMessageLite.mutableCopy(this.conditions_); 
    }
    
    public static OrCondition getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(OrCondition param1OrCondition) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1OrCondition);
    }
    
    public static OrCondition parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (OrCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static OrCondition parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (OrCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static OrCondition parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (OrCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static OrCondition parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (OrCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static OrCondition parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (OrCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static OrCondition parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (OrCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static OrCondition parseFrom(InputStream param1InputStream) throws IOException {
      return (OrCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static OrCondition parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (OrCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static OrCondition parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (OrCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static OrCondition parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (OrCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<OrCondition> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeConditions(int param1Int) {
      ensureConditionsIsMutable();
      this.conditions_.remove(param1Int);
    }
    
    private void setConditions(int param1Int, Conditions.Condition.Builder param1Builder) {
      ensureConditionsIsMutable();
      this.conditions_.set(param1Int, param1Builder.build());
    }
    
    private void setConditions(int param1Int, Conditions.Condition param1Condition) {
      if (param1Condition != null) {
        ensureConditionsIsMutable();
        this.conditions_.set(param1Int, param1Condition);
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/developers/mobile/targeting/proto/Conditions$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 326, 2 -> 322, 3 -> 311, 4 -> 302, 5 -> 268, 6 -> 110, 7 -> 264, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/developers/mobile/targeting/proto/Conditions$OrCondition.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/developers/mobile/targeting/proto/Conditions$OrCondition
      //   72: monitorenter
      //   73: getstatic com/google/developers/mobile/targeting/proto/Conditions$OrCondition.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/developers/mobile/targeting/proto/Conditions$OrCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$OrCondition;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/developers/mobile/targeting/proto/Conditions$OrCondition.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/developers/mobile/targeting/proto/Conditions$OrCondition
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/developers/mobile/targeting/proto/Conditions$OrCondition
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/developers/mobile/targeting/proto/Conditions$OrCondition.PARSER : Lcom/google/protobuf/Parser;
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
      //   162: getfield conditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   165: invokeinterface isModifiable : ()Z
      //   170: ifne -> 184
      //   173: aload_0
      //   174: aload_0
      //   175: getfield conditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   178: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   181: putfield conditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   184: aload_0
      //   185: getfield conditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   188: aload_1
      //   189: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   192: aload_2
      //   193: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   196: checkcast com/google/developers/mobile/targeting/proto/Conditions$Condition
      //   199: invokeinterface add : (Ljava/lang/Object;)Z
      //   204: pop
      //   205: goto -> 123
      //   208: iconst_1
      //   209: istore #4
      //   211: goto -> 123
      //   214: astore_1
      //   215: goto -> 262
      //   218: astore_2
      //   219: new java/lang/RuntimeException
      //   222: astore_3
      //   223: new com/google/protobuf/InvalidProtocolBufferException
      //   226: astore_1
      //   227: aload_1
      //   228: aload_2
      //   229: invokevirtual getMessage : ()Ljava/lang/String;
      //   232: invokespecial <init> : (Ljava/lang/String;)V
      //   235: aload_3
      //   236: aload_1
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
      //   264: getstatic com/google/developers/mobile/targeting/proto/Conditions$OrCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$OrCondition;
      //   267: areturn
      //   268: aload_2
      //   269: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   272: astore_1
      //   273: aload_3
      //   274: checkcast com/google/developers/mobile/targeting/proto/Conditions$OrCondition
      //   277: astore_2
      //   278: aload_0
      //   279: aload_1
      //   280: aload_0
      //   281: getfield conditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   284: aload_2
      //   285: getfield conditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   288: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   293: putfield conditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   296: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   299: astore_1
      //   300: aload_0
      //   301: areturn
      //   302: new com/google/developers/mobile/targeting/proto/Conditions$OrCondition$Builder
      //   305: dup
      //   306: aconst_null
      //   307: invokespecial <init> : (Lcom/google/developers/mobile/targeting/proto/Conditions$1;)V
      //   310: areturn
      //   311: aload_0
      //   312: getfield conditions_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   315: invokeinterface makeImmutable : ()V
      //   320: aconst_null
      //   321: areturn
      //   322: getstatic com/google/developers/mobile/targeting/proto/Conditions$OrCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$OrCondition;
      //   325: areturn
      //   326: new com/google/developers/mobile/targeting/proto/Conditions$OrCondition
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
    
    public Conditions.Condition getConditions(int param1Int) {
      return (Conditions.Condition)this.conditions_.get(param1Int);
    }
    
    public int getConditionsCount() {
      return this.conditions_.size();
    }
    
    public List<Conditions.Condition> getConditionsList() {
      return (List<Conditions.Condition>)this.conditions_;
    }
    
    public Conditions.ConditionOrBuilder getConditionsOrBuilder(int param1Int) {
      return (Conditions.ConditionOrBuilder)this.conditions_.get(param1Int);
    }
    
    public List<? extends Conditions.ConditionOrBuilder> getConditionsOrBuilderList() {
      return (List)this.conditions_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      int j = 0;
      while (i < this.conditions_.size()) {
        j += CodedOutputStream.computeMessageSize(1, (MessageLite)this.conditions_.get(i));
        i++;
      } 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      for (byte b = 0; b < this.conditions_.size(); b++)
        param1CodedOutputStream.writeMessage(1, (MessageLite)this.conditions_.get(b)); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<OrCondition, Builder> implements Conditions.OrConditionOrBuilder {
      private Builder() {
        super(Conditions.OrCondition.DEFAULT_INSTANCE);
      }
      
      public Builder addAllConditions(Iterable<? extends Conditions.Condition> param2Iterable) {
        copyOnWrite();
        ((Conditions.OrCondition)this.instance).addAllConditions(param2Iterable);
        return this;
      }
      
      public Builder addConditions(int param2Int, Conditions.Condition.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.OrCondition)this.instance).addConditions(param2Int, param2Builder);
        return this;
      }
      
      public Builder addConditions(int param2Int, Conditions.Condition param2Condition) {
        copyOnWrite();
        ((Conditions.OrCondition)this.instance).addConditions(param2Int, param2Condition);
        return this;
      }
      
      public Builder addConditions(Conditions.Condition.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.OrCondition)this.instance).addConditions(param2Builder);
        return this;
      }
      
      public Builder addConditions(Conditions.Condition param2Condition) {
        copyOnWrite();
        ((Conditions.OrCondition)this.instance).addConditions(param2Condition);
        return this;
      }
      
      public Builder clearConditions() {
        copyOnWrite();
        ((Conditions.OrCondition)this.instance).clearConditions();
        return this;
      }
      
      public Conditions.Condition getConditions(int param2Int) {
        return ((Conditions.OrCondition)this.instance).getConditions(param2Int);
      }
      
      public int getConditionsCount() {
        return ((Conditions.OrCondition)this.instance).getConditionsCount();
      }
      
      public List<Conditions.Condition> getConditionsList() {
        return Collections.unmodifiableList(((Conditions.OrCondition)this.instance).getConditionsList());
      }
      
      public Builder removeConditions(int param2Int) {
        copyOnWrite();
        ((Conditions.OrCondition)this.instance).removeConditions(param2Int);
        return this;
      }
      
      public Builder setConditions(int param2Int, Conditions.Condition.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.OrCondition)this.instance).setConditions(param2Int, param2Builder);
        return this;
      }
      
      public Builder setConditions(int param2Int, Conditions.Condition param2Condition) {
        copyOnWrite();
        ((Conditions.OrCondition)this.instance).setConditions(param2Int, param2Condition);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<OrCondition, OrCondition.Builder> implements OrConditionOrBuilder {
    private Builder() {
      super(Conditions.OrCondition.DEFAULT_INSTANCE);
    }
    
    public Builder addAllConditions(Iterable<? extends Conditions.Condition> param1Iterable) {
      copyOnWrite();
      ((Conditions.OrCondition)this.instance).addAllConditions(param1Iterable);
      return this;
    }
    
    public Builder addConditions(int param1Int, Conditions.Condition.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.OrCondition)this.instance).addConditions(param1Int, param1Builder);
      return this;
    }
    
    public Builder addConditions(int param1Int, Conditions.Condition param1Condition) {
      copyOnWrite();
      ((Conditions.OrCondition)this.instance).addConditions(param1Int, param1Condition);
      return this;
    }
    
    public Builder addConditions(Conditions.Condition.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.OrCondition)this.instance).addConditions(param1Builder);
      return this;
    }
    
    public Builder addConditions(Conditions.Condition param1Condition) {
      copyOnWrite();
      ((Conditions.OrCondition)this.instance).addConditions(param1Condition);
      return this;
    }
    
    public Builder clearConditions() {
      copyOnWrite();
      ((Conditions.OrCondition)this.instance).clearConditions();
      return this;
    }
    
    public Conditions.Condition getConditions(int param1Int) {
      return ((Conditions.OrCondition)this.instance).getConditions(param1Int);
    }
    
    public int getConditionsCount() {
      return ((Conditions.OrCondition)this.instance).getConditionsCount();
    }
    
    public List<Conditions.Condition> getConditionsList() {
      return Collections.unmodifiableList(((Conditions.OrCondition)this.instance).getConditionsList());
    }
    
    public Builder removeConditions(int param1Int) {
      copyOnWrite();
      ((Conditions.OrCondition)this.instance).removeConditions(param1Int);
      return this;
    }
    
    public Builder setConditions(int param1Int, Conditions.Condition.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.OrCondition)this.instance).setConditions(param1Int, param1Builder);
      return this;
    }
    
    public Builder setConditions(int param1Int, Conditions.Condition param1Condition) {
      copyOnWrite();
      ((Conditions.OrCondition)this.instance).setConditions(param1Int, param1Condition);
      return this;
    }
  }
  
  public static interface OrConditionOrBuilder extends MessageLiteOrBuilder {
    Conditions.Condition getConditions(int param1Int);
    
    int getConditionsCount();
    
    List<Conditions.Condition> getConditionsList();
  }
  
  public static final class OsTypeCondition extends GeneratedMessageLite<OsTypeCondition, OsTypeCondition.Builder> implements OsTypeConditionOrBuilder {
    private static final OsTypeCondition DEFAULT_INSTANCE = new OsTypeCondition();
    
    public static final int OPERATOR_FIELD_NUMBER = 1;
    
    private static volatile Parser<OsTypeCondition> PARSER;
    
    public static final int TARGET_OS_TYPE_FIELD_NUMBER = 2;
    
    private int operator_;
    
    private int targetOsType_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearOperator() {
      this.operator_ = 0;
    }
    
    private void clearTargetOsType() {
      this.targetOsType_ = 0;
    }
    
    public static OsTypeCondition getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(OsTypeCondition param1OsTypeCondition) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1OsTypeCondition);
    }
    
    public static OsTypeCondition parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (OsTypeCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static OsTypeCondition parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (OsTypeCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static OsTypeCondition parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (OsTypeCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static OsTypeCondition parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (OsTypeCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static OsTypeCondition parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (OsTypeCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static OsTypeCondition parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (OsTypeCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static OsTypeCondition parseFrom(InputStream param1InputStream) throws IOException {
      return (OsTypeCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static OsTypeCondition parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (OsTypeCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static OsTypeCondition parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (OsTypeCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static OsTypeCondition parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (OsTypeCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<OsTypeCondition> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setOperator(OsTypeOperator param1OsTypeOperator) {
      if (param1OsTypeOperator != null) {
        this.operator_ = param1OsTypeOperator.getNumber();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setOperatorValue(int param1Int) {
      this.operator_ = param1Int;
    }
    
    private void setTargetOsType(OsType param1OsType) {
      if (param1OsType != null) {
        this.targetOsType_ = param1OsType.getNumber();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTargetOsTypeValue(int param1Int) {
      this.targetOsType_ = param1Int;
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/developers/mobile/targeting/proto/Conditions$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: istore #4
      //   10: iconst_0
      //   11: istore #5
      //   13: iconst_0
      //   14: istore #6
      //   16: iload #4
      //   18: tableswitch default -> 64, 1 -> 400, 2 -> 396, 3 -> 394, 4 -> 385, 5 -> 255, 6 -> 118, 7 -> 251, 8 -> 72
      //   64: new java/lang/UnsupportedOperationException
      //   67: dup
      //   68: invokespecial <init> : ()V
      //   71: athrow
      //   72: getstatic com/google/developers/mobile/targeting/proto/Conditions$OsTypeCondition.PARSER : Lcom/google/protobuf/Parser;
      //   75: ifnonnull -> 114
      //   78: ldc com/google/developers/mobile/targeting/proto/Conditions$OsTypeCondition
      //   80: monitorenter
      //   81: getstatic com/google/developers/mobile/targeting/proto/Conditions$OsTypeCondition.PARSER : Lcom/google/protobuf/Parser;
      //   84: ifnonnull -> 102
      //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   90: astore_1
      //   91: aload_1
      //   92: getstatic com/google/developers/mobile/targeting/proto/Conditions$OsTypeCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$OsTypeCondition;
      //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   98: aload_1
      //   99: putstatic com/google/developers/mobile/targeting/proto/Conditions$OsTypeCondition.PARSER : Lcom/google/protobuf/Parser;
      //   102: ldc com/google/developers/mobile/targeting/proto/Conditions$OsTypeCondition
      //   104: monitorexit
      //   105: goto -> 114
      //   108: astore_1
      //   109: ldc com/google/developers/mobile/targeting/proto/Conditions$OsTypeCondition
      //   111: monitorexit
      //   112: aload_1
      //   113: athrow
      //   114: getstatic com/google/developers/mobile/targeting/proto/Conditions$OsTypeCondition.PARSER : Lcom/google/protobuf/Parser;
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
      //   175: invokevirtual readEnum : ()I
      //   178: putfield targetOsType_ : I
      //   181: goto -> 128
      //   184: aload_0
      //   185: aload_1
      //   186: invokevirtual readEnum : ()I
      //   189: putfield operator_ : I
      //   192: goto -> 128
      //   195: iconst_1
      //   196: istore #6
      //   198: goto -> 128
      //   201: astore_1
      //   202: goto -> 249
      //   205: astore_3
      //   206: new java/lang/RuntimeException
      //   209: astore_2
      //   210: new com/google/protobuf/InvalidProtocolBufferException
      //   213: astore_1
      //   214: aload_1
      //   215: aload_3
      //   216: invokevirtual getMessage : ()Ljava/lang/String;
      //   219: invokespecial <init> : (Ljava/lang/String;)V
      //   222: aload_2
      //   223: aload_1
      //   224: aload_0
      //   225: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   228: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   231: aload_2
      //   232: athrow
      //   233: astore_1
      //   234: new java/lang/RuntimeException
      //   237: astore_2
      //   238: aload_2
      //   239: aload_1
      //   240: aload_0
      //   241: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   244: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   247: aload_2
      //   248: athrow
      //   249: aload_1
      //   250: athrow
      //   251: getstatic com/google/developers/mobile/targeting/proto/Conditions$OsTypeCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$OsTypeCondition;
      //   254: areturn
      //   255: aload_2
      //   256: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   259: astore_1
      //   260: aload_3
      //   261: checkcast com/google/developers/mobile/targeting/proto/Conditions$OsTypeCondition
      //   264: astore_2
      //   265: aload_0
      //   266: getfield operator_ : I
      //   269: ifeq -> 278
      //   272: iconst_1
      //   273: istore #7
      //   275: goto -> 281
      //   278: iconst_0
      //   279: istore #7
      //   281: aload_0
      //   282: getfield operator_ : I
      //   285: istore #6
      //   287: aload_2
      //   288: getfield operator_ : I
      //   291: ifeq -> 300
      //   294: iconst_1
      //   295: istore #8
      //   297: goto -> 303
      //   300: iconst_0
      //   301: istore #8
      //   303: aload_0
      //   304: aload_1
      //   305: iload #7
      //   307: iload #6
      //   309: iload #8
      //   311: aload_2
      //   312: getfield operator_ : I
      //   315: invokeinterface visitInt : (ZIZI)I
      //   320: putfield operator_ : I
      //   323: aload_0
      //   324: getfield targetOsType_ : I
      //   327: ifeq -> 336
      //   330: iconst_1
      //   331: istore #7
      //   333: goto -> 339
      //   336: iconst_0
      //   337: istore #7
      //   339: aload_0
      //   340: getfield targetOsType_ : I
      //   343: istore #6
      //   345: iload #5
      //   347: istore #8
      //   349: aload_2
      //   350: getfield targetOsType_ : I
      //   353: ifeq -> 359
      //   356: iconst_1
      //   357: istore #8
      //   359: aload_0
      //   360: aload_1
      //   361: iload #7
      //   363: iload #6
      //   365: iload #8
      //   367: aload_2
      //   368: getfield targetOsType_ : I
      //   371: invokeinterface visitInt : (ZIZI)I
      //   376: putfield targetOsType_ : I
      //   379: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   382: astore_1
      //   383: aload_0
      //   384: areturn
      //   385: new com/google/developers/mobile/targeting/proto/Conditions$OsTypeCondition$Builder
      //   388: dup
      //   389: aconst_null
      //   390: invokespecial <init> : (Lcom/google/developers/mobile/targeting/proto/Conditions$1;)V
      //   393: areturn
      //   394: aconst_null
      //   395: areturn
      //   396: getstatic com/google/developers/mobile/targeting/proto/Conditions$OsTypeCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$OsTypeCondition;
      //   399: areturn
      //   400: new com/google/developers/mobile/targeting/proto/Conditions$OsTypeCondition
      //   403: dup
      //   404: invokespecial <init> : ()V
      //   407: areturn
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
    
    public OsTypeOperator getOperator() {
      OsTypeOperator osTypeOperator1 = OsTypeOperator.forNumber(this.operator_);
      OsTypeOperator osTypeOperator2 = osTypeOperator1;
      if (osTypeOperator1 == null)
        osTypeOperator2 = OsTypeOperator.UNRECOGNIZED; 
      return osTypeOperator2;
    }
    
    public int getOperatorValue() {
      return this.operator_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (this.operator_ != OsTypeOperator.UNKNOWN_OPERATOR.getNumber())
        i = 0 + CodedOutputStream.computeEnumSize(1, this.operator_); 
      int j = i;
      if (this.targetOsType_ != OsType.UNKNOWN_OS_TYPE.getNumber())
        j = i + CodedOutputStream.computeEnumSize(2, this.targetOsType_); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public OsType getTargetOsType() {
      OsType osType1 = OsType.forNumber(this.targetOsType_);
      OsType osType2 = osType1;
      if (osType1 == null)
        osType2 = OsType.UNRECOGNIZED; 
      return osType2;
    }
    
    public int getTargetOsTypeValue() {
      return this.targetOsType_;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.operator_ != OsTypeOperator.UNKNOWN_OPERATOR.getNumber())
        param1CodedOutputStream.writeEnum(1, this.operator_); 
      if (this.targetOsType_ != OsType.UNKNOWN_OS_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(2, this.targetOsType_); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<OsTypeCondition, Builder> implements Conditions.OsTypeConditionOrBuilder {
      private Builder() {
        super(Conditions.OsTypeCondition.DEFAULT_INSTANCE);
      }
      
      public Builder clearOperator() {
        copyOnWrite();
        ((Conditions.OsTypeCondition)this.instance).clearOperator();
        return this;
      }
      
      public Builder clearTargetOsType() {
        copyOnWrite();
        ((Conditions.OsTypeCondition)this.instance).clearTargetOsType();
        return this;
      }
      
      public Conditions.OsTypeCondition.OsTypeOperator getOperator() {
        return ((Conditions.OsTypeCondition)this.instance).getOperator();
      }
      
      public int getOperatorValue() {
        return ((Conditions.OsTypeCondition)this.instance).getOperatorValue();
      }
      
      public Conditions.OsTypeCondition.OsType getTargetOsType() {
        return ((Conditions.OsTypeCondition)this.instance).getTargetOsType();
      }
      
      public int getTargetOsTypeValue() {
        return ((Conditions.OsTypeCondition)this.instance).getTargetOsTypeValue();
      }
      
      public Builder setOperator(Conditions.OsTypeCondition.OsTypeOperator param2OsTypeOperator) {
        copyOnWrite();
        ((Conditions.OsTypeCondition)this.instance).setOperator(param2OsTypeOperator);
        return this;
      }
      
      public Builder setOperatorValue(int param2Int) {
        copyOnWrite();
        ((Conditions.OsTypeCondition)this.instance).setOperatorValue(param2Int);
        return this;
      }
      
      public Builder setTargetOsType(Conditions.OsTypeCondition.OsType param2OsType) {
        copyOnWrite();
        ((Conditions.OsTypeCondition)this.instance).setTargetOsType(param2OsType);
        return this;
      }
      
      public Builder setTargetOsTypeValue(int param2Int) {
        copyOnWrite();
        ((Conditions.OsTypeCondition)this.instance).setTargetOsTypeValue(param2Int);
        return this;
      }
    }
    
    public enum OsType implements Internal.EnumLite {
      ANDROID(0),
      IOS(0),
      UNKNOWN_OS_TYPE(0),
      UNRECOGNIZED(0);
      
      public static final int ANDROID_VALUE = 1;
      
      public static final int IOS_VALUE = 2;
      
      public static final int UNKNOWN_OS_TYPE_VALUE = 0;
      
      private static final Internal.EnumLiteMap<OsType> internalValueMap = new Internal.EnumLiteMap<OsType>() {
          public Conditions.OsTypeCondition.OsType findValueByNumber(int param3Int) {
            return Conditions.OsTypeCondition.OsType.forNumber(param3Int);
          }
        };
      
      private final int value;
      
      static {
      
      }
      
      OsType(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static OsType forNumber(int param2Int) {
        switch (param2Int) {
          default:
            return null;
          case 2:
            return IOS;
          case 1:
            return ANDROID;
          case 0:
            break;
        } 
        return UNKNOWN_OS_TYPE;
      }
      
      public static Internal.EnumLiteMap<OsType> internalGetValueMap() {
        return internalValueMap;
      }
      
      public final int getNumber() {
        return this.value;
      }
    }
    
    class null implements Internal.EnumLiteMap<OsType> {
      public Conditions.OsTypeCondition.OsType findValueByNumber(int param2Int) {
        return Conditions.OsTypeCondition.OsType.forNumber(param2Int);
      }
    }
    
    public enum OsTypeOperator implements Internal.EnumLite {
      EQUALS(0),
      NOT_EQUALS(0),
      UNKNOWN_OPERATOR(0),
      UNRECOGNIZED(0);
      
      public static final int EQUALS_VALUE = 1;
      
      public static final int NOT_EQUALS_VALUE = 2;
      
      public static final int UNKNOWN_OPERATOR_VALUE = 0;
      
      private static final Internal.EnumLiteMap<OsTypeOperator> internalValueMap = new Internal.EnumLiteMap<OsTypeOperator>() {
          public Conditions.OsTypeCondition.OsTypeOperator findValueByNumber(int param3Int) {
            return Conditions.OsTypeCondition.OsTypeOperator.forNumber(param3Int);
          }
        };
      
      private final int value;
      
      static {
      
      }
      
      OsTypeOperator(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static OsTypeOperator forNumber(int param2Int) {
        switch (param2Int) {
          default:
            return null;
          case 2:
            return NOT_EQUALS;
          case 1:
            return EQUALS;
          case 0:
            break;
        } 
        return UNKNOWN_OPERATOR;
      }
      
      public static Internal.EnumLiteMap<OsTypeOperator> internalGetValueMap() {
        return internalValueMap;
      }
      
      public final int getNumber() {
        return this.value;
      }
    }
    
    class null implements Internal.EnumLiteMap<OsTypeOperator> {
      public Conditions.OsTypeCondition.OsTypeOperator findValueByNumber(int param2Int) {
        return Conditions.OsTypeCondition.OsTypeOperator.forNumber(param2Int);
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<OsTypeCondition, OsTypeCondition.Builder> implements OsTypeConditionOrBuilder {
    private Builder() {
      super(Conditions.OsTypeCondition.DEFAULT_INSTANCE);
    }
    
    public Builder clearOperator() {
      copyOnWrite();
      ((Conditions.OsTypeCondition)this.instance).clearOperator();
      return this;
    }
    
    public Builder clearTargetOsType() {
      copyOnWrite();
      ((Conditions.OsTypeCondition)this.instance).clearTargetOsType();
      return this;
    }
    
    public Conditions.OsTypeCondition.OsTypeOperator getOperator() {
      return ((Conditions.OsTypeCondition)this.instance).getOperator();
    }
    
    public int getOperatorValue() {
      return ((Conditions.OsTypeCondition)this.instance).getOperatorValue();
    }
    
    public Conditions.OsTypeCondition.OsType getTargetOsType() {
      return ((Conditions.OsTypeCondition)this.instance).getTargetOsType();
    }
    
    public int getTargetOsTypeValue() {
      return ((Conditions.OsTypeCondition)this.instance).getTargetOsTypeValue();
    }
    
    public Builder setOperator(Conditions.OsTypeCondition.OsTypeOperator param1OsTypeOperator) {
      copyOnWrite();
      ((Conditions.OsTypeCondition)this.instance).setOperator(param1OsTypeOperator);
      return this;
    }
    
    public Builder setOperatorValue(int param1Int) {
      copyOnWrite();
      ((Conditions.OsTypeCondition)this.instance).setOperatorValue(param1Int);
      return this;
    }
    
    public Builder setTargetOsType(Conditions.OsTypeCondition.OsType param1OsType) {
      copyOnWrite();
      ((Conditions.OsTypeCondition)this.instance).setTargetOsType(param1OsType);
      return this;
    }
    
    public Builder setTargetOsTypeValue(int param1Int) {
      copyOnWrite();
      ((Conditions.OsTypeCondition)this.instance).setTargetOsTypeValue(param1Int);
      return this;
    }
  }
  
  public enum OsType implements Internal.EnumLite {
    ANDROID(0),
    IOS(0),
    UNKNOWN_OS_TYPE(0),
    UNRECOGNIZED(0);
    
    public static final int ANDROID_VALUE = 1;
    
    public static final int IOS_VALUE = 2;
    
    public static final int UNKNOWN_OS_TYPE_VALUE = 0;
    
    private static final Internal.EnumLiteMap<OsType> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new OsType[] { UNKNOWN_OS_TYPE, ANDROID, IOS, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<OsType>() {
          public Conditions.OsTypeCondition.OsType findValueByNumber(int param3Int) {
            return Conditions.OsTypeCondition.OsType.forNumber(param3Int);
          }
        };
    }
    
    OsType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static OsType forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 2:
          return IOS;
        case 1:
          return ANDROID;
        case 0:
          break;
      } 
      return UNKNOWN_OS_TYPE;
    }
    
    public static Internal.EnumLiteMap<OsType> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<OsTypeCondition.OsType> {
    public Conditions.OsTypeCondition.OsType findValueByNumber(int param1Int) {
      return Conditions.OsTypeCondition.OsType.forNumber(param1Int);
    }
  }
  
  public enum OsTypeOperator implements Internal.EnumLite {
    EQUALS(0),
    NOT_EQUALS(0),
    UNKNOWN_OPERATOR(0),
    UNRECOGNIZED(0);
    
    public static final int EQUALS_VALUE = 1;
    
    public static final int NOT_EQUALS_VALUE = 2;
    
    public static final int UNKNOWN_OPERATOR_VALUE = 0;
    
    private static final Internal.EnumLiteMap<OsTypeOperator> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new OsTypeOperator[] { UNKNOWN_OPERATOR, EQUALS, NOT_EQUALS, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<OsTypeOperator>() {
          public Conditions.OsTypeCondition.OsTypeOperator findValueByNumber(int param3Int) {
            return Conditions.OsTypeCondition.OsTypeOperator.forNumber(param3Int);
          }
        };
    }
    
    OsTypeOperator(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static OsTypeOperator forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 2:
          return NOT_EQUALS;
        case 1:
          return EQUALS;
        case 0:
          break;
      } 
      return UNKNOWN_OPERATOR;
    }
    
    public static Internal.EnumLiteMap<OsTypeOperator> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<OsTypeCondition.OsTypeOperator> {
    public Conditions.OsTypeCondition.OsTypeOperator findValueByNumber(int param1Int) {
      return Conditions.OsTypeCondition.OsTypeOperator.forNumber(param1Int);
    }
  }
  
  public static interface OsTypeConditionOrBuilder extends MessageLiteOrBuilder {
    Conditions.OsTypeCondition.OsTypeOperator getOperator();
    
    int getOperatorValue();
    
    Conditions.OsTypeCondition.OsType getTargetOsType();
    
    int getTargetOsTypeValue();
  }
  
  public static final class PercentCondition extends GeneratedMessageLite<PercentCondition, PercentCondition.Builder> implements PercentConditionOrBuilder {
    private static final PercentCondition DEFAULT_INSTANCE = new PercentCondition();
    
    public static final int MICRO_PERCENT_FIELD_NUMBER = 2;
    
    public static final int OPERATOR_FIELD_NUMBER = 1;
    
    private static volatile Parser<PercentCondition> PARSER;
    
    public static final int SEED_FIELD_NUMBER = 3;
    
    private int microPercent_;
    
    private int operator_;
    
    private String seed_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearMicroPercent() {
      this.microPercent_ = 0;
    }
    
    private void clearOperator() {
      this.operator_ = 0;
    }
    
    private void clearSeed() {
      this.seed_ = getDefaultInstance().getSeed();
    }
    
    public static PercentCondition getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(PercentCondition param1PercentCondition) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1PercentCondition);
    }
    
    public static PercentCondition parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (PercentCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static PercentCondition parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PercentCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static PercentCondition parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (PercentCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static PercentCondition parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (PercentCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static PercentCondition parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (PercentCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static PercentCondition parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PercentCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static PercentCondition parseFrom(InputStream param1InputStream) throws IOException {
      return (PercentCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static PercentCondition parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PercentCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static PercentCondition parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (PercentCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static PercentCondition parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (PercentCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<PercentCondition> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setMicroPercent(int param1Int) {
      this.microPercent_ = param1Int;
    }
    
    private void setOperator(PercentOperator param1PercentOperator) {
      if (param1PercentOperator != null) {
        this.operator_ = param1PercentOperator.getNumber();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setOperatorValue(int param1Int) {
      this.operator_ = param1Int;
    }
    
    private void setSeed(String param1String) {
      if (param1String != null) {
        this.seed_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setSeedBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.seed_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/developers/mobile/targeting/proto/Conditions$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: istore #4
      //   10: iconst_0
      //   11: istore #5
      //   13: iconst_0
      //   14: istore #6
      //   16: iload #4
      //   18: tableswitch default -> 64, 1 -> 454, 2 -> 450, 3 -> 448, 4 -> 439, 5 -> 273, 6 -> 118, 7 -> 269, 8 -> 72
      //   64: new java/lang/UnsupportedOperationException
      //   67: dup
      //   68: invokespecial <init> : ()V
      //   71: athrow
      //   72: getstatic com/google/developers/mobile/targeting/proto/Conditions$PercentCondition.PARSER : Lcom/google/protobuf/Parser;
      //   75: ifnonnull -> 114
      //   78: ldc com/google/developers/mobile/targeting/proto/Conditions$PercentCondition
      //   80: monitorenter
      //   81: getstatic com/google/developers/mobile/targeting/proto/Conditions$PercentCondition.PARSER : Lcom/google/protobuf/Parser;
      //   84: ifnonnull -> 102
      //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   90: astore_1
      //   91: aload_1
      //   92: getstatic com/google/developers/mobile/targeting/proto/Conditions$PercentCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$PercentCondition;
      //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   98: aload_1
      //   99: putstatic com/google/developers/mobile/targeting/proto/Conditions$PercentCondition.PARSER : Lcom/google/protobuf/Parser;
      //   102: ldc com/google/developers/mobile/targeting/proto/Conditions$PercentCondition
      //   104: monitorexit
      //   105: goto -> 114
      //   108: astore_1
      //   109: ldc com/google/developers/mobile/targeting/proto/Conditions$PercentCondition
      //   111: monitorexit
      //   112: aload_1
      //   113: athrow
      //   114: getstatic com/google/developers/mobile/targeting/proto/Conditions$PercentCondition.PARSER : Lcom/google/protobuf/Parser;
      //   117: areturn
      //   118: aload_2
      //   119: checkcast com/google/protobuf/CodedInputStream
      //   122: astore_1
      //   123: aload_3
      //   124: checkcast com/google/protobuf/ExtensionRegistryLite
      //   127: astore_2
      //   128: iload #6
      //   130: ifne -> 269
      //   133: aload_1
      //   134: invokevirtual readTag : ()I
      //   137: istore #4
      //   139: iload #4
      //   141: ifeq -> 213
      //   144: iload #4
      //   146: bipush #8
      //   148: if_icmpeq -> 202
      //   151: iload #4
      //   153: bipush #16
      //   155: if_icmpeq -> 191
      //   158: iload #4
      //   160: bipush #26
      //   162: if_icmpeq -> 180
      //   165: aload_1
      //   166: iload #4
      //   168: invokevirtual skipField : (I)Z
      //   171: ifne -> 128
      //   174: iconst_1
      //   175: istore #6
      //   177: goto -> 128
      //   180: aload_0
      //   181: aload_1
      //   182: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   185: putfield seed_ : Ljava/lang/String;
      //   188: goto -> 128
      //   191: aload_0
      //   192: aload_1
      //   193: invokevirtual readUInt32 : ()I
      //   196: putfield microPercent_ : I
      //   199: goto -> 128
      //   202: aload_0
      //   203: aload_1
      //   204: invokevirtual readEnum : ()I
      //   207: putfield operator_ : I
      //   210: goto -> 128
      //   213: iconst_1
      //   214: istore #6
      //   216: goto -> 128
      //   219: astore_1
      //   220: goto -> 267
      //   223: astore_1
      //   224: new java/lang/RuntimeException
      //   227: astore_2
      //   228: new com/google/protobuf/InvalidProtocolBufferException
      //   231: astore_3
      //   232: aload_3
      //   233: aload_1
      //   234: invokevirtual getMessage : ()Ljava/lang/String;
      //   237: invokespecial <init> : (Ljava/lang/String;)V
      //   240: aload_2
      //   241: aload_3
      //   242: aload_0
      //   243: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   246: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   249: aload_2
      //   250: athrow
      //   251: astore_1
      //   252: new java/lang/RuntimeException
      //   255: astore_2
      //   256: aload_2
      //   257: aload_1
      //   258: aload_0
      //   259: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   262: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   265: aload_2
      //   266: athrow
      //   267: aload_1
      //   268: athrow
      //   269: getstatic com/google/developers/mobile/targeting/proto/Conditions$PercentCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$PercentCondition;
      //   272: areturn
      //   273: aload_2
      //   274: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   277: astore_1
      //   278: aload_3
      //   279: checkcast com/google/developers/mobile/targeting/proto/Conditions$PercentCondition
      //   282: astore_2
      //   283: aload_0
      //   284: getfield operator_ : I
      //   287: ifeq -> 296
      //   290: iconst_1
      //   291: istore #7
      //   293: goto -> 299
      //   296: iconst_0
      //   297: istore #7
      //   299: aload_0
      //   300: getfield operator_ : I
      //   303: istore #6
      //   305: aload_2
      //   306: getfield operator_ : I
      //   309: ifeq -> 318
      //   312: iconst_1
      //   313: istore #8
      //   315: goto -> 321
      //   318: iconst_0
      //   319: istore #8
      //   321: aload_0
      //   322: aload_1
      //   323: iload #7
      //   325: iload #6
      //   327: iload #8
      //   329: aload_2
      //   330: getfield operator_ : I
      //   333: invokeinterface visitInt : (ZIZI)I
      //   338: putfield operator_ : I
      //   341: aload_0
      //   342: getfield microPercent_ : I
      //   345: ifeq -> 354
      //   348: iconst_1
      //   349: istore #7
      //   351: goto -> 357
      //   354: iconst_0
      //   355: istore #7
      //   357: aload_0
      //   358: getfield microPercent_ : I
      //   361: istore #6
      //   363: iload #5
      //   365: istore #8
      //   367: aload_2
      //   368: getfield microPercent_ : I
      //   371: ifeq -> 377
      //   374: iconst_1
      //   375: istore #8
      //   377: aload_0
      //   378: aload_1
      //   379: iload #7
      //   381: iload #6
      //   383: iload #8
      //   385: aload_2
      //   386: getfield microPercent_ : I
      //   389: invokeinterface visitInt : (ZIZI)I
      //   394: putfield microPercent_ : I
      //   397: aload_0
      //   398: aload_1
      //   399: aload_0
      //   400: getfield seed_ : Ljava/lang/String;
      //   403: invokevirtual isEmpty : ()Z
      //   406: iconst_1
      //   407: ixor
      //   408: aload_0
      //   409: getfield seed_ : Ljava/lang/String;
      //   412: aload_2
      //   413: getfield seed_ : Ljava/lang/String;
      //   416: invokevirtual isEmpty : ()Z
      //   419: iconst_1
      //   420: ixor
      //   421: aload_2
      //   422: getfield seed_ : Ljava/lang/String;
      //   425: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   430: putfield seed_ : Ljava/lang/String;
      //   433: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   436: astore_1
      //   437: aload_0
      //   438: areturn
      //   439: new com/google/developers/mobile/targeting/proto/Conditions$PercentCondition$Builder
      //   442: dup
      //   443: aconst_null
      //   444: invokespecial <init> : (Lcom/google/developers/mobile/targeting/proto/Conditions$1;)V
      //   447: areturn
      //   448: aconst_null
      //   449: areturn
      //   450: getstatic com/google/developers/mobile/targeting/proto/Conditions$PercentCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$PercentCondition;
      //   453: areturn
      //   454: new com/google/developers/mobile/targeting/proto/Conditions$PercentCondition
      //   457: dup
      //   458: invokespecial <init> : ()V
      //   461: areturn
      // Exception table:
      //   from	to	target	type
      //   81	102	108	finally
      //   102	105	108	finally
      //   109	112	108	finally
      //   133	139	251	com/google/protobuf/InvalidProtocolBufferException
      //   133	139	223	java/io/IOException
      //   133	139	219	finally
      //   165	174	251	com/google/protobuf/InvalidProtocolBufferException
      //   165	174	223	java/io/IOException
      //   165	174	219	finally
      //   180	188	251	com/google/protobuf/InvalidProtocolBufferException
      //   180	188	223	java/io/IOException
      //   180	188	219	finally
      //   191	199	251	com/google/protobuf/InvalidProtocolBufferException
      //   191	199	223	java/io/IOException
      //   191	199	219	finally
      //   202	210	251	com/google/protobuf/InvalidProtocolBufferException
      //   202	210	223	java/io/IOException
      //   202	210	219	finally
      //   224	251	219	finally
      //   252	267	219	finally
    }
    
    public int getMicroPercent() {
      return this.microPercent_;
    }
    
    public PercentOperator getOperator() {
      PercentOperator percentOperator1 = PercentOperator.forNumber(this.operator_);
      PercentOperator percentOperator2 = percentOperator1;
      if (percentOperator1 == null)
        percentOperator2 = PercentOperator.UNRECOGNIZED; 
      return percentOperator2;
    }
    
    public int getOperatorValue() {
      return this.operator_;
    }
    
    public String getSeed() {
      return this.seed_;
    }
    
    public ByteString getSeedBytes() {
      return ByteString.copyFromUtf8(this.seed_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.operator_ != PercentOperator.UNKNOWN.getNumber())
        j = 0 + CodedOutputStream.computeEnumSize(1, this.operator_); 
      int k = this.microPercent_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeUInt32Size(2, k); 
      j = i;
      if (!this.seed_.isEmpty())
        j = i + CodedOutputStream.computeStringSize(3, getSeed()); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.operator_ != PercentOperator.UNKNOWN.getNumber())
        param1CodedOutputStream.writeEnum(1, this.operator_); 
      int i = this.microPercent_;
      if (i != 0)
        param1CodedOutputStream.writeUInt32(2, i); 
      if (!this.seed_.isEmpty())
        param1CodedOutputStream.writeString(3, getSeed()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<PercentCondition, Builder> implements Conditions.PercentConditionOrBuilder {
      private Builder() {
        super(Conditions.PercentCondition.DEFAULT_INSTANCE);
      }
      
      public Builder clearMicroPercent() {
        copyOnWrite();
        ((Conditions.PercentCondition)this.instance).clearMicroPercent();
        return this;
      }
      
      public Builder clearOperator() {
        copyOnWrite();
        ((Conditions.PercentCondition)this.instance).clearOperator();
        return this;
      }
      
      public Builder clearSeed() {
        copyOnWrite();
        ((Conditions.PercentCondition)this.instance).clearSeed();
        return this;
      }
      
      public int getMicroPercent() {
        return ((Conditions.PercentCondition)this.instance).getMicroPercent();
      }
      
      public Conditions.PercentCondition.PercentOperator getOperator() {
        return ((Conditions.PercentCondition)this.instance).getOperator();
      }
      
      public int getOperatorValue() {
        return ((Conditions.PercentCondition)this.instance).getOperatorValue();
      }
      
      public String getSeed() {
        return ((Conditions.PercentCondition)this.instance).getSeed();
      }
      
      public ByteString getSeedBytes() {
        return ((Conditions.PercentCondition)this.instance).getSeedBytes();
      }
      
      public Builder setMicroPercent(int param2Int) {
        copyOnWrite();
        ((Conditions.PercentCondition)this.instance).setMicroPercent(param2Int);
        return this;
      }
      
      public Builder setOperator(Conditions.PercentCondition.PercentOperator param2PercentOperator) {
        copyOnWrite();
        ((Conditions.PercentCondition)this.instance).setOperator(param2PercentOperator);
        return this;
      }
      
      public Builder setOperatorValue(int param2Int) {
        copyOnWrite();
        ((Conditions.PercentCondition)this.instance).setOperatorValue(param2Int);
        return this;
      }
      
      public Builder setSeed(String param2String) {
        copyOnWrite();
        ((Conditions.PercentCondition)this.instance).setSeed(param2String);
        return this;
      }
      
      public Builder setSeedBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((Conditions.PercentCondition)this.instance).setSeedBytes(param2ByteString);
        return this;
      }
    }
    
    public enum PercentOperator implements Internal.EnumLite {
      GREATER_THAN(0),
      LESS_OR_EQUAL(0),
      UNKNOWN(0),
      UNRECOGNIZED(0);
      
      public static final int GREATER_THAN_VALUE = 2;
      
      public static final int LESS_OR_EQUAL_VALUE = 1;
      
      public static final int UNKNOWN_VALUE = 0;
      
      private static final Internal.EnumLiteMap<PercentOperator> internalValueMap;
      
      private final int value;
      
      static {
        $VALUES = new PercentOperator[] { UNKNOWN, LESS_OR_EQUAL, GREATER_THAN, UNRECOGNIZED };
        internalValueMap = new Internal.EnumLiteMap<PercentOperator>() {
            public Conditions.PercentCondition.PercentOperator findValueByNumber(int param3Int) {
              return Conditions.PercentCondition.PercentOperator.forNumber(param3Int);
            }
          };
      }
      
      PercentOperator(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static PercentOperator forNumber(int param2Int) {
        switch (param2Int) {
          default:
            return null;
          case 2:
            return GREATER_THAN;
          case 1:
            return LESS_OR_EQUAL;
          case 0:
            break;
        } 
        return UNKNOWN;
      }
      
      public static Internal.EnumLiteMap<PercentOperator> internalGetValueMap() {
        return internalValueMap;
      }
      
      public final int getNumber() {
        return this.value;
      }
    }
    
    class null implements Internal.EnumLiteMap<PercentOperator> {
      public Conditions.PercentCondition.PercentOperator findValueByNumber(int param2Int) {
        return Conditions.PercentCondition.PercentOperator.forNumber(param2Int);
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<PercentCondition, PercentCondition.Builder> implements PercentConditionOrBuilder {
    private Builder() {
      super(Conditions.PercentCondition.DEFAULT_INSTANCE);
    }
    
    public Builder clearMicroPercent() {
      copyOnWrite();
      ((Conditions.PercentCondition)this.instance).clearMicroPercent();
      return this;
    }
    
    public Builder clearOperator() {
      copyOnWrite();
      ((Conditions.PercentCondition)this.instance).clearOperator();
      return this;
    }
    
    public Builder clearSeed() {
      copyOnWrite();
      ((Conditions.PercentCondition)this.instance).clearSeed();
      return this;
    }
    
    public int getMicroPercent() {
      return ((Conditions.PercentCondition)this.instance).getMicroPercent();
    }
    
    public Conditions.PercentCondition.PercentOperator getOperator() {
      return ((Conditions.PercentCondition)this.instance).getOperator();
    }
    
    public int getOperatorValue() {
      return ((Conditions.PercentCondition)this.instance).getOperatorValue();
    }
    
    public String getSeed() {
      return ((Conditions.PercentCondition)this.instance).getSeed();
    }
    
    public ByteString getSeedBytes() {
      return ((Conditions.PercentCondition)this.instance).getSeedBytes();
    }
    
    public Builder setMicroPercent(int param1Int) {
      copyOnWrite();
      ((Conditions.PercentCondition)this.instance).setMicroPercent(param1Int);
      return this;
    }
    
    public Builder setOperator(Conditions.PercentCondition.PercentOperator param1PercentOperator) {
      copyOnWrite();
      ((Conditions.PercentCondition)this.instance).setOperator(param1PercentOperator);
      return this;
    }
    
    public Builder setOperatorValue(int param1Int) {
      copyOnWrite();
      ((Conditions.PercentCondition)this.instance).setOperatorValue(param1Int);
      return this;
    }
    
    public Builder setSeed(String param1String) {
      copyOnWrite();
      ((Conditions.PercentCondition)this.instance).setSeed(param1String);
      return this;
    }
    
    public Builder setSeedBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Conditions.PercentCondition)this.instance).setSeedBytes(param1ByteString);
      return this;
    }
  }
  
  public enum PercentOperator implements Internal.EnumLite {
    GREATER_THAN(0),
    LESS_OR_EQUAL(0),
    UNKNOWN(0),
    UNRECOGNIZED(0);
    
    public static final int GREATER_THAN_VALUE = 2;
    
    public static final int LESS_OR_EQUAL_VALUE = 1;
    
    public static final int UNKNOWN_VALUE = 0;
    
    private static final Internal.EnumLiteMap<PercentOperator> internalValueMap;
    
    private final int value;
    
    static {
      GREATER_THAN = new PercentOperator("GREATER_THAN", 2, 2);
      UNRECOGNIZED = new PercentOperator("UNRECOGNIZED", 3, -1);
      $VALUES = new PercentOperator[] { UNKNOWN, LESS_OR_EQUAL, GREATER_THAN, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<PercentOperator>() {
          public Conditions.PercentCondition.PercentOperator findValueByNumber(int param3Int) {
            return Conditions.PercentCondition.PercentOperator.forNumber(param3Int);
          }
        };
    }
    
    PercentOperator(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static PercentOperator forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 2:
          return GREATER_THAN;
        case 1:
          return LESS_OR_EQUAL;
        case 0:
          break;
      } 
      return UNKNOWN;
    }
    
    public static Internal.EnumLiteMap<PercentOperator> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<PercentCondition.PercentOperator> {
    public Conditions.PercentCondition.PercentOperator findValueByNumber(int param1Int) {
      return Conditions.PercentCondition.PercentOperator.forNumber(param1Int);
    }
  }
  
  public static interface PercentConditionOrBuilder extends MessageLiteOrBuilder {
    int getMicroPercent();
    
    Conditions.PercentCondition.PercentOperator getOperator();
    
    int getOperatorValue();
    
    String getSeed();
    
    ByteString getSeedBytes();
  }
  
  public static final class PredictionsCondition extends GeneratedMessageLite<PredictionsCondition, PredictionsCondition.Builder> implements PredictionsConditionOrBuilder {
    private static final PredictionsCondition DEFAULT_INSTANCE = new PredictionsCondition();
    
    public static final int OPERATOR_FIELD_NUMBER = 1;
    
    private static volatile Parser<PredictionsCondition> PARSER;
    
    public static final int PREDICTION_TARGETS_FIELD_NUMBER = 2;
    
    private int bitField0_;
    
    private int operator_;
    
    private Internal.ProtobufList<PredictionsTarget> predictionTargets_ = emptyProtobufList();
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllPredictionTargets(Iterable<? extends PredictionsTarget> param1Iterable) {
      ensurePredictionTargetsIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.predictionTargets_);
    }
    
    private void addPredictionTargets(int param1Int, PredictionsTarget.Builder param1Builder) {
      ensurePredictionTargetsIsMutable();
      this.predictionTargets_.add(param1Int, param1Builder.build());
    }
    
    private void addPredictionTargets(int param1Int, PredictionsTarget param1PredictionsTarget) {
      if (param1PredictionsTarget != null) {
        ensurePredictionTargetsIsMutable();
        this.predictionTargets_.add(param1Int, param1PredictionsTarget);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addPredictionTargets(PredictionsTarget.Builder param1Builder) {
      ensurePredictionTargetsIsMutable();
      this.predictionTargets_.add(param1Builder.build());
    }
    
    private void addPredictionTargets(PredictionsTarget param1PredictionsTarget) {
      if (param1PredictionsTarget != null) {
        ensurePredictionTargetsIsMutable();
        this.predictionTargets_.add(param1PredictionsTarget);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearOperator() {
      this.operator_ = 0;
    }
    
    private void clearPredictionTargets() {
      this.predictionTargets_ = emptyProtobufList();
    }
    
    private void ensurePredictionTargetsIsMutable() {
      if (!this.predictionTargets_.isModifiable())
        this.predictionTargets_ = GeneratedMessageLite.mutableCopy(this.predictionTargets_); 
    }
    
    public static PredictionsCondition getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(PredictionsCondition param1PredictionsCondition) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1PredictionsCondition);
    }
    
    public static PredictionsCondition parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (PredictionsCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static PredictionsCondition parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PredictionsCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static PredictionsCondition parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (PredictionsCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static PredictionsCondition parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (PredictionsCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static PredictionsCondition parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (PredictionsCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static PredictionsCondition parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PredictionsCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static PredictionsCondition parseFrom(InputStream param1InputStream) throws IOException {
      return (PredictionsCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static PredictionsCondition parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PredictionsCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static PredictionsCondition parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (PredictionsCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static PredictionsCondition parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (PredictionsCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<PredictionsCondition> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removePredictionTargets(int param1Int) {
      ensurePredictionTargetsIsMutable();
      this.predictionTargets_.remove(param1Int);
    }
    
    private void setOperator(PredictionsOperator param1PredictionsOperator) {
      if (param1PredictionsOperator != null) {
        this.operator_ = param1PredictionsOperator.getNumber();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setOperatorValue(int param1Int) {
      this.operator_ = param1Int;
    }
    
    private void setPredictionTargets(int param1Int, PredictionsTarget.Builder param1Builder) {
      ensurePredictionTargetsIsMutable();
      this.predictionTargets_.set(param1Int, param1Builder.build());
    }
    
    private void setPredictionTargets(int param1Int, PredictionsTarget param1PredictionsTarget) {
      if (param1PredictionsTarget != null) {
        ensurePredictionTargetsIsMutable();
        this.predictionTargets_.set(param1Int, param1PredictionsTarget);
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/developers/mobile/targeting/proto/Conditions$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: istore #4
      //   10: iconst_0
      //   11: istore #5
      //   13: iconst_0
      //   14: istore #6
      //   16: iload #4
      //   18: tableswitch default -> 64, 1 -> 417, 2 -> 413, 3 -> 402, 4 -> 393, 5 -> 291, 6 -> 118, 7 -> 287, 8 -> 72
      //   64: new java/lang/UnsupportedOperationException
      //   67: dup
      //   68: invokespecial <init> : ()V
      //   71: athrow
      //   72: getstatic com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition.PARSER : Lcom/google/protobuf/Parser;
      //   75: ifnonnull -> 114
      //   78: ldc com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition
      //   80: monitorenter
      //   81: getstatic com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition.PARSER : Lcom/google/protobuf/Parser;
      //   84: ifnonnull -> 102
      //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   90: astore_1
      //   91: aload_1
      //   92: getstatic com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition;
      //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   98: aload_1
      //   99: putstatic com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition.PARSER : Lcom/google/protobuf/Parser;
      //   102: ldc com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition
      //   104: monitorexit
      //   105: goto -> 114
      //   108: astore_1
      //   109: ldc com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition
      //   111: monitorexit
      //   112: aload_1
      //   113: athrow
      //   114: getstatic com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition.PARSER : Lcom/google/protobuf/Parser;
      //   117: areturn
      //   118: aload_2
      //   119: checkcast com/google/protobuf/CodedInputStream
      //   122: astore_1
      //   123: aload_3
      //   124: checkcast com/google/protobuf/ExtensionRegistryLite
      //   127: astore_2
      //   128: iload #6
      //   130: ifne -> 287
      //   133: aload_1
      //   134: invokevirtual readTag : ()I
      //   137: istore #4
      //   139: iload #4
      //   141: ifeq -> 231
      //   144: iload #4
      //   146: bipush #8
      //   148: if_icmpeq -> 220
      //   151: iload #4
      //   153: bipush #18
      //   155: if_icmpeq -> 173
      //   158: aload_1
      //   159: iload #4
      //   161: invokevirtual skipField : (I)Z
      //   164: ifne -> 128
      //   167: iconst_1
      //   168: istore #6
      //   170: goto -> 128
      //   173: aload_0
      //   174: getfield predictionTargets_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   177: invokeinterface isModifiable : ()Z
      //   182: ifne -> 196
      //   185: aload_0
      //   186: aload_0
      //   187: getfield predictionTargets_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   190: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   193: putfield predictionTargets_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   196: aload_0
      //   197: getfield predictionTargets_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   200: aload_1
      //   201: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   204: aload_2
      //   205: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   208: checkcast com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget
      //   211: invokeinterface add : (Ljava/lang/Object;)Z
      //   216: pop
      //   217: goto -> 128
      //   220: aload_0
      //   221: aload_1
      //   222: invokevirtual readEnum : ()I
      //   225: putfield operator_ : I
      //   228: goto -> 128
      //   231: iconst_1
      //   232: istore #6
      //   234: goto -> 128
      //   237: astore_1
      //   238: goto -> 285
      //   241: astore_1
      //   242: new java/lang/RuntimeException
      //   245: astore_2
      //   246: new com/google/protobuf/InvalidProtocolBufferException
      //   249: astore_3
      //   250: aload_3
      //   251: aload_1
      //   252: invokevirtual getMessage : ()Ljava/lang/String;
      //   255: invokespecial <init> : (Ljava/lang/String;)V
      //   258: aload_2
      //   259: aload_3
      //   260: aload_0
      //   261: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   264: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   267: aload_2
      //   268: athrow
      //   269: astore_1
      //   270: new java/lang/RuntimeException
      //   273: astore_2
      //   274: aload_2
      //   275: aload_1
      //   276: aload_0
      //   277: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   280: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   283: aload_2
      //   284: athrow
      //   285: aload_1
      //   286: athrow
      //   287: getstatic com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition;
      //   290: areturn
      //   291: aload_2
      //   292: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   295: astore_1
      //   296: aload_3
      //   297: checkcast com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition
      //   300: astore_2
      //   301: aload_0
      //   302: getfield operator_ : I
      //   305: ifeq -> 314
      //   308: iconst_1
      //   309: istore #7
      //   311: goto -> 317
      //   314: iconst_0
      //   315: istore #7
      //   317: aload_0
      //   318: getfield operator_ : I
      //   321: istore #6
      //   323: aload_2
      //   324: getfield operator_ : I
      //   327: ifeq -> 333
      //   330: iconst_1
      //   331: istore #5
      //   333: aload_0
      //   334: aload_1
      //   335: iload #7
      //   337: iload #6
      //   339: iload #5
      //   341: aload_2
      //   342: getfield operator_ : I
      //   345: invokeinterface visitInt : (ZIZI)I
      //   350: putfield operator_ : I
      //   353: aload_0
      //   354: aload_1
      //   355: aload_0
      //   356: getfield predictionTargets_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   359: aload_2
      //   360: getfield predictionTargets_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   363: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   368: putfield predictionTargets_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   371: aload_1
      //   372: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   375: if_acmpne -> 391
      //   378: aload_0
      //   379: aload_0
      //   380: getfield bitField0_ : I
      //   383: aload_2
      //   384: getfield bitField0_ : I
      //   387: ior
      //   388: putfield bitField0_ : I
      //   391: aload_0
      //   392: areturn
      //   393: new com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$Builder
      //   396: dup
      //   397: aconst_null
      //   398: invokespecial <init> : (Lcom/google/developers/mobile/targeting/proto/Conditions$1;)V
      //   401: areturn
      //   402: aload_0
      //   403: getfield predictionTargets_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   406: invokeinterface makeImmutable : ()V
      //   411: aconst_null
      //   412: areturn
      //   413: getstatic com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition;
      //   416: areturn
      //   417: new com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition
      //   420: dup
      //   421: invokespecial <init> : ()V
      //   424: areturn
      // Exception table:
      //   from	to	target	type
      //   81	102	108	finally
      //   102	105	108	finally
      //   109	112	108	finally
      //   133	139	269	com/google/protobuf/InvalidProtocolBufferException
      //   133	139	241	java/io/IOException
      //   133	139	237	finally
      //   158	167	269	com/google/protobuf/InvalidProtocolBufferException
      //   158	167	241	java/io/IOException
      //   158	167	237	finally
      //   173	196	269	com/google/protobuf/InvalidProtocolBufferException
      //   173	196	241	java/io/IOException
      //   173	196	237	finally
      //   196	217	269	com/google/protobuf/InvalidProtocolBufferException
      //   196	217	241	java/io/IOException
      //   196	217	237	finally
      //   220	228	269	com/google/protobuf/InvalidProtocolBufferException
      //   220	228	241	java/io/IOException
      //   220	228	237	finally
      //   242	269	237	finally
      //   270	285	237	finally
    }
    
    public PredictionsOperator getOperator() {
      PredictionsOperator predictionsOperator1 = PredictionsOperator.forNumber(this.operator_);
      PredictionsOperator predictionsOperator2 = predictionsOperator1;
      if (predictionsOperator1 == null)
        predictionsOperator2 = PredictionsOperator.UNRECOGNIZED; 
      return predictionsOperator2;
    }
    
    public int getOperatorValue() {
      return this.operator_;
    }
    
    public PredictionsTarget getPredictionTargets(int param1Int) {
      return (PredictionsTarget)this.predictionTargets_.get(param1Int);
    }
    
    public int getPredictionTargetsCount() {
      return this.predictionTargets_.size();
    }
    
    public List<PredictionsTarget> getPredictionTargetsList() {
      return (List<PredictionsTarget>)this.predictionTargets_;
    }
    
    public PredictionsTargetOrBuilder getPredictionTargetsOrBuilder(int param1Int) {
      return (PredictionsTargetOrBuilder)this.predictionTargets_.get(param1Int);
    }
    
    public List<? extends PredictionsTargetOrBuilder> getPredictionTargetsOrBuilderList() {
      return (List)this.predictionTargets_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      int j = this.operator_;
      i = PredictionsOperator.UNKNOWN.getNumber();
      byte b = 0;
      if (j != i) {
        i = CodedOutputStream.computeEnumSize(1, this.operator_) + 0;
      } else {
        i = 0;
      } 
      while (b < this.predictionTargets_.size()) {
        i += CodedOutputStream.computeMessageSize(2, (MessageLite)this.predictionTargets_.get(b));
        b++;
      } 
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.operator_ != PredictionsOperator.UNKNOWN.getNumber())
        param1CodedOutputStream.writeEnum(1, this.operator_); 
      for (byte b = 0; b < this.predictionTargets_.size(); b++)
        param1CodedOutputStream.writeMessage(2, (MessageLite)this.predictionTargets_.get(b)); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<PredictionsCondition, Builder> implements Conditions.PredictionsConditionOrBuilder {
      private Builder() {
        super(Conditions.PredictionsCondition.DEFAULT_INSTANCE);
      }
      
      public Builder addAllPredictionTargets(Iterable<? extends Conditions.PredictionsCondition.PredictionsTarget> param2Iterable) {
        copyOnWrite();
        ((Conditions.PredictionsCondition)this.instance).addAllPredictionTargets(param2Iterable);
        return this;
      }
      
      public Builder addPredictionTargets(int param2Int, Conditions.PredictionsCondition.PredictionsTarget.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.PredictionsCondition)this.instance).addPredictionTargets(param2Int, param2Builder);
        return this;
      }
      
      public Builder addPredictionTargets(int param2Int, Conditions.PredictionsCondition.PredictionsTarget param2PredictionsTarget) {
        copyOnWrite();
        ((Conditions.PredictionsCondition)this.instance).addPredictionTargets(param2Int, param2PredictionsTarget);
        return this;
      }
      
      public Builder addPredictionTargets(Conditions.PredictionsCondition.PredictionsTarget.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.PredictionsCondition)this.instance).addPredictionTargets(param2Builder);
        return this;
      }
      
      public Builder addPredictionTargets(Conditions.PredictionsCondition.PredictionsTarget param2PredictionsTarget) {
        copyOnWrite();
        ((Conditions.PredictionsCondition)this.instance).addPredictionTargets(param2PredictionsTarget);
        return this;
      }
      
      public Builder clearOperator() {
        copyOnWrite();
        ((Conditions.PredictionsCondition)this.instance).clearOperator();
        return this;
      }
      
      public Builder clearPredictionTargets() {
        copyOnWrite();
        ((Conditions.PredictionsCondition)this.instance).clearPredictionTargets();
        return this;
      }
      
      public Conditions.PredictionsCondition.PredictionsOperator getOperator() {
        return ((Conditions.PredictionsCondition)this.instance).getOperator();
      }
      
      public int getOperatorValue() {
        return ((Conditions.PredictionsCondition)this.instance).getOperatorValue();
      }
      
      public Conditions.PredictionsCondition.PredictionsTarget getPredictionTargets(int param2Int) {
        return ((Conditions.PredictionsCondition)this.instance).getPredictionTargets(param2Int);
      }
      
      public int getPredictionTargetsCount() {
        return ((Conditions.PredictionsCondition)this.instance).getPredictionTargetsCount();
      }
      
      public List<Conditions.PredictionsCondition.PredictionsTarget> getPredictionTargetsList() {
        return Collections.unmodifiableList(((Conditions.PredictionsCondition)this.instance).getPredictionTargetsList());
      }
      
      public Builder removePredictionTargets(int param2Int) {
        copyOnWrite();
        ((Conditions.PredictionsCondition)this.instance).removePredictionTargets(param2Int);
        return this;
      }
      
      public Builder setOperator(Conditions.PredictionsCondition.PredictionsOperator param2PredictionsOperator) {
        copyOnWrite();
        ((Conditions.PredictionsCondition)this.instance).setOperator(param2PredictionsOperator);
        return this;
      }
      
      public Builder setOperatorValue(int param2Int) {
        copyOnWrite();
        ((Conditions.PredictionsCondition)this.instance).setOperatorValue(param2Int);
        return this;
      }
      
      public Builder setPredictionTargets(int param2Int, Conditions.PredictionsCondition.PredictionsTarget.Builder param2Builder) {
        copyOnWrite();
        ((Conditions.PredictionsCondition)this.instance).setPredictionTargets(param2Int, param2Builder);
        return this;
      }
      
      public Builder setPredictionTargets(int param2Int, Conditions.PredictionsCondition.PredictionsTarget param2PredictionsTarget) {
        copyOnWrite();
        ((Conditions.PredictionsCondition)this.instance).setPredictionTargets(param2Int, param2PredictionsTarget);
        return this;
      }
    }
    
    public enum PredictionsOperator implements Internal.EnumLite {
      IN_ALL(0),
      IN_AT_LEAST_ONE(0),
      UNKNOWN(0),
      UNRECOGNIZED(0);
      
      public static final int IN_ALL_VALUE = 2;
      
      public static final int IN_AT_LEAST_ONE_VALUE = 1;
      
      public static final int UNKNOWN_VALUE = 0;
      
      private static final Internal.EnumLiteMap<PredictionsOperator> internalValueMap;
      
      private final int value;
      
      static {
        $VALUES = new PredictionsOperator[] { UNKNOWN, IN_AT_LEAST_ONE, IN_ALL, UNRECOGNIZED };
        internalValueMap = new Internal.EnumLiteMap<PredictionsOperator>() {
            public Conditions.PredictionsCondition.PredictionsOperator findValueByNumber(int param3Int) {
              return Conditions.PredictionsCondition.PredictionsOperator.forNumber(param3Int);
            }
          };
      }
      
      PredictionsOperator(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static PredictionsOperator forNumber(int param2Int) {
        switch (param2Int) {
          default:
            return null;
          case 2:
            return IN_ALL;
          case 1:
            return IN_AT_LEAST_ONE;
          case 0:
            break;
        } 
        return UNKNOWN;
      }
      
      public static Internal.EnumLiteMap<PredictionsOperator> internalGetValueMap() {
        return internalValueMap;
      }
      
      public final int getNumber() {
        return this.value;
      }
    }
    
    class null implements Internal.EnumLiteMap<PredictionsOperator> {
      public Conditions.PredictionsCondition.PredictionsOperator findValueByNumber(int param2Int) {
        return Conditions.PredictionsCondition.PredictionsOperator.forNumber(param2Int);
      }
    }
    
    public static final class PredictionsTarget extends GeneratedMessageLite<PredictionsTarget, PredictionsTarget.Builder> implements PredictionsTargetOrBuilder {
      private static final PredictionsTarget DEFAULT_INSTANCE = new PredictionsTarget();
      
      private static volatile Parser<PredictionsTarget> PARSER;
      
      public static final int PREDICTION_RISK_PROFILE_ID_FIELD_NUMBER = 1;
      
      private String predictionRiskProfileId_ = "";
      
      static {
        DEFAULT_INSTANCE.makeImmutable();
      }
      
      private void clearPredictionRiskProfileId() {
        this.predictionRiskProfileId_ = getDefaultInstance().getPredictionRiskProfileId();
      }
      
      public static PredictionsTarget getDefaultInstance() {
        return DEFAULT_INSTANCE;
      }
      
      public static Builder newBuilder() {
        return (Builder)DEFAULT_INSTANCE.toBuilder();
      }
      
      public static Builder newBuilder(PredictionsTarget param2PredictionsTarget) {
        return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param2PredictionsTarget);
      }
      
      public static PredictionsTarget parseDelimitedFrom(InputStream param2InputStream) throws IOException {
        return (PredictionsTarget)parseDelimitedFrom(DEFAULT_INSTANCE, param2InputStream);
      }
      
      public static PredictionsTarget parseDelimitedFrom(InputStream param2InputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (PredictionsTarget)parseDelimitedFrom(DEFAULT_INSTANCE, param2InputStream, param2ExtensionRegistryLite);
      }
      
      public static PredictionsTarget parseFrom(ByteString param2ByteString) throws InvalidProtocolBufferException {
        return (PredictionsTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ByteString);
      }
      
      public static PredictionsTarget parseFrom(ByteString param2ByteString, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (PredictionsTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ByteString, param2ExtensionRegistryLite);
      }
      
      public static PredictionsTarget parseFrom(CodedInputStream param2CodedInputStream) throws IOException {
        return (PredictionsTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2CodedInputStream);
      }
      
      public static PredictionsTarget parseFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (PredictionsTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2CodedInputStream, param2ExtensionRegistryLite);
      }
      
      public static PredictionsTarget parseFrom(InputStream param2InputStream) throws IOException {
        return (PredictionsTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2InputStream);
      }
      
      public static PredictionsTarget parseFrom(InputStream param2InputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (PredictionsTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2InputStream, param2ExtensionRegistryLite);
      }
      
      public static PredictionsTarget parseFrom(byte[] param2ArrayOfbyte) throws InvalidProtocolBufferException {
        return (PredictionsTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ArrayOfbyte);
      }
      
      public static PredictionsTarget parseFrom(byte[] param2ArrayOfbyte, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (PredictionsTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ArrayOfbyte, param2ExtensionRegistryLite);
      }
      
      public static Parser<PredictionsTarget> parser() {
        return DEFAULT_INSTANCE.getParserForType();
      }
      
      private void setPredictionRiskProfileId(String param2String) {
        if (param2String != null) {
          this.predictionRiskProfileId_ = param2String;
          return;
        } 
        throw new NullPointerException();
      }
      
      private void setPredictionRiskProfileIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          checkByteStringIsUtf8(param2ByteString);
          this.predictionRiskProfileId_ = param2ByteString.toStringUtf8();
          return;
        } 
        throw new NullPointerException();
      }
      
      protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param2MethodToInvoke, Object param2Object1, Object param2Object2) {
        // Byte code:
        //   0: getstatic com/google/developers/mobile/targeting/proto/Conditions$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
        //   3: aload_1
        //   4: invokevirtual ordinal : ()I
        //   7: iaload
        //   8: tableswitch default -> 56, 1 -> 299, 2 -> 295, 3 -> 293, 4 -> 284, 5 -> 232, 6 -> 110, 7 -> 228, 8 -> 64
        //   56: new java/lang/UnsupportedOperationException
        //   59: dup
        //   60: invokespecial <init> : ()V
        //   63: athrow
        //   64: getstatic com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget.PARSER : Lcom/google/protobuf/Parser;
        //   67: ifnonnull -> 106
        //   70: ldc com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget
        //   72: monitorenter
        //   73: getstatic com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget.PARSER : Lcom/google/protobuf/Parser;
        //   76: ifnonnull -> 94
        //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
        //   82: astore_1
        //   83: aload_1
        //   84: getstatic com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget;
        //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
        //   90: aload_1
        //   91: putstatic com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget.PARSER : Lcom/google/protobuf/Parser;
        //   94: ldc com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget
        //   96: monitorexit
        //   97: goto -> 106
        //   100: astore_1
        //   101: ldc com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget
        //   103: monitorexit
        //   104: aload_1
        //   105: athrow
        //   106: getstatic com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget.PARSER : Lcom/google/protobuf/Parser;
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
        //   125: ifne -> 228
        //   128: aload_1
        //   129: invokevirtual readTag : ()I
        //   132: istore #5
        //   134: iload #5
        //   136: ifeq -> 172
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
        //   162: aload_1
        //   163: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
        //   166: putfield predictionRiskProfileId_ : Ljava/lang/String;
        //   169: goto -> 123
        //   172: iconst_1
        //   173: istore #4
        //   175: goto -> 123
        //   178: astore_1
        //   179: goto -> 226
        //   182: astore_3
        //   183: new java/lang/RuntimeException
        //   186: astore_2
        //   187: new com/google/protobuf/InvalidProtocolBufferException
        //   190: astore_1
        //   191: aload_1
        //   192: aload_3
        //   193: invokevirtual getMessage : ()Ljava/lang/String;
        //   196: invokespecial <init> : (Ljava/lang/String;)V
        //   199: aload_2
        //   200: aload_1
        //   201: aload_0
        //   202: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
        //   205: invokespecial <init> : (Ljava/lang/Throwable;)V
        //   208: aload_2
        //   209: athrow
        //   210: astore_2
        //   211: new java/lang/RuntimeException
        //   214: astore_1
        //   215: aload_1
        //   216: aload_2
        //   217: aload_0
        //   218: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
        //   221: invokespecial <init> : (Ljava/lang/Throwable;)V
        //   224: aload_1
        //   225: athrow
        //   226: aload_1
        //   227: athrow
        //   228: getstatic com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget;
        //   231: areturn
        //   232: aload_2
        //   233: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
        //   236: astore_1
        //   237: aload_3
        //   238: checkcast com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget
        //   241: astore_2
        //   242: aload_0
        //   243: aload_1
        //   244: aload_0
        //   245: getfield predictionRiskProfileId_ : Ljava/lang/String;
        //   248: invokevirtual isEmpty : ()Z
        //   251: iconst_1
        //   252: ixor
        //   253: aload_0
        //   254: getfield predictionRiskProfileId_ : Ljava/lang/String;
        //   257: iconst_1
        //   258: aload_2
        //   259: getfield predictionRiskProfileId_ : Ljava/lang/String;
        //   262: invokevirtual isEmpty : ()Z
        //   265: ixor
        //   266: aload_2
        //   267: getfield predictionRiskProfileId_ : Ljava/lang/String;
        //   270: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
        //   275: putfield predictionRiskProfileId_ : Ljava/lang/String;
        //   278: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
        //   281: astore_1
        //   282: aload_0
        //   283: areturn
        //   284: new com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget$Builder
        //   287: dup
        //   288: aconst_null
        //   289: invokespecial <init> : (Lcom/google/developers/mobile/targeting/proto/Conditions$1;)V
        //   292: areturn
        //   293: aconst_null
        //   294: areturn
        //   295: getstatic com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget;
        //   298: areturn
        //   299: new com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget
        //   302: dup
        //   303: invokespecial <init> : ()V
        //   306: areturn
        // Exception table:
        //   from	to	target	type
        //   73	94	100	finally
        //   94	97	100	finally
        //   101	104	100	finally
        //   128	134	210	com/google/protobuf/InvalidProtocolBufferException
        //   128	134	182	java/io/IOException
        //   128	134	178	finally
        //   146	155	210	com/google/protobuf/InvalidProtocolBufferException
        //   146	155	182	java/io/IOException
        //   146	155	178	finally
        //   161	169	210	com/google/protobuf/InvalidProtocolBufferException
        //   161	169	182	java/io/IOException
        //   161	169	178	finally
        //   183	210	178	finally
        //   211	226	178	finally
      }
      
      public String getPredictionRiskProfileId() {
        return this.predictionRiskProfileId_;
      }
      
      public ByteString getPredictionRiskProfileIdBytes() {
        return ByteString.copyFromUtf8(this.predictionRiskProfileId_);
      }
      
      public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1)
          return i; 
        i = 0;
        if (!this.predictionRiskProfileId_.isEmpty())
          i = 0 + CodedOutputStream.computeStringSize(1, getPredictionRiskProfileId()); 
        this.memoizedSerializedSize = i;
        return i;
      }
      
      public void writeTo(CodedOutputStream param2CodedOutputStream) throws IOException {
        if (!this.predictionRiskProfileId_.isEmpty())
          param2CodedOutputStream.writeString(1, getPredictionRiskProfileId()); 
      }
      
      public static final class Builder extends GeneratedMessageLite.Builder<PredictionsTarget, Builder> implements Conditions.PredictionsCondition.PredictionsTargetOrBuilder {
        private Builder() {
          super(Conditions.PredictionsCondition.PredictionsTarget.DEFAULT_INSTANCE);
        }
        
        public Builder clearPredictionRiskProfileId() {
          copyOnWrite();
          ((Conditions.PredictionsCondition.PredictionsTarget)this.instance).clearPredictionRiskProfileId();
          return this;
        }
        
        public String getPredictionRiskProfileId() {
          return ((Conditions.PredictionsCondition.PredictionsTarget)this.instance).getPredictionRiskProfileId();
        }
        
        public ByteString getPredictionRiskProfileIdBytes() {
          return ((Conditions.PredictionsCondition.PredictionsTarget)this.instance).getPredictionRiskProfileIdBytes();
        }
        
        public Builder setPredictionRiskProfileId(String param3String) {
          copyOnWrite();
          ((Conditions.PredictionsCondition.PredictionsTarget)this.instance).setPredictionRiskProfileId(param3String);
          return this;
        }
        
        public Builder setPredictionRiskProfileIdBytes(ByteString param3ByteString) {
          copyOnWrite();
          ((Conditions.PredictionsCondition.PredictionsTarget)this.instance).setPredictionRiskProfileIdBytes(param3ByteString);
          return this;
        }
      }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<PredictionsTarget, PredictionsTarget.Builder> implements PredictionsTargetOrBuilder {
      private Builder() {
        super(Conditions.PredictionsCondition.PredictionsTarget.DEFAULT_INSTANCE);
      }
      
      public Builder clearPredictionRiskProfileId() {
        copyOnWrite();
        ((Conditions.PredictionsCondition.PredictionsTarget)this.instance).clearPredictionRiskProfileId();
        return this;
      }
      
      public String getPredictionRiskProfileId() {
        return ((Conditions.PredictionsCondition.PredictionsTarget)this.instance).getPredictionRiskProfileId();
      }
      
      public ByteString getPredictionRiskProfileIdBytes() {
        return ((Conditions.PredictionsCondition.PredictionsTarget)this.instance).getPredictionRiskProfileIdBytes();
      }
      
      public Builder setPredictionRiskProfileId(String param2String) {
        copyOnWrite();
        ((Conditions.PredictionsCondition.PredictionsTarget)this.instance).setPredictionRiskProfileId(param2String);
        return this;
      }
      
      public Builder setPredictionRiskProfileIdBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((Conditions.PredictionsCondition.PredictionsTarget)this.instance).setPredictionRiskProfileIdBytes(param2ByteString);
        return this;
      }
    }
    
    public static interface PredictionsTargetOrBuilder extends MessageLiteOrBuilder {
      String getPredictionRiskProfileId();
      
      ByteString getPredictionRiskProfileIdBytes();
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<PredictionsCondition, PredictionsCondition.Builder> implements PredictionsConditionOrBuilder {
    private Builder() {
      super(Conditions.PredictionsCondition.DEFAULT_INSTANCE);
    }
    
    public Builder addAllPredictionTargets(Iterable<? extends Conditions.PredictionsCondition.PredictionsTarget> param1Iterable) {
      copyOnWrite();
      ((Conditions.PredictionsCondition)this.instance).addAllPredictionTargets(param1Iterable);
      return this;
    }
    
    public Builder addPredictionTargets(int param1Int, Conditions.PredictionsCondition.PredictionsTarget.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.PredictionsCondition)this.instance).addPredictionTargets(param1Int, param1Builder);
      return this;
    }
    
    public Builder addPredictionTargets(int param1Int, Conditions.PredictionsCondition.PredictionsTarget param1PredictionsTarget) {
      copyOnWrite();
      ((Conditions.PredictionsCondition)this.instance).addPredictionTargets(param1Int, param1PredictionsTarget);
      return this;
    }
    
    public Builder addPredictionTargets(Conditions.PredictionsCondition.PredictionsTarget.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.PredictionsCondition)this.instance).addPredictionTargets(param1Builder);
      return this;
    }
    
    public Builder addPredictionTargets(Conditions.PredictionsCondition.PredictionsTarget param1PredictionsTarget) {
      copyOnWrite();
      ((Conditions.PredictionsCondition)this.instance).addPredictionTargets(param1PredictionsTarget);
      return this;
    }
    
    public Builder clearOperator() {
      copyOnWrite();
      ((Conditions.PredictionsCondition)this.instance).clearOperator();
      return this;
    }
    
    public Builder clearPredictionTargets() {
      copyOnWrite();
      ((Conditions.PredictionsCondition)this.instance).clearPredictionTargets();
      return this;
    }
    
    public Conditions.PredictionsCondition.PredictionsOperator getOperator() {
      return ((Conditions.PredictionsCondition)this.instance).getOperator();
    }
    
    public int getOperatorValue() {
      return ((Conditions.PredictionsCondition)this.instance).getOperatorValue();
    }
    
    public Conditions.PredictionsCondition.PredictionsTarget getPredictionTargets(int param1Int) {
      return ((Conditions.PredictionsCondition)this.instance).getPredictionTargets(param1Int);
    }
    
    public int getPredictionTargetsCount() {
      return ((Conditions.PredictionsCondition)this.instance).getPredictionTargetsCount();
    }
    
    public List<Conditions.PredictionsCondition.PredictionsTarget> getPredictionTargetsList() {
      return Collections.unmodifiableList(((Conditions.PredictionsCondition)this.instance).getPredictionTargetsList());
    }
    
    public Builder removePredictionTargets(int param1Int) {
      copyOnWrite();
      ((Conditions.PredictionsCondition)this.instance).removePredictionTargets(param1Int);
      return this;
    }
    
    public Builder setOperator(Conditions.PredictionsCondition.PredictionsOperator param1PredictionsOperator) {
      copyOnWrite();
      ((Conditions.PredictionsCondition)this.instance).setOperator(param1PredictionsOperator);
      return this;
    }
    
    public Builder setOperatorValue(int param1Int) {
      copyOnWrite();
      ((Conditions.PredictionsCondition)this.instance).setOperatorValue(param1Int);
      return this;
    }
    
    public Builder setPredictionTargets(int param1Int, Conditions.PredictionsCondition.PredictionsTarget.Builder param1Builder) {
      copyOnWrite();
      ((Conditions.PredictionsCondition)this.instance).setPredictionTargets(param1Int, param1Builder);
      return this;
    }
    
    public Builder setPredictionTargets(int param1Int, Conditions.PredictionsCondition.PredictionsTarget param1PredictionsTarget) {
      copyOnWrite();
      ((Conditions.PredictionsCondition)this.instance).setPredictionTargets(param1Int, param1PredictionsTarget);
      return this;
    }
  }
  
  public enum PredictionsOperator implements Internal.EnumLite {
    IN_ALL(0),
    IN_AT_LEAST_ONE(0),
    UNKNOWN(0),
    UNRECOGNIZED(0);
    
    public static final int IN_ALL_VALUE = 2;
    
    public static final int IN_AT_LEAST_ONE_VALUE = 1;
    
    public static final int UNKNOWN_VALUE = 0;
    
    private static final Internal.EnumLiteMap<PredictionsOperator> internalValueMap;
    
    private final int value;
    
    static {
      IN_ALL = new PredictionsOperator("IN_ALL", 2, 2);
      UNRECOGNIZED = new PredictionsOperator("UNRECOGNIZED", 3, -1);
      $VALUES = new PredictionsOperator[] { UNKNOWN, IN_AT_LEAST_ONE, IN_ALL, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<PredictionsOperator>() {
          public Conditions.PredictionsCondition.PredictionsOperator findValueByNumber(int param3Int) {
            return Conditions.PredictionsCondition.PredictionsOperator.forNumber(param3Int);
          }
        };
    }
    
    PredictionsOperator(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static PredictionsOperator forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 2:
          return IN_ALL;
        case 1:
          return IN_AT_LEAST_ONE;
        case 0:
          break;
      } 
      return UNKNOWN;
    }
    
    public static Internal.EnumLiteMap<PredictionsOperator> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<PredictionsCondition.PredictionsOperator> {
    public Conditions.PredictionsCondition.PredictionsOperator findValueByNumber(int param1Int) {
      return Conditions.PredictionsCondition.PredictionsOperator.forNumber(param1Int);
    }
  }
  
  public static final class PredictionsTarget extends GeneratedMessageLite<PredictionsCondition.PredictionsTarget, PredictionsCondition.PredictionsTarget.Builder> implements PredictionsCondition.PredictionsTargetOrBuilder {
    private static final PredictionsTarget DEFAULT_INSTANCE = new PredictionsTarget();
    
    private static volatile Parser<PredictionsTarget> PARSER;
    
    public static final int PREDICTION_RISK_PROFILE_ID_FIELD_NUMBER = 1;
    
    private String predictionRiskProfileId_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearPredictionRiskProfileId() {
      this.predictionRiskProfileId_ = getDefaultInstance().getPredictionRiskProfileId();
    }
    
    public static PredictionsTarget getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(PredictionsTarget param1PredictionsTarget) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1PredictionsTarget);
    }
    
    public static PredictionsTarget parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (PredictionsTarget)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static PredictionsTarget parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PredictionsTarget)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static PredictionsTarget parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (PredictionsTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static PredictionsTarget parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (PredictionsTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static PredictionsTarget parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (PredictionsTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static PredictionsTarget parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PredictionsTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static PredictionsTarget parseFrom(InputStream param1InputStream) throws IOException {
      return (PredictionsTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static PredictionsTarget parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PredictionsTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static PredictionsTarget parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (PredictionsTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static PredictionsTarget parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (PredictionsTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<PredictionsTarget> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setPredictionRiskProfileId(String param1String) {
      if (param1String != null) {
        this.predictionRiskProfileId_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setPredictionRiskProfileIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.predictionRiskProfileId_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/developers/mobile/targeting/proto/Conditions$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 299, 2 -> 295, 3 -> 293, 4 -> 284, 5 -> 232, 6 -> 110, 7 -> 228, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget
      //   72: monitorenter
      //   73: getstatic com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 228
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 172
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
      //   162: aload_1
      //   163: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   166: putfield predictionRiskProfileId_ : Ljava/lang/String;
      //   169: goto -> 123
      //   172: iconst_1
      //   173: istore #4
      //   175: goto -> 123
      //   178: astore_1
      //   179: goto -> 226
      //   182: astore_3
      //   183: new java/lang/RuntimeException
      //   186: astore_2
      //   187: new com/google/protobuf/InvalidProtocolBufferException
      //   190: astore_1
      //   191: aload_1
      //   192: aload_3
      //   193: invokevirtual getMessage : ()Ljava/lang/String;
      //   196: invokespecial <init> : (Ljava/lang/String;)V
      //   199: aload_2
      //   200: aload_1
      //   201: aload_0
      //   202: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   205: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   208: aload_2
      //   209: athrow
      //   210: astore_2
      //   211: new java/lang/RuntimeException
      //   214: astore_1
      //   215: aload_1
      //   216: aload_2
      //   217: aload_0
      //   218: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   221: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   224: aload_1
      //   225: athrow
      //   226: aload_1
      //   227: athrow
      //   228: getstatic com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget;
      //   231: areturn
      //   232: aload_2
      //   233: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   236: astore_1
      //   237: aload_3
      //   238: checkcast com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget
      //   241: astore_2
      //   242: aload_0
      //   243: aload_1
      //   244: aload_0
      //   245: getfield predictionRiskProfileId_ : Ljava/lang/String;
      //   248: invokevirtual isEmpty : ()Z
      //   251: iconst_1
      //   252: ixor
      //   253: aload_0
      //   254: getfield predictionRiskProfileId_ : Ljava/lang/String;
      //   257: iconst_1
      //   258: aload_2
      //   259: getfield predictionRiskProfileId_ : Ljava/lang/String;
      //   262: invokevirtual isEmpty : ()Z
      //   265: ixor
      //   266: aload_2
      //   267: getfield predictionRiskProfileId_ : Ljava/lang/String;
      //   270: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   275: putfield predictionRiskProfileId_ : Ljava/lang/String;
      //   278: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   281: astore_1
      //   282: aload_0
      //   283: areturn
      //   284: new com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget$Builder
      //   287: dup
      //   288: aconst_null
      //   289: invokespecial <init> : (Lcom/google/developers/mobile/targeting/proto/Conditions$1;)V
      //   292: areturn
      //   293: aconst_null
      //   294: areturn
      //   295: getstatic com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget;
      //   298: areturn
      //   299: new com/google/developers/mobile/targeting/proto/Conditions$PredictionsCondition$PredictionsTarget
      //   302: dup
      //   303: invokespecial <init> : ()V
      //   306: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	210	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	182	java/io/IOException
      //   128	134	178	finally
      //   146	155	210	com/google/protobuf/InvalidProtocolBufferException
      //   146	155	182	java/io/IOException
      //   146	155	178	finally
      //   161	169	210	com/google/protobuf/InvalidProtocolBufferException
      //   161	169	182	java/io/IOException
      //   161	169	178	finally
      //   183	210	178	finally
      //   211	226	178	finally
    }
    
    public String getPredictionRiskProfileId() {
      return this.predictionRiskProfileId_;
    }
    
    public ByteString getPredictionRiskProfileIdBytes() {
      return ByteString.copyFromUtf8(this.predictionRiskProfileId_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (!this.predictionRiskProfileId_.isEmpty())
        i = 0 + CodedOutputStream.computeStringSize(1, getPredictionRiskProfileId()); 
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.predictionRiskProfileId_.isEmpty())
        param1CodedOutputStream.writeString(1, getPredictionRiskProfileId()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<PredictionsTarget, Builder> implements Conditions.PredictionsCondition.PredictionsTargetOrBuilder {
      private Builder() {
        super(Conditions.PredictionsCondition.PredictionsTarget.DEFAULT_INSTANCE);
      }
      
      public Builder clearPredictionRiskProfileId() {
        copyOnWrite();
        ((Conditions.PredictionsCondition.PredictionsTarget)this.instance).clearPredictionRiskProfileId();
        return this;
      }
      
      public String getPredictionRiskProfileId() {
        return ((Conditions.PredictionsCondition.PredictionsTarget)this.instance).getPredictionRiskProfileId();
      }
      
      public ByteString getPredictionRiskProfileIdBytes() {
        return ((Conditions.PredictionsCondition.PredictionsTarget)this.instance).getPredictionRiskProfileIdBytes();
      }
      
      public Builder setPredictionRiskProfileId(String param3String) {
        copyOnWrite();
        ((Conditions.PredictionsCondition.PredictionsTarget)this.instance).setPredictionRiskProfileId(param3String);
        return this;
      }
      
      public Builder setPredictionRiskProfileIdBytes(ByteString param3ByteString) {
        copyOnWrite();
        ((Conditions.PredictionsCondition.PredictionsTarget)this.instance).setPredictionRiskProfileIdBytes(param3ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<PredictionsCondition.PredictionsTarget, PredictionsCondition.PredictionsTarget.Builder> implements PredictionsCondition.PredictionsTargetOrBuilder {
    private Builder() {
      super(Conditions.PredictionsCondition.PredictionsTarget.DEFAULT_INSTANCE);
    }
    
    public Builder clearPredictionRiskProfileId() {
      copyOnWrite();
      ((Conditions.PredictionsCondition.PredictionsTarget)this.instance).clearPredictionRiskProfileId();
      return this;
    }
    
    public String getPredictionRiskProfileId() {
      return ((Conditions.PredictionsCondition.PredictionsTarget)this.instance).getPredictionRiskProfileId();
    }
    
    public ByteString getPredictionRiskProfileIdBytes() {
      return ((Conditions.PredictionsCondition.PredictionsTarget)this.instance).getPredictionRiskProfileIdBytes();
    }
    
    public Builder setPredictionRiskProfileId(String param1String) {
      copyOnWrite();
      ((Conditions.PredictionsCondition.PredictionsTarget)this.instance).setPredictionRiskProfileId(param1String);
      return this;
    }
    
    public Builder setPredictionRiskProfileIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Conditions.PredictionsCondition.PredictionsTarget)this.instance).setPredictionRiskProfileIdBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface PredictionsTargetOrBuilder extends MessageLiteOrBuilder {
    String getPredictionRiskProfileId();
    
    ByteString getPredictionRiskProfileIdBytes();
  }
  
  public static interface PredictionsConditionOrBuilder extends MessageLiteOrBuilder {
    Conditions.PredictionsCondition.PredictionsOperator getOperator();
    
    int getOperatorValue();
    
    Conditions.PredictionsCondition.PredictionsTarget getPredictionTargets(int param1Int);
    
    int getPredictionTargetsCount();
    
    List<Conditions.PredictionsCondition.PredictionsTarget> getPredictionTargetsList();
  }
  
  public static final class TargetDateTimeZone extends GeneratedMessageLite<TargetDateTimeZone, TargetDateTimeZone.Builder> implements TargetDateTimeZoneOrBuilder {
    public static final int DATE_TIME_FIELD_NUMBER = 1;
    
    private static final TargetDateTimeZone DEFAULT_INSTANCE = new TargetDateTimeZone();
    
    private static volatile Parser<TargetDateTimeZone> PARSER;
    
    public static final int TIME_ZONE_FIELD_NUMBER = 2;
    
    private String dateTime_ = "";
    
    private String timeZone_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearDateTime() {
      this.dateTime_ = getDefaultInstance().getDateTime();
    }
    
    private void clearTimeZone() {
      this.timeZone_ = getDefaultInstance().getTimeZone();
    }
    
    public static TargetDateTimeZone getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(TargetDateTimeZone param1TargetDateTimeZone) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1TargetDateTimeZone);
    }
    
    public static TargetDateTimeZone parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (TargetDateTimeZone)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static TargetDateTimeZone parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (TargetDateTimeZone)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static TargetDateTimeZone parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (TargetDateTimeZone)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static TargetDateTimeZone parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (TargetDateTimeZone)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static TargetDateTimeZone parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (TargetDateTimeZone)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static TargetDateTimeZone parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (TargetDateTimeZone)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static TargetDateTimeZone parseFrom(InputStream param1InputStream) throws IOException {
      return (TargetDateTimeZone)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static TargetDateTimeZone parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (TargetDateTimeZone)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static TargetDateTimeZone parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (TargetDateTimeZone)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static TargetDateTimeZone parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (TargetDateTimeZone)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<TargetDateTimeZone> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setDateTime(String param1String) {
      if (param1String != null) {
        this.dateTime_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setDateTimeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.dateTime_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTimeZone(String param1String) {
      if (param1String != null) {
        this.timeZone_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTimeZoneBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.timeZone_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/developers/mobile/targeting/proto/Conditions$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 353, 2 -> 349, 3 -> 347, 4 -> 338, 5 -> 250, 6 -> 110, 7 -> 246, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone
      //   72: monitorenter
      //   73: getstatic com/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 246
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 190
      //   139: iload #5
      //   141: bipush #10
      //   143: if_icmpeq -> 179
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
      //   169: aload_1
      //   170: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   173: putfield timeZone_ : Ljava/lang/String;
      //   176: goto -> 123
      //   179: aload_0
      //   180: aload_1
      //   181: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   184: putfield dateTime_ : Ljava/lang/String;
      //   187: goto -> 123
      //   190: iconst_1
      //   191: istore #4
      //   193: goto -> 123
      //   196: astore_1
      //   197: goto -> 244
      //   200: astore_2
      //   201: new java/lang/RuntimeException
      //   204: astore_1
      //   205: new com/google/protobuf/InvalidProtocolBufferException
      //   208: astore_3
      //   209: aload_3
      //   210: aload_2
      //   211: invokevirtual getMessage : ()Ljava/lang/String;
      //   214: invokespecial <init> : (Ljava/lang/String;)V
      //   217: aload_1
      //   218: aload_3
      //   219: aload_0
      //   220: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   223: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   226: aload_1
      //   227: athrow
      //   228: astore_2
      //   229: new java/lang/RuntimeException
      //   232: astore_1
      //   233: aload_1
      //   234: aload_2
      //   235: aload_0
      //   236: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   239: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   242: aload_1
      //   243: athrow
      //   244: aload_1
      //   245: athrow
      //   246: getstatic com/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone;
      //   249: areturn
      //   250: aload_2
      //   251: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   254: astore_1
      //   255: aload_3
      //   256: checkcast com/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone
      //   259: astore_2
      //   260: aload_0
      //   261: aload_1
      //   262: aload_0
      //   263: getfield dateTime_ : Ljava/lang/String;
      //   266: invokevirtual isEmpty : ()Z
      //   269: iconst_1
      //   270: ixor
      //   271: aload_0
      //   272: getfield dateTime_ : Ljava/lang/String;
      //   275: aload_2
      //   276: getfield dateTime_ : Ljava/lang/String;
      //   279: invokevirtual isEmpty : ()Z
      //   282: iconst_1
      //   283: ixor
      //   284: aload_2
      //   285: getfield dateTime_ : Ljava/lang/String;
      //   288: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   293: putfield dateTime_ : Ljava/lang/String;
      //   296: aload_0
      //   297: aload_1
      //   298: aload_0
      //   299: getfield timeZone_ : Ljava/lang/String;
      //   302: invokevirtual isEmpty : ()Z
      //   305: iconst_1
      //   306: ixor
      //   307: aload_0
      //   308: getfield timeZone_ : Ljava/lang/String;
      //   311: iconst_1
      //   312: aload_2
      //   313: getfield timeZone_ : Ljava/lang/String;
      //   316: invokevirtual isEmpty : ()Z
      //   319: ixor
      //   320: aload_2
      //   321: getfield timeZone_ : Ljava/lang/String;
      //   324: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   329: putfield timeZone_ : Ljava/lang/String;
      //   332: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   335: astore_1
      //   336: aload_0
      //   337: areturn
      //   338: new com/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone$Builder
      //   341: dup
      //   342: aconst_null
      //   343: invokespecial <init> : (Lcom/google/developers/mobile/targeting/proto/Conditions$1;)V
      //   346: areturn
      //   347: aconst_null
      //   348: areturn
      //   349: getstatic com/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone;
      //   352: areturn
      //   353: new com/google/developers/mobile/targeting/proto/Conditions$TargetDateTimeZone
      //   356: dup
      //   357: invokespecial <init> : ()V
      //   360: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	228	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	200	java/io/IOException
      //   128	134	196	finally
      //   153	162	228	com/google/protobuf/InvalidProtocolBufferException
      //   153	162	200	java/io/IOException
      //   153	162	196	finally
      //   168	176	228	com/google/protobuf/InvalidProtocolBufferException
      //   168	176	200	java/io/IOException
      //   168	176	196	finally
      //   179	187	228	com/google/protobuf/InvalidProtocolBufferException
      //   179	187	200	java/io/IOException
      //   179	187	196	finally
      //   201	228	196	finally
      //   229	244	196	finally
    }
    
    public String getDateTime() {
      return this.dateTime_;
    }
    
    public ByteString getDateTimeBytes() {
      return ByteString.copyFromUtf8(this.dateTime_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (!this.dateTime_.isEmpty())
        i = 0 + CodedOutputStream.computeStringSize(1, getDateTime()); 
      int j = i;
      if (!this.timeZone_.isEmpty())
        j = i + CodedOutputStream.computeStringSize(2, getTimeZone()); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public String getTimeZone() {
      return this.timeZone_;
    }
    
    public ByteString getTimeZoneBytes() {
      return ByteString.copyFromUtf8(this.timeZone_);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.dateTime_.isEmpty())
        param1CodedOutputStream.writeString(1, getDateTime()); 
      if (!this.timeZone_.isEmpty())
        param1CodedOutputStream.writeString(2, getTimeZone()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<TargetDateTimeZone, Builder> implements Conditions.TargetDateTimeZoneOrBuilder {
      private Builder() {
        super(Conditions.TargetDateTimeZone.DEFAULT_INSTANCE);
      }
      
      public Builder clearDateTime() {
        copyOnWrite();
        ((Conditions.TargetDateTimeZone)this.instance).clearDateTime();
        return this;
      }
      
      public Builder clearTimeZone() {
        copyOnWrite();
        ((Conditions.TargetDateTimeZone)this.instance).clearTimeZone();
        return this;
      }
      
      public String getDateTime() {
        return ((Conditions.TargetDateTimeZone)this.instance).getDateTime();
      }
      
      public ByteString getDateTimeBytes() {
        return ((Conditions.TargetDateTimeZone)this.instance).getDateTimeBytes();
      }
      
      public String getTimeZone() {
        return ((Conditions.TargetDateTimeZone)this.instance).getTimeZone();
      }
      
      public ByteString getTimeZoneBytes() {
        return ((Conditions.TargetDateTimeZone)this.instance).getTimeZoneBytes();
      }
      
      public Builder setDateTime(String param2String) {
        copyOnWrite();
        ((Conditions.TargetDateTimeZone)this.instance).setDateTime(param2String);
        return this;
      }
      
      public Builder setDateTimeBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((Conditions.TargetDateTimeZone)this.instance).setDateTimeBytes(param2ByteString);
        return this;
      }
      
      public Builder setTimeZone(String param2String) {
        copyOnWrite();
        ((Conditions.TargetDateTimeZone)this.instance).setTimeZone(param2String);
        return this;
      }
      
      public Builder setTimeZoneBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((Conditions.TargetDateTimeZone)this.instance).setTimeZoneBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<TargetDateTimeZone, TargetDateTimeZone.Builder> implements TargetDateTimeZoneOrBuilder {
    private Builder() {
      super(Conditions.TargetDateTimeZone.DEFAULT_INSTANCE);
    }
    
    public Builder clearDateTime() {
      copyOnWrite();
      ((Conditions.TargetDateTimeZone)this.instance).clearDateTime();
      return this;
    }
    
    public Builder clearTimeZone() {
      copyOnWrite();
      ((Conditions.TargetDateTimeZone)this.instance).clearTimeZone();
      return this;
    }
    
    public String getDateTime() {
      return ((Conditions.TargetDateTimeZone)this.instance).getDateTime();
    }
    
    public ByteString getDateTimeBytes() {
      return ((Conditions.TargetDateTimeZone)this.instance).getDateTimeBytes();
    }
    
    public String getTimeZone() {
      return ((Conditions.TargetDateTimeZone)this.instance).getTimeZone();
    }
    
    public ByteString getTimeZoneBytes() {
      return ((Conditions.TargetDateTimeZone)this.instance).getTimeZoneBytes();
    }
    
    public Builder setDateTime(String param1String) {
      copyOnWrite();
      ((Conditions.TargetDateTimeZone)this.instance).setDateTime(param1String);
      return this;
    }
    
    public Builder setDateTimeBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Conditions.TargetDateTimeZone)this.instance).setDateTimeBytes(param1ByteString);
      return this;
    }
    
    public Builder setTimeZone(String param1String) {
      copyOnWrite();
      ((Conditions.TargetDateTimeZone)this.instance).setTimeZone(param1String);
      return this;
    }
    
    public Builder setTimeZoneBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Conditions.TargetDateTimeZone)this.instance).setTimeZoneBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface TargetDateTimeZoneOrBuilder extends MessageLiteOrBuilder {
    String getDateTime();
    
    ByteString getDateTimeBytes();
    
    String getTimeZone();
    
    ByteString getTimeZoneBytes();
  }
  
  public static final class TopicCondition extends GeneratedMessageLite<TopicCondition, TopicCondition.Builder> implements TopicConditionOrBuilder {
    private static final TopicCondition DEFAULT_INSTANCE = new TopicCondition();
    
    private static volatile Parser<TopicCondition> PARSER;
    
    public static final int TOPIC_NAME_FIELD_NUMBER = 1;
    
    private String topicName_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearTopicName() {
      this.topicName_ = getDefaultInstance().getTopicName();
    }
    
    public static TopicCondition getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(TopicCondition param1TopicCondition) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1TopicCondition);
    }
    
    public static TopicCondition parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (TopicCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static TopicCondition parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (TopicCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static TopicCondition parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (TopicCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static TopicCondition parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (TopicCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static TopicCondition parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (TopicCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static TopicCondition parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (TopicCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static TopicCondition parseFrom(InputStream param1InputStream) throws IOException {
      return (TopicCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static TopicCondition parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (TopicCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static TopicCondition parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (TopicCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static TopicCondition parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (TopicCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<TopicCondition> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setTopicName(String param1String) {
      if (param1String != null) {
        this.topicName_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTopicNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.topicName_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/developers/mobile/targeting/proto/Conditions$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 299, 2 -> 295, 3 -> 293, 4 -> 284, 5 -> 232, 6 -> 110, 7 -> 228, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/developers/mobile/targeting/proto/Conditions$TopicCondition.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/developers/mobile/targeting/proto/Conditions$TopicCondition
      //   72: monitorenter
      //   73: getstatic com/google/developers/mobile/targeting/proto/Conditions$TopicCondition.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/developers/mobile/targeting/proto/Conditions$TopicCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$TopicCondition;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/developers/mobile/targeting/proto/Conditions$TopicCondition.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/developers/mobile/targeting/proto/Conditions$TopicCondition
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/developers/mobile/targeting/proto/Conditions$TopicCondition
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/developers/mobile/targeting/proto/Conditions$TopicCondition.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 228
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 172
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
      //   162: aload_1
      //   163: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   166: putfield topicName_ : Ljava/lang/String;
      //   169: goto -> 123
      //   172: iconst_1
      //   173: istore #4
      //   175: goto -> 123
      //   178: astore_1
      //   179: goto -> 226
      //   182: astore_3
      //   183: new java/lang/RuntimeException
      //   186: astore_1
      //   187: new com/google/protobuf/InvalidProtocolBufferException
      //   190: astore_2
      //   191: aload_2
      //   192: aload_3
      //   193: invokevirtual getMessage : ()Ljava/lang/String;
      //   196: invokespecial <init> : (Ljava/lang/String;)V
      //   199: aload_1
      //   200: aload_2
      //   201: aload_0
      //   202: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   205: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   208: aload_1
      //   209: athrow
      //   210: astore_2
      //   211: new java/lang/RuntimeException
      //   214: astore_1
      //   215: aload_1
      //   216: aload_2
      //   217: aload_0
      //   218: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   221: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   224: aload_1
      //   225: athrow
      //   226: aload_1
      //   227: athrow
      //   228: getstatic com/google/developers/mobile/targeting/proto/Conditions$TopicCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$TopicCondition;
      //   231: areturn
      //   232: aload_2
      //   233: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   236: astore_1
      //   237: aload_3
      //   238: checkcast com/google/developers/mobile/targeting/proto/Conditions$TopicCondition
      //   241: astore_2
      //   242: aload_0
      //   243: aload_1
      //   244: aload_0
      //   245: getfield topicName_ : Ljava/lang/String;
      //   248: invokevirtual isEmpty : ()Z
      //   251: iconst_1
      //   252: ixor
      //   253: aload_0
      //   254: getfield topicName_ : Ljava/lang/String;
      //   257: iconst_1
      //   258: aload_2
      //   259: getfield topicName_ : Ljava/lang/String;
      //   262: invokevirtual isEmpty : ()Z
      //   265: ixor
      //   266: aload_2
      //   267: getfield topicName_ : Ljava/lang/String;
      //   270: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   275: putfield topicName_ : Ljava/lang/String;
      //   278: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   281: astore_1
      //   282: aload_0
      //   283: areturn
      //   284: new com/google/developers/mobile/targeting/proto/Conditions$TopicCondition$Builder
      //   287: dup
      //   288: aconst_null
      //   289: invokespecial <init> : (Lcom/google/developers/mobile/targeting/proto/Conditions$1;)V
      //   292: areturn
      //   293: aconst_null
      //   294: areturn
      //   295: getstatic com/google/developers/mobile/targeting/proto/Conditions$TopicCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$TopicCondition;
      //   298: areturn
      //   299: new com/google/developers/mobile/targeting/proto/Conditions$TopicCondition
      //   302: dup
      //   303: invokespecial <init> : ()V
      //   306: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	210	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	182	java/io/IOException
      //   128	134	178	finally
      //   146	155	210	com/google/protobuf/InvalidProtocolBufferException
      //   146	155	182	java/io/IOException
      //   146	155	178	finally
      //   161	169	210	com/google/protobuf/InvalidProtocolBufferException
      //   161	169	182	java/io/IOException
      //   161	169	178	finally
      //   183	210	178	finally
      //   211	226	178	finally
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (!this.topicName_.isEmpty())
        i = 0 + CodedOutputStream.computeStringSize(1, getTopicName()); 
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public String getTopicName() {
      return this.topicName_;
    }
    
    public ByteString getTopicNameBytes() {
      return ByteString.copyFromUtf8(this.topicName_);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.topicName_.isEmpty())
        param1CodedOutputStream.writeString(1, getTopicName()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<TopicCondition, Builder> implements Conditions.TopicConditionOrBuilder {
      private Builder() {
        super(Conditions.TopicCondition.DEFAULT_INSTANCE);
      }
      
      public Builder clearTopicName() {
        copyOnWrite();
        ((Conditions.TopicCondition)this.instance).clearTopicName();
        return this;
      }
      
      public String getTopicName() {
        return ((Conditions.TopicCondition)this.instance).getTopicName();
      }
      
      public ByteString getTopicNameBytes() {
        return ((Conditions.TopicCondition)this.instance).getTopicNameBytes();
      }
      
      public Builder setTopicName(String param2String) {
        copyOnWrite();
        ((Conditions.TopicCondition)this.instance).setTopicName(param2String);
        return this;
      }
      
      public Builder setTopicNameBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((Conditions.TopicCondition)this.instance).setTopicNameBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<TopicCondition, TopicCondition.Builder> implements TopicConditionOrBuilder {
    private Builder() {
      super(Conditions.TopicCondition.DEFAULT_INSTANCE);
    }
    
    public Builder clearTopicName() {
      copyOnWrite();
      ((Conditions.TopicCondition)this.instance).clearTopicName();
      return this;
    }
    
    public String getTopicName() {
      return ((Conditions.TopicCondition)this.instance).getTopicName();
    }
    
    public ByteString getTopicNameBytes() {
      return ((Conditions.TopicCondition)this.instance).getTopicNameBytes();
    }
    
    public Builder setTopicName(String param1String) {
      copyOnWrite();
      ((Conditions.TopicCondition)this.instance).setTopicName(param1String);
      return this;
    }
    
    public Builder setTopicNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Conditions.TopicCondition)this.instance).setTopicNameBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface TopicConditionOrBuilder extends MessageLiteOrBuilder {
    String getTopicName();
    
    ByteString getTopicNameBytes();
  }
  
  public static final class TrueCondition extends GeneratedMessageLite<TrueCondition, TrueCondition.Builder> implements TrueConditionOrBuilder {
    private static final TrueCondition DEFAULT_INSTANCE = new TrueCondition();
    
    private static volatile Parser<TrueCondition> PARSER;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    public static TrueCondition getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(TrueCondition param1TrueCondition) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1TrueCondition);
    }
    
    public static TrueCondition parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (TrueCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static TrueCondition parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (TrueCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static TrueCondition parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (TrueCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static TrueCondition parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (TrueCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static TrueCondition parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (TrueCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static TrueCondition parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (TrueCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static TrueCondition parseFrom(InputStream param1InputStream) throws IOException {
      return (TrueCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static TrueCondition parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (TrueCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static TrueCondition parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (TrueCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static TrueCondition parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (TrueCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<TrueCondition> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/developers/mobile/targeting/proto/Conditions$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 249, 2 -> 245, 3 -> 243, 4 -> 234, 5 -> 218, 6 -> 110, 7 -> 214, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/developers/mobile/targeting/proto/Conditions$TrueCondition.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/developers/mobile/targeting/proto/Conditions$TrueCondition
      //   72: monitorenter
      //   73: getstatic com/google/developers/mobile/targeting/proto/Conditions$TrueCondition.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/developers/mobile/targeting/proto/Conditions$TrueCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$TrueCondition;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/developers/mobile/targeting/proto/Conditions$TrueCondition.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/developers/mobile/targeting/proto/Conditions$TrueCondition
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/developers/mobile/targeting/proto/Conditions$TrueCondition
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/developers/mobile/targeting/proto/Conditions$TrueCondition.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 214
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 158
      //   139: aload_1
      //   140: iload #5
      //   142: invokevirtual skipField : (I)Z
      //   145: istore #6
      //   147: iload #6
      //   149: ifne -> 123
      //   152: iconst_1
      //   153: istore #4
      //   155: goto -> 123
      //   158: iconst_1
      //   159: istore #4
      //   161: goto -> 123
      //   164: astore_1
      //   165: goto -> 212
      //   168: astore_1
      //   169: new java/lang/RuntimeException
      //   172: astore_2
      //   173: new com/google/protobuf/InvalidProtocolBufferException
      //   176: astore_3
      //   177: aload_3
      //   178: aload_1
      //   179: invokevirtual getMessage : ()Ljava/lang/String;
      //   182: invokespecial <init> : (Ljava/lang/String;)V
      //   185: aload_2
      //   186: aload_3
      //   187: aload_0
      //   188: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   191: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   194: aload_2
      //   195: athrow
      //   196: astore_1
      //   197: new java/lang/RuntimeException
      //   200: astore_2
      //   201: aload_2
      //   202: aload_1
      //   203: aload_0
      //   204: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   207: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   210: aload_2
      //   211: athrow
      //   212: aload_1
      //   213: athrow
      //   214: getstatic com/google/developers/mobile/targeting/proto/Conditions$TrueCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$TrueCondition;
      //   217: areturn
      //   218: aload_2
      //   219: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   222: astore_1
      //   223: aload_3
      //   224: checkcast com/google/developers/mobile/targeting/proto/Conditions$TrueCondition
      //   227: astore_1
      //   228: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   231: astore_1
      //   232: aload_0
      //   233: areturn
      //   234: new com/google/developers/mobile/targeting/proto/Conditions$TrueCondition$Builder
      //   237: dup
      //   238: aconst_null
      //   239: invokespecial <init> : (Lcom/google/developers/mobile/targeting/proto/Conditions$1;)V
      //   242: areturn
      //   243: aconst_null
      //   244: areturn
      //   245: getstatic com/google/developers/mobile/targeting/proto/Conditions$TrueCondition.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/Conditions$TrueCondition;
      //   248: areturn
      //   249: new com/google/developers/mobile/targeting/proto/Conditions$TrueCondition
      //   252: dup
      //   253: invokespecial <init> : ()V
      //   256: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	196	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	168	java/io/IOException
      //   128	134	164	finally
      //   139	147	196	com/google/protobuf/InvalidProtocolBufferException
      //   139	147	168	java/io/IOException
      //   139	147	164	finally
      //   169	196	164	finally
      //   197	212	164	finally
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      this.memoizedSerializedSize = 0;
      return 0;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {}
    
    public static final class Builder extends GeneratedMessageLite.Builder<TrueCondition, Builder> implements Conditions.TrueConditionOrBuilder {
      private Builder() {
        super(Conditions.TrueCondition.DEFAULT_INSTANCE);
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<TrueCondition, TrueCondition.Builder> implements TrueConditionOrBuilder {
    private Builder() {
      super(Conditions.TrueCondition.DEFAULT_INSTANCE);
    }
  }
  
  public static interface TrueConditionOrBuilder extends MessageLiteOrBuilder {}
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\developers\mobile\targeting\proto\Conditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */