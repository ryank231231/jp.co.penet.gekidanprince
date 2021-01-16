package com.google.android.gms.internal.clearcut;

final class zzee {
  private final String info;
  
  private int position;
  
  zzee(String paramString) {
    this.info = paramString;
    this.position = 0;
  }
  
  final boolean hasNext() {
    return (this.position < this.info.length());
  }
  
  final int next() {
    String str = this.info;
    int i = this.position;
    this.position = i + 1;
    i = str.charAt(i);
    if (i < 55296)
      return i; 
    int j = i & 0x1FFF;
    i = 13;
    while (true) {
      str = this.info;
      int k = this.position;
      this.position = k + 1;
      k = str.charAt(k);
      if (k >= 55296) {
        j |= (k & 0x1FFF) << i;
        i += 13;
        continue;
      } 
      return j | k << i;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */