package com.google.firebase.inappmessaging.display;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.customtabs.CustomTabsIntent;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory;
import com.google.firebase.inappmessaging.display.internal.FiamAnimator;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.RenewableTimer;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.BannerMessage;
import com.google.firebase.inappmessaging.model.CardMessage;
import com.google.firebase.inappmessaging.model.ImageData;
import com.google.firebase.inappmessaging.model.ImageOnlyMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.ModalMessage;
import com.squareup.picasso.Callback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

@Keep
@FirebaseAppScope
public class FirebaseInAppMessagingDisplay extends FirebaseInAppMessagingDisplayImpl {
  static final long DISMISS_THRESHOLD_MILLIS = 20000L;
  
  static final long IMPRESSION_THRESHOLD_MILLIS = 5000L;
  
  static final long INTERVAL_MILLIS = 1000L;
  
  private final FiamAnimator animator;
  
  private final Application application;
  
  private final RenewableTimer autoDismissTimer;
  
  private final BindingWrapperFactory bindingWrapperFactory;
  
  private FirebaseInAppMessagingDisplayCallbacks callbacks;
  
  private FiamListener fiamListener;
  
  private com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay;
  
  private final FirebaseInAppMessaging headlessInAppMessaging;
  
  private final FiamImageLoader imageLoader;
  
  private final RenewableTimer impressionTimer;
  
  private InAppMessage inAppMessage;
  
  private final Map<String, Provider<InAppMessageLayoutConfig>> layoutConfigs;
  
  private final FiamWindowManager windowManager;
  
  @Inject
  FirebaseInAppMessagingDisplay(FirebaseInAppMessaging paramFirebaseInAppMessaging, Map<String, Provider<InAppMessageLayoutConfig>> paramMap, FiamImageLoader paramFiamImageLoader, RenewableTimer paramRenewableTimer1, RenewableTimer paramRenewableTimer2, FiamWindowManager paramFiamWindowManager, Application paramApplication, BindingWrapperFactory paramBindingWrapperFactory, FiamAnimator paramFiamAnimator) {
    this.headlessInAppMessaging = paramFirebaseInAppMessaging;
    this.layoutConfigs = paramMap;
    this.imageLoader = paramFiamImageLoader;
    this.impressionTimer = paramRenewableTimer1;
    this.autoDismissTimer = paramRenewableTimer2;
    this.windowManager = paramFiamWindowManager;
    this.application = paramApplication;
    this.bindingWrapperFactory = paramBindingWrapperFactory;
    this.animator = paramFiamAnimator;
  }
  
  private void cancelTimers() {
    this.impressionTimer.cancel();
    this.autoDismissTimer.cancel();
  }
  
  private void dismissFiam(Activity paramActivity) {
    Logging.logd("Dismissing fiam");
    notifyFiamDismiss();
    removeDisplayedFiam(paramActivity);
    this.inAppMessage = null;
    this.callbacks = null;
  }
  
  private List<Action> extractActions(InAppMessage paramInAppMessage) {
    CardMessage cardMessage;
    ArrayList<Action> arrayList = new ArrayList();
    switch (paramInAppMessage.getMessageType()) {
      default:
        arrayList.add(new Action(null, null));
        return arrayList;
      case CARD:
        cardMessage = (CardMessage)paramInAppMessage;
        arrayList.add(cardMessage.getPrimaryAction());
        arrayList.add(cardMessage.getSecondaryAction());
        return arrayList;
      case IMAGE_ONLY:
        arrayList.add(((ImageOnlyMessage)cardMessage).getAction());
        return arrayList;
      case MODAL:
        arrayList.add(((ModalMessage)cardMessage).getAction());
        return arrayList;
      case BANNER:
        break;
    } 
    arrayList.add(((BannerMessage)cardMessage).getAction());
    return arrayList;
  }
  
  @Keep
  public static FirebaseInAppMessagingDisplay getInstance() {
    return (FirebaseInAppMessagingDisplay)FirebaseApp.getInstance().get(FirebaseInAppMessagingDisplay.class);
  }
  
  private static int getScreenOrientation(Application paramApplication) {
    return (paramApplication.getResources().getConfiguration()).orientation;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void inflateBinding(final Activity activity, final BindingWrapper bindingWrapper) {
    View.OnClickListener onClickListener = new View.OnClickListener() {
        public void onClick(View param1View) {
          if (FirebaseInAppMessagingDisplay.this.callbacks != null)
            FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.CLICK); 
          FirebaseInAppMessagingDisplay.this.dismissFiam(activity);
        }
      };
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (Action action : extractActions(this.inAppMessage)) {
      View.OnClickListener onClickListener1;
      if (action != null && !TextUtils.isEmpty(action.getActionUrl())) {
        onClickListener1 = new View.OnClickListener() {
            public void onClick(View param1View) {
              if (FirebaseInAppMessagingDisplay.this.callbacks != null)
                FirebaseInAppMessagingDisplay.this.callbacks.messageClicked(action); 
              (new CustomTabsIntent.Builder()).setShowTitle(true).build().launchUrl((Context)activity, Uri.parse(action.getActionUrl()));
              FirebaseInAppMessagingDisplay.this.notifyFiamClick();
              FirebaseInAppMessagingDisplay.this.removeDisplayedFiam(activity);
              FirebaseInAppMessagingDisplay.access$002(FirebaseInAppMessagingDisplay.this, null);
              FirebaseInAppMessagingDisplay.access$202(FirebaseInAppMessagingDisplay.this, null);
            }
          };
      } else {
        Logging.loge("No action url found for action.");
        onClickListener1 = onClickListener;
      } 
      hashMap.put(action, onClickListener1);
    } 
    final ViewTreeObserver.OnGlobalLayoutListener layoutListener = bindingWrapper.inflate(hashMap, onClickListener);
    if (onGlobalLayoutListener != null)
      bindingWrapper.getImageView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener); 
    loadNullableImage(activity, bindingWrapper, this.inAppMessage.getImageData(), new Callback() {
          public void onError() {
            Logging.loge("Image download failure ");
            if (layoutListener != null)
              bindingWrapper.getImageView().getViewTreeObserver().removeGlobalOnLayoutListener(layoutListener); 
            FirebaseInAppMessagingDisplay.this.cancelTimers();
            FirebaseInAppMessagingDisplay.access$002(FirebaseInAppMessagingDisplay.this, null);
            FirebaseInAppMessagingDisplay.access$202(FirebaseInAppMessagingDisplay.this, null);
          }
          
          public void onSuccess() {
            if (!bindingWrapper.getConfig().backgroundEnabled().booleanValue())
              bindingWrapper.getRootView().setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View param2View, MotionEvent param2MotionEvent) {
                      if (param2MotionEvent.getAction() == 4) {
                        if (FirebaseInAppMessagingDisplay.this.callbacks != null)
                          FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.UNKNOWN_DISMISS_TYPE); 
                        FirebaseInAppMessagingDisplay.this.dismissFiam(activity);
                        return true;
                      } 
                      return false;
                    }
                  }); 
            FirebaseInAppMessagingDisplay.this.impressionTimer.start(new RenewableTimer.Callback() {
                  public void onFinish() {
                    if (FirebaseInAppMessagingDisplay.this.inAppMessage != null && FirebaseInAppMessagingDisplay.this.callbacks != null) {
                      StringBuilder stringBuilder = new StringBuilder();
                      stringBuilder.append("Impression timer onFinish for: ");
                      stringBuilder.append(FirebaseInAppMessagingDisplay.this.inAppMessage.getCampaignMetadata().getCampaignId());
                      Logging.logi(stringBuilder.toString());
                      FirebaseInAppMessagingDisplay.this.callbacks.impressionDetected();
                    } 
                  }
                },  5000L, 1000L);
            if (bindingWrapper.getConfig().autoDismiss().booleanValue())
              FirebaseInAppMessagingDisplay.this.autoDismissTimer.start(new RenewableTimer.Callback() {
                    public void onFinish() {
                      if (FirebaseInAppMessagingDisplay.this.inAppMessage != null && FirebaseInAppMessagingDisplay.this.callbacks != null)
                        FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.AUTO); 
                      FirebaseInAppMessagingDisplay.this.dismissFiam(activity);
                    }
                  },  20000L, 1000L); 
            activity.runOnUiThread(new Runnable() {
                  public void run() {
                    FirebaseInAppMessagingDisplay.this.windowManager.show(bindingWrapper, activity);
                    if (bindingWrapper.getConfig().animate().booleanValue())
                      FirebaseInAppMessagingDisplay.this.animator.slideIntoView(FirebaseInAppMessagingDisplay.this.application, (View)bindingWrapper.getRootView(), FiamAnimator.Position.TOP); 
                  }
                });
          }
        });
  }
  
  private void loadNullableImage(Activity paramActivity, BindingWrapper paramBindingWrapper, ImageData paramImageData, Callback paramCallback) {
    if (paramImageData != null && !TextUtils.isEmpty(paramImageData.getImageUrl())) {
      this.imageLoader.load(paramImageData.getImageUrl()).tag(paramActivity.getClass()).placeholder(R.drawable.image_placeholder).into(paramBindingWrapper.getImageView(), paramCallback);
    } else {
      paramCallback.onSuccess();
    } 
  }
  
  private void notifyFiamClick() {
    FiamListener fiamListener = this.fiamListener;
    if (fiamListener != null)
      fiamListener.onFiamClick(); 
  }
  
  private void notifyFiamDismiss() {
    FiamListener fiamListener = this.fiamListener;
    if (fiamListener != null)
      fiamListener.onFiamDismiss(); 
  }
  
  private void notifyFiamTrigger() {
    FiamListener fiamListener = this.fiamListener;
    if (fiamListener != null)
      fiamListener.onFiamTrigger(); 
  }
  
  private void removeDisplayedFiam(Activity paramActivity) {
    if (this.windowManager.isFiamDisplayed()) {
      this.windowManager.destroy(paramActivity);
      cancelTimers();
    } 
  }
  
  private void showActiveFiam(@NonNull final Activity activity) {
    final BindingWrapper bindingWrapper;
    if (this.inAppMessage == null || this.headlessInAppMessaging.areMessagesSuppressed()) {
      Logging.loge("No active message found to render");
      return;
    } 
    if (this.inAppMessage.getMessageType().equals(MessageType.UNSUPPORTED)) {
      Logging.loge("The message being triggered is not supported by this version of the sdk.");
      return;
    } 
    notifyFiamTrigger();
    InAppMessageLayoutConfig inAppMessageLayoutConfig = (InAppMessageLayoutConfig)((Provider)this.layoutConfigs.get(InflaterConfigModule.configFor(this.inAppMessage.getMessageType(), getScreenOrientation(this.application)))).get();
    switch (this.inAppMessage.getMessageType()) {
      default:
        Logging.loge("No bindings found for this message type");
        return;
      case CARD:
        Logging.logd("CardMessage bindings not supported in this version of the display sdk.");
        return;
      case IMAGE_ONLY:
        bindingWrapper = this.bindingWrapperFactory.createImageBindingWrapper(inAppMessageLayoutConfig, this.inAppMessage);
        break;
      case MODAL:
        bindingWrapper = this.bindingWrapperFactory.createModalBindingWrapper((InAppMessageLayoutConfig)bindingWrapper, this.inAppMessage);
        break;
      case BANNER:
        bindingWrapper = this.bindingWrapperFactory.createBannerBindingWrapper((InAppMessageLayoutConfig)bindingWrapper, this.inAppMessage);
        break;
    } 
    activity.findViewById(16908290).post(new Runnable() {
          public void run() {
            FirebaseInAppMessagingDisplay.this.inflateBinding(activity, bindingWrapper);
          }
        });
  }
  
  @Keep
  @KeepForSdk
  public void clearFiamListener() {
    this.fiamListener = null;
  }
  
  @VisibleForTesting
  InAppMessage getCurrentInAppMessage() {
    return this.inAppMessage;
  }
  
  @Keep
  @KeepForSdk
  public void onActivityPaused(Activity paramActivity) {
    super.onActivityPaused(paramActivity);
    this.headlessInAppMessaging.clearDisplayListener();
    this.imageLoader.cancelTag(paramActivity.getClass());
    removeDisplayedFiam(paramActivity);
  }
  
  @Keep
  @KeepForSdk
  public void onActivityResumed(Activity paramActivity) {
    super.onActivityResumed(paramActivity);
    if (this.inAppMessage != null)
      showActiveFiam(paramActivity); 
  }
  
  @Keep
  @KeepForSdk
  public void onActivityStarted(final Activity activity) {
    this.firebaseInAppMessagingDisplay = new com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay() {
        public void displayMessage(InAppMessage param1InAppMessage, FirebaseInAppMessagingDisplayCallbacks param1FirebaseInAppMessagingDisplayCallbacks) {
          if (FirebaseInAppMessagingDisplay.this.inAppMessage != null || FirebaseInAppMessagingDisplay.this.headlessInAppMessaging.areMessagesSuppressed()) {
            Logging.logd("Active FIAM exists. Skipping trigger");
            return;
          } 
          FirebaseInAppMessagingDisplay.access$002(FirebaseInAppMessagingDisplay.this, param1InAppMessage);
          FirebaseInAppMessagingDisplay.access$202(FirebaseInAppMessagingDisplay.this, param1FirebaseInAppMessagingDisplayCallbacks);
          FirebaseInAppMessagingDisplay.this.showActiveFiam(activity);
        }
      };
    this.headlessInAppMessaging.setMessageDisplayComponent(this.firebaseInAppMessagingDisplay);
  }
  
  @Keep
  @KeepForSdk
  public void setFiamListener(FiamListener paramFiamListener) {
    this.fiamListener = paramFiamListener;
  }
  
  @Keep
  @KeepForSdk
  public void testMessage(Activity paramActivity, InAppMessage paramInAppMessage, FirebaseInAppMessagingDisplayCallbacks paramFirebaseInAppMessagingDisplayCallbacks) {
    this.inAppMessage = paramInAppMessage;
    this.callbacks = paramFirebaseInAppMessagingDisplayCallbacks;
    showActiveFiam(paramActivity);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\FirebaseInAppMessagingDisplay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */