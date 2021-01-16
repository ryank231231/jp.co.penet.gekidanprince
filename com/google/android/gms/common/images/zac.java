package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import java.lang.ref.WeakReference;

public final class zac extends zaa {
  private WeakReference<ImageView> zanb;
  
  public zac(ImageView paramImageView, int paramInt) {
    super(null, paramInt);
    Asserts.checkNotNull(paramImageView);
    this.zanb = new WeakReference<ImageView>(paramImageView);
  }
  
  public zac(ImageView paramImageView, Uri paramUri) {
    super(paramUri, 0);
    Asserts.checkNotNull(paramImageView);
    this.zanb = new WeakReference<ImageView>(paramImageView);
  }
  
  public final boolean equals(Object paramObject) {
    if (!(paramObject instanceof zac))
      return false; 
    if (this == paramObject)
      return true; 
    zac zac1 = (zac)paramObject;
    paramObject = this.zanb.get();
    ImageView imageView = zac1.zanb.get();
    return (imageView != null && paramObject != null && Objects.equal(imageView, paramObject));
  }
  
  public final int hashCode() {
    return 0;
  }
  
  protected final void zaa(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    // Byte code:
    //   0: aload_0
    //   1: getfield zanb : Ljava/lang/ref/WeakReference;
    //   4: invokevirtual get : ()Ljava/lang/Object;
    //   7: checkcast android/widget/ImageView
    //   10: astore #5
    //   12: aload #5
    //   14: ifnull -> 207
    //   17: iconst_0
    //   18: istore #6
    //   20: iload_3
    //   21: ifne -> 35
    //   24: iload #4
    //   26: ifne -> 35
    //   29: iconst_1
    //   30: istore #7
    //   32: goto -> 38
    //   35: iconst_0
    //   36: istore #7
    //   38: iload #7
    //   40: ifeq -> 72
    //   43: aload #5
    //   45: instanceof com/google/android/gms/internal/base/zaj
    //   48: ifeq -> 72
    //   51: invokestatic zach : ()I
    //   54: istore #8
    //   56: aload_0
    //   57: getfield zamw : I
    //   60: ifeq -> 72
    //   63: iload #8
    //   65: aload_0
    //   66: getfield zamw : I
    //   69: if_icmpeq -> 207
    //   72: aload_0
    //   73: iload_2
    //   74: iload_3
    //   75: invokevirtual zaa : (ZZ)Z
    //   78: istore_2
    //   79: aconst_null
    //   80: astore #9
    //   82: aload_1
    //   83: astore #10
    //   85: iload_2
    //   86: ifeq -> 141
    //   89: aload #5
    //   91: invokevirtual getDrawable : ()Landroid/graphics/drawable/Drawable;
    //   94: astore #11
    //   96: aload #11
    //   98: ifnull -> 126
    //   101: aload #11
    //   103: astore #10
    //   105: aload #11
    //   107: instanceof com/google/android/gms/internal/base/zae
    //   110: ifeq -> 129
    //   113: aload #11
    //   115: checkcast com/google/android/gms/internal/base/zae
    //   118: invokevirtual zacf : ()Landroid/graphics/drawable/Drawable;
    //   121: astore #10
    //   123: goto -> 129
    //   126: aconst_null
    //   127: astore #10
    //   129: new com/google/android/gms/internal/base/zae
    //   132: dup
    //   133: aload #10
    //   135: aload_1
    //   136: invokespecial <init> : (Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   139: astore #10
    //   141: aload #5
    //   143: aload #10
    //   145: invokevirtual setImageDrawable : (Landroid/graphics/drawable/Drawable;)V
    //   148: aload #5
    //   150: instanceof com/google/android/gms/internal/base/zaj
    //   153: ifeq -> 192
    //   156: aload #9
    //   158: astore_1
    //   159: iload #4
    //   161: ifeq -> 172
    //   164: aload_0
    //   165: getfield zamu : Lcom/google/android/gms/common/images/zab;
    //   168: getfield uri : Landroid/net/Uri;
    //   171: astore_1
    //   172: aload_1
    //   173: invokestatic zaa : (Landroid/net/Uri;)V
    //   176: iload #7
    //   178: ifeq -> 187
    //   181: aload_0
    //   182: getfield zamw : I
    //   185: istore #6
    //   187: iload #6
    //   189: invokestatic zai : (I)V
    //   192: iload_2
    //   193: ifeq -> 207
    //   196: aload #10
    //   198: checkcast com/google/android/gms/internal/base/zae
    //   201: sipush #250
    //   204: invokevirtual startTransition : (I)V
    //   207: return
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\images\zac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */