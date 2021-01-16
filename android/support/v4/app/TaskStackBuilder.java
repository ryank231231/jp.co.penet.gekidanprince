package android.support.v4.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class TaskStackBuilder implements Iterable<Intent> {
  private static final TaskStackBuilderBaseImpl IMPL;
  
  private static final String TAG = "TaskStackBuilder";
  
  private final ArrayList<Intent> mIntents = new ArrayList<Intent>();
  
  private final Context mSourceContext;
  
  static {
    if (Build.VERSION.SDK_INT >= 16) {
      IMPL = new TaskStackBuilderApi16Impl();
    } else {
      IMPL = new TaskStackBuilderBaseImpl();
    } 
  }
  
  private TaskStackBuilder(Context paramContext) {
    this.mSourceContext = paramContext;
  }
  
  @NonNull
  public static TaskStackBuilder create(@NonNull Context paramContext) {
    return new TaskStackBuilder(paramContext);
  }
  
  @Deprecated
  public static TaskStackBuilder from(Context paramContext) {
    return create(paramContext);
  }
  
  @NonNull
  public TaskStackBuilder addNextIntent(@NonNull Intent paramIntent) {
    this.mIntents.add(paramIntent);
    return this;
  }
  
  @NonNull
  public TaskStackBuilder addNextIntentWithParentStack(@NonNull Intent paramIntent) {
    ComponentName componentName1 = paramIntent.getComponent();
    ComponentName componentName2 = componentName1;
    if (componentName1 == null)
      componentName2 = paramIntent.resolveActivity(this.mSourceContext.getPackageManager()); 
    if (componentName2 != null)
      addParentStack(componentName2); 
    addNextIntent(paramIntent);
    return this;
  }
  
  @NonNull
  public TaskStackBuilder addParentStack(@NonNull Activity paramActivity) {
    Intent intent1;
    if (paramActivity instanceof SupportParentable) {
      intent1 = ((SupportParentable)paramActivity).getSupportParentActivityIntent();
    } else {
      intent1 = null;
    } 
    Intent intent2 = intent1;
    if (intent1 == null)
      intent2 = NavUtils.getParentActivityIntent(paramActivity); 
    if (intent2 != null) {
      ComponentName componentName2 = intent2.getComponent();
      ComponentName componentName1 = componentName2;
      if (componentName2 == null)
        componentName1 = intent2.resolveActivity(this.mSourceContext.getPackageManager()); 
      addParentStack(componentName1);
      addNextIntent(intent2);
    } 
    return this;
  }
  
  public TaskStackBuilder addParentStack(ComponentName paramComponentName) {
    int i = this.mIntents.size();
    try {
      for (Intent intent = NavUtils.getParentActivityIntent(this.mSourceContext, paramComponentName); intent != null; intent = NavUtils.getParentActivityIntent(this.mSourceContext, intent.getComponent()))
        this.mIntents.add(i, intent); 
      return this;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
      throw new IllegalArgumentException(nameNotFoundException);
    } 
  }
  
  @NonNull
  public TaskStackBuilder addParentStack(@NonNull Class<?> paramClass) {
    return addParentStack(new ComponentName(this.mSourceContext, paramClass));
  }
  
  @Nullable
  public Intent editIntentAt(int paramInt) {
    return this.mIntents.get(paramInt);
  }
  
  @Deprecated
  public Intent getIntent(int paramInt) {
    return editIntentAt(paramInt);
  }
  
  public int getIntentCount() {
    return this.mIntents.size();
  }
  
  @NonNull
  public Intent[] getIntents() {
    Intent[] arrayOfIntent = new Intent[this.mIntents.size()];
    if (arrayOfIntent.length == 0)
      return arrayOfIntent; 
    arrayOfIntent[0] = (new Intent(this.mIntents.get(0))).addFlags(268484608);
    for (byte b = 1; b < arrayOfIntent.length; b++)
      arrayOfIntent[b] = new Intent(this.mIntents.get(b)); 
    return arrayOfIntent;
  }
  
  @Nullable
  public PendingIntent getPendingIntent(int paramInt1, int paramInt2) {
    return getPendingIntent(paramInt1, paramInt2, null);
  }
  
  @Nullable
  public PendingIntent getPendingIntent(int paramInt1, int paramInt2, @Nullable Bundle paramBundle) {
    if (!this.mIntents.isEmpty()) {
      ArrayList<Intent> arrayList = this.mIntents;
      Intent[] arrayOfIntent = arrayList.<Intent>toArray(new Intent[arrayList.size()]);
      arrayOfIntent[0] = (new Intent(arrayOfIntent[0])).addFlags(268484608);
      return IMPL.getPendingIntent(this.mSourceContext, arrayOfIntent, paramInt1, paramInt2, paramBundle);
    } 
    throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
  }
  
  @Deprecated
  public Iterator<Intent> iterator() {
    return this.mIntents.iterator();
  }
  
  public void startActivities() {
    startActivities(null);
  }
  
  public void startActivities(@Nullable Bundle paramBundle) {
    if (!this.mIntents.isEmpty()) {
      ArrayList<Intent> arrayList = this.mIntents;
      Intent[] arrayOfIntent = arrayList.<Intent>toArray(new Intent[arrayList.size()]);
      arrayOfIntent[0] = (new Intent(arrayOfIntent[0])).addFlags(268484608);
      if (!ContextCompat.startActivities(this.mSourceContext, arrayOfIntent, paramBundle)) {
        Intent intent = new Intent(arrayOfIntent[arrayOfIntent.length - 1]);
        intent.addFlags(268435456);
        this.mSourceContext.startActivity(intent);
      } 
      return;
    } 
    throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
  }
  
  public static interface SupportParentable {
    @Nullable
    Intent getSupportParentActivityIntent();
  }
  
  @RequiresApi(16)
  static class TaskStackBuilderApi16Impl extends TaskStackBuilderBaseImpl {
    public PendingIntent getPendingIntent(Context param1Context, Intent[] param1ArrayOfIntent, int param1Int1, int param1Int2, Bundle param1Bundle) {
      param1ArrayOfIntent[0] = (new Intent(param1ArrayOfIntent[0])).addFlags(268484608);
      return PendingIntent.getActivities(param1Context, param1Int1, param1ArrayOfIntent, param1Int2, param1Bundle);
    }
  }
  
  static class TaskStackBuilderBaseImpl {
    public PendingIntent getPendingIntent(Context param1Context, Intent[] param1ArrayOfIntent, int param1Int1, int param1Int2, Bundle param1Bundle) {
      param1ArrayOfIntent[0] = (new Intent(param1ArrayOfIntent[0])).addFlags(268484608);
      return PendingIntent.getActivities(param1Context, param1Int1, param1ArrayOfIntent, param1Int2);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\v4\app\TaskStackBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */