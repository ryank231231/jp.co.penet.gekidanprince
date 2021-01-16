package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
public class ExecutionError extends Error {
  private static final long serialVersionUID = 0L;
  
  protected ExecutionError() {}
  
  public ExecutionError(@Nullable Error paramError) {
    super(paramError);
  }
  
  protected ExecutionError(@Nullable String paramString) {
    super(paramString);
  }
  
  public ExecutionError(@Nullable String paramString, @Nullable Error paramError) {
    super(paramString, paramError);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\ExecutionError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */