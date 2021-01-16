package android.support.constraint.solver.widgets;

import java.util.ArrayList;

public class ChainHead {
  private boolean mDefined;
  
  protected ConstraintWidget mFirst;
  
  protected ConstraintWidget mFirstMatchConstraintWidget;
  
  protected ConstraintWidget mFirstVisibleWidget;
  
  protected boolean mHasComplexMatchWeights;
  
  protected boolean mHasDefinedWeights;
  
  protected boolean mHasUndefinedWeights;
  
  protected ConstraintWidget mHead;
  
  private boolean mIsRtl = false;
  
  protected ConstraintWidget mLast;
  
  protected ConstraintWidget mLastMatchConstraintWidget;
  
  protected ConstraintWidget mLastVisibleWidget;
  
  private int mOrientation;
  
  protected float mTotalWeight = 0.0F;
  
  protected ArrayList<ConstraintWidget> mWeightedMatchConstraintsWidgets;
  
  protected int mWidgetsCount;
  
  protected int mWidgetsMatchCount;
  
  public ChainHead(ConstraintWidget paramConstraintWidget, int paramInt, boolean paramBoolean) {
    this.mFirst = paramConstraintWidget;
    this.mOrientation = paramInt;
    this.mIsRtl = paramBoolean;
  }
  
  private void defineChainProperties() {
    int i = this.mOrientation * 2;
    ConstraintWidget constraintWidget = this.mFirst;
    boolean bool1 = false;
    boolean bool2;
    for (bool2 = false; !bool2; bool2 = true) {
      ConstraintWidget constraintWidget1;
      this.mWidgetsCount++;
      ConstraintWidget[] arrayOfConstraintWidget1 = constraintWidget.mListNextVisibleWidget;
      int j = this.mOrientation;
      ConstraintWidget[] arrayOfConstraintWidget2 = null;
      arrayOfConstraintWidget1[j] = null;
      constraintWidget.mListNextMatchConstraintsWidget[this.mOrientation] = null;
      if (constraintWidget.getVisibility() != 8) {
        if (this.mFirstVisibleWidget == null)
          this.mFirstVisibleWidget = constraintWidget; 
        constraintWidget1 = this.mLastVisibleWidget;
        if (constraintWidget1 != null)
          constraintWidget1.mListNextVisibleWidget[this.mOrientation] = constraintWidget; 
        this.mLastVisibleWidget = constraintWidget;
        if (constraintWidget.mListDimensionBehaviors[this.mOrientation] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (constraintWidget.mResolvedMatchConstraintDefault[this.mOrientation] == 0 || constraintWidget.mResolvedMatchConstraintDefault[this.mOrientation] == 3 || constraintWidget.mResolvedMatchConstraintDefault[this.mOrientation] == 2)) {
          this.mWidgetsMatchCount++;
          float f = constraintWidget.mWeight[this.mOrientation];
          if (f > 0.0F)
            this.mTotalWeight += constraintWidget.mWeight[this.mOrientation]; 
          if (isMatchConstraintEqualityCandidate(constraintWidget, this.mOrientation)) {
            if (f < 0.0F) {
              this.mHasUndefinedWeights = true;
            } else {
              this.mHasDefinedWeights = true;
            } 
            if (this.mWeightedMatchConstraintsWidgets == null)
              this.mWeightedMatchConstraintsWidgets = new ArrayList<ConstraintWidget>(); 
            this.mWeightedMatchConstraintsWidgets.add(constraintWidget);
          } 
          if (this.mFirstMatchConstraintWidget == null)
            this.mFirstMatchConstraintWidget = constraintWidget; 
          constraintWidget1 = this.mLastMatchConstraintWidget;
          if (constraintWidget1 != null)
            constraintWidget1.mListNextMatchConstraintsWidget[this.mOrientation] = constraintWidget; 
          this.mLastMatchConstraintWidget = constraintWidget;
        } 
      } 
      ConstraintAnchor constraintAnchor = (constraintWidget.mListAnchors[i + 1]).mTarget;
      arrayOfConstraintWidget1 = arrayOfConstraintWidget2;
      if (constraintAnchor != null) {
        ConstraintWidget constraintWidget2 = constraintAnchor.mOwner;
        arrayOfConstraintWidget1 = arrayOfConstraintWidget2;
        if ((constraintWidget2.mListAnchors[i]).mTarget != null)
          if ((constraintWidget2.mListAnchors[i]).mTarget.mOwner != constraintWidget) {
            arrayOfConstraintWidget1 = arrayOfConstraintWidget2;
          } else {
            constraintWidget1 = constraintWidget2;
          }  
      } 
      if (constraintWidget1 != null) {
        constraintWidget = constraintWidget1;
        continue;
      } 
    } 
    this.mLast = constraintWidget;
    if (this.mOrientation == 0 && this.mIsRtl) {
      this.mHead = this.mLast;
    } else {
      this.mHead = this.mFirst;
    } 
    boolean bool3 = bool1;
    if (this.mHasDefinedWeights) {
      bool3 = bool1;
      if (this.mHasUndefinedWeights)
        bool3 = true; 
    } 
    this.mHasComplexMatchWeights = bool3;
  }
  
  private static boolean isMatchConstraintEqualityCandidate(ConstraintWidget paramConstraintWidget, int paramInt) {
    boolean bool;
    if (paramConstraintWidget.getVisibility() != 8 && paramConstraintWidget.mListDimensionBehaviors[paramInt] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (paramConstraintWidget.mResolvedMatchConstraintDefault[paramInt] == 0 || paramConstraintWidget.mResolvedMatchConstraintDefault[paramInt] == 3)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void define() {
    if (!this.mDefined)
      defineChainProperties(); 
    this.mDefined = true;
  }
  
  public ConstraintWidget getFirst() {
    return this.mFirst;
  }
  
  public ConstraintWidget getFirstMatchConstraintWidget() {
    return this.mFirstMatchConstraintWidget;
  }
  
  public ConstraintWidget getFirstVisibleWidget() {
    return this.mFirstVisibleWidget;
  }
  
  public ConstraintWidget getHead() {
    return this.mHead;
  }
  
  public ConstraintWidget getLast() {
    return this.mLast;
  }
  
  public ConstraintWidget getLastMatchConstraintWidget() {
    return this.mLastMatchConstraintWidget;
  }
  
  public ConstraintWidget getLastVisibleWidget() {
    return this.mLastVisibleWidget;
  }
  
  public float getTotalWeight() {
    return this.mTotalWeight;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\constraint\solver\widgets\ChainHead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */