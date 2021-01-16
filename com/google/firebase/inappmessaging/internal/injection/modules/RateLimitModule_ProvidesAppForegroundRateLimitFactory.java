package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.model.RateLimit;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class RateLimitModule_ProvidesAppForegroundRateLimitFactory implements Factory<RateLimit> {
  private final RateLimitModule module;
  
  public RateLimitModule_ProvidesAppForegroundRateLimitFactory(RateLimitModule paramRateLimitModule) {
    this.module = paramRateLimitModule;
  }
  
  public static Factory<RateLimit> create(RateLimitModule paramRateLimitModule) {
    return new RateLimitModule_ProvidesAppForegroundRateLimitFactory(paramRateLimitModule);
  }
  
  public RateLimit get() {
    return (RateLimit)Preconditions.checkNotNull(this.module.providesAppForegroundRateLimit(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\RateLimitModule_ProvidesAppForegroundRateLimitFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */