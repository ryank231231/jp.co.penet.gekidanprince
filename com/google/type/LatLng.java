package com.google.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class LatLng extends GeneratedMessageLite<LatLng, LatLng.Builder> implements LatLngOrBuilder {
  private static final LatLng DEFAULT_INSTANCE = new LatLng();
  
  public static final int LATITUDE_FIELD_NUMBER = 1;
  
  public static final int LONGITUDE_FIELD_NUMBER = 2;
  
  private static volatile Parser<LatLng> PARSER;
  
  private double latitude_;
  
  private double longitude_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearLatitude() {
    this.latitude_ = 0.0D;
  }
  
  private void clearLongitude() {
    this.longitude_ = 0.0D;
  }
  
  public static LatLng getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(LatLng paramLatLng) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramLatLng);
  }
  
  public static LatLng parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (LatLng)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static LatLng parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (LatLng)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static LatLng parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (LatLng)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static LatLng parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (LatLng)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static LatLng parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (LatLng)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static LatLng parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (LatLng)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static LatLng parseFrom(InputStream paramInputStream) throws IOException {
    return (LatLng)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static LatLng parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (LatLng)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static LatLng parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (LatLng)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static LatLng parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (LatLng)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<LatLng> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setLatitude(double paramDouble) {
    this.latitude_ = paramDouble;
  }
  
  private void setLongitude(double paramDouble) {
    this.longitude_ = paramDouble;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/type/LatLng$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iload #4
    //   15: tableswitch default -> 60, 1 -> 406, 2 -> 402, 3 -> 400, 4 -> 391, 5 -> 251, 6 -> 114, 7 -> 247, 8 -> 68
    //   60: new java/lang/UnsupportedOperationException
    //   63: dup
    //   64: invokespecial <init> : ()V
    //   67: athrow
    //   68: getstatic com/google/type/LatLng.PARSER : Lcom/google/protobuf/Parser;
    //   71: ifnonnull -> 110
    //   74: ldc com/google/type/LatLng
    //   76: monitorenter
    //   77: getstatic com/google/type/LatLng.PARSER : Lcom/google/protobuf/Parser;
    //   80: ifnonnull -> 98
    //   83: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   86: astore_1
    //   87: aload_1
    //   88: getstatic com/google/type/LatLng.DEFAULT_INSTANCE : Lcom/google/type/LatLng;
    //   91: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   94: aload_1
    //   95: putstatic com/google/type/LatLng.PARSER : Lcom/google/protobuf/Parser;
    //   98: ldc com/google/type/LatLng
    //   100: monitorexit
    //   101: goto -> 110
    //   104: astore_1
    //   105: ldc com/google/type/LatLng
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    //   110: getstatic com/google/type/LatLng.PARSER : Lcom/google/protobuf/Parser;
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
    //   142: bipush #9
    //   144: if_icmpeq -> 180
    //   147: iload #4
    //   149: bipush #17
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
    //   171: invokevirtual readDouble : ()D
    //   174: putfield longitude_ : D
    //   177: goto -> 124
    //   180: aload_0
    //   181: aload_1
    //   182: invokevirtual readDouble : ()D
    //   185: putfield latitude_ : D
    //   188: goto -> 124
    //   191: iconst_1
    //   192: istore #5
    //   194: goto -> 124
    //   197: astore_1
    //   198: goto -> 245
    //   201: astore_2
    //   202: new java/lang/RuntimeException
    //   205: astore_1
    //   206: new com/google/protobuf/InvalidProtocolBufferException
    //   209: astore_3
    //   210: aload_3
    //   211: aload_2
    //   212: invokevirtual getMessage : ()Ljava/lang/String;
    //   215: invokespecial <init> : (Ljava/lang/String;)V
    //   218: aload_1
    //   219: aload_3
    //   220: aload_0
    //   221: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   224: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   227: aload_1
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
    //   247: getstatic com/google/type/LatLng.DEFAULT_INSTANCE : Lcom/google/type/LatLng;
    //   250: areturn
    //   251: aload_2
    //   252: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   255: astore_1
    //   256: aload_3
    //   257: checkcast com/google/type/LatLng
    //   260: astore_2
    //   261: aload_0
    //   262: getfield latitude_ : D
    //   265: dconst_0
    //   266: dcmpl
    //   267: ifeq -> 276
    //   270: iconst_1
    //   271: istore #6
    //   273: goto -> 279
    //   276: iconst_0
    //   277: istore #6
    //   279: aload_0
    //   280: getfield latitude_ : D
    //   283: dstore #7
    //   285: aload_2
    //   286: getfield latitude_ : D
    //   289: dconst_0
    //   290: dcmpl
    //   291: ifeq -> 300
    //   294: iconst_1
    //   295: istore #9
    //   297: goto -> 303
    //   300: iconst_0
    //   301: istore #9
    //   303: aload_0
    //   304: aload_1
    //   305: iload #6
    //   307: dload #7
    //   309: iload #9
    //   311: aload_2
    //   312: getfield latitude_ : D
    //   315: invokeinterface visitDouble : (ZDZD)D
    //   320: putfield latitude_ : D
    //   323: aload_0
    //   324: getfield longitude_ : D
    //   327: dconst_0
    //   328: dcmpl
    //   329: ifeq -> 338
    //   332: iconst_1
    //   333: istore #6
    //   335: goto -> 341
    //   338: iconst_0
    //   339: istore #6
    //   341: aload_0
    //   342: getfield longitude_ : D
    //   345: dstore #7
    //   347: aload_2
    //   348: getfield longitude_ : D
    //   351: dconst_0
    //   352: dcmpl
    //   353: ifeq -> 362
    //   356: iconst_1
    //   357: istore #9
    //   359: goto -> 365
    //   362: iconst_0
    //   363: istore #9
    //   365: aload_0
    //   366: aload_1
    //   367: iload #6
    //   369: dload #7
    //   371: iload #9
    //   373: aload_2
    //   374: getfield longitude_ : D
    //   377: invokeinterface visitDouble : (ZDZD)D
    //   382: putfield longitude_ : D
    //   385: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   388: astore_1
    //   389: aload_0
    //   390: areturn
    //   391: new com/google/type/LatLng$Builder
    //   394: dup
    //   395: aconst_null
    //   396: invokespecial <init> : (Lcom/google/type/LatLng$1;)V
    //   399: areturn
    //   400: aconst_null
    //   401: areturn
    //   402: getstatic com/google/type/LatLng.DEFAULT_INSTANCE : Lcom/google/type/LatLng;
    //   405: areturn
    //   406: new com/google/type/LatLng
    //   409: dup
    //   410: invokespecial <init> : ()V
    //   413: areturn
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
  
  public double getLatitude() {
    return this.latitude_;
  }
  
  public double getLongitude() {
    return this.longitude_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    double d = this.latitude_;
    if (d != 0.0D)
      i = 0 + CodedOutputStream.computeDoubleSize(1, d); 
    d = this.longitude_;
    int j = i;
    if (d != 0.0D)
      j = i + CodedOutputStream.computeDoubleSize(2, d); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    double d = this.latitude_;
    if (d != 0.0D)
      paramCodedOutputStream.writeDouble(1, d); 
    d = this.longitude_;
    if (d != 0.0D)
      paramCodedOutputStream.writeDouble(2, d); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<LatLng, Builder> implements LatLngOrBuilder {
    private Builder() {
      super(LatLng.DEFAULT_INSTANCE);
    }
    
    public Builder clearLatitude() {
      copyOnWrite();
      ((LatLng)this.instance).clearLatitude();
      return this;
    }
    
    public Builder clearLongitude() {
      copyOnWrite();
      ((LatLng)this.instance).clearLongitude();
      return this;
    }
    
    public double getLatitude() {
      return ((LatLng)this.instance).getLatitude();
    }
    
    public double getLongitude() {
      return ((LatLng)this.instance).getLongitude();
    }
    
    public Builder setLatitude(double param1Double) {
      copyOnWrite();
      ((LatLng)this.instance).setLatitude(param1Double);
      return this;
    }
    
    public Builder setLongitude(double param1Double) {
      copyOnWrite();
      ((LatLng)this.instance).setLongitude(param1Double);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\type\LatLng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */