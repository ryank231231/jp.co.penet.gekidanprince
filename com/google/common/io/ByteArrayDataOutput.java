package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import java.io.DataOutput;

@GwtIncompatible
public interface ByteArrayDataOutput extends DataOutput {
  byte[] toByteArray();
  
  void write(int paramInt);
  
  void write(byte[] paramArrayOfbyte);
  
  void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
  
  void writeBoolean(boolean paramBoolean);
  
  void writeByte(int paramInt);
  
  @Deprecated
  void writeBytes(String paramString);
  
  void writeChar(int paramInt);
  
  void writeChars(String paramString);
  
  void writeDouble(double paramDouble);
  
  void writeFloat(float paramFloat);
  
  void writeInt(int paramInt);
  
  void writeLong(long paramLong);
  
  void writeShort(int paramInt);
  
  void writeUTF(String paramString);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\io\ByteArrayDataOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */