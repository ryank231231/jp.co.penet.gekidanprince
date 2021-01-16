package com.google.longrunning;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class DeleteOperationRequest extends GeneratedMessageLite<DeleteOperationRequest, DeleteOperationRequest.Builder> implements DeleteOperationRequestOrBuilder {
  private static final DeleteOperationRequest DEFAULT_INSTANCE = new DeleteOperationRequest();
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  private static volatile Parser<DeleteOperationRequest> PARSER;
  
  private String name_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  public static DeleteOperationRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(DeleteOperationRequest paramDeleteOperationRequest) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramDeleteOperationRequest);
  }
  
  public static DeleteOperationRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (DeleteOperationRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static DeleteOperationRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DeleteOperationRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DeleteOperationRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (DeleteOperationRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static DeleteOperationRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (DeleteOperationRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static DeleteOperationRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (DeleteOperationRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static DeleteOperationRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DeleteOperationRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static DeleteOperationRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (DeleteOperationRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static DeleteOperationRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DeleteOperationRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DeleteOperationRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (DeleteOperationRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static DeleteOperationRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (DeleteOperationRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<DeleteOperationRequest> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setName(String paramString) {
    if (paramString != null) {
      this.name_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setNameBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.name_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/longrunning/DeleteOperationRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 299, 2 -> 295, 3 -> 293, 4 -> 284, 5 -> 232, 6 -> 110, 7 -> 228, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/longrunning/DeleteOperationRequest.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/longrunning/DeleteOperationRequest
    //   72: monitorenter
    //   73: getstatic com/google/longrunning/DeleteOperationRequest.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/longrunning/DeleteOperationRequest.DEFAULT_INSTANCE : Lcom/google/longrunning/DeleteOperationRequest;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/longrunning/DeleteOperationRequest.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/longrunning/DeleteOperationRequest
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/longrunning/DeleteOperationRequest
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/longrunning/DeleteOperationRequest.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 228
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 172
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
    //   162: aload_1
    //   163: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   166: putfield name_ : Ljava/lang/String;
    //   169: goto -> 123
    //   172: iconst_1
    //   173: istore #4
    //   175: goto -> 123
    //   178: astore_1
    //   179: goto -> 226
    //   182: astore_2
    //   183: new java/lang/RuntimeException
    //   186: astore_3
    //   187: new com/google/protobuf/InvalidProtocolBufferException
    //   190: astore_1
    //   191: aload_1
    //   192: aload_2
    //   193: invokevirtual getMessage : ()Ljava/lang/String;
    //   196: invokespecial <init> : (Ljava/lang/String;)V
    //   199: aload_3
    //   200: aload_1
    //   201: aload_0
    //   202: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   205: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   208: aload_3
    //   209: athrow
    //   210: astore_1
    //   211: new java/lang/RuntimeException
    //   214: astore_2
    //   215: aload_2
    //   216: aload_1
    //   217: aload_0
    //   218: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   221: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   224: aload_2
    //   225: athrow
    //   226: aload_1
    //   227: athrow
    //   228: getstatic com/google/longrunning/DeleteOperationRequest.DEFAULT_INSTANCE : Lcom/google/longrunning/DeleteOperationRequest;
    //   231: areturn
    //   232: aload_2
    //   233: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   236: astore_1
    //   237: aload_3
    //   238: checkcast com/google/longrunning/DeleteOperationRequest
    //   241: astore_2
    //   242: aload_0
    //   243: aload_1
    //   244: aload_0
    //   245: getfield name_ : Ljava/lang/String;
    //   248: invokevirtual isEmpty : ()Z
    //   251: iconst_1
    //   252: ixor
    //   253: aload_0
    //   254: getfield name_ : Ljava/lang/String;
    //   257: iconst_1
    //   258: aload_2
    //   259: getfield name_ : Ljava/lang/String;
    //   262: invokevirtual isEmpty : ()Z
    //   265: ixor
    //   266: aload_2
    //   267: getfield name_ : Ljava/lang/String;
    //   270: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   275: putfield name_ : Ljava/lang/String;
    //   278: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   281: astore_1
    //   282: aload_0
    //   283: areturn
    //   284: new com/google/longrunning/DeleteOperationRequest$Builder
    //   287: dup
    //   288: aconst_null
    //   289: invokespecial <init> : (Lcom/google/longrunning/DeleteOperationRequest$1;)V
    //   292: areturn
    //   293: aconst_null
    //   294: areturn
    //   295: getstatic com/google/longrunning/DeleteOperationRequest.DEFAULT_INSTANCE : Lcom/google/longrunning/DeleteOperationRequest;
    //   298: areturn
    //   299: new com/google/longrunning/DeleteOperationRequest
    //   302: dup
    //   303: invokespecial <init> : ()V
    //   306: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	210	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	182	java/io/IOException
    //   128	134	178	finally
    //   146	155	210	com/google/protobuf/InvalidProtocolBufferException
    //   146	155	182	java/io/IOException
    //   146	155	178	finally
    //   161	169	210	com/google/protobuf/InvalidProtocolBufferException
    //   161	169	182	java/io/IOException
    //   161	169	178	finally
    //   183	210	178	finally
    //   211	226	178	finally
  }
  
  public String getName() {
    return this.name_;
  }
  
  public ByteString getNameBytes() {
    return ByteString.copyFromUtf8(this.name_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!this.name_.isEmpty())
      i = 0 + CodedOutputStream.computeStringSize(1, getName()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(1, getName()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<DeleteOperationRequest, Builder> implements DeleteOperationRequestOrBuilder {
    private Builder() {
      super(DeleteOperationRequest.DEFAULT_INSTANCE);
    }
    
    public Builder clearName() {
      copyOnWrite();
      ((DeleteOperationRequest)this.instance).clearName();
      return this;
    }
    
    public String getName() {
      return ((DeleteOperationRequest)this.instance).getName();
    }
    
    public ByteString getNameBytes() {
      return ((DeleteOperationRequest)this.instance).getNameBytes();
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      ((DeleteOperationRequest)this.instance).setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((DeleteOperationRequest)this.instance).setNameBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\longrunning\DeleteOperationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */