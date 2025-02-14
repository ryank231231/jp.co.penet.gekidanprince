package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.io.Flushable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Beta
@GwtIncompatible
public final class Flushables {
  private static final Logger logger = Logger.getLogger(Flushables.class.getName());
  
  public static void flush(Flushable paramFlushable, boolean paramBoolean) throws IOException {
    try {
      paramFlushable.flush();
    } catch (IOException iOException) {
      if (paramBoolean) {
        logger.log(Level.WARNING, "IOException thrown while flushing Flushable.", iOException);
        return;
      } 
    } 
  }
  
  public static void flushQuietly(Flushable paramFlushable) {
    try {
      flush(paramFlushable, true);
    } catch (IOException iOException) {
      logger.log(Level.SEVERE, "IOException should not have been thrown.", iOException);
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\io\Flushables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */