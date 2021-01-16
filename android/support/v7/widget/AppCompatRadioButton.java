package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.widget.TintableCompoundButton;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class AppCompatRadioButton extends RadioButton implements TintableCompoundButton {
  private final AppCompatCompoundButtonHelper mCompoundButtonHelper = new AppCompatCompoundButtonHelper((CompoundButton)this);
  
  private final AppCompatTextHelper mTextHelper;
  
  public AppCompatRadioButton(Context paramContext) {
    this(paramContext, null);
  }
  
  public AppCompatRadioButton(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.radioButtonStyle);
  }
  
  public AppCompatRadioButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(TintContextWrapper.wrap(paramContext), paramAttributeSet, paramInt);
    this.mCompoundButtonHelper.loadFromAttributes(paramAttributeSet, paramInt);
    this.mTextHelper = new AppCompatTextHelper((TextView)this);
    this.mTextHelper.loadFromAttributes(paramAttributeSet, paramInt);
  }
  
  public int getCompoundPaddingLeft() {
    int i = super.getCompoundPaddingLeft();
    AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCompoundButtonHelper;
    int j = i;
    if (appCompatCompoundButtonHelper != null)
      j = appCompatCompoundButtonHelper.getCompoundPaddingLeft(i); 
    return j;
  }
  
  @Nullable
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public ColorStateList getSupportButtonTintList() {
    AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCompoundButtonHelper;
    if (appCompatCompoundButtonHelper != null) {
      ColorStateList colorStateList = appCompatCompoundButtonHelper.getSupportButtonTintList();
    } else {
      appCompatCompoundButtonHelper = null;
    } 
    return (ColorStateList)appCompatCompoundButtonHelper;
  }
  
  @Nullable
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public PorterDuff.Mode getSupportButtonTintMode() {
    AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCompoundButtonHelper;
    if (appCompatCompoundButtonHelper != null) {
      PorterDuff.Mode mode = appCompatCompoundButtonHelper.getSupportButtonTintMode();
    } else {
      appCompatCompoundButtonHelper = null;
    } 
    return (PorterDuff.Mode)appCompatCompoundButtonHelper;
  }
  
  public void setButtonDrawable(@DrawableRes int paramInt) {
    setButtonDrawable(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  public void setButtonDrawable(Drawable paramDrawable) {
    super.setButtonDrawable(paramDrawable);
    AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCompoundButtonHelper;
    if (appCompatCompoundButtonHelper != null)
      appCompatCompoundButtonHelper.onSetButtonDrawable(); 
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public void setSupportButtonTintList(@Nullable ColorStateList paramColorStateList) {
    AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCompoundButtonHelper;
    if (appCompatCompoundButtonHelper != null)
      appCompatCompoundButtonHelper.setSupportButtonTintList(paramColorStateList); 
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public void setSupportButtonTintMode(@Nullable PorterDuff.Mode paramMode) {
    AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCompoundButtonHelper;
    if (appCompatCompoundButtonHelper != null)
      appCompatCompoundButtonHelper.setSupportButtonTintMode(paramMode); 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\v7\widget\AppCompatRadioButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */