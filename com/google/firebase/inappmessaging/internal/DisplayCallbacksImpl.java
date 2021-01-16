package com.google.firebase.inappmessaging.internal;

import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.internal.vendored.Clock;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.CardMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpression;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;

public class DisplayCallbacksImpl implements FirebaseInAppMessagingDisplayCallbacks {
  private static final String MESSAGE_CLICK = "message click to metrics logger";
  
  private static boolean wasImpressed;
  
  private final RateLimit appForegroundRateLimit;
  
  private final CampaignCacheClient campaignCacheClient;
  
  private final Clock clock;
  
  private final DataCollectionHelper dataCollectionHelper;
  
  private final ImpressionStorageClient impressionStorageClient;
  
  private final InAppMessage inAppMessage;
  
  private final MetricsLoggerClient metricsLoggerClient;
  
  private final RateLimiterClient rateLimiterClient;
  
  private final Schedulers schedulers;
  
  private final String triggeringEvent;
  
  @VisibleForTesting
  DisplayCallbacksImpl(ImpressionStorageClient paramImpressionStorageClient, Clock paramClock, Schedulers paramSchedulers, RateLimiterClient paramRateLimiterClient, CampaignCacheClient paramCampaignCacheClient, RateLimit paramRateLimit, MetricsLoggerClient paramMetricsLoggerClient, DataCollectionHelper paramDataCollectionHelper, InAppMessage paramInAppMessage, String paramString) {
    this.impressionStorageClient = paramImpressionStorageClient;
    this.clock = paramClock;
    this.schedulers = paramSchedulers;
    this.rateLimiterClient = paramRateLimiterClient;
    this.campaignCacheClient = paramCampaignCacheClient;
    this.appForegroundRateLimit = paramRateLimit;
    this.metricsLoggerClient = paramMetricsLoggerClient;
    this.dataCollectionHelper = paramDataCollectionHelper;
    this.inAppMessage = paramInAppMessage;
    this.triggeringEvent = paramString;
    wasImpressed = false;
  }
  
  private boolean actionMatches(Action paramAction1, Action paramAction2) {
    return (paramAction1 == null) ? ((paramAction2 == null || TextUtils.isEmpty(paramAction2.getActionUrl()))) : paramAction1.getActionUrl().equals(paramAction2.getActionUrl());
  }
  
  private void logActionNotTaken(String paramString) {
    logActionNotTaken(paramString, null);
  }
  
  private void logActionNotTaken(String paramString, Maybe<String> paramMaybe) {
    if (paramMaybe != null) {
      Logging.logd(String.format("Not recording: %s. Reason: %s", new Object[] { paramString, paramMaybe }));
    } else if (this.inAppMessage.getIsTestMessage().booleanValue()) {
      Logging.logd(String.format("Not recording: %s. Reason: Message is test message", new Object[] { paramString }));
    } else if (!this.dataCollectionHelper.isAutomaticDataCollectionEnabled()) {
      Logging.logd(String.format("Not recording: %s. Reason: Data collection is disabled", new Object[] { paramString }));
    } else {
      Logging.logd(String.format("Not recording: %s", new Object[] { paramString }));
    } 
  }
  
  private Task<Void> logImpressionIfNeeded(Completable paramCompletable) {
    if (!wasImpressed)
      impressionDetected(); 
    return maybeToTask(paramCompletable.toMaybe(), this.schedulers.io());
  }
  
  private Task<Void> logMessageClick(Action paramAction) {
    Logging.logd("Attempting to record: message click to metrics logger");
    return logImpressionIfNeeded(Completable.fromAction(DisplayCallbacksImpl$$Lambda$4.lambdaFactory$(this, paramAction)));
  }
  
  private Completable logToImpressionStore() {
    Logging.logd("Attempting to record: message impression in impression store");
    String str = this.inAppMessage.getCampaignId();
    Completable completable = this.impressionStorageClient.storeImpression((CampaignImpression)CampaignImpression.newBuilder().setImpressionTimestampMillis(this.clock.now()).setCampaignId(str).build()).doOnError(DisplayCallbacksImpl$$Lambda$6.lambdaFactory$()).doOnComplete(DisplayCallbacksImpl$$Lambda$7.lambdaFactory$());
    return InAppMessageStreamManager.isAppForegroundEvent(this.triggeringEvent) ? this.rateLimiterClient.increment(this.appForegroundRateLimit).doOnError(DisplayCallbacksImpl$$Lambda$8.lambdaFactory$()).doOnComplete(DisplayCallbacksImpl$$Lambda$9.lambdaFactory$()).onErrorComplete().andThen((CompletableSource)completable) : completable;
  }
  
  private static <T> Task<T> maybeToTask(Maybe<T> paramMaybe, Scheduler paramScheduler) {
    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
    taskCompletionSource.getClass();
    paramMaybe.doOnSuccess(DisplayCallbacksImpl$$Lambda$10.lambdaFactory$(taskCompletionSource)).switchIfEmpty((MaybeSource)Maybe.fromCallable(DisplayCallbacksImpl$$Lambda$11.lambdaFactory$(taskCompletionSource))).onErrorResumeNext(DisplayCallbacksImpl$$Lambda$12.lambdaFactory$(taskCompletionSource)).subscribeOn(paramScheduler).subscribe();
    return taskCompletionSource.getTask();
  }
  
  private boolean shouldLog() {
    boolean bool;
    if (this.dataCollectionHelper.isAutomaticDataCollectionEnabled() && !this.inAppMessage.getIsTestMessage().booleanValue()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private Completable updateWasImpressed() {
    return Completable.fromAction(DisplayCallbacksImpl$$Lambda$2.lambdaFactory$());
  }
  
  public Task<Void> displayErrorEncountered(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason paramInAppMessagingErrorReason) {
    if (shouldLog()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Attempting to record: ");
      stringBuilder.append("render error to metrics logger");
      Logging.logd(stringBuilder.toString());
      Completable completable = Completable.fromAction(DisplayCallbacksImpl$$Lambda$5.lambdaFactory$(this, paramInAppMessagingErrorReason));
      return maybeToTask(logToImpressionStore().andThen((CompletableSource)completable).andThen((CompletableSource)updateWasImpressed()).toMaybe(), this.schedulers.io());
    } 
    logActionNotTaken("render error to metrics logger");
    return (new TaskCompletionSource()).getTask();
  }
  
  public Task<Void> impressionDetected() {
    if (shouldLog() && !wasImpressed) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Attempting to record: ");
      stringBuilder.append("message impression to metrics logger");
      Logging.logd(stringBuilder.toString());
      Completable completable = Completable.fromAction(DisplayCallbacksImpl$$Lambda$1.lambdaFactory$(this));
      return maybeToTask(logToImpressionStore().andThen((CompletableSource)completable).andThen((CompletableSource)updateWasImpressed()).toMaybe(), this.schedulers.io());
    } 
    logActionNotTaken("message impression to metrics logger");
    return (new TaskCompletionSource()).getTask();
  }
  
  @Deprecated
  public Task<Void> messageClicked() {
    return messageClicked(this.inAppMessage.getAction());
  }
  
  public Task<Void> messageClicked(Action paramAction) {
    if (shouldLog()) {
      if (this.inAppMessage.getMessageType().equals(MessageType.CARD))
        return actionMatches(((CardMessage)this.inAppMessage).getPrimaryAction(), paramAction) ? logMessageClick(paramAction) : messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.CLICK); 
      logMessageClick(paramAction);
    } 
    logActionNotTaken("message click to metrics logger");
    return (new TaskCompletionSource()).getTask();
  }
  
  public Task<Void> messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType paramInAppMessagingDismissType) {
    if (shouldLog()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Attempting to record: ");
      stringBuilder.append("message dismissal to metrics logger");
      Logging.logd(stringBuilder.toString());
      return logImpressionIfNeeded(Completable.fromAction(DisplayCallbacksImpl$$Lambda$3.lambdaFactory$(this, paramInAppMessagingDismissType)));
    } 
    logActionNotTaken("message dismissal to metrics logger");
    return (new TaskCompletionSource()).getTask();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\DisplayCallbacksImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */