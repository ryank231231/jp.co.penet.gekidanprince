package com.google.logging.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Duration;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class HttpRequest extends GeneratedMessageLite<HttpRequest, HttpRequest.Builder> implements HttpRequestOrBuilder {
  public static final int CACHE_FILL_BYTES_FIELD_NUMBER = 12;
  
  public static final int CACHE_HIT_FIELD_NUMBER = 9;
  
  public static final int CACHE_LOOKUP_FIELD_NUMBER = 11;
  
  public static final int CACHE_VALIDATED_WITH_ORIGIN_SERVER_FIELD_NUMBER = 10;
  
  private static final HttpRequest DEFAULT_INSTANCE = new HttpRequest();
  
  public static final int LATENCY_FIELD_NUMBER = 14;
  
  private static volatile Parser<HttpRequest> PARSER;
  
  public static final int PROTOCOL_FIELD_NUMBER = 15;
  
  public static final int REFERER_FIELD_NUMBER = 8;
  
  public static final int REMOTE_IP_FIELD_NUMBER = 7;
  
  public static final int REQUEST_METHOD_FIELD_NUMBER = 1;
  
  public static final int REQUEST_SIZE_FIELD_NUMBER = 3;
  
  public static final int REQUEST_URL_FIELD_NUMBER = 2;
  
  public static final int RESPONSE_SIZE_FIELD_NUMBER = 5;
  
  public static final int SERVER_IP_FIELD_NUMBER = 13;
  
  public static final int STATUS_FIELD_NUMBER = 4;
  
  public static final int USER_AGENT_FIELD_NUMBER = 6;
  
  private long cacheFillBytes_;
  
  private boolean cacheHit_;
  
  private boolean cacheLookup_;
  
  private boolean cacheValidatedWithOriginServer_;
  
  private Duration latency_;
  
  private String protocol_ = "";
  
  private String referer_ = "";
  
  private String remoteIp_ = "";
  
  private String requestMethod_ = "";
  
  private long requestSize_;
  
  private String requestUrl_ = "";
  
  private long responseSize_;
  
  private String serverIp_ = "";
  
  private int status_;
  
  private String userAgent_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearCacheFillBytes() {
    this.cacheFillBytes_ = 0L;
  }
  
  private void clearCacheHit() {
    this.cacheHit_ = false;
  }
  
  private void clearCacheLookup() {
    this.cacheLookup_ = false;
  }
  
  private void clearCacheValidatedWithOriginServer() {
    this.cacheValidatedWithOriginServer_ = false;
  }
  
  private void clearLatency() {
    this.latency_ = null;
  }
  
  private void clearProtocol() {
    this.protocol_ = getDefaultInstance().getProtocol();
  }
  
  private void clearReferer() {
    this.referer_ = getDefaultInstance().getReferer();
  }
  
  private void clearRemoteIp() {
    this.remoteIp_ = getDefaultInstance().getRemoteIp();
  }
  
  private void clearRequestMethod() {
    this.requestMethod_ = getDefaultInstance().getRequestMethod();
  }
  
  private void clearRequestSize() {
    this.requestSize_ = 0L;
  }
  
  private void clearRequestUrl() {
    this.requestUrl_ = getDefaultInstance().getRequestUrl();
  }
  
  private void clearResponseSize() {
    this.responseSize_ = 0L;
  }
  
  private void clearServerIp() {
    this.serverIp_ = getDefaultInstance().getServerIp();
  }
  
  private void clearStatus() {
    this.status_ = 0;
  }
  
  private void clearUserAgent() {
    this.userAgent_ = getDefaultInstance().getUserAgent();
  }
  
  public static HttpRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeLatency(Duration paramDuration) {
    Duration duration = this.latency_;
    if (duration != null && duration != Duration.getDefaultInstance()) {
      this.latency_ = (Duration)((Duration.Builder)Duration.newBuilder(this.latency_).mergeFrom((GeneratedMessageLite)paramDuration)).buildPartial();
    } else {
      this.latency_ = paramDuration;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(HttpRequest paramHttpRequest) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramHttpRequest);
  }
  
  public static HttpRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (HttpRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static HttpRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (HttpRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static HttpRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (HttpRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static HttpRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (HttpRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static HttpRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (HttpRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static HttpRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (HttpRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static HttpRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (HttpRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static HttpRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (HttpRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static HttpRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (HttpRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static HttpRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (HttpRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<HttpRequest> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setCacheFillBytes(long paramLong) {
    this.cacheFillBytes_ = paramLong;
  }
  
  private void setCacheHit(boolean paramBoolean) {
    this.cacheHit_ = paramBoolean;
  }
  
  private void setCacheLookup(boolean paramBoolean) {
    this.cacheLookup_ = paramBoolean;
  }
  
  private void setCacheValidatedWithOriginServer(boolean paramBoolean) {
    this.cacheValidatedWithOriginServer_ = paramBoolean;
  }
  
  private void setLatency(Duration.Builder paramBuilder) {
    this.latency_ = (Duration)paramBuilder.build();
  }
  
  private void setLatency(Duration paramDuration) {
    if (paramDuration != null) {
      this.latency_ = paramDuration;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setProtocol(String paramString) {
    if (paramString != null) {
      this.protocol_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setProtocolBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.protocol_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setReferer(String paramString) {
    if (paramString != null) {
      this.referer_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRefererBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.referer_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRemoteIp(String paramString) {
    if (paramString != null) {
      this.remoteIp_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRemoteIpBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.remoteIp_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRequestMethod(String paramString) {
    if (paramString != null) {
      this.requestMethod_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRequestMethodBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.requestMethod_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRequestSize(long paramLong) {
    this.requestSize_ = paramLong;
  }
  
  private void setRequestUrl(String paramString) {
    if (paramString != null) {
      this.requestUrl_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRequestUrlBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.requestUrl_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setResponseSize(long paramLong) {
    this.responseSize_ = paramLong;
  }
  
  private void setServerIp(String paramString) {
    if (paramString != null) {
      this.serverIp_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setServerIpBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.serverIp_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setStatus(int paramInt) {
    this.status_ = paramInt;
  }
  
  private void setUserAgent(String paramString) {
    if (paramString != null) {
      this.userAgent_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setUserAgentBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.userAgent_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/logging/type/HttpRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iload #4
    //   15: tableswitch default -> 60, 1 -> 1215, 2 -> 1211, 3 -> 1209, 4 -> 1200, 5 -> 577, 6 -> 114, 7 -> 573, 8 -> 68
    //   60: new java/lang/UnsupportedOperationException
    //   63: dup
    //   64: invokespecial <init> : ()V
    //   67: athrow
    //   68: getstatic com/google/logging/type/HttpRequest.PARSER : Lcom/google/protobuf/Parser;
    //   71: ifnonnull -> 110
    //   74: ldc com/google/logging/type/HttpRequest
    //   76: monitorenter
    //   77: getstatic com/google/logging/type/HttpRequest.PARSER : Lcom/google/protobuf/Parser;
    //   80: ifnonnull -> 98
    //   83: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   86: astore_1
    //   87: aload_1
    //   88: getstatic com/google/logging/type/HttpRequest.DEFAULT_INSTANCE : Lcom/google/logging/type/HttpRequest;
    //   91: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   94: aload_1
    //   95: putstatic com/google/logging/type/HttpRequest.PARSER : Lcom/google/protobuf/Parser;
    //   98: ldc com/google/logging/type/HttpRequest
    //   100: monitorexit
    //   101: goto -> 110
    //   104: astore_1
    //   105: ldc com/google/logging/type/HttpRequest
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    //   110: getstatic com/google/logging/type/HttpRequest.PARSER : Lcom/google/protobuf/Parser;
    //   113: areturn
    //   114: aload_2
    //   115: checkcast com/google/protobuf/CodedInputStream
    //   118: astore_2
    //   119: aload_3
    //   120: checkcast com/google/protobuf/ExtensionRegistryLite
    //   123: astore_3
    //   124: iload #5
    //   126: ifne -> 573
    //   129: aload_2
    //   130: invokevirtual readTag : ()I
    //   133: istore #4
    //   135: iload #4
    //   137: lookupswitch default -> 276, 0 -> 506, 10 -> 495, 18 -> 484, 24 -> 473, 32 -> 462, 40 -> 451, 50 -> 440, 58 -> 429, 66 -> 418, 72 -> 407, 80 -> 396, 88 -> 385, 96 -> 374, 106 -> 363, 114 -> 298, 122 -> 287
    //   276: aload_2
    //   277: iload #4
    //   279: invokevirtual skipField : (I)Z
    //   282: istore #6
    //   284: goto -> 512
    //   287: aload_0
    //   288: aload_2
    //   289: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   292: putfield protocol_ : Ljava/lang/String;
    //   295: goto -> 124
    //   298: aload_0
    //   299: getfield latency_ : Lcom/google/protobuf/Duration;
    //   302: ifnull -> 319
    //   305: aload_0
    //   306: getfield latency_ : Lcom/google/protobuf/Duration;
    //   309: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   312: checkcast com/google/protobuf/Duration$Builder
    //   315: astore_1
    //   316: goto -> 321
    //   319: aconst_null
    //   320: astore_1
    //   321: aload_0
    //   322: aload_2
    //   323: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   326: aload_3
    //   327: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   330: checkcast com/google/protobuf/Duration
    //   333: putfield latency_ : Lcom/google/protobuf/Duration;
    //   336: aload_1
    //   337: ifnull -> 124
    //   340: aload_1
    //   341: aload_0
    //   342: getfield latency_ : Lcom/google/protobuf/Duration;
    //   345: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   348: pop
    //   349: aload_0
    //   350: aload_1
    //   351: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   354: checkcast com/google/protobuf/Duration
    //   357: putfield latency_ : Lcom/google/protobuf/Duration;
    //   360: goto -> 124
    //   363: aload_0
    //   364: aload_2
    //   365: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   368: putfield serverIp_ : Ljava/lang/String;
    //   371: goto -> 124
    //   374: aload_0
    //   375: aload_2
    //   376: invokevirtual readInt64 : ()J
    //   379: putfield cacheFillBytes_ : J
    //   382: goto -> 124
    //   385: aload_0
    //   386: aload_2
    //   387: invokevirtual readBool : ()Z
    //   390: putfield cacheLookup_ : Z
    //   393: goto -> 124
    //   396: aload_0
    //   397: aload_2
    //   398: invokevirtual readBool : ()Z
    //   401: putfield cacheValidatedWithOriginServer_ : Z
    //   404: goto -> 124
    //   407: aload_0
    //   408: aload_2
    //   409: invokevirtual readBool : ()Z
    //   412: putfield cacheHit_ : Z
    //   415: goto -> 124
    //   418: aload_0
    //   419: aload_2
    //   420: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   423: putfield referer_ : Ljava/lang/String;
    //   426: goto -> 124
    //   429: aload_0
    //   430: aload_2
    //   431: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   434: putfield remoteIp_ : Ljava/lang/String;
    //   437: goto -> 124
    //   440: aload_0
    //   441: aload_2
    //   442: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   445: putfield userAgent_ : Ljava/lang/String;
    //   448: goto -> 124
    //   451: aload_0
    //   452: aload_2
    //   453: invokevirtual readInt64 : ()J
    //   456: putfield responseSize_ : J
    //   459: goto -> 124
    //   462: aload_0
    //   463: aload_2
    //   464: invokevirtual readInt32 : ()I
    //   467: putfield status_ : I
    //   470: goto -> 124
    //   473: aload_0
    //   474: aload_2
    //   475: invokevirtual readInt64 : ()J
    //   478: putfield requestSize_ : J
    //   481: goto -> 124
    //   484: aload_0
    //   485: aload_2
    //   486: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   489: putfield requestUrl_ : Ljava/lang/String;
    //   492: goto -> 124
    //   495: aload_0
    //   496: aload_2
    //   497: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   500: putfield requestMethod_ : Ljava/lang/String;
    //   503: goto -> 124
    //   506: iconst_1
    //   507: istore #5
    //   509: goto -> 124
    //   512: iload #6
    //   514: ifne -> 124
    //   517: iconst_1
    //   518: istore #5
    //   520: goto -> 124
    //   523: astore_1
    //   524: goto -> 571
    //   527: astore_2
    //   528: new java/lang/RuntimeException
    //   531: astore_3
    //   532: new com/google/protobuf/InvalidProtocolBufferException
    //   535: astore_1
    //   536: aload_1
    //   537: aload_2
    //   538: invokevirtual getMessage : ()Ljava/lang/String;
    //   541: invokespecial <init> : (Ljava/lang/String;)V
    //   544: aload_3
    //   545: aload_1
    //   546: aload_0
    //   547: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   550: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   553: aload_3
    //   554: athrow
    //   555: astore_2
    //   556: new java/lang/RuntimeException
    //   559: astore_1
    //   560: aload_1
    //   561: aload_2
    //   562: aload_0
    //   563: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   566: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   569: aload_1
    //   570: athrow
    //   571: aload_1
    //   572: athrow
    //   573: getstatic com/google/logging/type/HttpRequest.DEFAULT_INSTANCE : Lcom/google/logging/type/HttpRequest;
    //   576: areturn
    //   577: aload_2
    //   578: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   581: astore_1
    //   582: aload_3
    //   583: checkcast com/google/logging/type/HttpRequest
    //   586: astore_2
    //   587: aload_0
    //   588: aload_1
    //   589: aload_0
    //   590: getfield requestMethod_ : Ljava/lang/String;
    //   593: invokevirtual isEmpty : ()Z
    //   596: iconst_1
    //   597: ixor
    //   598: aload_0
    //   599: getfield requestMethod_ : Ljava/lang/String;
    //   602: aload_2
    //   603: getfield requestMethod_ : Ljava/lang/String;
    //   606: invokevirtual isEmpty : ()Z
    //   609: iconst_1
    //   610: ixor
    //   611: aload_2
    //   612: getfield requestMethod_ : Ljava/lang/String;
    //   615: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   620: putfield requestMethod_ : Ljava/lang/String;
    //   623: aload_0
    //   624: aload_1
    //   625: aload_0
    //   626: getfield requestUrl_ : Ljava/lang/String;
    //   629: invokevirtual isEmpty : ()Z
    //   632: iconst_1
    //   633: ixor
    //   634: aload_0
    //   635: getfield requestUrl_ : Ljava/lang/String;
    //   638: aload_2
    //   639: getfield requestUrl_ : Ljava/lang/String;
    //   642: invokevirtual isEmpty : ()Z
    //   645: iconst_1
    //   646: ixor
    //   647: aload_2
    //   648: getfield requestUrl_ : Ljava/lang/String;
    //   651: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   656: putfield requestUrl_ : Ljava/lang/String;
    //   659: aload_0
    //   660: getfield requestSize_ : J
    //   663: lconst_0
    //   664: lcmp
    //   665: ifeq -> 674
    //   668: iconst_1
    //   669: istore #6
    //   671: goto -> 677
    //   674: iconst_0
    //   675: istore #6
    //   677: aload_0
    //   678: getfield requestSize_ : J
    //   681: lstore #7
    //   683: aload_2
    //   684: getfield requestSize_ : J
    //   687: lconst_0
    //   688: lcmp
    //   689: ifeq -> 698
    //   692: iconst_1
    //   693: istore #9
    //   695: goto -> 701
    //   698: iconst_0
    //   699: istore #9
    //   701: aload_0
    //   702: aload_1
    //   703: iload #6
    //   705: lload #7
    //   707: iload #9
    //   709: aload_2
    //   710: getfield requestSize_ : J
    //   713: invokeinterface visitLong : (ZJZJ)J
    //   718: putfield requestSize_ : J
    //   721: aload_0
    //   722: getfield status_ : I
    //   725: ifeq -> 734
    //   728: iconst_1
    //   729: istore #6
    //   731: goto -> 737
    //   734: iconst_0
    //   735: istore #6
    //   737: aload_0
    //   738: getfield status_ : I
    //   741: istore #5
    //   743: aload_2
    //   744: getfield status_ : I
    //   747: ifeq -> 756
    //   750: iconst_1
    //   751: istore #9
    //   753: goto -> 759
    //   756: iconst_0
    //   757: istore #9
    //   759: aload_0
    //   760: aload_1
    //   761: iload #6
    //   763: iload #5
    //   765: iload #9
    //   767: aload_2
    //   768: getfield status_ : I
    //   771: invokeinterface visitInt : (ZIZI)I
    //   776: putfield status_ : I
    //   779: aload_0
    //   780: getfield responseSize_ : J
    //   783: lconst_0
    //   784: lcmp
    //   785: ifeq -> 794
    //   788: iconst_1
    //   789: istore #6
    //   791: goto -> 797
    //   794: iconst_0
    //   795: istore #6
    //   797: aload_0
    //   798: getfield responseSize_ : J
    //   801: lstore #7
    //   803: aload_2
    //   804: getfield responseSize_ : J
    //   807: lconst_0
    //   808: lcmp
    //   809: ifeq -> 818
    //   812: iconst_1
    //   813: istore #9
    //   815: goto -> 821
    //   818: iconst_0
    //   819: istore #9
    //   821: aload_0
    //   822: aload_1
    //   823: iload #6
    //   825: lload #7
    //   827: iload #9
    //   829: aload_2
    //   830: getfield responseSize_ : J
    //   833: invokeinterface visitLong : (ZJZJ)J
    //   838: putfield responseSize_ : J
    //   841: aload_0
    //   842: aload_1
    //   843: aload_0
    //   844: getfield userAgent_ : Ljava/lang/String;
    //   847: invokevirtual isEmpty : ()Z
    //   850: iconst_1
    //   851: ixor
    //   852: aload_0
    //   853: getfield userAgent_ : Ljava/lang/String;
    //   856: aload_2
    //   857: getfield userAgent_ : Ljava/lang/String;
    //   860: invokevirtual isEmpty : ()Z
    //   863: iconst_1
    //   864: ixor
    //   865: aload_2
    //   866: getfield userAgent_ : Ljava/lang/String;
    //   869: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   874: putfield userAgent_ : Ljava/lang/String;
    //   877: aload_0
    //   878: aload_1
    //   879: aload_0
    //   880: getfield remoteIp_ : Ljava/lang/String;
    //   883: invokevirtual isEmpty : ()Z
    //   886: iconst_1
    //   887: ixor
    //   888: aload_0
    //   889: getfield remoteIp_ : Ljava/lang/String;
    //   892: aload_2
    //   893: getfield remoteIp_ : Ljava/lang/String;
    //   896: invokevirtual isEmpty : ()Z
    //   899: iconst_1
    //   900: ixor
    //   901: aload_2
    //   902: getfield remoteIp_ : Ljava/lang/String;
    //   905: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   910: putfield remoteIp_ : Ljava/lang/String;
    //   913: aload_0
    //   914: aload_1
    //   915: aload_0
    //   916: getfield serverIp_ : Ljava/lang/String;
    //   919: invokevirtual isEmpty : ()Z
    //   922: iconst_1
    //   923: ixor
    //   924: aload_0
    //   925: getfield serverIp_ : Ljava/lang/String;
    //   928: aload_2
    //   929: getfield serverIp_ : Ljava/lang/String;
    //   932: invokevirtual isEmpty : ()Z
    //   935: iconst_1
    //   936: ixor
    //   937: aload_2
    //   938: getfield serverIp_ : Ljava/lang/String;
    //   941: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   946: putfield serverIp_ : Ljava/lang/String;
    //   949: aload_0
    //   950: aload_1
    //   951: aload_0
    //   952: getfield referer_ : Ljava/lang/String;
    //   955: invokevirtual isEmpty : ()Z
    //   958: iconst_1
    //   959: ixor
    //   960: aload_0
    //   961: getfield referer_ : Ljava/lang/String;
    //   964: aload_2
    //   965: getfield referer_ : Ljava/lang/String;
    //   968: invokevirtual isEmpty : ()Z
    //   971: iconst_1
    //   972: ixor
    //   973: aload_2
    //   974: getfield referer_ : Ljava/lang/String;
    //   977: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   982: putfield referer_ : Ljava/lang/String;
    //   985: aload_0
    //   986: aload_1
    //   987: aload_0
    //   988: getfield latency_ : Lcom/google/protobuf/Duration;
    //   991: aload_2
    //   992: getfield latency_ : Lcom/google/protobuf/Duration;
    //   995: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   1000: checkcast com/google/protobuf/Duration
    //   1003: putfield latency_ : Lcom/google/protobuf/Duration;
    //   1006: aload_0
    //   1007: getfield cacheLookup_ : Z
    //   1010: istore #6
    //   1012: aload_2
    //   1013: getfield cacheLookup_ : Z
    //   1016: istore #9
    //   1018: aload_0
    //   1019: aload_1
    //   1020: iload #6
    //   1022: iload #6
    //   1024: iload #9
    //   1026: iload #9
    //   1028: invokeinterface visitBoolean : (ZZZZ)Z
    //   1033: putfield cacheLookup_ : Z
    //   1036: aload_0
    //   1037: getfield cacheHit_ : Z
    //   1040: istore #9
    //   1042: aload_2
    //   1043: getfield cacheHit_ : Z
    //   1046: istore #6
    //   1048: aload_0
    //   1049: aload_1
    //   1050: iload #9
    //   1052: iload #9
    //   1054: iload #6
    //   1056: iload #6
    //   1058: invokeinterface visitBoolean : (ZZZZ)Z
    //   1063: putfield cacheHit_ : Z
    //   1066: aload_0
    //   1067: getfield cacheValidatedWithOriginServer_ : Z
    //   1070: istore #6
    //   1072: aload_2
    //   1073: getfield cacheValidatedWithOriginServer_ : Z
    //   1076: istore #9
    //   1078: aload_0
    //   1079: aload_1
    //   1080: iload #6
    //   1082: iload #6
    //   1084: iload #9
    //   1086: iload #9
    //   1088: invokeinterface visitBoolean : (ZZZZ)Z
    //   1093: putfield cacheValidatedWithOriginServer_ : Z
    //   1096: aload_0
    //   1097: getfield cacheFillBytes_ : J
    //   1100: lconst_0
    //   1101: lcmp
    //   1102: ifeq -> 1111
    //   1105: iconst_1
    //   1106: istore #6
    //   1108: goto -> 1114
    //   1111: iconst_0
    //   1112: istore #6
    //   1114: aload_0
    //   1115: getfield cacheFillBytes_ : J
    //   1118: lstore #7
    //   1120: aload_2
    //   1121: getfield cacheFillBytes_ : J
    //   1124: lconst_0
    //   1125: lcmp
    //   1126: ifeq -> 1135
    //   1129: iconst_1
    //   1130: istore #9
    //   1132: goto -> 1138
    //   1135: iconst_0
    //   1136: istore #9
    //   1138: aload_0
    //   1139: aload_1
    //   1140: iload #6
    //   1142: lload #7
    //   1144: iload #9
    //   1146: aload_2
    //   1147: getfield cacheFillBytes_ : J
    //   1150: invokeinterface visitLong : (ZJZJ)J
    //   1155: putfield cacheFillBytes_ : J
    //   1158: aload_0
    //   1159: aload_1
    //   1160: aload_0
    //   1161: getfield protocol_ : Ljava/lang/String;
    //   1164: invokevirtual isEmpty : ()Z
    //   1167: iconst_1
    //   1168: ixor
    //   1169: aload_0
    //   1170: getfield protocol_ : Ljava/lang/String;
    //   1173: aload_2
    //   1174: getfield protocol_ : Ljava/lang/String;
    //   1177: invokevirtual isEmpty : ()Z
    //   1180: iconst_1
    //   1181: ixor
    //   1182: aload_2
    //   1183: getfield protocol_ : Ljava/lang/String;
    //   1186: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   1191: putfield protocol_ : Ljava/lang/String;
    //   1194: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   1197: astore_1
    //   1198: aload_0
    //   1199: areturn
    //   1200: new com/google/logging/type/HttpRequest$Builder
    //   1203: dup
    //   1204: aconst_null
    //   1205: invokespecial <init> : (Lcom/google/logging/type/HttpRequest$1;)V
    //   1208: areturn
    //   1209: aconst_null
    //   1210: areturn
    //   1211: getstatic com/google/logging/type/HttpRequest.DEFAULT_INSTANCE : Lcom/google/logging/type/HttpRequest;
    //   1214: areturn
    //   1215: new com/google/logging/type/HttpRequest
    //   1218: dup
    //   1219: invokespecial <init> : ()V
    //   1222: areturn
    // Exception table:
    //   from	to	target	type
    //   77	98	104	finally
    //   98	101	104	finally
    //   105	108	104	finally
    //   129	135	555	com/google/protobuf/InvalidProtocolBufferException
    //   129	135	527	java/io/IOException
    //   129	135	523	finally
    //   276	284	555	com/google/protobuf/InvalidProtocolBufferException
    //   276	284	527	java/io/IOException
    //   276	284	523	finally
    //   287	295	555	com/google/protobuf/InvalidProtocolBufferException
    //   287	295	527	java/io/IOException
    //   287	295	523	finally
    //   298	316	555	com/google/protobuf/InvalidProtocolBufferException
    //   298	316	527	java/io/IOException
    //   298	316	523	finally
    //   321	336	555	com/google/protobuf/InvalidProtocolBufferException
    //   321	336	527	java/io/IOException
    //   321	336	523	finally
    //   340	360	555	com/google/protobuf/InvalidProtocolBufferException
    //   340	360	527	java/io/IOException
    //   340	360	523	finally
    //   363	371	555	com/google/protobuf/InvalidProtocolBufferException
    //   363	371	527	java/io/IOException
    //   363	371	523	finally
    //   374	382	555	com/google/protobuf/InvalidProtocolBufferException
    //   374	382	527	java/io/IOException
    //   374	382	523	finally
    //   385	393	555	com/google/protobuf/InvalidProtocolBufferException
    //   385	393	527	java/io/IOException
    //   385	393	523	finally
    //   396	404	555	com/google/protobuf/InvalidProtocolBufferException
    //   396	404	527	java/io/IOException
    //   396	404	523	finally
    //   407	415	555	com/google/protobuf/InvalidProtocolBufferException
    //   407	415	527	java/io/IOException
    //   407	415	523	finally
    //   418	426	555	com/google/protobuf/InvalidProtocolBufferException
    //   418	426	527	java/io/IOException
    //   418	426	523	finally
    //   429	437	555	com/google/protobuf/InvalidProtocolBufferException
    //   429	437	527	java/io/IOException
    //   429	437	523	finally
    //   440	448	555	com/google/protobuf/InvalidProtocolBufferException
    //   440	448	527	java/io/IOException
    //   440	448	523	finally
    //   451	459	555	com/google/protobuf/InvalidProtocolBufferException
    //   451	459	527	java/io/IOException
    //   451	459	523	finally
    //   462	470	555	com/google/protobuf/InvalidProtocolBufferException
    //   462	470	527	java/io/IOException
    //   462	470	523	finally
    //   473	481	555	com/google/protobuf/InvalidProtocolBufferException
    //   473	481	527	java/io/IOException
    //   473	481	523	finally
    //   484	492	555	com/google/protobuf/InvalidProtocolBufferException
    //   484	492	527	java/io/IOException
    //   484	492	523	finally
    //   495	503	555	com/google/protobuf/InvalidProtocolBufferException
    //   495	503	527	java/io/IOException
    //   495	503	523	finally
    //   528	555	523	finally
    //   556	571	523	finally
  }
  
  public long getCacheFillBytes() {
    return this.cacheFillBytes_;
  }
  
  public boolean getCacheHit() {
    return this.cacheHit_;
  }
  
  public boolean getCacheLookup() {
    return this.cacheLookup_;
  }
  
  public boolean getCacheValidatedWithOriginServer() {
    return this.cacheValidatedWithOriginServer_;
  }
  
  public Duration getLatency() {
    Duration duration1 = this.latency_;
    Duration duration2 = duration1;
    if (duration1 == null)
      duration2 = Duration.getDefaultInstance(); 
    return duration2;
  }
  
  public String getProtocol() {
    return this.protocol_;
  }
  
  public ByteString getProtocolBytes() {
    return ByteString.copyFromUtf8(this.protocol_);
  }
  
  public String getReferer() {
    return this.referer_;
  }
  
  public ByteString getRefererBytes() {
    return ByteString.copyFromUtf8(this.referer_);
  }
  
  public String getRemoteIp() {
    return this.remoteIp_;
  }
  
  public ByteString getRemoteIpBytes() {
    return ByteString.copyFromUtf8(this.remoteIp_);
  }
  
  public String getRequestMethod() {
    return this.requestMethod_;
  }
  
  public ByteString getRequestMethodBytes() {
    return ByteString.copyFromUtf8(this.requestMethod_);
  }
  
  public long getRequestSize() {
    return this.requestSize_;
  }
  
  public String getRequestUrl() {
    return this.requestUrl_;
  }
  
  public ByteString getRequestUrlBytes() {
    return ByteString.copyFromUtf8(this.requestUrl_);
  }
  
  public long getResponseSize() {
    return this.responseSize_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!this.requestMethod_.isEmpty())
      j = 0 + CodedOutputStream.computeStringSize(1, getRequestMethod()); 
    i = j;
    if (!this.requestUrl_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(2, getRequestUrl()); 
    long l = this.requestSize_;
    j = i;
    if (l != 0L)
      j = i + CodedOutputStream.computeInt64Size(3, l); 
    int k = this.status_;
    i = j;
    if (k != 0)
      i = j + CodedOutputStream.computeInt32Size(4, k); 
    l = this.responseSize_;
    j = i;
    if (l != 0L)
      j = i + CodedOutputStream.computeInt64Size(5, l); 
    i = j;
    if (!this.userAgent_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(6, getUserAgent()); 
    j = i;
    if (!this.remoteIp_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(7, getRemoteIp()); 
    i = j;
    if (!this.referer_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(8, getReferer()); 
    boolean bool = this.cacheHit_;
    k = i;
    if (bool)
      k = i + CodedOutputStream.computeBoolSize(9, bool); 
    bool = this.cacheValidatedWithOriginServer_;
    j = k;
    if (bool)
      j = k + CodedOutputStream.computeBoolSize(10, bool); 
    bool = this.cacheLookup_;
    i = j;
    if (bool)
      i = j + CodedOutputStream.computeBoolSize(11, bool); 
    l = this.cacheFillBytes_;
    j = i;
    if (l != 0L)
      j = i + CodedOutputStream.computeInt64Size(12, l); 
    i = j;
    if (!this.serverIp_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(13, getServerIp()); 
    j = i;
    if (this.latency_ != null)
      j = i + CodedOutputStream.computeMessageSize(14, (MessageLite)getLatency()); 
    i = j;
    if (!this.protocol_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(15, getProtocol()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public String getServerIp() {
    return this.serverIp_;
  }
  
  public ByteString getServerIpBytes() {
    return ByteString.copyFromUtf8(this.serverIp_);
  }
  
  public int getStatus() {
    return this.status_;
  }
  
  public String getUserAgent() {
    return this.userAgent_;
  }
  
  public ByteString getUserAgentBytes() {
    return ByteString.copyFromUtf8(this.userAgent_);
  }
  
  public boolean hasLatency() {
    boolean bool;
    if (this.latency_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.requestMethod_.isEmpty())
      paramCodedOutputStream.writeString(1, getRequestMethod()); 
    if (!this.requestUrl_.isEmpty())
      paramCodedOutputStream.writeString(2, getRequestUrl()); 
    long l = this.requestSize_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(3, l); 
    int i = this.status_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(4, i); 
    l = this.responseSize_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(5, l); 
    if (!this.userAgent_.isEmpty())
      paramCodedOutputStream.writeString(6, getUserAgent()); 
    if (!this.remoteIp_.isEmpty())
      paramCodedOutputStream.writeString(7, getRemoteIp()); 
    if (!this.referer_.isEmpty())
      paramCodedOutputStream.writeString(8, getReferer()); 
    boolean bool = this.cacheHit_;
    if (bool)
      paramCodedOutputStream.writeBool(9, bool); 
    bool = this.cacheValidatedWithOriginServer_;
    if (bool)
      paramCodedOutputStream.writeBool(10, bool); 
    bool = this.cacheLookup_;
    if (bool)
      paramCodedOutputStream.writeBool(11, bool); 
    l = this.cacheFillBytes_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(12, l); 
    if (!this.serverIp_.isEmpty())
      paramCodedOutputStream.writeString(13, getServerIp()); 
    if (this.latency_ != null)
      paramCodedOutputStream.writeMessage(14, (MessageLite)getLatency()); 
    if (!this.protocol_.isEmpty())
      paramCodedOutputStream.writeString(15, getProtocol()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<HttpRequest, Builder> implements HttpRequestOrBuilder {
    private Builder() {
      super(HttpRequest.DEFAULT_INSTANCE);
    }
    
    public Builder clearCacheFillBytes() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearCacheFillBytes();
      return this;
    }
    
    public Builder clearCacheHit() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearCacheHit();
      return this;
    }
    
    public Builder clearCacheLookup() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearCacheLookup();
      return this;
    }
    
    public Builder clearCacheValidatedWithOriginServer() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearCacheValidatedWithOriginServer();
      return this;
    }
    
    public Builder clearLatency() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearLatency();
      return this;
    }
    
    public Builder clearProtocol() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearProtocol();
      return this;
    }
    
    public Builder clearReferer() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearReferer();
      return this;
    }
    
    public Builder clearRemoteIp() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearRemoteIp();
      return this;
    }
    
    public Builder clearRequestMethod() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearRequestMethod();
      return this;
    }
    
    public Builder clearRequestSize() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearRequestSize();
      return this;
    }
    
    public Builder clearRequestUrl() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearRequestUrl();
      return this;
    }
    
    public Builder clearResponseSize() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearResponseSize();
      return this;
    }
    
    public Builder clearServerIp() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearServerIp();
      return this;
    }
    
    public Builder clearStatus() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearStatus();
      return this;
    }
    
    public Builder clearUserAgent() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearUserAgent();
      return this;
    }
    
    public long getCacheFillBytes() {
      return ((HttpRequest)this.instance).getCacheFillBytes();
    }
    
    public boolean getCacheHit() {
      return ((HttpRequest)this.instance).getCacheHit();
    }
    
    public boolean getCacheLookup() {
      return ((HttpRequest)this.instance).getCacheLookup();
    }
    
    public boolean getCacheValidatedWithOriginServer() {
      return ((HttpRequest)this.instance).getCacheValidatedWithOriginServer();
    }
    
    public Duration getLatency() {
      return ((HttpRequest)this.instance).getLatency();
    }
    
    public String getProtocol() {
      return ((HttpRequest)this.instance).getProtocol();
    }
    
    public ByteString getProtocolBytes() {
      return ((HttpRequest)this.instance).getProtocolBytes();
    }
    
    public String getReferer() {
      return ((HttpRequest)this.instance).getReferer();
    }
    
    public ByteString getRefererBytes() {
      return ((HttpRequest)this.instance).getRefererBytes();
    }
    
    public String getRemoteIp() {
      return ((HttpRequest)this.instance).getRemoteIp();
    }
    
    public ByteString getRemoteIpBytes() {
      return ((HttpRequest)this.instance).getRemoteIpBytes();
    }
    
    public String getRequestMethod() {
      return ((HttpRequest)this.instance).getRequestMethod();
    }
    
    public ByteString getRequestMethodBytes() {
      return ((HttpRequest)this.instance).getRequestMethodBytes();
    }
    
    public long getRequestSize() {
      return ((HttpRequest)this.instance).getRequestSize();
    }
    
    public String getRequestUrl() {
      return ((HttpRequest)this.instance).getRequestUrl();
    }
    
    public ByteString getRequestUrlBytes() {
      return ((HttpRequest)this.instance).getRequestUrlBytes();
    }
    
    public long getResponseSize() {
      return ((HttpRequest)this.instance).getResponseSize();
    }
    
    public String getServerIp() {
      return ((HttpRequest)this.instance).getServerIp();
    }
    
    public ByteString getServerIpBytes() {
      return ((HttpRequest)this.instance).getServerIpBytes();
    }
    
    public int getStatus() {
      return ((HttpRequest)this.instance).getStatus();
    }
    
    public String getUserAgent() {
      return ((HttpRequest)this.instance).getUserAgent();
    }
    
    public ByteString getUserAgentBytes() {
      return ((HttpRequest)this.instance).getUserAgentBytes();
    }
    
    public boolean hasLatency() {
      return ((HttpRequest)this.instance).hasLatency();
    }
    
    public Builder mergeLatency(Duration param1Duration) {
      copyOnWrite();
      ((HttpRequest)this.instance).mergeLatency(param1Duration);
      return this;
    }
    
    public Builder setCacheFillBytes(long param1Long) {
      copyOnWrite();
      ((HttpRequest)this.instance).setCacheFillBytes(param1Long);
      return this;
    }
    
    public Builder setCacheHit(boolean param1Boolean) {
      copyOnWrite();
      ((HttpRequest)this.instance).setCacheHit(param1Boolean);
      return this;
    }
    
    public Builder setCacheLookup(boolean param1Boolean) {
      copyOnWrite();
      ((HttpRequest)this.instance).setCacheLookup(param1Boolean);
      return this;
    }
    
    public Builder setCacheValidatedWithOriginServer(boolean param1Boolean) {
      copyOnWrite();
      ((HttpRequest)this.instance).setCacheValidatedWithOriginServer(param1Boolean);
      return this;
    }
    
    public Builder setLatency(Duration.Builder param1Builder) {
      copyOnWrite();
      ((HttpRequest)this.instance).setLatency(param1Builder);
      return this;
    }
    
    public Builder setLatency(Duration param1Duration) {
      copyOnWrite();
      ((HttpRequest)this.instance).setLatency(param1Duration);
      return this;
    }
    
    public Builder setProtocol(String param1String) {
      copyOnWrite();
      ((HttpRequest)this.instance).setProtocol(param1String);
      return this;
    }
    
    public Builder setProtocolBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((HttpRequest)this.instance).setProtocolBytes(param1ByteString);
      return this;
    }
    
    public Builder setReferer(String param1String) {
      copyOnWrite();
      ((HttpRequest)this.instance).setReferer(param1String);
      return this;
    }
    
    public Builder setRefererBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((HttpRequest)this.instance).setRefererBytes(param1ByteString);
      return this;
    }
    
    public Builder setRemoteIp(String param1String) {
      copyOnWrite();
      ((HttpRequest)this.instance).setRemoteIp(param1String);
      return this;
    }
    
    public Builder setRemoteIpBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((HttpRequest)this.instance).setRemoteIpBytes(param1ByteString);
      return this;
    }
    
    public Builder setRequestMethod(String param1String) {
      copyOnWrite();
      ((HttpRequest)this.instance).setRequestMethod(param1String);
      return this;
    }
    
    public Builder setRequestMethodBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((HttpRequest)this.instance).setRequestMethodBytes(param1ByteString);
      return this;
    }
    
    public Builder setRequestSize(long param1Long) {
      copyOnWrite();
      ((HttpRequest)this.instance).setRequestSize(param1Long);
      return this;
    }
    
    public Builder setRequestUrl(String param1String) {
      copyOnWrite();
      ((HttpRequest)this.instance).setRequestUrl(param1String);
      return this;
    }
    
    public Builder setRequestUrlBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((HttpRequest)this.instance).setRequestUrlBytes(param1ByteString);
      return this;
    }
    
    public Builder setResponseSize(long param1Long) {
      copyOnWrite();
      ((HttpRequest)this.instance).setResponseSize(param1Long);
      return this;
    }
    
    public Builder setServerIp(String param1String) {
      copyOnWrite();
      ((HttpRequest)this.instance).setServerIp(param1String);
      return this;
    }
    
    public Builder setServerIpBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((HttpRequest)this.instance).setServerIpBytes(param1ByteString);
      return this;
    }
    
    public Builder setStatus(int param1Int) {
      copyOnWrite();
      ((HttpRequest)this.instance).setStatus(param1Int);
      return this;
    }
    
    public Builder setUserAgent(String param1String) {
      copyOnWrite();
      ((HttpRequest)this.instance).setUserAgent(param1String);
      return this;
    }
    
    public Builder setUserAgentBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((HttpRequest)this.instance).setUserAgentBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\logging\type\HttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */