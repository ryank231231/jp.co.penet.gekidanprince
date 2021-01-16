package com.google.rpc;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class DebugInfo extends GeneratedMessageLite<DebugInfo, DebugInfo.Builder> implements DebugInfoOrBuilder {
  private static final DebugInfo DEFAULT_INSTANCE = new DebugInfo();
  
  public static final int DETAIL_FIELD_NUMBER = 2;
  
  private static volatile Parser<DebugInfo> PARSER;
  
  public static final int STACK_ENTRIES_FIELD_NUMBER = 1;
  
  private int bitField0_;
  
  private String detail_ = "";
  
  private Internal.ProtobufList<String> stackEntries_ = GeneratedMessageLite.emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllStackEntries(Iterable<String> paramIterable) {
    ensureStackEntriesIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.stackEntries_);
  }
  
  private void addStackEntries(String paramString) {
    if (paramString != null) {
      ensureStackEntriesIsMutable();
      this.stackEntries_.add(paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addStackEntriesBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      ensureStackEntriesIsMutable();
      this.stackEntries_.add(paramByteString.toStringUtf8());
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearDetail() {
    this.detail_ = getDefaultInstance().getDetail();
  }
  
  private void clearStackEntries() {
    this.stackEntries_ = GeneratedMessageLite.emptyProtobufList();
  }
  
  private void ensureStackEntriesIsMutable() {
    if (!this.stackEntries_.isModifiable())
      this.stackEntries_ = GeneratedMessageLite.mutableCopy(this.stackEntries_); 
  }
  
  public static DebugInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(DebugInfo paramDebugInfo) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramDebugInfo);
  }
  
  public static DebugInfo parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (DebugInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static DebugInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DebugInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DebugInfo parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (DebugInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static DebugInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (DebugInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static DebugInfo parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (DebugInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static DebugInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DebugInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static DebugInfo parseFrom(InputStream paramInputStream) throws IOException {
    return (DebugInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static DebugInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DebugInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DebugInfo parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (DebugInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static DebugInfo parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (DebugInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<DebugInfo> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setDetail(String paramString) {
    if (paramString != null) {
      this.detail_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDetailBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.detail_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setStackEntries(int paramInt, String paramString) {
    if (paramString != null) {
      ensureStackEntriesIsMutable();
      this.stackEntries_.set(paramInt, paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/rpc/DebugInfo$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 391, 2 -> 387, 3 -> 376, 4 -> 367, 5 -> 281, 6 -> 110, 7 -> 277, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/rpc/DebugInfo.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/rpc/DebugInfo
    //   72: monitorenter
    //   73: getstatic com/google/rpc/DebugInfo.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/rpc/DebugInfo.DEFAULT_INSTANCE : Lcom/google/rpc/DebugInfo;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/rpc/DebugInfo.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/rpc/DebugInfo
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/rpc/DebugInfo
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/rpc/DebugInfo.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 277
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 221
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 179
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
    //   169: aload_1
    //   170: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   173: putfield detail_ : Ljava/lang/String;
    //   176: goto -> 123
    //   179: aload_1
    //   180: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   183: astore_2
    //   184: aload_0
    //   185: getfield stackEntries_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   188: invokeinterface isModifiable : ()Z
    //   193: ifne -> 207
    //   196: aload_0
    //   197: aload_0
    //   198: getfield stackEntries_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   201: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   204: putfield stackEntries_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   207: aload_0
    //   208: getfield stackEntries_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   211: aload_2
    //   212: invokeinterface add : (Ljava/lang/Object;)Z
    //   217: pop
    //   218: goto -> 123
    //   221: iconst_1
    //   222: istore #4
    //   224: goto -> 123
    //   227: astore_1
    //   228: goto -> 275
    //   231: astore_2
    //   232: new java/lang/RuntimeException
    //   235: astore_1
    //   236: new com/google/protobuf/InvalidProtocolBufferException
    //   239: astore_3
    //   240: aload_3
    //   241: aload_2
    //   242: invokevirtual getMessage : ()Ljava/lang/String;
    //   245: invokespecial <init> : (Ljava/lang/String;)V
    //   248: aload_1
    //   249: aload_3
    //   250: aload_0
    //   251: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   254: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   257: aload_1
    //   258: athrow
    //   259: astore_2
    //   260: new java/lang/RuntimeException
    //   263: astore_1
    //   264: aload_1
    //   265: aload_2
    //   266: aload_0
    //   267: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   270: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   273: aload_1
    //   274: athrow
    //   275: aload_1
    //   276: athrow
    //   277: getstatic com/google/rpc/DebugInfo.DEFAULT_INSTANCE : Lcom/google/rpc/DebugInfo;
    //   280: areturn
    //   281: aload_2
    //   282: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   285: astore_1
    //   286: aload_3
    //   287: checkcast com/google/rpc/DebugInfo
    //   290: astore_2
    //   291: aload_0
    //   292: aload_1
    //   293: aload_0
    //   294: getfield stackEntries_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   297: aload_2
    //   298: getfield stackEntries_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   301: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   306: putfield stackEntries_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   309: aload_0
    //   310: aload_1
    //   311: aload_0
    //   312: getfield detail_ : Ljava/lang/String;
    //   315: invokevirtual isEmpty : ()Z
    //   318: iconst_1
    //   319: ixor
    //   320: aload_0
    //   321: getfield detail_ : Ljava/lang/String;
    //   324: iconst_1
    //   325: aload_2
    //   326: getfield detail_ : Ljava/lang/String;
    //   329: invokevirtual isEmpty : ()Z
    //   332: ixor
    //   333: aload_2
    //   334: getfield detail_ : Ljava/lang/String;
    //   337: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   342: putfield detail_ : Ljava/lang/String;
    //   345: aload_1
    //   346: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   349: if_acmpne -> 365
    //   352: aload_0
    //   353: aload_0
    //   354: getfield bitField0_ : I
    //   357: aload_2
    //   358: getfield bitField0_ : I
    //   361: ior
    //   362: putfield bitField0_ : I
    //   365: aload_0
    //   366: areturn
    //   367: new com/google/rpc/DebugInfo$Builder
    //   370: dup
    //   371: aconst_null
    //   372: invokespecial <init> : (Lcom/google/rpc/DebugInfo$1;)V
    //   375: areturn
    //   376: aload_0
    //   377: getfield stackEntries_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   380: invokeinterface makeImmutable : ()V
    //   385: aconst_null
    //   386: areturn
    //   387: getstatic com/google/rpc/DebugInfo.DEFAULT_INSTANCE : Lcom/google/rpc/DebugInfo;
    //   390: areturn
    //   391: new com/google/rpc/DebugInfo
    //   394: dup
    //   395: invokespecial <init> : ()V
    //   398: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	259	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	231	java/io/IOException
    //   128	134	227	finally
    //   153	162	259	com/google/protobuf/InvalidProtocolBufferException
    //   153	162	231	java/io/IOException
    //   153	162	227	finally
    //   168	176	259	com/google/protobuf/InvalidProtocolBufferException
    //   168	176	231	java/io/IOException
    //   168	176	227	finally
    //   179	207	259	com/google/protobuf/InvalidProtocolBufferException
    //   179	207	231	java/io/IOException
    //   179	207	227	finally
    //   207	218	259	com/google/protobuf/InvalidProtocolBufferException
    //   207	218	231	java/io/IOException
    //   207	218	227	finally
    //   232	259	227	finally
    //   260	275	227	finally
  }
  
  public String getDetail() {
    return this.detail_;
  }
  
  public ByteString getDetailBytes() {
    return ByteString.copyFromUtf8(this.detail_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    i = 0;
    while (j < this.stackEntries_.size()) {
      i += CodedOutputStream.computeStringSizeNoTag((String)this.stackEntries_.get(j));
      j++;
    } 
    j = 0 + i + getStackEntriesList().size() * 1;
    i = j;
    if (!this.detail_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(2, getDetail()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public String getStackEntries(int paramInt) {
    return (String)this.stackEntries_.get(paramInt);
  }
  
  public ByteString getStackEntriesBytes(int paramInt) {
    return ByteString.copyFromUtf8((String)this.stackEntries_.get(paramInt));
  }
  
  public int getStackEntriesCount() {
    return this.stackEntries_.size();
  }
  
  public List<String> getStackEntriesList() {
    return (List<String>)this.stackEntries_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (byte b = 0; b < this.stackEntries_.size(); b++)
      paramCodedOutputStream.writeString(1, (String)this.stackEntries_.get(b)); 
    if (!this.detail_.isEmpty())
      paramCodedOutputStream.writeString(2, getDetail()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<DebugInfo, Builder> implements DebugInfoOrBuilder {
    private Builder() {
      super(DebugInfo.DEFAULT_INSTANCE);
    }
    
    public Builder addAllStackEntries(Iterable<String> param1Iterable) {
      copyOnWrite();
      ((DebugInfo)this.instance).addAllStackEntries(param1Iterable);
      return this;
    }
    
    public Builder addStackEntries(String param1String) {
      copyOnWrite();
      ((DebugInfo)this.instance).addStackEntries(param1String);
      return this;
    }
    
    public Builder addStackEntriesBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((DebugInfo)this.instance).addStackEntriesBytes(param1ByteString);
      return this;
    }
    
    public Builder clearDetail() {
      copyOnWrite();
      ((DebugInfo)this.instance).clearDetail();
      return this;
    }
    
    public Builder clearStackEntries() {
      copyOnWrite();
      ((DebugInfo)this.instance).clearStackEntries();
      return this;
    }
    
    public String getDetail() {
      return ((DebugInfo)this.instance).getDetail();
    }
    
    public ByteString getDetailBytes() {
      return ((DebugInfo)this.instance).getDetailBytes();
    }
    
    public String getStackEntries(int param1Int) {
      return ((DebugInfo)this.instance).getStackEntries(param1Int);
    }
    
    public ByteString getStackEntriesBytes(int param1Int) {
      return ((DebugInfo)this.instance).getStackEntriesBytes(param1Int);
    }
    
    public int getStackEntriesCount() {
      return ((DebugInfo)this.instance).getStackEntriesCount();
    }
    
    public List<String> getStackEntriesList() {
      return Collections.unmodifiableList(((DebugInfo)this.instance).getStackEntriesList());
    }
    
    public Builder setDetail(String param1String) {
      copyOnWrite();
      ((DebugInfo)this.instance).setDetail(param1String);
      return this;
    }
    
    public Builder setDetailBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((DebugInfo)this.instance).setDetailBytes(param1ByteString);
      return this;
    }
    
    public Builder setStackEntries(int param1Int, String param1String) {
      copyOnWrite();
      ((DebugInfo)this.instance).setStackEntries(param1Int, param1String);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\rpc\DebugInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */