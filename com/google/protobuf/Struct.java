package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

public final class Struct extends GeneratedMessageLite<Struct, Struct.Builder> implements StructOrBuilder {
  private static final Struct DEFAULT_INSTANCE = new Struct();
  
  public static final int FIELDS_FIELD_NUMBER = 1;
  
  private static volatile Parser<Struct> PARSER;
  
  private MapFieldLite<String, Value> fields_ = MapFieldLite.emptyMapField();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  public static Struct getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private Map<String, Value> getMutableFieldsMap() {
    return internalGetMutableFields();
  }
  
  private MapFieldLite<String, Value> internalGetFields() {
    return this.fields_;
  }
  
  private MapFieldLite<String, Value> internalGetMutableFields() {
    if (!this.fields_.isMutable())
      this.fields_ = this.fields_.mutableCopy(); 
    return this.fields_;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Struct paramStruct) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramStruct);
  }
  
  public static Struct parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Struct)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Struct parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Struct)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Struct parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Struct>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Struct parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Struct>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Struct parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<Struct>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Struct parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Struct>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Struct parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<Struct>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Struct parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Struct>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Struct parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Struct>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Struct parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Struct>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Struct> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  public boolean containsFields(String paramString) {
    if (paramString != null)
      return internalGetFields().containsKey(paramString); 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/Struct$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 313, 2 -> 309, 3 -> 300, 4 -> 291, 5 -> 257, 6 -> 110, 7 -> 253, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/protobuf/Struct.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/protobuf/Struct
    //   72: monitorenter
    //   73: getstatic com/google/protobuf/Struct.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/protobuf/Struct.DEFAULT_INSTANCE : Lcom/google/protobuf/Struct;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/protobuf/Struct.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/protobuf/Struct
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/protobuf/Struct
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/protobuf/Struct.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 253
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 197
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
    //   161: aload_0
    //   162: getfield fields_ : Lcom/google/protobuf/MapFieldLite;
    //   165: invokevirtual isMutable : ()Z
    //   168: ifne -> 182
    //   171: aload_0
    //   172: aload_0
    //   173: getfield fields_ : Lcom/google/protobuf/MapFieldLite;
    //   176: invokevirtual mutableCopy : ()Lcom/google/protobuf/MapFieldLite;
    //   179: putfield fields_ : Lcom/google/protobuf/MapFieldLite;
    //   182: getstatic com/google/protobuf/Struct$FieldsDefaultEntryHolder.defaultEntry : Lcom/google/protobuf/MapEntryLite;
    //   185: aload_0
    //   186: getfield fields_ : Lcom/google/protobuf/MapFieldLite;
    //   189: aload_1
    //   190: aload_2
    //   191: invokevirtual parseInto : (Lcom/google/protobuf/MapFieldLite;Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)V
    //   194: goto -> 123
    //   197: iconst_1
    //   198: istore #4
    //   200: goto -> 123
    //   203: astore_1
    //   204: goto -> 251
    //   207: astore_1
    //   208: new java/lang/RuntimeException
    //   211: astore_2
    //   212: new com/google/protobuf/InvalidProtocolBufferException
    //   215: astore_3
    //   216: aload_3
    //   217: aload_1
    //   218: invokevirtual getMessage : ()Ljava/lang/String;
    //   221: invokespecial <init> : (Ljava/lang/String;)V
    //   224: aload_2
    //   225: aload_3
    //   226: aload_0
    //   227: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   230: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   233: aload_2
    //   234: athrow
    //   235: astore_2
    //   236: new java/lang/RuntimeException
    //   239: astore_1
    //   240: aload_1
    //   241: aload_2
    //   242: aload_0
    //   243: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   246: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   249: aload_1
    //   250: athrow
    //   251: aload_1
    //   252: athrow
    //   253: getstatic com/google/protobuf/Struct.DEFAULT_INSTANCE : Lcom/google/protobuf/Struct;
    //   256: areturn
    //   257: aload_2
    //   258: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   261: astore_1
    //   262: aload_3
    //   263: checkcast com/google/protobuf/Struct
    //   266: astore_2
    //   267: aload_0
    //   268: aload_1
    //   269: aload_0
    //   270: getfield fields_ : Lcom/google/protobuf/MapFieldLite;
    //   273: aload_2
    //   274: invokespecial internalGetFields : ()Lcom/google/protobuf/MapFieldLite;
    //   277: invokeinterface visitMap : (Lcom/google/protobuf/MapFieldLite;Lcom/google/protobuf/MapFieldLite;)Lcom/google/protobuf/MapFieldLite;
    //   282: putfield fields_ : Lcom/google/protobuf/MapFieldLite;
    //   285: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   288: astore_1
    //   289: aload_0
    //   290: areturn
    //   291: new com/google/protobuf/Struct$Builder
    //   294: dup
    //   295: aconst_null
    //   296: invokespecial <init> : (Lcom/google/protobuf/Struct$1;)V
    //   299: areturn
    //   300: aload_0
    //   301: getfield fields_ : Lcom/google/protobuf/MapFieldLite;
    //   304: invokevirtual makeImmutable : ()V
    //   307: aconst_null
    //   308: areturn
    //   309: getstatic com/google/protobuf/Struct.DEFAULT_INSTANCE : Lcom/google/protobuf/Struct;
    //   312: areturn
    //   313: new com/google/protobuf/Struct
    //   316: dup
    //   317: invokespecial <init> : ()V
    //   320: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	235	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	207	java/io/IOException
    //   128	134	203	finally
    //   146	155	235	com/google/protobuf/InvalidProtocolBufferException
    //   146	155	207	java/io/IOException
    //   146	155	203	finally
    //   161	182	235	com/google/protobuf/InvalidProtocolBufferException
    //   161	182	207	java/io/IOException
    //   161	182	203	finally
    //   182	194	235	com/google/protobuf/InvalidProtocolBufferException
    //   182	194	207	java/io/IOException
    //   182	194	203	finally
    //   208	235	203	finally
    //   236	251	203	finally
  }
  
  @Deprecated
  public Map<String, Value> getFields() {
    return getFieldsMap();
  }
  
  public int getFieldsCount() {
    return internalGetFields().size();
  }
  
  public Map<String, Value> getFieldsMap() {
    return Collections.unmodifiableMap(internalGetFields());
  }
  
  public Value getFieldsOrDefault(String paramString, Value paramValue) {
    if (paramString != null) {
      MapFieldLite<String, Value> mapFieldLite = internalGetFields();
      if (mapFieldLite.containsKey(paramString))
        paramValue = mapFieldLite.get(paramString); 
      return paramValue;
    } 
    throw new NullPointerException();
  }
  
  public Value getFieldsOrThrow(String paramString) {
    if (paramString != null) {
      MapFieldLite<String, Value> mapFieldLite = internalGetFields();
      if (mapFieldLite.containsKey(paramString))
        return mapFieldLite.get(paramString); 
      throw new IllegalArgumentException();
    } 
    throw new NullPointerException();
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    for (Map.Entry<String, Value> entry : internalGetFields().entrySet())
      i += FieldsDefaultEntryHolder.defaultEntry.computeMessageSize(1, (String)entry.getKey(), (Value)entry.getValue()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (Map.Entry<String, Value> entry : internalGetFields().entrySet())
      FieldsDefaultEntryHolder.defaultEntry.serializeTo(paramCodedOutputStream, 1, (String)entry.getKey(), (Value)entry.getValue()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Struct, Builder> implements StructOrBuilder {
    private Builder() {
      super(Struct.DEFAULT_INSTANCE);
    }
    
    public Builder clearFields() {
      copyOnWrite();
      this.instance.getMutableFieldsMap().clear();
      return this;
    }
    
    public boolean containsFields(String param1String) {
      if (param1String != null)
        return this.instance.getFieldsMap().containsKey(param1String); 
      throw new NullPointerException();
    }
    
    @Deprecated
    public Map<String, Value> getFields() {
      return getFieldsMap();
    }
    
    public int getFieldsCount() {
      return this.instance.getFieldsMap().size();
    }
    
    public Map<String, Value> getFieldsMap() {
      return Collections.unmodifiableMap(this.instance.getFieldsMap());
    }
    
    public Value getFieldsOrDefault(String param1String, Value param1Value) {
      if (param1String != null) {
        Map<String, Value> map = this.instance.getFieldsMap();
        if (map.containsKey(param1String))
          param1Value = map.get(param1String); 
        return param1Value;
      } 
      throw new NullPointerException();
    }
    
    public Value getFieldsOrThrow(String param1String) {
      if (param1String != null) {
        Map<String, Value> map = this.instance.getFieldsMap();
        if (map.containsKey(param1String))
          return map.get(param1String); 
        throw new IllegalArgumentException();
      } 
      throw new NullPointerException();
    }
    
    public Builder putAllFields(Map<String, Value> param1Map) {
      copyOnWrite();
      this.instance.getMutableFieldsMap().putAll(param1Map);
      return this;
    }
    
    public Builder putFields(String param1String, Value param1Value) {
      if (param1String != null) {
        if (param1Value != null) {
          copyOnWrite();
          this.instance.getMutableFieldsMap().put(param1String, param1Value);
          return this;
        } 
        throw new NullPointerException();
      } 
      throw new NullPointerException();
    }
    
    public Builder removeFields(String param1String) {
      if (param1String != null) {
        copyOnWrite();
        this.instance.getMutableFieldsMap().remove(param1String);
        return this;
      } 
      throw new NullPointerException();
    }
  }
  
  private static final class FieldsDefaultEntryHolder {
    static final MapEntryLite<String, Value> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.getDefaultInstance());
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\Struct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */