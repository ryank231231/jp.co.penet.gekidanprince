package com.google.firebase.inappmessaging;

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

public final class MessagesProto {
  static {
  
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class Action extends GeneratedMessageLite<Action, Action.Builder> implements ActionOrBuilder {
    public static final int ACTION_URL_FIELD_NUMBER = 1;
    
    private static final Action DEFAULT_INSTANCE = new Action();
    
    private static volatile Parser<Action> PARSER;
    
    private String actionUrl_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearActionUrl() {
      this.actionUrl_ = getDefaultInstance().getActionUrl();
    }
    
    public static Action getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Action param1Action) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1Action);
    }
    
    public static Action parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Action)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Action parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Action)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Action parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Action)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static Action parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Action)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Action parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Action)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static Action parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Action)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Action parseFrom(InputStream param1InputStream) throws IOException {
      return (Action)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Action parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Action)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Action parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Action)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static Action parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Action)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Action> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setActionUrl(String param1String) {
      if (param1String != null) {
        this.actionUrl_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setActionUrlBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.actionUrl_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firebase/inappmessaging/MessagesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 299, 2 -> 295, 3 -> 293, 4 -> 284, 5 -> 232, 6 -> 110, 7 -> 228, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/firebase/inappmessaging/MessagesProto$Action.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/firebase/inappmessaging/MessagesProto$Action
      //   72: monitorenter
      //   73: getstatic com/google/firebase/inappmessaging/MessagesProto$Action.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/firebase/inappmessaging/MessagesProto$Action.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/firebase/inappmessaging/MessagesProto$Action.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/firebase/inappmessaging/MessagesProto$Action
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/firebase/inappmessaging/MessagesProto$Action
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/firebase/inappmessaging/MessagesProto$Action.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 228
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 172
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
      //   162: aload_1
      //   163: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   166: putfield actionUrl_ : Ljava/lang/String;
      //   169: goto -> 123
      //   172: iconst_1
      //   173: istore #4
      //   175: goto -> 123
      //   178: astore_1
      //   179: goto -> 226
      //   182: astore_2
      //   183: new java/lang/RuntimeException
      //   186: astore_1
      //   187: new com/google/protobuf/InvalidProtocolBufferException
      //   190: astore_3
      //   191: aload_3
      //   192: aload_2
      //   193: invokevirtual getMessage : ()Ljava/lang/String;
      //   196: invokespecial <init> : (Ljava/lang/String;)V
      //   199: aload_1
      //   200: aload_3
      //   201: aload_0
      //   202: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   205: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   208: aload_1
      //   209: athrow
      //   210: astore_2
      //   211: new java/lang/RuntimeException
      //   214: astore_1
      //   215: aload_1
      //   216: aload_2
      //   217: aload_0
      //   218: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   221: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   224: aload_1
      //   225: athrow
      //   226: aload_1
      //   227: athrow
      //   228: getstatic com/google/firebase/inappmessaging/MessagesProto$Action.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   231: areturn
      //   232: aload_2
      //   233: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   236: astore_1
      //   237: aload_3
      //   238: checkcast com/google/firebase/inappmessaging/MessagesProto$Action
      //   241: astore_2
      //   242: aload_0
      //   243: aload_1
      //   244: aload_0
      //   245: getfield actionUrl_ : Ljava/lang/String;
      //   248: invokevirtual isEmpty : ()Z
      //   251: iconst_1
      //   252: ixor
      //   253: aload_0
      //   254: getfield actionUrl_ : Ljava/lang/String;
      //   257: iconst_1
      //   258: aload_2
      //   259: getfield actionUrl_ : Ljava/lang/String;
      //   262: invokevirtual isEmpty : ()Z
      //   265: ixor
      //   266: aload_2
      //   267: getfield actionUrl_ : Ljava/lang/String;
      //   270: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   275: putfield actionUrl_ : Ljava/lang/String;
      //   278: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   281: astore_1
      //   282: aload_0
      //   283: areturn
      //   284: new com/google/firebase/inappmessaging/MessagesProto$Action$Builder
      //   287: dup
      //   288: aconst_null
      //   289: invokespecial <init> : (Lcom/google/firebase/inappmessaging/MessagesProto$1;)V
      //   292: areturn
      //   293: aconst_null
      //   294: areturn
      //   295: getstatic com/google/firebase/inappmessaging/MessagesProto$Action.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   298: areturn
      //   299: new com/google/firebase/inappmessaging/MessagesProto$Action
      //   302: dup
      //   303: invokespecial <init> : ()V
      //   306: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	210	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	182	java/io/IOException
      //   128	134	178	finally
      //   146	155	210	com/google/protobuf/InvalidProtocolBufferException
      //   146	155	182	java/io/IOException
      //   146	155	178	finally
      //   161	169	210	com/google/protobuf/InvalidProtocolBufferException
      //   161	169	182	java/io/IOException
      //   161	169	178	finally
      //   183	210	178	finally
      //   211	226	178	finally
    }
    
    public String getActionUrl() {
      return this.actionUrl_;
    }
    
    public ByteString getActionUrlBytes() {
      return ByteString.copyFromUtf8(this.actionUrl_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (!this.actionUrl_.isEmpty())
        i = 0 + CodedOutputStream.computeStringSize(1, getActionUrl()); 
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.actionUrl_.isEmpty())
        param1CodedOutputStream.writeString(1, getActionUrl()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Action, Builder> implements MessagesProto.ActionOrBuilder {
      private Builder() {
        super(MessagesProto.Action.DEFAULT_INSTANCE);
      }
      
      public Builder clearActionUrl() {
        copyOnWrite();
        ((MessagesProto.Action)this.instance).clearActionUrl();
        return this;
      }
      
      public String getActionUrl() {
        return ((MessagesProto.Action)this.instance).getActionUrl();
      }
      
      public ByteString getActionUrlBytes() {
        return ((MessagesProto.Action)this.instance).getActionUrlBytes();
      }
      
      public Builder setActionUrl(String param2String) {
        copyOnWrite();
        ((MessagesProto.Action)this.instance).setActionUrl(param2String);
        return this;
      }
      
      public Builder setActionUrlBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((MessagesProto.Action)this.instance).setActionUrlBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Action, Action.Builder> implements ActionOrBuilder {
    private Builder() {
      super(MessagesProto.Action.DEFAULT_INSTANCE);
    }
    
    public Builder clearActionUrl() {
      copyOnWrite();
      ((MessagesProto.Action)this.instance).clearActionUrl();
      return this;
    }
    
    public String getActionUrl() {
      return ((MessagesProto.Action)this.instance).getActionUrl();
    }
    
    public ByteString getActionUrlBytes() {
      return ((MessagesProto.Action)this.instance).getActionUrlBytes();
    }
    
    public Builder setActionUrl(String param1String) {
      copyOnWrite();
      ((MessagesProto.Action)this.instance).setActionUrl(param1String);
      return this;
    }
    
    public Builder setActionUrlBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((MessagesProto.Action)this.instance).setActionUrlBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface ActionOrBuilder extends MessageLiteOrBuilder {
    String getActionUrl();
    
    ByteString getActionUrlBytes();
  }
  
  public static final class BannerMessage extends GeneratedMessageLite<BannerMessage, BannerMessage.Builder> implements BannerMessageOrBuilder {
    public static final int ACTION_FIELD_NUMBER = 4;
    
    public static final int BACKGROUND_HEX_COLOR_FIELD_NUMBER = 5;
    
    public static final int BODY_FIELD_NUMBER = 2;
    
    private static final BannerMessage DEFAULT_INSTANCE = new BannerMessage();
    
    public static final int IMAGE_URL_FIELD_NUMBER = 3;
    
    private static volatile Parser<BannerMessage> PARSER;
    
    public static final int TITLE_FIELD_NUMBER = 1;
    
    private MessagesProto.Action action_;
    
    private String backgroundHexColor_ = "";
    
    private MessagesProto.Text body_;
    
    private String imageUrl_ = "";
    
    private MessagesProto.Text title_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearAction() {
      this.action_ = null;
    }
    
    private void clearBackgroundHexColor() {
      this.backgroundHexColor_ = getDefaultInstance().getBackgroundHexColor();
    }
    
    private void clearBody() {
      this.body_ = null;
    }
    
    private void clearImageUrl() {
      this.imageUrl_ = getDefaultInstance().getImageUrl();
    }
    
    private void clearTitle() {
      this.title_ = null;
    }
    
    public static BannerMessage getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeAction(MessagesProto.Action param1Action) {
      MessagesProto.Action action = this.action_;
      if (action != null && action != MessagesProto.Action.getDefaultInstance()) {
        this.action_ = (MessagesProto.Action)((MessagesProto.Action.Builder)MessagesProto.Action.newBuilder(this.action_).mergeFrom(param1Action)).buildPartial();
      } else {
        this.action_ = param1Action;
      } 
    }
    
    private void mergeBody(MessagesProto.Text param1Text) {
      MessagesProto.Text text = this.body_;
      if (text != null && text != MessagesProto.Text.getDefaultInstance()) {
        this.body_ = (MessagesProto.Text)((MessagesProto.Text.Builder)MessagesProto.Text.newBuilder(this.body_).mergeFrom(param1Text)).buildPartial();
      } else {
        this.body_ = param1Text;
      } 
    }
    
    private void mergeTitle(MessagesProto.Text param1Text) {
      MessagesProto.Text text = this.title_;
      if (text != null && text != MessagesProto.Text.getDefaultInstance()) {
        this.title_ = (MessagesProto.Text)((MessagesProto.Text.Builder)MessagesProto.Text.newBuilder(this.title_).mergeFrom(param1Text)).buildPartial();
      } else {
        this.title_ = param1Text;
      } 
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(BannerMessage param1BannerMessage) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1BannerMessage);
    }
    
    public static BannerMessage parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (BannerMessage)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static BannerMessage parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (BannerMessage)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static BannerMessage parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (BannerMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static BannerMessage parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (BannerMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static BannerMessage parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (BannerMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static BannerMessage parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (BannerMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static BannerMessage parseFrom(InputStream param1InputStream) throws IOException {
      return (BannerMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static BannerMessage parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (BannerMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static BannerMessage parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (BannerMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static BannerMessage parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (BannerMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<BannerMessage> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setAction(MessagesProto.Action.Builder param1Builder) {
      this.action_ = (MessagesProto.Action)param1Builder.build();
    }
    
    private void setAction(MessagesProto.Action param1Action) {
      if (param1Action != null) {
        this.action_ = param1Action;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setBackgroundHexColor(String param1String) {
      if (param1String != null) {
        this.backgroundHexColor_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setBackgroundHexColorBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.backgroundHexColor_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setBody(MessagesProto.Text.Builder param1Builder) {
      this.body_ = (MessagesProto.Text)param1Builder.build();
    }
    
    private void setBody(MessagesProto.Text param1Text) {
      if (param1Text != null) {
        this.body_ = param1Text;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setImageUrl(String param1String) {
      if (param1String != null) {
        this.imageUrl_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setImageUrlBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.imageUrl_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTitle(MessagesProto.Text.Builder param1Builder) {
      this.title_ = (MessagesProto.Text)param1Builder.build();
    }
    
    private void setTitle(MessagesProto.Text param1Text) {
      if (param1Text != null) {
        this.title_ = param1Text;
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firebase/inappmessaging/MessagesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 632, 2 -> 628, 3 -> 626, 4 -> 617, 5 -> 466, 6 -> 110, 7 -> 462, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/firebase/inappmessaging/MessagesProto$BannerMessage.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/firebase/inappmessaging/MessagesProto$BannerMessage
      //   72: monitorenter
      //   73: getstatic com/google/firebase/inappmessaging/MessagesProto$BannerMessage.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/firebase/inappmessaging/MessagesProto$BannerMessage.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/MessagesProto$BannerMessage;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/firebase/inappmessaging/MessagesProto$BannerMessage.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/firebase/inappmessaging/MessagesProto$BannerMessage
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/firebase/inappmessaging/MessagesProto$BannerMessage
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/firebase/inappmessaging/MessagesProto$BannerMessage.PARSER : Lcom/google/protobuf/Parser;
      //   109: areturn
      //   110: aload_2
      //   111: checkcast com/google/protobuf/CodedInputStream
      //   114: astore_2
      //   115: aload_3
      //   116: checkcast com/google/protobuf/ExtensionRegistryLite
      //   119: astore_3
      //   120: iconst_0
      //   121: istore #4
      //   123: iload #4
      //   125: ifne -> 462
      //   128: aload_2
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 406
      //   139: iload #5
      //   141: bipush #10
      //   143: if_icmpeq -> 341
      //   146: iload #5
      //   148: bipush #18
      //   150: if_icmpeq -> 276
      //   153: iload #5
      //   155: bipush #26
      //   157: if_icmpeq -> 265
      //   160: iload #5
      //   162: bipush #34
      //   164: if_icmpeq -> 200
      //   167: iload #5
      //   169: bipush #42
      //   171: if_icmpeq -> 189
      //   174: aload_2
      //   175: iload #5
      //   177: invokevirtual skipField : (I)Z
      //   180: ifne -> 123
      //   183: iconst_1
      //   184: istore #4
      //   186: goto -> 123
      //   189: aload_0
      //   190: aload_2
      //   191: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   194: putfield backgroundHexColor_ : Ljava/lang/String;
      //   197: goto -> 123
      //   200: aload_0
      //   201: getfield action_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   204: ifnull -> 221
      //   207: aload_0
      //   208: getfield action_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   211: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   214: checkcast com/google/firebase/inappmessaging/MessagesProto$Action$Builder
      //   217: astore_1
      //   218: goto -> 223
      //   221: aconst_null
      //   222: astore_1
      //   223: aload_0
      //   224: aload_2
      //   225: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   228: aload_3
      //   229: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   232: checkcast com/google/firebase/inappmessaging/MessagesProto$Action
      //   235: putfield action_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   238: aload_1
      //   239: ifnull -> 123
      //   242: aload_1
      //   243: aload_0
      //   244: getfield action_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   247: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   250: pop
      //   251: aload_0
      //   252: aload_1
      //   253: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   256: checkcast com/google/firebase/inappmessaging/MessagesProto$Action
      //   259: putfield action_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   262: goto -> 123
      //   265: aload_0
      //   266: aload_2
      //   267: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   270: putfield imageUrl_ : Ljava/lang/String;
      //   273: goto -> 123
      //   276: aload_0
      //   277: getfield body_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   280: ifnull -> 297
      //   283: aload_0
      //   284: getfield body_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   287: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   290: checkcast com/google/firebase/inappmessaging/MessagesProto$Text$Builder
      //   293: astore_1
      //   294: goto -> 299
      //   297: aconst_null
      //   298: astore_1
      //   299: aload_0
      //   300: aload_2
      //   301: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   304: aload_3
      //   305: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   308: checkcast com/google/firebase/inappmessaging/MessagesProto$Text
      //   311: putfield body_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   314: aload_1
      //   315: ifnull -> 123
      //   318: aload_1
      //   319: aload_0
      //   320: getfield body_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   323: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   326: pop
      //   327: aload_0
      //   328: aload_1
      //   329: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   332: checkcast com/google/firebase/inappmessaging/MessagesProto$Text
      //   335: putfield body_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   338: goto -> 123
      //   341: aload_0
      //   342: getfield title_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   345: ifnull -> 362
      //   348: aload_0
      //   349: getfield title_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   352: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   355: checkcast com/google/firebase/inappmessaging/MessagesProto$Text$Builder
      //   358: astore_1
      //   359: goto -> 364
      //   362: aconst_null
      //   363: astore_1
      //   364: aload_0
      //   365: aload_2
      //   366: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   369: aload_3
      //   370: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   373: checkcast com/google/firebase/inappmessaging/MessagesProto$Text
      //   376: putfield title_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   379: aload_1
      //   380: ifnull -> 123
      //   383: aload_1
      //   384: aload_0
      //   385: getfield title_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   388: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   391: pop
      //   392: aload_0
      //   393: aload_1
      //   394: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   397: checkcast com/google/firebase/inappmessaging/MessagesProto$Text
      //   400: putfield title_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   403: goto -> 123
      //   406: iconst_1
      //   407: istore #4
      //   409: goto -> 123
      //   412: astore_1
      //   413: goto -> 460
      //   416: astore_1
      //   417: new java/lang/RuntimeException
      //   420: astore_2
      //   421: new com/google/protobuf/InvalidProtocolBufferException
      //   424: astore_3
      //   425: aload_3
      //   426: aload_1
      //   427: invokevirtual getMessage : ()Ljava/lang/String;
      //   430: invokespecial <init> : (Ljava/lang/String;)V
      //   433: aload_2
      //   434: aload_3
      //   435: aload_0
      //   436: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   439: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   442: aload_2
      //   443: athrow
      //   444: astore_2
      //   445: new java/lang/RuntimeException
      //   448: astore_1
      //   449: aload_1
      //   450: aload_2
      //   451: aload_0
      //   452: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   455: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   458: aload_1
      //   459: athrow
      //   460: aload_1
      //   461: athrow
      //   462: getstatic com/google/firebase/inappmessaging/MessagesProto$BannerMessage.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/MessagesProto$BannerMessage;
      //   465: areturn
      //   466: aload_2
      //   467: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   470: astore_1
      //   471: aload_3
      //   472: checkcast com/google/firebase/inappmessaging/MessagesProto$BannerMessage
      //   475: astore_2
      //   476: aload_0
      //   477: aload_1
      //   478: aload_0
      //   479: getfield title_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   482: aload_2
      //   483: getfield title_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   486: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   491: checkcast com/google/firebase/inappmessaging/MessagesProto$Text
      //   494: putfield title_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   497: aload_0
      //   498: aload_1
      //   499: aload_0
      //   500: getfield body_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   503: aload_2
      //   504: getfield body_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   507: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   512: checkcast com/google/firebase/inappmessaging/MessagesProto$Text
      //   515: putfield body_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   518: aload_0
      //   519: aload_1
      //   520: aload_0
      //   521: getfield imageUrl_ : Ljava/lang/String;
      //   524: invokevirtual isEmpty : ()Z
      //   527: iconst_1
      //   528: ixor
      //   529: aload_0
      //   530: getfield imageUrl_ : Ljava/lang/String;
      //   533: aload_2
      //   534: getfield imageUrl_ : Ljava/lang/String;
      //   537: invokevirtual isEmpty : ()Z
      //   540: iconst_1
      //   541: ixor
      //   542: aload_2
      //   543: getfield imageUrl_ : Ljava/lang/String;
      //   546: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   551: putfield imageUrl_ : Ljava/lang/String;
      //   554: aload_0
      //   555: aload_1
      //   556: aload_0
      //   557: getfield action_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   560: aload_2
      //   561: getfield action_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   564: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   569: checkcast com/google/firebase/inappmessaging/MessagesProto$Action
      //   572: putfield action_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   575: aload_0
      //   576: aload_1
      //   577: aload_0
      //   578: getfield backgroundHexColor_ : Ljava/lang/String;
      //   581: invokevirtual isEmpty : ()Z
      //   584: iconst_1
      //   585: ixor
      //   586: aload_0
      //   587: getfield backgroundHexColor_ : Ljava/lang/String;
      //   590: iconst_1
      //   591: aload_2
      //   592: getfield backgroundHexColor_ : Ljava/lang/String;
      //   595: invokevirtual isEmpty : ()Z
      //   598: ixor
      //   599: aload_2
      //   600: getfield backgroundHexColor_ : Ljava/lang/String;
      //   603: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   608: putfield backgroundHexColor_ : Ljava/lang/String;
      //   611: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   614: astore_1
      //   615: aload_0
      //   616: areturn
      //   617: new com/google/firebase/inappmessaging/MessagesProto$BannerMessage$Builder
      //   620: dup
      //   621: aconst_null
      //   622: invokespecial <init> : (Lcom/google/firebase/inappmessaging/MessagesProto$1;)V
      //   625: areturn
      //   626: aconst_null
      //   627: areturn
      //   628: getstatic com/google/firebase/inappmessaging/MessagesProto$BannerMessage.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/MessagesProto$BannerMessage;
      //   631: areturn
      //   632: new com/google/firebase/inappmessaging/MessagesProto$BannerMessage
      //   635: dup
      //   636: invokespecial <init> : ()V
      //   639: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	444	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	416	java/io/IOException
      //   128	134	412	finally
      //   174	183	444	com/google/protobuf/InvalidProtocolBufferException
      //   174	183	416	java/io/IOException
      //   174	183	412	finally
      //   189	197	444	com/google/protobuf/InvalidProtocolBufferException
      //   189	197	416	java/io/IOException
      //   189	197	412	finally
      //   200	218	444	com/google/protobuf/InvalidProtocolBufferException
      //   200	218	416	java/io/IOException
      //   200	218	412	finally
      //   223	238	444	com/google/protobuf/InvalidProtocolBufferException
      //   223	238	416	java/io/IOException
      //   223	238	412	finally
      //   242	262	444	com/google/protobuf/InvalidProtocolBufferException
      //   242	262	416	java/io/IOException
      //   242	262	412	finally
      //   265	273	444	com/google/protobuf/InvalidProtocolBufferException
      //   265	273	416	java/io/IOException
      //   265	273	412	finally
      //   276	294	444	com/google/protobuf/InvalidProtocolBufferException
      //   276	294	416	java/io/IOException
      //   276	294	412	finally
      //   299	314	444	com/google/protobuf/InvalidProtocolBufferException
      //   299	314	416	java/io/IOException
      //   299	314	412	finally
      //   318	338	444	com/google/protobuf/InvalidProtocolBufferException
      //   318	338	416	java/io/IOException
      //   318	338	412	finally
      //   341	359	444	com/google/protobuf/InvalidProtocolBufferException
      //   341	359	416	java/io/IOException
      //   341	359	412	finally
      //   364	379	444	com/google/protobuf/InvalidProtocolBufferException
      //   364	379	416	java/io/IOException
      //   364	379	412	finally
      //   383	403	444	com/google/protobuf/InvalidProtocolBufferException
      //   383	403	416	java/io/IOException
      //   383	403	412	finally
      //   417	444	412	finally
      //   445	460	412	finally
    }
    
    public MessagesProto.Action getAction() {
      MessagesProto.Action action1 = this.action_;
      MessagesProto.Action action2 = action1;
      if (action1 == null)
        action2 = MessagesProto.Action.getDefaultInstance(); 
      return action2;
    }
    
    public String getBackgroundHexColor() {
      return this.backgroundHexColor_;
    }
    
    public ByteString getBackgroundHexColorBytes() {
      return ByteString.copyFromUtf8(this.backgroundHexColor_);
    }
    
    public MessagesProto.Text getBody() {
      MessagesProto.Text text1 = this.body_;
      MessagesProto.Text text2 = text1;
      if (text1 == null)
        text2 = MessagesProto.Text.getDefaultInstance(); 
      return text2;
    }
    
    public String getImageUrl() {
      return this.imageUrl_;
    }
    
    public ByteString getImageUrlBytes() {
      return ByteString.copyFromUtf8(this.imageUrl_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (this.title_ != null)
        i = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)getTitle()); 
      int j = i;
      if (this.body_ != null)
        j = i + CodedOutputStream.computeMessageSize(2, (MessageLite)getBody()); 
      i = j;
      if (!this.imageUrl_.isEmpty())
        i = j + CodedOutputStream.computeStringSize(3, getImageUrl()); 
      j = i;
      if (this.action_ != null)
        j = i + CodedOutputStream.computeMessageSize(4, (MessageLite)getAction()); 
      i = j;
      if (!this.backgroundHexColor_.isEmpty())
        i = j + CodedOutputStream.computeStringSize(5, getBackgroundHexColor()); 
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public MessagesProto.Text getTitle() {
      MessagesProto.Text text1 = this.title_;
      MessagesProto.Text text2 = text1;
      if (text1 == null)
        text2 = MessagesProto.Text.getDefaultInstance(); 
      return text2;
    }
    
    public boolean hasAction() {
      boolean bool;
      if (this.action_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasBody() {
      boolean bool;
      if (this.body_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasTitle() {
      boolean bool;
      if (this.title_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.title_ != null)
        param1CodedOutputStream.writeMessage(1, (MessageLite)getTitle()); 
      if (this.body_ != null)
        param1CodedOutputStream.writeMessage(2, (MessageLite)getBody()); 
      if (!this.imageUrl_.isEmpty())
        param1CodedOutputStream.writeString(3, getImageUrl()); 
      if (this.action_ != null)
        param1CodedOutputStream.writeMessage(4, (MessageLite)getAction()); 
      if (!this.backgroundHexColor_.isEmpty())
        param1CodedOutputStream.writeString(5, getBackgroundHexColor()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<BannerMessage, Builder> implements MessagesProto.BannerMessageOrBuilder {
      private Builder() {
        super(MessagesProto.BannerMessage.DEFAULT_INSTANCE);
      }
      
      public Builder clearAction() {
        copyOnWrite();
        ((MessagesProto.BannerMessage)this.instance).clearAction();
        return this;
      }
      
      public Builder clearBackgroundHexColor() {
        copyOnWrite();
        ((MessagesProto.BannerMessage)this.instance).clearBackgroundHexColor();
        return this;
      }
      
      public Builder clearBody() {
        copyOnWrite();
        ((MessagesProto.BannerMessage)this.instance).clearBody();
        return this;
      }
      
      public Builder clearImageUrl() {
        copyOnWrite();
        ((MessagesProto.BannerMessage)this.instance).clearImageUrl();
        return this;
      }
      
      public Builder clearTitle() {
        copyOnWrite();
        ((MessagesProto.BannerMessage)this.instance).clearTitle();
        return this;
      }
      
      public MessagesProto.Action getAction() {
        return ((MessagesProto.BannerMessage)this.instance).getAction();
      }
      
      public String getBackgroundHexColor() {
        return ((MessagesProto.BannerMessage)this.instance).getBackgroundHexColor();
      }
      
      public ByteString getBackgroundHexColorBytes() {
        return ((MessagesProto.BannerMessage)this.instance).getBackgroundHexColorBytes();
      }
      
      public MessagesProto.Text getBody() {
        return ((MessagesProto.BannerMessage)this.instance).getBody();
      }
      
      public String getImageUrl() {
        return ((MessagesProto.BannerMessage)this.instance).getImageUrl();
      }
      
      public ByteString getImageUrlBytes() {
        return ((MessagesProto.BannerMessage)this.instance).getImageUrlBytes();
      }
      
      public MessagesProto.Text getTitle() {
        return ((MessagesProto.BannerMessage)this.instance).getTitle();
      }
      
      public boolean hasAction() {
        return ((MessagesProto.BannerMessage)this.instance).hasAction();
      }
      
      public boolean hasBody() {
        return ((MessagesProto.BannerMessage)this.instance).hasBody();
      }
      
      public boolean hasTitle() {
        return ((MessagesProto.BannerMessage)this.instance).hasTitle();
      }
      
      public Builder mergeAction(MessagesProto.Action param2Action) {
        copyOnWrite();
        ((MessagesProto.BannerMessage)this.instance).mergeAction(param2Action);
        return this;
      }
      
      public Builder mergeBody(MessagesProto.Text param2Text) {
        copyOnWrite();
        ((MessagesProto.BannerMessage)this.instance).mergeBody(param2Text);
        return this;
      }
      
      public Builder mergeTitle(MessagesProto.Text param2Text) {
        copyOnWrite();
        ((MessagesProto.BannerMessage)this.instance).mergeTitle(param2Text);
        return this;
      }
      
      public Builder setAction(MessagesProto.Action.Builder param2Builder) {
        copyOnWrite();
        ((MessagesProto.BannerMessage)this.instance).setAction(param2Builder);
        return this;
      }
      
      public Builder setAction(MessagesProto.Action param2Action) {
        copyOnWrite();
        ((MessagesProto.BannerMessage)this.instance).setAction(param2Action);
        return this;
      }
      
      public Builder setBackgroundHexColor(String param2String) {
        copyOnWrite();
        ((MessagesProto.BannerMessage)this.instance).setBackgroundHexColor(param2String);
        return this;
      }
      
      public Builder setBackgroundHexColorBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((MessagesProto.BannerMessage)this.instance).setBackgroundHexColorBytes(param2ByteString);
        return this;
      }
      
      public Builder setBody(MessagesProto.Text.Builder param2Builder) {
        copyOnWrite();
        ((MessagesProto.BannerMessage)this.instance).setBody(param2Builder);
        return this;
      }
      
      public Builder setBody(MessagesProto.Text param2Text) {
        copyOnWrite();
        ((MessagesProto.BannerMessage)this.instance).setBody(param2Text);
        return this;
      }
      
      public Builder setImageUrl(String param2String) {
        copyOnWrite();
        ((MessagesProto.BannerMessage)this.instance).setImageUrl(param2String);
        return this;
      }
      
      public Builder setImageUrlBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((MessagesProto.BannerMessage)this.instance).setImageUrlBytes(param2ByteString);
        return this;
      }
      
      public Builder setTitle(MessagesProto.Text.Builder param2Builder) {
        copyOnWrite();
        ((MessagesProto.BannerMessage)this.instance).setTitle(param2Builder);
        return this;
      }
      
      public Builder setTitle(MessagesProto.Text param2Text) {
        copyOnWrite();
        ((MessagesProto.BannerMessage)this.instance).setTitle(param2Text);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<BannerMessage, BannerMessage.Builder> implements BannerMessageOrBuilder {
    private Builder() {
      super(MessagesProto.BannerMessage.DEFAULT_INSTANCE);
    }
    
    public Builder clearAction() {
      copyOnWrite();
      ((MessagesProto.BannerMessage)this.instance).clearAction();
      return this;
    }
    
    public Builder clearBackgroundHexColor() {
      copyOnWrite();
      ((MessagesProto.BannerMessage)this.instance).clearBackgroundHexColor();
      return this;
    }
    
    public Builder clearBody() {
      copyOnWrite();
      ((MessagesProto.BannerMessage)this.instance).clearBody();
      return this;
    }
    
    public Builder clearImageUrl() {
      copyOnWrite();
      ((MessagesProto.BannerMessage)this.instance).clearImageUrl();
      return this;
    }
    
    public Builder clearTitle() {
      copyOnWrite();
      ((MessagesProto.BannerMessage)this.instance).clearTitle();
      return this;
    }
    
    public MessagesProto.Action getAction() {
      return ((MessagesProto.BannerMessage)this.instance).getAction();
    }
    
    public String getBackgroundHexColor() {
      return ((MessagesProto.BannerMessage)this.instance).getBackgroundHexColor();
    }
    
    public ByteString getBackgroundHexColorBytes() {
      return ((MessagesProto.BannerMessage)this.instance).getBackgroundHexColorBytes();
    }
    
    public MessagesProto.Text getBody() {
      return ((MessagesProto.BannerMessage)this.instance).getBody();
    }
    
    public String getImageUrl() {
      return ((MessagesProto.BannerMessage)this.instance).getImageUrl();
    }
    
    public ByteString getImageUrlBytes() {
      return ((MessagesProto.BannerMessage)this.instance).getImageUrlBytes();
    }
    
    public MessagesProto.Text getTitle() {
      return ((MessagesProto.BannerMessage)this.instance).getTitle();
    }
    
    public boolean hasAction() {
      return ((MessagesProto.BannerMessage)this.instance).hasAction();
    }
    
    public boolean hasBody() {
      return ((MessagesProto.BannerMessage)this.instance).hasBody();
    }
    
    public boolean hasTitle() {
      return ((MessagesProto.BannerMessage)this.instance).hasTitle();
    }
    
    public Builder mergeAction(MessagesProto.Action param1Action) {
      copyOnWrite();
      ((MessagesProto.BannerMessage)this.instance).mergeAction(param1Action);
      return this;
    }
    
    public Builder mergeBody(MessagesProto.Text param1Text) {
      copyOnWrite();
      ((MessagesProto.BannerMessage)this.instance).mergeBody(param1Text);
      return this;
    }
    
    public Builder mergeTitle(MessagesProto.Text param1Text) {
      copyOnWrite();
      ((MessagesProto.BannerMessage)this.instance).mergeTitle(param1Text);
      return this;
    }
    
    public Builder setAction(MessagesProto.Action.Builder param1Builder) {
      copyOnWrite();
      ((MessagesProto.BannerMessage)this.instance).setAction(param1Builder);
      return this;
    }
    
    public Builder setAction(MessagesProto.Action param1Action) {
      copyOnWrite();
      ((MessagesProto.BannerMessage)this.instance).setAction(param1Action);
      return this;
    }
    
    public Builder setBackgroundHexColor(String param1String) {
      copyOnWrite();
      ((MessagesProto.BannerMessage)this.instance).setBackgroundHexColor(param1String);
      return this;
    }
    
    public Builder setBackgroundHexColorBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((MessagesProto.BannerMessage)this.instance).setBackgroundHexColorBytes(param1ByteString);
      return this;
    }
    
    public Builder setBody(MessagesProto.Text.Builder param1Builder) {
      copyOnWrite();
      ((MessagesProto.BannerMessage)this.instance).setBody(param1Builder);
      return this;
    }
    
    public Builder setBody(MessagesProto.Text param1Text) {
      copyOnWrite();
      ((MessagesProto.BannerMessage)this.instance).setBody(param1Text);
      return this;
    }
    
    public Builder setImageUrl(String param1String) {
      copyOnWrite();
      ((MessagesProto.BannerMessage)this.instance).setImageUrl(param1String);
      return this;
    }
    
    public Builder setImageUrlBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((MessagesProto.BannerMessage)this.instance).setImageUrlBytes(param1ByteString);
      return this;
    }
    
    public Builder setTitle(MessagesProto.Text.Builder param1Builder) {
      copyOnWrite();
      ((MessagesProto.BannerMessage)this.instance).setTitle(param1Builder);
      return this;
    }
    
    public Builder setTitle(MessagesProto.Text param1Text) {
      copyOnWrite();
      ((MessagesProto.BannerMessage)this.instance).setTitle(param1Text);
      return this;
    }
  }
  
  public static interface BannerMessageOrBuilder extends MessageLiteOrBuilder {
    MessagesProto.Action getAction();
    
    String getBackgroundHexColor();
    
    ByteString getBackgroundHexColorBytes();
    
    MessagesProto.Text getBody();
    
    String getImageUrl();
    
    ByteString getImageUrlBytes();
    
    MessagesProto.Text getTitle();
    
    boolean hasAction();
    
    boolean hasBody();
    
    boolean hasTitle();
  }
  
  public static final class Button extends GeneratedMessageLite<Button, Button.Builder> implements ButtonOrBuilder {
    public static final int BUTTON_HEX_COLOR_FIELD_NUMBER = 2;
    
    private static final Button DEFAULT_INSTANCE = new Button();
    
    private static volatile Parser<Button> PARSER;
    
    public static final int TEXT_FIELD_NUMBER = 1;
    
    private String buttonHexColor_ = "";
    
    private MessagesProto.Text text_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearButtonHexColor() {
      this.buttonHexColor_ = getDefaultInstance().getButtonHexColor();
    }
    
    private void clearText() {
      this.text_ = null;
    }
    
    public static Button getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeText(MessagesProto.Text param1Text) {
      MessagesProto.Text text = this.text_;
      if (text != null && text != MessagesProto.Text.getDefaultInstance()) {
        this.text_ = (MessagesProto.Text)((MessagesProto.Text.Builder)MessagesProto.Text.newBuilder(this.text_).mergeFrom(param1Text)).buildPartial();
      } else {
        this.text_ = param1Text;
      } 
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Button param1Button) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1Button);
    }
    
    public static Button parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Button)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Button parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Button)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Button parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Button)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static Button parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Button)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Button parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Button)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static Button parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Button)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Button parseFrom(InputStream param1InputStream) throws IOException {
      return (Button)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Button parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Button)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Button parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Button)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static Button parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Button)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Button> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setButtonHexColor(String param1String) {
      if (param1String != null) {
        this.buttonHexColor_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setButtonHexColorBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.buttonHexColor_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setText(MessagesProto.Text.Builder param1Builder) {
      this.text_ = (MessagesProto.Text)param1Builder.build();
    }
    
    private void setText(MessagesProto.Text param1Text) {
      if (param1Text != null) {
        this.text_ = param1Text;
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firebase/inappmessaging/MessagesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 392, 2 -> 388, 3 -> 386, 4 -> 377, 5 -> 304, 6 -> 110, 7 -> 300, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/firebase/inappmessaging/MessagesProto$Button.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/firebase/inappmessaging/MessagesProto$Button
      //   72: monitorenter
      //   73: getstatic com/google/firebase/inappmessaging/MessagesProto$Button.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/firebase/inappmessaging/MessagesProto$Button.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/MessagesProto$Button;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/firebase/inappmessaging/MessagesProto$Button.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/firebase/inappmessaging/MessagesProto$Button
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/firebase/inappmessaging/MessagesProto$Button
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/firebase/inappmessaging/MessagesProto$Button.PARSER : Lcom/google/protobuf/Parser;
      //   109: areturn
      //   110: aload_2
      //   111: checkcast com/google/protobuf/CodedInputStream
      //   114: astore_2
      //   115: aload_3
      //   116: checkcast com/google/protobuf/ExtensionRegistryLite
      //   119: astore_3
      //   120: iconst_0
      //   121: istore #4
      //   123: iload #4
      //   125: ifne -> 300
      //   128: aload_2
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 244
      //   139: iload #5
      //   141: bipush #10
      //   143: if_icmpeq -> 179
      //   146: iload #5
      //   148: bipush #18
      //   150: if_icmpeq -> 168
      //   153: aload_2
      //   154: iload #5
      //   156: invokevirtual skipField : (I)Z
      //   159: ifne -> 123
      //   162: iconst_1
      //   163: istore #4
      //   165: goto -> 123
      //   168: aload_0
      //   169: aload_2
      //   170: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   173: putfield buttonHexColor_ : Ljava/lang/String;
      //   176: goto -> 123
      //   179: aload_0
      //   180: getfield text_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   183: ifnull -> 200
      //   186: aload_0
      //   187: getfield text_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   190: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   193: checkcast com/google/firebase/inappmessaging/MessagesProto$Text$Builder
      //   196: astore_1
      //   197: goto -> 202
      //   200: aconst_null
      //   201: astore_1
      //   202: aload_0
      //   203: aload_2
      //   204: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   207: aload_3
      //   208: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   211: checkcast com/google/firebase/inappmessaging/MessagesProto$Text
      //   214: putfield text_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   217: aload_1
      //   218: ifnull -> 123
      //   221: aload_1
      //   222: aload_0
      //   223: getfield text_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   226: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   229: pop
      //   230: aload_0
      //   231: aload_1
      //   232: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   235: checkcast com/google/firebase/inappmessaging/MessagesProto$Text
      //   238: putfield text_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
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
      //   300: getstatic com/google/firebase/inappmessaging/MessagesProto$Button.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/MessagesProto$Button;
      //   303: areturn
      //   304: aload_2
      //   305: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   308: astore_1
      //   309: aload_3
      //   310: checkcast com/google/firebase/inappmessaging/MessagesProto$Button
      //   313: astore_2
      //   314: aload_0
      //   315: aload_1
      //   316: aload_0
      //   317: getfield text_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   320: aload_2
      //   321: getfield text_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   324: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   329: checkcast com/google/firebase/inappmessaging/MessagesProto$Text
      //   332: putfield text_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   335: aload_0
      //   336: aload_1
      //   337: aload_0
      //   338: getfield buttonHexColor_ : Ljava/lang/String;
      //   341: invokevirtual isEmpty : ()Z
      //   344: iconst_1
      //   345: ixor
      //   346: aload_0
      //   347: getfield buttonHexColor_ : Ljava/lang/String;
      //   350: iconst_1
      //   351: aload_2
      //   352: getfield buttonHexColor_ : Ljava/lang/String;
      //   355: invokevirtual isEmpty : ()Z
      //   358: ixor
      //   359: aload_2
      //   360: getfield buttonHexColor_ : Ljava/lang/String;
      //   363: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   368: putfield buttonHexColor_ : Ljava/lang/String;
      //   371: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   374: astore_1
      //   375: aload_0
      //   376: areturn
      //   377: new com/google/firebase/inappmessaging/MessagesProto$Button$Builder
      //   380: dup
      //   381: aconst_null
      //   382: invokespecial <init> : (Lcom/google/firebase/inappmessaging/MessagesProto$1;)V
      //   385: areturn
      //   386: aconst_null
      //   387: areturn
      //   388: getstatic com/google/firebase/inappmessaging/MessagesProto$Button.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/MessagesProto$Button;
      //   391: areturn
      //   392: new com/google/firebase/inappmessaging/MessagesProto$Button
      //   395: dup
      //   396: invokespecial <init> : ()V
      //   399: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	282	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	254	java/io/IOException
      //   128	134	250	finally
      //   153	162	282	com/google/protobuf/InvalidProtocolBufferException
      //   153	162	254	java/io/IOException
      //   153	162	250	finally
      //   168	176	282	com/google/protobuf/InvalidProtocolBufferException
      //   168	176	254	java/io/IOException
      //   168	176	250	finally
      //   179	197	282	com/google/protobuf/InvalidProtocolBufferException
      //   179	197	254	java/io/IOException
      //   179	197	250	finally
      //   202	217	282	com/google/protobuf/InvalidProtocolBufferException
      //   202	217	254	java/io/IOException
      //   202	217	250	finally
      //   221	241	282	com/google/protobuf/InvalidProtocolBufferException
      //   221	241	254	java/io/IOException
      //   221	241	250	finally
      //   255	282	250	finally
      //   283	298	250	finally
    }
    
    public String getButtonHexColor() {
      return this.buttonHexColor_;
    }
    
    public ByteString getButtonHexColorBytes() {
      return ByteString.copyFromUtf8(this.buttonHexColor_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (this.text_ != null)
        i = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)getText()); 
      int j = i;
      if (!this.buttonHexColor_.isEmpty())
        j = i + CodedOutputStream.computeStringSize(2, getButtonHexColor()); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public MessagesProto.Text getText() {
      MessagesProto.Text text1 = this.text_;
      MessagesProto.Text text2 = text1;
      if (text1 == null)
        text2 = MessagesProto.Text.getDefaultInstance(); 
      return text2;
    }
    
    public boolean hasText() {
      boolean bool;
      if (this.text_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.text_ != null)
        param1CodedOutputStream.writeMessage(1, (MessageLite)getText()); 
      if (!this.buttonHexColor_.isEmpty())
        param1CodedOutputStream.writeString(2, getButtonHexColor()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Button, Builder> implements MessagesProto.ButtonOrBuilder {
      private Builder() {
        super(MessagesProto.Button.DEFAULT_INSTANCE);
      }
      
      public Builder clearButtonHexColor() {
        copyOnWrite();
        ((MessagesProto.Button)this.instance).clearButtonHexColor();
        return this;
      }
      
      public Builder clearText() {
        copyOnWrite();
        ((MessagesProto.Button)this.instance).clearText();
        return this;
      }
      
      public String getButtonHexColor() {
        return ((MessagesProto.Button)this.instance).getButtonHexColor();
      }
      
      public ByteString getButtonHexColorBytes() {
        return ((MessagesProto.Button)this.instance).getButtonHexColorBytes();
      }
      
      public MessagesProto.Text getText() {
        return ((MessagesProto.Button)this.instance).getText();
      }
      
      public boolean hasText() {
        return ((MessagesProto.Button)this.instance).hasText();
      }
      
      public Builder mergeText(MessagesProto.Text param2Text) {
        copyOnWrite();
        ((MessagesProto.Button)this.instance).mergeText(param2Text);
        return this;
      }
      
      public Builder setButtonHexColor(String param2String) {
        copyOnWrite();
        ((MessagesProto.Button)this.instance).setButtonHexColor(param2String);
        return this;
      }
      
      public Builder setButtonHexColorBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((MessagesProto.Button)this.instance).setButtonHexColorBytes(param2ByteString);
        return this;
      }
      
      public Builder setText(MessagesProto.Text.Builder param2Builder) {
        copyOnWrite();
        ((MessagesProto.Button)this.instance).setText(param2Builder);
        return this;
      }
      
      public Builder setText(MessagesProto.Text param2Text) {
        copyOnWrite();
        ((MessagesProto.Button)this.instance).setText(param2Text);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Button, Button.Builder> implements ButtonOrBuilder {
    private Builder() {
      super(MessagesProto.Button.DEFAULT_INSTANCE);
    }
    
    public Builder clearButtonHexColor() {
      copyOnWrite();
      ((MessagesProto.Button)this.instance).clearButtonHexColor();
      return this;
    }
    
    public Builder clearText() {
      copyOnWrite();
      ((MessagesProto.Button)this.instance).clearText();
      return this;
    }
    
    public String getButtonHexColor() {
      return ((MessagesProto.Button)this.instance).getButtonHexColor();
    }
    
    public ByteString getButtonHexColorBytes() {
      return ((MessagesProto.Button)this.instance).getButtonHexColorBytes();
    }
    
    public MessagesProto.Text getText() {
      return ((MessagesProto.Button)this.instance).getText();
    }
    
    public boolean hasText() {
      return ((MessagesProto.Button)this.instance).hasText();
    }
    
    public Builder mergeText(MessagesProto.Text param1Text) {
      copyOnWrite();
      ((MessagesProto.Button)this.instance).mergeText(param1Text);
      return this;
    }
    
    public Builder setButtonHexColor(String param1String) {
      copyOnWrite();
      ((MessagesProto.Button)this.instance).setButtonHexColor(param1String);
      return this;
    }
    
    public Builder setButtonHexColorBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((MessagesProto.Button)this.instance).setButtonHexColorBytes(param1ByteString);
      return this;
    }
    
    public Builder setText(MessagesProto.Text.Builder param1Builder) {
      copyOnWrite();
      ((MessagesProto.Button)this.instance).setText(param1Builder);
      return this;
    }
    
    public Builder setText(MessagesProto.Text param1Text) {
      copyOnWrite();
      ((MessagesProto.Button)this.instance).setText(param1Text);
      return this;
    }
  }
  
  public static interface ButtonOrBuilder extends MessageLiteOrBuilder {
    String getButtonHexColor();
    
    ByteString getButtonHexColorBytes();
    
    MessagesProto.Text getText();
    
    boolean hasText();
  }
  
  public static final class CardMessage extends GeneratedMessageLite<CardMessage, CardMessage.Builder> implements CardMessageOrBuilder {
    public static final int BACKGROUND_HEX_COLOR_FIELD_NUMBER = 5;
    
    public static final int BODY_FIELD_NUMBER = 2;
    
    private static final CardMessage DEFAULT_INSTANCE = new CardMessage();
    
    public static final int LANDSCAPE_IMAGE_URL_FIELD_NUMBER = 4;
    
    private static volatile Parser<CardMessage> PARSER;
    
    public static final int PORTRAIT_IMAGE_URL_FIELD_NUMBER = 3;
    
    public static final int PRIMARY_ACTION_BUTTON_FIELD_NUMBER = 6;
    
    public static final int PRIMARY_ACTION_FIELD_NUMBER = 7;
    
    public static final int SECONDARY_ACTION_BUTTON_FIELD_NUMBER = 8;
    
    public static final int SECONDARY_ACTION_FIELD_NUMBER = 9;
    
    public static final int TITLE_FIELD_NUMBER = 1;
    
    private String backgroundHexColor_ = "";
    
    private MessagesProto.Text body_;
    
    private String landscapeImageUrl_ = "";
    
    private String portraitImageUrl_ = "";
    
    private MessagesProto.Button primaryActionButton_;
    
    private MessagesProto.Action primaryAction_;
    
    private MessagesProto.Button secondaryActionButton_;
    
    private MessagesProto.Action secondaryAction_;
    
    private MessagesProto.Text title_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearBackgroundHexColor() {
      this.backgroundHexColor_ = getDefaultInstance().getBackgroundHexColor();
    }
    
    private void clearBody() {
      this.body_ = null;
    }
    
    private void clearLandscapeImageUrl() {
      this.landscapeImageUrl_ = getDefaultInstance().getLandscapeImageUrl();
    }
    
    private void clearPortraitImageUrl() {
      this.portraitImageUrl_ = getDefaultInstance().getPortraitImageUrl();
    }
    
    private void clearPrimaryAction() {
      this.primaryAction_ = null;
    }
    
    private void clearPrimaryActionButton() {
      this.primaryActionButton_ = null;
    }
    
    private void clearSecondaryAction() {
      this.secondaryAction_ = null;
    }
    
    private void clearSecondaryActionButton() {
      this.secondaryActionButton_ = null;
    }
    
    private void clearTitle() {
      this.title_ = null;
    }
    
    public static CardMessage getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeBody(MessagesProto.Text param1Text) {
      MessagesProto.Text text = this.body_;
      if (text != null && text != MessagesProto.Text.getDefaultInstance()) {
        this.body_ = (MessagesProto.Text)((MessagesProto.Text.Builder)MessagesProto.Text.newBuilder(this.body_).mergeFrom(param1Text)).buildPartial();
      } else {
        this.body_ = param1Text;
      } 
    }
    
    private void mergePrimaryAction(MessagesProto.Action param1Action) {
      MessagesProto.Action action = this.primaryAction_;
      if (action != null && action != MessagesProto.Action.getDefaultInstance()) {
        this.primaryAction_ = (MessagesProto.Action)((MessagesProto.Action.Builder)MessagesProto.Action.newBuilder(this.primaryAction_).mergeFrom(param1Action)).buildPartial();
      } else {
        this.primaryAction_ = param1Action;
      } 
    }
    
    private void mergePrimaryActionButton(MessagesProto.Button param1Button) {
      MessagesProto.Button button = this.primaryActionButton_;
      if (button != null && button != MessagesProto.Button.getDefaultInstance()) {
        this.primaryActionButton_ = (MessagesProto.Button)((MessagesProto.Button.Builder)MessagesProto.Button.newBuilder(this.primaryActionButton_).mergeFrom(param1Button)).buildPartial();
      } else {
        this.primaryActionButton_ = param1Button;
      } 
    }
    
    private void mergeSecondaryAction(MessagesProto.Action param1Action) {
      MessagesProto.Action action = this.secondaryAction_;
      if (action != null && action != MessagesProto.Action.getDefaultInstance()) {
        this.secondaryAction_ = (MessagesProto.Action)((MessagesProto.Action.Builder)MessagesProto.Action.newBuilder(this.secondaryAction_).mergeFrom(param1Action)).buildPartial();
      } else {
        this.secondaryAction_ = param1Action;
      } 
    }
    
    private void mergeSecondaryActionButton(MessagesProto.Button param1Button) {
      MessagesProto.Button button = this.secondaryActionButton_;
      if (button != null && button != MessagesProto.Button.getDefaultInstance()) {
        this.secondaryActionButton_ = (MessagesProto.Button)((MessagesProto.Button.Builder)MessagesProto.Button.newBuilder(this.secondaryActionButton_).mergeFrom(param1Button)).buildPartial();
      } else {
        this.secondaryActionButton_ = param1Button;
      } 
    }
    
    private void mergeTitle(MessagesProto.Text param1Text) {
      MessagesProto.Text text = this.title_;
      if (text != null && text != MessagesProto.Text.getDefaultInstance()) {
        this.title_ = (MessagesProto.Text)((MessagesProto.Text.Builder)MessagesProto.Text.newBuilder(this.title_).mergeFrom(param1Text)).buildPartial();
      } else {
        this.title_ = param1Text;
      } 
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(CardMessage param1CardMessage) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1CardMessage);
    }
    
    public static CardMessage parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (CardMessage)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static CardMessage parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CardMessage)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static CardMessage parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (CardMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static CardMessage parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CardMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static CardMessage parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (CardMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static CardMessage parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CardMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static CardMessage parseFrom(InputStream param1InputStream) throws IOException {
      return (CardMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static CardMessage parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CardMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static CardMessage parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (CardMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static CardMessage parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CardMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<CardMessage> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setBackgroundHexColor(String param1String) {
      if (param1String != null) {
        this.backgroundHexColor_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setBackgroundHexColorBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.backgroundHexColor_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setBody(MessagesProto.Text.Builder param1Builder) {
      this.body_ = (MessagesProto.Text)param1Builder.build();
    }
    
    private void setBody(MessagesProto.Text param1Text) {
      if (param1Text != null) {
        this.body_ = param1Text;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setLandscapeImageUrl(String param1String) {
      if (param1String != null) {
        this.landscapeImageUrl_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setLandscapeImageUrlBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.landscapeImageUrl_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setPortraitImageUrl(String param1String) {
      if (param1String != null) {
        this.portraitImageUrl_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setPortraitImageUrlBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.portraitImageUrl_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setPrimaryAction(MessagesProto.Action.Builder param1Builder) {
      this.primaryAction_ = (MessagesProto.Action)param1Builder.build();
    }
    
    private void setPrimaryAction(MessagesProto.Action param1Action) {
      if (param1Action != null) {
        this.primaryAction_ = param1Action;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setPrimaryActionButton(MessagesProto.Button.Builder param1Builder) {
      this.primaryActionButton_ = (MessagesProto.Button)param1Builder.build();
    }
    
    private void setPrimaryActionButton(MessagesProto.Button param1Button) {
      if (param1Button != null) {
        this.primaryActionButton_ = param1Button;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setSecondaryAction(MessagesProto.Action.Builder param1Builder) {
      this.secondaryAction_ = (MessagesProto.Action)param1Builder.build();
    }
    
    private void setSecondaryAction(MessagesProto.Action param1Action) {
      if (param1Action != null) {
        this.secondaryAction_ = param1Action;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setSecondaryActionButton(MessagesProto.Button.Builder param1Builder) {
      this.secondaryActionButton_ = (MessagesProto.Button)param1Builder.build();
    }
    
    private void setSecondaryActionButton(MessagesProto.Button param1Button) {
      if (param1Button != null) {
        this.secondaryActionButton_ = param1Button;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTitle(MessagesProto.Text.Builder param1Builder) {
      this.title_ = (MessagesProto.Text)param1Builder.build();
    }
    
    private void setTitle(MessagesProto.Text param1Text) {
      if (param1Text != null) {
        this.title_ = param1Text;
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firebase/inappmessaging/MessagesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 965, 2 -> 961, 3 -> 959, 4 -> 950, 5 -> 700, 6 -> 110, 7 -> 696, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/firebase/inappmessaging/MessagesProto$CardMessage.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/firebase/inappmessaging/MessagesProto$CardMessage
      //   72: monitorenter
      //   73: getstatic com/google/firebase/inappmessaging/MessagesProto$CardMessage.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/firebase/inappmessaging/MessagesProto$CardMessage.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/MessagesProto$CardMessage;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/firebase/inappmessaging/MessagesProto$CardMessage.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/firebase/inappmessaging/MessagesProto$CardMessage
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/firebase/inappmessaging/MessagesProto$CardMessage
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/firebase/inappmessaging/MessagesProto$CardMessage.PARSER : Lcom/google/protobuf/Parser;
      //   109: areturn
      //   110: aload_2
      //   111: checkcast com/google/protobuf/CodedInputStream
      //   114: astore_2
      //   115: aload_3
      //   116: checkcast com/google/protobuf/ExtensionRegistryLite
      //   119: astore_3
      //   120: iconst_0
      //   121: istore #4
      //   123: iload #4
      //   125: ifne -> 696
      //   128: aload_2
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 640
      //   139: iload #5
      //   141: bipush #10
      //   143: if_icmpeq -> 575
      //   146: iload #5
      //   148: bipush #18
      //   150: if_icmpeq -> 510
      //   153: iload #5
      //   155: bipush #26
      //   157: if_icmpeq -> 499
      //   160: iload #5
      //   162: bipush #34
      //   164: if_icmpeq -> 488
      //   167: iload #5
      //   169: bipush #42
      //   171: if_icmpeq -> 477
      //   174: iload #5
      //   176: bipush #50
      //   178: if_icmpeq -> 412
      //   181: iload #5
      //   183: bipush #58
      //   185: if_icmpeq -> 347
      //   188: iload #5
      //   190: bipush #66
      //   192: if_icmpeq -> 282
      //   195: iload #5
      //   197: bipush #74
      //   199: if_icmpeq -> 217
      //   202: aload_2
      //   203: iload #5
      //   205: invokevirtual skipField : (I)Z
      //   208: ifne -> 123
      //   211: iconst_1
      //   212: istore #4
      //   214: goto -> 123
      //   217: aload_0
      //   218: getfield secondaryAction_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   221: ifnull -> 238
      //   224: aload_0
      //   225: getfield secondaryAction_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   228: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   231: checkcast com/google/firebase/inappmessaging/MessagesProto$Action$Builder
      //   234: astore_1
      //   235: goto -> 240
      //   238: aconst_null
      //   239: astore_1
      //   240: aload_0
      //   241: aload_2
      //   242: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   245: aload_3
      //   246: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   249: checkcast com/google/firebase/inappmessaging/MessagesProto$Action
      //   252: putfield secondaryAction_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   255: aload_1
      //   256: ifnull -> 123
      //   259: aload_1
      //   260: aload_0
      //   261: getfield secondaryAction_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   264: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   267: pop
      //   268: aload_0
      //   269: aload_1
      //   270: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   273: checkcast com/google/firebase/inappmessaging/MessagesProto$Action
      //   276: putfield secondaryAction_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   279: goto -> 123
      //   282: aload_0
      //   283: getfield secondaryActionButton_ : Lcom/google/firebase/inappmessaging/MessagesProto$Button;
      //   286: ifnull -> 303
      //   289: aload_0
      //   290: getfield secondaryActionButton_ : Lcom/google/firebase/inappmessaging/MessagesProto$Button;
      //   293: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   296: checkcast com/google/firebase/inappmessaging/MessagesProto$Button$Builder
      //   299: astore_1
      //   300: goto -> 305
      //   303: aconst_null
      //   304: astore_1
      //   305: aload_0
      //   306: aload_2
      //   307: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   310: aload_3
      //   311: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   314: checkcast com/google/firebase/inappmessaging/MessagesProto$Button
      //   317: putfield secondaryActionButton_ : Lcom/google/firebase/inappmessaging/MessagesProto$Button;
      //   320: aload_1
      //   321: ifnull -> 123
      //   324: aload_1
      //   325: aload_0
      //   326: getfield secondaryActionButton_ : Lcom/google/firebase/inappmessaging/MessagesProto$Button;
      //   329: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   332: pop
      //   333: aload_0
      //   334: aload_1
      //   335: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   338: checkcast com/google/firebase/inappmessaging/MessagesProto$Button
      //   341: putfield secondaryActionButton_ : Lcom/google/firebase/inappmessaging/MessagesProto$Button;
      //   344: goto -> 123
      //   347: aload_0
      //   348: getfield primaryAction_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   351: ifnull -> 368
      //   354: aload_0
      //   355: getfield primaryAction_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   358: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   361: checkcast com/google/firebase/inappmessaging/MessagesProto$Action$Builder
      //   364: astore_1
      //   365: goto -> 370
      //   368: aconst_null
      //   369: astore_1
      //   370: aload_0
      //   371: aload_2
      //   372: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   375: aload_3
      //   376: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   379: checkcast com/google/firebase/inappmessaging/MessagesProto$Action
      //   382: putfield primaryAction_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   385: aload_1
      //   386: ifnull -> 123
      //   389: aload_1
      //   390: aload_0
      //   391: getfield primaryAction_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   394: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   397: pop
      //   398: aload_0
      //   399: aload_1
      //   400: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   403: checkcast com/google/firebase/inappmessaging/MessagesProto$Action
      //   406: putfield primaryAction_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   409: goto -> 123
      //   412: aload_0
      //   413: getfield primaryActionButton_ : Lcom/google/firebase/inappmessaging/MessagesProto$Button;
      //   416: ifnull -> 433
      //   419: aload_0
      //   420: getfield primaryActionButton_ : Lcom/google/firebase/inappmessaging/MessagesProto$Button;
      //   423: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   426: checkcast com/google/firebase/inappmessaging/MessagesProto$Button$Builder
      //   429: astore_1
      //   430: goto -> 435
      //   433: aconst_null
      //   434: astore_1
      //   435: aload_0
      //   436: aload_2
      //   437: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   440: aload_3
      //   441: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   444: checkcast com/google/firebase/inappmessaging/MessagesProto$Button
      //   447: putfield primaryActionButton_ : Lcom/google/firebase/inappmessaging/MessagesProto$Button;
      //   450: aload_1
      //   451: ifnull -> 123
      //   454: aload_1
      //   455: aload_0
      //   456: getfield primaryActionButton_ : Lcom/google/firebase/inappmessaging/MessagesProto$Button;
      //   459: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   462: pop
      //   463: aload_0
      //   464: aload_1
      //   465: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   468: checkcast com/google/firebase/inappmessaging/MessagesProto$Button
      //   471: putfield primaryActionButton_ : Lcom/google/firebase/inappmessaging/MessagesProto$Button;
      //   474: goto -> 123
      //   477: aload_0
      //   478: aload_2
      //   479: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   482: putfield backgroundHexColor_ : Ljava/lang/String;
      //   485: goto -> 123
      //   488: aload_0
      //   489: aload_2
      //   490: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   493: putfield landscapeImageUrl_ : Ljava/lang/String;
      //   496: goto -> 123
      //   499: aload_0
      //   500: aload_2
      //   501: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   504: putfield portraitImageUrl_ : Ljava/lang/String;
      //   507: goto -> 123
      //   510: aload_0
      //   511: getfield body_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   514: ifnull -> 531
      //   517: aload_0
      //   518: getfield body_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   521: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   524: checkcast com/google/firebase/inappmessaging/MessagesProto$Text$Builder
      //   527: astore_1
      //   528: goto -> 533
      //   531: aconst_null
      //   532: astore_1
      //   533: aload_0
      //   534: aload_2
      //   535: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   538: aload_3
      //   539: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   542: checkcast com/google/firebase/inappmessaging/MessagesProto$Text
      //   545: putfield body_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   548: aload_1
      //   549: ifnull -> 123
      //   552: aload_1
      //   553: aload_0
      //   554: getfield body_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   557: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   560: pop
      //   561: aload_0
      //   562: aload_1
      //   563: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   566: checkcast com/google/firebase/inappmessaging/MessagesProto$Text
      //   569: putfield body_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   572: goto -> 123
      //   575: aload_0
      //   576: getfield title_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   579: ifnull -> 596
      //   582: aload_0
      //   583: getfield title_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   586: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   589: checkcast com/google/firebase/inappmessaging/MessagesProto$Text$Builder
      //   592: astore_1
      //   593: goto -> 598
      //   596: aconst_null
      //   597: astore_1
      //   598: aload_0
      //   599: aload_2
      //   600: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   603: aload_3
      //   604: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   607: checkcast com/google/firebase/inappmessaging/MessagesProto$Text
      //   610: putfield title_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   613: aload_1
      //   614: ifnull -> 123
      //   617: aload_1
      //   618: aload_0
      //   619: getfield title_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   622: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   625: pop
      //   626: aload_0
      //   627: aload_1
      //   628: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   631: checkcast com/google/firebase/inappmessaging/MessagesProto$Text
      //   634: putfield title_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   637: goto -> 123
      //   640: iconst_1
      //   641: istore #4
      //   643: goto -> 123
      //   646: astore_1
      //   647: goto -> 694
      //   650: astore_2
      //   651: new java/lang/RuntimeException
      //   654: astore_3
      //   655: new com/google/protobuf/InvalidProtocolBufferException
      //   658: astore_1
      //   659: aload_1
      //   660: aload_2
      //   661: invokevirtual getMessage : ()Ljava/lang/String;
      //   664: invokespecial <init> : (Ljava/lang/String;)V
      //   667: aload_3
      //   668: aload_1
      //   669: aload_0
      //   670: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   673: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   676: aload_3
      //   677: athrow
      //   678: astore_2
      //   679: new java/lang/RuntimeException
      //   682: astore_1
      //   683: aload_1
      //   684: aload_2
      //   685: aload_0
      //   686: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   689: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   692: aload_1
      //   693: athrow
      //   694: aload_1
      //   695: athrow
      //   696: getstatic com/google/firebase/inappmessaging/MessagesProto$CardMessage.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/MessagesProto$CardMessage;
      //   699: areturn
      //   700: aload_2
      //   701: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   704: astore_1
      //   705: aload_3
      //   706: checkcast com/google/firebase/inappmessaging/MessagesProto$CardMessage
      //   709: astore_2
      //   710: aload_0
      //   711: aload_1
      //   712: aload_0
      //   713: getfield title_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   716: aload_2
      //   717: getfield title_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   720: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   725: checkcast com/google/firebase/inappmessaging/MessagesProto$Text
      //   728: putfield title_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   731: aload_0
      //   732: aload_1
      //   733: aload_0
      //   734: getfield body_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   737: aload_2
      //   738: getfield body_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   741: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   746: checkcast com/google/firebase/inappmessaging/MessagesProto$Text
      //   749: putfield body_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   752: aload_0
      //   753: aload_1
      //   754: aload_0
      //   755: getfield portraitImageUrl_ : Ljava/lang/String;
      //   758: invokevirtual isEmpty : ()Z
      //   761: iconst_1
      //   762: ixor
      //   763: aload_0
      //   764: getfield portraitImageUrl_ : Ljava/lang/String;
      //   767: aload_2
      //   768: getfield portraitImageUrl_ : Ljava/lang/String;
      //   771: invokevirtual isEmpty : ()Z
      //   774: iconst_1
      //   775: ixor
      //   776: aload_2
      //   777: getfield portraitImageUrl_ : Ljava/lang/String;
      //   780: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   785: putfield portraitImageUrl_ : Ljava/lang/String;
      //   788: aload_0
      //   789: aload_1
      //   790: aload_0
      //   791: getfield landscapeImageUrl_ : Ljava/lang/String;
      //   794: invokevirtual isEmpty : ()Z
      //   797: iconst_1
      //   798: ixor
      //   799: aload_0
      //   800: getfield landscapeImageUrl_ : Ljava/lang/String;
      //   803: aload_2
      //   804: getfield landscapeImageUrl_ : Ljava/lang/String;
      //   807: invokevirtual isEmpty : ()Z
      //   810: iconst_1
      //   811: ixor
      //   812: aload_2
      //   813: getfield landscapeImageUrl_ : Ljava/lang/String;
      //   816: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   821: putfield landscapeImageUrl_ : Ljava/lang/String;
      //   824: aload_0
      //   825: aload_1
      //   826: aload_0
      //   827: getfield backgroundHexColor_ : Ljava/lang/String;
      //   830: invokevirtual isEmpty : ()Z
      //   833: iconst_1
      //   834: ixor
      //   835: aload_0
      //   836: getfield backgroundHexColor_ : Ljava/lang/String;
      //   839: iconst_1
      //   840: aload_2
      //   841: getfield backgroundHexColor_ : Ljava/lang/String;
      //   844: invokevirtual isEmpty : ()Z
      //   847: ixor
      //   848: aload_2
      //   849: getfield backgroundHexColor_ : Ljava/lang/String;
      //   852: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   857: putfield backgroundHexColor_ : Ljava/lang/String;
      //   860: aload_0
      //   861: aload_1
      //   862: aload_0
      //   863: getfield primaryActionButton_ : Lcom/google/firebase/inappmessaging/MessagesProto$Button;
      //   866: aload_2
      //   867: getfield primaryActionButton_ : Lcom/google/firebase/inappmessaging/MessagesProto$Button;
      //   870: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   875: checkcast com/google/firebase/inappmessaging/MessagesProto$Button
      //   878: putfield primaryActionButton_ : Lcom/google/firebase/inappmessaging/MessagesProto$Button;
      //   881: aload_0
      //   882: aload_1
      //   883: aload_0
      //   884: getfield primaryAction_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   887: aload_2
      //   888: getfield primaryAction_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   891: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   896: checkcast com/google/firebase/inappmessaging/MessagesProto$Action
      //   899: putfield primaryAction_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   902: aload_0
      //   903: aload_1
      //   904: aload_0
      //   905: getfield secondaryActionButton_ : Lcom/google/firebase/inappmessaging/MessagesProto$Button;
      //   908: aload_2
      //   909: getfield secondaryActionButton_ : Lcom/google/firebase/inappmessaging/MessagesProto$Button;
      //   912: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   917: checkcast com/google/firebase/inappmessaging/MessagesProto$Button
      //   920: putfield secondaryActionButton_ : Lcom/google/firebase/inappmessaging/MessagesProto$Button;
      //   923: aload_0
      //   924: aload_1
      //   925: aload_0
      //   926: getfield secondaryAction_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   929: aload_2
      //   930: getfield secondaryAction_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   933: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   938: checkcast com/google/firebase/inappmessaging/MessagesProto$Action
      //   941: putfield secondaryAction_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   944: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   947: astore_1
      //   948: aload_0
      //   949: areturn
      //   950: new com/google/firebase/inappmessaging/MessagesProto$CardMessage$Builder
      //   953: dup
      //   954: aconst_null
      //   955: invokespecial <init> : (Lcom/google/firebase/inappmessaging/MessagesProto$1;)V
      //   958: areturn
      //   959: aconst_null
      //   960: areturn
      //   961: getstatic com/google/firebase/inappmessaging/MessagesProto$CardMessage.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/MessagesProto$CardMessage;
      //   964: areturn
      //   965: new com/google/firebase/inappmessaging/MessagesProto$CardMessage
      //   968: dup
      //   969: invokespecial <init> : ()V
      //   972: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	678	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	650	java/io/IOException
      //   128	134	646	finally
      //   202	211	678	com/google/protobuf/InvalidProtocolBufferException
      //   202	211	650	java/io/IOException
      //   202	211	646	finally
      //   217	235	678	com/google/protobuf/InvalidProtocolBufferException
      //   217	235	650	java/io/IOException
      //   217	235	646	finally
      //   240	255	678	com/google/protobuf/InvalidProtocolBufferException
      //   240	255	650	java/io/IOException
      //   240	255	646	finally
      //   259	279	678	com/google/protobuf/InvalidProtocolBufferException
      //   259	279	650	java/io/IOException
      //   259	279	646	finally
      //   282	300	678	com/google/protobuf/InvalidProtocolBufferException
      //   282	300	650	java/io/IOException
      //   282	300	646	finally
      //   305	320	678	com/google/protobuf/InvalidProtocolBufferException
      //   305	320	650	java/io/IOException
      //   305	320	646	finally
      //   324	344	678	com/google/protobuf/InvalidProtocolBufferException
      //   324	344	650	java/io/IOException
      //   324	344	646	finally
      //   347	365	678	com/google/protobuf/InvalidProtocolBufferException
      //   347	365	650	java/io/IOException
      //   347	365	646	finally
      //   370	385	678	com/google/protobuf/InvalidProtocolBufferException
      //   370	385	650	java/io/IOException
      //   370	385	646	finally
      //   389	409	678	com/google/protobuf/InvalidProtocolBufferException
      //   389	409	650	java/io/IOException
      //   389	409	646	finally
      //   412	430	678	com/google/protobuf/InvalidProtocolBufferException
      //   412	430	650	java/io/IOException
      //   412	430	646	finally
      //   435	450	678	com/google/protobuf/InvalidProtocolBufferException
      //   435	450	650	java/io/IOException
      //   435	450	646	finally
      //   454	474	678	com/google/protobuf/InvalidProtocolBufferException
      //   454	474	650	java/io/IOException
      //   454	474	646	finally
      //   477	485	678	com/google/protobuf/InvalidProtocolBufferException
      //   477	485	650	java/io/IOException
      //   477	485	646	finally
      //   488	496	678	com/google/protobuf/InvalidProtocolBufferException
      //   488	496	650	java/io/IOException
      //   488	496	646	finally
      //   499	507	678	com/google/protobuf/InvalidProtocolBufferException
      //   499	507	650	java/io/IOException
      //   499	507	646	finally
      //   510	528	678	com/google/protobuf/InvalidProtocolBufferException
      //   510	528	650	java/io/IOException
      //   510	528	646	finally
      //   533	548	678	com/google/protobuf/InvalidProtocolBufferException
      //   533	548	650	java/io/IOException
      //   533	548	646	finally
      //   552	572	678	com/google/protobuf/InvalidProtocolBufferException
      //   552	572	650	java/io/IOException
      //   552	572	646	finally
      //   575	593	678	com/google/protobuf/InvalidProtocolBufferException
      //   575	593	650	java/io/IOException
      //   575	593	646	finally
      //   598	613	678	com/google/protobuf/InvalidProtocolBufferException
      //   598	613	650	java/io/IOException
      //   598	613	646	finally
      //   617	637	678	com/google/protobuf/InvalidProtocolBufferException
      //   617	637	650	java/io/IOException
      //   617	637	646	finally
      //   651	678	646	finally
      //   679	694	646	finally
    }
    
    public String getBackgroundHexColor() {
      return this.backgroundHexColor_;
    }
    
    public ByteString getBackgroundHexColorBytes() {
      return ByteString.copyFromUtf8(this.backgroundHexColor_);
    }
    
    public MessagesProto.Text getBody() {
      MessagesProto.Text text1 = this.body_;
      MessagesProto.Text text2 = text1;
      if (text1 == null)
        text2 = MessagesProto.Text.getDefaultInstance(); 
      return text2;
    }
    
    public String getLandscapeImageUrl() {
      return this.landscapeImageUrl_;
    }
    
    public ByteString getLandscapeImageUrlBytes() {
      return ByteString.copyFromUtf8(this.landscapeImageUrl_);
    }
    
    public String getPortraitImageUrl() {
      return this.portraitImageUrl_;
    }
    
    public ByteString getPortraitImageUrlBytes() {
      return ByteString.copyFromUtf8(this.portraitImageUrl_);
    }
    
    public MessagesProto.Action getPrimaryAction() {
      MessagesProto.Action action1 = this.primaryAction_;
      MessagesProto.Action action2 = action1;
      if (action1 == null)
        action2 = MessagesProto.Action.getDefaultInstance(); 
      return action2;
    }
    
    public MessagesProto.Button getPrimaryActionButton() {
      MessagesProto.Button button1 = this.primaryActionButton_;
      MessagesProto.Button button2 = button1;
      if (button1 == null)
        button2 = MessagesProto.Button.getDefaultInstance(); 
      return button2;
    }
    
    public MessagesProto.Action getSecondaryAction() {
      MessagesProto.Action action1 = this.secondaryAction_;
      MessagesProto.Action action2 = action1;
      if (action1 == null)
        action2 = MessagesProto.Action.getDefaultInstance(); 
      return action2;
    }
    
    public MessagesProto.Button getSecondaryActionButton() {
      MessagesProto.Button button1 = this.secondaryActionButton_;
      MessagesProto.Button button2 = button1;
      if (button1 == null)
        button2 = MessagesProto.Button.getDefaultInstance(); 
      return button2;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.title_ != null)
        j = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)getTitle()); 
      i = j;
      if (this.body_ != null)
        i = j + CodedOutputStream.computeMessageSize(2, (MessageLite)getBody()); 
      j = i;
      if (!this.portraitImageUrl_.isEmpty())
        j = i + CodedOutputStream.computeStringSize(3, getPortraitImageUrl()); 
      i = j;
      if (!this.landscapeImageUrl_.isEmpty())
        i = j + CodedOutputStream.computeStringSize(4, getLandscapeImageUrl()); 
      j = i;
      if (!this.backgroundHexColor_.isEmpty())
        j = i + CodedOutputStream.computeStringSize(5, getBackgroundHexColor()); 
      i = j;
      if (this.primaryActionButton_ != null)
        i = j + CodedOutputStream.computeMessageSize(6, (MessageLite)getPrimaryActionButton()); 
      j = i;
      if (this.primaryAction_ != null)
        j = i + CodedOutputStream.computeMessageSize(7, (MessageLite)getPrimaryAction()); 
      i = j;
      if (this.secondaryActionButton_ != null)
        i = j + CodedOutputStream.computeMessageSize(8, (MessageLite)getSecondaryActionButton()); 
      j = i;
      if (this.secondaryAction_ != null)
        j = i + CodedOutputStream.computeMessageSize(9, (MessageLite)getSecondaryAction()); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public MessagesProto.Text getTitle() {
      MessagesProto.Text text1 = this.title_;
      MessagesProto.Text text2 = text1;
      if (text1 == null)
        text2 = MessagesProto.Text.getDefaultInstance(); 
      return text2;
    }
    
    public boolean hasBody() {
      boolean bool;
      if (this.body_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasPrimaryAction() {
      boolean bool;
      if (this.primaryAction_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasPrimaryActionButton() {
      boolean bool;
      if (this.primaryActionButton_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasSecondaryAction() {
      boolean bool;
      if (this.secondaryAction_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasSecondaryActionButton() {
      boolean bool;
      if (this.secondaryActionButton_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasTitle() {
      boolean bool;
      if (this.title_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.title_ != null)
        param1CodedOutputStream.writeMessage(1, (MessageLite)getTitle()); 
      if (this.body_ != null)
        param1CodedOutputStream.writeMessage(2, (MessageLite)getBody()); 
      if (!this.portraitImageUrl_.isEmpty())
        param1CodedOutputStream.writeString(3, getPortraitImageUrl()); 
      if (!this.landscapeImageUrl_.isEmpty())
        param1CodedOutputStream.writeString(4, getLandscapeImageUrl()); 
      if (!this.backgroundHexColor_.isEmpty())
        param1CodedOutputStream.writeString(5, getBackgroundHexColor()); 
      if (this.primaryActionButton_ != null)
        param1CodedOutputStream.writeMessage(6, (MessageLite)getPrimaryActionButton()); 
      if (this.primaryAction_ != null)
        param1CodedOutputStream.writeMessage(7, (MessageLite)getPrimaryAction()); 
      if (this.secondaryActionButton_ != null)
        param1CodedOutputStream.writeMessage(8, (MessageLite)getSecondaryActionButton()); 
      if (this.secondaryAction_ != null)
        param1CodedOutputStream.writeMessage(9, (MessageLite)getSecondaryAction()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<CardMessage, Builder> implements MessagesProto.CardMessageOrBuilder {
      private Builder() {
        super(MessagesProto.CardMessage.DEFAULT_INSTANCE);
      }
      
      public Builder clearBackgroundHexColor() {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).clearBackgroundHexColor();
        return this;
      }
      
      public Builder clearBody() {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).clearBody();
        return this;
      }
      
      public Builder clearLandscapeImageUrl() {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).clearLandscapeImageUrl();
        return this;
      }
      
      public Builder clearPortraitImageUrl() {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).clearPortraitImageUrl();
        return this;
      }
      
      public Builder clearPrimaryAction() {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).clearPrimaryAction();
        return this;
      }
      
      public Builder clearPrimaryActionButton() {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).clearPrimaryActionButton();
        return this;
      }
      
      public Builder clearSecondaryAction() {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).clearSecondaryAction();
        return this;
      }
      
      public Builder clearSecondaryActionButton() {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).clearSecondaryActionButton();
        return this;
      }
      
      public Builder clearTitle() {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).clearTitle();
        return this;
      }
      
      public String getBackgroundHexColor() {
        return ((MessagesProto.CardMessage)this.instance).getBackgroundHexColor();
      }
      
      public ByteString getBackgroundHexColorBytes() {
        return ((MessagesProto.CardMessage)this.instance).getBackgroundHexColorBytes();
      }
      
      public MessagesProto.Text getBody() {
        return ((MessagesProto.CardMessage)this.instance).getBody();
      }
      
      public String getLandscapeImageUrl() {
        return ((MessagesProto.CardMessage)this.instance).getLandscapeImageUrl();
      }
      
      public ByteString getLandscapeImageUrlBytes() {
        return ((MessagesProto.CardMessage)this.instance).getLandscapeImageUrlBytes();
      }
      
      public String getPortraitImageUrl() {
        return ((MessagesProto.CardMessage)this.instance).getPortraitImageUrl();
      }
      
      public ByteString getPortraitImageUrlBytes() {
        return ((MessagesProto.CardMessage)this.instance).getPortraitImageUrlBytes();
      }
      
      public MessagesProto.Action getPrimaryAction() {
        return ((MessagesProto.CardMessage)this.instance).getPrimaryAction();
      }
      
      public MessagesProto.Button getPrimaryActionButton() {
        return ((MessagesProto.CardMessage)this.instance).getPrimaryActionButton();
      }
      
      public MessagesProto.Action getSecondaryAction() {
        return ((MessagesProto.CardMessage)this.instance).getSecondaryAction();
      }
      
      public MessagesProto.Button getSecondaryActionButton() {
        return ((MessagesProto.CardMessage)this.instance).getSecondaryActionButton();
      }
      
      public MessagesProto.Text getTitle() {
        return ((MessagesProto.CardMessage)this.instance).getTitle();
      }
      
      public boolean hasBody() {
        return ((MessagesProto.CardMessage)this.instance).hasBody();
      }
      
      public boolean hasPrimaryAction() {
        return ((MessagesProto.CardMessage)this.instance).hasPrimaryAction();
      }
      
      public boolean hasPrimaryActionButton() {
        return ((MessagesProto.CardMessage)this.instance).hasPrimaryActionButton();
      }
      
      public boolean hasSecondaryAction() {
        return ((MessagesProto.CardMessage)this.instance).hasSecondaryAction();
      }
      
      public boolean hasSecondaryActionButton() {
        return ((MessagesProto.CardMessage)this.instance).hasSecondaryActionButton();
      }
      
      public boolean hasTitle() {
        return ((MessagesProto.CardMessage)this.instance).hasTitle();
      }
      
      public Builder mergeBody(MessagesProto.Text param2Text) {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).mergeBody(param2Text);
        return this;
      }
      
      public Builder mergePrimaryAction(MessagesProto.Action param2Action) {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).mergePrimaryAction(param2Action);
        return this;
      }
      
      public Builder mergePrimaryActionButton(MessagesProto.Button param2Button) {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).mergePrimaryActionButton(param2Button);
        return this;
      }
      
      public Builder mergeSecondaryAction(MessagesProto.Action param2Action) {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).mergeSecondaryAction(param2Action);
        return this;
      }
      
      public Builder mergeSecondaryActionButton(MessagesProto.Button param2Button) {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).mergeSecondaryActionButton(param2Button);
        return this;
      }
      
      public Builder mergeTitle(MessagesProto.Text param2Text) {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).mergeTitle(param2Text);
        return this;
      }
      
      public Builder setBackgroundHexColor(String param2String) {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).setBackgroundHexColor(param2String);
        return this;
      }
      
      public Builder setBackgroundHexColorBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).setBackgroundHexColorBytes(param2ByteString);
        return this;
      }
      
      public Builder setBody(MessagesProto.Text.Builder param2Builder) {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).setBody(param2Builder);
        return this;
      }
      
      public Builder setBody(MessagesProto.Text param2Text) {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).setBody(param2Text);
        return this;
      }
      
      public Builder setLandscapeImageUrl(String param2String) {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).setLandscapeImageUrl(param2String);
        return this;
      }
      
      public Builder setLandscapeImageUrlBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).setLandscapeImageUrlBytes(param2ByteString);
        return this;
      }
      
      public Builder setPortraitImageUrl(String param2String) {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).setPortraitImageUrl(param2String);
        return this;
      }
      
      public Builder setPortraitImageUrlBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).setPortraitImageUrlBytes(param2ByteString);
        return this;
      }
      
      public Builder setPrimaryAction(MessagesProto.Action.Builder param2Builder) {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).setPrimaryAction(param2Builder);
        return this;
      }
      
      public Builder setPrimaryAction(MessagesProto.Action param2Action) {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).setPrimaryAction(param2Action);
        return this;
      }
      
      public Builder setPrimaryActionButton(MessagesProto.Button.Builder param2Builder) {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).setPrimaryActionButton(param2Builder);
        return this;
      }
      
      public Builder setPrimaryActionButton(MessagesProto.Button param2Button) {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).setPrimaryActionButton(param2Button);
        return this;
      }
      
      public Builder setSecondaryAction(MessagesProto.Action.Builder param2Builder) {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).setSecondaryAction(param2Builder);
        return this;
      }
      
      public Builder setSecondaryAction(MessagesProto.Action param2Action) {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).setSecondaryAction(param2Action);
        return this;
      }
      
      public Builder setSecondaryActionButton(MessagesProto.Button.Builder param2Builder) {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).setSecondaryActionButton(param2Builder);
        return this;
      }
      
      public Builder setSecondaryActionButton(MessagesProto.Button param2Button) {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).setSecondaryActionButton(param2Button);
        return this;
      }
      
      public Builder setTitle(MessagesProto.Text.Builder param2Builder) {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).setTitle(param2Builder);
        return this;
      }
      
      public Builder setTitle(MessagesProto.Text param2Text) {
        copyOnWrite();
        ((MessagesProto.CardMessage)this.instance).setTitle(param2Text);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<CardMessage, CardMessage.Builder> implements CardMessageOrBuilder {
    private Builder() {
      super(MessagesProto.CardMessage.DEFAULT_INSTANCE);
    }
    
    public Builder clearBackgroundHexColor() {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).clearBackgroundHexColor();
      return this;
    }
    
    public Builder clearBody() {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).clearBody();
      return this;
    }
    
    public Builder clearLandscapeImageUrl() {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).clearLandscapeImageUrl();
      return this;
    }
    
    public Builder clearPortraitImageUrl() {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).clearPortraitImageUrl();
      return this;
    }
    
    public Builder clearPrimaryAction() {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).clearPrimaryAction();
      return this;
    }
    
    public Builder clearPrimaryActionButton() {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).clearPrimaryActionButton();
      return this;
    }
    
    public Builder clearSecondaryAction() {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).clearSecondaryAction();
      return this;
    }
    
    public Builder clearSecondaryActionButton() {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).clearSecondaryActionButton();
      return this;
    }
    
    public Builder clearTitle() {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).clearTitle();
      return this;
    }
    
    public String getBackgroundHexColor() {
      return ((MessagesProto.CardMessage)this.instance).getBackgroundHexColor();
    }
    
    public ByteString getBackgroundHexColorBytes() {
      return ((MessagesProto.CardMessage)this.instance).getBackgroundHexColorBytes();
    }
    
    public MessagesProto.Text getBody() {
      return ((MessagesProto.CardMessage)this.instance).getBody();
    }
    
    public String getLandscapeImageUrl() {
      return ((MessagesProto.CardMessage)this.instance).getLandscapeImageUrl();
    }
    
    public ByteString getLandscapeImageUrlBytes() {
      return ((MessagesProto.CardMessage)this.instance).getLandscapeImageUrlBytes();
    }
    
    public String getPortraitImageUrl() {
      return ((MessagesProto.CardMessage)this.instance).getPortraitImageUrl();
    }
    
    public ByteString getPortraitImageUrlBytes() {
      return ((MessagesProto.CardMessage)this.instance).getPortraitImageUrlBytes();
    }
    
    public MessagesProto.Action getPrimaryAction() {
      return ((MessagesProto.CardMessage)this.instance).getPrimaryAction();
    }
    
    public MessagesProto.Button getPrimaryActionButton() {
      return ((MessagesProto.CardMessage)this.instance).getPrimaryActionButton();
    }
    
    public MessagesProto.Action getSecondaryAction() {
      return ((MessagesProto.CardMessage)this.instance).getSecondaryAction();
    }
    
    public MessagesProto.Button getSecondaryActionButton() {
      return ((MessagesProto.CardMessage)this.instance).getSecondaryActionButton();
    }
    
    public MessagesProto.Text getTitle() {
      return ((MessagesProto.CardMessage)this.instance).getTitle();
    }
    
    public boolean hasBody() {
      return ((MessagesProto.CardMessage)this.instance).hasBody();
    }
    
    public boolean hasPrimaryAction() {
      return ((MessagesProto.CardMessage)this.instance).hasPrimaryAction();
    }
    
    public boolean hasPrimaryActionButton() {
      return ((MessagesProto.CardMessage)this.instance).hasPrimaryActionButton();
    }
    
    public boolean hasSecondaryAction() {
      return ((MessagesProto.CardMessage)this.instance).hasSecondaryAction();
    }
    
    public boolean hasSecondaryActionButton() {
      return ((MessagesProto.CardMessage)this.instance).hasSecondaryActionButton();
    }
    
    public boolean hasTitle() {
      return ((MessagesProto.CardMessage)this.instance).hasTitle();
    }
    
    public Builder mergeBody(MessagesProto.Text param1Text) {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).mergeBody(param1Text);
      return this;
    }
    
    public Builder mergePrimaryAction(MessagesProto.Action param1Action) {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).mergePrimaryAction(param1Action);
      return this;
    }
    
    public Builder mergePrimaryActionButton(MessagesProto.Button param1Button) {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).mergePrimaryActionButton(param1Button);
      return this;
    }
    
    public Builder mergeSecondaryAction(MessagesProto.Action param1Action) {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).mergeSecondaryAction(param1Action);
      return this;
    }
    
    public Builder mergeSecondaryActionButton(MessagesProto.Button param1Button) {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).mergeSecondaryActionButton(param1Button);
      return this;
    }
    
    public Builder mergeTitle(MessagesProto.Text param1Text) {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).mergeTitle(param1Text);
      return this;
    }
    
    public Builder setBackgroundHexColor(String param1String) {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).setBackgroundHexColor(param1String);
      return this;
    }
    
    public Builder setBackgroundHexColorBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).setBackgroundHexColorBytes(param1ByteString);
      return this;
    }
    
    public Builder setBody(MessagesProto.Text.Builder param1Builder) {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).setBody(param1Builder);
      return this;
    }
    
    public Builder setBody(MessagesProto.Text param1Text) {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).setBody(param1Text);
      return this;
    }
    
    public Builder setLandscapeImageUrl(String param1String) {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).setLandscapeImageUrl(param1String);
      return this;
    }
    
    public Builder setLandscapeImageUrlBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).setLandscapeImageUrlBytes(param1ByteString);
      return this;
    }
    
    public Builder setPortraitImageUrl(String param1String) {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).setPortraitImageUrl(param1String);
      return this;
    }
    
    public Builder setPortraitImageUrlBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).setPortraitImageUrlBytes(param1ByteString);
      return this;
    }
    
    public Builder setPrimaryAction(MessagesProto.Action.Builder param1Builder) {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).setPrimaryAction(param1Builder);
      return this;
    }
    
    public Builder setPrimaryAction(MessagesProto.Action param1Action) {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).setPrimaryAction(param1Action);
      return this;
    }
    
    public Builder setPrimaryActionButton(MessagesProto.Button.Builder param1Builder) {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).setPrimaryActionButton(param1Builder);
      return this;
    }
    
    public Builder setPrimaryActionButton(MessagesProto.Button param1Button) {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).setPrimaryActionButton(param1Button);
      return this;
    }
    
    public Builder setSecondaryAction(MessagesProto.Action.Builder param1Builder) {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).setSecondaryAction(param1Builder);
      return this;
    }
    
    public Builder setSecondaryAction(MessagesProto.Action param1Action) {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).setSecondaryAction(param1Action);
      return this;
    }
    
    public Builder setSecondaryActionButton(MessagesProto.Button.Builder param1Builder) {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).setSecondaryActionButton(param1Builder);
      return this;
    }
    
    public Builder setSecondaryActionButton(MessagesProto.Button param1Button) {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).setSecondaryActionButton(param1Button);
      return this;
    }
    
    public Builder setTitle(MessagesProto.Text.Builder param1Builder) {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).setTitle(param1Builder);
      return this;
    }
    
    public Builder setTitle(MessagesProto.Text param1Text) {
      copyOnWrite();
      ((MessagesProto.CardMessage)this.instance).setTitle(param1Text);
      return this;
    }
  }
  
  public static interface CardMessageOrBuilder extends MessageLiteOrBuilder {
    String getBackgroundHexColor();
    
    ByteString getBackgroundHexColorBytes();
    
    MessagesProto.Text getBody();
    
    String getLandscapeImageUrl();
    
    ByteString getLandscapeImageUrlBytes();
    
    String getPortraitImageUrl();
    
    ByteString getPortraitImageUrlBytes();
    
    MessagesProto.Action getPrimaryAction();
    
    MessagesProto.Button getPrimaryActionButton();
    
    MessagesProto.Action getSecondaryAction();
    
    MessagesProto.Button getSecondaryActionButton();
    
    MessagesProto.Text getTitle();
    
    boolean hasBody();
    
    boolean hasPrimaryAction();
    
    boolean hasPrimaryActionButton();
    
    boolean hasSecondaryAction();
    
    boolean hasSecondaryActionButton();
    
    boolean hasTitle();
  }
  
  public static final class Content extends GeneratedMessageLite<Content, Content.Builder> implements ContentOrBuilder {
    public static final int BANNER_FIELD_NUMBER = 1;
    
    public static final int CARD_FIELD_NUMBER = 4;
    
    private static final Content DEFAULT_INSTANCE = new Content();
    
    public static final int IMAGE_ONLY_FIELD_NUMBER = 3;
    
    public static final int MODAL_FIELD_NUMBER = 2;
    
    private static volatile Parser<Content> PARSER;
    
    private int messageDetailsCase_ = 0;
    
    private Object messageDetails_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearBanner() {
      if (this.messageDetailsCase_ == 1) {
        this.messageDetailsCase_ = 0;
        this.messageDetails_ = null;
      } 
    }
    
    private void clearCard() {
      if (this.messageDetailsCase_ == 4) {
        this.messageDetailsCase_ = 0;
        this.messageDetails_ = null;
      } 
    }
    
    private void clearImageOnly() {
      if (this.messageDetailsCase_ == 3) {
        this.messageDetailsCase_ = 0;
        this.messageDetails_ = null;
      } 
    }
    
    private void clearMessageDetails() {
      this.messageDetailsCase_ = 0;
      this.messageDetails_ = null;
    }
    
    private void clearModal() {
      if (this.messageDetailsCase_ == 2) {
        this.messageDetailsCase_ = 0;
        this.messageDetails_ = null;
      } 
    }
    
    public static Content getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeBanner(MessagesProto.BannerMessage param1BannerMessage) {
      if (this.messageDetailsCase_ == 1 && this.messageDetails_ != MessagesProto.BannerMessage.getDefaultInstance()) {
        this.messageDetails_ = ((MessagesProto.BannerMessage.Builder)MessagesProto.BannerMessage.newBuilder((MessagesProto.BannerMessage)this.messageDetails_).mergeFrom(param1BannerMessage)).buildPartial();
      } else {
        this.messageDetails_ = param1BannerMessage;
      } 
      this.messageDetailsCase_ = 1;
    }
    
    private void mergeCard(MessagesProto.CardMessage param1CardMessage) {
      if (this.messageDetailsCase_ == 4 && this.messageDetails_ != MessagesProto.CardMessage.getDefaultInstance()) {
        this.messageDetails_ = ((MessagesProto.CardMessage.Builder)MessagesProto.CardMessage.newBuilder((MessagesProto.CardMessage)this.messageDetails_).mergeFrom(param1CardMessage)).buildPartial();
      } else {
        this.messageDetails_ = param1CardMessage;
      } 
      this.messageDetailsCase_ = 4;
    }
    
    private void mergeImageOnly(MessagesProto.ImageOnlyMessage param1ImageOnlyMessage) {
      if (this.messageDetailsCase_ == 3 && this.messageDetails_ != MessagesProto.ImageOnlyMessage.getDefaultInstance()) {
        this.messageDetails_ = ((MessagesProto.ImageOnlyMessage.Builder)MessagesProto.ImageOnlyMessage.newBuilder((MessagesProto.ImageOnlyMessage)this.messageDetails_).mergeFrom(param1ImageOnlyMessage)).buildPartial();
      } else {
        this.messageDetails_ = param1ImageOnlyMessage;
      } 
      this.messageDetailsCase_ = 3;
    }
    
    private void mergeModal(MessagesProto.ModalMessage param1ModalMessage) {
      if (this.messageDetailsCase_ == 2 && this.messageDetails_ != MessagesProto.ModalMessage.getDefaultInstance()) {
        this.messageDetails_ = ((MessagesProto.ModalMessage.Builder)MessagesProto.ModalMessage.newBuilder((MessagesProto.ModalMessage)this.messageDetails_).mergeFrom(param1ModalMessage)).buildPartial();
      } else {
        this.messageDetails_ = param1ModalMessage;
      } 
      this.messageDetailsCase_ = 2;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Content param1Content) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1Content);
    }
    
    public static Content parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Content)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Content parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Content)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Content parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Content)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static Content parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Content)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Content parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Content)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static Content parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Content)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Content parseFrom(InputStream param1InputStream) throws IOException {
      return (Content)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Content parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Content)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Content parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Content)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static Content parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Content)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Content> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setBanner(MessagesProto.BannerMessage.Builder param1Builder) {
      this.messageDetails_ = param1Builder.build();
      this.messageDetailsCase_ = 1;
    }
    
    private void setBanner(MessagesProto.BannerMessage param1BannerMessage) {
      if (param1BannerMessage != null) {
        this.messageDetails_ = param1BannerMessage;
        this.messageDetailsCase_ = 1;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setCard(MessagesProto.CardMessage.Builder param1Builder) {
      this.messageDetails_ = param1Builder.build();
      this.messageDetailsCase_ = 4;
    }
    
    private void setCard(MessagesProto.CardMessage param1CardMessage) {
      if (param1CardMessage != null) {
        this.messageDetails_ = param1CardMessage;
        this.messageDetailsCase_ = 4;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setImageOnly(MessagesProto.ImageOnlyMessage.Builder param1Builder) {
      this.messageDetails_ = param1Builder.build();
      this.messageDetailsCase_ = 3;
    }
    
    private void setImageOnly(MessagesProto.ImageOnlyMessage param1ImageOnlyMessage) {
      if (param1ImageOnlyMessage != null) {
        this.messageDetails_ = param1ImageOnlyMessage;
        this.messageDetailsCase_ = 3;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setModal(MessagesProto.ModalMessage.Builder param1Builder) {
      this.messageDetails_ = param1Builder.build();
      this.messageDetailsCase_ = 2;
    }
    
    private void setModal(MessagesProto.ModalMessage param1ModalMessage) {
      if (param1ModalMessage != null) {
        this.messageDetails_ = param1ModalMessage;
        this.messageDetailsCase_ = 2;
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firebase/inappmessaging/MessagesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
      //   25: iconst_0
      //   26: istore #10
      //   28: iload #4
      //   30: tableswitch default -> 76, 1 -> 814, 2 -> 810, 3 -> 808, 4 -> 799, 5 -> 543, 6 -> 130, 7 -> 539, 8 -> 84
      //   76: new java/lang/UnsupportedOperationException
      //   79: dup
      //   80: invokespecial <init> : ()V
      //   83: athrow
      //   84: getstatic com/google/firebase/inappmessaging/MessagesProto$Content.PARSER : Lcom/google/protobuf/Parser;
      //   87: ifnonnull -> 126
      //   90: ldc com/google/firebase/inappmessaging/MessagesProto$Content
      //   92: monitorenter
      //   93: getstatic com/google/firebase/inappmessaging/MessagesProto$Content.PARSER : Lcom/google/protobuf/Parser;
      //   96: ifnonnull -> 114
      //   99: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   102: astore_1
      //   103: aload_1
      //   104: getstatic com/google/firebase/inappmessaging/MessagesProto$Content.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/MessagesProto$Content;
      //   107: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   110: aload_1
      //   111: putstatic com/google/firebase/inappmessaging/MessagesProto$Content.PARSER : Lcom/google/protobuf/Parser;
      //   114: ldc com/google/firebase/inappmessaging/MessagesProto$Content
      //   116: monitorexit
      //   117: goto -> 126
      //   120: astore_1
      //   121: ldc com/google/firebase/inappmessaging/MessagesProto$Content
      //   123: monitorexit
      //   124: aload_1
      //   125: athrow
      //   126: getstatic com/google/firebase/inappmessaging/MessagesProto$Content.PARSER : Lcom/google/protobuf/Parser;
      //   129: areturn
      //   130: aload_2
      //   131: checkcast com/google/protobuf/CodedInputStream
      //   134: astore_2
      //   135: aload_3
      //   136: checkcast com/google/protobuf/ExtensionRegistryLite
      //   139: astore_3
      //   140: iload #10
      //   142: ifne -> 539
      //   145: aload_2
      //   146: invokevirtual readTag : ()I
      //   149: istore #4
      //   151: iload #4
      //   153: ifeq -> 483
      //   156: iload #4
      //   158: bipush #10
      //   160: if_icmpeq -> 412
      //   163: iload #4
      //   165: bipush #18
      //   167: if_icmpeq -> 341
      //   170: iload #4
      //   172: bipush #26
      //   174: if_icmpeq -> 270
      //   177: iload #4
      //   179: bipush #34
      //   181: if_icmpeq -> 199
      //   184: aload_2
      //   185: iload #4
      //   187: invokevirtual skipField : (I)Z
      //   190: ifne -> 140
      //   193: iconst_1
      //   194: istore #10
      //   196: goto -> 140
      //   199: aload_0
      //   200: getfield messageDetailsCase_ : I
      //   203: iconst_4
      //   204: if_icmpne -> 224
      //   207: aload_0
      //   208: getfield messageDetails_ : Ljava/lang/Object;
      //   211: checkcast com/google/firebase/inappmessaging/MessagesProto$CardMessage
      //   214: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   217: checkcast com/google/firebase/inappmessaging/MessagesProto$CardMessage$Builder
      //   220: astore_1
      //   221: goto -> 226
      //   224: aconst_null
      //   225: astore_1
      //   226: aload_0
      //   227: aload_2
      //   228: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   231: aload_3
      //   232: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   235: putfield messageDetails_ : Ljava/lang/Object;
      //   238: aload_1
      //   239: ifnull -> 262
      //   242: aload_1
      //   243: aload_0
      //   244: getfield messageDetails_ : Ljava/lang/Object;
      //   247: checkcast com/google/firebase/inappmessaging/MessagesProto$CardMessage
      //   250: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   253: pop
      //   254: aload_0
      //   255: aload_1
      //   256: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   259: putfield messageDetails_ : Ljava/lang/Object;
      //   262: aload_0
      //   263: iconst_4
      //   264: putfield messageDetailsCase_ : I
      //   267: goto -> 140
      //   270: aload_0
      //   271: getfield messageDetailsCase_ : I
      //   274: iconst_3
      //   275: if_icmpne -> 295
      //   278: aload_0
      //   279: getfield messageDetails_ : Ljava/lang/Object;
      //   282: checkcast com/google/firebase/inappmessaging/MessagesProto$ImageOnlyMessage
      //   285: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   288: checkcast com/google/firebase/inappmessaging/MessagesProto$ImageOnlyMessage$Builder
      //   291: astore_1
      //   292: goto -> 297
      //   295: aconst_null
      //   296: astore_1
      //   297: aload_0
      //   298: aload_2
      //   299: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   302: aload_3
      //   303: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   306: putfield messageDetails_ : Ljava/lang/Object;
      //   309: aload_1
      //   310: ifnull -> 333
      //   313: aload_1
      //   314: aload_0
      //   315: getfield messageDetails_ : Ljava/lang/Object;
      //   318: checkcast com/google/firebase/inappmessaging/MessagesProto$ImageOnlyMessage
      //   321: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   324: pop
      //   325: aload_0
      //   326: aload_1
      //   327: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   330: putfield messageDetails_ : Ljava/lang/Object;
      //   333: aload_0
      //   334: iconst_3
      //   335: putfield messageDetailsCase_ : I
      //   338: goto -> 140
      //   341: aload_0
      //   342: getfield messageDetailsCase_ : I
      //   345: iconst_2
      //   346: if_icmpne -> 366
      //   349: aload_0
      //   350: getfield messageDetails_ : Ljava/lang/Object;
      //   353: checkcast com/google/firebase/inappmessaging/MessagesProto$ModalMessage
      //   356: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   359: checkcast com/google/firebase/inappmessaging/MessagesProto$ModalMessage$Builder
      //   362: astore_1
      //   363: goto -> 368
      //   366: aconst_null
      //   367: astore_1
      //   368: aload_0
      //   369: aload_2
      //   370: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   373: aload_3
      //   374: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   377: putfield messageDetails_ : Ljava/lang/Object;
      //   380: aload_1
      //   381: ifnull -> 404
      //   384: aload_1
      //   385: aload_0
      //   386: getfield messageDetails_ : Ljava/lang/Object;
      //   389: checkcast com/google/firebase/inappmessaging/MessagesProto$ModalMessage
      //   392: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   395: pop
      //   396: aload_0
      //   397: aload_1
      //   398: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   401: putfield messageDetails_ : Ljava/lang/Object;
      //   404: aload_0
      //   405: iconst_2
      //   406: putfield messageDetailsCase_ : I
      //   409: goto -> 140
      //   412: aload_0
      //   413: getfield messageDetailsCase_ : I
      //   416: iconst_1
      //   417: if_icmpne -> 437
      //   420: aload_0
      //   421: getfield messageDetails_ : Ljava/lang/Object;
      //   424: checkcast com/google/firebase/inappmessaging/MessagesProto$BannerMessage
      //   427: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   430: checkcast com/google/firebase/inappmessaging/MessagesProto$BannerMessage$Builder
      //   433: astore_1
      //   434: goto -> 439
      //   437: aconst_null
      //   438: astore_1
      //   439: aload_0
      //   440: aload_2
      //   441: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   444: aload_3
      //   445: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   448: putfield messageDetails_ : Ljava/lang/Object;
      //   451: aload_1
      //   452: ifnull -> 475
      //   455: aload_1
      //   456: aload_0
      //   457: getfield messageDetails_ : Ljava/lang/Object;
      //   460: checkcast com/google/firebase/inappmessaging/MessagesProto$BannerMessage
      //   463: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   466: pop
      //   467: aload_0
      //   468: aload_1
      //   469: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   472: putfield messageDetails_ : Ljava/lang/Object;
      //   475: aload_0
      //   476: iconst_1
      //   477: putfield messageDetailsCase_ : I
      //   480: goto -> 140
      //   483: iconst_1
      //   484: istore #10
      //   486: goto -> 140
      //   489: astore_1
      //   490: goto -> 537
      //   493: astore_2
      //   494: new java/lang/RuntimeException
      //   497: astore_1
      //   498: new com/google/protobuf/InvalidProtocolBufferException
      //   501: astore_3
      //   502: aload_3
      //   503: aload_2
      //   504: invokevirtual getMessage : ()Ljava/lang/String;
      //   507: invokespecial <init> : (Ljava/lang/String;)V
      //   510: aload_1
      //   511: aload_3
      //   512: aload_0
      //   513: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   516: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   519: aload_1
      //   520: athrow
      //   521: astore_2
      //   522: new java/lang/RuntimeException
      //   525: astore_1
      //   526: aload_1
      //   527: aload_2
      //   528: aload_0
      //   529: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   532: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   535: aload_1
      //   536: athrow
      //   537: aload_1
      //   538: athrow
      //   539: getstatic com/google/firebase/inappmessaging/MessagesProto$Content.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/MessagesProto$Content;
      //   542: areturn
      //   543: aload_2
      //   544: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   547: astore_1
      //   548: aload_3
      //   549: checkcast com/google/firebase/inappmessaging/MessagesProto$Content
      //   552: astore_2
      //   553: getstatic com/google/firebase/inappmessaging/MessagesProto$1.$SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase : [I
      //   556: aload_2
      //   557: invokevirtual getMessageDetailsCase : ()Lcom/google/firebase/inappmessaging/MessagesProto$Content$MessageDetailsCase;
      //   560: invokevirtual ordinal : ()I
      //   563: iaload
      //   564: tableswitch default -> 600, 1 -> 738, 2 -> 700, 3 -> 662, 4 -> 624, 5 -> 603
      //   600: goto -> 773
      //   603: aload_0
      //   604: getfield messageDetailsCase_ : I
      //   607: ifeq -> 613
      //   610: iconst_1
      //   611: istore #5
      //   613: aload_1
      //   614: iload #5
      //   616: invokeinterface visitOneofNotSet : (Z)V
      //   621: goto -> 773
      //   624: iload #6
      //   626: istore #5
      //   628: aload_0
      //   629: getfield messageDetailsCase_ : I
      //   632: iconst_4
      //   633: if_icmpne -> 639
      //   636: iconst_1
      //   637: istore #5
      //   639: aload_0
      //   640: aload_1
      //   641: iload #5
      //   643: aload_0
      //   644: getfield messageDetails_ : Ljava/lang/Object;
      //   647: aload_2
      //   648: getfield messageDetails_ : Ljava/lang/Object;
      //   651: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   656: putfield messageDetails_ : Ljava/lang/Object;
      //   659: goto -> 773
      //   662: iload #7
      //   664: istore #5
      //   666: aload_0
      //   667: getfield messageDetailsCase_ : I
      //   670: iconst_3
      //   671: if_icmpne -> 677
      //   674: iconst_1
      //   675: istore #5
      //   677: aload_0
      //   678: aload_1
      //   679: iload #5
      //   681: aload_0
      //   682: getfield messageDetails_ : Ljava/lang/Object;
      //   685: aload_2
      //   686: getfield messageDetails_ : Ljava/lang/Object;
      //   689: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   694: putfield messageDetails_ : Ljava/lang/Object;
      //   697: goto -> 773
      //   700: iload #8
      //   702: istore #5
      //   704: aload_0
      //   705: getfield messageDetailsCase_ : I
      //   708: iconst_2
      //   709: if_icmpne -> 715
      //   712: iconst_1
      //   713: istore #5
      //   715: aload_0
      //   716: aload_1
      //   717: iload #5
      //   719: aload_0
      //   720: getfield messageDetails_ : Ljava/lang/Object;
      //   723: aload_2
      //   724: getfield messageDetails_ : Ljava/lang/Object;
      //   727: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   732: putfield messageDetails_ : Ljava/lang/Object;
      //   735: goto -> 773
      //   738: iload #9
      //   740: istore #5
      //   742: aload_0
      //   743: getfield messageDetailsCase_ : I
      //   746: iconst_1
      //   747: if_icmpne -> 753
      //   750: iconst_1
      //   751: istore #5
      //   753: aload_0
      //   754: aload_1
      //   755: iload #5
      //   757: aload_0
      //   758: getfield messageDetails_ : Ljava/lang/Object;
      //   761: aload_2
      //   762: getfield messageDetails_ : Ljava/lang/Object;
      //   765: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   770: putfield messageDetails_ : Ljava/lang/Object;
      //   773: aload_1
      //   774: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   777: if_acmpne -> 797
      //   780: aload_2
      //   781: getfield messageDetailsCase_ : I
      //   784: istore #10
      //   786: iload #10
      //   788: ifeq -> 797
      //   791: aload_0
      //   792: iload #10
      //   794: putfield messageDetailsCase_ : I
      //   797: aload_0
      //   798: areturn
      //   799: new com/google/firebase/inappmessaging/MessagesProto$Content$Builder
      //   802: dup
      //   803: aconst_null
      //   804: invokespecial <init> : (Lcom/google/firebase/inappmessaging/MessagesProto$1;)V
      //   807: areturn
      //   808: aconst_null
      //   809: areturn
      //   810: getstatic com/google/firebase/inappmessaging/MessagesProto$Content.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/MessagesProto$Content;
      //   813: areturn
      //   814: new com/google/firebase/inappmessaging/MessagesProto$Content
      //   817: dup
      //   818: invokespecial <init> : ()V
      //   821: areturn
      // Exception table:
      //   from	to	target	type
      //   93	114	120	finally
      //   114	117	120	finally
      //   121	124	120	finally
      //   145	151	521	com/google/protobuf/InvalidProtocolBufferException
      //   145	151	493	java/io/IOException
      //   145	151	489	finally
      //   184	193	521	com/google/protobuf/InvalidProtocolBufferException
      //   184	193	493	java/io/IOException
      //   184	193	489	finally
      //   199	221	521	com/google/protobuf/InvalidProtocolBufferException
      //   199	221	493	java/io/IOException
      //   199	221	489	finally
      //   226	238	521	com/google/protobuf/InvalidProtocolBufferException
      //   226	238	493	java/io/IOException
      //   226	238	489	finally
      //   242	262	521	com/google/protobuf/InvalidProtocolBufferException
      //   242	262	493	java/io/IOException
      //   242	262	489	finally
      //   262	267	521	com/google/protobuf/InvalidProtocolBufferException
      //   262	267	493	java/io/IOException
      //   262	267	489	finally
      //   270	292	521	com/google/protobuf/InvalidProtocolBufferException
      //   270	292	493	java/io/IOException
      //   270	292	489	finally
      //   297	309	521	com/google/protobuf/InvalidProtocolBufferException
      //   297	309	493	java/io/IOException
      //   297	309	489	finally
      //   313	333	521	com/google/protobuf/InvalidProtocolBufferException
      //   313	333	493	java/io/IOException
      //   313	333	489	finally
      //   333	338	521	com/google/protobuf/InvalidProtocolBufferException
      //   333	338	493	java/io/IOException
      //   333	338	489	finally
      //   341	363	521	com/google/protobuf/InvalidProtocolBufferException
      //   341	363	493	java/io/IOException
      //   341	363	489	finally
      //   368	380	521	com/google/protobuf/InvalidProtocolBufferException
      //   368	380	493	java/io/IOException
      //   368	380	489	finally
      //   384	404	521	com/google/protobuf/InvalidProtocolBufferException
      //   384	404	493	java/io/IOException
      //   384	404	489	finally
      //   404	409	521	com/google/protobuf/InvalidProtocolBufferException
      //   404	409	493	java/io/IOException
      //   404	409	489	finally
      //   412	434	521	com/google/protobuf/InvalidProtocolBufferException
      //   412	434	493	java/io/IOException
      //   412	434	489	finally
      //   439	451	521	com/google/protobuf/InvalidProtocolBufferException
      //   439	451	493	java/io/IOException
      //   439	451	489	finally
      //   455	475	521	com/google/protobuf/InvalidProtocolBufferException
      //   455	475	493	java/io/IOException
      //   455	475	489	finally
      //   475	480	521	com/google/protobuf/InvalidProtocolBufferException
      //   475	480	493	java/io/IOException
      //   475	480	489	finally
      //   494	521	489	finally
      //   522	537	489	finally
    }
    
    public MessagesProto.BannerMessage getBanner() {
      return (this.messageDetailsCase_ == 1) ? (MessagesProto.BannerMessage)this.messageDetails_ : MessagesProto.BannerMessage.getDefaultInstance();
    }
    
    public MessagesProto.CardMessage getCard() {
      return (this.messageDetailsCase_ == 4) ? (MessagesProto.CardMessage)this.messageDetails_ : MessagesProto.CardMessage.getDefaultInstance();
    }
    
    public MessagesProto.ImageOnlyMessage getImageOnly() {
      return (this.messageDetailsCase_ == 3) ? (MessagesProto.ImageOnlyMessage)this.messageDetails_ : MessagesProto.ImageOnlyMessage.getDefaultInstance();
    }
    
    public MessageDetailsCase getMessageDetailsCase() {
      return MessageDetailsCase.forNumber(this.messageDetailsCase_);
    }
    
    public MessagesProto.ModalMessage getModal() {
      return (this.messageDetailsCase_ == 2) ? (MessagesProto.ModalMessage)this.messageDetails_ : MessagesProto.ModalMessage.getDefaultInstance();
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.messageDetailsCase_ == 1)
        j = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)this.messageDetails_); 
      i = j;
      if (this.messageDetailsCase_ == 2)
        i = j + CodedOutputStream.computeMessageSize(2, (MessageLite)this.messageDetails_); 
      j = i;
      if (this.messageDetailsCase_ == 3)
        j = i + CodedOutputStream.computeMessageSize(3, (MessageLite)this.messageDetails_); 
      i = j;
      if (this.messageDetailsCase_ == 4)
        i = j + CodedOutputStream.computeMessageSize(4, (MessageLite)this.messageDetails_); 
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.messageDetailsCase_ == 1)
        param1CodedOutputStream.writeMessage(1, (MessageLite)this.messageDetails_); 
      if (this.messageDetailsCase_ == 2)
        param1CodedOutputStream.writeMessage(2, (MessageLite)this.messageDetails_); 
      if (this.messageDetailsCase_ == 3)
        param1CodedOutputStream.writeMessage(3, (MessageLite)this.messageDetails_); 
      if (this.messageDetailsCase_ == 4)
        param1CodedOutputStream.writeMessage(4, (MessageLite)this.messageDetails_); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Content, Builder> implements MessagesProto.ContentOrBuilder {
      private Builder() {
        super(MessagesProto.Content.DEFAULT_INSTANCE);
      }
      
      public Builder clearBanner() {
        copyOnWrite();
        ((MessagesProto.Content)this.instance).clearBanner();
        return this;
      }
      
      public Builder clearCard() {
        copyOnWrite();
        ((MessagesProto.Content)this.instance).clearCard();
        return this;
      }
      
      public Builder clearImageOnly() {
        copyOnWrite();
        ((MessagesProto.Content)this.instance).clearImageOnly();
        return this;
      }
      
      public Builder clearMessageDetails() {
        copyOnWrite();
        ((MessagesProto.Content)this.instance).clearMessageDetails();
        return this;
      }
      
      public Builder clearModal() {
        copyOnWrite();
        ((MessagesProto.Content)this.instance).clearModal();
        return this;
      }
      
      public MessagesProto.BannerMessage getBanner() {
        return ((MessagesProto.Content)this.instance).getBanner();
      }
      
      public MessagesProto.CardMessage getCard() {
        return ((MessagesProto.Content)this.instance).getCard();
      }
      
      public MessagesProto.ImageOnlyMessage getImageOnly() {
        return ((MessagesProto.Content)this.instance).getImageOnly();
      }
      
      public MessagesProto.Content.MessageDetailsCase getMessageDetailsCase() {
        return ((MessagesProto.Content)this.instance).getMessageDetailsCase();
      }
      
      public MessagesProto.ModalMessage getModal() {
        return ((MessagesProto.Content)this.instance).getModal();
      }
      
      public Builder mergeBanner(MessagesProto.BannerMessage param2BannerMessage) {
        copyOnWrite();
        ((MessagesProto.Content)this.instance).mergeBanner(param2BannerMessage);
        return this;
      }
      
      public Builder mergeCard(MessagesProto.CardMessage param2CardMessage) {
        copyOnWrite();
        ((MessagesProto.Content)this.instance).mergeCard(param2CardMessage);
        return this;
      }
      
      public Builder mergeImageOnly(MessagesProto.ImageOnlyMessage param2ImageOnlyMessage) {
        copyOnWrite();
        ((MessagesProto.Content)this.instance).mergeImageOnly(param2ImageOnlyMessage);
        return this;
      }
      
      public Builder mergeModal(MessagesProto.ModalMessage param2ModalMessage) {
        copyOnWrite();
        ((MessagesProto.Content)this.instance).mergeModal(param2ModalMessage);
        return this;
      }
      
      public Builder setBanner(MessagesProto.BannerMessage.Builder param2Builder) {
        copyOnWrite();
        ((MessagesProto.Content)this.instance).setBanner(param2Builder);
        return this;
      }
      
      public Builder setBanner(MessagesProto.BannerMessage param2BannerMessage) {
        copyOnWrite();
        ((MessagesProto.Content)this.instance).setBanner(param2BannerMessage);
        return this;
      }
      
      public Builder setCard(MessagesProto.CardMessage.Builder param2Builder) {
        copyOnWrite();
        ((MessagesProto.Content)this.instance).setCard(param2Builder);
        return this;
      }
      
      public Builder setCard(MessagesProto.CardMessage param2CardMessage) {
        copyOnWrite();
        ((MessagesProto.Content)this.instance).setCard(param2CardMessage);
        return this;
      }
      
      public Builder setImageOnly(MessagesProto.ImageOnlyMessage.Builder param2Builder) {
        copyOnWrite();
        ((MessagesProto.Content)this.instance).setImageOnly(param2Builder);
        return this;
      }
      
      public Builder setImageOnly(MessagesProto.ImageOnlyMessage param2ImageOnlyMessage) {
        copyOnWrite();
        ((MessagesProto.Content)this.instance).setImageOnly(param2ImageOnlyMessage);
        return this;
      }
      
      public Builder setModal(MessagesProto.ModalMessage.Builder param2Builder) {
        copyOnWrite();
        ((MessagesProto.Content)this.instance).setModal(param2Builder);
        return this;
      }
      
      public Builder setModal(MessagesProto.ModalMessage param2ModalMessage) {
        copyOnWrite();
        ((MessagesProto.Content)this.instance).setModal(param2ModalMessage);
        return this;
      }
    }
    
    public enum MessageDetailsCase implements Internal.EnumLite {
      BANNER(1),
      CARD(1),
      IMAGE_ONLY(1),
      MESSAGEDETAILS_NOT_SET(1),
      MODAL(2);
      
      private final int value;
      
      static {
        $VALUES = new MessageDetailsCase[] { BANNER, MODAL, IMAGE_ONLY, CARD, MESSAGEDETAILS_NOT_SET };
      }
      
      MessageDetailsCase(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static MessageDetailsCase forNumber(int param2Int) {
        switch (param2Int) {
          default:
            return null;
          case 4:
            return CARD;
          case 3:
            return IMAGE_ONLY;
          case 2:
            return MODAL;
          case 1:
            return BANNER;
          case 0:
            break;
        } 
        return MESSAGEDETAILS_NOT_SET;
      }
      
      public int getNumber() {
        return this.value;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Content, Content.Builder> implements ContentOrBuilder {
    private Builder() {
      super(MessagesProto.Content.DEFAULT_INSTANCE);
    }
    
    public Builder clearBanner() {
      copyOnWrite();
      ((MessagesProto.Content)this.instance).clearBanner();
      return this;
    }
    
    public Builder clearCard() {
      copyOnWrite();
      ((MessagesProto.Content)this.instance).clearCard();
      return this;
    }
    
    public Builder clearImageOnly() {
      copyOnWrite();
      ((MessagesProto.Content)this.instance).clearImageOnly();
      return this;
    }
    
    public Builder clearMessageDetails() {
      copyOnWrite();
      ((MessagesProto.Content)this.instance).clearMessageDetails();
      return this;
    }
    
    public Builder clearModal() {
      copyOnWrite();
      ((MessagesProto.Content)this.instance).clearModal();
      return this;
    }
    
    public MessagesProto.BannerMessage getBanner() {
      return ((MessagesProto.Content)this.instance).getBanner();
    }
    
    public MessagesProto.CardMessage getCard() {
      return ((MessagesProto.Content)this.instance).getCard();
    }
    
    public MessagesProto.ImageOnlyMessage getImageOnly() {
      return ((MessagesProto.Content)this.instance).getImageOnly();
    }
    
    public MessagesProto.Content.MessageDetailsCase getMessageDetailsCase() {
      return ((MessagesProto.Content)this.instance).getMessageDetailsCase();
    }
    
    public MessagesProto.ModalMessage getModal() {
      return ((MessagesProto.Content)this.instance).getModal();
    }
    
    public Builder mergeBanner(MessagesProto.BannerMessage param1BannerMessage) {
      copyOnWrite();
      ((MessagesProto.Content)this.instance).mergeBanner(param1BannerMessage);
      return this;
    }
    
    public Builder mergeCard(MessagesProto.CardMessage param1CardMessage) {
      copyOnWrite();
      ((MessagesProto.Content)this.instance).mergeCard(param1CardMessage);
      return this;
    }
    
    public Builder mergeImageOnly(MessagesProto.ImageOnlyMessage param1ImageOnlyMessage) {
      copyOnWrite();
      ((MessagesProto.Content)this.instance).mergeImageOnly(param1ImageOnlyMessage);
      return this;
    }
    
    public Builder mergeModal(MessagesProto.ModalMessage param1ModalMessage) {
      copyOnWrite();
      ((MessagesProto.Content)this.instance).mergeModal(param1ModalMessage);
      return this;
    }
    
    public Builder setBanner(MessagesProto.BannerMessage.Builder param1Builder) {
      copyOnWrite();
      ((MessagesProto.Content)this.instance).setBanner(param1Builder);
      return this;
    }
    
    public Builder setBanner(MessagesProto.BannerMessage param1BannerMessage) {
      copyOnWrite();
      ((MessagesProto.Content)this.instance).setBanner(param1BannerMessage);
      return this;
    }
    
    public Builder setCard(MessagesProto.CardMessage.Builder param1Builder) {
      copyOnWrite();
      ((MessagesProto.Content)this.instance).setCard(param1Builder);
      return this;
    }
    
    public Builder setCard(MessagesProto.CardMessage param1CardMessage) {
      copyOnWrite();
      ((MessagesProto.Content)this.instance).setCard(param1CardMessage);
      return this;
    }
    
    public Builder setImageOnly(MessagesProto.ImageOnlyMessage.Builder param1Builder) {
      copyOnWrite();
      ((MessagesProto.Content)this.instance).setImageOnly(param1Builder);
      return this;
    }
    
    public Builder setImageOnly(MessagesProto.ImageOnlyMessage param1ImageOnlyMessage) {
      copyOnWrite();
      ((MessagesProto.Content)this.instance).setImageOnly(param1ImageOnlyMessage);
      return this;
    }
    
    public Builder setModal(MessagesProto.ModalMessage.Builder param1Builder) {
      copyOnWrite();
      ((MessagesProto.Content)this.instance).setModal(param1Builder);
      return this;
    }
    
    public Builder setModal(MessagesProto.ModalMessage param1ModalMessage) {
      copyOnWrite();
      ((MessagesProto.Content)this.instance).setModal(param1ModalMessage);
      return this;
    }
  }
  
  public enum MessageDetailsCase implements Internal.EnumLite {
    BANNER(1),
    CARD(1),
    IMAGE_ONLY(1),
    MESSAGEDETAILS_NOT_SET(1),
    MODAL(2);
    
    private final int value;
    
    static {
      CARD = new MessageDetailsCase("CARD", 3, 4);
      MESSAGEDETAILS_NOT_SET = new MessageDetailsCase("MESSAGEDETAILS_NOT_SET", 4, 0);
      $VALUES = new MessageDetailsCase[] { BANNER, MODAL, IMAGE_ONLY, CARD, MESSAGEDETAILS_NOT_SET };
    }
    
    MessageDetailsCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static MessageDetailsCase forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 4:
          return CARD;
        case 3:
          return IMAGE_ONLY;
        case 2:
          return MODAL;
        case 1:
          return BANNER;
        case 0:
          break;
      } 
      return MESSAGEDETAILS_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
  
  public static interface ContentOrBuilder extends MessageLiteOrBuilder {
    MessagesProto.BannerMessage getBanner();
    
    MessagesProto.CardMessage getCard();
    
    MessagesProto.ImageOnlyMessage getImageOnly();
    
    MessagesProto.Content.MessageDetailsCase getMessageDetailsCase();
    
    MessagesProto.ModalMessage getModal();
  }
  
  public static final class ImageOnlyMessage extends GeneratedMessageLite<ImageOnlyMessage, ImageOnlyMessage.Builder> implements ImageOnlyMessageOrBuilder {
    public static final int ACTION_FIELD_NUMBER = 2;
    
    private static final ImageOnlyMessage DEFAULT_INSTANCE = new ImageOnlyMessage();
    
    public static final int IMAGE_URL_FIELD_NUMBER = 1;
    
    private static volatile Parser<ImageOnlyMessage> PARSER;
    
    private MessagesProto.Action action_;
    
    private String imageUrl_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearAction() {
      this.action_ = null;
    }
    
    private void clearImageUrl() {
      this.imageUrl_ = getDefaultInstance().getImageUrl();
    }
    
    public static ImageOnlyMessage getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeAction(MessagesProto.Action param1Action) {
      MessagesProto.Action action = this.action_;
      if (action != null && action != MessagesProto.Action.getDefaultInstance()) {
        this.action_ = (MessagesProto.Action)((MessagesProto.Action.Builder)MessagesProto.Action.newBuilder(this.action_).mergeFrom(param1Action)).buildPartial();
      } else {
        this.action_ = param1Action;
      } 
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ImageOnlyMessage param1ImageOnlyMessage) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1ImageOnlyMessage);
    }
    
    public static ImageOnlyMessage parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (ImageOnlyMessage)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static ImageOnlyMessage parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ImageOnlyMessage)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ImageOnlyMessage parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (ImageOnlyMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static ImageOnlyMessage parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ImageOnlyMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static ImageOnlyMessage parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (ImageOnlyMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static ImageOnlyMessage parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ImageOnlyMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static ImageOnlyMessage parseFrom(InputStream param1InputStream) throws IOException {
      return (ImageOnlyMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static ImageOnlyMessage parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ImageOnlyMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ImageOnlyMessage parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (ImageOnlyMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static ImageOnlyMessage parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ImageOnlyMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<ImageOnlyMessage> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setAction(MessagesProto.Action.Builder param1Builder) {
      this.action_ = (MessagesProto.Action)param1Builder.build();
    }
    
    private void setAction(MessagesProto.Action param1Action) {
      if (param1Action != null) {
        this.action_ = param1Action;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setImageUrl(String param1String) {
      if (param1String != null) {
        this.imageUrl_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setImageUrlBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.imageUrl_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firebase/inappmessaging/MessagesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 392, 2 -> 388, 3 -> 386, 4 -> 377, 5 -> 304, 6 -> 110, 7 -> 300, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/firebase/inappmessaging/MessagesProto$ImageOnlyMessage.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/firebase/inappmessaging/MessagesProto$ImageOnlyMessage
      //   72: monitorenter
      //   73: getstatic com/google/firebase/inappmessaging/MessagesProto$ImageOnlyMessage.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/firebase/inappmessaging/MessagesProto$ImageOnlyMessage.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/MessagesProto$ImageOnlyMessage;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/firebase/inappmessaging/MessagesProto$ImageOnlyMessage.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/firebase/inappmessaging/MessagesProto$ImageOnlyMessage
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/firebase/inappmessaging/MessagesProto$ImageOnlyMessage
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/firebase/inappmessaging/MessagesProto$ImageOnlyMessage.PARSER : Lcom/google/protobuf/Parser;
      //   109: areturn
      //   110: aload_2
      //   111: checkcast com/google/protobuf/CodedInputStream
      //   114: astore_2
      //   115: aload_3
      //   116: checkcast com/google/protobuf/ExtensionRegistryLite
      //   119: astore_3
      //   120: iconst_0
      //   121: istore #4
      //   123: iload #4
      //   125: ifne -> 300
      //   128: aload_2
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 244
      //   139: iload #5
      //   141: bipush #10
      //   143: if_icmpeq -> 233
      //   146: iload #5
      //   148: bipush #18
      //   150: if_icmpeq -> 168
      //   153: aload_2
      //   154: iload #5
      //   156: invokevirtual skipField : (I)Z
      //   159: ifne -> 123
      //   162: iconst_1
      //   163: istore #4
      //   165: goto -> 123
      //   168: aload_0
      //   169: getfield action_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   172: ifnull -> 189
      //   175: aload_0
      //   176: getfield action_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   179: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   182: checkcast com/google/firebase/inappmessaging/MessagesProto$Action$Builder
      //   185: astore_1
      //   186: goto -> 191
      //   189: aconst_null
      //   190: astore_1
      //   191: aload_0
      //   192: aload_2
      //   193: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   196: aload_3
      //   197: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   200: checkcast com/google/firebase/inappmessaging/MessagesProto$Action
      //   203: putfield action_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   206: aload_1
      //   207: ifnull -> 123
      //   210: aload_1
      //   211: aload_0
      //   212: getfield action_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   215: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   218: pop
      //   219: aload_0
      //   220: aload_1
      //   221: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   224: checkcast com/google/firebase/inappmessaging/MessagesProto$Action
      //   227: putfield action_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   230: goto -> 123
      //   233: aload_0
      //   234: aload_2
      //   235: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   238: putfield imageUrl_ : Ljava/lang/String;
      //   241: goto -> 123
      //   244: iconst_1
      //   245: istore #4
      //   247: goto -> 123
      //   250: astore_1
      //   251: goto -> 298
      //   254: astore_2
      //   255: new java/lang/RuntimeException
      //   258: astore_1
      //   259: new com/google/protobuf/InvalidProtocolBufferException
      //   262: astore_3
      //   263: aload_3
      //   264: aload_2
      //   265: invokevirtual getMessage : ()Ljava/lang/String;
      //   268: invokespecial <init> : (Ljava/lang/String;)V
      //   271: aload_1
      //   272: aload_3
      //   273: aload_0
      //   274: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   277: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   280: aload_1
      //   281: athrow
      //   282: astore_1
      //   283: new java/lang/RuntimeException
      //   286: astore_2
      //   287: aload_2
      //   288: aload_1
      //   289: aload_0
      //   290: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   293: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   296: aload_2
      //   297: athrow
      //   298: aload_1
      //   299: athrow
      //   300: getstatic com/google/firebase/inappmessaging/MessagesProto$ImageOnlyMessage.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/MessagesProto$ImageOnlyMessage;
      //   303: areturn
      //   304: aload_2
      //   305: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   308: astore_1
      //   309: aload_3
      //   310: checkcast com/google/firebase/inappmessaging/MessagesProto$ImageOnlyMessage
      //   313: astore_2
      //   314: aload_0
      //   315: aload_1
      //   316: aload_0
      //   317: getfield imageUrl_ : Ljava/lang/String;
      //   320: invokevirtual isEmpty : ()Z
      //   323: iconst_1
      //   324: ixor
      //   325: aload_0
      //   326: getfield imageUrl_ : Ljava/lang/String;
      //   329: iconst_1
      //   330: aload_2
      //   331: getfield imageUrl_ : Ljava/lang/String;
      //   334: invokevirtual isEmpty : ()Z
      //   337: ixor
      //   338: aload_2
      //   339: getfield imageUrl_ : Ljava/lang/String;
      //   342: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   347: putfield imageUrl_ : Ljava/lang/String;
      //   350: aload_0
      //   351: aload_1
      //   352: aload_0
      //   353: getfield action_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   356: aload_2
      //   357: getfield action_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   360: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   365: checkcast com/google/firebase/inappmessaging/MessagesProto$Action
      //   368: putfield action_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   371: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   374: astore_1
      //   375: aload_0
      //   376: areturn
      //   377: new com/google/firebase/inappmessaging/MessagesProto$ImageOnlyMessage$Builder
      //   380: dup
      //   381: aconst_null
      //   382: invokespecial <init> : (Lcom/google/firebase/inappmessaging/MessagesProto$1;)V
      //   385: areturn
      //   386: aconst_null
      //   387: areturn
      //   388: getstatic com/google/firebase/inappmessaging/MessagesProto$ImageOnlyMessage.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/MessagesProto$ImageOnlyMessage;
      //   391: areturn
      //   392: new com/google/firebase/inappmessaging/MessagesProto$ImageOnlyMessage
      //   395: dup
      //   396: invokespecial <init> : ()V
      //   399: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	282	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	254	java/io/IOException
      //   128	134	250	finally
      //   153	162	282	com/google/protobuf/InvalidProtocolBufferException
      //   153	162	254	java/io/IOException
      //   153	162	250	finally
      //   168	186	282	com/google/protobuf/InvalidProtocolBufferException
      //   168	186	254	java/io/IOException
      //   168	186	250	finally
      //   191	206	282	com/google/protobuf/InvalidProtocolBufferException
      //   191	206	254	java/io/IOException
      //   191	206	250	finally
      //   210	230	282	com/google/protobuf/InvalidProtocolBufferException
      //   210	230	254	java/io/IOException
      //   210	230	250	finally
      //   233	241	282	com/google/protobuf/InvalidProtocolBufferException
      //   233	241	254	java/io/IOException
      //   233	241	250	finally
      //   255	282	250	finally
      //   283	298	250	finally
    }
    
    public MessagesProto.Action getAction() {
      MessagesProto.Action action1 = this.action_;
      MessagesProto.Action action2 = action1;
      if (action1 == null)
        action2 = MessagesProto.Action.getDefaultInstance(); 
      return action2;
    }
    
    public String getImageUrl() {
      return this.imageUrl_;
    }
    
    public ByteString getImageUrlBytes() {
      return ByteString.copyFromUtf8(this.imageUrl_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (!this.imageUrl_.isEmpty())
        i = 0 + CodedOutputStream.computeStringSize(1, getImageUrl()); 
      int j = i;
      if (this.action_ != null)
        j = i + CodedOutputStream.computeMessageSize(2, (MessageLite)getAction()); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public boolean hasAction() {
      boolean bool;
      if (this.action_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.imageUrl_.isEmpty())
        param1CodedOutputStream.writeString(1, getImageUrl()); 
      if (this.action_ != null)
        param1CodedOutputStream.writeMessage(2, (MessageLite)getAction()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<ImageOnlyMessage, Builder> implements MessagesProto.ImageOnlyMessageOrBuilder {
      private Builder() {
        super(MessagesProto.ImageOnlyMessage.DEFAULT_INSTANCE);
      }
      
      public Builder clearAction() {
        copyOnWrite();
        ((MessagesProto.ImageOnlyMessage)this.instance).clearAction();
        return this;
      }
      
      public Builder clearImageUrl() {
        copyOnWrite();
        ((MessagesProto.ImageOnlyMessage)this.instance).clearImageUrl();
        return this;
      }
      
      public MessagesProto.Action getAction() {
        return ((MessagesProto.ImageOnlyMessage)this.instance).getAction();
      }
      
      public String getImageUrl() {
        return ((MessagesProto.ImageOnlyMessage)this.instance).getImageUrl();
      }
      
      public ByteString getImageUrlBytes() {
        return ((MessagesProto.ImageOnlyMessage)this.instance).getImageUrlBytes();
      }
      
      public boolean hasAction() {
        return ((MessagesProto.ImageOnlyMessage)this.instance).hasAction();
      }
      
      public Builder mergeAction(MessagesProto.Action param2Action) {
        copyOnWrite();
        ((MessagesProto.ImageOnlyMessage)this.instance).mergeAction(param2Action);
        return this;
      }
      
      public Builder setAction(MessagesProto.Action.Builder param2Builder) {
        copyOnWrite();
        ((MessagesProto.ImageOnlyMessage)this.instance).setAction(param2Builder);
        return this;
      }
      
      public Builder setAction(MessagesProto.Action param2Action) {
        copyOnWrite();
        ((MessagesProto.ImageOnlyMessage)this.instance).setAction(param2Action);
        return this;
      }
      
      public Builder setImageUrl(String param2String) {
        copyOnWrite();
        ((MessagesProto.ImageOnlyMessage)this.instance).setImageUrl(param2String);
        return this;
      }
      
      public Builder setImageUrlBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((MessagesProto.ImageOnlyMessage)this.instance).setImageUrlBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ImageOnlyMessage, ImageOnlyMessage.Builder> implements ImageOnlyMessageOrBuilder {
    private Builder() {
      super(MessagesProto.ImageOnlyMessage.DEFAULT_INSTANCE);
    }
    
    public Builder clearAction() {
      copyOnWrite();
      ((MessagesProto.ImageOnlyMessage)this.instance).clearAction();
      return this;
    }
    
    public Builder clearImageUrl() {
      copyOnWrite();
      ((MessagesProto.ImageOnlyMessage)this.instance).clearImageUrl();
      return this;
    }
    
    public MessagesProto.Action getAction() {
      return ((MessagesProto.ImageOnlyMessage)this.instance).getAction();
    }
    
    public String getImageUrl() {
      return ((MessagesProto.ImageOnlyMessage)this.instance).getImageUrl();
    }
    
    public ByteString getImageUrlBytes() {
      return ((MessagesProto.ImageOnlyMessage)this.instance).getImageUrlBytes();
    }
    
    public boolean hasAction() {
      return ((MessagesProto.ImageOnlyMessage)this.instance).hasAction();
    }
    
    public Builder mergeAction(MessagesProto.Action param1Action) {
      copyOnWrite();
      ((MessagesProto.ImageOnlyMessage)this.instance).mergeAction(param1Action);
      return this;
    }
    
    public Builder setAction(MessagesProto.Action.Builder param1Builder) {
      copyOnWrite();
      ((MessagesProto.ImageOnlyMessage)this.instance).setAction(param1Builder);
      return this;
    }
    
    public Builder setAction(MessagesProto.Action param1Action) {
      copyOnWrite();
      ((MessagesProto.ImageOnlyMessage)this.instance).setAction(param1Action);
      return this;
    }
    
    public Builder setImageUrl(String param1String) {
      copyOnWrite();
      ((MessagesProto.ImageOnlyMessage)this.instance).setImageUrl(param1String);
      return this;
    }
    
    public Builder setImageUrlBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((MessagesProto.ImageOnlyMessage)this.instance).setImageUrlBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface ImageOnlyMessageOrBuilder extends MessageLiteOrBuilder {
    MessagesProto.Action getAction();
    
    String getImageUrl();
    
    ByteString getImageUrlBytes();
    
    boolean hasAction();
  }
  
  public static final class ModalMessage extends GeneratedMessageLite<ModalMessage, ModalMessage.Builder> implements ModalMessageOrBuilder {
    public static final int ACTION_BUTTON_FIELD_NUMBER = 4;
    
    public static final int ACTION_FIELD_NUMBER = 5;
    
    public static final int BACKGROUND_HEX_COLOR_FIELD_NUMBER = 6;
    
    public static final int BODY_FIELD_NUMBER = 2;
    
    private static final ModalMessage DEFAULT_INSTANCE = new ModalMessage();
    
    public static final int IMAGE_URL_FIELD_NUMBER = 3;
    
    private static volatile Parser<ModalMessage> PARSER;
    
    public static final int TITLE_FIELD_NUMBER = 1;
    
    private MessagesProto.Button actionButton_;
    
    private MessagesProto.Action action_;
    
    private String backgroundHexColor_ = "";
    
    private MessagesProto.Text body_;
    
    private String imageUrl_ = "";
    
    private MessagesProto.Text title_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearAction() {
      this.action_ = null;
    }
    
    private void clearActionButton() {
      this.actionButton_ = null;
    }
    
    private void clearBackgroundHexColor() {
      this.backgroundHexColor_ = getDefaultInstance().getBackgroundHexColor();
    }
    
    private void clearBody() {
      this.body_ = null;
    }
    
    private void clearImageUrl() {
      this.imageUrl_ = getDefaultInstance().getImageUrl();
    }
    
    private void clearTitle() {
      this.title_ = null;
    }
    
    public static ModalMessage getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeAction(MessagesProto.Action param1Action) {
      MessagesProto.Action action = this.action_;
      if (action != null && action != MessagesProto.Action.getDefaultInstance()) {
        this.action_ = (MessagesProto.Action)((MessagesProto.Action.Builder)MessagesProto.Action.newBuilder(this.action_).mergeFrom(param1Action)).buildPartial();
      } else {
        this.action_ = param1Action;
      } 
    }
    
    private void mergeActionButton(MessagesProto.Button param1Button) {
      MessagesProto.Button button = this.actionButton_;
      if (button != null && button != MessagesProto.Button.getDefaultInstance()) {
        this.actionButton_ = (MessagesProto.Button)((MessagesProto.Button.Builder)MessagesProto.Button.newBuilder(this.actionButton_).mergeFrom(param1Button)).buildPartial();
      } else {
        this.actionButton_ = param1Button;
      } 
    }
    
    private void mergeBody(MessagesProto.Text param1Text) {
      MessagesProto.Text text = this.body_;
      if (text != null && text != MessagesProto.Text.getDefaultInstance()) {
        this.body_ = (MessagesProto.Text)((MessagesProto.Text.Builder)MessagesProto.Text.newBuilder(this.body_).mergeFrom(param1Text)).buildPartial();
      } else {
        this.body_ = param1Text;
      } 
    }
    
    private void mergeTitle(MessagesProto.Text param1Text) {
      MessagesProto.Text text = this.title_;
      if (text != null && text != MessagesProto.Text.getDefaultInstance()) {
        this.title_ = (MessagesProto.Text)((MessagesProto.Text.Builder)MessagesProto.Text.newBuilder(this.title_).mergeFrom(param1Text)).buildPartial();
      } else {
        this.title_ = param1Text;
      } 
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ModalMessage param1ModalMessage) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1ModalMessage);
    }
    
    public static ModalMessage parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (ModalMessage)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static ModalMessage parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ModalMessage)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ModalMessage parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (ModalMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static ModalMessage parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ModalMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static ModalMessage parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (ModalMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static ModalMessage parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ModalMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static ModalMessage parseFrom(InputStream param1InputStream) throws IOException {
      return (ModalMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static ModalMessage parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ModalMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ModalMessage parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (ModalMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static ModalMessage parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ModalMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<ModalMessage> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setAction(MessagesProto.Action.Builder param1Builder) {
      this.action_ = (MessagesProto.Action)param1Builder.build();
    }
    
    private void setAction(MessagesProto.Action param1Action) {
      if (param1Action != null) {
        this.action_ = param1Action;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setActionButton(MessagesProto.Button.Builder param1Builder) {
      this.actionButton_ = (MessagesProto.Button)param1Builder.build();
    }
    
    private void setActionButton(MessagesProto.Button param1Button) {
      if (param1Button != null) {
        this.actionButton_ = param1Button;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setBackgroundHexColor(String param1String) {
      if (param1String != null) {
        this.backgroundHexColor_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setBackgroundHexColorBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.backgroundHexColor_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setBody(MessagesProto.Text.Builder param1Builder) {
      this.body_ = (MessagesProto.Text)param1Builder.build();
    }
    
    private void setBody(MessagesProto.Text param1Text) {
      if (param1Text != null) {
        this.body_ = param1Text;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setImageUrl(String param1String) {
      if (param1String != null) {
        this.imageUrl_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setImageUrlBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.imageUrl_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTitle(MessagesProto.Text.Builder param1Builder) {
      this.title_ = (MessagesProto.Text)param1Builder.build();
    }
    
    private void setTitle(MessagesProto.Text param1Text) {
      if (param1Text != null) {
        this.title_ = param1Text;
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firebase/inappmessaging/MessagesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 725, 2 -> 721, 3 -> 719, 4 -> 710, 5 -> 538, 6 -> 110, 7 -> 534, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/firebase/inappmessaging/MessagesProto$ModalMessage.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/firebase/inappmessaging/MessagesProto$ModalMessage
      //   72: monitorenter
      //   73: getstatic com/google/firebase/inappmessaging/MessagesProto$ModalMessage.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/firebase/inappmessaging/MessagesProto$ModalMessage.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/MessagesProto$ModalMessage;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/firebase/inappmessaging/MessagesProto$ModalMessage.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/firebase/inappmessaging/MessagesProto$ModalMessage
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/firebase/inappmessaging/MessagesProto$ModalMessage
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/firebase/inappmessaging/MessagesProto$ModalMessage.PARSER : Lcom/google/protobuf/Parser;
      //   109: areturn
      //   110: aload_2
      //   111: checkcast com/google/protobuf/CodedInputStream
      //   114: astore_2
      //   115: aload_3
      //   116: checkcast com/google/protobuf/ExtensionRegistryLite
      //   119: astore_3
      //   120: iconst_0
      //   121: istore #4
      //   123: iload #4
      //   125: ifne -> 534
      //   128: aload_2
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 478
      //   139: iload #5
      //   141: bipush #10
      //   143: if_icmpeq -> 413
      //   146: iload #5
      //   148: bipush #18
      //   150: if_icmpeq -> 348
      //   153: iload #5
      //   155: bipush #26
      //   157: if_icmpeq -> 337
      //   160: iload #5
      //   162: bipush #34
      //   164: if_icmpeq -> 272
      //   167: iload #5
      //   169: bipush #42
      //   171: if_icmpeq -> 207
      //   174: iload #5
      //   176: bipush #50
      //   178: if_icmpeq -> 196
      //   181: aload_2
      //   182: iload #5
      //   184: invokevirtual skipField : (I)Z
      //   187: ifne -> 123
      //   190: iconst_1
      //   191: istore #4
      //   193: goto -> 123
      //   196: aload_0
      //   197: aload_2
      //   198: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   201: putfield backgroundHexColor_ : Ljava/lang/String;
      //   204: goto -> 123
      //   207: aload_0
      //   208: getfield action_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   211: ifnull -> 228
      //   214: aload_0
      //   215: getfield action_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   218: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   221: checkcast com/google/firebase/inappmessaging/MessagesProto$Action$Builder
      //   224: astore_1
      //   225: goto -> 230
      //   228: aconst_null
      //   229: astore_1
      //   230: aload_0
      //   231: aload_2
      //   232: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   235: aload_3
      //   236: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   239: checkcast com/google/firebase/inappmessaging/MessagesProto$Action
      //   242: putfield action_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   245: aload_1
      //   246: ifnull -> 123
      //   249: aload_1
      //   250: aload_0
      //   251: getfield action_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   254: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   257: pop
      //   258: aload_0
      //   259: aload_1
      //   260: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   263: checkcast com/google/firebase/inappmessaging/MessagesProto$Action
      //   266: putfield action_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   269: goto -> 123
      //   272: aload_0
      //   273: getfield actionButton_ : Lcom/google/firebase/inappmessaging/MessagesProto$Button;
      //   276: ifnull -> 293
      //   279: aload_0
      //   280: getfield actionButton_ : Lcom/google/firebase/inappmessaging/MessagesProto$Button;
      //   283: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   286: checkcast com/google/firebase/inappmessaging/MessagesProto$Button$Builder
      //   289: astore_1
      //   290: goto -> 295
      //   293: aconst_null
      //   294: astore_1
      //   295: aload_0
      //   296: aload_2
      //   297: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   300: aload_3
      //   301: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   304: checkcast com/google/firebase/inappmessaging/MessagesProto$Button
      //   307: putfield actionButton_ : Lcom/google/firebase/inappmessaging/MessagesProto$Button;
      //   310: aload_1
      //   311: ifnull -> 123
      //   314: aload_1
      //   315: aload_0
      //   316: getfield actionButton_ : Lcom/google/firebase/inappmessaging/MessagesProto$Button;
      //   319: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   322: pop
      //   323: aload_0
      //   324: aload_1
      //   325: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   328: checkcast com/google/firebase/inappmessaging/MessagesProto$Button
      //   331: putfield actionButton_ : Lcom/google/firebase/inappmessaging/MessagesProto$Button;
      //   334: goto -> 123
      //   337: aload_0
      //   338: aload_2
      //   339: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   342: putfield imageUrl_ : Ljava/lang/String;
      //   345: goto -> 123
      //   348: aload_0
      //   349: getfield body_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   352: ifnull -> 369
      //   355: aload_0
      //   356: getfield body_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   359: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   362: checkcast com/google/firebase/inappmessaging/MessagesProto$Text$Builder
      //   365: astore_1
      //   366: goto -> 371
      //   369: aconst_null
      //   370: astore_1
      //   371: aload_0
      //   372: aload_2
      //   373: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   376: aload_3
      //   377: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   380: checkcast com/google/firebase/inappmessaging/MessagesProto$Text
      //   383: putfield body_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   386: aload_1
      //   387: ifnull -> 123
      //   390: aload_1
      //   391: aload_0
      //   392: getfield body_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   395: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   398: pop
      //   399: aload_0
      //   400: aload_1
      //   401: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   404: checkcast com/google/firebase/inappmessaging/MessagesProto$Text
      //   407: putfield body_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   410: goto -> 123
      //   413: aload_0
      //   414: getfield title_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   417: ifnull -> 434
      //   420: aload_0
      //   421: getfield title_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   424: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   427: checkcast com/google/firebase/inappmessaging/MessagesProto$Text$Builder
      //   430: astore_1
      //   431: goto -> 436
      //   434: aconst_null
      //   435: astore_1
      //   436: aload_0
      //   437: aload_2
      //   438: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   441: aload_3
      //   442: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   445: checkcast com/google/firebase/inappmessaging/MessagesProto$Text
      //   448: putfield title_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   451: aload_1
      //   452: ifnull -> 123
      //   455: aload_1
      //   456: aload_0
      //   457: getfield title_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   460: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   463: pop
      //   464: aload_0
      //   465: aload_1
      //   466: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   469: checkcast com/google/firebase/inappmessaging/MessagesProto$Text
      //   472: putfield title_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   475: goto -> 123
      //   478: iconst_1
      //   479: istore #4
      //   481: goto -> 123
      //   484: astore_1
      //   485: goto -> 532
      //   488: astore_3
      //   489: new java/lang/RuntimeException
      //   492: astore_2
      //   493: new com/google/protobuf/InvalidProtocolBufferException
      //   496: astore_1
      //   497: aload_1
      //   498: aload_3
      //   499: invokevirtual getMessage : ()Ljava/lang/String;
      //   502: invokespecial <init> : (Ljava/lang/String;)V
      //   505: aload_2
      //   506: aload_1
      //   507: aload_0
      //   508: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   511: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   514: aload_2
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
      //   534: getstatic com/google/firebase/inappmessaging/MessagesProto$ModalMessage.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/MessagesProto$ModalMessage;
      //   537: areturn
      //   538: aload_2
      //   539: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   542: astore_1
      //   543: aload_3
      //   544: checkcast com/google/firebase/inappmessaging/MessagesProto$ModalMessage
      //   547: astore_2
      //   548: aload_0
      //   549: aload_1
      //   550: aload_0
      //   551: getfield title_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   554: aload_2
      //   555: getfield title_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   558: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   563: checkcast com/google/firebase/inappmessaging/MessagesProto$Text
      //   566: putfield title_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   569: aload_0
      //   570: aload_1
      //   571: aload_0
      //   572: getfield body_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   575: aload_2
      //   576: getfield body_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   579: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   584: checkcast com/google/firebase/inappmessaging/MessagesProto$Text
      //   587: putfield body_ : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   590: aload_0
      //   591: aload_1
      //   592: aload_0
      //   593: getfield imageUrl_ : Ljava/lang/String;
      //   596: invokevirtual isEmpty : ()Z
      //   599: iconst_1
      //   600: ixor
      //   601: aload_0
      //   602: getfield imageUrl_ : Ljava/lang/String;
      //   605: aload_2
      //   606: getfield imageUrl_ : Ljava/lang/String;
      //   609: invokevirtual isEmpty : ()Z
      //   612: iconst_1
      //   613: ixor
      //   614: aload_2
      //   615: getfield imageUrl_ : Ljava/lang/String;
      //   618: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   623: putfield imageUrl_ : Ljava/lang/String;
      //   626: aload_0
      //   627: aload_1
      //   628: aload_0
      //   629: getfield actionButton_ : Lcom/google/firebase/inappmessaging/MessagesProto$Button;
      //   632: aload_2
      //   633: getfield actionButton_ : Lcom/google/firebase/inappmessaging/MessagesProto$Button;
      //   636: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   641: checkcast com/google/firebase/inappmessaging/MessagesProto$Button
      //   644: putfield actionButton_ : Lcom/google/firebase/inappmessaging/MessagesProto$Button;
      //   647: aload_0
      //   648: aload_1
      //   649: aload_0
      //   650: getfield action_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   653: aload_2
      //   654: getfield action_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   657: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   662: checkcast com/google/firebase/inappmessaging/MessagesProto$Action
      //   665: putfield action_ : Lcom/google/firebase/inappmessaging/MessagesProto$Action;
      //   668: aload_0
      //   669: aload_1
      //   670: aload_0
      //   671: getfield backgroundHexColor_ : Ljava/lang/String;
      //   674: invokevirtual isEmpty : ()Z
      //   677: iconst_1
      //   678: ixor
      //   679: aload_0
      //   680: getfield backgroundHexColor_ : Ljava/lang/String;
      //   683: iconst_1
      //   684: aload_2
      //   685: getfield backgroundHexColor_ : Ljava/lang/String;
      //   688: invokevirtual isEmpty : ()Z
      //   691: ixor
      //   692: aload_2
      //   693: getfield backgroundHexColor_ : Ljava/lang/String;
      //   696: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   701: putfield backgroundHexColor_ : Ljava/lang/String;
      //   704: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   707: astore_1
      //   708: aload_0
      //   709: areturn
      //   710: new com/google/firebase/inappmessaging/MessagesProto$ModalMessage$Builder
      //   713: dup
      //   714: aconst_null
      //   715: invokespecial <init> : (Lcom/google/firebase/inappmessaging/MessagesProto$1;)V
      //   718: areturn
      //   719: aconst_null
      //   720: areturn
      //   721: getstatic com/google/firebase/inappmessaging/MessagesProto$ModalMessage.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/MessagesProto$ModalMessage;
      //   724: areturn
      //   725: new com/google/firebase/inappmessaging/MessagesProto$ModalMessage
      //   728: dup
      //   729: invokespecial <init> : ()V
      //   732: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	516	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	488	java/io/IOException
      //   128	134	484	finally
      //   181	190	516	com/google/protobuf/InvalidProtocolBufferException
      //   181	190	488	java/io/IOException
      //   181	190	484	finally
      //   196	204	516	com/google/protobuf/InvalidProtocolBufferException
      //   196	204	488	java/io/IOException
      //   196	204	484	finally
      //   207	225	516	com/google/protobuf/InvalidProtocolBufferException
      //   207	225	488	java/io/IOException
      //   207	225	484	finally
      //   230	245	516	com/google/protobuf/InvalidProtocolBufferException
      //   230	245	488	java/io/IOException
      //   230	245	484	finally
      //   249	269	516	com/google/protobuf/InvalidProtocolBufferException
      //   249	269	488	java/io/IOException
      //   249	269	484	finally
      //   272	290	516	com/google/protobuf/InvalidProtocolBufferException
      //   272	290	488	java/io/IOException
      //   272	290	484	finally
      //   295	310	516	com/google/protobuf/InvalidProtocolBufferException
      //   295	310	488	java/io/IOException
      //   295	310	484	finally
      //   314	334	516	com/google/protobuf/InvalidProtocolBufferException
      //   314	334	488	java/io/IOException
      //   314	334	484	finally
      //   337	345	516	com/google/protobuf/InvalidProtocolBufferException
      //   337	345	488	java/io/IOException
      //   337	345	484	finally
      //   348	366	516	com/google/protobuf/InvalidProtocolBufferException
      //   348	366	488	java/io/IOException
      //   348	366	484	finally
      //   371	386	516	com/google/protobuf/InvalidProtocolBufferException
      //   371	386	488	java/io/IOException
      //   371	386	484	finally
      //   390	410	516	com/google/protobuf/InvalidProtocolBufferException
      //   390	410	488	java/io/IOException
      //   390	410	484	finally
      //   413	431	516	com/google/protobuf/InvalidProtocolBufferException
      //   413	431	488	java/io/IOException
      //   413	431	484	finally
      //   436	451	516	com/google/protobuf/InvalidProtocolBufferException
      //   436	451	488	java/io/IOException
      //   436	451	484	finally
      //   455	475	516	com/google/protobuf/InvalidProtocolBufferException
      //   455	475	488	java/io/IOException
      //   455	475	484	finally
      //   489	516	484	finally
      //   517	532	484	finally
    }
    
    public MessagesProto.Action getAction() {
      MessagesProto.Action action1 = this.action_;
      MessagesProto.Action action2 = action1;
      if (action1 == null)
        action2 = MessagesProto.Action.getDefaultInstance(); 
      return action2;
    }
    
    public MessagesProto.Button getActionButton() {
      MessagesProto.Button button1 = this.actionButton_;
      MessagesProto.Button button2 = button1;
      if (button1 == null)
        button2 = MessagesProto.Button.getDefaultInstance(); 
      return button2;
    }
    
    public String getBackgroundHexColor() {
      return this.backgroundHexColor_;
    }
    
    public ByteString getBackgroundHexColorBytes() {
      return ByteString.copyFromUtf8(this.backgroundHexColor_);
    }
    
    public MessagesProto.Text getBody() {
      MessagesProto.Text text1 = this.body_;
      MessagesProto.Text text2 = text1;
      if (text1 == null)
        text2 = MessagesProto.Text.getDefaultInstance(); 
      return text2;
    }
    
    public String getImageUrl() {
      return this.imageUrl_;
    }
    
    public ByteString getImageUrlBytes() {
      return ByteString.copyFromUtf8(this.imageUrl_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.title_ != null)
        j = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)getTitle()); 
      i = j;
      if (this.body_ != null)
        i = j + CodedOutputStream.computeMessageSize(2, (MessageLite)getBody()); 
      j = i;
      if (!this.imageUrl_.isEmpty())
        j = i + CodedOutputStream.computeStringSize(3, getImageUrl()); 
      i = j;
      if (this.actionButton_ != null)
        i = j + CodedOutputStream.computeMessageSize(4, (MessageLite)getActionButton()); 
      j = i;
      if (this.action_ != null)
        j = i + CodedOutputStream.computeMessageSize(5, (MessageLite)getAction()); 
      i = j;
      if (!this.backgroundHexColor_.isEmpty())
        i = j + CodedOutputStream.computeStringSize(6, getBackgroundHexColor()); 
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public MessagesProto.Text getTitle() {
      MessagesProto.Text text1 = this.title_;
      MessagesProto.Text text2 = text1;
      if (text1 == null)
        text2 = MessagesProto.Text.getDefaultInstance(); 
      return text2;
    }
    
    public boolean hasAction() {
      boolean bool;
      if (this.action_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasActionButton() {
      boolean bool;
      if (this.actionButton_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasBody() {
      boolean bool;
      if (this.body_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasTitle() {
      boolean bool;
      if (this.title_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.title_ != null)
        param1CodedOutputStream.writeMessage(1, (MessageLite)getTitle()); 
      if (this.body_ != null)
        param1CodedOutputStream.writeMessage(2, (MessageLite)getBody()); 
      if (!this.imageUrl_.isEmpty())
        param1CodedOutputStream.writeString(3, getImageUrl()); 
      if (this.actionButton_ != null)
        param1CodedOutputStream.writeMessage(4, (MessageLite)getActionButton()); 
      if (this.action_ != null)
        param1CodedOutputStream.writeMessage(5, (MessageLite)getAction()); 
      if (!this.backgroundHexColor_.isEmpty())
        param1CodedOutputStream.writeString(6, getBackgroundHexColor()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<ModalMessage, Builder> implements MessagesProto.ModalMessageOrBuilder {
      private Builder() {
        super(MessagesProto.ModalMessage.DEFAULT_INSTANCE);
      }
      
      public Builder clearAction() {
        copyOnWrite();
        ((MessagesProto.ModalMessage)this.instance).clearAction();
        return this;
      }
      
      public Builder clearActionButton() {
        copyOnWrite();
        ((MessagesProto.ModalMessage)this.instance).clearActionButton();
        return this;
      }
      
      public Builder clearBackgroundHexColor() {
        copyOnWrite();
        ((MessagesProto.ModalMessage)this.instance).clearBackgroundHexColor();
        return this;
      }
      
      public Builder clearBody() {
        copyOnWrite();
        ((MessagesProto.ModalMessage)this.instance).clearBody();
        return this;
      }
      
      public Builder clearImageUrl() {
        copyOnWrite();
        ((MessagesProto.ModalMessage)this.instance).clearImageUrl();
        return this;
      }
      
      public Builder clearTitle() {
        copyOnWrite();
        ((MessagesProto.ModalMessage)this.instance).clearTitle();
        return this;
      }
      
      public MessagesProto.Action getAction() {
        return ((MessagesProto.ModalMessage)this.instance).getAction();
      }
      
      public MessagesProto.Button getActionButton() {
        return ((MessagesProto.ModalMessage)this.instance).getActionButton();
      }
      
      public String getBackgroundHexColor() {
        return ((MessagesProto.ModalMessage)this.instance).getBackgroundHexColor();
      }
      
      public ByteString getBackgroundHexColorBytes() {
        return ((MessagesProto.ModalMessage)this.instance).getBackgroundHexColorBytes();
      }
      
      public MessagesProto.Text getBody() {
        return ((MessagesProto.ModalMessage)this.instance).getBody();
      }
      
      public String getImageUrl() {
        return ((MessagesProto.ModalMessage)this.instance).getImageUrl();
      }
      
      public ByteString getImageUrlBytes() {
        return ((MessagesProto.ModalMessage)this.instance).getImageUrlBytes();
      }
      
      public MessagesProto.Text getTitle() {
        return ((MessagesProto.ModalMessage)this.instance).getTitle();
      }
      
      public boolean hasAction() {
        return ((MessagesProto.ModalMessage)this.instance).hasAction();
      }
      
      public boolean hasActionButton() {
        return ((MessagesProto.ModalMessage)this.instance).hasActionButton();
      }
      
      public boolean hasBody() {
        return ((MessagesProto.ModalMessage)this.instance).hasBody();
      }
      
      public boolean hasTitle() {
        return ((MessagesProto.ModalMessage)this.instance).hasTitle();
      }
      
      public Builder mergeAction(MessagesProto.Action param2Action) {
        copyOnWrite();
        ((MessagesProto.ModalMessage)this.instance).mergeAction(param2Action);
        return this;
      }
      
      public Builder mergeActionButton(MessagesProto.Button param2Button) {
        copyOnWrite();
        ((MessagesProto.ModalMessage)this.instance).mergeActionButton(param2Button);
        return this;
      }
      
      public Builder mergeBody(MessagesProto.Text param2Text) {
        copyOnWrite();
        ((MessagesProto.ModalMessage)this.instance).mergeBody(param2Text);
        return this;
      }
      
      public Builder mergeTitle(MessagesProto.Text param2Text) {
        copyOnWrite();
        ((MessagesProto.ModalMessage)this.instance).mergeTitle(param2Text);
        return this;
      }
      
      public Builder setAction(MessagesProto.Action.Builder param2Builder) {
        copyOnWrite();
        ((MessagesProto.ModalMessage)this.instance).setAction(param2Builder);
        return this;
      }
      
      public Builder setAction(MessagesProto.Action param2Action) {
        copyOnWrite();
        ((MessagesProto.ModalMessage)this.instance).setAction(param2Action);
        return this;
      }
      
      public Builder setActionButton(MessagesProto.Button.Builder param2Builder) {
        copyOnWrite();
        ((MessagesProto.ModalMessage)this.instance).setActionButton(param2Builder);
        return this;
      }
      
      public Builder setActionButton(MessagesProto.Button param2Button) {
        copyOnWrite();
        ((MessagesProto.ModalMessage)this.instance).setActionButton(param2Button);
        return this;
      }
      
      public Builder setBackgroundHexColor(String param2String) {
        copyOnWrite();
        ((MessagesProto.ModalMessage)this.instance).setBackgroundHexColor(param2String);
        return this;
      }
      
      public Builder setBackgroundHexColorBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((MessagesProto.ModalMessage)this.instance).setBackgroundHexColorBytes(param2ByteString);
        return this;
      }
      
      public Builder setBody(MessagesProto.Text.Builder param2Builder) {
        copyOnWrite();
        ((MessagesProto.ModalMessage)this.instance).setBody(param2Builder);
        return this;
      }
      
      public Builder setBody(MessagesProto.Text param2Text) {
        copyOnWrite();
        ((MessagesProto.ModalMessage)this.instance).setBody(param2Text);
        return this;
      }
      
      public Builder setImageUrl(String param2String) {
        copyOnWrite();
        ((MessagesProto.ModalMessage)this.instance).setImageUrl(param2String);
        return this;
      }
      
      public Builder setImageUrlBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((MessagesProto.ModalMessage)this.instance).setImageUrlBytes(param2ByteString);
        return this;
      }
      
      public Builder setTitle(MessagesProto.Text.Builder param2Builder) {
        copyOnWrite();
        ((MessagesProto.ModalMessage)this.instance).setTitle(param2Builder);
        return this;
      }
      
      public Builder setTitle(MessagesProto.Text param2Text) {
        copyOnWrite();
        ((MessagesProto.ModalMessage)this.instance).setTitle(param2Text);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ModalMessage, ModalMessage.Builder> implements ModalMessageOrBuilder {
    private Builder() {
      super(MessagesProto.ModalMessage.DEFAULT_INSTANCE);
    }
    
    public Builder clearAction() {
      copyOnWrite();
      ((MessagesProto.ModalMessage)this.instance).clearAction();
      return this;
    }
    
    public Builder clearActionButton() {
      copyOnWrite();
      ((MessagesProto.ModalMessage)this.instance).clearActionButton();
      return this;
    }
    
    public Builder clearBackgroundHexColor() {
      copyOnWrite();
      ((MessagesProto.ModalMessage)this.instance).clearBackgroundHexColor();
      return this;
    }
    
    public Builder clearBody() {
      copyOnWrite();
      ((MessagesProto.ModalMessage)this.instance).clearBody();
      return this;
    }
    
    public Builder clearImageUrl() {
      copyOnWrite();
      ((MessagesProto.ModalMessage)this.instance).clearImageUrl();
      return this;
    }
    
    public Builder clearTitle() {
      copyOnWrite();
      ((MessagesProto.ModalMessage)this.instance).clearTitle();
      return this;
    }
    
    public MessagesProto.Action getAction() {
      return ((MessagesProto.ModalMessage)this.instance).getAction();
    }
    
    public MessagesProto.Button getActionButton() {
      return ((MessagesProto.ModalMessage)this.instance).getActionButton();
    }
    
    public String getBackgroundHexColor() {
      return ((MessagesProto.ModalMessage)this.instance).getBackgroundHexColor();
    }
    
    public ByteString getBackgroundHexColorBytes() {
      return ((MessagesProto.ModalMessage)this.instance).getBackgroundHexColorBytes();
    }
    
    public MessagesProto.Text getBody() {
      return ((MessagesProto.ModalMessage)this.instance).getBody();
    }
    
    public String getImageUrl() {
      return ((MessagesProto.ModalMessage)this.instance).getImageUrl();
    }
    
    public ByteString getImageUrlBytes() {
      return ((MessagesProto.ModalMessage)this.instance).getImageUrlBytes();
    }
    
    public MessagesProto.Text getTitle() {
      return ((MessagesProto.ModalMessage)this.instance).getTitle();
    }
    
    public boolean hasAction() {
      return ((MessagesProto.ModalMessage)this.instance).hasAction();
    }
    
    public boolean hasActionButton() {
      return ((MessagesProto.ModalMessage)this.instance).hasActionButton();
    }
    
    public boolean hasBody() {
      return ((MessagesProto.ModalMessage)this.instance).hasBody();
    }
    
    public boolean hasTitle() {
      return ((MessagesProto.ModalMessage)this.instance).hasTitle();
    }
    
    public Builder mergeAction(MessagesProto.Action param1Action) {
      copyOnWrite();
      ((MessagesProto.ModalMessage)this.instance).mergeAction(param1Action);
      return this;
    }
    
    public Builder mergeActionButton(MessagesProto.Button param1Button) {
      copyOnWrite();
      ((MessagesProto.ModalMessage)this.instance).mergeActionButton(param1Button);
      return this;
    }
    
    public Builder mergeBody(MessagesProto.Text param1Text) {
      copyOnWrite();
      ((MessagesProto.ModalMessage)this.instance).mergeBody(param1Text);
      return this;
    }
    
    public Builder mergeTitle(MessagesProto.Text param1Text) {
      copyOnWrite();
      ((MessagesProto.ModalMessage)this.instance).mergeTitle(param1Text);
      return this;
    }
    
    public Builder setAction(MessagesProto.Action.Builder param1Builder) {
      copyOnWrite();
      ((MessagesProto.ModalMessage)this.instance).setAction(param1Builder);
      return this;
    }
    
    public Builder setAction(MessagesProto.Action param1Action) {
      copyOnWrite();
      ((MessagesProto.ModalMessage)this.instance).setAction(param1Action);
      return this;
    }
    
    public Builder setActionButton(MessagesProto.Button.Builder param1Builder) {
      copyOnWrite();
      ((MessagesProto.ModalMessage)this.instance).setActionButton(param1Builder);
      return this;
    }
    
    public Builder setActionButton(MessagesProto.Button param1Button) {
      copyOnWrite();
      ((MessagesProto.ModalMessage)this.instance).setActionButton(param1Button);
      return this;
    }
    
    public Builder setBackgroundHexColor(String param1String) {
      copyOnWrite();
      ((MessagesProto.ModalMessage)this.instance).setBackgroundHexColor(param1String);
      return this;
    }
    
    public Builder setBackgroundHexColorBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((MessagesProto.ModalMessage)this.instance).setBackgroundHexColorBytes(param1ByteString);
      return this;
    }
    
    public Builder setBody(MessagesProto.Text.Builder param1Builder) {
      copyOnWrite();
      ((MessagesProto.ModalMessage)this.instance).setBody(param1Builder);
      return this;
    }
    
    public Builder setBody(MessagesProto.Text param1Text) {
      copyOnWrite();
      ((MessagesProto.ModalMessage)this.instance).setBody(param1Text);
      return this;
    }
    
    public Builder setImageUrl(String param1String) {
      copyOnWrite();
      ((MessagesProto.ModalMessage)this.instance).setImageUrl(param1String);
      return this;
    }
    
    public Builder setImageUrlBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((MessagesProto.ModalMessage)this.instance).setImageUrlBytes(param1ByteString);
      return this;
    }
    
    public Builder setTitle(MessagesProto.Text.Builder param1Builder) {
      copyOnWrite();
      ((MessagesProto.ModalMessage)this.instance).setTitle(param1Builder);
      return this;
    }
    
    public Builder setTitle(MessagesProto.Text param1Text) {
      copyOnWrite();
      ((MessagesProto.ModalMessage)this.instance).setTitle(param1Text);
      return this;
    }
  }
  
  public static interface ModalMessageOrBuilder extends MessageLiteOrBuilder {
    MessagesProto.Action getAction();
    
    MessagesProto.Button getActionButton();
    
    String getBackgroundHexColor();
    
    ByteString getBackgroundHexColorBytes();
    
    MessagesProto.Text getBody();
    
    String getImageUrl();
    
    ByteString getImageUrlBytes();
    
    MessagesProto.Text getTitle();
    
    boolean hasAction();
    
    boolean hasActionButton();
    
    boolean hasBody();
    
    boolean hasTitle();
  }
  
  public static final class Text extends GeneratedMessageLite<Text, Text.Builder> implements TextOrBuilder {
    private static final Text DEFAULT_INSTANCE = new Text();
    
    public static final int HEX_COLOR_FIELD_NUMBER = 2;
    
    private static volatile Parser<Text> PARSER;
    
    public static final int TEXT_FIELD_NUMBER = 1;
    
    private String hexColor_ = "";
    
    private String text_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearHexColor() {
      this.hexColor_ = getDefaultInstance().getHexColor();
    }
    
    private void clearText() {
      this.text_ = getDefaultInstance().getText();
    }
    
    public static Text getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Text param1Text) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1Text);
    }
    
    public static Text parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Text)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Text parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Text)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Text parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Text)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static Text parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Text)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Text parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Text)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static Text parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Text)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Text parseFrom(InputStream param1InputStream) throws IOException {
      return (Text)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Text parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Text)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Text parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Text)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static Text parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Text)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Text> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setHexColor(String param1String) {
      if (param1String != null) {
        this.hexColor_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setHexColorBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.hexColor_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setText(String param1String) {
      if (param1String != null) {
        this.text_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTextBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.text_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firebase/inappmessaging/MessagesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 353, 2 -> 349, 3 -> 347, 4 -> 338, 5 -> 250, 6 -> 110, 7 -> 246, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/firebase/inappmessaging/MessagesProto$Text.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/firebase/inappmessaging/MessagesProto$Text
      //   72: monitorenter
      //   73: getstatic com/google/firebase/inappmessaging/MessagesProto$Text.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/firebase/inappmessaging/MessagesProto$Text.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/firebase/inappmessaging/MessagesProto$Text.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/firebase/inappmessaging/MessagesProto$Text
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/firebase/inappmessaging/MessagesProto$Text
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/firebase/inappmessaging/MessagesProto$Text.PARSER : Lcom/google/protobuf/Parser;
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
      //   173: putfield hexColor_ : Ljava/lang/String;
      //   176: goto -> 123
      //   179: aload_0
      //   180: aload_1
      //   181: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   184: putfield text_ : Ljava/lang/String;
      //   187: goto -> 123
      //   190: iconst_1
      //   191: istore #4
      //   193: goto -> 123
      //   196: astore_1
      //   197: goto -> 244
      //   200: astore_3
      //   201: new java/lang/RuntimeException
      //   204: astore_1
      //   205: new com/google/protobuf/InvalidProtocolBufferException
      //   208: astore_2
      //   209: aload_2
      //   210: aload_3
      //   211: invokevirtual getMessage : ()Ljava/lang/String;
      //   214: invokespecial <init> : (Ljava/lang/String;)V
      //   217: aload_1
      //   218: aload_2
      //   219: aload_0
      //   220: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   223: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   226: aload_1
      //   227: athrow
      //   228: astore_1
      //   229: new java/lang/RuntimeException
      //   232: astore_2
      //   233: aload_2
      //   234: aload_1
      //   235: aload_0
      //   236: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   239: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   242: aload_2
      //   243: athrow
      //   244: aload_1
      //   245: athrow
      //   246: getstatic com/google/firebase/inappmessaging/MessagesProto$Text.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   249: areturn
      //   250: aload_2
      //   251: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   254: astore_1
      //   255: aload_3
      //   256: checkcast com/google/firebase/inappmessaging/MessagesProto$Text
      //   259: astore_2
      //   260: aload_0
      //   261: aload_1
      //   262: aload_0
      //   263: getfield text_ : Ljava/lang/String;
      //   266: invokevirtual isEmpty : ()Z
      //   269: iconst_1
      //   270: ixor
      //   271: aload_0
      //   272: getfield text_ : Ljava/lang/String;
      //   275: aload_2
      //   276: getfield text_ : Ljava/lang/String;
      //   279: invokevirtual isEmpty : ()Z
      //   282: iconst_1
      //   283: ixor
      //   284: aload_2
      //   285: getfield text_ : Ljava/lang/String;
      //   288: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   293: putfield text_ : Ljava/lang/String;
      //   296: aload_0
      //   297: aload_1
      //   298: aload_0
      //   299: getfield hexColor_ : Ljava/lang/String;
      //   302: invokevirtual isEmpty : ()Z
      //   305: iconst_1
      //   306: ixor
      //   307: aload_0
      //   308: getfield hexColor_ : Ljava/lang/String;
      //   311: iconst_1
      //   312: aload_2
      //   313: getfield hexColor_ : Ljava/lang/String;
      //   316: invokevirtual isEmpty : ()Z
      //   319: ixor
      //   320: aload_2
      //   321: getfield hexColor_ : Ljava/lang/String;
      //   324: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   329: putfield hexColor_ : Ljava/lang/String;
      //   332: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   335: astore_1
      //   336: aload_0
      //   337: areturn
      //   338: new com/google/firebase/inappmessaging/MessagesProto$Text$Builder
      //   341: dup
      //   342: aconst_null
      //   343: invokespecial <init> : (Lcom/google/firebase/inappmessaging/MessagesProto$1;)V
      //   346: areturn
      //   347: aconst_null
      //   348: areturn
      //   349: getstatic com/google/firebase/inappmessaging/MessagesProto$Text.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/MessagesProto$Text;
      //   352: areturn
      //   353: new com/google/firebase/inappmessaging/MessagesProto$Text
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
    
    public String getHexColor() {
      return this.hexColor_;
    }
    
    public ByteString getHexColorBytes() {
      return ByteString.copyFromUtf8(this.hexColor_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (!this.text_.isEmpty())
        i = 0 + CodedOutputStream.computeStringSize(1, getText()); 
      int j = i;
      if (!this.hexColor_.isEmpty())
        j = i + CodedOutputStream.computeStringSize(2, getHexColor()); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public String getText() {
      return this.text_;
    }
    
    public ByteString getTextBytes() {
      return ByteString.copyFromUtf8(this.text_);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.text_.isEmpty())
        param1CodedOutputStream.writeString(1, getText()); 
      if (!this.hexColor_.isEmpty())
        param1CodedOutputStream.writeString(2, getHexColor()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Text, Builder> implements MessagesProto.TextOrBuilder {
      private Builder() {
        super(MessagesProto.Text.DEFAULT_INSTANCE);
      }
      
      public Builder clearHexColor() {
        copyOnWrite();
        ((MessagesProto.Text)this.instance).clearHexColor();
        return this;
      }
      
      public Builder clearText() {
        copyOnWrite();
        ((MessagesProto.Text)this.instance).clearText();
        return this;
      }
      
      public String getHexColor() {
        return ((MessagesProto.Text)this.instance).getHexColor();
      }
      
      public ByteString getHexColorBytes() {
        return ((MessagesProto.Text)this.instance).getHexColorBytes();
      }
      
      public String getText() {
        return ((MessagesProto.Text)this.instance).getText();
      }
      
      public ByteString getTextBytes() {
        return ((MessagesProto.Text)this.instance).getTextBytes();
      }
      
      public Builder setHexColor(String param2String) {
        copyOnWrite();
        ((MessagesProto.Text)this.instance).setHexColor(param2String);
        return this;
      }
      
      public Builder setHexColorBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((MessagesProto.Text)this.instance).setHexColorBytes(param2ByteString);
        return this;
      }
      
      public Builder setText(String param2String) {
        copyOnWrite();
        ((MessagesProto.Text)this.instance).setText(param2String);
        return this;
      }
      
      public Builder setTextBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((MessagesProto.Text)this.instance).setTextBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Text, Text.Builder> implements TextOrBuilder {
    private Builder() {
      super(MessagesProto.Text.DEFAULT_INSTANCE);
    }
    
    public Builder clearHexColor() {
      copyOnWrite();
      ((MessagesProto.Text)this.instance).clearHexColor();
      return this;
    }
    
    public Builder clearText() {
      copyOnWrite();
      ((MessagesProto.Text)this.instance).clearText();
      return this;
    }
    
    public String getHexColor() {
      return ((MessagesProto.Text)this.instance).getHexColor();
    }
    
    public ByteString getHexColorBytes() {
      return ((MessagesProto.Text)this.instance).getHexColorBytes();
    }
    
    public String getText() {
      return ((MessagesProto.Text)this.instance).getText();
    }
    
    public ByteString getTextBytes() {
      return ((MessagesProto.Text)this.instance).getTextBytes();
    }
    
    public Builder setHexColor(String param1String) {
      copyOnWrite();
      ((MessagesProto.Text)this.instance).setHexColor(param1String);
      return this;
    }
    
    public Builder setHexColorBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((MessagesProto.Text)this.instance).setHexColorBytes(param1ByteString);
      return this;
    }
    
    public Builder setText(String param1String) {
      copyOnWrite();
      ((MessagesProto.Text)this.instance).setText(param1String);
      return this;
    }
    
    public Builder setTextBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((MessagesProto.Text)this.instance).setTextBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface TextOrBuilder extends MessageLiteOrBuilder {
    String getHexColor();
    
    ByteString getHexColorBytes();
    
    String getText();
    
    ByteString getTextBytes();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\MessagesProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */