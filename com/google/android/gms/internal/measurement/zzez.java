package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzez<MessageType extends zzez<MessageType, BuilderType>, BuilderType extends zzez.zza<MessageType, BuilderType>> extends zzdg<MessageType, BuilderType> {
  private static Map<Object, zzez<?, ?>> zzagp = new ConcurrentHashMap<Object, zzez<?, ?>>();
  
  protected zzhr zzagn = zzhr.zzor();
  
  private int zzago = -1;
  
  static <T extends zzez<T, ?>> T zza(T paramT, zzeb paramzzeb, zzem paramzzem) throws zzfh {
    zzez zzez1 = (zzez)paramT.zza(zze.zzagx, (Object)null, (Object)null);
    try {
      zzgu.zznz().<zzez>zzv(zzez1).zza(zzez1, zzee.zza(paramzzeb), paramzzem);
      zzez1.zzjz();
      return (T)zzez1;
    } catch (IOException iOException) {
      if (iOException.getCause() instanceof zzfh)
        throw (zzfh)iOException.getCause(); 
      throw (new zzfh(iOException.getMessage())).zzg(zzez1);
    } catch (RuntimeException runtimeException) {
      if (runtimeException.getCause() instanceof zzfh)
        throw (zzfh)runtimeException.getCause(); 
      throw runtimeException;
    } 
  }
  
  private static <T extends zzez<T, ?>> T zza(T paramT, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, zzem paramzzem) throws zzfh {
    zzez zzez1 = (zzez)paramT.zza(zze.zzagx, (Object)null, (Object)null);
    try {
      zzgy<zzez> zzgy = zzgu.zznz().zzv(zzez1);
      zzdm zzdm = new zzdm();
      this(paramzzem);
      zzgy.zza(zzez1, paramArrayOfbyte, 0, paramInt2, zzdm);
      zzez1.zzjz();
      if (zzez1.zzabm == 0)
        return (T)zzez1; 
      RuntimeException runtimeException = new RuntimeException();
      this();
      throw runtimeException;
    } catch (IOException iOException) {
      if (iOException.getCause() instanceof zzfh)
        throw (zzfh)iOException.getCause(); 
      throw (new zzfh(iOException.getMessage())).zzg(zzez1);
    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
      throw zzfh.zzmu().zzg(zzez1);
    } 
  }
  
  protected static <T extends zzez<T, ?>> T zza(T paramT, byte[] paramArrayOfbyte, zzem paramzzem) throws zzfh {
    paramT = zza(paramT, paramArrayOfbyte, 0, paramArrayOfbyte.length, paramzzem);
    if (paramT == null || paramT.isInitialized())
      return paramT; 
    throw (new zzfh((new zzhp(paramT)).getMessage())).zzg(paramT);
  }
  
  protected static zzff zza(zzff paramzzff) {
    int i = paramzzff.size();
    if (i == 0) {
      i = 10;
    } else {
      i <<= 1;
    } 
    return paramzzff.zzav(i);
  }
  
  protected static <E> zzfg<E> zza(zzfg<E> paramzzfg) {
    int i = paramzzfg.size();
    if (i == 0) {
      i = 10;
    } else {
      i <<= 1;
    } 
    return paramzzfg.zzq(i);
  }
  
  protected static Object zza(zzgh paramzzgh, String paramString, Object[] paramArrayOfObject) {
    return new zzgw(paramzzgh, paramString, paramArrayOfObject);
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
  
  protected static <T extends zzez<?, ?>> void zza(Class<T> paramClass, T paramT) {
    zzagp.put(paramClass, (zzez<?, ?>)paramT);
  }
  
  protected static final <T extends zzez<T, ?>> boolean zza(T paramT, boolean paramBoolean) {
    byte b = ((Byte)paramT.zza(zze.zzagu, (Object)null, (Object)null)).byteValue();
    if (b == 1)
      return true; 
    if (b == 0)
      return false; 
    boolean bool = zzgu.zznz().<T>zzv(paramT).zzu(paramT);
    if (paramBoolean) {
      Object object;
      int i = zze.zzagv;
      if (bool) {
        T t = paramT;
      } else {
        object = null;
      } 
      paramT.zza(i, object, (Object)null);
    } 
    return bool;
  }
  
  static <T extends zzez<?, ?>> T zzd(Class<T> paramClass) {
    zzez<?, ?> zzez1 = zzagp.get(paramClass);
    zzez<?, ?> zzez2 = zzez1;
    if (zzez1 == null)
      try {
        Class.forName(paramClass.getName(), true, paramClass.getClassLoader());
        zzez2 = zzagp.get(paramClass);
      } catch (ClassNotFoundException classNotFoundException) {
        throw new IllegalStateException("Class initialization cannot fail.", classNotFoundException);
      }  
    zzez1 = zzez2;
    if (zzez2 == null) {
      zzez1 = (zzez)((zzez)zzhw.<zzez>zzh((Class<zzez>)classNotFoundException)).zza(zze.zzagz, (Object)null, (Object)null);
      if (zzez1 != null) {
        zzagp.put(classNotFoundException, zzez1);
      } else {
        throw new IllegalStateException();
      } 
    } 
    return (T)zzez1;
  }
  
  protected static zzff zzmi() {
    return zzfv.zznk();
  }
  
  protected static <E> zzfg<E> zzmj() {
    return zzgv.zzoa();
  }
  
  public boolean equals(Object paramObject) {
    return (this == paramObject) ? true : (!((zzez)zza(zze.zzagz, (Object)null, (Object)null)).getClass().isInstance(paramObject) ? false : zzgu.zznz().<zzez>zzv(this).equals(this, (zzez)paramObject));
  }
  
  public int hashCode() {
    if (this.zzabm != 0)
      return this.zzabm; 
    this.zzabm = zzgu.zznz().<zzez>zzv(this).hashCode(this);
    return this.zzabm;
  }
  
  public final boolean isInitialized() {
    return zza(this, Boolean.TRUE.booleanValue());
  }
  
  public String toString() {
    return zzgk.zza(this, super.toString());
  }
  
  protected abstract Object zza(int paramInt, Object paramObject1, Object paramObject2);
  
  public final void zzb(zzeg paramzzeg) throws IOException {
    zzgu.zznz().zzf(getClass()).zza(this, zzei.zza(paramzzeg));
  }
  
  final int zzjw() {
    return this.zzago;
  }
  
  protected final void zzjz() {
    zzgu.zznz().<zzez>zzv(this).zzi(this);
  }
  
  public final int zzly() {
    if (this.zzago == -1)
      this.zzago = zzgu.zznz().<zzez>zzv(this).zzs(this); 
    return this.zzago;
  }
  
  protected final <MessageType extends zzez<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzmg() {
    return (BuilderType)zza(zze.zzagy, (Object)null, (Object)null);
  }
  
  public final BuilderType zzmh() {
    zza zza = (zza)zza(zze.zzagy, (Object)null, (Object)null);
    zza.zza(this);
    return (BuilderType)zza;
  }
  
  final void zzn(int paramInt) {
    this.zzago = paramInt;
  }
  
  public static class zza<MessageType extends zzez<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdh<MessageType, BuilderType> {
    private final MessageType zzagq;
    
    protected MessageType zzagr;
    
    private boolean zzags;
    
    protected zza(MessageType param1MessageType) {
      this.zzagq = param1MessageType;
      this.zzagr = (MessageType)param1MessageType.zza(zzez.zze.zzagx, (Object)null, (Object)null);
      this.zzags = false;
    }
    
    private static void zza(MessageType param1MessageType1, MessageType param1MessageType2) {
      zzgu.zznz().<MessageType>zzv(param1MessageType1).zzc(param1MessageType1, param1MessageType2);
    }
    
    public final boolean isInitialized() {
      return zzez.zza(this.zzagr, false);
    }
    
    public final BuilderType zza(MessageType param1MessageType) {
      zzmn();
      zza(this.zzagr, param1MessageType);
      return (BuilderType)this;
    }
    
    protected final void zzmn() {
      if (this.zzags) {
        zzez zzez1 = (zzez)this.zzagr.zza(zzez.zze.zzagx, (Object)null, (Object)null);
        zza((MessageType)zzez1, this.zzagr);
        this.zzagr = (MessageType)zzez1;
        this.zzags = false;
      } 
    }
    
    public MessageType zzmo() {
      if (this.zzags)
        return this.zzagr; 
      this.zzagr.zzjz();
      this.zzags = true;
      return this.zzagr;
    }
    
    public final MessageType zzmp() {
      zzez zzez1 = (zzez)zzmq();
      if (zzez1.isInitialized())
        return (MessageType)zzez1; 
      throw new zzhp(zzez1);
    }
  }
  
  public static final class zzb<T extends zzez<T, ?>> extends zzdi<T> {
    private final T zzagq;
    
    public zzb(T param1T) {
      this.zzagq = param1T;
    }
  }
  
  public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzez<MessageType, BuilderType> implements zzgj {
    protected zzeq<Object> zzagt = zzeq.zzlx();
    
    final zzeq<Object> zzms() {
      if (this.zzagt.isImmutable())
        this.zzagt = (zzeq<Object>)this.zzagt.clone(); 
      return this.zzagt;
    }
  }
  
  public static final class zzd<ContainingType extends zzgh, Type> extends zzek<ContainingType, Type> {}
  
  public enum zze {
    zzagu, zzagv, zzagw, zzagx, zzagy, zzagz, zzaha, zzahc, zzahd, zzahf, zzahg;
    
    public static int[] zzmt() {
      return (int[])zzahb.clone();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */