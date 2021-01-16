package com.google.android.gms.internal.measurement;

final class zzfy implements zzgg {
  private zzgg[] zzair;
  
  zzfy(zzgg... paramVarArgs) {
    this.zzair = paramVarArgs;
  }
  
  public final boolean zzb(Class<?> paramClass) {
    zzgg[] arrayOfZzgg = this.zzair;
    int i = arrayOfZzgg.length;
    for (byte b = 0; b < i; b++) {
      if (arrayOfZzgg[b].zzb(paramClass))
        return true; 
    } 
    return false;
  }
  
  public final zzgf zzc(Class<?> paramClass) {
    for (zzgg zzgg1 : this.zzair) {
      if (zzgg1.zzb(paramClass))
        return zzgg1.zzc(paramClass); 
    } 
    String str = String.valueOf(paramClass.getName());
    if (str.length() != 0) {
      str = "No factory is available for message type: ".concat(str);
    } else {
      str = new String("No factory is available for message type: ");
    } 
    throw new UnsupportedOperationException(str);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzfy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */