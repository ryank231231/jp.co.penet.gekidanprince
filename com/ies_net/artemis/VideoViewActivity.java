package com.ies_net.artemis;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import java.io.FileDescriptor;
import java.io.RandomAccessFile;

public class VideoViewActivity extends Activity implements MediaPlayer.OnCompletionListener {
  private AssetFileDescriptor asset = null;
  
  private RandomAccessFile file = null;
  
  private boolean pause = false;
  
  private int skip = 0;
  
  private ArtemisVideoView videoView = null;
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    return (paramKeyEvent.getAction() == 0 && paramKeyEvent.getKeyCode() == 4 && this.skip == 0) ? true : super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void finish() {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer) {
    try {
      if (this.file != null) {
        this.file.close();
        this.file = null;
      } 
    } catch (Exception exception) {}
    setResult(-1, new Intent());
    finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.pause = false;
    Intent intent = getIntent();
    String str = intent.getStringExtra("PATH");
    int i = intent.getIntExtra("OFFSET", 0);
    int j = intent.getIntExtra("LENGTH", 0);
    int k = intent.getIntExtra("VOLUME", 0);
    this.skip = intent.getIntExtra("SKIP", 0);
    if (str.isEmpty() || j <= 0) {
      setResult(0, new Intent());
      finish();
      return;
    } 
    LinearLayout linearLayout = new LinearLayout((Context)this);
    linearLayout.setBackgroundColor(Color.rgb(0, 0, 0));
    linearLayout.setGravity(17);
    setContentView((View)linearLayout, (ViewGroup.LayoutParams)new WindowManager.LayoutParams(-1, -1));
    this.videoView = new ArtemisVideoView((Context)this);
    this.videoView.setZOrderOnTop(true);
    this.videoView.requestFocus();
    linearLayout.addView((View)this.videoView);
    this.videoView.setOnCompletionListener(this);
    try {
      if (this.file != null) {
        this.file.close();
        this.file = null;
      } 
      RandomAccessFile randomAccessFile = new RandomAccessFile();
      this(str, "r");
      this.file = randomAccessFile;
      this.videoView.setVideoSource(this.file.getFD(), i, j, k);
    } catch (Exception exception) {
      try {
        if (this.asset != null) {
          this.asset.close();
          this.asset = null;
        } 
        this.asset = getAssets().openFd(str);
        ArtemisVideoView artemisVideoView = this.videoView;
        FileDescriptor fileDescriptor = this.asset.getFileDescriptor();
        long l = this.asset.getStartOffset();
        artemisVideoView.setVideoSource(fileDescriptor, i + l, j, k);
      } catch (Exception exception1) {}
    } 
    this.videoView.start();
  }
  
  public void onPause() {
    super.onPause();
    this.pause = true;
    this.videoView.pause();
  }
  
  public void onResume() {
    super.onResume();
    if (Build.VERSION.SDK_INT >= 19)
      getWindow().getDecorView().setSystemUiVisibility(4102); 
    if (!this.pause)
      return; 
    this.pause = false;
    setResult(0, new Intent());
    finish();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (this.skip == 0)
      return super.onTouchEvent(paramMotionEvent); 
    int i = paramMotionEvent.getAction();
    if (i != 0) {
      if (i == 261 && this.skip <= 2)
        onCompletion((MediaPlayer)null); 
    } else if (this.skip <= 1) {
      onCompletion((MediaPlayer)null);
    } 
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\ies_net\artemis\VideoViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */