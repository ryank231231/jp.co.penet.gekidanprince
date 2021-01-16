package io.opencensus.tags;

public enum TaggingState {
  DISABLED, ENABLED;
  
  static {
    DISABLED = new TaggingState("DISABLED", 1);
    $VALUES = new TaggingState[] { ENABLED, DISABLED };
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\tags\TaggingState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */