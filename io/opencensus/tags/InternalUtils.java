package io.opencensus.tags;

import java.util.Iterator;

public final class InternalUtils {
  public static Iterator<Tag> getTags(TagContext paramTagContext) {
    return paramTagContext.getIterator();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\tags\InternalUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */