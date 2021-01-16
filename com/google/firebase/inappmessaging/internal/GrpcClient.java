package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequest;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServingGrpc;
import javax.inject.Inject;

@FirebaseAppScope
public class GrpcClient {
  private final InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub stub;
  
  @Inject
  GrpcClient(InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub paramInAppMessagingSdkServingBlockingStub) {
    this.stub = paramInAppMessagingSdkServingBlockingStub;
  }
  
  public FetchEligibleCampaignsResponse fetchEligibleCampaigns(FetchEligibleCampaignsRequest paramFetchEligibleCampaignsRequest) {
    return this.stub.fetchEligibleCampaigns(paramFetchEligibleCampaignsRequest);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\GrpcClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */