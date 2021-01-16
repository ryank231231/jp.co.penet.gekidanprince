package com.google.protobuf;

import java.io.IOException;

public class LazyFieldLite {
  private static final ExtensionRegistryLite EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();
  
  private ByteString delayedBytes;
  
  private ExtensionRegistryLite extensionRegistry;
  
  private volatile ByteString memoizedBytes;
  
  protected volatile MessageLite value;
  
  public LazyFieldLite() {}
  
  public LazyFieldLite(ExtensionRegistryLite paramExtensionRegistryLite, ByteString paramByteString) {
    checkArguments(paramExtensionRegistryLite, paramByteString);
    this.extensionRegistry = paramExtensionRegistryLite;
    this.delayedBytes = paramByteString;
  }
  
  private static void checkArguments(ExtensionRegistryLite paramExtensionRegistryLite, ByteString paramByteString) {
    if (paramExtensionRegistryLite != null) {
      if (paramByteString != null)
        return; 
      throw new NullPointerException("found null ByteString");
    } 
    throw new NullPointerException("found null ExtensionRegistry");
  }
  
  public static LazyFieldLite fromValue(MessageLite paramMessageLite) {
    LazyFieldLite lazyFieldLite = new LazyFieldLite();
    lazyFieldLite.setValue(paramMessageLite);
    return lazyFieldLite;
  }
  
  private static MessageLite mergeValueAndBytes(MessageLite paramMessageLite, ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) {
    try {
      return paramMessageLite.toBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite).build();
    } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
      return paramMessageLite;
    } 
  }
  
  public void clear() {
    this.delayedBytes = null;
    this.value = null;
    this.memoizedBytes = null;
  }
  
  public boolean containsDefaultInstance() {
    if (this.memoizedBytes != ByteString.EMPTY) {
      if (this.value == null) {
        ByteString byteString = this.delayedBytes;
        if (byteString == null || byteString == ByteString.EMPTY)
          return true; 
      } 
      return false;
    } 
    return true;
  }
  
  protected void ensureInitialized(MessageLite paramMessageLite) {
    // Byte code:
    //   0: aload_0
    //   1: getfield value : Lcom/google/protobuf/MessageLite;
    //   4: ifnull -> 8
    //   7: return
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield value : Lcom/google/protobuf/MessageLite;
    //   14: ifnull -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: getfield delayedBytes : Lcom/google/protobuf/ByteString;
    //   24: ifnull -> 64
    //   27: aload_0
    //   28: aload_1
    //   29: invokeinterface getParserForType : ()Lcom/google/protobuf/Parser;
    //   34: aload_0
    //   35: getfield delayedBytes : Lcom/google/protobuf/ByteString;
    //   38: aload_0
    //   39: getfield extensionRegistry : Lcom/google/protobuf/ExtensionRegistryLite;
    //   42: invokeinterface parseFrom : (Lcom/google/protobuf/ByteString;Lcom/google/protobuf/ExtensionRegistryLite;)Ljava/lang/Object;
    //   47: checkcast com/google/protobuf/MessageLite
    //   50: putfield value : Lcom/google/protobuf/MessageLite;
    //   53: aload_0
    //   54: aload_0
    //   55: getfield delayedBytes : Lcom/google/protobuf/ByteString;
    //   58: putfield memoizedBytes : Lcom/google/protobuf/ByteString;
    //   61: goto -> 92
    //   64: aload_0
    //   65: aload_1
    //   66: putfield value : Lcom/google/protobuf/MessageLite;
    //   69: aload_0
    //   70: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   73: putfield memoizedBytes : Lcom/google/protobuf/ByteString;
    //   76: goto -> 92
    //   79: astore_2
    //   80: aload_0
    //   81: aload_1
    //   82: putfield value : Lcom/google/protobuf/MessageLite;
    //   85: aload_0
    //   86: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   89: putfield memoizedBytes : Lcom/google/protobuf/ByteString;
    //   92: aload_0
    //   93: monitorexit
    //   94: return
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Exception table:
    //   from	to	target	type
    //   10	19	95	finally
    //   20	61	79	com/google/protobuf/InvalidProtocolBufferException
    //   20	61	95	finally
    //   64	76	79	com/google/protobuf/InvalidProtocolBufferException
    //   64	76	95	finally
    //   80	92	95	finally
    //   92	94	95	finally
    //   96	98	95	finally
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof LazyFieldLite))
      return false; 
    LazyFieldLite lazyFieldLite = (LazyFieldLite)paramObject;
    MessageLite messageLite = this.value;
    paramObject = lazyFieldLite.value;
    return (messageLite == null && paramObject == null) ? toByteString().equals(lazyFieldLite.toByteString()) : ((messageLite != null && paramObject != null) ? messageLite.equals(paramObject) : ((messageLite != null) ? messageLite.equals(lazyFieldLite.getValue(messageLite.getDefaultInstanceForType())) : getValue(paramObject.getDefaultInstanceForType()).equals(paramObject)));
  }
  
  public int getSerializedSize() {
    if (this.memoizedBytes != null)
      return this.memoizedBytes.size(); 
    ByteString byteString = this.delayedBytes;
    return (byteString != null) ? byteString.size() : ((this.value != null) ? this.value.getSerializedSize() : 0);
  }
  
  public MessageLite getValue(MessageLite paramMessageLite) {
    ensureInitialized(paramMessageLite);
    return this.value;
  }
  
  public int hashCode() {
    return 1;
  }
  
  public void merge(LazyFieldLite paramLazyFieldLite) {
    if (paramLazyFieldLite.containsDefaultInstance())
      return; 
    if (containsDefaultInstance()) {
      set(paramLazyFieldLite);
      return;
    } 
    if (this.extensionRegistry == null)
      this.extensionRegistry = paramLazyFieldLite.extensionRegistry; 
    ByteString byteString = this.delayedBytes;
    if (byteString != null) {
      ByteString byteString1 = paramLazyFieldLite.delayedBytes;
      if (byteString1 != null) {
        this.delayedBytes = byteString.concat(byteString1);
        return;
      } 
    } 
    if (this.value == null && paramLazyFieldLite.value != null) {
      setValue(mergeValueAndBytes(paramLazyFieldLite.value, this.delayedBytes, this.extensionRegistry));
      return;
    } 
    if (this.value != null && paramLazyFieldLite.value == null) {
      setValue(mergeValueAndBytes(this.value, paramLazyFieldLite.delayedBytes, paramLazyFieldLite.extensionRegistry));
      return;
    } 
    if (paramLazyFieldLite.extensionRegistry != null) {
      setValue(mergeValueAndBytes(this.value, paramLazyFieldLite.toByteString(), paramLazyFieldLite.extensionRegistry));
      return;
    } 
    if (this.extensionRegistry != null) {
      setValue(mergeValueAndBytes(paramLazyFieldLite.value, toByteString(), this.extensionRegistry));
      return;
    } 
    setValue(mergeValueAndBytes(this.value, paramLazyFieldLite.toByteString(), EMPTY_REGISTRY));
  }
  
  public void mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    if (containsDefaultInstance()) {
      setByteString(paramCodedInputStream.readBytes(), paramExtensionRegistryLite);
      return;
    } 
    if (this.extensionRegistry == null)
      this.extensionRegistry = paramExtensionRegistryLite; 
    ByteString byteString = this.delayedBytes;
    if (byteString != null) {
      setByteString(byteString.concat(paramCodedInputStream.readBytes()), this.extensionRegistry);
      return;
    } 
    try {
      setValue(this.value.toBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).build());
    } catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
  }
  
  public void set(LazyFieldLite paramLazyFieldLite) {
    this.delayedBytes = paramLazyFieldLite.delayedBytes;
    this.value = paramLazyFieldLite.value;
    this.memoizedBytes = paramLazyFieldLite.memoizedBytes;
    ExtensionRegistryLite extensionRegistryLite = paramLazyFieldLite.extensionRegistry;
    if (extensionRegistryLite != null)
      this.extensionRegistry = extensionRegistryLite; 
  }
  
  public void setByteString(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) {
    checkArguments(paramExtensionRegistryLite, paramByteString);
    this.delayedBytes = paramByteString;
    this.extensionRegistry = paramExtensionRegistryLite;
    this.value = null;
    this.memoizedBytes = null;
  }
  
  public MessageLite setValue(MessageLite paramMessageLite) {
    MessageLite messageLite = this.value;
    this.delayedBytes = null;
    this.memoizedBytes = null;
    this.value = paramMessageLite;
    return messageLite;
  }
  
  public ByteString toByteString() {
    // Byte code:
    //   0: aload_0
    //   1: getfield memoizedBytes : Lcom/google/protobuf/ByteString;
    //   4: ifnull -> 12
    //   7: aload_0
    //   8: getfield memoizedBytes : Lcom/google/protobuf/ByteString;
    //   11: areturn
    //   12: aload_0
    //   13: getfield delayedBytes : Lcom/google/protobuf/ByteString;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull -> 23
    //   21: aload_1
    //   22: areturn
    //   23: aload_0
    //   24: monitorenter
    //   25: aload_0
    //   26: getfield memoizedBytes : Lcom/google/protobuf/ByteString;
    //   29: ifnull -> 41
    //   32: aload_0
    //   33: getfield memoizedBytes : Lcom/google/protobuf/ByteString;
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: areturn
    //   41: aload_0
    //   42: getfield value : Lcom/google/protobuf/MessageLite;
    //   45: ifnonnull -> 58
    //   48: aload_0
    //   49: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   52: putfield memoizedBytes : Lcom/google/protobuf/ByteString;
    //   55: goto -> 71
    //   58: aload_0
    //   59: aload_0
    //   60: getfield value : Lcom/google/protobuf/MessageLite;
    //   63: invokeinterface toByteString : ()Lcom/google/protobuf/ByteString;
    //   68: putfield memoizedBytes : Lcom/google/protobuf/ByteString;
    //   71: aload_0
    //   72: getfield memoizedBytes : Lcom/google/protobuf/ByteString;
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: areturn
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    // Exception table:
    //   from	to	target	type
    //   25	39	80	finally
    //   41	55	80	finally
    //   58	71	80	finally
    //   71	78	80	finally
    //   81	83	80	finally
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\LazyFieldLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */