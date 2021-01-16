package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
final class Platform {
  static boolean isInstanceOfThrowableClass(@Nullable Throwable paramThrowable, Class<? extends Throwable> paramClass) {
    return paramClass.isInstance(paramThrowable);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */