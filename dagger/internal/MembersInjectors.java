package dagger.internal;

import dagger.MembersInjector;

public final class MembersInjectors {
  public static void checkInstanceNotNull(Object paramObject) {
    Preconditions.checkNotNull(paramObject, "Cannot inject members into a null reference");
  }
  
  public static <T> T injectMembers(MembersInjector<T> paramMembersInjector, T paramT) {
    paramMembersInjector.injectMembers(paramT);
    return paramT;
  }
  
  public static <T> MembersInjector<T> noOp() {
    return NoOpMembersInjector.INSTANCE;
  }
  
  private enum NoOpMembersInjector implements MembersInjector<Object> {
    INSTANCE;
    
    static {
    
    }
    
    public void injectMembers(Object param1Object) {
      MembersInjectors.checkInstanceNotNull(param1Object);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\internal\MembersInjectors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */