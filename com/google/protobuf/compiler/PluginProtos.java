package com.google.protobuf.compiler;

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
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class PluginProtos {
  static {
  
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class CodeGeneratorRequest extends GeneratedMessageLite<CodeGeneratorRequest, CodeGeneratorRequest.Builder> implements CodeGeneratorRequestOrBuilder {
    public static final int COMPILER_VERSION_FIELD_NUMBER = 3;
    
    private static final CodeGeneratorRequest DEFAULT_INSTANCE = new CodeGeneratorRequest();
    
    public static final int FILE_TO_GENERATE_FIELD_NUMBER = 1;
    
    public static final int PARAMETER_FIELD_NUMBER = 2;
    
    private static volatile Parser<CodeGeneratorRequest> PARSER;
    
    public static final int PROTO_FILE_FIELD_NUMBER = 15;
    
    private int bitField0_;
    
    private PluginProtos.Version compilerVersion_;
    
    private Internal.ProtobufList<String> fileToGenerate_ = GeneratedMessageLite.emptyProtobufList();
    
    private byte memoizedIsInitialized = (byte)-1;
    
    private String parameter_ = "";
    
    private Internal.ProtobufList<DescriptorProtos.FileDescriptorProto> protoFile_ = emptyProtobufList();
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllFileToGenerate(Iterable<String> param1Iterable) {
      ensureFileToGenerateIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.fileToGenerate_);
    }
    
    private void addAllProtoFile(Iterable<? extends DescriptorProtos.FileDescriptorProto> param1Iterable) {
      ensureProtoFileIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.protoFile_);
    }
    
    private void addFileToGenerate(String param1String) {
      if (param1String != null) {
        ensureFileToGenerateIsMutable();
        this.fileToGenerate_.add(param1String);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addFileToGenerateBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ensureFileToGenerateIsMutable();
        this.fileToGenerate_.add(param1ByteString.toStringUtf8());
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addProtoFile(int param1Int, DescriptorProtos.FileDescriptorProto.Builder param1Builder) {
      ensureProtoFileIsMutable();
      this.protoFile_.add(param1Int, param1Builder.build());
    }
    
    private void addProtoFile(int param1Int, DescriptorProtos.FileDescriptorProto param1FileDescriptorProto) {
      if (param1FileDescriptorProto != null) {
        ensureProtoFileIsMutable();
        this.protoFile_.add(param1Int, param1FileDescriptorProto);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addProtoFile(DescriptorProtos.FileDescriptorProto.Builder param1Builder) {
      ensureProtoFileIsMutable();
      this.protoFile_.add(param1Builder.build());
    }
    
    private void addProtoFile(DescriptorProtos.FileDescriptorProto param1FileDescriptorProto) {
      if (param1FileDescriptorProto != null) {
        ensureProtoFileIsMutable();
        this.protoFile_.add(param1FileDescriptorProto);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearCompilerVersion() {
      this.compilerVersion_ = null;
      this.bitField0_ &= 0xFFFFFFFD;
    }
    
    private void clearFileToGenerate() {
      this.fileToGenerate_ = GeneratedMessageLite.emptyProtobufList();
    }
    
    private void clearParameter() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.parameter_ = getDefaultInstance().getParameter();
    }
    
    private void clearProtoFile() {
      this.protoFile_ = emptyProtobufList();
    }
    
    private void ensureFileToGenerateIsMutable() {
      if (!this.fileToGenerate_.isModifiable())
        this.fileToGenerate_ = GeneratedMessageLite.mutableCopy(this.fileToGenerate_); 
    }
    
    private void ensureProtoFileIsMutable() {
      if (!this.protoFile_.isModifiable())
        this.protoFile_ = GeneratedMessageLite.mutableCopy(this.protoFile_); 
    }
    
    public static CodeGeneratorRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeCompilerVersion(PluginProtos.Version param1Version) {
      PluginProtos.Version version = this.compilerVersion_;
      if (version != null && version != PluginProtos.Version.getDefaultInstance()) {
        this.compilerVersion_ = (PluginProtos.Version)((PluginProtos.Version.Builder)PluginProtos.Version.newBuilder(this.compilerVersion_).mergeFrom(param1Version)).buildPartial();
      } else {
        this.compilerVersion_ = param1Version;
      } 
      this.bitField0_ |= 0x2;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(CodeGeneratorRequest param1CodeGeneratorRequest) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1CodeGeneratorRequest);
    }
    
    public static CodeGeneratorRequest parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (CodeGeneratorRequest)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static CodeGeneratorRequest parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CodeGeneratorRequest)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static CodeGeneratorRequest parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (CodeGeneratorRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static CodeGeneratorRequest parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CodeGeneratorRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static CodeGeneratorRequest parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (CodeGeneratorRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static CodeGeneratorRequest parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CodeGeneratorRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static CodeGeneratorRequest parseFrom(InputStream param1InputStream) throws IOException {
      return (CodeGeneratorRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static CodeGeneratorRequest parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CodeGeneratorRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static CodeGeneratorRequest parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (CodeGeneratorRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static CodeGeneratorRequest parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CodeGeneratorRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<CodeGeneratorRequest> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeProtoFile(int param1Int) {
      ensureProtoFileIsMutable();
      this.protoFile_.remove(param1Int);
    }
    
    private void setCompilerVersion(PluginProtos.Version.Builder param1Builder) {
      this.compilerVersion_ = (PluginProtos.Version)param1Builder.build();
      this.bitField0_ |= 0x2;
    }
    
    private void setCompilerVersion(PluginProtos.Version param1Version) {
      if (param1Version != null) {
        this.compilerVersion_ = param1Version;
        this.bitField0_ |= 0x2;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setFileToGenerate(int param1Int, String param1String) {
      if (param1String != null) {
        ensureFileToGenerateIsMutable();
        this.fileToGenerate_.set(param1Int, param1String);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setParameter(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x1;
        this.parameter_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setParameterBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x1;
        this.parameter_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setProtoFile(int param1Int, DescriptorProtos.FileDescriptorProto.Builder param1Builder) {
      ensureProtoFileIsMutable();
      this.protoFile_.set(param1Int, param1Builder.build());
    }
    
    private void setProtoFile(int param1Int, DescriptorProtos.FileDescriptorProto param1FileDescriptorProto) {
      if (param1FileDescriptorProto != null) {
        ensureProtoFileIsMutable();
        this.protoFile_.set(param1Int, param1FileDescriptorProto);
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/protobuf/compiler/PluginProtos$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: istore #4
      //   10: iconst_0
      //   11: istore #5
      //   13: iload #4
      //   15: tableswitch default -> 60, 1 -> 668, 2 -> 578, 3 -> 558, 4 -> 549, 5 -> 434, 6 -> 114, 7 -> 430, 8 -> 68
      //   60: new java/lang/UnsupportedOperationException
      //   63: dup
      //   64: invokespecial <init> : ()V
      //   67: athrow
      //   68: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest.PARSER : Lcom/google/protobuf/Parser;
      //   71: ifnonnull -> 110
      //   74: ldc com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest
      //   76: monitorenter
      //   77: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest.PARSER : Lcom/google/protobuf/Parser;
      //   80: ifnonnull -> 98
      //   83: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   86: astore_1
      //   87: aload_1
      //   88: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest;
      //   91: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   94: aload_1
      //   95: putstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest.PARSER : Lcom/google/protobuf/Parser;
      //   98: ldc com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest
      //   100: monitorexit
      //   101: goto -> 110
      //   104: astore_1
      //   105: ldc com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest
      //   107: monitorexit
      //   108: aload_1
      //   109: athrow
      //   110: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest.PARSER : Lcom/google/protobuf/Parser;
      //   113: areturn
      //   114: aload_2
      //   115: checkcast com/google/protobuf/CodedInputStream
      //   118: astore_2
      //   119: aload_3
      //   120: checkcast com/google/protobuf/ExtensionRegistryLite
      //   123: astore_3
      //   124: iload #5
      //   126: ifne -> 430
      //   129: aload_2
      //   130: invokevirtual readTag : ()I
      //   133: istore #4
      //   135: iload #4
      //   137: ifeq -> 374
      //   140: iload #4
      //   142: bipush #10
      //   144: if_icmpeq -> 332
      //   147: iload #4
      //   149: bipush #18
      //   151: if_icmpeq -> 309
      //   154: iload #4
      //   156: bipush #26
      //   158: if_icmpeq -> 231
      //   161: iload #4
      //   163: bipush #122
      //   165: if_icmpeq -> 184
      //   168: aload_0
      //   169: iload #4
      //   171: aload_2
      //   172: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   175: ifne -> 124
      //   178: iconst_1
      //   179: istore #5
      //   181: goto -> 124
      //   184: aload_0
      //   185: getfield protoFile_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   188: invokeinterface isModifiable : ()Z
      //   193: ifne -> 207
      //   196: aload_0
      //   197: aload_0
      //   198: getfield protoFile_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   201: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   204: putfield protoFile_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   207: aload_0
      //   208: getfield protoFile_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   211: aload_2
      //   212: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   215: aload_3
      //   216: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   219: checkcast com/google/protobuf/DescriptorProtos$FileDescriptorProto
      //   222: invokeinterface add : (Ljava/lang/Object;)Z
      //   227: pop
      //   228: goto -> 124
      //   231: aload_0
      //   232: getfield bitField0_ : I
      //   235: iconst_2
      //   236: iand
      //   237: iconst_2
      //   238: if_icmpne -> 255
      //   241: aload_0
      //   242: getfield compilerVersion_ : Lcom/google/protobuf/compiler/PluginProtos$Version;
      //   245: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   248: checkcast com/google/protobuf/compiler/PluginProtos$Version$Builder
      //   251: astore_1
      //   252: goto -> 257
      //   255: aconst_null
      //   256: astore_1
      //   257: aload_0
      //   258: aload_2
      //   259: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   262: aload_3
      //   263: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   266: checkcast com/google/protobuf/compiler/PluginProtos$Version
      //   269: putfield compilerVersion_ : Lcom/google/protobuf/compiler/PluginProtos$Version;
      //   272: aload_1
      //   273: ifnull -> 296
      //   276: aload_1
      //   277: aload_0
      //   278: getfield compilerVersion_ : Lcom/google/protobuf/compiler/PluginProtos$Version;
      //   281: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   284: pop
      //   285: aload_0
      //   286: aload_1
      //   287: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   290: checkcast com/google/protobuf/compiler/PluginProtos$Version
      //   293: putfield compilerVersion_ : Lcom/google/protobuf/compiler/PluginProtos$Version;
      //   296: aload_0
      //   297: aload_0
      //   298: getfield bitField0_ : I
      //   301: iconst_2
      //   302: ior
      //   303: putfield bitField0_ : I
      //   306: goto -> 124
      //   309: aload_2
      //   310: invokevirtual readString : ()Ljava/lang/String;
      //   313: astore_1
      //   314: aload_0
      //   315: aload_0
      //   316: getfield bitField0_ : I
      //   319: iconst_1
      //   320: ior
      //   321: putfield bitField0_ : I
      //   324: aload_0
      //   325: aload_1
      //   326: putfield parameter_ : Ljava/lang/String;
      //   329: goto -> 124
      //   332: aload_2
      //   333: invokevirtual readString : ()Ljava/lang/String;
      //   336: astore_1
      //   337: aload_0
      //   338: getfield fileToGenerate_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   341: invokeinterface isModifiable : ()Z
      //   346: ifne -> 360
      //   349: aload_0
      //   350: aload_0
      //   351: getfield fileToGenerate_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   354: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   357: putfield fileToGenerate_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   360: aload_0
      //   361: getfield fileToGenerate_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   364: aload_1
      //   365: invokeinterface add : (Ljava/lang/Object;)Z
      //   370: pop
      //   371: goto -> 124
      //   374: iconst_1
      //   375: istore #5
      //   377: goto -> 124
      //   380: astore_1
      //   381: goto -> 428
      //   384: astore_1
      //   385: new java/lang/RuntimeException
      //   388: astore_2
      //   389: new com/google/protobuf/InvalidProtocolBufferException
      //   392: astore_3
      //   393: aload_3
      //   394: aload_1
      //   395: invokevirtual getMessage : ()Ljava/lang/String;
      //   398: invokespecial <init> : (Ljava/lang/String;)V
      //   401: aload_2
      //   402: aload_3
      //   403: aload_0
      //   404: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   407: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   410: aload_2
      //   411: athrow
      //   412: astore_1
      //   413: new java/lang/RuntimeException
      //   416: astore_2
      //   417: aload_2
      //   418: aload_1
      //   419: aload_0
      //   420: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   423: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   426: aload_2
      //   427: athrow
      //   428: aload_1
      //   429: athrow
      //   430: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest;
      //   433: areturn
      //   434: aload_2
      //   435: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   438: astore_1
      //   439: aload_3
      //   440: checkcast com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest
      //   443: astore_2
      //   444: aload_0
      //   445: aload_1
      //   446: aload_0
      //   447: getfield fileToGenerate_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   450: aload_2
      //   451: getfield fileToGenerate_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   454: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   459: putfield fileToGenerate_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   462: aload_0
      //   463: aload_1
      //   464: aload_0
      //   465: invokevirtual hasParameter : ()Z
      //   468: aload_0
      //   469: getfield parameter_ : Ljava/lang/String;
      //   472: aload_2
      //   473: invokevirtual hasParameter : ()Z
      //   476: aload_2
      //   477: getfield parameter_ : Ljava/lang/String;
      //   480: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   485: putfield parameter_ : Ljava/lang/String;
      //   488: aload_0
      //   489: aload_1
      //   490: aload_0
      //   491: getfield protoFile_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   494: aload_2
      //   495: getfield protoFile_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   498: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   503: putfield protoFile_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   506: aload_0
      //   507: aload_1
      //   508: aload_0
      //   509: getfield compilerVersion_ : Lcom/google/protobuf/compiler/PluginProtos$Version;
      //   512: aload_2
      //   513: getfield compilerVersion_ : Lcom/google/protobuf/compiler/PluginProtos$Version;
      //   516: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   521: checkcast com/google/protobuf/compiler/PluginProtos$Version
      //   524: putfield compilerVersion_ : Lcom/google/protobuf/compiler/PluginProtos$Version;
      //   527: aload_1
      //   528: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   531: if_acmpne -> 547
      //   534: aload_0
      //   535: aload_0
      //   536: getfield bitField0_ : I
      //   539: aload_2
      //   540: getfield bitField0_ : I
      //   543: ior
      //   544: putfield bitField0_ : I
      //   547: aload_0
      //   548: areturn
      //   549: new com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest$Builder
      //   552: dup
      //   553: aconst_null
      //   554: invokespecial <init> : (Lcom/google/protobuf/compiler/PluginProtos$1;)V
      //   557: areturn
      //   558: aload_0
      //   559: getfield fileToGenerate_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   562: invokeinterface makeImmutable : ()V
      //   567: aload_0
      //   568: getfield protoFile_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   571: invokeinterface makeImmutable : ()V
      //   576: aconst_null
      //   577: areturn
      //   578: aload_0
      //   579: getfield memoizedIsInitialized : B
      //   582: istore #5
      //   584: iload #5
      //   586: iconst_1
      //   587: if_icmpne -> 594
      //   590: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest;
      //   593: areturn
      //   594: iload #5
      //   596: ifne -> 601
      //   599: aconst_null
      //   600: areturn
      //   601: aload_2
      //   602: checkcast java/lang/Boolean
      //   605: invokevirtual booleanValue : ()Z
      //   608: istore #6
      //   610: iconst_0
      //   611: istore #5
      //   613: iload #5
      //   615: aload_0
      //   616: invokevirtual getProtoFileCount : ()I
      //   619: if_icmpge -> 653
      //   622: aload_0
      //   623: iload #5
      //   625: invokevirtual getProtoFile : (I)Lcom/google/protobuf/DescriptorProtos$FileDescriptorProto;
      //   628: invokevirtual isInitialized : ()Z
      //   631: ifne -> 647
      //   634: iload #6
      //   636: ifeq -> 645
      //   639: aload_0
      //   640: iconst_0
      //   641: i2b
      //   642: putfield memoizedIsInitialized : B
      //   645: aconst_null
      //   646: areturn
      //   647: iinc #5, 1
      //   650: goto -> 613
      //   653: iload #6
      //   655: ifeq -> 664
      //   658: aload_0
      //   659: iconst_1
      //   660: i2b
      //   661: putfield memoizedIsInitialized : B
      //   664: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest;
      //   667: areturn
      //   668: new com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest
      //   671: dup
      //   672: invokespecial <init> : ()V
      //   675: areturn
      // Exception table:
      //   from	to	target	type
      //   77	98	104	finally
      //   98	101	104	finally
      //   105	108	104	finally
      //   129	135	412	com/google/protobuf/InvalidProtocolBufferException
      //   129	135	384	java/io/IOException
      //   129	135	380	finally
      //   168	178	412	com/google/protobuf/InvalidProtocolBufferException
      //   168	178	384	java/io/IOException
      //   168	178	380	finally
      //   184	207	412	com/google/protobuf/InvalidProtocolBufferException
      //   184	207	384	java/io/IOException
      //   184	207	380	finally
      //   207	228	412	com/google/protobuf/InvalidProtocolBufferException
      //   207	228	384	java/io/IOException
      //   207	228	380	finally
      //   231	252	412	com/google/protobuf/InvalidProtocolBufferException
      //   231	252	384	java/io/IOException
      //   231	252	380	finally
      //   257	272	412	com/google/protobuf/InvalidProtocolBufferException
      //   257	272	384	java/io/IOException
      //   257	272	380	finally
      //   276	296	412	com/google/protobuf/InvalidProtocolBufferException
      //   276	296	384	java/io/IOException
      //   276	296	380	finally
      //   296	306	412	com/google/protobuf/InvalidProtocolBufferException
      //   296	306	384	java/io/IOException
      //   296	306	380	finally
      //   309	329	412	com/google/protobuf/InvalidProtocolBufferException
      //   309	329	384	java/io/IOException
      //   309	329	380	finally
      //   332	360	412	com/google/protobuf/InvalidProtocolBufferException
      //   332	360	384	java/io/IOException
      //   332	360	380	finally
      //   360	371	412	com/google/protobuf/InvalidProtocolBufferException
      //   360	371	384	java/io/IOException
      //   360	371	380	finally
      //   385	412	380	finally
      //   413	428	380	finally
    }
    
    public PluginProtos.Version getCompilerVersion() {
      PluginProtos.Version version1 = this.compilerVersion_;
      PluginProtos.Version version2 = version1;
      if (version1 == null)
        version2 = PluginProtos.Version.getDefaultInstance(); 
      return version2;
    }
    
    public String getFileToGenerate(int param1Int) {
      return (String)this.fileToGenerate_.get(param1Int);
    }
    
    public ByteString getFileToGenerateBytes(int param1Int) {
      return ByteString.copyFromUtf8((String)this.fileToGenerate_.get(param1Int));
    }
    
    public int getFileToGenerateCount() {
      return this.fileToGenerate_.size();
    }
    
    public List<String> getFileToGenerateList() {
      return (List<String>)this.fileToGenerate_;
    }
    
    public String getParameter() {
      return this.parameter_;
    }
    
    public ByteString getParameterBytes() {
      return ByteString.copyFromUtf8(this.parameter_);
    }
    
    public DescriptorProtos.FileDescriptorProto getProtoFile(int param1Int) {
      return (DescriptorProtos.FileDescriptorProto)this.protoFile_.get(param1Int);
    }
    
    public int getProtoFileCount() {
      return this.protoFile_.size();
    }
    
    public List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
      return (List<DescriptorProtos.FileDescriptorProto>)this.protoFile_;
    }
    
    public DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int param1Int) {
      return (DescriptorProtos.FileDescriptorProtoOrBuilder)this.protoFile_.get(param1Int);
    }
    
    public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList() {
      return (List)this.protoFile_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      byte b1 = 0;
      i = 0;
      int j = 0;
      while (i < this.fileToGenerate_.size()) {
        j += CodedOutputStream.computeStringSizeNoTag((String)this.fileToGenerate_.get(i));
        i++;
      } 
      j = j + 0 + getFileToGenerateList().size() * 1;
      i = j;
      if ((this.bitField0_ & 0x1) == 1)
        i = j + CodedOutputStream.computeStringSize(2, getParameter()); 
      byte b2 = b1;
      j = i;
      if ((this.bitField0_ & 0x2) == 2) {
        j = i + CodedOutputStream.computeMessageSize(3, (MessageLite)getCompilerVersion());
        b2 = b1;
      } 
      while (b2 < this.protoFile_.size()) {
        j += CodedOutputStream.computeMessageSize(15, (MessageLite)this.protoFile_.get(b2));
        b2++;
      } 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasCompilerVersion() {
      boolean bool;
      if ((this.bitField0_ & 0x2) == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasParameter() {
      int i = this.bitField0_;
      boolean bool = true;
      if ((i & 0x1) != 1)
        bool = false; 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      boolean bool = false;
      byte b;
      for (b = 0; b < this.fileToGenerate_.size(); b++)
        param1CodedOutputStream.writeString(1, (String)this.fileToGenerate_.get(b)); 
      if ((this.bitField0_ & 0x1) == 1)
        param1CodedOutputStream.writeString(2, getParameter()); 
      b = bool;
      if ((this.bitField0_ & 0x2) == 2) {
        param1CodedOutputStream.writeMessage(3, (MessageLite)getCompilerVersion());
        b = bool;
      } 
      while (b < this.protoFile_.size()) {
        param1CodedOutputStream.writeMessage(15, (MessageLite)this.protoFile_.get(b));
        b++;
      } 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<CodeGeneratorRequest, Builder> implements PluginProtos.CodeGeneratorRequestOrBuilder {
      private Builder() {
        super(PluginProtos.CodeGeneratorRequest.DEFAULT_INSTANCE);
      }
      
      public Builder addAllFileToGenerate(Iterable<String> param2Iterable) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).addAllFileToGenerate(param2Iterable);
        return this;
      }
      
      public Builder addAllProtoFile(Iterable<? extends DescriptorProtos.FileDescriptorProto> param2Iterable) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).addAllProtoFile(param2Iterable);
        return this;
      }
      
      public Builder addFileToGenerate(String param2String) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).addFileToGenerate(param2String);
        return this;
      }
      
      public Builder addFileToGenerateBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).addFileToGenerateBytes(param2ByteString);
        return this;
      }
      
      public Builder addProtoFile(int param2Int, DescriptorProtos.FileDescriptorProto.Builder param2Builder) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).addProtoFile(param2Int, param2Builder);
        return this;
      }
      
      public Builder addProtoFile(int param2Int, DescriptorProtos.FileDescriptorProto param2FileDescriptorProto) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).addProtoFile(param2Int, param2FileDescriptorProto);
        return this;
      }
      
      public Builder addProtoFile(DescriptorProtos.FileDescriptorProto.Builder param2Builder) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).addProtoFile(param2Builder);
        return this;
      }
      
      public Builder addProtoFile(DescriptorProtos.FileDescriptorProto param2FileDescriptorProto) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).addProtoFile(param2FileDescriptorProto);
        return this;
      }
      
      public Builder clearCompilerVersion() {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).clearCompilerVersion();
        return this;
      }
      
      public Builder clearFileToGenerate() {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).clearFileToGenerate();
        return this;
      }
      
      public Builder clearParameter() {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).clearParameter();
        return this;
      }
      
      public Builder clearProtoFile() {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).clearProtoFile();
        return this;
      }
      
      public PluginProtos.Version getCompilerVersion() {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).getCompilerVersion();
      }
      
      public String getFileToGenerate(int param2Int) {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).getFileToGenerate(param2Int);
      }
      
      public ByteString getFileToGenerateBytes(int param2Int) {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).getFileToGenerateBytes(param2Int);
      }
      
      public int getFileToGenerateCount() {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).getFileToGenerateCount();
      }
      
      public List<String> getFileToGenerateList() {
        return Collections.unmodifiableList(((PluginProtos.CodeGeneratorRequest)this.instance).getFileToGenerateList());
      }
      
      public String getParameter() {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).getParameter();
      }
      
      public ByteString getParameterBytes() {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).getParameterBytes();
      }
      
      public DescriptorProtos.FileDescriptorProto getProtoFile(int param2Int) {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).getProtoFile(param2Int);
      }
      
      public int getProtoFileCount() {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).getProtoFileCount();
      }
      
      public List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
        return Collections.unmodifiableList(((PluginProtos.CodeGeneratorRequest)this.instance).getProtoFileList());
      }
      
      public boolean hasCompilerVersion() {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).hasCompilerVersion();
      }
      
      public boolean hasParameter() {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).hasParameter();
      }
      
      public Builder mergeCompilerVersion(PluginProtos.Version param2Version) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).mergeCompilerVersion(param2Version);
        return this;
      }
      
      public Builder removeProtoFile(int param2Int) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).removeProtoFile(param2Int);
        return this;
      }
      
      public Builder setCompilerVersion(PluginProtos.Version.Builder param2Builder) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).setCompilerVersion(param2Builder);
        return this;
      }
      
      public Builder setCompilerVersion(PluginProtos.Version param2Version) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).setCompilerVersion(param2Version);
        return this;
      }
      
      public Builder setFileToGenerate(int param2Int, String param2String) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).setFileToGenerate(param2Int, param2String);
        return this;
      }
      
      public Builder setParameter(String param2String) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).setParameter(param2String);
        return this;
      }
      
      public Builder setParameterBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).setParameterBytes(param2ByteString);
        return this;
      }
      
      public Builder setProtoFile(int param2Int, DescriptorProtos.FileDescriptorProto.Builder param2Builder) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).setProtoFile(param2Int, param2Builder);
        return this;
      }
      
      public Builder setProtoFile(int param2Int, DescriptorProtos.FileDescriptorProto param2FileDescriptorProto) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).setProtoFile(param2Int, param2FileDescriptorProto);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<CodeGeneratorRequest, CodeGeneratorRequest.Builder> implements CodeGeneratorRequestOrBuilder {
    private Builder() {
      super(PluginProtos.CodeGeneratorRequest.DEFAULT_INSTANCE);
    }
    
    public Builder addAllFileToGenerate(Iterable<String> param1Iterable) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).addAllFileToGenerate(param1Iterable);
      return this;
    }
    
    public Builder addAllProtoFile(Iterable<? extends DescriptorProtos.FileDescriptorProto> param1Iterable) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).addAllProtoFile(param1Iterable);
      return this;
    }
    
    public Builder addFileToGenerate(String param1String) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).addFileToGenerate(param1String);
      return this;
    }
    
    public Builder addFileToGenerateBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).addFileToGenerateBytes(param1ByteString);
      return this;
    }
    
    public Builder addProtoFile(int param1Int, DescriptorProtos.FileDescriptorProto.Builder param1Builder) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).addProtoFile(param1Int, param1Builder);
      return this;
    }
    
    public Builder addProtoFile(int param1Int, DescriptorProtos.FileDescriptorProto param1FileDescriptorProto) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).addProtoFile(param1Int, param1FileDescriptorProto);
      return this;
    }
    
    public Builder addProtoFile(DescriptorProtos.FileDescriptorProto.Builder param1Builder) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).addProtoFile(param1Builder);
      return this;
    }
    
    public Builder addProtoFile(DescriptorProtos.FileDescriptorProto param1FileDescriptorProto) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).addProtoFile(param1FileDescriptorProto);
      return this;
    }
    
    public Builder clearCompilerVersion() {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).clearCompilerVersion();
      return this;
    }
    
    public Builder clearFileToGenerate() {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).clearFileToGenerate();
      return this;
    }
    
    public Builder clearParameter() {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).clearParameter();
      return this;
    }
    
    public Builder clearProtoFile() {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).clearProtoFile();
      return this;
    }
    
    public PluginProtos.Version getCompilerVersion() {
      return ((PluginProtos.CodeGeneratorRequest)this.instance).getCompilerVersion();
    }
    
    public String getFileToGenerate(int param1Int) {
      return ((PluginProtos.CodeGeneratorRequest)this.instance).getFileToGenerate(param1Int);
    }
    
    public ByteString getFileToGenerateBytes(int param1Int) {
      return ((PluginProtos.CodeGeneratorRequest)this.instance).getFileToGenerateBytes(param1Int);
    }
    
    public int getFileToGenerateCount() {
      return ((PluginProtos.CodeGeneratorRequest)this.instance).getFileToGenerateCount();
    }
    
    public List<String> getFileToGenerateList() {
      return Collections.unmodifiableList(((PluginProtos.CodeGeneratorRequest)this.instance).getFileToGenerateList());
    }
    
    public String getParameter() {
      return ((PluginProtos.CodeGeneratorRequest)this.instance).getParameter();
    }
    
    public ByteString getParameterBytes() {
      return ((PluginProtos.CodeGeneratorRequest)this.instance).getParameterBytes();
    }
    
    public DescriptorProtos.FileDescriptorProto getProtoFile(int param1Int) {
      return ((PluginProtos.CodeGeneratorRequest)this.instance).getProtoFile(param1Int);
    }
    
    public int getProtoFileCount() {
      return ((PluginProtos.CodeGeneratorRequest)this.instance).getProtoFileCount();
    }
    
    public List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
      return Collections.unmodifiableList(((PluginProtos.CodeGeneratorRequest)this.instance).getProtoFileList());
    }
    
    public boolean hasCompilerVersion() {
      return ((PluginProtos.CodeGeneratorRequest)this.instance).hasCompilerVersion();
    }
    
    public boolean hasParameter() {
      return ((PluginProtos.CodeGeneratorRequest)this.instance).hasParameter();
    }
    
    public Builder mergeCompilerVersion(PluginProtos.Version param1Version) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).mergeCompilerVersion(param1Version);
      return this;
    }
    
    public Builder removeProtoFile(int param1Int) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).removeProtoFile(param1Int);
      return this;
    }
    
    public Builder setCompilerVersion(PluginProtos.Version.Builder param1Builder) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).setCompilerVersion(param1Builder);
      return this;
    }
    
    public Builder setCompilerVersion(PluginProtos.Version param1Version) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).setCompilerVersion(param1Version);
      return this;
    }
    
    public Builder setFileToGenerate(int param1Int, String param1String) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).setFileToGenerate(param1Int, param1String);
      return this;
    }
    
    public Builder setParameter(String param1String) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).setParameter(param1String);
      return this;
    }
    
    public Builder setParameterBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).setParameterBytes(param1ByteString);
      return this;
    }
    
    public Builder setProtoFile(int param1Int, DescriptorProtos.FileDescriptorProto.Builder param1Builder) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).setProtoFile(param1Int, param1Builder);
      return this;
    }
    
    public Builder setProtoFile(int param1Int, DescriptorProtos.FileDescriptorProto param1FileDescriptorProto) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).setProtoFile(param1Int, param1FileDescriptorProto);
      return this;
    }
  }
  
  public static interface CodeGeneratorRequestOrBuilder extends MessageLiteOrBuilder {
    PluginProtos.Version getCompilerVersion();
    
    String getFileToGenerate(int param1Int);
    
    ByteString getFileToGenerateBytes(int param1Int);
    
    int getFileToGenerateCount();
    
    List<String> getFileToGenerateList();
    
    String getParameter();
    
    ByteString getParameterBytes();
    
    DescriptorProtos.FileDescriptorProto getProtoFile(int param1Int);
    
    int getProtoFileCount();
    
    List<DescriptorProtos.FileDescriptorProto> getProtoFileList();
    
    boolean hasCompilerVersion();
    
    boolean hasParameter();
  }
  
  public static final class CodeGeneratorResponse extends GeneratedMessageLite<CodeGeneratorResponse, CodeGeneratorResponse.Builder> implements CodeGeneratorResponseOrBuilder {
    private static final CodeGeneratorResponse DEFAULT_INSTANCE = new CodeGeneratorResponse();
    
    public static final int ERROR_FIELD_NUMBER = 1;
    
    public static final int FILE_FIELD_NUMBER = 15;
    
    private static volatile Parser<CodeGeneratorResponse> PARSER;
    
    private int bitField0_;
    
    private String error_ = "";
    
    private Internal.ProtobufList<File> file_ = emptyProtobufList();
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllFile(Iterable<? extends File> param1Iterable) {
      ensureFileIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.file_);
    }
    
    private void addFile(int param1Int, File.Builder param1Builder) {
      ensureFileIsMutable();
      this.file_.add(param1Int, param1Builder.build());
    }
    
    private void addFile(int param1Int, File param1File) {
      if (param1File != null) {
        ensureFileIsMutable();
        this.file_.add(param1Int, param1File);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addFile(File.Builder param1Builder) {
      ensureFileIsMutable();
      this.file_.add(param1Builder.build());
    }
    
    private void addFile(File param1File) {
      if (param1File != null) {
        ensureFileIsMutable();
        this.file_.add(param1File);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearError() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.error_ = getDefaultInstance().getError();
    }
    
    private void clearFile() {
      this.file_ = emptyProtobufList();
    }
    
    private void ensureFileIsMutable() {
      if (!this.file_.isModifiable())
        this.file_ = GeneratedMessageLite.mutableCopy(this.file_); 
    }
    
    public static CodeGeneratorResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(CodeGeneratorResponse param1CodeGeneratorResponse) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1CodeGeneratorResponse);
    }
    
    public static CodeGeneratorResponse parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (CodeGeneratorResponse)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static CodeGeneratorResponse parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CodeGeneratorResponse)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static CodeGeneratorResponse parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (CodeGeneratorResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static CodeGeneratorResponse parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CodeGeneratorResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static CodeGeneratorResponse parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (CodeGeneratorResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static CodeGeneratorResponse parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CodeGeneratorResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static CodeGeneratorResponse parseFrom(InputStream param1InputStream) throws IOException {
      return (CodeGeneratorResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static CodeGeneratorResponse parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CodeGeneratorResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static CodeGeneratorResponse parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (CodeGeneratorResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static CodeGeneratorResponse parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CodeGeneratorResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<CodeGeneratorResponse> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeFile(int param1Int) {
      ensureFileIsMutable();
      this.file_.remove(param1Int);
    }
    
    private void setError(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x1;
        this.error_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setErrorBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x1;
        this.error_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setFile(int param1Int, File.Builder param1Builder) {
      ensureFileIsMutable();
      this.file_.set(param1Int, param1Builder.build());
    }
    
    private void setFile(int param1Int, File param1File) {
      if (param1File != null) {
        ensureFileIsMutable();
        this.file_.set(param1Int, param1File);
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/protobuf/compiler/PluginProtos$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 399, 2 -> 395, 3 -> 384, 4 -> 375, 5 -> 299, 6 -> 110, 7 -> 295, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse
      //   72: monitorenter
      //   73: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 295
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 239
      //   139: iload #5
      //   141: bipush #10
      //   143: if_icmpeq -> 216
      //   146: iload #5
      //   148: bipush #122
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
      //   170: getfield file_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   173: invokeinterface isModifiable : ()Z
      //   178: ifne -> 192
      //   181: aload_0
      //   182: aload_0
      //   183: getfield file_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   186: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   189: putfield file_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   192: aload_0
      //   193: getfield file_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   196: aload_1
      //   197: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   200: aload_2
      //   201: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   204: checkcast com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File
      //   207: invokeinterface add : (Ljava/lang/Object;)Z
      //   212: pop
      //   213: goto -> 123
      //   216: aload_1
      //   217: invokevirtual readString : ()Ljava/lang/String;
      //   220: astore_3
      //   221: aload_0
      //   222: iconst_1
      //   223: aload_0
      //   224: getfield bitField0_ : I
      //   227: ior
      //   228: putfield bitField0_ : I
      //   231: aload_0
      //   232: aload_3
      //   233: putfield error_ : Ljava/lang/String;
      //   236: goto -> 123
      //   239: iconst_1
      //   240: istore #4
      //   242: goto -> 123
      //   245: astore_1
      //   246: goto -> 293
      //   249: astore_1
      //   250: new java/lang/RuntimeException
      //   253: astore_2
      //   254: new com/google/protobuf/InvalidProtocolBufferException
      //   257: astore_3
      //   258: aload_3
      //   259: aload_1
      //   260: invokevirtual getMessage : ()Ljava/lang/String;
      //   263: invokespecial <init> : (Ljava/lang/String;)V
      //   266: aload_2
      //   267: aload_3
      //   268: aload_0
      //   269: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   272: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   275: aload_2
      //   276: athrow
      //   277: astore_1
      //   278: new java/lang/RuntimeException
      //   281: astore_2
      //   282: aload_2
      //   283: aload_1
      //   284: aload_0
      //   285: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   288: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   291: aload_2
      //   292: athrow
      //   293: aload_1
      //   294: athrow
      //   295: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse;
      //   298: areturn
      //   299: aload_2
      //   300: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   303: astore_1
      //   304: aload_3
      //   305: checkcast com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse
      //   308: astore_2
      //   309: aload_0
      //   310: aload_1
      //   311: aload_0
      //   312: invokevirtual hasError : ()Z
      //   315: aload_0
      //   316: getfield error_ : Ljava/lang/String;
      //   319: aload_2
      //   320: invokevirtual hasError : ()Z
      //   323: aload_2
      //   324: getfield error_ : Ljava/lang/String;
      //   327: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   332: putfield error_ : Ljava/lang/String;
      //   335: aload_0
      //   336: aload_1
      //   337: aload_0
      //   338: getfield file_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   341: aload_2
      //   342: getfield file_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   345: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   350: putfield file_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   353: aload_1
      //   354: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   357: if_acmpne -> 373
      //   360: aload_0
      //   361: aload_0
      //   362: getfield bitField0_ : I
      //   365: aload_2
      //   366: getfield bitField0_ : I
      //   369: ior
      //   370: putfield bitField0_ : I
      //   373: aload_0
      //   374: areturn
      //   375: new com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$Builder
      //   378: dup
      //   379: aconst_null
      //   380: invokespecial <init> : (Lcom/google/protobuf/compiler/PluginProtos$1;)V
      //   383: areturn
      //   384: aload_0
      //   385: getfield file_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   388: invokeinterface makeImmutable : ()V
      //   393: aconst_null
      //   394: areturn
      //   395: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse;
      //   398: areturn
      //   399: new com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse
      //   402: dup
      //   403: invokespecial <init> : ()V
      //   406: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	277	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	249	java/io/IOException
      //   128	134	245	finally
      //   153	163	277	com/google/protobuf/InvalidProtocolBufferException
      //   153	163	249	java/io/IOException
      //   153	163	245	finally
      //   169	192	277	com/google/protobuf/InvalidProtocolBufferException
      //   169	192	249	java/io/IOException
      //   169	192	245	finally
      //   192	213	277	com/google/protobuf/InvalidProtocolBufferException
      //   192	213	249	java/io/IOException
      //   192	213	245	finally
      //   216	236	277	com/google/protobuf/InvalidProtocolBufferException
      //   216	236	249	java/io/IOException
      //   216	236	245	finally
      //   250	277	245	finally
      //   278	293	245	finally
    }
    
    public String getError() {
      return this.error_;
    }
    
    public ByteString getErrorBytes() {
      return ByteString.copyFromUtf8(this.error_);
    }
    
    public File getFile(int param1Int) {
      return (File)this.file_.get(param1Int);
    }
    
    public int getFileCount() {
      return this.file_.size();
    }
    
    public List<File> getFileList() {
      return (List<File>)this.file_;
    }
    
    public FileOrBuilder getFileOrBuilder(int param1Int) {
      return (FileOrBuilder)this.file_.get(param1Int);
    }
    
    public List<? extends FileOrBuilder> getFileOrBuilderList() {
      return (List)this.file_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = this.bitField0_;
      byte b = 0;
      if ((i & 0x1) == 1) {
        i = CodedOutputStream.computeStringSize(1, getError()) + 0;
      } else {
        i = 0;
      } 
      while (b < this.file_.size()) {
        i += CodedOutputStream.computeMessageSize(15, (MessageLite)this.file_.get(b));
        b++;
      } 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasError() {
      int i = this.bitField0_;
      boolean bool = true;
      if ((i & 0x1) != 1)
        bool = false; 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if ((this.bitField0_ & 0x1) == 1)
        param1CodedOutputStream.writeString(1, getError()); 
      for (byte b = 0; b < this.file_.size(); b++)
        param1CodedOutputStream.writeMessage(15, (MessageLite)this.file_.get(b)); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<CodeGeneratorResponse, Builder> implements PluginProtos.CodeGeneratorResponseOrBuilder {
      private Builder() {
        super(PluginProtos.CodeGeneratorResponse.DEFAULT_INSTANCE);
      }
      
      public Builder addAllFile(Iterable<? extends PluginProtos.CodeGeneratorResponse.File> param2Iterable) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).addAllFile(param2Iterable);
        return this;
      }
      
      public Builder addFile(int param2Int, PluginProtos.CodeGeneratorResponse.File.Builder param2Builder) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).addFile(param2Int, param2Builder);
        return this;
      }
      
      public Builder addFile(int param2Int, PluginProtos.CodeGeneratorResponse.File param2File) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).addFile(param2Int, param2File);
        return this;
      }
      
      public Builder addFile(PluginProtos.CodeGeneratorResponse.File.Builder param2Builder) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).addFile(param2Builder);
        return this;
      }
      
      public Builder addFile(PluginProtos.CodeGeneratorResponse.File param2File) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).addFile(param2File);
        return this;
      }
      
      public Builder clearError() {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).clearError();
        return this;
      }
      
      public Builder clearFile() {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).clearFile();
        return this;
      }
      
      public String getError() {
        return ((PluginProtos.CodeGeneratorResponse)this.instance).getError();
      }
      
      public ByteString getErrorBytes() {
        return ((PluginProtos.CodeGeneratorResponse)this.instance).getErrorBytes();
      }
      
      public PluginProtos.CodeGeneratorResponse.File getFile(int param2Int) {
        return ((PluginProtos.CodeGeneratorResponse)this.instance).getFile(param2Int);
      }
      
      public int getFileCount() {
        return ((PluginProtos.CodeGeneratorResponse)this.instance).getFileCount();
      }
      
      public List<PluginProtos.CodeGeneratorResponse.File> getFileList() {
        return Collections.unmodifiableList(((PluginProtos.CodeGeneratorResponse)this.instance).getFileList());
      }
      
      public boolean hasError() {
        return ((PluginProtos.CodeGeneratorResponse)this.instance).hasError();
      }
      
      public Builder removeFile(int param2Int) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).removeFile(param2Int);
        return this;
      }
      
      public Builder setError(String param2String) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).setError(param2String);
        return this;
      }
      
      public Builder setErrorBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).setErrorBytes(param2ByteString);
        return this;
      }
      
      public Builder setFile(int param2Int, PluginProtos.CodeGeneratorResponse.File.Builder param2Builder) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).setFile(param2Int, param2Builder);
        return this;
      }
      
      public Builder setFile(int param2Int, PluginProtos.CodeGeneratorResponse.File param2File) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).setFile(param2Int, param2File);
        return this;
      }
    }
    
    public static final class File extends GeneratedMessageLite<File, File.Builder> implements FileOrBuilder {
      public static final int CONTENT_FIELD_NUMBER = 15;
      
      private static final File DEFAULT_INSTANCE = new File();
      
      public static final int INSERTION_POINT_FIELD_NUMBER = 2;
      
      public static final int NAME_FIELD_NUMBER = 1;
      
      private static volatile Parser<File> PARSER;
      
      private int bitField0_;
      
      private String content_ = "";
      
      private String insertionPoint_ = "";
      
      private String name_ = "";
      
      static {
        DEFAULT_INSTANCE.makeImmutable();
      }
      
      private void clearContent() {
        this.bitField0_ &= 0xFFFFFFFB;
        this.content_ = getDefaultInstance().getContent();
      }
      
      private void clearInsertionPoint() {
        this.bitField0_ &= 0xFFFFFFFD;
        this.insertionPoint_ = getDefaultInstance().getInsertionPoint();
      }
      
      private void clearName() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.name_ = getDefaultInstance().getName();
      }
      
      public static File getDefaultInstance() {
        return DEFAULT_INSTANCE;
      }
      
      public static Builder newBuilder() {
        return (Builder)DEFAULT_INSTANCE.toBuilder();
      }
      
      public static Builder newBuilder(File param2File) {
        return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param2File);
      }
      
      public static File parseDelimitedFrom(InputStream param2InputStream) throws IOException {
        return (File)parseDelimitedFrom(DEFAULT_INSTANCE, param2InputStream);
      }
      
      public static File parseDelimitedFrom(InputStream param2InputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (File)parseDelimitedFrom(DEFAULT_INSTANCE, param2InputStream, param2ExtensionRegistryLite);
      }
      
      public static File parseFrom(ByteString param2ByteString) throws InvalidProtocolBufferException {
        return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ByteString);
      }
      
      public static File parseFrom(ByteString param2ByteString, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ByteString, param2ExtensionRegistryLite);
      }
      
      public static File parseFrom(CodedInputStream param2CodedInputStream) throws IOException {
        return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2CodedInputStream);
      }
      
      public static File parseFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2CodedInputStream, param2ExtensionRegistryLite);
      }
      
      public static File parseFrom(InputStream param2InputStream) throws IOException {
        return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2InputStream);
      }
      
      public static File parseFrom(InputStream param2InputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2InputStream, param2ExtensionRegistryLite);
      }
      
      public static File parseFrom(byte[] param2ArrayOfbyte) throws InvalidProtocolBufferException {
        return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ArrayOfbyte);
      }
      
      public static File parseFrom(byte[] param2ArrayOfbyte, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ArrayOfbyte, param2ExtensionRegistryLite);
      }
      
      public static Parser<File> parser() {
        return DEFAULT_INSTANCE.getParserForType();
      }
      
      private void setContent(String param2String) {
        if (param2String != null) {
          this.bitField0_ |= 0x4;
          this.content_ = param2String;
          return;
        } 
        throw new NullPointerException();
      }
      
      private void setContentBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          this.bitField0_ |= 0x4;
          this.content_ = param2ByteString.toStringUtf8();
          return;
        } 
        throw new NullPointerException();
      }
      
      private void setInsertionPoint(String param2String) {
        if (param2String != null) {
          this.bitField0_ |= 0x2;
          this.insertionPoint_ = param2String;
          return;
        } 
        throw new NullPointerException();
      }
      
      private void setInsertionPointBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          this.bitField0_ |= 0x2;
          this.insertionPoint_ = param2ByteString.toStringUtf8();
          return;
        } 
        throw new NullPointerException();
      }
      
      private void setName(String param2String) {
        if (param2String != null) {
          this.bitField0_ |= 0x1;
          this.name_ = param2String;
          return;
        } 
        throw new NullPointerException();
      }
      
      private void setNameBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          this.bitField0_ |= 0x1;
          this.name_ = param2ByteString.toStringUtf8();
          return;
        } 
        throw new NullPointerException();
      }
      
      protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param2MethodToInvoke, Object param2Object1, Object param2Object2) {
        // Byte code:
        //   0: getstatic com/google/protobuf/compiler/PluginProtos$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
        //   3: aload_1
        //   4: invokevirtual ordinal : ()I
        //   7: iaload
        //   8: tableswitch default -> 56, 1 -> 430, 2 -> 426, 3 -> 424, 4 -> 415, 5 -> 305, 6 -> 110, 7 -> 301, 8 -> 64
        //   56: new java/lang/UnsupportedOperationException
        //   59: dup
        //   60: invokespecial <init> : ()V
        //   63: athrow
        //   64: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.PARSER : Lcom/google/protobuf/Parser;
        //   67: ifnonnull -> 106
        //   70: ldc com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File
        //   72: monitorenter
        //   73: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.PARSER : Lcom/google/protobuf/Parser;
        //   76: ifnonnull -> 94
        //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
        //   82: astore_1
        //   83: aload_1
        //   84: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File;
        //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
        //   90: aload_1
        //   91: putstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.PARSER : Lcom/google/protobuf/Parser;
        //   94: ldc com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File
        //   96: monitorexit
        //   97: goto -> 106
        //   100: astore_1
        //   101: ldc com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File
        //   103: monitorexit
        //   104: aload_1
        //   105: athrow
        //   106: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.PARSER : Lcom/google/protobuf/Parser;
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
        //   125: ifne -> 301
        //   128: aload_1
        //   129: invokevirtual readTag : ()I
        //   132: istore #5
        //   134: iload #5
        //   136: ifeq -> 245
        //   139: iload #5
        //   141: bipush #10
        //   143: if_icmpeq -> 222
        //   146: iload #5
        //   148: bipush #18
        //   150: if_icmpeq -> 199
        //   153: iload #5
        //   155: bipush #122
        //   157: if_icmpeq -> 176
        //   160: aload_0
        //   161: iload #5
        //   163: aload_1
        //   164: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
        //   167: ifne -> 123
        //   170: iconst_1
        //   171: istore #4
        //   173: goto -> 123
        //   176: aload_1
        //   177: invokevirtual readString : ()Ljava/lang/String;
        //   180: astore_2
        //   181: aload_0
        //   182: aload_0
        //   183: getfield bitField0_ : I
        //   186: iconst_4
        //   187: ior
        //   188: putfield bitField0_ : I
        //   191: aload_0
        //   192: aload_2
        //   193: putfield content_ : Ljava/lang/String;
        //   196: goto -> 123
        //   199: aload_1
        //   200: invokevirtual readString : ()Ljava/lang/String;
        //   203: astore_2
        //   204: aload_0
        //   205: aload_0
        //   206: getfield bitField0_ : I
        //   209: iconst_2
        //   210: ior
        //   211: putfield bitField0_ : I
        //   214: aload_0
        //   215: aload_2
        //   216: putfield insertionPoint_ : Ljava/lang/String;
        //   219: goto -> 123
        //   222: aload_1
        //   223: invokevirtual readString : ()Ljava/lang/String;
        //   226: astore_2
        //   227: aload_0
        //   228: iconst_1
        //   229: aload_0
        //   230: getfield bitField0_ : I
        //   233: ior
        //   234: putfield bitField0_ : I
        //   237: aload_0
        //   238: aload_2
        //   239: putfield name_ : Ljava/lang/String;
        //   242: goto -> 123
        //   245: iconst_1
        //   246: istore #4
        //   248: goto -> 123
        //   251: astore_1
        //   252: goto -> 299
        //   255: astore_1
        //   256: new java/lang/RuntimeException
        //   259: astore_3
        //   260: new com/google/protobuf/InvalidProtocolBufferException
        //   263: astore_2
        //   264: aload_2
        //   265: aload_1
        //   266: invokevirtual getMessage : ()Ljava/lang/String;
        //   269: invokespecial <init> : (Ljava/lang/String;)V
        //   272: aload_3
        //   273: aload_2
        //   274: aload_0
        //   275: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
        //   278: invokespecial <init> : (Ljava/lang/Throwable;)V
        //   281: aload_3
        //   282: athrow
        //   283: astore_1
        //   284: new java/lang/RuntimeException
        //   287: astore_2
        //   288: aload_2
        //   289: aload_1
        //   290: aload_0
        //   291: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
        //   294: invokespecial <init> : (Ljava/lang/Throwable;)V
        //   297: aload_2
        //   298: athrow
        //   299: aload_1
        //   300: athrow
        //   301: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File;
        //   304: areturn
        //   305: aload_2
        //   306: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
        //   309: astore_1
        //   310: aload_3
        //   311: checkcast com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File
        //   314: astore_2
        //   315: aload_0
        //   316: aload_1
        //   317: aload_0
        //   318: invokevirtual hasName : ()Z
        //   321: aload_0
        //   322: getfield name_ : Ljava/lang/String;
        //   325: aload_2
        //   326: invokevirtual hasName : ()Z
        //   329: aload_2
        //   330: getfield name_ : Ljava/lang/String;
        //   333: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
        //   338: putfield name_ : Ljava/lang/String;
        //   341: aload_0
        //   342: aload_1
        //   343: aload_0
        //   344: invokevirtual hasInsertionPoint : ()Z
        //   347: aload_0
        //   348: getfield insertionPoint_ : Ljava/lang/String;
        //   351: aload_2
        //   352: invokevirtual hasInsertionPoint : ()Z
        //   355: aload_2
        //   356: getfield insertionPoint_ : Ljava/lang/String;
        //   359: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
        //   364: putfield insertionPoint_ : Ljava/lang/String;
        //   367: aload_0
        //   368: aload_1
        //   369: aload_0
        //   370: invokevirtual hasContent : ()Z
        //   373: aload_0
        //   374: getfield content_ : Ljava/lang/String;
        //   377: aload_2
        //   378: invokevirtual hasContent : ()Z
        //   381: aload_2
        //   382: getfield content_ : Ljava/lang/String;
        //   385: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
        //   390: putfield content_ : Ljava/lang/String;
        //   393: aload_1
        //   394: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
        //   397: if_acmpne -> 413
        //   400: aload_0
        //   401: aload_0
        //   402: getfield bitField0_ : I
        //   405: aload_2
        //   406: getfield bitField0_ : I
        //   409: ior
        //   410: putfield bitField0_ : I
        //   413: aload_0
        //   414: areturn
        //   415: new com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File$Builder
        //   418: dup
        //   419: aconst_null
        //   420: invokespecial <init> : (Lcom/google/protobuf/compiler/PluginProtos$1;)V
        //   423: areturn
        //   424: aconst_null
        //   425: areturn
        //   426: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File;
        //   429: areturn
        //   430: new com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File
        //   433: dup
        //   434: invokespecial <init> : ()V
        //   437: areturn
        // Exception table:
        //   from	to	target	type
        //   73	94	100	finally
        //   94	97	100	finally
        //   101	104	100	finally
        //   128	134	283	com/google/protobuf/InvalidProtocolBufferException
        //   128	134	255	java/io/IOException
        //   128	134	251	finally
        //   160	170	283	com/google/protobuf/InvalidProtocolBufferException
        //   160	170	255	java/io/IOException
        //   160	170	251	finally
        //   176	196	283	com/google/protobuf/InvalidProtocolBufferException
        //   176	196	255	java/io/IOException
        //   176	196	251	finally
        //   199	219	283	com/google/protobuf/InvalidProtocolBufferException
        //   199	219	255	java/io/IOException
        //   199	219	251	finally
        //   222	242	283	com/google/protobuf/InvalidProtocolBufferException
        //   222	242	255	java/io/IOException
        //   222	242	251	finally
        //   256	283	251	finally
        //   284	299	251	finally
      }
      
      public String getContent() {
        return this.content_;
      }
      
      public ByteString getContentBytes() {
        return ByteString.copyFromUtf8(this.content_);
      }
      
      public String getInsertionPoint() {
        return this.insertionPoint_;
      }
      
      public ByteString getInsertionPointBytes() {
        return ByteString.copyFromUtf8(this.insertionPoint_);
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
        if ((this.bitField0_ & 0x2) == 2)
          i = j + CodedOutputStream.computeStringSize(2, getInsertionPoint()); 
        j = i;
        if ((this.bitField0_ & 0x4) == 4)
          j = i + CodedOutputStream.computeStringSize(15, getContent()); 
        i = j + this.unknownFields.getSerializedSize();
        this.memoizedSerializedSize = i;
        return i;
      }
      
      public boolean hasContent() {
        boolean bool;
        if ((this.bitField0_ & 0x4) == 4) {
          bool = true;
        } else {
          bool = false;
        } 
        return bool;
      }
      
      public boolean hasInsertionPoint() {
        boolean bool;
        if ((this.bitField0_ & 0x2) == 2) {
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
      
      public void writeTo(CodedOutputStream param2CodedOutputStream) throws IOException {
        if ((this.bitField0_ & 0x1) == 1)
          param2CodedOutputStream.writeString(1, getName()); 
        if ((this.bitField0_ & 0x2) == 2)
          param2CodedOutputStream.writeString(2, getInsertionPoint()); 
        if ((this.bitField0_ & 0x4) == 4)
          param2CodedOutputStream.writeString(15, getContent()); 
        this.unknownFields.writeTo(param2CodedOutputStream);
      }
      
      public static final class Builder extends GeneratedMessageLite.Builder<File, Builder> implements PluginProtos.CodeGeneratorResponse.FileOrBuilder {
        private Builder() {
          super(PluginProtos.CodeGeneratorResponse.File.DEFAULT_INSTANCE);
        }
        
        public Builder clearContent() {
          copyOnWrite();
          ((PluginProtos.CodeGeneratorResponse.File)this.instance).clearContent();
          return this;
        }
        
        public Builder clearInsertionPoint() {
          copyOnWrite();
          ((PluginProtos.CodeGeneratorResponse.File)this.instance).clearInsertionPoint();
          return this;
        }
        
        public Builder clearName() {
          copyOnWrite();
          ((PluginProtos.CodeGeneratorResponse.File)this.instance).clearName();
          return this;
        }
        
        public String getContent() {
          return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getContent();
        }
        
        public ByteString getContentBytes() {
          return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getContentBytes();
        }
        
        public String getInsertionPoint() {
          return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getInsertionPoint();
        }
        
        public ByteString getInsertionPointBytes() {
          return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getInsertionPointBytes();
        }
        
        public String getName() {
          return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getName();
        }
        
        public ByteString getNameBytes() {
          return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getNameBytes();
        }
        
        public boolean hasContent() {
          return ((PluginProtos.CodeGeneratorResponse.File)this.instance).hasContent();
        }
        
        public boolean hasInsertionPoint() {
          return ((PluginProtos.CodeGeneratorResponse.File)this.instance).hasInsertionPoint();
        }
        
        public boolean hasName() {
          return ((PluginProtos.CodeGeneratorResponse.File)this.instance).hasName();
        }
        
        public Builder setContent(String param3String) {
          copyOnWrite();
          ((PluginProtos.CodeGeneratorResponse.File)this.instance).setContent(param3String);
          return this;
        }
        
        public Builder setContentBytes(ByteString param3ByteString) {
          copyOnWrite();
          ((PluginProtos.CodeGeneratorResponse.File)this.instance).setContentBytes(param3ByteString);
          return this;
        }
        
        public Builder setInsertionPoint(String param3String) {
          copyOnWrite();
          ((PluginProtos.CodeGeneratorResponse.File)this.instance).setInsertionPoint(param3String);
          return this;
        }
        
        public Builder setInsertionPointBytes(ByteString param3ByteString) {
          copyOnWrite();
          ((PluginProtos.CodeGeneratorResponse.File)this.instance).setInsertionPointBytes(param3ByteString);
          return this;
        }
        
        public Builder setName(String param3String) {
          copyOnWrite();
          ((PluginProtos.CodeGeneratorResponse.File)this.instance).setName(param3String);
          return this;
        }
        
        public Builder setNameBytes(ByteString param3ByteString) {
          copyOnWrite();
          ((PluginProtos.CodeGeneratorResponse.File)this.instance).setNameBytes(param3ByteString);
          return this;
        }
      }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<File, File.Builder> implements FileOrBuilder {
      private Builder() {
        super(PluginProtos.CodeGeneratorResponse.File.DEFAULT_INSTANCE);
      }
      
      public Builder clearContent() {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).clearContent();
        return this;
      }
      
      public Builder clearInsertionPoint() {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).clearInsertionPoint();
        return this;
      }
      
      public Builder clearName() {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).clearName();
        return this;
      }
      
      public String getContent() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getContent();
      }
      
      public ByteString getContentBytes() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getContentBytes();
      }
      
      public String getInsertionPoint() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getInsertionPoint();
      }
      
      public ByteString getInsertionPointBytes() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getInsertionPointBytes();
      }
      
      public String getName() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getName();
      }
      
      public ByteString getNameBytes() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getNameBytes();
      }
      
      public boolean hasContent() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).hasContent();
      }
      
      public boolean hasInsertionPoint() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).hasInsertionPoint();
      }
      
      public boolean hasName() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).hasName();
      }
      
      public Builder setContent(String param2String) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).setContent(param2String);
        return this;
      }
      
      public Builder setContentBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).setContentBytes(param2ByteString);
        return this;
      }
      
      public Builder setInsertionPoint(String param2String) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).setInsertionPoint(param2String);
        return this;
      }
      
      public Builder setInsertionPointBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).setInsertionPointBytes(param2ByteString);
        return this;
      }
      
      public Builder setName(String param2String) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).setName(param2String);
        return this;
      }
      
      public Builder setNameBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).setNameBytes(param2ByteString);
        return this;
      }
    }
    
    public static interface FileOrBuilder extends MessageLiteOrBuilder {
      String getContent();
      
      ByteString getContentBytes();
      
      String getInsertionPoint();
      
      ByteString getInsertionPointBytes();
      
      String getName();
      
      ByteString getNameBytes();
      
      boolean hasContent();
      
      boolean hasInsertionPoint();
      
      boolean hasName();
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<CodeGeneratorResponse, CodeGeneratorResponse.Builder> implements CodeGeneratorResponseOrBuilder {
    private Builder() {
      super(PluginProtos.CodeGeneratorResponse.DEFAULT_INSTANCE);
    }
    
    public Builder addAllFile(Iterable<? extends PluginProtos.CodeGeneratorResponse.File> param1Iterable) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse)this.instance).addAllFile(param1Iterable);
      return this;
    }
    
    public Builder addFile(int param1Int, PluginProtos.CodeGeneratorResponse.File.Builder param1Builder) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse)this.instance).addFile(param1Int, param1Builder);
      return this;
    }
    
    public Builder addFile(int param1Int, PluginProtos.CodeGeneratorResponse.File param1File) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse)this.instance).addFile(param1Int, param1File);
      return this;
    }
    
    public Builder addFile(PluginProtos.CodeGeneratorResponse.File.Builder param1Builder) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse)this.instance).addFile(param1Builder);
      return this;
    }
    
    public Builder addFile(PluginProtos.CodeGeneratorResponse.File param1File) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse)this.instance).addFile(param1File);
      return this;
    }
    
    public Builder clearError() {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse)this.instance).clearError();
      return this;
    }
    
    public Builder clearFile() {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse)this.instance).clearFile();
      return this;
    }
    
    public String getError() {
      return ((PluginProtos.CodeGeneratorResponse)this.instance).getError();
    }
    
    public ByteString getErrorBytes() {
      return ((PluginProtos.CodeGeneratorResponse)this.instance).getErrorBytes();
    }
    
    public PluginProtos.CodeGeneratorResponse.File getFile(int param1Int) {
      return ((PluginProtos.CodeGeneratorResponse)this.instance).getFile(param1Int);
    }
    
    public int getFileCount() {
      return ((PluginProtos.CodeGeneratorResponse)this.instance).getFileCount();
    }
    
    public List<PluginProtos.CodeGeneratorResponse.File> getFileList() {
      return Collections.unmodifiableList(((PluginProtos.CodeGeneratorResponse)this.instance).getFileList());
    }
    
    public boolean hasError() {
      return ((PluginProtos.CodeGeneratorResponse)this.instance).hasError();
    }
    
    public Builder removeFile(int param1Int) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse)this.instance).removeFile(param1Int);
      return this;
    }
    
    public Builder setError(String param1String) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse)this.instance).setError(param1String);
      return this;
    }
    
    public Builder setErrorBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse)this.instance).setErrorBytes(param1ByteString);
      return this;
    }
    
    public Builder setFile(int param1Int, PluginProtos.CodeGeneratorResponse.File.Builder param1Builder) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse)this.instance).setFile(param1Int, param1Builder);
      return this;
    }
    
    public Builder setFile(int param1Int, PluginProtos.CodeGeneratorResponse.File param1File) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse)this.instance).setFile(param1Int, param1File);
      return this;
    }
  }
  
  public static final class File extends GeneratedMessageLite<CodeGeneratorResponse.File, CodeGeneratorResponse.File.Builder> implements CodeGeneratorResponse.FileOrBuilder {
    public static final int CONTENT_FIELD_NUMBER = 15;
    
    private static final File DEFAULT_INSTANCE = new File();
    
    public static final int INSERTION_POINT_FIELD_NUMBER = 2;
    
    public static final int NAME_FIELD_NUMBER = 1;
    
    private static volatile Parser<File> PARSER;
    
    private int bitField0_;
    
    private String content_ = "";
    
    private String insertionPoint_ = "";
    
    private String name_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearContent() {
      this.bitField0_ &= 0xFFFFFFFB;
      this.content_ = getDefaultInstance().getContent();
    }
    
    private void clearInsertionPoint() {
      this.bitField0_ &= 0xFFFFFFFD;
      this.insertionPoint_ = getDefaultInstance().getInsertionPoint();
    }
    
    private void clearName() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.name_ = getDefaultInstance().getName();
    }
    
    public static File getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(File param1File) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1File);
    }
    
    public static File parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (File)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static File parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (File)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static File parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static File parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static File parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static File parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static File parseFrom(InputStream param1InputStream) throws IOException {
      return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static File parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static File parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static File parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<File> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setContent(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x4;
        this.content_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setContentBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x4;
        this.content_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setInsertionPoint(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x2;
        this.insertionPoint_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setInsertionPointBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x2;
        this.insertionPoint_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
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
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/protobuf/compiler/PluginProtos$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 430, 2 -> 426, 3 -> 424, 4 -> 415, 5 -> 305, 6 -> 110, 7 -> 301, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File
      //   72: monitorenter
      //   73: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 301
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 245
      //   139: iload #5
      //   141: bipush #10
      //   143: if_icmpeq -> 222
      //   146: iload #5
      //   148: bipush #18
      //   150: if_icmpeq -> 199
      //   153: iload #5
      //   155: bipush #122
      //   157: if_icmpeq -> 176
      //   160: aload_0
      //   161: iload #5
      //   163: aload_1
      //   164: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   167: ifne -> 123
      //   170: iconst_1
      //   171: istore #4
      //   173: goto -> 123
      //   176: aload_1
      //   177: invokevirtual readString : ()Ljava/lang/String;
      //   180: astore_2
      //   181: aload_0
      //   182: aload_0
      //   183: getfield bitField0_ : I
      //   186: iconst_4
      //   187: ior
      //   188: putfield bitField0_ : I
      //   191: aload_0
      //   192: aload_2
      //   193: putfield content_ : Ljava/lang/String;
      //   196: goto -> 123
      //   199: aload_1
      //   200: invokevirtual readString : ()Ljava/lang/String;
      //   203: astore_2
      //   204: aload_0
      //   205: aload_0
      //   206: getfield bitField0_ : I
      //   209: iconst_2
      //   210: ior
      //   211: putfield bitField0_ : I
      //   214: aload_0
      //   215: aload_2
      //   216: putfield insertionPoint_ : Ljava/lang/String;
      //   219: goto -> 123
      //   222: aload_1
      //   223: invokevirtual readString : ()Ljava/lang/String;
      //   226: astore_2
      //   227: aload_0
      //   228: iconst_1
      //   229: aload_0
      //   230: getfield bitField0_ : I
      //   233: ior
      //   234: putfield bitField0_ : I
      //   237: aload_0
      //   238: aload_2
      //   239: putfield name_ : Ljava/lang/String;
      //   242: goto -> 123
      //   245: iconst_1
      //   246: istore #4
      //   248: goto -> 123
      //   251: astore_1
      //   252: goto -> 299
      //   255: astore_1
      //   256: new java/lang/RuntimeException
      //   259: astore_3
      //   260: new com/google/protobuf/InvalidProtocolBufferException
      //   263: astore_2
      //   264: aload_2
      //   265: aload_1
      //   266: invokevirtual getMessage : ()Ljava/lang/String;
      //   269: invokespecial <init> : (Ljava/lang/String;)V
      //   272: aload_3
      //   273: aload_2
      //   274: aload_0
      //   275: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   278: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   281: aload_3
      //   282: athrow
      //   283: astore_1
      //   284: new java/lang/RuntimeException
      //   287: astore_2
      //   288: aload_2
      //   289: aload_1
      //   290: aload_0
      //   291: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   294: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   297: aload_2
      //   298: athrow
      //   299: aload_1
      //   300: athrow
      //   301: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File;
      //   304: areturn
      //   305: aload_2
      //   306: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   309: astore_1
      //   310: aload_3
      //   311: checkcast com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File
      //   314: astore_2
      //   315: aload_0
      //   316: aload_1
      //   317: aload_0
      //   318: invokevirtual hasName : ()Z
      //   321: aload_0
      //   322: getfield name_ : Ljava/lang/String;
      //   325: aload_2
      //   326: invokevirtual hasName : ()Z
      //   329: aload_2
      //   330: getfield name_ : Ljava/lang/String;
      //   333: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   338: putfield name_ : Ljava/lang/String;
      //   341: aload_0
      //   342: aload_1
      //   343: aload_0
      //   344: invokevirtual hasInsertionPoint : ()Z
      //   347: aload_0
      //   348: getfield insertionPoint_ : Ljava/lang/String;
      //   351: aload_2
      //   352: invokevirtual hasInsertionPoint : ()Z
      //   355: aload_2
      //   356: getfield insertionPoint_ : Ljava/lang/String;
      //   359: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   364: putfield insertionPoint_ : Ljava/lang/String;
      //   367: aload_0
      //   368: aload_1
      //   369: aload_0
      //   370: invokevirtual hasContent : ()Z
      //   373: aload_0
      //   374: getfield content_ : Ljava/lang/String;
      //   377: aload_2
      //   378: invokevirtual hasContent : ()Z
      //   381: aload_2
      //   382: getfield content_ : Ljava/lang/String;
      //   385: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   390: putfield content_ : Ljava/lang/String;
      //   393: aload_1
      //   394: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   397: if_acmpne -> 413
      //   400: aload_0
      //   401: aload_0
      //   402: getfield bitField0_ : I
      //   405: aload_2
      //   406: getfield bitField0_ : I
      //   409: ior
      //   410: putfield bitField0_ : I
      //   413: aload_0
      //   414: areturn
      //   415: new com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File$Builder
      //   418: dup
      //   419: aconst_null
      //   420: invokespecial <init> : (Lcom/google/protobuf/compiler/PluginProtos$1;)V
      //   423: areturn
      //   424: aconst_null
      //   425: areturn
      //   426: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File;
      //   429: areturn
      //   430: new com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File
      //   433: dup
      //   434: invokespecial <init> : ()V
      //   437: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	283	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	255	java/io/IOException
      //   128	134	251	finally
      //   160	170	283	com/google/protobuf/InvalidProtocolBufferException
      //   160	170	255	java/io/IOException
      //   160	170	251	finally
      //   176	196	283	com/google/protobuf/InvalidProtocolBufferException
      //   176	196	255	java/io/IOException
      //   176	196	251	finally
      //   199	219	283	com/google/protobuf/InvalidProtocolBufferException
      //   199	219	255	java/io/IOException
      //   199	219	251	finally
      //   222	242	283	com/google/protobuf/InvalidProtocolBufferException
      //   222	242	255	java/io/IOException
      //   222	242	251	finally
      //   256	283	251	finally
      //   284	299	251	finally
    }
    
    public String getContent() {
      return this.content_;
    }
    
    public ByteString getContentBytes() {
      return ByteString.copyFromUtf8(this.content_);
    }
    
    public String getInsertionPoint() {
      return this.insertionPoint_;
    }
    
    public ByteString getInsertionPointBytes() {
      return ByteString.copyFromUtf8(this.insertionPoint_);
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
      if ((this.bitField0_ & 0x2) == 2)
        i = j + CodedOutputStream.computeStringSize(2, getInsertionPoint()); 
      j = i;
      if ((this.bitField0_ & 0x4) == 4)
        j = i + CodedOutputStream.computeStringSize(15, getContent()); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasContent() {
      boolean bool;
      if ((this.bitField0_ & 0x4) == 4) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasInsertionPoint() {
      boolean bool;
      if ((this.bitField0_ & 0x2) == 2) {
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
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if ((this.bitField0_ & 0x1) == 1)
        param1CodedOutputStream.writeString(1, getName()); 
      if ((this.bitField0_ & 0x2) == 2)
        param1CodedOutputStream.writeString(2, getInsertionPoint()); 
      if ((this.bitField0_ & 0x4) == 4)
        param1CodedOutputStream.writeString(15, getContent()); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<File, Builder> implements PluginProtos.CodeGeneratorResponse.FileOrBuilder {
      private Builder() {
        super(PluginProtos.CodeGeneratorResponse.File.DEFAULT_INSTANCE);
      }
      
      public Builder clearContent() {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).clearContent();
        return this;
      }
      
      public Builder clearInsertionPoint() {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).clearInsertionPoint();
        return this;
      }
      
      public Builder clearName() {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).clearName();
        return this;
      }
      
      public String getContent() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getContent();
      }
      
      public ByteString getContentBytes() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getContentBytes();
      }
      
      public String getInsertionPoint() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getInsertionPoint();
      }
      
      public ByteString getInsertionPointBytes() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getInsertionPointBytes();
      }
      
      public String getName() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getName();
      }
      
      public ByteString getNameBytes() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getNameBytes();
      }
      
      public boolean hasContent() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).hasContent();
      }
      
      public boolean hasInsertionPoint() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).hasInsertionPoint();
      }
      
      public boolean hasName() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).hasName();
      }
      
      public Builder setContent(String param3String) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).setContent(param3String);
        return this;
      }
      
      public Builder setContentBytes(ByteString param3ByteString) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).setContentBytes(param3ByteString);
        return this;
      }
      
      public Builder setInsertionPoint(String param3String) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).setInsertionPoint(param3String);
        return this;
      }
      
      public Builder setInsertionPointBytes(ByteString param3ByteString) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).setInsertionPointBytes(param3ByteString);
        return this;
      }
      
      public Builder setName(String param3String) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).setName(param3String);
        return this;
      }
      
      public Builder setNameBytes(ByteString param3ByteString) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).setNameBytes(param3ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<CodeGeneratorResponse.File, CodeGeneratorResponse.File.Builder> implements CodeGeneratorResponse.FileOrBuilder {
    private Builder() {
      super(PluginProtos.CodeGeneratorResponse.File.DEFAULT_INSTANCE);
    }
    
    public Builder clearContent() {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse.File)this.instance).clearContent();
      return this;
    }
    
    public Builder clearInsertionPoint() {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse.File)this.instance).clearInsertionPoint();
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse.File)this.instance).clearName();
      return this;
    }
    
    public String getContent() {
      return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getContent();
    }
    
    public ByteString getContentBytes() {
      return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getContentBytes();
    }
    
    public String getInsertionPoint() {
      return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getInsertionPoint();
    }
    
    public ByteString getInsertionPointBytes() {
      return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getInsertionPointBytes();
    }
    
    public String getName() {
      return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getName();
    }
    
    public ByteString getNameBytes() {
      return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getNameBytes();
    }
    
    public boolean hasContent() {
      return ((PluginProtos.CodeGeneratorResponse.File)this.instance).hasContent();
    }
    
    public boolean hasInsertionPoint() {
      return ((PluginProtos.CodeGeneratorResponse.File)this.instance).hasInsertionPoint();
    }
    
    public boolean hasName() {
      return ((PluginProtos.CodeGeneratorResponse.File)this.instance).hasName();
    }
    
    public Builder setContent(String param1String) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse.File)this.instance).setContent(param1String);
      return this;
    }
    
    public Builder setContentBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse.File)this.instance).setContentBytes(param1ByteString);
      return this;
    }
    
    public Builder setInsertionPoint(String param1String) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse.File)this.instance).setInsertionPoint(param1String);
      return this;
    }
    
    public Builder setInsertionPointBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse.File)this.instance).setInsertionPointBytes(param1ByteString);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse.File)this.instance).setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse.File)this.instance).setNameBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface FileOrBuilder extends MessageLiteOrBuilder {
    String getContent();
    
    ByteString getContentBytes();
    
    String getInsertionPoint();
    
    ByteString getInsertionPointBytes();
    
    String getName();
    
    ByteString getNameBytes();
    
    boolean hasContent();
    
    boolean hasInsertionPoint();
    
    boolean hasName();
  }
  
  public static interface CodeGeneratorResponseOrBuilder extends MessageLiteOrBuilder {
    String getError();
    
    ByteString getErrorBytes();
    
    PluginProtos.CodeGeneratorResponse.File getFile(int param1Int);
    
    int getFileCount();
    
    List<PluginProtos.CodeGeneratorResponse.File> getFileList();
    
    boolean hasError();
  }
  
  public static final class Version extends GeneratedMessageLite<Version, Version.Builder> implements VersionOrBuilder {
    private static final Version DEFAULT_INSTANCE = new Version();
    
    public static final int MAJOR_FIELD_NUMBER = 1;
    
    public static final int MINOR_FIELD_NUMBER = 2;
    
    private static volatile Parser<Version> PARSER;
    
    public static final int PATCH_FIELD_NUMBER = 3;
    
    public static final int SUFFIX_FIELD_NUMBER = 4;
    
    private int bitField0_;
    
    private int major_;
    
    private int minor_;
    
    private int patch_;
    
    private String suffix_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearMajor() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.major_ = 0;
    }
    
    private void clearMinor() {
      this.bitField0_ &= 0xFFFFFFFD;
      this.minor_ = 0;
    }
    
    private void clearPatch() {
      this.bitField0_ &= 0xFFFFFFFB;
      this.patch_ = 0;
    }
    
    private void clearSuffix() {
      this.bitField0_ &= 0xFFFFFFF7;
      this.suffix_ = getDefaultInstance().getSuffix();
    }
    
    public static Version getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Version param1Version) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1Version);
    }
    
    public static Version parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Version)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Version parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Version)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Version parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Version)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static Version parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Version)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Version parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Version)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static Version parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Version)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Version parseFrom(InputStream param1InputStream) throws IOException {
      return (Version)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Version parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Version)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Version parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Version)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static Version parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Version)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Version> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setMajor(int param1Int) {
      this.bitField0_ |= 0x1;
      this.major_ = param1Int;
    }
    
    private void setMinor(int param1Int) {
      this.bitField0_ |= 0x2;
      this.minor_ = param1Int;
    }
    
    private void setPatch(int param1Int) {
      this.bitField0_ |= 0x4;
      this.patch_ = param1Int;
    }
    
    private void setSuffix(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x8;
        this.suffix_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setSuffixBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x8;
        this.suffix_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/protobuf/compiler/PluginProtos$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 481, 2 -> 477, 3 -> 475, 4 -> 466, 5 -> 330, 6 -> 110, 7 -> 326, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/protobuf/compiler/PluginProtos$Version.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/protobuf/compiler/PluginProtos$Version
      //   72: monitorenter
      //   73: getstatic com/google/protobuf/compiler/PluginProtos$Version.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/protobuf/compiler/PluginProtos$Version.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$Version;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/protobuf/compiler/PluginProtos$Version.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/protobuf/compiler/PluginProtos$Version
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/protobuf/compiler/PluginProtos$Version
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/protobuf/compiler/PluginProtos$Version.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 326
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 270
      //   139: iload #5
      //   141: bipush #8
      //   143: if_icmpeq -> 249
      //   146: iload #5
      //   148: bipush #16
      //   150: if_icmpeq -> 228
      //   153: iload #5
      //   155: bipush #24
      //   157: if_icmpeq -> 207
      //   160: iload #5
      //   162: bipush #34
      //   164: if_icmpeq -> 183
      //   167: aload_0
      //   168: iload #5
      //   170: aload_1
      //   171: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   174: ifne -> 123
      //   177: iconst_1
      //   178: istore #4
      //   180: goto -> 123
      //   183: aload_1
      //   184: invokevirtual readString : ()Ljava/lang/String;
      //   187: astore_2
      //   188: aload_0
      //   189: aload_0
      //   190: getfield bitField0_ : I
      //   193: bipush #8
      //   195: ior
      //   196: putfield bitField0_ : I
      //   199: aload_0
      //   200: aload_2
      //   201: putfield suffix_ : Ljava/lang/String;
      //   204: goto -> 123
      //   207: aload_0
      //   208: aload_0
      //   209: getfield bitField0_ : I
      //   212: iconst_4
      //   213: ior
      //   214: putfield bitField0_ : I
      //   217: aload_0
      //   218: aload_1
      //   219: invokevirtual readInt32 : ()I
      //   222: putfield patch_ : I
      //   225: goto -> 123
      //   228: aload_0
      //   229: aload_0
      //   230: getfield bitField0_ : I
      //   233: iconst_2
      //   234: ior
      //   235: putfield bitField0_ : I
      //   238: aload_0
      //   239: aload_1
      //   240: invokevirtual readInt32 : ()I
      //   243: putfield minor_ : I
      //   246: goto -> 123
      //   249: aload_0
      //   250: aload_0
      //   251: getfield bitField0_ : I
      //   254: iconst_1
      //   255: ior
      //   256: putfield bitField0_ : I
      //   259: aload_0
      //   260: aload_1
      //   261: invokevirtual readInt32 : ()I
      //   264: putfield major_ : I
      //   267: goto -> 123
      //   270: iconst_1
      //   271: istore #4
      //   273: goto -> 123
      //   276: astore_1
      //   277: goto -> 324
      //   280: astore_1
      //   281: new java/lang/RuntimeException
      //   284: astore_2
      //   285: new com/google/protobuf/InvalidProtocolBufferException
      //   288: astore_3
      //   289: aload_3
      //   290: aload_1
      //   291: invokevirtual getMessage : ()Ljava/lang/String;
      //   294: invokespecial <init> : (Ljava/lang/String;)V
      //   297: aload_2
      //   298: aload_3
      //   299: aload_0
      //   300: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   303: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   306: aload_2
      //   307: athrow
      //   308: astore_2
      //   309: new java/lang/RuntimeException
      //   312: astore_1
      //   313: aload_1
      //   314: aload_2
      //   315: aload_0
      //   316: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   319: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   322: aload_1
      //   323: athrow
      //   324: aload_1
      //   325: athrow
      //   326: getstatic com/google/protobuf/compiler/PluginProtos$Version.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$Version;
      //   329: areturn
      //   330: aload_2
      //   331: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   334: astore_1
      //   335: aload_3
      //   336: checkcast com/google/protobuf/compiler/PluginProtos$Version
      //   339: astore_2
      //   340: aload_0
      //   341: aload_1
      //   342: aload_0
      //   343: invokevirtual hasMajor : ()Z
      //   346: aload_0
      //   347: getfield major_ : I
      //   350: aload_2
      //   351: invokevirtual hasMajor : ()Z
      //   354: aload_2
      //   355: getfield major_ : I
      //   358: invokeinterface visitInt : (ZIZI)I
      //   363: putfield major_ : I
      //   366: aload_0
      //   367: aload_1
      //   368: aload_0
      //   369: invokevirtual hasMinor : ()Z
      //   372: aload_0
      //   373: getfield minor_ : I
      //   376: aload_2
      //   377: invokevirtual hasMinor : ()Z
      //   380: aload_2
      //   381: getfield minor_ : I
      //   384: invokeinterface visitInt : (ZIZI)I
      //   389: putfield minor_ : I
      //   392: aload_0
      //   393: aload_1
      //   394: aload_0
      //   395: invokevirtual hasPatch : ()Z
      //   398: aload_0
      //   399: getfield patch_ : I
      //   402: aload_2
      //   403: invokevirtual hasPatch : ()Z
      //   406: aload_2
      //   407: getfield patch_ : I
      //   410: invokeinterface visitInt : (ZIZI)I
      //   415: putfield patch_ : I
      //   418: aload_0
      //   419: aload_1
      //   420: aload_0
      //   421: invokevirtual hasSuffix : ()Z
      //   424: aload_0
      //   425: getfield suffix_ : Ljava/lang/String;
      //   428: aload_2
      //   429: invokevirtual hasSuffix : ()Z
      //   432: aload_2
      //   433: getfield suffix_ : Ljava/lang/String;
      //   436: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   441: putfield suffix_ : Ljava/lang/String;
      //   444: aload_1
      //   445: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   448: if_acmpne -> 464
      //   451: aload_0
      //   452: aload_0
      //   453: getfield bitField0_ : I
      //   456: aload_2
      //   457: getfield bitField0_ : I
      //   460: ior
      //   461: putfield bitField0_ : I
      //   464: aload_0
      //   465: areturn
      //   466: new com/google/protobuf/compiler/PluginProtos$Version$Builder
      //   469: dup
      //   470: aconst_null
      //   471: invokespecial <init> : (Lcom/google/protobuf/compiler/PluginProtos$1;)V
      //   474: areturn
      //   475: aconst_null
      //   476: areturn
      //   477: getstatic com/google/protobuf/compiler/PluginProtos$Version.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$Version;
      //   480: areturn
      //   481: new com/google/protobuf/compiler/PluginProtos$Version
      //   484: dup
      //   485: invokespecial <init> : ()V
      //   488: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	308	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	280	java/io/IOException
      //   128	134	276	finally
      //   167	177	308	com/google/protobuf/InvalidProtocolBufferException
      //   167	177	280	java/io/IOException
      //   167	177	276	finally
      //   183	204	308	com/google/protobuf/InvalidProtocolBufferException
      //   183	204	280	java/io/IOException
      //   183	204	276	finally
      //   207	225	308	com/google/protobuf/InvalidProtocolBufferException
      //   207	225	280	java/io/IOException
      //   207	225	276	finally
      //   228	246	308	com/google/protobuf/InvalidProtocolBufferException
      //   228	246	280	java/io/IOException
      //   228	246	276	finally
      //   249	267	308	com/google/protobuf/InvalidProtocolBufferException
      //   249	267	280	java/io/IOException
      //   249	267	276	finally
      //   281	308	276	finally
      //   309	324	276	finally
    }
    
    public int getMajor() {
      return this.major_;
    }
    
    public int getMinor() {
      return this.minor_;
    }
    
    public int getPatch() {
      return this.patch_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if ((this.bitField0_ & 0x1) == 1)
        j = 0 + CodedOutputStream.computeInt32Size(1, this.major_); 
      i = j;
      if ((this.bitField0_ & 0x2) == 2)
        i = j + CodedOutputStream.computeInt32Size(2, this.minor_); 
      j = i;
      if ((this.bitField0_ & 0x4) == 4)
        j = i + CodedOutputStream.computeInt32Size(3, this.patch_); 
      i = j;
      if ((this.bitField0_ & 0x8) == 8)
        i = j + CodedOutputStream.computeStringSize(4, getSuffix()); 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public String getSuffix() {
      return this.suffix_;
    }
    
    public ByteString getSuffixBytes() {
      return ByteString.copyFromUtf8(this.suffix_);
    }
    
    public boolean hasMajor() {
      int i = this.bitField0_;
      boolean bool = true;
      if ((i & 0x1) != 1)
        bool = false; 
      return bool;
    }
    
    public boolean hasMinor() {
      boolean bool;
      if ((this.bitField0_ & 0x2) == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasPatch() {
      boolean bool;
      if ((this.bitField0_ & 0x4) == 4) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasSuffix() {
      boolean bool;
      if ((this.bitField0_ & 0x8) == 8) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if ((this.bitField0_ & 0x1) == 1)
        param1CodedOutputStream.writeInt32(1, this.major_); 
      if ((this.bitField0_ & 0x2) == 2)
        param1CodedOutputStream.writeInt32(2, this.minor_); 
      if ((this.bitField0_ & 0x4) == 4)
        param1CodedOutputStream.writeInt32(3, this.patch_); 
      if ((this.bitField0_ & 0x8) == 8)
        param1CodedOutputStream.writeString(4, getSuffix()); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Version, Builder> implements PluginProtos.VersionOrBuilder {
      private Builder() {
        super(PluginProtos.Version.DEFAULT_INSTANCE);
      }
      
      public Builder clearMajor() {
        copyOnWrite();
        ((PluginProtos.Version)this.instance).clearMajor();
        return this;
      }
      
      public Builder clearMinor() {
        copyOnWrite();
        ((PluginProtos.Version)this.instance).clearMinor();
        return this;
      }
      
      public Builder clearPatch() {
        copyOnWrite();
        ((PluginProtos.Version)this.instance).clearPatch();
        return this;
      }
      
      public Builder clearSuffix() {
        copyOnWrite();
        ((PluginProtos.Version)this.instance).clearSuffix();
        return this;
      }
      
      public int getMajor() {
        return ((PluginProtos.Version)this.instance).getMajor();
      }
      
      public int getMinor() {
        return ((PluginProtos.Version)this.instance).getMinor();
      }
      
      public int getPatch() {
        return ((PluginProtos.Version)this.instance).getPatch();
      }
      
      public String getSuffix() {
        return ((PluginProtos.Version)this.instance).getSuffix();
      }
      
      public ByteString getSuffixBytes() {
        return ((PluginProtos.Version)this.instance).getSuffixBytes();
      }
      
      public boolean hasMajor() {
        return ((PluginProtos.Version)this.instance).hasMajor();
      }
      
      public boolean hasMinor() {
        return ((PluginProtos.Version)this.instance).hasMinor();
      }
      
      public boolean hasPatch() {
        return ((PluginProtos.Version)this.instance).hasPatch();
      }
      
      public boolean hasSuffix() {
        return ((PluginProtos.Version)this.instance).hasSuffix();
      }
      
      public Builder setMajor(int param2Int) {
        copyOnWrite();
        ((PluginProtos.Version)this.instance).setMajor(param2Int);
        return this;
      }
      
      public Builder setMinor(int param2Int) {
        copyOnWrite();
        ((PluginProtos.Version)this.instance).setMinor(param2Int);
        return this;
      }
      
      public Builder setPatch(int param2Int) {
        copyOnWrite();
        ((PluginProtos.Version)this.instance).setPatch(param2Int);
        return this;
      }
      
      public Builder setSuffix(String param2String) {
        copyOnWrite();
        ((PluginProtos.Version)this.instance).setSuffix(param2String);
        return this;
      }
      
      public Builder setSuffixBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((PluginProtos.Version)this.instance).setSuffixBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Version, Version.Builder> implements VersionOrBuilder {
    private Builder() {
      super(PluginProtos.Version.DEFAULT_INSTANCE);
    }
    
    public Builder clearMajor() {
      copyOnWrite();
      ((PluginProtos.Version)this.instance).clearMajor();
      return this;
    }
    
    public Builder clearMinor() {
      copyOnWrite();
      ((PluginProtos.Version)this.instance).clearMinor();
      return this;
    }
    
    public Builder clearPatch() {
      copyOnWrite();
      ((PluginProtos.Version)this.instance).clearPatch();
      return this;
    }
    
    public Builder clearSuffix() {
      copyOnWrite();
      ((PluginProtos.Version)this.instance).clearSuffix();
      return this;
    }
    
    public int getMajor() {
      return ((PluginProtos.Version)this.instance).getMajor();
    }
    
    public int getMinor() {
      return ((PluginProtos.Version)this.instance).getMinor();
    }
    
    public int getPatch() {
      return ((PluginProtos.Version)this.instance).getPatch();
    }
    
    public String getSuffix() {
      return ((PluginProtos.Version)this.instance).getSuffix();
    }
    
    public ByteString getSuffixBytes() {
      return ((PluginProtos.Version)this.instance).getSuffixBytes();
    }
    
    public boolean hasMajor() {
      return ((PluginProtos.Version)this.instance).hasMajor();
    }
    
    public boolean hasMinor() {
      return ((PluginProtos.Version)this.instance).hasMinor();
    }
    
    public boolean hasPatch() {
      return ((PluginProtos.Version)this.instance).hasPatch();
    }
    
    public boolean hasSuffix() {
      return ((PluginProtos.Version)this.instance).hasSuffix();
    }
    
    public Builder setMajor(int param1Int) {
      copyOnWrite();
      ((PluginProtos.Version)this.instance).setMajor(param1Int);
      return this;
    }
    
    public Builder setMinor(int param1Int) {
      copyOnWrite();
      ((PluginProtos.Version)this.instance).setMinor(param1Int);
      return this;
    }
    
    public Builder setPatch(int param1Int) {
      copyOnWrite();
      ((PluginProtos.Version)this.instance).setPatch(param1Int);
      return this;
    }
    
    public Builder setSuffix(String param1String) {
      copyOnWrite();
      ((PluginProtos.Version)this.instance).setSuffix(param1String);
      return this;
    }
    
    public Builder setSuffixBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PluginProtos.Version)this.instance).setSuffixBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface VersionOrBuilder extends MessageLiteOrBuilder {
    int getMajor();
    
    int getMinor();
    
    int getPatch();
    
    String getSuffix();
    
    ByteString getSuffixBytes();
    
    boolean hasMajor();
    
    boolean hasMinor();
    
    boolean hasPatch();
    
    boolean hasSuffix();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\compiler\PluginProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */