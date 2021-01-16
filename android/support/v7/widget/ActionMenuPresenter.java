package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ActionProvider;
import android.support.v7.appcompat.R;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.BaseMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.ShowableListMenu;
import android.support.v7.view.menu.SubMenuBuilder;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {
  private static final String TAG = "ActionMenuPresenter";
  
  private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
  
  ActionButtonSubmenu mActionButtonPopup;
  
  private int mActionItemWidthLimit;
  
  private boolean mExpandedActionViewsExclusive;
  
  private int mMaxItems;
  
  private boolean mMaxItemsSet;
  
  private int mMinCellSize;
  
  int mOpenSubMenuId;
  
  OverflowMenuButton mOverflowButton;
  
  OverflowPopup mOverflowPopup;
  
  private Drawable mPendingOverflowIcon;
  
  private boolean mPendingOverflowIconSet;
  
  private ActionMenuPopupCallback mPopupCallback;
  
  final PopupPresenterCallback mPopupPresenterCallback = new PopupPresenterCallback();
  
  OpenOverflowRunnable mPostedOpenRunnable;
  
  private boolean mReserveOverflow;
  
  private boolean mReserveOverflowSet;
  
  private View mScrapActionButtonView;
  
  private boolean mStrictWidthLimit;
  
  private int mWidthLimit;
  
  private boolean mWidthLimitSet;
  
  public ActionMenuPresenter(Context paramContext) {
    super(paramContext, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
  }
  
  private View findViewForItem(MenuItem paramMenuItem) {
    ViewGroup viewGroup = (ViewGroup)this.mMenuView;
    if (viewGroup == null)
      return null; 
    int i = viewGroup.getChildCount();
    for (byte b = 0; b < i; b++) {
      View view = viewGroup.getChildAt(b);
      if (view instanceof MenuView.ItemView && ((MenuView.ItemView)view).getItemData() == paramMenuItem)
        return view; 
    } 
    return null;
  }
  
  public void bindItemView(MenuItemImpl paramMenuItemImpl, MenuView.ItemView paramItemView) {
    paramItemView.initialize(paramMenuItemImpl, 0);
    ActionMenuView actionMenuView = (ActionMenuView)this.mMenuView;
    ActionMenuItemView actionMenuItemView = (ActionMenuItemView)paramItemView;
    actionMenuItemView.setItemInvoker(actionMenuView);
    if (this.mPopupCallback == null)
      this.mPopupCallback = new ActionMenuPopupCallback(); 
    actionMenuItemView.setPopupCallback(this.mPopupCallback);
  }
  
  public boolean dismissPopupMenus() {
    return hideOverflowMenu() | hideSubMenus();
  }
  
  public boolean filterLeftoverView(ViewGroup paramViewGroup, int paramInt) {
    return (paramViewGroup.getChildAt(paramInt) == this.mOverflowButton) ? false : super.filterLeftoverView(paramViewGroup, paramInt);
  }
  
  public boolean flagActionItems() {
    // Byte code:
    //   0: aload_0
    //   1: astore_1
    //   2: aload_1
    //   3: getfield mMenu : Landroid/support/v7/view/menu/MenuBuilder;
    //   6: ifnull -> 25
    //   9: aload_1
    //   10: getfield mMenu : Landroid/support/v7/view/menu/MenuBuilder;
    //   13: invokevirtual getVisibleItems : ()Ljava/util/ArrayList;
    //   16: astore_2
    //   17: aload_2
    //   18: invokevirtual size : ()I
    //   21: istore_3
    //   22: goto -> 29
    //   25: aconst_null
    //   26: astore_2
    //   27: iconst_0
    //   28: istore_3
    //   29: aload_1
    //   30: getfield mMaxItems : I
    //   33: istore #4
    //   35: aload_1
    //   36: getfield mActionItemWidthLimit : I
    //   39: istore #5
    //   41: iconst_0
    //   42: iconst_0
    //   43: invokestatic makeMeasureSpec : (II)I
    //   46: istore #6
    //   48: aload_1
    //   49: getfield mMenuView : Landroid/support/v7/view/menu/MenuView;
    //   52: checkcast android/view/ViewGroup
    //   55: astore #7
    //   57: iconst_0
    //   58: istore #8
    //   60: iconst_0
    //   61: istore #9
    //   63: iconst_0
    //   64: istore #10
    //   66: iconst_0
    //   67: istore #11
    //   69: iload #8
    //   71: iload_3
    //   72: if_icmpge -> 153
    //   75: aload_2
    //   76: iload #8
    //   78: invokevirtual get : (I)Ljava/lang/Object;
    //   81: checkcast android/support/v7/view/menu/MenuItemImpl
    //   84: astore #12
    //   86: aload #12
    //   88: invokevirtual requiresActionButton : ()Z
    //   91: ifeq -> 100
    //   94: iinc #10, 1
    //   97: goto -> 117
    //   100: aload #12
    //   102: invokevirtual requestsActionButton : ()Z
    //   105: ifeq -> 114
    //   108: iinc #11, 1
    //   111: goto -> 117
    //   114: iconst_1
    //   115: istore #9
    //   117: iload #4
    //   119: istore #13
    //   121: aload_1
    //   122: getfield mExpandedActionViewsExclusive : Z
    //   125: ifeq -> 143
    //   128: iload #4
    //   130: istore #13
    //   132: aload #12
    //   134: invokevirtual isActionViewExpanded : ()Z
    //   137: ifeq -> 143
    //   140: iconst_0
    //   141: istore #13
    //   143: iinc #8, 1
    //   146: iload #13
    //   148: istore #4
    //   150: goto -> 69
    //   153: iload #4
    //   155: istore #8
    //   157: aload_1
    //   158: getfield mReserveOverflow : Z
    //   161: ifeq -> 189
    //   164: iload #9
    //   166: ifne -> 183
    //   169: iload #4
    //   171: istore #8
    //   173: iload #11
    //   175: iload #10
    //   177: iadd
    //   178: iload #4
    //   180: if_icmple -> 189
    //   183: iload #4
    //   185: iconst_1
    //   186: isub
    //   187: istore #8
    //   189: iload #8
    //   191: iload #10
    //   193: isub
    //   194: istore #11
    //   196: aload_1
    //   197: getfield mActionButtonGroups : Landroid/util/SparseBooleanArray;
    //   200: astore #12
    //   202: aload #12
    //   204: invokevirtual clear : ()V
    //   207: aload_1
    //   208: getfield mStrictWidthLimit : Z
    //   211: ifeq -> 243
    //   214: aload_1
    //   215: getfield mMinCellSize : I
    //   218: istore #4
    //   220: iload #5
    //   222: iload #4
    //   224: idiv
    //   225: istore #10
    //   227: iload #4
    //   229: iload #5
    //   231: iload #4
    //   233: irem
    //   234: iload #10
    //   236: idiv
    //   237: iadd
    //   238: istore #9
    //   240: goto -> 249
    //   243: iconst_0
    //   244: istore #9
    //   246: iconst_0
    //   247: istore #10
    //   249: iload #5
    //   251: istore #8
    //   253: iconst_0
    //   254: istore #5
    //   256: iconst_0
    //   257: istore #4
    //   259: iload_3
    //   260: istore #13
    //   262: aload_0
    //   263: astore_1
    //   264: iload #5
    //   266: iload #13
    //   268: if_icmpge -> 777
    //   271: aload_2
    //   272: iload #5
    //   274: invokevirtual get : (I)Ljava/lang/Object;
    //   277: checkcast android/support/v7/view/menu/MenuItemImpl
    //   280: astore #14
    //   282: aload #14
    //   284: invokevirtual requiresActionButton : ()Z
    //   287: ifeq -> 405
    //   290: aload_1
    //   291: aload #14
    //   293: aload_1
    //   294: getfield mScrapActionButtonView : Landroid/view/View;
    //   297: aload #7
    //   299: invokevirtual getItemView : (Landroid/support/v7/view/menu/MenuItemImpl;Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    //   302: astore #15
    //   304: aload_1
    //   305: getfield mScrapActionButtonView : Landroid/view/View;
    //   308: ifnonnull -> 317
    //   311: aload_1
    //   312: aload #15
    //   314: putfield mScrapActionButtonView : Landroid/view/View;
    //   317: aload_1
    //   318: getfield mStrictWidthLimit : Z
    //   321: ifeq -> 344
    //   324: iload #10
    //   326: aload #15
    //   328: iload #9
    //   330: iload #10
    //   332: iload #6
    //   334: iconst_0
    //   335: invokestatic measureChildForCells : (Landroid/view/View;IIII)I
    //   338: isub
    //   339: istore #10
    //   341: goto -> 353
    //   344: aload #15
    //   346: iload #6
    //   348: iload #6
    //   350: invokevirtual measure : (II)V
    //   353: aload #15
    //   355: invokevirtual getMeasuredWidth : ()I
    //   358: istore_3
    //   359: iload #8
    //   361: iload_3
    //   362: isub
    //   363: istore #8
    //   365: iload #4
    //   367: ifne -> 376
    //   370: iload_3
    //   371: istore #4
    //   373: goto -> 376
    //   376: aload #14
    //   378: invokevirtual getGroupId : ()I
    //   381: istore_3
    //   382: iload_3
    //   383: ifeq -> 396
    //   386: aload #12
    //   388: iload_3
    //   389: iconst_1
    //   390: invokevirtual put : (IZ)V
    //   393: goto -> 396
    //   396: aload #14
    //   398: iconst_1
    //   399: invokevirtual setIsActionButton : (Z)V
    //   402: goto -> 771
    //   405: aload #14
    //   407: invokevirtual requestsActionButton : ()Z
    //   410: ifeq -> 765
    //   413: aload #14
    //   415: invokevirtual getGroupId : ()I
    //   418: istore #16
    //   420: aload #12
    //   422: iload #16
    //   424: invokevirtual get : (I)Z
    //   427: istore #17
    //   429: iload #11
    //   431: ifgt -> 439
    //   434: iload #17
    //   436: ifeq -> 462
    //   439: iload #8
    //   441: ifle -> 462
    //   444: aload_1
    //   445: getfield mStrictWidthLimit : Z
    //   448: ifeq -> 456
    //   451: iload #10
    //   453: ifle -> 462
    //   456: iconst_1
    //   457: istore #18
    //   459: goto -> 465
    //   462: iconst_0
    //   463: istore #18
    //   465: iload #18
    //   467: ifeq -> 638
    //   470: aload_1
    //   471: aload #14
    //   473: aload_1
    //   474: getfield mScrapActionButtonView : Landroid/view/View;
    //   477: aload #7
    //   479: invokevirtual getItemView : (Landroid/support/v7/view/menu/MenuItemImpl;Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    //   482: astore #15
    //   484: aload_1
    //   485: getfield mScrapActionButtonView : Landroid/view/View;
    //   488: ifnonnull -> 497
    //   491: aload_1
    //   492: aload #15
    //   494: putfield mScrapActionButtonView : Landroid/view/View;
    //   497: aload_1
    //   498: getfield mStrictWidthLimit : Z
    //   501: ifeq -> 541
    //   504: aload #15
    //   506: iload #9
    //   508: iload #10
    //   510: iload #6
    //   512: iconst_0
    //   513: invokestatic measureChildForCells : (Landroid/view/View;IIII)I
    //   516: istore #19
    //   518: iload #10
    //   520: iload #19
    //   522: isub
    //   523: istore_3
    //   524: iload_3
    //   525: istore #10
    //   527: iload #19
    //   529: ifne -> 550
    //   532: iconst_0
    //   533: istore #18
    //   535: iload_3
    //   536: istore #10
    //   538: goto -> 550
    //   541: aload #15
    //   543: iload #6
    //   545: iload #6
    //   547: invokevirtual measure : (II)V
    //   550: aload #15
    //   552: invokevirtual getMeasuredWidth : ()I
    //   555: istore #19
    //   557: iload #8
    //   559: iload #19
    //   561: isub
    //   562: istore #8
    //   564: iload #4
    //   566: istore_3
    //   567: iload #4
    //   569: ifne -> 575
    //   572: iload #19
    //   574: istore_3
    //   575: aload_1
    //   576: getfield mStrictWidthLimit : Z
    //   579: ifeq -> 609
    //   582: iload #8
    //   584: iflt -> 593
    //   587: iconst_1
    //   588: istore #4
    //   590: goto -> 596
    //   593: iconst_0
    //   594: istore #4
    //   596: iload #18
    //   598: iload #4
    //   600: iand
    //   601: istore #18
    //   603: iload_3
    //   604: istore #4
    //   606: goto -> 638
    //   609: iload #8
    //   611: iload_3
    //   612: iadd
    //   613: ifle -> 622
    //   616: iconst_1
    //   617: istore #4
    //   619: goto -> 625
    //   622: iconst_0
    //   623: istore #4
    //   625: iload #18
    //   627: iload #4
    //   629: iand
    //   630: istore #18
    //   632: iload_3
    //   633: istore #4
    //   635: goto -> 638
    //   638: iload #18
    //   640: ifeq -> 662
    //   643: iload #16
    //   645: ifeq -> 662
    //   648: aload #12
    //   650: iload #16
    //   652: iconst_1
    //   653: invokevirtual put : (IZ)V
    //   656: iload #11
    //   658: istore_3
    //   659: goto -> 742
    //   662: iload #11
    //   664: istore_3
    //   665: iload #17
    //   667: ifeq -> 742
    //   670: aload #12
    //   672: iload #16
    //   674: iconst_0
    //   675: invokevirtual put : (IZ)V
    //   678: iconst_0
    //   679: istore #19
    //   681: iload #11
    //   683: istore_3
    //   684: iload #19
    //   686: iload #5
    //   688: if_icmpge -> 742
    //   691: aload_2
    //   692: iload #19
    //   694: invokevirtual get : (I)Ljava/lang/Object;
    //   697: checkcast android/support/v7/view/menu/MenuItemImpl
    //   700: astore_1
    //   701: iload #11
    //   703: istore_3
    //   704: aload_1
    //   705: invokevirtual getGroupId : ()I
    //   708: iload #16
    //   710: if_icmpne -> 733
    //   713: iload #11
    //   715: istore_3
    //   716: aload_1
    //   717: invokevirtual isActionButton : ()Z
    //   720: ifeq -> 728
    //   723: iload #11
    //   725: iconst_1
    //   726: iadd
    //   727: istore_3
    //   728: aload_1
    //   729: iconst_0
    //   730: invokevirtual setIsActionButton : (Z)V
    //   733: iinc #19, 1
    //   736: iload_3
    //   737: istore #11
    //   739: goto -> 681
    //   742: iload_3
    //   743: istore #11
    //   745: iload #18
    //   747: ifeq -> 755
    //   750: iload_3
    //   751: iconst_1
    //   752: isub
    //   753: istore #11
    //   755: aload #14
    //   757: iload #18
    //   759: invokevirtual setIsActionButton : (Z)V
    //   762: goto -> 771
    //   765: aload #14
    //   767: iconst_0
    //   768: invokevirtual setIsActionButton : (Z)V
    //   771: iinc #5, 1
    //   774: goto -> 262
    //   777: iconst_1
    //   778: ireturn
  }
  
  public View getItemView(MenuItemImpl paramMenuItemImpl, View paramView, ViewGroup paramViewGroup) {
    boolean bool;
    View view = paramMenuItemImpl.getActionView();
    if (view == null || paramMenuItemImpl.hasCollapsibleActionView())
      view = super.getItemView(paramMenuItemImpl, paramView, paramViewGroup); 
    if (paramMenuItemImpl.isActionViewExpanded()) {
      bool = true;
    } else {
      bool = false;
    } 
    view.setVisibility(bool);
    ActionMenuView actionMenuView = (ActionMenuView)paramViewGroup;
    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
    if (!actionMenuView.checkLayoutParams(layoutParams))
      view.setLayoutParams((ViewGroup.LayoutParams)actionMenuView.generateLayoutParams(layoutParams)); 
    return view;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup) {
    MenuView menuView2 = this.mMenuView;
    MenuView menuView1 = super.getMenuView(paramViewGroup);
    if (menuView2 != menuView1)
      ((ActionMenuView)menuView1).setPresenter(this); 
    return menuView1;
  }
  
  public Drawable getOverflowIcon() {
    OverflowMenuButton overflowMenuButton = this.mOverflowButton;
    return (overflowMenuButton != null) ? overflowMenuButton.getDrawable() : (this.mPendingOverflowIconSet ? this.mPendingOverflowIcon : null);
  }
  
  public boolean hideOverflowMenu() {
    if (this.mPostedOpenRunnable != null && this.mMenuView != null) {
      ((View)this.mMenuView).removeCallbacks(this.mPostedOpenRunnable);
      this.mPostedOpenRunnable = null;
      return true;
    } 
    OverflowPopup overflowPopup = this.mOverflowPopup;
    if (overflowPopup != null) {
      overflowPopup.dismiss();
      return true;
    } 
    return false;
  }
  
  public boolean hideSubMenus() {
    ActionButtonSubmenu actionButtonSubmenu = this.mActionButtonPopup;
    if (actionButtonSubmenu != null) {
      actionButtonSubmenu.dismiss();
      return true;
    } 
    return false;
  }
  
  public void initForMenu(@NonNull Context paramContext, @Nullable MenuBuilder paramMenuBuilder) {
    super.initForMenu(paramContext, paramMenuBuilder);
    Resources resources = paramContext.getResources();
    ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(paramContext);
    if (!this.mReserveOverflowSet)
      this.mReserveOverflow = actionBarPolicy.showsOverflowMenuButton(); 
    if (!this.mWidthLimitSet)
      this.mWidthLimit = actionBarPolicy.getEmbeddedMenuWidthLimit(); 
    if (!this.mMaxItemsSet)
      this.mMaxItems = actionBarPolicy.getMaxActionButtons(); 
    int i = this.mWidthLimit;
    if (this.mReserveOverflow) {
      if (this.mOverflowButton == null) {
        this.mOverflowButton = new OverflowMenuButton(this.mSystemContext);
        if (this.mPendingOverflowIconSet) {
          this.mOverflowButton.setImageDrawable(this.mPendingOverflowIcon);
          this.mPendingOverflowIcon = null;
          this.mPendingOverflowIconSet = false;
        } 
        int j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mOverflowButton.measure(j, j);
      } 
      i -= this.mOverflowButton.getMeasuredWidth();
    } else {
      this.mOverflowButton = null;
    } 
    this.mActionItemWidthLimit = i;
    this.mMinCellSize = (int)((resources.getDisplayMetrics()).density * 56.0F);
    this.mScrapActionButtonView = null;
  }
  
  public boolean isOverflowMenuShowPending() {
    return (this.mPostedOpenRunnable != null || isOverflowMenuShowing());
  }
  
  public boolean isOverflowMenuShowing() {
    boolean bool;
    OverflowPopup overflowPopup = this.mOverflowPopup;
    if (overflowPopup != null && overflowPopup.isShowing()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isOverflowReserved() {
    return this.mReserveOverflow;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {
    dismissPopupMenus();
    super.onCloseMenu(paramMenuBuilder, paramBoolean);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    if (!this.mMaxItemsSet)
      this.mMaxItems = ActionBarPolicy.get(this.mContext).getMaxActionButtons(); 
    if (this.mMenu != null)
      this.mMenu.onItemsChanged(true); 
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState))
      return; 
    paramParcelable = paramParcelable;
    if (((SavedState)paramParcelable).openSubMenuId > 0) {
      MenuItem menuItem = this.mMenu.findItem(((SavedState)paramParcelable).openSubMenuId);
      if (menuItem != null)
        onSubMenuSelected((SubMenuBuilder)menuItem.getSubMenu()); 
    } 
  }
  
  public Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState();
    savedState.openSubMenuId = this.mOpenSubMenuId;
    return savedState;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder) {
    boolean bool = paramSubMenuBuilder.hasVisibleItems();
    boolean bool1 = false;
    if (!bool)
      return false; 
    SubMenuBuilder subMenuBuilder;
    for (subMenuBuilder = paramSubMenuBuilder; subMenuBuilder.getParentMenu() != this.mMenu; subMenuBuilder = (SubMenuBuilder)subMenuBuilder.getParentMenu());
    View view = findViewForItem(subMenuBuilder.getItem());
    if (view == null)
      return false; 
    this.mOpenSubMenuId = paramSubMenuBuilder.getItem().getItemId();
    int i = paramSubMenuBuilder.size();
    byte b = 0;
    while (true) {
      bool = bool1;
      if (b < i) {
        MenuItem menuItem = paramSubMenuBuilder.getItem(b);
        if (menuItem.isVisible() && menuItem.getIcon() != null) {
          bool = true;
          break;
        } 
        b++;
        continue;
      } 
      break;
    } 
    this.mActionButtonPopup = new ActionButtonSubmenu(this.mContext, paramSubMenuBuilder, view);
    this.mActionButtonPopup.setForceShowIcon(bool);
    this.mActionButtonPopup.show();
    super.onSubMenuSelected(paramSubMenuBuilder);
    return true;
  }
  
  public void onSubUiVisibilityChanged(boolean paramBoolean) {
    if (paramBoolean) {
      super.onSubMenuSelected(null);
    } else if (this.mMenu != null) {
      this.mMenu.close(false);
    } 
  }
  
  public void setExpandedActionViewsExclusive(boolean paramBoolean) {
    this.mExpandedActionViewsExclusive = paramBoolean;
  }
  
  public void setItemLimit(int paramInt) {
    this.mMaxItems = paramInt;
    this.mMaxItemsSet = true;
  }
  
  public void setMenuView(ActionMenuView paramActionMenuView) {
    this.mMenuView = paramActionMenuView;
    paramActionMenuView.initialize(this.mMenu);
  }
  
  public void setOverflowIcon(Drawable paramDrawable) {
    OverflowMenuButton overflowMenuButton = this.mOverflowButton;
    if (overflowMenuButton != null) {
      overflowMenuButton.setImageDrawable(paramDrawable);
    } else {
      this.mPendingOverflowIconSet = true;
      this.mPendingOverflowIcon = paramDrawable;
    } 
  }
  
  public void setReserveOverflow(boolean paramBoolean) {
    this.mReserveOverflow = paramBoolean;
    this.mReserveOverflowSet = true;
  }
  
  public void setWidthLimit(int paramInt, boolean paramBoolean) {
    this.mWidthLimit = paramInt;
    this.mStrictWidthLimit = paramBoolean;
    this.mWidthLimitSet = true;
  }
  
  public boolean shouldIncludeItem(int paramInt, MenuItemImpl paramMenuItemImpl) {
    return paramMenuItemImpl.isActionButton();
  }
  
  public boolean showOverflowMenu() {
    if (this.mReserveOverflow && !isOverflowMenuShowing() && this.mMenu != null && this.mMenuView != null && this.mPostedOpenRunnable == null && !this.mMenu.getNonActionItems().isEmpty()) {
      this.mPostedOpenRunnable = new OpenOverflowRunnable(new OverflowPopup(this.mContext, this.mMenu, (View)this.mOverflowButton, true));
      ((View)this.mMenuView).post(this.mPostedOpenRunnable);
      super.onSubMenuSelected(null);
      return true;
    } 
    return false;
  }
  
  public void updateMenuView(boolean paramBoolean) {
    super.updateMenuView(paramBoolean);
    ((View)this.mMenuView).requestLayout();
    MenuBuilder<MenuItemImpl> menuBuilder = this.mMenu;
    byte b = 0;
    if (menuBuilder != null) {
      ArrayList<MenuItemImpl> arrayList = this.mMenu.getActionItems();
      int j = arrayList.size();
      for (byte b1 = 0; b1 < j; b1++) {
        ActionProvider actionProvider = ((MenuItemImpl)arrayList.get(b1)).getSupportActionProvider();
        if (actionProvider != null)
          actionProvider.setSubUiVisibilityListener(this); 
      } 
    } 
    if (this.mMenu != null) {
      ArrayList arrayList = this.mMenu.getNonActionItems();
    } else {
      menuBuilder = null;
    } 
    int i = b;
    if (this.mReserveOverflow) {
      i = b;
      if (menuBuilder != null) {
        int j = menuBuilder.size();
        if (j == 1) {
          i = ((MenuItemImpl)menuBuilder.get(0)).isActionViewExpanded() ^ true;
        } else {
          i = b;
          if (j > 0)
            i = 1; 
        } 
      } 
    } 
    if (i != 0) {
      if (this.mOverflowButton == null)
        this.mOverflowButton = new OverflowMenuButton(this.mSystemContext); 
      ViewGroup viewGroup = (ViewGroup)this.mOverflowButton.getParent();
      if (viewGroup != this.mMenuView) {
        if (viewGroup != null)
          viewGroup.removeView((View)this.mOverflowButton); 
        viewGroup = (ActionMenuView)this.mMenuView;
        viewGroup.addView((View)this.mOverflowButton, (ViewGroup.LayoutParams)viewGroup.generateOverflowButtonLayoutParams());
      } 
    } else {
      OverflowMenuButton overflowMenuButton = this.mOverflowButton;
      if (overflowMenuButton != null && overflowMenuButton.getParent() == this.mMenuView)
        ((ViewGroup)this.mMenuView).removeView((View)this.mOverflowButton); 
    } 
    ((ActionMenuView)this.mMenuView).setOverflowReserved(this.mReserveOverflow);
  }
  
  private class ActionButtonSubmenu extends MenuPopupHelper {
    public ActionButtonSubmenu(Context param1Context, SubMenuBuilder param1SubMenuBuilder, View param1View) {
      super(param1Context, (MenuBuilder)param1SubMenuBuilder, param1View, false, R.attr.actionOverflowMenuStyle);
      if (!((MenuItemImpl)param1SubMenuBuilder.getItem()).isActionButton()) {
        ActionMenuPresenter.OverflowMenuButton overflowMenuButton;
        if (ActionMenuPresenter.this.mOverflowButton == null) {
          View view = (View)ActionMenuPresenter.this.mMenuView;
        } else {
          overflowMenuButton = ActionMenuPresenter.this.mOverflowButton;
        } 
        setAnchorView((View)overflowMenuButton);
      } 
      setPresenterCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
    }
    
    protected void onDismiss() {
      ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
      actionMenuPresenter.mActionButtonPopup = null;
      actionMenuPresenter.mOpenSubMenuId = 0;
      super.onDismiss();
    }
  }
  
  private class ActionMenuPopupCallback extends ActionMenuItemView.PopupCallback {
    public ShowableListMenu getPopup() {
      ShowableListMenu showableListMenu;
      if (ActionMenuPresenter.this.mActionButtonPopup != null) {
        showableListMenu = (ShowableListMenu)ActionMenuPresenter.this.mActionButtonPopup.getPopup();
      } else {
        showableListMenu = null;
      } 
      return showableListMenu;
    }
  }
  
  private class OpenOverflowRunnable implements Runnable {
    private ActionMenuPresenter.OverflowPopup mPopup;
    
    public OpenOverflowRunnable(ActionMenuPresenter.OverflowPopup param1OverflowPopup) {
      this.mPopup = param1OverflowPopup;
    }
    
    public void run() {
      if (ActionMenuPresenter.this.mMenu != null)
        ActionMenuPresenter.this.mMenu.changeMenuMode(); 
      View view = (View)ActionMenuPresenter.this.mMenuView;
      if (view != null && view.getWindowToken() != null && this.mPopup.tryShow())
        ActionMenuPresenter.this.mOverflowPopup = this.mPopup; 
      ActionMenuPresenter.this.mPostedOpenRunnable = null;
    }
  }
  
  private class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {
    private final float[] mTempPts = new float[2];
    
    public OverflowMenuButton(Context param1Context) {
      super(param1Context, (AttributeSet)null, R.attr.actionOverflowButtonStyle);
      setClickable(true);
      setFocusable(true);
      setVisibility(0);
      setEnabled(true);
      TooltipCompat.setTooltipText((View)this, getContentDescription());
      setOnTouchListener(new ForwardingListener((View)this) {
            public ShowableListMenu getPopup() {
              return (ShowableListMenu)((ActionMenuPresenter.this.mOverflowPopup == null) ? null : ActionMenuPresenter.this.mOverflowPopup.getPopup());
            }
            
            public boolean onForwardingStarted() {
              ActionMenuPresenter.this.showOverflowMenu();
              return true;
            }
            
            public boolean onForwardingStopped() {
              if (ActionMenuPresenter.this.mPostedOpenRunnable != null)
                return false; 
              ActionMenuPresenter.this.hideOverflowMenu();
              return true;
            }
          });
    }
    
    public boolean needsDividerAfter() {
      return false;
    }
    
    public boolean needsDividerBefore() {
      return false;
    }
    
    public boolean performClick() {
      if (super.performClick())
        return true; 
      playSoundEffect(0);
      ActionMenuPresenter.this.showOverflowMenu();
      return true;
    }
    
    protected boolean setFrame(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      boolean bool = super.setFrame(param1Int1, param1Int2, param1Int3, param1Int4);
      Drawable drawable1 = getDrawable();
      Drawable drawable2 = getBackground();
      if (drawable1 != null && drawable2 != null) {
        int i = getWidth();
        param1Int2 = getHeight();
        param1Int1 = Math.max(i, param1Int2) / 2;
        int j = getPaddingLeft();
        int k = getPaddingRight();
        param1Int3 = getPaddingTop();
        param1Int4 = getPaddingBottom();
        i = (i + j - k) / 2;
        param1Int2 = (param1Int2 + param1Int3 - param1Int4) / 2;
        DrawableCompat.setHotspotBounds(drawable2, i - param1Int1, param1Int2 - param1Int1, i + param1Int1, param1Int2 + param1Int1);
      } 
      return bool;
    }
  }
  
  class null extends ForwardingListener {
    null(View param1View) {
      super(param1View);
    }
    
    public ShowableListMenu getPopup() {
      return (ShowableListMenu)((ActionMenuPresenter.this.mOverflowPopup == null) ? null : ActionMenuPresenter.this.mOverflowPopup.getPopup());
    }
    
    public boolean onForwardingStarted() {
      ActionMenuPresenter.this.showOverflowMenu();
      return true;
    }
    
    public boolean onForwardingStopped() {
      if (ActionMenuPresenter.this.mPostedOpenRunnable != null)
        return false; 
      ActionMenuPresenter.this.hideOverflowMenu();
      return true;
    }
  }
  
  private class OverflowPopup extends MenuPopupHelper {
    public OverflowPopup(Context param1Context, MenuBuilder param1MenuBuilder, View param1View, boolean param1Boolean) {
      super(param1Context, param1MenuBuilder, param1View, param1Boolean, R.attr.actionOverflowMenuStyle);
      setGravity(8388613);
      setPresenterCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
    }
    
    protected void onDismiss() {
      if (ActionMenuPresenter.this.mMenu != null)
        ActionMenuPresenter.this.mMenu.close(); 
      ActionMenuPresenter.this.mOverflowPopup = null;
      super.onDismiss();
    }
  }
  
  private class PopupPresenterCallback implements MenuPresenter.Callback {
    public void onCloseMenu(MenuBuilder param1MenuBuilder, boolean param1Boolean) {
      if (param1MenuBuilder instanceof SubMenuBuilder)
        param1MenuBuilder.getRootMenu().close(false); 
      MenuPresenter.Callback callback = ActionMenuPresenter.this.getCallback();
      if (callback != null)
        callback.onCloseMenu(param1MenuBuilder, param1Boolean); 
    }
    
    public boolean onOpenSubMenu(MenuBuilder param1MenuBuilder) {
      boolean bool = false;
      if (param1MenuBuilder == null)
        return false; 
      ActionMenuPresenter.this.mOpenSubMenuId = ((SubMenuBuilder)param1MenuBuilder).getItem().getItemId();
      MenuPresenter.Callback callback = ActionMenuPresenter.this.getCallback();
      if (callback != null)
        bool = callback.onOpenSubMenu(param1MenuBuilder); 
      return bool;
    }
  }
  
  private static class SavedState implements Parcelable {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
        public ActionMenuPresenter.SavedState createFromParcel(Parcel param2Parcel) {
          return new ActionMenuPresenter.SavedState(param2Parcel);
        }
        
        public ActionMenuPresenter.SavedState[] newArray(int param2Int) {
          return new ActionMenuPresenter.SavedState[param2Int];
        }
      };
    
    public int openSubMenuId;
    
    SavedState() {}
    
    SavedState(Parcel param1Parcel) {
      this.openSubMenuId = param1Parcel.readInt();
    }
    
    public int describeContents() {
      return 0;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      param1Parcel.writeInt(this.openSubMenuId);
    }
  }
  
  static final class null implements Parcelable.Creator<SavedState> {
    public ActionMenuPresenter.SavedState createFromParcel(Parcel param1Parcel) {
      return new ActionMenuPresenter.SavedState(param1Parcel);
    }
    
    public ActionMenuPresenter.SavedState[] newArray(int param1Int) {
      return new ActionMenuPresenter.SavedState[param1Int];
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\v7\widget\ActionMenuPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */