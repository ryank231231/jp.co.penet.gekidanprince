package com.ies_net.artemis;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.StatFs;
import android.provider.Settings;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DownloadActivity extends Activity {
  private String dir;
  
  private String name;
  
  private DownloadActivity self;
  
  private String url;
  
  public void finish() {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    Intent intent = getIntent();
    this.dir = intent.getStringExtra("DIR");
    this.name = intent.getStringExtra("NAME");
    this.url = intent.getStringExtra("URL");
    this.self = this;
    if (this.dir.isEmpty() || this.name.isEmpty() || this.url.isEmpty()) {
      setResult(0, new Intent());
      finish();
      return;
    } 
    getWindow().setFlags(4195456, 4195456);
    runOnUiThread(new Runnable() {
          public void run() {
            (new DownloadActivity.HttpTask()).execute((Object[])new String[0]);
          }
        });
  }
  
  public void onPause() {
    super.onPause();
  }
  
  public void onResume() {
    super.onResume();
    if (Build.VERSION.SDK_INT >= 19)
      getWindow().getDecorView().setSystemUiVisibility(4102); 
  }
  
  class HttpTask extends AsyncTask<String, Void, String> {
    private AlertDialog.Builder dialog;
    
    private long length;
    
    private ProgressDialog progress;
    
    private int resumeYesNo;
    
    private long start;
    
    private int urlIndex;
    
    private int urlTotal;
    
    protected String doInBackground(String... param1VarArgs) {
      try {
        File file = new File();
        this(DownloadActivity.this.dir);
        file.mkdirs();
        String str = Settings.Secure.getString(DownloadActivity.this.self.getContentResolver(), "android_id");
        StringTokenizer stringTokenizer1 = new StringTokenizer();
        this(DownloadActivity.this.url, "|");
        Vector<String> vector2 = new Vector();
        this();
        while (stringTokenizer1.hasMoreTokens())
          vector2.add(stringTokenizer1.nextToken()); 
        StringTokenizer stringTokenizer2 = new StringTokenizer();
        this(DownloadActivity.this.name, "|");
        Vector<String> vector1 = new Vector();
        this();
        while (stringTokenizer2.hasMoreTokens())
          vector1.add(stringTokenizer2.nextToken()); 
        this.urlIndex = 0;
        this.urlTotal = vector2.size();
        while (true) {
          if (this.urlIndex < this.urlTotal) {
            StringBuilder stringBuilder = new StringBuilder();
            this();
            stringBuilder.append(DownloadActivity.this.dir);
            stringBuilder.append("/");
            stringBuilder.append(vector1.get(this.urlIndex));
            String str1 = stringBuilder.toString();
            File file1 = new File();
            this(str1);
            if (file1.length() <= 0L) {
              DownloadActivity downloadActivity;
              file1 = new File();
              StringBuilder stringBuilder1 = new StringBuilder();
              this();
              stringBuilder1.append(str1);
              stringBuilder1.append(".download");
              this(stringBuilder1.toString());
              URL uRL = new URL();
              this(vector2.get(this.urlIndex));
              HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
              httpURLConnection.setConnectTimeout(10000);
              httpURLConnection.setReadTimeout(10000);
              httpURLConnection.setRequestProperty("Android-ID", str);
              if (file1.length() > 0L) {
                this.resumeYesNo = 0;
                AlertDialog.Builder builder1 = new AlertDialog.Builder();
                this();
                this.dialog = builder1;
                this.dialog.setCancelable(false);
                this.dialog.setTitle("Download");
                this.dialog.setMessage("Do you want to resume the download?");
                builder1 = this.dialog;
                DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                      DownloadActivity.HttpTask.access$402(DownloadActivity.HttpTask.this, 1);
                    }
                  };
                super(this);
                builder1.setPositiveButton("Yes", onClickListener2);
                AlertDialog.Builder builder2 = this.dialog;
                DialogInterface.OnClickListener onClickListener1 = new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                      DownloadActivity.HttpTask.access$402(DownloadActivity.HttpTask.this, -1);
                    }
                  };
                super(this);
                builder2.setNegativeButton("No", onClickListener1);
                DownloadActivity downloadActivity1 = DownloadActivity.this;
                Runnable runnable = new Runnable() {
                    public void run() {
                      DownloadActivity.HttpTask.this.dialog.show();
                    }
                  };
                super(this);
                downloadActivity1.runOnUiThread(runnable);
                try {
                  while (this.resumeYesNo == 0)
                    Thread.sleep(1000L); 
                } catch (Exception exception) {}
                this.dialog = null;
                if (this.resumeYesNo > 0) {
                  this.start = file1.length();
                  StringBuilder stringBuilder2 = new StringBuilder();
                  this();
                  stringBuilder2.append("bytes=");
                  stringBuilder2.append(this.start);
                  stringBuilder2.append("-");
                  httpURLConnection.setRequestProperty("Range", stringBuilder2.toString());
                } else {
                  this.start = 0L;
                  file1.delete();
                  file1.createNewFile();
                } 
              } else {
                this.start = 0L;
              } 
              httpURLConnection.setDoInput(true);
              int i = httpURLConnection.getResponseCode();
              if (i == 200 || i == 206) {
                this.length = httpURLConnection.getContentLength();
                if (this.length <= 0L)
                  this.length = httpURLConnection.getHeaderFieldInt("X-Content-Length", 0); 
                if (this.start > 0L) {
                  String str2 = httpURLConnection.getHeaderField("Content-Range");
                  if (str2 != null) {
                    Matcher matcher = Pattern.compile("bytes +([0-9]+)-([0-9]+)/([0-9*]+)").matcher(str2);
                    if (!matcher.find() || matcher.groupCount() != 3 || Integer.parseInt(matcher.group(1)) != this.start) {
                      AlertDialog.Builder builder = new AlertDialog.Builder();
                      this();
                      this.dialog = builder;
                      this.dialog.setTitle("Download failed");
                      this.dialog.setMessage("Resume download failed.");
                      builder = this.dialog;
                      DialogInterface.OnCancelListener onCancelListener = new DialogInterface.OnCancelListener() {
                          public void onCancel(DialogInterface param2DialogInterface) {
                            Intent intent = new Intent();
                            DownloadActivity.this.setResult(0, intent);
                            DownloadActivity.this.finish();
                          }
                        };
                      super(this);
                      builder.setOnCancelListener(onCancelListener);
                      builder = this.dialog;
                      DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
                          public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                            Intent intent = new Intent();
                            DownloadActivity.this.setResult(0, intent);
                            DownloadActivity.this.finish();
                          }
                        };
                      super(this);
                      builder.setPositiveButton("OK", onClickListener);
                      DownloadActivity downloadActivity2 = DownloadActivity.this;
                      Runnable runnable1 = new Runnable() {
                          public void run() {
                            DownloadActivity.HttpTask.this.dialog.show();
                          }
                        };
                      super(this);
                      downloadActivity2.runOnUiThread(runnable1);
                      return null;
                    } 
                  } else {
                    this.start = 0L;
                  } 
                } 
                if (this.length > 0L) {
                  StatFs statFs = new StatFs();
                  this(DownloadActivity.this.dir);
                  long l1 = this.length;
                  long l2 = statFs.getAvailableBlocks() * statFs.getBlockSize();
                  if (l1 > l2) {
                    AlertDialog.Builder builder = new AlertDialog.Builder();
                    this();
                    this.dialog = builder;
                    this.dialog.setTitle("Download failed");
                    this.dialog.setMessage(String.format("There is not enough storage space.\n\nRequire %d Bytes.\nAvailable %d Bytes.", new Object[] { Long.valueOf(l1), Long.valueOf(l2) }));
                    builder = this.dialog;
                    DialogInterface.OnCancelListener onCancelListener = new DialogInterface.OnCancelListener() {
                        public void onCancel(DialogInterface param2DialogInterface) {
                          Intent intent = new Intent();
                          DownloadActivity.this.setResult(0, intent);
                          DownloadActivity.this.finish();
                        }
                      };
                    super(this);
                    builder.setOnCancelListener(onCancelListener);
                    builder = this.dialog;
                    DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                          Intent intent = new Intent();
                          DownloadActivity.this.setResult(0, intent);
                          DownloadActivity.this.finish();
                        }
                      };
                    super(this);
                    builder.setPositiveButton("OK", onClickListener);
                    DownloadActivity downloadActivity2 = DownloadActivity.this;
                    Runnable runnable1 = new Runnable() {
                        public void run() {
                          DownloadActivity.HttpTask.this.dialog.show();
                        }
                      };
                    super(this);
                    downloadActivity2.runOnUiThread(runnable1);
                    return null;
                  } 
                } 
                DownloadActivity downloadActivity1 = DownloadActivity.this;
                Runnable runnable = new Runnable() {
                    public void run() {
                      DownloadActivity.HttpTask httpTask = DownloadActivity.HttpTask.this;
                      DownloadActivity.HttpTask.access$602(httpTask, new ProgressDialog((Context)DownloadActivity.this.self));
                      DownloadActivity.HttpTask.this.progress.setCancelable(false);
                      DownloadActivity.HttpTask.this.progress.setTitle("Download");
                      DownloadActivity.HttpTask.this.progress.setMessage(String.format("Downloading Game Data... (%d/%d)", new Object[] { Integer.valueOf(DownloadActivity.HttpTask.access$700(this.this$1) + 1), Integer.valueOf(DownloadActivity.HttpTask.access$800(this.this$1)) }));
                      if (DownloadActivity.HttpTask.this.length > 0L) {
                        DownloadActivity.HttpTask.this.progress.setProgressStyle(1);
                        DownloadActivity.HttpTask.this.progress.setMax((int)(DownloadActivity.HttpTask.this.start + DownloadActivity.HttpTask.this.length));
                        DownloadActivity.HttpTask.this.progress.incrementProgressBy((int)DownloadActivity.HttpTask.this.start);
                      } else {
                        DownloadActivity.HttpTask.this.progress.setProgressStyle(0);
                      } 
                      DownloadActivity.HttpTask.this.progress.show();
                    }
                  };
                super(this);
                downloadActivity1.runOnUiThread(runnable);
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedInputStream bufferedInputStream = new BufferedInputStream();
                this(inputStream, 1048576);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream();
                FileOutputStream fileOutputStream = new FileOutputStream();
                this(file1, true);
                this(fileOutputStream, 1048576);
                byte[] arrayOfByte = new byte[1048576];
                while (true) {
                  i = bufferedInputStream.read(arrayOfByte);
                  if (i != -1) {
                    bufferedOutputStream.write(arrayOfByte, 0, i);
                    if (this.progress != null && this.length > 0L)
                      this.progress.incrementProgressBy(i); 
                    continue;
                  } 
                  httpURLConnection.disconnect();
                  bufferedOutputStream.flush();
                  bufferedOutputStream.close();
                  bufferedInputStream.close();
                  File file2 = new File();
                  this(str1);
                  file1.renameTo(file2);
                  if (this.progress != null) {
                    downloadActivity = DownloadActivity.this;
                    Runnable runnable1 = new Runnable() {
                        public void run() {
                          DownloadActivity.HttpTask.this.progress.dismiss();
                          DownloadActivity.HttpTask.access$602(DownloadActivity.HttpTask.this, (ProgressDialog)null);
                        }
                      };
                    super(this);
                    downloadActivity.runOnUiThread(runnable1);
                  } 
                  break;
                } 
              } else {
                downloadActivity.delete();
                AlertDialog.Builder builder1 = new AlertDialog.Builder();
                this();
                this.dialog = builder1;
                this.dialog.setTitle("Download failed");
                this.dialog.setMessage(String.format("Download failed (%d)", new Object[] { Integer.valueOf(i) }));
                builder1 = this.dialog;
                DialogInterface.OnCancelListener onCancelListener = new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface param2DialogInterface) {
                      Intent intent = new Intent();
                      DownloadActivity.this.setResult(0, intent);
                      DownloadActivity.this.finish();
                    }
                  };
                super(this);
                builder1.setOnCancelListener(onCancelListener);
                AlertDialog.Builder builder2 = this.dialog;
                DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                      Intent intent = new Intent();
                      DownloadActivity.this.setResult(0, intent);
                      DownloadActivity.this.finish();
                    }
                  };
                super(this);
                builder2.setPositiveButton("OK", onClickListener);
                DownloadActivity downloadActivity1 = DownloadActivity.this;
                Runnable runnable = new Runnable() {
                    public void run() {
                      DownloadActivity.HttpTask.this.dialog.show();
                    }
                  };
                super(this);
                downloadActivity1.runOnUiThread(runnable);
                return null;
              } 
            } 
            this.urlIndex++;
            continue;
          } 
          return null;
        } 
      } catch (IOException iOException) {
        this.dialog = new AlertDialog.Builder((Context)DownloadActivity.this.self);
        this.dialog.setTitle("Download failed");
        this.dialog.setMessage("Download failed");
        this.dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
              public void onCancel(DialogInterface param2DialogInterface) {
                Intent intent = new Intent();
                DownloadActivity.this.setResult(0, intent);
                DownloadActivity.this.finish();
              }
            });
        this.dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                Intent intent = new Intent();
                DownloadActivity.this.setResult(0, intent);
                DownloadActivity.this.finish();
              }
            });
        DownloadActivity.this.runOnUiThread(new Runnable() {
              public void run() {
                DownloadActivity.HttpTask.this.dialog.show();
              }
            });
        return null;
      } catch (Exception exception) {
        Log.e("Artemis", "Download failed. Unknown exception.");
        return null;
      } 
    }
    
    protected void onPostExecute(String param1String) {
      if (this.dialog != null)
        return; 
      Intent intent = new Intent();
      DownloadActivity.this.setResult(-1, intent);
      DownloadActivity.this.finish();
    }
    
    protected void onPreExecute() {
      this.progress = null;
      this.dialog = null;
      this.start = 0L;
      this.length = -1L;
    }
  }
  
  class null implements DialogInterface.OnClickListener {
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      DownloadActivity.HttpTask.access$402(this.this$1, 1);
    }
  }
  
  class null implements Runnable {
    public void run() {
      DownloadActivity.HttpTask httpTask = this.this$1;
      DownloadActivity.HttpTask.access$602(httpTask, new ProgressDialog((Context)DownloadActivity.this.self));
      this.this$1.progress.setCancelable(false);
      this.this$1.progress.setTitle("Download");
      this.this$1.progress.setMessage(String.format("Downloading Game Data... (%d/%d)", new Object[] { Integer.valueOf(DownloadActivity.HttpTask.access$700(this.this$1) + 1), Integer.valueOf(DownloadActivity.HttpTask.access$800(this.this$1)) }));
      if (this.this$1.length > 0L) {
        this.this$1.progress.setProgressStyle(1);
        this.this$1.progress.setMax((int)(this.this$1.start + this.this$1.length));
        this.this$1.progress.incrementProgressBy((int)this.this$1.start);
      } else {
        this.this$1.progress.setProgressStyle(0);
      } 
      this.this$1.progress.show();
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$1.progress.dismiss();
      DownloadActivity.HttpTask.access$602(this.this$1, (ProgressDialog)null);
    }
  }
  
  class null implements DialogInterface.OnCancelListener {
    public void onCancel(DialogInterface param1DialogInterface) {
      Intent intent = new Intent();
      DownloadActivity.this.setResult(0, intent);
      DownloadActivity.this.finish();
    }
  }
  
  class null implements DialogInterface.OnClickListener {
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      Intent intent = new Intent();
      DownloadActivity.this.setResult(0, intent);
      DownloadActivity.this.finish();
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$1.dialog.show();
    }
  }
  
  class null implements DialogInterface.OnCancelListener {
    public void onCancel(DialogInterface param1DialogInterface) {
      Intent intent = new Intent();
      DownloadActivity.this.setResult(0, intent);
      DownloadActivity.this.finish();
    }
  }
  
  class null implements DialogInterface.OnClickListener {
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      Intent intent = new Intent();
      DownloadActivity.this.setResult(0, intent);
      DownloadActivity.this.finish();
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$1.dialog.show();
    }
  }
  
  class null implements DialogInterface.OnClickListener {
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      DownloadActivity.HttpTask.access$402(this.this$1, -1);
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$1.dialog.show();
    }
  }
  
  class null implements DialogInterface.OnCancelListener {
    public void onCancel(DialogInterface param1DialogInterface) {
      Intent intent = new Intent();
      DownloadActivity.this.setResult(0, intent);
      DownloadActivity.this.finish();
    }
  }
  
  class null implements DialogInterface.OnClickListener {
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      Intent intent = new Intent();
      DownloadActivity.this.setResult(0, intent);
      DownloadActivity.this.finish();
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$1.dialog.show();
    }
  }
  
  class null implements DialogInterface.OnCancelListener {
    public void onCancel(DialogInterface param1DialogInterface) {
      Intent intent = new Intent();
      DownloadActivity.this.setResult(0, intent);
      DownloadActivity.this.finish();
    }
  }
  
  class null implements DialogInterface.OnClickListener {
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      Intent intent = new Intent();
      DownloadActivity.this.setResult(0, intent);
      DownloadActivity.this.finish();
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$1.dialog.show();
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\ies_net\artemis\DownloadActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */