package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class FloatValue extends GeneratedMessageLite<FloatValue, FloatValue.Builder> implements FloatValueOrBuilder {
  private static final FloatValue DEFAULT_INSTANCE = new FloatValue();
  
  private static volatile Parser<FloatValue> PARSER;
  
  public static final int VALUE_FIELD_NUMBER = 1;
  
  private float value_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearValue() {
    this.value_ = 0.0F;
  }
  
  public static FloatValue getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(FloatValue paramFloatValue) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramFloatValue);
  }
  
  public static FloatValue parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (FloatValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static FloatValue parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (FloatValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FloatValue parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<FloatValue>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static FloatValue parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<FloatValue>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static FloatValue parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<FloatValue>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static FloatValue parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<FloatValue>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static FloatValue parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<FloatValue>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static FloatValue parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<FloatValue>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FloatValue parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<FloatValue>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static FloatValue parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<FloatValue>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<FloatValue> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setValue(float paramFloat) {
    this.value_ = paramFloat;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/FloatValue$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 324, 2 -> 320, 3 -> 318, 4 -> 309, 5 -> 237, 6 -> 118, 7 -> 233, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/protobuf/FloatValue.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/protobuf/FloatValue
    //   80: monitorenter
    //   81: getstatic com/google/protobuf/FloatValue.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/protobuf/FloatValue.DEFAULT_INSTANCE : Lcom/google/protobuf/FloatValue;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/protobuf/FloatValue.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/protobuf/FloatValue
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/protobuf/FloatValue
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/protobuf/FloatValue.PARSER : Lcom/google/protobuf/Parser;
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
    //   146: bipush #13
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
    //   168: invokevirtual readFloat : ()F
    //   171: putfield value_ : F
    //   174: goto -> 128
    //   177: iconst_1
    //   178: istore #6
    //   180: goto -> 128
    //   183: astore_1
    //   184: goto -> 231
    //   187: astore_1
    //   188: new java/lang/RuntimeException
    //   191: astore_2
    //   192: new com/google/protobuf/InvalidProtocolBufferException
    //   195: astore_3
    //   196: aload_3
    //   197: aload_1
    //   198: invokevirtual getMessage : ()Ljava/lang/String;
    //   201: invokespecial <init> : (Ljava/lang/String;)V
    //   204: aload_2
    //   205: aload_3
    //   206: aload_0
    //   207: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   210: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   213: aload_2
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
    //   233: getstatic com/google/protobuf/FloatValue.DEFAULT_INSTANCE : Lcom/google/protobuf/FloatValue;
    //   236: areturn
    //   237: aload_2
    //   238: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   241: astore_1
    //   242: aload_3
    //   243: checkcast com/google/protobuf/FloatValue
    //   246: astore_2
    //   247: aload_0
    //   248: getfield value_ : F
    //   251: fconst_0
    //   252: fcmpl
    //   253: ifeq -> 262
    //   256: iconst_1
    //   257: istore #7
    //   259: goto -> 265
    //   262: iconst_0
    //   263: istore #7
    //   265: aload_0
    //   266: getfield value_ : F
    //   269: fstore #8
    //   271: aload_2
    //   272: getfield value_ : F
    //   275: fconst_0
    //   276: fcmpl
    //   277: ifeq -> 283
    //   280: iconst_1
    //   281: istore #5
    //   283: aload_0
    //   284: aload_1
    //   285: iload #7
    //   287: fload #8
    //   289: iload #5
    //   291: aload_2
    //   292: getfield value_ : F
    //   295: invokeinterface visitFloat : (ZFZF)F
    //   300: putfield value_ : F
    //   303: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   306: astore_1
    //   307: aload_0
    //   308: areturn
    //   309: new com/google/protobuf/FloatValue$Builder
    //   312: dup
    //   313: aconst_null
    //   314: invokespecial <init> : (Lcom/google/protobuf/FloatValue$1;)V
    //   317: areturn
    //   318: aconst_null
    //   319: areturn
    //   320: getstatic com/google/protobuf/FloatValue.DEFAULT_INSTANCE : Lcom/google/protobuf/FloatValue;
    //   323: areturn
    //   324: new com/google/protobuf/FloatValue
    //   327: dup
    //   328: invokespecial <init> : ()V
    //   331: areturn
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
    float f = this.value_;
    if (f != 0.0F)
      i = 0 + CodedOutputStream.computeFloatSize(1, f); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public float getValue() {
    return this.value_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    float f = this.value_;
    if (f != 0.0F)
      paramCodedOutputStream.writeFloat(1, f); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<FloatValue, Builder> implements FloatValueOrBuilder {
    private Builder() {
      super(FloatValue.DEFAULT_INSTANCE);
    }
    
    public Builder clearValue() {
      copyOnWrite();
      this.instance.clearValue();
      return this;
    }
    
    public float getValue() {
      return this.instance.getValue();
    }
    
    public Builder setValue(float param1Float) {
      copyOnWrite();
      this.instance.setValue(param1Float);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\FloatValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */