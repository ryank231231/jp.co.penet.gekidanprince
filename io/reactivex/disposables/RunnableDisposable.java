package io.reactivex.disposables;

import io.reactivex.annotations.NonNull;

final class RunnableDisposable extends ReferenceDisposable<Runnable> {
  private static final long serialVersionUID = -8219729196779211169L;
  
  RunnableDisposable(Runnable paramRunnable) {
    super(paramRunnable);
  }
  
  protected void onDisposed(@NonNull Runnable paramRunnable) {
    paramRunnable.run();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("RunnableDisposable(disposed=");
    stringBuilder.append(isDisposed());
    stringBuilder.append(", ");
    stringBuilder.append(get());
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\disposables\RunnableDisposable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */