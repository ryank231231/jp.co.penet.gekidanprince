package android.support.v4.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.util.Pair;
import android.util.Pair;
import android.view.View;

public class ActivityOptionsCompat {
  public static final String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
  
  public static final String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";
  
  @RequiresApi(16)
  private static ActivityOptionsCompat createImpl(ActivityOptions paramActivityOptions) {
    return (Build.VERSION.SDK_INT >= 24) ? new ActivityOptionsCompatApi24Impl(paramActivityOptions) : ((Build.VERSION.SDK_INT >= 23) ? new ActivityOptionsCompatApi23Impl(paramActivityOptions) : new ActivityOptionsCompatApi16Impl(paramActivityOptions));
  }
  
  @NonNull
  public static ActivityOptionsCompat makeBasic() {
    return (Build.VERSION.SDK_INT >= 23) ? createImpl(ActivityOptions.makeBasic()) : new ActivityOptionsCompat();
  }
  
  @NonNull
  public static ActivityOptionsCompat makeClipRevealAnimation(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return (Build.VERSION.SDK_INT >= 23) ? createImpl(ActivityOptions.makeClipRevealAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4)) : new ActivityOptionsCompat();
  }
  
  @NonNull
  public static ActivityOptionsCompat makeCustomAnimation(@NonNull Context paramContext, int paramInt1, int paramInt2) {
    return (Build.VERSION.SDK_INT >= 16) ? createImpl(ActivityOptions.makeCustomAnimation(paramContext, paramInt1, paramInt2)) : new ActivityOptionsCompat();
  }
  
  @NonNull
  public static ActivityOptionsCompat makeScaleUpAnimation(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return (Build.VERSION.SDK_INT >= 16) ? createImpl(ActivityOptions.makeScaleUpAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4)) : new ActivityOptionsCompat();
  }
  
  @NonNull
  public static ActivityOptionsCompat makeSceneTransitionAnimation(@NonNull Activity paramActivity, @NonNull View paramView, @NonNull String paramString) {
    return (Build.VERSION.SDK_INT >= 21) ? createImpl(ActivityOptions.makeSceneTransitionAnimation(paramActivity, paramView, paramString)) : new ActivityOptionsCompat();
  }
  
  @NonNull
  public static ActivityOptionsCompat makeSceneTransitionAnimation(@NonNull Activity paramActivity, Pair<View, String>... paramVarArgs) {
    if (Build.VERSION.SDK_INT >= 21) {
      Pair[] arrayOfPair = null;
      if (paramVarArgs != null) {
        Pair[] arrayOfPair1 = new Pair[paramVarArgs.length];
        byte b = 0;
        while (true) {
          arrayOfPair = arrayOfPair1;
          if (b < paramVarArgs.length) {
            arrayOfPair1[b] = Pair.create((paramVarArgs[b]).first, (paramVarArgs[b]).second);
            b++;
            continue;
          } 
          break;
        } 
      } 
      return createImpl(ActivityOptions.makeSceneTransitionAnimation(paramActivity, arrayOfPair));
    } 
    return new ActivityOptionsCompat();
  }
  
  @NonNull
  public static ActivityOptionsCompat makeTaskLaunchBehind() {
    return (Build.VERSION.SDK_INT >= 21) ? createImpl(ActivityOptions.makeTaskLaunchBehind()) : new ActivityOptionsCompat();
  }
  
  @NonNull
  public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(@NonNull View paramView, @NonNull Bitmap paramBitmap, int paramInt1, int paramInt2) {
    return (Build.VERSION.SDK_INT >= 16) ? createImpl(ActivityOptions.makeThumbnailScaleUpAnimation(paramView, paramBitmap, paramInt1, paramInt2)) : new ActivityOptionsCompat();
  }
  
  @Nullable
  public Rect getLaunchBounds() {
    return null;
  }
  
  public void requestUsageTimeReport(@NonNull PendingIntent paramPendingIntent) {}
  
  @NonNull
  public ActivityOptionsCompat setLaunchBounds(@Nullable Rect paramRect) {
    return this;
  }
  
  @Nullable
  public Bundle toBundle() {
    return null;
  }
  
  public void update(@NonNull ActivityOptionsCompat paramActivityOptionsCompat) {}
  
  @RequiresApi(16)
  private static class ActivityOptionsCompatApi16Impl extends ActivityOptionsCompat {
    protected final ActivityOptions mActivityOptions;
    
    ActivityOptionsCompatApi16Impl(ActivityOptions param1ActivityOptions) {
      this.mActivityOptions = param1ActivityOptions;
    }
    
    public Bundle toBundle() {
      return this.mActivityOptions.toBundle();
    }
    
    public void update(ActivityOptionsCompat param1ActivityOptionsCompat) {
      if (param1ActivityOptionsCompat instanceof ActivityOptionsCompatApi16Impl) {
        param1ActivityOptionsCompat = param1ActivityOptionsCompat;
        this.mActivityOptions.update(((ActivityOptionsCompatApi16Impl)param1ActivityOptionsCompat).mActivityOptions);
      } 
    }
  }
  
  @RequiresApi(23)
  private static class ActivityOptionsCompatApi23Impl extends ActivityOptionsCompatApi16Impl {
    ActivityOptionsCompatApi23Impl(ActivityOptions param1ActivityOptions) {
      super(param1ActivityOptions);
    }
    
    public void requestUsageTimeReport(PendingIntent param1PendingIntent) {
      this.mActivityOptions.requestUsageTimeReport(param1PendingIntent);
    }
  }
  
  @RequiresApi(24)
  private static class ActivityOptionsCompatApi24Impl extends ActivityOptionsCompatApi23Impl {
    ActivityOptionsCompatApi24Impl(ActivityOptions param1ActivityOptions) {
      super(param1ActivityOptions);
    }
    
    public Rect getLaunchBounds() {
      return this.mActivityOptions.getLaunchBounds();
    }
    
    public ActivityOptionsCompat setLaunchBounds(@Nullable Rect param1Rect) {
      return new ActivityOptionsCompatApi24Impl(this.mActivityOptions.setLaunchBounds(param1Rect));
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\v4\app\ActivityOptionsCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */