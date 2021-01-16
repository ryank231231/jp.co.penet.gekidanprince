package io.opencensus.tags;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import java.util.Iterator;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class TagContext {
  public boolean equals(@Nullable Object<Tag> paramObject) {
    ImmutableMultiset immutableMultiset;
    HashMultiset hashMultiset;
    if (!(paramObject instanceof TagContext))
      return false; 
    TagContext tagContext = (TagContext)paramObject;
    paramObject = (Object<Tag>)getIterator();
    Iterator<Tag> iterator = tagContext.getIterator();
    if (paramObject == null) {
      immutableMultiset = ImmutableMultiset.of();
    } else {
      hashMultiset = HashMultiset.create(Lists.newArrayList((Iterator)immutableMultiset));
    } 
    Multiset multiset = (Multiset)hashMultiset;
    if (iterator == null) {
      ImmutableMultiset immutableMultiset1 = ImmutableMultiset.of();
    } else {
      hashMultiset = HashMultiset.create(Lists.newArrayList(iterator));
    } 
    return multiset.equals(hashMultiset);
  }
  
  protected abstract Iterator<Tag> getIterator();
  
  public final int hashCode() {
    Iterator<Tag> iterator = getIterator();
    int i = 0;
    if (iterator == null)
      return 0; 
    while (iterator.hasNext()) {
      Tag tag = iterator.next();
      if (tag != null)
        i += tag.hashCode(); 
    } 
    return i;
  }
  
  public String toString() {
    return "TagContext";
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\tags\TagContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */