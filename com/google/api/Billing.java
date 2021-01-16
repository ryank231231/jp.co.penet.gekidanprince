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

public final class Billing extends GeneratedMessageLite<Billing, Billing.Builder> implements BillingOrBuilder {
  public static final int CONSUMER_DESTINATIONS_FIELD_NUMBER = 8;
  
  private static final Billing DEFAULT_INSTANCE = new Billing();
  
  private static volatile Parser<Billing> PARSER;
  
  private Internal.ProtobufList<BillingDestination> consumerDestinations_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllConsumerDestinations(Iterable<? extends BillingDestination> paramIterable) {
    ensureConsumerDestinationsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.consumerDestinations_);
  }
  
  private void addConsumerDestinations(int paramInt, BillingDestination.Builder paramBuilder) {
    ensureConsumerDestinationsIsMutable();
    this.consumerDestinations_.add(paramInt, paramBuilder.build());
  }
  
  private void addConsumerDestinations(int paramInt, BillingDestination paramBillingDestination) {
    if (paramBillingDestination != null) {
      ensureConsumerDestinationsIsMutable();
      this.consumerDestinations_.add(paramInt, paramBillingDestination);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addConsumerDestinations(BillingDestination.Builder paramBuilder) {
    ensureConsumerDestinationsIsMutable();
    this.consumerDestinations_.add(paramBuilder.build());
  }
  
  private void addConsumerDestinations(BillingDestination paramBillingDestination) {
    if (paramBillingDestination != null) {
      ensureConsumerDestinationsIsMutable();
      this.consumerDestinations_.add(paramBillingDestination);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearConsumerDestinations() {
    this.consumerDestinations_ = emptyProtobufList();
  }
  
  private void ensureConsumerDestinationsIsMutable() {
    if (!this.consumerDestinations_.isModifiable())
      this.consumerDestinations_ = GeneratedMessageLite.mutableCopy(this.consumerDestinations_); 
  }
  
  public static Billing getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Billing paramBilling) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramBilling);
  }
  
  public static Billing parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Billing)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Billing parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Billing)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Billing parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Billing)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Billing parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Billing)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Billing parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Billing)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Billing parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Billing)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Billing parseFrom(InputStream paramInputStream) throws IOException {
    return (Billing)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Billing parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Billing)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Billing parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Billing)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Billing parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Billing)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Billing> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeConsumerDestinations(int paramInt) {
    ensureConsumerDestinationsIsMutable();
    this.consumerDestinations_.remove(paramInt);
  }
  
  private void setConsumerDestinations(int paramInt, BillingDestination.Builder paramBuilder) {
    ensureConsumerDestinationsIsMutable();
    this.consumerDestinations_.set(paramInt, paramBuilder.build());
  }
  
  private void setConsumerDestinations(int paramInt, BillingDestination paramBillingDestination) {
    if (paramBillingDestination != null) {
      ensureConsumerDestinationsIsMutable();
      this.consumerDestinations_.set(paramInt, paramBillingDestination);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/Billing$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 326, 2 -> 322, 3 -> 311, 4 -> 302, 5 -> 268, 6 -> 110, 7 -> 264, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/api/Billing.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/api/Billing
    //   72: monitorenter
    //   73: getstatic com/google/api/Billing.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/api/Billing.DEFAULT_INSTANCE : Lcom/google/api/Billing;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/api/Billing.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/api/Billing
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/api/Billing
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/api/Billing.PARSER : Lcom/google/protobuf/Parser;
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
    //   141: bipush #66
    //   143: if_icmpeq -> 161
    //   146: aload_1
    //   147: iload #5
    //   149: invokevirtual skipField : (I)Z
    //   152: ifne -> 123
    //   155: iconst_1
    //   156: istore #4
    //   158: goto -> 123
    //   161: aload_0
    //   162: getfield consumerDestinations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   165: invokeinterface isModifiable : ()Z
    //   170: ifne -> 184
    //   173: aload_0
    //   174: aload_0
    //   175: getfield consumerDestinations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   178: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   181: putfield consumerDestinations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   184: aload_0
    //   185: getfield consumerDestinations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   188: aload_1
    //   189: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   192: aload_2
    //   193: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   196: checkcast com/google/api/Billing$BillingDestination
    //   199: invokeinterface add : (Ljava/lang/Object;)Z
    //   204: pop
    //   205: goto -> 123
    //   208: iconst_1
    //   209: istore #4
    //   211: goto -> 123
    //   214: astore_1
    //   215: goto -> 262
    //   218: astore_3
    //   219: new java/lang/RuntimeException
    //   222: astore_2
    //   223: new com/google/protobuf/InvalidProtocolBufferException
    //   226: astore_1
    //   227: aload_1
    //   228: aload_3
    //   229: invokevirtual getMessage : ()Ljava/lang/String;
    //   232: invokespecial <init> : (Ljava/lang/String;)V
    //   235: aload_2
    //   236: aload_1
    //   237: aload_0
    //   238: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   241: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   244: aload_2
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
    //   264: getstatic com/google/api/Billing.DEFAULT_INSTANCE : Lcom/google/api/Billing;
    //   267: areturn
    //   268: aload_2
    //   269: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   272: astore_1
    //   273: aload_3
    //   274: checkcast com/google/api/Billing
    //   277: astore_2
    //   278: aload_0
    //   279: aload_1
    //   280: aload_0
    //   281: getfield consumerDestinations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   284: aload_2
    //   285: getfield consumerDestinations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   288: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   293: putfield consumerDestinations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   296: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   299: astore_1
    //   300: aload_0
    //   301: areturn
    //   302: new com/google/api/Billing$Builder
    //   305: dup
    //   306: aconst_null
    //   307: invokespecial <init> : (Lcom/google/api/Billing$1;)V
    //   310: areturn
    //   311: aload_0
    //   312: getfield consumerDestinations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   315: invokeinterface makeImmutable : ()V
    //   320: aconst_null
    //   321: areturn
    //   322: getstatic com/google/api/Billing.DEFAULT_INSTANCE : Lcom/google/api/Billing;
    //   325: areturn
    //   326: new com/google/api/Billing
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
  
  public BillingDestination getConsumerDestinations(int paramInt) {
    return (BillingDestination)this.consumerDestinations_.get(paramInt);
  }
  
  public int getConsumerDestinationsCount() {
    return this.consumerDestinations_.size();
  }
  
  public List<BillingDestination> getConsumerDestinationsList() {
    return (List<BillingDestination>)this.consumerDestinations_;
  }
  
  public BillingDestinationOrBuilder getConsumerDestinationsOrBuilder(int paramInt) {
    return (BillingDestinationOrBuilder)this.consumerDestinations_.get(paramInt);
  }
  
  public List<? extends BillingDestinationOrBuilder> getConsumerDestinationsOrBuilderList() {
    return (List)this.consumerDestinations_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    byte b = 0;
    i = 0;
    while (b < this.consumerDestinations_.size()) {
      i += CodedOutputStream.computeMessageSize(8, (MessageLite)this.consumerDestinations_.get(b));
      b++;
    } 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (byte b = 0; b < this.consumerDestinations_.size(); b++)
      paramCodedOutputStream.writeMessage(8, (MessageLite)this.consumerDestinations_.get(b)); 
  }
  
  public static final class BillingDestination extends GeneratedMessageLite<BillingDestination, BillingDestination.Builder> implements BillingDestinationOrBuilder {
    private static final BillingDestination DEFAULT_INSTANCE = new BillingDestination();
    
    public static final int METRICS_FIELD_NUMBER = 2;
    
    public static final int MONITORED_RESOURCE_FIELD_NUMBER = 1;
    
    private static volatile Parser<BillingDestination> PARSER;
    
    private int bitField0_;
    
    private Internal.ProtobufList<String> metrics_ = GeneratedMessageLite.emptyProtobufList();
    
    private String monitoredResource_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllMetrics(Iterable<String> param1Iterable) {
      ensureMetricsIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.metrics_);
    }
    
    private void addMetrics(String param1String) {
      if (param1String != null) {
        ensureMetricsIsMutable();
        this.metrics_.add(param1String);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addMetricsBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        ensureMetricsIsMutable();
        this.metrics_.add(param1ByteString.toStringUtf8());
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearMetrics() {
      this.metrics_ = GeneratedMessageLite.emptyProtobufList();
    }
    
    private void clearMonitoredResource() {
      this.monitoredResource_ = getDefaultInstance().getMonitoredResource();
    }
    
    private void ensureMetricsIsMutable() {
      if (!this.metrics_.isModifiable())
        this.metrics_ = GeneratedMessageLite.mutableCopy(this.metrics_); 
    }
    
    public static BillingDestination getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(BillingDestination param1BillingDestination) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1BillingDestination);
    }
    
    public static BillingDestination parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (BillingDestination)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static BillingDestination parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (BillingDestination)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static BillingDestination parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (BillingDestination)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static BillingDestination parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (BillingDestination)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static BillingDestination parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (BillingDestination)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static BillingDestination parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (BillingDestination)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static BillingDestination parseFrom(InputStream param1InputStream) throws IOException {
      return (BillingDestination)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static BillingDestination parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (BillingDestination)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static BillingDestination parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (BillingDestination)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static BillingDestination parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (BillingDestination)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<BillingDestination> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setMetrics(int param1Int, String param1String) {
      if (param1String != null) {
        ensureMetricsIsMutable();
        this.metrics_.set(param1Int, param1String);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setMonitoredResource(String param1String) {
      if (param1String != null) {
        this.monitoredResource_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setMonitoredResourceBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.monitoredResource_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/api/Billing$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 391, 2 -> 387, 3 -> 376, 4 -> 367, 5 -> 281, 6 -> 110, 7 -> 277, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/api/Billing$BillingDestination.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/api/Billing$BillingDestination
      //   72: monitorenter
      //   73: getstatic com/google/api/Billing$BillingDestination.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/api/Billing$BillingDestination.DEFAULT_INSTANCE : Lcom/google/api/Billing$BillingDestination;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/api/Billing$BillingDestination.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/api/Billing$BillingDestination
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/api/Billing$BillingDestination
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/api/Billing$BillingDestination.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 277
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 221
      //   139: iload #5
      //   141: bipush #10
      //   143: if_icmpeq -> 210
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
      //   168: aload_1
      //   169: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   172: astore_2
      //   173: aload_0
      //   174: getfield metrics_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   177: invokeinterface isModifiable : ()Z
      //   182: ifne -> 196
      //   185: aload_0
      //   186: aload_0
      //   187: getfield metrics_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   190: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   193: putfield metrics_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   196: aload_0
      //   197: getfield metrics_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   200: aload_2
      //   201: invokeinterface add : (Ljava/lang/Object;)Z
      //   206: pop
      //   207: goto -> 123
      //   210: aload_0
      //   211: aload_1
      //   212: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   215: putfield monitoredResource_ : Ljava/lang/String;
      //   218: goto -> 123
      //   221: iconst_1
      //   222: istore #4
      //   224: goto -> 123
      //   227: astore_1
      //   228: goto -> 275
      //   231: astore_2
      //   232: new java/lang/RuntimeException
      //   235: astore_1
      //   236: new com/google/protobuf/InvalidProtocolBufferException
      //   239: astore_3
      //   240: aload_3
      //   241: aload_2
      //   242: invokevirtual getMessage : ()Ljava/lang/String;
      //   245: invokespecial <init> : (Ljava/lang/String;)V
      //   248: aload_1
      //   249: aload_3
      //   250: aload_0
      //   251: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   254: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   257: aload_1
      //   258: athrow
      //   259: astore_1
      //   260: new java/lang/RuntimeException
      //   263: astore_2
      //   264: aload_2
      //   265: aload_1
      //   266: aload_0
      //   267: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   270: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   273: aload_2
      //   274: athrow
      //   275: aload_1
      //   276: athrow
      //   277: getstatic com/google/api/Billing$BillingDestination.DEFAULT_INSTANCE : Lcom/google/api/Billing$BillingDestination;
      //   280: areturn
      //   281: aload_2
      //   282: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   285: astore_1
      //   286: aload_3
      //   287: checkcast com/google/api/Billing$BillingDestination
      //   290: astore_2
      //   291: aload_0
      //   292: aload_1
      //   293: aload_0
      //   294: getfield monitoredResource_ : Ljava/lang/String;
      //   297: invokevirtual isEmpty : ()Z
      //   300: iconst_1
      //   301: ixor
      //   302: aload_0
      //   303: getfield monitoredResource_ : Ljava/lang/String;
      //   306: iconst_1
      //   307: aload_2
      //   308: getfield monitoredResource_ : Ljava/lang/String;
      //   311: invokevirtual isEmpty : ()Z
      //   314: ixor
      //   315: aload_2
      //   316: getfield monitoredResource_ : Ljava/lang/String;
      //   319: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   324: putfield monitoredResource_ : Ljava/lang/String;
      //   327: aload_0
      //   328: aload_1
      //   329: aload_0
      //   330: getfield metrics_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   333: aload_2
      //   334: getfield metrics_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   337: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   342: putfield metrics_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   345: aload_1
      //   346: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   349: if_acmpne -> 365
      //   352: aload_0
      //   353: aload_0
      //   354: getfield bitField0_ : I
      //   357: aload_2
      //   358: getfield bitField0_ : I
      //   361: ior
      //   362: putfield bitField0_ : I
      //   365: aload_0
      //   366: areturn
      //   367: new com/google/api/Billing$BillingDestination$Builder
      //   370: dup
      //   371: aconst_null
      //   372: invokespecial <init> : (Lcom/google/api/Billing$1;)V
      //   375: areturn
      //   376: aload_0
      //   377: getfield metrics_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   380: invokeinterface makeImmutable : ()V
      //   385: aconst_null
      //   386: areturn
      //   387: getstatic com/google/api/Billing$BillingDestination.DEFAULT_INSTANCE : Lcom/google/api/Billing$BillingDestination;
      //   390: areturn
      //   391: new com/google/api/Billing$BillingDestination
      //   394: dup
      //   395: invokespecial <init> : ()V
      //   398: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	259	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	231	java/io/IOException
      //   128	134	227	finally
      //   153	162	259	com/google/protobuf/InvalidProtocolBufferException
      //   153	162	231	java/io/IOException
      //   153	162	227	finally
      //   168	196	259	com/google/protobuf/InvalidProtocolBufferException
      //   168	196	231	java/io/IOException
      //   168	196	227	finally
      //   196	207	259	com/google/protobuf/InvalidProtocolBufferException
      //   196	207	231	java/io/IOException
      //   196	207	227	finally
      //   210	218	259	com/google/protobuf/InvalidProtocolBufferException
      //   210	218	231	java/io/IOException
      //   210	218	227	finally
      //   232	259	227	finally
      //   260	275	227	finally
    }
    
    public String getMetrics(int param1Int) {
      return (String)this.metrics_.get(param1Int);
    }
    
    public ByteString getMetricsBytes(int param1Int) {
      return ByteString.copyFromUtf8((String)this.metrics_.get(param1Int));
    }
    
    public int getMetricsCount() {
      return this.metrics_.size();
    }
    
    public List<String> getMetricsList() {
      return (List<String>)this.metrics_;
    }
    
    public String getMonitoredResource() {
      return this.monitoredResource_;
    }
    
    public ByteString getMonitoredResourceBytes() {
      return ByteString.copyFromUtf8(this.monitoredResource_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      boolean bool = this.monitoredResource_.isEmpty();
      byte b = 0;
      if (!bool) {
        i = CodedOutputStream.computeStringSize(1, getMonitoredResource()) + 0;
      } else {
        i = 0;
      } 
      int j = 0;
      while (b < this.metrics_.size()) {
        j += CodedOutputStream.computeStringSizeNoTag((String)this.metrics_.get(b));
        b++;
      } 
      i = i + j + getMetricsList().size() * 1;
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.monitoredResource_.isEmpty())
        param1CodedOutputStream.writeString(1, getMonitoredResource()); 
      for (byte b = 0; b < this.metrics_.size(); b++)
        param1CodedOutputStream.writeString(2, (String)this.metrics_.get(b)); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<BillingDestination, Builder> implements Billing.BillingDestinationOrBuilder {
      private Builder() {
        super(Billing.BillingDestination.DEFAULT_INSTANCE);
      }
      
      public Builder addAllMetrics(Iterable<String> param2Iterable) {
        copyOnWrite();
        ((Billing.BillingDestination)this.instance).addAllMetrics(param2Iterable);
        return this;
      }
      
      public Builder addMetrics(String param2String) {
        copyOnWrite();
        ((Billing.BillingDestination)this.instance).addMetrics(param2String);
        return this;
      }
      
      public Builder addMetricsBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((Billing.BillingDestination)this.instance).addMetricsBytes(param2ByteString);
        return this;
      }
      
      public Builder clearMetrics() {
        copyOnWrite();
        ((Billing.BillingDestination)this.instance).clearMetrics();
        return this;
      }
      
      public Builder clearMonitoredResource() {
        copyOnWrite();
        ((Billing.BillingDestination)this.instance).clearMonitoredResource();
        return this;
      }
      
      public String getMetrics(int param2Int) {
        return ((Billing.BillingDestination)this.instance).getMetrics(param2Int);
      }
      
      public ByteString getMetricsBytes(int param2Int) {
        return ((Billing.BillingDestination)this.instance).getMetricsBytes(param2Int);
      }
      
      public int getMetricsCount() {
        return ((Billing.BillingDestination)this.instance).getMetricsCount();
      }
      
      public List<String> getMetricsList() {
        return Collections.unmodifiableList(((Billing.BillingDestination)this.instance).getMetricsList());
      }
      
      public String getMonitoredResource() {
        return ((Billing.BillingDestination)this.instance).getMonitoredResource();
      }
      
      public ByteString getMonitoredResourceBytes() {
        return ((Billing.BillingDestination)this.instance).getMonitoredResourceBytes();
      }
      
      public Builder setMetrics(int param2Int, String param2String) {
        copyOnWrite();
        ((Billing.BillingDestination)this.instance).setMetrics(param2Int, param2String);
        return this;
      }
      
      public Builder setMonitoredResource(String param2String) {
        copyOnWrite();
        ((Billing.BillingDestination)this.instance).setMonitoredResource(param2String);
        return this;
      }
      
      public Builder setMonitoredResourceBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((Billing.BillingDestination)this.instance).setMonitoredResourceBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<BillingDestination, BillingDestination.Builder> implements BillingDestinationOrBuilder {
    private Builder() {
      super(Billing.BillingDestination.DEFAULT_INSTANCE);
    }
    
    public Builder addAllMetrics(Iterable<String> param1Iterable) {
      copyOnWrite();
      ((Billing.BillingDestination)this.instance).addAllMetrics(param1Iterable);
      return this;
    }
    
    public Builder addMetrics(String param1String) {
      copyOnWrite();
      ((Billing.BillingDestination)this.instance).addMetrics(param1String);
      return this;
    }
    
    public Builder addMetricsBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Billing.BillingDestination)this.instance).addMetricsBytes(param1ByteString);
      return this;
    }
    
    public Builder clearMetrics() {
      copyOnWrite();
      ((Billing.BillingDestination)this.instance).clearMetrics();
      return this;
    }
    
    public Builder clearMonitoredResource() {
      copyOnWrite();
      ((Billing.BillingDestination)this.instance).clearMonitoredResource();
      return this;
    }
    
    public String getMetrics(int param1Int) {
      return ((Billing.BillingDestination)this.instance).getMetrics(param1Int);
    }
    
    public ByteString getMetricsBytes(int param1Int) {
      return ((Billing.BillingDestination)this.instance).getMetricsBytes(param1Int);
    }
    
    public int getMetricsCount() {
      return ((Billing.BillingDestination)this.instance).getMetricsCount();
    }
    
    public List<String> getMetricsList() {
      return Collections.unmodifiableList(((Billing.BillingDestination)this.instance).getMetricsList());
    }
    
    public String getMonitoredResource() {
      return ((Billing.BillingDestination)this.instance).getMonitoredResource();
    }
    
    public ByteString getMonitoredResourceBytes() {
      return ((Billing.BillingDestination)this.instance).getMonitoredResourceBytes();
    }
    
    public Builder setMetrics(int param1Int, String param1String) {
      copyOnWrite();
      ((Billing.BillingDestination)this.instance).setMetrics(param1Int, param1String);
      return this;
    }
    
    public Builder setMonitoredResource(String param1String) {
      copyOnWrite();
      ((Billing.BillingDestination)this.instance).setMonitoredResource(param1String);
      return this;
    }
    
    public Builder setMonitoredResourceBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Billing.BillingDestination)this.instance).setMonitoredResourceBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface BillingDestinationOrBuilder extends MessageLiteOrBuilder {
    String getMetrics(int param1Int);
    
    ByteString getMetricsBytes(int param1Int);
    
    int getMetricsCount();
    
    List<String> getMetricsList();
    
    String getMonitoredResource();
    
    ByteString getMonitoredResourceBytes();
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Billing, Builder> implements BillingOrBuilder {
    private Builder() {
      super(Billing.DEFAULT_INSTANCE);
    }
    
    public Builder addAllConsumerDestinations(Iterable<? extends Billing.BillingDestination> param1Iterable) {
      copyOnWrite();
      ((Billing)this.instance).addAllConsumerDestinations(param1Iterable);
      return this;
    }
    
    public Builder addConsumerDestinations(int param1Int, Billing.BillingDestination.Builder param1Builder) {
      copyOnWrite();
      ((Billing)this.instance).addConsumerDestinations(param1Int, param1Builder);
      return this;
    }
    
    public Builder addConsumerDestinations(int param1Int, Billing.BillingDestination param1BillingDestination) {
      copyOnWrite();
      ((Billing)this.instance).addConsumerDestinations(param1Int, param1BillingDestination);
      return this;
    }
    
    public Builder addConsumerDestinations(Billing.BillingDestination.Builder param1Builder) {
      copyOnWrite();
      ((Billing)this.instance).addConsumerDestinations(param1Builder);
      return this;
    }
    
    public Builder addConsumerDestinations(Billing.BillingDestination param1BillingDestination) {
      copyOnWrite();
      ((Billing)this.instance).addConsumerDestinations(param1BillingDestination);
      return this;
    }
    
    public Builder clearConsumerDestinations() {
      copyOnWrite();
      ((Billing)this.instance).clearConsumerDestinations();
      return this;
    }
    
    public Billing.BillingDestination getConsumerDestinations(int param1Int) {
      return ((Billing)this.instance).getConsumerDestinations(param1Int);
    }
    
    public int getConsumerDestinationsCount() {
      return ((Billing)this.instance).getConsumerDestinationsCount();
    }
    
    public List<Billing.BillingDestination> getConsumerDestinationsList() {
      return Collections.unmodifiableList(((Billing)this.instance).getConsumerDestinationsList());
    }
    
    public Builder removeConsumerDestinations(int param1Int) {
      copyOnWrite();
      ((Billing)this.instance).removeConsumerDestinations(param1Int);
      return this;
    }
    
    public Builder setConsumerDestinations(int param1Int, Billing.BillingDestination.Builder param1Builder) {
      copyOnWrite();
      ((Billing)this.instance).setConsumerDestinations(param1Int, param1Builder);
      return this;
    }
    
    public Builder setConsumerDestinations(int param1Int, Billing.BillingDestination param1BillingDestination) {
      copyOnWrite();
      ((Billing)this.instance).setConsumerDestinations(param1Int, param1BillingDestination);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\Billing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */