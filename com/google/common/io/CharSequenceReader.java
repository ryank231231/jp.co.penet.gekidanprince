package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

@GwtIncompatible
final class CharSequenceReader extends Reader {
  private int mark;
  
  private int pos;
  
  private CharSequence seq;
  
  public CharSequenceReader(CharSequence paramCharSequence) {
    this.seq = (CharSequence)Preconditions.checkNotNull(paramCharSequence);
  }
  
  private void checkOpen() throws IOException {
    if (this.seq != null)
      return; 
    throw new IOException("reader closed");
  }
  
  private boolean hasRemaining() {
    boolean bool;
    if (remaining() > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private int remaining() {
    return this.seq.length() - this.pos;
  }
  
  public void close() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aconst_null
    //   4: putfield seq : Ljava/lang/CharSequence;
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  public void mark(int paramInt) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: iflt -> 11
    //   6: iconst_1
    //   7: istore_2
    //   8: goto -> 13
    //   11: iconst_0
    //   12: istore_2
    //   13: iload_2
    //   14: ldc 'readAheadLimit (%s) may not be negative'
    //   16: iload_1
    //   17: invokestatic checkArgument : (ZLjava/lang/String;I)V
    //   20: aload_0
    //   21: invokespecial checkOpen : ()V
    //   24: aload_0
    //   25: aload_0
    //   26: getfield pos : I
    //   29: putfield mark : I
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: astore_3
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_3
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   13	32	35	finally
  }
  
  public boolean markSupported() {
    return true;
  }
  
  public int read() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial checkOpen : ()V
    //   6: aload_0
    //   7: invokespecial hasRemaining : ()Z
    //   10: ifeq -> 41
    //   13: aload_0
    //   14: getfield seq : Ljava/lang/CharSequence;
    //   17: astore_1
    //   18: aload_0
    //   19: getfield pos : I
    //   22: istore_2
    //   23: aload_0
    //   24: iload_2
    //   25: iconst_1
    //   26: iadd
    //   27: putfield pos : I
    //   30: aload_1
    //   31: iload_2
    //   32: invokeinterface charAt : (I)C
    //   37: istore_2
    //   38: goto -> 43
    //   41: iconst_m1
    //   42: istore_2
    //   43: aload_0
    //   44: monitorexit
    //   45: iload_2
    //   46: ireturn
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Exception table:
    //   from	to	target	type
    //   2	38	47	finally
  }
  
  public int read(CharBuffer paramCharBuffer) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: invokespecial checkOpen : ()V
    //   11: aload_0
    //   12: invokespecial hasRemaining : ()Z
    //   15: istore_2
    //   16: iload_2
    //   17: ifne -> 24
    //   20: aload_0
    //   21: monitorexit
    //   22: iconst_m1
    //   23: ireturn
    //   24: aload_1
    //   25: invokevirtual remaining : ()I
    //   28: aload_0
    //   29: invokespecial remaining : ()I
    //   32: invokestatic min : (II)I
    //   35: istore_3
    //   36: iconst_0
    //   37: istore #4
    //   39: iload #4
    //   41: iload_3
    //   42: if_icmpge -> 85
    //   45: aload_0
    //   46: getfield seq : Ljava/lang/CharSequence;
    //   49: astore #5
    //   51: aload_0
    //   52: getfield pos : I
    //   55: istore #6
    //   57: aload_0
    //   58: iload #6
    //   60: iconst_1
    //   61: iadd
    //   62: putfield pos : I
    //   65: aload_1
    //   66: aload #5
    //   68: iload #6
    //   70: invokeinterface charAt : (I)C
    //   75: invokevirtual put : (C)Ljava/nio/CharBuffer;
    //   78: pop
    //   79: iinc #4, 1
    //   82: goto -> 39
    //   85: aload_0
    //   86: monitorexit
    //   87: iload_3
    //   88: ireturn
    //   89: astore_1
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_1
    //   93: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	89	finally
    //   24	36	89	finally
    //   45	79	89	finally
  }
  
  public int read(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_2
    //   3: iload_2
    //   4: iload_3
    //   5: iadd
    //   6: aload_1
    //   7: arraylength
    //   8: invokestatic checkPositionIndexes : (III)V
    //   11: aload_0
    //   12: invokespecial checkOpen : ()V
    //   15: aload_0
    //   16: invokespecial hasRemaining : ()Z
    //   19: istore #4
    //   21: iload #4
    //   23: ifne -> 30
    //   26: aload_0
    //   27: monitorexit
    //   28: iconst_m1
    //   29: ireturn
    //   30: iload_3
    //   31: aload_0
    //   32: invokespecial remaining : ()I
    //   35: invokestatic min : (II)I
    //   38: istore #5
    //   40: iconst_0
    //   41: istore_3
    //   42: iload_3
    //   43: iload #5
    //   45: if_icmpge -> 88
    //   48: aload_0
    //   49: getfield seq : Ljava/lang/CharSequence;
    //   52: astore #6
    //   54: aload_0
    //   55: getfield pos : I
    //   58: istore #7
    //   60: aload_0
    //   61: iload #7
    //   63: iconst_1
    //   64: iadd
    //   65: putfield pos : I
    //   68: aload_1
    //   69: iload_2
    //   70: iload_3
    //   71: iadd
    //   72: aload #6
    //   74: iload #7
    //   76: invokeinterface charAt : (I)C
    //   81: castore
    //   82: iinc #3, 1
    //   85: goto -> 42
    //   88: aload_0
    //   89: monitorexit
    //   90: iload #5
    //   92: ireturn
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	93	finally
    //   30	40	93	finally
    //   48	82	93	finally
  }
  
  public boolean ready() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial checkOpen : ()V
    //   6: aload_0
    //   7: monitorexit
    //   8: iconst_1
    //   9: ireturn
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	6	10	finally
  }
  
  public void reset() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial checkOpen : ()V
    //   6: aload_0
    //   7: aload_0
    //   8: getfield mark : I
    //   11: putfield pos : I
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	17	finally
  }
  
  public long skip(long paramLong) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: lload_1
    //   3: lconst_0
    //   4: lcmp
    //   5: iflt -> 13
    //   8: iconst_1
    //   9: istore_3
    //   10: goto -> 15
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: ldc 'n (%s) may not be negative'
    //   18: lload_1
    //   19: invokestatic checkArgument : (ZLjava/lang/String;J)V
    //   22: aload_0
    //   23: invokespecial checkOpen : ()V
    //   26: aload_0
    //   27: invokespecial remaining : ()I
    //   30: i2l
    //   31: lload_1
    //   32: invokestatic min : (JJ)J
    //   35: l2i
    //   36: istore #4
    //   38: aload_0
    //   39: aload_0
    //   40: getfield pos : I
    //   43: iload #4
    //   45: iadd
    //   46: putfield pos : I
    //   49: iload #4
    //   51: i2l
    //   52: lstore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: lload_1
    //   56: lreturn
    //   57: astore #5
    //   59: aload_0
    //   60: monitorexit
    //   61: aload #5
    //   63: athrow
    // Exception table:
    //   from	to	target	type
    //   15	49	57	finally
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\io\CharSequenceReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */