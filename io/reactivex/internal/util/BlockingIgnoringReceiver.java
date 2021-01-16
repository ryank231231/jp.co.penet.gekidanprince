package io.reactivex.internal.util;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.CountDownLatch;

public final class BlockingIgnoringReceiver extends CountDownLatch implements Consumer<Throwable>, Action {
  public Throwable error;
  
  public BlockingIgnoringReceiver() {
    super(1);
  }
  
  public void accept(Throwable paramThrowable) {
    this.error = paramThrowable;
    countDown();
  }
  
  public void run() {
    countDown();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\interna\\util\BlockingIgnoringReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */