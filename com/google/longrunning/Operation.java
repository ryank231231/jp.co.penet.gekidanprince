package com.google.longrunning;

import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.rpc.Status;
import java.io.IOException;
import java.io.InputStream;

public final class Operation extends GeneratedMessageLite<Operation, Operation.Builder> implements OperationOrBuilder {
  private static final Operation DEFAULT_INSTANCE = new Operation();
  
  public static final int DONE_FIELD_NUMBER = 3;
  
  public static final int ERROR_FIELD_NUMBER = 4;
  
  public static final int METADATA_FIELD_NUMBER = 2;
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  private static volatile Parser<Operation> PARSER;
  
  public static final int RESPONSE_FIELD_NUMBER = 5;
  
  private boolean done_;
  
  private Any metadata_;
  
  private String name_ = "";
  
  private int resultCase_ = 0;
  
  private Object result_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearDone() {
    this.done_ = false;
  }
  
  private void clearError() {
    if (this.resultCase_ == 4) {
      this.resultCase_ = 0;
      this.result_ = null;
    } 
  }
  
  private void clearMetadata() {
    this.metadata_ = null;
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearResponse() {
    if (this.resultCase_ == 5) {
      this.resultCase_ = 0;
      this.result_ = null;
    } 
  }
  
  private void clearResult() {
    this.resultCase_ = 0;
    this.result_ = null;
  }
  
  public static Operation getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeError(Status paramStatus) {
    if (this.resultCase_ == 4 && this.result_ != Status.getDefaultInstance()) {
      this.result_ = ((Status.Builder)Status.newBuilder((Status)this.result_).mergeFrom((GeneratedMessageLite)paramStatus)).buildPartial();
    } else {
      this.result_ = paramStatus;
    } 
    this.resultCase_ = 4;
  }
  
  private void mergeMetadata(Any paramAny) {
    Any any = this.metadata_;
    if (any != null && any != Any.getDefaultInstance()) {
      this.metadata_ = (Any)((Any.Builder)Any.newBuilder(this.metadata_).mergeFrom((GeneratedMessageLite)paramAny)).buildPartial();
    } else {
      this.metadata_ = paramAny;
    } 
  }
  
  private void mergeResponse(Any paramAny) {
    if (this.resultCase_ == 5 && this.result_ != Any.getDefaultInstance()) {
      this.result_ = ((Any.Builder)Any.newBuilder((Any)this.result_).mergeFrom((GeneratedMessageLite)paramAny)).buildPartial();
    } else {
      this.result_ = paramAny;
    } 
    this.resultCase_ = 5;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Operation paramOperation) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramOperation);
  }
  
  public static Operation parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Operation)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Operation parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Operation)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Operation parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Operation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Operation parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Operation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Operation parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Operation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Operation parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Operation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Operation parseFrom(InputStream paramInputStream) throws IOException {
    return (Operation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Operation parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Operation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Operation parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Operation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Operation parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Operation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Operation> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setDone(boolean paramBoolean) {
    this.done_ = paramBoolean;
  }
  
  private void setError(Status.Builder paramBuilder) {
    this.result_ = paramBuilder.build();
    this.resultCase_ = 4;
  }
  
  private void setError(Status paramStatus) {
    if (paramStatus != null) {
      this.result_ = paramStatus;
      this.resultCase_ = 4;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setMetadata(Any.Builder paramBuilder) {
    this.metadata_ = (Any)paramBuilder.build();
  }
  
  private void setMetadata(Any paramAny) {
    if (paramAny != null) {
      this.metadata_ = paramAny;
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
  
  private void setResponse(Any.Builder paramBuilder) {
    this.result_ = paramBuilder.build();
    this.resultCase_ = 5;
  }
  
  private void setResponse(Any paramAny) {
    if (paramAny != null) {
      this.result_ = paramAny;
      this.resultCase_ = 5;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/longrunning/Operation$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iconst_0
    //   17: istore #7
    //   19: iconst_0
    //   20: istore #8
    //   22: iload #4
    //   24: tableswitch default -> 72, 1 -> 762, 2 -> 758, 3 -> 756, 4 -> 747, 5 -> 491, 6 -> 126, 7 -> 487, 8 -> 80
    //   72: new java/lang/UnsupportedOperationException
    //   75: dup
    //   76: invokespecial <init> : ()V
    //   79: athrow
    //   80: getstatic com/google/longrunning/Operation.PARSER : Lcom/google/protobuf/Parser;
    //   83: ifnonnull -> 122
    //   86: ldc com/google/longrunning/Operation
    //   88: monitorenter
    //   89: getstatic com/google/longrunning/Operation.PARSER : Lcom/google/protobuf/Parser;
    //   92: ifnonnull -> 110
    //   95: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   98: astore_1
    //   99: aload_1
    //   100: getstatic com/google/longrunning/Operation.DEFAULT_INSTANCE : Lcom/google/longrunning/Operation;
    //   103: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   106: aload_1
    //   107: putstatic com/google/longrunning/Operation.PARSER : Lcom/google/protobuf/Parser;
    //   110: ldc com/google/longrunning/Operation
    //   112: monitorexit
    //   113: goto -> 122
    //   116: astore_1
    //   117: ldc com/google/longrunning/Operation
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    //   122: getstatic com/google/longrunning/Operation.PARSER : Lcom/google/protobuf/Parser;
    //   125: areturn
    //   126: aload_2
    //   127: checkcast com/google/protobuf/CodedInputStream
    //   130: astore_2
    //   131: aload_3
    //   132: checkcast com/google/protobuf/ExtensionRegistryLite
    //   135: astore_3
    //   136: iload #8
    //   138: ifne -> 487
    //   141: aload_2
    //   142: invokevirtual readTag : ()I
    //   145: istore #4
    //   147: iload #4
    //   149: ifeq -> 431
    //   152: iload #4
    //   154: bipush #10
    //   156: if_icmpeq -> 420
    //   159: iload #4
    //   161: bipush #18
    //   163: if_icmpeq -> 355
    //   166: iload #4
    //   168: bipush #24
    //   170: if_icmpeq -> 344
    //   173: iload #4
    //   175: bipush #34
    //   177: if_icmpeq -> 273
    //   180: iload #4
    //   182: bipush #42
    //   184: if_icmpeq -> 202
    //   187: aload_2
    //   188: iload #4
    //   190: invokevirtual skipField : (I)Z
    //   193: ifne -> 136
    //   196: iconst_1
    //   197: istore #8
    //   199: goto -> 136
    //   202: aload_0
    //   203: getfield resultCase_ : I
    //   206: iconst_5
    //   207: if_icmpne -> 227
    //   210: aload_0
    //   211: getfield result_ : Ljava/lang/Object;
    //   214: checkcast com/google/protobuf/Any
    //   217: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   220: checkcast com/google/protobuf/Any$Builder
    //   223: astore_1
    //   224: goto -> 229
    //   227: aconst_null
    //   228: astore_1
    //   229: aload_0
    //   230: aload_2
    //   231: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   234: aload_3
    //   235: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   238: putfield result_ : Ljava/lang/Object;
    //   241: aload_1
    //   242: ifnull -> 265
    //   245: aload_1
    //   246: aload_0
    //   247: getfield result_ : Ljava/lang/Object;
    //   250: checkcast com/google/protobuf/Any
    //   253: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   256: pop
    //   257: aload_0
    //   258: aload_1
    //   259: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   262: putfield result_ : Ljava/lang/Object;
    //   265: aload_0
    //   266: iconst_5
    //   267: putfield resultCase_ : I
    //   270: goto -> 136
    //   273: aload_0
    //   274: getfield resultCase_ : I
    //   277: iconst_4
    //   278: if_icmpne -> 298
    //   281: aload_0
    //   282: getfield result_ : Ljava/lang/Object;
    //   285: checkcast com/google/rpc/Status
    //   288: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   291: checkcast com/google/rpc/Status$Builder
    //   294: astore_1
    //   295: goto -> 300
    //   298: aconst_null
    //   299: astore_1
    //   300: aload_0
    //   301: aload_2
    //   302: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   305: aload_3
    //   306: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   309: putfield result_ : Ljava/lang/Object;
    //   312: aload_1
    //   313: ifnull -> 336
    //   316: aload_1
    //   317: aload_0
    //   318: getfield result_ : Ljava/lang/Object;
    //   321: checkcast com/google/rpc/Status
    //   324: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   327: pop
    //   328: aload_0
    //   329: aload_1
    //   330: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   333: putfield result_ : Ljava/lang/Object;
    //   336: aload_0
    //   337: iconst_4
    //   338: putfield resultCase_ : I
    //   341: goto -> 136
    //   344: aload_0
    //   345: aload_2
    //   346: invokevirtual readBool : ()Z
    //   349: putfield done_ : Z
    //   352: goto -> 136
    //   355: aload_0
    //   356: getfield metadata_ : Lcom/google/protobuf/Any;
    //   359: ifnull -> 376
    //   362: aload_0
    //   363: getfield metadata_ : Lcom/google/protobuf/Any;
    //   366: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   369: checkcast com/google/protobuf/Any$Builder
    //   372: astore_1
    //   373: goto -> 378
    //   376: aconst_null
    //   377: astore_1
    //   378: aload_0
    //   379: aload_2
    //   380: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   383: aload_3
    //   384: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   387: checkcast com/google/protobuf/Any
    //   390: putfield metadata_ : Lcom/google/protobuf/Any;
    //   393: aload_1
    //   394: ifnull -> 136
    //   397: aload_1
    //   398: aload_0
    //   399: getfield metadata_ : Lcom/google/protobuf/Any;
    //   402: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   405: pop
    //   406: aload_0
    //   407: aload_1
    //   408: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   411: checkcast com/google/protobuf/Any
    //   414: putfield metadata_ : Lcom/google/protobuf/Any;
    //   417: goto -> 136
    //   420: aload_0
    //   421: aload_2
    //   422: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   425: putfield name_ : Ljava/lang/String;
    //   428: goto -> 136
    //   431: iconst_1
    //   432: istore #8
    //   434: goto -> 136
    //   437: astore_1
    //   438: goto -> 485
    //   441: astore_3
    //   442: new java/lang/RuntimeException
    //   445: astore_1
    //   446: new com/google/protobuf/InvalidProtocolBufferException
    //   449: astore_2
    //   450: aload_2
    //   451: aload_3
    //   452: invokevirtual getMessage : ()Ljava/lang/String;
    //   455: invokespecial <init> : (Ljava/lang/String;)V
    //   458: aload_1
    //   459: aload_2
    //   460: aload_0
    //   461: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   464: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   467: aload_1
    //   468: athrow
    //   469: astore_2
    //   470: new java/lang/RuntimeException
    //   473: astore_1
    //   474: aload_1
    //   475: aload_2
    //   476: aload_0
    //   477: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   480: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   483: aload_1
    //   484: athrow
    //   485: aload_1
    //   486: athrow
    //   487: getstatic com/google/longrunning/Operation.DEFAULT_INSTANCE : Lcom/google/longrunning/Operation;
    //   490: areturn
    //   491: aload_2
    //   492: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   495: astore_1
    //   496: aload_3
    //   497: checkcast com/google/longrunning/Operation
    //   500: astore_2
    //   501: aload_0
    //   502: aload_1
    //   503: aload_0
    //   504: getfield name_ : Ljava/lang/String;
    //   507: invokevirtual isEmpty : ()Z
    //   510: iconst_1
    //   511: ixor
    //   512: aload_0
    //   513: getfield name_ : Ljava/lang/String;
    //   516: aload_2
    //   517: getfield name_ : Ljava/lang/String;
    //   520: invokevirtual isEmpty : ()Z
    //   523: iconst_1
    //   524: ixor
    //   525: aload_2
    //   526: getfield name_ : Ljava/lang/String;
    //   529: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   534: putfield name_ : Ljava/lang/String;
    //   537: aload_0
    //   538: aload_1
    //   539: aload_0
    //   540: getfield metadata_ : Lcom/google/protobuf/Any;
    //   543: aload_2
    //   544: getfield metadata_ : Lcom/google/protobuf/Any;
    //   547: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   552: checkcast com/google/protobuf/Any
    //   555: putfield metadata_ : Lcom/google/protobuf/Any;
    //   558: aload_0
    //   559: getfield done_ : Z
    //   562: istore #9
    //   564: aload_2
    //   565: getfield done_ : Z
    //   568: istore #10
    //   570: aload_0
    //   571: aload_1
    //   572: iload #9
    //   574: iload #9
    //   576: iload #10
    //   578: iload #10
    //   580: invokeinterface visitBoolean : (ZZZZ)Z
    //   585: putfield done_ : Z
    //   588: getstatic com/google/longrunning/Operation$1.$SwitchMap$com$google$longrunning$Operation$ResultCase : [I
    //   591: aload_2
    //   592: invokevirtual getResultCase : ()Lcom/google/longrunning/Operation$ResultCase;
    //   595: invokevirtual ordinal : ()I
    //   598: iaload
    //   599: tableswitch default -> 624, 1 -> 686, 2 -> 648, 3 -> 627
    //   624: goto -> 721
    //   627: aload_0
    //   628: getfield resultCase_ : I
    //   631: ifeq -> 637
    //   634: iconst_1
    //   635: istore #5
    //   637: aload_1
    //   638: iload #5
    //   640: invokeinterface visitOneofNotSet : (Z)V
    //   645: goto -> 721
    //   648: iload #6
    //   650: istore #5
    //   652: aload_0
    //   653: getfield resultCase_ : I
    //   656: iconst_5
    //   657: if_icmpne -> 663
    //   660: iconst_1
    //   661: istore #5
    //   663: aload_0
    //   664: aload_1
    //   665: iload #5
    //   667: aload_0
    //   668: getfield result_ : Ljava/lang/Object;
    //   671: aload_2
    //   672: getfield result_ : Ljava/lang/Object;
    //   675: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   680: putfield result_ : Ljava/lang/Object;
    //   683: goto -> 721
    //   686: iload #7
    //   688: istore #5
    //   690: aload_0
    //   691: getfield resultCase_ : I
    //   694: iconst_4
    //   695: if_icmpne -> 701
    //   698: iconst_1
    //   699: istore #5
    //   701: aload_0
    //   702: aload_1
    //   703: iload #5
    //   705: aload_0
    //   706: getfield result_ : Ljava/lang/Object;
    //   709: aload_2
    //   710: getfield result_ : Ljava/lang/Object;
    //   713: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   718: putfield result_ : Ljava/lang/Object;
    //   721: aload_1
    //   722: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   725: if_acmpne -> 745
    //   728: aload_2
    //   729: getfield resultCase_ : I
    //   732: istore #8
    //   734: iload #8
    //   736: ifeq -> 745
    //   739: aload_0
    //   740: iload #8
    //   742: putfield resultCase_ : I
    //   745: aload_0
    //   746: areturn
    //   747: new com/google/longrunning/Operation$Builder
    //   750: dup
    //   751: aconst_null
    //   752: invokespecial <init> : (Lcom/google/longrunning/Operation$1;)V
    //   755: areturn
    //   756: aconst_null
    //   757: areturn
    //   758: getstatic com/google/longrunning/Operation.DEFAULT_INSTANCE : Lcom/google/longrunning/Operation;
    //   761: areturn
    //   762: new com/google/longrunning/Operation
    //   765: dup
    //   766: invokespecial <init> : ()V
    //   769: areturn
    // Exception table:
    //   from	to	target	type
    //   89	110	116	finally
    //   110	113	116	finally
    //   117	120	116	finally
    //   141	147	469	com/google/protobuf/InvalidProtocolBufferException
    //   141	147	441	java/io/IOException
    //   141	147	437	finally
    //   187	196	469	com/google/protobuf/InvalidProtocolBufferException
    //   187	196	441	java/io/IOException
    //   187	196	437	finally
    //   202	224	469	com/google/protobuf/InvalidProtocolBufferException
    //   202	224	441	java/io/IOException
    //   202	224	437	finally
    //   229	241	469	com/google/protobuf/InvalidProtocolBufferException
    //   229	241	441	java/io/IOException
    //   229	241	437	finally
    //   245	265	469	com/google/protobuf/InvalidProtocolBufferException
    //   245	265	441	java/io/IOException
    //   245	265	437	finally
    //   265	270	469	com/google/protobuf/InvalidProtocolBufferException
    //   265	270	441	java/io/IOException
    //   265	270	437	finally
    //   273	295	469	com/google/protobuf/InvalidProtocolBufferException
    //   273	295	441	java/io/IOException
    //   273	295	437	finally
    //   300	312	469	com/google/protobuf/InvalidProtocolBufferException
    //   300	312	441	java/io/IOException
    //   300	312	437	finally
    //   316	336	469	com/google/protobuf/InvalidProtocolBufferException
    //   316	336	441	java/io/IOException
    //   316	336	437	finally
    //   336	341	469	com/google/protobuf/InvalidProtocolBufferException
    //   336	341	441	java/io/IOException
    //   336	341	437	finally
    //   344	352	469	com/google/protobuf/InvalidProtocolBufferException
    //   344	352	441	java/io/IOException
    //   344	352	437	finally
    //   355	373	469	com/google/protobuf/InvalidProtocolBufferException
    //   355	373	441	java/io/IOException
    //   355	373	437	finally
    //   378	393	469	com/google/protobuf/InvalidProtocolBufferException
    //   378	393	441	java/io/IOException
    //   378	393	437	finally
    //   397	417	469	com/google/protobuf/InvalidProtocolBufferException
    //   397	417	441	java/io/IOException
    //   397	417	437	finally
    //   420	428	469	com/google/protobuf/InvalidProtocolBufferException
    //   420	428	441	java/io/IOException
    //   420	428	437	finally
    //   442	469	437	finally
    //   470	485	437	finally
  }
  
  public boolean getDone() {
    return this.done_;
  }
  
  public Status getError() {
    return (this.resultCase_ == 4) ? (Status)this.result_ : Status.getDefaultInstance();
  }
  
  public Any getMetadata() {
    Any any1 = this.metadata_;
    Any any2 = any1;
    if (any1 == null)
      any2 = Any.getDefaultInstance(); 
    return any2;
  }
  
  public String getName() {
    return this.name_;
  }
  
  public ByteString getNameBytes() {
    return ByteString.copyFromUtf8(this.name_);
  }
  
  public Any getResponse() {
    return (this.resultCase_ == 5) ? (Any)this.result_ : Any.getDefaultInstance();
  }
  
  public ResultCase getResultCase() {
    return ResultCase.forNumber(this.resultCase_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!this.name_.isEmpty())
      j = 0 + CodedOutputStream.computeStringSize(1, getName()); 
    i = j;
    if (this.metadata_ != null)
      i = j + CodedOutputStream.computeMessageSize(2, (MessageLite)getMetadata()); 
    boolean bool = this.done_;
    j = i;
    if (bool)
      j = i + CodedOutputStream.computeBoolSize(3, bool); 
    i = j;
    if (this.resultCase_ == 4)
      i = j + CodedOutputStream.computeMessageSize(4, (MessageLite)this.result_); 
    j = i;
    if (this.resultCase_ == 5)
      j = i + CodedOutputStream.computeMessageSize(5, (MessageLite)this.result_); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public boolean hasMetadata() {
    boolean bool;
    if (this.metadata_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(1, getName()); 
    if (this.metadata_ != null)
      paramCodedOutputStream.writeMessage(2, (MessageLite)getMetadata()); 
    boolean bool = this.done_;
    if (bool)
      paramCodedOutputStream.writeBool(3, bool); 
    if (this.resultCase_ == 4)
      paramCodedOutputStream.writeMessage(4, (MessageLite)this.result_); 
    if (this.resultCase_ == 5)
      paramCodedOutputStream.writeMessage(5, (MessageLite)this.result_); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Operation, Builder> implements OperationOrBuilder {
    private Builder() {
      super(Operation.DEFAULT_INSTANCE);
    }
    
    public Builder clearDone() {
      copyOnWrite();
      ((Operation)this.instance).clearDone();
      return this;
    }
    
    public Builder clearError() {
      copyOnWrite();
      ((Operation)this.instance).clearError();
      return this;
    }
    
    public Builder clearMetadata() {
      copyOnWrite();
      ((Operation)this.instance).clearMetadata();
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      ((Operation)this.instance).clearName();
      return this;
    }
    
    public Builder clearResponse() {
      copyOnWrite();
      ((Operation)this.instance).clearResponse();
      return this;
    }
    
    public Builder clearResult() {
      copyOnWrite();
      ((Operation)this.instance).clearResult();
      return this;
    }
    
    public boolean getDone() {
      return ((Operation)this.instance).getDone();
    }
    
    public Status getError() {
      return ((Operation)this.instance).getError();
    }
    
    public Any getMetadata() {
      return ((Operation)this.instance).getMetadata();
    }
    
    public String getName() {
      return ((Operation)this.instance).getName();
    }
    
    public ByteString getNameBytes() {
      return ((Operation)this.instance).getNameBytes();
    }
    
    public Any getResponse() {
      return ((Operation)this.instance).getResponse();
    }
    
    public Operation.ResultCase getResultCase() {
      return ((Operation)this.instance).getResultCase();
    }
    
    public boolean hasMetadata() {
      return ((Operation)this.instance).hasMetadata();
    }
    
    public Builder mergeError(Status param1Status) {
      copyOnWrite();
      ((Operation)this.instance).mergeError(param1Status);
      return this;
    }
    
    public Builder mergeMetadata(Any param1Any) {
      copyOnWrite();
      ((Operation)this.instance).mergeMetadata(param1Any);
      return this;
    }
    
    public Builder mergeResponse(Any param1Any) {
      copyOnWrite();
      ((Operation)this.instance).mergeResponse(param1Any);
      return this;
    }
    
    public Builder setDone(boolean param1Boolean) {
      copyOnWrite();
      ((Operation)this.instance).setDone(param1Boolean);
      return this;
    }
    
    public Builder setError(Status.Builder param1Builder) {
      copyOnWrite();
      ((Operation)this.instance).setError(param1Builder);
      return this;
    }
    
    public Builder setError(Status param1Status) {
      copyOnWrite();
      ((Operation)this.instance).setError(param1Status);
      return this;
    }
    
    public Builder setMetadata(Any.Builder param1Builder) {
      copyOnWrite();
      ((Operation)this.instance).setMetadata(param1Builder);
      return this;
    }
    
    public Builder setMetadata(Any param1Any) {
      copyOnWrite();
      ((Operation)this.instance).setMetadata(param1Any);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      ((Operation)this.instance).setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Operation)this.instance).setNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setResponse(Any.Builder param1Builder) {
      copyOnWrite();
      ((Operation)this.instance).setResponse(param1Builder);
      return this;
    }
    
    public Builder setResponse(Any param1Any) {
      copyOnWrite();
      ((Operation)this.instance).setResponse(param1Any);
      return this;
    }
  }
  
  public enum ResultCase implements Internal.EnumLite {
    ERROR(4),
    RESPONSE(5),
    RESULT_NOT_SET(0);
    
    private final int value;
    
    static {
    
    }
    
    ResultCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ResultCase forNumber(int param1Int) {
      if (param1Int != 0) {
        switch (param1Int) {
          default:
            return null;
          case 5:
            return RESPONSE;
          case 4:
            break;
        } 
        return ERROR;
      } 
      return RESULT_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\longrunning\Operation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */