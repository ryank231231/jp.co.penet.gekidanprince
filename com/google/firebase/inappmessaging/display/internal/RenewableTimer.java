package com.google.firebase.inappmessaging.display.internal;

import android.os.CountDownTimer;

public class RenewableTimer {
  private CountDownTimer mCountDownTimer;
  
  public void cancel() {
    CountDownTimer countDownTimer = this.mCountDownTimer;
    if (countDownTimer != null) {
      countDownTimer.cancel();
      this.mCountDownTimer = null;
    } 
  }
  
  public void start(final Callback c, long paramLong1, long paramLong2) {
    this.mCountDownTimer = (new CountDownTimer(paramLong1, paramLong2) {
        public void onFinish() {
          c.onFinish();
        }
        
        public void onTick(long param1Long) {}
      }).start();
  }
  
  public static interface Callback {
    void onFinish();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\RenewableTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */