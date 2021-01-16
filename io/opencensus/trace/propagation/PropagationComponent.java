package io.opencensus.trace.propagation;

public abstract class PropagationComponent {
  private static final PropagationComponent NOOP_PROPAGATION_COMPONENT = new NoopPropagationComponent();
  
  public static PropagationComponent getNoopPropagationComponent() {
    return NOOP_PROPAGATION_COMPONENT;
  }
  
  public abstract TextFormat getB3Format();
  
  public abstract BinaryFormat getBinaryFormat();
  
  private static final class NoopPropagationComponent extends PropagationComponent {
    private NoopPropagationComponent() {}
    
    public TextFormat getB3Format() {
      return TextFormat.getNoopTextFormat();
    }
    
    public BinaryFormat getBinaryFormat() {
      return BinaryFormat.getNoopBinaryFormat();
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\propagation\PropagationComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */