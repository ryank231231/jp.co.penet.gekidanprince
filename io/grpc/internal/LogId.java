package io.grpc.internal;

import java.util.concurrent.atomic.AtomicLong;

public final class LogId {
  private static final AtomicLong idAlloc = new AtomicLong();
  
  private final long id;
  
  private final String tag;
  
  protected LogId(String paramString, long paramLong) {
    this.tag = paramString;
    this.id = paramLong;
  }
  
  public static LogId allocate(String paramString) {
    return new LogId(paramString, getNextId());
  }
  
  static long getNextId() {
    return idAlloc.incrementAndGet();
  }
  
  public long getId() {
    return this.id;
  }
  
  public String getTag() {
    return this.tag;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.tag);
    stringBuilder.append("-");
    stringBuilder.append(this.id);
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\LogId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */