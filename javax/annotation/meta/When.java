package javax.annotation.meta;

public enum When {
  ALWAYS, MAYBE, NEVER, UNKNOWN;
  
  static {
    MAYBE = new When("MAYBE", 2);
    NEVER = new When("NEVER", 3);
    $VALUES = new When[] { ALWAYS, UNKNOWN, MAYBE, NEVER };
  }
}


/* Location:              Y:\classes-dex2jar.jar!\javax\annotation\meta\When.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */