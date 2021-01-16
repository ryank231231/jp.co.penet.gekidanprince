package com.google.longrunning;

import com.google.protobuf.AbstractMessageLite;
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

public final class ListOperationsResponse extends GeneratedMessageLite<ListOperationsResponse, ListOperationsResponse.Builder> implements ListOperationsResponseOrBuilder {
  private static final ListOperationsResponse DEFAULT_INSTANCE = new ListOperationsResponse();
  
  public static final int NEXT_PAGE_TOKEN_FIELD_NUMBER = 2;
  
  public static final int OPERATIONS_FIELD_NUMBER = 1;
  
  private static volatile Parser<ListOperationsResponse> PARSER;
  
  private int bitField0_;
  
  private String nextPageToken_ = "";
  
  private Internal.ProtobufList<Operation> operations_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllOperations(Iterable<? extends Operation> paramIterable) {
    ensureOperationsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.operations_);
  }
  
  private void addOperations(int paramInt, Operation.Builder paramBuilder) {
    ensureOperationsIsMutable();
    this.operations_.add(paramInt, paramBuilder.build());
  }
  
  private void addOperations(int paramInt, Operation paramOperation) {
    if (paramOperation != null) {
      ensureOperationsIsMutable();
      this.operations_.add(paramInt, paramOperation);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addOperations(Operation.Builder paramBuilder) {
    ensureOperationsIsMutable();
    this.operations_.add(paramBuilder.build());
  }
  
  private void addOperations(Operation paramOperation) {
    if (paramOperation != null) {
      ensureOperationsIsMutable();
      this.operations_.add(paramOperation);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearNextPageToken() {
    this.nextPageToken_ = getDefaultInstance().getNextPageToken();
  }
  
  private void clearOperations() {
    this.operations_ = emptyProtobufList();
  }
  
  private void ensureOperationsIsMutable() {
    if (!this.operations_.isModifiable())
      this.operations_ = GeneratedMessageLite.mutableCopy(this.operations_); 
  }
  
  public static ListOperationsResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ListOperationsResponse paramListOperationsResponse) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramListOperationsResponse);
  }
  
  public static ListOperationsResponse parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ListOperationsResponse)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ListOperationsResponse parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListOperationsResponse)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListOperationsResponse parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (ListOperationsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static ListOperationsResponse parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListOperationsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static ListOperationsResponse parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (ListOperationsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static ListOperationsResponse parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListOperationsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ListOperationsResponse parseFrom(InputStream paramInputStream) throws IOException {
    return (ListOperationsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ListOperationsResponse parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListOperationsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListOperationsResponse parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (ListOperationsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static ListOperationsResponse parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListOperationsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ListOperationsResponse> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeOperations(int paramInt) {
    ensureOperationsIsMutable();
    this.operations_.remove(paramInt);
  }
  
  private void setNextPageToken(String paramString) {
    if (paramString != null) {
      this.nextPageToken_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setNextPageTokenBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.nextPageToken_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setOperations(int paramInt, Operation.Builder paramBuilder) {
    ensureOperationsIsMutable();
    this.operations_.set(paramInt, paramBuilder.build());
  }
  
  private void setOperations(int paramInt, Operation paramOperation) {
    if (paramOperation != null) {
      ensureOperationsIsMutable();
      this.operations_.set(paramInt, paramOperation);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/longrunning/ListOperationsResponse$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 396, 2 -> 392, 3 -> 381, 4 -> 372, 5 -> 286, 6 -> 110, 7 -> 282, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/longrunning/ListOperationsResponse.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/longrunning/ListOperationsResponse
    //   72: monitorenter
    //   73: getstatic com/google/longrunning/ListOperationsResponse.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/longrunning/ListOperationsResponse.DEFAULT_INSTANCE : Lcom/google/longrunning/ListOperationsResponse;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/longrunning/ListOperationsResponse.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/longrunning/ListOperationsResponse
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/longrunning/ListOperationsResponse
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/longrunning/ListOperationsResponse.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 282
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 226
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
    //   173: putfield nextPageToken_ : Ljava/lang/String;
    //   176: goto -> 123
    //   179: aload_0
    //   180: getfield operations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   183: invokeinterface isModifiable : ()Z
    //   188: ifne -> 202
    //   191: aload_0
    //   192: aload_0
    //   193: getfield operations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   196: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   199: putfield operations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   202: aload_0
    //   203: getfield operations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   206: aload_1
    //   207: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   210: aload_2
    //   211: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   214: checkcast com/google/longrunning/Operation
    //   217: invokeinterface add : (Ljava/lang/Object;)Z
    //   222: pop
    //   223: goto -> 123
    //   226: iconst_1
    //   227: istore #4
    //   229: goto -> 123
    //   232: astore_1
    //   233: goto -> 280
    //   236: astore_2
    //   237: new java/lang/RuntimeException
    //   240: astore_3
    //   241: new com/google/protobuf/InvalidProtocolBufferException
    //   244: astore_1
    //   245: aload_1
    //   246: aload_2
    //   247: invokevirtual getMessage : ()Ljava/lang/String;
    //   250: invokespecial <init> : (Ljava/lang/String;)V
    //   253: aload_3
    //   254: aload_1
    //   255: aload_0
    //   256: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   259: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   262: aload_3
    //   263: athrow
    //   264: astore_1
    //   265: new java/lang/RuntimeException
    //   268: astore_2
    //   269: aload_2
    //   270: aload_1
    //   271: aload_0
    //   272: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   275: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   278: aload_2
    //   279: athrow
    //   280: aload_1
    //   281: athrow
    //   282: getstatic com/google/longrunning/ListOperationsResponse.DEFAULT_INSTANCE : Lcom/google/longrunning/ListOperationsResponse;
    //   285: areturn
    //   286: aload_2
    //   287: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   290: astore_1
    //   291: aload_3
    //   292: checkcast com/google/longrunning/ListOperationsResponse
    //   295: astore_2
    //   296: aload_0
    //   297: aload_1
    //   298: aload_0
    //   299: getfield operations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   302: aload_2
    //   303: getfield operations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   306: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   311: putfield operations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   314: aload_0
    //   315: aload_1
    //   316: aload_0
    //   317: getfield nextPageToken_ : Ljava/lang/String;
    //   320: invokevirtual isEmpty : ()Z
    //   323: iconst_1
    //   324: ixor
    //   325: aload_0
    //   326: getfield nextPageToken_ : Ljava/lang/String;
    //   329: iconst_1
    //   330: aload_2
    //   331: getfield nextPageToken_ : Ljava/lang/String;
    //   334: invokevirtual isEmpty : ()Z
    //   337: ixor
    //   338: aload_2
    //   339: getfield nextPageToken_ : Ljava/lang/String;
    //   342: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   347: putfield nextPageToken_ : Ljava/lang/String;
    //   350: aload_1
    //   351: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   354: if_acmpne -> 370
    //   357: aload_0
    //   358: aload_0
    //   359: getfield bitField0_ : I
    //   362: aload_2
    //   363: getfield bitField0_ : I
    //   366: ior
    //   367: putfield bitField0_ : I
    //   370: aload_0
    //   371: areturn
    //   372: new com/google/longrunning/ListOperationsResponse$Builder
    //   375: dup
    //   376: aconst_null
    //   377: invokespecial <init> : (Lcom/google/longrunning/ListOperationsResponse$1;)V
    //   380: areturn
    //   381: aload_0
    //   382: getfield operations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   385: invokeinterface makeImmutable : ()V
    //   390: aconst_null
    //   391: areturn
    //   392: getstatic com/google/longrunning/ListOperationsResponse.DEFAULT_INSTANCE : Lcom/google/longrunning/ListOperationsResponse;
    //   395: areturn
    //   396: new com/google/longrunning/ListOperationsResponse
    //   399: dup
    //   400: invokespecial <init> : ()V
    //   403: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	264	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	236	java/io/IOException
    //   128	134	232	finally
    //   153	162	264	com/google/protobuf/InvalidProtocolBufferException
    //   153	162	236	java/io/IOException
    //   153	162	232	finally
    //   168	176	264	com/google/protobuf/InvalidProtocolBufferException
    //   168	176	236	java/io/IOException
    //   168	176	232	finally
    //   179	202	264	com/google/protobuf/InvalidProtocolBufferException
    //   179	202	236	java/io/IOException
    //   179	202	232	finally
    //   202	223	264	com/google/protobuf/InvalidProtocolBufferException
    //   202	223	236	java/io/IOException
    //   202	223	232	finally
    //   237	264	232	finally
    //   265	280	232	finally
  }
  
  public String getNextPageToken() {
    return this.nextPageToken_;
  }
  
  public ByteString getNextPageTokenBytes() {
    return ByteString.copyFromUtf8(this.nextPageToken_);
  }
  
  public Operation getOperations(int paramInt) {
    return (Operation)this.operations_.get(paramInt);
  }
  
  public int getOperationsCount() {
    return this.operations_.size();
  }
  
  public List<Operation> getOperationsList() {
    return (List<Operation>)this.operations_;
  }
  
  public OperationOrBuilder getOperationsOrBuilder(int paramInt) {
    return (OperationOrBuilder)this.operations_.get(paramInt);
  }
  
  public List<? extends OperationOrBuilder> getOperationsOrBuilderList() {
    return (List)this.operations_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    i = 0;
    while (j < this.operations_.size()) {
      i += CodedOutputStream.computeMessageSize(1, (MessageLite)this.operations_.get(j));
      j++;
    } 
    j = i;
    if (!this.nextPageToken_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(2, getNextPageToken()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (byte b = 0; b < this.operations_.size(); b++)
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.operations_.get(b)); 
    if (!this.nextPageToken_.isEmpty())
      paramCodedOutputStream.writeString(2, getNextPageToken()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ListOperationsResponse, Builder> implements ListOperationsResponseOrBuilder {
    private Builder() {
      super(ListOperationsResponse.DEFAULT_INSTANCE);
    }
    
    public Builder addAllOperations(Iterable<? extends Operation> param1Iterable) {
      copyOnWrite();
      ((ListOperationsResponse)this.instance).addAllOperations(param1Iterable);
      return this;
    }
    
    public Builder addOperations(int param1Int, Operation.Builder param1Builder) {
      copyOnWrite();
      ((ListOperationsResponse)this.instance).addOperations(param1Int, param1Builder);
      return this;
    }
    
    public Builder addOperations(int param1Int, Operation param1Operation) {
      copyOnWrite();
      ((ListOperationsResponse)this.instance).addOperations(param1Int, param1Operation);
      return this;
    }
    
    public Builder addOperations(Operation.Builder param1Builder) {
      copyOnWrite();
      ((ListOperationsResponse)this.instance).addOperations(param1Builder);
      return this;
    }
    
    public Builder addOperations(Operation param1Operation) {
      copyOnWrite();
      ((ListOperationsResponse)this.instance).addOperations(param1Operation);
      return this;
    }
    
    public Builder clearNextPageToken() {
      copyOnWrite();
      ((ListOperationsResponse)this.instance).clearNextPageToken();
      return this;
    }
    
    public Builder clearOperations() {
      copyOnWrite();
      ((ListOperationsResponse)this.instance).clearOperations();
      return this;
    }
    
    public String getNextPageToken() {
      return ((ListOperationsResponse)this.instance).getNextPageToken();
    }
    
    public ByteString getNextPageTokenBytes() {
      return ((ListOperationsResponse)this.instance).getNextPageTokenBytes();
    }
    
    public Operation getOperations(int param1Int) {
      return ((ListOperationsResponse)this.instance).getOperations(param1Int);
    }
    
    public int getOperationsCount() {
      return ((ListOperationsResponse)this.instance).getOperationsCount();
    }
    
    public List<Operation> getOperationsList() {
      return Collections.unmodifiableList(((ListOperationsResponse)this.instance).getOperationsList());
    }
    
    public Builder removeOperations(int param1Int) {
      copyOnWrite();
      ((ListOperationsResponse)this.instance).removeOperations(param1Int);
      return this;
    }
    
    public Builder setNextPageToken(String param1String) {
      copyOnWrite();
      ((ListOperationsResponse)this.instance).setNextPageToken(param1String);
      return this;
    }
    
    public Builder setNextPageTokenBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ListOperationsResponse)this.instance).setNextPageTokenBytes(param1ByteString);
      return this;
    }
    
    public Builder setOperations(int param1Int, Operation.Builder param1Builder) {
      copyOnWrite();
      ((ListOperationsResponse)this.instance).setOperations(param1Int, param1Builder);
      return this;
    }
    
    public Builder setOperations(int param1Int, Operation param1Operation) {
      copyOnWrite();
      ((ListOperationsResponse)this.instance).setOperations(param1Int, param1Operation);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\longrunning\ListOperationsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */