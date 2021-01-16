package io.grpc;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
@ThreadSafe
public final class DecompressorRegistry {
  static final Joiner ACCEPT_ENCODING_JOINER = Joiner.on(',');
  
  private static final DecompressorRegistry DEFAULT_INSTANCE = emptyInstance().with(new Codec.Gzip(), true).with(Codec.Identity.NONE, false);
  
  private final byte[] advertisedDecompressors;
  
  private final Map<String, DecompressorInfo> decompressors;
  
  private DecompressorRegistry() {
    this.decompressors = new LinkedHashMap<String, DecompressorInfo>(0);
    this.advertisedDecompressors = new byte[0];
  }
  
  private DecompressorRegistry(Decompressor paramDecompressor, boolean paramBoolean, DecompressorRegistry paramDecompressorRegistry) {
    String str = paramDecompressor.getMessageEncoding();
    Preconditions.checkArgument(str.contains(",") ^ true, "Comma is currently not allowed in message encoding");
    int i = paramDecompressorRegistry.decompressors.size();
    int j = i;
    if (!paramDecompressorRegistry.decompressors.containsKey(paramDecompressor.getMessageEncoding()))
      j = i + 1; 
    LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(j);
    for (DecompressorInfo decompressorInfo : paramDecompressorRegistry.decompressors.values()) {
      String str1 = decompressorInfo.decompressor.getMessageEncoding();
      if (!str1.equals(str))
        linkedHashMap.put(str1, new DecompressorInfo(decompressorInfo.decompressor, decompressorInfo.advertised)); 
    } 
    linkedHashMap.put(str, new DecompressorInfo(paramDecompressor, paramBoolean));
    this.decompressors = Collections.unmodifiableMap(linkedHashMap);
    this.advertisedDecompressors = ACCEPT_ENCODING_JOINER.join(getAdvertisedMessageEncodings()).getBytes(Charset.forName("US-ASCII"));
  }
  
  public static DecompressorRegistry emptyInstance() {
    return new DecompressorRegistry();
  }
  
  public static DecompressorRegistry getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
  public Set<String> getAdvertisedMessageEncodings() {
    HashSet<? extends String> hashSet = new HashSet(this.decompressors.size());
    for (Map.Entry<String, DecompressorInfo> entry : this.decompressors.entrySet()) {
      if (((DecompressorInfo)entry.getValue()).advertised)
        hashSet.add(entry.getKey()); 
    } 
    return Collections.unmodifiableSet(hashSet);
  }
  
  public Set<String> getKnownMessageEncodings() {
    return this.decompressors.keySet();
  }
  
  byte[] getRawAdvertisedMessageEncodings() {
    return this.advertisedDecompressors;
  }
  
  @Nullable
  public Decompressor lookupDecompressor(String paramString) {
    DecompressorInfo decompressorInfo = this.decompressors.get(paramString);
    if (decompressorInfo != null) {
      Decompressor decompressor = decompressorInfo.decompressor;
    } else {
      decompressorInfo = null;
    } 
    return (Decompressor)decompressorInfo;
  }
  
  public DecompressorRegistry with(Decompressor paramDecompressor, boolean paramBoolean) {
    return new DecompressorRegistry(paramDecompressor, paramBoolean, this);
  }
  
  private static final class DecompressorInfo {
    final boolean advertised;
    
    final Decompressor decompressor;
    
    DecompressorInfo(Decompressor param1Decompressor, boolean param1Boolean) {
      this.decompressor = (Decompressor)Preconditions.checkNotNull(param1Decompressor, "decompressor");
      this.advertised = param1Boolean;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\DecompressorRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */