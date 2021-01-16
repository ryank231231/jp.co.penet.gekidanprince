package androidx.browser.browseractions;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.customtabs.R;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

class BrowserActionsFallbackMenuAdapter extends BaseAdapter {
  private final Context mContext;
  
  private final List<BrowserActionItem> mMenuItems;
  
  BrowserActionsFallbackMenuAdapter(List<BrowserActionItem> paramList, Context paramContext) {
    this.mMenuItems = paramList;
    this.mContext = paramContext;
  }
  
  public int getCount() {
    return this.mMenuItems.size();
  }
  
  public Object getItem(int paramInt) {
    return this.mMenuItems.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolderItem viewHolderItem1;
    ViewHolderItem viewHolderItem2;
    BrowserActionItem browserActionItem = this.mMenuItems.get(paramInt);
    if (paramView == null) {
      View view = LayoutInflater.from(this.mContext).inflate(R.layout.browser_actions_context_menu_row, null);
      viewHolderItem1 = new ViewHolderItem();
      viewHolderItem1.mIcon = (ImageView)view.findViewById(R.id.browser_actions_menu_item_icon);
      viewHolderItem1.mText = (TextView)view.findViewById(R.id.browser_actions_menu_item_text);
      view.setTag(viewHolderItem1);
    } else {
      ViewHolderItem viewHolderItem = (ViewHolderItem)viewHolderItem1.getTag();
      viewHolderItem2 = viewHolderItem1;
      viewHolderItem1 = viewHolderItem;
    } 
    viewHolderItem1.mText.setText(browserActionItem.getTitle());
    if (browserActionItem.getIconId() != 0) {
      Drawable drawable = ResourcesCompat.getDrawable(this.mContext.getResources(), browserActionItem.getIconId(), null);
      viewHolderItem1.mIcon.setImageDrawable(drawable);
    } else {
      viewHolderItem1.mIcon.setImageDrawable(null);
    } 
    return (View)viewHolderItem2;
  }
  
  private static class ViewHolderItem {
    ImageView mIcon;
    
    TextView mText;
    
    private ViewHolderItem() {}
  }
}


/* Location:              Y:\classes-dex2jar.jar!\androidx\browser\browseractions\BrowserActionsFallbackMenuAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */