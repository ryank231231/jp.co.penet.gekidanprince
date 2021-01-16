package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@Beta
public final class ClassPath {
  private static final String CLASS_FILE_NAME_EXTENSION = ".class";
  
  private static final Splitter CLASS_PATH_ATTRIBUTE_SEPARATOR;
  
  private static final Predicate<ClassInfo> IS_TOP_LEVEL;
  
  private static final Logger logger = Logger.getLogger(ClassPath.class.getName());
  
  private final ImmutableSet<ResourceInfo> resources;
  
  static {
    IS_TOP_LEVEL = new Predicate<ClassInfo>() {
        public boolean apply(ClassPath.ClassInfo param1ClassInfo) {
          boolean bool;
          if (param1ClassInfo.className.indexOf('$') == -1) {
            bool = true;
          } else {
            bool = false;
          } 
          return bool;
        }
      };
    CLASS_PATH_ATTRIBUTE_SEPARATOR = Splitter.on(" ").omitEmptyStrings();
  }
  
  private ClassPath(ImmutableSet<ResourceInfo> paramImmutableSet) {
    this.resources = paramImmutableSet;
  }
  
  public static ClassPath from(ClassLoader paramClassLoader) throws IOException {
    DefaultScanner defaultScanner = new DefaultScanner();
    defaultScanner.scan(paramClassLoader);
    return new ClassPath(defaultScanner.getResources());
  }
  
  @VisibleForTesting
  static String getClassName(String paramString) {
    return paramString.substring(0, paramString.length() - 6).replace('/', '.');
  }
  
  public ImmutableSet<ClassInfo> getAllClasses() {
    return FluentIterable.from((Iterable)this.resources).filter(ClassInfo.class).toSet();
  }
  
  public ImmutableSet<ResourceInfo> getResources() {
    return this.resources;
  }
  
  public ImmutableSet<ClassInfo> getTopLevelClasses() {
    return FluentIterable.from((Iterable)this.resources).filter(ClassInfo.class).filter(IS_TOP_LEVEL).toSet();
  }
  
  public ImmutableSet<ClassInfo> getTopLevelClasses(String paramString) {
    Preconditions.checkNotNull(paramString);
    ImmutableSet.Builder builder = ImmutableSet.builder();
    for (ClassInfo classInfo : getTopLevelClasses()) {
      if (classInfo.getPackageName().equals(paramString))
        builder.add(classInfo); 
    } 
    return builder.build();
  }
  
  public ImmutableSet<ClassInfo> getTopLevelClassesRecursive(String paramString) {
    Preconditions.checkNotNull(paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append('.');
    String str = stringBuilder.toString();
    ImmutableSet.Builder builder = ImmutableSet.builder();
    for (ClassInfo classInfo : getTopLevelClasses()) {
      if (classInfo.getName().startsWith(str))
        builder.add(classInfo); 
    } 
    return builder.build();
  }
  
  @Beta
  public static final class ClassInfo extends ResourceInfo {
    private final String className;
    
    ClassInfo(String param1String, ClassLoader param1ClassLoader) {
      super(param1String, param1ClassLoader);
      this.className = ClassPath.getClassName(param1String);
    }
    
    public String getName() {
      return this.className;
    }
    
    public String getPackageName() {
      return Reflection.getPackageName(this.className);
    }
    
    public String getSimpleName() {
      int i = this.className.lastIndexOf('$');
      if (i != -1) {
        String str1 = this.className.substring(i + 1);
        return CharMatcher.digit().trimLeadingFrom(str1);
      } 
      String str = getPackageName();
      return str.isEmpty() ? this.className : this.className.substring(str.length() + 1);
    }
    
    public Class<?> load() {
      try {
        return this.loader.loadClass(this.className);
      } catch (ClassNotFoundException classNotFoundException) {
        throw new IllegalStateException(classNotFoundException);
      } 
    }
    
    public String toString() {
      return this.className;
    }
  }
  
  @VisibleForTesting
  static final class DefaultScanner extends Scanner {
    private final SetMultimap<ClassLoader, String> resources = MultimapBuilder.hashKeys().linkedHashSetValues().build();
    
    private void scanDirectory(File param1File, ClassLoader param1ClassLoader, String param1String) throws IOException {
      StringBuilder stringBuilder;
      Logger logger;
      File[] arrayOfFile = param1File.listFiles();
      if (arrayOfFile == null) {
        logger = ClassPath.logger;
        stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot read directory ");
        stringBuilder.append(param1File);
        logger.warning(stringBuilder.toString());
        return;
      } 
      int i = arrayOfFile.length;
      for (byte b = 0; b < i; b++) {
        File file = arrayOfFile[b];
        String str = file.getName();
        if (file.isDirectory()) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append((String)logger);
          stringBuilder1.append(str);
          stringBuilder1.append("/");
          scanDirectory(file, (ClassLoader)stringBuilder, stringBuilder1.toString());
        } else {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append((String)logger);
          stringBuilder1.append(str);
          str = stringBuilder1.toString();
          if (!str.equals("META-INF/MANIFEST.MF"))
            this.resources.get(stringBuilder).add(str); 
        } 
      } 
    }
    
    ImmutableSet<ClassPath.ResourceInfo> getResources() {
      ImmutableSet.Builder builder = ImmutableSet.builder();
      for (Map.Entry entry : this.resources.entries())
        builder.add(ClassPath.ResourceInfo.of((String)entry.getValue(), (ClassLoader)entry.getKey())); 
      return builder.build();
    }
    
    protected void scanDirectory(ClassLoader param1ClassLoader, File param1File) throws IOException {
      scanDirectory(param1File, param1ClassLoader, "");
    }
    
    protected void scanJarFile(ClassLoader param1ClassLoader, JarFile param1JarFile) {
      Enumeration<JarEntry> enumeration = param1JarFile.entries();
      while (enumeration.hasMoreElements()) {
        JarEntry jarEntry = enumeration.nextElement();
        if (jarEntry.isDirectory() || jarEntry.getName().equals("META-INF/MANIFEST.MF"))
          continue; 
        this.resources.get(param1ClassLoader).add(jarEntry.getName());
      } 
    }
  }
  
  @Beta
  public static class ResourceInfo {
    final ClassLoader loader;
    
    private final String resourceName;
    
    ResourceInfo(String param1String, ClassLoader param1ClassLoader) {
      this.resourceName = (String)Preconditions.checkNotNull(param1String);
      this.loader = (ClassLoader)Preconditions.checkNotNull(param1ClassLoader);
    }
    
    static ResourceInfo of(String param1String, ClassLoader param1ClassLoader) {
      return param1String.endsWith(".class") ? new ClassPath.ClassInfo(param1String, param1ClassLoader) : new ResourceInfo(param1String, param1ClassLoader);
    }
    
    public final ByteSource asByteSource() {
      return Resources.asByteSource(url());
    }
    
    public final CharSource asCharSource(Charset param1Charset) {
      return Resources.asCharSource(url(), param1Charset);
    }
    
    public boolean equals(Object param1Object) {
      boolean bool = param1Object instanceof ResourceInfo;
      boolean bool1 = false;
      if (bool) {
        param1Object = param1Object;
        bool = bool1;
        if (this.resourceName.equals(((ResourceInfo)param1Object).resourceName)) {
          bool = bool1;
          if (this.loader == ((ResourceInfo)param1Object).loader)
            bool = true; 
        } 
        return bool;
      } 
      return false;
    }
    
    public final String getResourceName() {
      return this.resourceName;
    }
    
    public int hashCode() {
      return this.resourceName.hashCode();
    }
    
    public String toString() {
      return this.resourceName;
    }
    
    public final URL url() {
      URL uRL = this.loader.getResource(this.resourceName);
      if (uRL != null)
        return uRL; 
      throw new NoSuchElementException(this.resourceName);
    }
  }
  
  static abstract class Scanner {
    private final Set<File> scannedUris = Sets.newHashSet();
    
    @VisibleForTesting
    static ImmutableMap<File, ClassLoader> getClassPathEntries(ClassLoader param1ClassLoader) {
      LinkedHashMap<File, ClassLoader> linkedHashMap = Maps.newLinkedHashMap();
      ClassLoader classLoader = param1ClassLoader.getParent();
      if (classLoader != null)
        linkedHashMap.putAll((Map<? extends File, ? extends ClassLoader>)getClassPathEntries(classLoader)); 
      if (param1ClassLoader instanceof URLClassLoader)
        for (URL uRL : ((URLClassLoader)param1ClassLoader).getURLs()) {
          if (uRL.getProtocol().equals("file")) {
            File file = new File(uRL.getFile());
            if (!linkedHashMap.containsKey(file))
              linkedHashMap.put(file, param1ClassLoader); 
          } 
        }  
      return ImmutableMap.copyOf(linkedHashMap);
    }
    
    @VisibleForTesting
    static URL getClassPathEntry(File param1File, String param1String) throws MalformedURLException {
      return new URL(param1File.toURI().toURL(), param1String);
    }
    
    @VisibleForTesting
    static ImmutableSet<File> getClassPathFromManifest(File param1File, @Nullable Manifest param1Manifest) {
      if (param1Manifest == null)
        return ImmutableSet.of(); 
      ImmutableSet.Builder builder = ImmutableSet.builder();
      String str = param1Manifest.getMainAttributes().getValue(Attributes.Name.CLASS_PATH.toString());
      if (str != null)
        for (String str1 : ClassPath.CLASS_PATH_ATTRIBUTE_SEPARATOR.split(str)) {
          try {
            URL uRL = getClassPathEntry(param1File, str1);
            if (uRL.getProtocol().equals("file"))
              builder.add(new File(uRL.getFile())); 
          } catch (MalformedURLException malformedURLException) {
            Logger logger = ClassPath.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid Class-Path entry: ");
            stringBuilder.append(str1);
            logger.warning(stringBuilder.toString());
          } 
        }  
      return builder.build();
    }
    
    private void scanFrom(File param1File, ClassLoader param1ClassLoader) throws IOException {
      try {
        boolean bool = param1File.exists();
        if (!bool)
          return; 
        if (param1File.isDirectory()) {
          scanDirectory(param1ClassLoader, param1File);
        } else {
          scanJar(param1File, param1ClassLoader);
        } 
        return;
      } catch (SecurityException securityException) {
        Logger logger = ClassPath.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot access ");
        stringBuilder.append(param1File);
        stringBuilder.append(": ");
        stringBuilder.append(securityException);
        logger.warning(stringBuilder.toString());
        return;
      } 
    }
    
    private void scanJar(File param1File, ClassLoader param1ClassLoader) throws IOException {
      try {
        JarFile jarFile = new JarFile(param1File);
        try {
          Iterator<File> iterator = getClassPathFromManifest(param1File, jarFile.getManifest()).iterator();
          while (iterator.hasNext())
            scan(iterator.next(), param1ClassLoader); 
          scanJarFile(param1ClassLoader, jarFile);
        } finally {
          try {
            jarFile.close();
          } catch (IOException iOException) {}
        } 
      } catch (IOException iOException) {
        return;
      } 
    }
    
    @VisibleForTesting
    final void scan(File param1File, ClassLoader param1ClassLoader) throws IOException {
      if (this.scannedUris.add(param1File.getCanonicalFile()))
        scanFrom(param1File, param1ClassLoader); 
    }
    
    public final void scan(ClassLoader param1ClassLoader) throws IOException {
      for (Map.Entry entry : getClassPathEntries(param1ClassLoader).entrySet())
        scan((File)entry.getKey(), (ClassLoader)entry.getValue()); 
    }
    
    protected abstract void scanDirectory(ClassLoader param1ClassLoader, File param1File) throws IOException;
    
    protected abstract void scanJarFile(ClassLoader param1ClassLoader, JarFile param1JarFile) throws IOException;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\reflect\ClassPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */