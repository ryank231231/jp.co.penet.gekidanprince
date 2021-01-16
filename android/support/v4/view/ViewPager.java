package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.CallSuper;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
  private static final int CLOSE_ENOUGH = 2;
  
  private static final Comparator<ItemInfo> COMPARATOR;
  
  private static final boolean DEBUG = false;
  
  private static final int DEFAULT_GUTTER_SIZE = 16;
  
  private static final int DEFAULT_OFFSCREEN_PAGES = 1;
  
  private static final int DRAW_ORDER_DEFAULT = 0;
  
  private static final int DRAW_ORDER_FORWARD = 1;
  
  private static final int DRAW_ORDER_REVERSE = 2;
  
  private static final int INVALID_POINTER = -1;
  
  static final int[] LAYOUT_ATTRS = new int[] { 16842931 };
  
  private static final int MAX_SETTLE_DURATION = 600;
  
  private static final int MIN_DISTANCE_FOR_FLING = 25;
  
  private static final int MIN_FLING_VELOCITY = 400;
  
  public static final int SCROLL_STATE_DRAGGING = 1;
  
  public static final int SCROLL_STATE_IDLE = 0;
  
  public static final int SCROLL_STATE_SETTLING = 2;
  
  private static final String TAG = "ViewPager";
  
  private static final boolean USE_CACHE = false;
  
  private static final Interpolator sInterpolator;
  
  private static final ViewPositionComparator sPositionComparator;
  
  private int mActivePointerId = -1;
  
  PagerAdapter mAdapter;
  
  private List<OnAdapterChangeListener> mAdapterChangeListeners;
  
  private int mBottomPageBounds;
  
  private boolean mCalledSuper;
  
  private int mChildHeightMeasureSpec;
  
  private int mChildWidthMeasureSpec;
  
  private int mCloseEnough;
  
  int mCurItem;
  
  private int mDecorChildCount;
  
  private int mDefaultGutterSize;
  
  private int mDrawingOrder;
  
  private ArrayList<View> mDrawingOrderedChildren;
  
  private final Runnable mEndScrollRunnable = new Runnable() {
      public void run() {
        ViewPager.this.setScrollState(0);
        ViewPager.this.populate();
      }
    };
  
  private int mExpectedAdapterCount;
  
  private long mFakeDragBeginTime;
  
  private boolean mFakeDragging;
  
  private boolean mFirstLayout = true;
  
  private float mFirstOffset = -3.4028235E38F;
  
  private int mFlingDistance;
  
  private int mGutterSize;
  
  private boolean mInLayout;
  
  private float mInitialMotionX;
  
  private float mInitialMotionY;
  
  private OnPageChangeListener mInternalPageChangeListener;
  
  private boolean mIsBeingDragged;
  
  private boolean mIsScrollStarted;
  
  private boolean mIsUnableToDrag;
  
  private final ArrayList<ItemInfo> mItems = new ArrayList<ItemInfo>();
  
  private float mLastMotionX;
  
  private float mLastMotionY;
  
  private float mLastOffset = Float.MAX_VALUE;
  
  private EdgeEffect mLeftEdge;
  
  private Drawable mMarginDrawable;
  
  private int mMaximumVelocity;
  
  private int mMinimumVelocity;
  
  private boolean mNeedCalculatePageOffsets = false;
  
  private PagerObserver mObserver;
  
  private int mOffscreenPageLimit = 1;
  
  private OnPageChangeListener mOnPageChangeListener;
  
  private List<OnPageChangeListener> mOnPageChangeListeners;
  
  private int mPageMargin;
  
  private PageTransformer mPageTransformer;
  
  private int mPageTransformerLayerType;
  
  private boolean mPopulatePending;
  
  private Parcelable mRestoredAdapterState = null;
  
  private ClassLoader mRestoredClassLoader = null;
  
  private int mRestoredCurItem = -1;
  
  private EdgeEffect mRightEdge;
  
  private int mScrollState = 0;
  
  private Scroller mScroller;
  
  private boolean mScrollingCacheEnabled;
  
  private final ItemInfo mTempItem = new ItemInfo();
  
  private final Rect mTempRect = new Rect();
  
  private int mTopPageBounds;
  
  private int mTouchSlop;
  
  private VelocityTracker mVelocityTracker;
  
  static {
    COMPARATOR = new Comparator<ItemInfo>() {
        public int compare(ViewPager.ItemInfo param1ItemInfo1, ViewPager.ItemInfo param1ItemInfo2) {
          return param1ItemInfo1.position - param1ItemInfo2.position;
        }
      };
    sInterpolator = new Interpolator() {
        public float getInterpolation(float param1Float) {
          param1Float--;
          return param1Float * param1Float * param1Float * param1Float * param1Float + 1.0F;
        }
      };
    sPositionComparator = new ViewPositionComparator();
  }
  
  public ViewPager(@NonNull Context paramContext) {
    super(paramContext);
    initViewPager();
  }
  
  public ViewPager(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    initViewPager();
  }
  
  private void calculatePageOffsets(ItemInfo paramItemInfo1, int paramInt, ItemInfo paramItemInfo2) {
    float f1;
    int i = this.mAdapter.getCount();
    int j = getClientWidth();
    if (j > 0) {
      f1 = this.mPageMargin / j;
    } else {
      f1 = 0.0F;
    } 
    if (paramItemInfo2 != null) {
      j = paramItemInfo2.position;
      if (j < paramItemInfo1.position) {
        f2 = paramItemInfo2.offset + paramItemInfo2.widthFactor + f1;
        j++;
        byte b = 0;
        while (j <= paramItemInfo1.position && b < this.mItems.size()) {
          int n;
          float f;
          paramItemInfo2 = this.mItems.get(b);
          while (true) {
            n = j;
            f = f2;
            if (j > paramItemInfo2.position) {
              n = j;
              f = f2;
              if (b < this.mItems.size() - 1) {
                paramItemInfo2 = this.mItems.get(++b);
                continue;
              } 
            } 
            break;
          } 
          while (n < paramItemInfo2.position) {
            f += this.mAdapter.getPageWidth(n) + f1;
            n++;
          } 
          paramItemInfo2.offset = f;
          f2 = f + paramItemInfo2.widthFactor + f1;
          j = n + 1;
        } 
      } else if (j > paramItemInfo1.position) {
        int n = this.mItems.size() - 1;
        f2 = paramItemInfo2.offset;
        while (--j >= paramItemInfo1.position && n >= 0) {
          int i1;
          float f;
          paramItemInfo2 = this.mItems.get(n);
          while (true) {
            i1 = j;
            f = f2;
            if (j < paramItemInfo2.position) {
              i1 = j;
              f = f2;
              if (n > 0) {
                paramItemInfo2 = this.mItems.get(--n);
                continue;
              } 
            } 
            break;
          } 
          while (i1 > paramItemInfo2.position) {
            f -= this.mAdapter.getPageWidth(i1) + f1;
            i1--;
          } 
          f2 = f - paramItemInfo2.widthFactor + f1;
          paramItemInfo2.offset = f2;
          j = i1 - 1;
        } 
      } 
    } 
    int m = this.mItems.size();
    float f3 = paramItemInfo1.offset;
    j = paramItemInfo1.position - 1;
    if (paramItemInfo1.position == 0) {
      f2 = paramItemInfo1.offset;
    } else {
      f2 = -3.4028235E38F;
    } 
    this.mFirstOffset = f2;
    int k = paramItemInfo1.position;
    if (k == --i) {
      f2 = paramItemInfo1.offset + paramItemInfo1.widthFactor - 1.0F;
    } else {
      f2 = Float.MAX_VALUE;
    } 
    this.mLastOffset = f2;
    k = paramInt - 1;
    float f2 = f3;
    while (k >= 0) {
      paramItemInfo2 = this.mItems.get(k);
      while (j > paramItemInfo2.position) {
        f2 -= this.mAdapter.getPageWidth(j) + f1;
        j--;
      } 
      f2 -= paramItemInfo2.widthFactor + f1;
      paramItemInfo2.offset = f2;
      if (paramItemInfo2.position == 0)
        this.mFirstOffset = f2; 
      k--;
      j--;
    } 
    f2 = paramItemInfo1.offset + paramItemInfo1.widthFactor + f1;
    k = paramItemInfo1.position + 1;
    j = paramInt + 1;
    for (paramInt = k; j < m; paramInt++) {
      paramItemInfo1 = this.mItems.get(j);
      while (paramInt < paramItemInfo1.position) {
        f2 += this.mAdapter.getPageWidth(paramInt) + f1;
        paramInt++;
      } 
      if (paramItemInfo1.position == i)
        this.mLastOffset = paramItemInfo1.widthFactor + f2 - 1.0F; 
      paramItemInfo1.offset = f2;
      f2 += paramItemInfo1.widthFactor + f1;
      j++;
    } 
    this.mNeedCalculatePageOffsets = false;
  }
  
  private void completeScroll(boolean paramBoolean) {
    if (this.mScrollState == 2) {
      b1 = 1;
    } else {
      b1 = 0;
    } 
    if (b1) {
      setScrollingCacheEnabled(false);
      if ((this.mScroller.isFinished() ^ true) != 0) {
        this.mScroller.abortAnimation();
        int i = getScrollX();
        int j = getScrollY();
        int k = this.mScroller.getCurrX();
        int m = this.mScroller.getCurrY();
        if (i != k || j != m) {
          scrollTo(k, m);
          if (k != i)
            pageScrolled(k); 
        } 
      } 
    } 
    this.mPopulatePending = false;
    byte b3 = 0;
    byte b2 = b1;
    for (byte b1 = b3; b1 < this.mItems.size(); b1++) {
      ItemInfo itemInfo = this.mItems.get(b1);
      if (itemInfo.scrolling) {
        itemInfo.scrolling = false;
        b2 = 1;
      } 
    } 
    if (b2 != 0)
      if (paramBoolean) {
        ViewCompat.postOnAnimation((View)this, this.mEndScrollRunnable);
      } else {
        this.mEndScrollRunnable.run();
      }  
  }
  
  private int determineTargetPage(int paramInt1, float paramFloat, int paramInt2, int paramInt3) {
    if (Math.abs(paramInt3) > this.mFlingDistance && Math.abs(paramInt2) > this.mMinimumVelocity) {
      if (paramInt2 <= 0)
        paramInt1++; 
    } else {
      float f;
      if (paramInt1 >= this.mCurItem) {
        f = 0.4F;
      } else {
        f = 0.6F;
      } 
      paramInt1 += (int)(paramFloat + f);
    } 
    paramInt2 = paramInt1;
    if (this.mItems.size() > 0) {
      ItemInfo itemInfo1 = this.mItems.get(0);
      ArrayList<ItemInfo> arrayList = this.mItems;
      ItemInfo itemInfo2 = arrayList.get(arrayList.size() - 1);
      paramInt2 = Math.max(itemInfo1.position, Math.min(paramInt1, itemInfo2.position));
    } 
    return paramInt2;
  }
  
  private void dispatchOnPageScrolled(int paramInt1, float paramFloat, int paramInt2) {
    OnPageChangeListener onPageChangeListener2 = this.mOnPageChangeListener;
    if (onPageChangeListener2 != null)
      onPageChangeListener2.onPageScrolled(paramInt1, paramFloat, paramInt2); 
    List<OnPageChangeListener> list = this.mOnPageChangeListeners;
    if (list != null) {
      byte b = 0;
      int i = list.size();
      while (b < i) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListeners.get(b);
        if (onPageChangeListener != null)
          onPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2); 
        b++;
      } 
    } 
    OnPageChangeListener onPageChangeListener1 = this.mInternalPageChangeListener;
    if (onPageChangeListener1 != null)
      onPageChangeListener1.onPageScrolled(paramInt1, paramFloat, paramInt2); 
  }
  
  private void dispatchOnPageSelected(int paramInt) {
    OnPageChangeListener onPageChangeListener2 = this.mOnPageChangeListener;
    if (onPageChangeListener2 != null)
      onPageChangeListener2.onPageSelected(paramInt); 
    List<OnPageChangeListener> list = this.mOnPageChangeListeners;
    if (list != null) {
      byte b = 0;
      int i = list.size();
      while (b < i) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListeners.get(b);
        if (onPageChangeListener != null)
          onPageChangeListener.onPageSelected(paramInt); 
        b++;
      } 
    } 
    OnPageChangeListener onPageChangeListener1 = this.mInternalPageChangeListener;
    if (onPageChangeListener1 != null)
      onPageChangeListener1.onPageSelected(paramInt); 
  }
  
  private void dispatchOnScrollStateChanged(int paramInt) {
    OnPageChangeListener onPageChangeListener2 = this.mOnPageChangeListener;
    if (onPageChangeListener2 != null)
      onPageChangeListener2.onPageScrollStateChanged(paramInt); 
    List<OnPageChangeListener> list = this.mOnPageChangeListeners;
    if (list != null) {
      byte b = 0;
      int i = list.size();
      while (b < i) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListeners.get(b);
        if (onPageChangeListener != null)
          onPageChangeListener.onPageScrollStateChanged(paramInt); 
        b++;
      } 
    } 
    OnPageChangeListener onPageChangeListener1 = this.mInternalPageChangeListener;
    if (onPageChangeListener1 != null)
      onPageChangeListener1.onPageScrollStateChanged(paramInt); 
  }
  
  private void enableLayers(boolean paramBoolean) {
    int i = getChildCount();
    for (byte b = 0; b < i; b++) {
      boolean bool;
      if (paramBoolean) {
        bool = this.mPageTransformerLayerType;
      } else {
        bool = false;
      } 
      getChildAt(b).setLayerType(bool, null);
    } 
  }
  
  private void endDrag() {
    this.mIsBeingDragged = false;
    this.mIsUnableToDrag = false;
    VelocityTracker velocityTracker = this.mVelocityTracker;
    if (velocityTracker != null) {
      velocityTracker.recycle();
      this.mVelocityTracker = null;
    } 
  }
  
  private Rect getChildRectInPagerCoordinates(Rect paramRect, View paramView) {
    Rect rect = paramRect;
    if (paramRect == null)
      rect = new Rect(); 
    if (paramView == null) {
      rect.set(0, 0, 0, 0);
      return rect;
    } 
    rect.left = paramView.getLeft();
    rect.right = paramView.getRight();
    rect.top = paramView.getTop();
    rect.bottom = paramView.getBottom();
    ViewParent viewParent = paramView.getParent();
    while (viewParent instanceof ViewGroup && viewParent != this) {
      ViewGroup viewGroup = (ViewGroup)viewParent;
      rect.left += viewGroup.getLeft();
      rect.right += viewGroup.getRight();
      rect.top += viewGroup.getTop();
      rect.bottom += viewGroup.getBottom();
      ViewParent viewParent1 = viewGroup.getParent();
    } 
    return rect;
  }
  
  private int getClientWidth() {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private ItemInfo infoForCurrentScrollPosition() {
    float f1;
    float f2;
    int i = getClientWidth();
    if (i > 0) {
      f1 = getScrollX() / i;
    } else {
      f1 = 0.0F;
    } 
    if (i > 0) {
      f2 = this.mPageMargin / i;
    } else {
      f2 = 0.0F;
    } 
    ItemInfo itemInfo = null;
    i = 0;
    boolean bool = true;
    int j = -1;
    float f3 = 0.0F;
    float f4 = 0.0F;
    while (i < this.mItems.size()) {
      ItemInfo itemInfo1 = this.mItems.get(i);
      int k = i;
      ItemInfo itemInfo2 = itemInfo1;
      if (!bool) {
        int m = itemInfo1.position;
        j++;
        k = i;
        itemInfo2 = itemInfo1;
        if (m != j) {
          itemInfo2 = this.mTempItem;
          itemInfo2.offset = f3 + f4 + f2;
          itemInfo2.position = j;
          itemInfo2.widthFactor = this.mAdapter.getPageWidth(itemInfo2.position);
          k = i - 1;
        } 
      } 
      f3 = itemInfo2.offset;
      f4 = itemInfo2.widthFactor;
      if (bool || f1 >= f3) {
        if (f1 < f4 + f3 + f2 || k == this.mItems.size() - 1)
          return itemInfo2; 
        j = itemInfo2.position;
        f4 = itemInfo2.widthFactor;
        i = k + 1;
        bool = false;
        itemInfo = itemInfo2;
        continue;
      } 
      return itemInfo;
    } 
    return itemInfo;
  }
  
  private static boolean isDecorView(@NonNull View paramView) {
    boolean bool;
    if (paramView.getClass().getAnnotation(DecorView.class) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private boolean isGutterDrag(float paramFloat1, float paramFloat2) {
    boolean bool;
    if ((paramFloat1 < this.mGutterSize && paramFloat2 > 0.0F) || (paramFloat1 > (getWidth() - this.mGutterSize) && paramFloat2 < 0.0F)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId) {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      } 
      this.mLastMotionX = paramMotionEvent.getX(i);
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
      VelocityTracker velocityTracker = this.mVelocityTracker;
      if (velocityTracker != null)
        velocityTracker.clear(); 
    } 
  }
  
  private boolean pageScrolled(int paramInt) {
    if (this.mItems.size() == 0) {
      if (this.mFirstLayout)
        return false; 
      this.mCalledSuper = false;
      onPageScrolled(0, 0.0F, 0);
      if (this.mCalledSuper)
        return false; 
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    } 
    ItemInfo itemInfo = infoForCurrentScrollPosition();
    int i = getClientWidth();
    int j = this.mPageMargin;
    float f1 = j;
    float f2 = i;
    f1 /= f2;
    int k = itemInfo.position;
    f2 = (paramInt / f2 - itemInfo.offset) / (itemInfo.widthFactor + f1);
    paramInt = (int)((i + j) * f2);
    this.mCalledSuper = false;
    onPageScrolled(k, f2, paramInt);
    if (this.mCalledSuper)
      return true; 
    throw new IllegalStateException("onPageScrolled did not call superclass implementation");
  }
  
  private boolean performDrag(float paramFloat) {
    boolean bool4;
    float f1 = this.mLastMotionX;
    this.mLastMotionX = paramFloat;
    float f2 = getScrollX() + f1 - paramFloat;
    float f3 = getClientWidth();
    paramFloat = this.mFirstOffset * f3;
    f1 = this.mLastOffset * f3;
    ArrayList<ItemInfo> arrayList1 = this.mItems;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    ItemInfo itemInfo1 = arrayList1.get(0);
    ArrayList<ItemInfo> arrayList2 = this.mItems;
    ItemInfo itemInfo2 = arrayList2.get(arrayList2.size() - 1);
    if (itemInfo1.position != 0) {
      paramFloat = itemInfo1.offset * f3;
      i = 0;
    } else {
      i = 1;
    } 
    if (itemInfo2.position != this.mAdapter.getCount() - 1) {
      f1 = itemInfo2.offset * f3;
      bool4 = false;
    } else {
      bool4 = true;
    } 
    if (f2 < paramFloat) {
      if (i) {
        this.mLeftEdge.onPull(Math.abs(paramFloat - f2) / f3);
        bool3 = true;
      } 
    } else {
      bool3 = bool2;
      paramFloat = f2;
      if (f2 > f1) {
        bool3 = bool1;
        if (bool4) {
          this.mRightEdge.onPull(Math.abs(f2 - f1) / f3);
          bool3 = true;
        } 
        paramFloat = f1;
      } 
    } 
    f1 = this.mLastMotionX;
    int i = (int)paramFloat;
    this.mLastMotionX = f1 + paramFloat - i;
    scrollTo(i, getScrollY());
    pageScrolled(i);
    return bool3;
  }
  
  private void recomputeScrollPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (paramInt2 > 0 && !this.mItems.isEmpty()) {
      if (!this.mScroller.isFinished()) {
        this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
      } else {
        int i = getPaddingLeft();
        int j = getPaddingRight();
        int k = getPaddingLeft();
        int m = getPaddingRight();
        scrollTo((int)(getScrollX() / (paramInt2 - k - m + paramInt4) * (paramInt1 - i - j + paramInt3)), getScrollY());
      } 
    } else {
      float f;
      ItemInfo itemInfo = infoForPosition(this.mCurItem);
      if (itemInfo != null) {
        f = Math.min(itemInfo.offset, this.mLastOffset);
      } else {
        f = 0.0F;
      } 
      paramInt1 = (int)(f * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 != getScrollX()) {
        completeScroll(false);
        scrollTo(paramInt1, getScrollY());
      } 
    } 
  }
  
  private void removeNonDecorViews() {
    for (int i = 0; i < getChildCount(); i = j + 1) {
      int j = i;
      if (!((LayoutParams)getChildAt(i).getLayoutParams()).isDecor) {
        removeViewAt(i);
        j = i - 1;
      } 
    } 
  }
  
  private void requestParentDisallowInterceptTouchEvent(boolean paramBoolean) {
    ViewParent viewParent = getParent();
    if (viewParent != null)
      viewParent.requestDisallowInterceptTouchEvent(paramBoolean); 
  }
  
  private boolean resetTouch() {
    this.mActivePointerId = -1;
    endDrag();
    this.mLeftEdge.onRelease();
    this.mRightEdge.onRelease();
    return (this.mLeftEdge.isFinished() || this.mRightEdge.isFinished());
  }
  
  private void scrollToItem(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2) {
    boolean bool;
    ItemInfo itemInfo = infoForPosition(paramInt1);
    if (itemInfo != null) {
      bool = (int)(getClientWidth() * Math.max(this.mFirstOffset, Math.min(itemInfo.offset, this.mLastOffset)));
    } else {
      bool = false;
    } 
    if (paramBoolean1) {
      smoothScrollTo(bool, 0, paramInt2);
      if (paramBoolean2)
        dispatchOnPageSelected(paramInt1); 
    } else {
      if (paramBoolean2)
        dispatchOnPageSelected(paramInt1); 
      completeScroll(false);
      scrollTo(bool, 0);
      pageScrolled(bool);
    } 
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean) {
    if (this.mScrollingCacheEnabled != paramBoolean)
      this.mScrollingCacheEnabled = paramBoolean; 
  }
  
  private void sortChildDrawingOrder() {
    if (this.mDrawingOrder != 0) {
      ArrayList<View> arrayList = this.mDrawingOrderedChildren;
      if (arrayList == null) {
        this.mDrawingOrderedChildren = new ArrayList<View>();
      } else {
        arrayList.clear();
      } 
      int i = getChildCount();
      for (byte b = 0; b < i; b++) {
        View view = getChildAt(b);
        this.mDrawingOrderedChildren.add(view);
      } 
      Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
    } 
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2) {
    int i = paramArrayList.size();
    int j = getDescendantFocusability();
    if (j != 393216)
      for (byte b = 0; b < getChildCount(); b++) {
        View view = getChildAt(b);
        if (view.getVisibility() == 0) {
          ItemInfo itemInfo = infoForChild(view);
          if (itemInfo != null && itemInfo.position == this.mCurItem)
            view.addFocusables(paramArrayList, paramInt1, paramInt2); 
        } 
      }  
    if (j != 262144 || i == paramArrayList.size()) {
      if (!isFocusable())
        return; 
      if ((paramInt2 & 0x1) == 1 && isInTouchMode() && !isFocusableInTouchMode())
        return; 
      if (paramArrayList != null)
        paramArrayList.add(this); 
    } 
  }
  
  ItemInfo addNewItem(int paramInt1, int paramInt2) {
    ItemInfo itemInfo = new ItemInfo();
    itemInfo.position = paramInt1;
    itemInfo.object = this.mAdapter.instantiateItem(this, paramInt1);
    itemInfo.widthFactor = this.mAdapter.getPageWidth(paramInt1);
    if (paramInt2 < 0 || paramInt2 >= this.mItems.size()) {
      this.mItems.add(itemInfo);
      return itemInfo;
    } 
    this.mItems.add(paramInt2, itemInfo);
    return itemInfo;
  }
  
  public void addOnAdapterChangeListener(@NonNull OnAdapterChangeListener paramOnAdapterChangeListener) {
    if (this.mAdapterChangeListeners == null)
      this.mAdapterChangeListeners = new ArrayList<OnAdapterChangeListener>(); 
    this.mAdapterChangeListeners.add(paramOnAdapterChangeListener);
  }
  
  public void addOnPageChangeListener(@NonNull OnPageChangeListener paramOnPageChangeListener) {
    if (this.mOnPageChangeListeners == null)
      this.mOnPageChangeListeners = new ArrayList<OnPageChangeListener>(); 
    this.mOnPageChangeListeners.add(paramOnPageChangeListener);
  }
  
  public void addTouchables(ArrayList<View> paramArrayList) {
    for (byte b = 0; b < getChildCount(); b++) {
      View view = getChildAt(b);
      if (view.getVisibility() == 0) {
        ItemInfo itemInfo = infoForChild(view);
        if (itemInfo != null && itemInfo.position == this.mCurItem)
          view.addTouchables(paramArrayList); 
      } 
    } 
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
    ViewGroup.LayoutParams layoutParams = paramLayoutParams;
    if (!checkLayoutParams(paramLayoutParams))
      layoutParams = generateLayoutParams(paramLayoutParams); 
    paramLayoutParams = layoutParams;
    ((LayoutParams)paramLayoutParams).isDecor |= isDecorView(paramView);
    if (this.mInLayout) {
      if (paramLayoutParams == null || !((LayoutParams)paramLayoutParams).isDecor) {
        ((LayoutParams)paramLayoutParams).needsMeasure = true;
        addViewInLayout(paramView, paramInt, layoutParams);
        return;
      } 
      throw new IllegalStateException("Cannot add pager decor view during layout");
    } 
    super.addView(paramView, paramInt, layoutParams);
  }
  
  public boolean arrowScroll(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual findFocus : ()Landroid/view/View;
    //   4: astore_2
    //   5: iconst_0
    //   6: istore_3
    //   7: aconst_null
    //   8: astore #4
    //   10: aload_2
    //   11: aload_0
    //   12: if_acmpne -> 22
    //   15: aload #4
    //   17: astore #5
    //   19: goto -> 193
    //   22: aload_2
    //   23: ifnull -> 190
    //   26: aload_2
    //   27: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   30: astore #5
    //   32: aload #5
    //   34: instanceof android/view/ViewGroup
    //   37: ifeq -> 64
    //   40: aload #5
    //   42: aload_0
    //   43: if_acmpne -> 52
    //   46: iconst_1
    //   47: istore #6
    //   49: goto -> 67
    //   52: aload #5
    //   54: invokeinterface getParent : ()Landroid/view/ViewParent;
    //   59: astore #5
    //   61: goto -> 32
    //   64: iconst_0
    //   65: istore #6
    //   67: iload #6
    //   69: ifne -> 190
    //   72: new java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial <init> : ()V
    //   79: astore #7
    //   81: aload #7
    //   83: aload_2
    //   84: invokevirtual getClass : ()Ljava/lang/Class;
    //   87: invokevirtual getSimpleName : ()Ljava/lang/String;
    //   90: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_2
    //   95: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   98: astore #5
    //   100: aload #5
    //   102: instanceof android/view/ViewGroup
    //   105: ifeq -> 143
    //   108: aload #7
    //   110: ldc_w ' => '
    //   113: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload #7
    //   119: aload #5
    //   121: invokevirtual getClass : ()Ljava/lang/Class;
    //   124: invokevirtual getSimpleName : ()Ljava/lang/String;
    //   127: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload #5
    //   133: invokeinterface getParent : ()Landroid/view/ViewParent;
    //   138: astore #5
    //   140: goto -> 100
    //   143: new java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial <init> : ()V
    //   150: astore #5
    //   152: aload #5
    //   154: ldc_w 'arrowScroll tried to find focus based on non-child current focused view '
    //   157: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload #5
    //   163: aload #7
    //   165: invokevirtual toString : ()Ljava/lang/String;
    //   168: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: ldc 'ViewPager'
    //   174: aload #5
    //   176: invokevirtual toString : ()Ljava/lang/String;
    //   179: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   182: pop
    //   183: aload #4
    //   185: astore #5
    //   187: goto -> 193
    //   190: aload_2
    //   191: astore #5
    //   193: invokestatic getInstance : ()Landroid/view/FocusFinder;
    //   196: aload_0
    //   197: aload #5
    //   199: iload_1
    //   200: invokevirtual findNextFocus : (Landroid/view/ViewGroup;Landroid/view/View;I)Landroid/view/View;
    //   203: astore #4
    //   205: aload #4
    //   207: ifnull -> 347
    //   210: aload #4
    //   212: aload #5
    //   214: if_acmpeq -> 347
    //   217: iload_1
    //   218: bipush #17
    //   220: if_icmpne -> 282
    //   223: aload_0
    //   224: aload_0
    //   225: getfield mTempRect : Landroid/graphics/Rect;
    //   228: aload #4
    //   230: invokespecial getChildRectInPagerCoordinates : (Landroid/graphics/Rect;Landroid/view/View;)Landroid/graphics/Rect;
    //   233: getfield left : I
    //   236: istore #8
    //   238: aload_0
    //   239: aload_0
    //   240: getfield mTempRect : Landroid/graphics/Rect;
    //   243: aload #5
    //   245: invokespecial getChildRectInPagerCoordinates : (Landroid/graphics/Rect;Landroid/view/View;)Landroid/graphics/Rect;
    //   248: getfield left : I
    //   251: istore #6
    //   253: aload #5
    //   255: ifnull -> 273
    //   258: iload #8
    //   260: iload #6
    //   262: if_icmplt -> 273
    //   265: aload_0
    //   266: invokevirtual pageLeft : ()Z
    //   269: istore_3
    //   270: goto -> 385
    //   273: aload #4
    //   275: invokevirtual requestFocus : ()Z
    //   278: istore_3
    //   279: goto -> 385
    //   282: iload_1
    //   283: bipush #66
    //   285: if_icmpne -> 385
    //   288: aload_0
    //   289: aload_0
    //   290: getfield mTempRect : Landroid/graphics/Rect;
    //   293: aload #4
    //   295: invokespecial getChildRectInPagerCoordinates : (Landroid/graphics/Rect;Landroid/view/View;)Landroid/graphics/Rect;
    //   298: getfield left : I
    //   301: istore #8
    //   303: aload_0
    //   304: aload_0
    //   305: getfield mTempRect : Landroid/graphics/Rect;
    //   308: aload #5
    //   310: invokespecial getChildRectInPagerCoordinates : (Landroid/graphics/Rect;Landroid/view/View;)Landroid/graphics/Rect;
    //   313: getfield left : I
    //   316: istore #6
    //   318: aload #5
    //   320: ifnull -> 338
    //   323: iload #8
    //   325: iload #6
    //   327: if_icmpgt -> 338
    //   330: aload_0
    //   331: invokevirtual pageRight : ()Z
    //   334: istore_3
    //   335: goto -> 385
    //   338: aload #4
    //   340: invokevirtual requestFocus : ()Z
    //   343: istore_3
    //   344: goto -> 385
    //   347: iload_1
    //   348: bipush #17
    //   350: if_icmpeq -> 380
    //   353: iload_1
    //   354: iconst_1
    //   355: if_icmpne -> 361
    //   358: goto -> 380
    //   361: iload_1
    //   362: bipush #66
    //   364: if_icmpeq -> 372
    //   367: iload_1
    //   368: iconst_2
    //   369: if_icmpne -> 385
    //   372: aload_0
    //   373: invokevirtual pageRight : ()Z
    //   376: istore_3
    //   377: goto -> 385
    //   380: aload_0
    //   381: invokevirtual pageLeft : ()Z
    //   384: istore_3
    //   385: iload_3
    //   386: ifeq -> 397
    //   389: aload_0
    //   390: iload_1
    //   391: invokestatic getContantForFocusDirection : (I)I
    //   394: invokevirtual playSoundEffect : (I)V
    //   397: iload_3
    //   398: ireturn
  }
  
  public boolean beginFakeDrag() {
    if (this.mIsBeingDragged)
      return false; 
    this.mFakeDragging = true;
    setScrollState(1);
    this.mLastMotionX = 0.0F;
    this.mInitialMotionX = 0.0F;
    VelocityTracker velocityTracker = this.mVelocityTracker;
    if (velocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    } else {
      velocityTracker.clear();
    } 
    long l = SystemClock.uptimeMillis();
    MotionEvent motionEvent = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
    this.mVelocityTracker.addMovement(motionEvent);
    motionEvent.recycle();
    this.mFakeDragBeginTime = l;
    return true;
  }
  
  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3) {
    boolean bool = paramView instanceof ViewGroup;
    boolean bool1 = true;
    if (bool) {
      ViewGroup viewGroup = (ViewGroup)paramView;
      int i = paramView.getScrollX();
      int j = paramView.getScrollY();
      for (int k = viewGroup.getChildCount() - 1; k >= 0; k--) {
        View view = viewGroup.getChildAt(k);
        int m = paramInt2 + i;
        if (m >= view.getLeft() && m < view.getRight()) {
          int n = paramInt3 + j;
          if (n >= view.getTop() && n < view.getBottom() && canScroll(view, true, paramInt1, m - view.getLeft(), n - view.getTop()))
            return true; 
        } 
      } 
    } 
    if (paramBoolean && paramView.canScrollHorizontally(-paramInt1)) {
      paramBoolean = bool1;
    } else {
      paramBoolean = false;
    } 
    return paramBoolean;
  }
  
  public boolean canScrollHorizontally(int paramInt) {
    PagerAdapter pagerAdapter = this.mAdapter;
    boolean bool1 = false;
    boolean bool2 = false;
    if (pagerAdapter == null)
      return false; 
    int i = getClientWidth();
    int j = getScrollX();
    if (paramInt < 0) {
      if (j > (int)(i * this.mFirstOffset))
        bool2 = true; 
      return bool2;
    } 
    if (paramInt > 0) {
      bool2 = bool1;
      if (j < (int)(i * this.mLastOffset))
        bool2 = true; 
      return bool2;
    } 
    return false;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    boolean bool;
    if (paramLayoutParams instanceof LayoutParams && super.checkLayoutParams(paramLayoutParams)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void clearOnPageChangeListeners() {
    List<OnPageChangeListener> list = this.mOnPageChangeListeners;
    if (list != null)
      list.clear(); 
  }
  
  public void computeScroll() {
    this.mIsScrollStarted = true;
    if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
      int i = getScrollX();
      int j = getScrollY();
      int k = this.mScroller.getCurrX();
      int m = this.mScroller.getCurrY();
      if (i != k || j != m) {
        scrollTo(k, m);
        if (!pageScrolled(k)) {
          this.mScroller.abortAnimation();
          scrollTo(0, m);
        } 
      } 
      ViewCompat.postInvalidateOnAnimation((View)this);
      return;
    } 
    completeScroll(true);
  }
  
  void dataSetChanged() {
    byte b;
    int i = this.mAdapter.getCount();
    this.mExpectedAdapterCount = i;
    if (this.mItems.size() < this.mOffscreenPageLimit * 2 + 1 && this.mItems.size() < i) {
      b = 1;
    } else {
      b = 0;
    } 
    int j = this.mCurItem;
    int k = 0;
    int m = 0;
    while (k < this.mItems.size()) {
      int i1;
      int i2;
      int i3;
      ItemInfo itemInfo = this.mItems.get(k);
      int n = this.mAdapter.getItemPosition(itemInfo.object);
      if (n == -1) {
        i1 = k;
        i2 = m;
        i3 = j;
      } else if (n == -2) {
        this.mItems.remove(k);
        i1 = k - 1;
        b = m;
        if (!m) {
          this.mAdapter.startUpdate(this);
          b = 1;
        } 
        this.mAdapter.destroyItem(this, itemInfo.position, itemInfo.object);
        if (this.mCurItem == itemInfo.position) {
          i3 = Math.max(0, Math.min(this.mCurItem, i - 1));
          j = 1;
          i2 = b;
          b = j;
        } else {
          m = 1;
          i2 = b;
          b = m;
          i3 = j;
        } 
      } else {
        i1 = k;
        i2 = m;
        i3 = j;
        if (itemInfo.position != n) {
          if (itemInfo.position == this.mCurItem)
            j = n; 
          itemInfo.position = n;
          b = 1;
          i3 = j;
          i2 = m;
          i1 = k;
        } 
      } 
      k = i1 + 1;
      m = i2;
      j = i3;
    } 
    if (m != 0)
      this.mAdapter.finishUpdate(this); 
    Collections.sort(this.mItems, COMPARATOR);
    if (b) {
      m = getChildCount();
      for (b = 0; b < m; b++) {
        LayoutParams layoutParams = (LayoutParams)getChildAt(b).getLayoutParams();
        if (!layoutParams.isDecor)
          layoutParams.widthFactor = 0.0F; 
      } 
      setCurrentItemInternal(j, false, true);
      requestLayout();
    } 
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    return (super.dispatchKeyEvent(paramKeyEvent) || executeKeyEvent(paramKeyEvent));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    if (paramAccessibilityEvent.getEventType() == 4096)
      return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent); 
    int i = getChildCount();
    for (byte b = 0; b < i; b++) {
      View view = getChildAt(b);
      if (view.getVisibility() == 0) {
        ItemInfo itemInfo = infoForChild(view);
        if (itemInfo != null && itemInfo.position == this.mCurItem && view.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))
          return true; 
      } 
    } 
    return false;
  }
  
  float distanceInfluenceForSnapDuration(float paramFloat) {
    return (float)Math.sin(((paramFloat - 0.5F) * 0.47123894F));
  }
  
  public void draw(Canvas paramCanvas) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial draw : (Landroid/graphics/Canvas;)V
    //   5: aload_0
    //   6: invokevirtual getOverScrollMode : ()I
    //   9: istore_2
    //   10: iconst_0
    //   11: istore_3
    //   12: iconst_0
    //   13: istore #4
    //   15: iload_2
    //   16: ifeq -> 64
    //   19: iload_2
    //   20: iconst_1
    //   21: if_icmpne -> 47
    //   24: aload_0
    //   25: getfield mAdapter : Landroid/support/v4/view/PagerAdapter;
    //   28: astore #5
    //   30: aload #5
    //   32: ifnull -> 47
    //   35: aload #5
    //   37: invokevirtual getCount : ()I
    //   40: iconst_1
    //   41: if_icmple -> 47
    //   44: goto -> 64
    //   47: aload_0
    //   48: getfield mLeftEdge : Landroid/widget/EdgeEffect;
    //   51: invokevirtual finish : ()V
    //   54: aload_0
    //   55: getfield mRightEdge : Landroid/widget/EdgeEffect;
    //   58: invokevirtual finish : ()V
    //   61: goto -> 256
    //   64: aload_0
    //   65: getfield mLeftEdge : Landroid/widget/EdgeEffect;
    //   68: invokevirtual isFinished : ()Z
    //   71: ifne -> 154
    //   74: aload_1
    //   75: invokevirtual save : ()I
    //   78: istore_3
    //   79: aload_0
    //   80: invokevirtual getHeight : ()I
    //   83: aload_0
    //   84: invokevirtual getPaddingTop : ()I
    //   87: isub
    //   88: aload_0
    //   89: invokevirtual getPaddingBottom : ()I
    //   92: isub
    //   93: istore #4
    //   95: aload_0
    //   96: invokevirtual getWidth : ()I
    //   99: istore_2
    //   100: aload_1
    //   101: ldc_w 270.0
    //   104: invokevirtual rotate : (F)V
    //   107: aload_1
    //   108: iload #4
    //   110: ineg
    //   111: aload_0
    //   112: invokevirtual getPaddingTop : ()I
    //   115: iadd
    //   116: i2f
    //   117: aload_0
    //   118: getfield mFirstOffset : F
    //   121: iload_2
    //   122: i2f
    //   123: fmul
    //   124: invokevirtual translate : (FF)V
    //   127: aload_0
    //   128: getfield mLeftEdge : Landroid/widget/EdgeEffect;
    //   131: iload #4
    //   133: iload_2
    //   134: invokevirtual setSize : (II)V
    //   137: iconst_0
    //   138: aload_0
    //   139: getfield mLeftEdge : Landroid/widget/EdgeEffect;
    //   142: aload_1
    //   143: invokevirtual draw : (Landroid/graphics/Canvas;)Z
    //   146: ior
    //   147: istore #4
    //   149: aload_1
    //   150: iload_3
    //   151: invokevirtual restoreToCount : (I)V
    //   154: iload #4
    //   156: istore_3
    //   157: aload_0
    //   158: getfield mRightEdge : Landroid/widget/EdgeEffect;
    //   161: invokevirtual isFinished : ()Z
    //   164: ifne -> 256
    //   167: aload_1
    //   168: invokevirtual save : ()I
    //   171: istore_2
    //   172: aload_0
    //   173: invokevirtual getWidth : ()I
    //   176: istore #6
    //   178: aload_0
    //   179: invokevirtual getHeight : ()I
    //   182: istore_3
    //   183: aload_0
    //   184: invokevirtual getPaddingTop : ()I
    //   187: istore #7
    //   189: aload_0
    //   190: invokevirtual getPaddingBottom : ()I
    //   193: istore #8
    //   195: aload_1
    //   196: ldc_w 90.0
    //   199: invokevirtual rotate : (F)V
    //   202: aload_1
    //   203: aload_0
    //   204: invokevirtual getPaddingTop : ()I
    //   207: ineg
    //   208: i2f
    //   209: aload_0
    //   210: getfield mLastOffset : F
    //   213: fconst_1
    //   214: fadd
    //   215: fneg
    //   216: iload #6
    //   218: i2f
    //   219: fmul
    //   220: invokevirtual translate : (FF)V
    //   223: aload_0
    //   224: getfield mRightEdge : Landroid/widget/EdgeEffect;
    //   227: iload_3
    //   228: iload #7
    //   230: isub
    //   231: iload #8
    //   233: isub
    //   234: iload #6
    //   236: invokevirtual setSize : (II)V
    //   239: iload #4
    //   241: aload_0
    //   242: getfield mRightEdge : Landroid/widget/EdgeEffect;
    //   245: aload_1
    //   246: invokevirtual draw : (Landroid/graphics/Canvas;)Z
    //   249: ior
    //   250: istore_3
    //   251: aload_1
    //   252: iload_2
    //   253: invokevirtual restoreToCount : (I)V
    //   256: iload_3
    //   257: ifeq -> 264
    //   260: aload_0
    //   261: invokestatic postInvalidateOnAnimation : (Landroid/view/View;)V
    //   264: return
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    Drawable drawable = this.mMarginDrawable;
    if (drawable != null && drawable.isStateful())
      drawable.setState(getDrawableState()); 
  }
  
  public void endFakeDrag() {
    if (this.mFakeDragging) {
      if (this.mAdapter != null) {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int i = (int)velocityTracker.getXVelocity(this.mActivePointerId);
        this.mPopulatePending = true;
        int j = getClientWidth();
        int k = getScrollX();
        ItemInfo itemInfo = infoForCurrentScrollPosition();
        setCurrentItemInternal(determineTargetPage(itemInfo.position, (k / j - itemInfo.offset) / itemInfo.widthFactor, i, (int)(this.mLastMotionX - this.mInitialMotionX)), true, true, i);
      } 
      endDrag();
      this.mFakeDragging = false;
      return;
    } 
    throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
  }
  
  public boolean executeKeyEvent(@NonNull KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getAction() == 0) {
      int i = paramKeyEvent.getKeyCode();
      if (i != 61) {
        boolean bool1;
        switch (i) {
          case 22:
            if (paramKeyEvent.hasModifiers(2)) {
              bool1 = pageRight();
            } else {
              bool1 = arrowScroll(66);
            } 
            return bool1;
          case 21:
            if (paramKeyEvent.hasModifiers(2)) {
              bool1 = pageLeft();
            } else {
              bool1 = arrowScroll(17);
            } 
            return bool1;
        } 
      } else {
        boolean bool1;
        if (paramKeyEvent.hasNoModifiers()) {
          bool1 = arrowScroll(2);
        } else {
          if (paramKeyEvent.hasModifiers(1))
            return arrowScroll(1); 
          bool1 = false;
        } 
        return bool1;
      } 
    } 
    boolean bool = false;
  }
  
  public void fakeDragBy(float paramFloat) {
    if (this.mFakeDragging) {
      if (this.mAdapter == null)
        return; 
      this.mLastMotionX += paramFloat;
      float f1 = getScrollX() - paramFloat;
      float f2 = getClientWidth();
      paramFloat = this.mFirstOffset * f2;
      float f3 = this.mLastOffset * f2;
      ItemInfo itemInfo1 = this.mItems.get(0);
      ArrayList<ItemInfo> arrayList = this.mItems;
      ItemInfo itemInfo2 = arrayList.get(arrayList.size() - 1);
      if (itemInfo1.position != 0)
        paramFloat = itemInfo1.offset * f2; 
      if (itemInfo2.position != this.mAdapter.getCount() - 1)
        f3 = itemInfo2.offset * f2; 
      if (f1 >= paramFloat) {
        paramFloat = f1;
        if (f1 > f3)
          paramFloat = f3; 
      } 
      f3 = this.mLastMotionX;
      int i = (int)paramFloat;
      this.mLastMotionX = f3 + paramFloat - i;
      scrollTo(i, getScrollY());
      pageScrolled(i);
      long l = SystemClock.uptimeMillis();
      MotionEvent motionEvent = MotionEvent.obtain(this.mFakeDragBeginTime, l, 2, this.mLastMotionX, 0.0F, 0);
      this.mVelocityTracker.addMovement(motionEvent);
      motionEvent.recycle();
      return;
    } 
    throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
    return new LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return generateDefaultLayoutParams();
  }
  
  @Nullable
  public PagerAdapter getAdapter() {
    return this.mAdapter;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2) {
    int i = paramInt2;
    if (this.mDrawingOrder == 2)
      i = paramInt1 - 1 - paramInt2; 
    return ((LayoutParams)((View)this.mDrawingOrderedChildren.get(i)).getLayoutParams()).childIndex;
  }
  
  public int getCurrentItem() {
    return this.mCurItem;
  }
  
  public int getOffscreenPageLimit() {
    return this.mOffscreenPageLimit;
  }
  
  public int getPageMargin() {
    return this.mPageMargin;
  }
  
  ItemInfo infoForAnyChild(View paramView) {
    while (true) {
      ViewParent viewParent = paramView.getParent();
      if (viewParent != this) {
        if (viewParent != null) {
          if (!(viewParent instanceof View))
            return null; 
          paramView = (View)viewParent;
          continue;
        } 
        continue;
      } 
      return infoForChild(paramView);
    } 
  }
  
  ItemInfo infoForChild(View paramView) {
    for (byte b = 0; b < this.mItems.size(); b++) {
      ItemInfo itemInfo = this.mItems.get(b);
      if (this.mAdapter.isViewFromObject(paramView, itemInfo.object))
        return itemInfo; 
    } 
    return null;
  }
  
  ItemInfo infoForPosition(int paramInt) {
    for (byte b = 0; b < this.mItems.size(); b++) {
      ItemInfo itemInfo = this.mItems.get(b);
      if (itemInfo.position == paramInt)
        return itemInfo; 
    } 
    return null;
  }
  
  void initViewPager() {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context context = getContext();
    this.mScroller = new Scroller(context, sInterpolator);
    ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
    float f = (context.getResources().getDisplayMetrics()).density;
    this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
    this.mMinimumVelocity = (int)(400.0F * f);
    this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    this.mLeftEdge = new EdgeEffect(context);
    this.mRightEdge = new EdgeEffect(context);
    this.mFlingDistance = (int)(25.0F * f);
    this.mCloseEnough = (int)(2.0F * f);
    this.mDefaultGutterSize = (int)(f * 16.0F);
    ViewCompat.setAccessibilityDelegate((View)this, new MyAccessibilityDelegate());
    if (ViewCompat.getImportantForAccessibility((View)this) == 0)
      ViewCompat.setImportantForAccessibility((View)this, 1); 
    ViewCompat.setOnApplyWindowInsetsListener((View)this, new OnApplyWindowInsetsListener() {
          private final Rect mTempRect = new Rect();
          
          public WindowInsetsCompat onApplyWindowInsets(View param1View, WindowInsetsCompat param1WindowInsetsCompat) {
            param1WindowInsetsCompat = ViewCompat.onApplyWindowInsets(param1View, param1WindowInsetsCompat);
            if (param1WindowInsetsCompat.isConsumed())
              return param1WindowInsetsCompat; 
            Rect rect = this.mTempRect;
            rect.left = param1WindowInsetsCompat.getSystemWindowInsetLeft();
            rect.top = param1WindowInsetsCompat.getSystemWindowInsetTop();
            rect.right = param1WindowInsetsCompat.getSystemWindowInsetRight();
            rect.bottom = param1WindowInsetsCompat.getSystemWindowInsetBottom();
            byte b = 0;
            int i = ViewPager.this.getChildCount();
            while (b < i) {
              WindowInsetsCompat windowInsetsCompat = ViewCompat.dispatchApplyWindowInsets(ViewPager.this.getChildAt(b), param1WindowInsetsCompat);
              rect.left = Math.min(windowInsetsCompat.getSystemWindowInsetLeft(), rect.left);
              rect.top = Math.min(windowInsetsCompat.getSystemWindowInsetTop(), rect.top);
              rect.right = Math.min(windowInsetsCompat.getSystemWindowInsetRight(), rect.right);
              rect.bottom = Math.min(windowInsetsCompat.getSystemWindowInsetBottom(), rect.bottom);
              b++;
            } 
            return param1WindowInsetsCompat.replaceSystemWindowInsets(rect.left, rect.top, rect.right, rect.bottom);
          }
        });
  }
  
  public boolean isFakeDragging() {
    return this.mFakeDragging;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    this.mFirstLayout = true;
  }
  
  protected void onDetachedFromWindow() {
    removeCallbacks(this.mEndScrollRunnable);
    Scroller scroller = this.mScroller;
    if (scroller != null && !scroller.isFinished())
      this.mScroller.abortAnimation(); 
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    if (this.mPageMargin > 0 && this.mMarginDrawable != null && this.mItems.size() > 0 && this.mAdapter != null) {
      int i = getScrollX();
      int j = getWidth();
      float f1 = this.mPageMargin;
      float f2 = j;
      float f3 = f1 / f2;
      ArrayList<ItemInfo> arrayList = this.mItems;
      byte b = 0;
      ItemInfo itemInfo = arrayList.get(0);
      f1 = itemInfo.offset;
      int k = this.mItems.size();
      int m = itemInfo.position;
      int n = ((ItemInfo)this.mItems.get(k - 1)).position;
      while (m < n) {
        ItemInfo itemInfo1;
        float f;
        while (m > itemInfo.position && b < k) {
          ArrayList<ItemInfo> arrayList1 = this.mItems;
          itemInfo1 = arrayList1.get(++b);
        } 
        if (m == itemInfo1.position) {
          f = (itemInfo1.offset + itemInfo1.widthFactor) * f2;
          f1 = itemInfo1.offset + itemInfo1.widthFactor + f3;
        } else {
          float f4 = this.mAdapter.getPageWidth(m);
          f = f1 + f4 + f3;
          f4 = (f1 + f4) * f2;
          f1 = f;
          f = f4;
        } 
        if (this.mPageMargin + f > i) {
          this.mMarginDrawable.setBounds(Math.round(f), this.mTopPageBounds, Math.round(this.mPageMargin + f), this.mBottomPageBounds);
          this.mMarginDrawable.draw(paramCanvas);
        } 
        if (f > (i + j))
          break; 
        m++;
      } 
    } 
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 3 || i == 1) {
      resetTouch();
      return false;
    } 
    if (i != 0) {
      if (this.mIsBeingDragged)
        return true; 
      if (this.mIsUnableToDrag)
        return false; 
    } 
    if (i != 0) {
      if (i != 2) {
        if (i == 6)
          onSecondaryPointerUp(paramMotionEvent); 
      } else {
        i = this.mActivePointerId;
        if (i != -1) {
          i = paramMotionEvent.findPointerIndex(i);
          float f1 = paramMotionEvent.getX(i);
          float f2 = f1 - this.mLastMotionX;
          float f3 = Math.abs(f2);
          float f4 = paramMotionEvent.getY(i);
          float f5 = Math.abs(f4 - this.mInitialMotionY);
          if (f2 != 0.0F && !isGutterDrag(this.mLastMotionX, f2) && canScroll((View)this, false, (int)f2, (int)f1, (int)f4)) {
            this.mLastMotionX = f1;
            this.mLastMotionY = f4;
            this.mIsUnableToDrag = true;
            return false;
          } 
          if (f3 > this.mTouchSlop && f3 * 0.5F > f5) {
            this.mIsBeingDragged = true;
            requestParentDisallowInterceptTouchEvent(true);
            setScrollState(1);
            if (f2 > 0.0F) {
              f3 = this.mInitialMotionX + this.mTouchSlop;
            } else {
              f3 = this.mInitialMotionX - this.mTouchSlop;
            } 
            this.mLastMotionX = f3;
            this.mLastMotionY = f4;
            setScrollingCacheEnabled(true);
          } else if (f5 > this.mTouchSlop) {
            this.mIsUnableToDrag = true;
          } 
          if (this.mIsBeingDragged && performDrag(f1))
            ViewCompat.postInvalidateOnAnimation((View)this); 
        } 
      } 
    } else {
      float f = paramMotionEvent.getX();
      this.mInitialMotionX = f;
      this.mLastMotionX = f;
      f = paramMotionEvent.getY();
      this.mInitialMotionY = f;
      this.mLastMotionY = f;
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      this.mIsUnableToDrag = false;
      this.mIsScrollStarted = true;
      this.mScroller.computeScrollOffset();
      if (this.mScrollState == 2 && Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough) {
        this.mScroller.abortAnimation();
        this.mPopulatePending = false;
        populate();
        this.mIsBeingDragged = true;
        requestParentDisallowInterceptTouchEvent(true);
        setScrollState(1);
      } else {
        completeScroll(false);
        this.mIsBeingDragged = false;
      } 
    } 
    if (this.mVelocityTracker == null)
      this.mVelocityTracker = VelocityTracker.obtain(); 
    this.mVelocityTracker.addMovement(paramMotionEvent);
    return this.mIsBeingDragged;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i = getChildCount();
    int j = paramInt3 - paramInt1;
    int k = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    int m = getPaddingRight();
    paramInt4 = getPaddingBottom();
    int n = getScrollX();
    int i1 = 0;
    byte b = 0;
    while (b < i) {
      View view = getChildAt(b);
      int i2 = paramInt2;
      int i3 = m;
      int i4 = paramInt1;
      int i5 = paramInt4;
      paramInt3 = i1;
      if (view.getVisibility() != 8) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        i2 = paramInt2;
        i3 = m;
        i4 = paramInt1;
        i5 = paramInt4;
        paramInt3 = i1;
        if (layoutParams.isDecor) {
          paramInt3 = layoutParams.gravity & 0x7;
          i5 = layoutParams.gravity & 0x70;
          if (paramInt3 != 1) {
            if (paramInt3 != 3) {
              if (paramInt3 != 5) {
                paramInt3 = paramInt2;
                i2 = paramInt2;
              } else {
                paramInt3 = j - m - view.getMeasuredWidth();
                m += view.getMeasuredWidth();
                i2 = paramInt2;
              } 
            } else {
              i2 = view.getMeasuredWidth();
              paramInt3 = paramInt2;
              i2 += paramInt2;
            } 
          } else {
            paramInt3 = Math.max((j - view.getMeasuredWidth()) / 2, paramInt2);
            i2 = paramInt2;
          } 
          if (i5 != 16) {
            if (i5 != 48) {
              if (i5 != 80) {
                paramInt2 = paramInt1;
              } else {
                paramInt2 = k - paramInt4 - view.getMeasuredHeight();
                paramInt4 += view.getMeasuredHeight();
              } 
            } else {
              i5 = view.getMeasuredHeight();
              paramInt2 = paramInt1;
              paramInt1 = i5 + paramInt1;
            } 
          } else {
            paramInt2 = Math.max((k - view.getMeasuredHeight()) / 2, paramInt1);
          } 
          paramInt3 += n;
          view.layout(paramInt3, paramInt2, view.getMeasuredWidth() + paramInt3, paramInt2 + view.getMeasuredHeight());
          paramInt3 = i1 + 1;
          i5 = paramInt4;
          i4 = paramInt1;
          i3 = m;
        } 
      } 
      b++;
      paramInt2 = i2;
      m = i3;
      paramInt1 = i4;
      paramInt4 = i5;
      i1 = paramInt3;
    } 
    for (paramInt3 = 0; paramInt3 < i; paramInt3++) {
      View view = getChildAt(paramInt3);
      if (view.getVisibility() != 8) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (!layoutParams.isDecor) {
          ItemInfo itemInfo = infoForChild(view);
          if (itemInfo != null) {
            float f = (j - paramInt2 - m);
            int i2 = (int)(itemInfo.offset * f) + paramInt2;
            if (layoutParams.needsMeasure) {
              layoutParams.needsMeasure = false;
              view.measure(View.MeasureSpec.makeMeasureSpec((int)(f * layoutParams.widthFactor), 1073741824), View.MeasureSpec.makeMeasureSpec(k - paramInt1 - paramInt4, 1073741824));
            } 
            view.layout(i2, paramInt1, view.getMeasuredWidth() + i2, view.getMeasuredHeight() + paramInt1);
          } 
        } 
      } 
    } 
    this.mTopPageBounds = paramInt1;
    this.mBottomPageBounds = k - paramInt4;
    this.mDecorChildCount = i1;
    if (this.mFirstLayout)
      scrollToItem(this.mCurItem, false, 0, false); 
    this.mFirstLayout = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    int i = getMeasuredWidth();
    this.mGutterSize = Math.min(i / 10, this.mDefaultGutterSize);
    int j = getPaddingLeft();
    paramInt1 = getPaddingRight();
    paramInt2 = getMeasuredHeight();
    int k = getPaddingTop();
    int m = getPaddingBottom();
    int n = getChildCount();
    paramInt2 = paramInt2 - k - m;
    paramInt1 = i - j - paramInt1;
    m = 0;
    while (true) {
      k = 1;
      int i1 = 1073741824;
      if (m < n) {
        View view = getChildAt(m);
        i = paramInt1;
        j = paramInt2;
        if (view.getVisibility() != 8) {
          LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
          i = paramInt1;
          j = paramInt2;
          if (layoutParams != null) {
            i = paramInt1;
            j = paramInt2;
            if (layoutParams.isDecor) {
              boolean bool;
              i = layoutParams.gravity & 0x7;
              j = layoutParams.gravity & 0x70;
              if (j == 48 || j == 80) {
                bool = true;
              } else {
                bool = false;
              } 
              int i2 = k;
              if (i != 3)
                if (i == 5) {
                  i2 = k;
                } else {
                  i2 = 0;
                }  
              j = Integer.MIN_VALUE;
              if (bool) {
                j = 1073741824;
                i = Integer.MIN_VALUE;
              } else if (i2 != 0) {
                i = 1073741824;
              } else {
                i = Integer.MIN_VALUE;
              } 
              if (layoutParams.width != -2) {
                if (layoutParams.width != -1) {
                  k = layoutParams.width;
                  j = 1073741824;
                } else {
                  k = paramInt1;
                  j = 1073741824;
                } 
              } else {
                k = paramInt1;
              } 
              if (layoutParams.height != -2) {
                if (layoutParams.height != -1) {
                  i = layoutParams.height;
                } else {
                  i = paramInt2;
                } 
              } else {
                int i3 = paramInt2;
                i1 = i;
                i = i3;
              } 
              view.measure(View.MeasureSpec.makeMeasureSpec(k, j), View.MeasureSpec.makeMeasureSpec(i, i1));
              if (bool) {
                j = paramInt2 - view.getMeasuredHeight();
                i = paramInt1;
              } else {
                i = paramInt1;
                j = paramInt2;
                if (i2 != 0) {
                  i = paramInt1 - view.getMeasuredWidth();
                  j = paramInt2;
                } 
              } 
            } 
          } 
        } 
        m++;
        paramInt1 = i;
        paramInt2 = j;
        continue;
      } 
      this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
      this.mInLayout = true;
      populate();
      paramInt2 = 0;
      this.mInLayout = false;
      i = getChildCount();
      while (paramInt2 < i) {
        View view = getChildAt(paramInt2);
        if (view.getVisibility() != 8) {
          LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
          if (layoutParams == null || !layoutParams.isDecor)
            view.measure(View.MeasureSpec.makeMeasureSpec((int)(paramInt1 * layoutParams.widthFactor), 1073741824), this.mChildHeightMeasureSpec); 
        } 
        paramInt2++;
      } 
      return;
    } 
  }
  
  @CallSuper
  protected void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {
    int i = this.mDecorChildCount;
    boolean bool = false;
    if (i > 0) {
      int j = getScrollX();
      i = getPaddingLeft();
      int k = getPaddingRight();
      int m = getWidth();
      int n = getChildCount();
      for (byte b = 0; b < n; b++) {
        View view = getChildAt(b);
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.isDecor) {
          int i1 = layoutParams.gravity & 0x7;
          if (i1 != 1) {
            if (i1 != 3) {
              if (i1 != 5) {
                int i2 = i;
                i1 = i;
                i = i2;
              } else {
                i1 = view.getMeasuredWidth();
                int i2 = k + view.getMeasuredWidth();
                i1 = m - k - i1;
                k = i2;
              } 
            } else {
              int i2 = view.getWidth() + i;
              i1 = i;
              i = i2;
            } 
          } else {
            i1 = Math.max((m - view.getMeasuredWidth()) / 2, i);
          } 
          i1 = i1 + j - view.getLeft();
          if (i1 != 0)
            view.offsetLeftAndRight(i1); 
        } 
      } 
    } 
    dispatchOnPageScrolled(paramInt1, paramFloat, paramInt2);
    if (this.mPageTransformer != null) {
      i = getScrollX();
      paramInt2 = getChildCount();
      for (paramInt1 = bool; paramInt1 < paramInt2; paramInt1++) {
        View view = getChildAt(paramInt1);
        if (!((LayoutParams)view.getLayoutParams()).isDecor) {
          paramFloat = (view.getLeft() - i) / getClientWidth();
          this.mPageTransformer.transformPage(view, paramFloat);
        } 
      } 
    } 
    this.mCalledSuper = true;
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect) {
    byte b;
    int i = getChildCount();
    int j = -1;
    if ((paramInt & 0x2) != 0) {
      j = i;
      i = 0;
      b = 1;
    } else {
      i--;
      b = -1;
    } 
    while (i != j) {
      View view = getChildAt(i);
      if (view.getVisibility() == 0) {
        ItemInfo itemInfo = infoForChild(view);
        if (itemInfo != null && itemInfo.position == this.mCurItem && view.requestFocus(paramInt, paramRect))
          return true; 
      } 
      i += b;
    } 
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    PagerAdapter pagerAdapter = this.mAdapter;
    if (pagerAdapter != null) {
      pagerAdapter.restoreState(savedState.adapterState, savedState.loader);
      setCurrentItemInternal(savedState.position, false, true);
    } else {
      this.mRestoredCurItem = savedState.position;
      this.mRestoredAdapterState = savedState.adapterState;
      this.mRestoredClassLoader = savedState.loader;
    } 
  }
  
  public Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    savedState.position = this.mCurItem;
    PagerAdapter pagerAdapter = this.mAdapter;
    if (pagerAdapter != null)
      savedState.adapterState = pagerAdapter.saveState(); 
    return savedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      paramInt2 = this.mPageMargin;
      recomputeScrollPosition(paramInt1, paramInt3, paramInt2, paramInt2);
    } 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    float f;
    if (this.mFakeDragging)
      return true; 
    int i = paramMotionEvent.getAction();
    boolean bool = false;
    if (i == 0 && paramMotionEvent.getEdgeFlags() != 0)
      return false; 
    PagerAdapter pagerAdapter = this.mAdapter;
    if (pagerAdapter == null || pagerAdapter.getCount() == 0)
      return false; 
    if (this.mVelocityTracker == null)
      this.mVelocityTracker = VelocityTracker.obtain(); 
    this.mVelocityTracker.addMovement(paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF) {
      case 6:
        onSecondaryPointerUp(paramMotionEvent);
        this.mLastMotionX = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.mActivePointerId));
        break;
      case 5:
        i = paramMotionEvent.getActionIndex();
        this.mLastMotionX = paramMotionEvent.getX(i);
        this.mActivePointerId = paramMotionEvent.getPointerId(i);
        break;
      case 3:
        if (this.mIsBeingDragged) {
          scrollToItem(this.mCurItem, true, 0, false);
          bool = resetTouch();
        } 
        break;
      case 2:
        if (!this.mIsBeingDragged) {
          i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
          if (i == -1) {
            bool = resetTouch();
            break;
          } 
          float f1 = paramMotionEvent.getX(i);
          float f2 = Math.abs(f1 - this.mLastMotionX);
          float f3 = paramMotionEvent.getY(i);
          float f4 = Math.abs(f3 - this.mLastMotionY);
          if (f2 > this.mTouchSlop && f2 > f4) {
            this.mIsBeingDragged = true;
            requestParentDisallowInterceptTouchEvent(true);
            f2 = this.mInitialMotionX;
            if (f1 - f2 > 0.0F) {
              f1 = f2 + this.mTouchSlop;
            } else {
              f1 = f2 - this.mTouchSlop;
            } 
            this.mLastMotionX = f1;
            this.mLastMotionY = f3;
            setScrollState(1);
            setScrollingCacheEnabled(true);
            ViewParent viewParent = getParent();
            if (viewParent != null)
              viewParent.requestDisallowInterceptTouchEvent(true); 
          } 
        } 
        if (this.mIsBeingDragged)
          int j = false | performDrag(paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.mActivePointerId))); 
        break;
      case 1:
        if (this.mIsBeingDragged) {
          VelocityTracker velocityTracker = this.mVelocityTracker;
          velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
          i = (int)velocityTracker.getXVelocity(this.mActivePointerId);
          this.mPopulatePending = true;
          int j = getClientWidth();
          int k = getScrollX();
          ItemInfo itemInfo = infoForCurrentScrollPosition();
          float f2 = this.mPageMargin;
          float f1 = j;
          f2 /= f1;
          setCurrentItemInternal(determineTargetPage(itemInfo.position, (k / f1 - itemInfo.offset) / (itemInfo.widthFactor + f2), i, (int)(paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, i);
          bool = resetTouch();
        } 
        break;
      case 0:
        this.mScroller.abortAnimation();
        this.mPopulatePending = false;
        populate();
        f = paramMotionEvent.getX();
        this.mInitialMotionX = f;
        this.mLastMotionX = f;
        f = paramMotionEvent.getY();
        this.mInitialMotionY = f;
        this.mLastMotionY = f;
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        break;
    } 
    if (bool)
      ViewCompat.postInvalidateOnAnimation((View)this); 
    return true;
  }
  
  boolean pageLeft() {
    int i = this.mCurItem;
    if (i > 0) {
      setCurrentItem(i - 1, true);
      return true;
    } 
    return false;
  }
  
  boolean pageRight() {
    PagerAdapter pagerAdapter = this.mAdapter;
    if (pagerAdapter != null && this.mCurItem < pagerAdapter.getCount() - 1) {
      setCurrentItem(this.mCurItem + 1, true);
      return true;
    } 
    return false;
  }
  
  void populate() {
    populate(this.mCurItem);
  }
  
  void populate(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mCurItem : I
    //   4: istore_2
    //   5: iload_2
    //   6: iload_1
    //   7: if_icmpeq -> 24
    //   10: aload_0
    //   11: iload_2
    //   12: invokevirtual infoForPosition : (I)Landroid/support/v4/view/ViewPager$ItemInfo;
    //   15: astore_3
    //   16: aload_0
    //   17: iload_1
    //   18: putfield mCurItem : I
    //   21: goto -> 26
    //   24: aconst_null
    //   25: astore_3
    //   26: aload_0
    //   27: getfield mAdapter : Landroid/support/v4/view/PagerAdapter;
    //   30: ifnonnull -> 38
    //   33: aload_0
    //   34: invokespecial sortChildDrawingOrder : ()V
    //   37: return
    //   38: aload_0
    //   39: getfield mPopulatePending : Z
    //   42: ifeq -> 50
    //   45: aload_0
    //   46: invokespecial sortChildDrawingOrder : ()V
    //   49: return
    //   50: aload_0
    //   51: invokevirtual getWindowToken : ()Landroid/os/IBinder;
    //   54: ifnonnull -> 58
    //   57: return
    //   58: aload_0
    //   59: getfield mAdapter : Landroid/support/v4/view/PagerAdapter;
    //   62: aload_0
    //   63: invokevirtual startUpdate : (Landroid/view/ViewGroup;)V
    //   66: aload_0
    //   67: getfield mOffscreenPageLimit : I
    //   70: istore_1
    //   71: iconst_0
    //   72: aload_0
    //   73: getfield mCurItem : I
    //   76: iload_1
    //   77: isub
    //   78: invokestatic max : (II)I
    //   81: istore #4
    //   83: aload_0
    //   84: getfield mAdapter : Landroid/support/v4/view/PagerAdapter;
    //   87: invokevirtual getCount : ()I
    //   90: istore #5
    //   92: iload #5
    //   94: iconst_1
    //   95: isub
    //   96: aload_0
    //   97: getfield mCurItem : I
    //   100: iload_1
    //   101: iadd
    //   102: invokestatic min : (II)I
    //   105: istore #6
    //   107: iload #5
    //   109: aload_0
    //   110: getfield mExpectedAdapterCount : I
    //   113: if_icmpne -> 1150
    //   116: iconst_0
    //   117: istore_1
    //   118: iload_1
    //   119: aload_0
    //   120: getfield mItems : Ljava/util/ArrayList;
    //   123: invokevirtual size : ()I
    //   126: if_icmpge -> 175
    //   129: aload_0
    //   130: getfield mItems : Ljava/util/ArrayList;
    //   133: iload_1
    //   134: invokevirtual get : (I)Ljava/lang/Object;
    //   137: checkcast android/support/v4/view/ViewPager$ItemInfo
    //   140: astore #7
    //   142: aload #7
    //   144: getfield position : I
    //   147: aload_0
    //   148: getfield mCurItem : I
    //   151: if_icmplt -> 169
    //   154: aload #7
    //   156: getfield position : I
    //   159: aload_0
    //   160: getfield mCurItem : I
    //   163: if_icmpne -> 175
    //   166: goto -> 178
    //   169: iinc #1, 1
    //   172: goto -> 118
    //   175: aconst_null
    //   176: astore #7
    //   178: aload #7
    //   180: astore #8
    //   182: aload #7
    //   184: ifnonnull -> 207
    //   187: aload #7
    //   189: astore #8
    //   191: iload #5
    //   193: ifle -> 207
    //   196: aload_0
    //   197: aload_0
    //   198: getfield mCurItem : I
    //   201: iload_1
    //   202: invokevirtual addNewItem : (II)Landroid/support/v4/view/ViewPager$ItemInfo;
    //   205: astore #8
    //   207: aload #8
    //   209: ifnull -> 946
    //   212: iload_1
    //   213: iconst_1
    //   214: isub
    //   215: istore #9
    //   217: iload #9
    //   219: iflt -> 239
    //   222: aload_0
    //   223: getfield mItems : Ljava/util/ArrayList;
    //   226: iload #9
    //   228: invokevirtual get : (I)Ljava/lang/Object;
    //   231: checkcast android/support/v4/view/ViewPager$ItemInfo
    //   234: astore #7
    //   236: goto -> 242
    //   239: aconst_null
    //   240: astore #7
    //   242: aload_0
    //   243: invokespecial getClientWidth : ()I
    //   246: istore #10
    //   248: iload #10
    //   250: ifgt -> 259
    //   253: fconst_0
    //   254: fstore #11
    //   256: goto -> 278
    //   259: fconst_2
    //   260: aload #8
    //   262: getfield widthFactor : F
    //   265: fsub
    //   266: aload_0
    //   267: invokevirtual getPaddingLeft : ()I
    //   270: i2f
    //   271: iload #10
    //   273: i2f
    //   274: fdiv
    //   275: fadd
    //   276: fstore #11
    //   278: aload_0
    //   279: getfield mCurItem : I
    //   282: iconst_1
    //   283: isub
    //   284: istore #12
    //   286: fconst_0
    //   287: fstore #13
    //   289: aload #7
    //   291: astore #14
    //   293: iload_1
    //   294: istore #15
    //   296: iload #12
    //   298: iflt -> 565
    //   301: fload #13
    //   303: fload #11
    //   305: fcmpl
    //   306: iflt -> 435
    //   309: iload #12
    //   311: iload #4
    //   313: if_icmpge -> 435
    //   316: aload #14
    //   318: ifnonnull -> 324
    //   321: goto -> 565
    //   324: fload #13
    //   326: fstore #16
    //   328: iload #15
    //   330: istore_1
    //   331: aload #14
    //   333: astore #7
    //   335: iload #9
    //   337: istore_2
    //   338: iload #12
    //   340: aload #14
    //   342: getfield position : I
    //   345: if_icmpne -> 545
    //   348: fload #13
    //   350: fstore #16
    //   352: iload #15
    //   354: istore_1
    //   355: aload #14
    //   357: astore #7
    //   359: iload #9
    //   361: istore_2
    //   362: aload #14
    //   364: getfield scrolling : Z
    //   367: ifne -> 545
    //   370: aload_0
    //   371: getfield mItems : Ljava/util/ArrayList;
    //   374: iload #9
    //   376: invokevirtual remove : (I)Ljava/lang/Object;
    //   379: pop
    //   380: aload_0
    //   381: getfield mAdapter : Landroid/support/v4/view/PagerAdapter;
    //   384: aload_0
    //   385: iload #12
    //   387: aload #14
    //   389: getfield object : Ljava/lang/Object;
    //   392: invokevirtual destroyItem : (Landroid/view/ViewGroup;ILjava/lang/Object;)V
    //   395: iload #9
    //   397: iconst_1
    //   398: isub
    //   399: istore_2
    //   400: iload #15
    //   402: iconst_1
    //   403: isub
    //   404: istore_1
    //   405: iload_2
    //   406: iflt -> 425
    //   409: aload_0
    //   410: getfield mItems : Ljava/util/ArrayList;
    //   413: iload_2
    //   414: invokevirtual get : (I)Ljava/lang/Object;
    //   417: checkcast android/support/v4/view/ViewPager$ItemInfo
    //   420: astore #7
    //   422: goto -> 428
    //   425: aconst_null
    //   426: astore #7
    //   428: fload #13
    //   430: fstore #16
    //   432: goto -> 545
    //   435: aload #14
    //   437: ifnull -> 494
    //   440: iload #12
    //   442: aload #14
    //   444: getfield position : I
    //   447: if_icmpne -> 494
    //   450: fload #13
    //   452: aload #14
    //   454: getfield widthFactor : F
    //   457: fadd
    //   458: fstore #16
    //   460: iload #9
    //   462: iconst_1
    //   463: isub
    //   464: istore_2
    //   465: iload_2
    //   466: iflt -> 485
    //   469: aload_0
    //   470: getfield mItems : Ljava/util/ArrayList;
    //   473: iload_2
    //   474: invokevirtual get : (I)Ljava/lang/Object;
    //   477: checkcast android/support/v4/view/ViewPager$ItemInfo
    //   480: astore #7
    //   482: goto -> 488
    //   485: aconst_null
    //   486: astore #7
    //   488: iload #15
    //   490: istore_1
    //   491: goto -> 545
    //   494: fload #13
    //   496: aload_0
    //   497: iload #12
    //   499: iload #9
    //   501: iconst_1
    //   502: iadd
    //   503: invokevirtual addNewItem : (II)Landroid/support/v4/view/ViewPager$ItemInfo;
    //   506: getfield widthFactor : F
    //   509: fadd
    //   510: fstore #16
    //   512: iload #15
    //   514: iconst_1
    //   515: iadd
    //   516: istore_1
    //   517: iload #9
    //   519: iflt -> 539
    //   522: aload_0
    //   523: getfield mItems : Ljava/util/ArrayList;
    //   526: iload #9
    //   528: invokevirtual get : (I)Ljava/lang/Object;
    //   531: checkcast android/support/v4/view/ViewPager$ItemInfo
    //   534: astore #7
    //   536: goto -> 542
    //   539: aconst_null
    //   540: astore #7
    //   542: iload #9
    //   544: istore_2
    //   545: iinc #12, -1
    //   548: fload #16
    //   550: fstore #13
    //   552: iload_1
    //   553: istore #15
    //   555: aload #7
    //   557: astore #14
    //   559: iload_2
    //   560: istore #9
    //   562: goto -> 296
    //   565: aload #8
    //   567: getfield widthFactor : F
    //   570: fstore #13
    //   572: iload #15
    //   574: iconst_1
    //   575: iadd
    //   576: istore_2
    //   577: fload #13
    //   579: fconst_2
    //   580: fcmpg
    //   581: ifge -> 920
    //   584: iload_2
    //   585: aload_0
    //   586: getfield mItems : Ljava/util/ArrayList;
    //   589: invokevirtual size : ()I
    //   592: if_icmpge -> 611
    //   595: aload_0
    //   596: getfield mItems : Ljava/util/ArrayList;
    //   599: iload_2
    //   600: invokevirtual get : (I)Ljava/lang/Object;
    //   603: checkcast android/support/v4/view/ViewPager$ItemInfo
    //   606: astore #7
    //   608: goto -> 614
    //   611: aconst_null
    //   612: astore #7
    //   614: iload #10
    //   616: ifgt -> 625
    //   619: fconst_0
    //   620: fstore #11
    //   622: goto -> 638
    //   625: aload_0
    //   626: invokevirtual getPaddingRight : ()I
    //   629: i2f
    //   630: iload #10
    //   632: i2f
    //   633: fdiv
    //   634: fconst_2
    //   635: fadd
    //   636: fstore #11
    //   638: aload_0
    //   639: getfield mCurItem : I
    //   642: istore_1
    //   643: aload #7
    //   645: astore #14
    //   647: iload_1
    //   648: iconst_1
    //   649: iadd
    //   650: istore #12
    //   652: iload #12
    //   654: iload #5
    //   656: if_icmpge -> 920
    //   659: fload #13
    //   661: fload #11
    //   663: fcmpl
    //   664: iflt -> 789
    //   667: iload #12
    //   669: iload #6
    //   671: if_icmple -> 789
    //   674: aload #14
    //   676: ifnonnull -> 682
    //   679: goto -> 920
    //   682: fload #13
    //   684: fstore #16
    //   686: iload_2
    //   687: istore_1
    //   688: aload #14
    //   690: astore #7
    //   692: iload #12
    //   694: aload #14
    //   696: getfield position : I
    //   699: if_icmpne -> 904
    //   702: fload #13
    //   704: fstore #16
    //   706: iload_2
    //   707: istore_1
    //   708: aload #14
    //   710: astore #7
    //   712: aload #14
    //   714: getfield scrolling : Z
    //   717: ifne -> 904
    //   720: aload_0
    //   721: getfield mItems : Ljava/util/ArrayList;
    //   724: iload_2
    //   725: invokevirtual remove : (I)Ljava/lang/Object;
    //   728: pop
    //   729: aload_0
    //   730: getfield mAdapter : Landroid/support/v4/view/PagerAdapter;
    //   733: aload_0
    //   734: iload #12
    //   736: aload #14
    //   738: getfield object : Ljava/lang/Object;
    //   741: invokevirtual destroyItem : (Landroid/view/ViewGroup;ILjava/lang/Object;)V
    //   744: iload_2
    //   745: aload_0
    //   746: getfield mItems : Ljava/util/ArrayList;
    //   749: invokevirtual size : ()I
    //   752: if_icmpge -> 777
    //   755: aload_0
    //   756: getfield mItems : Ljava/util/ArrayList;
    //   759: iload_2
    //   760: invokevirtual get : (I)Ljava/lang/Object;
    //   763: checkcast android/support/v4/view/ViewPager$ItemInfo
    //   766: astore #7
    //   768: fload #13
    //   770: fstore #16
    //   772: iload_2
    //   773: istore_1
    //   774: goto -> 904
    //   777: aconst_null
    //   778: astore #7
    //   780: fload #13
    //   782: fstore #16
    //   784: iload_2
    //   785: istore_1
    //   786: goto -> 904
    //   789: aload #14
    //   791: ifnull -> 851
    //   794: iload #12
    //   796: aload #14
    //   798: getfield position : I
    //   801: if_icmpne -> 851
    //   804: fload #13
    //   806: aload #14
    //   808: getfield widthFactor : F
    //   811: fadd
    //   812: fstore #16
    //   814: iload_2
    //   815: iconst_1
    //   816: iadd
    //   817: istore_1
    //   818: iload_1
    //   819: aload_0
    //   820: getfield mItems : Ljava/util/ArrayList;
    //   823: invokevirtual size : ()I
    //   826: if_icmpge -> 845
    //   829: aload_0
    //   830: getfield mItems : Ljava/util/ArrayList;
    //   833: iload_1
    //   834: invokevirtual get : (I)Ljava/lang/Object;
    //   837: checkcast android/support/v4/view/ViewPager$ItemInfo
    //   840: astore #7
    //   842: goto -> 904
    //   845: aconst_null
    //   846: astore #7
    //   848: goto -> 904
    //   851: aload_0
    //   852: iload #12
    //   854: iload_2
    //   855: invokevirtual addNewItem : (II)Landroid/support/v4/view/ViewPager$ItemInfo;
    //   858: astore #7
    //   860: iload_2
    //   861: iconst_1
    //   862: iadd
    //   863: istore_1
    //   864: fload #13
    //   866: aload #7
    //   868: getfield widthFactor : F
    //   871: fadd
    //   872: fstore #16
    //   874: iload_1
    //   875: aload_0
    //   876: getfield mItems : Ljava/util/ArrayList;
    //   879: invokevirtual size : ()I
    //   882: if_icmpge -> 901
    //   885: aload_0
    //   886: getfield mItems : Ljava/util/ArrayList;
    //   889: iload_1
    //   890: invokevirtual get : (I)Ljava/lang/Object;
    //   893: checkcast android/support/v4/view/ViewPager$ItemInfo
    //   896: astore #7
    //   898: goto -> 904
    //   901: aconst_null
    //   902: astore #7
    //   904: fload #16
    //   906: fstore #13
    //   908: iload_1
    //   909: istore_2
    //   910: aload #7
    //   912: astore #14
    //   914: iload #12
    //   916: istore_1
    //   917: goto -> 647
    //   920: aload_0
    //   921: aload #8
    //   923: iload #15
    //   925: aload_3
    //   926: invokespecial calculatePageOffsets : (Landroid/support/v4/view/ViewPager$ItemInfo;ILandroid/support/v4/view/ViewPager$ItemInfo;)V
    //   929: aload_0
    //   930: getfield mAdapter : Landroid/support/v4/view/PagerAdapter;
    //   933: aload_0
    //   934: aload_0
    //   935: getfield mCurItem : I
    //   938: aload #8
    //   940: getfield object : Ljava/lang/Object;
    //   943: invokevirtual setPrimaryItem : (Landroid/view/ViewGroup;ILjava/lang/Object;)V
    //   946: aload_0
    //   947: getfield mAdapter : Landroid/support/v4/view/PagerAdapter;
    //   950: aload_0
    //   951: invokevirtual finishUpdate : (Landroid/view/ViewGroup;)V
    //   954: aload_0
    //   955: invokevirtual getChildCount : ()I
    //   958: istore_2
    //   959: iconst_0
    //   960: istore_1
    //   961: iload_1
    //   962: iload_2
    //   963: if_icmpge -> 1039
    //   966: aload_0
    //   967: iload_1
    //   968: invokevirtual getChildAt : (I)Landroid/view/View;
    //   971: astore_3
    //   972: aload_3
    //   973: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   976: checkcast android/support/v4/view/ViewPager$LayoutParams
    //   979: astore #7
    //   981: aload #7
    //   983: iload_1
    //   984: putfield childIndex : I
    //   987: aload #7
    //   989: getfield isDecor : Z
    //   992: ifne -> 1033
    //   995: aload #7
    //   997: getfield widthFactor : F
    //   1000: fconst_0
    //   1001: fcmpl
    //   1002: ifne -> 1033
    //   1005: aload_0
    //   1006: aload_3
    //   1007: invokevirtual infoForChild : (Landroid/view/View;)Landroid/support/v4/view/ViewPager$ItemInfo;
    //   1010: astore_3
    //   1011: aload_3
    //   1012: ifnull -> 1033
    //   1015: aload #7
    //   1017: aload_3
    //   1018: getfield widthFactor : F
    //   1021: putfield widthFactor : F
    //   1024: aload #7
    //   1026: aload_3
    //   1027: getfield position : I
    //   1030: putfield position : I
    //   1033: iinc #1, 1
    //   1036: goto -> 961
    //   1039: aload_0
    //   1040: invokespecial sortChildDrawingOrder : ()V
    //   1043: aload_0
    //   1044: invokevirtual hasFocus : ()Z
    //   1047: ifeq -> 1149
    //   1050: aload_0
    //   1051: invokevirtual findFocus : ()Landroid/view/View;
    //   1054: astore #7
    //   1056: aload #7
    //   1058: ifnull -> 1072
    //   1061: aload_0
    //   1062: aload #7
    //   1064: invokevirtual infoForAnyChild : (Landroid/view/View;)Landroid/support/v4/view/ViewPager$ItemInfo;
    //   1067: astore #7
    //   1069: goto -> 1075
    //   1072: aconst_null
    //   1073: astore #7
    //   1075: aload #7
    //   1077: ifnull -> 1092
    //   1080: aload #7
    //   1082: getfield position : I
    //   1085: aload_0
    //   1086: getfield mCurItem : I
    //   1089: if_icmpeq -> 1149
    //   1092: iconst_0
    //   1093: istore_1
    //   1094: iload_1
    //   1095: aload_0
    //   1096: invokevirtual getChildCount : ()I
    //   1099: if_icmpge -> 1149
    //   1102: aload_0
    //   1103: iload_1
    //   1104: invokevirtual getChildAt : (I)Landroid/view/View;
    //   1107: astore_3
    //   1108: aload_0
    //   1109: aload_3
    //   1110: invokevirtual infoForChild : (Landroid/view/View;)Landroid/support/v4/view/ViewPager$ItemInfo;
    //   1113: astore #7
    //   1115: aload #7
    //   1117: ifnull -> 1143
    //   1120: aload #7
    //   1122: getfield position : I
    //   1125: aload_0
    //   1126: getfield mCurItem : I
    //   1129: if_icmpne -> 1143
    //   1132: aload_3
    //   1133: iconst_2
    //   1134: invokevirtual requestFocus : (I)Z
    //   1137: ifeq -> 1143
    //   1140: goto -> 1149
    //   1143: iinc #1, 1
    //   1146: goto -> 1094
    //   1149: return
    //   1150: aload_0
    //   1151: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   1154: aload_0
    //   1155: invokevirtual getId : ()I
    //   1158: invokevirtual getResourceName : (I)Ljava/lang/String;
    //   1161: astore #7
    //   1163: goto -> 1177
    //   1166: astore #7
    //   1168: aload_0
    //   1169: invokevirtual getId : ()I
    //   1172: invokestatic toHexString : (I)Ljava/lang/String;
    //   1175: astore #7
    //   1177: new java/lang/StringBuilder
    //   1180: dup
    //   1181: invokespecial <init> : ()V
    //   1184: astore_3
    //   1185: aload_3
    //   1186: ldc_w 'The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: '
    //   1189: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1192: pop
    //   1193: aload_3
    //   1194: aload_0
    //   1195: getfield mExpectedAdapterCount : I
    //   1198: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1201: pop
    //   1202: aload_3
    //   1203: ldc_w ', found: '
    //   1206: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1209: pop
    //   1210: aload_3
    //   1211: iload #5
    //   1213: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1216: pop
    //   1217: aload_3
    //   1218: ldc_w ' Pager id: '
    //   1221: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1224: pop
    //   1225: aload_3
    //   1226: aload #7
    //   1228: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: pop
    //   1232: aload_3
    //   1233: ldc_w ' Pager class: '
    //   1236: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1239: pop
    //   1240: aload_3
    //   1241: aload_0
    //   1242: invokevirtual getClass : ()Ljava/lang/Class;
    //   1245: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1248: pop
    //   1249: aload_3
    //   1250: ldc_w ' Problematic adapter: '
    //   1253: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1256: pop
    //   1257: aload_3
    //   1258: aload_0
    //   1259: getfield mAdapter : Landroid/support/v4/view/PagerAdapter;
    //   1262: invokevirtual getClass : ()Ljava/lang/Class;
    //   1265: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1268: pop
    //   1269: new java/lang/IllegalStateException
    //   1272: dup
    //   1273: aload_3
    //   1274: invokevirtual toString : ()Ljava/lang/String;
    //   1277: invokespecial <init> : (Ljava/lang/String;)V
    //   1280: athrow
    // Exception table:
    //   from	to	target	type
    //   1150	1163	1166	android/content/res/Resources$NotFoundException
  }
  
  public void removeOnAdapterChangeListener(@NonNull OnAdapterChangeListener paramOnAdapterChangeListener) {
    List<OnAdapterChangeListener> list = this.mAdapterChangeListeners;
    if (list != null)
      list.remove(paramOnAdapterChangeListener); 
  }
  
  public void removeOnPageChangeListener(@NonNull OnPageChangeListener paramOnPageChangeListener) {
    List<OnPageChangeListener> list = this.mOnPageChangeListeners;
    if (list != null)
      list.remove(paramOnPageChangeListener); 
  }
  
  public void removeView(View paramView) {
    if (this.mInLayout) {
      removeViewInLayout(paramView);
    } else {
      super.removeView(paramView);
    } 
  }
  
  public void setAdapter(@Nullable PagerAdapter paramPagerAdapter) {
    PagerAdapter pagerAdapter1 = this.mAdapter;
    byte b = 0;
    if (pagerAdapter1 != null) {
      pagerAdapter1.setViewPagerObserver(null);
      this.mAdapter.startUpdate(this);
      for (byte b1 = 0; b1 < this.mItems.size(); b1++) {
        ItemInfo itemInfo = this.mItems.get(b1);
        this.mAdapter.destroyItem(this, itemInfo.position, itemInfo.object);
      } 
      this.mAdapter.finishUpdate(this);
      this.mItems.clear();
      removeNonDecorViews();
      this.mCurItem = 0;
      scrollTo(0, 0);
    } 
    PagerAdapter pagerAdapter2 = this.mAdapter;
    this.mAdapter = paramPagerAdapter;
    this.mExpectedAdapterCount = 0;
    if (this.mAdapter != null) {
      if (this.mObserver == null)
        this.mObserver = new PagerObserver(); 
      this.mAdapter.setViewPagerObserver(this.mObserver);
      this.mPopulatePending = false;
      boolean bool = this.mFirstLayout;
      this.mFirstLayout = true;
      this.mExpectedAdapterCount = this.mAdapter.getCount();
      if (this.mRestoredCurItem >= 0) {
        this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
        setCurrentItemInternal(this.mRestoredCurItem, false, true);
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
      } else if (!bool) {
        populate();
      } else {
        requestLayout();
      } 
    } 
    List<OnAdapterChangeListener> list = this.mAdapterChangeListeners;
    if (list != null && !list.isEmpty()) {
      int i = this.mAdapterChangeListeners.size();
      for (byte b1 = b; b1 < i; b1++)
        ((OnAdapterChangeListener)this.mAdapterChangeListeners.get(b1)).onAdapterChanged(this, pagerAdapter2, paramPagerAdapter); 
    } 
  }
  
  public void setCurrentItem(int paramInt) {
    this.mPopulatePending = false;
    setCurrentItemInternal(paramInt, this.mFirstLayout ^ true, false);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean) {
    this.mPopulatePending = false;
    setCurrentItemInternal(paramInt, paramBoolean, false);
  }
  
  void setCurrentItemInternal(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
    setCurrentItemInternal(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  void setCurrentItemInternal(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2) {
    int i;
    PagerAdapter pagerAdapter = this.mAdapter;
    if (pagerAdapter == null || pagerAdapter.getCount() <= 0) {
      setScrollingCacheEnabled(false);
      return;
    } 
    if (!paramBoolean2 && this.mCurItem == paramInt1 && this.mItems.size() != 0) {
      setScrollingCacheEnabled(false);
      return;
    } 
    paramBoolean2 = true;
    if (paramInt1 < 0) {
      i = 0;
    } else {
      i = paramInt1;
      if (paramInt1 >= this.mAdapter.getCount())
        i = this.mAdapter.getCount() - 1; 
    } 
    paramInt1 = this.mOffscreenPageLimit;
    int j = this.mCurItem;
    if (i > j + paramInt1 || i < j - paramInt1)
      for (paramInt1 = 0; paramInt1 < this.mItems.size(); paramInt1++)
        ((ItemInfo)this.mItems.get(paramInt1)).scrolling = true;  
    if (this.mCurItem == i)
      paramBoolean2 = false; 
    if (this.mFirstLayout) {
      this.mCurItem = i;
      if (paramBoolean2)
        dispatchOnPageSelected(i); 
      requestLayout();
    } else {
      populate(i);
      scrollToItem(i, paramBoolean1, paramInt2, paramBoolean2);
    } 
  }
  
  OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener paramOnPageChangeListener) {
    OnPageChangeListener onPageChangeListener = this.mInternalPageChangeListener;
    this.mInternalPageChangeListener = paramOnPageChangeListener;
    return onPageChangeListener;
  }
  
  public void setOffscreenPageLimit(int paramInt) {
    int i = paramInt;
    if (paramInt < 1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Requested offscreen page limit ");
      stringBuilder.append(paramInt);
      stringBuilder.append(" too small; defaulting to ");
      stringBuilder.append(1);
      Log.w("ViewPager", stringBuilder.toString());
      i = 1;
    } 
    if (i != this.mOffscreenPageLimit) {
      this.mOffscreenPageLimit = i;
      populate();
    } 
  }
  
  @Deprecated
  public void setOnPageChangeListener(OnPageChangeListener paramOnPageChangeListener) {
    this.mOnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setPageMargin(int paramInt) {
    int i = this.mPageMargin;
    this.mPageMargin = paramInt;
    int j = getWidth();
    recomputeScrollPosition(j, j, paramInt, i);
    requestLayout();
  }
  
  public void setPageMarginDrawable(@DrawableRes int paramInt) {
    setPageMarginDrawable(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setPageMarginDrawable(@Nullable Drawable paramDrawable) {
    boolean bool;
    this.mMarginDrawable = paramDrawable;
    if (paramDrawable != null)
      refreshDrawableState(); 
    if (paramDrawable == null) {
      bool = true;
    } else {
      bool = false;
    } 
    setWillNotDraw(bool);
    invalidate();
  }
  
  public void setPageTransformer(boolean paramBoolean, @Nullable PageTransformer paramPageTransformer) {
    setPageTransformer(paramBoolean, paramPageTransformer, 2);
  }
  
  public void setPageTransformer(boolean paramBoolean, @Nullable PageTransformer paramPageTransformer, int paramInt) {
    boolean bool1;
    boolean bool2;
    boolean bool3;
    byte b = 1;
    if (paramPageTransformer != null) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (this.mPageTransformer != null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (bool1 != bool2) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    this.mPageTransformer = paramPageTransformer;
    setChildrenDrawingOrderEnabled(bool1);
    if (bool1) {
      if (paramBoolean)
        b = 2; 
      this.mDrawingOrder = b;
      this.mPageTransformerLayerType = paramInt;
    } else {
      this.mDrawingOrder = 0;
    } 
    if (bool3)
      populate(); 
  }
  
  void setScrollState(int paramInt) {
    if (this.mScrollState == paramInt)
      return; 
    this.mScrollState = paramInt;
    if (this.mPageTransformer != null) {
      boolean bool;
      if (paramInt != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      enableLayers(bool);
    } 
    dispatchOnScrollStateChanged(paramInt);
  }
  
  void smoothScrollTo(int paramInt1, int paramInt2) {
    smoothScrollTo(paramInt1, paramInt2, 0);
  }
  
  void smoothScrollTo(int paramInt1, int paramInt2, int paramInt3) {
    int i;
    if (getChildCount() == 0) {
      setScrollingCacheEnabled(false);
      return;
    } 
    Scroller scroller = this.mScroller;
    if (scroller != null && !scroller.isFinished()) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i) {
      if (this.mIsScrollStarted) {
        i = this.mScroller.getCurrX();
      } else {
        i = this.mScroller.getStartX();
      } 
      this.mScroller.abortAnimation();
      setScrollingCacheEnabled(false);
    } else {
      i = getScrollX();
    } 
    int j = getScrollY();
    int k = paramInt1 - i;
    paramInt2 -= j;
    if (k == 0 && paramInt2 == 0) {
      completeScroll(false);
      populate();
      setScrollState(0);
      return;
    } 
    setScrollingCacheEnabled(true);
    setScrollState(2);
    int m = getClientWidth();
    paramInt1 = m / 2;
    float f1 = Math.abs(k);
    float f2 = m;
    float f3 = Math.min(1.0F, f1 * 1.0F / f2);
    f1 = paramInt1;
    f3 = distanceInfluenceForSnapDuration(f3);
    paramInt1 = Math.abs(paramInt3);
    if (paramInt1 > 0) {
      paramInt1 = Math.round(Math.abs((f1 + f3 * f1) / paramInt1) * 1000.0F) * 4;
    } else {
      f1 = this.mAdapter.getPageWidth(this.mCurItem);
      paramInt1 = (int)((Math.abs(k) / (f2 * f1 + this.mPageMargin) + 1.0F) * 100.0F);
    } 
    paramInt1 = Math.min(paramInt1, 600);
    this.mIsScrollStarted = false;
    this.mScroller.startScroll(i, j, k, paramInt2, paramInt1);
    ViewCompat.postInvalidateOnAnimation((View)this);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable) {
    return (super.verifyDrawable(paramDrawable) || paramDrawable == this.mMarginDrawable);
  }
  
  @Inherited
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.TYPE})
  public static @interface DecorView {}
  
  static class ItemInfo {
    Object object;
    
    float offset;
    
    int position;
    
    boolean scrolling;
    
    float widthFactor;
  }
  
  public static class LayoutParams extends ViewGroup.LayoutParams {
    int childIndex;
    
    public int gravity;
    
    public boolean isDecor;
    
    boolean needsMeasure;
    
    int position;
    
    float widthFactor = 0.0F;
    
    public LayoutParams() {
      super(-1, -1);
    }
    
    public LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, ViewPager.LAYOUT_ATTRS);
      this.gravity = typedArray.getInteger(0, 48);
      typedArray.recycle();
    }
  }
  
  class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
    private boolean canScroll() {
      PagerAdapter pagerAdapter = ViewPager.this.mAdapter;
      boolean bool = true;
      if (pagerAdapter == null || ViewPager.this.mAdapter.getCount() <= 1)
        bool = false; 
      return bool;
    }
    
    public void onInitializeAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      super.onInitializeAccessibilityEvent(param1View, param1AccessibilityEvent);
      param1AccessibilityEvent.setClassName(ViewPager.class.getName());
      param1AccessibilityEvent.setScrollable(canScroll());
      if (param1AccessibilityEvent.getEventType() == 4096 && ViewPager.this.mAdapter != null) {
        param1AccessibilityEvent.setItemCount(ViewPager.this.mAdapter.getCount());
        param1AccessibilityEvent.setFromIndex(ViewPager.this.mCurItem);
        param1AccessibilityEvent.setToIndex(ViewPager.this.mCurItem);
      } 
    }
    
    public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
      super.onInitializeAccessibilityNodeInfo(param1View, param1AccessibilityNodeInfoCompat);
      param1AccessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
      param1AccessibilityNodeInfoCompat.setScrollable(canScroll());
      if (ViewPager.this.canScrollHorizontally(1))
        param1AccessibilityNodeInfoCompat.addAction(4096); 
      if (ViewPager.this.canScrollHorizontally(-1))
        param1AccessibilityNodeInfoCompat.addAction(8192); 
    }
    
    public boolean performAccessibilityAction(View param1View, int param1Int, Bundle param1Bundle) {
      if (super.performAccessibilityAction(param1View, param1Int, param1Bundle))
        return true; 
      if (param1Int != 4096) {
        if (param1Int != 8192)
          return false; 
        if (ViewPager.this.canScrollHorizontally(-1)) {
          ViewPager viewPager = ViewPager.this;
          viewPager.setCurrentItem(viewPager.mCurItem - 1);
          return true;
        } 
        return false;
      } 
      if (ViewPager.this.canScrollHorizontally(1)) {
        ViewPager viewPager = ViewPager.this;
        viewPager.setCurrentItem(viewPager.mCurItem + 1);
        return true;
      } 
      return false;
    }
  }
  
  public static interface OnAdapterChangeListener {
    void onAdapterChanged(@NonNull ViewPager param1ViewPager, @Nullable PagerAdapter param1PagerAdapter1, @Nullable PagerAdapter param1PagerAdapter2);
  }
  
  public static interface OnPageChangeListener {
    void onPageScrollStateChanged(int param1Int);
    
    void onPageScrolled(int param1Int1, float param1Float, int param1Int2);
    
    void onPageSelected(int param1Int);
  }
  
  public static interface PageTransformer {
    void transformPage(@NonNull View param1View, float param1Float);
  }
  
  private class PagerObserver extends DataSetObserver {
    public void onChanged() {
      ViewPager.this.dataSetChanged();
    }
    
    public void onInvalidated() {
      ViewPager.this.dataSetChanged();
    }
  }
  
  public static class SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = (Parcelable.Creator<SavedState>)new Parcelable.ClassLoaderCreator<SavedState>() {
        public ViewPager.SavedState createFromParcel(Parcel param2Parcel) {
          return new ViewPager.SavedState(param2Parcel, null);
        }
        
        public ViewPager.SavedState createFromParcel(Parcel param2Parcel, ClassLoader param2ClassLoader) {
          return new ViewPager.SavedState(param2Parcel, param2ClassLoader);
        }
        
        public ViewPager.SavedState[] newArray(int param2Int) {
          return new ViewPager.SavedState[param2Int];
        }
      };
    
    Parcelable adapterState;
    
    ClassLoader loader;
    
    int position;
    
    SavedState(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      ClassLoader classLoader = param1ClassLoader;
      if (param1ClassLoader == null)
        classLoader = getClass().getClassLoader(); 
      this.position = param1Parcel.readInt();
      this.adapterState = param1Parcel.readParcelable(classLoader);
      this.loader = classLoader;
    }
    
    public SavedState(@NonNull Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("FragmentPager.SavedState{");
      stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      stringBuilder.append(" position=");
      stringBuilder.append(this.position);
      stringBuilder.append("}");
      return stringBuilder.toString();
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeInt(this.position);
      param1Parcel.writeParcelable(this.adapterState, param1Int);
    }
  }
  
  static final class null implements Parcelable.ClassLoaderCreator<SavedState> {
    public ViewPager.SavedState createFromParcel(Parcel param1Parcel) {
      return new ViewPager.SavedState(param1Parcel, null);
    }
    
    public ViewPager.SavedState createFromParcel(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return new ViewPager.SavedState(param1Parcel, param1ClassLoader);
    }
    
    public ViewPager.SavedState[] newArray(int param1Int) {
      return new ViewPager.SavedState[param1Int];
    }
  }
  
  public static class SimpleOnPageChangeListener implements OnPageChangeListener {
    public void onPageScrollStateChanged(int param1Int) {}
    
    public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
    
    public void onPageSelected(int param1Int) {}
  }
  
  static class ViewPositionComparator implements Comparator<View> {
    public int compare(View param1View1, View param1View2) {
      ViewPager.LayoutParams layoutParams1 = (ViewPager.LayoutParams)param1View1.getLayoutParams();
      ViewPager.LayoutParams layoutParams2 = (ViewPager.LayoutParams)param1View2.getLayoutParams();
      if (layoutParams1.isDecor != layoutParams2.isDecor) {
        byte b;
        if (layoutParams1.isDecor) {
          b = 1;
        } else {
          b = -1;
        } 
        return b;
      } 
      return layoutParams1.position - layoutParams2.position;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\v4\view\ViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */