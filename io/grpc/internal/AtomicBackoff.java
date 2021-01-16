package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class AtomicBackoff {
  private static final Logger log = Logger.getLogger(AtomicBackoff.class.getName());
  
  private final String name;
  
  private final AtomicLong value;
  
  public AtomicBackoff(String paramString, long paramLong) {
    boolean bool;
    this.value = new AtomicLong();
    if (paramLong > 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "value must be positive");
    this.name = paramString;
    this.value.set(paramLong);
  }
  
  public State getState() {
    return new State(this.value.get());
  }
  
  @ThreadSafe
  public final class State {
    private final long savedValue;
    
    private State(long param1Long) {
      this.savedValue = param1Long;
    }
    
    public void backoff() {
      long l = this.savedValue;
      l = Math.max(2L * l, l);
      if (AtomicBackoff.this.value.compareAndSet(this.savedValue, l))
        AtomicBackoff.log.log(Level.WARNING, "Increased {0} to {1}", new Object[] { AtomicBackoff.access$200(this.this$0), Long.valueOf(l) }); 
    }
    
    public long get() {
      return this.savedValue;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\AtomicBackoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */