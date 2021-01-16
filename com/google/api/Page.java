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

public final class Page extends GeneratedMessageLite<Page, Page.Builder> implements PageOrBuilder {
  public static final int CONTENT_FIELD_NUMBER = 2;
  
  private static final Page DEFAULT_INSTANCE = new Page();
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  private static volatile Parser<Page> PARSER;
  
  public static final int SUBPAGES_FIELD_NUMBER = 3;
  
  private int bitField0_;
  
  private String content_ = "";
  
  private String name_ = "";
  
  private Internal.ProtobufList<Page> subpages_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllSubpages(Iterable<? extends Page> paramIterable) {
    ensureSubpagesIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.subpages_);
  }
  
  private void addSubpages(int paramInt, Builder paramBuilder) {
    ensureSubpagesIsMutable();
    this.subpages_.add(paramInt, paramBuilder.build());
  }
  
  private void addSubpages(int paramInt, Page paramPage) {
    if (paramPage != null) {
      ensureSubpagesIsMutable();
      this.subpages_.add(paramInt, paramPage);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addSubpages(Builder paramBuilder) {
    ensureSubpagesIsMutable();
    this.subpages_.add(paramBuilder.build());
  }
  
  private void addSubpages(Page paramPage) {
    if (paramPage != null) {
      ensureSubpagesIsMutable();
      this.subpages_.add(paramPage);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearContent() {
    this.content_ = getDefaultInstance().getContent();
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearSubpages() {
    this.subpages_ = emptyProtobufList();
  }
  
  private void ensureSubpagesIsMutable() {
    if (!this.subpages_.isModifiable())
      this.subpages_ = GeneratedMessageLite.mutableCopy(this.subpages_); 
  }
  
  public static Page getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Page paramPage) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramPage);
  }
  
  public static Page parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Page)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Page parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Page)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Page parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Page)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Page parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Page)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Page parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Page)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Page parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Page)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Page parseFrom(InputStream paramInputStream) throws IOException {
    return (Page)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Page parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Page)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Page parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Page)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Page parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Page)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Page> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeSubpages(int paramInt) {
    ensureSubpagesIsMutable();
    this.subpages_.remove(paramInt);
  }
  
  private void setContent(String paramString) {
    if (paramString != null) {
      this.content_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setContentBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.content_ = paramByteString.toStringUtf8();
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
  
  private void setSubpages(int paramInt, Builder paramBuilder) {
    ensureSubpagesIsMutable();
    this.subpages_.set(paramInt, paramBuilder.build());
  }
  
  private void setSubpages(int paramInt, Page paramPage) {
    if (paramPage != null) {
      ensureSubpagesIsMutable();
      this.subpages_.set(paramInt, paramPage);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/Page$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 450, 2 -> 446, 3 -> 435, 4 -> 426, 5 -> 304, 6 -> 110, 7 -> 300, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/api/Page.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/api/Page
    //   72: monitorenter
    //   73: getstatic com/google/api/Page.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/api/Page.DEFAULT_INSTANCE : Lcom/google/api/Page;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/api/Page.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/api/Page
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/api/Page
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/api/Page.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 300
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 244
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 233
    //   146: iload #5
    //   148: bipush #18
    //   150: if_icmpeq -> 222
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
    //   176: getfield subpages_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   179: invokeinterface isModifiable : ()Z
    //   184: ifne -> 198
    //   187: aload_0
    //   188: aload_0
    //   189: getfield subpages_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   192: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   195: putfield subpages_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   198: aload_0
    //   199: getfield subpages_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   202: aload_1
    //   203: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   206: aload_2
    //   207: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   210: checkcast com/google/api/Page
    //   213: invokeinterface add : (Ljava/lang/Object;)Z
    //   218: pop
    //   219: goto -> 123
    //   222: aload_0
    //   223: aload_1
    //   224: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   227: putfield content_ : Ljava/lang/String;
    //   230: goto -> 123
    //   233: aload_0
    //   234: aload_1
    //   235: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   238: putfield name_ : Ljava/lang/String;
    //   241: goto -> 123
    //   244: iconst_1
    //   245: istore #4
    //   247: goto -> 123
    //   250: astore_1
    //   251: goto -> 298
    //   254: astore_1
    //   255: new java/lang/RuntimeException
    //   258: astore_3
    //   259: new com/google/protobuf/InvalidProtocolBufferException
    //   262: astore_2
    //   263: aload_2
    //   264: aload_1
    //   265: invokevirtual getMessage : ()Ljava/lang/String;
    //   268: invokespecial <init> : (Ljava/lang/String;)V
    //   271: aload_3
    //   272: aload_2
    //   273: aload_0
    //   274: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   277: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   280: aload_3
    //   281: athrow
    //   282: astore_2
    //   283: new java/lang/RuntimeException
    //   286: astore_1
    //   287: aload_1
    //   288: aload_2
    //   289: aload_0
    //   290: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   293: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   296: aload_1
    //   297: athrow
    //   298: aload_1
    //   299: athrow
    //   300: getstatic com/google/api/Page.DEFAULT_INSTANCE : Lcom/google/api/Page;
    //   303: areturn
    //   304: aload_2
    //   305: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   308: astore_1
    //   309: aload_3
    //   310: checkcast com/google/api/Page
    //   313: astore_2
    //   314: aload_0
    //   315: aload_1
    //   316: aload_0
    //   317: getfield name_ : Ljava/lang/String;
    //   320: invokevirtual isEmpty : ()Z
    //   323: iconst_1
    //   324: ixor
    //   325: aload_0
    //   326: getfield name_ : Ljava/lang/String;
    //   329: aload_2
    //   330: getfield name_ : Ljava/lang/String;
    //   333: invokevirtual isEmpty : ()Z
    //   336: iconst_1
    //   337: ixor
    //   338: aload_2
    //   339: getfield name_ : Ljava/lang/String;
    //   342: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   347: putfield name_ : Ljava/lang/String;
    //   350: aload_0
    //   351: aload_1
    //   352: aload_0
    //   353: getfield content_ : Ljava/lang/String;
    //   356: invokevirtual isEmpty : ()Z
    //   359: iconst_1
    //   360: ixor
    //   361: aload_0
    //   362: getfield content_ : Ljava/lang/String;
    //   365: iconst_1
    //   366: aload_2
    //   367: getfield content_ : Ljava/lang/String;
    //   370: invokevirtual isEmpty : ()Z
    //   373: ixor
    //   374: aload_2
    //   375: getfield content_ : Ljava/lang/String;
    //   378: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   383: putfield content_ : Ljava/lang/String;
    //   386: aload_0
    //   387: aload_1
    //   388: aload_0
    //   389: getfield subpages_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   392: aload_2
    //   393: getfield subpages_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   396: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   401: putfield subpages_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   404: aload_1
    //   405: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   408: if_acmpne -> 424
    //   411: aload_0
    //   412: aload_0
    //   413: getfield bitField0_ : I
    //   416: aload_2
    //   417: getfield bitField0_ : I
    //   420: ior
    //   421: putfield bitField0_ : I
    //   424: aload_0
    //   425: areturn
    //   426: new com/google/api/Page$Builder
    //   429: dup
    //   430: aconst_null
    //   431: invokespecial <init> : (Lcom/google/api/Page$1;)V
    //   434: areturn
    //   435: aload_0
    //   436: getfield subpages_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   439: invokeinterface makeImmutable : ()V
    //   444: aconst_null
    //   445: areturn
    //   446: getstatic com/google/api/Page.DEFAULT_INSTANCE : Lcom/google/api/Page;
    //   449: areturn
    //   450: new com/google/api/Page
    //   453: dup
    //   454: invokespecial <init> : ()V
    //   457: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	282	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	254	java/io/IOException
    //   128	134	250	finally
    //   160	169	282	com/google/protobuf/InvalidProtocolBufferException
    //   160	169	254	java/io/IOException
    //   160	169	250	finally
    //   175	198	282	com/google/protobuf/InvalidProtocolBufferException
    //   175	198	254	java/io/IOException
    //   175	198	250	finally
    //   198	219	282	com/google/protobuf/InvalidProtocolBufferException
    //   198	219	254	java/io/IOException
    //   198	219	250	finally
    //   222	230	282	com/google/protobuf/InvalidProtocolBufferException
    //   222	230	254	java/io/IOException
    //   222	230	250	finally
    //   233	241	282	com/google/protobuf/InvalidProtocolBufferException
    //   233	241	254	java/io/IOException
    //   233	241	250	finally
    //   255	282	250	finally
    //   283	298	250	finally
  }
  
  public String getContent() {
    return this.content_;
  }
  
  public ByteString getContentBytes() {
    return ByteString.copyFromUtf8(this.content_);
  }
  
  public String getName() {
    return this.name_;
  }
  
  public ByteString getNameBytes() {
    return ByteString.copyFromUtf8(this.name_);
  }
  
  public int getSerializedSize() {
    byte b2;
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    boolean bool = this.name_.isEmpty();
    byte b1 = 0;
    if (!bool) {
      b2 = CodedOutputStream.computeStringSize(1, getName()) + 0;
    } else {
      b2 = 0;
    } 
    i = b2;
    byte b3 = b1;
    if (!this.content_.isEmpty()) {
      i = b2 + CodedOutputStream.computeStringSize(2, getContent());
      b3 = b1;
    } 
    while (b3 < this.subpages_.size()) {
      i += CodedOutputStream.computeMessageSize(3, (MessageLite)this.subpages_.get(b3));
      b3++;
    } 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public Page getSubpages(int paramInt) {
    return (Page)this.subpages_.get(paramInt);
  }
  
  public int getSubpagesCount() {
    return this.subpages_.size();
  }
  
  public List<Page> getSubpagesList() {
    return (List<Page>)this.subpages_;
  }
  
  public PageOrBuilder getSubpagesOrBuilder(int paramInt) {
    return (PageOrBuilder)this.subpages_.get(paramInt);
  }
  
  public List<? extends PageOrBuilder> getSubpagesOrBuilderList() {
    return (List)this.subpages_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(1, getName()); 
    if (!this.content_.isEmpty())
      paramCodedOutputStream.writeString(2, getContent()); 
    for (byte b = 0; b < this.subpages_.size(); b++)
      paramCodedOutputStream.writeMessage(3, (MessageLite)this.subpages_.get(b)); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Page, Builder> implements PageOrBuilder {
    private Builder() {
      super(Page.DEFAULT_INSTANCE);
    }
    
    public Builder addAllSubpages(Iterable<? extends Page> param1Iterable) {
      copyOnWrite();
      ((Page)this.instance).addAllSubpages(param1Iterable);
      return this;
    }
    
    public Builder addSubpages(int param1Int, Builder param1Builder) {
      copyOnWrite();
      ((Page)this.instance).addSubpages(param1Int, param1Builder);
      return this;
    }
    
    public Builder addSubpages(int param1Int, Page param1Page) {
      copyOnWrite();
      ((Page)this.instance).addSubpages(param1Int, param1Page);
      return this;
    }
    
    public Builder addSubpages(Builder param1Builder) {
      copyOnWrite();
      ((Page)this.instance).addSubpages(param1Builder);
      return this;
    }
    
    public Builder addSubpages(Page param1Page) {
      copyOnWrite();
      ((Page)this.instance).addSubpages(param1Page);
      return this;
    }
    
    public Builder clearContent() {
      copyOnWrite();
      ((Page)this.instance).clearContent();
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      ((Page)this.instance).clearName();
      return this;
    }
    
    public Builder clearSubpages() {
      copyOnWrite();
      ((Page)this.instance).clearSubpages();
      return this;
    }
    
    public String getContent() {
      return ((Page)this.instance).getContent();
    }
    
    public ByteString getContentBytes() {
      return ((Page)this.instance).getContentBytes();
    }
    
    public String getName() {
      return ((Page)this.instance).getName();
    }
    
    public ByteString getNameBytes() {
      return ((Page)this.instance).getNameBytes();
    }
    
    public Page getSubpages(int param1Int) {
      return ((Page)this.instance).getSubpages(param1Int);
    }
    
    public int getSubpagesCount() {
      return ((Page)this.instance).getSubpagesCount();
    }
    
    public List<Page> getSubpagesList() {
      return Collections.unmodifiableList(((Page)this.instance).getSubpagesList());
    }
    
    public Builder removeSubpages(int param1Int) {
      copyOnWrite();
      ((Page)this.instance).removeSubpages(param1Int);
      return this;
    }
    
    public Builder setContent(String param1String) {
      copyOnWrite();
      ((Page)this.instance).setContent(param1String);
      return this;
    }
    
    public Builder setContentBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Page)this.instance).setContentBytes(param1ByteString);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      ((Page)this.instance).setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Page)this.instance).setNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setSubpages(int param1Int, Builder param1Builder) {
      copyOnWrite();
      ((Page)this.instance).setSubpages(param1Int, param1Builder);
      return this;
    }
    
    public Builder setSubpages(int param1Int, Page param1Page) {
      copyOnWrite();
      ((Page)this.instance).setSubpages(param1Int, param1Page);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\Page.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */