package com.google.api;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class SourceInfo extends GeneratedMessageLite<SourceInfo, SourceInfo.Builder> implements SourceInfoOrBuilder {
  private static final SourceInfo DEFAULT_INSTANCE = new SourceInfo();
  
  private static volatile Parser<SourceInfo> PARSER;
  
  public static final int SOURCE_FILES_FIELD_NUMBER = 1;
  
  private Internal.ProtobufList<Any> sourceFiles_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllSourceFiles(Iterable<? extends Any> paramIterable) {
    ensureSourceFilesIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.sourceFiles_);
  }
  
  private void addSourceFiles(int paramInt, Any.Builder paramBuilder) {
    ensureSourceFilesIsMutable();
    this.sourceFiles_.add(paramInt, paramBuilder.build());
  }
  
  private void addSourceFiles(int paramInt, Any paramAny) {
    if (paramAny != null) {
      ensureSourceFilesIsMutable();
      this.sourceFiles_.add(paramInt, paramAny);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addSourceFiles(Any.Builder paramBuilder) {
    ensureSourceFilesIsMutable();
    this.sourceFiles_.add(paramBuilder.build());
  }
  
  private void addSourceFiles(Any paramAny) {
    if (paramAny != null) {
      ensureSourceFilesIsMutable();
      this.sourceFiles_.add(paramAny);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearSourceFiles() {
    this.sourceFiles_ = emptyProtobufList();
  }
  
  private void ensureSourceFilesIsMutable() {
    if (!this.sourceFiles_.isModifiable())
      this.sourceFiles_ = GeneratedMessageLite.mutableCopy(this.sourceFiles_); 
  }
  
  public static SourceInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(SourceInfo paramSourceInfo) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramSourceInfo);
  }
  
  public static SourceInfo parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (SourceInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static SourceInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (SourceInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static SourceInfo parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (SourceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static SourceInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (SourceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static SourceInfo parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (SourceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static SourceInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (SourceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static SourceInfo parseFrom(InputStream paramInputStream) throws IOException {
    return (SourceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static SourceInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (SourceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static SourceInfo parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (SourceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static SourceInfo parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (SourceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<SourceInfo> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeSourceFiles(int paramInt) {
    ensureSourceFilesIsMutable();
    this.sourceFiles_.remove(paramInt);
  }
  
  private void setSourceFiles(int paramInt, Any.Builder paramBuilder) {
    ensureSourceFilesIsMutable();
    this.sourceFiles_.set(paramInt, paramBuilder.build());
  }
  
  private void setSourceFiles(int paramInt, Any paramAny) {
    if (paramAny != null) {
      ensureSourceFilesIsMutable();
      this.sourceFiles_.set(paramInt, paramAny);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/SourceInfo$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 326, 2 -> 322, 3 -> 311, 4 -> 302, 5 -> 268, 6 -> 110, 7 -> 264, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/api/SourceInfo.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/api/SourceInfo
    //   72: monitorenter
    //   73: getstatic com/google/api/SourceInfo.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/api/SourceInfo.DEFAULT_INSTANCE : Lcom/google/api/SourceInfo;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/api/SourceInfo.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/api/SourceInfo
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/api/SourceInfo
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/api/SourceInfo.PARSER : Lcom/google/protobuf/Parser;
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
    //   162: getfield sourceFiles_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   165: invokeinterface isModifiable : ()Z
    //   170: ifne -> 184
    //   173: aload_0
    //   174: aload_0
    //   175: getfield sourceFiles_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   178: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   181: putfield sourceFiles_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   184: aload_0
    //   185: getfield sourceFiles_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   188: aload_1
    //   189: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   192: aload_2
    //   193: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   196: checkcast com/google/protobuf/Any
    //   199: invokeinterface add : (Ljava/lang/Object;)Z
    //   204: pop
    //   205: goto -> 123
    //   208: iconst_1
    //   209: istore #4
    //   211: goto -> 123
    //   214: astore_1
    //   215: goto -> 262
    //   218: astore_2
    //   219: new java/lang/RuntimeException
    //   222: astore_1
    //   223: new com/google/protobuf/InvalidProtocolBufferException
    //   226: astore_3
    //   227: aload_3
    //   228: aload_2
    //   229: invokevirtual getMessage : ()Ljava/lang/String;
    //   232: invokespecial <init> : (Ljava/lang/String;)V
    //   235: aload_1
    //   236: aload_3
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
    //   264: getstatic com/google/api/SourceInfo.DEFAULT_INSTANCE : Lcom/google/api/SourceInfo;
    //   267: areturn
    //   268: aload_2
    //   269: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   272: astore_1
    //   273: aload_3
    //   274: checkcast com/google/api/SourceInfo
    //   277: astore_2
    //   278: aload_0
    //   279: aload_1
    //   280: aload_0
    //   281: getfield sourceFiles_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   284: aload_2
    //   285: getfield sourceFiles_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   288: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   293: putfield sourceFiles_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   296: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   299: astore_1
    //   300: aload_0
    //   301: areturn
    //   302: new com/google/api/SourceInfo$Builder
    //   305: dup
    //   306: aconst_null
    //   307: invokespecial <init> : (Lcom/google/api/SourceInfo$1;)V
    //   310: areturn
    //   311: aload_0
    //   312: getfield sourceFiles_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   315: invokeinterface makeImmutable : ()V
    //   320: aconst_null
    //   321: areturn
    //   322: getstatic com/google/api/SourceInfo.DEFAULT_INSTANCE : Lcom/google/api/SourceInfo;
    //   325: areturn
    //   326: new com/google/api/SourceInfo
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
    i = 0;
    int j = 0;
    while (i < this.sourceFiles_.size()) {
      j += CodedOutputStream.computeMessageSize(1, (MessageLite)this.sourceFiles_.get(i));
      i++;
    } 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public Any getSourceFiles(int paramInt) {
    return (Any)this.sourceFiles_.get(paramInt);
  }
  
  public int getSourceFilesCount() {
    return this.sourceFiles_.size();
  }
  
  public List<Any> getSourceFilesList() {
    return (List<Any>)this.sourceFiles_;
  }
  
  public AnyOrBuilder getSourceFilesOrBuilder(int paramInt) {
    return (AnyOrBuilder)this.sourceFiles_.get(paramInt);
  }
  
  public List<? extends AnyOrBuilder> getSourceFilesOrBuilderList() {
    return (List)this.sourceFiles_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (byte b = 0; b < this.sourceFiles_.size(); b++)
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.sourceFiles_.get(b)); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<SourceInfo, Builder> implements SourceInfoOrBuilder {
    private Builder() {
      super(SourceInfo.DEFAULT_INSTANCE);
    }
    
    public Builder addAllSourceFiles(Iterable<? extends Any> param1Iterable) {
      copyOnWrite();
      ((SourceInfo)this.instance).addAllSourceFiles(param1Iterable);
      return this;
    }
    
    public Builder addSourceFiles(int param1Int, Any.Builder param1Builder) {
      copyOnWrite();
      ((SourceInfo)this.instance).addSourceFiles(param1Int, param1Builder);
      return this;
    }
    
    public Builder addSourceFiles(int param1Int, Any param1Any) {
      copyOnWrite();
      ((SourceInfo)this.instance).addSourceFiles(param1Int, param1Any);
      return this;
    }
    
    public Builder addSourceFiles(Any.Builder param1Builder) {
      copyOnWrite();
      ((SourceInfo)this.instance).addSourceFiles(param1Builder);
      return this;
    }
    
    public Builder addSourceFiles(Any param1Any) {
      copyOnWrite();
      ((SourceInfo)this.instance).addSourceFiles(param1Any);
      return this;
    }
    
    public Builder clearSourceFiles() {
      copyOnWrite();
      ((SourceInfo)this.instance).clearSourceFiles();
      return this;
    }
    
    public Any getSourceFiles(int param1Int) {
      return ((SourceInfo)this.instance).getSourceFiles(param1Int);
    }
    
    public int getSourceFilesCount() {
      return ((SourceInfo)this.instance).getSourceFilesCount();
    }
    
    public List<Any> getSourceFilesList() {
      return Collections.unmodifiableList(((SourceInfo)this.instance).getSourceFilesList());
    }
    
    public Builder removeSourceFiles(int param1Int) {
      copyOnWrite();
      ((SourceInfo)this.instance).removeSourceFiles(param1Int);
      return this;
    }
    
    public Builder setSourceFiles(int param1Int, Any.Builder param1Builder) {
      copyOnWrite();
      ((SourceInfo)this.instance).setSourceFiles(param1Int, param1Builder);
      return this;
    }
    
    public Builder setSourceFiles(int param1Int, Any param1Any) {
      copyOnWrite();
      ((SourceInfo)this.instance).setSourceFiles(param1Int, param1Any);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\SourceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */