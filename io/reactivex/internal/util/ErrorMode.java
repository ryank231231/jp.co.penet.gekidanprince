package io.reactivex.internal.util;

public enum ErrorMode {
  BOUNDARY, END, IMMEDIATE;
  
  static {
    BOUNDARY = new ErrorMode("BOUNDARY", 1);
    END = new ErrorMode("END", 2);
    $VALUES = new ErrorMode[] { IMMEDIATE, BOUNDARY, END };
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\interna\\util\ErrorMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */