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

public final class Quota extends GeneratedMessageLite<Quota, Quota.Builder> implements QuotaOrBuilder {
  private static final Quota DEFAULT_INSTANCE = new Quota();
  
  public static final int LIMITS_FIELD_NUMBER = 3;
  
  public static final int METRIC_RULES_FIELD_NUMBER = 4;
  
  private static volatile Parser<Quota> PARSER;
  
  private Internal.ProtobufList<QuotaLimit> limits_ = emptyProtobufList();
  
  private Internal.ProtobufList<MetricRule> metricRules_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllLimits(Iterable<? extends QuotaLimit> paramIterable) {
    ensureLimitsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.limits_);
  }
  
  private void addAllMetricRules(Iterable<? extends MetricRule> paramIterable) {
    ensureMetricRulesIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.metricRules_);
  }
  
  private void addLimits(int paramInt, QuotaLimit.Builder paramBuilder) {
    ensureLimitsIsMutable();
    this.limits_.add(paramInt, paramBuilder.build());
  }
  
  private void addLimits(int paramInt, QuotaLimit paramQuotaLimit) {
    if (paramQuotaLimit != null) {
      ensureLimitsIsMutable();
      this.limits_.add(paramInt, paramQuotaLimit);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addLimits(QuotaLimit.Builder paramBuilder) {
    ensureLimitsIsMutable();
    this.limits_.add(paramBuilder.build());
  }
  
  private void addLimits(QuotaLimit paramQuotaLimit) {
    if (paramQuotaLimit != null) {
      ensureLimitsIsMutable();
      this.limits_.add(paramQuotaLimit);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addMetricRules(int paramInt, MetricRule.Builder paramBuilder) {
    ensureMetricRulesIsMutable();
    this.metricRules_.add(paramInt, paramBuilder.build());
  }
  
  private void addMetricRules(int paramInt, MetricRule paramMetricRule) {
    if (paramMetricRule != null) {
      ensureMetricRulesIsMutable();
      this.metricRules_.add(paramInt, paramMetricRule);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addMetricRules(MetricRule.Builder paramBuilder) {
    ensureMetricRulesIsMutable();
    this.metricRules_.add(paramBuilder.build());
  }
  
  private void addMetricRules(MetricRule paramMetricRule) {
    if (paramMetricRule != null) {
      ensureMetricRulesIsMutable();
      this.metricRules_.add(paramMetricRule);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearLimits() {
    this.limits_ = emptyProtobufList();
  }
  
  private void clearMetricRules() {
    this.metricRules_ = emptyProtobufList();
  }
  
  private void ensureLimitsIsMutable() {
    if (!this.limits_.isModifiable())
      this.limits_ = GeneratedMessageLite.mutableCopy(this.limits_); 
  }
  
  private void ensureMetricRulesIsMutable() {
    if (!this.metricRules_.isModifiable())
      this.metricRules_ = GeneratedMessageLite.mutableCopy(this.metricRules_); 
  }
  
  public static Quota getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Quota paramQuota) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramQuota);
  }
  
  public static Quota parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Quota)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Quota parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Quota)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Quota parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Quota)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Quota parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Quota)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Quota parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Quota)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Quota parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Quota)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Quota parseFrom(InputStream paramInputStream) throws IOException {
    return (Quota)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Quota parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Quota)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Quota parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Quota)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Quota parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Quota)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Quota> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeLimits(int paramInt) {
    ensureLimitsIsMutable();
    this.limits_.remove(paramInt);
  }
  
  private void removeMetricRules(int paramInt) {
    ensureMetricRulesIsMutable();
    this.metricRules_.remove(paramInt);
  }
  
  private void setLimits(int paramInt, QuotaLimit.Builder paramBuilder) {
    ensureLimitsIsMutable();
    this.limits_.set(paramInt, paramBuilder.build());
  }
  
  private void setLimits(int paramInt, QuotaLimit paramQuotaLimit) {
    if (paramQuotaLimit != null) {
      ensureLimitsIsMutable();
      this.limits_.set(paramInt, paramQuotaLimit);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setMetricRules(int paramInt, MetricRule.Builder paramBuilder) {
    ensureMetricRulesIsMutable();
    this.metricRules_.set(paramInt, paramBuilder.build());
  }
  
  private void setMetricRules(int paramInt, MetricRule paramMetricRule) {
    if (paramMetricRule != null) {
      ensureMetricRulesIsMutable();
      this.metricRules_.set(paramInt, paramMetricRule);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/Quota$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 407, 2 -> 403, 3 -> 383, 4 -> 374, 5 -> 322, 6 -> 110, 7 -> 318, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/api/Quota.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/api/Quota
    //   72: monitorenter
    //   73: getstatic com/google/api/Quota.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/api/Quota.DEFAULT_INSTANCE : Lcom/google/api/Quota;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/api/Quota.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/api/Quota
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/api/Quota
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/api/Quota.PARSER : Lcom/google/protobuf/Parser;
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
    //   141: bipush #26
    //   143: if_icmpeq -> 215
    //   146: iload #5
    //   148: bipush #34
    //   150: if_icmpeq -> 168
    //   153: aload_1
    //   154: iload #5
    //   156: invokevirtual skipField : (I)Z
    //   159: ifne -> 123
    //   162: iconst_1
    //   163: istore #4
    //   165: goto -> 123
    //   168: aload_0
    //   169: getfield metricRules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   172: invokeinterface isModifiable : ()Z
    //   177: ifne -> 191
    //   180: aload_0
    //   181: aload_0
    //   182: getfield metricRules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   185: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   188: putfield metricRules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   191: aload_0
    //   192: getfield metricRules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   195: aload_1
    //   196: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   199: aload_2
    //   200: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   203: checkcast com/google/api/MetricRule
    //   206: invokeinterface add : (Ljava/lang/Object;)Z
    //   211: pop
    //   212: goto -> 123
    //   215: aload_0
    //   216: getfield limits_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   219: invokeinterface isModifiable : ()Z
    //   224: ifne -> 238
    //   227: aload_0
    //   228: aload_0
    //   229: getfield limits_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   232: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   235: putfield limits_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   238: aload_0
    //   239: getfield limits_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   242: aload_1
    //   243: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   246: aload_2
    //   247: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   250: checkcast com/google/api/QuotaLimit
    //   253: invokeinterface add : (Ljava/lang/Object;)Z
    //   258: pop
    //   259: goto -> 123
    //   262: iconst_1
    //   263: istore #4
    //   265: goto -> 123
    //   268: astore_1
    //   269: goto -> 316
    //   272: astore_2
    //   273: new java/lang/RuntimeException
    //   276: astore_1
    //   277: new com/google/protobuf/InvalidProtocolBufferException
    //   280: astore_3
    //   281: aload_3
    //   282: aload_2
    //   283: invokevirtual getMessage : ()Ljava/lang/String;
    //   286: invokespecial <init> : (Ljava/lang/String;)V
    //   289: aload_1
    //   290: aload_3
    //   291: aload_0
    //   292: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   295: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   298: aload_1
    //   299: athrow
    //   300: astore_2
    //   301: new java/lang/RuntimeException
    //   304: astore_1
    //   305: aload_1
    //   306: aload_2
    //   307: aload_0
    //   308: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   311: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   314: aload_1
    //   315: athrow
    //   316: aload_1
    //   317: athrow
    //   318: getstatic com/google/api/Quota.DEFAULT_INSTANCE : Lcom/google/api/Quota;
    //   321: areturn
    //   322: aload_2
    //   323: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   326: astore_1
    //   327: aload_3
    //   328: checkcast com/google/api/Quota
    //   331: astore_2
    //   332: aload_0
    //   333: aload_1
    //   334: aload_0
    //   335: getfield limits_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   338: aload_2
    //   339: getfield limits_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   342: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   347: putfield limits_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   350: aload_0
    //   351: aload_1
    //   352: aload_0
    //   353: getfield metricRules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   356: aload_2
    //   357: getfield metricRules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   360: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   365: putfield metricRules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   368: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   371: astore_1
    //   372: aload_0
    //   373: areturn
    //   374: new com/google/api/Quota$Builder
    //   377: dup
    //   378: aconst_null
    //   379: invokespecial <init> : (Lcom/google/api/Quota$1;)V
    //   382: areturn
    //   383: aload_0
    //   384: getfield limits_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   387: invokeinterface makeImmutable : ()V
    //   392: aload_0
    //   393: getfield metricRules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   396: invokeinterface makeImmutable : ()V
    //   401: aconst_null
    //   402: areturn
    //   403: getstatic com/google/api/Quota.DEFAULT_INSTANCE : Lcom/google/api/Quota;
    //   406: areturn
    //   407: new com/google/api/Quota
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
  
  public QuotaLimit getLimits(int paramInt) {
    return (QuotaLimit)this.limits_.get(paramInt);
  }
  
  public int getLimitsCount() {
    return this.limits_.size();
  }
  
  public List<QuotaLimit> getLimitsList() {
    return (List<QuotaLimit>)this.limits_;
  }
  
  public QuotaLimitOrBuilder getLimitsOrBuilder(int paramInt) {
    return (QuotaLimitOrBuilder)this.limits_.get(paramInt);
  }
  
  public List<? extends QuotaLimitOrBuilder> getLimitsOrBuilderList() {
    return (List)this.limits_;
  }
  
  public MetricRule getMetricRules(int paramInt) {
    return (MetricRule)this.metricRules_.get(paramInt);
  }
  
  public int getMetricRulesCount() {
    return this.metricRules_.size();
  }
  
  public List<MetricRule> getMetricRulesList() {
    return (List<MetricRule>)this.metricRules_;
  }
  
  public MetricRuleOrBuilder getMetricRulesOrBuilder(int paramInt) {
    return (MetricRuleOrBuilder)this.metricRules_.get(paramInt);
  }
  
  public List<? extends MetricRuleOrBuilder> getMetricRulesOrBuilderList() {
    return (List)this.metricRules_;
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
      if (b2 < this.limits_.size()) {
        i += CodedOutputStream.computeMessageSize(3, (MessageLite)this.limits_.get(b2));
        b2++;
        continue;
      } 
      break;
    } 
    while (b3 < this.metricRules_.size()) {
      j += CodedOutputStream.computeMessageSize(4, (MessageLite)this.metricRules_.get(b3));
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
      if (b2 < this.limits_.size()) {
        paramCodedOutputStream.writeMessage(3, (MessageLite)this.limits_.get(b2));
        b2++;
        continue;
      } 
      break;
    } 
    while (b3 < this.metricRules_.size()) {
      paramCodedOutputStream.writeMessage(4, (MessageLite)this.metricRules_.get(b3));
      b3++;
    } 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Quota, Builder> implements QuotaOrBuilder {
    private Builder() {
      super(Quota.DEFAULT_INSTANCE);
    }
    
    public Builder addAllLimits(Iterable<? extends QuotaLimit> param1Iterable) {
      copyOnWrite();
      ((Quota)this.instance).addAllLimits(param1Iterable);
      return this;
    }
    
    public Builder addAllMetricRules(Iterable<? extends MetricRule> param1Iterable) {
      copyOnWrite();
      ((Quota)this.instance).addAllMetricRules(param1Iterable);
      return this;
    }
    
    public Builder addLimits(int param1Int, QuotaLimit.Builder param1Builder) {
      copyOnWrite();
      ((Quota)this.instance).addLimits(param1Int, param1Builder);
      return this;
    }
    
    public Builder addLimits(int param1Int, QuotaLimit param1QuotaLimit) {
      copyOnWrite();
      ((Quota)this.instance).addLimits(param1Int, param1QuotaLimit);
      return this;
    }
    
    public Builder addLimits(QuotaLimit.Builder param1Builder) {
      copyOnWrite();
      ((Quota)this.instance).addLimits(param1Builder);
      return this;
    }
    
    public Builder addLimits(QuotaLimit param1QuotaLimit) {
      copyOnWrite();
      ((Quota)this.instance).addLimits(param1QuotaLimit);
      return this;
    }
    
    public Builder addMetricRules(int param1Int, MetricRule.Builder param1Builder) {
      copyOnWrite();
      ((Quota)this.instance).addMetricRules(param1Int, param1Builder);
      return this;
    }
    
    public Builder addMetricRules(int param1Int, MetricRule param1MetricRule) {
      copyOnWrite();
      ((Quota)this.instance).addMetricRules(param1Int, param1MetricRule);
      return this;
    }
    
    public Builder addMetricRules(MetricRule.Builder param1Builder) {
      copyOnWrite();
      ((Quota)this.instance).addMetricRules(param1Builder);
      return this;
    }
    
    public Builder addMetricRules(MetricRule param1MetricRule) {
      copyOnWrite();
      ((Quota)this.instance).addMetricRules(param1MetricRule);
      return this;
    }
    
    public Builder clearLimits() {
      copyOnWrite();
      ((Quota)this.instance).clearLimits();
      return this;
    }
    
    public Builder clearMetricRules() {
      copyOnWrite();
      ((Quota)this.instance).clearMetricRules();
      return this;
    }
    
    public QuotaLimit getLimits(int param1Int) {
      return ((Quota)this.instance).getLimits(param1Int);
    }
    
    public int getLimitsCount() {
      return ((Quota)this.instance).getLimitsCount();
    }
    
    public List<QuotaLimit> getLimitsList() {
      return Collections.unmodifiableList(((Quota)this.instance).getLimitsList());
    }
    
    public MetricRule getMetricRules(int param1Int) {
      return ((Quota)this.instance).getMetricRules(param1Int);
    }
    
    public int getMetricRulesCount() {
      return ((Quota)this.instance).getMetricRulesCount();
    }
    
    public List<MetricRule> getMetricRulesList() {
      return Collections.unmodifiableList(((Quota)this.instance).getMetricRulesList());
    }
    
    public Builder removeLimits(int param1Int) {
      copyOnWrite();
      ((Quota)this.instance).removeLimits(param1Int);
      return this;
    }
    
    public Builder removeMetricRules(int param1Int) {
      copyOnWrite();
      ((Quota)this.instance).removeMetricRules(param1Int);
      return this;
    }
    
    public Builder setLimits(int param1Int, QuotaLimit.Builder param1Builder) {
      copyOnWrite();
      ((Quota)this.instance).setLimits(param1Int, param1Builder);
      return this;
    }
    
    public Builder setLimits(int param1Int, QuotaLimit param1QuotaLimit) {
      copyOnWrite();
      ((Quota)this.instance).setLimits(param1Int, param1QuotaLimit);
      return this;
    }
    
    public Builder setMetricRules(int param1Int, MetricRule.Builder param1Builder) {
      copyOnWrite();
      ((Quota)this.instance).setMetricRules(param1Int, param1Builder);
      return this;
    }
    
    public Builder setMetricRules(int param1Int, MetricRule param1MetricRule) {
      copyOnWrite();
      ((Quota)this.instance).setMetricRules(param1Int, param1MetricRule);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\Quota.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */