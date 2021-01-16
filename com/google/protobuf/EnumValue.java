package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class EnumValue extends GeneratedMessageLite<EnumValue, EnumValue.Builder> implements EnumValueOrBuilder {
  private static final EnumValue DEFAULT_INSTANCE = new EnumValue();
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  public static final int NUMBER_FIELD_NUMBER = 2;
  
  public static final int OPTIONS_FIELD_NUMBER = 3;
  
  private static volatile Parser<EnumValue> PARSER;
  
  private int bitField0_;
  
  private String name_ = "";
  
  private int number_;
  
  private Internal.ProtobufList<Option> options_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllOptions(Iterable<? extends Option> paramIterable) {
    ensureOptionsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.options_);
  }
  
  private void addOptions(int paramInt, Option.Builder paramBuilder) {
    ensureOptionsIsMutable();
    this.options_.add(paramInt, paramBuilder.build());
  }
  
  private void addOptions(int paramInt, Option paramOption) {
    if (paramOption != null) {
      ensureOptionsIsMutable();
      this.options_.add(paramInt, paramOption);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addOptions(Option.Builder paramBuilder) {
    ensureOptionsIsMutable();
    this.options_.add(paramBuilder.build());
  }
  
  private void addOptions(Option paramOption) {
    if (paramOption != null) {
      ensureOptionsIsMutable();
      this.options_.add(paramOption);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearNumber() {
    this.number_ = 0;
  }
  
  private void clearOptions() {
    this.options_ = emptyProtobufList();
  }
  
  private void ensureOptionsIsMutable() {
    if (!this.options_.isModifiable())
      this.options_ = GeneratedMessageLite.mutableCopy(this.options_); 
  }
  
  public static EnumValue getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(EnumValue paramEnumValue) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramEnumValue);
  }
  
  public static EnumValue parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (EnumValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static EnumValue parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (EnumValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumValue parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<EnumValue>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static EnumValue parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<EnumValue>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static EnumValue parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<EnumValue>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static EnumValue parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<EnumValue>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumValue parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<EnumValue>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static EnumValue parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<EnumValue>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumValue parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<EnumValue>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static EnumValue parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<EnumValue>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<EnumValue> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeOptions(int paramInt) {
    ensureOptionsIsMutable();
    this.options_.remove(paramInt);
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
  
  private void setNumber(int paramInt) {
    this.number_ = paramInt;
  }
  
  private void setOptions(int paramInt, Option.Builder paramBuilder) {
    ensureOptionsIsMutable();
    this.options_.set(paramInt, paramBuilder.build());
  }
  
  private void setOptions(int paramInt, Option paramOption) {
    if (paramOption != null) {
      ensureOptionsIsMutable();
      this.options_.set(paramInt, paramOption);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/EnumValue$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 471, 2 -> 467, 3 -> 456, 4 -> 447, 5 -> 309, 6 -> 118, 7 -> 305, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/protobuf/EnumValue.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/protobuf/EnumValue
    //   80: monitorenter
    //   81: getstatic com/google/protobuf/EnumValue.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/protobuf/EnumValue.DEFAULT_INSTANCE : Lcom/google/protobuf/EnumValue;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/protobuf/EnumValue.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/protobuf/EnumValue
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/protobuf/EnumValue
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/protobuf/EnumValue.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_1
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_2
    //   128: iload #6
    //   130: ifne -> 305
    //   133: aload_1
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 249
    //   144: iload #4
    //   146: bipush #10
    //   148: if_icmpeq -> 238
    //   151: iload #4
    //   153: bipush #16
    //   155: if_icmpeq -> 227
    //   158: iload #4
    //   160: bipush #26
    //   162: if_icmpeq -> 180
    //   165: aload_1
    //   166: iload #4
    //   168: invokevirtual skipField : (I)Z
    //   171: ifne -> 128
    //   174: iconst_1
    //   175: istore #6
    //   177: goto -> 128
    //   180: aload_0
    //   181: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   184: invokeinterface isModifiable : ()Z
    //   189: ifne -> 203
    //   192: aload_0
    //   193: aload_0
    //   194: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   197: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   200: putfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   203: aload_0
    //   204: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   207: aload_1
    //   208: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   211: aload_2
    //   212: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   215: checkcast com/google/protobuf/Option
    //   218: invokeinterface add : (Ljava/lang/Object;)Z
    //   223: pop
    //   224: goto -> 128
    //   227: aload_0
    //   228: aload_1
    //   229: invokevirtual readInt32 : ()I
    //   232: putfield number_ : I
    //   235: goto -> 128
    //   238: aload_0
    //   239: aload_1
    //   240: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   243: putfield name_ : Ljava/lang/String;
    //   246: goto -> 128
    //   249: iconst_1
    //   250: istore #6
    //   252: goto -> 128
    //   255: astore_1
    //   256: goto -> 303
    //   259: astore_2
    //   260: new java/lang/RuntimeException
    //   263: astore_3
    //   264: new com/google/protobuf/InvalidProtocolBufferException
    //   267: astore_1
    //   268: aload_1
    //   269: aload_2
    //   270: invokevirtual getMessage : ()Ljava/lang/String;
    //   273: invokespecial <init> : (Ljava/lang/String;)V
    //   276: aload_3
    //   277: aload_1
    //   278: aload_0
    //   279: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   282: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   285: aload_3
    //   286: athrow
    //   287: astore_1
    //   288: new java/lang/RuntimeException
    //   291: astore_2
    //   292: aload_2
    //   293: aload_1
    //   294: aload_0
    //   295: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   298: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   301: aload_2
    //   302: athrow
    //   303: aload_1
    //   304: athrow
    //   305: getstatic com/google/protobuf/EnumValue.DEFAULT_INSTANCE : Lcom/google/protobuf/EnumValue;
    //   308: areturn
    //   309: aload_2
    //   310: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   313: astore_1
    //   314: aload_3
    //   315: checkcast com/google/protobuf/EnumValue
    //   318: astore_2
    //   319: aload_0
    //   320: aload_1
    //   321: aload_0
    //   322: getfield name_ : Ljava/lang/String;
    //   325: invokevirtual isEmpty : ()Z
    //   328: iconst_1
    //   329: ixor
    //   330: aload_0
    //   331: getfield name_ : Ljava/lang/String;
    //   334: aload_2
    //   335: getfield name_ : Ljava/lang/String;
    //   338: invokevirtual isEmpty : ()Z
    //   341: iconst_1
    //   342: ixor
    //   343: aload_2
    //   344: getfield name_ : Ljava/lang/String;
    //   347: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   352: putfield name_ : Ljava/lang/String;
    //   355: aload_0
    //   356: getfield number_ : I
    //   359: ifeq -> 368
    //   362: iconst_1
    //   363: istore #7
    //   365: goto -> 371
    //   368: iconst_0
    //   369: istore #7
    //   371: aload_0
    //   372: getfield number_ : I
    //   375: istore #6
    //   377: aload_2
    //   378: getfield number_ : I
    //   381: ifeq -> 387
    //   384: iconst_1
    //   385: istore #5
    //   387: aload_0
    //   388: aload_1
    //   389: iload #7
    //   391: iload #6
    //   393: iload #5
    //   395: aload_2
    //   396: getfield number_ : I
    //   399: invokeinterface visitInt : (ZIZI)I
    //   404: putfield number_ : I
    //   407: aload_0
    //   408: aload_1
    //   409: aload_0
    //   410: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   413: aload_2
    //   414: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   417: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   422: putfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   425: aload_1
    //   426: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   429: if_acmpne -> 445
    //   432: aload_0
    //   433: aload_0
    //   434: getfield bitField0_ : I
    //   437: aload_2
    //   438: getfield bitField0_ : I
    //   441: ior
    //   442: putfield bitField0_ : I
    //   445: aload_0
    //   446: areturn
    //   447: new com/google/protobuf/EnumValue$Builder
    //   450: dup
    //   451: aconst_null
    //   452: invokespecial <init> : (Lcom/google/protobuf/EnumValue$1;)V
    //   455: areturn
    //   456: aload_0
    //   457: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   460: invokeinterface makeImmutable : ()V
    //   465: aconst_null
    //   466: areturn
    //   467: getstatic com/google/protobuf/EnumValue.DEFAULT_INSTANCE : Lcom/google/protobuf/EnumValue;
    //   470: areturn
    //   471: new com/google/protobuf/EnumValue
    //   474: dup
    //   475: invokespecial <init> : ()V
    //   478: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	287	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	259	java/io/IOException
    //   133	139	255	finally
    //   165	174	287	com/google/protobuf/InvalidProtocolBufferException
    //   165	174	259	java/io/IOException
    //   165	174	255	finally
    //   180	203	287	com/google/protobuf/InvalidProtocolBufferException
    //   180	203	259	java/io/IOException
    //   180	203	255	finally
    //   203	224	287	com/google/protobuf/InvalidProtocolBufferException
    //   203	224	259	java/io/IOException
    //   203	224	255	finally
    //   227	235	287	com/google/protobuf/InvalidProtocolBufferException
    //   227	235	259	java/io/IOException
    //   227	235	255	finally
    //   238	246	287	com/google/protobuf/InvalidProtocolBufferException
    //   238	246	259	java/io/IOException
    //   238	246	255	finally
    //   260	287	255	finally
    //   288	303	255	finally
  }
  
  public String getName() {
    return this.name_;
  }
  
  public ByteString getNameBytes() {
    return ByteString.copyFromUtf8(this.name_);
  }
  
  public int getNumber() {
    return this.number_;
  }
  
  public Option getOptions(int paramInt) {
    return this.options_.get(paramInt);
  }
  
  public int getOptionsCount() {
    return this.options_.size();
  }
  
  public List<Option> getOptionsList() {
    return this.options_;
  }
  
  public OptionOrBuilder getOptionsOrBuilder(int paramInt) {
    return this.options_.get(paramInt);
  }
  
  public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
    return (List)this.options_;
  }
  
  public int getSerializedSize() {
    byte b2;
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    boolean bool = this.name_.isEmpty();
    byte b1 = 0;
    if (!bool) {
      b2 = CodedOutputStream.computeStringSize(1, getName()) + 0;
    } else {
      b2 = 0;
    } 
    int j = this.number_;
    i = b2;
    byte b3 = b1;
    if (j != 0) {
      i = b2 + CodedOutputStream.computeInt32Size(2, j);
      b3 = b1;
    } 
    while (b3 < this.options_.size()) {
      i += CodedOutputStream.computeMessageSize(3, this.options_.get(b3));
      b3++;
    } 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(1, getName()); 
    int i = this.number_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(2, i); 
    for (i = 0; i < this.options_.size(); i++)
      paramCodedOutputStream.writeMessage(3, this.options_.get(i)); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<EnumValue, Builder> implements EnumValueOrBuilder {
    private Builder() {
      super(EnumValue.DEFAULT_INSTANCE);
    }
    
    public Builder addAllOptions(Iterable<? extends Option> param1Iterable) {
      copyOnWrite();
      this.instance.addAllOptions(param1Iterable);
      return this;
    }
    
    public Builder addOptions(int param1Int, Option.Builder param1Builder) {
      copyOnWrite();
      this.instance.addOptions(param1Int, param1Builder);
      return this;
    }
    
    public Builder addOptions(int param1Int, Option param1Option) {
      copyOnWrite();
      this.instance.addOptions(param1Int, param1Option);
      return this;
    }
    
    public Builder addOptions(Option.Builder param1Builder) {
      copyOnWrite();
      this.instance.addOptions(param1Builder);
      return this;
    }
    
    public Builder addOptions(Option param1Option) {
      copyOnWrite();
      this.instance.addOptions(param1Option);
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      this.instance.clearName();
      return this;
    }
    
    public Builder clearNumber() {
      copyOnWrite();
      this.instance.clearNumber();
      return this;
    }
    
    public Builder clearOptions() {
      copyOnWrite();
      this.instance.clearOptions();
      return this;
    }
    
    public String getName() {
      return this.instance.getName();
    }
    
    public ByteString getNameBytes() {
      return this.instance.getNameBytes();
    }
    
    public int getNumber() {
      return this.instance.getNumber();
    }
    
    public Option getOptions(int param1Int) {
      return this.instance.getOptions(param1Int);
    }
    
    public int getOptionsCount() {
      return this.instance.getOptionsCount();
    }
    
    public List<Option> getOptionsList() {
      return Collections.unmodifiableList(this.instance.getOptionsList());
    }
    
    public Builder removeOptions(int param1Int) {
      copyOnWrite();
      this.instance.removeOptions(param1Int);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      this.instance.setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.setNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setNumber(int param1Int) {
      copyOnWrite();
      this.instance.setNumber(param1Int);
      return this;
    }
    
    public Builder setOptions(int param1Int, Option.Builder param1Builder) {
      copyOnWrite();
      this.instance.setOptions(param1Int, param1Builder);
      return this;
    }
    
    public Builder setOptions(int param1Int, Option param1Option) {
      copyOnWrite();
      this.instance.setOptions(param1Int, param1Option);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\EnumValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */