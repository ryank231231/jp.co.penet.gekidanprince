package android.support.v4.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class GestureDetectorCompat {
  private final GestureDetectorCompatImpl mImpl;
  
  public GestureDetectorCompat(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener) {
    this(paramContext, paramOnGestureListener, null);
  }
  
  public GestureDetectorCompat(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler) {
    if (Build.VERSION.SDK_INT > 17) {
      this.mImpl = new GestureDetectorCompatImplJellybeanMr2(paramContext, paramOnGestureListener, paramHandler);
    } else {
      this.mImpl = new GestureDetectorCompatImplBase(paramContext, paramOnGestureListener, paramHandler);
    } 
  }
  
  public boolean isLongpressEnabled() {
    return this.mImpl.isLongpressEnabled();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    return this.mImpl.onTouchEvent(paramMotionEvent);
  }
  
  public void setIsLongpressEnabled(boolean paramBoolean) {
    this.mImpl.setIsLongpressEnabled(paramBoolean);
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener) {
    this.mImpl.setOnDoubleTapListener(paramOnDoubleTapListener);
  }
  
  static interface GestureDetectorCompatImpl {
    boolean isLongpressEnabled();
    
    boolean onTouchEvent(MotionEvent param1MotionEvent);
    
    void setIsLongpressEnabled(boolean param1Boolean);
    
    void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener param1OnDoubleTapListener);
  }
  
  static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {
    private static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
    
    private static final int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
    
    private static final int LONG_PRESS = 2;
    
    private static final int SHOW_PRESS = 1;
    
    private static final int TAP = 3;
    
    private static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
    
    private boolean mAlwaysInBiggerTapRegion;
    
    private boolean mAlwaysInTapRegion;
    
    MotionEvent mCurrentDownEvent;
    
    boolean mDeferConfirmSingleTap;
    
    GestureDetector.OnDoubleTapListener mDoubleTapListener;
    
    private int mDoubleTapSlopSquare;
    
    private float mDownFocusX;
    
    private float mDownFocusY;
    
    private final Handler mHandler;
    
    private boolean mInLongPress;
    
    private boolean mIsDoubleTapping;
    
    private boolean mIsLongpressEnabled;
    
    private float mLastFocusX;
    
    private float mLastFocusY;
    
    final GestureDetector.OnGestureListener mListener;
    
    private int mMaximumFlingVelocity;
    
    private int mMinimumFlingVelocity;
    
    private MotionEvent mPreviousUpEvent;
    
    boolean mStillDown;
    
    private int mTouchSlopSquare;
    
    private VelocityTracker mVelocityTracker;
    
    static {
    
    }
    
    GestureDetectorCompatImplBase(Context param1Context, GestureDetector.OnGestureListener param1OnGestureListener, Handler param1Handler) {
      if (param1Handler != null) {
        this.mHandler = new GestureHandler(param1Handler);
      } else {
        this.mHandler = new GestureHandler();
      } 
      this.mListener = param1OnGestureListener;
      if (param1OnGestureListener instanceof GestureDetector.OnDoubleTapListener)
        setOnDoubleTapListener((GestureDetector.OnDoubleTapListener)param1OnGestureListener); 
      init(param1Context);
    }
    
    private void cancel() {
      this.mHandler.removeMessages(1);
      this.mHandler.removeMessages(2);
      this.mHandler.removeMessages(3);
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
      this.mIsDoubleTapping = false;
      this.mStillDown = false;
      this.mAlwaysInTapRegion = false;
      this.mAlwaysInBiggerTapRegion = false;
      this.mDeferConfirmSingleTap = false;
      if (this.mInLongPress)
        this.mInLongPress = false; 
    }
    
    private void cancelTaps() {
      this.mHandler.removeMessages(1);
      this.mHandler.removeMessages(2);
      this.mHandler.removeMessages(3);
      this.mIsDoubleTapping = false;
      this.mAlwaysInTapRegion = false;
      this.mAlwaysInBiggerTapRegion = false;
      this.mDeferConfirmSingleTap = false;
      if (this.mInLongPress)
        this.mInLongPress = false; 
    }
    
    private void init(Context param1Context) {
      if (param1Context != null) {
        if (this.mListener != null) {
          this.mIsLongpressEnabled = true;
          ViewConfiguration viewConfiguration = ViewConfiguration.get(param1Context);
          int i = viewConfiguration.getScaledTouchSlop();
          int j = viewConfiguration.getScaledDoubleTapSlop();
          this.mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
          this.mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
          this.mTouchSlopSquare = i * i;
          this.mDoubleTapSlopSquare = j * j;
          return;
        } 
        throw new IllegalArgumentException("OnGestureListener must not be null");
      } 
      throw new IllegalArgumentException("Context must not be null");
    }
    
    private boolean isConsideredDoubleTap(MotionEvent param1MotionEvent1, MotionEvent param1MotionEvent2, MotionEvent param1MotionEvent3) {
      boolean bool = this.mAlwaysInBiggerTapRegion;
      boolean bool1 = false;
      if (!bool)
        return false; 
      if (param1MotionEvent3.getEventTime() - param1MotionEvent2.getEventTime() > DOUBLE_TAP_TIMEOUT)
        return false; 
      int i = (int)param1MotionEvent1.getX() - (int)param1MotionEvent3.getX();
      int j = (int)param1MotionEvent1.getY() - (int)param1MotionEvent3.getY();
      if (i * i + j * j < this.mDoubleTapSlopSquare)
        bool1 = true; 
      return bool1;
    }
    
    void dispatchLongPress() {
      this.mHandler.removeMessages(3);
      this.mDeferConfirmSingleTap = false;
      this.mInLongPress = true;
      this.mListener.onLongPress(this.mCurrentDownEvent);
    }
    
    public boolean isLongpressEnabled() {
      return this.mIsLongpressEnabled;
    }
    
    public boolean onTouchEvent(MotionEvent param1MotionEvent) {
      // Byte code:
      //   0: aload_1
      //   1: invokevirtual getAction : ()I
      //   4: istore_2
      //   5: aload_0
      //   6: getfield mVelocityTracker : Landroid/view/VelocityTracker;
      //   9: ifnonnull -> 19
      //   12: aload_0
      //   13: invokestatic obtain : ()Landroid/view/VelocityTracker;
      //   16: putfield mVelocityTracker : Landroid/view/VelocityTracker;
      //   19: aload_0
      //   20: getfield mVelocityTracker : Landroid/view/VelocityTracker;
      //   23: aload_1
      //   24: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
      //   27: iload_2
      //   28: sipush #255
      //   31: iand
      //   32: istore_3
      //   33: iconst_0
      //   34: istore #4
      //   36: iload_3
      //   37: bipush #6
      //   39: if_icmpne -> 47
      //   42: iconst_1
      //   43: istore_2
      //   44: goto -> 49
      //   47: iconst_0
      //   48: istore_2
      //   49: iload_2
      //   50: ifeq -> 62
      //   53: aload_1
      //   54: invokevirtual getActionIndex : ()I
      //   57: istore #5
      //   59: goto -> 65
      //   62: iconst_m1
      //   63: istore #5
      //   65: aload_1
      //   66: invokevirtual getPointerCount : ()I
      //   69: istore #6
      //   71: iconst_0
      //   72: istore #7
      //   74: fconst_0
      //   75: fstore #8
      //   77: fconst_0
      //   78: fstore #9
      //   80: iload #7
      //   82: iload #6
      //   84: if_icmpge -> 125
      //   87: iload #5
      //   89: iload #7
      //   91: if_icmpne -> 97
      //   94: goto -> 119
      //   97: fload #8
      //   99: aload_1
      //   100: iload #7
      //   102: invokevirtual getX : (I)F
      //   105: fadd
      //   106: fstore #8
      //   108: fload #9
      //   110: aload_1
      //   111: iload #7
      //   113: invokevirtual getY : (I)F
      //   116: fadd
      //   117: fstore #9
      //   119: iinc #7, 1
      //   122: goto -> 80
      //   125: iload_2
      //   126: ifeq -> 137
      //   129: iload #6
      //   131: iconst_1
      //   132: isub
      //   133: istore_2
      //   134: goto -> 140
      //   137: iload #6
      //   139: istore_2
      //   140: iload_2
      //   141: i2f
      //   142: fstore #10
      //   144: fload #8
      //   146: fload #10
      //   148: fdiv
      //   149: fstore #8
      //   151: fload #9
      //   153: fload #10
      //   155: fdiv
      //   156: fstore #9
      //   158: iload_3
      //   159: tableswitch default -> 200, 0 -> 916, 1 -> 645, 2 -> 403, 3 -> 392, 4 -> 200, 5 -> 357, 6 -> 207
      //   200: iload #4
      //   202: istore #11
      //   204: goto -> 1184
      //   207: aload_0
      //   208: fload #8
      //   210: putfield mLastFocusX : F
      //   213: aload_0
      //   214: fload #8
      //   216: putfield mDownFocusX : F
      //   219: aload_0
      //   220: fload #9
      //   222: putfield mLastFocusY : F
      //   225: aload_0
      //   226: fload #9
      //   228: putfield mDownFocusY : F
      //   231: aload_0
      //   232: getfield mVelocityTracker : Landroid/view/VelocityTracker;
      //   235: sipush #1000
      //   238: aload_0
      //   239: getfield mMaximumFlingVelocity : I
      //   242: i2f
      //   243: invokevirtual computeCurrentVelocity : (IF)V
      //   246: aload_1
      //   247: invokevirtual getActionIndex : ()I
      //   250: istore #5
      //   252: aload_1
      //   253: iload #5
      //   255: invokevirtual getPointerId : (I)I
      //   258: istore_2
      //   259: aload_0
      //   260: getfield mVelocityTracker : Landroid/view/VelocityTracker;
      //   263: iload_2
      //   264: invokevirtual getXVelocity : (I)F
      //   267: fstore #9
      //   269: aload_0
      //   270: getfield mVelocityTracker : Landroid/view/VelocityTracker;
      //   273: iload_2
      //   274: invokevirtual getYVelocity : (I)F
      //   277: fstore #8
      //   279: iconst_0
      //   280: istore_2
      //   281: iload #4
      //   283: istore #11
      //   285: iload_2
      //   286: iload #6
      //   288: if_icmpge -> 1184
      //   291: iload_2
      //   292: iload #5
      //   294: if_icmpne -> 300
      //   297: goto -> 351
      //   300: aload_1
      //   301: iload_2
      //   302: invokevirtual getPointerId : (I)I
      //   305: istore #7
      //   307: aload_0
      //   308: getfield mVelocityTracker : Landroid/view/VelocityTracker;
      //   311: iload #7
      //   313: invokevirtual getXVelocity : (I)F
      //   316: fload #9
      //   318: fmul
      //   319: aload_0
      //   320: getfield mVelocityTracker : Landroid/view/VelocityTracker;
      //   323: iload #7
      //   325: invokevirtual getYVelocity : (I)F
      //   328: fload #8
      //   330: fmul
      //   331: fadd
      //   332: fconst_0
      //   333: fcmpg
      //   334: ifge -> 351
      //   337: aload_0
      //   338: getfield mVelocityTracker : Landroid/view/VelocityTracker;
      //   341: invokevirtual clear : ()V
      //   344: iload #4
      //   346: istore #11
      //   348: goto -> 1184
      //   351: iinc #2, 1
      //   354: goto -> 281
      //   357: aload_0
      //   358: fload #8
      //   360: putfield mLastFocusX : F
      //   363: aload_0
      //   364: fload #8
      //   366: putfield mDownFocusX : F
      //   369: aload_0
      //   370: fload #9
      //   372: putfield mLastFocusY : F
      //   375: aload_0
      //   376: fload #9
      //   378: putfield mDownFocusY : F
      //   381: aload_0
      //   382: invokespecial cancelTaps : ()V
      //   385: iload #4
      //   387: istore #11
      //   389: goto -> 1184
      //   392: aload_0
      //   393: invokespecial cancel : ()V
      //   396: iload #4
      //   398: istore #11
      //   400: goto -> 1184
      //   403: aload_0
      //   404: getfield mInLongPress : Z
      //   407: ifeq -> 417
      //   410: iload #4
      //   412: istore #11
      //   414: goto -> 1184
      //   417: aload_0
      //   418: getfield mLastFocusX : F
      //   421: fload #8
      //   423: fsub
      //   424: fstore #10
      //   426: aload_0
      //   427: getfield mLastFocusY : F
      //   430: fload #9
      //   432: fsub
      //   433: fstore #12
      //   435: aload_0
      //   436: getfield mIsDoubleTapping : Z
      //   439: ifeq -> 459
      //   442: iconst_0
      //   443: aload_0
      //   444: getfield mDoubleTapListener : Landroid/view/GestureDetector$OnDoubleTapListener;
      //   447: aload_1
      //   448: invokeinterface onDoubleTapEvent : (Landroid/view/MotionEvent;)Z
      //   453: ior
      //   454: istore #11
      //   456: goto -> 1184
      //   459: aload_0
      //   460: getfield mAlwaysInTapRegion : Z
      //   463: ifeq -> 586
      //   466: fload #8
      //   468: aload_0
      //   469: getfield mDownFocusX : F
      //   472: fsub
      //   473: f2i
      //   474: istore_2
      //   475: fload #9
      //   477: aload_0
      //   478: getfield mDownFocusY : F
      //   481: fsub
      //   482: f2i
      //   483: istore #5
      //   485: iload_2
      //   486: iload_2
      //   487: imul
      //   488: iload #5
      //   490: iload #5
      //   492: imul
      //   493: iadd
      //   494: istore_2
      //   495: iload_2
      //   496: aload_0
      //   497: getfield mTouchSlopSquare : I
      //   500: if_icmple -> 567
      //   503: aload_0
      //   504: getfield mListener : Landroid/view/GestureDetector$OnGestureListener;
      //   507: aload_0
      //   508: getfield mCurrentDownEvent : Landroid/view/MotionEvent;
      //   511: aload_1
      //   512: fload #10
      //   514: fload #12
      //   516: invokeinterface onScroll : (Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
      //   521: istore #11
      //   523: aload_0
      //   524: fload #8
      //   526: putfield mLastFocusX : F
      //   529: aload_0
      //   530: fload #9
      //   532: putfield mLastFocusY : F
      //   535: aload_0
      //   536: iconst_0
      //   537: putfield mAlwaysInTapRegion : Z
      //   540: aload_0
      //   541: getfield mHandler : Landroid/os/Handler;
      //   544: iconst_3
      //   545: invokevirtual removeMessages : (I)V
      //   548: aload_0
      //   549: getfield mHandler : Landroid/os/Handler;
      //   552: iconst_1
      //   553: invokevirtual removeMessages : (I)V
      //   556: aload_0
      //   557: getfield mHandler : Landroid/os/Handler;
      //   560: iconst_2
      //   561: invokevirtual removeMessages : (I)V
      //   564: goto -> 570
      //   567: iconst_0
      //   568: istore #11
      //   570: iload_2
      //   571: aload_0
      //   572: getfield mTouchSlopSquare : I
      //   575: if_icmple -> 583
      //   578: aload_0
      //   579: iconst_0
      //   580: putfield mAlwaysInBiggerTapRegion : Z
      //   583: goto -> 1184
      //   586: fload #10
      //   588: invokestatic abs : (F)F
      //   591: fconst_1
      //   592: fcmpl
      //   593: ifge -> 610
      //   596: iload #4
      //   598: istore #11
      //   600: fload #12
      //   602: invokestatic abs : (F)F
      //   605: fconst_1
      //   606: fcmpl
      //   607: iflt -> 1184
      //   610: aload_0
      //   611: getfield mListener : Landroid/view/GestureDetector$OnGestureListener;
      //   614: aload_0
      //   615: getfield mCurrentDownEvent : Landroid/view/MotionEvent;
      //   618: aload_1
      //   619: fload #10
      //   621: fload #12
      //   623: invokeinterface onScroll : (Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
      //   628: istore #11
      //   630: aload_0
      //   631: fload #8
      //   633: putfield mLastFocusX : F
      //   636: aload_0
      //   637: fload #9
      //   639: putfield mLastFocusY : F
      //   642: goto -> 1184
      //   645: aload_0
      //   646: iconst_0
      //   647: putfield mStillDown : Z
      //   650: aload_1
      //   651: invokestatic obtain : (Landroid/view/MotionEvent;)Landroid/view/MotionEvent;
      //   654: astore #13
      //   656: aload_0
      //   657: getfield mIsDoubleTapping : Z
      //   660: ifeq -> 680
      //   663: aload_0
      //   664: getfield mDoubleTapListener : Landroid/view/GestureDetector$OnDoubleTapListener;
      //   667: aload_1
      //   668: invokeinterface onDoubleTapEvent : (Landroid/view/MotionEvent;)Z
      //   673: iconst_0
      //   674: ior
      //   675: istore #11
      //   677: goto -> 850
      //   680: aload_0
      //   681: getfield mInLongPress : Z
      //   684: ifeq -> 703
      //   687: aload_0
      //   688: getfield mHandler : Landroid/os/Handler;
      //   691: iconst_3
      //   692: invokevirtual removeMessages : (I)V
      //   695: aload_0
      //   696: iconst_0
      //   697: putfield mInLongPress : Z
      //   700: goto -> 824
      //   703: aload_0
      //   704: getfield mAlwaysInTapRegion : Z
      //   707: ifeq -> 752
      //   710: aload_0
      //   711: getfield mListener : Landroid/view/GestureDetector$OnGestureListener;
      //   714: aload_1
      //   715: invokeinterface onSingleTapUp : (Landroid/view/MotionEvent;)Z
      //   720: istore #11
      //   722: aload_0
      //   723: getfield mDeferConfirmSingleTap : Z
      //   726: ifeq -> 749
      //   729: aload_0
      //   730: getfield mDoubleTapListener : Landroid/view/GestureDetector$OnDoubleTapListener;
      //   733: astore #14
      //   735: aload #14
      //   737: ifnull -> 749
      //   740: aload #14
      //   742: aload_1
      //   743: invokeinterface onSingleTapConfirmed : (Landroid/view/MotionEvent;)Z
      //   748: pop
      //   749: goto -> 850
      //   752: aload_0
      //   753: getfield mVelocityTracker : Landroid/view/VelocityTracker;
      //   756: astore #14
      //   758: aload_1
      //   759: iconst_0
      //   760: invokevirtual getPointerId : (I)I
      //   763: istore_2
      //   764: aload #14
      //   766: sipush #1000
      //   769: aload_0
      //   770: getfield mMaximumFlingVelocity : I
      //   773: i2f
      //   774: invokevirtual computeCurrentVelocity : (IF)V
      //   777: aload #14
      //   779: iload_2
      //   780: invokevirtual getYVelocity : (I)F
      //   783: fstore #9
      //   785: aload #14
      //   787: iload_2
      //   788: invokevirtual getXVelocity : (I)F
      //   791: fstore #8
      //   793: fload #9
      //   795: invokestatic abs : (F)F
      //   798: aload_0
      //   799: getfield mMinimumFlingVelocity : I
      //   802: i2f
      //   803: fcmpl
      //   804: ifgt -> 830
      //   807: fload #8
      //   809: invokestatic abs : (F)F
      //   812: aload_0
      //   813: getfield mMinimumFlingVelocity : I
      //   816: i2f
      //   817: fcmpl
      //   818: ifle -> 824
      //   821: goto -> 830
      //   824: iconst_0
      //   825: istore #11
      //   827: goto -> 850
      //   830: aload_0
      //   831: getfield mListener : Landroid/view/GestureDetector$OnGestureListener;
      //   834: aload_0
      //   835: getfield mCurrentDownEvent : Landroid/view/MotionEvent;
      //   838: aload_1
      //   839: fload #8
      //   841: fload #9
      //   843: invokeinterface onFling : (Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
      //   848: istore #11
      //   850: aload_0
      //   851: getfield mPreviousUpEvent : Landroid/view/MotionEvent;
      //   854: astore_1
      //   855: aload_1
      //   856: ifnull -> 863
      //   859: aload_1
      //   860: invokevirtual recycle : ()V
      //   863: aload_0
      //   864: aload #13
      //   866: putfield mPreviousUpEvent : Landroid/view/MotionEvent;
      //   869: aload_0
      //   870: getfield mVelocityTracker : Landroid/view/VelocityTracker;
      //   873: astore_1
      //   874: aload_1
      //   875: ifnull -> 887
      //   878: aload_1
      //   879: invokevirtual recycle : ()V
      //   882: aload_0
      //   883: aconst_null
      //   884: putfield mVelocityTracker : Landroid/view/VelocityTracker;
      //   887: aload_0
      //   888: iconst_0
      //   889: putfield mIsDoubleTapping : Z
      //   892: aload_0
      //   893: iconst_0
      //   894: putfield mDeferConfirmSingleTap : Z
      //   897: aload_0
      //   898: getfield mHandler : Landroid/os/Handler;
      //   901: iconst_1
      //   902: invokevirtual removeMessages : (I)V
      //   905: aload_0
      //   906: getfield mHandler : Landroid/os/Handler;
      //   909: iconst_2
      //   910: invokevirtual removeMessages : (I)V
      //   913: goto -> 1184
      //   916: aload_0
      //   917: getfield mDoubleTapListener : Landroid/view/GestureDetector$OnDoubleTapListener;
      //   920: ifnull -> 1033
      //   923: aload_0
      //   924: getfield mHandler : Landroid/os/Handler;
      //   927: iconst_3
      //   928: invokevirtual hasMessages : (I)Z
      //   931: istore #11
      //   933: iload #11
      //   935: ifeq -> 946
      //   938: aload_0
      //   939: getfield mHandler : Landroid/os/Handler;
      //   942: iconst_3
      //   943: invokevirtual removeMessages : (I)V
      //   946: aload_0
      //   947: getfield mCurrentDownEvent : Landroid/view/MotionEvent;
      //   950: astore #13
      //   952: aload #13
      //   954: ifnull -> 1020
      //   957: aload_0
      //   958: getfield mPreviousUpEvent : Landroid/view/MotionEvent;
      //   961: astore #14
      //   963: aload #14
      //   965: ifnull -> 1020
      //   968: iload #11
      //   970: ifeq -> 1020
      //   973: aload_0
      //   974: aload #13
      //   976: aload #14
      //   978: aload_1
      //   979: invokespecial isConsideredDoubleTap : (Landroid/view/MotionEvent;Landroid/view/MotionEvent;Landroid/view/MotionEvent;)Z
      //   982: ifeq -> 1020
      //   985: aload_0
      //   986: iconst_1
      //   987: putfield mIsDoubleTapping : Z
      //   990: aload_0
      //   991: getfield mDoubleTapListener : Landroid/view/GestureDetector$OnDoubleTapListener;
      //   994: aload_0
      //   995: getfield mCurrentDownEvent : Landroid/view/MotionEvent;
      //   998: invokeinterface onDoubleTap : (Landroid/view/MotionEvent;)Z
      //   1003: iconst_0
      //   1004: ior
      //   1005: aload_0
      //   1006: getfield mDoubleTapListener : Landroid/view/GestureDetector$OnDoubleTapListener;
      //   1009: aload_1
      //   1010: invokeinterface onDoubleTapEvent : (Landroid/view/MotionEvent;)Z
      //   1015: ior
      //   1016: istore_2
      //   1017: goto -> 1035
      //   1020: aload_0
      //   1021: getfield mHandler : Landroid/os/Handler;
      //   1024: iconst_3
      //   1025: getstatic android/support/v4/view/GestureDetectorCompat$GestureDetectorCompatImplBase.DOUBLE_TAP_TIMEOUT : I
      //   1028: i2l
      //   1029: invokevirtual sendEmptyMessageDelayed : (IJ)Z
      //   1032: pop
      //   1033: iconst_0
      //   1034: istore_2
      //   1035: aload_0
      //   1036: fload #8
      //   1038: putfield mLastFocusX : F
      //   1041: aload_0
      //   1042: fload #8
      //   1044: putfield mDownFocusX : F
      //   1047: aload_0
      //   1048: fload #9
      //   1050: putfield mLastFocusY : F
      //   1053: aload_0
      //   1054: fload #9
      //   1056: putfield mDownFocusY : F
      //   1059: aload_0
      //   1060: getfield mCurrentDownEvent : Landroid/view/MotionEvent;
      //   1063: astore #13
      //   1065: aload #13
      //   1067: ifnull -> 1075
      //   1070: aload #13
      //   1072: invokevirtual recycle : ()V
      //   1075: aload_0
      //   1076: aload_1
      //   1077: invokestatic obtain : (Landroid/view/MotionEvent;)Landroid/view/MotionEvent;
      //   1080: putfield mCurrentDownEvent : Landroid/view/MotionEvent;
      //   1083: aload_0
      //   1084: iconst_1
      //   1085: putfield mAlwaysInTapRegion : Z
      //   1088: aload_0
      //   1089: iconst_1
      //   1090: putfield mAlwaysInBiggerTapRegion : Z
      //   1093: aload_0
      //   1094: iconst_1
      //   1095: putfield mStillDown : Z
      //   1098: aload_0
      //   1099: iconst_0
      //   1100: putfield mInLongPress : Z
      //   1103: aload_0
      //   1104: iconst_0
      //   1105: putfield mDeferConfirmSingleTap : Z
      //   1108: aload_0
      //   1109: getfield mIsLongpressEnabled : Z
      //   1112: ifeq -> 1149
      //   1115: aload_0
      //   1116: getfield mHandler : Landroid/os/Handler;
      //   1119: iconst_2
      //   1120: invokevirtual removeMessages : (I)V
      //   1123: aload_0
      //   1124: getfield mHandler : Landroid/os/Handler;
      //   1127: iconst_2
      //   1128: aload_0
      //   1129: getfield mCurrentDownEvent : Landroid/view/MotionEvent;
      //   1132: invokevirtual getDownTime : ()J
      //   1135: getstatic android/support/v4/view/GestureDetectorCompat$GestureDetectorCompatImplBase.TAP_TIMEOUT : I
      //   1138: i2l
      //   1139: ladd
      //   1140: getstatic android/support/v4/view/GestureDetectorCompat$GestureDetectorCompatImplBase.LONGPRESS_TIMEOUT : I
      //   1143: i2l
      //   1144: ladd
      //   1145: invokevirtual sendEmptyMessageAtTime : (IJ)Z
      //   1148: pop
      //   1149: aload_0
      //   1150: getfield mHandler : Landroid/os/Handler;
      //   1153: iconst_1
      //   1154: aload_0
      //   1155: getfield mCurrentDownEvent : Landroid/view/MotionEvent;
      //   1158: invokevirtual getDownTime : ()J
      //   1161: getstatic android/support/v4/view/GestureDetectorCompat$GestureDetectorCompatImplBase.TAP_TIMEOUT : I
      //   1164: i2l
      //   1165: ladd
      //   1166: invokevirtual sendEmptyMessageAtTime : (IJ)Z
      //   1169: pop
      //   1170: iload_2
      //   1171: aload_0
      //   1172: getfield mListener : Landroid/view/GestureDetector$OnGestureListener;
      //   1175: aload_1
      //   1176: invokeinterface onDown : (Landroid/view/MotionEvent;)Z
      //   1181: ior
      //   1182: istore #11
      //   1184: iload #11
      //   1186: ireturn
    }
    
    public void setIsLongpressEnabled(boolean param1Boolean) {
      this.mIsLongpressEnabled = param1Boolean;
    }
    
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener param1OnDoubleTapListener) {
      this.mDoubleTapListener = param1OnDoubleTapListener;
    }
    
    private class GestureHandler extends Handler {
      GestureHandler() {}
      
      GestureHandler(Handler param2Handler) {
        super(param2Handler.getLooper());
      }
      
      public void handleMessage(Message param2Message) {
        StringBuilder stringBuilder;
        switch (param2Message.what) {
          default:
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown message ");
            stringBuilder.append(param2Message);
            throw new RuntimeException(stringBuilder.toString());
          case 3:
            if (GestureDetectorCompat.GestureDetectorCompatImplBase.this.mDoubleTapListener != null)
              if (!GestureDetectorCompat.GestureDetectorCompatImplBase.this.mStillDown) {
                GestureDetectorCompat.GestureDetectorCompatImplBase.this.mDoubleTapListener.onSingleTapConfirmed(GestureDetectorCompat.GestureDetectorCompatImplBase.this.mCurrentDownEvent);
              } else {
                GestureDetectorCompat.GestureDetectorCompatImplBase.this.mDeferConfirmSingleTap = true;
              }  
            return;
          case 2:
            GestureDetectorCompat.GestureDetectorCompatImplBase.this.dispatchLongPress();
            return;
          case 1:
            break;
        } 
        GestureDetectorCompat.GestureDetectorCompatImplBase.this.mListener.onShowPress(GestureDetectorCompat.GestureDetectorCompatImplBase.this.mCurrentDownEvent);
      }
    }
  }
  
  private class GestureHandler extends Handler {
    GestureHandler() {}
    
    GestureHandler(Handler param1Handler) {
      super(param1Handler.getLooper());
    }
    
    public void handleMessage(Message param1Message) {
      StringBuilder stringBuilder;
      switch (param1Message.what) {
        default:
          stringBuilder = new StringBuilder();
          stringBuilder.append("Unknown message ");
          stringBuilder.append(param1Message);
          throw new RuntimeException(stringBuilder.toString());
        case 3:
          if (this.this$0.mDoubleTapListener != null)
            if (!this.this$0.mStillDown) {
              this.this$0.mDoubleTapListener.onSingleTapConfirmed(this.this$0.mCurrentDownEvent);
            } else {
              this.this$0.mDeferConfirmSingleTap = true;
            }  
          return;
        case 2:
          this.this$0.dispatchLongPress();
          return;
        case 1:
          break;
      } 
      this.this$0.mListener.onShowPress(this.this$0.mCurrentDownEvent);
    }
  }
  
  static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {
    private final GestureDetector mDetector;
    
    GestureDetectorCompatImplJellybeanMr2(Context param1Context, GestureDetector.OnGestureListener param1OnGestureListener, Handler param1Handler) {
      this.mDetector = new GestureDetector(param1Context, param1OnGestureListener, param1Handler);
    }
    
    public boolean isLongpressEnabled() {
      return this.mDetector.isLongpressEnabled();
    }
    
    public boolean onTouchEvent(MotionEvent param1MotionEvent) {
      return this.mDetector.onTouchEvent(param1MotionEvent);
    }
    
    public void setIsLongpressEnabled(boolean param1Boolean) {
      this.mDetector.setIsLongpressEnabled(param1Boolean);
    }
    
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener param1OnDoubleTapListener) {
      this.mDetector.setOnDoubleTapListener(param1OnDoubleTapListener);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\v4\view\GestureDetectorCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */