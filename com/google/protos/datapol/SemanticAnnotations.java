package com.google.protos.datapol;

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
import java.util.List;

public final class SemanticAnnotations {
  public static final int DATA_FORMAT_FIELD_NUMBER = 40221563;
  
  public static final int FIELD_DETAILS_FIELD_NUMBER = 40093572;
  
  public static final int FILE_VETTED_FOR_DATAPOL_ANNOTATIONS_FIELD_NUMBER = 43601160;
  
  public static final int FILE_VETTING_STATUS_FIELD_NUMBER = 71304954;
  
  public static final int LOCATION_QUALIFIER_FIELD_NUMBER = 69646961;
  
  public static final int MSG_DETAILS_FIELD_NUMBER = 41744383;
  
  public static final int MSG_LOCATION_QUALIFIER_FIELD_NUMBER = 69646961;
  
  public static final int MSG_QUALIFIER_FIELD_NUMBER = 41551199;
  
  public static final int MSG_RETENTION_FIELD_NUMBER = 41909987;
  
  public static final int MSG_SEMANTIC_TYPE_FIELD_NUMBER = 41149386;
  
  public static final int QUALIFIER_FIELD_NUMBER = 40270992;
  
  public static final int RETENTION_FIELD_NUMBER = 40223876;
  
  public static final int SEMANTIC_TYPE_FIELD_NUMBER = 40075780;
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, DataFormat> dataFormat;
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, FieldDetails> fieldDetails;
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FileOptions, Boolean> fileVettedForDatapolAnnotations;
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FileOptions, String> fileVettingStatus;
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, LocationQualifier> locationQualifier;
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.MessageOptions, MessageDetails> msgDetails;
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.MessageOptions, LocationQualifier> msgLocationQualifier;
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.MessageOptions, Qualifier> msgQualifier;
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.MessageOptions, List<RetentionAnnotations.RetentionSpec>> msgRetention;
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.MessageOptions, SemanticType> msgSemanticType;
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, Qualifier> qualifier;
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, List<RetentionAnnotations.RetentionSpec>> retention;
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, SemanticType> semanticType = GeneratedMessageLite.newSingularGeneratedExtension((MessageLite)DescriptorProtos.FieldOptions.getDefaultInstance(), SemanticType.ST_NOT_SPECIFIED, null, SemanticType.internalGetValueMap(), 40075780, WireFormat.FieldType.ENUM, SemanticType.class);
  
  static {
    qualifier = GeneratedMessageLite.newSingularGeneratedExtension((MessageLite)DescriptorProtos.FieldOptions.getDefaultInstance(), Qualifier.getDefaultInstance(), (MessageLite)Qualifier.getDefaultInstance(), null, 40270992, WireFormat.FieldType.MESSAGE, Qualifier.class);
    locationQualifier = GeneratedMessageLite.newSingularGeneratedExtension((MessageLite)DescriptorProtos.FieldOptions.getDefaultInstance(), LocationQualifier.getDefaultInstance(), (MessageLite)LocationQualifier.getDefaultInstance(), null, 69646961, WireFormat.FieldType.MESSAGE, LocationQualifier.class);
    fieldDetails = GeneratedMessageLite.newSingularGeneratedExtension((MessageLite)DescriptorProtos.FieldOptions.getDefaultInstance(), FieldDetails.getDefaultInstance(), (MessageLite)FieldDetails.getDefaultInstance(), null, 40093572, WireFormat.FieldType.MESSAGE, FieldDetails.class);
    dataFormat = GeneratedMessageLite.newSingularGeneratedExtension((MessageLite)DescriptorProtos.FieldOptions.getDefaultInstance(), DataFormat.DF_NONE, null, DataFormat.internalGetValueMap(), 40221563, WireFormat.FieldType.ENUM, DataFormat.class);
    retention = GeneratedMessageLite.newRepeatedGeneratedExtension((MessageLite)DescriptorProtos.FieldOptions.getDefaultInstance(), (MessageLite)RetentionAnnotations.RetentionSpec.getDefaultInstance(), null, 40223876, WireFormat.FieldType.MESSAGE, false, RetentionAnnotations.RetentionSpec.class);
    msgSemanticType = GeneratedMessageLite.newSingularGeneratedExtension((MessageLite)DescriptorProtos.MessageOptions.getDefaultInstance(), SemanticType.ST_NOT_SPECIFIED, null, SemanticType.internalGetValueMap(), 41149386, WireFormat.FieldType.ENUM, SemanticType.class);
    msgQualifier = GeneratedMessageLite.newSingularGeneratedExtension((MessageLite)DescriptorProtos.MessageOptions.getDefaultInstance(), Qualifier.getDefaultInstance(), (MessageLite)Qualifier.getDefaultInstance(), null, 41551199, WireFormat.FieldType.MESSAGE, Qualifier.class);
    msgLocationQualifier = GeneratedMessageLite.newSingularGeneratedExtension((MessageLite)DescriptorProtos.MessageOptions.getDefaultInstance(), LocationQualifier.getDefaultInstance(), (MessageLite)LocationQualifier.getDefaultInstance(), null, 69646961, WireFormat.FieldType.MESSAGE, LocationQualifier.class);
    msgDetails = GeneratedMessageLite.newSingularGeneratedExtension((MessageLite)DescriptorProtos.MessageOptions.getDefaultInstance(), MessageDetails.getDefaultInstance(), (MessageLite)MessageDetails.getDefaultInstance(), null, 41744383, WireFormat.FieldType.MESSAGE, MessageDetails.class);
    msgRetention = GeneratedMessageLite.newRepeatedGeneratedExtension((MessageLite)DescriptorProtos.MessageOptions.getDefaultInstance(), (MessageLite)RetentionAnnotations.RetentionSpec.getDefaultInstance(), null, 41909987, WireFormat.FieldType.MESSAGE, false, RetentionAnnotations.RetentionSpec.class);
    fileVettedForDatapolAnnotations = GeneratedMessageLite.newSingularGeneratedExtension((MessageLite)DescriptorProtos.FileOptions.getDefaultInstance(), Boolean.valueOf(false), null, null, 43601160, WireFormat.FieldType.BOOL, Boolean.class);
    fileVettingStatus = GeneratedMessageLite.newSingularGeneratedExtension((MessageLite)DescriptorProtos.FileOptions.getDefaultInstance(), "", null, null, 71304954, WireFormat.FieldType.STRING, String.class);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {
    paramExtensionRegistryLite.add(semanticType);
    paramExtensionRegistryLite.add(qualifier);
    paramExtensionRegistryLite.add(locationQualifier);
    paramExtensionRegistryLite.add(fieldDetails);
    paramExtensionRegistryLite.add(dataFormat);
    paramExtensionRegistryLite.add(retention);
    paramExtensionRegistryLite.add(msgSemanticType);
    paramExtensionRegistryLite.add(msgQualifier);
    paramExtensionRegistryLite.add(msgLocationQualifier);
    paramExtensionRegistryLite.add(msgDetails);
    paramExtensionRegistryLite.add(msgRetention);
    paramExtensionRegistryLite.add(fileVettedForDatapolAnnotations);
    paramExtensionRegistryLite.add(fileVettingStatus);
  }
  
  public enum DataFormat implements Internal.EnumLite {
    DF_BYTE_SWAPPED,
    DF_CGI_ARGS,
    DF_COOKIE,
    DF_HOST_ORDER,
    DF_HTTPHEADER,
    DF_LOGGING_ELEMENT_TYPE_ID,
    DF_NONE(0),
    DF_URL(0);
    
    public static final int DF_BYTE_SWAPPED_VALUE = 6;
    
    public static final int DF_CGI_ARGS_VALUE = 4;
    
    public static final int DF_COOKIE_VALUE = 2;
    
    public static final int DF_HOST_ORDER_VALUE = 5;
    
    public static final int DF_HTTPHEADER_VALUE = 1;
    
    public static final int DF_LOGGING_ELEMENT_TYPE_ID_VALUE = 7;
    
    public static final int DF_NONE_VALUE = 0;
    
    public static final int DF_URL_VALUE = 3;
    
    private static final Internal.EnumLiteMap<DataFormat> internalValueMap;
    
    private final int value;
    
    static {
      DF_COOKIE = new DataFormat("DF_COOKIE", 2, 2);
      DF_URL = new DataFormat("DF_URL", 3, 3);
      DF_CGI_ARGS = new DataFormat("DF_CGI_ARGS", 4, 4);
      DF_HOST_ORDER = new DataFormat("DF_HOST_ORDER", 5, 5);
      DF_BYTE_SWAPPED = new DataFormat("DF_BYTE_SWAPPED", 6, 6);
      DF_LOGGING_ELEMENT_TYPE_ID = new DataFormat("DF_LOGGING_ELEMENT_TYPE_ID", 7, 7);
      $VALUES = new DataFormat[] { DF_NONE, DF_HTTPHEADER, DF_COOKIE, DF_URL, DF_CGI_ARGS, DF_HOST_ORDER, DF_BYTE_SWAPPED, DF_LOGGING_ELEMENT_TYPE_ID };
      internalValueMap = new Internal.EnumLiteMap<DataFormat>() {
          public SemanticAnnotations.DataFormat findValueByNumber(int param2Int) {
            return SemanticAnnotations.DataFormat.forNumber(param2Int);
          }
        };
    }
    
    DataFormat(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static DataFormat forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 7:
          return DF_LOGGING_ELEMENT_TYPE_ID;
        case 6:
          return DF_BYTE_SWAPPED;
        case 5:
          return DF_HOST_ORDER;
        case 4:
          return DF_CGI_ARGS;
        case 3:
          return DF_URL;
        case 2:
          return DF_COOKIE;
        case 1:
          return DF_HTTPHEADER;
        case 0:
          break;
      } 
      return DF_NONE;
    }
    
    public static Internal.EnumLiteMap<DataFormat> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<DataFormat> {
    public SemanticAnnotations.DataFormat findValueByNumber(int param1Int) {
      return SemanticAnnotations.DataFormat.forNumber(param1Int);
    }
  }
  
  public static final class FieldDetails extends GeneratedMessageLite<FieldDetails, FieldDetails.Builder> implements FieldDetailsOrBuilder {
    private static final FieldDetails DEFAULT_INSTANCE = new FieldDetails();
    
    private static volatile Parser<FieldDetails> PARSER;
    
    public static final int SEMANTIC_TYPE_FIELD_NUMBER = 1;
    
    private static final Internal.ListAdapter.Converter<Integer, SemanticAnnotations.SemanticType> semanticType_converter_ = new Internal.ListAdapter.Converter<Integer, SemanticAnnotations.SemanticType>() {
        public SemanticAnnotations.SemanticType convert(Integer param2Integer) {
          SemanticAnnotations.SemanticType semanticType2 = SemanticAnnotations.SemanticType.forNumber(param2Integer.intValue());
          SemanticAnnotations.SemanticType semanticType1 = semanticType2;
          if (semanticType2 == null)
            semanticType1 = SemanticAnnotations.SemanticType.ST_NOT_SPECIFIED; 
          return semanticType1;
        }
      };
    
    private Internal.IntList semanticType_ = emptyIntList();
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllSemanticType(Iterable<? extends SemanticAnnotations.SemanticType> param1Iterable) {
      ensureSemanticTypeIsMutable();
      for (SemanticAnnotations.SemanticType semanticType : param1Iterable)
        this.semanticType_.addInt(semanticType.getNumber()); 
    }
    
    private void addSemanticType(SemanticAnnotations.SemanticType param1SemanticType) {
      if (param1SemanticType != null) {
        ensureSemanticTypeIsMutable();
        this.semanticType_.addInt(param1SemanticType.getNumber());
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearSemanticType() {
      this.semanticType_ = emptyIntList();
    }
    
    private void ensureSemanticTypeIsMutable() {
      if (!this.semanticType_.isModifiable())
        this.semanticType_ = GeneratedMessageLite.mutableCopy(this.semanticType_); 
    }
    
    public static FieldDetails getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(FieldDetails param1FieldDetails) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1FieldDetails);
    }
    
    public static FieldDetails parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (FieldDetails)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static FieldDetails parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FieldDetails)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FieldDetails parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (FieldDetails)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static FieldDetails parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FieldDetails)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static FieldDetails parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (FieldDetails)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static FieldDetails parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FieldDetails)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static FieldDetails parseFrom(InputStream param1InputStream) throws IOException {
      return (FieldDetails)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static FieldDetails parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FieldDetails)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FieldDetails parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (FieldDetails)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static FieldDetails parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FieldDetails)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<FieldDetails> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setSemanticType(int param1Int, SemanticAnnotations.SemanticType param1SemanticType) {
      if (param1SemanticType != null) {
        ensureSemanticTypeIsMutable();
        this.semanticType_.setInt(param1Int, param1SemanticType.getNumber());
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/protos/datapol/SemanticAnnotations$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 435, 2 -> 431, 3 -> 420, 4 -> 411, 5 -> 377, 6 -> 110, 7 -> 373, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/protos/datapol/SemanticAnnotations$FieldDetails.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/protos/datapol/SemanticAnnotations$FieldDetails
      //   72: monitorenter
      //   73: getstatic com/google/protos/datapol/SemanticAnnotations$FieldDetails.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/protos/datapol/SemanticAnnotations$FieldDetails.DEFAULT_INSTANCE : Lcom/google/protos/datapol/SemanticAnnotations$FieldDetails;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/protos/datapol/SemanticAnnotations$FieldDetails.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/protos/datapol/SemanticAnnotations$FieldDetails
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/protos/datapol/SemanticAnnotations$FieldDetails
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/protos/datapol/SemanticAnnotations$FieldDetails.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 373
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 317
      //   139: iload #5
      //   141: bipush #8
      //   143: if_icmpeq -> 256
      //   146: iload #5
      //   148: bipush #10
      //   150: if_icmpeq -> 169
      //   153: aload_0
      //   154: iload #5
      //   156: aload_1
      //   157: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   160: ifne -> 123
      //   163: iconst_1
      //   164: istore #4
      //   166: goto -> 123
      //   169: aload_0
      //   170: getfield semanticType_ : Lcom/google/protobuf/Internal$IntList;
      //   173: invokeinterface isModifiable : ()Z
      //   178: ifne -> 192
      //   181: aload_0
      //   182: aload_0
      //   183: getfield semanticType_ : Lcom/google/protobuf/Internal$IntList;
      //   186: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$IntList;)Lcom/google/protobuf/Internal$IntList;
      //   189: putfield semanticType_ : Lcom/google/protobuf/Internal$IntList;
      //   192: aload_1
      //   193: aload_1
      //   194: invokevirtual readRawVarint32 : ()I
      //   197: invokevirtual pushLimit : (I)I
      //   200: istore #5
      //   202: aload_1
      //   203: invokevirtual getBytesUntilLimit : ()I
      //   206: ifle -> 247
      //   209: aload_1
      //   210: invokevirtual readEnum : ()I
      //   213: istore #6
      //   215: iload #6
      //   217: invokestatic forNumber : (I)Lcom/google/protos/datapol/SemanticAnnotations$SemanticType;
      //   220: ifnonnull -> 233
      //   223: aload_0
      //   224: iconst_1
      //   225: iload #6
      //   227: invokespecial mergeVarintField : (II)V
      //   230: goto -> 202
      //   233: aload_0
      //   234: getfield semanticType_ : Lcom/google/protobuf/Internal$IntList;
      //   237: iload #6
      //   239: invokeinterface addInt : (I)V
      //   244: goto -> 202
      //   247: aload_1
      //   248: iload #5
      //   250: invokevirtual popLimit : (I)V
      //   253: goto -> 123
      //   256: aload_0
      //   257: getfield semanticType_ : Lcom/google/protobuf/Internal$IntList;
      //   260: invokeinterface isModifiable : ()Z
      //   265: ifne -> 279
      //   268: aload_0
      //   269: aload_0
      //   270: getfield semanticType_ : Lcom/google/protobuf/Internal$IntList;
      //   273: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$IntList;)Lcom/google/protobuf/Internal$IntList;
      //   276: putfield semanticType_ : Lcom/google/protobuf/Internal$IntList;
      //   279: aload_1
      //   280: invokevirtual readEnum : ()I
      //   283: istore #5
      //   285: iload #5
      //   287: invokestatic forNumber : (I)Lcom/google/protos/datapol/SemanticAnnotations$SemanticType;
      //   290: ifnonnull -> 303
      //   293: aload_0
      //   294: iconst_1
      //   295: iload #5
      //   297: invokespecial mergeVarintField : (II)V
      //   300: goto -> 123
      //   303: aload_0
      //   304: getfield semanticType_ : Lcom/google/protobuf/Internal$IntList;
      //   307: iload #5
      //   309: invokeinterface addInt : (I)V
      //   314: goto -> 123
      //   317: iconst_1
      //   318: istore #4
      //   320: goto -> 123
      //   323: astore_1
      //   324: goto -> 371
      //   327: astore_1
      //   328: new java/lang/RuntimeException
      //   331: astore_3
      //   332: new com/google/protobuf/InvalidProtocolBufferException
      //   335: astore_2
      //   336: aload_2
      //   337: aload_1
      //   338: invokevirtual getMessage : ()Ljava/lang/String;
      //   341: invokespecial <init> : (Ljava/lang/String;)V
      //   344: aload_3
      //   345: aload_2
      //   346: aload_0
      //   347: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   350: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   353: aload_3
      //   354: athrow
      //   355: astore_2
      //   356: new java/lang/RuntimeException
      //   359: astore_1
      //   360: aload_1
      //   361: aload_2
      //   362: aload_0
      //   363: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   366: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   369: aload_1
      //   370: athrow
      //   371: aload_1
      //   372: athrow
      //   373: getstatic com/google/protos/datapol/SemanticAnnotations$FieldDetails.DEFAULT_INSTANCE : Lcom/google/protos/datapol/SemanticAnnotations$FieldDetails;
      //   376: areturn
      //   377: aload_2
      //   378: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   381: astore_1
      //   382: aload_3
      //   383: checkcast com/google/protos/datapol/SemanticAnnotations$FieldDetails
      //   386: astore_2
      //   387: aload_0
      //   388: aload_1
      //   389: aload_0
      //   390: getfield semanticType_ : Lcom/google/protobuf/Internal$IntList;
      //   393: aload_2
      //   394: getfield semanticType_ : Lcom/google/protobuf/Internal$IntList;
      //   397: invokeinterface visitIntList : (Lcom/google/protobuf/Internal$IntList;Lcom/google/protobuf/Internal$IntList;)Lcom/google/protobuf/Internal$IntList;
      //   402: putfield semanticType_ : Lcom/google/protobuf/Internal$IntList;
      //   405: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   408: astore_1
      //   409: aload_0
      //   410: areturn
      //   411: new com/google/protos/datapol/SemanticAnnotations$FieldDetails$Builder
      //   414: dup
      //   415: aconst_null
      //   416: invokespecial <init> : (Lcom/google/protos/datapol/SemanticAnnotations$1;)V
      //   419: areturn
      //   420: aload_0
      //   421: getfield semanticType_ : Lcom/google/protobuf/Internal$IntList;
      //   424: invokeinterface makeImmutable : ()V
      //   429: aconst_null
      //   430: areturn
      //   431: getstatic com/google/protos/datapol/SemanticAnnotations$FieldDetails.DEFAULT_INSTANCE : Lcom/google/protos/datapol/SemanticAnnotations$FieldDetails;
      //   434: areturn
      //   435: new com/google/protos/datapol/SemanticAnnotations$FieldDetails
      //   438: dup
      //   439: invokespecial <init> : ()V
      //   442: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	355	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	327	java/io/IOException
      //   128	134	323	finally
      //   153	163	355	com/google/protobuf/InvalidProtocolBufferException
      //   153	163	327	java/io/IOException
      //   153	163	323	finally
      //   169	192	355	com/google/protobuf/InvalidProtocolBufferException
      //   169	192	327	java/io/IOException
      //   169	192	323	finally
      //   192	202	355	com/google/protobuf/InvalidProtocolBufferException
      //   192	202	327	java/io/IOException
      //   192	202	323	finally
      //   202	230	355	com/google/protobuf/InvalidProtocolBufferException
      //   202	230	327	java/io/IOException
      //   202	230	323	finally
      //   233	244	355	com/google/protobuf/InvalidProtocolBufferException
      //   233	244	327	java/io/IOException
      //   233	244	323	finally
      //   247	253	355	com/google/protobuf/InvalidProtocolBufferException
      //   247	253	327	java/io/IOException
      //   247	253	323	finally
      //   256	279	355	com/google/protobuf/InvalidProtocolBufferException
      //   256	279	327	java/io/IOException
      //   256	279	323	finally
      //   279	300	355	com/google/protobuf/InvalidProtocolBufferException
      //   279	300	327	java/io/IOException
      //   279	300	323	finally
      //   303	314	355	com/google/protobuf/InvalidProtocolBufferException
      //   303	314	327	java/io/IOException
      //   303	314	323	finally
      //   328	355	323	finally
      //   356	371	323	finally
    }
    
    public SemanticAnnotations.SemanticType getSemanticType(int param1Int) {
      return (SemanticAnnotations.SemanticType)semanticType_converter_.convert(Integer.valueOf(this.semanticType_.getInt(param1Int)));
    }
    
    public int getSemanticTypeCount() {
      return this.semanticType_.size();
    }
    
    public List<SemanticAnnotations.SemanticType> getSemanticTypeList() {
      return (List<SemanticAnnotations.SemanticType>)new Internal.ListAdapter((List)this.semanticType_, semanticType_converter_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      byte b = 0;
      i = 0;
      while (b < this.semanticType_.size()) {
        i += CodedOutputStream.computeEnumSizeNoTag(this.semanticType_.getInt(b));
        b++;
      } 
      i = 0 + i + this.semanticType_.size() * 1 + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      for (byte b = 0; b < this.semanticType_.size(); b++)
        param1CodedOutputStream.writeEnum(1, this.semanticType_.getInt(b)); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<FieldDetails, Builder> implements SemanticAnnotations.FieldDetailsOrBuilder {
      private Builder() {
        super(SemanticAnnotations.FieldDetails.DEFAULT_INSTANCE);
      }
      
      public Builder addAllSemanticType(Iterable<? extends SemanticAnnotations.SemanticType> param2Iterable) {
        copyOnWrite();
        ((SemanticAnnotations.FieldDetails)this.instance).addAllSemanticType(param2Iterable);
        return this;
      }
      
      public Builder addSemanticType(SemanticAnnotations.SemanticType param2SemanticType) {
        copyOnWrite();
        ((SemanticAnnotations.FieldDetails)this.instance).addSemanticType(param2SemanticType);
        return this;
      }
      
      public Builder clearSemanticType() {
        copyOnWrite();
        ((SemanticAnnotations.FieldDetails)this.instance).clearSemanticType();
        return this;
      }
      
      public SemanticAnnotations.SemanticType getSemanticType(int param2Int) {
        return ((SemanticAnnotations.FieldDetails)this.instance).getSemanticType(param2Int);
      }
      
      public int getSemanticTypeCount() {
        return ((SemanticAnnotations.FieldDetails)this.instance).getSemanticTypeCount();
      }
      
      public List<SemanticAnnotations.SemanticType> getSemanticTypeList() {
        return ((SemanticAnnotations.FieldDetails)this.instance).getSemanticTypeList();
      }
      
      public Builder setSemanticType(int param2Int, SemanticAnnotations.SemanticType param2SemanticType) {
        copyOnWrite();
        ((SemanticAnnotations.FieldDetails)this.instance).setSemanticType(param2Int, param2SemanticType);
        return this;
      }
    }
  }
  
  class null implements Internal.ListAdapter.Converter<Integer, SemanticType> {
    public SemanticAnnotations.SemanticType convert(Integer param1Integer) {
      SemanticAnnotations.SemanticType semanticType2 = SemanticAnnotations.SemanticType.forNumber(param1Integer.intValue());
      SemanticAnnotations.SemanticType semanticType1 = semanticType2;
      if (semanticType2 == null)
        semanticType1 = SemanticAnnotations.SemanticType.ST_NOT_SPECIFIED; 
      return semanticType1;
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<FieldDetails, FieldDetails.Builder> implements FieldDetailsOrBuilder {
    private Builder() {
      super(SemanticAnnotations.FieldDetails.DEFAULT_INSTANCE);
    }
    
    public Builder addAllSemanticType(Iterable<? extends SemanticAnnotations.SemanticType> param1Iterable) {
      copyOnWrite();
      ((SemanticAnnotations.FieldDetails)this.instance).addAllSemanticType(param1Iterable);
      return this;
    }
    
    public Builder addSemanticType(SemanticAnnotations.SemanticType param1SemanticType) {
      copyOnWrite();
      ((SemanticAnnotations.FieldDetails)this.instance).addSemanticType(param1SemanticType);
      return this;
    }
    
    public Builder clearSemanticType() {
      copyOnWrite();
      ((SemanticAnnotations.FieldDetails)this.instance).clearSemanticType();
      return this;
    }
    
    public SemanticAnnotations.SemanticType getSemanticType(int param1Int) {
      return ((SemanticAnnotations.FieldDetails)this.instance).getSemanticType(param1Int);
    }
    
    public int getSemanticTypeCount() {
      return ((SemanticAnnotations.FieldDetails)this.instance).getSemanticTypeCount();
    }
    
    public List<SemanticAnnotations.SemanticType> getSemanticTypeList() {
      return ((SemanticAnnotations.FieldDetails)this.instance).getSemanticTypeList();
    }
    
    public Builder setSemanticType(int param1Int, SemanticAnnotations.SemanticType param1SemanticType) {
      copyOnWrite();
      ((SemanticAnnotations.FieldDetails)this.instance).setSemanticType(param1Int, param1SemanticType);
      return this;
    }
  }
  
  public static interface FieldDetailsOrBuilder extends MessageLiteOrBuilder {
    SemanticAnnotations.SemanticType getSemanticType(int param1Int);
    
    int getSemanticTypeCount();
    
    List<SemanticAnnotations.SemanticType> getSemanticTypeList();
  }
  
  public static final class LocationQualifier extends GeneratedMessageLite<LocationQualifier, LocationQualifier.Builder> implements LocationQualifierOrBuilder {
    private static final LocationQualifier DEFAULT_INSTANCE = new LocationQualifier();
    
    public static final int NON_USER_LOCATION_FIELD_NUMBER = 1;
    
    private static volatile Parser<LocationQualifier> PARSER;
    
    public static final int PRECISE_LOCATION_FIELD_NUMBER = 2;
    
    private int bitField0_;
    
    private boolean nonUserLocation_;
    
    private boolean preciseLocation_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearNonUserLocation() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.nonUserLocation_ = false;
    }
    
    private void clearPreciseLocation() {
      this.bitField0_ &= 0xFFFFFFFD;
      this.preciseLocation_ = false;
    }
    
    public static LocationQualifier getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(LocationQualifier param1LocationQualifier) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1LocationQualifier);
    }
    
    public static LocationQualifier parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (LocationQualifier)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static LocationQualifier parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LocationQualifier)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LocationQualifier parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (LocationQualifier)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static LocationQualifier parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LocationQualifier)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static LocationQualifier parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (LocationQualifier)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static LocationQualifier parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LocationQualifier)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static LocationQualifier parseFrom(InputStream param1InputStream) throws IOException {
      return (LocationQualifier)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static LocationQualifier parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LocationQualifier)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LocationQualifier parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (LocationQualifier)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static LocationQualifier parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LocationQualifier)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<LocationQualifier> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setNonUserLocation(boolean param1Boolean) {
      this.bitField0_ |= 0x1;
      this.nonUserLocation_ = param1Boolean;
    }
    
    private void setPreciseLocation(boolean param1Boolean) {
      this.bitField0_ |= 0x2;
      this.preciseLocation_ = param1Boolean;
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/protos/datapol/SemanticAnnotations$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 370, 2 -> 366, 3 -> 364, 4 -> 355, 5 -> 271, 6 -> 110, 7 -> 267, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/protos/datapol/SemanticAnnotations$LocationQualifier.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/protos/datapol/SemanticAnnotations$LocationQualifier
      //   72: monitorenter
      //   73: getstatic com/google/protos/datapol/SemanticAnnotations$LocationQualifier.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/protos/datapol/SemanticAnnotations$LocationQualifier.DEFAULT_INSTANCE : Lcom/google/protos/datapol/SemanticAnnotations$LocationQualifier;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/protos/datapol/SemanticAnnotations$LocationQualifier.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/protos/datapol/SemanticAnnotations$LocationQualifier
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/protos/datapol/SemanticAnnotations$LocationQualifier
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/protos/datapol/SemanticAnnotations$LocationQualifier.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 267
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 211
      //   139: iload #5
      //   141: bipush #8
      //   143: if_icmpeq -> 190
      //   146: iload #5
      //   148: bipush #16
      //   150: if_icmpeq -> 169
      //   153: aload_0
      //   154: iload #5
      //   156: aload_1
      //   157: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   160: ifne -> 123
      //   163: iconst_1
      //   164: istore #4
      //   166: goto -> 123
      //   169: aload_0
      //   170: aload_0
      //   171: getfield bitField0_ : I
      //   174: iconst_2
      //   175: ior
      //   176: putfield bitField0_ : I
      //   179: aload_0
      //   180: aload_1
      //   181: invokevirtual readBool : ()Z
      //   184: putfield preciseLocation_ : Z
      //   187: goto -> 123
      //   190: aload_0
      //   191: aload_0
      //   192: getfield bitField0_ : I
      //   195: iconst_1
      //   196: ior
      //   197: putfield bitField0_ : I
      //   200: aload_0
      //   201: aload_1
      //   202: invokevirtual readBool : ()Z
      //   205: putfield nonUserLocation_ : Z
      //   208: goto -> 123
      //   211: iconst_1
      //   212: istore #4
      //   214: goto -> 123
      //   217: astore_1
      //   218: goto -> 265
      //   221: astore_3
      //   222: new java/lang/RuntimeException
      //   225: astore_2
      //   226: new com/google/protobuf/InvalidProtocolBufferException
      //   229: astore_1
      //   230: aload_1
      //   231: aload_3
      //   232: invokevirtual getMessage : ()Ljava/lang/String;
      //   235: invokespecial <init> : (Ljava/lang/String;)V
      //   238: aload_2
      //   239: aload_1
      //   240: aload_0
      //   241: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   244: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   247: aload_2
      //   248: athrow
      //   249: astore_1
      //   250: new java/lang/RuntimeException
      //   253: astore_2
      //   254: aload_2
      //   255: aload_1
      //   256: aload_0
      //   257: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   260: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   263: aload_2
      //   264: athrow
      //   265: aload_1
      //   266: athrow
      //   267: getstatic com/google/protos/datapol/SemanticAnnotations$LocationQualifier.DEFAULT_INSTANCE : Lcom/google/protos/datapol/SemanticAnnotations$LocationQualifier;
      //   270: areturn
      //   271: aload_2
      //   272: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   275: astore_1
      //   276: aload_3
      //   277: checkcast com/google/protos/datapol/SemanticAnnotations$LocationQualifier
      //   280: astore_2
      //   281: aload_0
      //   282: aload_1
      //   283: aload_0
      //   284: invokevirtual hasNonUserLocation : ()Z
      //   287: aload_0
      //   288: getfield nonUserLocation_ : Z
      //   291: aload_2
      //   292: invokevirtual hasNonUserLocation : ()Z
      //   295: aload_2
      //   296: getfield nonUserLocation_ : Z
      //   299: invokeinterface visitBoolean : (ZZZZ)Z
      //   304: putfield nonUserLocation_ : Z
      //   307: aload_0
      //   308: aload_1
      //   309: aload_0
      //   310: invokevirtual hasPreciseLocation : ()Z
      //   313: aload_0
      //   314: getfield preciseLocation_ : Z
      //   317: aload_2
      //   318: invokevirtual hasPreciseLocation : ()Z
      //   321: aload_2
      //   322: getfield preciseLocation_ : Z
      //   325: invokeinterface visitBoolean : (ZZZZ)Z
      //   330: putfield preciseLocation_ : Z
      //   333: aload_1
      //   334: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   337: if_acmpne -> 353
      //   340: aload_0
      //   341: aload_0
      //   342: getfield bitField0_ : I
      //   345: aload_2
      //   346: getfield bitField0_ : I
      //   349: ior
      //   350: putfield bitField0_ : I
      //   353: aload_0
      //   354: areturn
      //   355: new com/google/protos/datapol/SemanticAnnotations$LocationQualifier$Builder
      //   358: dup
      //   359: aconst_null
      //   360: invokespecial <init> : (Lcom/google/protos/datapol/SemanticAnnotations$1;)V
      //   363: areturn
      //   364: aconst_null
      //   365: areturn
      //   366: getstatic com/google/protos/datapol/SemanticAnnotations$LocationQualifier.DEFAULT_INSTANCE : Lcom/google/protos/datapol/SemanticAnnotations$LocationQualifier;
      //   369: areturn
      //   370: new com/google/protos/datapol/SemanticAnnotations$LocationQualifier
      //   373: dup
      //   374: invokespecial <init> : ()V
      //   377: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	249	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	221	java/io/IOException
      //   128	134	217	finally
      //   153	163	249	com/google/protobuf/InvalidProtocolBufferException
      //   153	163	221	java/io/IOException
      //   153	163	217	finally
      //   169	187	249	com/google/protobuf/InvalidProtocolBufferException
      //   169	187	221	java/io/IOException
      //   169	187	217	finally
      //   190	208	249	com/google/protobuf/InvalidProtocolBufferException
      //   190	208	221	java/io/IOException
      //   190	208	217	finally
      //   222	249	217	finally
      //   250	265	217	finally
    }
    
    public boolean getNonUserLocation() {
      return this.nonUserLocation_;
    }
    
    public boolean getPreciseLocation() {
      return this.preciseLocation_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if ((this.bitField0_ & 0x1) == 1)
        i = 0 + CodedOutputStream.computeBoolSize(1, this.nonUserLocation_); 
      int j = i;
      if ((this.bitField0_ & 0x2) == 2)
        j = i + CodedOutputStream.computeBoolSize(2, this.preciseLocation_); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasNonUserLocation() {
      int i = this.bitField0_;
      boolean bool = true;
      if ((i & 0x1) != 1)
        bool = false; 
      return bool;
    }
    
    public boolean hasPreciseLocation() {
      boolean bool;
      if ((this.bitField0_ & 0x2) == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if ((this.bitField0_ & 0x1) == 1)
        param1CodedOutputStream.writeBool(1, this.nonUserLocation_); 
      if ((this.bitField0_ & 0x2) == 2)
        param1CodedOutputStream.writeBool(2, this.preciseLocation_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<LocationQualifier, Builder> implements SemanticAnnotations.LocationQualifierOrBuilder {
      private Builder() {
        super(SemanticAnnotations.LocationQualifier.DEFAULT_INSTANCE);
      }
      
      public Builder clearNonUserLocation() {
        copyOnWrite();
        ((SemanticAnnotations.LocationQualifier)this.instance).clearNonUserLocation();
        return this;
      }
      
      public Builder clearPreciseLocation() {
        copyOnWrite();
        ((SemanticAnnotations.LocationQualifier)this.instance).clearPreciseLocation();
        return this;
      }
      
      public boolean getNonUserLocation() {
        return ((SemanticAnnotations.LocationQualifier)this.instance).getNonUserLocation();
      }
      
      public boolean getPreciseLocation() {
        return ((SemanticAnnotations.LocationQualifier)this.instance).getPreciseLocation();
      }
      
      public boolean hasNonUserLocation() {
        return ((SemanticAnnotations.LocationQualifier)this.instance).hasNonUserLocation();
      }
      
      public boolean hasPreciseLocation() {
        return ((SemanticAnnotations.LocationQualifier)this.instance).hasPreciseLocation();
      }
      
      public Builder setNonUserLocation(boolean param2Boolean) {
        copyOnWrite();
        ((SemanticAnnotations.LocationQualifier)this.instance).setNonUserLocation(param2Boolean);
        return this;
      }
      
      public Builder setPreciseLocation(boolean param2Boolean) {
        copyOnWrite();
        ((SemanticAnnotations.LocationQualifier)this.instance).setPreciseLocation(param2Boolean);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<LocationQualifier, LocationQualifier.Builder> implements LocationQualifierOrBuilder {
    private Builder() {
      super(SemanticAnnotations.LocationQualifier.DEFAULT_INSTANCE);
    }
    
    public Builder clearNonUserLocation() {
      copyOnWrite();
      ((SemanticAnnotations.LocationQualifier)this.instance).clearNonUserLocation();
      return this;
    }
    
    public Builder clearPreciseLocation() {
      copyOnWrite();
      ((SemanticAnnotations.LocationQualifier)this.instance).clearPreciseLocation();
      return this;
    }
    
    public boolean getNonUserLocation() {
      return ((SemanticAnnotations.LocationQualifier)this.instance).getNonUserLocation();
    }
    
    public boolean getPreciseLocation() {
      return ((SemanticAnnotations.LocationQualifier)this.instance).getPreciseLocation();
    }
    
    public boolean hasNonUserLocation() {
      return ((SemanticAnnotations.LocationQualifier)this.instance).hasNonUserLocation();
    }
    
    public boolean hasPreciseLocation() {
      return ((SemanticAnnotations.LocationQualifier)this.instance).hasPreciseLocation();
    }
    
    public Builder setNonUserLocation(boolean param1Boolean) {
      copyOnWrite();
      ((SemanticAnnotations.LocationQualifier)this.instance).setNonUserLocation(param1Boolean);
      return this;
    }
    
    public Builder setPreciseLocation(boolean param1Boolean) {
      copyOnWrite();
      ((SemanticAnnotations.LocationQualifier)this.instance).setPreciseLocation(param1Boolean);
      return this;
    }
  }
  
  public static interface LocationQualifierOrBuilder extends MessageLiteOrBuilder {
    boolean getNonUserLocation();
    
    boolean getPreciseLocation();
    
    boolean hasNonUserLocation();
    
    boolean hasPreciseLocation();
  }
  
  public static final class MessageDetails extends GeneratedMessageLite<MessageDetails, MessageDetails.Builder> implements MessageDetailsOrBuilder {
    private static final MessageDetails DEFAULT_INSTANCE = new MessageDetails();
    
    private static volatile Parser<MessageDetails> PARSER;
    
    public static final int SEMANTIC_TYPE_FIELD_NUMBER = 1;
    
    private static final Internal.ListAdapter.Converter<Integer, SemanticAnnotations.SemanticType> semanticType_converter_ = new Internal.ListAdapter.Converter<Integer, SemanticAnnotations.SemanticType>() {
        public SemanticAnnotations.SemanticType convert(Integer param2Integer) {
          SemanticAnnotations.SemanticType semanticType2 = SemanticAnnotations.SemanticType.forNumber(param2Integer.intValue());
          SemanticAnnotations.SemanticType semanticType1 = semanticType2;
          if (semanticType2 == null)
            semanticType1 = SemanticAnnotations.SemanticType.ST_NOT_SPECIFIED; 
          return semanticType1;
        }
      };
    
    private Internal.IntList semanticType_ = emptyIntList();
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllSemanticType(Iterable<? extends SemanticAnnotations.SemanticType> param1Iterable) {
      ensureSemanticTypeIsMutable();
      for (SemanticAnnotations.SemanticType semanticType : param1Iterable)
        this.semanticType_.addInt(semanticType.getNumber()); 
    }
    
    private void addSemanticType(SemanticAnnotations.SemanticType param1SemanticType) {
      if (param1SemanticType != null) {
        ensureSemanticTypeIsMutable();
        this.semanticType_.addInt(param1SemanticType.getNumber());
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearSemanticType() {
      this.semanticType_ = emptyIntList();
    }
    
    private void ensureSemanticTypeIsMutable() {
      if (!this.semanticType_.isModifiable())
        this.semanticType_ = GeneratedMessageLite.mutableCopy(this.semanticType_); 
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
    
    private void setSemanticType(int param1Int, SemanticAnnotations.SemanticType param1SemanticType) {
      if (param1SemanticType != null) {
        ensureSemanticTypeIsMutable();
        this.semanticType_.setInt(param1Int, param1SemanticType.getNumber());
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/protos/datapol/SemanticAnnotations$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 435, 2 -> 431, 3 -> 420, 4 -> 411, 5 -> 377, 6 -> 110, 7 -> 373, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/protos/datapol/SemanticAnnotations$MessageDetails.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/protos/datapol/SemanticAnnotations$MessageDetails
      //   72: monitorenter
      //   73: getstatic com/google/protos/datapol/SemanticAnnotations$MessageDetails.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/protos/datapol/SemanticAnnotations$MessageDetails.DEFAULT_INSTANCE : Lcom/google/protos/datapol/SemanticAnnotations$MessageDetails;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/protos/datapol/SemanticAnnotations$MessageDetails.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/protos/datapol/SemanticAnnotations$MessageDetails
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/protos/datapol/SemanticAnnotations$MessageDetails
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/protos/datapol/SemanticAnnotations$MessageDetails.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 373
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 317
      //   139: iload #5
      //   141: bipush #8
      //   143: if_icmpeq -> 256
      //   146: iload #5
      //   148: bipush #10
      //   150: if_icmpeq -> 169
      //   153: aload_0
      //   154: iload #5
      //   156: aload_1
      //   157: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   160: ifne -> 123
      //   163: iconst_1
      //   164: istore #4
      //   166: goto -> 123
      //   169: aload_0
      //   170: getfield semanticType_ : Lcom/google/protobuf/Internal$IntList;
      //   173: invokeinterface isModifiable : ()Z
      //   178: ifne -> 192
      //   181: aload_0
      //   182: aload_0
      //   183: getfield semanticType_ : Lcom/google/protobuf/Internal$IntList;
      //   186: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$IntList;)Lcom/google/protobuf/Internal$IntList;
      //   189: putfield semanticType_ : Lcom/google/protobuf/Internal$IntList;
      //   192: aload_1
      //   193: aload_1
      //   194: invokevirtual readRawVarint32 : ()I
      //   197: invokevirtual pushLimit : (I)I
      //   200: istore #6
      //   202: aload_1
      //   203: invokevirtual getBytesUntilLimit : ()I
      //   206: ifle -> 247
      //   209: aload_1
      //   210: invokevirtual readEnum : ()I
      //   213: istore #5
      //   215: iload #5
      //   217: invokestatic forNumber : (I)Lcom/google/protos/datapol/SemanticAnnotations$SemanticType;
      //   220: ifnonnull -> 233
      //   223: aload_0
      //   224: iconst_1
      //   225: iload #5
      //   227: invokespecial mergeVarintField : (II)V
      //   230: goto -> 202
      //   233: aload_0
      //   234: getfield semanticType_ : Lcom/google/protobuf/Internal$IntList;
      //   237: iload #5
      //   239: invokeinterface addInt : (I)V
      //   244: goto -> 202
      //   247: aload_1
      //   248: iload #6
      //   250: invokevirtual popLimit : (I)V
      //   253: goto -> 123
      //   256: aload_0
      //   257: getfield semanticType_ : Lcom/google/protobuf/Internal$IntList;
      //   260: invokeinterface isModifiable : ()Z
      //   265: ifne -> 279
      //   268: aload_0
      //   269: aload_0
      //   270: getfield semanticType_ : Lcom/google/protobuf/Internal$IntList;
      //   273: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$IntList;)Lcom/google/protobuf/Internal$IntList;
      //   276: putfield semanticType_ : Lcom/google/protobuf/Internal$IntList;
      //   279: aload_1
      //   280: invokevirtual readEnum : ()I
      //   283: istore #5
      //   285: iload #5
      //   287: invokestatic forNumber : (I)Lcom/google/protos/datapol/SemanticAnnotations$SemanticType;
      //   290: ifnonnull -> 303
      //   293: aload_0
      //   294: iconst_1
      //   295: iload #5
      //   297: invokespecial mergeVarintField : (II)V
      //   300: goto -> 123
      //   303: aload_0
      //   304: getfield semanticType_ : Lcom/google/protobuf/Internal$IntList;
      //   307: iload #5
      //   309: invokeinterface addInt : (I)V
      //   314: goto -> 123
      //   317: iconst_1
      //   318: istore #4
      //   320: goto -> 123
      //   323: astore_1
      //   324: goto -> 371
      //   327: astore_2
      //   328: new java/lang/RuntimeException
      //   331: astore_1
      //   332: new com/google/protobuf/InvalidProtocolBufferException
      //   335: astore_3
      //   336: aload_3
      //   337: aload_2
      //   338: invokevirtual getMessage : ()Ljava/lang/String;
      //   341: invokespecial <init> : (Ljava/lang/String;)V
      //   344: aload_1
      //   345: aload_3
      //   346: aload_0
      //   347: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   350: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   353: aload_1
      //   354: athrow
      //   355: astore_1
      //   356: new java/lang/RuntimeException
      //   359: astore_2
      //   360: aload_2
      //   361: aload_1
      //   362: aload_0
      //   363: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   366: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   369: aload_2
      //   370: athrow
      //   371: aload_1
      //   372: athrow
      //   373: getstatic com/google/protos/datapol/SemanticAnnotations$MessageDetails.DEFAULT_INSTANCE : Lcom/google/protos/datapol/SemanticAnnotations$MessageDetails;
      //   376: areturn
      //   377: aload_2
      //   378: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   381: astore_1
      //   382: aload_3
      //   383: checkcast com/google/protos/datapol/SemanticAnnotations$MessageDetails
      //   386: astore_2
      //   387: aload_0
      //   388: aload_1
      //   389: aload_0
      //   390: getfield semanticType_ : Lcom/google/protobuf/Internal$IntList;
      //   393: aload_2
      //   394: getfield semanticType_ : Lcom/google/protobuf/Internal$IntList;
      //   397: invokeinterface visitIntList : (Lcom/google/protobuf/Internal$IntList;Lcom/google/protobuf/Internal$IntList;)Lcom/google/protobuf/Internal$IntList;
      //   402: putfield semanticType_ : Lcom/google/protobuf/Internal$IntList;
      //   405: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   408: astore_1
      //   409: aload_0
      //   410: areturn
      //   411: new com/google/protos/datapol/SemanticAnnotations$MessageDetails$Builder
      //   414: dup
      //   415: aconst_null
      //   416: invokespecial <init> : (Lcom/google/protos/datapol/SemanticAnnotations$1;)V
      //   419: areturn
      //   420: aload_0
      //   421: getfield semanticType_ : Lcom/google/protobuf/Internal$IntList;
      //   424: invokeinterface makeImmutable : ()V
      //   429: aconst_null
      //   430: areturn
      //   431: getstatic com/google/protos/datapol/SemanticAnnotations$MessageDetails.DEFAULT_INSTANCE : Lcom/google/protos/datapol/SemanticAnnotations$MessageDetails;
      //   434: areturn
      //   435: new com/google/protos/datapol/SemanticAnnotations$MessageDetails
      //   438: dup
      //   439: invokespecial <init> : ()V
      //   442: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	355	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	327	java/io/IOException
      //   128	134	323	finally
      //   153	163	355	com/google/protobuf/InvalidProtocolBufferException
      //   153	163	327	java/io/IOException
      //   153	163	323	finally
      //   169	192	355	com/google/protobuf/InvalidProtocolBufferException
      //   169	192	327	java/io/IOException
      //   169	192	323	finally
      //   192	202	355	com/google/protobuf/InvalidProtocolBufferException
      //   192	202	327	java/io/IOException
      //   192	202	323	finally
      //   202	230	355	com/google/protobuf/InvalidProtocolBufferException
      //   202	230	327	java/io/IOException
      //   202	230	323	finally
      //   233	244	355	com/google/protobuf/InvalidProtocolBufferException
      //   233	244	327	java/io/IOException
      //   233	244	323	finally
      //   247	253	355	com/google/protobuf/InvalidProtocolBufferException
      //   247	253	327	java/io/IOException
      //   247	253	323	finally
      //   256	279	355	com/google/protobuf/InvalidProtocolBufferException
      //   256	279	327	java/io/IOException
      //   256	279	323	finally
      //   279	300	355	com/google/protobuf/InvalidProtocolBufferException
      //   279	300	327	java/io/IOException
      //   279	300	323	finally
      //   303	314	355	com/google/protobuf/InvalidProtocolBufferException
      //   303	314	327	java/io/IOException
      //   303	314	323	finally
      //   328	355	323	finally
      //   356	371	323	finally
    }
    
    public SemanticAnnotations.SemanticType getSemanticType(int param1Int) {
      return (SemanticAnnotations.SemanticType)semanticType_converter_.convert(Integer.valueOf(this.semanticType_.getInt(param1Int)));
    }
    
    public int getSemanticTypeCount() {
      return this.semanticType_.size();
    }
    
    public List<SemanticAnnotations.SemanticType> getSemanticTypeList() {
      return (List<SemanticAnnotations.SemanticType>)new Internal.ListAdapter((List)this.semanticType_, semanticType_converter_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      int j = 0;
      while (i < this.semanticType_.size()) {
        j += CodedOutputStream.computeEnumSizeNoTag(this.semanticType_.getInt(i));
        i++;
      } 
      i = 0 + j + this.semanticType_.size() * 1 + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      for (byte b = 0; b < this.semanticType_.size(); b++)
        param1CodedOutputStream.writeEnum(1, this.semanticType_.getInt(b)); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<MessageDetails, Builder> implements SemanticAnnotations.MessageDetailsOrBuilder {
      private Builder() {
        super(SemanticAnnotations.MessageDetails.DEFAULT_INSTANCE);
      }
      
      public Builder addAllSemanticType(Iterable<? extends SemanticAnnotations.SemanticType> param2Iterable) {
        copyOnWrite();
        ((SemanticAnnotations.MessageDetails)this.instance).addAllSemanticType(param2Iterable);
        return this;
      }
      
      public Builder addSemanticType(SemanticAnnotations.SemanticType param2SemanticType) {
        copyOnWrite();
        ((SemanticAnnotations.MessageDetails)this.instance).addSemanticType(param2SemanticType);
        return this;
      }
      
      public Builder clearSemanticType() {
        copyOnWrite();
        ((SemanticAnnotations.MessageDetails)this.instance).clearSemanticType();
        return this;
      }
      
      public SemanticAnnotations.SemanticType getSemanticType(int param2Int) {
        return ((SemanticAnnotations.MessageDetails)this.instance).getSemanticType(param2Int);
      }
      
      public int getSemanticTypeCount() {
        return ((SemanticAnnotations.MessageDetails)this.instance).getSemanticTypeCount();
      }
      
      public List<SemanticAnnotations.SemanticType> getSemanticTypeList() {
        return ((SemanticAnnotations.MessageDetails)this.instance).getSemanticTypeList();
      }
      
      public Builder setSemanticType(int param2Int, SemanticAnnotations.SemanticType param2SemanticType) {
        copyOnWrite();
        ((SemanticAnnotations.MessageDetails)this.instance).setSemanticType(param2Int, param2SemanticType);
        return this;
      }
    }
  }
  
  class null implements Internal.ListAdapter.Converter<Integer, SemanticType> {
    public SemanticAnnotations.SemanticType convert(Integer param1Integer) {
      SemanticAnnotations.SemanticType semanticType2 = SemanticAnnotations.SemanticType.forNumber(param1Integer.intValue());
      SemanticAnnotations.SemanticType semanticType1 = semanticType2;
      if (semanticType2 == null)
        semanticType1 = SemanticAnnotations.SemanticType.ST_NOT_SPECIFIED; 
      return semanticType1;
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<MessageDetails, MessageDetails.Builder> implements MessageDetailsOrBuilder {
    private Builder() {
      super(SemanticAnnotations.MessageDetails.DEFAULT_INSTANCE);
    }
    
    public Builder addAllSemanticType(Iterable<? extends SemanticAnnotations.SemanticType> param1Iterable) {
      copyOnWrite();
      ((SemanticAnnotations.MessageDetails)this.instance).addAllSemanticType(param1Iterable);
      return this;
    }
    
    public Builder addSemanticType(SemanticAnnotations.SemanticType param1SemanticType) {
      copyOnWrite();
      ((SemanticAnnotations.MessageDetails)this.instance).addSemanticType(param1SemanticType);
      return this;
    }
    
    public Builder clearSemanticType() {
      copyOnWrite();
      ((SemanticAnnotations.MessageDetails)this.instance).clearSemanticType();
      return this;
    }
    
    public SemanticAnnotations.SemanticType getSemanticType(int param1Int) {
      return ((SemanticAnnotations.MessageDetails)this.instance).getSemanticType(param1Int);
    }
    
    public int getSemanticTypeCount() {
      return ((SemanticAnnotations.MessageDetails)this.instance).getSemanticTypeCount();
    }
    
    public List<SemanticAnnotations.SemanticType> getSemanticTypeList() {
      return ((SemanticAnnotations.MessageDetails)this.instance).getSemanticTypeList();
    }
    
    public Builder setSemanticType(int param1Int, SemanticAnnotations.SemanticType param1SemanticType) {
      copyOnWrite();
      ((SemanticAnnotations.MessageDetails)this.instance).setSemanticType(param1Int, param1SemanticType);
      return this;
    }
  }
  
  public static interface MessageDetailsOrBuilder extends MessageLiteOrBuilder {
    SemanticAnnotations.SemanticType getSemanticType(int param1Int);
    
    int getSemanticTypeCount();
    
    List<SemanticAnnotations.SemanticType> getSemanticTypeList();
  }
  
  public static final class Qualifier extends GeneratedMessageLite<Qualifier, Qualifier.Builder> implements QualifierOrBuilder {
    public static final int AUTO_DELETE_WITHIN_180_DAYS_FIELD_NUMBER = 13;
    
    public static final int AUTO_DELETE_WITHIN_WIPEOUT_FIELD_NUMBER = 11;
    
    private static final Qualifier DEFAULT_INSTANCE = new Qualifier();
    
    public static final int HAS_EXPLICIT_CONSENT_FIELD_NUMBER = 6;
    
    public static final int IS_ACCESS_TARGET_FIELD_NUMBER = 12;
    
    public static final int IS_ENCRYPTED_FIELD_NUMBER = 7;
    
    public static final int IS_GOOGLE_FIELD_NUMBER = 2;
    
    public static final int IS_PARTNER_FIELD_NUMBER = 4;
    
    public static final int IS_PUBLIC_FIELD_NUMBER = 1;
    
    public static final int IS_PUBLISHER_FIELD_NUMBER = 5;
    
    public static final int LIMITED_ACCESS_FIELD_NUMBER = 10;
    
    public static final int NON_USER_LOCATION_FIELD_NUMBER = 9;
    
    public static final int OTHER_USER_FIELD_NUMBER = 3;
    
    private static volatile Parser<Qualifier> PARSER;
    
    public static final int RELATED_FIELD_FIELD_NUMBER = 8;
    
    private boolean autoDeleteWithin180Days_;
    
    private boolean autoDeleteWithinWipeout_;
    
    private int bitField0_;
    
    private boolean hasExplicitConsent_;
    
    private boolean isAccessTarget_;
    
    private boolean isEncrypted_;
    
    private boolean isGoogle_;
    
    private boolean isPartner_;
    
    private boolean isPublic_;
    
    private boolean isPublisher_;
    
    private boolean limitedAccess_;
    
    private boolean nonUserLocation_;
    
    private boolean otherUser_;
    
    private int relatedField_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearAutoDeleteWithin180Days() {
      this.bitField0_ &= 0xFFFFF7FF;
      this.autoDeleteWithin180Days_ = false;
    }
    
    private void clearAutoDeleteWithinWipeout() {
      this.bitField0_ &= 0xFFFFFBFF;
      this.autoDeleteWithinWipeout_ = false;
    }
    
    private void clearHasExplicitConsent() {
      this.bitField0_ &= 0xFFFFFFDF;
      this.hasExplicitConsent_ = false;
    }
    
    private void clearIsAccessTarget() {
      this.bitField0_ &= 0xFFFFEFFF;
      this.isAccessTarget_ = false;
    }
    
    private void clearIsEncrypted() {
      this.bitField0_ &= 0xFFFFFFBF;
      this.isEncrypted_ = false;
    }
    
    private void clearIsGoogle() {
      this.bitField0_ &= 0xFFFFFFFD;
      this.isGoogle_ = false;
    }
    
    private void clearIsPartner() {
      this.bitField0_ &= 0xFFFFFFF7;
      this.isPartner_ = false;
    }
    
    private void clearIsPublic() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.isPublic_ = false;
    }
    
    private void clearIsPublisher() {
      this.bitField0_ &= 0xFFFFFFEF;
      this.isPublisher_ = false;
    }
    
    private void clearLimitedAccess() {
      this.bitField0_ &= 0xFFFFFDFF;
      this.limitedAccess_ = false;
    }
    
    private void clearNonUserLocation() {
      this.bitField0_ &= 0xFFFFFEFF;
      this.nonUserLocation_ = false;
    }
    
    private void clearOtherUser() {
      this.bitField0_ &= 0xFFFFFFFB;
      this.otherUser_ = false;
    }
    
    private void clearRelatedField() {
      this.bitField0_ &= 0xFFFFFF7F;
      this.relatedField_ = 0;
    }
    
    public static Qualifier getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Qualifier param1Qualifier) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1Qualifier);
    }
    
    public static Qualifier parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Qualifier)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Qualifier parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Qualifier)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Qualifier parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Qualifier)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static Qualifier parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Qualifier)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Qualifier parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Qualifier)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static Qualifier parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Qualifier)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Qualifier parseFrom(InputStream param1InputStream) throws IOException {
      return (Qualifier)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Qualifier parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Qualifier)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Qualifier parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Qualifier)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static Qualifier parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Qualifier)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Qualifier> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setAutoDeleteWithin180Days(boolean param1Boolean) {
      this.bitField0_ |= 0x800;
      this.autoDeleteWithin180Days_ = param1Boolean;
    }
    
    private void setAutoDeleteWithinWipeout(boolean param1Boolean) {
      this.bitField0_ |= 0x400;
      this.autoDeleteWithinWipeout_ = param1Boolean;
    }
    
    private void setHasExplicitConsent(boolean param1Boolean) {
      this.bitField0_ |= 0x20;
      this.hasExplicitConsent_ = param1Boolean;
    }
    
    private void setIsAccessTarget(boolean param1Boolean) {
      this.bitField0_ |= 0x1000;
      this.isAccessTarget_ = param1Boolean;
    }
    
    private void setIsEncrypted(boolean param1Boolean) {
      this.bitField0_ |= 0x40;
      this.isEncrypted_ = param1Boolean;
    }
    
    private void setIsGoogle(boolean param1Boolean) {
      this.bitField0_ |= 0x2;
      this.isGoogle_ = param1Boolean;
    }
    
    private void setIsPartner(boolean param1Boolean) {
      this.bitField0_ |= 0x8;
      this.isPartner_ = param1Boolean;
    }
    
    private void setIsPublic(boolean param1Boolean) {
      this.bitField0_ |= 0x1;
      this.isPublic_ = param1Boolean;
    }
    
    private void setIsPublisher(boolean param1Boolean) {
      this.bitField0_ |= 0x10;
      this.isPublisher_ = param1Boolean;
    }
    
    private void setLimitedAccess(boolean param1Boolean) {
      this.bitField0_ |= 0x200;
      this.limitedAccess_ = param1Boolean;
    }
    
    private void setNonUserLocation(boolean param1Boolean) {
      this.bitField0_ |= 0x100;
      this.nonUserLocation_ = param1Boolean;
    }
    
    private void setOtherUser(boolean param1Boolean) {
      this.bitField0_ |= 0x4;
      this.otherUser_ = param1Boolean;
    }
    
    private void setRelatedField(int param1Int) {
      this.bitField0_ |= 0x80;
      this.relatedField_ = param1Int;
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/protos/datapol/SemanticAnnotations$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 1017, 2 -> 1013, 3 -> 1011, 4 -> 1002, 5 -> 632, 6 -> 110, 7 -> 628, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/protos/datapol/SemanticAnnotations$Qualifier.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/protos/datapol/SemanticAnnotations$Qualifier
      //   72: monitorenter
      //   73: getstatic com/google/protos/datapol/SemanticAnnotations$Qualifier.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/protos/datapol/SemanticAnnotations$Qualifier.DEFAULT_INSTANCE : Lcom/google/protos/datapol/SemanticAnnotations$Qualifier;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/protos/datapol/SemanticAnnotations$Qualifier.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/protos/datapol/SemanticAnnotations$Qualifier
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/protos/datapol/SemanticAnnotations$Qualifier
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/protos/datapol/SemanticAnnotations$Qualifier.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 628
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: lookupswitch default -> 260, 0 -> 561, 8 -> 540, 16 -> 519, 24 -> 498, 32 -> 476, 40 -> 454, 48 -> 432, 56 -> 410, 64 -> 387, 72 -> 364, 80 -> 341, 88 -> 318, 96 -> 295, 104 -> 272
      //   260: aload_0
      //   261: iload #5
      //   263: aload_1
      //   264: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   267: istore #6
      //   269: goto -> 567
      //   272: aload_0
      //   273: aload_0
      //   274: getfield bitField0_ : I
      //   277: sipush #2048
      //   280: ior
      //   281: putfield bitField0_ : I
      //   284: aload_0
      //   285: aload_1
      //   286: invokevirtual readBool : ()Z
      //   289: putfield autoDeleteWithin180Days_ : Z
      //   292: goto -> 123
      //   295: aload_0
      //   296: aload_0
      //   297: getfield bitField0_ : I
      //   300: sipush #4096
      //   303: ior
      //   304: putfield bitField0_ : I
      //   307: aload_0
      //   308: aload_1
      //   309: invokevirtual readBool : ()Z
      //   312: putfield isAccessTarget_ : Z
      //   315: goto -> 123
      //   318: aload_0
      //   319: aload_0
      //   320: getfield bitField0_ : I
      //   323: sipush #1024
      //   326: ior
      //   327: putfield bitField0_ : I
      //   330: aload_0
      //   331: aload_1
      //   332: invokevirtual readBool : ()Z
      //   335: putfield autoDeleteWithinWipeout_ : Z
      //   338: goto -> 123
      //   341: aload_0
      //   342: aload_0
      //   343: getfield bitField0_ : I
      //   346: sipush #512
      //   349: ior
      //   350: putfield bitField0_ : I
      //   353: aload_0
      //   354: aload_1
      //   355: invokevirtual readBool : ()Z
      //   358: putfield limitedAccess_ : Z
      //   361: goto -> 123
      //   364: aload_0
      //   365: aload_0
      //   366: getfield bitField0_ : I
      //   369: sipush #256
      //   372: ior
      //   373: putfield bitField0_ : I
      //   376: aload_0
      //   377: aload_1
      //   378: invokevirtual readBool : ()Z
      //   381: putfield nonUserLocation_ : Z
      //   384: goto -> 123
      //   387: aload_0
      //   388: aload_0
      //   389: getfield bitField0_ : I
      //   392: sipush #128
      //   395: ior
      //   396: putfield bitField0_ : I
      //   399: aload_0
      //   400: aload_1
      //   401: invokevirtual readInt32 : ()I
      //   404: putfield relatedField_ : I
      //   407: goto -> 123
      //   410: aload_0
      //   411: aload_0
      //   412: getfield bitField0_ : I
      //   415: bipush #64
      //   417: ior
      //   418: putfield bitField0_ : I
      //   421: aload_0
      //   422: aload_1
      //   423: invokevirtual readBool : ()Z
      //   426: putfield isEncrypted_ : Z
      //   429: goto -> 123
      //   432: aload_0
      //   433: aload_0
      //   434: getfield bitField0_ : I
      //   437: bipush #32
      //   439: ior
      //   440: putfield bitField0_ : I
      //   443: aload_0
      //   444: aload_1
      //   445: invokevirtual readBool : ()Z
      //   448: putfield hasExplicitConsent_ : Z
      //   451: goto -> 123
      //   454: aload_0
      //   455: aload_0
      //   456: getfield bitField0_ : I
      //   459: bipush #16
      //   461: ior
      //   462: putfield bitField0_ : I
      //   465: aload_0
      //   466: aload_1
      //   467: invokevirtual readBool : ()Z
      //   470: putfield isPublisher_ : Z
      //   473: goto -> 123
      //   476: aload_0
      //   477: aload_0
      //   478: getfield bitField0_ : I
      //   481: bipush #8
      //   483: ior
      //   484: putfield bitField0_ : I
      //   487: aload_0
      //   488: aload_1
      //   489: invokevirtual readBool : ()Z
      //   492: putfield isPartner_ : Z
      //   495: goto -> 123
      //   498: aload_0
      //   499: aload_0
      //   500: getfield bitField0_ : I
      //   503: iconst_4
      //   504: ior
      //   505: putfield bitField0_ : I
      //   508: aload_0
      //   509: aload_1
      //   510: invokevirtual readBool : ()Z
      //   513: putfield otherUser_ : Z
      //   516: goto -> 123
      //   519: aload_0
      //   520: aload_0
      //   521: getfield bitField0_ : I
      //   524: iconst_2
      //   525: ior
      //   526: putfield bitField0_ : I
      //   529: aload_0
      //   530: aload_1
      //   531: invokevirtual readBool : ()Z
      //   534: putfield isGoogle_ : Z
      //   537: goto -> 123
      //   540: aload_0
      //   541: aload_0
      //   542: getfield bitField0_ : I
      //   545: iconst_1
      //   546: ior
      //   547: putfield bitField0_ : I
      //   550: aload_0
      //   551: aload_1
      //   552: invokevirtual readBool : ()Z
      //   555: putfield isPublic_ : Z
      //   558: goto -> 123
      //   561: iconst_1
      //   562: istore #4
      //   564: goto -> 123
      //   567: iload #6
      //   569: ifne -> 123
      //   572: iconst_1
      //   573: istore #4
      //   575: goto -> 123
      //   578: astore_1
      //   579: goto -> 626
      //   582: astore_3
      //   583: new java/lang/RuntimeException
      //   586: astore_2
      //   587: new com/google/protobuf/InvalidProtocolBufferException
      //   590: astore_1
      //   591: aload_1
      //   592: aload_3
      //   593: invokevirtual getMessage : ()Ljava/lang/String;
      //   596: invokespecial <init> : (Ljava/lang/String;)V
      //   599: aload_2
      //   600: aload_1
      //   601: aload_0
      //   602: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   605: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   608: aload_2
      //   609: athrow
      //   610: astore_1
      //   611: new java/lang/RuntimeException
      //   614: astore_2
      //   615: aload_2
      //   616: aload_1
      //   617: aload_0
      //   618: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   621: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   624: aload_2
      //   625: athrow
      //   626: aload_1
      //   627: athrow
      //   628: getstatic com/google/protos/datapol/SemanticAnnotations$Qualifier.DEFAULT_INSTANCE : Lcom/google/protos/datapol/SemanticAnnotations$Qualifier;
      //   631: areturn
      //   632: aload_2
      //   633: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   636: astore_1
      //   637: aload_3
      //   638: checkcast com/google/protos/datapol/SemanticAnnotations$Qualifier
      //   641: astore_2
      //   642: aload_0
      //   643: aload_1
      //   644: aload_0
      //   645: invokevirtual hasIsPublic : ()Z
      //   648: aload_0
      //   649: getfield isPublic_ : Z
      //   652: aload_2
      //   653: invokevirtual hasIsPublic : ()Z
      //   656: aload_2
      //   657: getfield isPublic_ : Z
      //   660: invokeinterface visitBoolean : (ZZZZ)Z
      //   665: putfield isPublic_ : Z
      //   668: aload_0
      //   669: aload_1
      //   670: aload_0
      //   671: invokevirtual hasIsGoogle : ()Z
      //   674: aload_0
      //   675: getfield isGoogle_ : Z
      //   678: aload_2
      //   679: invokevirtual hasIsGoogle : ()Z
      //   682: aload_2
      //   683: getfield isGoogle_ : Z
      //   686: invokeinterface visitBoolean : (ZZZZ)Z
      //   691: putfield isGoogle_ : Z
      //   694: aload_0
      //   695: aload_1
      //   696: aload_0
      //   697: invokevirtual hasOtherUser : ()Z
      //   700: aload_0
      //   701: getfield otherUser_ : Z
      //   704: aload_2
      //   705: invokevirtual hasOtherUser : ()Z
      //   708: aload_2
      //   709: getfield otherUser_ : Z
      //   712: invokeinterface visitBoolean : (ZZZZ)Z
      //   717: putfield otherUser_ : Z
      //   720: aload_0
      //   721: aload_1
      //   722: aload_0
      //   723: invokevirtual hasIsPartner : ()Z
      //   726: aload_0
      //   727: getfield isPartner_ : Z
      //   730: aload_2
      //   731: invokevirtual hasIsPartner : ()Z
      //   734: aload_2
      //   735: getfield isPartner_ : Z
      //   738: invokeinterface visitBoolean : (ZZZZ)Z
      //   743: putfield isPartner_ : Z
      //   746: aload_0
      //   747: aload_1
      //   748: aload_0
      //   749: invokevirtual hasIsPublisher : ()Z
      //   752: aload_0
      //   753: getfield isPublisher_ : Z
      //   756: aload_2
      //   757: invokevirtual hasIsPublisher : ()Z
      //   760: aload_2
      //   761: getfield isPublisher_ : Z
      //   764: invokeinterface visitBoolean : (ZZZZ)Z
      //   769: putfield isPublisher_ : Z
      //   772: aload_0
      //   773: aload_1
      //   774: aload_0
      //   775: invokevirtual hasHasExplicitConsent : ()Z
      //   778: aload_0
      //   779: getfield hasExplicitConsent_ : Z
      //   782: aload_2
      //   783: invokevirtual hasHasExplicitConsent : ()Z
      //   786: aload_2
      //   787: getfield hasExplicitConsent_ : Z
      //   790: invokeinterface visitBoolean : (ZZZZ)Z
      //   795: putfield hasExplicitConsent_ : Z
      //   798: aload_0
      //   799: aload_1
      //   800: aload_0
      //   801: invokevirtual hasIsEncrypted : ()Z
      //   804: aload_0
      //   805: getfield isEncrypted_ : Z
      //   808: aload_2
      //   809: invokevirtual hasIsEncrypted : ()Z
      //   812: aload_2
      //   813: getfield isEncrypted_ : Z
      //   816: invokeinterface visitBoolean : (ZZZZ)Z
      //   821: putfield isEncrypted_ : Z
      //   824: aload_0
      //   825: aload_1
      //   826: aload_0
      //   827: invokevirtual hasRelatedField : ()Z
      //   830: aload_0
      //   831: getfield relatedField_ : I
      //   834: aload_2
      //   835: invokevirtual hasRelatedField : ()Z
      //   838: aload_2
      //   839: getfield relatedField_ : I
      //   842: invokeinterface visitInt : (ZIZI)I
      //   847: putfield relatedField_ : I
      //   850: aload_0
      //   851: aload_1
      //   852: aload_0
      //   853: invokevirtual hasNonUserLocation : ()Z
      //   856: aload_0
      //   857: getfield nonUserLocation_ : Z
      //   860: aload_2
      //   861: invokevirtual hasNonUserLocation : ()Z
      //   864: aload_2
      //   865: getfield nonUserLocation_ : Z
      //   868: invokeinterface visitBoolean : (ZZZZ)Z
      //   873: putfield nonUserLocation_ : Z
      //   876: aload_0
      //   877: aload_1
      //   878: aload_0
      //   879: invokevirtual hasLimitedAccess : ()Z
      //   882: aload_0
      //   883: getfield limitedAccess_ : Z
      //   886: aload_2
      //   887: invokevirtual hasLimitedAccess : ()Z
      //   890: aload_2
      //   891: getfield limitedAccess_ : Z
      //   894: invokeinterface visitBoolean : (ZZZZ)Z
      //   899: putfield limitedAccess_ : Z
      //   902: aload_0
      //   903: aload_1
      //   904: aload_0
      //   905: invokevirtual hasAutoDeleteWithinWipeout : ()Z
      //   908: aload_0
      //   909: getfield autoDeleteWithinWipeout_ : Z
      //   912: aload_2
      //   913: invokevirtual hasAutoDeleteWithinWipeout : ()Z
      //   916: aload_2
      //   917: getfield autoDeleteWithinWipeout_ : Z
      //   920: invokeinterface visitBoolean : (ZZZZ)Z
      //   925: putfield autoDeleteWithinWipeout_ : Z
      //   928: aload_0
      //   929: aload_1
      //   930: aload_0
      //   931: invokevirtual hasAutoDeleteWithin180Days : ()Z
      //   934: aload_0
      //   935: getfield autoDeleteWithin180Days_ : Z
      //   938: aload_2
      //   939: invokevirtual hasAutoDeleteWithin180Days : ()Z
      //   942: aload_2
      //   943: getfield autoDeleteWithin180Days_ : Z
      //   946: invokeinterface visitBoolean : (ZZZZ)Z
      //   951: putfield autoDeleteWithin180Days_ : Z
      //   954: aload_0
      //   955: aload_1
      //   956: aload_0
      //   957: invokevirtual hasIsAccessTarget : ()Z
      //   960: aload_0
      //   961: getfield isAccessTarget_ : Z
      //   964: aload_2
      //   965: invokevirtual hasIsAccessTarget : ()Z
      //   968: aload_2
      //   969: getfield isAccessTarget_ : Z
      //   972: invokeinterface visitBoolean : (ZZZZ)Z
      //   977: putfield isAccessTarget_ : Z
      //   980: aload_1
      //   981: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   984: if_acmpne -> 1000
      //   987: aload_0
      //   988: aload_0
      //   989: getfield bitField0_ : I
      //   992: aload_2
      //   993: getfield bitField0_ : I
      //   996: ior
      //   997: putfield bitField0_ : I
      //   1000: aload_0
      //   1001: areturn
      //   1002: new com/google/protos/datapol/SemanticAnnotations$Qualifier$Builder
      //   1005: dup
      //   1006: aconst_null
      //   1007: invokespecial <init> : (Lcom/google/protos/datapol/SemanticAnnotations$1;)V
      //   1010: areturn
      //   1011: aconst_null
      //   1012: areturn
      //   1013: getstatic com/google/protos/datapol/SemanticAnnotations$Qualifier.DEFAULT_INSTANCE : Lcom/google/protos/datapol/SemanticAnnotations$Qualifier;
      //   1016: areturn
      //   1017: new com/google/protos/datapol/SemanticAnnotations$Qualifier
      //   1020: dup
      //   1021: invokespecial <init> : ()V
      //   1024: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	610	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	582	java/io/IOException
      //   128	134	578	finally
      //   260	269	610	com/google/protobuf/InvalidProtocolBufferException
      //   260	269	582	java/io/IOException
      //   260	269	578	finally
      //   272	292	610	com/google/protobuf/InvalidProtocolBufferException
      //   272	292	582	java/io/IOException
      //   272	292	578	finally
      //   295	315	610	com/google/protobuf/InvalidProtocolBufferException
      //   295	315	582	java/io/IOException
      //   295	315	578	finally
      //   318	338	610	com/google/protobuf/InvalidProtocolBufferException
      //   318	338	582	java/io/IOException
      //   318	338	578	finally
      //   341	361	610	com/google/protobuf/InvalidProtocolBufferException
      //   341	361	582	java/io/IOException
      //   341	361	578	finally
      //   364	384	610	com/google/protobuf/InvalidProtocolBufferException
      //   364	384	582	java/io/IOException
      //   364	384	578	finally
      //   387	407	610	com/google/protobuf/InvalidProtocolBufferException
      //   387	407	582	java/io/IOException
      //   387	407	578	finally
      //   410	429	610	com/google/protobuf/InvalidProtocolBufferException
      //   410	429	582	java/io/IOException
      //   410	429	578	finally
      //   432	451	610	com/google/protobuf/InvalidProtocolBufferException
      //   432	451	582	java/io/IOException
      //   432	451	578	finally
      //   454	473	610	com/google/protobuf/InvalidProtocolBufferException
      //   454	473	582	java/io/IOException
      //   454	473	578	finally
      //   476	495	610	com/google/protobuf/InvalidProtocolBufferException
      //   476	495	582	java/io/IOException
      //   476	495	578	finally
      //   498	516	610	com/google/protobuf/InvalidProtocolBufferException
      //   498	516	582	java/io/IOException
      //   498	516	578	finally
      //   519	537	610	com/google/protobuf/InvalidProtocolBufferException
      //   519	537	582	java/io/IOException
      //   519	537	578	finally
      //   540	558	610	com/google/protobuf/InvalidProtocolBufferException
      //   540	558	582	java/io/IOException
      //   540	558	578	finally
      //   583	610	578	finally
      //   611	626	578	finally
    }
    
    public boolean getAutoDeleteWithin180Days() {
      return this.autoDeleteWithin180Days_;
    }
    
    public boolean getAutoDeleteWithinWipeout() {
      return this.autoDeleteWithinWipeout_;
    }
    
    public boolean getHasExplicitConsent() {
      return this.hasExplicitConsent_;
    }
    
    public boolean getIsAccessTarget() {
      return this.isAccessTarget_;
    }
    
    public boolean getIsEncrypted() {
      return this.isEncrypted_;
    }
    
    public boolean getIsGoogle() {
      return this.isGoogle_;
    }
    
    public boolean getIsPartner() {
      return this.isPartner_;
    }
    
    public boolean getIsPublic() {
      return this.isPublic_;
    }
    
    public boolean getIsPublisher() {
      return this.isPublisher_;
    }
    
    public boolean getLimitedAccess() {
      return this.limitedAccess_;
    }
    
    public boolean getNonUserLocation() {
      return this.nonUserLocation_;
    }
    
    public boolean getOtherUser() {
      return this.otherUser_;
    }
    
    public int getRelatedField() {
      return this.relatedField_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if ((this.bitField0_ & 0x1) == 1)
        i = 0 + CodedOutputStream.computeBoolSize(1, this.isPublic_); 
      int j = i;
      if ((this.bitField0_ & 0x2) == 2)
        j = i + CodedOutputStream.computeBoolSize(2, this.isGoogle_); 
      i = j;
      if ((this.bitField0_ & 0x4) == 4)
        i = j + CodedOutputStream.computeBoolSize(3, this.otherUser_); 
      j = i;
      if ((this.bitField0_ & 0x8) == 8)
        j = i + CodedOutputStream.computeBoolSize(4, this.isPartner_); 
      i = j;
      if ((this.bitField0_ & 0x10) == 16)
        i = j + CodedOutputStream.computeBoolSize(5, this.isPublisher_); 
      j = i;
      if ((this.bitField0_ & 0x20) == 32)
        j = i + CodedOutputStream.computeBoolSize(6, this.hasExplicitConsent_); 
      i = j;
      if ((this.bitField0_ & 0x40) == 64)
        i = j + CodedOutputStream.computeBoolSize(7, this.isEncrypted_); 
      int k = i;
      if ((this.bitField0_ & 0x80) == 128)
        k = i + CodedOutputStream.computeInt32Size(8, this.relatedField_); 
      j = k;
      if ((this.bitField0_ & 0x100) == 256)
        j = k + CodedOutputStream.computeBoolSize(9, this.nonUserLocation_); 
      i = j;
      if ((this.bitField0_ & 0x200) == 512)
        i = j + CodedOutputStream.computeBoolSize(10, this.limitedAccess_); 
      j = i;
      if ((this.bitField0_ & 0x400) == 1024)
        j = i + CodedOutputStream.computeBoolSize(11, this.autoDeleteWithinWipeout_); 
      i = j;
      if ((this.bitField0_ & 0x1000) == 4096)
        i = j + CodedOutputStream.computeBoolSize(12, this.isAccessTarget_); 
      j = i;
      if ((this.bitField0_ & 0x800) == 2048)
        j = i + CodedOutputStream.computeBoolSize(13, this.autoDeleteWithin180Days_); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasAutoDeleteWithin180Days() {
      boolean bool;
      if ((this.bitField0_ & 0x800) == 2048) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasAutoDeleteWithinWipeout() {
      boolean bool;
      if ((this.bitField0_ & 0x400) == 1024) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasHasExplicitConsent() {
      boolean bool;
      if ((this.bitField0_ & 0x20) == 32) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasIsAccessTarget() {
      boolean bool;
      if ((this.bitField0_ & 0x1000) == 4096) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasIsEncrypted() {
      boolean bool;
      if ((this.bitField0_ & 0x40) == 64) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasIsGoogle() {
      boolean bool;
      if ((this.bitField0_ & 0x2) == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasIsPartner() {
      boolean bool;
      if ((this.bitField0_ & 0x8) == 8) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasIsPublic() {
      int i = this.bitField0_;
      boolean bool = true;
      if ((i & 0x1) != 1)
        bool = false; 
      return bool;
    }
    
    public boolean hasIsPublisher() {
      boolean bool;
      if ((this.bitField0_ & 0x10) == 16) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasLimitedAccess() {
      boolean bool;
      if ((this.bitField0_ & 0x200) == 512) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasNonUserLocation() {
      boolean bool;
      if ((this.bitField0_ & 0x100) == 256) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasOtherUser() {
      boolean bool;
      if ((this.bitField0_ & 0x4) == 4) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasRelatedField() {
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
        param1CodedOutputStream.writeBool(1, this.isPublic_); 
      if ((this.bitField0_ & 0x2) == 2)
        param1CodedOutputStream.writeBool(2, this.isGoogle_); 
      if ((this.bitField0_ & 0x4) == 4)
        param1CodedOutputStream.writeBool(3, this.otherUser_); 
      if ((this.bitField0_ & 0x8) == 8)
        param1CodedOutputStream.writeBool(4, this.isPartner_); 
      if ((this.bitField0_ & 0x10) == 16)
        param1CodedOutputStream.writeBool(5, this.isPublisher_); 
      if ((this.bitField0_ & 0x20) == 32)
        param1CodedOutputStream.writeBool(6, this.hasExplicitConsent_); 
      if ((this.bitField0_ & 0x40) == 64)
        param1CodedOutputStream.writeBool(7, this.isEncrypted_); 
      if ((this.bitField0_ & 0x80) == 128)
        param1CodedOutputStream.writeInt32(8, this.relatedField_); 
      if ((this.bitField0_ & 0x100) == 256)
        param1CodedOutputStream.writeBool(9, this.nonUserLocation_); 
      if ((this.bitField0_ & 0x200) == 512)
        param1CodedOutputStream.writeBool(10, this.limitedAccess_); 
      if ((this.bitField0_ & 0x400) == 1024)
        param1CodedOutputStream.writeBool(11, this.autoDeleteWithinWipeout_); 
      if ((this.bitField0_ & 0x1000) == 4096)
        param1CodedOutputStream.writeBool(12, this.isAccessTarget_); 
      if ((this.bitField0_ & 0x800) == 2048)
        param1CodedOutputStream.writeBool(13, this.autoDeleteWithin180Days_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Qualifier, Builder> implements SemanticAnnotations.QualifierOrBuilder {
      private Builder() {
        super(SemanticAnnotations.Qualifier.DEFAULT_INSTANCE);
      }
      
      public Builder clearAutoDeleteWithin180Days() {
        copyOnWrite();
        ((SemanticAnnotations.Qualifier)this.instance).clearAutoDeleteWithin180Days();
        return this;
      }
      
      public Builder clearAutoDeleteWithinWipeout() {
        copyOnWrite();
        ((SemanticAnnotations.Qualifier)this.instance).clearAutoDeleteWithinWipeout();
        return this;
      }
      
      public Builder clearHasExplicitConsent() {
        copyOnWrite();
        ((SemanticAnnotations.Qualifier)this.instance).clearHasExplicitConsent();
        return this;
      }
      
      public Builder clearIsAccessTarget() {
        copyOnWrite();
        ((SemanticAnnotations.Qualifier)this.instance).clearIsAccessTarget();
        return this;
      }
      
      public Builder clearIsEncrypted() {
        copyOnWrite();
        ((SemanticAnnotations.Qualifier)this.instance).clearIsEncrypted();
        return this;
      }
      
      public Builder clearIsGoogle() {
        copyOnWrite();
        ((SemanticAnnotations.Qualifier)this.instance).clearIsGoogle();
        return this;
      }
      
      public Builder clearIsPartner() {
        copyOnWrite();
        ((SemanticAnnotations.Qualifier)this.instance).clearIsPartner();
        return this;
      }
      
      public Builder clearIsPublic() {
        copyOnWrite();
        ((SemanticAnnotations.Qualifier)this.instance).clearIsPublic();
        return this;
      }
      
      public Builder clearIsPublisher() {
        copyOnWrite();
        ((SemanticAnnotations.Qualifier)this.instance).clearIsPublisher();
        return this;
      }
      
      public Builder clearLimitedAccess() {
        copyOnWrite();
        ((SemanticAnnotations.Qualifier)this.instance).clearLimitedAccess();
        return this;
      }
      
      public Builder clearNonUserLocation() {
        copyOnWrite();
        ((SemanticAnnotations.Qualifier)this.instance).clearNonUserLocation();
        return this;
      }
      
      public Builder clearOtherUser() {
        copyOnWrite();
        ((SemanticAnnotations.Qualifier)this.instance).clearOtherUser();
        return this;
      }
      
      public Builder clearRelatedField() {
        copyOnWrite();
        ((SemanticAnnotations.Qualifier)this.instance).clearRelatedField();
        return this;
      }
      
      public boolean getAutoDeleteWithin180Days() {
        return ((SemanticAnnotations.Qualifier)this.instance).getAutoDeleteWithin180Days();
      }
      
      public boolean getAutoDeleteWithinWipeout() {
        return ((SemanticAnnotations.Qualifier)this.instance).getAutoDeleteWithinWipeout();
      }
      
      public boolean getHasExplicitConsent() {
        return ((SemanticAnnotations.Qualifier)this.instance).getHasExplicitConsent();
      }
      
      public boolean getIsAccessTarget() {
        return ((SemanticAnnotations.Qualifier)this.instance).getIsAccessTarget();
      }
      
      public boolean getIsEncrypted() {
        return ((SemanticAnnotations.Qualifier)this.instance).getIsEncrypted();
      }
      
      public boolean getIsGoogle() {
        return ((SemanticAnnotations.Qualifier)this.instance).getIsGoogle();
      }
      
      public boolean getIsPartner() {
        return ((SemanticAnnotations.Qualifier)this.instance).getIsPartner();
      }
      
      public boolean getIsPublic() {
        return ((SemanticAnnotations.Qualifier)this.instance).getIsPublic();
      }
      
      public boolean getIsPublisher() {
        return ((SemanticAnnotations.Qualifier)this.instance).getIsPublisher();
      }
      
      public boolean getLimitedAccess() {
        return ((SemanticAnnotations.Qualifier)this.instance).getLimitedAccess();
      }
      
      public boolean getNonUserLocation() {
        return ((SemanticAnnotations.Qualifier)this.instance).getNonUserLocation();
      }
      
      public boolean getOtherUser() {
        return ((SemanticAnnotations.Qualifier)this.instance).getOtherUser();
      }
      
      public int getRelatedField() {
        return ((SemanticAnnotations.Qualifier)this.instance).getRelatedField();
      }
      
      public boolean hasAutoDeleteWithin180Days() {
        return ((SemanticAnnotations.Qualifier)this.instance).hasAutoDeleteWithin180Days();
      }
      
      public boolean hasAutoDeleteWithinWipeout() {
        return ((SemanticAnnotations.Qualifier)this.instance).hasAutoDeleteWithinWipeout();
      }
      
      public boolean hasHasExplicitConsent() {
        return ((SemanticAnnotations.Qualifier)this.instance).hasHasExplicitConsent();
      }
      
      public boolean hasIsAccessTarget() {
        return ((SemanticAnnotations.Qualifier)this.instance).hasIsAccessTarget();
      }
      
      public boolean hasIsEncrypted() {
        return ((SemanticAnnotations.Qualifier)this.instance).hasIsEncrypted();
      }
      
      public boolean hasIsGoogle() {
        return ((SemanticAnnotations.Qualifier)this.instance).hasIsGoogle();
      }
      
      public boolean hasIsPartner() {
        return ((SemanticAnnotations.Qualifier)this.instance).hasIsPartner();
      }
      
      public boolean hasIsPublic() {
        return ((SemanticAnnotations.Qualifier)this.instance).hasIsPublic();
      }
      
      public boolean hasIsPublisher() {
        return ((SemanticAnnotations.Qualifier)this.instance).hasIsPublisher();
      }
      
      public boolean hasLimitedAccess() {
        return ((SemanticAnnotations.Qualifier)this.instance).hasLimitedAccess();
      }
      
      public boolean hasNonUserLocation() {
        return ((SemanticAnnotations.Qualifier)this.instance).hasNonUserLocation();
      }
      
      public boolean hasOtherUser() {
        return ((SemanticAnnotations.Qualifier)this.instance).hasOtherUser();
      }
      
      public boolean hasRelatedField() {
        return ((SemanticAnnotations.Qualifier)this.instance).hasRelatedField();
      }
      
      public Builder setAutoDeleteWithin180Days(boolean param2Boolean) {
        copyOnWrite();
        ((SemanticAnnotations.Qualifier)this.instance).setAutoDeleteWithin180Days(param2Boolean);
        return this;
      }
      
      public Builder setAutoDeleteWithinWipeout(boolean param2Boolean) {
        copyOnWrite();
        ((SemanticAnnotations.Qualifier)this.instance).setAutoDeleteWithinWipeout(param2Boolean);
        return this;
      }
      
      public Builder setHasExplicitConsent(boolean param2Boolean) {
        copyOnWrite();
        ((SemanticAnnotations.Qualifier)this.instance).setHasExplicitConsent(param2Boolean);
        return this;
      }
      
      public Builder setIsAccessTarget(boolean param2Boolean) {
        copyOnWrite();
        ((SemanticAnnotations.Qualifier)this.instance).setIsAccessTarget(param2Boolean);
        return this;
      }
      
      public Builder setIsEncrypted(boolean param2Boolean) {
        copyOnWrite();
        ((SemanticAnnotations.Qualifier)this.instance).setIsEncrypted(param2Boolean);
        return this;
      }
      
      public Builder setIsGoogle(boolean param2Boolean) {
        copyOnWrite();
        ((SemanticAnnotations.Qualifier)this.instance).setIsGoogle(param2Boolean);
        return this;
      }
      
      public Builder setIsPartner(boolean param2Boolean) {
        copyOnWrite();
        ((SemanticAnnotations.Qualifier)this.instance).setIsPartner(param2Boolean);
        return this;
      }
      
      public Builder setIsPublic(boolean param2Boolean) {
        copyOnWrite();
        ((SemanticAnnotations.Qualifier)this.instance).setIsPublic(param2Boolean);
        return this;
      }
      
      public Builder setIsPublisher(boolean param2Boolean) {
        copyOnWrite();
        ((SemanticAnnotations.Qualifier)this.instance).setIsPublisher(param2Boolean);
        return this;
      }
      
      public Builder setLimitedAccess(boolean param2Boolean) {
        copyOnWrite();
        ((SemanticAnnotations.Qualifier)this.instance).setLimitedAccess(param2Boolean);
        return this;
      }
      
      public Builder setNonUserLocation(boolean param2Boolean) {
        copyOnWrite();
        ((SemanticAnnotations.Qualifier)this.instance).setNonUserLocation(param2Boolean);
        return this;
      }
      
      public Builder setOtherUser(boolean param2Boolean) {
        copyOnWrite();
        ((SemanticAnnotations.Qualifier)this.instance).setOtherUser(param2Boolean);
        return this;
      }
      
      public Builder setRelatedField(int param2Int) {
        copyOnWrite();
        ((SemanticAnnotations.Qualifier)this.instance).setRelatedField(param2Int);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Qualifier, Qualifier.Builder> implements QualifierOrBuilder {
    private Builder() {
      super(SemanticAnnotations.Qualifier.DEFAULT_INSTANCE);
    }
    
    public Builder clearAutoDeleteWithin180Days() {
      copyOnWrite();
      ((SemanticAnnotations.Qualifier)this.instance).clearAutoDeleteWithin180Days();
      return this;
    }
    
    public Builder clearAutoDeleteWithinWipeout() {
      copyOnWrite();
      ((SemanticAnnotations.Qualifier)this.instance).clearAutoDeleteWithinWipeout();
      return this;
    }
    
    public Builder clearHasExplicitConsent() {
      copyOnWrite();
      ((SemanticAnnotations.Qualifier)this.instance).clearHasExplicitConsent();
      return this;
    }
    
    public Builder clearIsAccessTarget() {
      copyOnWrite();
      ((SemanticAnnotations.Qualifier)this.instance).clearIsAccessTarget();
      return this;
    }
    
    public Builder clearIsEncrypted() {
      copyOnWrite();
      ((SemanticAnnotations.Qualifier)this.instance).clearIsEncrypted();
      return this;
    }
    
    public Builder clearIsGoogle() {
      copyOnWrite();
      ((SemanticAnnotations.Qualifier)this.instance).clearIsGoogle();
      return this;
    }
    
    public Builder clearIsPartner() {
      copyOnWrite();
      ((SemanticAnnotations.Qualifier)this.instance).clearIsPartner();
      return this;
    }
    
    public Builder clearIsPublic() {
      copyOnWrite();
      ((SemanticAnnotations.Qualifier)this.instance).clearIsPublic();
      return this;
    }
    
    public Builder clearIsPublisher() {
      copyOnWrite();
      ((SemanticAnnotations.Qualifier)this.instance).clearIsPublisher();
      return this;
    }
    
    public Builder clearLimitedAccess() {
      copyOnWrite();
      ((SemanticAnnotations.Qualifier)this.instance).clearLimitedAccess();
      return this;
    }
    
    public Builder clearNonUserLocation() {
      copyOnWrite();
      ((SemanticAnnotations.Qualifier)this.instance).clearNonUserLocation();
      return this;
    }
    
    public Builder clearOtherUser() {
      copyOnWrite();
      ((SemanticAnnotations.Qualifier)this.instance).clearOtherUser();
      return this;
    }
    
    public Builder clearRelatedField() {
      copyOnWrite();
      ((SemanticAnnotations.Qualifier)this.instance).clearRelatedField();
      return this;
    }
    
    public boolean getAutoDeleteWithin180Days() {
      return ((SemanticAnnotations.Qualifier)this.instance).getAutoDeleteWithin180Days();
    }
    
    public boolean getAutoDeleteWithinWipeout() {
      return ((SemanticAnnotations.Qualifier)this.instance).getAutoDeleteWithinWipeout();
    }
    
    public boolean getHasExplicitConsent() {
      return ((SemanticAnnotations.Qualifier)this.instance).getHasExplicitConsent();
    }
    
    public boolean getIsAccessTarget() {
      return ((SemanticAnnotations.Qualifier)this.instance).getIsAccessTarget();
    }
    
    public boolean getIsEncrypted() {
      return ((SemanticAnnotations.Qualifier)this.instance).getIsEncrypted();
    }
    
    public boolean getIsGoogle() {
      return ((SemanticAnnotations.Qualifier)this.instance).getIsGoogle();
    }
    
    public boolean getIsPartner() {
      return ((SemanticAnnotations.Qualifier)this.instance).getIsPartner();
    }
    
    public boolean getIsPublic() {
      return ((SemanticAnnotations.Qualifier)this.instance).getIsPublic();
    }
    
    public boolean getIsPublisher() {
      return ((SemanticAnnotations.Qualifier)this.instance).getIsPublisher();
    }
    
    public boolean getLimitedAccess() {
      return ((SemanticAnnotations.Qualifier)this.instance).getLimitedAccess();
    }
    
    public boolean getNonUserLocation() {
      return ((SemanticAnnotations.Qualifier)this.instance).getNonUserLocation();
    }
    
    public boolean getOtherUser() {
      return ((SemanticAnnotations.Qualifier)this.instance).getOtherUser();
    }
    
    public int getRelatedField() {
      return ((SemanticAnnotations.Qualifier)this.instance).getRelatedField();
    }
    
    public boolean hasAutoDeleteWithin180Days() {
      return ((SemanticAnnotations.Qualifier)this.instance).hasAutoDeleteWithin180Days();
    }
    
    public boolean hasAutoDeleteWithinWipeout() {
      return ((SemanticAnnotations.Qualifier)this.instance).hasAutoDeleteWithinWipeout();
    }
    
    public boolean hasHasExplicitConsent() {
      return ((SemanticAnnotations.Qualifier)this.instance).hasHasExplicitConsent();
    }
    
    public boolean hasIsAccessTarget() {
      return ((SemanticAnnotations.Qualifier)this.instance).hasIsAccessTarget();
    }
    
    public boolean hasIsEncrypted() {
      return ((SemanticAnnotations.Qualifier)this.instance).hasIsEncrypted();
    }
    
    public boolean hasIsGoogle() {
      return ((SemanticAnnotations.Qualifier)this.instance).hasIsGoogle();
    }
    
    public boolean hasIsPartner() {
      return ((SemanticAnnotations.Qualifier)this.instance).hasIsPartner();
    }
    
    public boolean hasIsPublic() {
      return ((SemanticAnnotations.Qualifier)this.instance).hasIsPublic();
    }
    
    public boolean hasIsPublisher() {
      return ((SemanticAnnotations.Qualifier)this.instance).hasIsPublisher();
    }
    
    public boolean hasLimitedAccess() {
      return ((SemanticAnnotations.Qualifier)this.instance).hasLimitedAccess();
    }
    
    public boolean hasNonUserLocation() {
      return ((SemanticAnnotations.Qualifier)this.instance).hasNonUserLocation();
    }
    
    public boolean hasOtherUser() {
      return ((SemanticAnnotations.Qualifier)this.instance).hasOtherUser();
    }
    
    public boolean hasRelatedField() {
      return ((SemanticAnnotations.Qualifier)this.instance).hasRelatedField();
    }
    
    public Builder setAutoDeleteWithin180Days(boolean param1Boolean) {
      copyOnWrite();
      ((SemanticAnnotations.Qualifier)this.instance).setAutoDeleteWithin180Days(param1Boolean);
      return this;
    }
    
    public Builder setAutoDeleteWithinWipeout(boolean param1Boolean) {
      copyOnWrite();
      ((SemanticAnnotations.Qualifier)this.instance).setAutoDeleteWithinWipeout(param1Boolean);
      return this;
    }
    
    public Builder setHasExplicitConsent(boolean param1Boolean) {
      copyOnWrite();
      ((SemanticAnnotations.Qualifier)this.instance).setHasExplicitConsent(param1Boolean);
      return this;
    }
    
    public Builder setIsAccessTarget(boolean param1Boolean) {
      copyOnWrite();
      ((SemanticAnnotations.Qualifier)this.instance).setIsAccessTarget(param1Boolean);
      return this;
    }
    
    public Builder setIsEncrypted(boolean param1Boolean) {
      copyOnWrite();
      ((SemanticAnnotations.Qualifier)this.instance).setIsEncrypted(param1Boolean);
      return this;
    }
    
    public Builder setIsGoogle(boolean param1Boolean) {
      copyOnWrite();
      ((SemanticAnnotations.Qualifier)this.instance).setIsGoogle(param1Boolean);
      return this;
    }
    
    public Builder setIsPartner(boolean param1Boolean) {
      copyOnWrite();
      ((SemanticAnnotations.Qualifier)this.instance).setIsPartner(param1Boolean);
      return this;
    }
    
    public Builder setIsPublic(boolean param1Boolean) {
      copyOnWrite();
      ((SemanticAnnotations.Qualifier)this.instance).setIsPublic(param1Boolean);
      return this;
    }
    
    public Builder setIsPublisher(boolean param1Boolean) {
      copyOnWrite();
      ((SemanticAnnotations.Qualifier)this.instance).setIsPublisher(param1Boolean);
      return this;
    }
    
    public Builder setLimitedAccess(boolean param1Boolean) {
      copyOnWrite();
      ((SemanticAnnotations.Qualifier)this.instance).setLimitedAccess(param1Boolean);
      return this;
    }
    
    public Builder setNonUserLocation(boolean param1Boolean) {
      copyOnWrite();
      ((SemanticAnnotations.Qualifier)this.instance).setNonUserLocation(param1Boolean);
      return this;
    }
    
    public Builder setOtherUser(boolean param1Boolean) {
      copyOnWrite();
      ((SemanticAnnotations.Qualifier)this.instance).setOtherUser(param1Boolean);
      return this;
    }
    
    public Builder setRelatedField(int param1Int) {
      copyOnWrite();
      ((SemanticAnnotations.Qualifier)this.instance).setRelatedField(param1Int);
      return this;
    }
  }
  
  public static interface QualifierOrBuilder extends MessageLiteOrBuilder {
    boolean getAutoDeleteWithin180Days();
    
    boolean getAutoDeleteWithinWipeout();
    
    boolean getHasExplicitConsent();
    
    boolean getIsAccessTarget();
    
    boolean getIsEncrypted();
    
    boolean getIsGoogle();
    
    boolean getIsPartner();
    
    boolean getIsPublic();
    
    boolean getIsPublisher();
    
    boolean getLimitedAccess();
    
    boolean getNonUserLocation();
    
    boolean getOtherUser();
    
    int getRelatedField();
    
    boolean hasAutoDeleteWithin180Days();
    
    boolean hasAutoDeleteWithinWipeout();
    
    boolean hasHasExplicitConsent();
    
    boolean hasIsAccessTarget();
    
    boolean hasIsEncrypted();
    
    boolean hasIsGoogle();
    
    boolean hasIsPartner();
    
    boolean hasIsPublic();
    
    boolean hasIsPublisher();
    
    boolean hasLimitedAccess();
    
    boolean hasNonUserLocation();
    
    boolean hasOtherUser();
    
    boolean hasRelatedField();
  }
  
  public enum SemanticType implements Internal.EnumLite {
    ST_ACCOUNT_CREDENTIAL(0),
    ST_ACSA_ID(0),
    ST_ANALYTICS_ID(0),
    ST_ANDROID_LOGGING_ID(0),
    ST_ANDROID_LOGGING_ID2(0),
    ST_ANONYMOUS_DATA(0),
    ST_ARES_ID(0),
    ST_AVOCADO_ID(0),
    ST_BISCOTTI_ID(0),
    ST_CARDHOLDER_DATA(0),
    ST_CHD_INFO(0),
    ST_CHD_PAN(0),
    ST_COARSE_LOCATION(0),
    ST_CONTENT_DEPENDENT(0),
    ST_CRITICAL_PAYMENT_INFO(0),
    ST_CUSTOMER_ID(0),
    ST_DEBUG_INFO(0),
    ST_DEMOGRAPHIC_INFO(0),
    ST_EMAIL_ID(0),
    ST_GAIA_ID(0),
    ST_GOOGLE_RELATIONSHIP_ID(0),
    ST_GOVERNMENT_ID_NUMBER(0),
    ST_GSERVICES_ANDROID_ID(0),
    ST_HARDWARE_ID(0),
    ST_HEALTHCARE_INFO(0),
    ST_HERREVAD_ID(0),
    ST_IDENTIFYING_ID(0),
    ST_IP_ADDRESS(0),
    ST_KEY(0),
    ST_KEY_VALUE_PAIR(0),
    ST_LIMITED_USE_PAYMENTS_INFO(0),
    ST_LOCATION(0),
    ST_MANDELBREAD_ID(0),
    ST_MEDICAL_RECORD_NUMBER(0),
    ST_NAME(0),
    ST_NETWORK_ENDPOINT(0),
    ST_NOT_REQUIRED(0),
    ST_NOT_SPECIFIED(0),
    ST_PARTNER_ID(0),
    ST_PAYMENTS_INFO(0),
    ST_PAYMENTS_PCI_SAD(0),
    ST_PAYMENTS_TRANSACTION_INFO(0),
    ST_PAYMENT_ID(0),
    ST_PERSONAL_DATA(0),
    ST_PHONE_NUMBER(0),
    ST_PRECISE_LOCATION(0),
    ST_PREF_ID(0),
    ST_PSEUDONYMOUS_ID(0),
    ST_PUBLISHER_ID(0),
    ST_REFERER_URL(0),
    ST_SECURITY_KEY(0),
    ST_SECURITY_MATERIAL(0),
    ST_SENSITIVE_BACKGROUND_INFO(0),
    ST_SENSITIVE_TIMESTAMP(0),
    ST_SESSION_ID(0),
    ST_SOFTWARE_ID(0),
    ST_SPII_ID(0),
    ST_THIRD_PARTY_DATA(0),
    ST_TIMESTAMP(0),
    ST_USERNAME(0),
    ST_USER_AGENT(0),
    ST_USER_CONTENT(0),
    ST_USER_QUERY(0),
    ST_VALUE(0),
    ST_ZWIEBACK_ID(0);
    
    public static final int ST_ACCOUNT_CREDENTIAL_VALUE = 2602;
    
    public static final int ST_ACSA_ID_VALUE = 1007;
    
    public static final int ST_ANALYTICS_ID_VALUE = 1004;
    
    public static final int ST_ANDROID_LOGGING_ID2_VALUE = 1006;
    
    public static final int ST_ANDROID_LOGGING_ID_VALUE = 1401;
    
    public static final int ST_ANONYMOUS_DATA_VALUE = 1600;
    
    public static final int ST_ARES_ID_VALUE = 1108;
    
    public static final int ST_AVOCADO_ID_VALUE = 2500;
    
    public static final int ST_BISCOTTI_ID_VALUE = 1003;
    
    public static final int ST_CARDHOLDER_DATA_VALUE = 1202;
    
    public static final int ST_CHD_INFO_VALUE = 1212;
    
    public static final int ST_CHD_PAN_VALUE = 1211;
    
    public static final int ST_COARSE_LOCATION_VALUE = 1702;
    
    public static final int ST_CONTENT_DEPENDENT_VALUE = 9900;
    
    public static final int ST_CRITICAL_PAYMENT_INFO_VALUE = 1221;
    
    public static final int ST_CUSTOMER_ID_VALUE = 1801;
    
    public static final int ST_DEBUG_INFO_VALUE = 9901;
    
    public static final int ST_DEMOGRAPHIC_INFO_VALUE = 1601;
    
    public static final int ST_EMAIL_ID_VALUE = 1102;
    
    public static final int ST_GAIA_ID_VALUE = 1105;
    
    public static final int ST_GOOGLE_RELATIONSHIP_ID_VALUE = 1800;
    
    public static final int ST_GOVERNMENT_ID_NUMBER_VALUE = 1201;
    
    public static final int ST_GSERVICES_ANDROID_ID_VALUE = 1107;
    
    public static final int ST_HARDWARE_ID_VALUE = 1400;
    
    public static final int ST_HEALTHCARE_INFO_VALUE = 1203;
    
    public static final int ST_HERREVAD_ID_VALUE = 1008;
    
    public static final int ST_IDENTIFYING_ID_VALUE = 1100;
    
    public static final int ST_IP_ADDRESS_VALUE = 1301;
    
    public static final int ST_KEY_VALUE = 9903;
    
    public static final int ST_KEY_VALUE_PAIR_VALUE = 9902;
    
    public static final int ST_LIMITED_USE_PAYMENTS_INFO_VALUE = 1223;
    
    public static final int ST_LOCATION_VALUE = 1700;
    
    public static final int ST_MANDELBREAD_ID_VALUE = 1005;
    
    public static final int ST_MEDICAL_RECORD_NUMBER_VALUE = 1109;
    
    public static final int ST_NAME_VALUE = 1103;
    
    public static final int ST_NETWORK_ENDPOINT_VALUE = 1300;
    
    public static final int ST_NOT_REQUIRED_VALUE = 999;
    
    public static final int ST_NOT_SPECIFIED_VALUE = 0;
    
    public static final int ST_PARTNER_ID_VALUE = 1802;
    
    public static final int ST_PAYMENTS_INFO_VALUE = 1220;
    
    public static final int ST_PAYMENTS_PCI_SAD_VALUE = 2603;
    
    public static final int ST_PAYMENTS_TRANSACTION_INFO_VALUE = 1240;
    
    public static final int ST_PAYMENT_ID_VALUE = 1222;
    
    public static final int ST_PERSONAL_DATA_VALUE = 2400;
    
    public static final int ST_PHONE_NUMBER_VALUE = 1104;
    
    public static final int ST_PRECISE_LOCATION_VALUE = 1701;
    
    public static final int ST_PREF_ID_VALUE = 1002;
    
    public static final int ST_PSEUDONYMOUS_ID_VALUE = 1000;
    
    public static final int ST_PUBLISHER_ID_VALUE = 1803;
    
    public static final int ST_REFERER_URL_VALUE = 9905;
    
    public static final int ST_SECURITY_KEY_VALUE = 2601;
    
    public static final int ST_SECURITY_MATERIAL_VALUE = 2600;
    
    public static final int ST_SENSITIVE_BACKGROUND_INFO_VALUE = 1204;
    
    public static final int ST_SENSITIVE_TIMESTAMP_VALUE = 2101;
    
    public static final int ST_SESSION_ID_VALUE = 2300;
    
    public static final int ST_SOFTWARE_ID_VALUE = 1500;
    
    public static final int ST_SPII_ID_VALUE = 1200;
    
    public static final int ST_THIRD_PARTY_DATA_VALUE = 2000;
    
    public static final int ST_TIMESTAMP_VALUE = 2100;
    
    public static final int ST_USERNAME_VALUE = 1106;
    
    public static final int ST_USER_AGENT_VALUE = 1501;
    
    public static final int ST_USER_CONTENT_VALUE = 1900;
    
    public static final int ST_USER_QUERY_VALUE = 1901;
    
    public static final int ST_VALUE_VALUE = 9904;
    
    public static final int ST_ZWIEBACK_ID_VALUE = 1001;
    
    private static final Internal.EnumLiteMap<SemanticType> internalValueMap;
    
    private final int value;
    
    static {
      ST_PREF_ID = new SemanticType("ST_PREF_ID", 4, 1002);
      ST_BISCOTTI_ID = new SemanticType("ST_BISCOTTI_ID", 5, 1003);
      ST_ANALYTICS_ID = new SemanticType("ST_ANALYTICS_ID", 6, 1004);
      ST_MANDELBREAD_ID = new SemanticType("ST_MANDELBREAD_ID", 7, 1005);
      ST_ANDROID_LOGGING_ID2 = new SemanticType("ST_ANDROID_LOGGING_ID2", 8, 1006);
      ST_ACSA_ID = new SemanticType("ST_ACSA_ID", 9, 1007);
      ST_HERREVAD_ID = new SemanticType("ST_HERREVAD_ID", 10, 1008);
      ST_IDENTIFYING_ID = new SemanticType("ST_IDENTIFYING_ID", 11, 1100);
      ST_EMAIL_ID = new SemanticType("ST_EMAIL_ID", 12, 1102);
      ST_NAME = new SemanticType("ST_NAME", 13, 1103);
      ST_PHONE_NUMBER = new SemanticType("ST_PHONE_NUMBER", 14, 1104);
      ST_GAIA_ID = new SemanticType("ST_GAIA_ID", 15, 1105);
      ST_USERNAME = new SemanticType("ST_USERNAME", 16, 1106);
      ST_GSERVICES_ANDROID_ID = new SemanticType("ST_GSERVICES_ANDROID_ID", 17, 1107);
      ST_ARES_ID = new SemanticType("ST_ARES_ID", 18, 1108);
      ST_MEDICAL_RECORD_NUMBER = new SemanticType("ST_MEDICAL_RECORD_NUMBER", 19, 1109);
      ST_SPII_ID = new SemanticType("ST_SPII_ID", 20, 1200);
      ST_GOVERNMENT_ID_NUMBER = new SemanticType("ST_GOVERNMENT_ID_NUMBER", 21, 1201);
      ST_HEALTHCARE_INFO = new SemanticType("ST_HEALTHCARE_INFO", 22, 1203);
      ST_SENSITIVE_BACKGROUND_INFO = new SemanticType("ST_SENSITIVE_BACKGROUND_INFO", 23, 1204);
      ST_CARDHOLDER_DATA = new SemanticType("ST_CARDHOLDER_DATA", 24, 1202);
      ST_CHD_PAN = new SemanticType("ST_CHD_PAN", 25, 1211);
      ST_CHD_INFO = new SemanticType("ST_CHD_INFO", 26, 1212);
      ST_PAYMENTS_INFO = new SemanticType("ST_PAYMENTS_INFO", 27, 1220);
      ST_CRITICAL_PAYMENT_INFO = new SemanticType("ST_CRITICAL_PAYMENT_INFO", 28, 1221);
      ST_PAYMENT_ID = new SemanticType("ST_PAYMENT_ID", 29, 1222);
      ST_LIMITED_USE_PAYMENTS_INFO = new SemanticType("ST_LIMITED_USE_PAYMENTS_INFO", 30, 1223);
      ST_PAYMENTS_TRANSACTION_INFO = new SemanticType("ST_PAYMENTS_TRANSACTION_INFO", 31, 1240);
      ST_NETWORK_ENDPOINT = new SemanticType("ST_NETWORK_ENDPOINT", 32, 1300);
      ST_IP_ADDRESS = new SemanticType("ST_IP_ADDRESS", 33, 1301);
      ST_HARDWARE_ID = new SemanticType("ST_HARDWARE_ID", 34, 1400);
      ST_ANDROID_LOGGING_ID = new SemanticType("ST_ANDROID_LOGGING_ID", 35, 1401);
      ST_SOFTWARE_ID = new SemanticType("ST_SOFTWARE_ID", 36, 1500);
      ST_USER_AGENT = new SemanticType("ST_USER_AGENT", 37, 1501);
      ST_ANONYMOUS_DATA = new SemanticType("ST_ANONYMOUS_DATA", 38, 1600);
      ST_DEMOGRAPHIC_INFO = new SemanticType("ST_DEMOGRAPHIC_INFO", 39, 1601);
      ST_LOCATION = new SemanticType("ST_LOCATION", 40, 1700);
      ST_PRECISE_LOCATION = new SemanticType("ST_PRECISE_LOCATION", 41, 1701);
      ST_COARSE_LOCATION = new SemanticType("ST_COARSE_LOCATION", 42, 1702);
      ST_GOOGLE_RELATIONSHIP_ID = new SemanticType("ST_GOOGLE_RELATIONSHIP_ID", 43, 1800);
      ST_CUSTOMER_ID = new SemanticType("ST_CUSTOMER_ID", 44, 1801);
      ST_PARTNER_ID = new SemanticType("ST_PARTNER_ID", 45, 1802);
      ST_PUBLISHER_ID = new SemanticType("ST_PUBLISHER_ID", 46, 1803);
      ST_USER_CONTENT = new SemanticType("ST_USER_CONTENT", 47, 1900);
      ST_USER_QUERY = new SemanticType("ST_USER_QUERY", 48, 1901);
      ST_THIRD_PARTY_DATA = new SemanticType("ST_THIRD_PARTY_DATA", 49, 2000);
      ST_TIMESTAMP = new SemanticType("ST_TIMESTAMP", 50, 2100);
      ST_SENSITIVE_TIMESTAMP = new SemanticType("ST_SENSITIVE_TIMESTAMP", 51, 2101);
      ST_SESSION_ID = new SemanticType("ST_SESSION_ID", 52, 2300);
      ST_PERSONAL_DATA = new SemanticType("ST_PERSONAL_DATA", 53, 2400);
      ST_AVOCADO_ID = new SemanticType("ST_AVOCADO_ID", 54, 2500);
      ST_SECURITY_MATERIAL = new SemanticType("ST_SECURITY_MATERIAL", 55, 2600);
      ST_SECURITY_KEY = new SemanticType("ST_SECURITY_KEY", 56, 2601);
      ST_ACCOUNT_CREDENTIAL = new SemanticType("ST_ACCOUNT_CREDENTIAL", 57, 2602);
      ST_PAYMENTS_PCI_SAD = new SemanticType("ST_PAYMENTS_PCI_SAD", 58, 2603);
      ST_CONTENT_DEPENDENT = new SemanticType("ST_CONTENT_DEPENDENT", 59, 9900);
      ST_DEBUG_INFO = new SemanticType("ST_DEBUG_INFO", 60, 9901);
      ST_KEY_VALUE_PAIR = new SemanticType("ST_KEY_VALUE_PAIR", 61, 9902);
      ST_KEY = new SemanticType("ST_KEY", 62, 9903);
      ST_VALUE = new SemanticType("ST_VALUE", 63, 9904);
      ST_REFERER_URL = new SemanticType("ST_REFERER_URL", 64, 9905);
      $VALUES = new SemanticType[] { 
          ST_NOT_SPECIFIED, ST_NOT_REQUIRED, ST_PSEUDONYMOUS_ID, ST_ZWIEBACK_ID, ST_PREF_ID, ST_BISCOTTI_ID, ST_ANALYTICS_ID, ST_MANDELBREAD_ID, ST_ANDROID_LOGGING_ID2, ST_ACSA_ID, 
          ST_HERREVAD_ID, ST_IDENTIFYING_ID, ST_EMAIL_ID, ST_NAME, ST_PHONE_NUMBER, ST_GAIA_ID, ST_USERNAME, ST_GSERVICES_ANDROID_ID, ST_ARES_ID, ST_MEDICAL_RECORD_NUMBER, 
          ST_SPII_ID, ST_GOVERNMENT_ID_NUMBER, ST_HEALTHCARE_INFO, ST_SENSITIVE_BACKGROUND_INFO, ST_CARDHOLDER_DATA, ST_CHD_PAN, ST_CHD_INFO, ST_PAYMENTS_INFO, ST_CRITICAL_PAYMENT_INFO, ST_PAYMENT_ID, 
          ST_LIMITED_USE_PAYMENTS_INFO, ST_PAYMENTS_TRANSACTION_INFO, ST_NETWORK_ENDPOINT, ST_IP_ADDRESS, ST_HARDWARE_ID, ST_ANDROID_LOGGING_ID, ST_SOFTWARE_ID, ST_USER_AGENT, ST_ANONYMOUS_DATA, ST_DEMOGRAPHIC_INFO, 
          ST_LOCATION, ST_PRECISE_LOCATION, ST_COARSE_LOCATION, ST_GOOGLE_RELATIONSHIP_ID, ST_CUSTOMER_ID, ST_PARTNER_ID, ST_PUBLISHER_ID, ST_USER_CONTENT, ST_USER_QUERY, ST_THIRD_PARTY_DATA, 
          ST_TIMESTAMP, ST_SENSITIVE_TIMESTAMP, ST_SESSION_ID, ST_PERSONAL_DATA, ST_AVOCADO_ID, ST_SECURITY_MATERIAL, ST_SECURITY_KEY, ST_ACCOUNT_CREDENTIAL, ST_PAYMENTS_PCI_SAD, ST_CONTENT_DEPENDENT, 
          ST_DEBUG_INFO, ST_KEY_VALUE_PAIR, ST_KEY, ST_VALUE, ST_REFERER_URL };
      internalValueMap = new Internal.EnumLiteMap<SemanticType>() {
          public SemanticAnnotations.SemanticType findValueByNumber(int param2Int) {
            return SemanticAnnotations.SemanticType.forNumber(param2Int);
          }
        };
    }
    
    SemanticType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static SemanticType forNumber(int param1Int) {
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
                                                                  switch (param1Int) {
                                                                    default:
                                                                      return null;
                                                                    case 2500:
                                                                      return ST_AVOCADO_ID;
                                                                    case 2400:
                                                                      return ST_PERSONAL_DATA;
                                                                    case 2300:
                                                                      return ST_SESSION_ID;
                                                                    case 2000:
                                                                      return ST_THIRD_PARTY_DATA;
                                                                    case 1240:
                                                                      return ST_PAYMENTS_TRANSACTION_INFO;
                                                                    case 1100:
                                                                      return ST_IDENTIFYING_ID;
                                                                    case 0:
                                                                      break;
                                                                  } 
                                                                  return ST_NOT_SPECIFIED;
                                                                case 9905:
                                                                  return ST_REFERER_URL;
                                                                case 9904:
                                                                  return ST_VALUE;
                                                                case 9903:
                                                                  return ST_KEY;
                                                                case 9902:
                                                                  return ST_KEY_VALUE_PAIR;
                                                                case 9901:
                                                                  return ST_DEBUG_INFO;
                                                                case 9900:
                                                                  break;
                                                              } 
                                                              return ST_CONTENT_DEPENDENT;
                                                            case 2603:
                                                              return ST_PAYMENTS_PCI_SAD;
                                                            case 2602:
                                                              return ST_ACCOUNT_CREDENTIAL;
                                                            case 2601:
                                                              return ST_SECURITY_KEY;
                                                            case 2600:
                                                              break;
                                                          } 
                                                          return ST_SECURITY_MATERIAL;
                                                        case 2101:
                                                          return ST_SENSITIVE_TIMESTAMP;
                                                        case 2100:
                                                          break;
                                                      } 
                                                      return ST_TIMESTAMP;
                                                    case 1901:
                                                      return ST_USER_QUERY;
                                                    case 1900:
                                                      break;
                                                  } 
                                                  return ST_USER_CONTENT;
                                                case 1803:
                                                  return ST_PUBLISHER_ID;
                                                case 1802:
                                                  return ST_PARTNER_ID;
                                                case 1801:
                                                  return ST_CUSTOMER_ID;
                                                case 1800:
                                                  break;
                                              } 
                                              return ST_GOOGLE_RELATIONSHIP_ID;
                                            case 1702:
                                              return ST_COARSE_LOCATION;
                                            case 1701:
                                              return ST_PRECISE_LOCATION;
                                            case 1700:
                                              break;
                                          } 
                                          return ST_LOCATION;
                                        case 1601:
                                          return ST_DEMOGRAPHIC_INFO;
                                        case 1600:
                                          break;
                                      } 
                                      return ST_ANONYMOUS_DATA;
                                    case 1501:
                                      return ST_USER_AGENT;
                                    case 1500:
                                      break;
                                  } 
                                  return ST_SOFTWARE_ID;
                                case 1401:
                                  return ST_ANDROID_LOGGING_ID;
                                case 1400:
                                  break;
                              } 
                              return ST_HARDWARE_ID;
                            case 1301:
                              return ST_IP_ADDRESS;
                            case 1300:
                              break;
                          } 
                          return ST_NETWORK_ENDPOINT;
                        case 1223:
                          return ST_LIMITED_USE_PAYMENTS_INFO;
                        case 1222:
                          return ST_PAYMENT_ID;
                        case 1221:
                          return ST_CRITICAL_PAYMENT_INFO;
                        case 1220:
                          break;
                      } 
                      return ST_PAYMENTS_INFO;
                    case 1212:
                      return ST_CHD_INFO;
                    case 1211:
                      break;
                  } 
                  return ST_CHD_PAN;
                case 1204:
                  return ST_SENSITIVE_BACKGROUND_INFO;
                case 1203:
                  return ST_HEALTHCARE_INFO;
                case 1202:
                  return ST_CARDHOLDER_DATA;
                case 1201:
                  return ST_GOVERNMENT_ID_NUMBER;
                case 1200:
                  break;
              } 
              return ST_SPII_ID;
            case 1109:
              return ST_MEDICAL_RECORD_NUMBER;
            case 1108:
              return ST_ARES_ID;
            case 1107:
              return ST_GSERVICES_ANDROID_ID;
            case 1106:
              return ST_USERNAME;
            case 1105:
              return ST_GAIA_ID;
            case 1104:
              return ST_PHONE_NUMBER;
            case 1103:
              return ST_NAME;
            case 1102:
              break;
          } 
          return ST_EMAIL_ID;
        case 1008:
          return ST_HERREVAD_ID;
        case 1007:
          return ST_ACSA_ID;
        case 1006:
          return ST_ANDROID_LOGGING_ID2;
        case 1005:
          return ST_MANDELBREAD_ID;
        case 1004:
          return ST_ANALYTICS_ID;
        case 1003:
          return ST_BISCOTTI_ID;
        case 1002:
          return ST_PREF_ID;
        case 1001:
          return ST_ZWIEBACK_ID;
        case 1000:
          return ST_PSEUDONYMOUS_ID;
        case 999:
          break;
      } 
      return ST_NOT_REQUIRED;
    }
    
    public static Internal.EnumLiteMap<SemanticType> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<SemanticType> {
    public SemanticAnnotations.SemanticType findValueByNumber(int param1Int) {
      return SemanticAnnotations.SemanticType.forNumber(param1Int);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protos\datapol\SemanticAnnotations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */