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

public final class Logging extends GeneratedMessageLite<Logging, Logging.Builder> implements LoggingOrBuilder {
  public static final int CONSUMER_DESTINATIONS_FIELD_NUMBER = 2;
  
  private static final Logging DEFAULT_INSTANCE = new Logging();
  
  private static volatile Parser<Logging> PARSER;
  
  public static final int PRODUCER_DESTINATIONS_FIELD_NUMBER = 1;
  
  private Internal.ProtobufList<LoggingDestination> consumerDestinations_ = emptyProtobufList();
  
  private Internal.ProtobufList<LoggingDestination> producerDestinations_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllConsumerDestinations(Iterable<? extends LoggingDestination> paramIterable) {
    ensureConsumerDestinationsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.consumerDestinations_);
  }
  
  private void addAllProducerDestinations(Iterable<? extends LoggingDestination> paramIterable) {
    ensureProducerDestinationsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.producerDestinations_);
  }
  
  private void addConsumerDestinations(int paramInt, LoggingDestination.Builder paramBuilder) {
    ensureConsumerDestinationsIsMutable();
    this.consumerDestinations_.add(paramInt, paramBuilder.build());
  }
  
  private void addConsumerDestinations(int paramInt, LoggingDestination paramLoggingDestination) {
    if (paramLoggingDestination != null) {
      ensureConsumerDestinationsIsMutable();
      this.consumerDestinations_.add(paramInt, paramLoggingDestination);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addConsumerDestinations(LoggingDestination.Builder paramBuilder) {
    ensureConsumerDestinationsIsMutable();
    this.consumerDestinations_.add(paramBuilder.build());
  }
  
  private void addConsumerDestinations(LoggingDestination paramLoggingDestination) {
    if (paramLoggingDestination != null) {
      ensureConsumerDestinationsIsMutable();
      this.consumerDestinations_.add(paramLoggingDestination);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addProducerDestinations(int paramInt, LoggingDestination.Builder paramBuilder) {
    ensureProducerDestinationsIsMutable();
    this.producerDestinations_.add(paramInt, paramBuilder.build());
  }
  
  private void addProducerDestinations(int paramInt, LoggingDestination paramLoggingDestination) {
    if (paramLoggingDestination != null) {
      ensureProducerDestinationsIsMutable();
      this.producerDestinations_.add(paramInt, paramLoggingDestination);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addProducerDestinations(LoggingDestination.Builder paramBuilder) {
    ensureProducerDestinationsIsMutable();
    this.producerDestinations_.add(paramBuilder.build());
  }
  
  private void addProducerDestinations(LoggingDestination paramLoggingDestination) {
    if (paramLoggingDestination != null) {
      ensureProducerDestinationsIsMutable();
      this.producerDestinations_.add(paramLoggingDestination);
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
  
  public static Logging getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Logging paramLogging) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramLogging);
  }
  
  public static Logging parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Logging)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Logging parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Logging)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Logging parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Logging)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Logging parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Logging)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Logging parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Logging)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Logging parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Logging)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Logging parseFrom(InputStream paramInputStream) throws IOException {
    return (Logging)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Logging parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Logging)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Logging parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Logging)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Logging parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Logging)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Logging> parser() {
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
  
  private void setConsumerDestinations(int paramInt, LoggingDestination.Builder paramBuilder) {
    ensureConsumerDestinationsIsMutable();
    this.consumerDestinations_.set(paramInt, paramBuilder.build());
  }
  
  private void setConsumerDestinations(int paramInt, LoggingDestination paramLoggingDestination) {
    if (paramLoggingDestination != null) {
      ensureConsumerDestinationsIsMutable();
      this.consumerDestinations_.set(paramInt, paramLoggingDestination);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setProducerDestinations(int paramInt, LoggingDestination.Builder paramBuilder) {
    ensureProducerDestinationsIsMutable();
    this.producerDestinations_.set(paramInt, paramBuilder.build());
  }
  
  private void setProducerDestinations(int paramInt, LoggingDestination paramLoggingDestination) {
    if (paramLoggingDestination != null) {
      ensureProducerDestinationsIsMutable();
      this.producerDestinations_.set(paramInt, paramLoggingDestination);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/Logging$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 407, 2 -> 403, 3 -> 383, 4 -> 374, 5 -> 322, 6 -> 110, 7 -> 318, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/api/Logging.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/api/Logging
    //   72: monitorenter
    //   73: getstatic com/google/api/Logging.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/api/Logging.DEFAULT_INSTANCE : Lcom/google/api/Logging;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/api/Logging.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/api/Logging
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/api/Logging
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/api/Logging.PARSER : Lcom/google/protobuf/Parser;
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
    //   203: checkcast com/google/api/Logging$LoggingDestination
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
    //   250: checkcast com/google/api/Logging$LoggingDestination
    //   253: invokeinterface add : (Ljava/lang/Object;)Z
    //   258: pop
    //   259: goto -> 123
    //   262: iconst_1
    //   263: istore #4
    //   265: goto -> 123
    //   268: astore_1
    //   269: goto -> 316
    //   272: astore_3
    //   273: new java/lang/RuntimeException
    //   276: astore_2
    //   277: new com/google/protobuf/InvalidProtocolBufferException
    //   280: astore_1
    //   281: aload_1
    //   282: aload_3
    //   283: invokevirtual getMessage : ()Ljava/lang/String;
    //   286: invokespecial <init> : (Ljava/lang/String;)V
    //   289: aload_2
    //   290: aload_1
    //   291: aload_0
    //   292: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   295: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   298: aload_2
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
    //   318: getstatic com/google/api/Logging.DEFAULT_INSTANCE : Lcom/google/api/Logging;
    //   321: areturn
    //   322: aload_2
    //   323: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   326: astore_1
    //   327: aload_3
    //   328: checkcast com/google/api/Logging
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
    //   374: new com/google/api/Logging$Builder
    //   377: dup
    //   378: aconst_null
    //   379: invokespecial <init> : (Lcom/google/api/Logging$1;)V
    //   382: areturn
    //   383: aload_0
    //   384: getfield producerDestinations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   387: invokeinterface makeImmutable : ()V
    //   392: aload_0
    //   393: getfield consumerDestinations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   396: invokeinterface makeImmutable : ()V
    //   401: aconst_null
    //   402: areturn
    //   403: getstatic com/google/api/Logging.DEFAULT_INSTANCE : Lcom/google/api/Logging;
    //   406: areturn
    //   407: new com/google/api/Logging
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
  
  public LoggingDestination getConsumerDestinations(int paramInt) {
    return (LoggingDestination)this.consumerDestinations_.get(paramInt);
  }
  
  public int getConsumerDestinationsCount() {
    return this.consumerDestinations_.size();
  }
  
  public List<LoggingDestination> getConsumerDestinationsList() {
    return (List<LoggingDestination>)this.consumerDestinations_;
  }
  
  public LoggingDestinationOrBuilder getConsumerDestinationsOrBuilder(int paramInt) {
    return (LoggingDestinationOrBuilder)this.consumerDestinations_.get(paramInt);
  }
  
  public List<? extends LoggingDestinationOrBuilder> getConsumerDestinationsOrBuilderList() {
    return (List)this.consumerDestinations_;
  }
  
  public LoggingDestination getProducerDestinations(int paramInt) {
    return (LoggingDestination)this.producerDestinations_.get(paramInt);
  }
  
  public int getProducerDestinationsCount() {
    return this.producerDestinations_.size();
  }
  
  public List<LoggingDestination> getProducerDestinationsList() {
    return (List<LoggingDestination>)this.producerDestinations_;
  }
  
  public LoggingDestinationOrBuilder getProducerDestinationsOrBuilder(int paramInt) {
    return (LoggingDestinationOrBuilder)this.producerDestinations_.get(paramInt);
  }
  
  public List<? extends LoggingDestinationOrBuilder> getProducerDestinationsOrBuilderList() {
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
  
  public static final class Builder extends GeneratedMessageLite.Builder<Logging, Builder> implements LoggingOrBuilder {
    private Builder() {
      super(Logging.DEFAULT_INSTANCE);
    }
    
    public Builder addAllConsumerDestinations(Iterable<? extends Logging.LoggingDestination> param1Iterable) {
      copyOnWrite();
      ((Logging)this.instance).addAllConsumerDestinations(param1Iterable);
      return this;
    }
    
    public Builder addAllProducerDestinations(Iterable<? extends Logging.LoggingDestination> param1Iterable) {
      copyOnWrite();
      ((Logging)this.instance).addAllProducerDestinations(param1Iterable);
      return this;
    }
    
    public Builder addConsumerDestinations(int param1Int, Logging.LoggingDestination.Builder param1Builder) {
      copyOnWrite();
      ((Logging)this.instance).addConsumerDestinations(param1Int, param1Builder);
      return this;
    }
    
    public Builder addConsumerDestinations(int param1Int, Logging.LoggingDestination param1LoggingDestination) {
      copyOnWrite();
      ((Logging)this.instance).addConsumerDestinations(param1Int, param1LoggingDestination);
      return this;
    }
    
    public Builder addConsumerDestinations(Logging.LoggingDestination.Builder param1Builder) {
      copyOnWrite();
      ((Logging)this.instance).addConsumerDestinations(param1Builder);
      return this;
    }
    
    public Builder addConsumerDestinations(Logging.LoggingDestination param1LoggingDestination) {
      copyOnWrite();
      ((Logging)this.instance).addConsumerDestinations(param1LoggingDestination);
      return this;
    }
    
    public Builder addProducerDestinations(int param1Int, Logging.LoggingDestination.Builder param1Builder) {
      copyOnWrite();
      ((Logging)this.instance).addProducerDestinations(param1Int, param1Builder);
      return this;
    }
    
    public Builder addProducerDestinations(int param1Int, Logging.LoggingDestination param1LoggingDestination) {
      copyOnWrite();
      ((Logging)this.instance).addProducerDestinations(param1Int, param1LoggingDestination);
      return this;
    }
    
    public Builder addProducerDestinations(Logging.LoggingDestination.Builder param1Builder) {
      copyOnWrite();
      ((Logging)this.instance).addProducerDestinations(param1Builder);
      return this;
    }
    
    public Builder addProducerDestinations(Logging.LoggingDestination param1LoggingDestination) {
      copyOnWrite();
      ((Logging)this.instance).addProducerDestinations(param1LoggingDestination);
      return this;
    }
    
    public Builder clearConsumerDestinations() {
      copyOnWrite();
      ((Logging)this.instance).clearConsumerDestinations();
      return this;
    }
    
    public Builder clearProducerDestinations() {
      copyOnWrite();
      ((Logging)this.instance).clearProducerDestinations();
      return this;
    }
    
    public Logging.LoggingDestination getConsumerDestinations(int param1Int) {
      return ((Logging)this.instance).getConsumerDestinations(param1Int);
    }
    
    public int getConsumerDestinationsCount() {
      return ((Logging)this.instance).getConsumerDestinationsCount();
    }
    
    public List<Logging.LoggingDestination> getConsumerDestinationsList() {
      return Collections.unmodifiableList(((Logging)this.instance).getConsumerDestinationsList());
    }
    
    public Logging.LoggingDestination getProducerDestinations(int param1Int) {
      return ((Logging)this.instance).getProducerDestinations(param1Int);
    }
    
    public int getProducerDestinationsCount() {
      return ((Logging)this.instance).getProducerDestinationsCount();
    }
    
    public List<Logging.LoggingDestination> getProducerDestinationsList() {
      return Collections.unmodifiableList(((Logging)this.instance).getProducerDestinationsList());
    }
    
    public Builder removeConsumerDestinations(int param1Int) {
      copyOnWrite();
      ((Logging)this.instance).removeConsumerDestinations(param1Int);
      return this;
    }
    
    public Builder removeProducerDestinations(int param1Int) {
      copyOnWrite();
      ((Logging)this.instance).removeProducerDestinations(param1Int);
      return this;
    }
    
    public Builder setConsumerDestinations(int param1Int, Logging.LoggingDestination.Builder param1Builder) {
      copyOnWrite();
      ((Logging)this.instance).setConsumerDestinations(param1Int, param1Builder);
      return this;
    }
    
    public Builder setConsumerDestinations(int param1Int, Logging.LoggingDestination param1LoggingDestination) {
      copyOnWrite();
      ((Logging)this.instance).setConsumerDestinations(param1Int, param1LoggingDestination);
      return this;
    }
    
    public Builder setProducerDestinations(int param1Int, Logging.LoggingDestination.Builder param1Builder) {
      copyOnWrite();
      ((Logging)this.instance).setProducerDestinations(param1Int, param1Builder);
      return this;
    }
    
    public Builder setProducerDestinations(int param1Int, Logging.LoggingDestination param1LoggingDestination) {
      copyOnWrite();
      ((Logging)this.instance).setProducerDestinations(param1Int, param1LoggingDestination);
      return this;
    }
  }
  
  public static final class LoggingDestination extends GeneratedMessageLite<LoggingDestination, LoggingDestination.Builder> implements LoggingDestinationOrBuilder {
    private static final LoggingDestination DEFAULT_INSTANCE = new LoggingDestination();
    
    public static final int LOGS_FIELD_NUMBER = 1;
    
    public static final int MONITORED_RESOURCE_FIELD_NUMBER = 3;
    
    private static volatile Parser<LoggingDestination> PARSER;
    
    private int bitField0_;
    
    private Internal.ProtobufList<String> logs_ = GeneratedMessageLite.emptyProtobufList();
    
    private String monitoredResource_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllLogs(Iterable<String> param1Iterable) {
      ensureLogsIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.logs_);
    }
    
    private void addLogs(String param1String) {
      if (param1String != null) {
        ensureLogsIsMutable();
        this.logs_.add(param1String);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addLogsBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        ensureLogsIsMutable();
        this.logs_.add(param1ByteString.toStringUtf8());
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearLogs() {
      this.logs_ = GeneratedMessageLite.emptyProtobufList();
    }
    
    private void clearMonitoredResource() {
      this.monitoredResource_ = getDefaultInstance().getMonitoredResource();
    }
    
    private void ensureLogsIsMutable() {
      if (!this.logs_.isModifiable())
        this.logs_ = GeneratedMessageLite.mutableCopy(this.logs_); 
    }
    
    public static LoggingDestination getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(LoggingDestination param1LoggingDestination) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1LoggingDestination);
    }
    
    public static LoggingDestination parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (LoggingDestination)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static LoggingDestination parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LoggingDestination)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LoggingDestination parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (LoggingDestination)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static LoggingDestination parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LoggingDestination)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static LoggingDestination parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (LoggingDestination)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static LoggingDestination parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LoggingDestination)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static LoggingDestination parseFrom(InputStream param1InputStream) throws IOException {
      return (LoggingDestination)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static LoggingDestination parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LoggingDestination)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LoggingDestination parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (LoggingDestination)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static LoggingDestination parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LoggingDestination)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<LoggingDestination> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setLogs(int param1Int, String param1String) {
      if (param1String != null) {
        ensureLogsIsMutable();
        this.logs_.set(param1Int, param1String);
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
      //   0: getstatic com/google/api/Logging$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 391, 2 -> 387, 3 -> 376, 4 -> 367, 5 -> 281, 6 -> 110, 7 -> 277, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/api/Logging$LoggingDestination.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/api/Logging$LoggingDestination
      //   72: monitorenter
      //   73: getstatic com/google/api/Logging$LoggingDestination.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/api/Logging$LoggingDestination.DEFAULT_INSTANCE : Lcom/google/api/Logging$LoggingDestination;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/api/Logging$LoggingDestination.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/api/Logging$LoggingDestination
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/api/Logging$LoggingDestination
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/api/Logging$LoggingDestination.PARSER : Lcom/google/protobuf/Parser;
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
      //   143: if_icmpeq -> 179
      //   146: iload #5
      //   148: bipush #26
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
      //   173: putfield monitoredResource_ : Ljava/lang/String;
      //   176: goto -> 123
      //   179: aload_1
      //   180: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   183: astore_2
      //   184: aload_0
      //   185: getfield logs_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   188: invokeinterface isModifiable : ()Z
      //   193: ifne -> 207
      //   196: aload_0
      //   197: aload_0
      //   198: getfield logs_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   201: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   204: putfield logs_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   207: aload_0
      //   208: getfield logs_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   211: aload_2
      //   212: invokeinterface add : (Ljava/lang/Object;)Z
      //   217: pop
      //   218: goto -> 123
      //   221: iconst_1
      //   222: istore #4
      //   224: goto -> 123
      //   227: astore_1
      //   228: goto -> 275
      //   231: astore_2
      //   232: new java/lang/RuntimeException
      //   235: astore_3
      //   236: new com/google/protobuf/InvalidProtocolBufferException
      //   239: astore_1
      //   240: aload_1
      //   241: aload_2
      //   242: invokevirtual getMessage : ()Ljava/lang/String;
      //   245: invokespecial <init> : (Ljava/lang/String;)V
      //   248: aload_3
      //   249: aload_1
      //   250: aload_0
      //   251: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   254: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   257: aload_3
      //   258: athrow
      //   259: astore_2
      //   260: new java/lang/RuntimeException
      //   263: astore_1
      //   264: aload_1
      //   265: aload_2
      //   266: aload_0
      //   267: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   270: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   273: aload_1
      //   274: athrow
      //   275: aload_1
      //   276: athrow
      //   277: getstatic com/google/api/Logging$LoggingDestination.DEFAULT_INSTANCE : Lcom/google/api/Logging$LoggingDestination;
      //   280: areturn
      //   281: aload_2
      //   282: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   285: astore_1
      //   286: aload_3
      //   287: checkcast com/google/api/Logging$LoggingDestination
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
      //   330: getfield logs_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   333: aload_2
      //   334: getfield logs_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   337: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   342: putfield logs_ : Lcom/google/protobuf/Internal$ProtobufList;
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
      //   367: new com/google/api/Logging$LoggingDestination$Builder
      //   370: dup
      //   371: aconst_null
      //   372: invokespecial <init> : (Lcom/google/api/Logging$1;)V
      //   375: areturn
      //   376: aload_0
      //   377: getfield logs_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   380: invokeinterface makeImmutable : ()V
      //   385: aconst_null
      //   386: areturn
      //   387: getstatic com/google/api/Logging$LoggingDestination.DEFAULT_INSTANCE : Lcom/google/api/Logging$LoggingDestination;
      //   390: areturn
      //   391: new com/google/api/Logging$LoggingDestination
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
      //   168	176	259	com/google/protobuf/InvalidProtocolBufferException
      //   168	176	231	java/io/IOException
      //   168	176	227	finally
      //   179	207	259	com/google/protobuf/InvalidProtocolBufferException
      //   179	207	231	java/io/IOException
      //   179	207	227	finally
      //   207	218	259	com/google/protobuf/InvalidProtocolBufferException
      //   207	218	231	java/io/IOException
      //   207	218	227	finally
      //   232	259	227	finally
      //   260	275	227	finally
    }
    
    public String getLogs(int param1Int) {
      return (String)this.logs_.get(param1Int);
    }
    
    public ByteString getLogsBytes(int param1Int) {
      return ByteString.copyFromUtf8((String)this.logs_.get(param1Int));
    }
    
    public int getLogsCount() {
      return this.logs_.size();
    }
    
    public List<String> getLogsList() {
      return (List<String>)this.logs_;
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
      int j = 0;
      i = 0;
      while (j < this.logs_.size()) {
        i += CodedOutputStream.computeStringSizeNoTag((String)this.logs_.get(j));
        j++;
      } 
      j = 0 + i + getLogsList().size() * 1;
      i = j;
      if (!this.monitoredResource_.isEmpty())
        i = j + CodedOutputStream.computeStringSize(3, getMonitoredResource()); 
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      for (byte b = 0; b < this.logs_.size(); b++)
        param1CodedOutputStream.writeString(1, (String)this.logs_.get(b)); 
      if (!this.monitoredResource_.isEmpty())
        param1CodedOutputStream.writeString(3, getMonitoredResource()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<LoggingDestination, Builder> implements Logging.LoggingDestinationOrBuilder {
      private Builder() {
        super(Logging.LoggingDestination.DEFAULT_INSTANCE);
      }
      
      public Builder addAllLogs(Iterable<String> param2Iterable) {
        copyOnWrite();
        ((Logging.LoggingDestination)this.instance).addAllLogs(param2Iterable);
        return this;
      }
      
      public Builder addLogs(String param2String) {
        copyOnWrite();
        ((Logging.LoggingDestination)this.instance).addLogs(param2String);
        return this;
      }
      
      public Builder addLogsBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((Logging.LoggingDestination)this.instance).addLogsBytes(param2ByteString);
        return this;
      }
      
      public Builder clearLogs() {
        copyOnWrite();
        ((Logging.LoggingDestination)this.instance).clearLogs();
        return this;
      }
      
      public Builder clearMonitoredResource() {
        copyOnWrite();
        ((Logging.LoggingDestination)this.instance).clearMonitoredResource();
        return this;
      }
      
      public String getLogs(int param2Int) {
        return ((Logging.LoggingDestination)this.instance).getLogs(param2Int);
      }
      
      public ByteString getLogsBytes(int param2Int) {
        return ((Logging.LoggingDestination)this.instance).getLogsBytes(param2Int);
      }
      
      public int getLogsCount() {
        return ((Logging.LoggingDestination)this.instance).getLogsCount();
      }
      
      public List<String> getLogsList() {
        return Collections.unmodifiableList(((Logging.LoggingDestination)this.instance).getLogsList());
      }
      
      public String getMonitoredResource() {
        return ((Logging.LoggingDestination)this.instance).getMonitoredResource();
      }
      
      public ByteString getMonitoredResourceBytes() {
        return ((Logging.LoggingDestination)this.instance).getMonitoredResourceBytes();
      }
      
      public Builder setLogs(int param2Int, String param2String) {
        copyOnWrite();
        ((Logging.LoggingDestination)this.instance).setLogs(param2Int, param2String);
        return this;
      }
      
      public Builder setMonitoredResource(String param2String) {
        copyOnWrite();
        ((Logging.LoggingDestination)this.instance).setMonitoredResource(param2String);
        return this;
      }
      
      public Builder setMonitoredResourceBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((Logging.LoggingDestination)this.instance).setMonitoredResourceBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<LoggingDestination, LoggingDestination.Builder> implements LoggingDestinationOrBuilder {
    private Builder() {
      super(Logging.LoggingDestination.DEFAULT_INSTANCE);
    }
    
    public Builder addAllLogs(Iterable<String> param1Iterable) {
      copyOnWrite();
      ((Logging.LoggingDestination)this.instance).addAllLogs(param1Iterable);
      return this;
    }
    
    public Builder addLogs(String param1String) {
      copyOnWrite();
      ((Logging.LoggingDestination)this.instance).addLogs(param1String);
      return this;
    }
    
    public Builder addLogsBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Logging.LoggingDestination)this.instance).addLogsBytes(param1ByteString);
      return this;
    }
    
    public Builder clearLogs() {
      copyOnWrite();
      ((Logging.LoggingDestination)this.instance).clearLogs();
      return this;
    }
    
    public Builder clearMonitoredResource() {
      copyOnWrite();
      ((Logging.LoggingDestination)this.instance).clearMonitoredResource();
      return this;
    }
    
    public String getLogs(int param1Int) {
      return ((Logging.LoggingDestination)this.instance).getLogs(param1Int);
    }
    
    public ByteString getLogsBytes(int param1Int) {
      return ((Logging.LoggingDestination)this.instance).getLogsBytes(param1Int);
    }
    
    public int getLogsCount() {
      return ((Logging.LoggingDestination)this.instance).getLogsCount();
    }
    
    public List<String> getLogsList() {
      return Collections.unmodifiableList(((Logging.LoggingDestination)this.instance).getLogsList());
    }
    
    public String getMonitoredResource() {
      return ((Logging.LoggingDestination)this.instance).getMonitoredResource();
    }
    
    public ByteString getMonitoredResourceBytes() {
      return ((Logging.LoggingDestination)this.instance).getMonitoredResourceBytes();
    }
    
    public Builder setLogs(int param1Int, String param1String) {
      copyOnWrite();
      ((Logging.LoggingDestination)this.instance).setLogs(param1Int, param1String);
      return this;
    }
    
    public Builder setMonitoredResource(String param1String) {
      copyOnWrite();
      ((Logging.LoggingDestination)this.instance).setMonitoredResource(param1String);
      return this;
    }
    
    public Builder setMonitoredResourceBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Logging.LoggingDestination)this.instance).setMonitoredResourceBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface LoggingDestinationOrBuilder extends MessageLiteOrBuilder {
    String getLogs(int param1Int);
    
    ByteString getLogsBytes(int param1Int);
    
    int getLogsCount();
    
    List<String> getLogsList();
    
    String getMonitoredResource();
    
    ByteString getMonitoredResourceBytes();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\Logging.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */