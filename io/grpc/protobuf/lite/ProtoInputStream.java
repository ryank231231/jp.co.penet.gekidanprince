package io.grpc.protobuf.lite;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import io.grpc.Drainable;
import io.grpc.KnownLength;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;

class ProtoInputStream extends InputStream implements Drainable, KnownLength {
  @Nullable
  private MessageLite message;
  
  private final Parser<?> parser;
  
  @Nullable
  private ByteArrayInputStream partial;
  
  public ProtoInputStream(MessageLite paramMessageLite, Parser<?> paramParser) {
    this.message = paramMessageLite;
    this.parser = paramParser;
  }
  
  public int available() throws IOException {
    MessageLite messageLite = this.message;
    if (messageLite != null)
      return messageLite.getSerializedSize(); 
    ByteArrayInputStream byteArrayInputStream = this.partial;
    return (byteArrayInputStream != null) ? byteArrayInputStream.available() : 0;
  }
  
  public int drainTo(OutputStream paramOutputStream) throws IOException {
    boolean bool;
    MessageLite messageLite = this.message;
    if (messageLite != null) {
      bool = messageLite.getSerializedSize();
      this.message.writeTo(paramOutputStream);
      this.message = null;
    } else {
      ByteArrayInputStream byteArrayInputStream = this.partial;
      if (byteArrayInputStream != null) {
        bool = (int)ProtoLiteUtils.copy(byteArrayInputStream, paramOutputStream);
        this.partial = null;
      } else {
        bool = false;
      } 
    } 
    return bool;
  }
  
  MessageLite message() {
    MessageLite messageLite = this.message;
    if (messageLite != null)
      return messageLite; 
    throw new IllegalStateException("message not available");
  }
  
  Parser<?> parser() {
    return this.parser;
  }
  
  public int read() throws IOException {
    MessageLite messageLite = this.message;
    if (messageLite != null) {
      this.partial = new ByteArrayInputStream(messageLite.toByteArray());
      this.message = null;
    } 
    ByteArrayInputStream byteArrayInputStream = this.partial;
    return (byteArrayInputStream != null) ? byteArrayInputStream.read() : -1;
  }
  
  public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    CodedOutputStream codedOutputStream;
    MessageLite messageLite = this.message;
    if (messageLite != null) {
      int i = messageLite.getSerializedSize();
      if (i == 0) {
        this.message = null;
        this.partial = null;
        return -1;
      } 
      if (paramInt2 >= i) {
        codedOutputStream = CodedOutputStream.newInstance(paramArrayOfbyte, paramInt1, i);
        this.message.writeTo(codedOutputStream);
        codedOutputStream.flush();
        codedOutputStream.checkNoSpaceLeft();
        this.message = null;
        this.partial = null;
        return i;
      } 
      this.partial = new ByteArrayInputStream(this.message.toByteArray());
      this.message = null;
    } 
    ByteArrayInputStream byteArrayInputStream = this.partial;
    return (byteArrayInputStream != null) ? byteArrayInputStream.read((byte[])codedOutputStream, paramInt1, paramInt2) : -1;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\protobuf\lite\ProtoInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */