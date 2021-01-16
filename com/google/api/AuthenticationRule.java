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

public final class AuthenticationRule extends GeneratedMessageLite<AuthenticationRule, AuthenticationRule.Builder> implements AuthenticationRuleOrBuilder {
  public static final int ALLOW_WITHOUT_CREDENTIAL_FIELD_NUMBER = 5;
  
  private static final AuthenticationRule DEFAULT_INSTANCE = new AuthenticationRule();
  
  public static final int OAUTH_FIELD_NUMBER = 2;
  
  private static volatile Parser<AuthenticationRule> PARSER;
  
  public static final int REQUIREMENTS_FIELD_NUMBER = 7;
  
  public static final int SELECTOR_FIELD_NUMBER = 1;
  
  private boolean allowWithoutCredential_;
  
  private int bitField0_;
  
  private OAuthRequirements oauth_;
  
  private Internal.ProtobufList<AuthRequirement> requirements_ = emptyProtobufList();
  
  private String selector_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllRequirements(Iterable<? extends AuthRequirement> paramIterable) {
    ensureRequirementsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.requirements_);
  }
  
  private void addRequirements(int paramInt, AuthRequirement.Builder paramBuilder) {
    ensureRequirementsIsMutable();
    this.requirements_.add(paramInt, paramBuilder.build());
  }
  
  private void addRequirements(int paramInt, AuthRequirement paramAuthRequirement) {
    if (paramAuthRequirement != null) {
      ensureRequirementsIsMutable();
      this.requirements_.add(paramInt, paramAuthRequirement);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addRequirements(AuthRequirement.Builder paramBuilder) {
    ensureRequirementsIsMutable();
    this.requirements_.add(paramBuilder.build());
  }
  
  private void addRequirements(AuthRequirement paramAuthRequirement) {
    if (paramAuthRequirement != null) {
      ensureRequirementsIsMutable();
      this.requirements_.add(paramAuthRequirement);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearAllowWithoutCredential() {
    this.allowWithoutCredential_ = false;
  }
  
  private void clearOauth() {
    this.oauth_ = null;
  }
  
  private void clearRequirements() {
    this.requirements_ = emptyProtobufList();
  }
  
  private void clearSelector() {
    this.selector_ = getDefaultInstance().getSelector();
  }
  
  private void ensureRequirementsIsMutable() {
    if (!this.requirements_.isModifiable())
      this.requirements_ = GeneratedMessageLite.mutableCopy(this.requirements_); 
  }
  
  public static AuthenticationRule getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeOauth(OAuthRequirements paramOAuthRequirements) {
    OAuthRequirements oAuthRequirements = this.oauth_;
    if (oAuthRequirements != null && oAuthRequirements != OAuthRequirements.getDefaultInstance()) {
      this.oauth_ = (OAuthRequirements)((OAuthRequirements.Builder)OAuthRequirements.newBuilder(this.oauth_).mergeFrom(paramOAuthRequirements)).buildPartial();
    } else {
      this.oauth_ = paramOAuthRequirements;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(AuthenticationRule paramAuthenticationRule) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramAuthenticationRule);
  }
  
  public static AuthenticationRule parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (AuthenticationRule)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static AuthenticationRule parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthenticationRule)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthenticationRule parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (AuthenticationRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static AuthenticationRule parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuthenticationRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static AuthenticationRule parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (AuthenticationRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static AuthenticationRule parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthenticationRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthenticationRule parseFrom(InputStream paramInputStream) throws IOException {
    return (AuthenticationRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static AuthenticationRule parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthenticationRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthenticationRule parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (AuthenticationRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static AuthenticationRule parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuthenticationRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<AuthenticationRule> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeRequirements(int paramInt) {
    ensureRequirementsIsMutable();
    this.requirements_.remove(paramInt);
  }
  
  private void setAllowWithoutCredential(boolean paramBoolean) {
    this.allowWithoutCredential_ = paramBoolean;
  }
  
  private void setOauth(OAuthRequirements.Builder paramBuilder) {
    this.oauth_ = (OAuthRequirements)paramBuilder.build();
  }
  
  private void setOauth(OAuthRequirements paramOAuthRequirements) {
    if (paramOAuthRequirements != null) {
      this.oauth_ = paramOAuthRequirements;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRequirements(int paramInt, AuthRequirement.Builder paramBuilder) {
    ensureRequirementsIsMutable();
    this.requirements_.set(paramInt, paramBuilder.build());
  }
  
  private void setRequirements(int paramInt, AuthRequirement paramAuthRequirement) {
    if (paramAuthRequirement != null) {
      ensureRequirementsIsMutable();
      this.requirements_.set(paramInt, paramAuthRequirement);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setSelector(String paramString) {
    if (paramString != null) {
      this.selector_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setSelectorBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.selector_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/AuthenticationRule$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 537, 2 -> 533, 3 -> 522, 4 -> 513, 5 -> 376, 6 -> 110, 7 -> 372, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/api/AuthenticationRule.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/api/AuthenticationRule
    //   72: monitorenter
    //   73: getstatic com/google/api/AuthenticationRule.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/api/AuthenticationRule.DEFAULT_INSTANCE : Lcom/google/api/AuthenticationRule;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/api/AuthenticationRule.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/api/AuthenticationRule
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/api/AuthenticationRule
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/api/AuthenticationRule.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 372
    //   128: aload_2
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 316
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 305
    //   146: iload #5
    //   148: bipush #18
    //   150: if_icmpeq -> 240
    //   153: iload #5
    //   155: bipush #40
    //   157: if_icmpeq -> 229
    //   160: iload #5
    //   162: bipush #58
    //   164: if_icmpeq -> 182
    //   167: aload_2
    //   168: iload #5
    //   170: invokevirtual skipField : (I)Z
    //   173: ifne -> 123
    //   176: iconst_1
    //   177: istore #4
    //   179: goto -> 123
    //   182: aload_0
    //   183: getfield requirements_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   186: invokeinterface isModifiable : ()Z
    //   191: ifne -> 205
    //   194: aload_0
    //   195: aload_0
    //   196: getfield requirements_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   199: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   202: putfield requirements_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   205: aload_0
    //   206: getfield requirements_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   209: aload_2
    //   210: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   213: aload_3
    //   214: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   217: checkcast com/google/api/AuthRequirement
    //   220: invokeinterface add : (Ljava/lang/Object;)Z
    //   225: pop
    //   226: goto -> 123
    //   229: aload_0
    //   230: aload_2
    //   231: invokevirtual readBool : ()Z
    //   234: putfield allowWithoutCredential_ : Z
    //   237: goto -> 123
    //   240: aload_0
    //   241: getfield oauth_ : Lcom/google/api/OAuthRequirements;
    //   244: ifnull -> 261
    //   247: aload_0
    //   248: getfield oauth_ : Lcom/google/api/OAuthRequirements;
    //   251: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   254: checkcast com/google/api/OAuthRequirements$Builder
    //   257: astore_1
    //   258: goto -> 263
    //   261: aconst_null
    //   262: astore_1
    //   263: aload_0
    //   264: aload_2
    //   265: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   268: aload_3
    //   269: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   272: checkcast com/google/api/OAuthRequirements
    //   275: putfield oauth_ : Lcom/google/api/OAuthRequirements;
    //   278: aload_1
    //   279: ifnull -> 123
    //   282: aload_1
    //   283: aload_0
    //   284: getfield oauth_ : Lcom/google/api/OAuthRequirements;
    //   287: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   290: pop
    //   291: aload_0
    //   292: aload_1
    //   293: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   296: checkcast com/google/api/OAuthRequirements
    //   299: putfield oauth_ : Lcom/google/api/OAuthRequirements;
    //   302: goto -> 123
    //   305: aload_0
    //   306: aload_2
    //   307: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   310: putfield selector_ : Ljava/lang/String;
    //   313: goto -> 123
    //   316: iconst_1
    //   317: istore #4
    //   319: goto -> 123
    //   322: astore_1
    //   323: goto -> 370
    //   326: astore_1
    //   327: new java/lang/RuntimeException
    //   330: astore_2
    //   331: new com/google/protobuf/InvalidProtocolBufferException
    //   334: astore_3
    //   335: aload_3
    //   336: aload_1
    //   337: invokevirtual getMessage : ()Ljava/lang/String;
    //   340: invokespecial <init> : (Ljava/lang/String;)V
    //   343: aload_2
    //   344: aload_3
    //   345: aload_0
    //   346: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   349: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   352: aload_2
    //   353: athrow
    //   354: astore_2
    //   355: new java/lang/RuntimeException
    //   358: astore_1
    //   359: aload_1
    //   360: aload_2
    //   361: aload_0
    //   362: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   365: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   368: aload_1
    //   369: athrow
    //   370: aload_1
    //   371: athrow
    //   372: getstatic com/google/api/AuthenticationRule.DEFAULT_INSTANCE : Lcom/google/api/AuthenticationRule;
    //   375: areturn
    //   376: aload_2
    //   377: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   380: astore_1
    //   381: aload_3
    //   382: checkcast com/google/api/AuthenticationRule
    //   385: astore_2
    //   386: aload_0
    //   387: aload_1
    //   388: aload_0
    //   389: getfield selector_ : Ljava/lang/String;
    //   392: invokevirtual isEmpty : ()Z
    //   395: iconst_1
    //   396: ixor
    //   397: aload_0
    //   398: getfield selector_ : Ljava/lang/String;
    //   401: iconst_1
    //   402: aload_2
    //   403: getfield selector_ : Ljava/lang/String;
    //   406: invokevirtual isEmpty : ()Z
    //   409: ixor
    //   410: aload_2
    //   411: getfield selector_ : Ljava/lang/String;
    //   414: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   419: putfield selector_ : Ljava/lang/String;
    //   422: aload_0
    //   423: aload_1
    //   424: aload_0
    //   425: getfield oauth_ : Lcom/google/api/OAuthRequirements;
    //   428: aload_2
    //   429: getfield oauth_ : Lcom/google/api/OAuthRequirements;
    //   432: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   437: checkcast com/google/api/OAuthRequirements
    //   440: putfield oauth_ : Lcom/google/api/OAuthRequirements;
    //   443: aload_0
    //   444: getfield allowWithoutCredential_ : Z
    //   447: istore #6
    //   449: aload_2
    //   450: getfield allowWithoutCredential_ : Z
    //   453: istore #7
    //   455: aload_0
    //   456: aload_1
    //   457: iload #6
    //   459: iload #6
    //   461: iload #7
    //   463: iload #7
    //   465: invokeinterface visitBoolean : (ZZZZ)Z
    //   470: putfield allowWithoutCredential_ : Z
    //   473: aload_0
    //   474: aload_1
    //   475: aload_0
    //   476: getfield requirements_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   479: aload_2
    //   480: getfield requirements_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   483: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   488: putfield requirements_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   491: aload_1
    //   492: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   495: if_acmpne -> 511
    //   498: aload_0
    //   499: aload_0
    //   500: getfield bitField0_ : I
    //   503: aload_2
    //   504: getfield bitField0_ : I
    //   507: ior
    //   508: putfield bitField0_ : I
    //   511: aload_0
    //   512: areturn
    //   513: new com/google/api/AuthenticationRule$Builder
    //   516: dup
    //   517: aconst_null
    //   518: invokespecial <init> : (Lcom/google/api/AuthenticationRule$1;)V
    //   521: areturn
    //   522: aload_0
    //   523: getfield requirements_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   526: invokeinterface makeImmutable : ()V
    //   531: aconst_null
    //   532: areturn
    //   533: getstatic com/google/api/AuthenticationRule.DEFAULT_INSTANCE : Lcom/google/api/AuthenticationRule;
    //   536: areturn
    //   537: new com/google/api/AuthenticationRule
    //   540: dup
    //   541: invokespecial <init> : ()V
    //   544: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	354	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	326	java/io/IOException
    //   128	134	322	finally
    //   167	176	354	com/google/protobuf/InvalidProtocolBufferException
    //   167	176	326	java/io/IOException
    //   167	176	322	finally
    //   182	205	354	com/google/protobuf/InvalidProtocolBufferException
    //   182	205	326	java/io/IOException
    //   182	205	322	finally
    //   205	226	354	com/google/protobuf/InvalidProtocolBufferException
    //   205	226	326	java/io/IOException
    //   205	226	322	finally
    //   229	237	354	com/google/protobuf/InvalidProtocolBufferException
    //   229	237	326	java/io/IOException
    //   229	237	322	finally
    //   240	258	354	com/google/protobuf/InvalidProtocolBufferException
    //   240	258	326	java/io/IOException
    //   240	258	322	finally
    //   263	278	354	com/google/protobuf/InvalidProtocolBufferException
    //   263	278	326	java/io/IOException
    //   263	278	322	finally
    //   282	302	354	com/google/protobuf/InvalidProtocolBufferException
    //   282	302	326	java/io/IOException
    //   282	302	322	finally
    //   305	313	354	com/google/protobuf/InvalidProtocolBufferException
    //   305	313	326	java/io/IOException
    //   305	313	322	finally
    //   327	354	322	finally
    //   355	370	322	finally
  }
  
  public boolean getAllowWithoutCredential() {
    return this.allowWithoutCredential_;
  }
  
  public OAuthRequirements getOauth() {
    OAuthRequirements oAuthRequirements1 = this.oauth_;
    OAuthRequirements oAuthRequirements2 = oAuthRequirements1;
    if (oAuthRequirements1 == null)
      oAuthRequirements2 = OAuthRequirements.getDefaultInstance(); 
    return oAuthRequirements2;
  }
  
  public AuthRequirement getRequirements(int paramInt) {
    return (AuthRequirement)this.requirements_.get(paramInt);
  }
  
  public int getRequirementsCount() {
    return this.requirements_.size();
  }
  
  public List<AuthRequirement> getRequirementsList() {
    return (List<AuthRequirement>)this.requirements_;
  }
  
  public AuthRequirementOrBuilder getRequirementsOrBuilder(int paramInt) {
    return (AuthRequirementOrBuilder)this.requirements_.get(paramInt);
  }
  
  public List<? extends AuthRequirementOrBuilder> getRequirementsOrBuilderList() {
    return (List)this.requirements_;
  }
  
  public String getSelector() {
    return this.selector_;
  }
  
  public ByteString getSelectorBytes() {
    return ByteString.copyFromUtf8(this.selector_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    boolean bool = this.selector_.isEmpty();
    byte b1 = 0;
    if (!bool) {
      i = CodedOutputStream.computeStringSize(1, getSelector()) + 0;
    } else {
      i = 0;
    } 
    int j = i;
    if (this.oauth_ != null)
      j = i + CodedOutputStream.computeMessageSize(2, (MessageLite)getOauth()); 
    bool = this.allowWithoutCredential_;
    i = j;
    byte b2 = b1;
    if (bool) {
      i = j + CodedOutputStream.computeBoolSize(5, bool);
      b2 = b1;
    } 
    while (b2 < this.requirements_.size()) {
      i += CodedOutputStream.computeMessageSize(7, (MessageLite)this.requirements_.get(b2));
      b2++;
    } 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public boolean hasOauth() {
    boolean bool;
    if (this.oauth_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.selector_.isEmpty())
      paramCodedOutputStream.writeString(1, getSelector()); 
    if (this.oauth_ != null)
      paramCodedOutputStream.writeMessage(2, (MessageLite)getOauth()); 
    boolean bool = this.allowWithoutCredential_;
    if (bool)
      paramCodedOutputStream.writeBool(5, bool); 
    for (byte b = 0; b < this.requirements_.size(); b++)
      paramCodedOutputStream.writeMessage(7, (MessageLite)this.requirements_.get(b)); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<AuthenticationRule, Builder> implements AuthenticationRuleOrBuilder {
    private Builder() {
      super(AuthenticationRule.DEFAULT_INSTANCE);
    }
    
    public Builder addAllRequirements(Iterable<? extends AuthRequirement> param1Iterable) {
      copyOnWrite();
      ((AuthenticationRule)this.instance).addAllRequirements(param1Iterable);
      return this;
    }
    
    public Builder addRequirements(int param1Int, AuthRequirement.Builder param1Builder) {
      copyOnWrite();
      ((AuthenticationRule)this.instance).addRequirements(param1Int, param1Builder);
      return this;
    }
    
    public Builder addRequirements(int param1Int, AuthRequirement param1AuthRequirement) {
      copyOnWrite();
      ((AuthenticationRule)this.instance).addRequirements(param1Int, param1AuthRequirement);
      return this;
    }
    
    public Builder addRequirements(AuthRequirement.Builder param1Builder) {
      copyOnWrite();
      ((AuthenticationRule)this.instance).addRequirements(param1Builder);
      return this;
    }
    
    public Builder addRequirements(AuthRequirement param1AuthRequirement) {
      copyOnWrite();
      ((AuthenticationRule)this.instance).addRequirements(param1AuthRequirement);
      return this;
    }
    
    public Builder clearAllowWithoutCredential() {
      copyOnWrite();
      ((AuthenticationRule)this.instance).clearAllowWithoutCredential();
      return this;
    }
    
    public Builder clearOauth() {
      copyOnWrite();
      ((AuthenticationRule)this.instance).clearOauth();
      return this;
    }
    
    public Builder clearRequirements() {
      copyOnWrite();
      ((AuthenticationRule)this.instance).clearRequirements();
      return this;
    }
    
    public Builder clearSelector() {
      copyOnWrite();
      ((AuthenticationRule)this.instance).clearSelector();
      return this;
    }
    
    public boolean getAllowWithoutCredential() {
      return ((AuthenticationRule)this.instance).getAllowWithoutCredential();
    }
    
    public OAuthRequirements getOauth() {
      return ((AuthenticationRule)this.instance).getOauth();
    }
    
    public AuthRequirement getRequirements(int param1Int) {
      return ((AuthenticationRule)this.instance).getRequirements(param1Int);
    }
    
    public int getRequirementsCount() {
      return ((AuthenticationRule)this.instance).getRequirementsCount();
    }
    
    public List<AuthRequirement> getRequirementsList() {
      return Collections.unmodifiableList(((AuthenticationRule)this.instance).getRequirementsList());
    }
    
    public String getSelector() {
      return ((AuthenticationRule)this.instance).getSelector();
    }
    
    public ByteString getSelectorBytes() {
      return ((AuthenticationRule)this.instance).getSelectorBytes();
    }
    
    public boolean hasOauth() {
      return ((AuthenticationRule)this.instance).hasOauth();
    }
    
    public Builder mergeOauth(OAuthRequirements param1OAuthRequirements) {
      copyOnWrite();
      ((AuthenticationRule)this.instance).mergeOauth(param1OAuthRequirements);
      return this;
    }
    
    public Builder removeRequirements(int param1Int) {
      copyOnWrite();
      ((AuthenticationRule)this.instance).removeRequirements(param1Int);
      return this;
    }
    
    public Builder setAllowWithoutCredential(boolean param1Boolean) {
      copyOnWrite();
      ((AuthenticationRule)this.instance).setAllowWithoutCredential(param1Boolean);
      return this;
    }
    
    public Builder setOauth(OAuthRequirements.Builder param1Builder) {
      copyOnWrite();
      ((AuthenticationRule)this.instance).setOauth(param1Builder);
      return this;
    }
    
    public Builder setOauth(OAuthRequirements param1OAuthRequirements) {
      copyOnWrite();
      ((AuthenticationRule)this.instance).setOauth(param1OAuthRequirements);
      return this;
    }
    
    public Builder setRequirements(int param1Int, AuthRequirement.Builder param1Builder) {
      copyOnWrite();
      ((AuthenticationRule)this.instance).setRequirements(param1Int, param1Builder);
      return this;
    }
    
    public Builder setRequirements(int param1Int, AuthRequirement param1AuthRequirement) {
      copyOnWrite();
      ((AuthenticationRule)this.instance).setRequirements(param1Int, param1AuthRequirement);
      return this;
    }
    
    public Builder setSelector(String param1String) {
      copyOnWrite();
      ((AuthenticationRule)this.instance).setSelector(param1String);
      return this;
    }
    
    public Builder setSelectorBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((AuthenticationRule)this.instance).setSelectorBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\AuthenticationRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */