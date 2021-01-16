package com.squareup.okhttp.internal;

import com.squareup.okhttp.HttpUrl;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.ByteString;
import okio.Source;

public final class Util {
  public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  
  public static final String[] EMPTY_STRING_ARRAY = new String[0];
  
  public static final Charset UTF_8 = Charset.forName("UTF-8");
  
  public static void checkOffsetAndCount(long paramLong1, long paramLong2, long paramLong3) {
    if ((paramLong2 | paramLong3) >= 0L && paramLong2 <= paramLong1 && paramLong1 - paramLong2 >= paramLong3)
      return; 
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public static void closeAll(Closeable paramCloseable1, Closeable paramCloseable2) throws IOException {
    Throwable throwable2;
    try {
      paramCloseable1.close();
      paramCloseable1 = null;
    } catch (Throwable throwable1) {}
    try {
      paramCloseable2.close();
      throwable2 = throwable1;
    } catch (Throwable throwable) {
      throwable2 = throwable1;
      if (throwable1 == null)
        throwable2 = throwable; 
    } 
    if (throwable2 == null)
      return; 
    if (!(throwable2 instanceof IOException)) {
      if (!(throwable2 instanceof RuntimeException)) {
        if (throwable2 instanceof Error)
          throw (Error)throwable2; 
        throw new AssertionError(throwable2);
      } 
      throw (RuntimeException)throwable2;
    } 
    throw (IOException)throwable2;
  }
  
  public static void closeQuietly(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
      } catch (RuntimeException runtimeException) {
        throw runtimeException;
      } catch (Exception exception) {} 
  }
  
  public static void closeQuietly(ServerSocket paramServerSocket) {
    if (paramServerSocket != null)
      try {
        paramServerSocket.close();
      } catch (RuntimeException runtimeException) {
        throw runtimeException;
      } catch (Exception exception) {} 
  }
  
  public static void closeQuietly(Socket paramSocket) {
    if (paramSocket != null)
      try {
        paramSocket.close();
      } catch (AssertionError assertionError) {
        if (!isAndroidGetsocknameError(assertionError))
          throw assertionError; 
      } catch (RuntimeException runtimeException) {
        throw runtimeException;
      } catch (Exception exception) {} 
  }
  
  public static String[] concat(String[] paramArrayOfString, String paramString) {
    String[] arrayOfString = new String[paramArrayOfString.length + 1];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramArrayOfString.length);
    arrayOfString[arrayOfString.length - 1] = paramString;
    return arrayOfString;
  }
  
  public static boolean contains(String[] paramArrayOfString, String paramString) {
    return Arrays.<String>asList(paramArrayOfString).contains(paramString);
  }
  
  public static boolean discard(Source paramSource, int paramInt, TimeUnit paramTimeUnit) {
    try {
      return skipAll(paramSource, paramInt, paramTimeUnit);
    } catch (IOException iOException) {
      return false;
    } 
  }
  
  public static boolean equal(Object paramObject1, Object paramObject2) {
    return (paramObject1 == paramObject2 || (paramObject1 != null && paramObject1.equals(paramObject2)));
  }
  
  public static String hostHeader(HttpUrl paramHttpUrl) {
    String str;
    if (paramHttpUrl.port() != HttpUrl.defaultPort(paramHttpUrl.scheme())) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramHttpUrl.host());
      stringBuilder.append(":");
      stringBuilder.append(paramHttpUrl.port());
      str = stringBuilder.toString();
    } else {
      str = str.host();
    } 
    return str;
  }
  
  public static <T> List<T> immutableList(List<T> paramList) {
    return Collections.unmodifiableList(new ArrayList<T>(paramList));
  }
  
  public static <T> List<T> immutableList(T... paramVarArgs) {
    return Collections.unmodifiableList(Arrays.asList((T[])paramVarArgs.clone()));
  }
  
  public static <K, V> Map<K, V> immutableMap(Map<K, V> paramMap) {
    return Collections.unmodifiableMap(new LinkedHashMap<K, V>(paramMap));
  }
  
  private static <T> List<T> intersect(T[] paramArrayOfT1, T[] paramArrayOfT2) {
    ArrayList<T> arrayList = new ArrayList();
    int i = paramArrayOfT1.length;
    for (byte b = 0; b < i; b++) {
      T t = paramArrayOfT1[b];
      int j = paramArrayOfT2.length;
      for (byte b1 = 0; b1 < j; b1++) {
        T t1 = paramArrayOfT2[b1];
        if (t.equals(t1)) {
          arrayList.add(t1);
          break;
        } 
      } 
    } 
    return arrayList;
  }
  
  public static <T> T[] intersect(Class<T> paramClass, T[] paramArrayOfT1, T[] paramArrayOfT2) {
    List<T> list = intersect(paramArrayOfT1, paramArrayOfT2);
    return list.toArray((T[])Array.newInstance(paramClass, list.size()));
  }
  
  public static boolean isAndroidGetsocknameError(AssertionError paramAssertionError) {
    boolean bool;
    if (paramAssertionError.getCause() != null && paramAssertionError.getMessage() != null && paramAssertionError.getMessage().contains("getsockname failed")) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static String md5Hex(String paramString) {
    try {
      return ByteString.of(MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8"))).hex();
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
    
    } catch (UnsupportedEncodingException unsupportedEncodingException) {}
    throw new AssertionError(unsupportedEncodingException);
  }
  
  public static ByteString sha1(ByteString paramByteString) {
    try {
      return ByteString.of(MessageDigest.getInstance("SHA-1").digest(paramByteString.toByteArray()));
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new AssertionError(noSuchAlgorithmException);
    } 
  }
  
  public static String shaBase64(String paramString) {
    try {
      return ByteString.of(MessageDigest.getInstance("SHA-1").digest(paramString.getBytes("UTF-8"))).base64();
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
    
    } catch (UnsupportedEncodingException unsupportedEncodingException) {}
    throw new AssertionError(unsupportedEncodingException);
  }
  
  public static boolean skipAll(Source paramSource, int paramInt, TimeUnit paramTimeUnit) throws IOException {
    long l2;
    long l1 = System.nanoTime();
    if (paramSource.timeout().hasDeadline()) {
      l2 = paramSource.timeout().deadlineNanoTime() - l1;
    } else {
      l2 = Long.MAX_VALUE;
    } 
    paramSource.timeout().deadlineNanoTime(Math.min(l2, paramTimeUnit.toNanos(paramInt)) + l1);
    try {
      Buffer buffer = new Buffer();
      this();
      while (paramSource.read(buffer, 2048L) != -1L)
        buffer.clear(); 
      return true;
    } catch (InterruptedIOException interruptedIOException) {
      return false;
    } finally {
      if (l2 == Long.MAX_VALUE) {
        paramSource.timeout().clearDeadline();
      } else {
        paramSource.timeout().deadlineNanoTime(l1 + l2);
      } 
    } 
  }
  
  public static ThreadFactory threadFactory(final String name, final boolean daemon) {
    return new ThreadFactory() {
        public Thread newThread(Runnable param1Runnable) {
          param1Runnable = new Thread(param1Runnable, name);
          param1Runnable.setDaemon(daemon);
          return (Thread)param1Runnable;
        }
      };
  }
  
  public static String toHumanReadableAscii(String paramString) {
    int i = paramString.length();
    int j = 0;
    while (j < i) {
      int k = paramString.codePointAt(j);
      if (k > 31 && k < 127) {
        j += Character.charCount(k);
        continue;
      } 
      Buffer buffer = new Buffer();
      buffer.writeUtf8(paramString, 0, j);
      while (j < i) {
        int m = paramString.codePointAt(j);
        if (m > 31 && m < 127) {
          k = m;
        } else {
          k = 63;
        } 
        buffer.writeUtf8CodePoint(k);
        j += Character.charCount(m);
      } 
      return buffer.readUtf8();
    } 
    return paramString;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\okhttp\internal\Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */