package analytics_collection;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class GmpMeasurementPublic {
  static {
  
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class FirebaseAnalyticsApiRequest extends GeneratedMessageLite<FirebaseAnalyticsApiRequest, FirebaseAnalyticsApiRequest.Builder> implements FirebaseAnalyticsApiRequestOrBuilder {
    public static final int API_KEY_FIELD_NUMBER = 18;
    
    public static final int APP_ID_FIELD_NUMBER = 1;
    
    public static final int APP_INSTANCE_ID_FIELD_NUMBER = 6;
    
    public static final int APP_STORE_FIELD_NUMBER = 15;
    
    public static final int APP_VERSION_MAJOR_FIELD_NUMBER = 3;
    
    public static final int APP_VERSION_MINOR_FIELD_NUMBER = 4;
    
    public static final int APP_VERSION_RELEASE_FIELD_NUMBER = 5;
    
    private static final FirebaseAnalyticsApiRequest DEFAULT_INSTANCE = new FirebaseAnalyticsApiRequest();
    
    public static final int DEVICE_MODEL_FIELD_NUMBER = 12;
    
    public static final int EVENT_FIELD_NUMBER = 16;
    
    public static final int IP_ADDRESS_FIELD_NUMBER = 19;
    
    public static final int LIMITED_AD_TRACKING_FIELD_NUMBER = 9;
    
    public static final int OS_VERSION_FIELD_NUMBER = 11;
    
    public static final int PACKAGE_NAME_FIELD_NUMBER = 2;
    
    private static volatile Parser<FirebaseAnalyticsApiRequest> PARSER;
    
    public static final int PLATFORM_FIELD_NUMBER = 10;
    
    public static final int RESETTABLE_DEVICE_ID_FIELD_NUMBER = 7;
    
    public static final int UPLOAD_TIMESTAMP_MILLIS_FIELD_NUMBER = 14;
    
    public static final int USER_DEFAULT_LANGUAGE_FIELD_NUMBER = 13;
    
    public static final int USER_PROPERTY_FIELD_NUMBER = 17;
    
    public static final int VENDOR_DEVICE_ID_FIELD_NUMBER = 8;
    
    private String apiKey_ = "";
    
    private String appId_ = "";
    
    private String appInstanceId_ = "";
    
    private String appStore_ = "";
    
    private int appVersionMajor_;
    
    private int appVersionMinor_;
    
    private int appVersionRelease_;
    
    private int bitField0_;
    
    private String deviceModel_ = "";
    
    private Internal.ProtobufList<GmpMeasurementPublic.FirebaseAnalyticsEvent> event_ = emptyProtobufList();
    
    private String ipAddress_ = "";
    
    private boolean limitedAdTracking_;
    
    private String osVersion_ = "";
    
    private String packageName_ = "";
    
    private String platform_ = "";
    
    private String resettableDeviceId_ = "";
    
    private long uploadTimestampMillis_;
    
    private String userDefaultLanguage_ = "";
    
    private Internal.ProtobufList<GmpMeasurementPublic.FirebaseAnalyticsUserAttribute> userProperty_ = emptyProtobufList();
    
    private String vendorDeviceId_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllEvent(Iterable<? extends GmpMeasurementPublic.FirebaseAnalyticsEvent> param1Iterable) {
      ensureEventIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.event_);
    }
    
    private void addAllUserProperty(Iterable<? extends GmpMeasurementPublic.FirebaseAnalyticsUserAttribute> param1Iterable) {
      ensureUserPropertyIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.userProperty_);
    }
    
    private void addEvent(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsEvent.Builder param1Builder) {
      ensureEventIsMutable();
      this.event_.add(param1Int, param1Builder.build());
    }
    
    private void addEvent(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsEvent param1FirebaseAnalyticsEvent) {
      if (param1FirebaseAnalyticsEvent != null) {
        ensureEventIsMutable();
        this.event_.add(param1Int, param1FirebaseAnalyticsEvent);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addEvent(GmpMeasurementPublic.FirebaseAnalyticsEvent.Builder param1Builder) {
      ensureEventIsMutable();
      this.event_.add(param1Builder.build());
    }
    
    private void addEvent(GmpMeasurementPublic.FirebaseAnalyticsEvent param1FirebaseAnalyticsEvent) {
      if (param1FirebaseAnalyticsEvent != null) {
        ensureEventIsMutable();
        this.event_.add(param1FirebaseAnalyticsEvent);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addUserProperty(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsUserAttribute.Builder param1Builder) {
      ensureUserPropertyIsMutable();
      this.userProperty_.add(param1Int, param1Builder.build());
    }
    
    private void addUserProperty(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsUserAttribute param1FirebaseAnalyticsUserAttribute) {
      if (param1FirebaseAnalyticsUserAttribute != null) {
        ensureUserPropertyIsMutable();
        this.userProperty_.add(param1Int, param1FirebaseAnalyticsUserAttribute);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addUserProperty(GmpMeasurementPublic.FirebaseAnalyticsUserAttribute.Builder param1Builder) {
      ensureUserPropertyIsMutable();
      this.userProperty_.add(param1Builder.build());
    }
    
    private void addUserProperty(GmpMeasurementPublic.FirebaseAnalyticsUserAttribute param1FirebaseAnalyticsUserAttribute) {
      if (param1FirebaseAnalyticsUserAttribute != null) {
        ensureUserPropertyIsMutable();
        this.userProperty_.add(param1FirebaseAnalyticsUserAttribute);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearApiKey() {
      this.bitField0_ &= 0xFFFF7FFF;
      this.apiKey_ = getDefaultInstance().getApiKey();
    }
    
    private void clearAppId() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.appId_ = getDefaultInstance().getAppId();
    }
    
    private void clearAppInstanceId() {
      this.bitField0_ &= 0xFFFFFFDF;
      this.appInstanceId_ = getDefaultInstance().getAppInstanceId();
    }
    
    private void clearAppStore() {
      this.bitField0_ &= 0xFFFFBFFF;
      this.appStore_ = getDefaultInstance().getAppStore();
    }
    
    private void clearAppVersionMajor() {
      this.bitField0_ &= 0xFFFFFFFB;
      this.appVersionMajor_ = 0;
    }
    
    private void clearAppVersionMinor() {
      this.bitField0_ &= 0xFFFFFFF7;
      this.appVersionMinor_ = 0;
    }
    
    private void clearAppVersionRelease() {
      this.bitField0_ &= 0xFFFFFFEF;
      this.appVersionRelease_ = 0;
    }
    
    private void clearDeviceModel() {
      this.bitField0_ &= 0xFFFFF7FF;
      this.deviceModel_ = getDefaultInstance().getDeviceModel();
    }
    
    private void clearEvent() {
      this.event_ = emptyProtobufList();
    }
    
    private void clearIpAddress() {
      this.bitField0_ &= 0xFFFEFFFF;
      this.ipAddress_ = getDefaultInstance().getIpAddress();
    }
    
    private void clearLimitedAdTracking() {
      this.bitField0_ &= 0xFFFFFEFF;
      this.limitedAdTracking_ = false;
    }
    
    private void clearOsVersion() {
      this.bitField0_ &= 0xFFFFFBFF;
      this.osVersion_ = getDefaultInstance().getOsVersion();
    }
    
    private void clearPackageName() {
      this.bitField0_ &= 0xFFFFFFFD;
      this.packageName_ = getDefaultInstance().getPackageName();
    }
    
    private void clearPlatform() {
      this.bitField0_ &= 0xFFFFFDFF;
      this.platform_ = getDefaultInstance().getPlatform();
    }
    
    private void clearResettableDeviceId() {
      this.bitField0_ &= 0xFFFFFFBF;
      this.resettableDeviceId_ = getDefaultInstance().getResettableDeviceId();
    }
    
    private void clearUploadTimestampMillis() {
      this.bitField0_ &= 0xFFFFDFFF;
      this.uploadTimestampMillis_ = 0L;
    }
    
    private void clearUserDefaultLanguage() {
      this.bitField0_ &= 0xFFFFEFFF;
      this.userDefaultLanguage_ = getDefaultInstance().getUserDefaultLanguage();
    }
    
    private void clearUserProperty() {
      this.userProperty_ = emptyProtobufList();
    }
    
    private void clearVendorDeviceId() {
      this.bitField0_ &= 0xFFFFFF7F;
      this.vendorDeviceId_ = getDefaultInstance().getVendorDeviceId();
    }
    
    private void ensureEventIsMutable() {
      if (!this.event_.isModifiable())
        this.event_ = GeneratedMessageLite.mutableCopy(this.event_); 
    }
    
    private void ensureUserPropertyIsMutable() {
      if (!this.userProperty_.isModifiable())
        this.userProperty_ = GeneratedMessageLite.mutableCopy(this.userProperty_); 
    }
    
    public static FirebaseAnalyticsApiRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(FirebaseAnalyticsApiRequest param1FirebaseAnalyticsApiRequest) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1FirebaseAnalyticsApiRequest);
    }
    
    public static FirebaseAnalyticsApiRequest parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (FirebaseAnalyticsApiRequest)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static FirebaseAnalyticsApiRequest parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FirebaseAnalyticsApiRequest)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FirebaseAnalyticsApiRequest parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (FirebaseAnalyticsApiRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static FirebaseAnalyticsApiRequest parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FirebaseAnalyticsApiRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static FirebaseAnalyticsApiRequest parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (FirebaseAnalyticsApiRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static FirebaseAnalyticsApiRequest parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FirebaseAnalyticsApiRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static FirebaseAnalyticsApiRequest parseFrom(InputStream param1InputStream) throws IOException {
      return (FirebaseAnalyticsApiRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static FirebaseAnalyticsApiRequest parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FirebaseAnalyticsApiRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FirebaseAnalyticsApiRequest parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (FirebaseAnalyticsApiRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static FirebaseAnalyticsApiRequest parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FirebaseAnalyticsApiRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<FirebaseAnalyticsApiRequest> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeEvent(int param1Int) {
      ensureEventIsMutable();
      this.event_.remove(param1Int);
    }
    
    private void removeUserProperty(int param1Int) {
      ensureUserPropertyIsMutable();
      this.userProperty_.remove(param1Int);
    }
    
    private void setApiKey(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x8000;
        this.apiKey_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setApiKeyBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x8000;
        this.apiKey_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAppId(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x1;
        this.appId_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAppIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x1;
        this.appId_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAppInstanceId(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x20;
        this.appInstanceId_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAppInstanceIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x20;
        this.appInstanceId_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAppStore(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x4000;
        this.appStore_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAppStoreBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x4000;
        this.appStore_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setAppVersionMajor(int param1Int) {
      this.bitField0_ |= 0x4;
      this.appVersionMajor_ = param1Int;
    }
    
    private void setAppVersionMinor(int param1Int) {
      this.bitField0_ |= 0x8;
      this.appVersionMinor_ = param1Int;
    }
    
    private void setAppVersionRelease(int param1Int) {
      this.bitField0_ |= 0x10;
      this.appVersionRelease_ = param1Int;
    }
    
    private void setDeviceModel(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x800;
        this.deviceModel_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setDeviceModelBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x800;
        this.deviceModel_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setEvent(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsEvent.Builder param1Builder) {
      ensureEventIsMutable();
      this.event_.set(param1Int, param1Builder.build());
    }
    
    private void setEvent(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsEvent param1FirebaseAnalyticsEvent) {
      if (param1FirebaseAnalyticsEvent != null) {
        ensureEventIsMutable();
        this.event_.set(param1Int, param1FirebaseAnalyticsEvent);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setIpAddress(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x10000;
        this.ipAddress_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setIpAddressBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x10000;
        this.ipAddress_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setLimitedAdTracking(boolean param1Boolean) {
      this.bitField0_ |= 0x100;
      this.limitedAdTracking_ = param1Boolean;
    }
    
    private void setOsVersion(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x400;
        this.osVersion_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setOsVersionBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x400;
        this.osVersion_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setPackageName(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x2;
        this.packageName_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setPackageNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x2;
        this.packageName_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setPlatform(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x200;
        this.platform_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setPlatformBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x200;
        this.platform_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setResettableDeviceId(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x40;
        this.resettableDeviceId_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setResettableDeviceIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x40;
        this.resettableDeviceId_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setUploadTimestampMillis(long param1Long) {
      this.bitField0_ |= 0x2000;
      this.uploadTimestampMillis_ = param1Long;
    }
    
    private void setUserDefaultLanguage(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x1000;
        this.userDefaultLanguage_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setUserDefaultLanguageBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x1000;
        this.userDefaultLanguage_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setUserProperty(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsUserAttribute.Builder param1Builder) {
      ensureUserPropertyIsMutable();
      this.userProperty_.set(param1Int, param1Builder.build());
    }
    
    private void setUserProperty(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsUserAttribute param1FirebaseAnalyticsUserAttribute) {
      if (param1FirebaseAnalyticsUserAttribute != null) {
        ensureUserPropertyIsMutable();
        this.userProperty_.set(param1Int, param1FirebaseAnalyticsUserAttribute);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setVendorDeviceId(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x80;
        this.vendorDeviceId_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setVendorDeviceIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x80;
        this.vendorDeviceId_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic analytics_collection/GmpMeasurementPublic$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 1433, 2 -> 1429, 3 -> 1409, 4 -> 1400, 5 -> 890, 6 -> 110, 7 -> 886, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsApiRequest.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsApiRequest
      //   72: monitorenter
      //   73: getstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsApiRequest.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsApiRequest.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurementPublic$FirebaseAnalyticsApiRequest;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsApiRequest.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsApiRequest
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsApiRequest
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsApiRequest.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 886
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: lookupswitch default -> 308, 0 -> 819, 10 -> 796, 18 -> 773, 24 -> 752, 32 -> 730, 40 -> 708, 50 -> 684, 58 -> 660, 66 -> 635, 72 -> 612, 82 -> 587, 90 -> 562, 98 -> 537, 106 -> 512, 112 -> 489, 122 -> 464, 130 -> 417, 138 -> 370, 146 -> 345, 154 -> 320
      //   308: aload_0
      //   309: iload #5
      //   311: aload_1
      //   312: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   315: istore #6
      //   317: goto -> 825
      //   320: aload_1
      //   321: invokevirtual readString : ()Ljava/lang/String;
      //   324: astore_3
      //   325: aload_0
      //   326: aload_0
      //   327: getfield bitField0_ : I
      //   330: ldc_w 65536
      //   333: ior
      //   334: putfield bitField0_ : I
      //   337: aload_0
      //   338: aload_3
      //   339: putfield ipAddress_ : Ljava/lang/String;
      //   342: goto -> 123
      //   345: aload_1
      //   346: invokevirtual readString : ()Ljava/lang/String;
      //   349: astore_3
      //   350: aload_0
      //   351: aload_0
      //   352: getfield bitField0_ : I
      //   355: ldc_w 32768
      //   358: ior
      //   359: putfield bitField0_ : I
      //   362: aload_0
      //   363: aload_3
      //   364: putfield apiKey_ : Ljava/lang/String;
      //   367: goto -> 123
      //   370: aload_0
      //   371: getfield userProperty_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   374: invokeinterface isModifiable : ()Z
      //   379: ifne -> 393
      //   382: aload_0
      //   383: aload_0
      //   384: getfield userProperty_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   387: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   390: putfield userProperty_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   393: aload_0
      //   394: getfield userProperty_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   397: aload_1
      //   398: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   401: aload_2
      //   402: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   405: checkcast analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsUserAttribute
      //   408: invokeinterface add : (Ljava/lang/Object;)Z
      //   413: pop
      //   414: goto -> 123
      //   417: aload_0
      //   418: getfield event_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   421: invokeinterface isModifiable : ()Z
      //   426: ifne -> 440
      //   429: aload_0
      //   430: aload_0
      //   431: getfield event_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   434: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   437: putfield event_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   440: aload_0
      //   441: getfield event_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   444: aload_1
      //   445: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   448: aload_2
      //   449: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   452: checkcast analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEvent
      //   455: invokeinterface add : (Ljava/lang/Object;)Z
      //   460: pop
      //   461: goto -> 123
      //   464: aload_1
      //   465: invokevirtual readString : ()Ljava/lang/String;
      //   468: astore_3
      //   469: aload_0
      //   470: aload_0
      //   471: getfield bitField0_ : I
      //   474: sipush #16384
      //   477: ior
      //   478: putfield bitField0_ : I
      //   481: aload_0
      //   482: aload_3
      //   483: putfield appStore_ : Ljava/lang/String;
      //   486: goto -> 123
      //   489: aload_0
      //   490: aload_0
      //   491: getfield bitField0_ : I
      //   494: sipush #8192
      //   497: ior
      //   498: putfield bitField0_ : I
      //   501: aload_0
      //   502: aload_1
      //   503: invokevirtual readInt64 : ()J
      //   506: putfield uploadTimestampMillis_ : J
      //   509: goto -> 123
      //   512: aload_1
      //   513: invokevirtual readString : ()Ljava/lang/String;
      //   516: astore_3
      //   517: aload_0
      //   518: aload_0
      //   519: getfield bitField0_ : I
      //   522: sipush #4096
      //   525: ior
      //   526: putfield bitField0_ : I
      //   529: aload_0
      //   530: aload_3
      //   531: putfield userDefaultLanguage_ : Ljava/lang/String;
      //   534: goto -> 123
      //   537: aload_1
      //   538: invokevirtual readString : ()Ljava/lang/String;
      //   541: astore_3
      //   542: aload_0
      //   543: aload_0
      //   544: getfield bitField0_ : I
      //   547: sipush #2048
      //   550: ior
      //   551: putfield bitField0_ : I
      //   554: aload_0
      //   555: aload_3
      //   556: putfield deviceModel_ : Ljava/lang/String;
      //   559: goto -> 123
      //   562: aload_1
      //   563: invokevirtual readString : ()Ljava/lang/String;
      //   566: astore_3
      //   567: aload_0
      //   568: aload_0
      //   569: getfield bitField0_ : I
      //   572: sipush #1024
      //   575: ior
      //   576: putfield bitField0_ : I
      //   579: aload_0
      //   580: aload_3
      //   581: putfield osVersion_ : Ljava/lang/String;
      //   584: goto -> 123
      //   587: aload_1
      //   588: invokevirtual readString : ()Ljava/lang/String;
      //   591: astore_3
      //   592: aload_0
      //   593: aload_0
      //   594: getfield bitField0_ : I
      //   597: sipush #512
      //   600: ior
      //   601: putfield bitField0_ : I
      //   604: aload_0
      //   605: aload_3
      //   606: putfield platform_ : Ljava/lang/String;
      //   609: goto -> 123
      //   612: aload_0
      //   613: aload_0
      //   614: getfield bitField0_ : I
      //   617: sipush #256
      //   620: ior
      //   621: putfield bitField0_ : I
      //   624: aload_0
      //   625: aload_1
      //   626: invokevirtual readBool : ()Z
      //   629: putfield limitedAdTracking_ : Z
      //   632: goto -> 123
      //   635: aload_1
      //   636: invokevirtual readString : ()Ljava/lang/String;
      //   639: astore_3
      //   640: aload_0
      //   641: aload_0
      //   642: getfield bitField0_ : I
      //   645: sipush #128
      //   648: ior
      //   649: putfield bitField0_ : I
      //   652: aload_0
      //   653: aload_3
      //   654: putfield vendorDeviceId_ : Ljava/lang/String;
      //   657: goto -> 123
      //   660: aload_1
      //   661: invokevirtual readString : ()Ljava/lang/String;
      //   664: astore_3
      //   665: aload_0
      //   666: aload_0
      //   667: getfield bitField0_ : I
      //   670: bipush #64
      //   672: ior
      //   673: putfield bitField0_ : I
      //   676: aload_0
      //   677: aload_3
      //   678: putfield resettableDeviceId_ : Ljava/lang/String;
      //   681: goto -> 123
      //   684: aload_1
      //   685: invokevirtual readString : ()Ljava/lang/String;
      //   688: astore_3
      //   689: aload_0
      //   690: aload_0
      //   691: getfield bitField0_ : I
      //   694: bipush #32
      //   696: ior
      //   697: putfield bitField0_ : I
      //   700: aload_0
      //   701: aload_3
      //   702: putfield appInstanceId_ : Ljava/lang/String;
      //   705: goto -> 123
      //   708: aload_0
      //   709: aload_0
      //   710: getfield bitField0_ : I
      //   713: bipush #16
      //   715: ior
      //   716: putfield bitField0_ : I
      //   719: aload_0
      //   720: aload_1
      //   721: invokevirtual readInt32 : ()I
      //   724: putfield appVersionRelease_ : I
      //   727: goto -> 123
      //   730: aload_0
      //   731: aload_0
      //   732: getfield bitField0_ : I
      //   735: bipush #8
      //   737: ior
      //   738: putfield bitField0_ : I
      //   741: aload_0
      //   742: aload_1
      //   743: invokevirtual readInt32 : ()I
      //   746: putfield appVersionMinor_ : I
      //   749: goto -> 123
      //   752: aload_0
      //   753: aload_0
      //   754: getfield bitField0_ : I
      //   757: iconst_4
      //   758: ior
      //   759: putfield bitField0_ : I
      //   762: aload_0
      //   763: aload_1
      //   764: invokevirtual readInt32 : ()I
      //   767: putfield appVersionMajor_ : I
      //   770: goto -> 123
      //   773: aload_1
      //   774: invokevirtual readString : ()Ljava/lang/String;
      //   777: astore_3
      //   778: aload_0
      //   779: aload_0
      //   780: getfield bitField0_ : I
      //   783: iconst_2
      //   784: ior
      //   785: putfield bitField0_ : I
      //   788: aload_0
      //   789: aload_3
      //   790: putfield packageName_ : Ljava/lang/String;
      //   793: goto -> 123
      //   796: aload_1
      //   797: invokevirtual readString : ()Ljava/lang/String;
      //   800: astore_3
      //   801: aload_0
      //   802: iconst_1
      //   803: aload_0
      //   804: getfield bitField0_ : I
      //   807: ior
      //   808: putfield bitField0_ : I
      //   811: aload_0
      //   812: aload_3
      //   813: putfield appId_ : Ljava/lang/String;
      //   816: goto -> 123
      //   819: iconst_1
      //   820: istore #4
      //   822: goto -> 123
      //   825: iload #6
      //   827: ifne -> 123
      //   830: iconst_1
      //   831: istore #4
      //   833: goto -> 123
      //   836: astore_1
      //   837: goto -> 884
      //   840: astore_3
      //   841: new java/lang/RuntimeException
      //   844: astore_1
      //   845: new com/google/protobuf/InvalidProtocolBufferException
      //   848: astore_2
      //   849: aload_2
      //   850: aload_3
      //   851: invokevirtual getMessage : ()Ljava/lang/String;
      //   854: invokespecial <init> : (Ljava/lang/String;)V
      //   857: aload_1
      //   858: aload_2
      //   859: aload_0
      //   860: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   863: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   866: aload_1
      //   867: athrow
      //   868: astore_1
      //   869: new java/lang/RuntimeException
      //   872: astore_2
      //   873: aload_2
      //   874: aload_1
      //   875: aload_0
      //   876: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   879: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   882: aload_2
      //   883: athrow
      //   884: aload_1
      //   885: athrow
      //   886: getstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsApiRequest.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurementPublic$FirebaseAnalyticsApiRequest;
      //   889: areturn
      //   890: aload_2
      //   891: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   894: astore_1
      //   895: aload_3
      //   896: checkcast analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsApiRequest
      //   899: astore_2
      //   900: aload_0
      //   901: aload_1
      //   902: aload_0
      //   903: invokevirtual hasAppId : ()Z
      //   906: aload_0
      //   907: getfield appId_ : Ljava/lang/String;
      //   910: aload_2
      //   911: invokevirtual hasAppId : ()Z
      //   914: aload_2
      //   915: getfield appId_ : Ljava/lang/String;
      //   918: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   923: putfield appId_ : Ljava/lang/String;
      //   926: aload_0
      //   927: aload_1
      //   928: aload_0
      //   929: invokevirtual hasPackageName : ()Z
      //   932: aload_0
      //   933: getfield packageName_ : Ljava/lang/String;
      //   936: aload_2
      //   937: invokevirtual hasPackageName : ()Z
      //   940: aload_2
      //   941: getfield packageName_ : Ljava/lang/String;
      //   944: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   949: putfield packageName_ : Ljava/lang/String;
      //   952: aload_0
      //   953: aload_1
      //   954: aload_0
      //   955: invokevirtual hasAppVersionMajor : ()Z
      //   958: aload_0
      //   959: getfield appVersionMajor_ : I
      //   962: aload_2
      //   963: invokevirtual hasAppVersionMajor : ()Z
      //   966: aload_2
      //   967: getfield appVersionMajor_ : I
      //   970: invokeinterface visitInt : (ZIZI)I
      //   975: putfield appVersionMajor_ : I
      //   978: aload_0
      //   979: aload_1
      //   980: aload_0
      //   981: invokevirtual hasAppVersionMinor : ()Z
      //   984: aload_0
      //   985: getfield appVersionMinor_ : I
      //   988: aload_2
      //   989: invokevirtual hasAppVersionMinor : ()Z
      //   992: aload_2
      //   993: getfield appVersionMinor_ : I
      //   996: invokeinterface visitInt : (ZIZI)I
      //   1001: putfield appVersionMinor_ : I
      //   1004: aload_0
      //   1005: aload_1
      //   1006: aload_0
      //   1007: invokevirtual hasAppVersionRelease : ()Z
      //   1010: aload_0
      //   1011: getfield appVersionRelease_ : I
      //   1014: aload_2
      //   1015: invokevirtual hasAppVersionRelease : ()Z
      //   1018: aload_2
      //   1019: getfield appVersionRelease_ : I
      //   1022: invokeinterface visitInt : (ZIZI)I
      //   1027: putfield appVersionRelease_ : I
      //   1030: aload_0
      //   1031: aload_1
      //   1032: aload_0
      //   1033: invokevirtual hasAppInstanceId : ()Z
      //   1036: aload_0
      //   1037: getfield appInstanceId_ : Ljava/lang/String;
      //   1040: aload_2
      //   1041: invokevirtual hasAppInstanceId : ()Z
      //   1044: aload_2
      //   1045: getfield appInstanceId_ : Ljava/lang/String;
      //   1048: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   1053: putfield appInstanceId_ : Ljava/lang/String;
      //   1056: aload_0
      //   1057: aload_1
      //   1058: aload_0
      //   1059: invokevirtual hasResettableDeviceId : ()Z
      //   1062: aload_0
      //   1063: getfield resettableDeviceId_ : Ljava/lang/String;
      //   1066: aload_2
      //   1067: invokevirtual hasResettableDeviceId : ()Z
      //   1070: aload_2
      //   1071: getfield resettableDeviceId_ : Ljava/lang/String;
      //   1074: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   1079: putfield resettableDeviceId_ : Ljava/lang/String;
      //   1082: aload_0
      //   1083: aload_1
      //   1084: aload_0
      //   1085: invokevirtual hasVendorDeviceId : ()Z
      //   1088: aload_0
      //   1089: getfield vendorDeviceId_ : Ljava/lang/String;
      //   1092: aload_2
      //   1093: invokevirtual hasVendorDeviceId : ()Z
      //   1096: aload_2
      //   1097: getfield vendorDeviceId_ : Ljava/lang/String;
      //   1100: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   1105: putfield vendorDeviceId_ : Ljava/lang/String;
      //   1108: aload_0
      //   1109: aload_1
      //   1110: aload_0
      //   1111: invokevirtual hasLimitedAdTracking : ()Z
      //   1114: aload_0
      //   1115: getfield limitedAdTracking_ : Z
      //   1118: aload_2
      //   1119: invokevirtual hasLimitedAdTracking : ()Z
      //   1122: aload_2
      //   1123: getfield limitedAdTracking_ : Z
      //   1126: invokeinterface visitBoolean : (ZZZZ)Z
      //   1131: putfield limitedAdTracking_ : Z
      //   1134: aload_0
      //   1135: aload_1
      //   1136: aload_0
      //   1137: invokevirtual hasPlatform : ()Z
      //   1140: aload_0
      //   1141: getfield platform_ : Ljava/lang/String;
      //   1144: aload_2
      //   1145: invokevirtual hasPlatform : ()Z
      //   1148: aload_2
      //   1149: getfield platform_ : Ljava/lang/String;
      //   1152: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   1157: putfield platform_ : Ljava/lang/String;
      //   1160: aload_0
      //   1161: aload_1
      //   1162: aload_0
      //   1163: invokevirtual hasOsVersion : ()Z
      //   1166: aload_0
      //   1167: getfield osVersion_ : Ljava/lang/String;
      //   1170: aload_2
      //   1171: invokevirtual hasOsVersion : ()Z
      //   1174: aload_2
      //   1175: getfield osVersion_ : Ljava/lang/String;
      //   1178: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   1183: putfield osVersion_ : Ljava/lang/String;
      //   1186: aload_0
      //   1187: aload_1
      //   1188: aload_0
      //   1189: invokevirtual hasDeviceModel : ()Z
      //   1192: aload_0
      //   1193: getfield deviceModel_ : Ljava/lang/String;
      //   1196: aload_2
      //   1197: invokevirtual hasDeviceModel : ()Z
      //   1200: aload_2
      //   1201: getfield deviceModel_ : Ljava/lang/String;
      //   1204: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   1209: putfield deviceModel_ : Ljava/lang/String;
      //   1212: aload_0
      //   1213: aload_1
      //   1214: aload_0
      //   1215: invokevirtual hasUserDefaultLanguage : ()Z
      //   1218: aload_0
      //   1219: getfield userDefaultLanguage_ : Ljava/lang/String;
      //   1222: aload_2
      //   1223: invokevirtual hasUserDefaultLanguage : ()Z
      //   1226: aload_2
      //   1227: getfield userDefaultLanguage_ : Ljava/lang/String;
      //   1230: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   1235: putfield userDefaultLanguage_ : Ljava/lang/String;
      //   1238: aload_0
      //   1239: aload_1
      //   1240: aload_0
      //   1241: invokevirtual hasUploadTimestampMillis : ()Z
      //   1244: aload_0
      //   1245: getfield uploadTimestampMillis_ : J
      //   1248: aload_2
      //   1249: invokevirtual hasUploadTimestampMillis : ()Z
      //   1252: aload_2
      //   1253: getfield uploadTimestampMillis_ : J
      //   1256: invokeinterface visitLong : (ZJZJ)J
      //   1261: putfield uploadTimestampMillis_ : J
      //   1264: aload_0
      //   1265: aload_1
      //   1266: aload_0
      //   1267: invokevirtual hasAppStore : ()Z
      //   1270: aload_0
      //   1271: getfield appStore_ : Ljava/lang/String;
      //   1274: aload_2
      //   1275: invokevirtual hasAppStore : ()Z
      //   1278: aload_2
      //   1279: getfield appStore_ : Ljava/lang/String;
      //   1282: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   1287: putfield appStore_ : Ljava/lang/String;
      //   1290: aload_0
      //   1291: aload_1
      //   1292: aload_0
      //   1293: getfield event_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1296: aload_2
      //   1297: getfield event_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1300: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   1305: putfield event_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1308: aload_0
      //   1309: aload_1
      //   1310: aload_0
      //   1311: getfield userProperty_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1314: aload_2
      //   1315: getfield userProperty_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1318: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   1323: putfield userProperty_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1326: aload_0
      //   1327: aload_1
      //   1328: aload_0
      //   1329: invokevirtual hasApiKey : ()Z
      //   1332: aload_0
      //   1333: getfield apiKey_ : Ljava/lang/String;
      //   1336: aload_2
      //   1337: invokevirtual hasApiKey : ()Z
      //   1340: aload_2
      //   1341: getfield apiKey_ : Ljava/lang/String;
      //   1344: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   1349: putfield apiKey_ : Ljava/lang/String;
      //   1352: aload_0
      //   1353: aload_1
      //   1354: aload_0
      //   1355: invokevirtual hasIpAddress : ()Z
      //   1358: aload_0
      //   1359: getfield ipAddress_ : Ljava/lang/String;
      //   1362: aload_2
      //   1363: invokevirtual hasIpAddress : ()Z
      //   1366: aload_2
      //   1367: getfield ipAddress_ : Ljava/lang/String;
      //   1370: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   1375: putfield ipAddress_ : Ljava/lang/String;
      //   1378: aload_1
      //   1379: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   1382: if_acmpne -> 1398
      //   1385: aload_0
      //   1386: aload_0
      //   1387: getfield bitField0_ : I
      //   1390: aload_2
      //   1391: getfield bitField0_ : I
      //   1394: ior
      //   1395: putfield bitField0_ : I
      //   1398: aload_0
      //   1399: areturn
      //   1400: new analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsApiRequest$Builder
      //   1403: dup
      //   1404: aconst_null
      //   1405: invokespecial <init> : (Lanalytics_collection/GmpMeasurementPublic$1;)V
      //   1408: areturn
      //   1409: aload_0
      //   1410: getfield event_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1413: invokeinterface makeImmutable : ()V
      //   1418: aload_0
      //   1419: getfield userProperty_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1422: invokeinterface makeImmutable : ()V
      //   1427: aconst_null
      //   1428: areturn
      //   1429: getstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsApiRequest.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurementPublic$FirebaseAnalyticsApiRequest;
      //   1432: areturn
      //   1433: new analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsApiRequest
      //   1436: dup
      //   1437: invokespecial <init> : ()V
      //   1440: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	868	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	840	java/io/IOException
      //   128	134	836	finally
      //   308	317	868	com/google/protobuf/InvalidProtocolBufferException
      //   308	317	840	java/io/IOException
      //   308	317	836	finally
      //   320	342	868	com/google/protobuf/InvalidProtocolBufferException
      //   320	342	840	java/io/IOException
      //   320	342	836	finally
      //   345	367	868	com/google/protobuf/InvalidProtocolBufferException
      //   345	367	840	java/io/IOException
      //   345	367	836	finally
      //   370	393	868	com/google/protobuf/InvalidProtocolBufferException
      //   370	393	840	java/io/IOException
      //   370	393	836	finally
      //   393	414	868	com/google/protobuf/InvalidProtocolBufferException
      //   393	414	840	java/io/IOException
      //   393	414	836	finally
      //   417	440	868	com/google/protobuf/InvalidProtocolBufferException
      //   417	440	840	java/io/IOException
      //   417	440	836	finally
      //   440	461	868	com/google/protobuf/InvalidProtocolBufferException
      //   440	461	840	java/io/IOException
      //   440	461	836	finally
      //   464	486	868	com/google/protobuf/InvalidProtocolBufferException
      //   464	486	840	java/io/IOException
      //   464	486	836	finally
      //   489	509	868	com/google/protobuf/InvalidProtocolBufferException
      //   489	509	840	java/io/IOException
      //   489	509	836	finally
      //   512	534	868	com/google/protobuf/InvalidProtocolBufferException
      //   512	534	840	java/io/IOException
      //   512	534	836	finally
      //   537	559	868	com/google/protobuf/InvalidProtocolBufferException
      //   537	559	840	java/io/IOException
      //   537	559	836	finally
      //   562	584	868	com/google/protobuf/InvalidProtocolBufferException
      //   562	584	840	java/io/IOException
      //   562	584	836	finally
      //   587	609	868	com/google/protobuf/InvalidProtocolBufferException
      //   587	609	840	java/io/IOException
      //   587	609	836	finally
      //   612	632	868	com/google/protobuf/InvalidProtocolBufferException
      //   612	632	840	java/io/IOException
      //   612	632	836	finally
      //   635	657	868	com/google/protobuf/InvalidProtocolBufferException
      //   635	657	840	java/io/IOException
      //   635	657	836	finally
      //   660	681	868	com/google/protobuf/InvalidProtocolBufferException
      //   660	681	840	java/io/IOException
      //   660	681	836	finally
      //   684	705	868	com/google/protobuf/InvalidProtocolBufferException
      //   684	705	840	java/io/IOException
      //   684	705	836	finally
      //   708	727	868	com/google/protobuf/InvalidProtocolBufferException
      //   708	727	840	java/io/IOException
      //   708	727	836	finally
      //   730	749	868	com/google/protobuf/InvalidProtocolBufferException
      //   730	749	840	java/io/IOException
      //   730	749	836	finally
      //   752	770	868	com/google/protobuf/InvalidProtocolBufferException
      //   752	770	840	java/io/IOException
      //   752	770	836	finally
      //   773	793	868	com/google/protobuf/InvalidProtocolBufferException
      //   773	793	840	java/io/IOException
      //   773	793	836	finally
      //   796	816	868	com/google/protobuf/InvalidProtocolBufferException
      //   796	816	840	java/io/IOException
      //   796	816	836	finally
      //   841	868	836	finally
      //   869	884	836	finally
    }
    
    public String getApiKey() {
      return this.apiKey_;
    }
    
    public ByteString getApiKeyBytes() {
      return ByteString.copyFromUtf8(this.apiKey_);
    }
    
    public String getAppId() {
      return this.appId_;
    }
    
    public ByteString getAppIdBytes() {
      return ByteString.copyFromUtf8(this.appId_);
    }
    
    public String getAppInstanceId() {
      return this.appInstanceId_;
    }
    
    public ByteString getAppInstanceIdBytes() {
      return ByteString.copyFromUtf8(this.appInstanceId_);
    }
    
    public String getAppStore() {
      return this.appStore_;
    }
    
    public ByteString getAppStoreBytes() {
      return ByteString.copyFromUtf8(this.appStore_);
    }
    
    public int getAppVersionMajor() {
      return this.appVersionMajor_;
    }
    
    public int getAppVersionMinor() {
      return this.appVersionMinor_;
    }
    
    public int getAppVersionRelease() {
      return this.appVersionRelease_;
    }
    
    public String getDeviceModel() {
      return this.deviceModel_;
    }
    
    public ByteString getDeviceModelBytes() {
      return ByteString.copyFromUtf8(this.deviceModel_);
    }
    
    public GmpMeasurementPublic.FirebaseAnalyticsEvent getEvent(int param1Int) {
      return (GmpMeasurementPublic.FirebaseAnalyticsEvent)this.event_.get(param1Int);
    }
    
    public int getEventCount() {
      return this.event_.size();
    }
    
    public List<GmpMeasurementPublic.FirebaseAnalyticsEvent> getEventList() {
      return (List<GmpMeasurementPublic.FirebaseAnalyticsEvent>)this.event_;
    }
    
    public GmpMeasurementPublic.FirebaseAnalyticsEventOrBuilder getEventOrBuilder(int param1Int) {
      return (GmpMeasurementPublic.FirebaseAnalyticsEventOrBuilder)this.event_.get(param1Int);
    }
    
    public List<? extends GmpMeasurementPublic.FirebaseAnalyticsEventOrBuilder> getEventOrBuilderList() {
      return (List)this.event_;
    }
    
    public String getIpAddress() {
      return this.ipAddress_;
    }
    
    public ByteString getIpAddressBytes() {
      return ByteString.copyFromUtf8(this.ipAddress_);
    }
    
    public boolean getLimitedAdTracking() {
      return this.limitedAdTracking_;
    }
    
    public String getOsVersion() {
      return this.osVersion_;
    }
    
    public ByteString getOsVersionBytes() {
      return ByteString.copyFromUtf8(this.osVersion_);
    }
    
    public String getPackageName() {
      return this.packageName_;
    }
    
    public ByteString getPackageNameBytes() {
      return ByteString.copyFromUtf8(this.packageName_);
    }
    
    public String getPlatform() {
      return this.platform_;
    }
    
    public ByteString getPlatformBytes() {
      return ByteString.copyFromUtf8(this.platform_);
    }
    
    public String getResettableDeviceId() {
      return this.resettableDeviceId_;
    }
    
    public ByteString getResettableDeviceIdBytes() {
      return ByteString.copyFromUtf8(this.resettableDeviceId_);
    }
    
    public int getSerializedSize() {
      byte b3;
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = this.bitField0_;
      byte b1 = 0;
      if ((i & 0x1) == 1) {
        i = CodedOutputStream.computeStringSize(1, getAppId()) + 0;
      } else {
        i = 0;
      } 
      int j = i;
      if ((this.bitField0_ & 0x2) == 2)
        j = i + CodedOutputStream.computeStringSize(2, getPackageName()); 
      i = j;
      if ((this.bitField0_ & 0x4) == 4)
        i = j + CodedOutputStream.computeInt32Size(3, this.appVersionMajor_); 
      j = i;
      if ((this.bitField0_ & 0x8) == 8)
        j = i + CodedOutputStream.computeInt32Size(4, this.appVersionMinor_); 
      i = j;
      if ((this.bitField0_ & 0x10) == 16)
        i = j + CodedOutputStream.computeInt32Size(5, this.appVersionRelease_); 
      j = i;
      if ((this.bitField0_ & 0x20) == 32)
        j = i + CodedOutputStream.computeStringSize(6, getAppInstanceId()); 
      i = j;
      if ((this.bitField0_ & 0x40) == 64)
        i = j + CodedOutputStream.computeStringSize(7, getResettableDeviceId()); 
      j = i;
      if ((this.bitField0_ & 0x80) == 128)
        j = i + CodedOutputStream.computeStringSize(8, getVendorDeviceId()); 
      i = j;
      if ((this.bitField0_ & 0x100) == 256)
        i = j + CodedOutputStream.computeBoolSize(9, this.limitedAdTracking_); 
      j = i;
      if ((this.bitField0_ & 0x200) == 512)
        j = i + CodedOutputStream.computeStringSize(10, getPlatform()); 
      i = j;
      if ((this.bitField0_ & 0x400) == 1024)
        i = j + CodedOutputStream.computeStringSize(11, getOsVersion()); 
      j = i;
      if ((this.bitField0_ & 0x800) == 2048)
        j = i + CodedOutputStream.computeStringSize(12, getDeviceModel()); 
      i = j;
      if ((this.bitField0_ & 0x1000) == 4096)
        i = j + CodedOutputStream.computeStringSize(13, getUserDefaultLanguage()); 
      j = i;
      if ((this.bitField0_ & 0x2000) == 8192)
        j = i + CodedOutputStream.computeInt64Size(14, this.uploadTimestampMillis_); 
      i = j;
      if ((this.bitField0_ & 0x4000) == 16384)
        i = j + CodedOutputStream.computeStringSize(15, getAppStore()); 
      byte b2 = 0;
      j = i;
      while (true) {
        i = j;
        b3 = b1;
        if (b2 < this.event_.size()) {
          j += CodedOutputStream.computeMessageSize(16, (MessageLite)this.event_.get(b2));
          b2++;
          continue;
        } 
        break;
      } 
      while (b3 < this.userProperty_.size()) {
        i += CodedOutputStream.computeMessageSize(17, (MessageLite)this.userProperty_.get(b3));
        b3++;
      } 
      j = i;
      if ((this.bitField0_ & 0x8000) == 32768)
        j = i + CodedOutputStream.computeStringSize(18, getApiKey()); 
      i = j;
      if ((this.bitField0_ & 0x10000) == 65536)
        i = j + CodedOutputStream.computeStringSize(19, getIpAddress()); 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public long getUploadTimestampMillis() {
      return this.uploadTimestampMillis_;
    }
    
    public String getUserDefaultLanguage() {
      return this.userDefaultLanguage_;
    }
    
    public ByteString getUserDefaultLanguageBytes() {
      return ByteString.copyFromUtf8(this.userDefaultLanguage_);
    }
    
    public GmpMeasurementPublic.FirebaseAnalyticsUserAttribute getUserProperty(int param1Int) {
      return (GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.userProperty_.get(param1Int);
    }
    
    public int getUserPropertyCount() {
      return this.userProperty_.size();
    }
    
    public List<GmpMeasurementPublic.FirebaseAnalyticsUserAttribute> getUserPropertyList() {
      return (List<GmpMeasurementPublic.FirebaseAnalyticsUserAttribute>)this.userProperty_;
    }
    
    public GmpMeasurementPublic.FirebaseAnalyticsUserAttributeOrBuilder getUserPropertyOrBuilder(int param1Int) {
      return (GmpMeasurementPublic.FirebaseAnalyticsUserAttributeOrBuilder)this.userProperty_.get(param1Int);
    }
    
    public List<? extends GmpMeasurementPublic.FirebaseAnalyticsUserAttributeOrBuilder> getUserPropertyOrBuilderList() {
      return (List)this.userProperty_;
    }
    
    public String getVendorDeviceId() {
      return this.vendorDeviceId_;
    }
    
    public ByteString getVendorDeviceIdBytes() {
      return ByteString.copyFromUtf8(this.vendorDeviceId_);
    }
    
    public boolean hasApiKey() {
      boolean bool;
      if ((this.bitField0_ & 0x8000) == 32768) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasAppId() {
      int i = this.bitField0_;
      boolean bool = true;
      if ((i & 0x1) != 1)
        bool = false; 
      return bool;
    }
    
    public boolean hasAppInstanceId() {
      boolean bool;
      if ((this.bitField0_ & 0x20) == 32) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasAppStore() {
      boolean bool;
      if ((this.bitField0_ & 0x4000) == 16384) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasAppVersionMajor() {
      boolean bool;
      if ((this.bitField0_ & 0x4) == 4) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasAppVersionMinor() {
      boolean bool;
      if ((this.bitField0_ & 0x8) == 8) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasAppVersionRelease() {
      boolean bool;
      if ((this.bitField0_ & 0x10) == 16) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasDeviceModel() {
      boolean bool;
      if ((this.bitField0_ & 0x800) == 2048) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasIpAddress() {
      boolean bool;
      if ((this.bitField0_ & 0x10000) == 65536) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasLimitedAdTracking() {
      boolean bool;
      if ((this.bitField0_ & 0x100) == 256) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasOsVersion() {
      boolean bool;
      if ((this.bitField0_ & 0x400) == 1024) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasPackageName() {
      boolean bool;
      if ((this.bitField0_ & 0x2) == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasPlatform() {
      boolean bool;
      if ((this.bitField0_ & 0x200) == 512) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasResettableDeviceId() {
      boolean bool;
      if ((this.bitField0_ & 0x40) == 64) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasUploadTimestampMillis() {
      boolean bool;
      if ((this.bitField0_ & 0x2000) == 8192) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasUserDefaultLanguage() {
      boolean bool;
      if ((this.bitField0_ & 0x1000) == 4096) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasVendorDeviceId() {
      boolean bool;
      if ((this.bitField0_ & 0x80) == 128) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if ((this.bitField0_ & 0x1) == 1)
        param1CodedOutputStream.writeString(1, getAppId()); 
      if ((this.bitField0_ & 0x2) == 2)
        param1CodedOutputStream.writeString(2, getPackageName()); 
      if ((this.bitField0_ & 0x4) == 4)
        param1CodedOutputStream.writeInt32(3, this.appVersionMajor_); 
      if ((this.bitField0_ & 0x8) == 8)
        param1CodedOutputStream.writeInt32(4, this.appVersionMinor_); 
      if ((this.bitField0_ & 0x10) == 16)
        param1CodedOutputStream.writeInt32(5, this.appVersionRelease_); 
      if ((this.bitField0_ & 0x20) == 32)
        param1CodedOutputStream.writeString(6, getAppInstanceId()); 
      if ((this.bitField0_ & 0x40) == 64)
        param1CodedOutputStream.writeString(7, getResettableDeviceId()); 
      if ((this.bitField0_ & 0x80) == 128)
        param1CodedOutputStream.writeString(8, getVendorDeviceId()); 
      if ((this.bitField0_ & 0x100) == 256)
        param1CodedOutputStream.writeBool(9, this.limitedAdTracking_); 
      if ((this.bitField0_ & 0x200) == 512)
        param1CodedOutputStream.writeString(10, getPlatform()); 
      if ((this.bitField0_ & 0x400) == 1024)
        param1CodedOutputStream.writeString(11, getOsVersion()); 
      if ((this.bitField0_ & 0x800) == 2048)
        param1CodedOutputStream.writeString(12, getDeviceModel()); 
      if ((this.bitField0_ & 0x1000) == 4096)
        param1CodedOutputStream.writeString(13, getUserDefaultLanguage()); 
      if ((this.bitField0_ & 0x2000) == 8192)
        param1CodedOutputStream.writeInt64(14, this.uploadTimestampMillis_); 
      if ((this.bitField0_ & 0x4000) == 16384)
        param1CodedOutputStream.writeString(15, getAppStore()); 
      byte b;
      for (b = 0; b < this.event_.size(); b++)
        param1CodedOutputStream.writeMessage(16, (MessageLite)this.event_.get(b)); 
      for (b = 0; b < this.userProperty_.size(); b++)
        param1CodedOutputStream.writeMessage(17, (MessageLite)this.userProperty_.get(b)); 
      if ((this.bitField0_ & 0x8000) == 32768)
        param1CodedOutputStream.writeString(18, getApiKey()); 
      if ((this.bitField0_ & 0x10000) == 65536)
        param1CodedOutputStream.writeString(19, getIpAddress()); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<FirebaseAnalyticsApiRequest, Builder> implements GmpMeasurementPublic.FirebaseAnalyticsApiRequestOrBuilder {
      private Builder() {
        super(GmpMeasurementPublic.FirebaseAnalyticsApiRequest.DEFAULT_INSTANCE);
      }
      
      public Builder addAllEvent(Iterable<? extends GmpMeasurementPublic.FirebaseAnalyticsEvent> param2Iterable) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).addAllEvent(param2Iterable);
        return this;
      }
      
      public Builder addAllUserProperty(Iterable<? extends GmpMeasurementPublic.FirebaseAnalyticsUserAttribute> param2Iterable) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).addAllUserProperty(param2Iterable);
        return this;
      }
      
      public Builder addEvent(int param2Int, GmpMeasurementPublic.FirebaseAnalyticsEvent.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).addEvent(param2Int, param2Builder);
        return this;
      }
      
      public Builder addEvent(int param2Int, GmpMeasurementPublic.FirebaseAnalyticsEvent param2FirebaseAnalyticsEvent) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).addEvent(param2Int, param2FirebaseAnalyticsEvent);
        return this;
      }
      
      public Builder addEvent(GmpMeasurementPublic.FirebaseAnalyticsEvent.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).addEvent(param2Builder);
        return this;
      }
      
      public Builder addEvent(GmpMeasurementPublic.FirebaseAnalyticsEvent param2FirebaseAnalyticsEvent) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).addEvent(param2FirebaseAnalyticsEvent);
        return this;
      }
      
      public Builder addUserProperty(int param2Int, GmpMeasurementPublic.FirebaseAnalyticsUserAttribute.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).addUserProperty(param2Int, param2Builder);
        return this;
      }
      
      public Builder addUserProperty(int param2Int, GmpMeasurementPublic.FirebaseAnalyticsUserAttribute param2FirebaseAnalyticsUserAttribute) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).addUserProperty(param2Int, param2FirebaseAnalyticsUserAttribute);
        return this;
      }
      
      public Builder addUserProperty(GmpMeasurementPublic.FirebaseAnalyticsUserAttribute.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).addUserProperty(param2Builder);
        return this;
      }
      
      public Builder addUserProperty(GmpMeasurementPublic.FirebaseAnalyticsUserAttribute param2FirebaseAnalyticsUserAttribute) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).addUserProperty(param2FirebaseAnalyticsUserAttribute);
        return this;
      }
      
      public Builder clearApiKey() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearApiKey();
        return this;
      }
      
      public Builder clearAppId() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearAppId();
        return this;
      }
      
      public Builder clearAppInstanceId() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearAppInstanceId();
        return this;
      }
      
      public Builder clearAppStore() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearAppStore();
        return this;
      }
      
      public Builder clearAppVersionMajor() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearAppVersionMajor();
        return this;
      }
      
      public Builder clearAppVersionMinor() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearAppVersionMinor();
        return this;
      }
      
      public Builder clearAppVersionRelease() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearAppVersionRelease();
        return this;
      }
      
      public Builder clearDeviceModel() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearDeviceModel();
        return this;
      }
      
      public Builder clearEvent() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearEvent();
        return this;
      }
      
      public Builder clearIpAddress() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearIpAddress();
        return this;
      }
      
      public Builder clearLimitedAdTracking() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearLimitedAdTracking();
        return this;
      }
      
      public Builder clearOsVersion() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearOsVersion();
        return this;
      }
      
      public Builder clearPackageName() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearPackageName();
        return this;
      }
      
      public Builder clearPlatform() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearPlatform();
        return this;
      }
      
      public Builder clearResettableDeviceId() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearResettableDeviceId();
        return this;
      }
      
      public Builder clearUploadTimestampMillis() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearUploadTimestampMillis();
        return this;
      }
      
      public Builder clearUserDefaultLanguage() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearUserDefaultLanguage();
        return this;
      }
      
      public Builder clearUserProperty() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearUserProperty();
        return this;
      }
      
      public Builder clearVendorDeviceId() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearVendorDeviceId();
        return this;
      }
      
      public String getApiKey() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getApiKey();
      }
      
      public ByteString getApiKeyBytes() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getApiKeyBytes();
      }
      
      public String getAppId() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getAppId();
      }
      
      public ByteString getAppIdBytes() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getAppIdBytes();
      }
      
      public String getAppInstanceId() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getAppInstanceId();
      }
      
      public ByteString getAppInstanceIdBytes() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getAppInstanceIdBytes();
      }
      
      public String getAppStore() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getAppStore();
      }
      
      public ByteString getAppStoreBytes() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getAppStoreBytes();
      }
      
      public int getAppVersionMajor() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getAppVersionMajor();
      }
      
      public int getAppVersionMinor() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getAppVersionMinor();
      }
      
      public int getAppVersionRelease() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getAppVersionRelease();
      }
      
      public String getDeviceModel() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getDeviceModel();
      }
      
      public ByteString getDeviceModelBytes() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getDeviceModelBytes();
      }
      
      public GmpMeasurementPublic.FirebaseAnalyticsEvent getEvent(int param2Int) {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getEvent(param2Int);
      }
      
      public int getEventCount() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getEventCount();
      }
      
      public List<GmpMeasurementPublic.FirebaseAnalyticsEvent> getEventList() {
        return Collections.unmodifiableList(((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getEventList());
      }
      
      public String getIpAddress() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getIpAddress();
      }
      
      public ByteString getIpAddressBytes() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getIpAddressBytes();
      }
      
      public boolean getLimitedAdTracking() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getLimitedAdTracking();
      }
      
      public String getOsVersion() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getOsVersion();
      }
      
      public ByteString getOsVersionBytes() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getOsVersionBytes();
      }
      
      public String getPackageName() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getPackageName();
      }
      
      public ByteString getPackageNameBytes() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getPackageNameBytes();
      }
      
      public String getPlatform() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getPlatform();
      }
      
      public ByteString getPlatformBytes() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getPlatformBytes();
      }
      
      public String getResettableDeviceId() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getResettableDeviceId();
      }
      
      public ByteString getResettableDeviceIdBytes() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getResettableDeviceIdBytes();
      }
      
      public long getUploadTimestampMillis() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getUploadTimestampMillis();
      }
      
      public String getUserDefaultLanguage() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getUserDefaultLanguage();
      }
      
      public ByteString getUserDefaultLanguageBytes() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getUserDefaultLanguageBytes();
      }
      
      public GmpMeasurementPublic.FirebaseAnalyticsUserAttribute getUserProperty(int param2Int) {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getUserProperty(param2Int);
      }
      
      public int getUserPropertyCount() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getUserPropertyCount();
      }
      
      public List<GmpMeasurementPublic.FirebaseAnalyticsUserAttribute> getUserPropertyList() {
        return Collections.unmodifiableList(((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getUserPropertyList());
      }
      
      public String getVendorDeviceId() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getVendorDeviceId();
      }
      
      public ByteString getVendorDeviceIdBytes() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getVendorDeviceIdBytes();
      }
      
      public boolean hasApiKey() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasApiKey();
      }
      
      public boolean hasAppId() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasAppId();
      }
      
      public boolean hasAppInstanceId() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasAppInstanceId();
      }
      
      public boolean hasAppStore() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasAppStore();
      }
      
      public boolean hasAppVersionMajor() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasAppVersionMajor();
      }
      
      public boolean hasAppVersionMinor() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasAppVersionMinor();
      }
      
      public boolean hasAppVersionRelease() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasAppVersionRelease();
      }
      
      public boolean hasDeviceModel() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasDeviceModel();
      }
      
      public boolean hasIpAddress() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasIpAddress();
      }
      
      public boolean hasLimitedAdTracking() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasLimitedAdTracking();
      }
      
      public boolean hasOsVersion() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasOsVersion();
      }
      
      public boolean hasPackageName() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasPackageName();
      }
      
      public boolean hasPlatform() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasPlatform();
      }
      
      public boolean hasResettableDeviceId() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasResettableDeviceId();
      }
      
      public boolean hasUploadTimestampMillis() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasUploadTimestampMillis();
      }
      
      public boolean hasUserDefaultLanguage() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasUserDefaultLanguage();
      }
      
      public boolean hasVendorDeviceId() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasVendorDeviceId();
      }
      
      public Builder removeEvent(int param2Int) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).removeEvent(param2Int);
        return this;
      }
      
      public Builder removeUserProperty(int param2Int) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).removeUserProperty(param2Int);
        return this;
      }
      
      public Builder setApiKey(String param2String) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setApiKey(param2String);
        return this;
      }
      
      public Builder setApiKeyBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setApiKeyBytes(param2ByteString);
        return this;
      }
      
      public Builder setAppId(String param2String) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setAppId(param2String);
        return this;
      }
      
      public Builder setAppIdBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setAppIdBytes(param2ByteString);
        return this;
      }
      
      public Builder setAppInstanceId(String param2String) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setAppInstanceId(param2String);
        return this;
      }
      
      public Builder setAppInstanceIdBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setAppInstanceIdBytes(param2ByteString);
        return this;
      }
      
      public Builder setAppStore(String param2String) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setAppStore(param2String);
        return this;
      }
      
      public Builder setAppStoreBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setAppStoreBytes(param2ByteString);
        return this;
      }
      
      public Builder setAppVersionMajor(int param2Int) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setAppVersionMajor(param2Int);
        return this;
      }
      
      public Builder setAppVersionMinor(int param2Int) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setAppVersionMinor(param2Int);
        return this;
      }
      
      public Builder setAppVersionRelease(int param2Int) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setAppVersionRelease(param2Int);
        return this;
      }
      
      public Builder setDeviceModel(String param2String) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setDeviceModel(param2String);
        return this;
      }
      
      public Builder setDeviceModelBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setDeviceModelBytes(param2ByteString);
        return this;
      }
      
      public Builder setEvent(int param2Int, GmpMeasurementPublic.FirebaseAnalyticsEvent.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setEvent(param2Int, param2Builder);
        return this;
      }
      
      public Builder setEvent(int param2Int, GmpMeasurementPublic.FirebaseAnalyticsEvent param2FirebaseAnalyticsEvent) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setEvent(param2Int, param2FirebaseAnalyticsEvent);
        return this;
      }
      
      public Builder setIpAddress(String param2String) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setIpAddress(param2String);
        return this;
      }
      
      public Builder setIpAddressBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setIpAddressBytes(param2ByteString);
        return this;
      }
      
      public Builder setLimitedAdTracking(boolean param2Boolean) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setLimitedAdTracking(param2Boolean);
        return this;
      }
      
      public Builder setOsVersion(String param2String) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setOsVersion(param2String);
        return this;
      }
      
      public Builder setOsVersionBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setOsVersionBytes(param2ByteString);
        return this;
      }
      
      public Builder setPackageName(String param2String) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setPackageName(param2String);
        return this;
      }
      
      public Builder setPackageNameBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setPackageNameBytes(param2ByteString);
        return this;
      }
      
      public Builder setPlatform(String param2String) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setPlatform(param2String);
        return this;
      }
      
      public Builder setPlatformBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setPlatformBytes(param2ByteString);
        return this;
      }
      
      public Builder setResettableDeviceId(String param2String) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setResettableDeviceId(param2String);
        return this;
      }
      
      public Builder setResettableDeviceIdBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setResettableDeviceIdBytes(param2ByteString);
        return this;
      }
      
      public Builder setUploadTimestampMillis(long param2Long) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setUploadTimestampMillis(param2Long);
        return this;
      }
      
      public Builder setUserDefaultLanguage(String param2String) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setUserDefaultLanguage(param2String);
        return this;
      }
      
      public Builder setUserDefaultLanguageBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setUserDefaultLanguageBytes(param2ByteString);
        return this;
      }
      
      public Builder setUserProperty(int param2Int, GmpMeasurementPublic.FirebaseAnalyticsUserAttribute.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setUserProperty(param2Int, param2Builder);
        return this;
      }
      
      public Builder setUserProperty(int param2Int, GmpMeasurementPublic.FirebaseAnalyticsUserAttribute param2FirebaseAnalyticsUserAttribute) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setUserProperty(param2Int, param2FirebaseAnalyticsUserAttribute);
        return this;
      }
      
      public Builder setVendorDeviceId(String param2String) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setVendorDeviceId(param2String);
        return this;
      }
      
      public Builder setVendorDeviceIdBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setVendorDeviceIdBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<FirebaseAnalyticsApiRequest, FirebaseAnalyticsApiRequest.Builder> implements FirebaseAnalyticsApiRequestOrBuilder {
    private Builder() {
      super(GmpMeasurementPublic.FirebaseAnalyticsApiRequest.DEFAULT_INSTANCE);
    }
    
    public Builder addAllEvent(Iterable<? extends GmpMeasurementPublic.FirebaseAnalyticsEvent> param1Iterable) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).addAllEvent(param1Iterable);
      return this;
    }
    
    public Builder addAllUserProperty(Iterable<? extends GmpMeasurementPublic.FirebaseAnalyticsUserAttribute> param1Iterable) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).addAllUserProperty(param1Iterable);
      return this;
    }
    
    public Builder addEvent(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsEvent.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).addEvent(param1Int, param1Builder);
      return this;
    }
    
    public Builder addEvent(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsEvent param1FirebaseAnalyticsEvent) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).addEvent(param1Int, param1FirebaseAnalyticsEvent);
      return this;
    }
    
    public Builder addEvent(GmpMeasurementPublic.FirebaseAnalyticsEvent.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).addEvent(param1Builder);
      return this;
    }
    
    public Builder addEvent(GmpMeasurementPublic.FirebaseAnalyticsEvent param1FirebaseAnalyticsEvent) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).addEvent(param1FirebaseAnalyticsEvent);
      return this;
    }
    
    public Builder addUserProperty(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsUserAttribute.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).addUserProperty(param1Int, param1Builder);
      return this;
    }
    
    public Builder addUserProperty(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsUserAttribute param1FirebaseAnalyticsUserAttribute) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).addUserProperty(param1Int, param1FirebaseAnalyticsUserAttribute);
      return this;
    }
    
    public Builder addUserProperty(GmpMeasurementPublic.FirebaseAnalyticsUserAttribute.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).addUserProperty(param1Builder);
      return this;
    }
    
    public Builder addUserProperty(GmpMeasurementPublic.FirebaseAnalyticsUserAttribute param1FirebaseAnalyticsUserAttribute) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).addUserProperty(param1FirebaseAnalyticsUserAttribute);
      return this;
    }
    
    public Builder clearApiKey() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearApiKey();
      return this;
    }
    
    public Builder clearAppId() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearAppId();
      return this;
    }
    
    public Builder clearAppInstanceId() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearAppInstanceId();
      return this;
    }
    
    public Builder clearAppStore() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearAppStore();
      return this;
    }
    
    public Builder clearAppVersionMajor() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearAppVersionMajor();
      return this;
    }
    
    public Builder clearAppVersionMinor() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearAppVersionMinor();
      return this;
    }
    
    public Builder clearAppVersionRelease() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearAppVersionRelease();
      return this;
    }
    
    public Builder clearDeviceModel() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearDeviceModel();
      return this;
    }
    
    public Builder clearEvent() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearEvent();
      return this;
    }
    
    public Builder clearIpAddress() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearIpAddress();
      return this;
    }
    
    public Builder clearLimitedAdTracking() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearLimitedAdTracking();
      return this;
    }
    
    public Builder clearOsVersion() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearOsVersion();
      return this;
    }
    
    public Builder clearPackageName() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearPackageName();
      return this;
    }
    
    public Builder clearPlatform() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearPlatform();
      return this;
    }
    
    public Builder clearResettableDeviceId() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearResettableDeviceId();
      return this;
    }
    
    public Builder clearUploadTimestampMillis() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearUploadTimestampMillis();
      return this;
    }
    
    public Builder clearUserDefaultLanguage() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearUserDefaultLanguage();
      return this;
    }
    
    public Builder clearUserProperty() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearUserProperty();
      return this;
    }
    
    public Builder clearVendorDeviceId() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).clearVendorDeviceId();
      return this;
    }
    
    public String getApiKey() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getApiKey();
    }
    
    public ByteString getApiKeyBytes() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getApiKeyBytes();
    }
    
    public String getAppId() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getAppId();
    }
    
    public ByteString getAppIdBytes() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getAppIdBytes();
    }
    
    public String getAppInstanceId() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getAppInstanceId();
    }
    
    public ByteString getAppInstanceIdBytes() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getAppInstanceIdBytes();
    }
    
    public String getAppStore() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getAppStore();
    }
    
    public ByteString getAppStoreBytes() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getAppStoreBytes();
    }
    
    public int getAppVersionMajor() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getAppVersionMajor();
    }
    
    public int getAppVersionMinor() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getAppVersionMinor();
    }
    
    public int getAppVersionRelease() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getAppVersionRelease();
    }
    
    public String getDeviceModel() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getDeviceModel();
    }
    
    public ByteString getDeviceModelBytes() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getDeviceModelBytes();
    }
    
    public GmpMeasurementPublic.FirebaseAnalyticsEvent getEvent(int param1Int) {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getEvent(param1Int);
    }
    
    public int getEventCount() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getEventCount();
    }
    
    public List<GmpMeasurementPublic.FirebaseAnalyticsEvent> getEventList() {
      return Collections.unmodifiableList(((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getEventList());
    }
    
    public String getIpAddress() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getIpAddress();
    }
    
    public ByteString getIpAddressBytes() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getIpAddressBytes();
    }
    
    public boolean getLimitedAdTracking() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getLimitedAdTracking();
    }
    
    public String getOsVersion() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getOsVersion();
    }
    
    public ByteString getOsVersionBytes() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getOsVersionBytes();
    }
    
    public String getPackageName() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getPackageName();
    }
    
    public ByteString getPackageNameBytes() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getPackageNameBytes();
    }
    
    public String getPlatform() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getPlatform();
    }
    
    public ByteString getPlatformBytes() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getPlatformBytes();
    }
    
    public String getResettableDeviceId() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getResettableDeviceId();
    }
    
    public ByteString getResettableDeviceIdBytes() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getResettableDeviceIdBytes();
    }
    
    public long getUploadTimestampMillis() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getUploadTimestampMillis();
    }
    
    public String getUserDefaultLanguage() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getUserDefaultLanguage();
    }
    
    public ByteString getUserDefaultLanguageBytes() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getUserDefaultLanguageBytes();
    }
    
    public GmpMeasurementPublic.FirebaseAnalyticsUserAttribute getUserProperty(int param1Int) {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getUserProperty(param1Int);
    }
    
    public int getUserPropertyCount() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getUserPropertyCount();
    }
    
    public List<GmpMeasurementPublic.FirebaseAnalyticsUserAttribute> getUserPropertyList() {
      return Collections.unmodifiableList(((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getUserPropertyList());
    }
    
    public String getVendorDeviceId() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getVendorDeviceId();
    }
    
    public ByteString getVendorDeviceIdBytes() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).getVendorDeviceIdBytes();
    }
    
    public boolean hasApiKey() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasApiKey();
    }
    
    public boolean hasAppId() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasAppId();
    }
    
    public boolean hasAppInstanceId() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasAppInstanceId();
    }
    
    public boolean hasAppStore() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasAppStore();
    }
    
    public boolean hasAppVersionMajor() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasAppVersionMajor();
    }
    
    public boolean hasAppVersionMinor() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasAppVersionMinor();
    }
    
    public boolean hasAppVersionRelease() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasAppVersionRelease();
    }
    
    public boolean hasDeviceModel() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasDeviceModel();
    }
    
    public boolean hasIpAddress() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasIpAddress();
    }
    
    public boolean hasLimitedAdTracking() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasLimitedAdTracking();
    }
    
    public boolean hasOsVersion() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasOsVersion();
    }
    
    public boolean hasPackageName() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasPackageName();
    }
    
    public boolean hasPlatform() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasPlatform();
    }
    
    public boolean hasResettableDeviceId() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasResettableDeviceId();
    }
    
    public boolean hasUploadTimestampMillis() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasUploadTimestampMillis();
    }
    
    public boolean hasUserDefaultLanguage() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasUserDefaultLanguage();
    }
    
    public boolean hasVendorDeviceId() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).hasVendorDeviceId();
    }
    
    public Builder removeEvent(int param1Int) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).removeEvent(param1Int);
      return this;
    }
    
    public Builder removeUserProperty(int param1Int) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).removeUserProperty(param1Int);
      return this;
    }
    
    public Builder setApiKey(String param1String) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setApiKey(param1String);
      return this;
    }
    
    public Builder setApiKeyBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setApiKeyBytes(param1ByteString);
      return this;
    }
    
    public Builder setAppId(String param1String) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setAppId(param1String);
      return this;
    }
    
    public Builder setAppIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setAppIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setAppInstanceId(String param1String) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setAppInstanceId(param1String);
      return this;
    }
    
    public Builder setAppInstanceIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setAppInstanceIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setAppStore(String param1String) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setAppStore(param1String);
      return this;
    }
    
    public Builder setAppStoreBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setAppStoreBytes(param1ByteString);
      return this;
    }
    
    public Builder setAppVersionMajor(int param1Int) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setAppVersionMajor(param1Int);
      return this;
    }
    
    public Builder setAppVersionMinor(int param1Int) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setAppVersionMinor(param1Int);
      return this;
    }
    
    public Builder setAppVersionRelease(int param1Int) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setAppVersionRelease(param1Int);
      return this;
    }
    
    public Builder setDeviceModel(String param1String) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setDeviceModel(param1String);
      return this;
    }
    
    public Builder setDeviceModelBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setDeviceModelBytes(param1ByteString);
      return this;
    }
    
    public Builder setEvent(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsEvent.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setEvent(param1Int, param1Builder);
      return this;
    }
    
    public Builder setEvent(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsEvent param1FirebaseAnalyticsEvent) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setEvent(param1Int, param1FirebaseAnalyticsEvent);
      return this;
    }
    
    public Builder setIpAddress(String param1String) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setIpAddress(param1String);
      return this;
    }
    
    public Builder setIpAddressBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setIpAddressBytes(param1ByteString);
      return this;
    }
    
    public Builder setLimitedAdTracking(boolean param1Boolean) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setLimitedAdTracking(param1Boolean);
      return this;
    }
    
    public Builder setOsVersion(String param1String) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setOsVersion(param1String);
      return this;
    }
    
    public Builder setOsVersionBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setOsVersionBytes(param1ByteString);
      return this;
    }
    
    public Builder setPackageName(String param1String) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setPackageName(param1String);
      return this;
    }
    
    public Builder setPackageNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setPackageNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setPlatform(String param1String) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setPlatform(param1String);
      return this;
    }
    
    public Builder setPlatformBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setPlatformBytes(param1ByteString);
      return this;
    }
    
    public Builder setResettableDeviceId(String param1String) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setResettableDeviceId(param1String);
      return this;
    }
    
    public Builder setResettableDeviceIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setResettableDeviceIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setUploadTimestampMillis(long param1Long) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setUploadTimestampMillis(param1Long);
      return this;
    }
    
    public Builder setUserDefaultLanguage(String param1String) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setUserDefaultLanguage(param1String);
      return this;
    }
    
    public Builder setUserDefaultLanguageBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setUserDefaultLanguageBytes(param1ByteString);
      return this;
    }
    
    public Builder setUserProperty(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsUserAttribute.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setUserProperty(param1Int, param1Builder);
      return this;
    }
    
    public Builder setUserProperty(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsUserAttribute param1FirebaseAnalyticsUserAttribute) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setUserProperty(param1Int, param1FirebaseAnalyticsUserAttribute);
      return this;
    }
    
    public Builder setVendorDeviceId(String param1String) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setVendorDeviceId(param1String);
      return this;
    }
    
    public Builder setVendorDeviceIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsApiRequest)this.instance).setVendorDeviceIdBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface FirebaseAnalyticsApiRequestOrBuilder extends MessageLiteOrBuilder {
    String getApiKey();
    
    ByteString getApiKeyBytes();
    
    String getAppId();
    
    ByteString getAppIdBytes();
    
    String getAppInstanceId();
    
    ByteString getAppInstanceIdBytes();
    
    String getAppStore();
    
    ByteString getAppStoreBytes();
    
    int getAppVersionMajor();
    
    int getAppVersionMinor();
    
    int getAppVersionRelease();
    
    String getDeviceModel();
    
    ByteString getDeviceModelBytes();
    
    GmpMeasurementPublic.FirebaseAnalyticsEvent getEvent(int param1Int);
    
    int getEventCount();
    
    List<GmpMeasurementPublic.FirebaseAnalyticsEvent> getEventList();
    
    String getIpAddress();
    
    ByteString getIpAddressBytes();
    
    boolean getLimitedAdTracking();
    
    String getOsVersion();
    
    ByteString getOsVersionBytes();
    
    String getPackageName();
    
    ByteString getPackageNameBytes();
    
    String getPlatform();
    
    ByteString getPlatformBytes();
    
    String getResettableDeviceId();
    
    ByteString getResettableDeviceIdBytes();
    
    long getUploadTimestampMillis();
    
    String getUserDefaultLanguage();
    
    ByteString getUserDefaultLanguageBytes();
    
    GmpMeasurementPublic.FirebaseAnalyticsUserAttribute getUserProperty(int param1Int);
    
    int getUserPropertyCount();
    
    List<GmpMeasurementPublic.FirebaseAnalyticsUserAttribute> getUserPropertyList();
    
    String getVendorDeviceId();
    
    ByteString getVendorDeviceIdBytes();
    
    boolean hasApiKey();
    
    boolean hasAppId();
    
    boolean hasAppInstanceId();
    
    boolean hasAppStore();
    
    boolean hasAppVersionMajor();
    
    boolean hasAppVersionMinor();
    
    boolean hasAppVersionRelease();
    
    boolean hasDeviceModel();
    
    boolean hasIpAddress();
    
    boolean hasLimitedAdTracking();
    
    boolean hasOsVersion();
    
    boolean hasPackageName();
    
    boolean hasPlatform();
    
    boolean hasResettableDeviceId();
    
    boolean hasUploadTimestampMillis();
    
    boolean hasUserDefaultLanguage();
    
    boolean hasVendorDeviceId();
  }
  
  public static final class FirebaseAnalyticsEvent extends GeneratedMessageLite<FirebaseAnalyticsEvent, FirebaseAnalyticsEvent.Builder> implements FirebaseAnalyticsEventOrBuilder {
    private static final FirebaseAnalyticsEvent DEFAULT_INSTANCE = new FirebaseAnalyticsEvent();
    
    public static final int NAME_FIELD_NUMBER = 2;
    
    public static final int PARAMS_FIELD_NUMBER = 1;
    
    private static volatile Parser<FirebaseAnalyticsEvent> PARSER;
    
    public static final int TIMESTAMP_MILLIS_FIELD_NUMBER = 3;
    
    private int bitField0_;
    
    private String name_ = "";
    
    private Internal.ProtobufList<GmpMeasurementPublic.FirebaseAnalyticsEventParam> params_ = emptyProtobufList();
    
    private long timestampMillis_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllParams(Iterable<? extends GmpMeasurementPublic.FirebaseAnalyticsEventParam> param1Iterable) {
      ensureParamsIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.params_);
    }
    
    private void addParams(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsEventParam.Builder param1Builder) {
      ensureParamsIsMutable();
      this.params_.add(param1Int, param1Builder.build());
    }
    
    private void addParams(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsEventParam param1FirebaseAnalyticsEventParam) {
      if (param1FirebaseAnalyticsEventParam != null) {
        ensureParamsIsMutable();
        this.params_.add(param1Int, param1FirebaseAnalyticsEventParam);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addParams(GmpMeasurementPublic.FirebaseAnalyticsEventParam.Builder param1Builder) {
      ensureParamsIsMutable();
      this.params_.add(param1Builder.build());
    }
    
    private void addParams(GmpMeasurementPublic.FirebaseAnalyticsEventParam param1FirebaseAnalyticsEventParam) {
      if (param1FirebaseAnalyticsEventParam != null) {
        ensureParamsIsMutable();
        this.params_.add(param1FirebaseAnalyticsEventParam);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearName() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.name_ = getDefaultInstance().getName();
    }
    
    private void clearParams() {
      this.params_ = emptyProtobufList();
    }
    
    private void clearTimestampMillis() {
      this.bitField0_ &= 0xFFFFFFFD;
      this.timestampMillis_ = 0L;
    }
    
    private void ensureParamsIsMutable() {
      if (!this.params_.isModifiable())
        this.params_ = GeneratedMessageLite.mutableCopy(this.params_); 
    }
    
    public static FirebaseAnalyticsEvent getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(FirebaseAnalyticsEvent param1FirebaseAnalyticsEvent) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1FirebaseAnalyticsEvent);
    }
    
    public static FirebaseAnalyticsEvent parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (FirebaseAnalyticsEvent)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static FirebaseAnalyticsEvent parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FirebaseAnalyticsEvent)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FirebaseAnalyticsEvent parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (FirebaseAnalyticsEvent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static FirebaseAnalyticsEvent parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FirebaseAnalyticsEvent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static FirebaseAnalyticsEvent parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (FirebaseAnalyticsEvent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static FirebaseAnalyticsEvent parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FirebaseAnalyticsEvent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static FirebaseAnalyticsEvent parseFrom(InputStream param1InputStream) throws IOException {
      return (FirebaseAnalyticsEvent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static FirebaseAnalyticsEvent parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FirebaseAnalyticsEvent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FirebaseAnalyticsEvent parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (FirebaseAnalyticsEvent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static FirebaseAnalyticsEvent parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FirebaseAnalyticsEvent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<FirebaseAnalyticsEvent> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeParams(int param1Int) {
      ensureParamsIsMutable();
      this.params_.remove(param1Int);
    }
    
    private void setName(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x1;
        this.name_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x1;
        this.name_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setParams(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsEventParam.Builder param1Builder) {
      ensureParamsIsMutable();
      this.params_.set(param1Int, param1Builder.build());
    }
    
    private void setParams(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsEventParam param1FirebaseAnalyticsEventParam) {
      if (param1FirebaseAnalyticsEventParam != null) {
        ensureParamsIsMutable();
        this.params_.set(param1Int, param1FirebaseAnalyticsEventParam);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTimestampMillis(long param1Long) {
      this.bitField0_ |= 0x2;
      this.timestampMillis_ = param1Long;
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic analytics_collection/GmpMeasurementPublic$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 453, 2 -> 449, 3 -> 438, 4 -> 429, 5 -> 327, 6 -> 110, 7 -> 323, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEvent.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEvent
      //   72: monitorenter
      //   73: getstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEvent.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEvent.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEvent;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEvent.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEvent
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEvent
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEvent.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 323
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 267
      //   139: iload #5
      //   141: bipush #10
      //   143: if_icmpeq -> 220
      //   146: iload #5
      //   148: bipush #18
      //   150: if_icmpeq -> 197
      //   153: iload #5
      //   155: bipush #24
      //   157: if_icmpeq -> 176
      //   160: aload_0
      //   161: iload #5
      //   163: aload_1
      //   164: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   167: ifne -> 123
      //   170: iconst_1
      //   171: istore #4
      //   173: goto -> 123
      //   176: aload_0
      //   177: aload_0
      //   178: getfield bitField0_ : I
      //   181: iconst_2
      //   182: ior
      //   183: putfield bitField0_ : I
      //   186: aload_0
      //   187: aload_1
      //   188: invokevirtual readInt64 : ()J
      //   191: putfield timestampMillis_ : J
      //   194: goto -> 123
      //   197: aload_1
      //   198: invokevirtual readString : ()Ljava/lang/String;
      //   201: astore_3
      //   202: aload_0
      //   203: iconst_1
      //   204: aload_0
      //   205: getfield bitField0_ : I
      //   208: ior
      //   209: putfield bitField0_ : I
      //   212: aload_0
      //   213: aload_3
      //   214: putfield name_ : Ljava/lang/String;
      //   217: goto -> 123
      //   220: aload_0
      //   221: getfield params_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   224: invokeinterface isModifiable : ()Z
      //   229: ifne -> 243
      //   232: aload_0
      //   233: aload_0
      //   234: getfield params_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   237: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   240: putfield params_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   243: aload_0
      //   244: getfield params_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   247: aload_1
      //   248: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   251: aload_2
      //   252: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   255: checkcast analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEventParam
      //   258: invokeinterface add : (Ljava/lang/Object;)Z
      //   263: pop
      //   264: goto -> 123
      //   267: iconst_1
      //   268: istore #4
      //   270: goto -> 123
      //   273: astore_1
      //   274: goto -> 321
      //   277: astore_3
      //   278: new java/lang/RuntimeException
      //   281: astore_1
      //   282: new com/google/protobuf/InvalidProtocolBufferException
      //   285: astore_2
      //   286: aload_2
      //   287: aload_3
      //   288: invokevirtual getMessage : ()Ljava/lang/String;
      //   291: invokespecial <init> : (Ljava/lang/String;)V
      //   294: aload_1
      //   295: aload_2
      //   296: aload_0
      //   297: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   300: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   303: aload_1
      //   304: athrow
      //   305: astore_2
      //   306: new java/lang/RuntimeException
      //   309: astore_1
      //   310: aload_1
      //   311: aload_2
      //   312: aload_0
      //   313: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   316: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   319: aload_1
      //   320: athrow
      //   321: aload_1
      //   322: athrow
      //   323: getstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEvent.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEvent;
      //   326: areturn
      //   327: aload_2
      //   328: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   331: astore_1
      //   332: aload_3
      //   333: checkcast analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEvent
      //   336: astore_2
      //   337: aload_0
      //   338: aload_1
      //   339: aload_0
      //   340: getfield params_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   343: aload_2
      //   344: getfield params_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   347: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   352: putfield params_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   355: aload_0
      //   356: aload_1
      //   357: aload_0
      //   358: invokevirtual hasName : ()Z
      //   361: aload_0
      //   362: getfield name_ : Ljava/lang/String;
      //   365: aload_2
      //   366: invokevirtual hasName : ()Z
      //   369: aload_2
      //   370: getfield name_ : Ljava/lang/String;
      //   373: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   378: putfield name_ : Ljava/lang/String;
      //   381: aload_0
      //   382: aload_1
      //   383: aload_0
      //   384: invokevirtual hasTimestampMillis : ()Z
      //   387: aload_0
      //   388: getfield timestampMillis_ : J
      //   391: aload_2
      //   392: invokevirtual hasTimestampMillis : ()Z
      //   395: aload_2
      //   396: getfield timestampMillis_ : J
      //   399: invokeinterface visitLong : (ZJZJ)J
      //   404: putfield timestampMillis_ : J
      //   407: aload_1
      //   408: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   411: if_acmpne -> 427
      //   414: aload_0
      //   415: aload_0
      //   416: getfield bitField0_ : I
      //   419: aload_2
      //   420: getfield bitField0_ : I
      //   423: ior
      //   424: putfield bitField0_ : I
      //   427: aload_0
      //   428: areturn
      //   429: new analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEvent$Builder
      //   432: dup
      //   433: aconst_null
      //   434: invokespecial <init> : (Lanalytics_collection/GmpMeasurementPublic$1;)V
      //   437: areturn
      //   438: aload_0
      //   439: getfield params_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   442: invokeinterface makeImmutable : ()V
      //   447: aconst_null
      //   448: areturn
      //   449: getstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEvent.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEvent;
      //   452: areturn
      //   453: new analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEvent
      //   456: dup
      //   457: invokespecial <init> : ()V
      //   460: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	305	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	277	java/io/IOException
      //   128	134	273	finally
      //   160	170	305	com/google/protobuf/InvalidProtocolBufferException
      //   160	170	277	java/io/IOException
      //   160	170	273	finally
      //   176	194	305	com/google/protobuf/InvalidProtocolBufferException
      //   176	194	277	java/io/IOException
      //   176	194	273	finally
      //   197	217	305	com/google/protobuf/InvalidProtocolBufferException
      //   197	217	277	java/io/IOException
      //   197	217	273	finally
      //   220	243	305	com/google/protobuf/InvalidProtocolBufferException
      //   220	243	277	java/io/IOException
      //   220	243	273	finally
      //   243	264	305	com/google/protobuf/InvalidProtocolBufferException
      //   243	264	277	java/io/IOException
      //   243	264	273	finally
      //   278	305	273	finally
      //   306	321	273	finally
    }
    
    public String getName() {
      return this.name_;
    }
    
    public ByteString getNameBytes() {
      return ByteString.copyFromUtf8(this.name_);
    }
    
    public GmpMeasurementPublic.FirebaseAnalyticsEventParam getParams(int param1Int) {
      return (GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.params_.get(param1Int);
    }
    
    public int getParamsCount() {
      return this.params_.size();
    }
    
    public List<GmpMeasurementPublic.FirebaseAnalyticsEventParam> getParamsList() {
      return (List<GmpMeasurementPublic.FirebaseAnalyticsEventParam>)this.params_;
    }
    
    public GmpMeasurementPublic.FirebaseAnalyticsEventParamOrBuilder getParamsOrBuilder(int param1Int) {
      return (GmpMeasurementPublic.FirebaseAnalyticsEventParamOrBuilder)this.params_.get(param1Int);
    }
    
    public List<? extends GmpMeasurementPublic.FirebaseAnalyticsEventParamOrBuilder> getParamsOrBuilderList() {
      return (List)this.params_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      int j = 0;
      i = 0;
      while (j < this.params_.size()) {
        i += CodedOutputStream.computeMessageSize(1, (MessageLite)this.params_.get(j));
        j++;
      } 
      j = i;
      if ((this.bitField0_ & 0x1) == 1)
        j = i + CodedOutputStream.computeStringSize(2, getName()); 
      i = j;
      if ((this.bitField0_ & 0x2) == 2)
        i = j + CodedOutputStream.computeInt64Size(3, this.timestampMillis_); 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public long getTimestampMillis() {
      return this.timestampMillis_;
    }
    
    public boolean hasName() {
      int i = this.bitField0_;
      boolean bool = true;
      if ((i & 0x1) != 1)
        bool = false; 
      return bool;
    }
    
    public boolean hasTimestampMillis() {
      boolean bool;
      if ((this.bitField0_ & 0x2) == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      for (byte b = 0; b < this.params_.size(); b++)
        param1CodedOutputStream.writeMessage(1, (MessageLite)this.params_.get(b)); 
      if ((this.bitField0_ & 0x1) == 1)
        param1CodedOutputStream.writeString(2, getName()); 
      if ((this.bitField0_ & 0x2) == 2)
        param1CodedOutputStream.writeInt64(3, this.timestampMillis_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<FirebaseAnalyticsEvent, Builder> implements GmpMeasurementPublic.FirebaseAnalyticsEventOrBuilder {
      private Builder() {
        super(GmpMeasurementPublic.FirebaseAnalyticsEvent.DEFAULT_INSTANCE);
      }
      
      public Builder addAllParams(Iterable<? extends GmpMeasurementPublic.FirebaseAnalyticsEventParam> param2Iterable) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).addAllParams(param2Iterable);
        return this;
      }
      
      public Builder addParams(int param2Int, GmpMeasurementPublic.FirebaseAnalyticsEventParam.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).addParams(param2Int, param2Builder);
        return this;
      }
      
      public Builder addParams(int param2Int, GmpMeasurementPublic.FirebaseAnalyticsEventParam param2FirebaseAnalyticsEventParam) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).addParams(param2Int, param2FirebaseAnalyticsEventParam);
        return this;
      }
      
      public Builder addParams(GmpMeasurementPublic.FirebaseAnalyticsEventParam.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).addParams(param2Builder);
        return this;
      }
      
      public Builder addParams(GmpMeasurementPublic.FirebaseAnalyticsEventParam param2FirebaseAnalyticsEventParam) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).addParams(param2FirebaseAnalyticsEventParam);
        return this;
      }
      
      public Builder clearName() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).clearName();
        return this;
      }
      
      public Builder clearParams() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).clearParams();
        return this;
      }
      
      public Builder clearTimestampMillis() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).clearTimestampMillis();
        return this;
      }
      
      public String getName() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).getName();
      }
      
      public ByteString getNameBytes() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).getNameBytes();
      }
      
      public GmpMeasurementPublic.FirebaseAnalyticsEventParam getParams(int param2Int) {
        return ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).getParams(param2Int);
      }
      
      public int getParamsCount() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).getParamsCount();
      }
      
      public List<GmpMeasurementPublic.FirebaseAnalyticsEventParam> getParamsList() {
        return Collections.unmodifiableList(((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).getParamsList());
      }
      
      public long getTimestampMillis() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).getTimestampMillis();
      }
      
      public boolean hasName() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).hasName();
      }
      
      public boolean hasTimestampMillis() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).hasTimestampMillis();
      }
      
      public Builder removeParams(int param2Int) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).removeParams(param2Int);
        return this;
      }
      
      public Builder setName(String param2String) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).setName(param2String);
        return this;
      }
      
      public Builder setNameBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).setNameBytes(param2ByteString);
        return this;
      }
      
      public Builder setParams(int param2Int, GmpMeasurementPublic.FirebaseAnalyticsEventParam.Builder param2Builder) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).setParams(param2Int, param2Builder);
        return this;
      }
      
      public Builder setParams(int param2Int, GmpMeasurementPublic.FirebaseAnalyticsEventParam param2FirebaseAnalyticsEventParam) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).setParams(param2Int, param2FirebaseAnalyticsEventParam);
        return this;
      }
      
      public Builder setTimestampMillis(long param2Long) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).setTimestampMillis(param2Long);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<FirebaseAnalyticsEvent, FirebaseAnalyticsEvent.Builder> implements FirebaseAnalyticsEventOrBuilder {
    private Builder() {
      super(GmpMeasurementPublic.FirebaseAnalyticsEvent.DEFAULT_INSTANCE);
    }
    
    public Builder addAllParams(Iterable<? extends GmpMeasurementPublic.FirebaseAnalyticsEventParam> param1Iterable) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).addAllParams(param1Iterable);
      return this;
    }
    
    public Builder addParams(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsEventParam.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).addParams(param1Int, param1Builder);
      return this;
    }
    
    public Builder addParams(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsEventParam param1FirebaseAnalyticsEventParam) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).addParams(param1Int, param1FirebaseAnalyticsEventParam);
      return this;
    }
    
    public Builder addParams(GmpMeasurementPublic.FirebaseAnalyticsEventParam.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).addParams(param1Builder);
      return this;
    }
    
    public Builder addParams(GmpMeasurementPublic.FirebaseAnalyticsEventParam param1FirebaseAnalyticsEventParam) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).addParams(param1FirebaseAnalyticsEventParam);
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).clearName();
      return this;
    }
    
    public Builder clearParams() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).clearParams();
      return this;
    }
    
    public Builder clearTimestampMillis() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).clearTimestampMillis();
      return this;
    }
    
    public String getName() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).getName();
    }
    
    public ByteString getNameBytes() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).getNameBytes();
    }
    
    public GmpMeasurementPublic.FirebaseAnalyticsEventParam getParams(int param1Int) {
      return ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).getParams(param1Int);
    }
    
    public int getParamsCount() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).getParamsCount();
    }
    
    public List<GmpMeasurementPublic.FirebaseAnalyticsEventParam> getParamsList() {
      return Collections.unmodifiableList(((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).getParamsList());
    }
    
    public long getTimestampMillis() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).getTimestampMillis();
    }
    
    public boolean hasName() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).hasName();
    }
    
    public boolean hasTimestampMillis() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).hasTimestampMillis();
    }
    
    public Builder removeParams(int param1Int) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).removeParams(param1Int);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).setNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setParams(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsEventParam.Builder param1Builder) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).setParams(param1Int, param1Builder);
      return this;
    }
    
    public Builder setParams(int param1Int, GmpMeasurementPublic.FirebaseAnalyticsEventParam param1FirebaseAnalyticsEventParam) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).setParams(param1Int, param1FirebaseAnalyticsEventParam);
      return this;
    }
    
    public Builder setTimestampMillis(long param1Long) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsEvent)this.instance).setTimestampMillis(param1Long);
      return this;
    }
  }
  
  public static interface FirebaseAnalyticsEventOrBuilder extends MessageLiteOrBuilder {
    String getName();
    
    ByteString getNameBytes();
    
    GmpMeasurementPublic.FirebaseAnalyticsEventParam getParams(int param1Int);
    
    int getParamsCount();
    
    List<GmpMeasurementPublic.FirebaseAnalyticsEventParam> getParamsList();
    
    long getTimestampMillis();
    
    boolean hasName();
    
    boolean hasTimestampMillis();
  }
  
  public static final class FirebaseAnalyticsEventParam extends GeneratedMessageLite<FirebaseAnalyticsEventParam, FirebaseAnalyticsEventParam.Builder> implements FirebaseAnalyticsEventParamOrBuilder {
    private static final FirebaseAnalyticsEventParam DEFAULT_INSTANCE = new FirebaseAnalyticsEventParam();
    
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 4;
    
    public static final int INT_VALUE_FIELD_NUMBER = 3;
    
    public static final int NAME_FIELD_NUMBER = 1;
    
    private static volatile Parser<FirebaseAnalyticsEventParam> PARSER;
    
    public static final int STRING_VALUE_FIELD_NUMBER = 2;
    
    private int bitField0_;
    
    private String name_ = "";
    
    private int paramValueCase_ = 0;
    
    private Object paramValue_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearDoubleValue() {
      if (this.paramValueCase_ == 4) {
        this.paramValueCase_ = 0;
        this.paramValue_ = null;
      } 
    }
    
    private void clearIntValue() {
      if (this.paramValueCase_ == 3) {
        this.paramValueCase_ = 0;
        this.paramValue_ = null;
      } 
    }
    
    private void clearName() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.name_ = getDefaultInstance().getName();
    }
    
    private void clearParamValue() {
      this.paramValueCase_ = 0;
      this.paramValue_ = null;
    }
    
    private void clearStringValue() {
      if (this.paramValueCase_ == 2) {
        this.paramValueCase_ = 0;
        this.paramValue_ = null;
      } 
    }
    
    public static FirebaseAnalyticsEventParam getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(FirebaseAnalyticsEventParam param1FirebaseAnalyticsEventParam) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1FirebaseAnalyticsEventParam);
    }
    
    public static FirebaseAnalyticsEventParam parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (FirebaseAnalyticsEventParam)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static FirebaseAnalyticsEventParam parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FirebaseAnalyticsEventParam)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FirebaseAnalyticsEventParam parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (FirebaseAnalyticsEventParam)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static FirebaseAnalyticsEventParam parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FirebaseAnalyticsEventParam)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static FirebaseAnalyticsEventParam parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (FirebaseAnalyticsEventParam)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static FirebaseAnalyticsEventParam parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FirebaseAnalyticsEventParam)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static FirebaseAnalyticsEventParam parseFrom(InputStream param1InputStream) throws IOException {
      return (FirebaseAnalyticsEventParam)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static FirebaseAnalyticsEventParam parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FirebaseAnalyticsEventParam)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FirebaseAnalyticsEventParam parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (FirebaseAnalyticsEventParam)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static FirebaseAnalyticsEventParam parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FirebaseAnalyticsEventParam)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<FirebaseAnalyticsEventParam> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setDoubleValue(double param1Double) {
      this.paramValueCase_ = 4;
      this.paramValue_ = Double.valueOf(param1Double);
    }
    
    private void setIntValue(long param1Long) {
      this.paramValueCase_ = 3;
      this.paramValue_ = Long.valueOf(param1Long);
    }
    
    private void setName(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x1;
        this.name_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x1;
        this.name_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setStringValue(String param1String) {
      if (param1String != null) {
        this.paramValueCase_ = 2;
        this.paramValue_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setStringValueBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.paramValueCase_ = 2;
        this.paramValue_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic analytics_collection/GmpMeasurementPublic$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
      //   25: iload #4
      //   27: tableswitch default -> 72, 1 -> 601, 2 -> 597, 3 -> 595, 4 -> 586, 5 -> 335, 6 -> 126, 7 -> 331, 8 -> 80
      //   72: new java/lang/UnsupportedOperationException
      //   75: dup
      //   76: invokespecial <init> : ()V
      //   79: athrow
      //   80: getstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEventParam.PARSER : Lcom/google/protobuf/Parser;
      //   83: ifnonnull -> 122
      //   86: ldc analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEventParam
      //   88: monitorenter
      //   89: getstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEventParam.PARSER : Lcom/google/protobuf/Parser;
      //   92: ifnonnull -> 110
      //   95: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   98: astore_1
      //   99: aload_1
      //   100: getstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEventParam.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEventParam;
      //   103: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   106: aload_1
      //   107: putstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEventParam.PARSER : Lcom/google/protobuf/Parser;
      //   110: ldc analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEventParam
      //   112: monitorexit
      //   113: goto -> 122
      //   116: astore_1
      //   117: ldc analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEventParam
      //   119: monitorexit
      //   120: aload_1
      //   121: athrow
      //   122: getstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEventParam.PARSER : Lcom/google/protobuf/Parser;
      //   125: areturn
      //   126: aload_2
      //   127: checkcast com/google/protobuf/CodedInputStream
      //   130: astore_1
      //   131: aload_3
      //   132: checkcast com/google/protobuf/ExtensionRegistryLite
      //   135: astore_2
      //   136: iload #9
      //   138: ifne -> 331
      //   141: aload_1
      //   142: invokevirtual readTag : ()I
      //   145: istore #4
      //   147: iload #4
      //   149: ifeq -> 275
      //   152: iload #4
      //   154: bipush #10
      //   156: if_icmpeq -> 252
      //   159: iload #4
      //   161: bipush #18
      //   163: if_icmpeq -> 234
      //   166: iload #4
      //   168: bipush #24
      //   170: if_icmpeq -> 215
      //   173: iload #4
      //   175: bipush #33
      //   177: if_icmpeq -> 196
      //   180: aload_0
      //   181: iload #4
      //   183: aload_1
      //   184: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   187: ifne -> 136
      //   190: iconst_1
      //   191: istore #9
      //   193: goto -> 136
      //   196: aload_0
      //   197: iconst_4
      //   198: putfield paramValueCase_ : I
      //   201: aload_0
      //   202: aload_1
      //   203: invokevirtual readDouble : ()D
      //   206: invokestatic valueOf : (D)Ljava/lang/Double;
      //   209: putfield paramValue_ : Ljava/lang/Object;
      //   212: goto -> 136
      //   215: aload_0
      //   216: iconst_3
      //   217: putfield paramValueCase_ : I
      //   220: aload_0
      //   221: aload_1
      //   222: invokevirtual readInt64 : ()J
      //   225: invokestatic valueOf : (J)Ljava/lang/Long;
      //   228: putfield paramValue_ : Ljava/lang/Object;
      //   231: goto -> 136
      //   234: aload_1
      //   235: invokevirtual readString : ()Ljava/lang/String;
      //   238: astore_2
      //   239: aload_0
      //   240: iconst_2
      //   241: putfield paramValueCase_ : I
      //   244: aload_0
      //   245: aload_2
      //   246: putfield paramValue_ : Ljava/lang/Object;
      //   249: goto -> 136
      //   252: aload_1
      //   253: invokevirtual readString : ()Ljava/lang/String;
      //   256: astore_2
      //   257: aload_0
      //   258: aload_0
      //   259: getfield bitField0_ : I
      //   262: iconst_1
      //   263: ior
      //   264: putfield bitField0_ : I
      //   267: aload_0
      //   268: aload_2
      //   269: putfield name_ : Ljava/lang/String;
      //   272: goto -> 136
      //   275: iconst_1
      //   276: istore #9
      //   278: goto -> 136
      //   281: astore_1
      //   282: goto -> 329
      //   285: astore_1
      //   286: new java/lang/RuntimeException
      //   289: astore_3
      //   290: new com/google/protobuf/InvalidProtocolBufferException
      //   293: astore_2
      //   294: aload_2
      //   295: aload_1
      //   296: invokevirtual getMessage : ()Ljava/lang/String;
      //   299: invokespecial <init> : (Ljava/lang/String;)V
      //   302: aload_3
      //   303: aload_2
      //   304: aload_0
      //   305: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   308: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   311: aload_3
      //   312: athrow
      //   313: astore_1
      //   314: new java/lang/RuntimeException
      //   317: astore_2
      //   318: aload_2
      //   319: aload_1
      //   320: aload_0
      //   321: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   324: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   327: aload_2
      //   328: athrow
      //   329: aload_1
      //   330: athrow
      //   331: getstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEventParam.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEventParam;
      //   334: areturn
      //   335: aload_2
      //   336: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   339: astore_1
      //   340: aload_3
      //   341: checkcast analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEventParam
      //   344: astore_2
      //   345: aload_0
      //   346: aload_1
      //   347: aload_0
      //   348: invokevirtual hasName : ()Z
      //   351: aload_0
      //   352: getfield name_ : Ljava/lang/String;
      //   355: aload_2
      //   356: invokevirtual hasName : ()Z
      //   359: aload_2
      //   360: getfield name_ : Ljava/lang/String;
      //   363: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   368: putfield name_ : Ljava/lang/String;
      //   371: getstatic analytics_collection/GmpMeasurementPublic$1.$SwitchMap$analytics_collection$GmpMeasurementPublic$FirebaseAnalyticsEventParam$ParamValueCase : [I
      //   374: aload_2
      //   375: invokevirtual getParamValueCase : ()Lanalytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEventParam$ParamValueCase;
      //   378: invokevirtual ordinal : ()I
      //   381: iaload
      //   382: tableswitch default -> 412, 1 -> 512, 2 -> 474, 3 -> 436, 4 -> 415
      //   412: goto -> 547
      //   415: aload_0
      //   416: getfield paramValueCase_ : I
      //   419: ifeq -> 425
      //   422: iconst_1
      //   423: istore #5
      //   425: aload_1
      //   426: iload #5
      //   428: invokeinterface visitOneofNotSet : (Z)V
      //   433: goto -> 547
      //   436: iload #6
      //   438: istore #5
      //   440: aload_0
      //   441: getfield paramValueCase_ : I
      //   444: iconst_4
      //   445: if_icmpne -> 451
      //   448: iconst_1
      //   449: istore #5
      //   451: aload_0
      //   452: aload_1
      //   453: iload #5
      //   455: aload_0
      //   456: getfield paramValue_ : Ljava/lang/Object;
      //   459: aload_2
      //   460: getfield paramValue_ : Ljava/lang/Object;
      //   463: invokeinterface visitOneofDouble : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   468: putfield paramValue_ : Ljava/lang/Object;
      //   471: goto -> 547
      //   474: iload #7
      //   476: istore #5
      //   478: aload_0
      //   479: getfield paramValueCase_ : I
      //   482: iconst_3
      //   483: if_icmpne -> 489
      //   486: iconst_1
      //   487: istore #5
      //   489: aload_0
      //   490: aload_1
      //   491: iload #5
      //   493: aload_0
      //   494: getfield paramValue_ : Ljava/lang/Object;
      //   497: aload_2
      //   498: getfield paramValue_ : Ljava/lang/Object;
      //   501: invokeinterface visitOneofLong : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   506: putfield paramValue_ : Ljava/lang/Object;
      //   509: goto -> 547
      //   512: iload #8
      //   514: istore #5
      //   516: aload_0
      //   517: getfield paramValueCase_ : I
      //   520: iconst_2
      //   521: if_icmpne -> 527
      //   524: iconst_1
      //   525: istore #5
      //   527: aload_0
      //   528: aload_1
      //   529: iload #5
      //   531: aload_0
      //   532: getfield paramValue_ : Ljava/lang/Object;
      //   535: aload_2
      //   536: getfield paramValue_ : Ljava/lang/Object;
      //   539: invokeinterface visitOneofString : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   544: putfield paramValue_ : Ljava/lang/Object;
      //   547: aload_1
      //   548: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   551: if_acmpne -> 584
      //   554: aload_2
      //   555: getfield paramValueCase_ : I
      //   558: istore #9
      //   560: iload #9
      //   562: ifeq -> 571
      //   565: aload_0
      //   566: iload #9
      //   568: putfield paramValueCase_ : I
      //   571: aload_0
      //   572: aload_0
      //   573: getfield bitField0_ : I
      //   576: aload_2
      //   577: getfield bitField0_ : I
      //   580: ior
      //   581: putfield bitField0_ : I
      //   584: aload_0
      //   585: areturn
      //   586: new analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEventParam$Builder
      //   589: dup
      //   590: aconst_null
      //   591: invokespecial <init> : (Lanalytics_collection/GmpMeasurementPublic$1;)V
      //   594: areturn
      //   595: aconst_null
      //   596: areturn
      //   597: getstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEventParam.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEventParam;
      //   600: areturn
      //   601: new analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsEventParam
      //   604: dup
      //   605: invokespecial <init> : ()V
      //   608: areturn
      // Exception table:
      //   from	to	target	type
      //   89	110	116	finally
      //   110	113	116	finally
      //   117	120	116	finally
      //   141	147	313	com/google/protobuf/InvalidProtocolBufferException
      //   141	147	285	java/io/IOException
      //   141	147	281	finally
      //   180	190	313	com/google/protobuf/InvalidProtocolBufferException
      //   180	190	285	java/io/IOException
      //   180	190	281	finally
      //   196	212	313	com/google/protobuf/InvalidProtocolBufferException
      //   196	212	285	java/io/IOException
      //   196	212	281	finally
      //   215	231	313	com/google/protobuf/InvalidProtocolBufferException
      //   215	231	285	java/io/IOException
      //   215	231	281	finally
      //   234	249	313	com/google/protobuf/InvalidProtocolBufferException
      //   234	249	285	java/io/IOException
      //   234	249	281	finally
      //   252	272	313	com/google/protobuf/InvalidProtocolBufferException
      //   252	272	285	java/io/IOException
      //   252	272	281	finally
      //   286	313	281	finally
      //   314	329	281	finally
    }
    
    public double getDoubleValue() {
      return (this.paramValueCase_ == 4) ? ((Double)this.paramValue_).doubleValue() : 0.0D;
    }
    
    public long getIntValue() {
      return (this.paramValueCase_ == 3) ? ((Long)this.paramValue_).longValue() : 0L;
    }
    
    public String getName() {
      return this.name_;
    }
    
    public ByteString getNameBytes() {
      return ByteString.copyFromUtf8(this.name_);
    }
    
    public ParamValueCase getParamValueCase() {
      return ParamValueCase.forNumber(this.paramValueCase_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if ((this.bitField0_ & 0x1) == 1)
        j = 0 + CodedOutputStream.computeStringSize(1, getName()); 
      i = j;
      if (this.paramValueCase_ == 2)
        i = j + CodedOutputStream.computeStringSize(2, getStringValue()); 
      j = i;
      if (this.paramValueCase_ == 3)
        j = i + CodedOutputStream.computeInt64Size(3, ((Long)this.paramValue_).longValue()); 
      i = j;
      if (this.paramValueCase_ == 4)
        i = j + CodedOutputStream.computeDoubleSize(4, ((Double)this.paramValue_).doubleValue()); 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public String getStringValue() {
      String str = "";
      if (this.paramValueCase_ == 2)
        str = (String)this.paramValue_; 
      return str;
    }
    
    public ByteString getStringValueBytes() {
      String str = "";
      if (this.paramValueCase_ == 2)
        str = (String)this.paramValue_; 
      return ByteString.copyFromUtf8(str);
    }
    
    public boolean hasDoubleValue() {
      boolean bool;
      if (this.paramValueCase_ == 4) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasIntValue() {
      boolean bool;
      if (this.paramValueCase_ == 3) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasName() {
      int i = this.bitField0_;
      boolean bool = true;
      if ((i & 0x1) != 1)
        bool = false; 
      return bool;
    }
    
    public boolean hasStringValue() {
      boolean bool;
      if (this.paramValueCase_ == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if ((this.bitField0_ & 0x1) == 1)
        param1CodedOutputStream.writeString(1, getName()); 
      if (this.paramValueCase_ == 2)
        param1CodedOutputStream.writeString(2, getStringValue()); 
      if (this.paramValueCase_ == 3)
        param1CodedOutputStream.writeInt64(3, ((Long)this.paramValue_).longValue()); 
      if (this.paramValueCase_ == 4)
        param1CodedOutputStream.writeDouble(4, ((Double)this.paramValue_).doubleValue()); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<FirebaseAnalyticsEventParam, Builder> implements GmpMeasurementPublic.FirebaseAnalyticsEventParamOrBuilder {
      private Builder() {
        super(GmpMeasurementPublic.FirebaseAnalyticsEventParam.DEFAULT_INSTANCE);
      }
      
      public Builder clearDoubleValue() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).clearDoubleValue();
        return this;
      }
      
      public Builder clearIntValue() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).clearIntValue();
        return this;
      }
      
      public Builder clearName() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).clearName();
        return this;
      }
      
      public Builder clearParamValue() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).clearParamValue();
        return this;
      }
      
      public Builder clearStringValue() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).clearStringValue();
        return this;
      }
      
      public double getDoubleValue() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).getDoubleValue();
      }
      
      public long getIntValue() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).getIntValue();
      }
      
      public String getName() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).getName();
      }
      
      public ByteString getNameBytes() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).getNameBytes();
      }
      
      public GmpMeasurementPublic.FirebaseAnalyticsEventParam.ParamValueCase getParamValueCase() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).getParamValueCase();
      }
      
      public String getStringValue() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).getStringValue();
      }
      
      public ByteString getStringValueBytes() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).getStringValueBytes();
      }
      
      public boolean hasDoubleValue() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).hasDoubleValue();
      }
      
      public boolean hasIntValue() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).hasIntValue();
      }
      
      public boolean hasName() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).hasName();
      }
      
      public boolean hasStringValue() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).hasStringValue();
      }
      
      public Builder setDoubleValue(double param2Double) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).setDoubleValue(param2Double);
        return this;
      }
      
      public Builder setIntValue(long param2Long) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).setIntValue(param2Long);
        return this;
      }
      
      public Builder setName(String param2String) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).setName(param2String);
        return this;
      }
      
      public Builder setNameBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).setNameBytes(param2ByteString);
        return this;
      }
      
      public Builder setStringValue(String param2String) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).setStringValue(param2String);
        return this;
      }
      
      public Builder setStringValueBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).setStringValueBytes(param2ByteString);
        return this;
      }
    }
    
    public enum ParamValueCase implements Internal.EnumLite {
      DOUBLE_VALUE,
      INT_VALUE,
      PARAMVALUE_NOT_SET,
      STRING_VALUE(2);
      
      private final int value;
      
      static {
        $VALUES = new ParamValueCase[] { STRING_VALUE, INT_VALUE, DOUBLE_VALUE, PARAMVALUE_NOT_SET };
      }
      
      ParamValueCase(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static ParamValueCase forNumber(int param2Int) {
        if (param2Int != 0) {
          switch (param2Int) {
            default:
              return null;
            case 4:
              return DOUBLE_VALUE;
            case 3:
              return INT_VALUE;
            case 2:
              break;
          } 
          return STRING_VALUE;
        } 
        return PARAMVALUE_NOT_SET;
      }
      
      public int getNumber() {
        return this.value;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<FirebaseAnalyticsEventParam, FirebaseAnalyticsEventParam.Builder> implements FirebaseAnalyticsEventParamOrBuilder {
    private Builder() {
      super(GmpMeasurementPublic.FirebaseAnalyticsEventParam.DEFAULT_INSTANCE);
    }
    
    public Builder clearDoubleValue() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).clearDoubleValue();
      return this;
    }
    
    public Builder clearIntValue() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).clearIntValue();
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).clearName();
      return this;
    }
    
    public Builder clearParamValue() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).clearParamValue();
      return this;
    }
    
    public Builder clearStringValue() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).clearStringValue();
      return this;
    }
    
    public double getDoubleValue() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).getDoubleValue();
    }
    
    public long getIntValue() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).getIntValue();
    }
    
    public String getName() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).getName();
    }
    
    public ByteString getNameBytes() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).getNameBytes();
    }
    
    public GmpMeasurementPublic.FirebaseAnalyticsEventParam.ParamValueCase getParamValueCase() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).getParamValueCase();
    }
    
    public String getStringValue() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).getStringValue();
    }
    
    public ByteString getStringValueBytes() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).getStringValueBytes();
    }
    
    public boolean hasDoubleValue() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).hasDoubleValue();
    }
    
    public boolean hasIntValue() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).hasIntValue();
    }
    
    public boolean hasName() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).hasName();
    }
    
    public boolean hasStringValue() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).hasStringValue();
    }
    
    public Builder setDoubleValue(double param1Double) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).setDoubleValue(param1Double);
      return this;
    }
    
    public Builder setIntValue(long param1Long) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).setIntValue(param1Long);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).setNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setStringValue(String param1String) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).setStringValue(param1String);
      return this;
    }
    
    public Builder setStringValueBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsEventParam)this.instance).setStringValueBytes(param1ByteString);
      return this;
    }
  }
  
  public enum ParamValueCase implements Internal.EnumLite {
    DOUBLE_VALUE(2),
    INT_VALUE(2),
    PARAMVALUE_NOT_SET(2),
    STRING_VALUE(2);
    
    private final int value;
    
    static {
      DOUBLE_VALUE = new ParamValueCase("DOUBLE_VALUE", 2, 4);
      PARAMVALUE_NOT_SET = new ParamValueCase("PARAMVALUE_NOT_SET", 3, 0);
      $VALUES = new ParamValueCase[] { STRING_VALUE, INT_VALUE, DOUBLE_VALUE, PARAMVALUE_NOT_SET };
    }
    
    ParamValueCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ParamValueCase forNumber(int param1Int) {
      if (param1Int != 0) {
        switch (param1Int) {
          default:
            return null;
          case 4:
            return DOUBLE_VALUE;
          case 3:
            return INT_VALUE;
          case 2:
            break;
        } 
        return STRING_VALUE;
      } 
      return PARAMVALUE_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
  
  public static interface FirebaseAnalyticsEventParamOrBuilder extends MessageLiteOrBuilder {
    double getDoubleValue();
    
    long getIntValue();
    
    String getName();
    
    ByteString getNameBytes();
    
    GmpMeasurementPublic.FirebaseAnalyticsEventParam.ParamValueCase getParamValueCase();
    
    String getStringValue();
    
    ByteString getStringValueBytes();
    
    boolean hasDoubleValue();
    
    boolean hasIntValue();
    
    boolean hasName();
    
    boolean hasStringValue();
  }
  
  public static final class FirebaseAnalyticsUserAttribute extends GeneratedMessageLite<FirebaseAnalyticsUserAttribute, FirebaseAnalyticsUserAttribute.Builder> implements FirebaseAnalyticsUserAttributeOrBuilder {
    private static final FirebaseAnalyticsUserAttribute DEFAULT_INSTANCE = new FirebaseAnalyticsUserAttribute();
    
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 4;
    
    public static final int INT_VALUE_FIELD_NUMBER = 3;
    
    public static final int NAME_FIELD_NUMBER = 1;
    
    private static volatile Parser<FirebaseAnalyticsUserAttribute> PARSER;
    
    public static final int STRING_VALUE_FIELD_NUMBER = 2;
    
    public static final int TIMESTAMP_MILLIS_FIELD_NUMBER = 5;
    
    private int attributeValueCase_ = 0;
    
    private Object attributeValue_;
    
    private int bitField0_;
    
    private String name_ = "";
    
    private long timestampMillis_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearAttributeValue() {
      this.attributeValueCase_ = 0;
      this.attributeValue_ = null;
    }
    
    private void clearDoubleValue() {
      if (this.attributeValueCase_ == 4) {
        this.attributeValueCase_ = 0;
        this.attributeValue_ = null;
      } 
    }
    
    private void clearIntValue() {
      if (this.attributeValueCase_ == 3) {
        this.attributeValueCase_ = 0;
        this.attributeValue_ = null;
      } 
    }
    
    private void clearName() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.name_ = getDefaultInstance().getName();
    }
    
    private void clearStringValue() {
      if (this.attributeValueCase_ == 2) {
        this.attributeValueCase_ = 0;
        this.attributeValue_ = null;
      } 
    }
    
    private void clearTimestampMillis() {
      this.bitField0_ &= 0xFFFFFFEF;
      this.timestampMillis_ = 0L;
    }
    
    public static FirebaseAnalyticsUserAttribute getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(FirebaseAnalyticsUserAttribute param1FirebaseAnalyticsUserAttribute) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1FirebaseAnalyticsUserAttribute);
    }
    
    public static FirebaseAnalyticsUserAttribute parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (FirebaseAnalyticsUserAttribute)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static FirebaseAnalyticsUserAttribute parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FirebaseAnalyticsUserAttribute)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FirebaseAnalyticsUserAttribute parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (FirebaseAnalyticsUserAttribute)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static FirebaseAnalyticsUserAttribute parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FirebaseAnalyticsUserAttribute)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static FirebaseAnalyticsUserAttribute parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (FirebaseAnalyticsUserAttribute)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static FirebaseAnalyticsUserAttribute parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FirebaseAnalyticsUserAttribute)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static FirebaseAnalyticsUserAttribute parseFrom(InputStream param1InputStream) throws IOException {
      return (FirebaseAnalyticsUserAttribute)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static FirebaseAnalyticsUserAttribute parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FirebaseAnalyticsUserAttribute)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FirebaseAnalyticsUserAttribute parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (FirebaseAnalyticsUserAttribute)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static FirebaseAnalyticsUserAttribute parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FirebaseAnalyticsUserAttribute)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<FirebaseAnalyticsUserAttribute> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setDoubleValue(double param1Double) {
      this.attributeValueCase_ = 4;
      this.attributeValue_ = Double.valueOf(param1Double);
    }
    
    private void setIntValue(long param1Long) {
      this.attributeValueCase_ = 3;
      this.attributeValue_ = Long.valueOf(param1Long);
    }
    
    private void setName(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x1;
        this.name_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x1;
        this.name_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setStringValue(String param1String) {
      if (param1String != null) {
        this.attributeValueCase_ = 2;
        this.attributeValue_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setStringValueBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.attributeValueCase_ = 2;
        this.attributeValue_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTimestampMillis(long param1Long) {
      this.bitField0_ |= 0x10;
      this.timestampMillis_ = param1Long;
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic analytics_collection/GmpMeasurementPublic$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
      //   25: iload #4
      //   27: tableswitch default -> 72, 1 -> 657, 2 -> 653, 3 -> 651, 4 -> 642, 5 -> 364, 6 -> 126, 7 -> 360, 8 -> 80
      //   72: new java/lang/UnsupportedOperationException
      //   75: dup
      //   76: invokespecial <init> : ()V
      //   79: athrow
      //   80: getstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsUserAttribute.PARSER : Lcom/google/protobuf/Parser;
      //   83: ifnonnull -> 122
      //   86: ldc analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsUserAttribute
      //   88: monitorenter
      //   89: getstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsUserAttribute.PARSER : Lcom/google/protobuf/Parser;
      //   92: ifnonnull -> 110
      //   95: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   98: astore_1
      //   99: aload_1
      //   100: getstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsUserAttribute.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurementPublic$FirebaseAnalyticsUserAttribute;
      //   103: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   106: aload_1
      //   107: putstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsUserAttribute.PARSER : Lcom/google/protobuf/Parser;
      //   110: ldc analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsUserAttribute
      //   112: monitorexit
      //   113: goto -> 122
      //   116: astore_1
      //   117: ldc analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsUserAttribute
      //   119: monitorexit
      //   120: aload_1
      //   121: athrow
      //   122: getstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsUserAttribute.PARSER : Lcom/google/protobuf/Parser;
      //   125: areturn
      //   126: aload_2
      //   127: checkcast com/google/protobuf/CodedInputStream
      //   130: astore_1
      //   131: aload_3
      //   132: checkcast com/google/protobuf/ExtensionRegistryLite
      //   135: astore_2
      //   136: iload #9
      //   138: ifne -> 360
      //   141: aload_1
      //   142: invokevirtual readTag : ()I
      //   145: istore #4
      //   147: iload #4
      //   149: ifeq -> 304
      //   152: iload #4
      //   154: bipush #10
      //   156: if_icmpeq -> 281
      //   159: iload #4
      //   161: bipush #18
      //   163: if_icmpeq -> 263
      //   166: iload #4
      //   168: bipush #24
      //   170: if_icmpeq -> 244
      //   173: iload #4
      //   175: bipush #33
      //   177: if_icmpeq -> 225
      //   180: iload #4
      //   182: bipush #40
      //   184: if_icmpeq -> 203
      //   187: aload_0
      //   188: iload #4
      //   190: aload_1
      //   191: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   194: ifne -> 136
      //   197: iconst_1
      //   198: istore #9
      //   200: goto -> 136
      //   203: aload_0
      //   204: aload_0
      //   205: getfield bitField0_ : I
      //   208: bipush #16
      //   210: ior
      //   211: putfield bitField0_ : I
      //   214: aload_0
      //   215: aload_1
      //   216: invokevirtual readInt64 : ()J
      //   219: putfield timestampMillis_ : J
      //   222: goto -> 136
      //   225: aload_0
      //   226: iconst_4
      //   227: putfield attributeValueCase_ : I
      //   230: aload_0
      //   231: aload_1
      //   232: invokevirtual readDouble : ()D
      //   235: invokestatic valueOf : (D)Ljava/lang/Double;
      //   238: putfield attributeValue_ : Ljava/lang/Object;
      //   241: goto -> 136
      //   244: aload_0
      //   245: iconst_3
      //   246: putfield attributeValueCase_ : I
      //   249: aload_0
      //   250: aload_1
      //   251: invokevirtual readInt64 : ()J
      //   254: invokestatic valueOf : (J)Ljava/lang/Long;
      //   257: putfield attributeValue_ : Ljava/lang/Object;
      //   260: goto -> 136
      //   263: aload_1
      //   264: invokevirtual readString : ()Ljava/lang/String;
      //   267: astore_2
      //   268: aload_0
      //   269: iconst_2
      //   270: putfield attributeValueCase_ : I
      //   273: aload_0
      //   274: aload_2
      //   275: putfield attributeValue_ : Ljava/lang/Object;
      //   278: goto -> 136
      //   281: aload_1
      //   282: invokevirtual readString : ()Ljava/lang/String;
      //   285: astore_2
      //   286: aload_0
      //   287: aload_0
      //   288: getfield bitField0_ : I
      //   291: iconst_1
      //   292: ior
      //   293: putfield bitField0_ : I
      //   296: aload_0
      //   297: aload_2
      //   298: putfield name_ : Ljava/lang/String;
      //   301: goto -> 136
      //   304: iconst_1
      //   305: istore #9
      //   307: goto -> 136
      //   310: astore_1
      //   311: goto -> 358
      //   314: astore_3
      //   315: new java/lang/RuntimeException
      //   318: astore_2
      //   319: new com/google/protobuf/InvalidProtocolBufferException
      //   322: astore_1
      //   323: aload_1
      //   324: aload_3
      //   325: invokevirtual getMessage : ()Ljava/lang/String;
      //   328: invokespecial <init> : (Ljava/lang/String;)V
      //   331: aload_2
      //   332: aload_1
      //   333: aload_0
      //   334: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   337: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   340: aload_2
      //   341: athrow
      //   342: astore_2
      //   343: new java/lang/RuntimeException
      //   346: astore_1
      //   347: aload_1
      //   348: aload_2
      //   349: aload_0
      //   350: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   353: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   356: aload_1
      //   357: athrow
      //   358: aload_1
      //   359: athrow
      //   360: getstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsUserAttribute.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurementPublic$FirebaseAnalyticsUserAttribute;
      //   363: areturn
      //   364: aload_2
      //   365: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   368: astore_1
      //   369: aload_3
      //   370: checkcast analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsUserAttribute
      //   373: astore_2
      //   374: aload_0
      //   375: aload_1
      //   376: aload_0
      //   377: invokevirtual hasName : ()Z
      //   380: aload_0
      //   381: getfield name_ : Ljava/lang/String;
      //   384: aload_2
      //   385: invokevirtual hasName : ()Z
      //   388: aload_2
      //   389: getfield name_ : Ljava/lang/String;
      //   392: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   397: putfield name_ : Ljava/lang/String;
      //   400: aload_0
      //   401: aload_1
      //   402: aload_0
      //   403: invokevirtual hasTimestampMillis : ()Z
      //   406: aload_0
      //   407: getfield timestampMillis_ : J
      //   410: aload_2
      //   411: invokevirtual hasTimestampMillis : ()Z
      //   414: aload_2
      //   415: getfield timestampMillis_ : J
      //   418: invokeinterface visitLong : (ZJZJ)J
      //   423: putfield timestampMillis_ : J
      //   426: getstatic analytics_collection/GmpMeasurementPublic$1.$SwitchMap$analytics_collection$GmpMeasurementPublic$FirebaseAnalyticsUserAttribute$AttributeValueCase : [I
      //   429: aload_2
      //   430: invokevirtual getAttributeValueCase : ()Lanalytics_collection/GmpMeasurementPublic$FirebaseAnalyticsUserAttribute$AttributeValueCase;
      //   433: invokevirtual ordinal : ()I
      //   436: iaload
      //   437: tableswitch default -> 468, 1 -> 568, 2 -> 530, 3 -> 492, 4 -> 471
      //   468: goto -> 603
      //   471: aload_0
      //   472: getfield attributeValueCase_ : I
      //   475: ifeq -> 481
      //   478: iconst_1
      //   479: istore #5
      //   481: aload_1
      //   482: iload #5
      //   484: invokeinterface visitOneofNotSet : (Z)V
      //   489: goto -> 603
      //   492: iload #6
      //   494: istore #5
      //   496: aload_0
      //   497: getfield attributeValueCase_ : I
      //   500: iconst_4
      //   501: if_icmpne -> 507
      //   504: iconst_1
      //   505: istore #5
      //   507: aload_0
      //   508: aload_1
      //   509: iload #5
      //   511: aload_0
      //   512: getfield attributeValue_ : Ljava/lang/Object;
      //   515: aload_2
      //   516: getfield attributeValue_ : Ljava/lang/Object;
      //   519: invokeinterface visitOneofDouble : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   524: putfield attributeValue_ : Ljava/lang/Object;
      //   527: goto -> 603
      //   530: iload #7
      //   532: istore #5
      //   534: aload_0
      //   535: getfield attributeValueCase_ : I
      //   538: iconst_3
      //   539: if_icmpne -> 545
      //   542: iconst_1
      //   543: istore #5
      //   545: aload_0
      //   546: aload_1
      //   547: iload #5
      //   549: aload_0
      //   550: getfield attributeValue_ : Ljava/lang/Object;
      //   553: aload_2
      //   554: getfield attributeValue_ : Ljava/lang/Object;
      //   557: invokeinterface visitOneofLong : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   562: putfield attributeValue_ : Ljava/lang/Object;
      //   565: goto -> 603
      //   568: iload #8
      //   570: istore #5
      //   572: aload_0
      //   573: getfield attributeValueCase_ : I
      //   576: iconst_2
      //   577: if_icmpne -> 583
      //   580: iconst_1
      //   581: istore #5
      //   583: aload_0
      //   584: aload_1
      //   585: iload #5
      //   587: aload_0
      //   588: getfield attributeValue_ : Ljava/lang/Object;
      //   591: aload_2
      //   592: getfield attributeValue_ : Ljava/lang/Object;
      //   595: invokeinterface visitOneofString : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   600: putfield attributeValue_ : Ljava/lang/Object;
      //   603: aload_1
      //   604: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   607: if_acmpne -> 640
      //   610: aload_2
      //   611: getfield attributeValueCase_ : I
      //   614: istore #9
      //   616: iload #9
      //   618: ifeq -> 627
      //   621: aload_0
      //   622: iload #9
      //   624: putfield attributeValueCase_ : I
      //   627: aload_0
      //   628: aload_0
      //   629: getfield bitField0_ : I
      //   632: aload_2
      //   633: getfield bitField0_ : I
      //   636: ior
      //   637: putfield bitField0_ : I
      //   640: aload_0
      //   641: areturn
      //   642: new analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsUserAttribute$Builder
      //   645: dup
      //   646: aconst_null
      //   647: invokespecial <init> : (Lanalytics_collection/GmpMeasurementPublic$1;)V
      //   650: areturn
      //   651: aconst_null
      //   652: areturn
      //   653: getstatic analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsUserAttribute.DEFAULT_INSTANCE : Lanalytics_collection/GmpMeasurementPublic$FirebaseAnalyticsUserAttribute;
      //   656: areturn
      //   657: new analytics_collection/GmpMeasurementPublic$FirebaseAnalyticsUserAttribute
      //   660: dup
      //   661: invokespecial <init> : ()V
      //   664: areturn
      // Exception table:
      //   from	to	target	type
      //   89	110	116	finally
      //   110	113	116	finally
      //   117	120	116	finally
      //   141	147	342	com/google/protobuf/InvalidProtocolBufferException
      //   141	147	314	java/io/IOException
      //   141	147	310	finally
      //   187	197	342	com/google/protobuf/InvalidProtocolBufferException
      //   187	197	314	java/io/IOException
      //   187	197	310	finally
      //   203	222	342	com/google/protobuf/InvalidProtocolBufferException
      //   203	222	314	java/io/IOException
      //   203	222	310	finally
      //   225	241	342	com/google/protobuf/InvalidProtocolBufferException
      //   225	241	314	java/io/IOException
      //   225	241	310	finally
      //   244	260	342	com/google/protobuf/InvalidProtocolBufferException
      //   244	260	314	java/io/IOException
      //   244	260	310	finally
      //   263	278	342	com/google/protobuf/InvalidProtocolBufferException
      //   263	278	314	java/io/IOException
      //   263	278	310	finally
      //   281	301	342	com/google/protobuf/InvalidProtocolBufferException
      //   281	301	314	java/io/IOException
      //   281	301	310	finally
      //   315	342	310	finally
      //   343	358	310	finally
    }
    
    public AttributeValueCase getAttributeValueCase() {
      return AttributeValueCase.forNumber(this.attributeValueCase_);
    }
    
    public double getDoubleValue() {
      return (this.attributeValueCase_ == 4) ? ((Double)this.attributeValue_).doubleValue() : 0.0D;
    }
    
    public long getIntValue() {
      return (this.attributeValueCase_ == 3) ? ((Long)this.attributeValue_).longValue() : 0L;
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
      int j = 0;
      if ((this.bitField0_ & 0x1) == 1)
        j = 0 + CodedOutputStream.computeStringSize(1, getName()); 
      i = j;
      if (this.attributeValueCase_ == 2)
        i = j + CodedOutputStream.computeStringSize(2, getStringValue()); 
      j = i;
      if (this.attributeValueCase_ == 3)
        j = i + CodedOutputStream.computeInt64Size(3, ((Long)this.attributeValue_).longValue()); 
      i = j;
      if (this.attributeValueCase_ == 4)
        i = j + CodedOutputStream.computeDoubleSize(4, ((Double)this.attributeValue_).doubleValue()); 
      j = i;
      if ((this.bitField0_ & 0x10) == 16)
        j = i + CodedOutputStream.computeInt64Size(5, this.timestampMillis_); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public String getStringValue() {
      String str = "";
      if (this.attributeValueCase_ == 2)
        str = (String)this.attributeValue_; 
      return str;
    }
    
    public ByteString getStringValueBytes() {
      String str = "";
      if (this.attributeValueCase_ == 2)
        str = (String)this.attributeValue_; 
      return ByteString.copyFromUtf8(str);
    }
    
    public long getTimestampMillis() {
      return this.timestampMillis_;
    }
    
    public boolean hasDoubleValue() {
      boolean bool;
      if (this.attributeValueCase_ == 4) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasIntValue() {
      boolean bool;
      if (this.attributeValueCase_ == 3) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasName() {
      int i = this.bitField0_;
      boolean bool = true;
      if ((i & 0x1) != 1)
        bool = false; 
      return bool;
    }
    
    public boolean hasStringValue() {
      boolean bool;
      if (this.attributeValueCase_ == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasTimestampMillis() {
      boolean bool;
      if ((this.bitField0_ & 0x10) == 16) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if ((this.bitField0_ & 0x1) == 1)
        param1CodedOutputStream.writeString(1, getName()); 
      if (this.attributeValueCase_ == 2)
        param1CodedOutputStream.writeString(2, getStringValue()); 
      if (this.attributeValueCase_ == 3)
        param1CodedOutputStream.writeInt64(3, ((Long)this.attributeValue_).longValue()); 
      if (this.attributeValueCase_ == 4)
        param1CodedOutputStream.writeDouble(4, ((Double)this.attributeValue_).doubleValue()); 
      if ((this.bitField0_ & 0x10) == 16)
        param1CodedOutputStream.writeInt64(5, this.timestampMillis_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public enum AttributeValueCase implements Internal.EnumLite {
      ATTRIBUTEVALUE_NOT_SET(2),
      DOUBLE_VALUE(2),
      INT_VALUE(2),
      STRING_VALUE(2);
      
      private final int value;
      
      static {
        ATTRIBUTEVALUE_NOT_SET = new AttributeValueCase("ATTRIBUTEVALUE_NOT_SET", 3, 0);
        $VALUES = new AttributeValueCase[] { STRING_VALUE, INT_VALUE, DOUBLE_VALUE, ATTRIBUTEVALUE_NOT_SET };
      }
      
      AttributeValueCase(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static AttributeValueCase forNumber(int param2Int) {
        if (param2Int != 0) {
          switch (param2Int) {
            default:
              return null;
            case 4:
              return DOUBLE_VALUE;
            case 3:
              return INT_VALUE;
            case 2:
              break;
          } 
          return STRING_VALUE;
        } 
        return ATTRIBUTEVALUE_NOT_SET;
      }
      
      public int getNumber() {
        return this.value;
      }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<FirebaseAnalyticsUserAttribute, Builder> implements GmpMeasurementPublic.FirebaseAnalyticsUserAttributeOrBuilder {
      private Builder() {
        super(GmpMeasurementPublic.FirebaseAnalyticsUserAttribute.DEFAULT_INSTANCE);
      }
      
      public Builder clearAttributeValue() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).clearAttributeValue();
        return this;
      }
      
      public Builder clearDoubleValue() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).clearDoubleValue();
        return this;
      }
      
      public Builder clearIntValue() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).clearIntValue();
        return this;
      }
      
      public Builder clearName() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).clearName();
        return this;
      }
      
      public Builder clearStringValue() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).clearStringValue();
        return this;
      }
      
      public Builder clearTimestampMillis() {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).clearTimestampMillis();
        return this;
      }
      
      public GmpMeasurementPublic.FirebaseAnalyticsUserAttribute.AttributeValueCase getAttributeValueCase() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).getAttributeValueCase();
      }
      
      public double getDoubleValue() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).getDoubleValue();
      }
      
      public long getIntValue() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).getIntValue();
      }
      
      public String getName() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).getName();
      }
      
      public ByteString getNameBytes() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).getNameBytes();
      }
      
      public String getStringValue() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).getStringValue();
      }
      
      public ByteString getStringValueBytes() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).getStringValueBytes();
      }
      
      public long getTimestampMillis() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).getTimestampMillis();
      }
      
      public boolean hasDoubleValue() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).hasDoubleValue();
      }
      
      public boolean hasIntValue() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).hasIntValue();
      }
      
      public boolean hasName() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).hasName();
      }
      
      public boolean hasStringValue() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).hasStringValue();
      }
      
      public boolean hasTimestampMillis() {
        return ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).hasTimestampMillis();
      }
      
      public Builder setDoubleValue(double param2Double) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).setDoubleValue(param2Double);
        return this;
      }
      
      public Builder setIntValue(long param2Long) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).setIntValue(param2Long);
        return this;
      }
      
      public Builder setName(String param2String) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).setName(param2String);
        return this;
      }
      
      public Builder setNameBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).setNameBytes(param2ByteString);
        return this;
      }
      
      public Builder setStringValue(String param2String) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).setStringValue(param2String);
        return this;
      }
      
      public Builder setStringValueBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).setStringValueBytes(param2ByteString);
        return this;
      }
      
      public Builder setTimestampMillis(long param2Long) {
        copyOnWrite();
        ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).setTimestampMillis(param2Long);
        return this;
      }
    }
  }
  
  public enum AttributeValueCase implements Internal.EnumLite {
    ATTRIBUTEVALUE_NOT_SET(2),
    DOUBLE_VALUE(2),
    INT_VALUE(2),
    STRING_VALUE(2);
    
    private final int value;
    
    static {
      DOUBLE_VALUE = new AttributeValueCase("DOUBLE_VALUE", 2, 4);
      ATTRIBUTEVALUE_NOT_SET = new AttributeValueCase("ATTRIBUTEVALUE_NOT_SET", 3, 0);
      $VALUES = new AttributeValueCase[] { STRING_VALUE, INT_VALUE, DOUBLE_VALUE, ATTRIBUTEVALUE_NOT_SET };
    }
    
    AttributeValueCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static AttributeValueCase forNumber(int param1Int) {
      if (param1Int != 0) {
        switch (param1Int) {
          default:
            return null;
          case 4:
            return DOUBLE_VALUE;
          case 3:
            return INT_VALUE;
          case 2:
            break;
        } 
        return STRING_VALUE;
      } 
      return ATTRIBUTEVALUE_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<FirebaseAnalyticsUserAttribute, FirebaseAnalyticsUserAttribute.Builder> implements FirebaseAnalyticsUserAttributeOrBuilder {
    private Builder() {
      super(GmpMeasurementPublic.FirebaseAnalyticsUserAttribute.DEFAULT_INSTANCE);
    }
    
    public Builder clearAttributeValue() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).clearAttributeValue();
      return this;
    }
    
    public Builder clearDoubleValue() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).clearDoubleValue();
      return this;
    }
    
    public Builder clearIntValue() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).clearIntValue();
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).clearName();
      return this;
    }
    
    public Builder clearStringValue() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).clearStringValue();
      return this;
    }
    
    public Builder clearTimestampMillis() {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).clearTimestampMillis();
      return this;
    }
    
    public GmpMeasurementPublic.FirebaseAnalyticsUserAttribute.AttributeValueCase getAttributeValueCase() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).getAttributeValueCase();
    }
    
    public double getDoubleValue() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).getDoubleValue();
    }
    
    public long getIntValue() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).getIntValue();
    }
    
    public String getName() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).getName();
    }
    
    public ByteString getNameBytes() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).getNameBytes();
    }
    
    public String getStringValue() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).getStringValue();
    }
    
    public ByteString getStringValueBytes() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).getStringValueBytes();
    }
    
    public long getTimestampMillis() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).getTimestampMillis();
    }
    
    public boolean hasDoubleValue() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).hasDoubleValue();
    }
    
    public boolean hasIntValue() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).hasIntValue();
    }
    
    public boolean hasName() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).hasName();
    }
    
    public boolean hasStringValue() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).hasStringValue();
    }
    
    public boolean hasTimestampMillis() {
      return ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).hasTimestampMillis();
    }
    
    public Builder setDoubleValue(double param1Double) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).setDoubleValue(param1Double);
      return this;
    }
    
    public Builder setIntValue(long param1Long) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).setIntValue(param1Long);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).setNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setStringValue(String param1String) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).setStringValue(param1String);
      return this;
    }
    
    public Builder setStringValueBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).setStringValueBytes(param1ByteString);
      return this;
    }
    
    public Builder setTimestampMillis(long param1Long) {
      copyOnWrite();
      ((GmpMeasurementPublic.FirebaseAnalyticsUserAttribute)this.instance).setTimestampMillis(param1Long);
      return this;
    }
  }
  
  public static interface FirebaseAnalyticsUserAttributeOrBuilder extends MessageLiteOrBuilder {
    GmpMeasurementPublic.FirebaseAnalyticsUserAttribute.AttributeValueCase getAttributeValueCase();
    
    double getDoubleValue();
    
    long getIntValue();
    
    String getName();
    
    ByteString getNameBytes();
    
    String getStringValue();
    
    ByteString getStringValueBytes();
    
    long getTimestampMillis();
    
    boolean hasDoubleValue();
    
    boolean hasIntValue();
    
    boolean hasName();
    
    boolean hasStringValue();
    
    boolean hasTimestampMillis();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\analytics_collection\GmpMeasurementPublic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */