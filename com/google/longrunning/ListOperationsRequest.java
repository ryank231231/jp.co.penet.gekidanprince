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

public final class ListOperationsRequest extends GeneratedMessageLite<ListOperationsRequest, ListOperationsRequest.Builder> implements ListOperationsRequestOrBuilder {
  private static final ListOperationsRequest DEFAULT_INSTANCE = new ListOperationsRequest();
  
  public static final int FILTER_FIELD_NUMBER = 1;
  
  public static final int NAME_FIELD_NUMBER = 4;
  
  public static final int PAGE_SIZE_FIELD_NUMBER = 2;
  
  public static final int PAGE_TOKEN_FIELD_NUMBER = 3;
  
  private static volatile Parser<ListOperationsRequest> PARSER;
  
  private String filter_ = "";
  
  private String name_ = "";
  
  private int pageSize_;
  
  private String pageToken_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearFilter() {
    this.filter_ = getDefaultInstance().getFilter();
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearPageSize() {
    this.pageSize_ = 0;
  }
  
  private void clearPageToken() {
    this.pageToken_ = getDefaultInstance().getPageToken();
  }
  
  public static ListOperationsRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ListOperationsRequest paramListOperationsRequest) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramListOperationsRequest);
  }
  
  public static ListOperationsRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ListOperationsRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ListOperationsRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListOperationsRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListOperationsRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (ListOperationsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static ListOperationsRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListOperationsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static ListOperationsRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (ListOperationsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static ListOperationsRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListOperationsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ListOperationsRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (ListOperationsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ListOperationsRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListOperationsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListOperationsRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (ListOperationsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static ListOperationsRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListOperationsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ListOperationsRequest> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setFilter(String paramString) {
    if (paramString != null) {
      this.filter_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setFilterBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.filter_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
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
  
  private void setPageSize(int paramInt) {
    this.pageSize_ = paramInt;
  }
  
  private void setPageToken(String paramString) {
    if (paramString != null) {
      this.pageToken_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setPageTokenBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.pageToken_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/longrunning/ListOperationsRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 482, 2 -> 478, 3 -> 476, 4 -> 467, 5 -> 291, 6 -> 118, 7 -> 287, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/longrunning/ListOperationsRequest.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/longrunning/ListOperationsRequest
    //   80: monitorenter
    //   81: getstatic com/google/longrunning/ListOperationsRequest.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/longrunning/ListOperationsRequest.DEFAULT_INSTANCE : Lcom/google/longrunning/ListOperationsRequest;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/longrunning/ListOperationsRequest.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/longrunning/ListOperationsRequest
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/longrunning/ListOperationsRequest
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/longrunning/ListOperationsRequest.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_1
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_2
    //   128: iload #6
    //   130: ifne -> 287
    //   133: aload_1
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 231
    //   144: iload #4
    //   146: bipush #10
    //   148: if_icmpeq -> 220
    //   151: iload #4
    //   153: bipush #16
    //   155: if_icmpeq -> 209
    //   158: iload #4
    //   160: bipush #26
    //   162: if_icmpeq -> 198
    //   165: iload #4
    //   167: bipush #34
    //   169: if_icmpeq -> 187
    //   172: aload_1
    //   173: iload #4
    //   175: invokevirtual skipField : (I)Z
    //   178: ifne -> 128
    //   181: iconst_1
    //   182: istore #6
    //   184: goto -> 128
    //   187: aload_0
    //   188: aload_1
    //   189: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   192: putfield name_ : Ljava/lang/String;
    //   195: goto -> 128
    //   198: aload_0
    //   199: aload_1
    //   200: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   203: putfield pageToken_ : Ljava/lang/String;
    //   206: goto -> 128
    //   209: aload_0
    //   210: aload_1
    //   211: invokevirtual readInt32 : ()I
    //   214: putfield pageSize_ : I
    //   217: goto -> 128
    //   220: aload_0
    //   221: aload_1
    //   222: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   225: putfield filter_ : Ljava/lang/String;
    //   228: goto -> 128
    //   231: iconst_1
    //   232: istore #6
    //   234: goto -> 128
    //   237: astore_1
    //   238: goto -> 285
    //   241: astore_1
    //   242: new java/lang/RuntimeException
    //   245: astore_2
    //   246: new com/google/protobuf/InvalidProtocolBufferException
    //   249: astore_3
    //   250: aload_3
    //   251: aload_1
    //   252: invokevirtual getMessage : ()Ljava/lang/String;
    //   255: invokespecial <init> : (Ljava/lang/String;)V
    //   258: aload_2
    //   259: aload_3
    //   260: aload_0
    //   261: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   264: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   267: aload_2
    //   268: athrow
    //   269: astore_2
    //   270: new java/lang/RuntimeException
    //   273: astore_1
    //   274: aload_1
    //   275: aload_2
    //   276: aload_0
    //   277: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   280: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   283: aload_1
    //   284: athrow
    //   285: aload_1
    //   286: athrow
    //   287: getstatic com/google/longrunning/ListOperationsRequest.DEFAULT_INSTANCE : Lcom/google/longrunning/ListOperationsRequest;
    //   290: areturn
    //   291: aload_2
    //   292: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   295: astore_1
    //   296: aload_3
    //   297: checkcast com/google/longrunning/ListOperationsRequest
    //   300: astore_2
    //   301: aload_0
    //   302: aload_1
    //   303: aload_0
    //   304: getfield name_ : Ljava/lang/String;
    //   307: invokevirtual isEmpty : ()Z
    //   310: iconst_1
    //   311: ixor
    //   312: aload_0
    //   313: getfield name_ : Ljava/lang/String;
    //   316: aload_2
    //   317: getfield name_ : Ljava/lang/String;
    //   320: invokevirtual isEmpty : ()Z
    //   323: iconst_1
    //   324: ixor
    //   325: aload_2
    //   326: getfield name_ : Ljava/lang/String;
    //   329: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   334: putfield name_ : Ljava/lang/String;
    //   337: aload_0
    //   338: aload_1
    //   339: aload_0
    //   340: getfield filter_ : Ljava/lang/String;
    //   343: invokevirtual isEmpty : ()Z
    //   346: iconst_1
    //   347: ixor
    //   348: aload_0
    //   349: getfield filter_ : Ljava/lang/String;
    //   352: aload_2
    //   353: getfield filter_ : Ljava/lang/String;
    //   356: invokevirtual isEmpty : ()Z
    //   359: iconst_1
    //   360: ixor
    //   361: aload_2
    //   362: getfield filter_ : Ljava/lang/String;
    //   365: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   370: putfield filter_ : Ljava/lang/String;
    //   373: aload_0
    //   374: getfield pageSize_ : I
    //   377: ifeq -> 386
    //   380: iconst_1
    //   381: istore #7
    //   383: goto -> 389
    //   386: iconst_0
    //   387: istore #7
    //   389: aload_0
    //   390: getfield pageSize_ : I
    //   393: istore #6
    //   395: aload_2
    //   396: getfield pageSize_ : I
    //   399: ifeq -> 405
    //   402: iconst_1
    //   403: istore #5
    //   405: aload_0
    //   406: aload_1
    //   407: iload #7
    //   409: iload #6
    //   411: iload #5
    //   413: aload_2
    //   414: getfield pageSize_ : I
    //   417: invokeinterface visitInt : (ZIZI)I
    //   422: putfield pageSize_ : I
    //   425: aload_0
    //   426: aload_1
    //   427: aload_0
    //   428: getfield pageToken_ : Ljava/lang/String;
    //   431: invokevirtual isEmpty : ()Z
    //   434: iconst_1
    //   435: ixor
    //   436: aload_0
    //   437: getfield pageToken_ : Ljava/lang/String;
    //   440: aload_2
    //   441: getfield pageToken_ : Ljava/lang/String;
    //   444: invokevirtual isEmpty : ()Z
    //   447: iconst_1
    //   448: ixor
    //   449: aload_2
    //   450: getfield pageToken_ : Ljava/lang/String;
    //   453: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   458: putfield pageToken_ : Ljava/lang/String;
    //   461: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   464: astore_1
    //   465: aload_0
    //   466: areturn
    //   467: new com/google/longrunning/ListOperationsRequest$Builder
    //   470: dup
    //   471: aconst_null
    //   472: invokespecial <init> : (Lcom/google/longrunning/ListOperationsRequest$1;)V
    //   475: areturn
    //   476: aconst_null
    //   477: areturn
    //   478: getstatic com/google/longrunning/ListOperationsRequest.DEFAULT_INSTANCE : Lcom/google/longrunning/ListOperationsRequest;
    //   481: areturn
    //   482: new com/google/longrunning/ListOperationsRequest
    //   485: dup
    //   486: invokespecial <init> : ()V
    //   489: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	269	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	241	java/io/IOException
    //   133	139	237	finally
    //   172	181	269	com/google/protobuf/InvalidProtocolBufferException
    //   172	181	241	java/io/IOException
    //   172	181	237	finally
    //   187	195	269	com/google/protobuf/InvalidProtocolBufferException
    //   187	195	241	java/io/IOException
    //   187	195	237	finally
    //   198	206	269	com/google/protobuf/InvalidProtocolBufferException
    //   198	206	241	java/io/IOException
    //   198	206	237	finally
    //   209	217	269	com/google/protobuf/InvalidProtocolBufferException
    //   209	217	241	java/io/IOException
    //   209	217	237	finally
    //   220	228	269	com/google/protobuf/InvalidProtocolBufferException
    //   220	228	241	java/io/IOException
    //   220	228	237	finally
    //   242	269	237	finally
    //   270	285	237	finally
  }
  
  public String getFilter() {
    return this.filter_;
  }
  
  public ByteString getFilterBytes() {
    return ByteString.copyFromUtf8(this.filter_);
  }
  
  public String getName() {
    return this.name_;
  }
  
  public ByteString getNameBytes() {
    return ByteString.copyFromUtf8(this.name_);
  }
  
  public int getPageSize() {
    return this.pageSize_;
  }
  
  public String getPageToken() {
    return this.pageToken_;
  }
  
  public ByteString getPageTokenBytes() {
    return ByteString.copyFromUtf8(this.pageToken_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!this.filter_.isEmpty())
      j = 0 + CodedOutputStream.computeStringSize(1, getFilter()); 
    int k = this.pageSize_;
    i = j;
    if (k != 0)
      i = j + CodedOutputStream.computeInt32Size(2, k); 
    j = i;
    if (!this.pageToken_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(3, getPageToken()); 
    i = j;
    if (!this.name_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(4, getName()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.filter_.isEmpty())
      paramCodedOutputStream.writeString(1, getFilter()); 
    int i = this.pageSize_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(2, i); 
    if (!this.pageToken_.isEmpty())
      paramCodedOutputStream.writeString(3, getPageToken()); 
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(4, getName()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ListOperationsRequest, Builder> implements ListOperationsRequestOrBuilder {
    private Builder() {
      super(ListOperationsRequest.DEFAULT_INSTANCE);
    }
    
    public Builder clearFilter() {
      copyOnWrite();
      ((ListOperationsRequest)this.instance).clearFilter();
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      ((ListOperationsRequest)this.instance).clearName();
      return this;
    }
    
    public Builder clearPageSize() {
      copyOnWrite();
      ((ListOperationsRequest)this.instance).clearPageSize();
      return this;
    }
    
    public Builder clearPageToken() {
      copyOnWrite();
      ((ListOperationsRequest)this.instance).clearPageToken();
      return this;
    }
    
    public String getFilter() {
      return ((ListOperationsRequest)this.instance).getFilter();
    }
    
    public ByteString getFilterBytes() {
      return ((ListOperationsRequest)this.instance).getFilterBytes();
    }
    
    public String getName() {
      return ((ListOperationsRequest)this.instance).getName();
    }
    
    public ByteString getNameBytes() {
      return ((ListOperationsRequest)this.instance).getNameBytes();
    }
    
    public int getPageSize() {
      return ((ListOperationsRequest)this.instance).getPageSize();
    }
    
    public String getPageToken() {
      return ((ListOperationsRequest)this.instance).getPageToken();
    }
    
    public ByteString getPageTokenBytes() {
      return ((ListOperationsRequest)this.instance).getPageTokenBytes();
    }
    
    public Builder setFilter(String param1String) {
      copyOnWrite();
      ((ListOperationsRequest)this.instance).setFilter(param1String);
      return this;
    }
    
    public Builder setFilterBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ListOperationsRequest)this.instance).setFilterBytes(param1ByteString);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      ((ListOperationsRequest)this.instance).setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ListOperationsRequest)this.instance).setNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setPageSize(int param1Int) {
      copyOnWrite();
      ((ListOperationsRequest)this.instance).setPageSize(param1Int);
      return this;
    }
    
    public Builder setPageToken(String param1String) {
      copyOnWrite();
      ((ListOperationsRequest)this.instance).setPageToken(param1String);
      return this;
    }
    
    public Builder setPageTokenBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ListOperationsRequest)this.instance).setPageTokenBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\longrunning\ListOperationsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */