package io.grpc.internal;

import io.grpc.Context;

abstract class ContextRunnable implements Runnable {
  private final Context context;
  
  public ContextRunnable(Context paramContext) {
    this.context = paramContext;
  }
  
  public final void run() {
    Context context = this.context.attach();
    try {
      runInContext();
      return;
    } finally {
      this.context.detach(context);
    } 
  }
  
  public abstract void runInContext();
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ContextRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */