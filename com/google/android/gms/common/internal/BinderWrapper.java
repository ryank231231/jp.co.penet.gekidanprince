package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;

@KeepForSdk
@KeepName
public final class BinderWrapper implements Parcelable {
  public static final Parcelable.Creator<BinderWrapper> CREATOR = new zza();
  
  private IBinder zzcz = null;
  
  public BinderWrapper() {}
  
  @KeepForSdk
  public BinderWrapper(IBinder paramIBinder) {
    this.zzcz = paramIBinder;
  }
  
  private BinderWrapper(Parcel paramParcel) {
    this.zzcz = paramParcel.readStrongBinder();
  }
  
  public final int describeContents() {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeStrongBinder(this.zzcz);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\BinderWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */