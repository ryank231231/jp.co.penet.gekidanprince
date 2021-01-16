package com.squareup.picasso;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;

public class StatsSnapshot {
  public final long averageDownloadSize;
  
  public final long averageOriginalBitmapSize;
  
  public final long averageTransformedBitmapSize;
  
  public final long cacheHits;
  
  public final long cacheMisses;
  
  public final int downloadCount;
  
  public final int maxSize;
  
  public final int originalBitmapCount;
  
  public final int size;
  
  public final long timeStamp;
  
  public final long totalDownloadSize;
  
  public final long totalOriginalBitmapSize;
  
  public final long totalTransformedBitmapSize;
  
  public final int transformedBitmapCount;
  
  public StatsSnapshot(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, int paramInt3, int paramInt4, int paramInt5, long paramLong9) {
    this.maxSize = paramInt1;
    this.size = paramInt2;
    this.cacheHits = paramLong1;
    this.cacheMisses = paramLong2;
    this.totalDownloadSize = paramLong3;
    this.totalOriginalBitmapSize = paramLong4;
    this.totalTransformedBitmapSize = paramLong5;
    this.averageDownloadSize = paramLong6;
    this.averageOriginalBitmapSize = paramLong7;
    this.averageTransformedBitmapSize = paramLong8;
    this.downloadCount = paramInt3;
    this.originalBitmapCount = paramInt4;
    this.transformedBitmapCount = paramInt5;
    this.timeStamp = paramLong9;
  }
  
  public void dump() {
    StringWriter stringWriter = new StringWriter();
    dump(new PrintWriter(stringWriter));
    Log.i("Picasso", stringWriter.toString());
  }
  
  public void dump(PrintWriter paramPrintWriter) {
    paramPrintWriter.println("===============BEGIN PICASSO STATS ===============");
    paramPrintWriter.println("Memory Cache Stats");
    paramPrintWriter.print("  Max Cache Size: ");
    paramPrintWriter.println(this.maxSize);
    paramPrintWriter.print("  Cache Size: ");
    paramPrintWriter.println(this.size);
    paramPrintWriter.print("  Cache % Full: ");
    paramPrintWriter.println((int)Math.ceil((this.size / this.maxSize * 100.0F)));
    paramPrintWriter.print("  Cache Hits: ");
    paramPrintWriter.println(this.cacheHits);
    paramPrintWriter.print("  Cache Misses: ");
    paramPrintWriter.println(this.cacheMisses);
    paramPrintWriter.println("Network Stats");
    paramPrintWriter.print("  Download Count: ");
    paramPrintWriter.println(this.downloadCount);
    paramPrintWriter.print("  Total Download Size: ");
    paramPrintWriter.println(this.totalDownloadSize);
    paramPrintWriter.print("  Average Download Size: ");
    paramPrintWriter.println(this.averageDownloadSize);
    paramPrintWriter.println("Bitmap Stats");
    paramPrintWriter.print("  Total Bitmaps Decoded: ");
    paramPrintWriter.println(this.originalBitmapCount);
    paramPrintWriter.print("  Total Bitmap Size: ");
    paramPrintWriter.println(this.totalOriginalBitmapSize);
    paramPrintWriter.print("  Total Transformed Bitmaps: ");
    paramPrintWriter.println(this.transformedBitmapCount);
    paramPrintWriter.print("  Total Transformed Bitmap Size: ");
    paramPrintWriter.println(this.totalTransformedBitmapSize);
    paramPrintWriter.print("  Average Bitmap Size: ");
    paramPrintWriter.println(this.averageOriginalBitmapSize);
    paramPrintWriter.print("  Average Transformed Bitmap Size: ");
    paramPrintWriter.println(this.averageTransformedBitmapSize);
    paramPrintWriter.println("===============END PICASSO STATS ===============");
    paramPrintWriter.flush();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("StatsSnapshot{maxSize=");
    stringBuilder.append(this.maxSize);
    stringBuilder.append(", size=");
    stringBuilder.append(this.size);
    stringBuilder.append(", cacheHits=");
    stringBuilder.append(this.cacheHits);
    stringBuilder.append(", cacheMisses=");
    stringBuilder.append(this.cacheMisses);
    stringBuilder.append(", downloadCount=");
    stringBuilder.append(this.downloadCount);
    stringBuilder.append(", totalDownloadSize=");
    stringBuilder.append(this.totalDownloadSize);
    stringBuilder.append(", averageDownloadSize=");
    stringBuilder.append(this.averageDownloadSize);
    stringBuilder.append(", totalOriginalBitmapSize=");
    stringBuilder.append(this.totalOriginalBitmapSize);
    stringBuilder.append(", totalTransformedBitmapSize=");
    stringBuilder.append(this.totalTransformedBitmapSize);
    stringBuilder.append(", averageOriginalBitmapSize=");
    stringBuilder.append(this.averageOriginalBitmapSize);
    stringBuilder.append(", averageTransformedBitmapSize=");
    stringBuilder.append(this.averageTransformedBitmapSize);
    stringBuilder.append(", originalBitmapCount=");
    stringBuilder.append(this.originalBitmapCount);
    stringBuilder.append(", transformedBitmapCount=");
    stringBuilder.append(this.transformedBitmapCount);
    stringBuilder.append(", timeStamp=");
    stringBuilder.append(this.timeStamp);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\picasso\StatsSnapshot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */