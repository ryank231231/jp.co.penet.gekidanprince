package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayList;

@KeepForSdk
public abstract class EntityBuffer<T> extends AbstractDataBuffer<T> {
  private boolean zamd = false;
  
  private ArrayList<Integer> zame;
  
  @KeepForSdk
  protected EntityBuffer(DataHolder paramDataHolder) {
    super(paramDataHolder);
  }
  
  private final void zacb() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zamd : Z
    //   6: ifne -> 240
    //   9: aload_0
    //   10: getfield mDataHolder : Lcom/google/android/gms/common/data/DataHolder;
    //   13: invokevirtual getCount : ()I
    //   16: istore_1
    //   17: new java/util/ArrayList
    //   20: astore_2
    //   21: aload_2
    //   22: invokespecial <init> : ()V
    //   25: aload_0
    //   26: aload_2
    //   27: putfield zame : Ljava/util/ArrayList;
    //   30: iload_1
    //   31: ifle -> 235
    //   34: aload_0
    //   35: getfield zame : Ljava/util/ArrayList;
    //   38: iconst_0
    //   39: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   42: invokevirtual add : (Ljava/lang/Object;)Z
    //   45: pop
    //   46: aload_0
    //   47: invokevirtual getPrimaryDataMarkerColumn : ()Ljava/lang/String;
    //   50: astore_3
    //   51: aload_0
    //   52: getfield mDataHolder : Lcom/google/android/gms/common/data/DataHolder;
    //   55: iconst_0
    //   56: invokevirtual getWindowIndex : (I)I
    //   59: istore #4
    //   61: aload_0
    //   62: getfield mDataHolder : Lcom/google/android/gms/common/data/DataHolder;
    //   65: aload_3
    //   66: iconst_0
    //   67: iload #4
    //   69: invokevirtual getString : (Ljava/lang/String;II)Ljava/lang/String;
    //   72: astore #5
    //   74: iconst_1
    //   75: istore #4
    //   77: iload #4
    //   79: iload_1
    //   80: if_icmpge -> 235
    //   83: aload_0
    //   84: getfield mDataHolder : Lcom/google/android/gms/common/data/DataHolder;
    //   87: iload #4
    //   89: invokevirtual getWindowIndex : (I)I
    //   92: istore #6
    //   94: aload_0
    //   95: getfield mDataHolder : Lcom/google/android/gms/common/data/DataHolder;
    //   98: aload_3
    //   99: iload #4
    //   101: iload #6
    //   103: invokevirtual getString : (Ljava/lang/String;II)Ljava/lang/String;
    //   106: astore #7
    //   108: aload #7
    //   110: ifnull -> 151
    //   113: aload #5
    //   115: astore_2
    //   116: aload #7
    //   118: aload #5
    //   120: invokevirtual equals : (Ljava/lang/Object;)Z
    //   123: ifne -> 142
    //   126: aload_0
    //   127: getfield zame : Ljava/util/ArrayList;
    //   130: iload #4
    //   132: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   135: invokevirtual add : (Ljava/lang/Object;)Z
    //   138: pop
    //   139: aload #7
    //   141: astore_2
    //   142: iinc #4, 1
    //   145: aload_2
    //   146: astore #5
    //   148: goto -> 77
    //   151: new java/lang/NullPointerException
    //   154: astore_2
    //   155: aload_3
    //   156: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   159: invokevirtual length : ()I
    //   162: istore_1
    //   163: new java/lang/StringBuilder
    //   166: astore #5
    //   168: aload #5
    //   170: iload_1
    //   171: bipush #78
    //   173: iadd
    //   174: invokespecial <init> : (I)V
    //   177: aload #5
    //   179: ldc 'Missing value for markerColumn: '
    //   181: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload #5
    //   187: aload_3
    //   188: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload #5
    //   194: ldc ', at row: '
    //   196: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload #5
    //   202: iload #4
    //   204: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload #5
    //   210: ldc ', for window: '
    //   212: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload #5
    //   218: iload #6
    //   220: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_2
    //   225: aload #5
    //   227: invokevirtual toString : ()Ljava/lang/String;
    //   230: invokespecial <init> : (Ljava/lang/String;)V
    //   233: aload_2
    //   234: athrow
    //   235: aload_0
    //   236: iconst_1
    //   237: putfield zamd : Z
    //   240: aload_0
    //   241: monitorexit
    //   242: return
    //   243: astore_2
    //   244: aload_0
    //   245: monitorexit
    //   246: aload_2
    //   247: athrow
    // Exception table:
    //   from	to	target	type
    //   2	30	243	finally
    //   34	74	243	finally
    //   83	108	243	finally
    //   116	139	243	finally
    //   151	235	243	finally
    //   235	240	243	finally
    //   240	242	243	finally
    //   244	246	243	finally
  }
  
  private final int zah(int paramInt) {
    if (paramInt >= 0 && paramInt < this.zame.size())
      return ((Integer)this.zame.get(paramInt)).intValue(); 
    StringBuilder stringBuilder = new StringBuilder(53);
    stringBuilder.append("Position ");
    stringBuilder.append(paramInt);
    stringBuilder.append(" is out of bounds for this buffer");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  @KeepForSdk
  public final T get(int paramInt) {
    zacb();
    int i = zah(paramInt);
    byte b = 0;
    int j = b;
    if (paramInt >= 0)
      if (paramInt == this.zame.size()) {
        j = b;
      } else {
        if (paramInt == this.zame.size() - 1) {
          j = this.mDataHolder.getCount() - ((Integer)this.zame.get(paramInt)).intValue();
        } else {
          j = ((Integer)this.zame.get(paramInt + 1)).intValue() - ((Integer)this.zame.get(paramInt)).intValue();
        } 
        if (j == 1) {
          paramInt = zah(paramInt);
          int k = this.mDataHolder.getWindowIndex(paramInt);
          String str = getChildDataMarkerColumn();
          if (str != null && this.mDataHolder.getString(str, paramInt, k) == null)
            j = b; 
        } 
      }  
    return getEntry(i, j);
  }
  
  @KeepForSdk
  protected String getChildDataMarkerColumn() {
    return null;
  }
  
  @KeepForSdk
  public int getCount() {
    zacb();
    return this.zame.size();
  }
  
  @KeepForSdk
  protected abstract T getEntry(int paramInt1, int paramInt2);
  
  @KeepForSdk
  protected abstract String getPrimaryDataMarkerColumn();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\data\EntityBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */