package android.support.v7.widget;

import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.v4.graphics.drawable.WrappedDrawable;
import android.support.v7.graphics.drawable.DrawableWrapper;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DrawableUtils {
  public static final Rect INSETS_NONE = new Rect();
  
  private static final String TAG = "DrawableUtils";
  
  private static final String VECTOR_DRAWABLE_CLAZZ_NAME = "android.graphics.drawable.VectorDrawable";
  
  private static Class<?> sInsetsClazz;
  
  static {
    if (Build.VERSION.SDK_INT >= 18)
      try {
        sInsetsClazz = Class.forName("android.graphics.Insets");
      } catch (ClassNotFoundException classNotFoundException) {} 
  }
  
  public static boolean canSafelyMutateDrawable(@NonNull Drawable paramDrawable) {
    Drawable[] arrayOfDrawable;
    if (Build.VERSION.SDK_INT < 15 && paramDrawable instanceof android.graphics.drawable.InsetDrawable)
      return false; 
    if (Build.VERSION.SDK_INT < 15 && paramDrawable instanceof android.graphics.drawable.GradientDrawable)
      return false; 
    if (Build.VERSION.SDK_INT < 17 && paramDrawable instanceof android.graphics.drawable.LayerDrawable)
      return false; 
    if (paramDrawable instanceof DrawableContainer) {
      Drawable.ConstantState constantState = paramDrawable.getConstantState();
      if (constantState instanceof DrawableContainer.DrawableContainerState) {
        arrayOfDrawable = ((DrawableContainer.DrawableContainerState)constantState).getChildren();
        int i = arrayOfDrawable.length;
        for (byte b = 0; b < i; b++) {
          if (!canSafelyMutateDrawable(arrayOfDrawable[b]))
            return false; 
        } 
      } 
    } else {
      if (arrayOfDrawable instanceof WrappedDrawable)
        return canSafelyMutateDrawable(((WrappedDrawable)arrayOfDrawable).getWrappedDrawable()); 
      if (arrayOfDrawable instanceof DrawableWrapper)
        return canSafelyMutateDrawable(((DrawableWrapper)arrayOfDrawable).getWrappedDrawable()); 
      if (arrayOfDrawable instanceof ScaleDrawable)
        return canSafelyMutateDrawable(((ScaleDrawable)arrayOfDrawable).getDrawable()); 
    } 
    return true;
  }
  
  static void fixDrawable(@NonNull Drawable paramDrawable) {
    if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName()))
      fixVectorDrawableTinting(paramDrawable); 
  }
  
  private static void fixVectorDrawableTinting(Drawable paramDrawable) {
    int[] arrayOfInt = paramDrawable.getState();
    if (arrayOfInt == null || arrayOfInt.length == 0) {
      paramDrawable.setState(ThemeUtils.CHECKED_STATE_SET);
    } else {
      paramDrawable.setState(ThemeUtils.EMPTY_STATE_SET);
    } 
    paramDrawable.setState(arrayOfInt);
  }
  
  public static Rect getOpticalBounds(Drawable paramDrawable) {
    // Byte code:
    //   0: getstatic android/support/v7/widget/DrawableUtils.sInsetsClazz : Ljava/lang/Class;
    //   3: ifnull -> 281
    //   6: aload_0
    //   7: invokestatic unwrap : (Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;
    //   10: astore_0
    //   11: aload_0
    //   12: invokevirtual getClass : ()Ljava/lang/Class;
    //   15: ldc 'getOpticalInsets'
    //   17: iconst_0
    //   18: anewarray java/lang/Class
    //   21: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   24: aload_0
    //   25: iconst_0
    //   26: anewarray java/lang/Object
    //   29: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   32: astore_1
    //   33: aload_1
    //   34: ifnull -> 281
    //   37: new android/graphics/Rect
    //   40: astore_2
    //   41: aload_2
    //   42: invokespecial <init> : ()V
    //   45: getstatic android/support/v7/widget/DrawableUtils.sInsetsClazz : Ljava/lang/Class;
    //   48: invokevirtual getFields : ()[Ljava/lang/reflect/Field;
    //   51: astore_3
    //   52: aload_3
    //   53: arraylength
    //   54: istore #4
    //   56: iconst_0
    //   57: istore #5
    //   59: iload #5
    //   61: iload #4
    //   63: if_icmpge -> 270
    //   66: aload_3
    //   67: iload #5
    //   69: aaload
    //   70: astore_0
    //   71: aload_0
    //   72: invokevirtual getName : ()Ljava/lang/String;
    //   75: astore #6
    //   77: aload #6
    //   79: invokevirtual hashCode : ()I
    //   82: istore #7
    //   84: iload #7
    //   86: ldc -1383228885
    //   88: if_icmpeq -> 163
    //   91: iload #7
    //   93: ldc 115029
    //   95: if_icmpeq -> 147
    //   98: iload #7
    //   100: ldc 3317767
    //   102: if_icmpeq -> 131
    //   105: iload #7
    //   107: ldc 108511772
    //   109: if_icmpeq -> 115
    //   112: goto -> 179
    //   115: aload #6
    //   117: ldc 'right'
    //   119: invokevirtual equals : (Ljava/lang/Object;)Z
    //   122: ifeq -> 179
    //   125: iconst_2
    //   126: istore #7
    //   128: goto -> 182
    //   131: aload #6
    //   133: ldc 'left'
    //   135: invokevirtual equals : (Ljava/lang/Object;)Z
    //   138: ifeq -> 179
    //   141: iconst_0
    //   142: istore #7
    //   144: goto -> 182
    //   147: aload #6
    //   149: ldc 'top'
    //   151: invokevirtual equals : (Ljava/lang/Object;)Z
    //   154: ifeq -> 179
    //   157: iconst_1
    //   158: istore #7
    //   160: goto -> 182
    //   163: aload #6
    //   165: ldc 'bottom'
    //   167: invokevirtual equals : (Ljava/lang/Object;)Z
    //   170: ifeq -> 179
    //   173: iconst_3
    //   174: istore #7
    //   176: goto -> 182
    //   179: iconst_m1
    //   180: istore #7
    //   182: iload #7
    //   184: tableswitch default -> 216, 0 -> 255, 1 -> 243, 2 -> 231, 3 -> 219
    //   216: goto -> 264
    //   219: aload_2
    //   220: aload_0
    //   221: aload_1
    //   222: invokevirtual getInt : (Ljava/lang/Object;)I
    //   225: putfield bottom : I
    //   228: goto -> 264
    //   231: aload_2
    //   232: aload_0
    //   233: aload_1
    //   234: invokevirtual getInt : (Ljava/lang/Object;)I
    //   237: putfield right : I
    //   240: goto -> 264
    //   243: aload_2
    //   244: aload_0
    //   245: aload_1
    //   246: invokevirtual getInt : (Ljava/lang/Object;)I
    //   249: putfield top : I
    //   252: goto -> 264
    //   255: aload_2
    //   256: aload_0
    //   257: aload_1
    //   258: invokevirtual getInt : (Ljava/lang/Object;)I
    //   261: putfield left : I
    //   264: iinc #5, 1
    //   267: goto -> 59
    //   270: aload_2
    //   271: areturn
    //   272: astore_0
    //   273: ldc 'DrawableUtils'
    //   275: ldc 'Couldn't obtain the optical insets. Ignoring.'
    //   277: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   280: pop
    //   281: getstatic android/support/v7/widget/DrawableUtils.INSETS_NONE : Landroid/graphics/Rect;
    //   284: areturn
    // Exception table:
    //   from	to	target	type
    //   6	33	272	java/lang/Exception
    //   37	56	272	java/lang/Exception
    //   71	84	272	java/lang/Exception
    //   115	125	272	java/lang/Exception
    //   131	141	272	java/lang/Exception
    //   147	157	272	java/lang/Exception
    //   163	173	272	java/lang/Exception
    //   219	228	272	java/lang/Exception
    //   231	240	272	java/lang/Exception
    //   243	252	272	java/lang/Exception
    //   255	264	272	java/lang/Exception
  }
  
  public static PorterDuff.Mode parseTintMode(int paramInt, PorterDuff.Mode paramMode) {
    if (paramInt != 3) {
      if (paramInt != 5) {
        if (paramInt != 9) {
          switch (paramInt) {
            default:
              return paramMode;
            case 16:
              return PorterDuff.Mode.ADD;
            case 15:
              return PorterDuff.Mode.SCREEN;
            case 14:
              break;
          } 
          return PorterDuff.Mode.MULTIPLY;
        } 
        return PorterDuff.Mode.SRC_ATOP;
      } 
      return PorterDuff.Mode.SRC_IN;
    } 
    return PorterDuff.Mode.SRC_OVER;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\v7\widget\DrawableUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */