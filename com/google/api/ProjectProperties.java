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

public final class ProjectProperties extends GeneratedMessageLite<ProjectProperties, ProjectProperties.Builder> implements ProjectPropertiesOrBuilder {
  private static final ProjectProperties DEFAULT_INSTANCE = new ProjectProperties();
  
  private static volatile Parser<ProjectProperties> PARSER;
  
  public static final int PROPERTIES_FIELD_NUMBER = 1;
  
  private Internal.ProtobufList<Property> properties_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllProperties(Iterable<? extends Property> paramIterable) {
    ensurePropertiesIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.properties_);
  }
  
  private void addProperties(int paramInt, Property.Builder paramBuilder) {
    ensurePropertiesIsMutable();
    this.properties_.add(paramInt, paramBuilder.build());
  }
  
  private void addProperties(int paramInt, Property paramProperty) {
    if (paramProperty != null) {
      ensurePropertiesIsMutable();
      this.properties_.add(paramInt, paramProperty);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addProperties(Property.Builder paramBuilder) {
    ensurePropertiesIsMutable();
    this.properties_.add(paramBuilder.build());
  }
  
  private void addProperties(Property paramProperty) {
    if (paramProperty != null) {
      ensurePropertiesIsMutable();
      this.properties_.add(paramProperty);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearProperties() {
    this.properties_ = emptyProtobufList();
  }
  
  private void ensurePropertiesIsMutable() {
    if (!this.properties_.isModifiable())
      this.properties_ = GeneratedMessageLite.mutableCopy(this.properties_); 
  }
  
  public static ProjectProperties getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ProjectProperties paramProjectProperties) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramProjectProperties);
  }
  
  public static ProjectProperties parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ProjectProperties)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ProjectProperties parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ProjectProperties)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ProjectProperties parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (ProjectProperties)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static ProjectProperties parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ProjectProperties)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static ProjectProperties parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (ProjectProperties)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static ProjectProperties parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ProjectProperties)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ProjectProperties parseFrom(InputStream paramInputStream) throws IOException {
    return (ProjectProperties)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ProjectProperties parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ProjectProperties)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ProjectProperties parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (ProjectProperties)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static ProjectProperties parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ProjectProperties)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ProjectProperties> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeProperties(int paramInt) {
    ensurePropertiesIsMutable();
    this.properties_.remove(paramInt);
  }
  
  private void setProperties(int paramInt, Property.Builder paramBuilder) {
    ensurePropertiesIsMutable();
    this.properties_.set(paramInt, paramBuilder.build());
  }
  
  private void setProperties(int paramInt, Property paramProperty) {
    if (paramProperty != null) {
      ensurePropertiesIsMutable();
      this.properties_.set(paramInt, paramProperty);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/ProjectProperties$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 326, 2 -> 322, 3 -> 311, 4 -> 302, 5 -> 268, 6 -> 110, 7 -> 264, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/api/ProjectProperties.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/api/ProjectProperties
    //   72: monitorenter
    //   73: getstatic com/google/api/ProjectProperties.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/api/ProjectProperties.DEFAULT_INSTANCE : Lcom/google/api/ProjectProperties;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/api/ProjectProperties.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/api/ProjectProperties
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/api/ProjectProperties
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/api/ProjectProperties.PARSER : Lcom/google/protobuf/Parser;
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
    //   162: getfield properties_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   165: invokeinterface isModifiable : ()Z
    //   170: ifne -> 184
    //   173: aload_0
    //   174: aload_0
    //   175: getfield properties_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   178: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   181: putfield properties_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   184: aload_0
    //   185: getfield properties_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   188: aload_1
    //   189: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   192: aload_2
    //   193: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   196: checkcast com/google/api/Property
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
    //   246: astore_1
    //   247: new java/lang/RuntimeException
    //   250: astore_2
    //   251: aload_2
    //   252: aload_1
    //   253: aload_0
    //   254: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   257: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   260: aload_2
    //   261: athrow
    //   262: aload_1
    //   263: athrow
    //   264: getstatic com/google/api/ProjectProperties.DEFAULT_INSTANCE : Lcom/google/api/ProjectProperties;
    //   267: areturn
    //   268: aload_2
    //   269: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   272: astore_1
    //   273: aload_3
    //   274: checkcast com/google/api/ProjectProperties
    //   277: astore_2
    //   278: aload_0
    //   279: aload_1
    //   280: aload_0
    //   281: getfield properties_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   284: aload_2
    //   285: getfield properties_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   288: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   293: putfield properties_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   296: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   299: astore_1
    //   300: aload_0
    //   301: areturn
    //   302: new com/google/api/ProjectProperties$Builder
    //   305: dup
    //   306: aconst_null
    //   307: invokespecial <init> : (Lcom/google/api/ProjectProperties$1;)V
    //   310: areturn
    //   311: aload_0
    //   312: getfield properties_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   315: invokeinterface makeImmutable : ()V
    //   320: aconst_null
    //   321: areturn
    //   322: getstatic com/google/api/ProjectProperties.DEFAULT_INSTANCE : Lcom/google/api/ProjectProperties;
    //   325: areturn
    //   326: new com/google/api/ProjectProperties
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
  
  public Property getProperties(int paramInt) {
    return (Property)this.properties_.get(paramInt);
  }
  
  public int getPropertiesCount() {
    return this.properties_.size();
  }
  
  public List<Property> getPropertiesList() {
    return (List<Property>)this.properties_;
  }
  
  public PropertyOrBuilder getPropertiesOrBuilder(int paramInt) {
    return (PropertyOrBuilder)this.properties_.get(paramInt);
  }
  
  public List<? extends PropertyOrBuilder> getPropertiesOrBuilderList() {
    return (List)this.properties_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    byte b = 0;
    i = 0;
    while (b < this.properties_.size()) {
      i += CodedOutputStream.computeMessageSize(1, (MessageLite)this.properties_.get(b));
      b++;
    } 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (byte b = 0; b < this.properties_.size(); b++)
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.properties_.get(b)); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ProjectProperties, Builder> implements ProjectPropertiesOrBuilder {
    private Builder() {
      super(ProjectProperties.DEFAULT_INSTANCE);
    }
    
    public Builder addAllProperties(Iterable<? extends Property> param1Iterable) {
      copyOnWrite();
      ((ProjectProperties)this.instance).addAllProperties(param1Iterable);
      return this;
    }
    
    public Builder addProperties(int param1Int, Property.Builder param1Builder) {
      copyOnWrite();
      ((ProjectProperties)this.instance).addProperties(param1Int, param1Builder);
      return this;
    }
    
    public Builder addProperties(int param1Int, Property param1Property) {
      copyOnWrite();
      ((ProjectProperties)this.instance).addProperties(param1Int, param1Property);
      return this;
    }
    
    public Builder addProperties(Property.Builder param1Builder) {
      copyOnWrite();
      ((ProjectProperties)this.instance).addProperties(param1Builder);
      return this;
    }
    
    public Builder addProperties(Property param1Property) {
      copyOnWrite();
      ((ProjectProperties)this.instance).addProperties(param1Property);
      return this;
    }
    
    public Builder clearProperties() {
      copyOnWrite();
      ((ProjectProperties)this.instance).clearProperties();
      return this;
    }
    
    public Property getProperties(int param1Int) {
      return ((ProjectProperties)this.instance).getProperties(param1Int);
    }
    
    public int getPropertiesCount() {
      return ((ProjectProperties)this.instance).getPropertiesCount();
    }
    
    public List<Property> getPropertiesList() {
      return Collections.unmodifiableList(((ProjectProperties)this.instance).getPropertiesList());
    }
    
    public Builder removeProperties(int param1Int) {
      copyOnWrite();
      ((ProjectProperties)this.instance).removeProperties(param1Int);
      return this;
    }
    
    public Builder setProperties(int param1Int, Property.Builder param1Builder) {
      copyOnWrite();
      ((ProjectProperties)this.instance).setProperties(param1Int, param1Builder);
      return this;
    }
    
    public Builder setProperties(int param1Int, Property param1Property) {
      copyOnWrite();
      ((ProjectProperties)this.instance).setProperties(param1Int, param1Property);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\ProjectProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */