package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class ListValue extends GeneratedMessageLite<ListValue, ListValue.Builder> implements ListValueOrBuilder {
  private static final ListValue DEFAULT_INSTANCE = new ListValue();
  
  private static volatile Parser<ListValue> PARSER;
  
  public static final int VALUES_FIELD_NUMBER = 1;
  
  private Internal.ProtobufList<Value> values_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllValues(Iterable<? extends Value> paramIterable) {
    ensureValuesIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.values_);
  }
  
  private void addValues(int paramInt, Value.Builder paramBuilder) {
    ensureValuesIsMutable();
    this.values_.add(paramInt, paramBuilder.build());
  }
  
  private void addValues(int paramInt, Value paramValue) {
    if (paramValue != null) {
      ensureValuesIsMutable();
      this.values_.add(paramInt, paramValue);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addValues(Value.Builder paramBuilder) {
    ensureValuesIsMutable();
    this.values_.add(paramBuilder.build());
  }
  
  private void addValues(Value paramValue) {
    if (paramValue != null) {
      ensureValuesIsMutable();
      this.values_.add(paramValue);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearValues() {
    this.values_ = emptyProtobufList();
  }
  
  private void ensureValuesIsMutable() {
    if (!this.values_.isModifiable())
      this.values_ = GeneratedMessageLite.mutableCopy(this.values_); 
  }
  
  public static ListValue getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ListValue paramListValue) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramListValue);
  }
  
  public static ListValue parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ListValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ListValue parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListValue parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<ListValue>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static ListValue parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<ListValue>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static ListValue parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<ListValue>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static ListValue parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<ListValue>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ListValue parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<ListValue>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ListValue parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<ListValue>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListValue parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<ListValue>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static ListValue parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<ListValue>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ListValue> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeValues(int paramInt) {
    ensureValuesIsMutable();
    this.values_.remove(paramInt);
  }
  
  private void setValues(int paramInt, Value.Builder paramBuilder) {
    ensureValuesIsMutable();
    this.values_.set(paramInt, paramBuilder.build());
  }
  
  private void setValues(int paramInt, Value paramValue) {
    if (paramValue != null) {
      ensureValuesIsMutable();
      this.values_.set(paramInt, paramValue);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/ListValue$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 326, 2 -> 322, 3 -> 311, 4 -> 302, 5 -> 268, 6 -> 110, 7 -> 264, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/protobuf/ListValue.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/protobuf/ListValue
    //   72: monitorenter
    //   73: getstatic com/google/protobuf/ListValue.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/protobuf/ListValue.DEFAULT_INSTANCE : Lcom/google/protobuf/ListValue;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/protobuf/ListValue.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/protobuf/ListValue
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/protobuf/ListValue
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/protobuf/ListValue.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 264
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 208
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
    //   162: getfield values_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   165: invokeinterface isModifiable : ()Z
    //   170: ifne -> 184
    //   173: aload_0
    //   174: aload_0
    //   175: getfield values_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   178: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   181: putfield values_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   184: aload_0
    //   185: getfield values_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   188: aload_1
    //   189: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   192: aload_2
    //   193: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   196: checkcast com/google/protobuf/Value
    //   199: invokeinterface add : (Ljava/lang/Object;)Z
    //   204: pop
    //   205: goto -> 123
    //   208: iconst_1
    //   209: istore #4
    //   211: goto -> 123
    //   214: astore_1
    //   215: goto -> 262
    //   218: astore_3
    //   219: new java/lang/RuntimeException
    //   222: astore_1
    //   223: new com/google/protobuf/InvalidProtocolBufferException
    //   226: astore_2
    //   227: aload_2
    //   228: aload_3
    //   229: invokevirtual getMessage : ()Ljava/lang/String;
    //   232: invokespecial <init> : (Ljava/lang/String;)V
    //   235: aload_1
    //   236: aload_2
    //   237: aload_0
    //   238: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   241: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   244: aload_1
    //   245: athrow
    //   246: astore_2
    //   247: new java/lang/RuntimeException
    //   250: astore_1
    //   251: aload_1
    //   252: aload_2
    //   253: aload_0
    //   254: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   257: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   260: aload_1
    //   261: athrow
    //   262: aload_1
    //   263: athrow
    //   264: getstatic com/google/protobuf/ListValue.DEFAULT_INSTANCE : Lcom/google/protobuf/ListValue;
    //   267: areturn
    //   268: aload_2
    //   269: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   272: astore_1
    //   273: aload_3
    //   274: checkcast com/google/protobuf/ListValue
    //   277: astore_2
    //   278: aload_0
    //   279: aload_1
    //   280: aload_0
    //   281: getfield values_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   284: aload_2
    //   285: getfield values_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   288: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   293: putfield values_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   296: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   299: astore_1
    //   300: aload_0
    //   301: areturn
    //   302: new com/google/protobuf/ListValue$Builder
    //   305: dup
    //   306: aconst_null
    //   307: invokespecial <init> : (Lcom/google/protobuf/ListValue$1;)V
    //   310: areturn
    //   311: aload_0
    //   312: getfield values_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   315: invokeinterface makeImmutable : ()V
    //   320: aconst_null
    //   321: areturn
    //   322: getstatic com/google/protobuf/ListValue.DEFAULT_INSTANCE : Lcom/google/protobuf/ListValue;
    //   325: areturn
    //   326: new com/google/protobuf/ListValue
    //   329: dup
    //   330: invokespecial <init> : ()V
    //   333: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	246	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	218	java/io/IOException
    //   128	134	214	finally
    //   146	155	246	com/google/protobuf/InvalidProtocolBufferException
    //   146	155	218	java/io/IOException
    //   146	155	214	finally
    //   161	184	246	com/google/protobuf/InvalidProtocolBufferException
    //   161	184	218	java/io/IOException
    //   161	184	214	finally
    //   184	205	246	com/google/protobuf/InvalidProtocolBufferException
    //   184	205	218	java/io/IOException
    //   184	205	214	finally
    //   219	246	214	finally
    //   247	262	214	finally
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    byte b = 0;
    i = 0;
    while (b < this.values_.size()) {
      i += CodedOutputStream.computeMessageSize(1, this.values_.get(b));
      b++;
    } 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public Value getValues(int paramInt) {
    return this.values_.get(paramInt);
  }
  
  public int getValuesCount() {
    return this.values_.size();
  }
  
  public List<Value> getValuesList() {
    return this.values_;
  }
  
  public ValueOrBuilder getValuesOrBuilder(int paramInt) {
    return this.values_.get(paramInt);
  }
  
  public List<? extends ValueOrBuilder> getValuesOrBuilderList() {
    return (List)this.values_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (byte b = 0; b < this.values_.size(); b++)
      paramCodedOutputStream.writeMessage(1, this.values_.get(b)); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ListValue, Builder> implements ListValueOrBuilder {
    private Builder() {
      super(ListValue.DEFAULT_INSTANCE);
    }
    
    public Builder addAllValues(Iterable<? extends Value> param1Iterable) {
      copyOnWrite();
      this.instance.addAllValues(param1Iterable);
      return this;
    }
    
    public Builder addValues(int param1Int, Value.Builder param1Builder) {
      copyOnWrite();
      this.instance.addValues(param1Int, param1Builder);
      return this;
    }
    
    public Builder addValues(int param1Int, Value param1Value) {
      copyOnWrite();
      this.instance.addValues(param1Int, param1Value);
      return this;
    }
    
    public Builder addValues(Value.Builder param1Builder) {
      copyOnWrite();
      this.instance.addValues(param1Builder);
      return this;
    }
    
    public Builder addValues(Value param1Value) {
      copyOnWrite();
      this.instance.addValues(param1Value);
      return this;
    }
    
    public Builder clearValues() {
      copyOnWrite();
      this.instance.clearValues();
      return this;
    }
    
    public Value getValues(int param1Int) {
      return this.instance.getValues(param1Int);
    }
    
    public int getValuesCount() {
      return this.instance.getValuesCount();
    }
    
    public List<Value> getValuesList() {
      return Collections.unmodifiableList(this.instance.getValuesList());
    }
    
    public Builder removeValues(int param1Int) {
      copyOnWrite();
      this.instance.removeValues(param1Int);
      return this;
    }
    
    public Builder setValues(int param1Int, Value.Builder param1Builder) {
      copyOnWrite();
      this.instance.setValues(param1Int, param1Builder);
      return this;
    }
    
    public Builder setValues(int param1Int, Value param1Value) {
      copyOnWrite();
      this.instance.setValues(param1Int, param1Value);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\ListValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */