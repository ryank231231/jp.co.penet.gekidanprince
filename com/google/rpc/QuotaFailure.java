package com.google.rpc;

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

public final class QuotaFailure extends GeneratedMessageLite<QuotaFailure, QuotaFailure.Builder> implements QuotaFailureOrBuilder {
  private static final QuotaFailure DEFAULT_INSTANCE = new QuotaFailure();
  
  private static volatile Parser<QuotaFailure> PARSER;
  
  public static final int VIOLATIONS_FIELD_NUMBER = 1;
  
  private Internal.ProtobufList<Violation> violations_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllViolations(Iterable<? extends Violation> paramIterable) {
    ensureViolationsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.violations_);
  }
  
  private void addViolations(int paramInt, Violation.Builder paramBuilder) {
    ensureViolationsIsMutable();
    this.violations_.add(paramInt, paramBuilder.build());
  }
  
  private void addViolations(int paramInt, Violation paramViolation) {
    if (paramViolation != null) {
      ensureViolationsIsMutable();
      this.violations_.add(paramInt, paramViolation);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addViolations(Violation.Builder paramBuilder) {
    ensureViolationsIsMutable();
    this.violations_.add(paramBuilder.build());
  }
  
  private void addViolations(Violation paramViolation) {
    if (paramViolation != null) {
      ensureViolationsIsMutable();
      this.violations_.add(paramViolation);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearViolations() {
    this.violations_ = emptyProtobufList();
  }
  
  private void ensureViolationsIsMutable() {
    if (!this.violations_.isModifiable())
      this.violations_ = GeneratedMessageLite.mutableCopy(this.violations_); 
  }
  
  public static QuotaFailure getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(QuotaFailure paramQuotaFailure) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramQuotaFailure);
  }
  
  public static QuotaFailure parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (QuotaFailure)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static QuotaFailure parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (QuotaFailure)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static QuotaFailure parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (QuotaFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static QuotaFailure parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (QuotaFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static QuotaFailure parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (QuotaFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static QuotaFailure parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (QuotaFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static QuotaFailure parseFrom(InputStream paramInputStream) throws IOException {
    return (QuotaFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static QuotaFailure parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (QuotaFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static QuotaFailure parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (QuotaFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static QuotaFailure parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (QuotaFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<QuotaFailure> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeViolations(int paramInt) {
    ensureViolationsIsMutable();
    this.violations_.remove(paramInt);
  }
  
  private void setViolations(int paramInt, Violation.Builder paramBuilder) {
    ensureViolationsIsMutable();
    this.violations_.set(paramInt, paramBuilder.build());
  }
  
  private void setViolations(int paramInt, Violation paramViolation) {
    if (paramViolation != null) {
      ensureViolationsIsMutable();
      this.violations_.set(paramInt, paramViolation);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/rpc/QuotaFailure$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 326, 2 -> 322, 3 -> 311, 4 -> 302, 5 -> 268, 6 -> 110, 7 -> 264, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/rpc/QuotaFailure.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/rpc/QuotaFailure
    //   72: monitorenter
    //   73: getstatic com/google/rpc/QuotaFailure.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/rpc/QuotaFailure.DEFAULT_INSTANCE : Lcom/google/rpc/QuotaFailure;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/rpc/QuotaFailure.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/rpc/QuotaFailure
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/rpc/QuotaFailure
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/rpc/QuotaFailure.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 264
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 208
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 161
    //   146: aload_1
    //   147: iload #5
    //   149: invokevirtual skipField : (I)Z
    //   152: ifne -> 123
    //   155: iconst_1
    //   156: istore #4
    //   158: goto -> 123
    //   161: aload_0
    //   162: getfield violations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   165: invokeinterface isModifiable : ()Z
    //   170: ifne -> 184
    //   173: aload_0
    //   174: aload_0
    //   175: getfield violations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   178: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   181: putfield violations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   184: aload_0
    //   185: getfield violations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   188: aload_1
    //   189: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   192: aload_2
    //   193: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   196: checkcast com/google/rpc/QuotaFailure$Violation
    //   199: invokeinterface add : (Ljava/lang/Object;)Z
    //   204: pop
    //   205: goto -> 123
    //   208: iconst_1
    //   209: istore #4
    //   211: goto -> 123
    //   214: astore_1
    //   215: goto -> 262
    //   218: astore_1
    //   219: new java/lang/RuntimeException
    //   222: astore_2
    //   223: new com/google/protobuf/InvalidProtocolBufferException
    //   226: astore_3
    //   227: aload_3
    //   228: aload_1
    //   229: invokevirtual getMessage : ()Ljava/lang/String;
    //   232: invokespecial <init> : (Ljava/lang/String;)V
    //   235: aload_2
    //   236: aload_3
    //   237: aload_0
    //   238: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   241: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   244: aload_2
    //   245: athrow
    //   246: astore_1
    //   247: new java/lang/RuntimeException
    //   250: astore_2
    //   251: aload_2
    //   252: aload_1
    //   253: aload_0
    //   254: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   257: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   260: aload_2
    //   261: athrow
    //   262: aload_1
    //   263: athrow
    //   264: getstatic com/google/rpc/QuotaFailure.DEFAULT_INSTANCE : Lcom/google/rpc/QuotaFailure;
    //   267: areturn
    //   268: aload_2
    //   269: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   272: astore_1
    //   273: aload_3
    //   274: checkcast com/google/rpc/QuotaFailure
    //   277: astore_2
    //   278: aload_0
    //   279: aload_1
    //   280: aload_0
    //   281: getfield violations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   284: aload_2
    //   285: getfield violations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   288: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   293: putfield violations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   296: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   299: astore_1
    //   300: aload_0
    //   301: areturn
    //   302: new com/google/rpc/QuotaFailure$Builder
    //   305: dup
    //   306: aconst_null
    //   307: invokespecial <init> : (Lcom/google/rpc/QuotaFailure$1;)V
    //   310: areturn
    //   311: aload_0
    //   312: getfield violations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   315: invokeinterface makeImmutable : ()V
    //   320: aconst_null
    //   321: areturn
    //   322: getstatic com/google/rpc/QuotaFailure.DEFAULT_INSTANCE : Lcom/google/rpc/QuotaFailure;
    //   325: areturn
    //   326: new com/google/rpc/QuotaFailure
    //   329: dup
    //   330: invokespecial <init> : ()V
    //   333: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	246	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	218	java/io/IOException
    //   128	134	214	finally
    //   146	155	246	com/google/protobuf/InvalidProtocolBufferException
    //   146	155	218	java/io/IOException
    //   146	155	214	finally
    //   161	184	246	com/google/protobuf/InvalidProtocolBufferException
    //   161	184	218	java/io/IOException
    //   161	184	214	finally
    //   184	205	246	com/google/protobuf/InvalidProtocolBufferException
    //   184	205	218	java/io/IOException
    //   184	205	214	finally
    //   219	246	214	finally
    //   247	262	214	finally
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    int j = 0;
    while (i < this.violations_.size()) {
      j += CodedOutputStream.computeMessageSize(1, (MessageLite)this.violations_.get(i));
      i++;
    } 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public Violation getViolations(int paramInt) {
    return (Violation)this.violations_.get(paramInt);
  }
  
  public int getViolationsCount() {
    return this.violations_.size();
  }
  
  public List<Violation> getViolationsList() {
    return (List<Violation>)this.violations_;
  }
  
  public ViolationOrBuilder getViolationsOrBuilder(int paramInt) {
    return (ViolationOrBuilder)this.violations_.get(paramInt);
  }
  
  public List<? extends ViolationOrBuilder> getViolationsOrBuilderList() {
    return (List)this.violations_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (byte b = 0; b < this.violations_.size(); b++)
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.violations_.get(b)); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<QuotaFailure, Builder> implements QuotaFailureOrBuilder {
    private Builder() {
      super(QuotaFailure.DEFAULT_INSTANCE);
    }
    
    public Builder addAllViolations(Iterable<? extends QuotaFailure.Violation> param1Iterable) {
      copyOnWrite();
      ((QuotaFailure)this.instance).addAllViolations(param1Iterable);
      return this;
    }
    
    public Builder addViolations(int param1Int, QuotaFailure.Violation.Builder param1Builder) {
      copyOnWrite();
      ((QuotaFailure)this.instance).addViolations(param1Int, param1Builder);
      return this;
    }
    
    public Builder addViolations(int param1Int, QuotaFailure.Violation param1Violation) {
      copyOnWrite();
      ((QuotaFailure)this.instance).addViolations(param1Int, param1Violation);
      return this;
    }
    
    public Builder addViolations(QuotaFailure.Violation.Builder param1Builder) {
      copyOnWrite();
      ((QuotaFailure)this.instance).addViolations(param1Builder);
      return this;
    }
    
    public Builder addViolations(QuotaFailure.Violation param1Violation) {
      copyOnWrite();
      ((QuotaFailure)this.instance).addViolations(param1Violation);
      return this;
    }
    
    public Builder clearViolations() {
      copyOnWrite();
      ((QuotaFailure)this.instance).clearViolations();
      return this;
    }
    
    public QuotaFailure.Violation getViolations(int param1Int) {
      return ((QuotaFailure)this.instance).getViolations(param1Int);
    }
    
    public int getViolationsCount() {
      return ((QuotaFailure)this.instance).getViolationsCount();
    }
    
    public List<QuotaFailure.Violation> getViolationsList() {
      return Collections.unmodifiableList(((QuotaFailure)this.instance).getViolationsList());
    }
    
    public Builder removeViolations(int param1Int) {
      copyOnWrite();
      ((QuotaFailure)this.instance).removeViolations(param1Int);
      return this;
    }
    
    public Builder setViolations(int param1Int, QuotaFailure.Violation.Builder param1Builder) {
      copyOnWrite();
      ((QuotaFailure)this.instance).setViolations(param1Int, param1Builder);
      return this;
    }
    
    public Builder setViolations(int param1Int, QuotaFailure.Violation param1Violation) {
      copyOnWrite();
      ((QuotaFailure)this.instance).setViolations(param1Int, param1Violation);
      return this;
    }
  }
  
  public static final class Violation extends GeneratedMessageLite<Violation, Violation.Builder> implements ViolationOrBuilder {
    private static final Violation DEFAULT_INSTANCE = new Violation();
    
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    
    private static volatile Parser<Violation> PARSER;
    
    public static final int SUBJECT_FIELD_NUMBER = 1;
    
    private String description_ = "";
    
    private String subject_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearDescription() {
      this.description_ = getDefaultInstance().getDescription();
    }
    
    private void clearSubject() {
      this.subject_ = getDefaultInstance().getSubject();
    }
    
    public static Violation getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Violation param1Violation) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1Violation);
    }
    
    public static Violation parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Violation)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Violation parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Violation)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Violation parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Violation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static Violation parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Violation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Violation parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Violation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static Violation parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Violation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Violation parseFrom(InputStream param1InputStream) throws IOException {
      return (Violation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Violation parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Violation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Violation parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Violation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static Violation parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Violation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Violation> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setDescription(String param1String) {
      if (param1String != null) {
        this.description_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setDescriptionBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.description_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setSubject(String param1String) {
      if (param1String != null) {
        this.subject_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setSubjectBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.subject_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/rpc/QuotaFailure$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 353, 2 -> 349, 3 -> 347, 4 -> 338, 5 -> 250, 6 -> 110, 7 -> 246, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/rpc/QuotaFailure$Violation.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/rpc/QuotaFailure$Violation
      //   72: monitorenter
      //   73: getstatic com/google/rpc/QuotaFailure$Violation.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/rpc/QuotaFailure$Violation.DEFAULT_INSTANCE : Lcom/google/rpc/QuotaFailure$Violation;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/rpc/QuotaFailure$Violation.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/rpc/QuotaFailure$Violation
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/rpc/QuotaFailure$Violation
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/rpc/QuotaFailure$Violation.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 246
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 190
      //   139: iload #5
      //   141: bipush #10
      //   143: if_icmpeq -> 179
      //   146: iload #5
      //   148: bipush #18
      //   150: if_icmpeq -> 168
      //   153: aload_1
      //   154: iload #5
      //   156: invokevirtual skipField : (I)Z
      //   159: ifne -> 123
      //   162: iconst_1
      //   163: istore #4
      //   165: goto -> 123
      //   168: aload_0
      //   169: aload_1
      //   170: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   173: putfield description_ : Ljava/lang/String;
      //   176: goto -> 123
      //   179: aload_0
      //   180: aload_1
      //   181: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   184: putfield subject_ : Ljava/lang/String;
      //   187: goto -> 123
      //   190: iconst_1
      //   191: istore #4
      //   193: goto -> 123
      //   196: astore_1
      //   197: goto -> 244
      //   200: astore_1
      //   201: new java/lang/RuntimeException
      //   204: astore_2
      //   205: new com/google/protobuf/InvalidProtocolBufferException
      //   208: astore_3
      //   209: aload_3
      //   210: aload_1
      //   211: invokevirtual getMessage : ()Ljava/lang/String;
      //   214: invokespecial <init> : (Ljava/lang/String;)V
      //   217: aload_2
      //   218: aload_3
      //   219: aload_0
      //   220: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   223: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   226: aload_2
      //   227: athrow
      //   228: astore_2
      //   229: new java/lang/RuntimeException
      //   232: astore_1
      //   233: aload_1
      //   234: aload_2
      //   235: aload_0
      //   236: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   239: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   242: aload_1
      //   243: athrow
      //   244: aload_1
      //   245: athrow
      //   246: getstatic com/google/rpc/QuotaFailure$Violation.DEFAULT_INSTANCE : Lcom/google/rpc/QuotaFailure$Violation;
      //   249: areturn
      //   250: aload_2
      //   251: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   254: astore_1
      //   255: aload_3
      //   256: checkcast com/google/rpc/QuotaFailure$Violation
      //   259: astore_2
      //   260: aload_0
      //   261: aload_1
      //   262: aload_0
      //   263: getfield subject_ : Ljava/lang/String;
      //   266: invokevirtual isEmpty : ()Z
      //   269: iconst_1
      //   270: ixor
      //   271: aload_0
      //   272: getfield subject_ : Ljava/lang/String;
      //   275: aload_2
      //   276: getfield subject_ : Ljava/lang/String;
      //   279: invokevirtual isEmpty : ()Z
      //   282: iconst_1
      //   283: ixor
      //   284: aload_2
      //   285: getfield subject_ : Ljava/lang/String;
      //   288: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   293: putfield subject_ : Ljava/lang/String;
      //   296: aload_0
      //   297: aload_1
      //   298: aload_0
      //   299: getfield description_ : Ljava/lang/String;
      //   302: invokevirtual isEmpty : ()Z
      //   305: iconst_1
      //   306: ixor
      //   307: aload_0
      //   308: getfield description_ : Ljava/lang/String;
      //   311: iconst_1
      //   312: aload_2
      //   313: getfield description_ : Ljava/lang/String;
      //   316: invokevirtual isEmpty : ()Z
      //   319: ixor
      //   320: aload_2
      //   321: getfield description_ : Ljava/lang/String;
      //   324: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   329: putfield description_ : Ljava/lang/String;
      //   332: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   335: astore_1
      //   336: aload_0
      //   337: areturn
      //   338: new com/google/rpc/QuotaFailure$Violation$Builder
      //   341: dup
      //   342: aconst_null
      //   343: invokespecial <init> : (Lcom/google/rpc/QuotaFailure$1;)V
      //   346: areturn
      //   347: aconst_null
      //   348: areturn
      //   349: getstatic com/google/rpc/QuotaFailure$Violation.DEFAULT_INSTANCE : Lcom/google/rpc/QuotaFailure$Violation;
      //   352: areturn
      //   353: new com/google/rpc/QuotaFailure$Violation
      //   356: dup
      //   357: invokespecial <init> : ()V
      //   360: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	228	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	200	java/io/IOException
      //   128	134	196	finally
      //   153	162	228	com/google/protobuf/InvalidProtocolBufferException
      //   153	162	200	java/io/IOException
      //   153	162	196	finally
      //   168	176	228	com/google/protobuf/InvalidProtocolBufferException
      //   168	176	200	java/io/IOException
      //   168	176	196	finally
      //   179	187	228	com/google/protobuf/InvalidProtocolBufferException
      //   179	187	200	java/io/IOException
      //   179	187	196	finally
      //   201	228	196	finally
      //   229	244	196	finally
    }
    
    public String getDescription() {
      return this.description_;
    }
    
    public ByteString getDescriptionBytes() {
      return ByteString.copyFromUtf8(this.description_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (!this.subject_.isEmpty())
        i = 0 + CodedOutputStream.computeStringSize(1, getSubject()); 
      int j = i;
      if (!this.description_.isEmpty())
        j = i + CodedOutputStream.computeStringSize(2, getDescription()); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public String getSubject() {
      return this.subject_;
    }
    
    public ByteString getSubjectBytes() {
      return ByteString.copyFromUtf8(this.subject_);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.subject_.isEmpty())
        param1CodedOutputStream.writeString(1, getSubject()); 
      if (!this.description_.isEmpty())
        param1CodedOutputStream.writeString(2, getDescription()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Violation, Builder> implements QuotaFailure.ViolationOrBuilder {
      private Builder() {
        super(QuotaFailure.Violation.DEFAULT_INSTANCE);
      }
      
      public Builder clearDescription() {
        copyOnWrite();
        ((QuotaFailure.Violation)this.instance).clearDescription();
        return this;
      }
      
      public Builder clearSubject() {
        copyOnWrite();
        ((QuotaFailure.Violation)this.instance).clearSubject();
        return this;
      }
      
      public String getDescription() {
        return ((QuotaFailure.Violation)this.instance).getDescription();
      }
      
      public ByteString getDescriptionBytes() {
        return ((QuotaFailure.Violation)this.instance).getDescriptionBytes();
      }
      
      public String getSubject() {
        return ((QuotaFailure.Violation)this.instance).getSubject();
      }
      
      public ByteString getSubjectBytes() {
        return ((QuotaFailure.Violation)this.instance).getSubjectBytes();
      }
      
      public Builder setDescription(String param2String) {
        copyOnWrite();
        ((QuotaFailure.Violation)this.instance).setDescription(param2String);
        return this;
      }
      
      public Builder setDescriptionBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((QuotaFailure.Violation)this.instance).setDescriptionBytes(param2ByteString);
        return this;
      }
      
      public Builder setSubject(String param2String) {
        copyOnWrite();
        ((QuotaFailure.Violation)this.instance).setSubject(param2String);
        return this;
      }
      
      public Builder setSubjectBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((QuotaFailure.Violation)this.instance).setSubjectBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Violation, Violation.Builder> implements ViolationOrBuilder {
    private Builder() {
      super(QuotaFailure.Violation.DEFAULT_INSTANCE);
    }
    
    public Builder clearDescription() {
      copyOnWrite();
      ((QuotaFailure.Violation)this.instance).clearDescription();
      return this;
    }
    
    public Builder clearSubject() {
      copyOnWrite();
      ((QuotaFailure.Violation)this.instance).clearSubject();
      return this;
    }
    
    public String getDescription() {
      return ((QuotaFailure.Violation)this.instance).getDescription();
    }
    
    public ByteString getDescriptionBytes() {
      return ((QuotaFailure.Violation)this.instance).getDescriptionBytes();
    }
    
    public String getSubject() {
      return ((QuotaFailure.Violation)this.instance).getSubject();
    }
    
    public ByteString getSubjectBytes() {
      return ((QuotaFailure.Violation)this.instance).getSubjectBytes();
    }
    
    public Builder setDescription(String param1String) {
      copyOnWrite();
      ((QuotaFailure.Violation)this.instance).setDescription(param1String);
      return this;
    }
    
    public Builder setDescriptionBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((QuotaFailure.Violation)this.instance).setDescriptionBytes(param1ByteString);
      return this;
    }
    
    public Builder setSubject(String param1String) {
      copyOnWrite();
      ((QuotaFailure.Violation)this.instance).setSubject(param1String);
      return this;
    }
    
    public Builder setSubjectBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((QuotaFailure.Violation)this.instance).setSubjectBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface ViolationOrBuilder extends MessageLiteOrBuilder {
    String getDescription();
    
    ByteString getDescriptionBytes();
    
    String getSubject();
    
    ByteString getSubjectBytes();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\rpc\QuotaFailure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */