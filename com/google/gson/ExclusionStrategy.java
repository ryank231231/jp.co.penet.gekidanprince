package com.google.gson;

public interface ExclusionStrategy {
  boolean shouldSkipClass(Class<?> paramClass);
  
  boolean shouldSkipField(FieldAttributes paramFieldAttributes);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\gson\ExclusionStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */