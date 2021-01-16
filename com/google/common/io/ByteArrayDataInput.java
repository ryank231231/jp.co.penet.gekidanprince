package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.DataInput;

@GwtIncompatible
public interface ByteArrayDataInput extends DataInput {
  @CanIgnoreReturnValue
  boolean readBoolean();
  
  @CanIgnoreReturnValue
  byte readByte();
  
  @CanIgnoreReturnValue
  char readChar();
  
  @CanIgnoreReturnValue
  double readDouble();
  
  @CanIgnoreReturnValue
  float readFloat();
  
  void readFully(byte[] paramArrayOfbyte);
  
  void readFully(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
  
  @CanIgnoreReturnValue
  int readInt();
  
  @CanIgnoreReturnValue
  String readLine();
  
  @CanIgnoreReturnValue
  long readLong();
  
  @CanIgnoreReturnValue
  short readShort();
  
  @CanIgnoreReturnValue
  String readUTF();
  
  @CanIgnoreReturnValue
  int readUnsignedByte();
  
  @CanIgnoreReturnValue
  int readUnsignedShort();
  
  int skipBytes(int paramInt);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\io\ByteArrayDataInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */