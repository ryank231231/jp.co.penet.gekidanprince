package com.google.firebase.components;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ComponentDiscovery<T> {
  private static final String COMPONENT_KEY_PREFIX = "com.google.firebase.components:";
  
  private static final String COMPONENT_SENTINEL_VALUE = "com.google.firebase.components.ComponentRegistrar";
  
  private static final String TAG = "ComponentDiscovery";
  
  private final T context;
  
  private final RegistrarNameRetriever<T> retriever;
  
  @VisibleForTesting
  ComponentDiscovery(T paramT, RegistrarNameRetriever<T> paramRegistrarNameRetriever) {
    this.context = paramT;
    this.retriever = paramRegistrarNameRetriever;
  }
  
  public static ComponentDiscovery<Context> forContext(Context paramContext) {
    return new ComponentDiscovery<Context>(paramContext, new MetadataRegistrarNameRetriever());
  }
  
  private static List<ComponentRegistrar> instantiate(List<String> paramList) {
    ArrayList<ComponentRegistrar> arrayList = new ArrayList();
    for (String str : paramList) {
      try {
        Class<?> clazz = Class.forName(str);
        if (!ComponentRegistrar.class.isAssignableFrom(clazz)) {
          Log.w("ComponentDiscovery", String.format("Class %s is not an instance of %s", new Object[] { str, "com.google.firebase.components.ComponentRegistrar" }));
          continue;
        } 
        arrayList.add(clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
      } catch (ClassNotFoundException classNotFoundException) {
        Log.w("ComponentDiscovery", String.format("Class %s is not an found.", new Object[] { str }), classNotFoundException);
      } catch (IllegalAccessException illegalAccessException) {
        Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", new Object[] { str }), illegalAccessException);
      } catch (InstantiationException instantiationException) {
        Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", new Object[] { str }), instantiationException);
      } catch (NoSuchMethodException noSuchMethodException) {
        Log.w("ComponentDiscovery", String.format("Could not instantiate %s", new Object[] { str }), noSuchMethodException);
      } catch (InvocationTargetException invocationTargetException) {
        Log.w("ComponentDiscovery", String.format("Could not instantiate %s", new Object[] { str }), invocationTargetException);
      } 
    } 
    return arrayList;
  }
  
  public List<ComponentRegistrar> discover() {
    return instantiate(this.retriever.retrieve(this.context));
  }
  
  private static class MetadataRegistrarNameRetriever implements RegistrarNameRetriever<Context> {
    private MetadataRegistrarNameRetriever() {}
    
    private static Bundle getMetadata(Context param1Context) {
      try {
        PackageManager packageManager = param1Context.getPackageManager();
        if (packageManager == null) {
          Log.w("ComponentDiscovery", "Context has no PackageManager.");
          return null;
        } 
        ComponentName componentName = new ComponentName();
        this(param1Context, ComponentDiscoveryService.class);
        ServiceInfo serviceInfo = packageManager.getServiceInfo(componentName, 128);
        if (serviceInfo == null) {
          Log.w("ComponentDiscovery", "ComponentDiscoveryService has no service info.");
          return null;
        } 
        return serviceInfo.metaData;
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        Log.w("ComponentDiscovery", "Application info not found.");
        return null;
      } 
    }
    
    public List<String> retrieve(Context param1Context) {
      Bundle bundle = getMetadata(param1Context);
      if (bundle == null) {
        Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
        return Collections.emptyList();
      } 
      ArrayList<String> arrayList = new ArrayList();
      for (String str : bundle.keySet()) {
        if ("com.google.firebase.components.ComponentRegistrar".equals(bundle.get(str)) && str.startsWith("com.google.firebase.components:"))
          arrayList.add(str.substring(31)); 
      } 
      return arrayList;
    }
  }
  
  @VisibleForTesting
  static interface RegistrarNameRetriever<T> {
    List<String> retrieve(T param1T);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\components\ComponentDiscovery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */