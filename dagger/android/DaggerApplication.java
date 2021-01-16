package dagger.android;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import com.google.errorprone.annotations.ForOverride;
import javax.inject.Inject;

public abstract class DaggerApplication extends Application implements HasActivityInjector, HasFragmentInjector, HasServiceInjector, HasBroadcastReceiverInjector, HasContentProviderInjector {
  @Inject
  DispatchingAndroidInjector<Activity> activityInjector;
  
  @Inject
  DispatchingAndroidInjector<BroadcastReceiver> broadcastReceiverInjector;
  
  @Inject
  DispatchingAndroidInjector<ContentProvider> contentProviderInjector;
  
  @Inject
  DispatchingAndroidInjector<Fragment> fragmentInjector;
  
  private volatile boolean needToInject = true;
  
  @Inject
  DispatchingAndroidInjector<Service> serviceInjector;
  
  private void injectIfNecessary() {
    // Byte code:
    //   0: aload_0
    //   1: getfield needToInject : Z
    //   4: ifeq -> 58
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield needToInject : Z
    //   13: ifeq -> 48
    //   16: aload_0
    //   17: invokevirtual applicationInjector : ()Ldagger/android/AndroidInjector;
    //   20: aload_0
    //   21: invokeinterface inject : (Ljava/lang/Object;)V
    //   26: aload_0
    //   27: getfield needToInject : Z
    //   30: ifne -> 36
    //   33: goto -> 48
    //   36: new java/lang/IllegalStateException
    //   39: astore_1
    //   40: aload_1
    //   41: ldc 'The AndroidInjector returned from applicationInjector() did not inject the DaggerApplication'
    //   43: invokespecial <init> : (Ljava/lang/String;)V
    //   46: aload_1
    //   47: athrow
    //   48: aload_0
    //   49: monitorexit
    //   50: goto -> 58
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    //   58: return
    // Exception table:
    //   from	to	target	type
    //   9	33	53	finally
    //   36	48	53	finally
    //   48	50	53	finally
    //   54	56	53	finally
  }
  
  public DispatchingAndroidInjector<Activity> activityInjector() {
    return this.activityInjector;
  }
  
  @ForOverride
  protected abstract AndroidInjector<? extends DaggerApplication> applicationInjector();
  
  public DispatchingAndroidInjector<BroadcastReceiver> broadcastReceiverInjector() {
    return this.broadcastReceiverInjector;
  }
  
  public AndroidInjector<ContentProvider> contentProviderInjector() {
    injectIfNecessary();
    return this.contentProviderInjector;
  }
  
  public DispatchingAndroidInjector<Fragment> fragmentInjector() {
    return this.fragmentInjector;
  }
  
  public void onCreate() {
    super.onCreate();
    injectIfNecessary();
  }
  
  public DispatchingAndroidInjector<Service> serviceInjector() {
    return this.serviceInjector;
  }
  
  @Inject
  void setInjected() {
    this.needToInject = false;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\dagger\android\DaggerApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */