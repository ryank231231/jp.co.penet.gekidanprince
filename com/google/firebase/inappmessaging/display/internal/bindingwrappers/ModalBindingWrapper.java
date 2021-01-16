package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;
import com.google.firebase.inappmessaging.display.internal.layout.FiamRelativeLayout;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.ModalMessage;
import java.util.Map;
import javax.inject.Inject;

@InAppMessageScope
public class ModalBindingWrapper extends BindingWrapper {
  private ScrollView bodyScroll;
  
  private Button button;
  
  private View collapseImage;
  
  private ImageView imageView;
  
  private ViewTreeObserver.OnGlobalLayoutListener layoutListener = new ScrollViewAdjustableListener();
  
  private TextView messageBody;
  
  private TextView messageTitle;
  
  private ViewGroup modalContentRoot;
  
  private ModalMessage modalMessage;
  
  private FiamRelativeLayout modalRoot;
  
  @Inject
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public ModalBindingWrapper(InAppMessageLayoutConfig paramInAppMessageLayoutConfig, LayoutInflater paramLayoutInflater, InAppMessage paramInAppMessage) {
    super(paramInAppMessageLayoutConfig, paramLayoutInflater, paramInAppMessage);
  }
  
  private void setActionListener(View.OnClickListener paramOnClickListener) {
    this.button.setOnClickListener(paramOnClickListener);
  }
  
  private void setButtonColorOverrides() {
    if (this.button != null && this.message.getAction() != null && this.message.getAction().getButton() != null && this.message.getAction().getButton().getButtonHexColor() != null) {
      int i = Color.parseColor(this.message.getAction().getButton().getButtonHexColor());
      Drawable drawable = DrawableCompat.wrap(this.button.getBackground());
      DrawableCompat.setTint(drawable, i);
      this.button.setBackground(drawable);
      if (this.message.getAction() != null && this.message.getAction().getButton() != null && this.message.getAction().getButton().getText() != null) {
        if (!TextUtils.isEmpty(this.message.getAction().getButton().getText().getText())) {
          this.button.setVisibility(0);
          this.button.setText(this.message.getAction().getButton().getText().getText());
        } else {
          this.button.setVisibility(8);
        } 
        String str = this.message.getAction().getButton().getText().getHexColor();
        if (!TextUtils.isEmpty(str))
          this.button.setTextColor(Color.parseColor(str)); 
      } 
    } else {
      this.button.setVisibility(8);
    } 
  }
  
  private void setDismissListener(View.OnClickListener paramOnClickListener) {
    this.collapseImage.setOnClickListener(paramOnClickListener);
    this.modalRoot.setDismissListener(paramOnClickListener);
  }
  
  private void setLayoutConfig(InAppMessageLayoutConfig paramInAppMessageLayoutConfig) {
    this.imageView.setMaxHeight(paramInAppMessageLayoutConfig.getMaxImageHeight());
    this.imageView.setMaxWidth(paramInAppMessageLayoutConfig.getMaxImageWidth());
  }
  
  private void setMessage(ModalMessage paramModalMessage) {
    if (paramModalMessage.getImageData() == null || TextUtils.isEmpty(paramModalMessage.getImageData().getImageUrl())) {
      this.imageView.setVisibility(8);
    } else {
      this.imageView.setVisibility(0);
    } 
    if (paramModalMessage.getTitle() != null) {
      if (!TextUtils.isEmpty(paramModalMessage.getTitle().getText())) {
        this.messageTitle.setVisibility(0);
        this.messageTitle.setText(paramModalMessage.getTitle().getText());
      } else {
        this.messageTitle.setVisibility(8);
      } 
      if (!TextUtils.isEmpty(paramModalMessage.getTitle().getHexColor()))
        this.messageTitle.setTextColor(Color.parseColor(paramModalMessage.getTitle().getHexColor())); 
    } 
    if (paramModalMessage.getBody() != null && !TextUtils.isEmpty(paramModalMessage.getBody().getText())) {
      this.bodyScroll.setVisibility(0);
    } else {
      this.bodyScroll.setVisibility(8);
    } 
    if (paramModalMessage.getBody() != null) {
      if (!TextUtils.isEmpty(paramModalMessage.getBody().getText())) {
        this.messageBody.setVisibility(0);
        this.messageBody.setText(paramModalMessage.getBody().getText());
      } else {
        this.messageBody.setVisibility(8);
      } 
      if (!TextUtils.isEmpty(paramModalMessage.getBody().getHexColor()))
        this.messageBody.setTextColor(Color.parseColor(paramModalMessage.getBody().getHexColor())); 
    } 
  }
  
  private void setModalColorOverrides() {
    ViewGroup viewGroup = this.modalContentRoot;
    if (viewGroup != null)
      setGradientDrawableBgColor((View)viewGroup, this.modalMessage.getBackgroundHexColor()); 
  }
  
  @NonNull
  public Button getActionButton() {
    return this.button;
  }
  
  @NonNull
  public View getCollapseButton() {
    return this.collapseImage;
  }
  
  @NonNull
  public InAppMessageLayoutConfig getConfig() {
    return this.config;
  }
  
  @NonNull
  public View getDialogView() {
    return (View)this.modalContentRoot;
  }
  
  @NonNull
  public ImageView getImageView() {
    return this.imageView;
  }
  
  @NonNull
  public ViewGroup getRootView() {
    return (ViewGroup)this.modalRoot;
  }
  
  @NonNull
  public ViewTreeObserver.OnGlobalLayoutListener inflate(Map<Action, View.OnClickListener> paramMap, View.OnClickListener paramOnClickListener) {
    View view = this.inflater.inflate(R.layout.modal, null);
    this.bodyScroll = (ScrollView)view.findViewById(R.id.body_scroll);
    this.button = (Button)view.findViewById(R.id.button);
    this.collapseImage = view.findViewById(R.id.collapse_button);
    this.imageView = (ImageView)view.findViewById(R.id.image_view);
    this.messageBody = (TextView)view.findViewById(R.id.message_body);
    this.messageTitle = (TextView)view.findViewById(R.id.message_title);
    this.modalRoot = (FiamRelativeLayout)view.findViewById(R.id.modal_root);
    this.modalContentRoot = (ViewGroup)view.findViewById(R.id.modal_content_root);
    if (this.message.getMessageType().equals(MessageType.MODAL)) {
      this.modalMessage = (ModalMessage)this.message;
      setMessage((ModalMessage)this.message);
      setLayoutConfig(this.config);
      setDismissListener(paramOnClickListener);
      setActionListener(paramMap.get(this.modalMessage.getAction()));
      setModalColorOverrides();
      setButtonColorOverrides();
    } 
    return this.layoutListener;
  }
  
  @VisibleForTesting
  public void setLayoutListener(ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener) {
    this.layoutListener = paramOnGlobalLayoutListener;
  }
  
  public class ScrollViewAdjustableListener implements ViewTreeObserver.OnGlobalLayoutListener {
    public void onGlobalLayout() {
      ModalBindingWrapper.this.imageView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\bindingwrappers\ModalBindingWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */