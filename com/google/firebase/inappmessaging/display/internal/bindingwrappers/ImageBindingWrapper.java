package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;
import com.google.firebase.inappmessaging.display.internal.layout.FiamFrameLayout;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.ImageOnlyMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import java.util.Map;
import javax.inject.Inject;

@InAppMessageScope
public class ImageBindingWrapper extends BindingWrapper {
  private Button collapseButton;
  
  private ViewGroup imageContentRoot;
  
  private FiamFrameLayout imageRoot;
  
  private ImageView imageView;
  
  @Inject
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public ImageBindingWrapper(InAppMessageLayoutConfig paramInAppMessageLayoutConfig, LayoutInflater paramLayoutInflater, InAppMessage paramInAppMessage) {
    super(paramInAppMessageLayoutConfig, paramLayoutInflater, paramInAppMessage);
  }
  
  @NonNull
  public View getCollapseButton() {
    return (View)this.collapseButton;
  }
  
  @NonNull
  public View getDialogView() {
    return (View)this.imageContentRoot;
  }
  
  @NonNull
  public ImageView getImageView() {
    return this.imageView;
  }
  
  @NonNull
  public ViewGroup getRootView() {
    return (ViewGroup)this.imageRoot;
  }
  
  @Nullable
  public ViewTreeObserver.OnGlobalLayoutListener inflate(Map<Action, View.OnClickListener> paramMap, View.OnClickListener paramOnClickListener) {
    View view = this.inflater.inflate(R.layout.image, null);
    this.imageRoot = (FiamFrameLayout)view.findViewById(R.id.image_root);
    this.imageContentRoot = (ViewGroup)view.findViewById(R.id.image_content_root);
    this.imageView = (ImageView)view.findViewById(R.id.image_view);
    this.collapseButton = (Button)view.findViewById(R.id.collapse_button);
    this.imageView.setMaxHeight(this.config.getMaxImageHeight());
    this.imageView.setMaxWidth(this.config.getMaxImageWidth());
    if (this.message.getMessageType().equals(MessageType.IMAGE_ONLY)) {
      boolean bool;
      ImageOnlyMessage imageOnlyMessage = (ImageOnlyMessage)this.message;
      ImageView imageView = this.imageView;
      if (imageOnlyMessage.getImageData() == null || TextUtils.isEmpty(imageOnlyMessage.getImageData().getImageUrl())) {
        bool = true;
      } else {
        bool = false;
      } 
      imageView.setVisibility(bool);
      this.imageView.setOnClickListener(paramMap.get(imageOnlyMessage.getAction()));
    } 
    this.imageRoot.setDismissListener(paramOnClickListener);
    this.collapseButton.setOnClickListener(paramOnClickListener);
    return null;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\bindingwrappers\ImageBindingWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */