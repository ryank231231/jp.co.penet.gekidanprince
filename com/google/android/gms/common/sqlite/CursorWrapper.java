package com.google.android.gms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class CursorWrapper extends CursorWrapper implements CrossProcessCursor {
  private AbstractWindowedCursor zzez;
  
  @KeepForSdk
  public CursorWrapper(Cursor paramCursor) {
    super(paramCursor);
    String str;
    for (byte b = 0; b < 10 && paramCursor instanceof CursorWrapper; b++)
      paramCursor = ((CursorWrapper)paramCursor).getWrappedCursor(); 
    if (!(paramCursor instanceof AbstractWindowedCursor)) {
      str = String.valueOf(paramCursor.getClass().getName());
      if (str.length() != 0) {
        str = "Unknown type: ".concat(str);
      } else {
        str = new String("Unknown type: ");
      } 
      throw new IllegalArgumentException(str);
    } 
    this.zzez = (AbstractWindowedCursor)str;
  }
  
  @KeepForSdk
  public void fillWindow(int paramInt, CursorWindow paramCursorWindow) {
    this.zzez.fillWindow(paramInt, paramCursorWindow);
  }
  
  @KeepForSdk
  public CursorWindow getWindow() {
    return this.zzez.getWindow();
  }
  
  public boolean onMove(int paramInt1, int paramInt2) {
    return this.zzez.onMove(paramInt1, paramInt2);
  }
  
  @KeepForSdk
  public void setWindow(CursorWindow paramCursorWindow) {
    this.zzez.setWindow(paramCursorWindow);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\sqlite\CursorWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */