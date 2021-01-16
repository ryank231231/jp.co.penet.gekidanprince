package android.support.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

final class MultiDexExtractor {
  private static final int BUFFER_SIZE = 16384;
  
  private static final String DEX_PREFIX = "classes";
  
  private static final String DEX_SUFFIX = ".dex";
  
  private static final String EXTRACTED_NAME_EXT = ".classes";
  
  private static final String EXTRACTED_SUFFIX = ".zip";
  
  private static final String KEY_CRC = "crc";
  
  private static final String KEY_DEX_CRC = "dex.crc.";
  
  private static final String KEY_DEX_NUMBER = "dex.number";
  
  private static final String KEY_DEX_TIME = "dex.time.";
  
  private static final String KEY_TIME_STAMP = "timestamp";
  
  private static final String LOCK_FILENAME = "MultiDex.lock";
  
  private static final int MAX_EXTRACT_ATTEMPTS = 3;
  
  private static final long NO_VALUE = -1L;
  
  private static final String PREFS_FILE = "multidex.version";
  
  private static final String TAG = "MultiDex";
  
  private static void closeQuietly(Closeable paramCloseable) {
    try {
      paramCloseable.close();
    } catch (IOException iOException) {
      Log.w("MultiDex", "Failed to close resource", iOException);
    } 
  }
  
  private static void extract(ZipFile paramZipFile, ZipEntry paramZipEntry, File paramFile, String paramString) throws IOException, FileNotFoundException {
    InputStream inputStream = paramZipFile.getInputStream(paramZipEntry);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("tmp-");
    stringBuilder.append(paramString);
    File file = File.createTempFile(stringBuilder.toString(), ".zip", paramFile.getParentFile());
    stringBuilder = new StringBuilder();
    stringBuilder.append("Extracting ");
    stringBuilder.append(file.getPath());
    Log.i("MultiDex", stringBuilder.toString());
    try {
      IOException iOException;
      ZipOutputStream zipOutputStream = new ZipOutputStream();
      BufferedOutputStream bufferedOutputStream = new BufferedOutputStream();
      FileOutputStream fileOutputStream = new FileOutputStream();
      this(file);
      this(fileOutputStream);
    } finally {
      closeQuietly(inputStream);
      file.delete();
    } 
  }
  
  private static SharedPreferences getMultiDexPreferences(Context paramContext) {
    byte b;
    if (Build.VERSION.SDK_INT < 11) {
      b = 0;
    } else {
      b = 4;
    } 
    return paramContext.getSharedPreferences("multidex.version", b);
  }
  
  private static long getTimeStamp(File paramFile) {
    long l1 = paramFile.lastModified();
    long l2 = l1;
    if (l1 == -1L)
      l2 = l1 - 1L; 
    return l2;
  }
  
  private static long getZipCrc(File paramFile) throws IOException {
    long l1 = ZipUtil.getZipCrc(paramFile);
    long l2 = l1;
    if (l1 == -1L)
      l2 = l1 - 1L; 
    return l2;
  }
  
  private static boolean isModified(Context paramContext, File paramFile, long paramLong, String paramString) {
    SharedPreferences sharedPreferences = getMultiDexPreferences(paramContext);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("timestamp");
    if (sharedPreferences.getLong(stringBuilder.toString(), -1L) == getTimeStamp(paramFile)) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString);
      stringBuilder1.append("crc");
      return (sharedPreferences.getLong(stringBuilder1.toString(), -1L) != paramLong);
    } 
    return true;
  }
  
  static List<? extends File> load(Context paramContext, File paramFile1, File paramFile2, String paramString, boolean paramBoolean) throws IOException {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #5
    //   9: aload #5
    //   11: ldc 'MultiDexExtractor.load('
    //   13: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload #5
    //   19: aload_1
    //   20: invokevirtual getPath : ()Ljava/lang/String;
    //   23: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload #5
    //   29: ldc ', '
    //   31: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload #5
    //   37: iload #4
    //   39: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload #5
    //   45: ldc ', '
    //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload #5
    //   53: aload_3
    //   54: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload #5
    //   60: ldc ')'
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: ldc 'MultiDex'
    //   68: aload #5
    //   70: invokevirtual toString : ()Ljava/lang/String;
    //   73: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   76: pop
    //   77: aload_1
    //   78: invokestatic getZipCrc : (Ljava/io/File;)J
    //   81: lstore #6
    //   83: new java/io/File
    //   86: dup
    //   87: aload_2
    //   88: ldc 'MultiDex.lock'
    //   90: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   93: astore #8
    //   95: new java/io/RandomAccessFile
    //   98: dup
    //   99: aload #8
    //   101: ldc 'rw'
    //   103: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   106: astore #9
    //   108: aload #9
    //   110: invokevirtual getChannel : ()Ljava/nio/channels/FileChannel;
    //   113: astore #5
    //   115: new java/lang/StringBuilder
    //   118: astore #10
    //   120: aload #10
    //   122: invokespecial <init> : ()V
    //   125: aload #10
    //   127: ldc_w 'Blocking on lock '
    //   130: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload #10
    //   136: aload #8
    //   138: invokevirtual getPath : ()Ljava/lang/String;
    //   141: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: ldc 'MultiDex'
    //   147: aload #10
    //   149: invokevirtual toString : ()Ljava/lang/String;
    //   152: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   155: pop
    //   156: aload #5
    //   158: invokevirtual lock : ()Ljava/nio/channels/FileLock;
    //   161: astore #10
    //   163: new java/lang/StringBuilder
    //   166: astore #11
    //   168: aload #11
    //   170: invokespecial <init> : ()V
    //   173: aload #11
    //   175: aload #8
    //   177: invokevirtual getPath : ()Ljava/lang/String;
    //   180: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload #11
    //   186: ldc_w ' locked'
    //   189: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: ldc 'MultiDex'
    //   195: aload #11
    //   197: invokevirtual toString : ()Ljava/lang/String;
    //   200: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   203: pop
    //   204: iload #4
    //   206: ifne -> 275
    //   209: aload_0
    //   210: aload_1
    //   211: lload #6
    //   213: aload_3
    //   214: invokestatic isModified : (Landroid/content/Context;Ljava/io/File;JLjava/lang/String;)Z
    //   217: istore #4
    //   219: iload #4
    //   221: ifne -> 275
    //   224: aload_0
    //   225: aload_1
    //   226: aload_2
    //   227: aload_3
    //   228: invokestatic loadExistingExtractions : (Landroid/content/Context;Ljava/io/File;Ljava/io/File;Ljava/lang/String;)Ljava/util/List;
    //   231: astore #11
    //   233: aload #11
    //   235: astore_0
    //   236: goto -> 304
    //   239: astore #11
    //   241: ldc 'MultiDex'
    //   243: ldc_w 'Failed to reload existing extracted secondary dex files, falling back to fresh extraction'
    //   246: aload #11
    //   248: invokestatic w : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   251: pop
    //   252: aload_1
    //   253: aload_2
    //   254: invokestatic performExtractions : (Ljava/io/File;Ljava/io/File;)Ljava/util/List;
    //   257: astore_2
    //   258: aload_0
    //   259: aload_3
    //   260: aload_1
    //   261: invokestatic getTimeStamp : (Ljava/io/File;)J
    //   264: lload #6
    //   266: aload_2
    //   267: invokestatic putStoredApkInfo : (Landroid/content/Context;Ljava/lang/String;JJLjava/util/List;)V
    //   270: aload_2
    //   271: astore_0
    //   272: goto -> 236
    //   275: ldc 'MultiDex'
    //   277: ldc_w 'Detected that extraction must be performed.'
    //   280: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   283: pop
    //   284: aload_1
    //   285: aload_2
    //   286: invokestatic performExtractions : (Ljava/io/File;Ljava/io/File;)Ljava/util/List;
    //   289: astore_2
    //   290: aload_0
    //   291: aload_3
    //   292: aload_1
    //   293: invokestatic getTimeStamp : (Ljava/io/File;)J
    //   296: lload #6
    //   298: aload_2
    //   299: invokestatic putStoredApkInfo : (Landroid/content/Context;Ljava/lang/String;JJLjava/util/List;)V
    //   302: aload_2
    //   303: astore_0
    //   304: aload #10
    //   306: ifnull -> 357
    //   309: aload #10
    //   311: invokevirtual release : ()V
    //   314: goto -> 357
    //   317: astore_1
    //   318: new java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial <init> : ()V
    //   325: astore_2
    //   326: aload_2
    //   327: ldc_w 'Failed to release lock on '
    //   330: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload_2
    //   335: aload #8
    //   337: invokevirtual getPath : ()Ljava/lang/String;
    //   340: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: ldc 'MultiDex'
    //   346: aload_2
    //   347: invokevirtual toString : ()Ljava/lang/String;
    //   350: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   353: pop
    //   354: goto -> 359
    //   357: aconst_null
    //   358: astore_1
    //   359: aload #5
    //   361: ifnull -> 369
    //   364: aload #5
    //   366: invokestatic closeQuietly : (Ljava/io/Closeable;)V
    //   369: aload #9
    //   371: invokestatic closeQuietly : (Ljava/io/Closeable;)V
    //   374: aload_1
    //   375: ifnonnull -> 425
    //   378: new java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial <init> : ()V
    //   385: astore_1
    //   386: aload_1
    //   387: ldc_w 'load found '
    //   390: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload_1
    //   395: aload_0
    //   396: invokeinterface size : ()I
    //   401: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload_1
    //   406: ldc_w ' secondary dex files'
    //   409: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: ldc 'MultiDex'
    //   415: aload_1
    //   416: invokevirtual toString : ()Ljava/lang/String;
    //   419: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   422: pop
    //   423: aload_0
    //   424: areturn
    //   425: aload_1
    //   426: athrow
    //   427: astore_0
    //   428: aload #5
    //   430: astore_2
    //   431: aload #10
    //   433: astore_1
    //   434: goto -> 451
    //   437: astore_0
    //   438: aconst_null
    //   439: astore_1
    //   440: aload #5
    //   442: astore_2
    //   443: goto -> 451
    //   446: astore_0
    //   447: aconst_null
    //   448: astore_2
    //   449: aload_2
    //   450: astore_1
    //   451: aload_1
    //   452: ifnull -> 499
    //   455: aload_1
    //   456: invokevirtual release : ()V
    //   459: goto -> 499
    //   462: astore_1
    //   463: new java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial <init> : ()V
    //   470: astore_1
    //   471: aload_1
    //   472: ldc_w 'Failed to release lock on '
    //   475: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload_1
    //   480: aload #8
    //   482: invokevirtual getPath : ()Ljava/lang/String;
    //   485: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: pop
    //   489: ldc 'MultiDex'
    //   491: aload_1
    //   492: invokevirtual toString : ()Ljava/lang/String;
    //   495: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   498: pop
    //   499: aload_2
    //   500: ifnull -> 507
    //   503: aload_2
    //   504: invokestatic closeQuietly : (Ljava/io/Closeable;)V
    //   507: aload #9
    //   509: invokestatic closeQuietly : (Ljava/io/Closeable;)V
    //   512: aload_0
    //   513: athrow
    // Exception table:
    //   from	to	target	type
    //   108	115	446	finally
    //   115	163	437	finally
    //   163	204	427	finally
    //   209	219	427	finally
    //   224	233	239	java/io/IOException
    //   224	233	427	finally
    //   241	270	427	finally
    //   275	302	427	finally
    //   309	314	317	java/io/IOException
    //   455	459	462	java/io/IOException
  }
  
  private static List<ExtractedDex> loadExistingExtractions(Context paramContext, File paramFile1, File paramFile2, String paramString) throws IOException {
    Log.i("MultiDex", "loading existing secondary dex files");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramFile1.getName());
    stringBuilder.append(".classes");
    String str = stringBuilder.toString();
    SharedPreferences sharedPreferences = getMultiDexPreferences(paramContext);
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("dex.number");
    int i = sharedPreferences.getInt(stringBuilder.toString(), 1);
    ArrayList<ExtractedDex> arrayList = new ArrayList(i - 1);
    byte b = 2;
    while (b <= i) {
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str);
      stringBuilder2.append(b);
      stringBuilder2.append(".zip");
      ExtractedDex extractedDex = new ExtractedDex(paramFile2, stringBuilder2.toString());
      if (extractedDex.isFile()) {
        extractedDex.crc = getZipCrc(extractedDex);
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(paramString);
        stringBuilder4.append("dex.crc.");
        stringBuilder4.append(b);
        long l1 = sharedPreferences.getLong(stringBuilder4.toString(), -1L);
        stringBuilder4 = new StringBuilder();
        stringBuilder4.append(paramString);
        stringBuilder4.append("dex.time.");
        stringBuilder4.append(b);
        long l2 = sharedPreferences.getLong(stringBuilder4.toString(), -1L);
        long l3 = extractedDex.lastModified();
        if (l2 == l3 && l1 == extractedDex.crc) {
          arrayList.add(extractedDex);
          b++;
          continue;
        } 
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Invalid extracted dex: ");
        stringBuilder3.append(extractedDex);
        stringBuilder3.append(" (key \"");
        stringBuilder3.append(paramString);
        stringBuilder3.append("\"), expected modification time: ");
        stringBuilder3.append(l2);
        stringBuilder3.append(", modification time: ");
        stringBuilder3.append(l3);
        stringBuilder3.append(", expected crc: ");
        stringBuilder3.append(l1);
        stringBuilder3.append(", file crc: ");
        stringBuilder3.append(extractedDex.crc);
        throw new IOException(stringBuilder3.toString());
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Missing extracted secondary dex file '");
      stringBuilder1.append(extractedDex.getPath());
      stringBuilder1.append("'");
      throw new IOException(stringBuilder1.toString());
    } 
    return arrayList;
  }
  
  private static List<ExtractedDex> performExtractions(File paramFile1, File paramFile2) throws IOException {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramFile1.getName());
    stringBuilder.append(".classes");
    String str = stringBuilder.toString();
    prepareDexDir(paramFile2, str);
    ArrayList<ExtractedDex> arrayList = new ArrayList();
    ZipFile zipFile = new ZipFile(paramFile1);
    byte b = 2;
    try {
      StringBuilder stringBuilder1 = new StringBuilder();
      this();
      stringBuilder1.append("classes");
      stringBuilder1.append(2);
      stringBuilder1.append(".dex");
      ZipEntry zipEntry = zipFile.getEntry(stringBuilder1.toString());
      while (zipEntry != null) {
        stringBuilder = new StringBuilder();
        this();
        stringBuilder.append(str);
        stringBuilder.append(b);
        stringBuilder.append(".zip");
        String str1 = stringBuilder.toString();
        ExtractedDex extractedDex = new ExtractedDex();
        this(paramFile2, str1);
        arrayList.add(extractedDex);
        StringBuilder stringBuilder3 = new StringBuilder();
        this();
        stringBuilder3.append("Extraction is needed for file ");
        stringBuilder3.append(extractedDex);
        Log.i("MultiDex", stringBuilder3.toString());
        int i = 0;
        boolean bool = false;
        while (i < 3 && !bool) {
          String str2;
          boolean bool1;
          int j = i + 1;
          extract(zipFile, zipEntry, extractedDex, str);
          try {
            extractedDex.crc = getZipCrc(extractedDex);
            bool1 = true;
          } catch (IOException iOException1) {
            stringBuilder3 = new StringBuilder();
            this();
            stringBuilder3.append("Failed to read crc from ");
            stringBuilder3.append(extractedDex.getAbsolutePath());
            Log.w("MultiDex", stringBuilder3.toString(), iOException1);
            bool1 = false;
          } 
          StringBuilder stringBuilder4 = new StringBuilder();
          this();
          stringBuilder4.append("Extraction ");
          if (bool1) {
            str2 = "succeeded";
          } else {
            str2 = "failed";
          } 
          stringBuilder4.append(str2);
          stringBuilder4.append(" - length ");
          stringBuilder4.append(extractedDex.getAbsolutePath());
          stringBuilder4.append(": ");
          stringBuilder4.append(extractedDex.length());
          stringBuilder4.append(" - crc: ");
          stringBuilder4.append(extractedDex.crc);
          Log.i("MultiDex", stringBuilder4.toString());
          i = j;
          bool = bool1;
          if (!bool1) {
            extractedDex.delete();
            i = j;
            bool = bool1;
            if (extractedDex.exists()) {
              StringBuilder stringBuilder5 = new StringBuilder();
              this();
              stringBuilder5.append("Failed to delete corrupted secondary dex '");
              stringBuilder5.append(extractedDex.getPath());
              stringBuilder5.append("'");
              Log.w("MultiDex", stringBuilder5.toString());
              i = j;
              bool = bool1;
            } 
          } 
        } 
        if (bool) {
          b++;
          StringBuilder stringBuilder4 = new StringBuilder();
          this();
          stringBuilder4.append("classes");
          stringBuilder4.append(b);
          stringBuilder4.append(".dex");
          ZipEntry zipEntry1 = zipFile.getEntry(stringBuilder4.toString());
          continue;
        } 
        IOException iOException = new IOException();
        StringBuilder stringBuilder2 = new StringBuilder();
        this();
        stringBuilder2.append("Could not create zip file ");
        stringBuilder2.append(extractedDex.getAbsolutePath());
        stringBuilder2.append(" for secondary dex (");
        stringBuilder2.append(b);
        stringBuilder2.append(")");
        this(stringBuilder2.toString());
        throw iOException;
      } 
      return arrayList;
    } finally {
      try {
        zipFile.close();
      } catch (IOException iOException) {
        Log.w("MultiDex", "Failed to close resource", iOException);
      } 
    } 
  }
  
  private static void prepareDexDir(File paramFile, final String extractedFilePrefix) {
    StringBuilder stringBuilder;
    File[] arrayOfFile = paramFile.listFiles(new FileFilter() {
          public boolean accept(File param1File) {
            boolean bool;
            String str = param1File.getName();
            if (!str.startsWith(extractedFilePrefix) && !str.equals("MultiDex.lock")) {
              bool = true;
            } else {
              bool = false;
            } 
            return bool;
          }
        });
    if (arrayOfFile == null) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to list secondary dex dir content (");
      stringBuilder.append(paramFile.getPath());
      stringBuilder.append(").");
      Log.w("MultiDex", stringBuilder.toString());
      return;
    } 
    int i = stringBuilder.length;
    for (byte b = 0; b < i; b++) {
      StringBuilder stringBuilder1 = stringBuilder[b];
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("Trying to delete old file ");
      stringBuilder2.append(stringBuilder1.getPath());
      stringBuilder2.append(" of size ");
      stringBuilder2.append(stringBuilder1.length());
      Log.i("MultiDex", stringBuilder2.toString());
      if (!stringBuilder1.delete()) {
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Failed to delete old file ");
        stringBuilder2.append(stringBuilder1.getPath());
        Log.w("MultiDex", stringBuilder2.toString());
      } else {
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Deleted old file ");
        stringBuilder2.append(stringBuilder1.getPath());
        Log.i("MultiDex", stringBuilder2.toString());
      } 
    } 
  }
  
  private static void putStoredApkInfo(Context paramContext, String paramString, long paramLong1, long paramLong2, List<ExtractedDex> paramList) {
    SharedPreferences.Editor editor = getMultiDexPreferences(paramContext).edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("timestamp");
    editor.putLong(stringBuilder.toString(), paramLong1);
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("crc");
    editor.putLong(stringBuilder.toString(), paramLong2);
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("dex.number");
    editor.putInt(stringBuilder.toString(), paramList.size() + 1);
    Iterator<ExtractedDex> iterator = paramList.iterator();
    for (byte b = 2; iterator.hasNext(); b++) {
      ExtractedDex extractedDex = iterator.next();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString);
      stringBuilder1.append("dex.crc.");
      stringBuilder1.append(b);
      editor.putLong(stringBuilder1.toString(), extractedDex.crc);
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString);
      stringBuilder1.append("dex.time.");
      stringBuilder1.append(b);
      editor.putLong(stringBuilder1.toString(), extractedDex.lastModified());
    } 
    editor.commit();
  }
  
  private static class ExtractedDex extends File {
    public long crc = -1L;
    
    public ExtractedDex(File param1File, String param1String) {
      super(param1File, param1String);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\multidex\MultiDexExtractor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */