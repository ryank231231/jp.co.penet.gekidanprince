package com.google.android.gms.common.api.internal;

abstract class zabf {
  private final zabd zaht;
  
  protected zabf(zabd paramzabd) {
    this.zaht = paramzabd;
  }
  
  protected abstract void zaan();
  
  public final void zac(zabe paramzabe) {
    zabe.zaa(paramzabe).lock();
    try {
      zabd zabd1 = zabe.zab(paramzabe);
      zabd zabd2 = this.zaht;
      if (zabd1 != zabd2)
        return; 
      zaan();
      return;
    } finally {
      zabe.zaa(paramzabe).unlock();
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zabf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */