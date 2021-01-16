package io.grpc;

import com.google.common.base.Preconditions;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
public final class ConnectivityStateInfo {
  private final ConnectivityState state;
  
  private final Status status;
  
  private ConnectivityStateInfo(ConnectivityState paramConnectivityState, Status paramStatus) {
    this.state = (ConnectivityState)Preconditions.checkNotNull(paramConnectivityState, "state is null");
    this.status = (Status)Preconditions.checkNotNull(paramStatus, "status is null");
  }
  
  public static ConnectivityStateInfo forNonError(ConnectivityState paramConnectivityState) {
    boolean bool;
    if (paramConnectivityState != ConnectivityState.TRANSIENT_FAILURE) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "state is TRANSIENT_ERROR. Use forError() instead");
    return new ConnectivityStateInfo(paramConnectivityState, Status.OK);
  }
  
  public static ConnectivityStateInfo forTransientFailure(Status paramStatus) {
    Preconditions.checkArgument(paramStatus.isOk() ^ true, "The error status must not be OK");
    return new ConnectivityStateInfo(ConnectivityState.TRANSIENT_FAILURE, paramStatus);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof ConnectivityStateInfo;
    boolean bool1 = false;
    if (!bool)
      return false; 
    paramObject = paramObject;
    bool = bool1;
    if (this.state.equals(((ConnectivityStateInfo)paramObject).state)) {
      bool = bool1;
      if (this.status.equals(((ConnectivityStateInfo)paramObject).status))
        bool = true; 
    } 
    return bool;
  }
  
  public ConnectivityState getState() {
    return this.state;
  }
  
  public Status getStatus() {
    return this.status;
  }
  
  public int hashCode() {
    return this.state.hashCode() ^ this.status.hashCode();
  }
  
  public String toString() {
    if (this.status.isOk())
      return this.state.toString(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.state);
    stringBuilder.append("(");
    stringBuilder.append(this.status);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\ConnectivityStateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */