package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class Enum extends GeneratedMessageLite<Enum, Enum.Builder> implements EnumOrBuilder {
  private static final Enum DEFAULT_INSTANCE = new Enum();
  
  public static final int ENUMVALUE_FIELD_NUMBER = 2;
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  public static final int OPTIONS_FIELD_NUMBER = 3;
  
  private static volatile Parser<Enum> PARSER;
  
  public static final int SOURCE_CONTEXT_FIELD_NUMBER = 4;
  
  public static final int SYNTAX_FIELD_NUMBER = 5;
  
  private int bitField0_;
  
  private Internal.ProtobufList<EnumValue> enumvalue_ = emptyProtobufList();
  
  private String name_ = "";
  
  private Internal.ProtobufList<Option> options_ = emptyProtobufList();
  
  private SourceContext sourceContext_;
  
  private int syntax_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllEnumvalue(Iterable<? extends EnumValue> paramIterable) {
    ensureEnumvalueIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.enumvalue_);
  }
  
  private void addAllOptions(Iterable<? extends Option> paramIterable) {
    ensureOptionsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.options_);
  }
  
  private void addEnumvalue(int paramInt, EnumValue.Builder paramBuilder) {
    ensureEnumvalueIsMutable();
    this.enumvalue_.add(paramInt, paramBuilder.build());
  }
  
  private void addEnumvalue(int paramInt, EnumValue paramEnumValue) {
    if (paramEnumValue != null) {
      ensureEnumvalueIsMutable();
      this.enumvalue_.add(paramInt, paramEnumValue);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addEnumvalue(EnumValue.Builder paramBuilder) {
    ensureEnumvalueIsMutable();
    this.enumvalue_.add(paramBuilder.build());
  }
  
  private void addEnumvalue(EnumValue paramEnumValue) {
    if (paramEnumValue != null) {
      ensureEnumvalueIsMutable();
      this.enumvalue_.add(paramEnumValue);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addOptions(int paramInt, Option.Builder paramBuilder) {
    ensureOptionsIsMutable();
    this.options_.add(paramInt, paramBuilder.build());
  }
  
  private void addOptions(int paramInt, Option paramOption) {
    if (paramOption != null) {
      ensureOptionsIsMutable();
      this.options_.add(paramInt, paramOption);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addOptions(Option.Builder paramBuilder) {
    ensureOptionsIsMutable();
    this.options_.add(paramBuilder.build());
  }
  
  private void addOptions(Option paramOption) {
    if (paramOption != null) {
      ensureOptionsIsMutable();
      this.options_.add(paramOption);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearEnumvalue() {
    this.enumvalue_ = emptyProtobufList();
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearOptions() {
    this.options_ = emptyProtobufList();
  }
  
  private void clearSourceContext() {
    this.sourceContext_ = null;
  }
  
  private void clearSyntax() {
    this.syntax_ = 0;
  }
  
  private void ensureEnumvalueIsMutable() {
    if (!this.enumvalue_.isModifiable())
      this.enumvalue_ = GeneratedMessageLite.mutableCopy(this.enumvalue_); 
  }
  
  private void ensureOptionsIsMutable() {
    if (!this.options_.isModifiable())
      this.options_ = GeneratedMessageLite.mutableCopy(this.options_); 
  }
  
  public static Enum getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeSourceContext(SourceContext paramSourceContext) {
    SourceContext sourceContext = this.sourceContext_;
    if (sourceContext != null && sourceContext != SourceContext.getDefaultInstance()) {
      this.sourceContext_ = SourceContext.newBuilder(this.sourceContext_).mergeFrom(paramSourceContext).buildPartial();
    } else {
      this.sourceContext_ = paramSourceContext;
    } 
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Enum paramEnum) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramEnum);
  }
  
  public static Enum parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Enum)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Enum parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Enum)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Enum parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Enum>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Enum parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Enum>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Enum parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<Enum>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Enum parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Enum>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Enum parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<Enum>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Enum parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Enum>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Enum parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Enum>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Enum parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Enum>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Enum> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeEnumvalue(int paramInt) {
    ensureEnumvalueIsMutable();
    this.enumvalue_.remove(paramInt);
  }
  
  private void removeOptions(int paramInt) {
    ensureOptionsIsMutable();
    this.options_.remove(paramInt);
  }
  
  private void setEnumvalue(int paramInt, EnumValue.Builder paramBuilder) {
    ensureEnumvalueIsMutable();
    this.enumvalue_.set(paramInt, paramBuilder.build());
  }
  
  private void setEnumvalue(int paramInt, EnumValue paramEnumValue) {
    if (paramEnumValue != null) {
      ensureEnumvalueIsMutable();
      this.enumvalue_.set(paramInt, paramEnumValue);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setName(String paramString) {
    if (paramString != null) {
      this.name_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setNameBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.name_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setOptions(int paramInt, Option.Builder paramBuilder) {
    ensureOptionsIsMutable();
    this.options_.set(paramInt, paramBuilder.build());
  }
  
  private void setOptions(int paramInt, Option paramOption) {
    if (paramOption != null) {
      ensureOptionsIsMutable();
      this.options_.set(paramInt, paramOption);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setSourceContext(SourceContext.Builder paramBuilder) {
    this.sourceContext_ = paramBuilder.build();
  }
  
  private void setSourceContext(SourceContext paramSourceContext) {
    if (paramSourceContext != null) {
      this.sourceContext_ = paramSourceContext;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setSyntax(Syntax paramSyntax) {
    if (paramSyntax != null) {
      this.syntax_ = paramSyntax.getNumber();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setSyntaxValue(int paramInt) {
    this.syntax_ = paramInt;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/Enum$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 645, 2 -> 641, 3 -> 621, 4 -> 612, 5 -> 435, 6 -> 118, 7 -> 431, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/protobuf/Enum.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/protobuf/Enum
    //   80: monitorenter
    //   81: getstatic com/google/protobuf/Enum.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/protobuf/Enum.DEFAULT_INSTANCE : Lcom/google/protobuf/Enum;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/protobuf/Enum.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/protobuf/Enum
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/protobuf/Enum
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/protobuf/Enum.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_2
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_3
    //   128: iload #6
    //   130: ifne -> 431
    //   133: aload_2
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 375
    //   144: iload #4
    //   146: bipush #10
    //   148: if_icmpeq -> 364
    //   151: iload #4
    //   153: bipush #18
    //   155: if_icmpeq -> 317
    //   158: iload #4
    //   160: bipush #26
    //   162: if_icmpeq -> 270
    //   165: iload #4
    //   167: bipush #34
    //   169: if_icmpeq -> 205
    //   172: iload #4
    //   174: bipush #40
    //   176: if_icmpeq -> 194
    //   179: aload_2
    //   180: iload #4
    //   182: invokevirtual skipField : (I)Z
    //   185: ifne -> 128
    //   188: iconst_1
    //   189: istore #6
    //   191: goto -> 128
    //   194: aload_0
    //   195: aload_2
    //   196: invokevirtual readEnum : ()I
    //   199: putfield syntax_ : I
    //   202: goto -> 128
    //   205: aload_0
    //   206: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   209: ifnull -> 226
    //   212: aload_0
    //   213: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   216: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   219: checkcast com/google/protobuf/SourceContext$Builder
    //   222: astore_1
    //   223: goto -> 228
    //   226: aconst_null
    //   227: astore_1
    //   228: aload_0
    //   229: aload_2
    //   230: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   233: aload_3
    //   234: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   237: checkcast com/google/protobuf/SourceContext
    //   240: putfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   243: aload_1
    //   244: ifnull -> 128
    //   247: aload_1
    //   248: aload_0
    //   249: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   252: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   255: pop
    //   256: aload_0
    //   257: aload_1
    //   258: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   261: checkcast com/google/protobuf/SourceContext
    //   264: putfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   267: goto -> 128
    //   270: aload_0
    //   271: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   274: invokeinterface isModifiable : ()Z
    //   279: ifne -> 293
    //   282: aload_0
    //   283: aload_0
    //   284: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   287: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   290: putfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   293: aload_0
    //   294: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   297: aload_2
    //   298: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   301: aload_3
    //   302: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   305: checkcast com/google/protobuf/Option
    //   308: invokeinterface add : (Ljava/lang/Object;)Z
    //   313: pop
    //   314: goto -> 128
    //   317: aload_0
    //   318: getfield enumvalue_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   321: invokeinterface isModifiable : ()Z
    //   326: ifne -> 340
    //   329: aload_0
    //   330: aload_0
    //   331: getfield enumvalue_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   334: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   337: putfield enumvalue_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   340: aload_0
    //   341: getfield enumvalue_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   344: aload_2
    //   345: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   348: aload_3
    //   349: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   352: checkcast com/google/protobuf/EnumValue
    //   355: invokeinterface add : (Ljava/lang/Object;)Z
    //   360: pop
    //   361: goto -> 128
    //   364: aload_0
    //   365: aload_2
    //   366: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   369: putfield name_ : Ljava/lang/String;
    //   372: goto -> 128
    //   375: iconst_1
    //   376: istore #6
    //   378: goto -> 128
    //   381: astore_1
    //   382: goto -> 429
    //   385: astore_2
    //   386: new java/lang/RuntimeException
    //   389: astore_1
    //   390: new com/google/protobuf/InvalidProtocolBufferException
    //   393: astore_3
    //   394: aload_3
    //   395: aload_2
    //   396: invokevirtual getMessage : ()Ljava/lang/String;
    //   399: invokespecial <init> : (Ljava/lang/String;)V
    //   402: aload_1
    //   403: aload_3
    //   404: aload_0
    //   405: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   408: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   411: aload_1
    //   412: athrow
    //   413: astore_2
    //   414: new java/lang/RuntimeException
    //   417: astore_1
    //   418: aload_1
    //   419: aload_2
    //   420: aload_0
    //   421: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   424: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   427: aload_1
    //   428: athrow
    //   429: aload_1
    //   430: athrow
    //   431: getstatic com/google/protobuf/Enum.DEFAULT_INSTANCE : Lcom/google/protobuf/Enum;
    //   434: areturn
    //   435: aload_2
    //   436: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   439: astore_1
    //   440: aload_3
    //   441: checkcast com/google/protobuf/Enum
    //   444: astore_2
    //   445: aload_0
    //   446: aload_1
    //   447: aload_0
    //   448: getfield name_ : Ljava/lang/String;
    //   451: invokevirtual isEmpty : ()Z
    //   454: iconst_1
    //   455: ixor
    //   456: aload_0
    //   457: getfield name_ : Ljava/lang/String;
    //   460: aload_2
    //   461: getfield name_ : Ljava/lang/String;
    //   464: invokevirtual isEmpty : ()Z
    //   467: iconst_1
    //   468: ixor
    //   469: aload_2
    //   470: getfield name_ : Ljava/lang/String;
    //   473: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   478: putfield name_ : Ljava/lang/String;
    //   481: aload_0
    //   482: aload_1
    //   483: aload_0
    //   484: getfield enumvalue_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   487: aload_2
    //   488: getfield enumvalue_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   491: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   496: putfield enumvalue_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   499: aload_0
    //   500: aload_1
    //   501: aload_0
    //   502: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   505: aload_2
    //   506: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   509: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   514: putfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   517: aload_0
    //   518: aload_1
    //   519: aload_0
    //   520: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   523: aload_2
    //   524: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   527: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   532: checkcast com/google/protobuf/SourceContext
    //   535: putfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   538: aload_0
    //   539: getfield syntax_ : I
    //   542: ifeq -> 551
    //   545: iconst_1
    //   546: istore #7
    //   548: goto -> 554
    //   551: iconst_0
    //   552: istore #7
    //   554: aload_0
    //   555: getfield syntax_ : I
    //   558: istore #6
    //   560: aload_2
    //   561: getfield syntax_ : I
    //   564: ifeq -> 570
    //   567: iconst_1
    //   568: istore #5
    //   570: aload_0
    //   571: aload_1
    //   572: iload #7
    //   574: iload #6
    //   576: iload #5
    //   578: aload_2
    //   579: getfield syntax_ : I
    //   582: invokeinterface visitInt : (ZIZI)I
    //   587: putfield syntax_ : I
    //   590: aload_1
    //   591: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   594: if_acmpne -> 610
    //   597: aload_0
    //   598: aload_0
    //   599: getfield bitField0_ : I
    //   602: aload_2
    //   603: getfield bitField0_ : I
    //   606: ior
    //   607: putfield bitField0_ : I
    //   610: aload_0
    //   611: areturn
    //   612: new com/google/protobuf/Enum$Builder
    //   615: dup
    //   616: aconst_null
    //   617: invokespecial <init> : (Lcom/google/protobuf/Enum$1;)V
    //   620: areturn
    //   621: aload_0
    //   622: getfield enumvalue_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   625: invokeinterface makeImmutable : ()V
    //   630: aload_0
    //   631: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   634: invokeinterface makeImmutable : ()V
    //   639: aconst_null
    //   640: areturn
    //   641: getstatic com/google/protobuf/Enum.DEFAULT_INSTANCE : Lcom/google/protobuf/Enum;
    //   644: areturn
    //   645: new com/google/protobuf/Enum
    //   648: dup
    //   649: invokespecial <init> : ()V
    //   652: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	413	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	385	java/io/IOException
    //   133	139	381	finally
    //   179	188	413	com/google/protobuf/InvalidProtocolBufferException
    //   179	188	385	java/io/IOException
    //   179	188	381	finally
    //   194	202	413	com/google/protobuf/InvalidProtocolBufferException
    //   194	202	385	java/io/IOException
    //   194	202	381	finally
    //   205	223	413	com/google/protobuf/InvalidProtocolBufferException
    //   205	223	385	java/io/IOException
    //   205	223	381	finally
    //   228	243	413	com/google/protobuf/InvalidProtocolBufferException
    //   228	243	385	java/io/IOException
    //   228	243	381	finally
    //   247	267	413	com/google/protobuf/InvalidProtocolBufferException
    //   247	267	385	java/io/IOException
    //   247	267	381	finally
    //   270	293	413	com/google/protobuf/InvalidProtocolBufferException
    //   270	293	385	java/io/IOException
    //   270	293	381	finally
    //   293	314	413	com/google/protobuf/InvalidProtocolBufferException
    //   293	314	385	java/io/IOException
    //   293	314	381	finally
    //   317	340	413	com/google/protobuf/InvalidProtocolBufferException
    //   317	340	385	java/io/IOException
    //   317	340	381	finally
    //   340	361	413	com/google/protobuf/InvalidProtocolBufferException
    //   340	361	385	java/io/IOException
    //   340	361	381	finally
    //   364	372	413	com/google/protobuf/InvalidProtocolBufferException
    //   364	372	385	java/io/IOException
    //   364	372	381	finally
    //   386	413	381	finally
    //   414	429	381	finally
  }
  
  public EnumValue getEnumvalue(int paramInt) {
    return this.enumvalue_.get(paramInt);
  }
  
  public int getEnumvalueCount() {
    return this.enumvalue_.size();
  }
  
  public List<EnumValue> getEnumvalueList() {
    return this.enumvalue_;
  }
  
  public EnumValueOrBuilder getEnumvalueOrBuilder(int paramInt) {
    return this.enumvalue_.get(paramInt);
  }
  
  public List<? extends EnumValueOrBuilder> getEnumvalueOrBuilderList() {
    return (List)this.enumvalue_;
  }
  
  public String getName() {
    return this.name_;
  }
  
  public ByteString getNameBytes() {
    return ByteString.copyFromUtf8(this.name_);
  }
  
  public Option getOptions(int paramInt) {
    return this.options_.get(paramInt);
  }
  
  public int getOptionsCount() {
    return this.options_.size();
  }
  
  public List<Option> getOptionsList() {
    return this.options_;
  }
  
  public OptionOrBuilder getOptionsOrBuilder(int paramInt) {
    return this.options_.get(paramInt);
  }
  
  public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
    return (List)this.options_;
  }
  
  public int getSerializedSize() {
    byte b3;
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    boolean bool = this.name_.isEmpty();
    byte b1 = 0;
    if (!bool) {
      i = CodedOutputStream.computeStringSize(1, getName()) + 0;
    } else {
      i = 0;
    } 
    byte b2 = 0;
    int j = i;
    while (true) {
      b3 = b1;
      i = j;
      if (b2 < this.enumvalue_.size()) {
        j += CodedOutputStream.computeMessageSize(2, this.enumvalue_.get(b2));
        b2++;
        continue;
      } 
      break;
    } 
    while (b3 < this.options_.size()) {
      i += CodedOutputStream.computeMessageSize(3, this.options_.get(b3));
      b3++;
    } 
    j = i;
    if (this.sourceContext_ != null)
      j = i + CodedOutputStream.computeMessageSize(4, getSourceContext()); 
    i = j;
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber())
      i = j + CodedOutputStream.computeEnumSize(5, this.syntax_); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public SourceContext getSourceContext() {
    SourceContext sourceContext1 = this.sourceContext_;
    SourceContext sourceContext2 = sourceContext1;
    if (sourceContext1 == null)
      sourceContext2 = SourceContext.getDefaultInstance(); 
    return sourceContext2;
  }
  
  public Syntax getSyntax() {
    Syntax syntax1 = Syntax.forNumber(this.syntax_);
    Syntax syntax2 = syntax1;
    if (syntax1 == null)
      syntax2 = Syntax.UNRECOGNIZED; 
    return syntax2;
  }
  
  public int getSyntaxValue() {
    return this.syntax_;
  }
  
  public boolean hasSourceContext() {
    boolean bool;
    if (this.sourceContext_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    byte b3;
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(1, getName()); 
    byte b1 = 0;
    byte b2 = 0;
    while (true) {
      b3 = b1;
      if (b2 < this.enumvalue_.size()) {
        paramCodedOutputStream.writeMessage(2, this.enumvalue_.get(b2));
        b2++;
        continue;
      } 
      break;
    } 
    while (b3 < this.options_.size()) {
      paramCodedOutputStream.writeMessage(3, this.options_.get(b3));
      b3++;
    } 
    if (this.sourceContext_ != null)
      paramCodedOutputStream.writeMessage(4, getSourceContext()); 
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber())
      paramCodedOutputStream.writeEnum(5, this.syntax_); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Enum, Builder> implements EnumOrBuilder {
    private Builder() {
      super(Enum.DEFAULT_INSTANCE);
    }
    
    public Builder addAllEnumvalue(Iterable<? extends EnumValue> param1Iterable) {
      copyOnWrite();
      this.instance.addAllEnumvalue(param1Iterable);
      return this;
    }
    
    public Builder addAllOptions(Iterable<? extends Option> param1Iterable) {
      copyOnWrite();
      this.instance.addAllOptions(param1Iterable);
      return this;
    }
    
    public Builder addEnumvalue(int param1Int, EnumValue.Builder param1Builder) {
      copyOnWrite();
      this.instance.addEnumvalue(param1Int, param1Builder);
      return this;
    }
    
    public Builder addEnumvalue(int param1Int, EnumValue param1EnumValue) {
      copyOnWrite();
      this.instance.addEnumvalue(param1Int, param1EnumValue);
      return this;
    }
    
    public Builder addEnumvalue(EnumValue.Builder param1Builder) {
      copyOnWrite();
      this.instance.addEnumvalue(param1Builder);
      return this;
    }
    
    public Builder addEnumvalue(EnumValue param1EnumValue) {
      copyOnWrite();
      this.instance.addEnumvalue(param1EnumValue);
      return this;
    }
    
    public Builder addOptions(int param1Int, Option.Builder param1Builder) {
      copyOnWrite();
      this.instance.addOptions(param1Int, param1Builder);
      return this;
    }
    
    public Builder addOptions(int param1Int, Option param1Option) {
      copyOnWrite();
      this.instance.addOptions(param1Int, param1Option);
      return this;
    }
    
    public Builder addOptions(Option.Builder param1Builder) {
      copyOnWrite();
      this.instance.addOptions(param1Builder);
      return this;
    }
    
    public Builder addOptions(Option param1Option) {
      copyOnWrite();
      this.instance.addOptions(param1Option);
      return this;
    }
    
    public Builder clearEnumvalue() {
      copyOnWrite();
      this.instance.clearEnumvalue();
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      this.instance.clearName();
      return this;
    }
    
    public Builder clearOptions() {
      copyOnWrite();
      this.instance.clearOptions();
      return this;
    }
    
    public Builder clearSourceContext() {
      copyOnWrite();
      this.instance.clearSourceContext();
      return this;
    }
    
    public Builder clearSyntax() {
      copyOnWrite();
      this.instance.clearSyntax();
      return this;
    }
    
    public EnumValue getEnumvalue(int param1Int) {
      return this.instance.getEnumvalue(param1Int);
    }
    
    public int getEnumvalueCount() {
      return this.instance.getEnumvalueCount();
    }
    
    public List<EnumValue> getEnumvalueList() {
      return Collections.unmodifiableList(this.instance.getEnumvalueList());
    }
    
    public String getName() {
      return this.instance.getName();
    }
    
    public ByteString getNameBytes() {
      return this.instance.getNameBytes();
    }
    
    public Option getOptions(int param1Int) {
      return this.instance.getOptions(param1Int);
    }
    
    public int getOptionsCount() {
      return this.instance.getOptionsCount();
    }
    
    public List<Option> getOptionsList() {
      return Collections.unmodifiableList(this.instance.getOptionsList());
    }
    
    public SourceContext getSourceContext() {
      return this.instance.getSourceContext();
    }
    
    public Syntax getSyntax() {
      return this.instance.getSyntax();
    }
    
    public int getSyntaxValue() {
      return this.instance.getSyntaxValue();
    }
    
    public boolean hasSourceContext() {
      return this.instance.hasSourceContext();
    }
    
    public Builder mergeSourceContext(SourceContext param1SourceContext) {
      copyOnWrite();
      this.instance.mergeSourceContext(param1SourceContext);
      return this;
    }
    
    public Builder removeEnumvalue(int param1Int) {
      copyOnWrite();
      this.instance.removeEnumvalue(param1Int);
      return this;
    }
    
    public Builder removeOptions(int param1Int) {
      copyOnWrite();
      this.instance.removeOptions(param1Int);
      return this;
    }
    
    public Builder setEnumvalue(int param1Int, EnumValue.Builder param1Builder) {
      copyOnWrite();
      this.instance.setEnumvalue(param1Int, param1Builder);
      return this;
    }
    
    public Builder setEnumvalue(int param1Int, EnumValue param1EnumValue) {
      copyOnWrite();
      this.instance.setEnumvalue(param1Int, param1EnumValue);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      this.instance.setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.setNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setOptions(int param1Int, Option.Builder param1Builder) {
      copyOnWrite();
      this.instance.setOptions(param1Int, param1Builder);
      return this;
    }
    
    public Builder setOptions(int param1Int, Option param1Option) {
      copyOnWrite();
      this.instance.setOptions(param1Int, param1Option);
      return this;
    }
    
    public Builder setSourceContext(SourceContext.Builder param1Builder) {
      copyOnWrite();
      this.instance.setSourceContext(param1Builder);
      return this;
    }
    
    public Builder setSourceContext(SourceContext param1SourceContext) {
      copyOnWrite();
      this.instance.setSourceContext(param1SourceContext);
      return this;
    }
    
    public Builder setSyntax(Syntax param1Syntax) {
      copyOnWrite();
      this.instance.setSyntax(param1Syntax);
      return this;
    }
    
    public Builder setSyntaxValue(int param1Int) {
      copyOnWrite();
      this.instance.setSyntaxValue(param1Int);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\Enum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */