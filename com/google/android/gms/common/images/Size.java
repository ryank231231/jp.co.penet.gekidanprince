package com.google.android.gms.common.images;

public final class Size {
  private final int zand;
  
  private final int zane;
  
  public Size(int paramInt1, int paramInt2) {
    this.zand = paramInt1;
    this.zane = paramInt2;
  }
  
  public static Size parseSize(String paramString) throws NumberFormatException {
    if (paramString != null) {
      int i = paramString.indexOf('*');
      int j = i;
      if (i < 0)
        j = paramString.indexOf('x'); 
      if (j >= 0)
        try {
          return new Size(Integer.parseInt(paramString.substring(0, j)), Integer.parseInt(paramString.substring(j + 1)));
        } catch (NumberFormatException numberFormatException) {
          throw zah(paramString);
        }  
      throw zah(paramString);
    } 
    throw new IllegalArgumentException("string must not be null");
  }
  
  private static NumberFormatException zah(String paramString) {
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString).length() + 16);
    stringBuilder.append("Invalid Size: \"");
    stringBuilder.append(paramString);
    stringBuilder.append("\"");
    throw new NumberFormatException(stringBuilder.toString());
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == null)
      return false; 
    if (this == paramObject)
      return true; 
    if (paramObject instanceof Size) {
      paramObject = paramObject;
      return (this.zand == ((Size)paramObject).zand && this.zane == ((Size)paramObject).zane);
    } 
    return false;
  }
  
  public final int getHeight() {
    return this.zane;
  }
  
  public final int getWidth() {
    return this.zand;
  }
  
  public final int hashCode() {
    int i = this.zane;
    int j = this.zand;
    return i ^ (j >>> 16 | j << 16);
  }
  
  public final String toString() {
    int i = this.zand;
    int j = this.zane;
    StringBuilder stringBuilder = new StringBuilder(23);
    stringBuilder.append(i);
    stringBuilder.append("x");
    stringBuilder.append(j);
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\images\Size.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */