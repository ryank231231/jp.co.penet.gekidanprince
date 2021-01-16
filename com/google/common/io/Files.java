package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.TreeTraverser;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Beta
@GwtIncompatible
public final class Files {
  private static final TreeTraverser<File> FILE_TREE_TRAVERSER = new TreeTraverser<File>() {
      public Iterable<File> children(File param1File) {
        if (param1File.isDirectory()) {
          File[] arrayOfFile = param1File.listFiles();
          if (arrayOfFile != null)
            return Collections.unmodifiableList(Arrays.asList(arrayOfFile)); 
        } 
        return Collections.emptyList();
      }
      
      public String toString() {
        return "Files.fileTreeTraverser()";
      }
    };
  
  private static final int TEMP_DIR_ATTEMPTS = 10000;
  
  public static void append(CharSequence paramCharSequence, File paramFile, Charset paramCharset) throws IOException {
    write(paramCharSequence, paramFile, paramCharset, true);
  }
  
  public static ByteSink asByteSink(File paramFile, FileWriteMode... paramVarArgs) {
    return new FileByteSink(paramFile, paramVarArgs);
  }
  
  public static ByteSource asByteSource(File paramFile) {
    return new FileByteSource(paramFile);
  }
  
  public static CharSink asCharSink(File paramFile, Charset paramCharset, FileWriteMode... paramVarArgs) {
    return asByteSink(paramFile, paramVarArgs).asCharSink(paramCharset);
  }
  
  public static CharSource asCharSource(File paramFile, Charset paramCharset) {
    return asByteSource(paramFile).asCharSource(paramCharset);
  }
  
  public static void copy(File paramFile1, File paramFile2) throws IOException {
    Preconditions.checkArgument(paramFile1.equals(paramFile2) ^ true, "Source %s and destination %s must be different", paramFile1, paramFile2);
    asByteSource(paramFile1).copyTo(asByteSink(paramFile2, new FileWriteMode[0]));
  }
  
  public static void copy(File paramFile, OutputStream paramOutputStream) throws IOException {
    asByteSource(paramFile).copyTo(paramOutputStream);
  }
  
  public static void copy(File paramFile, Charset paramCharset, Appendable paramAppendable) throws IOException {
    asCharSource(paramFile, paramCharset).copyTo(paramAppendable);
  }
  
  public static void createParentDirs(File paramFile) throws IOException {
    Preconditions.checkNotNull(paramFile);
    File file = paramFile.getCanonicalFile().getParentFile();
    if (file == null)
      return; 
    file.mkdirs();
    if (file.isDirectory())
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unable to create parent directories of ");
    stringBuilder.append(paramFile);
    throw new IOException(stringBuilder.toString());
  }
  
  public static File createTempDir() {
    File file = new File(System.getProperty("java.io.tmpdir"));
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(System.currentTimeMillis());
    stringBuilder2.append("-");
    String str = stringBuilder2.toString();
    for (byte b = 0; b < '✐'; b++) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(b);
      File file1 = new File(file, stringBuilder.toString());
      if (file1.mkdir())
        return file1; 
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("Failed to create directory within 10000 attempts (tried ");
    stringBuilder1.append(str);
    stringBuilder1.append("0 to ");
    stringBuilder1.append(str);
    stringBuilder1.append(9999);
    stringBuilder1.append(')');
    throw new IllegalStateException(stringBuilder1.toString());
  }
  
  public static boolean equal(File paramFile1, File paramFile2) throws IOException {
    Preconditions.checkNotNull(paramFile1);
    Preconditions.checkNotNull(paramFile2);
    if (paramFile1 == paramFile2 || paramFile1.equals(paramFile2))
      return true; 
    long l1 = paramFile1.length();
    long l2 = paramFile2.length();
    return (l1 != 0L && l2 != 0L && l1 != l2) ? false : asByteSource(paramFile1).contentEquals(asByteSource(paramFile2));
  }
  
  public static TreeTraverser<File> fileTreeTraverser() {
    return FILE_TREE_TRAVERSER;
  }
  
  public static String getFileExtension(String paramString) {
    Preconditions.checkNotNull(paramString);
    paramString = (new File(paramString)).getName();
    int i = paramString.lastIndexOf('.');
    if (i == -1) {
      paramString = "";
    } else {
      paramString = paramString.substring(i + 1);
    } 
    return paramString;
  }
  
  public static String getNameWithoutExtension(String paramString) {
    Preconditions.checkNotNull(paramString);
    paramString = (new File(paramString)).getName();
    int i = paramString.lastIndexOf('.');
    if (i != -1)
      paramString = paramString.substring(0, i); 
    return paramString;
  }
  
  public static HashCode hash(File paramFile, HashFunction paramHashFunction) throws IOException {
    return asByteSource(paramFile).hash(paramHashFunction);
  }
  
  public static Predicate<File> isDirectory() {
    return FilePredicate.IS_DIRECTORY;
  }
  
  public static Predicate<File> isFile() {
    return FilePredicate.IS_FILE;
  }
  
  public static MappedByteBuffer map(File paramFile) throws IOException {
    Preconditions.checkNotNull(paramFile);
    return map(paramFile, FileChannel.MapMode.READ_ONLY);
  }
  
  public static MappedByteBuffer map(File paramFile, FileChannel.MapMode paramMapMode) throws IOException {
    Preconditions.checkNotNull(paramFile);
    Preconditions.checkNotNull(paramMapMode);
    if (paramFile.exists())
      return map(paramFile, paramMapMode, paramFile.length()); 
    throw new FileNotFoundException(paramFile.toString());
  }
  
  public static MappedByteBuffer map(File paramFile, FileChannel.MapMode paramMapMode, long paramLong) throws FileNotFoundException, IOException {
    Preconditions.checkNotNull(paramFile);
    Preconditions.checkNotNull(paramMapMode);
    Closer closer = Closer.create();
    try {
      String str;
      RandomAccessFile randomAccessFile = new RandomAccessFile();
      if (paramMapMode == FileChannel.MapMode.READ_ONLY) {
        str = "r";
      } else {
        str = "rw";
      } 
      this(paramFile, str);
      MappedByteBuffer mappedByteBuffer = map(closer.<RandomAccessFile>register(randomAccessFile), paramMapMode, paramLong);
      closer.close();
      return mappedByteBuffer;
    } catch (Throwable throwable) {
      throw closer.rethrow(throwable);
    } finally {}
    closer.close();
    throw paramFile;
  }
  
  private static MappedByteBuffer map(RandomAccessFile paramRandomAccessFile, FileChannel.MapMode paramMapMode, long paramLong) throws IOException {
    Closer closer = Closer.create();
    try {
      MappedByteBuffer mappedByteBuffer = ((FileChannel)closer.<FileChannel>register(paramRandomAccessFile.getChannel())).map(paramMapMode, 0L, paramLong);
      closer.close();
      return mappedByteBuffer;
    } catch (Throwable throwable) {
      throw closer.rethrow(throwable);
    } finally {}
    closer.close();
    throw paramRandomAccessFile;
  }
  
  private static FileWriteMode[] modes(boolean paramBoolean) {
    FileWriteMode[] arrayOfFileWriteMode;
    if (paramBoolean) {
      arrayOfFileWriteMode = new FileWriteMode[1];
      arrayOfFileWriteMode[0] = FileWriteMode.APPEND;
    } else {
      arrayOfFileWriteMode = new FileWriteMode[0];
    } 
    return arrayOfFileWriteMode;
  }
  
  public static void move(File paramFile1, File paramFile2) throws IOException {
    Preconditions.checkNotNull(paramFile1);
    Preconditions.checkNotNull(paramFile2);
    Preconditions.checkArgument(paramFile1.equals(paramFile2) ^ true, "Source %s and destination %s must be different", paramFile1, paramFile2);
    if (!paramFile1.renameTo(paramFile2)) {
      copy(paramFile1, paramFile2);
      if (!paramFile1.delete()) {
        StringBuilder stringBuilder1;
        if (!paramFile2.delete()) {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Unable to delete ");
          stringBuilder1.append(paramFile2);
          throw new IOException(stringBuilder1.toString());
        } 
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Unable to delete ");
        stringBuilder2.append(stringBuilder1);
        throw new IOException(stringBuilder2.toString());
      } 
    } 
  }
  
  public static BufferedReader newReader(File paramFile, Charset paramCharset) throws FileNotFoundException {
    Preconditions.checkNotNull(paramFile);
    Preconditions.checkNotNull(paramCharset);
    return new BufferedReader(new InputStreamReader(new FileInputStream(paramFile), paramCharset));
  }
  
  public static BufferedWriter newWriter(File paramFile, Charset paramCharset) throws FileNotFoundException {
    Preconditions.checkNotNull(paramFile);
    Preconditions.checkNotNull(paramCharset);
    return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(paramFile), paramCharset));
  }
  
  @CanIgnoreReturnValue
  public static <T> T readBytes(File paramFile, ByteProcessor<T> paramByteProcessor) throws IOException {
    return asByteSource(paramFile).read(paramByteProcessor);
  }
  
  static byte[] readFile(InputStream paramInputStream, long paramLong) throws IOException {
    if (paramLong <= 2147483647L) {
      byte[] arrayOfByte;
      if (paramLong == 0L) {
        arrayOfByte = ByteStreams.toByteArray(paramInputStream);
      } else {
        arrayOfByte = ByteStreams.toByteArray((InputStream)arrayOfByte, (int)paramLong);
      } 
      return arrayOfByte;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("file is too large to fit in a byte array: ");
    stringBuilder.append(paramLong);
    stringBuilder.append(" bytes");
    throw new OutOfMemoryError(stringBuilder.toString());
  }
  
  public static String readFirstLine(File paramFile, Charset paramCharset) throws IOException {
    return asCharSource(paramFile, paramCharset).readFirstLine();
  }
  
  @CanIgnoreReturnValue
  public static <T> T readLines(File paramFile, Charset paramCharset, LineProcessor<T> paramLineProcessor) throws IOException {
    return asCharSource(paramFile, paramCharset).readLines(paramLineProcessor);
  }
  
  public static List<String> readLines(File paramFile, Charset paramCharset) throws IOException {
    return readLines(paramFile, paramCharset, new LineProcessor<List<String>>() {
          final List<String> result = Lists.newArrayList();
          
          public List<String> getResult() {
            return this.result;
          }
          
          public boolean processLine(String param1String) {
            this.result.add(param1String);
            return true;
          }
        });
  }
  
  public static String simplifyPath(String paramString) {
    Preconditions.checkNotNull(paramString);
    if (paramString.length() == 0)
      return "."; 
    Iterable iterable = Splitter.on('/').omitEmptyStrings().split(paramString);
    ArrayList<String> arrayList = new ArrayList();
    for (String str : iterable) {
      if (str.equals("."))
        continue; 
      if (str.equals("..")) {
        if (arrayList.size() > 0 && !((String)arrayList.get(arrayList.size() - 1)).equals("..")) {
          arrayList.remove(arrayList.size() - 1);
          continue;
        } 
        arrayList.add("..");
        continue;
      } 
      arrayList.add(str);
    } 
    String str1 = Joiner.on('/').join(arrayList);
    String str2 = str1;
    if (paramString.charAt(0) == '/') {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("/");
      stringBuilder.append(str1);
      str2 = stringBuilder.toString();
    } 
    while (str2.startsWith("/../"))
      str2 = str2.substring(3); 
    if (str2.equals("/..")) {
      paramString = "/";
    } else {
      paramString = str2;
      if ("".equals(str2))
        paramString = "."; 
    } 
    return paramString;
  }
  
  public static byte[] toByteArray(File paramFile) throws IOException {
    return asByteSource(paramFile).read();
  }
  
  public static String toString(File paramFile, Charset paramCharset) throws IOException {
    return asCharSource(paramFile, paramCharset).read();
  }
  
  public static void touch(File paramFile) throws IOException {
    Preconditions.checkNotNull(paramFile);
    if (paramFile.createNewFile() || paramFile.setLastModified(System.currentTimeMillis()))
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unable to update modification time of ");
    stringBuilder.append(paramFile);
    throw new IOException(stringBuilder.toString());
  }
  
  public static void write(CharSequence paramCharSequence, File paramFile, Charset paramCharset) throws IOException {
    asCharSink(paramFile, paramCharset, new FileWriteMode[0]).write(paramCharSequence);
  }
  
  private static void write(CharSequence paramCharSequence, File paramFile, Charset paramCharset, boolean paramBoolean) throws IOException {
    asCharSink(paramFile, paramCharset, modes(paramBoolean)).write(paramCharSequence);
  }
  
  public static void write(byte[] paramArrayOfbyte, File paramFile) throws IOException {
    asByteSink(paramFile, new FileWriteMode[0]).write(paramArrayOfbyte);
  }
  
  private static final class FileByteSink extends ByteSink {
    private final File file;
    
    private final ImmutableSet<FileWriteMode> modes;
    
    private FileByteSink(File param1File, FileWriteMode... param1VarArgs) {
      this.file = (File)Preconditions.checkNotNull(param1File);
      this.modes = ImmutableSet.copyOf((Object[])param1VarArgs);
    }
    
    public FileOutputStream openStream() throws IOException {
      return new FileOutputStream(this.file, this.modes.contains(FileWriteMode.APPEND));
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Files.asByteSink(");
      stringBuilder.append(this.file);
      stringBuilder.append(", ");
      stringBuilder.append(this.modes);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private static final class FileByteSource extends ByteSource {
    private final File file;
    
    private FileByteSource(File param1File) {
      this.file = (File)Preconditions.checkNotNull(param1File);
    }
    
    public FileInputStream openStream() throws IOException {
      return new FileInputStream(this.file);
    }
    
    public byte[] read() throws IOException {
      Throwable throwable;
      Closer closer = Closer.create();
      try {
        FileInputStream fileInputStream = closer.<FileInputStream>register(openStream());
        byte[] arrayOfByte = Files.readFile(fileInputStream, fileInputStream.getChannel().size());
        closer.close();
        return arrayOfByte;
      } catch (Throwable null) {
        throw closer.rethrow(throwable);
      } finally {}
      closer.close();
      throw throwable;
    }
    
    public long size() throws IOException {
      if (this.file.isFile())
        return this.file.length(); 
      throw new FileNotFoundException(this.file.toString());
    }
    
    public Optional<Long> sizeIfKnown() {
      return this.file.isFile() ? Optional.of(Long.valueOf(this.file.length())) : Optional.absent();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Files.asByteSource(");
      stringBuilder.append(this.file);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private enum FilePredicate implements Predicate<File> {
    IS_DIRECTORY {
      public boolean apply(File param2File) {
        return param2File.isDirectory();
      }
      
      public String toString() {
        return "Files.isDirectory()";
      }
    },
    IS_FILE {
      public boolean apply(File param2File) {
        return param2File.isFile();
      }
      
      public String toString() {
        return "Files.isFile()";
      }
    };
    
    static {
    
    }
  }
  
  enum null {
    public boolean apply(File param1File) {
      return param1File.isDirectory();
    }
    
    public String toString() {
      return "Files.isDirectory()";
    }
  }
  
  enum null {
    public boolean apply(File param1File) {
      return param1File.isFile();
    }
    
    public String toString() {
      return "Files.isFile()";
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\io\Files.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */