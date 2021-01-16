package com.google.api;

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

public final class ContextRule extends GeneratedMessageLite<ContextRule, ContextRule.Builder> implements ContextRuleOrBuilder {
  private static final ContextRule DEFAULT_INSTANCE = new ContextRule();
  
  private static volatile Parser<ContextRule> PARSER;
  
  public static final int PROVIDED_FIELD_NUMBER = 3;
  
  public static final int REQUESTED_FIELD_NUMBER = 2;
  
  public static final int SELECTOR_FIELD_NUMBER = 1;
  
  private int bitField0_;
  
  private Internal.ProtobufList<String> provided_ = GeneratedMessageLite.emptyProtobufList();
  
  private Internal.ProtobufList<String> requested_ = GeneratedMessageLite.emptyProtobufList();
  
  private String selector_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllProvided(Iterable<String> paramIterable) {
    ensureProvidedIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.provided_);
  }
  
  private void addAllRequested(Iterable<String> paramIterable) {
    ensureRequestedIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.requested_);
  }
  
  private void addProvided(String paramString) {
    if (paramString != null) {
      ensureProvidedIsMutable();
      this.provided_.add(paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addProvidedBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      ensureProvidedIsMutable();
      this.provided_.add(paramByteString.toStringUtf8());
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addRequested(String paramString) {
    if (paramString != null) {
      ensureRequestedIsMutable();
      this.requested_.add(paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addRequestedBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      ensureRequestedIsMutable();
      this.requested_.add(paramByteString.toStringUtf8());
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearProvided() {
    this.provided_ = GeneratedMessageLite.emptyProtobufList();
  }
  
  private void clearRequested() {
    this.requested_ = GeneratedMessageLite.emptyProtobufList();
  }
  
  private void clearSelector() {
    this.selector_ = getDefaultInstance().getSelector();
  }
  
  private void ensureProvidedIsMutable() {
    if (!this.provided_.isModifiable())
      this.provided_ = GeneratedMessageLite.mutableCopy(this.provided_); 
  }
  
  private void ensureRequestedIsMutable() {
    if (!this.requested_.isModifiable())
      this.requested_ = GeneratedMessageLite.mutableCopy(this.requested_); 
  }
  
  public static ContextRule getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ContextRule paramContextRule) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramContextRule);
  }
  
  public static ContextRule parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ContextRule)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ContextRule parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ContextRule)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ContextRule parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (ContextRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static ContextRule parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ContextRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static ContextRule parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (ContextRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static ContextRule parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ContextRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ContextRule parseFrom(InputStream paramInputStream) throws IOException {
    return (ContextRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ContextRule parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ContextRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ContextRule parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (ContextRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static ContextRule parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ContextRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ContextRule> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setProvided(int paramInt, String paramString) {
    if (paramString != null) {
      ensureProvidedIsMutable();
      this.provided_.set(paramInt, paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRequested(int paramInt, String paramString) {
    if (paramString != null) {
      ensureRequestedIsMutable();
      this.requested_.set(paramInt, paramString);
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
    //   0: getstatic com/google/api/ContextRule$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 467, 2 -> 463, 3 -> 443, 4 -> 434, 5 -> 330, 6 -> 110, 7 -> 326, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/api/ContextRule.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/api/ContextRule
    //   72: monitorenter
    //   73: getstatic com/google/api/ContextRule.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/api/ContextRule.DEFAULT_INSTANCE : Lcom/google/api/ContextRule;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/api/ContextRule.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/api/ContextRule
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/api/ContextRule
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/api/ContextRule.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 326
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 270
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 259
    //   146: iload #5
    //   148: bipush #18
    //   150: if_icmpeq -> 217
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
    //   175: aload_1
    //   176: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   179: astore_2
    //   180: aload_0
    //   181: getfield provided_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   184: invokeinterface isModifiable : ()Z
    //   189: ifne -> 203
    //   192: aload_0
    //   193: aload_0
    //   194: getfield provided_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   197: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   200: putfield provided_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   203: aload_0
    //   204: getfield provided_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   207: aload_2
    //   208: invokeinterface add : (Ljava/lang/Object;)Z
    //   213: pop
    //   214: goto -> 123
    //   217: aload_1
    //   218: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   221: astore_2
    //   222: aload_0
    //   223: getfield requested_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   226: invokeinterface isModifiable : ()Z
    //   231: ifne -> 245
    //   234: aload_0
    //   235: aload_0
    //   236: getfield requested_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   239: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   242: putfield requested_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   245: aload_0
    //   246: getfield requested_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   249: aload_2
    //   250: invokeinterface add : (Ljava/lang/Object;)Z
    //   255: pop
    //   256: goto -> 123
    //   259: aload_0
    //   260: aload_1
    //   261: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   264: putfield selector_ : Ljava/lang/String;
    //   267: goto -> 123
    //   270: iconst_1
    //   271: istore #4
    //   273: goto -> 123
    //   276: astore_1
    //   277: goto -> 324
    //   280: astore_1
    //   281: new java/lang/RuntimeException
    //   284: astore_2
    //   285: new com/google/protobuf/InvalidProtocolBufferException
    //   288: astore_3
    //   289: aload_3
    //   290: aload_1
    //   291: invokevirtual getMessage : ()Ljava/lang/String;
    //   294: invokespecial <init> : (Ljava/lang/String;)V
    //   297: aload_2
    //   298: aload_3
    //   299: aload_0
    //   300: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   303: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   306: aload_2
    //   307: athrow
    //   308: astore_1
    //   309: new java/lang/RuntimeException
    //   312: astore_2
    //   313: aload_2
    //   314: aload_1
    //   315: aload_0
    //   316: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   319: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   322: aload_2
    //   323: athrow
    //   324: aload_1
    //   325: athrow
    //   326: getstatic com/google/api/ContextRule.DEFAULT_INSTANCE : Lcom/google/api/ContextRule;
    //   329: areturn
    //   330: aload_2
    //   331: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   334: astore_1
    //   335: aload_3
    //   336: checkcast com/google/api/ContextRule
    //   339: astore_2
    //   340: aload_0
    //   341: aload_1
    //   342: aload_0
    //   343: getfield selector_ : Ljava/lang/String;
    //   346: invokevirtual isEmpty : ()Z
    //   349: iconst_1
    //   350: ixor
    //   351: aload_0
    //   352: getfield selector_ : Ljava/lang/String;
    //   355: iconst_1
    //   356: aload_2
    //   357: getfield selector_ : Ljava/lang/String;
    //   360: invokevirtual isEmpty : ()Z
    //   363: ixor
    //   364: aload_2
    //   365: getfield selector_ : Ljava/lang/String;
    //   368: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   373: putfield selector_ : Ljava/lang/String;
    //   376: aload_0
    //   377: aload_1
    //   378: aload_0
    //   379: getfield requested_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   382: aload_2
    //   383: getfield requested_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   386: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   391: putfield requested_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   394: aload_0
    //   395: aload_1
    //   396: aload_0
    //   397: getfield provided_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   400: aload_2
    //   401: getfield provided_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   404: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   409: putfield provided_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   412: aload_1
    //   413: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   416: if_acmpne -> 432
    //   419: aload_0
    //   420: aload_0
    //   421: getfield bitField0_ : I
    //   424: aload_2
    //   425: getfield bitField0_ : I
    //   428: ior
    //   429: putfield bitField0_ : I
    //   432: aload_0
    //   433: areturn
    //   434: new com/google/api/ContextRule$Builder
    //   437: dup
    //   438: aconst_null
    //   439: invokespecial <init> : (Lcom/google/api/ContextRule$1;)V
    //   442: areturn
    //   443: aload_0
    //   444: getfield requested_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   447: invokeinterface makeImmutable : ()V
    //   452: aload_0
    //   453: getfield provided_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   456: invokeinterface makeImmutable : ()V
    //   461: aconst_null
    //   462: areturn
    //   463: getstatic com/google/api/ContextRule.DEFAULT_INSTANCE : Lcom/google/api/ContextRule;
    //   466: areturn
    //   467: new com/google/api/ContextRule
    //   470: dup
    //   471: invokespecial <init> : ()V
    //   474: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	308	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	280	java/io/IOException
    //   128	134	276	finally
    //   160	169	308	com/google/protobuf/InvalidProtocolBufferException
    //   160	169	280	java/io/IOException
    //   160	169	276	finally
    //   175	203	308	com/google/protobuf/InvalidProtocolBufferException
    //   175	203	280	java/io/IOException
    //   175	203	276	finally
    //   203	214	308	com/google/protobuf/InvalidProtocolBufferException
    //   203	214	280	java/io/IOException
    //   203	214	276	finally
    //   217	245	308	com/google/protobuf/InvalidProtocolBufferException
    //   217	245	280	java/io/IOException
    //   217	245	276	finally
    //   245	256	308	com/google/protobuf/InvalidProtocolBufferException
    //   245	256	280	java/io/IOException
    //   245	256	276	finally
    //   259	267	308	com/google/protobuf/InvalidProtocolBufferException
    //   259	267	280	java/io/IOException
    //   259	267	276	finally
    //   281	308	276	finally
    //   309	324	276	finally
  }
  
  public String getProvided(int paramInt) {
    return (String)this.provided_.get(paramInt);
  }
  
  public ByteString getProvidedBytes(int paramInt) {
    return ByteString.copyFromUtf8((String)this.provided_.get(paramInt));
  }
  
  public int getProvidedCount() {
    return this.provided_.size();
  }
  
  public List<String> getProvidedList() {
    return (List<String>)this.provided_;
  }
  
  public String getRequested(int paramInt) {
    return (String)this.requested_.get(paramInt);
  }
  
  public ByteString getRequestedBytes(int paramInt) {
    return ByteString.copyFromUtf8((String)this.requested_.get(paramInt));
  }
  
  public int getRequestedCount() {
    return this.requested_.size();
  }
  
  public List<String> getRequestedList() {
    return (List<String>)this.requested_;
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
    int j = 0;
    int k = 0;
    while (j < this.requested_.size()) {
      k += CodedOutputStream.computeStringSizeNoTag((String)this.requested_.get(j));
      j++;
    } 
    int m = getRequestedList().size();
    j = 0;
    while (b < this.provided_.size()) {
      j += CodedOutputStream.computeStringSizeNoTag((String)this.provided_.get(b));
      b++;
    } 
    i = i + k + m * 1 + j + getProvidedList().size() * 1;
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    byte b3;
    if (!this.selector_.isEmpty())
      paramCodedOutputStream.writeString(1, getSelector()); 
    byte b1 = 0;
    byte b2 = 0;
    while (true) {
      b3 = b1;
      if (b2 < this.requested_.size()) {
        paramCodedOutputStream.writeString(2, (String)this.requested_.get(b2));
        b2++;
        continue;
      } 
      break;
    } 
    while (b3 < this.provided_.size()) {
      paramCodedOutputStream.writeString(3, (String)this.provided_.get(b3));
      b3++;
    } 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ContextRule, Builder> implements ContextRuleOrBuilder {
    private Builder() {
      super(ContextRule.DEFAULT_INSTANCE);
    }
    
    public Builder addAllProvided(Iterable<String> param1Iterable) {
      copyOnWrite();
      ((ContextRule)this.instance).addAllProvided(param1Iterable);
      return this;
    }
    
    public Builder addAllRequested(Iterable<String> param1Iterable) {
      copyOnWrite();
      ((ContextRule)this.instance).addAllRequested(param1Iterable);
      return this;
    }
    
    public Builder addProvided(String param1String) {
      copyOnWrite();
      ((ContextRule)this.instance).addProvided(param1String);
      return this;
    }
    
    public Builder addProvidedBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ContextRule)this.instance).addProvidedBytes(param1ByteString);
      return this;
    }
    
    public Builder addRequested(String param1String) {
      copyOnWrite();
      ((ContextRule)this.instance).addRequested(param1String);
      return this;
    }
    
    public Builder addRequestedBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ContextRule)this.instance).addRequestedBytes(param1ByteString);
      return this;
    }
    
    public Builder clearProvided() {
      copyOnWrite();
      ((ContextRule)this.instance).clearProvided();
      return this;
    }
    
    public Builder clearRequested() {
      copyOnWrite();
      ((ContextRule)this.instance).clearRequested();
      return this;
    }
    
    public Builder clearSelector() {
      copyOnWrite();
      ((ContextRule)this.instance).clearSelector();
      return this;
    }
    
    public String getProvided(int param1Int) {
      return ((ContextRule)this.instance).getProvided(param1Int);
    }
    
    public ByteString getProvidedBytes(int param1Int) {
      return ((ContextRule)this.instance).getProvidedBytes(param1Int);
    }
    
    public int getProvidedCount() {
      return ((ContextRule)this.instance).getProvidedCount();
    }
    
    public List<String> getProvidedList() {
      return Collections.unmodifiableList(((ContextRule)this.instance).getProvidedList());
    }
    
    public String getRequested(int param1Int) {
      return ((ContextRule)this.instance).getRequested(param1Int);
    }
    
    public ByteString getRequestedBytes(int param1Int) {
      return ((ContextRule)this.instance).getRequestedBytes(param1Int);
    }
    
    public int getRequestedCount() {
      return ((ContextRule)this.instance).getRequestedCount();
    }
    
    public List<String> getRequestedList() {
      return Collections.unmodifiableList(((ContextRule)this.instance).getRequestedList());
    }
    
    public String getSelector() {
      return ((ContextRule)this.instance).getSelector();
    }
    
    public ByteString getSelectorBytes() {
      return ((ContextRule)this.instance).getSelectorBytes();
    }
    
    public Builder setProvided(int param1Int, String param1String) {
      copyOnWrite();
      ((ContextRule)this.instance).setProvided(param1Int, param1String);
      return this;
    }
    
    public Builder setRequested(int param1Int, String param1String) {
      copyOnWrite();
      ((ContextRule)this.instance).setRequested(param1Int, param1String);
      return this;
    }
    
    public Builder setSelector(String param1String) {
      copyOnWrite();
      ((ContextRule)this.instance).setSelector(param1String);
      return this;
    }
    
    public Builder setSelectorBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ContextRule)this.instance).setSelectorBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\ContextRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */