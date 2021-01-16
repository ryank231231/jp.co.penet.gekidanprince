package logs_proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class LogsAnnotations {
  public static final int FIELD_ENCRYPTION_KEY_NAME_FIELD_NUMBER = 26652850;
  
  public static final int FILE_NOT_USED_FOR_LOGGING_EXCEPT_ENUMS_FIELD_NUMBER = 21596320;
  
  public static final int FILE_VETTED_FOR_LOGS_ANNOTATIONS_FIELD_NUMBER = 28993747;
  
  public static final int ID_TYPE_FIELD_NUMBER = 21713708;
  
  public static final int IS_ENCRYPTED_FIELD_NUMBER = 26652850;
  
  public static final int IS_PRIVATE_LOG_FIELD_NUMBER = 23459630;
  
  public static final int MAX_RECURSION_DEPTH_FIELD_NUMBER = 53697879;
  
  public static final int MSG_DETAILS_FIELD_NUMBER = 21467048;
  
  public static final int MSG_ID_TYPE_FIELD_NUMBER = 21713708;
  
  public static final int MSG_NOT_LOGGED_IN_SAWMILL_FIELD_NUMBER = 21596320;
  
  public static final int MSG_TEMP_LOGS_ONLY_FIELD_NUMBER = 21623477;
  
  public static final int NOT_LOGGED_IN_SAWMILL_FIELD_NUMBER = 21596320;
  
  public static final int SAWMILL_FILTER_OVERRIDE_APPROVED_BY_LOGS_ACCESS_FIELD_NUMBER = 56871503;
  
  public static final int TEMP_LOGS_ONLY_FIELD_NUMBER = 21623477;
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.MessageOptions, String> fieldEncryptionKeyName;
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FileOptions, Boolean> fileNotUsedForLoggingExceptEnums;
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FileOptions, Boolean> fileVettedForLogsAnnotations;
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, IdentifierType> idType = GeneratedMessageLite.newSingularGeneratedExtension((MessageLite)DescriptorProtos.FieldOptions.getDefaultInstance(), IdentifierType.LOGSID_NONE, null, IdentifierType.internalGetValueMap(), 21713708, WireFormat.FieldType.ENUM, IdentifierType.class);
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, Boolean> isEncrypted;
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, Boolean> isPrivateLog;
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, Integer> maxRecursionDepth;
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.MessageOptions, MessageDetails> msgDetails;
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.MessageOptions, IdentifierType> msgIdType;
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.MessageOptions, Boolean> msgNotLoggedInSawmill;
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.MessageOptions, Boolean> msgTempLogsOnly;
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, Boolean> notLoggedInSawmill;
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, String> sawmillFilterOverrideApprovedByLogsAccess;
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, Boolean> tempLogsOnly = GeneratedMessageLite.newSingularGeneratedExtension((MessageLite)DescriptorProtos.FieldOptions.getDefaultInstance(), Boolean.valueOf(false), null, null, 21623477, WireFormat.FieldType.BOOL, Boolean.class);
  
  static {
    isPrivateLog = GeneratedMessageLite.newSingularGeneratedExtension((MessageLite)DescriptorProtos.FieldOptions.getDefaultInstance(), Boolean.valueOf(false), null, null, 23459630, WireFormat.FieldType.BOOL, Boolean.class);
    notLoggedInSawmill = GeneratedMessageLite.newSingularGeneratedExtension((MessageLite)DescriptorProtos.FieldOptions.getDefaultInstance(), Boolean.valueOf(false), null, null, 21596320, WireFormat.FieldType.BOOL, Boolean.class);
    isEncrypted = GeneratedMessageLite.newSingularGeneratedExtension((MessageLite)DescriptorProtos.FieldOptions.getDefaultInstance(), Boolean.valueOf(false), null, null, 26652850, WireFormat.FieldType.BOOL, Boolean.class);
    maxRecursionDepth = GeneratedMessageLite.newSingularGeneratedExtension((MessageLite)DescriptorProtos.FieldOptions.getDefaultInstance(), Integer.valueOf(0), null, null, 53697879, WireFormat.FieldType.INT32, Integer.class);
    sawmillFilterOverrideApprovedByLogsAccess = GeneratedMessageLite.newSingularGeneratedExtension((MessageLite)DescriptorProtos.FieldOptions.getDefaultInstance(), "", null, null, 56871503, WireFormat.FieldType.STRING, String.class);
    msgIdType = GeneratedMessageLite.newSingularGeneratedExtension((MessageLite)DescriptorProtos.MessageOptions.getDefaultInstance(), IdentifierType.LOGSID_NONE, null, IdentifierType.internalGetValueMap(), 21713708, WireFormat.FieldType.ENUM, IdentifierType.class);
    msgTempLogsOnly = GeneratedMessageLite.newSingularGeneratedExtension((MessageLite)DescriptorProtos.MessageOptions.getDefaultInstance(), Boolean.valueOf(false), null, null, 21623477, WireFormat.FieldType.BOOL, Boolean.class);
    msgNotLoggedInSawmill = GeneratedMessageLite.newSingularGeneratedExtension((MessageLite)DescriptorProtos.MessageOptions.getDefaultInstance(), Boolean.valueOf(false), null, null, 21596320, WireFormat.FieldType.BOOL, Boolean.class);
    msgDetails = GeneratedMessageLite.newSingularGeneratedExtension((MessageLite)DescriptorProtos.MessageOptions.getDefaultInstance(), MessageDetails.getDefaultInstance(), (MessageLite)MessageDetails.getDefaultInstance(), null, 21467048, WireFormat.FieldType.MESSAGE, MessageDetails.class);
    fieldEncryptionKeyName = GeneratedMessageLite.newSingularGeneratedExtension((MessageLite)DescriptorProtos.MessageOptions.getDefaultInstance(), "", null, null, 26652850, WireFormat.FieldType.STRING, String.class);
    fileNotUsedForLoggingExceptEnums = GeneratedMessageLite.newSingularGeneratedExtension((MessageLite)DescriptorProtos.FileOptions.getDefaultInstance(), Boolean.valueOf(false), null, null, 21596320, WireFormat.FieldType.BOOL, Boolean.class);
    fileVettedForLogsAnnotations = GeneratedMessageLite.newSingularGeneratedExtension((MessageLite)DescriptorProtos.FileOptions.getDefaultInstance(), Boolean.valueOf(false), null, null, 28993747, WireFormat.FieldType.BOOL, Boolean.class);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {
    paramExtensionRegistryLite.add(idType);
    paramExtensionRegistryLite.add(tempLogsOnly);
    paramExtensionRegistryLite.add(isPrivateLog);
    paramExtensionRegistryLite.add(notLoggedInSawmill);
    paramExtensionRegistryLite.add(isEncrypted);
    paramExtensionRegistryLite.add(maxRecursionDepth);
    paramExtensionRegistryLite.add(sawmillFilterOverrideApprovedByLogsAccess);
    paramExtensionRegistryLite.add(msgIdType);
    paramExtensionRegistryLite.add(msgTempLogsOnly);
    paramExtensionRegistryLite.add(msgNotLoggedInSawmill);
    paramExtensionRegistryLite.add(msgDetails);
    paramExtensionRegistryLite.add(fieldEncryptionKeyName);
    paramExtensionRegistryLite.add(fileNotUsedForLoggingExceptEnums);
    paramExtensionRegistryLite.add(fileVettedForLogsAnnotations);
  }
  
  public enum IdentifierType implements Internal.EnumLite {
    LOGSID_ANDROID_LOGGING_ID,
    LOGSID_APPROXIMATE_LOCATION,
    LOGSID_BISCOTTI,
    LOGSID_BUILD_SERIAL_ID,
    LOGSID_COARSE_LOCATION,
    LOGSID_COOKIE,
    LOGSID_CUSTOM_SESSION_ID,
    LOGSID_DASHER_ID,
    LOGSID_DEMOGRAPHIC_INFO,
    LOGSID_EMAIL,
    LOGSID_FOCUS_GROUP_ID,
    LOGSID_GAIA_ID,
    LOGSID_GAIA_ID_PUBLIC,
    LOGSID_GENERIC_KEY,
    LOGSID_GENERIC_VALUE,
    LOGSID_GSERVICES_ANDROID_ID,
    LOGSID_HARDWARE_ID,
    LOGSID_HTTPHEADER,
    LOGSID_IP_ADDRESS,
    LOGSID_IP_ADDRESS_INTERNAL,
    LOGSID_MSISDN_ID,
    LOGSID_NONE(0),
    LOGSID_OTHER_AUTHENTICATED_ID(0),
    LOGSID_OTHER_IDENTIFYING_USER_INFO(0),
    LOGSID_OTHER_LOCATION(0),
    LOGSID_OTHER_MOBILE_DEVICE_ID(0),
    LOGSID_OTHER_PERSONAL_ID(0),
    LOGSID_OTHER_PSEUDONYMOUS_ID(0),
    LOGSID_OTHER_UNAUTHENTICATED_ID(0),
    LOGSID_OTHER_VERSION_ID(0),
    LOGSID_PARTNER_OR_CUSTOMER_ID(0),
    LOGSID_PHONE_NUMBER(0),
    LOGSID_PREF(0),
    LOGSID_PUBLISHER_ID(0),
    LOGSID_REFERER(0),
    LOGSID_SECURE_SETTINGS_ANDROID_ID(0),
    LOGSID_SENSITIVE_LOCATION(0),
    LOGSID_SENSITIVE_TIMESTAMP(0),
    LOGSID_THIRD_PARTY_PARAMETERS(0),
    LOGSID_UDID_ID(0),
    LOGSID_URL(0),
    LOGSID_USERNAME(0),
    LOGSID_USER_AGENT(0),
    LOGSID_USER_INPUT(0),
    LOGSID_ZWIEBACK(0);
    
    public static final int LOGSID_ANDROID_LOGGING_ID_VALUE = 56;
    
    public static final int LOGSID_APPROXIMATE_LOCATION_VALUE = 15;
    
    public static final int LOGSID_BISCOTTI_VALUE = 13;
    
    public static final int LOGSID_BUILD_SERIAL_ID_VALUE = 54;
    
    public static final int LOGSID_COARSE_LOCATION_VALUE = 6;
    
    public static final int LOGSID_COOKIE_VALUE = 204;
    
    public static final int LOGSID_CUSTOM_SESSION_ID_VALUE = 14;
    
    public static final int LOGSID_DASHER_ID_VALUE = 33;
    
    public static final int LOGSID_DEMOGRAPHIC_INFO_VALUE = 201;
    
    public static final int LOGSID_EMAIL_VALUE = 22;
    
    public static final int LOGSID_FOCUS_GROUP_ID_VALUE = 34;
    
    public static final int LOGSID_GAIA_ID_PUBLIC_VALUE = 207;
    
    public static final int LOGSID_GAIA_ID_VALUE = 21;
    
    public static final int LOGSID_GENERIC_KEY_VALUE = 202;
    
    public static final int LOGSID_GENERIC_VALUE_VALUE = 203;
    
    public static final int LOGSID_GSERVICES_ANDROID_ID_VALUE = 51;
    
    public static final int LOGSID_HARDWARE_ID_VALUE = 52;
    
    public static final int LOGSID_HTTPHEADER_VALUE = 206;
    
    public static final int LOGSID_IP_ADDRESS_INTERNAL_VALUE = 2;
    
    public static final int LOGSID_IP_ADDRESS_VALUE = 1;
    
    public static final int LOGSID_MSISDN_ID_VALUE = 53;
    
    public static final int LOGSID_NONE_VALUE = 0;
    
    public static final int LOGSID_OTHER_AUTHENTICATED_ID_VALUE = 30;
    
    public static final int LOGSID_OTHER_IDENTIFYING_USER_INFO_VALUE = 100;
    
    public static final int LOGSID_OTHER_LOCATION_VALUE = 9;
    
    public static final int LOGSID_OTHER_MOBILE_DEVICE_ID_VALUE = 50;
    
    public static final int LOGSID_OTHER_PERSONAL_ID_VALUE = 20;
    
    public static final int LOGSID_OTHER_PSEUDONYMOUS_ID_VALUE = 10;
    
    public static final int LOGSID_OTHER_UNAUTHENTICATED_ID_VALUE = 31;
    
    public static final int LOGSID_OTHER_VERSION_ID_VALUE = 7;
    
    public static final int LOGSID_PARTNER_OR_CUSTOMER_ID_VALUE = 32;
    
    public static final int LOGSID_PHONE_NUMBER_VALUE = 24;
    
    public static final int LOGSID_PREF_VALUE = 11;
    
    public static final int LOGSID_PUBLISHER_ID_VALUE = 35;
    
    public static final int LOGSID_REFERER_VALUE = 8;
    
    public static final int LOGSID_SECURE_SETTINGS_ANDROID_ID_VALUE = 57;
    
    public static final int LOGSID_SENSITIVE_LOCATION_VALUE = 5;
    
    public static final int LOGSID_SENSITIVE_TIMESTAMP_VALUE = 4;
    
    public static final int LOGSID_THIRD_PARTY_PARAMETERS_VALUE = 16;
    
    public static final int LOGSID_UDID_ID_VALUE = 55;
    
    public static final int LOGSID_URL_VALUE = 205;
    
    public static final int LOGSID_USERNAME_VALUE = 23;
    
    public static final int LOGSID_USER_AGENT_VALUE = 3;
    
    public static final int LOGSID_USER_INPUT_VALUE = 200;
    
    public static final int LOGSID_ZWIEBACK_VALUE = 12;
    
    private static final Internal.EnumLiteMap<IdentifierType> internalValueMap;
    
    private final int value;
    
    static {
      LOGSID_SENSITIVE_TIMESTAMP = new IdentifierType("LOGSID_SENSITIVE_TIMESTAMP", 4, 4);
      LOGSID_SENSITIVE_LOCATION = new IdentifierType("LOGSID_SENSITIVE_LOCATION", 5, 5);
      LOGSID_APPROXIMATE_LOCATION = new IdentifierType("LOGSID_APPROXIMATE_LOCATION", 6, 15);
      LOGSID_COARSE_LOCATION = new IdentifierType("LOGSID_COARSE_LOCATION", 7, 6);
      LOGSID_OTHER_LOCATION = new IdentifierType("LOGSID_OTHER_LOCATION", 8, 9);
      LOGSID_OTHER_VERSION_ID = new IdentifierType("LOGSID_OTHER_VERSION_ID", 9, 7);
      LOGSID_REFERER = new IdentifierType("LOGSID_REFERER", 10, 8);
      LOGSID_THIRD_PARTY_PARAMETERS = new IdentifierType("LOGSID_THIRD_PARTY_PARAMETERS", 11, 16);
      LOGSID_OTHER_PSEUDONYMOUS_ID = new IdentifierType("LOGSID_OTHER_PSEUDONYMOUS_ID", 12, 10);
      LOGSID_PREF = new IdentifierType("LOGSID_PREF", 13, 11);
      LOGSID_ZWIEBACK = new IdentifierType("LOGSID_ZWIEBACK", 14, 12);
      LOGSID_BISCOTTI = new IdentifierType("LOGSID_BISCOTTI", 15, 13);
      LOGSID_CUSTOM_SESSION_ID = new IdentifierType("LOGSID_CUSTOM_SESSION_ID", 16, 14);
      LOGSID_OTHER_PERSONAL_ID = new IdentifierType("LOGSID_OTHER_PERSONAL_ID", 17, 20);
      LOGSID_GAIA_ID = new IdentifierType("LOGSID_GAIA_ID", 18, 21);
      LOGSID_EMAIL = new IdentifierType("LOGSID_EMAIL", 19, 22);
      LOGSID_USERNAME = new IdentifierType("LOGSID_USERNAME", 20, 23);
      LOGSID_PHONE_NUMBER = new IdentifierType("LOGSID_PHONE_NUMBER", 21, 24);
      LOGSID_GAIA_ID_PUBLIC = new IdentifierType("LOGSID_GAIA_ID_PUBLIC", 22, 207);
      LOGSID_OTHER_AUTHENTICATED_ID = new IdentifierType("LOGSID_OTHER_AUTHENTICATED_ID", 23, 30);
      LOGSID_OTHER_UNAUTHENTICATED_ID = new IdentifierType("LOGSID_OTHER_UNAUTHENTICATED_ID", 24, 31);
      LOGSID_PARTNER_OR_CUSTOMER_ID = new IdentifierType("LOGSID_PARTNER_OR_CUSTOMER_ID", 25, 32);
      LOGSID_PUBLISHER_ID = new IdentifierType("LOGSID_PUBLISHER_ID", 26, 35);
      LOGSID_DASHER_ID = new IdentifierType("LOGSID_DASHER_ID", 27, 33);
      LOGSID_FOCUS_GROUP_ID = new IdentifierType("LOGSID_FOCUS_GROUP_ID", 28, 34);
      LOGSID_OTHER_MOBILE_DEVICE_ID = new IdentifierType("LOGSID_OTHER_MOBILE_DEVICE_ID", 29, 50);
      LOGSID_GSERVICES_ANDROID_ID = new IdentifierType("LOGSID_GSERVICES_ANDROID_ID", 30, 51);
      LOGSID_HARDWARE_ID = new IdentifierType("LOGSID_HARDWARE_ID", 31, 52);
      LOGSID_MSISDN_ID = new IdentifierType("LOGSID_MSISDN_ID", 32, 53);
      LOGSID_BUILD_SERIAL_ID = new IdentifierType("LOGSID_BUILD_SERIAL_ID", 33, 54);
      LOGSID_UDID_ID = new IdentifierType("LOGSID_UDID_ID", 34, 55);
      LOGSID_ANDROID_LOGGING_ID = new IdentifierType("LOGSID_ANDROID_LOGGING_ID", 35, 56);
      LOGSID_SECURE_SETTINGS_ANDROID_ID = new IdentifierType("LOGSID_SECURE_SETTINGS_ANDROID_ID", 36, 57);
      LOGSID_OTHER_IDENTIFYING_USER_INFO = new IdentifierType("LOGSID_OTHER_IDENTIFYING_USER_INFO", 37, 100);
      LOGSID_USER_INPUT = new IdentifierType("LOGSID_USER_INPUT", 38, 200);
      LOGSID_DEMOGRAPHIC_INFO = new IdentifierType("LOGSID_DEMOGRAPHIC_INFO", 39, 201);
      LOGSID_GENERIC_KEY = new IdentifierType("LOGSID_GENERIC_KEY", 40, 202);
      LOGSID_GENERIC_VALUE = new IdentifierType("LOGSID_GENERIC_VALUE", 41, 203);
      LOGSID_COOKIE = new IdentifierType("LOGSID_COOKIE", 42, 204);
      LOGSID_URL = new IdentifierType("LOGSID_URL", 43, 205);
      LOGSID_HTTPHEADER = new IdentifierType("LOGSID_HTTPHEADER", 44, 206);
      $VALUES = new IdentifierType[] { 
          LOGSID_NONE, LOGSID_IP_ADDRESS, LOGSID_IP_ADDRESS_INTERNAL, LOGSID_USER_AGENT, LOGSID_SENSITIVE_TIMESTAMP, LOGSID_SENSITIVE_LOCATION, LOGSID_APPROXIMATE_LOCATION, LOGSID_COARSE_LOCATION, LOGSID_OTHER_LOCATION, LOGSID_OTHER_VERSION_ID, 
          LOGSID_REFERER, LOGSID_THIRD_PARTY_PARAMETERS, LOGSID_OTHER_PSEUDONYMOUS_ID, LOGSID_PREF, LOGSID_ZWIEBACK, LOGSID_BISCOTTI, LOGSID_CUSTOM_SESSION_ID, LOGSID_OTHER_PERSONAL_ID, LOGSID_GAIA_ID, LOGSID_EMAIL, 
          LOGSID_USERNAME, LOGSID_PHONE_NUMBER, LOGSID_GAIA_ID_PUBLIC, LOGSID_OTHER_AUTHENTICATED_ID, LOGSID_OTHER_UNAUTHENTICATED_ID, LOGSID_PARTNER_OR_CUSTOMER_ID, LOGSID_PUBLISHER_ID, LOGSID_DASHER_ID, LOGSID_FOCUS_GROUP_ID, LOGSID_OTHER_MOBILE_DEVICE_ID, 
          LOGSID_GSERVICES_ANDROID_ID, LOGSID_HARDWARE_ID, LOGSID_MSISDN_ID, LOGSID_BUILD_SERIAL_ID, LOGSID_UDID_ID, LOGSID_ANDROID_LOGGING_ID, LOGSID_SECURE_SETTINGS_ANDROID_ID, LOGSID_OTHER_IDENTIFYING_USER_INFO, LOGSID_USER_INPUT, LOGSID_DEMOGRAPHIC_INFO, 
          LOGSID_GENERIC_KEY, LOGSID_GENERIC_VALUE, LOGSID_COOKIE, LOGSID_URL, LOGSID_HTTPHEADER };
      internalValueMap = new Internal.EnumLiteMap<IdentifierType>() {
          public LogsAnnotations.IdentifierType findValueByNumber(int param2Int) {
            return LogsAnnotations.IdentifierType.forNumber(param2Int);
          }
        };
    }
    
    IdentifierType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static IdentifierType forNumber(int param1Int) {
      if (param1Int != 100) {
        switch (param1Int) {
          default:
            switch (param1Int) {
              default:
                switch (param1Int) {
                  default:
                    switch (param1Int) {
                      default:
                        switch (param1Int) {
                          default:
                            return null;
                          case 207:
                            return LOGSID_GAIA_ID_PUBLIC;
                          case 206:
                            return LOGSID_HTTPHEADER;
                          case 205:
                            return LOGSID_URL;
                          case 204:
                            return LOGSID_COOKIE;
                          case 203:
                            return LOGSID_GENERIC_VALUE;
                          case 202:
                            return LOGSID_GENERIC_KEY;
                          case 201:
                            return LOGSID_DEMOGRAPHIC_INFO;
                          case 200:
                            break;
                        } 
                        return LOGSID_USER_INPUT;
                      case 57:
                        return LOGSID_SECURE_SETTINGS_ANDROID_ID;
                      case 56:
                        return LOGSID_ANDROID_LOGGING_ID;
                      case 55:
                        return LOGSID_UDID_ID;
                      case 54:
                        return LOGSID_BUILD_SERIAL_ID;
                      case 53:
                        return LOGSID_MSISDN_ID;
                      case 52:
                        return LOGSID_HARDWARE_ID;
                      case 51:
                        return LOGSID_GSERVICES_ANDROID_ID;
                      case 50:
                        break;
                    } 
                    return LOGSID_OTHER_MOBILE_DEVICE_ID;
                  case 35:
                    return LOGSID_PUBLISHER_ID;
                  case 34:
                    return LOGSID_FOCUS_GROUP_ID;
                  case 33:
                    return LOGSID_DASHER_ID;
                  case 32:
                    return LOGSID_PARTNER_OR_CUSTOMER_ID;
                  case 31:
                    return LOGSID_OTHER_UNAUTHENTICATED_ID;
                  case 30:
                    break;
                } 
                return LOGSID_OTHER_AUTHENTICATED_ID;
              case 24:
                return LOGSID_PHONE_NUMBER;
              case 23:
                return LOGSID_USERNAME;
              case 22:
                return LOGSID_EMAIL;
              case 21:
                return LOGSID_GAIA_ID;
              case 20:
                break;
            } 
            return LOGSID_OTHER_PERSONAL_ID;
          case 16:
            return LOGSID_THIRD_PARTY_PARAMETERS;
          case 15:
            return LOGSID_APPROXIMATE_LOCATION;
          case 14:
            return LOGSID_CUSTOM_SESSION_ID;
          case 13:
            return LOGSID_BISCOTTI;
          case 12:
            return LOGSID_ZWIEBACK;
          case 11:
            return LOGSID_PREF;
          case 10:
            return LOGSID_OTHER_PSEUDONYMOUS_ID;
          case 9:
            return LOGSID_OTHER_LOCATION;
          case 8:
            return LOGSID_REFERER;
          case 7:
            return LOGSID_OTHER_VERSION_ID;
          case 6:
            return LOGSID_COARSE_LOCATION;
          case 5:
            return LOGSID_SENSITIVE_LOCATION;
          case 4:
            return LOGSID_SENSITIVE_TIMESTAMP;
          case 3:
            return LOGSID_USER_AGENT;
          case 2:
            return LOGSID_IP_ADDRESS_INTERNAL;
          case 1:
            return LOGSID_IP_ADDRESS;
          case 0:
            break;
        } 
        return LOGSID_NONE;
      } 
      return LOGSID_OTHER_IDENTIFYING_USER_INFO;
    }
    
    public static Internal.EnumLiteMap<IdentifierType> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<IdentifierType> {
    public LogsAnnotations.IdentifierType findValueByNumber(int param1Int) {
      return LogsAnnotations.IdentifierType.forNumber(param1Int);
    }
  }
  
  public static final class MessageDetails extends GeneratedMessageLite<MessageDetails, MessageDetails.Builder> implements MessageDetailsOrBuilder {
    private static final MessageDetails DEFAULT_INSTANCE = new MessageDetails();
    
    public static final int MAY_APPEAR_IN_FIELD_NUMBER = 1;
    
    private static volatile Parser<MessageDetails> PARSER;
    
    private Internal.ProtobufList<Type> mayAppearIn_ = emptyProtobufList();
    
    private byte memoizedIsInitialized = (byte)-1;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllMayAppearIn(Iterable<? extends Type> param1Iterable) {
      ensureMayAppearInIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.mayAppearIn_);
    }
    
    private void addMayAppearIn(int param1Int, Type.Builder param1Builder) {
      ensureMayAppearInIsMutable();
      this.mayAppearIn_.add(param1Int, param1Builder.build());
    }
    
    private void addMayAppearIn(int param1Int, Type param1Type) {
      if (param1Type != null) {
        ensureMayAppearInIsMutable();
        this.mayAppearIn_.add(param1Int, param1Type);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addMayAppearIn(Type.Builder param1Builder) {
      ensureMayAppearInIsMutable();
      this.mayAppearIn_.add(param1Builder.build());
    }
    
    private void addMayAppearIn(Type param1Type) {
      if (param1Type != null) {
        ensureMayAppearInIsMutable();
        this.mayAppearIn_.add(param1Type);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearMayAppearIn() {
      this.mayAppearIn_ = emptyProtobufList();
    }
    
    private void ensureMayAppearInIsMutable() {
      if (!this.mayAppearIn_.isModifiable())
        this.mayAppearIn_ = GeneratedMessageLite.mutableCopy(this.mayAppearIn_); 
    }
    
    public static MessageDetails getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(MessageDetails param1MessageDetails) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1MessageDetails);
    }
    
    public static MessageDetails parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (MessageDetails)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static MessageDetails parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (MessageDetails)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static MessageDetails parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (MessageDetails)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static MessageDetails parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (MessageDetails)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static MessageDetails parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (MessageDetails)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static MessageDetails parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (MessageDetails)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static MessageDetails parseFrom(InputStream param1InputStream) throws IOException {
      return (MessageDetails)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static MessageDetails parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (MessageDetails)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static MessageDetails parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (MessageDetails)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static MessageDetails parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (MessageDetails)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<MessageDetails> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeMayAppearIn(int param1Int) {
      ensureMayAppearInIsMutable();
      this.mayAppearIn_.remove(param1Int);
    }
    
    private void setMayAppearIn(int param1Int, Type.Builder param1Builder) {
      ensureMayAppearInIsMutable();
      this.mayAppearIn_.set(param1Int, param1Builder.build());
    }
    
    private void setMayAppearIn(int param1Int, Type param1Type) {
      if (param1Type != null) {
        ensureMayAppearInIsMutable();
        this.mayAppearIn_.set(param1Int, param1Type);
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic logs_proto/LogsAnnotations$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: istore #4
      //   10: iconst_0
      //   11: istore #5
      //   13: iload #4
      //   15: tableswitch default -> 60, 1 -> 414, 2 -> 324, 3 -> 313, 4 -> 304, 5 -> 270, 6 -> 114, 7 -> 266, 8 -> 68
      //   60: new java/lang/UnsupportedOperationException
      //   63: dup
      //   64: invokespecial <init> : ()V
      //   67: athrow
      //   68: getstatic logs_proto/LogsAnnotations$MessageDetails.PARSER : Lcom/google/protobuf/Parser;
      //   71: ifnonnull -> 110
      //   74: ldc logs_proto/LogsAnnotations$MessageDetails
      //   76: monitorenter
      //   77: getstatic logs_proto/LogsAnnotations$MessageDetails.PARSER : Lcom/google/protobuf/Parser;
      //   80: ifnonnull -> 98
      //   83: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   86: astore_1
      //   87: aload_1
      //   88: getstatic logs_proto/LogsAnnotations$MessageDetails.DEFAULT_INSTANCE : Llogs_proto/LogsAnnotations$MessageDetails;
      //   91: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   94: aload_1
      //   95: putstatic logs_proto/LogsAnnotations$MessageDetails.PARSER : Lcom/google/protobuf/Parser;
      //   98: ldc logs_proto/LogsAnnotations$MessageDetails
      //   100: monitorexit
      //   101: goto -> 110
      //   104: astore_1
      //   105: ldc logs_proto/LogsAnnotations$MessageDetails
      //   107: monitorexit
      //   108: aload_1
      //   109: athrow
      //   110: getstatic logs_proto/LogsAnnotations$MessageDetails.PARSER : Lcom/google/protobuf/Parser;
      //   113: areturn
      //   114: aload_2
      //   115: checkcast com/google/protobuf/CodedInputStream
      //   118: astore_1
      //   119: aload_3
      //   120: checkcast com/google/protobuf/ExtensionRegistryLite
      //   123: astore_2
      //   124: iload #5
      //   126: ifne -> 266
      //   129: aload_1
      //   130: invokevirtual readTag : ()I
      //   133: istore #4
      //   135: iload #4
      //   137: ifeq -> 210
      //   140: iload #4
      //   142: bipush #10
      //   144: if_icmpeq -> 163
      //   147: aload_0
      //   148: iload #4
      //   150: aload_1
      //   151: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   154: ifne -> 124
      //   157: iconst_1
      //   158: istore #5
      //   160: goto -> 124
      //   163: aload_0
      //   164: getfield mayAppearIn_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   167: invokeinterface isModifiable : ()Z
      //   172: ifne -> 186
      //   175: aload_0
      //   176: aload_0
      //   177: getfield mayAppearIn_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   180: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   183: putfield mayAppearIn_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   186: aload_0
      //   187: getfield mayAppearIn_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   190: aload_1
      //   191: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   194: aload_2
      //   195: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   198: checkcast logs_proto/LogsAnnotations$MessageDetails$Type
      //   201: invokeinterface add : (Ljava/lang/Object;)Z
      //   206: pop
      //   207: goto -> 124
      //   210: iconst_1
      //   211: istore #5
      //   213: goto -> 124
      //   216: astore_1
      //   217: goto -> 264
      //   220: astore_1
      //   221: new java/lang/RuntimeException
      //   224: astore_2
      //   225: new com/google/protobuf/InvalidProtocolBufferException
      //   228: astore_3
      //   229: aload_3
      //   230: aload_1
      //   231: invokevirtual getMessage : ()Ljava/lang/String;
      //   234: invokespecial <init> : (Ljava/lang/String;)V
      //   237: aload_2
      //   238: aload_3
      //   239: aload_0
      //   240: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   243: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   246: aload_2
      //   247: athrow
      //   248: astore_1
      //   249: new java/lang/RuntimeException
      //   252: astore_2
      //   253: aload_2
      //   254: aload_1
      //   255: aload_0
      //   256: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   259: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   262: aload_2
      //   263: athrow
      //   264: aload_1
      //   265: athrow
      //   266: getstatic logs_proto/LogsAnnotations$MessageDetails.DEFAULT_INSTANCE : Llogs_proto/LogsAnnotations$MessageDetails;
      //   269: areturn
      //   270: aload_2
      //   271: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   274: astore_1
      //   275: aload_3
      //   276: checkcast logs_proto/LogsAnnotations$MessageDetails
      //   279: astore_2
      //   280: aload_0
      //   281: aload_1
      //   282: aload_0
      //   283: getfield mayAppearIn_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   286: aload_2
      //   287: getfield mayAppearIn_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   290: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   295: putfield mayAppearIn_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   298: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   301: astore_1
      //   302: aload_0
      //   303: areturn
      //   304: new logs_proto/LogsAnnotations$MessageDetails$Builder
      //   307: dup
      //   308: aconst_null
      //   309: invokespecial <init> : (Llogs_proto/LogsAnnotations$1;)V
      //   312: areturn
      //   313: aload_0
      //   314: getfield mayAppearIn_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   317: invokeinterface makeImmutable : ()V
      //   322: aconst_null
      //   323: areturn
      //   324: aload_0
      //   325: getfield memoizedIsInitialized : B
      //   328: istore #5
      //   330: iload #5
      //   332: iconst_1
      //   333: if_icmpne -> 340
      //   336: getstatic logs_proto/LogsAnnotations$MessageDetails.DEFAULT_INSTANCE : Llogs_proto/LogsAnnotations$MessageDetails;
      //   339: areturn
      //   340: iload #5
      //   342: ifne -> 347
      //   345: aconst_null
      //   346: areturn
      //   347: aload_2
      //   348: checkcast java/lang/Boolean
      //   351: invokevirtual booleanValue : ()Z
      //   354: istore #6
      //   356: iconst_0
      //   357: istore #5
      //   359: iload #5
      //   361: aload_0
      //   362: invokevirtual getMayAppearInCount : ()I
      //   365: if_icmpge -> 399
      //   368: aload_0
      //   369: iload #5
      //   371: invokevirtual getMayAppearIn : (I)Llogs_proto/LogsAnnotations$MessageDetails$Type;
      //   374: invokevirtual isInitialized : ()Z
      //   377: ifne -> 393
      //   380: iload #6
      //   382: ifeq -> 391
      //   385: aload_0
      //   386: iconst_0
      //   387: i2b
      //   388: putfield memoizedIsInitialized : B
      //   391: aconst_null
      //   392: areturn
      //   393: iinc #5, 1
      //   396: goto -> 359
      //   399: iload #6
      //   401: ifeq -> 410
      //   404: aload_0
      //   405: iconst_1
      //   406: i2b
      //   407: putfield memoizedIsInitialized : B
      //   410: getstatic logs_proto/LogsAnnotations$MessageDetails.DEFAULT_INSTANCE : Llogs_proto/LogsAnnotations$MessageDetails;
      //   413: areturn
      //   414: new logs_proto/LogsAnnotations$MessageDetails
      //   417: dup
      //   418: invokespecial <init> : ()V
      //   421: areturn
      // Exception table:
      //   from	to	target	type
      //   77	98	104	finally
      //   98	101	104	finally
      //   105	108	104	finally
      //   129	135	248	com/google/protobuf/InvalidProtocolBufferException
      //   129	135	220	java/io/IOException
      //   129	135	216	finally
      //   147	157	248	com/google/protobuf/InvalidProtocolBufferException
      //   147	157	220	java/io/IOException
      //   147	157	216	finally
      //   163	186	248	com/google/protobuf/InvalidProtocolBufferException
      //   163	186	220	java/io/IOException
      //   163	186	216	finally
      //   186	207	248	com/google/protobuf/InvalidProtocolBufferException
      //   186	207	220	java/io/IOException
      //   186	207	216	finally
      //   221	248	216	finally
      //   249	264	216	finally
    }
    
    public Type getMayAppearIn(int param1Int) {
      return (Type)this.mayAppearIn_.get(param1Int);
    }
    
    public int getMayAppearInCount() {
      return this.mayAppearIn_.size();
    }
    
    public List<Type> getMayAppearInList() {
      return (List<Type>)this.mayAppearIn_;
    }
    
    public TypeOrBuilder getMayAppearInOrBuilder(int param1Int) {
      return (TypeOrBuilder)this.mayAppearIn_.get(param1Int);
    }
    
    public List<? extends TypeOrBuilder> getMayAppearInOrBuilderList() {
      return (List)this.mayAppearIn_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      int j = 0;
      while (i < this.mayAppearIn_.size()) {
        j += CodedOutputStream.computeMessageSize(1, (MessageLite)this.mayAppearIn_.get(i));
        i++;
      } 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      for (byte b = 0; b < this.mayAppearIn_.size(); b++)
        param1CodedOutputStream.writeMessage(1, (MessageLite)this.mayAppearIn_.get(b)); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<MessageDetails, Builder> implements LogsAnnotations.MessageDetailsOrBuilder {
      private Builder() {
        super(LogsAnnotations.MessageDetails.DEFAULT_INSTANCE);
      }
      
      public Builder addAllMayAppearIn(Iterable<? extends LogsAnnotations.MessageDetails.Type> param2Iterable) {
        copyOnWrite();
        ((LogsAnnotations.MessageDetails)this.instance).addAllMayAppearIn(param2Iterable);
        return this;
      }
      
      public Builder addMayAppearIn(int param2Int, LogsAnnotations.MessageDetails.Type.Builder param2Builder) {
        copyOnWrite();
        ((LogsAnnotations.MessageDetails)this.instance).addMayAppearIn(param2Int, param2Builder);
        return this;
      }
      
      public Builder addMayAppearIn(int param2Int, LogsAnnotations.MessageDetails.Type param2Type) {
        copyOnWrite();
        ((LogsAnnotations.MessageDetails)this.instance).addMayAppearIn(param2Int, param2Type);
        return this;
      }
      
      public Builder addMayAppearIn(LogsAnnotations.MessageDetails.Type.Builder param2Builder) {
        copyOnWrite();
        ((LogsAnnotations.MessageDetails)this.instance).addMayAppearIn(param2Builder);
        return this;
      }
      
      public Builder addMayAppearIn(LogsAnnotations.MessageDetails.Type param2Type) {
        copyOnWrite();
        ((LogsAnnotations.MessageDetails)this.instance).addMayAppearIn(param2Type);
        return this;
      }
      
      public Builder clearMayAppearIn() {
        copyOnWrite();
        ((LogsAnnotations.MessageDetails)this.instance).clearMayAppearIn();
        return this;
      }
      
      public LogsAnnotations.MessageDetails.Type getMayAppearIn(int param2Int) {
        return ((LogsAnnotations.MessageDetails)this.instance).getMayAppearIn(param2Int);
      }
      
      public int getMayAppearInCount() {
        return ((LogsAnnotations.MessageDetails)this.instance).getMayAppearInCount();
      }
      
      public List<LogsAnnotations.MessageDetails.Type> getMayAppearInList() {
        return Collections.unmodifiableList(((LogsAnnotations.MessageDetails)this.instance).getMayAppearInList());
      }
      
      public Builder removeMayAppearIn(int param2Int) {
        copyOnWrite();
        ((LogsAnnotations.MessageDetails)this.instance).removeMayAppearIn(param2Int);
        return this;
      }
      
      public Builder setMayAppearIn(int param2Int, LogsAnnotations.MessageDetails.Type.Builder param2Builder) {
        copyOnWrite();
        ((LogsAnnotations.MessageDetails)this.instance).setMayAppearIn(param2Int, param2Builder);
        return this;
      }
      
      public Builder setMayAppearIn(int param2Int, LogsAnnotations.MessageDetails.Type param2Type) {
        copyOnWrite();
        ((LogsAnnotations.MessageDetails)this.instance).setMayAppearIn(param2Int, param2Type);
        return this;
      }
    }
    
    public static final class Type extends GeneratedMessageLite<Type, Type.Builder> implements TypeOrBuilder {
      private static final Type DEFAULT_INSTANCE = new Type();
      
      public static final int LOG_TYPE_FIELD_NUMBER = 2;
      
      private static volatile Parser<Type> PARSER;
      
      public static final int SOURCE_TYPE_FIELD_NUMBER = 1;
      
      private int bitField0_;
      
      private String logType_ = "";
      
      private byte memoizedIsInitialized = (byte)-1;
      
      private String sourceType_ = "";
      
      static {
        DEFAULT_INSTANCE.makeImmutable();
      }
      
      private void clearLogType() {
        this.bitField0_ &= 0xFFFFFFFD;
        this.logType_ = getDefaultInstance().getLogType();
      }
      
      private void clearSourceType() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.sourceType_ = getDefaultInstance().getSourceType();
      }
      
      public static Type getDefaultInstance() {
        return DEFAULT_INSTANCE;
      }
      
      public static Builder newBuilder() {
        return (Builder)DEFAULT_INSTANCE.toBuilder();
      }
      
      public static Builder newBuilder(Type param2Type) {
        return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param2Type);
      }
      
      public static Type parseDelimitedFrom(InputStream param2InputStream) throws IOException {
        return (Type)parseDelimitedFrom(DEFAULT_INSTANCE, param2InputStream);
      }
      
      public static Type parseDelimitedFrom(InputStream param2InputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (Type)parseDelimitedFrom(DEFAULT_INSTANCE, param2InputStream, param2ExtensionRegistryLite);
      }
      
      public static Type parseFrom(ByteString param2ByteString) throws InvalidProtocolBufferException {
        return (Type)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ByteString);
      }
      
      public static Type parseFrom(ByteString param2ByteString, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (Type)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ByteString, param2ExtensionRegistryLite);
      }
      
      public static Type parseFrom(CodedInputStream param2CodedInputStream) throws IOException {
        return (Type)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2CodedInputStream);
      }
      
      public static Type parseFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (Type)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2CodedInputStream, param2ExtensionRegistryLite);
      }
      
      public static Type parseFrom(InputStream param2InputStream) throws IOException {
        return (Type)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2InputStream);
      }
      
      public static Type parseFrom(InputStream param2InputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (Type)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2InputStream, param2ExtensionRegistryLite);
      }
      
      public static Type parseFrom(byte[] param2ArrayOfbyte) throws InvalidProtocolBufferException {
        return (Type)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ArrayOfbyte);
      }
      
      public static Type parseFrom(byte[] param2ArrayOfbyte, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (Type)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ArrayOfbyte, param2ExtensionRegistryLite);
      }
      
      public static Parser<Type> parser() {
        return DEFAULT_INSTANCE.getParserForType();
      }
      
      private void setLogType(String param2String) {
        if (param2String != null) {
          this.bitField0_ |= 0x2;
          this.logType_ = param2String;
          return;
        } 
        throw new NullPointerException();
      }
      
      private void setLogTypeBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          this.bitField0_ |= 0x2;
          this.logType_ = param2ByteString.toStringUtf8();
          return;
        } 
        throw new NullPointerException();
      }
      
      private void setSourceType(String param2String) {
        if (param2String != null) {
          this.bitField0_ |= 0x1;
          this.sourceType_ = param2String;
          return;
        } 
        throw new NullPointerException();
      }
      
      private void setSourceTypeBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          this.bitField0_ |= 0x1;
          this.sourceType_ = param2ByteString.toStringUtf8();
          return;
        } 
        throw new NullPointerException();
      }
      
      protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param2MethodToInvoke, Object param2Object1, Object param2Object2) {
        // Byte code:
        //   0: getstatic logs_proto/LogsAnnotations$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
        //   3: aload_1
        //   4: invokevirtual ordinal : ()I
        //   7: iaload
        //   8: istore #4
        //   10: iconst_0
        //   11: istore #5
        //   13: iload #4
        //   15: tableswitch default -> 60, 1 -> 458, 2 -> 371, 3 -> 369, 4 -> 360, 5 -> 276, 6 -> 114, 7 -> 272, 8 -> 68
        //   60: new java/lang/UnsupportedOperationException
        //   63: dup
        //   64: invokespecial <init> : ()V
        //   67: athrow
        //   68: getstatic logs_proto/LogsAnnotations$MessageDetails$Type.PARSER : Lcom/google/protobuf/Parser;
        //   71: ifnonnull -> 110
        //   74: ldc logs_proto/LogsAnnotations$MessageDetails$Type
        //   76: monitorenter
        //   77: getstatic logs_proto/LogsAnnotations$MessageDetails$Type.PARSER : Lcom/google/protobuf/Parser;
        //   80: ifnonnull -> 98
        //   83: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
        //   86: astore_1
        //   87: aload_1
        //   88: getstatic logs_proto/LogsAnnotations$MessageDetails$Type.DEFAULT_INSTANCE : Llogs_proto/LogsAnnotations$MessageDetails$Type;
        //   91: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
        //   94: aload_1
        //   95: putstatic logs_proto/LogsAnnotations$MessageDetails$Type.PARSER : Lcom/google/protobuf/Parser;
        //   98: ldc logs_proto/LogsAnnotations$MessageDetails$Type
        //   100: monitorexit
        //   101: goto -> 110
        //   104: astore_1
        //   105: ldc logs_proto/LogsAnnotations$MessageDetails$Type
        //   107: monitorexit
        //   108: aload_1
        //   109: athrow
        //   110: getstatic logs_proto/LogsAnnotations$MessageDetails$Type.PARSER : Lcom/google/protobuf/Parser;
        //   113: areturn
        //   114: aload_2
        //   115: checkcast com/google/protobuf/CodedInputStream
        //   118: astore_1
        //   119: aload_3
        //   120: checkcast com/google/protobuf/ExtensionRegistryLite
        //   123: astore_2
        //   124: iload #5
        //   126: ifne -> 272
        //   129: aload_1
        //   130: invokevirtual readTag : ()I
        //   133: istore #4
        //   135: iload #4
        //   137: ifeq -> 216
        //   140: iload #4
        //   142: bipush #10
        //   144: if_icmpeq -> 193
        //   147: iload #4
        //   149: bipush #18
        //   151: if_icmpeq -> 170
        //   154: aload_0
        //   155: iload #4
        //   157: aload_1
        //   158: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
        //   161: ifne -> 124
        //   164: iconst_1
        //   165: istore #5
        //   167: goto -> 124
        //   170: aload_1
        //   171: invokevirtual readString : ()Ljava/lang/String;
        //   174: astore_2
        //   175: aload_0
        //   176: aload_0
        //   177: getfield bitField0_ : I
        //   180: iconst_2
        //   181: ior
        //   182: putfield bitField0_ : I
        //   185: aload_0
        //   186: aload_2
        //   187: putfield logType_ : Ljava/lang/String;
        //   190: goto -> 124
        //   193: aload_1
        //   194: invokevirtual readString : ()Ljava/lang/String;
        //   197: astore_2
        //   198: aload_0
        //   199: aload_0
        //   200: getfield bitField0_ : I
        //   203: iconst_1
        //   204: ior
        //   205: putfield bitField0_ : I
        //   208: aload_0
        //   209: aload_2
        //   210: putfield sourceType_ : Ljava/lang/String;
        //   213: goto -> 124
        //   216: iconst_1
        //   217: istore #5
        //   219: goto -> 124
        //   222: astore_1
        //   223: goto -> 270
        //   226: astore_2
        //   227: new java/lang/RuntimeException
        //   230: astore_3
        //   231: new com/google/protobuf/InvalidProtocolBufferException
        //   234: astore_1
        //   235: aload_1
        //   236: aload_2
        //   237: invokevirtual getMessage : ()Ljava/lang/String;
        //   240: invokespecial <init> : (Ljava/lang/String;)V
        //   243: aload_3
        //   244: aload_1
        //   245: aload_0
        //   246: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
        //   249: invokespecial <init> : (Ljava/lang/Throwable;)V
        //   252: aload_3
        //   253: athrow
        //   254: astore_1
        //   255: new java/lang/RuntimeException
        //   258: astore_2
        //   259: aload_2
        //   260: aload_1
        //   261: aload_0
        //   262: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
        //   265: invokespecial <init> : (Ljava/lang/Throwable;)V
        //   268: aload_2
        //   269: athrow
        //   270: aload_1
        //   271: athrow
        //   272: getstatic logs_proto/LogsAnnotations$MessageDetails$Type.DEFAULT_INSTANCE : Llogs_proto/LogsAnnotations$MessageDetails$Type;
        //   275: areturn
        //   276: aload_2
        //   277: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
        //   280: astore_1
        //   281: aload_3
        //   282: checkcast logs_proto/LogsAnnotations$MessageDetails$Type
        //   285: astore_2
        //   286: aload_0
        //   287: aload_1
        //   288: aload_0
        //   289: invokevirtual hasSourceType : ()Z
        //   292: aload_0
        //   293: getfield sourceType_ : Ljava/lang/String;
        //   296: aload_2
        //   297: invokevirtual hasSourceType : ()Z
        //   300: aload_2
        //   301: getfield sourceType_ : Ljava/lang/String;
        //   304: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
        //   309: putfield sourceType_ : Ljava/lang/String;
        //   312: aload_0
        //   313: aload_1
        //   314: aload_0
        //   315: invokevirtual hasLogType : ()Z
        //   318: aload_0
        //   319: getfield logType_ : Ljava/lang/String;
        //   322: aload_2
        //   323: invokevirtual hasLogType : ()Z
        //   326: aload_2
        //   327: getfield logType_ : Ljava/lang/String;
        //   330: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
        //   335: putfield logType_ : Ljava/lang/String;
        //   338: aload_1
        //   339: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
        //   342: if_acmpne -> 358
        //   345: aload_0
        //   346: aload_0
        //   347: getfield bitField0_ : I
        //   350: aload_2
        //   351: getfield bitField0_ : I
        //   354: ior
        //   355: putfield bitField0_ : I
        //   358: aload_0
        //   359: areturn
        //   360: new logs_proto/LogsAnnotations$MessageDetails$Type$Builder
        //   363: dup
        //   364: aconst_null
        //   365: invokespecial <init> : (Llogs_proto/LogsAnnotations$1;)V
        //   368: areturn
        //   369: aconst_null
        //   370: areturn
        //   371: aload_0
        //   372: getfield memoizedIsInitialized : B
        //   375: istore #5
        //   377: iload #5
        //   379: iconst_1
        //   380: if_icmpne -> 387
        //   383: getstatic logs_proto/LogsAnnotations$MessageDetails$Type.DEFAULT_INSTANCE : Llogs_proto/LogsAnnotations$MessageDetails$Type;
        //   386: areturn
        //   387: iload #5
        //   389: ifne -> 394
        //   392: aconst_null
        //   393: areturn
        //   394: aload_2
        //   395: checkcast java/lang/Boolean
        //   398: invokevirtual booleanValue : ()Z
        //   401: istore #6
        //   403: aload_0
        //   404: invokevirtual hasSourceType : ()Z
        //   407: ifne -> 423
        //   410: iload #6
        //   412: ifeq -> 421
        //   415: aload_0
        //   416: iconst_0
        //   417: i2b
        //   418: putfield memoizedIsInitialized : B
        //   421: aconst_null
        //   422: areturn
        //   423: aload_0
        //   424: invokevirtual hasLogType : ()Z
        //   427: ifne -> 443
        //   430: iload #6
        //   432: ifeq -> 441
        //   435: aload_0
        //   436: iconst_0
        //   437: i2b
        //   438: putfield memoizedIsInitialized : B
        //   441: aconst_null
        //   442: areturn
        //   443: iload #6
        //   445: ifeq -> 454
        //   448: aload_0
        //   449: iconst_1
        //   450: i2b
        //   451: putfield memoizedIsInitialized : B
        //   454: getstatic logs_proto/LogsAnnotations$MessageDetails$Type.DEFAULT_INSTANCE : Llogs_proto/LogsAnnotations$MessageDetails$Type;
        //   457: areturn
        //   458: new logs_proto/LogsAnnotations$MessageDetails$Type
        //   461: dup
        //   462: invokespecial <init> : ()V
        //   465: areturn
        // Exception table:
        //   from	to	target	type
        //   77	98	104	finally
        //   98	101	104	finally
        //   105	108	104	finally
        //   129	135	254	com/google/protobuf/InvalidProtocolBufferException
        //   129	135	226	java/io/IOException
        //   129	135	222	finally
        //   154	164	254	com/google/protobuf/InvalidProtocolBufferException
        //   154	164	226	java/io/IOException
        //   154	164	222	finally
        //   170	190	254	com/google/protobuf/InvalidProtocolBufferException
        //   170	190	226	java/io/IOException
        //   170	190	222	finally
        //   193	213	254	com/google/protobuf/InvalidProtocolBufferException
        //   193	213	226	java/io/IOException
        //   193	213	222	finally
        //   227	254	222	finally
        //   255	270	222	finally
      }
      
      public String getLogType() {
        return this.logType_;
      }
      
      public ByteString getLogTypeBytes() {
        return ByteString.copyFromUtf8(this.logType_);
      }
      
      public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1)
          return i; 
        i = 0;
        if ((this.bitField0_ & 0x1) == 1)
          i = 0 + CodedOutputStream.computeStringSize(1, getSourceType()); 
        int j = i;
        if ((this.bitField0_ & 0x2) == 2)
          j = i + CodedOutputStream.computeStringSize(2, getLogType()); 
        i = j + this.unknownFields.getSerializedSize();
        this.memoizedSerializedSize = i;
        return i;
      }
      
      public String getSourceType() {
        return this.sourceType_;
      }
      
      public ByteString getSourceTypeBytes() {
        return ByteString.copyFromUtf8(this.sourceType_);
      }
      
      public boolean hasLogType() {
        boolean bool;
        if ((this.bitField0_ & 0x2) == 2) {
          bool = true;
        } else {
          bool = false;
        } 
        return bool;
      }
      
      public boolean hasSourceType() {
        int i = this.bitField0_;
        boolean bool = true;
        if ((i & 0x1) != 1)
          bool = false; 
        return bool;
      }
      
      public void writeTo(CodedOutputStream param2CodedOutputStream) throws IOException {
        if ((this.bitField0_ & 0x1) == 1)
          param2CodedOutputStream.writeString(1, getSourceType()); 
        if ((this.bitField0_ & 0x2) == 2)
          param2CodedOutputStream.writeString(2, getLogType()); 
        this.unknownFields.writeTo(param2CodedOutputStream);
      }
      
      public static final class Builder extends GeneratedMessageLite.Builder<Type, Builder> implements LogsAnnotations.MessageDetails.TypeOrBuilder {
        private Builder() {
          super(LogsAnnotations.MessageDetails.Type.DEFAULT_INSTANCE);
        }
        
        public Builder clearLogType() {
          copyOnWrite();
          ((LogsAnnotations.MessageDetails.Type)this.instance).clearLogType();
          return this;
        }
        
        public Builder clearSourceType() {
          copyOnWrite();
          ((LogsAnnotations.MessageDetails.Type)this.instance).clearSourceType();
          return this;
        }
        
        public String getLogType() {
          return ((LogsAnnotations.MessageDetails.Type)this.instance).getLogType();
        }
        
        public ByteString getLogTypeBytes() {
          return ((LogsAnnotations.MessageDetails.Type)this.instance).getLogTypeBytes();
        }
        
        public String getSourceType() {
          return ((LogsAnnotations.MessageDetails.Type)this.instance).getSourceType();
        }
        
        public ByteString getSourceTypeBytes() {
          return ((LogsAnnotations.MessageDetails.Type)this.instance).getSourceTypeBytes();
        }
        
        public boolean hasLogType() {
          return ((LogsAnnotations.MessageDetails.Type)this.instance).hasLogType();
        }
        
        public boolean hasSourceType() {
          return ((LogsAnnotations.MessageDetails.Type)this.instance).hasSourceType();
        }
        
        public Builder setLogType(String param3String) {
          copyOnWrite();
          ((LogsAnnotations.MessageDetails.Type)this.instance).setLogType(param3String);
          return this;
        }
        
        public Builder setLogTypeBytes(ByteString param3ByteString) {
          copyOnWrite();
          ((LogsAnnotations.MessageDetails.Type)this.instance).setLogTypeBytes(param3ByteString);
          return this;
        }
        
        public Builder setSourceType(String param3String) {
          copyOnWrite();
          ((LogsAnnotations.MessageDetails.Type)this.instance).setSourceType(param3String);
          return this;
        }
        
        public Builder setSourceTypeBytes(ByteString param3ByteString) {
          copyOnWrite();
          ((LogsAnnotations.MessageDetails.Type)this.instance).setSourceTypeBytes(param3ByteString);
          return this;
        }
      }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Type, Type.Builder> implements TypeOrBuilder {
      private Builder() {
        super(LogsAnnotations.MessageDetails.Type.DEFAULT_INSTANCE);
      }
      
      public Builder clearLogType() {
        copyOnWrite();
        ((LogsAnnotations.MessageDetails.Type)this.instance).clearLogType();
        return this;
      }
      
      public Builder clearSourceType() {
        copyOnWrite();
        ((LogsAnnotations.MessageDetails.Type)this.instance).clearSourceType();
        return this;
      }
      
      public String getLogType() {
        return ((LogsAnnotations.MessageDetails.Type)this.instance).getLogType();
      }
      
      public ByteString getLogTypeBytes() {
        return ((LogsAnnotations.MessageDetails.Type)this.instance).getLogTypeBytes();
      }
      
      public String getSourceType() {
        return ((LogsAnnotations.MessageDetails.Type)this.instance).getSourceType();
      }
      
      public ByteString getSourceTypeBytes() {
        return ((LogsAnnotations.MessageDetails.Type)this.instance).getSourceTypeBytes();
      }
      
      public boolean hasLogType() {
        return ((LogsAnnotations.MessageDetails.Type)this.instance).hasLogType();
      }
      
      public boolean hasSourceType() {
        return ((LogsAnnotations.MessageDetails.Type)this.instance).hasSourceType();
      }
      
      public Builder setLogType(String param2String) {
        copyOnWrite();
        ((LogsAnnotations.MessageDetails.Type)this.instance).setLogType(param2String);
        return this;
      }
      
      public Builder setLogTypeBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((LogsAnnotations.MessageDetails.Type)this.instance).setLogTypeBytes(param2ByteString);
        return this;
      }
      
      public Builder setSourceType(String param2String) {
        copyOnWrite();
        ((LogsAnnotations.MessageDetails.Type)this.instance).setSourceType(param2String);
        return this;
      }
      
      public Builder setSourceTypeBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((LogsAnnotations.MessageDetails.Type)this.instance).setSourceTypeBytes(param2ByteString);
        return this;
      }
    }
    
    public static interface TypeOrBuilder extends MessageLiteOrBuilder {
      String getLogType();
      
      ByteString getLogTypeBytes();
      
      String getSourceType();
      
      ByteString getSourceTypeBytes();
      
      boolean hasLogType();
      
      boolean hasSourceType();
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<MessageDetails, MessageDetails.Builder> implements MessageDetailsOrBuilder {
    private Builder() {
      super(LogsAnnotations.MessageDetails.DEFAULT_INSTANCE);
    }
    
    public Builder addAllMayAppearIn(Iterable<? extends LogsAnnotations.MessageDetails.Type> param1Iterable) {
      copyOnWrite();
      ((LogsAnnotations.MessageDetails)this.instance).addAllMayAppearIn(param1Iterable);
      return this;
    }
    
    public Builder addMayAppearIn(int param1Int, LogsAnnotations.MessageDetails.Type.Builder param1Builder) {
      copyOnWrite();
      ((LogsAnnotations.MessageDetails)this.instance).addMayAppearIn(param1Int, param1Builder);
      return this;
    }
    
    public Builder addMayAppearIn(int param1Int, LogsAnnotations.MessageDetails.Type param1Type) {
      copyOnWrite();
      ((LogsAnnotations.MessageDetails)this.instance).addMayAppearIn(param1Int, param1Type);
      return this;
    }
    
    public Builder addMayAppearIn(LogsAnnotations.MessageDetails.Type.Builder param1Builder) {
      copyOnWrite();
      ((LogsAnnotations.MessageDetails)this.instance).addMayAppearIn(param1Builder);
      return this;
    }
    
    public Builder addMayAppearIn(LogsAnnotations.MessageDetails.Type param1Type) {
      copyOnWrite();
      ((LogsAnnotations.MessageDetails)this.instance).addMayAppearIn(param1Type);
      return this;
    }
    
    public Builder clearMayAppearIn() {
      copyOnWrite();
      ((LogsAnnotations.MessageDetails)this.instance).clearMayAppearIn();
      return this;
    }
    
    public LogsAnnotations.MessageDetails.Type getMayAppearIn(int param1Int) {
      return ((LogsAnnotations.MessageDetails)this.instance).getMayAppearIn(param1Int);
    }
    
    public int getMayAppearInCount() {
      return ((LogsAnnotations.MessageDetails)this.instance).getMayAppearInCount();
    }
    
    public List<LogsAnnotations.MessageDetails.Type> getMayAppearInList() {
      return Collections.unmodifiableList(((LogsAnnotations.MessageDetails)this.instance).getMayAppearInList());
    }
    
    public Builder removeMayAppearIn(int param1Int) {
      copyOnWrite();
      ((LogsAnnotations.MessageDetails)this.instance).removeMayAppearIn(param1Int);
      return this;
    }
    
    public Builder setMayAppearIn(int param1Int, LogsAnnotations.MessageDetails.Type.Builder param1Builder) {
      copyOnWrite();
      ((LogsAnnotations.MessageDetails)this.instance).setMayAppearIn(param1Int, param1Builder);
      return this;
    }
    
    public Builder setMayAppearIn(int param1Int, LogsAnnotations.MessageDetails.Type param1Type) {
      copyOnWrite();
      ((LogsAnnotations.MessageDetails)this.instance).setMayAppearIn(param1Int, param1Type);
      return this;
    }
  }
  
  public static final class Type extends GeneratedMessageLite<MessageDetails.Type, MessageDetails.Type.Builder> implements MessageDetails.TypeOrBuilder {
    private static final Type DEFAULT_INSTANCE = new Type();
    
    public static final int LOG_TYPE_FIELD_NUMBER = 2;
    
    private static volatile Parser<Type> PARSER;
    
    public static final int SOURCE_TYPE_FIELD_NUMBER = 1;
    
    private int bitField0_;
    
    private String logType_ = "";
    
    private byte memoizedIsInitialized = (byte)-1;
    
    private String sourceType_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearLogType() {
      this.bitField0_ &= 0xFFFFFFFD;
      this.logType_ = getDefaultInstance().getLogType();
    }
    
    private void clearSourceType() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.sourceType_ = getDefaultInstance().getSourceType();
    }
    
    public static Type getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Type param1Type) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1Type);
    }
    
    public static Type parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Type)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Type parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Type)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Type parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Type)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static Type parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Type)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Type parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Type)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static Type parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Type)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Type parseFrom(InputStream param1InputStream) throws IOException {
      return (Type)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Type parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Type)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Type parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Type)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static Type parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Type)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Type> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setLogType(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x2;
        this.logType_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setLogTypeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x2;
        this.logType_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setSourceType(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x1;
        this.sourceType_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setSourceTypeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x1;
        this.sourceType_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic logs_proto/LogsAnnotations$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: istore #4
      //   10: iconst_0
      //   11: istore #5
      //   13: iload #4
      //   15: tableswitch default -> 60, 1 -> 458, 2 -> 371, 3 -> 369, 4 -> 360, 5 -> 276, 6 -> 114, 7 -> 272, 8 -> 68
      //   60: new java/lang/UnsupportedOperationException
      //   63: dup
      //   64: invokespecial <init> : ()V
      //   67: athrow
      //   68: getstatic logs_proto/LogsAnnotations$MessageDetails$Type.PARSER : Lcom/google/protobuf/Parser;
      //   71: ifnonnull -> 110
      //   74: ldc logs_proto/LogsAnnotations$MessageDetails$Type
      //   76: monitorenter
      //   77: getstatic logs_proto/LogsAnnotations$MessageDetails$Type.PARSER : Lcom/google/protobuf/Parser;
      //   80: ifnonnull -> 98
      //   83: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   86: astore_1
      //   87: aload_1
      //   88: getstatic logs_proto/LogsAnnotations$MessageDetails$Type.DEFAULT_INSTANCE : Llogs_proto/LogsAnnotations$MessageDetails$Type;
      //   91: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   94: aload_1
      //   95: putstatic logs_proto/LogsAnnotations$MessageDetails$Type.PARSER : Lcom/google/protobuf/Parser;
      //   98: ldc logs_proto/LogsAnnotations$MessageDetails$Type
      //   100: monitorexit
      //   101: goto -> 110
      //   104: astore_1
      //   105: ldc logs_proto/LogsAnnotations$MessageDetails$Type
      //   107: monitorexit
      //   108: aload_1
      //   109: athrow
      //   110: getstatic logs_proto/LogsAnnotations$MessageDetails$Type.PARSER : Lcom/google/protobuf/Parser;
      //   113: areturn
      //   114: aload_2
      //   115: checkcast com/google/protobuf/CodedInputStream
      //   118: astore_1
      //   119: aload_3
      //   120: checkcast com/google/protobuf/ExtensionRegistryLite
      //   123: astore_2
      //   124: iload #5
      //   126: ifne -> 272
      //   129: aload_1
      //   130: invokevirtual readTag : ()I
      //   133: istore #4
      //   135: iload #4
      //   137: ifeq -> 216
      //   140: iload #4
      //   142: bipush #10
      //   144: if_icmpeq -> 193
      //   147: iload #4
      //   149: bipush #18
      //   151: if_icmpeq -> 170
      //   154: aload_0
      //   155: iload #4
      //   157: aload_1
      //   158: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   161: ifne -> 124
      //   164: iconst_1
      //   165: istore #5
      //   167: goto -> 124
      //   170: aload_1
      //   171: invokevirtual readString : ()Ljava/lang/String;
      //   174: astore_2
      //   175: aload_0
      //   176: aload_0
      //   177: getfield bitField0_ : I
      //   180: iconst_2
      //   181: ior
      //   182: putfield bitField0_ : I
      //   185: aload_0
      //   186: aload_2
      //   187: putfield logType_ : Ljava/lang/String;
      //   190: goto -> 124
      //   193: aload_1
      //   194: invokevirtual readString : ()Ljava/lang/String;
      //   197: astore_2
      //   198: aload_0
      //   199: aload_0
      //   200: getfield bitField0_ : I
      //   203: iconst_1
      //   204: ior
      //   205: putfield bitField0_ : I
      //   208: aload_0
      //   209: aload_2
      //   210: putfield sourceType_ : Ljava/lang/String;
      //   213: goto -> 124
      //   216: iconst_1
      //   217: istore #5
      //   219: goto -> 124
      //   222: astore_1
      //   223: goto -> 270
      //   226: astore_2
      //   227: new java/lang/RuntimeException
      //   230: astore_3
      //   231: new com/google/protobuf/InvalidProtocolBufferException
      //   234: astore_1
      //   235: aload_1
      //   236: aload_2
      //   237: invokevirtual getMessage : ()Ljava/lang/String;
      //   240: invokespecial <init> : (Ljava/lang/String;)V
      //   243: aload_3
      //   244: aload_1
      //   245: aload_0
      //   246: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   249: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   252: aload_3
      //   253: athrow
      //   254: astore_1
      //   255: new java/lang/RuntimeException
      //   258: astore_2
      //   259: aload_2
      //   260: aload_1
      //   261: aload_0
      //   262: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   265: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   268: aload_2
      //   269: athrow
      //   270: aload_1
      //   271: athrow
      //   272: getstatic logs_proto/LogsAnnotations$MessageDetails$Type.DEFAULT_INSTANCE : Llogs_proto/LogsAnnotations$MessageDetails$Type;
      //   275: areturn
      //   276: aload_2
      //   277: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   280: astore_1
      //   281: aload_3
      //   282: checkcast logs_proto/LogsAnnotations$MessageDetails$Type
      //   285: astore_2
      //   286: aload_0
      //   287: aload_1
      //   288: aload_0
      //   289: invokevirtual hasSourceType : ()Z
      //   292: aload_0
      //   293: getfield sourceType_ : Ljava/lang/String;
      //   296: aload_2
      //   297: invokevirtual hasSourceType : ()Z
      //   300: aload_2
      //   301: getfield sourceType_ : Ljava/lang/String;
      //   304: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   309: putfield sourceType_ : Ljava/lang/String;
      //   312: aload_0
      //   313: aload_1
      //   314: aload_0
      //   315: invokevirtual hasLogType : ()Z
      //   318: aload_0
      //   319: getfield logType_ : Ljava/lang/String;
      //   322: aload_2
      //   323: invokevirtual hasLogType : ()Z
      //   326: aload_2
      //   327: getfield logType_ : Ljava/lang/String;
      //   330: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   335: putfield logType_ : Ljava/lang/String;
      //   338: aload_1
      //   339: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   342: if_acmpne -> 358
      //   345: aload_0
      //   346: aload_0
      //   347: getfield bitField0_ : I
      //   350: aload_2
      //   351: getfield bitField0_ : I
      //   354: ior
      //   355: putfield bitField0_ : I
      //   358: aload_0
      //   359: areturn
      //   360: new logs_proto/LogsAnnotations$MessageDetails$Type$Builder
      //   363: dup
      //   364: aconst_null
      //   365: invokespecial <init> : (Llogs_proto/LogsAnnotations$1;)V
      //   368: areturn
      //   369: aconst_null
      //   370: areturn
      //   371: aload_0
      //   372: getfield memoizedIsInitialized : B
      //   375: istore #5
      //   377: iload #5
      //   379: iconst_1
      //   380: if_icmpne -> 387
      //   383: getstatic logs_proto/LogsAnnotations$MessageDetails$Type.DEFAULT_INSTANCE : Llogs_proto/LogsAnnotations$MessageDetails$Type;
      //   386: areturn
      //   387: iload #5
      //   389: ifne -> 394
      //   392: aconst_null
      //   393: areturn
      //   394: aload_2
      //   395: checkcast java/lang/Boolean
      //   398: invokevirtual booleanValue : ()Z
      //   401: istore #6
      //   403: aload_0
      //   404: invokevirtual hasSourceType : ()Z
      //   407: ifne -> 423
      //   410: iload #6
      //   412: ifeq -> 421
      //   415: aload_0
      //   416: iconst_0
      //   417: i2b
      //   418: putfield memoizedIsInitialized : B
      //   421: aconst_null
      //   422: areturn
      //   423: aload_0
      //   424: invokevirtual hasLogType : ()Z
      //   427: ifne -> 443
      //   430: iload #6
      //   432: ifeq -> 441
      //   435: aload_0
      //   436: iconst_0
      //   437: i2b
      //   438: putfield memoizedIsInitialized : B
      //   441: aconst_null
      //   442: areturn
      //   443: iload #6
      //   445: ifeq -> 454
      //   448: aload_0
      //   449: iconst_1
      //   450: i2b
      //   451: putfield memoizedIsInitialized : B
      //   454: getstatic logs_proto/LogsAnnotations$MessageDetails$Type.DEFAULT_INSTANCE : Llogs_proto/LogsAnnotations$MessageDetails$Type;
      //   457: areturn
      //   458: new logs_proto/LogsAnnotations$MessageDetails$Type
      //   461: dup
      //   462: invokespecial <init> : ()V
      //   465: areturn
      // Exception table:
      //   from	to	target	type
      //   77	98	104	finally
      //   98	101	104	finally
      //   105	108	104	finally
      //   129	135	254	com/google/protobuf/InvalidProtocolBufferException
      //   129	135	226	java/io/IOException
      //   129	135	222	finally
      //   154	164	254	com/google/protobuf/InvalidProtocolBufferException
      //   154	164	226	java/io/IOException
      //   154	164	222	finally
      //   170	190	254	com/google/protobuf/InvalidProtocolBufferException
      //   170	190	226	java/io/IOException
      //   170	190	222	finally
      //   193	213	254	com/google/protobuf/InvalidProtocolBufferException
      //   193	213	226	java/io/IOException
      //   193	213	222	finally
      //   227	254	222	finally
      //   255	270	222	finally
    }
    
    public String getLogType() {
      return this.logType_;
    }
    
    public ByteString getLogTypeBytes() {
      return ByteString.copyFromUtf8(this.logType_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if ((this.bitField0_ & 0x1) == 1)
        i = 0 + CodedOutputStream.computeStringSize(1, getSourceType()); 
      int j = i;
      if ((this.bitField0_ & 0x2) == 2)
        j = i + CodedOutputStream.computeStringSize(2, getLogType()); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public String getSourceType() {
      return this.sourceType_;
    }
    
    public ByteString getSourceTypeBytes() {
      return ByteString.copyFromUtf8(this.sourceType_);
    }
    
    public boolean hasLogType() {
      boolean bool;
      if ((this.bitField0_ & 0x2) == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasSourceType() {
      int i = this.bitField0_;
      boolean bool = true;
      if ((i & 0x1) != 1)
        bool = false; 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if ((this.bitField0_ & 0x1) == 1)
        param1CodedOutputStream.writeString(1, getSourceType()); 
      if ((this.bitField0_ & 0x2) == 2)
        param1CodedOutputStream.writeString(2, getLogType()); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Type, Builder> implements LogsAnnotations.MessageDetails.TypeOrBuilder {
      private Builder() {
        super(LogsAnnotations.MessageDetails.Type.DEFAULT_INSTANCE);
      }
      
      public Builder clearLogType() {
        copyOnWrite();
        ((LogsAnnotations.MessageDetails.Type)this.instance).clearLogType();
        return this;
      }
      
      public Builder clearSourceType() {
        copyOnWrite();
        ((LogsAnnotations.MessageDetails.Type)this.instance).clearSourceType();
        return this;
      }
      
      public String getLogType() {
        return ((LogsAnnotations.MessageDetails.Type)this.instance).getLogType();
      }
      
      public ByteString getLogTypeBytes() {
        return ((LogsAnnotations.MessageDetails.Type)this.instance).getLogTypeBytes();
      }
      
      public String getSourceType() {
        return ((LogsAnnotations.MessageDetails.Type)this.instance).getSourceType();
      }
      
      public ByteString getSourceTypeBytes() {
        return ((LogsAnnotations.MessageDetails.Type)this.instance).getSourceTypeBytes();
      }
      
      public boolean hasLogType() {
        return ((LogsAnnotations.MessageDetails.Type)this.instance).hasLogType();
      }
      
      public boolean hasSourceType() {
        return ((LogsAnnotations.MessageDetails.Type)this.instance).hasSourceType();
      }
      
      public Builder setLogType(String param3String) {
        copyOnWrite();
        ((LogsAnnotations.MessageDetails.Type)this.instance).setLogType(param3String);
        return this;
      }
      
      public Builder setLogTypeBytes(ByteString param3ByteString) {
        copyOnWrite();
        ((LogsAnnotations.MessageDetails.Type)this.instance).setLogTypeBytes(param3ByteString);
        return this;
      }
      
      public Builder setSourceType(String param3String) {
        copyOnWrite();
        ((LogsAnnotations.MessageDetails.Type)this.instance).setSourceType(param3String);
        return this;
      }
      
      public Builder setSourceTypeBytes(ByteString param3ByteString) {
        copyOnWrite();
        ((LogsAnnotations.MessageDetails.Type)this.instance).setSourceTypeBytes(param3ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<MessageDetails.Type, MessageDetails.Type.Builder> implements MessageDetails.TypeOrBuilder {
    private Builder() {
      super(LogsAnnotations.MessageDetails.Type.DEFAULT_INSTANCE);
    }
    
    public Builder clearLogType() {
      copyOnWrite();
      ((LogsAnnotations.MessageDetails.Type)this.instance).clearLogType();
      return this;
    }
    
    public Builder clearSourceType() {
      copyOnWrite();
      ((LogsAnnotations.MessageDetails.Type)this.instance).clearSourceType();
      return this;
    }
    
    public String getLogType() {
      return ((LogsAnnotations.MessageDetails.Type)this.instance).getLogType();
    }
    
    public ByteString getLogTypeBytes() {
      return ((LogsAnnotations.MessageDetails.Type)this.instance).getLogTypeBytes();
    }
    
    public String getSourceType() {
      return ((LogsAnnotations.MessageDetails.Type)this.instance).getSourceType();
    }
    
    public ByteString getSourceTypeBytes() {
      return ((LogsAnnotations.MessageDetails.Type)this.instance).getSourceTypeBytes();
    }
    
    public boolean hasLogType() {
      return ((LogsAnnotations.MessageDetails.Type)this.instance).hasLogType();
    }
    
    public boolean hasSourceType() {
      return ((LogsAnnotations.MessageDetails.Type)this.instance).hasSourceType();
    }
    
    public Builder setLogType(String param1String) {
      copyOnWrite();
      ((LogsAnnotations.MessageDetails.Type)this.instance).setLogType(param1String);
      return this;
    }
    
    public Builder setLogTypeBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((LogsAnnotations.MessageDetails.Type)this.instance).setLogTypeBytes(param1ByteString);
      return this;
    }
    
    public Builder setSourceType(String param1String) {
      copyOnWrite();
      ((LogsAnnotations.MessageDetails.Type)this.instance).setSourceType(param1String);
      return this;
    }
    
    public Builder setSourceTypeBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((LogsAnnotations.MessageDetails.Type)this.instance).setSourceTypeBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface TypeOrBuilder extends MessageLiteOrBuilder {
    String getLogType();
    
    ByteString getLogTypeBytes();
    
    String getSourceType();
    
    ByteString getSourceTypeBytes();
    
    boolean hasLogType();
    
    boolean hasSourceType();
  }
  
  public static interface MessageDetailsOrBuilder extends MessageLiteOrBuilder {
    LogsAnnotations.MessageDetails.Type getMayAppearIn(int param1Int);
    
    int getMayAppearInCount();
    
    List<LogsAnnotations.MessageDetails.Type> getMayAppearInList();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\logs_proto\LogsAnnotations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */