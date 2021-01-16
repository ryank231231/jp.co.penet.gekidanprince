package com.google.firebase.messaging;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

@Class(creator = "RemoteMessageCreator")
@Reserved({1})
public final class RemoteMessage extends AbstractSafeParcelable {
  public static final Parcelable.Creator<RemoteMessage> CREATOR = new zzc();
  
  public static final int PRIORITY_HIGH = 1;
  
  public static final int PRIORITY_NORMAL = 2;
  
  public static final int PRIORITY_UNKNOWN = 0;
  
  @Field(id = 2)
  Bundle zzdu;
  
  private Map<String, String> zzdv;
  
  private Notification zzdw;
  
  @Constructor
  public RemoteMessage(@Param(id = 2) Bundle paramBundle) {
    this.zzdu = paramBundle;
  }
  
  private static int zzm(String paramString) {
    return "high".equals(paramString) ? 1 : ("normal".equals(paramString) ? 2 : 0);
  }
  
  @Nullable
  public final String getCollapseKey() {
    return this.zzdu.getString("collapse_key");
  }
  
  public final Map<String, String> getData() {
    if (this.zzdv == null) {
      Bundle bundle = this.zzdu;
      ArrayMap arrayMap = new ArrayMap();
      for (String str : bundle.keySet()) {
        Object object = bundle.get(str);
        if (object instanceof String) {
          object = object;
          if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key"))
            arrayMap.put(str, object); 
        } 
      } 
      this.zzdv = (Map<String, String>)arrayMap;
    } 
    return this.zzdv;
  }
  
  @Nullable
  public final String getFrom() {
    return this.zzdu.getString("from");
  }
  
  @Nullable
  public final String getMessageId() {
    String str1 = this.zzdu.getString("google.message_id");
    String str2 = str1;
    if (str1 == null)
      str2 = this.zzdu.getString("message_id"); 
    return str2;
  }
  
  @Nullable
  public final String getMessageType() {
    return this.zzdu.getString("message_type");
  }
  
  @Nullable
  public final Notification getNotification() {
    if (this.zzdw == null && zza.zzf(this.zzdu))
      this.zzdw = new Notification(this.zzdu, null); 
    return this.zzdw;
  }
  
  public final int getOriginalPriority() {
    String str1 = this.zzdu.getString("google.original_priority");
    String str2 = str1;
    if (str1 == null)
      str2 = this.zzdu.getString("google.priority"); 
    return zzm(str2);
  }
  
  public final int getPriority() {
    String str1 = this.zzdu.getString("google.delivered_priority");
    String str2 = str1;
    if (str1 == null) {
      if ("1".equals(this.zzdu.getString("google.priority_reduced")))
        return 2; 
      str2 = this.zzdu.getString("google.priority");
    } 
    return zzm(str2);
  }
  
  public final long getSentTime() {
    Object object = this.zzdu.get("google.sent_time");
    if (object instanceof Long)
      return ((Long)object).longValue(); 
    if (object instanceof String)
      try {
        return Long.parseLong((String)object);
      } catch (NumberFormatException numberFormatException) {
        object = String.valueOf(object);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(object).length() + 19);
        stringBuilder.append("Invalid sent time: ");
        stringBuilder.append((String)object);
        Log.w("FirebaseMessaging", stringBuilder.toString());
      }  
    return 0L;
  }
  
  @Nullable
  public final String getTo() {
    return this.zzdu.getString("google.to");
  }
  
  public final int getTtl() {
    Object object = this.zzdu.get("google.ttl");
    if (object instanceof Integer)
      return ((Integer)object).intValue(); 
    if (object instanceof String)
      try {
        return Integer.parseInt((String)object);
      } catch (NumberFormatException numberFormatException) {
        object = String.valueOf(object);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(object).length() + 13);
        stringBuilder.append("Invalid TTL: ");
        stringBuilder.append((String)object);
        Log.w("FirebaseMessaging", stringBuilder.toString());
      }  
    return 0;
  }
  
  @KeepForSdk
  public final Intent toIntent() {
    Intent intent = new Intent();
    intent.putExtras(this.zzdu);
    return intent;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBundle(paramParcel, 2, this.zzdu, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public static class Builder {
    private final Bundle zzdu = new Bundle();
    
    private final Map<String, String> zzdv = (Map<String, String>)new ArrayMap();
    
    public Builder(String param1String) {
      if (TextUtils.isEmpty(param1String)) {
        param1String = String.valueOf(param1String);
        if (param1String.length() != 0) {
          param1String = "Invalid to: ".concat(param1String);
        } else {
          param1String = new String("Invalid to: ");
        } 
        throw new IllegalArgumentException(param1String);
      } 
      this.zzdu.putString("google.to", param1String);
    }
    
    public Builder addData(String param1String1, String param1String2) {
      this.zzdv.put(param1String1, param1String2);
      return this;
    }
    
    public RemoteMessage build() {
      Bundle bundle = new Bundle();
      for (Map.Entry<String, String> entry : this.zzdv.entrySet())
        bundle.putString((String)entry.getKey(), (String)entry.getValue()); 
      bundle.putAll(this.zzdu);
      this.zzdu.remove("from");
      return new RemoteMessage(bundle);
    }
    
    public Builder clearData() {
      this.zzdv.clear();
      return this;
    }
    
    public Builder setCollapseKey(String param1String) {
      this.zzdu.putString("collapse_key", param1String);
      return this;
    }
    
    public Builder setData(Map<String, String> param1Map) {
      this.zzdv.clear();
      this.zzdv.putAll(param1Map);
      return this;
    }
    
    public Builder setMessageId(String param1String) {
      this.zzdu.putString("google.message_id", param1String);
      return this;
    }
    
    public Builder setMessageType(String param1String) {
      this.zzdu.putString("message_type", param1String);
      return this;
    }
    
    public Builder setTtl(@IntRange(from = 0L, to = 86400L) int param1Int) {
      this.zzdu.putString("google.ttl", String.valueOf(param1Int));
      return this;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface MessagePriority {}
  
  public static class Notification {
    private final String tag;
    
    private final String zzdx;
    
    private final String zzdy;
    
    private final String[] zzdz;
    
    private final String zzea;
    
    private final String zzeb;
    
    private final String[] zzec;
    
    private final String zzed;
    
    private final String zzee;
    
    private final String zzef;
    
    private final String zzeg;
    
    private final String zzeh;
    
    private final Uri zzei;
    
    private Notification(Bundle param1Bundle) {
      this.zzdx = zza.zza(param1Bundle, "gcm.n.title");
      this.zzdy = zza.zzb(param1Bundle, "gcm.n.title");
      this.zzdz = zze(param1Bundle, "gcm.n.title");
      this.zzea = zza.zza(param1Bundle, "gcm.n.body");
      this.zzeb = zza.zzb(param1Bundle, "gcm.n.body");
      this.zzec = zze(param1Bundle, "gcm.n.body");
      this.zzed = zza.zza(param1Bundle, "gcm.n.icon");
      this.zzee = zza.zzi(param1Bundle);
      this.tag = zza.zza(param1Bundle, "gcm.n.tag");
      this.zzef = zza.zza(param1Bundle, "gcm.n.color");
      this.zzeg = zza.zza(param1Bundle, "gcm.n.click_action");
      this.zzeh = zza.zza(param1Bundle, "gcm.n.android_channel_id");
      this.zzei = zza.zzg(param1Bundle);
    }
    
    private static String[] zze(Bundle param1Bundle, String param1String) {
      Object[] arrayOfObject = zza.zzc(param1Bundle, param1String);
      if (arrayOfObject == null)
        return null; 
      String[] arrayOfString = new String[arrayOfObject.length];
      for (byte b = 0; b < arrayOfObject.length; b++)
        arrayOfString[b] = String.valueOf(arrayOfObject[b]); 
      return arrayOfString;
    }
    
    @Nullable
    public String getBody() {
      return this.zzea;
    }
    
    @Nullable
    public String[] getBodyLocalizationArgs() {
      return this.zzec;
    }
    
    @Nullable
    public String getBodyLocalizationKey() {
      return this.zzeb;
    }
    
    @Nullable
    public String getChannelId() {
      return this.zzeh;
    }
    
    @Nullable
    public String getClickAction() {
      return this.zzeg;
    }
    
    @Nullable
    public String getColor() {
      return this.zzef;
    }
    
    @Nullable
    public String getIcon() {
      return this.zzed;
    }
    
    @Nullable
    public Uri getLink() {
      return this.zzei;
    }
    
    @Nullable
    public String getSound() {
      return this.zzee;
    }
    
    @Nullable
    public String getTag() {
      return this.tag;
    }
    
    @Nullable
    public String getTitle() {
      return this.zzdx;
    }
    
    @Nullable
    public String[] getTitleLocalizationArgs() {
      return this.zzdz;
    }
    
    @Nullable
    public String getTitleLocalizationKey() {
      return this.zzdy;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\messaging\RemoteMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */