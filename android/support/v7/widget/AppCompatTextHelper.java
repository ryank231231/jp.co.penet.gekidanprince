package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.widget.AutoSizeableTextView;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;

@RequiresApi(9)
class AppCompatTextHelper {
  private static final int MONOSPACE = 3;
  
  private static final int SANS = 1;
  
  private static final int SERIF = 2;
  
  private boolean mAsyncFontPending;
  
  @NonNull
  private final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
  
  private TintInfo mDrawableBottomTint;
  
  private TintInfo mDrawableLeftTint;
  
  private TintInfo mDrawableRightTint;
  
  private TintInfo mDrawableTopTint;
  
  private Typeface mFontTypeface;
  
  private int mStyle = 0;
  
  final TextView mView;
  
  AppCompatTextHelper(TextView paramTextView) {
    this.mView = paramTextView;
    this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(this.mView);
  }
  
  static AppCompatTextHelper create(TextView paramTextView) {
    return (Build.VERSION.SDK_INT >= 17) ? new AppCompatTextHelperV17(paramTextView) : new AppCompatTextHelper(paramTextView);
  }
  
  protected static TintInfo createTintInfo(Context paramContext, AppCompatDrawableManager paramAppCompatDrawableManager, int paramInt) {
    ColorStateList colorStateList = paramAppCompatDrawableManager.getTintList(paramContext, paramInt);
    if (colorStateList != null) {
      TintInfo tintInfo = new TintInfo();
      tintInfo.mHasTintList = true;
      tintInfo.mTintList = colorStateList;
      return tintInfo;
    } 
    return null;
  }
  
  private void onAsyncTypefaceReceived(WeakReference<TextView> paramWeakReference, Typeface paramTypeface) {
    if (this.mAsyncFontPending) {
      this.mFontTypeface = paramTypeface;
      TextView textView = paramWeakReference.get();
      if (textView != null)
        textView.setTypeface(paramTypeface, this.mStyle); 
    } 
  }
  
  private void setTextSizeInternal(int paramInt, float paramFloat) {
    this.mAutoSizeTextHelper.setTextSizeInternal(paramInt, paramFloat);
  }
  
  private void updateTypefaceAndStyle(Context paramContext, TintTypedArray paramTintTypedArray) {
    this.mStyle = paramTintTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, this.mStyle);
    boolean bool = paramTintTypedArray.hasValue(R.styleable.TextAppearance_android_fontFamily);
    boolean bool1 = true;
    if (bool || paramTintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily)) {
      int i;
      this.mFontTypeface = null;
      if (paramTintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily)) {
        i = R.styleable.TextAppearance_fontFamily;
      } else {
        i = R.styleable.TextAppearance_android_fontFamily;
      } 
      if (!paramContext.isRestricted()) {
        ResourcesCompat.FontCallback fontCallback = new ResourcesCompat.FontCallback() {
            public void onFontRetrievalFailed(int param1Int) {}
            
            public void onFontRetrieved(@NonNull Typeface param1Typeface) {
              AppCompatTextHelper.this.onAsyncTypefaceReceived(textViewWeak, param1Typeface);
            }
          };
        try {
          this.mFontTypeface = paramTintTypedArray.getFont(i, this.mStyle, fontCallback);
          if (this.mFontTypeface != null)
            bool1 = false; 
          this.mAsyncFontPending = bool1;
        } catch (UnsupportedOperationException|android.content.res.Resources.NotFoundException unsupportedOperationException) {}
      } 
      if (this.mFontTypeface == null) {
        String str = paramTintTypedArray.getString(i);
        if (str != null)
          this.mFontTypeface = Typeface.create(str, this.mStyle); 
      } 
      return;
    } 
    if (paramTintTypedArray.hasValue(R.styleable.TextAppearance_android_typeface)) {
      this.mAsyncFontPending = false;
      switch (paramTintTypedArray.getInt(R.styleable.TextAppearance_android_typeface, 1)) {
        default:
          return;
        case 3:
          this.mFontTypeface = Typeface.MONOSPACE;
        case 2:
          this.mFontTypeface = Typeface.SERIF;
        case 1:
          break;
      } 
      this.mFontTypeface = Typeface.SANS_SERIF;
    } 
  }
  
  final void applyCompoundDrawableTint(Drawable paramDrawable, TintInfo paramTintInfo) {
    if (paramDrawable != null && paramTintInfo != null)
      AppCompatDrawableManager.tintDrawable(paramDrawable, paramTintInfo, this.mView.getDrawableState()); 
  }
  
  void applyCompoundDrawablesTints() {
    if (this.mDrawableLeftTint != null || this.mDrawableTopTint != null || this.mDrawableRightTint != null || this.mDrawableBottomTint != null) {
      Drawable[] arrayOfDrawable = this.mView.getCompoundDrawables();
      applyCompoundDrawableTint(arrayOfDrawable[0], this.mDrawableLeftTint);
      applyCompoundDrawableTint(arrayOfDrawable[1], this.mDrawableTopTint);
      applyCompoundDrawableTint(arrayOfDrawable[2], this.mDrawableRightTint);
      applyCompoundDrawableTint(arrayOfDrawable[3], this.mDrawableBottomTint);
    } 
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  void autoSizeText() {
    this.mAutoSizeTextHelper.autoSizeText();
  }
  
  int getAutoSizeMaxTextSize() {
    return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
  }
  
  int getAutoSizeMinTextSize() {
    return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
  }
  
  int getAutoSizeStepGranularity() {
    return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
  }
  
  int[] getAutoSizeTextAvailableSizes() {
    return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
  }
  
  int getAutoSizeTextType() {
    return this.mAutoSizeTextHelper.getAutoSizeTextType();
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  boolean isAutoSizeEnabled() {
    return this.mAutoSizeTextHelper.isAutoSizeEnabled();
  }
  
  @SuppressLint({"NewApi"})
  void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt) {
    AppCompatDrawableManager appCompatDrawableManager2;
    ColorStateList colorStateList1;
    ColorStateList colorStateList3;
    boolean bool2;
    AppCompatDrawableManager appCompatDrawableManager5;
    ColorStateList colorStateList4;
    Context context = this.mView.getContext();
    AppCompatDrawableManager appCompatDrawableManager1 = AppCompatDrawableManager.get();
    TintTypedArray tintTypedArray1 = TintTypedArray.obtainStyledAttributes(context, paramAttributeSet, R.styleable.AppCompatTextHelper, paramInt, 0);
    int i = tintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
    if (tintTypedArray1.hasValue(R.styleable.AppCompatTextHelper_android_drawableLeft))
      this.mDrawableLeftTint = createTintInfo(context, appCompatDrawableManager1, tintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_drawableLeft, 0)); 
    if (tintTypedArray1.hasValue(R.styleable.AppCompatTextHelper_android_drawableTop))
      this.mDrawableTopTint = createTintInfo(context, appCompatDrawableManager1, tintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_drawableTop, 0)); 
    if (tintTypedArray1.hasValue(R.styleable.AppCompatTextHelper_android_drawableRight))
      this.mDrawableRightTint = createTintInfo(context, appCompatDrawableManager1, tintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_drawableRight, 0)); 
    if (tintTypedArray1.hasValue(R.styleable.AppCompatTextHelper_android_drawableBottom))
      this.mDrawableBottomTint = createTintInfo(context, appCompatDrawableManager1, tintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_drawableBottom, 0)); 
    tintTypedArray1.recycle();
    boolean bool1 = this.mView.getTransformationMethod() instanceof android.text.method.PasswordTransformationMethod;
    boolean bool = true;
    ColorStateList colorStateList2 = null;
    tintTypedArray1 = null;
    if (i != -1) {
      TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(context, i, R.styleable.TextAppearance);
      if (!bool1 && tintTypedArray.hasValue(R.styleable.TextAppearance_textAllCaps)) {
        bool2 = tintTypedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        i = 1;
      } else {
        i = 0;
        bool2 = false;
      } 
      updateTypefaceAndStyle(context, tintTypedArray);
      if (Build.VERSION.SDK_INT < 23) {
        ColorStateList colorStateList5;
        ColorStateList colorStateList6;
        if (tintTypedArray.hasValue(R.styleable.TextAppearance_android_textColor)) {
          colorStateList5 = tintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColor);
        } else {
          appCompatDrawableManager1 = null;
        } 
        if (tintTypedArray.hasValue(R.styleable.TextAppearance_android_textColorHint)) {
          colorStateList6 = tintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColorHint);
        } else {
          colorStateList6 = null;
        } 
        if (tintTypedArray.hasValue(R.styleable.TextAppearance_android_textColorLink)) {
          colorStateList2 = tintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColorLink);
          appCompatDrawableManager2 = appCompatDrawableManager1;
          colorStateList5 = colorStateList2;
          colorStateList2 = colorStateList6;
        } else {
          colorStateList2 = null;
          ColorStateList colorStateList = colorStateList5;
          colorStateList5 = colorStateList2;
          colorStateList2 = colorStateList6;
        } 
      } else {
        appCompatDrawableManager1 = null;
        appCompatDrawableManager3 = appCompatDrawableManager1;
      } 
      tintTypedArray.recycle();
      appCompatDrawableManager5 = appCompatDrawableManager1;
      appCompatDrawableManager1 = appCompatDrawableManager3;
    } else {
      appCompatDrawableManager5 = null;
      appCompatDrawableManager1 = appCompatDrawableManager5;
      i = 0;
      bool2 = false;
      appCompatDrawableManager2 = appCompatDrawableManager3;
    } 
    TintTypedArray tintTypedArray2 = TintTypedArray.obtainStyledAttributes(context, paramAttributeSet, R.styleable.TextAppearance, paramInt, 0);
    if (!bool1 && tintTypedArray2.hasValue(R.styleable.TextAppearance_textAllCaps)) {
      bool2 = tintTypedArray2.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
      i = bool;
    } 
    AppCompatDrawableManager appCompatDrawableManager6 = appCompatDrawableManager2;
    AppCompatDrawableManager appCompatDrawableManager4 = appCompatDrawableManager5;
    AppCompatDrawableManager appCompatDrawableManager3 = appCompatDrawableManager1;
    if (Build.VERSION.SDK_INT < 23) {
      ColorStateList colorStateList5;
      ColorStateList colorStateList6;
      if (tintTypedArray2.hasValue(R.styleable.TextAppearance_android_textColor))
        colorStateList6 = tintTypedArray2.getColorStateList(R.styleable.TextAppearance_android_textColor); 
      if (tintTypedArray2.hasValue(R.styleable.TextAppearance_android_textColorHint))
        colorStateList5 = tintTypedArray2.getColorStateList(R.styleable.TextAppearance_android_textColorHint); 
      colorStateList4 = colorStateList6;
      appCompatDrawableManager4 = appCompatDrawableManager5;
      colorStateList1 = colorStateList5;
      if (tintTypedArray2.hasValue(R.styleable.TextAppearance_android_textColorLink)) {
        colorStateList3 = tintTypedArray2.getColorStateList(R.styleable.TextAppearance_android_textColorLink);
        colorStateList1 = colorStateList5;
        colorStateList4 = colorStateList6;
      } 
    } 
    updateTypefaceAndStyle(context, tintTypedArray2);
    tintTypedArray2.recycle();
    if (colorStateList4 != null)
      this.mView.setTextColor(colorStateList4); 
    if (colorStateList1 != null)
      this.mView.setHintTextColor(colorStateList1); 
    if (colorStateList3 != null)
      this.mView.setLinkTextColor(colorStateList3); 
    if (!bool1 && i != 0)
      setAllCaps(bool2); 
    Typeface typeface = this.mFontTypeface;
    if (typeface != null)
      this.mView.setTypeface(typeface, this.mStyle); 
    this.mAutoSizeTextHelper.loadFromAttributes(paramAttributeSet, paramInt);
    if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE && this.mAutoSizeTextHelper.getAutoSizeTextType() != 0) {
      int[] arrayOfInt = this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
      if (arrayOfInt.length > 0)
        if (this.mView.getAutoSizeStepGranularity() != -1.0F) {
          this.mView.setAutoSizeTextTypeUniformWithConfiguration(this.mAutoSizeTextHelper.getAutoSizeMinTextSize(), this.mAutoSizeTextHelper.getAutoSizeMaxTextSize(), this.mAutoSizeTextHelper.getAutoSizeStepGranularity(), 0);
        } else {
          this.mView.setAutoSizeTextTypeUniformWithPresetSizes(arrayOfInt, 0);
        }  
    } 
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE)
      autoSizeText(); 
  }
  
  void onSetTextAppearance(Context paramContext, int paramInt) {
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramInt, R.styleable.TextAppearance);
    if (tintTypedArray.hasValue(R.styleable.TextAppearance_textAllCaps))
      setAllCaps(tintTypedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false)); 
    if (Build.VERSION.SDK_INT < 23 && tintTypedArray.hasValue(R.styleable.TextAppearance_android_textColor)) {
      ColorStateList colorStateList = tintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColor);
      if (colorStateList != null)
        this.mView.setTextColor(colorStateList); 
    } 
    updateTypefaceAndStyle(paramContext, tintTypedArray);
    tintTypedArray.recycle();
    Typeface typeface = this.mFontTypeface;
    if (typeface != null)
      this.mView.setTypeface(typeface, this.mStyle); 
  }
  
  void setAllCaps(boolean paramBoolean) {
    this.mView.setAllCaps(paramBoolean);
  }
  
  void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4) throws IllegalArgumentException {
    this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] paramArrayOfint, int paramInt) throws IllegalArgumentException {
    this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfint, paramInt);
  }
  
  void setAutoSizeTextTypeWithDefaults(int paramInt) {
    this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(paramInt);
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  void setTextSize(int paramInt, float paramFloat) {
    if (!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE && !isAutoSizeEnabled())
      setTextSizeInternal(paramInt, paramFloat); 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\v7\widget\AppCompatTextHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */