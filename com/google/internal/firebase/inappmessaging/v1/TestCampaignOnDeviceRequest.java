package com.google.internal.firebase.inappmessaging.v1;

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

public final class TestCampaignOnDeviceRequest extends GeneratedMessageLite<TestCampaignOnDeviceRequest, TestCampaignOnDeviceRequest.Builder> implements TestCampaignOnDeviceRequestOrBuilder {
  public static final int CAMPAIGN_ID_FIELD_NUMBER = 2;
  
  private static final TestCampaignOnDeviceRequest DEFAULT_INSTANCE = new TestCampaignOnDeviceRequest();
  
  public static final int INSTANCE_IDS_FIELD_NUMBER = 3;
  
  private static volatile Parser<TestCampaignOnDeviceRequest> PARSER;
  
  public static final int PROJECT_NUMBER_FIELD_NUMBER = 1;
  
  private int bitField0_;
  
  private String campaignId_ = "";
  
  private Internal.ProtobufList<String> instanceIds_ = GeneratedMessageLite.emptyProtobufList();
  
  private String projectNumber_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllInstanceIds(Iterable<String> paramIterable) {
    ensureInstanceIdsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.instanceIds_);
  }
  
  private void addInstanceIds(String paramString) {
    if (paramString != null) {
      ensureInstanceIdsIsMutable();
      this.instanceIds_.add(paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addInstanceIdsBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      ensureInstanceIdsIsMutable();
      this.instanceIds_.add(paramByteString.toStringUtf8());
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearCampaignId() {
    this.campaignId_ = getDefaultInstance().getCampaignId();
  }
  
  private void clearInstanceIds() {
    this.instanceIds_ = GeneratedMessageLite.emptyProtobufList();
  }
  
  private void clearProjectNumber() {
    this.projectNumber_ = getDefaultInstance().getProjectNumber();
  }
  
  private void ensureInstanceIdsIsMutable() {
    if (!this.instanceIds_.isModifiable())
      this.instanceIds_ = GeneratedMessageLite.mutableCopy(this.instanceIds_); 
  }
  
  public static TestCampaignOnDeviceRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(TestCampaignOnDeviceRequest paramTestCampaignOnDeviceRequest) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramTestCampaignOnDeviceRequest);
  }
  
  public static TestCampaignOnDeviceRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (TestCampaignOnDeviceRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static TestCampaignOnDeviceRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (TestCampaignOnDeviceRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static TestCampaignOnDeviceRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (TestCampaignOnDeviceRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static TestCampaignOnDeviceRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (TestCampaignOnDeviceRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static TestCampaignOnDeviceRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (TestCampaignOnDeviceRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static TestCampaignOnDeviceRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (TestCampaignOnDeviceRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static TestCampaignOnDeviceRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (TestCampaignOnDeviceRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static TestCampaignOnDeviceRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (TestCampaignOnDeviceRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static TestCampaignOnDeviceRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (TestCampaignOnDeviceRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static TestCampaignOnDeviceRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (TestCampaignOnDeviceRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<TestCampaignOnDeviceRequest> parser() {
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
  
  private void setInstanceIds(int paramInt, String paramString) {
    if (paramString != null) {
      ensureInstanceIdsIsMutable();
      this.instanceIds_.set(paramInt, paramString);
      return;
    } 
    throw new NullPointerException();
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
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/internal/firebase/inappmessaging/v1/TestCampaignOnDeviceRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 445, 2 -> 441, 3 -> 430, 4 -> 421, 5 -> 299, 6 -> 110, 7 -> 295, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/internal/firebase/inappmessaging/v1/TestCampaignOnDeviceRequest.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/internal/firebase/inappmessaging/v1/TestCampaignOnDeviceRequest
    //   72: monitorenter
    //   73: getstatic com/google/internal/firebase/inappmessaging/v1/TestCampaignOnDeviceRequest.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/internal/firebase/inappmessaging/v1/TestCampaignOnDeviceRequest.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/TestCampaignOnDeviceRequest;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/internal/firebase/inappmessaging/v1/TestCampaignOnDeviceRequest.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/internal/firebase/inappmessaging/v1/TestCampaignOnDeviceRequest
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/internal/firebase/inappmessaging/v1/TestCampaignOnDeviceRequest
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/internal/firebase/inappmessaging/v1/TestCampaignOnDeviceRequest.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 295
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 239
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 228
    //   146: iload #5
    //   148: bipush #18
    //   150: if_icmpeq -> 217
    //   153: iload #5
    //   155: bipush #26
    //   157: if_icmpeq -> 175
    //   160: aload_1
    //   161: iload #5
    //   163: invokevirtual skipField : (I)Z
    //   166: ifne -> 123
    //   169: iconst_1
    //   170: istore #4
    //   172: goto -> 123
    //   175: aload_1
    //   176: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   179: astore_2
    //   180: aload_0
    //   181: getfield instanceIds_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   184: invokeinterface isModifiable : ()Z
    //   189: ifne -> 203
    //   192: aload_0
    //   193: aload_0
    //   194: getfield instanceIds_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   197: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   200: putfield instanceIds_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   203: aload_0
    //   204: getfield instanceIds_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   207: aload_2
    //   208: invokeinterface add : (Ljava/lang/Object;)Z
    //   213: pop
    //   214: goto -> 123
    //   217: aload_0
    //   218: aload_1
    //   219: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   222: putfield campaignId_ : Ljava/lang/String;
    //   225: goto -> 123
    //   228: aload_0
    //   229: aload_1
    //   230: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   233: putfield projectNumber_ : Ljava/lang/String;
    //   236: goto -> 123
    //   239: iconst_1
    //   240: istore #4
    //   242: goto -> 123
    //   245: astore_1
    //   246: goto -> 293
    //   249: astore_1
    //   250: new java/lang/RuntimeException
    //   253: astore_2
    //   254: new com/google/protobuf/InvalidProtocolBufferException
    //   257: astore_3
    //   258: aload_3
    //   259: aload_1
    //   260: invokevirtual getMessage : ()Ljava/lang/String;
    //   263: invokespecial <init> : (Ljava/lang/String;)V
    //   266: aload_2
    //   267: aload_3
    //   268: aload_0
    //   269: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   272: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   275: aload_2
    //   276: athrow
    //   277: astore_2
    //   278: new java/lang/RuntimeException
    //   281: astore_1
    //   282: aload_1
    //   283: aload_2
    //   284: aload_0
    //   285: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   288: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   291: aload_1
    //   292: athrow
    //   293: aload_1
    //   294: athrow
    //   295: getstatic com/google/internal/firebase/inappmessaging/v1/TestCampaignOnDeviceRequest.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/TestCampaignOnDeviceRequest;
    //   298: areturn
    //   299: aload_2
    //   300: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   303: astore_1
    //   304: aload_3
    //   305: checkcast com/google/internal/firebase/inappmessaging/v1/TestCampaignOnDeviceRequest
    //   308: astore_2
    //   309: aload_0
    //   310: aload_1
    //   311: aload_0
    //   312: getfield projectNumber_ : Ljava/lang/String;
    //   315: invokevirtual isEmpty : ()Z
    //   318: iconst_1
    //   319: ixor
    //   320: aload_0
    //   321: getfield projectNumber_ : Ljava/lang/String;
    //   324: aload_2
    //   325: getfield projectNumber_ : Ljava/lang/String;
    //   328: invokevirtual isEmpty : ()Z
    //   331: iconst_1
    //   332: ixor
    //   333: aload_2
    //   334: getfield projectNumber_ : Ljava/lang/String;
    //   337: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   342: putfield projectNumber_ : Ljava/lang/String;
    //   345: aload_0
    //   346: aload_1
    //   347: aload_0
    //   348: getfield campaignId_ : Ljava/lang/String;
    //   351: invokevirtual isEmpty : ()Z
    //   354: iconst_1
    //   355: ixor
    //   356: aload_0
    //   357: getfield campaignId_ : Ljava/lang/String;
    //   360: iconst_1
    //   361: aload_2
    //   362: getfield campaignId_ : Ljava/lang/String;
    //   365: invokevirtual isEmpty : ()Z
    //   368: ixor
    //   369: aload_2
    //   370: getfield campaignId_ : Ljava/lang/String;
    //   373: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   378: putfield campaignId_ : Ljava/lang/String;
    //   381: aload_0
    //   382: aload_1
    //   383: aload_0
    //   384: getfield instanceIds_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   387: aload_2
    //   388: getfield instanceIds_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   391: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   396: putfield instanceIds_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   399: aload_1
    //   400: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   403: if_acmpne -> 419
    //   406: aload_0
    //   407: aload_0
    //   408: getfield bitField0_ : I
    //   411: aload_2
    //   412: getfield bitField0_ : I
    //   415: ior
    //   416: putfield bitField0_ : I
    //   419: aload_0
    //   420: areturn
    //   421: new com/google/internal/firebase/inappmessaging/v1/TestCampaignOnDeviceRequest$Builder
    //   424: dup
    //   425: aconst_null
    //   426: invokespecial <init> : (Lcom/google/internal/firebase/inappmessaging/v1/TestCampaignOnDeviceRequest$1;)V
    //   429: areturn
    //   430: aload_0
    //   431: getfield instanceIds_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   434: invokeinterface makeImmutable : ()V
    //   439: aconst_null
    //   440: areturn
    //   441: getstatic com/google/internal/firebase/inappmessaging/v1/TestCampaignOnDeviceRequest.DEFAULT_INSTANCE : Lcom/google/internal/firebase/inappmessaging/v1/TestCampaignOnDeviceRequest;
    //   444: areturn
    //   445: new com/google/internal/firebase/inappmessaging/v1/TestCampaignOnDeviceRequest
    //   448: dup
    //   449: invokespecial <init> : ()V
    //   452: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	277	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	249	java/io/IOException
    //   128	134	245	finally
    //   160	169	277	com/google/protobuf/InvalidProtocolBufferException
    //   160	169	249	java/io/IOException
    //   160	169	245	finally
    //   175	203	277	com/google/protobuf/InvalidProtocolBufferException
    //   175	203	249	java/io/IOException
    //   175	203	245	finally
    //   203	214	277	com/google/protobuf/InvalidProtocolBufferException
    //   203	214	249	java/io/IOException
    //   203	214	245	finally
    //   217	225	277	com/google/protobuf/InvalidProtocolBufferException
    //   217	225	249	java/io/IOException
    //   217	225	245	finally
    //   228	236	277	com/google/protobuf/InvalidProtocolBufferException
    //   228	236	249	java/io/IOException
    //   228	236	245	finally
    //   250	277	245	finally
    //   278	293	245	finally
  }
  
  public String getCampaignId() {
    return this.campaignId_;
  }
  
  public ByteString getCampaignIdBytes() {
    return ByteString.copyFromUtf8(this.campaignId_);
  }
  
  public String getInstanceIds(int paramInt) {
    return (String)this.instanceIds_.get(paramInt);
  }
  
  public ByteString getInstanceIdsBytes(int paramInt) {
    return ByteString.copyFromUtf8((String)this.instanceIds_.get(paramInt));
  }
  
  public int getInstanceIdsCount() {
    return this.instanceIds_.size();
  }
  
  public List<String> getInstanceIdsList() {
    return (List<String>)this.instanceIds_;
  }
  
  public String getProjectNumber() {
    return this.projectNumber_;
  }
  
  public ByteString getProjectNumberBytes() {
    return ByteString.copyFromUtf8(this.projectNumber_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    boolean bool = this.projectNumber_.isEmpty();
    boolean bool1 = false;
    if (!bool) {
      i = CodedOutputStream.computeStringSize(1, getProjectNumber()) + 0;
    } else {
      i = 0;
    } 
    int j = i;
    if (!this.campaignId_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(2, getCampaignId()); 
    int k = 0;
    for (i = bool1; i < this.instanceIds_.size(); i++)
      k += CodedOutputStream.computeStringSizeNoTag((String)this.instanceIds_.get(i)); 
    i = j + k + getInstanceIdsList().size() * 1;
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.projectNumber_.isEmpty())
      paramCodedOutputStream.writeString(1, getProjectNumber()); 
    if (!this.campaignId_.isEmpty())
      paramCodedOutputStream.writeString(2, getCampaignId()); 
    for (byte b = 0; b < this.instanceIds_.size(); b++)
      paramCodedOutputStream.writeString(3, (String)this.instanceIds_.get(b)); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<TestCampaignOnDeviceRequest, Builder> implements TestCampaignOnDeviceRequestOrBuilder {
    private Builder() {
      super(TestCampaignOnDeviceRequest.DEFAULT_INSTANCE);
    }
    
    public Builder addAllInstanceIds(Iterable<String> param1Iterable) {
      copyOnWrite();
      ((TestCampaignOnDeviceRequest)this.instance).addAllInstanceIds(param1Iterable);
      return this;
    }
    
    public Builder addInstanceIds(String param1String) {
      copyOnWrite();
      ((TestCampaignOnDeviceRequest)this.instance).addInstanceIds(param1String);
      return this;
    }
    
    public Builder addInstanceIdsBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((TestCampaignOnDeviceRequest)this.instance).addInstanceIdsBytes(param1ByteString);
      return this;
    }
    
    public Builder clearCampaignId() {
      copyOnWrite();
      ((TestCampaignOnDeviceRequest)this.instance).clearCampaignId();
      return this;
    }
    
    public Builder clearInstanceIds() {
      copyOnWrite();
      ((TestCampaignOnDeviceRequest)this.instance).clearInstanceIds();
      return this;
    }
    
    public Builder clearProjectNumber() {
      copyOnWrite();
      ((TestCampaignOnDeviceRequest)this.instance).clearProjectNumber();
      return this;
    }
    
    public String getCampaignId() {
      return ((TestCampaignOnDeviceRequest)this.instance).getCampaignId();
    }
    
    public ByteString getCampaignIdBytes() {
      return ((TestCampaignOnDeviceRequest)this.instance).getCampaignIdBytes();
    }
    
    public String getInstanceIds(int param1Int) {
      return ((TestCampaignOnDeviceRequest)this.instance).getInstanceIds(param1Int);
    }
    
    public ByteString getInstanceIdsBytes(int param1Int) {
      return ((TestCampaignOnDeviceRequest)this.instance).getInstanceIdsBytes(param1Int);
    }
    
    public int getInstanceIdsCount() {
      return ((TestCampaignOnDeviceRequest)this.instance).getInstanceIdsCount();
    }
    
    public List<String> getInstanceIdsList() {
      return Collections.unmodifiableList(((TestCampaignOnDeviceRequest)this.instance).getInstanceIdsList());
    }
    
    public String getProjectNumber() {
      return ((TestCampaignOnDeviceRequest)this.instance).getProjectNumber();
    }
    
    public ByteString getProjectNumberBytes() {
      return ((TestCampaignOnDeviceRequest)this.instance).getProjectNumberBytes();
    }
    
    public Builder setCampaignId(String param1String) {
      copyOnWrite();
      ((TestCampaignOnDeviceRequest)this.instance).setCampaignId(param1String);
      return this;
    }
    
    public Builder setCampaignIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((TestCampaignOnDeviceRequest)this.instance).setCampaignIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setInstanceIds(int param1Int, String param1String) {
      copyOnWrite();
      ((TestCampaignOnDeviceRequest)this.instance).setInstanceIds(param1Int, param1String);
      return this;
    }
    
    public Builder setProjectNumber(String param1String) {
      copyOnWrite();
      ((TestCampaignOnDeviceRequest)this.instance).setProjectNumber(param1String);
      return this;
    }
    
    public Builder setProjectNumberBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((TestCampaignOnDeviceRequest)this.instance).setProjectNumberBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\internal\firebase\inappmessaging\v1\TestCampaignOnDeviceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */