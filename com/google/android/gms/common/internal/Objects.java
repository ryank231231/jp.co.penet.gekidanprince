package com.google.android.gms.common.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@KeepForSdk
public final class Objects {
  private Objects() {
    throw new AssertionError("Uninstantiable");
  }
  
  @KeepForSdk
  public static boolean equal(@Nullable Object paramObject1, @Nullable Object paramObject2) {
    return (paramObject1 == paramObject2 || (paramObject1 != null && paramObject1.equals(paramObject2)));
  }
  
  @KeepForSdk
  public static int hashCode(Object... paramVarArgs) {
    return Arrays.hashCode(paramVarArgs);
  }
  
  @KeepForSdk
  public static ToStringHelper toStringHelper(Object paramObject) {
    return new ToStringHelper(paramObject, null);
  }
  
  @KeepForSdk
  public static final class ToStringHelper {
    private final List<String> zzer;
    
    private final Object zzes;
    
    private ToStringHelper(Object param1Object) {
      this.zzes = Preconditions.checkNotNull(param1Object);
      this.zzer = new ArrayList<String>();
    }
    
    @KeepForSdk
    public final ToStringHelper add(String param1String, @Nullable Object param1Object) {
      List<String> list = this.zzer;
      param1String = Preconditions.<String>checkNotNull(param1String);
      String str = String.valueOf(param1Object);
      param1Object = new StringBuilder(String.valueOf(param1String).length() + 1 + String.valueOf(str).length());
      param1Object.append(param1String);
      param1Object.append("=");
      param1Object.append(str);
      list.add(param1Object.toString());
      return this;
    }
    
    @KeepForSdk
    public final String toString() {
      StringBuilder stringBuilder = new StringBuilder(100);
      stringBuilder.append(this.zzes.getClass().getSimpleName());
      stringBuilder.append('{');
      int i = this.zzer.size();
      for (byte b = 0; b < i; b++) {
        stringBuilder.append(this.zzer.get(b));
        if (b < i - 1)
          stringBuilder.append(", "); 
      } 
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\Objects.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */