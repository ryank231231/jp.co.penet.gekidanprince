package com.google.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ExtensionRegistryLite {
  static final ExtensionRegistryLite EMPTY_REGISTRY_LITE;
  
  static final String EXTENSION_CLASS_NAME = "com.google.protobuf.Extension";
  
  private static volatile boolean eagerlyParseMessageSets = false;
  
  private static final Class<?> extensionClass = resolveExtensionClass();
  
  private final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> extensionsByNumber;
  
  static {
    EMPTY_REGISTRY_LITE = new ExtensionRegistryLite(true);
  }
  
  ExtensionRegistryLite() {
    this.extensionsByNumber = new HashMap<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>>();
  }
  
  ExtensionRegistryLite(ExtensionRegistryLite paramExtensionRegistryLite) {
    if (paramExtensionRegistryLite == EMPTY_REGISTRY_LITE) {
      this.extensionsByNumber = Collections.emptyMap();
    } else {
      this.extensionsByNumber = Collections.unmodifiableMap(paramExtensionRegistryLite.extensionsByNumber);
    } 
  }
  
  ExtensionRegistryLite(boolean paramBoolean) {
    this.extensionsByNumber = Collections.emptyMap();
  }
  
  public static ExtensionRegistryLite getEmptyRegistry() {
    return ExtensionRegistryFactory.createEmpty();
  }
  
  public static boolean isEagerlyParseMessageSets() {
    return eagerlyParseMessageSets;
  }
  
  public static ExtensionRegistryLite newInstance() {
    return ExtensionRegistryFactory.create();
  }
  
  static Class<?> resolveExtensionClass() {
    try {
      return Class.forName("com.google.protobuf.Extension");
    } catch (ClassNotFoundException classNotFoundException) {
      return null;
    } 
  }
  
  public static void setEagerlyParseMessageSets(boolean paramBoolean) {
    eagerlyParseMessageSets = paramBoolean;
  }
  
  public final void add(ExtensionLite<?, ?> paramExtensionLite) {
    if (GeneratedMessageLite.GeneratedExtension.class.isAssignableFrom(paramExtensionLite.getClass()))
      add((GeneratedMessageLite.GeneratedExtension<?, ?>)paramExtensionLite); 
    if (ExtensionRegistryFactory.isFullRegistry(this))
      try {
        getClass().getMethod("add", new Class[] { extensionClass }).invoke(this, new Object[] { paramExtensionLite });
      } catch (Exception exception) {
        throw new IllegalArgumentException(String.format("Could not invoke ExtensionRegistry#add for %s", new Object[] { paramExtensionLite }), exception);
      }  
  }
  
  public final void add(GeneratedMessageLite.GeneratedExtension<?, ?> paramGeneratedExtension) {
    this.extensionsByNumber.put(new ObjectIntPair(paramGeneratedExtension.getContainingTypeDefaultInstance(), paramGeneratedExtension.getNumber()), paramGeneratedExtension);
  }
  
  public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType paramContainingType, int paramInt) {
    return (GeneratedMessageLite.GeneratedExtension<ContainingType, ?>)this.extensionsByNumber.get(new ObjectIntPair(paramContainingType, paramInt));
  }
  
  public ExtensionRegistryLite getUnmodifiable() {
    return new ExtensionRegistryLite(this);
  }
  
  private static final class ObjectIntPair {
    private final int number;
    
    private final Object object;
    
    ObjectIntPair(Object param1Object, int param1Int) {
      this.object = param1Object;
      this.number = param1Int;
    }
    
    public boolean equals(Object param1Object) {
      boolean bool = param1Object instanceof ObjectIntPair;
      boolean bool1 = false;
      if (!bool)
        return false; 
      param1Object = param1Object;
      bool = bool1;
      if (this.object == ((ObjectIntPair)param1Object).object) {
        bool = bool1;
        if (this.number == ((ObjectIntPair)param1Object).number)
          bool = true; 
      } 
      return bool;
    }
    
    public int hashCode() {
      return System.identityHashCode(this.object) * 65535 + this.number;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\ExtensionRegistryLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */