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

public final class MetricRule extends GeneratedMessageLite<MetricRule, MetricRule.Builder> implements MetricRuleOrBuilder {
  private static final MetricRule DEFAULT_INSTANCE = new MetricRule();
  
  public static final int METRIC_COSTS_FIELD_NUMBER = 2;
  
  private static volatile Parser<MetricRule> PARSER;
  
  public static final int SELECTOR_FIELD_NUMBER = 1;
  
  private int bitField0_;
  
  private MapFieldLite<String, Long> metricCosts_ = MapFieldLite.emptyMapField();
  
  private String selector_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearSelector() {
    this.selector_ = getDefaultInstance().getSelector();
  }
  
  public static MetricRule getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private Map<String, Long> getMutableMetricCostsMap() {
    return (Map<String, Long>)internalGetMutableMetricCosts();
  }
  
  private MapFieldLite<String, Long> internalGetMetricCosts() {
    return this.metricCosts_;
  }
  
  private MapFieldLite<String, Long> internalGetMutableMetricCosts() {
    if (!this.metricCosts_.isMutable())
      this.metricCosts_ = this.metricCosts_.mutableCopy(); 
    return this.metricCosts_;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(MetricRule paramMetricRule) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramMetricRule);
  }
  
  public static MetricRule parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (MetricRule)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static MetricRule parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MetricRule)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MetricRule parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (MetricRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static MetricRule parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MetricRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static MetricRule parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (MetricRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static MetricRule parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MetricRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static MetricRule parseFrom(InputStream paramInputStream) throws IOException {
    return (MetricRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static MetricRule parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MetricRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MetricRule parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (MetricRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static MetricRule parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MetricRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<MetricRule> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setSelector(String paramString) {
    if (paramString != null) {
      this.selector_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setSelectorBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.selector_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  public boolean containsMetricCosts(String paramString) {
    if (paramString != null)
      return internalGetMetricCosts().containsKey(paramString); 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/MetricRule$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 383, 2 -> 379, 3 -> 370, 4 -> 361, 5 -> 275, 6 -> 110, 7 -> 271, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/api/MetricRule.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/api/MetricRule
    //   72: monitorenter
    //   73: getstatic com/google/api/MetricRule.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/api/MetricRule.DEFAULT_INSTANCE : Lcom/google/api/MetricRule;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/api/MetricRule.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/api/MetricRule
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/api/MetricRule
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/api/MetricRule.PARSER : Lcom/google/protobuf/Parser;
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
    //   169: getfield metricCosts_ : Lcom/google/protobuf/MapFieldLite;
    //   172: invokevirtual isMutable : ()Z
    //   175: ifne -> 189
    //   178: aload_0
    //   179: aload_0
    //   180: getfield metricCosts_ : Lcom/google/protobuf/MapFieldLite;
    //   183: invokevirtual mutableCopy : ()Lcom/google/protobuf/MapFieldLite;
    //   186: putfield metricCosts_ : Lcom/google/protobuf/MapFieldLite;
    //   189: getstatic com/google/api/MetricRule$MetricCostsDefaultEntryHolder.defaultEntry : Lcom/google/protobuf/MapEntryLite;
    //   192: aload_0
    //   193: getfield metricCosts_ : Lcom/google/protobuf/MapFieldLite;
    //   196: aload_1
    //   197: aload_2
    //   198: invokevirtual parseInto : (Lcom/google/protobuf/MapFieldLite;Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)V
    //   201: goto -> 123
    //   204: aload_0
    //   205: aload_1
    //   206: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   209: putfield selector_ : Ljava/lang/String;
    //   212: goto -> 123
    //   215: iconst_1
    //   216: istore #4
    //   218: goto -> 123
    //   221: astore_1
    //   222: goto -> 269
    //   225: astore_3
    //   226: new java/lang/RuntimeException
    //   229: astore_2
    //   230: new com/google/protobuf/InvalidProtocolBufferException
    //   233: astore_1
    //   234: aload_1
    //   235: aload_3
    //   236: invokevirtual getMessage : ()Ljava/lang/String;
    //   239: invokespecial <init> : (Ljava/lang/String;)V
    //   242: aload_2
    //   243: aload_1
    //   244: aload_0
    //   245: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   248: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   251: aload_2
    //   252: athrow
    //   253: astore_1
    //   254: new java/lang/RuntimeException
    //   257: astore_2
    //   258: aload_2
    //   259: aload_1
    //   260: aload_0
    //   261: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   264: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   267: aload_2
    //   268: athrow
    //   269: aload_1
    //   270: athrow
    //   271: getstatic com/google/api/MetricRule.DEFAULT_INSTANCE : Lcom/google/api/MetricRule;
    //   274: areturn
    //   275: aload_2
    //   276: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   279: astore_1
    //   280: aload_3
    //   281: checkcast com/google/api/MetricRule
    //   284: astore_2
    //   285: aload_0
    //   286: aload_1
    //   287: aload_0
    //   288: getfield selector_ : Ljava/lang/String;
    //   291: invokevirtual isEmpty : ()Z
    //   294: iconst_1
    //   295: ixor
    //   296: aload_0
    //   297: getfield selector_ : Ljava/lang/String;
    //   300: iconst_1
    //   301: aload_2
    //   302: getfield selector_ : Ljava/lang/String;
    //   305: invokevirtual isEmpty : ()Z
    //   308: ixor
    //   309: aload_2
    //   310: getfield selector_ : Ljava/lang/String;
    //   313: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   318: putfield selector_ : Ljava/lang/String;
    //   321: aload_0
    //   322: aload_1
    //   323: aload_0
    //   324: getfield metricCosts_ : Lcom/google/protobuf/MapFieldLite;
    //   327: aload_2
    //   328: invokespecial internalGetMetricCosts : ()Lcom/google/protobuf/MapFieldLite;
    //   331: invokeinterface visitMap : (Lcom/google/protobuf/MapFieldLite;Lcom/google/protobuf/MapFieldLite;)Lcom/google/protobuf/MapFieldLite;
    //   336: putfield metricCosts_ : Lcom/google/protobuf/MapFieldLite;
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
    //   361: new com/google/api/MetricRule$Builder
    //   364: dup
    //   365: aconst_null
    //   366: invokespecial <init> : (Lcom/google/api/MetricRule$1;)V
    //   369: areturn
    //   370: aload_0
    //   371: getfield metricCosts_ : Lcom/google/protobuf/MapFieldLite;
    //   374: invokevirtual makeImmutable : ()V
    //   377: aconst_null
    //   378: areturn
    //   379: getstatic com/google/api/MetricRule.DEFAULT_INSTANCE : Lcom/google/api/MetricRule;
    //   382: areturn
    //   383: new com/google/api/MetricRule
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
  public Map<String, Long> getMetricCosts() {
    return getMetricCostsMap();
  }
  
  public int getMetricCostsCount() {
    return internalGetMetricCosts().size();
  }
  
  public Map<String, Long> getMetricCostsMap() {
    return Collections.unmodifiableMap((Map<? extends String, ? extends Long>)internalGetMetricCosts());
  }
  
  public long getMetricCostsOrDefault(String paramString, long paramLong) {
    if (paramString != null) {
      MapFieldLite<String, Long> mapFieldLite = internalGetMetricCosts();
      if (mapFieldLite.containsKey(paramString))
        paramLong = ((Long)mapFieldLite.get(paramString)).longValue(); 
      return paramLong;
    } 
    throw new NullPointerException();
  }
  
  public long getMetricCostsOrThrow(String paramString) {
    if (paramString != null) {
      MapFieldLite<String, Long> mapFieldLite = internalGetMetricCosts();
      if (mapFieldLite.containsKey(paramString))
        return ((Long)mapFieldLite.get(paramString)).longValue(); 
      throw new IllegalArgumentException();
    } 
    throw new NullPointerException();
  }
  
  public String getSelector() {
    return this.selector_;
  }
  
  public ByteString getSelectorBytes() {
    return ByteString.copyFromUtf8(this.selector_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!this.selector_.isEmpty())
      i = 0 + CodedOutputStream.computeStringSize(1, getSelector()); 
    for (Map.Entry entry : internalGetMetricCosts().entrySet())
      i += MetricCostsDefaultEntryHolder.defaultEntry.computeMessageSize(2, entry.getKey(), entry.getValue()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.selector_.isEmpty())
      paramCodedOutputStream.writeString(1, getSelector()); 
    for (Map.Entry entry : internalGetMetricCosts().entrySet())
      MetricCostsDefaultEntryHolder.defaultEntry.serializeTo(paramCodedOutputStream, 2, entry.getKey(), entry.getValue()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<MetricRule, Builder> implements MetricRuleOrBuilder {
    private Builder() {
      super(MetricRule.DEFAULT_INSTANCE);
    }
    
    public Builder clearMetricCosts() {
      copyOnWrite();
      ((MetricRule)this.instance).getMutableMetricCostsMap().clear();
      return this;
    }
    
    public Builder clearSelector() {
      copyOnWrite();
      ((MetricRule)this.instance).clearSelector();
      return this;
    }
    
    public boolean containsMetricCosts(String param1String) {
      if (param1String != null)
        return ((MetricRule)this.instance).getMetricCostsMap().containsKey(param1String); 
      throw new NullPointerException();
    }
    
    @Deprecated
    public Map<String, Long> getMetricCosts() {
      return getMetricCostsMap();
    }
    
    public int getMetricCostsCount() {
      return ((MetricRule)this.instance).getMetricCostsMap().size();
    }
    
    public Map<String, Long> getMetricCostsMap() {
      return Collections.unmodifiableMap(((MetricRule)this.instance).getMetricCostsMap());
    }
    
    public long getMetricCostsOrDefault(String param1String, long param1Long) {
      if (param1String != null) {
        Map<String, Long> map = ((MetricRule)this.instance).getMetricCostsMap();
        if (map.containsKey(param1String))
          param1Long = ((Long)map.get(param1String)).longValue(); 
        return param1Long;
      } 
      throw new NullPointerException();
    }
    
    public long getMetricCostsOrThrow(String param1String) {
      if (param1String != null) {
        Map<String, Long> map = ((MetricRule)this.instance).getMetricCostsMap();
        if (map.containsKey(param1String))
          return ((Long)map.get(param1String)).longValue(); 
        throw new IllegalArgumentException();
      } 
      throw new NullPointerException();
    }
    
    public String getSelector() {
      return ((MetricRule)this.instance).getSelector();
    }
    
    public ByteString getSelectorBytes() {
      return ((MetricRule)this.instance).getSelectorBytes();
    }
    
    public Builder putAllMetricCosts(Map<String, Long> param1Map) {
      copyOnWrite();
      ((MetricRule)this.instance).getMutableMetricCostsMap().putAll(param1Map);
      return this;
    }
    
    public Builder putMetricCosts(String param1String, long param1Long) {
      if (param1String != null) {
        copyOnWrite();
        ((MetricRule)this.instance).getMutableMetricCostsMap().put(param1String, Long.valueOf(param1Long));
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder removeMetricCosts(String param1String) {
      if (param1String != null) {
        copyOnWrite();
        ((MetricRule)this.instance).getMutableMetricCostsMap().remove(param1String);
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setSelector(String param1String) {
      copyOnWrite();
      ((MetricRule)this.instance).setSelector(param1String);
      return this;
    }
    
    public Builder setSelectorBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((MetricRule)this.instance).setSelectorBytes(param1ByteString);
      return this;
    }
  }
  
  private static final class MetricCostsDefaultEntryHolder {
    static final MapEntryLite<String, Long> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.INT64, Long.valueOf(0L));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\MetricRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */