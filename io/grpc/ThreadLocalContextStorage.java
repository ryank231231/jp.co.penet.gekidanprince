package io.grpc;

import java.util.logging.Level;
import java.util.logging.Logger;

final class ThreadLocalContextStorage extends Context.Storage {
  private static final ThreadLocal<Context> localContext;
  
  private static final Logger log = Logger.getLogger(ThreadLocalContextStorage.class.getName());
  
  static {
    localContext = new ThreadLocal<Context>();
  }
  
  public Context current() {
    return localContext.get();
  }
  
  public void detach(Context paramContext1, Context paramContext2) {
    if (current() != paramContext1)
      log.log(Level.SEVERE, "Context was not attached when detaching", (new Throwable()).fillInStackTrace()); 
    doAttach(paramContext2);
  }
  
  public Context doAttach(Context paramContext) {
    Context context = current();
    localContext.set(paramContext);
    return context;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\ThreadLocalContextStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */