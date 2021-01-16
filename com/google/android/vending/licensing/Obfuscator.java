package com.google.android.vending.licensing;

public interface Obfuscator {
  String obfuscate(String paramString1, String paramString2);
  
  String unobfuscate(String paramString1, String paramString2) throws ValidationException;
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\vending\licensing\Obfuscator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */