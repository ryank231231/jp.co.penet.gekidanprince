package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzin {
  private final ByteBuffer zzada;
  
  private zzeg zzanb;
  
  private int zzanc;
  
  private zzin(ByteBuffer paramByteBuffer) {
    this.zzada = paramByteBuffer;
    this.zzada.order(ByteOrder.LITTLE_ENDIAN);
  }
  
  private zzin(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    this(ByteBuffer.wrap(paramArrayOfbyte, paramInt1, paramInt2));
  }
  
  private static int zza(CharSequence paramCharSequence) {
    int n;
    int i = paramCharSequence.length();
    int j = 0;
    int k;
    for (k = 0; k < i && paramCharSequence.charAt(k) < ''; k++);
    int m = i;
    while (true) {
      n = m;
      if (k < i) {
        n = paramCharSequence.charAt(k);
        if (n < 2048) {
          m += 127 - n >>> 31;
          k++;
          continue;
        } 
        int i1 = paramCharSequence.length();
        n = j;
        while (k < i1) {
          char c = paramCharSequence.charAt(k);
          if (c < 'ࠀ') {
            n += 127 - c >>> 31;
            j = k;
          } else {
            int i2 = n + 2;
            n = i2;
            j = k;
            if ('?' <= c) {
              n = i2;
              j = k;
              if (c <= '?')
                if (Character.codePointAt(paramCharSequence, k) >= 65536) {
                  j = k + 1;
                  n = i2;
                } else {
                  paramCharSequence = new StringBuilder(39);
                  paramCharSequence.append("Unpaired surrogate at index ");
                  paramCharSequence.append(k);
                  throw new IllegalArgumentException(paramCharSequence.toString());
                }  
            } 
          } 
          k = j + 1;
        } 
        n = m + n;
      } 
      break;
    } 
    if (n >= i)
      return n; 
    long l = n;
    paramCharSequence = new StringBuilder(54);
    paramCharSequence.append("UTF-8 length does not fit in int: ");
    paramCharSequence.append(l + 4294967296L);
    throw new IllegalArgumentException(paramCharSequence.toString());
  }
  
  public static int zzaj(int paramInt) {
    return zzar(paramInt << 3);
  }
  
  public static int zzak(int paramInt) {
    return (paramInt >= 0) ? zzar(paramInt) : 10;
  }
  
  public static int zzar(int paramInt) {
    return ((paramInt & 0xFFFFFF80) == 0) ? 1 : (((paramInt & 0xFFFFC000) == 0) ? 2 : (((0xFFE00000 & paramInt) == 0) ? 3 : (((paramInt & 0xF0000000) == 0) ? 4 : 5)));
  }
  
  public static int zzb(int paramInt, zziv paramzziv) {
    paramInt = zzaj(paramInt);
    int i = paramzziv.zzly();
    return paramInt + zzar(i) + i;
  }
  
  private final void zzbc(long paramLong) throws IOException {
    while (true) {
      if ((0xFFFFFFFFFFFFFF80L & paramLong) == 0L) {
        zzbk((int)paramLong);
        return;
      } 
      zzbk((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7L;
    } 
  }
  
  private final void zzbk(int paramInt) throws IOException {
    byte b = (byte)paramInt;
    if (this.zzada.hasRemaining()) {
      this.zzada.put(b);
      return;
    } 
    throw new zzio(this.zzada.position(), this.zzada.limit());
  }
  
  public static int zzc(int paramInt, String paramString) {
    return zzaj(paramInt) + zzcp(paramString);
  }
  
  public static int zzcp(String paramString) {
    int i = zza(paramString);
    return zzar(i) + i;
  }
  
  public static int zzd(int paramInt, long paramLong) {
    int i = zzaj(paramInt);
    if ((0xFFFFFFFFFFFFFF80L & paramLong) == 0L) {
      paramInt = 1;
    } else if ((0xFFFFFFFFFFFFC000L & paramLong) == 0L) {
      paramInt = 2;
    } else if ((0xFFFFFFFFFFE00000L & paramLong) == 0L) {
      paramInt = 3;
    } else if ((0xFFFFFFFFF0000000L & paramLong) == 0L) {
      paramInt = 4;
    } else if ((0xFFFFFFF800000000L & paramLong) == 0L) {
      paramInt = 5;
    } else if ((0xFFFFFC0000000000L & paramLong) == 0L) {
      paramInt = 6;
    } else if ((0xFFFE000000000000L & paramLong) == 0L) {
      paramInt = 7;
    } else if ((0xFF00000000000000L & paramLong) == 0L) {
      paramInt = 8;
    } else if ((paramLong & Long.MIN_VALUE) == 0L) {
      paramInt = 9;
    } else {
      paramInt = 10;
    } 
    return i + paramInt;
  }
  
  private static void zzd(CharSequence paramCharSequence, ByteBuffer paramByteBuffer) {
    if (!paramByteBuffer.isReadOnly()) {
      BufferOverflowException bufferOverflowException;
      boolean bool = paramByteBuffer.hasArray();
      int i = 0;
      int j = 0;
      if (bool)
        try {
          StringBuilder stringBuilder;
          byte[] arrayOfByte = paramByteBuffer.array();
          i = paramByteBuffer.arrayOffset() + paramByteBuffer.position();
          int m = paramByteBuffer.remaining();
          int n = paramCharSequence.length();
          int i1 = m + i;
          while (j < n) {
            m = j + i;
            if (m < i1) {
              char c = paramCharSequence.charAt(j);
              if (c < '') {
                arrayOfByte[m] = (byte)(byte)c;
                j++;
              } 
            } 
          } 
          if (j == n) {
            m = i + n;
          } else {
            i += j;
            while (true) {
              m = i;
              if (j < n) {
                char c = paramCharSequence.charAt(j);
                if (c < '' && i < i1) {
                  arrayOfByte[i] = (byte)(byte)c;
                  i++;
                } else if (c < 'ࠀ' && i <= i1 - 2) {
                  m = i + 1;
                  arrayOfByte[i] = (byte)(byte)(c >>> 6 | 0x3C0);
                  i = m + 1;
                  arrayOfByte[m] = (byte)(byte)(c & 0x3F | 0x80);
                } else if ((c < '?' || '?' < c) && i <= i1 - 3) {
                  m = i + 1;
                  arrayOfByte[i] = (byte)(byte)(c >>> 12 | 0x1E0);
                  i = m + 1;
                  arrayOfByte[m] = (byte)(byte)(c >>> 6 & 0x3F | 0x80);
                  arrayOfByte[i] = (byte)(byte)(c & 0x3F | 0x80);
                  i++;
                } else if (i <= i1 - 4) {
                  m = j + 1;
                  if (m != paramCharSequence.length()) {
                    char c1 = paramCharSequence.charAt(m);
                    if (Character.isSurrogatePair(c, c1)) {
                      j = Character.toCodePoint(c, c1);
                      int i2 = i + 1;
                      arrayOfByte[i] = (byte)(byte)(j >>> 18 | 0xF0);
                      i = i2 + 1;
                      arrayOfByte[i2] = (byte)(byte)(j >>> 12 & 0x3F | 0x80);
                      i2 = i + 1;
                      arrayOfByte[i] = (byte)(byte)(j >>> 6 & 0x3F | 0x80);
                      i = i2 + 1;
                      arrayOfByte[i2] = (byte)(byte)(j & 0x3F | 0x80);
                      j = m;
                    } else {
                      j = m;
                      IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                      paramCharSequence = new StringBuilder();
                      super(39);
                      paramCharSequence.append("Unpaired surrogate at index ");
                      paramCharSequence.append(j - 1);
                      this(paramCharSequence.toString());
                      throw illegalArgumentException;
                    } 
                  } else {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                    paramCharSequence = new StringBuilder();
                    super(39);
                    paramCharSequence.append("Unpaired surrogate at index ");
                    paramCharSequence.append(j - 1);
                    this(paramCharSequence.toString());
                    throw illegalArgumentException;
                  } 
                } else {
                  ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException1 = new ArrayIndexOutOfBoundsException();
                  stringBuilder = new StringBuilder();
                  this(37);
                  stringBuilder.append("Failed writing ");
                  stringBuilder.append(c);
                  stringBuilder.append(" at index ");
                  stringBuilder.append(i);
                  this(stringBuilder.toString());
                  throw arrayIndexOutOfBoundsException1;
                } 
                j++;
                continue;
              } 
              break;
            } 
          } 
          stringBuilder.position(m - stringBuilder.arrayOffset());
          return;
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
          bufferOverflowException = new BufferOverflowException();
          bufferOverflowException.initCause(arrayIndexOutOfBoundsException);
          throw bufferOverflowException;
        }  
      int k = bufferOverflowException.length();
      while (i < k) {
        char c = bufferOverflowException.charAt(i);
        if (c < '') {
          arrayIndexOutOfBoundsException.put((byte)c);
        } else if (c < 'ࠀ') {
          arrayIndexOutOfBoundsException.put((byte)(c >>> 6 | 0x3C0));
          arrayIndexOutOfBoundsException.put((byte)(c & 0x3F | 0x80));
        } else if (c < '?' || '?' < c) {
          arrayIndexOutOfBoundsException.put((byte)(c >>> 12 | 0x1E0));
          arrayIndexOutOfBoundsException.put((byte)(c >>> 6 & 0x3F | 0x80));
          arrayIndexOutOfBoundsException.put((byte)(c & 0x3F | 0x80));
        } else {
          j = i + 1;
          if (j != bufferOverflowException.length()) {
            char c1 = bufferOverflowException.charAt(j);
            if (Character.isSurrogatePair(c, c1)) {
              i = Character.toCodePoint(c, c1);
              arrayIndexOutOfBoundsException.put((byte)(i >>> 18 | 0xF0));
              arrayIndexOutOfBoundsException.put((byte)(i >>> 12 & 0x3F | 0x80));
              arrayIndexOutOfBoundsException.put((byte)(i >>> 6 & 0x3F | 0x80));
              arrayIndexOutOfBoundsException.put((byte)(i & 0x3F | 0x80));
              i = j;
            } else {
              i = j;
              StringBuilder stringBuilder = new StringBuilder(39);
              stringBuilder.append("Unpaired surrogate at index ");
              stringBuilder.append(i - 1);
              throw new IllegalArgumentException(stringBuilder.toString());
            } 
          } else {
            StringBuilder stringBuilder = new StringBuilder(39);
            stringBuilder.append("Unpaired surrogate at index ");
            stringBuilder.append(i - 1);
            throw new IllegalArgumentException(stringBuilder.toString());
          } 
        } 
        i++;
      } 
      return;
    } 
    throw new ReadOnlyBufferException();
  }
  
  public static int zzg(int paramInt1, int paramInt2) {
    return zzaj(paramInt1) + zzak(paramInt2);
  }
  
  public static zzin zzk(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return new zzin(paramArrayOfbyte, 0, paramInt2);
  }
  
  public static zzin zzl(byte[] paramArrayOfbyte) {
    return zzk(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public final void zza(int paramInt, zziv paramzziv) throws IOException {
    zzb(paramInt, 2);
    if (paramzziv.zzanm < 0)
      paramzziv.zzly(); 
    zzbl(paramzziv.zzanm);
    paramzziv.zza(this);
  }
  
  public final void zzb(int paramInt1, int paramInt2) throws IOException {
    zzbl(paramInt1 << 3 | paramInt2);
  }
  
  public final void zzb(int paramInt, String paramString) throws IOException {
    zzb(paramInt, 2);
    try {
      zzio zzio;
      int i = zzar(paramString.length());
      if (i == zzar(paramString.length() * 3)) {
        paramInt = this.zzada.position();
        if (this.zzada.remaining() >= i) {
          this.zzada.position(paramInt + i);
          zzd(paramString, this.zzada);
          int j = this.zzada.position();
          this.zzada.position(paramInt);
          zzbl(j - paramInt - i);
          this.zzada.position(j);
          return;
        } 
        zzio = new zzio();
        this(paramInt + i, this.zzada.limit());
        throw zzio;
      } 
      zzbl(zza((CharSequence)zzio));
      zzd((CharSequence)zzio, this.zzada);
      return;
    } catch (BufferOverflowException bufferOverflowException) {
      zzio zzio = new zzio(this.zzada.position(), this.zzada.limit());
      zzio.initCause(bufferOverflowException);
      throw zzio;
    } 
  }
  
  public final void zzb(int paramInt, boolean paramBoolean) throws IOException {
    zzb(paramInt, 0);
    byte b = (byte)paramBoolean;
    if (this.zzada.hasRemaining()) {
      this.zzada.put(b);
      return;
    } 
    throw new zzio(this.zzada.position(), this.zzada.limit());
  }
  
  public final void zzbl(int paramInt) throws IOException {
    while (true) {
      if ((paramInt & 0xFFFFFF80) == 0) {
        zzbk(paramInt);
        return;
      } 
      zzbk(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    } 
  }
  
  public final void zzc(int paramInt1, int paramInt2) throws IOException {
    zzb(paramInt1, 0);
    if (paramInt2 >= 0) {
      zzbl(paramInt2);
      return;
    } 
    zzbc(paramInt2);
  }
  
  public final void zze(int paramInt, zzgh paramzzgh) throws IOException {
    if (this.zzanb == null) {
      this.zzanb = zzeg.zza(this.zzada);
      this.zzanc = this.zzada.position();
    } else if (this.zzanc != this.zzada.position()) {
      this.zzanb.write(this.zzada.array(), this.zzanc, this.zzada.position() - this.zzanc);
      this.zzanc = this.zzada.position();
    } 
    zzeg zzeg1 = this.zzanb;
    zzeg1.zza(paramInt, paramzzgh);
    zzeg1.flush();
    this.zzanc = this.zzada.position();
  }
  
  public final void zzi(int paramInt, long paramLong) throws IOException {
    zzb(paramInt, 0);
    zzbc(paramLong);
  }
  
  public final void zzlk() {
    if (this.zzada.remaining() == 0)
      return; 
    throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", new Object[] { Integer.valueOf(this.zzada.remaining()) }));
  }
  
  public final void zzm(byte[] paramArrayOfbyte) throws IOException {
    int i = paramArrayOfbyte.length;
    if (this.zzada.remaining() >= i) {
      this.zzada.put(paramArrayOfbyte, 0, i);
      return;
    } 
    throw new zzio(this.zzada.position(), this.zzada.limit());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */