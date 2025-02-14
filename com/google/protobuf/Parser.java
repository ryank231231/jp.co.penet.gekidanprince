package com.google.protobuf;

import java.io.InputStream;

public interface Parser<MessageType> {
  MessageType parseDelimitedFrom(InputStream paramInputStream) throws InvalidProtocolBufferException;
  
  MessageType parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException;
  
  MessageType parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException;
  
  MessageType parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException;
  
  MessageType parseFrom(CodedInputStream paramCodedInputStream) throws InvalidProtocolBufferException;
  
  MessageType parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException;
  
  MessageType parseFrom(InputStream paramInputStream) throws InvalidProtocolBufferException;
  
  MessageType parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException;
  
  MessageType parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException;
  
  MessageType parseFrom(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws InvalidProtocolBufferException;
  
  MessageType parseFrom(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException;
  
  MessageType parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException;
  
  MessageType parsePartialDelimitedFrom(InputStream paramInputStream) throws InvalidProtocolBufferException;
  
  MessageType parsePartialDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException;
  
  MessageType parsePartialFrom(ByteString paramByteString) throws InvalidProtocolBufferException;
  
  MessageType parsePartialFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException;
  
  MessageType parsePartialFrom(CodedInputStream paramCodedInputStream) throws InvalidProtocolBufferException;
  
  MessageType parsePartialFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException;
  
  MessageType parsePartialFrom(InputStream paramInputStream) throws InvalidProtocolBufferException;
  
  MessageType parsePartialFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException;
  
  MessageType parsePartialFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException;
  
  MessageType parsePartialFrom(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws InvalidProtocolBufferException;
  
  MessageType parsePartialFrom(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException;
  
  MessageType parsePartialFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException;
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\Parser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */