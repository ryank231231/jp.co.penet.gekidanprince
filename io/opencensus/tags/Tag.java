package io.opencensus.tags;

import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class Tag {
  public static Tag create(TagKey paramTagKey, TagValue paramTagValue) {
    return new AutoValue_Tag(paramTagKey, paramTagValue);
  }
  
  public abstract TagKey getKey();
  
  public abstract TagValue getValue();
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\tags\Tag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */