package android.support.v4.content;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;

public final class IntentCompat {
  public static final String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";
  
  public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
  
  public static final String EXTRA_START_PLAYBACK = "android.intent.extra.START_PLAYBACK";
  
  @NonNull
  public static Intent makeMainSelectorActivity(@NonNull String paramString1, @NonNull String paramString2) {
    if (Build.VERSION.SDK_INT >= 15)
      return Intent.makeMainSelectorActivity(paramString1, paramString2); 
    Intent intent = new Intent(paramString1);
    intent.addCategory(paramString2);
    return intent;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\v4\content\IntentCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */