package io.opencensus.tags;

import com.google.common.base.Preconditions;
import io.opencensus.internal.StringUtil;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class TagKey {
  public static final int MAX_LENGTH = 255;
  
  public static TagKey create(String paramString) {
    Preconditions.checkArgument(isValid(paramString));
    return new AutoValue_TagKey(paramString);
  }
  
  private static boolean isValid(String paramString) {
    boolean bool;
    if (!paramString.isEmpty() && paramString.length() <= 255 && StringUtil.isPrintableString(paramString)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public abstract String getName();
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\tags\TagKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */