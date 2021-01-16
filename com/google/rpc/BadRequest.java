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

public final class BadRequest extends GeneratedMessageLite<BadRequest, BadRequest.Builder> implements BadRequestOrBuilder {
  private static final BadRequest DEFAULT_INSTANCE = new BadRequest();
  
  public static final int FIELD_VIOLATIONS_FIELD_NUMBER = 1;
  
  private static volatile Parser<BadRequest> PARSER;
  
  private Internal.ProtobufList<FieldViolation> fieldViolations_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllFieldViolations(Iterable<? extends FieldViolation> paramIterable) {
    ensureFieldViolationsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.fieldViolations_);
  }
  
  private void addFieldViolations(int paramInt, FieldViolation.Builder paramBuilder) {
    ensureFieldViolationsIsMutable();
    this.fieldViolations_.add(paramInt, paramBuilder.build());
  }
  
  private void addFieldViolations(int paramInt, FieldViolation paramFieldViolation) {
    if (paramFieldViolation != null) {
      ensureFieldViolationsIsMutable();
      this.fieldViolations_.add(paramInt, paramFieldViolation);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addFieldViolations(FieldViolation.Builder paramBuilder) {
    ensureFieldViolationsIsMutable();
    this.fieldViolations_.add(paramBuilder.build());
  }
  
  private void addFieldViolations(FieldViolation paramFieldViolation) {
    if (paramFieldViolation != null) {
      ensureFieldViolationsIsMutable();
      this.fieldViolations_.add(paramFieldViolation);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearFieldViolations() {
    this.fieldViolations_ = emptyProtobufList();
  }
  
  private void ensureFieldViolationsIsMutable() {
    if (!this.fieldViolations_.isModifiable())
      this.fieldViolations_ = GeneratedMessageLite.mutableCopy(this.fieldViolations_); 
  }
  
  public static BadRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(BadRequest paramBadRequest) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramBadRequest);
  }
  
  public static BadRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (BadRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static BadRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (BadRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static BadRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (BadRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static BadRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (BadRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static BadRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (BadRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static BadRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (BadRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static BadRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (BadRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static BadRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (BadRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static BadRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (BadRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static BadRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (BadRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<BadRequest> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeFieldViolations(int paramInt) {
    ensureFieldViolationsIsMutable();
    this.fieldViolations_.remove(paramInt);
  }
  
  private void setFieldViolations(int paramInt, FieldViolation.Builder paramBuilder) {
    ensureFieldViolationsIsMutable();
    this.fieldViolations_.set(paramInt, paramBuilder.build());
  }
  
  private void setFieldViolations(int paramInt, FieldViolation paramFieldViolation) {
    if (paramFieldViolation != null) {
      ensureFieldViolationsIsMutable();
      this.fieldViolations_.set(paramInt, paramFieldViolation);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/rpc/BadRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 326, 2 -> 322, 3 -> 311, 4 -> 302, 5 -> 268, 6 -> 110, 7 -> 264, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/rpc/BadRequest.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/rpc/BadRequest
    //   72: monitorenter
    //   73: getstatic com/google/rpc/BadRequest.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/rpc/BadRequest.DEFAULT_INSTANCE : Lcom/google/rpc/BadRequest;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/rpc/BadRequest.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/rpc/BadRequest
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/rpc/BadRequest
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/rpc/BadRequest.PARSER : Lcom/google/protobuf/Parser;
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
    //   162: getfield fieldViolations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   165: invokeinterface isModifiable : ()Z
    //   170: ifne -> 184
    //   173: aload_0
    //   174: aload_0
    //   175: getfield fieldViolations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   178: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   181: putfield fieldViolations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   184: aload_0
    //   185: getfield fieldViolations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   188: aload_1
    //   189: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   192: aload_2
    //   193: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   196: checkcast com/google/rpc/BadRequest$FieldViolation
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
    //   264: getstatic com/google/rpc/BadRequest.DEFAULT_INSTANCE : Lcom/google/rpc/BadRequest;
    //   267: areturn
    //   268: aload_2
    //   269: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   272: astore_1
    //   273: aload_3
    //   274: checkcast com/google/rpc/BadRequest
    //   277: astore_2
    //   278: aload_0
    //   279: aload_1
    //   280: aload_0
    //   281: getfield fieldViolations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   284: aload_2
    //   285: getfield fieldViolations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   288: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   293: putfield fieldViolations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   296: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   299: astore_1
    //   300: aload_0
    //   301: areturn
    //   302: new com/google/rpc/BadRequest$Builder
    //   305: dup
    //   306: aconst_null
    //   307: invokespecial <init> : (Lcom/google/rpc/BadRequest$1;)V
    //   310: areturn
    //   311: aload_0
    //   312: getfield fieldViolations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   315: invokeinterface makeImmutable : ()V
    //   320: aconst_null
    //   321: areturn
    //   322: getstatic com/google/rpc/BadRequest.DEFAULT_INSTANCE : Lcom/google/rpc/BadRequest;
    //   325: areturn
    //   326: new com/google/rpc/BadRequest
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
  
  public FieldViolation getFieldViolations(int paramInt) {
    return (FieldViolation)this.fieldViolations_.get(paramInt);
  }
  
  public int getFieldViolationsCount() {
    return this.fieldViolations_.size();
  }
  
  public List<FieldViolation> getFieldViolationsList() {
    return (List<FieldViolation>)this.fieldViolations_;
  }
  
  public FieldViolationOrBuilder getFieldViolationsOrBuilder(int paramInt) {
    return (FieldViolationOrBuilder)this.fieldViolations_.get(paramInt);
  }
  
  public List<? extends FieldViolationOrBuilder> getFieldViolationsOrBuilderList() {
    return (List)this.fieldViolations_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    byte b = 0;
    i = 0;
    while (b < this.fieldViolations_.size()) {
      i += CodedOutputStream.computeMessageSize(1, (MessageLite)this.fieldViolations_.get(b));
      b++;
    } 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (byte b = 0; b < this.fieldViolations_.size(); b++)
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.fieldViolations_.get(b)); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<BadRequest, Builder> implements BadRequestOrBuilder {
    private Builder() {
      super(BadRequest.DEFAULT_INSTANCE);
    }
    
    public Builder addAllFieldViolations(Iterable<? extends BadRequest.FieldViolation> param1Iterable) {
      copyOnWrite();
      ((BadRequest)this.instance).addAllFieldViolations(param1Iterable);
      return this;
    }
    
    public Builder addFieldViolations(int param1Int, BadRequest.FieldViolation.Builder param1Builder) {
      copyOnWrite();
      ((BadRequest)this.instance).addFieldViolations(param1Int, param1Builder);
      return this;
    }
    
    public Builder addFieldViolations(int param1Int, BadRequest.FieldViolation param1FieldViolation) {
      copyOnWrite();
      ((BadRequest)this.instance).addFieldViolations(param1Int, param1FieldViolation);
      return this;
    }
    
    public Builder addFieldViolations(BadRequest.FieldViolation.Builder param1Builder) {
      copyOnWrite();
      ((BadRequest)this.instance).addFieldViolations(param1Builder);
      return this;
    }
    
    public Builder addFieldViolations(BadRequest.FieldViolation param1FieldViolation) {
      copyOnWrite();
      ((BadRequest)this.instance).addFieldViolations(param1FieldViolation);
      return this;
    }
    
    public Builder clearFieldViolations() {
      copyOnWrite();
      ((BadRequest)this.instance).clearFieldViolations();
      return this;
    }
    
    public BadRequest.FieldViolation getFieldViolations(int param1Int) {
      return ((BadRequest)this.instance).getFieldViolations(param1Int);
    }
    
    public int getFieldViolationsCount() {
      return ((BadRequest)this.instance).getFieldViolationsCount();
    }
    
    public List<BadRequest.FieldViolation> getFieldViolationsList() {
      return Collections.unmodifiableList(((BadRequest)this.instance).getFieldViolationsList());
    }
    
    public Builder removeFieldViolations(int param1Int) {
      copyOnWrite();
      ((BadRequest)this.instance).removeFieldViolations(param1Int);
      return this;
    }
    
    public Builder setFieldViolations(int param1Int, BadRequest.FieldViolation.Builder param1Builder) {
      copyOnWrite();
      ((BadRequest)this.instance).setFieldViolations(param1Int, param1Builder);
      return this;
    }
    
    public Builder setFieldViolations(int param1Int, BadRequest.FieldViolation param1FieldViolation) {
      copyOnWrite();
      ((BadRequest)this.instance).setFieldViolations(param1Int, param1FieldViolation);
      return this;
    }
  }
  
  public static final class FieldViolation extends GeneratedMessageLite<FieldViolation, FieldViolation.Builder> implements FieldViolationOrBuilder {
    private static final FieldViolation DEFAULT_INSTANCE = new FieldViolation();
    
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    
    public static final int FIELD_FIELD_NUMBER = 1;
    
    private static volatile Parser<FieldViolation> PARSER;
    
    private String description_ = "";
    
    private String field_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearDescription() {
      this.description_ = getDefaultInstance().getDescription();
    }
    
    private void clearField() {
      this.field_ = getDefaultInstance().getField();
    }
    
    public static FieldViolation getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(FieldViolation param1FieldViolation) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1FieldViolation);
    }
    
    public static FieldViolation parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (FieldViolation)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static FieldViolation parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FieldViolation)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FieldViolation parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (FieldViolation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static FieldViolation parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FieldViolation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static FieldViolation parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (FieldViolation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static FieldViolation parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FieldViolation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static FieldViolation parseFrom(InputStream param1InputStream) throws IOException {
      return (FieldViolation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static FieldViolation parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FieldViolation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FieldViolation parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (FieldViolation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static FieldViolation parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FieldViolation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<FieldViolation> parser() {
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
    
    private void setField(String param1String) {
      if (param1String != null) {
        this.field_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setFieldBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.field_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/rpc/BadRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 353, 2 -> 349, 3 -> 347, 4 -> 338, 5 -> 250, 6 -> 110, 7 -> 246, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/rpc/BadRequest$FieldViolation.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/rpc/BadRequest$FieldViolation
      //   72: monitorenter
      //   73: getstatic com/google/rpc/BadRequest$FieldViolation.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/rpc/BadRequest$FieldViolation.DEFAULT_INSTANCE : Lcom/google/rpc/BadRequest$FieldViolation;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/rpc/BadRequest$FieldViolation.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/rpc/BadRequest$FieldViolation
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/rpc/BadRequest$FieldViolation
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/rpc/BadRequest$FieldViolation.PARSER : Lcom/google/protobuf/Parser;
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
      //   184: putfield field_ : Ljava/lang/String;
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
      //   246: getstatic com/google/rpc/BadRequest$FieldViolation.DEFAULT_INSTANCE : Lcom/google/rpc/BadRequest$FieldViolation;
      //   249: areturn
      //   250: aload_2
      //   251: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   254: astore_1
      //   255: aload_3
      //   256: checkcast com/google/rpc/BadRequest$FieldViolation
      //   259: astore_2
      //   260: aload_0
      //   261: aload_1
      //   262: aload_0
      //   263: getfield field_ : Ljava/lang/String;
      //   266: invokevirtual isEmpty : ()Z
      //   269: iconst_1
      //   270: ixor
      //   271: aload_0
      //   272: getfield field_ : Ljava/lang/String;
      //   275: aload_2
      //   276: getfield field_ : Ljava/lang/String;
      //   279: invokevirtual isEmpty : ()Z
      //   282: iconst_1
      //   283: ixor
      //   284: aload_2
      //   285: getfield field_ : Ljava/lang/String;
      //   288: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   293: putfield field_ : Ljava/lang/String;
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
      //   338: new com/google/rpc/BadRequest$FieldViolation$Builder
      //   341: dup
      //   342: aconst_null
      //   343: invokespecial <init> : (Lcom/google/rpc/BadRequest$1;)V
      //   346: areturn
      //   347: aconst_null
      //   348: areturn
      //   349: getstatic com/google/rpc/BadRequest$FieldViolation.DEFAULT_INSTANCE : Lcom/google/rpc/BadRequest$FieldViolation;
      //   352: areturn
      //   353: new com/google/rpc/BadRequest$FieldViolation
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
    
    public String getField() {
      return this.field_;
    }
    
    public ByteString getFieldBytes() {
      return ByteString.copyFromUtf8(this.field_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (!this.field_.isEmpty())
        i = 0 + CodedOutputStream.computeStringSize(1, getField()); 
      int j = i;
      if (!this.description_.isEmpty())
        j = i + CodedOutputStream.computeStringSize(2, getDescription()); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.field_.isEmpty())
        param1CodedOutputStream.writeString(1, getField()); 
      if (!this.description_.isEmpty())
        param1CodedOutputStream.writeString(2, getDescription()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<FieldViolation, Builder> implements BadRequest.FieldViolationOrBuilder {
      private Builder() {
        super(BadRequest.FieldViolation.DEFAULT_INSTANCE);
      }
      
      public Builder clearDescription() {
        copyOnWrite();
        ((BadRequest.FieldViolation)this.instance).clearDescription();
        return this;
      }
      
      public Builder clearField() {
        copyOnWrite();
        ((BadRequest.FieldViolation)this.instance).clearField();
        return this;
      }
      
      public String getDescription() {
        return ((BadRequest.FieldViolation)this.instance).getDescription();
      }
      
      public ByteString getDescriptionBytes() {
        return ((BadRequest.FieldViolation)this.instance).getDescriptionBytes();
      }
      
      public String getField() {
        return ((BadRequest.FieldViolation)this.instance).getField();
      }
      
      public ByteString getFieldBytes() {
        return ((BadRequest.FieldViolation)this.instance).getFieldBytes();
      }
      
      public Builder setDescription(String param2String) {
        copyOnWrite();
        ((BadRequest.FieldViolation)this.instance).setDescription(param2String);
        return this;
      }
      
      public Builder setDescriptionBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((BadRequest.FieldViolation)this.instance).setDescriptionBytes(param2ByteString);
        return this;
      }
      
      public Builder setField(String param2String) {
        copyOnWrite();
        ((BadRequest.FieldViolation)this.instance).setField(param2String);
        return this;
      }
      
      public Builder setFieldBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((BadRequest.FieldViolation)this.instance).setFieldBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<FieldViolation, FieldViolation.Builder> implements FieldViolationOrBuilder {
    private Builder() {
      super(BadRequest.FieldViolation.DEFAULT_INSTANCE);
    }
    
    public Builder clearDescription() {
      copyOnWrite();
      ((BadRequest.FieldViolation)this.instance).clearDescription();
      return this;
    }
    
    public Builder clearField() {
      copyOnWrite();
      ((BadRequest.FieldViolation)this.instance).clearField();
      return this;
    }
    
    public String getDescription() {
      return ((BadRequest.FieldViolation)this.instance).getDescription();
    }
    
    public ByteString getDescriptionBytes() {
      return ((BadRequest.FieldViolation)this.instance).getDescriptionBytes();
    }
    
    public String getField() {
      return ((BadRequest.FieldViolation)this.instance).getField();
    }
    
    public ByteString getFieldBytes() {
      return ((BadRequest.FieldViolation)this.instance).getFieldBytes();
    }
    
    public Builder setDescription(String param1String) {
      copyOnWrite();
      ((BadRequest.FieldViolation)this.instance).setDescription(param1String);
      return this;
    }
    
    public Builder setDescriptionBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((BadRequest.FieldViolation)this.instance).setDescriptionBytes(param1ByteString);
      return this;
    }
    
    public Builder setField(String param1String) {
      copyOnWrite();
      ((BadRequest.FieldViolation)this.instance).setField(param1String);
      return this;
    }
    
    public Builder setFieldBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((BadRequest.FieldViolation)this.instance).setFieldBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface FieldViolationOrBuilder extends MessageLiteOrBuilder {
    String getDescription();
    
    ByteString getDescriptionBytes();
    
    String getField();
    
    ByteString getFieldBytes();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\rpc\BadRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */