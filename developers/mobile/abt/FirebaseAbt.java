package developers.mobile.abt;

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

public final class FirebaseAbt {
  static {
  
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class ExperimentLite extends GeneratedMessageLite<ExperimentLite, ExperimentLite.Builder> implements ExperimentLiteOrBuilder {
    private static final ExperimentLite DEFAULT_INSTANCE = new ExperimentLite();
    
    public static final int EXPERIMENT_ID_FIELD_NUMBER = 1;
    
    private static volatile Parser<ExperimentLite> PARSER;
    
    private String experimentId_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearExperimentId() {
      this.experimentId_ = getDefaultInstance().getExperimentId();
    }
    
    public static ExperimentLite getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ExperimentLite param1ExperimentLite) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1ExperimentLite);
    }
    
    public static ExperimentLite parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (ExperimentLite)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static ExperimentLite parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ExperimentLite)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ExperimentLite parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (ExperimentLite)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static ExperimentLite parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ExperimentLite)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static ExperimentLite parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (ExperimentLite)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static ExperimentLite parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ExperimentLite)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static ExperimentLite parseFrom(InputStream param1InputStream) throws IOException {
      return (ExperimentLite)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static ExperimentLite parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ExperimentLite)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ExperimentLite parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (ExperimentLite)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static ExperimentLite parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ExperimentLite)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<ExperimentLite> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setExperimentId(String param1String) {
      if (param1String != null) {
        this.experimentId_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setExperimentIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.experimentId_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic developers/mobile/abt/FirebaseAbt$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 299, 2 -> 295, 3 -> 293, 4 -> 284, 5 -> 232, 6 -> 110, 7 -> 228, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic developers/mobile/abt/FirebaseAbt$ExperimentLite.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc developers/mobile/abt/FirebaseAbt$ExperimentLite
      //   72: monitorenter
      //   73: getstatic developers/mobile/abt/FirebaseAbt$ExperimentLite.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic developers/mobile/abt/FirebaseAbt$ExperimentLite.DEFAULT_INSTANCE : Ldevelopers/mobile/abt/FirebaseAbt$ExperimentLite;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic developers/mobile/abt/FirebaseAbt$ExperimentLite.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc developers/mobile/abt/FirebaseAbt$ExperimentLite
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc developers/mobile/abt/FirebaseAbt$ExperimentLite
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic developers/mobile/abt/FirebaseAbt$ExperimentLite.PARSER : Lcom/google/protobuf/Parser;
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
      //   166: putfield experimentId_ : Ljava/lang/String;
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
      //   210: astore_1
      //   211: new java/lang/RuntimeException
      //   214: astore_2
      //   215: aload_2
      //   216: aload_1
      //   217: aload_0
      //   218: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   221: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   224: aload_2
      //   225: athrow
      //   226: aload_1
      //   227: athrow
      //   228: getstatic developers/mobile/abt/FirebaseAbt$ExperimentLite.DEFAULT_INSTANCE : Ldevelopers/mobile/abt/FirebaseAbt$ExperimentLite;
      //   231: areturn
      //   232: aload_2
      //   233: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   236: astore_1
      //   237: aload_3
      //   238: checkcast developers/mobile/abt/FirebaseAbt$ExperimentLite
      //   241: astore_2
      //   242: aload_0
      //   243: aload_1
      //   244: aload_0
      //   245: getfield experimentId_ : Ljava/lang/String;
      //   248: invokevirtual isEmpty : ()Z
      //   251: iconst_1
      //   252: ixor
      //   253: aload_0
      //   254: getfield experimentId_ : Ljava/lang/String;
      //   257: iconst_1
      //   258: aload_2
      //   259: getfield experimentId_ : Ljava/lang/String;
      //   262: invokevirtual isEmpty : ()Z
      //   265: ixor
      //   266: aload_2
      //   267: getfield experimentId_ : Ljava/lang/String;
      //   270: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   275: putfield experimentId_ : Ljava/lang/String;
      //   278: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   281: astore_1
      //   282: aload_0
      //   283: areturn
      //   284: new developers/mobile/abt/FirebaseAbt$ExperimentLite$Builder
      //   287: dup
      //   288: aconst_null
      //   289: invokespecial <init> : (Ldevelopers/mobile/abt/FirebaseAbt$1;)V
      //   292: areturn
      //   293: aconst_null
      //   294: areturn
      //   295: getstatic developers/mobile/abt/FirebaseAbt$ExperimentLite.DEFAULT_INSTANCE : Ldevelopers/mobile/abt/FirebaseAbt$ExperimentLite;
      //   298: areturn
      //   299: new developers/mobile/abt/FirebaseAbt$ExperimentLite
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
    
    public String getExperimentId() {
      return this.experimentId_;
    }
    
    public ByteString getExperimentIdBytes() {
      return ByteString.copyFromUtf8(this.experimentId_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (!this.experimentId_.isEmpty())
        i = 0 + CodedOutputStream.computeStringSize(1, getExperimentId()); 
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.experimentId_.isEmpty())
        param1CodedOutputStream.writeString(1, getExperimentId()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<ExperimentLite, Builder> implements FirebaseAbt.ExperimentLiteOrBuilder {
      private Builder() {
        super(FirebaseAbt.ExperimentLite.DEFAULT_INSTANCE);
      }
      
      public Builder clearExperimentId() {
        copyOnWrite();
        ((FirebaseAbt.ExperimentLite)this.instance).clearExperimentId();
        return this;
      }
      
      public String getExperimentId() {
        return ((FirebaseAbt.ExperimentLite)this.instance).getExperimentId();
      }
      
      public ByteString getExperimentIdBytes() {
        return ((FirebaseAbt.ExperimentLite)this.instance).getExperimentIdBytes();
      }
      
      public Builder setExperimentId(String param2String) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentLite)this.instance).setExperimentId(param2String);
        return this;
      }
      
      public Builder setExperimentIdBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentLite)this.instance).setExperimentIdBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ExperimentLite, ExperimentLite.Builder> implements ExperimentLiteOrBuilder {
    private Builder() {
      super(FirebaseAbt.ExperimentLite.DEFAULT_INSTANCE);
    }
    
    public Builder clearExperimentId() {
      copyOnWrite();
      ((FirebaseAbt.ExperimentLite)this.instance).clearExperimentId();
      return this;
    }
    
    public String getExperimentId() {
      return ((FirebaseAbt.ExperimentLite)this.instance).getExperimentId();
    }
    
    public ByteString getExperimentIdBytes() {
      return ((FirebaseAbt.ExperimentLite)this.instance).getExperimentIdBytes();
    }
    
    public Builder setExperimentId(String param1String) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentLite)this.instance).setExperimentId(param1String);
      return this;
    }
    
    public Builder setExperimentIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentLite)this.instance).setExperimentIdBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface ExperimentLiteOrBuilder extends MessageLiteOrBuilder {
    String getExperimentId();
    
    ByteString getExperimentIdBytes();
  }
  
  public static final class ExperimentPayload extends GeneratedMessageLite<ExperimentPayload, ExperimentPayload.Builder> implements ExperimentPayloadOrBuilder {
    public static final int ACTIVATE_EVENT_TO_LOG_FIELD_NUMBER = 8;
    
    public static final int CLEAR_EVENT_TO_LOG_FIELD_NUMBER = 9;
    
    private static final ExperimentPayload DEFAULT_INSTANCE = new ExperimentPayload();
    
    public static final int EXPERIMENT_ID_FIELD_NUMBER = 1;
    
    public static final int EXPERIMENT_START_TIME_MILLIS_FIELD_NUMBER = 3;
    
    public static final int ONGOING_EXPERIMENTS_FIELD_NUMBER = 13;
    
    public static final int OVERFLOW_POLICY_FIELD_NUMBER = 12;
    
    private static volatile Parser<ExperimentPayload> PARSER;
    
    public static final int SET_EVENT_TO_LOG_FIELD_NUMBER = 7;
    
    public static final int TIMEOUT_EVENT_TO_LOG_FIELD_NUMBER = 10;
    
    public static final int TIME_TO_LIVE_MILLIS_FIELD_NUMBER = 6;
    
    public static final int TRIGGER_EVENT_FIELD_NUMBER = 4;
    
    public static final int TRIGGER_TIMEOUT_MILLIS_FIELD_NUMBER = 5;
    
    public static final int TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER = 11;
    
    public static final int VARIANT_ID_FIELD_NUMBER = 2;
    
    private String activateEventToLog_ = "";
    
    private int bitField0_;
    
    private String clearEventToLog_ = "";
    
    private String experimentId_ = "";
    
    private long experimentStartTimeMillis_;
    
    private Internal.ProtobufList<FirebaseAbt.ExperimentLite> ongoingExperiments_ = emptyProtobufList();
    
    private int overflowPolicy_;
    
    private String setEventToLog_ = "";
    
    private long timeToLiveMillis_;
    
    private String timeoutEventToLog_ = "";
    
    private String triggerEvent_ = "";
    
    private long triggerTimeoutMillis_;
    
    private String ttlExpiryEventToLog_ = "";
    
    private String variantId_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllOngoingExperiments(Iterable<? extends FirebaseAbt.ExperimentLite> param1Iterable) {
      ensureOngoingExperimentsIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.ongoingExperiments_);
    }
    
    private void addOngoingExperiments(int param1Int, FirebaseAbt.ExperimentLite.Builder param1Builder) {
      ensureOngoingExperimentsIsMutable();
      this.ongoingExperiments_.add(param1Int, param1Builder.build());
    }
    
    private void addOngoingExperiments(int param1Int, FirebaseAbt.ExperimentLite param1ExperimentLite) {
      if (param1ExperimentLite != null) {
        ensureOngoingExperimentsIsMutable();
        this.ongoingExperiments_.add(param1Int, param1ExperimentLite);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addOngoingExperiments(FirebaseAbt.ExperimentLite.Builder param1Builder) {
      ensureOngoingExperimentsIsMutable();
      this.ongoingExperiments_.add(param1Builder.build());
    }
    
    private void addOngoingExperiments(FirebaseAbt.ExperimentLite param1ExperimentLite) {
      if (param1ExperimentLite != null) {
        ensureOngoingExperimentsIsMutable();
        this.ongoingExperiments_.add(param1ExperimentLite);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearActivateEventToLog() {
      this.activateEventToLog_ = getDefaultInstance().getActivateEventToLog();
    }
    
    private void clearClearEventToLog() {
      this.clearEventToLog_ = getDefaultInstance().getClearEventToLog();
    }
    
    private void clearExperimentId() {
      this.experimentId_ = getDefaultInstance().getExperimentId();
    }
    
    private void clearExperimentStartTimeMillis() {
      this.experimentStartTimeMillis_ = 0L;
    }
    
    private void clearOngoingExperiments() {
      this.ongoingExperiments_ = emptyProtobufList();
    }
    
    private void clearOverflowPolicy() {
      this.overflowPolicy_ = 0;
    }
    
    private void clearSetEventToLog() {
      this.setEventToLog_ = getDefaultInstance().getSetEventToLog();
    }
    
    private void clearTimeToLiveMillis() {
      this.timeToLiveMillis_ = 0L;
    }
    
    private void clearTimeoutEventToLog() {
      this.timeoutEventToLog_ = getDefaultInstance().getTimeoutEventToLog();
    }
    
    private void clearTriggerEvent() {
      this.triggerEvent_ = getDefaultInstance().getTriggerEvent();
    }
    
    private void clearTriggerTimeoutMillis() {
      this.triggerTimeoutMillis_ = 0L;
    }
    
    private void clearTtlExpiryEventToLog() {
      this.ttlExpiryEventToLog_ = getDefaultInstance().getTtlExpiryEventToLog();
    }
    
    private void clearVariantId() {
      this.variantId_ = getDefaultInstance().getVariantId();
    }
    
    private void ensureOngoingExperimentsIsMutable() {
      if (!this.ongoingExperiments_.isModifiable())
        this.ongoingExperiments_ = GeneratedMessageLite.mutableCopy(this.ongoingExperiments_); 
    }
    
    public static ExperimentPayload getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ExperimentPayload param1ExperimentPayload) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1ExperimentPayload);
    }
    
    public static ExperimentPayload parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (ExperimentPayload)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static ExperimentPayload parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ExperimentPayload)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ExperimentPayload parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (ExperimentPayload)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static ExperimentPayload parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ExperimentPayload)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static ExperimentPayload parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (ExperimentPayload)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static ExperimentPayload parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ExperimentPayload)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static ExperimentPayload parseFrom(InputStream param1InputStream) throws IOException {
      return (ExperimentPayload)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static ExperimentPayload parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ExperimentPayload)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ExperimentPayload parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (ExperimentPayload)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static ExperimentPayload parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ExperimentPayload)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<ExperimentPayload> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeOngoingExperiments(int param1Int) {
      ensureOngoingExperimentsIsMutable();
      this.ongoingExperiments_.remove(param1Int);
    }
    
    private void setActivateEventToLog(String param1String) {
      if (param1String != null) {
        this.activateEventToLog_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setActivateEventToLogBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.activateEventToLog_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setClearEventToLog(String param1String) {
      if (param1String != null) {
        this.clearEventToLog_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setClearEventToLogBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.clearEventToLog_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setExperimentId(String param1String) {
      if (param1String != null) {
        this.experimentId_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setExperimentIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.experimentId_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setExperimentStartTimeMillis(long param1Long) {
      this.experimentStartTimeMillis_ = param1Long;
    }
    
    private void setOngoingExperiments(int param1Int, FirebaseAbt.ExperimentLite.Builder param1Builder) {
      ensureOngoingExperimentsIsMutable();
      this.ongoingExperiments_.set(param1Int, param1Builder.build());
    }
    
    private void setOngoingExperiments(int param1Int, FirebaseAbt.ExperimentLite param1ExperimentLite) {
      if (param1ExperimentLite != null) {
        ensureOngoingExperimentsIsMutable();
        this.ongoingExperiments_.set(param1Int, param1ExperimentLite);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setOverflowPolicy(ExperimentOverflowPolicy param1ExperimentOverflowPolicy) {
      if (param1ExperimentOverflowPolicy != null) {
        this.overflowPolicy_ = param1ExperimentOverflowPolicy.getNumber();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setOverflowPolicyValue(int param1Int) {
      this.overflowPolicy_ = param1Int;
    }
    
    private void setSetEventToLog(String param1String) {
      if (param1String != null) {
        this.setEventToLog_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setSetEventToLogBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.setEventToLog_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTimeToLiveMillis(long param1Long) {
      this.timeToLiveMillis_ = param1Long;
    }
    
    private void setTimeoutEventToLog(String param1String) {
      if (param1String != null) {
        this.timeoutEventToLog_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTimeoutEventToLogBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.timeoutEventToLog_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTriggerEvent(String param1String) {
      if (param1String != null) {
        this.triggerEvent_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTriggerEventBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.triggerEvent_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTriggerTimeoutMillis(long param1Long) {
      this.triggerTimeoutMillis_ = param1Long;
    }
    
    private void setTtlExpiryEventToLog(String param1String) {
      if (param1String != null) {
        this.ttlExpiryEventToLog_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTtlExpiryEventToLogBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.ttlExpiryEventToLog_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setVariantId(String param1String) {
      if (param1String != null) {
        this.variantId_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setVariantIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.variantId_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic developers/mobile/abt/FirebaseAbt$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: istore #4
      //   10: iconst_0
      //   11: istore #5
      //   13: iconst_0
      //   14: istore #6
      //   16: iload #4
      //   18: tableswitch default -> 64, 1 -> 1129, 2 -> 1125, 3 -> 1114, 4 -> 1105, 5 -> 525, 6 -> 118, 7 -> 521, 8 -> 72
      //   64: new java/lang/UnsupportedOperationException
      //   67: dup
      //   68: invokespecial <init> : ()V
      //   71: athrow
      //   72: getstatic developers/mobile/abt/FirebaseAbt$ExperimentPayload.PARSER : Lcom/google/protobuf/Parser;
      //   75: ifnonnull -> 114
      //   78: ldc developers/mobile/abt/FirebaseAbt$ExperimentPayload
      //   80: monitorenter
      //   81: getstatic developers/mobile/abt/FirebaseAbt$ExperimentPayload.PARSER : Lcom/google/protobuf/Parser;
      //   84: ifnonnull -> 102
      //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   90: astore_1
      //   91: aload_1
      //   92: getstatic developers/mobile/abt/FirebaseAbt$ExperimentPayload.DEFAULT_INSTANCE : Ldevelopers/mobile/abt/FirebaseAbt$ExperimentPayload;
      //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   98: aload_1
      //   99: putstatic developers/mobile/abt/FirebaseAbt$ExperimentPayload.PARSER : Lcom/google/protobuf/Parser;
      //   102: ldc developers/mobile/abt/FirebaseAbt$ExperimentPayload
      //   104: monitorexit
      //   105: goto -> 114
      //   108: astore_1
      //   109: ldc developers/mobile/abt/FirebaseAbt$ExperimentPayload
      //   111: monitorexit
      //   112: aload_1
      //   113: athrow
      //   114: getstatic developers/mobile/abt/FirebaseAbt$ExperimentPayload.PARSER : Lcom/google/protobuf/Parser;
      //   117: areturn
      //   118: aload_2
      //   119: checkcast com/google/protobuf/CodedInputStream
      //   122: astore_1
      //   123: aload_3
      //   124: checkcast com/google/protobuf/ExtensionRegistryLite
      //   127: astore_2
      //   128: iload #6
      //   130: ifne -> 521
      //   133: aload_1
      //   134: invokevirtual readTag : ()I
      //   137: istore #4
      //   139: iload #4
      //   141: lookupswitch default -> 264, 0 -> 454, 10 -> 443, 18 -> 432, 24 -> 421, 34 -> 410, 40 -> 399, 48 -> 388, 58 -> 377, 66 -> 366, 74 -> 355, 82 -> 344, 90 -> 333, 96 -> 322, 106 -> 275
      //   264: aload_1
      //   265: iload #4
      //   267: invokevirtual skipField : (I)Z
      //   270: istore #7
      //   272: goto -> 460
      //   275: aload_0
      //   276: getfield ongoingExperiments_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   279: invokeinterface isModifiable : ()Z
      //   284: ifne -> 298
      //   287: aload_0
      //   288: aload_0
      //   289: getfield ongoingExperiments_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   292: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   295: putfield ongoingExperiments_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   298: aload_0
      //   299: getfield ongoingExperiments_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   302: aload_1
      //   303: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   306: aload_2
      //   307: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   310: checkcast developers/mobile/abt/FirebaseAbt$ExperimentLite
      //   313: invokeinterface add : (Ljava/lang/Object;)Z
      //   318: pop
      //   319: goto -> 128
      //   322: aload_0
      //   323: aload_1
      //   324: invokevirtual readEnum : ()I
      //   327: putfield overflowPolicy_ : I
      //   330: goto -> 128
      //   333: aload_0
      //   334: aload_1
      //   335: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   338: putfield ttlExpiryEventToLog_ : Ljava/lang/String;
      //   341: goto -> 128
      //   344: aload_0
      //   345: aload_1
      //   346: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   349: putfield timeoutEventToLog_ : Ljava/lang/String;
      //   352: goto -> 128
      //   355: aload_0
      //   356: aload_1
      //   357: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   360: putfield clearEventToLog_ : Ljava/lang/String;
      //   363: goto -> 128
      //   366: aload_0
      //   367: aload_1
      //   368: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   371: putfield activateEventToLog_ : Ljava/lang/String;
      //   374: goto -> 128
      //   377: aload_0
      //   378: aload_1
      //   379: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   382: putfield setEventToLog_ : Ljava/lang/String;
      //   385: goto -> 128
      //   388: aload_0
      //   389: aload_1
      //   390: invokevirtual readInt64 : ()J
      //   393: putfield timeToLiveMillis_ : J
      //   396: goto -> 128
      //   399: aload_0
      //   400: aload_1
      //   401: invokevirtual readInt64 : ()J
      //   404: putfield triggerTimeoutMillis_ : J
      //   407: goto -> 128
      //   410: aload_0
      //   411: aload_1
      //   412: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   415: putfield triggerEvent_ : Ljava/lang/String;
      //   418: goto -> 128
      //   421: aload_0
      //   422: aload_1
      //   423: invokevirtual readInt64 : ()J
      //   426: putfield experimentStartTimeMillis_ : J
      //   429: goto -> 128
      //   432: aload_0
      //   433: aload_1
      //   434: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   437: putfield variantId_ : Ljava/lang/String;
      //   440: goto -> 128
      //   443: aload_0
      //   444: aload_1
      //   445: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   448: putfield experimentId_ : Ljava/lang/String;
      //   451: goto -> 128
      //   454: iconst_1
      //   455: istore #6
      //   457: goto -> 128
      //   460: iload #7
      //   462: ifne -> 128
      //   465: iconst_1
      //   466: istore #6
      //   468: goto -> 128
      //   471: astore_1
      //   472: goto -> 519
      //   475: astore_1
      //   476: new java/lang/RuntimeException
      //   479: astore_2
      //   480: new com/google/protobuf/InvalidProtocolBufferException
      //   483: astore_3
      //   484: aload_3
      //   485: aload_1
      //   486: invokevirtual getMessage : ()Ljava/lang/String;
      //   489: invokespecial <init> : (Ljava/lang/String;)V
      //   492: aload_2
      //   493: aload_3
      //   494: aload_0
      //   495: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   498: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   501: aload_2
      //   502: athrow
      //   503: astore_1
      //   504: new java/lang/RuntimeException
      //   507: astore_2
      //   508: aload_2
      //   509: aload_1
      //   510: aload_0
      //   511: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   514: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   517: aload_2
      //   518: athrow
      //   519: aload_1
      //   520: athrow
      //   521: getstatic developers/mobile/abt/FirebaseAbt$ExperimentPayload.DEFAULT_INSTANCE : Ldevelopers/mobile/abt/FirebaseAbt$ExperimentPayload;
      //   524: areturn
      //   525: aload_2
      //   526: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   529: astore_1
      //   530: aload_3
      //   531: checkcast developers/mobile/abt/FirebaseAbt$ExperimentPayload
      //   534: astore_2
      //   535: aload_0
      //   536: aload_1
      //   537: aload_0
      //   538: getfield experimentId_ : Ljava/lang/String;
      //   541: invokevirtual isEmpty : ()Z
      //   544: iconst_1
      //   545: ixor
      //   546: aload_0
      //   547: getfield experimentId_ : Ljava/lang/String;
      //   550: aload_2
      //   551: getfield experimentId_ : Ljava/lang/String;
      //   554: invokevirtual isEmpty : ()Z
      //   557: iconst_1
      //   558: ixor
      //   559: aload_2
      //   560: getfield experimentId_ : Ljava/lang/String;
      //   563: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   568: putfield experimentId_ : Ljava/lang/String;
      //   571: aload_0
      //   572: aload_1
      //   573: aload_0
      //   574: getfield variantId_ : Ljava/lang/String;
      //   577: invokevirtual isEmpty : ()Z
      //   580: iconst_1
      //   581: ixor
      //   582: aload_0
      //   583: getfield variantId_ : Ljava/lang/String;
      //   586: aload_2
      //   587: getfield variantId_ : Ljava/lang/String;
      //   590: invokevirtual isEmpty : ()Z
      //   593: iconst_1
      //   594: ixor
      //   595: aload_2
      //   596: getfield variantId_ : Ljava/lang/String;
      //   599: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   604: putfield variantId_ : Ljava/lang/String;
      //   607: aload_0
      //   608: getfield experimentStartTimeMillis_ : J
      //   611: lconst_0
      //   612: lcmp
      //   613: ifeq -> 622
      //   616: iconst_1
      //   617: istore #7
      //   619: goto -> 625
      //   622: iconst_0
      //   623: istore #7
      //   625: aload_0
      //   626: getfield experimentStartTimeMillis_ : J
      //   629: lstore #8
      //   631: aload_2
      //   632: getfield experimentStartTimeMillis_ : J
      //   635: lconst_0
      //   636: lcmp
      //   637: ifeq -> 646
      //   640: iconst_1
      //   641: istore #10
      //   643: goto -> 649
      //   646: iconst_0
      //   647: istore #10
      //   649: aload_0
      //   650: aload_1
      //   651: iload #7
      //   653: lload #8
      //   655: iload #10
      //   657: aload_2
      //   658: getfield experimentStartTimeMillis_ : J
      //   661: invokeinterface visitLong : (ZJZJ)J
      //   666: putfield experimentStartTimeMillis_ : J
      //   669: aload_0
      //   670: aload_1
      //   671: aload_0
      //   672: getfield triggerEvent_ : Ljava/lang/String;
      //   675: invokevirtual isEmpty : ()Z
      //   678: iconst_1
      //   679: ixor
      //   680: aload_0
      //   681: getfield triggerEvent_ : Ljava/lang/String;
      //   684: aload_2
      //   685: getfield triggerEvent_ : Ljava/lang/String;
      //   688: invokevirtual isEmpty : ()Z
      //   691: iconst_1
      //   692: ixor
      //   693: aload_2
      //   694: getfield triggerEvent_ : Ljava/lang/String;
      //   697: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   702: putfield triggerEvent_ : Ljava/lang/String;
      //   705: aload_0
      //   706: getfield triggerTimeoutMillis_ : J
      //   709: lconst_0
      //   710: lcmp
      //   711: ifeq -> 720
      //   714: iconst_1
      //   715: istore #7
      //   717: goto -> 723
      //   720: iconst_0
      //   721: istore #7
      //   723: aload_0
      //   724: getfield triggerTimeoutMillis_ : J
      //   727: lstore #8
      //   729: aload_2
      //   730: getfield triggerTimeoutMillis_ : J
      //   733: lconst_0
      //   734: lcmp
      //   735: ifeq -> 744
      //   738: iconst_1
      //   739: istore #10
      //   741: goto -> 747
      //   744: iconst_0
      //   745: istore #10
      //   747: aload_0
      //   748: aload_1
      //   749: iload #7
      //   751: lload #8
      //   753: iload #10
      //   755: aload_2
      //   756: getfield triggerTimeoutMillis_ : J
      //   759: invokeinterface visitLong : (ZJZJ)J
      //   764: putfield triggerTimeoutMillis_ : J
      //   767: aload_0
      //   768: getfield timeToLiveMillis_ : J
      //   771: lconst_0
      //   772: lcmp
      //   773: ifeq -> 782
      //   776: iconst_1
      //   777: istore #7
      //   779: goto -> 785
      //   782: iconst_0
      //   783: istore #7
      //   785: aload_0
      //   786: getfield timeToLiveMillis_ : J
      //   789: lstore #8
      //   791: aload_2
      //   792: getfield timeToLiveMillis_ : J
      //   795: lconst_0
      //   796: lcmp
      //   797: ifeq -> 806
      //   800: iconst_1
      //   801: istore #10
      //   803: goto -> 809
      //   806: iconst_0
      //   807: istore #10
      //   809: aload_0
      //   810: aload_1
      //   811: iload #7
      //   813: lload #8
      //   815: iload #10
      //   817: aload_2
      //   818: getfield timeToLiveMillis_ : J
      //   821: invokeinterface visitLong : (ZJZJ)J
      //   826: putfield timeToLiveMillis_ : J
      //   829: aload_0
      //   830: aload_1
      //   831: aload_0
      //   832: getfield setEventToLog_ : Ljava/lang/String;
      //   835: invokevirtual isEmpty : ()Z
      //   838: iconst_1
      //   839: ixor
      //   840: aload_0
      //   841: getfield setEventToLog_ : Ljava/lang/String;
      //   844: aload_2
      //   845: getfield setEventToLog_ : Ljava/lang/String;
      //   848: invokevirtual isEmpty : ()Z
      //   851: iconst_1
      //   852: ixor
      //   853: aload_2
      //   854: getfield setEventToLog_ : Ljava/lang/String;
      //   857: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   862: putfield setEventToLog_ : Ljava/lang/String;
      //   865: aload_0
      //   866: aload_1
      //   867: aload_0
      //   868: getfield activateEventToLog_ : Ljava/lang/String;
      //   871: invokevirtual isEmpty : ()Z
      //   874: iconst_1
      //   875: ixor
      //   876: aload_0
      //   877: getfield activateEventToLog_ : Ljava/lang/String;
      //   880: aload_2
      //   881: getfield activateEventToLog_ : Ljava/lang/String;
      //   884: invokevirtual isEmpty : ()Z
      //   887: iconst_1
      //   888: ixor
      //   889: aload_2
      //   890: getfield activateEventToLog_ : Ljava/lang/String;
      //   893: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   898: putfield activateEventToLog_ : Ljava/lang/String;
      //   901: aload_0
      //   902: aload_1
      //   903: aload_0
      //   904: getfield clearEventToLog_ : Ljava/lang/String;
      //   907: invokevirtual isEmpty : ()Z
      //   910: iconst_1
      //   911: ixor
      //   912: aload_0
      //   913: getfield clearEventToLog_ : Ljava/lang/String;
      //   916: aload_2
      //   917: getfield clearEventToLog_ : Ljava/lang/String;
      //   920: invokevirtual isEmpty : ()Z
      //   923: iconst_1
      //   924: ixor
      //   925: aload_2
      //   926: getfield clearEventToLog_ : Ljava/lang/String;
      //   929: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   934: putfield clearEventToLog_ : Ljava/lang/String;
      //   937: aload_0
      //   938: aload_1
      //   939: aload_0
      //   940: getfield timeoutEventToLog_ : Ljava/lang/String;
      //   943: invokevirtual isEmpty : ()Z
      //   946: iconst_1
      //   947: ixor
      //   948: aload_0
      //   949: getfield timeoutEventToLog_ : Ljava/lang/String;
      //   952: aload_2
      //   953: getfield timeoutEventToLog_ : Ljava/lang/String;
      //   956: invokevirtual isEmpty : ()Z
      //   959: iconst_1
      //   960: ixor
      //   961: aload_2
      //   962: getfield timeoutEventToLog_ : Ljava/lang/String;
      //   965: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   970: putfield timeoutEventToLog_ : Ljava/lang/String;
      //   973: aload_0
      //   974: aload_1
      //   975: aload_0
      //   976: getfield ttlExpiryEventToLog_ : Ljava/lang/String;
      //   979: invokevirtual isEmpty : ()Z
      //   982: iconst_1
      //   983: ixor
      //   984: aload_0
      //   985: getfield ttlExpiryEventToLog_ : Ljava/lang/String;
      //   988: aload_2
      //   989: getfield ttlExpiryEventToLog_ : Ljava/lang/String;
      //   992: invokevirtual isEmpty : ()Z
      //   995: iconst_1
      //   996: ixor
      //   997: aload_2
      //   998: getfield ttlExpiryEventToLog_ : Ljava/lang/String;
      //   1001: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   1006: putfield ttlExpiryEventToLog_ : Ljava/lang/String;
      //   1009: aload_0
      //   1010: getfield overflowPolicy_ : I
      //   1013: ifeq -> 1022
      //   1016: iconst_1
      //   1017: istore #7
      //   1019: goto -> 1025
      //   1022: iconst_0
      //   1023: istore #7
      //   1025: aload_0
      //   1026: getfield overflowPolicy_ : I
      //   1029: istore #6
      //   1031: iload #5
      //   1033: istore #10
      //   1035: aload_2
      //   1036: getfield overflowPolicy_ : I
      //   1039: ifeq -> 1045
      //   1042: iconst_1
      //   1043: istore #10
      //   1045: aload_0
      //   1046: aload_1
      //   1047: iload #7
      //   1049: iload #6
      //   1051: iload #10
      //   1053: aload_2
      //   1054: getfield overflowPolicy_ : I
      //   1057: invokeinterface visitInt : (ZIZI)I
      //   1062: putfield overflowPolicy_ : I
      //   1065: aload_0
      //   1066: aload_1
      //   1067: aload_0
      //   1068: getfield ongoingExperiments_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1071: aload_2
      //   1072: getfield ongoingExperiments_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1075: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   1080: putfield ongoingExperiments_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1083: aload_1
      //   1084: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   1087: if_acmpne -> 1103
      //   1090: aload_0
      //   1091: aload_0
      //   1092: getfield bitField0_ : I
      //   1095: aload_2
      //   1096: getfield bitField0_ : I
      //   1099: ior
      //   1100: putfield bitField0_ : I
      //   1103: aload_0
      //   1104: areturn
      //   1105: new developers/mobile/abt/FirebaseAbt$ExperimentPayload$Builder
      //   1108: dup
      //   1109: aconst_null
      //   1110: invokespecial <init> : (Ldevelopers/mobile/abt/FirebaseAbt$1;)V
      //   1113: areturn
      //   1114: aload_0
      //   1115: getfield ongoingExperiments_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   1118: invokeinterface makeImmutable : ()V
      //   1123: aconst_null
      //   1124: areturn
      //   1125: getstatic developers/mobile/abt/FirebaseAbt$ExperimentPayload.DEFAULT_INSTANCE : Ldevelopers/mobile/abt/FirebaseAbt$ExperimentPayload;
      //   1128: areturn
      //   1129: new developers/mobile/abt/FirebaseAbt$ExperimentPayload
      //   1132: dup
      //   1133: invokespecial <init> : ()V
      //   1136: areturn
      // Exception table:
      //   from	to	target	type
      //   81	102	108	finally
      //   102	105	108	finally
      //   109	112	108	finally
      //   133	139	503	com/google/protobuf/InvalidProtocolBufferException
      //   133	139	475	java/io/IOException
      //   133	139	471	finally
      //   264	272	503	com/google/protobuf/InvalidProtocolBufferException
      //   264	272	475	java/io/IOException
      //   264	272	471	finally
      //   275	298	503	com/google/protobuf/InvalidProtocolBufferException
      //   275	298	475	java/io/IOException
      //   275	298	471	finally
      //   298	319	503	com/google/protobuf/InvalidProtocolBufferException
      //   298	319	475	java/io/IOException
      //   298	319	471	finally
      //   322	330	503	com/google/protobuf/InvalidProtocolBufferException
      //   322	330	475	java/io/IOException
      //   322	330	471	finally
      //   333	341	503	com/google/protobuf/InvalidProtocolBufferException
      //   333	341	475	java/io/IOException
      //   333	341	471	finally
      //   344	352	503	com/google/protobuf/InvalidProtocolBufferException
      //   344	352	475	java/io/IOException
      //   344	352	471	finally
      //   355	363	503	com/google/protobuf/InvalidProtocolBufferException
      //   355	363	475	java/io/IOException
      //   355	363	471	finally
      //   366	374	503	com/google/protobuf/InvalidProtocolBufferException
      //   366	374	475	java/io/IOException
      //   366	374	471	finally
      //   377	385	503	com/google/protobuf/InvalidProtocolBufferException
      //   377	385	475	java/io/IOException
      //   377	385	471	finally
      //   388	396	503	com/google/protobuf/InvalidProtocolBufferException
      //   388	396	475	java/io/IOException
      //   388	396	471	finally
      //   399	407	503	com/google/protobuf/InvalidProtocolBufferException
      //   399	407	475	java/io/IOException
      //   399	407	471	finally
      //   410	418	503	com/google/protobuf/InvalidProtocolBufferException
      //   410	418	475	java/io/IOException
      //   410	418	471	finally
      //   421	429	503	com/google/protobuf/InvalidProtocolBufferException
      //   421	429	475	java/io/IOException
      //   421	429	471	finally
      //   432	440	503	com/google/protobuf/InvalidProtocolBufferException
      //   432	440	475	java/io/IOException
      //   432	440	471	finally
      //   443	451	503	com/google/protobuf/InvalidProtocolBufferException
      //   443	451	475	java/io/IOException
      //   443	451	471	finally
      //   476	503	471	finally
      //   504	519	471	finally
    }
    
    public String getActivateEventToLog() {
      return this.activateEventToLog_;
    }
    
    public ByteString getActivateEventToLogBytes() {
      return ByteString.copyFromUtf8(this.activateEventToLog_);
    }
    
    public String getClearEventToLog() {
      return this.clearEventToLog_;
    }
    
    public ByteString getClearEventToLogBytes() {
      return ByteString.copyFromUtf8(this.clearEventToLog_);
    }
    
    public String getExperimentId() {
      return this.experimentId_;
    }
    
    public ByteString getExperimentIdBytes() {
      return ByteString.copyFromUtf8(this.experimentId_);
    }
    
    public long getExperimentStartTimeMillis() {
      return this.experimentStartTimeMillis_;
    }
    
    public FirebaseAbt.ExperimentLite getOngoingExperiments(int param1Int) {
      return (FirebaseAbt.ExperimentLite)this.ongoingExperiments_.get(param1Int);
    }
    
    public int getOngoingExperimentsCount() {
      return this.ongoingExperiments_.size();
    }
    
    public List<FirebaseAbt.ExperimentLite> getOngoingExperimentsList() {
      return (List<FirebaseAbt.ExperimentLite>)this.ongoingExperiments_;
    }
    
    public FirebaseAbt.ExperimentLiteOrBuilder getOngoingExperimentsOrBuilder(int param1Int) {
      return (FirebaseAbt.ExperimentLiteOrBuilder)this.ongoingExperiments_.get(param1Int);
    }
    
    public List<? extends FirebaseAbt.ExperimentLiteOrBuilder> getOngoingExperimentsOrBuilderList() {
      return (List)this.ongoingExperiments_;
    }
    
    public ExperimentOverflowPolicy getOverflowPolicy() {
      ExperimentOverflowPolicy experimentOverflowPolicy1 = ExperimentOverflowPolicy.forNumber(this.overflowPolicy_);
      ExperimentOverflowPolicy experimentOverflowPolicy2 = experimentOverflowPolicy1;
      if (experimentOverflowPolicy1 == null)
        experimentOverflowPolicy2 = ExperimentOverflowPolicy.UNRECOGNIZED; 
      return experimentOverflowPolicy2;
    }
    
    public int getOverflowPolicyValue() {
      return this.overflowPolicy_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      boolean bool = this.experimentId_.isEmpty();
      boolean bool1 = false;
      if (!bool) {
        j = CodedOutputStream.computeStringSize(1, getExperimentId()) + 0;
      } else {
        j = 0;
      } 
      i = j;
      if (!this.variantId_.isEmpty())
        i = j + CodedOutputStream.computeStringSize(2, getVariantId()); 
      long l = this.experimentStartTimeMillis_;
      int j = i;
      if (l != 0L)
        j = i + CodedOutputStream.computeInt64Size(3, l); 
      i = j;
      if (!this.triggerEvent_.isEmpty())
        i = j + CodedOutputStream.computeStringSize(4, getTriggerEvent()); 
      l = this.triggerTimeoutMillis_;
      j = i;
      if (l != 0L)
        j = i + CodedOutputStream.computeInt64Size(5, l); 
      l = this.timeToLiveMillis_;
      i = j;
      if (l != 0L)
        i = j + CodedOutputStream.computeInt64Size(6, l); 
      int k = i;
      if (!this.setEventToLog_.isEmpty())
        k = i + CodedOutputStream.computeStringSize(7, getSetEventToLog()); 
      j = k;
      if (!this.activateEventToLog_.isEmpty())
        j = k + CodedOutputStream.computeStringSize(8, getActivateEventToLog()); 
      i = j;
      if (!this.clearEventToLog_.isEmpty())
        i = j + CodedOutputStream.computeStringSize(9, getClearEventToLog()); 
      j = i;
      if (!this.timeoutEventToLog_.isEmpty())
        j = i + CodedOutputStream.computeStringSize(10, getTimeoutEventToLog()); 
      i = j;
      if (!this.ttlExpiryEventToLog_.isEmpty())
        i = j + CodedOutputStream.computeStringSize(11, getTtlExpiryEventToLog()); 
      j = i;
      k = bool1;
      if (this.overflowPolicy_ != ExperimentOverflowPolicy.POLICY_UNSPECIFIED.getNumber()) {
        j = i + CodedOutputStream.computeEnumSize(12, this.overflowPolicy_);
        k = bool1;
      } 
      while (k < this.ongoingExperiments_.size()) {
        j += CodedOutputStream.computeMessageSize(13, (MessageLite)this.ongoingExperiments_.get(k));
        k++;
      } 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public String getSetEventToLog() {
      return this.setEventToLog_;
    }
    
    public ByteString getSetEventToLogBytes() {
      return ByteString.copyFromUtf8(this.setEventToLog_);
    }
    
    public long getTimeToLiveMillis() {
      return this.timeToLiveMillis_;
    }
    
    public String getTimeoutEventToLog() {
      return this.timeoutEventToLog_;
    }
    
    public ByteString getTimeoutEventToLogBytes() {
      return ByteString.copyFromUtf8(this.timeoutEventToLog_);
    }
    
    public String getTriggerEvent() {
      return this.triggerEvent_;
    }
    
    public ByteString getTriggerEventBytes() {
      return ByteString.copyFromUtf8(this.triggerEvent_);
    }
    
    public long getTriggerTimeoutMillis() {
      return this.triggerTimeoutMillis_;
    }
    
    public String getTtlExpiryEventToLog() {
      return this.ttlExpiryEventToLog_;
    }
    
    public ByteString getTtlExpiryEventToLogBytes() {
      return ByteString.copyFromUtf8(this.ttlExpiryEventToLog_);
    }
    
    public String getVariantId() {
      return this.variantId_;
    }
    
    public ByteString getVariantIdBytes() {
      return ByteString.copyFromUtf8(this.variantId_);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.experimentId_.isEmpty())
        param1CodedOutputStream.writeString(1, getExperimentId()); 
      if (!this.variantId_.isEmpty())
        param1CodedOutputStream.writeString(2, getVariantId()); 
      long l = this.experimentStartTimeMillis_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(3, l); 
      if (!this.triggerEvent_.isEmpty())
        param1CodedOutputStream.writeString(4, getTriggerEvent()); 
      l = this.triggerTimeoutMillis_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(5, l); 
      l = this.timeToLiveMillis_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(6, l); 
      if (!this.setEventToLog_.isEmpty())
        param1CodedOutputStream.writeString(7, getSetEventToLog()); 
      if (!this.activateEventToLog_.isEmpty())
        param1CodedOutputStream.writeString(8, getActivateEventToLog()); 
      if (!this.clearEventToLog_.isEmpty())
        param1CodedOutputStream.writeString(9, getClearEventToLog()); 
      if (!this.timeoutEventToLog_.isEmpty())
        param1CodedOutputStream.writeString(10, getTimeoutEventToLog()); 
      if (!this.ttlExpiryEventToLog_.isEmpty())
        param1CodedOutputStream.writeString(11, getTtlExpiryEventToLog()); 
      if (this.overflowPolicy_ != ExperimentOverflowPolicy.POLICY_UNSPECIFIED.getNumber())
        param1CodedOutputStream.writeEnum(12, this.overflowPolicy_); 
      for (byte b = 0; b < this.ongoingExperiments_.size(); b++)
        param1CodedOutputStream.writeMessage(13, (MessageLite)this.ongoingExperiments_.get(b)); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<ExperimentPayload, Builder> implements FirebaseAbt.ExperimentPayloadOrBuilder {
      private Builder() {
        super(FirebaseAbt.ExperimentPayload.DEFAULT_INSTANCE);
      }
      
      public Builder addAllOngoingExperiments(Iterable<? extends FirebaseAbt.ExperimentLite> param2Iterable) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).addAllOngoingExperiments(param2Iterable);
        return this;
      }
      
      public Builder addOngoingExperiments(int param2Int, FirebaseAbt.ExperimentLite.Builder param2Builder) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).addOngoingExperiments(param2Int, param2Builder);
        return this;
      }
      
      public Builder addOngoingExperiments(int param2Int, FirebaseAbt.ExperimentLite param2ExperimentLite) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).addOngoingExperiments(param2Int, param2ExperimentLite);
        return this;
      }
      
      public Builder addOngoingExperiments(FirebaseAbt.ExperimentLite.Builder param2Builder) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).addOngoingExperiments(param2Builder);
        return this;
      }
      
      public Builder addOngoingExperiments(FirebaseAbt.ExperimentLite param2ExperimentLite) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).addOngoingExperiments(param2ExperimentLite);
        return this;
      }
      
      public Builder clearActivateEventToLog() {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).clearActivateEventToLog();
        return this;
      }
      
      public Builder clearClearEventToLog() {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).clearClearEventToLog();
        return this;
      }
      
      public Builder clearExperimentId() {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).clearExperimentId();
        return this;
      }
      
      public Builder clearExperimentStartTimeMillis() {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).clearExperimentStartTimeMillis();
        return this;
      }
      
      public Builder clearOngoingExperiments() {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).clearOngoingExperiments();
        return this;
      }
      
      public Builder clearOverflowPolicy() {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).clearOverflowPolicy();
        return this;
      }
      
      public Builder clearSetEventToLog() {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).clearSetEventToLog();
        return this;
      }
      
      public Builder clearTimeToLiveMillis() {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).clearTimeToLiveMillis();
        return this;
      }
      
      public Builder clearTimeoutEventToLog() {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).clearTimeoutEventToLog();
        return this;
      }
      
      public Builder clearTriggerEvent() {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).clearTriggerEvent();
        return this;
      }
      
      public Builder clearTriggerTimeoutMillis() {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).clearTriggerTimeoutMillis();
        return this;
      }
      
      public Builder clearTtlExpiryEventToLog() {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).clearTtlExpiryEventToLog();
        return this;
      }
      
      public Builder clearVariantId() {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).clearVariantId();
        return this;
      }
      
      public String getActivateEventToLog() {
        return ((FirebaseAbt.ExperimentPayload)this.instance).getActivateEventToLog();
      }
      
      public ByteString getActivateEventToLogBytes() {
        return ((FirebaseAbt.ExperimentPayload)this.instance).getActivateEventToLogBytes();
      }
      
      public String getClearEventToLog() {
        return ((FirebaseAbt.ExperimentPayload)this.instance).getClearEventToLog();
      }
      
      public ByteString getClearEventToLogBytes() {
        return ((FirebaseAbt.ExperimentPayload)this.instance).getClearEventToLogBytes();
      }
      
      public String getExperimentId() {
        return ((FirebaseAbt.ExperimentPayload)this.instance).getExperimentId();
      }
      
      public ByteString getExperimentIdBytes() {
        return ((FirebaseAbt.ExperimentPayload)this.instance).getExperimentIdBytes();
      }
      
      public long getExperimentStartTimeMillis() {
        return ((FirebaseAbt.ExperimentPayload)this.instance).getExperimentStartTimeMillis();
      }
      
      public FirebaseAbt.ExperimentLite getOngoingExperiments(int param2Int) {
        return ((FirebaseAbt.ExperimentPayload)this.instance).getOngoingExperiments(param2Int);
      }
      
      public int getOngoingExperimentsCount() {
        return ((FirebaseAbt.ExperimentPayload)this.instance).getOngoingExperimentsCount();
      }
      
      public List<FirebaseAbt.ExperimentLite> getOngoingExperimentsList() {
        return Collections.unmodifiableList(((FirebaseAbt.ExperimentPayload)this.instance).getOngoingExperimentsList());
      }
      
      public FirebaseAbt.ExperimentPayload.ExperimentOverflowPolicy getOverflowPolicy() {
        return ((FirebaseAbt.ExperimentPayload)this.instance).getOverflowPolicy();
      }
      
      public int getOverflowPolicyValue() {
        return ((FirebaseAbt.ExperimentPayload)this.instance).getOverflowPolicyValue();
      }
      
      public String getSetEventToLog() {
        return ((FirebaseAbt.ExperimentPayload)this.instance).getSetEventToLog();
      }
      
      public ByteString getSetEventToLogBytes() {
        return ((FirebaseAbt.ExperimentPayload)this.instance).getSetEventToLogBytes();
      }
      
      public long getTimeToLiveMillis() {
        return ((FirebaseAbt.ExperimentPayload)this.instance).getTimeToLiveMillis();
      }
      
      public String getTimeoutEventToLog() {
        return ((FirebaseAbt.ExperimentPayload)this.instance).getTimeoutEventToLog();
      }
      
      public ByteString getTimeoutEventToLogBytes() {
        return ((FirebaseAbt.ExperimentPayload)this.instance).getTimeoutEventToLogBytes();
      }
      
      public String getTriggerEvent() {
        return ((FirebaseAbt.ExperimentPayload)this.instance).getTriggerEvent();
      }
      
      public ByteString getTriggerEventBytes() {
        return ((FirebaseAbt.ExperimentPayload)this.instance).getTriggerEventBytes();
      }
      
      public long getTriggerTimeoutMillis() {
        return ((FirebaseAbt.ExperimentPayload)this.instance).getTriggerTimeoutMillis();
      }
      
      public String getTtlExpiryEventToLog() {
        return ((FirebaseAbt.ExperimentPayload)this.instance).getTtlExpiryEventToLog();
      }
      
      public ByteString getTtlExpiryEventToLogBytes() {
        return ((FirebaseAbt.ExperimentPayload)this.instance).getTtlExpiryEventToLogBytes();
      }
      
      public String getVariantId() {
        return ((FirebaseAbt.ExperimentPayload)this.instance).getVariantId();
      }
      
      public ByteString getVariantIdBytes() {
        return ((FirebaseAbt.ExperimentPayload)this.instance).getVariantIdBytes();
      }
      
      public Builder removeOngoingExperiments(int param2Int) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).removeOngoingExperiments(param2Int);
        return this;
      }
      
      public Builder setActivateEventToLog(String param2String) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).setActivateEventToLog(param2String);
        return this;
      }
      
      public Builder setActivateEventToLogBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).setActivateEventToLogBytes(param2ByteString);
        return this;
      }
      
      public Builder setClearEventToLog(String param2String) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).setClearEventToLog(param2String);
        return this;
      }
      
      public Builder setClearEventToLogBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).setClearEventToLogBytes(param2ByteString);
        return this;
      }
      
      public Builder setExperimentId(String param2String) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).setExperimentId(param2String);
        return this;
      }
      
      public Builder setExperimentIdBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).setExperimentIdBytes(param2ByteString);
        return this;
      }
      
      public Builder setExperimentStartTimeMillis(long param2Long) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).setExperimentStartTimeMillis(param2Long);
        return this;
      }
      
      public Builder setOngoingExperiments(int param2Int, FirebaseAbt.ExperimentLite.Builder param2Builder) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).setOngoingExperiments(param2Int, param2Builder);
        return this;
      }
      
      public Builder setOngoingExperiments(int param2Int, FirebaseAbt.ExperimentLite param2ExperimentLite) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).setOngoingExperiments(param2Int, param2ExperimentLite);
        return this;
      }
      
      public Builder setOverflowPolicy(FirebaseAbt.ExperimentPayload.ExperimentOverflowPolicy param2ExperimentOverflowPolicy) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).setOverflowPolicy(param2ExperimentOverflowPolicy);
        return this;
      }
      
      public Builder setOverflowPolicyValue(int param2Int) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).setOverflowPolicyValue(param2Int);
        return this;
      }
      
      public Builder setSetEventToLog(String param2String) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).setSetEventToLog(param2String);
        return this;
      }
      
      public Builder setSetEventToLogBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).setSetEventToLogBytes(param2ByteString);
        return this;
      }
      
      public Builder setTimeToLiveMillis(long param2Long) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).setTimeToLiveMillis(param2Long);
        return this;
      }
      
      public Builder setTimeoutEventToLog(String param2String) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).setTimeoutEventToLog(param2String);
        return this;
      }
      
      public Builder setTimeoutEventToLogBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).setTimeoutEventToLogBytes(param2ByteString);
        return this;
      }
      
      public Builder setTriggerEvent(String param2String) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).setTriggerEvent(param2String);
        return this;
      }
      
      public Builder setTriggerEventBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).setTriggerEventBytes(param2ByteString);
        return this;
      }
      
      public Builder setTriggerTimeoutMillis(long param2Long) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).setTriggerTimeoutMillis(param2Long);
        return this;
      }
      
      public Builder setTtlExpiryEventToLog(String param2String) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).setTtlExpiryEventToLog(param2String);
        return this;
      }
      
      public Builder setTtlExpiryEventToLogBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).setTtlExpiryEventToLogBytes(param2ByteString);
        return this;
      }
      
      public Builder setVariantId(String param2String) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).setVariantId(param2String);
        return this;
      }
      
      public Builder setVariantIdBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((FirebaseAbt.ExperimentPayload)this.instance).setVariantIdBytes(param2ByteString);
        return this;
      }
    }
    
    public enum ExperimentOverflowPolicy implements Internal.EnumLite {
      DISCARD_OLDEST,
      IGNORE_NEWEST,
      POLICY_UNSPECIFIED(0),
      UNRECOGNIZED(0);
      
      public static final int DISCARD_OLDEST_VALUE = 1;
      
      public static final int IGNORE_NEWEST_VALUE = 2;
      
      public static final int POLICY_UNSPECIFIED_VALUE = 0;
      
      private static final Internal.EnumLiteMap<ExperimentOverflowPolicy> internalValueMap = new Internal.EnumLiteMap<ExperimentOverflowPolicy>() {
          public FirebaseAbt.ExperimentPayload.ExperimentOverflowPolicy findValueByNumber(int param3Int) {
            return FirebaseAbt.ExperimentPayload.ExperimentOverflowPolicy.forNumber(param3Int);
          }
        };
      
      private final int value;
      
      static {
      
      }
      
      ExperimentOverflowPolicy(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static ExperimentOverflowPolicy forNumber(int param2Int) {
        switch (param2Int) {
          default:
            return null;
          case 2:
            return IGNORE_NEWEST;
          case 1:
            return DISCARD_OLDEST;
          case 0:
            break;
        } 
        return POLICY_UNSPECIFIED;
      }
      
      public static Internal.EnumLiteMap<ExperimentOverflowPolicy> internalGetValueMap() {
        return internalValueMap;
      }
      
      public final int getNumber() {
        return this.value;
      }
    }
    
    class null implements Internal.EnumLiteMap<ExperimentOverflowPolicy> {
      public FirebaseAbt.ExperimentPayload.ExperimentOverflowPolicy findValueByNumber(int param2Int) {
        return FirebaseAbt.ExperimentPayload.ExperimentOverflowPolicy.forNumber(param2Int);
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ExperimentPayload, ExperimentPayload.Builder> implements ExperimentPayloadOrBuilder {
    private Builder() {
      super(FirebaseAbt.ExperimentPayload.DEFAULT_INSTANCE);
    }
    
    public Builder addAllOngoingExperiments(Iterable<? extends FirebaseAbt.ExperimentLite> param1Iterable) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).addAllOngoingExperiments(param1Iterable);
      return this;
    }
    
    public Builder addOngoingExperiments(int param1Int, FirebaseAbt.ExperimentLite.Builder param1Builder) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).addOngoingExperiments(param1Int, param1Builder);
      return this;
    }
    
    public Builder addOngoingExperiments(int param1Int, FirebaseAbt.ExperimentLite param1ExperimentLite) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).addOngoingExperiments(param1Int, param1ExperimentLite);
      return this;
    }
    
    public Builder addOngoingExperiments(FirebaseAbt.ExperimentLite.Builder param1Builder) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).addOngoingExperiments(param1Builder);
      return this;
    }
    
    public Builder addOngoingExperiments(FirebaseAbt.ExperimentLite param1ExperimentLite) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).addOngoingExperiments(param1ExperimentLite);
      return this;
    }
    
    public Builder clearActivateEventToLog() {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).clearActivateEventToLog();
      return this;
    }
    
    public Builder clearClearEventToLog() {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).clearClearEventToLog();
      return this;
    }
    
    public Builder clearExperimentId() {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).clearExperimentId();
      return this;
    }
    
    public Builder clearExperimentStartTimeMillis() {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).clearExperimentStartTimeMillis();
      return this;
    }
    
    public Builder clearOngoingExperiments() {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).clearOngoingExperiments();
      return this;
    }
    
    public Builder clearOverflowPolicy() {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).clearOverflowPolicy();
      return this;
    }
    
    public Builder clearSetEventToLog() {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).clearSetEventToLog();
      return this;
    }
    
    public Builder clearTimeToLiveMillis() {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).clearTimeToLiveMillis();
      return this;
    }
    
    public Builder clearTimeoutEventToLog() {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).clearTimeoutEventToLog();
      return this;
    }
    
    public Builder clearTriggerEvent() {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).clearTriggerEvent();
      return this;
    }
    
    public Builder clearTriggerTimeoutMillis() {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).clearTriggerTimeoutMillis();
      return this;
    }
    
    public Builder clearTtlExpiryEventToLog() {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).clearTtlExpiryEventToLog();
      return this;
    }
    
    public Builder clearVariantId() {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).clearVariantId();
      return this;
    }
    
    public String getActivateEventToLog() {
      return ((FirebaseAbt.ExperimentPayload)this.instance).getActivateEventToLog();
    }
    
    public ByteString getActivateEventToLogBytes() {
      return ((FirebaseAbt.ExperimentPayload)this.instance).getActivateEventToLogBytes();
    }
    
    public String getClearEventToLog() {
      return ((FirebaseAbt.ExperimentPayload)this.instance).getClearEventToLog();
    }
    
    public ByteString getClearEventToLogBytes() {
      return ((FirebaseAbt.ExperimentPayload)this.instance).getClearEventToLogBytes();
    }
    
    public String getExperimentId() {
      return ((FirebaseAbt.ExperimentPayload)this.instance).getExperimentId();
    }
    
    public ByteString getExperimentIdBytes() {
      return ((FirebaseAbt.ExperimentPayload)this.instance).getExperimentIdBytes();
    }
    
    public long getExperimentStartTimeMillis() {
      return ((FirebaseAbt.ExperimentPayload)this.instance).getExperimentStartTimeMillis();
    }
    
    public FirebaseAbt.ExperimentLite getOngoingExperiments(int param1Int) {
      return ((FirebaseAbt.ExperimentPayload)this.instance).getOngoingExperiments(param1Int);
    }
    
    public int getOngoingExperimentsCount() {
      return ((FirebaseAbt.ExperimentPayload)this.instance).getOngoingExperimentsCount();
    }
    
    public List<FirebaseAbt.ExperimentLite> getOngoingExperimentsList() {
      return Collections.unmodifiableList(((FirebaseAbt.ExperimentPayload)this.instance).getOngoingExperimentsList());
    }
    
    public FirebaseAbt.ExperimentPayload.ExperimentOverflowPolicy getOverflowPolicy() {
      return ((FirebaseAbt.ExperimentPayload)this.instance).getOverflowPolicy();
    }
    
    public int getOverflowPolicyValue() {
      return ((FirebaseAbt.ExperimentPayload)this.instance).getOverflowPolicyValue();
    }
    
    public String getSetEventToLog() {
      return ((FirebaseAbt.ExperimentPayload)this.instance).getSetEventToLog();
    }
    
    public ByteString getSetEventToLogBytes() {
      return ((FirebaseAbt.ExperimentPayload)this.instance).getSetEventToLogBytes();
    }
    
    public long getTimeToLiveMillis() {
      return ((FirebaseAbt.ExperimentPayload)this.instance).getTimeToLiveMillis();
    }
    
    public String getTimeoutEventToLog() {
      return ((FirebaseAbt.ExperimentPayload)this.instance).getTimeoutEventToLog();
    }
    
    public ByteString getTimeoutEventToLogBytes() {
      return ((FirebaseAbt.ExperimentPayload)this.instance).getTimeoutEventToLogBytes();
    }
    
    public String getTriggerEvent() {
      return ((FirebaseAbt.ExperimentPayload)this.instance).getTriggerEvent();
    }
    
    public ByteString getTriggerEventBytes() {
      return ((FirebaseAbt.ExperimentPayload)this.instance).getTriggerEventBytes();
    }
    
    public long getTriggerTimeoutMillis() {
      return ((FirebaseAbt.ExperimentPayload)this.instance).getTriggerTimeoutMillis();
    }
    
    public String getTtlExpiryEventToLog() {
      return ((FirebaseAbt.ExperimentPayload)this.instance).getTtlExpiryEventToLog();
    }
    
    public ByteString getTtlExpiryEventToLogBytes() {
      return ((FirebaseAbt.ExperimentPayload)this.instance).getTtlExpiryEventToLogBytes();
    }
    
    public String getVariantId() {
      return ((FirebaseAbt.ExperimentPayload)this.instance).getVariantId();
    }
    
    public ByteString getVariantIdBytes() {
      return ((FirebaseAbt.ExperimentPayload)this.instance).getVariantIdBytes();
    }
    
    public Builder removeOngoingExperiments(int param1Int) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).removeOngoingExperiments(param1Int);
      return this;
    }
    
    public Builder setActivateEventToLog(String param1String) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).setActivateEventToLog(param1String);
      return this;
    }
    
    public Builder setActivateEventToLogBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).setActivateEventToLogBytes(param1ByteString);
      return this;
    }
    
    public Builder setClearEventToLog(String param1String) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).setClearEventToLog(param1String);
      return this;
    }
    
    public Builder setClearEventToLogBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).setClearEventToLogBytes(param1ByteString);
      return this;
    }
    
    public Builder setExperimentId(String param1String) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).setExperimentId(param1String);
      return this;
    }
    
    public Builder setExperimentIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).setExperimentIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setExperimentStartTimeMillis(long param1Long) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).setExperimentStartTimeMillis(param1Long);
      return this;
    }
    
    public Builder setOngoingExperiments(int param1Int, FirebaseAbt.ExperimentLite.Builder param1Builder) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).setOngoingExperiments(param1Int, param1Builder);
      return this;
    }
    
    public Builder setOngoingExperiments(int param1Int, FirebaseAbt.ExperimentLite param1ExperimentLite) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).setOngoingExperiments(param1Int, param1ExperimentLite);
      return this;
    }
    
    public Builder setOverflowPolicy(FirebaseAbt.ExperimentPayload.ExperimentOverflowPolicy param1ExperimentOverflowPolicy) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).setOverflowPolicy(param1ExperimentOverflowPolicy);
      return this;
    }
    
    public Builder setOverflowPolicyValue(int param1Int) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).setOverflowPolicyValue(param1Int);
      return this;
    }
    
    public Builder setSetEventToLog(String param1String) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).setSetEventToLog(param1String);
      return this;
    }
    
    public Builder setSetEventToLogBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).setSetEventToLogBytes(param1ByteString);
      return this;
    }
    
    public Builder setTimeToLiveMillis(long param1Long) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).setTimeToLiveMillis(param1Long);
      return this;
    }
    
    public Builder setTimeoutEventToLog(String param1String) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).setTimeoutEventToLog(param1String);
      return this;
    }
    
    public Builder setTimeoutEventToLogBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).setTimeoutEventToLogBytes(param1ByteString);
      return this;
    }
    
    public Builder setTriggerEvent(String param1String) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).setTriggerEvent(param1String);
      return this;
    }
    
    public Builder setTriggerEventBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).setTriggerEventBytes(param1ByteString);
      return this;
    }
    
    public Builder setTriggerTimeoutMillis(long param1Long) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).setTriggerTimeoutMillis(param1Long);
      return this;
    }
    
    public Builder setTtlExpiryEventToLog(String param1String) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).setTtlExpiryEventToLog(param1String);
      return this;
    }
    
    public Builder setTtlExpiryEventToLogBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).setTtlExpiryEventToLogBytes(param1ByteString);
      return this;
    }
    
    public Builder setVariantId(String param1String) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).setVariantId(param1String);
      return this;
    }
    
    public Builder setVariantIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((FirebaseAbt.ExperimentPayload)this.instance).setVariantIdBytes(param1ByteString);
      return this;
    }
  }
  
  public enum ExperimentOverflowPolicy implements Internal.EnumLite {
    DISCARD_OLDEST(0),
    IGNORE_NEWEST(0),
    POLICY_UNSPECIFIED(0),
    UNRECOGNIZED(0);
    
    public static final int DISCARD_OLDEST_VALUE = 1;
    
    public static final int IGNORE_NEWEST_VALUE = 2;
    
    public static final int POLICY_UNSPECIFIED_VALUE = 0;
    
    private static final Internal.EnumLiteMap<ExperimentOverflowPolicy> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new ExperimentOverflowPolicy[] { POLICY_UNSPECIFIED, DISCARD_OLDEST, IGNORE_NEWEST, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<ExperimentOverflowPolicy>() {
          public FirebaseAbt.ExperimentPayload.ExperimentOverflowPolicy findValueByNumber(int param3Int) {
            return FirebaseAbt.ExperimentPayload.ExperimentOverflowPolicy.forNumber(param3Int);
          }
        };
    }
    
    ExperimentOverflowPolicy(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ExperimentOverflowPolicy forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 2:
          return IGNORE_NEWEST;
        case 1:
          return DISCARD_OLDEST;
        case 0:
          break;
      } 
      return POLICY_UNSPECIFIED;
    }
    
    public static Internal.EnumLiteMap<ExperimentOverflowPolicy> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<ExperimentPayload.ExperimentOverflowPolicy> {
    public FirebaseAbt.ExperimentPayload.ExperimentOverflowPolicy findValueByNumber(int param1Int) {
      return FirebaseAbt.ExperimentPayload.ExperimentOverflowPolicy.forNumber(param1Int);
    }
  }
  
  public static interface ExperimentPayloadOrBuilder extends MessageLiteOrBuilder {
    String getActivateEventToLog();
    
    ByteString getActivateEventToLogBytes();
    
    String getClearEventToLog();
    
    ByteString getClearEventToLogBytes();
    
    String getExperimentId();
    
    ByteString getExperimentIdBytes();
    
    long getExperimentStartTimeMillis();
    
    FirebaseAbt.ExperimentLite getOngoingExperiments(int param1Int);
    
    int getOngoingExperimentsCount();
    
    List<FirebaseAbt.ExperimentLite> getOngoingExperimentsList();
    
    FirebaseAbt.ExperimentPayload.ExperimentOverflowPolicy getOverflowPolicy();
    
    int getOverflowPolicyValue();
    
    String getSetEventToLog();
    
    ByteString getSetEventToLogBytes();
    
    long getTimeToLiveMillis();
    
    String getTimeoutEventToLog();
    
    ByteString getTimeoutEventToLogBytes();
    
    String getTriggerEvent();
    
    ByteString getTriggerEventBytes();
    
    long getTriggerTimeoutMillis();
    
    String getTtlExpiryEventToLog();
    
    ByteString getTtlExpiryEventToLogBytes();
    
    String getVariantId();
    
    ByteString getVariantIdBytes();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\developers\mobile\abt\FirebaseAbt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */