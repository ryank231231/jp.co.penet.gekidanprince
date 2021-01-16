package io.opencensus.tags;

import io.opencensus.tags.propagation.TagPropagationComponent;

public abstract class TagsComponent {
  public abstract TaggingState getState();
  
  public abstract TagPropagationComponent getTagPropagationComponent();
  
  public abstract Tagger getTagger();
  
  @Deprecated
  public abstract void setState(TaggingState paramTaggingState);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\tags\TagsComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */