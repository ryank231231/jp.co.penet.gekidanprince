package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.ResizableImageView;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;
import com.google.firebase.inappmessaging.display.internal.layout.FiamFrameLayout;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.BannerMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import java.util.Map;
import javax.inject.Inject;

@InAppMessageScope
public class BannerBindingWrapper extends BindingWrapper {
  private TextView bannerBody;
  
  private ViewGroup bannerContentRoot;
  
  private ResizableImageView bannerImage;
  
  private FiamFrameLayout bannerRoot;
  
  private TextView bannerTitle;
  
  private View.OnClickListener mDismissListener;
  
  @Inject
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public BannerBindingWrapper(InAppMessage paramInAppMessage, LayoutInflater paramLayoutInflater, InAppMessageLayoutConfig paramInAppMessageLayoutConfig) {
    super(paramInAppMessageLayoutConfig, paramLayoutInflater, paramInAppMessage);
  }
  
  private void setActionListener(View.OnClickListener paramOnClickListener) {
    this.bannerContentRoot.setOnClickListener(paramOnClickListener);
  }
  
  private void setLayoutConfig(InAppMessageLayoutConfig paramInAppMessageLayoutConfig) {
    int i = Math.min(paramInAppMessageLayoutConfig.maxDialogWidthPx().intValue(), paramInAppMessageLayoutConfig.maxDialogHeightPx().intValue());
    ViewGroup.LayoutParams layoutParams1 = this.bannerRoot.getLayoutParams();
    ViewGroup.LayoutParams layoutParams2 = layoutParams1;
    if (layoutParams1 == null)
      layoutParams2 = new ViewGroup.LayoutParams(-1, -2); 
    layoutParams2.width = i;
    this.bannerRoot.setLayoutParams(layoutParams2);
    this.bannerImage.setMaxHeight(paramInAppMessageLayoutConfig.getMaxImageHeight());
    this.bannerImage.setMaxWidth(paramInAppMessageLayoutConfig.getMaxImageWidth());
  }
  
  private void setMessage(@NonNull BannerMessage paramBannerMessage) {
    boolean bool;
    if (!TextUtils.isEmpty(paramBannerMessage.getBackgroundHexColor()))
      setGradientDrawableBgColor((View)this.bannerContentRoot, paramBannerMessage.getBackgroundHexColor()); 
    ResizableImageView resizableImageView = this.bannerImage;
    if (paramBannerMessage.getImageData() == null || TextUtils.isEmpty(paramBannerMessage.getImageData().getImageUrl())) {
      bool = true;
    } else {
      bool = false;
    } 
    resizableImageView.setVisibility(bool);
    if (paramBannerMessage.getTitle() != null) {
      if (!TextUtils.isEmpty(paramBannerMessage.getTitle().getText()))
        this.bannerTitle.setText(paramBannerMessage.getTitle().getText()); 
      if (!TextUtils.isEmpty(paramBannerMessage.getTitle().getHexColor()))
        this.bannerTitle.setTextColor(Color.parseColor(paramBannerMessage.getTitle().getHexColor())); 
    } 
    if (paramBannerMessage.getBody() != null) {
      if (!TextUtils.isEmpty(paramBannerMessage.getBody().getText()))
        this.bannerBody.setText(paramBannerMessage.getBody().getText()); 
      if (!TextUtils.isEmpty(paramBannerMessage.getBody().getHexColor()))
        this.bannerBody.setTextColor(Color.parseColor(paramBannerMessage.getBody().getHexColor())); 
    } 
  }
  
  private void setSwipeDismissListener(View.OnClickListener paramOnClickListener) {
    this.mDismissListener = paramOnClickListener;
    this.bannerRoot.setDismissListener(this.mDismissListener);
  }
  
  public boolean canSwipeToDismiss() {
    return true;
  }
  
  @NonNull
  public InAppMessageLayoutConfig getConfig() {
    return this.config;
  }
  
  @NonNull
  public View getDialogView() {
    return (View)this.bannerContentRoot;
  }
  
  @Nullable
  public View.OnClickListener getDismissListener() {
    return this.mDismissListener;
  }
  
  @NonNull
  public ImageView getImageView() {
    return (ImageView)this.bannerImage;
  }
  
  @NonNull
  public ViewGroup getRootView() {
    return (ViewGroup)this.bannerRoot;
  }
  
  @Nullable
  public ViewTreeObserver.OnGlobalLayoutListener inflate(Map<Action, View.OnClickListener> paramMap, View.OnClickListener paramOnClickListener) {
    View view = this.inflater.inflate(R.layout.banner, null);
    this.bannerRoot = (FiamFrameLayout)view.findViewById(R.id.banner_root);
    this.bannerContentRoot = (ViewGroup)view.findViewById(R.id.banner_content_root);
    this.bannerBody = (TextView)view.findViewById(R.id.banner_body);
    this.bannerImage = (ResizableImageView)view.findViewById(R.id.banner_image);
    this.bannerTitle = (TextView)view.findViewById(R.id.banner_title);
    if (this.message.getMessageType().equals(MessageType.BANNER)) {
      BannerMessage bannerMessage = (BannerMessage)this.message;
      setMessage(bannerMessage);
      setLayoutConfig(this.config);
      setSwipeDismissListener(paramOnClickListener);
      setActionListener(paramMap.get(bannerMessage.getAction()));
    } 
    return null;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\bindingwrappers\BannerBindingWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */