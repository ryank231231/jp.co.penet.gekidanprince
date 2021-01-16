package dagger.android;

import android.content.BroadcastReceiver;
import dagger.MapKey;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@MapKey
@Target({ElementType.METHOD})
public @interface BroadcastReceiverKey {
  Class<? extends BroadcastReceiver> value();
}


/* Location:              Y:\classes-dex2jar.jar!\dagger\android\BroadcastReceiverKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */