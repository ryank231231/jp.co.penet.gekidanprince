package com.google.firebase.inappmessaging.internal.injection.modules;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.annotation.NonNull;
import com.google.common.io.BaseEncoding;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServingGrpc;
import dagger.Module;
import dagger.Provides;
import io.grpc.Channel;
import io.grpc.ClientInterceptor;
import io.grpc.ClientInterceptors;
import io.grpc.Metadata;
import io.grpc.stub.MetadataUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Module
public class GrpcClientModule {
  private final FirebaseApp firebaseApp;
  
  public GrpcClientModule(FirebaseApp paramFirebaseApp) {
    this.firebaseApp = paramFirebaseApp;
  }
  
  public static String getSignature(@NonNull PackageManager paramPackageManager, @NonNull String paramString) {
    try {
      PackageInfo packageInfo = paramPackageManager.getPackageInfo(paramString, 64);
      return (packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length == 0 || packageInfo.signatures[0] == null) ? null : signatureDigest(packageInfo.signatures[0]);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return null;
    } 
  }
  
  private static String signatureDigest(Signature paramSignature) {
    byte[] arrayOfByte = paramSignature.toByteArray();
    try {
      arrayOfByte = MessageDigest.getInstance("SHA1").digest(arrayOfByte);
      return BaseEncoding.base16().upperCase().encode(arrayOfByte);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      return null;
    } 
  }
  
  @Provides
  public Metadata providesApiKeyHeaders() {
    Metadata.Key key1 = Metadata.Key.of("X-Goog-Api-Key", Metadata.ASCII_STRING_MARSHALLER);
    Metadata.Key key2 = Metadata.Key.of("X-Android-Package", Metadata.ASCII_STRING_MARSHALLER);
    Metadata.Key key3 = Metadata.Key.of("X-Android-Cert", Metadata.ASCII_STRING_MARSHALLER);
    Metadata metadata = new Metadata();
    String str2 = this.firebaseApp.getApplicationContext().getPackageName();
    metadata.put(key1, this.firebaseApp.getOptions().getApiKey());
    metadata.put(key2, str2);
    String str1 = getSignature(this.firebaseApp.getApplicationContext().getPackageManager(), str2);
    if (str1 != null)
      metadata.put(key3, str1); 
    return metadata;
  }
  
  @Provides
  @FirebaseAppScope
  public InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub providesInAppMessagingSdkServingStub(Channel paramChannel, Metadata paramMetadata) {
    return InAppMessagingSdkServingGrpc.newBlockingStub(ClientInterceptors.intercept(paramChannel, new ClientInterceptor[] { MetadataUtils.newAttachHeadersInterceptor(paramMetadata) }));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\GrpcClientModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */