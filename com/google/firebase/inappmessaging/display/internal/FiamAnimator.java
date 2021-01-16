package com.google.firebase.inappmessaging.display.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Application;
import android.graphics.Point;
import android.view.View;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;

@FirebaseAppScope
public class FiamAnimator {
  public void slideIntoView(final Application app, final View view, Position paramPosition) {
    view.setAlpha(0.0F);
    Point point = Position.getPoint(paramPosition, view);
    view.animate().translationX(point.x).translationY(point.y).setDuration(1L).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter() {
          public void onAnimationEnd(Animator param1Animator) {
            super.onAnimationEnd(param1Animator);
            view.animate().translationX(0.0F).translationY(0.0F).alpha(1.0F).setDuration(app.getResources().getInteger(17694722)).setListener(null);
          }
        });
  }
  
  public void slideOutOfView(Application paramApplication, View paramView, Position paramPosition, final AnimationCompleteListener completeListener) {
    Point point = Position.getPoint(paramPosition, paramView);
    AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() {
        public void onAnimationEnd(Animator param1Animator) {
          super.onAnimationEnd(param1Animator);
          completeListener.onComplete();
        }
      };
    paramView.animate().translationX(point.x).translationY(point.y).setDuration(paramApplication.getResources().getInteger(17694722)).setListener((Animator.AnimatorListener)animatorListenerAdapter);
  }
  
  public static interface AnimationCompleteListener {
    void onComplete();
  }
  
  public enum Position {
    BOTTOM, LEFT, RIGHT, TOP;
    
    static {
      $VALUES = new Position[] { LEFT, RIGHT, TOP, BOTTOM };
    }
    
    private static Point getPoint(Position param1Position, View param1View) {
      param1View.measure(-2, -2);
      switch (param1Position) {
        default:
          return new Point(0, param1View.getMeasuredHeight() * -1);
        case BOTTOM:
          return new Point(0, param1View.getMeasuredHeight() * 1);
        case TOP:
          return new Point(0, param1View.getMeasuredHeight() * -1);
        case RIGHT:
          return new Point(param1View.getMeasuredWidth() * 1, 0);
        case LEFT:
          break;
      } 
      return new Point(param1View.getMeasuredWidth() * -1, 0);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\FiamAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */