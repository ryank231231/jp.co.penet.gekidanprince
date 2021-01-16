package com.squareup.okhttp.internal;

import com.squareup.okhttp.internal.io.FileSystem;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class DiskLruCache implements Closeable {
  static final long ANY_SEQUENCE_NUMBER = -1L;
  
  private static final String CLEAN = "CLEAN";
  
  private static final String DIRTY = "DIRTY";
  
  static final String JOURNAL_FILE = "journal";
  
  static final String JOURNAL_FILE_BACKUP = "journal.bkp";
  
  static final String JOURNAL_FILE_TEMP = "journal.tmp";
  
  static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
  
  static final String MAGIC = "libcore.io.DiskLruCache";
  
  private static final Sink NULL_SINK = new Sink() {
      public void close() throws IOException {}
      
      public void flush() throws IOException {}
      
      public Timeout timeout() {
        return Timeout.NONE;
      }
      
      public void write(Buffer param1Buffer, long param1Long) throws IOException {
        param1Buffer.skip(param1Long);
      }
    };
  
  private static final String READ = "READ";
  
  private static final String REMOVE = "REMOVE";
  
  static final String VERSION_1 = "1";
  
  private final int appVersion;
  
  private final Runnable cleanupRunnable = new Runnable() {
      public void run() {
        synchronized (DiskLruCache.this) {
          boolean bool;
          if (!DiskLruCache.this.initialized) {
            bool = true;
          } else {
            bool = false;
          } 
          if (bool | DiskLruCache.this.closed)
            return; 
          try {
            DiskLruCache.this.trimToSize();
            if (DiskLruCache.this.journalRebuildRequired()) {
              DiskLruCache.this.rebuildJournal();
              DiskLruCache.access$502(DiskLruCache.this, 0);
            } 
            return;
          } catch (IOException iOException) {
            RuntimeException runtimeException = new RuntimeException();
            this(iOException);
            throw runtimeException;
          } 
        } 
      }
    };
  
  private boolean closed;
  
  private final File directory;
  
  private final Executor executor;
  
  private final FileSystem fileSystem;
  
  private boolean hasJournalErrors;
  
  private boolean initialized;
  
  private final File journalFile;
  
  private final File journalFileBackup;
  
  private final File journalFileTmp;
  
  private BufferedSink journalWriter;
  
  private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<String, Entry>(0, 0.75F, true);
  
  private long maxSize;
  
  private long nextSequenceNumber = 0L;
  
  private int redundantOpCount;
  
  private long size = 0L;
  
  private final int valueCount;
  
  DiskLruCache(FileSystem paramFileSystem, File paramFile, int paramInt1, int paramInt2, long paramLong, Executor paramExecutor) {
    this.fileSystem = paramFileSystem;
    this.directory = paramFile;
    this.appVersion = paramInt1;
    this.journalFile = new File(paramFile, "journal");
    this.journalFileTmp = new File(paramFile, "journal.tmp");
    this.journalFileBackup = new File(paramFile, "journal.bkp");
    this.valueCount = paramInt2;
    this.maxSize = paramLong;
    this.executor = paramExecutor;
  }
  
  private void checkNotClosed() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual isClosed : ()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: new java/lang/IllegalStateException
    //   17: astore_2
    //   18: aload_2
    //   19: ldc 'cache is closed'
    //   21: invokespecial <init> : (Ljava/lang/String;)V
    //   24: aload_2
    //   25: athrow
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	26	finally
    //   14	26	26	finally
  }
  
  private void completeEdit(Editor paramEditor, boolean paramBoolean) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic access$1700 : (Lcom/squareup/okhttp/internal/DiskLruCache$Editor;)Lcom/squareup/okhttp/internal/DiskLruCache$Entry;
    //   6: astore_3
    //   7: aload_3
    //   8: invokestatic access$900 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Lcom/squareup/okhttp/internal/DiskLruCache$Editor;
    //   11: aload_1
    //   12: if_acmpne -> 467
    //   15: iconst_0
    //   16: istore #4
    //   18: iload #4
    //   20: istore #5
    //   22: iload_2
    //   23: ifeq -> 135
    //   26: iload #4
    //   28: istore #5
    //   30: aload_3
    //   31: invokestatic access$800 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Z
    //   34: ifne -> 135
    //   37: iconst_0
    //   38: istore #6
    //   40: iload #4
    //   42: istore #5
    //   44: iload #6
    //   46: aload_0
    //   47: getfield valueCount : I
    //   50: if_icmpge -> 135
    //   53: aload_1
    //   54: invokestatic access$1800 : (Lcom/squareup/okhttp/internal/DiskLruCache$Editor;)[Z
    //   57: iload #6
    //   59: baload
    //   60: ifeq -> 95
    //   63: aload_0
    //   64: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   67: aload_3
    //   68: invokestatic access$1400 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)[Ljava/io/File;
    //   71: iload #6
    //   73: aaload
    //   74: invokeinterface exists : (Ljava/io/File;)Z
    //   79: ifne -> 89
    //   82: aload_1
    //   83: invokevirtual abort : ()V
    //   86: aload_0
    //   87: monitorexit
    //   88: return
    //   89: iinc #6, 1
    //   92: goto -> 40
    //   95: aload_1
    //   96: invokevirtual abort : ()V
    //   99: new java/lang/IllegalStateException
    //   102: astore_3
    //   103: new java/lang/StringBuilder
    //   106: astore_1
    //   107: aload_1
    //   108: invokespecial <init> : ()V
    //   111: aload_1
    //   112: ldc 'Newly created entry didn't create value for index '
    //   114: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_1
    //   119: iload #6
    //   121: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_3
    //   126: aload_1
    //   127: invokevirtual toString : ()Ljava/lang/String;
    //   130: invokespecial <init> : (Ljava/lang/String;)V
    //   133: aload_3
    //   134: athrow
    //   135: iload #5
    //   137: aload_0
    //   138: getfield valueCount : I
    //   141: if_icmpge -> 254
    //   144: aload_3
    //   145: invokestatic access$1400 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)[Ljava/io/File;
    //   148: iload #5
    //   150: aaload
    //   151: astore_1
    //   152: iload_2
    //   153: ifeq -> 238
    //   156: aload_0
    //   157: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   160: aload_1
    //   161: invokeinterface exists : (Ljava/io/File;)Z
    //   166: ifeq -> 248
    //   169: aload_3
    //   170: invokestatic access$1300 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)[Ljava/io/File;
    //   173: iload #5
    //   175: aaload
    //   176: astore #7
    //   178: aload_0
    //   179: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   182: aload_1
    //   183: aload #7
    //   185: invokeinterface rename : (Ljava/io/File;Ljava/io/File;)V
    //   190: aload_3
    //   191: invokestatic access$1200 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)[J
    //   194: iload #5
    //   196: laload
    //   197: lstore #8
    //   199: aload_0
    //   200: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   203: aload #7
    //   205: invokeinterface size : (Ljava/io/File;)J
    //   210: lstore #10
    //   212: aload_3
    //   213: invokestatic access$1200 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)[J
    //   216: iload #5
    //   218: lload #10
    //   220: lastore
    //   221: aload_0
    //   222: aload_0
    //   223: getfield size : J
    //   226: lload #8
    //   228: lsub
    //   229: lload #10
    //   231: ladd
    //   232: putfield size : J
    //   235: goto -> 248
    //   238: aload_0
    //   239: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   242: aload_1
    //   243: invokeinterface delete : (Ljava/io/File;)V
    //   248: iinc #5, 1
    //   251: goto -> 135
    //   254: aload_0
    //   255: aload_0
    //   256: getfield redundantOpCount : I
    //   259: iconst_1
    //   260: iadd
    //   261: putfield redundantOpCount : I
    //   264: aload_3
    //   265: aconst_null
    //   266: invokestatic access$902 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;Lcom/squareup/okhttp/internal/DiskLruCache$Editor;)Lcom/squareup/okhttp/internal/DiskLruCache$Editor;
    //   269: pop
    //   270: aload_3
    //   271: invokestatic access$800 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Z
    //   274: iload_2
    //   275: ior
    //   276: ifeq -> 366
    //   279: aload_3
    //   280: iconst_1
    //   281: invokestatic access$802 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;Z)Z
    //   284: pop
    //   285: aload_0
    //   286: getfield journalWriter : Lokio/BufferedSink;
    //   289: ldc 'CLEAN'
    //   291: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   296: bipush #32
    //   298: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   303: pop
    //   304: aload_0
    //   305: getfield journalWriter : Lokio/BufferedSink;
    //   308: aload_3
    //   309: invokestatic access$1500 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Ljava/lang/String;
    //   312: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   317: pop
    //   318: aload_3
    //   319: aload_0
    //   320: getfield journalWriter : Lokio/BufferedSink;
    //   323: invokevirtual writeLengths : (Lokio/BufferedSink;)V
    //   326: aload_0
    //   327: getfield journalWriter : Lokio/BufferedSink;
    //   330: bipush #10
    //   332: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   337: pop
    //   338: iload_2
    //   339: ifeq -> 423
    //   342: aload_0
    //   343: getfield nextSequenceNumber : J
    //   346: lstore #10
    //   348: aload_0
    //   349: lconst_1
    //   350: lload #10
    //   352: ladd
    //   353: putfield nextSequenceNumber : J
    //   356: aload_3
    //   357: lload #10
    //   359: invokestatic access$1602 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;J)J
    //   362: pop2
    //   363: goto -> 423
    //   366: aload_0
    //   367: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   370: aload_3
    //   371: invokestatic access$1500 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Ljava/lang/String;
    //   374: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   377: pop
    //   378: aload_0
    //   379: getfield journalWriter : Lokio/BufferedSink;
    //   382: ldc 'REMOVE'
    //   384: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   389: bipush #32
    //   391: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   396: pop
    //   397: aload_0
    //   398: getfield journalWriter : Lokio/BufferedSink;
    //   401: aload_3
    //   402: invokestatic access$1500 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Ljava/lang/String;
    //   405: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   410: pop
    //   411: aload_0
    //   412: getfield journalWriter : Lokio/BufferedSink;
    //   415: bipush #10
    //   417: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   422: pop
    //   423: aload_0
    //   424: getfield journalWriter : Lokio/BufferedSink;
    //   427: invokeinterface flush : ()V
    //   432: aload_0
    //   433: getfield size : J
    //   436: aload_0
    //   437: getfield maxSize : J
    //   440: lcmp
    //   441: ifgt -> 451
    //   444: aload_0
    //   445: invokespecial journalRebuildRequired : ()Z
    //   448: ifeq -> 464
    //   451: aload_0
    //   452: getfield executor : Ljava/util/concurrent/Executor;
    //   455: aload_0
    //   456: getfield cleanupRunnable : Ljava/lang/Runnable;
    //   459: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   464: aload_0
    //   465: monitorexit
    //   466: return
    //   467: new java/lang/IllegalStateException
    //   470: astore_1
    //   471: aload_1
    //   472: invokespecial <init> : ()V
    //   475: aload_1
    //   476: athrow
    //   477: astore_1
    //   478: aload_0
    //   479: monitorexit
    //   480: aload_1
    //   481: athrow
    // Exception table:
    //   from	to	target	type
    //   2	15	477	finally
    //   30	37	477	finally
    //   44	86	477	finally
    //   95	135	477	finally
    //   135	152	477	finally
    //   156	235	477	finally
    //   238	248	477	finally
    //   254	338	477	finally
    //   342	363	477	finally
    //   366	423	477	finally
    //   423	451	477	finally
    //   451	464	477	finally
    //   467	477	477	finally
  }
  
  public static DiskLruCache create(FileSystem paramFileSystem, File paramFile, int paramInt1, int paramInt2, long paramLong) {
    if (paramLong > 0L) {
      if (paramInt2 > 0)
        return new DiskLruCache(paramFileSystem, paramFile, paramInt1, paramInt2, paramLong, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), Util.threadFactory("OkHttp DiskLruCache", true))); 
      throw new IllegalArgumentException("valueCount <= 0");
    } 
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  private Editor edit(String paramString, long paramLong) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual initialize : ()V
    //   6: aload_0
    //   7: invokespecial checkNotClosed : ()V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial validateKey : (Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   19: aload_1
    //   20: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast com/squareup/okhttp/internal/DiskLruCache$Entry
    //   26: astore #4
    //   28: lload_2
    //   29: ldc2_w -1
    //   32: lcmp
    //   33: ifeq -> 59
    //   36: aload #4
    //   38: ifnull -> 55
    //   41: aload #4
    //   43: invokestatic access$1600 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)J
    //   46: lstore #5
    //   48: lload #5
    //   50: lload_2
    //   51: lcmp
    //   52: ifeq -> 59
    //   55: aload_0
    //   56: monitorexit
    //   57: aconst_null
    //   58: areturn
    //   59: aload #4
    //   61: ifnull -> 80
    //   64: aload #4
    //   66: invokestatic access$900 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Lcom/squareup/okhttp/internal/DiskLruCache$Editor;
    //   69: astore #7
    //   71: aload #7
    //   73: ifnull -> 80
    //   76: aload_0
    //   77: monitorexit
    //   78: aconst_null
    //   79: areturn
    //   80: aload_0
    //   81: getfield journalWriter : Lokio/BufferedSink;
    //   84: ldc 'DIRTY'
    //   86: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   91: bipush #32
    //   93: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   98: aload_1
    //   99: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   104: bipush #10
    //   106: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   111: pop
    //   112: aload_0
    //   113: getfield journalWriter : Lokio/BufferedSink;
    //   116: invokeinterface flush : ()V
    //   121: aload_0
    //   122: getfield hasJournalErrors : Z
    //   125: istore #8
    //   127: iload #8
    //   129: ifeq -> 136
    //   132: aload_0
    //   133: monitorexit
    //   134: aconst_null
    //   135: areturn
    //   136: aload #4
    //   138: astore #7
    //   140: aload #4
    //   142: ifnonnull -> 169
    //   145: new com/squareup/okhttp/internal/DiskLruCache$Entry
    //   148: astore #7
    //   150: aload #7
    //   152: aload_0
    //   153: aload_1
    //   154: aconst_null
    //   155: invokespecial <init> : (Lcom/squareup/okhttp/internal/DiskLruCache;Ljava/lang/String;Lcom/squareup/okhttp/internal/DiskLruCache$1;)V
    //   158: aload_0
    //   159: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   162: aload_1
    //   163: aload #7
    //   165: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   168: pop
    //   169: new com/squareup/okhttp/internal/DiskLruCache$Editor
    //   172: astore_1
    //   173: aload_1
    //   174: aload_0
    //   175: aload #7
    //   177: aconst_null
    //   178: invokespecial <init> : (Lcom/squareup/okhttp/internal/DiskLruCache;Lcom/squareup/okhttp/internal/DiskLruCache$Entry;Lcom/squareup/okhttp/internal/DiskLruCache$1;)V
    //   181: aload #7
    //   183: aload_1
    //   184: invokestatic access$902 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;Lcom/squareup/okhttp/internal/DiskLruCache$Editor;)Lcom/squareup/okhttp/internal/DiskLruCache$Editor;
    //   187: pop
    //   188: aload_0
    //   189: monitorexit
    //   190: aload_1
    //   191: areturn
    //   192: astore_1
    //   193: aload_0
    //   194: monitorexit
    //   195: aload_1
    //   196: athrow
    // Exception table:
    //   from	to	target	type
    //   2	28	192	finally
    //   41	48	192	finally
    //   64	71	192	finally
    //   80	127	192	finally
    //   145	169	192	finally
    //   169	188	192	finally
  }
  
  private boolean journalRebuildRequired() {
    boolean bool;
    int i = this.redundantOpCount;
    if (i >= 2000 && i >= this.lruEntries.size()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private BufferedSink newJournalWriter() throws FileNotFoundException {
    return Okio.buffer((Sink)new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile)) {
          protected void onException(IOException param1IOException) {
            DiskLruCache.access$602(DiskLruCache.this, true);
          }
        });
  }
  
  private void processJournal() throws IOException {
    this.fileSystem.delete(this.journalFileTmp);
    Iterator<Entry> iterator = this.lruEntries.values().iterator();
    while (iterator.hasNext()) {
      Entry entry = iterator.next();
      Editor editor = entry.currentEditor;
      boolean bool = false;
      byte b = 0;
      if (editor == null) {
        while (b < this.valueCount) {
          this.size += entry.lengths[b];
          b++;
        } 
        continue;
      } 
      Entry.access$902(entry, null);
      for (b = bool; b < this.valueCount; b++) {
        this.fileSystem.delete(entry.cleanFiles[b]);
        this.fileSystem.delete(entry.dirtyFiles[b]);
      } 
      iterator.remove();
    } 
  }
  
  private void readJournal() throws IOException {
    BufferedSource bufferedSource = Okio.buffer(this.fileSystem.source(this.journalFile));
    try {
      String str1 = bufferedSource.readUtf8LineStrict();
      String str2 = bufferedSource.readUtf8LineStrict();
      String str3 = bufferedSource.readUtf8LineStrict();
      String str4 = bufferedSource.readUtf8LineStrict();
      String str5 = bufferedSource.readUtf8LineStrict();
      if ("libcore.io.DiskLruCache".equals(str1) && "1".equals(str2) && Integer.toString(this.appVersion).equals(str3) && Integer.toString(this.valueCount).equals(str4)) {
        boolean bool = "".equals(str5);
        if (bool) {
          byte b = 0;
          try {
            while (true) {
              readJournalLine(bufferedSource.readUtf8LineStrict());
              b++;
            } 
          } catch (EOFException eOFException) {
            this.redundantOpCount = b - this.lruEntries.size();
            if (!bufferedSource.exhausted()) {
              rebuildJournal();
            } else {
              this.journalWriter = newJournalWriter();
            } 
            return;
          } 
        } 
      } 
      IOException iOException = new IOException();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("unexpected journal header: [");
      stringBuilder.append(str1);
      stringBuilder.append(", ");
      stringBuilder.append((String)eOFException);
      stringBuilder.append(", ");
      stringBuilder.append(str4);
      stringBuilder.append(", ");
      stringBuilder.append(str5);
      stringBuilder.append("]");
      this(stringBuilder.toString());
      throw iOException;
    } finally {
      Util.closeQuietly((Closeable)bufferedSource);
    } 
  }
  
  private void readJournalLine(String paramString) throws IOException {
    String[] arrayOfString;
    int i = paramString.indexOf(' ');
    if (i != -1) {
      String str;
      int j = i + 1;
      int k = paramString.indexOf(' ', j);
      if (k == -1) {
        String str1 = paramString.substring(j);
        str = str1;
        if (i == 6) {
          str = str1;
          if (paramString.startsWith("REMOVE")) {
            this.lruEntries.remove(str1);
            return;
          } 
        } 
      } else {
        str = paramString.substring(j, k);
      } 
      Entry entry2 = this.lruEntries.get(str);
      Entry entry1 = entry2;
      if (entry2 == null) {
        entry1 = new Entry(str);
        this.lruEntries.put(str, entry1);
      } 
      if (k != -1 && i == 5 && paramString.startsWith("CLEAN")) {
        arrayOfString = paramString.substring(k + 1).split(" ");
        Entry.access$802(entry1, true);
        Entry.access$902(entry1, null);
        entry1.setLengths(arrayOfString);
      } else if (k == -1 && i == 5 && arrayOfString.startsWith("DIRTY")) {
        Entry.access$902(entry1, new Editor(entry1));
      } else if (k != -1 || i != 4 || !arrayOfString.startsWith("READ")) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("unexpected journal line: ");
        stringBuilder1.append((String)arrayOfString);
        throw new IOException(stringBuilder1.toString());
      } 
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("unexpected journal line: ");
    stringBuilder.append((String)arrayOfString);
    throw new IOException(stringBuilder.toString());
  }
  
  private void rebuildJournal() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield journalWriter : Lokio/BufferedSink;
    //   6: ifnull -> 18
    //   9: aload_0
    //   10: getfield journalWriter : Lokio/BufferedSink;
    //   13: invokeinterface close : ()V
    //   18: aload_0
    //   19: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   22: aload_0
    //   23: getfield journalFileTmp : Ljava/io/File;
    //   26: invokeinterface sink : (Ljava/io/File;)Lokio/Sink;
    //   31: invokestatic buffer : (Lokio/Sink;)Lokio/BufferedSink;
    //   34: astore_1
    //   35: aload_1
    //   36: ldc 'libcore.io.DiskLruCache'
    //   38: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   43: bipush #10
    //   45: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   50: pop
    //   51: aload_1
    //   52: ldc '1'
    //   54: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   59: bipush #10
    //   61: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   66: pop
    //   67: aload_1
    //   68: aload_0
    //   69: getfield appVersion : I
    //   72: i2l
    //   73: invokeinterface writeDecimalLong : (J)Lokio/BufferedSink;
    //   78: bipush #10
    //   80: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   85: pop
    //   86: aload_1
    //   87: aload_0
    //   88: getfield valueCount : I
    //   91: i2l
    //   92: invokeinterface writeDecimalLong : (J)Lokio/BufferedSink;
    //   97: bipush #10
    //   99: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   104: pop
    //   105: aload_1
    //   106: bipush #10
    //   108: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   113: pop
    //   114: aload_0
    //   115: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   118: invokevirtual values : ()Ljava/util/Collection;
    //   121: invokeinterface iterator : ()Ljava/util/Iterator;
    //   126: astore_2
    //   127: aload_2
    //   128: invokeinterface hasNext : ()Z
    //   133: ifeq -> 236
    //   136: aload_2
    //   137: invokeinterface next : ()Ljava/lang/Object;
    //   142: checkcast com/squareup/okhttp/internal/DiskLruCache$Entry
    //   145: astore_3
    //   146: aload_3
    //   147: invokestatic access$900 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Lcom/squareup/okhttp/internal/DiskLruCache$Editor;
    //   150: ifnull -> 192
    //   153: aload_1
    //   154: ldc 'DIRTY'
    //   156: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   161: bipush #32
    //   163: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   168: pop
    //   169: aload_1
    //   170: aload_3
    //   171: invokestatic access$1500 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Ljava/lang/String;
    //   174: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   179: pop
    //   180: aload_1
    //   181: bipush #10
    //   183: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   188: pop
    //   189: goto -> 127
    //   192: aload_1
    //   193: ldc 'CLEAN'
    //   195: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   200: bipush #32
    //   202: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   207: pop
    //   208: aload_1
    //   209: aload_3
    //   210: invokestatic access$1500 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Ljava/lang/String;
    //   213: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   218: pop
    //   219: aload_3
    //   220: aload_1
    //   221: invokevirtual writeLengths : (Lokio/BufferedSink;)V
    //   224: aload_1
    //   225: bipush #10
    //   227: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   232: pop
    //   233: goto -> 127
    //   236: aload_1
    //   237: invokeinterface close : ()V
    //   242: aload_0
    //   243: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   246: aload_0
    //   247: getfield journalFile : Ljava/io/File;
    //   250: invokeinterface exists : (Ljava/io/File;)Z
    //   255: ifeq -> 275
    //   258: aload_0
    //   259: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   262: aload_0
    //   263: getfield journalFile : Ljava/io/File;
    //   266: aload_0
    //   267: getfield journalFileBackup : Ljava/io/File;
    //   270: invokeinterface rename : (Ljava/io/File;Ljava/io/File;)V
    //   275: aload_0
    //   276: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   279: aload_0
    //   280: getfield journalFileTmp : Ljava/io/File;
    //   283: aload_0
    //   284: getfield journalFile : Ljava/io/File;
    //   287: invokeinterface rename : (Ljava/io/File;Ljava/io/File;)V
    //   292: aload_0
    //   293: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   296: aload_0
    //   297: getfield journalFileBackup : Ljava/io/File;
    //   300: invokeinterface delete : (Ljava/io/File;)V
    //   305: aload_0
    //   306: aload_0
    //   307: invokespecial newJournalWriter : ()Lokio/BufferedSink;
    //   310: putfield journalWriter : Lokio/BufferedSink;
    //   313: aload_0
    //   314: iconst_0
    //   315: putfield hasJournalErrors : Z
    //   318: aload_0
    //   319: monitorexit
    //   320: return
    //   321: astore_3
    //   322: aload_1
    //   323: invokeinterface close : ()V
    //   328: aload_3
    //   329: athrow
    //   330: astore_1
    //   331: aload_0
    //   332: monitorexit
    //   333: aload_1
    //   334: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	330	finally
    //   18	35	330	finally
    //   35	127	321	finally
    //   127	189	321	finally
    //   192	233	321	finally
    //   236	275	330	finally
    //   275	318	330	finally
    //   322	330	330	finally
  }
  
  private boolean removeEntry(Entry paramEntry) throws IOException {
    if (paramEntry.currentEditor != null)
      Editor.access$1902(paramEntry.currentEditor, true); 
    for (byte b = 0; b < this.valueCount; b++) {
      this.fileSystem.delete(paramEntry.cleanFiles[b]);
      this.size -= paramEntry.lengths[b];
      paramEntry.lengths[b] = 0L;
    } 
    this.redundantOpCount++;
    this.journalWriter.writeUtf8("REMOVE").writeByte(32).writeUtf8(paramEntry.key).writeByte(10);
    this.lruEntries.remove(paramEntry.key);
    if (journalRebuildRequired())
      this.executor.execute(this.cleanupRunnable); 
    return true;
  }
  
  private void trimToSize() throws IOException {
    while (this.size > this.maxSize)
      removeEntry(this.lruEntries.values().iterator().next()); 
  }
  
  private void validateKey(String paramString) {
    if (LEGAL_KEY_PATTERN.matcher(paramString).matches())
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("keys must match regex [a-z0-9_-]{1,120}: \"");
    stringBuilder.append(paramString);
    stringBuilder.append("\"");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void close() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield initialized : Z
    //   6: ifeq -> 108
    //   9: aload_0
    //   10: getfield closed : Z
    //   13: ifeq -> 19
    //   16: goto -> 108
    //   19: aload_0
    //   20: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   23: invokevirtual values : ()Ljava/util/Collection;
    //   26: aload_0
    //   27: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   30: invokevirtual size : ()I
    //   33: anewarray com/squareup/okhttp/internal/DiskLruCache$Entry
    //   36: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   41: checkcast [Lcom/squareup/okhttp/internal/DiskLruCache$Entry;
    //   44: astore_1
    //   45: aload_1
    //   46: arraylength
    //   47: istore_2
    //   48: iconst_0
    //   49: istore_3
    //   50: iload_3
    //   51: iload_2
    //   52: if_icmpge -> 82
    //   55: aload_1
    //   56: iload_3
    //   57: aaload
    //   58: astore #4
    //   60: aload #4
    //   62: invokestatic access$900 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Lcom/squareup/okhttp/internal/DiskLruCache$Editor;
    //   65: ifnull -> 76
    //   68: aload #4
    //   70: invokestatic access$900 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Lcom/squareup/okhttp/internal/DiskLruCache$Editor;
    //   73: invokevirtual abort : ()V
    //   76: iinc #3, 1
    //   79: goto -> 50
    //   82: aload_0
    //   83: invokespecial trimToSize : ()V
    //   86: aload_0
    //   87: getfield journalWriter : Lokio/BufferedSink;
    //   90: invokeinterface close : ()V
    //   95: aload_0
    //   96: aconst_null
    //   97: putfield journalWriter : Lokio/BufferedSink;
    //   100: aload_0
    //   101: iconst_1
    //   102: putfield closed : Z
    //   105: aload_0
    //   106: monitorexit
    //   107: return
    //   108: aload_0
    //   109: iconst_1
    //   110: putfield closed : Z
    //   113: aload_0
    //   114: monitorexit
    //   115: return
    //   116: astore #4
    //   118: aload_0
    //   119: monitorexit
    //   120: aload #4
    //   122: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	116	finally
    //   19	48	116	finally
    //   60	76	116	finally
    //   82	105	116	finally
    //   108	113	116	finally
  }
  
  public void delete() throws IOException {
    close();
    this.fileSystem.deleteContents(this.directory);
  }
  
  public Editor edit(String paramString) throws IOException {
    return edit(paramString, -1L);
  }
  
  public void evictAll() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual initialize : ()V
    //   6: aload_0
    //   7: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   10: invokevirtual values : ()Ljava/util/Collection;
    //   13: aload_0
    //   14: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   17: invokevirtual size : ()I
    //   20: anewarray com/squareup/okhttp/internal/DiskLruCache$Entry
    //   23: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   28: checkcast [Lcom/squareup/okhttp/internal/DiskLruCache$Entry;
    //   31: astore_1
    //   32: aload_1
    //   33: arraylength
    //   34: istore_2
    //   35: iconst_0
    //   36: istore_3
    //   37: iload_3
    //   38: iload_2
    //   39: if_icmpge -> 56
    //   42: aload_0
    //   43: aload_1
    //   44: iload_3
    //   45: aaload
    //   46: invokespecial removeEntry : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Z
    //   49: pop
    //   50: iinc #3, 1
    //   53: goto -> 37
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Exception table:
    //   from	to	target	type
    //   2	35	59	finally
    //   42	50	59	finally
  }
  
  public void flush() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield initialized : Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokespecial checkNotClosed : ()V
    //   18: aload_0
    //   19: invokespecial trimToSize : ()V
    //   22: aload_0
    //   23: getfield journalWriter : Lokio/BufferedSink;
    //   26: invokeinterface flush : ()V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	34	finally
    //   14	31	34	finally
  }
  
  public Snapshot get(String paramString) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual initialize : ()V
    //   6: aload_0
    //   7: invokespecial checkNotClosed : ()V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial validateKey : (Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   19: aload_1
    //   20: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast com/squareup/okhttp/internal/DiskLruCache$Entry
    //   26: astore_2
    //   27: aload_2
    //   28: ifnull -> 120
    //   31: aload_2
    //   32: invokestatic access$800 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Z
    //   35: ifne -> 41
    //   38: goto -> 120
    //   41: aload_2
    //   42: invokevirtual snapshot : ()Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;
    //   45: astore_2
    //   46: aload_2
    //   47: ifnonnull -> 54
    //   50: aload_0
    //   51: monitorexit
    //   52: aconst_null
    //   53: areturn
    //   54: aload_0
    //   55: aload_0
    //   56: getfield redundantOpCount : I
    //   59: iconst_1
    //   60: iadd
    //   61: putfield redundantOpCount : I
    //   64: aload_0
    //   65: getfield journalWriter : Lokio/BufferedSink;
    //   68: ldc 'READ'
    //   70: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   75: bipush #32
    //   77: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   82: aload_1
    //   83: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   88: bipush #10
    //   90: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   95: pop
    //   96: aload_0
    //   97: invokespecial journalRebuildRequired : ()Z
    //   100: ifeq -> 116
    //   103: aload_0
    //   104: getfield executor : Ljava/util/concurrent/Executor;
    //   107: aload_0
    //   108: getfield cleanupRunnable : Ljava/lang/Runnable;
    //   111: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_2
    //   119: areturn
    //   120: aload_0
    //   121: monitorexit
    //   122: aconst_null
    //   123: areturn
    //   124: astore_1
    //   125: aload_0
    //   126: monitorexit
    //   127: aload_1
    //   128: athrow
    // Exception table:
    //   from	to	target	type
    //   2	27	124	finally
    //   31	38	124	finally
    //   41	46	124	finally
    //   54	116	124	finally
  }
  
  public File getDirectory() {
    return this.directory;
  }
  
  public long getMaxSize() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield maxSize : J
    //   6: lstore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: lload_1
    //   10: lreturn
    //   11: astore_3
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_3
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public void initialize() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield initialized : Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   18: aload_0
    //   19: getfield journalFileBackup : Ljava/io/File;
    //   22: invokeinterface exists : (Ljava/io/File;)Z
    //   27: ifeq -> 79
    //   30: aload_0
    //   31: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   34: aload_0
    //   35: getfield journalFile : Ljava/io/File;
    //   38: invokeinterface exists : (Ljava/io/File;)Z
    //   43: ifeq -> 62
    //   46: aload_0
    //   47: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   50: aload_0
    //   51: getfield journalFileBackup : Ljava/io/File;
    //   54: invokeinterface delete : (Ljava/io/File;)V
    //   59: goto -> 79
    //   62: aload_0
    //   63: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   66: aload_0
    //   67: getfield journalFileBackup : Ljava/io/File;
    //   70: aload_0
    //   71: getfield journalFile : Ljava/io/File;
    //   74: invokeinterface rename : (Ljava/io/File;Ljava/io/File;)V
    //   79: aload_0
    //   80: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   83: aload_0
    //   84: getfield journalFile : Ljava/io/File;
    //   87: invokeinterface exists : (Ljava/io/File;)Z
    //   92: istore_1
    //   93: iload_1
    //   94: ifeq -> 193
    //   97: aload_0
    //   98: invokespecial readJournal : ()V
    //   101: aload_0
    //   102: invokespecial processJournal : ()V
    //   105: aload_0
    //   106: iconst_1
    //   107: putfield initialized : Z
    //   110: aload_0
    //   111: monitorexit
    //   112: return
    //   113: astore_2
    //   114: invokestatic get : ()Lcom/squareup/okhttp/internal/Platform;
    //   117: astore_3
    //   118: new java/lang/StringBuilder
    //   121: astore #4
    //   123: aload #4
    //   125: invokespecial <init> : ()V
    //   128: aload #4
    //   130: ldc_w 'DiskLruCache '
    //   133: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload #4
    //   139: aload_0
    //   140: getfield directory : Ljava/io/File;
    //   143: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload #4
    //   149: ldc_w ' is corrupt: '
    //   152: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload #4
    //   158: aload_2
    //   159: invokevirtual getMessage : ()Ljava/lang/String;
    //   162: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload #4
    //   168: ldc_w ', removing'
    //   171: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_3
    //   176: aload #4
    //   178: invokevirtual toString : ()Ljava/lang/String;
    //   181: invokevirtual logW : (Ljava/lang/String;)V
    //   184: aload_0
    //   185: invokevirtual delete : ()V
    //   188: aload_0
    //   189: iconst_0
    //   190: putfield closed : Z
    //   193: aload_0
    //   194: invokespecial rebuildJournal : ()V
    //   197: aload_0
    //   198: iconst_1
    //   199: putfield initialized : Z
    //   202: aload_0
    //   203: monitorexit
    //   204: return
    //   205: astore_2
    //   206: aload_0
    //   207: monitorexit
    //   208: aload_2
    //   209: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	205	finally
    //   14	59	205	finally
    //   62	79	205	finally
    //   79	93	205	finally
    //   97	110	113	java/io/IOException
    //   97	110	205	finally
    //   114	193	205	finally
    //   193	202	205	finally
  }
  
  public boolean isClosed() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield closed : Z
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public boolean remove(String paramString) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual initialize : ()V
    //   6: aload_0
    //   7: invokespecial checkNotClosed : ()V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial validateKey : (Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   19: aload_1
    //   20: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast com/squareup/okhttp/internal/DiskLruCache$Entry
    //   26: astore_1
    //   27: aload_1
    //   28: ifnonnull -> 35
    //   31: aload_0
    //   32: monitorexit
    //   33: iconst_0
    //   34: ireturn
    //   35: aload_0
    //   36: aload_1
    //   37: invokespecial removeEntry : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Z
    //   40: istore_2
    //   41: aload_0
    //   42: monitorexit
    //   43: iload_2
    //   44: ireturn
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Exception table:
    //   from	to	target	type
    //   2	27	45	finally
    //   35	41	45	finally
  }
  
  public void setMaxSize(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: lload_1
    //   4: putfield maxSize : J
    //   7: aload_0
    //   8: getfield initialized : Z
    //   11: ifeq -> 27
    //   14: aload_0
    //   15: getfield executor : Ljava/util/concurrent/Executor;
    //   18: aload_0
    //   19: getfield cleanupRunnable : Ljava/lang/Runnable;
    //   22: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: astore_3
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_3
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   2	27	30	finally
  }
  
  public long size() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual initialize : ()V
    //   6: aload_0
    //   7: getfield size : J
    //   10: lstore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: lload_1
    //   14: lreturn
    //   15: astore_3
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_3
    //   19: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	15	finally
  }
  
  public Iterator<Snapshot> snapshots() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual initialize : ()V
    //   6: new com/squareup/okhttp/internal/DiskLruCache$3
    //   9: dup
    //   10: aload_0
    //   11: invokespecial <init> : (Lcom/squareup/okhttp/internal/DiskLruCache;)V
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: areturn
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: athrow
    // Exception table:
    //   from	to	target	type
    //   2	15	19	finally
  }
  
  public final class Editor {
    private boolean committed;
    
    private final DiskLruCache.Entry entry;
    
    private boolean hasErrors;
    
    private final boolean[] written;
    
    private Editor(DiskLruCache.Entry param1Entry) {
      boolean[] arrayOfBoolean;
      this.entry = param1Entry;
      if (param1Entry.readable) {
        DiskLruCache.this = null;
      } else {
        arrayOfBoolean = new boolean[DiskLruCache.this.valueCount];
      } 
      this.written = arrayOfBoolean;
    }
    
    public void abort() throws IOException {
      synchronized (DiskLruCache.this) {
        DiskLruCache.this.completeEdit(this, false);
        return;
      } 
    }
    
    public void abortUnlessCommitted() {
      synchronized (DiskLruCache.this) {
        boolean bool = this.committed;
        if (!bool)
          try {
            DiskLruCache.this.completeEdit(this, false);
          } catch (IOException iOException) {} 
        return;
      } 
    }
    
    public void commit() throws IOException {
      synchronized (DiskLruCache.this) {
        if (this.hasErrors) {
          DiskLruCache.this.completeEdit(this, false);
          DiskLruCache.this.removeEntry(this.entry);
        } else {
          DiskLruCache.this.completeEdit(this, true);
        } 
        this.committed = true;
        return;
      } 
    }
    
    public Sink newSink(int param1Int) throws IOException {
      synchronized (DiskLruCache.this) {
        if (this.entry.currentEditor == this) {
          if (!this.entry.readable)
            this.written[param1Int] = true; 
          File file = this.entry.dirtyFiles[param1Int];
          try {
            Sink sink = DiskLruCache.this.fileSystem.sink(file);
            FaultHidingSink faultHidingSink = new FaultHidingSink() {
                protected void onException(IOException param2IOException) {
                  synchronized (DiskLruCache.this) {
                    DiskLruCache.Editor.access$1902(DiskLruCache.Editor.this, true);
                    return;
                  } 
                }
              };
            super(this, sink);
            return (Sink)faultHidingSink;
          } catch (FileNotFoundException fileNotFoundException) {
            return DiskLruCache.NULL_SINK;
          } 
        } 
        IllegalStateException illegalStateException = new IllegalStateException();
        this();
        throw illegalStateException;
      } 
    }
    
    public Source newSource(int param1Int) throws IOException {
      synchronized (DiskLruCache.this) {
        if (this.entry.currentEditor == this) {
          if (!this.entry.readable)
            return null; 
          try {
            return DiskLruCache.this.fileSystem.source(this.entry.cleanFiles[param1Int]);
          } catch (FileNotFoundException fileNotFoundException) {
            return null;
          } 
        } 
        IllegalStateException illegalStateException = new IllegalStateException();
        this();
        throw illegalStateException;
      } 
    }
  }
  
  class null extends FaultHidingSink {
    null(Sink param1Sink) {
      super(param1Sink);
    }
    
    protected void onException(IOException param1IOException) {
      synchronized (DiskLruCache.this) {
        DiskLruCache.Editor.access$1902(this.this$1, true);
        return;
      } 
    }
  }
  
  private final class Entry {
    private final File[] cleanFiles;
    
    private DiskLruCache.Editor currentEditor;
    
    private final File[] dirtyFiles;
    
    private final String key;
    
    private final long[] lengths;
    
    private boolean readable;
    
    private long sequenceNumber;
    
    private Entry(String param1String) {
      this.key = param1String;
      this.lengths = new long[DiskLruCache.this.valueCount];
      this.cleanFiles = new File[DiskLruCache.this.valueCount];
      this.dirtyFiles = new File[DiskLruCache.this.valueCount];
      StringBuilder stringBuilder = new StringBuilder(param1String);
      stringBuilder.append('.');
      int i = stringBuilder.length();
      for (byte b = 0; b < DiskLruCache.this.valueCount; b++) {
        stringBuilder.append(b);
        this.cleanFiles[b] = new File(DiskLruCache.this.directory, stringBuilder.toString());
        stringBuilder.append(".tmp");
        this.dirtyFiles[b] = new File(DiskLruCache.this.directory, stringBuilder.toString());
        stringBuilder.setLength(i);
      } 
    }
    
    private IOException invalidLengths(String[] param1ArrayOfString) throws IOException {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unexpected journal line: ");
      stringBuilder.append(Arrays.toString((Object[])param1ArrayOfString));
      throw new IOException(stringBuilder.toString());
    }
    
    private void setLengths(String[] param1ArrayOfString) throws IOException {
      if (param1ArrayOfString.length == DiskLruCache.this.valueCount) {
        byte b = 0;
        try {
          while (b < param1ArrayOfString.length) {
            this.lengths[b] = Long.parseLong(param1ArrayOfString[b]);
            b++;
          } 
          return;
        } catch (NumberFormatException numberFormatException) {
          throw invalidLengths(param1ArrayOfString);
        } 
      } 
      throw invalidLengths(param1ArrayOfString);
    }
    
    DiskLruCache.Snapshot snapshot() {
      if (Thread.holdsLock(DiskLruCache.this)) {
        Source[] arrayOfSource = new Source[DiskLruCache.this.valueCount];
        long[] arrayOfLong = (long[])this.lengths.clone();
        boolean bool = false;
        byte b = 0;
        try {
          while (b < DiskLruCache.this.valueCount) {
            arrayOfSource[b] = DiskLruCache.this.fileSystem.source(this.cleanFiles[b]);
            b++;
          } 
          return new DiskLruCache.Snapshot(this.key, this.sequenceNumber, arrayOfSource, arrayOfLong);
        } catch (FileNotFoundException fileNotFoundException) {
          for (b = bool; b < DiskLruCache.this.valueCount && arrayOfSource[b] != null; b++)
            Util.closeQuietly((Closeable)arrayOfSource[b]); 
          return null;
        } 
      } 
      throw new AssertionError();
    }
    
    void writeLengths(BufferedSink param1BufferedSink) throws IOException {
      for (long l : this.lengths)
        param1BufferedSink.writeByte(32).writeDecimalLong(l); 
    }
  }
  
  public final class Snapshot implements Closeable {
    private final String key;
    
    private final long[] lengths;
    
    private final long sequenceNumber;
    
    private final Source[] sources;
    
    private Snapshot(String param1String, long param1Long, Source[] param1ArrayOfSource, long[] param1ArrayOflong) {
      this.key = param1String;
      this.sequenceNumber = param1Long;
      this.sources = param1ArrayOfSource;
      this.lengths = param1ArrayOflong;
    }
    
    public void close() {
      Source[] arrayOfSource = this.sources;
      int i = arrayOfSource.length;
      for (byte b = 0; b < i; b++)
        Util.closeQuietly((Closeable)arrayOfSource[b]); 
    }
    
    public DiskLruCache.Editor edit() throws IOException {
      return DiskLruCache.this.edit(this.key, this.sequenceNumber);
    }
    
    public long getLength(int param1Int) {
      return this.lengths[param1Int];
    }
    
    public Source getSource(int param1Int) {
      return this.sources[param1Int];
    }
    
    public String key() {
      return this.key;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\okhttp\internal\DiskLruCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */