package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.nio.charset.Charset;

abstract class AbstractCompositeHashFunction extends AbstractStreamingHashFunction {
  private static final long serialVersionUID = 0L;
  
  final HashFunction[] functions;
  
  AbstractCompositeHashFunction(HashFunction... paramVarArgs) {
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++)
      Preconditions.checkNotNull(paramVarArgs[b]); 
    this.functions = paramVarArgs;
  }
  
  abstract HashCode makeHash(Hasher[] paramArrayOfHasher);
  
  public Hasher newHasher() {
    final Hasher[] hashers = new Hasher[this.functions.length];
    for (byte b = 0; b < arrayOfHasher.length; b++)
      arrayOfHasher[b] = this.functions[b].newHasher(); 
    return new Hasher() {
        public HashCode hash() {
          return AbstractCompositeHashFunction.this.makeHash(hashers);
        }
        
        public Hasher putBoolean(boolean param1Boolean) {
          Hasher[] arrayOfHasher = hashers;
          int i = arrayOfHasher.length;
          for (byte b = 0; b < i; b++)
            arrayOfHasher[b].putBoolean(param1Boolean); 
          return this;
        }
        
        public Hasher putByte(byte param1Byte) {
          Hasher[] arrayOfHasher = hashers;
          int i = arrayOfHasher.length;
          for (byte b = 0; b < i; b++)
            arrayOfHasher[b].putByte(param1Byte); 
          return this;
        }
        
        public Hasher putBytes(byte[] param1ArrayOfbyte) {
          Hasher[] arrayOfHasher = hashers;
          int i = arrayOfHasher.length;
          for (byte b = 0; b < i; b++)
            arrayOfHasher[b].putBytes(param1ArrayOfbyte); 
          return this;
        }
        
        public Hasher putBytes(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
          Hasher[] arrayOfHasher = hashers;
          int i = arrayOfHasher.length;
          for (byte b = 0; b < i; b++)
            arrayOfHasher[b].putBytes(param1ArrayOfbyte, param1Int1, param1Int2); 
          return this;
        }
        
        public Hasher putChar(char param1Char) {
          Hasher[] arrayOfHasher = hashers;
          int i = arrayOfHasher.length;
          for (byte b = 0; b < i; b++)
            arrayOfHasher[b].putChar(param1Char); 
          return this;
        }
        
        public Hasher putDouble(double param1Double) {
          Hasher[] arrayOfHasher = hashers;
          int i = arrayOfHasher.length;
          for (byte b = 0; b < i; b++)
            arrayOfHasher[b].putDouble(param1Double); 
          return this;
        }
        
        public Hasher putFloat(float param1Float) {
          Hasher[] arrayOfHasher = hashers;
          int i = arrayOfHasher.length;
          for (byte b = 0; b < i; b++)
            arrayOfHasher[b].putFloat(param1Float); 
          return this;
        }
        
        public Hasher putInt(int param1Int) {
          Hasher[] arrayOfHasher = hashers;
          int i = arrayOfHasher.length;
          for (byte b = 0; b < i; b++)
            arrayOfHasher[b].putInt(param1Int); 
          return this;
        }
        
        public Hasher putLong(long param1Long) {
          Hasher[] arrayOfHasher = hashers;
          int i = arrayOfHasher.length;
          for (byte b = 0; b < i; b++)
            arrayOfHasher[b].putLong(param1Long); 
          return this;
        }
        
        public <T> Hasher putObject(T param1T, Funnel<? super T> param1Funnel) {
          Hasher[] arrayOfHasher = hashers;
          int i = arrayOfHasher.length;
          for (byte b = 0; b < i; b++)
            arrayOfHasher[b].putObject(param1T, param1Funnel); 
          return this;
        }
        
        public Hasher putShort(short param1Short) {
          Hasher[] arrayOfHasher = hashers;
          int i = arrayOfHasher.length;
          for (byte b = 0; b < i; b++)
            arrayOfHasher[b].putShort(param1Short); 
          return this;
        }
        
        public Hasher putString(CharSequence param1CharSequence, Charset param1Charset) {
          Hasher[] arrayOfHasher = hashers;
          int i = arrayOfHasher.length;
          for (byte b = 0; b < i; b++)
            arrayOfHasher[b].putString(param1CharSequence, param1Charset); 
          return this;
        }
        
        public Hasher putUnencodedChars(CharSequence param1CharSequence) {
          Hasher[] arrayOfHasher = hashers;
          int i = arrayOfHasher.length;
          for (byte b = 0; b < i; b++)
            arrayOfHasher[b].putUnencodedChars(param1CharSequence); 
          return this;
        }
      };
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\hash\AbstractCompositeHashFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */