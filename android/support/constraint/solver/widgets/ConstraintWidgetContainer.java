package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.Metrics;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class ConstraintWidgetContainer extends WidgetContainer {
  private static final boolean DEBUG = false;
  
  static final boolean DEBUG_GRAPH = false;
  
  private static final boolean DEBUG_LAYOUT = false;
  
  private static final int MAX_ITERATIONS = 8;
  
  private static final boolean USE_SNAPSHOT = true;
  
  int mDebugSolverPassCount = 0;
  
  private boolean mHeightMeasuredTooSmall = false;
  
  ChainHead[] mHorizontalChainsArray = new ChainHead[4];
  
  int mHorizontalChainsSize = 0;
  
  private boolean mIsRtl = false;
  
  private int mOptimizationLevel = 3;
  
  int mPaddingBottom;
  
  int mPaddingLeft;
  
  int mPaddingRight;
  
  int mPaddingTop;
  
  private Snapshot mSnapshot;
  
  protected LinearSystem mSystem = new LinearSystem();
  
  ChainHead[] mVerticalChainsArray = new ChainHead[4];
  
  int mVerticalChainsSize = 0;
  
  private boolean mWidthMeasuredTooSmall = false;
  
  public ConstraintWidgetContainer() {}
  
  public ConstraintWidgetContainer(int paramInt1, int paramInt2) {
    super(paramInt1, paramInt2);
  }
  
  public ConstraintWidgetContainer(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void addHorizontalChain(ConstraintWidget paramConstraintWidget) {
    int i = this.mHorizontalChainsSize;
    ChainHead[] arrayOfChainHead = this.mHorizontalChainsArray;
    if (i + 1 >= arrayOfChainHead.length)
      this.mHorizontalChainsArray = Arrays.<ChainHead>copyOf(arrayOfChainHead, arrayOfChainHead.length * 2); 
    this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(paramConstraintWidget, 0, isRtl());
    this.mHorizontalChainsSize++;
  }
  
  private void addVerticalChain(ConstraintWidget paramConstraintWidget) {
    int i = this.mVerticalChainsSize;
    ChainHead[] arrayOfChainHead = this.mVerticalChainsArray;
    if (i + 1 >= arrayOfChainHead.length)
      this.mVerticalChainsArray = Arrays.<ChainHead>copyOf(arrayOfChainHead, arrayOfChainHead.length * 2); 
    this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(paramConstraintWidget, 1, isRtl());
    this.mVerticalChainsSize++;
  }
  
  private void resetChains() {
    this.mHorizontalChainsSize = 0;
    this.mVerticalChainsSize = 0;
  }
  
  void addChain(ConstraintWidget paramConstraintWidget, int paramInt) {
    if (paramInt == 0) {
      addHorizontalChain(paramConstraintWidget);
    } else if (paramInt == 1) {
      addVerticalChain(paramConstraintWidget);
    } 
  }
  
  public boolean addChildrenToSolver(LinearSystem paramLinearSystem) {
    addToSolver(paramLinearSystem);
    int i = this.mChildren.size();
    for (byte b = 0; b < i; b++) {
      ConstraintWidget constraintWidget = this.mChildren.get(b);
      if (constraintWidget instanceof ConstraintWidgetContainer) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour1 = constraintWidget.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.mListDimensionBehaviors[1];
        if (dimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
          constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED); 
        if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
          constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED); 
        constraintWidget.addToSolver(paramLinearSystem);
        if (dimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
          constraintWidget.setHorizontalDimensionBehaviour(dimensionBehaviour1); 
        if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
          constraintWidget.setVerticalDimensionBehaviour(dimensionBehaviour2); 
      } else {
        Optimizer.checkMatchParent(this, paramLinearSystem, constraintWidget);
        constraintWidget.addToSolver(paramLinearSystem);
      } 
    } 
    if (this.mHorizontalChainsSize > 0)
      Chain.applyChainConstraints(this, paramLinearSystem, 0); 
    if (this.mVerticalChainsSize > 0)
      Chain.applyChainConstraints(this, paramLinearSystem, 1); 
    return true;
  }
  
  public void analyze(int paramInt) {
    super.analyze(paramInt);
    int i = this.mChildren.size();
    for (byte b = 0; b < i; b++)
      ((ConstraintWidget)this.mChildren.get(b)).analyze(paramInt); 
  }
  
  public void fillMetrics(Metrics paramMetrics) {
    this.mSystem.fillMetrics(paramMetrics);
  }
  
  public ArrayList<Guideline> getHorizontalGuidelines() {
    ArrayList<ConstraintWidget> arrayList = new ArrayList();
    int i = this.mChildren.size();
    for (byte b = 0; b < i; b++) {
      ConstraintWidget constraintWidget = this.mChildren.get(b);
      if (constraintWidget instanceof Guideline) {
        constraintWidget = constraintWidget;
        if (constraintWidget.getOrientation() == 0)
          arrayList.add(constraintWidget); 
      } 
    } 
    return (ArrayList)arrayList;
  }
  
  public int getOptimizationLevel() {
    return this.mOptimizationLevel;
  }
  
  public LinearSystem getSystem() {
    return this.mSystem;
  }
  
  public String getType() {
    return "ConstraintLayout";
  }
  
  public ArrayList<Guideline> getVerticalGuidelines() {
    ArrayList<ConstraintWidget> arrayList = new ArrayList();
    int i = this.mChildren.size();
    for (byte b = 0; b < i; b++) {
      ConstraintWidget constraintWidget = this.mChildren.get(b);
      if (constraintWidget instanceof Guideline) {
        constraintWidget = constraintWidget;
        if (constraintWidget.getOrientation() == 1)
          arrayList.add(constraintWidget); 
      } 
    } 
    return (ArrayList)arrayList;
  }
  
  public boolean handlesInternalConstraints() {
    return false;
  }
  
  public boolean isHeightMeasuredTooSmall() {
    return this.mHeightMeasuredTooSmall;
  }
  
  public boolean isRtl() {
    return this.mIsRtl;
  }
  
  public boolean isWidthMeasuredTooSmall() {
    return this.mWidthMeasuredTooSmall;
  }
  
  public void layout() {
    int i = this.mX;
    int j = this.mY;
    int k = Math.max(0, getWidth());
    int m = Math.max(0, getHeight());
    this.mWidthMeasuredTooSmall = false;
    this.mHeightMeasuredTooSmall = false;
    if (this.mParent != null) {
      if (this.mSnapshot == null)
        this.mSnapshot = new Snapshot(this); 
      this.mSnapshot.updateFrom(this);
      setX(this.mPaddingLeft);
      setY(this.mPaddingTop);
      resetAnchors();
      resetSolverVariables(this.mSystem.getCache());
    } else {
      this.mX = 0;
      this.mY = 0;
    } 
    if (this.mOptimizationLevel != 0) {
      if (!optimizeFor(8))
        optimizeReset(); 
      optimize();
      this.mSystem.graphOptimizer = true;
    } else {
      this.mSystem.graphOptimizer = false;
    } 
    ConstraintWidget.DimensionBehaviour dimensionBehaviour1 = this.mListDimensionBehaviors[1];
    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.mListDimensionBehaviors[0];
    resetChains();
    int n = this.mChildren.size();
    int i1;
    for (i1 = 0; i1 < n; i1++) {
      ConstraintWidget constraintWidget = this.mChildren.get(i1);
      if (constraintWidget instanceof WidgetContainer)
        ((WidgetContainer)constraintWidget).layout(); 
    } 
    int i2 = 0;
    boolean bool = true;
    i1 = 0;
    while (bool) {
      int i3 = i2 + 1;
      boolean bool1 = bool;
      try {
        this.mSystem.reset();
        bool1 = bool;
        createObjectVariables(this.mSystem);
        for (i2 = 0; i2 < n; i2++) {
          bool1 = bool;
          ((ConstraintWidget)this.mChildren.get(i2)).createObjectVariables(this.mSystem);
        } 
        bool1 = bool;
        bool = addChildrenToSolver(this.mSystem);
        bool1 = bool;
        if (bool) {
          bool1 = bool;
          this.mSystem.minimize();
          bool1 = bool;
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
        PrintStream printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EXCEPTION : ");
        stringBuilder.append(exception);
        printStream.println(stringBuilder.toString());
      } 
      if (bool1) {
        updateChildrenFromSolver(this.mSystem, Optimizer.flags);
      } else {
        updateFromSolver(this.mSystem);
        for (i2 = 0; i2 < n; i2++) {
          ConstraintWidget constraintWidget = this.mChildren.get(i2);
          if (constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getWidth() < constraintWidget.getWrapWidth()) {
            Optimizer.flags[2] = true;
            break;
          } 
          if (constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getHeight() < constraintWidget.getWrapHeight()) {
            Optimizer.flags[2] = true;
            break;
          } 
        } 
      } 
      if (i3 < 8 && Optimizer.flags[2]) {
        int i4 = 0;
        int i5 = 0;
        i2 = 0;
        while (i4 < n) {
          ConstraintWidget constraintWidget = this.mChildren.get(i4);
          i5 = Math.max(i5, constraintWidget.mX + constraintWidget.getWidth());
          i2 = Math.max(i2, constraintWidget.mY + constraintWidget.getHeight());
          i4++;
        } 
        i4 = Math.max(this.mMinWidth, i5);
        i2 = Math.max(this.mMinHeight, i2);
        if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && getWidth() < i4) {
          setWidth(i4);
          this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
          bool1 = true;
          i1 = 1;
        } else {
          bool1 = false;
        } 
        if (dimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && getHeight() < i2) {
          setHeight(i2);
          this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
          bool1 = true;
          i1 = 1;
        } 
      } else {
        bool1 = false;
      } 
      i2 = Math.max(this.mMinWidth, getWidth());
      if (i2 > getWidth()) {
        setWidth(i2);
        this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
        bool1 = true;
        i1 = 1;
      } 
      i2 = Math.max(this.mMinHeight, getHeight());
      if (i2 > getHeight()) {
        setHeight(i2);
        this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
        bool1 = true;
        i1 = 1;
      } 
      if (i1 == 0) {
        bool = bool1;
        i2 = i1;
        if (this.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          bool = bool1;
          i2 = i1;
          if (k > 0) {
            bool = bool1;
            i2 = i1;
            if (getWidth() > k) {
              this.mWidthMeasuredTooSmall = true;
              this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
              setWidth(k);
              bool = true;
              i2 = 1;
            } 
          } 
        } 
        if (this.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && m > 0 && getHeight() > m) {
          this.mHeightMeasuredTooSmall = true;
          this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
          setHeight(m);
          bool1 = true;
          i1 = 1;
        } else {
          bool1 = bool;
          i1 = i2;
        } 
      } 
      i2 = i3;
      bool = bool1;
    } 
    if (this.mParent != null) {
      int i3 = Math.max(this.mMinWidth, getWidth());
      i2 = Math.max(this.mMinHeight, getHeight());
      this.mSnapshot.applyTo(this);
      setWidth(i3 + this.mPaddingLeft + this.mPaddingRight);
      setHeight(i2 + this.mPaddingTop + this.mPaddingBottom);
    } else {
      this.mX = i;
      this.mY = j;
    } 
    if (i1 != 0) {
      this.mListDimensionBehaviors[0] = dimensionBehaviour2;
      this.mListDimensionBehaviors[1] = dimensionBehaviour1;
    } 
    resetSolverVariables(this.mSystem.getCache());
    if (this == getRootConstraintContainer())
      updateDrawPosition(); 
  }
  
  public void optimize() {
    if (!optimizeFor(8))
      analyze(this.mOptimizationLevel); 
    solveGraph();
  }
  
  public boolean optimizeFor(int paramInt) {
    boolean bool;
    if ((this.mOptimizationLevel & paramInt) == paramInt) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void optimizeForDimensions(int paramInt1, int paramInt2) {
    if (this.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && this.mResolutionWidth != null)
      this.mResolutionWidth.resolve(paramInt1); 
    if (this.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && this.mResolutionHeight != null)
      this.mResolutionHeight.resolve(paramInt2); 
  }
  
  public void optimizeReset() {
    int i = this.mChildren.size();
    resetResolutionNodes();
    for (byte b = 0; b < i; b++)
      ((ConstraintWidget)this.mChildren.get(b)).resetResolutionNodes(); 
  }
  
  public void preOptimize() {
    optimizeReset();
    analyze(this.mOptimizationLevel);
  }
  
  public void reset() {
    this.mSystem.reset();
    this.mPaddingLeft = 0;
    this.mPaddingRight = 0;
    this.mPaddingTop = 0;
    this.mPaddingBottom = 0;
    super.reset();
  }
  
  public void resetGraph() {
    ResolutionAnchor resolutionAnchor1 = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
    ResolutionAnchor resolutionAnchor2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
    resolutionAnchor1.invalidateAnchors();
    resolutionAnchor2.invalidateAnchors();
    resolutionAnchor1.resolve(null, 0.0F);
    resolutionAnchor2.resolve(null, 0.0F);
  }
  
  public void setOptimizationLevel(int paramInt) {
    this.mOptimizationLevel = paramInt;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.mPaddingLeft = paramInt1;
    this.mPaddingTop = paramInt2;
    this.mPaddingRight = paramInt3;
    this.mPaddingBottom = paramInt4;
  }
  
  public void setRtl(boolean paramBoolean) {
    this.mIsRtl = paramBoolean;
  }
  
  public void solveGraph() {
    ResolutionAnchor resolutionAnchor1 = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
    ResolutionAnchor resolutionAnchor2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
    resolutionAnchor1.resolve(null, 0.0F);
    resolutionAnchor2.resolve(null, 0.0F);
  }
  
  public void updateChildrenFromSolver(LinearSystem paramLinearSystem, boolean[] paramArrayOfboolean) {
    paramArrayOfboolean[2] = false;
    updateFromSolver(paramLinearSystem);
    int i = this.mChildren.size();
    for (byte b = 0; b < i; b++) {
      ConstraintWidget constraintWidget = this.mChildren.get(b);
      constraintWidget.updateFromSolver(paramLinearSystem);
      if (constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getWidth() < constraintWidget.getWrapWidth())
        paramArrayOfboolean[2] = true; 
      if (constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getHeight() < constraintWidget.getWrapHeight())
        paramArrayOfboolean[2] = true; 
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\constraint\solver\widgets\ConstraintWidgetContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */