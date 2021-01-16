package io.opencensus.trace.propagation;

import com.google.common.base.Preconditions;
import io.opencensus.trace.SpanContext;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

public abstract class TextFormat {
  private static final NoopTextFormat NOOP_TEXT_FORMAT = new NoopTextFormat();
  
  static TextFormat getNoopTextFormat() {
    return NOOP_TEXT_FORMAT;
  }
  
  public abstract <C> SpanContext extract(C paramC, Getter<C> paramGetter) throws SpanContextParseException;
  
  public abstract List<String> fields();
  
  public abstract <C> void inject(SpanContext paramSpanContext, C paramC, Setter<C> paramSetter);
  
  public static abstract class Getter<C> {
    @Nullable
    public abstract String get(C param1C, String param1String);
  }
  
  private static final class NoopTextFormat extends TextFormat {
    private NoopTextFormat() {}
    
    public <C> SpanContext extract(C param1C, TextFormat.Getter<C> param1Getter) {
      Preconditions.checkNotNull(param1C, "carrier");
      Preconditions.checkNotNull(param1Getter, "getter");
      return SpanContext.INVALID;
    }
    
    public List<String> fields() {
      return Collections.emptyList();
    }
    
    public <C> void inject(SpanContext param1SpanContext, C param1C, TextFormat.Setter<C> param1Setter) {
      Preconditions.checkNotNull(param1SpanContext, "spanContext");
      Preconditions.checkNotNull(param1C, "carrier");
      Preconditions.checkNotNull(param1Setter, "setter");
    }
  }
  
  public static abstract class Setter<C> {
    public abstract void put(C param1C, String param1String1, String param1String2);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\propagation\TextFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */