package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.Metrics;
import android.support.constraint.solver.SolverVariable;
import java.util.ArrayList;

public class Barrier extends Helper {
  public static final int BOTTOM = 3;
  
  public static final int LEFT = 0;
  
  public static final int RIGHT = 1;
  
  public static final int TOP = 2;
  
  private boolean mAllowsGoneWidget = true;
  
  private int mBarrierType = 0;
  
  private ArrayList<ResolutionAnchor> mNodes = new ArrayList<ResolutionAnchor>(4);
  
  public void addToSolver(LinearSystem paramLinearSystem) {
    this.mListAnchors[0] = this.mLeft;
    this.mListAnchors[2] = this.mTop;
    this.mListAnchors[1] = this.mRight;
    this.mListAnchors[3] = this.mBottom;
    int i;
    for (i = 0; i < this.mListAnchors.length; i++)
      (this.mListAnchors[i]).mSolverVariable = paramLinearSystem.createObjectVariable(this.mListAnchors[i]); 
    i = this.mBarrierType;
    if (i >= 0 && i < 4) {
      boolean bool;
      ConstraintAnchor constraintAnchor = this.mListAnchors[this.mBarrierType];
      i = 0;
      while (true) {
        if (i < this.mWidgetsCount) {
          ConstraintWidget constraintWidget = this.mWidgets[i];
          if (this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) {
            int j = this.mBarrierType;
            if ((j == 0 || j == 1) && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
              boolean bool1 = true;
              break;
            } 
            j = this.mBarrierType;
            if ((j == 2 || j == 3) && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
              boolean bool1 = true;
              break;
            } 
          } 
          i++;
          continue;
        } 
        bool = false;
        break;
      } 
      i = this.mBarrierType;
      if (i == 0 || i == 1) {
        if (getParent().getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
          bool = false; 
      } else if (getParent().getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
        bool = false;
      } 
      for (i = 0; i < this.mWidgetsCount; i++) {
        ConstraintWidget constraintWidget = this.mWidgets[i];
        if (this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) {
          SolverVariable solverVariable = paramLinearSystem.createObjectVariable(constraintWidget.mListAnchors[this.mBarrierType]);
          ConstraintAnchor[] arrayOfConstraintAnchor = constraintWidget.mListAnchors;
          int j = this.mBarrierType;
          (arrayOfConstraintAnchor[j]).mSolverVariable = solverVariable;
          if (j == 0 || j == 2) {
            paramLinearSystem.addLowerBarrier(constraintAnchor.mSolverVariable, solverVariable, bool);
          } else {
            paramLinearSystem.addGreaterBarrier(constraintAnchor.mSolverVariable, solverVariable, bool);
          } 
        } 
      } 
      i = this.mBarrierType;
      if (i == 0) {
        paramLinearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 6);
        if (!bool)
          paramLinearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 5); 
      } else if (i == 1) {
        paramLinearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 6);
        if (!bool)
          paramLinearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 5); 
      } else if (i == 2) {
        paramLinearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 6);
        if (!bool)
          paramLinearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 5); 
      } else if (i == 3) {
        paramLinearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 6);
        if (!bool)
          paramLinearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 5); 
      } 
      return;
    } 
  }
  
  public boolean allowedInBarrier() {
    return true;
  }
  
  public void analyze(int paramInt) {
    ResolutionAnchor resolutionAnchor;
    if (this.mParent == null)
      return; 
    if (!((ConstraintWidgetContainer)this.mParent).optimizeFor(2))
      return; 
    switch (this.mBarrierType) {
      default:
        return;
      case 3:
        resolutionAnchor = this.mBottom.getResolutionNode();
        break;
      case 2:
        resolutionAnchor = this.mTop.getResolutionNode();
        break;
      case 1:
        resolutionAnchor = this.mRight.getResolutionNode();
        break;
      case 0:
        resolutionAnchor = this.mLeft.getResolutionNode();
        break;
    } 
    resolutionAnchor.setType(5);
    paramInt = this.mBarrierType;
    if (paramInt == 0 || paramInt == 1) {
      this.mTop.getResolutionNode().resolve((ResolutionAnchor)null, 0.0F);
      this.mBottom.getResolutionNode().resolve((ResolutionAnchor)null, 0.0F);
    } else {
      this.mLeft.getResolutionNode().resolve((ResolutionAnchor)null, 0.0F);
      this.mRight.getResolutionNode().resolve((ResolutionAnchor)null, 0.0F);
    } 
    this.mNodes.clear();
    for (paramInt = 0; paramInt < this.mWidgetsCount; paramInt++) {
      ConstraintWidget constraintWidget = this.mWidgets[paramInt];
      if (this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) {
        ResolutionAnchor resolutionAnchor1;
        switch (this.mBarrierType) {
          default:
            constraintWidget = null;
            break;
          case 3:
            resolutionAnchor1 = constraintWidget.mBottom.getResolutionNode();
            break;
          case 2:
            resolutionAnchor1 = ((ConstraintWidget)resolutionAnchor1).mTop.getResolutionNode();
            break;
          case 1:
            resolutionAnchor1 = ((ConstraintWidget)resolutionAnchor1).mRight.getResolutionNode();
            break;
          case 0:
            resolutionAnchor1 = ((ConstraintWidget)resolutionAnchor1).mLeft.getResolutionNode();
            break;
        } 
        if (resolutionAnchor1 != null) {
          this.mNodes.add(resolutionAnchor1);
          resolutionAnchor1.addDependent(resolutionAnchor);
        } 
      } 
    } 
  }
  
  public void resetResolutionNodes() {
    super.resetResolutionNodes();
    this.mNodes.clear();
  }
  
  public void resolve() {
    ResolutionAnchor resolutionAnchor1;
    int i = this.mBarrierType;
    float f1 = Float.MAX_VALUE;
    switch (i) {
      default:
        return;
      case 3:
        resolutionAnchor1 = this.mBottom.getResolutionNode();
        f1 = 0.0F;
        break;
      case 2:
        resolutionAnchor1 = this.mTop.getResolutionNode();
        break;
      case 1:
        resolutionAnchor1 = this.mRight.getResolutionNode();
        f1 = 0.0F;
        break;
      case 0:
        resolutionAnchor1 = this.mLeft.getResolutionNode();
        break;
    } 
    int j = this.mNodes.size();
    ResolutionAnchor resolutionAnchor2 = null;
    i = 0;
    float f2;
    for (f2 = f1; i < j; f2 = f1) {
      ResolutionAnchor resolutionAnchor = this.mNodes.get(i);
      if (resolutionAnchor.state != 1)
        return; 
      int k = this.mBarrierType;
      if (k == 0 || k == 2) {
        f1 = f2;
        if (resolutionAnchor.resolvedOffset < f2) {
          f1 = resolutionAnchor.resolvedOffset;
          resolutionAnchor2 = resolutionAnchor.resolvedTarget;
        } 
      } else {
        f1 = f2;
        if (resolutionAnchor.resolvedOffset > f2) {
          f1 = resolutionAnchor.resolvedOffset;
          resolutionAnchor2 = resolutionAnchor.resolvedTarget;
        } 
      } 
      i++;
    } 
    if (LinearSystem.getMetrics() != null) {
      Metrics metrics = LinearSystem.getMetrics();
      metrics.barrierConnectionResolved++;
    } 
    resolutionAnchor1.resolvedTarget = resolutionAnchor2;
    resolutionAnchor1.resolvedOffset = f2;
    resolutionAnchor1.didResolve();
    switch (this.mBarrierType) {
      default:
        return;
      case 3:
        this.mTop.getResolutionNode().resolve(resolutionAnchor2, f2);
        return;
      case 2:
        this.mBottom.getResolutionNode().resolve(resolutionAnchor2, f2);
        return;
      case 1:
        this.mLeft.getResolutionNode().resolve(resolutionAnchor2, f2);
        return;
      case 0:
        break;
    } 
    this.mRight.getResolutionNode().resolve(resolutionAnchor2, f2);
  }
  
  public void setAllowsGoneWidget(boolean paramBoolean) {
    this.mAllowsGoneWidget = paramBoolean;
  }
  
  public void setBarrierType(int paramInt) {
    this.mBarrierType = paramInt;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\constraint\solver\widgets\Barrier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */