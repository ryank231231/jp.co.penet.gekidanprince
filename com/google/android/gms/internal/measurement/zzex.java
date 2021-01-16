package com.google.android.gms.internal.measurement;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class zzex<T extends zzem> {
  private static final Logger logger = Logger.getLogger(zzeg.class.getName());
  
  private static String zzagl = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";
  
  static <T extends zzem> T zza(Class<T> paramClass) {
    String str;
    ClassLoader classLoader = zzex.class.getClassLoader();
    if (paramClass.equals(zzem.class)) {
      str = zzagl;
    } else if (paramClass.getPackage().equals(zzex.class.getPackage())) {
      str = String.format("%s.BlazeGenerated%sLoader", new Object[] { paramClass.getPackage().getName(), paramClass.getSimpleName() });
    } else {
      throw new IllegalArgumentException(paramClass.getName());
    } 
    try {
      Class<?> clazz = Class.forName(str, true, classLoader);
      try {
        zzex zzex1 = clazz.getConstructor(new Class[0]).newInstance(new Object[0]);
        return paramClass.cast(zzex1.zzme());
      } catch (NoSuchMethodException noSuchMethodException) {
        IllegalStateException illegalStateException = new IllegalStateException();
        this(noSuchMethodException);
        throw illegalStateException;
      } catch (InstantiationException instantiationException) {
        IllegalStateException illegalStateException = new IllegalStateException();
        this(instantiationException);
        throw illegalStateException;
      } catch (IllegalAccessException illegalAccessException) {
        IllegalStateException illegalStateException = new IllegalStateException();
        this(illegalAccessException);
        throw illegalStateException;
      } catch (InvocationTargetException invocationTargetException) {
        IllegalStateException illegalStateException = new IllegalStateException();
        this(invocationTargetException);
        throw illegalStateException;
      } 
    } catch (ClassNotFoundException classNotFoundException) {
      Iterator<zzex> iterator = ServiceLoader.<zzex>load(zzex.class, classLoader).iterator();
      ArrayList<zzem> arrayList = new ArrayList();
      while (iterator.hasNext()) {
        try {
          arrayList.add((zzem)paramClass.cast(((zzex)iterator.next()).zzme()));
        } catch (ServiceConfigurationError serviceConfigurationError) {
          Logger logger = logger;
          Level level = Level.SEVERE;
          String str1 = String.valueOf(paramClass.getSimpleName());
          if (str1.length() != 0) {
            str1 = "Unable to load ".concat(str1);
          } else {
            str1 = new String("Unable to load ");
          } 
          logger.logp(level, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", str1, serviceConfigurationError);
        } 
      } 
      if (arrayList.size() == 1)
        return (T)arrayList.get(0); 
      if (arrayList.size() == 0)
        return null; 
      try {
        return (T)paramClass.getMethod("combine", new Class[] { Collection.class }).invoke(null, new Object[] { arrayList });
      } catch (NoSuchMethodException noSuchMethodException) {
        throw new IllegalStateException(noSuchMethodException);
      } catch (IllegalAccessException illegalAccessException) {
        throw new IllegalStateException(illegalAccessException);
      } catch (InvocationTargetException invocationTargetException) {
        throw new IllegalStateException(invocationTargetException);
      } 
    } 
  }
  
  protected abstract T zzme();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */