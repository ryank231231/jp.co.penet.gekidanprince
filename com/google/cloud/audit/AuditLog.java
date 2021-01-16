package com.google.cloud.audit;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.Struct;
import com.google.rpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class AuditLog extends GeneratedMessageLite<AuditLog, AuditLog.Builder> implements AuditLogOrBuilder {
  public static final int AUTHENTICATION_INFO_FIELD_NUMBER = 3;
  
  public static final int AUTHORIZATION_INFO_FIELD_NUMBER = 9;
  
  private static final AuditLog DEFAULT_INSTANCE = new AuditLog();
  
  public static final int METHOD_NAME_FIELD_NUMBER = 8;
  
  public static final int NUM_RESPONSE_ITEMS_FIELD_NUMBER = 12;
  
  private static volatile Parser<AuditLog> PARSER;
  
  public static final int REQUEST_FIELD_NUMBER = 16;
  
  public static final int REQUEST_METADATA_FIELD_NUMBER = 4;
  
  public static final int RESOURCE_NAME_FIELD_NUMBER = 11;
  
  public static final int RESPONSE_FIELD_NUMBER = 17;
  
  public static final int SERVICE_DATA_FIELD_NUMBER = 15;
  
  public static final int SERVICE_NAME_FIELD_NUMBER = 7;
  
  public static final int STATUS_FIELD_NUMBER = 2;
  
  private AuthenticationInfo authenticationInfo_;
  
  private Internal.ProtobufList<AuthorizationInfo> authorizationInfo_ = emptyProtobufList();
  
  private int bitField0_;
  
  private String methodName_ = "";
  
  private long numResponseItems_;
  
  private RequestMetadata requestMetadata_;
  
  private Struct request_;
  
  private String resourceName_ = "";
  
  private Struct response_;
  
  private Any serviceData_;
  
  private String serviceName_ = "";
  
  private Status status_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllAuthorizationInfo(Iterable<? extends AuthorizationInfo> paramIterable) {
    ensureAuthorizationInfoIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.authorizationInfo_);
  }
  
  private void addAuthorizationInfo(int paramInt, AuthorizationInfo.Builder paramBuilder) {
    ensureAuthorizationInfoIsMutable();
    this.authorizationInfo_.add(paramInt, paramBuilder.build());
  }
  
  private void addAuthorizationInfo(int paramInt, AuthorizationInfo paramAuthorizationInfo) {
    if (paramAuthorizationInfo != null) {
      ensureAuthorizationInfoIsMutable();
      this.authorizationInfo_.add(paramInt, paramAuthorizationInfo);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addAuthorizationInfo(AuthorizationInfo.Builder paramBuilder) {
    ensureAuthorizationInfoIsMutable();
    this.authorizationInfo_.add(paramBuilder.build());
  }
  
  private void addAuthorizationInfo(AuthorizationInfo paramAuthorizationInfo) {
    if (paramAuthorizationInfo != null) {
      ensureAuthorizationInfoIsMutable();
      this.authorizationInfo_.add(paramAuthorizationInfo);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearAuthenticationInfo() {
    this.authenticationInfo_ = null;
  }
  
  private void clearAuthorizationInfo() {
    this.authorizationInfo_ = emptyProtobufList();
  }
  
  private void clearMethodName() {
    this.methodName_ = getDefaultInstance().getMethodName();
  }
  
  private void clearNumResponseItems() {
    this.numResponseItems_ = 0L;
  }
  
  private void clearRequest() {
    this.request_ = null;
  }
  
  private void clearRequestMetadata() {
    this.requestMetadata_ = null;
  }
  
  private void clearResourceName() {
    this.resourceName_ = getDefaultInstance().getResourceName();
  }
  
  private void clearResponse() {
    this.response_ = null;
  }
  
  private void clearServiceData() {
    this.serviceData_ = null;
  }
  
  private void clearServiceName() {
    this.serviceName_ = getDefaultInstance().getServiceName();
  }
  
  private void clearStatus() {
    this.status_ = null;
  }
  
  private void ensureAuthorizationInfoIsMutable() {
    if (!this.authorizationInfo_.isModifiable())
      this.authorizationInfo_ = GeneratedMessageLite.mutableCopy(this.authorizationInfo_); 
  }
  
  public static AuditLog getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeAuthenticationInfo(AuthenticationInfo paramAuthenticationInfo) {
    AuthenticationInfo authenticationInfo = this.authenticationInfo_;
    if (authenticationInfo != null && authenticationInfo != AuthenticationInfo.getDefaultInstance()) {
      this.authenticationInfo_ = (AuthenticationInfo)((AuthenticationInfo.Builder)AuthenticationInfo.newBuilder(this.authenticationInfo_).mergeFrom(paramAuthenticationInfo)).buildPartial();
    } else {
      this.authenticationInfo_ = paramAuthenticationInfo;
    } 
  }
  
  private void mergeRequest(Struct paramStruct) {
    Struct struct = this.request_;
    if (struct != null && struct != Struct.getDefaultInstance()) {
      this.request_ = (Struct)((Struct.Builder)Struct.newBuilder(this.request_).mergeFrom((GeneratedMessageLite)paramStruct)).buildPartial();
    } else {
      this.request_ = paramStruct;
    } 
  }
  
  private void mergeRequestMetadata(RequestMetadata paramRequestMetadata) {
    RequestMetadata requestMetadata = this.requestMetadata_;
    if (requestMetadata != null && requestMetadata != RequestMetadata.getDefaultInstance()) {
      this.requestMetadata_ = (RequestMetadata)((RequestMetadata.Builder)RequestMetadata.newBuilder(this.requestMetadata_).mergeFrom(paramRequestMetadata)).buildPartial();
    } else {
      this.requestMetadata_ = paramRequestMetadata;
    } 
  }
  
  private void mergeResponse(Struct paramStruct) {
    Struct struct = this.response_;
    if (struct != null && struct != Struct.getDefaultInstance()) {
      this.response_ = (Struct)((Struct.Builder)Struct.newBuilder(this.response_).mergeFrom((GeneratedMessageLite)paramStruct)).buildPartial();
    } else {
      this.response_ = paramStruct;
    } 
  }
  
  private void mergeServiceData(Any paramAny) {
    Any any = this.serviceData_;
    if (any != null && any != Any.getDefaultInstance()) {
      this.serviceData_ = (Any)((Any.Builder)Any.newBuilder(this.serviceData_).mergeFrom((GeneratedMessageLite)paramAny)).buildPartial();
    } else {
      this.serviceData_ = paramAny;
    } 
  }
  
  private void mergeStatus(Status paramStatus) {
    Status status = this.status_;
    if (status != null && status != Status.getDefaultInstance()) {
      this.status_ = (Status)((Status.Builder)Status.newBuilder(this.status_).mergeFrom((GeneratedMessageLite)paramStatus)).buildPartial();
    } else {
      this.status_ = paramStatus;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(AuditLog paramAuditLog) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramAuditLog);
  }
  
  public static AuditLog parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (AuditLog)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static AuditLog parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuditLog)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static AuditLog parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (AuditLog)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static AuditLog parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuditLog)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static AuditLog parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (AuditLog)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static AuditLog parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuditLog)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static AuditLog parseFrom(InputStream paramInputStream) throws IOException {
    return (AuditLog)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static AuditLog parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuditLog)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static AuditLog parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (AuditLog)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static AuditLog parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuditLog)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<AuditLog> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeAuthorizationInfo(int paramInt) {
    ensureAuthorizationInfoIsMutable();
    this.authorizationInfo_.remove(paramInt);
  }
  
  private void setAuthenticationInfo(AuthenticationInfo.Builder paramBuilder) {
    this.authenticationInfo_ = (AuthenticationInfo)paramBuilder.build();
  }
  
  private void setAuthenticationInfo(AuthenticationInfo paramAuthenticationInfo) {
    if (paramAuthenticationInfo != null) {
      this.authenticationInfo_ = paramAuthenticationInfo;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setAuthorizationInfo(int paramInt, AuthorizationInfo.Builder paramBuilder) {
    ensureAuthorizationInfoIsMutable();
    this.authorizationInfo_.set(paramInt, paramBuilder.build());
  }
  
  private void setAuthorizationInfo(int paramInt, AuthorizationInfo paramAuthorizationInfo) {
    if (paramAuthorizationInfo != null) {
      ensureAuthorizationInfoIsMutable();
      this.authorizationInfo_.set(paramInt, paramAuthorizationInfo);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setMethodName(String paramString) {
    if (paramString != null) {
      this.methodName_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setMethodNameBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.methodName_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setNumResponseItems(long paramLong) {
    this.numResponseItems_ = paramLong;
  }
  
  private void setRequest(Struct.Builder paramBuilder) {
    this.request_ = (Struct)paramBuilder.build();
  }
  
  private void setRequest(Struct paramStruct) {
    if (paramStruct != null) {
      this.request_ = paramStruct;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRequestMetadata(RequestMetadata.Builder paramBuilder) {
    this.requestMetadata_ = (RequestMetadata)paramBuilder.build();
  }
  
  private void setRequestMetadata(RequestMetadata paramRequestMetadata) {
    if (paramRequestMetadata != null) {
      this.requestMetadata_ = paramRequestMetadata;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setResourceName(String paramString) {
    if (paramString != null) {
      this.resourceName_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setResourceNameBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.resourceName_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setResponse(Struct.Builder paramBuilder) {
    this.response_ = (Struct)paramBuilder.build();
  }
  
  private void setResponse(Struct paramStruct) {
    if (paramStruct != null) {
      this.response_ = paramStruct;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setServiceData(Any.Builder paramBuilder) {
    this.serviceData_ = (Any)paramBuilder.build();
  }
  
  private void setServiceData(Any paramAny) {
    if (paramAny != null) {
      this.serviceData_ = paramAny;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setServiceName(String paramString) {
    if (paramString != null) {
      this.serviceName_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setServiceNameBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.serviceName_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setStatus(Status.Builder paramBuilder) {
    this.status_ = (Status)paramBuilder.build();
  }
  
  private void setStatus(Status paramStatus) {
    if (paramStatus != null) {
      this.status_ = paramStatus;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/cloud/audit/AuditLog$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iload #4
    //   15: tableswitch default -> 60, 1 -> 1177, 2 -> 1173, 3 -> 1162, 4 -> 1153, 5 -> 807, 6 -> 114, 7 -> 803, 8 -> 68
    //   60: new java/lang/UnsupportedOperationException
    //   63: dup
    //   64: invokespecial <init> : ()V
    //   67: athrow
    //   68: getstatic com/google/cloud/audit/AuditLog.PARSER : Lcom/google/protobuf/Parser;
    //   71: ifnonnull -> 110
    //   74: ldc com/google/cloud/audit/AuditLog
    //   76: monitorenter
    //   77: getstatic com/google/cloud/audit/AuditLog.PARSER : Lcom/google/protobuf/Parser;
    //   80: ifnonnull -> 98
    //   83: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   86: astore_1
    //   87: aload_1
    //   88: getstatic com/google/cloud/audit/AuditLog.DEFAULT_INSTANCE : Lcom/google/cloud/audit/AuditLog;
    //   91: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   94: aload_1
    //   95: putstatic com/google/cloud/audit/AuditLog.PARSER : Lcom/google/protobuf/Parser;
    //   98: ldc com/google/cloud/audit/AuditLog
    //   100: monitorexit
    //   101: goto -> 110
    //   104: astore_1
    //   105: ldc com/google/cloud/audit/AuditLog
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    //   110: getstatic com/google/cloud/audit/AuditLog.PARSER : Lcom/google/protobuf/Parser;
    //   113: areturn
    //   114: aload_2
    //   115: checkcast com/google/protobuf/CodedInputStream
    //   118: astore_2
    //   119: aload_3
    //   120: checkcast com/google/protobuf/ExtensionRegistryLite
    //   123: astore_3
    //   124: iload #5
    //   126: ifne -> 803
    //   129: aload_2
    //   130: invokevirtual readTag : ()I
    //   133: istore #4
    //   135: iload #4
    //   137: lookupswitch default -> 244, 0 -> 736, 18 -> 671, 26 -> 606, 34 -> 541, 58 -> 530, 66 -> 519, 74 -> 472, 90 -> 461, 96 -> 450, 122 -> 385, 130 -> 320, 138 -> 255
    //   244: aload_2
    //   245: iload #4
    //   247: invokevirtual skipField : (I)Z
    //   250: istore #6
    //   252: goto -> 742
    //   255: aload_0
    //   256: getfield response_ : Lcom/google/protobuf/Struct;
    //   259: ifnull -> 276
    //   262: aload_0
    //   263: getfield response_ : Lcom/google/protobuf/Struct;
    //   266: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   269: checkcast com/google/protobuf/Struct$Builder
    //   272: astore_1
    //   273: goto -> 278
    //   276: aconst_null
    //   277: astore_1
    //   278: aload_0
    //   279: aload_2
    //   280: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   283: aload_3
    //   284: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   287: checkcast com/google/protobuf/Struct
    //   290: putfield response_ : Lcom/google/protobuf/Struct;
    //   293: aload_1
    //   294: ifnull -> 124
    //   297: aload_1
    //   298: aload_0
    //   299: getfield response_ : Lcom/google/protobuf/Struct;
    //   302: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   305: pop
    //   306: aload_0
    //   307: aload_1
    //   308: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   311: checkcast com/google/protobuf/Struct
    //   314: putfield response_ : Lcom/google/protobuf/Struct;
    //   317: goto -> 124
    //   320: aload_0
    //   321: getfield request_ : Lcom/google/protobuf/Struct;
    //   324: ifnull -> 341
    //   327: aload_0
    //   328: getfield request_ : Lcom/google/protobuf/Struct;
    //   331: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   334: checkcast com/google/protobuf/Struct$Builder
    //   337: astore_1
    //   338: goto -> 343
    //   341: aconst_null
    //   342: astore_1
    //   343: aload_0
    //   344: aload_2
    //   345: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   348: aload_3
    //   349: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   352: checkcast com/google/protobuf/Struct
    //   355: putfield request_ : Lcom/google/protobuf/Struct;
    //   358: aload_1
    //   359: ifnull -> 124
    //   362: aload_1
    //   363: aload_0
    //   364: getfield request_ : Lcom/google/protobuf/Struct;
    //   367: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   370: pop
    //   371: aload_0
    //   372: aload_1
    //   373: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   376: checkcast com/google/protobuf/Struct
    //   379: putfield request_ : Lcom/google/protobuf/Struct;
    //   382: goto -> 124
    //   385: aload_0
    //   386: getfield serviceData_ : Lcom/google/protobuf/Any;
    //   389: ifnull -> 406
    //   392: aload_0
    //   393: getfield serviceData_ : Lcom/google/protobuf/Any;
    //   396: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   399: checkcast com/google/protobuf/Any$Builder
    //   402: astore_1
    //   403: goto -> 408
    //   406: aconst_null
    //   407: astore_1
    //   408: aload_0
    //   409: aload_2
    //   410: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   413: aload_3
    //   414: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   417: checkcast com/google/protobuf/Any
    //   420: putfield serviceData_ : Lcom/google/protobuf/Any;
    //   423: aload_1
    //   424: ifnull -> 124
    //   427: aload_1
    //   428: aload_0
    //   429: getfield serviceData_ : Lcom/google/protobuf/Any;
    //   432: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   435: pop
    //   436: aload_0
    //   437: aload_1
    //   438: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   441: checkcast com/google/protobuf/Any
    //   444: putfield serviceData_ : Lcom/google/protobuf/Any;
    //   447: goto -> 124
    //   450: aload_0
    //   451: aload_2
    //   452: invokevirtual readInt64 : ()J
    //   455: putfield numResponseItems_ : J
    //   458: goto -> 124
    //   461: aload_0
    //   462: aload_2
    //   463: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   466: putfield resourceName_ : Ljava/lang/String;
    //   469: goto -> 124
    //   472: aload_0
    //   473: getfield authorizationInfo_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   476: invokeinterface isModifiable : ()Z
    //   481: ifne -> 495
    //   484: aload_0
    //   485: aload_0
    //   486: getfield authorizationInfo_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   489: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   492: putfield authorizationInfo_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   495: aload_0
    //   496: getfield authorizationInfo_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   499: aload_2
    //   500: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   503: aload_3
    //   504: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   507: checkcast com/google/cloud/audit/AuthorizationInfo
    //   510: invokeinterface add : (Ljava/lang/Object;)Z
    //   515: pop
    //   516: goto -> 124
    //   519: aload_0
    //   520: aload_2
    //   521: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   524: putfield methodName_ : Ljava/lang/String;
    //   527: goto -> 124
    //   530: aload_0
    //   531: aload_2
    //   532: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   535: putfield serviceName_ : Ljava/lang/String;
    //   538: goto -> 124
    //   541: aload_0
    //   542: getfield requestMetadata_ : Lcom/google/cloud/audit/RequestMetadata;
    //   545: ifnull -> 562
    //   548: aload_0
    //   549: getfield requestMetadata_ : Lcom/google/cloud/audit/RequestMetadata;
    //   552: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   555: checkcast com/google/cloud/audit/RequestMetadata$Builder
    //   558: astore_1
    //   559: goto -> 564
    //   562: aconst_null
    //   563: astore_1
    //   564: aload_0
    //   565: aload_2
    //   566: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   569: aload_3
    //   570: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   573: checkcast com/google/cloud/audit/RequestMetadata
    //   576: putfield requestMetadata_ : Lcom/google/cloud/audit/RequestMetadata;
    //   579: aload_1
    //   580: ifnull -> 124
    //   583: aload_1
    //   584: aload_0
    //   585: getfield requestMetadata_ : Lcom/google/cloud/audit/RequestMetadata;
    //   588: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   591: pop
    //   592: aload_0
    //   593: aload_1
    //   594: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   597: checkcast com/google/cloud/audit/RequestMetadata
    //   600: putfield requestMetadata_ : Lcom/google/cloud/audit/RequestMetadata;
    //   603: goto -> 124
    //   606: aload_0
    //   607: getfield authenticationInfo_ : Lcom/google/cloud/audit/AuthenticationInfo;
    //   610: ifnull -> 627
    //   613: aload_0
    //   614: getfield authenticationInfo_ : Lcom/google/cloud/audit/AuthenticationInfo;
    //   617: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   620: checkcast com/google/cloud/audit/AuthenticationInfo$Builder
    //   623: astore_1
    //   624: goto -> 629
    //   627: aconst_null
    //   628: astore_1
    //   629: aload_0
    //   630: aload_2
    //   631: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   634: aload_3
    //   635: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   638: checkcast com/google/cloud/audit/AuthenticationInfo
    //   641: putfield authenticationInfo_ : Lcom/google/cloud/audit/AuthenticationInfo;
    //   644: aload_1
    //   645: ifnull -> 124
    //   648: aload_1
    //   649: aload_0
    //   650: getfield authenticationInfo_ : Lcom/google/cloud/audit/AuthenticationInfo;
    //   653: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   656: pop
    //   657: aload_0
    //   658: aload_1
    //   659: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   662: checkcast com/google/cloud/audit/AuthenticationInfo
    //   665: putfield authenticationInfo_ : Lcom/google/cloud/audit/AuthenticationInfo;
    //   668: goto -> 124
    //   671: aload_0
    //   672: getfield status_ : Lcom/google/rpc/Status;
    //   675: ifnull -> 692
    //   678: aload_0
    //   679: getfield status_ : Lcom/google/rpc/Status;
    //   682: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   685: checkcast com/google/rpc/Status$Builder
    //   688: astore_1
    //   689: goto -> 694
    //   692: aconst_null
    //   693: astore_1
    //   694: aload_0
    //   695: aload_2
    //   696: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   699: aload_3
    //   700: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   703: checkcast com/google/rpc/Status
    //   706: putfield status_ : Lcom/google/rpc/Status;
    //   709: aload_1
    //   710: ifnull -> 124
    //   713: aload_1
    //   714: aload_0
    //   715: getfield status_ : Lcom/google/rpc/Status;
    //   718: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   721: pop
    //   722: aload_0
    //   723: aload_1
    //   724: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   727: checkcast com/google/rpc/Status
    //   730: putfield status_ : Lcom/google/rpc/Status;
    //   733: goto -> 124
    //   736: iconst_1
    //   737: istore #5
    //   739: goto -> 124
    //   742: iload #6
    //   744: ifne -> 124
    //   747: iconst_1
    //   748: istore #5
    //   750: goto -> 124
    //   753: astore_1
    //   754: goto -> 801
    //   757: astore_3
    //   758: new java/lang/RuntimeException
    //   761: astore_2
    //   762: new com/google/protobuf/InvalidProtocolBufferException
    //   765: astore_1
    //   766: aload_1
    //   767: aload_3
    //   768: invokevirtual getMessage : ()Ljava/lang/String;
    //   771: invokespecial <init> : (Ljava/lang/String;)V
    //   774: aload_2
    //   775: aload_1
    //   776: aload_0
    //   777: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   780: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   783: aload_2
    //   784: athrow
    //   785: astore_2
    //   786: new java/lang/RuntimeException
    //   789: astore_1
    //   790: aload_1
    //   791: aload_2
    //   792: aload_0
    //   793: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   796: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   799: aload_1
    //   800: athrow
    //   801: aload_1
    //   802: athrow
    //   803: getstatic com/google/cloud/audit/AuditLog.DEFAULT_INSTANCE : Lcom/google/cloud/audit/AuditLog;
    //   806: areturn
    //   807: aload_2
    //   808: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   811: astore_1
    //   812: aload_3
    //   813: checkcast com/google/cloud/audit/AuditLog
    //   816: astore_2
    //   817: aload_0
    //   818: aload_1
    //   819: aload_0
    //   820: getfield serviceName_ : Ljava/lang/String;
    //   823: invokevirtual isEmpty : ()Z
    //   826: iconst_1
    //   827: ixor
    //   828: aload_0
    //   829: getfield serviceName_ : Ljava/lang/String;
    //   832: aload_2
    //   833: getfield serviceName_ : Ljava/lang/String;
    //   836: invokevirtual isEmpty : ()Z
    //   839: iconst_1
    //   840: ixor
    //   841: aload_2
    //   842: getfield serviceName_ : Ljava/lang/String;
    //   845: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   850: putfield serviceName_ : Ljava/lang/String;
    //   853: aload_0
    //   854: aload_1
    //   855: aload_0
    //   856: getfield methodName_ : Ljava/lang/String;
    //   859: invokevirtual isEmpty : ()Z
    //   862: iconst_1
    //   863: ixor
    //   864: aload_0
    //   865: getfield methodName_ : Ljava/lang/String;
    //   868: aload_2
    //   869: getfield methodName_ : Ljava/lang/String;
    //   872: invokevirtual isEmpty : ()Z
    //   875: iconst_1
    //   876: ixor
    //   877: aload_2
    //   878: getfield methodName_ : Ljava/lang/String;
    //   881: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   886: putfield methodName_ : Ljava/lang/String;
    //   889: aload_0
    //   890: aload_1
    //   891: aload_0
    //   892: getfield resourceName_ : Ljava/lang/String;
    //   895: invokevirtual isEmpty : ()Z
    //   898: iconst_1
    //   899: ixor
    //   900: aload_0
    //   901: getfield resourceName_ : Ljava/lang/String;
    //   904: aload_2
    //   905: getfield resourceName_ : Ljava/lang/String;
    //   908: invokevirtual isEmpty : ()Z
    //   911: iconst_1
    //   912: ixor
    //   913: aload_2
    //   914: getfield resourceName_ : Ljava/lang/String;
    //   917: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   922: putfield resourceName_ : Ljava/lang/String;
    //   925: aload_0
    //   926: getfield numResponseItems_ : J
    //   929: lconst_0
    //   930: lcmp
    //   931: ifeq -> 940
    //   934: iconst_1
    //   935: istore #6
    //   937: goto -> 943
    //   940: iconst_0
    //   941: istore #6
    //   943: aload_0
    //   944: getfield numResponseItems_ : J
    //   947: lstore #7
    //   949: aload_2
    //   950: getfield numResponseItems_ : J
    //   953: lconst_0
    //   954: lcmp
    //   955: ifeq -> 964
    //   958: iconst_1
    //   959: istore #9
    //   961: goto -> 967
    //   964: iconst_0
    //   965: istore #9
    //   967: aload_0
    //   968: aload_1
    //   969: iload #6
    //   971: lload #7
    //   973: iload #9
    //   975: aload_2
    //   976: getfield numResponseItems_ : J
    //   979: invokeinterface visitLong : (ZJZJ)J
    //   984: putfield numResponseItems_ : J
    //   987: aload_0
    //   988: aload_1
    //   989: aload_0
    //   990: getfield status_ : Lcom/google/rpc/Status;
    //   993: aload_2
    //   994: getfield status_ : Lcom/google/rpc/Status;
    //   997: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   1002: checkcast com/google/rpc/Status
    //   1005: putfield status_ : Lcom/google/rpc/Status;
    //   1008: aload_0
    //   1009: aload_1
    //   1010: aload_0
    //   1011: getfield authenticationInfo_ : Lcom/google/cloud/audit/AuthenticationInfo;
    //   1014: aload_2
    //   1015: getfield authenticationInfo_ : Lcom/google/cloud/audit/AuthenticationInfo;
    //   1018: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   1023: checkcast com/google/cloud/audit/AuthenticationInfo
    //   1026: putfield authenticationInfo_ : Lcom/google/cloud/audit/AuthenticationInfo;
    //   1029: aload_0
    //   1030: aload_1
    //   1031: aload_0
    //   1032: getfield authorizationInfo_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   1035: aload_2
    //   1036: getfield authorizationInfo_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   1039: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   1044: putfield authorizationInfo_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   1047: aload_0
    //   1048: aload_1
    //   1049: aload_0
    //   1050: getfield requestMetadata_ : Lcom/google/cloud/audit/RequestMetadata;
    //   1053: aload_2
    //   1054: getfield requestMetadata_ : Lcom/google/cloud/audit/RequestMetadata;
    //   1057: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   1062: checkcast com/google/cloud/audit/RequestMetadata
    //   1065: putfield requestMetadata_ : Lcom/google/cloud/audit/RequestMetadata;
    //   1068: aload_0
    //   1069: aload_1
    //   1070: aload_0
    //   1071: getfield request_ : Lcom/google/protobuf/Struct;
    //   1074: aload_2
    //   1075: getfield request_ : Lcom/google/protobuf/Struct;
    //   1078: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   1083: checkcast com/google/protobuf/Struct
    //   1086: putfield request_ : Lcom/google/protobuf/Struct;
    //   1089: aload_0
    //   1090: aload_1
    //   1091: aload_0
    //   1092: getfield response_ : Lcom/google/protobuf/Struct;
    //   1095: aload_2
    //   1096: getfield response_ : Lcom/google/protobuf/Struct;
    //   1099: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   1104: checkcast com/google/protobuf/Struct
    //   1107: putfield response_ : Lcom/google/protobuf/Struct;
    //   1110: aload_0
    //   1111: aload_1
    //   1112: aload_0
    //   1113: getfield serviceData_ : Lcom/google/protobuf/Any;
    //   1116: aload_2
    //   1117: getfield serviceData_ : Lcom/google/protobuf/Any;
    //   1120: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   1125: checkcast com/google/protobuf/Any
    //   1128: putfield serviceData_ : Lcom/google/protobuf/Any;
    //   1131: aload_1
    //   1132: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   1135: if_acmpne -> 1151
    //   1138: aload_0
    //   1139: aload_0
    //   1140: getfield bitField0_ : I
    //   1143: aload_2
    //   1144: getfield bitField0_ : I
    //   1147: ior
    //   1148: putfield bitField0_ : I
    //   1151: aload_0
    //   1152: areturn
    //   1153: new com/google/cloud/audit/AuditLog$Builder
    //   1156: dup
    //   1157: aconst_null
    //   1158: invokespecial <init> : (Lcom/google/cloud/audit/AuditLog$1;)V
    //   1161: areturn
    //   1162: aload_0
    //   1163: getfield authorizationInfo_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   1166: invokeinterface makeImmutable : ()V
    //   1171: aconst_null
    //   1172: areturn
    //   1173: getstatic com/google/cloud/audit/AuditLog.DEFAULT_INSTANCE : Lcom/google/cloud/audit/AuditLog;
    //   1176: areturn
    //   1177: new com/google/cloud/audit/AuditLog
    //   1180: dup
    //   1181: invokespecial <init> : ()V
    //   1184: areturn
    // Exception table:
    //   from	to	target	type
    //   77	98	104	finally
    //   98	101	104	finally
    //   105	108	104	finally
    //   129	135	785	com/google/protobuf/InvalidProtocolBufferException
    //   129	135	757	java/io/IOException
    //   129	135	753	finally
    //   244	252	785	com/google/protobuf/InvalidProtocolBufferException
    //   244	252	757	java/io/IOException
    //   244	252	753	finally
    //   255	273	785	com/google/protobuf/InvalidProtocolBufferException
    //   255	273	757	java/io/IOException
    //   255	273	753	finally
    //   278	293	785	com/google/protobuf/InvalidProtocolBufferException
    //   278	293	757	java/io/IOException
    //   278	293	753	finally
    //   297	317	785	com/google/protobuf/InvalidProtocolBufferException
    //   297	317	757	java/io/IOException
    //   297	317	753	finally
    //   320	338	785	com/google/protobuf/InvalidProtocolBufferException
    //   320	338	757	java/io/IOException
    //   320	338	753	finally
    //   343	358	785	com/google/protobuf/InvalidProtocolBufferException
    //   343	358	757	java/io/IOException
    //   343	358	753	finally
    //   362	382	785	com/google/protobuf/InvalidProtocolBufferException
    //   362	382	757	java/io/IOException
    //   362	382	753	finally
    //   385	403	785	com/google/protobuf/InvalidProtocolBufferException
    //   385	403	757	java/io/IOException
    //   385	403	753	finally
    //   408	423	785	com/google/protobuf/InvalidProtocolBufferException
    //   408	423	757	java/io/IOException
    //   408	423	753	finally
    //   427	447	785	com/google/protobuf/InvalidProtocolBufferException
    //   427	447	757	java/io/IOException
    //   427	447	753	finally
    //   450	458	785	com/google/protobuf/InvalidProtocolBufferException
    //   450	458	757	java/io/IOException
    //   450	458	753	finally
    //   461	469	785	com/google/protobuf/InvalidProtocolBufferException
    //   461	469	757	java/io/IOException
    //   461	469	753	finally
    //   472	495	785	com/google/protobuf/InvalidProtocolBufferException
    //   472	495	757	java/io/IOException
    //   472	495	753	finally
    //   495	516	785	com/google/protobuf/InvalidProtocolBufferException
    //   495	516	757	java/io/IOException
    //   495	516	753	finally
    //   519	527	785	com/google/protobuf/InvalidProtocolBufferException
    //   519	527	757	java/io/IOException
    //   519	527	753	finally
    //   530	538	785	com/google/protobuf/InvalidProtocolBufferException
    //   530	538	757	java/io/IOException
    //   530	538	753	finally
    //   541	559	785	com/google/protobuf/InvalidProtocolBufferException
    //   541	559	757	java/io/IOException
    //   541	559	753	finally
    //   564	579	785	com/google/protobuf/InvalidProtocolBufferException
    //   564	579	757	java/io/IOException
    //   564	579	753	finally
    //   583	603	785	com/google/protobuf/InvalidProtocolBufferException
    //   583	603	757	java/io/IOException
    //   583	603	753	finally
    //   606	624	785	com/google/protobuf/InvalidProtocolBufferException
    //   606	624	757	java/io/IOException
    //   606	624	753	finally
    //   629	644	785	com/google/protobuf/InvalidProtocolBufferException
    //   629	644	757	java/io/IOException
    //   629	644	753	finally
    //   648	668	785	com/google/protobuf/InvalidProtocolBufferException
    //   648	668	757	java/io/IOException
    //   648	668	753	finally
    //   671	689	785	com/google/protobuf/InvalidProtocolBufferException
    //   671	689	757	java/io/IOException
    //   671	689	753	finally
    //   694	709	785	com/google/protobuf/InvalidProtocolBufferException
    //   694	709	757	java/io/IOException
    //   694	709	753	finally
    //   713	733	785	com/google/protobuf/InvalidProtocolBufferException
    //   713	733	757	java/io/IOException
    //   713	733	753	finally
    //   758	785	753	finally
    //   786	801	753	finally
  }
  
  public AuthenticationInfo getAuthenticationInfo() {
    AuthenticationInfo authenticationInfo1 = this.authenticationInfo_;
    AuthenticationInfo authenticationInfo2 = authenticationInfo1;
    if (authenticationInfo1 == null)
      authenticationInfo2 = AuthenticationInfo.getDefaultInstance(); 
    return authenticationInfo2;
  }
  
  public AuthorizationInfo getAuthorizationInfo(int paramInt) {
    return (AuthorizationInfo)this.authorizationInfo_.get(paramInt);
  }
  
  public int getAuthorizationInfoCount() {
    return this.authorizationInfo_.size();
  }
  
  public List<AuthorizationInfo> getAuthorizationInfoList() {
    return (List<AuthorizationInfo>)this.authorizationInfo_;
  }
  
  public AuthorizationInfoOrBuilder getAuthorizationInfoOrBuilder(int paramInt) {
    return (AuthorizationInfoOrBuilder)this.authorizationInfo_.get(paramInt);
  }
  
  public List<? extends AuthorizationInfoOrBuilder> getAuthorizationInfoOrBuilderList() {
    return (List)this.authorizationInfo_;
  }
  
  public String getMethodName() {
    return this.methodName_;
  }
  
  public ByteString getMethodNameBytes() {
    return ByteString.copyFromUtf8(this.methodName_);
  }
  
  public long getNumResponseItems() {
    return this.numResponseItems_;
  }
  
  public Struct getRequest() {
    Struct struct1 = this.request_;
    Struct struct2 = struct1;
    if (struct1 == null)
      struct2 = Struct.getDefaultInstance(); 
    return struct2;
  }
  
  public RequestMetadata getRequestMetadata() {
    RequestMetadata requestMetadata1 = this.requestMetadata_;
    RequestMetadata requestMetadata2 = requestMetadata1;
    if (requestMetadata1 == null)
      requestMetadata2 = RequestMetadata.getDefaultInstance(); 
    return requestMetadata2;
  }
  
  public String getResourceName() {
    return this.resourceName_;
  }
  
  public ByteString getResourceNameBytes() {
    return ByteString.copyFromUtf8(this.resourceName_);
  }
  
  public Struct getResponse() {
    Struct struct1 = this.response_;
    Struct struct2 = struct1;
    if (struct1 == null)
      struct2 = Struct.getDefaultInstance(); 
    return struct2;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    Status status = this.status_;
    byte b1 = 0;
    if (status != null) {
      i = CodedOutputStream.computeMessageSize(2, (MessageLite)getStatus()) + 0;
    } else {
      i = 0;
    } 
    int j = i;
    if (this.authenticationInfo_ != null)
      j = i + CodedOutputStream.computeMessageSize(3, (MessageLite)getAuthenticationInfo()); 
    i = j;
    if (this.requestMetadata_ != null)
      i = j + CodedOutputStream.computeMessageSize(4, (MessageLite)getRequestMetadata()); 
    j = i;
    if (!this.serviceName_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(7, getServiceName()); 
    i = j;
    byte b2 = b1;
    if (!this.methodName_.isEmpty()) {
      i = j + CodedOutputStream.computeStringSize(8, getMethodName());
      b2 = b1;
    } 
    while (b2 < this.authorizationInfo_.size()) {
      i += CodedOutputStream.computeMessageSize(9, (MessageLite)this.authorizationInfo_.get(b2));
      b2++;
    } 
    j = i;
    if (!this.resourceName_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(11, getResourceName()); 
    long l = this.numResponseItems_;
    i = j;
    if (l != 0L)
      i = j + CodedOutputStream.computeInt64Size(12, l); 
    j = i;
    if (this.serviceData_ != null)
      j = i + CodedOutputStream.computeMessageSize(15, (MessageLite)getServiceData()); 
    i = j;
    if (this.request_ != null)
      i = j + CodedOutputStream.computeMessageSize(16, (MessageLite)getRequest()); 
    j = i;
    if (this.response_ != null)
      j = i + CodedOutputStream.computeMessageSize(17, (MessageLite)getResponse()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public Any getServiceData() {
    Any any1 = this.serviceData_;
    Any any2 = any1;
    if (any1 == null)
      any2 = Any.getDefaultInstance(); 
    return any2;
  }
  
  public String getServiceName() {
    return this.serviceName_;
  }
  
  public ByteString getServiceNameBytes() {
    return ByteString.copyFromUtf8(this.serviceName_);
  }
  
  public Status getStatus() {
    Status status1 = this.status_;
    Status status2 = status1;
    if (status1 == null)
      status2 = Status.getDefaultInstance(); 
    return status2;
  }
  
  public boolean hasAuthenticationInfo() {
    boolean bool;
    if (this.authenticationInfo_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasRequest() {
    boolean bool;
    if (this.request_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasRequestMetadata() {
    boolean bool;
    if (this.requestMetadata_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasResponse() {
    boolean bool;
    if (this.response_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasServiceData() {
    boolean bool;
    if (this.serviceData_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasStatus() {
    boolean bool;
    if (this.status_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (this.status_ != null)
      paramCodedOutputStream.writeMessage(2, (MessageLite)getStatus()); 
    if (this.authenticationInfo_ != null)
      paramCodedOutputStream.writeMessage(3, (MessageLite)getAuthenticationInfo()); 
    if (this.requestMetadata_ != null)
      paramCodedOutputStream.writeMessage(4, (MessageLite)getRequestMetadata()); 
    if (!this.serviceName_.isEmpty())
      paramCodedOutputStream.writeString(7, getServiceName()); 
    if (!this.methodName_.isEmpty())
      paramCodedOutputStream.writeString(8, getMethodName()); 
    for (byte b = 0; b < this.authorizationInfo_.size(); b++)
      paramCodedOutputStream.writeMessage(9, (MessageLite)this.authorizationInfo_.get(b)); 
    if (!this.resourceName_.isEmpty())
      paramCodedOutputStream.writeString(11, getResourceName()); 
    long l = this.numResponseItems_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(12, l); 
    if (this.serviceData_ != null)
      paramCodedOutputStream.writeMessage(15, (MessageLite)getServiceData()); 
    if (this.request_ != null)
      paramCodedOutputStream.writeMessage(16, (MessageLite)getRequest()); 
    if (this.response_ != null)
      paramCodedOutputStream.writeMessage(17, (MessageLite)getResponse()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<AuditLog, Builder> implements AuditLogOrBuilder {
    private Builder() {
      super(AuditLog.DEFAULT_INSTANCE);
    }
    
    public Builder addAllAuthorizationInfo(Iterable<? extends AuthorizationInfo> param1Iterable) {
      copyOnWrite();
      ((AuditLog)this.instance).addAllAuthorizationInfo(param1Iterable);
      return this;
    }
    
    public Builder addAuthorizationInfo(int param1Int, AuthorizationInfo.Builder param1Builder) {
      copyOnWrite();
      ((AuditLog)this.instance).addAuthorizationInfo(param1Int, param1Builder);
      return this;
    }
    
    public Builder addAuthorizationInfo(int param1Int, AuthorizationInfo param1AuthorizationInfo) {
      copyOnWrite();
      ((AuditLog)this.instance).addAuthorizationInfo(param1Int, param1AuthorizationInfo);
      return this;
    }
    
    public Builder addAuthorizationInfo(AuthorizationInfo.Builder param1Builder) {
      copyOnWrite();
      ((AuditLog)this.instance).addAuthorizationInfo(param1Builder);
      return this;
    }
    
    public Builder addAuthorizationInfo(AuthorizationInfo param1AuthorizationInfo) {
      copyOnWrite();
      ((AuditLog)this.instance).addAuthorizationInfo(param1AuthorizationInfo);
      return this;
    }
    
    public Builder clearAuthenticationInfo() {
      copyOnWrite();
      ((AuditLog)this.instance).clearAuthenticationInfo();
      return this;
    }
    
    public Builder clearAuthorizationInfo() {
      copyOnWrite();
      ((AuditLog)this.instance).clearAuthorizationInfo();
      return this;
    }
    
    public Builder clearMethodName() {
      copyOnWrite();
      ((AuditLog)this.instance).clearMethodName();
      return this;
    }
    
    public Builder clearNumResponseItems() {
      copyOnWrite();
      ((AuditLog)this.instance).clearNumResponseItems();
      return this;
    }
    
    public Builder clearRequest() {
      copyOnWrite();
      ((AuditLog)this.instance).clearRequest();
      return this;
    }
    
    public Builder clearRequestMetadata() {
      copyOnWrite();
      ((AuditLog)this.instance).clearRequestMetadata();
      return this;
    }
    
    public Builder clearResourceName() {
      copyOnWrite();
      ((AuditLog)this.instance).clearResourceName();
      return this;
    }
    
    public Builder clearResponse() {
      copyOnWrite();
      ((AuditLog)this.instance).clearResponse();
      return this;
    }
    
    public Builder clearServiceData() {
      copyOnWrite();
      ((AuditLog)this.instance).clearServiceData();
      return this;
    }
    
    public Builder clearServiceName() {
      copyOnWrite();
      ((AuditLog)this.instance).clearServiceName();
      return this;
    }
    
    public Builder clearStatus() {
      copyOnWrite();
      ((AuditLog)this.instance).clearStatus();
      return this;
    }
    
    public AuthenticationInfo getAuthenticationInfo() {
      return ((AuditLog)this.instance).getAuthenticationInfo();
    }
    
    public AuthorizationInfo getAuthorizationInfo(int param1Int) {
      return ((AuditLog)this.instance).getAuthorizationInfo(param1Int);
    }
    
    public int getAuthorizationInfoCount() {
      return ((AuditLog)this.instance).getAuthorizationInfoCount();
    }
    
    public List<AuthorizationInfo> getAuthorizationInfoList() {
      return Collections.unmodifiableList(((AuditLog)this.instance).getAuthorizationInfoList());
    }
    
    public String getMethodName() {
      return ((AuditLog)this.instance).getMethodName();
    }
    
    public ByteString getMethodNameBytes() {
      return ((AuditLog)this.instance).getMethodNameBytes();
    }
    
    public long getNumResponseItems() {
      return ((AuditLog)this.instance).getNumResponseItems();
    }
    
    public Struct getRequest() {
      return ((AuditLog)this.instance).getRequest();
    }
    
    public RequestMetadata getRequestMetadata() {
      return ((AuditLog)this.instance).getRequestMetadata();
    }
    
    public String getResourceName() {
      return ((AuditLog)this.instance).getResourceName();
    }
    
    public ByteString getResourceNameBytes() {
      return ((AuditLog)this.instance).getResourceNameBytes();
    }
    
    public Struct getResponse() {
      return ((AuditLog)this.instance).getResponse();
    }
    
    public Any getServiceData() {
      return ((AuditLog)this.instance).getServiceData();
    }
    
    public String getServiceName() {
      return ((AuditLog)this.instance).getServiceName();
    }
    
    public ByteString getServiceNameBytes() {
      return ((AuditLog)this.instance).getServiceNameBytes();
    }
    
    public Status getStatus() {
      return ((AuditLog)this.instance).getStatus();
    }
    
    public boolean hasAuthenticationInfo() {
      return ((AuditLog)this.instance).hasAuthenticationInfo();
    }
    
    public boolean hasRequest() {
      return ((AuditLog)this.instance).hasRequest();
    }
    
    public boolean hasRequestMetadata() {
      return ((AuditLog)this.instance).hasRequestMetadata();
    }
    
    public boolean hasResponse() {
      return ((AuditLog)this.instance).hasResponse();
    }
    
    public boolean hasServiceData() {
      return ((AuditLog)this.instance).hasServiceData();
    }
    
    public boolean hasStatus() {
      return ((AuditLog)this.instance).hasStatus();
    }
    
    public Builder mergeAuthenticationInfo(AuthenticationInfo param1AuthenticationInfo) {
      copyOnWrite();
      ((AuditLog)this.instance).mergeAuthenticationInfo(param1AuthenticationInfo);
      return this;
    }
    
    public Builder mergeRequest(Struct param1Struct) {
      copyOnWrite();
      ((AuditLog)this.instance).mergeRequest(param1Struct);
      return this;
    }
    
    public Builder mergeRequestMetadata(RequestMetadata param1RequestMetadata) {
      copyOnWrite();
      ((AuditLog)this.instance).mergeRequestMetadata(param1RequestMetadata);
      return this;
    }
    
    public Builder mergeResponse(Struct param1Struct) {
      copyOnWrite();
      ((AuditLog)this.instance).mergeResponse(param1Struct);
      return this;
    }
    
    public Builder mergeServiceData(Any param1Any) {
      copyOnWrite();
      ((AuditLog)this.instance).mergeServiceData(param1Any);
      return this;
    }
    
    public Builder mergeStatus(Status param1Status) {
      copyOnWrite();
      ((AuditLog)this.instance).mergeStatus(param1Status);
      return this;
    }
    
    public Builder removeAuthorizationInfo(int param1Int) {
      copyOnWrite();
      ((AuditLog)this.instance).removeAuthorizationInfo(param1Int);
      return this;
    }
    
    public Builder setAuthenticationInfo(AuthenticationInfo.Builder param1Builder) {
      copyOnWrite();
      ((AuditLog)this.instance).setAuthenticationInfo(param1Builder);
      return this;
    }
    
    public Builder setAuthenticationInfo(AuthenticationInfo param1AuthenticationInfo) {
      copyOnWrite();
      ((AuditLog)this.instance).setAuthenticationInfo(param1AuthenticationInfo);
      return this;
    }
    
    public Builder setAuthorizationInfo(int param1Int, AuthorizationInfo.Builder param1Builder) {
      copyOnWrite();
      ((AuditLog)this.instance).setAuthorizationInfo(param1Int, param1Builder);
      return this;
    }
    
    public Builder setAuthorizationInfo(int param1Int, AuthorizationInfo param1AuthorizationInfo) {
      copyOnWrite();
      ((AuditLog)this.instance).setAuthorizationInfo(param1Int, param1AuthorizationInfo);
      return this;
    }
    
    public Builder setMethodName(String param1String) {
      copyOnWrite();
      ((AuditLog)this.instance).setMethodName(param1String);
      return this;
    }
    
    public Builder setMethodNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((AuditLog)this.instance).setMethodNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setNumResponseItems(long param1Long) {
      copyOnWrite();
      ((AuditLog)this.instance).setNumResponseItems(param1Long);
      return this;
    }
    
    public Builder setRequest(Struct.Builder param1Builder) {
      copyOnWrite();
      ((AuditLog)this.instance).setRequest(param1Builder);
      return this;
    }
    
    public Builder setRequest(Struct param1Struct) {
      copyOnWrite();
      ((AuditLog)this.instance).setRequest(param1Struct);
      return this;
    }
    
    public Builder setRequestMetadata(RequestMetadata.Builder param1Builder) {
      copyOnWrite();
      ((AuditLog)this.instance).setRequestMetadata(param1Builder);
      return this;
    }
    
    public Builder setRequestMetadata(RequestMetadata param1RequestMetadata) {
      copyOnWrite();
      ((AuditLog)this.instance).setRequestMetadata(param1RequestMetadata);
      return this;
    }
    
    public Builder setResourceName(String param1String) {
      copyOnWrite();
      ((AuditLog)this.instance).setResourceName(param1String);
      return this;
    }
    
    public Builder setResourceNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((AuditLog)this.instance).setResourceNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setResponse(Struct.Builder param1Builder) {
      copyOnWrite();
      ((AuditLog)this.instance).setResponse(param1Builder);
      return this;
    }
    
    public Builder setResponse(Struct param1Struct) {
      copyOnWrite();
      ((AuditLog)this.instance).setResponse(param1Struct);
      return this;
    }
    
    public Builder setServiceData(Any.Builder param1Builder) {
      copyOnWrite();
      ((AuditLog)this.instance).setServiceData(param1Builder);
      return this;
    }
    
    public Builder setServiceData(Any param1Any) {
      copyOnWrite();
      ((AuditLog)this.instance).setServiceData(param1Any);
      return this;
    }
    
    public Builder setServiceName(String param1String) {
      copyOnWrite();
      ((AuditLog)this.instance).setServiceName(param1String);
      return this;
    }
    
    public Builder setServiceNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((AuditLog)this.instance).setServiceNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setStatus(Status.Builder param1Builder) {
      copyOnWrite();
      ((AuditLog)this.instance).setStatus(param1Builder);
      return this;
    }
    
    public Builder setStatus(Status param1Status) {
      copyOnWrite();
      ((AuditLog)this.instance).setStatus(param1Status);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\cloud\audit\AuditLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */