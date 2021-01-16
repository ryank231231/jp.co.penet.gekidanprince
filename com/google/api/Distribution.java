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
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class Distribution extends GeneratedMessageLite<Distribution, Distribution.Builder> implements DistributionOrBuilder {
  public static final int BUCKET_COUNTS_FIELD_NUMBER = 7;
  
  public static final int BUCKET_OPTIONS_FIELD_NUMBER = 6;
  
  public static final int COUNT_FIELD_NUMBER = 1;
  
  private static final Distribution DEFAULT_INSTANCE = new Distribution();
  
  public static final int MEAN_FIELD_NUMBER = 2;
  
  private static volatile Parser<Distribution> PARSER;
  
  public static final int RANGE_FIELD_NUMBER = 4;
  
  public static final int SUM_OF_SQUARED_DEVIATION_FIELD_NUMBER = 3;
  
  private int bitField0_;
  
  private Internal.LongList bucketCounts_ = emptyLongList();
  
  private BucketOptions bucketOptions_;
  
  private long count_;
  
  private double mean_;
  
  private Range range_;
  
  private double sumOfSquaredDeviation_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllBucketCounts(Iterable<? extends Long> paramIterable) {
    ensureBucketCountsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.bucketCounts_);
  }
  
  private void addBucketCounts(long paramLong) {
    ensureBucketCountsIsMutable();
    this.bucketCounts_.addLong(paramLong);
  }
  
  private void clearBucketCounts() {
    this.bucketCounts_ = emptyLongList();
  }
  
  private void clearBucketOptions() {
    this.bucketOptions_ = null;
  }
  
  private void clearCount() {
    this.count_ = 0L;
  }
  
  private void clearMean() {
    this.mean_ = 0.0D;
  }
  
  private void clearRange() {
    this.range_ = null;
  }
  
  private void clearSumOfSquaredDeviation() {
    this.sumOfSquaredDeviation_ = 0.0D;
  }
  
  private void ensureBucketCountsIsMutable() {
    if (!this.bucketCounts_.isModifiable())
      this.bucketCounts_ = GeneratedMessageLite.mutableCopy(this.bucketCounts_); 
  }
  
  public static Distribution getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeBucketOptions(BucketOptions paramBucketOptions) {
    BucketOptions bucketOptions = this.bucketOptions_;
    if (bucketOptions != null && bucketOptions != BucketOptions.getDefaultInstance()) {
      this.bucketOptions_ = (BucketOptions)((BucketOptions.Builder)BucketOptions.newBuilder(this.bucketOptions_).mergeFrom(paramBucketOptions)).buildPartial();
    } else {
      this.bucketOptions_ = paramBucketOptions;
    } 
  }
  
  private void mergeRange(Range paramRange) {
    Range range = this.range_;
    if (range != null && range != Range.getDefaultInstance()) {
      this.range_ = (Range)((Range.Builder)Range.newBuilder(this.range_).mergeFrom(paramRange)).buildPartial();
    } else {
      this.range_ = paramRange;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Distribution paramDistribution) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramDistribution);
  }
  
  public static Distribution parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Distribution)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Distribution parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Distribution)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Distribution parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Distribution)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Distribution parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Distribution)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Distribution parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Distribution)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Distribution parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Distribution)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Distribution parseFrom(InputStream paramInputStream) throws IOException {
    return (Distribution)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Distribution parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Distribution)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Distribution parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Distribution)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Distribution parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Distribution)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Distribution> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setBucketCounts(int paramInt, long paramLong) {
    ensureBucketCountsIsMutable();
    this.bucketCounts_.setLong(paramInt, paramLong);
  }
  
  private void setBucketOptions(BucketOptions.Builder paramBuilder) {
    this.bucketOptions_ = (BucketOptions)paramBuilder.build();
  }
  
  private void setBucketOptions(BucketOptions paramBucketOptions) {
    if (paramBucketOptions != null) {
      this.bucketOptions_ = paramBucketOptions;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setCount(long paramLong) {
    this.count_ = paramLong;
  }
  
  private void setMean(double paramDouble) {
    this.mean_ = paramDouble;
  }
  
  private void setRange(Range.Builder paramBuilder) {
    this.range_ = (Range)paramBuilder.build();
  }
  
  private void setRange(Range paramRange) {
    if (paramRange != null) {
      this.range_ = paramRange;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setSumOfSquaredDeviation(double paramDouble) {
    this.sumOfSquaredDeviation_ = paramDouble;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/Distribution$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iload #4
    //   15: tableswitch default -> 60, 1 -> 840, 2 -> 836, 3 -> 825, 4 -> 816, 5 -> 538, 6 -> 114, 7 -> 534, 8 -> 68
    //   60: new java/lang/UnsupportedOperationException
    //   63: dup
    //   64: invokespecial <init> : ()V
    //   67: athrow
    //   68: getstatic com/google/api/Distribution.PARSER : Lcom/google/protobuf/Parser;
    //   71: ifnonnull -> 110
    //   74: ldc com/google/api/Distribution
    //   76: monitorenter
    //   77: getstatic com/google/api/Distribution.PARSER : Lcom/google/protobuf/Parser;
    //   80: ifnonnull -> 98
    //   83: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   86: astore_1
    //   87: aload_1
    //   88: getstatic com/google/api/Distribution.DEFAULT_INSTANCE : Lcom/google/api/Distribution;
    //   91: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   94: aload_1
    //   95: putstatic com/google/api/Distribution.PARSER : Lcom/google/protobuf/Parser;
    //   98: ldc com/google/api/Distribution
    //   100: monitorexit
    //   101: goto -> 110
    //   104: astore_1
    //   105: ldc com/google/api/Distribution
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    //   110: getstatic com/google/api/Distribution.PARSER : Lcom/google/protobuf/Parser;
    //   113: areturn
    //   114: aload_2
    //   115: checkcast com/google/protobuf/CodedInputStream
    //   118: astore_2
    //   119: aload_3
    //   120: checkcast com/google/protobuf/ExtensionRegistryLite
    //   123: astore_3
    //   124: iload #5
    //   126: ifne -> 534
    //   129: aload_2
    //   130: invokevirtual readTag : ()I
    //   133: istore #4
    //   135: iload #4
    //   137: ifeq -> 478
    //   140: iload #4
    //   142: bipush #8
    //   144: if_icmpeq -> 467
    //   147: iload #4
    //   149: bipush #17
    //   151: if_icmpeq -> 456
    //   154: iload #4
    //   156: bipush #25
    //   158: if_icmpeq -> 445
    //   161: iload #4
    //   163: bipush #34
    //   165: if_icmpeq -> 380
    //   168: iload #4
    //   170: bipush #50
    //   172: if_icmpeq -> 315
    //   175: iload #4
    //   177: bipush #56
    //   179: if_icmpeq -> 276
    //   182: iload #4
    //   184: bipush #58
    //   186: if_icmpeq -> 204
    //   189: aload_2
    //   190: iload #4
    //   192: invokevirtual skipField : (I)Z
    //   195: ifne -> 124
    //   198: iconst_1
    //   199: istore #5
    //   201: goto -> 124
    //   204: aload_2
    //   205: aload_2
    //   206: invokevirtual readRawVarint32 : ()I
    //   209: invokevirtual pushLimit : (I)I
    //   212: istore #4
    //   214: aload_0
    //   215: getfield bucketCounts_ : Lcom/google/protobuf/Internal$LongList;
    //   218: invokeinterface isModifiable : ()Z
    //   223: ifne -> 244
    //   226: aload_2
    //   227: invokevirtual getBytesUntilLimit : ()I
    //   230: ifle -> 244
    //   233: aload_0
    //   234: aload_0
    //   235: getfield bucketCounts_ : Lcom/google/protobuf/Internal$LongList;
    //   238: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$LongList;)Lcom/google/protobuf/Internal$LongList;
    //   241: putfield bucketCounts_ : Lcom/google/protobuf/Internal$LongList;
    //   244: aload_2
    //   245: invokevirtual getBytesUntilLimit : ()I
    //   248: ifle -> 267
    //   251: aload_0
    //   252: getfield bucketCounts_ : Lcom/google/protobuf/Internal$LongList;
    //   255: aload_2
    //   256: invokevirtual readInt64 : ()J
    //   259: invokeinterface addLong : (J)V
    //   264: goto -> 244
    //   267: aload_2
    //   268: iload #4
    //   270: invokevirtual popLimit : (I)V
    //   273: goto -> 124
    //   276: aload_0
    //   277: getfield bucketCounts_ : Lcom/google/protobuf/Internal$LongList;
    //   280: invokeinterface isModifiable : ()Z
    //   285: ifne -> 299
    //   288: aload_0
    //   289: aload_0
    //   290: getfield bucketCounts_ : Lcom/google/protobuf/Internal$LongList;
    //   293: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$LongList;)Lcom/google/protobuf/Internal$LongList;
    //   296: putfield bucketCounts_ : Lcom/google/protobuf/Internal$LongList;
    //   299: aload_0
    //   300: getfield bucketCounts_ : Lcom/google/protobuf/Internal$LongList;
    //   303: aload_2
    //   304: invokevirtual readInt64 : ()J
    //   307: invokeinterface addLong : (J)V
    //   312: goto -> 124
    //   315: aload_0
    //   316: getfield bucketOptions_ : Lcom/google/api/Distribution$BucketOptions;
    //   319: ifnull -> 336
    //   322: aload_0
    //   323: getfield bucketOptions_ : Lcom/google/api/Distribution$BucketOptions;
    //   326: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   329: checkcast com/google/api/Distribution$BucketOptions$Builder
    //   332: astore_1
    //   333: goto -> 338
    //   336: aconst_null
    //   337: astore_1
    //   338: aload_0
    //   339: aload_2
    //   340: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   343: aload_3
    //   344: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   347: checkcast com/google/api/Distribution$BucketOptions
    //   350: putfield bucketOptions_ : Lcom/google/api/Distribution$BucketOptions;
    //   353: aload_1
    //   354: ifnull -> 124
    //   357: aload_1
    //   358: aload_0
    //   359: getfield bucketOptions_ : Lcom/google/api/Distribution$BucketOptions;
    //   362: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   365: pop
    //   366: aload_0
    //   367: aload_1
    //   368: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   371: checkcast com/google/api/Distribution$BucketOptions
    //   374: putfield bucketOptions_ : Lcom/google/api/Distribution$BucketOptions;
    //   377: goto -> 124
    //   380: aload_0
    //   381: getfield range_ : Lcom/google/api/Distribution$Range;
    //   384: ifnull -> 401
    //   387: aload_0
    //   388: getfield range_ : Lcom/google/api/Distribution$Range;
    //   391: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   394: checkcast com/google/api/Distribution$Range$Builder
    //   397: astore_1
    //   398: goto -> 403
    //   401: aconst_null
    //   402: astore_1
    //   403: aload_0
    //   404: aload_2
    //   405: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   408: aload_3
    //   409: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   412: checkcast com/google/api/Distribution$Range
    //   415: putfield range_ : Lcom/google/api/Distribution$Range;
    //   418: aload_1
    //   419: ifnull -> 124
    //   422: aload_1
    //   423: aload_0
    //   424: getfield range_ : Lcom/google/api/Distribution$Range;
    //   427: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   430: pop
    //   431: aload_0
    //   432: aload_1
    //   433: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   436: checkcast com/google/api/Distribution$Range
    //   439: putfield range_ : Lcom/google/api/Distribution$Range;
    //   442: goto -> 124
    //   445: aload_0
    //   446: aload_2
    //   447: invokevirtual readDouble : ()D
    //   450: putfield sumOfSquaredDeviation_ : D
    //   453: goto -> 124
    //   456: aload_0
    //   457: aload_2
    //   458: invokevirtual readDouble : ()D
    //   461: putfield mean_ : D
    //   464: goto -> 124
    //   467: aload_0
    //   468: aload_2
    //   469: invokevirtual readInt64 : ()J
    //   472: putfield count_ : J
    //   475: goto -> 124
    //   478: iconst_1
    //   479: istore #5
    //   481: goto -> 124
    //   484: astore_1
    //   485: goto -> 532
    //   488: astore_1
    //   489: new java/lang/RuntimeException
    //   492: astore_3
    //   493: new com/google/protobuf/InvalidProtocolBufferException
    //   496: astore_2
    //   497: aload_2
    //   498: aload_1
    //   499: invokevirtual getMessage : ()Ljava/lang/String;
    //   502: invokespecial <init> : (Ljava/lang/String;)V
    //   505: aload_3
    //   506: aload_2
    //   507: aload_0
    //   508: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   511: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   514: aload_3
    //   515: athrow
    //   516: astore_1
    //   517: new java/lang/RuntimeException
    //   520: astore_2
    //   521: aload_2
    //   522: aload_1
    //   523: aload_0
    //   524: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   527: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   530: aload_2
    //   531: athrow
    //   532: aload_1
    //   533: athrow
    //   534: getstatic com/google/api/Distribution.DEFAULT_INSTANCE : Lcom/google/api/Distribution;
    //   537: areturn
    //   538: aload_2
    //   539: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   542: astore_1
    //   543: aload_3
    //   544: checkcast com/google/api/Distribution
    //   547: astore_2
    //   548: aload_0
    //   549: getfield count_ : J
    //   552: lconst_0
    //   553: lcmp
    //   554: ifeq -> 563
    //   557: iconst_1
    //   558: istore #6
    //   560: goto -> 566
    //   563: iconst_0
    //   564: istore #6
    //   566: aload_0
    //   567: getfield count_ : J
    //   570: lstore #7
    //   572: aload_2
    //   573: getfield count_ : J
    //   576: lconst_0
    //   577: lcmp
    //   578: ifeq -> 587
    //   581: iconst_1
    //   582: istore #9
    //   584: goto -> 590
    //   587: iconst_0
    //   588: istore #9
    //   590: aload_0
    //   591: aload_1
    //   592: iload #6
    //   594: lload #7
    //   596: iload #9
    //   598: aload_2
    //   599: getfield count_ : J
    //   602: invokeinterface visitLong : (ZJZJ)J
    //   607: putfield count_ : J
    //   610: aload_0
    //   611: getfield mean_ : D
    //   614: dconst_0
    //   615: dcmpl
    //   616: ifeq -> 625
    //   619: iconst_1
    //   620: istore #6
    //   622: goto -> 628
    //   625: iconst_0
    //   626: istore #6
    //   628: aload_0
    //   629: getfield mean_ : D
    //   632: dstore #10
    //   634: aload_2
    //   635: getfield mean_ : D
    //   638: dconst_0
    //   639: dcmpl
    //   640: ifeq -> 649
    //   643: iconst_1
    //   644: istore #9
    //   646: goto -> 652
    //   649: iconst_0
    //   650: istore #9
    //   652: aload_0
    //   653: aload_1
    //   654: iload #6
    //   656: dload #10
    //   658: iload #9
    //   660: aload_2
    //   661: getfield mean_ : D
    //   664: invokeinterface visitDouble : (ZDZD)D
    //   669: putfield mean_ : D
    //   672: aload_0
    //   673: getfield sumOfSquaredDeviation_ : D
    //   676: dconst_0
    //   677: dcmpl
    //   678: ifeq -> 687
    //   681: iconst_1
    //   682: istore #6
    //   684: goto -> 690
    //   687: iconst_0
    //   688: istore #6
    //   690: aload_0
    //   691: getfield sumOfSquaredDeviation_ : D
    //   694: dstore #10
    //   696: aload_2
    //   697: getfield sumOfSquaredDeviation_ : D
    //   700: dconst_0
    //   701: dcmpl
    //   702: ifeq -> 711
    //   705: iconst_1
    //   706: istore #9
    //   708: goto -> 714
    //   711: iconst_0
    //   712: istore #9
    //   714: aload_0
    //   715: aload_1
    //   716: iload #6
    //   718: dload #10
    //   720: iload #9
    //   722: aload_2
    //   723: getfield sumOfSquaredDeviation_ : D
    //   726: invokeinterface visitDouble : (ZDZD)D
    //   731: putfield sumOfSquaredDeviation_ : D
    //   734: aload_0
    //   735: aload_1
    //   736: aload_0
    //   737: getfield range_ : Lcom/google/api/Distribution$Range;
    //   740: aload_2
    //   741: getfield range_ : Lcom/google/api/Distribution$Range;
    //   744: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   749: checkcast com/google/api/Distribution$Range
    //   752: putfield range_ : Lcom/google/api/Distribution$Range;
    //   755: aload_0
    //   756: aload_1
    //   757: aload_0
    //   758: getfield bucketOptions_ : Lcom/google/api/Distribution$BucketOptions;
    //   761: aload_2
    //   762: getfield bucketOptions_ : Lcom/google/api/Distribution$BucketOptions;
    //   765: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   770: checkcast com/google/api/Distribution$BucketOptions
    //   773: putfield bucketOptions_ : Lcom/google/api/Distribution$BucketOptions;
    //   776: aload_0
    //   777: aload_1
    //   778: aload_0
    //   779: getfield bucketCounts_ : Lcom/google/protobuf/Internal$LongList;
    //   782: aload_2
    //   783: getfield bucketCounts_ : Lcom/google/protobuf/Internal$LongList;
    //   786: invokeinterface visitLongList : (Lcom/google/protobuf/Internal$LongList;Lcom/google/protobuf/Internal$LongList;)Lcom/google/protobuf/Internal$LongList;
    //   791: putfield bucketCounts_ : Lcom/google/protobuf/Internal$LongList;
    //   794: aload_1
    //   795: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   798: if_acmpne -> 814
    //   801: aload_0
    //   802: aload_0
    //   803: getfield bitField0_ : I
    //   806: aload_2
    //   807: getfield bitField0_ : I
    //   810: ior
    //   811: putfield bitField0_ : I
    //   814: aload_0
    //   815: areturn
    //   816: new com/google/api/Distribution$Builder
    //   819: dup
    //   820: aconst_null
    //   821: invokespecial <init> : (Lcom/google/api/Distribution$1;)V
    //   824: areturn
    //   825: aload_0
    //   826: getfield bucketCounts_ : Lcom/google/protobuf/Internal$LongList;
    //   829: invokeinterface makeImmutable : ()V
    //   834: aconst_null
    //   835: areturn
    //   836: getstatic com/google/api/Distribution.DEFAULT_INSTANCE : Lcom/google/api/Distribution;
    //   839: areturn
    //   840: new com/google/api/Distribution
    //   843: dup
    //   844: invokespecial <init> : ()V
    //   847: areturn
    // Exception table:
    //   from	to	target	type
    //   77	98	104	finally
    //   98	101	104	finally
    //   105	108	104	finally
    //   129	135	516	com/google/protobuf/InvalidProtocolBufferException
    //   129	135	488	java/io/IOException
    //   129	135	484	finally
    //   189	198	516	com/google/protobuf/InvalidProtocolBufferException
    //   189	198	488	java/io/IOException
    //   189	198	484	finally
    //   204	244	516	com/google/protobuf/InvalidProtocolBufferException
    //   204	244	488	java/io/IOException
    //   204	244	484	finally
    //   244	264	516	com/google/protobuf/InvalidProtocolBufferException
    //   244	264	488	java/io/IOException
    //   244	264	484	finally
    //   267	273	516	com/google/protobuf/InvalidProtocolBufferException
    //   267	273	488	java/io/IOException
    //   267	273	484	finally
    //   276	299	516	com/google/protobuf/InvalidProtocolBufferException
    //   276	299	488	java/io/IOException
    //   276	299	484	finally
    //   299	312	516	com/google/protobuf/InvalidProtocolBufferException
    //   299	312	488	java/io/IOException
    //   299	312	484	finally
    //   315	333	516	com/google/protobuf/InvalidProtocolBufferException
    //   315	333	488	java/io/IOException
    //   315	333	484	finally
    //   338	353	516	com/google/protobuf/InvalidProtocolBufferException
    //   338	353	488	java/io/IOException
    //   338	353	484	finally
    //   357	377	516	com/google/protobuf/InvalidProtocolBufferException
    //   357	377	488	java/io/IOException
    //   357	377	484	finally
    //   380	398	516	com/google/protobuf/InvalidProtocolBufferException
    //   380	398	488	java/io/IOException
    //   380	398	484	finally
    //   403	418	516	com/google/protobuf/InvalidProtocolBufferException
    //   403	418	488	java/io/IOException
    //   403	418	484	finally
    //   422	442	516	com/google/protobuf/InvalidProtocolBufferException
    //   422	442	488	java/io/IOException
    //   422	442	484	finally
    //   445	453	516	com/google/protobuf/InvalidProtocolBufferException
    //   445	453	488	java/io/IOException
    //   445	453	484	finally
    //   456	464	516	com/google/protobuf/InvalidProtocolBufferException
    //   456	464	488	java/io/IOException
    //   456	464	484	finally
    //   467	475	516	com/google/protobuf/InvalidProtocolBufferException
    //   467	475	488	java/io/IOException
    //   467	475	484	finally
    //   489	516	484	finally
    //   517	532	484	finally
  }
  
  public long getBucketCounts(int paramInt) {
    return this.bucketCounts_.getLong(paramInt);
  }
  
  public int getBucketCountsCount() {
    return this.bucketCounts_.size();
  }
  
  public List<Long> getBucketCountsList() {
    return (List<Long>)this.bucketCounts_;
  }
  
  public BucketOptions getBucketOptions() {
    BucketOptions bucketOptions1 = this.bucketOptions_;
    BucketOptions bucketOptions2 = bucketOptions1;
    if (bucketOptions1 == null)
      bucketOptions2 = BucketOptions.getDefaultInstance(); 
    return bucketOptions2;
  }
  
  public long getCount() {
    return this.count_;
  }
  
  public double getMean() {
    return this.mean_;
  }
  
  public Range getRange() {
    Range range1 = this.range_;
    Range range2 = range1;
    if (range1 == null)
      range2 = Range.getDefaultInstance(); 
    return range2;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    long l = this.count_;
    int j = 0;
    if (l != 0L) {
      k = CodedOutputStream.computeInt64Size(1, l) + 0;
    } else {
      k = 0;
    } 
    double d = this.mean_;
    i = k;
    if (d != 0.0D)
      i = k + CodedOutputStream.computeDoubleSize(2, d); 
    d = this.sumOfSquaredDeviation_;
    int k = i;
    if (d != 0.0D)
      k = i + CodedOutputStream.computeDoubleSize(3, d); 
    i = k;
    if (this.range_ != null)
      i = k + CodedOutputStream.computeMessageSize(4, (MessageLite)getRange()); 
    k = i;
    if (this.bucketOptions_ != null)
      k = i + CodedOutputStream.computeMessageSize(6, (MessageLite)getBucketOptions()); 
    byte b = 0;
    i = j;
    j = b;
    while (i < this.bucketCounts_.size()) {
      j += CodedOutputStream.computeInt64SizeNoTag(this.bucketCounts_.getLong(i));
      i++;
    } 
    i = k + j + getBucketCountsList().size() * 1;
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public double getSumOfSquaredDeviation() {
    return this.sumOfSquaredDeviation_;
  }
  
  public boolean hasBucketOptions() {
    boolean bool;
    if (this.bucketOptions_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasRange() {
    boolean bool;
    if (this.range_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    getSerializedSize();
    long l = this.count_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(1, l); 
    double d = this.mean_;
    if (d != 0.0D)
      paramCodedOutputStream.writeDouble(2, d); 
    d = this.sumOfSquaredDeviation_;
    if (d != 0.0D)
      paramCodedOutputStream.writeDouble(3, d); 
    if (this.range_ != null)
      paramCodedOutputStream.writeMessage(4, (MessageLite)getRange()); 
    if (this.bucketOptions_ != null)
      paramCodedOutputStream.writeMessage(6, (MessageLite)getBucketOptions()); 
    for (byte b = 0; b < this.bucketCounts_.size(); b++)
      paramCodedOutputStream.writeInt64(7, this.bucketCounts_.getLong(b)); 
  }
  
  public static final class BucketOptions extends GeneratedMessageLite<BucketOptions, BucketOptions.Builder> implements BucketOptionsOrBuilder {
    private static final BucketOptions DEFAULT_INSTANCE = new BucketOptions();
    
    public static final int EXPLICIT_BUCKETS_FIELD_NUMBER = 3;
    
    public static final int EXPONENTIAL_BUCKETS_FIELD_NUMBER = 2;
    
    public static final int LINEAR_BUCKETS_FIELD_NUMBER = 1;
    
    private static volatile Parser<BucketOptions> PARSER;
    
    private int optionsCase_ = 0;
    
    private Object options_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearExplicitBuckets() {
      if (this.optionsCase_ == 3) {
        this.optionsCase_ = 0;
        this.options_ = null;
      } 
    }
    
    private void clearExponentialBuckets() {
      if (this.optionsCase_ == 2) {
        this.optionsCase_ = 0;
        this.options_ = null;
      } 
    }
    
    private void clearLinearBuckets() {
      if (this.optionsCase_ == 1) {
        this.optionsCase_ = 0;
        this.options_ = null;
      } 
    }
    
    private void clearOptions() {
      this.optionsCase_ = 0;
      this.options_ = null;
    }
    
    public static BucketOptions getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeExplicitBuckets(Explicit param1Explicit) {
      if (this.optionsCase_ == 3 && this.options_ != Explicit.getDefaultInstance()) {
        this.options_ = ((Explicit.Builder)Explicit.newBuilder((Explicit)this.options_).mergeFrom(param1Explicit)).buildPartial();
      } else {
        this.options_ = param1Explicit;
      } 
      this.optionsCase_ = 3;
    }
    
    private void mergeExponentialBuckets(Exponential param1Exponential) {
      if (this.optionsCase_ == 2 && this.options_ != Exponential.getDefaultInstance()) {
        this.options_ = ((Exponential.Builder)Exponential.newBuilder((Exponential)this.options_).mergeFrom(param1Exponential)).buildPartial();
      } else {
        this.options_ = param1Exponential;
      } 
      this.optionsCase_ = 2;
    }
    
    private void mergeLinearBuckets(Linear param1Linear) {
      if (this.optionsCase_ == 1 && this.options_ != Linear.getDefaultInstance()) {
        this.options_ = ((Linear.Builder)Linear.newBuilder((Linear)this.options_).mergeFrom(param1Linear)).buildPartial();
      } else {
        this.options_ = param1Linear;
      } 
      this.optionsCase_ = 1;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(BucketOptions param1BucketOptions) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1BucketOptions);
    }
    
    public static BucketOptions parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (BucketOptions)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static BucketOptions parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (BucketOptions)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static BucketOptions parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (BucketOptions)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static BucketOptions parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (BucketOptions)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static BucketOptions parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (BucketOptions)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static BucketOptions parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (BucketOptions)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static BucketOptions parseFrom(InputStream param1InputStream) throws IOException {
      return (BucketOptions)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static BucketOptions parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (BucketOptions)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static BucketOptions parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (BucketOptions)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static BucketOptions parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (BucketOptions)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<BucketOptions> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setExplicitBuckets(Explicit.Builder param1Builder) {
      this.options_ = param1Builder.build();
      this.optionsCase_ = 3;
    }
    
    private void setExplicitBuckets(Explicit param1Explicit) {
      if (param1Explicit != null) {
        this.options_ = param1Explicit;
        this.optionsCase_ = 3;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setExponentialBuckets(Exponential.Builder param1Builder) {
      this.options_ = param1Builder.build();
      this.optionsCase_ = 2;
    }
    
    private void setExponentialBuckets(Exponential param1Exponential) {
      if (param1Exponential != null) {
        this.options_ = param1Exponential;
        this.optionsCase_ = 2;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setLinearBuckets(Linear.Builder param1Builder) {
      this.options_ = param1Builder.build();
      this.optionsCase_ = 1;
    }
    
    private void setLinearBuckets(Linear param1Linear) {
      if (param1Linear != null) {
        this.options_ = param1Linear;
        this.optionsCase_ = 1;
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/api/Distribution$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
      //   22: iconst_0
      //   23: istore #9
      //   25: iload #4
      //   27: tableswitch default -> 72, 1 -> 688, 2 -> 684, 3 -> 682, 4 -> 673, 5 -> 461, 6 -> 126, 7 -> 457, 8 -> 80
      //   72: new java/lang/UnsupportedOperationException
      //   75: dup
      //   76: invokespecial <init> : ()V
      //   79: athrow
      //   80: getstatic com/google/api/Distribution$BucketOptions.PARSER : Lcom/google/protobuf/Parser;
      //   83: ifnonnull -> 122
      //   86: ldc com/google/api/Distribution$BucketOptions
      //   88: monitorenter
      //   89: getstatic com/google/api/Distribution$BucketOptions.PARSER : Lcom/google/protobuf/Parser;
      //   92: ifnonnull -> 110
      //   95: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   98: astore_1
      //   99: aload_1
      //   100: getstatic com/google/api/Distribution$BucketOptions.DEFAULT_INSTANCE : Lcom/google/api/Distribution$BucketOptions;
      //   103: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   106: aload_1
      //   107: putstatic com/google/api/Distribution$BucketOptions.PARSER : Lcom/google/protobuf/Parser;
      //   110: ldc com/google/api/Distribution$BucketOptions
      //   112: monitorexit
      //   113: goto -> 122
      //   116: astore_1
      //   117: ldc com/google/api/Distribution$BucketOptions
      //   119: monitorexit
      //   120: aload_1
      //   121: athrow
      //   122: getstatic com/google/api/Distribution$BucketOptions.PARSER : Lcom/google/protobuf/Parser;
      //   125: areturn
      //   126: aload_2
      //   127: checkcast com/google/protobuf/CodedInputStream
      //   130: astore_2
      //   131: aload_3
      //   132: checkcast com/google/protobuf/ExtensionRegistryLite
      //   135: astore_3
      //   136: iload #9
      //   138: ifne -> 457
      //   141: aload_2
      //   142: invokevirtual readTag : ()I
      //   145: istore #4
      //   147: iload #4
      //   149: ifeq -> 401
      //   152: iload #4
      //   154: bipush #10
      //   156: if_icmpeq -> 330
      //   159: iload #4
      //   161: bipush #18
      //   163: if_icmpeq -> 259
      //   166: iload #4
      //   168: bipush #26
      //   170: if_icmpeq -> 188
      //   173: aload_2
      //   174: iload #4
      //   176: invokevirtual skipField : (I)Z
      //   179: ifne -> 136
      //   182: iconst_1
      //   183: istore #9
      //   185: goto -> 136
      //   188: aload_0
      //   189: getfield optionsCase_ : I
      //   192: iconst_3
      //   193: if_icmpne -> 213
      //   196: aload_0
      //   197: getfield options_ : Ljava/lang/Object;
      //   200: checkcast com/google/api/Distribution$BucketOptions$Explicit
      //   203: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   206: checkcast com/google/api/Distribution$BucketOptions$Explicit$Builder
      //   209: astore_1
      //   210: goto -> 215
      //   213: aconst_null
      //   214: astore_1
      //   215: aload_0
      //   216: aload_2
      //   217: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   220: aload_3
      //   221: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   224: putfield options_ : Ljava/lang/Object;
      //   227: aload_1
      //   228: ifnull -> 251
      //   231: aload_1
      //   232: aload_0
      //   233: getfield options_ : Ljava/lang/Object;
      //   236: checkcast com/google/api/Distribution$BucketOptions$Explicit
      //   239: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   242: pop
      //   243: aload_0
      //   244: aload_1
      //   245: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   248: putfield options_ : Ljava/lang/Object;
      //   251: aload_0
      //   252: iconst_3
      //   253: putfield optionsCase_ : I
      //   256: goto -> 136
      //   259: aload_0
      //   260: getfield optionsCase_ : I
      //   263: iconst_2
      //   264: if_icmpne -> 284
      //   267: aload_0
      //   268: getfield options_ : Ljava/lang/Object;
      //   271: checkcast com/google/api/Distribution$BucketOptions$Exponential
      //   274: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   277: checkcast com/google/api/Distribution$BucketOptions$Exponential$Builder
      //   280: astore_1
      //   281: goto -> 286
      //   284: aconst_null
      //   285: astore_1
      //   286: aload_0
      //   287: aload_2
      //   288: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   291: aload_3
      //   292: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   295: putfield options_ : Ljava/lang/Object;
      //   298: aload_1
      //   299: ifnull -> 322
      //   302: aload_1
      //   303: aload_0
      //   304: getfield options_ : Ljava/lang/Object;
      //   307: checkcast com/google/api/Distribution$BucketOptions$Exponential
      //   310: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   313: pop
      //   314: aload_0
      //   315: aload_1
      //   316: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   319: putfield options_ : Ljava/lang/Object;
      //   322: aload_0
      //   323: iconst_2
      //   324: putfield optionsCase_ : I
      //   327: goto -> 136
      //   330: aload_0
      //   331: getfield optionsCase_ : I
      //   334: iconst_1
      //   335: if_icmpne -> 355
      //   338: aload_0
      //   339: getfield options_ : Ljava/lang/Object;
      //   342: checkcast com/google/api/Distribution$BucketOptions$Linear
      //   345: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   348: checkcast com/google/api/Distribution$BucketOptions$Linear$Builder
      //   351: astore_1
      //   352: goto -> 357
      //   355: aconst_null
      //   356: astore_1
      //   357: aload_0
      //   358: aload_2
      //   359: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   362: aload_3
      //   363: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   366: putfield options_ : Ljava/lang/Object;
      //   369: aload_1
      //   370: ifnull -> 393
      //   373: aload_1
      //   374: aload_0
      //   375: getfield options_ : Ljava/lang/Object;
      //   378: checkcast com/google/api/Distribution$BucketOptions$Linear
      //   381: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   384: pop
      //   385: aload_0
      //   386: aload_1
      //   387: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   390: putfield options_ : Ljava/lang/Object;
      //   393: aload_0
      //   394: iconst_1
      //   395: putfield optionsCase_ : I
      //   398: goto -> 136
      //   401: iconst_1
      //   402: istore #9
      //   404: goto -> 136
      //   407: astore_1
      //   408: goto -> 455
      //   411: astore_3
      //   412: new java/lang/RuntimeException
      //   415: astore_2
      //   416: new com/google/protobuf/InvalidProtocolBufferException
      //   419: astore_1
      //   420: aload_1
      //   421: aload_3
      //   422: invokevirtual getMessage : ()Ljava/lang/String;
      //   425: invokespecial <init> : (Ljava/lang/String;)V
      //   428: aload_2
      //   429: aload_1
      //   430: aload_0
      //   431: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   434: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   437: aload_2
      //   438: athrow
      //   439: astore_1
      //   440: new java/lang/RuntimeException
      //   443: astore_2
      //   444: aload_2
      //   445: aload_1
      //   446: aload_0
      //   447: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   450: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   453: aload_2
      //   454: athrow
      //   455: aload_1
      //   456: athrow
      //   457: getstatic com/google/api/Distribution$BucketOptions.DEFAULT_INSTANCE : Lcom/google/api/Distribution$BucketOptions;
      //   460: areturn
      //   461: aload_2
      //   462: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   465: astore_1
      //   466: aload_3
      //   467: checkcast com/google/api/Distribution$BucketOptions
      //   470: astore_2
      //   471: getstatic com/google/api/Distribution$1.$SwitchMap$com$google$api$Distribution$BucketOptions$OptionsCase : [I
      //   474: aload_2
      //   475: invokevirtual getOptionsCase : ()Lcom/google/api/Distribution$BucketOptions$OptionsCase;
      //   478: invokevirtual ordinal : ()I
      //   481: iaload
      //   482: tableswitch default -> 512, 1 -> 612, 2 -> 574, 3 -> 536, 4 -> 515
      //   512: goto -> 647
      //   515: aload_0
      //   516: getfield optionsCase_ : I
      //   519: ifeq -> 525
      //   522: iconst_1
      //   523: istore #5
      //   525: aload_1
      //   526: iload #5
      //   528: invokeinterface visitOneofNotSet : (Z)V
      //   533: goto -> 647
      //   536: iload #6
      //   538: istore #5
      //   540: aload_0
      //   541: getfield optionsCase_ : I
      //   544: iconst_3
      //   545: if_icmpne -> 551
      //   548: iconst_1
      //   549: istore #5
      //   551: aload_0
      //   552: aload_1
      //   553: iload #5
      //   555: aload_0
      //   556: getfield options_ : Ljava/lang/Object;
      //   559: aload_2
      //   560: getfield options_ : Ljava/lang/Object;
      //   563: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   568: putfield options_ : Ljava/lang/Object;
      //   571: goto -> 647
      //   574: iload #7
      //   576: istore #5
      //   578: aload_0
      //   579: getfield optionsCase_ : I
      //   582: iconst_2
      //   583: if_icmpne -> 589
      //   586: iconst_1
      //   587: istore #5
      //   589: aload_0
      //   590: aload_1
      //   591: iload #5
      //   593: aload_0
      //   594: getfield options_ : Ljava/lang/Object;
      //   597: aload_2
      //   598: getfield options_ : Ljava/lang/Object;
      //   601: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   606: putfield options_ : Ljava/lang/Object;
      //   609: goto -> 647
      //   612: iload #8
      //   614: istore #5
      //   616: aload_0
      //   617: getfield optionsCase_ : I
      //   620: iconst_1
      //   621: if_icmpne -> 627
      //   624: iconst_1
      //   625: istore #5
      //   627: aload_0
      //   628: aload_1
      //   629: iload #5
      //   631: aload_0
      //   632: getfield options_ : Ljava/lang/Object;
      //   635: aload_2
      //   636: getfield options_ : Ljava/lang/Object;
      //   639: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   644: putfield options_ : Ljava/lang/Object;
      //   647: aload_1
      //   648: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   651: if_acmpne -> 671
      //   654: aload_2
      //   655: getfield optionsCase_ : I
      //   658: istore #9
      //   660: iload #9
      //   662: ifeq -> 671
      //   665: aload_0
      //   666: iload #9
      //   668: putfield optionsCase_ : I
      //   671: aload_0
      //   672: areturn
      //   673: new com/google/api/Distribution$BucketOptions$Builder
      //   676: dup
      //   677: aconst_null
      //   678: invokespecial <init> : (Lcom/google/api/Distribution$1;)V
      //   681: areturn
      //   682: aconst_null
      //   683: areturn
      //   684: getstatic com/google/api/Distribution$BucketOptions.DEFAULT_INSTANCE : Lcom/google/api/Distribution$BucketOptions;
      //   687: areturn
      //   688: new com/google/api/Distribution$BucketOptions
      //   691: dup
      //   692: invokespecial <init> : ()V
      //   695: areturn
      // Exception table:
      //   from	to	target	type
      //   89	110	116	finally
      //   110	113	116	finally
      //   117	120	116	finally
      //   141	147	439	com/google/protobuf/InvalidProtocolBufferException
      //   141	147	411	java/io/IOException
      //   141	147	407	finally
      //   173	182	439	com/google/protobuf/InvalidProtocolBufferException
      //   173	182	411	java/io/IOException
      //   173	182	407	finally
      //   188	210	439	com/google/protobuf/InvalidProtocolBufferException
      //   188	210	411	java/io/IOException
      //   188	210	407	finally
      //   215	227	439	com/google/protobuf/InvalidProtocolBufferException
      //   215	227	411	java/io/IOException
      //   215	227	407	finally
      //   231	251	439	com/google/protobuf/InvalidProtocolBufferException
      //   231	251	411	java/io/IOException
      //   231	251	407	finally
      //   251	256	439	com/google/protobuf/InvalidProtocolBufferException
      //   251	256	411	java/io/IOException
      //   251	256	407	finally
      //   259	281	439	com/google/protobuf/InvalidProtocolBufferException
      //   259	281	411	java/io/IOException
      //   259	281	407	finally
      //   286	298	439	com/google/protobuf/InvalidProtocolBufferException
      //   286	298	411	java/io/IOException
      //   286	298	407	finally
      //   302	322	439	com/google/protobuf/InvalidProtocolBufferException
      //   302	322	411	java/io/IOException
      //   302	322	407	finally
      //   322	327	439	com/google/protobuf/InvalidProtocolBufferException
      //   322	327	411	java/io/IOException
      //   322	327	407	finally
      //   330	352	439	com/google/protobuf/InvalidProtocolBufferException
      //   330	352	411	java/io/IOException
      //   330	352	407	finally
      //   357	369	439	com/google/protobuf/InvalidProtocolBufferException
      //   357	369	411	java/io/IOException
      //   357	369	407	finally
      //   373	393	439	com/google/protobuf/InvalidProtocolBufferException
      //   373	393	411	java/io/IOException
      //   373	393	407	finally
      //   393	398	439	com/google/protobuf/InvalidProtocolBufferException
      //   393	398	411	java/io/IOException
      //   393	398	407	finally
      //   412	439	407	finally
      //   440	455	407	finally
    }
    
    public Explicit getExplicitBuckets() {
      return (this.optionsCase_ == 3) ? (Explicit)this.options_ : Explicit.getDefaultInstance();
    }
    
    public Exponential getExponentialBuckets() {
      return (this.optionsCase_ == 2) ? (Exponential)this.options_ : Exponential.getDefaultInstance();
    }
    
    public Linear getLinearBuckets() {
      return (this.optionsCase_ == 1) ? (Linear)this.options_ : Linear.getDefaultInstance();
    }
    
    public OptionsCase getOptionsCase() {
      return OptionsCase.forNumber(this.optionsCase_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.optionsCase_ == 1)
        j = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)this.options_); 
      i = j;
      if (this.optionsCase_ == 2)
        i = j + CodedOutputStream.computeMessageSize(2, (MessageLite)this.options_); 
      j = i;
      if (this.optionsCase_ == 3)
        j = i + CodedOutputStream.computeMessageSize(3, (MessageLite)this.options_); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.optionsCase_ == 1)
        param1CodedOutputStream.writeMessage(1, (MessageLite)this.options_); 
      if (this.optionsCase_ == 2)
        param1CodedOutputStream.writeMessage(2, (MessageLite)this.options_); 
      if (this.optionsCase_ == 3)
        param1CodedOutputStream.writeMessage(3, (MessageLite)this.options_); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<BucketOptions, Builder> implements Distribution.BucketOptionsOrBuilder {
      private Builder() {
        super(Distribution.BucketOptions.DEFAULT_INSTANCE);
      }
      
      public Builder clearExplicitBuckets() {
        copyOnWrite();
        ((Distribution.BucketOptions)this.instance).clearExplicitBuckets();
        return this;
      }
      
      public Builder clearExponentialBuckets() {
        copyOnWrite();
        ((Distribution.BucketOptions)this.instance).clearExponentialBuckets();
        return this;
      }
      
      public Builder clearLinearBuckets() {
        copyOnWrite();
        ((Distribution.BucketOptions)this.instance).clearLinearBuckets();
        return this;
      }
      
      public Builder clearOptions() {
        copyOnWrite();
        ((Distribution.BucketOptions)this.instance).clearOptions();
        return this;
      }
      
      public Distribution.BucketOptions.Explicit getExplicitBuckets() {
        return ((Distribution.BucketOptions)this.instance).getExplicitBuckets();
      }
      
      public Distribution.BucketOptions.Exponential getExponentialBuckets() {
        return ((Distribution.BucketOptions)this.instance).getExponentialBuckets();
      }
      
      public Distribution.BucketOptions.Linear getLinearBuckets() {
        return ((Distribution.BucketOptions)this.instance).getLinearBuckets();
      }
      
      public Distribution.BucketOptions.OptionsCase getOptionsCase() {
        return ((Distribution.BucketOptions)this.instance).getOptionsCase();
      }
      
      public Builder mergeExplicitBuckets(Distribution.BucketOptions.Explicit param2Explicit) {
        copyOnWrite();
        ((Distribution.BucketOptions)this.instance).mergeExplicitBuckets(param2Explicit);
        return this;
      }
      
      public Builder mergeExponentialBuckets(Distribution.BucketOptions.Exponential param2Exponential) {
        copyOnWrite();
        ((Distribution.BucketOptions)this.instance).mergeExponentialBuckets(param2Exponential);
        return this;
      }
      
      public Builder mergeLinearBuckets(Distribution.BucketOptions.Linear param2Linear) {
        copyOnWrite();
        ((Distribution.BucketOptions)this.instance).mergeLinearBuckets(param2Linear);
        return this;
      }
      
      public Builder setExplicitBuckets(Distribution.BucketOptions.Explicit.Builder param2Builder) {
        copyOnWrite();
        ((Distribution.BucketOptions)this.instance).setExplicitBuckets(param2Builder);
        return this;
      }
      
      public Builder setExplicitBuckets(Distribution.BucketOptions.Explicit param2Explicit) {
        copyOnWrite();
        ((Distribution.BucketOptions)this.instance).setExplicitBuckets(param2Explicit);
        return this;
      }
      
      public Builder setExponentialBuckets(Distribution.BucketOptions.Exponential.Builder param2Builder) {
        copyOnWrite();
        ((Distribution.BucketOptions)this.instance).setExponentialBuckets(param2Builder);
        return this;
      }
      
      public Builder setExponentialBuckets(Distribution.BucketOptions.Exponential param2Exponential) {
        copyOnWrite();
        ((Distribution.BucketOptions)this.instance).setExponentialBuckets(param2Exponential);
        return this;
      }
      
      public Builder setLinearBuckets(Distribution.BucketOptions.Linear.Builder param2Builder) {
        copyOnWrite();
        ((Distribution.BucketOptions)this.instance).setLinearBuckets(param2Builder);
        return this;
      }
      
      public Builder setLinearBuckets(Distribution.BucketOptions.Linear param2Linear) {
        copyOnWrite();
        ((Distribution.BucketOptions)this.instance).setLinearBuckets(param2Linear);
        return this;
      }
    }
    
    public static final class Explicit extends GeneratedMessageLite<Explicit, Explicit.Builder> implements ExplicitOrBuilder {
      public static final int BOUNDS_FIELD_NUMBER = 1;
      
      private static final Explicit DEFAULT_INSTANCE = new Explicit();
      
      private static volatile Parser<Explicit> PARSER;
      
      private Internal.DoubleList bounds_ = emptyDoubleList();
      
      static {
        DEFAULT_INSTANCE.makeImmutable();
      }
      
      private void addAllBounds(Iterable<? extends Double> param2Iterable) {
        ensureBoundsIsMutable();
        AbstractMessageLite.addAll(param2Iterable, (Collection)this.bounds_);
      }
      
      private void addBounds(double param2Double) {
        ensureBoundsIsMutable();
        this.bounds_.addDouble(param2Double);
      }
      
      private void clearBounds() {
        this.bounds_ = emptyDoubleList();
      }
      
      private void ensureBoundsIsMutable() {
        if (!this.bounds_.isModifiable())
          this.bounds_ = GeneratedMessageLite.mutableCopy(this.bounds_); 
      }
      
      public static Explicit getDefaultInstance() {
        return DEFAULT_INSTANCE;
      }
      
      public static Builder newBuilder() {
        return (Builder)DEFAULT_INSTANCE.toBuilder();
      }
      
      public static Builder newBuilder(Explicit param2Explicit) {
        return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param2Explicit);
      }
      
      public static Explicit parseDelimitedFrom(InputStream param2InputStream) throws IOException {
        return (Explicit)parseDelimitedFrom(DEFAULT_INSTANCE, param2InputStream);
      }
      
      public static Explicit parseDelimitedFrom(InputStream param2InputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (Explicit)parseDelimitedFrom(DEFAULT_INSTANCE, param2InputStream, param2ExtensionRegistryLite);
      }
      
      public static Explicit parseFrom(ByteString param2ByteString) throws InvalidProtocolBufferException {
        return (Explicit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ByteString);
      }
      
      public static Explicit parseFrom(ByteString param2ByteString, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (Explicit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ByteString, param2ExtensionRegistryLite);
      }
      
      public static Explicit parseFrom(CodedInputStream param2CodedInputStream) throws IOException {
        return (Explicit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2CodedInputStream);
      }
      
      public static Explicit parseFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (Explicit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2CodedInputStream, param2ExtensionRegistryLite);
      }
      
      public static Explicit parseFrom(InputStream param2InputStream) throws IOException {
        return (Explicit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2InputStream);
      }
      
      public static Explicit parseFrom(InputStream param2InputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (Explicit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2InputStream, param2ExtensionRegistryLite);
      }
      
      public static Explicit parseFrom(byte[] param2ArrayOfbyte) throws InvalidProtocolBufferException {
        return (Explicit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ArrayOfbyte);
      }
      
      public static Explicit parseFrom(byte[] param2ArrayOfbyte, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (Explicit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ArrayOfbyte, param2ExtensionRegistryLite);
      }
      
      public static Parser<Explicit> parser() {
        return DEFAULT_INSTANCE.getParserForType();
      }
      
      private void setBounds(int param2Int, double param2Double) {
        ensureBoundsIsMutable();
        this.bounds_.setDouble(param2Int, param2Double);
      }
      
      protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param2MethodToInvoke, Object param2Object1, Object param2Object2) {
        // Byte code:
        //   0: getstatic com/google/api/Distribution$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
        //   3: aload_1
        //   4: invokevirtual ordinal : ()I
        //   7: iaload
        //   8: tableswitch default -> 56, 1 -> 433, 2 -> 429, 3 -> 418, 4 -> 409, 5 -> 375, 6 -> 110, 7 -> 371, 8 -> 64
        //   56: new java/lang/UnsupportedOperationException
        //   59: dup
        //   60: invokespecial <init> : ()V
        //   63: athrow
        //   64: getstatic com/google/api/Distribution$BucketOptions$Explicit.PARSER : Lcom/google/protobuf/Parser;
        //   67: ifnonnull -> 106
        //   70: ldc com/google/api/Distribution$BucketOptions$Explicit
        //   72: monitorenter
        //   73: getstatic com/google/api/Distribution$BucketOptions$Explicit.PARSER : Lcom/google/protobuf/Parser;
        //   76: ifnonnull -> 94
        //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
        //   82: astore_1
        //   83: aload_1
        //   84: getstatic com/google/api/Distribution$BucketOptions$Explicit.DEFAULT_INSTANCE : Lcom/google/api/Distribution$BucketOptions$Explicit;
        //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
        //   90: aload_1
        //   91: putstatic com/google/api/Distribution$BucketOptions$Explicit.PARSER : Lcom/google/protobuf/Parser;
        //   94: ldc com/google/api/Distribution$BucketOptions$Explicit
        //   96: monitorexit
        //   97: goto -> 106
        //   100: astore_1
        //   101: ldc com/google/api/Distribution$BucketOptions$Explicit
        //   103: monitorexit
        //   104: aload_1
        //   105: athrow
        //   106: getstatic com/google/api/Distribution$BucketOptions$Explicit.PARSER : Lcom/google/protobuf/Parser;
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
        //   125: ifne -> 371
        //   128: aload_1
        //   129: invokevirtual readTag : ()I
        //   132: istore #5
        //   134: iload #5
        //   136: ifeq -> 315
        //   139: iload #5
        //   141: tableswitch default -> 164, 9 -> 276, 10 -> 179
        //   164: aload_1
        //   165: iload #5
        //   167: invokevirtual skipField : (I)Z
        //   170: ifne -> 123
        //   173: iconst_1
        //   174: istore #4
        //   176: goto -> 123
        //   179: aload_1
        //   180: invokevirtual readRawVarint32 : ()I
        //   183: istore #6
        //   185: aload_1
        //   186: iload #6
        //   188: invokevirtual pushLimit : (I)I
        //   191: istore #5
        //   193: aload_0
        //   194: getfield bounds_ : Lcom/google/protobuf/Internal$DoubleList;
        //   197: invokeinterface isModifiable : ()Z
        //   202: ifne -> 244
        //   205: aload_1
        //   206: invokevirtual getBytesUntilLimit : ()I
        //   209: ifle -> 244
        //   212: aload_0
        //   213: getfield bounds_ : Lcom/google/protobuf/Internal$DoubleList;
        //   216: invokeinterface size : ()I
        //   221: istore #7
        //   223: aload_0
        //   224: aload_0
        //   225: getfield bounds_ : Lcom/google/protobuf/Internal$DoubleList;
        //   228: iload #7
        //   230: iload #6
        //   232: bipush #8
        //   234: idiv
        //   235: iadd
        //   236: invokeinterface mutableCopyWithCapacity : (I)Lcom/google/protobuf/Internal$DoubleList;
        //   241: putfield bounds_ : Lcom/google/protobuf/Internal$DoubleList;
        //   244: aload_1
        //   245: invokevirtual getBytesUntilLimit : ()I
        //   248: ifle -> 267
        //   251: aload_0
        //   252: getfield bounds_ : Lcom/google/protobuf/Internal$DoubleList;
        //   255: aload_1
        //   256: invokevirtual readDouble : ()D
        //   259: invokeinterface addDouble : (D)V
        //   264: goto -> 244
        //   267: aload_1
        //   268: iload #5
        //   270: invokevirtual popLimit : (I)V
        //   273: goto -> 123
        //   276: aload_0
        //   277: getfield bounds_ : Lcom/google/protobuf/Internal$DoubleList;
        //   280: invokeinterface isModifiable : ()Z
        //   285: ifne -> 299
        //   288: aload_0
        //   289: aload_0
        //   290: getfield bounds_ : Lcom/google/protobuf/Internal$DoubleList;
        //   293: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$DoubleList;)Lcom/google/protobuf/Internal$DoubleList;
        //   296: putfield bounds_ : Lcom/google/protobuf/Internal$DoubleList;
        //   299: aload_0
        //   300: getfield bounds_ : Lcom/google/protobuf/Internal$DoubleList;
        //   303: aload_1
        //   304: invokevirtual readDouble : ()D
        //   307: invokeinterface addDouble : (D)V
        //   312: goto -> 123
        //   315: iconst_1
        //   316: istore #4
        //   318: goto -> 123
        //   321: astore_1
        //   322: goto -> 369
        //   325: astore_2
        //   326: new java/lang/RuntimeException
        //   329: astore_3
        //   330: new com/google/protobuf/InvalidProtocolBufferException
        //   333: astore_1
        //   334: aload_1
        //   335: aload_2
        //   336: invokevirtual getMessage : ()Ljava/lang/String;
        //   339: invokespecial <init> : (Ljava/lang/String;)V
        //   342: aload_3
        //   343: aload_1
        //   344: aload_0
        //   345: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
        //   348: invokespecial <init> : (Ljava/lang/Throwable;)V
        //   351: aload_3
        //   352: athrow
        //   353: astore_2
        //   354: new java/lang/RuntimeException
        //   357: astore_1
        //   358: aload_1
        //   359: aload_2
        //   360: aload_0
        //   361: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
        //   364: invokespecial <init> : (Ljava/lang/Throwable;)V
        //   367: aload_1
        //   368: athrow
        //   369: aload_1
        //   370: athrow
        //   371: getstatic com/google/api/Distribution$BucketOptions$Explicit.DEFAULT_INSTANCE : Lcom/google/api/Distribution$BucketOptions$Explicit;
        //   374: areturn
        //   375: aload_2
        //   376: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
        //   379: astore_1
        //   380: aload_3
        //   381: checkcast com/google/api/Distribution$BucketOptions$Explicit
        //   384: astore_2
        //   385: aload_0
        //   386: aload_1
        //   387: aload_0
        //   388: getfield bounds_ : Lcom/google/protobuf/Internal$DoubleList;
        //   391: aload_2
        //   392: getfield bounds_ : Lcom/google/protobuf/Internal$DoubleList;
        //   395: invokeinterface visitDoubleList : (Lcom/google/protobuf/Internal$DoubleList;Lcom/google/protobuf/Internal$DoubleList;)Lcom/google/protobuf/Internal$DoubleList;
        //   400: putfield bounds_ : Lcom/google/protobuf/Internal$DoubleList;
        //   403: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
        //   406: astore_1
        //   407: aload_0
        //   408: areturn
        //   409: new com/google/api/Distribution$BucketOptions$Explicit$Builder
        //   412: dup
        //   413: aconst_null
        //   414: invokespecial <init> : (Lcom/google/api/Distribution$1;)V
        //   417: areturn
        //   418: aload_0
        //   419: getfield bounds_ : Lcom/google/protobuf/Internal$DoubleList;
        //   422: invokeinterface makeImmutable : ()V
        //   427: aconst_null
        //   428: areturn
        //   429: getstatic com/google/api/Distribution$BucketOptions$Explicit.DEFAULT_INSTANCE : Lcom/google/api/Distribution$BucketOptions$Explicit;
        //   432: areturn
        //   433: new com/google/api/Distribution$BucketOptions$Explicit
        //   436: dup
        //   437: invokespecial <init> : ()V
        //   440: areturn
        // Exception table:
        //   from	to	target	type
        //   73	94	100	finally
        //   94	97	100	finally
        //   101	104	100	finally
        //   128	134	353	com/google/protobuf/InvalidProtocolBufferException
        //   128	134	325	java/io/IOException
        //   128	134	321	finally
        //   164	173	353	com/google/protobuf/InvalidProtocolBufferException
        //   164	173	325	java/io/IOException
        //   164	173	321	finally
        //   179	244	353	com/google/protobuf/InvalidProtocolBufferException
        //   179	244	325	java/io/IOException
        //   179	244	321	finally
        //   244	264	353	com/google/protobuf/InvalidProtocolBufferException
        //   244	264	325	java/io/IOException
        //   244	264	321	finally
        //   267	273	353	com/google/protobuf/InvalidProtocolBufferException
        //   267	273	325	java/io/IOException
        //   267	273	321	finally
        //   276	299	353	com/google/protobuf/InvalidProtocolBufferException
        //   276	299	325	java/io/IOException
        //   276	299	321	finally
        //   299	312	353	com/google/protobuf/InvalidProtocolBufferException
        //   299	312	325	java/io/IOException
        //   299	312	321	finally
        //   326	353	321	finally
        //   354	369	321	finally
      }
      
      public double getBounds(int param2Int) {
        return this.bounds_.getDouble(param2Int);
      }
      
      public int getBoundsCount() {
        return this.bounds_.size();
      }
      
      public List<Double> getBoundsList() {
        return (List<Double>)this.bounds_;
      }
      
      public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1)
          return i; 
        i = getBoundsList().size() * 8 + 0 + getBoundsList().size() * 1;
        this.memoizedSerializedSize = i;
        return i;
      }
      
      public void writeTo(CodedOutputStream param2CodedOutputStream) throws IOException {
        getSerializedSize();
        for (byte b = 0; b < this.bounds_.size(); b++)
          param2CodedOutputStream.writeDouble(1, this.bounds_.getDouble(b)); 
      }
      
      public static final class Builder extends GeneratedMessageLite.Builder<Explicit, Builder> implements Distribution.BucketOptions.ExplicitOrBuilder {
        private Builder() {
          super(Distribution.BucketOptions.Explicit.DEFAULT_INSTANCE);
        }
        
        public Builder addAllBounds(Iterable<? extends Double> param3Iterable) {
          copyOnWrite();
          ((Distribution.BucketOptions.Explicit)this.instance).addAllBounds(param3Iterable);
          return this;
        }
        
        public Builder addBounds(double param3Double) {
          copyOnWrite();
          ((Distribution.BucketOptions.Explicit)this.instance).addBounds(param3Double);
          return this;
        }
        
        public Builder clearBounds() {
          copyOnWrite();
          ((Distribution.BucketOptions.Explicit)this.instance).clearBounds();
          return this;
        }
        
        public double getBounds(int param3Int) {
          return ((Distribution.BucketOptions.Explicit)this.instance).getBounds(param3Int);
        }
        
        public int getBoundsCount() {
          return ((Distribution.BucketOptions.Explicit)this.instance).getBoundsCount();
        }
        
        public List<Double> getBoundsList() {
          return Collections.unmodifiableList(((Distribution.BucketOptions.Explicit)this.instance).getBoundsList());
        }
        
        public Builder setBounds(int param3Int, double param3Double) {
          copyOnWrite();
          ((Distribution.BucketOptions.Explicit)this.instance).setBounds(param3Int, param3Double);
          return this;
        }
      }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Explicit, Explicit.Builder> implements ExplicitOrBuilder {
      private Builder() {
        super(Distribution.BucketOptions.Explicit.DEFAULT_INSTANCE);
      }
      
      public Builder addAllBounds(Iterable<? extends Double> param2Iterable) {
        copyOnWrite();
        ((Distribution.BucketOptions.Explicit)this.instance).addAllBounds(param2Iterable);
        return this;
      }
      
      public Builder addBounds(double param2Double) {
        copyOnWrite();
        ((Distribution.BucketOptions.Explicit)this.instance).addBounds(param2Double);
        return this;
      }
      
      public Builder clearBounds() {
        copyOnWrite();
        ((Distribution.BucketOptions.Explicit)this.instance).clearBounds();
        return this;
      }
      
      public double getBounds(int param2Int) {
        return ((Distribution.BucketOptions.Explicit)this.instance).getBounds(param2Int);
      }
      
      public int getBoundsCount() {
        return ((Distribution.BucketOptions.Explicit)this.instance).getBoundsCount();
      }
      
      public List<Double> getBoundsList() {
        return Collections.unmodifiableList(((Distribution.BucketOptions.Explicit)this.instance).getBoundsList());
      }
      
      public Builder setBounds(int param2Int, double param2Double) {
        copyOnWrite();
        ((Distribution.BucketOptions.Explicit)this.instance).setBounds(param2Int, param2Double);
        return this;
      }
    }
    
    public static interface ExplicitOrBuilder extends MessageLiteOrBuilder {
      double getBounds(int param2Int);
      
      int getBoundsCount();
      
      List<Double> getBoundsList();
    }
    
    public static final class Exponential extends GeneratedMessageLite<Exponential, Exponential.Builder> implements ExponentialOrBuilder {
      private static final Exponential DEFAULT_INSTANCE = new Exponential();
      
      public static final int GROWTH_FACTOR_FIELD_NUMBER = 2;
      
      public static final int NUM_FINITE_BUCKETS_FIELD_NUMBER = 1;
      
      private static volatile Parser<Exponential> PARSER;
      
      public static final int SCALE_FIELD_NUMBER = 3;
      
      private double growthFactor_;
      
      private int numFiniteBuckets_;
      
      private double scale_;
      
      static {
        DEFAULT_INSTANCE.makeImmutable();
      }
      
      private void clearGrowthFactor() {
        this.growthFactor_ = 0.0D;
      }
      
      private void clearNumFiniteBuckets() {
        this.numFiniteBuckets_ = 0;
      }
      
      private void clearScale() {
        this.scale_ = 0.0D;
      }
      
      public static Exponential getDefaultInstance() {
        return DEFAULT_INSTANCE;
      }
      
      public static Builder newBuilder() {
        return (Builder)DEFAULT_INSTANCE.toBuilder();
      }
      
      public static Builder newBuilder(Exponential param2Exponential) {
        return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param2Exponential);
      }
      
      public static Exponential parseDelimitedFrom(InputStream param2InputStream) throws IOException {
        return (Exponential)parseDelimitedFrom(DEFAULT_INSTANCE, param2InputStream);
      }
      
      public static Exponential parseDelimitedFrom(InputStream param2InputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (Exponential)parseDelimitedFrom(DEFAULT_INSTANCE, param2InputStream, param2ExtensionRegistryLite);
      }
      
      public static Exponential parseFrom(ByteString param2ByteString) throws InvalidProtocolBufferException {
        return (Exponential)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ByteString);
      }
      
      public static Exponential parseFrom(ByteString param2ByteString, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (Exponential)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ByteString, param2ExtensionRegistryLite);
      }
      
      public static Exponential parseFrom(CodedInputStream param2CodedInputStream) throws IOException {
        return (Exponential)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2CodedInputStream);
      }
      
      public static Exponential parseFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (Exponential)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2CodedInputStream, param2ExtensionRegistryLite);
      }
      
      public static Exponential parseFrom(InputStream param2InputStream) throws IOException {
        return (Exponential)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2InputStream);
      }
      
      public static Exponential parseFrom(InputStream param2InputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (Exponential)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2InputStream, param2ExtensionRegistryLite);
      }
      
      public static Exponential parseFrom(byte[] param2ArrayOfbyte) throws InvalidProtocolBufferException {
        return (Exponential)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ArrayOfbyte);
      }
      
      public static Exponential parseFrom(byte[] param2ArrayOfbyte, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (Exponential)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ArrayOfbyte, param2ExtensionRegistryLite);
      }
      
      public static Parser<Exponential> parser() {
        return DEFAULT_INSTANCE.getParserForType();
      }
      
      private void setGrowthFactor(double param2Double) {
        this.growthFactor_ = param2Double;
      }
      
      private void setNumFiniteBuckets(int param2Int) {
        this.numFiniteBuckets_ = param2Int;
      }
      
      private void setScale(double param2Double) {
        this.scale_ = param2Double;
      }
      
      protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param2MethodToInvoke, Object param2Object1, Object param2Object2) {
        // Byte code:
        //   0: getstatic com/google/api/Distribution$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
        //   3: aload_1
        //   4: invokevirtual ordinal : ()I
        //   7: iaload
        //   8: istore #4
        //   10: iconst_0
        //   11: istore #5
        //   13: iload #4
        //   15: tableswitch default -> 60, 1 -> 482, 2 -> 478, 3 -> 476, 4 -> 467, 5 -> 269, 6 -> 114, 7 -> 265, 8 -> 68
        //   60: new java/lang/UnsupportedOperationException
        //   63: dup
        //   64: invokespecial <init> : ()V
        //   67: athrow
        //   68: getstatic com/google/api/Distribution$BucketOptions$Exponential.PARSER : Lcom/google/protobuf/Parser;
        //   71: ifnonnull -> 110
        //   74: ldc com/google/api/Distribution$BucketOptions$Exponential
        //   76: monitorenter
        //   77: getstatic com/google/api/Distribution$BucketOptions$Exponential.PARSER : Lcom/google/protobuf/Parser;
        //   80: ifnonnull -> 98
        //   83: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
        //   86: astore_1
        //   87: aload_1
        //   88: getstatic com/google/api/Distribution$BucketOptions$Exponential.DEFAULT_INSTANCE : Lcom/google/api/Distribution$BucketOptions$Exponential;
        //   91: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
        //   94: aload_1
        //   95: putstatic com/google/api/Distribution$BucketOptions$Exponential.PARSER : Lcom/google/protobuf/Parser;
        //   98: ldc com/google/api/Distribution$BucketOptions$Exponential
        //   100: monitorexit
        //   101: goto -> 110
        //   104: astore_1
        //   105: ldc com/google/api/Distribution$BucketOptions$Exponential
        //   107: monitorexit
        //   108: aload_1
        //   109: athrow
        //   110: getstatic com/google/api/Distribution$BucketOptions$Exponential.PARSER : Lcom/google/protobuf/Parser;
        //   113: areturn
        //   114: aload_2
        //   115: checkcast com/google/protobuf/CodedInputStream
        //   118: astore_1
        //   119: aload_3
        //   120: checkcast com/google/protobuf/ExtensionRegistryLite
        //   123: astore_2
        //   124: iload #5
        //   126: ifne -> 265
        //   129: aload_1
        //   130: invokevirtual readTag : ()I
        //   133: istore #4
        //   135: iload #4
        //   137: ifeq -> 209
        //   140: iload #4
        //   142: bipush #8
        //   144: if_icmpeq -> 198
        //   147: iload #4
        //   149: bipush #17
        //   151: if_icmpeq -> 187
        //   154: iload #4
        //   156: bipush #25
        //   158: if_icmpeq -> 176
        //   161: aload_1
        //   162: iload #4
        //   164: invokevirtual skipField : (I)Z
        //   167: ifne -> 124
        //   170: iconst_1
        //   171: istore #5
        //   173: goto -> 124
        //   176: aload_0
        //   177: aload_1
        //   178: invokevirtual readDouble : ()D
        //   181: putfield scale_ : D
        //   184: goto -> 124
        //   187: aload_0
        //   188: aload_1
        //   189: invokevirtual readDouble : ()D
        //   192: putfield growthFactor_ : D
        //   195: goto -> 124
        //   198: aload_0
        //   199: aload_1
        //   200: invokevirtual readInt32 : ()I
        //   203: putfield numFiniteBuckets_ : I
        //   206: goto -> 124
        //   209: iconst_1
        //   210: istore #5
        //   212: goto -> 124
        //   215: astore_1
        //   216: goto -> 263
        //   219: astore_1
        //   220: new java/lang/RuntimeException
        //   223: astore_3
        //   224: new com/google/protobuf/InvalidProtocolBufferException
        //   227: astore_2
        //   228: aload_2
        //   229: aload_1
        //   230: invokevirtual getMessage : ()Ljava/lang/String;
        //   233: invokespecial <init> : (Ljava/lang/String;)V
        //   236: aload_3
        //   237: aload_2
        //   238: aload_0
        //   239: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
        //   242: invokespecial <init> : (Ljava/lang/Throwable;)V
        //   245: aload_3
        //   246: athrow
        //   247: astore_1
        //   248: new java/lang/RuntimeException
        //   251: astore_2
        //   252: aload_2
        //   253: aload_1
        //   254: aload_0
        //   255: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
        //   258: invokespecial <init> : (Ljava/lang/Throwable;)V
        //   261: aload_2
        //   262: athrow
        //   263: aload_1
        //   264: athrow
        //   265: getstatic com/google/api/Distribution$BucketOptions$Exponential.DEFAULT_INSTANCE : Lcom/google/api/Distribution$BucketOptions$Exponential;
        //   268: areturn
        //   269: aload_2
        //   270: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
        //   273: astore_1
        //   274: aload_3
        //   275: checkcast com/google/api/Distribution$BucketOptions$Exponential
        //   278: astore_2
        //   279: aload_0
        //   280: getfield numFiniteBuckets_ : I
        //   283: ifeq -> 292
        //   286: iconst_1
        //   287: istore #6
        //   289: goto -> 295
        //   292: iconst_0
        //   293: istore #6
        //   295: aload_0
        //   296: getfield numFiniteBuckets_ : I
        //   299: istore #5
        //   301: aload_2
        //   302: getfield numFiniteBuckets_ : I
        //   305: ifeq -> 314
        //   308: iconst_1
        //   309: istore #7
        //   311: goto -> 317
        //   314: iconst_0
        //   315: istore #7
        //   317: aload_0
        //   318: aload_1
        //   319: iload #6
        //   321: iload #5
        //   323: iload #7
        //   325: aload_2
        //   326: getfield numFiniteBuckets_ : I
        //   329: invokeinterface visitInt : (ZIZI)I
        //   334: putfield numFiniteBuckets_ : I
        //   337: aload_0
        //   338: getfield growthFactor_ : D
        //   341: dconst_0
        //   342: dcmpl
        //   343: ifeq -> 352
        //   346: iconst_1
        //   347: istore #6
        //   349: goto -> 355
        //   352: iconst_0
        //   353: istore #6
        //   355: aload_0
        //   356: getfield growthFactor_ : D
        //   359: dstore #8
        //   361: aload_2
        //   362: getfield growthFactor_ : D
        //   365: dconst_0
        //   366: dcmpl
        //   367: ifeq -> 376
        //   370: iconst_1
        //   371: istore #7
        //   373: goto -> 379
        //   376: iconst_0
        //   377: istore #7
        //   379: aload_0
        //   380: aload_1
        //   381: iload #6
        //   383: dload #8
        //   385: iload #7
        //   387: aload_2
        //   388: getfield growthFactor_ : D
        //   391: invokeinterface visitDouble : (ZDZD)D
        //   396: putfield growthFactor_ : D
        //   399: aload_0
        //   400: getfield scale_ : D
        //   403: dconst_0
        //   404: dcmpl
        //   405: ifeq -> 414
        //   408: iconst_1
        //   409: istore #6
        //   411: goto -> 417
        //   414: iconst_0
        //   415: istore #6
        //   417: aload_0
        //   418: getfield scale_ : D
        //   421: dstore #8
        //   423: aload_2
        //   424: getfield scale_ : D
        //   427: dconst_0
        //   428: dcmpl
        //   429: ifeq -> 438
        //   432: iconst_1
        //   433: istore #7
        //   435: goto -> 441
        //   438: iconst_0
        //   439: istore #7
        //   441: aload_0
        //   442: aload_1
        //   443: iload #6
        //   445: dload #8
        //   447: iload #7
        //   449: aload_2
        //   450: getfield scale_ : D
        //   453: invokeinterface visitDouble : (ZDZD)D
        //   458: putfield scale_ : D
        //   461: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
        //   464: astore_1
        //   465: aload_0
        //   466: areturn
        //   467: new com/google/api/Distribution$BucketOptions$Exponential$Builder
        //   470: dup
        //   471: aconst_null
        //   472: invokespecial <init> : (Lcom/google/api/Distribution$1;)V
        //   475: areturn
        //   476: aconst_null
        //   477: areturn
        //   478: getstatic com/google/api/Distribution$BucketOptions$Exponential.DEFAULT_INSTANCE : Lcom/google/api/Distribution$BucketOptions$Exponential;
        //   481: areturn
        //   482: new com/google/api/Distribution$BucketOptions$Exponential
        //   485: dup
        //   486: invokespecial <init> : ()V
        //   489: areturn
        // Exception table:
        //   from	to	target	type
        //   77	98	104	finally
        //   98	101	104	finally
        //   105	108	104	finally
        //   129	135	247	com/google/protobuf/InvalidProtocolBufferException
        //   129	135	219	java/io/IOException
        //   129	135	215	finally
        //   161	170	247	com/google/protobuf/InvalidProtocolBufferException
        //   161	170	219	java/io/IOException
        //   161	170	215	finally
        //   176	184	247	com/google/protobuf/InvalidProtocolBufferException
        //   176	184	219	java/io/IOException
        //   176	184	215	finally
        //   187	195	247	com/google/protobuf/InvalidProtocolBufferException
        //   187	195	219	java/io/IOException
        //   187	195	215	finally
        //   198	206	247	com/google/protobuf/InvalidProtocolBufferException
        //   198	206	219	java/io/IOException
        //   198	206	215	finally
        //   220	247	215	finally
        //   248	263	215	finally
      }
      
      public double getGrowthFactor() {
        return this.growthFactor_;
      }
      
      public int getNumFiniteBuckets() {
        return this.numFiniteBuckets_;
      }
      
      public double getScale() {
        return this.scale_;
      }
      
      public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1)
          return i; 
        int j = 0;
        i = this.numFiniteBuckets_;
        if (i != 0)
          j = 0 + CodedOutputStream.computeInt32Size(1, i); 
        double d = this.growthFactor_;
        i = j;
        if (d != 0.0D)
          i = j + CodedOutputStream.computeDoubleSize(2, d); 
        d = this.scale_;
        j = i;
        if (d != 0.0D)
          j = i + CodedOutputStream.computeDoubleSize(3, d); 
        this.memoizedSerializedSize = j;
        return j;
      }
      
      public void writeTo(CodedOutputStream param2CodedOutputStream) throws IOException {
        int i = this.numFiniteBuckets_;
        if (i != 0)
          param2CodedOutputStream.writeInt32(1, i); 
        double d = this.growthFactor_;
        if (d != 0.0D)
          param2CodedOutputStream.writeDouble(2, d); 
        d = this.scale_;
        if (d != 0.0D)
          param2CodedOutputStream.writeDouble(3, d); 
      }
      
      public static final class Builder extends GeneratedMessageLite.Builder<Exponential, Builder> implements Distribution.BucketOptions.ExponentialOrBuilder {
        private Builder() {
          super(Distribution.BucketOptions.Exponential.DEFAULT_INSTANCE);
        }
        
        public Builder clearGrowthFactor() {
          copyOnWrite();
          ((Distribution.BucketOptions.Exponential)this.instance).clearGrowthFactor();
          return this;
        }
        
        public Builder clearNumFiniteBuckets() {
          copyOnWrite();
          ((Distribution.BucketOptions.Exponential)this.instance).clearNumFiniteBuckets();
          return this;
        }
        
        public Builder clearScale() {
          copyOnWrite();
          ((Distribution.BucketOptions.Exponential)this.instance).clearScale();
          return this;
        }
        
        public double getGrowthFactor() {
          return ((Distribution.BucketOptions.Exponential)this.instance).getGrowthFactor();
        }
        
        public int getNumFiniteBuckets() {
          return ((Distribution.BucketOptions.Exponential)this.instance).getNumFiniteBuckets();
        }
        
        public double getScale() {
          return ((Distribution.BucketOptions.Exponential)this.instance).getScale();
        }
        
        public Builder setGrowthFactor(double param3Double) {
          copyOnWrite();
          ((Distribution.BucketOptions.Exponential)this.instance).setGrowthFactor(param3Double);
          return this;
        }
        
        public Builder setNumFiniteBuckets(int param3Int) {
          copyOnWrite();
          ((Distribution.BucketOptions.Exponential)this.instance).setNumFiniteBuckets(param3Int);
          return this;
        }
        
        public Builder setScale(double param3Double) {
          copyOnWrite();
          ((Distribution.BucketOptions.Exponential)this.instance).setScale(param3Double);
          return this;
        }
      }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Exponential, Exponential.Builder> implements ExponentialOrBuilder {
      private Builder() {
        super(Distribution.BucketOptions.Exponential.DEFAULT_INSTANCE);
      }
      
      public Builder clearGrowthFactor() {
        copyOnWrite();
        ((Distribution.BucketOptions.Exponential)this.instance).clearGrowthFactor();
        return this;
      }
      
      public Builder clearNumFiniteBuckets() {
        copyOnWrite();
        ((Distribution.BucketOptions.Exponential)this.instance).clearNumFiniteBuckets();
        return this;
      }
      
      public Builder clearScale() {
        copyOnWrite();
        ((Distribution.BucketOptions.Exponential)this.instance).clearScale();
        return this;
      }
      
      public double getGrowthFactor() {
        return ((Distribution.BucketOptions.Exponential)this.instance).getGrowthFactor();
      }
      
      public int getNumFiniteBuckets() {
        return ((Distribution.BucketOptions.Exponential)this.instance).getNumFiniteBuckets();
      }
      
      public double getScale() {
        return ((Distribution.BucketOptions.Exponential)this.instance).getScale();
      }
      
      public Builder setGrowthFactor(double param2Double) {
        copyOnWrite();
        ((Distribution.BucketOptions.Exponential)this.instance).setGrowthFactor(param2Double);
        return this;
      }
      
      public Builder setNumFiniteBuckets(int param2Int) {
        copyOnWrite();
        ((Distribution.BucketOptions.Exponential)this.instance).setNumFiniteBuckets(param2Int);
        return this;
      }
      
      public Builder setScale(double param2Double) {
        copyOnWrite();
        ((Distribution.BucketOptions.Exponential)this.instance).setScale(param2Double);
        return this;
      }
    }
    
    public static interface ExponentialOrBuilder extends MessageLiteOrBuilder {
      double getGrowthFactor();
      
      int getNumFiniteBuckets();
      
      double getScale();
    }
    
    public static final class Linear extends GeneratedMessageLite<Linear, Linear.Builder> implements LinearOrBuilder {
      private static final Linear DEFAULT_INSTANCE = new Linear();
      
      public static final int NUM_FINITE_BUCKETS_FIELD_NUMBER = 1;
      
      public static final int OFFSET_FIELD_NUMBER = 3;
      
      private static volatile Parser<Linear> PARSER;
      
      public static final int WIDTH_FIELD_NUMBER = 2;
      
      private int numFiniteBuckets_;
      
      private double offset_;
      
      private double width_;
      
      static {
        DEFAULT_INSTANCE.makeImmutable();
      }
      
      private void clearNumFiniteBuckets() {
        this.numFiniteBuckets_ = 0;
      }
      
      private void clearOffset() {
        this.offset_ = 0.0D;
      }
      
      private void clearWidth() {
        this.width_ = 0.0D;
      }
      
      public static Linear getDefaultInstance() {
        return DEFAULT_INSTANCE;
      }
      
      public static Builder newBuilder() {
        return (Builder)DEFAULT_INSTANCE.toBuilder();
      }
      
      public static Builder newBuilder(Linear param2Linear) {
        return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param2Linear);
      }
      
      public static Linear parseDelimitedFrom(InputStream param2InputStream) throws IOException {
        return (Linear)parseDelimitedFrom(DEFAULT_INSTANCE, param2InputStream);
      }
      
      public static Linear parseDelimitedFrom(InputStream param2InputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (Linear)parseDelimitedFrom(DEFAULT_INSTANCE, param2InputStream, param2ExtensionRegistryLite);
      }
      
      public static Linear parseFrom(ByteString param2ByteString) throws InvalidProtocolBufferException {
        return (Linear)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ByteString);
      }
      
      public static Linear parseFrom(ByteString param2ByteString, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (Linear)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ByteString, param2ExtensionRegistryLite);
      }
      
      public static Linear parseFrom(CodedInputStream param2CodedInputStream) throws IOException {
        return (Linear)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2CodedInputStream);
      }
      
      public static Linear parseFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (Linear)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2CodedInputStream, param2ExtensionRegistryLite);
      }
      
      public static Linear parseFrom(InputStream param2InputStream) throws IOException {
        return (Linear)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2InputStream);
      }
      
      public static Linear parseFrom(InputStream param2InputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (Linear)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2InputStream, param2ExtensionRegistryLite);
      }
      
      public static Linear parseFrom(byte[] param2ArrayOfbyte) throws InvalidProtocolBufferException {
        return (Linear)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ArrayOfbyte);
      }
      
      public static Linear parseFrom(byte[] param2ArrayOfbyte, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (Linear)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ArrayOfbyte, param2ExtensionRegistryLite);
      }
      
      public static Parser<Linear> parser() {
        return DEFAULT_INSTANCE.getParserForType();
      }
      
      private void setNumFiniteBuckets(int param2Int) {
        this.numFiniteBuckets_ = param2Int;
      }
      
      private void setOffset(double param2Double) {
        this.offset_ = param2Double;
      }
      
      private void setWidth(double param2Double) {
        this.width_ = param2Double;
      }
      
      protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param2MethodToInvoke, Object param2Object1, Object param2Object2) {
        // Byte code:
        //   0: getstatic com/google/api/Distribution$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
        //   3: aload_1
        //   4: invokevirtual ordinal : ()I
        //   7: iaload
        //   8: istore #4
        //   10: iconst_0
        //   11: istore #5
        //   13: iload #4
        //   15: tableswitch default -> 60, 1 -> 482, 2 -> 478, 3 -> 476, 4 -> 467, 5 -> 269, 6 -> 114, 7 -> 265, 8 -> 68
        //   60: new java/lang/UnsupportedOperationException
        //   63: dup
        //   64: invokespecial <init> : ()V
        //   67: athrow
        //   68: getstatic com/google/api/Distribution$BucketOptions$Linear.PARSER : Lcom/google/protobuf/Parser;
        //   71: ifnonnull -> 110
        //   74: ldc com/google/api/Distribution$BucketOptions$Linear
        //   76: monitorenter
        //   77: getstatic com/google/api/Distribution$BucketOptions$Linear.PARSER : Lcom/google/protobuf/Parser;
        //   80: ifnonnull -> 98
        //   83: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
        //   86: astore_1
        //   87: aload_1
        //   88: getstatic com/google/api/Distribution$BucketOptions$Linear.DEFAULT_INSTANCE : Lcom/google/api/Distribution$BucketOptions$Linear;
        //   91: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
        //   94: aload_1
        //   95: putstatic com/google/api/Distribution$BucketOptions$Linear.PARSER : Lcom/google/protobuf/Parser;
        //   98: ldc com/google/api/Distribution$BucketOptions$Linear
        //   100: monitorexit
        //   101: goto -> 110
        //   104: astore_1
        //   105: ldc com/google/api/Distribution$BucketOptions$Linear
        //   107: monitorexit
        //   108: aload_1
        //   109: athrow
        //   110: getstatic com/google/api/Distribution$BucketOptions$Linear.PARSER : Lcom/google/protobuf/Parser;
        //   113: areturn
        //   114: aload_2
        //   115: checkcast com/google/protobuf/CodedInputStream
        //   118: astore_1
        //   119: aload_3
        //   120: checkcast com/google/protobuf/ExtensionRegistryLite
        //   123: astore_2
        //   124: iload #5
        //   126: ifne -> 265
        //   129: aload_1
        //   130: invokevirtual readTag : ()I
        //   133: istore #4
        //   135: iload #4
        //   137: ifeq -> 209
        //   140: iload #4
        //   142: bipush #8
        //   144: if_icmpeq -> 198
        //   147: iload #4
        //   149: bipush #17
        //   151: if_icmpeq -> 187
        //   154: iload #4
        //   156: bipush #25
        //   158: if_icmpeq -> 176
        //   161: aload_1
        //   162: iload #4
        //   164: invokevirtual skipField : (I)Z
        //   167: ifne -> 124
        //   170: iconst_1
        //   171: istore #5
        //   173: goto -> 124
        //   176: aload_0
        //   177: aload_1
        //   178: invokevirtual readDouble : ()D
        //   181: putfield offset_ : D
        //   184: goto -> 124
        //   187: aload_0
        //   188: aload_1
        //   189: invokevirtual readDouble : ()D
        //   192: putfield width_ : D
        //   195: goto -> 124
        //   198: aload_0
        //   199: aload_1
        //   200: invokevirtual readInt32 : ()I
        //   203: putfield numFiniteBuckets_ : I
        //   206: goto -> 124
        //   209: iconst_1
        //   210: istore #5
        //   212: goto -> 124
        //   215: astore_1
        //   216: goto -> 263
        //   219: astore_2
        //   220: new java/lang/RuntimeException
        //   223: astore_3
        //   224: new com/google/protobuf/InvalidProtocolBufferException
        //   227: astore_1
        //   228: aload_1
        //   229: aload_2
        //   230: invokevirtual getMessage : ()Ljava/lang/String;
        //   233: invokespecial <init> : (Ljava/lang/String;)V
        //   236: aload_3
        //   237: aload_1
        //   238: aload_0
        //   239: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
        //   242: invokespecial <init> : (Ljava/lang/Throwable;)V
        //   245: aload_3
        //   246: athrow
        //   247: astore_2
        //   248: new java/lang/RuntimeException
        //   251: astore_1
        //   252: aload_1
        //   253: aload_2
        //   254: aload_0
        //   255: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
        //   258: invokespecial <init> : (Ljava/lang/Throwable;)V
        //   261: aload_1
        //   262: athrow
        //   263: aload_1
        //   264: athrow
        //   265: getstatic com/google/api/Distribution$BucketOptions$Linear.DEFAULT_INSTANCE : Lcom/google/api/Distribution$BucketOptions$Linear;
        //   268: areturn
        //   269: aload_2
        //   270: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
        //   273: astore_1
        //   274: aload_3
        //   275: checkcast com/google/api/Distribution$BucketOptions$Linear
        //   278: astore_2
        //   279: aload_0
        //   280: getfield numFiniteBuckets_ : I
        //   283: ifeq -> 292
        //   286: iconst_1
        //   287: istore #6
        //   289: goto -> 295
        //   292: iconst_0
        //   293: istore #6
        //   295: aload_0
        //   296: getfield numFiniteBuckets_ : I
        //   299: istore #5
        //   301: aload_2
        //   302: getfield numFiniteBuckets_ : I
        //   305: ifeq -> 314
        //   308: iconst_1
        //   309: istore #7
        //   311: goto -> 317
        //   314: iconst_0
        //   315: istore #7
        //   317: aload_0
        //   318: aload_1
        //   319: iload #6
        //   321: iload #5
        //   323: iload #7
        //   325: aload_2
        //   326: getfield numFiniteBuckets_ : I
        //   329: invokeinterface visitInt : (ZIZI)I
        //   334: putfield numFiniteBuckets_ : I
        //   337: aload_0
        //   338: getfield width_ : D
        //   341: dconst_0
        //   342: dcmpl
        //   343: ifeq -> 352
        //   346: iconst_1
        //   347: istore #6
        //   349: goto -> 355
        //   352: iconst_0
        //   353: istore #6
        //   355: aload_0
        //   356: getfield width_ : D
        //   359: dstore #8
        //   361: aload_2
        //   362: getfield width_ : D
        //   365: dconst_0
        //   366: dcmpl
        //   367: ifeq -> 376
        //   370: iconst_1
        //   371: istore #7
        //   373: goto -> 379
        //   376: iconst_0
        //   377: istore #7
        //   379: aload_0
        //   380: aload_1
        //   381: iload #6
        //   383: dload #8
        //   385: iload #7
        //   387: aload_2
        //   388: getfield width_ : D
        //   391: invokeinterface visitDouble : (ZDZD)D
        //   396: putfield width_ : D
        //   399: aload_0
        //   400: getfield offset_ : D
        //   403: dconst_0
        //   404: dcmpl
        //   405: ifeq -> 414
        //   408: iconst_1
        //   409: istore #6
        //   411: goto -> 417
        //   414: iconst_0
        //   415: istore #6
        //   417: aload_0
        //   418: getfield offset_ : D
        //   421: dstore #8
        //   423: aload_2
        //   424: getfield offset_ : D
        //   427: dconst_0
        //   428: dcmpl
        //   429: ifeq -> 438
        //   432: iconst_1
        //   433: istore #7
        //   435: goto -> 441
        //   438: iconst_0
        //   439: istore #7
        //   441: aload_0
        //   442: aload_1
        //   443: iload #6
        //   445: dload #8
        //   447: iload #7
        //   449: aload_2
        //   450: getfield offset_ : D
        //   453: invokeinterface visitDouble : (ZDZD)D
        //   458: putfield offset_ : D
        //   461: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
        //   464: astore_1
        //   465: aload_0
        //   466: areturn
        //   467: new com/google/api/Distribution$BucketOptions$Linear$Builder
        //   470: dup
        //   471: aconst_null
        //   472: invokespecial <init> : (Lcom/google/api/Distribution$1;)V
        //   475: areturn
        //   476: aconst_null
        //   477: areturn
        //   478: getstatic com/google/api/Distribution$BucketOptions$Linear.DEFAULT_INSTANCE : Lcom/google/api/Distribution$BucketOptions$Linear;
        //   481: areturn
        //   482: new com/google/api/Distribution$BucketOptions$Linear
        //   485: dup
        //   486: invokespecial <init> : ()V
        //   489: areturn
        // Exception table:
        //   from	to	target	type
        //   77	98	104	finally
        //   98	101	104	finally
        //   105	108	104	finally
        //   129	135	247	com/google/protobuf/InvalidProtocolBufferException
        //   129	135	219	java/io/IOException
        //   129	135	215	finally
        //   161	170	247	com/google/protobuf/InvalidProtocolBufferException
        //   161	170	219	java/io/IOException
        //   161	170	215	finally
        //   176	184	247	com/google/protobuf/InvalidProtocolBufferException
        //   176	184	219	java/io/IOException
        //   176	184	215	finally
        //   187	195	247	com/google/protobuf/InvalidProtocolBufferException
        //   187	195	219	java/io/IOException
        //   187	195	215	finally
        //   198	206	247	com/google/protobuf/InvalidProtocolBufferException
        //   198	206	219	java/io/IOException
        //   198	206	215	finally
        //   220	247	215	finally
        //   248	263	215	finally
      }
      
      public int getNumFiniteBuckets() {
        return this.numFiniteBuckets_;
      }
      
      public double getOffset() {
        return this.offset_;
      }
      
      public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1)
          return i; 
        i = 0;
        int j = this.numFiniteBuckets_;
        if (j != 0)
          i = 0 + CodedOutputStream.computeInt32Size(1, j); 
        double d = this.width_;
        j = i;
        if (d != 0.0D)
          j = i + CodedOutputStream.computeDoubleSize(2, d); 
        d = this.offset_;
        i = j;
        if (d != 0.0D)
          i = j + CodedOutputStream.computeDoubleSize(3, d); 
        this.memoizedSerializedSize = i;
        return i;
      }
      
      public double getWidth() {
        return this.width_;
      }
      
      public void writeTo(CodedOutputStream param2CodedOutputStream) throws IOException {
        int i = this.numFiniteBuckets_;
        if (i != 0)
          param2CodedOutputStream.writeInt32(1, i); 
        double d = this.width_;
        if (d != 0.0D)
          param2CodedOutputStream.writeDouble(2, d); 
        d = this.offset_;
        if (d != 0.0D)
          param2CodedOutputStream.writeDouble(3, d); 
      }
      
      public static final class Builder extends GeneratedMessageLite.Builder<Linear, Builder> implements Distribution.BucketOptions.LinearOrBuilder {
        private Builder() {
          super(Distribution.BucketOptions.Linear.DEFAULT_INSTANCE);
        }
        
        public Builder clearNumFiniteBuckets() {
          copyOnWrite();
          ((Distribution.BucketOptions.Linear)this.instance).clearNumFiniteBuckets();
          return this;
        }
        
        public Builder clearOffset() {
          copyOnWrite();
          ((Distribution.BucketOptions.Linear)this.instance).clearOffset();
          return this;
        }
        
        public Builder clearWidth() {
          copyOnWrite();
          ((Distribution.BucketOptions.Linear)this.instance).clearWidth();
          return this;
        }
        
        public int getNumFiniteBuckets() {
          return ((Distribution.BucketOptions.Linear)this.instance).getNumFiniteBuckets();
        }
        
        public double getOffset() {
          return ((Distribution.BucketOptions.Linear)this.instance).getOffset();
        }
        
        public double getWidth() {
          return ((Distribution.BucketOptions.Linear)this.instance).getWidth();
        }
        
        public Builder setNumFiniteBuckets(int param3Int) {
          copyOnWrite();
          ((Distribution.BucketOptions.Linear)this.instance).setNumFiniteBuckets(param3Int);
          return this;
        }
        
        public Builder setOffset(double param3Double) {
          copyOnWrite();
          ((Distribution.BucketOptions.Linear)this.instance).setOffset(param3Double);
          return this;
        }
        
        public Builder setWidth(double param3Double) {
          copyOnWrite();
          ((Distribution.BucketOptions.Linear)this.instance).setWidth(param3Double);
          return this;
        }
      }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Linear, Linear.Builder> implements LinearOrBuilder {
      private Builder() {
        super(Distribution.BucketOptions.Linear.DEFAULT_INSTANCE);
      }
      
      public Builder clearNumFiniteBuckets() {
        copyOnWrite();
        ((Distribution.BucketOptions.Linear)this.instance).clearNumFiniteBuckets();
        return this;
      }
      
      public Builder clearOffset() {
        copyOnWrite();
        ((Distribution.BucketOptions.Linear)this.instance).clearOffset();
        return this;
      }
      
      public Builder clearWidth() {
        copyOnWrite();
        ((Distribution.BucketOptions.Linear)this.instance).clearWidth();
        return this;
      }
      
      public int getNumFiniteBuckets() {
        return ((Distribution.BucketOptions.Linear)this.instance).getNumFiniteBuckets();
      }
      
      public double getOffset() {
        return ((Distribution.BucketOptions.Linear)this.instance).getOffset();
      }
      
      public double getWidth() {
        return ((Distribution.BucketOptions.Linear)this.instance).getWidth();
      }
      
      public Builder setNumFiniteBuckets(int param2Int) {
        copyOnWrite();
        ((Distribution.BucketOptions.Linear)this.instance).setNumFiniteBuckets(param2Int);
        return this;
      }
      
      public Builder setOffset(double param2Double) {
        copyOnWrite();
        ((Distribution.BucketOptions.Linear)this.instance).setOffset(param2Double);
        return this;
      }
      
      public Builder setWidth(double param2Double) {
        copyOnWrite();
        ((Distribution.BucketOptions.Linear)this.instance).setWidth(param2Double);
        return this;
      }
    }
    
    public static interface LinearOrBuilder extends MessageLiteOrBuilder {
      int getNumFiniteBuckets();
      
      double getOffset();
      
      double getWidth();
    }
    
    public enum OptionsCase implements Internal.EnumLite {
      EXPLICIT_BUCKETS,
      EXPONENTIAL_BUCKETS,
      LINEAR_BUCKETS(1),
      OPTIONS_NOT_SET(1);
      
      private final int value;
      
      static {
        $VALUES = new OptionsCase[] { LINEAR_BUCKETS, EXPONENTIAL_BUCKETS, EXPLICIT_BUCKETS, OPTIONS_NOT_SET };
      }
      
      OptionsCase(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static OptionsCase forNumber(int param2Int) {
        switch (param2Int) {
          default:
            return null;
          case 3:
            return EXPLICIT_BUCKETS;
          case 2:
            return EXPONENTIAL_BUCKETS;
          case 1:
            return LINEAR_BUCKETS;
          case 0:
            break;
        } 
        return OPTIONS_NOT_SET;
      }
      
      public int getNumber() {
        return this.value;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<BucketOptions, BucketOptions.Builder> implements BucketOptionsOrBuilder {
    private Builder() {
      super(Distribution.BucketOptions.DEFAULT_INSTANCE);
    }
    
    public Builder clearExplicitBuckets() {
      copyOnWrite();
      ((Distribution.BucketOptions)this.instance).clearExplicitBuckets();
      return this;
    }
    
    public Builder clearExponentialBuckets() {
      copyOnWrite();
      ((Distribution.BucketOptions)this.instance).clearExponentialBuckets();
      return this;
    }
    
    public Builder clearLinearBuckets() {
      copyOnWrite();
      ((Distribution.BucketOptions)this.instance).clearLinearBuckets();
      return this;
    }
    
    public Builder clearOptions() {
      copyOnWrite();
      ((Distribution.BucketOptions)this.instance).clearOptions();
      return this;
    }
    
    public Distribution.BucketOptions.Explicit getExplicitBuckets() {
      return ((Distribution.BucketOptions)this.instance).getExplicitBuckets();
    }
    
    public Distribution.BucketOptions.Exponential getExponentialBuckets() {
      return ((Distribution.BucketOptions)this.instance).getExponentialBuckets();
    }
    
    public Distribution.BucketOptions.Linear getLinearBuckets() {
      return ((Distribution.BucketOptions)this.instance).getLinearBuckets();
    }
    
    public Distribution.BucketOptions.OptionsCase getOptionsCase() {
      return ((Distribution.BucketOptions)this.instance).getOptionsCase();
    }
    
    public Builder mergeExplicitBuckets(Distribution.BucketOptions.Explicit param1Explicit) {
      copyOnWrite();
      ((Distribution.BucketOptions)this.instance).mergeExplicitBuckets(param1Explicit);
      return this;
    }
    
    public Builder mergeExponentialBuckets(Distribution.BucketOptions.Exponential param1Exponential) {
      copyOnWrite();
      ((Distribution.BucketOptions)this.instance).mergeExponentialBuckets(param1Exponential);
      return this;
    }
    
    public Builder mergeLinearBuckets(Distribution.BucketOptions.Linear param1Linear) {
      copyOnWrite();
      ((Distribution.BucketOptions)this.instance).mergeLinearBuckets(param1Linear);
      return this;
    }
    
    public Builder setExplicitBuckets(Distribution.BucketOptions.Explicit.Builder param1Builder) {
      copyOnWrite();
      ((Distribution.BucketOptions)this.instance).setExplicitBuckets(param1Builder);
      return this;
    }
    
    public Builder setExplicitBuckets(Distribution.BucketOptions.Explicit param1Explicit) {
      copyOnWrite();
      ((Distribution.BucketOptions)this.instance).setExplicitBuckets(param1Explicit);
      return this;
    }
    
    public Builder setExponentialBuckets(Distribution.BucketOptions.Exponential.Builder param1Builder) {
      copyOnWrite();
      ((Distribution.BucketOptions)this.instance).setExponentialBuckets(param1Builder);
      return this;
    }
    
    public Builder setExponentialBuckets(Distribution.BucketOptions.Exponential param1Exponential) {
      copyOnWrite();
      ((Distribution.BucketOptions)this.instance).setExponentialBuckets(param1Exponential);
      return this;
    }
    
    public Builder setLinearBuckets(Distribution.BucketOptions.Linear.Builder param1Builder) {
      copyOnWrite();
      ((Distribution.BucketOptions)this.instance).setLinearBuckets(param1Builder);
      return this;
    }
    
    public Builder setLinearBuckets(Distribution.BucketOptions.Linear param1Linear) {
      copyOnWrite();
      ((Distribution.BucketOptions)this.instance).setLinearBuckets(param1Linear);
      return this;
    }
  }
  
  public static final class Explicit extends GeneratedMessageLite<BucketOptions.Explicit, BucketOptions.Explicit.Builder> implements BucketOptions.ExplicitOrBuilder {
    public static final int BOUNDS_FIELD_NUMBER = 1;
    
    private static final Explicit DEFAULT_INSTANCE = new Explicit();
    
    private static volatile Parser<Explicit> PARSER;
    
    private Internal.DoubleList bounds_ = emptyDoubleList();
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllBounds(Iterable<? extends Double> param1Iterable) {
      ensureBoundsIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.bounds_);
    }
    
    private void addBounds(double param1Double) {
      ensureBoundsIsMutable();
      this.bounds_.addDouble(param1Double);
    }
    
    private void clearBounds() {
      this.bounds_ = emptyDoubleList();
    }
    
    private void ensureBoundsIsMutable() {
      if (!this.bounds_.isModifiable())
        this.bounds_ = GeneratedMessageLite.mutableCopy(this.bounds_); 
    }
    
    public static Explicit getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Explicit param1Explicit) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1Explicit);
    }
    
    public static Explicit parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Explicit)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Explicit parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Explicit)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Explicit parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Explicit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static Explicit parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Explicit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Explicit parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Explicit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static Explicit parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Explicit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Explicit parseFrom(InputStream param1InputStream) throws IOException {
      return (Explicit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Explicit parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Explicit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Explicit parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Explicit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static Explicit parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Explicit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Explicit> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setBounds(int param1Int, double param1Double) {
      ensureBoundsIsMutable();
      this.bounds_.setDouble(param1Int, param1Double);
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/api/Distribution$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 433, 2 -> 429, 3 -> 418, 4 -> 409, 5 -> 375, 6 -> 110, 7 -> 371, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/api/Distribution$BucketOptions$Explicit.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/api/Distribution$BucketOptions$Explicit
      //   72: monitorenter
      //   73: getstatic com/google/api/Distribution$BucketOptions$Explicit.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/api/Distribution$BucketOptions$Explicit.DEFAULT_INSTANCE : Lcom/google/api/Distribution$BucketOptions$Explicit;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/api/Distribution$BucketOptions$Explicit.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/api/Distribution$BucketOptions$Explicit
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/api/Distribution$BucketOptions$Explicit
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/api/Distribution$BucketOptions$Explicit.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 371
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 315
      //   139: iload #5
      //   141: tableswitch default -> 164, 9 -> 276, 10 -> 179
      //   164: aload_1
      //   165: iload #5
      //   167: invokevirtual skipField : (I)Z
      //   170: ifne -> 123
      //   173: iconst_1
      //   174: istore #4
      //   176: goto -> 123
      //   179: aload_1
      //   180: invokevirtual readRawVarint32 : ()I
      //   183: istore #6
      //   185: aload_1
      //   186: iload #6
      //   188: invokevirtual pushLimit : (I)I
      //   191: istore #5
      //   193: aload_0
      //   194: getfield bounds_ : Lcom/google/protobuf/Internal$DoubleList;
      //   197: invokeinterface isModifiable : ()Z
      //   202: ifne -> 244
      //   205: aload_1
      //   206: invokevirtual getBytesUntilLimit : ()I
      //   209: ifle -> 244
      //   212: aload_0
      //   213: getfield bounds_ : Lcom/google/protobuf/Internal$DoubleList;
      //   216: invokeinterface size : ()I
      //   221: istore #7
      //   223: aload_0
      //   224: aload_0
      //   225: getfield bounds_ : Lcom/google/protobuf/Internal$DoubleList;
      //   228: iload #7
      //   230: iload #6
      //   232: bipush #8
      //   234: idiv
      //   235: iadd
      //   236: invokeinterface mutableCopyWithCapacity : (I)Lcom/google/protobuf/Internal$DoubleList;
      //   241: putfield bounds_ : Lcom/google/protobuf/Internal$DoubleList;
      //   244: aload_1
      //   245: invokevirtual getBytesUntilLimit : ()I
      //   248: ifle -> 267
      //   251: aload_0
      //   252: getfield bounds_ : Lcom/google/protobuf/Internal$DoubleList;
      //   255: aload_1
      //   256: invokevirtual readDouble : ()D
      //   259: invokeinterface addDouble : (D)V
      //   264: goto -> 244
      //   267: aload_1
      //   268: iload #5
      //   270: invokevirtual popLimit : (I)V
      //   273: goto -> 123
      //   276: aload_0
      //   277: getfield bounds_ : Lcom/google/protobuf/Internal$DoubleList;
      //   280: invokeinterface isModifiable : ()Z
      //   285: ifne -> 299
      //   288: aload_0
      //   289: aload_0
      //   290: getfield bounds_ : Lcom/google/protobuf/Internal$DoubleList;
      //   293: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$DoubleList;)Lcom/google/protobuf/Internal$DoubleList;
      //   296: putfield bounds_ : Lcom/google/protobuf/Internal$DoubleList;
      //   299: aload_0
      //   300: getfield bounds_ : Lcom/google/protobuf/Internal$DoubleList;
      //   303: aload_1
      //   304: invokevirtual readDouble : ()D
      //   307: invokeinterface addDouble : (D)V
      //   312: goto -> 123
      //   315: iconst_1
      //   316: istore #4
      //   318: goto -> 123
      //   321: astore_1
      //   322: goto -> 369
      //   325: astore_2
      //   326: new java/lang/RuntimeException
      //   329: astore_3
      //   330: new com/google/protobuf/InvalidProtocolBufferException
      //   333: astore_1
      //   334: aload_1
      //   335: aload_2
      //   336: invokevirtual getMessage : ()Ljava/lang/String;
      //   339: invokespecial <init> : (Ljava/lang/String;)V
      //   342: aload_3
      //   343: aload_1
      //   344: aload_0
      //   345: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   348: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   351: aload_3
      //   352: athrow
      //   353: astore_2
      //   354: new java/lang/RuntimeException
      //   357: astore_1
      //   358: aload_1
      //   359: aload_2
      //   360: aload_0
      //   361: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   364: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   367: aload_1
      //   368: athrow
      //   369: aload_1
      //   370: athrow
      //   371: getstatic com/google/api/Distribution$BucketOptions$Explicit.DEFAULT_INSTANCE : Lcom/google/api/Distribution$BucketOptions$Explicit;
      //   374: areturn
      //   375: aload_2
      //   376: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   379: astore_1
      //   380: aload_3
      //   381: checkcast com/google/api/Distribution$BucketOptions$Explicit
      //   384: astore_2
      //   385: aload_0
      //   386: aload_1
      //   387: aload_0
      //   388: getfield bounds_ : Lcom/google/protobuf/Internal$DoubleList;
      //   391: aload_2
      //   392: getfield bounds_ : Lcom/google/protobuf/Internal$DoubleList;
      //   395: invokeinterface visitDoubleList : (Lcom/google/protobuf/Internal$DoubleList;Lcom/google/protobuf/Internal$DoubleList;)Lcom/google/protobuf/Internal$DoubleList;
      //   400: putfield bounds_ : Lcom/google/protobuf/Internal$DoubleList;
      //   403: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   406: astore_1
      //   407: aload_0
      //   408: areturn
      //   409: new com/google/api/Distribution$BucketOptions$Explicit$Builder
      //   412: dup
      //   413: aconst_null
      //   414: invokespecial <init> : (Lcom/google/api/Distribution$1;)V
      //   417: areturn
      //   418: aload_0
      //   419: getfield bounds_ : Lcom/google/protobuf/Internal$DoubleList;
      //   422: invokeinterface makeImmutable : ()V
      //   427: aconst_null
      //   428: areturn
      //   429: getstatic com/google/api/Distribution$BucketOptions$Explicit.DEFAULT_INSTANCE : Lcom/google/api/Distribution$BucketOptions$Explicit;
      //   432: areturn
      //   433: new com/google/api/Distribution$BucketOptions$Explicit
      //   436: dup
      //   437: invokespecial <init> : ()V
      //   440: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	353	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	325	java/io/IOException
      //   128	134	321	finally
      //   164	173	353	com/google/protobuf/InvalidProtocolBufferException
      //   164	173	325	java/io/IOException
      //   164	173	321	finally
      //   179	244	353	com/google/protobuf/InvalidProtocolBufferException
      //   179	244	325	java/io/IOException
      //   179	244	321	finally
      //   244	264	353	com/google/protobuf/InvalidProtocolBufferException
      //   244	264	325	java/io/IOException
      //   244	264	321	finally
      //   267	273	353	com/google/protobuf/InvalidProtocolBufferException
      //   267	273	325	java/io/IOException
      //   267	273	321	finally
      //   276	299	353	com/google/protobuf/InvalidProtocolBufferException
      //   276	299	325	java/io/IOException
      //   276	299	321	finally
      //   299	312	353	com/google/protobuf/InvalidProtocolBufferException
      //   299	312	325	java/io/IOException
      //   299	312	321	finally
      //   326	353	321	finally
      //   354	369	321	finally
    }
    
    public double getBounds(int param1Int) {
      return this.bounds_.getDouble(param1Int);
    }
    
    public int getBoundsCount() {
      return this.bounds_.size();
    }
    
    public List<Double> getBoundsList() {
      return (List<Double>)this.bounds_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = getBoundsList().size() * 8 + 0 + getBoundsList().size() * 1;
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      getSerializedSize();
      for (byte b = 0; b < this.bounds_.size(); b++)
        param1CodedOutputStream.writeDouble(1, this.bounds_.getDouble(b)); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Explicit, Builder> implements Distribution.BucketOptions.ExplicitOrBuilder {
      private Builder() {
        super(Distribution.BucketOptions.Explicit.DEFAULT_INSTANCE);
      }
      
      public Builder addAllBounds(Iterable<? extends Double> param3Iterable) {
        copyOnWrite();
        ((Distribution.BucketOptions.Explicit)this.instance).addAllBounds(param3Iterable);
        return this;
      }
      
      public Builder addBounds(double param3Double) {
        copyOnWrite();
        ((Distribution.BucketOptions.Explicit)this.instance).addBounds(param3Double);
        return this;
      }
      
      public Builder clearBounds() {
        copyOnWrite();
        ((Distribution.BucketOptions.Explicit)this.instance).clearBounds();
        return this;
      }
      
      public double getBounds(int param3Int) {
        return ((Distribution.BucketOptions.Explicit)this.instance).getBounds(param3Int);
      }
      
      public int getBoundsCount() {
        return ((Distribution.BucketOptions.Explicit)this.instance).getBoundsCount();
      }
      
      public List<Double> getBoundsList() {
        return Collections.unmodifiableList(((Distribution.BucketOptions.Explicit)this.instance).getBoundsList());
      }
      
      public Builder setBounds(int param3Int, double param3Double) {
        copyOnWrite();
        ((Distribution.BucketOptions.Explicit)this.instance).setBounds(param3Int, param3Double);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<BucketOptions.Explicit, BucketOptions.Explicit.Builder> implements BucketOptions.ExplicitOrBuilder {
    private Builder() {
      super(Distribution.BucketOptions.Explicit.DEFAULT_INSTANCE);
    }
    
    public Builder addAllBounds(Iterable<? extends Double> param1Iterable) {
      copyOnWrite();
      ((Distribution.BucketOptions.Explicit)this.instance).addAllBounds(param1Iterable);
      return this;
    }
    
    public Builder addBounds(double param1Double) {
      copyOnWrite();
      ((Distribution.BucketOptions.Explicit)this.instance).addBounds(param1Double);
      return this;
    }
    
    public Builder clearBounds() {
      copyOnWrite();
      ((Distribution.BucketOptions.Explicit)this.instance).clearBounds();
      return this;
    }
    
    public double getBounds(int param1Int) {
      return ((Distribution.BucketOptions.Explicit)this.instance).getBounds(param1Int);
    }
    
    public int getBoundsCount() {
      return ((Distribution.BucketOptions.Explicit)this.instance).getBoundsCount();
    }
    
    public List<Double> getBoundsList() {
      return Collections.unmodifiableList(((Distribution.BucketOptions.Explicit)this.instance).getBoundsList());
    }
    
    public Builder setBounds(int param1Int, double param1Double) {
      copyOnWrite();
      ((Distribution.BucketOptions.Explicit)this.instance).setBounds(param1Int, param1Double);
      return this;
    }
  }
  
  public static interface ExplicitOrBuilder extends MessageLiteOrBuilder {
    double getBounds(int param1Int);
    
    int getBoundsCount();
    
    List<Double> getBoundsList();
  }
  
  public static final class Exponential extends GeneratedMessageLite<BucketOptions.Exponential, BucketOptions.Exponential.Builder> implements BucketOptions.ExponentialOrBuilder {
    private static final Exponential DEFAULT_INSTANCE = new Exponential();
    
    public static final int GROWTH_FACTOR_FIELD_NUMBER = 2;
    
    public static final int NUM_FINITE_BUCKETS_FIELD_NUMBER = 1;
    
    private static volatile Parser<Exponential> PARSER;
    
    public static final int SCALE_FIELD_NUMBER = 3;
    
    private double growthFactor_;
    
    private int numFiniteBuckets_;
    
    private double scale_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearGrowthFactor() {
      this.growthFactor_ = 0.0D;
    }
    
    private void clearNumFiniteBuckets() {
      this.numFiniteBuckets_ = 0;
    }
    
    private void clearScale() {
      this.scale_ = 0.0D;
    }
    
    public static Exponential getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Exponential param1Exponential) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1Exponential);
    }
    
    public static Exponential parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Exponential)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Exponential parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Exponential)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Exponential parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Exponential)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static Exponential parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Exponential)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Exponential parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Exponential)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static Exponential parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Exponential)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Exponential parseFrom(InputStream param1InputStream) throws IOException {
      return (Exponential)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Exponential parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Exponential)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Exponential parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Exponential)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static Exponential parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Exponential)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Exponential> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setGrowthFactor(double param1Double) {
      this.growthFactor_ = param1Double;
    }
    
    private void setNumFiniteBuckets(int param1Int) {
      this.numFiniteBuckets_ = param1Int;
    }
    
    private void setScale(double param1Double) {
      this.scale_ = param1Double;
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/api/Distribution$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: istore #4
      //   10: iconst_0
      //   11: istore #5
      //   13: iload #4
      //   15: tableswitch default -> 60, 1 -> 482, 2 -> 478, 3 -> 476, 4 -> 467, 5 -> 269, 6 -> 114, 7 -> 265, 8 -> 68
      //   60: new java/lang/UnsupportedOperationException
      //   63: dup
      //   64: invokespecial <init> : ()V
      //   67: athrow
      //   68: getstatic com/google/api/Distribution$BucketOptions$Exponential.PARSER : Lcom/google/protobuf/Parser;
      //   71: ifnonnull -> 110
      //   74: ldc com/google/api/Distribution$BucketOptions$Exponential
      //   76: monitorenter
      //   77: getstatic com/google/api/Distribution$BucketOptions$Exponential.PARSER : Lcom/google/protobuf/Parser;
      //   80: ifnonnull -> 98
      //   83: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   86: astore_1
      //   87: aload_1
      //   88: getstatic com/google/api/Distribution$BucketOptions$Exponential.DEFAULT_INSTANCE : Lcom/google/api/Distribution$BucketOptions$Exponential;
      //   91: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   94: aload_1
      //   95: putstatic com/google/api/Distribution$BucketOptions$Exponential.PARSER : Lcom/google/protobuf/Parser;
      //   98: ldc com/google/api/Distribution$BucketOptions$Exponential
      //   100: monitorexit
      //   101: goto -> 110
      //   104: astore_1
      //   105: ldc com/google/api/Distribution$BucketOptions$Exponential
      //   107: monitorexit
      //   108: aload_1
      //   109: athrow
      //   110: getstatic com/google/api/Distribution$BucketOptions$Exponential.PARSER : Lcom/google/protobuf/Parser;
      //   113: areturn
      //   114: aload_2
      //   115: checkcast com/google/protobuf/CodedInputStream
      //   118: astore_1
      //   119: aload_3
      //   120: checkcast com/google/protobuf/ExtensionRegistryLite
      //   123: astore_2
      //   124: iload #5
      //   126: ifne -> 265
      //   129: aload_1
      //   130: invokevirtual readTag : ()I
      //   133: istore #4
      //   135: iload #4
      //   137: ifeq -> 209
      //   140: iload #4
      //   142: bipush #8
      //   144: if_icmpeq -> 198
      //   147: iload #4
      //   149: bipush #17
      //   151: if_icmpeq -> 187
      //   154: iload #4
      //   156: bipush #25
      //   158: if_icmpeq -> 176
      //   161: aload_1
      //   162: iload #4
      //   164: invokevirtual skipField : (I)Z
      //   167: ifne -> 124
      //   170: iconst_1
      //   171: istore #5
      //   173: goto -> 124
      //   176: aload_0
      //   177: aload_1
      //   178: invokevirtual readDouble : ()D
      //   181: putfield scale_ : D
      //   184: goto -> 124
      //   187: aload_0
      //   188: aload_1
      //   189: invokevirtual readDouble : ()D
      //   192: putfield growthFactor_ : D
      //   195: goto -> 124
      //   198: aload_0
      //   199: aload_1
      //   200: invokevirtual readInt32 : ()I
      //   203: putfield numFiniteBuckets_ : I
      //   206: goto -> 124
      //   209: iconst_1
      //   210: istore #5
      //   212: goto -> 124
      //   215: astore_1
      //   216: goto -> 263
      //   219: astore_1
      //   220: new java/lang/RuntimeException
      //   223: astore_3
      //   224: new com/google/protobuf/InvalidProtocolBufferException
      //   227: astore_2
      //   228: aload_2
      //   229: aload_1
      //   230: invokevirtual getMessage : ()Ljava/lang/String;
      //   233: invokespecial <init> : (Ljava/lang/String;)V
      //   236: aload_3
      //   237: aload_2
      //   238: aload_0
      //   239: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   242: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   245: aload_3
      //   246: athrow
      //   247: astore_1
      //   248: new java/lang/RuntimeException
      //   251: astore_2
      //   252: aload_2
      //   253: aload_1
      //   254: aload_0
      //   255: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   258: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   261: aload_2
      //   262: athrow
      //   263: aload_1
      //   264: athrow
      //   265: getstatic com/google/api/Distribution$BucketOptions$Exponential.DEFAULT_INSTANCE : Lcom/google/api/Distribution$BucketOptions$Exponential;
      //   268: areturn
      //   269: aload_2
      //   270: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   273: astore_1
      //   274: aload_3
      //   275: checkcast com/google/api/Distribution$BucketOptions$Exponential
      //   278: astore_2
      //   279: aload_0
      //   280: getfield numFiniteBuckets_ : I
      //   283: ifeq -> 292
      //   286: iconst_1
      //   287: istore #6
      //   289: goto -> 295
      //   292: iconst_0
      //   293: istore #6
      //   295: aload_0
      //   296: getfield numFiniteBuckets_ : I
      //   299: istore #5
      //   301: aload_2
      //   302: getfield numFiniteBuckets_ : I
      //   305: ifeq -> 314
      //   308: iconst_1
      //   309: istore #7
      //   311: goto -> 317
      //   314: iconst_0
      //   315: istore #7
      //   317: aload_0
      //   318: aload_1
      //   319: iload #6
      //   321: iload #5
      //   323: iload #7
      //   325: aload_2
      //   326: getfield numFiniteBuckets_ : I
      //   329: invokeinterface visitInt : (ZIZI)I
      //   334: putfield numFiniteBuckets_ : I
      //   337: aload_0
      //   338: getfield growthFactor_ : D
      //   341: dconst_0
      //   342: dcmpl
      //   343: ifeq -> 352
      //   346: iconst_1
      //   347: istore #6
      //   349: goto -> 355
      //   352: iconst_0
      //   353: istore #6
      //   355: aload_0
      //   356: getfield growthFactor_ : D
      //   359: dstore #8
      //   361: aload_2
      //   362: getfield growthFactor_ : D
      //   365: dconst_0
      //   366: dcmpl
      //   367: ifeq -> 376
      //   370: iconst_1
      //   371: istore #7
      //   373: goto -> 379
      //   376: iconst_0
      //   377: istore #7
      //   379: aload_0
      //   380: aload_1
      //   381: iload #6
      //   383: dload #8
      //   385: iload #7
      //   387: aload_2
      //   388: getfield growthFactor_ : D
      //   391: invokeinterface visitDouble : (ZDZD)D
      //   396: putfield growthFactor_ : D
      //   399: aload_0
      //   400: getfield scale_ : D
      //   403: dconst_0
      //   404: dcmpl
      //   405: ifeq -> 414
      //   408: iconst_1
      //   409: istore #6
      //   411: goto -> 417
      //   414: iconst_0
      //   415: istore #6
      //   417: aload_0
      //   418: getfield scale_ : D
      //   421: dstore #8
      //   423: aload_2
      //   424: getfield scale_ : D
      //   427: dconst_0
      //   428: dcmpl
      //   429: ifeq -> 438
      //   432: iconst_1
      //   433: istore #7
      //   435: goto -> 441
      //   438: iconst_0
      //   439: istore #7
      //   441: aload_0
      //   442: aload_1
      //   443: iload #6
      //   445: dload #8
      //   447: iload #7
      //   449: aload_2
      //   450: getfield scale_ : D
      //   453: invokeinterface visitDouble : (ZDZD)D
      //   458: putfield scale_ : D
      //   461: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   464: astore_1
      //   465: aload_0
      //   466: areturn
      //   467: new com/google/api/Distribution$BucketOptions$Exponential$Builder
      //   470: dup
      //   471: aconst_null
      //   472: invokespecial <init> : (Lcom/google/api/Distribution$1;)V
      //   475: areturn
      //   476: aconst_null
      //   477: areturn
      //   478: getstatic com/google/api/Distribution$BucketOptions$Exponential.DEFAULT_INSTANCE : Lcom/google/api/Distribution$BucketOptions$Exponential;
      //   481: areturn
      //   482: new com/google/api/Distribution$BucketOptions$Exponential
      //   485: dup
      //   486: invokespecial <init> : ()V
      //   489: areturn
      // Exception table:
      //   from	to	target	type
      //   77	98	104	finally
      //   98	101	104	finally
      //   105	108	104	finally
      //   129	135	247	com/google/protobuf/InvalidProtocolBufferException
      //   129	135	219	java/io/IOException
      //   129	135	215	finally
      //   161	170	247	com/google/protobuf/InvalidProtocolBufferException
      //   161	170	219	java/io/IOException
      //   161	170	215	finally
      //   176	184	247	com/google/protobuf/InvalidProtocolBufferException
      //   176	184	219	java/io/IOException
      //   176	184	215	finally
      //   187	195	247	com/google/protobuf/InvalidProtocolBufferException
      //   187	195	219	java/io/IOException
      //   187	195	215	finally
      //   198	206	247	com/google/protobuf/InvalidProtocolBufferException
      //   198	206	219	java/io/IOException
      //   198	206	215	finally
      //   220	247	215	finally
      //   248	263	215	finally
    }
    
    public double getGrowthFactor() {
      return this.growthFactor_;
    }
    
    public int getNumFiniteBuckets() {
      return this.numFiniteBuckets_;
    }
    
    public double getScale() {
      return this.scale_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      int j = 0;
      i = this.numFiniteBuckets_;
      if (i != 0)
        j = 0 + CodedOutputStream.computeInt32Size(1, i); 
      double d = this.growthFactor_;
      i = j;
      if (d != 0.0D)
        i = j + CodedOutputStream.computeDoubleSize(2, d); 
      d = this.scale_;
      j = i;
      if (d != 0.0D)
        j = i + CodedOutputStream.computeDoubleSize(3, d); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      int i = this.numFiniteBuckets_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(1, i); 
      double d = this.growthFactor_;
      if (d != 0.0D)
        param1CodedOutputStream.writeDouble(2, d); 
      d = this.scale_;
      if (d != 0.0D)
        param1CodedOutputStream.writeDouble(3, d); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Exponential, Builder> implements Distribution.BucketOptions.ExponentialOrBuilder {
      private Builder() {
        super(Distribution.BucketOptions.Exponential.DEFAULT_INSTANCE);
      }
      
      public Builder clearGrowthFactor() {
        copyOnWrite();
        ((Distribution.BucketOptions.Exponential)this.instance).clearGrowthFactor();
        return this;
      }
      
      public Builder clearNumFiniteBuckets() {
        copyOnWrite();
        ((Distribution.BucketOptions.Exponential)this.instance).clearNumFiniteBuckets();
        return this;
      }
      
      public Builder clearScale() {
        copyOnWrite();
        ((Distribution.BucketOptions.Exponential)this.instance).clearScale();
        return this;
      }
      
      public double getGrowthFactor() {
        return ((Distribution.BucketOptions.Exponential)this.instance).getGrowthFactor();
      }
      
      public int getNumFiniteBuckets() {
        return ((Distribution.BucketOptions.Exponential)this.instance).getNumFiniteBuckets();
      }
      
      public double getScale() {
        return ((Distribution.BucketOptions.Exponential)this.instance).getScale();
      }
      
      public Builder setGrowthFactor(double param3Double) {
        copyOnWrite();
        ((Distribution.BucketOptions.Exponential)this.instance).setGrowthFactor(param3Double);
        return this;
      }
      
      public Builder setNumFiniteBuckets(int param3Int) {
        copyOnWrite();
        ((Distribution.BucketOptions.Exponential)this.instance).setNumFiniteBuckets(param3Int);
        return this;
      }
      
      public Builder setScale(double param3Double) {
        copyOnWrite();
        ((Distribution.BucketOptions.Exponential)this.instance).setScale(param3Double);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<BucketOptions.Exponential, BucketOptions.Exponential.Builder> implements BucketOptions.ExponentialOrBuilder {
    private Builder() {
      super(Distribution.BucketOptions.Exponential.DEFAULT_INSTANCE);
    }
    
    public Builder clearGrowthFactor() {
      copyOnWrite();
      ((Distribution.BucketOptions.Exponential)this.instance).clearGrowthFactor();
      return this;
    }
    
    public Builder clearNumFiniteBuckets() {
      copyOnWrite();
      ((Distribution.BucketOptions.Exponential)this.instance).clearNumFiniteBuckets();
      return this;
    }
    
    public Builder clearScale() {
      copyOnWrite();
      ((Distribution.BucketOptions.Exponential)this.instance).clearScale();
      return this;
    }
    
    public double getGrowthFactor() {
      return ((Distribution.BucketOptions.Exponential)this.instance).getGrowthFactor();
    }
    
    public int getNumFiniteBuckets() {
      return ((Distribution.BucketOptions.Exponential)this.instance).getNumFiniteBuckets();
    }
    
    public double getScale() {
      return ((Distribution.BucketOptions.Exponential)this.instance).getScale();
    }
    
    public Builder setGrowthFactor(double param1Double) {
      copyOnWrite();
      ((Distribution.BucketOptions.Exponential)this.instance).setGrowthFactor(param1Double);
      return this;
    }
    
    public Builder setNumFiniteBuckets(int param1Int) {
      copyOnWrite();
      ((Distribution.BucketOptions.Exponential)this.instance).setNumFiniteBuckets(param1Int);
      return this;
    }
    
    public Builder setScale(double param1Double) {
      copyOnWrite();
      ((Distribution.BucketOptions.Exponential)this.instance).setScale(param1Double);
      return this;
    }
  }
  
  public static interface ExponentialOrBuilder extends MessageLiteOrBuilder {
    double getGrowthFactor();
    
    int getNumFiniteBuckets();
    
    double getScale();
  }
  
  public static final class Linear extends GeneratedMessageLite<BucketOptions.Linear, BucketOptions.Linear.Builder> implements BucketOptions.LinearOrBuilder {
    private static final Linear DEFAULT_INSTANCE = new Linear();
    
    public static final int NUM_FINITE_BUCKETS_FIELD_NUMBER = 1;
    
    public static final int OFFSET_FIELD_NUMBER = 3;
    
    private static volatile Parser<Linear> PARSER;
    
    public static final int WIDTH_FIELD_NUMBER = 2;
    
    private int numFiniteBuckets_;
    
    private double offset_;
    
    private double width_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearNumFiniteBuckets() {
      this.numFiniteBuckets_ = 0;
    }
    
    private void clearOffset() {
      this.offset_ = 0.0D;
    }
    
    private void clearWidth() {
      this.width_ = 0.0D;
    }
    
    public static Linear getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Linear param1Linear) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1Linear);
    }
    
    public static Linear parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Linear)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Linear parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Linear)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Linear parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Linear)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static Linear parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Linear)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Linear parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Linear)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static Linear parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Linear)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Linear parseFrom(InputStream param1InputStream) throws IOException {
      return (Linear)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Linear parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Linear)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Linear parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Linear)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static Linear parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Linear)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Linear> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setNumFiniteBuckets(int param1Int) {
      this.numFiniteBuckets_ = param1Int;
    }
    
    private void setOffset(double param1Double) {
      this.offset_ = param1Double;
    }
    
    private void setWidth(double param1Double) {
      this.width_ = param1Double;
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/api/Distribution$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: istore #4
      //   10: iconst_0
      //   11: istore #5
      //   13: iload #4
      //   15: tableswitch default -> 60, 1 -> 482, 2 -> 478, 3 -> 476, 4 -> 467, 5 -> 269, 6 -> 114, 7 -> 265, 8 -> 68
      //   60: new java/lang/UnsupportedOperationException
      //   63: dup
      //   64: invokespecial <init> : ()V
      //   67: athrow
      //   68: getstatic com/google/api/Distribution$BucketOptions$Linear.PARSER : Lcom/google/protobuf/Parser;
      //   71: ifnonnull -> 110
      //   74: ldc com/google/api/Distribution$BucketOptions$Linear
      //   76: monitorenter
      //   77: getstatic com/google/api/Distribution$BucketOptions$Linear.PARSER : Lcom/google/protobuf/Parser;
      //   80: ifnonnull -> 98
      //   83: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   86: astore_1
      //   87: aload_1
      //   88: getstatic com/google/api/Distribution$BucketOptions$Linear.DEFAULT_INSTANCE : Lcom/google/api/Distribution$BucketOptions$Linear;
      //   91: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   94: aload_1
      //   95: putstatic com/google/api/Distribution$BucketOptions$Linear.PARSER : Lcom/google/protobuf/Parser;
      //   98: ldc com/google/api/Distribution$BucketOptions$Linear
      //   100: monitorexit
      //   101: goto -> 110
      //   104: astore_1
      //   105: ldc com/google/api/Distribution$BucketOptions$Linear
      //   107: monitorexit
      //   108: aload_1
      //   109: athrow
      //   110: getstatic com/google/api/Distribution$BucketOptions$Linear.PARSER : Lcom/google/protobuf/Parser;
      //   113: areturn
      //   114: aload_2
      //   115: checkcast com/google/protobuf/CodedInputStream
      //   118: astore_1
      //   119: aload_3
      //   120: checkcast com/google/protobuf/ExtensionRegistryLite
      //   123: astore_2
      //   124: iload #5
      //   126: ifne -> 265
      //   129: aload_1
      //   130: invokevirtual readTag : ()I
      //   133: istore #4
      //   135: iload #4
      //   137: ifeq -> 209
      //   140: iload #4
      //   142: bipush #8
      //   144: if_icmpeq -> 198
      //   147: iload #4
      //   149: bipush #17
      //   151: if_icmpeq -> 187
      //   154: iload #4
      //   156: bipush #25
      //   158: if_icmpeq -> 176
      //   161: aload_1
      //   162: iload #4
      //   164: invokevirtual skipField : (I)Z
      //   167: ifne -> 124
      //   170: iconst_1
      //   171: istore #5
      //   173: goto -> 124
      //   176: aload_0
      //   177: aload_1
      //   178: invokevirtual readDouble : ()D
      //   181: putfield offset_ : D
      //   184: goto -> 124
      //   187: aload_0
      //   188: aload_1
      //   189: invokevirtual readDouble : ()D
      //   192: putfield width_ : D
      //   195: goto -> 124
      //   198: aload_0
      //   199: aload_1
      //   200: invokevirtual readInt32 : ()I
      //   203: putfield numFiniteBuckets_ : I
      //   206: goto -> 124
      //   209: iconst_1
      //   210: istore #5
      //   212: goto -> 124
      //   215: astore_1
      //   216: goto -> 263
      //   219: astore_2
      //   220: new java/lang/RuntimeException
      //   223: astore_3
      //   224: new com/google/protobuf/InvalidProtocolBufferException
      //   227: astore_1
      //   228: aload_1
      //   229: aload_2
      //   230: invokevirtual getMessage : ()Ljava/lang/String;
      //   233: invokespecial <init> : (Ljava/lang/String;)V
      //   236: aload_3
      //   237: aload_1
      //   238: aload_0
      //   239: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   242: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   245: aload_3
      //   246: athrow
      //   247: astore_2
      //   248: new java/lang/RuntimeException
      //   251: astore_1
      //   252: aload_1
      //   253: aload_2
      //   254: aload_0
      //   255: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   258: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   261: aload_1
      //   262: athrow
      //   263: aload_1
      //   264: athrow
      //   265: getstatic com/google/api/Distribution$BucketOptions$Linear.DEFAULT_INSTANCE : Lcom/google/api/Distribution$BucketOptions$Linear;
      //   268: areturn
      //   269: aload_2
      //   270: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   273: astore_1
      //   274: aload_3
      //   275: checkcast com/google/api/Distribution$BucketOptions$Linear
      //   278: astore_2
      //   279: aload_0
      //   280: getfield numFiniteBuckets_ : I
      //   283: ifeq -> 292
      //   286: iconst_1
      //   287: istore #6
      //   289: goto -> 295
      //   292: iconst_0
      //   293: istore #6
      //   295: aload_0
      //   296: getfield numFiniteBuckets_ : I
      //   299: istore #5
      //   301: aload_2
      //   302: getfield numFiniteBuckets_ : I
      //   305: ifeq -> 314
      //   308: iconst_1
      //   309: istore #7
      //   311: goto -> 317
      //   314: iconst_0
      //   315: istore #7
      //   317: aload_0
      //   318: aload_1
      //   319: iload #6
      //   321: iload #5
      //   323: iload #7
      //   325: aload_2
      //   326: getfield numFiniteBuckets_ : I
      //   329: invokeinterface visitInt : (ZIZI)I
      //   334: putfield numFiniteBuckets_ : I
      //   337: aload_0
      //   338: getfield width_ : D
      //   341: dconst_0
      //   342: dcmpl
      //   343: ifeq -> 352
      //   346: iconst_1
      //   347: istore #6
      //   349: goto -> 355
      //   352: iconst_0
      //   353: istore #6
      //   355: aload_0
      //   356: getfield width_ : D
      //   359: dstore #8
      //   361: aload_2
      //   362: getfield width_ : D
      //   365: dconst_0
      //   366: dcmpl
      //   367: ifeq -> 376
      //   370: iconst_1
      //   371: istore #7
      //   373: goto -> 379
      //   376: iconst_0
      //   377: istore #7
      //   379: aload_0
      //   380: aload_1
      //   381: iload #6
      //   383: dload #8
      //   385: iload #7
      //   387: aload_2
      //   388: getfield width_ : D
      //   391: invokeinterface visitDouble : (ZDZD)D
      //   396: putfield width_ : D
      //   399: aload_0
      //   400: getfield offset_ : D
      //   403: dconst_0
      //   404: dcmpl
      //   405: ifeq -> 414
      //   408: iconst_1
      //   409: istore #6
      //   411: goto -> 417
      //   414: iconst_0
      //   415: istore #6
      //   417: aload_0
      //   418: getfield offset_ : D
      //   421: dstore #8
      //   423: aload_2
      //   424: getfield offset_ : D
      //   427: dconst_0
      //   428: dcmpl
      //   429: ifeq -> 438
      //   432: iconst_1
      //   433: istore #7
      //   435: goto -> 441
      //   438: iconst_0
      //   439: istore #7
      //   441: aload_0
      //   442: aload_1
      //   443: iload #6
      //   445: dload #8
      //   447: iload #7
      //   449: aload_2
      //   450: getfield offset_ : D
      //   453: invokeinterface visitDouble : (ZDZD)D
      //   458: putfield offset_ : D
      //   461: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   464: astore_1
      //   465: aload_0
      //   466: areturn
      //   467: new com/google/api/Distribution$BucketOptions$Linear$Builder
      //   470: dup
      //   471: aconst_null
      //   472: invokespecial <init> : (Lcom/google/api/Distribution$1;)V
      //   475: areturn
      //   476: aconst_null
      //   477: areturn
      //   478: getstatic com/google/api/Distribution$BucketOptions$Linear.DEFAULT_INSTANCE : Lcom/google/api/Distribution$BucketOptions$Linear;
      //   481: areturn
      //   482: new com/google/api/Distribution$BucketOptions$Linear
      //   485: dup
      //   486: invokespecial <init> : ()V
      //   489: areturn
      // Exception table:
      //   from	to	target	type
      //   77	98	104	finally
      //   98	101	104	finally
      //   105	108	104	finally
      //   129	135	247	com/google/protobuf/InvalidProtocolBufferException
      //   129	135	219	java/io/IOException
      //   129	135	215	finally
      //   161	170	247	com/google/protobuf/InvalidProtocolBufferException
      //   161	170	219	java/io/IOException
      //   161	170	215	finally
      //   176	184	247	com/google/protobuf/InvalidProtocolBufferException
      //   176	184	219	java/io/IOException
      //   176	184	215	finally
      //   187	195	247	com/google/protobuf/InvalidProtocolBufferException
      //   187	195	219	java/io/IOException
      //   187	195	215	finally
      //   198	206	247	com/google/protobuf/InvalidProtocolBufferException
      //   198	206	219	java/io/IOException
      //   198	206	215	finally
      //   220	247	215	finally
      //   248	263	215	finally
    }
    
    public int getNumFiniteBuckets() {
      return this.numFiniteBuckets_;
    }
    
    public double getOffset() {
      return this.offset_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      int j = this.numFiniteBuckets_;
      if (j != 0)
        i = 0 + CodedOutputStream.computeInt32Size(1, j); 
      double d = this.width_;
      j = i;
      if (d != 0.0D)
        j = i + CodedOutputStream.computeDoubleSize(2, d); 
      d = this.offset_;
      i = j;
      if (d != 0.0D)
        i = j + CodedOutputStream.computeDoubleSize(3, d); 
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public double getWidth() {
      return this.width_;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      int i = this.numFiniteBuckets_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(1, i); 
      double d = this.width_;
      if (d != 0.0D)
        param1CodedOutputStream.writeDouble(2, d); 
      d = this.offset_;
      if (d != 0.0D)
        param1CodedOutputStream.writeDouble(3, d); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Linear, Builder> implements Distribution.BucketOptions.LinearOrBuilder {
      private Builder() {
        super(Distribution.BucketOptions.Linear.DEFAULT_INSTANCE);
      }
      
      public Builder clearNumFiniteBuckets() {
        copyOnWrite();
        ((Distribution.BucketOptions.Linear)this.instance).clearNumFiniteBuckets();
        return this;
      }
      
      public Builder clearOffset() {
        copyOnWrite();
        ((Distribution.BucketOptions.Linear)this.instance).clearOffset();
        return this;
      }
      
      public Builder clearWidth() {
        copyOnWrite();
        ((Distribution.BucketOptions.Linear)this.instance).clearWidth();
        return this;
      }
      
      public int getNumFiniteBuckets() {
        return ((Distribution.BucketOptions.Linear)this.instance).getNumFiniteBuckets();
      }
      
      public double getOffset() {
        return ((Distribution.BucketOptions.Linear)this.instance).getOffset();
      }
      
      public double getWidth() {
        return ((Distribution.BucketOptions.Linear)this.instance).getWidth();
      }
      
      public Builder setNumFiniteBuckets(int param3Int) {
        copyOnWrite();
        ((Distribution.BucketOptions.Linear)this.instance).setNumFiniteBuckets(param3Int);
        return this;
      }
      
      public Builder setOffset(double param3Double) {
        copyOnWrite();
        ((Distribution.BucketOptions.Linear)this.instance).setOffset(param3Double);
        return this;
      }
      
      public Builder setWidth(double param3Double) {
        copyOnWrite();
        ((Distribution.BucketOptions.Linear)this.instance).setWidth(param3Double);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<BucketOptions.Linear, BucketOptions.Linear.Builder> implements BucketOptions.LinearOrBuilder {
    private Builder() {
      super(Distribution.BucketOptions.Linear.DEFAULT_INSTANCE);
    }
    
    public Builder clearNumFiniteBuckets() {
      copyOnWrite();
      ((Distribution.BucketOptions.Linear)this.instance).clearNumFiniteBuckets();
      return this;
    }
    
    public Builder clearOffset() {
      copyOnWrite();
      ((Distribution.BucketOptions.Linear)this.instance).clearOffset();
      return this;
    }
    
    public Builder clearWidth() {
      copyOnWrite();
      ((Distribution.BucketOptions.Linear)this.instance).clearWidth();
      return this;
    }
    
    public int getNumFiniteBuckets() {
      return ((Distribution.BucketOptions.Linear)this.instance).getNumFiniteBuckets();
    }
    
    public double getOffset() {
      return ((Distribution.BucketOptions.Linear)this.instance).getOffset();
    }
    
    public double getWidth() {
      return ((Distribution.BucketOptions.Linear)this.instance).getWidth();
    }
    
    public Builder setNumFiniteBuckets(int param1Int) {
      copyOnWrite();
      ((Distribution.BucketOptions.Linear)this.instance).setNumFiniteBuckets(param1Int);
      return this;
    }
    
    public Builder setOffset(double param1Double) {
      copyOnWrite();
      ((Distribution.BucketOptions.Linear)this.instance).setOffset(param1Double);
      return this;
    }
    
    public Builder setWidth(double param1Double) {
      copyOnWrite();
      ((Distribution.BucketOptions.Linear)this.instance).setWidth(param1Double);
      return this;
    }
  }
  
  public static interface LinearOrBuilder extends MessageLiteOrBuilder {
    int getNumFiniteBuckets();
    
    double getOffset();
    
    double getWidth();
  }
  
  public enum OptionsCase implements Internal.EnumLite {
    EXPLICIT_BUCKETS(1),
    EXPONENTIAL_BUCKETS(1),
    LINEAR_BUCKETS(1),
    OPTIONS_NOT_SET(1);
    
    private final int value;
    
    static {
      EXPLICIT_BUCKETS = new OptionsCase("EXPLICIT_BUCKETS", 2, 3);
      OPTIONS_NOT_SET = new OptionsCase("OPTIONS_NOT_SET", 3, 0);
      $VALUES = new OptionsCase[] { LINEAR_BUCKETS, EXPONENTIAL_BUCKETS, EXPLICIT_BUCKETS, OPTIONS_NOT_SET };
    }
    
    OptionsCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static OptionsCase forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 3:
          return EXPLICIT_BUCKETS;
        case 2:
          return EXPONENTIAL_BUCKETS;
        case 1:
          return LINEAR_BUCKETS;
        case 0:
          break;
      } 
      return OPTIONS_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
  
  public static interface BucketOptionsOrBuilder extends MessageLiteOrBuilder {
    Distribution.BucketOptions.Explicit getExplicitBuckets();
    
    Distribution.BucketOptions.Exponential getExponentialBuckets();
    
    Distribution.BucketOptions.Linear getLinearBuckets();
    
    Distribution.BucketOptions.OptionsCase getOptionsCase();
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Distribution, Builder> implements DistributionOrBuilder {
    private Builder() {
      super(Distribution.DEFAULT_INSTANCE);
    }
    
    public Builder addAllBucketCounts(Iterable<? extends Long> param1Iterable) {
      copyOnWrite();
      ((Distribution)this.instance).addAllBucketCounts(param1Iterable);
      return this;
    }
    
    public Builder addBucketCounts(long param1Long) {
      copyOnWrite();
      ((Distribution)this.instance).addBucketCounts(param1Long);
      return this;
    }
    
    public Builder clearBucketCounts() {
      copyOnWrite();
      ((Distribution)this.instance).clearBucketCounts();
      return this;
    }
    
    public Builder clearBucketOptions() {
      copyOnWrite();
      ((Distribution)this.instance).clearBucketOptions();
      return this;
    }
    
    public Builder clearCount() {
      copyOnWrite();
      ((Distribution)this.instance).clearCount();
      return this;
    }
    
    public Builder clearMean() {
      copyOnWrite();
      ((Distribution)this.instance).clearMean();
      return this;
    }
    
    public Builder clearRange() {
      copyOnWrite();
      ((Distribution)this.instance).clearRange();
      return this;
    }
    
    public Builder clearSumOfSquaredDeviation() {
      copyOnWrite();
      ((Distribution)this.instance).clearSumOfSquaredDeviation();
      return this;
    }
    
    public long getBucketCounts(int param1Int) {
      return ((Distribution)this.instance).getBucketCounts(param1Int);
    }
    
    public int getBucketCountsCount() {
      return ((Distribution)this.instance).getBucketCountsCount();
    }
    
    public List<Long> getBucketCountsList() {
      return Collections.unmodifiableList(((Distribution)this.instance).getBucketCountsList());
    }
    
    public Distribution.BucketOptions getBucketOptions() {
      return ((Distribution)this.instance).getBucketOptions();
    }
    
    public long getCount() {
      return ((Distribution)this.instance).getCount();
    }
    
    public double getMean() {
      return ((Distribution)this.instance).getMean();
    }
    
    public Distribution.Range getRange() {
      return ((Distribution)this.instance).getRange();
    }
    
    public double getSumOfSquaredDeviation() {
      return ((Distribution)this.instance).getSumOfSquaredDeviation();
    }
    
    public boolean hasBucketOptions() {
      return ((Distribution)this.instance).hasBucketOptions();
    }
    
    public boolean hasRange() {
      return ((Distribution)this.instance).hasRange();
    }
    
    public Builder mergeBucketOptions(Distribution.BucketOptions param1BucketOptions) {
      copyOnWrite();
      ((Distribution)this.instance).mergeBucketOptions(param1BucketOptions);
      return this;
    }
    
    public Builder mergeRange(Distribution.Range param1Range) {
      copyOnWrite();
      ((Distribution)this.instance).mergeRange(param1Range);
      return this;
    }
    
    public Builder setBucketCounts(int param1Int, long param1Long) {
      copyOnWrite();
      ((Distribution)this.instance).setBucketCounts(param1Int, param1Long);
      return this;
    }
    
    public Builder setBucketOptions(Distribution.BucketOptions.Builder param1Builder) {
      copyOnWrite();
      ((Distribution)this.instance).setBucketOptions(param1Builder);
      return this;
    }
    
    public Builder setBucketOptions(Distribution.BucketOptions param1BucketOptions) {
      copyOnWrite();
      ((Distribution)this.instance).setBucketOptions(param1BucketOptions);
      return this;
    }
    
    public Builder setCount(long param1Long) {
      copyOnWrite();
      ((Distribution)this.instance).setCount(param1Long);
      return this;
    }
    
    public Builder setMean(double param1Double) {
      copyOnWrite();
      ((Distribution)this.instance).setMean(param1Double);
      return this;
    }
    
    public Builder setRange(Distribution.Range.Builder param1Builder) {
      copyOnWrite();
      ((Distribution)this.instance).setRange(param1Builder);
      return this;
    }
    
    public Builder setRange(Distribution.Range param1Range) {
      copyOnWrite();
      ((Distribution)this.instance).setRange(param1Range);
      return this;
    }
    
    public Builder setSumOfSquaredDeviation(double param1Double) {
      copyOnWrite();
      ((Distribution)this.instance).setSumOfSquaredDeviation(param1Double);
      return this;
    }
  }
  
  public static final class Range extends GeneratedMessageLite<Range, Range.Builder> implements RangeOrBuilder {
    private static final Range DEFAULT_INSTANCE = new Range();
    
    public static final int MAX_FIELD_NUMBER = 2;
    
    public static final int MIN_FIELD_NUMBER = 1;
    
    private static volatile Parser<Range> PARSER;
    
    private double max_;
    
    private double min_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearMax() {
      this.max_ = 0.0D;
    }
    
    private void clearMin() {
      this.min_ = 0.0D;
    }
    
    public static Range getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Range param1Range) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1Range);
    }
    
    public static Range parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Range)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Range parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Range)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Range parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Range)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static Range parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Range)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Range parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Range)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static Range parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Range)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Range parseFrom(InputStream param1InputStream) throws IOException {
      return (Range)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Range parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Range)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Range parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Range)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static Range parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Range)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Range> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setMax(double param1Double) {
      this.max_ = param1Double;
    }
    
    private void setMin(double param1Double) {
      this.min_ = param1Double;
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/api/Distribution$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
      //   68: getstatic com/google/api/Distribution$Range.PARSER : Lcom/google/protobuf/Parser;
      //   71: ifnonnull -> 110
      //   74: ldc com/google/api/Distribution$Range
      //   76: monitorenter
      //   77: getstatic com/google/api/Distribution$Range.PARSER : Lcom/google/protobuf/Parser;
      //   80: ifnonnull -> 98
      //   83: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   86: astore_1
      //   87: aload_1
      //   88: getstatic com/google/api/Distribution$Range.DEFAULT_INSTANCE : Lcom/google/api/Distribution$Range;
      //   91: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   94: aload_1
      //   95: putstatic com/google/api/Distribution$Range.PARSER : Lcom/google/protobuf/Parser;
      //   98: ldc com/google/api/Distribution$Range
      //   100: monitorexit
      //   101: goto -> 110
      //   104: astore_1
      //   105: ldc com/google/api/Distribution$Range
      //   107: monitorexit
      //   108: aload_1
      //   109: athrow
      //   110: getstatic com/google/api/Distribution$Range.PARSER : Lcom/google/protobuf/Parser;
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
      //   174: putfield max_ : D
      //   177: goto -> 124
      //   180: aload_0
      //   181: aload_1
      //   182: invokevirtual readDouble : ()D
      //   185: putfield min_ : D
      //   188: goto -> 124
      //   191: iconst_1
      //   192: istore #5
      //   194: goto -> 124
      //   197: astore_1
      //   198: goto -> 245
      //   201: astore_1
      //   202: new java/lang/RuntimeException
      //   205: astore_2
      //   206: new com/google/protobuf/InvalidProtocolBufferException
      //   209: astore_3
      //   210: aload_3
      //   211: aload_1
      //   212: invokevirtual getMessage : ()Ljava/lang/String;
      //   215: invokespecial <init> : (Ljava/lang/String;)V
      //   218: aload_2
      //   219: aload_3
      //   220: aload_0
      //   221: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   224: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   227: aload_2
      //   228: athrow
      //   229: astore_2
      //   230: new java/lang/RuntimeException
      //   233: astore_1
      //   234: aload_1
      //   235: aload_2
      //   236: aload_0
      //   237: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   240: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   243: aload_1
      //   244: athrow
      //   245: aload_1
      //   246: athrow
      //   247: getstatic com/google/api/Distribution$Range.DEFAULT_INSTANCE : Lcom/google/api/Distribution$Range;
      //   250: areturn
      //   251: aload_2
      //   252: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   255: astore_1
      //   256: aload_3
      //   257: checkcast com/google/api/Distribution$Range
      //   260: astore_2
      //   261: aload_0
      //   262: getfield min_ : D
      //   265: dconst_0
      //   266: dcmpl
      //   267: ifeq -> 276
      //   270: iconst_1
      //   271: istore #6
      //   273: goto -> 279
      //   276: iconst_0
      //   277: istore #6
      //   279: aload_0
      //   280: getfield min_ : D
      //   283: dstore #7
      //   285: aload_2
      //   286: getfield min_ : D
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
      //   312: getfield min_ : D
      //   315: invokeinterface visitDouble : (ZDZD)D
      //   320: putfield min_ : D
      //   323: aload_0
      //   324: getfield max_ : D
      //   327: dconst_0
      //   328: dcmpl
      //   329: ifeq -> 338
      //   332: iconst_1
      //   333: istore #6
      //   335: goto -> 341
      //   338: iconst_0
      //   339: istore #6
      //   341: aload_0
      //   342: getfield max_ : D
      //   345: dstore #7
      //   347: aload_2
      //   348: getfield max_ : D
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
      //   374: getfield max_ : D
      //   377: invokeinterface visitDouble : (ZDZD)D
      //   382: putfield max_ : D
      //   385: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   388: astore_1
      //   389: aload_0
      //   390: areturn
      //   391: new com/google/api/Distribution$Range$Builder
      //   394: dup
      //   395: aconst_null
      //   396: invokespecial <init> : (Lcom/google/api/Distribution$1;)V
      //   399: areturn
      //   400: aconst_null
      //   401: areturn
      //   402: getstatic com/google/api/Distribution$Range.DEFAULT_INSTANCE : Lcom/google/api/Distribution$Range;
      //   405: areturn
      //   406: new com/google/api/Distribution$Range
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
    
    public double getMax() {
      return this.max_;
    }
    
    public double getMin() {
      return this.min_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      double d = this.min_;
      if (d != 0.0D)
        i = 0 + CodedOutputStream.computeDoubleSize(1, d); 
      d = this.max_;
      int j = i;
      if (d != 0.0D)
        j = i + CodedOutputStream.computeDoubleSize(2, d); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      double d = this.min_;
      if (d != 0.0D)
        param1CodedOutputStream.writeDouble(1, d); 
      d = this.max_;
      if (d != 0.0D)
        param1CodedOutputStream.writeDouble(2, d); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Range, Builder> implements Distribution.RangeOrBuilder {
      private Builder() {
        super(Distribution.Range.DEFAULT_INSTANCE);
      }
      
      public Builder clearMax() {
        copyOnWrite();
        ((Distribution.Range)this.instance).clearMax();
        return this;
      }
      
      public Builder clearMin() {
        copyOnWrite();
        ((Distribution.Range)this.instance).clearMin();
        return this;
      }
      
      public double getMax() {
        return ((Distribution.Range)this.instance).getMax();
      }
      
      public double getMin() {
        return ((Distribution.Range)this.instance).getMin();
      }
      
      public Builder setMax(double param2Double) {
        copyOnWrite();
        ((Distribution.Range)this.instance).setMax(param2Double);
        return this;
      }
      
      public Builder setMin(double param2Double) {
        copyOnWrite();
        ((Distribution.Range)this.instance).setMin(param2Double);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Range, Range.Builder> implements RangeOrBuilder {
    private Builder() {
      super(Distribution.Range.DEFAULT_INSTANCE);
    }
    
    public Builder clearMax() {
      copyOnWrite();
      ((Distribution.Range)this.instance).clearMax();
      return this;
    }
    
    public Builder clearMin() {
      copyOnWrite();
      ((Distribution.Range)this.instance).clearMin();
      return this;
    }
    
    public double getMax() {
      return ((Distribution.Range)this.instance).getMax();
    }
    
    public double getMin() {
      return ((Distribution.Range)this.instance).getMin();
    }
    
    public Builder setMax(double param1Double) {
      copyOnWrite();
      ((Distribution.Range)this.instance).setMax(param1Double);
      return this;
    }
    
    public Builder setMin(double param1Double) {
      copyOnWrite();
      ((Distribution.Range)this.instance).setMin(param1Double);
      return this;
    }
  }
  
  public static interface RangeOrBuilder extends MessageLiteOrBuilder {
    double getMax();
    
    double getMin();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\Distribution.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */