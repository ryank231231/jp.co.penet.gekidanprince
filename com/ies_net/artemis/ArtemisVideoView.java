package com.ies_net.artemis;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.MediaController;
import java.io.FileDescriptor;
import java.io.IOException;

public class ArtemisVideoView extends SurfaceView implements MediaController.MediaPlayerControl {
  private static final int STATE_ERROR = -1;
  
  private static final int STATE_IDLE = 0;
  
  private static final int STATE_PAUSED = 4;
  
  private static final int STATE_PLAYBACK_COMPLETED = 5;
  
  private static final int STATE_PLAYING = 3;
  
  private static final int STATE_PREPARED = 2;
  
  private static final int STATE_PREPARING = 1;
  
  private static final int STATE_RESUME = 7;
  
  private static final int STATE_SUSPEND = 6;
  
  private static final int STATE_SUSPEND_UNSUPPORTED = 8;
  
  private String TAG = "VideoView";
  
  private MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener() {
      public void onBufferingUpdate(MediaPlayer param1MediaPlayer, int param1Int) {
        ArtemisVideoView.access$1702(ArtemisVideoView.this, param1Int);
      }
    };
  
  private boolean mCanPause;
  
  private boolean mCanSeekBack;
  
  private boolean mCanSeekForward;
  
  private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
      public void onCompletion(MediaPlayer param1MediaPlayer) {
        ArtemisVideoView.access$202(ArtemisVideoView.this, 5);
        ArtemisVideoView.access$1202(ArtemisVideoView.this, 5);
        if (ArtemisVideoView.this.mMediaController != null)
          ArtemisVideoView.this.mMediaController.hide(); 
        if (ArtemisVideoView.this.mOnCompletionListener != null)
          ArtemisVideoView.this.mOnCompletionListener.onCompletion(ArtemisVideoView.this.mMediaPlayer); 
      }
    };
  
  private Context mContext;
  
  private int mCurrentBufferPercentage;
  
  private int mCurrentState = 0;
  
  private int mDuration;
  
  private MediaPlayer.OnErrorListener mErrorListener = new MediaPlayer.OnErrorListener() {
      public boolean onError(MediaPlayer param1MediaPlayer, int param1Int1, int param1Int2) {
        String str = ArtemisVideoView.this.TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error: ");
        stringBuilder.append(param1Int1);
        stringBuilder.append(",");
        stringBuilder.append(param1Int2);
        Log.d(str, stringBuilder.toString());
        ArtemisVideoView.access$202(ArtemisVideoView.this, -1);
        ArtemisVideoView.access$1202(ArtemisVideoView.this, -1);
        if (ArtemisVideoView.this.mMediaController != null)
          ArtemisVideoView.this.mMediaController.hide(); 
        if (ArtemisVideoView.this.mOnErrorListener != null && ArtemisVideoView.this.mOnErrorListener.onError(ArtemisVideoView.this.mMediaPlayer, param1Int1, param1Int2))
          return true; 
        if (ArtemisVideoView.this.getWindowToken() != null) {
          if (param1Int1 == 200) {
            param1Int1 = Resources.getSystem().getIdentifier("VideoView_error_text_invalid_progressive_playback", "string", "android");
          } else {
            param1Int1 = Resources.getSystem().getIdentifier("VideoView_error_text_unknown", "string", "android");
          } 
          (new AlertDialog.Builder(ArtemisVideoView.this.mContext)).setTitle(Resources.getSystem().getIdentifier("VideoView_error_title", "string", "android")).setMessage(param1Int1).setPositiveButton(Resources.getSystem().getIdentifier("VideoView_error_button", "string", "android"), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                  if (ArtemisVideoView.this.mOnCompletionListener != null)
                    ArtemisVideoView.this.mOnCompletionListener.onCompletion(ArtemisVideoView.this.mMediaPlayer); 
                }
              }).setCancelable(false).show();
        } 
        return true;
      }
    };
  
  private FileDescriptor mFd;
  
  private long mLength;
  
  private MediaController mMediaController;
  
  private MediaPlayer mMediaPlayer = null;
  
  private long mOffset;
  
  private MediaPlayer.OnCompletionListener mOnCompletionListener;
  
  private MediaPlayer.OnErrorListener mOnErrorListener;
  
  private MediaPlayer.OnPreparedListener mOnPreparedListener;
  
  MediaPlayer.OnPreparedListener mPreparedListener = new MediaPlayer.OnPreparedListener() {
      public void onPrepared(MediaPlayer param1MediaPlayer) {
        ArtemisVideoView.access$202(ArtemisVideoView.this, 2);
        ArtemisVideoView artemisVideoView = ArtemisVideoView.this;
        ArtemisVideoView.access$302(artemisVideoView, ArtemisVideoView.access$402(artemisVideoView, ArtemisVideoView.access$502(artemisVideoView, false)));
        if (ArtemisVideoView.this.mOnPreparedListener != null)
          ArtemisVideoView.this.mOnPreparedListener.onPrepared(ArtemisVideoView.this.mMediaPlayer); 
        if (ArtemisVideoView.this.mMediaController != null)
          ArtemisVideoView.this.mMediaController.setEnabled(true); 
        ArtemisVideoView.access$002(ArtemisVideoView.this, param1MediaPlayer.getVideoWidth());
        ArtemisVideoView.access$102(ArtemisVideoView.this, param1MediaPlayer.getVideoHeight());
        int i = ArtemisVideoView.this.mSeekWhenPrepared;
        if (i != 0)
          ArtemisVideoView.this.seekTo(i); 
        if (ArtemisVideoView.this.mVideoWidth != 0 && ArtemisVideoView.this.mVideoHeight != 0) {
          ArtemisVideoView.this.getHolder().setFixedSize(ArtemisVideoView.this.mVideoWidth, ArtemisVideoView.this.mVideoHeight);
          if (ArtemisVideoView.this.mSurfaceWidth == ArtemisVideoView.this.mVideoWidth && ArtemisVideoView.this.mSurfaceHeight == ArtemisVideoView.this.mVideoHeight)
            if (ArtemisVideoView.this.mTargetState == 3) {
              ArtemisVideoView.this.start();
              if (ArtemisVideoView.this.mMediaController != null)
                ArtemisVideoView.this.mMediaController.show(); 
            } else if (!ArtemisVideoView.this.isPlaying() && (i != 0 || ArtemisVideoView.this.getCurrentPosition() > 0) && ArtemisVideoView.this.mMediaController != null) {
              ArtemisVideoView.this.mMediaController.show(0);
            }  
        } else if (ArtemisVideoView.this.mTargetState == 3) {
          ArtemisVideoView.this.start();
        } 
      }
    };
  
  SurfaceHolder.Callback mSHCallback = new SurfaceHolder.Callback() {
      public void surfaceChanged(SurfaceHolder param1SurfaceHolder, int param1Int1, int param1Int2, int param1Int3) {
        ArtemisVideoView.access$1002(ArtemisVideoView.this, param1Int2);
        ArtemisVideoView.access$1102(ArtemisVideoView.this, param1Int3);
        param1Int1 = ArtemisVideoView.this.mTargetState;
        boolean bool = true;
        if (param1Int1 == 3) {
          param1Int1 = 1;
        } else {
          param1Int1 = 0;
        } 
        if (ArtemisVideoView.this.mVideoWidth == param1Int2 && ArtemisVideoView.this.mVideoHeight == param1Int3) {
          param1Int2 = bool;
        } else {
          param1Int2 = 0;
        } 
        if (ArtemisVideoView.this.mMediaPlayer != null && param1Int1 != 0 && param1Int2 != 0) {
          if (ArtemisVideoView.this.mSeekWhenPrepared != 0) {
            ArtemisVideoView artemisVideoView = ArtemisVideoView.this;
            artemisVideoView.seekTo(artemisVideoView.mSeekWhenPrepared);
          } 
          ArtemisVideoView.this.start();
          if (ArtemisVideoView.this.mMediaController != null) {
            if (ArtemisVideoView.this.mMediaController.isShowing())
              ArtemisVideoView.this.mMediaController.hide(); 
            ArtemisVideoView.this.mMediaController.show();
          } 
        } 
      }
      
      public void surfaceCreated(SurfaceHolder param1SurfaceHolder) {
        ArtemisVideoView.access$1802(ArtemisVideoView.this, param1SurfaceHolder);
        if (ArtemisVideoView.this.mMediaPlayer != null && ArtemisVideoView.this.mCurrentState == 6 && ArtemisVideoView.this.mTargetState == 7) {
          ArtemisVideoView.this.mMediaPlayer.setDisplay(ArtemisVideoView.this.mSurfaceHolder);
          ArtemisVideoView.this.resume();
        } else {
          ArtemisVideoView.this.openVideo();
        } 
      }
      
      public void surfaceDestroyed(SurfaceHolder param1SurfaceHolder) {
        ArtemisVideoView.access$1802(ArtemisVideoView.this, (SurfaceHolder)null);
        if (ArtemisVideoView.this.mMediaController != null)
          ArtemisVideoView.this.mMediaController.hide(); 
        if (ArtemisVideoView.this.mCurrentState != 6)
          ArtemisVideoView.this.release(true); 
      }
    };
  
  private int mSeekWhenPrepared;
  
  MediaPlayer.OnVideoSizeChangedListener mSizeChangedListener = new MediaPlayer.OnVideoSizeChangedListener() {
      public void onVideoSizeChanged(MediaPlayer param1MediaPlayer, int param1Int1, int param1Int2) {
        ArtemisVideoView.access$002(ArtemisVideoView.this, param1MediaPlayer.getVideoWidth());
        ArtemisVideoView.access$102(ArtemisVideoView.this, param1MediaPlayer.getVideoHeight());
        if (ArtemisVideoView.this.mVideoWidth != 0 && ArtemisVideoView.this.mVideoHeight != 0)
          ArtemisVideoView.this.getHolder().setFixedSize(ArtemisVideoView.this.mVideoWidth, ArtemisVideoView.this.mVideoHeight); 
      }
    };
  
  private int mStateWhenSuspended;
  
  private int mSurfaceHeight;
  
  private SurfaceHolder mSurfaceHolder = null;
  
  private int mSurfaceWidth;
  
  private int mTargetState = 0;
  
  private int mVideoHeight;
  
  private int mVideoWidth;
  
  private float mVolume;
  
  public ArtemisVideoView(Context paramContext) {
    super(paramContext);
    this.mContext = paramContext;
    initVideoView();
  }
  
  public ArtemisVideoView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
    this.mContext = paramContext;
    initVideoView();
  }
  
  public ArtemisVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    initVideoView();
  }
  
  private void attachMediaController() {
    if (this.mMediaPlayer != null) {
      MediaController mediaController = this.mMediaController;
      if (mediaController != null) {
        ArtemisVideoView artemisVideoView;
        mediaController.setMediaPlayer(this);
        if (getParent() instanceof View) {
          View view = (View)getParent();
        } else {
          artemisVideoView = this;
        } 
        this.mMediaController.setAnchorView((View)artemisVideoView);
        this.mMediaController.setEnabled(isInPlaybackState());
      } 
    } 
  }
  
  private void initVideoView() {
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    getHolder().addCallback(this.mSHCallback);
    getHolder().setType(3);
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
    this.mCurrentState = 0;
    this.mTargetState = 0;
  }
  
  private boolean isInPlaybackState() {
    MediaPlayer mediaPlayer = this.mMediaPlayer;
    null = true;
    if (mediaPlayer != null) {
      int i = this.mCurrentState;
      if (i != -1 && i != 0 && i != 1)
        return null; 
    } 
    return false;
  }
  
  private void openVideo() {
    if (this.mFd == null || this.mSurfaceHolder == null)
      return; 
    Intent intent = new Intent("com.android.music.musicservicecommand");
    intent.putExtra("command", "pause");
    this.mContext.sendBroadcast(intent);
    release(false);
    try {
      MediaPlayer mediaPlayer = new MediaPlayer();
      this();
      this.mMediaPlayer = mediaPlayer;
      this.mMediaPlayer.setOnPreparedListener(this.mPreparedListener);
      this.mMediaPlayer.setOnVideoSizeChangedListener(this.mSizeChangedListener);
      this.mDuration = -1;
      this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
      this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
      this.mMediaPlayer.setOnBufferingUpdateListener(this.mBufferingUpdateListener);
      this.mCurrentBufferPercentage = 0;
      this.mMediaPlayer.setDataSource(this.mFd, this.mOffset, this.mLength);
      this.mMediaPlayer.setDisplay(this.mSurfaceHolder);
      this.mMediaPlayer.setAudioStreamType(3);
      this.mMediaPlayer.setVolume(this.mVolume, this.mVolume);
      this.mMediaPlayer.setScreenOnWhilePlaying(true);
      this.mMediaPlayer.prepareAsync();
      this.mCurrentState = 1;
      attachMediaController();
      return;
    } catch (IOException iOException) {
      String str = this.TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to open content: ");
      stringBuilder.append(this.mFd);
      Log.w(str, stringBuilder.toString(), iOException);
      this.mCurrentState = -1;
      this.mTargetState = -1;
      this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
      return;
    } catch (IllegalArgumentException illegalArgumentException) {
      String str = this.TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to open content: ");
      stringBuilder.append(this.mFd);
      Log.w(str, stringBuilder.toString(), illegalArgumentException);
      this.mCurrentState = -1;
      this.mTargetState = -1;
      this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
      return;
    } 
  }
  
  private void release(boolean paramBoolean) {
    MediaPlayer mediaPlayer = this.mMediaPlayer;
    if (mediaPlayer != null) {
      mediaPlayer.reset();
      this.mMediaPlayer.release();
      this.mMediaPlayer = null;
      this.mCurrentState = 0;
      if (paramBoolean)
        this.mTargetState = 0; 
    } 
  }
  
  private void toggleMediaControlsVisiblity() {
    if (this.mMediaController.isShowing()) {
      this.mMediaController.hide();
    } else {
      this.mMediaController.show();
    } 
  }
  
  public boolean canPause() {
    return this.mCanPause;
  }
  
  public boolean canSeekBackward() {
    return this.mCanSeekBack;
  }
  
  public boolean canSeekForward() {
    return this.mCanSeekForward;
  }
  
  public int getAudioSessionId() {
    return 0;
  }
  
  public int getBufferPercentage() {
    return (this.mMediaPlayer != null) ? this.mCurrentBufferPercentage : 0;
  }
  
  public int getCurrentPosition() {
    return isInPlaybackState() ? this.mMediaPlayer.getCurrentPosition() : 0;
  }
  
  public int getDuration() {
    if (isInPlaybackState()) {
      int i = this.mDuration;
      if (i > 0)
        return i; 
      this.mDuration = this.mMediaPlayer.getDuration();
      return this.mDuration;
    } 
    this.mDuration = -1;
    return this.mDuration;
  }
  
  public boolean isPlaying() {
    boolean bool;
    if (isInPlaybackState() && this.mMediaPlayer.isPlaying()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    boolean bool;
    if (paramInt != 4 && paramInt != 24 && paramInt != 25 && paramInt != 82 && paramInt != 5 && paramInt != 6) {
      bool = true;
    } else {
      bool = false;
    } 
    if (isInPlaybackState() && bool && this.mMediaController != null) {
      if (paramInt == 79 || paramInt == 85) {
        if (this.mMediaPlayer.isPlaying()) {
          pause();
          this.mMediaController.show();
        } else {
          start();
          this.mMediaController.hide();
        } 
        return true;
      } 
      if (paramInt == 86 && this.mMediaPlayer.isPlaying()) {
        pause();
        this.mMediaController.show();
      } else {
        toggleMediaControlsVisiblity();
      } 
    } 
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    int i = getDefaultSize(this.mVideoWidth, paramInt1);
    int j = getDefaultSize(this.mVideoHeight, paramInt2);
    int k = this.mVideoWidth;
    paramInt2 = i;
    paramInt1 = j;
    if (k > 0) {
      int m = this.mVideoHeight;
      paramInt2 = i;
      paramInt1 = j;
      if (m > 0)
        if (k * j > i * m) {
          paramInt1 = m * i / k;
          paramInt2 = i;
        } else {
          paramInt2 = i;
          paramInt1 = j;
          if (k * j < i * m) {
            paramInt2 = k * j / m;
            paramInt1 = j;
          } 
        }  
    } 
    setMeasuredDimension(paramInt2, paramInt1);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (isInPlaybackState() && this.mMediaController != null)
      toggleMediaControlsVisiblity(); 
    return false;
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent) {
    if (isInPlaybackState() && this.mMediaController != null)
      toggleMediaControlsVisiblity(); 
    return false;
  }
  
  public void pause() {
    if (isInPlaybackState() && this.mMediaPlayer.isPlaying()) {
      this.mMediaPlayer.pause();
      this.mCurrentState = 4;
    } 
    this.mTargetState = 4;
  }
  
  public int resolveAdjustedSize(int paramInt1, int paramInt2) {
    int i = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt2);
    if (i != Integer.MIN_VALUE) {
      paramInt2 = paramInt1;
      if (i != 0)
        if (i != 1073741824) {
          paramInt2 = paramInt1;
        } else {
          paramInt2 = j;
        }  
    } else {
      paramInt2 = Math.min(paramInt1, j);
    } 
    return paramInt2;
  }
  
  public void resume() {
    if (this.mSurfaceHolder == null && this.mCurrentState == 6) {
      this.mTargetState = 7;
      return;
    } 
    MediaPlayer mediaPlayer = this.mMediaPlayer;
    if (mediaPlayer != null && this.mCurrentState == 6) {
      mediaPlayer.start();
      int i = this.mStateWhenSuspended;
      this.mCurrentState = i;
      this.mTargetState = i;
      return;
    } 
    if (this.mCurrentState == 8)
      openVideo(); 
  }
  
  public void seekTo(int paramInt) {
    if (isInPlaybackState()) {
      this.mMediaPlayer.seekTo(paramInt);
      this.mSeekWhenPrepared = 0;
    } else {
      this.mSeekWhenPrepared = paramInt;
    } 
  }
  
  public void setMediaController(MediaController paramMediaController) {
    MediaController mediaController = this.mMediaController;
    if (mediaController != null)
      mediaController.hide(); 
    this.mMediaController = paramMediaController;
    attachMediaController();
  }
  
  public void setOnCompletionListener(MediaPlayer.OnCompletionListener paramOnCompletionListener) {
    this.mOnCompletionListener = paramOnCompletionListener;
  }
  
  public void setOnErrorListener(MediaPlayer.OnErrorListener paramOnErrorListener) {
    this.mOnErrorListener = paramOnErrorListener;
  }
  
  public void setOnPreparedListener(MediaPlayer.OnPreparedListener paramOnPreparedListener) {
    this.mOnPreparedListener = paramOnPreparedListener;
  }
  
  public void setVideoSource(FileDescriptor paramFileDescriptor, long paramLong1, long paramLong2, int paramInt) {
    this.mFd = paramFileDescriptor;
    this.mOffset = paramLong1;
    this.mLength = paramLong2;
    if (paramInt >= 1000) {
      this.mVolume = 1.0F;
    } else if (paramInt <= 0) {
      this.mVolume = 0.0F;
    } else {
      this.mVolume = paramInt / 1000.0F;
    } 
    this.mSeekWhenPrepared = 0;
    openVideo();
    requestLayout();
    invalidate();
  }
  
  public void start() {
    if (isInPlaybackState()) {
      this.mMediaPlayer.start();
      this.mCurrentState = 3;
    } 
    this.mTargetState = 3;
  }
  
  public void stopPlayback() {
    MediaPlayer mediaPlayer = this.mMediaPlayer;
    if (mediaPlayer != null) {
      mediaPlayer.stop();
      this.mMediaPlayer.release();
      this.mMediaPlayer = null;
      this.mCurrentState = 0;
      this.mTargetState = 0;
    } 
  }
  
  public void suspend() {
    if (isInPlaybackState()) {
      this.mMediaPlayer.stop();
      this.mStateWhenSuspended = this.mCurrentState;
      this.mCurrentState = 6;
      this.mTargetState = 6;
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\ies_net\artemis\ArtemisVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */