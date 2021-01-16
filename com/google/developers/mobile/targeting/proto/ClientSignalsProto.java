package com.google.developers.mobile.targeting.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class ClientSignalsProto {
  static {
  
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class AppInstanceClaim extends GeneratedMessageLite<AppInstanceClaim, AppInstanceClaim.Builder> implements AppInstanceClaimOrBuilder {
    public static final int APP_INSTANCE_ID_FIELD_NUMBER = 1;
    
    public static final int APP_INSTANCE_TOKEN_FIELD_NUMBER = 2;
    
    private static final AppInstanceClaim DEFAULT_INSTANCE = new AppInstanceClaim();
    
    public static final int GMP_APP_ID_FIELD_NUMBER = 3;
    
    private static volatile Parser<AppInstanceClaim> PARSER;
    
    private String appInstanceId_ = "";
    
    private String appInstanceToken_ = "";
    
    private String gmpAppId_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearAppInstanceId() {
      this.appInstanceId_ = getDefaultInstance().getAppInstanceId();
    }
    
    private void clearAppInstanceToken() {
      this.appInstanceToken_ = getDefaultInstance().getAppInstanceToken();
    }
    
    private void clearGmpAppId() {
      this.gmpAppId_ = getDefaultInstance().getGmpAppId();
    }
    
    public static AppInstanceClaim getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(AppInstanceClaim param1AppInstanceClaim) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1AppInstanceClaim);
    }
    
    public static AppInstanceClaim parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (AppInstanceClaim)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static AppInstanceClaim parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (AppInstanceClaim)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static AppInstanceClaim parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (AppInstanceClaim)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static AppInstanceClaim parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (AppInstanceClaim)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static AppInstanceClaim parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (AppInstanceClaim)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static AppInstanceClaim parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (AppInstanceClaim)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static AppInstanceClaim parseFrom(InputStream param1InputStream) throws IOException {
      return (AppInstanceClaim)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static AppInstanceClaim parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (AppInstanceClaim)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static AppInstanceClaim parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (AppInstanceClaim)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static AppInstanceClaim parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (AppInstanceClaim)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<AppInstanceClaim> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setAppInstanceId(String param1String) {
      if (param1String != null) {
        this.appInstanceId_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAppInstanceIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.appInstanceId_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAppInstanceToken(String param1String) {
      if (param1String != null) {
        this.appInstanceToken_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAppInstanceTokenBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.appInstanceToken_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setGmpAppId(String param1String) {
      if (param1String != null) {
        this.gmpAppId_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setGmpAppIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.gmpAppId_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/developers/mobile/targeting/proto/ClientSignalsProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 407, 2 -> 403, 3 -> 401, 4 -> 392, 5 -> 268, 6 -> 110, 7 -> 264, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/developers/mobile/targeting/proto/ClientSignalsProto$AppInstanceClaim.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/developers/mobile/targeting/proto/ClientSignalsProto$AppInstanceClaim
      //   72: monitorenter
      //   73: getstatic com/google/developers/mobile/targeting/proto/ClientSignalsProto$AppInstanceClaim.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/developers/mobile/targeting/proto/ClientSignalsProto$AppInstanceClaim.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/ClientSignalsProto$AppInstanceClaim;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/developers/mobile/targeting/proto/ClientSignalsProto$AppInstanceClaim.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/developers/mobile/targeting/proto/ClientSignalsProto$AppInstanceClaim
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/developers/mobile/targeting/proto/ClientSignalsProto$AppInstanceClaim
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/developers/mobile/targeting/proto/ClientSignalsProto$AppInstanceClaim.PARSER : Lcom/google/protobuf/Parser;
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
      //   143: if_icmpeq -> 197
      //   146: iload #5
      //   148: bipush #18
      //   150: if_icmpeq -> 186
      //   153: iload #5
      //   155: bipush #26
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
      //   180: putfield gmpAppId_ : Ljava/lang/String;
      //   183: goto -> 123
      //   186: aload_0
      //   187: aload_1
      //   188: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   191: putfield appInstanceToken_ : Ljava/lang/String;
      //   194: goto -> 123
      //   197: aload_0
      //   198: aload_1
      //   199: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   202: putfield appInstanceId_ : Ljava/lang/String;
      //   205: goto -> 123
      //   208: iconst_1
      //   209: istore #4
      //   211: goto -> 123
      //   214: astore_1
      //   215: goto -> 262
      //   218: astore_1
      //   219: new java/lang/RuntimeException
      //   222: astore_2
      //   223: new com/google/protobuf/InvalidProtocolBufferException
      //   226: astore_3
      //   227: aload_3
      //   228: aload_1
      //   229: invokevirtual getMessage : ()Ljava/lang/String;
      //   232: invokespecial <init> : (Ljava/lang/String;)V
      //   235: aload_2
      //   236: aload_3
      //   237: aload_0
      //   238: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   241: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   244: aload_2
      //   245: athrow
      //   246: astore_2
      //   247: new java/lang/RuntimeException
      //   250: astore_1
      //   251: aload_1
      //   252: aload_2
      //   253: aload_0
      //   254: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   257: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   260: aload_1
      //   261: athrow
      //   262: aload_1
      //   263: athrow
      //   264: getstatic com/google/developers/mobile/targeting/proto/ClientSignalsProto$AppInstanceClaim.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/ClientSignalsProto$AppInstanceClaim;
      //   267: areturn
      //   268: aload_2
      //   269: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   272: astore_1
      //   273: aload_3
      //   274: checkcast com/google/developers/mobile/targeting/proto/ClientSignalsProto$AppInstanceClaim
      //   277: astore_2
      //   278: aload_0
      //   279: aload_1
      //   280: aload_0
      //   281: getfield appInstanceId_ : Ljava/lang/String;
      //   284: invokevirtual isEmpty : ()Z
      //   287: iconst_1
      //   288: ixor
      //   289: aload_0
      //   290: getfield appInstanceId_ : Ljava/lang/String;
      //   293: aload_2
      //   294: getfield appInstanceId_ : Ljava/lang/String;
      //   297: invokevirtual isEmpty : ()Z
      //   300: iconst_1
      //   301: ixor
      //   302: aload_2
      //   303: getfield appInstanceId_ : Ljava/lang/String;
      //   306: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   311: putfield appInstanceId_ : Ljava/lang/String;
      //   314: aload_0
      //   315: aload_1
      //   316: aload_0
      //   317: getfield appInstanceToken_ : Ljava/lang/String;
      //   320: invokevirtual isEmpty : ()Z
      //   323: iconst_1
      //   324: ixor
      //   325: aload_0
      //   326: getfield appInstanceToken_ : Ljava/lang/String;
      //   329: aload_2
      //   330: getfield appInstanceToken_ : Ljava/lang/String;
      //   333: invokevirtual isEmpty : ()Z
      //   336: iconst_1
      //   337: ixor
      //   338: aload_2
      //   339: getfield appInstanceToken_ : Ljava/lang/String;
      //   342: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   347: putfield appInstanceToken_ : Ljava/lang/String;
      //   350: aload_0
      //   351: aload_1
      //   352: aload_0
      //   353: getfield gmpAppId_ : Ljava/lang/String;
      //   356: invokevirtual isEmpty : ()Z
      //   359: iconst_1
      //   360: ixor
      //   361: aload_0
      //   362: getfield gmpAppId_ : Ljava/lang/String;
      //   365: iconst_1
      //   366: aload_2
      //   367: getfield gmpAppId_ : Ljava/lang/String;
      //   370: invokevirtual isEmpty : ()Z
      //   373: ixor
      //   374: aload_2
      //   375: getfield gmpAppId_ : Ljava/lang/String;
      //   378: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   383: putfield gmpAppId_ : Ljava/lang/String;
      //   386: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   389: astore_1
      //   390: aload_0
      //   391: areturn
      //   392: new com/google/developers/mobile/targeting/proto/ClientSignalsProto$AppInstanceClaim$Builder
      //   395: dup
      //   396: aconst_null
      //   397: invokespecial <init> : (Lcom/google/developers/mobile/targeting/proto/ClientSignalsProto$1;)V
      //   400: areturn
      //   401: aconst_null
      //   402: areturn
      //   403: getstatic com/google/developers/mobile/targeting/proto/ClientSignalsProto$AppInstanceClaim.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/ClientSignalsProto$AppInstanceClaim;
      //   406: areturn
      //   407: new com/google/developers/mobile/targeting/proto/ClientSignalsProto$AppInstanceClaim
      //   410: dup
      //   411: invokespecial <init> : ()V
      //   414: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	246	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	218	java/io/IOException
      //   128	134	214	finally
      //   160	169	246	com/google/protobuf/InvalidProtocolBufferException
      //   160	169	218	java/io/IOException
      //   160	169	214	finally
      //   175	183	246	com/google/protobuf/InvalidProtocolBufferException
      //   175	183	218	java/io/IOException
      //   175	183	214	finally
      //   186	194	246	com/google/protobuf/InvalidProtocolBufferException
      //   186	194	218	java/io/IOException
      //   186	194	214	finally
      //   197	205	246	com/google/protobuf/InvalidProtocolBufferException
      //   197	205	218	java/io/IOException
      //   197	205	214	finally
      //   219	246	214	finally
      //   247	262	214	finally
    }
    
    public String getAppInstanceId() {
      return this.appInstanceId_;
    }
    
    public ByteString getAppInstanceIdBytes() {
      return ByteString.copyFromUtf8(this.appInstanceId_);
    }
    
    public String getAppInstanceToken() {
      return this.appInstanceToken_;
    }
    
    public ByteString getAppInstanceTokenBytes() {
      return ByteString.copyFromUtf8(this.appInstanceToken_);
    }
    
    public String getGmpAppId() {
      return this.gmpAppId_;
    }
    
    public ByteString getGmpAppIdBytes() {
      return ByteString.copyFromUtf8(this.gmpAppId_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (!this.appInstanceId_.isEmpty())
        j = 0 + CodedOutputStream.computeStringSize(1, getAppInstanceId()); 
      i = j;
      if (!this.appInstanceToken_.isEmpty())
        i = j + CodedOutputStream.computeStringSize(2, getAppInstanceToken()); 
      j = i;
      if (!this.gmpAppId_.isEmpty())
        j = i + CodedOutputStream.computeStringSize(3, getGmpAppId()); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.appInstanceId_.isEmpty())
        param1CodedOutputStream.writeString(1, getAppInstanceId()); 
      if (!this.appInstanceToken_.isEmpty())
        param1CodedOutputStream.writeString(2, getAppInstanceToken()); 
      if (!this.gmpAppId_.isEmpty())
        param1CodedOutputStream.writeString(3, getGmpAppId()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AppInstanceClaim, Builder> implements ClientSignalsProto.AppInstanceClaimOrBuilder {
      private Builder() {
        super(ClientSignalsProto.AppInstanceClaim.DEFAULT_INSTANCE);
      }
      
      public Builder clearAppInstanceId() {
        copyOnWrite();
        ((ClientSignalsProto.AppInstanceClaim)this.instance).clearAppInstanceId();
        return this;
      }
      
      public Builder clearAppInstanceToken() {
        copyOnWrite();
        ((ClientSignalsProto.AppInstanceClaim)this.instance).clearAppInstanceToken();
        return this;
      }
      
      public Builder clearGmpAppId() {
        copyOnWrite();
        ((ClientSignalsProto.AppInstanceClaim)this.instance).clearGmpAppId();
        return this;
      }
      
      public String getAppInstanceId() {
        return ((ClientSignalsProto.AppInstanceClaim)this.instance).getAppInstanceId();
      }
      
      public ByteString getAppInstanceIdBytes() {
        return ((ClientSignalsProto.AppInstanceClaim)this.instance).getAppInstanceIdBytes();
      }
      
      public String getAppInstanceToken() {
        return ((ClientSignalsProto.AppInstanceClaim)this.instance).getAppInstanceToken();
      }
      
      public ByteString getAppInstanceTokenBytes() {
        return ((ClientSignalsProto.AppInstanceClaim)this.instance).getAppInstanceTokenBytes();
      }
      
      public String getGmpAppId() {
        return ((ClientSignalsProto.AppInstanceClaim)this.instance).getGmpAppId();
      }
      
      public ByteString getGmpAppIdBytes() {
        return ((ClientSignalsProto.AppInstanceClaim)this.instance).getGmpAppIdBytes();
      }
      
      public Builder setAppInstanceId(String param2String) {
        copyOnWrite();
        ((ClientSignalsProto.AppInstanceClaim)this.instance).setAppInstanceId(param2String);
        return this;
      }
      
      public Builder setAppInstanceIdBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((ClientSignalsProto.AppInstanceClaim)this.instance).setAppInstanceIdBytes(param2ByteString);
        return this;
      }
      
      public Builder setAppInstanceToken(String param2String) {
        copyOnWrite();
        ((ClientSignalsProto.AppInstanceClaim)this.instance).setAppInstanceToken(param2String);
        return this;
      }
      
      public Builder setAppInstanceTokenBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((ClientSignalsProto.AppInstanceClaim)this.instance).setAppInstanceTokenBytes(param2ByteString);
        return this;
      }
      
      public Builder setGmpAppId(String param2String) {
        copyOnWrite();
        ((ClientSignalsProto.AppInstanceClaim)this.instance).setGmpAppId(param2String);
        return this;
      }
      
      public Builder setGmpAppIdBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((ClientSignalsProto.AppInstanceClaim)this.instance).setGmpAppIdBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<AppInstanceClaim, AppInstanceClaim.Builder> implements AppInstanceClaimOrBuilder {
    private Builder() {
      super(ClientSignalsProto.AppInstanceClaim.DEFAULT_INSTANCE);
    }
    
    public Builder clearAppInstanceId() {
      copyOnWrite();
      ((ClientSignalsProto.AppInstanceClaim)this.instance).clearAppInstanceId();
      return this;
    }
    
    public Builder clearAppInstanceToken() {
      copyOnWrite();
      ((ClientSignalsProto.AppInstanceClaim)this.instance).clearAppInstanceToken();
      return this;
    }
    
    public Builder clearGmpAppId() {
      copyOnWrite();
      ((ClientSignalsProto.AppInstanceClaim)this.instance).clearGmpAppId();
      return this;
    }
    
    public String getAppInstanceId() {
      return ((ClientSignalsProto.AppInstanceClaim)this.instance).getAppInstanceId();
    }
    
    public ByteString getAppInstanceIdBytes() {
      return ((ClientSignalsProto.AppInstanceClaim)this.instance).getAppInstanceIdBytes();
    }
    
    public String getAppInstanceToken() {
      return ((ClientSignalsProto.AppInstanceClaim)this.instance).getAppInstanceToken();
    }
    
    public ByteString getAppInstanceTokenBytes() {
      return ((ClientSignalsProto.AppInstanceClaim)this.instance).getAppInstanceTokenBytes();
    }
    
    public String getGmpAppId() {
      return ((ClientSignalsProto.AppInstanceClaim)this.instance).getGmpAppId();
    }
    
    public ByteString getGmpAppIdBytes() {
      return ((ClientSignalsProto.AppInstanceClaim)this.instance).getGmpAppIdBytes();
    }
    
    public Builder setAppInstanceId(String param1String) {
      copyOnWrite();
      ((ClientSignalsProto.AppInstanceClaim)this.instance).setAppInstanceId(param1String);
      return this;
    }
    
    public Builder setAppInstanceIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ClientSignalsProto.AppInstanceClaim)this.instance).setAppInstanceIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setAppInstanceToken(String param1String) {
      copyOnWrite();
      ((ClientSignalsProto.AppInstanceClaim)this.instance).setAppInstanceToken(param1String);
      return this;
    }
    
    public Builder setAppInstanceTokenBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ClientSignalsProto.AppInstanceClaim)this.instance).setAppInstanceTokenBytes(param1ByteString);
      return this;
    }
    
    public Builder setGmpAppId(String param1String) {
      copyOnWrite();
      ((ClientSignalsProto.AppInstanceClaim)this.instance).setGmpAppId(param1String);
      return this;
    }
    
    public Builder setGmpAppIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ClientSignalsProto.AppInstanceClaim)this.instance).setGmpAppIdBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface AppInstanceClaimOrBuilder extends MessageLiteOrBuilder {
    String getAppInstanceId();
    
    ByteString getAppInstanceIdBytes();
    
    String getAppInstanceToken();
    
    ByteString getAppInstanceTokenBytes();
    
    String getGmpAppId();
    
    ByteString getGmpAppIdBytes();
  }
  
  public static final class ClientSignals extends GeneratedMessageLite<ClientSignals, ClientSignals.Builder> implements ClientSignalsOrBuilder {
    public static final int APP_VERSION_FIELD_NUMBER = 1;
    
    private static final ClientSignals DEFAULT_INSTANCE = new ClientSignals();
    
    public static final int LANGUAGE_CODE_FIELD_NUMBER = 3;
    
    private static volatile Parser<ClientSignals> PARSER;
    
    public static final int PLATFORM_VERSION_FIELD_NUMBER = 2;
    
    public static final int TIME_ZONE_FIELD_NUMBER = 4;
    
    private String appVersion_ = "";
    
    private String languageCode_ = "";
    
    private String platformVersion_ = "";
    
    private String timeZone_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearAppVersion() {
      this.appVersion_ = getDefaultInstance().getAppVersion();
    }
    
    private void clearLanguageCode() {
      this.languageCode_ = getDefaultInstance().getLanguageCode();
    }
    
    private void clearPlatformVersion() {
      this.platformVersion_ = getDefaultInstance().getPlatformVersion();
    }
    
    private void clearTimeZone() {
      this.timeZone_ = getDefaultInstance().getTimeZone();
    }
    
    public static ClientSignals getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ClientSignals param1ClientSignals) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1ClientSignals);
    }
    
    public static ClientSignals parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (ClientSignals)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static ClientSignals parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ClientSignals)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ClientSignals parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (ClientSignals)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static ClientSignals parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ClientSignals)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static ClientSignals parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (ClientSignals)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static ClientSignals parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ClientSignals)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static ClientSignals parseFrom(InputStream param1InputStream) throws IOException {
      return (ClientSignals)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static ClientSignals parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ClientSignals)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ClientSignals parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (ClientSignals)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static ClientSignals parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ClientSignals)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<ClientSignals> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setAppVersion(String param1String) {
      if (param1String != null) {
        this.appVersion_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAppVersionBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.appVersion_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setLanguageCode(String param1String) {
      if (param1String != null) {
        this.languageCode_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setLanguageCodeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.languageCode_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setPlatformVersion(String param1String) {
      if (param1String != null) {
        this.platformVersion_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setPlatformVersionBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.platformVersion_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTimeZone(String param1String) {
      if (param1String != null) {
        this.timeZone_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTimeZoneBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.timeZone_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/developers/mobile/targeting/proto/ClientSignalsProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 461, 2 -> 457, 3 -> 455, 4 -> 446, 5 -> 286, 6 -> 110, 7 -> 282, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals
      //   72: monitorenter
      //   73: getstatic com/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals.PARSER : Lcom/google/protobuf/Parser;
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
      //   143: if_icmpeq -> 215
      //   146: iload #5
      //   148: bipush #18
      //   150: if_icmpeq -> 204
      //   153: iload #5
      //   155: bipush #26
      //   157: if_icmpeq -> 193
      //   160: iload #5
      //   162: bipush #34
      //   164: if_icmpeq -> 182
      //   167: aload_1
      //   168: iload #5
      //   170: invokevirtual skipField : (I)Z
      //   173: ifne -> 123
      //   176: iconst_1
      //   177: istore #4
      //   179: goto -> 123
      //   182: aload_0
      //   183: aload_1
      //   184: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   187: putfield timeZone_ : Ljava/lang/String;
      //   190: goto -> 123
      //   193: aload_0
      //   194: aload_1
      //   195: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   198: putfield languageCode_ : Ljava/lang/String;
      //   201: goto -> 123
      //   204: aload_0
      //   205: aload_1
      //   206: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   209: putfield platformVersion_ : Ljava/lang/String;
      //   212: goto -> 123
      //   215: aload_0
      //   216: aload_1
      //   217: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   220: putfield appVersion_ : Ljava/lang/String;
      //   223: goto -> 123
      //   226: iconst_1
      //   227: istore #4
      //   229: goto -> 123
      //   232: astore_1
      //   233: goto -> 280
      //   236: astore_2
      //   237: new java/lang/RuntimeException
      //   240: astore_3
      //   241: new com/google/protobuf/InvalidProtocolBufferException
      //   244: astore_1
      //   245: aload_1
      //   246: aload_2
      //   247: invokevirtual getMessage : ()Ljava/lang/String;
      //   250: invokespecial <init> : (Ljava/lang/String;)V
      //   253: aload_3
      //   254: aload_1
      //   255: aload_0
      //   256: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   259: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   262: aload_3
      //   263: athrow
      //   264: astore_1
      //   265: new java/lang/RuntimeException
      //   268: astore_2
      //   269: aload_2
      //   270: aload_1
      //   271: aload_0
      //   272: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   275: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   278: aload_2
      //   279: athrow
      //   280: aload_1
      //   281: athrow
      //   282: getstatic com/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals;
      //   285: areturn
      //   286: aload_2
      //   287: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   290: astore_1
      //   291: aload_3
      //   292: checkcast com/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals
      //   295: astore_2
      //   296: aload_0
      //   297: aload_1
      //   298: aload_0
      //   299: getfield appVersion_ : Ljava/lang/String;
      //   302: invokevirtual isEmpty : ()Z
      //   305: iconst_1
      //   306: ixor
      //   307: aload_0
      //   308: getfield appVersion_ : Ljava/lang/String;
      //   311: aload_2
      //   312: getfield appVersion_ : Ljava/lang/String;
      //   315: invokevirtual isEmpty : ()Z
      //   318: iconst_1
      //   319: ixor
      //   320: aload_2
      //   321: getfield appVersion_ : Ljava/lang/String;
      //   324: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   329: putfield appVersion_ : Ljava/lang/String;
      //   332: aload_0
      //   333: aload_1
      //   334: aload_0
      //   335: getfield platformVersion_ : Ljava/lang/String;
      //   338: invokevirtual isEmpty : ()Z
      //   341: iconst_1
      //   342: ixor
      //   343: aload_0
      //   344: getfield platformVersion_ : Ljava/lang/String;
      //   347: aload_2
      //   348: getfield platformVersion_ : Ljava/lang/String;
      //   351: invokevirtual isEmpty : ()Z
      //   354: iconst_1
      //   355: ixor
      //   356: aload_2
      //   357: getfield platformVersion_ : Ljava/lang/String;
      //   360: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   365: putfield platformVersion_ : Ljava/lang/String;
      //   368: aload_0
      //   369: aload_1
      //   370: aload_0
      //   371: getfield languageCode_ : Ljava/lang/String;
      //   374: invokevirtual isEmpty : ()Z
      //   377: iconst_1
      //   378: ixor
      //   379: aload_0
      //   380: getfield languageCode_ : Ljava/lang/String;
      //   383: aload_2
      //   384: getfield languageCode_ : Ljava/lang/String;
      //   387: invokevirtual isEmpty : ()Z
      //   390: iconst_1
      //   391: ixor
      //   392: aload_2
      //   393: getfield languageCode_ : Ljava/lang/String;
      //   396: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   401: putfield languageCode_ : Ljava/lang/String;
      //   404: aload_0
      //   405: aload_1
      //   406: aload_0
      //   407: getfield timeZone_ : Ljava/lang/String;
      //   410: invokevirtual isEmpty : ()Z
      //   413: iconst_1
      //   414: ixor
      //   415: aload_0
      //   416: getfield timeZone_ : Ljava/lang/String;
      //   419: iconst_1
      //   420: aload_2
      //   421: getfield timeZone_ : Ljava/lang/String;
      //   424: invokevirtual isEmpty : ()Z
      //   427: ixor
      //   428: aload_2
      //   429: getfield timeZone_ : Ljava/lang/String;
      //   432: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   437: putfield timeZone_ : Ljava/lang/String;
      //   440: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   443: astore_1
      //   444: aload_0
      //   445: areturn
      //   446: new com/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals$Builder
      //   449: dup
      //   450: aconst_null
      //   451: invokespecial <init> : (Lcom/google/developers/mobile/targeting/proto/ClientSignalsProto$1;)V
      //   454: areturn
      //   455: aconst_null
      //   456: areturn
      //   457: getstatic com/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals.DEFAULT_INSTANCE : Lcom/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals;
      //   460: areturn
      //   461: new com/google/developers/mobile/targeting/proto/ClientSignalsProto$ClientSignals
      //   464: dup
      //   465: invokespecial <init> : ()V
      //   468: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	264	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	236	java/io/IOException
      //   128	134	232	finally
      //   167	176	264	com/google/protobuf/InvalidProtocolBufferException
      //   167	176	236	java/io/IOException
      //   167	176	232	finally
      //   182	190	264	com/google/protobuf/InvalidProtocolBufferException
      //   182	190	236	java/io/IOException
      //   182	190	232	finally
      //   193	201	264	com/google/protobuf/InvalidProtocolBufferException
      //   193	201	236	java/io/IOException
      //   193	201	232	finally
      //   204	212	264	com/google/protobuf/InvalidProtocolBufferException
      //   204	212	236	java/io/IOException
      //   204	212	232	finally
      //   215	223	264	com/google/protobuf/InvalidProtocolBufferException
      //   215	223	236	java/io/IOException
      //   215	223	232	finally
      //   237	264	232	finally
      //   265	280	232	finally
    }
    
    public String getAppVersion() {
      return this.appVersion_;
    }
    
    public ByteString getAppVersionBytes() {
      return ByteString.copyFromUtf8(this.appVersion_);
    }
    
    public String getLanguageCode() {
      return this.languageCode_;
    }
    
    public ByteString getLanguageCodeBytes() {
      return ByteString.copyFromUtf8(this.languageCode_);
    }
    
    public String getPlatformVersion() {
      return this.platformVersion_;
    }
    
    public ByteString getPlatformVersionBytes() {
      return ByteString.copyFromUtf8(this.platformVersion_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (!this.appVersion_.isEmpty())
        i = 0 + CodedOutputStream.computeStringSize(1, getAppVersion()); 
      int j = i;
      if (!this.platformVersion_.isEmpty())
        j = i + CodedOutputStream.computeStringSize(2, getPlatformVersion()); 
      i = j;
      if (!this.languageCode_.isEmpty())
        i = j + CodedOutputStream.computeStringSize(3, getLanguageCode()); 
      j = i;
      if (!this.timeZone_.isEmpty())
        j = i + CodedOutputStream.computeStringSize(4, getTimeZone()); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public String getTimeZone() {
      return this.timeZone_;
    }
    
    public ByteString getTimeZoneBytes() {
      return ByteString.copyFromUtf8(this.timeZone_);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.appVersion_.isEmpty())
        param1CodedOutputStream.writeString(1, getAppVersion()); 
      if (!this.platformVersion_.isEmpty())
        param1CodedOutputStream.writeString(2, getPlatformVersion()); 
      if (!this.languageCode_.isEmpty())
        param1CodedOutputStream.writeString(3, getLanguageCode()); 
      if (!this.timeZone_.isEmpty())
        param1CodedOutputStream.writeString(4, getTimeZone()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<ClientSignals, Builder> implements ClientSignalsProto.ClientSignalsOrBuilder {
      private Builder() {
        super(ClientSignalsProto.ClientSignals.DEFAULT_INSTANCE);
      }
      
      public Builder clearAppVersion() {
        copyOnWrite();
        ((ClientSignalsProto.ClientSignals)this.instance).clearAppVersion();
        return this;
      }
      
      public Builder clearLanguageCode() {
        copyOnWrite();
        ((ClientSignalsProto.ClientSignals)this.instance).clearLanguageCode();
        return this;
      }
      
      public Builder clearPlatformVersion() {
        copyOnWrite();
        ((ClientSignalsProto.ClientSignals)this.instance).clearPlatformVersion();
        return this;
      }
      
      public Builder clearTimeZone() {
        copyOnWrite();
        ((ClientSignalsProto.ClientSignals)this.instance).clearTimeZone();
        return this;
      }
      
      public String getAppVersion() {
        return ((ClientSignalsProto.ClientSignals)this.instance).getAppVersion();
      }
      
      public ByteString getAppVersionBytes() {
        return ((ClientSignalsProto.ClientSignals)this.instance).getAppVersionBytes();
      }
      
      public String getLanguageCode() {
        return ((ClientSignalsProto.ClientSignals)this.instance).getLanguageCode();
      }
      
      public ByteString getLanguageCodeBytes() {
        return ((ClientSignalsProto.ClientSignals)this.instance).getLanguageCodeBytes();
      }
      
      public String getPlatformVersion() {
        return ((ClientSignalsProto.ClientSignals)this.instance).getPlatformVersion();
      }
      
      public ByteString getPlatformVersionBytes() {
        return ((ClientSignalsProto.ClientSignals)this.instance).getPlatformVersionBytes();
      }
      
      public String getTimeZone() {
        return ((ClientSignalsProto.ClientSignals)this.instance).getTimeZone();
      }
      
      public ByteString getTimeZoneBytes() {
        return ((ClientSignalsProto.ClientSignals)this.instance).getTimeZoneBytes();
      }
      
      public Builder setAppVersion(String param2String) {
        copyOnWrite();
        ((ClientSignalsProto.ClientSignals)this.instance).setAppVersion(param2String);
        return this;
      }
      
      public Builder setAppVersionBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((ClientSignalsProto.ClientSignals)this.instance).setAppVersionBytes(param2ByteString);
        return this;
      }
      
      public Builder setLanguageCode(String param2String) {
        copyOnWrite();
        ((ClientSignalsProto.ClientSignals)this.instance).setLanguageCode(param2String);
        return this;
      }
      
      public Builder setLanguageCodeBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((ClientSignalsProto.ClientSignals)this.instance).setLanguageCodeBytes(param2ByteString);
        return this;
      }
      
      public Builder setPlatformVersion(String param2String) {
        copyOnWrite();
        ((ClientSignalsProto.ClientSignals)this.instance).setPlatformVersion(param2String);
        return this;
      }
      
      public Builder setPlatformVersionBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((ClientSignalsProto.ClientSignals)this.instance).setPlatformVersionBytes(param2ByteString);
        return this;
      }
      
      public Builder setTimeZone(String param2String) {
        copyOnWrite();
        ((ClientSignalsProto.ClientSignals)this.instance).setTimeZone(param2String);
        return this;
      }
      
      public Builder setTimeZoneBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((ClientSignalsProto.ClientSignals)this.instance).setTimeZoneBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ClientSignals, ClientSignals.Builder> implements ClientSignalsOrBuilder {
    private Builder() {
      super(ClientSignalsProto.ClientSignals.DEFAULT_INSTANCE);
    }
    
    public Builder clearAppVersion() {
      copyOnWrite();
      ((ClientSignalsProto.ClientSignals)this.instance).clearAppVersion();
      return this;
    }
    
    public Builder clearLanguageCode() {
      copyOnWrite();
      ((ClientSignalsProto.ClientSignals)this.instance).clearLanguageCode();
      return this;
    }
    
    public Builder clearPlatformVersion() {
      copyOnWrite();
      ((ClientSignalsProto.ClientSignals)this.instance).clearPlatformVersion();
      return this;
    }
    
    public Builder clearTimeZone() {
      copyOnWrite();
      ((ClientSignalsProto.ClientSignals)this.instance).clearTimeZone();
      return this;
    }
    
    public String getAppVersion() {
      return ((ClientSignalsProto.ClientSignals)this.instance).getAppVersion();
    }
    
    public ByteString getAppVersionBytes() {
      return ((ClientSignalsProto.ClientSignals)this.instance).getAppVersionBytes();
    }
    
    public String getLanguageCode() {
      return ((ClientSignalsProto.ClientSignals)this.instance).getLanguageCode();
    }
    
    public ByteString getLanguageCodeBytes() {
      return ((ClientSignalsProto.ClientSignals)this.instance).getLanguageCodeBytes();
    }
    
    public String getPlatformVersion() {
      return ((ClientSignalsProto.ClientSignals)this.instance).getPlatformVersion();
    }
    
    public ByteString getPlatformVersionBytes() {
      return ((ClientSignalsProto.ClientSignals)this.instance).getPlatformVersionBytes();
    }
    
    public String getTimeZone() {
      return ((ClientSignalsProto.ClientSignals)this.instance).getTimeZone();
    }
    
    public ByteString getTimeZoneBytes() {
      return ((ClientSignalsProto.ClientSignals)this.instance).getTimeZoneBytes();
    }
    
    public Builder setAppVersion(String param1String) {
      copyOnWrite();
      ((ClientSignalsProto.ClientSignals)this.instance).setAppVersion(param1String);
      return this;
    }
    
    public Builder setAppVersionBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ClientSignalsProto.ClientSignals)this.instance).setAppVersionBytes(param1ByteString);
      return this;
    }
    
    public Builder setLanguageCode(String param1String) {
      copyOnWrite();
      ((ClientSignalsProto.ClientSignals)this.instance).setLanguageCode(param1String);
      return this;
    }
    
    public Builder setLanguageCodeBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ClientSignalsProto.ClientSignals)this.instance).setLanguageCodeBytes(param1ByteString);
      return this;
    }
    
    public Builder setPlatformVersion(String param1String) {
      copyOnWrite();
      ((ClientSignalsProto.ClientSignals)this.instance).setPlatformVersion(param1String);
      return this;
    }
    
    public Builder setPlatformVersionBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ClientSignalsProto.ClientSignals)this.instance).setPlatformVersionBytes(param1ByteString);
      return this;
    }
    
    public Builder setTimeZone(String param1String) {
      copyOnWrite();
      ((ClientSignalsProto.ClientSignals)this.instance).setTimeZone(param1String);
      return this;
    }
    
    public Builder setTimeZoneBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ClientSignalsProto.ClientSignals)this.instance).setTimeZoneBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface ClientSignalsOrBuilder extends MessageLiteOrBuilder {
    String getAppVersion();
    
    ByteString getAppVersionBytes();
    
    String getLanguageCode();
    
    ByteString getLanguageCodeBytes();
    
    String getPlatformVersion();
    
    ByteString getPlatformVersionBytes();
    
    String getTimeZone();
    
    ByteString getTimeZoneBytes();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\developers\mobile\targeting\proto\ClientSignalsProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */