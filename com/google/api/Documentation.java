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

public final class Documentation extends GeneratedMessageLite<Documentation, Documentation.Builder> implements DocumentationOrBuilder {
  private static final Documentation DEFAULT_INSTANCE = new Documentation();
  
  public static final int DOCUMENTATION_ROOT_URL_FIELD_NUMBER = 4;
  
  public static final int OVERVIEW_FIELD_NUMBER = 2;
  
  public static final int PAGES_FIELD_NUMBER = 5;
  
  private static volatile Parser<Documentation> PARSER;
  
  public static final int RULES_FIELD_NUMBER = 3;
  
  public static final int SUMMARY_FIELD_NUMBER = 1;
  
  private int bitField0_;
  
  private String documentationRootUrl_ = "";
  
  private String overview_ = "";
  
  private Internal.ProtobufList<Page> pages_ = emptyProtobufList();
  
  private Internal.ProtobufList<DocumentationRule> rules_ = emptyProtobufList();
  
  private String summary_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllPages(Iterable<? extends Page> paramIterable) {
    ensurePagesIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.pages_);
  }
  
  private void addAllRules(Iterable<? extends DocumentationRule> paramIterable) {
    ensureRulesIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.rules_);
  }
  
  private void addPages(int paramInt, Page.Builder paramBuilder) {
    ensurePagesIsMutable();
    this.pages_.add(paramInt, paramBuilder.build());
  }
  
  private void addPages(int paramInt, Page paramPage) {
    if (paramPage != null) {
      ensurePagesIsMutable();
      this.pages_.add(paramInt, paramPage);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addPages(Page.Builder paramBuilder) {
    ensurePagesIsMutable();
    this.pages_.add(paramBuilder.build());
  }
  
  private void addPages(Page paramPage) {
    if (paramPage != null) {
      ensurePagesIsMutable();
      this.pages_.add(paramPage);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addRules(int paramInt, DocumentationRule.Builder paramBuilder) {
    ensureRulesIsMutable();
    this.rules_.add(paramInt, paramBuilder.build());
  }
  
  private void addRules(int paramInt, DocumentationRule paramDocumentationRule) {
    if (paramDocumentationRule != null) {
      ensureRulesIsMutable();
      this.rules_.add(paramInt, paramDocumentationRule);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addRules(DocumentationRule.Builder paramBuilder) {
    ensureRulesIsMutable();
    this.rules_.add(paramBuilder.build());
  }
  
  private void addRules(DocumentationRule paramDocumentationRule) {
    if (paramDocumentationRule != null) {
      ensureRulesIsMutable();
      this.rules_.add(paramDocumentationRule);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearDocumentationRootUrl() {
    this.documentationRootUrl_ = getDefaultInstance().getDocumentationRootUrl();
  }
  
  private void clearOverview() {
    this.overview_ = getDefaultInstance().getOverview();
  }
  
  private void clearPages() {
    this.pages_ = emptyProtobufList();
  }
  
  private void clearRules() {
    this.rules_ = emptyProtobufList();
  }
  
  private void clearSummary() {
    this.summary_ = getDefaultInstance().getSummary();
  }
  
  private void ensurePagesIsMutable() {
    if (!this.pages_.isModifiable())
      this.pages_ = GeneratedMessageLite.mutableCopy(this.pages_); 
  }
  
  private void ensureRulesIsMutable() {
    if (!this.rules_.isModifiable())
      this.rules_ = GeneratedMessageLite.mutableCopy(this.rules_); 
  }
  
  public static Documentation getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Documentation paramDocumentation) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramDocumentation);
  }
  
  public static Documentation parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Documentation)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Documentation parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Documentation)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Documentation parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Documentation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Documentation parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Documentation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Documentation parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Documentation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Documentation parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Documentation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Documentation parseFrom(InputStream paramInputStream) throws IOException {
    return (Documentation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Documentation parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Documentation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Documentation parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Documentation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Documentation parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Documentation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Documentation> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removePages(int paramInt) {
    ensurePagesIsMutable();
    this.pages_.remove(paramInt);
  }
  
  private void removeRules(int paramInt) {
    ensureRulesIsMutable();
    this.rules_.remove(paramInt);
  }
  
  private void setDocumentationRootUrl(String paramString) {
    if (paramString != null) {
      this.documentationRootUrl_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDocumentationRootUrlBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.documentationRootUrl_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setOverview(String paramString) {
    if (paramString != null) {
      this.overview_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setOverviewBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.overview_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setPages(int paramInt, Page.Builder paramBuilder) {
    ensurePagesIsMutable();
    this.pages_.set(paramInt, paramBuilder.build());
  }
  
  private void setPages(int paramInt, Page paramPage) {
    if (paramPage != null) {
      ensurePagesIsMutable();
      this.pages_.set(paramInt, paramPage);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRules(int paramInt, DocumentationRule.Builder paramBuilder) {
    ensureRulesIsMutable();
    this.rules_.set(paramInt, paramBuilder.build());
  }
  
  private void setRules(int paramInt, DocumentationRule paramDocumentationRule) {
    if (paramDocumentationRule != null) {
      ensureRulesIsMutable();
      this.rules_.set(paramInt, paramDocumentationRule);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setSummary(String paramString) {
    if (paramString != null) {
      this.summary_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setSummaryBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.summary_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/Documentation$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 585, 2 -> 581, 3 -> 561, 4 -> 552, 5 -> 376, 6 -> 110, 7 -> 372, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/api/Documentation.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/api/Documentation
    //   72: monitorenter
    //   73: getstatic com/google/api/Documentation.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/api/Documentation.DEFAULT_INSTANCE : Lcom/google/api/Documentation;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/api/Documentation.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/api/Documentation
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/api/Documentation
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/api/Documentation.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 372
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 316
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 305
    //   146: iload #5
    //   148: bipush #18
    //   150: if_icmpeq -> 294
    //   153: iload #5
    //   155: bipush #26
    //   157: if_icmpeq -> 247
    //   160: iload #5
    //   162: bipush #34
    //   164: if_icmpeq -> 236
    //   167: iload #5
    //   169: bipush #42
    //   171: if_icmpeq -> 189
    //   174: aload_1
    //   175: iload #5
    //   177: invokevirtual skipField : (I)Z
    //   180: ifne -> 123
    //   183: iconst_1
    //   184: istore #4
    //   186: goto -> 123
    //   189: aload_0
    //   190: getfield pages_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   193: invokeinterface isModifiable : ()Z
    //   198: ifne -> 212
    //   201: aload_0
    //   202: aload_0
    //   203: getfield pages_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   206: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   209: putfield pages_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   212: aload_0
    //   213: getfield pages_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   216: aload_1
    //   217: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   220: aload_2
    //   221: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   224: checkcast com/google/api/Page
    //   227: invokeinterface add : (Ljava/lang/Object;)Z
    //   232: pop
    //   233: goto -> 123
    //   236: aload_0
    //   237: aload_1
    //   238: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   241: putfield documentationRootUrl_ : Ljava/lang/String;
    //   244: goto -> 123
    //   247: aload_0
    //   248: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   251: invokeinterface isModifiable : ()Z
    //   256: ifne -> 270
    //   259: aload_0
    //   260: aload_0
    //   261: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   264: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   267: putfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   270: aload_0
    //   271: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   274: aload_1
    //   275: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   278: aload_2
    //   279: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   282: checkcast com/google/api/DocumentationRule
    //   285: invokeinterface add : (Ljava/lang/Object;)Z
    //   290: pop
    //   291: goto -> 123
    //   294: aload_0
    //   295: aload_1
    //   296: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   299: putfield overview_ : Ljava/lang/String;
    //   302: goto -> 123
    //   305: aload_0
    //   306: aload_1
    //   307: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   310: putfield summary_ : Ljava/lang/String;
    //   313: goto -> 123
    //   316: iconst_1
    //   317: istore #4
    //   319: goto -> 123
    //   322: astore_1
    //   323: goto -> 370
    //   326: astore_2
    //   327: new java/lang/RuntimeException
    //   330: astore_1
    //   331: new com/google/protobuf/InvalidProtocolBufferException
    //   334: astore_3
    //   335: aload_3
    //   336: aload_2
    //   337: invokevirtual getMessage : ()Ljava/lang/String;
    //   340: invokespecial <init> : (Ljava/lang/String;)V
    //   343: aload_1
    //   344: aload_3
    //   345: aload_0
    //   346: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   349: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   352: aload_1
    //   353: athrow
    //   354: astore_1
    //   355: new java/lang/RuntimeException
    //   358: astore_2
    //   359: aload_2
    //   360: aload_1
    //   361: aload_0
    //   362: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   365: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   368: aload_2
    //   369: athrow
    //   370: aload_1
    //   371: athrow
    //   372: getstatic com/google/api/Documentation.DEFAULT_INSTANCE : Lcom/google/api/Documentation;
    //   375: areturn
    //   376: aload_2
    //   377: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   380: astore_1
    //   381: aload_3
    //   382: checkcast com/google/api/Documentation
    //   385: astore_2
    //   386: aload_0
    //   387: aload_1
    //   388: aload_0
    //   389: getfield summary_ : Ljava/lang/String;
    //   392: invokevirtual isEmpty : ()Z
    //   395: iconst_1
    //   396: ixor
    //   397: aload_0
    //   398: getfield summary_ : Ljava/lang/String;
    //   401: aload_2
    //   402: getfield summary_ : Ljava/lang/String;
    //   405: invokevirtual isEmpty : ()Z
    //   408: iconst_1
    //   409: ixor
    //   410: aload_2
    //   411: getfield summary_ : Ljava/lang/String;
    //   414: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   419: putfield summary_ : Ljava/lang/String;
    //   422: aload_0
    //   423: aload_1
    //   424: aload_0
    //   425: getfield pages_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   428: aload_2
    //   429: getfield pages_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   432: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   437: putfield pages_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   440: aload_0
    //   441: aload_1
    //   442: aload_0
    //   443: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   446: aload_2
    //   447: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   450: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   455: putfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   458: aload_0
    //   459: aload_1
    //   460: aload_0
    //   461: getfield documentationRootUrl_ : Ljava/lang/String;
    //   464: invokevirtual isEmpty : ()Z
    //   467: iconst_1
    //   468: ixor
    //   469: aload_0
    //   470: getfield documentationRootUrl_ : Ljava/lang/String;
    //   473: aload_2
    //   474: getfield documentationRootUrl_ : Ljava/lang/String;
    //   477: invokevirtual isEmpty : ()Z
    //   480: iconst_1
    //   481: ixor
    //   482: aload_2
    //   483: getfield documentationRootUrl_ : Ljava/lang/String;
    //   486: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   491: putfield documentationRootUrl_ : Ljava/lang/String;
    //   494: aload_0
    //   495: aload_1
    //   496: aload_0
    //   497: getfield overview_ : Ljava/lang/String;
    //   500: invokevirtual isEmpty : ()Z
    //   503: iconst_1
    //   504: ixor
    //   505: aload_0
    //   506: getfield overview_ : Ljava/lang/String;
    //   509: iconst_1
    //   510: aload_2
    //   511: getfield overview_ : Ljava/lang/String;
    //   514: invokevirtual isEmpty : ()Z
    //   517: ixor
    //   518: aload_2
    //   519: getfield overview_ : Ljava/lang/String;
    //   522: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   527: putfield overview_ : Ljava/lang/String;
    //   530: aload_1
    //   531: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   534: if_acmpne -> 550
    //   537: aload_0
    //   538: aload_0
    //   539: getfield bitField0_ : I
    //   542: aload_2
    //   543: getfield bitField0_ : I
    //   546: ior
    //   547: putfield bitField0_ : I
    //   550: aload_0
    //   551: areturn
    //   552: new com/google/api/Documentation$Builder
    //   555: dup
    //   556: aconst_null
    //   557: invokespecial <init> : (Lcom/google/api/Documentation$1;)V
    //   560: areturn
    //   561: aload_0
    //   562: getfield pages_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   565: invokeinterface makeImmutable : ()V
    //   570: aload_0
    //   571: getfield rules_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   574: invokeinterface makeImmutable : ()V
    //   579: aconst_null
    //   580: areturn
    //   581: getstatic com/google/api/Documentation.DEFAULT_INSTANCE : Lcom/google/api/Documentation;
    //   584: areturn
    //   585: new com/google/api/Documentation
    //   588: dup
    //   589: invokespecial <init> : ()V
    //   592: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	354	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	326	java/io/IOException
    //   128	134	322	finally
    //   174	183	354	com/google/protobuf/InvalidProtocolBufferException
    //   174	183	326	java/io/IOException
    //   174	183	322	finally
    //   189	212	354	com/google/protobuf/InvalidProtocolBufferException
    //   189	212	326	java/io/IOException
    //   189	212	322	finally
    //   212	233	354	com/google/protobuf/InvalidProtocolBufferException
    //   212	233	326	java/io/IOException
    //   212	233	322	finally
    //   236	244	354	com/google/protobuf/InvalidProtocolBufferException
    //   236	244	326	java/io/IOException
    //   236	244	322	finally
    //   247	270	354	com/google/protobuf/InvalidProtocolBufferException
    //   247	270	326	java/io/IOException
    //   247	270	322	finally
    //   270	291	354	com/google/protobuf/InvalidProtocolBufferException
    //   270	291	326	java/io/IOException
    //   270	291	322	finally
    //   294	302	354	com/google/protobuf/InvalidProtocolBufferException
    //   294	302	326	java/io/IOException
    //   294	302	322	finally
    //   305	313	354	com/google/protobuf/InvalidProtocolBufferException
    //   305	313	326	java/io/IOException
    //   305	313	322	finally
    //   327	354	322	finally
    //   355	370	322	finally
  }
  
  public String getDocumentationRootUrl() {
    return this.documentationRootUrl_;
  }
  
  public ByteString getDocumentationRootUrlBytes() {
    return ByteString.copyFromUtf8(this.documentationRootUrl_);
  }
  
  public String getOverview() {
    return this.overview_;
  }
  
  public ByteString getOverviewBytes() {
    return ByteString.copyFromUtf8(this.overview_);
  }
  
  public Page getPages(int paramInt) {
    return (Page)this.pages_.get(paramInt);
  }
  
  public int getPagesCount() {
    return this.pages_.size();
  }
  
  public List<Page> getPagesList() {
    return (List<Page>)this.pages_;
  }
  
  public PageOrBuilder getPagesOrBuilder(int paramInt) {
    return (PageOrBuilder)this.pages_.get(paramInt);
  }
  
  public List<? extends PageOrBuilder> getPagesOrBuilderList() {
    return (List)this.pages_;
  }
  
  public DocumentationRule getRules(int paramInt) {
    return (DocumentationRule)this.rules_.get(paramInt);
  }
  
  public int getRulesCount() {
    return this.rules_.size();
  }
  
  public List<DocumentationRule> getRulesList() {
    return (List<DocumentationRule>)this.rules_;
  }
  
  public DocumentationRuleOrBuilder getRulesOrBuilder(int paramInt) {
    return (DocumentationRuleOrBuilder)this.rules_.get(paramInt);
  }
  
  public List<? extends DocumentationRuleOrBuilder> getRulesOrBuilderList() {
    return (List)this.rules_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    boolean bool = this.summary_.isEmpty();
    byte b1 = 0;
    if (!bool) {
      i = CodedOutputStream.computeStringSize(1, getSummary()) + 0;
    } else {
      i = 0;
    } 
    int j = i;
    if (!this.overview_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(2, getOverview()); 
    i = j;
    for (j = 0; j < this.rules_.size(); j++)
      i += CodedOutputStream.computeMessageSize(3, (MessageLite)this.rules_.get(j)); 
    byte b2 = b1;
    j = i;
    if (!this.documentationRootUrl_.isEmpty()) {
      j = i + CodedOutputStream.computeStringSize(4, getDocumentationRootUrl());
      b2 = b1;
    } 
    while (b2 < this.pages_.size()) {
      j += CodedOutputStream.computeMessageSize(5, (MessageLite)this.pages_.get(b2));
      b2++;
    } 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public String getSummary() {
    return this.summary_;
  }
  
  public ByteString getSummaryBytes() {
    return ByteString.copyFromUtf8(this.summary_);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.summary_.isEmpty())
      paramCodedOutputStream.writeString(1, getSummary()); 
    if (!this.overview_.isEmpty())
      paramCodedOutputStream.writeString(2, getOverview()); 
    boolean bool = false;
    byte b;
    for (b = 0; b < this.rules_.size(); b++)
      paramCodedOutputStream.writeMessage(3, (MessageLite)this.rules_.get(b)); 
    b = bool;
    if (!this.documentationRootUrl_.isEmpty()) {
      paramCodedOutputStream.writeString(4, getDocumentationRootUrl());
      b = bool;
    } 
    while (b < this.pages_.size()) {
      paramCodedOutputStream.writeMessage(5, (MessageLite)this.pages_.get(b));
      b++;
    } 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Documentation, Builder> implements DocumentationOrBuilder {
    private Builder() {
      super(Documentation.DEFAULT_INSTANCE);
    }
    
    public Builder addAllPages(Iterable<? extends Page> param1Iterable) {
      copyOnWrite();
      ((Documentation)this.instance).addAllPages(param1Iterable);
      return this;
    }
    
    public Builder addAllRules(Iterable<? extends DocumentationRule> param1Iterable) {
      copyOnWrite();
      ((Documentation)this.instance).addAllRules(param1Iterable);
      return this;
    }
    
    public Builder addPages(int param1Int, Page.Builder param1Builder) {
      copyOnWrite();
      ((Documentation)this.instance).addPages(param1Int, param1Builder);
      return this;
    }
    
    public Builder addPages(int param1Int, Page param1Page) {
      copyOnWrite();
      ((Documentation)this.instance).addPages(param1Int, param1Page);
      return this;
    }
    
    public Builder addPages(Page.Builder param1Builder) {
      copyOnWrite();
      ((Documentation)this.instance).addPages(param1Builder);
      return this;
    }
    
    public Builder addPages(Page param1Page) {
      copyOnWrite();
      ((Documentation)this.instance).addPages(param1Page);
      return this;
    }
    
    public Builder addRules(int param1Int, DocumentationRule.Builder param1Builder) {
      copyOnWrite();
      ((Documentation)this.instance).addRules(param1Int, param1Builder);
      return this;
    }
    
    public Builder addRules(int param1Int, DocumentationRule param1DocumentationRule) {
      copyOnWrite();
      ((Documentation)this.instance).addRules(param1Int, param1DocumentationRule);
      return this;
    }
    
    public Builder addRules(DocumentationRule.Builder param1Builder) {
      copyOnWrite();
      ((Documentation)this.instance).addRules(param1Builder);
      return this;
    }
    
    public Builder addRules(DocumentationRule param1DocumentationRule) {
      copyOnWrite();
      ((Documentation)this.instance).addRules(param1DocumentationRule);
      return this;
    }
    
    public Builder clearDocumentationRootUrl() {
      copyOnWrite();
      ((Documentation)this.instance).clearDocumentationRootUrl();
      return this;
    }
    
    public Builder clearOverview() {
      copyOnWrite();
      ((Documentation)this.instance).clearOverview();
      return this;
    }
    
    public Builder clearPages() {
      copyOnWrite();
      ((Documentation)this.instance).clearPages();
      return this;
    }
    
    public Builder clearRules() {
      copyOnWrite();
      ((Documentation)this.instance).clearRules();
      return this;
    }
    
    public Builder clearSummary() {
      copyOnWrite();
      ((Documentation)this.instance).clearSummary();
      return this;
    }
    
    public String getDocumentationRootUrl() {
      return ((Documentation)this.instance).getDocumentationRootUrl();
    }
    
    public ByteString getDocumentationRootUrlBytes() {
      return ((Documentation)this.instance).getDocumentationRootUrlBytes();
    }
    
    public String getOverview() {
      return ((Documentation)this.instance).getOverview();
    }
    
    public ByteString getOverviewBytes() {
      return ((Documentation)this.instance).getOverviewBytes();
    }
    
    public Page getPages(int param1Int) {
      return ((Documentation)this.instance).getPages(param1Int);
    }
    
    public int getPagesCount() {
      return ((Documentation)this.instance).getPagesCount();
    }
    
    public List<Page> getPagesList() {
      return Collections.unmodifiableList(((Documentation)this.instance).getPagesList());
    }
    
    public DocumentationRule getRules(int param1Int) {
      return ((Documentation)this.instance).getRules(param1Int);
    }
    
    public int getRulesCount() {
      return ((Documentation)this.instance).getRulesCount();
    }
    
    public List<DocumentationRule> getRulesList() {
      return Collections.unmodifiableList(((Documentation)this.instance).getRulesList());
    }
    
    public String getSummary() {
      return ((Documentation)this.instance).getSummary();
    }
    
    public ByteString getSummaryBytes() {
      return ((Documentation)this.instance).getSummaryBytes();
    }
    
    public Builder removePages(int param1Int) {
      copyOnWrite();
      ((Documentation)this.instance).removePages(param1Int);
      return this;
    }
    
    public Builder removeRules(int param1Int) {
      copyOnWrite();
      ((Documentation)this.instance).removeRules(param1Int);
      return this;
    }
    
    public Builder setDocumentationRootUrl(String param1String) {
      copyOnWrite();
      ((Documentation)this.instance).setDocumentationRootUrl(param1String);
      return this;
    }
    
    public Builder setDocumentationRootUrlBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Documentation)this.instance).setDocumentationRootUrlBytes(param1ByteString);
      return this;
    }
    
    public Builder setOverview(String param1String) {
      copyOnWrite();
      ((Documentation)this.instance).setOverview(param1String);
      return this;
    }
    
    public Builder setOverviewBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Documentation)this.instance).setOverviewBytes(param1ByteString);
      return this;
    }
    
    public Builder setPages(int param1Int, Page.Builder param1Builder) {
      copyOnWrite();
      ((Documentation)this.instance).setPages(param1Int, param1Builder);
      return this;
    }
    
    public Builder setPages(int param1Int, Page param1Page) {
      copyOnWrite();
      ((Documentation)this.instance).setPages(param1Int, param1Page);
      return this;
    }
    
    public Builder setRules(int param1Int, DocumentationRule.Builder param1Builder) {
      copyOnWrite();
      ((Documentation)this.instance).setRules(param1Int, param1Builder);
      return this;
    }
    
    public Builder setRules(int param1Int, DocumentationRule param1DocumentationRule) {
      copyOnWrite();
      ((Documentation)this.instance).setRules(param1Int, param1DocumentationRule);
      return this;
    }
    
    public Builder setSummary(String param1String) {
      copyOnWrite();
      ((Documentation)this.instance).setSummary(param1String);
      return this;
    }
    
    public Builder setSummaryBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Documentation)this.instance).setSummaryBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\Documentation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */