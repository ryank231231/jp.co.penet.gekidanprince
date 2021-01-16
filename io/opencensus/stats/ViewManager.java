package io.opencensus.stats;

import java.util.Set;
import javax.annotation.Nullable;

public abstract class ViewManager {
  public abstract Set<View> getAllExportedViews();
  
  @Nullable
  public abstract ViewData getView(View.Name paramName);
  
  public abstract void registerView(View paramView);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\stats\ViewManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */