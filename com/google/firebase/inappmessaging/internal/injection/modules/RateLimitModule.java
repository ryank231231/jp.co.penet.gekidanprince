package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground;
import com.google.firebase.inappmessaging.model.RateLimit;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;

@Module
public class RateLimitModule {
  private static final String APP_FOREGROUND_ONE_PER_DAY_LIMITER_KEY = "APP_FOREGROUND_ONE_PER_DAY_LIMITER_KEY";
  
  @AppForeground
  @Provides
  public RateLimit providesAppForegroundRateLimit() {
    return RateLimit.builder().setLimit(1L).setLimiterKey("APP_FOREGROUND_ONE_PER_DAY_LIMITER_KEY").setTimeToLiveMillis(TimeUnit.DAYS.toMillis(1L)).build();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\RateLimitModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */