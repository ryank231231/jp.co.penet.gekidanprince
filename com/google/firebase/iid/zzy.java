package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.firebase_messaging.zzg;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;

final class zzy {
  @Nullable
  private final zzz zza(Context paramContext, String paramString, zzz paramzzz, boolean paramBoolean) {
    if (Log.isLoggable("FirebaseInstanceId", 3))
      Log.d("FirebaseInstanceId", "Writing key to properties file"); 
    Properties properties = new Properties();
    properties.setProperty("pub", zzz.zza(paramzzz));
    properties.setProperty("pri", zzz.zzb(paramzzz));
    properties.setProperty("cre", String.valueOf(zzz.zzc(paramzzz)));
    File file = zzf(paramContext, paramString);
    try {
      file.createNewFile();
      RandomAccessFile randomAccessFile = new RandomAccessFile();
      this(file, "rw");
      try {
        FileChannel fileChannel = randomAccessFile.getChannel();
        try {
          fileChannel.lock();
          if (paramBoolean) {
            long l = fileChannel.size();
            if (l > 0L) {
              try {
                fileChannel.position(0L);
                return zza(fileChannel);
              } catch (IOException iOException) {
              
              } catch (zzaa zzaa) {}
              if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String str = String.valueOf(zzaa);
                int i = String.valueOf(str).length();
                StringBuilder stringBuilder = new StringBuilder();
                this(i + 64);
                stringBuilder.append("Tried reading key pair before writing new one, but failed with: ");
                stringBuilder.append(str);
                Log.d("FirebaseInstanceId", stringBuilder.toString());
              } 
            } 
          } 
          fileChannel.position(0L);
          properties.store(Channels.newOutputStream(fileChannel), (String)null);
          return paramzzz;
        } catch (Throwable throwable) {
          try {
            throw throwable;
          } finally {}
        } finally {
          file = null;
        } 
        if (fileChannel != null)
          zza((Throwable)paramString, fileChannel); 
        throw file;
      } catch (Throwable throwable) {
        try {
          throw throwable;
        } finally {
          zzz zzz1;
          paramzzz = null;
          Throwable throwable1 = throwable;
        } 
      } finally {
        file = null;
      } 
      zza((Throwable)paramString, randomAccessFile);
      throw file;
    } catch (IOException iOException) {
      String str = String.valueOf(iOException);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 21);
      stringBuilder.append("Failed to write key: ");
      stringBuilder.append(str);
      Log.w("FirebaseInstanceId", stringBuilder.toString());
      return null;
    } 
  }
  
  @Nullable
  private static zzz zza(SharedPreferences paramSharedPreferences, String paramString) throws zzaa {
    String str1 = paramSharedPreferences.getString(zzaw.zzd(paramString, "|P|"), null);
    String str2 = paramSharedPreferences.getString(zzaw.zzd(paramString, "|K|"), null);
    return (str1 == null || str2 == null) ? null : new zzz(zzc(str1, str2), zzb(paramSharedPreferences, paramString));
  }
  
  private final zzz zza(File paramFile) throws zzaa, IOException {
    Throwable throwable1;
    Throwable throwable2;
    FileInputStream fileInputStream = new FileInputStream(paramFile);
    File file = null;
    paramFile = file;
    try {
      Throwable throwable;
      FileChannel fileChannel = fileInputStream.getChannel();
      try {
        fileChannel.lock(0L, Long.MAX_VALUE, true);
        zzz zzz = zza(fileChannel);
        if (fileChannel != null) {
          paramFile = file;
          zza((Throwable)null, fileChannel);
        } 
        return zzz;
      } catch (Throwable null) {
        try {
          throw throwable;
        } finally {}
      } finally {
        throwable2 = null;
      } 
      if (fileChannel != null) {
        paramFile = file;
        zza(throwable, fileChannel);
      } 
      paramFile = file;
      throw throwable2;
    } catch (Throwable null) {
      throwable1 = throwable2;
      throw throwable2;
    } finally {}
    zza(throwable1, fileInputStream);
    throw throwable2;
  }
  
  private static zzz zza(FileChannel paramFileChannel) throws zzaa, IOException {
    Properties properties = new Properties();
    properties.load(Channels.newInputStream(paramFileChannel));
    String str1 = properties.getProperty("pub");
    String str2 = properties.getProperty("pri");
    if (str1 != null && str2 != null) {
      KeyPair keyPair = zzc(str1, str2);
      try {
        long l = Long.parseLong(properties.getProperty("cre"));
        return new zzz(keyPair, l);
      } catch (NumberFormatException numberFormatException) {
        throw new zzaa(numberFormatException);
      } 
    } 
    throw new zzaa("Invalid properties file");
  }
  
  static void zza(Context paramContext) {
    for (File file : zzb(paramContext).listFiles()) {
      if (file.getName().startsWith("com.google.InstanceId"))
        file.delete(); 
    } 
  }
  
  private final void zza(Context paramContext, String paramString, zzz paramzzz) {
    SharedPreferences sharedPreferences = paramContext.getSharedPreferences("com.google.android.gms.appid", 0);
    try {
      boolean bool = paramzzz.equals(zza(sharedPreferences, paramString));
      if (bool)
        return; 
    } catch (zzaa zzaa) {}
    if (Log.isLoggable("FirebaseInstanceId", 3))
      Log.d("FirebaseInstanceId", "Writing key to shared preferences"); 
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putString(zzaw.zzd(paramString, "|P|"), zzz.zza(paramzzz));
    editor.putString(zzaw.zzd(paramString, "|K|"), zzz.zzb(paramzzz));
    editor.putString(zzaw.zzd(paramString, "cre"), String.valueOf(zzz.zzc(paramzzz)));
    editor.commit();
  }
  
  private static long zzb(SharedPreferences paramSharedPreferences, String paramString) {
    String str = paramSharedPreferences.getString(zzaw.zzd(paramString, "cre"), null);
    if (str != null)
      try {
        return Long.parseLong(str);
      } catch (NumberFormatException numberFormatException) {} 
    return 0L;
  }
  
  private static File zzb(Context paramContext) {
    File file = ContextCompat.getNoBackupFilesDir(paramContext);
    if (file != null && file.isDirectory())
      return file; 
    Log.w("FirebaseInstanceId", "noBackupFilesDir doesn't exist, using regular files directory instead");
    return paramContext.getFilesDir();
  }
  
  private static KeyPair zzc(String paramString1, String paramString2) throws zzaa {
    try {
      byte[] arrayOfByte2 = Base64.decode(paramString1, 8);
      byte[] arrayOfByte1 = Base64.decode(paramString2, 8);
      try {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec();
        this(arrayOfByte2);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec();
        this(arrayOfByte1);
        return new KeyPair(publicKey, keyFactory.generatePrivate(pKCS8EncodedKeySpec));
      } catch (InvalidKeySpecException invalidKeySpecException) {
      
      } catch (NoSuchAlgorithmException noSuchAlgorithmException) {}
      String str = String.valueOf(noSuchAlgorithmException);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 19);
      stringBuilder.append("Invalid key stored ");
      stringBuilder.append(str);
      Log.w("FirebaseInstanceId", stringBuilder.toString());
      throw new zzaa(noSuchAlgorithmException);
    } catch (IllegalArgumentException illegalArgumentException) {
      throw new zzaa(illegalArgumentException);
    } 
  }
  
  @Nullable
  private final zzz zzd(Context paramContext, String paramString) throws zzaa {
    try {
      zzz zzz = zze(paramContext, paramString);
      if (zzz != null) {
        zza(paramContext, paramString, zzz);
        return zzz;
      } 
      zzz = null;
    } catch (zzaa null) {}
    try {
      zzz zzz = zza(paramContext.getSharedPreferences("com.google.android.gms.appid", 0), paramString);
      if (zzz != null) {
        zza(paramContext, paramString, zzz, false);
        return zzz;
      } 
    } catch (zzaa zzaa) {}
    if (zzaa == null)
      return null; 
    throw zzaa;
  }
  
  @Nullable
  private final zzz zze(Context paramContext, String paramString) throws zzaa {
    File file = zzf(paramContext, paramString);
    if (!file.exists())
      return null; 
    try {
      return zza(file);
    } catch (zzaa zzaa) {
    
    } catch (IOException iOException) {}
    if (Log.isLoggable("FirebaseInstanceId", 3)) {
      String str = String.valueOf(iOException);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 40);
      stringBuilder.append("Failed to read key from file, retrying: ");
      stringBuilder.append(str);
      Log.d("FirebaseInstanceId", stringBuilder.toString());
    } 
    try {
      return zza(file);
    } catch (IOException iOException1) {
      String str = String.valueOf(iOException1);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 45);
      stringBuilder.append("IID file exists, but failed to read from it: ");
      stringBuilder.append(str);
      Log.w("FirebaseInstanceId", stringBuilder.toString());
      throw new zzaa(iOException1);
    } 
  }
  
  private static File zzf(Context paramContext, String paramString) {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      paramString = "com.google.InstanceId.properties";
    } else {
      try {
        String str1 = Base64.encodeToString(paramString.getBytes("UTF-8"), 11);
        int i = String.valueOf(str1).length();
        StringBuilder stringBuilder = new StringBuilder();
        this(i + 33);
        stringBuilder.append("com.google.InstanceId_");
        stringBuilder.append(str1);
        stringBuilder.append(".properties");
        str = stringBuilder.toString();
        return new File(zzb(paramContext), str);
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        throw new AssertionError(unsupportedEncodingException);
      } 
    } 
    return new File(zzb((Context)unsupportedEncodingException), str);
  }
  
  @WorkerThread
  final zzz zzb(Context paramContext, String paramString) throws zzaa {
    zzz zzz = zzd(paramContext, paramString);
    return (zzz != null) ? zzz : zzc(paramContext, paramString);
  }
  
  @WorkerThread
  final zzz zzc(Context paramContext, String paramString) {
    zzz zzz1 = new zzz(zza.zzc(), System.currentTimeMillis());
    zzz zzz2 = zza(paramContext, paramString, zzz1, true);
    if (zzz2 != null && !zzz2.equals(zzz1)) {
      if (Log.isLoggable("FirebaseInstanceId", 3))
        Log.d("FirebaseInstanceId", "Loaded key after generating new one, using loaded one"); 
      return zzz2;
    } 
    if (Log.isLoggable("FirebaseInstanceId", 3))
      Log.d("FirebaseInstanceId", "Generated new key"); 
    zza(paramContext, paramString, zzz1);
    return zzz1;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\iid\zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */