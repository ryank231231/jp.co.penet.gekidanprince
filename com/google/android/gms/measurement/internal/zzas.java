package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.atomic.AtomicReference;

public final class zzas extends zzcu {
  private static final AtomicReference<String[]> zzjm = (AtomicReference)new AtomicReference<String>();
  
  private static final AtomicReference<String[]> zzjn = (AtomicReference)new AtomicReference<String>();
  
  private static final AtomicReference<String[]> zzjo = (AtomicReference)new AtomicReference<String>();
  
  zzas(zzby paramzzby) {
    super(paramzzby);
  }
  
  @Nullable
  private static String zza(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, AtomicReference<String[]> paramAtomicReference) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_2
    //   6: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   9: pop
    //   10: aload_3
    //   11: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   14: pop
    //   15: aload_1
    //   16: arraylength
    //   17: istore #4
    //   19: aload_2
    //   20: arraylength
    //   21: istore #5
    //   23: iconst_0
    //   24: istore #6
    //   26: iload #4
    //   28: iload #5
    //   30: if_icmpne -> 39
    //   33: iconst_1
    //   34: istore #7
    //   36: goto -> 42
    //   39: iconst_0
    //   40: istore #7
    //   42: iload #7
    //   44: invokestatic checkArgument : (Z)V
    //   47: iload #6
    //   49: aload_1
    //   50: arraylength
    //   51: if_icmpge -> 177
    //   54: aload_0
    //   55: aload_1
    //   56: iload #6
    //   58: aaload
    //   59: invokestatic zzs : (Ljava/lang/String;Ljava/lang/String;)Z
    //   62: ifeq -> 171
    //   65: aload_3
    //   66: monitorenter
    //   67: aload_3
    //   68: invokevirtual get : ()Ljava/lang/Object;
    //   71: checkcast [Ljava/lang/String;
    //   74: astore #8
    //   76: aload #8
    //   78: astore_0
    //   79: aload #8
    //   81: ifnonnull -> 95
    //   84: aload_2
    //   85: arraylength
    //   86: anewarray java/lang/String
    //   89: astore_0
    //   90: aload_3
    //   91: aload_0
    //   92: invokevirtual set : (Ljava/lang/Object;)V
    //   95: aload_0
    //   96: iload #6
    //   98: aaload
    //   99: ifnonnull -> 157
    //   102: new java/lang/StringBuilder
    //   105: astore #8
    //   107: aload #8
    //   109: invokespecial <init> : ()V
    //   112: aload #8
    //   114: aload_2
    //   115: iload #6
    //   117: aaload
    //   118: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload #8
    //   124: ldc '('
    //   126: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload #8
    //   132: aload_1
    //   133: iload #6
    //   135: aaload
    //   136: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload #8
    //   142: ldc ')'
    //   144: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_0
    //   149: iload #6
    //   151: aload #8
    //   153: invokevirtual toString : ()Ljava/lang/String;
    //   156: aastore
    //   157: aload_0
    //   158: iload #6
    //   160: aaload
    //   161: astore_0
    //   162: aload_3
    //   163: monitorexit
    //   164: aload_0
    //   165: areturn
    //   166: astore_0
    //   167: aload_3
    //   168: monitorexit
    //   169: aload_0
    //   170: athrow
    //   171: iinc #6, 1
    //   174: goto -> 47
    //   177: aload_0
    //   178: areturn
    // Exception table:
    //   from	to	target	type
    //   67	76	166	finally
    //   84	95	166	finally
    //   102	157	166	finally
    //   162	164	166	finally
    //   167	169	166	finally
  }
  
  @Nullable
  private final String zzb(zzag paramzzag) {
    return (paramzzag == null) ? null : (!zzcz() ? paramzzag.toString() : zzc(paramzzag.zzct()));
  }
  
  private final boolean zzcz() {
    super.zzag();
    return (this.zzl.zzel() && this.zzl.zzad().isLoggable(3));
  }
  
  @Nullable
  protected final String zza(zzae paramzzae) {
    if (paramzzae == null)
      return null; 
    if (!zzcz())
      return paramzzae.toString(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Event{appId='");
    stringBuilder.append(paramzzae.zzcf);
    stringBuilder.append("', name='");
    stringBuilder.append(zzal(paramzzae.name));
    stringBuilder.append("', params=");
    stringBuilder.append(zzb(paramzzae.zzfd));
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  protected final boolean zzak() {
    return false;
  }
  
  @Nullable
  protected final String zzal(String paramString) {
    return (paramString == null) ? null : (!zzcz() ? paramString : zza(paramString, zzcx.zzoz, zzcx.zzoy, zzjm));
  }
  
  @Nullable
  protected final String zzam(String paramString) {
    return (paramString == null) ? null : (!zzcz() ? paramString : zza(paramString, zzcy.zzpb, zzcy.zzpa, zzjn));
  }
  
  @Nullable
  protected final String zzan(String paramString) {
    if (paramString == null)
      return null; 
    if (!zzcz())
      return paramString; 
    if (paramString.startsWith("_exp_")) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("experiment_id");
      stringBuilder.append("(");
      stringBuilder.append(paramString);
      stringBuilder.append(")");
      return stringBuilder.toString();
    } 
    return zza(paramString, zzcz.zzpd, zzcz.zzpc, zzjo);
  }
  
  @Nullable
  protected final String zzb(zzaj paramzzaj) {
    if (paramzzaj == null)
      return null; 
    if (!zzcz())
      return paramzzaj.toString(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("origin=");
    stringBuilder.append(paramzzaj.origin);
    stringBuilder.append(",name=");
    stringBuilder.append(zzal(paramzzaj.name));
    stringBuilder.append(",params=");
    stringBuilder.append(zzb(paramzzaj.zzfd));
    return stringBuilder.toString();
  }
  
  @Nullable
  protected final String zzc(Bundle paramBundle) {
    if (paramBundle == null)
      return null; 
    if (!zzcz())
      return paramBundle.toString(); 
    StringBuilder stringBuilder = new StringBuilder();
    for (String str : paramBundle.keySet()) {
      if (stringBuilder.length() != 0) {
        stringBuilder.append(", ");
      } else {
        stringBuilder.append("Bundle[{");
      } 
      stringBuilder.append(zzam(str));
      stringBuilder.append("=");
      stringBuilder.append(paramBundle.get(str));
    } 
    stringBuilder.append("}]");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */