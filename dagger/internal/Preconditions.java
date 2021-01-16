package dagger.internal;

public final class Preconditions {
  public static <T> T checkNotNull(T paramT) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException();
  }
  
  public static <T> T checkNotNull(T paramT, String paramString) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(paramString);
  }
  
  public static <T> T checkNotNull(T paramT, String paramString, Object paramObject) {
    String str;
    if (paramT == null) {
      if (paramString.contains("%s")) {
        if (paramString.indexOf("%s") == paramString.lastIndexOf("%s")) {
          if (paramObject instanceof Class) {
            str = ((Class)paramObject).getCanonicalName();
          } else {
            str = String.valueOf(paramObject);
          } 
          throw new NullPointerException(paramString.replace("%s", str));
        } 
        throw new IllegalArgumentException("errorMessageTemplate has more than one format specifier");
      } 
      throw new IllegalArgumentException("errorMessageTemplate has no format specifiers");
    } 
    return (T)str;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\internal\Preconditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */