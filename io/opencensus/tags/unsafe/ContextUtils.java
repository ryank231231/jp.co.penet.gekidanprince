package io.opencensus.tags.unsafe;

import io.grpc.Context;
import io.opencensus.tags.Tag;
import io.opencensus.tags.TagContext;
import java.util.Collections;
import java.util.Iterator;
import javax.annotation.concurrent.Immutable;

public final class ContextUtils {
  private static final TagContext EMPTY_TAG_CONTEXT = new EmptyTagContext();
  
  public static final Context.Key<TagContext> TAG_CONTEXT_KEY = Context.keyWithDefault("opencensus-tag-context-key", EMPTY_TAG_CONTEXT);
  
  @Immutable
  private static final class EmptyTagContext extends TagContext {
    private EmptyTagContext() {}
    
    protected Iterator<Tag> getIterator() {
      return Collections.<Tag>emptySet().iterator();
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\tag\\unsafe\ContextUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */