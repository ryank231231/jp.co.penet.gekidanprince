package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class Empty extends GeneratedMessageLite<Empty, Empty.Builder> implements EmptyOrBuilder {
  private static final Empty DEFAULT_INSTANCE = new Empty();
  
  private static volatile Parser<Empty> PARSER;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  public static Empty getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Empty paramEmpty) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramEmpty);
  }
  
  public static Empty parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Empty)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Empty parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Empty)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Empty parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Empty>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Empty parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Empty>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Empty parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<Empty>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Empty parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Empty>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Empty parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<Empty>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Empty parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Empty>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Empty parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Empty>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Empty parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Empty>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Empty> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/Empty$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 249, 2 -> 245, 3 -> 243, 4 -> 234, 5 -> 218, 6 -> 110, 7 -> 214, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/protobuf/Empty.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/protobuf/Empty
    //   72: monitorenter
    //   73: getstatic com/google/protobuf/Empty.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/protobuf/Empty.DEFAULT_INSTANCE : Lcom/google/protobuf/Empty;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/protobuf/Empty.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/protobuf/Empty
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/protobuf/Empty
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/protobuf/Empty.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 214
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 158
    //   139: aload_1
    //   140: iload #5
    //   142: invokevirtual skipField : (I)Z
    //   145: istore #6
    //   147: iload #6
    //   149: ifne -> 123
    //   152: iconst_1
    //   153: istore #4
    //   155: goto -> 123
    //   158: iconst_1
    //   159: istore #4
    //   161: goto -> 123
    //   164: astore_1
    //   165: goto -> 212
    //   168: astore_3
    //   169: new java/lang/RuntimeException
    //   172: astore_1
    //   173: new com/google/protobuf/InvalidProtocolBufferException
    //   176: astore_2
    //   177: aload_2
    //   178: aload_3
    //   179: invokevirtual getMessage : ()Ljava/lang/String;
    //   182: invokespecial <init> : (Ljava/lang/String;)V
    //   185: aload_1
    //   186: aload_2
    //   187: aload_0
    //   188: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   191: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   194: aload_1
    //   195: athrow
    //   196: astore_2
    //   197: new java/lang/RuntimeException
    //   200: astore_1
    //   201: aload_1
    //   202: aload_2
    //   203: aload_0
    //   204: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   207: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   210: aload_1
    //   211: athrow
    //   212: aload_1
    //   213: athrow
    //   214: getstatic com/google/protobuf/Empty.DEFAULT_INSTANCE : Lcom/google/protobuf/Empty;
    //   217: areturn
    //   218: aload_2
    //   219: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   222: astore_1
    //   223: aload_3
    //   224: checkcast com/google/protobuf/Empty
    //   227: astore_1
    //   228: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   231: astore_1
    //   232: aload_0
    //   233: areturn
    //   234: new com/google/protobuf/Empty$Builder
    //   237: dup
    //   238: aconst_null
    //   239: invokespecial <init> : (Lcom/google/protobuf/Empty$1;)V
    //   242: areturn
    //   243: aconst_null
    //   244: areturn
    //   245: getstatic com/google/protobuf/Empty.DEFAULT_INSTANCE : Lcom/google/protobuf/Empty;
    //   248: areturn
    //   249: new com/google/protobuf/Empty
    //   252: dup
    //   253: invokespecial <init> : ()V
    //   256: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	196	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	168	java/io/IOException
    //   128	134	164	finally
    //   139	147	196	com/google/protobuf/InvalidProtocolBufferException
    //   139	147	168	java/io/IOException
    //   139	147	164	finally
    //   169	196	164	finally
    //   197	212	164	finally
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    this.memoizedSerializedSize = 0;
    return 0;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {}
  
  public static final class Builder extends GeneratedMessageLite.Builder<Empty, Builder> implements EmptyOrBuilder {
    private Builder() {
      super(Empty.DEFAULT_INSTANCE);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\Empty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */