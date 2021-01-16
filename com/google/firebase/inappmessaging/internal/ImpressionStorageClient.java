package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.injection.qualifiers.ImpressionStore;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpression;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import com.google.protobuf.AbstractMessageLite;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ImpressionStorageClient {
  private static final CampaignImpressionList EMPTY_IMPRESSIONS = CampaignImpressionList.getDefaultInstance();
  
  private Maybe<CampaignImpressionList> cachedImpressionsMaybe = Maybe.empty();
  
  private final ProtoStorageClient storageClient;
  
  @Inject
  ImpressionStorageClient(@ImpressionStore ProtoStorageClient paramProtoStorageClient) {
    this.storageClient = paramProtoStorageClient;
  }
  
  private static CampaignImpressionList appendImpression(CampaignImpressionList paramCampaignImpressionList, CampaignImpression paramCampaignImpression) {
    return (CampaignImpressionList)CampaignImpressionList.newBuilder(paramCampaignImpressionList).addAlreadySeenCampaigns(paramCampaignImpression).build();
  }
  
  private void clearInMemCache() {
    this.cachedImpressionsMaybe = Maybe.empty();
  }
  
  private void initInMemCache(CampaignImpressionList paramCampaignImpressionList) {
    this.cachedImpressionsMaybe = Maybe.just(paramCampaignImpressionList);
  }
  
  public Maybe<CampaignImpressionList> getAllImpressions() {
    return this.cachedImpressionsMaybe.switchIfEmpty((MaybeSource)this.storageClient.<AbstractMessageLite>read(CampaignImpressionList.parser()).doOnSuccess(ImpressionStorageClient$$Lambda$2.lambdaFactory$(this))).doOnError(ImpressionStorageClient$$Lambda$3.lambdaFactory$(this));
  }
  
  public Single<Boolean> isImpressed(String paramString) {
    return getAllImpressions().map(ImpressionStorageClient$$Lambda$4.lambdaFactory$()).flatMapObservable(ImpressionStorageClient$$Lambda$5.lambdaFactory$()).map(ImpressionStorageClient$$Lambda$6.lambdaFactory$()).contains(paramString);
  }
  
  public Completable storeImpression(CampaignImpression paramCampaignImpression) {
    return getAllImpressions().defaultIfEmpty(EMPTY_IMPRESSIONS).flatMapCompletable(ImpressionStorageClient$$Lambda$1.lambdaFactory$(this, paramCampaignImpression));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\ImpressionStorageClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */