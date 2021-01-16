package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzcg<MessageType extends zzcg<MessageType, BuilderType>, BuilderType extends zzcg.zza<MessageType, BuilderType>> extends zzas<MessageType, BuilderType> {
  private static Map<Object, zzcg<?, ?>> zzjr = new ConcurrentHashMap<Object, zzcg<?, ?>>();
  
  protected zzey zzjp = zzey.zzea();
  
  private int zzjq = -1;
  
  public static <ContainingType extends zzdo, Type> zzf<ContainingType, Type> zza(ContainingType paramContainingType, Type paramType, zzdo paramzzdo, zzck<?> paramzzck, int paramInt, zzfl paramzzfl, Class paramClass) {
    return new zzf<ContainingType, Type>(paramContainingType, paramType, paramzzdo, new zze(null, 66321687, paramzzfl, false, false), paramClass);
  }
  
  private static <T extends zzcg<T, ?>> T zza(T paramT, byte[] paramArrayOfbyte) throws zzco {
    zzcg zzcg1 = (zzcg)paramT.zza(zzg.zzkg, (Object)null, (Object)null);
    try {
      zzef<zzcg> zzef = zzea.zzcm().zzp(zzcg1);
      int i = paramArrayOfbyte.length;
      zzay zzay = new zzay();
      this();
      zzef.zza(zzcg1, paramArrayOfbyte, 0, i, zzay);
      zzea.zzcm().<zzcg>zzp(zzcg1).zzc(zzcg1);
      if (zzcg1.zzex == 0)
        return (T)zzcg1; 
      RuntimeException runtimeException = new RuntimeException();
      this();
      throw runtimeException;
    } catch (IOException iOException) {
      if (iOException.getCause() instanceof zzco)
        throw (zzco)iOException.getCause(); 
      throw (new zzco(iOException.getMessage())).zzg(zzcg1);
    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
      throw zzco.zzbl().zzg(zzcg1);
    } 
  }
  
  protected static Object zza(zzdo paramzzdo, String paramString, Object[] paramArrayOfObject) {
    return new zzec(paramzzdo, paramString, paramArrayOfObject);
  }
  
  static Object zza(Method paramMethod, Object paramObject, Object... paramVarArgs) {
    try {
      return paramMethod.invoke(paramObject, paramVarArgs);
    } catch (IllegalAccessException illegalAccessException) {
      throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", illegalAccessException);
    } catch (InvocationTargetException invocationTargetException) {
      Throwable throwable = invocationTargetException.getCause();
      if (!(throwable instanceof RuntimeException)) {
        if (throwable instanceof Error)
          throw (Error)throwable; 
        throw new RuntimeException("Unexpected exception thrown by generated accessor method.", throwable);
      } 
      throw (RuntimeException)throwable;
    } 
  }
  
  protected static <T extends zzcg<?, ?>> void zza(Class<T> paramClass, T paramT) {
    zzjr.put(paramClass, (zzcg<?, ?>)paramT);
  }
  
  protected static final <T extends zzcg<T, ?>> boolean zza(T paramT, boolean paramBoolean) {
    byte b = ((Byte)paramT.zza(zzg.zzkd, (Object)null, (Object)null)).byteValue();
    return (b == 1) ? true : ((b == 0) ? false : zzea.zzcm().<T>zzp(paramT).zzo(paramT));
  }
  
  protected static zzcl zzaz() {
    return (zzcl)zzch.zzbk();
  }
  
  protected static <T extends zzcg<T, ?>> T zzb(T paramT, byte[] paramArrayOfbyte) throws zzco {
    paramArrayOfbyte = zza((byte[])paramT, paramArrayOfbyte);
    if (paramArrayOfbyte != null) {
      boolean bool1 = Boolean.TRUE.booleanValue();
      byte b = ((Byte)paramArrayOfbyte.zza(zzg.zzkd, (Object)null, (Object)null)).byteValue();
      boolean bool2 = true;
      if (b != 1)
        if (b == 0) {
          bool2 = false;
        } else {
          boolean bool = zzea.zzcm().<byte[]>zzp(paramArrayOfbyte).zzo(paramArrayOfbyte);
          bool2 = bool;
          if (bool1) {
            int i = zzg.zzke;
            if (bool) {
              byte[] arrayOfByte = paramArrayOfbyte;
            } else {
              paramT = null;
            } 
            paramArrayOfbyte.zza(i, paramT, (Object)null);
            bool2 = bool;
          } 
        }  
      if (!bool2)
        throw (new zzco((new zzew(paramArrayOfbyte)).getMessage())).zzg(paramArrayOfbyte); 
    } 
    return (T)paramArrayOfbyte;
  }
  
  protected static zzcm zzba() {
    return (zzcm)zzdc.zzbx();
  }
  
  protected static <E> zzcn<E> zzbb() {
    return zzeb.zzcn();
  }
  
  static <T extends zzcg<?, ?>> T zzc(Class<T> paramClass) {
    zzcg zzcg1 = zzjr.get(paramClass);
    zzcg zzcg2 = zzcg1;
    if (zzcg1 == null)
      try {
        Class.forName(paramClass.getName(), true, paramClass.getClassLoader());
        zzcg2 = zzjr.get(paramClass);
      } catch (ClassNotFoundException classNotFoundException) {
        throw new IllegalStateException("Class initialization cannot fail.", classNotFoundException);
      }  
    if (zzcg2 == null) {
      String str = String.valueOf(classNotFoundException.getName());
      if (str.length() != 0) {
        str = "Unable to get default instance for: ".concat(str);
      } else {
        str = new String("Unable to get default instance for: ");
      } 
      throw new IllegalStateException(str);
    } 
    return (T)zzcg2;
  }
  
  public boolean equals(Object paramObject) {
    return (this == paramObject) ? true : (!((zzcg)zza(zzg.zzki, (Object)null, (Object)null)).getClass().isInstance(paramObject) ? false : zzea.zzcm().<zzcg>zzp(this).equals(this, (zzcg)paramObject));
  }
  
  public int hashCode() {
    if (this.zzex != 0)
      return this.zzex; 
    this.zzex = zzea.zzcm().<zzcg>zzp(this).hashCode(this);
    return this.zzex;
  }
  
  public final boolean isInitialized() {
    boolean bool1 = Boolean.TRUE.booleanValue();
    byte b = ((Byte)zza(zzg.zzkd, (Object)null, (Object)null)).byteValue();
    if (b == 1)
      return true; 
    if (b == 0)
      return false; 
    boolean bool2 = zzea.zzcm().<zzcg>zzp(this).zzo(this);
    if (bool1) {
      Object object;
      int i = zzg.zzke;
      if (bool2) {
        object = this;
      } else {
        object = null;
      } 
      zza(i, object, (Object)null);
    } 
    return bool2;
  }
  
  public String toString() {
    return zzdr.zza(this, super.toString());
  }
  
  protected abstract Object zza(int paramInt, Object paramObject1, Object paramObject2);
  
  public final int zzas() {
    if (this.zzjq == -1)
      this.zzjq = zzea.zzcm().<zzcg>zzp(this).zzm(this); 
    return this.zzjq;
  }
  
  public final void zzb(zzbn paramzzbn) throws IOException {
    zzea.zzcm().zze(getClass()).zza(this, zzbp.zza(paramzzbn));
  }
  
  final void zzf(int paramInt) {
    this.zzjq = paramInt;
  }
  
  final int zzs() {
    return this.zzjq;
  }
  
  public static class zza<MessageType extends zzcg<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzat<MessageType, BuilderType> {
    private final MessageType zzjs;
    
    protected MessageType zzjt;
    
    protected boolean zzju;
    
    protected zza(MessageType param1MessageType) {
      this.zzjs = param1MessageType;
      this.zzjt = (MessageType)param1MessageType.zza(zzcg.zzg.zzkg, (Object)null, (Object)null);
      this.zzju = false;
    }
    
    private static void zza(MessageType param1MessageType1, MessageType param1MessageType2) {
      zzea.zzcm().<MessageType>zzp(param1MessageType1).zzc(param1MessageType1, param1MessageType2);
    }
    
    public final boolean isInitialized() {
      return zzcg.zza(this.zzjt, false);
    }
    
    public final BuilderType zza(MessageType param1MessageType) {
      zzbf();
      zza(this.zzjt, param1MessageType);
      return (BuilderType)this;
    }
    
    protected void zzbf() {
      if (this.zzju) {
        zzcg zzcg1 = (zzcg)this.zzjt.zza(zzcg.zzg.zzkg, (Object)null, (Object)null);
        zza((MessageType)zzcg1, this.zzjt);
        this.zzjt = (MessageType)zzcg1;
        this.zzju = false;
      } 
    }
    
    public MessageType zzbg() {
      if (this.zzju)
        return this.zzjt; 
      MessageType messageType = this.zzjt;
      zzea.zzcm().<MessageType>zzp(messageType).zzc(messageType);
      this.zzju = true;
      return this.zzjt;
    }
    
    public final MessageType zzbh() {
      zzcg zzcg1 = (zzcg)zzbi();
      boolean bool1 = Boolean.TRUE.booleanValue();
      byte b = ((Byte)zzcg1.zza(zzcg.zzg.zzkd, (Object)null, (Object)null)).byteValue();
      boolean bool2 = true;
      if (b != 1)
        if (b == 0) {
          bool2 = false;
        } else {
          boolean bool = zzea.zzcm().<zzcg>zzp(zzcg1).zzo(zzcg1);
          bool2 = bool;
          if (bool1) {
            Object object;
            int i = zzcg.zzg.zzke;
            if (bool) {
              object = zzcg1;
            } else {
              object = null;
            } 
            zzcg1.zza(i, object, (Object)null);
            bool2 = bool;
          } 
        }  
      if (bool2)
        return (MessageType)zzcg1; 
      throw new zzew(zzcg1);
    }
  }
  
  public static final class zzb<T extends zzcg<T, ?>> extends zzau<T> {
    private T zzjs;
    
    public zzb(T param1T) {
      this.zzjs = param1T;
    }
  }
  
  public static class zzc<MessageType extends zzd<MessageType, BuilderType>, BuilderType extends zzc<MessageType, BuilderType>> extends zza<MessageType, BuilderType> implements zzdq {
    protected zzc(MessageType param1MessageType) {
      super(param1MessageType);
    }
    
    protected final void zzbf() {
      if (!this.zzju)
        return; 
      super.zzbf();
      ((zzcg.zzd)this.zzjt).zzjv = (zzby<zzcg.zze>)((zzcg.zzd)this.zzjt).zzjv.clone();
    }
  }
  
  public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType extends zzc<MessageType, BuilderType>> extends zzcg<MessageType, BuilderType> implements zzdq {
    protected zzby<zzcg.zze> zzjv = zzby.zzar();
  }
  
  static final class zze implements zzca<zze> {
    final int number = 66321687;
    
    private final zzck<?> zzjw = null;
    
    final zzfl zzjx;
    
    final boolean zzjy;
    
    final boolean zzjz;
    
    zze(zzck<?> param1zzck, int param1Int, zzfl param1zzfl, boolean param1Boolean1, boolean param1Boolean2) {
      this.zzjx = param1zzfl;
      this.zzjy = false;
      this.zzjz = false;
    }
    
    public final zzdp zza(zzdp param1zzdp, zzdo param1zzdo) {
      return ((zzcg.zza<zzcg, zzdp>)param1zzdp).zza((zzcg)param1zzdo);
    }
    
    public final zzdv zza(zzdv param1zzdv1, zzdv param1zzdv2) {
      throw new UnsupportedOperationException();
    }
    
    public final zzfl zzau() {
      return this.zzjx;
    }
    
    public final zzfq zzav() {
      return this.zzjx.zzek();
    }
    
    public final boolean zzaw() {
      return false;
    }
    
    public final boolean zzax() {
      return false;
    }
    
    public final int zzc() {
      return this.number;
    }
  }
  
  public static final class zzf<ContainingType extends zzdo, Type> extends zzbr<ContainingType, Type> {
    private final Type zzdu;
    
    private final ContainingType zzka;
    
    private final zzdo zzkb;
    
    private final zzcg.zze zzkc;
    
    zzf(ContainingType param1ContainingType, Type param1Type, zzdo param1zzdo, zzcg.zze param1zze, Class param1Class) {
      if (param1ContainingType != null) {
        if (param1zze.zzjx != zzfl.zzqm || param1zzdo != null) {
          this.zzka = param1ContainingType;
          this.zzdu = param1Type;
          this.zzkb = param1zzdo;
          this.zzkc = param1zze;
          return;
        } 
        throw new IllegalArgumentException("Null messageDefaultInstance");
      } 
      throw new IllegalArgumentException("Null containingTypeDefaultInstance");
    }
  }
  
  public enum zzg {
    zzkd, zzke, zzkf, zzkg, zzkh, zzki, zzkj, zzkl, zzkm, zzko, zzkp;
    
    public static int[] values$50KLMJ33DTMIUPRFDTJMOP9FE1P6UT3FC9QMCBQ7CLN6ASJ1EHIM8JB5EDPM2PR59HKN8P949LIN8Q3FCHA6UIBEEPNMMP9R0() {
      return (int[])zzkk.clone();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzcg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */