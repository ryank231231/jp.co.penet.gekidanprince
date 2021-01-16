package com.google.rpc;

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

public final class Status extends GeneratedMessageLite<Status, Status.Builder> implements StatusOrBuilder {
  public static final int CODE_FIELD_NUMBER = 1;
  
  private static final Status DEFAULT_INSTANCE = new Status();
  
  public static final int DETAILS_FIELD_NUMBER = 3;
  
  public static final int MESSAGE_FIELD_NUMBER = 2;
  
  private static volatile Parser<Status> PARSER;
  
  private int bitField0_;
  
  private int code_;
  
  private Internal.ProtobufList<Any> details_ = emptyProtobufList();
  
  private String message_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllDetails(Iterable<? extends Any> paramIterable) {
    ensureDetailsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.details_);
  }
  
  private void addDetails(int paramInt, Any.Builder paramBuilder) {
    ensureDetailsIsMutable();
    this.details_.add(paramInt, paramBuilder.build());
  }
  
  private void addDetails(int paramInt, Any paramAny) {
    if (paramAny != null) {
      ensureDetailsIsMutable();
      this.details_.add(paramInt, paramAny);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addDetails(Any.Builder paramBuilder) {
    ensureDetailsIsMutable();
    this.details_.add(paramBuilder.build());
  }
  
  private void addDetails(Any paramAny) {
    if (paramAny != null) {
      ensureDetailsIsMutable();
      this.details_.add(paramAny);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearCode() {
    this.code_ = 0;
  }
  
  private void clearDetails() {
    this.details_ = emptyProtobufList();
  }
  
  private void clearMessage() {
    this.message_ = getDefaultInstance().getMessage();
  }
  
  private void ensureDetailsIsMutable() {
    if (!this.details_.isModifiable())
      this.details_ = GeneratedMessageLite.mutableCopy(this.details_); 
  }
  
  public static Status getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Status paramStatus) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramStatus);
  }
  
  public static Status parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Status)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Status parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Status)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Status parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Status)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Status parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Status)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Status parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Status)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Status parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Status)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Status parseFrom(InputStream paramInputStream) throws IOException {
    return (Status)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Status parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Status)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Status parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Status)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Status parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Status)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Status> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeDetails(int paramInt) {
    ensureDetailsIsMutable();
    this.details_.remove(paramInt);
  }
  
  private void setCode(int paramInt) {
    this.code_ = paramInt;
  }
  
  private void setDetails(int paramInt, Any.Builder paramBuilder) {
    ensureDetailsIsMutable();
    this.details_.set(paramInt, paramBuilder.build());
  }
  
  private void setDetails(int paramInt, Any paramAny) {
    if (paramAny != null) {
      ensureDetailsIsMutable();
      this.details_.set(paramInt, paramAny);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setMessage(String paramString) {
    if (paramString != null) {
      this.message_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setMessageBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.message_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/rpc/Status$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 471, 2 -> 467, 3 -> 456, 4 -> 447, 5 -> 309, 6 -> 118, 7 -> 305, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/rpc/Status.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/rpc/Status
    //   80: monitorenter
    //   81: getstatic com/google/rpc/Status.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/rpc/Status.DEFAULT_INSTANCE : Lcom/google/rpc/Status;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/rpc/Status.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/rpc/Status
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/rpc/Status
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/rpc/Status.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_1
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_2
    //   128: iload #6
    //   130: ifne -> 305
    //   133: aload_1
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 249
    //   144: iload #4
    //   146: bipush #8
    //   148: if_icmpeq -> 238
    //   151: iload #4
    //   153: bipush #18
    //   155: if_icmpeq -> 227
    //   158: iload #4
    //   160: bipush #26
    //   162: if_icmpeq -> 180
    //   165: aload_1
    //   166: iload #4
    //   168: invokevirtual skipField : (I)Z
    //   171: ifne -> 128
    //   174: iconst_1
    //   175: istore #6
    //   177: goto -> 128
    //   180: aload_0
    //   181: getfield details_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   184: invokeinterface isModifiable : ()Z
    //   189: ifne -> 203
    //   192: aload_0
    //   193: aload_0
    //   194: getfield details_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   197: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   200: putfield details_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   203: aload_0
    //   204: getfield details_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   207: aload_1
    //   208: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   211: aload_2
    //   212: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   215: checkcast com/google/protobuf/Any
    //   218: invokeinterface add : (Ljava/lang/Object;)Z
    //   223: pop
    //   224: goto -> 128
    //   227: aload_0
    //   228: aload_1
    //   229: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   232: putfield message_ : Ljava/lang/String;
    //   235: goto -> 128
    //   238: aload_0
    //   239: aload_1
    //   240: invokevirtual readInt32 : ()I
    //   243: putfield code_ : I
    //   246: goto -> 128
    //   249: iconst_1
    //   250: istore #6
    //   252: goto -> 128
    //   255: astore_1
    //   256: goto -> 303
    //   259: astore_1
    //   260: new java/lang/RuntimeException
    //   263: astore_2
    //   264: new com/google/protobuf/InvalidProtocolBufferException
    //   267: astore_3
    //   268: aload_3
    //   269: aload_1
    //   270: invokevirtual getMessage : ()Ljava/lang/String;
    //   273: invokespecial <init> : (Ljava/lang/String;)V
    //   276: aload_2
    //   277: aload_3
    //   278: aload_0
    //   279: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   282: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   285: aload_2
    //   286: athrow
    //   287: astore_2
    //   288: new java/lang/RuntimeException
    //   291: astore_1
    //   292: aload_1
    //   293: aload_2
    //   294: aload_0
    //   295: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   298: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   301: aload_1
    //   302: athrow
    //   303: aload_1
    //   304: athrow
    //   305: getstatic com/google/rpc/Status.DEFAULT_INSTANCE : Lcom/google/rpc/Status;
    //   308: areturn
    //   309: aload_2
    //   310: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   313: astore_1
    //   314: aload_3
    //   315: checkcast com/google/rpc/Status
    //   318: astore_2
    //   319: aload_0
    //   320: getfield code_ : I
    //   323: ifeq -> 332
    //   326: iconst_1
    //   327: istore #7
    //   329: goto -> 335
    //   332: iconst_0
    //   333: istore #7
    //   335: aload_0
    //   336: getfield code_ : I
    //   339: istore #6
    //   341: aload_2
    //   342: getfield code_ : I
    //   345: ifeq -> 351
    //   348: iconst_1
    //   349: istore #5
    //   351: aload_0
    //   352: aload_1
    //   353: iload #7
    //   355: iload #6
    //   357: iload #5
    //   359: aload_2
    //   360: getfield code_ : I
    //   363: invokeinterface visitInt : (ZIZI)I
    //   368: putfield code_ : I
    //   371: aload_0
    //   372: aload_1
    //   373: aload_0
    //   374: getfield message_ : Ljava/lang/String;
    //   377: invokevirtual isEmpty : ()Z
    //   380: iconst_1
    //   381: ixor
    //   382: aload_0
    //   383: getfield message_ : Ljava/lang/String;
    //   386: aload_2
    //   387: getfield message_ : Ljava/lang/String;
    //   390: invokevirtual isEmpty : ()Z
    //   393: iconst_1
    //   394: ixor
    //   395: aload_2
    //   396: getfield message_ : Ljava/lang/String;
    //   399: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   404: putfield message_ : Ljava/lang/String;
    //   407: aload_0
    //   408: aload_1
    //   409: aload_0
    //   410: getfield details_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   413: aload_2
    //   414: getfield details_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   417: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   422: putfield details_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   425: aload_1
    //   426: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   429: if_acmpne -> 445
    //   432: aload_0
    //   433: aload_0
    //   434: getfield bitField0_ : I
    //   437: aload_2
    //   438: getfield bitField0_ : I
    //   441: ior
    //   442: putfield bitField0_ : I
    //   445: aload_0
    //   446: areturn
    //   447: new com/google/rpc/Status$Builder
    //   450: dup
    //   451: aconst_null
    //   452: invokespecial <init> : (Lcom/google/rpc/Status$1;)V
    //   455: areturn
    //   456: aload_0
    //   457: getfield details_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   460: invokeinterface makeImmutable : ()V
    //   465: aconst_null
    //   466: areturn
    //   467: getstatic com/google/rpc/Status.DEFAULT_INSTANCE : Lcom/google/rpc/Status;
    //   470: areturn
    //   471: new com/google/rpc/Status
    //   474: dup
    //   475: invokespecial <init> : ()V
    //   478: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	287	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	259	java/io/IOException
    //   133	139	255	finally
    //   165	174	287	com/google/protobuf/InvalidProtocolBufferException
    //   165	174	259	java/io/IOException
    //   165	174	255	finally
    //   180	203	287	com/google/protobuf/InvalidProtocolBufferException
    //   180	203	259	java/io/IOException
    //   180	203	255	finally
    //   203	224	287	com/google/protobuf/InvalidProtocolBufferException
    //   203	224	259	java/io/IOException
    //   203	224	255	finally
    //   227	235	287	com/google/protobuf/InvalidProtocolBufferException
    //   227	235	259	java/io/IOException
    //   227	235	255	finally
    //   238	246	287	com/google/protobuf/InvalidProtocolBufferException
    //   238	246	259	java/io/IOException
    //   238	246	255	finally
    //   260	287	255	finally
    //   288	303	255	finally
  }
  
  public int getCode() {
    return this.code_;
  }
  
  public Any getDetails(int paramInt) {
    return (Any)this.details_.get(paramInt);
  }
  
  public int getDetailsCount() {
    return this.details_.size();
  }
  
  public List<Any> getDetailsList() {
    return (List<Any>)this.details_;
  }
  
  public AnyOrBuilder getDetailsOrBuilder(int paramInt) {
    return (AnyOrBuilder)this.details_.get(paramInt);
  }
  
  public List<? extends AnyOrBuilder> getDetailsOrBuilderList() {
    return (List)this.details_;
  }
  
  public String getMessage() {
    return this.message_;
  }
  
  public ByteString getMessageBytes() {
    return ByteString.copyFromUtf8(this.message_);
  }
  
  public int getSerializedSize() {
    byte b2;
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = this.code_;
    byte b1 = 0;
    if (i != 0) {
      b2 = CodedOutputStream.computeInt32Size(1, i) + 0;
    } else {
      b2 = 0;
    } 
    i = b2;
    byte b3 = b1;
    if (!this.message_.isEmpty()) {
      i = b2 + CodedOutputStream.computeStringSize(2, getMessage());
      b3 = b1;
    } 
    while (b3 < this.details_.size()) {
      i += CodedOutputStream.computeMessageSize(3, (MessageLite)this.details_.get(b3));
      b3++;
    } 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    int i = this.code_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(1, i); 
    if (!this.message_.isEmpty())
      paramCodedOutputStream.writeString(2, getMessage()); 
    for (i = 0; i < this.details_.size(); i++)
      paramCodedOutputStream.writeMessage(3, (MessageLite)this.details_.get(i)); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Status, Builder> implements StatusOrBuilder {
    private Builder() {
      super(Status.DEFAULT_INSTANCE);
    }
    
    public Builder addAllDetails(Iterable<? extends Any> param1Iterable) {
      copyOnWrite();
      ((Status)this.instance).addAllDetails(param1Iterable);
      return this;
    }
    
    public Builder addDetails(int param1Int, Any.Builder param1Builder) {
      copyOnWrite();
      ((Status)this.instance).addDetails(param1Int, param1Builder);
      return this;
    }
    
    public Builder addDetails(int param1Int, Any param1Any) {
      copyOnWrite();
      ((Status)this.instance).addDetails(param1Int, param1Any);
      return this;
    }
    
    public Builder addDetails(Any.Builder param1Builder) {
      copyOnWrite();
      ((Status)this.instance).addDetails(param1Builder);
      return this;
    }
    
    public Builder addDetails(Any param1Any) {
      copyOnWrite();
      ((Status)this.instance).addDetails(param1Any);
      return this;
    }
    
    public Builder clearCode() {
      copyOnWrite();
      ((Status)this.instance).clearCode();
      return this;
    }
    
    public Builder clearDetails() {
      copyOnWrite();
      ((Status)this.instance).clearDetails();
      return this;
    }
    
    public Builder clearMessage() {
      copyOnWrite();
      ((Status)this.instance).clearMessage();
      return this;
    }
    
    public int getCode() {
      return ((Status)this.instance).getCode();
    }
    
    public Any getDetails(int param1Int) {
      return ((Status)this.instance).getDetails(param1Int);
    }
    
    public int getDetailsCount() {
      return ((Status)this.instance).getDetailsCount();
    }
    
    public List<Any> getDetailsList() {
      return Collections.unmodifiableList(((Status)this.instance).getDetailsList());
    }
    
    public String getMessage() {
      return ((Status)this.instance).getMessage();
    }
    
    public ByteString getMessageBytes() {
      return ((Status)this.instance).getMessageBytes();
    }
    
    public Builder removeDetails(int param1Int) {
      copyOnWrite();
      ((Status)this.instance).removeDetails(param1Int);
      return this;
    }
    
    public Builder setCode(int param1Int) {
      copyOnWrite();
      ((Status)this.instance).setCode(param1Int);
      return this;
    }
    
    public Builder setDetails(int param1Int, Any.Builder param1Builder) {
      copyOnWrite();
      ((Status)this.instance).setDetails(param1Int, param1Builder);
      return this;
    }
    
    public Builder setDetails(int param1Int, Any param1Any) {
      copyOnWrite();
      ((Status)this.instance).setDetails(param1Int, param1Any);
      return this;
    }
    
    public Builder setMessage(String param1String) {
      copyOnWrite();
      ((Status)this.instance).setMessage(param1String);
      return this;
    }
    
    public Builder setMessageBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Status)this.instance).setMessageBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\rpc\Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */