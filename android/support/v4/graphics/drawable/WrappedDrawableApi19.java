package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

@RequiresApi(19)
class WrappedDrawableApi19 extends WrappedDrawableApi14 {
  WrappedDrawableApi19(Drawable paramDrawable) {
    super(paramDrawable);
  }
  
  WrappedDrawableApi19(WrappedDrawableApi14.DrawableWrapperState paramDrawableWrapperState, Resources paramResources) {
    super(paramDrawableWrapperState, paramResources);
  }
  
  public boolean isAutoMirrored() {
    return this.mDrawable.isAutoMirrored();
  }
  
  @NonNull
  WrappedDrawableApi14.DrawableWrapperState mutateConstantState() {
    return new DrawableWrapperStateKitKat(this.mState, null);
  }
  
  public void setAutoMirrored(boolean paramBoolean) {
    this.mDrawable.setAutoMirrored(paramBoolean);
  }
  
  private static class DrawableWrapperStateKitKat extends WrappedDrawableApi14.DrawableWrapperState {
    DrawableWrapperStateKitKat(@Nullable WrappedDrawableApi14.DrawableWrapperState param1DrawableWrapperState, @Nullable Resources param1Resources) {
      super(param1DrawableWrapperState, param1Resources);
    }
    
    @NonNull
    public Drawable newDrawable(@Nullable Resources param1Resources) {
      return new WrappedDrawableApi19(this, param1Resources);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\v4\graphics\drawable\WrappedDrawableApi19.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */