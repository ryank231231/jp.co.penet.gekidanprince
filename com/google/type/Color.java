package com.google.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FloatValue;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class Color extends GeneratedMessageLite<Color, Color.Builder> implements ColorOrBuilder {
  public static final int ALPHA_FIELD_NUMBER = 4;
  
  public static final int BLUE_FIELD_NUMBER = 3;
  
  private static final Color DEFAULT_INSTANCE = new Color();
  
  public static final int GREEN_FIELD_NUMBER = 2;
  
  private static volatile Parser<Color> PARSER;
  
  public static final int RED_FIELD_NUMBER = 1;
  
  private FloatValue alpha_;
  
  private float blue_;
  
  private float green_;
  
  private float red_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearAlpha() {
    this.alpha_ = null;
  }
  
  private void clearBlue() {
    this.blue_ = 0.0F;
  }
  
  private void clearGreen() {
    this.green_ = 0.0F;
  }
  
  private void clearRed() {
    this.red_ = 0.0F;
  }
  
  public static Color getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeAlpha(FloatValue paramFloatValue) {
    FloatValue floatValue = this.alpha_;
    if (floatValue != null && floatValue != FloatValue.getDefaultInstance()) {
      this.alpha_ = (FloatValue)((FloatValue.Builder)FloatValue.newBuilder(this.alpha_).mergeFrom((GeneratedMessageLite)paramFloatValue)).buildPartial();
    } else {
      this.alpha_ = paramFloatValue;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Color paramColor) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramColor);
  }
  
  public static Color parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Color)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Color parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Color)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Color parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Color)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Color parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Color)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Color parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Color)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Color parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Color)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Color parseFrom(InputStream paramInputStream) throws IOException {
    return (Color)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Color parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Color)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Color parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Color)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Color parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Color)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Color> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setAlpha(FloatValue.Builder paramBuilder) {
    this.alpha_ = (FloatValue)paramBuilder.build();
  }
  
  private void setAlpha(FloatValue paramFloatValue) {
    if (paramFloatValue != null) {
      this.alpha_ = paramFloatValue;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setBlue(float paramFloat) {
    this.blue_ = paramFloat;
  }
  
  private void setGreen(float paramFloat) {
    this.green_ = paramFloat;
  }
  
  private void setRed(float paramFloat) {
    this.red_ = paramFloat;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/type/Color$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 581, 2 -> 577, 3 -> 575, 4 -> 566, 5 -> 345, 6 -> 118, 7 -> 341, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/type/Color.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/type/Color
    //   80: monitorenter
    //   81: getstatic com/google/type/Color.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/type/Color.DEFAULT_INSTANCE : Lcom/google/type/Color;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/type/Color.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/type/Color
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/type/Color
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/type/Color.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_2
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_3
    //   128: iload #6
    //   130: ifne -> 341
    //   133: aload_2
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 285
    //   144: iload #4
    //   146: bipush #13
    //   148: if_icmpeq -> 274
    //   151: iload #4
    //   153: bipush #21
    //   155: if_icmpeq -> 263
    //   158: iload #4
    //   160: bipush #29
    //   162: if_icmpeq -> 252
    //   165: iload #4
    //   167: bipush #34
    //   169: if_icmpeq -> 187
    //   172: aload_2
    //   173: iload #4
    //   175: invokevirtual skipField : (I)Z
    //   178: ifne -> 128
    //   181: iconst_1
    //   182: istore #6
    //   184: goto -> 128
    //   187: aload_0
    //   188: getfield alpha_ : Lcom/google/protobuf/FloatValue;
    //   191: ifnull -> 208
    //   194: aload_0
    //   195: getfield alpha_ : Lcom/google/protobuf/FloatValue;
    //   198: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   201: checkcast com/google/protobuf/FloatValue$Builder
    //   204: astore_1
    //   205: goto -> 210
    //   208: aconst_null
    //   209: astore_1
    //   210: aload_0
    //   211: aload_2
    //   212: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   215: aload_3
    //   216: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   219: checkcast com/google/protobuf/FloatValue
    //   222: putfield alpha_ : Lcom/google/protobuf/FloatValue;
    //   225: aload_1
    //   226: ifnull -> 128
    //   229: aload_1
    //   230: aload_0
    //   231: getfield alpha_ : Lcom/google/protobuf/FloatValue;
    //   234: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   237: pop
    //   238: aload_0
    //   239: aload_1
    //   240: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   243: checkcast com/google/protobuf/FloatValue
    //   246: putfield alpha_ : Lcom/google/protobuf/FloatValue;
    //   249: goto -> 128
    //   252: aload_0
    //   253: aload_2
    //   254: invokevirtual readFloat : ()F
    //   257: putfield blue_ : F
    //   260: goto -> 128
    //   263: aload_0
    //   264: aload_2
    //   265: invokevirtual readFloat : ()F
    //   268: putfield green_ : F
    //   271: goto -> 128
    //   274: aload_0
    //   275: aload_2
    //   276: invokevirtual readFloat : ()F
    //   279: putfield red_ : F
    //   282: goto -> 128
    //   285: iconst_1
    //   286: istore #6
    //   288: goto -> 128
    //   291: astore_1
    //   292: goto -> 339
    //   295: astore_3
    //   296: new java/lang/RuntimeException
    //   299: astore_1
    //   300: new com/google/protobuf/InvalidProtocolBufferException
    //   303: astore_2
    //   304: aload_2
    //   305: aload_3
    //   306: invokevirtual getMessage : ()Ljava/lang/String;
    //   309: invokespecial <init> : (Ljava/lang/String;)V
    //   312: aload_1
    //   313: aload_2
    //   314: aload_0
    //   315: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   318: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   321: aload_1
    //   322: athrow
    //   323: astore_2
    //   324: new java/lang/RuntimeException
    //   327: astore_1
    //   328: aload_1
    //   329: aload_2
    //   330: aload_0
    //   331: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   334: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   337: aload_1
    //   338: athrow
    //   339: aload_1
    //   340: athrow
    //   341: getstatic com/google/type/Color.DEFAULT_INSTANCE : Lcom/google/type/Color;
    //   344: areturn
    //   345: aload_2
    //   346: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   349: astore_1
    //   350: aload_3
    //   351: checkcast com/google/type/Color
    //   354: astore_2
    //   355: aload_0
    //   356: getfield red_ : F
    //   359: fconst_0
    //   360: fcmpl
    //   361: ifeq -> 370
    //   364: iconst_1
    //   365: istore #7
    //   367: goto -> 373
    //   370: iconst_0
    //   371: istore #7
    //   373: aload_0
    //   374: getfield red_ : F
    //   377: fstore #8
    //   379: aload_2
    //   380: getfield red_ : F
    //   383: fconst_0
    //   384: fcmpl
    //   385: ifeq -> 394
    //   388: iconst_1
    //   389: istore #9
    //   391: goto -> 397
    //   394: iconst_0
    //   395: istore #9
    //   397: aload_0
    //   398: aload_1
    //   399: iload #7
    //   401: fload #8
    //   403: iload #9
    //   405: aload_2
    //   406: getfield red_ : F
    //   409: invokeinterface visitFloat : (ZFZF)F
    //   414: putfield red_ : F
    //   417: aload_0
    //   418: getfield green_ : F
    //   421: fconst_0
    //   422: fcmpl
    //   423: ifeq -> 432
    //   426: iconst_1
    //   427: istore #7
    //   429: goto -> 435
    //   432: iconst_0
    //   433: istore #7
    //   435: aload_0
    //   436: getfield green_ : F
    //   439: fstore #8
    //   441: aload_2
    //   442: getfield green_ : F
    //   445: fconst_0
    //   446: fcmpl
    //   447: ifeq -> 456
    //   450: iconst_1
    //   451: istore #9
    //   453: goto -> 459
    //   456: iconst_0
    //   457: istore #9
    //   459: aload_0
    //   460: aload_1
    //   461: iload #7
    //   463: fload #8
    //   465: iload #9
    //   467: aload_2
    //   468: getfield green_ : F
    //   471: invokeinterface visitFloat : (ZFZF)F
    //   476: putfield green_ : F
    //   479: aload_0
    //   480: getfield blue_ : F
    //   483: fconst_0
    //   484: fcmpl
    //   485: ifeq -> 494
    //   488: iconst_1
    //   489: istore #7
    //   491: goto -> 497
    //   494: iconst_0
    //   495: istore #7
    //   497: aload_0
    //   498: getfield blue_ : F
    //   501: fstore #8
    //   503: iload #5
    //   505: istore #9
    //   507: aload_2
    //   508: getfield blue_ : F
    //   511: fconst_0
    //   512: fcmpl
    //   513: ifeq -> 519
    //   516: iconst_1
    //   517: istore #9
    //   519: aload_0
    //   520: aload_1
    //   521: iload #7
    //   523: fload #8
    //   525: iload #9
    //   527: aload_2
    //   528: getfield blue_ : F
    //   531: invokeinterface visitFloat : (ZFZF)F
    //   536: putfield blue_ : F
    //   539: aload_0
    //   540: aload_1
    //   541: aload_0
    //   542: getfield alpha_ : Lcom/google/protobuf/FloatValue;
    //   545: aload_2
    //   546: getfield alpha_ : Lcom/google/protobuf/FloatValue;
    //   549: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   554: checkcast com/google/protobuf/FloatValue
    //   557: putfield alpha_ : Lcom/google/protobuf/FloatValue;
    //   560: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   563: astore_1
    //   564: aload_0
    //   565: areturn
    //   566: new com/google/type/Color$Builder
    //   569: dup
    //   570: aconst_null
    //   571: invokespecial <init> : (Lcom/google/type/Color$1;)V
    //   574: areturn
    //   575: aconst_null
    //   576: areturn
    //   577: getstatic com/google/type/Color.DEFAULT_INSTANCE : Lcom/google/type/Color;
    //   580: areturn
    //   581: new com/google/type/Color
    //   584: dup
    //   585: invokespecial <init> : ()V
    //   588: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	323	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	295	java/io/IOException
    //   133	139	291	finally
    //   172	181	323	com/google/protobuf/InvalidProtocolBufferException
    //   172	181	295	java/io/IOException
    //   172	181	291	finally
    //   187	205	323	com/google/protobuf/InvalidProtocolBufferException
    //   187	205	295	java/io/IOException
    //   187	205	291	finally
    //   210	225	323	com/google/protobuf/InvalidProtocolBufferException
    //   210	225	295	java/io/IOException
    //   210	225	291	finally
    //   229	249	323	com/google/protobuf/InvalidProtocolBufferException
    //   229	249	295	java/io/IOException
    //   229	249	291	finally
    //   252	260	323	com/google/protobuf/InvalidProtocolBufferException
    //   252	260	295	java/io/IOException
    //   252	260	291	finally
    //   263	271	323	com/google/protobuf/InvalidProtocolBufferException
    //   263	271	295	java/io/IOException
    //   263	271	291	finally
    //   274	282	323	com/google/protobuf/InvalidProtocolBufferException
    //   274	282	295	java/io/IOException
    //   274	282	291	finally
    //   296	323	291	finally
    //   324	339	291	finally
  }
  
  public FloatValue getAlpha() {
    FloatValue floatValue1 = this.alpha_;
    FloatValue floatValue2 = floatValue1;
    if (floatValue1 == null)
      floatValue2 = FloatValue.getDefaultInstance(); 
    return floatValue2;
  }
  
  public float getBlue() {
    return this.blue_;
  }
  
  public float getGreen() {
    return this.green_;
  }
  
  public float getRed() {
    return this.red_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    float f = this.red_;
    if (f != 0.0F)
      i = 0 + CodedOutputStream.computeFloatSize(1, f); 
    f = this.green_;
    int j = i;
    if (f != 0.0F)
      j = i + CodedOutputStream.computeFloatSize(2, f); 
    f = this.blue_;
    i = j;
    if (f != 0.0F)
      i = j + CodedOutputStream.computeFloatSize(3, f); 
    j = i;
    if (this.alpha_ != null)
      j = i + CodedOutputStream.computeMessageSize(4, (MessageLite)getAlpha()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public boolean hasAlpha() {
    boolean bool;
    if (this.alpha_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    float f = this.red_;
    if (f != 0.0F)
      paramCodedOutputStream.writeFloat(1, f); 
    f = this.green_;
    if (f != 0.0F)
      paramCodedOutputStream.writeFloat(2, f); 
    f = this.blue_;
    if (f != 0.0F)
      paramCodedOutputStream.writeFloat(3, f); 
    if (this.alpha_ != null)
      paramCodedOutputStream.writeMessage(4, (MessageLite)getAlpha()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Color, Builder> implements ColorOrBuilder {
    private Builder() {
      super(Color.DEFAULT_INSTANCE);
    }
    
    public Builder clearAlpha() {
      copyOnWrite();
      ((Color)this.instance).clearAlpha();
      return this;
    }
    
    public Builder clearBlue() {
      copyOnWrite();
      ((Color)this.instance).clearBlue();
      return this;
    }
    
    public Builder clearGreen() {
      copyOnWrite();
      ((Color)this.instance).clearGreen();
      return this;
    }
    
    public Builder clearRed() {
      copyOnWrite();
      ((Color)this.instance).clearRed();
      return this;
    }
    
    public FloatValue getAlpha() {
      return ((Color)this.instance).getAlpha();
    }
    
    public float getBlue() {
      return ((Color)this.instance).getBlue();
    }
    
    public float getGreen() {
      return ((Color)this.instance).getGreen();
    }
    
    public float getRed() {
      return ((Color)this.instance).getRed();
    }
    
    public boolean hasAlpha() {
      return ((Color)this.instance).hasAlpha();
    }
    
    public Builder mergeAlpha(FloatValue param1FloatValue) {
      copyOnWrite();
      ((Color)this.instance).mergeAlpha(param1FloatValue);
      return this;
    }
    
    public Builder setAlpha(FloatValue.Builder param1Builder) {
      copyOnWrite();
      ((Color)this.instance).setAlpha(param1Builder);
      return this;
    }
    
    public Builder setAlpha(FloatValue param1FloatValue) {
      copyOnWrite();
      ((Color)this.instance).setAlpha(param1FloatValue);
      return this;
    }
    
    public Builder setBlue(float param1Float) {
      copyOnWrite();
      ((Color)this.instance).setBlue(param1Float);
      return this;
    }
    
    public Builder setGreen(float param1Float) {
      copyOnWrite();
      ((Color)this.instance).setGreen(param1Float);
      return this;
    }
    
    public Builder setRed(float param1Float) {
      copyOnWrite();
      ((Color)this.instance).setRed(param1Float);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\type\Color.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */