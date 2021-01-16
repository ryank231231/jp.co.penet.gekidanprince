package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends GeneratedMessageLite.Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {
  protected int memoizedSerializedSize = -1;
  
  protected UnknownFieldSetLite unknownFields = UnknownFieldSetLite.getDefaultInstance();
  
  private static <MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>, T> GeneratedExtension<MessageType, T> checkIsLite(ExtensionLite<MessageType, T> paramExtensionLite) {
    if (paramExtensionLite.isLite())
      return (GeneratedExtension<MessageType, T>)paramExtensionLite; 
    throw new IllegalArgumentException("Expected a lite extension.");
  }
  
  private static <T extends GeneratedMessageLite<T, ?>> T checkMessageInitialized(T paramT) throws InvalidProtocolBufferException {
    if (paramT == null || paramT.isInitialized())
      return paramT; 
    throw paramT.newUninitializedMessageException().asInvalidProtocolBufferException().setUnfinishedMessage(paramT);
  }
  
  protected static Internal.BooleanList emptyBooleanList() {
    return BooleanArrayList.emptyList();
  }
  
  protected static Internal.DoubleList emptyDoubleList() {
    return DoubleArrayList.emptyList();
  }
  
  protected static Internal.FloatList emptyFloatList() {
    return FloatArrayList.emptyList();
  }
  
  protected static Internal.IntList emptyIntList() {
    return IntArrayList.emptyList();
  }
  
  protected static Internal.LongList emptyLongList() {
    return LongArrayList.emptyList();
  }
  
  protected static <E> Internal.ProtobufList<E> emptyProtobufList() {
    return ProtobufArrayList.emptyList();
  }
  
  private final void ensureUnknownFieldsInitialized() {
    if (this.unknownFields == UnknownFieldSetLite.getDefaultInstance())
      this.unknownFields = UnknownFieldSetLite.newInstance(); 
  }
  
  static Method getMethodOrDie(Class paramClass, String paramString, Class... paramVarArgs) {
    try {
      return paramClass.getMethod(paramString, paramVarArgs);
    } catch (NoSuchMethodException noSuchMethodException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Generated message class \"");
      stringBuilder.append(paramClass.getName());
      stringBuilder.append("\" missing method \"");
      stringBuilder.append(paramString);
      stringBuilder.append("\".");
      throw new RuntimeException(stringBuilder.toString(), noSuchMethodException);
    } 
  }
  
  static Object invokeOrDie(Method paramMethod, Object paramObject, Object... paramVarArgs) {
    try {
      return paramMethod.invoke(paramObject, paramVarArgs);
    } catch (IllegalAccessException illegalAccessException) {
      throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", illegalAccessException);
    } catch (InvocationTargetException invocationTargetException) {
      Throwable throwable = invocationTargetException.getCause();
      if (!(throwable instanceof RuntimeException)) {
        if (throwable instanceof Error)
          throw (Error)throwable; 
        throw new RuntimeException("Unexpected exception thrown by generated accessor method.", throwable);
      } 
      throw (RuntimeException)throwable;
    } 
  }
  
  protected static final <T extends GeneratedMessageLite<T, ?>> boolean isInitialized(T paramT, boolean paramBoolean) {
    if (paramT.dynamicMethod(MethodToInvoke.IS_INITIALIZED, Boolean.valueOf(paramBoolean)) != null) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    } 
    return paramBoolean;
  }
  
  protected static final <T extends GeneratedMessageLite<T, ?>> void makeImmutable(T paramT) {
    paramT.dynamicMethod(MethodToInvoke.MAKE_IMMUTABLE);
  }
  
  protected static Internal.BooleanList mutableCopy(Internal.BooleanList paramBooleanList) {
    int i = paramBooleanList.size();
    if (i == 0) {
      i = 10;
    } else {
      i *= 2;
    } 
    return paramBooleanList.mutableCopyWithCapacity(i);
  }
  
  protected static Internal.DoubleList mutableCopy(Internal.DoubleList paramDoubleList) {
    int i = paramDoubleList.size();
    if (i == 0) {
      i = 10;
    } else {
      i *= 2;
    } 
    return paramDoubleList.mutableCopyWithCapacity(i);
  }
  
  protected static Internal.FloatList mutableCopy(Internal.FloatList paramFloatList) {
    int i = paramFloatList.size();
    if (i == 0) {
      i = 10;
    } else {
      i *= 2;
    } 
    return paramFloatList.mutableCopyWithCapacity(i);
  }
  
  protected static Internal.IntList mutableCopy(Internal.IntList paramIntList) {
    int i = paramIntList.size();
    if (i == 0) {
      i = 10;
    } else {
      i *= 2;
    } 
    return paramIntList.mutableCopyWithCapacity(i);
  }
  
  protected static Internal.LongList mutableCopy(Internal.LongList paramLongList) {
    int i = paramLongList.size();
    if (i == 0) {
      i = 10;
    } else {
      i *= 2;
    } 
    return paramLongList.mutableCopyWithCapacity(i);
  }
  
  protected static <E> Internal.ProtobufList<E> mutableCopy(Internal.ProtobufList<E> paramProtobufList) {
    int i = paramProtobufList.size();
    if (i == 0) {
      i = 10;
    } else {
      i *= 2;
    } 
    return paramProtobufList.mutableCopyWithCapacity(i);
  }
  
  public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType paramContainingType, MessageLite paramMessageLite, Internal.EnumLiteMap<?> paramEnumLiteMap, int paramInt, WireFormat.FieldType paramFieldType, boolean paramBoolean, Class paramClass) {
    return new GeneratedExtension<ContainingType, Type>(paramContainingType, (Type)Collections.emptyList(), paramMessageLite, new ExtensionDescriptor(paramEnumLiteMap, paramInt, paramFieldType, true, paramBoolean), paramClass);
  }
  
  public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType paramContainingType, Type paramType, MessageLite paramMessageLite, Internal.EnumLiteMap<?> paramEnumLiteMap, int paramInt, WireFormat.FieldType paramFieldType, Class paramClass) {
    return new GeneratedExtension<ContainingType, Type>(paramContainingType, paramType, paramMessageLite, new ExtensionDescriptor(paramEnumLiteMap, paramInt, paramFieldType, false, false), paramClass);
  }
  
  protected static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T paramT, InputStream paramInputStream) throws InvalidProtocolBufferException {
    return checkMessageInitialized(parsePartialDelimitedFrom(paramT, paramInputStream, ExtensionRegistryLite.getEmptyRegistry()));
  }
  
  protected static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T paramT, InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return checkMessageInitialized(parsePartialDelimitedFrom(paramT, paramInputStream, paramExtensionRegistryLite));
  }
  
  protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T paramT, ByteString paramByteString) throws InvalidProtocolBufferException {
    return checkMessageInitialized(parseFrom(paramT, paramByteString, ExtensionRegistryLite.getEmptyRegistry()));
  }
  
  protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T paramT, ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return checkMessageInitialized(parsePartialFrom(paramT, paramByteString, paramExtensionRegistryLite));
  }
  
  protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T paramT, CodedInputStream paramCodedInputStream) throws InvalidProtocolBufferException {
    return parseFrom(paramT, paramCodedInputStream, ExtensionRegistryLite.getEmptyRegistry());
  }
  
  protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T paramT, CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return checkMessageInitialized(parsePartialFrom(paramT, paramCodedInputStream, paramExtensionRegistryLite));
  }
  
  protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T paramT, InputStream paramInputStream) throws InvalidProtocolBufferException {
    return checkMessageInitialized(parsePartialFrom(paramT, CodedInputStream.newInstance(paramInputStream), ExtensionRegistryLite.getEmptyRegistry()));
  }
  
  protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T paramT, InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return checkMessageInitialized(parsePartialFrom(paramT, CodedInputStream.newInstance(paramInputStream), paramExtensionRegistryLite));
  }
  
  protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T paramT, byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return checkMessageInitialized(parsePartialFrom(paramT, paramArrayOfbyte, ExtensionRegistryLite.getEmptyRegistry()));
  }
  
  protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T paramT, byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return checkMessageInitialized(parsePartialFrom(paramT, paramArrayOfbyte, paramExtensionRegistryLite));
  }
  
  private static <T extends GeneratedMessageLite<T, ?>> T parsePartialDelimitedFrom(T paramT, InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    try {
      int i = paramInputStream.read();
      if (i == -1)
        return null; 
      i = CodedInputStream.readRawVarint32(i, paramInputStream);
      CodedInputStream codedInputStream = CodedInputStream.newInstance(new AbstractMessageLite.Builder.LimitedInputStream(paramInputStream, i));
      paramT = parsePartialFrom(paramT, codedInputStream, paramExtensionRegistryLite);
      try {
        codedInputStream.checkLastTagWas(0);
        return paramT;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw invalidProtocolBufferException.setUnfinishedMessage(paramT);
      } 
    } catch (IOException iOException) {
      throw new InvalidProtocolBufferException(iOException.getMessage());
    } 
  }
  
  private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T paramT, ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    try {
      CodedInputStream codedInputStream = paramByteString.newCodedInput();
      paramT = parsePartialFrom(paramT, codedInputStream, paramExtensionRegistryLite);
      try {
        codedInputStream.checkLastTagWas(0);
        return paramT;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw invalidProtocolBufferException.setUnfinishedMessage(paramT);
      } 
    } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
      throw invalidProtocolBufferException;
    } 
  }
  
  protected static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T paramT, CodedInputStream paramCodedInputStream) throws InvalidProtocolBufferException {
    return parsePartialFrom(paramT, paramCodedInputStream, ExtensionRegistryLite.getEmptyRegistry());
  }
  
  static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T paramT, CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite)paramT.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
    try {
      generatedMessageLite.dynamicMethod(MethodToInvoke.MERGE_FROM_STREAM, paramCodedInputStream, paramExtensionRegistryLite);
      generatedMessageLite.makeImmutable();
      return (T)generatedMessageLite;
    } catch (RuntimeException runtimeException) {
      if (runtimeException.getCause() instanceof InvalidProtocolBufferException)
        throw (InvalidProtocolBufferException)runtimeException.getCause(); 
      throw runtimeException;
    } 
  }
  
  private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T paramT, byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    try {
      CodedInputStream codedInputStream = CodedInputStream.newInstance(paramArrayOfbyte);
      paramT = parsePartialFrom(paramT, codedInputStream, paramExtensionRegistryLite);
      try {
        codedInputStream.checkLastTagWas(0);
        return paramT;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw invalidProtocolBufferException.setUnfinishedMessage(paramT);
      } 
    } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
      throw invalidProtocolBufferException;
    } 
  }
  
  protected Object dynamicMethod(MethodToInvoke paramMethodToInvoke) {
    return dynamicMethod(paramMethodToInvoke, (Object)null, (Object)null);
  }
  
  protected Object dynamicMethod(MethodToInvoke paramMethodToInvoke, Object paramObject) {
    return dynamicMethod(paramMethodToInvoke, paramObject, (Object)null);
  }
  
  protected abstract Object dynamicMethod(MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2);
  
  boolean equals(EqualsVisitor paramEqualsVisitor, MessageLite paramMessageLite) {
    if (this == paramMessageLite)
      return true; 
    if (!getDefaultInstanceForType().getClass().isInstance(paramMessageLite))
      return false; 
    visit(paramEqualsVisitor, (MessageType)paramMessageLite);
    return true;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!getDefaultInstanceForType().getClass().isInstance(paramObject))
      return false; 
    try {
      visit(EqualsVisitor.INSTANCE, (MessageType)paramObject);
      return true;
    } catch (NotEqualsException notEqualsException) {
      return false;
    } 
  }
  
  public final MessageType getDefaultInstanceForType() {
    return (MessageType)dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE);
  }
  
  public final Parser<MessageType> getParserForType() {
    return (Parser<MessageType>)dynamicMethod(MethodToInvoke.GET_PARSER);
  }
  
  public int hashCode() {
    if (this.memoizedHashCode == 0) {
      HashCodeVisitor hashCodeVisitor = new HashCodeVisitor();
      visit(hashCodeVisitor, (MessageType)this);
      this.memoizedHashCode = hashCodeVisitor.hashCode;
    } 
    return this.memoizedHashCode;
  }
  
  int hashCode(HashCodeVisitor paramHashCodeVisitor) {
    if (this.memoizedHashCode == 0) {
      int i = paramHashCodeVisitor.hashCode;
      HashCodeVisitor.access$102(paramHashCodeVisitor, 0);
      visit(paramHashCodeVisitor, (MessageType)this);
      this.memoizedHashCode = paramHashCodeVisitor.hashCode;
      HashCodeVisitor.access$102(paramHashCodeVisitor, i);
    } 
    return this.memoizedHashCode;
  }
  
  public final boolean isInitialized() {
    boolean bool;
    if (dynamicMethod(MethodToInvoke.IS_INITIALIZED, Boolean.TRUE) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  protected void makeImmutable() {
    dynamicMethod(MethodToInvoke.MAKE_IMMUTABLE);
    this.unknownFields.makeImmutable();
  }
  
  protected void mergeLengthDelimitedField(int paramInt, ByteString paramByteString) {
    ensureUnknownFieldsInitialized();
    this.unknownFields.mergeLengthDelimitedField(paramInt, paramByteString);
  }
  
  protected final void mergeUnknownFields(UnknownFieldSetLite paramUnknownFieldSetLite) {
    this.unknownFields = UnknownFieldSetLite.mutableCopyOf(this.unknownFields, paramUnknownFieldSetLite);
  }
  
  protected void mergeVarintField(int paramInt1, int paramInt2) {
    ensureUnknownFieldsInitialized();
    this.unknownFields.mergeVarintField(paramInt1, paramInt2);
  }
  
  public final BuilderType newBuilderForType() {
    return (BuilderType)dynamicMethod(MethodToInvoke.NEW_BUILDER);
  }
  
  protected boolean parseUnknownField(int paramInt, CodedInputStream paramCodedInputStream) throws IOException {
    if (WireFormat.getTagWireType(paramInt) == 4)
      return false; 
    ensureUnknownFieldsInitialized();
    return this.unknownFields.mergeFieldFrom(paramInt, paramCodedInputStream);
  }
  
  public final BuilderType toBuilder() {
    Builder builder = (Builder)dynamicMethod(MethodToInvoke.NEW_BUILDER);
    builder.mergeFrom(this);
    return (BuilderType)builder;
  }
  
  public String toString() {
    return MessageLiteToString.toString(this, super.toString());
  }
  
  void visit(Visitor paramVisitor, MessageType paramMessageType) {
    dynamicMethod(MethodToInvoke.VISIT, paramVisitor, paramMessageType);
    this.unknownFields = paramVisitor.visitUnknownFields(this.unknownFields, ((GeneratedMessageLite)paramMessageType).unknownFields);
  }
  
  public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {
    private final MessageType defaultInstance;
    
    protected MessageType instance;
    
    protected boolean isBuilt;
    
    protected Builder(MessageType param1MessageType) {
      this.defaultInstance = param1MessageType;
      this.instance = (MessageType)param1MessageType.dynamicMethod(GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE);
      this.isBuilt = false;
    }
    
    public final MessageType build() {
      MessageType messageType = buildPartial();
      if (messageType.isInitialized())
        return messageType; 
      throw newUninitializedMessageException(messageType);
    }
    
    public MessageType buildPartial() {
      if (this.isBuilt)
        return this.instance; 
      this.instance.makeImmutable();
      this.isBuilt = true;
      return this.instance;
    }
    
    public final BuilderType clear() {
      this.instance = (MessageType)this.instance.dynamicMethod(GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE);
      return (BuilderType)this;
    }
    
    public BuilderType clone() {
      Object object = getDefaultInstanceForType().newBuilderForType();
      object.mergeFrom(buildPartial());
      return (BuilderType)object;
    }
    
    protected void copyOnWrite() {
      if (this.isBuilt) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite)this.instance.dynamicMethod(GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE);
        generatedMessageLite.visit(GeneratedMessageLite.MergeFromVisitor.INSTANCE, this.instance);
        this.instance = (MessageType)generatedMessageLite;
        this.isBuilt = false;
      } 
    }
    
    public MessageType getDefaultInstanceForType() {
      return this.defaultInstance;
    }
    
    protected BuilderType internalMergeFrom(MessageType param1MessageType) {
      return mergeFrom(param1MessageType);
    }
    
    public final boolean isInitialized() {
      return GeneratedMessageLite.isInitialized(this.instance, false);
    }
    
    public BuilderType mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      copyOnWrite();
      try {
        this.instance.dynamicMethod(GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM, param1CodedInputStream, param1ExtensionRegistryLite);
        return (BuilderType)this;
      } catch (RuntimeException runtimeException) {
        if (runtimeException.getCause() instanceof IOException)
          throw (IOException)runtimeException.getCause(); 
        throw runtimeException;
      } 
    }
    
    public BuilderType mergeFrom(MessageType param1MessageType) {
      copyOnWrite();
      this.instance.visit(GeneratedMessageLite.MergeFromVisitor.INSTANCE, param1MessageType);
      return (BuilderType)this;
    }
  }
  
  protected static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {
    private T defaultInstance;
    
    public DefaultInstanceBasedParser(T param1T) {
      this.defaultInstance = param1T;
    }
    
    public T parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return GeneratedMessageLite.parsePartialFrom(this.defaultInstance, param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  static class EqualsVisitor implements Visitor {
    static final EqualsVisitor INSTANCE = new EqualsVisitor();
    
    static final NotEqualsException NOT_EQUALS = new NotEqualsException();
    
    public boolean visitBoolean(boolean param1Boolean1, boolean param1Boolean2, boolean param1Boolean3, boolean param1Boolean4) {
      if (param1Boolean1 == param1Boolean3 && param1Boolean2 == param1Boolean4)
        return param1Boolean2; 
      throw NOT_EQUALS;
    }
    
    public Internal.BooleanList visitBooleanList(Internal.BooleanList param1BooleanList1, Internal.BooleanList param1BooleanList2) {
      if (param1BooleanList1.equals(param1BooleanList2))
        return param1BooleanList1; 
      throw NOT_EQUALS;
    }
    
    public ByteString visitByteString(boolean param1Boolean1, ByteString param1ByteString1, boolean param1Boolean2, ByteString param1ByteString2) {
      if (param1Boolean1 == param1Boolean2 && param1ByteString1.equals(param1ByteString2))
        return param1ByteString1; 
      throw NOT_EQUALS;
    }
    
    public double visitDouble(boolean param1Boolean1, double param1Double1, boolean param1Boolean2, double param1Double2) {
      if (param1Boolean1 == param1Boolean2 && param1Double1 == param1Double2)
        return param1Double1; 
      throw NOT_EQUALS;
    }
    
    public Internal.DoubleList visitDoubleList(Internal.DoubleList param1DoubleList1, Internal.DoubleList param1DoubleList2) {
      if (param1DoubleList1.equals(param1DoubleList2))
        return param1DoubleList1; 
      throw NOT_EQUALS;
    }
    
    public FieldSet<GeneratedMessageLite.ExtensionDescriptor> visitExtensions(FieldSet<GeneratedMessageLite.ExtensionDescriptor> param1FieldSet1, FieldSet<GeneratedMessageLite.ExtensionDescriptor> param1FieldSet2) {
      if (param1FieldSet1.equals(param1FieldSet2))
        return param1FieldSet1; 
      throw NOT_EQUALS;
    }
    
    public float visitFloat(boolean param1Boolean1, float param1Float1, boolean param1Boolean2, float param1Float2) {
      if (param1Boolean1 == param1Boolean2 && param1Float1 == param1Float2)
        return param1Float1; 
      throw NOT_EQUALS;
    }
    
    public Internal.FloatList visitFloatList(Internal.FloatList param1FloatList1, Internal.FloatList param1FloatList2) {
      if (param1FloatList1.equals(param1FloatList2))
        return param1FloatList1; 
      throw NOT_EQUALS;
    }
    
    public int visitInt(boolean param1Boolean1, int param1Int1, boolean param1Boolean2, int param1Int2) {
      if (param1Boolean1 == param1Boolean2 && param1Int1 == param1Int2)
        return param1Int1; 
      throw NOT_EQUALS;
    }
    
    public Internal.IntList visitIntList(Internal.IntList param1IntList1, Internal.IntList param1IntList2) {
      if (param1IntList1.equals(param1IntList2))
        return param1IntList1; 
      throw NOT_EQUALS;
    }
    
    public LazyFieldLite visitLazyMessage(LazyFieldLite param1LazyFieldLite1, LazyFieldLite param1LazyFieldLite2) {
      if (param1LazyFieldLite1 == null && param1LazyFieldLite2 == null)
        return null; 
      if (param1LazyFieldLite1 != null && param1LazyFieldLite2 != null) {
        if (param1LazyFieldLite1.equals(param1LazyFieldLite2))
          return param1LazyFieldLite1; 
        throw NOT_EQUALS;
      } 
      throw NOT_EQUALS;
    }
    
    public <T> Internal.ProtobufList<T> visitList(Internal.ProtobufList<T> param1ProtobufList1, Internal.ProtobufList<T> param1ProtobufList2) {
      if (param1ProtobufList1.equals(param1ProtobufList2))
        return param1ProtobufList1; 
      throw NOT_EQUALS;
    }
    
    public long visitLong(boolean param1Boolean1, long param1Long1, boolean param1Boolean2, long param1Long2) {
      if (param1Boolean1 == param1Boolean2 && param1Long1 == param1Long2)
        return param1Long1; 
      throw NOT_EQUALS;
    }
    
    public Internal.LongList visitLongList(Internal.LongList param1LongList1, Internal.LongList param1LongList2) {
      if (param1LongList1.equals(param1LongList2))
        return param1LongList1; 
      throw NOT_EQUALS;
    }
    
    public <K, V> MapFieldLite<K, V> visitMap(MapFieldLite<K, V> param1MapFieldLite1, MapFieldLite<K, V> param1MapFieldLite2) {
      if (param1MapFieldLite1.equals(param1MapFieldLite2))
        return param1MapFieldLite1; 
      throw NOT_EQUALS;
    }
    
    public <T extends MessageLite> T visitMessage(T param1T1, T param1T2) {
      if (param1T1 == null && param1T2 == null)
        return null; 
      if (param1T1 != null && param1T2 != null) {
        ((GeneratedMessageLite)param1T1).equals(this, (MessageLite)param1T2);
        return param1T1;
      } 
      throw NOT_EQUALS;
    }
    
    public Object visitOneofBoolean(boolean param1Boolean, Object param1Object1, Object param1Object2) {
      if (param1Boolean && param1Object1.equals(param1Object2))
        return param1Object1; 
      throw NOT_EQUALS;
    }
    
    public Object visitOneofByteString(boolean param1Boolean, Object param1Object1, Object param1Object2) {
      if (param1Boolean && param1Object1.equals(param1Object2))
        return param1Object1; 
      throw NOT_EQUALS;
    }
    
    public Object visitOneofDouble(boolean param1Boolean, Object param1Object1, Object param1Object2) {
      if (param1Boolean && param1Object1.equals(param1Object2))
        return param1Object1; 
      throw NOT_EQUALS;
    }
    
    public Object visitOneofFloat(boolean param1Boolean, Object param1Object1, Object param1Object2) {
      if (param1Boolean && param1Object1.equals(param1Object2))
        return param1Object1; 
      throw NOT_EQUALS;
    }
    
    public Object visitOneofInt(boolean param1Boolean, Object param1Object1, Object param1Object2) {
      if (param1Boolean && param1Object1.equals(param1Object2))
        return param1Object1; 
      throw NOT_EQUALS;
    }
    
    public Object visitOneofLazyMessage(boolean param1Boolean, Object param1Object1, Object param1Object2) {
      if (param1Boolean && param1Object1.equals(param1Object2))
        return param1Object1; 
      throw NOT_EQUALS;
    }
    
    public Object visitOneofLong(boolean param1Boolean, Object param1Object1, Object param1Object2) {
      if (param1Boolean && param1Object1.equals(param1Object2))
        return param1Object1; 
      throw NOT_EQUALS;
    }
    
    public Object visitOneofMessage(boolean param1Boolean, Object param1Object1, Object param1Object2) {
      if (param1Boolean && ((GeneratedMessageLite)param1Object1).equals(this, (MessageLite)param1Object2))
        return param1Object1; 
      throw NOT_EQUALS;
    }
    
    public void visitOneofNotSet(boolean param1Boolean) {
      if (!param1Boolean)
        return; 
      throw NOT_EQUALS;
    }
    
    public Object visitOneofString(boolean param1Boolean, Object param1Object1, Object param1Object2) {
      if (param1Boolean && param1Object1.equals(param1Object2))
        return param1Object1; 
      throw NOT_EQUALS;
    }
    
    public String visitString(boolean param1Boolean1, String param1String1, boolean param1Boolean2, String param1String2) {
      if (param1Boolean1 == param1Boolean2 && param1String1.equals(param1String2))
        return param1String1; 
      throw NOT_EQUALS;
    }
    
    public UnknownFieldSetLite visitUnknownFields(UnknownFieldSetLite param1UnknownFieldSetLite1, UnknownFieldSetLite param1UnknownFieldSetLite2) {
      if (param1UnknownFieldSetLite1.equals(param1UnknownFieldSetLite2))
        return param1UnknownFieldSetLite1; 
      throw NOT_EQUALS;
    }
    
    static final class NotEqualsException extends RuntimeException {}
  }
  
  static final class NotEqualsException extends RuntimeException {}
  
  public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
    protected ExtendableBuilder(MessageType param1MessageType) {
      super(param1MessageType);
      ((GeneratedMessageLite.ExtendableMessage)this.instance).extensions = ((GeneratedMessageLite.ExtendableMessage)this.instance).extensions.clone();
    }
    
    private void verifyExtensionContainingType(GeneratedMessageLite.GeneratedExtension<MessageType, ?> param1GeneratedExtension) {
      if (param1GeneratedExtension.getContainingTypeDefaultInstance() == getDefaultInstanceForType())
        return; 
      throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
    }
    
    public final <Type> BuilderType addExtension(ExtensionLite<MessageType, List<Type>> param1ExtensionLite, Type param1Type) {
      param1ExtensionLite = (ExtensionLite)GeneratedMessageLite.checkIsLite((ExtensionLite)param1ExtensionLite);
      verifyExtensionContainingType((GeneratedMessageLite.GeneratedExtension<MessageType, ?>)param1ExtensionLite);
      copyOnWrite();
      ((GeneratedMessageLite.ExtendableMessage)this.instance).extensions.addRepeatedField(((GeneratedMessageLite.GeneratedExtension)param1ExtensionLite).descriptor, param1ExtensionLite.singularToFieldSetType(param1Type));
      return (BuilderType)this;
    }
    
    public final MessageType buildPartial() {
      if (this.isBuilt)
        return this.instance; 
      ((GeneratedMessageLite.ExtendableMessage)this.instance).extensions.makeImmutable();
      return super.buildPartial();
    }
    
    public final <Type> BuilderType clearExtension(ExtensionLite<MessageType, ?> param1ExtensionLite) {
      param1ExtensionLite = GeneratedMessageLite.checkIsLite((ExtensionLite)param1ExtensionLite);
      verifyExtensionContainingType((GeneratedMessageLite.GeneratedExtension<MessageType, ?>)param1ExtensionLite);
      copyOnWrite();
      ((GeneratedMessageLite.ExtendableMessage)this.instance).extensions.clearField(((GeneratedMessageLite.GeneratedExtension)param1ExtensionLite).descriptor);
      return (BuilderType)this;
    }
    
    public BuilderType clone() {
      return super.clone();
    }
    
    protected void copyOnWrite() {
      if (!this.isBuilt)
        return; 
      super.copyOnWrite();
      ((GeneratedMessageLite.ExtendableMessage)this.instance).extensions = ((GeneratedMessageLite.ExtendableMessage)this.instance).extensions.clone();
    }
    
    public final <Type> Type getExtension(ExtensionLite<MessageType, Type> param1ExtensionLite) {
      return (Type)((GeneratedMessageLite.ExtendableMessage)this.instance).getExtension(param1ExtensionLite);
    }
    
    public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> param1ExtensionLite, int param1Int) {
      return (Type)((GeneratedMessageLite.ExtendableMessage)this.instance).getExtension(param1ExtensionLite, param1Int);
    }
    
    public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> param1ExtensionLite) {
      return ((GeneratedMessageLite.ExtendableMessage)this.instance).getExtensionCount(param1ExtensionLite);
    }
    
    public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> param1ExtensionLite) {
      return ((GeneratedMessageLite.ExtendableMessage)this.instance).hasExtension(param1ExtensionLite);
    }
    
    void internalSetExtensionSet(FieldSet<GeneratedMessageLite.ExtensionDescriptor> param1FieldSet) {
      copyOnWrite();
      ((GeneratedMessageLite.ExtendableMessage)this.instance).extensions = param1FieldSet;
    }
    
    public final <Type> BuilderType setExtension(ExtensionLite<MessageType, List<Type>> param1ExtensionLite, int param1Int, Type param1Type) {
      param1ExtensionLite = (ExtensionLite)GeneratedMessageLite.checkIsLite((ExtensionLite)param1ExtensionLite);
      verifyExtensionContainingType((GeneratedMessageLite.GeneratedExtension<MessageType, ?>)param1ExtensionLite);
      copyOnWrite();
      ((GeneratedMessageLite.ExtendableMessage)this.instance).extensions.setRepeatedField(((GeneratedMessageLite.GeneratedExtension)param1ExtensionLite).descriptor, param1Int, param1ExtensionLite.singularToFieldSetType(param1Type));
      return (BuilderType)this;
    }
    
    public final <Type> BuilderType setExtension(ExtensionLite<MessageType, Type> param1ExtensionLite, Type param1Type) {
      param1ExtensionLite = GeneratedMessageLite.checkIsLite(param1ExtensionLite);
      verifyExtensionContainingType((GeneratedMessageLite.GeneratedExtension<MessageType, ?>)param1ExtensionLite);
      copyOnWrite();
      ((GeneratedMessageLite.ExtendableMessage)this.instance).extensions.setField(((GeneratedMessageLite.GeneratedExtension)param1ExtensionLite).descriptor, param1ExtensionLite.toFieldSetType(param1Type));
      return (BuilderType)this;
    }
  }
  
  public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
    protected FieldSet<GeneratedMessageLite.ExtensionDescriptor> extensions = FieldSet.newFieldSet();
    
    private void verifyExtensionContainingType(GeneratedMessageLite.GeneratedExtension<MessageType, ?> param1GeneratedExtension) {
      if (param1GeneratedExtension.getContainingTypeDefaultInstance() == getDefaultInstanceForType())
        return; 
      throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
    }
    
    protected boolean extensionsAreInitialized() {
      return this.extensions.isInitialized();
    }
    
    protected int extensionsSerializedSize() {
      return this.extensions.getSerializedSize();
    }
    
    protected int extensionsSerializedSizeAsMessageSet() {
      return this.extensions.getMessageSetSerializedSize();
    }
    
    public final <Type> Type getExtension(ExtensionLite<MessageType, Type> param1ExtensionLite) {
      param1ExtensionLite = GeneratedMessageLite.checkIsLite(param1ExtensionLite);
      verifyExtensionContainingType((GeneratedMessageLite.GeneratedExtension<MessageType, ?>)param1ExtensionLite);
      Object object = this.extensions.getField(((GeneratedMessageLite.GeneratedExtension)param1ExtensionLite).descriptor);
      return (Type)((object == null) ? (Object)((GeneratedMessageLite.GeneratedExtension)param1ExtensionLite).defaultValue : param1ExtensionLite.fromFieldSetType(object));
    }
    
    public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> param1ExtensionLite, int param1Int) {
      param1ExtensionLite = (ExtensionLite)GeneratedMessageLite.checkIsLite((ExtensionLite)param1ExtensionLite);
      verifyExtensionContainingType((GeneratedMessageLite.GeneratedExtension<MessageType, ?>)param1ExtensionLite);
      return (Type)param1ExtensionLite.singularFromFieldSetType(this.extensions.getRepeatedField(((GeneratedMessageLite.GeneratedExtension)param1ExtensionLite).descriptor, param1Int));
    }
    
    public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> param1ExtensionLite) {
      param1ExtensionLite = (ExtensionLite)GeneratedMessageLite.checkIsLite((ExtensionLite)param1ExtensionLite);
      verifyExtensionContainingType((GeneratedMessageLite.GeneratedExtension<MessageType, ?>)param1ExtensionLite);
      return this.extensions.getRepeatedFieldCount(((GeneratedMessageLite.GeneratedExtension)param1ExtensionLite).descriptor);
    }
    
    public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> param1ExtensionLite) {
      param1ExtensionLite = GeneratedMessageLite.checkIsLite(param1ExtensionLite);
      verifyExtensionContainingType((GeneratedMessageLite.GeneratedExtension<MessageType, ?>)param1ExtensionLite);
      return this.extensions.hasField(((GeneratedMessageLite.GeneratedExtension)param1ExtensionLite).descriptor);
    }
    
    protected final void makeImmutable() {
      super.makeImmutable();
      this.extensions.makeImmutable();
    }
    
    protected final void mergeExtensionFields(MessageType param1MessageType) {
      if (this.extensions.isImmutable())
        this.extensions = this.extensions.clone(); 
      this.extensions.mergeFrom(((ExtendableMessage)param1MessageType).extensions);
    }
    
    protected ExtensionWriter newExtensionWriter() {
      return new ExtensionWriter(false);
    }
    
    protected ExtensionWriter newMessageSetExtensionWriter() {
      return new ExtensionWriter(true);
    }
    
    protected <MessageType extends MessageLite> boolean parseUnknownField(MessageType param1MessageType, CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite, int param1Int) throws IOException {
      boolean bool;
      int i = WireFormat.getTagWireType(param1Int);
      int j = WireFormat.getTagFieldNumber(param1Int);
      GeneratedMessageLite.GeneratedExtension<MessageType, ?> generatedExtension = param1ExtensionRegistryLite.findLiteExtensionByNumber(param1MessageType, j);
      if (generatedExtension == null) {
        i = 1;
        bool = false;
      } else if (i == FieldSet.getWireFormatForFieldType(generatedExtension.descriptor.getLiteType(), false)) {
        i = 0;
        bool = false;
      } else if (generatedExtension.descriptor.isRepeated && generatedExtension.descriptor.type.isPackable() && i == FieldSet.getWireFormatForFieldType(generatedExtension.descriptor.getLiteType(), true)) {
        i = 0;
        bool = true;
      } else {
        i = 1;
        bool = false;
      } 
      if (i != 0)
        return parseUnknownField(param1Int, param1CodedInputStream); 
      if (bool) {
        param1Int = param1CodedInputStream.pushLimit(param1CodedInputStream.readRawVarint32());
        if (generatedExtension.descriptor.getLiteType() == WireFormat.FieldType.ENUM) {
          while (param1CodedInputStream.getBytesUntilLimit() > 0) {
            i = param1CodedInputStream.readEnum();
            param1MessageType = (MessageType)generatedExtension.descriptor.getEnumType().findValueByNumber(i);
            if (param1MessageType == null)
              return true; 
            this.extensions.addRepeatedField(generatedExtension.descriptor, generatedExtension.singularToFieldSetType(param1MessageType));
          } 
        } else {
          while (param1CodedInputStream.getBytesUntilLimit() > 0) {
            param1MessageType = (MessageType)FieldSet.readPrimitiveField(param1CodedInputStream, generatedExtension.descriptor.getLiteType(), false);
            this.extensions.addRepeatedField(generatedExtension.descriptor, param1MessageType);
          } 
        } 
        param1CodedInputStream.popLimit(param1Int);
      } else {
        CodedInputStream codedInputStream1;
        MessageLite.Builder builder1;
        MessageLite messageLite;
        CodedInputStream codedInputStream2;
        MessageLite.Builder builder2;
        switch (generatedExtension.descriptor.getLiteJavaType()) {
          default:
            param1MessageType = (MessageType)FieldSet.readPrimitiveField(param1CodedInputStream, generatedExtension.descriptor.getLiteType(), false);
            break;
          case ENUM:
            param1Int = param1CodedInputStream.readEnum();
            param1CodedInputStream = (CodedInputStream)generatedExtension.descriptor.getEnumType().findValueByNumber(param1Int);
            codedInputStream1 = param1CodedInputStream;
            if (param1CodedInputStream == null) {
              mergeVarintField(j, param1Int);
              return true;
            } 
            break;
          case MESSAGE:
            codedInputStream2 = null;
            codedInputStream1 = codedInputStream2;
            if (!generatedExtension.descriptor.isRepeated()) {
              MessageLite messageLite1 = (MessageLite)this.extensions.getField(generatedExtension.descriptor);
              codedInputStream1 = codedInputStream2;
              if (messageLite1 != null)
                builder1 = messageLite1.toBuilder(); 
            } 
            builder2 = builder1;
            if (builder1 == null)
              builder2 = generatedExtension.getMessageDefaultInstance().newBuilderForType(); 
            if (generatedExtension.descriptor.getLiteType() == WireFormat.FieldType.GROUP) {
              param1CodedInputStream.readGroup(generatedExtension.getNumber(), builder2, param1ExtensionRegistryLite);
            } else {
              param1CodedInputStream.readMessage(builder2, param1ExtensionRegistryLite);
            } 
            messageLite = builder2.build();
            break;
        } 
        if (generatedExtension.descriptor.isRepeated()) {
          this.extensions.addRepeatedField(generatedExtension.descriptor, generatedExtension.singularToFieldSetType(messageLite));
        } else {
          this.extensions.setField(generatedExtension.descriptor, generatedExtension.singularToFieldSetType(messageLite));
        } 
      } 
      return true;
    }
    
    final void visit(GeneratedMessageLite.Visitor param1Visitor, MessageType param1MessageType) {
      super.visit(param1Visitor, param1MessageType);
      this.extensions = param1Visitor.visitExtensions(this.extensions, ((ExtendableMessage)param1MessageType).extensions);
    }
    
    protected class ExtensionWriter {
      private final Iterator<Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object>> iter = GeneratedMessageLite.ExtendableMessage.this.extensions.iterator();
      
      private final boolean messageSetWireFormat;
      
      private Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object> next;
      
      private ExtensionWriter(boolean param2Boolean) {
        if (this.iter.hasNext())
          this.next = this.iter.next(); 
        this.messageSetWireFormat = param2Boolean;
      }
      
      public void writeUntil(int param2Int, CodedOutputStream param2CodedOutputStream) throws IOException {
        while (true) {
          Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object> entry = this.next;
          if (entry != null && ((GeneratedMessageLite.ExtensionDescriptor)entry.getKey()).getNumber() < param2Int) {
            GeneratedMessageLite.ExtensionDescriptor extensionDescriptor = this.next.getKey();
            if (this.messageSetWireFormat && extensionDescriptor.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !extensionDescriptor.isRepeated()) {
              param2CodedOutputStream.writeMessageSetExtension(extensionDescriptor.getNumber(), (MessageLite)this.next.getValue());
            } else {
              FieldSet.writeField(extensionDescriptor, this.next.getValue(), param2CodedOutputStream);
            } 
            if (this.iter.hasNext()) {
              this.next = this.iter.next();
              continue;
            } 
            this.next = null;
            continue;
          } 
          break;
        } 
      }
    }
  }
  
  protected class ExtensionWriter {
    private final Iterator<Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object>> iter = GeneratedMessageLite.ExtendableMessage.this.extensions.iterator();
    
    private final boolean messageSetWireFormat;
    
    private Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object> next;
    
    private ExtensionWriter(boolean param1Boolean) {
      if (this.iter.hasNext())
        this.next = this.iter.next(); 
      this.messageSetWireFormat = param1Boolean;
    }
    
    public void writeUntil(int param1Int, CodedOutputStream param1CodedOutputStream) throws IOException {
      while (true) {
        Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object> entry = this.next;
        if (entry != null && ((GeneratedMessageLite.ExtensionDescriptor)entry.getKey()).getNumber() < param1Int) {
          GeneratedMessageLite.ExtensionDescriptor extensionDescriptor = this.next.getKey();
          if (this.messageSetWireFormat && extensionDescriptor.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !extensionDescriptor.isRepeated()) {
            param1CodedOutputStream.writeMessageSetExtension(extensionDescriptor.getNumber(), (MessageLite)this.next.getValue());
          } else {
            FieldSet.writeField(extensionDescriptor, this.next.getValue(), param1CodedOutputStream);
          } 
          if (this.iter.hasNext()) {
            this.next = this.iter.next();
            continue;
          } 
          this.next = null;
          continue;
        } 
        break;
      } 
    }
  }
  
  public static interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends MessageLiteOrBuilder {
    <Type> Type getExtension(ExtensionLite<MessageType, Type> param1ExtensionLite);
    
    <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> param1ExtensionLite, int param1Int);
    
    <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> param1ExtensionLite);
    
    <Type> boolean hasExtension(ExtensionLite<MessageType, Type> param1ExtensionLite);
  }
  
  static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {
    final Internal.EnumLiteMap<?> enumTypeMap;
    
    final boolean isPacked;
    
    final boolean isRepeated;
    
    final int number;
    
    final WireFormat.FieldType type;
    
    ExtensionDescriptor(Internal.EnumLiteMap<?> param1EnumLiteMap, int param1Int, WireFormat.FieldType param1FieldType, boolean param1Boolean1, boolean param1Boolean2) {
      this.enumTypeMap = param1EnumLiteMap;
      this.number = param1Int;
      this.type = param1FieldType;
      this.isRepeated = param1Boolean1;
      this.isPacked = param1Boolean2;
    }
    
    public int compareTo(ExtensionDescriptor param1ExtensionDescriptor) {
      return this.number - param1ExtensionDescriptor.number;
    }
    
    public Internal.EnumLiteMap<?> getEnumType() {
      return this.enumTypeMap;
    }
    
    public WireFormat.JavaType getLiteJavaType() {
      return this.type.getJavaType();
    }
    
    public WireFormat.FieldType getLiteType() {
      return this.type;
    }
    
    public int getNumber() {
      return this.number;
    }
    
    public MessageLite.Builder internalMergeFrom(MessageLite.Builder param1Builder, MessageLite param1MessageLite) {
      return ((GeneratedMessageLite.Builder<GeneratedMessageLite, MessageLite.Builder>)param1Builder).mergeFrom((GeneratedMessageLite)param1MessageLite);
    }
    
    public boolean isPacked() {
      return this.isPacked;
    }
    
    public boolean isRepeated() {
      return this.isRepeated;
    }
  }
  
  public static class GeneratedExtension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {
    final ContainingType containingTypeDefaultInstance;
    
    final Type defaultValue;
    
    final GeneratedMessageLite.ExtensionDescriptor descriptor;
    
    final MessageLite messageDefaultInstance;
    
    GeneratedExtension(ContainingType param1ContainingType, Type param1Type, MessageLite param1MessageLite, GeneratedMessageLite.ExtensionDescriptor param1ExtensionDescriptor, Class param1Class) {
      if (param1ContainingType != null) {
        if (param1ExtensionDescriptor.getLiteType() != WireFormat.FieldType.MESSAGE || param1MessageLite != null) {
          this.containingTypeDefaultInstance = param1ContainingType;
          this.defaultValue = param1Type;
          this.messageDefaultInstance = param1MessageLite;
          this.descriptor = param1ExtensionDescriptor;
          return;
        } 
        throw new IllegalArgumentException("Null messageDefaultInstance");
      } 
      throw new IllegalArgumentException("Null containingTypeDefaultInstance");
    }
    
    Object fromFieldSetType(Object param1Object) {
      if (this.descriptor.isRepeated()) {
        if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) {
          ArrayList<Object> arrayList = new ArrayList();
          param1Object = ((List)param1Object).iterator();
          while (param1Object.hasNext())
            arrayList.add(singularFromFieldSetType(param1Object.next())); 
          return arrayList;
        } 
        return param1Object;
      } 
      return singularFromFieldSetType(param1Object);
    }
    
    public ContainingType getContainingTypeDefaultInstance() {
      return this.containingTypeDefaultInstance;
    }
    
    public Type getDefaultValue() {
      return this.defaultValue;
    }
    
    public WireFormat.FieldType getLiteType() {
      return this.descriptor.getLiteType();
    }
    
    public MessageLite getMessageDefaultInstance() {
      return this.messageDefaultInstance;
    }
    
    public int getNumber() {
      return this.descriptor.getNumber();
    }
    
    public boolean isRepeated() {
      return this.descriptor.isRepeated;
    }
    
    Object singularFromFieldSetType(Object param1Object) {
      return (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) ? this.descriptor.enumTypeMap.findValueByNumber(((Integer)param1Object).intValue()) : param1Object;
    }
    
    Object singularToFieldSetType(Object param1Object) {
      return (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) ? Integer.valueOf(((Internal.EnumLite)param1Object).getNumber()) : param1Object;
    }
    
    Object toFieldSetType(Object param1Object) {
      if (this.descriptor.isRepeated()) {
        if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) {
          ArrayList<Object> arrayList = new ArrayList();
          param1Object = ((List)param1Object).iterator();
          while (param1Object.hasNext())
            arrayList.add(singularToFieldSetType(param1Object.next())); 
          return arrayList;
        } 
        return param1Object;
      } 
      return singularToFieldSetType(param1Object);
    }
  }
  
  private static class HashCodeVisitor implements Visitor {
    private int hashCode = 0;
    
    private HashCodeVisitor() {}
    
    public boolean visitBoolean(boolean param1Boolean1, boolean param1Boolean2, boolean param1Boolean3, boolean param1Boolean4) {
      this.hashCode = this.hashCode * 53 + Internal.hashBoolean(param1Boolean2);
      return param1Boolean2;
    }
    
    public Internal.BooleanList visitBooleanList(Internal.BooleanList param1BooleanList1, Internal.BooleanList param1BooleanList2) {
      this.hashCode = this.hashCode * 53 + param1BooleanList1.hashCode();
      return param1BooleanList1;
    }
    
    public ByteString visitByteString(boolean param1Boolean1, ByteString param1ByteString1, boolean param1Boolean2, ByteString param1ByteString2) {
      this.hashCode = this.hashCode * 53 + param1ByteString1.hashCode();
      return param1ByteString1;
    }
    
    public double visitDouble(boolean param1Boolean1, double param1Double1, boolean param1Boolean2, double param1Double2) {
      this.hashCode = this.hashCode * 53 + Internal.hashLong(Double.doubleToLongBits(param1Double1));
      return param1Double1;
    }
    
    public Internal.DoubleList visitDoubleList(Internal.DoubleList param1DoubleList1, Internal.DoubleList param1DoubleList2) {
      this.hashCode = this.hashCode * 53 + param1DoubleList1.hashCode();
      return param1DoubleList1;
    }
    
    public FieldSet<GeneratedMessageLite.ExtensionDescriptor> visitExtensions(FieldSet<GeneratedMessageLite.ExtensionDescriptor> param1FieldSet1, FieldSet<GeneratedMessageLite.ExtensionDescriptor> param1FieldSet2) {
      this.hashCode = this.hashCode * 53 + param1FieldSet1.hashCode();
      return param1FieldSet1;
    }
    
    public float visitFloat(boolean param1Boolean1, float param1Float1, boolean param1Boolean2, float param1Float2) {
      this.hashCode = this.hashCode * 53 + Float.floatToIntBits(param1Float1);
      return param1Float1;
    }
    
    public Internal.FloatList visitFloatList(Internal.FloatList param1FloatList1, Internal.FloatList param1FloatList2) {
      this.hashCode = this.hashCode * 53 + param1FloatList1.hashCode();
      return param1FloatList1;
    }
    
    public int visitInt(boolean param1Boolean1, int param1Int1, boolean param1Boolean2, int param1Int2) {
      this.hashCode = this.hashCode * 53 + param1Int1;
      return param1Int1;
    }
    
    public Internal.IntList visitIntList(Internal.IntList param1IntList1, Internal.IntList param1IntList2) {
      this.hashCode = this.hashCode * 53 + param1IntList1.hashCode();
      return param1IntList1;
    }
    
    public LazyFieldLite visitLazyMessage(LazyFieldLite param1LazyFieldLite1, LazyFieldLite param1LazyFieldLite2) {
      byte b;
      if (param1LazyFieldLite1 != null) {
        b = param1LazyFieldLite1.hashCode();
      } else {
        b = 37;
      } 
      this.hashCode = this.hashCode * 53 + b;
      return param1LazyFieldLite1;
    }
    
    public <T> Internal.ProtobufList<T> visitList(Internal.ProtobufList<T> param1ProtobufList1, Internal.ProtobufList<T> param1ProtobufList2) {
      this.hashCode = this.hashCode * 53 + param1ProtobufList1.hashCode();
      return param1ProtobufList1;
    }
    
    public long visitLong(boolean param1Boolean1, long param1Long1, boolean param1Boolean2, long param1Long2) {
      this.hashCode = this.hashCode * 53 + Internal.hashLong(param1Long1);
      return param1Long1;
    }
    
    public Internal.LongList visitLongList(Internal.LongList param1LongList1, Internal.LongList param1LongList2) {
      this.hashCode = this.hashCode * 53 + param1LongList1.hashCode();
      return param1LongList1;
    }
    
    public <K, V> MapFieldLite<K, V> visitMap(MapFieldLite<K, V> param1MapFieldLite1, MapFieldLite<K, V> param1MapFieldLite2) {
      this.hashCode = this.hashCode * 53 + param1MapFieldLite1.hashCode();
      return param1MapFieldLite1;
    }
    
    public <T extends MessageLite> T visitMessage(T param1T1, T param1T2) {
      byte b;
      if (param1T1 != null) {
        if (param1T1 instanceof GeneratedMessageLite) {
          b = ((GeneratedMessageLite)param1T1).hashCode(this);
        } else {
          b = param1T1.hashCode();
        } 
      } else {
        b = 37;
      } 
      this.hashCode = this.hashCode * 53 + b;
      return param1T1;
    }
    
    public Object visitOneofBoolean(boolean param1Boolean, Object param1Object1, Object param1Object2) {
      this.hashCode = this.hashCode * 53 + Internal.hashBoolean(((Boolean)param1Object1).booleanValue());
      return param1Object1;
    }
    
    public Object visitOneofByteString(boolean param1Boolean, Object param1Object1, Object param1Object2) {
      this.hashCode = this.hashCode * 53 + param1Object1.hashCode();
      return param1Object1;
    }
    
    public Object visitOneofDouble(boolean param1Boolean, Object param1Object1, Object param1Object2) {
      this.hashCode = this.hashCode * 53 + Internal.hashLong(Double.doubleToLongBits(((Double)param1Object1).doubleValue()));
      return param1Object1;
    }
    
    public Object visitOneofFloat(boolean param1Boolean, Object param1Object1, Object param1Object2) {
      this.hashCode = this.hashCode * 53 + Float.floatToIntBits(((Float)param1Object1).floatValue());
      return param1Object1;
    }
    
    public Object visitOneofInt(boolean param1Boolean, Object param1Object1, Object param1Object2) {
      this.hashCode = this.hashCode * 53 + ((Integer)param1Object1).intValue();
      return param1Object1;
    }
    
    public Object visitOneofLazyMessage(boolean param1Boolean, Object param1Object1, Object param1Object2) {
      this.hashCode = this.hashCode * 53 + param1Object1.hashCode();
      return param1Object1;
    }
    
    public Object visitOneofLong(boolean param1Boolean, Object param1Object1, Object param1Object2) {
      this.hashCode = this.hashCode * 53 + Internal.hashLong(((Long)param1Object1).longValue());
      return param1Object1;
    }
    
    public Object visitOneofMessage(boolean param1Boolean, Object param1Object1, Object param1Object2) {
      return visitMessage((MessageLite)param1Object1, (MessageLite)param1Object2);
    }
    
    public void visitOneofNotSet(boolean param1Boolean) {
      if (!param1Boolean)
        return; 
      throw new IllegalStateException();
    }
    
    public Object visitOneofString(boolean param1Boolean, Object param1Object1, Object param1Object2) {
      this.hashCode = this.hashCode * 53 + param1Object1.hashCode();
      return param1Object1;
    }
    
    public String visitString(boolean param1Boolean1, String param1String1, boolean param1Boolean2, String param1String2) {
      this.hashCode = this.hashCode * 53 + param1String1.hashCode();
      return param1String1;
    }
    
    public UnknownFieldSetLite visitUnknownFields(UnknownFieldSetLite param1UnknownFieldSetLite1, UnknownFieldSetLite param1UnknownFieldSetLite2) {
      this.hashCode = this.hashCode * 53 + param1UnknownFieldSetLite1.hashCode();
      return param1UnknownFieldSetLite1;
    }
  }
  
  protected static class MergeFromVisitor implements Visitor {
    public static final MergeFromVisitor INSTANCE = new MergeFromVisitor();
    
    public boolean visitBoolean(boolean param1Boolean1, boolean param1Boolean2, boolean param1Boolean3, boolean param1Boolean4) {
      if (param1Boolean3)
        param1Boolean2 = param1Boolean4; 
      return param1Boolean2;
    }
    
    public Internal.BooleanList visitBooleanList(Internal.BooleanList param1BooleanList1, Internal.BooleanList param1BooleanList2) {
      int i = param1BooleanList1.size();
      int j = param1BooleanList2.size();
      Internal.BooleanList booleanList = param1BooleanList1;
      if (i > 0) {
        booleanList = param1BooleanList1;
        if (j > 0) {
          booleanList = param1BooleanList1;
          if (!param1BooleanList1.isModifiable())
            booleanList = param1BooleanList1.mutableCopyWithCapacity(j + i); 
          booleanList.addAll(param1BooleanList2);
        } 
      } 
      if (i > 0)
        param1BooleanList2 = booleanList; 
      return param1BooleanList2;
    }
    
    public ByteString visitByteString(boolean param1Boolean1, ByteString param1ByteString1, boolean param1Boolean2, ByteString param1ByteString2) {
      if (param1Boolean2)
        param1ByteString1 = param1ByteString2; 
      return param1ByteString1;
    }
    
    public double visitDouble(boolean param1Boolean1, double param1Double1, boolean param1Boolean2, double param1Double2) {
      if (param1Boolean2)
        param1Double1 = param1Double2; 
      return param1Double1;
    }
    
    public Internal.DoubleList visitDoubleList(Internal.DoubleList param1DoubleList1, Internal.DoubleList param1DoubleList2) {
      int i = param1DoubleList1.size();
      int j = param1DoubleList2.size();
      Internal.DoubleList doubleList = param1DoubleList1;
      if (i > 0) {
        doubleList = param1DoubleList1;
        if (j > 0) {
          doubleList = param1DoubleList1;
          if (!param1DoubleList1.isModifiable())
            doubleList = param1DoubleList1.mutableCopyWithCapacity(j + i); 
          doubleList.addAll(param1DoubleList2);
        } 
      } 
      if (i > 0)
        param1DoubleList2 = doubleList; 
      return param1DoubleList2;
    }
    
    public FieldSet<GeneratedMessageLite.ExtensionDescriptor> visitExtensions(FieldSet<GeneratedMessageLite.ExtensionDescriptor> param1FieldSet1, FieldSet<GeneratedMessageLite.ExtensionDescriptor> param1FieldSet2) {
      FieldSet<GeneratedMessageLite.ExtensionDescriptor> fieldSet = param1FieldSet1;
      if (param1FieldSet1.isImmutable())
        fieldSet = param1FieldSet1.clone(); 
      fieldSet.mergeFrom(param1FieldSet2);
      return fieldSet;
    }
    
    public float visitFloat(boolean param1Boolean1, float param1Float1, boolean param1Boolean2, float param1Float2) {
      if (param1Boolean2)
        param1Float1 = param1Float2; 
      return param1Float1;
    }
    
    public Internal.FloatList visitFloatList(Internal.FloatList param1FloatList1, Internal.FloatList param1FloatList2) {
      int i = param1FloatList1.size();
      int j = param1FloatList2.size();
      Internal.FloatList floatList = param1FloatList1;
      if (i > 0) {
        floatList = param1FloatList1;
        if (j > 0) {
          floatList = param1FloatList1;
          if (!param1FloatList1.isModifiable())
            floatList = param1FloatList1.mutableCopyWithCapacity(j + i); 
          floatList.addAll(param1FloatList2);
        } 
      } 
      if (i <= 0)
        floatList = param1FloatList2; 
      return floatList;
    }
    
    public int visitInt(boolean param1Boolean1, int param1Int1, boolean param1Boolean2, int param1Int2) {
      if (param1Boolean2)
        param1Int1 = param1Int2; 
      return param1Int1;
    }
    
    public Internal.IntList visitIntList(Internal.IntList param1IntList1, Internal.IntList param1IntList2) {
      int i = param1IntList1.size();
      int j = param1IntList2.size();
      Internal.IntList intList = param1IntList1;
      if (i > 0) {
        intList = param1IntList1;
        if (j > 0) {
          intList = param1IntList1;
          if (!param1IntList1.isModifiable())
            intList = param1IntList1.mutableCopyWithCapacity(j + i); 
          intList.addAll(param1IntList2);
        } 
      } 
      if (i <= 0)
        intList = param1IntList2; 
      return intList;
    }
    
    public LazyFieldLite visitLazyMessage(LazyFieldLite param1LazyFieldLite1, LazyFieldLite param1LazyFieldLite2) {
      LazyFieldLite lazyFieldLite = param1LazyFieldLite1;
      if (param1LazyFieldLite2 != null) {
        lazyFieldLite = param1LazyFieldLite1;
        if (param1LazyFieldLite1 == null)
          lazyFieldLite = new LazyFieldLite(); 
        lazyFieldLite.merge(param1LazyFieldLite2);
      } 
      return lazyFieldLite;
    }
    
    public <T> Internal.ProtobufList<T> visitList(Internal.ProtobufList<T> param1ProtobufList1, Internal.ProtobufList<T> param1ProtobufList2) {
      int i = param1ProtobufList1.size();
      int j = param1ProtobufList2.size();
      Internal.ProtobufList<T> protobufList = param1ProtobufList1;
      if (i > 0) {
        protobufList = param1ProtobufList1;
        if (j > 0) {
          protobufList = param1ProtobufList1;
          if (!param1ProtobufList1.isModifiable())
            protobufList = param1ProtobufList1.mutableCopyWithCapacity(j + i); 
          protobufList.addAll(param1ProtobufList2);
        } 
      } 
      if (i > 0)
        param1ProtobufList2 = protobufList; 
      return param1ProtobufList2;
    }
    
    public long visitLong(boolean param1Boolean1, long param1Long1, boolean param1Boolean2, long param1Long2) {
      if (param1Boolean2)
        param1Long1 = param1Long2; 
      return param1Long1;
    }
    
    public Internal.LongList visitLongList(Internal.LongList param1LongList1, Internal.LongList param1LongList2) {
      int i = param1LongList1.size();
      int j = param1LongList2.size();
      Internal.LongList longList = param1LongList1;
      if (i > 0) {
        longList = param1LongList1;
        if (j > 0) {
          longList = param1LongList1;
          if (!param1LongList1.isModifiable())
            longList = param1LongList1.mutableCopyWithCapacity(j + i); 
          longList.addAll(param1LongList2);
        } 
      } 
      if (i > 0)
        param1LongList2 = longList; 
      return param1LongList2;
    }
    
    public <K, V> MapFieldLite<K, V> visitMap(MapFieldLite<K, V> param1MapFieldLite1, MapFieldLite<K, V> param1MapFieldLite2) {
      MapFieldLite<K, V> mapFieldLite = param1MapFieldLite1;
      if (!param1MapFieldLite2.isEmpty()) {
        mapFieldLite = param1MapFieldLite1;
        if (!param1MapFieldLite1.isMutable())
          mapFieldLite = param1MapFieldLite1.mutableCopy(); 
        mapFieldLite.mergeFrom(param1MapFieldLite2);
      } 
      return mapFieldLite;
    }
    
    public <T extends MessageLite> T visitMessage(T param1T1, T param1T2) {
      if (param1T1 != null && param1T2 != null)
        return (T)param1T1.toBuilder().mergeFrom((MessageLite)param1T2).build(); 
      if (param1T1 == null)
        param1T1 = param1T2; 
      return param1T1;
    }
    
    public Object visitOneofBoolean(boolean param1Boolean, Object param1Object1, Object param1Object2) {
      return param1Object2;
    }
    
    public Object visitOneofByteString(boolean param1Boolean, Object param1Object1, Object param1Object2) {
      return param1Object2;
    }
    
    public Object visitOneofDouble(boolean param1Boolean, Object param1Object1, Object param1Object2) {
      return param1Object2;
    }
    
    public Object visitOneofFloat(boolean param1Boolean, Object param1Object1, Object param1Object2) {
      return param1Object2;
    }
    
    public Object visitOneofInt(boolean param1Boolean, Object param1Object1, Object param1Object2) {
      return param1Object2;
    }
    
    public Object visitOneofLazyMessage(boolean param1Boolean, Object param1Object1, Object param1Object2) {
      if (param1Boolean) {
        param1Object1 = param1Object1;
      } else {
        param1Object1 = new LazyFieldLite();
      } 
      param1Object1.merge((LazyFieldLite)param1Object2);
      return param1Object1;
    }
    
    public Object visitOneofLong(boolean param1Boolean, Object param1Object1, Object param1Object2) {
      return param1Object2;
    }
    
    public Object visitOneofMessage(boolean param1Boolean, Object param1Object1, Object param1Object2) {
      return param1Boolean ? visitMessage((MessageLite)param1Object1, (MessageLite)param1Object2) : param1Object2;
    }
    
    public void visitOneofNotSet(boolean param1Boolean) {}
    
    public Object visitOneofString(boolean param1Boolean, Object param1Object1, Object param1Object2) {
      return param1Object2;
    }
    
    public String visitString(boolean param1Boolean1, String param1String1, boolean param1Boolean2, String param1String2) {
      if (param1Boolean2)
        param1String1 = param1String2; 
      return param1String1;
    }
    
    public UnknownFieldSetLite visitUnknownFields(UnknownFieldSetLite param1UnknownFieldSetLite1, UnknownFieldSetLite param1UnknownFieldSetLite2) {
      if (param1UnknownFieldSetLite2 != UnknownFieldSetLite.getDefaultInstance())
        param1UnknownFieldSetLite1 = UnknownFieldSetLite.mutableCopyOf(param1UnknownFieldSetLite1, param1UnknownFieldSetLite2); 
      return param1UnknownFieldSetLite1;
    }
  }
  
  public enum MethodToInvoke {
    GET_DEFAULT_INSTANCE, GET_PARSER, IS_INITIALIZED, MAKE_IMMUTABLE, MERGE_FROM_STREAM, NEW_BUILDER, NEW_MUTABLE_INSTANCE, VISIT;
    
    static {
      MAKE_IMMUTABLE = new MethodToInvoke("MAKE_IMMUTABLE", 3);
      NEW_MUTABLE_INSTANCE = new MethodToInvoke("NEW_MUTABLE_INSTANCE", 4);
      NEW_BUILDER = new MethodToInvoke("NEW_BUILDER", 5);
      GET_DEFAULT_INSTANCE = new MethodToInvoke("GET_DEFAULT_INSTANCE", 6);
      GET_PARSER = new MethodToInvoke("GET_PARSER", 7);
      $VALUES = new MethodToInvoke[] { IS_INITIALIZED, VISIT, MERGE_FROM_STREAM, MAKE_IMMUTABLE, NEW_MUTABLE_INSTANCE, NEW_BUILDER, GET_DEFAULT_INSTANCE, GET_PARSER };
    }
  }
  
  protected static final class SerializedForm implements Serializable {
    private static final long serialVersionUID = 0L;
    
    private final byte[] asBytes;
    
    private final String messageClassName;
    
    SerializedForm(MessageLite param1MessageLite) {
      this.messageClassName = param1MessageLite.getClass().getName();
      this.asBytes = param1MessageLite.toByteArray();
    }
    
    public static SerializedForm of(MessageLite param1MessageLite) {
      return new SerializedForm(param1MessageLite);
    }
    
    @Deprecated
    private Object readResolveFallback() throws ObjectStreamException {
      try {
        Field field = Class.forName(this.messageClassName).getDeclaredField("defaultInstance");
        field.setAccessible(true);
        return ((MessageLite)field.get((Object)null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
      } catch (ClassNotFoundException classNotFoundException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to find proto buffer class: ");
        stringBuilder.append(this.messageClassName);
        throw new RuntimeException(stringBuilder.toString(), classNotFoundException);
      } catch (NoSuchFieldException noSuchFieldException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to find defaultInstance in ");
        stringBuilder.append(this.messageClassName);
        throw new RuntimeException(stringBuilder.toString(), noSuchFieldException);
      } catch (SecurityException securityException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to call defaultInstance in ");
        stringBuilder.append(this.messageClassName);
        throw new RuntimeException(stringBuilder.toString(), securityException);
      } catch (IllegalAccessException illegalAccessException) {
        throw new RuntimeException("Unable to call parsePartialFrom", illegalAccessException);
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw new RuntimeException("Unable to understand proto buffer", invalidProtocolBufferException);
      } 
    }
    
    protected Object readResolve() throws ObjectStreamException {
      try {
        Field field = Class.forName(this.messageClassName).getDeclaredField("DEFAULT_INSTANCE");
        field.setAccessible(true);
        return ((MessageLite)field.get((Object)null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
      } catch (ClassNotFoundException classNotFoundException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to find proto buffer class: ");
        stringBuilder.append(this.messageClassName);
        throw new RuntimeException(stringBuilder.toString(), classNotFoundException);
      } catch (NoSuchFieldException noSuchFieldException) {
        return readResolveFallback();
      } catch (SecurityException securityException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to call DEFAULT_INSTANCE in ");
        stringBuilder.append(this.messageClassName);
        throw new RuntimeException(stringBuilder.toString(), securityException);
      } catch (IllegalAccessException illegalAccessException) {
        throw new RuntimeException("Unable to call parsePartialFrom", illegalAccessException);
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw new RuntimeException("Unable to understand proto buffer", invalidProtocolBufferException);
      } 
    }
  }
  
  protected static interface Visitor {
    boolean visitBoolean(boolean param1Boolean1, boolean param1Boolean2, boolean param1Boolean3, boolean param1Boolean4);
    
    Internal.BooleanList visitBooleanList(Internal.BooleanList param1BooleanList1, Internal.BooleanList param1BooleanList2);
    
    ByteString visitByteString(boolean param1Boolean1, ByteString param1ByteString1, boolean param1Boolean2, ByteString param1ByteString2);
    
    double visitDouble(boolean param1Boolean1, double param1Double1, boolean param1Boolean2, double param1Double2);
    
    Internal.DoubleList visitDoubleList(Internal.DoubleList param1DoubleList1, Internal.DoubleList param1DoubleList2);
    
    FieldSet<GeneratedMessageLite.ExtensionDescriptor> visitExtensions(FieldSet<GeneratedMessageLite.ExtensionDescriptor> param1FieldSet1, FieldSet<GeneratedMessageLite.ExtensionDescriptor> param1FieldSet2);
    
    float visitFloat(boolean param1Boolean1, float param1Float1, boolean param1Boolean2, float param1Float2);
    
    Internal.FloatList visitFloatList(Internal.FloatList param1FloatList1, Internal.FloatList param1FloatList2);
    
    int visitInt(boolean param1Boolean1, int param1Int1, boolean param1Boolean2, int param1Int2);
    
    Internal.IntList visitIntList(Internal.IntList param1IntList1, Internal.IntList param1IntList2);
    
    LazyFieldLite visitLazyMessage(LazyFieldLite param1LazyFieldLite1, LazyFieldLite param1LazyFieldLite2);
    
    <T> Internal.ProtobufList<T> visitList(Internal.ProtobufList<T> param1ProtobufList1, Internal.ProtobufList<T> param1ProtobufList2);
    
    long visitLong(boolean param1Boolean1, long param1Long1, boolean param1Boolean2, long param1Long2);
    
    Internal.LongList visitLongList(Internal.LongList param1LongList1, Internal.LongList param1LongList2);
    
    <K, V> MapFieldLite<K, V> visitMap(MapFieldLite<K, V> param1MapFieldLite1, MapFieldLite<K, V> param1MapFieldLite2);
    
    <T extends MessageLite> T visitMessage(T param1T1, T param1T2);
    
    Object visitOneofBoolean(boolean param1Boolean, Object param1Object1, Object param1Object2);
    
    Object visitOneofByteString(boolean param1Boolean, Object param1Object1, Object param1Object2);
    
    Object visitOneofDouble(boolean param1Boolean, Object param1Object1, Object param1Object2);
    
    Object visitOneofFloat(boolean param1Boolean, Object param1Object1, Object param1Object2);
    
    Object visitOneofInt(boolean param1Boolean, Object param1Object1, Object param1Object2);
    
    Object visitOneofLazyMessage(boolean param1Boolean, Object param1Object1, Object param1Object2);
    
    Object visitOneofLong(boolean param1Boolean, Object param1Object1, Object param1Object2);
    
    Object visitOneofMessage(boolean param1Boolean, Object param1Object1, Object param1Object2);
    
    void visitOneofNotSet(boolean param1Boolean);
    
    Object visitOneofString(boolean param1Boolean, Object param1Object1, Object param1Object2);
    
    String visitString(boolean param1Boolean1, String param1String1, boolean param1Boolean2, String param1String2);
    
    UnknownFieldSetLite visitUnknownFields(UnknownFieldSetLite param1UnknownFieldSetLite1, UnknownFieldSetLite param1UnknownFieldSetLite2);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\GeneratedMessageLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */