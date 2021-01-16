package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Field;
import java.util.Arrays;

final class zzed {
  private final int flags;
  
  private final Object[] zzmj;
  
  private final int zzmk;
  
  private final int zzml;
  
  private final int zzmm;
  
  private final int[] zzms;
  
  private final zzee zznh;
  
  private Class<?> zzni;
  
  private final int zznj;
  
  private final int zznk;
  
  private final int zznl;
  
  private final int zznm;
  
  private final int zznn;
  
  private final int zzno;
  
  private int zznp;
  
  private int zznq;
  
  private int zznr;
  
  private int zzns;
  
  private int zznt;
  
  private int zznu;
  
  private int zznv;
  
  private int zznw;
  
  private int zznx;
  
  private int zzny;
  
  private int zznz;
  
  private int zzoa;
  
  private int zzob;
  
  private int zzoc;
  
  private Field zzod;
  
  private Object zzoe;
  
  private Object zzof;
  
  private Object zzog;
  
  zzed(Class<?> paramClass, String paramString, Object[] paramArrayOfObject) {
    int[] arrayOfInt;
    this.zznr = Integer.MAX_VALUE;
    this.zzns = Integer.MIN_VALUE;
    this.zznt = 0;
    this.zznu = 0;
    this.zznv = 0;
    this.zznw = 0;
    this.zznx = 0;
    this.zzni = paramClass;
    this.zznh = new zzee(paramString);
    this.zzmj = paramArrayOfObject;
    this.flags = this.zznh.next();
    this.zznj = this.zznh.next();
    int i = this.zznj;
    paramClass = null;
    if (i == 0) {
      this.zznk = 0;
      this.zznl = 0;
      this.zzmk = 0;
      this.zzml = 0;
      this.zznm = 0;
      this.zznn = 0;
      this.zzmm = 0;
      this.zzno = 0;
      this.zzms = null;
      return;
    } 
    this.zznk = this.zznh.next();
    this.zznl = this.zznh.next();
    this.zzmk = this.zznh.next();
    this.zzml = this.zznh.next();
    this.zznn = this.zznh.next();
    this.zzmm = this.zznh.next();
    this.zznm = this.zznh.next();
    this.zzno = this.zznh.next();
    i = this.zznh.next();
    if (i != 0)
      arrayOfInt = new int[i]; 
    this.zzms = arrayOfInt;
    this.zznp = (this.zznk << 1) + this.zznl;
  }
  
  private static Field zza(Class<?> paramClass, String paramString) {
    try {
      return paramClass.getDeclaredField(paramString);
    } catch (NoSuchFieldException noSuchFieldException) {
      for (Field field : paramClass.getDeclaredFields()) {
        if (paramString.equals(field.getName()))
          return field; 
      } 
      String str1 = paramClass.getName();
      String str2 = Arrays.toString((Object[])noSuchFieldException);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString).length() + 40 + String.valueOf(str1).length() + String.valueOf(str2).length());
      stringBuilder.append("Field ");
      stringBuilder.append(paramString);
      stringBuilder.append(" for ");
      stringBuilder.append(str1);
      stringBuilder.append(" not found. Known fields are ");
      stringBuilder.append(str2);
      throw new RuntimeException(stringBuilder.toString());
    } 
  }
  
  private final Object zzcw() {
    Object[] arrayOfObject = this.zzmj;
    int i = this.zznp;
    this.zznp = i + 1;
    return arrayOfObject[i];
  }
  
  private final boolean zzcz() {
    return ((this.flags & 0x1) == 1);
  }
  
  final boolean next() {
    // Byte code:
    //   0: aload_0
    //   1: getfield zznh : Lcom/google/android/gms/internal/clearcut/zzee;
    //   4: invokevirtual hasNext : ()Z
    //   7: istore_1
    //   8: iconst_0
    //   9: istore_2
    //   10: iload_1
    //   11: ifne -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_0
    //   17: aload_0
    //   18: getfield zznh : Lcom/google/android/gms/internal/clearcut/zzee;
    //   21: invokevirtual next : ()I
    //   24: putfield zzny : I
    //   27: aload_0
    //   28: aload_0
    //   29: getfield zznh : Lcom/google/android/gms/internal/clearcut/zzee;
    //   32: invokevirtual next : ()I
    //   35: putfield zznz : I
    //   38: aload_0
    //   39: aload_0
    //   40: getfield zznz : I
    //   43: sipush #255
    //   46: iand
    //   47: putfield zzoa : I
    //   50: aload_0
    //   51: getfield zzny : I
    //   54: istore_3
    //   55: iload_3
    //   56: aload_0
    //   57: getfield zznr : I
    //   60: if_icmpge -> 68
    //   63: aload_0
    //   64: iload_3
    //   65: putfield zznr : I
    //   68: aload_0
    //   69: getfield zzny : I
    //   72: istore_3
    //   73: iload_3
    //   74: aload_0
    //   75: getfield zzns : I
    //   78: if_icmple -> 86
    //   81: aload_0
    //   82: iload_3
    //   83: putfield zzns : I
    //   86: aload_0
    //   87: getfield zzoa : I
    //   90: getstatic com/google/android/gms/internal/clearcut/zzcb.zziw : Lcom/google/android/gms/internal/clearcut/zzcb;
    //   93: invokevirtual id : ()I
    //   96: if_icmpne -> 112
    //   99: aload_0
    //   100: aload_0
    //   101: getfield zznt : I
    //   104: iconst_1
    //   105: iadd
    //   106: putfield zznt : I
    //   109: goto -> 148
    //   112: aload_0
    //   113: getfield zzoa : I
    //   116: getstatic com/google/android/gms/internal/clearcut/zzcb.zzhq : Lcom/google/android/gms/internal/clearcut/zzcb;
    //   119: invokevirtual id : ()I
    //   122: if_icmplt -> 148
    //   125: aload_0
    //   126: getfield zzoa : I
    //   129: getstatic com/google/android/gms/internal/clearcut/zzcb.zziv : Lcom/google/android/gms/internal/clearcut/zzcb;
    //   132: invokevirtual id : ()I
    //   135: if_icmpgt -> 148
    //   138: aload_0
    //   139: aload_0
    //   140: getfield zznu : I
    //   143: iconst_1
    //   144: iadd
    //   145: putfield zznu : I
    //   148: aload_0
    //   149: aload_0
    //   150: getfield zznx : I
    //   153: iconst_1
    //   154: iadd
    //   155: putfield zznx : I
    //   158: aload_0
    //   159: getfield zznr : I
    //   162: aload_0
    //   163: getfield zzny : I
    //   166: aload_0
    //   167: getfield zznx : I
    //   170: invokestatic zzc : (III)Z
    //   173: ifeq -> 199
    //   176: aload_0
    //   177: aload_0
    //   178: getfield zzny : I
    //   181: iconst_1
    //   182: iadd
    //   183: putfield zznw : I
    //   186: aload_0
    //   187: getfield zznw : I
    //   190: aload_0
    //   191: getfield zznr : I
    //   194: isub
    //   195: istore_3
    //   196: goto -> 206
    //   199: aload_0
    //   200: getfield zznv : I
    //   203: iconst_1
    //   204: iadd
    //   205: istore_3
    //   206: aload_0
    //   207: iload_3
    //   208: putfield zznv : I
    //   211: aload_0
    //   212: getfield zznz : I
    //   215: sipush #1024
    //   218: iand
    //   219: ifeq -> 227
    //   222: iconst_1
    //   223: istore_3
    //   224: goto -> 229
    //   227: iconst_0
    //   228: istore_3
    //   229: iload_3
    //   230: ifeq -> 259
    //   233: aload_0
    //   234: getfield zzms : [I
    //   237: astore #4
    //   239: aload_0
    //   240: getfield zznq : I
    //   243: istore_3
    //   244: aload_0
    //   245: iload_3
    //   246: iconst_1
    //   247: iadd
    //   248: putfield zznq : I
    //   251: aload #4
    //   253: iload_3
    //   254: aload_0
    //   255: getfield zzny : I
    //   258: iastore
    //   259: aload_0
    //   260: aconst_null
    //   261: putfield zzoe : Ljava/lang/Object;
    //   264: aload_0
    //   265: aconst_null
    //   266: putfield zzof : Ljava/lang/Object;
    //   269: aload_0
    //   270: aconst_null
    //   271: putfield zzog : Ljava/lang/Object;
    //   274: aload_0
    //   275: invokevirtual zzda : ()Z
    //   278: ifeq -> 376
    //   281: aload_0
    //   282: aload_0
    //   283: getfield zznh : Lcom/google/android/gms/internal/clearcut/zzee;
    //   286: invokevirtual next : ()I
    //   289: putfield zzob : I
    //   292: aload_0
    //   293: getfield zzoa : I
    //   296: getstatic com/google/android/gms/internal/clearcut/zzcb.zzhh : Lcom/google/android/gms/internal/clearcut/zzcb;
    //   299: invokevirtual id : ()I
    //   302: bipush #51
    //   304: iadd
    //   305: if_icmpeq -> 361
    //   308: aload_0
    //   309: getfield zzoa : I
    //   312: getstatic com/google/android/gms/internal/clearcut/zzcb.zzhp : Lcom/google/android/gms/internal/clearcut/zzcb;
    //   315: invokevirtual id : ()I
    //   318: bipush #51
    //   320: iadd
    //   321: if_icmpne -> 327
    //   324: goto -> 361
    //   327: aload_0
    //   328: getfield zzoa : I
    //   331: getstatic com/google/android/gms/internal/clearcut/zzcb.zzhk : Lcom/google/android/gms/internal/clearcut/zzcb;
    //   334: invokevirtual id : ()I
    //   337: bipush #51
    //   339: iadd
    //   340: if_icmpne -> 577
    //   343: aload_0
    //   344: invokespecial zzcz : ()Z
    //   347: ifeq -> 577
    //   350: aload_0
    //   351: aload_0
    //   352: invokespecial zzcw : ()Ljava/lang/Object;
    //   355: putfield zzof : Ljava/lang/Object;
    //   358: goto -> 577
    //   361: aload_0
    //   362: invokespecial zzcw : ()Ljava/lang/Object;
    //   365: astore #4
    //   367: aload_0
    //   368: aload #4
    //   370: putfield zzoe : Ljava/lang/Object;
    //   373: goto -> 577
    //   376: aload_0
    //   377: aload_0
    //   378: getfield zzni : Ljava/lang/Class;
    //   381: aload_0
    //   382: invokespecial zzcw : ()Ljava/lang/Object;
    //   385: checkcast java/lang/String
    //   388: invokestatic zza : (Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   391: putfield zzod : Ljava/lang/reflect/Field;
    //   394: aload_0
    //   395: invokevirtual zzde : ()Z
    //   398: ifeq -> 412
    //   401: aload_0
    //   402: aload_0
    //   403: getfield zznh : Lcom/google/android/gms/internal/clearcut/zzee;
    //   406: invokevirtual next : ()I
    //   409: putfield zzoc : I
    //   412: aload_0
    //   413: getfield zzoa : I
    //   416: getstatic com/google/android/gms/internal/clearcut/zzcb.zzhh : Lcom/google/android/gms/internal/clearcut/zzcb;
    //   419: invokevirtual id : ()I
    //   422: if_icmpeq -> 565
    //   425: aload_0
    //   426: getfield zzoa : I
    //   429: getstatic com/google/android/gms/internal/clearcut/zzcb.zzhp : Lcom/google/android/gms/internal/clearcut/zzcb;
    //   432: invokevirtual id : ()I
    //   435: if_icmpne -> 441
    //   438: goto -> 565
    //   441: aload_0
    //   442: getfield zzoa : I
    //   445: getstatic com/google/android/gms/internal/clearcut/zzcb.zzhz : Lcom/google/android/gms/internal/clearcut/zzcb;
    //   448: invokevirtual id : ()I
    //   451: if_icmpeq -> 361
    //   454: aload_0
    //   455: getfield zzoa : I
    //   458: getstatic com/google/android/gms/internal/clearcut/zzcb.zziv : Lcom/google/android/gms/internal/clearcut/zzcb;
    //   461: invokevirtual id : ()I
    //   464: if_icmpne -> 470
    //   467: goto -> 361
    //   470: aload_0
    //   471: getfield zzoa : I
    //   474: getstatic com/google/android/gms/internal/clearcut/zzcb.zzhk : Lcom/google/android/gms/internal/clearcut/zzcb;
    //   477: invokevirtual id : ()I
    //   480: if_icmpeq -> 555
    //   483: aload_0
    //   484: getfield zzoa : I
    //   487: getstatic com/google/android/gms/internal/clearcut/zzcb.zzic : Lcom/google/android/gms/internal/clearcut/zzcb;
    //   490: invokevirtual id : ()I
    //   493: if_icmpeq -> 555
    //   496: aload_0
    //   497: getfield zzoa : I
    //   500: getstatic com/google/android/gms/internal/clearcut/zzcb.zziq : Lcom/google/android/gms/internal/clearcut/zzcb;
    //   503: invokevirtual id : ()I
    //   506: if_icmpne -> 512
    //   509: goto -> 555
    //   512: aload_0
    //   513: getfield zzoa : I
    //   516: getstatic com/google/android/gms/internal/clearcut/zzcb.zziw : Lcom/google/android/gms/internal/clearcut/zzcb;
    //   519: invokevirtual id : ()I
    //   522: if_icmpne -> 577
    //   525: aload_0
    //   526: aload_0
    //   527: invokespecial zzcw : ()Ljava/lang/Object;
    //   530: putfield zzog : Ljava/lang/Object;
    //   533: iload_2
    //   534: istore_3
    //   535: aload_0
    //   536: getfield zznz : I
    //   539: sipush #2048
    //   542: iand
    //   543: ifeq -> 548
    //   546: iconst_1
    //   547: istore_3
    //   548: iload_3
    //   549: ifeq -> 577
    //   552: goto -> 562
    //   555: aload_0
    //   556: invokespecial zzcz : ()Z
    //   559: ifeq -> 577
    //   562: goto -> 350
    //   565: aload_0
    //   566: getfield zzod : Ljava/lang/reflect/Field;
    //   569: invokevirtual getType : ()Ljava/lang/Class;
    //   572: astore #4
    //   574: goto -> 367
    //   577: iconst_1
    //   578: ireturn
  }
  
  final int zzcx() {
    return this.zzny;
  }
  
  final int zzcy() {
    return this.zzoa;
  }
  
  final boolean zzda() {
    return (this.zzoa > zzcb.zziw.id());
  }
  
  final Field zzdb() {
    int i = this.zzob << 1;
    Object object = this.zzmj[i];
    if (object instanceof Field)
      return (Field)object; 
    object = zza(this.zzni, (String)object);
    this.zzmj[i] = object;
    return (Field)object;
  }
  
  final Field zzdc() {
    int i = (this.zzob << 1) + 1;
    Object object = this.zzmj[i];
    if (object instanceof Field)
      return (Field)object; 
    object = zza(this.zzni, (String)object);
    this.zzmj[i] = object;
    return (Field)object;
  }
  
  final Field zzdd() {
    return this.zzod;
  }
  
  final boolean zzde() {
    return (zzcz() && this.zzoa <= zzcb.zzhp.id());
  }
  
  final Field zzdf() {
    int i = (this.zznk << 1) + this.zzoc / 32;
    Object object = this.zzmj[i];
    if (object instanceof Field)
      return (Field)object; 
    object = zza(this.zzni, (String)object);
    this.zzmj[i] = object;
    return (Field)object;
  }
  
  final int zzdg() {
    return this.zzoc % 32;
  }
  
  final boolean zzdh() {
    return ((this.zznz & 0x100) != 0);
  }
  
  final boolean zzdi() {
    return ((this.zznz & 0x200) != 0);
  }
  
  final Object zzdj() {
    return this.zzoe;
  }
  
  final Object zzdk() {
    return this.zzof;
  }
  
  final Object zzdl() {
    return this.zzog;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */