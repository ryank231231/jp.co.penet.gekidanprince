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

public final class Monitoring extends GeneratedMessageLite<Monitoring, Monitoring.Builder> implements MonitoringOrBuilder {
  public static final int CONSUMER_DESTINATIONS_FIELD_NUMBER = 2;
  
  private static final Monitoring DEFAULT_INSTANCE = new Monitoring();
  
  private static volatile Parser<Monitoring> PARSER;
  
  public static final int PRODUCER_DESTINATIONS_FIELD_NUMBER = 1;
  
  private Internal.ProtobufList<MonitoringDestination> consumerDestinations_ = emptyProtobufList();
  
  private Internal.ProtobufList<MonitoringDestination> producerDestinations_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllConsumerDestinations(Iterable<? extends MonitoringDestination> paramIterable) {
    ensureConsumerDestinationsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.consumerDestinations_);
  }
  
  private void addAllProducerDestinations(Iterable<? extends MonitoringDestination> paramIterable) {
    ensureProducerDestinationsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.producerDestinations_);
  }
  
  private void addConsumerDestinations(int paramInt, MonitoringDestination.Builder paramBuilder) {
    ensureConsumerDestinationsIsMutable();
    this.consumerDestinations_.add(paramInt, paramBuilder.build());
  }
  
  private void addConsumerDestinations(int paramInt, MonitoringDestination paramMonitoringDestination) {
    if (paramMonitoringDestination != null) {
      ensureConsumerDestinationsIsMutable();
      this.consumerDestinations_.add(paramInt, paramMonitoringDestination);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addConsumerDestinations(MonitoringDestination.Builder paramBuilder) {
    ensureConsumerDestinationsIsMutable();
    this.consumerDestinations_.add(paramBuilder.build());
  }
  
  private void addConsumerDestinations(MonitoringDestination paramMonitoringDestination) {
    if (paramMonitoringDestination != null) {
      ensureConsumerDestinationsIsMutable();
      this.consumerDestinations_.add(paramMonitoringDestination);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addProducerDestinations(int paramInt, MonitoringDestination.Builder paramBuilder) {
    ensureProducerDestinationsIsMutable();
    this.producerDestinations_.add(paramInt, paramBuilder.build());
  }
  
  private void addProducerDestinations(int paramInt, MonitoringDestination paramMonitoringDestination) {
    if (paramMonitoringDestination != null) {
      ensureProducerDestinationsIsMutable();
      this.producerDestinations_.add(paramInt, paramMonitoringDestination);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addProducerDestinations(MonitoringDestination.Builder paramBuilder) {
    ensureProducerDestinationsIsMutable();
    this.producerDestinations_.add(paramBuilder.build());
  }
  
  private void addProducerDestinations(MonitoringDestination paramMonitoringDestination) {
    if (paramMonitoringDestination != null) {
      ensureProducerDestinationsIsMutable();
      this.producerDestinations_.add(paramMonitoringDestination);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearConsumerDestinations() {
    this.consumerDestinations_ = emptyProtobufList();
  }
  
  private void clearProducerDestinations() {
    this.producerDestinations_ = emptyProtobufList();
  }
  
  private void ensureConsumerDestinationsIsMutable() {
    if (!this.consumerDestinations_.isModifiable())
      this.consumerDestinations_ = GeneratedMessageLite.mutableCopy(this.consumerDestinations_); 
  }
  
  private void ensureProducerDestinationsIsMutable() {
    if (!this.producerDestinations_.isModifiable())
      this.producerDestinations_ = GeneratedMessageLite.mutableCopy(this.producerDestinations_); 
  }
  
  public static Monitoring getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Monitoring paramMonitoring) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramMonitoring);
  }
  
  public static Monitoring parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Monitoring)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Monitoring parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Monitoring)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Monitoring parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Monitoring)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Monitoring parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Monitoring)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Monitoring parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Monitoring)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Monitoring parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Monitoring)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Monitoring parseFrom(InputStream paramInputStream) throws IOException {
    return (Monitoring)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Monitoring parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Monitoring)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Monitoring parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Monitoring)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Monitoring parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Monitoring)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Monitoring> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeConsumerDestinations(int paramInt) {
    ensureConsumerDestinationsIsMutable();
    this.consumerDestinations_.remove(paramInt);
  }
  
  private void removeProducerDestinations(int paramInt) {
    ensureProducerDestinationsIsMutable();
    this.producerDestinations_.remove(paramInt);
  }
  
  private void setConsumerDestinations(int paramInt, MonitoringDestination.Builder paramBuilder) {
    ensureConsumerDestinationsIsMutable();
    this.consumerDestinations_.set(paramInt, paramBuilder.build());
  }
  
  private void setConsumerDestinations(int paramInt, MonitoringDestination paramMonitoringDestination) {
    if (paramMonitoringDestination != null) {
      ensureConsumerDestinationsIsMutable();
      this.consumerDestinations_.set(paramInt, paramMonitoringDestination);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setProducerDestinations(int paramInt, MonitoringDestination.Builder paramBuilder) {
    ensureProducerDestinationsIsMutable();
    this.producerDestinations_.set(paramInt, paramBuilder.build());
  }
  
  private void setProducerDestinations(int paramInt, MonitoringDestination paramMonitoringDestination) {
    if (paramMonitoringDestination != null) {
      ensureProducerDestinationsIsMutable();
      this.producerDestinations_.set(paramInt, paramMonitoringDestination);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/Monitoring$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 407, 2 -> 403, 3 -> 383, 4 -> 374, 5 -> 322, 6 -> 110, 7 -> 318, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/api/Monitoring.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/api/Monitoring
    //   72: monitorenter
    //   73: getstatic com/google/api/Monitoring.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/api/Monitoring.DEFAULT_INSTANCE : Lcom/google/api/Monitoring;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/api/Monitoring.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/api/Monitoring
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/api/Monitoring
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/api/Monitoring.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 318
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 262
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
    //   169: getfield consumerDestinations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   172: invokeinterface isModifiable : ()Z
    //   177: ifne -> 191
    //   180: aload_0
    //   181: aload_0
    //   182: getfield consumerDestinations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   185: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   188: putfield consumerDestinations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   191: aload_0
    //   192: getfield consumerDestinations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   195: aload_1
    //   196: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   199: aload_2
    //   200: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   203: checkcast com/google/api/Monitoring$MonitoringDestination
    //   206: invokeinterface add : (Ljava/lang/Object;)Z
    //   211: pop
    //   212: goto -> 123
    //   215: aload_0
    //   216: getfield producerDestinations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   219: invokeinterface isModifiable : ()Z
    //   224: ifne -> 238
    //   227: aload_0
    //   228: aload_0
    //   229: getfield producerDestinations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   232: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   235: putfield producerDestinations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   238: aload_0
    //   239: getfield producerDestinations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   242: aload_1
    //   243: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   246: aload_2
    //   247: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   250: checkcast com/google/api/Monitoring$MonitoringDestination
    //   253: invokeinterface add : (Ljava/lang/Object;)Z
    //   258: pop
    //   259: goto -> 123
    //   262: iconst_1
    //   263: istore #4
    //   265: goto -> 123
    //   268: astore_1
    //   269: goto -> 316
    //   272: astore_1
    //   273: new java/lang/RuntimeException
    //   276: astore_3
    //   277: new com/google/protobuf/InvalidProtocolBufferException
    //   280: astore_2
    //   281: aload_2
    //   282: aload_1
    //   283: invokevirtual getMessage : ()Ljava/lang/String;
    //   286: invokespecial <init> : (Ljava/lang/String;)V
    //   289: aload_3
    //   290: aload_2
    //   291: aload_0
    //   292: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   295: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   298: aload_3
    //   299: athrow
    //   300: astore_1
    //   301: new java/lang/RuntimeException
    //   304: astore_2
    //   305: aload_2
    //   306: aload_1
    //   307: aload_0
    //   308: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   311: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   314: aload_2
    //   315: athrow
    //   316: aload_1
    //   317: athrow
    //   318: getstatic com/google/api/Monitoring.DEFAULT_INSTANCE : Lcom/google/api/Monitoring;
    //   321: areturn
    //   322: aload_2
    //   323: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   326: astore_1
    //   327: aload_3
    //   328: checkcast com/google/api/Monitoring
    //   331: astore_2
    //   332: aload_0
    //   333: aload_1
    //   334: aload_0
    //   335: getfield producerDestinations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   338: aload_2
    //   339: getfield producerDestinations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   342: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   347: putfield producerDestinations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   350: aload_0
    //   351: aload_1
    //   352: aload_0
    //   353: getfield consumerDestinations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   356: aload_2
    //   357: getfield consumerDestinations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   360: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   365: putfield consumerDestinations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   368: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   371: astore_1
    //   372: aload_0
    //   373: areturn
    //   374: new com/google/api/Monitoring$Builder
    //   377: dup
    //   378: aconst_null
    //   379: invokespecial <init> : (Lcom/google/api/Monitoring$1;)V
    //   382: areturn
    //   383: aload_0
    //   384: getfield producerDestinations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   387: invokeinterface makeImmutable : ()V
    //   392: aload_0
    //   393: getfield consumerDestinations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   396: invokeinterface makeImmutable : ()V
    //   401: aconst_null
    //   402: areturn
    //   403: getstatic com/google/api/Monitoring.DEFAULT_INSTANCE : Lcom/google/api/Monitoring;
    //   406: areturn
    //   407: new com/google/api/Monitoring
    //   410: dup
    //   411: invokespecial <init> : ()V
    //   414: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	300	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	272	java/io/IOException
    //   128	134	268	finally
    //   153	162	300	com/google/protobuf/InvalidProtocolBufferException
    //   153	162	272	java/io/IOException
    //   153	162	268	finally
    //   168	191	300	com/google/protobuf/InvalidProtocolBufferException
    //   168	191	272	java/io/IOException
    //   168	191	268	finally
    //   191	212	300	com/google/protobuf/InvalidProtocolBufferException
    //   191	212	272	java/io/IOException
    //   191	212	268	finally
    //   215	238	300	com/google/protobuf/InvalidProtocolBufferException
    //   215	238	272	java/io/IOException
    //   215	238	268	finally
    //   238	259	300	com/google/protobuf/InvalidProtocolBufferException
    //   238	259	272	java/io/IOException
    //   238	259	268	finally
    //   273	300	268	finally
    //   301	316	268	finally
  }
  
  public MonitoringDestination getConsumerDestinations(int paramInt) {
    return (MonitoringDestination)this.consumerDestinations_.get(paramInt);
  }
  
  public int getConsumerDestinationsCount() {
    return this.consumerDestinations_.size();
  }
  
  public List<MonitoringDestination> getConsumerDestinationsList() {
    return (List<MonitoringDestination>)this.consumerDestinations_;
  }
  
  public MonitoringDestinationOrBuilder getConsumerDestinationsOrBuilder(int paramInt) {
    return (MonitoringDestinationOrBuilder)this.consumerDestinations_.get(paramInt);
  }
  
  public List<? extends MonitoringDestinationOrBuilder> getConsumerDestinationsOrBuilderList() {
    return (List)this.consumerDestinations_;
  }
  
  public MonitoringDestination getProducerDestinations(int paramInt) {
    return (MonitoringDestination)this.producerDestinations_.get(paramInt);
  }
  
  public int getProducerDestinationsCount() {
    return this.producerDestinations_.size();
  }
  
  public List<MonitoringDestination> getProducerDestinationsList() {
    return (List<MonitoringDestination>)this.producerDestinations_;
  }
  
  public MonitoringDestinationOrBuilder getProducerDestinationsOrBuilder(int paramInt) {
    return (MonitoringDestinationOrBuilder)this.producerDestinations_.get(paramInt);
  }
  
  public List<? extends MonitoringDestinationOrBuilder> getProducerDestinationsOrBuilderList() {
    return (List)this.producerDestinations_;
  }
  
  public int getSerializedSize() {
    byte b3;
    int j;
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    byte b1 = 0;
    byte b2 = 0;
    i = 0;
    while (true) {
      b3 = b1;
      j = i;
      if (b2 < this.producerDestinations_.size()) {
        i += CodedOutputStream.computeMessageSize(1, (MessageLite)this.producerDestinations_.get(b2));
        b2++;
        continue;
      } 
      break;
    } 
    while (b3 < this.consumerDestinations_.size()) {
      j += CodedOutputStream.computeMessageSize(2, (MessageLite)this.consumerDestinations_.get(b3));
      b3++;
    } 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    byte b3;
    byte b1 = 0;
    byte b2 = 0;
    while (true) {
      b3 = b1;
      if (b2 < this.producerDestinations_.size()) {
        paramCodedOutputStream.writeMessage(1, (MessageLite)this.producerDestinations_.get(b2));
        b2++;
        continue;
      } 
      break;
    } 
    while (b3 < this.consumerDestinations_.size()) {
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.consumerDestinations_.get(b3));
      b3++;
    } 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Monitoring, Builder> implements MonitoringOrBuilder {
    private Builder() {
      super(Monitoring.DEFAULT_INSTANCE);
    }
    
    public Builder addAllConsumerDestinations(Iterable<? extends Monitoring.MonitoringDestination> param1Iterable) {
      copyOnWrite();
      ((Monitoring)this.instance).addAllConsumerDestinations(param1Iterable);
      return this;
    }
    
    public Builder addAllProducerDestinations(Iterable<? extends Monitoring.MonitoringDestination> param1Iterable) {
      copyOnWrite();
      ((Monitoring)this.instance).addAllProducerDestinations(param1Iterable);
      return this;
    }
    
    public Builder addConsumerDestinations(int param1Int, Monitoring.MonitoringDestination.Builder param1Builder) {
      copyOnWrite();
      ((Monitoring)this.instance).addConsumerDestinations(param1Int, param1Builder);
      return this;
    }
    
    public Builder addConsumerDestinations(int param1Int, Monitoring.MonitoringDestination param1MonitoringDestination) {
      copyOnWrite();
      ((Monitoring)this.instance).addConsumerDestinations(param1Int, param1MonitoringDestination);
      return this;
    }
    
    public Builder addConsumerDestinations(Monitoring.MonitoringDestination.Builder param1Builder) {
      copyOnWrite();
      ((Monitoring)this.instance).addConsumerDestinations(param1Builder);
      return this;
    }
    
    public Builder addConsumerDestinations(Monitoring.MonitoringDestination param1MonitoringDestination) {
      copyOnWrite();
      ((Monitoring)this.instance).addConsumerDestinations(param1MonitoringDestination);
      return this;
    }
    
    public Builder addProducerDestinations(int param1Int, Monitoring.MonitoringDestination.Builder param1Builder) {
      copyOnWrite();
      ((Monitoring)this.instance).addProducerDestinations(param1Int, param1Builder);
      return this;
    }
    
    public Builder addProducerDestinations(int param1Int, Monitoring.MonitoringDestination param1MonitoringDestination) {
      copyOnWrite();
      ((Monitoring)this.instance).addProducerDestinations(param1Int, param1MonitoringDestination);
      return this;
    }
    
    public Builder addProducerDestinations(Monitoring.MonitoringDestination.Builder param1Builder) {
      copyOnWrite();
      ((Monitoring)this.instance).addProducerDestinations(param1Builder);
      return this;
    }
    
    public Builder addProducerDestinations(Monitoring.MonitoringDestination param1MonitoringDestination) {
      copyOnWrite();
      ((Monitoring)this.instance).addProducerDestinations(param1MonitoringDestination);
      return this;
    }
    
    public Builder clearConsumerDestinations() {
      copyOnWrite();
      ((Monitoring)this.instance).clearConsumerDestinations();
      return this;
    }
    
    public Builder clearProducerDestinations() {
      copyOnWrite();
      ((Monitoring)this.instance).clearProducerDestinations();
      return this;
    }
    
    public Monitoring.MonitoringDestination getConsumerDestinations(int param1Int) {
      return ((Monitoring)this.instance).getConsumerDestinations(param1Int);
    }
    
    public int getConsumerDestinationsCount() {
      return ((Monitoring)this.instance).getConsumerDestinationsCount();
    }
    
    public List<Monitoring.MonitoringDestination> getConsumerDestinationsList() {
      return Collections.unmodifiableList(((Monitoring)this.instance).getConsumerDestinationsList());
    }
    
    public Monitoring.MonitoringDestination getProducerDestinations(int param1Int) {
      return ((Monitoring)this.instance).getProducerDestinations(param1Int);
    }
    
    public int getProducerDestinationsCount() {
      return ((Monitoring)this.instance).getProducerDestinationsCount();
    }
    
    public List<Monitoring.MonitoringDestination> getProducerDestinationsList() {
      return Collections.unmodifiableList(((Monitoring)this.instance).getProducerDestinationsList());
    }
    
    public Builder removeConsumerDestinations(int param1Int) {
      copyOnWrite();
      ((Monitoring)this.instance).removeConsumerDestinations(param1Int);
      return this;
    }
    
    public Builder removeProducerDestinations(int param1Int) {
      copyOnWrite();
      ((Monitoring)this.instance).removeProducerDestinations(param1Int);
      return this;
    }
    
    public Builder setConsumerDestinations(int param1Int, Monitoring.MonitoringDestination.Builder param1Builder) {
      copyOnWrite();
      ((Monitoring)this.instance).setConsumerDestinations(param1Int, param1Builder);
      return this;
    }
    
    public Builder setConsumerDestinations(int param1Int, Monitoring.MonitoringDestination param1MonitoringDestination) {
      copyOnWrite();
      ((Monitoring)this.instance).setConsumerDestinations(param1Int, param1MonitoringDestination);
      return this;
    }
    
    public Builder setProducerDestinations(int param1Int, Monitoring.MonitoringDestination.Builder param1Builder) {
      copyOnWrite();
      ((Monitoring)this.instance).setProducerDestinations(param1Int, param1Builder);
      return this;
    }
    
    public Builder setProducerDestinations(int param1Int, Monitoring.MonitoringDestination param1MonitoringDestination) {
      copyOnWrite();
      ((Monitoring)this.instance).setProducerDestinations(param1Int, param1MonitoringDestination);
      return this;
    }
  }
  
  public static final class MonitoringDestination extends GeneratedMessageLite<MonitoringDestination, MonitoringDestination.Builder> implements MonitoringDestinationOrBuilder {
    private static final MonitoringDestination DEFAULT_INSTANCE = new MonitoringDestination();
    
    public static final int METRICS_FIELD_NUMBER = 2;
    
    public static final int MONITORED_RESOURCE_FIELD_NUMBER = 1;
    
    private static volatile Parser<MonitoringDestination> PARSER;
    
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
    
    public static MonitoringDestination getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(MonitoringDestination param1MonitoringDestination) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1MonitoringDestination);
    }
    
    public static MonitoringDestination parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (MonitoringDestination)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static MonitoringDestination parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (MonitoringDestination)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static MonitoringDestination parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (MonitoringDestination)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static MonitoringDestination parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (MonitoringDestination)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static MonitoringDestination parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (MonitoringDestination)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static MonitoringDestination parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (MonitoringDestination)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static MonitoringDestination parseFrom(InputStream param1InputStream) throws IOException {
      return (MonitoringDestination)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static MonitoringDestination parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (MonitoringDestination)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static MonitoringDestination parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (MonitoringDestination)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static MonitoringDestination parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (MonitoringDestination)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<MonitoringDestination> parser() {
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
      //   0: getstatic com/google/api/Monitoring$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 391, 2 -> 387, 3 -> 376, 4 -> 367, 5 -> 281, 6 -> 110, 7 -> 277, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/api/Monitoring$MonitoringDestination.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/api/Monitoring$MonitoringDestination
      //   72: monitorenter
      //   73: getstatic com/google/api/Monitoring$MonitoringDestination.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/api/Monitoring$MonitoringDestination.DEFAULT_INSTANCE : Lcom/google/api/Monitoring$MonitoringDestination;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/api/Monitoring$MonitoringDestination.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/api/Monitoring$MonitoringDestination
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/api/Monitoring$MonitoringDestination
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/api/Monitoring$MonitoringDestination.PARSER : Lcom/google/protobuf/Parser;
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
      //   231: astore_1
      //   232: new java/lang/RuntimeException
      //   235: astore_3
      //   236: new com/google/protobuf/InvalidProtocolBufferException
      //   239: astore_2
      //   240: aload_2
      //   241: aload_1
      //   242: invokevirtual getMessage : ()Ljava/lang/String;
      //   245: invokespecial <init> : (Ljava/lang/String;)V
      //   248: aload_3
      //   249: aload_2
      //   250: aload_0
      //   251: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   254: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   257: aload_3
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
      //   277: getstatic com/google/api/Monitoring$MonitoringDestination.DEFAULT_INSTANCE : Lcom/google/api/Monitoring$MonitoringDestination;
      //   280: areturn
      //   281: aload_2
      //   282: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   285: astore_1
      //   286: aload_3
      //   287: checkcast com/google/api/Monitoring$MonitoringDestination
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
      //   367: new com/google/api/Monitoring$MonitoringDestination$Builder
      //   370: dup
      //   371: aconst_null
      //   372: invokespecial <init> : (Lcom/google/api/Monitoring$1;)V
      //   375: areturn
      //   376: aload_0
      //   377: getfield metrics_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   380: invokeinterface makeImmutable : ()V
      //   385: aconst_null
      //   386: areturn
      //   387: getstatic com/google/api/Monitoring$MonitoringDestination.DEFAULT_INSTANCE : Lcom/google/api/Monitoring$MonitoringDestination;
      //   390: areturn
      //   391: new com/google/api/Monitoring$MonitoringDestination
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
    
    public static final class Builder extends GeneratedMessageLite.Builder<MonitoringDestination, Builder> implements Monitoring.MonitoringDestinationOrBuilder {
      private Builder() {
        super(Monitoring.MonitoringDestination.DEFAULT_INSTANCE);
      }
      
      public Builder addAllMetrics(Iterable<String> param2Iterable) {
        copyOnWrite();
        ((Monitoring.MonitoringDestination)this.instance).addAllMetrics(param2Iterable);
        return this;
      }
      
      public Builder addMetrics(String param2String) {
        copyOnWrite();
        ((Monitoring.MonitoringDestination)this.instance).addMetrics(param2String);
        return this;
      }
      
      public Builder addMetricsBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((Monitoring.MonitoringDestination)this.instance).addMetricsBytes(param2ByteString);
        return this;
      }
      
      public Builder clearMetrics() {
        copyOnWrite();
        ((Monitoring.MonitoringDestination)this.instance).clearMetrics();
        return this;
      }
      
      public Builder clearMonitoredResource() {
        copyOnWrite();
        ((Monitoring.MonitoringDestination)this.instance).clearMonitoredResource();
        return this;
      }
      
      public String getMetrics(int param2Int) {
        return ((Monitoring.MonitoringDestination)this.instance).getMetrics(param2Int);
      }
      
      public ByteString getMetricsBytes(int param2Int) {
        return ((Monitoring.MonitoringDestination)this.instance).getMetricsBytes(param2Int);
      }
      
      public int getMetricsCount() {
        return ((Monitoring.MonitoringDestination)this.instance).getMetricsCount();
      }
      
      public List<String> getMetricsList() {
        return Collections.unmodifiableList(((Monitoring.MonitoringDestination)this.instance).getMetricsList());
      }
      
      public String getMonitoredResource() {
        return ((Monitoring.MonitoringDestination)this.instance).getMonitoredResource();
      }
      
      public ByteString getMonitoredResourceBytes() {
        return ((Monitoring.MonitoringDestination)this.instance).getMonitoredResourceBytes();
      }
      
      public Builder setMetrics(int param2Int, String param2String) {
        copyOnWrite();
        ((Monitoring.MonitoringDestination)this.instance).setMetrics(param2Int, param2String);
        return this;
      }
      
      public Builder setMonitoredResource(String param2String) {
        copyOnWrite();
        ((Monitoring.MonitoringDestination)this.instance).setMonitoredResource(param2String);
        return this;
      }
      
      public Builder setMonitoredResourceBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((Monitoring.MonitoringDestination)this.instance).setMonitoredResourceBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<MonitoringDestination, MonitoringDestination.Builder> implements MonitoringDestinationOrBuilder {
    private Builder() {
      super(Monitoring.MonitoringDestination.DEFAULT_INSTANCE);
    }
    
    public Builder addAllMetrics(Iterable<String> param1Iterable) {
      copyOnWrite();
      ((Monitoring.MonitoringDestination)this.instance).addAllMetrics(param1Iterable);
      return this;
    }
    
    public Builder addMetrics(String param1String) {
      copyOnWrite();
      ((Monitoring.MonitoringDestination)this.instance).addMetrics(param1String);
      return this;
    }
    
    public Builder addMetricsBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Monitoring.MonitoringDestination)this.instance).addMetricsBytes(param1ByteString);
      return this;
    }
    
    public Builder clearMetrics() {
      copyOnWrite();
      ((Monitoring.MonitoringDestination)this.instance).clearMetrics();
      return this;
    }
    
    public Builder clearMonitoredResource() {
      copyOnWrite();
      ((Monitoring.MonitoringDestination)this.instance).clearMonitoredResource();
      return this;
    }
    
    public String getMetrics(int param1Int) {
      return ((Monitoring.MonitoringDestination)this.instance).getMetrics(param1Int);
    }
    
    public ByteString getMetricsBytes(int param1Int) {
      return ((Monitoring.MonitoringDestination)this.instance).getMetricsBytes(param1Int);
    }
    
    public int getMetricsCount() {
      return ((Monitoring.MonitoringDestination)this.instance).getMetricsCount();
    }
    
    public List<String> getMetricsList() {
      return Collections.unmodifiableList(((Monitoring.MonitoringDestination)this.instance).getMetricsList());
    }
    
    public String getMonitoredResource() {
      return ((Monitoring.MonitoringDestination)this.instance).getMonitoredResource();
    }
    
    public ByteString getMonitoredResourceBytes() {
      return ((Monitoring.MonitoringDestination)this.instance).getMonitoredResourceBytes();
    }
    
    public Builder setMetrics(int param1Int, String param1String) {
      copyOnWrite();
      ((Monitoring.MonitoringDestination)this.instance).setMetrics(param1Int, param1String);
      return this;
    }
    
    public Builder setMonitoredResource(String param1String) {
      copyOnWrite();
      ((Monitoring.MonitoringDestination)this.instance).setMonitoredResource(param1String);
      return this;
    }
    
    public Builder setMonitoredResourceBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Monitoring.MonitoringDestination)this.instance).setMonitoredResourceBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface MonitoringDestinationOrBuilder extends MessageLiteOrBuilder {
    String getMetrics(int param1Int);
    
    ByteString getMetricsBytes(int param1Int);
    
    int getMetricsCount();
    
    List<String> getMetricsList();
    
    String getMonitoredResource();
    
    ByteString getMonitoredResourceBytes();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\Monitoring.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */