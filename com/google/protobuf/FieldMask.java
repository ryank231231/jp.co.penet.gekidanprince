package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class FieldMask extends GeneratedMessageLite<FieldMask, FieldMask.Builder> implements FieldMaskOrBuilder {
  private static final FieldMask DEFAULT_INSTANCE = new FieldMask();
  
  private static volatile Parser<FieldMask> PARSER;
  
  public static final int PATHS_FIELD_NUMBER = 1;
  
  private Internal.ProtobufList<String> paths_ = GeneratedMessageLite.emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllPaths(Iterable<String> paramIterable) {
    ensurePathsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.paths_);
  }
  
  private void addPaths(String paramString) {
    if (paramString != null) {
      ensurePathsIsMutable();
      this.paths_.add(paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addPathsBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      ensurePathsIsMutable();
      this.paths_.add(paramByteString.toStringUtf8());
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearPaths() {
    this.paths_ = GeneratedMessageLite.emptyProtobufList();
  }
  
  private void ensurePathsIsMutable() {
    if (!this.paths_.isModifiable())
      this.paths_ = GeneratedMessageLite.mutableCopy(this.paths_); 
  }
  
  public static FieldMask getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(FieldMask paramFieldMask) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramFieldMask);
  }
  
  public static FieldMask parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (FieldMask)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static FieldMask parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (FieldMask)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FieldMask parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<FieldMask>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static FieldMask parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<FieldMask>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static FieldMask parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<FieldMask>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static FieldMask parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<FieldMask>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static FieldMask parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<FieldMask>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static FieldMask parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<FieldMask>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FieldMask parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<FieldMask>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static FieldMask parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<FieldMask>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<FieldMask> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setPaths(int paramInt, String paramString) {
    if (paramString != null) {
      ensurePathsIsMutable();
      this.paths_.set(paramInt, paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/FieldMask$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 321, 2 -> 317, 3 -> 306, 4 -> 297, 5 -> 263, 6 -> 110, 7 -> 259, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/protobuf/FieldMask.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/protobuf/FieldMask
    //   72: monitorenter
    //   73: getstatic com/google/protobuf/FieldMask.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/protobuf/FieldMask.DEFAULT_INSTANCE : Lcom/google/protobuf/FieldMask;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/protobuf/FieldMask.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/protobuf/FieldMask
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/protobuf/FieldMask
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/protobuf/FieldMask.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 259
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 203
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 161
    //   146: aload_1
    //   147: iload #5
    //   149: invokevirtual skipField : (I)Z
    //   152: ifne -> 123
    //   155: iconst_1
    //   156: istore #4
    //   158: goto -> 123
    //   161: aload_1
    //   162: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   165: astore_2
    //   166: aload_0
    //   167: getfield paths_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   170: invokeinterface isModifiable : ()Z
    //   175: ifne -> 189
    //   178: aload_0
    //   179: aload_0
    //   180: getfield paths_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   183: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   186: putfield paths_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   189: aload_0
    //   190: getfield paths_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   193: aload_2
    //   194: invokeinterface add : (Ljava/lang/Object;)Z
    //   199: pop
    //   200: goto -> 123
    //   203: iconst_1
    //   204: istore #4
    //   206: goto -> 123
    //   209: astore_1
    //   210: goto -> 257
    //   213: astore_2
    //   214: new java/lang/RuntimeException
    //   217: astore_3
    //   218: new com/google/protobuf/InvalidProtocolBufferException
    //   221: astore_1
    //   222: aload_1
    //   223: aload_2
    //   224: invokevirtual getMessage : ()Ljava/lang/String;
    //   227: invokespecial <init> : (Ljava/lang/String;)V
    //   230: aload_3
    //   231: aload_1
    //   232: aload_0
    //   233: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   236: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   239: aload_3
    //   240: athrow
    //   241: astore_1
    //   242: new java/lang/RuntimeException
    //   245: astore_2
    //   246: aload_2
    //   247: aload_1
    //   248: aload_0
    //   249: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   252: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   255: aload_2
    //   256: athrow
    //   257: aload_1
    //   258: athrow
    //   259: getstatic com/google/protobuf/FieldMask.DEFAULT_INSTANCE : Lcom/google/protobuf/FieldMask;
    //   262: areturn
    //   263: aload_2
    //   264: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   267: astore_1
    //   268: aload_3
    //   269: checkcast com/google/protobuf/FieldMask
    //   272: astore_2
    //   273: aload_0
    //   274: aload_1
    //   275: aload_0
    //   276: getfield paths_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   279: aload_2
    //   280: getfield paths_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   283: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   288: putfield paths_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   291: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   294: astore_1
    //   295: aload_0
    //   296: areturn
    //   297: new com/google/protobuf/FieldMask$Builder
    //   300: dup
    //   301: aconst_null
    //   302: invokespecial <init> : (Lcom/google/protobuf/FieldMask$1;)V
    //   305: areturn
    //   306: aload_0
    //   307: getfield paths_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   310: invokeinterface makeImmutable : ()V
    //   315: aconst_null
    //   316: areturn
    //   317: getstatic com/google/protobuf/FieldMask.DEFAULT_INSTANCE : Lcom/google/protobuf/FieldMask;
    //   320: areturn
    //   321: new com/google/protobuf/FieldMask
    //   324: dup
    //   325: invokespecial <init> : ()V
    //   328: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	241	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	213	java/io/IOException
    //   128	134	209	finally
    //   146	155	241	com/google/protobuf/InvalidProtocolBufferException
    //   146	155	213	java/io/IOException
    //   146	155	209	finally
    //   161	189	241	com/google/protobuf/InvalidProtocolBufferException
    //   161	189	213	java/io/IOException
    //   161	189	209	finally
    //   189	200	241	com/google/protobuf/InvalidProtocolBufferException
    //   189	200	213	java/io/IOException
    //   189	200	209	finally
    //   214	241	209	finally
    //   242	257	209	finally
  }
  
  public String getPaths(int paramInt) {
    return this.paths_.get(paramInt);
  }
  
  public ByteString getPathsBytes(int paramInt) {
    return ByteString.copyFromUtf8(this.paths_.get(paramInt));
  }
  
  public int getPathsCount() {
    return this.paths_.size();
  }
  
  public List<String> getPathsList() {
    return this.paths_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    byte b = 0;
    i = 0;
    while (b < this.paths_.size()) {
      i += CodedOutputStream.computeStringSizeNoTag(this.paths_.get(b));
      b++;
    } 
    i = 0 + i + getPathsList().size() * 1;
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (byte b = 0; b < this.paths_.size(); b++)
      paramCodedOutputStream.writeString(1, this.paths_.get(b)); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<FieldMask, Builder> implements FieldMaskOrBuilder {
    private Builder() {
      super(FieldMask.DEFAULT_INSTANCE);
    }
    
    public Builder addAllPaths(Iterable<String> param1Iterable) {
      copyOnWrite();
      this.instance.addAllPaths(param1Iterable);
      return this;
    }
    
    public Builder addPaths(String param1String) {
      copyOnWrite();
      this.instance.addPaths(param1String);
      return this;
    }
    
    public Builder addPathsBytes(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.addPathsBytes(param1ByteString);
      return this;
    }
    
    public Builder clearPaths() {
      copyOnWrite();
      this.instance.clearPaths();
      return this;
    }
    
    public String getPaths(int param1Int) {
      return this.instance.getPaths(param1Int);
    }
    
    public ByteString getPathsBytes(int param1Int) {
      return this.instance.getPathsBytes(param1Int);
    }
    
    public int getPathsCount() {
      return this.instance.getPathsCount();
    }
    
    public List<String> getPathsList() {
      return Collections.unmodifiableList(this.instance.getPathsList());
    }
    
    public Builder setPaths(int param1Int, String param1String) {
      copyOnWrite();
      this.instance.setPaths(param1Int, param1String);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\FieldMask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */