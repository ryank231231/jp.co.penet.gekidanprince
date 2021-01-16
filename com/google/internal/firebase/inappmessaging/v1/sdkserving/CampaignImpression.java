package com.google.internal.firebase.inappmessaging.v1.sdkserving;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class CampaignImpression extends GeneratedMessageLite<CampaignImpression, CampaignImpression.Builder> implements CampaignImpressionOrBuilder {
  public static final int CAMPAIGN_ID_FIELD_NUMBER = 1;
  
  private static final CampaignImpression DEFAULT_INSTANCE = new CampaignImpression();
  
  public static final int IMPRESSION_TIMESTAMP_MILLIS_FIELD_NUMBER = 2;
  
  private static volatile Parser<CampaignImpression> PARSER;
  
  private String campaignId_ = "";
  
  private long impressionTimestampMillis_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearCampaignId() {
    this.campaignId_ = getDefaultInstance().getCampaignId();
  }
  
  private void clearImpressionTimestampMillis() {
    this.impressionTimestampMillis_ = 0L;
  }
  
  public static CampaignImpression getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(CampaignImpression paramCampaignImpression) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramCampaignImpression);
  }
  
  public static CampaignImpression parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (CampaignImpression)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static CampaignImpression parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (CampaignImpression)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static CampaignImpression parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (CampaignImpression)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static CampaignImpression parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (CampaignImpression)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static CampaignImpression parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (CampaignImpression)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static CampaignImpression parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (CampaignImpression)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static CampaignImpression parseFrom(InputStream paramInputStream) throws IOException {
    return (CampaignImpression)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static CampaignImpression parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (CampaignImpression)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static CampaignImpression parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (CampaignImpression)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static CampaignImpression parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (CampaignImpression)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<CampaignImpression> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setCampaignId(String paramString) {
    if (paramString != null) {
      this.campaignId_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setCampaignIdBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.campaignId_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setImpressionTimestampMillis(long paramLong) {
    this.impressionTimestampMillis_ = paramLong;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/CampaignImpression$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iload #4
    //   15: tableswitch default -> 60, 1 -> 380, 2 -> 376, 3 -> 374, 4 -> 365, 5 -> 251, 6 -> 114, 7 -> 247, 8 -> 68
    //   60: new java/lang/UnsupportedOperationException
    //   63: dup
    //   64: invokespecial <init> : ()V
    //   67: athrow
    //   68: getstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/CampaignImpression.PARSER : Lcom/google/protobuf/Parser;
    //   71: ifnonnull -> 110
    //   74: ldc com/google/internal/firebase/inappmessaging/v1/sdkserving/CampaignImpression
    //   76: monitorenter
    //   77: getstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/CampaignImpression.PARSER : Lcom/google/protobuf/Parser;
    //   80: ifnonnull -> 98
    //   83: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   86: astore_1
    //   87: aload_1
    //   88: getstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/CampaignImpression.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/sdkserving/CampaignImpression;
    //   91: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   94: aload_1
    //   95: putstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/CampaignImpression.PARSER : Lcom/google/protobuf/Parser;
    //   98: ldc com/google/internal/firebase/inappmessaging/v1/sdkserving/CampaignImpression
    //   100: monitorexit
    //   101: goto -> 110
    //   104: astore_1
    //   105: ldc com/google/internal/firebase/inappmessaging/v1/sdkserving/CampaignImpression
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    //   110: getstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/CampaignImpression.PARSER : Lcom/google/protobuf/Parser;
    //   113: areturn
    //   114: aload_2
    //   115: checkcast com/google/protobuf/CodedInputStream
    //   118: astore_1
    //   119: aload_3
    //   120: checkcast com/google/protobuf/ExtensionRegistryLite
    //   123: astore_2
    //   124: iload #5
    //   126: ifne -> 247
    //   129: aload_1
    //   130: invokevirtual readTag : ()I
    //   133: istore #4
    //   135: iload #4
    //   137: ifeq -> 191
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
    //   174: putfield impressionTimestampMillis_ : J
    //   177: goto -> 124
    //   180: aload_0
    //   181: aload_1
    //   182: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   185: putfield campaignId_ : Ljava/lang/String;
    //   188: goto -> 124
    //   191: iconst_1
    //   192: istore #5
    //   194: goto -> 124
    //   197: astore_1
    //   198: goto -> 245
    //   201: astore_1
    //   202: new java/lang/RuntimeException
    //   205: astore_2
    //   206: new com/google/protobuf/InvalidProtocolBufferException
    //   209: astore_3
    //   210: aload_3
    //   211: aload_1
    //   212: invokevirtual getMessage : ()Ljava/lang/String;
    //   215: invokespecial <init> : (Ljava/lang/String;)V
    //   218: aload_2
    //   219: aload_3
    //   220: aload_0
    //   221: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   224: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   227: aload_2
    //   228: athrow
    //   229: astore_1
    //   230: new java/lang/RuntimeException
    //   233: astore_2
    //   234: aload_2
    //   235: aload_1
    //   236: aload_0
    //   237: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   240: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   243: aload_2
    //   244: athrow
    //   245: aload_1
    //   246: athrow
    //   247: getstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/CampaignImpression.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/sdkserving/CampaignImpression;
    //   250: areturn
    //   251: aload_2
    //   252: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   255: astore_1
    //   256: aload_3
    //   257: checkcast com/google/internal/firebase/inappmessaging/v1/sdkserving/CampaignImpression
    //   260: astore_2
    //   261: aload_0
    //   262: aload_1
    //   263: aload_0
    //   264: getfield campaignId_ : Ljava/lang/String;
    //   267: invokevirtual isEmpty : ()Z
    //   270: iconst_1
    //   271: ixor
    //   272: aload_0
    //   273: getfield campaignId_ : Ljava/lang/String;
    //   276: aload_2
    //   277: getfield campaignId_ : Ljava/lang/String;
    //   280: invokevirtual isEmpty : ()Z
    //   283: iconst_1
    //   284: ixor
    //   285: aload_2
    //   286: getfield campaignId_ : Ljava/lang/String;
    //   289: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   294: putfield campaignId_ : Ljava/lang/String;
    //   297: aload_0
    //   298: getfield impressionTimestampMillis_ : J
    //   301: lconst_0
    //   302: lcmp
    //   303: ifeq -> 312
    //   306: iconst_1
    //   307: istore #6
    //   309: goto -> 315
    //   312: iconst_0
    //   313: istore #6
    //   315: aload_0
    //   316: getfield impressionTimestampMillis_ : J
    //   319: lstore #7
    //   321: aload_2
    //   322: getfield impressionTimestampMillis_ : J
    //   325: lconst_0
    //   326: lcmp
    //   327: ifeq -> 336
    //   330: iconst_1
    //   331: istore #9
    //   333: goto -> 339
    //   336: iconst_0
    //   337: istore #9
    //   339: aload_0
    //   340: aload_1
    //   341: iload #6
    //   343: lload #7
    //   345: iload #9
    //   347: aload_2
    //   348: getfield impressionTimestampMillis_ : J
    //   351: invokeinterface visitLong : (ZJZJ)J
    //   356: putfield impressionTimestampMillis_ : J
    //   359: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   362: astore_1
    //   363: aload_0
    //   364: areturn
    //   365: new com/google/internal/firebase/inappmessaging/v1/sdkserving/CampaignImpression$Builder
    //   368: dup
    //   369: aconst_null
    //   370: invokespecial <init> : (Lcom/google/internal/firebase/inappmessaging/v1/sdkserving/CampaignImpression$1;)V
    //   373: areturn
    //   374: aconst_null
    //   375: areturn
    //   376: getstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/CampaignImpression.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/sdkserving/CampaignImpression;
    //   379: areturn
    //   380: new com/google/internal/firebase/inappmessaging/v1/sdkserving/CampaignImpression
    //   383: dup
    //   384: invokespecial <init> : ()V
    //   387: areturn
    // Exception table:
    //   from	to	target	type
    //   77	98	104	finally
    //   98	101	104	finally
    //   105	108	104	finally
    //   129	135	229	com/google/protobuf/InvalidProtocolBufferException
    //   129	135	201	java/io/IOException
    //   129	135	197	finally
    //   154	163	229	com/google/protobuf/InvalidProtocolBufferException
    //   154	163	201	java/io/IOException
    //   154	163	197	finally
    //   169	177	229	com/google/protobuf/InvalidProtocolBufferException
    //   169	177	201	java/io/IOException
    //   169	177	197	finally
    //   180	188	229	com/google/protobuf/InvalidProtocolBufferException
    //   180	188	201	java/io/IOException
    //   180	188	197	finally
    //   202	229	197	finally
    //   230	245	197	finally
  }
  
  public String getCampaignId() {
    return this.campaignId_;
  }
  
  public ByteString getCampaignIdBytes() {
    return ByteString.copyFromUtf8(this.campaignId_);
  }
  
  public long getImpressionTimestampMillis() {
    return this.impressionTimestampMillis_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!this.campaignId_.isEmpty())
      i = 0 + CodedOutputStream.computeStringSize(1, getCampaignId()); 
    long l = this.impressionTimestampMillis_;
    int j = i;
    if (l != 0L)
      j = i + CodedOutputStream.computeInt64Size(2, l); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.campaignId_.isEmpty())
      paramCodedOutputStream.writeString(1, getCampaignId()); 
    long l = this.impressionTimestampMillis_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(2, l); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<CampaignImpression, Builder> implements CampaignImpressionOrBuilder {
    private Builder() {
      super(CampaignImpression.DEFAULT_INSTANCE);
    }
    
    public Builder clearCampaignId() {
      copyOnWrite();
      ((CampaignImpression)this.instance).clearCampaignId();
      return this;
    }
    
    public Builder clearImpressionTimestampMillis() {
      copyOnWrite();
      ((CampaignImpression)this.instance).clearImpressionTimestampMillis();
      return this;
    }
    
    public String getCampaignId() {
      return ((CampaignImpression)this.instance).getCampaignId();
    }
    
    public ByteString getCampaignIdBytes() {
      return ((CampaignImpression)this.instance).getCampaignIdBytes();
    }
    
    public long getImpressionTimestampMillis() {
      return ((CampaignImpression)this.instance).getImpressionTimestampMillis();
    }
    
    public Builder setCampaignId(String param1String) {
      copyOnWrite();
      ((CampaignImpression)this.instance).setCampaignId(param1String);
      return this;
    }
    
    public Builder setCampaignIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((CampaignImpression)this.instance).setCampaignIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setImpressionTimestampMillis(long param1Long) {
      copyOnWrite();
      ((CampaignImpression)this.instance).setImpressionTimestampMillis(param1Long);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\internal\firebase\inappmessaging\v1\sdkserving\CampaignImpression.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */