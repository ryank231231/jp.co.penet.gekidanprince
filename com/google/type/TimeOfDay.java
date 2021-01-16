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

public final class TimeOfDay extends GeneratedMessageLite<TimeOfDay, TimeOfDay.Builder> implements TimeOfDayOrBuilder {
  private static final TimeOfDay DEFAULT_INSTANCE = new TimeOfDay();
  
  public static final int HOURS_FIELD_NUMBER = 1;
  
  public static final int MINUTES_FIELD_NUMBER = 2;
  
  public static final int NANOS_FIELD_NUMBER = 4;
  
  private static volatile Parser<TimeOfDay> PARSER;
  
  public static final int SECONDS_FIELD_NUMBER = 3;
  
  private int hours_;
  
  private int minutes_;
  
  private int nanos_;
  
  private int seconds_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearHours() {
    this.hours_ = 0;
  }
  
  private void clearMinutes() {
    this.minutes_ = 0;
  }
  
  private void clearNanos() {
    this.nanos_ = 0;
  }
  
  private void clearSeconds() {
    this.seconds_ = 0;
  }
  
  public static TimeOfDay getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(TimeOfDay paramTimeOfDay) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramTimeOfDay);
  }
  
  public static TimeOfDay parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (TimeOfDay)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static TimeOfDay parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (TimeOfDay)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static TimeOfDay parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (TimeOfDay)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static TimeOfDay parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (TimeOfDay)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static TimeOfDay parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (TimeOfDay)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static TimeOfDay parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (TimeOfDay)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static TimeOfDay parseFrom(InputStream paramInputStream) throws IOException {
    return (TimeOfDay)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static TimeOfDay parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (TimeOfDay)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static TimeOfDay parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (TimeOfDay)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static TimeOfDay parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (TimeOfDay)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<TimeOfDay> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setHours(int paramInt) {
    this.hours_ = paramInt;
  }
  
  private void setMinutes(int paramInt) {
    this.minutes_ = paramInt;
  }
  
  private void setNanos(int paramInt) {
    this.nanos_ = paramInt;
  }
  
  private void setSeconds(int paramInt) {
    this.seconds_ = paramInt;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/type/TimeOfDay$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 552, 2 -> 548, 3 -> 546, 4 -> 537, 5 -> 291, 6 -> 118, 7 -> 287, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/type/TimeOfDay.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/type/TimeOfDay
    //   80: monitorenter
    //   81: getstatic com/google/type/TimeOfDay.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/type/TimeOfDay.DEFAULT_INSTANCE : Lcom/google/type/TimeOfDay;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/type/TimeOfDay.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/type/TimeOfDay
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/type/TimeOfDay
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/type/TimeOfDay.PARSER : Lcom/google/protobuf/Parser;
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
    //   146: bipush #8
    //   148: if_icmpeq -> 220
    //   151: iload #4
    //   153: bipush #16
    //   155: if_icmpeq -> 209
    //   158: iload #4
    //   160: bipush #24
    //   162: if_icmpeq -> 198
    //   165: iload #4
    //   167: bipush #32
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
    //   189: invokevirtual readInt32 : ()I
    //   192: putfield nanos_ : I
    //   195: goto -> 128
    //   198: aload_0
    //   199: aload_1
    //   200: invokevirtual readInt32 : ()I
    //   203: putfield seconds_ : I
    //   206: goto -> 128
    //   209: aload_0
    //   210: aload_1
    //   211: invokevirtual readInt32 : ()I
    //   214: putfield minutes_ : I
    //   217: goto -> 128
    //   220: aload_0
    //   221: aload_1
    //   222: invokevirtual readInt32 : ()I
    //   225: putfield hours_ : I
    //   228: goto -> 128
    //   231: iconst_1
    //   232: istore #6
    //   234: goto -> 128
    //   237: astore_1
    //   238: goto -> 285
    //   241: astore_2
    //   242: new java/lang/RuntimeException
    //   245: astore_1
    //   246: new com/google/protobuf/InvalidProtocolBufferException
    //   249: astore_3
    //   250: aload_3
    //   251: aload_2
    //   252: invokevirtual getMessage : ()Ljava/lang/String;
    //   255: invokespecial <init> : (Ljava/lang/String;)V
    //   258: aload_1
    //   259: aload_3
    //   260: aload_0
    //   261: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   264: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   267: aload_1
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
    //   287: getstatic com/google/type/TimeOfDay.DEFAULT_INSTANCE : Lcom/google/type/TimeOfDay;
    //   290: areturn
    //   291: aload_2
    //   292: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   295: astore_1
    //   296: aload_3
    //   297: checkcast com/google/type/TimeOfDay
    //   300: astore_2
    //   301: aload_0
    //   302: getfield hours_ : I
    //   305: ifeq -> 314
    //   308: iconst_1
    //   309: istore #7
    //   311: goto -> 317
    //   314: iconst_0
    //   315: istore #7
    //   317: aload_0
    //   318: getfield hours_ : I
    //   321: istore #6
    //   323: aload_2
    //   324: getfield hours_ : I
    //   327: ifeq -> 336
    //   330: iconst_1
    //   331: istore #8
    //   333: goto -> 339
    //   336: iconst_0
    //   337: istore #8
    //   339: aload_0
    //   340: aload_1
    //   341: iload #7
    //   343: iload #6
    //   345: iload #8
    //   347: aload_2
    //   348: getfield hours_ : I
    //   351: invokeinterface visitInt : (ZIZI)I
    //   356: putfield hours_ : I
    //   359: aload_0
    //   360: getfield minutes_ : I
    //   363: ifeq -> 372
    //   366: iconst_1
    //   367: istore #7
    //   369: goto -> 375
    //   372: iconst_0
    //   373: istore #7
    //   375: aload_0
    //   376: getfield minutes_ : I
    //   379: istore #6
    //   381: aload_2
    //   382: getfield minutes_ : I
    //   385: ifeq -> 394
    //   388: iconst_1
    //   389: istore #8
    //   391: goto -> 397
    //   394: iconst_0
    //   395: istore #8
    //   397: aload_0
    //   398: aload_1
    //   399: iload #7
    //   401: iload #6
    //   403: iload #8
    //   405: aload_2
    //   406: getfield minutes_ : I
    //   409: invokeinterface visitInt : (ZIZI)I
    //   414: putfield minutes_ : I
    //   417: aload_0
    //   418: getfield seconds_ : I
    //   421: ifeq -> 430
    //   424: iconst_1
    //   425: istore #7
    //   427: goto -> 433
    //   430: iconst_0
    //   431: istore #7
    //   433: aload_0
    //   434: getfield seconds_ : I
    //   437: istore #6
    //   439: aload_2
    //   440: getfield seconds_ : I
    //   443: ifeq -> 452
    //   446: iconst_1
    //   447: istore #8
    //   449: goto -> 455
    //   452: iconst_0
    //   453: istore #8
    //   455: aload_0
    //   456: aload_1
    //   457: iload #7
    //   459: iload #6
    //   461: iload #8
    //   463: aload_2
    //   464: getfield seconds_ : I
    //   467: invokeinterface visitInt : (ZIZI)I
    //   472: putfield seconds_ : I
    //   475: aload_0
    //   476: getfield nanos_ : I
    //   479: ifeq -> 488
    //   482: iconst_1
    //   483: istore #7
    //   485: goto -> 491
    //   488: iconst_0
    //   489: istore #7
    //   491: aload_0
    //   492: getfield nanos_ : I
    //   495: istore #6
    //   497: iload #5
    //   499: istore #8
    //   501: aload_2
    //   502: getfield nanos_ : I
    //   505: ifeq -> 511
    //   508: iconst_1
    //   509: istore #8
    //   511: aload_0
    //   512: aload_1
    //   513: iload #7
    //   515: iload #6
    //   517: iload #8
    //   519: aload_2
    //   520: getfield nanos_ : I
    //   523: invokeinterface visitInt : (ZIZI)I
    //   528: putfield nanos_ : I
    //   531: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   534: astore_1
    //   535: aload_0
    //   536: areturn
    //   537: new com/google/type/TimeOfDay$Builder
    //   540: dup
    //   541: aconst_null
    //   542: invokespecial <init> : (Lcom/google/type/TimeOfDay$1;)V
    //   545: areturn
    //   546: aconst_null
    //   547: areturn
    //   548: getstatic com/google/type/TimeOfDay.DEFAULT_INSTANCE : Lcom/google/type/TimeOfDay;
    //   551: areturn
    //   552: new com/google/type/TimeOfDay
    //   555: dup
    //   556: invokespecial <init> : ()V
    //   559: areturn
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
  
  public int getHours() {
    return this.hours_;
  }
  
  public int getMinutes() {
    return this.minutes_;
  }
  
  public int getNanos() {
    return this.nanos_;
  }
  
  public int getSeconds() {
    return this.seconds_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    i = this.hours_;
    if (i != 0)
      j = 0 + CodedOutputStream.computeInt32Size(1, i); 
    int k = this.minutes_;
    i = j;
    if (k != 0)
      i = j + CodedOutputStream.computeInt32Size(2, k); 
    k = this.seconds_;
    j = i;
    if (k != 0)
      j = i + CodedOutputStream.computeInt32Size(3, k); 
    k = this.nanos_;
    i = j;
    if (k != 0)
      i = j + CodedOutputStream.computeInt32Size(4, k); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    int i = this.hours_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(1, i); 
    i = this.minutes_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(2, i); 
    i = this.seconds_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(3, i); 
    i = this.nanos_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(4, i); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<TimeOfDay, Builder> implements TimeOfDayOrBuilder {
    private Builder() {
      super(TimeOfDay.DEFAULT_INSTANCE);
    }
    
    public Builder clearHours() {
      copyOnWrite();
      ((TimeOfDay)this.instance).clearHours();
      return this;
    }
    
    public Builder clearMinutes() {
      copyOnWrite();
      ((TimeOfDay)this.instance).clearMinutes();
      return this;
    }
    
    public Builder clearNanos() {
      copyOnWrite();
      ((TimeOfDay)this.instance).clearNanos();
      return this;
    }
    
    public Builder clearSeconds() {
      copyOnWrite();
      ((TimeOfDay)this.instance).clearSeconds();
      return this;
    }
    
    public int getHours() {
      return ((TimeOfDay)this.instance).getHours();
    }
    
    public int getMinutes() {
      return ((TimeOfDay)this.instance).getMinutes();
    }
    
    public int getNanos() {
      return ((TimeOfDay)this.instance).getNanos();
    }
    
    public int getSeconds() {
      return ((TimeOfDay)this.instance).getSeconds();
    }
    
    public Builder setHours(int param1Int) {
      copyOnWrite();
      ((TimeOfDay)this.instance).setHours(param1Int);
      return this;
    }
    
    public Builder setMinutes(int param1Int) {
      copyOnWrite();
      ((TimeOfDay)this.instance).setMinutes(param1Int);
      return this;
    }
    
    public Builder setNanos(int param1Int) {
      copyOnWrite();
      ((TimeOfDay)this.instance).setNanos(param1Int);
      return this;
    }
    
    public Builder setSeconds(int param1Int) {
      copyOnWrite();
      ((TimeOfDay)this.instance).setSeconds(param1Int);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\type\TimeOfDay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */