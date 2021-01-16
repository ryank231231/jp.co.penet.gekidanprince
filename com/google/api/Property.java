package com.google.api;

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

public final class Property extends GeneratedMessageLite<Property, Property.Builder> implements PropertyOrBuilder {
  private static final Property DEFAULT_INSTANCE = new Property();
  
  public static final int DESCRIPTION_FIELD_NUMBER = 3;
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  private static volatile Parser<Property> PARSER;
  
  public static final int TYPE_FIELD_NUMBER = 2;
  
  private String description_ = "";
  
  private String name_ = "";
  
  private int type_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearDescription() {
    this.description_ = getDefaultInstance().getDescription();
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearType() {
    this.type_ = 0;
  }
  
  public static Property getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Property paramProperty) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramProperty);
  }
  
  public static Property parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Property)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Property parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Property)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Property parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Property)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Property parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Property)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Property parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Property)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Property parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Property)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Property parseFrom(InputStream paramInputStream) throws IOException {
    return (Property)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Property parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Property)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Property parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Property)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Property parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Property)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Property> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setDescription(String paramString) {
    if (paramString != null) {
      this.description_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDescriptionBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.description_ = paramByteString.toStringUtf8();
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
  
  private void setType(PropertyType paramPropertyType) {
    if (paramPropertyType != null) {
      this.type_ = paramPropertyType.getNumber();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setTypeValue(int paramInt) {
    this.type_ = paramInt;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/Property$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 428, 2 -> 424, 3 -> 422, 4 -> 413, 5 -> 273, 6 -> 118, 7 -> 269, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/api/Property.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/api/Property
    //   80: monitorenter
    //   81: getstatic com/google/api/Property.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/api/Property.DEFAULT_INSTANCE : Lcom/google/api/Property;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/api/Property.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/api/Property
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/api/Property
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/api/Property.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_1
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_2
    //   128: iload #6
    //   130: ifne -> 269
    //   133: aload_1
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 213
    //   144: iload #4
    //   146: bipush #10
    //   148: if_icmpeq -> 202
    //   151: iload #4
    //   153: bipush #16
    //   155: if_icmpeq -> 191
    //   158: iload #4
    //   160: bipush #26
    //   162: if_icmpeq -> 180
    //   165: aload_1
    //   166: iload #4
    //   168: invokevirtual skipField : (I)Z
    //   171: ifne -> 128
    //   174: iconst_1
    //   175: istore #6
    //   177: goto -> 128
    //   180: aload_0
    //   181: aload_1
    //   182: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   185: putfield description_ : Ljava/lang/String;
    //   188: goto -> 128
    //   191: aload_0
    //   192: aload_1
    //   193: invokevirtual readEnum : ()I
    //   196: putfield type_ : I
    //   199: goto -> 128
    //   202: aload_0
    //   203: aload_1
    //   204: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   207: putfield name_ : Ljava/lang/String;
    //   210: goto -> 128
    //   213: iconst_1
    //   214: istore #6
    //   216: goto -> 128
    //   219: astore_1
    //   220: goto -> 267
    //   223: astore_2
    //   224: new java/lang/RuntimeException
    //   227: astore_3
    //   228: new com/google/protobuf/InvalidProtocolBufferException
    //   231: astore_1
    //   232: aload_1
    //   233: aload_2
    //   234: invokevirtual getMessage : ()Ljava/lang/String;
    //   237: invokespecial <init> : (Ljava/lang/String;)V
    //   240: aload_3
    //   241: aload_1
    //   242: aload_0
    //   243: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   246: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   249: aload_3
    //   250: athrow
    //   251: astore_2
    //   252: new java/lang/RuntimeException
    //   255: astore_1
    //   256: aload_1
    //   257: aload_2
    //   258: aload_0
    //   259: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   262: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   265: aload_1
    //   266: athrow
    //   267: aload_1
    //   268: athrow
    //   269: getstatic com/google/api/Property.DEFAULT_INSTANCE : Lcom/google/api/Property;
    //   272: areturn
    //   273: aload_2
    //   274: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   277: astore_1
    //   278: aload_3
    //   279: checkcast com/google/api/Property
    //   282: astore_2
    //   283: aload_0
    //   284: aload_1
    //   285: aload_0
    //   286: getfield name_ : Ljava/lang/String;
    //   289: invokevirtual isEmpty : ()Z
    //   292: iconst_1
    //   293: ixor
    //   294: aload_0
    //   295: getfield name_ : Ljava/lang/String;
    //   298: aload_2
    //   299: getfield name_ : Ljava/lang/String;
    //   302: invokevirtual isEmpty : ()Z
    //   305: iconst_1
    //   306: ixor
    //   307: aload_2
    //   308: getfield name_ : Ljava/lang/String;
    //   311: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   316: putfield name_ : Ljava/lang/String;
    //   319: aload_0
    //   320: getfield type_ : I
    //   323: ifeq -> 332
    //   326: iconst_1
    //   327: istore #7
    //   329: goto -> 335
    //   332: iconst_0
    //   333: istore #7
    //   335: aload_0
    //   336: getfield type_ : I
    //   339: istore #6
    //   341: aload_2
    //   342: getfield type_ : I
    //   345: ifeq -> 351
    //   348: iconst_1
    //   349: istore #5
    //   351: aload_0
    //   352: aload_1
    //   353: iload #7
    //   355: iload #6
    //   357: iload #5
    //   359: aload_2
    //   360: getfield type_ : I
    //   363: invokeinterface visitInt : (ZIZI)I
    //   368: putfield type_ : I
    //   371: aload_0
    //   372: aload_1
    //   373: aload_0
    //   374: getfield description_ : Ljava/lang/String;
    //   377: invokevirtual isEmpty : ()Z
    //   380: iconst_1
    //   381: ixor
    //   382: aload_0
    //   383: getfield description_ : Ljava/lang/String;
    //   386: aload_2
    //   387: getfield description_ : Ljava/lang/String;
    //   390: invokevirtual isEmpty : ()Z
    //   393: iconst_1
    //   394: ixor
    //   395: aload_2
    //   396: getfield description_ : Ljava/lang/String;
    //   399: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   404: putfield description_ : Ljava/lang/String;
    //   407: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   410: astore_1
    //   411: aload_0
    //   412: areturn
    //   413: new com/google/api/Property$Builder
    //   416: dup
    //   417: aconst_null
    //   418: invokespecial <init> : (Lcom/google/api/Property$1;)V
    //   421: areturn
    //   422: aconst_null
    //   423: areturn
    //   424: getstatic com/google/api/Property.DEFAULT_INSTANCE : Lcom/google/api/Property;
    //   427: areturn
    //   428: new com/google/api/Property
    //   431: dup
    //   432: invokespecial <init> : ()V
    //   435: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	251	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	223	java/io/IOException
    //   133	139	219	finally
    //   165	174	251	com/google/protobuf/InvalidProtocolBufferException
    //   165	174	223	java/io/IOException
    //   165	174	219	finally
    //   180	188	251	com/google/protobuf/InvalidProtocolBufferException
    //   180	188	223	java/io/IOException
    //   180	188	219	finally
    //   191	199	251	com/google/protobuf/InvalidProtocolBufferException
    //   191	199	223	java/io/IOException
    //   191	199	219	finally
    //   202	210	251	com/google/protobuf/InvalidProtocolBufferException
    //   202	210	223	java/io/IOException
    //   202	210	219	finally
    //   224	251	219	finally
    //   252	267	219	finally
  }
  
  public String getDescription() {
    return this.description_;
  }
  
  public ByteString getDescriptionBytes() {
    return ByteString.copyFromUtf8(this.description_);
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
    int j = 0;
    if (!this.name_.isEmpty())
      j = 0 + CodedOutputStream.computeStringSize(1, getName()); 
    i = j;
    if (this.type_ != PropertyType.UNSPECIFIED.getNumber())
      i = j + CodedOutputStream.computeEnumSize(2, this.type_); 
    j = i;
    if (!this.description_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(3, getDescription()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public PropertyType getType() {
    PropertyType propertyType1 = PropertyType.forNumber(this.type_);
    PropertyType propertyType2 = propertyType1;
    if (propertyType1 == null)
      propertyType2 = PropertyType.UNRECOGNIZED; 
    return propertyType2;
  }
  
  public int getTypeValue() {
    return this.type_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(1, getName()); 
    if (this.type_ != PropertyType.UNSPECIFIED.getNumber())
      paramCodedOutputStream.writeEnum(2, this.type_); 
    if (!this.description_.isEmpty())
      paramCodedOutputStream.writeString(3, getDescription()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Property, Builder> implements PropertyOrBuilder {
    private Builder() {
      super(Property.DEFAULT_INSTANCE);
    }
    
    public Builder clearDescription() {
      copyOnWrite();
      ((Property)this.instance).clearDescription();
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      ((Property)this.instance).clearName();
      return this;
    }
    
    public Builder clearType() {
      copyOnWrite();
      ((Property)this.instance).clearType();
      return this;
    }
    
    public String getDescription() {
      return ((Property)this.instance).getDescription();
    }
    
    public ByteString getDescriptionBytes() {
      return ((Property)this.instance).getDescriptionBytes();
    }
    
    public String getName() {
      return ((Property)this.instance).getName();
    }
    
    public ByteString getNameBytes() {
      return ((Property)this.instance).getNameBytes();
    }
    
    public Property.PropertyType getType() {
      return ((Property)this.instance).getType();
    }
    
    public int getTypeValue() {
      return ((Property)this.instance).getTypeValue();
    }
    
    public Builder setDescription(String param1String) {
      copyOnWrite();
      ((Property)this.instance).setDescription(param1String);
      return this;
    }
    
    public Builder setDescriptionBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Property)this.instance).setDescriptionBytes(param1ByteString);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      ((Property)this.instance).setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Property)this.instance).setNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setType(Property.PropertyType param1PropertyType) {
      copyOnWrite();
      ((Property)this.instance).setType(param1PropertyType);
      return this;
    }
    
    public Builder setTypeValue(int param1Int) {
      copyOnWrite();
      ((Property)this.instance).setTypeValue(param1Int);
      return this;
    }
  }
  
  public enum PropertyType implements Internal.EnumLite {
    BOOL,
    DOUBLE,
    INT64,
    STRING,
    UNRECOGNIZED,
    UNSPECIFIED(0);
    
    public static final int BOOL_VALUE = 2;
    
    public static final int DOUBLE_VALUE = 4;
    
    public static final int INT64_VALUE = 1;
    
    public static final int STRING_VALUE = 3;
    
    public static final int UNSPECIFIED_VALUE = 0;
    
    private static final Internal.EnumLiteMap<PropertyType> internalValueMap;
    
    private final int value;
    
    static {
      BOOL = new PropertyType("BOOL", 2, 2);
      STRING = new PropertyType("STRING", 3, 3);
      DOUBLE = new PropertyType("DOUBLE", 4, 4);
      UNRECOGNIZED = new PropertyType("UNRECOGNIZED", 5, -1);
      $VALUES = new PropertyType[] { UNSPECIFIED, INT64, BOOL, STRING, DOUBLE, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<PropertyType>() {
          public Property.PropertyType findValueByNumber(int param2Int) {
            return Property.PropertyType.forNumber(param2Int);
          }
        };
    }
    
    PropertyType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static PropertyType forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 4:
          return DOUBLE;
        case 3:
          return STRING;
        case 2:
          return BOOL;
        case 1:
          return INT64;
        case 0:
          break;
      } 
      return UNSPECIFIED;
    }
    
    public static Internal.EnumLiteMap<PropertyType> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<PropertyType> {
    public Property.PropertyType findValueByNumber(int param1Int) {
      return Property.PropertyType.forNumber(param1Int);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\Property.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */