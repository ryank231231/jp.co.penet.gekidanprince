package com.google.firebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;
import com.google.firebase.annotations.PublicApi;

@PublicApi
public final class FirebaseOptions {
  private static final String API_KEY_RESOURCE_NAME = "google_api_key";
  
  private static final String APP_ID_RESOURCE_NAME = "google_app_id";
  
  private static final String DATABASE_URL_RESOURCE_NAME = "firebase_database_url";
  
  private static final String GA_TRACKING_ID_RESOURCE_NAME = "ga_trackingId";
  
  private static final String GCM_SENDER_ID_RESOURCE_NAME = "gcm_defaultSenderId";
  
  private static final String PROJECT_ID_RESOURCE_NAME = "project_id";
  
  private static final String STORAGE_BUCKET_RESOURCE_NAME = "google_storage_bucket";
  
  private final String apiKey;
  
  private final String applicationId;
  
  private final String databaseUrl;
  
  private final String gaTrackingId;
  
  private final String gcmSenderId;
  
  private final String projectId;
  
  private final String storageBucket;
  
  private FirebaseOptions(@NonNull String paramString1, @NonNull String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5, @Nullable String paramString6, @Nullable String paramString7) {
    Preconditions.checkState(Strings.isEmptyOrWhitespace(paramString1) ^ true, "ApplicationId must be set.");
    this.applicationId = paramString1;
    this.apiKey = paramString2;
    this.databaseUrl = paramString3;
    this.gaTrackingId = paramString4;
    this.gcmSenderId = paramString5;
    this.storageBucket = paramString6;
    this.projectId = paramString7;
  }
  
  @PublicApi
  public static FirebaseOptions fromResource(Context paramContext) {
    StringResourceValueReader stringResourceValueReader = new StringResourceValueReader(paramContext);
    String str = stringResourceValueReader.getString("google_app_id");
    return TextUtils.isEmpty(str) ? null : new FirebaseOptions(str, stringResourceValueReader.getString("google_api_key"), stringResourceValueReader.getString("firebase_database_url"), stringResourceValueReader.getString("ga_trackingId"), stringResourceValueReader.getString("gcm_defaultSenderId"), stringResourceValueReader.getString("google_storage_bucket"), stringResourceValueReader.getString("project_id"));
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof FirebaseOptions;
    boolean bool1 = false;
    if (!bool)
      return false; 
    paramObject = paramObject;
    bool = bool1;
    if (Objects.equal(this.applicationId, ((FirebaseOptions)paramObject).applicationId)) {
      bool = bool1;
      if (Objects.equal(this.apiKey, ((FirebaseOptions)paramObject).apiKey)) {
        bool = bool1;
        if (Objects.equal(this.databaseUrl, ((FirebaseOptions)paramObject).databaseUrl)) {
          bool = bool1;
          if (Objects.equal(this.gaTrackingId, ((FirebaseOptions)paramObject).gaTrackingId)) {
            bool = bool1;
            if (Objects.equal(this.gcmSenderId, ((FirebaseOptions)paramObject).gcmSenderId)) {
              bool = bool1;
              if (Objects.equal(this.storageBucket, ((FirebaseOptions)paramObject).storageBucket)) {
                bool = bool1;
                if (Objects.equal(this.projectId, ((FirebaseOptions)paramObject).projectId))
                  bool = true; 
              } 
            } 
          } 
        } 
      } 
    } 
    return bool;
  }
  
  @PublicApi
  public String getApiKey() {
    return this.apiKey;
  }
  
  @PublicApi
  public String getApplicationId() {
    return this.applicationId;
  }
  
  @PublicApi
  public String getDatabaseUrl() {
    return this.databaseUrl;
  }
  
  @KeepForSdk
  public String getGaTrackingId() {
    return this.gaTrackingId;
  }
  
  @PublicApi
  public String getGcmSenderId() {
    return this.gcmSenderId;
  }
  
  @PublicApi
  public String getProjectId() {
    return this.projectId;
  }
  
  @PublicApi
  public String getStorageBucket() {
    return this.storageBucket;
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { this.applicationId, this.apiKey, this.databaseUrl, this.gaTrackingId, this.gcmSenderId, this.storageBucket, this.projectId });
  }
  
  public String toString() {
    return Objects.toStringHelper(this).add("applicationId", this.applicationId).add("apiKey", this.apiKey).add("databaseUrl", this.databaseUrl).add("gcmSenderId", this.gcmSenderId).add("storageBucket", this.storageBucket).add("projectId", this.projectId).toString();
  }
  
  @PublicApi
  public static final class Builder {
    private String apiKey;
    
    private String applicationId;
    
    private String databaseUrl;
    
    private String gaTrackingId;
    
    private String gcmSenderId;
    
    private String projectId;
    
    private String storageBucket;
    
    @PublicApi
    public Builder() {}
    
    @PublicApi
    public Builder(FirebaseOptions param1FirebaseOptions) {
      this.applicationId = param1FirebaseOptions.applicationId;
      this.apiKey = param1FirebaseOptions.apiKey;
      this.databaseUrl = param1FirebaseOptions.databaseUrl;
      this.gaTrackingId = param1FirebaseOptions.gaTrackingId;
      this.gcmSenderId = param1FirebaseOptions.gcmSenderId;
      this.storageBucket = param1FirebaseOptions.storageBucket;
      this.projectId = param1FirebaseOptions.projectId;
    }
    
    @PublicApi
    public FirebaseOptions build() {
      return new FirebaseOptions(this.applicationId, this.apiKey, this.databaseUrl, this.gaTrackingId, this.gcmSenderId, this.storageBucket, this.projectId);
    }
    
    @PublicApi
    public Builder setApiKey(@NonNull String param1String) {
      this.apiKey = Preconditions.checkNotEmpty(param1String, "ApiKey must be set.");
      return this;
    }
    
    @PublicApi
    public Builder setApplicationId(@NonNull String param1String) {
      this.applicationId = Preconditions.checkNotEmpty(param1String, "ApplicationId must be set.");
      return this;
    }
    
    @PublicApi
    public Builder setDatabaseUrl(@Nullable String param1String) {
      this.databaseUrl = param1String;
      return this;
    }
    
    @KeepForSdk
    public Builder setGaTrackingId(@Nullable String param1String) {
      this.gaTrackingId = param1String;
      return this;
    }
    
    @PublicApi
    public Builder setGcmSenderId(@Nullable String param1String) {
      this.gcmSenderId = param1String;
      return this;
    }
    
    @PublicApi
    public Builder setProjectId(@Nullable String param1String) {
      this.projectId = param1String;
      return this;
    }
    
    @PublicApi
    public Builder setStorageBucket(@Nullable String param1String) {
      this.storageBucket = param1String;
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\FirebaseOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */