package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.common.internal.Preconditions;

public class SupportErrorDialogFragment extends DialogFragment {
  private Dialog mDialog = null;
  
  private DialogInterface.OnCancelListener zaan = null;
  
  public static SupportErrorDialogFragment newInstance(Dialog paramDialog) {
    return newInstance(paramDialog, null);
  }
  
  public static SupportErrorDialogFragment newInstance(Dialog paramDialog, DialogInterface.OnCancelListener paramOnCancelListener) {
    SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
    paramDialog = (Dialog)Preconditions.checkNotNull(paramDialog, "Cannot display null dialog");
    paramDialog.setOnCancelListener(null);
    paramDialog.setOnDismissListener(null);
    supportErrorDialogFragment.mDialog = paramDialog;
    if (paramOnCancelListener != null)
      supportErrorDialogFragment.zaan = paramOnCancelListener; 
    return supportErrorDialogFragment;
  }
  
  public void onCancel(DialogInterface paramDialogInterface) {
    DialogInterface.OnCancelListener onCancelListener = this.zaan;
    if (onCancelListener != null)
      onCancelListener.onCancel(paramDialogInterface); 
  }
  
  public Dialog onCreateDialog(Bundle paramBundle) {
    if (this.mDialog == null)
      setShowsDialog(false); 
    return this.mDialog;
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString) {
    super.show(paramFragmentManager, paramString);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\SupportErrorDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */