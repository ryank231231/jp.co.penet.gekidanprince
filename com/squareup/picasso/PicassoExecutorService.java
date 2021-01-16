package com.squareup.picasso;

import android.net.NetworkInfo;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class PicassoExecutorService extends ThreadPoolExecutor {
  private static final int DEFAULT_THREAD_COUNT = 3;
  
  PicassoExecutorService() {
    super(3, 3, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<Runnable>(), new Utils.PicassoThreadFactory());
  }
  
  private void setThreadCount(int paramInt) {
    setCorePoolSize(paramInt);
    setMaximumPoolSize(paramInt);
  }
  
  void adjustThreadCount(NetworkInfo paramNetworkInfo) {
    if (paramNetworkInfo == null || !paramNetworkInfo.isConnectedOrConnecting()) {
      setThreadCount(3);
      return;
    } 
    int i = paramNetworkInfo.getType();
    if (i != 6 && i != 9)
      switch (i) {
        default:
          setThreadCount(3);
          return;
        case 0:
          i = paramNetworkInfo.getSubtype();
          switch (i) {
            default:
              switch (i) {
                default:
                  setThreadCount(3);
                  return;
                case 13:
                case 14:
                case 15:
                  setThreadCount(3);
                  return;
                case 12:
                  break;
              } 
            case 3:
            case 4:
            case 5:
            case 6:
              setThreadCount(2);
              return;
            case 1:
            case 2:
              break;
          } 
          setThreadCount(1);
          return;
        case 1:
          break;
      }  
    setThreadCount(4);
  }
  
  public Future<?> submit(Runnable paramRunnable) {
    paramRunnable = new PicassoFutureTask((BitmapHunter)paramRunnable);
    execute(paramRunnable);
    return (Future<?>)paramRunnable;
  }
  
  private static final class PicassoFutureTask extends FutureTask<BitmapHunter> implements Comparable<PicassoFutureTask> {
    private final BitmapHunter hunter;
    
    public PicassoFutureTask(BitmapHunter param1BitmapHunter) {
      super(param1BitmapHunter, null);
      this.hunter = param1BitmapHunter;
    }
    
    public int compareTo(PicassoFutureTask param1PicassoFutureTask) {
      int i;
      Picasso.Priority priority1 = this.hunter.getPriority();
      Picasso.Priority priority2 = param1PicassoFutureTask.hunter.getPriority();
      if (priority1 == priority2) {
        i = this.hunter.sequence - param1PicassoFutureTask.hunter.sequence;
      } else {
        i = priority2.ordinal() - priority1.ordinal();
      } 
      return i;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\picasso\PicassoExecutorService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */