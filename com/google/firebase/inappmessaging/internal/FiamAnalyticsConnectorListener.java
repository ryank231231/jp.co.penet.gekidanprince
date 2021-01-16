package com.google.firebase.inappmessaging.internal;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import io.reactivex.FlowableEmitter;

final class FiamAnalyticsConnectorListener implements AnalyticsConnector.AnalyticsConnectorListener {
  private FlowableEmitter<String> emitter;
  
  FiamAnalyticsConnectorListener(FlowableEmitter<String> paramFlowableEmitter) {
    this.emitter = paramFlowableEmitter;
  }
  
  public void onMessageTriggered(int paramInt, Bundle paramBundle) {
    if (paramInt == 2)
      this.emitter.onNext(paramBundle.getString("events")); 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\FiamAnalyticsConnectorListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */