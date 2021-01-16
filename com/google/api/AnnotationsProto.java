package com.google.api;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;

public final class AnnotationsProto {
  public static final int HTTP_FIELD_NUMBER = 72295728;
  
  public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.MethodOptions, HttpRule> http = GeneratedMessageLite.newSingularGeneratedExtension((MessageLite)DescriptorProtos.MethodOptions.getDefaultInstance(), HttpRule.getDefaultInstance(), (MessageLite)HttpRule.getDefaultInstance(), null, 72295728, WireFormat.FieldType.MESSAGE, HttpRule.class);
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {
    paramExtensionRegistryLite.add(http);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\AnnotationsProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */