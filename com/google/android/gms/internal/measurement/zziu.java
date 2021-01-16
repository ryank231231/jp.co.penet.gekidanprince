package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zziu extends IOException {
  public zziu(String paramString) {
    super(paramString);
  }
  
  public zziu(String paramString, Exception paramException) {
    super(paramString, paramException);
  }
  
  static zziu zzpg() {
    return new zziu("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
  }
  
  static zziu zzph() {
    return new zziu("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static zziu zzpi() {
    return new zziu("CodedInputStream encountered a malformed varint.");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zziu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */