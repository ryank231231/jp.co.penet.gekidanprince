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

public final class SystemParameterRule extends GeneratedMessageLite<SystemParameterRule, SystemParameterRule.Builder> implements SystemParameterRuleOrBuilder {
  private static final SystemParameterRule DEFAULT_INSTANCE = new SystemParameterRule();
  
  public static final int PARAMETERS_FIELD_NUMBER = 2;
  
  private static volatile Parser<SystemParameterRule> PARSER;
  
  public static final int SELECTOR_FIELD_NUMBER = 1;
  
  private int bitField0_;
  
  private Internal.ProtobufList<SystemParameter> parameters_ = emptyProtobufList();
  
  private String selector_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllParameters(Iterable<? extends SystemParameter> paramIterable) {
    ensureParametersIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.parameters_);
  }
  
  private void addParameters(int paramInt, SystemParameter.Builder paramBuilder) {
    ensureParametersIsMutable();
    this.parameters_.add(paramInt, paramBuilder.build());
  }
  
  private void addParameters(int paramInt, SystemParameter paramSystemParameter) {
    if (paramSystemParameter != null) {
      ensureParametersIsMutable();
      this.parameters_.add(paramInt, paramSystemParameter);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addParameters(SystemParameter.Builder paramBuilder) {
    ensureParametersIsMutable();
    this.parameters_.add(paramBuilder.build());
  }
  
  private void addParameters(SystemParameter paramSystemParameter) {
    if (paramSystemParameter != null) {
      ensureParametersIsMutable();
      this.parameters_.add(paramSystemParameter);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearParameters() {
    this.parameters_ = emptyProtobufList();
  }
  
  private void clearSelector() {
    this.selector_ = getDefaultInstance().getSelector();
  }
  
  private void ensureParametersIsMutable() {
    if (!this.parameters_.isModifiable())
      this.parameters_ = GeneratedMessageLite.mutableCopy(this.parameters_); 
  }
  
  public static SystemParameterRule getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(SystemParameterRule paramSystemParameterRule) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramSystemParameterRule);
  }
  
  public static SystemParameterRule parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (SystemParameterRule)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static SystemParameterRule parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (SystemParameterRule)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static SystemParameterRule parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (SystemParameterRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static SystemParameterRule parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (SystemParameterRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static SystemParameterRule parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (SystemParameterRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static SystemParameterRule parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (SystemParameterRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static SystemParameterRule parseFrom(InputStream paramInputStream) throws IOException {
    return (SystemParameterRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static SystemParameterRule parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (SystemParameterRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static SystemParameterRule parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (SystemParameterRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static SystemParameterRule parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (SystemParameterRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<SystemParameterRule> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeParameters(int paramInt) {
    ensureParametersIsMutable();
    this.parameters_.remove(paramInt);
  }
  
  private void setParameters(int paramInt, SystemParameter.Builder paramBuilder) {
    ensureParametersIsMutable();
    this.parameters_.set(paramInt, paramBuilder.build());
  }
  
  private void setParameters(int paramInt, SystemParameter paramSystemParameter) {
    if (paramSystemParameter != null) {
      ensureParametersIsMutable();
      this.parameters_.set(paramInt, paramSystemParameter);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setSelector(String paramString) {
    if (paramString != null) {
      this.selector_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setSelectorBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.selector_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/SystemParameterRule$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 396, 2 -> 392, 3 -> 381, 4 -> 372, 5 -> 286, 6 -> 110, 7 -> 282, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/api/SystemParameterRule.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/api/SystemParameterRule
    //   72: monitorenter
    //   73: getstatic com/google/api/SystemParameterRule.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/api/SystemParameterRule.DEFAULT_INSTANCE : Lcom/google/api/SystemParameterRule;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/api/SystemParameterRule.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/api/SystemParameterRule
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/api/SystemParameterRule
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/api/SystemParameterRule.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 282
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 226
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 215
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
    //   169: getfield parameters_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   172: invokeinterface isModifiable : ()Z
    //   177: ifne -> 191
    //   180: aload_0
    //   181: aload_0
    //   182: getfield parameters_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   185: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   188: putfield parameters_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   191: aload_0
    //   192: getfield parameters_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   195: aload_1
    //   196: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   199: aload_2
    //   200: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   203: checkcast com/google/api/SystemParameter
    //   206: invokeinterface add : (Ljava/lang/Object;)Z
    //   211: pop
    //   212: goto -> 123
    //   215: aload_0
    //   216: aload_1
    //   217: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   220: putfield selector_ : Ljava/lang/String;
    //   223: goto -> 123
    //   226: iconst_1
    //   227: istore #4
    //   229: goto -> 123
    //   232: astore_1
    //   233: goto -> 280
    //   236: astore_3
    //   237: new java/lang/RuntimeException
    //   240: astore_1
    //   241: new com/google/protobuf/InvalidProtocolBufferException
    //   244: astore_2
    //   245: aload_2
    //   246: aload_3
    //   247: invokevirtual getMessage : ()Ljava/lang/String;
    //   250: invokespecial <init> : (Ljava/lang/String;)V
    //   253: aload_1
    //   254: aload_2
    //   255: aload_0
    //   256: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   259: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   262: aload_1
    //   263: athrow
    //   264: astore_1
    //   265: new java/lang/RuntimeException
    //   268: astore_2
    //   269: aload_2
    //   270: aload_1
    //   271: aload_0
    //   272: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   275: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   278: aload_2
    //   279: athrow
    //   280: aload_1
    //   281: athrow
    //   282: getstatic com/google/api/SystemParameterRule.DEFAULT_INSTANCE : Lcom/google/api/SystemParameterRule;
    //   285: areturn
    //   286: aload_2
    //   287: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   290: astore_1
    //   291: aload_3
    //   292: checkcast com/google/api/SystemParameterRule
    //   295: astore_2
    //   296: aload_0
    //   297: aload_1
    //   298: aload_0
    //   299: getfield selector_ : Ljava/lang/String;
    //   302: invokevirtual isEmpty : ()Z
    //   305: iconst_1
    //   306: ixor
    //   307: aload_0
    //   308: getfield selector_ : Ljava/lang/String;
    //   311: iconst_1
    //   312: aload_2
    //   313: getfield selector_ : Ljava/lang/String;
    //   316: invokevirtual isEmpty : ()Z
    //   319: ixor
    //   320: aload_2
    //   321: getfield selector_ : Ljava/lang/String;
    //   324: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   329: putfield selector_ : Ljava/lang/String;
    //   332: aload_0
    //   333: aload_1
    //   334: aload_0
    //   335: getfield parameters_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   338: aload_2
    //   339: getfield parameters_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   342: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   347: putfield parameters_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   350: aload_1
    //   351: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   354: if_acmpne -> 370
    //   357: aload_0
    //   358: aload_0
    //   359: getfield bitField0_ : I
    //   362: aload_2
    //   363: getfield bitField0_ : I
    //   366: ior
    //   367: putfield bitField0_ : I
    //   370: aload_0
    //   371: areturn
    //   372: new com/google/api/SystemParameterRule$Builder
    //   375: dup
    //   376: aconst_null
    //   377: invokespecial <init> : (Lcom/google/api/SystemParameterRule$1;)V
    //   380: areturn
    //   381: aload_0
    //   382: getfield parameters_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   385: invokeinterface makeImmutable : ()V
    //   390: aconst_null
    //   391: areturn
    //   392: getstatic com/google/api/SystemParameterRule.DEFAULT_INSTANCE : Lcom/google/api/SystemParameterRule;
    //   395: areturn
    //   396: new com/google/api/SystemParameterRule
    //   399: dup
    //   400: invokespecial <init> : ()V
    //   403: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	264	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	236	java/io/IOException
    //   128	134	232	finally
    //   153	162	264	com/google/protobuf/InvalidProtocolBufferException
    //   153	162	236	java/io/IOException
    //   153	162	232	finally
    //   168	191	264	com/google/protobuf/InvalidProtocolBufferException
    //   168	191	236	java/io/IOException
    //   168	191	232	finally
    //   191	212	264	com/google/protobuf/InvalidProtocolBufferException
    //   191	212	236	java/io/IOException
    //   191	212	232	finally
    //   215	223	264	com/google/protobuf/InvalidProtocolBufferException
    //   215	223	236	java/io/IOException
    //   215	223	232	finally
    //   237	264	232	finally
    //   265	280	232	finally
  }
  
  public SystemParameter getParameters(int paramInt) {
    return (SystemParameter)this.parameters_.get(paramInt);
  }
  
  public int getParametersCount() {
    return this.parameters_.size();
  }
  
  public List<SystemParameter> getParametersList() {
    return (List<SystemParameter>)this.parameters_;
  }
  
  public SystemParameterOrBuilder getParametersOrBuilder(int paramInt) {
    return (SystemParameterOrBuilder)this.parameters_.get(paramInt);
  }
  
  public List<? extends SystemParameterOrBuilder> getParametersOrBuilderList() {
    return (List)this.parameters_;
  }
  
  public String getSelector() {
    return this.selector_;
  }
  
  public ByteString getSelectorBytes() {
    return ByteString.copyFromUtf8(this.selector_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    boolean bool = this.selector_.isEmpty();
    byte b = 0;
    if (!bool) {
      i = CodedOutputStream.computeStringSize(1, getSelector()) + 0;
    } else {
      i = 0;
    } 
    while (b < this.parameters_.size()) {
      i += CodedOutputStream.computeMessageSize(2, (MessageLite)this.parameters_.get(b));
      b++;
    } 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.selector_.isEmpty())
      paramCodedOutputStream.writeString(1, getSelector()); 
    for (byte b = 0; b < this.parameters_.size(); b++)
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.parameters_.get(b)); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<SystemParameterRule, Builder> implements SystemParameterRuleOrBuilder {
    private Builder() {
      super(SystemParameterRule.DEFAULT_INSTANCE);
    }
    
    public Builder addAllParameters(Iterable<? extends SystemParameter> param1Iterable) {
      copyOnWrite();
      ((SystemParameterRule)this.instance).addAllParameters(param1Iterable);
      return this;
    }
    
    public Builder addParameters(int param1Int, SystemParameter.Builder param1Builder) {
      copyOnWrite();
      ((SystemParameterRule)this.instance).addParameters(param1Int, param1Builder);
      return this;
    }
    
    public Builder addParameters(int param1Int, SystemParameter param1SystemParameter) {
      copyOnWrite();
      ((SystemParameterRule)this.instance).addParameters(param1Int, param1SystemParameter);
      return this;
    }
    
    public Builder addParameters(SystemParameter.Builder param1Builder) {
      copyOnWrite();
      ((SystemParameterRule)this.instance).addParameters(param1Builder);
      return this;
    }
    
    public Builder addParameters(SystemParameter param1SystemParameter) {
      copyOnWrite();
      ((SystemParameterRule)this.instance).addParameters(param1SystemParameter);
      return this;
    }
    
    public Builder clearParameters() {
      copyOnWrite();
      ((SystemParameterRule)this.instance).clearParameters();
      return this;
    }
    
    public Builder clearSelector() {
      copyOnWrite();
      ((SystemParameterRule)this.instance).clearSelector();
      return this;
    }
    
    public SystemParameter getParameters(int param1Int) {
      return ((SystemParameterRule)this.instance).getParameters(param1Int);
    }
    
    public int getParametersCount() {
      return ((SystemParameterRule)this.instance).getParametersCount();
    }
    
    public List<SystemParameter> getParametersList() {
      return Collections.unmodifiableList(((SystemParameterRule)this.instance).getParametersList());
    }
    
    public String getSelector() {
      return ((SystemParameterRule)this.instance).getSelector();
    }
    
    public ByteString getSelectorBytes() {
      return ((SystemParameterRule)this.instance).getSelectorBytes();
    }
    
    public Builder removeParameters(int param1Int) {
      copyOnWrite();
      ((SystemParameterRule)this.instance).removeParameters(param1Int);
      return this;
    }
    
    public Builder setParameters(int param1Int, SystemParameter.Builder param1Builder) {
      copyOnWrite();
      ((SystemParameterRule)this.instance).setParameters(param1Int, param1Builder);
      return this;
    }
    
    public Builder setParameters(int param1Int, SystemParameter param1SystemParameter) {
      copyOnWrite();
      ((SystemParameterRule)this.instance).setParameters(param1Int, param1SystemParameter);
      return this;
    }
    
    public Builder setSelector(String param1String) {
      copyOnWrite();
      ((SystemParameterRule)this.instance).setSelector(param1String);
      return this;
    }
    
    public Builder setSelectorBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((SystemParameterRule)this.instance).setSelectorBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\SystemParameterRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */