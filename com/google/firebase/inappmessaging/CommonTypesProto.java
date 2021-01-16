package com.google.firebase.inappmessaging;

import analytics_collection.GmpMeasurement;
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
import com.google.type.Date;
import com.google.type.TimeOfDay;
import java.io.IOException;
import java.io.InputStream;

public final class CommonTypesProto {
  static {
  
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public enum CampaignState implements Internal.EnumLite {
    DELETED,
    DRAFT,
    PUBLISHED,
    STOPPED,
    UNKNOWN_CAMPAIGN_STATE(0),
    UNRECOGNIZED(0);
    
    public static final int DELETED_VALUE = 4;
    
    public static final int DRAFT_VALUE = 1;
    
    public static final int PUBLISHED_VALUE = 2;
    
    public static final int STOPPED_VALUE = 3;
    
    public static final int UNKNOWN_CAMPAIGN_STATE_VALUE = 0;
    
    private static final Internal.EnumLiteMap<CampaignState> internalValueMap;
    
    private final int value;
    
    static {
      DELETED = new CampaignState("DELETED", 4, 4);
      UNRECOGNIZED = new CampaignState("UNRECOGNIZED", 5, -1);
      $VALUES = new CampaignState[] { UNKNOWN_CAMPAIGN_STATE, DRAFT, PUBLISHED, STOPPED, DELETED, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<CampaignState>() {
          public CommonTypesProto.CampaignState findValueByNumber(int param2Int) {
            return CommonTypesProto.CampaignState.forNumber(param2Int);
          }
        };
    }
    
    CampaignState(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static CampaignState forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 4:
          return DELETED;
        case 3:
          return STOPPED;
        case 2:
          return PUBLISHED;
        case 1:
          return DRAFT;
        case 0:
          break;
      } 
      return UNKNOWN_CAMPAIGN_STATE;
    }
    
    public static Internal.EnumLiteMap<CampaignState> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<CampaignState> {
    public CommonTypesProto.CampaignState findValueByNumber(int param1Int) {
      return CommonTypesProto.CampaignState.forNumber(param1Int);
    }
  }
  
  public static final class CampaignTime extends GeneratedMessageLite<CampaignTime, CampaignTime.Builder> implements CampaignTimeOrBuilder {
    public static final int DATE_FIELD_NUMBER = 1;
    
    private static final CampaignTime DEFAULT_INSTANCE = new CampaignTime();
    
    private static volatile Parser<CampaignTime> PARSER;
    
    public static final int TIME_FIELD_NUMBER = 2;
    
    public static final int TIME_ZONE_FIELD_NUMBER = 3;
    
    private Date date_;
    
    private String timeZone_ = "";
    
    private TimeOfDay time_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearDate() {
      this.date_ = null;
    }
    
    private void clearTime() {
      this.time_ = null;
    }
    
    private void clearTimeZone() {
      this.timeZone_ = getDefaultInstance().getTimeZone();
    }
    
    public static CampaignTime getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeDate(Date param1Date) {
      Date date = this.date_;
      if (date != null && date != Date.getDefaultInstance()) {
        this.date_ = (Date)((Date.Builder)Date.newBuilder(this.date_).mergeFrom((GeneratedMessageLite)param1Date)).buildPartial();
      } else {
        this.date_ = param1Date;
      } 
    }
    
    private void mergeTime(TimeOfDay param1TimeOfDay) {
      TimeOfDay timeOfDay = this.time_;
      if (timeOfDay != null && timeOfDay != TimeOfDay.getDefaultInstance()) {
        this.time_ = (TimeOfDay)((TimeOfDay.Builder)TimeOfDay.newBuilder(this.time_).mergeFrom((GeneratedMessageLite)param1TimeOfDay)).buildPartial();
      } else {
        this.time_ = param1TimeOfDay;
      } 
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(CampaignTime param1CampaignTime) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1CampaignTime);
    }
    
    public static CampaignTime parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (CampaignTime)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static CampaignTime parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CampaignTime)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static CampaignTime parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (CampaignTime)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static CampaignTime parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CampaignTime)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static CampaignTime parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (CampaignTime)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static CampaignTime parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CampaignTime)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static CampaignTime parseFrom(InputStream param1InputStream) throws IOException {
      return (CampaignTime)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static CampaignTime parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CampaignTime)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static CampaignTime parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (CampaignTime)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static CampaignTime parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CampaignTime)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<CampaignTime> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setDate(Date.Builder param1Builder) {
      this.date_ = (Date)param1Builder.build();
    }
    
    private void setDate(Date param1Date) {
      if (param1Date != null) {
        this.date_ = param1Date;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTime(TimeOfDay.Builder param1Builder) {
      this.time_ = (TimeOfDay)param1Builder.build();
    }
    
    private void setTime(TimeOfDay param1TimeOfDay) {
      if (param1TimeOfDay != null) {
        this.time_ = param1TimeOfDay;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTimeZone(String param1String) {
      if (param1String != null) {
        this.timeZone_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTimeZoneBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.timeZone_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firebase/inappmessaging/CommonTypesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 485, 2 -> 481, 3 -> 479, 4 -> 470, 5 -> 376, 6 -> 110, 7 -> 372, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime
      //   72: monitorenter
      //   73: getstatic com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 372
      //   128: aload_2
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 316
      //   139: iload #5
      //   141: bipush #10
      //   143: if_icmpeq -> 251
      //   146: iload #5
      //   148: bipush #18
      //   150: if_icmpeq -> 186
      //   153: iload #5
      //   155: bipush #26
      //   157: if_icmpeq -> 175
      //   160: aload_2
      //   161: iload #5
      //   163: invokevirtual skipField : (I)Z
      //   166: ifne -> 123
      //   169: iconst_1
      //   170: istore #4
      //   172: goto -> 123
      //   175: aload_0
      //   176: aload_2
      //   177: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   180: putfield timeZone_ : Ljava/lang/String;
      //   183: goto -> 123
      //   186: aload_0
      //   187: getfield time_ : Lcom/google/type/TimeOfDay;
      //   190: ifnull -> 207
      //   193: aload_0
      //   194: getfield time_ : Lcom/google/type/TimeOfDay;
      //   197: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   200: checkcast com/google/type/TimeOfDay$Builder
      //   203: astore_1
      //   204: goto -> 209
      //   207: aconst_null
      //   208: astore_1
      //   209: aload_0
      //   210: aload_2
      //   211: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   214: aload_3
      //   215: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   218: checkcast com/google/type/TimeOfDay
      //   221: putfield time_ : Lcom/google/type/TimeOfDay;
      //   224: aload_1
      //   225: ifnull -> 123
      //   228: aload_1
      //   229: aload_0
      //   230: getfield time_ : Lcom/google/type/TimeOfDay;
      //   233: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   236: pop
      //   237: aload_0
      //   238: aload_1
      //   239: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   242: checkcast com/google/type/TimeOfDay
      //   245: putfield time_ : Lcom/google/type/TimeOfDay;
      //   248: goto -> 123
      //   251: aload_0
      //   252: getfield date_ : Lcom/google/type/Date;
      //   255: ifnull -> 272
      //   258: aload_0
      //   259: getfield date_ : Lcom/google/type/Date;
      //   262: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   265: checkcast com/google/type/Date$Builder
      //   268: astore_1
      //   269: goto -> 274
      //   272: aconst_null
      //   273: astore_1
      //   274: aload_0
      //   275: aload_2
      //   276: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   279: aload_3
      //   280: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   283: checkcast com/google/type/Date
      //   286: putfield date_ : Lcom/google/type/Date;
      //   289: aload_1
      //   290: ifnull -> 123
      //   293: aload_1
      //   294: aload_0
      //   295: getfield date_ : Lcom/google/type/Date;
      //   298: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   301: pop
      //   302: aload_0
      //   303: aload_1
      //   304: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   307: checkcast com/google/type/Date
      //   310: putfield date_ : Lcom/google/type/Date;
      //   313: goto -> 123
      //   316: iconst_1
      //   317: istore #4
      //   319: goto -> 123
      //   322: astore_1
      //   323: goto -> 370
      //   326: astore_2
      //   327: new java/lang/RuntimeException
      //   330: astore_3
      //   331: new com/google/protobuf/InvalidProtocolBufferException
      //   334: astore_1
      //   335: aload_1
      //   336: aload_2
      //   337: invokevirtual getMessage : ()Ljava/lang/String;
      //   340: invokespecial <init> : (Ljava/lang/String;)V
      //   343: aload_3
      //   344: aload_1
      //   345: aload_0
      //   346: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   349: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   352: aload_3
      //   353: athrow
      //   354: astore_2
      //   355: new java/lang/RuntimeException
      //   358: astore_1
      //   359: aload_1
      //   360: aload_2
      //   361: aload_0
      //   362: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   365: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   368: aload_1
      //   369: athrow
      //   370: aload_1
      //   371: athrow
      //   372: getstatic com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   375: areturn
      //   376: aload_2
      //   377: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   380: astore_1
      //   381: aload_3
      //   382: checkcast com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime
      //   385: astore_2
      //   386: aload_0
      //   387: aload_1
      //   388: aload_0
      //   389: getfield date_ : Lcom/google/type/Date;
      //   392: aload_2
      //   393: getfield date_ : Lcom/google/type/Date;
      //   396: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   401: checkcast com/google/type/Date
      //   404: putfield date_ : Lcom/google/type/Date;
      //   407: aload_0
      //   408: aload_1
      //   409: aload_0
      //   410: getfield time_ : Lcom/google/type/TimeOfDay;
      //   413: aload_2
      //   414: getfield time_ : Lcom/google/type/TimeOfDay;
      //   417: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   422: checkcast com/google/type/TimeOfDay
      //   425: putfield time_ : Lcom/google/type/TimeOfDay;
      //   428: aload_0
      //   429: aload_1
      //   430: aload_0
      //   431: getfield timeZone_ : Ljava/lang/String;
      //   434: invokevirtual isEmpty : ()Z
      //   437: iconst_1
      //   438: ixor
      //   439: aload_0
      //   440: getfield timeZone_ : Ljava/lang/String;
      //   443: iconst_1
      //   444: aload_2
      //   445: getfield timeZone_ : Ljava/lang/String;
      //   448: invokevirtual isEmpty : ()Z
      //   451: ixor
      //   452: aload_2
      //   453: getfield timeZone_ : Ljava/lang/String;
      //   456: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   461: putfield timeZone_ : Ljava/lang/String;
      //   464: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   467: astore_1
      //   468: aload_0
      //   469: areturn
      //   470: new com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime$Builder
      //   473: dup
      //   474: aconst_null
      //   475: invokespecial <init> : (Lcom/google/firebase/inappmessaging/CommonTypesProto$1;)V
      //   478: areturn
      //   479: aconst_null
      //   480: areturn
      //   481: getstatic com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/CommonTypesProto$CampaignTime;
      //   484: areturn
      //   485: new com/google/firebase/inappmessaging/CommonTypesProto$CampaignTime
      //   488: dup
      //   489: invokespecial <init> : ()V
      //   492: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	354	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	326	java/io/IOException
      //   128	134	322	finally
      //   160	169	354	com/google/protobuf/InvalidProtocolBufferException
      //   160	169	326	java/io/IOException
      //   160	169	322	finally
      //   175	183	354	com/google/protobuf/InvalidProtocolBufferException
      //   175	183	326	java/io/IOException
      //   175	183	322	finally
      //   186	204	354	com/google/protobuf/InvalidProtocolBufferException
      //   186	204	326	java/io/IOException
      //   186	204	322	finally
      //   209	224	354	com/google/protobuf/InvalidProtocolBufferException
      //   209	224	326	java/io/IOException
      //   209	224	322	finally
      //   228	248	354	com/google/protobuf/InvalidProtocolBufferException
      //   228	248	326	java/io/IOException
      //   228	248	322	finally
      //   251	269	354	com/google/protobuf/InvalidProtocolBufferException
      //   251	269	326	java/io/IOException
      //   251	269	322	finally
      //   274	289	354	com/google/protobuf/InvalidProtocolBufferException
      //   274	289	326	java/io/IOException
      //   274	289	322	finally
      //   293	313	354	com/google/protobuf/InvalidProtocolBufferException
      //   293	313	326	java/io/IOException
      //   293	313	322	finally
      //   327	354	322	finally
      //   355	370	322	finally
    }
    
    public Date getDate() {
      Date date1 = this.date_;
      Date date2 = date1;
      if (date1 == null)
        date2 = Date.getDefaultInstance(); 
      return date2;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.date_ != null)
        j = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)getDate()); 
      i = j;
      if (this.time_ != null)
        i = j + CodedOutputStream.computeMessageSize(2, (MessageLite)getTime()); 
      j = i;
      if (!this.timeZone_.isEmpty())
        j = i + CodedOutputStream.computeStringSize(3, getTimeZone()); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public TimeOfDay getTime() {
      TimeOfDay timeOfDay1 = this.time_;
      TimeOfDay timeOfDay2 = timeOfDay1;
      if (timeOfDay1 == null)
        timeOfDay2 = TimeOfDay.getDefaultInstance(); 
      return timeOfDay2;
    }
    
    public String getTimeZone() {
      return this.timeZone_;
    }
    
    public ByteString getTimeZoneBytes() {
      return ByteString.copyFromUtf8(this.timeZone_);
    }
    
    public boolean hasDate() {
      boolean bool;
      if (this.date_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasTime() {
      boolean bool;
      if (this.time_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.date_ != null)
        param1CodedOutputStream.writeMessage(1, (MessageLite)getDate()); 
      if (this.time_ != null)
        param1CodedOutputStream.writeMessage(2, (MessageLite)getTime()); 
      if (!this.timeZone_.isEmpty())
        param1CodedOutputStream.writeString(3, getTimeZone()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<CampaignTime, Builder> implements CommonTypesProto.CampaignTimeOrBuilder {
      private Builder() {
        super(CommonTypesProto.CampaignTime.DEFAULT_INSTANCE);
      }
      
      public Builder clearDate() {
        copyOnWrite();
        ((CommonTypesProto.CampaignTime)this.instance).clearDate();
        return this;
      }
      
      public Builder clearTime() {
        copyOnWrite();
        ((CommonTypesProto.CampaignTime)this.instance).clearTime();
        return this;
      }
      
      public Builder clearTimeZone() {
        copyOnWrite();
        ((CommonTypesProto.CampaignTime)this.instance).clearTimeZone();
        return this;
      }
      
      public Date getDate() {
        return ((CommonTypesProto.CampaignTime)this.instance).getDate();
      }
      
      public TimeOfDay getTime() {
        return ((CommonTypesProto.CampaignTime)this.instance).getTime();
      }
      
      public String getTimeZone() {
        return ((CommonTypesProto.CampaignTime)this.instance).getTimeZone();
      }
      
      public ByteString getTimeZoneBytes() {
        return ((CommonTypesProto.CampaignTime)this.instance).getTimeZoneBytes();
      }
      
      public boolean hasDate() {
        return ((CommonTypesProto.CampaignTime)this.instance).hasDate();
      }
      
      public boolean hasTime() {
        return ((CommonTypesProto.CampaignTime)this.instance).hasTime();
      }
      
      public Builder mergeDate(Date param2Date) {
        copyOnWrite();
        ((CommonTypesProto.CampaignTime)this.instance).mergeDate(param2Date);
        return this;
      }
      
      public Builder mergeTime(TimeOfDay param2TimeOfDay) {
        copyOnWrite();
        ((CommonTypesProto.CampaignTime)this.instance).mergeTime(param2TimeOfDay);
        return this;
      }
      
      public Builder setDate(Date.Builder param2Builder) {
        copyOnWrite();
        ((CommonTypesProto.CampaignTime)this.instance).setDate(param2Builder);
        return this;
      }
      
      public Builder setDate(Date param2Date) {
        copyOnWrite();
        ((CommonTypesProto.CampaignTime)this.instance).setDate(param2Date);
        return this;
      }
      
      public Builder setTime(TimeOfDay.Builder param2Builder) {
        copyOnWrite();
        ((CommonTypesProto.CampaignTime)this.instance).setTime(param2Builder);
        return this;
      }
      
      public Builder setTime(TimeOfDay param2TimeOfDay) {
        copyOnWrite();
        ((CommonTypesProto.CampaignTime)this.instance).setTime(param2TimeOfDay);
        return this;
      }
      
      public Builder setTimeZone(String param2String) {
        copyOnWrite();
        ((CommonTypesProto.CampaignTime)this.instance).setTimeZone(param2String);
        return this;
      }
      
      public Builder setTimeZoneBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((CommonTypesProto.CampaignTime)this.instance).setTimeZoneBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<CampaignTime, CampaignTime.Builder> implements CampaignTimeOrBuilder {
    private Builder() {
      super(CommonTypesProto.CampaignTime.DEFAULT_INSTANCE);
    }
    
    public Builder clearDate() {
      copyOnWrite();
      ((CommonTypesProto.CampaignTime)this.instance).clearDate();
      return this;
    }
    
    public Builder clearTime() {
      copyOnWrite();
      ((CommonTypesProto.CampaignTime)this.instance).clearTime();
      return this;
    }
    
    public Builder clearTimeZone() {
      copyOnWrite();
      ((CommonTypesProto.CampaignTime)this.instance).clearTimeZone();
      return this;
    }
    
    public Date getDate() {
      return ((CommonTypesProto.CampaignTime)this.instance).getDate();
    }
    
    public TimeOfDay getTime() {
      return ((CommonTypesProto.CampaignTime)this.instance).getTime();
    }
    
    public String getTimeZone() {
      return ((CommonTypesProto.CampaignTime)this.instance).getTimeZone();
    }
    
    public ByteString getTimeZoneBytes() {
      return ((CommonTypesProto.CampaignTime)this.instance).getTimeZoneBytes();
    }
    
    public boolean hasDate() {
      return ((CommonTypesProto.CampaignTime)this.instance).hasDate();
    }
    
    public boolean hasTime() {
      return ((CommonTypesProto.CampaignTime)this.instance).hasTime();
    }
    
    public Builder mergeDate(Date param1Date) {
      copyOnWrite();
      ((CommonTypesProto.CampaignTime)this.instance).mergeDate(param1Date);
      return this;
    }
    
    public Builder mergeTime(TimeOfDay param1TimeOfDay) {
      copyOnWrite();
      ((CommonTypesProto.CampaignTime)this.instance).mergeTime(param1TimeOfDay);
      return this;
    }
    
    public Builder setDate(Date.Builder param1Builder) {
      copyOnWrite();
      ((CommonTypesProto.CampaignTime)this.instance).setDate(param1Builder);
      return this;
    }
    
    public Builder setDate(Date param1Date) {
      copyOnWrite();
      ((CommonTypesProto.CampaignTime)this.instance).setDate(param1Date);
      return this;
    }
    
    public Builder setTime(TimeOfDay.Builder param1Builder) {
      copyOnWrite();
      ((CommonTypesProto.CampaignTime)this.instance).setTime(param1Builder);
      return this;
    }
    
    public Builder setTime(TimeOfDay param1TimeOfDay) {
      copyOnWrite();
      ((CommonTypesProto.CampaignTime)this.instance).setTime(param1TimeOfDay);
      return this;
    }
    
    public Builder setTimeZone(String param1String) {
      copyOnWrite();
      ((CommonTypesProto.CampaignTime)this.instance).setTimeZone(param1String);
      return this;
    }
    
    public Builder setTimeZoneBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((CommonTypesProto.CampaignTime)this.instance).setTimeZoneBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface CampaignTimeOrBuilder extends MessageLiteOrBuilder {
    Date getDate();
    
    TimeOfDay getTime();
    
    String getTimeZone();
    
    ByteString getTimeZoneBytes();
    
    boolean hasDate();
    
    boolean hasTime();
  }
  
  public static final class DailyAnalyticsSummary extends GeneratedMessageLite<DailyAnalyticsSummary, DailyAnalyticsSummary.Builder> implements DailyAnalyticsSummaryOrBuilder {
    public static final int CLICKS_FIELD_NUMBER = 3;
    
    private static final DailyAnalyticsSummary DEFAULT_INSTANCE = new DailyAnalyticsSummary();
    
    public static final int ERRORS_FIELD_NUMBER = 4;
    
    public static final int IMPRESSIONS_FIELD_NUMBER = 2;
    
    private static volatile Parser<DailyAnalyticsSummary> PARSER;
    
    public static final int START_OF_DAY_MILLIS_FIELD_NUMBER = 1;
    
    private int clicks_;
    
    private int errors_;
    
    private int impressions_;
    
    private long startOfDayMillis_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearClicks() {
      this.clicks_ = 0;
    }
    
    private void clearErrors() {
      this.errors_ = 0;
    }
    
    private void clearImpressions() {
      this.impressions_ = 0;
    }
    
    private void clearStartOfDayMillis() {
      this.startOfDayMillis_ = 0L;
    }
    
    public static DailyAnalyticsSummary getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(DailyAnalyticsSummary param1DailyAnalyticsSummary) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1DailyAnalyticsSummary);
    }
    
    public static DailyAnalyticsSummary parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (DailyAnalyticsSummary)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static DailyAnalyticsSummary parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (DailyAnalyticsSummary)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static DailyAnalyticsSummary parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (DailyAnalyticsSummary)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static DailyAnalyticsSummary parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (DailyAnalyticsSummary)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static DailyAnalyticsSummary parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (DailyAnalyticsSummary)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static DailyAnalyticsSummary parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (DailyAnalyticsSummary)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static DailyAnalyticsSummary parseFrom(InputStream param1InputStream) throws IOException {
      return (DailyAnalyticsSummary)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static DailyAnalyticsSummary parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (DailyAnalyticsSummary)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static DailyAnalyticsSummary parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (DailyAnalyticsSummary)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static DailyAnalyticsSummary parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (DailyAnalyticsSummary)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<DailyAnalyticsSummary> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setClicks(int param1Int) {
      this.clicks_ = param1Int;
    }
    
    private void setErrors(int param1Int) {
      this.errors_ = param1Int;
    }
    
    private void setImpressions(int param1Int) {
      this.impressions_ = param1Int;
    }
    
    private void setStartOfDayMillis(long param1Long) {
      this.startOfDayMillis_ = param1Long;
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firebase/inappmessaging/CommonTypesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: istore #4
      //   10: iconst_0
      //   11: istore #5
      //   13: iconst_0
      //   14: istore #6
      //   16: iload #4
      //   18: tableswitch default -> 64, 1 -> 556, 2 -> 552, 3 -> 550, 4 -> 541, 5 -> 291, 6 -> 118, 7 -> 287, 8 -> 72
      //   64: new java/lang/UnsupportedOperationException
      //   67: dup
      //   68: invokespecial <init> : ()V
      //   71: athrow
      //   72: getstatic com/google/firebase/inappmessaging/CommonTypesProto$DailyAnalyticsSummary.PARSER : Lcom/google/protobuf/Parser;
      //   75: ifnonnull -> 114
      //   78: ldc com/google/firebase/inappmessaging/CommonTypesProto$DailyAnalyticsSummary
      //   80: monitorenter
      //   81: getstatic com/google/firebase/inappmessaging/CommonTypesProto$DailyAnalyticsSummary.PARSER : Lcom/google/protobuf/Parser;
      //   84: ifnonnull -> 102
      //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   90: astore_1
      //   91: aload_1
      //   92: getstatic com/google/firebase/inappmessaging/CommonTypesProto$DailyAnalyticsSummary.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/CommonTypesProto$DailyAnalyticsSummary;
      //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   98: aload_1
      //   99: putstatic com/google/firebase/inappmessaging/CommonTypesProto$DailyAnalyticsSummary.PARSER : Lcom/google/protobuf/Parser;
      //   102: ldc com/google/firebase/inappmessaging/CommonTypesProto$DailyAnalyticsSummary
      //   104: monitorexit
      //   105: goto -> 114
      //   108: astore_1
      //   109: ldc com/google/firebase/inappmessaging/CommonTypesProto$DailyAnalyticsSummary
      //   111: monitorexit
      //   112: aload_1
      //   113: athrow
      //   114: getstatic com/google/firebase/inappmessaging/CommonTypesProto$DailyAnalyticsSummary.PARSER : Lcom/google/protobuf/Parser;
      //   117: areturn
      //   118: aload_2
      //   119: checkcast com/google/protobuf/CodedInputStream
      //   122: astore_1
      //   123: aload_3
      //   124: checkcast com/google/protobuf/ExtensionRegistryLite
      //   127: astore_2
      //   128: iload #6
      //   130: ifne -> 287
      //   133: aload_1
      //   134: invokevirtual readTag : ()I
      //   137: istore #4
      //   139: iload #4
      //   141: ifeq -> 231
      //   144: iload #4
      //   146: bipush #8
      //   148: if_icmpeq -> 220
      //   151: iload #4
      //   153: bipush #16
      //   155: if_icmpeq -> 209
      //   158: iload #4
      //   160: bipush #24
      //   162: if_icmpeq -> 198
      //   165: iload #4
      //   167: bipush #32
      //   169: if_icmpeq -> 187
      //   172: aload_1
      //   173: iload #4
      //   175: invokevirtual skipField : (I)Z
      //   178: ifne -> 128
      //   181: iconst_1
      //   182: istore #6
      //   184: goto -> 128
      //   187: aload_0
      //   188: aload_1
      //   189: invokevirtual readInt32 : ()I
      //   192: putfield errors_ : I
      //   195: goto -> 128
      //   198: aload_0
      //   199: aload_1
      //   200: invokevirtual readInt32 : ()I
      //   203: putfield clicks_ : I
      //   206: goto -> 128
      //   209: aload_0
      //   210: aload_1
      //   211: invokevirtual readInt32 : ()I
      //   214: putfield impressions_ : I
      //   217: goto -> 128
      //   220: aload_0
      //   221: aload_1
      //   222: invokevirtual readInt64 : ()J
      //   225: putfield startOfDayMillis_ : J
      //   228: goto -> 128
      //   231: iconst_1
      //   232: istore #6
      //   234: goto -> 128
      //   237: astore_1
      //   238: goto -> 285
      //   241: astore_2
      //   242: new java/lang/RuntimeException
      //   245: astore_3
      //   246: new com/google/protobuf/InvalidProtocolBufferException
      //   249: astore_1
      //   250: aload_1
      //   251: aload_2
      //   252: invokevirtual getMessage : ()Ljava/lang/String;
      //   255: invokespecial <init> : (Ljava/lang/String;)V
      //   258: aload_3
      //   259: aload_1
      //   260: aload_0
      //   261: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   264: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   267: aload_3
      //   268: athrow
      //   269: astore_1
      //   270: new java/lang/RuntimeException
      //   273: astore_2
      //   274: aload_2
      //   275: aload_1
      //   276: aload_0
      //   277: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   280: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   283: aload_2
      //   284: athrow
      //   285: aload_1
      //   286: athrow
      //   287: getstatic com/google/firebase/inappmessaging/CommonTypesProto$DailyAnalyticsSummary.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/CommonTypesProto$DailyAnalyticsSummary;
      //   290: areturn
      //   291: aload_2
      //   292: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   295: astore_1
      //   296: aload_3
      //   297: checkcast com/google/firebase/inappmessaging/CommonTypesProto$DailyAnalyticsSummary
      //   300: astore_2
      //   301: aload_0
      //   302: getfield startOfDayMillis_ : J
      //   305: lconst_0
      //   306: lcmp
      //   307: ifeq -> 316
      //   310: iconst_1
      //   311: istore #7
      //   313: goto -> 319
      //   316: iconst_0
      //   317: istore #7
      //   319: aload_0
      //   320: getfield startOfDayMillis_ : J
      //   323: lstore #8
      //   325: aload_2
      //   326: getfield startOfDayMillis_ : J
      //   329: lconst_0
      //   330: lcmp
      //   331: ifeq -> 340
      //   334: iconst_1
      //   335: istore #10
      //   337: goto -> 343
      //   340: iconst_0
      //   341: istore #10
      //   343: aload_0
      //   344: aload_1
      //   345: iload #7
      //   347: lload #8
      //   349: iload #10
      //   351: aload_2
      //   352: getfield startOfDayMillis_ : J
      //   355: invokeinterface visitLong : (ZJZJ)J
      //   360: putfield startOfDayMillis_ : J
      //   363: aload_0
      //   364: getfield impressions_ : I
      //   367: ifeq -> 376
      //   370: iconst_1
      //   371: istore #7
      //   373: goto -> 379
      //   376: iconst_0
      //   377: istore #7
      //   379: aload_0
      //   380: getfield impressions_ : I
      //   383: istore #6
      //   385: aload_2
      //   386: getfield impressions_ : I
      //   389: ifeq -> 398
      //   392: iconst_1
      //   393: istore #10
      //   395: goto -> 401
      //   398: iconst_0
      //   399: istore #10
      //   401: aload_0
      //   402: aload_1
      //   403: iload #7
      //   405: iload #6
      //   407: iload #10
      //   409: aload_2
      //   410: getfield impressions_ : I
      //   413: invokeinterface visitInt : (ZIZI)I
      //   418: putfield impressions_ : I
      //   421: aload_0
      //   422: getfield clicks_ : I
      //   425: ifeq -> 434
      //   428: iconst_1
      //   429: istore #7
      //   431: goto -> 437
      //   434: iconst_0
      //   435: istore #7
      //   437: aload_0
      //   438: getfield clicks_ : I
      //   441: istore #6
      //   443: aload_2
      //   444: getfield clicks_ : I
      //   447: ifeq -> 456
      //   450: iconst_1
      //   451: istore #10
      //   453: goto -> 459
      //   456: iconst_0
      //   457: istore #10
      //   459: aload_0
      //   460: aload_1
      //   461: iload #7
      //   463: iload #6
      //   465: iload #10
      //   467: aload_2
      //   468: getfield clicks_ : I
      //   471: invokeinterface visitInt : (ZIZI)I
      //   476: putfield clicks_ : I
      //   479: aload_0
      //   480: getfield errors_ : I
      //   483: ifeq -> 492
      //   486: iconst_1
      //   487: istore #7
      //   489: goto -> 495
      //   492: iconst_0
      //   493: istore #7
      //   495: aload_0
      //   496: getfield errors_ : I
      //   499: istore #6
      //   501: iload #5
      //   503: istore #10
      //   505: aload_2
      //   506: getfield errors_ : I
      //   509: ifeq -> 515
      //   512: iconst_1
      //   513: istore #10
      //   515: aload_0
      //   516: aload_1
      //   517: iload #7
      //   519: iload #6
      //   521: iload #10
      //   523: aload_2
      //   524: getfield errors_ : I
      //   527: invokeinterface visitInt : (ZIZI)I
      //   532: putfield errors_ : I
      //   535: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   538: astore_1
      //   539: aload_0
      //   540: areturn
      //   541: new com/google/firebase/inappmessaging/CommonTypesProto$DailyAnalyticsSummary$Builder
      //   544: dup
      //   545: aconst_null
      //   546: invokespecial <init> : (Lcom/google/firebase/inappmessaging/CommonTypesProto$1;)V
      //   549: areturn
      //   550: aconst_null
      //   551: areturn
      //   552: getstatic com/google/firebase/inappmessaging/CommonTypesProto$DailyAnalyticsSummary.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/CommonTypesProto$DailyAnalyticsSummary;
      //   555: areturn
      //   556: new com/google/firebase/inappmessaging/CommonTypesProto$DailyAnalyticsSummary
      //   559: dup
      //   560: invokespecial <init> : ()V
      //   563: areturn
      // Exception table:
      //   from	to	target	type
      //   81	102	108	finally
      //   102	105	108	finally
      //   109	112	108	finally
      //   133	139	269	com/google/protobuf/InvalidProtocolBufferException
      //   133	139	241	java/io/IOException
      //   133	139	237	finally
      //   172	181	269	com/google/protobuf/InvalidProtocolBufferException
      //   172	181	241	java/io/IOException
      //   172	181	237	finally
      //   187	195	269	com/google/protobuf/InvalidProtocolBufferException
      //   187	195	241	java/io/IOException
      //   187	195	237	finally
      //   198	206	269	com/google/protobuf/InvalidProtocolBufferException
      //   198	206	241	java/io/IOException
      //   198	206	237	finally
      //   209	217	269	com/google/protobuf/InvalidProtocolBufferException
      //   209	217	241	java/io/IOException
      //   209	217	237	finally
      //   220	228	269	com/google/protobuf/InvalidProtocolBufferException
      //   220	228	241	java/io/IOException
      //   220	228	237	finally
      //   242	269	237	finally
      //   270	285	237	finally
    }
    
    public int getClicks() {
      return this.clicks_;
    }
    
    public int getErrors() {
      return this.errors_;
    }
    
    public int getImpressions() {
      return this.impressions_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      long l = this.startOfDayMillis_;
      if (l != 0L)
        i = 0 + CodedOutputStream.computeInt64Size(1, l); 
      int j = this.impressions_;
      int k = i;
      if (j != 0)
        k = i + CodedOutputStream.computeInt32Size(2, j); 
      j = this.clicks_;
      i = k;
      if (j != 0)
        i = k + CodedOutputStream.computeInt32Size(3, j); 
      j = this.errors_;
      k = i;
      if (j != 0)
        k = i + CodedOutputStream.computeInt32Size(4, j); 
      this.memoizedSerializedSize = k;
      return k;
    }
    
    public long getStartOfDayMillis() {
      return this.startOfDayMillis_;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      long l = this.startOfDayMillis_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(1, l); 
      int i = this.impressions_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(2, i); 
      i = this.clicks_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(3, i); 
      i = this.errors_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(4, i); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<DailyAnalyticsSummary, Builder> implements CommonTypesProto.DailyAnalyticsSummaryOrBuilder {
      private Builder() {
        super(CommonTypesProto.DailyAnalyticsSummary.DEFAULT_INSTANCE);
      }
      
      public Builder clearClicks() {
        copyOnWrite();
        ((CommonTypesProto.DailyAnalyticsSummary)this.instance).clearClicks();
        return this;
      }
      
      public Builder clearErrors() {
        copyOnWrite();
        ((CommonTypesProto.DailyAnalyticsSummary)this.instance).clearErrors();
        return this;
      }
      
      public Builder clearImpressions() {
        copyOnWrite();
        ((CommonTypesProto.DailyAnalyticsSummary)this.instance).clearImpressions();
        return this;
      }
      
      public Builder clearStartOfDayMillis() {
        copyOnWrite();
        ((CommonTypesProto.DailyAnalyticsSummary)this.instance).clearStartOfDayMillis();
        return this;
      }
      
      public int getClicks() {
        return ((CommonTypesProto.DailyAnalyticsSummary)this.instance).getClicks();
      }
      
      public int getErrors() {
        return ((CommonTypesProto.DailyAnalyticsSummary)this.instance).getErrors();
      }
      
      public int getImpressions() {
        return ((CommonTypesProto.DailyAnalyticsSummary)this.instance).getImpressions();
      }
      
      public long getStartOfDayMillis() {
        return ((CommonTypesProto.DailyAnalyticsSummary)this.instance).getStartOfDayMillis();
      }
      
      public Builder setClicks(int param2Int) {
        copyOnWrite();
        ((CommonTypesProto.DailyAnalyticsSummary)this.instance).setClicks(param2Int);
        return this;
      }
      
      public Builder setErrors(int param2Int) {
        copyOnWrite();
        ((CommonTypesProto.DailyAnalyticsSummary)this.instance).setErrors(param2Int);
        return this;
      }
      
      public Builder setImpressions(int param2Int) {
        copyOnWrite();
        ((CommonTypesProto.DailyAnalyticsSummary)this.instance).setImpressions(param2Int);
        return this;
      }
      
      public Builder setStartOfDayMillis(long param2Long) {
        copyOnWrite();
        ((CommonTypesProto.DailyAnalyticsSummary)this.instance).setStartOfDayMillis(param2Long);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<DailyAnalyticsSummary, DailyAnalyticsSummary.Builder> implements DailyAnalyticsSummaryOrBuilder {
    private Builder() {
      super(CommonTypesProto.DailyAnalyticsSummary.DEFAULT_INSTANCE);
    }
    
    public Builder clearClicks() {
      copyOnWrite();
      ((CommonTypesProto.DailyAnalyticsSummary)this.instance).clearClicks();
      return this;
    }
    
    public Builder clearErrors() {
      copyOnWrite();
      ((CommonTypesProto.DailyAnalyticsSummary)this.instance).clearErrors();
      return this;
    }
    
    public Builder clearImpressions() {
      copyOnWrite();
      ((CommonTypesProto.DailyAnalyticsSummary)this.instance).clearImpressions();
      return this;
    }
    
    public Builder clearStartOfDayMillis() {
      copyOnWrite();
      ((CommonTypesProto.DailyAnalyticsSummary)this.instance).clearStartOfDayMillis();
      return this;
    }
    
    public int getClicks() {
      return ((CommonTypesProto.DailyAnalyticsSummary)this.instance).getClicks();
    }
    
    public int getErrors() {
      return ((CommonTypesProto.DailyAnalyticsSummary)this.instance).getErrors();
    }
    
    public int getImpressions() {
      return ((CommonTypesProto.DailyAnalyticsSummary)this.instance).getImpressions();
    }
    
    public long getStartOfDayMillis() {
      return ((CommonTypesProto.DailyAnalyticsSummary)this.instance).getStartOfDayMillis();
    }
    
    public Builder setClicks(int param1Int) {
      copyOnWrite();
      ((CommonTypesProto.DailyAnalyticsSummary)this.instance).setClicks(param1Int);
      return this;
    }
    
    public Builder setErrors(int param1Int) {
      copyOnWrite();
      ((CommonTypesProto.DailyAnalyticsSummary)this.instance).setErrors(param1Int);
      return this;
    }
    
    public Builder setImpressions(int param1Int) {
      copyOnWrite();
      ((CommonTypesProto.DailyAnalyticsSummary)this.instance).setImpressions(param1Int);
      return this;
    }
    
    public Builder setStartOfDayMillis(long param1Long) {
      copyOnWrite();
      ((CommonTypesProto.DailyAnalyticsSummary)this.instance).setStartOfDayMillis(param1Long);
      return this;
    }
  }
  
  public static interface DailyAnalyticsSummaryOrBuilder extends MessageLiteOrBuilder {
    int getClicks();
    
    int getErrors();
    
    int getImpressions();
    
    long getStartOfDayMillis();
  }
  
  public static final class DailyConversionSummary extends GeneratedMessageLite<DailyConversionSummary, DailyConversionSummary.Builder> implements DailyConversionSummaryOrBuilder {
    public static final int CONVERSIONS_FIELD_NUMBER = 2;
    
    private static final DailyConversionSummary DEFAULT_INSTANCE = new DailyConversionSummary();
    
    private static volatile Parser<DailyConversionSummary> PARSER;
    
    public static final int START_OF_DAY_MILLIS_FIELD_NUMBER = 1;
    
    private int conversions_;
    
    private long startOfDayMillis_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearConversions() {
      this.conversions_ = 0;
    }
    
    private void clearStartOfDayMillis() {
      this.startOfDayMillis_ = 0L;
    }
    
    public static DailyConversionSummary getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(DailyConversionSummary param1DailyConversionSummary) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1DailyConversionSummary);
    }
    
    public static DailyConversionSummary parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (DailyConversionSummary)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static DailyConversionSummary parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (DailyConversionSummary)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static DailyConversionSummary parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (DailyConversionSummary)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static DailyConversionSummary parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (DailyConversionSummary)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static DailyConversionSummary parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (DailyConversionSummary)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static DailyConversionSummary parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (DailyConversionSummary)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static DailyConversionSummary parseFrom(InputStream param1InputStream) throws IOException {
      return (DailyConversionSummary)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static DailyConversionSummary parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (DailyConversionSummary)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static DailyConversionSummary parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (DailyConversionSummary)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static DailyConversionSummary parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (DailyConversionSummary)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<DailyConversionSummary> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setConversions(int param1Int) {
      this.conversions_ = param1Int;
    }
    
    private void setStartOfDayMillis(long param1Long) {
      this.startOfDayMillis_ = param1Long;
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firebase/inappmessaging/CommonTypesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: istore #4
      //   10: iconst_0
      //   11: istore #5
      //   13: iconst_0
      //   14: istore #6
      //   16: iload #4
      //   18: tableswitch default -> 64, 1 -> 404, 2 -> 400, 3 -> 398, 4 -> 389, 5 -> 255, 6 -> 118, 7 -> 251, 8 -> 72
      //   64: new java/lang/UnsupportedOperationException
      //   67: dup
      //   68: invokespecial <init> : ()V
      //   71: athrow
      //   72: getstatic com/google/firebase/inappmessaging/CommonTypesProto$DailyConversionSummary.PARSER : Lcom/google/protobuf/Parser;
      //   75: ifnonnull -> 114
      //   78: ldc com/google/firebase/inappmessaging/CommonTypesProto$DailyConversionSummary
      //   80: monitorenter
      //   81: getstatic com/google/firebase/inappmessaging/CommonTypesProto$DailyConversionSummary.PARSER : Lcom/google/protobuf/Parser;
      //   84: ifnonnull -> 102
      //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   90: astore_1
      //   91: aload_1
      //   92: getstatic com/google/firebase/inappmessaging/CommonTypesProto$DailyConversionSummary.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/CommonTypesProto$DailyConversionSummary;
      //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   98: aload_1
      //   99: putstatic com/google/firebase/inappmessaging/CommonTypesProto$DailyConversionSummary.PARSER : Lcom/google/protobuf/Parser;
      //   102: ldc com/google/firebase/inappmessaging/CommonTypesProto$DailyConversionSummary
      //   104: monitorexit
      //   105: goto -> 114
      //   108: astore_1
      //   109: ldc com/google/firebase/inappmessaging/CommonTypesProto$DailyConversionSummary
      //   111: monitorexit
      //   112: aload_1
      //   113: athrow
      //   114: getstatic com/google/firebase/inappmessaging/CommonTypesProto$DailyConversionSummary.PARSER : Lcom/google/protobuf/Parser;
      //   117: areturn
      //   118: aload_2
      //   119: checkcast com/google/protobuf/CodedInputStream
      //   122: astore_1
      //   123: aload_3
      //   124: checkcast com/google/protobuf/ExtensionRegistryLite
      //   127: astore_2
      //   128: iload #6
      //   130: ifne -> 251
      //   133: aload_1
      //   134: invokevirtual readTag : ()I
      //   137: istore #4
      //   139: iload #4
      //   141: ifeq -> 195
      //   144: iload #4
      //   146: bipush #8
      //   148: if_icmpeq -> 184
      //   151: iload #4
      //   153: bipush #16
      //   155: if_icmpeq -> 173
      //   158: aload_1
      //   159: iload #4
      //   161: invokevirtual skipField : (I)Z
      //   164: ifne -> 128
      //   167: iconst_1
      //   168: istore #6
      //   170: goto -> 128
      //   173: aload_0
      //   174: aload_1
      //   175: invokevirtual readInt32 : ()I
      //   178: putfield conversions_ : I
      //   181: goto -> 128
      //   184: aload_0
      //   185: aload_1
      //   186: invokevirtual readInt64 : ()J
      //   189: putfield startOfDayMillis_ : J
      //   192: goto -> 128
      //   195: iconst_1
      //   196: istore #6
      //   198: goto -> 128
      //   201: astore_1
      //   202: goto -> 249
      //   205: astore_1
      //   206: new java/lang/RuntimeException
      //   209: astore_3
      //   210: new com/google/protobuf/InvalidProtocolBufferException
      //   213: astore_2
      //   214: aload_2
      //   215: aload_1
      //   216: invokevirtual getMessage : ()Ljava/lang/String;
      //   219: invokespecial <init> : (Ljava/lang/String;)V
      //   222: aload_3
      //   223: aload_2
      //   224: aload_0
      //   225: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   228: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   231: aload_3
      //   232: athrow
      //   233: astore_1
      //   234: new java/lang/RuntimeException
      //   237: astore_2
      //   238: aload_2
      //   239: aload_1
      //   240: aload_0
      //   241: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   244: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   247: aload_2
      //   248: athrow
      //   249: aload_1
      //   250: athrow
      //   251: getstatic com/google/firebase/inappmessaging/CommonTypesProto$DailyConversionSummary.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/CommonTypesProto$DailyConversionSummary;
      //   254: areturn
      //   255: aload_2
      //   256: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   259: astore_1
      //   260: aload_3
      //   261: checkcast com/google/firebase/inappmessaging/CommonTypesProto$DailyConversionSummary
      //   264: astore_2
      //   265: aload_0
      //   266: getfield startOfDayMillis_ : J
      //   269: lconst_0
      //   270: lcmp
      //   271: ifeq -> 280
      //   274: iconst_1
      //   275: istore #7
      //   277: goto -> 283
      //   280: iconst_0
      //   281: istore #7
      //   283: aload_0
      //   284: getfield startOfDayMillis_ : J
      //   287: lstore #8
      //   289: aload_2
      //   290: getfield startOfDayMillis_ : J
      //   293: lconst_0
      //   294: lcmp
      //   295: ifeq -> 304
      //   298: iconst_1
      //   299: istore #10
      //   301: goto -> 307
      //   304: iconst_0
      //   305: istore #10
      //   307: aload_0
      //   308: aload_1
      //   309: iload #7
      //   311: lload #8
      //   313: iload #10
      //   315: aload_2
      //   316: getfield startOfDayMillis_ : J
      //   319: invokeinterface visitLong : (ZJZJ)J
      //   324: putfield startOfDayMillis_ : J
      //   327: aload_0
      //   328: getfield conversions_ : I
      //   331: ifeq -> 340
      //   334: iconst_1
      //   335: istore #7
      //   337: goto -> 343
      //   340: iconst_0
      //   341: istore #7
      //   343: aload_0
      //   344: getfield conversions_ : I
      //   347: istore #6
      //   349: iload #5
      //   351: istore #10
      //   353: aload_2
      //   354: getfield conversions_ : I
      //   357: ifeq -> 363
      //   360: iconst_1
      //   361: istore #10
      //   363: aload_0
      //   364: aload_1
      //   365: iload #7
      //   367: iload #6
      //   369: iload #10
      //   371: aload_2
      //   372: getfield conversions_ : I
      //   375: invokeinterface visitInt : (ZIZI)I
      //   380: putfield conversions_ : I
      //   383: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   386: astore_1
      //   387: aload_0
      //   388: areturn
      //   389: new com/google/firebase/inappmessaging/CommonTypesProto$DailyConversionSummary$Builder
      //   392: dup
      //   393: aconst_null
      //   394: invokespecial <init> : (Lcom/google/firebase/inappmessaging/CommonTypesProto$1;)V
      //   397: areturn
      //   398: aconst_null
      //   399: areturn
      //   400: getstatic com/google/firebase/inappmessaging/CommonTypesProto$DailyConversionSummary.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/CommonTypesProto$DailyConversionSummary;
      //   403: areturn
      //   404: new com/google/firebase/inappmessaging/CommonTypesProto$DailyConversionSummary
      //   407: dup
      //   408: invokespecial <init> : ()V
      //   411: areturn
      // Exception table:
      //   from	to	target	type
      //   81	102	108	finally
      //   102	105	108	finally
      //   109	112	108	finally
      //   133	139	233	com/google/protobuf/InvalidProtocolBufferException
      //   133	139	205	java/io/IOException
      //   133	139	201	finally
      //   158	167	233	com/google/protobuf/InvalidProtocolBufferException
      //   158	167	205	java/io/IOException
      //   158	167	201	finally
      //   173	181	233	com/google/protobuf/InvalidProtocolBufferException
      //   173	181	205	java/io/IOException
      //   173	181	201	finally
      //   184	192	233	com/google/protobuf/InvalidProtocolBufferException
      //   184	192	205	java/io/IOException
      //   184	192	201	finally
      //   206	233	201	finally
      //   234	249	201	finally
    }
    
    public int getConversions() {
      return this.conversions_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      long l = this.startOfDayMillis_;
      if (l != 0L)
        i = 0 + CodedOutputStream.computeInt64Size(1, l); 
      int j = this.conversions_;
      int k = i;
      if (j != 0)
        k = i + CodedOutputStream.computeInt32Size(2, j); 
      this.memoizedSerializedSize = k;
      return k;
    }
    
    public long getStartOfDayMillis() {
      return this.startOfDayMillis_;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      long l = this.startOfDayMillis_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(1, l); 
      int i = this.conversions_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(2, i); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<DailyConversionSummary, Builder> implements CommonTypesProto.DailyConversionSummaryOrBuilder {
      private Builder() {
        super(CommonTypesProto.DailyConversionSummary.DEFAULT_INSTANCE);
      }
      
      public Builder clearConversions() {
        copyOnWrite();
        ((CommonTypesProto.DailyConversionSummary)this.instance).clearConversions();
        return this;
      }
      
      public Builder clearStartOfDayMillis() {
        copyOnWrite();
        ((CommonTypesProto.DailyConversionSummary)this.instance).clearStartOfDayMillis();
        return this;
      }
      
      public int getConversions() {
        return ((CommonTypesProto.DailyConversionSummary)this.instance).getConversions();
      }
      
      public long getStartOfDayMillis() {
        return ((CommonTypesProto.DailyConversionSummary)this.instance).getStartOfDayMillis();
      }
      
      public Builder setConversions(int param2Int) {
        copyOnWrite();
        ((CommonTypesProto.DailyConversionSummary)this.instance).setConversions(param2Int);
        return this;
      }
      
      public Builder setStartOfDayMillis(long param2Long) {
        copyOnWrite();
        ((CommonTypesProto.DailyConversionSummary)this.instance).setStartOfDayMillis(param2Long);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<DailyConversionSummary, DailyConversionSummary.Builder> implements DailyConversionSummaryOrBuilder {
    private Builder() {
      super(CommonTypesProto.DailyConversionSummary.DEFAULT_INSTANCE);
    }
    
    public Builder clearConversions() {
      copyOnWrite();
      ((CommonTypesProto.DailyConversionSummary)this.instance).clearConversions();
      return this;
    }
    
    public Builder clearStartOfDayMillis() {
      copyOnWrite();
      ((CommonTypesProto.DailyConversionSummary)this.instance).clearStartOfDayMillis();
      return this;
    }
    
    public int getConversions() {
      return ((CommonTypesProto.DailyConversionSummary)this.instance).getConversions();
    }
    
    public long getStartOfDayMillis() {
      return ((CommonTypesProto.DailyConversionSummary)this.instance).getStartOfDayMillis();
    }
    
    public Builder setConversions(int param1Int) {
      copyOnWrite();
      ((CommonTypesProto.DailyConversionSummary)this.instance).setConversions(param1Int);
      return this;
    }
    
    public Builder setStartOfDayMillis(long param1Long) {
      copyOnWrite();
      ((CommonTypesProto.DailyConversionSummary)this.instance).setStartOfDayMillis(param1Long);
      return this;
    }
  }
  
  public static interface DailyConversionSummaryOrBuilder extends MessageLiteOrBuilder {
    int getConversions();
    
    long getStartOfDayMillis();
  }
  
  public static final class ExperimentVariant extends GeneratedMessageLite<ExperimentVariant, ExperimentVariant.Builder> implements ExperimentVariantOrBuilder {
    public static final int CONTENT_FIELD_NUMBER = 2;
    
    private static final ExperimentVariant DEFAULT_INSTANCE = new ExperimentVariant();
    
    public static final int INDEX_FIELD_NUMBER = 1;
    
    private static volatile Parser<ExperimentVariant> PARSER;
    
    private MessagesProto.Content content_;
    
    private int index_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearContent() {
      this.content_ = null;
    }
    
    private void clearIndex() {
      this.index_ = 0;
    }
    
    public static ExperimentVariant getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeContent(MessagesProto.Content param1Content) {
      MessagesProto.Content content = this.content_;
      if (content != null && content != MessagesProto.Content.getDefaultInstance()) {
        this.content_ = (MessagesProto.Content)((MessagesProto.Content.Builder)MessagesProto.Content.newBuilder(this.content_).mergeFrom(param1Content)).buildPartial();
      } else {
        this.content_ = param1Content;
      } 
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ExperimentVariant param1ExperimentVariant) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1ExperimentVariant);
    }
    
    public static ExperimentVariant parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (ExperimentVariant)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static ExperimentVariant parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ExperimentVariant)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ExperimentVariant parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (ExperimentVariant)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static ExperimentVariant parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ExperimentVariant)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static ExperimentVariant parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (ExperimentVariant)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static ExperimentVariant parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ExperimentVariant)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static ExperimentVariant parseFrom(InputStream param1InputStream) throws IOException {
      return (ExperimentVariant)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static ExperimentVariant parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ExperimentVariant)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ExperimentVariant parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (ExperimentVariant)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static ExperimentVariant parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ExperimentVariant)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<ExperimentVariant> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setContent(MessagesProto.Content.Builder param1Builder) {
      this.content_ = (MessagesProto.Content)param1Builder.build();
    }
    
    private void setContent(MessagesProto.Content param1Content) {
      if (param1Content != null) {
        this.content_ = param1Content;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setIndex(int param1Int) {
      this.index_ = param1Int;
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firebase/inappmessaging/CommonTypesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: istore #4
      //   10: iconst_0
      //   11: istore #5
      //   13: iconst_0
      //   14: istore #6
      //   16: iload #4
      //   18: tableswitch default -> 64, 1 -> 413, 2 -> 409, 3 -> 407, 4 -> 398, 5 -> 309, 6 -> 118, 7 -> 305, 8 -> 72
      //   64: new java/lang/UnsupportedOperationException
      //   67: dup
      //   68: invokespecial <init> : ()V
      //   71: athrow
      //   72: getstatic com/google/firebase/inappmessaging/CommonTypesProto$ExperimentVariant.PARSER : Lcom/google/protobuf/Parser;
      //   75: ifnonnull -> 114
      //   78: ldc com/google/firebase/inappmessaging/CommonTypesProto$ExperimentVariant
      //   80: monitorenter
      //   81: getstatic com/google/firebase/inappmessaging/CommonTypesProto$ExperimentVariant.PARSER : Lcom/google/protobuf/Parser;
      //   84: ifnonnull -> 102
      //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   90: astore_1
      //   91: aload_1
      //   92: getstatic com/google/firebase/inappmessaging/CommonTypesProto$ExperimentVariant.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/CommonTypesProto$ExperimentVariant;
      //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   98: aload_1
      //   99: putstatic com/google/firebase/inappmessaging/CommonTypesProto$ExperimentVariant.PARSER : Lcom/google/protobuf/Parser;
      //   102: ldc com/google/firebase/inappmessaging/CommonTypesProto$ExperimentVariant
      //   104: monitorexit
      //   105: goto -> 114
      //   108: astore_1
      //   109: ldc com/google/firebase/inappmessaging/CommonTypesProto$ExperimentVariant
      //   111: monitorexit
      //   112: aload_1
      //   113: athrow
      //   114: getstatic com/google/firebase/inappmessaging/CommonTypesProto$ExperimentVariant.PARSER : Lcom/google/protobuf/Parser;
      //   117: areturn
      //   118: aload_2
      //   119: checkcast com/google/protobuf/CodedInputStream
      //   122: astore_2
      //   123: aload_3
      //   124: checkcast com/google/protobuf/ExtensionRegistryLite
      //   127: astore_3
      //   128: iload #6
      //   130: ifne -> 305
      //   133: aload_2
      //   134: invokevirtual readTag : ()I
      //   137: istore #4
      //   139: iload #4
      //   141: ifeq -> 249
      //   144: iload #4
      //   146: bipush #8
      //   148: if_icmpeq -> 238
      //   151: iload #4
      //   153: bipush #18
      //   155: if_icmpeq -> 173
      //   158: aload_2
      //   159: iload #4
      //   161: invokevirtual skipField : (I)Z
      //   164: ifne -> 128
      //   167: iconst_1
      //   168: istore #6
      //   170: goto -> 128
      //   173: aload_0
      //   174: getfield content_ : Lcom/google/firebase/inappmessaging/MessagesProto$Content;
      //   177: ifnull -> 194
      //   180: aload_0
      //   181: getfield content_ : Lcom/google/firebase/inappmessaging/MessagesProto$Content;
      //   184: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   187: checkcast com/google/firebase/inappmessaging/MessagesProto$Content$Builder
      //   190: astore_1
      //   191: goto -> 196
      //   194: aconst_null
      //   195: astore_1
      //   196: aload_0
      //   197: aload_2
      //   198: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   201: aload_3
      //   202: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   205: checkcast com/google/firebase/inappmessaging/MessagesProto$Content
      //   208: putfield content_ : Lcom/google/firebase/inappmessaging/MessagesProto$Content;
      //   211: aload_1
      //   212: ifnull -> 128
      //   215: aload_1
      //   216: aload_0
      //   217: getfield content_ : Lcom/google/firebase/inappmessaging/MessagesProto$Content;
      //   220: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   223: pop
      //   224: aload_0
      //   225: aload_1
      //   226: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   229: checkcast com/google/firebase/inappmessaging/MessagesProto$Content
      //   232: putfield content_ : Lcom/google/firebase/inappmessaging/MessagesProto$Content;
      //   235: goto -> 128
      //   238: aload_0
      //   239: aload_2
      //   240: invokevirtual readInt32 : ()I
      //   243: putfield index_ : I
      //   246: goto -> 128
      //   249: iconst_1
      //   250: istore #6
      //   252: goto -> 128
      //   255: astore_1
      //   256: goto -> 303
      //   259: astore_2
      //   260: new java/lang/RuntimeException
      //   263: astore_1
      //   264: new com/google/protobuf/InvalidProtocolBufferException
      //   267: astore_3
      //   268: aload_3
      //   269: aload_2
      //   270: invokevirtual getMessage : ()Ljava/lang/String;
      //   273: invokespecial <init> : (Ljava/lang/String;)V
      //   276: aload_1
      //   277: aload_3
      //   278: aload_0
      //   279: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   282: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   285: aload_1
      //   286: athrow
      //   287: astore_1
      //   288: new java/lang/RuntimeException
      //   291: astore_2
      //   292: aload_2
      //   293: aload_1
      //   294: aload_0
      //   295: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   298: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   301: aload_2
      //   302: athrow
      //   303: aload_1
      //   304: athrow
      //   305: getstatic com/google/firebase/inappmessaging/CommonTypesProto$ExperimentVariant.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/CommonTypesProto$ExperimentVariant;
      //   308: areturn
      //   309: aload_2
      //   310: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   313: astore_1
      //   314: aload_3
      //   315: checkcast com/google/firebase/inappmessaging/CommonTypesProto$ExperimentVariant
      //   318: astore_2
      //   319: aload_0
      //   320: getfield index_ : I
      //   323: ifeq -> 332
      //   326: iconst_1
      //   327: istore #7
      //   329: goto -> 335
      //   332: iconst_0
      //   333: istore #7
      //   335: aload_0
      //   336: getfield index_ : I
      //   339: istore #6
      //   341: aload_2
      //   342: getfield index_ : I
      //   345: ifeq -> 351
      //   348: iconst_1
      //   349: istore #5
      //   351: aload_0
      //   352: aload_1
      //   353: iload #7
      //   355: iload #6
      //   357: iload #5
      //   359: aload_2
      //   360: getfield index_ : I
      //   363: invokeinterface visitInt : (ZIZI)I
      //   368: putfield index_ : I
      //   371: aload_0
      //   372: aload_1
      //   373: aload_0
      //   374: getfield content_ : Lcom/google/firebase/inappmessaging/MessagesProto$Content;
      //   377: aload_2
      //   378: getfield content_ : Lcom/google/firebase/inappmessaging/MessagesProto$Content;
      //   381: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   386: checkcast com/google/firebase/inappmessaging/MessagesProto$Content
      //   389: putfield content_ : Lcom/google/firebase/inappmessaging/MessagesProto$Content;
      //   392: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   395: astore_1
      //   396: aload_0
      //   397: areturn
      //   398: new com/google/firebase/inappmessaging/CommonTypesProto$ExperimentVariant$Builder
      //   401: dup
      //   402: aconst_null
      //   403: invokespecial <init> : (Lcom/google/firebase/inappmessaging/CommonTypesProto$1;)V
      //   406: areturn
      //   407: aconst_null
      //   408: areturn
      //   409: getstatic com/google/firebase/inappmessaging/CommonTypesProto$ExperimentVariant.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/CommonTypesProto$ExperimentVariant;
      //   412: areturn
      //   413: new com/google/firebase/inappmessaging/CommonTypesProto$ExperimentVariant
      //   416: dup
      //   417: invokespecial <init> : ()V
      //   420: areturn
      // Exception table:
      //   from	to	target	type
      //   81	102	108	finally
      //   102	105	108	finally
      //   109	112	108	finally
      //   133	139	287	com/google/protobuf/InvalidProtocolBufferException
      //   133	139	259	java/io/IOException
      //   133	139	255	finally
      //   158	167	287	com/google/protobuf/InvalidProtocolBufferException
      //   158	167	259	java/io/IOException
      //   158	167	255	finally
      //   173	191	287	com/google/protobuf/InvalidProtocolBufferException
      //   173	191	259	java/io/IOException
      //   173	191	255	finally
      //   196	211	287	com/google/protobuf/InvalidProtocolBufferException
      //   196	211	259	java/io/IOException
      //   196	211	255	finally
      //   215	235	287	com/google/protobuf/InvalidProtocolBufferException
      //   215	235	259	java/io/IOException
      //   215	235	255	finally
      //   238	246	287	com/google/protobuf/InvalidProtocolBufferException
      //   238	246	259	java/io/IOException
      //   238	246	255	finally
      //   260	287	255	finally
      //   288	303	255	finally
    }
    
    public MessagesProto.Content getContent() {
      MessagesProto.Content content1 = this.content_;
      MessagesProto.Content content2 = content1;
      if (content1 == null)
        content2 = MessagesProto.Content.getDefaultInstance(); 
      return content2;
    }
    
    public int getIndex() {
      return this.index_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      int j = this.index_;
      if (j != 0)
        i = 0 + CodedOutputStream.computeInt32Size(1, j); 
      j = i;
      if (this.content_ != null)
        j = i + CodedOutputStream.computeMessageSize(2, (MessageLite)getContent()); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public boolean hasContent() {
      boolean bool;
      if (this.content_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      int i = this.index_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(1, i); 
      if (this.content_ != null)
        param1CodedOutputStream.writeMessage(2, (MessageLite)getContent()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<ExperimentVariant, Builder> implements CommonTypesProto.ExperimentVariantOrBuilder {
      private Builder() {
        super(CommonTypesProto.ExperimentVariant.DEFAULT_INSTANCE);
      }
      
      public Builder clearContent() {
        copyOnWrite();
        ((CommonTypesProto.ExperimentVariant)this.instance).clearContent();
        return this;
      }
      
      public Builder clearIndex() {
        copyOnWrite();
        ((CommonTypesProto.ExperimentVariant)this.instance).clearIndex();
        return this;
      }
      
      public MessagesProto.Content getContent() {
        return ((CommonTypesProto.ExperimentVariant)this.instance).getContent();
      }
      
      public int getIndex() {
        return ((CommonTypesProto.ExperimentVariant)this.instance).getIndex();
      }
      
      public boolean hasContent() {
        return ((CommonTypesProto.ExperimentVariant)this.instance).hasContent();
      }
      
      public Builder mergeContent(MessagesProto.Content param2Content) {
        copyOnWrite();
        ((CommonTypesProto.ExperimentVariant)this.instance).mergeContent(param2Content);
        return this;
      }
      
      public Builder setContent(MessagesProto.Content.Builder param2Builder) {
        copyOnWrite();
        ((CommonTypesProto.ExperimentVariant)this.instance).setContent(param2Builder);
        return this;
      }
      
      public Builder setContent(MessagesProto.Content param2Content) {
        copyOnWrite();
        ((CommonTypesProto.ExperimentVariant)this.instance).setContent(param2Content);
        return this;
      }
      
      public Builder setIndex(int param2Int) {
        copyOnWrite();
        ((CommonTypesProto.ExperimentVariant)this.instance).setIndex(param2Int);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ExperimentVariant, ExperimentVariant.Builder> implements ExperimentVariantOrBuilder {
    private Builder() {
      super(CommonTypesProto.ExperimentVariant.DEFAULT_INSTANCE);
    }
    
    public Builder clearContent() {
      copyOnWrite();
      ((CommonTypesProto.ExperimentVariant)this.instance).clearContent();
      return this;
    }
    
    public Builder clearIndex() {
      copyOnWrite();
      ((CommonTypesProto.ExperimentVariant)this.instance).clearIndex();
      return this;
    }
    
    public MessagesProto.Content getContent() {
      return ((CommonTypesProto.ExperimentVariant)this.instance).getContent();
    }
    
    public int getIndex() {
      return ((CommonTypesProto.ExperimentVariant)this.instance).getIndex();
    }
    
    public boolean hasContent() {
      return ((CommonTypesProto.ExperimentVariant)this.instance).hasContent();
    }
    
    public Builder mergeContent(MessagesProto.Content param1Content) {
      copyOnWrite();
      ((CommonTypesProto.ExperimentVariant)this.instance).mergeContent(param1Content);
      return this;
    }
    
    public Builder setContent(MessagesProto.Content.Builder param1Builder) {
      copyOnWrite();
      ((CommonTypesProto.ExperimentVariant)this.instance).setContent(param1Builder);
      return this;
    }
    
    public Builder setContent(MessagesProto.Content param1Content) {
      copyOnWrite();
      ((CommonTypesProto.ExperimentVariant)this.instance).setContent(param1Content);
      return this;
    }
    
    public Builder setIndex(int param1Int) {
      copyOnWrite();
      ((CommonTypesProto.ExperimentVariant)this.instance).setIndex(param1Int);
      return this;
    }
  }
  
  public static interface ExperimentVariantOrBuilder extends MessageLiteOrBuilder {
    MessagesProto.Content getContent();
    
    int getIndex();
    
    boolean hasContent();
  }
  
  public enum ExperimentalCampaignState implements Internal.EnumLite {
    EXPERIMENT_DRAFT(0),
    EXPERIMENT_ROLLED_OUT(0),
    EXPERIMENT_RUNNING(0),
    EXPERIMENT_STOPPED(0),
    UNKNOWN_EXPERIMENTAL_CAMPAIGN_STATE(0),
    UNRECOGNIZED(0);
    
    public static final int EXPERIMENT_DRAFT_VALUE = 1;
    
    public static final int EXPERIMENT_ROLLED_OUT_VALUE = 4;
    
    public static final int EXPERIMENT_RUNNING_VALUE = 2;
    
    public static final int EXPERIMENT_STOPPED_VALUE = 3;
    
    public static final int UNKNOWN_EXPERIMENTAL_CAMPAIGN_STATE_VALUE = 0;
    
    private static final Internal.EnumLiteMap<ExperimentalCampaignState> internalValueMap;
    
    private final int value;
    
    static {
      EXPERIMENT_ROLLED_OUT = new ExperimentalCampaignState("EXPERIMENT_ROLLED_OUT", 4, 4);
      UNRECOGNIZED = new ExperimentalCampaignState("UNRECOGNIZED", 5, -1);
      $VALUES = new ExperimentalCampaignState[] { UNKNOWN_EXPERIMENTAL_CAMPAIGN_STATE, EXPERIMENT_DRAFT, EXPERIMENT_RUNNING, EXPERIMENT_STOPPED, EXPERIMENT_ROLLED_OUT, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<ExperimentalCampaignState>() {
          public CommonTypesProto.ExperimentalCampaignState findValueByNumber(int param2Int) {
            return CommonTypesProto.ExperimentalCampaignState.forNumber(param2Int);
          }
        };
    }
    
    ExperimentalCampaignState(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ExperimentalCampaignState forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 4:
          return EXPERIMENT_ROLLED_OUT;
        case 3:
          return EXPERIMENT_STOPPED;
        case 2:
          return EXPERIMENT_RUNNING;
        case 1:
          return EXPERIMENT_DRAFT;
        case 0:
          break;
      } 
      return UNKNOWN_EXPERIMENTAL_CAMPAIGN_STATE;
    }
    
    public static Internal.EnumLiteMap<ExperimentalCampaignState> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<ExperimentalCampaignState> {
    public CommonTypesProto.ExperimentalCampaignState findValueByNumber(int param1Int) {
      return CommonTypesProto.ExperimentalCampaignState.forNumber(param1Int);
    }
  }
  
  public static final class Priority extends GeneratedMessageLite<Priority, Priority.Builder> implements PriorityOrBuilder {
    private static final Priority DEFAULT_INSTANCE = new Priority();
    
    private static volatile Parser<Priority> PARSER;
    
    public static final int VALUE_FIELD_NUMBER = 1;
    
    private int value_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearValue() {
      this.value_ = 0;
    }
    
    public static Priority getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Priority param1Priority) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1Priority);
    }
    
    public static Priority parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Priority)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Priority parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Priority)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Priority parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Priority)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static Priority parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Priority)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Priority parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Priority)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static Priority parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Priority)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Priority parseFrom(InputStream param1InputStream) throws IOException {
      return (Priority)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Priority parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Priority)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Priority parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Priority)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static Priority parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Priority)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Priority> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setValue(int param1Int) {
      this.value_ = param1Int;
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firebase/inappmessaging/CommonTypesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: istore #4
      //   10: iconst_0
      //   11: istore #5
      //   13: iconst_0
      //   14: istore #6
      //   16: iload #4
      //   18: tableswitch default -> 64, 1 -> 320, 2 -> 316, 3 -> 314, 4 -> 305, 5 -> 237, 6 -> 118, 7 -> 233, 8 -> 72
      //   64: new java/lang/UnsupportedOperationException
      //   67: dup
      //   68: invokespecial <init> : ()V
      //   71: athrow
      //   72: getstatic com/google/firebase/inappmessaging/CommonTypesProto$Priority.PARSER : Lcom/google/protobuf/Parser;
      //   75: ifnonnull -> 114
      //   78: ldc com/google/firebase/inappmessaging/CommonTypesProto$Priority
      //   80: monitorenter
      //   81: getstatic com/google/firebase/inappmessaging/CommonTypesProto$Priority.PARSER : Lcom/google/protobuf/Parser;
      //   84: ifnonnull -> 102
      //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   90: astore_1
      //   91: aload_1
      //   92: getstatic com/google/firebase/inappmessaging/CommonTypesProto$Priority.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/CommonTypesProto$Priority;
      //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   98: aload_1
      //   99: putstatic com/google/firebase/inappmessaging/CommonTypesProto$Priority.PARSER : Lcom/google/protobuf/Parser;
      //   102: ldc com/google/firebase/inappmessaging/CommonTypesProto$Priority
      //   104: monitorexit
      //   105: goto -> 114
      //   108: astore_1
      //   109: ldc com/google/firebase/inappmessaging/CommonTypesProto$Priority
      //   111: monitorexit
      //   112: aload_1
      //   113: athrow
      //   114: getstatic com/google/firebase/inappmessaging/CommonTypesProto$Priority.PARSER : Lcom/google/protobuf/Parser;
      //   117: areturn
      //   118: aload_2
      //   119: checkcast com/google/protobuf/CodedInputStream
      //   122: astore_1
      //   123: aload_3
      //   124: checkcast com/google/protobuf/ExtensionRegistryLite
      //   127: astore_2
      //   128: iload #6
      //   130: ifne -> 233
      //   133: aload_1
      //   134: invokevirtual readTag : ()I
      //   137: istore #4
      //   139: iload #4
      //   141: ifeq -> 177
      //   144: iload #4
      //   146: bipush #8
      //   148: if_icmpeq -> 166
      //   151: aload_1
      //   152: iload #4
      //   154: invokevirtual skipField : (I)Z
      //   157: ifne -> 128
      //   160: iconst_1
      //   161: istore #6
      //   163: goto -> 128
      //   166: aload_0
      //   167: aload_1
      //   168: invokevirtual readInt32 : ()I
      //   171: putfield value_ : I
      //   174: goto -> 128
      //   177: iconst_1
      //   178: istore #6
      //   180: goto -> 128
      //   183: astore_1
      //   184: goto -> 231
      //   187: astore_3
      //   188: new java/lang/RuntimeException
      //   191: astore_1
      //   192: new com/google/protobuf/InvalidProtocolBufferException
      //   195: astore_2
      //   196: aload_2
      //   197: aload_3
      //   198: invokevirtual getMessage : ()Ljava/lang/String;
      //   201: invokespecial <init> : (Ljava/lang/String;)V
      //   204: aload_1
      //   205: aload_2
      //   206: aload_0
      //   207: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   210: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   213: aload_1
      //   214: athrow
      //   215: astore_2
      //   216: new java/lang/RuntimeException
      //   219: astore_1
      //   220: aload_1
      //   221: aload_2
      //   222: aload_0
      //   223: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   226: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   229: aload_1
      //   230: athrow
      //   231: aload_1
      //   232: athrow
      //   233: getstatic com/google/firebase/inappmessaging/CommonTypesProto$Priority.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/CommonTypesProto$Priority;
      //   236: areturn
      //   237: aload_2
      //   238: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   241: astore_1
      //   242: aload_3
      //   243: checkcast com/google/firebase/inappmessaging/CommonTypesProto$Priority
      //   246: astore_2
      //   247: aload_0
      //   248: getfield value_ : I
      //   251: ifeq -> 260
      //   254: iconst_1
      //   255: istore #7
      //   257: goto -> 263
      //   260: iconst_0
      //   261: istore #7
      //   263: aload_0
      //   264: getfield value_ : I
      //   267: istore #6
      //   269: aload_2
      //   270: getfield value_ : I
      //   273: ifeq -> 279
      //   276: iconst_1
      //   277: istore #5
      //   279: aload_0
      //   280: aload_1
      //   281: iload #7
      //   283: iload #6
      //   285: iload #5
      //   287: aload_2
      //   288: getfield value_ : I
      //   291: invokeinterface visitInt : (ZIZI)I
      //   296: putfield value_ : I
      //   299: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   302: astore_1
      //   303: aload_0
      //   304: areturn
      //   305: new com/google/firebase/inappmessaging/CommonTypesProto$Priority$Builder
      //   308: dup
      //   309: aconst_null
      //   310: invokespecial <init> : (Lcom/google/firebase/inappmessaging/CommonTypesProto$1;)V
      //   313: areturn
      //   314: aconst_null
      //   315: areturn
      //   316: getstatic com/google/firebase/inappmessaging/CommonTypesProto$Priority.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/CommonTypesProto$Priority;
      //   319: areturn
      //   320: new com/google/firebase/inappmessaging/CommonTypesProto$Priority
      //   323: dup
      //   324: invokespecial <init> : ()V
      //   327: areturn
      // Exception table:
      //   from	to	target	type
      //   81	102	108	finally
      //   102	105	108	finally
      //   109	112	108	finally
      //   133	139	215	com/google/protobuf/InvalidProtocolBufferException
      //   133	139	187	java/io/IOException
      //   133	139	183	finally
      //   151	160	215	com/google/protobuf/InvalidProtocolBufferException
      //   151	160	187	java/io/IOException
      //   151	160	183	finally
      //   166	174	215	com/google/protobuf/InvalidProtocolBufferException
      //   166	174	187	java/io/IOException
      //   166	174	183	finally
      //   188	215	183	finally
      //   216	231	183	finally
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      int j = this.value_;
      if (j != 0)
        i = 0 + CodedOutputStream.computeInt32Size(1, j); 
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public int getValue() {
      return this.value_;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      int i = this.value_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(1, i); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Priority, Builder> implements CommonTypesProto.PriorityOrBuilder {
      private Builder() {
        super(CommonTypesProto.Priority.DEFAULT_INSTANCE);
      }
      
      public Builder clearValue() {
        copyOnWrite();
        ((CommonTypesProto.Priority)this.instance).clearValue();
        return this;
      }
      
      public int getValue() {
        return ((CommonTypesProto.Priority)this.instance).getValue();
      }
      
      public Builder setValue(int param2Int) {
        copyOnWrite();
        ((CommonTypesProto.Priority)this.instance).setValue(param2Int);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Priority, Priority.Builder> implements PriorityOrBuilder {
    private Builder() {
      super(CommonTypesProto.Priority.DEFAULT_INSTANCE);
    }
    
    public Builder clearValue() {
      copyOnWrite();
      ((CommonTypesProto.Priority)this.instance).clearValue();
      return this;
    }
    
    public int getValue() {
      return ((CommonTypesProto.Priority)this.instance).getValue();
    }
    
    public Builder setValue(int param1Int) {
      copyOnWrite();
      ((CommonTypesProto.Priority)this.instance).setValue(param1Int);
      return this;
    }
  }
  
  public static interface PriorityOrBuilder extends MessageLiteOrBuilder {
    int getValue();
  }
  
  public static final class ScionConversionEvent extends GeneratedMessageLite<ScionConversionEvent, ScionConversionEvent.Builder> implements ScionConversionEventOrBuilder {
    private static final ScionConversionEvent DEFAULT_INSTANCE = new ScionConversionEvent();
    
    public static final int NAME_FIELD_NUMBER = 1;
    
    private static volatile Parser<ScionConversionEvent> PARSER;
    
    private String name_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearName() {
      this.name_ = getDefaultInstance().getName();
    }
    
    public static ScionConversionEvent getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ScionConversionEvent param1ScionConversionEvent) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1ScionConversionEvent);
    }
    
    public static ScionConversionEvent parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (ScionConversionEvent)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static ScionConversionEvent parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ScionConversionEvent)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ScionConversionEvent parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (ScionConversionEvent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static ScionConversionEvent parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ScionConversionEvent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static ScionConversionEvent parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (ScionConversionEvent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static ScionConversionEvent parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ScionConversionEvent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static ScionConversionEvent parseFrom(InputStream param1InputStream) throws IOException {
      return (ScionConversionEvent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static ScionConversionEvent parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ScionConversionEvent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ScionConversionEvent parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (ScionConversionEvent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static ScionConversionEvent parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ScionConversionEvent)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<ScionConversionEvent> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setName(String param1String) {
      if (param1String != null) {
        this.name_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.name_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firebase/inappmessaging/CommonTypesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 299, 2 -> 295, 3 -> 293, 4 -> 284, 5 -> 232, 6 -> 110, 7 -> 228, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/firebase/inappmessaging/CommonTypesProto$ScionConversionEvent.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/firebase/inappmessaging/CommonTypesProto$ScionConversionEvent
      //   72: monitorenter
      //   73: getstatic com/google/firebase/inappmessaging/CommonTypesProto$ScionConversionEvent.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/firebase/inappmessaging/CommonTypesProto$ScionConversionEvent.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/CommonTypesProto$ScionConversionEvent;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/firebase/inappmessaging/CommonTypesProto$ScionConversionEvent.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/firebase/inappmessaging/CommonTypesProto$ScionConversionEvent
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/firebase/inappmessaging/CommonTypesProto$ScionConversionEvent
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/firebase/inappmessaging/CommonTypesProto$ScionConversionEvent.PARSER : Lcom/google/protobuf/Parser;
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
      //   166: putfield name_ : Ljava/lang/String;
      //   169: goto -> 123
      //   172: iconst_1
      //   173: istore #4
      //   175: goto -> 123
      //   178: astore_1
      //   179: goto -> 226
      //   182: astore_3
      //   183: new java/lang/RuntimeException
      //   186: astore_2
      //   187: new com/google/protobuf/InvalidProtocolBufferException
      //   190: astore_1
      //   191: aload_1
      //   192: aload_3
      //   193: invokevirtual getMessage : ()Ljava/lang/String;
      //   196: invokespecial <init> : (Ljava/lang/String;)V
      //   199: aload_2
      //   200: aload_1
      //   201: aload_0
      //   202: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   205: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   208: aload_2
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
      //   228: getstatic com/google/firebase/inappmessaging/CommonTypesProto$ScionConversionEvent.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/CommonTypesProto$ScionConversionEvent;
      //   231: areturn
      //   232: aload_2
      //   233: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   236: astore_1
      //   237: aload_3
      //   238: checkcast com/google/firebase/inappmessaging/CommonTypesProto$ScionConversionEvent
      //   241: astore_2
      //   242: aload_0
      //   243: aload_1
      //   244: aload_0
      //   245: getfield name_ : Ljava/lang/String;
      //   248: invokevirtual isEmpty : ()Z
      //   251: iconst_1
      //   252: ixor
      //   253: aload_0
      //   254: getfield name_ : Ljava/lang/String;
      //   257: iconst_1
      //   258: aload_2
      //   259: getfield name_ : Ljava/lang/String;
      //   262: invokevirtual isEmpty : ()Z
      //   265: ixor
      //   266: aload_2
      //   267: getfield name_ : Ljava/lang/String;
      //   270: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   275: putfield name_ : Ljava/lang/String;
      //   278: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   281: astore_1
      //   282: aload_0
      //   283: areturn
      //   284: new com/google/firebase/inappmessaging/CommonTypesProto$ScionConversionEvent$Builder
      //   287: dup
      //   288: aconst_null
      //   289: invokespecial <init> : (Lcom/google/firebase/inappmessaging/CommonTypesProto$1;)V
      //   292: areturn
      //   293: aconst_null
      //   294: areturn
      //   295: getstatic com/google/firebase/inappmessaging/CommonTypesProto$ScionConversionEvent.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/CommonTypesProto$ScionConversionEvent;
      //   298: areturn
      //   299: new com/google/firebase/inappmessaging/CommonTypesProto$ScionConversionEvent
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
    
    public String getName() {
      return this.name_;
    }
    
    public ByteString getNameBytes() {
      return ByteString.copyFromUtf8(this.name_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (!this.name_.isEmpty())
        i = 0 + CodedOutputStream.computeStringSize(1, getName()); 
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.name_.isEmpty())
        param1CodedOutputStream.writeString(1, getName()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<ScionConversionEvent, Builder> implements CommonTypesProto.ScionConversionEventOrBuilder {
      private Builder() {
        super(CommonTypesProto.ScionConversionEvent.DEFAULT_INSTANCE);
      }
      
      public Builder clearName() {
        copyOnWrite();
        ((CommonTypesProto.ScionConversionEvent)this.instance).clearName();
        return this;
      }
      
      public String getName() {
        return ((CommonTypesProto.ScionConversionEvent)this.instance).getName();
      }
      
      public ByteString getNameBytes() {
        return ((CommonTypesProto.ScionConversionEvent)this.instance).getNameBytes();
      }
      
      public Builder setName(String param2String) {
        copyOnWrite();
        ((CommonTypesProto.ScionConversionEvent)this.instance).setName(param2String);
        return this;
      }
      
      public Builder setNameBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((CommonTypesProto.ScionConversionEvent)this.instance).setNameBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ScionConversionEvent, ScionConversionEvent.Builder> implements ScionConversionEventOrBuilder {
    private Builder() {
      super(CommonTypesProto.ScionConversionEvent.DEFAULT_INSTANCE);
    }
    
    public Builder clearName() {
      copyOnWrite();
      ((CommonTypesProto.ScionConversionEvent)this.instance).clearName();
      return this;
    }
    
    public String getName() {
      return ((CommonTypesProto.ScionConversionEvent)this.instance).getName();
    }
    
    public ByteString getNameBytes() {
      return ((CommonTypesProto.ScionConversionEvent)this.instance).getNameBytes();
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      ((CommonTypesProto.ScionConversionEvent)this.instance).setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((CommonTypesProto.ScionConversionEvent)this.instance).setNameBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface ScionConversionEventOrBuilder extends MessageLiteOrBuilder {
    String getName();
    
    ByteString getNameBytes();
  }
  
  public enum Trigger implements Internal.EnumLite {
    APP_LAUNCH(0),
    ON_FOREGROUND(0),
    UNKNOWN_TRIGGER(0),
    UNRECOGNIZED(0);
    
    public static final int APP_LAUNCH_VALUE = 1;
    
    public static final int ON_FOREGROUND_VALUE = 2;
    
    public static final int UNKNOWN_TRIGGER_VALUE = 0;
    
    private static final Internal.EnumLiteMap<Trigger> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new Trigger[] { UNKNOWN_TRIGGER, APP_LAUNCH, ON_FOREGROUND, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Trigger>() {
          public CommonTypesProto.Trigger findValueByNumber(int param2Int) {
            return CommonTypesProto.Trigger.forNumber(param2Int);
          }
        };
    }
    
    Trigger(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static Trigger forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 2:
          return ON_FOREGROUND;
        case 1:
          return APP_LAUNCH;
        case 0:
          break;
      } 
      return UNKNOWN_TRIGGER;
    }
    
    public static Internal.EnumLiteMap<Trigger> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<Trigger> {
    public CommonTypesProto.Trigger findValueByNumber(int param1Int) {
      return CommonTypesProto.Trigger.forNumber(param1Int);
    }
  }
  
  public static final class TriggeringCondition extends GeneratedMessageLite<TriggeringCondition, TriggeringCondition.Builder> implements TriggeringConditionOrBuilder {
    private static final TriggeringCondition DEFAULT_INSTANCE = new TriggeringCondition();
    
    public static final int EVENT_FIELD_NUMBER = 2;
    
    public static final int FIAM_TRIGGER_FIELD_NUMBER = 1;
    
    private static volatile Parser<TriggeringCondition> PARSER;
    
    private int conditionCase_ = 0;
    
    private Object condition_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearCondition() {
      this.conditionCase_ = 0;
      this.condition_ = null;
    }
    
    private void clearEvent() {
      if (this.conditionCase_ == 2) {
        this.conditionCase_ = 0;
        this.condition_ = null;
      } 
    }
    
    private void clearFiamTrigger() {
      if (this.conditionCase_ == 1) {
        this.conditionCase_ = 0;
        this.condition_ = null;
      } 
    }
    
    public static TriggeringCondition getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeEvent(GmpMeasurement.Event param1Event) {
      if (this.conditionCase_ == 2 && this.condition_ != GmpMeasurement.Event.getDefaultInstance()) {
        this.condition_ = ((GmpMeasurement.Event.Builder)GmpMeasurement.Event.newBuilder((GmpMeasurement.Event)this.condition_).mergeFrom((GeneratedMessageLite)param1Event)).buildPartial();
      } else {
        this.condition_ = param1Event;
      } 
      this.conditionCase_ = 2;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(TriggeringCondition param1TriggeringCondition) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1TriggeringCondition);
    }
    
    public static TriggeringCondition parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (TriggeringCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static TriggeringCondition parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (TriggeringCondition)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static TriggeringCondition parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (TriggeringCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static TriggeringCondition parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (TriggeringCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static TriggeringCondition parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (TriggeringCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static TriggeringCondition parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (TriggeringCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static TriggeringCondition parseFrom(InputStream param1InputStream) throws IOException {
      return (TriggeringCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static TriggeringCondition parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (TriggeringCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static TriggeringCondition parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (TriggeringCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static TriggeringCondition parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (TriggeringCondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<TriggeringCondition> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setEvent(GmpMeasurement.Event.Builder param1Builder) {
      this.condition_ = param1Builder.build();
      this.conditionCase_ = 2;
    }
    
    private void setEvent(GmpMeasurement.Event param1Event) {
      if (param1Event != null) {
        this.condition_ = param1Event;
        this.conditionCase_ = 2;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setFiamTrigger(CommonTypesProto.Trigger param1Trigger) {
      if (param1Trigger != null) {
        this.conditionCase_ = 1;
        this.condition_ = Integer.valueOf(param1Trigger.getNumber());
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setFiamTriggerValue(int param1Int) {
      this.conditionCase_ = 1;
      this.condition_ = Integer.valueOf(param1Int);
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firebase/inappmessaging/CommonTypesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
      //   22: iload #4
      //   24: tableswitch default -> 72, 1 -> 522, 2 -> 518, 3 -> 516, 4 -> 507, 5 -> 335, 6 -> 126, 7 -> 331, 8 -> 80
      //   72: new java/lang/UnsupportedOperationException
      //   75: dup
      //   76: invokespecial <init> : ()V
      //   79: athrow
      //   80: getstatic com/google/firebase/inappmessaging/CommonTypesProto$TriggeringCondition.PARSER : Lcom/google/protobuf/Parser;
      //   83: ifnonnull -> 122
      //   86: ldc com/google/firebase/inappmessaging/CommonTypesProto$TriggeringCondition
      //   88: monitorenter
      //   89: getstatic com/google/firebase/inappmessaging/CommonTypesProto$TriggeringCondition.PARSER : Lcom/google/protobuf/Parser;
      //   92: ifnonnull -> 110
      //   95: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   98: astore_1
      //   99: aload_1
      //   100: getstatic com/google/firebase/inappmessaging/CommonTypesProto$TriggeringCondition.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/CommonTypesProto$TriggeringCondition;
      //   103: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   106: aload_1
      //   107: putstatic com/google/firebase/inappmessaging/CommonTypesProto$TriggeringCondition.PARSER : Lcom/google/protobuf/Parser;
      //   110: ldc com/google/firebase/inappmessaging/CommonTypesProto$TriggeringCondition
      //   112: monitorexit
      //   113: goto -> 122
      //   116: astore_1
      //   117: ldc com/google/firebase/inappmessaging/CommonTypesProto$TriggeringCondition
      //   119: monitorexit
      //   120: aload_1
      //   121: athrow
      //   122: getstatic com/google/firebase/inappmessaging/CommonTypesProto$TriggeringCondition.PARSER : Lcom/google/protobuf/Parser;
      //   125: areturn
      //   126: aload_2
      //   127: checkcast com/google/protobuf/CodedInputStream
      //   130: astore_2
      //   131: aload_3
      //   132: checkcast com/google/protobuf/ExtensionRegistryLite
      //   135: astore_3
      //   136: iload #8
      //   138: ifne -> 331
      //   141: aload_2
      //   142: invokevirtual readTag : ()I
      //   145: istore #4
      //   147: iload #4
      //   149: ifeq -> 275
      //   152: iload #4
      //   154: bipush #8
      //   156: if_icmpeq -> 252
      //   159: iload #4
      //   161: bipush #18
      //   163: if_icmpeq -> 181
      //   166: aload_2
      //   167: iload #4
      //   169: invokevirtual skipField : (I)Z
      //   172: ifne -> 136
      //   175: iconst_1
      //   176: istore #8
      //   178: goto -> 136
      //   181: aload_0
      //   182: getfield conditionCase_ : I
      //   185: iconst_2
      //   186: if_icmpne -> 206
      //   189: aload_0
      //   190: getfield condition_ : Ljava/lang/Object;
      //   193: checkcast analytics_collection/GmpMeasurement$Event
      //   196: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   199: checkcast analytics_collection/GmpMeasurement$Event$Builder
      //   202: astore_1
      //   203: goto -> 208
      //   206: aconst_null
      //   207: astore_1
      //   208: aload_0
      //   209: aload_2
      //   210: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   213: aload_3
      //   214: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   217: putfield condition_ : Ljava/lang/Object;
      //   220: aload_1
      //   221: ifnull -> 244
      //   224: aload_1
      //   225: aload_0
      //   226: getfield condition_ : Ljava/lang/Object;
      //   229: checkcast analytics_collection/GmpMeasurement$Event
      //   232: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   235: pop
      //   236: aload_0
      //   237: aload_1
      //   238: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   241: putfield condition_ : Ljava/lang/Object;
      //   244: aload_0
      //   245: iconst_2
      //   246: putfield conditionCase_ : I
      //   249: goto -> 136
      //   252: aload_2
      //   253: invokevirtual readEnum : ()I
      //   256: istore #4
      //   258: aload_0
      //   259: iconst_1
      //   260: putfield conditionCase_ : I
      //   263: aload_0
      //   264: iload #4
      //   266: invokestatic valueOf : (I)Ljava/lang/Integer;
      //   269: putfield condition_ : Ljava/lang/Object;
      //   272: goto -> 136
      //   275: iconst_1
      //   276: istore #8
      //   278: goto -> 136
      //   281: astore_1
      //   282: goto -> 329
      //   285: astore_3
      //   286: new java/lang/RuntimeException
      //   289: astore_2
      //   290: new com/google/protobuf/InvalidProtocolBufferException
      //   293: astore_1
      //   294: aload_1
      //   295: aload_3
      //   296: invokevirtual getMessage : ()Ljava/lang/String;
      //   299: invokespecial <init> : (Ljava/lang/String;)V
      //   302: aload_2
      //   303: aload_1
      //   304: aload_0
      //   305: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   308: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   311: aload_2
      //   312: athrow
      //   313: astore_1
      //   314: new java/lang/RuntimeException
      //   317: astore_2
      //   318: aload_2
      //   319: aload_1
      //   320: aload_0
      //   321: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   324: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   327: aload_2
      //   328: athrow
      //   329: aload_1
      //   330: athrow
      //   331: getstatic com/google/firebase/inappmessaging/CommonTypesProto$TriggeringCondition.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/CommonTypesProto$TriggeringCondition;
      //   334: areturn
      //   335: aload_2
      //   336: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   339: astore_1
      //   340: aload_3
      //   341: checkcast com/google/firebase/inappmessaging/CommonTypesProto$TriggeringCondition
      //   344: astore_2
      //   345: getstatic com/google/firebase/inappmessaging/CommonTypesProto$1.$SwitchMap$com$google$firebase$inappmessaging$CommonTypesProto$TriggeringCondition$ConditionCase : [I
      //   348: aload_2
      //   349: invokevirtual getConditionCase : ()Lcom/google/firebase/inappmessaging/CommonTypesProto$TriggeringCondition$ConditionCase;
      //   352: invokevirtual ordinal : ()I
      //   355: iaload
      //   356: tableswitch default -> 384, 1 -> 446, 2 -> 408, 3 -> 387
      //   384: goto -> 481
      //   387: aload_0
      //   388: getfield conditionCase_ : I
      //   391: ifeq -> 397
      //   394: iconst_1
      //   395: istore #5
      //   397: aload_1
      //   398: iload #5
      //   400: invokeinterface visitOneofNotSet : (Z)V
      //   405: goto -> 481
      //   408: iload #6
      //   410: istore #5
      //   412: aload_0
      //   413: getfield conditionCase_ : I
      //   416: iconst_2
      //   417: if_icmpne -> 423
      //   420: iconst_1
      //   421: istore #5
      //   423: aload_0
      //   424: aload_1
      //   425: iload #5
      //   427: aload_0
      //   428: getfield condition_ : Ljava/lang/Object;
      //   431: aload_2
      //   432: getfield condition_ : Ljava/lang/Object;
      //   435: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   440: putfield condition_ : Ljava/lang/Object;
      //   443: goto -> 481
      //   446: iload #7
      //   448: istore #5
      //   450: aload_0
      //   451: getfield conditionCase_ : I
      //   454: iconst_1
      //   455: if_icmpne -> 461
      //   458: iconst_1
      //   459: istore #5
      //   461: aload_0
      //   462: aload_1
      //   463: iload #5
      //   465: aload_0
      //   466: getfield condition_ : Ljava/lang/Object;
      //   469: aload_2
      //   470: getfield condition_ : Ljava/lang/Object;
      //   473: invokeinterface visitOneofInt : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   478: putfield condition_ : Ljava/lang/Object;
      //   481: aload_1
      //   482: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   485: if_acmpne -> 505
      //   488: aload_2
      //   489: getfield conditionCase_ : I
      //   492: istore #8
      //   494: iload #8
      //   496: ifeq -> 505
      //   499: aload_0
      //   500: iload #8
      //   502: putfield conditionCase_ : I
      //   505: aload_0
      //   506: areturn
      //   507: new com/google/firebase/inappmessaging/CommonTypesProto$TriggeringCondition$Builder
      //   510: dup
      //   511: aconst_null
      //   512: invokespecial <init> : (Lcom/google/firebase/inappmessaging/CommonTypesProto$1;)V
      //   515: areturn
      //   516: aconst_null
      //   517: areturn
      //   518: getstatic com/google/firebase/inappmessaging/CommonTypesProto$TriggeringCondition.DEFAULT_INSTANCE : Lcom/google/firebase/inappmessaging/CommonTypesProto$TriggeringCondition;
      //   521: areturn
      //   522: new com/google/firebase/inappmessaging/CommonTypesProto$TriggeringCondition
      //   525: dup
      //   526: invokespecial <init> : ()V
      //   529: areturn
      // Exception table:
      //   from	to	target	type
      //   89	110	116	finally
      //   110	113	116	finally
      //   117	120	116	finally
      //   141	147	313	com/google/protobuf/InvalidProtocolBufferException
      //   141	147	285	java/io/IOException
      //   141	147	281	finally
      //   166	175	313	com/google/protobuf/InvalidProtocolBufferException
      //   166	175	285	java/io/IOException
      //   166	175	281	finally
      //   181	203	313	com/google/protobuf/InvalidProtocolBufferException
      //   181	203	285	java/io/IOException
      //   181	203	281	finally
      //   208	220	313	com/google/protobuf/InvalidProtocolBufferException
      //   208	220	285	java/io/IOException
      //   208	220	281	finally
      //   224	244	313	com/google/protobuf/InvalidProtocolBufferException
      //   224	244	285	java/io/IOException
      //   224	244	281	finally
      //   244	249	313	com/google/protobuf/InvalidProtocolBufferException
      //   244	249	285	java/io/IOException
      //   244	249	281	finally
      //   252	272	313	com/google/protobuf/InvalidProtocolBufferException
      //   252	272	285	java/io/IOException
      //   252	272	281	finally
      //   286	313	281	finally
      //   314	329	281	finally
    }
    
    public ConditionCase getConditionCase() {
      return ConditionCase.forNumber(this.conditionCase_);
    }
    
    public GmpMeasurement.Event getEvent() {
      return (this.conditionCase_ == 2) ? (GmpMeasurement.Event)this.condition_ : GmpMeasurement.Event.getDefaultInstance();
    }
    
    public CommonTypesProto.Trigger getFiamTrigger() {
      if (this.conditionCase_ == 1) {
        CommonTypesProto.Trigger trigger1 = CommonTypesProto.Trigger.forNumber(((Integer)this.condition_).intValue());
        CommonTypesProto.Trigger trigger2 = trigger1;
        if (trigger1 == null)
          trigger2 = CommonTypesProto.Trigger.UNRECOGNIZED; 
        return trigger2;
      } 
      return CommonTypesProto.Trigger.UNKNOWN_TRIGGER;
    }
    
    public int getFiamTriggerValue() {
      return (this.conditionCase_ == 1) ? ((Integer)this.condition_).intValue() : 0;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (this.conditionCase_ == 1)
        i = 0 + CodedOutputStream.computeEnumSize(1, ((Integer)this.condition_).intValue()); 
      int j = i;
      if (this.conditionCase_ == 2)
        j = i + CodedOutputStream.computeMessageSize(2, (MessageLite)this.condition_); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.conditionCase_ == 1)
        param1CodedOutputStream.writeEnum(1, ((Integer)this.condition_).intValue()); 
      if (this.conditionCase_ == 2)
        param1CodedOutputStream.writeMessage(2, (MessageLite)this.condition_); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<TriggeringCondition, Builder> implements CommonTypesProto.TriggeringConditionOrBuilder {
      private Builder() {
        super(CommonTypesProto.TriggeringCondition.DEFAULT_INSTANCE);
      }
      
      public Builder clearCondition() {
        copyOnWrite();
        ((CommonTypesProto.TriggeringCondition)this.instance).clearCondition();
        return this;
      }
      
      public Builder clearEvent() {
        copyOnWrite();
        ((CommonTypesProto.TriggeringCondition)this.instance).clearEvent();
        return this;
      }
      
      public Builder clearFiamTrigger() {
        copyOnWrite();
        ((CommonTypesProto.TriggeringCondition)this.instance).clearFiamTrigger();
        return this;
      }
      
      public CommonTypesProto.TriggeringCondition.ConditionCase getConditionCase() {
        return ((CommonTypesProto.TriggeringCondition)this.instance).getConditionCase();
      }
      
      public GmpMeasurement.Event getEvent() {
        return ((CommonTypesProto.TriggeringCondition)this.instance).getEvent();
      }
      
      public CommonTypesProto.Trigger getFiamTrigger() {
        return ((CommonTypesProto.TriggeringCondition)this.instance).getFiamTrigger();
      }
      
      public int getFiamTriggerValue() {
        return ((CommonTypesProto.TriggeringCondition)this.instance).getFiamTriggerValue();
      }
      
      public Builder mergeEvent(GmpMeasurement.Event param2Event) {
        copyOnWrite();
        ((CommonTypesProto.TriggeringCondition)this.instance).mergeEvent(param2Event);
        return this;
      }
      
      public Builder setEvent(GmpMeasurement.Event.Builder param2Builder) {
        copyOnWrite();
        ((CommonTypesProto.TriggeringCondition)this.instance).setEvent(param2Builder);
        return this;
      }
      
      public Builder setEvent(GmpMeasurement.Event param2Event) {
        copyOnWrite();
        ((CommonTypesProto.TriggeringCondition)this.instance).setEvent(param2Event);
        return this;
      }
      
      public Builder setFiamTrigger(CommonTypesProto.Trigger param2Trigger) {
        copyOnWrite();
        ((CommonTypesProto.TriggeringCondition)this.instance).setFiamTrigger(param2Trigger);
        return this;
      }
      
      public Builder setFiamTriggerValue(int param2Int) {
        copyOnWrite();
        ((CommonTypesProto.TriggeringCondition)this.instance).setFiamTriggerValue(param2Int);
        return this;
      }
    }
    
    public enum ConditionCase implements Internal.EnumLite {
      CONDITION_NOT_SET(0),
      EVENT(0),
      FIAM_TRIGGER(1);
      
      private final int value;
      
      static {
        $VALUES = new ConditionCase[] { FIAM_TRIGGER, EVENT, CONDITION_NOT_SET };
      }
      
      ConditionCase(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static ConditionCase forNumber(int param2Int) {
        switch (param2Int) {
          default:
            return null;
          case 2:
            return EVENT;
          case 1:
            return FIAM_TRIGGER;
          case 0:
            break;
        } 
        return CONDITION_NOT_SET;
      }
      
      public int getNumber() {
        return this.value;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<TriggeringCondition, TriggeringCondition.Builder> implements TriggeringConditionOrBuilder {
    private Builder() {
      super(CommonTypesProto.TriggeringCondition.DEFAULT_INSTANCE);
    }
    
    public Builder clearCondition() {
      copyOnWrite();
      ((CommonTypesProto.TriggeringCondition)this.instance).clearCondition();
      return this;
    }
    
    public Builder clearEvent() {
      copyOnWrite();
      ((CommonTypesProto.TriggeringCondition)this.instance).clearEvent();
      return this;
    }
    
    public Builder clearFiamTrigger() {
      copyOnWrite();
      ((CommonTypesProto.TriggeringCondition)this.instance).clearFiamTrigger();
      return this;
    }
    
    public CommonTypesProto.TriggeringCondition.ConditionCase getConditionCase() {
      return ((CommonTypesProto.TriggeringCondition)this.instance).getConditionCase();
    }
    
    public GmpMeasurement.Event getEvent() {
      return ((CommonTypesProto.TriggeringCondition)this.instance).getEvent();
    }
    
    public CommonTypesProto.Trigger getFiamTrigger() {
      return ((CommonTypesProto.TriggeringCondition)this.instance).getFiamTrigger();
    }
    
    public int getFiamTriggerValue() {
      return ((CommonTypesProto.TriggeringCondition)this.instance).getFiamTriggerValue();
    }
    
    public Builder mergeEvent(GmpMeasurement.Event param1Event) {
      copyOnWrite();
      ((CommonTypesProto.TriggeringCondition)this.instance).mergeEvent(param1Event);
      return this;
    }
    
    public Builder setEvent(GmpMeasurement.Event.Builder param1Builder) {
      copyOnWrite();
      ((CommonTypesProto.TriggeringCondition)this.instance).setEvent(param1Builder);
      return this;
    }
    
    public Builder setEvent(GmpMeasurement.Event param1Event) {
      copyOnWrite();
      ((CommonTypesProto.TriggeringCondition)this.instance).setEvent(param1Event);
      return this;
    }
    
    public Builder setFiamTrigger(CommonTypesProto.Trigger param1Trigger) {
      copyOnWrite();
      ((CommonTypesProto.TriggeringCondition)this.instance).setFiamTrigger(param1Trigger);
      return this;
    }
    
    public Builder setFiamTriggerValue(int param1Int) {
      copyOnWrite();
      ((CommonTypesProto.TriggeringCondition)this.instance).setFiamTriggerValue(param1Int);
      return this;
    }
  }
  
  public enum ConditionCase implements Internal.EnumLite {
    CONDITION_NOT_SET(1),
    EVENT(1),
    FIAM_TRIGGER(1);
    
    private final int value;
    
    static {
      CONDITION_NOT_SET = new ConditionCase("CONDITION_NOT_SET", 2, 0);
      $VALUES = new ConditionCase[] { FIAM_TRIGGER, EVENT, CONDITION_NOT_SET };
    }
    
    ConditionCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ConditionCase forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 2:
          return EVENT;
        case 1:
          return FIAM_TRIGGER;
        case 0:
          break;
      } 
      return CONDITION_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
  
  public static interface TriggeringConditionOrBuilder extends MessageLiteOrBuilder {
    CommonTypesProto.TriggeringCondition.ConditionCase getConditionCase();
    
    GmpMeasurement.Event getEvent();
    
    CommonTypesProto.Trigger getFiamTrigger();
    
    int getFiamTriggerValue();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\CommonTypesProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */