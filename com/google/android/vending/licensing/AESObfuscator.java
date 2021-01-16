package com.google.android.vending.licensing;

import com.google.android.vending.licensing.util.Base64;
import com.google.android.vending.licensing.util.Base64DecoderException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class AESObfuscator implements Obfuscator {
  private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
  
  private static final byte[] IV = new byte[] { 
      16, 74, 71, -80, 32, 101, -47, 72, 117, -14, 
      0, -29, 70, 65, -12, 74 };
  
  private static final String KEYGEN_ALGORITHM = "PBEWITHSHAAND256BITAES-CBC-BC";
  
  private static final String UTF8 = "UTF-8";
  
  private static final String header = "com.android.vending.licensing.AESObfuscator-1|";
  
  private Cipher mDecryptor;
  
  private Cipher mEncryptor;
  
  public AESObfuscator(byte[] paramArrayOfbyte, String paramString1, String paramString2) {
    try {
      SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBEWITHSHAAND256BITAES-CBC-BC");
      PBEKeySpec pBEKeySpec = new PBEKeySpec();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append(paramString1);
      stringBuilder.append(paramString2);
      this(stringBuilder.toString().toCharArray(), paramArrayOfbyte, 1024, 256);
      SecretKey secretKey = secretKeyFactory.generateSecret(pBEKeySpec);
      SecretKeySpec secretKeySpec = new SecretKeySpec();
      this(secretKey.getEncoded(), "AES");
      this.mEncryptor = Cipher.getInstance("AES/CBC/PKCS5Padding");
      Cipher cipher = this.mEncryptor;
      IvParameterSpec ivParameterSpec = new IvParameterSpec();
      this(IV);
      cipher.init(1, secretKeySpec, ivParameterSpec);
      this.mDecryptor = Cipher.getInstance("AES/CBC/PKCS5Padding");
      cipher = this.mDecryptor;
      ivParameterSpec = new IvParameterSpec();
      this(IV);
      cipher.init(2, secretKeySpec, ivParameterSpec);
      return;
    } catch (GeneralSecurityException generalSecurityException) {
      throw new RuntimeException("Invalid environment", generalSecurityException);
    } 
  }
  
  public String obfuscate(String paramString1, String paramString2) {
    if (paramString1 == null)
      return null; 
    try {
      Cipher cipher = this.mEncryptor;
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("com.android.vending.licensing.AESObfuscator-1|");
      stringBuilder.append(paramString2);
      stringBuilder.append(paramString1);
      return Base64.encode(cipher.doFinal(stringBuilder.toString().getBytes("UTF-8")));
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new RuntimeException("Invalid environment", unsupportedEncodingException);
    } catch (GeneralSecurityException generalSecurityException) {
      throw new RuntimeException("Invalid environment", generalSecurityException);
    } 
  }
  
  public String unobfuscate(String paramString1, String paramString2) throws ValidationException {
    if (paramString1 == null)
      return null; 
    try {
      String str = new String();
      this(this.mDecryptor.doFinal(Base64.decode(paramString1)), "UTF-8");
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("com.android.vending.licensing.AESObfuscator-1|");
      stringBuilder.append(paramString2);
      if (str.indexOf(stringBuilder.toString()) == 0)
        return str.substring(46 + paramString2.length(), str.length()); 
      ValidationException validationException = new ValidationException();
      stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("Header not found (invalid data or key):");
      stringBuilder.append(paramString1);
      this(stringBuilder.toString());
      throw validationException;
    } catch (Base64DecoderException base64DecoderException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(base64DecoderException.getMessage());
      stringBuilder.append(":");
      stringBuilder.append(paramString1);
      throw new ValidationException(stringBuilder.toString());
    } catch (IllegalBlockSizeException illegalBlockSizeException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(illegalBlockSizeException.getMessage());
      stringBuilder.append(":");
      stringBuilder.append(paramString1);
      throw new ValidationException(stringBuilder.toString());
    } catch (BadPaddingException badPaddingException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(badPaddingException.getMessage());
      stringBuilder.append(":");
      stringBuilder.append(paramString1);
      throw new ValidationException(stringBuilder.toString());
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new RuntimeException("Invalid environment", unsupportedEncodingException);
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\vending\licensing\AESObfuscator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */