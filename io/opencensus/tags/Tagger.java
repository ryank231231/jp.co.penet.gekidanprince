package io.opencensus.tags;

import io.opencensus.common.Scope;

public abstract class Tagger {
  public abstract TagContextBuilder currentBuilder();
  
  public abstract TagContext empty();
  
  public abstract TagContextBuilder emptyBuilder();
  
  public abstract TagContext getCurrentTagContext();
  
  public abstract TagContextBuilder toBuilder(TagContext paramTagContext);
  
  public abstract Scope withTagContext(TagContext paramTagContext);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\tags\Tagger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */