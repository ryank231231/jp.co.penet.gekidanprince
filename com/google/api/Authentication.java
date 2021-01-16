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

public final class Authentication extends GeneratedMessageLite<Authentication, Authentication.Builder> implements AuthenticationOrBuilder {
  private static final Authentication DEFAULT_INSTANCE = new Authentication();
  
  private static volatile Parser<Authentication> PARSER;
  
  public static final int PROVIDERS_FIELD_NUMBER = 4;
  
  public static final int RULES_FIELD_NUMBER = 3;
  
  private Internal.ProtobufList<AuthProvider> providers_ = emptyProtobufList();
  
  private Internal.ProtobufList<AuthenticationRule> rules_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllProviders(Iterable<? extends AuthProvider> paramIterable) {
    ensureProvidersIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.providers_);
  }
  
  private void addAllRules(Iterable<? extends AuthenticationRule> paramIterable) {
    ensureRulesIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.rules_);
  }
  
  private void addProviders(int paramInt, AuthProvider.Builder paramBuilder) {
    ensureProvidersIsMutable();
    this.providers_.add(paramInt, paramBuilder.build());
  }
  
  private void addProviders(int paramInt, AuthProvider paramAuthProvider) {
    if (paramAuthProvider != null) {
      ensureProvidersIsMutable();
      this.providers_.add(paramInt, paramAuthProvider);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addProviders(AuthProvider.Builder paramBuilder) {
    ensureProvidersIsMutable();
    this.providers_.add(paramBuilder.build());
  }
  
  private void addProviders(AuthProvider paramAuthProvider) {
    if (paramAuthProvider != null) {
      ensureProvidersIsMutable();
      this.providers_.add(paramAuthProvider);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addRules(int paramInt, AuthenticationRule.Builder paramBuilder) {
    ensureRulesIsMutable();
    this.rules_.add(paramInt, paramBuilder.build());
  }
  
  private void addRules(int paramInt, AuthenticationRule paramAuthenticationRule) {
    if (paramAuthenticationRule != null) {
      ensureRulesIsMutable();
      this.rules_.add(paramInt, paramAuthenticationRule);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addRules(AuthenticationRule.Builder paramBuilder) {
    ensureRulesIsMutable();
    this.rules_.add(paramBuilder.build());
  }
  
  private void addRules(AuthenticationRule paramAuthenticationRule) {
    if (paramAuthenticationRule != null) {
      ensureRulesIsMutable();
      this.rules_.add(paramAuthenticationRule);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearProviders() {
    this.providers_ = emptyProtobufList();
  }
  
  private void clearRules() {
    this.rules_ = emptyProtobufList();
  }
  
  private void ensureProvidersIsMutable() {
    if (!this.providers_.isModifiable())
      this.providers_ = GeneratedMessageLite.mutableCopy(this.providers_); 
  }
  
  private void ensureRulesIsMutable() {
    if (!this.rules_.isModifiable())
      this.rules_ = GeneratedMessageLite.mutableCopy(this.rules_); 
  }
  
  public static Authentication getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Authentication paramAuthentication) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramAuthentication);
  }
  
  public static Authentication parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Authentication)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Authentication parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Authentication)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Authentication parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Authentication)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Authentication parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Authentication)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Authentication parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Authentication)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Authentication parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Authentication)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Authentication parseFrom(InputStream paramInputStream) throws IOException {
    return (Authentication)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Authentication parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Authentication)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Authentication parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Authentication)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Authentication parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Authentication)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Authentication> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeProviders(int paramInt) {
    ensureProvidersIsMutable();
    this.providers_.remove(paramInt);
  }
  
  private void removeRules(int paramInt) {
    ensureRulesIsMutable();
    this.rules_.remove(paramInt);
  }
  
  private void setProviders(int paramInt, AuthProvider.Builder paramBuilder) {
    ensureProvidersIsMutable();
    this.providers_.set(paramInt, paramBuilder.build());
  }
  
  private void setProviders(int paramInt, AuthProvider paramAuthProvider) {
    if (paramAuthProvider != null) {
      ensureProvidersIsMutable();
      this.providers_.set(paramInt, paramAuthProvider);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRules(int paramInt, AuthenticationRule.Builder paramBuilder) {
    ensureRulesIsMutable();
    this.rules_.set(paramInt, paramBuilder.build());
  }
  
  private void setRules(int paramInt, AuthenticationRule paramAuthenticationRule) {
    if (paramAuthenticationRule != null) {
      ensureRulesIsMutable();
      this.rules_.set(paramInt, paramAuthenticationRule);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/Authentication$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 407, 2 -> 403, 3 -> 383, 4 -> 374, 5 -> 322, 6 -> 110, 7 -> 318, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/api/Authentication.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/api/Authentication
    //   72: monitorenter
    //   73: getstatic com/google/api/Authentication.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/api/Authentication.DEFAULT_INSTANCE : Lcom/google/api/Authentication;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/api/Authentication.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/api/Authentication
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/api/Authentication
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/api/Authentication.PARSER : Lcom/google/protobuf/Parser;
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
    //   169: getfield providers_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   172: invokeinterface isModifiable : ()Z
    //   177: ifne -> 191
    //   180: aload_0
    //   181: aload_0
    //   182: getfield providers_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   185: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   188: putfield providers_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   191: aload_0
    //   192: getfield providers_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   195: aload_1
    //   196: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   199: aload_2
    //   200: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   203: checkcast com/google/api/AuthProvider
    //   206: invokeinterface add : (Ljava/lang/Object;)Z
    //   211: pop
    //   212: goto -> 123
    //   215: aload_0
    //   216: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   219: invokeinterface isModifiable : ()Z
    //   224: ifne -> 238
    //   227: aload_0
    //   228: aload_0
    //   229: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   232: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   235: putfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   238: aload_0
    //   239: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   242: aload_1
    //   243: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   246: aload_2
    //   247: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   250: checkcast com/google/api/AuthenticationRule
    //   253: invokeinterface add : (Ljava/lang/Object;)Z
    //   258: pop
    //   259: goto -> 123
    //   262: iconst_1
    //   263: istore #4
    //   265: goto -> 123
    //   268: astore_1
    //   269: goto -> 316
    //   272: astore_1
    //   273: new java/lang/RuntimeException
    //   276: astore_3
    //   277: new com/google/protobuf/InvalidProtocolBufferException
    //   280: astore_2
    //   281: aload_2
    //   282: aload_1
    //   283: invokevirtual getMessage : ()Ljava/lang/String;
    //   286: invokespecial <init> : (Ljava/lang/String;)V
    //   289: aload_3
    //   290: aload_2
    //   291: aload_0
    //   292: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   295: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   298: aload_3
    //   299: athrow
    //   300: astore_1
    //   301: new java/lang/RuntimeException
    //   304: astore_2
    //   305: aload_2
    //   306: aload_1
    //   307: aload_0
    //   308: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   311: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   314: aload_2
    //   315: athrow
    //   316: aload_1
    //   317: athrow
    //   318: getstatic com/google/api/Authentication.DEFAULT_INSTANCE : Lcom/google/api/Authentication;
    //   321: areturn
    //   322: aload_2
    //   323: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   326: astore_1
    //   327: aload_3
    //   328: checkcast com/google/api/Authentication
    //   331: astore_2
    //   332: aload_0
    //   333: aload_1
    //   334: aload_0
    //   335: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   338: aload_2
    //   339: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   342: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   347: putfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   350: aload_0
    //   351: aload_1
    //   352: aload_0
    //   353: getfield providers_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   356: aload_2
    //   357: getfield providers_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   360: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   365: putfield providers_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   368: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   371: astore_1
    //   372: aload_0
    //   373: areturn
    //   374: new com/google/api/Authentication$Builder
    //   377: dup
    //   378: aconst_null
    //   379: invokespecial <init> : (Lcom/google/api/Authentication$1;)V
    //   382: areturn
    //   383: aload_0
    //   384: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   387: invokeinterface makeImmutable : ()V
    //   392: aload_0
    //   393: getfield providers_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   396: invokeinterface makeImmutable : ()V
    //   401: aconst_null
    //   402: areturn
    //   403: getstatic com/google/api/Authentication.DEFAULT_INSTANCE : Lcom/google/api/Authentication;
    //   406: areturn
    //   407: new com/google/api/Authentication
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
  
  public AuthProvider getProviders(int paramInt) {
    return (AuthProvider)this.providers_.get(paramInt);
  }
  
  public int getProvidersCount() {
    return this.providers_.size();
  }
  
  public List<AuthProvider> getProvidersList() {
    return (List<AuthProvider>)this.providers_;
  }
  
  public AuthProviderOrBuilder getProvidersOrBuilder(int paramInt) {
    return (AuthProviderOrBuilder)this.providers_.get(paramInt);
  }
  
  public List<? extends AuthProviderOrBuilder> getProvidersOrBuilderList() {
    return (List)this.providers_;
  }
  
  public AuthenticationRule getRules(int paramInt) {
    return (AuthenticationRule)this.rules_.get(paramInt);
  }
  
  public int getRulesCount() {
    return this.rules_.size();
  }
  
  public List<AuthenticationRule> getRulesList() {
    return (List<AuthenticationRule>)this.rules_;
  }
  
  public AuthenticationRuleOrBuilder getRulesOrBuilder(int paramInt) {
    return (AuthenticationRuleOrBuilder)this.rules_.get(paramInt);
  }
  
  public List<? extends AuthenticationRuleOrBuilder> getRulesOrBuilderList() {
    return (List)this.rules_;
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
      if (b2 < this.rules_.size()) {
        i += CodedOutputStream.computeMessageSize(3, (MessageLite)this.rules_.get(b2));
        b2++;
        continue;
      } 
      break;
    } 
    while (b3 < this.providers_.size()) {
      j += CodedOutputStream.computeMessageSize(4, (MessageLite)this.providers_.get(b3));
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
      if (b2 < this.rules_.size()) {
        paramCodedOutputStream.writeMessage(3, (MessageLite)this.rules_.get(b2));
        b2++;
        continue;
      } 
      break;
    } 
    while (b3 < this.providers_.size()) {
      paramCodedOutputStream.writeMessage(4, (MessageLite)this.providers_.get(b3));
      b3++;
    } 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Authentication, Builder> implements AuthenticationOrBuilder {
    private Builder() {
      super(Authentication.DEFAULT_INSTANCE);
    }
    
    public Builder addAllProviders(Iterable<? extends AuthProvider> param1Iterable) {
      copyOnWrite();
      ((Authentication)this.instance).addAllProviders(param1Iterable);
      return this;
    }
    
    public Builder addAllRules(Iterable<? extends AuthenticationRule> param1Iterable) {
      copyOnWrite();
      ((Authentication)this.instance).addAllRules(param1Iterable);
      return this;
    }
    
    public Builder addProviders(int param1Int, AuthProvider.Builder param1Builder) {
      copyOnWrite();
      ((Authentication)this.instance).addProviders(param1Int, param1Builder);
      return this;
    }
    
    public Builder addProviders(int param1Int, AuthProvider param1AuthProvider) {
      copyOnWrite();
      ((Authentication)this.instance).addProviders(param1Int, param1AuthProvider);
      return this;
    }
    
    public Builder addProviders(AuthProvider.Builder param1Builder) {
      copyOnWrite();
      ((Authentication)this.instance).addProviders(param1Builder);
      return this;
    }
    
    public Builder addProviders(AuthProvider param1AuthProvider) {
      copyOnWrite();
      ((Authentication)this.instance).addProviders(param1AuthProvider);
      return this;
    }
    
    public Builder addRules(int param1Int, AuthenticationRule.Builder param1Builder) {
      copyOnWrite();
      ((Authentication)this.instance).addRules(param1Int, param1Builder);
      return this;
    }
    
    public Builder addRules(int param1Int, AuthenticationRule param1AuthenticationRule) {
      copyOnWrite();
      ((Authentication)this.instance).addRules(param1Int, param1AuthenticationRule);
      return this;
    }
    
    public Builder addRules(AuthenticationRule.Builder param1Builder) {
      copyOnWrite();
      ((Authentication)this.instance).addRules(param1Builder);
      return this;
    }
    
    public Builder addRules(AuthenticationRule param1AuthenticationRule) {
      copyOnWrite();
      ((Authentication)this.instance).addRules(param1AuthenticationRule);
      return this;
    }
    
    public Builder clearProviders() {
      copyOnWrite();
      ((Authentication)this.instance).clearProviders();
      return this;
    }
    
    public Builder clearRules() {
      copyOnWrite();
      ((Authentication)this.instance).clearRules();
      return this;
    }
    
    public AuthProvider getProviders(int param1Int) {
      return ((Authentication)this.instance).getProviders(param1Int);
    }
    
    public int getProvidersCount() {
      return ((Authentication)this.instance).getProvidersCount();
    }
    
    public List<AuthProvider> getProvidersList() {
      return Collections.unmodifiableList(((Authentication)this.instance).getProvidersList());
    }
    
    public AuthenticationRule getRules(int param1Int) {
      return ((Authentication)this.instance).getRules(param1Int);
    }
    
    public int getRulesCount() {
      return ((Authentication)this.instance).getRulesCount();
    }
    
    public List<AuthenticationRule> getRulesList() {
      return Collections.unmodifiableList(((Authentication)this.instance).getRulesList());
    }
    
    public Builder removeProviders(int param1Int) {
      copyOnWrite();
      ((Authentication)this.instance).removeProviders(param1Int);
      return this;
    }
    
    public Builder removeRules(int param1Int) {
      copyOnWrite();
      ((Authentication)this.instance).removeRules(param1Int);
      return this;
    }
    
    public Builder setProviders(int param1Int, AuthProvider.Builder param1Builder) {
      copyOnWrite();
      ((Authentication)this.instance).setProviders(param1Int, param1Builder);
      return this;
    }
    
    public Builder setProviders(int param1Int, AuthProvider param1AuthProvider) {
      copyOnWrite();
      ((Authentication)this.instance).setProviders(param1Int, param1AuthProvider);
      return this;
    }
    
    public Builder setRules(int param1Int, AuthenticationRule.Builder param1Builder) {
      copyOnWrite();
      ((Authentication)this.instance).setRules(param1Int, param1Builder);
      return this;
    }
    
    public Builder setRules(int param1Int, AuthenticationRule param1AuthenticationRule) {
      copyOnWrite();
      ((Authentication)this.instance).setRules(param1Int, param1AuthenticationRule);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\Authentication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */