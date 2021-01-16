package com.google.protos.datapol;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class RetentionAnnotations {
  static {
  
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class RetentionSpec extends GeneratedMessageLite<RetentionSpec, RetentionSpec.Builder> implements RetentionSpecOrBuilder {
    public static final int CONTEXT_FIELD_NUMBER = 2;
    
    private static final RetentionSpec DEFAULT_INSTANCE = new RetentionSpec();
    
    public static final int DESIRED_RETENTION_FIELD_NUMBER = 1;
    
    private static volatile Parser<RetentionSpec> PARSER;
    
    private int bitField0_;
    
    private String context_ = "*";
    
    private int desiredRetention_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearContext() {
      this.bitField0_ &= 0xFFFFFFFD;
      this.context_ = getDefaultInstance().getContext();
    }
    
    private void clearDesiredRetention() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.desiredRetention_ = 0;
    }
    
    public static RetentionSpec getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(RetentionSpec param1RetentionSpec) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1RetentionSpec);
    }
    
    public static RetentionSpec parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (RetentionSpec)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static RetentionSpec parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (RetentionSpec)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static RetentionSpec parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (RetentionSpec)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static RetentionSpec parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (RetentionSpec)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static RetentionSpec parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (RetentionSpec)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static RetentionSpec parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (RetentionSpec)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static RetentionSpec parseFrom(InputStream param1InputStream) throws IOException {
      return (RetentionSpec)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static RetentionSpec parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (RetentionSpec)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static RetentionSpec parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (RetentionSpec)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static RetentionSpec parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (RetentionSpec)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<RetentionSpec> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setContext(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x2;
        this.context_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setContextBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x2;
        this.context_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setDesiredRetention(RetentionAnnotations.RetentionTag param1RetentionTag) {
      if (param1RetentionTag != null) {
        this.bitField0_ |= 0x1;
        this.desiredRetention_ = param1RetentionTag.getNumber();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/protos/datapol/RetentionAnnotations$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 394, 2 -> 390, 3 -> 388, 4 -> 379, 5 -> 295, 6 -> 110, 7 -> 291, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/protos/datapol/RetentionAnnotations$RetentionSpec.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/protos/datapol/RetentionAnnotations$RetentionSpec
      //   72: monitorenter
      //   73: getstatic com/google/protos/datapol/RetentionAnnotations$RetentionSpec.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/protos/datapol/RetentionAnnotations$RetentionSpec.DEFAULT_INSTANCE : Lcom/google/protos/datapol/RetentionAnnotations$RetentionSpec;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/protos/datapol/RetentionAnnotations$RetentionSpec.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/protos/datapol/RetentionAnnotations$RetentionSpec
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/protos/datapol/RetentionAnnotations$RetentionSpec
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/protos/datapol/RetentionAnnotations$RetentionSpec.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 291
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 235
      //   139: iload #5
      //   141: bipush #8
      //   143: if_icmpeq -> 192
      //   146: iload #5
      //   148: bipush #18
      //   150: if_icmpeq -> 169
      //   153: aload_0
      //   154: iload #5
      //   156: aload_1
      //   157: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   160: ifne -> 123
      //   163: iconst_1
      //   164: istore #4
      //   166: goto -> 123
      //   169: aload_1
      //   170: invokevirtual readString : ()Ljava/lang/String;
      //   173: astore_2
      //   174: aload_0
      //   175: aload_0
      //   176: getfield bitField0_ : I
      //   179: iconst_2
      //   180: ior
      //   181: putfield bitField0_ : I
      //   184: aload_0
      //   185: aload_2
      //   186: putfield context_ : Ljava/lang/String;
      //   189: goto -> 123
      //   192: aload_1
      //   193: invokevirtual readEnum : ()I
      //   196: istore #5
      //   198: iload #5
      //   200: invokestatic forNumber : (I)Lcom/google/protos/datapol/RetentionAnnotations$RetentionTag;
      //   203: ifnonnull -> 216
      //   206: aload_0
      //   207: iconst_1
      //   208: iload #5
      //   210: invokespecial mergeVarintField : (II)V
      //   213: goto -> 123
      //   216: aload_0
      //   217: iconst_1
      //   218: aload_0
      //   219: getfield bitField0_ : I
      //   222: ior
      //   223: putfield bitField0_ : I
      //   226: aload_0
      //   227: iload #5
      //   229: putfield desiredRetention_ : I
      //   232: goto -> 123
      //   235: iconst_1
      //   236: istore #4
      //   238: goto -> 123
      //   241: astore_1
      //   242: goto -> 289
      //   245: astore_1
      //   246: new java/lang/RuntimeException
      //   249: astore_2
      //   250: new com/google/protobuf/InvalidProtocolBufferException
      //   253: astore_3
      //   254: aload_3
      //   255: aload_1
      //   256: invokevirtual getMessage : ()Ljava/lang/String;
      //   259: invokespecial <init> : (Ljava/lang/String;)V
      //   262: aload_2
      //   263: aload_3
      //   264: aload_0
      //   265: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   268: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   271: aload_2
      //   272: athrow
      //   273: astore_2
      //   274: new java/lang/RuntimeException
      //   277: astore_1
      //   278: aload_1
      //   279: aload_2
      //   280: aload_0
      //   281: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   284: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   287: aload_1
      //   288: athrow
      //   289: aload_1
      //   290: athrow
      //   291: getstatic com/google/protos/datapol/RetentionAnnotations$RetentionSpec.DEFAULT_INSTANCE : Lcom/google/protos/datapol/RetentionAnnotations$RetentionSpec;
      //   294: areturn
      //   295: aload_2
      //   296: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   299: astore_1
      //   300: aload_3
      //   301: checkcast com/google/protos/datapol/RetentionAnnotations$RetentionSpec
      //   304: astore_2
      //   305: aload_0
      //   306: aload_1
      //   307: aload_0
      //   308: invokevirtual hasDesiredRetention : ()Z
      //   311: aload_0
      //   312: getfield desiredRetention_ : I
      //   315: aload_2
      //   316: invokevirtual hasDesiredRetention : ()Z
      //   319: aload_2
      //   320: getfield desiredRetention_ : I
      //   323: invokeinterface visitInt : (ZIZI)I
      //   328: putfield desiredRetention_ : I
      //   331: aload_0
      //   332: aload_1
      //   333: aload_0
      //   334: invokevirtual hasContext : ()Z
      //   337: aload_0
      //   338: getfield context_ : Ljava/lang/String;
      //   341: aload_2
      //   342: invokevirtual hasContext : ()Z
      //   345: aload_2
      //   346: getfield context_ : Ljava/lang/String;
      //   349: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   354: putfield context_ : Ljava/lang/String;
      //   357: aload_1
      //   358: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   361: if_acmpne -> 377
      //   364: aload_0
      //   365: aload_0
      //   366: getfield bitField0_ : I
      //   369: aload_2
      //   370: getfield bitField0_ : I
      //   373: ior
      //   374: putfield bitField0_ : I
      //   377: aload_0
      //   378: areturn
      //   379: new com/google/protos/datapol/RetentionAnnotations$RetentionSpec$Builder
      //   382: dup
      //   383: aconst_null
      //   384: invokespecial <init> : (Lcom/google/protos/datapol/RetentionAnnotations$1;)V
      //   387: areturn
      //   388: aconst_null
      //   389: areturn
      //   390: getstatic com/google/protos/datapol/RetentionAnnotations$RetentionSpec.DEFAULT_INSTANCE : Lcom/google/protos/datapol/RetentionAnnotations$RetentionSpec;
      //   393: areturn
      //   394: new com/google/protos/datapol/RetentionAnnotations$RetentionSpec
      //   397: dup
      //   398: invokespecial <init> : ()V
      //   401: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	273	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	245	java/io/IOException
      //   128	134	241	finally
      //   153	163	273	com/google/protobuf/InvalidProtocolBufferException
      //   153	163	245	java/io/IOException
      //   153	163	241	finally
      //   169	189	273	com/google/protobuf/InvalidProtocolBufferException
      //   169	189	245	java/io/IOException
      //   169	189	241	finally
      //   192	213	273	com/google/protobuf/InvalidProtocolBufferException
      //   192	213	245	java/io/IOException
      //   192	213	241	finally
      //   216	232	273	com/google/protobuf/InvalidProtocolBufferException
      //   216	232	245	java/io/IOException
      //   216	232	241	finally
      //   246	273	241	finally
      //   274	289	241	finally
    }
    
    public String getContext() {
      return this.context_;
    }
    
    public ByteString getContextBytes() {
      return ByteString.copyFromUtf8(this.context_);
    }
    
    public RetentionAnnotations.RetentionTag getDesiredRetention() {
      RetentionAnnotations.RetentionTag retentionTag1 = RetentionAnnotations.RetentionTag.forNumber(this.desiredRetention_);
      RetentionAnnotations.RetentionTag retentionTag2 = retentionTag1;
      if (retentionTag1 == null)
        retentionTag2 = RetentionAnnotations.RetentionTag.RT_DEFAULT; 
      return retentionTag2;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if ((this.bitField0_ & 0x1) == 1)
        i = 0 + CodedOutputStream.computeEnumSize(1, this.desiredRetention_); 
      int j = i;
      if ((this.bitField0_ & 0x2) == 2)
        j = i + CodedOutputStream.computeStringSize(2, getContext()); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasContext() {
      boolean bool;
      if ((this.bitField0_ & 0x2) == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasDesiredRetention() {
      int i = this.bitField0_;
      boolean bool = true;
      if ((i & 0x1) != 1)
        bool = false; 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if ((this.bitField0_ & 0x1) == 1)
        param1CodedOutputStream.writeEnum(1, this.desiredRetention_); 
      if ((this.bitField0_ & 0x2) == 2)
        param1CodedOutputStream.writeString(2, getContext()); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<RetentionSpec, Builder> implements RetentionAnnotations.RetentionSpecOrBuilder {
      private Builder() {
        super(RetentionAnnotations.RetentionSpec.DEFAULT_INSTANCE);
      }
      
      public Builder clearContext() {
        copyOnWrite();
        ((RetentionAnnotations.RetentionSpec)this.instance).clearContext();
        return this;
      }
      
      public Builder clearDesiredRetention() {
        copyOnWrite();
        ((RetentionAnnotations.RetentionSpec)this.instance).clearDesiredRetention();
        return this;
      }
      
      public String getContext() {
        return ((RetentionAnnotations.RetentionSpec)this.instance).getContext();
      }
      
      public ByteString getContextBytes() {
        return ((RetentionAnnotations.RetentionSpec)this.instance).getContextBytes();
      }
      
      public RetentionAnnotations.RetentionTag getDesiredRetention() {
        return ((RetentionAnnotations.RetentionSpec)this.instance).getDesiredRetention();
      }
      
      public boolean hasContext() {
        return ((RetentionAnnotations.RetentionSpec)this.instance).hasContext();
      }
      
      public boolean hasDesiredRetention() {
        return ((RetentionAnnotations.RetentionSpec)this.instance).hasDesiredRetention();
      }
      
      public Builder setContext(String param2String) {
        copyOnWrite();
        ((RetentionAnnotations.RetentionSpec)this.instance).setContext(param2String);
        return this;
      }
      
      public Builder setContextBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((RetentionAnnotations.RetentionSpec)this.instance).setContextBytes(param2ByteString);
        return this;
      }
      
      public Builder setDesiredRetention(RetentionAnnotations.RetentionTag param2RetentionTag) {
        copyOnWrite();
        ((RetentionAnnotations.RetentionSpec)this.instance).setDesiredRetention(param2RetentionTag);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<RetentionSpec, RetentionSpec.Builder> implements RetentionSpecOrBuilder {
    private Builder() {
      super(RetentionAnnotations.RetentionSpec.DEFAULT_INSTANCE);
    }
    
    public Builder clearContext() {
      copyOnWrite();
      ((RetentionAnnotations.RetentionSpec)this.instance).clearContext();
      return this;
    }
    
    public Builder clearDesiredRetention() {
      copyOnWrite();
      ((RetentionAnnotations.RetentionSpec)this.instance).clearDesiredRetention();
      return this;
    }
    
    public String getContext() {
      return ((RetentionAnnotations.RetentionSpec)this.instance).getContext();
    }
    
    public ByteString getContextBytes() {
      return ((RetentionAnnotations.RetentionSpec)this.instance).getContextBytes();
    }
    
    public RetentionAnnotations.RetentionTag getDesiredRetention() {
      return ((RetentionAnnotations.RetentionSpec)this.instance).getDesiredRetention();
    }
    
    public boolean hasContext() {
      return ((RetentionAnnotations.RetentionSpec)this.instance).hasContext();
    }
    
    public boolean hasDesiredRetention() {
      return ((RetentionAnnotations.RetentionSpec)this.instance).hasDesiredRetention();
    }
    
    public Builder setContext(String param1String) {
      copyOnWrite();
      ((RetentionAnnotations.RetentionSpec)this.instance).setContext(param1String);
      return this;
    }
    
    public Builder setContextBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((RetentionAnnotations.RetentionSpec)this.instance).setContextBytes(param1ByteString);
      return this;
    }
    
    public Builder setDesiredRetention(RetentionAnnotations.RetentionTag param1RetentionTag) {
      copyOnWrite();
      ((RetentionAnnotations.RetentionSpec)this.instance).setDesiredRetention(param1RetentionTag);
      return this;
    }
  }
  
  public static interface RetentionSpecOrBuilder extends MessageLiteOrBuilder {
    String getContext();
    
    ByteString getContextBytes();
    
    RetentionAnnotations.RetentionTag getDesiredRetention();
    
    boolean hasContext();
    
    boolean hasDesiredRetention();
  }
  
  public enum RetentionTag implements Internal.EnumLite {
    RT_16_MONTHS,
    RT_2_YEARS,
    RT_3_YEARS,
    RT_5_WEEKS,
    RT_ARCHIVAL,
    RT_DEFAULT(0),
    RT_HALF_A_YEAR(0),
    RT_MONTH(0),
    RT_OBSOLETE(1),
    RT_QUARTER(1),
    RT_WEEK(10),
    RT_YEAR(10),
    RT_YEAR_AND_A_HALF(10);
    
    public static final int RT_16_MONTHS_VALUE = 58;
    
    public static final int RT_2_YEARS_VALUE = 70;
    
    public static final int RT_3_YEARS_VALUE = 80;
    
    public static final int RT_5_WEEKS_VALUE = 21;
    
    public static final int RT_ARCHIVAL_VALUE = 1000;
    
    public static final int RT_DEFAULT_VALUE = 0;
    
    public static final int RT_HALF_A_YEAR_VALUE = 40;
    
    public static final int RT_MONTH_VALUE = 20;
    
    public static final int RT_OBSOLETE_VALUE = 1;
    
    public static final int RT_QUARTER_VALUE = 30;
    
    public static final int RT_WEEK_VALUE = 10;
    
    public static final int RT_YEAR_AND_A_HALF_VALUE = 60;
    
    public static final int RT_YEAR_VALUE = 50;
    
    private static final Internal.EnumLiteMap<RetentionTag> internalValueMap;
    
    private final int value;
    
    static {
      RT_5_WEEKS = new RetentionTag("RT_5_WEEKS", 4, 21);
      RT_QUARTER = new RetentionTag("RT_QUARTER", 5, 30);
      RT_HALF_A_YEAR = new RetentionTag("RT_HALF_A_YEAR", 6, 40);
      RT_YEAR = new RetentionTag("RT_YEAR", 7, 50);
      RT_16_MONTHS = new RetentionTag("RT_16_MONTHS", 8, 58);
      RT_YEAR_AND_A_HALF = new RetentionTag("RT_YEAR_AND_A_HALF", 9, 60);
      RT_2_YEARS = new RetentionTag("RT_2_YEARS", 10, 70);
      RT_3_YEARS = new RetentionTag("RT_3_YEARS", 11, 80);
      RT_ARCHIVAL = new RetentionTag("RT_ARCHIVAL", 12, 1000);
      $VALUES = new RetentionTag[] { 
          RT_DEFAULT, RT_OBSOLETE, RT_WEEK, RT_MONTH, RT_5_WEEKS, RT_QUARTER, RT_HALF_A_YEAR, RT_YEAR, RT_16_MONTHS, RT_YEAR_AND_A_HALF, 
          RT_2_YEARS, RT_3_YEARS, RT_ARCHIVAL };
      internalValueMap = new Internal.EnumLiteMap<RetentionTag>() {
          public RetentionAnnotations.RetentionTag findValueByNumber(int param2Int) {
            return RetentionAnnotations.RetentionTag.forNumber(param2Int);
          }
        };
    }
    
    RetentionTag(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static RetentionTag forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 1000:
          return RT_ARCHIVAL;
        case 80:
          return RT_3_YEARS;
        case 70:
          return RT_2_YEARS;
        case 60:
          return RT_YEAR_AND_A_HALF;
        case 58:
          return RT_16_MONTHS;
        case 50:
          return RT_YEAR;
        case 40:
          return RT_HALF_A_YEAR;
        case 30:
          return RT_QUARTER;
        case 21:
          return RT_5_WEEKS;
        case 20:
          return RT_MONTH;
        case 10:
          return RT_WEEK;
        case 1:
          return RT_OBSOLETE;
        case 0:
          break;
      } 
      return RT_DEFAULT;
    }
    
    public static Internal.EnumLiteMap<RetentionTag> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<RetentionTag> {
    public RetentionAnnotations.RetentionTag findValueByNumber(int param1Int) {
      return RetentionAnnotations.RetentionTag.forNumber(param1Int);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protos\datapol\RetentionAnnotations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */