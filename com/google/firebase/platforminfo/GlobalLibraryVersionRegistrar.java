package com.google.firebase.platforminfo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GlobalLibraryVersionRegistrar {
  private static volatile GlobalLibraryVersionRegistrar INSTANCE;
  
  private final Set<LibraryVersion> infos = new HashSet<LibraryVersion>();
  
  public static GlobalLibraryVersionRegistrar getInstance() {
    // Byte code:
    //   0: getstatic com/google/firebase/platforminfo/GlobalLibraryVersionRegistrar.INSTANCE : Lcom/google/firebase/platforminfo/GlobalLibraryVersionRegistrar;
    //   3: astore_0
    //   4: aload_0
    //   5: astore_1
    //   6: aload_0
    //   7: ifnonnull -> 47
    //   10: ldc com/google/firebase/platforminfo/GlobalLibraryVersionRegistrar
    //   12: monitorenter
    //   13: getstatic com/google/firebase/platforminfo/GlobalLibraryVersionRegistrar.INSTANCE : Lcom/google/firebase/platforminfo/GlobalLibraryVersionRegistrar;
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ifnonnull -> 35
    //   23: new com/google/firebase/platforminfo/GlobalLibraryVersionRegistrar
    //   26: astore_1
    //   27: aload_1
    //   28: invokespecial <init> : ()V
    //   31: aload_1
    //   32: putstatic com/google/firebase/platforminfo/GlobalLibraryVersionRegistrar.INSTANCE : Lcom/google/firebase/platforminfo/GlobalLibraryVersionRegistrar;
    //   35: ldc com/google/firebase/platforminfo/GlobalLibraryVersionRegistrar
    //   37: monitorexit
    //   38: goto -> 47
    //   41: astore_1
    //   42: ldc com/google/firebase/platforminfo/GlobalLibraryVersionRegistrar
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    //   47: aload_1
    //   48: areturn
    // Exception table:
    //   from	to	target	type
    //   13	17	41	finally
    //   23	35	41	finally
    //   35	38	41	finally
    //   42	45	41	finally
  }
  
  Set<LibraryVersion> getRegisteredVersions() {
    synchronized (this.infos) {
      return Collections.unmodifiableSet(this.infos);
    } 
  }
  
  public void registerVersion(String paramString1, String paramString2) {
    synchronized (this.infos) {
      this.infos.add(LibraryVersion.create(paramString1, paramString2));
      return;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\platforminfo\GlobalLibraryVersionRegistrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */