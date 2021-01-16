package okio;

public final class Utf8 {
  public static long size(String paramString) {
    return size(paramString, 0, paramString.length());
  }
  
  public static long size(String paramString, int paramInt1, int paramInt2) {
    if (paramString != null) {
      if (paramInt1 >= 0) {
        if (paramInt2 >= paramInt1) {
          if (paramInt2 <= paramString.length()) {
            long l = 0L;
            while (paramInt1 < paramInt2) {
              byte b;
              char c = paramString.charAt(paramInt1);
              if (c < '') {
                l++;
                paramInt1++;
                continue;
              } 
              if (c < 'ࠀ') {
                l += 2L;
                paramInt1++;
                continue;
              } 
              if (c < '?' || c > '?') {
                l += 3L;
                paramInt1++;
                continue;
              } 
              int i = paramInt1 + 1;
              if (i < paramInt2) {
                b = paramString.charAt(i);
              } else {
                b = 0;
              } 
              if (c > '?' || b < '?' || b > '?') {
                l++;
                paramInt1 = i;
                continue;
              } 
              l += 4L;
              paramInt1 += 2;
            } 
            return l;
          } 
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("endIndex > string.length: ");
          stringBuilder2.append(paramInt2);
          stringBuilder2.append(" > ");
          stringBuilder2.append(paramString.length());
          throw new IllegalArgumentException(stringBuilder2.toString());
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("endIndex < beginIndex: ");
        stringBuilder1.append(paramInt2);
        stringBuilder1.append(" < ");
        stringBuilder1.append(paramInt1);
        throw new IllegalArgumentException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("beginIndex < 0: ");
      stringBuilder.append(paramInt1);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    throw new IllegalArgumentException("string == null");
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\okio\Utf8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */