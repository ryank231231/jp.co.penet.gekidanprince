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

public final class Http extends GeneratedMessageLite<Http, Http.Builder> implements HttpOrBuilder {
  private static final Http DEFAULT_INSTANCE = new Http();
  
  public static final int FULLY_DECODE_RESERVED_EXPANSION_FIELD_NUMBER = 2;
  
  private static volatile Parser<Http> PARSER;
  
  public static final int RULES_FIELD_NUMBER = 1;
  
  private int bitField0_;
  
  private boolean fullyDecodeReservedExpansion_;
  
  private Internal.ProtobufList<HttpRule> rules_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllRules(Iterable<? extends HttpRule> paramIterable) {
    ensureRulesIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.rules_);
  }
  
  private void addRules(int paramInt, HttpRule.Builder paramBuilder) {
    ensureRulesIsMutable();
    this.rules_.add(paramInt, paramBuilder.build());
  }
  
  private void addRules(int paramInt, HttpRule paramHttpRule) {
    if (paramHttpRule != null) {
      ensureRulesIsMutable();
      this.rules_.add(paramInt, paramHttpRule);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addRules(HttpRule.Builder paramBuilder) {
    ensureRulesIsMutable();
    this.rules_.add(paramBuilder.build());
  }
  
  private void addRules(HttpRule paramHttpRule) {
    if (paramHttpRule != null) {
      ensureRulesIsMutable();
      this.rules_.add(paramHttpRule);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearFullyDecodeReservedExpansion() {
    this.fullyDecodeReservedExpansion_ = false;
  }
  
  private void clearRules() {
    this.rules_ = emptyProtobufList();
  }
  
  private void ensureRulesIsMutable() {
    if (!this.rules_.isModifiable())
      this.rules_ = GeneratedMessageLite.mutableCopy(this.rules_); 
  }
  
  public static Http getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Http paramHttp) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramHttp);
  }
  
  public static Http parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Http)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Http parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Http)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Http parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Http)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Http parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Http)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Http parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Http)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Http parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Http)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Http parseFrom(InputStream paramInputStream) throws IOException {
    return (Http)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Http parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Http)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Http parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Http)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Http parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Http)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Http> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeRules(int paramInt) {
    ensureRulesIsMutable();
    this.rules_.remove(paramInt);
  }
  
  private void setFullyDecodeReservedExpansion(boolean paramBoolean) {
    this.fullyDecodeReservedExpansion_ = paramBoolean;
  }
  
  private void setRules(int paramInt, HttpRule.Builder paramBuilder) {
    ensureRulesIsMutable();
    this.rules_.set(paramInt, paramBuilder.build());
  }
  
  private void setRules(int paramInt, HttpRule paramHttpRule) {
    if (paramHttpRule != null) {
      ensureRulesIsMutable();
      this.rules_.set(paramInt, paramHttpRule);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/Http$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 390, 2 -> 386, 3 -> 375, 4 -> 366, 5 -> 286, 6 -> 110, 7 -> 282, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/api/Http.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/api/Http
    //   72: monitorenter
    //   73: getstatic com/google/api/Http.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/api/Http.DEFAULT_INSTANCE : Lcom/google/api/Http;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/api/Http.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/api/Http
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/api/Http
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/api/Http.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 282
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 226
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 179
    //   146: iload #5
    //   148: bipush #16
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
    //   170: invokevirtual readBool : ()Z
    //   173: putfield fullyDecodeReservedExpansion_ : Z
    //   176: goto -> 123
    //   179: aload_0
    //   180: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   183: invokeinterface isModifiable : ()Z
    //   188: ifne -> 202
    //   191: aload_0
    //   192: aload_0
    //   193: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   196: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   199: putfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   202: aload_0
    //   203: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   206: aload_1
    //   207: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   210: aload_2
    //   211: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   214: checkcast com/google/api/HttpRule
    //   217: invokeinterface add : (Ljava/lang/Object;)Z
    //   222: pop
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
    //   282: getstatic com/google/api/Http.DEFAULT_INSTANCE : Lcom/google/api/Http;
    //   285: areturn
    //   286: aload_2
    //   287: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   290: astore_1
    //   291: aload_3
    //   292: checkcast com/google/api/Http
    //   295: astore_2
    //   296: aload_0
    //   297: aload_1
    //   298: aload_0
    //   299: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   302: aload_2
    //   303: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   306: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   311: putfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   314: aload_0
    //   315: getfield fullyDecodeReservedExpansion_ : Z
    //   318: istore #6
    //   320: aload_2
    //   321: getfield fullyDecodeReservedExpansion_ : Z
    //   324: istore #7
    //   326: aload_0
    //   327: aload_1
    //   328: iload #6
    //   330: iload #6
    //   332: iload #7
    //   334: iload #7
    //   336: invokeinterface visitBoolean : (ZZZZ)Z
    //   341: putfield fullyDecodeReservedExpansion_ : Z
    //   344: aload_1
    //   345: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   348: if_acmpne -> 364
    //   351: aload_0
    //   352: aload_0
    //   353: getfield bitField0_ : I
    //   356: aload_2
    //   357: getfield bitField0_ : I
    //   360: ior
    //   361: putfield bitField0_ : I
    //   364: aload_0
    //   365: areturn
    //   366: new com/google/api/Http$Builder
    //   369: dup
    //   370: aconst_null
    //   371: invokespecial <init> : (Lcom/google/api/Http$1;)V
    //   374: areturn
    //   375: aload_0
    //   376: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   379: invokeinterface makeImmutable : ()V
    //   384: aconst_null
    //   385: areturn
    //   386: getstatic com/google/api/Http.DEFAULT_INSTANCE : Lcom/google/api/Http;
    //   389: areturn
    //   390: new com/google/api/Http
    //   393: dup
    //   394: invokespecial <init> : ()V
    //   397: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	264	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	236	java/io/IOException
    //   128	134	232	finally
    //   153	162	264	com/google/protobuf/InvalidProtocolBufferException
    //   153	162	236	java/io/IOException
    //   153	162	232	finally
    //   168	176	264	com/google/protobuf/InvalidProtocolBufferException
    //   168	176	236	java/io/IOException
    //   168	176	232	finally
    //   179	202	264	com/google/protobuf/InvalidProtocolBufferException
    //   179	202	236	java/io/IOException
    //   179	202	232	finally
    //   202	223	264	com/google/protobuf/InvalidProtocolBufferException
    //   202	223	236	java/io/IOException
    //   202	223	232	finally
    //   237	264	232	finally
    //   265	280	232	finally
  }
  
  public boolean getFullyDecodeReservedExpansion() {
    return this.fullyDecodeReservedExpansion_;
  }
  
  public HttpRule getRules(int paramInt) {
    return (HttpRule)this.rules_.get(paramInt);
  }
  
  public int getRulesCount() {
    return this.rules_.size();
  }
  
  public List<HttpRule> getRulesList() {
    return (List<HttpRule>)this.rules_;
  }
  
  public HttpRuleOrBuilder getRulesOrBuilder(int paramInt) {
    return (HttpRuleOrBuilder)this.rules_.get(paramInt);
  }
  
  public List<? extends HttpRuleOrBuilder> getRulesOrBuilderList() {
    return (List)this.rules_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    i = 0;
    while (j < this.rules_.size()) {
      i += CodedOutputStream.computeMessageSize(1, (MessageLite)this.rules_.get(j));
      j++;
    } 
    boolean bool = this.fullyDecodeReservedExpansion_;
    j = i;
    if (bool)
      j = i + CodedOutputStream.computeBoolSize(2, bool); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (byte b = 0; b < this.rules_.size(); b++)
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.rules_.get(b)); 
    boolean bool = this.fullyDecodeReservedExpansion_;
    if (bool)
      paramCodedOutputStream.writeBool(2, bool); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Http, Builder> implements HttpOrBuilder {
    private Builder() {
      super(Http.DEFAULT_INSTANCE);
    }
    
    public Builder addAllRules(Iterable<? extends HttpRule> param1Iterable) {
      copyOnWrite();
      ((Http)this.instance).addAllRules(param1Iterable);
      return this;
    }
    
    public Builder addRules(int param1Int, HttpRule.Builder param1Builder) {
      copyOnWrite();
      ((Http)this.instance).addRules(param1Int, param1Builder);
      return this;
    }
    
    public Builder addRules(int param1Int, HttpRule param1HttpRule) {
      copyOnWrite();
      ((Http)this.instance).addRules(param1Int, param1HttpRule);
      return this;
    }
    
    public Builder addRules(HttpRule.Builder param1Builder) {
      copyOnWrite();
      ((Http)this.instance).addRules(param1Builder);
      return this;
    }
    
    public Builder addRules(HttpRule param1HttpRule) {
      copyOnWrite();
      ((Http)this.instance).addRules(param1HttpRule);
      return this;
    }
    
    public Builder clearFullyDecodeReservedExpansion() {
      copyOnWrite();
      ((Http)this.instance).clearFullyDecodeReservedExpansion();
      return this;
    }
    
    public Builder clearRules() {
      copyOnWrite();
      ((Http)this.instance).clearRules();
      return this;
    }
    
    public boolean getFullyDecodeReservedExpansion() {
      return ((Http)this.instance).getFullyDecodeReservedExpansion();
    }
    
    public HttpRule getRules(int param1Int) {
      return ((Http)this.instance).getRules(param1Int);
    }
    
    public int getRulesCount() {
      return ((Http)this.instance).getRulesCount();
    }
    
    public List<HttpRule> getRulesList() {
      return Collections.unmodifiableList(((Http)this.instance).getRulesList());
    }
    
    public Builder removeRules(int param1Int) {
      copyOnWrite();
      ((Http)this.instance).removeRules(param1Int);
      return this;
    }
    
    public Builder setFullyDecodeReservedExpansion(boolean param1Boolean) {
      copyOnWrite();
      ((Http)this.instance).setFullyDecodeReservedExpansion(param1Boolean);
      return this;
    }
    
    public Builder setRules(int param1Int, HttpRule.Builder param1Builder) {
      copyOnWrite();
      ((Http)this.instance).setRules(param1Int, param1Builder);
      return this;
    }
    
    public Builder setRules(int param1Int, HttpRule param1HttpRule) {
      copyOnWrite();
      ((Http)this.instance).setRules(param1Int, param1HttpRule);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\Http.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */