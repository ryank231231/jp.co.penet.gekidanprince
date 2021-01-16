package com.google.api;

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

public final class ConfigChange extends GeneratedMessageLite<ConfigChange, ConfigChange.Builder> implements ConfigChangeOrBuilder {
  public static final int ADVICES_FIELD_NUMBER = 5;
  
  public static final int CHANGE_TYPE_FIELD_NUMBER = 4;
  
  private static final ConfigChange DEFAULT_INSTANCE = new ConfigChange();
  
  public static final int ELEMENT_FIELD_NUMBER = 1;
  
  public static final int NEW_VALUE_FIELD_NUMBER = 3;
  
  public static final int OLD_VALUE_FIELD_NUMBER = 2;
  
  private static volatile Parser<ConfigChange> PARSER;
  
  private Internal.ProtobufList<Advice> advices_ = emptyProtobufList();
  
  private int bitField0_;
  
  private int changeType_;
  
  private String element_ = "";
  
  private String newValue_ = "";
  
  private String oldValue_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAdvices(int paramInt, Advice.Builder paramBuilder) {
    ensureAdvicesIsMutable();
    this.advices_.add(paramInt, paramBuilder.build());
  }
  
  private void addAdvices(int paramInt, Advice paramAdvice) {
    if (paramAdvice != null) {
      ensureAdvicesIsMutable();
      this.advices_.add(paramInt, paramAdvice);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addAdvices(Advice.Builder paramBuilder) {
    ensureAdvicesIsMutable();
    this.advices_.add(paramBuilder.build());
  }
  
  private void addAdvices(Advice paramAdvice) {
    if (paramAdvice != null) {
      ensureAdvicesIsMutable();
      this.advices_.add(paramAdvice);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addAllAdvices(Iterable<? extends Advice> paramIterable) {
    ensureAdvicesIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.advices_);
  }
  
  private void clearAdvices() {
    this.advices_ = emptyProtobufList();
  }
  
  private void clearChangeType() {
    this.changeType_ = 0;
  }
  
  private void clearElement() {
    this.element_ = getDefaultInstance().getElement();
  }
  
  private void clearNewValue() {
    this.newValue_ = getDefaultInstance().getNewValue();
  }
  
  private void clearOldValue() {
    this.oldValue_ = getDefaultInstance().getOldValue();
  }
  
  private void ensureAdvicesIsMutable() {
    if (!this.advices_.isModifiable())
      this.advices_ = GeneratedMessageLite.mutableCopy(this.advices_); 
  }
  
  public static ConfigChange getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ConfigChange paramConfigChange) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramConfigChange);
  }
  
  public static ConfigChange parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ConfigChange)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ConfigChange parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ConfigChange)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ConfigChange parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (ConfigChange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static ConfigChange parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ConfigChange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static ConfigChange parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (ConfigChange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static ConfigChange parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ConfigChange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ConfigChange parseFrom(InputStream paramInputStream) throws IOException {
    return (ConfigChange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ConfigChange parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ConfigChange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ConfigChange parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (ConfigChange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static ConfigChange parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ConfigChange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ConfigChange> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeAdvices(int paramInt) {
    ensureAdvicesIsMutable();
    this.advices_.remove(paramInt);
  }
  
  private void setAdvices(int paramInt, Advice.Builder paramBuilder) {
    ensureAdvicesIsMutable();
    this.advices_.set(paramInt, paramBuilder.build());
  }
  
  private void setAdvices(int paramInt, Advice paramAdvice) {
    if (paramAdvice != null) {
      ensureAdvicesIsMutable();
      this.advices_.set(paramInt, paramAdvice);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setChangeType(ChangeType paramChangeType) {
    if (paramChangeType != null) {
      this.changeType_ = paramChangeType.getNumber();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setChangeTypeValue(int paramInt) {
    this.changeType_ = paramInt;
  }
  
  private void setElement(String paramString) {
    if (paramString != null) {
      this.element_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setElementBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.element_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setNewValue(String paramString) {
    if (paramString != null) {
      this.newValue_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setNewValueBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.newValue_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setOldValue(String paramString) {
    if (paramString != null) {
      this.oldValue_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setOldValueBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.oldValue_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/ConfigChange$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 579, 2 -> 575, 3 -> 564, 4 -> 555, 5 -> 345, 6 -> 118, 7 -> 341, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/api/ConfigChange.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/api/ConfigChange
    //   80: monitorenter
    //   81: getstatic com/google/api/ConfigChange.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/api/ConfigChange.DEFAULT_INSTANCE : Lcom/google/api/ConfigChange;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/api/ConfigChange.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/api/ConfigChange
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/api/ConfigChange
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/api/ConfigChange.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_1
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_2
    //   128: iload #6
    //   130: ifne -> 341
    //   133: aload_1
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 285
    //   144: iload #4
    //   146: bipush #10
    //   148: if_icmpeq -> 274
    //   151: iload #4
    //   153: bipush #18
    //   155: if_icmpeq -> 263
    //   158: iload #4
    //   160: bipush #26
    //   162: if_icmpeq -> 252
    //   165: iload #4
    //   167: bipush #32
    //   169: if_icmpeq -> 241
    //   172: iload #4
    //   174: bipush #42
    //   176: if_icmpeq -> 194
    //   179: aload_1
    //   180: iload #4
    //   182: invokevirtual skipField : (I)Z
    //   185: ifne -> 128
    //   188: iconst_1
    //   189: istore #6
    //   191: goto -> 128
    //   194: aload_0
    //   195: getfield advices_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   198: invokeinterface isModifiable : ()Z
    //   203: ifne -> 217
    //   206: aload_0
    //   207: aload_0
    //   208: getfield advices_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   211: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   214: putfield advices_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   217: aload_0
    //   218: getfield advices_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   221: aload_1
    //   222: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   225: aload_2
    //   226: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   229: checkcast com/google/api/Advice
    //   232: invokeinterface add : (Ljava/lang/Object;)Z
    //   237: pop
    //   238: goto -> 128
    //   241: aload_0
    //   242: aload_1
    //   243: invokevirtual readEnum : ()I
    //   246: putfield changeType_ : I
    //   249: goto -> 128
    //   252: aload_0
    //   253: aload_1
    //   254: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   257: putfield newValue_ : Ljava/lang/String;
    //   260: goto -> 128
    //   263: aload_0
    //   264: aload_1
    //   265: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   268: putfield oldValue_ : Ljava/lang/String;
    //   271: goto -> 128
    //   274: aload_0
    //   275: aload_1
    //   276: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   279: putfield element_ : Ljava/lang/String;
    //   282: goto -> 128
    //   285: iconst_1
    //   286: istore #6
    //   288: goto -> 128
    //   291: astore_1
    //   292: goto -> 339
    //   295: astore_3
    //   296: new java/lang/RuntimeException
    //   299: astore_2
    //   300: new com/google/protobuf/InvalidProtocolBufferException
    //   303: astore_1
    //   304: aload_1
    //   305: aload_3
    //   306: invokevirtual getMessage : ()Ljava/lang/String;
    //   309: invokespecial <init> : (Ljava/lang/String;)V
    //   312: aload_2
    //   313: aload_1
    //   314: aload_0
    //   315: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   318: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   321: aload_2
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
    //   341: getstatic com/google/api/ConfigChange.DEFAULT_INSTANCE : Lcom/google/api/ConfigChange;
    //   344: areturn
    //   345: aload_2
    //   346: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   349: astore_1
    //   350: aload_3
    //   351: checkcast com/google/api/ConfigChange
    //   354: astore_2
    //   355: aload_0
    //   356: aload_1
    //   357: aload_0
    //   358: getfield element_ : Ljava/lang/String;
    //   361: invokevirtual isEmpty : ()Z
    //   364: iconst_1
    //   365: ixor
    //   366: aload_0
    //   367: getfield element_ : Ljava/lang/String;
    //   370: aload_2
    //   371: getfield element_ : Ljava/lang/String;
    //   374: invokevirtual isEmpty : ()Z
    //   377: iconst_1
    //   378: ixor
    //   379: aload_2
    //   380: getfield element_ : Ljava/lang/String;
    //   383: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   388: putfield element_ : Ljava/lang/String;
    //   391: aload_0
    //   392: aload_1
    //   393: aload_0
    //   394: getfield oldValue_ : Ljava/lang/String;
    //   397: invokevirtual isEmpty : ()Z
    //   400: iconst_1
    //   401: ixor
    //   402: aload_0
    //   403: getfield oldValue_ : Ljava/lang/String;
    //   406: aload_2
    //   407: getfield oldValue_ : Ljava/lang/String;
    //   410: invokevirtual isEmpty : ()Z
    //   413: iconst_1
    //   414: ixor
    //   415: aload_2
    //   416: getfield oldValue_ : Ljava/lang/String;
    //   419: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   424: putfield oldValue_ : Ljava/lang/String;
    //   427: aload_0
    //   428: aload_1
    //   429: aload_0
    //   430: getfield newValue_ : Ljava/lang/String;
    //   433: invokevirtual isEmpty : ()Z
    //   436: iconst_1
    //   437: ixor
    //   438: aload_0
    //   439: getfield newValue_ : Ljava/lang/String;
    //   442: aload_2
    //   443: getfield newValue_ : Ljava/lang/String;
    //   446: invokevirtual isEmpty : ()Z
    //   449: iconst_1
    //   450: ixor
    //   451: aload_2
    //   452: getfield newValue_ : Ljava/lang/String;
    //   455: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   460: putfield newValue_ : Ljava/lang/String;
    //   463: aload_0
    //   464: getfield changeType_ : I
    //   467: ifeq -> 476
    //   470: iconst_1
    //   471: istore #7
    //   473: goto -> 479
    //   476: iconst_0
    //   477: istore #7
    //   479: aload_0
    //   480: getfield changeType_ : I
    //   483: istore #6
    //   485: aload_2
    //   486: getfield changeType_ : I
    //   489: ifeq -> 495
    //   492: iconst_1
    //   493: istore #5
    //   495: aload_0
    //   496: aload_1
    //   497: iload #7
    //   499: iload #6
    //   501: iload #5
    //   503: aload_2
    //   504: getfield changeType_ : I
    //   507: invokeinterface visitInt : (ZIZI)I
    //   512: putfield changeType_ : I
    //   515: aload_0
    //   516: aload_1
    //   517: aload_0
    //   518: getfield advices_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   521: aload_2
    //   522: getfield advices_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   525: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   530: putfield advices_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   533: aload_1
    //   534: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   537: if_acmpne -> 553
    //   540: aload_0
    //   541: aload_0
    //   542: getfield bitField0_ : I
    //   545: aload_2
    //   546: getfield bitField0_ : I
    //   549: ior
    //   550: putfield bitField0_ : I
    //   553: aload_0
    //   554: areturn
    //   555: new com/google/api/ConfigChange$Builder
    //   558: dup
    //   559: aconst_null
    //   560: invokespecial <init> : (Lcom/google/api/ConfigChange$1;)V
    //   563: areturn
    //   564: aload_0
    //   565: getfield advices_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   568: invokeinterface makeImmutable : ()V
    //   573: aconst_null
    //   574: areturn
    //   575: getstatic com/google/api/ConfigChange.DEFAULT_INSTANCE : Lcom/google/api/ConfigChange;
    //   578: areturn
    //   579: new com/google/api/ConfigChange
    //   582: dup
    //   583: invokespecial <init> : ()V
    //   586: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	323	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	295	java/io/IOException
    //   133	139	291	finally
    //   179	188	323	com/google/protobuf/InvalidProtocolBufferException
    //   179	188	295	java/io/IOException
    //   179	188	291	finally
    //   194	217	323	com/google/protobuf/InvalidProtocolBufferException
    //   194	217	295	java/io/IOException
    //   194	217	291	finally
    //   217	238	323	com/google/protobuf/InvalidProtocolBufferException
    //   217	238	295	java/io/IOException
    //   217	238	291	finally
    //   241	249	323	com/google/protobuf/InvalidProtocolBufferException
    //   241	249	295	java/io/IOException
    //   241	249	291	finally
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
  
  public Advice getAdvices(int paramInt) {
    return (Advice)this.advices_.get(paramInt);
  }
  
  public int getAdvicesCount() {
    return this.advices_.size();
  }
  
  public List<Advice> getAdvicesList() {
    return (List<Advice>)this.advices_;
  }
  
  public AdviceOrBuilder getAdvicesOrBuilder(int paramInt) {
    return (AdviceOrBuilder)this.advices_.get(paramInt);
  }
  
  public List<? extends AdviceOrBuilder> getAdvicesOrBuilderList() {
    return (List)this.advices_;
  }
  
  public ChangeType getChangeType() {
    ChangeType changeType1 = ChangeType.forNumber(this.changeType_);
    ChangeType changeType2 = changeType1;
    if (changeType1 == null)
      changeType2 = ChangeType.UNRECOGNIZED; 
    return changeType2;
  }
  
  public int getChangeTypeValue() {
    return this.changeType_;
  }
  
  public String getElement() {
    return this.element_;
  }
  
  public ByteString getElementBytes() {
    return ByteString.copyFromUtf8(this.element_);
  }
  
  public String getNewValue() {
    return this.newValue_;
  }
  
  public ByteString getNewValueBytes() {
    return ByteString.copyFromUtf8(this.newValue_);
  }
  
  public String getOldValue() {
    return this.oldValue_;
  }
  
  public ByteString getOldValueBytes() {
    return ByteString.copyFromUtf8(this.oldValue_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    boolean bool = this.element_.isEmpty();
    byte b1 = 0;
    if (!bool) {
      i = CodedOutputStream.computeStringSize(1, getElement()) + 0;
    } else {
      i = 0;
    } 
    int j = i;
    if (!this.oldValue_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(2, getOldValue()); 
    i = j;
    if (!this.newValue_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(3, getNewValue()); 
    j = i;
    byte b2 = b1;
    if (this.changeType_ != ChangeType.CHANGE_TYPE_UNSPECIFIED.getNumber()) {
      j = i + CodedOutputStream.computeEnumSize(4, this.changeType_);
      b2 = b1;
    } 
    while (b2 < this.advices_.size()) {
      j += CodedOutputStream.computeMessageSize(5, (MessageLite)this.advices_.get(b2));
      b2++;
    } 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.element_.isEmpty())
      paramCodedOutputStream.writeString(1, getElement()); 
    if (!this.oldValue_.isEmpty())
      paramCodedOutputStream.writeString(2, getOldValue()); 
    if (!this.newValue_.isEmpty())
      paramCodedOutputStream.writeString(3, getNewValue()); 
    if (this.changeType_ != ChangeType.CHANGE_TYPE_UNSPECIFIED.getNumber())
      paramCodedOutputStream.writeEnum(4, this.changeType_); 
    for (byte b = 0; b < this.advices_.size(); b++)
      paramCodedOutputStream.writeMessage(5, (MessageLite)this.advices_.get(b)); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ConfigChange, Builder> implements ConfigChangeOrBuilder {
    private Builder() {
      super(ConfigChange.DEFAULT_INSTANCE);
    }
    
    public Builder addAdvices(int param1Int, Advice.Builder param1Builder) {
      copyOnWrite();
      ((ConfigChange)this.instance).addAdvices(param1Int, param1Builder);
      return this;
    }
    
    public Builder addAdvices(int param1Int, Advice param1Advice) {
      copyOnWrite();
      ((ConfigChange)this.instance).addAdvices(param1Int, param1Advice);
      return this;
    }
    
    public Builder addAdvices(Advice.Builder param1Builder) {
      copyOnWrite();
      ((ConfigChange)this.instance).addAdvices(param1Builder);
      return this;
    }
    
    public Builder addAdvices(Advice param1Advice) {
      copyOnWrite();
      ((ConfigChange)this.instance).addAdvices(param1Advice);
      return this;
    }
    
    public Builder addAllAdvices(Iterable<? extends Advice> param1Iterable) {
      copyOnWrite();
      ((ConfigChange)this.instance).addAllAdvices(param1Iterable);
      return this;
    }
    
    public Builder clearAdvices() {
      copyOnWrite();
      ((ConfigChange)this.instance).clearAdvices();
      return this;
    }
    
    public Builder clearChangeType() {
      copyOnWrite();
      ((ConfigChange)this.instance).clearChangeType();
      return this;
    }
    
    public Builder clearElement() {
      copyOnWrite();
      ((ConfigChange)this.instance).clearElement();
      return this;
    }
    
    public Builder clearNewValue() {
      copyOnWrite();
      ((ConfigChange)this.instance).clearNewValue();
      return this;
    }
    
    public Builder clearOldValue() {
      copyOnWrite();
      ((ConfigChange)this.instance).clearOldValue();
      return this;
    }
    
    public Advice getAdvices(int param1Int) {
      return ((ConfigChange)this.instance).getAdvices(param1Int);
    }
    
    public int getAdvicesCount() {
      return ((ConfigChange)this.instance).getAdvicesCount();
    }
    
    public List<Advice> getAdvicesList() {
      return Collections.unmodifiableList(((ConfigChange)this.instance).getAdvicesList());
    }
    
    public ChangeType getChangeType() {
      return ((ConfigChange)this.instance).getChangeType();
    }
    
    public int getChangeTypeValue() {
      return ((ConfigChange)this.instance).getChangeTypeValue();
    }
    
    public String getElement() {
      return ((ConfigChange)this.instance).getElement();
    }
    
    public ByteString getElementBytes() {
      return ((ConfigChange)this.instance).getElementBytes();
    }
    
    public String getNewValue() {
      return ((ConfigChange)this.instance).getNewValue();
    }
    
    public ByteString getNewValueBytes() {
      return ((ConfigChange)this.instance).getNewValueBytes();
    }
    
    public String getOldValue() {
      return ((ConfigChange)this.instance).getOldValue();
    }
    
    public ByteString getOldValueBytes() {
      return ((ConfigChange)this.instance).getOldValueBytes();
    }
    
    public Builder removeAdvices(int param1Int) {
      copyOnWrite();
      ((ConfigChange)this.instance).removeAdvices(param1Int);
      return this;
    }
    
    public Builder setAdvices(int param1Int, Advice.Builder param1Builder) {
      copyOnWrite();
      ((ConfigChange)this.instance).setAdvices(param1Int, param1Builder);
      return this;
    }
    
    public Builder setAdvices(int param1Int, Advice param1Advice) {
      copyOnWrite();
      ((ConfigChange)this.instance).setAdvices(param1Int, param1Advice);
      return this;
    }
    
    public Builder setChangeType(ChangeType param1ChangeType) {
      copyOnWrite();
      ((ConfigChange)this.instance).setChangeType(param1ChangeType);
      return this;
    }
    
    public Builder setChangeTypeValue(int param1Int) {
      copyOnWrite();
      ((ConfigChange)this.instance).setChangeTypeValue(param1Int);
      return this;
    }
    
    public Builder setElement(String param1String) {
      copyOnWrite();
      ((ConfigChange)this.instance).setElement(param1String);
      return this;
    }
    
    public Builder setElementBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ConfigChange)this.instance).setElementBytes(param1ByteString);
      return this;
    }
    
    public Builder setNewValue(String param1String) {
      copyOnWrite();
      ((ConfigChange)this.instance).setNewValue(param1String);
      return this;
    }
    
    public Builder setNewValueBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ConfigChange)this.instance).setNewValueBytes(param1ByteString);
      return this;
    }
    
    public Builder setOldValue(String param1String) {
      copyOnWrite();
      ((ConfigChange)this.instance).setOldValue(param1String);
      return this;
    }
    
    public Builder setOldValueBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ConfigChange)this.instance).setOldValueBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\ConfigChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */