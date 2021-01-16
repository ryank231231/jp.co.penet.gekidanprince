package com.google.firebase.inappmessaging.display.internal.layout.util;

import android.view.View;
import com.google.firebase.inappmessaging.display.internal.Logging;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class VerticalViewGroupMeasure {
  private int h = 0;
  
  private List<ViewMeasure> vms = new ArrayList<ViewMeasure>();
  
  private int w = 0;
  
  public VerticalViewGroupMeasure() {}
  
  public VerticalViewGroupMeasure(int paramInt1, int paramInt2) {}
  
  public void add(View paramView, boolean paramBoolean) {
    ViewMeasure viewMeasure = new ViewMeasure(paramView, paramBoolean);
    viewMeasure.setMaxDimens(this.w, this.h);
    this.vms.add(viewMeasure);
  }
  
  public void allocateSpace(int paramInt) {
    ArrayList<ViewMeasure> arrayList = new ArrayList();
    for (ViewMeasure viewMeasure : this.vms) {
      if (viewMeasure.isFlex())
        arrayList.add(viewMeasure); 
    } 
    Collections.sort(arrayList, new Comparator<ViewMeasure>() {
          public int compare(ViewMeasure param1ViewMeasure1, ViewMeasure param1ViewMeasure2) {
            return (param1ViewMeasure1.getDesiredHeight() > param1ViewMeasure2.getDesiredHeight()) ? -1 : ((param1ViewMeasure1.getDesiredHeight() < param1ViewMeasure2.getDesiredHeight()) ? 1 : 0);
          }
        });
    int i = 0;
    Iterator<ViewMeasure> iterator = arrayList.iterator();
    while (iterator.hasNext())
      i += ((ViewMeasure)iterator.next()).getDesiredHeight(); 
    int j = arrayList.size();
    if (j < 6) {
      float f1 = 1.0F - (j - 1) * 0.2F;
      Logging.logdPair("VVGM (minFrac, maxFrac)", 0.2F, f1);
      float f2 = 0.0F;
      for (ViewMeasure viewMeasure : arrayList) {
        float f4;
        float f3 = viewMeasure.getDesiredHeight() / i;
        if (f3 > f1) {
          f2 += f3 - f1;
          f4 = f1;
        } else {
          f4 = f3;
        } 
        float f5 = f2;
        if (f3 < 0.2F) {
          f4 = Math.min(0.2F - f3, f2);
          f5 = f2 - f4;
          f4 = f3 + f4;
        } 
        Logging.logdPair("\t(desired, granted)", f3, f4);
        j = (int)(f4 * paramInt);
        viewMeasure.setMaxDimens(this.w, j);
        f2 = f5;
      } 
      return;
    } 
    throw new IllegalStateException("VerticalViewGroupMeasure only supports up to 5 children");
  }
  
  public int getTotalFixedHeight() {
    Iterator<ViewMeasure> iterator = this.vms.iterator();
    int i = 0;
    while (iterator.hasNext()) {
      ViewMeasure viewMeasure = iterator.next();
      if (!viewMeasure.isFlex())
        i += viewMeasure.getDesiredHeight(); 
    } 
    return i;
  }
  
  public int getTotalHeight() {
    Iterator<ViewMeasure> iterator = this.vms.iterator();
    int i;
    for (i = 0; iterator.hasNext(); i += ((ViewMeasure)iterator.next()).getDesiredHeight());
    return i;
  }
  
  public List<ViewMeasure> getViews() {
    return this.vms;
  }
  
  public void reset(int paramInt1, int paramInt2) {
    this.w = paramInt1;
    this.h = paramInt2;
    this.vms = new ArrayList<ViewMeasure>();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\layou\\util\VerticalViewGroupMeasure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */