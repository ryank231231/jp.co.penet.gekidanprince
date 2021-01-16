package com.google.android.gms.internal.clearcut;

final class zzdb extends zzcy {
  private zzdb() {
    super(null);
  }
  
  private static <E> zzcn<E> zzc(Object paramObject, long paramLong) {
    return (zzcn<E>)zzfd.zzo(paramObject, paramLong);
  }
  
  final void zza(Object paramObject, long paramLong) {
    zzc(paramObject, paramLong).zzv();
  }
  
  final <E> void zza(Object paramObject1, Object<?> paramObject2, long paramLong) {
    Object<?> object;
    zzcn<?> zzcn1 = zzc(paramObject1, paramLong);
    zzcn<?> zzcn2 = zzc(paramObject2, paramLong);
    int i = zzcn1.size();
    int j = zzcn2.size();
    paramObject2 = (Object<?>)zzcn1;
    if (i > 0) {
      paramObject2 = (Object<?>)zzcn1;
      if (j > 0) {
        paramObject2 = (Object<?>)zzcn1;
        if (!zzcn1.zzu())
          paramObject2 = (Object<?>)zzcn1.zzi(j + i); 
        paramObject2.addAll(zzcn2);
      } 
    } 
    zzcn1 = zzcn2;
    if (i > 0)
      object = paramObject2; 
    zzfd.zza(paramObject1, paramLong, object);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzdb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */