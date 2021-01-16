package com.google.internal.firebase.inappmessaging.v1.sdkserving;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
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

public final class FetchEligibleCampaignsResponse extends GeneratedMessageLite<FetchEligibleCampaignsResponse, FetchEligibleCampaignsResponse.Builder> implements FetchEligibleCampaignsResponseOrBuilder {
  private static final FetchEligibleCampaignsResponse DEFAULT_INSTANCE = new FetchEligibleCampaignsResponse();
  
  public static final int EXPIRATION_EPOCH_TIMESTAMP_MILLIS_FIELD_NUMBER = 2;
  
  public static final int MESSAGES_FIELD_NUMBER = 1;
  
  private static volatile Parser<FetchEligibleCampaignsResponse> PARSER;
  
  private int bitField0_;
  
  private long expirationEpochTimestampMillis_;
  
  private Internal.ProtobufList<CampaignProto.ThickContent> messages_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllMessages(Iterable<? extends CampaignProto.ThickContent> paramIterable) {
    ensureMessagesIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.messages_);
  }
  
  private void addMessages(int paramInt, CampaignProto.ThickContent.Builder paramBuilder) {
    ensureMessagesIsMutable();
    this.messages_.add(paramInt, paramBuilder.build());
  }
  
  private void addMessages(int paramInt, CampaignProto.ThickContent paramThickContent) {
    if (paramThickContent != null) {
      ensureMessagesIsMutable();
      this.messages_.add(paramInt, paramThickContent);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addMessages(CampaignProto.ThickContent.Builder paramBuilder) {
    ensureMessagesIsMutable();
    this.messages_.add(paramBuilder.build());
  }
  
  private void addMessages(CampaignProto.ThickContent paramThickContent) {
    if (paramThickContent != null) {
      ensureMessagesIsMutable();
      this.messages_.add(paramThickContent);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearExpirationEpochTimestampMillis() {
    this.expirationEpochTimestampMillis_ = 0L;
  }
  
  private void clearMessages() {
    this.messages_ = emptyProtobufList();
  }
  
  private void ensureMessagesIsMutable() {
    if (!this.messages_.isModifiable())
      this.messages_ = GeneratedMessageLite.mutableCopy(this.messages_); 
  }
  
  public static FetchEligibleCampaignsResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(FetchEligibleCampaignsResponse paramFetchEligibleCampaignsResponse) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramFetchEligibleCampaignsResponse);
  }
  
  public static FetchEligibleCampaignsResponse parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (FetchEligibleCampaignsResponse)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static FetchEligibleCampaignsResponse parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (FetchEligibleCampaignsResponse)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FetchEligibleCampaignsResponse parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (FetchEligibleCampaignsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static FetchEligibleCampaignsResponse parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (FetchEligibleCampaignsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static FetchEligibleCampaignsResponse parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (FetchEligibleCampaignsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static FetchEligibleCampaignsResponse parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (FetchEligibleCampaignsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static FetchEligibleCampaignsResponse parseFrom(InputStream paramInputStream) throws IOException {
    return (FetchEligibleCampaignsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static FetchEligibleCampaignsResponse parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (FetchEligibleCampaignsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FetchEligibleCampaignsResponse parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (FetchEligibleCampaignsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static FetchEligibleCampaignsResponse parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (FetchEligibleCampaignsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<FetchEligibleCampaignsResponse> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeMessages(int paramInt) {
    ensureMessagesIsMutable();
    this.messages_.remove(paramInt);
  }
  
  private void setExpirationEpochTimestampMillis(long paramLong) {
    this.expirationEpochTimestampMillis_ = paramLong;
  }
  
  private void setMessages(int paramInt, CampaignProto.ThickContent.Builder paramBuilder) {
    ensureMessagesIsMutable();
    this.messages_.set(paramInt, paramBuilder.build());
  }
  
  private void setMessages(int paramInt, CampaignProto.ThickContent paramThickContent) {
    if (paramThickContent != null) {
      ensureMessagesIsMutable();
      this.messages_.set(paramInt, paramThickContent);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsResponse$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iload #4
    //   15: tableswitch default -> 60, 1 -> 423, 2 -> 419, 3 -> 408, 4 -> 399, 5 -> 287, 6 -> 114, 7 -> 283, 8 -> 68
    //   60: new java/lang/UnsupportedOperationException
    //   63: dup
    //   64: invokespecial <init> : ()V
    //   67: athrow
    //   68: getstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsResponse.PARSER : Lcom/google/protobuf/Parser;
    //   71: ifnonnull -> 110
    //   74: ldc com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsResponse
    //   76: monitorenter
    //   77: getstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsResponse.PARSER : Lcom/google/protobuf/Parser;
    //   80: ifnonnull -> 98
    //   83: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   86: astore_1
    //   87: aload_1
    //   88: getstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsResponse.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsResponse;
    //   91: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   94: aload_1
    //   95: putstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsResponse.PARSER : Lcom/google/protobuf/Parser;
    //   98: ldc com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsResponse
    //   100: monitorexit
    //   101: goto -> 110
    //   104: astore_1
    //   105: ldc com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsResponse
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    //   110: getstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsResponse.PARSER : Lcom/google/protobuf/Parser;
    //   113: areturn
    //   114: aload_2
    //   115: checkcast com/google/protobuf/CodedInputStream
    //   118: astore_1
    //   119: aload_3
    //   120: checkcast com/google/protobuf/ExtensionRegistryLite
    //   123: astore_2
    //   124: iload #5
    //   126: ifne -> 283
    //   129: aload_1
    //   130: invokevirtual readTag : ()I
    //   133: istore #4
    //   135: iload #4
    //   137: ifeq -> 227
    //   140: iload #4
    //   142: bipush #10
    //   144: if_icmpeq -> 180
    //   147: iload #4
    //   149: bipush #16
    //   151: if_icmpeq -> 169
    //   154: aload_1
    //   155: iload #4
    //   157: invokevirtual skipField : (I)Z
    //   160: ifne -> 124
    //   163: iconst_1
    //   164: istore #5
    //   166: goto -> 124
    //   169: aload_0
    //   170: aload_1
    //   171: invokevirtual readInt64 : ()J
    //   174: putfield expirationEpochTimestampMillis_ : J
    //   177: goto -> 124
    //   180: aload_0
    //   181: getfield messages_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   184: invokeinterface isModifiable : ()Z
    //   189: ifne -> 203
    //   192: aload_0
    //   193: aload_0
    //   194: getfield messages_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   197: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   200: putfield messages_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   203: aload_0
    //   204: getfield messages_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   207: aload_1
    //   208: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   211: aload_2
    //   212: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   215: checkcast com/google/internal/firebase/inappmessaging/v1/CampaignProto$ThickContent
    //   218: invokeinterface add : (Ljava/lang/Object;)Z
    //   223: pop
    //   224: goto -> 124
    //   227: iconst_1
    //   228: istore #5
    //   230: goto -> 124
    //   233: astore_1
    //   234: goto -> 281
    //   237: astore_1
    //   238: new java/lang/RuntimeException
    //   241: astore_3
    //   242: new com/google/protobuf/InvalidProtocolBufferException
    //   245: astore_2
    //   246: aload_2
    //   247: aload_1
    //   248: invokevirtual getMessage : ()Ljava/lang/String;
    //   251: invokespecial <init> : (Ljava/lang/String;)V
    //   254: aload_3
    //   255: aload_2
    //   256: aload_0
    //   257: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   260: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   263: aload_3
    //   264: athrow
    //   265: astore_1
    //   266: new java/lang/RuntimeException
    //   269: astore_2
    //   270: aload_2
    //   271: aload_1
    //   272: aload_0
    //   273: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   276: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   279: aload_2
    //   280: athrow
    //   281: aload_1
    //   282: athrow
    //   283: getstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsResponse.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsResponse;
    //   286: areturn
    //   287: aload_2
    //   288: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   291: astore_1
    //   292: aload_3
    //   293: checkcast com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsResponse
    //   296: astore_2
    //   297: aload_0
    //   298: aload_1
    //   299: aload_0
    //   300: getfield messages_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   303: aload_2
    //   304: getfield messages_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   307: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   312: putfield messages_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   315: aload_0
    //   316: getfield expirationEpochTimestampMillis_ : J
    //   319: lconst_0
    //   320: lcmp
    //   321: ifeq -> 330
    //   324: iconst_1
    //   325: istore #6
    //   327: goto -> 333
    //   330: iconst_0
    //   331: istore #6
    //   333: aload_0
    //   334: getfield expirationEpochTimestampMillis_ : J
    //   337: lstore #7
    //   339: aload_2
    //   340: getfield expirationEpochTimestampMillis_ : J
    //   343: lconst_0
    //   344: lcmp
    //   345: ifeq -> 354
    //   348: iconst_1
    //   349: istore #9
    //   351: goto -> 357
    //   354: iconst_0
    //   355: istore #9
    //   357: aload_0
    //   358: aload_1
    //   359: iload #6
    //   361: lload #7
    //   363: iload #9
    //   365: aload_2
    //   366: getfield expirationEpochTimestampMillis_ : J
    //   369: invokeinterface visitLong : (ZJZJ)J
    //   374: putfield expirationEpochTimestampMillis_ : J
    //   377: aload_1
    //   378: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   381: if_acmpne -> 397
    //   384: aload_0
    //   385: aload_0
    //   386: getfield bitField0_ : I
    //   389: aload_2
    //   390: getfield bitField0_ : I
    //   393: ior
    //   394: putfield bitField0_ : I
    //   397: aload_0
    //   398: areturn
    //   399: new com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsResponse$Builder
    //   402: dup
    //   403: aconst_null
    //   404: invokespecial <init> : (Lcom/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsResponse$1;)V
    //   407: areturn
    //   408: aload_0
    //   409: getfield messages_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   412: invokeinterface makeImmutable : ()V
    //   417: aconst_null
    //   418: areturn
    //   419: getstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsResponse.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsResponse;
    //   422: areturn
    //   423: new com/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsResponse
    //   426: dup
    //   427: invokespecial <init> : ()V
    //   430: areturn
    // Exception table:
    //   from	to	target	type
    //   77	98	104	finally
    //   98	101	104	finally
    //   105	108	104	finally
    //   129	135	265	com/google/protobuf/InvalidProtocolBufferException
    //   129	135	237	java/io/IOException
    //   129	135	233	finally
    //   154	163	265	com/google/protobuf/InvalidProtocolBufferException
    //   154	163	237	java/io/IOException
    //   154	163	233	finally
    //   169	177	265	com/google/protobuf/InvalidProtocolBufferException
    //   169	177	237	java/io/IOException
    //   169	177	233	finally
    //   180	203	265	com/google/protobuf/InvalidProtocolBufferException
    //   180	203	237	java/io/IOException
    //   180	203	233	finally
    //   203	224	265	com/google/protobuf/InvalidProtocolBufferException
    //   203	224	237	java/io/IOException
    //   203	224	233	finally
    //   238	265	233	finally
    //   266	281	233	finally
  }
  
  public long getExpirationEpochTimestampMillis() {
    return this.expirationEpochTimestampMillis_;
  }
  
  public CampaignProto.ThickContent getMessages(int paramInt) {
    return (CampaignProto.ThickContent)this.messages_.get(paramInt);
  }
  
  public int getMessagesCount() {
    return this.messages_.size();
  }
  
  public List<CampaignProto.ThickContent> getMessagesList() {
    return (List<CampaignProto.ThickContent>)this.messages_;
  }
  
  public CampaignProto.ThickContentOrBuilder getMessagesOrBuilder(int paramInt) {
    return (CampaignProto.ThickContentOrBuilder)this.messages_.get(paramInt);
  }
  
  public List<? extends CampaignProto.ThickContentOrBuilder> getMessagesOrBuilderList() {
    return (List)this.messages_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    i = 0;
    while (j < this.messages_.size()) {
      i += CodedOutputStream.computeMessageSize(1, (MessageLite)this.messages_.get(j));
      j++;
    } 
    long l = this.expirationEpochTimestampMillis_;
    j = i;
    if (l != 0L)
      j = i + CodedOutputStream.computeInt64Size(2, l); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (byte b = 0; b < this.messages_.size(); b++)
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.messages_.get(b)); 
    long l = this.expirationEpochTimestampMillis_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(2, l); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<FetchEligibleCampaignsResponse, Builder> implements FetchEligibleCampaignsResponseOrBuilder {
    private Builder() {
      super(FetchEligibleCampaignsResponse.DEFAULT_INSTANCE);
    }
    
    public Builder addAllMessages(Iterable<? extends CampaignProto.ThickContent> param1Iterable) {
      copyOnWrite();
      ((FetchEligibleCampaignsResponse)this.instance).addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addMessages(int param1Int, CampaignProto.ThickContent.Builder param1Builder) {
      copyOnWrite();
      ((FetchEligibleCampaignsResponse)this.instance).addMessages(param1Int, param1Builder);
      return this;
    }
    
    public Builder addMessages(int param1Int, CampaignProto.ThickContent param1ThickContent) {
      copyOnWrite();
      ((FetchEligibleCampaignsResponse)this.instance).addMessages(param1Int, param1ThickContent);
      return this;
    }
    
    public Builder addMessages(CampaignProto.ThickContent.Builder param1Builder) {
      copyOnWrite();
      ((FetchEligibleCampaignsResponse)this.instance).addMessages(param1Builder);
      return this;
    }
    
    public Builder addMessages(CampaignProto.ThickContent param1ThickContent) {
      copyOnWrite();
      ((FetchEligibleCampaignsResponse)this.instance).addMessages(param1ThickContent);
      return this;
    }
    
    public Builder clearExpirationEpochTimestampMillis() {
      copyOnWrite();
      ((FetchEligibleCampaignsResponse)this.instance).clearExpirationEpochTimestampMillis();
      return this;
    }
    
    public Builder clearMessages() {
      copyOnWrite();
      ((FetchEligibleCampaignsResponse)this.instance).clearMessages();
      return this;
    }
    
    public long getExpirationEpochTimestampMillis() {
      return ((FetchEligibleCampaignsResponse)this.instance).getExpirationEpochTimestampMillis();
    }
    
    public CampaignProto.ThickContent getMessages(int param1Int) {
      return ((FetchEligibleCampaignsResponse)this.instance).getMessages(param1Int);
    }
    
    public int getMessagesCount() {
      return ((FetchEligibleCampaignsResponse)this.instance).getMessagesCount();
    }
    
    public List<CampaignProto.ThickContent> getMessagesList() {
      return Collections.unmodifiableList(((FetchEligibleCampaignsResponse)this.instance).getMessagesList());
    }
    
    public Builder removeMessages(int param1Int) {
      copyOnWrite();
      ((FetchEligibleCampaignsResponse)this.instance).removeMessages(param1Int);
      return this;
    }
    
    public Builder setExpirationEpochTimestampMillis(long param1Long) {
      copyOnWrite();
      ((FetchEligibleCampaignsResponse)this.instance).setExpirationEpochTimestampMillis(param1Long);
      return this;
    }
    
    public Builder setMessages(int param1Int, CampaignProto.ThickContent.Builder param1Builder) {
      copyOnWrite();
      ((FetchEligibleCampaignsResponse)this.instance).setMessages(param1Int, param1Builder);
      return this;
    }
    
    public Builder setMessages(int param1Int, CampaignProto.ThickContent param1ThickContent) {
      copyOnWrite();
      ((FetchEligibleCampaignsResponse)this.instance).setMessages(param1Int, param1ThickContent);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\internal\firebase\inappmessaging\v1\sdkserving\FetchEligibleCampaignsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */