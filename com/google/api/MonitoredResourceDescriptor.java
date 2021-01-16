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

public final class MonitoredResourceDescriptor extends GeneratedMessageLite<MonitoredResourceDescriptor, MonitoredResourceDescriptor.Builder> implements MonitoredResourceDescriptorOrBuilder {
  private static final MonitoredResourceDescriptor DEFAULT_INSTANCE = new MonitoredResourceDescriptor();
  
  public static final int DESCRIPTION_FIELD_NUMBER = 3;
  
  public static final int DISPLAY_NAME_FIELD_NUMBER = 2;
  
  public static final int LABELS_FIELD_NUMBER = 4;
  
  public static final int NAME_FIELD_NUMBER = 5;
  
  private static volatile Parser<MonitoredResourceDescriptor> PARSER;
  
  public static final int TYPE_FIELD_NUMBER = 1;
  
  private int bitField0_;
  
  private String description_ = "";
  
  private String displayName_ = "";
  
  private Internal.ProtobufList<LabelDescriptor> labels_ = emptyProtobufList();
  
  private String name_ = "";
  
  private String type_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllLabels(Iterable<? extends LabelDescriptor> paramIterable) {
    ensureLabelsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.labels_);
  }
  
  private void addLabels(int paramInt, LabelDescriptor.Builder paramBuilder) {
    ensureLabelsIsMutable();
    this.labels_.add(paramInt, paramBuilder.build());
  }
  
  private void addLabels(int paramInt, LabelDescriptor paramLabelDescriptor) {
    if (paramLabelDescriptor != null) {
      ensureLabelsIsMutable();
      this.labels_.add(paramInt, paramLabelDescriptor);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addLabels(LabelDescriptor.Builder paramBuilder) {
    ensureLabelsIsMutable();
    this.labels_.add(paramBuilder.build());
  }
  
  private void addLabels(LabelDescriptor paramLabelDescriptor) {
    if (paramLabelDescriptor != null) {
      ensureLabelsIsMutable();
      this.labels_.add(paramLabelDescriptor);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearDescription() {
    this.description_ = getDefaultInstance().getDescription();
  }
  
  private void clearDisplayName() {
    this.displayName_ = getDefaultInstance().getDisplayName();
  }
  
  private void clearLabels() {
    this.labels_ = emptyProtobufList();
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearType() {
    this.type_ = getDefaultInstance().getType();
  }
  
  private void ensureLabelsIsMutable() {
    if (!this.labels_.isModifiable())
      this.labels_ = GeneratedMessageLite.mutableCopy(this.labels_); 
  }
  
  public static MonitoredResourceDescriptor getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(MonitoredResourceDescriptor paramMonitoredResourceDescriptor) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramMonitoredResourceDescriptor);
  }
  
  public static MonitoredResourceDescriptor parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (MonitoredResourceDescriptor)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static MonitoredResourceDescriptor parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MonitoredResourceDescriptor)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MonitoredResourceDescriptor parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (MonitoredResourceDescriptor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static MonitoredResourceDescriptor parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MonitoredResourceDescriptor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static MonitoredResourceDescriptor parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (MonitoredResourceDescriptor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static MonitoredResourceDescriptor parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MonitoredResourceDescriptor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static MonitoredResourceDescriptor parseFrom(InputStream paramInputStream) throws IOException {
    return (MonitoredResourceDescriptor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static MonitoredResourceDescriptor parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MonitoredResourceDescriptor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MonitoredResourceDescriptor parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (MonitoredResourceDescriptor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static MonitoredResourceDescriptor parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MonitoredResourceDescriptor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<MonitoredResourceDescriptor> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeLabels(int paramInt) {
    ensureLabelsIsMutable();
    this.labels_.remove(paramInt);
  }
  
  private void setDescription(String paramString) {
    if (paramString != null) {
      this.description_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDescriptionBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.description_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDisplayName(String paramString) {
    if (paramString != null) {
      this.displayName_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDisplayNameBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.displayName_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setLabels(int paramInt, LabelDescriptor.Builder paramBuilder) {
    ensureLabelsIsMutable();
    this.labels_.set(paramInt, paramBuilder.build());
  }
  
  private void setLabels(int paramInt, LabelDescriptor paramLabelDescriptor) {
    if (paramLabelDescriptor != null) {
      ensureLabelsIsMutable();
      this.labels_.set(paramInt, paramLabelDescriptor);
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
  
  private void setType(String paramString) {
    if (paramString != null) {
      this.type_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setTypeBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.type_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/MonitoredResourceDescriptor$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 558, 2 -> 554, 3 -> 543, 4 -> 534, 5 -> 340, 6 -> 110, 7 -> 336, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/api/MonitoredResourceDescriptor.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/api/MonitoredResourceDescriptor
    //   72: monitorenter
    //   73: getstatic com/google/api/MonitoredResourceDescriptor.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/api/MonitoredResourceDescriptor.DEFAULT_INSTANCE : Lcom/google/api/MonitoredResourceDescriptor;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/api/MonitoredResourceDescriptor.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/api/MonitoredResourceDescriptor
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/api/MonitoredResourceDescriptor
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/api/MonitoredResourceDescriptor.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 336
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 280
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 269
    //   146: iload #5
    //   148: bipush #18
    //   150: if_icmpeq -> 258
    //   153: iload #5
    //   155: bipush #26
    //   157: if_icmpeq -> 247
    //   160: iload #5
    //   162: bipush #34
    //   164: if_icmpeq -> 200
    //   167: iload #5
    //   169: bipush #42
    //   171: if_icmpeq -> 189
    //   174: aload_1
    //   175: iload #5
    //   177: invokevirtual skipField : (I)Z
    //   180: ifne -> 123
    //   183: iconst_1
    //   184: istore #4
    //   186: goto -> 123
    //   189: aload_0
    //   190: aload_1
    //   191: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   194: putfield name_ : Ljava/lang/String;
    //   197: goto -> 123
    //   200: aload_0
    //   201: getfield labels_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   204: invokeinterface isModifiable : ()Z
    //   209: ifne -> 223
    //   212: aload_0
    //   213: aload_0
    //   214: getfield labels_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   217: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   220: putfield labels_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   223: aload_0
    //   224: getfield labels_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   227: aload_1
    //   228: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   231: aload_2
    //   232: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   235: checkcast com/google/api/LabelDescriptor
    //   238: invokeinterface add : (Ljava/lang/Object;)Z
    //   243: pop
    //   244: goto -> 123
    //   247: aload_0
    //   248: aload_1
    //   249: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   252: putfield description_ : Ljava/lang/String;
    //   255: goto -> 123
    //   258: aload_0
    //   259: aload_1
    //   260: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   263: putfield displayName_ : Ljava/lang/String;
    //   266: goto -> 123
    //   269: aload_0
    //   270: aload_1
    //   271: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   274: putfield type_ : Ljava/lang/String;
    //   277: goto -> 123
    //   280: iconst_1
    //   281: istore #4
    //   283: goto -> 123
    //   286: astore_1
    //   287: goto -> 334
    //   290: astore_1
    //   291: new java/lang/RuntimeException
    //   294: astore_2
    //   295: new com/google/protobuf/InvalidProtocolBufferException
    //   298: astore_3
    //   299: aload_3
    //   300: aload_1
    //   301: invokevirtual getMessage : ()Ljava/lang/String;
    //   304: invokespecial <init> : (Ljava/lang/String;)V
    //   307: aload_2
    //   308: aload_3
    //   309: aload_0
    //   310: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   313: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   316: aload_2
    //   317: athrow
    //   318: astore_1
    //   319: new java/lang/RuntimeException
    //   322: astore_2
    //   323: aload_2
    //   324: aload_1
    //   325: aload_0
    //   326: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   329: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   332: aload_2
    //   333: athrow
    //   334: aload_1
    //   335: athrow
    //   336: getstatic com/google/api/MonitoredResourceDescriptor.DEFAULT_INSTANCE : Lcom/google/api/MonitoredResourceDescriptor;
    //   339: areturn
    //   340: aload_2
    //   341: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   344: astore_1
    //   345: aload_3
    //   346: checkcast com/google/api/MonitoredResourceDescriptor
    //   349: astore_2
    //   350: aload_0
    //   351: aload_1
    //   352: aload_0
    //   353: getfield name_ : Ljava/lang/String;
    //   356: invokevirtual isEmpty : ()Z
    //   359: iconst_1
    //   360: ixor
    //   361: aload_0
    //   362: getfield name_ : Ljava/lang/String;
    //   365: aload_2
    //   366: getfield name_ : Ljava/lang/String;
    //   369: invokevirtual isEmpty : ()Z
    //   372: iconst_1
    //   373: ixor
    //   374: aload_2
    //   375: getfield name_ : Ljava/lang/String;
    //   378: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   383: putfield name_ : Ljava/lang/String;
    //   386: aload_0
    //   387: aload_1
    //   388: aload_0
    //   389: getfield type_ : Ljava/lang/String;
    //   392: invokevirtual isEmpty : ()Z
    //   395: iconst_1
    //   396: ixor
    //   397: aload_0
    //   398: getfield type_ : Ljava/lang/String;
    //   401: aload_2
    //   402: getfield type_ : Ljava/lang/String;
    //   405: invokevirtual isEmpty : ()Z
    //   408: iconst_1
    //   409: ixor
    //   410: aload_2
    //   411: getfield type_ : Ljava/lang/String;
    //   414: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   419: putfield type_ : Ljava/lang/String;
    //   422: aload_0
    //   423: aload_1
    //   424: aload_0
    //   425: getfield displayName_ : Ljava/lang/String;
    //   428: invokevirtual isEmpty : ()Z
    //   431: iconst_1
    //   432: ixor
    //   433: aload_0
    //   434: getfield displayName_ : Ljava/lang/String;
    //   437: aload_2
    //   438: getfield displayName_ : Ljava/lang/String;
    //   441: invokevirtual isEmpty : ()Z
    //   444: iconst_1
    //   445: ixor
    //   446: aload_2
    //   447: getfield displayName_ : Ljava/lang/String;
    //   450: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   455: putfield displayName_ : Ljava/lang/String;
    //   458: aload_0
    //   459: aload_1
    //   460: aload_0
    //   461: getfield description_ : Ljava/lang/String;
    //   464: invokevirtual isEmpty : ()Z
    //   467: iconst_1
    //   468: ixor
    //   469: aload_0
    //   470: getfield description_ : Ljava/lang/String;
    //   473: iconst_1
    //   474: aload_2
    //   475: getfield description_ : Ljava/lang/String;
    //   478: invokevirtual isEmpty : ()Z
    //   481: ixor
    //   482: aload_2
    //   483: getfield description_ : Ljava/lang/String;
    //   486: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   491: putfield description_ : Ljava/lang/String;
    //   494: aload_0
    //   495: aload_1
    //   496: aload_0
    //   497: getfield labels_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   500: aload_2
    //   501: getfield labels_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   504: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   509: putfield labels_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   512: aload_1
    //   513: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   516: if_acmpne -> 532
    //   519: aload_0
    //   520: aload_0
    //   521: getfield bitField0_ : I
    //   524: aload_2
    //   525: getfield bitField0_ : I
    //   528: ior
    //   529: putfield bitField0_ : I
    //   532: aload_0
    //   533: areturn
    //   534: new com/google/api/MonitoredResourceDescriptor$Builder
    //   537: dup
    //   538: aconst_null
    //   539: invokespecial <init> : (Lcom/google/api/MonitoredResourceDescriptor$1;)V
    //   542: areturn
    //   543: aload_0
    //   544: getfield labels_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   547: invokeinterface makeImmutable : ()V
    //   552: aconst_null
    //   553: areturn
    //   554: getstatic com/google/api/MonitoredResourceDescriptor.DEFAULT_INSTANCE : Lcom/google/api/MonitoredResourceDescriptor;
    //   557: areturn
    //   558: new com/google/api/MonitoredResourceDescriptor
    //   561: dup
    //   562: invokespecial <init> : ()V
    //   565: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	318	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	290	java/io/IOException
    //   128	134	286	finally
    //   174	183	318	com/google/protobuf/InvalidProtocolBufferException
    //   174	183	290	java/io/IOException
    //   174	183	286	finally
    //   189	197	318	com/google/protobuf/InvalidProtocolBufferException
    //   189	197	290	java/io/IOException
    //   189	197	286	finally
    //   200	223	318	com/google/protobuf/InvalidProtocolBufferException
    //   200	223	290	java/io/IOException
    //   200	223	286	finally
    //   223	244	318	com/google/protobuf/InvalidProtocolBufferException
    //   223	244	290	java/io/IOException
    //   223	244	286	finally
    //   247	255	318	com/google/protobuf/InvalidProtocolBufferException
    //   247	255	290	java/io/IOException
    //   247	255	286	finally
    //   258	266	318	com/google/protobuf/InvalidProtocolBufferException
    //   258	266	290	java/io/IOException
    //   258	266	286	finally
    //   269	277	318	com/google/protobuf/InvalidProtocolBufferException
    //   269	277	290	java/io/IOException
    //   269	277	286	finally
    //   291	318	286	finally
    //   319	334	286	finally
  }
  
  public String getDescription() {
    return this.description_;
  }
  
  public ByteString getDescriptionBytes() {
    return ByteString.copyFromUtf8(this.description_);
  }
  
  public String getDisplayName() {
    return this.displayName_;
  }
  
  public ByteString getDisplayNameBytes() {
    return ByteString.copyFromUtf8(this.displayName_);
  }
  
  public LabelDescriptor getLabels(int paramInt) {
    return (LabelDescriptor)this.labels_.get(paramInt);
  }
  
  public int getLabelsCount() {
    return this.labels_.size();
  }
  
  public List<LabelDescriptor> getLabelsList() {
    return (List<LabelDescriptor>)this.labels_;
  }
  
  public LabelDescriptorOrBuilder getLabelsOrBuilder(int paramInt) {
    return (LabelDescriptorOrBuilder)this.labels_.get(paramInt);
  }
  
  public List<? extends LabelDescriptorOrBuilder> getLabelsOrBuilderList() {
    return (List)this.labels_;
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
    boolean bool = this.type_.isEmpty();
    byte b1 = 0;
    if (!bool) {
      i = CodedOutputStream.computeStringSize(1, getType()) + 0;
    } else {
      i = 0;
    } 
    int j = i;
    if (!this.displayName_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(2, getDisplayName()); 
    i = j;
    byte b2 = b1;
    if (!this.description_.isEmpty()) {
      i = j + CodedOutputStream.computeStringSize(3, getDescription());
      b2 = b1;
    } 
    while (b2 < this.labels_.size()) {
      i += CodedOutputStream.computeMessageSize(4, (MessageLite)this.labels_.get(b2));
      b2++;
    } 
    j = i;
    if (!this.name_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(5, getName()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public String getType() {
    return this.type_;
  }
  
  public ByteString getTypeBytes() {
    return ByteString.copyFromUtf8(this.type_);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.type_.isEmpty())
      paramCodedOutputStream.writeString(1, getType()); 
    if (!this.displayName_.isEmpty())
      paramCodedOutputStream.writeString(2, getDisplayName()); 
    if (!this.description_.isEmpty())
      paramCodedOutputStream.writeString(3, getDescription()); 
    for (byte b = 0; b < this.labels_.size(); b++)
      paramCodedOutputStream.writeMessage(4, (MessageLite)this.labels_.get(b)); 
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(5, getName()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<MonitoredResourceDescriptor, Builder> implements MonitoredResourceDescriptorOrBuilder {
    private Builder() {
      super(MonitoredResourceDescriptor.DEFAULT_INSTANCE);
    }
    
    public Builder addAllLabels(Iterable<? extends LabelDescriptor> param1Iterable) {
      copyOnWrite();
      ((MonitoredResourceDescriptor)this.instance).addAllLabels(param1Iterable);
      return this;
    }
    
    public Builder addLabels(int param1Int, LabelDescriptor.Builder param1Builder) {
      copyOnWrite();
      ((MonitoredResourceDescriptor)this.instance).addLabels(param1Int, param1Builder);
      return this;
    }
    
    public Builder addLabels(int param1Int, LabelDescriptor param1LabelDescriptor) {
      copyOnWrite();
      ((MonitoredResourceDescriptor)this.instance).addLabels(param1Int, param1LabelDescriptor);
      return this;
    }
    
    public Builder addLabels(LabelDescriptor.Builder param1Builder) {
      copyOnWrite();
      ((MonitoredResourceDescriptor)this.instance).addLabels(param1Builder);
      return this;
    }
    
    public Builder addLabels(LabelDescriptor param1LabelDescriptor) {
      copyOnWrite();
      ((MonitoredResourceDescriptor)this.instance).addLabels(param1LabelDescriptor);
      return this;
    }
    
    public Builder clearDescription() {
      copyOnWrite();
      ((MonitoredResourceDescriptor)this.instance).clearDescription();
      return this;
    }
    
    public Builder clearDisplayName() {
      copyOnWrite();
      ((MonitoredResourceDescriptor)this.instance).clearDisplayName();
      return this;
    }
    
    public Builder clearLabels() {
      copyOnWrite();
      ((MonitoredResourceDescriptor)this.instance).clearLabels();
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      ((MonitoredResourceDescriptor)this.instance).clearName();
      return this;
    }
    
    public Builder clearType() {
      copyOnWrite();
      ((MonitoredResourceDescriptor)this.instance).clearType();
      return this;
    }
    
    public String getDescription() {
      return ((MonitoredResourceDescriptor)this.instance).getDescription();
    }
    
    public ByteString getDescriptionBytes() {
      return ((MonitoredResourceDescriptor)this.instance).getDescriptionBytes();
    }
    
    public String getDisplayName() {
      return ((MonitoredResourceDescriptor)this.instance).getDisplayName();
    }
    
    public ByteString getDisplayNameBytes() {
      return ((MonitoredResourceDescriptor)this.instance).getDisplayNameBytes();
    }
    
    public LabelDescriptor getLabels(int param1Int) {
      return ((MonitoredResourceDescriptor)this.instance).getLabels(param1Int);
    }
    
    public int getLabelsCount() {
      return ((MonitoredResourceDescriptor)this.instance).getLabelsCount();
    }
    
    public List<LabelDescriptor> getLabelsList() {
      return Collections.unmodifiableList(((MonitoredResourceDescriptor)this.instance).getLabelsList());
    }
    
    public String getName() {
      return ((MonitoredResourceDescriptor)this.instance).getName();
    }
    
    public ByteString getNameBytes() {
      return ((MonitoredResourceDescriptor)this.instance).getNameBytes();
    }
    
    public String getType() {
      return ((MonitoredResourceDescriptor)this.instance).getType();
    }
    
    public ByteString getTypeBytes() {
      return ((MonitoredResourceDescriptor)this.instance).getTypeBytes();
    }
    
    public Builder removeLabels(int param1Int) {
      copyOnWrite();
      ((MonitoredResourceDescriptor)this.instance).removeLabels(param1Int);
      return this;
    }
    
    public Builder setDescription(String param1String) {
      copyOnWrite();
      ((MonitoredResourceDescriptor)this.instance).setDescription(param1String);
      return this;
    }
    
    public Builder setDescriptionBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((MonitoredResourceDescriptor)this.instance).setDescriptionBytes(param1ByteString);
      return this;
    }
    
    public Builder setDisplayName(String param1String) {
      copyOnWrite();
      ((MonitoredResourceDescriptor)this.instance).setDisplayName(param1String);
      return this;
    }
    
    public Builder setDisplayNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((MonitoredResourceDescriptor)this.instance).setDisplayNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setLabels(int param1Int, LabelDescriptor.Builder param1Builder) {
      copyOnWrite();
      ((MonitoredResourceDescriptor)this.instance).setLabels(param1Int, param1Builder);
      return this;
    }
    
    public Builder setLabels(int param1Int, LabelDescriptor param1LabelDescriptor) {
      copyOnWrite();
      ((MonitoredResourceDescriptor)this.instance).setLabels(param1Int, param1LabelDescriptor);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      ((MonitoredResourceDescriptor)this.instance).setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((MonitoredResourceDescriptor)this.instance).setNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setType(String param1String) {
      copyOnWrite();
      ((MonitoredResourceDescriptor)this.instance).setType(param1String);
      return this;
    }
    
    public Builder setTypeBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((MonitoredResourceDescriptor)this.instance).setTypeBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\MonitoredResourceDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */