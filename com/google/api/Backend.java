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

public final class Backend extends GeneratedMessageLite<Backend, Backend.Builder> implements BackendOrBuilder {
  private static final Backend DEFAULT_INSTANCE = new Backend();
  
  private static volatile Parser<Backend> PARSER;
  
  public static final int RULES_FIELD_NUMBER = 1;
  
  private Internal.ProtobufList<BackendRule> rules_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllRules(Iterable<? extends BackendRule> paramIterable) {
    ensureRulesIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.rules_);
  }
  
  private void addRules(int paramInt, BackendRule.Builder paramBuilder) {
    ensureRulesIsMutable();
    this.rules_.add(paramInt, paramBuilder.build());
  }
  
  private void addRules(int paramInt, BackendRule paramBackendRule) {
    if (paramBackendRule != null) {
      ensureRulesIsMutable();
      this.rules_.add(paramInt, paramBackendRule);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addRules(BackendRule.Builder paramBuilder) {
    ensureRulesIsMutable();
    this.rules_.add(paramBuilder.build());
  }
  
  private void addRules(BackendRule paramBackendRule) {
    if (paramBackendRule != null) {
      ensureRulesIsMutable();
      this.rules_.add(paramBackendRule);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearRules() {
    this.rules_ = emptyProtobufList();
  }
  
  private void ensureRulesIsMutable() {
    if (!this.rules_.isModifiable())
      this.rules_ = GeneratedMessageLite.mutableCopy(this.rules_); 
  }
  
  public static Backend getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Backend paramBackend) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramBackend);
  }
  
  public static Backend parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Backend)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Backend parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Backend)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Backend parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Backend)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Backend parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Backend)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Backend parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Backend)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Backend parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Backend)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Backend parseFrom(InputStream paramInputStream) throws IOException {
    return (Backend)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Backend parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Backend)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Backend parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Backend)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Backend parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Backend)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Backend> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeRules(int paramInt) {
    ensureRulesIsMutable();
    this.rules_.remove(paramInt);
  }
  
  private void setRules(int paramInt, BackendRule.Builder paramBuilder) {
    ensureRulesIsMutable();
    this.rules_.set(paramInt, paramBuilder.build());
  }
  
  private void setRules(int paramInt, BackendRule paramBackendRule) {
    if (paramBackendRule != null) {
      ensureRulesIsMutable();
      this.rules_.set(paramInt, paramBackendRule);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/Backend$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 326, 2 -> 322, 3 -> 311, 4 -> 302, 5 -> 268, 6 -> 110, 7 -> 264, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/api/Backend.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/api/Backend
    //   72: monitorenter
    //   73: getstatic com/google/api/Backend.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/api/Backend.DEFAULT_INSTANCE : Lcom/google/api/Backend;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/api/Backend.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/api/Backend
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/api/Backend
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/api/Backend.PARSER : Lcom/google/protobuf/Parser;
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
    //   162: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   165: invokeinterface isModifiable : ()Z
    //   170: ifne -> 184
    //   173: aload_0
    //   174: aload_0
    //   175: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   178: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   181: putfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   184: aload_0
    //   185: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   188: aload_1
    //   189: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   192: aload_2
    //   193: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   196: checkcast com/google/api/BackendRule
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
    //   222: astore_1
    //   223: new com/google/protobuf/InvalidProtocolBufferException
    //   226: astore_2
    //   227: aload_2
    //   228: aload_3
    //   229: invokevirtual getMessage : ()Ljava/lang/String;
    //   232: invokespecial <init> : (Ljava/lang/String;)V
    //   235: aload_1
    //   236: aload_2
    //   237: aload_0
    //   238: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   241: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   244: aload_1
    //   245: athrow
    //   246: astore_1
    //   247: new java/lang/RuntimeException
    //   250: astore_2
    //   251: aload_2
    //   252: aload_1
    //   253: aload_0
    //   254: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   257: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   260: aload_2
    //   261: athrow
    //   262: aload_1
    //   263: athrow
    //   264: getstatic com/google/api/Backend.DEFAULT_INSTANCE : Lcom/google/api/Backend;
    //   267: areturn
    //   268: aload_2
    //   269: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   272: astore_1
    //   273: aload_3
    //   274: checkcast com/google/api/Backend
    //   277: astore_2
    //   278: aload_0
    //   279: aload_1
    //   280: aload_0
    //   281: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   284: aload_2
    //   285: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   288: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   293: putfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   296: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   299: astore_1
    //   300: aload_0
    //   301: areturn
    //   302: new com/google/api/Backend$Builder
    //   305: dup
    //   306: aconst_null
    //   307: invokespecial <init> : (Lcom/google/api/Backend$1;)V
    //   310: areturn
    //   311: aload_0
    //   312: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   315: invokeinterface makeImmutable : ()V
    //   320: aconst_null
    //   321: areturn
    //   322: getstatic com/google/api/Backend.DEFAULT_INSTANCE : Lcom/google/api/Backend;
    //   325: areturn
    //   326: new com/google/api/Backend
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
  
  public BackendRule getRules(int paramInt) {
    return (BackendRule)this.rules_.get(paramInt);
  }
  
  public int getRulesCount() {
    return this.rules_.size();
  }
  
  public List<BackendRule> getRulesList() {
    return (List<BackendRule>)this.rules_;
  }
  
  public BackendRuleOrBuilder getRulesOrBuilder(int paramInt) {
    return (BackendRuleOrBuilder)this.rules_.get(paramInt);
  }
  
  public List<? extends BackendRuleOrBuilder> getRulesOrBuilderList() {
    return (List)this.rules_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    byte b = 0;
    i = 0;
    while (b < this.rules_.size()) {
      i += CodedOutputStream.computeMessageSize(1, (MessageLite)this.rules_.get(b));
      b++;
    } 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (byte b = 0; b < this.rules_.size(); b++)
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.rules_.get(b)); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Backend, Builder> implements BackendOrBuilder {
    private Builder() {
      super(Backend.DEFAULT_INSTANCE);
    }
    
    public Builder addAllRules(Iterable<? extends BackendRule> param1Iterable) {
      copyOnWrite();
      ((Backend)this.instance).addAllRules(param1Iterable);
      return this;
    }
    
    public Builder addRules(int param1Int, BackendRule.Builder param1Builder) {
      copyOnWrite();
      ((Backend)this.instance).addRules(param1Int, param1Builder);
      return this;
    }
    
    public Builder addRules(int param1Int, BackendRule param1BackendRule) {
      copyOnWrite();
      ((Backend)this.instance).addRules(param1Int, param1BackendRule);
      return this;
    }
    
    public Builder addRules(BackendRule.Builder param1Builder) {
      copyOnWrite();
      ((Backend)this.instance).addRules(param1Builder);
      return this;
    }
    
    public Builder addRules(BackendRule param1BackendRule) {
      copyOnWrite();
      ((Backend)this.instance).addRules(param1BackendRule);
      return this;
    }
    
    public Builder clearRules() {
      copyOnWrite();
      ((Backend)this.instance).clearRules();
      return this;
    }
    
    public BackendRule getRules(int param1Int) {
      return ((Backend)this.instance).getRules(param1Int);
    }
    
    public int getRulesCount() {
      return ((Backend)this.instance).getRulesCount();
    }
    
    public List<BackendRule> getRulesList() {
      return Collections.unmodifiableList(((Backend)this.instance).getRulesList());
    }
    
    public Builder removeRules(int param1Int) {
      copyOnWrite();
      ((Backend)this.instance).removeRules(param1Int);
      return this;
    }
    
    public Builder setRules(int param1Int, BackendRule.Builder param1Builder) {
      copyOnWrite();
      ((Backend)this.instance).setRules(param1Int, param1Builder);
      return this;
    }
    
    public Builder setRules(int param1Int, BackendRule param1BackendRule) {
      copyOnWrite();
      ((Backend)this.instance).setRules(param1Int, param1BackendRule);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\Backend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */