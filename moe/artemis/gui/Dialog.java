package moe.artemis.gui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.EditText;
import java.util.HashMap;

public class Dialog {
  private static HashMap<Integer, Dialog> instances;
  
  private static int seed;
  
  private Activity activity;
  
  private long context;
  
  private AlertDialog.Builder dialog;
  
  private EditText editText;
  
  private String message;
  
  private boolean textField;
  
  public Dialog(Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, long paramLong) {
    this.activity = paramActivity;
    this.dialog = new AlertDialog.Builder((Context)this.activity);
    this.editText = null;
    this.message = paramString2;
    this.textField = paramBoolean2;
    this.context = paramLong;
    this.dialog.setTitle(paramString1);
    if (!this.textField)
      this.dialog.setMessage(this.message); 
    this.dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
          public void onCancel(DialogInterface param1DialogInterface) {
            Dialog dialog = Dialog.this;
            dialog.OnClose(0, "", dialog.context);
          }
        });
    this.dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            String str;
            Dialog dialog = Dialog.this;
            if (dialog.editText != null) {
              str = Dialog.this.editText.getText().toString();
            } else {
              str = "";
            } 
            dialog.OnClose(1, str, Dialog.this.context);
          }
        });
    if (paramBoolean1)
      this.dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              String str;
              Dialog dialog = Dialog.this;
              if (dialog.editText != null) {
                str = Dialog.this.editText.getText().toString();
              } else {
                str = "";
              } 
              dialog.OnClose(0, str, Dialog.this.context);
            }
          }); 
    this.activity.runOnUiThread(new Runnable() {
          public void run() {
            if (Dialog.this.textField) {
              Dialog dialog = Dialog.this;
              Dialog.access$202(dialog, new EditText((Context)dialog.activity));
              Dialog.this.editText.setSingleLine(true);
              Dialog.this.editText.setText(Dialog.this.message);
              Dialog.this.dialog.setView((View)Dialog.this.editText);
            } 
            Dialog.this.dialog.show();
          }
        });
  }
  
  private native void OnClose(int paramInt, String paramString, long paramLong);
  
  public static void Release(int paramInt) {
    if (instances == null)
      instances = new HashMap<Integer, Dialog>(); 
    if (instances.containsKey(Integer.valueOf(paramInt)))
      instances.remove(Integer.valueOf(paramInt)); 
  }
  
  public static int Show(Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, long paramLong) {
    if (seed == 0) {
      ActivityInfo activityInfo = null;
      try {
        ActivityInfo activityInfo1 = paramActivity.getPackageManager().getActivityInfo(paramActivity.getComponentName(), 128);
        activityInfo = activityInfo1;
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {}
      System.loadLibrary(activityInfo.metaData.getString("android.app.lib_name"));
    } 
    seed++;
    if (instances == null)
      instances = new HashMap<Integer, Dialog>(); 
    instances.put(Integer.valueOf(seed), new Dialog(paramActivity, paramString1, paramString2, paramBoolean1, paramBoolean2, paramLong));
    return seed;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\moe\artemis\gui\Dialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */