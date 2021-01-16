package com.google.api;

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

public final class Usage extends GeneratedMessageLite<Usage, Usage.Builder> implements UsageOrBuilder {
  private static final Usage DEFAULT_INSTANCE = new Usage();
  
  private static volatile Parser<Usage> PARSER;
  
  public static final int PRODUCER_NOTIFICATION_CHANNEL_FIELD_NUMBER = 7;
  
  public static final int REQUIREMENTS_FIELD_NUMBER = 1;
  
  public static final int RULES_FIELD_NUMBER = 6;
  
  private int bitField0_;
  
  private String producerNotificationChannel_ = "";
  
  private Internal.ProtobufList<String> requirements_ = GeneratedMessageLite.emptyProtobufList();
  
  private Internal.ProtobufList<UsageRule> rules_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllRequirements(Iterable<String> paramIterable) {
    ensureRequirementsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.requirements_);
  }
  
  private void addAllRules(Iterable<? extends UsageRule> paramIterable) {
    ensureRulesIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.rules_);
  }
  
  private void addRequirements(String paramString) {
    if (paramString != null) {
      ensureRequirementsIsMutable();
      this.requirements_.add(paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addRequirementsBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      ensureRequirementsIsMutable();
      this.requirements_.add(paramByteString.toStringUtf8());
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addRules(int paramInt, UsageRule.Builder paramBuilder) {
    ensureRulesIsMutable();
    this.rules_.add(paramInt, paramBuilder.build());
  }
  
  private void addRules(int paramInt, UsageRule paramUsageRule) {
    if (paramUsageRule != null) {
      ensureRulesIsMutable();
      this.rules_.add(paramInt, paramUsageRule);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addRules(UsageRule.Builder paramBuilder) {
    ensureRulesIsMutable();
    this.rules_.add(paramBuilder.build());
  }
  
  private void addRules(UsageRule paramUsageRule) {
    if (paramUsageRule != null) {
      ensureRulesIsMutable();
      this.rules_.add(paramUsageRule);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearProducerNotificationChannel() {
    this.producerNotificationChannel_ = getDefaultInstance().getProducerNotificationChannel();
  }
  
  private void clearRequirements() {
    this.requirements_ = GeneratedMessageLite.emptyProtobufList();
  }
  
  private void clearRules() {
    this.rules_ = emptyProtobufList();
  }
  
  private void ensureRequirementsIsMutable() {
    if (!this.requirements_.isModifiable())
      this.requirements_ = GeneratedMessageLite.mutableCopy(this.requirements_); 
  }
  
  private void ensureRulesIsMutable() {
    if (!this.rules_.isModifiable())
      this.rules_ = GeneratedMessageLite.mutableCopy(this.rules_); 
  }
  
  public static Usage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Usage paramUsage) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramUsage);
  }
  
  public static Usage parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Usage)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Usage parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Usage)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Usage parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Usage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Usage parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Usage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Usage parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Usage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Usage parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Usage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Usage parseFrom(InputStream paramInputStream) throws IOException {
    return (Usage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Usage parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Usage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Usage parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Usage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Usage parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Usage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Usage> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeRules(int paramInt) {
    ensureRulesIsMutable();
    this.rules_.remove(paramInt);
  }
  
  private void setProducerNotificationChannel(String paramString) {
    if (paramString != null) {
      this.producerNotificationChannel_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setProducerNotificationChannelBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.producerNotificationChannel_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRequirements(int paramInt, String paramString) {
    if (paramString != null) {
      ensureRequirementsIsMutable();
      this.requirements_.set(paramInt, paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRules(int paramInt, UsageRule.Builder paramBuilder) {
    ensureRulesIsMutable();
    this.rules_.set(paramInt, paramBuilder.build());
  }
  
  private void setRules(int paramInt, UsageRule paramUsageRule) {
    if (paramUsageRule != null) {
      ensureRulesIsMutable();
      this.rules_.set(paramInt, paramUsageRule);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/Usage$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 472, 2 -> 468, 3 -> 448, 4 -> 439, 5 -> 335, 6 -> 110, 7 -> 331, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/api/Usage.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/api/Usage
    //   72: monitorenter
    //   73: getstatic com/google/api/Usage.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/api/Usage.DEFAULT_INSTANCE : Lcom/google/api/Usage;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/api/Usage.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/api/Usage
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/api/Usage
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/api/Usage.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 331
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 275
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 233
    //   146: iload #5
    //   148: bipush #50
    //   150: if_icmpeq -> 186
    //   153: iload #5
    //   155: bipush #58
    //   157: if_icmpeq -> 175
    //   160: aload_1
    //   161: iload #5
    //   163: invokevirtual skipField : (I)Z
    //   166: ifne -> 123
    //   169: iconst_1
    //   170: istore #4
    //   172: goto -> 123
    //   175: aload_0
    //   176: aload_1
    //   177: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   180: putfield producerNotificationChannel_ : Ljava/lang/String;
    //   183: goto -> 123
    //   186: aload_0
    //   187: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   190: invokeinterface isModifiable : ()Z
    //   195: ifne -> 209
    //   198: aload_0
    //   199: aload_0
    //   200: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   203: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   206: putfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   209: aload_0
    //   210: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   213: aload_1
    //   214: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   217: aload_2
    //   218: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   221: checkcast com/google/api/UsageRule
    //   224: invokeinterface add : (Ljava/lang/Object;)Z
    //   229: pop
    //   230: goto -> 123
    //   233: aload_1
    //   234: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   237: astore_3
    //   238: aload_0
    //   239: getfield requirements_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   242: invokeinterface isModifiable : ()Z
    //   247: ifne -> 261
    //   250: aload_0
    //   251: aload_0
    //   252: getfield requirements_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   255: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   258: putfield requirements_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   261: aload_0
    //   262: getfield requirements_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   265: aload_3
    //   266: invokeinterface add : (Ljava/lang/Object;)Z
    //   271: pop
    //   272: goto -> 123
    //   275: iconst_1
    //   276: istore #4
    //   278: goto -> 123
    //   281: astore_1
    //   282: goto -> 329
    //   285: astore_2
    //   286: new java/lang/RuntimeException
    //   289: astore_3
    //   290: new com/google/protobuf/InvalidProtocolBufferException
    //   293: astore_1
    //   294: aload_1
    //   295: aload_2
    //   296: invokevirtual getMessage : ()Ljava/lang/String;
    //   299: invokespecial <init> : (Ljava/lang/String;)V
    //   302: aload_3
    //   303: aload_1
    //   304: aload_0
    //   305: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   308: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   311: aload_3
    //   312: athrow
    //   313: astore_1
    //   314: new java/lang/RuntimeException
    //   317: astore_2
    //   318: aload_2
    //   319: aload_1
    //   320: aload_0
    //   321: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   324: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   327: aload_2
    //   328: athrow
    //   329: aload_1
    //   330: athrow
    //   331: getstatic com/google/api/Usage.DEFAULT_INSTANCE : Lcom/google/api/Usage;
    //   334: areturn
    //   335: aload_2
    //   336: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   339: astore_1
    //   340: aload_3
    //   341: checkcast com/google/api/Usage
    //   344: astore_2
    //   345: aload_0
    //   346: aload_1
    //   347: aload_0
    //   348: getfield requirements_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   351: aload_2
    //   352: getfield requirements_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   355: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   360: putfield requirements_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   363: aload_0
    //   364: aload_1
    //   365: aload_0
    //   366: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   369: aload_2
    //   370: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   373: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   378: putfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   381: aload_0
    //   382: aload_1
    //   383: aload_0
    //   384: getfield producerNotificationChannel_ : Ljava/lang/String;
    //   387: invokevirtual isEmpty : ()Z
    //   390: iconst_1
    //   391: ixor
    //   392: aload_0
    //   393: getfield producerNotificationChannel_ : Ljava/lang/String;
    //   396: iconst_1
    //   397: aload_2
    //   398: getfield producerNotificationChannel_ : Ljava/lang/String;
    //   401: invokevirtual isEmpty : ()Z
    //   404: ixor
    //   405: aload_2
    //   406: getfield producerNotificationChannel_ : Ljava/lang/String;
    //   409: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   414: putfield producerNotificationChannel_ : Ljava/lang/String;
    //   417: aload_1
    //   418: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   421: if_acmpne -> 437
    //   424: aload_0
    //   425: aload_0
    //   426: getfield bitField0_ : I
    //   429: aload_2
    //   430: getfield bitField0_ : I
    //   433: ior
    //   434: putfield bitField0_ : I
    //   437: aload_0
    //   438: areturn
    //   439: new com/google/api/Usage$Builder
    //   442: dup
    //   443: aconst_null
    //   444: invokespecial <init> : (Lcom/google/api/Usage$1;)V
    //   447: areturn
    //   448: aload_0
    //   449: getfield requirements_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   452: invokeinterface makeImmutable : ()V
    //   457: aload_0
    //   458: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   461: invokeinterface makeImmutable : ()V
    //   466: aconst_null
    //   467: areturn
    //   468: getstatic com/google/api/Usage.DEFAULT_INSTANCE : Lcom/google/api/Usage;
    //   471: areturn
    //   472: new com/google/api/Usage
    //   475: dup
    //   476: invokespecial <init> : ()V
    //   479: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	313	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	285	java/io/IOException
    //   128	134	281	finally
    //   160	169	313	com/google/protobuf/InvalidProtocolBufferException
    //   160	169	285	java/io/IOException
    //   160	169	281	finally
    //   175	183	313	com/google/protobuf/InvalidProtocolBufferException
    //   175	183	285	java/io/IOException
    //   175	183	281	finally
    //   186	209	313	com/google/protobuf/InvalidProtocolBufferException
    //   186	209	285	java/io/IOException
    //   186	209	281	finally
    //   209	230	313	com/google/protobuf/InvalidProtocolBufferException
    //   209	230	285	java/io/IOException
    //   209	230	281	finally
    //   233	261	313	com/google/protobuf/InvalidProtocolBufferException
    //   233	261	285	java/io/IOException
    //   233	261	281	finally
    //   261	272	313	com/google/protobuf/InvalidProtocolBufferException
    //   261	272	285	java/io/IOException
    //   261	272	281	finally
    //   286	313	281	finally
    //   314	329	281	finally
  }
  
  public String getProducerNotificationChannel() {
    return this.producerNotificationChannel_;
  }
  
  public ByteString getProducerNotificationChannelBytes() {
    return ByteString.copyFromUtf8(this.producerNotificationChannel_);
  }
  
  public String getRequirements(int paramInt) {
    return (String)this.requirements_.get(paramInt);
  }
  
  public ByteString getRequirementsBytes(int paramInt) {
    return ByteString.copyFromUtf8((String)this.requirements_.get(paramInt));
  }
  
  public int getRequirementsCount() {
    return this.requirements_.size();
  }
  
  public List<String> getRequirementsList() {
    return (List<String>)this.requirements_;
  }
  
  public UsageRule getRules(int paramInt) {
    return (UsageRule)this.rules_.get(paramInt);
  }
  
  public int getRulesCount() {
    return this.rules_.size();
  }
  
  public List<UsageRule> getRulesList() {
    return (List<UsageRule>)this.rules_;
  }
  
  public UsageRuleOrBuilder getRulesOrBuilder(int paramInt) {
    return (UsageRuleOrBuilder)this.rules_.get(paramInt);
  }
  
  public List<? extends UsageRuleOrBuilder> getRulesOrBuilderList() {
    return (List)this.rules_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    boolean bool = false;
    i = 0;
    int j = 0;
    while (i < this.requirements_.size()) {
      j += CodedOutputStream.computeStringSizeNoTag((String)this.requirements_.get(i));
      i++;
    } 
    i = j + 0 + getRequirementsList().size() * 1;
    for (j = bool; j < this.rules_.size(); j++)
      i += CodedOutputStream.computeMessageSize(6, (MessageLite)this.rules_.get(j)); 
    j = i;
    if (!this.producerNotificationChannel_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(7, getProducerNotificationChannel()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    byte b3;
    byte b1 = 0;
    byte b2 = 0;
    while (true) {
      b3 = b1;
      if (b2 < this.requirements_.size()) {
        paramCodedOutputStream.writeString(1, (String)this.requirements_.get(b2));
        b2++;
        continue;
      } 
      break;
    } 
    while (b3 < this.rules_.size()) {
      paramCodedOutputStream.writeMessage(6, (MessageLite)this.rules_.get(b3));
      b3++;
    } 
    if (!this.producerNotificationChannel_.isEmpty())
      paramCodedOutputStream.writeString(7, getProducerNotificationChannel()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Usage, Builder> implements UsageOrBuilder {
    private Builder() {
      super(Usage.DEFAULT_INSTANCE);
    }
    
    public Builder addAllRequirements(Iterable<String> param1Iterable) {
      copyOnWrite();
      ((Usage)this.instance).addAllRequirements(param1Iterable);
      return this;
    }
    
    public Builder addAllRules(Iterable<? extends UsageRule> param1Iterable) {
      copyOnWrite();
      ((Usage)this.instance).addAllRules(param1Iterable);
      return this;
    }
    
    public Builder addRequirements(String param1String) {
      copyOnWrite();
      ((Usage)this.instance).addRequirements(param1String);
      return this;
    }
    
    public Builder addRequirementsBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Usage)this.instance).addRequirementsBytes(param1ByteString);
      return this;
    }
    
    public Builder addRules(int param1Int, UsageRule.Builder param1Builder) {
      copyOnWrite();
      ((Usage)this.instance).addRules(param1Int, param1Builder);
      return this;
    }
    
    public Builder addRules(int param1Int, UsageRule param1UsageRule) {
      copyOnWrite();
      ((Usage)this.instance).addRules(param1Int, param1UsageRule);
      return this;
    }
    
    public Builder addRules(UsageRule.Builder param1Builder) {
      copyOnWrite();
      ((Usage)this.instance).addRules(param1Builder);
      return this;
    }
    
    public Builder addRules(UsageRule param1UsageRule) {
      copyOnWrite();
      ((Usage)this.instance).addRules(param1UsageRule);
      return this;
    }
    
    public Builder clearProducerNotificationChannel() {
      copyOnWrite();
      ((Usage)this.instance).clearProducerNotificationChannel();
      return this;
    }
    
    public Builder clearRequirements() {
      copyOnWrite();
      ((Usage)this.instance).clearRequirements();
      return this;
    }
    
    public Builder clearRules() {
      copyOnWrite();
      ((Usage)this.instance).clearRules();
      return this;
    }
    
    public String getProducerNotificationChannel() {
      return ((Usage)this.instance).getProducerNotificationChannel();
    }
    
    public ByteString getProducerNotificationChannelBytes() {
      return ((Usage)this.instance).getProducerNotificationChannelBytes();
    }
    
    public String getRequirements(int param1Int) {
      return ((Usage)this.instance).getRequirements(param1Int);
    }
    
    public ByteString getRequirementsBytes(int param1Int) {
      return ((Usage)this.instance).getRequirementsBytes(param1Int);
    }
    
    public int getRequirementsCount() {
      return ((Usage)this.instance).getRequirementsCount();
    }
    
    public List<String> getRequirementsList() {
      return Collections.unmodifiableList(((Usage)this.instance).getRequirementsList());
    }
    
    public UsageRule getRules(int param1Int) {
      return ((Usage)this.instance).getRules(param1Int);
    }
    
    public int getRulesCount() {
      return ((Usage)this.instance).getRulesCount();
    }
    
    public List<UsageRule> getRulesList() {
      return Collections.unmodifiableList(((Usage)this.instance).getRulesList());
    }
    
    public Builder removeRules(int param1Int) {
      copyOnWrite();
      ((Usage)this.instance).removeRules(param1Int);
      return this;
    }
    
    public Builder setProducerNotificationChannel(String param1String) {
      copyOnWrite();
      ((Usage)this.instance).setProducerNotificationChannel(param1String);
      return this;
    }
    
    public Builder setProducerNotificationChannelBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Usage)this.instance).setProducerNotificationChannelBytes(param1ByteString);
      return this;
    }
    
    public Builder setRequirements(int param1Int, String param1String) {
      copyOnWrite();
      ((Usage)this.instance).setRequirements(param1Int, param1String);
      return this;
    }
    
    public Builder setRules(int param1Int, UsageRule.Builder param1Builder) {
      copyOnWrite();
      ((Usage)this.instance).setRules(param1Int, param1Builder);
      return this;
    }
    
    public Builder setRules(int param1Int, UsageRule param1UsageRule) {
      copyOnWrite();
      ((Usage)this.instance).setRules(param1Int, param1UsageRule);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\Usage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */