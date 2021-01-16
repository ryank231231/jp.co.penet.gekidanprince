package com.google.internal.firebase.inappmessaging.v1;

import com.google.firebase.inappmessaging.CommonTypesProto;
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
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ListCampaignsRequest extends GeneratedMessageLite<ListCampaignsRequest, ListCampaignsRequest.Builder> implements ListCampaignsRequestOrBuilder {
  private static final ListCampaignsRequest DEFAULT_INSTANCE;
  
  private static volatile Parser<ListCampaignsRequest> PARSER;
  
  public static final int PROJECT_NUMBER_FIELD_NUMBER = 1;
  
  public static final int REQUESTED_STATES_FIELD_NUMBER = 2;
  
  private static final Internal.ListAdapter.Converter<Integer, CommonTypesProto.CampaignState> requestedStates_converter_ = new Internal.ListAdapter.Converter<Integer, CommonTypesProto.CampaignState>() {
      public CommonTypesProto.CampaignState convert(Integer param1Integer) {
        CommonTypesProto.CampaignState campaignState2 = CommonTypesProto.CampaignState.forNumber(param1Integer.intValue());
        CommonTypesProto.CampaignState campaignState1 = campaignState2;
        if (campaignState2 == null)
          campaignState1 = CommonTypesProto.CampaignState.UNRECOGNIZED; 
        return campaignState1;
      }
    };
  
  private int bitField0_;
  
  private String projectNumber_ = "";
  
  private Internal.IntList requestedStates_ = emptyIntList();
  
  static {
    DEFAULT_INSTANCE = new ListCampaignsRequest();
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllRequestedStates(Iterable<? extends CommonTypesProto.CampaignState> paramIterable) {
    ensureRequestedStatesIsMutable();
    for (CommonTypesProto.CampaignState campaignState : paramIterable)
      this.requestedStates_.addInt(campaignState.getNumber()); 
  }
  
  private void addAllRequestedStatesValue(Iterable<Integer> paramIterable) {
    ensureRequestedStatesIsMutable();
    Iterator<Integer> iterator = paramIterable.iterator();
    while (iterator.hasNext()) {
      int i = ((Integer)iterator.next()).intValue();
      this.requestedStates_.addInt(i);
    } 
  }
  
  private void addRequestedStates(CommonTypesProto.CampaignState paramCampaignState) {
    if (paramCampaignState != null) {
      ensureRequestedStatesIsMutable();
      this.requestedStates_.addInt(paramCampaignState.getNumber());
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addRequestedStatesValue(int paramInt) {
    ensureRequestedStatesIsMutable();
    this.requestedStates_.addInt(paramInt);
  }
  
  private void clearProjectNumber() {
    this.projectNumber_ = getDefaultInstance().getProjectNumber();
  }
  
  private void clearRequestedStates() {
    this.requestedStates_ = emptyIntList();
  }
  
  private void ensureRequestedStatesIsMutable() {
    if (!this.requestedStates_.isModifiable())
      this.requestedStates_ = GeneratedMessageLite.mutableCopy(this.requestedStates_); 
  }
  
  public static ListCampaignsRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ListCampaignsRequest paramListCampaignsRequest) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramListCampaignsRequest);
  }
  
  public static ListCampaignsRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ListCampaignsRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ListCampaignsRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListCampaignsRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListCampaignsRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (ListCampaignsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static ListCampaignsRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListCampaignsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static ListCampaignsRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (ListCampaignsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static ListCampaignsRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListCampaignsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ListCampaignsRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (ListCampaignsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ListCampaignsRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListCampaignsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListCampaignsRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (ListCampaignsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static ListCampaignsRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListCampaignsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ListCampaignsRequest> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setProjectNumber(String paramString) {
    if (paramString != null) {
      this.projectNumber_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setProjectNumberBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.projectNumber_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRequestedStates(int paramInt, CommonTypesProto.CampaignState paramCampaignState) {
    if (paramCampaignState != null) {
      ensureRequestedStatesIsMutable();
      this.requestedStates_.setInt(paramInt, paramCampaignState.getNumber());
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRequestedStatesValue(int paramInt1, int paramInt2) {
    ensureRequestedStatesIsMutable();
    this.requestedStates_.setInt(paramInt1, paramInt2);
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/internal/firebase/inappmessaging/v1/ListCampaignsRequest$2.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 460, 2 -> 456, 3 -> 445, 4 -> 436, 5 -> 350, 6 -> 110, 7 -> 346, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/internal/firebase/inappmessaging/v1/ListCampaignsRequest.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/internal/firebase/inappmessaging/v1/ListCampaignsRequest
    //   72: monitorenter
    //   73: getstatic com/google/internal/firebase/inappmessaging/v1/ListCampaignsRequest.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/internal/firebase/inappmessaging/v1/ListCampaignsRequest.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/ListCampaignsRequest;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/internal/firebase/inappmessaging/v1/ListCampaignsRequest.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/internal/firebase/inappmessaging/v1/ListCampaignsRequest
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/internal/firebase/inappmessaging/v1/ListCampaignsRequest
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/internal/firebase/inappmessaging/v1/ListCampaignsRequest.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 346
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 290
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 279
    //   146: iload #5
    //   148: bipush #16
    //   150: if_icmpeq -> 240
    //   153: iload #5
    //   155: bipush #18
    //   157: if_icmpeq -> 175
    //   160: aload_1
    //   161: iload #5
    //   163: invokevirtual skipField : (I)Z
    //   166: ifne -> 123
    //   169: iconst_1
    //   170: istore #4
    //   172: goto -> 123
    //   175: aload_0
    //   176: getfield requestedStates_ : Lcom/google/protobuf/Internal$IntList;
    //   179: invokeinterface isModifiable : ()Z
    //   184: ifne -> 198
    //   187: aload_0
    //   188: aload_0
    //   189: getfield requestedStates_ : Lcom/google/protobuf/Internal$IntList;
    //   192: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$IntList;)Lcom/google/protobuf/Internal$IntList;
    //   195: putfield requestedStates_ : Lcom/google/protobuf/Internal$IntList;
    //   198: aload_1
    //   199: aload_1
    //   200: invokevirtual readRawVarint32 : ()I
    //   203: invokevirtual pushLimit : (I)I
    //   206: istore #5
    //   208: aload_1
    //   209: invokevirtual getBytesUntilLimit : ()I
    //   212: ifle -> 231
    //   215: aload_0
    //   216: getfield requestedStates_ : Lcom/google/protobuf/Internal$IntList;
    //   219: aload_1
    //   220: invokevirtual readEnum : ()I
    //   223: invokeinterface addInt : (I)V
    //   228: goto -> 208
    //   231: aload_1
    //   232: iload #5
    //   234: invokevirtual popLimit : (I)V
    //   237: goto -> 123
    //   240: aload_0
    //   241: getfield requestedStates_ : Lcom/google/protobuf/Internal$IntList;
    //   244: invokeinterface isModifiable : ()Z
    //   249: ifne -> 263
    //   252: aload_0
    //   253: aload_0
    //   254: getfield requestedStates_ : Lcom/google/protobuf/Internal$IntList;
    //   257: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$IntList;)Lcom/google/protobuf/Internal$IntList;
    //   260: putfield requestedStates_ : Lcom/google/protobuf/Internal$IntList;
    //   263: aload_0
    //   264: getfield requestedStates_ : Lcom/google/protobuf/Internal$IntList;
    //   267: aload_1
    //   268: invokevirtual readEnum : ()I
    //   271: invokeinterface addInt : (I)V
    //   276: goto -> 123
    //   279: aload_0
    //   280: aload_1
    //   281: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   284: putfield projectNumber_ : Ljava/lang/String;
    //   287: goto -> 123
    //   290: iconst_1
    //   291: istore #4
    //   293: goto -> 123
    //   296: astore_1
    //   297: goto -> 344
    //   300: astore_3
    //   301: new java/lang/RuntimeException
    //   304: astore_2
    //   305: new com/google/protobuf/InvalidProtocolBufferException
    //   308: astore_1
    //   309: aload_1
    //   310: aload_3
    //   311: invokevirtual getMessage : ()Ljava/lang/String;
    //   314: invokespecial <init> : (Ljava/lang/String;)V
    //   317: aload_2
    //   318: aload_1
    //   319: aload_0
    //   320: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   323: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   326: aload_2
    //   327: athrow
    //   328: astore_1
    //   329: new java/lang/RuntimeException
    //   332: astore_2
    //   333: aload_2
    //   334: aload_1
    //   335: aload_0
    //   336: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   339: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   342: aload_2
    //   343: athrow
    //   344: aload_1
    //   345: athrow
    //   346: getstatic com/google/internal/firebase/inappmessaging/v1/ListCampaignsRequest.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/ListCampaignsRequest;
    //   349: areturn
    //   350: aload_2
    //   351: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   354: astore_1
    //   355: aload_3
    //   356: checkcast com/google/internal/firebase/inappmessaging/v1/ListCampaignsRequest
    //   359: astore_2
    //   360: aload_0
    //   361: aload_1
    //   362: aload_0
    //   363: getfield projectNumber_ : Ljava/lang/String;
    //   366: invokevirtual isEmpty : ()Z
    //   369: iconst_1
    //   370: ixor
    //   371: aload_0
    //   372: getfield projectNumber_ : Ljava/lang/String;
    //   375: iconst_1
    //   376: aload_2
    //   377: getfield projectNumber_ : Ljava/lang/String;
    //   380: invokevirtual isEmpty : ()Z
    //   383: ixor
    //   384: aload_2
    //   385: getfield projectNumber_ : Ljava/lang/String;
    //   388: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   393: putfield projectNumber_ : Ljava/lang/String;
    //   396: aload_0
    //   397: aload_1
    //   398: aload_0
    //   399: getfield requestedStates_ : Lcom/google/protobuf/Internal$IntList;
    //   402: aload_2
    //   403: getfield requestedStates_ : Lcom/google/protobuf/Internal$IntList;
    //   406: invokeinterface visitIntList : (Lcom/google/protobuf/Internal$IntList;Lcom/google/protobuf/Internal$IntList;)Lcom/google/protobuf/Internal$IntList;
    //   411: putfield requestedStates_ : Lcom/google/protobuf/Internal$IntList;
    //   414: aload_1
    //   415: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   418: if_acmpne -> 434
    //   421: aload_0
    //   422: aload_0
    //   423: getfield bitField0_ : I
    //   426: aload_2
    //   427: getfield bitField0_ : I
    //   430: ior
    //   431: putfield bitField0_ : I
    //   434: aload_0
    //   435: areturn
    //   436: new com/google/internal/firebase/inappmessaging/v1/ListCampaignsRequest$Builder
    //   439: dup
    //   440: aconst_null
    //   441: invokespecial <init> : (Lcom/google/internal/firebase/inappmessaging/v1/ListCampaignsRequest$1;)V
    //   444: areturn
    //   445: aload_0
    //   446: getfield requestedStates_ : Lcom/google/protobuf/Internal$IntList;
    //   449: invokeinterface makeImmutable : ()V
    //   454: aconst_null
    //   455: areturn
    //   456: getstatic com/google/internal/firebase/inappmessaging/v1/ListCampaignsRequest.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/ListCampaignsRequest;
    //   459: areturn
    //   460: new com/google/internal/firebase/inappmessaging/v1/ListCampaignsRequest
    //   463: dup
    //   464: invokespecial <init> : ()V
    //   467: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	328	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	300	java/io/IOException
    //   128	134	296	finally
    //   160	169	328	com/google/protobuf/InvalidProtocolBufferException
    //   160	169	300	java/io/IOException
    //   160	169	296	finally
    //   175	198	328	com/google/protobuf/InvalidProtocolBufferException
    //   175	198	300	java/io/IOException
    //   175	198	296	finally
    //   198	208	328	com/google/protobuf/InvalidProtocolBufferException
    //   198	208	300	java/io/IOException
    //   198	208	296	finally
    //   208	228	328	com/google/protobuf/InvalidProtocolBufferException
    //   208	228	300	java/io/IOException
    //   208	228	296	finally
    //   231	237	328	com/google/protobuf/InvalidProtocolBufferException
    //   231	237	300	java/io/IOException
    //   231	237	296	finally
    //   240	263	328	com/google/protobuf/InvalidProtocolBufferException
    //   240	263	300	java/io/IOException
    //   240	263	296	finally
    //   263	276	328	com/google/protobuf/InvalidProtocolBufferException
    //   263	276	300	java/io/IOException
    //   263	276	296	finally
    //   279	287	328	com/google/protobuf/InvalidProtocolBufferException
    //   279	287	300	java/io/IOException
    //   279	287	296	finally
    //   301	328	296	finally
    //   329	344	296	finally
  }
  
  public String getProjectNumber() {
    return this.projectNumber_;
  }
  
  public ByteString getProjectNumberBytes() {
    return ByteString.copyFromUtf8(this.projectNumber_);
  }
  
  public CommonTypesProto.CampaignState getRequestedStates(int paramInt) {
    return (CommonTypesProto.CampaignState)requestedStates_converter_.convert(Integer.valueOf(this.requestedStates_.getInt(paramInt)));
  }
  
  public int getRequestedStatesCount() {
    return this.requestedStates_.size();
  }
  
  public List<CommonTypesProto.CampaignState> getRequestedStatesList() {
    return (List<CommonTypesProto.CampaignState>)new Internal.ListAdapter((List)this.requestedStates_, requestedStates_converter_);
  }
  
  public int getRequestedStatesValue(int paramInt) {
    return this.requestedStates_.getInt(paramInt);
  }
  
  public List<Integer> getRequestedStatesValueList() {
    return (List<Integer>)this.requestedStates_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    boolean bool = this.projectNumber_.isEmpty();
    byte b = 0;
    if (!bool) {
      i = CodedOutputStream.computeStringSize(1, getProjectNumber()) + 0;
    } else {
      i = 0;
    } 
    int j = 0;
    while (b < this.requestedStates_.size()) {
      j += CodedOutputStream.computeEnumSizeNoTag(this.requestedStates_.getInt(b));
      b++;
    } 
    i = i + j + this.requestedStates_.size() * 1;
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    getSerializedSize();
    if (!this.projectNumber_.isEmpty())
      paramCodedOutputStream.writeString(1, getProjectNumber()); 
    for (byte b = 0; b < this.requestedStates_.size(); b++)
      paramCodedOutputStream.writeEnum(2, this.requestedStates_.getInt(b)); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ListCampaignsRequest, Builder> implements ListCampaignsRequestOrBuilder {
    private Builder() {
      super(ListCampaignsRequest.DEFAULT_INSTANCE);
    }
    
    public Builder addAllRequestedStates(Iterable<? extends CommonTypesProto.CampaignState> param1Iterable) {
      copyOnWrite();
      ((ListCampaignsRequest)this.instance).addAllRequestedStates(param1Iterable);
      return this;
    }
    
    public Builder addAllRequestedStatesValue(Iterable<Integer> param1Iterable) {
      copyOnWrite();
      ((ListCampaignsRequest)this.instance).addAllRequestedStatesValue(param1Iterable);
      return this;
    }
    
    public Builder addRequestedStates(CommonTypesProto.CampaignState param1CampaignState) {
      copyOnWrite();
      ((ListCampaignsRequest)this.instance).addRequestedStates(param1CampaignState);
      return this;
    }
    
    public Builder addRequestedStatesValue(int param1Int) {
      ((ListCampaignsRequest)this.instance).addRequestedStatesValue(param1Int);
      return this;
    }
    
    public Builder clearProjectNumber() {
      copyOnWrite();
      ((ListCampaignsRequest)this.instance).clearProjectNumber();
      return this;
    }
    
    public Builder clearRequestedStates() {
      copyOnWrite();
      ((ListCampaignsRequest)this.instance).clearRequestedStates();
      return this;
    }
    
    public String getProjectNumber() {
      return ((ListCampaignsRequest)this.instance).getProjectNumber();
    }
    
    public ByteString getProjectNumberBytes() {
      return ((ListCampaignsRequest)this.instance).getProjectNumberBytes();
    }
    
    public CommonTypesProto.CampaignState getRequestedStates(int param1Int) {
      return ((ListCampaignsRequest)this.instance).getRequestedStates(param1Int);
    }
    
    public int getRequestedStatesCount() {
      return ((ListCampaignsRequest)this.instance).getRequestedStatesCount();
    }
    
    public List<CommonTypesProto.CampaignState> getRequestedStatesList() {
      return ((ListCampaignsRequest)this.instance).getRequestedStatesList();
    }
    
    public int getRequestedStatesValue(int param1Int) {
      return ((ListCampaignsRequest)this.instance).getRequestedStatesValue(param1Int);
    }
    
    public List<Integer> getRequestedStatesValueList() {
      return Collections.unmodifiableList(((ListCampaignsRequest)this.instance).getRequestedStatesValueList());
    }
    
    public Builder setProjectNumber(String param1String) {
      copyOnWrite();
      ((ListCampaignsRequest)this.instance).setProjectNumber(param1String);
      return this;
    }
    
    public Builder setProjectNumberBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ListCampaignsRequest)this.instance).setProjectNumberBytes(param1ByteString);
      return this;
    }
    
    public Builder setRequestedStates(int param1Int, CommonTypesProto.CampaignState param1CampaignState) {
      copyOnWrite();
      ((ListCampaignsRequest)this.instance).setRequestedStates(param1Int, param1CampaignState);
      return this;
    }
    
    public Builder setRequestedStatesValue(int param1Int1, int param1Int2) {
      copyOnWrite();
      ((ListCampaignsRequest)this.instance).setRequestedStatesValue(param1Int1, param1Int2);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\internal\firebase\inappmessaging\v1\ListCampaignsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */