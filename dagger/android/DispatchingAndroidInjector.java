package dagger.android;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import dagger.internal.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

public final class DispatchingAndroidInjector<T> implements AndroidInjector<T> {
  private static final String NO_SUPERTYPES_BOUND_FORMAT = "No injector factory bound for Class<%s>";
  
  private static final String SUPERTYPES_BOUND_FORMAT = "No injector factory bound for Class<%1$s>. Injector factories were bound for supertypes of %1$s: %2$s. Did you mean to bind an injector factory for the subtype?";
  
  private final Map<Class<? extends T>, Provider<AndroidInjector.Factory<? extends T>>> injectorFactories;
  
  @Inject
  DispatchingAndroidInjector(Map<Class<? extends T>, Provider<AndroidInjector.Factory<? extends T>>> paramMap) {
    this.injectorFactories = paramMap;
  }
  
  private String errorMessageSuggestions(T paramT) {
    String str;
    ArrayList<String> arrayList = new ArrayList();
    for (Class<? extends T> clazz : this.injectorFactories.keySet()) {
      if (clazz.isInstance(paramT))
        arrayList.add(clazz.getCanonicalName()); 
    } 
    Collections.sort(arrayList);
    if (arrayList.isEmpty()) {
      str = "No injector factory bound for Class<%s>";
    } else {
      str = "No injector factory bound for Class<%1$s>. Injector factories were bound for supertypes of %1$s: %2$s. Did you mean to bind an injector factory for the subtype?";
    } 
    return String.format(str, new Object[] { paramT.getClass().getCanonicalName(), arrayList });
  }
  
  public void inject(T paramT) {
    if (maybeInject(paramT))
      return; 
    throw new IllegalArgumentException(errorMessageSuggestions(paramT));
  }
  
  @CanIgnoreReturnValue
  public boolean maybeInject(T paramT) {
    Provider provider = this.injectorFactories.get(paramT.getClass());
    if (provider == null)
      return false; 
    AndroidInjector.Factory factory = (AndroidInjector.Factory)provider.get();
    try {
      ((AndroidInjector<T>)Preconditions.checkNotNull(factory.create(paramT), "%s.create(I) should not return null.", factory.getClass())).inject(paramT);
      return true;
    } catch (ClassCastException classCastException) {
      throw new InvalidInjectorBindingException(String.format("%s does not implement AndroidInjector.Factory<%s>", new Object[] { factory.getClass().getCanonicalName(), paramT.getClass().getCanonicalName() }), classCastException);
    } 
  }
  
  class DispatchingAndroidInjector {}
}


/* Location:              Y:\classes-dex2jar.jar!\dagger\android\DispatchingAndroidInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */