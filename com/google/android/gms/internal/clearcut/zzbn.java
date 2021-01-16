package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzbn extends zzba {
  private static final Logger logger = Logger.getLogger(zzbn.class.getName());
  
  private static final boolean zzfy = zzfd.zzed();
  
  zzbp zzfz;
  
  private zzbn() {}
  
  public static int zza(int paramInt, zzcv paramzzcv) {
    paramInt = zzr(paramInt);
    int i = paramzzcv.zzas();
    return paramInt + zzt(i) + i;
  }
  
  public static int zza(zzcv paramzzcv) {
    int i = paramzzcv.zzas();
    return zzt(i) + i;
  }
  
  public static zzbn zza(ByteBuffer paramByteBuffer) {
    if (paramByteBuffer.hasArray())
      return new zzb(paramByteBuffer); 
    if (paramByteBuffer.isDirect() && !paramByteBuffer.isReadOnly())
      return (zzbn)(zzfd.zzee() ? new zze(paramByteBuffer) : new zzd(paramByteBuffer)); 
    throw new IllegalArgumentException("ByteBuffer is read-only");
  }
  
  public static int zzb(double paramDouble) {
    return 8;
  }
  
  public static int zzb(float paramFloat) {
    return 4;
  }
  
  public static int zzb(int paramInt, double paramDouble) {
    return zzr(paramInt) + 8;
  }
  
  public static int zzb(int paramInt, float paramFloat) {
    return zzr(paramInt) + 4;
  }
  
  public static int zzb(int paramInt, zzcv paramzzcv) {
    return (zzr(1) << 1) + zzh(2, paramInt) + zza(3, paramzzcv);
  }
  
  static int zzb(int paramInt, zzdo paramzzdo, zzef paramzzef) {
    return zzr(paramInt) + zzb(paramzzdo, paramzzef);
  }
  
  public static int zzb(int paramInt, String paramString) {
    return zzr(paramInt) + zzh(paramString);
  }
  
  public static int zzb(zzbb paramzzbb) {
    int i = paramzzbb.size();
    return zzt(i) + i;
  }
  
  static int zzb(zzdo paramzzdo, zzef<zzdo> paramzzef) {
    paramzzdo = paramzzdo;
    int i = paramzzdo.zzs();
    int j = i;
    if (i == -1) {
      j = paramzzef.zzm(paramzzdo);
      paramzzdo.zzf(j);
    } 
    return zzt(j) + j;
  }
  
  public static int zzb(boolean paramBoolean) {
    return 1;
  }
  
  public static int zzc(int paramInt, zzbb paramzzbb) {
    paramInt = zzr(paramInt);
    int i = paramzzbb.size();
    return paramInt + zzt(i) + i;
  }
  
  public static int zzc(int paramInt, zzdo paramzzdo) {
    return zzr(paramInt) + zzc(paramzzdo);
  }
  
  @Deprecated
  static int zzc(int paramInt, zzdo paramzzdo, zzef<zzdo> paramzzef) {
    int i = zzr(paramInt);
    paramzzdo = paramzzdo;
    int j = paramzzdo.zzs();
    paramInt = j;
    if (j == -1) {
      paramInt = paramzzef.zzm(paramzzdo);
      paramzzdo.zzf(paramInt);
    } 
    return (i << 1) + paramInt;
  }
  
  public static int zzc(int paramInt, boolean paramBoolean) {
    return zzr(paramInt) + 1;
  }
  
  public static int zzc(zzdo paramzzdo) {
    int i = paramzzdo.zzas();
    return zzt(i) + i;
  }
  
  public static zzbn zzc(byte[] paramArrayOfbyte) {
    return new zza(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public static int zzd(int paramInt, long paramLong) {
    return zzr(paramInt) + zzf(paramLong);
  }
  
  public static int zzd(int paramInt, zzbb paramzzbb) {
    return (zzr(1) << 1) + zzh(2, paramInt) + zzc(3, paramzzbb);
  }
  
  public static int zzd(int paramInt, zzdo paramzzdo) {
    return (zzr(1) << 1) + zzh(2, paramInt) + zzc(3, paramzzdo);
  }
  
  @Deprecated
  public static int zzd(zzdo paramzzdo) {
    return paramzzdo.zzas();
  }
  
  public static int zzd(byte[] paramArrayOfbyte) {
    int i = paramArrayOfbyte.length;
    return zzt(i) + i;
  }
  
  public static int zze(int paramInt, long paramLong) {
    return zzr(paramInt) + zzf(paramLong);
  }
  
  public static int zze(long paramLong) {
    return zzf(paramLong);
  }
  
  public static int zzf(int paramInt, long paramLong) {
    return zzr(paramInt) + zzf(zzj(paramLong));
  }
  
  public static int zzf(long paramLong) {
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
  
  public static int zzg(int paramInt1, int paramInt2) {
    return zzr(paramInt1) + zzs(paramInt2);
  }
  
  public static int zzg(int paramInt, long paramLong) {
    return zzr(paramInt) + 8;
  }
  
  public static int zzg(long paramLong) {
    return zzf(zzj(paramLong));
  }
  
  public static int zzh(int paramInt1, int paramInt2) {
    return zzr(paramInt1) + zzt(paramInt2);
  }
  
  public static int zzh(int paramInt, long paramLong) {
    return zzr(paramInt) + 8;
  }
  
  public static int zzh(long paramLong) {
    return 8;
  }
  
  public static int zzh(String paramString) {
    int i;
    try {
      i = zzff.zza(paramString);
    } catch (zzfi zzfi) {
      i = (paramString.getBytes(zzci.UTF_8)).length;
    } 
    return zzt(i) + i;
  }
  
  public static int zzi(int paramInt1, int paramInt2) {
    return zzr(paramInt1) + zzt(zzy(paramInt2));
  }
  
  public static int zzi(long paramLong) {
    return 8;
  }
  
  public static int zzj(int paramInt1, int paramInt2) {
    return zzr(paramInt1) + 4;
  }
  
  private static long zzj(long paramLong) {
    return paramLong >> 63L ^ paramLong << 1L;
  }
  
  public static int zzk(int paramInt1, int paramInt2) {
    return zzr(paramInt1) + 4;
  }
  
  public static int zzl(int paramInt1, int paramInt2) {
    return zzr(paramInt1) + zzs(paramInt2);
  }
  
  public static int zzr(int paramInt) {
    return zzt(paramInt << 3);
  }
  
  public static int zzs(int paramInt) {
    return (paramInt >= 0) ? zzt(paramInt) : 10;
  }
  
  public static int zzt(int paramInt) {
    return ((paramInt & 0xFFFFFF80) == 0) ? 1 : (((paramInt & 0xFFFFC000) == 0) ? 2 : (((0xFFE00000 & paramInt) == 0) ? 3 : (((paramInt & 0xF0000000) == 0) ? 4 : 5)));
  }
  
  public static int zzu(int paramInt) {
    return zzt(zzy(paramInt));
  }
  
  public static int zzv(int paramInt) {
    return 4;
  }
  
  public static int zzw(int paramInt) {
    return 4;
  }
  
  public static int zzx(int paramInt) {
    return zzs(paramInt);
  }
  
  private static int zzy(int paramInt) {
    return paramInt >> 31 ^ paramInt << 1;
  }
  
  @Deprecated
  public static int zzz(int paramInt) {
    return zzt(paramInt);
  }
  
  public abstract void flush() throws IOException;
  
  public abstract void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException;
  
  public abstract void zza(byte paramByte) throws IOException;
  
  public final void zza(double paramDouble) throws IOException {
    zzd(Double.doubleToRawLongBits(paramDouble));
  }
  
  public final void zza(float paramFloat) throws IOException {
    zzq(Float.floatToRawIntBits(paramFloat));
  }
  
  public final void zza(int paramInt, double paramDouble) throws IOException {
    zzc(paramInt, Double.doubleToRawLongBits(paramDouble));
  }
  
  public final void zza(int paramInt, float paramFloat) throws IOException {
    zzf(paramInt, Float.floatToRawIntBits(paramFloat));
  }
  
  public abstract void zza(int paramInt, long paramLong) throws IOException;
  
  public abstract void zza(int paramInt, zzbb paramzzbb) throws IOException;
  
  public abstract void zza(int paramInt, zzdo paramzzdo) throws IOException;
  
  abstract void zza(int paramInt, zzdo paramzzdo, zzef paramzzef) throws IOException;
  
  public abstract void zza(int paramInt, String paramString) throws IOException;
  
  public abstract void zza(zzbb paramzzbb) throws IOException;
  
  abstract void zza(zzdo paramzzdo, zzef paramzzef) throws IOException;
  
  final void zza(String paramString, zzfi paramzzfi) throws IOException {
    logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", paramzzfi);
    byte[] arrayOfByte = paramString.getBytes(zzci.UTF_8);
    try {
      zzo(arrayOfByte.length);
      zza(arrayOfByte, 0, arrayOfByte.length);
      return;
    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
      throw new zzc(indexOutOfBoundsException);
    } catch (zzc zzc) {
      throw zzc;
    } 
  }
  
  public final void zza(boolean paramBoolean) throws IOException {
    zza((byte)paramBoolean);
  }
  
  public abstract int zzag();
  
  public abstract void zzb(int paramInt1, int paramInt2) throws IOException;
  
  public final void zzb(int paramInt, long paramLong) throws IOException {
    zza(paramInt, zzj(paramLong));
  }
  
  public abstract void zzb(int paramInt, zzbb paramzzbb) throws IOException;
  
  public abstract void zzb(int paramInt, zzdo paramzzdo) throws IOException;
  
  public abstract void zzb(int paramInt, boolean paramBoolean) throws IOException;
  
  public abstract void zzb(long paramLong) throws IOException;
  
  public abstract void zzb(zzdo paramzzdo) throws IOException;
  
  public abstract void zzc(int paramInt1, int paramInt2) throws IOException;
  
  public abstract void zzc(int paramInt, long paramLong) throws IOException;
  
  public final void zzc(long paramLong) throws IOException {
    zzb(zzj(paramLong));
  }
  
  public abstract void zzd(int paramInt1, int paramInt2) throws IOException;
  
  public abstract void zzd(long paramLong) throws IOException;
  
  abstract void zzd(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException;
  
  public final void zze(int paramInt1, int paramInt2) throws IOException {
    zzd(paramInt1, zzy(paramInt2));
  }
  
  public abstract void zzf(int paramInt1, int paramInt2) throws IOException;
  
  public abstract void zzg(String paramString) throws IOException;
  
  public abstract void zzn(int paramInt) throws IOException;
  
  public abstract void zzo(int paramInt) throws IOException;
  
  public final void zzp(int paramInt) throws IOException {
    zzo(zzy(paramInt));
  }
  
  public abstract void zzq(int paramInt) throws IOException;
  
  static class zza extends zzbn {
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
        throw new zzbn.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(param1Int2) }), indexOutOfBoundsException);
      } 
    }
    
    public final void zza(byte param1Byte) throws IOException {
      try {
        byte[] arrayOfByte = this.buffer;
        int i = this.position;
        this.position = i + 1;
        arrayOfByte[i] = (byte)param1Byte;
        return;
      } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        throw new zzbn.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), indexOutOfBoundsException);
      } 
    }
    
    public final void zza(int param1Int, long param1Long) throws IOException {
      super.zzb(param1Int, 0);
      super.zzb(param1Long);
    }
    
    public final void zza(int param1Int, zzbb param1zzbb) throws IOException {
      super.zzb(param1Int, 2);
      super.zza(param1zzbb);
    }
    
    public final void zza(int param1Int, zzdo param1zzdo) throws IOException {
      super.zzb(param1Int, 2);
      super.zzb(param1zzdo);
    }
    
    final void zza(int param1Int, zzdo param1zzdo, zzef<zzas> param1zzef) throws IOException {
      super.zzb(param1Int, 2);
      zzas zzas = (zzas)param1zzdo;
      int i = zzas.zzs();
      param1Int = i;
      if (i == -1) {
        param1Int = param1zzef.zzm(zzas);
        zzas.zzf(param1Int);
      } 
      super.zzo(param1Int);
      param1zzef.zza(param1zzdo, this.zzfz);
    }
    
    public final void zza(int param1Int, String param1String) throws IOException {
      super.zzb(param1Int, 2);
      super.zzg(param1String);
    }
    
    public final void zza(zzbb param1zzbb) throws IOException {
      super.zzo(param1zzbb.size());
      param1zzbb.zza(this);
    }
    
    final void zza(zzdo param1zzdo, zzef<zzas> param1zzef) throws IOException {
      zzas zzas = (zzas)param1zzdo;
      int i = zzas.zzs();
      int j = i;
      if (i == -1) {
        j = param1zzef.zzm(zzas);
        zzas.zzf(j);
      } 
      super.zzo(j);
      param1zzef.zza(param1zzdo, this.zzfz);
    }
    
    public final void zza(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      super.write(param1ArrayOfbyte, param1Int1, param1Int2);
    }
    
    public final int zzag() {
      return this.limit - this.position;
    }
    
    public final int zzai() {
      return this.position - this.offset;
    }
    
    public final void zzb(int param1Int1, int param1Int2) throws IOException {
      super.zzo(param1Int1 << 3 | param1Int2);
    }
    
    public final void zzb(int param1Int, zzbb param1zzbb) throws IOException {
      super.zzb(1, 3);
      super.zzd(2, param1Int);
      super.zza(3, param1zzbb);
      super.zzb(1, 4);
    }
    
    public final void zzb(int param1Int, zzdo param1zzdo) throws IOException {
      super.zzb(1, 3);
      super.zzd(2, param1Int);
      super.zza(3, param1zzdo);
      super.zzb(1, 4);
    }
    
    public final void zzb(int param1Int, boolean param1Boolean) throws IOException {
      super.zzb(param1Int, 0);
      super.zza((byte)param1Boolean);
    }
    
    public final void zzb(long param1Long) throws IOException {
      long l = param1Long;
      if (zzbn.zzah()) {
        l = param1Long;
        if (super.zzag() >= 10)
          while (true) {
            if ((param1Long & 0xFFFFFFFFFFFFFF80L) == 0L) {
              byte[] arrayOfByte1 = this.buffer;
              int j = this.position;
              this.position = j + 1;
              zzfd.zza(arrayOfByte1, j, (byte)(int)param1Long);
              return;
            } 
            byte[] arrayOfByte = this.buffer;
            int i = this.position;
            this.position = i + 1;
            zzfd.zza(arrayOfByte, i, (byte)((int)param1Long & 0x7F | 0x80));
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
            throw new zzbn.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), indexOutOfBoundsException);
          }  
        byte[] arrayOfByte = this.buffer;
        int i = this.position;
        this.position = i + 1;
        arrayOfByte[i] = (byte)(byte)((int)l & 0x7F | 0x80);
        l >>>= 7L;
      } 
    }
    
    public final void zzb(zzdo param1zzdo) throws IOException {
      super.zzo(param1zzdo.zzas());
      param1zzdo.zzb(this);
    }
    
    public final void zzc(int param1Int1, int param1Int2) throws IOException {
      super.zzb(param1Int1, 0);
      super.zzn(param1Int2);
    }
    
    public final void zzc(int param1Int, long param1Long) throws IOException {
      super.zzb(param1Int, 1);
      super.zzd(param1Long);
    }
    
    public final void zzd(int param1Int1, int param1Int2) throws IOException {
      super.zzb(param1Int1, 0);
      super.zzo(param1Int2);
    }
    
    public final void zzd(long param1Long) throws IOException {
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
        throw new zzbn.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), indexOutOfBoundsException);
      } 
    }
    
    public final void zzd(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      super.zzo(param1Int2);
      super.write(param1ArrayOfbyte, 0, param1Int2);
    }
    
    public final void zzf(int param1Int1, int param1Int2) throws IOException {
      super.zzb(param1Int1, 5);
      super.zzq(param1Int2);
    }
    
    public final void zzg(String param1String) throws IOException {
      int i = this.position;
      try {
        int j = zzt(param1String.length() * 3);
        int k = zzt(param1String.length());
        if (k == j) {
          this.position = i + k;
          j = zzff.zza(param1String, this.buffer, this.position, super.zzag());
          this.position = i;
          super.zzo(j - i - k);
          this.position = j;
          return;
        } 
        super.zzo(zzff.zza(param1String));
        this.position = zzff.zza(param1String, this.buffer, this.position, super.zzag());
        return;
      } catch (zzfi zzfi) {
        this.position = i;
        zza(param1String, zzfi);
        return;
      } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        throw new zzbn.zzc(indexOutOfBoundsException);
      } 
    }
    
    public final void zzn(int param1Int) throws IOException {
      if (param1Int >= 0) {
        super.zzo(param1Int);
        return;
      } 
      super.zzb(param1Int);
    }
    
    public final void zzo(int param1Int) throws IOException {
      int i = param1Int;
      if (zzbn.zzah()) {
        i = param1Int;
        if (super.zzag() >= 10)
          while (true) {
            if ((param1Int & 0xFFFFFF80) == 0) {
              byte[] arrayOfByte1 = this.buffer;
              i = this.position;
              this.position = i + 1;
              zzfd.zza(arrayOfByte1, i, (byte)param1Int);
              return;
            } 
            byte[] arrayOfByte = this.buffer;
            i = this.position;
            this.position = i + 1;
            zzfd.zza(arrayOfByte, i, (byte)(param1Int & 0x7F | 0x80));
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
            throw new zzbn.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), indexOutOfBoundsException);
          }  
        byte[] arrayOfByte = this.buffer;
        param1Int = this.position;
        this.position = param1Int + 1;
        arrayOfByte[param1Int] = (byte)(byte)(i & 0x7F | 0x80);
        i >>>= 7;
      } 
    }
    
    public final void zzq(int param1Int) throws IOException {
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
        arrayOfByte[i] = (byte)(param1Int >> 24);
        return;
      } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        throw new zzbn.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1) }), indexOutOfBoundsException);
      } 
    }
  }
  
  static final class zzb extends zza {
    private final ByteBuffer zzga;
    
    private int zzgb;
    
    zzb(ByteBuffer param1ByteBuffer) {
      super(param1ByteBuffer.array(), param1ByteBuffer.arrayOffset() + param1ByteBuffer.position(), param1ByteBuffer.remaining());
      this.zzga = param1ByteBuffer;
      this.zzgb = param1ByteBuffer.position();
    }
    
    public final void flush() {
      this.zzga.position(this.zzgb + zzai());
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
  
  static final class zzd extends zzbn {
    private final int zzgb;
    
    private final ByteBuffer zzgc;
    
    private final ByteBuffer zzgd;
    
    zzd(ByteBuffer param1ByteBuffer) {
      super(null);
      this.zzgc = param1ByteBuffer;
      this.zzgd = param1ByteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
      this.zzgb = param1ByteBuffer.position();
    }
    
    private final void zzi(String param1String) throws IOException {
      try {
        zzff.zza(param1String, this.zzgd);
        return;
      } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        throw new zzbn.zzc(indexOutOfBoundsException);
      } 
    }
    
    public final void flush() {
      this.zzgc.position(this.zzgd.position());
    }
    
    public final void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      try {
        this.zzgd.put(param1ArrayOfbyte, param1Int1, param1Int2);
        return;
      } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        throw new zzbn.zzc(indexOutOfBoundsException);
      } catch (BufferOverflowException bufferOverflowException) {
        throw new zzbn.zzc(bufferOverflowException);
      } 
    }
    
    public final void zza(byte param1Byte) throws IOException {
      try {
        this.zzgd.put(param1Byte);
        return;
      } catch (BufferOverflowException bufferOverflowException) {
        throw new zzbn.zzc(bufferOverflowException);
      } 
    }
    
    public final void zza(int param1Int, long param1Long) throws IOException {
      super.zzb(param1Int, 0);
      super.zzb(param1Long);
    }
    
    public final void zza(int param1Int, zzbb param1zzbb) throws IOException {
      super.zzb(param1Int, 2);
      super.zza(param1zzbb);
    }
    
    public final void zza(int param1Int, zzdo param1zzdo) throws IOException {
      super.zzb(param1Int, 2);
      super.zzb(param1zzdo);
    }
    
    final void zza(int param1Int, zzdo param1zzdo, zzef param1zzef) throws IOException {
      super.zzb(param1Int, 2);
      super.zza(param1zzdo, param1zzef);
    }
    
    public final void zza(int param1Int, String param1String) throws IOException {
      super.zzb(param1Int, 2);
      super.zzg(param1String);
    }
    
    public final void zza(zzbb param1zzbb) throws IOException {
      super.zzo(param1zzbb.size());
      param1zzbb.zza(this);
    }
    
    final void zza(zzdo param1zzdo, zzef<zzas> param1zzef) throws IOException {
      zzas zzas = (zzas)param1zzdo;
      int i = zzas.zzs();
      int j = i;
      if (i == -1) {
        j = param1zzef.zzm(zzas);
        zzas.zzf(j);
      } 
      super.zzo(j);
      param1zzef.zza(param1zzdo, this.zzfz);
    }
    
    public final void zza(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      super.write(param1ArrayOfbyte, param1Int1, param1Int2);
    }
    
    public final int zzag() {
      return this.zzgd.remaining();
    }
    
    public final void zzb(int param1Int1, int param1Int2) throws IOException {
      super.zzo(param1Int1 << 3 | param1Int2);
    }
    
    public final void zzb(int param1Int, zzbb param1zzbb) throws IOException {
      super.zzb(1, 3);
      super.zzd(2, param1Int);
      super.zza(3, param1zzbb);
      super.zzb(1, 4);
    }
    
    public final void zzb(int param1Int, zzdo param1zzdo) throws IOException {
      super.zzb(1, 3);
      super.zzd(2, param1Int);
      super.zza(3, param1zzdo);
      super.zzb(1, 4);
    }
    
    public final void zzb(int param1Int, boolean param1Boolean) throws IOException {
      super.zzb(param1Int, 0);
      super.zza((byte)param1Boolean);
    }
    
    public final void zzb(long param1Long) throws IOException {
      while (true) {
        if ((0xFFFFFFFFFFFFFF80L & param1Long) == 0L)
          try {
            this.zzgd.put((byte)(int)param1Long);
            return;
          } catch (BufferOverflowException bufferOverflowException) {
            throw new zzbn.zzc(bufferOverflowException);
          }  
        this.zzgd.put((byte)((int)param1Long & 0x7F | 0x80));
        param1Long >>>= 7L;
      } 
    }
    
    public final void zzb(zzdo param1zzdo) throws IOException {
      super.zzo(param1zzdo.zzas());
      param1zzdo.zzb(this);
    }
    
    public final void zzc(int param1Int1, int param1Int2) throws IOException {
      super.zzb(param1Int1, 0);
      super.zzn(param1Int2);
    }
    
    public final void zzc(int param1Int, long param1Long) throws IOException {
      super.zzb(param1Int, 1);
      super.zzd(param1Long);
    }
    
    public final void zzd(int param1Int1, int param1Int2) throws IOException {
      super.zzb(param1Int1, 0);
      super.zzo(param1Int2);
    }
    
    public final void zzd(long param1Long) throws IOException {
      try {
        this.zzgd.putLong(param1Long);
        return;
      } catch (BufferOverflowException bufferOverflowException) {
        throw new zzbn.zzc(bufferOverflowException);
      } 
    }
    
    public final void zzd(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      super.zzo(param1Int2);
      super.write(param1ArrayOfbyte, 0, param1Int2);
    }
    
    public final void zzf(int param1Int1, int param1Int2) throws IOException {
      super.zzb(param1Int1, 5);
      super.zzq(param1Int2);
    }
    
    public final void zzg(String param1String) throws IOException {
      int i = this.zzgd.position();
      try {
        int j = zzt(param1String.length() * 3);
        int k = zzt(param1String.length());
        if (k == j) {
          j = this.zzgd.position() + k;
          this.zzgd.position(j);
          zzi(param1String);
          k = this.zzgd.position();
          this.zzgd.position(i);
          super.zzo(k - j);
          this.zzgd.position(k);
          return;
        } 
        super.zzo(zzff.zza(param1String));
        zzi(param1String);
        return;
      } catch (zzfi zzfi) {
        this.zzgd.position(i);
        zza(param1String, zzfi);
        return;
      } catch (IllegalArgumentException illegalArgumentException) {
        throw new zzbn.zzc(illegalArgumentException);
      } 
    }
    
    public final void zzn(int param1Int) throws IOException {
      if (param1Int >= 0) {
        super.zzo(param1Int);
        return;
      } 
      super.zzb(param1Int);
    }
    
    public final void zzo(int param1Int) throws IOException {
      while (true) {
        if ((param1Int & 0xFFFFFF80) == 0)
          try {
            this.zzgd.put((byte)param1Int);
            return;
          } catch (BufferOverflowException bufferOverflowException) {
            throw new zzbn.zzc(bufferOverflowException);
          }  
        this.zzgd.put((byte)(param1Int & 0x7F | 0x80));
        param1Int >>>= 7;
      } 
    }
    
    public final void zzq(int param1Int) throws IOException {
      try {
        this.zzgd.putInt(param1Int);
        return;
      } catch (BufferOverflowException bufferOverflowException) {
        throw new zzbn.zzc(bufferOverflowException);
      } 
    }
  }
  
  static final class zze extends zzbn {
    private final ByteBuffer zzgc;
    
    private final ByteBuffer zzgd;
    
    private final long zzge;
    
    private final long zzgf;
    
    private final long zzgg;
    
    private final long zzgh;
    
    private long zzgi;
    
    zze(ByteBuffer param1ByteBuffer) {
      super(null);
      this.zzgc = param1ByteBuffer;
      this.zzgd = param1ByteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
      this.zzge = zzfd.zzb(param1ByteBuffer);
      this.zzgf = this.zzge + param1ByteBuffer.position();
      this.zzgg = this.zzge + param1ByteBuffer.limit();
      this.zzgh = this.zzgg - 10L;
      this.zzgi = this.zzgf;
    }
    
    private final void zzk(long param1Long) {
      this.zzgd.position((int)(param1Long - this.zzge));
    }
    
    public final void flush() {
      this.zzgc.position((int)(this.zzgi - this.zzge));
    }
    
    public final void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      if (param1ArrayOfbyte != null && param1Int1 >= 0 && param1Int2 >= 0 && param1ArrayOfbyte.length - param1Int2 >= param1Int1) {
        long l1 = this.zzgg;
        long l2 = param1Int2;
        long l3 = this.zzgi;
        if (l1 - l2 >= l3) {
          zzfd.zza(param1ArrayOfbyte, param1Int1, l3, l2);
          this.zzgi += l2;
          return;
        } 
      } 
      if (param1ArrayOfbyte == null)
        throw new NullPointerException("value"); 
      throw new zzbn.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Long.valueOf(this.zzgi), Long.valueOf(this.zzgg), Integer.valueOf(param1Int2) }));
    }
    
    public final void zza(byte param1Byte) throws IOException {
      long l = this.zzgi;
      if (l < this.zzgg) {
        this.zzgi = 1L + l;
        zzfd.zza(l, param1Byte);
        return;
      } 
      throw new zzbn.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Long.valueOf(l), Long.valueOf(this.zzgg), Integer.valueOf(1) }));
    }
    
    public final void zza(int param1Int, long param1Long) throws IOException {
      super.zzb(param1Int, 0);
      super.zzb(param1Long);
    }
    
    public final void zza(int param1Int, zzbb param1zzbb) throws IOException {
      super.zzb(param1Int, 2);
      super.zza(param1zzbb);
    }
    
    public final void zza(int param1Int, zzdo param1zzdo) throws IOException {
      super.zzb(param1Int, 2);
      super.zzb(param1zzdo);
    }
    
    final void zza(int param1Int, zzdo param1zzdo, zzef param1zzef) throws IOException {
      super.zzb(param1Int, 2);
      super.zza(param1zzdo, param1zzef);
    }
    
    public final void zza(int param1Int, String param1String) throws IOException {
      super.zzb(param1Int, 2);
      super.zzg(param1String);
    }
    
    public final void zza(zzbb param1zzbb) throws IOException {
      super.zzo(param1zzbb.size());
      param1zzbb.zza(this);
    }
    
    final void zza(zzdo param1zzdo, zzef<zzas> param1zzef) throws IOException {
      zzas zzas = (zzas)param1zzdo;
      int i = zzas.zzs();
      int j = i;
      if (i == -1) {
        j = param1zzef.zzm(zzas);
        zzas.zzf(j);
      } 
      super.zzo(j);
      param1zzef.zza(param1zzdo, this.zzfz);
    }
    
    public final void zza(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      super.write(param1ArrayOfbyte, param1Int1, param1Int2);
    }
    
    public final int zzag() {
      return (int)(this.zzgg - this.zzgi);
    }
    
    public final void zzb(int param1Int1, int param1Int2) throws IOException {
      super.zzo(param1Int1 << 3 | param1Int2);
    }
    
    public final void zzb(int param1Int, zzbb param1zzbb) throws IOException {
      super.zzb(1, 3);
      super.zzd(2, param1Int);
      super.zza(3, param1zzbb);
      super.zzb(1, 4);
    }
    
    public final void zzb(int param1Int, zzdo param1zzdo) throws IOException {
      super.zzb(1, 3);
      super.zzd(2, param1Int);
      super.zza(3, param1zzdo);
      super.zzb(1, 4);
    }
    
    public final void zzb(int param1Int, boolean param1Boolean) throws IOException {
      super.zzb(param1Int, 0);
      super.zza((byte)param1Boolean);
    }
    
    public final void zzb(long param1Long) throws IOException {
      long l = param1Long;
      if (this.zzgi <= this.zzgh)
        while (true) {
          long l1;
          if ((param1Long & 0xFFFFFFFFFFFFFF80L) == 0L) {
            l1 = this.zzgi;
          } else {
            l = this.zzgi;
            this.zzgi = l + 1L;
            zzfd.zza(l, (byte)((int)param1Long & 0x7F | 0x80));
            param1Long >>>= 7L;
            continue;
          } 
          this.zzgi = 1L + l1;
          zzfd.zza(l1, (byte)(int)param1Long);
          return;
        }  
      while (true) {
        long l1 = this.zzgi;
        if (l1 < this.zzgg) {
          if ((l & 0xFFFFFFFFFFFFFF80L) == 0L) {
            param1Long = l;
          } else {
            this.zzgi = l1 + 1L;
            zzfd.zza(l1, (byte)((int)l & 0x7F | 0x80));
            l >>>= 7L;
            continue;
          } 
        } else {
          throw new zzbn.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Long.valueOf(l1), Long.valueOf(this.zzgg), Integer.valueOf(1) }));
        } 
        this.zzgi = 1L + l1;
        zzfd.zza(l1, (byte)(int)param1Long);
        return;
      } 
    }
    
    public final void zzb(zzdo param1zzdo) throws IOException {
      super.zzo(param1zzdo.zzas());
      param1zzdo.zzb(this);
    }
    
    public final void zzc(int param1Int1, int param1Int2) throws IOException {
      super.zzb(param1Int1, 0);
      super.zzn(param1Int2);
    }
    
    public final void zzc(int param1Int, long param1Long) throws IOException {
      super.zzb(param1Int, 1);
      super.zzd(param1Long);
    }
    
    public final void zzd(int param1Int1, int param1Int2) throws IOException {
      super.zzb(param1Int1, 0);
      super.zzo(param1Int2);
    }
    
    public final void zzd(long param1Long) throws IOException {
      this.zzgd.putLong((int)(this.zzgi - this.zzge), param1Long);
      this.zzgi += 8L;
    }
    
    public final void zzd(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      super.zzo(param1Int2);
      super.write(param1ArrayOfbyte, 0, param1Int2);
    }
    
    public final void zzf(int param1Int1, int param1Int2) throws IOException {
      super.zzb(param1Int1, 5);
      super.zzq(param1Int2);
    }
    
    public final void zzg(String param1String) throws IOException {
      long l = this.zzgi;
      try {
        int i = zzt(param1String.length() * 3);
        int j = zzt(param1String.length());
        if (j == i) {
          j = (int)(this.zzgi - this.zzge) + j;
          this.zzgd.position(j);
          zzff.zza(param1String, this.zzgd);
          j = this.zzgd.position() - j;
          super.zzo(j);
          this.zzgi += j;
          return;
        } 
        j = zzff.zza(param1String);
        super.zzo(j);
        zzk(this.zzgi);
        zzff.zza(param1String, this.zzgd);
        this.zzgi += j;
        return;
      } catch (zzfi zzfi) {
        this.zzgi = l;
        zzk(this.zzgi);
        zza(param1String, zzfi);
        return;
      } catch (IllegalArgumentException illegalArgumentException) {
        throw new zzbn.zzc(illegalArgumentException);
      } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        throw new zzbn.zzc(indexOutOfBoundsException);
      } 
    }
    
    public final void zzn(int param1Int) throws IOException {
      if (param1Int >= 0) {
        super.zzo(param1Int);
        return;
      } 
      super.zzb(param1Int);
    }
    
    public final void zzo(int param1Int) throws IOException {
      int i = param1Int;
      if (this.zzgi <= this.zzgh)
        while (true) {
          long l;
          if ((param1Int & 0xFFFFFF80) == 0) {
            l = this.zzgi;
          } else {
            l = this.zzgi;
            this.zzgi = l + 1L;
            zzfd.zza(l, (byte)(param1Int & 0x7F | 0x80));
            param1Int >>>= 7;
            continue;
          } 
          this.zzgi = 1L + l;
          zzfd.zza(l, (byte)param1Int);
          return;
        }  
      while (true) {
        long l = this.zzgi;
        if (l < this.zzgg) {
          if ((i & 0xFFFFFF80) == 0) {
            param1Int = i;
          } else {
            this.zzgi = l + 1L;
            zzfd.zza(l, (byte)(i & 0x7F | 0x80));
            i >>>= 7;
            continue;
          } 
        } else {
          throw new zzbn.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Long.valueOf(l), Long.valueOf(this.zzgg), Integer.valueOf(1) }));
        } 
        this.zzgi = 1L + l;
        zzfd.zza(l, (byte)param1Int);
        return;
      } 
    }
    
    public final void zzq(int param1Int) throws IOException {
      this.zzgd.putInt((int)(this.zzgi - this.zzge), param1Int);
      this.zzgi += 4L;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzbn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */