package com.google.type;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class PostalAddress extends GeneratedMessageLite<PostalAddress, PostalAddress.Builder> implements PostalAddressOrBuilder {
  public static final int ADDRESS_LINES_FIELD_NUMBER = 9;
  
  public static final int ADMINISTRATIVE_AREA_FIELD_NUMBER = 6;
  
  private static final PostalAddress DEFAULT_INSTANCE = new PostalAddress();
  
  public static final int LANGUAGE_CODE_FIELD_NUMBER = 3;
  
  public static final int LOCALITY_FIELD_NUMBER = 7;
  
  public static final int ORGANIZATION_FIELD_NUMBER = 11;
  
  private static volatile Parser<PostalAddress> PARSER;
  
  public static final int POSTAL_CODE_FIELD_NUMBER = 4;
  
  public static final int RECIPIENTS_FIELD_NUMBER = 10;
  
  public static final int REGION_CODE_FIELD_NUMBER = 2;
  
  public static final int REVISION_FIELD_NUMBER = 1;
  
  public static final int SORTING_CODE_FIELD_NUMBER = 5;
  
  public static final int SUBLOCALITY_FIELD_NUMBER = 8;
  
  private Internal.ProtobufList<String> addressLines_ = GeneratedMessageLite.emptyProtobufList();
  
  private String administrativeArea_ = "";
  
  private int bitField0_;
  
  private String languageCode_ = "";
  
  private String locality_ = "";
  
  private String organization_ = "";
  
  private String postalCode_ = "";
  
  private Internal.ProtobufList<String> recipients_ = GeneratedMessageLite.emptyProtobufList();
  
  private String regionCode_ = "";
  
  private int revision_;
  
  private String sortingCode_ = "";
  
  private String sublocality_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAddressLines(String paramString) {
    if (paramString != null) {
      ensureAddressLinesIsMutable();
      this.addressLines_.add(paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addAddressLinesBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      ensureAddressLinesIsMutable();
      this.addressLines_.add(paramByteString.toStringUtf8());
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addAllAddressLines(Iterable<String> paramIterable) {
    ensureAddressLinesIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.addressLines_);
  }
  
  private void addAllRecipients(Iterable<String> paramIterable) {
    ensureRecipientsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.recipients_);
  }
  
  private void addRecipients(String paramString) {
    if (paramString != null) {
      ensureRecipientsIsMutable();
      this.recipients_.add(paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addRecipientsBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      ensureRecipientsIsMutable();
      this.recipients_.add(paramByteString.toStringUtf8());
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearAddressLines() {
    this.addressLines_ = GeneratedMessageLite.emptyProtobufList();
  }
  
  private void clearAdministrativeArea() {
    this.administrativeArea_ = getDefaultInstance().getAdministrativeArea();
  }
  
  private void clearLanguageCode() {
    this.languageCode_ = getDefaultInstance().getLanguageCode();
  }
  
  private void clearLocality() {
    this.locality_ = getDefaultInstance().getLocality();
  }
  
  private void clearOrganization() {
    this.organization_ = getDefaultInstance().getOrganization();
  }
  
  private void clearPostalCode() {
    this.postalCode_ = getDefaultInstance().getPostalCode();
  }
  
  private void clearRecipients() {
    this.recipients_ = GeneratedMessageLite.emptyProtobufList();
  }
  
  private void clearRegionCode() {
    this.regionCode_ = getDefaultInstance().getRegionCode();
  }
  
  private void clearRevision() {
    this.revision_ = 0;
  }
  
  private void clearSortingCode() {
    this.sortingCode_ = getDefaultInstance().getSortingCode();
  }
  
  private void clearSublocality() {
    this.sublocality_ = getDefaultInstance().getSublocality();
  }
  
  private void ensureAddressLinesIsMutable() {
    if (!this.addressLines_.isModifiable())
      this.addressLines_ = GeneratedMessageLite.mutableCopy(this.addressLines_); 
  }
  
  private void ensureRecipientsIsMutable() {
    if (!this.recipients_.isModifiable())
      this.recipients_ = GeneratedMessageLite.mutableCopy(this.recipients_); 
  }
  
  public static PostalAddress getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(PostalAddress paramPostalAddress) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramPostalAddress);
  }
  
  public static PostalAddress parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (PostalAddress)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static PostalAddress parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (PostalAddress)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static PostalAddress parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (PostalAddress)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static PostalAddress parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (PostalAddress)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static PostalAddress parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (PostalAddress)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static PostalAddress parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (PostalAddress)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static PostalAddress parseFrom(InputStream paramInputStream) throws IOException {
    return (PostalAddress)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static PostalAddress parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (PostalAddress)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static PostalAddress parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (PostalAddress)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static PostalAddress parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (PostalAddress)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<PostalAddress> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setAddressLines(int paramInt, String paramString) {
    if (paramString != null) {
      ensureAddressLinesIsMutable();
      this.addressLines_.set(paramInt, paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setAdministrativeArea(String paramString) {
    if (paramString != null) {
      this.administrativeArea_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setAdministrativeAreaBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.administrativeArea_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setLanguageCode(String paramString) {
    if (paramString != null) {
      this.languageCode_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setLanguageCodeBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.languageCode_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setLocality(String paramString) {
    if (paramString != null) {
      this.locality_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setLocalityBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.locality_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setOrganization(String paramString) {
    if (paramString != null) {
      this.organization_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setOrganizationBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.organization_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setPostalCode(String paramString) {
    if (paramString != null) {
      this.postalCode_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setPostalCodeBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.postalCode_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRecipients(int paramInt, String paramString) {
    if (paramString != null) {
      ensureRecipientsIsMutable();
      this.recipients_.set(paramInt, paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRegionCode(String paramString) {
    if (paramString != null) {
      this.regionCode_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRegionCodeBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.regionCode_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRevision(int paramInt) {
    this.revision_ = paramInt;
  }
  
  private void setSortingCode(String paramString) {
    if (paramString != null) {
      this.sortingCode_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setSortingCodeBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.sortingCode_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setSublocality(String paramString) {
    if (paramString != null) {
      this.sublocality_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setSublocalityBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.sublocality_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/type/PostalAddress$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 954, 2 -> 950, 3 -> 930, 4 -> 921, 5 -> 513, 6 -> 118, 7 -> 509, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/type/PostalAddress.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/type/PostalAddress
    //   80: monitorenter
    //   81: getstatic com/google/type/PostalAddress.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/type/PostalAddress.DEFAULT_INSTANCE : Lcom/google/type/PostalAddress;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/type/PostalAddress.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/type/PostalAddress
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/type/PostalAddress
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/type/PostalAddress.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_1
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_2
    //   128: iload #6
    //   130: ifne -> 509
    //   133: aload_1
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: lookupswitch default -> 248, 0 -> 442, 8 -> 431, 18 -> 420, 26 -> 409, 34 -> 398, 42 -> 387, 50 -> 376, 58 -> 365, 66 -> 354, 74 -> 312, 82 -> 270, 90 -> 259
    //   248: aload_1
    //   249: iload #4
    //   251: invokevirtual skipField : (I)Z
    //   254: istore #7
    //   256: goto -> 448
    //   259: aload_0
    //   260: aload_1
    //   261: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   264: putfield organization_ : Ljava/lang/String;
    //   267: goto -> 128
    //   270: aload_1
    //   271: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   274: astore_2
    //   275: aload_0
    //   276: getfield recipients_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   279: invokeinterface isModifiable : ()Z
    //   284: ifne -> 298
    //   287: aload_0
    //   288: aload_0
    //   289: getfield recipients_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   292: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   295: putfield recipients_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   298: aload_0
    //   299: getfield recipients_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   302: aload_2
    //   303: invokeinterface add : (Ljava/lang/Object;)Z
    //   308: pop
    //   309: goto -> 128
    //   312: aload_1
    //   313: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   316: astore_2
    //   317: aload_0
    //   318: getfield addressLines_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   321: invokeinterface isModifiable : ()Z
    //   326: ifne -> 340
    //   329: aload_0
    //   330: aload_0
    //   331: getfield addressLines_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   334: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   337: putfield addressLines_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   340: aload_0
    //   341: getfield addressLines_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   344: aload_2
    //   345: invokeinterface add : (Ljava/lang/Object;)Z
    //   350: pop
    //   351: goto -> 128
    //   354: aload_0
    //   355: aload_1
    //   356: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   359: putfield sublocality_ : Ljava/lang/String;
    //   362: goto -> 128
    //   365: aload_0
    //   366: aload_1
    //   367: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   370: putfield locality_ : Ljava/lang/String;
    //   373: goto -> 128
    //   376: aload_0
    //   377: aload_1
    //   378: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   381: putfield administrativeArea_ : Ljava/lang/String;
    //   384: goto -> 128
    //   387: aload_0
    //   388: aload_1
    //   389: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   392: putfield sortingCode_ : Ljava/lang/String;
    //   395: goto -> 128
    //   398: aload_0
    //   399: aload_1
    //   400: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   403: putfield postalCode_ : Ljava/lang/String;
    //   406: goto -> 128
    //   409: aload_0
    //   410: aload_1
    //   411: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   414: putfield languageCode_ : Ljava/lang/String;
    //   417: goto -> 128
    //   420: aload_0
    //   421: aload_1
    //   422: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   425: putfield regionCode_ : Ljava/lang/String;
    //   428: goto -> 128
    //   431: aload_0
    //   432: aload_1
    //   433: invokevirtual readInt32 : ()I
    //   436: putfield revision_ : I
    //   439: goto -> 128
    //   442: iconst_1
    //   443: istore #6
    //   445: goto -> 128
    //   448: iload #7
    //   450: ifne -> 128
    //   453: iconst_1
    //   454: istore #6
    //   456: goto -> 128
    //   459: astore_1
    //   460: goto -> 507
    //   463: astore_3
    //   464: new java/lang/RuntimeException
    //   467: astore_2
    //   468: new com/google/protobuf/InvalidProtocolBufferException
    //   471: astore_1
    //   472: aload_1
    //   473: aload_3
    //   474: invokevirtual getMessage : ()Ljava/lang/String;
    //   477: invokespecial <init> : (Ljava/lang/String;)V
    //   480: aload_2
    //   481: aload_1
    //   482: aload_0
    //   483: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   486: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   489: aload_2
    //   490: athrow
    //   491: astore_1
    //   492: new java/lang/RuntimeException
    //   495: astore_2
    //   496: aload_2
    //   497: aload_1
    //   498: aload_0
    //   499: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   502: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   505: aload_2
    //   506: athrow
    //   507: aload_1
    //   508: athrow
    //   509: getstatic com/google/type/PostalAddress.DEFAULT_INSTANCE : Lcom/google/type/PostalAddress;
    //   512: areturn
    //   513: aload_2
    //   514: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   517: astore_1
    //   518: aload_3
    //   519: checkcast com/google/type/PostalAddress
    //   522: astore_2
    //   523: aload_0
    //   524: getfield revision_ : I
    //   527: ifeq -> 536
    //   530: iconst_1
    //   531: istore #7
    //   533: goto -> 539
    //   536: iconst_0
    //   537: istore #7
    //   539: aload_0
    //   540: getfield revision_ : I
    //   543: istore #6
    //   545: aload_2
    //   546: getfield revision_ : I
    //   549: ifeq -> 555
    //   552: iconst_1
    //   553: istore #5
    //   555: aload_0
    //   556: aload_1
    //   557: iload #7
    //   559: iload #6
    //   561: iload #5
    //   563: aload_2
    //   564: getfield revision_ : I
    //   567: invokeinterface visitInt : (ZIZI)I
    //   572: putfield revision_ : I
    //   575: aload_0
    //   576: aload_1
    //   577: aload_0
    //   578: getfield regionCode_ : Ljava/lang/String;
    //   581: invokevirtual isEmpty : ()Z
    //   584: iconst_1
    //   585: ixor
    //   586: aload_0
    //   587: getfield regionCode_ : Ljava/lang/String;
    //   590: aload_2
    //   591: getfield regionCode_ : Ljava/lang/String;
    //   594: invokevirtual isEmpty : ()Z
    //   597: iconst_1
    //   598: ixor
    //   599: aload_2
    //   600: getfield regionCode_ : Ljava/lang/String;
    //   603: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   608: putfield regionCode_ : Ljava/lang/String;
    //   611: aload_0
    //   612: aload_1
    //   613: aload_0
    //   614: getfield languageCode_ : Ljava/lang/String;
    //   617: invokevirtual isEmpty : ()Z
    //   620: iconst_1
    //   621: ixor
    //   622: aload_0
    //   623: getfield languageCode_ : Ljava/lang/String;
    //   626: aload_2
    //   627: getfield languageCode_ : Ljava/lang/String;
    //   630: invokevirtual isEmpty : ()Z
    //   633: iconst_1
    //   634: ixor
    //   635: aload_2
    //   636: getfield languageCode_ : Ljava/lang/String;
    //   639: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   644: putfield languageCode_ : Ljava/lang/String;
    //   647: aload_0
    //   648: aload_1
    //   649: aload_0
    //   650: getfield postalCode_ : Ljava/lang/String;
    //   653: invokevirtual isEmpty : ()Z
    //   656: iconst_1
    //   657: ixor
    //   658: aload_0
    //   659: getfield postalCode_ : Ljava/lang/String;
    //   662: aload_2
    //   663: getfield postalCode_ : Ljava/lang/String;
    //   666: invokevirtual isEmpty : ()Z
    //   669: iconst_1
    //   670: ixor
    //   671: aload_2
    //   672: getfield postalCode_ : Ljava/lang/String;
    //   675: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   680: putfield postalCode_ : Ljava/lang/String;
    //   683: aload_0
    //   684: aload_1
    //   685: aload_0
    //   686: getfield sortingCode_ : Ljava/lang/String;
    //   689: invokevirtual isEmpty : ()Z
    //   692: iconst_1
    //   693: ixor
    //   694: aload_0
    //   695: getfield sortingCode_ : Ljava/lang/String;
    //   698: aload_2
    //   699: getfield sortingCode_ : Ljava/lang/String;
    //   702: invokevirtual isEmpty : ()Z
    //   705: iconst_1
    //   706: ixor
    //   707: aload_2
    //   708: getfield sortingCode_ : Ljava/lang/String;
    //   711: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   716: putfield sortingCode_ : Ljava/lang/String;
    //   719: aload_0
    //   720: aload_1
    //   721: aload_0
    //   722: getfield administrativeArea_ : Ljava/lang/String;
    //   725: invokevirtual isEmpty : ()Z
    //   728: iconst_1
    //   729: ixor
    //   730: aload_0
    //   731: getfield administrativeArea_ : Ljava/lang/String;
    //   734: aload_2
    //   735: getfield administrativeArea_ : Ljava/lang/String;
    //   738: invokevirtual isEmpty : ()Z
    //   741: iconst_1
    //   742: ixor
    //   743: aload_2
    //   744: getfield administrativeArea_ : Ljava/lang/String;
    //   747: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   752: putfield administrativeArea_ : Ljava/lang/String;
    //   755: aload_0
    //   756: aload_1
    //   757: aload_0
    //   758: getfield locality_ : Ljava/lang/String;
    //   761: invokevirtual isEmpty : ()Z
    //   764: iconst_1
    //   765: ixor
    //   766: aload_0
    //   767: getfield locality_ : Ljava/lang/String;
    //   770: aload_2
    //   771: getfield locality_ : Ljava/lang/String;
    //   774: invokevirtual isEmpty : ()Z
    //   777: iconst_1
    //   778: ixor
    //   779: aload_2
    //   780: getfield locality_ : Ljava/lang/String;
    //   783: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   788: putfield locality_ : Ljava/lang/String;
    //   791: aload_0
    //   792: aload_1
    //   793: aload_0
    //   794: getfield sublocality_ : Ljava/lang/String;
    //   797: invokevirtual isEmpty : ()Z
    //   800: iconst_1
    //   801: ixor
    //   802: aload_0
    //   803: getfield sublocality_ : Ljava/lang/String;
    //   806: aload_2
    //   807: getfield sublocality_ : Ljava/lang/String;
    //   810: invokevirtual isEmpty : ()Z
    //   813: iconst_1
    //   814: ixor
    //   815: aload_2
    //   816: getfield sublocality_ : Ljava/lang/String;
    //   819: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   824: putfield sublocality_ : Ljava/lang/String;
    //   827: aload_0
    //   828: aload_1
    //   829: aload_0
    //   830: getfield addressLines_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   833: aload_2
    //   834: getfield addressLines_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   837: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   842: putfield addressLines_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   845: aload_0
    //   846: aload_1
    //   847: aload_0
    //   848: getfield recipients_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   851: aload_2
    //   852: getfield recipients_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   855: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   860: putfield recipients_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   863: aload_0
    //   864: aload_1
    //   865: aload_0
    //   866: getfield organization_ : Ljava/lang/String;
    //   869: invokevirtual isEmpty : ()Z
    //   872: iconst_1
    //   873: ixor
    //   874: aload_0
    //   875: getfield organization_ : Ljava/lang/String;
    //   878: aload_2
    //   879: getfield organization_ : Ljava/lang/String;
    //   882: invokevirtual isEmpty : ()Z
    //   885: iconst_1
    //   886: ixor
    //   887: aload_2
    //   888: getfield organization_ : Ljava/lang/String;
    //   891: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   896: putfield organization_ : Ljava/lang/String;
    //   899: aload_1
    //   900: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   903: if_acmpne -> 919
    //   906: aload_0
    //   907: aload_0
    //   908: getfield bitField0_ : I
    //   911: aload_2
    //   912: getfield bitField0_ : I
    //   915: ior
    //   916: putfield bitField0_ : I
    //   919: aload_0
    //   920: areturn
    //   921: new com/google/type/PostalAddress$Builder
    //   924: dup
    //   925: aconst_null
    //   926: invokespecial <init> : (Lcom/google/type/PostalAddress$1;)V
    //   929: areturn
    //   930: aload_0
    //   931: getfield addressLines_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   934: invokeinterface makeImmutable : ()V
    //   939: aload_0
    //   940: getfield recipients_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   943: invokeinterface makeImmutable : ()V
    //   948: aconst_null
    //   949: areturn
    //   950: getstatic com/google/type/PostalAddress.DEFAULT_INSTANCE : Lcom/google/type/PostalAddress;
    //   953: areturn
    //   954: new com/google/type/PostalAddress
    //   957: dup
    //   958: invokespecial <init> : ()V
    //   961: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	491	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	463	java/io/IOException
    //   133	139	459	finally
    //   248	256	491	com/google/protobuf/InvalidProtocolBufferException
    //   248	256	463	java/io/IOException
    //   248	256	459	finally
    //   259	267	491	com/google/protobuf/InvalidProtocolBufferException
    //   259	267	463	java/io/IOException
    //   259	267	459	finally
    //   270	298	491	com/google/protobuf/InvalidProtocolBufferException
    //   270	298	463	java/io/IOException
    //   270	298	459	finally
    //   298	309	491	com/google/protobuf/InvalidProtocolBufferException
    //   298	309	463	java/io/IOException
    //   298	309	459	finally
    //   312	340	491	com/google/protobuf/InvalidProtocolBufferException
    //   312	340	463	java/io/IOException
    //   312	340	459	finally
    //   340	351	491	com/google/protobuf/InvalidProtocolBufferException
    //   340	351	463	java/io/IOException
    //   340	351	459	finally
    //   354	362	491	com/google/protobuf/InvalidProtocolBufferException
    //   354	362	463	java/io/IOException
    //   354	362	459	finally
    //   365	373	491	com/google/protobuf/InvalidProtocolBufferException
    //   365	373	463	java/io/IOException
    //   365	373	459	finally
    //   376	384	491	com/google/protobuf/InvalidProtocolBufferException
    //   376	384	463	java/io/IOException
    //   376	384	459	finally
    //   387	395	491	com/google/protobuf/InvalidProtocolBufferException
    //   387	395	463	java/io/IOException
    //   387	395	459	finally
    //   398	406	491	com/google/protobuf/InvalidProtocolBufferException
    //   398	406	463	java/io/IOException
    //   398	406	459	finally
    //   409	417	491	com/google/protobuf/InvalidProtocolBufferException
    //   409	417	463	java/io/IOException
    //   409	417	459	finally
    //   420	428	491	com/google/protobuf/InvalidProtocolBufferException
    //   420	428	463	java/io/IOException
    //   420	428	459	finally
    //   431	439	491	com/google/protobuf/InvalidProtocolBufferException
    //   431	439	463	java/io/IOException
    //   431	439	459	finally
    //   464	491	459	finally
    //   492	507	459	finally
  }
  
  public String getAddressLines(int paramInt) {
    return (String)this.addressLines_.get(paramInt);
  }
  
  public ByteString getAddressLinesBytes(int paramInt) {
    return ByteString.copyFromUtf8((String)this.addressLines_.get(paramInt));
  }
  
  public int getAddressLinesCount() {
    return this.addressLines_.size();
  }
  
  public List<String> getAddressLinesList() {
    return (List<String>)this.addressLines_;
  }
  
  public String getAdministrativeArea() {
    return this.administrativeArea_;
  }
  
  public ByteString getAdministrativeAreaBytes() {
    return ByteString.copyFromUtf8(this.administrativeArea_);
  }
  
  public String getLanguageCode() {
    return this.languageCode_;
  }
  
  public ByteString getLanguageCodeBytes() {
    return ByteString.copyFromUtf8(this.languageCode_);
  }
  
  public String getLocality() {
    return this.locality_;
  }
  
  public ByteString getLocalityBytes() {
    return ByteString.copyFromUtf8(this.locality_);
  }
  
  public String getOrganization() {
    return this.organization_;
  }
  
  public ByteString getOrganizationBytes() {
    return ByteString.copyFromUtf8(this.organization_);
  }
  
  public String getPostalCode() {
    return this.postalCode_;
  }
  
  public ByteString getPostalCodeBytes() {
    return ByteString.copyFromUtf8(this.postalCode_);
  }
  
  public String getRecipients(int paramInt) {
    return (String)this.recipients_.get(paramInt);
  }
  
  public ByteString getRecipientsBytes(int paramInt) {
    return ByteString.copyFromUtf8((String)this.recipients_.get(paramInt));
  }
  
  public int getRecipientsCount() {
    return this.recipients_.size();
  }
  
  public List<String> getRecipientsList() {
    return (List<String>)this.recipients_;
  }
  
  public String getRegionCode() {
    return this.regionCode_;
  }
  
  public ByteString getRegionCodeBytes() {
    return ByteString.copyFromUtf8(this.regionCode_);
  }
  
  public int getRevision() {
    return this.revision_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = this.revision_;
    byte b = 0;
    if (i != 0) {
      j = CodedOutputStream.computeInt32Size(1, i) + 0;
    } else {
      j = 0;
    } 
    i = j;
    if (!this.regionCode_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(2, getRegionCode()); 
    int j = i;
    if (!this.languageCode_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(3, getLanguageCode()); 
    i = j;
    if (!this.postalCode_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(4, getPostalCode()); 
    j = i;
    if (!this.sortingCode_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(5, getSortingCode()); 
    i = j;
    if (!this.administrativeArea_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(6, getAdministrativeArea()); 
    j = i;
    if (!this.locality_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(7, getLocality()); 
    i = j;
    if (!this.sublocality_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(8, getSublocality()); 
    int k = 0;
    j = 0;
    while (k < this.addressLines_.size()) {
      j += CodedOutputStream.computeStringSizeNoTag((String)this.addressLines_.get(k));
      k++;
    } 
    int m = getAddressLinesList().size();
    k = 0;
    while (b < this.recipients_.size()) {
      k += CodedOutputStream.computeStringSizeNoTag((String)this.recipients_.get(b));
      b++;
    } 
    j = i + j + m * 1 + k + getRecipientsList().size() * 1;
    i = j;
    if (!this.organization_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(11, getOrganization()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public String getSortingCode() {
    return this.sortingCode_;
  }
  
  public ByteString getSortingCodeBytes() {
    return ByteString.copyFromUtf8(this.sortingCode_);
  }
  
  public String getSublocality() {
    return this.sublocality_;
  }
  
  public ByteString getSublocalityBytes() {
    return ByteString.copyFromUtf8(this.sublocality_);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    int i = this.revision_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(1, i); 
    if (!this.regionCode_.isEmpty())
      paramCodedOutputStream.writeString(2, getRegionCode()); 
    if (!this.languageCode_.isEmpty())
      paramCodedOutputStream.writeString(3, getLanguageCode()); 
    if (!this.postalCode_.isEmpty())
      paramCodedOutputStream.writeString(4, getPostalCode()); 
    if (!this.sortingCode_.isEmpty())
      paramCodedOutputStream.writeString(5, getSortingCode()); 
    if (!this.administrativeArea_.isEmpty())
      paramCodedOutputStream.writeString(6, getAdministrativeArea()); 
    if (!this.locality_.isEmpty())
      paramCodedOutputStream.writeString(7, getLocality()); 
    if (!this.sublocality_.isEmpty())
      paramCodedOutputStream.writeString(8, getSublocality()); 
    boolean bool = false;
    byte b = 0;
    while (true) {
      i = bool;
      if (b < this.addressLines_.size()) {
        paramCodedOutputStream.writeString(9, (String)this.addressLines_.get(b));
        b++;
        continue;
      } 
      break;
    } 
    while (i < this.recipients_.size()) {
      paramCodedOutputStream.writeString(10, (String)this.recipients_.get(i));
      i++;
    } 
    if (!this.organization_.isEmpty())
      paramCodedOutputStream.writeString(11, getOrganization()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<PostalAddress, Builder> implements PostalAddressOrBuilder {
    private Builder() {
      super(PostalAddress.DEFAULT_INSTANCE);
    }
    
    public Builder addAddressLines(String param1String) {
      copyOnWrite();
      ((PostalAddress)this.instance).addAddressLines(param1String);
      return this;
    }
    
    public Builder addAddressLinesBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PostalAddress)this.instance).addAddressLinesBytes(param1ByteString);
      return this;
    }
    
    public Builder addAllAddressLines(Iterable<String> param1Iterable) {
      copyOnWrite();
      ((PostalAddress)this.instance).addAllAddressLines(param1Iterable);
      return this;
    }
    
    public Builder addAllRecipients(Iterable<String> param1Iterable) {
      copyOnWrite();
      ((PostalAddress)this.instance).addAllRecipients(param1Iterable);
      return this;
    }
    
    public Builder addRecipients(String param1String) {
      copyOnWrite();
      ((PostalAddress)this.instance).addRecipients(param1String);
      return this;
    }
    
    public Builder addRecipientsBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PostalAddress)this.instance).addRecipientsBytes(param1ByteString);
      return this;
    }
    
    public Builder clearAddressLines() {
      copyOnWrite();
      ((PostalAddress)this.instance).clearAddressLines();
      return this;
    }
    
    public Builder clearAdministrativeArea() {
      copyOnWrite();
      ((PostalAddress)this.instance).clearAdministrativeArea();
      return this;
    }
    
    public Builder clearLanguageCode() {
      copyOnWrite();
      ((PostalAddress)this.instance).clearLanguageCode();
      return this;
    }
    
    public Builder clearLocality() {
      copyOnWrite();
      ((PostalAddress)this.instance).clearLocality();
      return this;
    }
    
    public Builder clearOrganization() {
      copyOnWrite();
      ((PostalAddress)this.instance).clearOrganization();
      return this;
    }
    
    public Builder clearPostalCode() {
      copyOnWrite();
      ((PostalAddress)this.instance).clearPostalCode();
      return this;
    }
    
    public Builder clearRecipients() {
      copyOnWrite();
      ((PostalAddress)this.instance).clearRecipients();
      return this;
    }
    
    public Builder clearRegionCode() {
      copyOnWrite();
      ((PostalAddress)this.instance).clearRegionCode();
      return this;
    }
    
    public Builder clearRevision() {
      copyOnWrite();
      ((PostalAddress)this.instance).clearRevision();
      return this;
    }
    
    public Builder clearSortingCode() {
      copyOnWrite();
      ((PostalAddress)this.instance).clearSortingCode();
      return this;
    }
    
    public Builder clearSublocality() {
      copyOnWrite();
      ((PostalAddress)this.instance).clearSublocality();
      return this;
    }
    
    public String getAddressLines(int param1Int) {
      return ((PostalAddress)this.instance).getAddressLines(param1Int);
    }
    
    public ByteString getAddressLinesBytes(int param1Int) {
      return ((PostalAddress)this.instance).getAddressLinesBytes(param1Int);
    }
    
    public int getAddressLinesCount() {
      return ((PostalAddress)this.instance).getAddressLinesCount();
    }
    
    public List<String> getAddressLinesList() {
      return Collections.unmodifiableList(((PostalAddress)this.instance).getAddressLinesList());
    }
    
    public String getAdministrativeArea() {
      return ((PostalAddress)this.instance).getAdministrativeArea();
    }
    
    public ByteString getAdministrativeAreaBytes() {
      return ((PostalAddress)this.instance).getAdministrativeAreaBytes();
    }
    
    public String getLanguageCode() {
      return ((PostalAddress)this.instance).getLanguageCode();
    }
    
    public ByteString getLanguageCodeBytes() {
      return ((PostalAddress)this.instance).getLanguageCodeBytes();
    }
    
    public String getLocality() {
      return ((PostalAddress)this.instance).getLocality();
    }
    
    public ByteString getLocalityBytes() {
      return ((PostalAddress)this.instance).getLocalityBytes();
    }
    
    public String getOrganization() {
      return ((PostalAddress)this.instance).getOrganization();
    }
    
    public ByteString getOrganizationBytes() {
      return ((PostalAddress)this.instance).getOrganizationBytes();
    }
    
    public String getPostalCode() {
      return ((PostalAddress)this.instance).getPostalCode();
    }
    
    public ByteString getPostalCodeBytes() {
      return ((PostalAddress)this.instance).getPostalCodeBytes();
    }
    
    public String getRecipients(int param1Int) {
      return ((PostalAddress)this.instance).getRecipients(param1Int);
    }
    
    public ByteString getRecipientsBytes(int param1Int) {
      return ((PostalAddress)this.instance).getRecipientsBytes(param1Int);
    }
    
    public int getRecipientsCount() {
      return ((PostalAddress)this.instance).getRecipientsCount();
    }
    
    public List<String> getRecipientsList() {
      return Collections.unmodifiableList(((PostalAddress)this.instance).getRecipientsList());
    }
    
    public String getRegionCode() {
      return ((PostalAddress)this.instance).getRegionCode();
    }
    
    public ByteString getRegionCodeBytes() {
      return ((PostalAddress)this.instance).getRegionCodeBytes();
    }
    
    public int getRevision() {
      return ((PostalAddress)this.instance).getRevision();
    }
    
    public String getSortingCode() {
      return ((PostalAddress)this.instance).getSortingCode();
    }
    
    public ByteString getSortingCodeBytes() {
      return ((PostalAddress)this.instance).getSortingCodeBytes();
    }
    
    public String getSublocality() {
      return ((PostalAddress)this.instance).getSublocality();
    }
    
    public ByteString getSublocalityBytes() {
      return ((PostalAddress)this.instance).getSublocalityBytes();
    }
    
    public Builder setAddressLines(int param1Int, String param1String) {
      copyOnWrite();
      ((PostalAddress)this.instance).setAddressLines(param1Int, param1String);
      return this;
    }
    
    public Builder setAdministrativeArea(String param1String) {
      copyOnWrite();
      ((PostalAddress)this.instance).setAdministrativeArea(param1String);
      return this;
    }
    
    public Builder setAdministrativeAreaBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PostalAddress)this.instance).setAdministrativeAreaBytes(param1ByteString);
      return this;
    }
    
    public Builder setLanguageCode(String param1String) {
      copyOnWrite();
      ((PostalAddress)this.instance).setLanguageCode(param1String);
      return this;
    }
    
    public Builder setLanguageCodeBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PostalAddress)this.instance).setLanguageCodeBytes(param1ByteString);
      return this;
    }
    
    public Builder setLocality(String param1String) {
      copyOnWrite();
      ((PostalAddress)this.instance).setLocality(param1String);
      return this;
    }
    
    public Builder setLocalityBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PostalAddress)this.instance).setLocalityBytes(param1ByteString);
      return this;
    }
    
    public Builder setOrganization(String param1String) {
      copyOnWrite();
      ((PostalAddress)this.instance).setOrganization(param1String);
      return this;
    }
    
    public Builder setOrganizationBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PostalAddress)this.instance).setOrganizationBytes(param1ByteString);
      return this;
    }
    
    public Builder setPostalCode(String param1String) {
      copyOnWrite();
      ((PostalAddress)this.instance).setPostalCode(param1String);
      return this;
    }
    
    public Builder setPostalCodeBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PostalAddress)this.instance).setPostalCodeBytes(param1ByteString);
      return this;
    }
    
    public Builder setRecipients(int param1Int, String param1String) {
      copyOnWrite();
      ((PostalAddress)this.instance).setRecipients(param1Int, param1String);
      return this;
    }
    
    public Builder setRegionCode(String param1String) {
      copyOnWrite();
      ((PostalAddress)this.instance).setRegionCode(param1String);
      return this;
    }
    
    public Builder setRegionCodeBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PostalAddress)this.instance).setRegionCodeBytes(param1ByteString);
      return this;
    }
    
    public Builder setRevision(int param1Int) {
      copyOnWrite();
      ((PostalAddress)this.instance).setRevision(param1Int);
      return this;
    }
    
    public Builder setSortingCode(String param1String) {
      copyOnWrite();
      ((PostalAddress)this.instance).setSortingCode(param1String);
      return this;
    }
    
    public Builder setSortingCodeBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PostalAddress)this.instance).setSortingCodeBytes(param1ByteString);
      return this;
    }
    
    public Builder setSublocality(String param1String) {
      copyOnWrite();
      ((PostalAddress)this.instance).setSublocality(param1String);
      return this;
    }
    
    public Builder setSublocalityBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PostalAddress)this.instance).setSublocalityBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\type\PostalAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */