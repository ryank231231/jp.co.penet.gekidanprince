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

public final class HttpRule extends GeneratedMessageLite<HttpRule, HttpRule.Builder> implements HttpRuleOrBuilder {
  public static final int ADDITIONAL_BINDINGS_FIELD_NUMBER = 11;
  
  public static final int BODY_FIELD_NUMBER = 7;
  
  public static final int CUSTOM_FIELD_NUMBER = 8;
  
  private static final HttpRule DEFAULT_INSTANCE = new HttpRule();
  
  public static final int DELETE_FIELD_NUMBER = 5;
  
  public static final int GET_FIELD_NUMBER = 2;
  
  private static volatile Parser<HttpRule> PARSER;
  
  public static final int PATCH_FIELD_NUMBER = 6;
  
  public static final int POST_FIELD_NUMBER = 4;
  
  public static final int PUT_FIELD_NUMBER = 3;
  
  public static final int SELECTOR_FIELD_NUMBER = 1;
  
  private Internal.ProtobufList<HttpRule> additionalBindings_ = emptyProtobufList();
  
  private int bitField0_;
  
  private String body_ = "";
  
  private int patternCase_ = 0;
  
  private Object pattern_;
  
  private String selector_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAdditionalBindings(int paramInt, Builder paramBuilder) {
    ensureAdditionalBindingsIsMutable();
    this.additionalBindings_.add(paramInt, paramBuilder.build());
  }
  
  private void addAdditionalBindings(int paramInt, HttpRule paramHttpRule) {
    if (paramHttpRule != null) {
      ensureAdditionalBindingsIsMutable();
      this.additionalBindings_.add(paramInt, paramHttpRule);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addAdditionalBindings(Builder paramBuilder) {
    ensureAdditionalBindingsIsMutable();
    this.additionalBindings_.add(paramBuilder.build());
  }
  
  private void addAdditionalBindings(HttpRule paramHttpRule) {
    if (paramHttpRule != null) {
      ensureAdditionalBindingsIsMutable();
      this.additionalBindings_.add(paramHttpRule);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addAllAdditionalBindings(Iterable<? extends HttpRule> paramIterable) {
    ensureAdditionalBindingsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.additionalBindings_);
  }
  
  private void clearAdditionalBindings() {
    this.additionalBindings_ = emptyProtobufList();
  }
  
  private void clearBody() {
    this.body_ = getDefaultInstance().getBody();
  }
  
  private void clearCustom() {
    if (this.patternCase_ == 8) {
      this.patternCase_ = 0;
      this.pattern_ = null;
    } 
  }
  
  private void clearDelete() {
    if (this.patternCase_ == 5) {
      this.patternCase_ = 0;
      this.pattern_ = null;
    } 
  }
  
  private void clearGet() {
    if (this.patternCase_ == 2) {
      this.patternCase_ = 0;
      this.pattern_ = null;
    } 
  }
  
  private void clearPatch() {
    if (this.patternCase_ == 6) {
      this.patternCase_ = 0;
      this.pattern_ = null;
    } 
  }
  
  private void clearPattern() {
    this.patternCase_ = 0;
    this.pattern_ = null;
  }
  
  private void clearPost() {
    if (this.patternCase_ == 4) {
      this.patternCase_ = 0;
      this.pattern_ = null;
    } 
  }
  
  private void clearPut() {
    if (this.patternCase_ == 3) {
      this.patternCase_ = 0;
      this.pattern_ = null;
    } 
  }
  
  private void clearSelector() {
    this.selector_ = getDefaultInstance().getSelector();
  }
  
  private void ensureAdditionalBindingsIsMutable() {
    if (!this.additionalBindings_.isModifiable())
      this.additionalBindings_ = GeneratedMessageLite.mutableCopy(this.additionalBindings_); 
  }
  
  public static HttpRule getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeCustom(CustomHttpPattern paramCustomHttpPattern) {
    if (this.patternCase_ == 8 && this.pattern_ != CustomHttpPattern.getDefaultInstance()) {
      this.pattern_ = ((CustomHttpPattern.Builder)CustomHttpPattern.newBuilder((CustomHttpPattern)this.pattern_).mergeFrom(paramCustomHttpPattern)).buildPartial();
    } else {
      this.pattern_ = paramCustomHttpPattern;
    } 
    this.patternCase_ = 8;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(HttpRule paramHttpRule) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramHttpRule);
  }
  
  public static HttpRule parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (HttpRule)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static HttpRule parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (HttpRule)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static HttpRule parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (HttpRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static HttpRule parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (HttpRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static HttpRule parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (HttpRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static HttpRule parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (HttpRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static HttpRule parseFrom(InputStream paramInputStream) throws IOException {
    return (HttpRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static HttpRule parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (HttpRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static HttpRule parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (HttpRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static HttpRule parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (HttpRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<HttpRule> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeAdditionalBindings(int paramInt) {
    ensureAdditionalBindingsIsMutable();
    this.additionalBindings_.remove(paramInt);
  }
  
  private void setAdditionalBindings(int paramInt, Builder paramBuilder) {
    ensureAdditionalBindingsIsMutable();
    this.additionalBindings_.set(paramInt, paramBuilder.build());
  }
  
  private void setAdditionalBindings(int paramInt, HttpRule paramHttpRule) {
    if (paramHttpRule != null) {
      ensureAdditionalBindingsIsMutable();
      this.additionalBindings_.set(paramInt, paramHttpRule);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setBody(String paramString) {
    if (paramString != null) {
      this.body_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setBodyBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.body_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setCustom(CustomHttpPattern.Builder paramBuilder) {
    this.pattern_ = paramBuilder.build();
    this.patternCase_ = 8;
  }
  
  private void setCustom(CustomHttpPattern paramCustomHttpPattern) {
    if (paramCustomHttpPattern != null) {
      this.pattern_ = paramCustomHttpPattern;
      this.patternCase_ = 8;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDelete(String paramString) {
    if (paramString != null) {
      this.patternCase_ = 5;
      this.pattern_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDeleteBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.patternCase_ = 5;
      this.pattern_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setGet(String paramString) {
    if (paramString != null) {
      this.patternCase_ = 2;
      this.pattern_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setGetBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.patternCase_ = 2;
      this.pattern_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setPatch(String paramString) {
    if (paramString != null) {
      this.patternCase_ = 6;
      this.pattern_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setPatchBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.patternCase_ = 6;
      this.pattern_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setPost(String paramString) {
    if (paramString != null) {
      this.patternCase_ = 4;
      this.pattern_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setPostBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.patternCase_ = 4;
      this.pattern_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setPut(String paramString) {
    if (paramString != null) {
      this.patternCase_ = 3;
      this.pattern_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setPutBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.patternCase_ = 3;
      this.pattern_ = paramByteString.toStringUtf8();
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
    //   0: getstatic com/google/api/HttpRule$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
    //   22: iconst_0
    //   23: istore #9
    //   25: iconst_0
    //   26: istore #10
    //   28: iconst_0
    //   29: istore #11
    //   31: iconst_0
    //   32: istore #12
    //   34: iload #4
    //   36: tableswitch default -> 84, 1 -> 1002, 2 -> 998, 3 -> 987, 4 -> 978, 5 -> 535, 6 -> 138, 7 -> 531, 8 -> 92
    //   84: new java/lang/UnsupportedOperationException
    //   87: dup
    //   88: invokespecial <init> : ()V
    //   91: athrow
    //   92: getstatic com/google/api/HttpRule.PARSER : Lcom/google/protobuf/Parser;
    //   95: ifnonnull -> 134
    //   98: ldc com/google/api/HttpRule
    //   100: monitorenter
    //   101: getstatic com/google/api/HttpRule.PARSER : Lcom/google/protobuf/Parser;
    //   104: ifnonnull -> 122
    //   107: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   110: astore_1
    //   111: aload_1
    //   112: getstatic com/google/api/HttpRule.DEFAULT_INSTANCE : Lcom/google/api/HttpRule;
    //   115: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   118: aload_1
    //   119: putstatic com/google/api/HttpRule.PARSER : Lcom/google/protobuf/Parser;
    //   122: ldc com/google/api/HttpRule
    //   124: monitorexit
    //   125: goto -> 134
    //   128: astore_1
    //   129: ldc com/google/api/HttpRule
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    //   134: getstatic com/google/api/HttpRule.PARSER : Lcom/google/protobuf/Parser;
    //   137: areturn
    //   138: aload_2
    //   139: checkcast com/google/protobuf/CodedInputStream
    //   142: astore_2
    //   143: aload_3
    //   144: checkcast com/google/protobuf/ExtensionRegistryLite
    //   147: astore_3
    //   148: iload #12
    //   150: ifne -> 531
    //   153: aload_2
    //   154: invokevirtual readTag : ()I
    //   157: istore #4
    //   159: iload #4
    //   161: ifeq -> 475
    //   164: iload #4
    //   166: bipush #10
    //   168: if_icmpeq -> 464
    //   171: iload #4
    //   173: bipush #18
    //   175: if_icmpeq -> 446
    //   178: iload #4
    //   180: bipush #26
    //   182: if_icmpeq -> 428
    //   185: iload #4
    //   187: bipush #34
    //   189: if_icmpeq -> 410
    //   192: iload #4
    //   194: bipush #42
    //   196: if_icmpeq -> 392
    //   199: iload #4
    //   201: bipush #50
    //   203: if_icmpeq -> 373
    //   206: iload #4
    //   208: bipush #58
    //   210: if_icmpeq -> 362
    //   213: iload #4
    //   215: bipush #66
    //   217: if_icmpeq -> 289
    //   220: iload #4
    //   222: bipush #90
    //   224: if_icmpeq -> 242
    //   227: aload_2
    //   228: iload #4
    //   230: invokevirtual skipField : (I)Z
    //   233: ifne -> 148
    //   236: iconst_1
    //   237: istore #12
    //   239: goto -> 148
    //   242: aload_0
    //   243: getfield additionalBindings_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   246: invokeinterface isModifiable : ()Z
    //   251: ifne -> 265
    //   254: aload_0
    //   255: aload_0
    //   256: getfield additionalBindings_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   259: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   262: putfield additionalBindings_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   265: aload_0
    //   266: getfield additionalBindings_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   269: aload_2
    //   270: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   273: aload_3
    //   274: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   277: checkcast com/google/api/HttpRule
    //   280: invokeinterface add : (Ljava/lang/Object;)Z
    //   285: pop
    //   286: goto -> 148
    //   289: aload_0
    //   290: getfield patternCase_ : I
    //   293: bipush #8
    //   295: if_icmpne -> 315
    //   298: aload_0
    //   299: getfield pattern_ : Ljava/lang/Object;
    //   302: checkcast com/google/api/CustomHttpPattern
    //   305: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   308: checkcast com/google/api/CustomHttpPattern$Builder
    //   311: astore_1
    //   312: goto -> 317
    //   315: aconst_null
    //   316: astore_1
    //   317: aload_0
    //   318: aload_2
    //   319: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   322: aload_3
    //   323: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   326: putfield pattern_ : Ljava/lang/Object;
    //   329: aload_1
    //   330: ifnull -> 353
    //   333: aload_1
    //   334: aload_0
    //   335: getfield pattern_ : Ljava/lang/Object;
    //   338: checkcast com/google/api/CustomHttpPattern
    //   341: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   344: pop
    //   345: aload_0
    //   346: aload_1
    //   347: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   350: putfield pattern_ : Ljava/lang/Object;
    //   353: aload_0
    //   354: bipush #8
    //   356: putfield patternCase_ : I
    //   359: goto -> 148
    //   362: aload_0
    //   363: aload_2
    //   364: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   367: putfield body_ : Ljava/lang/String;
    //   370: goto -> 148
    //   373: aload_2
    //   374: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   377: astore_1
    //   378: aload_0
    //   379: bipush #6
    //   381: putfield patternCase_ : I
    //   384: aload_0
    //   385: aload_1
    //   386: putfield pattern_ : Ljava/lang/Object;
    //   389: goto -> 148
    //   392: aload_2
    //   393: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   396: astore_1
    //   397: aload_0
    //   398: iconst_5
    //   399: putfield patternCase_ : I
    //   402: aload_0
    //   403: aload_1
    //   404: putfield pattern_ : Ljava/lang/Object;
    //   407: goto -> 148
    //   410: aload_2
    //   411: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   414: astore_1
    //   415: aload_0
    //   416: iconst_4
    //   417: putfield patternCase_ : I
    //   420: aload_0
    //   421: aload_1
    //   422: putfield pattern_ : Ljava/lang/Object;
    //   425: goto -> 148
    //   428: aload_2
    //   429: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   432: astore_1
    //   433: aload_0
    //   434: iconst_3
    //   435: putfield patternCase_ : I
    //   438: aload_0
    //   439: aload_1
    //   440: putfield pattern_ : Ljava/lang/Object;
    //   443: goto -> 148
    //   446: aload_2
    //   447: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   450: astore_1
    //   451: aload_0
    //   452: iconst_2
    //   453: putfield patternCase_ : I
    //   456: aload_0
    //   457: aload_1
    //   458: putfield pattern_ : Ljava/lang/Object;
    //   461: goto -> 148
    //   464: aload_0
    //   465: aload_2
    //   466: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   469: putfield selector_ : Ljava/lang/String;
    //   472: goto -> 148
    //   475: iconst_1
    //   476: istore #12
    //   478: goto -> 148
    //   481: astore_1
    //   482: goto -> 529
    //   485: astore_2
    //   486: new java/lang/RuntimeException
    //   489: astore_1
    //   490: new com/google/protobuf/InvalidProtocolBufferException
    //   493: astore_3
    //   494: aload_3
    //   495: aload_2
    //   496: invokevirtual getMessage : ()Ljava/lang/String;
    //   499: invokespecial <init> : (Ljava/lang/String;)V
    //   502: aload_1
    //   503: aload_3
    //   504: aload_0
    //   505: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   508: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   511: aload_1
    //   512: athrow
    //   513: astore_1
    //   514: new java/lang/RuntimeException
    //   517: astore_2
    //   518: aload_2
    //   519: aload_1
    //   520: aload_0
    //   521: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   524: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   527: aload_2
    //   528: athrow
    //   529: aload_1
    //   530: athrow
    //   531: getstatic com/google/api/HttpRule.DEFAULT_INSTANCE : Lcom/google/api/HttpRule;
    //   534: areturn
    //   535: aload_2
    //   536: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   539: astore_1
    //   540: aload_3
    //   541: checkcast com/google/api/HttpRule
    //   544: astore_2
    //   545: aload_0
    //   546: aload_1
    //   547: aload_0
    //   548: getfield selector_ : Ljava/lang/String;
    //   551: invokevirtual isEmpty : ()Z
    //   554: iconst_1
    //   555: ixor
    //   556: aload_0
    //   557: getfield selector_ : Ljava/lang/String;
    //   560: aload_2
    //   561: getfield selector_ : Ljava/lang/String;
    //   564: invokevirtual isEmpty : ()Z
    //   567: iconst_1
    //   568: ixor
    //   569: aload_2
    //   570: getfield selector_ : Ljava/lang/String;
    //   573: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   578: putfield selector_ : Ljava/lang/String;
    //   581: aload_0
    //   582: aload_1
    //   583: aload_0
    //   584: getfield body_ : Ljava/lang/String;
    //   587: invokevirtual isEmpty : ()Z
    //   590: iconst_1
    //   591: ixor
    //   592: aload_0
    //   593: getfield body_ : Ljava/lang/String;
    //   596: aload_2
    //   597: getfield body_ : Ljava/lang/String;
    //   600: invokevirtual isEmpty : ()Z
    //   603: iconst_1
    //   604: ixor
    //   605: aload_2
    //   606: getfield body_ : Ljava/lang/String;
    //   609: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   614: putfield body_ : Ljava/lang/String;
    //   617: aload_0
    //   618: aload_1
    //   619: aload_0
    //   620: getfield additionalBindings_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   623: aload_2
    //   624: getfield additionalBindings_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   627: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   632: putfield additionalBindings_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   635: getstatic com/google/api/HttpRule$1.$SwitchMap$com$google$api$HttpRule$PatternCase : [I
    //   638: aload_2
    //   639: invokevirtual getPatternCase : ()Lcom/google/api/HttpRule$PatternCase;
    //   642: invokevirtual ordinal : ()I
    //   645: iaload
    //   646: tableswitch default -> 688, 1 -> 904, 2 -> 866, 3 -> 828, 4 -> 790, 5 -> 751, 6 -> 712, 7 -> 691
    //   688: goto -> 939
    //   691: aload_0
    //   692: getfield patternCase_ : I
    //   695: ifeq -> 701
    //   698: iconst_1
    //   699: istore #5
    //   701: aload_1
    //   702: iload #5
    //   704: invokeinterface visitOneofNotSet : (Z)V
    //   709: goto -> 939
    //   712: iload #6
    //   714: istore #5
    //   716: aload_0
    //   717: getfield patternCase_ : I
    //   720: bipush #8
    //   722: if_icmpne -> 728
    //   725: iconst_1
    //   726: istore #5
    //   728: aload_0
    //   729: aload_1
    //   730: iload #5
    //   732: aload_0
    //   733: getfield pattern_ : Ljava/lang/Object;
    //   736: aload_2
    //   737: getfield pattern_ : Ljava/lang/Object;
    //   740: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   745: putfield pattern_ : Ljava/lang/Object;
    //   748: goto -> 939
    //   751: iload #7
    //   753: istore #5
    //   755: aload_0
    //   756: getfield patternCase_ : I
    //   759: bipush #6
    //   761: if_icmpne -> 767
    //   764: iconst_1
    //   765: istore #5
    //   767: aload_0
    //   768: aload_1
    //   769: iload #5
    //   771: aload_0
    //   772: getfield pattern_ : Ljava/lang/Object;
    //   775: aload_2
    //   776: getfield pattern_ : Ljava/lang/Object;
    //   779: invokeinterface visitOneofString : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   784: putfield pattern_ : Ljava/lang/Object;
    //   787: goto -> 939
    //   790: iload #8
    //   792: istore #5
    //   794: aload_0
    //   795: getfield patternCase_ : I
    //   798: iconst_5
    //   799: if_icmpne -> 805
    //   802: iconst_1
    //   803: istore #5
    //   805: aload_0
    //   806: aload_1
    //   807: iload #5
    //   809: aload_0
    //   810: getfield pattern_ : Ljava/lang/Object;
    //   813: aload_2
    //   814: getfield pattern_ : Ljava/lang/Object;
    //   817: invokeinterface visitOneofString : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   822: putfield pattern_ : Ljava/lang/Object;
    //   825: goto -> 939
    //   828: iload #9
    //   830: istore #5
    //   832: aload_0
    //   833: getfield patternCase_ : I
    //   836: iconst_4
    //   837: if_icmpne -> 843
    //   840: iconst_1
    //   841: istore #5
    //   843: aload_0
    //   844: aload_1
    //   845: iload #5
    //   847: aload_0
    //   848: getfield pattern_ : Ljava/lang/Object;
    //   851: aload_2
    //   852: getfield pattern_ : Ljava/lang/Object;
    //   855: invokeinterface visitOneofString : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   860: putfield pattern_ : Ljava/lang/Object;
    //   863: goto -> 939
    //   866: iload #10
    //   868: istore #5
    //   870: aload_0
    //   871: getfield patternCase_ : I
    //   874: iconst_3
    //   875: if_icmpne -> 881
    //   878: iconst_1
    //   879: istore #5
    //   881: aload_0
    //   882: aload_1
    //   883: iload #5
    //   885: aload_0
    //   886: getfield pattern_ : Ljava/lang/Object;
    //   889: aload_2
    //   890: getfield pattern_ : Ljava/lang/Object;
    //   893: invokeinterface visitOneofString : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   898: putfield pattern_ : Ljava/lang/Object;
    //   901: goto -> 939
    //   904: iload #11
    //   906: istore #5
    //   908: aload_0
    //   909: getfield patternCase_ : I
    //   912: iconst_2
    //   913: if_icmpne -> 919
    //   916: iconst_1
    //   917: istore #5
    //   919: aload_0
    //   920: aload_1
    //   921: iload #5
    //   923: aload_0
    //   924: getfield pattern_ : Ljava/lang/Object;
    //   927: aload_2
    //   928: getfield pattern_ : Ljava/lang/Object;
    //   931: invokeinterface visitOneofString : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   936: putfield pattern_ : Ljava/lang/Object;
    //   939: aload_1
    //   940: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   943: if_acmpne -> 976
    //   946: aload_2
    //   947: getfield patternCase_ : I
    //   950: istore #12
    //   952: iload #12
    //   954: ifeq -> 963
    //   957: aload_0
    //   958: iload #12
    //   960: putfield patternCase_ : I
    //   963: aload_0
    //   964: aload_0
    //   965: getfield bitField0_ : I
    //   968: aload_2
    //   969: getfield bitField0_ : I
    //   972: ior
    //   973: putfield bitField0_ : I
    //   976: aload_0
    //   977: areturn
    //   978: new com/google/api/HttpRule$Builder
    //   981: dup
    //   982: aconst_null
    //   983: invokespecial <init> : (Lcom/google/api/HttpRule$1;)V
    //   986: areturn
    //   987: aload_0
    //   988: getfield additionalBindings_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   991: invokeinterface makeImmutable : ()V
    //   996: aconst_null
    //   997: areturn
    //   998: getstatic com/google/api/HttpRule.DEFAULT_INSTANCE : Lcom/google/api/HttpRule;
    //   1001: areturn
    //   1002: new com/google/api/HttpRule
    //   1005: dup
    //   1006: invokespecial <init> : ()V
    //   1009: areturn
    // Exception table:
    //   from	to	target	type
    //   101	122	128	finally
    //   122	125	128	finally
    //   129	132	128	finally
    //   153	159	513	com/google/protobuf/InvalidProtocolBufferException
    //   153	159	485	java/io/IOException
    //   153	159	481	finally
    //   227	236	513	com/google/protobuf/InvalidProtocolBufferException
    //   227	236	485	java/io/IOException
    //   227	236	481	finally
    //   242	265	513	com/google/protobuf/InvalidProtocolBufferException
    //   242	265	485	java/io/IOException
    //   242	265	481	finally
    //   265	286	513	com/google/protobuf/InvalidProtocolBufferException
    //   265	286	485	java/io/IOException
    //   265	286	481	finally
    //   289	312	513	com/google/protobuf/InvalidProtocolBufferException
    //   289	312	485	java/io/IOException
    //   289	312	481	finally
    //   317	329	513	com/google/protobuf/InvalidProtocolBufferException
    //   317	329	485	java/io/IOException
    //   317	329	481	finally
    //   333	353	513	com/google/protobuf/InvalidProtocolBufferException
    //   333	353	485	java/io/IOException
    //   333	353	481	finally
    //   353	359	513	com/google/protobuf/InvalidProtocolBufferException
    //   353	359	485	java/io/IOException
    //   353	359	481	finally
    //   362	370	513	com/google/protobuf/InvalidProtocolBufferException
    //   362	370	485	java/io/IOException
    //   362	370	481	finally
    //   373	389	513	com/google/protobuf/InvalidProtocolBufferException
    //   373	389	485	java/io/IOException
    //   373	389	481	finally
    //   392	407	513	com/google/protobuf/InvalidProtocolBufferException
    //   392	407	485	java/io/IOException
    //   392	407	481	finally
    //   410	425	513	com/google/protobuf/InvalidProtocolBufferException
    //   410	425	485	java/io/IOException
    //   410	425	481	finally
    //   428	443	513	com/google/protobuf/InvalidProtocolBufferException
    //   428	443	485	java/io/IOException
    //   428	443	481	finally
    //   446	461	513	com/google/protobuf/InvalidProtocolBufferException
    //   446	461	485	java/io/IOException
    //   446	461	481	finally
    //   464	472	513	com/google/protobuf/InvalidProtocolBufferException
    //   464	472	485	java/io/IOException
    //   464	472	481	finally
    //   486	513	481	finally
    //   514	529	481	finally
  }
  
  public HttpRule getAdditionalBindings(int paramInt) {
    return (HttpRule)this.additionalBindings_.get(paramInt);
  }
  
  public int getAdditionalBindingsCount() {
    return this.additionalBindings_.size();
  }
  
  public List<HttpRule> getAdditionalBindingsList() {
    return (List<HttpRule>)this.additionalBindings_;
  }
  
  public HttpRuleOrBuilder getAdditionalBindingsOrBuilder(int paramInt) {
    return (HttpRuleOrBuilder)this.additionalBindings_.get(paramInt);
  }
  
  public List<? extends HttpRuleOrBuilder> getAdditionalBindingsOrBuilderList() {
    return (List)this.additionalBindings_;
  }
  
  public String getBody() {
    return this.body_;
  }
  
  public ByteString getBodyBytes() {
    return ByteString.copyFromUtf8(this.body_);
  }
  
  public CustomHttpPattern getCustom() {
    return (this.patternCase_ == 8) ? (CustomHttpPattern)this.pattern_ : CustomHttpPattern.getDefaultInstance();
  }
  
  public String getDelete() {
    String str = "";
    if (this.patternCase_ == 5)
      str = (String)this.pattern_; 
    return str;
  }
  
  public ByteString getDeleteBytes() {
    String str = "";
    if (this.patternCase_ == 5)
      str = (String)this.pattern_; 
    return ByteString.copyFromUtf8(str);
  }
  
  public String getGet() {
    String str = "";
    if (this.patternCase_ == 2)
      str = (String)this.pattern_; 
    return str;
  }
  
  public ByteString getGetBytes() {
    String str = "";
    if (this.patternCase_ == 2)
      str = (String)this.pattern_; 
    return ByteString.copyFromUtf8(str);
  }
  
  public String getPatch() {
    String str = "";
    if (this.patternCase_ == 6)
      str = (String)this.pattern_; 
    return str;
  }
  
  public ByteString getPatchBytes() {
    String str = "";
    if (this.patternCase_ == 6)
      str = (String)this.pattern_; 
    return ByteString.copyFromUtf8(str);
  }
  
  public PatternCase getPatternCase() {
    return PatternCase.forNumber(this.patternCase_);
  }
  
  public String getPost() {
    String str = "";
    if (this.patternCase_ == 4)
      str = (String)this.pattern_; 
    return str;
  }
  
  public ByteString getPostBytes() {
    String str = "";
    if (this.patternCase_ == 4)
      str = (String)this.pattern_; 
    return ByteString.copyFromUtf8(str);
  }
  
  public String getPut() {
    String str = "";
    if (this.patternCase_ == 3)
      str = (String)this.pattern_; 
    return str;
  }
  
  public ByteString getPutBytes() {
    String str = "";
    if (this.patternCase_ == 3)
      str = (String)this.pattern_; 
    return ByteString.copyFromUtf8(str);
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
      j = CodedOutputStream.computeStringSize(1, getSelector()) + 0;
    } else {
      j = 0;
    } 
    i = j;
    if (this.patternCase_ == 2)
      i = j + CodedOutputStream.computeStringSize(2, getGet()); 
    int j = i;
    if (this.patternCase_ == 3)
      j = i + CodedOutputStream.computeStringSize(3, getPut()); 
    i = j;
    if (this.patternCase_ == 4)
      i = j + CodedOutputStream.computeStringSize(4, getPost()); 
    j = i;
    if (this.patternCase_ == 5)
      j = i + CodedOutputStream.computeStringSize(5, getDelete()); 
    i = j;
    if (this.patternCase_ == 6)
      i = j + CodedOutputStream.computeStringSize(6, getPatch()); 
    j = i;
    if (!this.body_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(7, getBody()); 
    i = j;
    byte b2 = b1;
    if (this.patternCase_ == 8) {
      i = j + CodedOutputStream.computeMessageSize(8, (MessageLite)this.pattern_);
      b2 = b1;
    } 
    while (b2 < this.additionalBindings_.size()) {
      i += CodedOutputStream.computeMessageSize(11, (MessageLite)this.additionalBindings_.get(b2));
      b2++;
    } 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.selector_.isEmpty())
      paramCodedOutputStream.writeString(1, getSelector()); 
    if (this.patternCase_ == 2)
      paramCodedOutputStream.writeString(2, getGet()); 
    if (this.patternCase_ == 3)
      paramCodedOutputStream.writeString(3, getPut()); 
    if (this.patternCase_ == 4)
      paramCodedOutputStream.writeString(4, getPost()); 
    if (this.patternCase_ == 5)
      paramCodedOutputStream.writeString(5, getDelete()); 
    if (this.patternCase_ == 6)
      paramCodedOutputStream.writeString(6, getPatch()); 
    if (!this.body_.isEmpty())
      paramCodedOutputStream.writeString(7, getBody()); 
    if (this.patternCase_ == 8)
      paramCodedOutputStream.writeMessage(8, (MessageLite)this.pattern_); 
    for (byte b = 0; b < this.additionalBindings_.size(); b++)
      paramCodedOutputStream.writeMessage(11, (MessageLite)this.additionalBindings_.get(b)); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<HttpRule, Builder> implements HttpRuleOrBuilder {
    private Builder() {
      super(HttpRule.DEFAULT_INSTANCE);
    }
    
    public Builder addAdditionalBindings(int param1Int, Builder param1Builder) {
      copyOnWrite();
      ((HttpRule)this.instance).addAdditionalBindings(param1Int, param1Builder);
      return this;
    }
    
    public Builder addAdditionalBindings(int param1Int, HttpRule param1HttpRule) {
      copyOnWrite();
      ((HttpRule)this.instance).addAdditionalBindings(param1Int, param1HttpRule);
      return this;
    }
    
    public Builder addAdditionalBindings(Builder param1Builder) {
      copyOnWrite();
      ((HttpRule)this.instance).addAdditionalBindings(param1Builder);
      return this;
    }
    
    public Builder addAdditionalBindings(HttpRule param1HttpRule) {
      copyOnWrite();
      ((HttpRule)this.instance).addAdditionalBindings(param1HttpRule);
      return this;
    }
    
    public Builder addAllAdditionalBindings(Iterable<? extends HttpRule> param1Iterable) {
      copyOnWrite();
      ((HttpRule)this.instance).addAllAdditionalBindings(param1Iterable);
      return this;
    }
    
    public Builder clearAdditionalBindings() {
      copyOnWrite();
      ((HttpRule)this.instance).clearAdditionalBindings();
      return this;
    }
    
    public Builder clearBody() {
      copyOnWrite();
      ((HttpRule)this.instance).clearBody();
      return this;
    }
    
    public Builder clearCustom() {
      copyOnWrite();
      ((HttpRule)this.instance).clearCustom();
      return this;
    }
    
    public Builder clearDelete() {
      copyOnWrite();
      ((HttpRule)this.instance).clearDelete();
      return this;
    }
    
    public Builder clearGet() {
      copyOnWrite();
      ((HttpRule)this.instance).clearGet();
      return this;
    }
    
    public Builder clearPatch() {
      copyOnWrite();
      ((HttpRule)this.instance).clearPatch();
      return this;
    }
    
    public Builder clearPattern() {
      copyOnWrite();
      ((HttpRule)this.instance).clearPattern();
      return this;
    }
    
    public Builder clearPost() {
      copyOnWrite();
      ((HttpRule)this.instance).clearPost();
      return this;
    }
    
    public Builder clearPut() {
      copyOnWrite();
      ((HttpRule)this.instance).clearPut();
      return this;
    }
    
    public Builder clearSelector() {
      copyOnWrite();
      ((HttpRule)this.instance).clearSelector();
      return this;
    }
    
    public HttpRule getAdditionalBindings(int param1Int) {
      return ((HttpRule)this.instance).getAdditionalBindings(param1Int);
    }
    
    public int getAdditionalBindingsCount() {
      return ((HttpRule)this.instance).getAdditionalBindingsCount();
    }
    
    public List<HttpRule> getAdditionalBindingsList() {
      return Collections.unmodifiableList(((HttpRule)this.instance).getAdditionalBindingsList());
    }
    
    public String getBody() {
      return ((HttpRule)this.instance).getBody();
    }
    
    public ByteString getBodyBytes() {
      return ((HttpRule)this.instance).getBodyBytes();
    }
    
    public CustomHttpPattern getCustom() {
      return ((HttpRule)this.instance).getCustom();
    }
    
    public String getDelete() {
      return ((HttpRule)this.instance).getDelete();
    }
    
    public ByteString getDeleteBytes() {
      return ((HttpRule)this.instance).getDeleteBytes();
    }
    
    public String getGet() {
      return ((HttpRule)this.instance).getGet();
    }
    
    public ByteString getGetBytes() {
      return ((HttpRule)this.instance).getGetBytes();
    }
    
    public String getPatch() {
      return ((HttpRule)this.instance).getPatch();
    }
    
    public ByteString getPatchBytes() {
      return ((HttpRule)this.instance).getPatchBytes();
    }
    
    public HttpRule.PatternCase getPatternCase() {
      return ((HttpRule)this.instance).getPatternCase();
    }
    
    public String getPost() {
      return ((HttpRule)this.instance).getPost();
    }
    
    public ByteString getPostBytes() {
      return ((HttpRule)this.instance).getPostBytes();
    }
    
    public String getPut() {
      return ((HttpRule)this.instance).getPut();
    }
    
    public ByteString getPutBytes() {
      return ((HttpRule)this.instance).getPutBytes();
    }
    
    public String getSelector() {
      return ((HttpRule)this.instance).getSelector();
    }
    
    public ByteString getSelectorBytes() {
      return ((HttpRule)this.instance).getSelectorBytes();
    }
    
    public Builder mergeCustom(CustomHttpPattern param1CustomHttpPattern) {
      copyOnWrite();
      ((HttpRule)this.instance).mergeCustom(param1CustomHttpPattern);
      return this;
    }
    
    public Builder removeAdditionalBindings(int param1Int) {
      copyOnWrite();
      ((HttpRule)this.instance).removeAdditionalBindings(param1Int);
      return this;
    }
    
    public Builder setAdditionalBindings(int param1Int, Builder param1Builder) {
      copyOnWrite();
      ((HttpRule)this.instance).setAdditionalBindings(param1Int, param1Builder);
      return this;
    }
    
    public Builder setAdditionalBindings(int param1Int, HttpRule param1HttpRule) {
      copyOnWrite();
      ((HttpRule)this.instance).setAdditionalBindings(param1Int, param1HttpRule);
      return this;
    }
    
    public Builder setBody(String param1String) {
      copyOnWrite();
      ((HttpRule)this.instance).setBody(param1String);
      return this;
    }
    
    public Builder setBodyBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((HttpRule)this.instance).setBodyBytes(param1ByteString);
      return this;
    }
    
    public Builder setCustom(CustomHttpPattern.Builder param1Builder) {
      copyOnWrite();
      ((HttpRule)this.instance).setCustom(param1Builder);
      return this;
    }
    
    public Builder setCustom(CustomHttpPattern param1CustomHttpPattern) {
      copyOnWrite();
      ((HttpRule)this.instance).setCustom(param1CustomHttpPattern);
      return this;
    }
    
    public Builder setDelete(String param1String) {
      copyOnWrite();
      ((HttpRule)this.instance).setDelete(param1String);
      return this;
    }
    
    public Builder setDeleteBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((HttpRule)this.instance).setDeleteBytes(param1ByteString);
      return this;
    }
    
    public Builder setGet(String param1String) {
      copyOnWrite();
      ((HttpRule)this.instance).setGet(param1String);
      return this;
    }
    
    public Builder setGetBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((HttpRule)this.instance).setGetBytes(param1ByteString);
      return this;
    }
    
    public Builder setPatch(String param1String) {
      copyOnWrite();
      ((HttpRule)this.instance).setPatch(param1String);
      return this;
    }
    
    public Builder setPatchBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((HttpRule)this.instance).setPatchBytes(param1ByteString);
      return this;
    }
    
    public Builder setPost(String param1String) {
      copyOnWrite();
      ((HttpRule)this.instance).setPost(param1String);
      return this;
    }
    
    public Builder setPostBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((HttpRule)this.instance).setPostBytes(param1ByteString);
      return this;
    }
    
    public Builder setPut(String param1String) {
      copyOnWrite();
      ((HttpRule)this.instance).setPut(param1String);
      return this;
    }
    
    public Builder setPutBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((HttpRule)this.instance).setPutBytes(param1ByteString);
      return this;
    }
    
    public Builder setSelector(String param1String) {
      copyOnWrite();
      ((HttpRule)this.instance).setSelector(param1String);
      return this;
    }
    
    public Builder setSelectorBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((HttpRule)this.instance).setSelectorBytes(param1ByteString);
      return this;
    }
  }
  
  public enum PatternCase implements Internal.EnumLite {
    CUSTOM,
    DELETE,
    GET(2),
    PATCH(2),
    PATTERN_NOT_SET(2),
    POST(2),
    PUT(3);
    
    private final int value;
    
    static {
      DELETE = new PatternCase("DELETE", 3, 5);
      PATCH = new PatternCase("PATCH", 4, 6);
      CUSTOM = new PatternCase("CUSTOM", 5, 8);
      PATTERN_NOT_SET = new PatternCase("PATTERN_NOT_SET", 6, 0);
      $VALUES = new PatternCase[] { GET, PUT, POST, DELETE, PATCH, CUSTOM, PATTERN_NOT_SET };
    }
    
    PatternCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static PatternCase forNumber(int param1Int) {
      if (param1Int != 0) {
        if (param1Int != 8) {
          switch (param1Int) {
            default:
              return null;
            case 6:
              return PATCH;
            case 5:
              return DELETE;
            case 4:
              return POST;
            case 3:
              return PUT;
            case 2:
              break;
          } 
          return GET;
        } 
        return CUSTOM;
      } 
      return PATTERN_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\HttpRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */