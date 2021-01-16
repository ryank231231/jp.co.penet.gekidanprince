package dagger.android;

import com.google.errorprone.annotations.DoNotMock;

@DoNotMock("Faked versions of AndroidInjector are much clearer than a mock. See https://google.github.io/dagger/testing")
public interface AndroidInjector<T> {
  void inject(T paramT);
  
  class AndroidInjector {}
  
  class AndroidInjector {}
}


/* Location:              Y:\classes-dex2jar.jar!\dagger\android\AndroidInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */