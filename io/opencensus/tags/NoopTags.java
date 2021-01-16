package io.opencensus.tags;

import com.google.common.base.Preconditions;
import io.opencensus.common.Scope;
import io.opencensus.internal.NoopScope;
import io.opencensus.tags.propagation.TagContextBinarySerializer;
import io.opencensus.tags.propagation.TagPropagationComponent;
import java.util.Collections;
import java.util.Iterator;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;

final class NoopTags {
  static TagContext getNoopTagContext() {
    return NoopTagContext.INSTANCE;
  }
  
  static TagContextBinarySerializer getNoopTagContextBinarySerializer() {
    return NoopTagContextBinarySerializer.INSTANCE;
  }
  
  static TagContextBuilder getNoopTagContextBuilder() {
    return NoopTagContextBuilder.INSTANCE;
  }
  
  static TagPropagationComponent getNoopTagPropagationComponent() {
    return NoopTagPropagationComponent.INSTANCE;
  }
  
  static Tagger getNoopTagger() {
    return NoopTagger.INSTANCE;
  }
  
  static TagsComponent newNoopTagsComponent() {
    return new NoopTagsComponent();
  }
  
  @Immutable
  private static final class NoopTagContext extends TagContext {
    static final TagContext INSTANCE = new NoopTagContext();
    
    protected Iterator<Tag> getIterator() {
      return Collections.<Tag>emptySet().iterator();
    }
  }
  
  @Immutable
  private static final class NoopTagContextBinarySerializer extends TagContextBinarySerializer {
    static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    
    static final TagContextBinarySerializer INSTANCE = new NoopTagContextBinarySerializer();
    
    static {
    
    }
    
    public TagContext fromByteArray(byte[] param1ArrayOfbyte) {
      Preconditions.checkNotNull(param1ArrayOfbyte, "bytes");
      return NoopTags.getNoopTagContext();
    }
    
    public byte[] toByteArray(TagContext param1TagContext) {
      Preconditions.checkNotNull(param1TagContext, "tags");
      return EMPTY_BYTE_ARRAY;
    }
  }
  
  @Immutable
  private static final class NoopTagContextBuilder extends TagContextBuilder {
    static final TagContextBuilder INSTANCE = new NoopTagContextBuilder();
    
    public TagContext build() {
      return NoopTags.getNoopTagContext();
    }
    
    public Scope buildScoped() {
      return NoopScope.getInstance();
    }
    
    public TagContextBuilder put(TagKey param1TagKey, TagValue param1TagValue) {
      Preconditions.checkNotNull(param1TagKey, "key");
      Preconditions.checkNotNull(param1TagValue, "value");
      return this;
    }
    
    public TagContextBuilder remove(TagKey param1TagKey) {
      Preconditions.checkNotNull(param1TagKey, "key");
      return this;
    }
  }
  
  @Immutable
  private static final class NoopTagPropagationComponent extends TagPropagationComponent {
    static final TagPropagationComponent INSTANCE = new NoopTagPropagationComponent();
    
    public TagContextBinarySerializer getBinarySerializer() {
      return NoopTags.getNoopTagContextBinarySerializer();
    }
  }
  
  @Immutable
  private static final class NoopTagger extends Tagger {
    static final Tagger INSTANCE = new NoopTagger();
    
    public TagContextBuilder currentBuilder() {
      return NoopTags.getNoopTagContextBuilder();
    }
    
    public TagContext empty() {
      return NoopTags.getNoopTagContext();
    }
    
    public TagContextBuilder emptyBuilder() {
      return NoopTags.getNoopTagContextBuilder();
    }
    
    public TagContext getCurrentTagContext() {
      return NoopTags.getNoopTagContext();
    }
    
    public TagContextBuilder toBuilder(TagContext param1TagContext) {
      Preconditions.checkNotNull(param1TagContext, "tags");
      return NoopTags.getNoopTagContextBuilder();
    }
    
    public Scope withTagContext(TagContext param1TagContext) {
      Preconditions.checkNotNull(param1TagContext, "tags");
      return NoopScope.getInstance();
    }
  }
  
  @ThreadSafe
  private static final class NoopTagsComponent extends TagsComponent {
    private volatile boolean isRead;
    
    private NoopTagsComponent() {}
    
    public TaggingState getState() {
      this.isRead = true;
      return TaggingState.DISABLED;
    }
    
    public TagPropagationComponent getTagPropagationComponent() {
      return NoopTags.getNoopTagPropagationComponent();
    }
    
    public Tagger getTagger() {
      return NoopTags.getNoopTagger();
    }
    
    @Deprecated
    public void setState(TaggingState param1TaggingState) {
      Preconditions.checkNotNull(param1TaggingState, "state");
      Preconditions.checkState(this.isRead ^ true, "State was already read, cannot set state.");
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\tags\NoopTags.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */