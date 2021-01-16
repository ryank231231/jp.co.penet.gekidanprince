package io.opencensus.internal;

import java.util.ServiceConfigurationError;

public final class Provider {
  public static <T> T createInstance(Class<?> paramClass, Class<T> paramClass1) {
    try {
      return (T)paramClass.<Class<T>>asSubclass((Class)paramClass1).getConstructor(new Class[0]).newInstance(new Object[0]);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Provider ");
      stringBuilder.append(paramClass.getName());
      stringBuilder.append(" could not be instantiated.");
      throw new ServiceConfigurationError(stringBuilder.toString(), exception);
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\internal\Provider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */