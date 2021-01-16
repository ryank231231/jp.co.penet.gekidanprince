package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class Int32Value extends GeneratedMessageLite<Int32Value, Int32Value.Builder> implements Int32ValueOrBuilder {
  private static final Int32Value DEFAULT_INSTANCE = new Int32Value();
  
  private static volatile Parser<Int32Value> PARSER;
  
  public static final int VALUE_FIELD_NUMBER = 1;
  
  private int value_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearValue() {
    this.value_ = 0;
  }
  
  public static Int32Value getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Int32Value paramInt32Value) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramInt32Value);
  }
  
  public static Int32Value parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Int32Value)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Int32Value parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Int32Value)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Int32Value parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Int32Value>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Int32Value parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Int32Value>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Int32Value parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<Int32Value>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Int32Value parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Int32Value>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Int32Value parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<Int32Value>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Int32Value parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Int32Value>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Int32Value parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Int32Value>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Int32Value parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Int32Value>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Int32Value> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setValue(int paramInt) {
    this.value_ = paramInt;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/Int32Value$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 320, 2 -> 316, 3 -> 314, 4 -> 305, 5 -> 237, 6 -> 118, 7 -> 233, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/protobuf/Int32Value.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/protobuf/Int32Value
    //   80: monitorenter
    //   81: getstatic com/google/protobuf/Int32Value.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/protobuf/Int32Value.DEFAULT_INSTANCE : Lcom/google/protobuf/Int32Value;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/protobuf/Int32Value.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/protobuf/Int32Value
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/protobuf/Int32Value
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/protobuf/Int32Value.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_1
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_2
    //   128: iload #6
    //   130: ifne -> 233
    //   133: aload_1
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 177
    //   144: iload #4
    //   146: bipush #8
    //   148: if_icmpeq -> 166
    //   151: aload_1
    //   152: iload #4
    //   154: invokevirtual skipField : (I)Z
    //   157: ifne -> 128
    //   160: iconst_1
    //   161: istore #6
    //   163: goto -> 128
    //   166: aload_0
    //   167: aload_1
    //   168: invokevirtual readInt32 : ()I
    //   171: putfield value_ : I
    //   174: goto -> 128
    //   177: iconst_1
    //   178: istore #6
    //   180: goto -> 128
    //   183: astore_1
    //   184: goto -> 231
    //   187: astore_2
    //   188: new java/lang/RuntimeException
    //   191: astore_1
    //   192: new com/google/protobuf/InvalidProtocolBufferException
    //   195: astore_3
    //   196: aload_3
    //   197: aload_2
    //   198: invokevirtual getMessage : ()Ljava/lang/String;
    //   201: invokespecial <init> : (Ljava/lang/String;)V
    //   204: aload_1
    //   205: aload_3
    //   206: aload_0
    //   207: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   210: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   213: aload_1
    //   214: athrow
    //   215: astore_2
    //   216: new java/lang/RuntimeException
    //   219: astore_1
    //   220: aload_1
    //   221: aload_2
    //   222: aload_0
    //   223: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   226: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   229: aload_1
    //   230: athrow
    //   231: aload_1
    //   232: athrow
    //   233: getstatic com/google/protobuf/Int32Value.DEFAULT_INSTANCE : Lcom/google/protobuf/Int32Value;
    //   236: areturn
    //   237: aload_2
    //   238: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   241: astore_1
    //   242: aload_3
    //   243: checkcast com/google/protobuf/Int32Value
    //   246: astore_2
    //   247: aload_0
    //   248: getfield value_ : I
    //   251: ifeq -> 260
    //   254: iconst_1
    //   255: istore #7
    //   257: goto -> 263
    //   260: iconst_0
    //   261: istore #7
    //   263: aload_0
    //   264: getfield value_ : I
    //   267: istore #6
    //   269: aload_2
    //   270: getfield value_ : I
    //   273: ifeq -> 279
    //   276: iconst_1
    //   277: istore #5
    //   279: aload_0
    //   280: aload_1
    //   281: iload #7
    //   283: iload #6
    //   285: iload #5
    //   287: aload_2
    //   288: getfield value_ : I
    //   291: invokeinterface visitInt : (ZIZI)I
    //   296: putfield value_ : I
    //   299: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   302: astore_1
    //   303: aload_0
    //   304: areturn
    //   305: new com/google/protobuf/Int32Value$Builder
    //   308: dup
    //   309: aconst_null
    //   310: invokespecial <init> : (Lcom/google/protobuf/Int32Value$1;)V
    //   313: areturn
    //   314: aconst_null
    //   315: areturn
    //   316: getstatic com/google/protobuf/Int32Value.DEFAULT_INSTANCE : Lcom/google/protobuf/Int32Value;
    //   319: areturn
    //   320: new com/google/protobuf/Int32Value
    //   323: dup
    //   324: invokespecial <init> : ()V
    //   327: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	215	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	187	java/io/IOException
    //   133	139	183	finally
    //   151	160	215	com/google/protobuf/InvalidProtocolBufferException
    //   151	160	187	java/io/IOException
    //   151	160	183	finally
    //   166	174	215	com/google/protobuf/InvalidProtocolBufferException
    //   166	174	187	java/io/IOException
    //   166	174	183	finally
    //   188	215	183	finally
    //   216	231	183	finally
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    int j = this.value_;
    if (j != 0)
      i = 0 + CodedOutputStream.computeInt32Size(1, j); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public int getValue() {
    return this.value_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    int i = this.value_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(1, i); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Int32Value, Builder> implements Int32ValueOrBuilder {
    private Builder() {
      super(Int32Value.DEFAULT_INSTANCE);
    }
    
    public Builder clearValue() {
      copyOnWrite();
      this.instance.clearValue();
      return this;
    }
    
    public int getValue() {
      return this.instance.getValue();
    }
    
    public Builder setValue(int param1Int) {
      copyOnWrite();
      this.instance.setValue(param1Int);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\Int32Value.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */