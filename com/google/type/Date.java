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

public final class Date extends GeneratedMessageLite<Date, Date.Builder> implements DateOrBuilder {
  public static final int DAY_FIELD_NUMBER = 3;
  
  private static final Date DEFAULT_INSTANCE = new Date();
  
  public static final int MONTH_FIELD_NUMBER = 2;
  
  private static volatile Parser<Date> PARSER;
  
  public static final int YEAR_FIELD_NUMBER = 1;
  
  private int day_;
  
  private int month_;
  
  private int year_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearDay() {
    this.day_ = 0;
  }
  
  private void clearMonth() {
    this.month_ = 0;
  }
  
  private void clearYear() {
    this.year_ = 0;
  }
  
  public static Date getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Date paramDate) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramDate);
  }
  
  public static Date parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Date)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Date parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Date)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Date parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Date)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Date parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Date)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Date parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Date)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Date parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Date)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Date parseFrom(InputStream paramInputStream) throws IOException {
    return (Date)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Date parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Date)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Date parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Date)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Date parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Date)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Date> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setDay(int paramInt) {
    this.day_ = paramInt;
  }
  
  private void setMonth(int paramInt) {
    this.month_ = paramInt;
  }
  
  private void setYear(int paramInt) {
    this.year_ = paramInt;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/type/Date$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 476, 2 -> 472, 3 -> 470, 4 -> 461, 5 -> 273, 6 -> 118, 7 -> 269, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/type/Date.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/type/Date
    //   80: monitorenter
    //   81: getstatic com/google/type/Date.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/type/Date.DEFAULT_INSTANCE : Lcom/google/type/Date;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/type/Date.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/type/Date
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/type/Date
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/type/Date.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_1
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_2
    //   128: iload #6
    //   130: ifne -> 269
    //   133: aload_1
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 213
    //   144: iload #4
    //   146: bipush #8
    //   148: if_icmpeq -> 202
    //   151: iload #4
    //   153: bipush #16
    //   155: if_icmpeq -> 191
    //   158: iload #4
    //   160: bipush #24
    //   162: if_icmpeq -> 180
    //   165: aload_1
    //   166: iload #4
    //   168: invokevirtual skipField : (I)Z
    //   171: ifne -> 128
    //   174: iconst_1
    //   175: istore #6
    //   177: goto -> 128
    //   180: aload_0
    //   181: aload_1
    //   182: invokevirtual readInt32 : ()I
    //   185: putfield day_ : I
    //   188: goto -> 128
    //   191: aload_0
    //   192: aload_1
    //   193: invokevirtual readInt32 : ()I
    //   196: putfield month_ : I
    //   199: goto -> 128
    //   202: aload_0
    //   203: aload_1
    //   204: invokevirtual readInt32 : ()I
    //   207: putfield year_ : I
    //   210: goto -> 128
    //   213: iconst_1
    //   214: istore #6
    //   216: goto -> 128
    //   219: astore_1
    //   220: goto -> 267
    //   223: astore_3
    //   224: new java/lang/RuntimeException
    //   227: astore_2
    //   228: new com/google/protobuf/InvalidProtocolBufferException
    //   231: astore_1
    //   232: aload_1
    //   233: aload_3
    //   234: invokevirtual getMessage : ()Ljava/lang/String;
    //   237: invokespecial <init> : (Ljava/lang/String;)V
    //   240: aload_2
    //   241: aload_1
    //   242: aload_0
    //   243: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   246: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   249: aload_2
    //   250: athrow
    //   251: astore_2
    //   252: new java/lang/RuntimeException
    //   255: astore_1
    //   256: aload_1
    //   257: aload_2
    //   258: aload_0
    //   259: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   262: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   265: aload_1
    //   266: athrow
    //   267: aload_1
    //   268: athrow
    //   269: getstatic com/google/type/Date.DEFAULT_INSTANCE : Lcom/google/type/Date;
    //   272: areturn
    //   273: aload_2
    //   274: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   277: astore_1
    //   278: aload_3
    //   279: checkcast com/google/type/Date
    //   282: astore_2
    //   283: aload_0
    //   284: getfield year_ : I
    //   287: ifeq -> 296
    //   290: iconst_1
    //   291: istore #7
    //   293: goto -> 299
    //   296: iconst_0
    //   297: istore #7
    //   299: aload_0
    //   300: getfield year_ : I
    //   303: istore #6
    //   305: aload_2
    //   306: getfield year_ : I
    //   309: ifeq -> 318
    //   312: iconst_1
    //   313: istore #8
    //   315: goto -> 321
    //   318: iconst_0
    //   319: istore #8
    //   321: aload_0
    //   322: aload_1
    //   323: iload #7
    //   325: iload #6
    //   327: iload #8
    //   329: aload_2
    //   330: getfield year_ : I
    //   333: invokeinterface visitInt : (ZIZI)I
    //   338: putfield year_ : I
    //   341: aload_0
    //   342: getfield month_ : I
    //   345: ifeq -> 354
    //   348: iconst_1
    //   349: istore #7
    //   351: goto -> 357
    //   354: iconst_0
    //   355: istore #7
    //   357: aload_0
    //   358: getfield month_ : I
    //   361: istore #6
    //   363: aload_2
    //   364: getfield month_ : I
    //   367: ifeq -> 376
    //   370: iconst_1
    //   371: istore #8
    //   373: goto -> 379
    //   376: iconst_0
    //   377: istore #8
    //   379: aload_0
    //   380: aload_1
    //   381: iload #7
    //   383: iload #6
    //   385: iload #8
    //   387: aload_2
    //   388: getfield month_ : I
    //   391: invokeinterface visitInt : (ZIZI)I
    //   396: putfield month_ : I
    //   399: aload_0
    //   400: getfield day_ : I
    //   403: ifeq -> 412
    //   406: iconst_1
    //   407: istore #7
    //   409: goto -> 415
    //   412: iconst_0
    //   413: istore #7
    //   415: aload_0
    //   416: getfield day_ : I
    //   419: istore #6
    //   421: iload #5
    //   423: istore #8
    //   425: aload_2
    //   426: getfield day_ : I
    //   429: ifeq -> 435
    //   432: iconst_1
    //   433: istore #8
    //   435: aload_0
    //   436: aload_1
    //   437: iload #7
    //   439: iload #6
    //   441: iload #8
    //   443: aload_2
    //   444: getfield day_ : I
    //   447: invokeinterface visitInt : (ZIZI)I
    //   452: putfield day_ : I
    //   455: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   458: astore_1
    //   459: aload_0
    //   460: areturn
    //   461: new com/google/type/Date$Builder
    //   464: dup
    //   465: aconst_null
    //   466: invokespecial <init> : (Lcom/google/type/Date$1;)V
    //   469: areturn
    //   470: aconst_null
    //   471: areturn
    //   472: getstatic com/google/type/Date.DEFAULT_INSTANCE : Lcom/google/type/Date;
    //   475: areturn
    //   476: new com/google/type/Date
    //   479: dup
    //   480: invokespecial <init> : ()V
    //   483: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	251	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	223	java/io/IOException
    //   133	139	219	finally
    //   165	174	251	com/google/protobuf/InvalidProtocolBufferException
    //   165	174	223	java/io/IOException
    //   165	174	219	finally
    //   180	188	251	com/google/protobuf/InvalidProtocolBufferException
    //   180	188	223	java/io/IOException
    //   180	188	219	finally
    //   191	199	251	com/google/protobuf/InvalidProtocolBufferException
    //   191	199	223	java/io/IOException
    //   191	199	219	finally
    //   202	210	251	com/google/protobuf/InvalidProtocolBufferException
    //   202	210	223	java/io/IOException
    //   202	210	219	finally
    //   224	251	219	finally
    //   252	267	219	finally
  }
  
  public int getDay() {
    return this.day_;
  }
  
  public int getMonth() {
    return this.month_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    i = this.year_;
    if (i != 0)
      j = 0 + CodedOutputStream.computeInt32Size(1, i); 
    int k = this.month_;
    i = j;
    if (k != 0)
      i = j + CodedOutputStream.computeInt32Size(2, k); 
    k = this.day_;
    j = i;
    if (k != 0)
      j = i + CodedOutputStream.computeInt32Size(3, k); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public int getYear() {
    return this.year_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    int i = this.year_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(1, i); 
    i = this.month_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(2, i); 
    i = this.day_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(3, i); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Date, Builder> implements DateOrBuilder {
    private Builder() {
      super(Date.DEFAULT_INSTANCE);
    }
    
    public Builder clearDay() {
      copyOnWrite();
      ((Date)this.instance).clearDay();
      return this;
    }
    
    public Builder clearMonth() {
      copyOnWrite();
      ((Date)this.instance).clearMonth();
      return this;
    }
    
    public Builder clearYear() {
      copyOnWrite();
      ((Date)this.instance).clearYear();
      return this;
    }
    
    public int getDay() {
      return ((Date)this.instance).getDay();
    }
    
    public int getMonth() {
      return ((Date)this.instance).getMonth();
    }
    
    public int getYear() {
      return ((Date)this.instance).getYear();
    }
    
    public Builder setDay(int param1Int) {
      copyOnWrite();
      ((Date)this.instance).setDay(param1Int);
      return this;
    }
    
    public Builder setMonth(int param1Int) {
      copyOnWrite();
      ((Date)this.instance).setMonth(param1Int);
      return this;
    }
    
    public Builder setYear(int param1Int) {
      copyOnWrite();
      ((Date)this.instance).setYear(param1Int);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\type\Date.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */