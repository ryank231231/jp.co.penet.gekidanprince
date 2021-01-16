package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzeg extends zzdo {
  private static final Logger logger = Logger.getLogger(zzeg.class.getName());
  
  private static final boolean zzacv = zzhw.zzou();
  
  zzei zzacw;
  
  private zzeg() {}
  
  public static int zza(int paramInt, zzfo paramzzfo) {
    paramInt = zzaj(paramInt);
    int i = paramzzfo.zzly();
    return paramInt + zzal(i) + i;
  }
  
  public static int zza(zzfo paramzzfo) {
    int i = paramzzfo.zzly();
    return zzal(i) + i;
  }
  
  public static zzeg zza(ByteBuffer paramByteBuffer) {
    if (paramByteBuffer.hasArray())
      return new zzb(paramByteBuffer); 
    if (paramByteBuffer.isDirect() && !paramByteBuffer.isReadOnly())
      return (zzeg)(zzhw.zzov() ? new zze(paramByteBuffer) : new zzd(paramByteBuffer)); 
    throw new IllegalArgumentException("ByteBuffer is read-only");
  }
  
  public static int zzaj(int paramInt) {
    return zzal(paramInt << 3);
  }
  
  public static int zzak(int paramInt) {
    return (paramInt >= 0) ? zzal(paramInt) : 10;
  }
  
  public static int zzal(int paramInt) {
    return ((paramInt & 0xFFFFFF80) == 0) ? 1 : (((paramInt & 0xFFFFC000) == 0) ? 2 : (((0xFFE00000 & paramInt) == 0) ? 3 : (((paramInt & 0xF0000000) == 0) ? 4 : 5)));
  }
  
  public static int zzam(int paramInt) {
    return zzal(zzaq(paramInt));
  }
  
  public static int zzan(int paramInt) {
    return 4;
  }
  
  public static int zzao(int paramInt) {
    return 4;
  }
  
  public static int zzap(int paramInt) {
    return zzak(paramInt);
  }
  
  private static int zzaq(int paramInt) {
    return paramInt >> 31 ^ paramInt << 1;
  }
  
  @Deprecated
  public static int zzar(int paramInt) {
    return zzal(paramInt);
  }
  
  public static int zzat(long paramLong) {
    return zzau(paramLong);
  }
  
  public static int zzau(long paramLong) {
    if ((0xFFFFFFFFFFFFFF80L & paramLong) == 0L)
      return 1; 
    if (paramLong < 0L)
      return 10; 
    if ((0xFFFFFFF800000000L & paramLong) != 0L) {
      i = 6;
      paramLong >>>= 28L;
    } else {
      i = 2;
    } 
    int j = i;
    long l = paramLong;
    if ((0xFFFFFFFFFFE00000L & paramLong) != 0L) {
      j = i + 2;
      l = paramLong >>> 14L;
    } 
    int i = j;
    if ((l & 0xFFFFFFFFFFFFC000L) != 0L)
      i = j + 1; 
    return i;
  }
  
  public static int zzav(long paramLong) {
    return zzau(zzay(paramLong));
  }
  
  public static int zzaw(long paramLong) {
    return 8;
  }
  
  public static int zzax(long paramLong) {
    return 8;
  }
  
  private static long zzay(long paramLong) {
    return paramLong >> 63L ^ paramLong << 1L;
  }
  
  public static int zzb(float paramFloat) {
    return 4;
  }
  
  public static int zzb(int paramInt, double paramDouble) {
    return zzaj(paramInt) + 8;
  }
  
  public static int zzb(int paramInt, float paramFloat) {
    return zzaj(paramInt) + 4;
  }
  
  public static int zzb(int paramInt, zzfo paramzzfo) {
    return (zzaj(1) << 1) + zzh(2, paramInt) + zza(3, paramzzfo);
  }
  
  static int zzb(int paramInt, zzgh paramzzgh, zzgy paramzzgy) {
    return zzaj(paramInt) + zzb(paramzzgh, paramzzgy);
  }
  
  public static int zzb(zzdp paramzzdp) {
    int i = paramzzdp.size();
    return zzal(i) + i;
  }
  
  static int zzb(zzgh paramzzgh, zzgy<zzgh> paramzzgy) {
    paramzzgh = paramzzgh;
    int i = paramzzgh.zzjw();
    int j = i;
    if (i == -1) {
      j = paramzzgy.zzs(paramzzgh);
      paramzzgh.zzn(j);
    } 
    return zzal(j) + j;
  }
  
  public static int zzc(int paramInt, zzdp paramzzdp) {
    paramInt = zzaj(paramInt);
    int i = paramzzdp.size();
    return paramInt + zzal(i) + i;
  }
  
  public static int zzc(int paramInt, zzgh paramzzgh) {
    return zzaj(paramInt) + zzc(paramzzgh);
  }
  
  @Deprecated
  static int zzc(int paramInt, zzgh paramzzgh, zzgy<zzgh> paramzzgy) {
    int i = zzaj(paramInt);
    paramzzgh = paramzzgh;
    int j = paramzzgh.zzjw();
    paramInt = j;
    if (j == -1) {
      paramInt = paramzzgy.zzs(paramzzgh);
      paramzzgh.zzn(paramInt);
    } 
    return (i << 1) + paramInt;
  }
  
  public static int zzc(int paramInt, String paramString) {
    return zzaj(paramInt) + zzcp(paramString);
  }
  
  public static int zzc(int paramInt, boolean paramBoolean) {
    return zzaj(paramInt) + 1;
  }
  
  public static int zzc(zzgh paramzzgh) {
    int i = paramzzgh.zzly();
    return zzal(i) + i;
  }
  
  public static int zzcp(String paramString) {
    int i;
    try {
      i = zzhy.zza(paramString);
    } catch (zzic zzic) {
      i = (paramString.getBytes(zzfb.UTF_8)).length;
    } 
    return zzal(i) + i;
  }
  
  public static int zzd(int paramInt, long paramLong) {
    return zzaj(paramInt) + zzau(paramLong);
  }
  
  public static int zzd(int paramInt, zzdp paramzzdp) {
    return (zzaj(1) << 1) + zzh(2, paramInt) + zzc(3, paramzzdp);
  }
  
  public static int zzd(int paramInt, zzgh paramzzgh) {
    return (zzaj(1) << 1) + zzh(2, paramInt) + zzc(3, paramzzgh);
  }
  
  @Deprecated
  public static int zzd(zzgh paramzzgh) {
    return paramzzgh.zzly();
  }
  
  public static int zze(double paramDouble) {
    return 8;
  }
  
  public static int zze(int paramInt, long paramLong) {
    return zzaj(paramInt) + zzau(paramLong);
  }
  
  public static int zzf(int paramInt, long paramLong) {
    return zzaj(paramInt) + zzau(zzay(paramLong));
  }
  
  public static int zzg(int paramInt1, int paramInt2) {
    return zzaj(paramInt1) + zzak(paramInt2);
  }
  
  public static int zzg(int paramInt, long paramLong) {
    return zzaj(paramInt) + 8;
  }
  
  public static int zzh(int paramInt1, int paramInt2) {
    return zzaj(paramInt1) + zzal(paramInt2);
  }
  
  public static int zzh(int paramInt, long paramLong) {
    return zzaj(paramInt) + 8;
  }
  
  public static zzeg zzh(byte[] paramArrayOfbyte) {
    return new zza(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public static int zzi(int paramInt1, int paramInt2) {
    return zzaj(paramInt1) + zzal(zzaq(paramInt2));
  }
  
  public static int zzi(byte[] paramArrayOfbyte) {
    int i = paramArrayOfbyte.length;
    return zzal(i) + i;
  }
  
  public static int zzj(int paramInt1, int paramInt2) {
    return zzaj(paramInt1) + 4;
  }
  
  public static int zzk(int paramInt1, int paramInt2) {
    return zzaj(paramInt1) + 4;
  }
  
  public static int zzl(int paramInt1, int paramInt2) {
    return zzaj(paramInt1) + zzak(paramInt2);
  }
  
  public static int zzn(boolean paramBoolean) {
    return 1;
  }
  
  public abstract void flush() throws IOException;
  
  public abstract void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException;
  
  public final void zza(float paramFloat) throws IOException {
    zzai(Float.floatToRawIntBits(paramFloat));
  }
  
  public final void zza(int paramInt, double paramDouble) throws IOException {
    zzc(paramInt, Double.doubleToRawLongBits(paramDouble));
  }
  
  public final void zza(int paramInt, float paramFloat) throws IOException {
    zzf(paramInt, Float.floatToRawIntBits(paramFloat));
  }
  
  public abstract void zza(int paramInt, long paramLong) throws IOException;
  
  public abstract void zza(int paramInt, zzdp paramzzdp) throws IOException;
  
  public abstract void zza(int paramInt, zzgh paramzzgh) throws IOException;
  
  abstract void zza(int paramInt, zzgh paramzzgh, zzgy paramzzgy) throws IOException;
  
  public abstract void zza(zzdp paramzzdp) throws IOException;
  
  abstract void zza(zzgh paramzzgh, zzgy paramzzgy) throws IOException;
  
  final void zza(String paramString, zzic paramzzic) throws IOException {
    logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", paramzzic);
    byte[] arrayOfByte = paramString.getBytes(zzfb.UTF_8);
    try {
      zzag(arrayOfByte.length);
      zza(arrayOfByte, 0, arrayOfByte.length);
      return;
    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
      throw new zzc(indexOutOfBoundsException);
    } catch (zzc zzc) {
      throw zzc;
    } 
  }
  
  public abstract void zzaf(int paramInt) throws IOException;
  
  public abstract void zzag(int paramInt) throws IOException;
  
  public final void zzah(int paramInt) throws IOException {
    zzag(zzaq(paramInt));
  }
  
  public abstract void zzai(int paramInt) throws IOException;
  
  public abstract void zzaq(long paramLong) throws IOException;
  
  public final void zzar(long paramLong) throws IOException {
    zzaq(zzay(paramLong));
  }
  
  public abstract void zzas(long paramLong) throws IOException;
  
  public abstract void zzb(int paramInt1, int paramInt2) throws IOException;
  
  public final void zzb(int paramInt, long paramLong) throws IOException {
    zza(paramInt, zzay(paramLong));
  }
  
  public abstract void zzb(int paramInt, zzdp paramzzdp) throws IOException;
  
  public abstract void zzb(int paramInt, zzgh paramzzgh) throws IOException;
  
  public abstract void zzb(int paramInt, String paramString) throws IOException;
  
  public abstract void zzb(int paramInt, boolean paramBoolean) throws IOException;
  
  public abstract void zzb(zzgh paramzzgh) throws IOException;
  
  public abstract void zzc(byte paramByte) throws IOException;
  
  public abstract void zzc(int paramInt1, int paramInt2) throws IOException;
  
  public abstract void zzc(int paramInt, long paramLong) throws IOException;
  
  public abstract void zzco(String paramString) throws IOException;
  
  public final void zzd(double paramDouble) throws IOException {
    zzas(Double.doubleToRawLongBits(paramDouble));
  }
  
  public abstract void zzd(int paramInt1, int paramInt2) throws IOException;
  
  public final void zze(int paramInt1, int paramInt2) throws IOException {
    zzd(paramInt1, zzaq(paramInt2));
  }
  
  abstract void zze(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException;
  
  public abstract void zzf(int paramInt1, int paramInt2) throws IOException;
  
  public abstract int zzlj();
  
  public final void zzlk() {
    if (zzlj() == 0)
      return; 
    throw new IllegalStateException("Did not write as much data as expected.");
  }
  
  public final void zzm(boolean paramBoolean) throws IOException {
    zzc((byte)paramBoolean);
  }
  
  static class zza extends zzeg {
    private final byte[] buffer;
    
    private final int limit;
    
    private final int offset;
    
    private int position;
    
    zza(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      super(null);
      if (param1ArrayOfbyte != null) {
        int i = param1ArrayOfbyte.length;
        int j = param1Int1 + param1Int2;
        if ((param1Int1 | param1Int2 | i - j) >= 0) {
          this.buffer = param1ArrayOfbyte;
          this.offset = param1Int1;
          this.position = param1Int1;
          this.limit = j;
          return;
        } 
        throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[] { Integer.valueOf(param1ArrayOfbyte.length), Integer.valueOf(param1Int1), Integer.valueOf(param1Int2) }));
      } 
      throw new NullPointerException("buffer");
    }
    
    public void flush() {}
    
    public final void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      try {
        System.arraycopy(param1ArrayOfbyte, param1Int1, this.buffer, this.position, param1Int2);
        this.position += param1Int2;
        return;
      } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        throw new zzeg.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(param1Int2) }), indexOutOfBoundsException);
      } 
    }
    
    public final void zza(int param1Int, long param1Long) throws IOException {
      super.zzb(param1Int, 0);
      super.zzaq(param1Long);
    }
    
    public final void zza(int param1Int, zzdp param1zzdp) throws IOException {
      super.zzb(param1Int, 2);
      super.zza(param1zzdp);
    }
    
    public final void zza(int param1Int, zzgh param1zzgh) throws IOException {
      super.zzb(param1Int, 2);
      super.zzb(param1zzgh);
    }
    
    final void zza(int param1Int, zzgh param1zzgh, zzgy<zzdg> param1zzgy) throws IOException {
      super.zzb(param1Int, 2);
      zzdg zzdg = (zzdg)param1zzgh;
      int i = zzdg.zzjw();
      param1Int = i;
      if (i == -1) {
        param1Int = param1zzgy.zzs(zzdg);
        zzdg.zzn(param1Int);
      } 
      super.zzag(param1Int);
      param1zzgy.zza(param1zzgh, this.zzacw);
    }
    
    public final void zza(zzdp param1zzdp) throws IOException {
      super.zzag(param1zzdp.size());
      param1zzdp.zza(this);
    }
    
    final void zza(zzgh param1zzgh, zzgy<zzdg> param1zzgy) throws IOException {
      zzdg zzdg = (zzdg)param1zzgh;
      int i = zzdg.zzjw();
      int j = i;
      if (i == -1) {
        j = param1zzgy.zzs(zzdg);
        zzdg.zzn(j);
      } 
      super.zzag(j);
      param1zzgy.zza(param1zzgh, this.zzacw);
    }
    
    public final void zza(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      super.write(param1ArrayOfbyte, param1Int1, param1Int2);
    }
    
    public final void zzaf(int param1Int) throws IOException {
      if (param1Int >= 0) {
        super.zzag(param1Int);
        return;
      } 
      super.zzaq(param1Int);
    }
    
    public final void zzag(int param1Int) throws IOException {
      int i = param1Int;
      if (zzeg.zzll()) {
        i = param1Int;
        if (super.zzlj() >= 10)
          while (true) {
            if ((param1Int & 0xFFFFFF80) == 0) {
              byte[] arrayOfByte1 = this.buffer;
              i = this.position;
              this.position = i + 1;
              zzhw.zza(arrayOfByte1, i, (byte)param1Int);
              return;
            } 
            byte[] arrayOfByte = this.buffer;
            i = this.position;
            this.position = i + 1;
            zzhw.zza(arrayOfByte, i, (byte)(param1Int & 0x7F | 0x80));
            param1Int >>>= 7;
          }  
      } 
      while (true) {
        if ((i & 0xFFFFFF80) == 0)
          try {
            byte[] arrayOfByte1 = this.buffer;
            param1Int = this.position;
            this.position = param1Int + 1;
            arrayOfByte1[param1Int] = (byte)(byte)i;
            return;
          } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new zzeg.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), indexOutOfBoundsException);
          }  
        byte[] arrayOfByte = this.buffer;
        param1Int = this.position;
        this.position = param1Int + 1;
        arrayOfByte[param1Int] = (byte)(byte)(i & 0x7F | 0x80);
        i >>>= 7;
      } 
    }
    
    public final void zzai(int param1Int) throws IOException {
      try {
        byte[] arrayOfByte = this.buffer;
        int i = this.position;
        this.position = i + 1;
        arrayOfByte[i] = (byte)(byte)param1Int;
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = i + 1;
        arrayOfByte[i] = (byte)(byte)(param1Int >> 8);
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = i + 1;
        arrayOfByte[i] = (byte)(byte)(param1Int >> 16);
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = i + 1;
        arrayOfByte[i] = (byte)(byte)(param1Int >>> 24);
        return;
      } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        throw new zzeg.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), indexOutOfBoundsException);
      } 
    }
    
    public final void zzaq(long param1Long) throws IOException {
      long l = param1Long;
      if (zzeg.zzll()) {
        l = param1Long;
        if (super.zzlj() >= 10)
          while (true) {
            if ((param1Long & 0xFFFFFFFFFFFFFF80L) == 0L) {
              byte[] arrayOfByte1 = this.buffer;
              int j = this.position;
              this.position = j + 1;
              zzhw.zza(arrayOfByte1, j, (byte)(int)param1Long);
              return;
            } 
            byte[] arrayOfByte = this.buffer;
            int i = this.position;
            this.position = i + 1;
            zzhw.zza(arrayOfByte, i, (byte)((int)param1Long & 0x7F | 0x80));
            param1Long >>>= 7L;
          }  
      } 
      while (true) {
        if ((l & 0xFFFFFFFFFFFFFF80L) == 0L)
          try {
            byte[] arrayOfByte1 = this.buffer;
            int j = this.position;
            this.position = j + 1;
            arrayOfByte1[j] = (byte)(byte)(int)l;
            return;
          } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new zzeg.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), indexOutOfBoundsException);
          }  
        byte[] arrayOfByte = this.buffer;
        int i = this.position;
        this.position = i + 1;
        arrayOfByte[i] = (byte)(byte)((int)l & 0x7F | 0x80);
        l >>>= 7L;
      } 
    }
    
    public final void zzas(long param1Long) throws IOException {
      try {
        byte[] arrayOfByte = this.buffer;
        int i = this.position;
        this.position = i + 1;
        arrayOfByte[i] = (byte)(byte)(int)param1Long;
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = i + 1;
        arrayOfByte[i] = (byte)(byte)(int)(param1Long >> 8L);
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = i + 1;
        arrayOfByte[i] = (byte)(byte)(int)(param1Long >> 16L);
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = i + 1;
        arrayOfByte[i] = (byte)(byte)(int)(param1Long >> 24L);
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = i + 1;
        arrayOfByte[i] = (byte)(byte)(int)(param1Long >> 32L);
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = i + 1;
        arrayOfByte[i] = (byte)(byte)(int)(param1Long >> 40L);
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = i + 1;
        arrayOfByte[i] = (byte)(byte)(int)(param1Long >> 48L);
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = i + 1;
        arrayOfByte[i] = (byte)(byte)(int)(param1Long >> 56L);
        return;
      } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        throw new zzeg.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), indexOutOfBoundsException);
      } 
    }
    
    public final void zzb(int param1Int1, int param1Int2) throws IOException {
      super.zzag(param1Int1 << 3 | param1Int2);
    }
    
    public final void zzb(int param1Int, zzdp param1zzdp) throws IOException {
      super.zzb(1, 3);
      super.zzd(2, param1Int);
      super.zza(3, param1zzdp);
      super.zzb(1, 4);
    }
    
    public final void zzb(int param1Int, zzgh param1zzgh) throws IOException {
      super.zzb(1, 3);
      super.zzd(2, param1Int);
      super.zza(3, param1zzgh);
      super.zzb(1, 4);
    }
    
    public final void zzb(int param1Int, String param1String) throws IOException {
      super.zzb(param1Int, 2);
      super.zzco(param1String);
    }
    
    public final void zzb(int param1Int, boolean param1Boolean) throws IOException {
      super.zzb(param1Int, 0);
      super.zzc((byte)param1Boolean);
    }
    
    public final void zzb(zzgh param1zzgh) throws IOException {
      super.zzag(param1zzgh.zzly());
      param1zzgh.zzb(this);
    }
    
    public final void zzc(byte param1Byte) throws IOException {
      try {
        byte[] arrayOfByte = this.buffer;
        int i = this.position;
        this.position = i + 1;
        arrayOfByte[i] = (byte)param1Byte;
        return;
      } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        throw new zzeg.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), indexOutOfBoundsException);
      } 
    }
    
    public final void zzc(int param1Int1, int param1Int2) throws IOException {
      super.zzb(param1Int1, 0);
      super.zzaf(param1Int2);
    }
    
    public final void zzc(int param1Int, long param1Long) throws IOException {
      super.zzb(param1Int, 1);
      super.zzas(param1Long);
    }
    
    public final void zzco(String param1String) throws IOException {
      int i = this.position;
      try {
        int j = zzal(param1String.length() * 3);
        int k = zzal(param1String.length());
        if (k == j) {
          this.position = i + k;
          j = zzhy.zza(param1String, this.buffer, this.position, super.zzlj());
          this.position = i;
          super.zzag(j - i - k);
          this.position = j;
          return;
        } 
        super.zzag(zzhy.zza(param1String));
        this.position = zzhy.zza(param1String, this.buffer, this.position, super.zzlj());
        return;
      } catch (zzic zzic) {
        this.position = i;
        zza(param1String, zzic);
        return;
      } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        throw new zzeg.zzc(indexOutOfBoundsException);
      } 
    }
    
    public final void zzd(int param1Int1, int param1Int2) throws IOException {
      super.zzb(param1Int1, 0);
      super.zzag(param1Int2);
    }
    
    public final void zze(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      super.zzag(param1Int2);
      super.write(param1ArrayOfbyte, 0, param1Int2);
    }
    
    public final void zzf(int param1Int1, int param1Int2) throws IOException {
      super.zzb(param1Int1, 5);
      super.zzai(param1Int2);
    }
    
    public final int zzlj() {
      return this.limit - this.position;
    }
    
    public final int zzlm() {
      return this.position - this.offset;
    }
  }
  
  static final class zzb extends zza {
    private final ByteBuffer zzacx;
    
    private int zzacy;
    
    zzb(ByteBuffer param1ByteBuffer) {
      super(param1ByteBuffer.array(), param1ByteBuffer.arrayOffset() + param1ByteBuffer.position(), param1ByteBuffer.remaining());
      this.zzacx = param1ByteBuffer;
      this.zzacy = param1ByteBuffer.position();
    }
    
    public final void flush() {
      this.zzacx.position(this.zzacy + zzlm());
    }
  }
  
  public static final class zzc extends IOException {
    zzc() {
      super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }
    
    zzc(String param1String) {
      super(param1String);
    }
    
    zzc(String param1String, Throwable param1Throwable) {
      super(param1String, param1Throwable);
    }
    
    zzc(Throwable param1Throwable) {
      super("CodedOutputStream was writing to a flat byte array and ran out of space.", param1Throwable);
    }
  }
  
  static final class zzd extends zzeg {
    private final int zzacy;
    
    private final ByteBuffer zzacz;
    
    private final ByteBuffer zzada;
    
    zzd(ByteBuffer param1ByteBuffer) {
      super(null);
      this.zzacz = param1ByteBuffer;
      this.zzada = param1ByteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
      this.zzacy = param1ByteBuffer.position();
    }
    
    private final void zzcq(String param1String) throws IOException {
      try {
        zzhy.zza(param1String, this.zzada);
        return;
      } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        throw new zzeg.zzc(indexOutOfBoundsException);
      } 
    }
    
    public final void flush() {
      this.zzacz.position(this.zzada.position());
    }
    
    public final void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      try {
        this.zzada.put(param1ArrayOfbyte, param1Int1, param1Int2);
        return;
      } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        throw new zzeg.zzc(indexOutOfBoundsException);
      } catch (BufferOverflowException bufferOverflowException) {
        throw new zzeg.zzc(bufferOverflowException);
      } 
    }
    
    public final void zza(int param1Int, long param1Long) throws IOException {
      super.zzb(param1Int, 0);
      super.zzaq(param1Long);
    }
    
    public final void zza(int param1Int, zzdp param1zzdp) throws IOException {
      super.zzb(param1Int, 2);
      super.zza(param1zzdp);
    }
    
    public final void zza(int param1Int, zzgh param1zzgh) throws IOException {
      super.zzb(param1Int, 2);
      super.zzb(param1zzgh);
    }
    
    final void zza(int param1Int, zzgh param1zzgh, zzgy param1zzgy) throws IOException {
      super.zzb(param1Int, 2);
      super.zza(param1zzgh, param1zzgy);
    }
    
    public final void zza(zzdp param1zzdp) throws IOException {
      super.zzag(param1zzdp.size());
      param1zzdp.zza(this);
    }
    
    final void zza(zzgh param1zzgh, zzgy<zzdg> param1zzgy) throws IOException {
      zzdg zzdg = (zzdg)param1zzgh;
      int i = zzdg.zzjw();
      int j = i;
      if (i == -1) {
        j = param1zzgy.zzs(zzdg);
        zzdg.zzn(j);
      } 
      super.zzag(j);
      param1zzgy.zza(param1zzgh, this.zzacw);
    }
    
    public final void zza(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      super.write(param1ArrayOfbyte, param1Int1, param1Int2);
    }
    
    public final void zzaf(int param1Int) throws IOException {
      if (param1Int >= 0) {
        super.zzag(param1Int);
        return;
      } 
      super.zzaq(param1Int);
    }
    
    public final void zzag(int param1Int) throws IOException {
      while (true) {
        if ((param1Int & 0xFFFFFF80) == 0)
          try {
            this.zzada.put((byte)param1Int);
            return;
          } catch (BufferOverflowException bufferOverflowException) {
            throw new zzeg.zzc(bufferOverflowException);
          }  
        this.zzada.put((byte)(param1Int & 0x7F | 0x80));
        param1Int >>>= 7;
      } 
    }
    
    public final void zzai(int param1Int) throws IOException {
      try {
        this.zzada.putInt(param1Int);
        return;
      } catch (BufferOverflowException bufferOverflowException) {
        throw new zzeg.zzc(bufferOverflowException);
      } 
    }
    
    public final void zzaq(long param1Long) throws IOException {
      while (true) {
        if ((0xFFFFFFFFFFFFFF80L & param1Long) == 0L)
          try {
            this.zzada.put((byte)(int)param1Long);
            return;
          } catch (BufferOverflowException bufferOverflowException) {
            throw new zzeg.zzc(bufferOverflowException);
          }  
        this.zzada.put((byte)((int)param1Long & 0x7F | 0x80));
        param1Long >>>= 7L;
      } 
    }
    
    public final void zzas(long param1Long) throws IOException {
      try {
        this.zzada.putLong(param1Long);
        return;
      } catch (BufferOverflowException bufferOverflowException) {
        throw new zzeg.zzc(bufferOverflowException);
      } 
    }
    
    public final void zzb(int param1Int1, int param1Int2) throws IOException {
      super.zzag(param1Int1 << 3 | param1Int2);
    }
    
    public final void zzb(int param1Int, zzdp param1zzdp) throws IOException {
      super.zzb(1, 3);
      super.zzd(2, param1Int);
      super.zza(3, param1zzdp);
      super.zzb(1, 4);
    }
    
    public final void zzb(int param1Int, zzgh param1zzgh) throws IOException {
      super.zzb(1, 3);
      super.zzd(2, param1Int);
      super.zza(3, param1zzgh);
      super.zzb(1, 4);
    }
    
    public final void zzb(int param1Int, String param1String) throws IOException {
      super.zzb(param1Int, 2);
      super.zzco(param1String);
    }
    
    public final void zzb(int param1Int, boolean param1Boolean) throws IOException {
      super.zzb(param1Int, 0);
      super.zzc((byte)param1Boolean);
    }
    
    public final void zzb(zzgh param1zzgh) throws IOException {
      super.zzag(param1zzgh.zzly());
      param1zzgh.zzb(this);
    }
    
    public final void zzc(byte param1Byte) throws IOException {
      try {
        this.zzada.put(param1Byte);
        return;
      } catch (BufferOverflowException bufferOverflowException) {
        throw new zzeg.zzc(bufferOverflowException);
      } 
    }
    
    public final void zzc(int param1Int1, int param1Int2) throws IOException {
      super.zzb(param1Int1, 0);
      super.zzaf(param1Int2);
    }
    
    public final void zzc(int param1Int, long param1Long) throws IOException {
      super.zzb(param1Int, 1);
      super.zzas(param1Long);
    }
    
    public final void zzco(String param1String) throws IOException {
      int i = this.zzada.position();
      try {
        int j = zzal(param1String.length() * 3);
        int k = zzal(param1String.length());
        if (k == j) {
          k = this.zzada.position() + k;
          this.zzada.position(k);
          zzcq(param1String);
          j = this.zzada.position();
          this.zzada.position(i);
          super.zzag(j - k);
          this.zzada.position(j);
          return;
        } 
        super.zzag(zzhy.zza(param1String));
        zzcq(param1String);
        return;
      } catch (zzic zzic) {
        this.zzada.position(i);
        zza(param1String, zzic);
        return;
      } catch (IllegalArgumentException illegalArgumentException) {
        throw new zzeg.zzc(illegalArgumentException);
      } 
    }
    
    public final void zzd(int param1Int1, int param1Int2) throws IOException {
      super.zzb(param1Int1, 0);
      super.zzag(param1Int2);
    }
    
    public final void zze(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      super.zzag(param1Int2);
      super.write(param1ArrayOfbyte, 0, param1Int2);
    }
    
    public final void zzf(int param1Int1, int param1Int2) throws IOException {
      super.zzb(param1Int1, 5);
      super.zzai(param1Int2);
    }
    
    public final int zzlj() {
      return this.zzada.remaining();
    }
  }
  
  static final class zze extends zzeg {
    private final ByteBuffer zzacz;
    
    private final ByteBuffer zzada;
    
    private final long zzadb;
    
    private final long zzadc;
    
    private final long zzadd;
    
    private final long zzade;
    
    private long zzadf;
    
    zze(ByteBuffer param1ByteBuffer) {
      super(null);
      this.zzacz = param1ByteBuffer;
      this.zzada = param1ByteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
      this.zzadb = zzhw.zzb(param1ByteBuffer);
      this.zzadc = this.zzadb + param1ByteBuffer.position();
      this.zzadd = this.zzadb + param1ByteBuffer.limit();
      this.zzade = this.zzadd - 10L;
      this.zzadf = this.zzadc;
    }
    
    private final void zzaz(long param1Long) {
      this.zzada.position((int)(param1Long - this.zzadb));
    }
    
    public final void flush() {
      this.zzacz.position((int)(this.zzadf - this.zzadb));
    }
    
    public final void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      if (param1ArrayOfbyte != null && param1Int1 >= 0 && param1Int2 >= 0 && param1ArrayOfbyte.length - param1Int2 >= param1Int1) {
        long l1 = this.zzadd;
        long l2 = param1Int2;
        long l3 = this.zzadf;
        if (l1 - l2 >= l3) {
          zzhw.zza(param1ArrayOfbyte, param1Int1, l3, l2);
          this.zzadf += l2;
          return;
        } 
      } 
      if (param1ArrayOfbyte == null)
        throw new NullPointerException("value"); 
      throw new zzeg.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Long.valueOf(this.zzadf), Long.valueOf(this.zzadd), Integer.valueOf(param1Int2) }));
    }
    
    public final void zza(int param1Int, long param1Long) throws IOException {
      super.zzb(param1Int, 0);
      super.zzaq(param1Long);
    }
    
    public final void zza(int param1Int, zzdp param1zzdp) throws IOException {
      super.zzb(param1Int, 2);
      super.zza(param1zzdp);
    }
    
    public final void zza(int param1Int, zzgh param1zzgh) throws IOException {
      super.zzb(param1Int, 2);
      super.zzb(param1zzgh);
    }
    
    final void zza(int param1Int, zzgh param1zzgh, zzgy param1zzgy) throws IOException {
      super.zzb(param1Int, 2);
      super.zza(param1zzgh, param1zzgy);
    }
    
    public final void zza(zzdp param1zzdp) throws IOException {
      super.zzag(param1zzdp.size());
      param1zzdp.zza(this);
    }
    
    final void zza(zzgh param1zzgh, zzgy<zzdg> param1zzgy) throws IOException {
      zzdg zzdg = (zzdg)param1zzgh;
      int i = zzdg.zzjw();
      int j = i;
      if (i == -1) {
        j = param1zzgy.zzs(zzdg);
        zzdg.zzn(j);
      } 
      super.zzag(j);
      param1zzgy.zza(param1zzgh, this.zzacw);
    }
    
    public final void zza(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      super.write(param1ArrayOfbyte, param1Int1, param1Int2);
    }
    
    public final void zzaf(int param1Int) throws IOException {
      if (param1Int >= 0) {
        super.zzag(param1Int);
        return;
      } 
      super.zzaq(param1Int);
    }
    
    public final void zzag(int param1Int) throws IOException {
      int i = param1Int;
      if (this.zzadf <= this.zzade)
        while (true) {
          if ((param1Int & 0xFFFFFF80) == 0) {
            long l1 = this.zzadf;
            this.zzadf = 1L + l1;
            zzhw.zza(l1, (byte)param1Int);
            return;
          } 
          long l = this.zzadf;
          this.zzadf = l + 1L;
          zzhw.zza(l, (byte)(param1Int & 0x7F | 0x80));
          param1Int >>>= 7;
        }  
      while (true) {
        long l = this.zzadf;
        if (l < this.zzadd) {
          if ((i & 0xFFFFFF80) == 0) {
            this.zzadf = 1L + l;
            zzhw.zza(l, (byte)i);
            return;
          } 
          this.zzadf = l + 1L;
          zzhw.zza(l, (byte)(i & 0x7F | 0x80));
          i >>>= 7;
          continue;
        } 
        throw new zzeg.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Long.valueOf(l), Long.valueOf(this.zzadd), Integer.valueOf(1) }));
      } 
    }
    
    public final void zzai(int param1Int) throws IOException {
      this.zzada.putInt((int)(this.zzadf - this.zzadb), param1Int);
      this.zzadf += 4L;
    }
    
    public final void zzaq(long param1Long) throws IOException {
      long l = param1Long;
      if (this.zzadf <= this.zzade)
        while (true) {
          if ((param1Long & 0xFFFFFFFFFFFFFF80L) == 0L) {
            l = this.zzadf;
            this.zzadf = 1L + l;
            zzhw.zza(l, (byte)(int)param1Long);
            return;
          } 
          l = this.zzadf;
          this.zzadf = l + 1L;
          zzhw.zza(l, (byte)((int)param1Long & 0x7F | 0x80));
          param1Long >>>= 7L;
        }  
      while (true) {
        param1Long = this.zzadf;
        if (param1Long < this.zzadd) {
          if ((l & 0xFFFFFFFFFFFFFF80L) == 0L) {
            this.zzadf = 1L + param1Long;
            zzhw.zza(param1Long, (byte)(int)l);
            return;
          } 
          this.zzadf = param1Long + 1L;
          zzhw.zza(param1Long, (byte)((int)l & 0x7F | 0x80));
          l >>>= 7L;
          continue;
        } 
        throw new zzeg.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Long.valueOf(param1Long), Long.valueOf(this.zzadd), Integer.valueOf(1) }));
      } 
    }
    
    public final void zzas(long param1Long) throws IOException {
      this.zzada.putLong((int)(this.zzadf - this.zzadb), param1Long);
      this.zzadf += 8L;
    }
    
    public final void zzb(int param1Int1, int param1Int2) throws IOException {
      super.zzag(param1Int1 << 3 | param1Int2);
    }
    
    public final void zzb(int param1Int, zzdp param1zzdp) throws IOException {
      super.zzb(1, 3);
      super.zzd(2, param1Int);
      super.zza(3, param1zzdp);
      super.zzb(1, 4);
    }
    
    public final void zzb(int param1Int, zzgh param1zzgh) throws IOException {
      super.zzb(1, 3);
      super.zzd(2, param1Int);
      super.zza(3, param1zzgh);
      super.zzb(1, 4);
    }
    
    public final void zzb(int param1Int, String param1String) throws IOException {
      super.zzb(param1Int, 2);
      super.zzco(param1String);
    }
    
    public final void zzb(int param1Int, boolean param1Boolean) throws IOException {
      super.zzb(param1Int, 0);
      super.zzc((byte)param1Boolean);
    }
    
    public final void zzb(zzgh param1zzgh) throws IOException {
      super.zzag(param1zzgh.zzly());
      param1zzgh.zzb(this);
    }
    
    public final void zzc(byte param1Byte) throws IOException {
      long l = this.zzadf;
      if (l < this.zzadd) {
        this.zzadf = 1L + l;
        zzhw.zza(l, param1Byte);
        return;
      } 
      throw new zzeg.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Long.valueOf(l), Long.valueOf(this.zzadd), Integer.valueOf(1) }));
    }
    
    public final void zzc(int param1Int1, int param1Int2) throws IOException {
      super.zzb(param1Int1, 0);
      super.zzaf(param1Int2);
    }
    
    public final void zzc(int param1Int, long param1Long) throws IOException {
      super.zzb(param1Int, 1);
      super.zzas(param1Long);
    }
    
    public final void zzco(String param1String) throws IOException {
      long l = this.zzadf;
      try {
        int i = zzal(param1String.length() * 3);
        int j = zzal(param1String.length());
        if (j == i) {
          j = (int)(this.zzadf - this.zzadb) + j;
          this.zzada.position(j);
          zzhy.zza(param1String, this.zzada);
          j = this.zzada.position() - j;
          super.zzag(j);
          this.zzadf += j;
          return;
        } 
        j = zzhy.zza(param1String);
        super.zzag(j);
        zzaz(this.zzadf);
        zzhy.zza(param1String, this.zzada);
        this.zzadf += j;
        return;
      } catch (zzic zzic) {
        this.zzadf = l;
        zzaz(this.zzadf);
        zza(param1String, zzic);
        return;
      } catch (IllegalArgumentException illegalArgumentException) {
        throw new zzeg.zzc(illegalArgumentException);
      } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        throw new zzeg.zzc(indexOutOfBoundsException);
      } 
    }
    
    public final void zzd(int param1Int1, int param1Int2) throws IOException {
      super.zzb(param1Int1, 0);
      super.zzag(param1Int2);
    }
    
    public final void zze(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      super.zzag(param1Int2);
      super.write(param1ArrayOfbyte, 0, param1Int2);
    }
    
    public final void zzf(int param1Int1, int param1Int2) throws IOException {
      super.zzb(param1Int1, 5);
      super.zzai(param1Int2);
    }
    
    public final int zzlj() {
      return (int)(this.zzadd - this.zzadf);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzeg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */