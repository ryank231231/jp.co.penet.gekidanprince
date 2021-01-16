package io.opencensus.trace;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
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
  
  public static final Status DATA_LOSS;
  
  public static final Status DEADLINE_EXCEEDED;
  
  public static final Status FAILED_PRECONDITION;
  
  public static final Status INTERNAL;
  
  public static final Status INVALID_ARGUMENT;
  
  public static final Status NOT_FOUND;
  
  public static final Status OK;
  
  public static final Status OUT_OF_RANGE;
  
  public static final Status PERMISSION_DENIED;
  
  public static final Status RESOURCE_EXHAUSTED;
  
  private static final List<Status> STATUS_LIST = buildStatusList();
  
  public static final Status UNAUTHENTICATED;
  
  public static final Status UNAVAILABLE;
  
  public static final Status UNIMPLEMENTED;
  
  public static final Status UNKNOWN;
  
  private final CanonicalCode canonicalCode;
  
  @Nullable
  private final String description;
  
  static {
    OK = CanonicalCode.OK.toStatus();
    CANCELLED = CanonicalCode.CANCELLED.toStatus();
    UNKNOWN = CanonicalCode.UNKNOWN.toStatus();
    INVALID_ARGUMENT = CanonicalCode.INVALID_ARGUMENT.toStatus();
    DEADLINE_EXCEEDED = CanonicalCode.DEADLINE_EXCEEDED.toStatus();
    NOT_FOUND = CanonicalCode.NOT_FOUND.toStatus();
    ALREADY_EXISTS = CanonicalCode.ALREADY_EXISTS.toStatus();
    PERMISSION_DENIED = CanonicalCode.PERMISSION_DENIED.toStatus();
    UNAUTHENTICATED = CanonicalCode.UNAUTHENTICATED.toStatus();
    RESOURCE_EXHAUSTED = CanonicalCode.RESOURCE_EXHAUSTED.toStatus();
    FAILED_PRECONDITION = CanonicalCode.FAILED_PRECONDITION.toStatus();
    ABORTED = CanonicalCode.ABORTED.toStatus();
    OUT_OF_RANGE = CanonicalCode.OUT_OF_RANGE.toStatus();
    UNIMPLEMENTED = CanonicalCode.UNIMPLEMENTED.toStatus();
    INTERNAL = CanonicalCode.INTERNAL.toStatus();
    UNAVAILABLE = CanonicalCode.UNAVAILABLE.toStatus();
    DATA_LOSS = CanonicalCode.DATA_LOSS.toStatus();
  }
  
  private Status(CanonicalCode paramCanonicalCode, @Nullable String paramString) {
    this.canonicalCode = (CanonicalCode)Preconditions.checkNotNull(paramCanonicalCode, "canonicalCode");
    this.description = paramString;
  }
  
  private static List<Status> buildStatusList() {
    TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
    CanonicalCode[] arrayOfCanonicalCode = CanonicalCode.values();
    int i = arrayOfCanonicalCode.length;
    byte b = 0;
    while (b < i) {
      CanonicalCode canonicalCode = arrayOfCanonicalCode[b];
      Status status = (Status)treeMap.put(Integer.valueOf(canonicalCode.value()), new Status(canonicalCode, null));
      if (status == null) {
        b++;
        continue;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Code value duplication between ");
      stringBuilder.append(status.getCanonicalCode().name());
      stringBuilder.append(" & ");
      stringBuilder.append(canonicalCode.name());
      throw new IllegalStateException(stringBuilder.toString());
    } 
    return Collections.unmodifiableList(new ArrayList<Status>(treeMap.values()));
  }
  
  public boolean equals(@Nullable Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Status))
      return false; 
    paramObject = paramObject;
    if (this.canonicalCode != ((Status)paramObject).canonicalCode || !Objects.equal(this.description, ((Status)paramObject).description))
      bool = false; 
    return bool;
  }
  
  public CanonicalCode getCanonicalCode() {
    return this.canonicalCode;
  }
  
  @Nullable
  public String getDescription() {
    return this.description;
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { this.canonicalCode, this.description });
  }
  
  public boolean isOk() {
    boolean bool;
    if (CanonicalCode.OK == this.canonicalCode) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public String toString() {
    return MoreObjects.toStringHelper(this).add("canonicalCode", this.canonicalCode).add("description", this.description).toString();
  }
  
  public Status withDescription(String paramString) {
    return Objects.equal(this.description, paramString) ? this : new Status(this.canonicalCode, paramString);
  }
  
  public enum CanonicalCode {
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
    
    static {
      INVALID_ARGUMENT = new CanonicalCode("INVALID_ARGUMENT", 3, 3);
      DEADLINE_EXCEEDED = new CanonicalCode("DEADLINE_EXCEEDED", 4, 4);
      NOT_FOUND = new CanonicalCode("NOT_FOUND", 5, 5);
      ALREADY_EXISTS = new CanonicalCode("ALREADY_EXISTS", 6, 6);
      PERMISSION_DENIED = new CanonicalCode("PERMISSION_DENIED", 7, 7);
      RESOURCE_EXHAUSTED = new CanonicalCode("RESOURCE_EXHAUSTED", 8, 8);
      FAILED_PRECONDITION = new CanonicalCode("FAILED_PRECONDITION", 9, 9);
      ABORTED = new CanonicalCode("ABORTED", 10, 10);
      OUT_OF_RANGE = new CanonicalCode("OUT_OF_RANGE", 11, 11);
      UNIMPLEMENTED = new CanonicalCode("UNIMPLEMENTED", 12, 12);
      INTERNAL = new CanonicalCode("INTERNAL", 13, 13);
      UNAVAILABLE = new CanonicalCode("UNAVAILABLE", 14, 14);
      DATA_LOSS = new CanonicalCode("DATA_LOSS", 15, 15);
      UNAUTHENTICATED = new CanonicalCode("UNAUTHENTICATED", 16, 16);
      $VALUES = new CanonicalCode[] { 
          OK, CANCELLED, UNKNOWN, INVALID_ARGUMENT, DEADLINE_EXCEEDED, NOT_FOUND, ALREADY_EXISTS, PERMISSION_DENIED, RESOURCE_EXHAUSTED, FAILED_PRECONDITION, 
          ABORTED, OUT_OF_RANGE, UNIMPLEMENTED, INTERNAL, UNAVAILABLE, DATA_LOSS, UNAUTHENTICATED };
    }
    
    CanonicalCode(int param1Int1) {
      this.value = param1Int1;
    }
    
    @VisibleForTesting
    public Status toStatus() {
      return Status.STATUS_LIST.get(this.value);
    }
    
    public int value() {
      return this.value;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */