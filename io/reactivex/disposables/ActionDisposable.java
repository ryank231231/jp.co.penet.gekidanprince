package io.reactivex.disposables;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.internal.util.ExceptionHelper;

final class ActionDisposable extends ReferenceDisposable<Action> {
  private static final long serialVersionUID = -8219729196779211169L;
  
  ActionDisposable(Action paramAction) {
    super(paramAction);
  }
  
  protected void onDisposed(@NonNull Action paramAction) {
    try {
      paramAction.run();
      return;
    } catch (Throwable throwable) {
      throw ExceptionHelper.wrapOrThrow(throwable);
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\disposables\ActionDisposable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */