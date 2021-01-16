package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import javax.annotation.Nullable;

@GwtIncompatible
public enum StandardSystemProperty {
  FILE_SEPARATOR,
  JAVA_CLASS_PATH,
  JAVA_CLASS_VERSION,
  JAVA_COMPILER,
  JAVA_EXT_DIRS,
  JAVA_HOME,
  JAVA_IO_TMPDIR,
  JAVA_LIBRARY_PATH,
  JAVA_SPECIFICATION_NAME,
  JAVA_SPECIFICATION_VENDOR,
  JAVA_SPECIFICATION_VERSION,
  JAVA_VENDOR,
  JAVA_VENDOR_URL,
  JAVA_VERSION("java.version"),
  JAVA_VM_NAME("java.version"),
  JAVA_VM_SPECIFICATION_NAME("java.version"),
  JAVA_VM_SPECIFICATION_VENDOR("java.version"),
  JAVA_VM_SPECIFICATION_VERSION("java.version"),
  JAVA_VM_VENDOR("java.version"),
  JAVA_VM_VERSION("java.version"),
  LINE_SEPARATOR("java.version"),
  OS_ARCH("java.version"),
  OS_NAME("java.version"),
  OS_VERSION("java.version"),
  PATH_SEPARATOR("java.version"),
  USER_DIR("java.version"),
  USER_HOME("java.version"),
  USER_NAME("java.version");
  
  private final String key;
  
  static {
    JAVA_VENDOR = new StandardSystemProperty("JAVA_VENDOR", 1, "java.vendor");
    JAVA_VENDOR_URL = new StandardSystemProperty("JAVA_VENDOR_URL", 2, "java.vendor.url");
    JAVA_HOME = new StandardSystemProperty("JAVA_HOME", 3, "java.home");
    JAVA_VM_SPECIFICATION_VERSION = new StandardSystemProperty("JAVA_VM_SPECIFICATION_VERSION", 4, "java.vm.specification.version");
    JAVA_VM_SPECIFICATION_VENDOR = new StandardSystemProperty("JAVA_VM_SPECIFICATION_VENDOR", 5, "java.vm.specification.vendor");
    JAVA_VM_SPECIFICATION_NAME = new StandardSystemProperty("JAVA_VM_SPECIFICATION_NAME", 6, "java.vm.specification.name");
    JAVA_VM_VERSION = new StandardSystemProperty("JAVA_VM_VERSION", 7, "java.vm.version");
    JAVA_VM_VENDOR = new StandardSystemProperty("JAVA_VM_VENDOR", 8, "java.vm.vendor");
    JAVA_VM_NAME = new StandardSystemProperty("JAVA_VM_NAME", 9, "java.vm.name");
    JAVA_SPECIFICATION_VERSION = new StandardSystemProperty("JAVA_SPECIFICATION_VERSION", 10, "java.specification.version");
    JAVA_SPECIFICATION_VENDOR = new StandardSystemProperty("JAVA_SPECIFICATION_VENDOR", 11, "java.specification.vendor");
    JAVA_SPECIFICATION_NAME = new StandardSystemProperty("JAVA_SPECIFICATION_NAME", 12, "java.specification.name");
    JAVA_CLASS_VERSION = new StandardSystemProperty("JAVA_CLASS_VERSION", 13, "java.class.version");
    JAVA_CLASS_PATH = new StandardSystemProperty("JAVA_CLASS_PATH", 14, "java.class.path");
    JAVA_LIBRARY_PATH = new StandardSystemProperty("JAVA_LIBRARY_PATH", 15, "java.library.path");
    JAVA_IO_TMPDIR = new StandardSystemProperty("JAVA_IO_TMPDIR", 16, "java.io.tmpdir");
    JAVA_COMPILER = new StandardSystemProperty("JAVA_COMPILER", 17, "java.compiler");
    JAVA_EXT_DIRS = new StandardSystemProperty("JAVA_EXT_DIRS", 18, "java.ext.dirs");
    OS_NAME = new StandardSystemProperty("OS_NAME", 19, "os.name");
    OS_ARCH = new StandardSystemProperty("OS_ARCH", 20, "os.arch");
    OS_VERSION = new StandardSystemProperty("OS_VERSION", 21, "os.version");
    FILE_SEPARATOR = new StandardSystemProperty("FILE_SEPARATOR", 22, "file.separator");
    PATH_SEPARATOR = new StandardSystemProperty("PATH_SEPARATOR", 23, "path.separator");
    LINE_SEPARATOR = new StandardSystemProperty("LINE_SEPARATOR", 24, "line.separator");
    USER_NAME = new StandardSystemProperty("USER_NAME", 25, "user.name");
    USER_HOME = new StandardSystemProperty("USER_HOME", 26, "user.home");
    USER_DIR = new StandardSystemProperty("USER_DIR", 27, "user.dir");
    $VALUES = new StandardSystemProperty[] { 
        JAVA_VERSION, JAVA_VENDOR, JAVA_VENDOR_URL, JAVA_HOME, JAVA_VM_SPECIFICATION_VERSION, JAVA_VM_SPECIFICATION_VENDOR, JAVA_VM_SPECIFICATION_NAME, JAVA_VM_VERSION, JAVA_VM_VENDOR, JAVA_VM_NAME, 
        JAVA_SPECIFICATION_VERSION, JAVA_SPECIFICATION_VENDOR, JAVA_SPECIFICATION_NAME, JAVA_CLASS_VERSION, JAVA_CLASS_PATH, JAVA_LIBRARY_PATH, JAVA_IO_TMPDIR, JAVA_COMPILER, JAVA_EXT_DIRS, OS_NAME, 
        OS_ARCH, OS_VERSION, FILE_SEPARATOR, PATH_SEPARATOR, LINE_SEPARATOR, USER_NAME, USER_HOME, USER_DIR };
  }
  
  StandardSystemProperty(String paramString1) {
    this.key = paramString1;
  }
  
  public String key() {
    return this.key;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(key());
    stringBuilder.append("=");
    stringBuilder.append(value());
    return stringBuilder.toString();
  }
  
  @Nullable
  public String value() {
    return System.getProperty(this.key);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\StandardSystemProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */