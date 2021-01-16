package com.google.android.vending.licensing;

import android.content.SharedPreferences;
import android.util.Log;

public class PreferenceObfuscator {
  private static final String TAG = "PreferenceObfuscator";
  
  private SharedPreferences.Editor mEditor;
  
  private final Obfuscator mObfuscator;
  
  private final SharedPreferences mPreferences;
  
  public PreferenceObfuscator(SharedPreferences paramSharedPreferences, Obfuscator paramObfuscator) {
    this.mPreferences = paramSharedPreferences;
    this.mObfuscator = paramObfuscator;
    this.mEditor = null;
  }
  
  public void commit() {
    SharedPreferences.Editor editor = this.mEditor;
    if (editor != null) {
      editor.commit();
      this.mEditor = null;
    } 
  }
  
  public String getString(String paramString1, String paramString2) {
    String str1 = this.mPreferences.getString(paramString1, null);
    String str2 = paramString2;
    if (str1 != null)
      try {
        str2 = this.mObfuscator.unobfuscate(str1, paramString1);
      } catch (ValidationException validationException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Validation error while reading preference: ");
        stringBuilder.append(paramString1);
        Log.w("PreferenceObfuscator", stringBuilder.toString());
        str2 = paramString2;
      }  
    return str2;
  }
  
  public void putString(String paramString1, String paramString2) {
    if (this.mEditor == null)
      this.mEditor = this.mPreferences.edit(); 
    paramString2 = this.mObfuscator.obfuscate(paramString2, paramString1);
    this.mEditor.putString(paramString1, paramString2);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\vending\licensing\PreferenceObfuscator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */