package com.google.firebase.inappmessaging.display.internal;

import android.view.GestureDetector;
import android.view.MotionEvent;

public class OnSwipeUpListener extends GestureDetector.SimpleOnGestureListener {
  private static final int SWIPE_MAX_OFF_PATH = 250;
  
  private static final int SWIPE_MIN_DISTANCE = 120;
  
  private static final int SWIPE_THRESHOLD_VELOCITY = 200;
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
    return (Math.abs(paramMotionEvent1.getX() - paramMotionEvent2.getX()) > 250.0F) ? false : ((paramMotionEvent1.getY() - paramMotionEvent2.getY() > 120.0F && Math.abs(paramFloat2) > 200.0F) ? onSwipeUp() : false);
  }
  
  public boolean onSwipeUp() {
    return false;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\OnSwipeUpListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */