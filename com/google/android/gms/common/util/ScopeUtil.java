package com.google.android.gms.common.util;

import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@KeepForSdk
public final class ScopeUtil {
  @KeepForSdk
  public static Set<Scope> fromScopeString(Collection<String> paramCollection) {
    Preconditions.checkNotNull(paramCollection, "scopeStrings can't be null.");
    return fromScopeString(paramCollection.<String>toArray(new String[paramCollection.size()]));
  }
  
  @KeepForSdk
  public static Set<Scope> fromScopeString(String... paramVarArgs) {
    Preconditions.checkNotNull(paramVarArgs, "scopeStrings can't be null.");
    HashSet<Scope> hashSet = new HashSet(paramVarArgs.length);
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++) {
      String str = paramVarArgs[b];
      if (!TextUtils.isEmpty(str))
        hashSet.add(new Scope(str)); 
    } 
    return hashSet;
  }
  
  @KeepForSdk
  public static String[] toScopeString(Set<Scope> paramSet) {
    Preconditions.checkNotNull(paramSet, "scopes can't be null.");
    return toScopeString(paramSet.<Scope>toArray(new Scope[paramSet.size()]));
  }
  
  @KeepForSdk
  public static String[] toScopeString(Scope[] paramArrayOfScope) {
    Preconditions.checkNotNull(paramArrayOfScope, "scopes can't be null.");
    String[] arrayOfString = new String[paramArrayOfScope.length];
    for (byte b = 0; b < paramArrayOfScope.length; b++)
      arrayOfString[b] = paramArrayOfScope[b].getScopeUri(); 
    return arrayOfString;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\commo\\util\ScopeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */