package com.google.firebase.platforminfo;

import com.google.firebase.components.Component;

public class LibraryVersionComponent {
  public static Component<?> create(String paramString1, String paramString2) {
    return Component.intoSet(LibraryVersion.create(paramString1, paramString2), LibraryVersion.class);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\platforminfo\LibraryVersionComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */