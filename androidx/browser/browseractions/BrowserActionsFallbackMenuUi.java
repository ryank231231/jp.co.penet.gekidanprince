package androidx.browser.browseractions;

import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import android.support.customtabs.R;
import android.support.v4.widget.TextViewCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.List;

class BrowserActionsFallbackMenuUi implements AdapterView.OnItemClickListener {
  private static final String TAG = "BrowserActionskMenuUi";
  
  private BrowserActionsFallbackMenuDialog mBrowserActionsDialog;
  
  private final Context mContext;
  
  private final List<BrowserActionItem> mMenuItems;
  
  private BrowserActionsFallMenuUiListener mMenuUiListener;
  
  private final Uri mUri;
  
  BrowserActionsFallbackMenuUi(Context paramContext, Uri paramUri, List<BrowserActionItem> paramList) {
    this.mContext = paramContext;
    this.mUri = paramUri;
    this.mMenuItems = paramList;
  }
  
  private BrowserActionsFallbackMenuView initMenuView(View paramView) {
    BrowserActionsFallbackMenuView browserActionsFallbackMenuView = (BrowserActionsFallbackMenuView)paramView.findViewById(R.id.browser_actions_menu_view);
    final TextView urlTextView = (TextView)paramView.findViewById(R.id.browser_actions_header_text);
    textView.setText(this.mUri.toString());
    textView.setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            if (TextViewCompat.getMaxLines(urlTextView) == Integer.MAX_VALUE) {
              urlTextView.setMaxLines(1);
              urlTextView.setEllipsize(TextUtils.TruncateAt.END);
            } else {
              urlTextView.setMaxLines(2147483647);
              urlTextView.setEllipsize(null);
            } 
          }
        });
    ListView listView = (ListView)paramView.findViewById(R.id.browser_actions_menu_items);
    listView.setAdapter((ListAdapter)new BrowserActionsFallbackMenuAdapter(this.mMenuItems, this.mContext));
    listView.setOnItemClickListener(this);
    return browserActionsFallbackMenuView;
  }
  
  public void displayMenu() {
    final View view = LayoutInflater.from(this.mContext).inflate(R.layout.browser_actions_context_menu_page, null);
    this.mBrowserActionsDialog = new BrowserActionsFallbackMenuDialog(this.mContext, (View)initMenuView(view));
    this.mBrowserActionsDialog.setContentView(view);
    if (this.mMenuUiListener != null)
      this.mBrowserActionsDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            public void onShow(DialogInterface param1DialogInterface) {
              BrowserActionsFallbackMenuUi.this.mMenuUiListener.onMenuShown(view);
            }
          }); 
    this.mBrowserActionsDialog.show();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    PendingIntent pendingIntent = ((BrowserActionItem)this.mMenuItems.get(paramInt)).getAction();
    try {
      pendingIntent.send();
      this.mBrowserActionsDialog.dismiss();
    } catch (android.app.PendingIntent.CanceledException canceledException) {
      Log.e("BrowserActionskMenuUi", "Failed to send custom item action", (Throwable)canceledException);
    } 
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  @VisibleForTesting
  void setMenuUiListener(BrowserActionsFallMenuUiListener paramBrowserActionsFallMenuUiListener) {
    this.mMenuUiListener = paramBrowserActionsFallMenuUiListener;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  @VisibleForTesting
  static interface BrowserActionsFallMenuUiListener {
    void onMenuShown(View param1View);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\androidx\browser\browseractions\BrowserActionsFallbackMenuUi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */