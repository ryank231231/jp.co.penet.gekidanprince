package io.opencensus.tags;

import com.google.common.annotations.VisibleForTesting;
import io.opencensus.internal.Provider;
import io.opencensus.tags.propagation.TagPropagationComponent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class Tags {
  private static final Logger logger = Logger.getLogger(Tags.class.getName());
  
  private static final TagsComponent tagsComponent = loadTagsComponent(TagsComponent.class.getClassLoader());
  
  public static TaggingState getState() {
    return tagsComponent.getState();
  }
  
  public static TagPropagationComponent getTagPropagationComponent() {
    return tagsComponent.getTagPropagationComponent();
  }
  
  public static Tagger getTagger() {
    return tagsComponent.getTagger();
  }
  
  @VisibleForTesting
  static TagsComponent loadTagsComponent(@Nullable ClassLoader paramClassLoader) {
    try {
      return (TagsComponent)Provider.createInstance(Class.forName("io.opencensus.impl.tags.TagsComponentImpl", true, paramClassLoader), TagsComponent.class);
    } catch (ClassNotFoundException classNotFoundException) {
      logger.log(Level.FINE, "Couldn't load full implementation for TagsComponent, now trying to load lite implementation.", classNotFoundException);
      try {
        return (TagsComponent)Provider.createInstance(Class.forName("io.opencensus.impllite.tags.TagsComponentImplLite", true, paramClassLoader), TagsComponent.class);
      } catch (ClassNotFoundException classNotFoundException1) {
        logger.log(Level.FINE, "Couldn't load lite implementation for TagsComponent, now using default implementation for TagsComponent.", classNotFoundException1);
        return NoopTags.newNoopTagsComponent();
      } 
    } 
  }
  
  @Deprecated
  public static void setState(TaggingState paramTaggingState) {
    tagsComponent.setState(paramTaggingState);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\tags\Tags.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */