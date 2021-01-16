package androidx.browser.browseractions;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.customtabs.R;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class BrowserActionsFallbackMenuView extends LinearLayout {
  private final int mBrowserActionsMenuMaxWidthPx = getResources().getDimensionPixelOffset(R.dimen.browser_actions_context_menu_max_width);
  
  private final int mBrowserActionsMenuMinPaddingPx = getResources().getDimensionPixelOffset(R.dimen.browser_actions_context_menu_min_padding);
  
  public BrowserActionsFallbackMenuView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min((getResources().getDisplayMetrics()).widthPixels - this.mBrowserActionsMenuMinPaddingPx * 2, this.mBrowserActionsMenuMaxWidthPx), 1073741824), paramInt2);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\androidx\browser\browseractions\BrowserActionsFallbackMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */