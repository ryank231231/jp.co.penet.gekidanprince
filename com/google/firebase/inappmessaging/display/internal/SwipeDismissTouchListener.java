package com.google.firebase.inappmessaging.display.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

public class SwipeDismissTouchListener implements View.OnTouchListener {
  private long mAnimationTime;
  
  private DismissCallbacks mDismissCallbacks;
  
  private float mDownX;
  
  private float mDownY;
  
  private int mMaxFlingVelocity;
  
  private int mMinFlingVelocity;
  
  private int mSlop;
  
  private boolean mSwiping;
  
  private int mSwipingSlop;
  
  private Object mToken;
  
  private float mTranslationX;
  
  private VelocityTracker mVelocityTracker;
  
  private View mView;
  
  private int mViewWidth = 1;
  
  public SwipeDismissTouchListener(View paramView, Object paramObject, DismissCallbacks paramDismissCallbacks) {
    ViewConfiguration viewConfiguration = ViewConfiguration.get(paramView.getContext());
    this.mSlop = viewConfiguration.getScaledTouchSlop();
    this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
    this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    this.mAnimationTime = paramView.getContext().getResources().getInteger(17694720);
    this.mView = paramView;
    this.mToken = paramObject;
    this.mDismissCallbacks = paramDismissCallbacks;
  }
  
  private void animateTo(float paramFloat1, float paramFloat2, @Nullable AnimatorListenerAdapter paramAnimatorListenerAdapter) {
    final float beginTranslation = getTranslationX();
    final float beginAlpha = this.mView.getAlpha();
    ValueAnimator valueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    valueAnimator.setDuration(this.mAnimationTime);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            float f1 = beginTranslation;
            float f2 = param1ValueAnimator.getAnimatedFraction();
            float f3 = translationDiff;
            float f4 = beginAlpha;
            float f5 = param1ValueAnimator.getAnimatedFraction();
            float f6 = alphaDiff;
            SwipeDismissTouchListener.this.setTranslationX(f1 + f2 * f3);
            SwipeDismissTouchListener.this.setAlpha(f4 + f5 * f6);
          }
        });
    if (paramAnimatorListenerAdapter != null)
      valueAnimator.addListener((Animator.AnimatorListener)paramAnimatorListenerAdapter); 
    valueAnimator.start();
  }
  
  private void performDismiss() {
    final ViewGroup.LayoutParams lp = this.mView.getLayoutParams();
    final int originalHeight = this.mView.getHeight();
    ValueAnimator valueAnimator = ValueAnimator.ofInt(new int[] { i, 1 }).setDuration(this.mAnimationTime);
    valueAnimator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter() {
          public void onAnimationEnd(Animator param1Animator) {
            SwipeDismissTouchListener.this.mDismissCallbacks.onDismiss(SwipeDismissTouchListener.this.mView, SwipeDismissTouchListener.this.mToken);
            SwipeDismissTouchListener.this.mView.setAlpha(1.0F);
            SwipeDismissTouchListener.this.mView.setTranslationX(0.0F);
            lp.height = originalHeight;
            SwipeDismissTouchListener.this.mView.setLayoutParams(lp);
          }
        });
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            lp.height = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            SwipeDismissTouchListener.this.mView.setLayoutParams(lp);
          }
        });
    valueAnimator.start();
  }
  
  protected float getTranslationX() {
    return this.mView.getTranslationX();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    VelocityTracker velocityTracker;
    paramMotionEvent.offsetLocation(this.mTranslationX, 0.0F);
    if (this.mViewWidth < 2)
      this.mViewWidth = this.mView.getWidth(); 
    int i = paramMotionEvent.getActionMasked();
    boolean bool = true;
    switch (i) {
      default:
        return false;
      case 3:
        if (this.mVelocityTracker != null) {
          startCancelAnimation();
          this.mVelocityTracker.recycle();
          this.mVelocityTracker = null;
          this.mTranslationX = 0.0F;
          this.mDownX = 0.0F;
          this.mDownY = 0.0F;
          this.mSwiping = false;
        } 
      case 2:
        velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
          velocityTracker.addMovement(paramMotionEvent);
          float f1 = paramMotionEvent.getRawX() - this.mDownX;
          float f2 = paramMotionEvent.getRawY();
          float f3 = this.mDownY;
          if (Math.abs(f1) > this.mSlop && Math.abs(f2 - f3) < Math.abs(f1) / 2.0F) {
            this.mSwiping = true;
            if (f1 > 0.0F) {
              i = this.mSlop;
            } else {
              i = -this.mSlop;
            } 
            this.mSwipingSlop = i;
            this.mView.getParent().requestDisallowInterceptTouchEvent(true);
            MotionEvent motionEvent = MotionEvent.obtain(paramMotionEvent);
            motionEvent.setAction(paramMotionEvent.getActionIndex() << 8 | 0x3);
            this.mView.onTouchEvent(motionEvent);
            motionEvent.recycle();
          } 
          if (this.mSwiping) {
            this.mTranslationX = f1;
            setTranslationX(f1 - this.mSwipingSlop);
            setAlpha(Math.max(0.0F, Math.min(1.0F, 1.0F - Math.abs(f1) * 2.0F / this.mViewWidth)));
            return true;
          } 
        } 
      case 1:
        if (this.mVelocityTracker != null) {
          float f4 = paramMotionEvent.getRawX() - this.mDownX;
          this.mVelocityTracker.addMovement(paramMotionEvent);
          this.mVelocityTracker.computeCurrentVelocity(1000);
          float f2 = this.mVelocityTracker.getXVelocity();
          float f1 = Math.abs(f2);
          float f3 = Math.abs(this.mVelocityTracker.getYVelocity());
          if (Math.abs(f4) > (this.mViewWidth / 2) && this.mSwiping) {
            if (f4 > 0.0F) {
              bool = true;
            } else {
              bool = false;
            } 
            i = 1;
          } else if (this.mMinFlingVelocity <= f1 && f1 <= this.mMaxFlingVelocity && f3 < f1 && f3 < f1 && this.mSwiping) {
            byte b;
            if (f2 < 0.0F) {
              i = 1;
            } else {
              i = 0;
            } 
            if (f4 < 0.0F) {
              b = 1;
            } else {
              b = 0;
            } 
            if (i == b) {
              i = 1;
            } else {
              i = 0;
            } 
            if (this.mVelocityTracker.getXVelocity() <= 0.0F)
              bool = false; 
          } else {
            i = 0;
            bool = false;
          } 
          if (i != 0) {
            startDismissAnimation(bool);
          } else if (this.mSwiping) {
            startCancelAnimation();
          } 
          velocityTracker = this.mVelocityTracker;
          if (velocityTracker != null)
            velocityTracker.recycle(); 
          this.mVelocityTracker = null;
          this.mTranslationX = 0.0F;
          this.mDownX = 0.0F;
          this.mDownY = 0.0F;
          this.mSwiping = false;
        } 
      case 0:
        break;
    } 
    this.mDownX = paramMotionEvent.getRawX();
    this.mDownY = paramMotionEvent.getRawY();
    if (this.mDismissCallbacks.canDismiss(this.mToken)) {
      this.mVelocityTracker = VelocityTracker.obtain();
      this.mVelocityTracker.addMovement(paramMotionEvent);
    } 
    return false;
  }
  
  protected void setAlpha(float paramFloat) {
    this.mView.setAlpha(paramFloat);
  }
  
  protected void setTranslationX(float paramFloat) {
    this.mView.setTranslationX(paramFloat);
  }
  
  protected void startCancelAnimation() {
    animateTo(0.0F, 1.0F, null);
  }
  
  protected void startDismissAnimation(boolean paramBoolean) {
    int i;
    if (paramBoolean) {
      i = this.mViewWidth;
    } else {
      i = -this.mViewWidth;
    } 
    animateTo(i, 0.0F, new AnimatorListenerAdapter() {
          public void onAnimationEnd(Animator param1Animator) {
            SwipeDismissTouchListener.this.performDismiss();
          }
        });
  }
  
  public static interface DismissCallbacks {
    boolean canDismiss(Object param1Object);
    
    void onDismiss(View param1View, Object param1Object);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\SwipeDismissTouchListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */