package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.model.MessageType;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public class InflaterConfigModule {
  private int DISABLED_BG_FLAG = 327938;
  
  private int ENABLED_BG_FLAG = 65824;
  
  public static String configFor(MessageType paramMessageType, int paramInt) {
    if (paramInt == 1) {
      switch (paramMessageType) {
        default:
          return null;
        case BANNER:
          return "BANNER_PORTRAIT";
        case IMAGE_ONLY:
          return "IMAGE_ONLY_PORTRAIT";
        case MODAL:
          break;
      } 
      return "MODAL_PORTRAIT";
    } 
    switch (paramMessageType) {
      default:
        return null;
      case BANNER:
        return "BANNER_LANDSCAPE";
      case IMAGE_ONLY:
        return "IMAGE_ONLY_LANDSCAPE";
      case MODAL:
        break;
    } 
    return "MODAL_LANDSCAPE";
  }
  
  @Provides
  @IntoMap
  @StringKey("BANNER_LANDSCAPE")
  InAppMessageLayoutConfig providesBannerLandscapeLayoutConfig(DisplayMetrics paramDisplayMetrics) {
    return InAppMessageLayoutConfig.builder().setMaxImageHeightWeight(Float.valueOf(0.3F)).setMaxImageWidthWeight(Float.valueOf(0.3F)).setMaxDialogHeightPx(Integer.valueOf((int)(paramDisplayMetrics.heightPixels * 0.5F))).setMaxDialogWidthPx(Integer.valueOf((int)(paramDisplayMetrics.widthPixels * 0.9F))).setViewWindowGravity(Integer.valueOf(48)).setWindowFlag(Integer.valueOf(this.ENABLED_BG_FLAG)).setWindowWidth(Integer.valueOf(-1)).setWindowHeight(Integer.valueOf(-2)).setBackgroundEnabled(Boolean.valueOf(true)).setAnimate(Boolean.valueOf(true)).setAutoDismiss(Boolean.valueOf(true)).build();
  }
  
  @Provides
  @IntoMap
  @StringKey("BANNER_PORTRAIT")
  InAppMessageLayoutConfig providesBannerPortraitLayoutConfig(DisplayMetrics paramDisplayMetrics) {
    return InAppMessageLayoutConfig.builder().setMaxImageHeightWeight(Float.valueOf(0.3F)).setMaxImageWidthWeight(Float.valueOf(0.3F)).setMaxDialogHeightPx(Integer.valueOf((int)(paramDisplayMetrics.heightPixels * 0.5F))).setMaxDialogWidthPx(Integer.valueOf((int)(paramDisplayMetrics.widthPixels * 0.9F))).setViewWindowGravity(Integer.valueOf(48)).setWindowFlag(Integer.valueOf(this.ENABLED_BG_FLAG)).setWindowWidth(Integer.valueOf(-1)).setWindowHeight(Integer.valueOf(-2)).setBackgroundEnabled(Boolean.valueOf(true)).setAnimate(Boolean.valueOf(true)).setAutoDismiss(Boolean.valueOf(true)).build();
  }
  
  @Provides
  DisplayMetrics providesDisplayMetrics(Application paramApplication) {
    DisplayMetrics displayMetrics = new DisplayMetrics();
    ((WindowManager)paramApplication.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
    return displayMetrics;
  }
  
  @Provides
  @IntoMap
  @StringKey("IMAGE_ONLY_LANDSCAPE")
  InAppMessageLayoutConfig providesLandscapeImageLayoutConfig(DisplayMetrics paramDisplayMetrics) {
    return InAppMessageLayoutConfig.builder().setMaxDialogHeightPx(Integer.valueOf((int)(paramDisplayMetrics.heightPixels * 0.9F))).setMaxDialogWidthPx(Integer.valueOf((int)(paramDisplayMetrics.widthPixels * 0.9F))).setMaxImageWidthWeight(Float.valueOf(0.8F)).setMaxImageHeightWeight(Float.valueOf(0.8F)).setViewWindowGravity(Integer.valueOf(17)).setWindowFlag(Integer.valueOf(this.DISABLED_BG_FLAG)).setWindowWidth(Integer.valueOf(-2)).setWindowHeight(Integer.valueOf(-2)).setBackgroundEnabled(Boolean.valueOf(false)).setAnimate(Boolean.valueOf(false)).setAutoDismiss(Boolean.valueOf(false)).build();
  }
  
  @Provides
  @IntoMap
  @StringKey("MODAL_LANDSCAPE")
  InAppMessageLayoutConfig providesModalLandscapeConfig(DisplayMetrics paramDisplayMetrics) {
    InAppMessageLayoutConfig.Builder builder = InAppMessageLayoutConfig.builder();
    double d = paramDisplayMetrics.heightPixels;
    Double.isNaN(d);
    return builder.setMaxDialogHeightPx(Integer.valueOf((int)(d * 0.8D))).setMaxDialogWidthPx(Integer.valueOf(paramDisplayMetrics.widthPixels)).setMaxImageHeightWeight(Float.valueOf(1.0F)).setMaxImageWidthWeight(Float.valueOf(0.4F)).setMaxBodyHeightWeight(Float.valueOf(0.6F)).setMaxBodyWidthWeight(Float.valueOf(0.4F)).setViewWindowGravity(Integer.valueOf(17)).setWindowFlag(Integer.valueOf(this.DISABLED_BG_FLAG)).setWindowWidth(Integer.valueOf(-1)).setWindowHeight(Integer.valueOf(-1)).setBackgroundEnabled(Boolean.valueOf(false)).setAnimate(Boolean.valueOf(false)).setAutoDismiss(Boolean.valueOf(false)).build();
  }
  
  @Provides
  @IntoMap
  @StringKey("MODAL_PORTRAIT")
  InAppMessageLayoutConfig providesModalPortraitConfig(DisplayMetrics paramDisplayMetrics) {
    InAppMessageLayoutConfig.Builder builder = InAppMessageLayoutConfig.builder();
    double d = paramDisplayMetrics.heightPixels;
    Double.isNaN(d);
    return builder.setMaxDialogHeightPx(Integer.valueOf((int)(d * 0.8D))).setMaxDialogWidthPx(Integer.valueOf((int)(paramDisplayMetrics.widthPixels * 0.7F))).setMaxImageHeightWeight(Float.valueOf(0.6F)).setMaxBodyHeightWeight(Float.valueOf(0.1F)).setMaxImageWidthWeight(Float.valueOf(0.9F)).setMaxBodyWidthWeight(Float.valueOf(0.9F)).setViewWindowGravity(Integer.valueOf(17)).setWindowFlag(Integer.valueOf(this.DISABLED_BG_FLAG)).setWindowWidth(Integer.valueOf(-1)).setWindowHeight(Integer.valueOf(-2)).setBackgroundEnabled(Boolean.valueOf(false)).setAnimate(Boolean.valueOf(false)).setAutoDismiss(Boolean.valueOf(false)).build();
  }
  
  @Provides
  @IntoMap
  @StringKey("IMAGE_ONLY_PORTRAIT")
  InAppMessageLayoutConfig providesPortraitImageLayoutConfig(DisplayMetrics paramDisplayMetrics) {
    return InAppMessageLayoutConfig.builder().setMaxDialogHeightPx(Integer.valueOf((int)(paramDisplayMetrics.heightPixels * 0.9F))).setMaxDialogWidthPx(Integer.valueOf((int)(paramDisplayMetrics.widthPixels * 0.9F))).setMaxImageWidthWeight(Float.valueOf(0.8F)).setMaxImageHeightWeight(Float.valueOf(0.8F)).setViewWindowGravity(Integer.valueOf(17)).setWindowFlag(Integer.valueOf(this.DISABLED_BG_FLAG)).setWindowWidth(Integer.valueOf(-2)).setWindowHeight(Integer.valueOf(-2)).setBackgroundEnabled(Boolean.valueOf(false)).setAnimate(Boolean.valueOf(false)).setAutoDismiss(Boolean.valueOf(false)).build();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\injection\modules\InflaterConfigModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */