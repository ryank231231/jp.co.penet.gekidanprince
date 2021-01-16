package com.android.vending.billing.util;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.vending.licensing.util.Base64;
import com.google.android.vending.licensing.util.Base64DecoderException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class Security {
  private static final String KEY_FACTORY_ALGORITHM = "RSA";
  
  private static final String SIGNATURE_ALGORITHM = "SHA1withRSA";
  
  private static final String TAG = "IABUtil/Security";
  
  public static PublicKey generatePublicKey(String paramString) {
    try {
      byte[] arrayOfByte = Base64.decode(paramString);
      KeyFactory keyFactory = KeyFactory.getInstance("RSA");
      X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec();
      this(arrayOfByte);
      return keyFactory.generatePublic(x509EncodedKeySpec);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new RuntimeException(noSuchAlgorithmException);
    } catch (InvalidKeySpecException invalidKeySpecException) {
      Log.e("IABUtil/Security", "Invalid key specification.");
      throw new IllegalArgumentException(invalidKeySpecException);
    } catch (Base64DecoderException base64DecoderException) {
      Log.e("IABUtil/Security", "Base64 decoding failed.");
      throw new IllegalArgumentException(base64DecoderException);
    } 
  }
  
  public static boolean verify(PublicKey paramPublicKey, String paramString1, String paramString2) {
    try {
      Signature signature = Signature.getInstance("SHA1withRSA");
      signature.initVerify(paramPublicKey);
      signature.update(paramString1.getBytes());
      if (!signature.verify(Base64.decode(paramString2))) {
        Log.e("IABUtil/Security", "Signature verification failed.");
        return false;
      } 
      return true;
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      Log.e("IABUtil/Security", "NoSuchAlgorithmException.");
    } catch (InvalidKeyException invalidKeyException) {
      Log.e("IABUtil/Security", "Invalid key specification.");
    } catch (SignatureException signatureException) {
      Log.e("IABUtil/Security", "Signature exception.");
    } catch (Base64DecoderException base64DecoderException) {
      Log.e("IABUtil/Security", "Base64 decoding failed.");
    } 
    return false;
  }
  
  public static boolean verifyPurchase(String paramString1, String paramString2, String paramString3) {
    if (TextUtils.isEmpty(paramString2) || TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString3)) {
      Log.e("IABUtil/Security", "Purchase verification failed: missing data.");
      return false;
    } 
    return verify(generatePublicKey(paramString1), paramString2, paramString3);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\android\vending\billin\\util\Security.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */