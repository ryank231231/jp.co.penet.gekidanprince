package com.google.firebase.inappmessaging;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class ClientAppInfo extends GeneratedMessageLite<ClientAppInfo, ClientAppInfo.Builder> implements ClientAppInfoOrBuilder {
  private static final ClientAppInfo DEFAULT_INSTANCE = new ClientAppInfo();
  
  public static final int FIREBASE_INSTANCE_ID_FIELD_NUMBER = 2;
  
  public static final int GOOGLE_APP_ID_FIELD_NUMBER = 1;
  
  private static volatile Parser<ClientAppInfo> PARSER;
  
  private int bitField0_;
  
  private String firebaseInstanceId_ = "";
  
  private String googleAppId_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearFirebaseInstanceId() {
    this.bitField0_ &= 0xFFFFFFFD;
    this.firebaseInstanceId_ = getDefaultInstance().getFirebaseInstanceId();
  }
  
  private void clearGoogleAppId() {
    this.bitField0_ &= 0xFFFFFFFE;
    this.googleAppId_ = getDefaultInstance().getGoogleAppId();
  }
  
  public static ClientAppInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ClientAppInfo paramClientAppInfo) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramClientAppInfo);
  }
  
  public static ClientAppInfo parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ClientAppInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ClientAppInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ClientAppInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ClientAppInfo parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (ClientAppInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static ClientAppInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ClientAppInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static ClientAppInfo parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (ClientAppInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static ClientAppInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ClientAppInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ClientAppInfo parseFrom(InputStream paramInputStream) throws IOException {
    return (ClientAppInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ClientAppInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ClientAppInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ClientAppInfo parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (ClientAppInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static ClientAppInfo parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ClientAppInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ClientAppInfo> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setFirebaseInstanceId(String paramString) {
    if (paramString != null) {
      this.bitField0_ |= 0x2;
      this.firebaseInstanceId_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setFirebaseInstanceIdBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      this.bitField0_ |= 0x2;
      this.firebaseInstanceId_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setGoogleAppId(String paramString) {
    if (paramString != null) {
      this.bitField0_ |= 0x1;
      this.googleAppId_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setGoogleAppIdBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      this.bitField0_ |= 0x1;
      this.googleAppId_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firebase/inappmessaging/ClientAppInfo$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 374, 2 -> 370, 3 -> 368, 4 -> 359, 5 -> 275, 6 -> 110, 7 -> 271, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/firebase/inappmessaging/ClientAppInfo.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/firebase/inappmessaging/ClientAppInfo
    //   72: monitorenter
    //   73: getstatic com/google/firebase/inappmessaging/ClientAppInfo.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/firebase/inappmessaging/ClientAppInfo.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/ClientAppInfo;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/firebase/inappmessaging/ClientAppInfo.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/firebase/inappmessaging/ClientAppInfo
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/firebase/inappmessaging/ClientAppInfo
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/firebase/inappmessaging/ClientAppInfo.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 271
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 215
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 192
    //   146: iload #5
    //   148: bipush #18
    //   150: if_icmpeq -> 169
    //   153: aload_0
    //   154: iload #5
    //   156: aload_1
    //   157: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
    //   160: ifne -> 123
    //   163: iconst_1
    //   164: istore #4
    //   166: goto -> 123
    //   169: aload_1
    //   170: invokevirtual readString : ()Ljava/lang/String;
    //   173: astore_2
    //   174: aload_0
    //   175: aload_0
    //   176: getfield bitField0_ : I
    //   179: iconst_2
    //   180: ior
    //   181: putfield bitField0_ : I
    //   184: aload_0
    //   185: aload_2
    //   186: putfield firebaseInstanceId_ : Ljava/lang/String;
    //   189: goto -> 123
    //   192: aload_1
    //   193: invokevirtual readString : ()Ljava/lang/String;
    //   196: astore_2
    //   197: aload_0
    //   198: iconst_1
    //   199: aload_0
    //   200: getfield bitField0_ : I
    //   203: ior
    //   204: putfield bitField0_ : I
    //   207: aload_0
    //   208: aload_2
    //   209: putfield googleAppId_ : Ljava/lang/String;
    //   212: goto -> 123
    //   215: iconst_1
    //   216: istore #4
    //   218: goto -> 123
    //   221: astore_1
    //   222: goto -> 269
    //   225: astore_2
    //   226: new java/lang/RuntimeException
    //   229: astore_1
    //   230: new com/google/protobuf/InvalidProtocolBufferException
    //   233: astore_3
    //   234: aload_3
    //   235: aload_2
    //   236: invokevirtual getMessage : ()Ljava/lang/String;
    //   239: invokespecial <init> : (Ljava/lang/String;)V
    //   242: aload_1
    //   243: aload_3
    //   244: aload_0
    //   245: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   248: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   251: aload_1
    //   252: athrow
    //   253: astore_1
    //   254: new java/lang/RuntimeException
    //   257: astore_2
    //   258: aload_2
    //   259: aload_1
    //   260: aload_0
    //   261: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   264: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   267: aload_2
    //   268: athrow
    //   269: aload_1
    //   270: athrow
    //   271: getstatic com/google/firebase/inappmessaging/ClientAppInfo.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/ClientAppInfo;
    //   274: areturn
    //   275: aload_2
    //   276: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   279: astore_1
    //   280: aload_3
    //   281: checkcast com/google/firebase/inappmessaging/ClientAppInfo
    //   284: astore_2
    //   285: aload_0
    //   286: aload_1
    //   287: aload_0
    //   288: invokevirtual hasGoogleAppId : ()Z
    //   291: aload_0
    //   292: getfield googleAppId_ : Ljava/lang/String;
    //   295: aload_2
    //   296: invokevirtual hasGoogleAppId : ()Z
    //   299: aload_2
    //   300: getfield googleAppId_ : Ljava/lang/String;
    //   303: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   308: putfield googleAppId_ : Ljava/lang/String;
    //   311: aload_0
    //   312: aload_1
    //   313: aload_0
    //   314: invokevirtual hasFirebaseInstanceId : ()Z
    //   317: aload_0
    //   318: getfield firebaseInstanceId_ : Ljava/lang/String;
    //   321: aload_2
    //   322: invokevirtual hasFirebaseInstanceId : ()Z
    //   325: aload_2
    //   326: getfield firebaseInstanceId_ : Ljava/lang/String;
    //   329: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   334: putfield firebaseInstanceId_ : Ljava/lang/String;
    //   337: aload_1
    //   338: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   341: if_acmpne -> 357
    //   344: aload_0
    //   345: aload_0
    //   346: getfield bitField0_ : I
    //   349: aload_2
    //   350: getfield bitField0_ : I
    //   353: ior
    //   354: putfield bitField0_ : I
    //   357: aload_0
    //   358: areturn
    //   359: new com/google/firebase/inappmessaging/ClientAppInfo$Builder
    //   362: dup
    //   363: aconst_null
    //   364: invokespecial <init> : (Lcom/google/firebase/inappmessaging/ClientAppInfo$1;)V
    //   367: areturn
    //   368: aconst_null
    //   369: areturn
    //   370: getstatic com/google/firebase/inappmessaging/ClientAppInfo.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/ClientAppInfo;
    //   373: areturn
    //   374: new com/google/firebase/inappmessaging/ClientAppInfo
    //   377: dup
    //   378: invokespecial <init> : ()V
    //   381: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	253	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	225	java/io/IOException
    //   128	134	221	finally
    //   153	163	253	com/google/protobuf/InvalidProtocolBufferException
    //   153	163	225	java/io/IOException
    //   153	163	221	finally
    //   169	189	253	com/google/protobuf/InvalidProtocolBufferException
    //   169	189	225	java/io/IOException
    //   169	189	221	finally
    //   192	212	253	com/google/protobuf/InvalidProtocolBufferException
    //   192	212	225	java/io/IOException
    //   192	212	221	finally
    //   226	253	221	finally
    //   254	269	221	finally
  }
  
  public String getFirebaseInstanceId() {
    return this.firebaseInstanceId_;
  }
  
  public ByteString getFirebaseInstanceIdBytes() {
    return ByteString.copyFromUtf8(this.firebaseInstanceId_);
  }
  
  public String getGoogleAppId() {
    return this.googleAppId_;
  }
  
  public ByteString getGoogleAppIdBytes() {
    return ByteString.copyFromUtf8(this.googleAppId_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if ((this.bitField0_ & 0x1) == 1)
      i = 0 + CodedOutputStream.computeStringSize(1, getGoogleAppId()); 
    int j = i;
    if ((this.bitField0_ & 0x2) == 2)
      j = i + CodedOutputStream.computeStringSize(2, getFirebaseInstanceId()); 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public boolean hasFirebaseInstanceId() {
    boolean bool;
    if ((this.bitField0_ & 0x2) == 2) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasGoogleAppId() {
    int i = this.bitField0_;
    boolean bool = true;
    if ((i & 0x1) != 1)
      bool = false; 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if ((this.bitField0_ & 0x1) == 1)
      paramCodedOutputStream.writeString(1, getGoogleAppId()); 
    if ((this.bitField0_ & 0x2) == 2)
      paramCodedOutputStream.writeString(2, getFirebaseInstanceId()); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ClientAppInfo, Builder> implements ClientAppInfoOrBuilder {
    private Builder() {
      super(ClientAppInfo.DEFAULT_INSTANCE);
    }
    
    public Builder clearFirebaseInstanceId() {
      copyOnWrite();
      ((ClientAppInfo)this.instance).clearFirebaseInstanceId();
      return this;
    }
    
    public Builder clearGoogleAppId() {
      copyOnWrite();
      ((ClientAppInfo)this.instance).clearGoogleAppId();
      return this;
    }
    
    public String getFirebaseInstanceId() {
      return ((ClientAppInfo)this.instance).getFirebaseInstanceId();
    }
    
    public ByteString getFirebaseInstanceIdBytes() {
      return ((ClientAppInfo)this.instance).getFirebaseInstanceIdBytes();
    }
    
    public String getGoogleAppId() {
      return ((ClientAppInfo)this.instance).getGoogleAppId();
    }
    
    public ByteString getGoogleAppIdBytes() {
      return ((ClientAppInfo)this.instance).getGoogleAppIdBytes();
    }
    
    public boolean hasFirebaseInstanceId() {
      return ((ClientAppInfo)this.instance).hasFirebaseInstanceId();
    }
    
    public boolean hasGoogleAppId() {
      return ((ClientAppInfo)this.instance).hasGoogleAppId();
    }
    
    public Builder setFirebaseInstanceId(String param1String) {
      copyOnWrite();
      ((ClientAppInfo)this.instance).setFirebaseInstanceId(param1String);
      return this;
    }
    
    public Builder setFirebaseInstanceIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ClientAppInfo)this.instance).setFirebaseInstanceIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setGoogleAppId(String param1String) {
      copyOnWrite();
      ((ClientAppInfo)this.instance).setGoogleAppId(param1String);
      return this;
    }
    
    public Builder setGoogleAppIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ClientAppInfo)this.instance).setGoogleAppIdBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\ClientAppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */