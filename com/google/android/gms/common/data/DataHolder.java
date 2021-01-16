package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.sqlite.CursorWrapper;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@KeepForSdk
@KeepName
@Class(creator = "DataHolderCreator", validate = true)
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
  @KeepForSdk
  public static final Parcelable.Creator<DataHolder> CREATOR = new zac();
  
  private static final Builder zalx = new zab(new String[0], null);
  
  private boolean mClosed = false;
  
  @VersionField(id = 1000)
  private final int zale;
  
  @Field(getter = "getColumns", id = 1)
  private final String[] zalp;
  
  private Bundle zalq;
  
  @Field(getter = "getWindows", id = 2)
  private final CursorWindow[] zalr;
  
  @Field(getter = "getStatusCode", id = 3)
  private final int zals;
  
  @Field(getter = "getMetadata", id = 4)
  private final Bundle zalt;
  
  private int[] zalu;
  
  private int zalv;
  
  private boolean zalw = true;
  
  @Constructor
  DataHolder(@Param(id = 1000) int paramInt1, @Param(id = 1) String[] paramArrayOfString, @Param(id = 2) CursorWindow[] paramArrayOfCursorWindow, @Param(id = 3) int paramInt2, @Param(id = 4) Bundle paramBundle) {
    this.zale = paramInt1;
    this.zalp = paramArrayOfString;
    this.zalr = paramArrayOfCursorWindow;
    this.zals = paramInt2;
    this.zalt = paramBundle;
  }
  
  @KeepForSdk
  public DataHolder(Cursor paramCursor, int paramInt, Bundle paramBundle) {
    this(new CursorWrapper(paramCursor), paramInt, paramBundle);
  }
  
  private DataHolder(Builder paramBuilder, int paramInt, Bundle paramBundle) {
    this(Builder.zaa(paramBuilder), zaa(paramBuilder, -1), paramInt, (Bundle)null);
  }
  
  private DataHolder(Builder paramBuilder, int paramInt1, Bundle paramBundle, int paramInt2) {
    this(Builder.zaa(paramBuilder), zaa(paramBuilder, -1), paramInt1, paramBundle);
  }
  
  private DataHolder(CursorWrapper paramCursorWrapper, int paramInt, Bundle paramBundle) {
    this(paramCursorWrapper.getColumnNames(), zaa(paramCursorWrapper), paramInt, paramBundle);
  }
  
  @KeepForSdk
  public DataHolder(String[] paramArrayOfString, CursorWindow[] paramArrayOfCursorWindow, int paramInt, Bundle paramBundle) {
    this.zale = 1;
    this.zalp = (String[])Preconditions.checkNotNull(paramArrayOfString);
    this.zalr = (CursorWindow[])Preconditions.checkNotNull(paramArrayOfCursorWindow);
    this.zals = paramInt;
    this.zalt = paramBundle;
    zaca();
  }
  
  @KeepForSdk
  public static Builder builder(String[] paramArrayOfString) {
    return new Builder(paramArrayOfString, null, null);
  }
  
  @KeepForSdk
  public static DataHolder empty(int paramInt) {
    return new DataHolder(zalx, paramInt, null);
  }
  
  private final void zaa(String paramString, int paramInt) {
    Bundle bundle = this.zalq;
    if (bundle == null || !bundle.containsKey(paramString)) {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "No such column: ".concat(paramString);
      } else {
        paramString = new String("No such column: ");
      } 
      throw new IllegalArgumentException(paramString);
    } 
    if (!isClosed()) {
      if (paramInt >= 0 && paramInt < this.zalv)
        return; 
      throw new CursorIndexOutOfBoundsException(paramInt, this.zalv);
    } 
    throw new IllegalArgumentException("Buffer is closed.");
  }
  
  private static CursorWindow[] zaa(Builder paramBuilder, int paramInt) {
    List<Map> list;
    int i = (Builder.zaa(paramBuilder)).length;
    boolean bool = false;
    if (i == 0)
      return new CursorWindow[0]; 
    if (paramInt < 0 || paramInt >= Builder.zab(paramBuilder).size()) {
      list = Builder.zab(paramBuilder);
    } else {
      list = Builder.zab(paramBuilder).subList(0, paramInt);
    } 
    int j = list.size();
    CursorWindow cursorWindow = new CursorWindow(false);
    ArrayList<CursorWindow> arrayList = new ArrayList();
    arrayList.add(cursorWindow);
    cursorWindow.setNumColumns((Builder.zaa(paramBuilder)).length);
    paramInt = 0;
    i = 0;
    while (paramInt < j) {
      CursorWindow cursorWindow1 = cursorWindow;
      try {
        IllegalArgumentException illegalArgumentException;
        CursorWindow cursorWindow3;
        StringBuilder stringBuilder;
        CursorWindow cursorWindow2;
        if (!cursorWindow.allocRow()) {
          stringBuilder = new StringBuilder();
          this(72);
          stringBuilder.append("Allocating additional cursor window for large data set (row ");
          stringBuilder.append(paramInt);
          stringBuilder.append(")");
          Log.d("DataHolder", stringBuilder.toString());
          cursorWindow = new CursorWindow();
          this(false);
          cursorWindow.setStartPosition(paramInt);
          cursorWindow.setNumColumns((Builder.zaa(paramBuilder)).length);
          arrayList.add(cursorWindow);
          cursorWindow3 = cursorWindow;
          if (!cursorWindow.allocRow()) {
            Log.e("DataHolder", "Unable to allocate row to hold data.");
            arrayList.remove(cursorWindow);
            return arrayList.<CursorWindow>toArray(new CursorWindow[arrayList.size()]);
          } 
        } 
        Map map = list.get(paramInt);
        byte b = 0;
        boolean bool1 = true;
        while (b < (Builder.zaa(paramBuilder)).length && bool1) {
          String str = Builder.zaa(paramBuilder)[b];
          Object object = map.get(str);
          if (object == null) {
            bool1 = cursorWindow3.putNull(paramInt, b);
          } else if (object instanceof String) {
            bool1 = cursorWindow3.putString((String)object, paramInt, b);
          } else if (object instanceof Long) {
            bool1 = cursorWindow3.putLong(((Long)object).longValue(), paramInt, b);
          } else if (object instanceof Integer) {
            bool1 = cursorWindow3.putLong(((Integer)object).intValue(), paramInt, b);
          } else if (object instanceof Boolean) {
            long l;
            if (((Boolean)object).booleanValue()) {
              l = 1L;
            } else {
              l = 0L;
            } 
            bool1 = cursorWindow3.putLong(l, paramInt, b);
          } else if (object instanceof byte[]) {
            bool1 = cursorWindow3.putBlob((byte[])object, paramInt, b);
          } else if (object instanceof Double) {
            bool1 = cursorWindow3.putDouble(((Double)object).doubleValue(), paramInt, b);
          } else if (object instanceof Float) {
            bool1 = cursorWindow3.putDouble(((Float)object).floatValue(), paramInt, b);
          } else {
            illegalArgumentException = new IllegalArgumentException();
            String str1 = String.valueOf(object);
            paramInt = String.valueOf(str).length();
            i = String.valueOf(str1).length();
            stringBuilder = new StringBuilder();
            this(paramInt + 32 + i);
            stringBuilder.append("Unsupported object for column ");
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(str1);
            this(stringBuilder.toString());
            throw illegalArgumentException;
          } 
          b++;
        } 
        if (!bool1) {
          if (i == 0) {
            StringBuilder stringBuilder1 = new StringBuilder();
            this(74);
            stringBuilder1.append("Couldn't populate window data for row ");
            stringBuilder1.append(paramInt);
            stringBuilder1.append(" - allocating new window.");
            Log.d("DataHolder", stringBuilder1.toString());
            stringBuilder.freeLastRow();
            cursorWindow2 = new CursorWindow();
            this(false);
            cursorWindow2.setStartPosition(paramInt);
            cursorWindow2.setNumColumns((Builder.zaa((Builder)illegalArgumentException)).length);
            arrayList.add(cursorWindow2);
            paramInt--;
            i = 1;
          } else {
            zaa zaa = new zaa();
            this("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
            throw zaa;
          } 
        } else {
          i = 0;
        } 
        paramInt++;
        cursorWindow = cursorWindow2;
      } catch (RuntimeException runtimeException) {
        i = arrayList.size();
        for (paramInt = bool; paramInt < i; paramInt++)
          ((CursorWindow)arrayList.get(paramInt)).close(); 
        throw runtimeException;
      } 
    } 
    return arrayList.<CursorWindow>toArray(new CursorWindow[arrayList.size()]);
  }
  
  private static CursorWindow[] zaa(CursorWrapper paramCursorWrapper) {
    ArrayList<CursorWindow> arrayList = new ArrayList();
    try {
      int j;
      int i = paramCursorWrapper.getCount();
      CursorWindow cursorWindow = paramCursorWrapper.getWindow();
      if (cursorWindow != null && cursorWindow.getStartPosition() == 0) {
        cursorWindow.acquireReference();
        paramCursorWrapper.setWindow(null);
        arrayList.add(cursorWindow);
        j = cursorWindow.getNumRows();
      } else {
        j = 0;
      } 
      while (j < i && paramCursorWrapper.moveToPosition(j)) {
        cursorWindow = paramCursorWrapper.getWindow();
        if (cursorWindow != null) {
          cursorWindow.acquireReference();
          paramCursorWrapper.setWindow(null);
        } else {
          cursorWindow = new CursorWindow();
          this(false);
          cursorWindow.setStartPosition(j);
          paramCursorWrapper.fillWindow(j, cursorWindow);
        } 
        if (cursorWindow.getNumRows() != 0) {
          arrayList.add(cursorWindow);
          j = cursorWindow.getStartPosition();
          int k = cursorWindow.getNumRows();
          j += k;
        } 
      } 
      return arrayList.<CursorWindow>toArray(new CursorWindow[arrayList.size()]);
    } finally {
      paramCursorWrapper.close();
    } 
  }
  
  @KeepForSdk
  public final void close() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mClosed : Z
    //   6: ifne -> 40
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield mClosed : Z
    //   14: iconst_0
    //   15: istore_1
    //   16: iload_1
    //   17: aload_0
    //   18: getfield zalr : [Landroid/database/CursorWindow;
    //   21: arraylength
    //   22: if_icmpge -> 40
    //   25: aload_0
    //   26: getfield zalr : [Landroid/database/CursorWindow;
    //   29: iload_1
    //   30: aaload
    //   31: invokevirtual close : ()V
    //   34: iinc #1, 1
    //   37: goto -> 16
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: astore_2
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_2
    //   47: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	43	finally
    //   16	34	43	finally
    //   40	42	43	finally
    //   44	46	43	finally
  }
  
  protected final void finalize() throws Throwable {
    try {
      if (this.zalw && this.zalr.length > 0 && !isClosed()) {
        close();
        String str = toString();
        int i = String.valueOf(str).length();
        StringBuilder stringBuilder = new StringBuilder();
        this(i + 178);
        stringBuilder.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
        stringBuilder.append(str);
        stringBuilder.append(")");
        Log.e("DataBuffer", stringBuilder.toString());
      } 
      return;
    } finally {
      super.finalize();
    } 
  }
  
  @KeepForSdk
  public final boolean getBoolean(String paramString, int paramInt1, int paramInt2) {
    zaa(paramString, paramInt1);
    return (Long.valueOf(this.zalr[paramInt2].getLong(paramInt1, this.zalq.getInt(paramString))).longValue() == 1L);
  }
  
  @KeepForSdk
  public final byte[] getByteArray(String paramString, int paramInt1, int paramInt2) {
    zaa(paramString, paramInt1);
    return this.zalr[paramInt2].getBlob(paramInt1, this.zalq.getInt(paramString));
  }
  
  @KeepForSdk
  public final int getCount() {
    return this.zalv;
  }
  
  @KeepForSdk
  public final int getInteger(String paramString, int paramInt1, int paramInt2) {
    zaa(paramString, paramInt1);
    return this.zalr[paramInt2].getInt(paramInt1, this.zalq.getInt(paramString));
  }
  
  @KeepForSdk
  public final long getLong(String paramString, int paramInt1, int paramInt2) {
    zaa(paramString, paramInt1);
    return this.zalr[paramInt2].getLong(paramInt1, this.zalq.getInt(paramString));
  }
  
  @KeepForSdk
  public final Bundle getMetadata() {
    return this.zalt;
  }
  
  @KeepForSdk
  public final int getStatusCode() {
    return this.zals;
  }
  
  @KeepForSdk
  public final String getString(String paramString, int paramInt1, int paramInt2) {
    zaa(paramString, paramInt1);
    return this.zalr[paramInt2].getString(paramInt1, this.zalq.getInt(paramString));
  }
  
  @KeepForSdk
  public final int getWindowIndex(int paramInt) {
    boolean bool;
    int i;
    byte b = 0;
    if (paramInt >= 0 && paramInt < this.zalv) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool);
    while (true) {
      int[] arrayOfInt = this.zalu;
      i = b;
      if (b < arrayOfInt.length) {
        if (paramInt < arrayOfInt[b]) {
          i = b - 1;
          break;
        } 
        b++;
        continue;
      } 
      break;
    } 
    paramInt = i;
    if (i == this.zalu.length)
      paramInt = i - 1; 
    return paramInt;
  }
  
  @KeepForSdk
  public final boolean hasColumn(String paramString) {
    return this.zalq.containsKey(paramString);
  }
  
  @KeepForSdk
  public final boolean hasNull(String paramString, int paramInt1, int paramInt2) {
    zaa(paramString, paramInt1);
    return this.zalr[paramInt2].isNull(paramInt1, this.zalq.getInt(paramString));
  }
  
  @KeepForSdk
  public final boolean isClosed() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mClosed : Z
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	11	finally
    //   12	14	11	finally
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeStringArray(paramParcel, 1, this.zalp, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 2, (Parcelable[])this.zalr, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, getStatusCode());
    SafeParcelWriter.writeBundle(paramParcel, 4, getMetadata(), false);
    SafeParcelWriter.writeInt(paramParcel, 1000, this.zale);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    if ((paramInt & 0x1) != 0)
      close(); 
  }
  
  public final float zaa(String paramString, int paramInt1, int paramInt2) {
    zaa(paramString, paramInt1);
    return this.zalr[paramInt2].getFloat(paramInt1, this.zalq.getInt(paramString));
  }
  
  public final void zaa(String paramString, int paramInt1, int paramInt2, CharArrayBuffer paramCharArrayBuffer) {
    zaa(paramString, paramInt1);
    this.zalr[paramInt2].copyStringToBuffer(paramInt1, this.zalq.getInt(paramString), paramCharArrayBuffer);
  }
  
  public final double zab(String paramString, int paramInt1, int paramInt2) {
    zaa(paramString, paramInt1);
    return this.zalr[paramInt2].getDouble(paramInt1, this.zalq.getInt(paramString));
  }
  
  public final void zaca() {
    this.zalq = new Bundle();
    int i = 0;
    int j = 0;
    while (true) {
      String[] arrayOfString = this.zalp;
      if (j < arrayOfString.length) {
        this.zalq.putInt(arrayOfString[j], j);
        j++;
        continue;
      } 
      this.zalu = new int[this.zalr.length];
      int k = 0;
      j = i;
      while (true) {
        CursorWindow[] arrayOfCursorWindow = this.zalr;
        if (j < arrayOfCursorWindow.length) {
          this.zalu[j] = k;
          i = arrayOfCursorWindow[j].getStartPosition();
          k += this.zalr[j].getNumRows() - k - i;
          j++;
          continue;
        } 
        this.zalv = k;
        return;
      } 
      break;
    } 
  }
  
  @KeepForSdk
  public static class Builder {
    private final String[] zalp;
    
    private final ArrayList<HashMap<String, Object>> zaly;
    
    private final String zalz;
    
    private final HashMap<Object, Integer> zama;
    
    private boolean zamb;
    
    private String zamc;
    
    private Builder(String[] param1ArrayOfString, String param1String) {
      this.zalp = (String[])Preconditions.checkNotNull(param1ArrayOfString);
      this.zaly = new ArrayList<HashMap<String, Object>>();
      this.zalz = param1String;
      this.zama = new HashMap<Object, Integer>();
      this.zamb = false;
      this.zamc = null;
    }
    
    @KeepForSdk
    public DataHolder build(int param1Int) {
      return new DataHolder(this, param1Int, null, null);
    }
    
    @KeepForSdk
    public DataHolder build(int param1Int, Bundle param1Bundle) {
      return new DataHolder(this, param1Int, param1Bundle, -1, null);
    }
    
    @KeepForSdk
    public Builder withRow(ContentValues param1ContentValues) {
      Asserts.checkNotNull(param1ContentValues);
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>(param1ContentValues.size());
      for (Map.Entry entry : param1ContentValues.valueSet())
        hashMap.put(entry.getKey(), entry.getValue()); 
      return zaa((HashMap)hashMap);
    }
    
    public Builder zaa(HashMap<String, Object> param1HashMap) {
      int i;
      Asserts.checkNotNull(param1HashMap);
      String str = this.zalz;
      if (str == null) {
        i = -1;
      } else {
        Object object = param1HashMap.get(str);
        if (object == null) {
          i = -1;
        } else {
          Integer integer = this.zama.get(object);
          if (integer == null) {
            this.zama.put(object, Integer.valueOf(this.zaly.size()));
            i = -1;
          } else {
            i = integer.intValue();
          } 
        } 
      } 
      if (i == -1) {
        this.zaly.add(param1HashMap);
      } else {
        this.zaly.remove(i);
        this.zaly.add(i, param1HashMap);
      } 
      this.zamb = false;
      return this;
    }
  }
  
  public static final class zaa extends RuntimeException {
    public zaa(String param1String) {
      super(param1String);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\data\DataHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */