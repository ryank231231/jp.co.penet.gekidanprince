package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzfs {
  private final ByteBuffer zzgd;
  
  private zzbn zzrh;
  
  private int zzri;
  
  private zzfs(ByteBuffer paramByteBuffer) {
    this.zzgd = paramByteBuffer;
    this.zzgd.order(ByteOrder.LITTLE_ENDIAN);
  }
  
  private zzfs(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
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
  
  private final void zzao(int paramInt) throws IOException {
    byte b = (byte)paramInt;
    if (this.zzgd.hasRemaining()) {
      this.zzgd.put(b);
      return;
    } 
    throw new zzft(this.zzgd.position(), this.zzgd.limit());
  }
  
  private final void zzap(int paramInt) throws IOException {
    while (true) {
      if ((paramInt & 0xFFFFFF80) == 0) {
        zzao(paramInt);
        return;
      } 
      zzao(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    } 
  }
  
  public static int zzb(int paramInt, zzfz paramzzfz) {
    paramInt = zzr(paramInt);
    int i = paramzzfz.zzas();
    return paramInt + zzz(i) + i;
  }
  
  public static int zzb(int paramInt, String paramString) {
    return zzr(paramInt) + zzh(paramString);
  }
  
  public static int zzb(int paramInt, byte[] paramArrayOfbyte) {
    return zzr(paramInt) + zzh(paramArrayOfbyte);
  }
  
  public static int zzd(int paramInt, long paramLong) {
    return zzr(paramInt) + zzo(paramLong);
  }
  
  private static void zzd(CharSequence paramCharSequence, ByteBuffer paramByteBuffer) {
    if (!paramByteBuffer.isReadOnly()) {
      BufferOverflowException bufferOverflowException;
      boolean bool = paramByteBuffer.hasArray();
      int i = 0;
      int j = 0;
      if (bool)
        try {
          byte[] arrayOfByte = paramByteBuffer.array();
          i = paramByteBuffer.arrayOffset() + paramByteBuffer.position();
          int m = paramByteBuffer.remaining();
          int n = paramCharSequence.length();
          int i1 = m + i;
          while (j < n) {
            int i2 = j + i;
            if (i2 < i1) {
              m = paramCharSequence.charAt(j);
              if (m < 128) {
                arrayOfByte[i2] = (byte)(byte)m;
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
                  m = i + 1;
                  arrayOfByte[i] = (byte)(byte)c;
                  i = m;
                } else if (c < 'ࠀ' && i <= i1 - 2) {
                  m = i + 1;
                  arrayOfByte[i] = (byte)(byte)(c >>> 6 | 0x3C0);
                  i = m + 1;
                  arrayOfByte[m] = (byte)(byte)(c & 0x3F | 0x80);
                } else if ((c < '?' || '?' < c) && i <= i1 - 3) {
                  m = i + 1;
                  arrayOfByte[i] = (byte)(byte)(c >>> 12 | 0x1E0);
                  int i2 = m + 1;
                  arrayOfByte[m] = (byte)(byte)(c >>> 6 & 0x3F | 0x80);
                  i = i2 + 1;
                  arrayOfByte[i2] = (byte)(byte)(c & 0x3F | 0x80);
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
                  arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
                  paramCharSequence = new StringBuilder();
                  super(37);
                  paramCharSequence.append("Failed writing ");
                  paramCharSequence.append(c);
                  paramCharSequence.append(" at index ");
                  paramCharSequence.append(i);
                  this(paramCharSequence.toString());
                  throw arrayIndexOutOfBoundsException;
                } 
                j++;
                continue;
              } 
              break;
            } 
          } 
          arrayIndexOutOfBoundsException.position(m - arrayIndexOutOfBoundsException.arrayOffset());
          return;
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
          bufferOverflowException = new BufferOverflowException();
          bufferOverflowException.initCause(arrayIndexOutOfBoundsException);
          throw bufferOverflowException;
        }  
      int k = bufferOverflowException.length();
      for (j = i;; j++) {
        if (j < k) {
          char c = bufferOverflowException.charAt(j);
          if (c < '') {
            i = c;
          } else {
            if (c < 'ࠀ') {
              i = c >>> 6 | 0x3C0;
            } else if (c < '?' || '?' < c) {
              arrayIndexOutOfBoundsException.put((byte)(c >>> 12 | 0x1E0));
              i = c >>> 6 & 0x3F | 0x80;
            } else {
              i = j + 1;
              if (i != bufferOverflowException.length()) {
                char c1 = bufferOverflowException.charAt(i);
                if (Character.isSurrogatePair(c, c1)) {
                  j = Character.toCodePoint(c, c1);
                  arrayIndexOutOfBoundsException.put((byte)(j >>> 18 | 0xF0));
                  arrayIndexOutOfBoundsException.put((byte)(j >>> 12 & 0x3F | 0x80));
                  arrayIndexOutOfBoundsException.put((byte)(j >>> 6 & 0x3F | 0x80));
                  arrayIndexOutOfBoundsException.put((byte)(j & 0x3F | 0x80));
                  j = i;
                } else {
                  j = i;
                  StringBuilder stringBuilder = new StringBuilder(39);
                  stringBuilder.append("Unpaired surrogate at index ");
                  stringBuilder.append(j - 1);
                  throw new IllegalArgumentException(stringBuilder.toString());
                } 
              } else {
                StringBuilder stringBuilder = new StringBuilder(39);
                stringBuilder.append("Unpaired surrogate at index ");
                stringBuilder.append(j - 1);
                throw new IllegalArgumentException(stringBuilder.toString());
              } 
              j++;
            } 
            arrayIndexOutOfBoundsException.put((byte)i);
            i = c & 0x3F | 0x80;
          } 
          arrayIndexOutOfBoundsException.put((byte)i);
        } else {
          break;
        } 
      } 
      return;
    } 
    throw new ReadOnlyBufferException();
  }
  
  public static zzfs zzg(byte[] paramArrayOfbyte) {
    return zzh(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public static int zzh(String paramString) {
    int i = zza(paramString);
    return zzz(i) + i;
  }
  
  public static int zzh(byte[] paramArrayOfbyte) {
    return zzz(paramArrayOfbyte.length) + paramArrayOfbyte.length;
  }
  
  public static zzfs zzh(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return new zzfs(paramArrayOfbyte, 0, paramInt2);
  }
  
  public static long zzj(long paramLong) {
    return paramLong >> 63L ^ paramLong << 1L;
  }
  
  public static int zzo(long paramLong) {
    return ((0xFFFFFFFFFFFFFF80L & paramLong) == 0L) ? 1 : (((0xFFFFFFFFFFFFC000L & paramLong) == 0L) ? 2 : (((0xFFFFFFFFFFE00000L & paramLong) == 0L) ? 3 : (((0xFFFFFFFFF0000000L & paramLong) == 0L) ? 4 : (((0xFFFFFFF800000000L & paramLong) == 0L) ? 5 : (((0xFFFFFC0000000000L & paramLong) == 0L) ? 6 : (((0xFFFE000000000000L & paramLong) == 0L) ? 7 : (((0xFF00000000000000L & paramLong) == 0L) ? 8 : (((paramLong & Long.MIN_VALUE) == 0L) ? 9 : 10))))))));
  }
  
  public static int zzr(int paramInt) {
    return zzz(paramInt << 3);
  }
  
  public static int zzs(int paramInt) {
    return (paramInt >= 0) ? zzz(paramInt) : 10;
  }
  
  private static int zzz(int paramInt) {
    return ((paramInt & 0xFFFFFF80) == 0) ? 1 : (((paramInt & 0xFFFFC000) == 0) ? 2 : (((0xFFE00000 & paramInt) == 0) ? 3 : (((paramInt & 0xF0000000) == 0) ? 4 : 5)));
  }
  
  public final void zza(int paramInt, zzfz paramzzfz) throws IOException {
    zzb(paramInt, 2);
    if (paramzzfz.zzrs < 0)
      paramzzfz.zzas(); 
    zzap(paramzzfz.zzrs);
    paramzzfz.zza(this);
  }
  
  public final void zza(int paramInt, String paramString) throws IOException {
    zzb(paramInt, 2);
    try {
      zzft zzft;
      paramInt = zzz(paramString.length());
      if (paramInt == zzz(paramString.length() * 3)) {
        int i = this.zzgd.position();
        if (this.zzgd.remaining() >= paramInt) {
          this.zzgd.position(i + paramInt);
          zzd(paramString, this.zzgd);
          int j = this.zzgd.position();
          this.zzgd.position(i);
          zzap(j - i - paramInt);
          this.zzgd.position(j);
          return;
        } 
        zzft = new zzft();
        this(i + paramInt, this.zzgd.limit());
        throw zzft;
      } 
      zzap(zza((CharSequence)zzft));
      zzd((CharSequence)zzft, this.zzgd);
      return;
    } catch (BufferOverflowException bufferOverflowException) {
      zzft zzft = new zzft(this.zzgd.position(), this.zzgd.limit());
      zzft.initCause(bufferOverflowException);
      throw zzft;
    } 
  }
  
  public final void zza(int paramInt, byte[] paramArrayOfbyte) throws IOException {
    zzb(paramInt, 2);
    zzap(paramArrayOfbyte.length);
    paramInt = paramArrayOfbyte.length;
    if (this.zzgd.remaining() >= paramInt) {
      this.zzgd.put(paramArrayOfbyte, 0, paramInt);
      return;
    } 
    throw new zzft(this.zzgd.position(), this.zzgd.limit());
  }
  
  public final void zzb(int paramInt1, int paramInt2) throws IOException {
    zzap(paramInt1 << 3 | paramInt2);
  }
  
  public final void zzb(int paramInt, boolean paramBoolean) throws IOException {
    zzb(25, 0);
    byte b = (byte)paramBoolean;
    if (this.zzgd.hasRemaining()) {
      this.zzgd.put(b);
      return;
    } 
    throw new zzft(this.zzgd.position(), this.zzgd.limit());
  }
  
  public final void zzc(int paramInt1, int paramInt2) throws IOException {
    zzb(paramInt1, 0);
    if (paramInt2 >= 0) {
      zzap(paramInt2);
      return;
    } 
    zzn(paramInt2);
  }
  
  public final void zze(int paramInt, zzdo paramzzdo) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: getfield zzrh : Lcom/google/android/gms/internal/clearcut/zzbn;
    //   4: ifnonnull -> 32
    //   7: aload_0
    //   8: aload_0
    //   9: getfield zzgd : Ljava/nio/ByteBuffer;
    //   12: invokestatic zza : (Ljava/nio/ByteBuffer;)Lcom/google/android/gms/internal/clearcut/zzbn;
    //   15: putfield zzrh : Lcom/google/android/gms/internal/clearcut/zzbn;
    //   18: aload_0
    //   19: aload_0
    //   20: getfield zzgd : Ljava/nio/ByteBuffer;
    //   23: invokevirtual position : ()I
    //   26: putfield zzri : I
    //   29: goto -> 79
    //   32: aload_0
    //   33: getfield zzri : I
    //   36: aload_0
    //   37: getfield zzgd : Ljava/nio/ByteBuffer;
    //   40: invokevirtual position : ()I
    //   43: if_icmpeq -> 79
    //   46: aload_0
    //   47: getfield zzrh : Lcom/google/android/gms/internal/clearcut/zzbn;
    //   50: aload_0
    //   51: getfield zzgd : Ljava/nio/ByteBuffer;
    //   54: invokevirtual array : ()[B
    //   57: aload_0
    //   58: getfield zzri : I
    //   61: aload_0
    //   62: getfield zzgd : Ljava/nio/ByteBuffer;
    //   65: invokevirtual position : ()I
    //   68: aload_0
    //   69: getfield zzri : I
    //   72: isub
    //   73: invokevirtual write : ([BII)V
    //   76: goto -> 18
    //   79: aload_0
    //   80: getfield zzrh : Lcom/google/android/gms/internal/clearcut/zzbn;
    //   83: astore_3
    //   84: aload_3
    //   85: iload_1
    //   86: aload_2
    //   87: invokevirtual zza : (ILcom/google/android/gms/internal/clearcut/zzdo;)V
    //   90: aload_3
    //   91: invokevirtual flush : ()V
    //   94: aload_0
    //   95: aload_0
    //   96: getfield zzgd : Ljava/nio/ByteBuffer;
    //   99: invokevirtual position : ()I
    //   102: putfield zzri : I
    //   105: return
  }
  
  public final void zzem() {
    if (this.zzgd.remaining() == 0)
      return; 
    throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", new Object[] { Integer.valueOf(this.zzgd.remaining()) }));
  }
  
  public final void zzi(int paramInt, long paramLong) throws IOException {
    zzb(paramInt, 0);
    zzn(paramLong);
  }
  
  public final void zzn(long paramLong) throws IOException {
    while (true) {
      if ((0xFFFFFFFFFFFFFF80L & paramLong) == 0L) {
        zzao((int)paramLong);
        return;
      } 
      zzao((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7L;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzfs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */