package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class Option extends GeneratedMessageLite<Option, Option.Builder> implements OptionOrBuilder {
  private static final Option DEFAULT_INSTANCE = new Option();
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  private static volatile Parser<Option> PARSER;
  
  public static final int VALUE_FIELD_NUMBER = 2;
  
  private String name_ = "";
  
  private Any value_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearValue() {
    this.value_ = null;
  }
  
  public static Option getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeValue(Any paramAny) {
    Any any = this.value_;
    if (any != null && any != Any.getDefaultInstance()) {
      this.value_ = Any.newBuilder(this.value_).mergeFrom(paramAny).buildPartial();
    } else {
      this.value_ = paramAny;
    } 
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Option paramOption) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramOption);
  }
  
  public static Option parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Option)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Option parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Option)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Option parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Option>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Option parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Option>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Option parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<Option>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Option parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Option>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Option parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<Option>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Option parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Option>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Option parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Option>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Option parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Option>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Option> parser() {
    return DEFAULT_INSTANCE.getParserForType();
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
  
  private void setValue(Any.Builder paramBuilder) {
    this.value_ = paramBuilder.build();
  }
  
  private void setValue(Any paramAny) {
    if (paramAny != null) {
      this.value_ = paramAny;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/Option$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 392, 2 -> 388, 3 -> 386, 4 -> 377, 5 -> 304, 6 -> 110, 7 -> 300, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/protobuf/Option.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/protobuf/Option
    //   72: monitorenter
    //   73: getstatic com/google/protobuf/Option.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/protobuf/Option.DEFAULT_INSTANCE : Lcom/google/protobuf/Option;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/protobuf/Option.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/protobuf/Option
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/protobuf/Option
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/protobuf/Option.PARSER : Lcom/google/protobuf/Parser;
    //   109: areturn
    //   110: aload_2
    //   111: checkcast com/google/protobuf/CodedInputStream
    //   114: astore_2
    //   115: aload_3
    //   116: checkcast com/google/protobuf/ExtensionRegistryLite
    //   119: astore_3
    //   120: iconst_0
    //   121: istore #4
    //   123: iload #4
    //   125: ifne -> 300
    //   128: aload_2
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 244
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 233
    //   146: iload #5
    //   148: bipush #18
    //   150: if_icmpeq -> 168
    //   153: aload_2
    //   154: iload #5
    //   156: invokevirtual skipField : (I)Z
    //   159: ifne -> 123
    //   162: iconst_1
    //   163: istore #4
    //   165: goto -> 123
    //   168: aload_0
    //   169: getfield value_ : Lcom/google/protobuf/Any;
    //   172: ifnull -> 189
    //   175: aload_0
    //   176: getfield value_ : Lcom/google/protobuf/Any;
    //   179: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   182: checkcast com/google/protobuf/Any$Builder
    //   185: astore_1
    //   186: goto -> 191
    //   189: aconst_null
    //   190: astore_1
    //   191: aload_0
    //   192: aload_2
    //   193: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   196: aload_3
    //   197: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   200: checkcast com/google/protobuf/Any
    //   203: putfield value_ : Lcom/google/protobuf/Any;
    //   206: aload_1
    //   207: ifnull -> 123
    //   210: aload_1
    //   211: aload_0
    //   212: getfield value_ : Lcom/google/protobuf/Any;
    //   215: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   218: pop
    //   219: aload_0
    //   220: aload_1
    //   221: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   224: checkcast com/google/protobuf/Any
    //   227: putfield value_ : Lcom/google/protobuf/Any;
    //   230: goto -> 123
    //   233: aload_0
    //   234: aload_2
    //   235: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   238: putfield name_ : Ljava/lang/String;
    //   241: goto -> 123
    //   244: iconst_1
    //   245: istore #4
    //   247: goto -> 123
    //   250: astore_1
    //   251: goto -> 298
    //   254: astore_3
    //   255: new java/lang/RuntimeException
    //   258: astore_1
    //   259: new com/google/protobuf/InvalidProtocolBufferException
    //   262: astore_2
    //   263: aload_2
    //   264: aload_3
    //   265: invokevirtual getMessage : ()Ljava/lang/String;
    //   268: invokespecial <init> : (Ljava/lang/String;)V
    //   271: aload_1
    //   272: aload_2
    //   273: aload_0
    //   274: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   277: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   280: aload_1
    //   281: athrow
    //   282: astore_1
    //   283: new java/lang/RuntimeException
    //   286: astore_2
    //   287: aload_2
    //   288: aload_1
    //   289: aload_0
    //   290: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   293: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   296: aload_2
    //   297: athrow
    //   298: aload_1
    //   299: athrow
    //   300: getstatic com/google/protobuf/Option.DEFAULT_INSTANCE : Lcom/google/protobuf/Option;
    //   303: areturn
    //   304: aload_2
    //   305: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   308: astore_1
    //   309: aload_3
    //   310: checkcast com/google/protobuf/Option
    //   313: astore_2
    //   314: aload_0
    //   315: aload_1
    //   316: aload_0
    //   317: getfield name_ : Ljava/lang/String;
    //   320: invokevirtual isEmpty : ()Z
    //   323: iconst_1
    //   324: ixor
    //   325: aload_0
    //   326: getfield name_ : Ljava/lang/String;
    //   329: iconst_1
    //   330: aload_2
    //   331: getfield name_ : Ljava/lang/String;
    //   334: invokevirtual isEmpty : ()Z
    //   337: ixor
    //   338: aload_2
    //   339: getfield name_ : Ljava/lang/String;
    //   342: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   347: putfield name_ : Ljava/lang/String;
    //   350: aload_0
    //   351: aload_1
    //   352: aload_0
    //   353: getfield value_ : Lcom/google/protobuf/Any;
    //   356: aload_2
    //   357: getfield value_ : Lcom/google/protobuf/Any;
    //   360: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   365: checkcast com/google/protobuf/Any
    //   368: putfield value_ : Lcom/google/protobuf/Any;
    //   371: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   374: astore_1
    //   375: aload_0
    //   376: areturn
    //   377: new com/google/protobuf/Option$Builder
    //   380: dup
    //   381: aconst_null
    //   382: invokespecial <init> : (Lcom/google/protobuf/Option$1;)V
    //   385: areturn
    //   386: aconst_null
    //   387: areturn
    //   388: getstatic com/google/protobuf/Option.DEFAULT_INSTANCE : Lcom/google/protobuf/Option;
    //   391: areturn
    //   392: new com/google/protobuf/Option
    //   395: dup
    //   396: invokespecial <init> : ()V
    //   399: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	282	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	254	java/io/IOException
    //   128	134	250	finally
    //   153	162	282	com/google/protobuf/InvalidProtocolBufferException
    //   153	162	254	java/io/IOException
    //   153	162	250	finally
    //   168	186	282	com/google/protobuf/InvalidProtocolBufferException
    //   168	186	254	java/io/IOException
    //   168	186	250	finally
    //   191	206	282	com/google/protobuf/InvalidProtocolBufferException
    //   191	206	254	java/io/IOException
    //   191	206	250	finally
    //   210	230	282	com/google/protobuf/InvalidProtocolBufferException
    //   210	230	254	java/io/IOException
    //   210	230	250	finally
    //   233	241	282	com/google/protobuf/InvalidProtocolBufferException
    //   233	241	254	java/io/IOException
    //   233	241	250	finally
    //   255	282	250	finally
    //   283	298	250	finally
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
    i = 0;
    if (!this.name_.isEmpty())
      i = 0 + CodedOutputStream.computeStringSize(1, getName()); 
    int j = i;
    if (this.value_ != null)
      j = i + CodedOutputStream.computeMessageSize(2, getValue()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public Any getValue() {
    Any any1 = this.value_;
    Any any2 = any1;
    if (any1 == null)
      any2 = Any.getDefaultInstance(); 
    return any2;
  }
  
  public boolean hasValue() {
    boolean bool;
    if (this.value_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(1, getName()); 
    if (this.value_ != null)
      paramCodedOutputStream.writeMessage(2, getValue()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Option, Builder> implements OptionOrBuilder {
    private Builder() {
      super(Option.DEFAULT_INSTANCE);
    }
    
    public Builder clearName() {
      copyOnWrite();
      this.instance.clearName();
      return this;
    }
    
    public Builder clearValue() {
      copyOnWrite();
      this.instance.clearValue();
      return this;
    }
    
    public String getName() {
      return this.instance.getName();
    }
    
    public ByteString getNameBytes() {
      return this.instance.getNameBytes();
    }
    
    public Any getValue() {
      return this.instance.getValue();
    }
    
    public boolean hasValue() {
      return this.instance.hasValue();
    }
    
    public Builder mergeValue(Any param1Any) {
      copyOnWrite();
      this.instance.mergeValue(param1Any);
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
    
    public Builder setValue(Any.Builder param1Builder) {
      copyOnWrite();
      this.instance.setValue(param1Builder);
      return this;
    }
    
    public Builder setValue(Any param1Any) {
      copyOnWrite();
      this.instance.setValue(param1Any);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\Option.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */