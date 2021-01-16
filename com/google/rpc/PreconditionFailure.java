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

public final class PreconditionFailure extends GeneratedMessageLite<PreconditionFailure, PreconditionFailure.Builder> implements PreconditionFailureOrBuilder {
  private static final PreconditionFailure DEFAULT_INSTANCE = new PreconditionFailure();
  
  private static volatile Parser<PreconditionFailure> PARSER;
  
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
  
  public static PreconditionFailure getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(PreconditionFailure paramPreconditionFailure) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramPreconditionFailure);
  }
  
  public static PreconditionFailure parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (PreconditionFailure)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static PreconditionFailure parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (PreconditionFailure)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static PreconditionFailure parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (PreconditionFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static PreconditionFailure parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (PreconditionFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static PreconditionFailure parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (PreconditionFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static PreconditionFailure parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (PreconditionFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static PreconditionFailure parseFrom(InputStream paramInputStream) throws IOException {
    return (PreconditionFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static PreconditionFailure parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (PreconditionFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static PreconditionFailure parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (PreconditionFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static PreconditionFailure parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (PreconditionFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<PreconditionFailure> parser() {
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
    //   0: getstatic com/google/rpc/PreconditionFailure$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 326, 2 -> 322, 3 -> 311, 4 -> 302, 5 -> 268, 6 -> 110, 7 -> 264, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/rpc/PreconditionFailure.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/rpc/PreconditionFailure
    //   72: monitorenter
    //   73: getstatic com/google/rpc/PreconditionFailure.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/rpc/PreconditionFailure.DEFAULT_INSTANCE : Lcom/google/rpc/PreconditionFailure;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/rpc/PreconditionFailure.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/rpc/PreconditionFailure
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/rpc/PreconditionFailure
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/rpc/PreconditionFailure.PARSER : Lcom/google/protobuf/Parser;
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
    //   196: checkcast com/google/rpc/PreconditionFailure$Violation
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
    //   264: getstatic com/google/rpc/PreconditionFailure.DEFAULT_INSTANCE : Lcom/google/rpc/PreconditionFailure;
    //   267: areturn
    //   268: aload_2
    //   269: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   272: astore_1
    //   273: aload_3
    //   274: checkcast com/google/rpc/PreconditionFailure
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
    //   302: new com/google/rpc/PreconditionFailure$Builder
    //   305: dup
    //   306: aconst_null
    //   307: invokespecial <init> : (Lcom/google/rpc/PreconditionFailure$1;)V
    //   310: areturn
    //   311: aload_0
    //   312: getfield violations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   315: invokeinterface makeImmutable : ()V
    //   320: aconst_null
    //   321: areturn
    //   322: getstatic com/google/rpc/PreconditionFailure.DEFAULT_INSTANCE : Lcom/google/rpc/PreconditionFailure;
    //   325: areturn
    //   326: new com/google/rpc/PreconditionFailure
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
    byte b = 0;
    i = 0;
    while (b < this.violations_.size()) {
      i += CodedOutputStream.computeMessageSize(1, (MessageLite)this.violations_.get(b));
      b++;
    } 
    this.memoizedSerializedSize = i;
    return i;
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
  
  public static final class Builder extends GeneratedMessageLite.Builder<PreconditionFailure, Builder> implements PreconditionFailureOrBuilder {
    private Builder() {
      super(PreconditionFailure.DEFAULT_INSTANCE);
    }
    
    public Builder addAllViolations(Iterable<? extends PreconditionFailure.Violation> param1Iterable) {
      copyOnWrite();
      ((PreconditionFailure)this.instance).addAllViolations(param1Iterable);
      return this;
    }
    
    public Builder addViolations(int param1Int, PreconditionFailure.Violation.Builder param1Builder) {
      copyOnWrite();
      ((PreconditionFailure)this.instance).addViolations(param1Int, param1Builder);
      return this;
    }
    
    public Builder addViolations(int param1Int, PreconditionFailure.Violation param1Violation) {
      copyOnWrite();
      ((PreconditionFailure)this.instance).addViolations(param1Int, param1Violation);
      return this;
    }
    
    public Builder addViolations(PreconditionFailure.Violation.Builder param1Builder) {
      copyOnWrite();
      ((PreconditionFailure)this.instance).addViolations(param1Builder);
      return this;
    }
    
    public Builder addViolations(PreconditionFailure.Violation param1Violation) {
      copyOnWrite();
      ((PreconditionFailure)this.instance).addViolations(param1Violation);
      return this;
    }
    
    public Builder clearViolations() {
      copyOnWrite();
      ((PreconditionFailure)this.instance).clearViolations();
      return this;
    }
    
    public PreconditionFailure.Violation getViolations(int param1Int) {
      return ((PreconditionFailure)this.instance).getViolations(param1Int);
    }
    
    public int getViolationsCount() {
      return ((PreconditionFailure)this.instance).getViolationsCount();
    }
    
    public List<PreconditionFailure.Violation> getViolationsList() {
      return Collections.unmodifiableList(((PreconditionFailure)this.instance).getViolationsList());
    }
    
    public Builder removeViolations(int param1Int) {
      copyOnWrite();
      ((PreconditionFailure)this.instance).removeViolations(param1Int);
      return this;
    }
    
    public Builder setViolations(int param1Int, PreconditionFailure.Violation.Builder param1Builder) {
      copyOnWrite();
      ((PreconditionFailure)this.instance).setViolations(param1Int, param1Builder);
      return this;
    }
    
    public Builder setViolations(int param1Int, PreconditionFailure.Violation param1Violation) {
      copyOnWrite();
      ((PreconditionFailure)this.instance).setViolations(param1Int, param1Violation);
      return this;
    }
  }
  
  public static final class Violation extends GeneratedMessageLite<Violation, Violation.Builder> implements ViolationOrBuilder {
    private static final Violation DEFAULT_INSTANCE = new Violation();
    
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    
    private static volatile Parser<Violation> PARSER;
    
    public static final int SUBJECT_FIELD_NUMBER = 2;
    
    public static final int TYPE_FIELD_NUMBER = 1;
    
    private String description_ = "";
    
    private String subject_ = "";
    
    private String type_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearDescription() {
      this.description_ = getDefaultInstance().getDescription();
    }
    
    private void clearSubject() {
      this.subject_ = getDefaultInstance().getSubject();
    }
    
    private void clearType() {
      this.type_ = getDefaultInstance().getType();
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
    
    private void setType(String param1String) {
      if (param1String != null) {
        this.type_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTypeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.type_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/rpc/PreconditionFailure$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 407, 2 -> 403, 3 -> 401, 4 -> 392, 5 -> 268, 6 -> 110, 7 -> 264, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/rpc/PreconditionFailure$Violation.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/rpc/PreconditionFailure$Violation
      //   72: monitorenter
      //   73: getstatic com/google/rpc/PreconditionFailure$Violation.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/rpc/PreconditionFailure$Violation.DEFAULT_INSTANCE : Lcom/google/rpc/PreconditionFailure$Violation;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/rpc/PreconditionFailure$Violation.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/rpc/PreconditionFailure$Violation
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/rpc/PreconditionFailure$Violation
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/rpc/PreconditionFailure$Violation.PARSER : Lcom/google/protobuf/Parser;
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
      //   143: if_icmpeq -> 197
      //   146: iload #5
      //   148: bipush #18
      //   150: if_icmpeq -> 186
      //   153: iload #5
      //   155: bipush #26
      //   157: if_icmpeq -> 175
      //   160: aload_1
      //   161: iload #5
      //   163: invokevirtual skipField : (I)Z
      //   166: ifne -> 123
      //   169: iconst_1
      //   170: istore #4
      //   172: goto -> 123
      //   175: aload_0
      //   176: aload_1
      //   177: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   180: putfield description_ : Ljava/lang/String;
      //   183: goto -> 123
      //   186: aload_0
      //   187: aload_1
      //   188: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   191: putfield subject_ : Ljava/lang/String;
      //   194: goto -> 123
      //   197: aload_0
      //   198: aload_1
      //   199: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   202: putfield type_ : Ljava/lang/String;
      //   205: goto -> 123
      //   208: iconst_1
      //   209: istore #4
      //   211: goto -> 123
      //   214: astore_1
      //   215: goto -> 262
      //   218: astore_2
      //   219: new java/lang/RuntimeException
      //   222: astore_3
      //   223: new com/google/protobuf/InvalidProtocolBufferException
      //   226: astore_1
      //   227: aload_1
      //   228: aload_2
      //   229: invokevirtual getMessage : ()Ljava/lang/String;
      //   232: invokespecial <init> : (Ljava/lang/String;)V
      //   235: aload_3
      //   236: aload_1
      //   237: aload_0
      //   238: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   241: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   244: aload_3
      //   245: athrow
      //   246: astore_2
      //   247: new java/lang/RuntimeException
      //   250: astore_1
      //   251: aload_1
      //   252: aload_2
      //   253: aload_0
      //   254: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   257: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   260: aload_1
      //   261: athrow
      //   262: aload_1
      //   263: athrow
      //   264: getstatic com/google/rpc/PreconditionFailure$Violation.DEFAULT_INSTANCE : Lcom/google/rpc/PreconditionFailure$Violation;
      //   267: areturn
      //   268: aload_2
      //   269: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   272: astore_1
      //   273: aload_3
      //   274: checkcast com/google/rpc/PreconditionFailure$Violation
      //   277: astore_2
      //   278: aload_0
      //   279: aload_1
      //   280: aload_0
      //   281: getfield type_ : Ljava/lang/String;
      //   284: invokevirtual isEmpty : ()Z
      //   287: iconst_1
      //   288: ixor
      //   289: aload_0
      //   290: getfield type_ : Ljava/lang/String;
      //   293: aload_2
      //   294: getfield type_ : Ljava/lang/String;
      //   297: invokevirtual isEmpty : ()Z
      //   300: iconst_1
      //   301: ixor
      //   302: aload_2
      //   303: getfield type_ : Ljava/lang/String;
      //   306: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   311: putfield type_ : Ljava/lang/String;
      //   314: aload_0
      //   315: aload_1
      //   316: aload_0
      //   317: getfield subject_ : Ljava/lang/String;
      //   320: invokevirtual isEmpty : ()Z
      //   323: iconst_1
      //   324: ixor
      //   325: aload_0
      //   326: getfield subject_ : Ljava/lang/String;
      //   329: aload_2
      //   330: getfield subject_ : Ljava/lang/String;
      //   333: invokevirtual isEmpty : ()Z
      //   336: iconst_1
      //   337: ixor
      //   338: aload_2
      //   339: getfield subject_ : Ljava/lang/String;
      //   342: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   347: putfield subject_ : Ljava/lang/String;
      //   350: aload_0
      //   351: aload_1
      //   352: aload_0
      //   353: getfield description_ : Ljava/lang/String;
      //   356: invokevirtual isEmpty : ()Z
      //   359: iconst_1
      //   360: ixor
      //   361: aload_0
      //   362: getfield description_ : Ljava/lang/String;
      //   365: iconst_1
      //   366: aload_2
      //   367: getfield description_ : Ljava/lang/String;
      //   370: invokevirtual isEmpty : ()Z
      //   373: ixor
      //   374: aload_2
      //   375: getfield description_ : Ljava/lang/String;
      //   378: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   383: putfield description_ : Ljava/lang/String;
      //   386: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   389: astore_1
      //   390: aload_0
      //   391: areturn
      //   392: new com/google/rpc/PreconditionFailure$Violation$Builder
      //   395: dup
      //   396: aconst_null
      //   397: invokespecial <init> : (Lcom/google/rpc/PreconditionFailure$1;)V
      //   400: areturn
      //   401: aconst_null
      //   402: areturn
      //   403: getstatic com/google/rpc/PreconditionFailure$Violation.DEFAULT_INSTANCE : Lcom/google/rpc/PreconditionFailure$Violation;
      //   406: areturn
      //   407: new com/google/rpc/PreconditionFailure$Violation
      //   410: dup
      //   411: invokespecial <init> : ()V
      //   414: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	246	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	218	java/io/IOException
      //   128	134	214	finally
      //   160	169	246	com/google/protobuf/InvalidProtocolBufferException
      //   160	169	218	java/io/IOException
      //   160	169	214	finally
      //   175	183	246	com/google/protobuf/InvalidProtocolBufferException
      //   175	183	218	java/io/IOException
      //   175	183	214	finally
      //   186	194	246	com/google/protobuf/InvalidProtocolBufferException
      //   186	194	218	java/io/IOException
      //   186	194	214	finally
      //   197	205	246	com/google/protobuf/InvalidProtocolBufferException
      //   197	205	218	java/io/IOException
      //   197	205	214	finally
      //   219	246	214	finally
      //   247	262	214	finally
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
      int j = 0;
      if (!this.type_.isEmpty())
        j = 0 + CodedOutputStream.computeStringSize(1, getType()); 
      i = j;
      if (!this.subject_.isEmpty())
        i = j + CodedOutputStream.computeStringSize(2, getSubject()); 
      j = i;
      if (!this.description_.isEmpty())
        j = i + CodedOutputStream.computeStringSize(3, getDescription()); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public String getSubject() {
      return this.subject_;
    }
    
    public ByteString getSubjectBytes() {
      return ByteString.copyFromUtf8(this.subject_);
    }
    
    public String getType() {
      return this.type_;
    }
    
    public ByteString getTypeBytes() {
      return ByteString.copyFromUtf8(this.type_);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.type_.isEmpty())
        param1CodedOutputStream.writeString(1, getType()); 
      if (!this.subject_.isEmpty())
        param1CodedOutputStream.writeString(2, getSubject()); 
      if (!this.description_.isEmpty())
        param1CodedOutputStream.writeString(3, getDescription()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Violation, Builder> implements PreconditionFailure.ViolationOrBuilder {
      private Builder() {
        super(PreconditionFailure.Violation.DEFAULT_INSTANCE);
      }
      
      public Builder clearDescription() {
        copyOnWrite();
        ((PreconditionFailure.Violation)this.instance).clearDescription();
        return this;
      }
      
      public Builder clearSubject() {
        copyOnWrite();
        ((PreconditionFailure.Violation)this.instance).clearSubject();
        return this;
      }
      
      public Builder clearType() {
        copyOnWrite();
        ((PreconditionFailure.Violation)this.instance).clearType();
        return this;
      }
      
      public String getDescription() {
        return ((PreconditionFailure.Violation)this.instance).getDescription();
      }
      
      public ByteString getDescriptionBytes() {
        return ((PreconditionFailure.Violation)this.instance).getDescriptionBytes();
      }
      
      public String getSubject() {
        return ((PreconditionFailure.Violation)this.instance).getSubject();
      }
      
      public ByteString getSubjectBytes() {
        return ((PreconditionFailure.Violation)this.instance).getSubjectBytes();
      }
      
      public String getType() {
        return ((PreconditionFailure.Violation)this.instance).getType();
      }
      
      public ByteString getTypeBytes() {
        return ((PreconditionFailure.Violation)this.instance).getTypeBytes();
      }
      
      public Builder setDescription(String param2String) {
        copyOnWrite();
        ((PreconditionFailure.Violation)this.instance).setDescription(param2String);
        return this;
      }
      
      public Builder setDescriptionBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((PreconditionFailure.Violation)this.instance).setDescriptionBytes(param2ByteString);
        return this;
      }
      
      public Builder setSubject(String param2String) {
        copyOnWrite();
        ((PreconditionFailure.Violation)this.instance).setSubject(param2String);
        return this;
      }
      
      public Builder setSubjectBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((PreconditionFailure.Violation)this.instance).setSubjectBytes(param2ByteString);
        return this;
      }
      
      public Builder setType(String param2String) {
        copyOnWrite();
        ((PreconditionFailure.Violation)this.instance).setType(param2String);
        return this;
      }
      
      public Builder setTypeBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((PreconditionFailure.Violation)this.instance).setTypeBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Violation, Violation.Builder> implements ViolationOrBuilder {
    private Builder() {
      super(PreconditionFailure.Violation.DEFAULT_INSTANCE);
    }
    
    public Builder clearDescription() {
      copyOnWrite();
      ((PreconditionFailure.Violation)this.instance).clearDescription();
      return this;
    }
    
    public Builder clearSubject() {
      copyOnWrite();
      ((PreconditionFailure.Violation)this.instance).clearSubject();
      return this;
    }
    
    public Builder clearType() {
      copyOnWrite();
      ((PreconditionFailure.Violation)this.instance).clearType();
      return this;
    }
    
    public String getDescription() {
      return ((PreconditionFailure.Violation)this.instance).getDescription();
    }
    
    public ByteString getDescriptionBytes() {
      return ((PreconditionFailure.Violation)this.instance).getDescriptionBytes();
    }
    
    public String getSubject() {
      return ((PreconditionFailure.Violation)this.instance).getSubject();
    }
    
    public ByteString getSubjectBytes() {
      return ((PreconditionFailure.Violation)this.instance).getSubjectBytes();
    }
    
    public String getType() {
      return ((PreconditionFailure.Violation)this.instance).getType();
    }
    
    public ByteString getTypeBytes() {
      return ((PreconditionFailure.Violation)this.instance).getTypeBytes();
    }
    
    public Builder setDescription(String param1String) {
      copyOnWrite();
      ((PreconditionFailure.Violation)this.instance).setDescription(param1String);
      return this;
    }
    
    public Builder setDescriptionBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PreconditionFailure.Violation)this.instance).setDescriptionBytes(param1ByteString);
      return this;
    }
    
    public Builder setSubject(String param1String) {
      copyOnWrite();
      ((PreconditionFailure.Violation)this.instance).setSubject(param1String);
      return this;
    }
    
    public Builder setSubjectBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PreconditionFailure.Violation)this.instance).setSubjectBytes(param1ByteString);
      return this;
    }
    
    public Builder setType(String param1String) {
      copyOnWrite();
      ((PreconditionFailure.Violation)this.instance).setType(param1String);
      return this;
    }
    
    public Builder setTypeBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PreconditionFailure.Violation)this.instance).setTypeBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface ViolationOrBuilder extends MessageLiteOrBuilder {
    String getDescription();
    
    ByteString getDescriptionBytes();
    
    String getSubject();
    
    ByteString getSubjectBytes();
    
    String getType();
    
    ByteString getTypeBytes();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\rpc\PreconditionFailure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */