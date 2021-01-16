package io.grpc;

import com.google.common.base.Preconditions;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
public final class EquivalentAddressGroup {
  private final List<SocketAddress> addrs;
  
  private final Attributes attrs;
  
  private final int hashCode;
  
  public EquivalentAddressGroup(SocketAddress paramSocketAddress) {
    this(paramSocketAddress, Attributes.EMPTY);
  }
  
  public EquivalentAddressGroup(SocketAddress paramSocketAddress, Attributes paramAttributes) {
    this(Collections.singletonList(paramSocketAddress), paramAttributes);
  }
  
  public EquivalentAddressGroup(List<SocketAddress> paramList) {
    this(paramList, Attributes.EMPTY);
  }
  
  public EquivalentAddressGroup(List<SocketAddress> paramList, Attributes paramAttributes) {
    Preconditions.checkArgument(paramList.isEmpty() ^ true, "addrs is empty");
    this.addrs = Collections.unmodifiableList(new ArrayList<SocketAddress>(paramList));
    this.attrs = (Attributes)Preconditions.checkNotNull(paramAttributes, "attrs");
    this.hashCode = this.addrs.hashCode();
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof EquivalentAddressGroup))
      return false; 
    paramObject = paramObject;
    if (this.addrs.size() != ((EquivalentAddressGroup)paramObject).addrs.size())
      return false; 
    for (byte b = 0; b < this.addrs.size(); b++) {
      if (!((SocketAddress)this.addrs.get(b)).equals(((EquivalentAddressGroup)paramObject).addrs.get(b)))
        return false; 
    } 
    return !!this.attrs.equals(((EquivalentAddressGroup)paramObject).attrs);
  }
  
  public List<SocketAddress> getAddresses() {
    return this.addrs;
  }
  
  public Attributes getAttributes() {
    return this.attrs;
  }
  
  public int hashCode() {
    return this.hashCode;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[addrs=");
    stringBuilder.append(this.addrs);
    stringBuilder.append(", attrs=");
    stringBuilder.append(this.attrs);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\EquivalentAddressGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */