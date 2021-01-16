package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.injection.qualifiers.RateLimit;
import com.google.firebase.inappmessaging.internal.vendored.Clock;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.protobuf.AbstractMessageLite;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RateLimiterClient {
  private static final RateLimitProto.RateLimit EMPTY_RATE_LIMITS = RateLimitProto.RateLimit.getDefaultInstance();
  
  private Maybe<RateLimitProto.RateLimit> cachedRateLimts = Maybe.empty();
  
  private final Clock clock;
  
  private final ProtoStorageClient storageClient;
  
  @Inject
  RateLimiterClient(@RateLimit ProtoStorageClient paramProtoStorageClient, Clock paramClock) {
    this.storageClient = paramProtoStorageClient;
    this.clock = paramClock;
  }
  
  private void clearInMemCache() {
    this.cachedRateLimts = Maybe.empty();
  }
  
  private Maybe<RateLimitProto.RateLimit> getRateLimits() {
    return this.cachedRateLimts.switchIfEmpty((MaybeSource)this.storageClient.<RateLimitProto.RateLimit>read(RateLimitProto.RateLimit.parser()).doOnSuccess(RateLimiterClient$$Lambda$4.lambdaFactory$(this))).doOnError(RateLimiterClient$$Lambda$5.lambdaFactory$(this));
  }
  
  private static RateLimitProto.Counter increment(RateLimitProto.Counter paramCounter) {
    return (RateLimitProto.Counter)RateLimitProto.Counter.newBuilder(paramCounter).clearValue().setValue(paramCounter.getValue() + 1L).build();
  }
  
  private void initInMemCache(RateLimitProto.RateLimit paramRateLimit) {
    this.cachedRateLimts = Maybe.just(paramRateLimit);
  }
  
  private boolean isLimitExpired(RateLimitProto.Counter paramCounter, RateLimit paramRateLimit) {
    boolean bool;
    if (this.clock.now() - paramCounter.getStartTimeEpoch() > paramRateLimit.timeToLiveMillis()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private RateLimitProto.Counter newCounter() {
    return (RateLimitProto.Counter)RateLimitProto.Counter.newBuilder().setValue(0L).setStartTimeEpoch(this.clock.now()).build();
  }
  
  public Completable increment(RateLimit paramRateLimit) {
    return getRateLimits().defaultIfEmpty(EMPTY_RATE_LIMITS).flatMapCompletable(RateLimiterClient$$Lambda$1.lambdaFactory$(this, paramRateLimit));
  }
  
  public Single<Boolean> isRateLimited(RateLimit paramRateLimit) {
    return getRateLimits().switchIfEmpty((MaybeSource)Maybe.just(RateLimitProto.RateLimit.getDefaultInstance())).map(RateLimiterClient$$Lambda$2.lambdaFactory$(this, paramRateLimit)).filter(RateLimiterClient$$Lambda$3.lambdaFactory$(this, paramRateLimit)).isEmpty();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\RateLimiterClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */