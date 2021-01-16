package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.WorkerThread;
import android.support.v4.content.ContextCompat;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class zzad extends zzcu {
  private long zzew;
  
  private String zzex;
  
  private Boolean zzey;
  
  private AccountManager zzez;
  
  private Boolean zzfa;
  
  private long zzfb;
  
  zzad(zzby paramzzby) {
    super(paramzzby);
  }
  
  protected final boolean zzak() {
    Calendar calendar = Calendar.getInstance();
    this.zzew = TimeUnit.MINUTES.convert((calendar.get(15) + calendar.get(16)), TimeUnit.MILLISECONDS);
    Locale locale = Locale.getDefault();
    String str1 = locale.getLanguage().toLowerCase(Locale.ENGLISH);
    String str2 = locale.getCountry().toLowerCase(Locale.ENGLISH);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 1 + String.valueOf(str2).length());
    stringBuilder.append(str1);
    stringBuilder.append("-");
    stringBuilder.append(str2);
    this.zzex = stringBuilder.toString();
    return false;
  }
  
  public final long zzco() {
    zzah();
    return this.zzew;
  }
  
  public final String zzcp() {
    zzah();
    return this.zzex;
  }
  
  @WorkerThread
  final long zzcq() {
    super.zzq();
    return this.zzfb;
  }
  
  @WorkerThread
  final void zzcr() {
    super.zzq();
    this.zzfa = null;
    this.zzfb = 0L;
  }
  
  @WorkerThread
  final boolean zzcs() {
    super.zzq();
    long l = super.zzz().currentTimeMillis();
    if (l - this.zzfb > 86400000L)
      this.zzfa = null; 
    Boolean bool = this.zzfa;
    if (bool != null)
      return bool.booleanValue(); 
    if (ContextCompat.checkSelfPermission(super.getContext(), "android.permission.GET_ACCOUNTS") != 0) {
      super.zzad().zzde().zzaq("Permission error checking for dasher/unicorn accounts");
      this.zzfb = l;
      this.zzfa = Boolean.valueOf(false);
      return false;
    } 
    if (this.zzez == null)
      this.zzez = AccountManager.get(super.getContext()); 
    try {
      Account[] arrayOfAccount = (Account[])this.zzez.getAccountsByTypeAndFeatures("com.google", new String[] { "service_HOSTED" }, null, null).getResult();
      if (arrayOfAccount != null && arrayOfAccount.length > 0) {
        this.zzfa = Boolean.valueOf(true);
        this.zzfb = l;
        return true;
      } 
      arrayOfAccount = (Account[])this.zzez.getAccountsByTypeAndFeatures("com.google", new String[] { "service_uca" }, null, null).getResult();
      if (arrayOfAccount != null && arrayOfAccount.length > 0) {
        this.zzfa = Boolean.valueOf(true);
        this.zzfb = l;
        return true;
      } 
    } catch (AuthenticatorException authenticatorException) {
      super.zzad().zzdb().zza("Exception checking account types", authenticatorException);
    } catch (IOException iOException) {
    
    } catch (OperationCanceledException operationCanceledException) {}
    this.zzfb = l;
    this.zzfa = Boolean.valueOf(false);
    return false;
  }
  
  public final boolean zzj(Context paramContext) {
    if (this.zzey == null) {
      super.zzag();
      this.zzey = Boolean.valueOf(false);
      try {
        PackageManager packageManager = paramContext.getPackageManager();
        if (packageManager != null) {
          packageManager.getPackageInfo("com.google.android.gms", 128);
          this.zzey = Boolean.valueOf(true);
        } 
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {}
    } 
    return this.zzey.booleanValue();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */