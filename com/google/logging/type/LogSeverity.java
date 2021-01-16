package com.google.logging.type;

import com.google.protobuf.Internal;

public enum LogSeverity implements Internal.EnumLite {
  ALERT,
  CRITICAL,
  DEBUG,
  DEFAULT(0),
  EMERGENCY(0),
  ERROR(0),
  INFO(0),
  NOTICE(0),
  UNRECOGNIZED(0),
  WARNING(0);
  
  public static final int ALERT_VALUE = 700;
  
  public static final int CRITICAL_VALUE = 600;
  
  public static final int DEBUG_VALUE = 100;
  
  public static final int DEFAULT_VALUE = 0;
  
  public static final int EMERGENCY_VALUE = 800;
  
  public static final int ERROR_VALUE = 500;
  
  public static final int INFO_VALUE = 200;
  
  public static final int NOTICE_VALUE = 300;
  
  public static final int WARNING_VALUE = 400;
  
  private static final Internal.EnumLiteMap<LogSeverity> internalValueMap;
  
  private final int value;
  
  static {
    DEBUG = new LogSeverity("DEBUG", 1, 100);
    INFO = new LogSeverity("INFO", 2, 200);
    NOTICE = new LogSeverity("NOTICE", 3, 300);
    WARNING = new LogSeverity("WARNING", 4, 400);
    ERROR = new LogSeverity("ERROR", 5, 500);
    CRITICAL = new LogSeverity("CRITICAL", 6, 600);
    ALERT = new LogSeverity("ALERT", 7, 700);
    EMERGENCY = new LogSeverity("EMERGENCY", 8, 800);
    UNRECOGNIZED = new LogSeverity("UNRECOGNIZED", 9, -1);
    $VALUES = new LogSeverity[] { DEFAULT, DEBUG, INFO, NOTICE, WARNING, ERROR, CRITICAL, ALERT, EMERGENCY, UNRECOGNIZED };
    internalValueMap = new Internal.EnumLiteMap<LogSeverity>() {
        public LogSeverity findValueByNumber(int param1Int) {
          return LogSeverity.forNumber(param1Int);
        }
      };
  }
  
  LogSeverity(int paramInt1) {
    this.value = paramInt1;
  }
  
  public static LogSeverity forNumber(int paramInt) {
    return (paramInt != 0) ? ((paramInt != 100) ? ((paramInt != 200) ? ((paramInt != 300) ? ((paramInt != 400) ? ((paramInt != 500) ? ((paramInt != 600) ? ((paramInt != 700) ? ((paramInt != 800) ? null : EMERGENCY) : ALERT) : CRITICAL) : ERROR) : WARNING) : NOTICE) : INFO) : DEBUG) : DEFAULT;
  }
  
  public static Internal.EnumLiteMap<LogSeverity> internalGetValueMap() {
    return internalValueMap;
  }
  
  public final int getNumber() {
    return this.value;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\logging\type\LogSeverity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */