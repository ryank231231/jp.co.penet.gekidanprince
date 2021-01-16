package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.ForegroundNotifier;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground;
import dagger.Module;
import dagger.Provides;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.flowables.ConnectableFlowable;
import javax.inject.Singleton;

@Module
public class ForegroundFlowableModule {
  @AppForeground
  @Provides
  @Singleton
  public ConnectableFlowable<String> providesAppForegroundEventStream(Application paramApplication, ForegroundNotifier paramForegroundNotifier) {
    paramApplication.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)paramForegroundNotifier);
    ConnectableFlowable<String> connectableFlowable = Flowable.create(ForegroundFlowableModule$$Lambda$1.lambdaFactory$(paramForegroundNotifier), BackpressureStrategy.BUFFER).publish();
    connectableFlowable.connect();
    return connectableFlowable;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\ForegroundFlowableModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */