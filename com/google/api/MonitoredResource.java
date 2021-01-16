package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

public final class MonitoredResource extends GeneratedMessageLite<MonitoredResource, MonitoredResource.Builder> implements MonitoredResourceOrBuilder {
  private static final MonitoredResource DEFAULT_INSTANCE = new MonitoredResource();
  
  public static final int LABELS_FIELD_NUMBER = 2;
  
  private static volatile Parser<MonitoredResource> PARSER;
  
  public static final int TYPE_FIELD_NUMBER = 1;
  
  private int bitField0_;
  
  private MapFieldLite<String, String> labels_ = MapFieldLite.emptyMapField();
  
  private String type_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearType() {
    this.type_ = getDefaultInstance().getType();
  }
  
  public static MonitoredResource getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private Map<String, String> getMutableLabelsMap() {
    return (Map<String, String>)internalGetMutableLabels();
  }
  
  private MapFieldLite<String, String> internalGetLabels() {
    return this.labels_;
  }
  
  private MapFieldLite<String, String> internalGetMutableLabels() {
    if (!this.labels_.isMutable())
      this.labels_ = this.labels_.mutableCopy(); 
    return this.labels_;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(MonitoredResource paramMonitoredResource) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramMonitoredResource);
  }
  
  public static MonitoredResource parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (MonitoredResource)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static MonitoredResource parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MonitoredResource)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MonitoredResource parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (MonitoredResource)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static MonitoredResource parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MonitoredResource)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static MonitoredResource parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (MonitoredResource)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static MonitoredResource parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MonitoredResource)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static MonitoredResource parseFrom(InputStream paramInputStream) throws IOException {
    return (MonitoredResource)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static MonitoredResource parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MonitoredResource)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MonitoredResource parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (MonitoredResource)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static MonitoredResource parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MonitoredResource)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<MonitoredResource> parser() {
    return DEFAULT_INSTANCE.getParserForType();
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
  
  public boolean containsLabels(String paramString) {
    if (paramString != null)
      return internalGetLabels().containsKey(paramString); 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/MonitoredResource$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 383, 2 -> 379, 3 -> 370, 4 -> 361, 5 -> 275, 6 -> 110, 7 -> 271, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/api/MonitoredResource.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/api/MonitoredResource
    //   72: monitorenter
    //   73: getstatic com/google/api/MonitoredResource.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/api/MonitoredResource.DEFAULT_INSTANCE : Lcom/google/api/MonitoredResource;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/api/MonitoredResource.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/api/MonitoredResource
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/api/MonitoredResource
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/api/MonitoredResource.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 271
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 215
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 204
    //   146: iload #5
    //   148: bipush #18
    //   150: if_icmpeq -> 168
    //   153: aload_1
    //   154: iload #5
    //   156: invokevirtual skipField : (I)Z
    //   159: ifne -> 123
    //   162: iconst_1
    //   163: istore #4
    //   165: goto -> 123
    //   168: aload_0
    //   169: getfield labels_ : Lcom/google/protobuf/MapFieldLite;
    //   172: invokevirtual isMutable : ()Z
    //   175: ifne -> 189
    //   178: aload_0
    //   179: aload_0
    //   180: getfield labels_ : Lcom/google/protobuf/MapFieldLite;
    //   183: invokevirtual mutableCopy : ()Lcom/google/protobuf/MapFieldLite;
    //   186: putfield labels_ : Lcom/google/protobuf/MapFieldLite;
    //   189: getstatic com/google/api/MonitoredResource$LabelsDefaultEntryHolder.defaultEntry : Lcom/google/protobuf/MapEntryLite;
    //   192: aload_0
    //   193: getfield labels_ : Lcom/google/protobuf/MapFieldLite;
    //   196: aload_1
    //   197: aload_2
    //   198: invokevirtual parseInto : (Lcom/google/protobuf/MapFieldLite;Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)V
    //   201: goto -> 123
    //   204: aload_0
    //   205: aload_1
    //   206: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   209: putfield type_ : Ljava/lang/String;
    //   212: goto -> 123
    //   215: iconst_1
    //   216: istore #4
    //   218: goto -> 123
    //   221: astore_1
    //   222: goto -> 269
    //   225: astore_1
    //   226: new java/lang/RuntimeException
    //   229: astore_3
    //   230: new com/google/protobuf/InvalidProtocolBufferException
    //   233: astore_2
    //   234: aload_2
    //   235: aload_1
    //   236: invokevirtual getMessage : ()Ljava/lang/String;
    //   239: invokespecial <init> : (Ljava/lang/String;)V
    //   242: aload_3
    //   243: aload_2
    //   244: aload_0
    //   245: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   248: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   251: aload_3
    //   252: athrow
    //   253: astore_2
    //   254: new java/lang/RuntimeException
    //   257: astore_1
    //   258: aload_1
    //   259: aload_2
    //   260: aload_0
    //   261: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   264: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   267: aload_1
    //   268: athrow
    //   269: aload_1
    //   270: athrow
    //   271: getstatic com/google/api/MonitoredResource.DEFAULT_INSTANCE : Lcom/google/api/MonitoredResource;
    //   274: areturn
    //   275: aload_2
    //   276: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   279: astore_1
    //   280: aload_3
    //   281: checkcast com/google/api/MonitoredResource
    //   284: astore_2
    //   285: aload_0
    //   286: aload_1
    //   287: aload_0
    //   288: getfield type_ : Ljava/lang/String;
    //   291: invokevirtual isEmpty : ()Z
    //   294: iconst_1
    //   295: ixor
    //   296: aload_0
    //   297: getfield type_ : Ljava/lang/String;
    //   300: iconst_1
    //   301: aload_2
    //   302: getfield type_ : Ljava/lang/String;
    //   305: invokevirtual isEmpty : ()Z
    //   308: ixor
    //   309: aload_2
    //   310: getfield type_ : Ljava/lang/String;
    //   313: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   318: putfield type_ : Ljava/lang/String;
    //   321: aload_0
    //   322: aload_1
    //   323: aload_0
    //   324: getfield labels_ : Lcom/google/protobuf/MapFieldLite;
    //   327: aload_2
    //   328: invokespecial internalGetLabels : ()Lcom/google/protobuf/MapFieldLite;
    //   331: invokeinterface visitMap : (Lcom/google/protobuf/MapFieldLite;Lcom/google/protobuf/MapFieldLite;)Lcom/google/protobuf/MapFieldLite;
    //   336: putfield labels_ : Lcom/google/protobuf/MapFieldLite;
    //   339: aload_1
    //   340: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   343: if_acmpne -> 359
    //   346: aload_0
    //   347: aload_0
    //   348: getfield bitField0_ : I
    //   351: aload_2
    //   352: getfield bitField0_ : I
    //   355: ior
    //   356: putfield bitField0_ : I
    //   359: aload_0
    //   360: areturn
    //   361: new com/google/api/MonitoredResource$Builder
    //   364: dup
    //   365: aconst_null
    //   366: invokespecial <init> : (Lcom/google/api/MonitoredResource$1;)V
    //   369: areturn
    //   370: aload_0
    //   371: getfield labels_ : Lcom/google/protobuf/MapFieldLite;
    //   374: invokevirtual makeImmutable : ()V
    //   377: aconst_null
    //   378: areturn
    //   379: getstatic com/google/api/MonitoredResource.DEFAULT_INSTANCE : Lcom/google/api/MonitoredResource;
    //   382: areturn
    //   383: new com/google/api/MonitoredResource
    //   386: dup
    //   387: invokespecial <init> : ()V
    //   390: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	253	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	225	java/io/IOException
    //   128	134	221	finally
    //   153	162	253	com/google/protobuf/InvalidProtocolBufferException
    //   153	162	225	java/io/IOException
    //   153	162	221	finally
    //   168	189	253	com/google/protobuf/InvalidProtocolBufferException
    //   168	189	225	java/io/IOException
    //   168	189	221	finally
    //   189	201	253	com/google/protobuf/InvalidProtocolBufferException
    //   189	201	225	java/io/IOException
    //   189	201	221	finally
    //   204	212	253	com/google/protobuf/InvalidProtocolBufferException
    //   204	212	225	java/io/IOException
    //   204	212	221	finally
    //   226	253	221	finally
    //   254	269	221	finally
  }
  
  @Deprecated
  public Map<String, String> getLabels() {
    return getLabelsMap();
  }
  
  public int getLabelsCount() {
    return internalGetLabels().size();
  }
  
  public Map<String, String> getLabelsMap() {
    return Collections.unmodifiableMap((Map<? extends String, ? extends String>)internalGetLabels());
  }
  
  public String getLabelsOrDefault(String paramString1, String paramString2) {
    if (paramString1 != null) {
      MapFieldLite<String, String> mapFieldLite = internalGetLabels();
      if (mapFieldLite.containsKey(paramString1))
        paramString2 = mapFieldLite.get(paramString1); 
      return paramString2;
    } 
    throw new NullPointerException();
  }
  
  public String getLabelsOrThrow(String paramString) {
    if (paramString != null) {
      MapFieldLite<String, String> mapFieldLite = internalGetLabels();
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
    if (!this.type_.isEmpty())
      i = 0 + CodedOutputStream.computeStringSize(1, getType()); 
    for (Map.Entry entry : internalGetLabels().entrySet())
      i += LabelsDefaultEntryHolder.defaultEntry.computeMessageSize(2, entry.getKey(), entry.getValue()); 
    this.memoizedSerializedSize = i;
    return i;
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
    for (Map.Entry entry : internalGetLabels().entrySet())
      LabelsDefaultEntryHolder.defaultEntry.serializeTo(paramCodedOutputStream, 2, entry.getKey(), entry.getValue()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<MonitoredResource, Builder> implements MonitoredResourceOrBuilder {
    private Builder() {
      super(MonitoredResource.DEFAULT_INSTANCE);
    }
    
    public Builder clearLabels() {
      copyOnWrite();
      ((MonitoredResource)this.instance).getMutableLabelsMap().clear();
      return this;
    }
    
    public Builder clearType() {
      copyOnWrite();
      ((MonitoredResource)this.instance).clearType();
      return this;
    }
    
    public boolean containsLabels(String param1String) {
      if (param1String != null)
        return ((MonitoredResource)this.instance).getLabelsMap().containsKey(param1String); 
      throw new NullPointerException();
    }
    
    @Deprecated
    public Map<String, String> getLabels() {
      return getLabelsMap();
    }
    
    public int getLabelsCount() {
      return ((MonitoredResource)this.instance).getLabelsMap().size();
    }
    
    public Map<String, String> getLabelsMap() {
      return Collections.unmodifiableMap(((MonitoredResource)this.instance).getLabelsMap());
    }
    
    public String getLabelsOrDefault(String param1String1, String param1String2) {
      if (param1String1 != null) {
        Map<String, String> map = ((MonitoredResource)this.instance).getLabelsMap();
        if (map.containsKey(param1String1))
          param1String2 = map.get(param1String1); 
        return param1String2;
      } 
      throw new NullPointerException();
    }
    
    public String getLabelsOrThrow(String param1String) {
      if (param1String != null) {
        Map<String, String> map = ((MonitoredResource)this.instance).getLabelsMap();
        if (map.containsKey(param1String))
          return map.get(param1String); 
        throw new IllegalArgumentException();
      } 
      throw new NullPointerException();
    }
    
    public String getType() {
      return ((MonitoredResource)this.instance).getType();
    }
    
    public ByteString getTypeBytes() {
      return ((MonitoredResource)this.instance).getTypeBytes();
    }
    
    public Builder putAllLabels(Map<String, String> param1Map) {
      copyOnWrite();
      ((MonitoredResource)this.instance).getMutableLabelsMap().putAll(param1Map);
      return this;
    }
    
    public Builder putLabels(String param1String1, String param1String2) {
      if (param1String1 != null) {
        if (param1String2 != null) {
          copyOnWrite();
          ((MonitoredResource)this.instance).getMutableLabelsMap().put(param1String1, param1String2);
          return this;
        } 
        throw new NullPointerException();
      } 
      throw new NullPointerException();
    }
    
    public Builder removeLabels(String param1String) {
      if (param1String != null) {
        copyOnWrite();
        ((MonitoredResource)this.instance).getMutableLabelsMap().remove(param1String);
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setType(String param1String) {
      copyOnWrite();
      ((MonitoredResource)this.instance).setType(param1String);
      return this;
    }
    
    public Builder setTypeBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((MonitoredResource)this.instance).setTypeBytes(param1ByteString);
      return this;
    }
  }
  
  private static final class LabelsDefaultEntryHolder {
    static final MapEntryLite<String, String> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\MonitoredResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */