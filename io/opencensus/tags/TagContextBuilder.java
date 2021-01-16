package io.opencensus.tags;

import io.opencensus.common.Scope;

public abstract class TagContextBuilder {
  public abstract TagContext build();
  
  public abstract Scope buildScoped();
  
  public abstract TagContextBuilder put(TagKey paramTagKey, TagValue paramTagValue);
  
  public abstract TagContextBuilder remove(TagKey paramTagKey);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\tags\TagContextBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */