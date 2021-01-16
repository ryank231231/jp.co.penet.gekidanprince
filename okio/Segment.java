package okio;

import javax.annotation.Nullable;

final class Segment {
  static final int SHARE_MINIMUM = 1024;
  
  static final int SIZE = 8192;
  
  final byte[] data = new byte[8192];
  
  int limit;
  
  Segment next;
  
  boolean owner;
  
  int pos;
  
  Segment prev;
  
  boolean shared;
  
  Segment() {
    this.owner = true;
    this.shared = false;
  }
  
  Segment(Segment paramSegment) {
    this(paramSegment.data, paramSegment.pos, paramSegment.limit);
    paramSegment.shared = true;
  }
  
  Segment(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    this.pos = paramInt1;
    this.limit = paramInt2;
    this.owner = false;
    this.shared = true;
  }
  
  public void compact() {
    Segment segment = this.prev;
    if (segment != this) {
      int k;
      if (!segment.owner)
        return; 
      int i = this.limit - this.pos;
      int j = segment.limit;
      if (segment.shared) {
        k = 0;
      } else {
        k = segment.pos;
      } 
      if (i > 8192 - j + k)
        return; 
      writeTo(this.prev, i);
      pop();
      SegmentPool.recycle(this);
      return;
    } 
    throw new IllegalStateException();
  }
  
  @Nullable
  public Segment pop() {
    Segment segment1 = this.next;
    if (segment1 == this)
      segment1 = null; 
    Segment segment2 = this.prev;
    segment2.next = this.next;
    this.next.prev = segment2;
    this.next = null;
    this.prev = null;
    return segment1;
  }
  
  public Segment push(Segment paramSegment) {
    paramSegment.prev = this;
    paramSegment.next = this.next;
    this.next.prev = paramSegment;
    this.next = paramSegment;
    return paramSegment;
  }
  
  public Segment split(int paramInt) {
    if (paramInt > 0 && paramInt <= this.limit - this.pos) {
      Segment segment;
      if (paramInt >= 1024) {
        segment = new Segment(this);
      } else {
        segment = SegmentPool.take();
        System.arraycopy(this.data, this.pos, segment.data, 0, paramInt);
      } 
      segment.limit = segment.pos + paramInt;
      this.pos += paramInt;
      this.prev.push(segment);
      return segment;
    } 
    throw new IllegalArgumentException();
  }
  
  public void writeTo(Segment paramSegment, int paramInt) {
    if (paramSegment.owner) {
      int i = paramSegment.limit;
      if (i + paramInt > 8192)
        if (!paramSegment.shared) {
          int j = paramSegment.pos;
          if (i + paramInt - j <= 8192) {
            byte[] arrayOfByte = paramSegment.data;
            System.arraycopy(arrayOfByte, j, arrayOfByte, 0, i - j);
            paramSegment.limit -= paramSegment.pos;
            paramSegment.pos = 0;
          } else {
            throw new IllegalArgumentException();
          } 
        } else {
          throw new IllegalArgumentException();
        }  
      System.arraycopy(this.data, this.pos, paramSegment.data, paramSegment.limit, paramInt);
      paramSegment.limit += paramInt;
      this.pos += paramInt;
      return;
    } 
    throw new IllegalArgumentException();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\okio\Segment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */