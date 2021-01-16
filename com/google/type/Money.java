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

public final class Money extends GeneratedMessageLite<Money, Money.Builder> implements MoneyOrBuilder {
  public static final int CURRENCY_CODE_FIELD_NUMBER = 1;
  
  private static final Money DEFAULT_INSTANCE = new Money();
  
  public static final int NANOS_FIELD_NUMBER = 3;
  
  private static volatile Parser<Money> PARSER;
  
  public static final int UNITS_FIELD_NUMBER = 2;
  
  private String currencyCode_ = "";
  
  private int nanos_;
  
  private long units_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearCurrencyCode() {
    this.currencyCode_ = getDefaultInstance().getCurrencyCode();
  }
  
  private void clearNanos() {
    this.nanos_ = 0;
  }
  
  private void clearUnits() {
    this.units_ = 0L;
  }
  
  public static Money getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Money paramMoney) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramMoney);
  }
  
  public static Money parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Money)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Money parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Money)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Money parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Money)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Money parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Money)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Money parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Money)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Money parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Money)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Money parseFrom(InputStream paramInputStream) throws IOException {
    return (Money)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Money parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Money)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Money parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Money)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Money parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Money)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Money> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setCurrencyCode(String paramString) {
    if (paramString != null) {
      this.currencyCode_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setCurrencyCodeBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.currencyCode_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setNanos(int paramInt) {
    this.nanos_ = paramInt;
  }
  
  private void setUnits(long paramLong) {
    this.units_ = paramLong;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/type/Money$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 458, 2 -> 454, 3 -> 452, 4 -> 443, 5 -> 273, 6 -> 118, 7 -> 269, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/type/Money.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/type/Money
    //   80: monitorenter
    //   81: getstatic com/google/type/Money.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/type/Money.DEFAULT_INSTANCE : Lcom/google/type/Money;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/type/Money.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/type/Money
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/type/Money
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/type/Money.PARSER : Lcom/google/protobuf/Parser;
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
    //   146: bipush #10
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
    //   185: putfield nanos_ : I
    //   188: goto -> 128
    //   191: aload_0
    //   192: aload_1
    //   193: invokevirtual readInt64 : ()J
    //   196: putfield units_ : J
    //   199: goto -> 128
    //   202: aload_0
    //   203: aload_1
    //   204: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   207: putfield currencyCode_ : Ljava/lang/String;
    //   210: goto -> 128
    //   213: iconst_1
    //   214: istore #6
    //   216: goto -> 128
    //   219: astore_1
    //   220: goto -> 267
    //   223: astore_1
    //   224: new java/lang/RuntimeException
    //   227: astore_3
    //   228: new com/google/protobuf/InvalidProtocolBufferException
    //   231: astore_2
    //   232: aload_2
    //   233: aload_1
    //   234: invokevirtual getMessage : ()Ljava/lang/String;
    //   237: invokespecial <init> : (Ljava/lang/String;)V
    //   240: aload_3
    //   241: aload_2
    //   242: aload_0
    //   243: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   246: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   249: aload_3
    //   250: athrow
    //   251: astore_1
    //   252: new java/lang/RuntimeException
    //   255: astore_2
    //   256: aload_2
    //   257: aload_1
    //   258: aload_0
    //   259: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   262: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   265: aload_2
    //   266: athrow
    //   267: aload_1
    //   268: athrow
    //   269: getstatic com/google/type/Money.DEFAULT_INSTANCE : Lcom/google/type/Money;
    //   272: areturn
    //   273: aload_2
    //   274: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   277: astore_1
    //   278: aload_3
    //   279: checkcast com/google/type/Money
    //   282: astore_2
    //   283: aload_0
    //   284: aload_1
    //   285: aload_0
    //   286: getfield currencyCode_ : Ljava/lang/String;
    //   289: invokevirtual isEmpty : ()Z
    //   292: iconst_1
    //   293: ixor
    //   294: aload_0
    //   295: getfield currencyCode_ : Ljava/lang/String;
    //   298: aload_2
    //   299: getfield currencyCode_ : Ljava/lang/String;
    //   302: invokevirtual isEmpty : ()Z
    //   305: iconst_1
    //   306: ixor
    //   307: aload_2
    //   308: getfield currencyCode_ : Ljava/lang/String;
    //   311: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   316: putfield currencyCode_ : Ljava/lang/String;
    //   319: aload_0
    //   320: getfield units_ : J
    //   323: lconst_0
    //   324: lcmp
    //   325: ifeq -> 334
    //   328: iconst_1
    //   329: istore #7
    //   331: goto -> 337
    //   334: iconst_0
    //   335: istore #7
    //   337: aload_0
    //   338: getfield units_ : J
    //   341: lstore #8
    //   343: aload_2
    //   344: getfield units_ : J
    //   347: lconst_0
    //   348: lcmp
    //   349: ifeq -> 358
    //   352: iconst_1
    //   353: istore #10
    //   355: goto -> 361
    //   358: iconst_0
    //   359: istore #10
    //   361: aload_0
    //   362: aload_1
    //   363: iload #7
    //   365: lload #8
    //   367: iload #10
    //   369: aload_2
    //   370: getfield units_ : J
    //   373: invokeinterface visitLong : (ZJZJ)J
    //   378: putfield units_ : J
    //   381: aload_0
    //   382: getfield nanos_ : I
    //   385: ifeq -> 394
    //   388: iconst_1
    //   389: istore #7
    //   391: goto -> 397
    //   394: iconst_0
    //   395: istore #7
    //   397: aload_0
    //   398: getfield nanos_ : I
    //   401: istore #6
    //   403: iload #5
    //   405: istore #10
    //   407: aload_2
    //   408: getfield nanos_ : I
    //   411: ifeq -> 417
    //   414: iconst_1
    //   415: istore #10
    //   417: aload_0
    //   418: aload_1
    //   419: iload #7
    //   421: iload #6
    //   423: iload #10
    //   425: aload_2
    //   426: getfield nanos_ : I
    //   429: invokeinterface visitInt : (ZIZI)I
    //   434: putfield nanos_ : I
    //   437: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   440: astore_1
    //   441: aload_0
    //   442: areturn
    //   443: new com/google/type/Money$Builder
    //   446: dup
    //   447: aconst_null
    //   448: invokespecial <init> : (Lcom/google/type/Money$1;)V
    //   451: areturn
    //   452: aconst_null
    //   453: areturn
    //   454: getstatic com/google/type/Money.DEFAULT_INSTANCE : Lcom/google/type/Money;
    //   457: areturn
    //   458: new com/google/type/Money
    //   461: dup
    //   462: invokespecial <init> : ()V
    //   465: areturn
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
  
  public String getCurrencyCode() {
    return this.currencyCode_;
  }
  
  public ByteString getCurrencyCodeBytes() {
    return ByteString.copyFromUtf8(this.currencyCode_);
  }
  
  public int getNanos() {
    return this.nanos_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!this.currencyCode_.isEmpty())
      j = 0 + CodedOutputStream.computeStringSize(1, getCurrencyCode()); 
    long l = this.units_;
    i = j;
    if (l != 0L)
      i = j + CodedOutputStream.computeInt64Size(2, l); 
    int k = this.nanos_;
    j = i;
    if (k != 0)
      j = i + CodedOutputStream.computeInt32Size(3, k); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public long getUnits() {
    return this.units_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.currencyCode_.isEmpty())
      paramCodedOutputStream.writeString(1, getCurrencyCode()); 
    long l = this.units_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(2, l); 
    int i = this.nanos_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(3, i); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Money, Builder> implements MoneyOrBuilder {
    private Builder() {
      super(Money.DEFAULT_INSTANCE);
    }
    
    public Builder clearCurrencyCode() {
      copyOnWrite();
      ((Money)this.instance).clearCurrencyCode();
      return this;
    }
    
    public Builder clearNanos() {
      copyOnWrite();
      ((Money)this.instance).clearNanos();
      return this;
    }
    
    public Builder clearUnits() {
      copyOnWrite();
      ((Money)this.instance).clearUnits();
      return this;
    }
    
    public String getCurrencyCode() {
      return ((Money)this.instance).getCurrencyCode();
    }
    
    public ByteString getCurrencyCodeBytes() {
      return ((Money)this.instance).getCurrencyCodeBytes();
    }
    
    public int getNanos() {
      return ((Money)this.instance).getNanos();
    }
    
    public long getUnits() {
      return ((Money)this.instance).getUnits();
    }
    
    public Builder setCurrencyCode(String param1String) {
      copyOnWrite();
      ((Money)this.instance).setCurrencyCode(param1String);
      return this;
    }
    
    public Builder setCurrencyCodeBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Money)this.instance).setCurrencyCodeBytes(param1ByteString);
      return this;
    }
    
    public Builder setNanos(int param1Int) {
      copyOnWrite();
      ((Money)this.instance).setNanos(param1Int);
      return this;
    }
    
    public Builder setUnits(long param1Long) {
      copyOnWrite();
      ((Money)this.instance).setUnits(param1Long);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\type\Money.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */