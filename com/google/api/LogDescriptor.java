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

public final class LogDescriptor extends GeneratedMessageLite<LogDescriptor, LogDescriptor.Builder> implements LogDescriptorOrBuilder {
  private static final LogDescriptor DEFAULT_INSTANCE = new LogDescriptor();
  
  public static final int DESCRIPTION_FIELD_NUMBER = 3;
  
  public static final int DISPLAY_NAME_FIELD_NUMBER = 4;
  
  public static final int LABELS_FIELD_NUMBER = 2;
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  private static volatile Parser<LogDescriptor> PARSER;
  
  private int bitField0_;
  
  private String description_ = "";
  
  private String displayName_ = "";
  
  private Internal.ProtobufList<LabelDescriptor> labels_ = emptyProtobufList();
  
  private String name_ = "";
  
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
  
  private void ensureLabelsIsMutable() {
    if (!this.labels_.isModifiable())
      this.labels_ = GeneratedMessageLite.mutableCopy(this.labels_); 
  }
  
  public static LogDescriptor getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(LogDescriptor paramLogDescriptor) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramLogDescriptor);
  }
  
  public static LogDescriptor parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (LogDescriptor)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static LogDescriptor parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (LogDescriptor)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static LogDescriptor parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (LogDescriptor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static LogDescriptor parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (LogDescriptor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static LogDescriptor parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (LogDescriptor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static LogDescriptor parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (LogDescriptor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static LogDescriptor parseFrom(InputStream paramInputStream) throws IOException {
    return (LogDescriptor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static LogDescriptor parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (LogDescriptor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static LogDescriptor parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (LogDescriptor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static LogDescriptor parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (LogDescriptor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<LogDescriptor> parser() {
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
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/LogDescriptor$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 504, 2 -> 500, 3 -> 489, 4 -> 480, 5 -> 322, 6 -> 110, 7 -> 318, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/api/LogDescriptor.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/api/LogDescriptor
    //   72: monitorenter
    //   73: getstatic com/google/api/LogDescriptor.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/api/LogDescriptor.DEFAULT_INSTANCE : Lcom/google/api/LogDescriptor;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/api/LogDescriptor.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/api/LogDescriptor
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/api/LogDescriptor
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/api/LogDescriptor.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 318
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 262
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 251
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
    //   187: putfield displayName_ : Ljava/lang/String;
    //   190: goto -> 123
    //   193: aload_0
    //   194: aload_1
    //   195: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   198: putfield description_ : Ljava/lang/String;
    //   201: goto -> 123
    //   204: aload_0
    //   205: getfield labels_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   208: invokeinterface isModifiable : ()Z
    //   213: ifne -> 227
    //   216: aload_0
    //   217: aload_0
    //   218: getfield labels_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   221: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   224: putfield labels_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   227: aload_0
    //   228: getfield labels_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   231: aload_1
    //   232: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   235: aload_2
    //   236: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   239: checkcast com/google/api/LabelDescriptor
    //   242: invokeinterface add : (Ljava/lang/Object;)Z
    //   247: pop
    //   248: goto -> 123
    //   251: aload_0
    //   252: aload_1
    //   253: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   256: putfield name_ : Ljava/lang/String;
    //   259: goto -> 123
    //   262: iconst_1
    //   263: istore #4
    //   265: goto -> 123
    //   268: astore_1
    //   269: goto -> 316
    //   272: astore_2
    //   273: new java/lang/RuntimeException
    //   276: astore_1
    //   277: new com/google/protobuf/InvalidProtocolBufferException
    //   280: astore_3
    //   281: aload_3
    //   282: aload_2
    //   283: invokevirtual getMessage : ()Ljava/lang/String;
    //   286: invokespecial <init> : (Ljava/lang/String;)V
    //   289: aload_1
    //   290: aload_3
    //   291: aload_0
    //   292: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   295: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   298: aload_1
    //   299: athrow
    //   300: astore_1
    //   301: new java/lang/RuntimeException
    //   304: astore_2
    //   305: aload_2
    //   306: aload_1
    //   307: aload_0
    //   308: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   311: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   314: aload_2
    //   315: athrow
    //   316: aload_1
    //   317: athrow
    //   318: getstatic com/google/api/LogDescriptor.DEFAULT_INSTANCE : Lcom/google/api/LogDescriptor;
    //   321: areturn
    //   322: aload_2
    //   323: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   326: astore_1
    //   327: aload_3
    //   328: checkcast com/google/api/LogDescriptor
    //   331: astore_2
    //   332: aload_0
    //   333: aload_1
    //   334: aload_0
    //   335: getfield name_ : Ljava/lang/String;
    //   338: invokevirtual isEmpty : ()Z
    //   341: iconst_1
    //   342: ixor
    //   343: aload_0
    //   344: getfield name_ : Ljava/lang/String;
    //   347: aload_2
    //   348: getfield name_ : Ljava/lang/String;
    //   351: invokevirtual isEmpty : ()Z
    //   354: iconst_1
    //   355: ixor
    //   356: aload_2
    //   357: getfield name_ : Ljava/lang/String;
    //   360: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   365: putfield name_ : Ljava/lang/String;
    //   368: aload_0
    //   369: aload_1
    //   370: aload_0
    //   371: getfield labels_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   374: aload_2
    //   375: getfield labels_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   378: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   383: putfield labels_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   386: aload_0
    //   387: aload_1
    //   388: aload_0
    //   389: getfield description_ : Ljava/lang/String;
    //   392: invokevirtual isEmpty : ()Z
    //   395: iconst_1
    //   396: ixor
    //   397: aload_0
    //   398: getfield description_ : Ljava/lang/String;
    //   401: aload_2
    //   402: getfield description_ : Ljava/lang/String;
    //   405: invokevirtual isEmpty : ()Z
    //   408: iconst_1
    //   409: ixor
    //   410: aload_2
    //   411: getfield description_ : Ljava/lang/String;
    //   414: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   419: putfield description_ : Ljava/lang/String;
    //   422: aload_0
    //   423: aload_1
    //   424: aload_0
    //   425: getfield displayName_ : Ljava/lang/String;
    //   428: invokevirtual isEmpty : ()Z
    //   431: iconst_1
    //   432: ixor
    //   433: aload_0
    //   434: getfield displayName_ : Ljava/lang/String;
    //   437: iconst_1
    //   438: aload_2
    //   439: getfield displayName_ : Ljava/lang/String;
    //   442: invokevirtual isEmpty : ()Z
    //   445: ixor
    //   446: aload_2
    //   447: getfield displayName_ : Ljava/lang/String;
    //   450: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   455: putfield displayName_ : Ljava/lang/String;
    //   458: aload_1
    //   459: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   462: if_acmpne -> 478
    //   465: aload_0
    //   466: aload_0
    //   467: getfield bitField0_ : I
    //   470: aload_2
    //   471: getfield bitField0_ : I
    //   474: ior
    //   475: putfield bitField0_ : I
    //   478: aload_0
    //   479: areturn
    //   480: new com/google/api/LogDescriptor$Builder
    //   483: dup
    //   484: aconst_null
    //   485: invokespecial <init> : (Lcom/google/api/LogDescriptor$1;)V
    //   488: areturn
    //   489: aload_0
    //   490: getfield labels_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   493: invokeinterface makeImmutable : ()V
    //   498: aconst_null
    //   499: areturn
    //   500: getstatic com/google/api/LogDescriptor.DEFAULT_INSTANCE : Lcom/google/api/LogDescriptor;
    //   503: areturn
    //   504: new com/google/api/LogDescriptor
    //   507: dup
    //   508: invokespecial <init> : ()V
    //   511: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	300	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	272	java/io/IOException
    //   128	134	268	finally
    //   167	176	300	com/google/protobuf/InvalidProtocolBufferException
    //   167	176	272	java/io/IOException
    //   167	176	268	finally
    //   182	190	300	com/google/protobuf/InvalidProtocolBufferException
    //   182	190	272	java/io/IOException
    //   182	190	268	finally
    //   193	201	300	com/google/protobuf/InvalidProtocolBufferException
    //   193	201	272	java/io/IOException
    //   193	201	268	finally
    //   204	227	300	com/google/protobuf/InvalidProtocolBufferException
    //   204	227	272	java/io/IOException
    //   204	227	268	finally
    //   227	248	300	com/google/protobuf/InvalidProtocolBufferException
    //   227	248	272	java/io/IOException
    //   227	248	268	finally
    //   251	259	300	com/google/protobuf/InvalidProtocolBufferException
    //   251	259	272	java/io/IOException
    //   251	259	268	finally
    //   273	300	268	finally
    //   301	316	268	finally
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
    boolean bool = this.name_.isEmpty();
    int j = 0;
    if (!bool) {
      i = CodedOutputStream.computeStringSize(1, getName()) + 0;
    } else {
      i = 0;
    } 
    while (j < this.labels_.size()) {
      i += CodedOutputStream.computeMessageSize(2, (MessageLite)this.labels_.get(j));
      j++;
    } 
    j = i;
    if (!this.description_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(3, getDescription()); 
    i = j;
    if (!this.displayName_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(4, getDisplayName()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(1, getName()); 
    for (byte b = 0; b < this.labels_.size(); b++)
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.labels_.get(b)); 
    if (!this.description_.isEmpty())
      paramCodedOutputStream.writeString(3, getDescription()); 
    if (!this.displayName_.isEmpty())
      paramCodedOutputStream.writeString(4, getDisplayName()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<LogDescriptor, Builder> implements LogDescriptorOrBuilder {
    private Builder() {
      super(LogDescriptor.DEFAULT_INSTANCE);
    }
    
    public Builder addAllLabels(Iterable<? extends LabelDescriptor> param1Iterable) {
      copyOnWrite();
      ((LogDescriptor)this.instance).addAllLabels(param1Iterable);
      return this;
    }
    
    public Builder addLabels(int param1Int, LabelDescriptor.Builder param1Builder) {
      copyOnWrite();
      ((LogDescriptor)this.instance).addLabels(param1Int, param1Builder);
      return this;
    }
    
    public Builder addLabels(int param1Int, LabelDescriptor param1LabelDescriptor) {
      copyOnWrite();
      ((LogDescriptor)this.instance).addLabels(param1Int, param1LabelDescriptor);
      return this;
    }
    
    public Builder addLabels(LabelDescriptor.Builder param1Builder) {
      copyOnWrite();
      ((LogDescriptor)this.instance).addLabels(param1Builder);
      return this;
    }
    
    public Builder addLabels(LabelDescriptor param1LabelDescriptor) {
      copyOnWrite();
      ((LogDescriptor)this.instance).addLabels(param1LabelDescriptor);
      return this;
    }
    
    public Builder clearDescription() {
      copyOnWrite();
      ((LogDescriptor)this.instance).clearDescription();
      return this;
    }
    
    public Builder clearDisplayName() {
      copyOnWrite();
      ((LogDescriptor)this.instance).clearDisplayName();
      return this;
    }
    
    public Builder clearLabels() {
      copyOnWrite();
      ((LogDescriptor)this.instance).clearLabels();
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      ((LogDescriptor)this.instance).clearName();
      return this;
    }
    
    public String getDescription() {
      return ((LogDescriptor)this.instance).getDescription();
    }
    
    public ByteString getDescriptionBytes() {
      return ((LogDescriptor)this.instance).getDescriptionBytes();
    }
    
    public String getDisplayName() {
      return ((LogDescriptor)this.instance).getDisplayName();
    }
    
    public ByteString getDisplayNameBytes() {
      return ((LogDescriptor)this.instance).getDisplayNameBytes();
    }
    
    public LabelDescriptor getLabels(int param1Int) {
      return ((LogDescriptor)this.instance).getLabels(param1Int);
    }
    
    public int getLabelsCount() {
      return ((LogDescriptor)this.instance).getLabelsCount();
    }
    
    public List<LabelDescriptor> getLabelsList() {
      return Collections.unmodifiableList(((LogDescriptor)this.instance).getLabelsList());
    }
    
    public String getName() {
      return ((LogDescriptor)this.instance).getName();
    }
    
    public ByteString getNameBytes() {
      return ((LogDescriptor)this.instance).getNameBytes();
    }
    
    public Builder removeLabels(int param1Int) {
      copyOnWrite();
      ((LogDescriptor)this.instance).removeLabels(param1Int);
      return this;
    }
    
    public Builder setDescription(String param1String) {
      copyOnWrite();
      ((LogDescriptor)this.instance).setDescription(param1String);
      return this;
    }
    
    public Builder setDescriptionBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((LogDescriptor)this.instance).setDescriptionBytes(param1ByteString);
      return this;
    }
    
    public Builder setDisplayName(String param1String) {
      copyOnWrite();
      ((LogDescriptor)this.instance).setDisplayName(param1String);
      return this;
    }
    
    public Builder setDisplayNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((LogDescriptor)this.instance).setDisplayNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setLabels(int param1Int, LabelDescriptor.Builder param1Builder) {
      copyOnWrite();
      ((LogDescriptor)this.instance).setLabels(param1Int, param1Builder);
      return this;
    }
    
    public Builder setLabels(int param1Int, LabelDescriptor param1LabelDescriptor) {
      copyOnWrite();
      ((LogDescriptor)this.instance).setLabels(param1Int, param1LabelDescriptor);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      ((LogDescriptor)this.instance).setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((LogDescriptor)this.instance).setNameBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\LogDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */