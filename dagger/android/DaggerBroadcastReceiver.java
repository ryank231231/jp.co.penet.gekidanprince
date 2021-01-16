package dagger.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.CallSuper;

public abstract class DaggerBroadcastReceiver extends BroadcastReceiver {
  @CallSuper
  public void onReceive(Context paramContext, Intent paramIntent) {
    AndroidInjection.inject(this, paramContext);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\android\DaggerBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */