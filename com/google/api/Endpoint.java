package com.google.api;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class Endpoint extends GeneratedMessageLite<Endpoint, Endpoint.Builder> implements EndpointOrBuilder {
  public static final int ALIASES_FIELD_NUMBER = 2;
  
  public static final int ALLOW_CORS_FIELD_NUMBER = 5;
  
  public static final int APIS_FIELD_NUMBER = 3;
  
  private static final Endpoint DEFAULT_INSTANCE = new Endpoint();
  
  public static final int FEATURES_FIELD_NUMBER = 4;
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  private static volatile Parser<Endpoint> PARSER;
  
  public static final int TARGET_FIELD_NUMBER = 101;
  
  private Internal.ProtobufList<String> aliases_ = GeneratedMessageLite.emptyProtobufList();
  
  private boolean allowCors_;
  
  private Internal.ProtobufList<String> apis_ = GeneratedMessageLite.emptyProtobufList();
  
  private int bitField0_;
  
  private Internal.ProtobufList<String> features_ = GeneratedMessageLite.emptyProtobufList();
  
  private String name_ = "";
  
  private String target_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAliases(String paramString) {
    if (paramString != null) {
      ensureAliasesIsMutable();
      this.aliases_.add(paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addAliasesBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      ensureAliasesIsMutable();
      this.aliases_.add(paramByteString.toStringUtf8());
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addAllAliases(Iterable<String> paramIterable) {
    ensureAliasesIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.aliases_);
  }
  
  private void addAllApis(Iterable<String> paramIterable) {
    ensureApisIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.apis_);
  }
  
  private void addAllFeatures(Iterable<String> paramIterable) {
    ensureFeaturesIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.features_);
  }
  
  private void addApis(String paramString) {
    if (paramString != null) {
      ensureApisIsMutable();
      this.apis_.add(paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addApisBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      ensureApisIsMutable();
      this.apis_.add(paramByteString.toStringUtf8());
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addFeatures(String paramString) {
    if (paramString != null) {
      ensureFeaturesIsMutable();
      this.features_.add(paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addFeaturesBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      ensureFeaturesIsMutable();
      this.features_.add(paramByteString.toStringUtf8());
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearAliases() {
    this.aliases_ = GeneratedMessageLite.emptyProtobufList();
  }
  
  private void clearAllowCors() {
    this.allowCors_ = false;
  }
  
  private void clearApis() {
    this.apis_ = GeneratedMessageLite.emptyProtobufList();
  }
  
  private void clearFeatures() {
    this.features_ = GeneratedMessageLite.emptyProtobufList();
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearTarget() {
    this.target_ = getDefaultInstance().getTarget();
  }
  
  private void ensureAliasesIsMutable() {
    if (!this.aliases_.isModifiable())
      this.aliases_ = GeneratedMessageLite.mutableCopy(this.aliases_); 
  }
  
  private void ensureApisIsMutable() {
    if (!this.apis_.isModifiable())
      this.apis_ = GeneratedMessageLite.mutableCopy(this.apis_); 
  }
  
  private void ensureFeaturesIsMutable() {
    if (!this.features_.isModifiable())
      this.features_ = GeneratedMessageLite.mutableCopy(this.features_); 
  }
  
  public static Endpoint getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Endpoint paramEndpoint) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramEndpoint);
  }
  
  public static Endpoint parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Endpoint)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Endpoint parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Endpoint)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Endpoint parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Endpoint)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Endpoint parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Endpoint)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Endpoint parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Endpoint)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Endpoint parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Endpoint)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Endpoint parseFrom(InputStream paramInputStream) throws IOException {
    return (Endpoint)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Endpoint parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Endpoint)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Endpoint parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Endpoint)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Endpoint parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Endpoint)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Endpoint> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setAliases(int paramInt, String paramString) {
    if (paramString != null) {
      ensureAliasesIsMutable();
      this.aliases_.set(paramInt, paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setAllowCors(boolean paramBoolean) {
    this.allowCors_ = paramBoolean;
  }
  
  private void setApis(int paramInt, String paramString) {
    if (paramString != null) {
      ensureApisIsMutable();
      this.apis_.set(paramInt, paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setFeatures(int paramInt, String paramString) {
    if (paramString != null) {
      ensureFeaturesIsMutable();
      this.features_.set(paramInt, paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setName(String paramString) {
    if (paramString != null) {
      this.name_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setNameBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.name_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setTarget(String paramString) {
    if (paramString != null) {
      this.target_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setTargetBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.target_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/Endpoint$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 646, 2 -> 642, 3 -> 613, 4 -> 604, 5 -> 416, 6 -> 110, 7 -> 412, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/api/Endpoint.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/api/Endpoint
    //   72: monitorenter
    //   73: getstatic com/google/api/Endpoint.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/api/Endpoint.DEFAULT_INSTANCE : Lcom/google/api/Endpoint;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/api/Endpoint.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/api/Endpoint
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/api/Endpoint
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/api/Endpoint.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 412
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 356
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 345
    //   146: iload #5
    //   148: bipush #18
    //   150: if_icmpeq -> 303
    //   153: iload #5
    //   155: bipush #26
    //   157: if_icmpeq -> 261
    //   160: iload #5
    //   162: bipush #34
    //   164: if_icmpeq -> 219
    //   167: iload #5
    //   169: bipush #40
    //   171: if_icmpeq -> 208
    //   174: iload #5
    //   176: sipush #810
    //   179: if_icmpeq -> 197
    //   182: aload_1
    //   183: iload #5
    //   185: invokevirtual skipField : (I)Z
    //   188: ifne -> 123
    //   191: iconst_1
    //   192: istore #4
    //   194: goto -> 123
    //   197: aload_0
    //   198: aload_1
    //   199: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   202: putfield target_ : Ljava/lang/String;
    //   205: goto -> 123
    //   208: aload_0
    //   209: aload_1
    //   210: invokevirtual readBool : ()Z
    //   213: putfield allowCors_ : Z
    //   216: goto -> 123
    //   219: aload_1
    //   220: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   223: astore_2
    //   224: aload_0
    //   225: getfield features_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   228: invokeinterface isModifiable : ()Z
    //   233: ifne -> 247
    //   236: aload_0
    //   237: aload_0
    //   238: getfield features_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   241: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   244: putfield features_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   247: aload_0
    //   248: getfield features_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   251: aload_2
    //   252: invokeinterface add : (Ljava/lang/Object;)Z
    //   257: pop
    //   258: goto -> 123
    //   261: aload_1
    //   262: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   265: astore_2
    //   266: aload_0
    //   267: getfield apis_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   270: invokeinterface isModifiable : ()Z
    //   275: ifne -> 289
    //   278: aload_0
    //   279: aload_0
    //   280: getfield apis_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   283: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   286: putfield apis_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   289: aload_0
    //   290: getfield apis_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   293: aload_2
    //   294: invokeinterface add : (Ljava/lang/Object;)Z
    //   299: pop
    //   300: goto -> 123
    //   303: aload_1
    //   304: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   307: astore_2
    //   308: aload_0
    //   309: getfield aliases_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   312: invokeinterface isModifiable : ()Z
    //   317: ifne -> 331
    //   320: aload_0
    //   321: aload_0
    //   322: getfield aliases_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   325: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   328: putfield aliases_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   331: aload_0
    //   332: getfield aliases_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   335: aload_2
    //   336: invokeinterface add : (Ljava/lang/Object;)Z
    //   341: pop
    //   342: goto -> 123
    //   345: aload_0
    //   346: aload_1
    //   347: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   350: putfield name_ : Ljava/lang/String;
    //   353: goto -> 123
    //   356: iconst_1
    //   357: istore #4
    //   359: goto -> 123
    //   362: astore_1
    //   363: goto -> 410
    //   366: astore_2
    //   367: new java/lang/RuntimeException
    //   370: astore_3
    //   371: new com/google/protobuf/InvalidProtocolBufferException
    //   374: astore_1
    //   375: aload_1
    //   376: aload_2
    //   377: invokevirtual getMessage : ()Ljava/lang/String;
    //   380: invokespecial <init> : (Ljava/lang/String;)V
    //   383: aload_3
    //   384: aload_1
    //   385: aload_0
    //   386: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   389: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   392: aload_3
    //   393: athrow
    //   394: astore_1
    //   395: new java/lang/RuntimeException
    //   398: astore_2
    //   399: aload_2
    //   400: aload_1
    //   401: aload_0
    //   402: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   405: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   408: aload_2
    //   409: athrow
    //   410: aload_1
    //   411: athrow
    //   412: getstatic com/google/api/Endpoint.DEFAULT_INSTANCE : Lcom/google/api/Endpoint;
    //   415: areturn
    //   416: aload_2
    //   417: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   420: astore_1
    //   421: aload_3
    //   422: checkcast com/google/api/Endpoint
    //   425: astore_2
    //   426: aload_0
    //   427: aload_1
    //   428: aload_0
    //   429: getfield name_ : Ljava/lang/String;
    //   432: invokevirtual isEmpty : ()Z
    //   435: iconst_1
    //   436: ixor
    //   437: aload_0
    //   438: getfield name_ : Ljava/lang/String;
    //   441: aload_2
    //   442: getfield name_ : Ljava/lang/String;
    //   445: invokevirtual isEmpty : ()Z
    //   448: iconst_1
    //   449: ixor
    //   450: aload_2
    //   451: getfield name_ : Ljava/lang/String;
    //   454: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   459: putfield name_ : Ljava/lang/String;
    //   462: aload_0
    //   463: aload_1
    //   464: aload_0
    //   465: getfield aliases_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   468: aload_2
    //   469: getfield aliases_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   472: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   477: putfield aliases_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   480: aload_0
    //   481: aload_1
    //   482: aload_0
    //   483: getfield apis_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   486: aload_2
    //   487: getfield apis_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   490: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   495: putfield apis_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   498: aload_0
    //   499: aload_1
    //   500: aload_0
    //   501: getfield features_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   504: aload_2
    //   505: getfield features_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   508: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   513: putfield features_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   516: aload_0
    //   517: aload_1
    //   518: aload_0
    //   519: getfield target_ : Ljava/lang/String;
    //   522: invokevirtual isEmpty : ()Z
    //   525: iconst_1
    //   526: ixor
    //   527: aload_0
    //   528: getfield target_ : Ljava/lang/String;
    //   531: iconst_1
    //   532: aload_2
    //   533: getfield target_ : Ljava/lang/String;
    //   536: invokevirtual isEmpty : ()Z
    //   539: ixor
    //   540: aload_2
    //   541: getfield target_ : Ljava/lang/String;
    //   544: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   549: putfield target_ : Ljava/lang/String;
    //   552: aload_0
    //   553: getfield allowCors_ : Z
    //   556: istore #6
    //   558: aload_2
    //   559: getfield allowCors_ : Z
    //   562: istore #7
    //   564: aload_0
    //   565: aload_1
    //   566: iload #6
    //   568: iload #6
    //   570: iload #7
    //   572: iload #7
    //   574: invokeinterface visitBoolean : (ZZZZ)Z
    //   579: putfield allowCors_ : Z
    //   582: aload_1
    //   583: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   586: if_acmpne -> 602
    //   589: aload_0
    //   590: aload_0
    //   591: getfield bitField0_ : I
    //   594: aload_2
    //   595: getfield bitField0_ : I
    //   598: ior
    //   599: putfield bitField0_ : I
    //   602: aload_0
    //   603: areturn
    //   604: new com/google/api/Endpoint$Builder
    //   607: dup
    //   608: aconst_null
    //   609: invokespecial <init> : (Lcom/google/api/Endpoint$1;)V
    //   612: areturn
    //   613: aload_0
    //   614: getfield aliases_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   617: invokeinterface makeImmutable : ()V
    //   622: aload_0
    //   623: getfield apis_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   626: invokeinterface makeImmutable : ()V
    //   631: aload_0
    //   632: getfield features_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   635: invokeinterface makeImmutable : ()V
    //   640: aconst_null
    //   641: areturn
    //   642: getstatic com/google/api/Endpoint.DEFAULT_INSTANCE : Lcom/google/api/Endpoint;
    //   645: areturn
    //   646: new com/google/api/Endpoint
    //   649: dup
    //   650: invokespecial <init> : ()V
    //   653: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	394	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	366	java/io/IOException
    //   128	134	362	finally
    //   182	191	394	com/google/protobuf/InvalidProtocolBufferException
    //   182	191	366	java/io/IOException
    //   182	191	362	finally
    //   197	205	394	com/google/protobuf/InvalidProtocolBufferException
    //   197	205	366	java/io/IOException
    //   197	205	362	finally
    //   208	216	394	com/google/protobuf/InvalidProtocolBufferException
    //   208	216	366	java/io/IOException
    //   208	216	362	finally
    //   219	247	394	com/google/protobuf/InvalidProtocolBufferException
    //   219	247	366	java/io/IOException
    //   219	247	362	finally
    //   247	258	394	com/google/protobuf/InvalidProtocolBufferException
    //   247	258	366	java/io/IOException
    //   247	258	362	finally
    //   261	289	394	com/google/protobuf/InvalidProtocolBufferException
    //   261	289	366	java/io/IOException
    //   261	289	362	finally
    //   289	300	394	com/google/protobuf/InvalidProtocolBufferException
    //   289	300	366	java/io/IOException
    //   289	300	362	finally
    //   303	331	394	com/google/protobuf/InvalidProtocolBufferException
    //   303	331	366	java/io/IOException
    //   303	331	362	finally
    //   331	342	394	com/google/protobuf/InvalidProtocolBufferException
    //   331	342	366	java/io/IOException
    //   331	342	362	finally
    //   345	353	394	com/google/protobuf/InvalidProtocolBufferException
    //   345	353	366	java/io/IOException
    //   345	353	362	finally
    //   367	394	362	finally
    //   395	410	362	finally
  }
  
  public String getAliases(int paramInt) {
    return (String)this.aliases_.get(paramInt);
  }
  
  public ByteString getAliasesBytes(int paramInt) {
    return ByteString.copyFromUtf8((String)this.aliases_.get(paramInt));
  }
  
  public int getAliasesCount() {
    return this.aliases_.size();
  }
  
  public List<String> getAliasesList() {
    return (List<String>)this.aliases_;
  }
  
  public boolean getAllowCors() {
    return this.allowCors_;
  }
  
  public String getApis(int paramInt) {
    return (String)this.apis_.get(paramInt);
  }
  
  public ByteString getApisBytes(int paramInt) {
    return ByteString.copyFromUtf8((String)this.apis_.get(paramInt));
  }
  
  public int getApisCount() {
    return this.apis_.size();
  }
  
  public List<String> getApisList() {
    return (List<String>)this.apis_;
  }
  
  public String getFeatures(int paramInt) {
    return (String)this.features_.get(paramInt);
  }
  
  public ByteString getFeaturesBytes(int paramInt) {
    return ByteString.copyFromUtf8((String)this.features_.get(paramInt));
  }
  
  public int getFeaturesCount() {
    return this.features_.size();
  }
  
  public List<String> getFeaturesList() {
    return (List<String>)this.features_;
  }
  
  public String getName() {
    return this.name_;
  }
  
  public ByteString getNameBytes() {
    return ByteString.copyFromUtf8(this.name_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    boolean bool = this.name_.isEmpty();
    boolean bool1 = false;
    if (!bool) {
      i = CodedOutputStream.computeStringSize(1, getName()) + 0;
    } else {
      i = 0;
    } 
    int j = 0;
    int k = 0;
    while (j < this.aliases_.size()) {
      k += CodedOutputStream.computeStringSizeNoTag((String)this.aliases_.get(j));
      j++;
    } 
    int m = getAliasesList().size();
    byte b = 0;
    j = 0;
    while (b < this.apis_.size()) {
      j += CodedOutputStream.computeStringSizeNoTag((String)this.apis_.get(b));
      b++;
    } 
    int n = getApisList().size();
    int i1 = 0;
    for (b = bool1; b < this.features_.size(); b++)
      i1 += CodedOutputStream.computeStringSizeNoTag((String)this.features_.get(b)); 
    k = i + k + m * 1 + j + n * 1 + i1 + getFeaturesList().size() * 1;
    bool = this.allowCors_;
    i = k;
    if (bool)
      i = k + CodedOutputStream.computeBoolSize(5, bool); 
    k = i;
    if (!this.target_.isEmpty())
      k = i + CodedOutputStream.computeStringSize(101, getTarget()); 
    this.memoizedSerializedSize = k;
    return k;
  }
  
  public String getTarget() {
    return this.target_;
  }
  
  public ByteString getTargetBytes() {
    return ByteString.copyFromUtf8(this.target_);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(1, getName()); 
    boolean bool = false;
    byte b1;
    for (b1 = 0; b1 < this.aliases_.size(); b1++)
      paramCodedOutputStream.writeString(2, (String)this.aliases_.get(b1)); 
    byte b2 = 0;
    while (true) {
      b1 = bool;
      if (b2 < this.apis_.size()) {
        paramCodedOutputStream.writeString(3, (String)this.apis_.get(b2));
        b2++;
        continue;
      } 
      break;
    } 
    while (b1 < this.features_.size()) {
      paramCodedOutputStream.writeString(4, (String)this.features_.get(b1));
      b1++;
    } 
    boolean bool1 = this.allowCors_;
    if (bool1)
      paramCodedOutputStream.writeBool(5, bool1); 
    if (!this.target_.isEmpty())
      paramCodedOutputStream.writeString(101, getTarget()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Endpoint, Builder> implements EndpointOrBuilder {
    private Builder() {
      super(Endpoint.DEFAULT_INSTANCE);
    }
    
    public Builder addAliases(String param1String) {
      copyOnWrite();
      ((Endpoint)this.instance).addAliases(param1String);
      return this;
    }
    
    public Builder addAliasesBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Endpoint)this.instance).addAliasesBytes(param1ByteString);
      return this;
    }
    
    public Builder addAllAliases(Iterable<String> param1Iterable) {
      copyOnWrite();
      ((Endpoint)this.instance).addAllAliases(param1Iterable);
      return this;
    }
    
    public Builder addAllApis(Iterable<String> param1Iterable) {
      copyOnWrite();
      ((Endpoint)this.instance).addAllApis(param1Iterable);
      return this;
    }
    
    public Builder addAllFeatures(Iterable<String> param1Iterable) {
      copyOnWrite();
      ((Endpoint)this.instance).addAllFeatures(param1Iterable);
      return this;
    }
    
    public Builder addApis(String param1String) {
      copyOnWrite();
      ((Endpoint)this.instance).addApis(param1String);
      return this;
    }
    
    public Builder addApisBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Endpoint)this.instance).addApisBytes(param1ByteString);
      return this;
    }
    
    public Builder addFeatures(String param1String) {
      copyOnWrite();
      ((Endpoint)this.instance).addFeatures(param1String);
      return this;
    }
    
    public Builder addFeaturesBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Endpoint)this.instance).addFeaturesBytes(param1ByteString);
      return this;
    }
    
    public Builder clearAliases() {
      copyOnWrite();
      ((Endpoint)this.instance).clearAliases();
      return this;
    }
    
    public Builder clearAllowCors() {
      copyOnWrite();
      ((Endpoint)this.instance).clearAllowCors();
      return this;
    }
    
    public Builder clearApis() {
      copyOnWrite();
      ((Endpoint)this.instance).clearApis();
      return this;
    }
    
    public Builder clearFeatures() {
      copyOnWrite();
      ((Endpoint)this.instance).clearFeatures();
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      ((Endpoint)this.instance).clearName();
      return this;
    }
    
    public Builder clearTarget() {
      copyOnWrite();
      ((Endpoint)this.instance).clearTarget();
      return this;
    }
    
    public String getAliases(int param1Int) {
      return ((Endpoint)this.instance).getAliases(param1Int);
    }
    
    public ByteString getAliasesBytes(int param1Int) {
      return ((Endpoint)this.instance).getAliasesBytes(param1Int);
    }
    
    public int getAliasesCount() {
      return ((Endpoint)this.instance).getAliasesCount();
    }
    
    public List<String> getAliasesList() {
      return Collections.unmodifiableList(((Endpoint)this.instance).getAliasesList());
    }
    
    public boolean getAllowCors() {
      return ((Endpoint)this.instance).getAllowCors();
    }
    
    public String getApis(int param1Int) {
      return ((Endpoint)this.instance).getApis(param1Int);
    }
    
    public ByteString getApisBytes(int param1Int) {
      return ((Endpoint)this.instance).getApisBytes(param1Int);
    }
    
    public int getApisCount() {
      return ((Endpoint)this.instance).getApisCount();
    }
    
    public List<String> getApisList() {
      return Collections.unmodifiableList(((Endpoint)this.instance).getApisList());
    }
    
    public String getFeatures(int param1Int) {
      return ((Endpoint)this.instance).getFeatures(param1Int);
    }
    
    public ByteString getFeaturesBytes(int param1Int) {
      return ((Endpoint)this.instance).getFeaturesBytes(param1Int);
    }
    
    public int getFeaturesCount() {
      return ((Endpoint)this.instance).getFeaturesCount();
    }
    
    public List<String> getFeaturesList() {
      return Collections.unmodifiableList(((Endpoint)this.instance).getFeaturesList());
    }
    
    public String getName() {
      return ((Endpoint)this.instance).getName();
    }
    
    public ByteString getNameBytes() {
      return ((Endpoint)this.instance).getNameBytes();
    }
    
    public String getTarget() {
      return ((Endpoint)this.instance).getTarget();
    }
    
    public ByteString getTargetBytes() {
      return ((Endpoint)this.instance).getTargetBytes();
    }
    
    public Builder setAliases(int param1Int, String param1String) {
      copyOnWrite();
      ((Endpoint)this.instance).setAliases(param1Int, param1String);
      return this;
    }
    
    public Builder setAllowCors(boolean param1Boolean) {
      copyOnWrite();
      ((Endpoint)this.instance).setAllowCors(param1Boolean);
      return this;
    }
    
    public Builder setApis(int param1Int, String param1String) {
      copyOnWrite();
      ((Endpoint)this.instance).setApis(param1Int, param1String);
      return this;
    }
    
    public Builder setFeatures(int param1Int, String param1String) {
      copyOnWrite();
      ((Endpoint)this.instance).setFeatures(param1Int, param1String);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      ((Endpoint)this.instance).setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Endpoint)this.instance).setNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setTarget(String param1String) {
      copyOnWrite();
      ((Endpoint)this.instance).setTarget(param1String);
      return this;
    }
    
    public Builder setTargetBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Endpoint)this.instance).setTargetBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\Endpoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */