package android.support.v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.support.annotation.GuardedBy;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider extends ContentProvider {
  private static final String ATTR_NAME = "name";
  
  private static final String ATTR_PATH = "path";
  
  private static final String[] COLUMNS = new String[] { "_display_name", "_size" };
  
  private static final File DEVICE_ROOT = new File("/");
  
  private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
  
  private static final String TAG_CACHE_PATH = "cache-path";
  
  private static final String TAG_EXTERNAL = "external-path";
  
  private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
  
  private static final String TAG_EXTERNAL_FILES = "external-files-path";
  
  private static final String TAG_EXTERNAL_MEDIA = "external-media-path";
  
  private static final String TAG_FILES_PATH = "files-path";
  
  private static final String TAG_ROOT_PATH = "root-path";
  
  @GuardedBy("sCache")
  private static HashMap<String, PathStrategy> sCache = new HashMap<String, PathStrategy>();
  
  private PathStrategy mStrategy;
  
  private static File buildPath(File paramFile, String... paramVarArgs) {
    int i = paramVarArgs.length;
    byte b = 0;
    File file;
    for (file = paramFile; b < i; file = paramFile) {
      String str = paramVarArgs[b];
      paramFile = file;
      if (str != null)
        paramFile = new File(file, str); 
      b++;
    } 
    return file;
  }
  
  private static Object[] copyOf(Object[] paramArrayOfObject, int paramInt) {
    Object[] arrayOfObject = new Object[paramInt];
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramInt);
    return arrayOfObject;
  }
  
  private static String[] copyOf(String[] paramArrayOfString, int paramInt) {
    String[] arrayOfString = new String[paramInt];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramInt);
    return arrayOfString;
  }
  
  private static PathStrategy getPathStrategy(Context paramContext, String paramString) {
    synchronized (sCache) {
      PathStrategy pathStrategy1 = sCache.get(paramString);
      PathStrategy pathStrategy2 = pathStrategy1;
      if (pathStrategy1 == null)
        try {
          pathStrategy2 = parsePathStrategy(paramContext, paramString);
          sCache.put(paramString, pathStrategy2);
        } catch (IOException iOException) {
          IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
          this("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", iOException);
          throw illegalArgumentException;
        } catch (XmlPullParserException xmlPullParserException) {
          IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
          this("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", (Throwable)xmlPullParserException);
          throw illegalArgumentException;
        }  
      return pathStrategy2;
    } 
  }
  
  public static Uri getUriForFile(@NonNull Context paramContext, @NonNull String paramString, @NonNull File paramFile) {
    return getPathStrategy(paramContext, paramString).getUriForFile(paramFile);
  }
  
  private static int modeToMode(String paramString) {
    int i;
    if ("r".equals(paramString)) {
      i = 268435456;
    } else {
      if ("w".equals(paramString) || "wt".equals(paramString))
        return 738197504; 
      if ("wa".equals(paramString)) {
        i = 704643072;
      } else if ("rw".equals(paramString)) {
        i = 939524096;
      } else if ("rwt".equals(paramString)) {
        i = 1006632960;
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid mode: ");
        stringBuilder.append(paramString);
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
    } 
    return i;
  }
  
  private static PathStrategy parsePathStrategy(Context paramContext, String paramString) throws IOException, XmlPullParserException {
    SimplePathStrategy simplePathStrategy = new SimplePathStrategy(paramString);
    XmlResourceParser xmlResourceParser = paramContext.getPackageManager().resolveContentProvider(paramString, 128).loadXmlMetaData(paramContext.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
    if (xmlResourceParser != null)
      while (true) {
        int i = xmlResourceParser.next();
        if (i != 1) {
          if (i == 2) {
            File file;
            String str1 = xmlResourceParser.getName();
            String str2 = null;
            String str3 = xmlResourceParser.getAttributeValue(null, "name");
            String str4 = xmlResourceParser.getAttributeValue(null, "path");
            if ("root-path".equals(str1)) {
              file = DEVICE_ROOT;
            } else if ("files-path".equals(str1)) {
              file = paramContext.getFilesDir();
            } else if ("cache-path".equals(str1)) {
              file = paramContext.getCacheDir();
            } else if ("external-path".equals(str1)) {
              file = Environment.getExternalStorageDirectory();
            } else {
              File[] arrayOfFile;
              if ("external-files-path".equals(str1)) {
                arrayOfFile = ContextCompat.getExternalFilesDirs(paramContext, null);
                paramString = str2;
                if (arrayOfFile.length > 0)
                  file = arrayOfFile[0]; 
              } else if ("external-cache-path".equals(arrayOfFile)) {
                arrayOfFile = ContextCompat.getExternalCacheDirs(paramContext);
                paramString = str2;
                if (arrayOfFile.length > 0)
                  file = arrayOfFile[0]; 
              } else {
                paramString = str2;
                if (Build.VERSION.SDK_INT >= 21) {
                  paramString = str2;
                  if ("external-media-path".equals(arrayOfFile)) {
                    arrayOfFile = paramContext.getExternalMediaDirs();
                    paramString = str2;
                    if (arrayOfFile.length > 0)
                      file = arrayOfFile[0]; 
                  } 
                } 
              } 
            } 
            if (file != null)
              simplePathStrategy.addRoot(str3, buildPath(file, new String[] { str4 })); 
          } 
          continue;
        } 
        return simplePathStrategy;
      }  
    throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
  }
  
  public void attachInfo(@NonNull Context paramContext, @NonNull ProviderInfo paramProviderInfo) {
    super.attachInfo(paramContext, paramProviderInfo);
    if (!paramProviderInfo.exported) {
      if (paramProviderInfo.grantUriPermissions) {
        this.mStrategy = getPathStrategy(paramContext, paramProviderInfo.authority);
        return;
      } 
      throw new SecurityException("Provider must grant uri permissions");
    } 
    throw new SecurityException("Provider must not be exported");
  }
  
  public int delete(@NonNull Uri paramUri, @Nullable String paramString, @Nullable String[] paramArrayOfString) {
    return this.mStrategy.getFileForUri(paramUri).delete();
  }
  
  public String getType(@NonNull Uri paramUri) {
    File file = this.mStrategy.getFileForUri(paramUri);
    int i = file.getName().lastIndexOf('.');
    if (i >= 0) {
      String str = file.getName().substring(i + 1);
      str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
      if (str != null)
        return str; 
    } 
    return "application/octet-stream";
  }
  
  public Uri insert(@NonNull Uri paramUri, ContentValues paramContentValues) {
    throw new UnsupportedOperationException("No external inserts");
  }
  
  public boolean onCreate() {
    return true;
  }
  
  public ParcelFileDescriptor openFile(@NonNull Uri paramUri, @NonNull String paramString) throws FileNotFoundException {
    return ParcelFileDescriptor.open(this.mStrategy.getFileForUri(paramUri), modeToMode(paramString));
  }
  
  public Cursor query(@NonNull Uri paramUri, @Nullable String[] paramArrayOfString1, @Nullable String paramString1, @Nullable String[] paramArrayOfString2, @Nullable String paramString2) {
    File file = this.mStrategy.getFileForUri(paramUri);
    String[] arrayOfString = paramArrayOfString1;
    if (paramArrayOfString1 == null)
      arrayOfString = COLUMNS; 
    paramArrayOfString2 = new String[arrayOfString.length];
    Object[] arrayOfObject = new Object[arrayOfString.length];
    int i = arrayOfString.length;
    byte b = 0;
    int j;
    for (j = 0; b < i; j = k) {
      int k;
      paramString2 = arrayOfString[b];
      if ("_display_name".equals(paramString2)) {
        paramArrayOfString2[j] = "_display_name";
        arrayOfObject[j] = file.getName();
        k = j + 1;
      } else {
        k = j;
        if ("_size".equals(paramString2)) {
          paramArrayOfString2[j] = "_size";
          arrayOfObject[j] = Long.valueOf(file.length());
          k = j + 1;
        } 
      } 
      b++;
    } 
    arrayOfString = copyOf(paramArrayOfString2, j);
    arrayOfObject = copyOf(arrayOfObject, j);
    MatrixCursor matrixCursor = new MatrixCursor(arrayOfString, 1);
    matrixCursor.addRow(arrayOfObject);
    return (Cursor)matrixCursor;
  }
  
  public int update(@NonNull Uri paramUri, ContentValues paramContentValues, @Nullable String paramString, @Nullable String[] paramArrayOfString) {
    throw new UnsupportedOperationException("No external updates");
  }
  
  static interface PathStrategy {
    File getFileForUri(Uri param1Uri);
    
    Uri getUriForFile(File param1File);
  }
  
  static class SimplePathStrategy implements PathStrategy {
    private final String mAuthority;
    
    private final HashMap<String, File> mRoots = new HashMap<String, File>();
    
    SimplePathStrategy(String param1String) {
      this.mAuthority = param1String;
    }
    
    void addRoot(String param1String, File param1File) {
      if (!TextUtils.isEmpty(param1String))
        try {
          File file = param1File.getCanonicalFile();
          this.mRoots.put(param1String, file);
          return;
        } catch (IOException iOException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Failed to resolve canonical path for ");
          stringBuilder.append(param1File);
          throw new IllegalArgumentException(stringBuilder.toString(), iOException);
        }  
      throw new IllegalArgumentException("Name must not be empty");
    }
    
    public File getFileForUri(Uri param1Uri) {
      File file1;
      String str1 = param1Uri.getEncodedPath();
      int i = str1.indexOf('/', 1);
      String str2 = Uri.decode(str1.substring(1, i));
      str1 = Uri.decode(str1.substring(i + 1));
      File file2 = this.mRoots.get(str2);
      if (file2 != null) {
        file1 = new File(file2, str1);
        try {
          File file = file1.getCanonicalFile();
          if (file.getPath().startsWith(file2.getPath()))
            return file; 
          throw new SecurityException("Resolved path jumped beyond configured root");
        } catch (IOException iOException) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Failed to resolve canonical path for ");
          stringBuilder1.append(file1);
          throw new IllegalArgumentException(stringBuilder1.toString());
        } 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to find configured root for ");
      stringBuilder.append(file1);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public Uri getUriForFile(File param1File) {
      StringBuilder stringBuilder;
      try {
        Map.Entry<String, File> entry;
        StringBuilder stringBuilder1;
        String str = param1File.getCanonicalPath();
        param1File = null;
        for (Map.Entry<String, File> entry1 : this.mRoots.entrySet()) {
          String str1 = ((File)entry1.getValue()).getPath();
          if (str.startsWith(str1) && (param1File == null || str1.length() > ((File)param1File.getValue()).getPath().length()))
            entry = entry1; 
        } 
        if (entry != null) {
          String str2 = ((File)entry.getValue()).getPath();
          if (str2.endsWith("/")) {
            str2 = str.substring(str2.length());
          } else {
            str2 = str.substring(str2.length() + 1);
          } 
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append(Uri.encode(entry.getKey()));
          stringBuilder1.append('/');
          stringBuilder1.append(Uri.encode(str2, "/"));
          String str1 = stringBuilder1.toString();
          return (new Uri.Builder()).scheme("content").authority(this.mAuthority).encodedPath(str1).build();
        } 
        stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to find configured root that contains ");
        stringBuilder.append((String)stringBuilder1);
        throw new IllegalArgumentException(stringBuilder.toString());
      } catch (IOException iOException) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Failed to resolve canonical path for ");
        stringBuilder1.append(stringBuilder);
        throw new IllegalArgumentException(stringBuilder1.toString());
      } 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\v4\content\FileProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */