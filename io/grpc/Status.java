package io.grpc;

import com.google.common.base.Charsets;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public final class Status {
  public static final Status ABORTED;
  
  public static final Status ALREADY_EXISTS;
  
  public static final Status CANCELLED;
  
  static final Metadata.Key<Status> CODE_KEY;
  
  public static final Status DATA_LOSS;
  
  public static final Status DEADLINE_EXCEEDED;
  
  public static final Status FAILED_PRECONDITION;
  
  public static final Status INTERNAL;
  
  public static final Status INVALID_ARGUMENT;
  
  static final Metadata.Key<String> MESSAGE_KEY;
  
  public static final Status NOT_FOUND;
  
  public static final Status OK;
  
  public static final Status OUT_OF_RANGE;
  
  public static final Status PERMISSION_DENIED;
  
  public static final Status RESOURCE_EXHAUSTED;
  
  private static final List<Status> STATUS_LIST = buildStatusList();
  
  private static final Metadata.TrustedAsciiMarshaller<String> STATUS_MESSAGE_MARSHALLER;
  
  public static final Status UNAUTHENTICATED;
  
  public static final Status UNAVAILABLE;
  
  public static final Status UNIMPLEMENTED;
  
  public static final Status UNKNOWN;
  
  private final Throwable cause;
  
  private final Code code;
  
  private final String description;
  
  static {
    OK = Code.OK.toStatus();
    CANCELLED = Code.CANCELLED.toStatus();
    UNKNOWN = Code.UNKNOWN.toStatus();
    INVALID_ARGUMENT = Code.INVALID_ARGUMENT.toStatus();
    DEADLINE_EXCEEDED = Code.DEADLINE_EXCEEDED.toStatus();
    NOT_FOUND = Code.NOT_FOUND.toStatus();
    ALREADY_EXISTS = Code.ALREADY_EXISTS.toStatus();
    PERMISSION_DENIED = Code.PERMISSION_DENIED.toStatus();
    UNAUTHENTICATED = Code.UNAUTHENTICATED.toStatus();
    RESOURCE_EXHAUSTED = Code.RESOURCE_EXHAUSTED.toStatus();
    FAILED_PRECONDITION = Code.FAILED_PRECONDITION.toStatus();
    ABORTED = Code.ABORTED.toStatus();
    OUT_OF_RANGE = Code.OUT_OF_RANGE.toStatus();
    UNIMPLEMENTED = Code.UNIMPLEMENTED.toStatus();
    INTERNAL = Code.INTERNAL.toStatus();
    UNAVAILABLE = Code.UNAVAILABLE.toStatus();
    DATA_LOSS = Code.DATA_LOSS.toStatus();
    CODE_KEY = Metadata.Key.of("grpc-status", false, new StatusCodeMarshaller());
    STATUS_MESSAGE_MARSHALLER = new StatusMessageMarshaller();
    MESSAGE_KEY = Metadata.Key.of("grpc-message", false, STATUS_MESSAGE_MARSHALLER);
  }
  
  private Status(Code paramCode) {
    this(paramCode, null, null);
  }
  
  private Status(Code paramCode, @Nullable String paramString, @Nullable Throwable paramThrowable) {
    this.code = (Code)Preconditions.checkNotNull(paramCode, "code");
    this.description = paramString;
    this.cause = paramThrowable;
  }
  
  private static List<Status> buildStatusList() {
    TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
    Code[] arrayOfCode = Code.values();
    int i = arrayOfCode.length;
    byte b = 0;
    while (b < i) {
      Code code = arrayOfCode[b];
      Status status = (Status)treeMap.put(Integer.valueOf(code.value()), new Status(code));
      if (status == null) {
        b++;
        continue;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Code value duplication between ");
      stringBuilder.append(status.getCode().name());
      stringBuilder.append(" & ");
      stringBuilder.append(code.name());
      throw new IllegalStateException(stringBuilder.toString());
    } 
    return Collections.unmodifiableList(new ArrayList<Status>(treeMap.values()));
  }
  
  static String formatThrowableMessage(Status paramStatus) {
    if (paramStatus.description == null)
      return paramStatus.code.toString(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramStatus.code);
    stringBuilder.append(": ");
    stringBuilder.append(paramStatus.description);
    return stringBuilder.toString();
  }
  
  public static Status fromCode(Code paramCode) {
    return paramCode.toStatus();
  }
  
  public static Status fromCodeValue(int paramInt) {
    if (paramInt < 0 || paramInt > STATUS_LIST.size()) {
      Status status = UNKNOWN;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unknown code ");
      stringBuilder.append(paramInt);
      return status.withDescription(stringBuilder.toString());
    } 
    return STATUS_LIST.get(paramInt);
  }
  
  private static Status fromCodeValue(byte[] paramArrayOfbyte) {
    return (paramArrayOfbyte.length == 1 && paramArrayOfbyte[0] == 48) ? OK : fromCodeValueSlow(paramArrayOfbyte);
  }
  
  private static Status fromCodeValueSlow(byte[] paramArrayOfbyte) {
    Status status;
    StringBuilder stringBuilder;
    int i = paramArrayOfbyte.length;
    int j = 0;
    switch (i) {
      default:
        status = UNKNOWN;
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown code ");
        stringBuilder.append(new String(paramArrayOfbyte, Charsets.US_ASCII));
        return status.withDescription(stringBuilder.toString());
      case 2:
        if (paramArrayOfbyte[0] >= 48 && paramArrayOfbyte[0] <= 57) {
          i = 1;
          j = 0 + (paramArrayOfbyte[0] - 48) * 10;
          break;
        } 
      case 1:
        i = 0;
        break;
    } 
    if (paramArrayOfbyte[i] < 48 || paramArrayOfbyte[i] > 57);
    i = j + paramArrayOfbyte[i] - 48;
    if (i < STATUS_LIST.size())
      return STATUS_LIST.get(i); 
  }
  
  public static Status fromThrowable(Throwable paramThrowable) {
    for (Throwable throwable = (Throwable)Preconditions.checkNotNull(paramThrowable, "t"); throwable != null; throwable = throwable.getCause()) {
      if (throwable instanceof StatusException)
        return ((StatusException)throwable).getStatus(); 
      if (throwable instanceof StatusRuntimeException)
        return ((StatusRuntimeException)throwable).getStatus(); 
    } 
    return UNKNOWN.withCause(paramThrowable);
  }
  
  @ExperimentalApi
  public static Metadata trailersFromThrowable(Throwable paramThrowable) {
    for (paramThrowable = (Throwable)Preconditions.checkNotNull(paramThrowable, "t"); paramThrowable != null; paramThrowable = paramThrowable.getCause()) {
      if (paramThrowable instanceof StatusException)
        return ((StatusException)paramThrowable).getTrailers(); 
      if (paramThrowable instanceof StatusRuntimeException)
        return ((StatusRuntimeException)paramThrowable).getTrailers(); 
    } 
    return null;
  }
  
  public StatusException asException() {
    return new StatusException(this);
  }
  
  @ExperimentalApi
  public StatusException asException(Metadata paramMetadata) {
    return new StatusException(this, paramMetadata);
  }
  
  public StatusRuntimeException asRuntimeException() {
    return new StatusRuntimeException(this);
  }
  
  @ExperimentalApi
  public StatusRuntimeException asRuntimeException(Metadata paramMetadata) {
    return new StatusRuntimeException(this, paramMetadata);
  }
  
  public Status augmentDescription(String paramString) {
    if (paramString == null)
      return this; 
    if (this.description == null)
      return new Status(this.code, paramString, this.cause); 
    Code code = this.code;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.description);
    stringBuilder.append("\n");
    stringBuilder.append(paramString);
    return new Status(code, stringBuilder.toString(), this.cause);
  }
  
  public boolean equals(Object paramObject) {
    return super.equals(paramObject);
  }
  
  @Nullable
  public Throwable getCause() {
    return this.cause;
  }
  
  public Code getCode() {
    return this.code;
  }
  
  @Nullable
  public String getDescription() {
    return this.description;
  }
  
  public int hashCode() {
    return super.hashCode();
  }
  
  public boolean isOk() {
    boolean bool;
    if (Code.OK == this.code) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public String toString() {
    String str;
    MoreObjects.ToStringHelper toStringHelper = MoreObjects.toStringHelper(this).add("code", this.code.name()).add("description", this.description);
    Throwable throwable1 = this.cause;
    Throwable throwable2 = throwable1;
    if (throwable1 != null)
      str = Throwables.getStackTraceAsString(throwable1); 
    return toStringHelper.add("cause", str).toString();
  }
  
  public Status withCause(Throwable paramThrowable) {
    return Objects.equal(this.cause, paramThrowable) ? this : new Status(this.code, this.description, paramThrowable);
  }
  
  public Status withDescription(String paramString) {
    return Objects.equal(this.description, paramString) ? this : new Status(this.code, paramString, this.cause);
  }
  
  public enum Code {
    ABORTED,
    ALREADY_EXISTS,
    CANCELLED,
    DATA_LOSS,
    DEADLINE_EXCEEDED,
    FAILED_PRECONDITION,
    INTERNAL,
    INVALID_ARGUMENT,
    NOT_FOUND,
    OK(0),
    OUT_OF_RANGE(0),
    PERMISSION_DENIED(0),
    RESOURCE_EXHAUSTED(0),
    UNAUTHENTICATED(0),
    UNAVAILABLE(0),
    UNIMPLEMENTED(0),
    UNKNOWN(0);
    
    private final int value;
    
    private final byte[] valueAscii;
    
    static {
      INVALID_ARGUMENT = new Code("INVALID_ARGUMENT", 3, 3);
      DEADLINE_EXCEEDED = new Code("DEADLINE_EXCEEDED", 4, 4);
      NOT_FOUND = new Code("NOT_FOUND", 5, 5);
      ALREADY_EXISTS = new Code("ALREADY_EXISTS", 6, 6);
      PERMISSION_DENIED = new Code("PERMISSION_DENIED", 7, 7);
      RESOURCE_EXHAUSTED = new Code("RESOURCE_EXHAUSTED", 8, 8);
      FAILED_PRECONDITION = new Code("FAILED_PRECONDITION", 9, 9);
      ABORTED = new Code("ABORTED", 10, 10);
      OUT_OF_RANGE = new Code("OUT_OF_RANGE", 11, 11);
      UNIMPLEMENTED = new Code("UNIMPLEMENTED", 12, 12);
      INTERNAL = new Code("INTERNAL", 13, 13);
      UNAVAILABLE = new Code("UNAVAILABLE", 14, 14);
      DATA_LOSS = new Code("DATA_LOSS", 15, 15);
      UNAUTHENTICATED = new Code("UNAUTHENTICATED", 16, 16);
      $VALUES = new Code[] { 
          OK, CANCELLED, UNKNOWN, INVALID_ARGUMENT, DEADLINE_EXCEEDED, NOT_FOUND, ALREADY_EXISTS, PERMISSION_DENIED, RESOURCE_EXHAUSTED, FAILED_PRECONDITION, 
          ABORTED, OUT_OF_RANGE, UNIMPLEMENTED, INTERNAL, UNAVAILABLE, DATA_LOSS, UNAUTHENTICATED };
    }
    
    Code(int param1Int1) {
      this.value = param1Int1;
      this.valueAscii = Integer.toString(param1Int1).getBytes(Charsets.US_ASCII);
    }
    
    private byte[] valueAscii() {
      return this.valueAscii;
    }
    
    public Status toStatus() {
      return Status.STATUS_LIST.get(this.value);
    }
    
    public int value() {
      return this.value;
    }
  }
  
  private static final class StatusCodeMarshaller implements Metadata.TrustedAsciiMarshaller<Status> {
    private StatusCodeMarshaller() {}
    
    public Status parseAsciiString(byte[] param1ArrayOfbyte) {
      return Status.fromCodeValue(param1ArrayOfbyte);
    }
    
    public byte[] toAsciiString(Status param1Status) {
      return param1Status.getCode().valueAscii();
    }
  }
  
  private static final class StatusMessageMarshaller implements Metadata.TrustedAsciiMarshaller<String> {
    private static final byte[] HEX = new byte[] { 
        48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 
        65, 66, 67, 68, 69, 70 };
    
    private StatusMessageMarshaller() {}
    
    private static boolean isEscapingChar(byte param1Byte) {
      return (param1Byte < 32 || param1Byte >= 126 || param1Byte == 37);
    }
    
    private static String parseAsciiStringSlow(byte[] param1ArrayOfbyte) {
      ByteBuffer byteBuffer = ByteBuffer.allocate(param1ArrayOfbyte.length);
      byte b = 0;
      while (true) {
        if (b < param1ArrayOfbyte.length) {
          if (param1ArrayOfbyte[b] == 37 && b + 2 < param1ArrayOfbyte.length)
            try {
              String str = new String();
              this(param1ArrayOfbyte, b + 1, 2, Charsets.US_ASCII);
              byteBuffer.put((byte)Integer.parseInt(str, 16));
              b += 3;
              continue;
            } catch (NumberFormatException numberFormatException) {} 
          byteBuffer.put(param1ArrayOfbyte[b]);
          b++;
          continue;
        } 
        return new String(byteBuffer.array(), 0, byteBuffer.position(), Charsets.UTF_8);
      } 
    }
    
    private static byte[] toAsciiStringSlow(byte[] param1ArrayOfbyte, int param1Int) {
      byte[] arrayOfByte = new byte[(param1ArrayOfbyte.length - param1Int) * 3 + param1Int];
      if (param1Int != 0)
        System.arraycopy(param1ArrayOfbyte, 0, arrayOfByte, 0, param1Int); 
      int i = param1Int;
      int j = param1Int;
      param1Int = i;
      while (j < param1ArrayOfbyte.length) {
        byte b = param1ArrayOfbyte[j];
        if (isEscapingChar(b)) {
          arrayOfByte[param1Int] = (byte)37;
          byte[] arrayOfByte1 = HEX;
          arrayOfByte[param1Int + 1] = (byte)arrayOfByte1[b >> 4 & 0xF];
          arrayOfByte[param1Int + 2] = (byte)arrayOfByte1[b & 0xF];
          param1Int += 3;
        } else {
          arrayOfByte[param1Int] = b;
          param1Int++;
        } 
        j++;
      } 
      param1ArrayOfbyte = new byte[param1Int];
      System.arraycopy(arrayOfByte, 0, param1ArrayOfbyte, 0, param1Int);
      return param1ArrayOfbyte;
    }
    
    public String parseAsciiString(byte[] param1ArrayOfbyte) {
      for (byte b = 0; b < param1ArrayOfbyte.length; b++) {
        byte b1 = param1ArrayOfbyte[b];
        if (b1 < 32 || b1 >= 126 || (b1 == 37 && b + 2 < param1ArrayOfbyte.length))
          return parseAsciiStringSlow(param1ArrayOfbyte); 
      } 
      return new String(param1ArrayOfbyte, 0);
    }
    
    public byte[] toAsciiString(String param1String) {
      byte[] arrayOfByte = param1String.getBytes(Charsets.UTF_8);
      for (byte b = 0; b < arrayOfByte.length; b++) {
        if (isEscapingChar(arrayOfByte[b]))
          return toAsciiStringSlow(arrayOfByte, b); 
      } 
      return arrayOfByte;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */