package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public final class Verify {
  public static void verify(boolean paramBoolean) {
    if (paramBoolean)
      return; 
    throw new VerifyException();
  }
  
  public static void verify(boolean paramBoolean, @Nullable String paramString, @Nullable Object... paramVarArgs) {
    if (paramBoolean)
      return; 
    throw new VerifyException(Preconditions.format(paramString, paramVarArgs));
  }
  
  @CanIgnoreReturnValue
  public static <T> T verifyNotNull(@Nullable T paramT) {
    return verifyNotNull(paramT, "expected a non-null reference", new Object[0]);
  }
  
  @CanIgnoreReturnValue
  public static <T> T verifyNotNull(@Nullable T paramT, @Nullable String paramString, @Nullable Object... paramVarArgs) {
    boolean bool;
    if (paramT != null) {
      bool = true;
    } else {
      bool = false;
    } 
    verify(bool, paramString, paramVarArgs);
    return paramT;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\Verify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */