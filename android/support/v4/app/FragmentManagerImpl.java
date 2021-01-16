package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.arch.lifecycle.ViewModelStore;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.v4.util.ArraySet;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class FragmentManagerImpl extends FragmentManager implements LayoutInflater.Factory2 {
  static final Interpolator ACCELERATE_CUBIC;
  
  static final Interpolator ACCELERATE_QUINT;
  
  static final int ANIM_DUR = 220;
  
  public static final int ANIM_STYLE_CLOSE_ENTER = 3;
  
  public static final int ANIM_STYLE_CLOSE_EXIT = 4;
  
  public static final int ANIM_STYLE_FADE_ENTER = 5;
  
  public static final int ANIM_STYLE_FADE_EXIT = 6;
  
  public static final int ANIM_STYLE_OPEN_ENTER = 1;
  
  public static final int ANIM_STYLE_OPEN_EXIT = 2;
  
  static boolean DEBUG = false;
  
  static final Interpolator DECELERATE_CUBIC;
  
  static final Interpolator DECELERATE_QUINT = (Interpolator)new DecelerateInterpolator(2.5F);
  
  static final String TAG = "FragmentManager";
  
  static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
  
  static final String TARGET_STATE_TAG = "android:target_state";
  
  static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
  
  static final String VIEW_STATE_TAG = "android:view_state";
  
  static Field sAnimationListenerField;
  
  SparseArray<Fragment> mActive;
  
  final ArrayList<Fragment> mAdded = new ArrayList<Fragment>();
  
  ArrayList<Integer> mAvailBackStackIndices;
  
  ArrayList<BackStackRecord> mBackStack;
  
  ArrayList<FragmentManager.OnBackStackChangedListener> mBackStackChangeListeners;
  
  ArrayList<BackStackRecord> mBackStackIndices;
  
  FragmentContainer mContainer;
  
  ArrayList<Fragment> mCreatedMenus;
  
  int mCurState = 0;
  
  boolean mDestroyed;
  
  Runnable mExecCommit = new Runnable() {
      public void run() {
        FragmentManagerImpl.this.execPendingActions();
      }
    };
  
  boolean mExecutingActions;
  
  boolean mHavePendingDeferredStart;
  
  FragmentHostCallback mHost;
  
  private final CopyOnWriteArrayList<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> mLifecycleCallbacks = new CopyOnWriteArrayList<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>>();
  
  boolean mNeedMenuInvalidate;
  
  int mNextFragmentIndex = 0;
  
  String mNoTransactionsBecause;
  
  Fragment mParent;
  
  ArrayList<OpGenerator> mPendingActions;
  
  ArrayList<StartEnterTransitionListener> mPostponedTransactions;
  
  Fragment mPrimaryNav;
  
  FragmentManagerNonConfig mSavedNonConfig;
  
  SparseArray<Parcelable> mStateArray = null;
  
  Bundle mStateBundle = null;
  
  boolean mStateSaved;
  
  boolean mStopped;
  
  ArrayList<Fragment> mTmpAddedFragments;
  
  ArrayList<Boolean> mTmpIsPop;
  
  ArrayList<BackStackRecord> mTmpRecords;
  
  static {
    DECELERATE_CUBIC = (Interpolator)new DecelerateInterpolator(1.5F);
    ACCELERATE_QUINT = (Interpolator)new AccelerateInterpolator(2.5F);
    ACCELERATE_CUBIC = (Interpolator)new AccelerateInterpolator(1.5F);
  }
  
  private void addAddedFragments(ArraySet<Fragment> paramArraySet) {
    int i = this.mCurState;
    if (i < 1)
      return; 
    int j = Math.min(i, 4);
    int k = this.mAdded.size();
    for (i = 0; i < k; i++) {
      Fragment fragment = this.mAdded.get(i);
      if (fragment.mState < j) {
        moveToState(fragment, j, fragment.getNextAnim(), fragment.getNextTransition(), false);
        if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded)
          paramArraySet.add(fragment); 
      } 
    } 
  }
  
  private void animateRemoveFragment(@NonNull final Fragment fragment, @NonNull AnimationOrAnimator paramAnimationOrAnimator, int paramInt) {
    final View viewToAnimate = fragment.mView;
    final ViewGroup container = fragment.mContainer;
    viewGroup.startViewTransition(view);
    fragment.setStateAfterAnimating(paramInt);
    if (paramAnimationOrAnimator.animation != null) {
      EndViewTransitionAnimator endViewTransitionAnimator = new EndViewTransitionAnimator(paramAnimationOrAnimator.animation, viewGroup, view);
      fragment.setAnimatingAway(fragment.mView);
      endViewTransitionAnimator.setAnimationListener(new AnimationListenerWrapper(getAnimationListener((Animation)endViewTransitionAnimator)) {
            public void onAnimationEnd(Animation param1Animation) {
              super.onAnimationEnd(param1Animation);
              container.post(new Runnable() {
                    public void run() {
                      if (fragment.getAnimatingAway() != null) {
                        fragment.setAnimatingAway(null);
                        FragmentManagerImpl.this.moveToState(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
                      } 
                    }
                  });
            }
          });
      setHWLayerAnimListenerIfAlpha(view, paramAnimationOrAnimator);
      fragment.mView.startAnimation((Animation)endViewTransitionAnimator);
    } else {
      Animator animator = paramAnimationOrAnimator.animator;
      fragment.setAnimator(paramAnimationOrAnimator.animator);
      animator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator param1Animator) {
              container.endViewTransition(viewToAnimate);
              param1Animator = fragment.getAnimator();
              fragment.setAnimator(null);
              if (param1Animator != null && container.indexOfChild(viewToAnimate) < 0) {
                FragmentManagerImpl fragmentManagerImpl = FragmentManagerImpl.this;
                Fragment fragment = fragment;
                fragmentManagerImpl.moveToState(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
              } 
            }
          });
      animator.setTarget(fragment.mView);
      setHWLayerAnimListenerIfAlpha(fragment.mView, paramAnimationOrAnimator);
      animator.start();
    } 
  }
  
  private void burpActive() {
    SparseArray<Fragment> sparseArray = this.mActive;
    if (sparseArray != null)
      for (int i = sparseArray.size() - 1; i >= 0; i--) {
        if (this.mActive.valueAt(i) == null) {
          sparseArray = this.mActive;
          sparseArray.delete(sparseArray.keyAt(i));
        } 
      }  
  }
  
  private void checkStateLoss() {
    if (!isStateSaved()) {
      if (this.mNoTransactionsBecause == null)
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Can not perform this action inside of ");
      stringBuilder.append(this.mNoTransactionsBecause);
      throw new IllegalStateException(stringBuilder.toString());
    } 
    throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
  }
  
  private void cleanupExec() {
    this.mExecutingActions = false;
    this.mTmpIsPop.clear();
    this.mTmpRecords.clear();
  }
  
  private void completeExecute(BackStackRecord paramBackStackRecord, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    if (paramBoolean1) {
      paramBackStackRecord.executePopOps(paramBoolean3);
    } else {
      paramBackStackRecord.executeOps();
    } 
    ArrayList<BackStackRecord> arrayList = new ArrayList(1);
    ArrayList<Boolean> arrayList1 = new ArrayList(1);
    arrayList.add(paramBackStackRecord);
    arrayList1.add(Boolean.valueOf(paramBoolean1));
    if (paramBoolean2)
      FragmentTransition.startTransitions(this, arrayList, arrayList1, 0, 1, true); 
    if (paramBoolean3)
      moveToState(this.mCurState, true); 
    SparseArray<Fragment> sparseArray = this.mActive;
    if (sparseArray != null) {
      int i = sparseArray.size();
      for (byte b = 0; b < i; b++) {
        Fragment fragment = (Fragment)this.mActive.valueAt(b);
        if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && paramBackStackRecord.interactsWith(fragment.mContainerId)) {
          if (fragment.mPostponedAlpha > 0.0F)
            fragment.mView.setAlpha(fragment.mPostponedAlpha); 
          if (paramBoolean3) {
            fragment.mPostponedAlpha = 0.0F;
          } else {
            fragment.mPostponedAlpha = -1.0F;
            fragment.mIsNewlyAdded = false;
          } 
        } 
      } 
    } 
  }
  
  private void dispatchStateChange(int paramInt) {
    try {
      this.mExecutingActions = true;
      moveToState(paramInt, false);
      this.mExecutingActions = false;
      return;
    } finally {
      this.mExecutingActions = false;
    } 
  }
  
  private void endAnimatingAwayFragments() {
    int i;
    SparseArray<Fragment> sparseArray = this.mActive;
    byte b = 0;
    if (sparseArray == null) {
      i = 0;
    } else {
      i = sparseArray.size();
    } 
    while (b < i) {
      Fragment fragment = (Fragment)this.mActive.valueAt(b);
      if (fragment != null)
        if (fragment.getAnimatingAway() != null) {
          int j = fragment.getStateAfterAnimating();
          View view = fragment.getAnimatingAway();
          Animation animation = view.getAnimation();
          if (animation != null) {
            animation.cancel();
            view.clearAnimation();
          } 
          fragment.setAnimatingAway(null);
          moveToState(fragment, j, 0, 0, false);
        } else if (fragment.getAnimator() != null) {
          fragment.getAnimator().end();
        }  
      b++;
    } 
  }
  
  private void ensureExecReady(boolean paramBoolean) {
    if (!this.mExecutingActions) {
      if (this.mHost != null) {
        if (Looper.myLooper() == this.mHost.getHandler().getLooper()) {
          if (!paramBoolean)
            checkStateLoss(); 
          if (this.mTmpRecords == null) {
            this.mTmpRecords = new ArrayList<BackStackRecord>();
            this.mTmpIsPop = new ArrayList<Boolean>();
          } 
          this.mExecutingActions = true;
          try {
            executePostponedTransaction(null, null);
            return;
          } finally {
            this.mExecutingActions = false;
          } 
        } 
        throw new IllegalStateException("Must be called from main thread of fragment host");
      } 
      throw new IllegalStateException("Fragment host has been destroyed");
    } 
    throw new IllegalStateException("FragmentManager is already executing transactions");
  }
  
  private static void executeOps(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2) {
    while (paramInt1 < paramInt2) {
      BackStackRecord backStackRecord = paramArrayList.get(paramInt1);
      boolean bool = ((Boolean)paramArrayList1.get(paramInt1)).booleanValue();
      boolean bool1 = true;
      if (bool) {
        backStackRecord.bumpBackStackNesting(-1);
        if (paramInt1 != paramInt2 - 1)
          bool1 = false; 
        backStackRecord.executePopOps(bool1);
      } else {
        backStackRecord.bumpBackStackNesting(1);
        backStackRecord.executeOps();
      } 
      paramInt1++;
    } 
  }
  
  private void executeOpsTogether(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2) {
    int k;
    int i = paramInt1;
    boolean bool = ((BackStackRecord)paramArrayList.get(i)).mReorderingAllowed;
    ArrayList<Fragment> arrayList = this.mTmpAddedFragments;
    if (arrayList == null) {
      this.mTmpAddedFragments = new ArrayList<Fragment>();
    } else {
      arrayList.clear();
    } 
    this.mTmpAddedFragments.addAll(this.mAdded);
    Fragment fragment = getPrimaryNavigationFragment();
    int j = i;
    boolean bool1 = false;
    while (j < paramInt2) {
      BackStackRecord backStackRecord = paramArrayList.get(j);
      if (!((Boolean)paramArrayList1.get(j)).booleanValue()) {
        fragment = backStackRecord.expandOps(this.mTmpAddedFragments, fragment);
      } else {
        fragment = backStackRecord.trackAddedFragmentsInPop(this.mTmpAddedFragments, fragment);
      } 
      if (bool1 || backStackRecord.mAddToBackStack) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      j++;
    } 
    this.mTmpAddedFragments.clear();
    if (!bool)
      FragmentTransition.startTransitions(this, paramArrayList, paramArrayList1, paramInt1, paramInt2, false); 
    executeOps(paramArrayList, paramArrayList1, paramInt1, paramInt2);
    if (bool) {
      ArraySet<Fragment> arraySet = new ArraySet();
      addAddedFragments(arraySet);
      k = postponePostponableTransactions(paramArrayList, paramArrayList1, paramInt1, paramInt2, arraySet);
      makeRemovedFragmentsInvisible(arraySet);
    } else {
      k = paramInt2;
    } 
    j = i;
    if (k != i) {
      j = i;
      if (bool) {
        FragmentTransition.startTransitions(this, paramArrayList, paramArrayList1, paramInt1, k, true);
        moveToState(this.mCurState, true);
        j = i;
      } 
    } 
    while (j < paramInt2) {
      BackStackRecord backStackRecord = paramArrayList.get(j);
      if (((Boolean)paramArrayList1.get(j)).booleanValue() && backStackRecord.mIndex >= 0) {
        freeBackStackIndex(backStackRecord.mIndex);
        backStackRecord.mIndex = -1;
      } 
      backStackRecord.runOnCommitRunnables();
      j++;
    } 
    if (bool1)
      reportBackStackChanged(); 
  }
  
  private void executePostponedTransaction(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mPostponedTransactions : Ljava/util/ArrayList;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnonnull -> 15
    //   9: iconst_0
    //   10: istore #4
    //   12: goto -> 21
    //   15: aload_3
    //   16: invokevirtual size : ()I
    //   19: istore #4
    //   21: iconst_0
    //   22: istore #5
    //   24: iload #4
    //   26: istore #6
    //   28: iload #5
    //   30: istore #4
    //   32: iload #4
    //   34: iload #6
    //   36: if_icmpge -> 240
    //   39: aload_0
    //   40: getfield mPostponedTransactions : Ljava/util/ArrayList;
    //   43: iload #4
    //   45: invokevirtual get : (I)Ljava/lang/Object;
    //   48: checkcast android/support/v4/app/FragmentManagerImpl$StartEnterTransitionListener
    //   51: astore_3
    //   52: aload_1
    //   53: ifnull -> 109
    //   56: aload_3
    //   57: invokestatic access$300 : (Landroid/support/v4/app/FragmentManagerImpl$StartEnterTransitionListener;)Z
    //   60: ifne -> 109
    //   63: aload_1
    //   64: aload_3
    //   65: invokestatic access$400 : (Landroid/support/v4/app/FragmentManagerImpl$StartEnterTransitionListener;)Landroid/support/v4/app/BackStackRecord;
    //   68: invokevirtual indexOf : (Ljava/lang/Object;)I
    //   71: istore #5
    //   73: iload #5
    //   75: iconst_m1
    //   76: if_icmpeq -> 109
    //   79: aload_2
    //   80: iload #5
    //   82: invokevirtual get : (I)Ljava/lang/Object;
    //   85: checkcast java/lang/Boolean
    //   88: invokevirtual booleanValue : ()Z
    //   91: ifeq -> 109
    //   94: aload_3
    //   95: invokevirtual cancelTransaction : ()V
    //   98: iload #4
    //   100: istore #7
    //   102: iload #6
    //   104: istore #5
    //   106: goto -> 227
    //   109: aload_3
    //   110: invokevirtual isReady : ()Z
    //   113: ifne -> 152
    //   116: iload #4
    //   118: istore #7
    //   120: iload #6
    //   122: istore #5
    //   124: aload_1
    //   125: ifnull -> 227
    //   128: iload #4
    //   130: istore #7
    //   132: iload #6
    //   134: istore #5
    //   136: aload_3
    //   137: invokestatic access$400 : (Landroid/support/v4/app/FragmentManagerImpl$StartEnterTransitionListener;)Landroid/support/v4/app/BackStackRecord;
    //   140: aload_1
    //   141: iconst_0
    //   142: aload_1
    //   143: invokevirtual size : ()I
    //   146: invokevirtual interactsWith : (Ljava/util/ArrayList;II)Z
    //   149: ifeq -> 227
    //   152: aload_0
    //   153: getfield mPostponedTransactions : Ljava/util/ArrayList;
    //   156: iload #4
    //   158: invokevirtual remove : (I)Ljava/lang/Object;
    //   161: pop
    //   162: iload #4
    //   164: iconst_1
    //   165: isub
    //   166: istore #7
    //   168: iload #6
    //   170: iconst_1
    //   171: isub
    //   172: istore #5
    //   174: aload_1
    //   175: ifnull -> 223
    //   178: aload_3
    //   179: invokestatic access$300 : (Landroid/support/v4/app/FragmentManagerImpl$StartEnterTransitionListener;)Z
    //   182: ifne -> 223
    //   185: aload_1
    //   186: aload_3
    //   187: invokestatic access$400 : (Landroid/support/v4/app/FragmentManagerImpl$StartEnterTransitionListener;)Landroid/support/v4/app/BackStackRecord;
    //   190: invokevirtual indexOf : (Ljava/lang/Object;)I
    //   193: istore #4
    //   195: iload #4
    //   197: iconst_m1
    //   198: if_icmpeq -> 223
    //   201: aload_2
    //   202: iload #4
    //   204: invokevirtual get : (I)Ljava/lang/Object;
    //   207: checkcast java/lang/Boolean
    //   210: invokevirtual booleanValue : ()Z
    //   213: ifeq -> 223
    //   216: aload_3
    //   217: invokevirtual cancelTransaction : ()V
    //   220: goto -> 227
    //   223: aload_3
    //   224: invokevirtual completeTransaction : ()V
    //   227: iload #7
    //   229: iconst_1
    //   230: iadd
    //   231: istore #4
    //   233: iload #5
    //   235: istore #6
    //   237: goto -> 32
    //   240: return
  }
  
  private Fragment findFragmentUnder(Fragment paramFragment) {
    ViewGroup viewGroup = paramFragment.mContainer;
    View view = paramFragment.mView;
    if (viewGroup == null || view == null)
      return null; 
    for (int i = this.mAdded.indexOf(paramFragment) - 1; i >= 0; i--) {
      paramFragment = this.mAdded.get(i);
      if (paramFragment.mContainer == viewGroup && paramFragment.mView != null)
        return paramFragment; 
    } 
    return null;
  }
  
  private void forcePostponedTransactions() {
    if (this.mPostponedTransactions != null)
      while (!this.mPostponedTransactions.isEmpty())
        ((StartEnterTransitionListener)this.mPostponedTransactions.remove(0)).completeTransaction();  
  }
  
  private boolean generateOpsForPendingActions(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mPendingActions : Ljava/util/ArrayList;
    //   6: astore_3
    //   7: iconst_0
    //   8: istore #4
    //   10: aload_3
    //   11: ifnull -> 102
    //   14: aload_0
    //   15: getfield mPendingActions : Ljava/util/ArrayList;
    //   18: invokevirtual size : ()I
    //   21: ifne -> 27
    //   24: goto -> 102
    //   27: aload_0
    //   28: getfield mPendingActions : Ljava/util/ArrayList;
    //   31: invokevirtual size : ()I
    //   34: istore #5
    //   36: iconst_0
    //   37: istore #6
    //   39: iload #4
    //   41: iload #5
    //   43: if_icmpge -> 76
    //   46: iload #6
    //   48: aload_0
    //   49: getfield mPendingActions : Ljava/util/ArrayList;
    //   52: iload #4
    //   54: invokevirtual get : (I)Ljava/lang/Object;
    //   57: checkcast android/support/v4/app/FragmentManagerImpl$OpGenerator
    //   60: aload_1
    //   61: aload_2
    //   62: invokeinterface generateOps : (Ljava/util/ArrayList;Ljava/util/ArrayList;)Z
    //   67: ior
    //   68: istore #6
    //   70: iinc #4, 1
    //   73: goto -> 39
    //   76: aload_0
    //   77: getfield mPendingActions : Ljava/util/ArrayList;
    //   80: invokevirtual clear : ()V
    //   83: aload_0
    //   84: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   87: invokevirtual getHandler : ()Landroid/os/Handler;
    //   90: aload_0
    //   91: getfield mExecCommit : Ljava/lang/Runnable;
    //   94: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   97: aload_0
    //   98: monitorexit
    //   99: iload #6
    //   101: ireturn
    //   102: aload_0
    //   103: monitorexit
    //   104: iconst_0
    //   105: ireturn
    //   106: astore_1
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_1
    //   110: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	106	finally
    //   14	24	106	finally
    //   27	36	106	finally
    //   46	70	106	finally
    //   76	99	106	finally
    //   102	104	106	finally
    //   107	109	106	finally
  }
  
  private static Animation.AnimationListener getAnimationListener(Animation paramAnimation) {
    try {
      if (sAnimationListenerField == null) {
        sAnimationListenerField = Animation.class.getDeclaredField("mListener");
        sAnimationListenerField.setAccessible(true);
      } 
      Animation.AnimationListener animationListener = (Animation.AnimationListener)sAnimationListenerField.get(paramAnimation);
    } catch (NoSuchFieldException noSuchFieldException) {
      Log.e("FragmentManager", "No field with the name mListener is found in Animation class", noSuchFieldException);
      noSuchFieldException = null;
    } catch (IllegalAccessException illegalAccessException) {
      Log.e("FragmentManager", "Cannot access Animation's mListener field", illegalAccessException);
    } 
    return (Animation.AnimationListener)illegalAccessException;
  }
  
  static AnimationOrAnimator makeFadeAnimation(Context paramContext, float paramFloat1, float paramFloat2) {
    AlphaAnimation alphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    alphaAnimation.setInterpolator(DECELERATE_CUBIC);
    alphaAnimation.setDuration(220L);
    return new AnimationOrAnimator((Animation)alphaAnimation);
  }
  
  static AnimationOrAnimator makeOpenCloseAnimation(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    AnimationSet animationSet = new AnimationSet(false);
    ScaleAnimation scaleAnimation = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    scaleAnimation.setInterpolator(DECELERATE_QUINT);
    scaleAnimation.setDuration(220L);
    animationSet.addAnimation((Animation)scaleAnimation);
    AlphaAnimation alphaAnimation = new AlphaAnimation(paramFloat3, paramFloat4);
    alphaAnimation.setInterpolator(DECELERATE_CUBIC);
    alphaAnimation.setDuration(220L);
    animationSet.addAnimation((Animation)alphaAnimation);
    return new AnimationOrAnimator((Animation)animationSet);
  }
  
  private void makeRemovedFragmentsInvisible(ArraySet<Fragment> paramArraySet) {
    int i = paramArraySet.size();
    for (byte b = 0; b < i; b++) {
      Fragment fragment = (Fragment)paramArraySet.valueAt(b);
      if (!fragment.mAdded) {
        View view = fragment.getView();
        fragment.mPostponedAlpha = view.getAlpha();
        view.setAlpha(0.0F);
      } 
    } 
  }
  
  static boolean modifiesAlpha(Animator paramAnimator) {
    PropertyValuesHolder[] arrayOfPropertyValuesHolder;
    if (paramAnimator == null)
      return false; 
    if (paramAnimator instanceof ValueAnimator) {
      arrayOfPropertyValuesHolder = ((ValueAnimator)paramAnimator).getValues();
      for (byte b = 0; b < arrayOfPropertyValuesHolder.length; b++) {
        if ("alpha".equals(arrayOfPropertyValuesHolder[b].getPropertyName()))
          return true; 
      } 
    } else if (arrayOfPropertyValuesHolder instanceof AnimatorSet) {
      ArrayList<Animator> arrayList = ((AnimatorSet)arrayOfPropertyValuesHolder).getChildAnimations();
      for (byte b = 0; b < arrayList.size(); b++) {
        if (modifiesAlpha(arrayList.get(b)))
          return true; 
      } 
    } 
    return false;
  }
  
  static boolean modifiesAlpha(AnimationOrAnimator paramAnimationOrAnimator) {
    List list;
    if (paramAnimationOrAnimator.animation instanceof AlphaAnimation)
      return true; 
    if (paramAnimationOrAnimator.animation instanceof AnimationSet) {
      list = ((AnimationSet)paramAnimationOrAnimator.animation).getAnimations();
      for (byte b = 0; b < list.size(); b++) {
        if (list.get(b) instanceof AlphaAnimation)
          return true; 
      } 
      return false;
    } 
    return modifiesAlpha(((AnimationOrAnimator)list).animator);
  }
  
  private boolean popBackStackImmediate(String paramString, int paramInt1, int paramInt2) {
    execPendingActions();
    ensureExecReady(true);
    Fragment fragment = this.mPrimaryNav;
    if (fragment != null && paramInt1 < 0 && paramString == null) {
      FragmentManager fragmentManager = fragment.peekChildFragmentManager();
      if (fragmentManager != null && fragmentManager.popBackStackImmediate())
        return true; 
    } 
    boolean bool = popBackStackState(this.mTmpRecords, this.mTmpIsPop, paramString, paramInt1, paramInt2);
    if (bool) {
      this.mExecutingActions = true;
      try {
        removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
      } finally {
        cleanupExec();
      } 
    } 
    doPendingDeferredStart();
    burpActive();
    return bool;
  }
  
  private int postponePostponableTransactions(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, ArraySet<Fragment> paramArraySet) {
    int i = paramInt2 - 1;
    int j;
    for (j = paramInt2; i >= paramInt1; j = k) {
      boolean bool1;
      BackStackRecord backStackRecord = paramArrayList.get(i);
      boolean bool = ((Boolean)paramArrayList1.get(i)).booleanValue();
      if (backStackRecord.isPostponed() && !backStackRecord.interactsWith(paramArrayList, i + 1, paramInt2)) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      int k = j;
      if (bool1) {
        if (this.mPostponedTransactions == null)
          this.mPostponedTransactions = new ArrayList<StartEnterTransitionListener>(); 
        StartEnterTransitionListener startEnterTransitionListener = new StartEnterTransitionListener(backStackRecord, bool);
        this.mPostponedTransactions.add(startEnterTransitionListener);
        backStackRecord.setOnStartPostponedListener(startEnterTransitionListener);
        if (bool) {
          backStackRecord.executeOps();
        } else {
          backStackRecord.executePopOps(false);
        } 
        k = j - 1;
        if (i != k) {
          paramArrayList.remove(i);
          paramArrayList.add(k, backStackRecord);
        } 
        addAddedFragments(paramArraySet);
      } 
      i--;
    } 
    return j;
  }
  
  private void removeRedundantOperationsAndExecute(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1) {
    if (paramArrayList == null || paramArrayList.isEmpty())
      return; 
    if (paramArrayList1 != null && paramArrayList.size() == paramArrayList1.size()) {
      executePostponedTransaction(paramArrayList, paramArrayList1);
      int i = paramArrayList.size();
      int j = 0;
      int k;
      for (k = 0; j < i; k = n) {
        int m = j;
        int n = k;
        if (!((BackStackRecord)paramArrayList.get(j)).mReorderingAllowed) {
          if (k != j)
            executeOpsTogether(paramArrayList, paramArrayList1, k, j); 
          k = j + 1;
          n = k;
          if (((Boolean)paramArrayList1.get(j)).booleanValue())
            while (true) {
              n = k;
              if (k < i) {
                n = k;
                if (((Boolean)paramArrayList1.get(k)).booleanValue()) {
                  n = k;
                  if (!((BackStackRecord)paramArrayList.get(k)).mReorderingAllowed) {
                    k++;
                    continue;
                  } 
                } 
              } 
              break;
            }  
          executeOpsTogether(paramArrayList, paramArrayList1, j, n);
          m = n - 1;
        } 
        j = m + 1;
      } 
      if (k != i)
        executeOpsTogether(paramArrayList, paramArrayList1, k, i); 
      return;
    } 
    throw new IllegalStateException("Internal error with the back stack records");
  }
  
  public static int reverseTransit(int paramInt) {
    char c = ' ';
    if (paramInt != 4097)
      if (paramInt != 4099) {
        if (paramInt != 8194) {
          c = Character.MIN_VALUE;
        } else {
          c = 'ခ';
        } 
      } else {
        c = 'ဃ';
      }  
    return c;
  }
  
  private void scheduleCommit() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mPostponedTransactions : Ljava/util/ArrayList;
    //   6: astore_1
    //   7: iconst_0
    //   8: istore_2
    //   9: aload_1
    //   10: ifnull -> 28
    //   13: aload_0
    //   14: getfield mPostponedTransactions : Ljava/util/ArrayList;
    //   17: invokevirtual isEmpty : ()Z
    //   20: ifne -> 28
    //   23: iconst_1
    //   24: istore_3
    //   25: goto -> 30
    //   28: iconst_0
    //   29: istore_3
    //   30: iload_2
    //   31: istore #4
    //   33: aload_0
    //   34: getfield mPendingActions : Ljava/util/ArrayList;
    //   37: ifnull -> 57
    //   40: iload_2
    //   41: istore #4
    //   43: aload_0
    //   44: getfield mPendingActions : Ljava/util/ArrayList;
    //   47: invokevirtual size : ()I
    //   50: iconst_1
    //   51: if_icmpne -> 57
    //   54: iconst_1
    //   55: istore #4
    //   57: iload_3
    //   58: ifne -> 66
    //   61: iload #4
    //   63: ifeq -> 95
    //   66: aload_0
    //   67: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   70: invokevirtual getHandler : ()Landroid/os/Handler;
    //   73: aload_0
    //   74: getfield mExecCommit : Ljava/lang/Runnable;
    //   77: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   80: aload_0
    //   81: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   84: invokevirtual getHandler : ()Landroid/os/Handler;
    //   87: aload_0
    //   88: getfield mExecCommit : Ljava/lang/Runnable;
    //   91: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   94: pop
    //   95: aload_0
    //   96: monitorexit
    //   97: return
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	98	finally
    //   13	23	98	finally
    //   33	40	98	finally
    //   43	54	98	finally
    //   66	95	98	finally
    //   95	97	98	finally
    //   99	101	98	finally
  }
  
  private static void setHWLayerAnimListenerIfAlpha(View paramView, AnimationOrAnimator paramAnimationOrAnimator) {
    if (paramView == null || paramAnimationOrAnimator == null)
      return; 
    if (shouldRunOnHWLayer(paramView, paramAnimationOrAnimator))
      if (paramAnimationOrAnimator.animator != null) {
        paramAnimationOrAnimator.animator.addListener((Animator.AnimatorListener)new AnimatorOnHWLayerIfNeededListener(paramView));
      } else {
        Animation.AnimationListener animationListener = getAnimationListener(paramAnimationOrAnimator.animation);
        paramView.setLayerType(2, null);
        paramAnimationOrAnimator.animation.setAnimationListener(new AnimateOnHWLayerIfNeededListener(paramView, animationListener));
      }  
  }
  
  private static void setRetaining(FragmentManagerNonConfig paramFragmentManagerNonConfig) {
    if (paramFragmentManagerNonConfig == null)
      return; 
    List<Fragment> list1 = paramFragmentManagerNonConfig.getFragments();
    if (list1 != null) {
      Iterator<Fragment> iterator = list1.iterator();
      while (iterator.hasNext())
        ((Fragment)iterator.next()).mRetaining = true; 
    } 
    List<FragmentManagerNonConfig> list = paramFragmentManagerNonConfig.getChildNonConfigs();
    if (list != null) {
      Iterator<FragmentManagerNonConfig> iterator = list.iterator();
      while (iterator.hasNext())
        setRetaining(iterator.next()); 
    } 
  }
  
  static boolean shouldRunOnHWLayer(View paramView, AnimationOrAnimator paramAnimationOrAnimator) {
    boolean bool1 = false;
    if (paramView == null || paramAnimationOrAnimator == null)
      return false; 
    boolean bool2 = bool1;
    if (Build.VERSION.SDK_INT >= 19) {
      bool2 = bool1;
      if (paramView.getLayerType() == 0) {
        bool2 = bool1;
        if (ViewCompat.hasOverlappingRendering(paramView)) {
          bool2 = bool1;
          if (modifiesAlpha(paramAnimationOrAnimator))
            bool2 = true; 
        } 
      } 
    } 
    return bool2;
  }
  
  private void throwException(RuntimeException paramRuntimeException) {
    Log.e("FragmentManager", paramRuntimeException.getMessage());
    Log.e("FragmentManager", "Activity state:");
    PrintWriter printWriter = new PrintWriter((Writer)new LogWriter("FragmentManager"));
    FragmentHostCallback fragmentHostCallback = this.mHost;
    if (fragmentHostCallback != null) {
      try {
        fragmentHostCallback.onDump("  ", null, printWriter, new String[0]);
      } catch (Exception exception) {
        Log.e("FragmentManager", "Failed dumping state", exception);
      } 
    } else {
      try {
        dump("  ", null, printWriter, new String[0]);
      } catch (Exception exception) {
        Log.e("FragmentManager", "Failed dumping state", exception);
      } 
    } 
    throw paramRuntimeException;
  }
  
  public static int transitToStyleIndex(int paramInt, boolean paramBoolean) {
    if (paramInt != 4097) {
      if (paramInt != 4099) {
        if (paramInt != 8194) {
          paramInt = -1;
        } else if (paramBoolean) {
          paramInt = 3;
        } else {
          paramInt = 4;
        } 
      } else if (paramBoolean) {
        paramInt = 5;
      } else {
        paramInt = 6;
      } 
    } else if (paramBoolean) {
      paramInt = 1;
    } else {
      paramInt = 2;
    } 
    return paramInt;
  }
  
  void addBackStackState(BackStackRecord paramBackStackRecord) {
    if (this.mBackStack == null)
      this.mBackStack = new ArrayList<BackStackRecord>(); 
    this.mBackStack.add(paramBackStackRecord);
  }
  
  public void addFragment(Fragment paramFragment, boolean paramBoolean) {
    if (DEBUG) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("add: ");
      stringBuilder.append(paramFragment);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
    makeActive(paramFragment);
    if (!paramFragment.mDetached)
      if (!this.mAdded.contains(paramFragment)) {
        synchronized (this.mAdded) {
          this.mAdded.add(paramFragment);
          paramFragment.mAdded = true;
          paramFragment.mRemoving = false;
          if (paramFragment.mView == null)
            paramFragment.mHiddenChanged = false; 
          if (paramFragment.mHasMenu && paramFragment.mMenuVisible)
            this.mNeedMenuInvalidate = true; 
          if (paramBoolean)
            moveToState(paramFragment); 
        } 
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment already added: ");
        stringBuilder.append(paramFragment);
        throw new IllegalStateException(stringBuilder.toString());
      }  
  }
  
  public void addOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener) {
    if (this.mBackStackChangeListeners == null)
      this.mBackStackChangeListeners = new ArrayList<FragmentManager.OnBackStackChangedListener>(); 
    this.mBackStackChangeListeners.add(paramOnBackStackChangedListener);
  }
  
  public int allocBackStackIndex(BackStackRecord paramBackStackRecord) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   6: ifnull -> 111
    //   9: aload_0
    //   10: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   13: invokevirtual size : ()I
    //   16: ifgt -> 22
    //   19: goto -> 111
    //   22: aload_0
    //   23: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   26: aload_0
    //   27: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   30: invokevirtual size : ()I
    //   33: iconst_1
    //   34: isub
    //   35: invokevirtual remove : (I)Ljava/lang/Object;
    //   38: checkcast java/lang/Integer
    //   41: invokevirtual intValue : ()I
    //   44: istore_2
    //   45: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   48: ifeq -> 97
    //   51: new java/lang/StringBuilder
    //   54: astore_3
    //   55: aload_3
    //   56: invokespecial <init> : ()V
    //   59: aload_3
    //   60: ldc_w 'Adding back stack index '
    //   63: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload_3
    //   68: iload_2
    //   69: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_3
    //   74: ldc_w ' with '
    //   77: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_3
    //   82: aload_1
    //   83: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: ldc 'FragmentManager'
    //   89: aload_3
    //   90: invokevirtual toString : ()Ljava/lang/String;
    //   93: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   96: pop
    //   97: aload_0
    //   98: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   101: iload_2
    //   102: aload_1
    //   103: invokevirtual set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   106: pop
    //   107: aload_0
    //   108: monitorexit
    //   109: iload_2
    //   110: ireturn
    //   111: aload_0
    //   112: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   115: ifnonnull -> 131
    //   118: new java/util/ArrayList
    //   121: astore_3
    //   122: aload_3
    //   123: invokespecial <init> : ()V
    //   126: aload_0
    //   127: aload_3
    //   128: putfield mBackStackIndices : Ljava/util/ArrayList;
    //   131: aload_0
    //   132: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   135: invokevirtual size : ()I
    //   138: istore_2
    //   139: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   142: ifeq -> 191
    //   145: new java/lang/StringBuilder
    //   148: astore_3
    //   149: aload_3
    //   150: invokespecial <init> : ()V
    //   153: aload_3
    //   154: ldc_w 'Setting back stack index '
    //   157: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_3
    //   162: iload_2
    //   163: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload_3
    //   168: ldc_w ' to '
    //   171: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_3
    //   176: aload_1
    //   177: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: ldc 'FragmentManager'
    //   183: aload_3
    //   184: invokevirtual toString : ()Ljava/lang/String;
    //   187: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   190: pop
    //   191: aload_0
    //   192: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   195: aload_1
    //   196: invokevirtual add : (Ljava/lang/Object;)Z
    //   199: pop
    //   200: aload_0
    //   201: monitorexit
    //   202: iload_2
    //   203: ireturn
    //   204: astore_1
    //   205: aload_0
    //   206: monitorexit
    //   207: aload_1
    //   208: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	204	finally
    //   22	97	204	finally
    //   97	109	204	finally
    //   111	131	204	finally
    //   131	191	204	finally
    //   191	202	204	finally
    //   205	207	204	finally
  }
  
  public void attachController(FragmentHostCallback paramFragmentHostCallback, FragmentContainer paramFragmentContainer, Fragment paramFragment) {
    if (this.mHost == null) {
      this.mHost = paramFragmentHostCallback;
      this.mContainer = paramFragmentContainer;
      this.mParent = paramFragment;
      return;
    } 
    throw new IllegalStateException("Already attached");
  }
  
  public void attachFragment(Fragment paramFragment) {
    if (DEBUG) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("attach: ");
      stringBuilder.append(paramFragment);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
    if (paramFragment.mDetached) {
      paramFragment.mDetached = false;
      if (!paramFragment.mAdded)
        if (!this.mAdded.contains(paramFragment)) {
          if (DEBUG) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("add from attach: ");
            stringBuilder.append(paramFragment);
            Log.v("FragmentManager", stringBuilder.toString());
          } 
          synchronized (this.mAdded) {
            this.mAdded.add(paramFragment);
            paramFragment.mAdded = true;
            if (paramFragment.mHasMenu && paramFragment.mMenuVisible)
              this.mNeedMenuInvalidate = true; 
          } 
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Fragment already added: ");
          stringBuilder.append(paramFragment);
          throw new IllegalStateException(stringBuilder.toString());
        }  
    } 
  }
  
  public FragmentTransaction beginTransaction() {
    return new BackStackRecord(this);
  }
  
  void completeShowHideFragment(final Fragment fragment) {
    if (fragment.mView != null) {
      AnimationOrAnimator animationOrAnimator = loadAnimation(fragment, fragment.getNextTransition(), fragment.mHidden ^ true, fragment.getNextTransitionStyle());
      if (animationOrAnimator != null && animationOrAnimator.animator != null) {
        animationOrAnimator.animator.setTarget(fragment.mView);
        if (fragment.mHidden) {
          if (fragment.isHideReplaced()) {
            fragment.setHideReplaced(false);
          } else {
            final ViewGroup container = fragment.mContainer;
            final View animatingView = fragment.mView;
            viewGroup.startViewTransition(view);
            animationOrAnimator.animator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter() {
                  public void onAnimationEnd(Animator param1Animator) {
                    container.endViewTransition(animatingView);
                    param1Animator.removeListener((Animator.AnimatorListener)this);
                    if (fragment.mView != null)
                      fragment.mView.setVisibility(8); 
                  }
                });
          } 
        } else {
          fragment.mView.setVisibility(0);
        } 
        setHWLayerAnimListenerIfAlpha(fragment.mView, animationOrAnimator);
        animationOrAnimator.animator.start();
      } else {
        boolean bool;
        if (animationOrAnimator != null) {
          setHWLayerAnimListenerIfAlpha(fragment.mView, animationOrAnimator);
          fragment.mView.startAnimation(animationOrAnimator.animation);
          animationOrAnimator.animation.start();
        } 
        if (fragment.mHidden && !fragment.isHideReplaced()) {
          bool = true;
        } else {
          bool = false;
        } 
        fragment.mView.setVisibility(bool);
        if (fragment.isHideReplaced())
          fragment.setHideReplaced(false); 
      } 
    } 
    if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible)
      this.mNeedMenuInvalidate = true; 
    fragment.mHiddenChanged = false;
    fragment.onHiddenChanged(fragment.mHidden);
  }
  
  public void detachFragment(Fragment paramFragment) {
    if (DEBUG) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("detach: ");
      stringBuilder.append(paramFragment);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
    if (!paramFragment.mDetached) {
      paramFragment.mDetached = true;
      if (paramFragment.mAdded) {
        if (DEBUG) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("remove from detach: ");
          stringBuilder.append(paramFragment);
          Log.v("FragmentManager", stringBuilder.toString());
        } 
        synchronized (this.mAdded) {
          this.mAdded.remove(paramFragment);
          if (paramFragment.mHasMenu && paramFragment.mMenuVisible)
            this.mNeedMenuInvalidate = true; 
          paramFragment.mAdded = false;
        } 
      } 
    } 
  }
  
  public void dispatchActivityCreated() {
    this.mStateSaved = false;
    this.mStopped = false;
    dispatchStateChange(2);
  }
  
  public void dispatchConfigurationChanged(Configuration paramConfiguration) {
    for (byte b = 0; b < this.mAdded.size(); b++) {
      Fragment fragment = this.mAdded.get(b);
      if (fragment != null)
        fragment.performConfigurationChanged(paramConfiguration); 
    } 
  }
  
  public boolean dispatchContextItemSelected(MenuItem paramMenuItem) {
    if (this.mCurState < 1)
      return false; 
    for (byte b = 0; b < this.mAdded.size(); b++) {
      Fragment fragment = this.mAdded.get(b);
      if (fragment != null && fragment.performContextItemSelected(paramMenuItem))
        return true; 
    } 
    return false;
  }
  
  public void dispatchCreate() {
    this.mStateSaved = false;
    this.mStopped = false;
    dispatchStateChange(1);
  }
  
  public boolean dispatchCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {
    int i = this.mCurState;
    boolean bool1 = false;
    if (i < 1)
      return false; 
    ArrayList<Fragment> arrayList = null;
    i = 0;
    boolean bool2;
    for (bool2 = false; i < this.mAdded.size(); bool2 = bool) {
      Fragment fragment = this.mAdded.get(i);
      ArrayList<Fragment> arrayList1 = arrayList;
      boolean bool = bool2;
      if (fragment != null) {
        arrayList1 = arrayList;
        bool = bool2;
        if (fragment.performCreateOptionsMenu(paramMenu, paramMenuInflater)) {
          arrayList1 = arrayList;
          if (arrayList == null)
            arrayList1 = new ArrayList(); 
          arrayList1.add(fragment);
          bool = true;
        } 
      } 
      i++;
      arrayList = arrayList1;
    } 
    if (this.mCreatedMenus != null)
      for (i = bool1; i < this.mCreatedMenus.size(); i++) {
        Fragment fragment = this.mCreatedMenus.get(i);
        if (arrayList == null || !arrayList.contains(fragment))
          fragment.onDestroyOptionsMenu(); 
      }  
    this.mCreatedMenus = arrayList;
    return bool2;
  }
  
  public void dispatchDestroy() {
    this.mDestroyed = true;
    execPendingActions();
    dispatchStateChange(0);
    this.mHost = null;
    this.mContainer = null;
    this.mParent = null;
  }
  
  public void dispatchDestroyView() {
    dispatchStateChange(1);
  }
  
  public void dispatchLowMemory() {
    for (byte b = 0; b < this.mAdded.size(); b++) {
      Fragment fragment = this.mAdded.get(b);
      if (fragment != null)
        fragment.performLowMemory(); 
    } 
  }
  
  public void dispatchMultiWindowModeChanged(boolean paramBoolean) {
    for (int i = this.mAdded.size() - 1; i >= 0; i--) {
      Fragment fragment = this.mAdded.get(i);
      if (fragment != null)
        fragment.performMultiWindowModeChanged(paramBoolean); 
    } 
  }
  
  void dispatchOnFragmentActivityCreated(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean) {
    Fragment fragment = this.mParent;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentActivityCreated(paramFragment, paramBundle, true); 
    } 
    for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.mLifecycleCallbacks) {
      if (!paramBoolean || ((Boolean)pair.second).booleanValue())
        ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentActivityCreated(this, paramFragment, paramBundle); 
    } 
  }
  
  void dispatchOnFragmentAttached(Fragment paramFragment, Context paramContext, boolean paramBoolean) {
    Fragment fragment = this.mParent;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentAttached(paramFragment, paramContext, true); 
    } 
    for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.mLifecycleCallbacks) {
      if (!paramBoolean || ((Boolean)pair.second).booleanValue())
        ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentAttached(this, paramFragment, paramContext); 
    } 
  }
  
  void dispatchOnFragmentCreated(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean) {
    Fragment fragment = this.mParent;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentCreated(paramFragment, paramBundle, true); 
    } 
    for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.mLifecycleCallbacks) {
      if (!paramBoolean || ((Boolean)pair.second).booleanValue())
        ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentCreated(this, paramFragment, paramBundle); 
    } 
  }
  
  void dispatchOnFragmentDestroyed(Fragment paramFragment, boolean paramBoolean) {
    Fragment fragment = this.mParent;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentDestroyed(paramFragment, true); 
    } 
    for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.mLifecycleCallbacks) {
      if (!paramBoolean || ((Boolean)pair.second).booleanValue())
        ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentDestroyed(this, paramFragment); 
    } 
  }
  
  void dispatchOnFragmentDetached(Fragment paramFragment, boolean paramBoolean) {
    Fragment fragment = this.mParent;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentDetached(paramFragment, true); 
    } 
    for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.mLifecycleCallbacks) {
      if (!paramBoolean || ((Boolean)pair.second).booleanValue())
        ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentDetached(this, paramFragment); 
    } 
  }
  
  void dispatchOnFragmentPaused(Fragment paramFragment, boolean paramBoolean) {
    Fragment fragment = this.mParent;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentPaused(paramFragment, true); 
    } 
    for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.mLifecycleCallbacks) {
      if (!paramBoolean || ((Boolean)pair.second).booleanValue())
        ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentPaused(this, paramFragment); 
    } 
  }
  
  void dispatchOnFragmentPreAttached(Fragment paramFragment, Context paramContext, boolean paramBoolean) {
    Fragment fragment = this.mParent;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentPreAttached(paramFragment, paramContext, true); 
    } 
    for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.mLifecycleCallbacks) {
      if (!paramBoolean || ((Boolean)pair.second).booleanValue())
        ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentPreAttached(this, paramFragment, paramContext); 
    } 
  }
  
  void dispatchOnFragmentPreCreated(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean) {
    Fragment fragment = this.mParent;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentPreCreated(paramFragment, paramBundle, true); 
    } 
    for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.mLifecycleCallbacks) {
      if (!paramBoolean || ((Boolean)pair.second).booleanValue())
        ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentPreCreated(this, paramFragment, paramBundle); 
    } 
  }
  
  void dispatchOnFragmentResumed(Fragment paramFragment, boolean paramBoolean) {
    Fragment fragment = this.mParent;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentResumed(paramFragment, true); 
    } 
    for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.mLifecycleCallbacks) {
      if (!paramBoolean || ((Boolean)pair.second).booleanValue())
        ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentResumed(this, paramFragment); 
    } 
  }
  
  void dispatchOnFragmentSaveInstanceState(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean) {
    Fragment fragment = this.mParent;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentSaveInstanceState(paramFragment, paramBundle, true); 
    } 
    for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.mLifecycleCallbacks) {
      if (!paramBoolean || ((Boolean)pair.second).booleanValue())
        ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentSaveInstanceState(this, paramFragment, paramBundle); 
    } 
  }
  
  void dispatchOnFragmentStarted(Fragment paramFragment, boolean paramBoolean) {
    Fragment fragment = this.mParent;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentStarted(paramFragment, true); 
    } 
    for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.mLifecycleCallbacks) {
      if (!paramBoolean || ((Boolean)pair.second).booleanValue())
        ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentStarted(this, paramFragment); 
    } 
  }
  
  void dispatchOnFragmentStopped(Fragment paramFragment, boolean paramBoolean) {
    Fragment fragment = this.mParent;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentStopped(paramFragment, true); 
    } 
    for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.mLifecycleCallbacks) {
      if (!paramBoolean || ((Boolean)pair.second).booleanValue())
        ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentStopped(this, paramFragment); 
    } 
  }
  
  void dispatchOnFragmentViewCreated(Fragment paramFragment, View paramView, Bundle paramBundle, boolean paramBoolean) {
    Fragment fragment = this.mParent;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentViewCreated(paramFragment, paramView, paramBundle, true); 
    } 
    for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.mLifecycleCallbacks) {
      if (!paramBoolean || ((Boolean)pair.second).booleanValue())
        ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentViewCreated(this, paramFragment, paramView, paramBundle); 
    } 
  }
  
  void dispatchOnFragmentViewDestroyed(Fragment paramFragment, boolean paramBoolean) {
    Fragment fragment = this.mParent;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentViewDestroyed(paramFragment, true); 
    } 
    for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.mLifecycleCallbacks) {
      if (!paramBoolean || ((Boolean)pair.second).booleanValue())
        ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentViewDestroyed(this, paramFragment); 
    } 
  }
  
  public boolean dispatchOptionsItemSelected(MenuItem paramMenuItem) {
    if (this.mCurState < 1)
      return false; 
    for (byte b = 0; b < this.mAdded.size(); b++) {
      Fragment fragment = this.mAdded.get(b);
      if (fragment != null && fragment.performOptionsItemSelected(paramMenuItem))
        return true; 
    } 
    return false;
  }
  
  public void dispatchOptionsMenuClosed(Menu paramMenu) {
    if (this.mCurState < 1)
      return; 
    for (byte b = 0; b < this.mAdded.size(); b++) {
      Fragment fragment = this.mAdded.get(b);
      if (fragment != null)
        fragment.performOptionsMenuClosed(paramMenu); 
    } 
  }
  
  public void dispatchPause() {
    dispatchStateChange(4);
  }
  
  public void dispatchPictureInPictureModeChanged(boolean paramBoolean) {
    for (int i = this.mAdded.size() - 1; i >= 0; i--) {
      Fragment fragment = this.mAdded.get(i);
      if (fragment != null)
        fragment.performPictureInPictureModeChanged(paramBoolean); 
    } 
  }
  
  public boolean dispatchPrepareOptionsMenu(Menu paramMenu) {
    int i = this.mCurState;
    byte b = 0;
    if (i < 1)
      return false; 
    boolean bool;
    for (bool = false; b < this.mAdded.size(); bool = bool1) {
      Fragment fragment = this.mAdded.get(b);
      boolean bool1 = bool;
      if (fragment != null) {
        bool1 = bool;
        if (fragment.performPrepareOptionsMenu(paramMenu))
          bool1 = true; 
      } 
      b++;
    } 
    return bool;
  }
  
  public void dispatchReallyStop() {
    dispatchStateChange(2);
  }
  
  public void dispatchResume() {
    this.mStateSaved = false;
    this.mStopped = false;
    dispatchStateChange(5);
  }
  
  public void dispatchStart() {
    this.mStateSaved = false;
    this.mStopped = false;
    dispatchStateChange(4);
  }
  
  public void dispatchStop() {
    this.mStopped = true;
    dispatchStateChange(3);
  }
  
  void doPendingDeferredStart() {
    if (this.mHavePendingDeferredStart) {
      this.mHavePendingDeferredStart = false;
      startPendingDeferredFragments();
    } 
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #5
    //   9: aload #5
    //   11: aload_1
    //   12: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload #5
    //   18: ldc_w '    '
    //   21: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload #5
    //   27: invokevirtual toString : ()Ljava/lang/String;
    //   30: astore #5
    //   32: aload_0
    //   33: getfield mActive : Landroid/util/SparseArray;
    //   36: astore #6
    //   38: iconst_0
    //   39: istore #7
    //   41: aload #6
    //   43: ifnull -> 165
    //   46: aload #6
    //   48: invokevirtual size : ()I
    //   51: istore #8
    //   53: iload #8
    //   55: ifle -> 165
    //   58: aload_3
    //   59: aload_1
    //   60: invokevirtual print : (Ljava/lang/String;)V
    //   63: aload_3
    //   64: ldc_w 'Active Fragments in '
    //   67: invokevirtual print : (Ljava/lang/String;)V
    //   70: aload_3
    //   71: aload_0
    //   72: invokestatic identityHashCode : (Ljava/lang/Object;)I
    //   75: invokestatic toHexString : (I)Ljava/lang/String;
    //   78: invokevirtual print : (Ljava/lang/String;)V
    //   81: aload_3
    //   82: ldc_w ':'
    //   85: invokevirtual println : (Ljava/lang/String;)V
    //   88: iconst_0
    //   89: istore #9
    //   91: iload #9
    //   93: iload #8
    //   95: if_icmpge -> 165
    //   98: aload_0
    //   99: getfield mActive : Landroid/util/SparseArray;
    //   102: iload #9
    //   104: invokevirtual valueAt : (I)Ljava/lang/Object;
    //   107: checkcast android/support/v4/app/Fragment
    //   110: astore #6
    //   112: aload_3
    //   113: aload_1
    //   114: invokevirtual print : (Ljava/lang/String;)V
    //   117: aload_3
    //   118: ldc_w '  #'
    //   121: invokevirtual print : (Ljava/lang/String;)V
    //   124: aload_3
    //   125: iload #9
    //   127: invokevirtual print : (I)V
    //   130: aload_3
    //   131: ldc_w ': '
    //   134: invokevirtual print : (Ljava/lang/String;)V
    //   137: aload_3
    //   138: aload #6
    //   140: invokevirtual println : (Ljava/lang/Object;)V
    //   143: aload #6
    //   145: ifnull -> 159
    //   148: aload #6
    //   150: aload #5
    //   152: aload_2
    //   153: aload_3
    //   154: aload #4
    //   156: invokevirtual dump : (Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    //   159: iinc #9, 1
    //   162: goto -> 91
    //   165: aload_0
    //   166: getfield mAdded : Ljava/util/ArrayList;
    //   169: invokevirtual size : ()I
    //   172: istore #8
    //   174: iload #8
    //   176: ifle -> 255
    //   179: aload_3
    //   180: aload_1
    //   181: invokevirtual print : (Ljava/lang/String;)V
    //   184: aload_3
    //   185: ldc_w 'Added Fragments:'
    //   188: invokevirtual println : (Ljava/lang/String;)V
    //   191: iconst_0
    //   192: istore #9
    //   194: iload #9
    //   196: iload #8
    //   198: if_icmpge -> 255
    //   201: aload_0
    //   202: getfield mAdded : Ljava/util/ArrayList;
    //   205: iload #9
    //   207: invokevirtual get : (I)Ljava/lang/Object;
    //   210: checkcast android/support/v4/app/Fragment
    //   213: astore #6
    //   215: aload_3
    //   216: aload_1
    //   217: invokevirtual print : (Ljava/lang/String;)V
    //   220: aload_3
    //   221: ldc_w '  #'
    //   224: invokevirtual print : (Ljava/lang/String;)V
    //   227: aload_3
    //   228: iload #9
    //   230: invokevirtual print : (I)V
    //   233: aload_3
    //   234: ldc_w ': '
    //   237: invokevirtual print : (Ljava/lang/String;)V
    //   240: aload_3
    //   241: aload #6
    //   243: invokevirtual toString : ()Ljava/lang/String;
    //   246: invokevirtual println : (Ljava/lang/String;)V
    //   249: iinc #9, 1
    //   252: goto -> 194
    //   255: aload_0
    //   256: getfield mCreatedMenus : Ljava/util/ArrayList;
    //   259: astore #6
    //   261: aload #6
    //   263: ifnull -> 354
    //   266: aload #6
    //   268: invokevirtual size : ()I
    //   271: istore #8
    //   273: iload #8
    //   275: ifle -> 354
    //   278: aload_3
    //   279: aload_1
    //   280: invokevirtual print : (Ljava/lang/String;)V
    //   283: aload_3
    //   284: ldc_w 'Fragments Created Menus:'
    //   287: invokevirtual println : (Ljava/lang/String;)V
    //   290: iconst_0
    //   291: istore #9
    //   293: iload #9
    //   295: iload #8
    //   297: if_icmpge -> 354
    //   300: aload_0
    //   301: getfield mCreatedMenus : Ljava/util/ArrayList;
    //   304: iload #9
    //   306: invokevirtual get : (I)Ljava/lang/Object;
    //   309: checkcast android/support/v4/app/Fragment
    //   312: astore #6
    //   314: aload_3
    //   315: aload_1
    //   316: invokevirtual print : (Ljava/lang/String;)V
    //   319: aload_3
    //   320: ldc_w '  #'
    //   323: invokevirtual print : (Ljava/lang/String;)V
    //   326: aload_3
    //   327: iload #9
    //   329: invokevirtual print : (I)V
    //   332: aload_3
    //   333: ldc_w ': '
    //   336: invokevirtual print : (Ljava/lang/String;)V
    //   339: aload_3
    //   340: aload #6
    //   342: invokevirtual toString : ()Ljava/lang/String;
    //   345: invokevirtual println : (Ljava/lang/String;)V
    //   348: iinc #9, 1
    //   351: goto -> 293
    //   354: aload_0
    //   355: getfield mBackStack : Ljava/util/ArrayList;
    //   358: astore #6
    //   360: aload #6
    //   362: ifnull -> 464
    //   365: aload #6
    //   367: invokevirtual size : ()I
    //   370: istore #8
    //   372: iload #8
    //   374: ifle -> 464
    //   377: aload_3
    //   378: aload_1
    //   379: invokevirtual print : (Ljava/lang/String;)V
    //   382: aload_3
    //   383: ldc_w 'Back Stack:'
    //   386: invokevirtual println : (Ljava/lang/String;)V
    //   389: iconst_0
    //   390: istore #9
    //   392: iload #9
    //   394: iload #8
    //   396: if_icmpge -> 464
    //   399: aload_0
    //   400: getfield mBackStack : Ljava/util/ArrayList;
    //   403: iload #9
    //   405: invokevirtual get : (I)Ljava/lang/Object;
    //   408: checkcast android/support/v4/app/BackStackRecord
    //   411: astore #6
    //   413: aload_3
    //   414: aload_1
    //   415: invokevirtual print : (Ljava/lang/String;)V
    //   418: aload_3
    //   419: ldc_w '  #'
    //   422: invokevirtual print : (Ljava/lang/String;)V
    //   425: aload_3
    //   426: iload #9
    //   428: invokevirtual print : (I)V
    //   431: aload_3
    //   432: ldc_w ': '
    //   435: invokevirtual print : (Ljava/lang/String;)V
    //   438: aload_3
    //   439: aload #6
    //   441: invokevirtual toString : ()Ljava/lang/String;
    //   444: invokevirtual println : (Ljava/lang/String;)V
    //   447: aload #6
    //   449: aload #5
    //   451: aload_2
    //   452: aload_3
    //   453: aload #4
    //   455: invokevirtual dump : (Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    //   458: iinc #9, 1
    //   461: goto -> 392
    //   464: aload_0
    //   465: monitorenter
    //   466: aload_0
    //   467: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   470: ifnull -> 558
    //   473: aload_0
    //   474: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   477: invokevirtual size : ()I
    //   480: istore #8
    //   482: iload #8
    //   484: ifle -> 558
    //   487: aload_3
    //   488: aload_1
    //   489: invokevirtual print : (Ljava/lang/String;)V
    //   492: aload_3
    //   493: ldc_w 'Back Stack Indices:'
    //   496: invokevirtual println : (Ljava/lang/String;)V
    //   499: iconst_0
    //   500: istore #9
    //   502: iload #9
    //   504: iload #8
    //   506: if_icmpge -> 558
    //   509: aload_0
    //   510: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   513: iload #9
    //   515: invokevirtual get : (I)Ljava/lang/Object;
    //   518: checkcast android/support/v4/app/BackStackRecord
    //   521: astore_2
    //   522: aload_3
    //   523: aload_1
    //   524: invokevirtual print : (Ljava/lang/String;)V
    //   527: aload_3
    //   528: ldc_w '  #'
    //   531: invokevirtual print : (Ljava/lang/String;)V
    //   534: aload_3
    //   535: iload #9
    //   537: invokevirtual print : (I)V
    //   540: aload_3
    //   541: ldc_w ': '
    //   544: invokevirtual print : (Ljava/lang/String;)V
    //   547: aload_3
    //   548: aload_2
    //   549: invokevirtual println : (Ljava/lang/Object;)V
    //   552: iinc #9, 1
    //   555: goto -> 502
    //   558: aload_0
    //   559: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   562: ifnull -> 601
    //   565: aload_0
    //   566: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   569: invokevirtual size : ()I
    //   572: ifle -> 601
    //   575: aload_3
    //   576: aload_1
    //   577: invokevirtual print : (Ljava/lang/String;)V
    //   580: aload_3
    //   581: ldc_w 'mAvailBackStackIndices: '
    //   584: invokevirtual print : (Ljava/lang/String;)V
    //   587: aload_3
    //   588: aload_0
    //   589: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   592: invokevirtual toArray : ()[Ljava/lang/Object;
    //   595: invokestatic toString : ([Ljava/lang/Object;)Ljava/lang/String;
    //   598: invokevirtual println : (Ljava/lang/String;)V
    //   601: aload_0
    //   602: monitorexit
    //   603: aload_0
    //   604: getfield mPendingActions : Ljava/util/ArrayList;
    //   607: astore_2
    //   608: aload_2
    //   609: ifnull -> 695
    //   612: aload_2
    //   613: invokevirtual size : ()I
    //   616: istore #8
    //   618: iload #8
    //   620: ifle -> 695
    //   623: aload_3
    //   624: aload_1
    //   625: invokevirtual print : (Ljava/lang/String;)V
    //   628: aload_3
    //   629: ldc_w 'Pending Actions:'
    //   632: invokevirtual println : (Ljava/lang/String;)V
    //   635: iload #7
    //   637: istore #9
    //   639: iload #9
    //   641: iload #8
    //   643: if_icmpge -> 695
    //   646: aload_0
    //   647: getfield mPendingActions : Ljava/util/ArrayList;
    //   650: iload #9
    //   652: invokevirtual get : (I)Ljava/lang/Object;
    //   655: checkcast android/support/v4/app/FragmentManagerImpl$OpGenerator
    //   658: astore_2
    //   659: aload_3
    //   660: aload_1
    //   661: invokevirtual print : (Ljava/lang/String;)V
    //   664: aload_3
    //   665: ldc_w '  #'
    //   668: invokevirtual print : (Ljava/lang/String;)V
    //   671: aload_3
    //   672: iload #9
    //   674: invokevirtual print : (I)V
    //   677: aload_3
    //   678: ldc_w ': '
    //   681: invokevirtual print : (Ljava/lang/String;)V
    //   684: aload_3
    //   685: aload_2
    //   686: invokevirtual println : (Ljava/lang/Object;)V
    //   689: iinc #9, 1
    //   692: goto -> 639
    //   695: aload_3
    //   696: aload_1
    //   697: invokevirtual print : (Ljava/lang/String;)V
    //   700: aload_3
    //   701: ldc_w 'FragmentManager misc state:'
    //   704: invokevirtual println : (Ljava/lang/String;)V
    //   707: aload_3
    //   708: aload_1
    //   709: invokevirtual print : (Ljava/lang/String;)V
    //   712: aload_3
    //   713: ldc_w '  mHost='
    //   716: invokevirtual print : (Ljava/lang/String;)V
    //   719: aload_3
    //   720: aload_0
    //   721: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   724: invokevirtual println : (Ljava/lang/Object;)V
    //   727: aload_3
    //   728: aload_1
    //   729: invokevirtual print : (Ljava/lang/String;)V
    //   732: aload_3
    //   733: ldc_w '  mContainer='
    //   736: invokevirtual print : (Ljava/lang/String;)V
    //   739: aload_3
    //   740: aload_0
    //   741: getfield mContainer : Landroid/support/v4/app/FragmentContainer;
    //   744: invokevirtual println : (Ljava/lang/Object;)V
    //   747: aload_0
    //   748: getfield mParent : Landroid/support/v4/app/Fragment;
    //   751: ifnull -> 774
    //   754: aload_3
    //   755: aload_1
    //   756: invokevirtual print : (Ljava/lang/String;)V
    //   759: aload_3
    //   760: ldc_w '  mParent='
    //   763: invokevirtual print : (Ljava/lang/String;)V
    //   766: aload_3
    //   767: aload_0
    //   768: getfield mParent : Landroid/support/v4/app/Fragment;
    //   771: invokevirtual println : (Ljava/lang/Object;)V
    //   774: aload_3
    //   775: aload_1
    //   776: invokevirtual print : (Ljava/lang/String;)V
    //   779: aload_3
    //   780: ldc_w '  mCurState='
    //   783: invokevirtual print : (Ljava/lang/String;)V
    //   786: aload_3
    //   787: aload_0
    //   788: getfield mCurState : I
    //   791: invokevirtual print : (I)V
    //   794: aload_3
    //   795: ldc_w ' mStateSaved='
    //   798: invokevirtual print : (Ljava/lang/String;)V
    //   801: aload_3
    //   802: aload_0
    //   803: getfield mStateSaved : Z
    //   806: invokevirtual print : (Z)V
    //   809: aload_3
    //   810: ldc_w ' mStopped='
    //   813: invokevirtual print : (Ljava/lang/String;)V
    //   816: aload_3
    //   817: aload_0
    //   818: getfield mStopped : Z
    //   821: invokevirtual print : (Z)V
    //   824: aload_3
    //   825: ldc_w ' mDestroyed='
    //   828: invokevirtual print : (Ljava/lang/String;)V
    //   831: aload_3
    //   832: aload_0
    //   833: getfield mDestroyed : Z
    //   836: invokevirtual println : (Z)V
    //   839: aload_0
    //   840: getfield mNeedMenuInvalidate : Z
    //   843: ifeq -> 866
    //   846: aload_3
    //   847: aload_1
    //   848: invokevirtual print : (Ljava/lang/String;)V
    //   851: aload_3
    //   852: ldc_w '  mNeedMenuInvalidate='
    //   855: invokevirtual print : (Ljava/lang/String;)V
    //   858: aload_3
    //   859: aload_0
    //   860: getfield mNeedMenuInvalidate : Z
    //   863: invokevirtual println : (Z)V
    //   866: aload_0
    //   867: getfield mNoTransactionsBecause : Ljava/lang/String;
    //   870: ifnull -> 893
    //   873: aload_3
    //   874: aload_1
    //   875: invokevirtual print : (Ljava/lang/String;)V
    //   878: aload_3
    //   879: ldc_w '  mNoTransactionsBecause='
    //   882: invokevirtual print : (Ljava/lang/String;)V
    //   885: aload_3
    //   886: aload_0
    //   887: getfield mNoTransactionsBecause : Ljava/lang/String;
    //   890: invokevirtual println : (Ljava/lang/String;)V
    //   893: return
    //   894: astore_1
    //   895: aload_0
    //   896: monitorexit
    //   897: aload_1
    //   898: athrow
    // Exception table:
    //   from	to	target	type
    //   466	482	894	finally
    //   487	499	894	finally
    //   509	552	894	finally
    //   558	601	894	finally
    //   601	603	894	finally
    //   895	897	894	finally
  }
  
  public void enqueueAction(OpGenerator paramOpGenerator, boolean paramBoolean) {
    // Byte code:
    //   0: iload_2
    //   1: ifne -> 8
    //   4: aload_0
    //   5: invokespecial checkStateLoss : ()V
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield mDestroyed : Z
    //   14: ifne -> 63
    //   17: aload_0
    //   18: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   21: ifnonnull -> 27
    //   24: goto -> 63
    //   27: aload_0
    //   28: getfield mPendingActions : Ljava/util/ArrayList;
    //   31: ifnonnull -> 47
    //   34: new java/util/ArrayList
    //   37: astore_3
    //   38: aload_3
    //   39: invokespecial <init> : ()V
    //   42: aload_0
    //   43: aload_3
    //   44: putfield mPendingActions : Ljava/util/ArrayList;
    //   47: aload_0
    //   48: getfield mPendingActions : Ljava/util/ArrayList;
    //   51: aload_1
    //   52: invokevirtual add : (Ljava/lang/Object;)Z
    //   55: pop
    //   56: aload_0
    //   57: invokespecial scheduleCommit : ()V
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: iload_2
    //   64: ifeq -> 70
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: new java/lang/IllegalStateException
    //   73: astore_1
    //   74: aload_1
    //   75: ldc_w 'Activity has been destroyed'
    //   78: invokespecial <init> : (Ljava/lang/String;)V
    //   81: aload_1
    //   82: athrow
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Exception table:
    //   from	to	target	type
    //   10	24	83	finally
    //   27	47	83	finally
    //   47	62	83	finally
    //   67	69	83	finally
    //   70	83	83	finally
    //   84	86	83	finally
  }
  
  void ensureInflatedFragmentView(Fragment paramFragment) {
    if (paramFragment.mFromLayout && !paramFragment.mPerformedCreateView) {
      paramFragment.mView = paramFragment.performCreateView(paramFragment.performGetLayoutInflater(paramFragment.mSavedFragmentState), null, paramFragment.mSavedFragmentState);
      if (paramFragment.mView != null) {
        paramFragment.mInnerView = paramFragment.mView;
        paramFragment.mView.setSaveFromParentEnabled(false);
        if (paramFragment.mHidden)
          paramFragment.mView.setVisibility(8); 
        paramFragment.onViewCreated(paramFragment.mView, paramFragment.mSavedFragmentState);
        dispatchOnFragmentViewCreated(paramFragment, paramFragment.mView, paramFragment.mSavedFragmentState, false);
      } else {
        paramFragment.mInnerView = null;
      } 
    } 
  }
  
  public boolean execPendingActions() {
    ensureExecReady(true);
    boolean bool = false;
    while (generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop)) {
      this.mExecutingActions = true;
      try {
        removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
        cleanupExec();
      } finally {
        cleanupExec();
      } 
    } 
    doPendingDeferredStart();
    burpActive();
    return bool;
  }
  
  public void execSingleAction(OpGenerator paramOpGenerator, boolean paramBoolean) {
    if (paramBoolean && (this.mHost == null || this.mDestroyed))
      return; 
    ensureExecReady(paramBoolean);
    if (paramOpGenerator.generateOps(this.mTmpRecords, this.mTmpIsPop)) {
      this.mExecutingActions = true;
      try {
        removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
      } finally {
        cleanupExec();
      } 
    } 
    doPendingDeferredStart();
    burpActive();
  }
  
  public boolean executePendingTransactions() {
    boolean bool = execPendingActions();
    forcePostponedTransactions();
    return bool;
  }
  
  public Fragment findFragmentById(int paramInt) {
    int i;
    for (i = this.mAdded.size() - 1; i >= 0; i--) {
      Fragment fragment = this.mAdded.get(i);
      if (fragment != null && fragment.mFragmentId == paramInt)
        return fragment; 
    } 
    SparseArray<Fragment> sparseArray = this.mActive;
    if (sparseArray != null)
      for (i = sparseArray.size() - 1; i >= 0; i--) {
        Fragment fragment = (Fragment)this.mActive.valueAt(i);
        if (fragment != null && fragment.mFragmentId == paramInt)
          return fragment; 
      }  
    return null;
  }
  
  public Fragment findFragmentByTag(String paramString) {
    if (paramString != null)
      for (int i = this.mAdded.size() - 1; i >= 0; i--) {
        Fragment fragment = this.mAdded.get(i);
        if (fragment != null && paramString.equals(fragment.mTag))
          return fragment; 
      }  
    SparseArray<Fragment> sparseArray = this.mActive;
    if (sparseArray != null && paramString != null)
      for (int i = sparseArray.size() - 1; i >= 0; i--) {
        Fragment fragment = (Fragment)this.mActive.valueAt(i);
        if (fragment != null && paramString.equals(fragment.mTag))
          return fragment; 
      }  
    return null;
  }
  
  public Fragment findFragmentByWho(String paramString) {
    SparseArray<Fragment> sparseArray = this.mActive;
    if (sparseArray != null && paramString != null)
      for (int i = sparseArray.size() - 1; i >= 0; i--) {
        Fragment fragment = (Fragment)this.mActive.valueAt(i);
        if (fragment != null) {
          fragment = fragment.findFragmentByWho(paramString);
          if (fragment != null)
            return fragment; 
        } 
      }  
    return null;
  }
  
  public void freeBackStackIndex(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   6: iload_1
    //   7: aconst_null
    //   8: invokevirtual set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   11: pop
    //   12: aload_0
    //   13: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   16: ifnonnull -> 32
    //   19: new java/util/ArrayList
    //   22: astore_2
    //   23: aload_2
    //   24: invokespecial <init> : ()V
    //   27: aload_0
    //   28: aload_2
    //   29: putfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   32: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   35: ifeq -> 70
    //   38: new java/lang/StringBuilder
    //   41: astore_2
    //   42: aload_2
    //   43: invokespecial <init> : ()V
    //   46: aload_2
    //   47: ldc_w 'Freeing back stack index '
    //   50: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_2
    //   55: iload_1
    //   56: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: ldc 'FragmentManager'
    //   62: aload_2
    //   63: invokevirtual toString : ()Ljava/lang/String;
    //   66: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   69: pop
    //   70: aload_0
    //   71: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   74: iload_1
    //   75: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   78: invokevirtual add : (Ljava/lang/Object;)Z
    //   81: pop
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: astore_2
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_2
    //   89: athrow
    // Exception table:
    //   from	to	target	type
    //   2	32	85	finally
    //   32	70	85	finally
    //   70	84	85	finally
    //   86	88	85	finally
  }
  
  int getActiveFragmentCount() {
    SparseArray<Fragment> sparseArray = this.mActive;
    return (sparseArray == null) ? 0 : sparseArray.size();
  }
  
  List<Fragment> getActiveFragments() {
    SparseArray<Fragment> sparseArray = this.mActive;
    if (sparseArray == null)
      return null; 
    int i = sparseArray.size();
    ArrayList<Object> arrayList = new ArrayList(i);
    for (byte b = 0; b < i; b++)
      arrayList.add(this.mActive.valueAt(b)); 
    return arrayList;
  }
  
  public FragmentManager.BackStackEntry getBackStackEntryAt(int paramInt) {
    return this.mBackStack.get(paramInt);
  }
  
  public int getBackStackEntryCount() {
    boolean bool;
    ArrayList<BackStackRecord> arrayList = this.mBackStack;
    if (arrayList != null) {
      bool = arrayList.size();
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public Fragment getFragment(Bundle paramBundle, String paramString) {
    int i = paramBundle.getInt(paramString, -1);
    if (i == -1)
      return null; 
    Fragment fragment = (Fragment)this.mActive.get(i);
    if (fragment == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Fragment no longer exists for key ");
      stringBuilder.append(paramString);
      stringBuilder.append(": index ");
      stringBuilder.append(i);
      throwException(new IllegalStateException(stringBuilder.toString()));
    } 
    return fragment;
  }
  
  public List<Fragment> getFragments() {
    if (this.mAdded.isEmpty())
      return Collections.EMPTY_LIST; 
    synchronized (this.mAdded) {
      return (List)this.mAdded.clone();
    } 
  }
  
  LayoutInflater.Factory2 getLayoutInflaterFactory() {
    return this;
  }
  
  public Fragment getPrimaryNavigationFragment() {
    return this.mPrimaryNav;
  }
  
  public void hideFragment(Fragment paramFragment) {
    if (DEBUG) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("hide: ");
      stringBuilder.append(paramFragment);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
    if (!paramFragment.mHidden) {
      paramFragment.mHidden = true;
      paramFragment.mHiddenChanged = true ^ paramFragment.mHiddenChanged;
    } 
  }
  
  public boolean isDestroyed() {
    return this.mDestroyed;
  }
  
  boolean isStateAtLeast(int paramInt) {
    boolean bool;
    if (this.mCurState >= paramInt) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isStateSaved() {
    return (this.mStateSaved || this.mStopped);
  }
  
  AnimationOrAnimator loadAnimation(Fragment paramFragment, int paramInt1, boolean paramBoolean, int paramInt2) {
    int i = paramFragment.getNextAnim();
    Animation animation = paramFragment.onCreateAnimation(paramInt1, paramBoolean, i);
    if (animation != null)
      return new AnimationOrAnimator(animation); 
    Animator animator = paramFragment.onCreateAnimator(paramInt1, paramBoolean, i);
    if (animator != null)
      return new AnimationOrAnimator(animator); 
    if (i != 0) {
      boolean bool = "anim".equals(this.mHost.getContext().getResources().getResourceTypeName(i));
      boolean bool1 = false;
      boolean bool2 = bool1;
      if (bool)
        try {
          Animation animation1 = AnimationUtils.loadAnimation(this.mHost.getContext(), i);
          if (animation1 != null)
            return new AnimationOrAnimator(animation1); 
          bool2 = true;
        } catch (android.content.res.Resources.NotFoundException notFoundException) {
          throw notFoundException;
        } catch (RuntimeException runtimeException) {
          bool2 = bool1;
        }  
      if (!bool2)
        try {
          animator = AnimatorInflater.loadAnimator(this.mHost.getContext(), i);
          if (animator != null)
            return new AnimationOrAnimator(animator); 
        } catch (RuntimeException runtimeException) {
          Animation animation1;
          if (!bool) {
            animation1 = AnimationUtils.loadAnimation(this.mHost.getContext(), i);
            if (animation1 != null)
              return new AnimationOrAnimator(animation1); 
          } else {
            throw animation1;
          } 
        }  
    } 
    if (paramInt1 == 0)
      return null; 
    paramInt1 = transitToStyleIndex(paramInt1, paramBoolean);
    if (paramInt1 < 0)
      return null; 
    switch (paramInt1) {
      default:
        paramInt1 = paramInt2;
        if (paramInt2 == 0) {
          paramInt1 = paramInt2;
          if (this.mHost.onHasWindowAnimations())
            paramInt1 = this.mHost.onGetWindowAnimations(); 
        } 
        break;
      case 6:
        return makeFadeAnimation(this.mHost.getContext(), 1.0F, 0.0F);
      case 5:
        return makeFadeAnimation(this.mHost.getContext(), 0.0F, 1.0F);
      case 4:
        return makeOpenCloseAnimation(this.mHost.getContext(), 1.0F, 1.075F, 1.0F, 0.0F);
      case 3:
        return makeOpenCloseAnimation(this.mHost.getContext(), 0.975F, 1.0F, 0.0F, 1.0F);
      case 2:
        return makeOpenCloseAnimation(this.mHost.getContext(), 1.0F, 0.975F, 1.0F, 0.0F);
      case 1:
        return makeOpenCloseAnimation(this.mHost.getContext(), 1.125F, 1.0F, 0.0F, 1.0F);
    } 
    return (AnimationOrAnimator)((paramInt1 == 0) ? null : null);
  }
  
  void makeActive(Fragment paramFragment) {
    if (paramFragment.mIndex >= 0)
      return; 
    int i = this.mNextFragmentIndex;
    this.mNextFragmentIndex = i + 1;
    paramFragment.setIndex(i, this.mParent);
    if (this.mActive == null)
      this.mActive = new SparseArray(); 
    this.mActive.put(paramFragment.mIndex, paramFragment);
    if (DEBUG) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Allocated fragment index ");
      stringBuilder.append(paramFragment);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
  }
  
  void makeInactive(Fragment paramFragment) {
    if (paramFragment.mIndex < 0)
      return; 
    if (DEBUG) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Freeing fragment index ");
      stringBuilder.append(paramFragment);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
    this.mActive.put(paramFragment.mIndex, null);
    paramFragment.initState();
  }
  
  void moveFragmentToExpectedState(Fragment paramFragment) {
    if (paramFragment == null)
      return; 
    int i = this.mCurState;
    if (paramFragment.mRemoving)
      if (paramFragment.isInBackStack()) {
        i = Math.min(i, 1);
      } else {
        i = Math.min(i, 0);
      }  
    moveToState(paramFragment, i, paramFragment.getNextTransition(), paramFragment.getNextTransitionStyle(), false);
    if (paramFragment.mView != null) {
      Fragment fragment = findFragmentUnder(paramFragment);
      if (fragment != null) {
        View view = fragment.mView;
        ViewGroup viewGroup = paramFragment.mContainer;
        int j = viewGroup.indexOfChild(view);
        i = viewGroup.indexOfChild(paramFragment.mView);
        if (i < j) {
          viewGroup.removeViewAt(i);
          viewGroup.addView(paramFragment.mView, j);
        } 
      } 
      if (paramFragment.mIsNewlyAdded && paramFragment.mContainer != null) {
        if (paramFragment.mPostponedAlpha > 0.0F)
          paramFragment.mView.setAlpha(paramFragment.mPostponedAlpha); 
        paramFragment.mPostponedAlpha = 0.0F;
        paramFragment.mIsNewlyAdded = false;
        AnimationOrAnimator animationOrAnimator = loadAnimation(paramFragment, paramFragment.getNextTransition(), true, paramFragment.getNextTransitionStyle());
        if (animationOrAnimator != null) {
          setHWLayerAnimListenerIfAlpha(paramFragment.mView, animationOrAnimator);
          if (animationOrAnimator.animation != null) {
            paramFragment.mView.startAnimation(animationOrAnimator.animation);
          } else {
            animationOrAnimator.animator.setTarget(paramFragment.mView);
            animationOrAnimator.animator.start();
          } 
        } 
      } 
    } 
    if (paramFragment.mHiddenChanged)
      completeShowHideFragment(paramFragment); 
  }
  
  void moveToState(int paramInt, boolean paramBoolean) {
    if (this.mHost != null || paramInt == 0) {
      if (!paramBoolean && paramInt == this.mCurState)
        return; 
      this.mCurState = paramInt;
      if (this.mActive != null) {
        int i = this.mAdded.size();
        for (paramInt = 0; paramInt < i; paramInt++)
          moveFragmentToExpectedState(this.mAdded.get(paramInt)); 
        i = this.mActive.size();
        for (paramInt = 0; paramInt < i; paramInt++) {
          Fragment fragment = (Fragment)this.mActive.valueAt(paramInt);
          if (fragment != null && (fragment.mRemoving || fragment.mDetached) && !fragment.mIsNewlyAdded)
            moveFragmentToExpectedState(fragment); 
        } 
        startPendingDeferredFragments();
        if (this.mNeedMenuInvalidate) {
          FragmentHostCallback fragmentHostCallback = this.mHost;
          if (fragmentHostCallback != null && this.mCurState == 5) {
            fragmentHostCallback.onSupportInvalidateOptionsMenu();
            this.mNeedMenuInvalidate = false;
          } 
        } 
      } 
      return;
    } 
    throw new IllegalStateException("No activity");
  }
  
  void moveToState(Fragment paramFragment) {
    moveToState(paramFragment, this.mCurState, 0, 0, false);
  }
  
  void moveToState(Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
    boolean bool = paramFragment.mAdded;
    int i = 1;
    boolean bool1 = true;
    if (!bool || paramFragment.mDetached) {
      int k = paramInt1;
      paramInt1 = k;
      if (k > 1)
        paramInt1 = 1; 
    } 
    int j = paramInt1;
    if (paramFragment.mRemoving) {
      j = paramInt1;
      if (paramInt1 > paramFragment.mState)
        if (paramFragment.mState == 0 && paramFragment.isInBackStack()) {
          j = 1;
        } else {
          j = paramFragment.mState;
        }  
    } 
    if (paramFragment.mDeferStart && paramFragment.mState < 4 && j > 3) {
      paramInt1 = 3;
    } else {
      paramInt1 = j;
    } 
    if (paramFragment.mState <= paramInt1) {
      if (paramFragment.mFromLayout && !paramFragment.mInLayout)
        return; 
      if (paramFragment.getAnimatingAway() != null || paramFragment.getAnimator() != null) {
        paramFragment.setAnimatingAway(null);
        paramFragment.setAnimator(null);
        moveToState(paramFragment, paramFragment.getStateAfterAnimating(), 0, 0, true);
      } 
      j = paramInt1;
      i = paramInt1;
      paramInt3 = paramInt1;
      paramInt2 = paramInt1;
      switch (paramFragment.mState) {
        case 0:
          j = paramInt1;
          if (paramInt1 > 0) {
            FragmentManagerImpl fragmentManagerImpl;
            if (DEBUG) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("moveto CREATED: ");
              stringBuilder.append(paramFragment);
              Log.v("FragmentManager", stringBuilder.toString());
            } 
            j = paramInt1;
            if (paramFragment.mSavedFragmentState != null) {
              paramFragment.mSavedFragmentState.setClassLoader(this.mHost.getContext().getClassLoader());
              paramFragment.mSavedViewState = paramFragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
              paramFragment.mTarget = getFragment(paramFragment.mSavedFragmentState, "android:target_state");
              if (paramFragment.mTarget != null)
                paramFragment.mTargetRequestCode = paramFragment.mSavedFragmentState.getInt("android:target_req_state", 0); 
              if (paramFragment.mSavedUserVisibleHint != null) {
                paramFragment.mUserVisibleHint = paramFragment.mSavedUserVisibleHint.booleanValue();
                paramFragment.mSavedUserVisibleHint = null;
              } else {
                paramFragment.mUserVisibleHint = paramFragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
              } 
              j = paramInt1;
              if (!paramFragment.mUserVisibleHint) {
                paramFragment.mDeferStart = true;
                j = paramInt1;
                if (paramInt1 > 3)
                  j = 3; 
              } 
            } 
            FragmentHostCallback fragmentHostCallback = this.mHost;
            paramFragment.mHost = fragmentHostCallback;
            Fragment fragment = this.mParent;
            paramFragment.mParentFragment = fragment;
            if (fragment != null) {
              fragmentManagerImpl = fragment.mChildFragmentManager;
            } else {
              fragmentManagerImpl = fragmentManagerImpl.getFragmentManagerImpl();
            } 
            paramFragment.mFragmentManager = fragmentManagerImpl;
            if (paramFragment.mTarget != null)
              if (this.mActive.get(paramFragment.mTarget.mIndex) == paramFragment.mTarget) {
                if (paramFragment.mTarget.mState < 1)
                  moveToState(paramFragment.mTarget, 1, 0, 0, true); 
              } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Fragment ");
                stringBuilder.append(paramFragment);
                stringBuilder.append(" declared target fragment ");
                stringBuilder.append(paramFragment.mTarget);
                stringBuilder.append(" that does not belong to this FragmentManager!");
                throw new IllegalStateException(stringBuilder.toString());
              }  
            dispatchOnFragmentPreAttached(paramFragment, this.mHost.getContext(), false);
            paramFragment.mCalled = false;
            paramFragment.onAttach(this.mHost.getContext());
            if (paramFragment.mCalled) {
              if (paramFragment.mParentFragment == null) {
                this.mHost.onAttachFragment(paramFragment);
              } else {
                paramFragment.mParentFragment.onAttachFragment(paramFragment);
              } 
              dispatchOnFragmentAttached(paramFragment, this.mHost.getContext(), false);
              if (!paramFragment.mIsCreated) {
                dispatchOnFragmentPreCreated(paramFragment, paramFragment.mSavedFragmentState, false);
                paramFragment.performCreate(paramFragment.mSavedFragmentState);
                dispatchOnFragmentCreated(paramFragment, paramFragment.mSavedFragmentState, false);
              } else {
                paramFragment.restoreChildFragmentState(paramFragment.mSavedFragmentState);
                paramFragment.mState = 1;
              } 
              paramFragment.mRetaining = false;
            } else {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Fragment ");
              stringBuilder.append(paramFragment);
              stringBuilder.append(" did not call through to super.onAttach()");
              throw new SuperNotCalledException(stringBuilder.toString());
            } 
          } 
        case 1:
          ensureInflatedFragmentView(paramFragment);
          i = j;
          if (j > 1) {
            if (DEBUG) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("moveto ACTIVITY_CREATED: ");
              stringBuilder.append(paramFragment);
              Log.v("FragmentManager", stringBuilder.toString());
            } 
            if (!paramFragment.mFromLayout) {
              ViewGroup viewGroup;
              if (paramFragment.mContainerId != 0) {
                if (paramFragment.mContainerId == -1) {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("Cannot create fragment ");
                  stringBuilder.append(paramFragment);
                  stringBuilder.append(" for a container view with no id");
                  throwException(new IllegalArgumentException(stringBuilder.toString()));
                } 
                ViewGroup viewGroup1 = (ViewGroup)this.mContainer.onFindViewById(paramFragment.mContainerId);
                viewGroup = viewGroup1;
                if (viewGroup1 == null) {
                  viewGroup = viewGroup1;
                  if (!paramFragment.mRestored) {
                    String str;
                    try {
                      str = paramFragment.getResources().getResourceName(paramFragment.mContainerId);
                    } catch (android.content.res.Resources.NotFoundException notFoundException) {
                      str = "unknown";
                    } 
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("No view found for id 0x");
                    stringBuilder.append(Integer.toHexString(paramFragment.mContainerId));
                    stringBuilder.append(" (");
                    stringBuilder.append(str);
                    stringBuilder.append(") for fragment ");
                    stringBuilder.append(paramFragment);
                    throwException(new IllegalArgumentException(stringBuilder.toString()));
                    ViewGroup viewGroup2 = viewGroup1;
                  } 
                } 
              } else {
                viewGroup = null;
              } 
              paramFragment.mContainer = viewGroup;
              paramFragment.mView = paramFragment.performCreateView(paramFragment.performGetLayoutInflater(paramFragment.mSavedFragmentState), viewGroup, paramFragment.mSavedFragmentState);
              if (paramFragment.mView != null) {
                paramFragment.mInnerView = paramFragment.mView;
                paramFragment.mView.setSaveFromParentEnabled(false);
                if (viewGroup != null)
                  viewGroup.addView(paramFragment.mView); 
                if (paramFragment.mHidden)
                  paramFragment.mView.setVisibility(8); 
                paramFragment.onViewCreated(paramFragment.mView, paramFragment.mSavedFragmentState);
                dispatchOnFragmentViewCreated(paramFragment, paramFragment.mView, paramFragment.mSavedFragmentState, false);
                if (paramFragment.mView.getVisibility() == 0 && paramFragment.mContainer != null) {
                  paramBoolean = bool1;
                } else {
                  paramBoolean = false;
                } 
                paramFragment.mIsNewlyAdded = paramBoolean;
              } else {
                paramFragment.mInnerView = null;
              } 
            } 
            paramFragment.performActivityCreated(paramFragment.mSavedFragmentState);
            dispatchOnFragmentActivityCreated(paramFragment, paramFragment.mSavedFragmentState, false);
            if (paramFragment.mView != null)
              paramFragment.restoreViewState(paramFragment.mSavedFragmentState); 
            paramFragment.mSavedFragmentState = null;
            i = j;
          } 
        case 2:
          paramInt3 = i;
          if (i > 2) {
            paramFragment.mState = 3;
            paramInt3 = i;
          } 
        case 3:
          paramInt2 = paramInt3;
          if (paramInt3 > 3) {
            if (DEBUG) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("moveto STARTED: ");
              stringBuilder.append(paramFragment);
              Log.v("FragmentManager", stringBuilder.toString());
            } 
            paramFragment.performStart();
            dispatchOnFragmentStarted(paramFragment, false);
            paramInt2 = paramInt3;
          } 
        case 4:
          if (paramInt2 > 4) {
            if (DEBUG) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("moveto RESUMED: ");
              stringBuilder.append(paramFragment);
              Log.v("FragmentManager", stringBuilder.toString());
            } 
            paramFragment.performResume();
            dispatchOnFragmentResumed(paramFragment, false);
            paramFragment.mSavedFragmentState = null;
            paramFragment.mSavedViewState = null;
          } 
          paramInt1 = paramInt2;
          break;
      } 
    } else if (paramFragment.mState > paramInt1) {
      switch (paramFragment.mState) {
        case 5:
          if (paramInt1 < 5) {
            if (DEBUG) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("movefrom RESUMED: ");
              stringBuilder.append(paramFragment);
              Log.v("FragmentManager", stringBuilder.toString());
            } 
            paramFragment.performPause();
            dispatchOnFragmentPaused(paramFragment, false);
          } 
        case 4:
          if (paramInt1 < 4) {
            if (DEBUG) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("movefrom STARTED: ");
              stringBuilder.append(paramFragment);
              Log.v("FragmentManager", stringBuilder.toString());
            } 
            paramFragment.performStop();
            dispatchOnFragmentStopped(paramFragment, false);
          } 
        case 3:
          if (paramInt1 < 3) {
            if (DEBUG) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("movefrom STOPPED: ");
              stringBuilder.append(paramFragment);
              Log.v("FragmentManager", stringBuilder.toString());
            } 
            paramFragment.performReallyStop();
          } 
        case 2:
          if (paramInt1 < 2) {
            if (DEBUG) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("movefrom ACTIVITY_CREATED: ");
              stringBuilder.append(paramFragment);
              Log.v("FragmentManager", stringBuilder.toString());
            } 
            if (paramFragment.mView != null && this.mHost.onShouldSaveFragmentState(paramFragment) && paramFragment.mSavedViewState == null)
              saveFragmentViewState(paramFragment); 
            paramFragment.performDestroyView();
            dispatchOnFragmentViewDestroyed(paramFragment, false);
            if (paramFragment.mView != null && paramFragment.mContainer != null) {
              AnimationOrAnimator animationOrAnimator;
              paramFragment.mContainer.endViewTransition(paramFragment.mView);
              paramFragment.mView.clearAnimation();
              if (this.mCurState > 0 && !this.mDestroyed && paramFragment.mView.getVisibility() == 0 && paramFragment.mPostponedAlpha >= 0.0F) {
                animationOrAnimator = loadAnimation(paramFragment, paramInt2, false, paramInt3);
              } else {
                animationOrAnimator = null;
              } 
              paramFragment.mPostponedAlpha = 0.0F;
              if (animationOrAnimator != null)
                animateRemoveFragment(paramFragment, animationOrAnimator, paramInt1); 
              paramFragment.mContainer.removeView(paramFragment.mView);
            } 
            paramFragment.mContainer = null;
            paramFragment.mView = null;
            paramFragment.mInnerView = null;
            paramFragment.mInLayout = false;
          } 
        case 1:
          if (paramInt1 < 1) {
            if (this.mDestroyed)
              if (paramFragment.getAnimatingAway() != null) {
                View view = paramFragment.getAnimatingAway();
                paramFragment.setAnimatingAway(null);
                view.clearAnimation();
              } else if (paramFragment.getAnimator() != null) {
                Animator animator = paramFragment.getAnimator();
                paramFragment.setAnimator(null);
                animator.cancel();
              }  
            if (paramFragment.getAnimatingAway() != null || paramFragment.getAnimator() != null) {
              paramFragment.setStateAfterAnimating(paramInt1);
              paramInt1 = i;
              break;
            } 
            if (DEBUG) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("movefrom CREATED: ");
              stringBuilder.append(paramFragment);
              Log.v("FragmentManager", stringBuilder.toString());
            } 
            if (!paramFragment.mRetaining) {
              paramFragment.performDestroy();
              dispatchOnFragmentDestroyed(paramFragment, false);
            } else {
              paramFragment.mState = 0;
            } 
            paramFragment.performDetach();
            dispatchOnFragmentDetached(paramFragment, false);
            if (!paramBoolean) {
              if (!paramFragment.mRetaining) {
                makeInactive(paramFragment);
                break;
              } 
              paramFragment.mHost = null;
              paramFragment.mParentFragment = null;
              paramFragment.mFragmentManager = null;
            } 
          } 
          break;
      } 
    } 
    if (paramFragment.mState != paramInt1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("moveToState: Fragment state for ");
      stringBuilder.append(paramFragment);
      stringBuilder.append(" not updated inline; ");
      stringBuilder.append("expected state ");
      stringBuilder.append(paramInt1);
      stringBuilder.append(" found ");
      stringBuilder.append(paramFragment.mState);
      Log.w("FragmentManager", stringBuilder.toString());
      paramFragment.mState = paramInt1;
    } 
  }
  
  public void noteStateNotSaved() {
    this.mSavedNonConfig = null;
    byte b = 0;
    this.mStateSaved = false;
    this.mStopped = false;
    int i = this.mAdded.size();
    while (b < i) {
      Fragment fragment = this.mAdded.get(b);
      if (fragment != null)
        fragment.noteStateNotSaved(); 
      b++;
    } 
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet) {
    if (!"fragment".equals(paramString))
      return null; 
    String str1 = paramAttributeSet.getAttributeValue(null, "class");
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, FragmentTag.Fragment);
    int i = 0;
    if (str1 == null)
      str1 = typedArray.getString(0); 
    int j = typedArray.getResourceId(1, -1);
    String str2 = typedArray.getString(2);
    typedArray.recycle();
    if (!Fragment.isSupportFragmentClass(this.mHost.getContext(), str1))
      return null; 
    if (paramView != null)
      i = paramView.getId(); 
    if (i != -1 || j != -1 || str2 != null) {
      Fragment fragment1;
      FragmentHostCallback fragmentHostCallback;
      if (j != -1) {
        Fragment fragment = findFragmentById(j);
      } else {
        typedArray = null;
      } 
      TypedArray typedArray1 = typedArray;
      if (typedArray == null) {
        typedArray1 = typedArray;
        if (str2 != null)
          fragment1 = findFragmentByTag(str2); 
      } 
      Fragment fragment2 = fragment1;
      if (fragment1 == null) {
        fragment2 = fragment1;
        if (i != -1)
          fragment2 = findFragmentById(i); 
      } 
      if (DEBUG) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("onCreateView: id=0x");
        stringBuilder1.append(Integer.toHexString(j));
        stringBuilder1.append(" fname=");
        stringBuilder1.append(str1);
        stringBuilder1.append(" existing=");
        stringBuilder1.append(fragment2);
        Log.v("FragmentManager", stringBuilder1.toString());
      } 
      if (fragment2 == null) {
        int k;
        fragment1 = this.mContainer.instantiate(paramContext, str1, null);
        fragment1.mFromLayout = true;
        if (j != 0) {
          k = j;
        } else {
          k = i;
        } 
        fragment1.mFragmentId = k;
        fragment1.mContainerId = i;
        fragment1.mTag = str2;
        fragment1.mInLayout = true;
        fragment1.mFragmentManager = this;
        fragmentHostCallback = this.mHost;
        fragment1.mHost = fragmentHostCallback;
        fragment1.onInflate(fragmentHostCallback.getContext(), paramAttributeSet, fragment1.mSavedFragmentState);
        addFragment(fragment1, true);
      } else if (!((Fragment)fragmentHostCallback).mInLayout) {
        ((Fragment)fragmentHostCallback).mInLayout = true;
        ((Fragment)fragmentHostCallback).mHost = this.mHost;
        if (!((Fragment)fragmentHostCallback).mRetaining)
          fragmentHostCallback.onInflate(this.mHost.getContext(), paramAttributeSet, ((Fragment)fragmentHostCallback).mSavedFragmentState); 
        FragmentHostCallback fragmentHostCallback1 = fragmentHostCallback;
      } else {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramAttributeSet.getPositionDescription());
        stringBuilder1.append(": Duplicate id 0x");
        stringBuilder1.append(Integer.toHexString(j));
        stringBuilder1.append(", tag ");
        stringBuilder1.append(str2);
        stringBuilder1.append(", or parent id 0x");
        stringBuilder1.append(Integer.toHexString(i));
        stringBuilder1.append(" with another fragment for ");
        stringBuilder1.append(str1);
        throw new IllegalArgumentException(stringBuilder1.toString());
      } 
      if (this.mCurState < 1 && ((Fragment)stringBuilder1).mFromLayout) {
        moveToState((Fragment)stringBuilder1, 1, 0, 0, false);
      } else {
        moveToState((Fragment)stringBuilder1);
      } 
      if (((Fragment)stringBuilder1).mView != null) {
        if (j != 0)
          ((Fragment)stringBuilder1).mView.setId(j); 
        if (((Fragment)stringBuilder1).mView.getTag() == null)
          ((Fragment)stringBuilder1).mView.setTag(str2); 
        return ((Fragment)stringBuilder1).mView;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Fragment ");
      stringBuilder1.append(str1);
      stringBuilder1.append(" did not create a view.");
      throw new IllegalStateException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramAttributeSet.getPositionDescription());
    stringBuilder.append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
    stringBuilder.append(str1);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet) {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
  
  public void performPendingDeferredStart(Fragment paramFragment) {
    if (paramFragment.mDeferStart) {
      if (this.mExecutingActions) {
        this.mHavePendingDeferredStart = true;
        return;
      } 
      paramFragment.mDeferStart = false;
      moveToState(paramFragment, this.mCurState, 0, 0, false);
    } 
  }
  
  public void popBackStack() {
    enqueueAction(new PopBackStackState(null, -1, 0), false);
  }
  
  public void popBackStack(int paramInt1, int paramInt2) {
    if (paramInt1 >= 0) {
      enqueueAction(new PopBackStackState(null, paramInt1, paramInt2), false);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Bad id: ");
    stringBuilder.append(paramInt1);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void popBackStack(String paramString, int paramInt) {
    enqueueAction(new PopBackStackState(paramString, -1, paramInt), false);
  }
  
  public boolean popBackStackImmediate() {
    checkStateLoss();
    return popBackStackImmediate(null, -1, 0);
  }
  
  public boolean popBackStackImmediate(int paramInt1, int paramInt2) {
    checkStateLoss();
    execPendingActions();
    if (paramInt1 >= 0)
      return popBackStackImmediate(null, paramInt1, paramInt2); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Bad id: ");
    stringBuilder.append(paramInt1);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public boolean popBackStackImmediate(String paramString, int paramInt) {
    checkStateLoss();
    return popBackStackImmediate(paramString, -1, paramInt);
  }
  
  boolean popBackStackState(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, String paramString, int paramInt1, int paramInt2) {
    ArrayList<BackStackRecord> arrayList = this.mBackStack;
    if (arrayList == null)
      return false; 
    if (paramString == null && paramInt1 < 0 && (paramInt2 & 0x1) == 0) {
      paramInt1 = arrayList.size() - 1;
      if (paramInt1 < 0)
        return false; 
      paramArrayList.add(this.mBackStack.remove(paramInt1));
      paramArrayList1.add(Boolean.valueOf(true));
    } else {
      byte b;
      if (paramString != null || paramInt1 >= 0) {
        int i;
        for (i = this.mBackStack.size() - 1; i >= 0; i--) {
          BackStackRecord backStackRecord = this.mBackStack.get(i);
          if ((paramString != null && paramString.equals(backStackRecord.getName())) || (paramInt1 >= 0 && paramInt1 == backStackRecord.mIndex))
            break; 
        } 
        if (i < 0)
          return false; 
        b = i;
        if ((paramInt2 & 0x1) != 0)
          for (paramInt2 = i - 1;; paramInt2--) {
            b = paramInt2;
            if (paramInt2 >= 0) {
              BackStackRecord backStackRecord = this.mBackStack.get(paramInt2);
              if (paramString == null || !paramString.equals(backStackRecord.getName())) {
                b = paramInt2;
                if (paramInt1 >= 0) {
                  b = paramInt2;
                  if (paramInt1 == backStackRecord.mIndex)
                    continue; 
                } 
                break;
              } 
              continue;
            } 
            break;
          }  
      } else {
        b = -1;
      } 
      if (b == this.mBackStack.size() - 1)
        return false; 
      for (paramInt1 = this.mBackStack.size() - 1; paramInt1 > b; paramInt1--) {
        paramArrayList.add(this.mBackStack.remove(paramInt1));
        paramArrayList1.add(Boolean.valueOf(true));
      } 
    } 
    return true;
  }
  
  public void putFragment(Bundle paramBundle, String paramString, Fragment paramFragment) {
    if (paramFragment.mIndex < 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Fragment ");
      stringBuilder.append(paramFragment);
      stringBuilder.append(" is not currently in the FragmentManager");
      throwException(new IllegalStateException(stringBuilder.toString()));
    } 
    paramBundle.putInt(paramString, paramFragment.mIndex);
  }
  
  public void registerFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks paramFragmentLifecycleCallbacks, boolean paramBoolean) {
    this.mLifecycleCallbacks.add(new Pair(paramFragmentLifecycleCallbacks, Boolean.valueOf(paramBoolean)));
  }
  
  public void removeFragment(Fragment paramFragment) {
    if (DEBUG) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("remove: ");
      stringBuilder.append(paramFragment);
      stringBuilder.append(" nesting=");
      stringBuilder.append(paramFragment.mBackStackNesting);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
    boolean bool = paramFragment.isInBackStack();
    if (!paramFragment.mDetached || (bool ^ true) != 0)
      synchronized (this.mAdded) {
        this.mAdded.remove(paramFragment);
        if (paramFragment.mHasMenu && paramFragment.mMenuVisible)
          this.mNeedMenuInvalidate = true; 
        paramFragment.mAdded = false;
        paramFragment.mRemoving = true;
        return;
      }  
  }
  
  public void removeOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener) {
    ArrayList<FragmentManager.OnBackStackChangedListener> arrayList = this.mBackStackChangeListeners;
    if (arrayList != null)
      arrayList.remove(paramOnBackStackChangedListener); 
  }
  
  void reportBackStackChanged() {
    if (this.mBackStackChangeListeners != null)
      for (byte b = 0; b < this.mBackStackChangeListeners.size(); b++)
        ((FragmentManager.OnBackStackChangedListener)this.mBackStackChangeListeners.get(b)).onBackStackChanged();  
  }
  
  void restoreAllState(Parcelable<FragmentManagerNonConfig> paramParcelable, FragmentManagerNonConfig paramFragmentManagerNonConfig) {
    Parcelable<FragmentManagerNonConfig> parcelable;
    if (paramParcelable == null)
      return; 
    FragmentManagerState fragmentManagerState = (FragmentManagerState)paramParcelable;
    if (fragmentManagerState.mActive == null)
      return; 
    if (paramFragmentManagerNonConfig != null) {
      byte b1;
      List<Fragment> list = paramFragmentManagerNonConfig.getFragments();
      List<FragmentManagerNonConfig> list1 = paramFragmentManagerNonConfig.getChildNonConfigs();
      List<ViewModelStore> list2 = paramFragmentManagerNonConfig.getViewModelStores();
      if (list != null) {
        b1 = list.size();
      } else {
        b1 = 0;
      } 
      byte b2 = 0;
      while (true) {
        List<FragmentManagerNonConfig> list4 = list1;
        List<ViewModelStore> list3 = list2;
        if (b2 < b1) {
          Fragment fragment = list.get(b2);
          if (DEBUG) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("restoreAllState: re-attaching retained ");
            stringBuilder.append(fragment);
            Log.v("FragmentManager", stringBuilder.toString());
          } 
          byte b;
          for (b = 0; b < fragmentManagerState.mActive.length && (fragmentManagerState.mActive[b]).mIndex != fragment.mIndex; b++);
          if (b == fragmentManagerState.mActive.length) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not find active fragment with index ");
            stringBuilder.append(fragment.mIndex);
            throwException(new IllegalStateException(stringBuilder.toString()));
          } 
          parcelable = fragmentManagerState.mActive[b];
          ((FragmentState)parcelable).mInstance = fragment;
          fragment.mSavedViewState = null;
          fragment.mBackStackNesting = 0;
          fragment.mInLayout = false;
          fragment.mAdded = false;
          fragment.mTarget = null;
          if (((FragmentState)parcelable).mSavedFragmentState != null) {
            ((FragmentState)parcelable).mSavedFragmentState.setClassLoader(this.mHost.getContext().getClassLoader());
            fragment.mSavedViewState = ((FragmentState)parcelable).mSavedFragmentState.getSparseParcelableArray("android:view_state");
            fragment.mSavedFragmentState = ((FragmentState)parcelable).mSavedFragmentState;
          } 
          b2++;
          continue;
        } 
        break;
      } 
    } else {
      parcelable = null;
      paramParcelable = parcelable;
    } 
    this.mActive = new SparseArray(fragmentManagerState.mActive.length);
    int i;
    for (i = 0; i < fragmentManagerState.mActive.length; i++) {
      FragmentState fragmentState = fragmentManagerState.mActive[i];
      if (fragmentState != null) {
        FragmentManagerNonConfig fragmentManagerNonConfig;
        if (parcelable != null && i < parcelable.size()) {
          fragmentManagerNonConfig = parcelable.get(i);
        } else {
          fragmentManagerNonConfig = null;
        } 
        if (paramParcelable != null && i < paramParcelable.size()) {
          fragment = (Fragment)paramParcelable.get(i);
        } else {
          fragment = null;
        } 
        Fragment fragment = fragmentState.instantiate(this.mHost, this.mContainer, this.mParent, fragmentManagerNonConfig, (ViewModelStore)fragment);
        if (DEBUG) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("restoreAllState: active #");
          stringBuilder.append(i);
          stringBuilder.append(": ");
          stringBuilder.append(fragment);
          Log.v("FragmentManager", stringBuilder.toString());
        } 
        this.mActive.put(fragment.mIndex, fragment);
        fragmentState.mInstance = null;
      } 
    } 
    if (paramFragmentManagerNonConfig != null) {
      List<Fragment> list = paramFragmentManagerNonConfig.getFragments();
      if (list != null) {
        i = list.size();
      } else {
        i = 0;
      } 
      for (byte b = 0; b < i; b++) {
        Fragment fragment = list.get(b);
        if (fragment.mTargetIndex >= 0) {
          fragment.mTarget = (Fragment)this.mActive.get(fragment.mTargetIndex);
          if (fragment.mTarget == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Re-attaching retained fragment ");
            stringBuilder.append(fragment);
            stringBuilder.append(" target no longer exists: ");
            stringBuilder.append(fragment.mTargetIndex);
            Log.w("FragmentManager", stringBuilder.toString());
          } 
        } 
      } 
    } 
    this.mAdded.clear();
    if (fragmentManagerState.mAdded != null) {
      i = 0;
      while (i < fragmentManagerState.mAdded.length) {
        Fragment fragment = (Fragment)this.mActive.get(fragmentManagerState.mAdded[i]);
        if (fragment == null) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("No instantiated fragment for index #");
          stringBuilder.append(fragmentManagerState.mAdded[i]);
          throwException(new IllegalStateException(stringBuilder.toString()));
        } 
        fragment.mAdded = true;
        if (DEBUG) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("restoreAllState: added #");
          stringBuilder.append(i);
          stringBuilder.append(": ");
          stringBuilder.append(fragment);
          Log.v("FragmentManager", stringBuilder.toString());
        } 
        if (!this.mAdded.contains(fragment)) {
          synchronized (this.mAdded) {
            this.mAdded.add(fragment);
            i++;
          } 
          continue;
        } 
        throw new IllegalStateException("Already added!");
      } 
    } 
    if (fragmentManagerState.mBackStack != null) {
      this.mBackStack = new ArrayList<BackStackRecord>(fragmentManagerState.mBackStack.length);
      for (i = 0; i < fragmentManagerState.mBackStack.length; i++) {
        BackStackRecord backStackRecord = fragmentManagerState.mBackStack[i].instantiate(this);
        if (DEBUG) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("restoreAllState: back stack #");
          stringBuilder.append(i);
          stringBuilder.append(" (index ");
          stringBuilder.append(backStackRecord.mIndex);
          stringBuilder.append("): ");
          stringBuilder.append(backStackRecord);
          Log.v("FragmentManager", stringBuilder.toString());
          PrintWriter printWriter = new PrintWriter((Writer)new LogWriter("FragmentManager"));
          backStackRecord.dump("  ", printWriter, false);
          printWriter.close();
        } 
        this.mBackStack.add(backStackRecord);
        if (backStackRecord.mIndex >= 0)
          setBackStackIndex(backStackRecord.mIndex, backStackRecord); 
      } 
    } else {
      this.mBackStack = null;
    } 
    if (fragmentManagerState.mPrimaryNavActiveIndex >= 0)
      this.mPrimaryNav = (Fragment)this.mActive.get(fragmentManagerState.mPrimaryNavActiveIndex); 
    this.mNextFragmentIndex = fragmentManagerState.mNextFragmentIndex;
  }
  
  FragmentManagerNonConfig retainNonConfig() {
    setRetaining(this.mSavedNonConfig);
    return this.mSavedNonConfig;
  }
  
  Parcelable saveAllState() {
    StringBuilder stringBuilder;
    forcePostponedTransactions();
    endAnimatingAwayFragments();
    execPendingActions();
    this.mStateSaved = true;
    BackStackState[] arrayOfBackStackState1 = null;
    this.mSavedNonConfig = null;
    SparseArray<Fragment> sparseArray = this.mActive;
    if (sparseArray == null || sparseArray.size() <= 0)
      return null; 
    int i = this.mActive.size();
    FragmentState[] arrayOfFragmentState = new FragmentState[i];
    boolean bool = false;
    byte b = 0;
    int j = 0;
    while (b < i) {
      Fragment fragment1 = (Fragment)this.mActive.valueAt(b);
      if (fragment1 != null) {
        if (fragment1.mIndex < 0) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("Failure saving state: active ");
          stringBuilder.append(fragment1);
          stringBuilder.append(" has cleared index: ");
          stringBuilder.append(fragment1.mIndex);
          throwException(new IllegalStateException(stringBuilder.toString()));
        } 
        FragmentState fragmentState = new FragmentState(fragment1);
        arrayOfFragmentState[b] = fragmentState;
        if (fragment1.mState > 0 && fragmentState.mSavedFragmentState == null) {
          fragmentState.mSavedFragmentState = saveFragmentBasicState(fragment1);
          if (fragment1.mTarget != null) {
            if (fragment1.mTarget.mIndex < 0) {
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("Failure saving state: ");
              stringBuilder1.append(fragment1);
              stringBuilder1.append(" has target not in fragment manager: ");
              stringBuilder1.append(fragment1.mTarget);
              throwException(new IllegalStateException(stringBuilder1.toString()));
            } 
            if (fragmentState.mSavedFragmentState == null)
              fragmentState.mSavedFragmentState = new Bundle(); 
            putFragment(fragmentState.mSavedFragmentState, "android:target_state", fragment1.mTarget);
            if (fragment1.mTargetRequestCode != 0)
              fragmentState.mSavedFragmentState.putInt("android:target_req_state", fragment1.mTargetRequestCode); 
          } 
        } else {
          fragmentState.mSavedFragmentState = fragment1.mSavedFragmentState;
        } 
        if (DEBUG) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Saved state of ");
          stringBuilder1.append(fragment1);
          stringBuilder1.append(": ");
          stringBuilder1.append(fragmentState.mSavedFragmentState);
          Log.v("FragmentManager", stringBuilder1.toString());
        } 
        j = 1;
      } 
      b++;
    } 
    if (!j) {
      if (DEBUG)
        Log.v("FragmentManager", "saveAllState: no fragments!"); 
      return null;
    } 
    j = this.mAdded.size();
    if (j > 0) {
      int[] arrayOfInt = new int[j];
      b = 0;
      while (true) {
        int[] arrayOfInt1 = arrayOfInt;
        if (b < j) {
          arrayOfInt[b] = ((Fragment)this.mAdded.get(b)).mIndex;
          if (arrayOfInt[b] < 0) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Failure saving state: active ");
            stringBuilder1.append(this.mAdded.get(b));
            stringBuilder1.append(" has cleared index: ");
            stringBuilder1.append(arrayOfInt[b]);
            throwException(new IllegalStateException(stringBuilder1.toString()));
          } 
          if (DEBUG) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("saveAllState: adding fragment #");
            stringBuilder1.append(b);
            stringBuilder1.append(": ");
            stringBuilder1.append(this.mAdded.get(b));
            Log.v("FragmentManager", stringBuilder1.toString());
          } 
          b++;
          continue;
        } 
        break;
      } 
    } else {
      sparseArray = null;
    } 
    ArrayList<BackStackRecord> arrayList = this.mBackStack;
    BackStackState[] arrayOfBackStackState2 = arrayOfBackStackState1;
    if (arrayList != null) {
      j = arrayList.size();
      arrayOfBackStackState2 = arrayOfBackStackState1;
      if (j > 0) {
        arrayOfBackStackState1 = new BackStackState[j];
        b = bool;
        while (true) {
          arrayOfBackStackState2 = arrayOfBackStackState1;
          if (b < j) {
            arrayOfBackStackState1[b] = new BackStackState(this.mBackStack.get(b));
            if (DEBUG) {
              stringBuilder = new StringBuilder();
              stringBuilder.append("saveAllState: adding back stack #");
              stringBuilder.append(b);
              stringBuilder.append(": ");
              stringBuilder.append(this.mBackStack.get(b));
              Log.v("FragmentManager", stringBuilder.toString());
            } 
            b++;
            continue;
          } 
          break;
        } 
      } 
    } 
    FragmentManagerState fragmentManagerState = new FragmentManagerState();
    fragmentManagerState.mActive = arrayOfFragmentState;
    fragmentManagerState.mAdded = (int[])sparseArray;
    fragmentManagerState.mBackStack = (BackStackState[])stringBuilder;
    Fragment fragment = this.mPrimaryNav;
    if (fragment != null)
      fragmentManagerState.mPrimaryNavActiveIndex = fragment.mIndex; 
    fragmentManagerState.mNextFragmentIndex = this.mNextFragmentIndex;
    saveNonConfig();
    return fragmentManagerState;
  }
  
  Bundle saveFragmentBasicState(Fragment paramFragment) {
    if (this.mStateBundle == null)
      this.mStateBundle = new Bundle(); 
    paramFragment.performSaveInstanceState(this.mStateBundle);
    dispatchOnFragmentSaveInstanceState(paramFragment, this.mStateBundle, false);
    if (!this.mStateBundle.isEmpty()) {
      bundle1 = this.mStateBundle;
      this.mStateBundle = null;
    } else {
      bundle1 = null;
    } 
    if (paramFragment.mView != null)
      saveFragmentViewState(paramFragment); 
    Bundle bundle2 = bundle1;
    if (paramFragment.mSavedViewState != null) {
      bundle2 = bundle1;
      if (bundle1 == null)
        bundle2 = new Bundle(); 
      bundle2.putSparseParcelableArray("android:view_state", paramFragment.mSavedViewState);
    } 
    Bundle bundle1 = bundle2;
    if (!paramFragment.mUserVisibleHint) {
      bundle1 = bundle2;
      if (bundle2 == null)
        bundle1 = new Bundle(); 
      bundle1.putBoolean("android:user_visible_hint", paramFragment.mUserVisibleHint);
    } 
    return bundle1;
  }
  
  public Fragment.SavedState saveFragmentInstanceState(Fragment paramFragment) {
    if (paramFragment.mIndex < 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Fragment ");
      stringBuilder.append(paramFragment);
      stringBuilder.append(" is not currently in the FragmentManager");
      throwException(new IllegalStateException(stringBuilder.toString()));
    } 
    int i = paramFragment.mState;
    Fragment fragment = null;
    if (i > 0) {
      Fragment.SavedState savedState;
      Bundle bundle = saveFragmentBasicState(paramFragment);
      paramFragment = fragment;
      if (bundle != null)
        savedState = new Fragment.SavedState(bundle); 
      return savedState;
    } 
    return null;
  }
  
  void saveFragmentViewState(Fragment paramFragment) {
    if (paramFragment.mInnerView == null)
      return; 
    SparseArray<Parcelable> sparseArray = this.mStateArray;
    if (sparseArray == null) {
      this.mStateArray = new SparseArray();
    } else {
      sparseArray.clear();
    } 
    paramFragment.mInnerView.saveHierarchyState(this.mStateArray);
    if (this.mStateArray.size() > 0) {
      paramFragment.mSavedViewState = this.mStateArray;
      this.mStateArray = null;
    } 
  }
  
  void saveNonConfig() {
    List<FragmentManagerNonConfig> list1;
    List<FragmentManagerNonConfig> list2;
    List<FragmentManagerNonConfig> list3;
    if (this.mActive != null) {
      ArrayList<Fragment> arrayList1 = null;
      ArrayList<Fragment> arrayList2 = arrayList1;
      ArrayList<Fragment> arrayList3 = arrayList2;
      byte b = 0;
      while (true) {
        list1 = (List)arrayList1;
        list2 = (List)arrayList2;
        list3 = (List)arrayList3;
        if (b < this.mActive.size()) {
          ArrayList<Fragment> arrayList4;
          Fragment fragment = (Fragment)this.mActive.valueAt(b);
          ArrayList<Fragment> arrayList5 = arrayList1;
          list2 = (List)arrayList2;
          list1 = (List)arrayList3;
          if (fragment != null) {
            FragmentManagerNonConfig fragmentManagerNonConfig;
            list3 = (List)arrayList1;
            if (fragment.mRetainInstance) {
              byte b1;
              list2 = (List)arrayList1;
              if (arrayList1 == null)
                list2 = new ArrayList(); 
              list2.add(fragment);
              if (fragment.mTarget != null) {
                b1 = fragment.mTarget.mIndex;
              } else {
                b1 = -1;
              } 
              fragment.mTargetIndex = b1;
              list3 = list2;
              if (DEBUG) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("retainNonConfig: keeping retained ");
                stringBuilder.append(fragment);
                Log.v("FragmentManager", stringBuilder.toString());
                list3 = list2;
              } 
            } 
            if (fragment.mChildFragmentManager != null) {
              fragment.mChildFragmentManager.saveNonConfig();
              fragmentManagerNonConfig = fragment.mChildFragmentManager.mSavedNonConfig;
            } else {
              fragmentManagerNonConfig = fragment.mChildNonConfig;
            } 
            arrayList1 = arrayList2;
            if (arrayList2 == null) {
              arrayList1 = arrayList2;
              if (fragmentManagerNonConfig != null) {
                arrayList2 = new ArrayList<Fragment>(this.mActive.size());
                byte b1 = 0;
                while (true) {
                  arrayList1 = arrayList2;
                  if (b1 < b) {
                    arrayList2.add(null);
                    b1++;
                    continue;
                  } 
                  break;
                } 
              } 
            } 
            if (arrayList1 != null)
              arrayList1.add(fragmentManagerNonConfig); 
            arrayList2 = arrayList3;
            if (arrayList3 == null) {
              arrayList2 = arrayList3;
              if (fragment.mViewModelStore != null) {
                arrayList3 = new ArrayList<Fragment>(this.mActive.size());
                byte b1 = 0;
                while (true) {
                  arrayList2 = arrayList3;
                  if (b1 < b) {
                    arrayList3.add(null);
                    b1++;
                    continue;
                  } 
                  break;
                } 
              } 
            } 
            arrayList5 = (ArrayList)list3;
            arrayList4 = arrayList1;
            list1 = (List)arrayList2;
            if (arrayList2 != null) {
              arrayList2.add(fragment.mViewModelStore);
              list1 = (List)arrayList2;
              arrayList4 = arrayList1;
              arrayList5 = (ArrayList)list3;
            } 
          } 
          b++;
          arrayList1 = arrayList5;
          arrayList2 = arrayList4;
          arrayList3 = (ArrayList)list1;
          continue;
        } 
        break;
      } 
    } else {
      list1 = null;
      List<FragmentManagerNonConfig> list = list1;
      list3 = list;
      list2 = list;
    } 
    if (list1 == null && list2 == null && list3 == null) {
      this.mSavedNonConfig = null;
    } else {
      this.mSavedNonConfig = new FragmentManagerNonConfig((List)list1, list2, (List)list3);
    } 
  }
  
  public void setBackStackIndex(int paramInt, BackStackRecord paramBackStackRecord) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   6: ifnonnull -> 22
    //   9: new java/util/ArrayList
    //   12: astore_3
    //   13: aload_3
    //   14: invokespecial <init> : ()V
    //   17: aload_0
    //   18: aload_3
    //   19: putfield mBackStackIndices : Ljava/util/ArrayList;
    //   22: aload_0
    //   23: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   26: invokevirtual size : ()I
    //   29: istore #4
    //   31: iload #4
    //   33: istore #5
    //   35: iload_1
    //   36: iload #4
    //   38: if_icmpge -> 106
    //   41: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   44: ifeq -> 93
    //   47: new java/lang/StringBuilder
    //   50: astore_3
    //   51: aload_3
    //   52: invokespecial <init> : ()V
    //   55: aload_3
    //   56: ldc_w 'Setting back stack index '
    //   59: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_3
    //   64: iload_1
    //   65: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_3
    //   70: ldc_w ' to '
    //   73: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_3
    //   78: aload_2
    //   79: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: ldc 'FragmentManager'
    //   85: aload_3
    //   86: invokevirtual toString : ()Ljava/lang/String;
    //   89: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   92: pop
    //   93: aload_0
    //   94: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   97: iload_1
    //   98: aload_2
    //   99: invokevirtual set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   102: pop
    //   103: goto -> 260
    //   106: iload #5
    //   108: iload_1
    //   109: if_icmpge -> 199
    //   112: aload_0
    //   113: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   116: aconst_null
    //   117: invokevirtual add : (Ljava/lang/Object;)Z
    //   120: pop
    //   121: aload_0
    //   122: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   125: ifnonnull -> 141
    //   128: new java/util/ArrayList
    //   131: astore_3
    //   132: aload_3
    //   133: invokespecial <init> : ()V
    //   136: aload_0
    //   137: aload_3
    //   138: putfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   141: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   144: ifeq -> 180
    //   147: new java/lang/StringBuilder
    //   150: astore_3
    //   151: aload_3
    //   152: invokespecial <init> : ()V
    //   155: aload_3
    //   156: ldc_w 'Adding available back stack index '
    //   159: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload_3
    //   164: iload #5
    //   166: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: ldc 'FragmentManager'
    //   172: aload_3
    //   173: invokevirtual toString : ()Ljava/lang/String;
    //   176: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   179: pop
    //   180: aload_0
    //   181: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   184: iload #5
    //   186: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   189: invokevirtual add : (Ljava/lang/Object;)Z
    //   192: pop
    //   193: iinc #5, 1
    //   196: goto -> 106
    //   199: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   202: ifeq -> 251
    //   205: new java/lang/StringBuilder
    //   208: astore_3
    //   209: aload_3
    //   210: invokespecial <init> : ()V
    //   213: aload_3
    //   214: ldc_w 'Adding back stack index '
    //   217: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload_3
    //   222: iload_1
    //   223: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload_3
    //   228: ldc_w ' with '
    //   231: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload_3
    //   236: aload_2
    //   237: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: ldc 'FragmentManager'
    //   243: aload_3
    //   244: invokevirtual toString : ()Ljava/lang/String;
    //   247: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   250: pop
    //   251: aload_0
    //   252: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   255: aload_2
    //   256: invokevirtual add : (Ljava/lang/Object;)Z
    //   259: pop
    //   260: aload_0
    //   261: monitorexit
    //   262: return
    //   263: astore_2
    //   264: aload_0
    //   265: monitorexit
    //   266: aload_2
    //   267: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	263	finally
    //   22	31	263	finally
    //   41	93	263	finally
    //   93	103	263	finally
    //   112	141	263	finally
    //   141	180	263	finally
    //   180	193	263	finally
    //   199	251	263	finally
    //   251	260	263	finally
    //   260	262	263	finally
    //   264	266	263	finally
  }
  
  public void setPrimaryNavigationFragment(Fragment paramFragment) {
    if (paramFragment == null || (this.mActive.get(paramFragment.mIndex) == paramFragment && (paramFragment.mHost == null || paramFragment.getFragmentManager() == this))) {
      this.mPrimaryNav = paramFragment;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Fragment ");
    stringBuilder.append(paramFragment);
    stringBuilder.append(" is not an active fragment of FragmentManager ");
    stringBuilder.append(this);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void showFragment(Fragment paramFragment) {
    if (DEBUG) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("show: ");
      stringBuilder.append(paramFragment);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
    if (paramFragment.mHidden) {
      paramFragment.mHidden = false;
      paramFragment.mHiddenChanged ^= 0x1;
    } 
  }
  
  void startPendingDeferredFragments() {
    if (this.mActive == null)
      return; 
    for (byte b = 0; b < this.mActive.size(); b++) {
      Fragment fragment = (Fragment)this.mActive.valueAt(b);
      if (fragment != null)
        performPendingDeferredStart(fragment); 
    } 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);
    stringBuilder.append("FragmentManager{");
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    stringBuilder.append(" in ");
    Fragment fragment = this.mParent;
    if (fragment != null) {
      DebugUtils.buildShortClassTag(fragment, stringBuilder);
    } else {
      DebugUtils.buildShortClassTag(this.mHost, stringBuilder);
    } 
    stringBuilder.append("}}");
    return stringBuilder.toString();
  }
  
  public void unregisterFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks paramFragmentLifecycleCallbacks) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mLifecycleCallbacks : Ljava/util/concurrent/CopyOnWriteArrayList;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: iconst_0
    //   8: istore_3
    //   9: aload_0
    //   10: getfield mLifecycleCallbacks : Ljava/util/concurrent/CopyOnWriteArrayList;
    //   13: invokevirtual size : ()I
    //   16: istore #4
    //   18: iload_3
    //   19: iload #4
    //   21: if_icmpge -> 60
    //   24: aload_0
    //   25: getfield mLifecycleCallbacks : Ljava/util/concurrent/CopyOnWriteArrayList;
    //   28: iload_3
    //   29: invokevirtual get : (I)Ljava/lang/Object;
    //   32: checkcast android/support/v4/util/Pair
    //   35: getfield first : Ljava/lang/Object;
    //   38: aload_1
    //   39: if_acmpne -> 54
    //   42: aload_0
    //   43: getfield mLifecycleCallbacks : Ljava/util/concurrent/CopyOnWriteArrayList;
    //   46: iload_3
    //   47: invokevirtual remove : (I)Ljava/lang/Object;
    //   50: pop
    //   51: goto -> 60
    //   54: iinc #3, 1
    //   57: goto -> 18
    //   60: aload_2
    //   61: monitorexit
    //   62: return
    //   63: astore_1
    //   64: aload_2
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Exception table:
    //   from	to	target	type
    //   9	18	63	finally
    //   24	51	63	finally
    //   60	62	63	finally
    //   64	66	63	finally
  }
  
  private static class AnimateOnHWLayerIfNeededListener extends AnimationListenerWrapper {
    View mView;
    
    AnimateOnHWLayerIfNeededListener(View param1View, Animation.AnimationListener param1AnimationListener) {
      super(param1AnimationListener);
      this.mView = param1View;
    }
    
    @CallSuper
    public void onAnimationEnd(Animation param1Animation) {
      if (ViewCompat.isAttachedToWindow(this.mView) || Build.VERSION.SDK_INT >= 24) {
        this.mView.post(new Runnable() {
              public void run() {
                FragmentManagerImpl.AnimateOnHWLayerIfNeededListener.this.mView.setLayerType(0, null);
              }
            });
      } else {
        this.mView.setLayerType(0, null);
      } 
      super.onAnimationEnd(param1Animation);
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$0.mView.setLayerType(0, null);
    }
  }
  
  private static class AnimationListenerWrapper implements Animation.AnimationListener {
    private final Animation.AnimationListener mWrapped;
    
    private AnimationListenerWrapper(Animation.AnimationListener param1AnimationListener) {
      this.mWrapped = param1AnimationListener;
    }
    
    @CallSuper
    public void onAnimationEnd(Animation param1Animation) {
      Animation.AnimationListener animationListener = this.mWrapped;
      if (animationListener != null)
        animationListener.onAnimationEnd(param1Animation); 
    }
    
    @CallSuper
    public void onAnimationRepeat(Animation param1Animation) {
      Animation.AnimationListener animationListener = this.mWrapped;
      if (animationListener != null)
        animationListener.onAnimationRepeat(param1Animation); 
    }
    
    @CallSuper
    public void onAnimationStart(Animation param1Animation) {
      Animation.AnimationListener animationListener = this.mWrapped;
      if (animationListener != null)
        animationListener.onAnimationStart(param1Animation); 
    }
  }
  
  private static class AnimationOrAnimator {
    public final Animation animation = null;
    
    public final Animator animator;
    
    private AnimationOrAnimator(Animator param1Animator) {
      this.animator = param1Animator;
      if (param1Animator != null)
        return; 
      throw new IllegalStateException("Animator cannot be null");
    }
    
    private AnimationOrAnimator(Animation param1Animation) {
      this.animator = null;
      if (param1Animation != null)
        return; 
      throw new IllegalStateException("Animation cannot be null");
    }
  }
  
  private static class AnimatorOnHWLayerIfNeededListener extends AnimatorListenerAdapter {
    View mView;
    
    AnimatorOnHWLayerIfNeededListener(View param1View) {
      this.mView = param1View;
    }
    
    public void onAnimationEnd(Animator param1Animator) {
      this.mView.setLayerType(0, null);
      param1Animator.removeListener((Animator.AnimatorListener)this);
    }
    
    public void onAnimationStart(Animator param1Animator) {
      this.mView.setLayerType(2, null);
    }
  }
  
  private static class EndViewTransitionAnimator extends AnimationSet implements Runnable {
    private final View mChild;
    
    private boolean mEnded;
    
    private final ViewGroup mParent;
    
    private boolean mTransitionEnded;
    
    EndViewTransitionAnimator(@NonNull Animation param1Animation, @NonNull ViewGroup param1ViewGroup, @NonNull View param1View) {
      super(false);
      this.mParent = param1ViewGroup;
      this.mChild = param1View;
      addAnimation(param1Animation);
    }
    
    public boolean getTransformation(long param1Long, Transformation param1Transformation) {
      if (this.mEnded)
        return this.mTransitionEnded ^ true; 
      if (!super.getTransformation(param1Long, param1Transformation)) {
        this.mEnded = true;
        OneShotPreDrawListener.add((View)this.mParent, this);
      } 
      return true;
    }
    
    public boolean getTransformation(long param1Long, Transformation param1Transformation, float param1Float) {
      if (this.mEnded)
        return this.mTransitionEnded ^ true; 
      if (!super.getTransformation(param1Long, param1Transformation, param1Float)) {
        this.mEnded = true;
        OneShotPreDrawListener.add((View)this.mParent, this);
      } 
      return true;
    }
    
    public void run() {
      this.mParent.endViewTransition(this.mChild);
      this.mTransitionEnded = true;
    }
  }
  
  static class FragmentTag {
    public static final int[] Fragment = new int[] { 16842755, 16842960, 16842961 };
    
    public static final int Fragment_id = 1;
    
    public static final int Fragment_name = 0;
    
    public static final int Fragment_tag = 2;
  }
  
  static interface OpGenerator {
    boolean generateOps(ArrayList<BackStackRecord> param1ArrayList, ArrayList<Boolean> param1ArrayList1);
  }
  
  private class PopBackStackState implements OpGenerator {
    final int mFlags;
    
    final int mId;
    
    final String mName;
    
    PopBackStackState(String param1String, int param1Int1, int param1Int2) {
      this.mName = param1String;
      this.mId = param1Int1;
      this.mFlags = param1Int2;
    }
    
    public boolean generateOps(ArrayList<BackStackRecord> param1ArrayList, ArrayList<Boolean> param1ArrayList1) {
      if (FragmentManagerImpl.this.mPrimaryNav != null && this.mId < 0 && this.mName == null) {
        FragmentManager fragmentManager = FragmentManagerImpl.this.mPrimaryNav.peekChildFragmentManager();
        if (fragmentManager != null && fragmentManager.popBackStackImmediate())
          return false; 
      } 
      return FragmentManagerImpl.this.popBackStackState(param1ArrayList, param1ArrayList1, this.mName, this.mId, this.mFlags);
    }
  }
  
  static class StartEnterTransitionListener implements Fragment.OnStartEnterTransitionListener {
    private final boolean mIsBack;
    
    private int mNumPostponed;
    
    private final BackStackRecord mRecord;
    
    StartEnterTransitionListener(BackStackRecord param1BackStackRecord, boolean param1Boolean) {
      this.mIsBack = param1Boolean;
      this.mRecord = param1BackStackRecord;
    }
    
    public void cancelTransaction() {
      this.mRecord.mManager.completeExecute(this.mRecord, this.mIsBack, false, false);
    }
    
    public void completeTransaction() {
      int i = this.mNumPostponed;
      byte b = 0;
      if (i > 0) {
        i = 1;
      } else {
        i = 0;
      } 
      FragmentManagerImpl fragmentManagerImpl = this.mRecord.mManager;
      int j = fragmentManagerImpl.mAdded.size();
      while (b < j) {
        Fragment fragment = fragmentManagerImpl.mAdded.get(b);
        fragment.setOnStartEnterTransitionListener(null);
        if (i != 0 && fragment.isPostponed())
          fragment.startPostponedEnterTransition(); 
        b++;
      } 
      this.mRecord.mManager.completeExecute(this.mRecord, this.mIsBack, i ^ 0x1, true);
    }
    
    public boolean isReady() {
      boolean bool;
      if (this.mNumPostponed == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void onStartEnterTransition() {
      this.mNumPostponed--;
      if (this.mNumPostponed != 0)
        return; 
      this.mRecord.mManager.scheduleCommit();
    }
    
    public void startListening() {
      this.mNumPostponed++;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\v4\app\FragmentManagerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */