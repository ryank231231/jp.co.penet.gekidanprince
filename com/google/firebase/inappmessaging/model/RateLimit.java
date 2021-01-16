package com.google.firebase.inappmessaging.model;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class RateLimit {
  public static Builder builder() {
    return new AutoValue_RateLimit.Builder();
  }
  
  public abstract long limit();
  
  public abstract String limiterKey();
  
  public abstract long timeToLiveMillis();
  
  @com.google.auto.value.AutoValue.Builder
  public static abstract class Builder {
    public abstract RateLimit build();
    
    public abstract Builder setLimit(long param1Long);
    
    public abstract Builder setLimiterKey(String param1String);
    
    public abstract Builder setTimeToLiveMillis(long param1Long);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\model\RateLimit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */