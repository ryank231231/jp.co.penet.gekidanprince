package io.grpc;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public final class Metadata {
  public static final AsciiMarshaller<String> ASCII_STRING_MARSHALLER;
  
  public static final BinaryMarshaller<byte[]> BINARY_BYTE_MARSHALLER = new BinaryMarshaller<byte[]>() {
      public byte[] parseBytes(byte[] param1ArrayOfbyte) {
        return param1ArrayOfbyte;
      }
      
      public byte[] toBytes(byte[] param1ArrayOfbyte) {
        return param1ArrayOfbyte;
      }
    };
  
  public static final String BINARY_HEADER_SUFFIX = "-bin";
  
  private byte[][] namesAndValues;
  
  private int size;
  
  static {
    ASCII_STRING_MARSHALLER = new AsciiMarshaller<String>() {
        public String parseAsciiString(String param1String) {
          return param1String;
        }
        
        public String toAsciiString(String param1String) {
          return param1String;
        }
      };
  }
  
  public Metadata() {}
  
  Metadata(int paramInt, byte[]... paramVarArgs) {
    this.size = paramInt;
    this.namesAndValues = paramVarArgs;
  }
  
  Metadata(byte[]... paramVarArgs) {
    this(paramVarArgs.length / 2, paramVarArgs);
  }
  
  private boolean bytesEqual(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    return Arrays.equals(paramArrayOfbyte1, paramArrayOfbyte2);
  }
  
  private int cap() {
    boolean bool;
    byte[][] arrayOfByte = this.namesAndValues;
    if (arrayOfByte != null) {
      bool = arrayOfByte.length;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private void expand(int paramInt) {
    byte[][] arrayOfByte = new byte[paramInt][];
    if (!isEmpty())
      System.arraycopy(this.namesAndValues, 0, arrayOfByte, 0, len()); 
    this.namesAndValues = arrayOfByte;
  }
  
  private boolean isEmpty() {
    boolean bool;
    if (this.size == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private int len() {
    return this.size * 2;
  }
  
  private void maybeExpand() {
    if (len() == 0 || len() == cap())
      expand(Math.max(len() * 2, 8)); 
  }
  
  private void name(int paramInt, byte[] paramArrayOfbyte) {
    this.namesAndValues[paramInt * 2] = paramArrayOfbyte;
  }
  
  private byte[] name(int paramInt) {
    return this.namesAndValues[paramInt * 2];
  }
  
  private void value(int paramInt, byte[] paramArrayOfbyte) {
    this.namesAndValues[paramInt * 2 + 1] = paramArrayOfbyte;
  }
  
  private byte[] value(int paramInt) {
    return this.namesAndValues[paramInt * 2 + 1];
  }
  
  public boolean containsKey(Key<?> paramKey) {
    for (byte b = 0; b < this.size; b++) {
      if (bytesEqual(paramKey.asciiName(), name(b)))
        return true; 
    } 
    return false;
  }
  
  @ExperimentalApi
  public <T> void discardAll(Key<T> paramKey) {
    if (isEmpty())
      return; 
    byte b1 = 0;
    byte b2 = 0;
    while (b1 < this.size) {
      if (!bytesEqual(paramKey.asciiName(), name(b1))) {
        name(b2, name(b1));
        value(b2, value(b1));
        b2++;
      } 
      b1++;
    } 
    Arrays.fill((Object[])this.namesAndValues, b2 * 2, len(), (Object)null);
    this.size = b2;
  }
  
  @Nullable
  public <T> T get(Key<T> paramKey) {
    for (int i = this.size - 1; i >= 0; i--) {
      if (bytesEqual(paramKey.asciiName(), name(i)))
        return paramKey.parseBytes(value(i)); 
    } 
    return null;
  }
  
  @Nullable
  public <T> Iterable<T> getAll(Key<T> paramKey) {
    for (byte b = 0; b < this.size; b++) {
      if (bytesEqual(paramKey.asciiName(), name(b)))
        return new IterableAt<T>(paramKey, b); 
    } 
    return null;
  }
  
  int headerCount() {
    return this.size;
  }
  
  public Set<String> keys() {
    if (isEmpty())
      return Collections.emptySet(); 
    HashSet<String> hashSet = new HashSet(this.size);
    for (byte b = 0; b < this.size; b++)
      hashSet.add(new String(name(b), 0)); 
    return Collections.unmodifiableSet(hashSet);
  }
  
  public void merge(Metadata paramMetadata) {
    if (paramMetadata.isEmpty())
      return; 
    int i = cap();
    int j = len();
    if (isEmpty() || i - j < paramMetadata.len())
      expand(len() + paramMetadata.len()); 
    System.arraycopy(paramMetadata.namesAndValues, 0, this.namesAndValues, len(), paramMetadata.len());
    this.size += paramMetadata.size;
  }
  
  public void merge(Metadata paramMetadata, Set<Key<?>> paramSet) {
    Preconditions.checkNotNull(paramMetadata, "other");
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(paramSet.size());
    for (Key<?> key : paramSet)
      hashMap.put(ByteBuffer.wrap(key.asciiName()), key); 
    for (byte b = 0; b < paramMetadata.size; b++) {
      if (hashMap.containsKey(ByteBuffer.wrap(paramMetadata.name(b)))) {
        maybeExpand();
        name(this.size, paramMetadata.name(b));
        value(this.size, paramMetadata.value(b));
        this.size++;
      } 
    } 
  }
  
  public <T> void put(Key<T> paramKey, T paramT) {
    Preconditions.checkNotNull(paramKey, "key");
    Preconditions.checkNotNull(paramT, "value");
    maybeExpand();
    name(this.size, paramKey.asciiName());
    value(this.size, paramKey.toBytes(paramT));
    this.size++;
  }
  
  public <T> boolean remove(Key<T> paramKey, T paramT) {
    Preconditions.checkNotNull(paramKey, "key");
    Preconditions.checkNotNull(paramT, "value");
    byte b = 0;
    while (b < this.size) {
      if (!bytesEqual(paramKey.asciiName(), name(b)) || !paramT.equals(paramKey.parseBytes(value(b)))) {
        b++;
        continue;
      } 
      int i = (b + 1) * 2;
      int j = len();
      byte[][] arrayOfByte = this.namesAndValues;
      System.arraycopy(arrayOfByte, i, arrayOfByte, b * 2, j - i);
      this.size--;
      name(this.size, null);
      value(this.size, null);
      return true;
    } 
    return false;
  }
  
  public <T> Iterable<T> removeAll(Key<T> paramKey) {
    if (isEmpty())
      return null; 
    byte b1 = 0;
    ArrayList<T> arrayList = null;
    byte b2 = 0;
    while (b1 < this.size) {
      if (bytesEqual(paramKey.asciiName(), name(b1))) {
        if (arrayList == null)
          arrayList = new ArrayList(); 
        arrayList.add(paramKey.parseBytes(value(b1)));
      } else {
        name(b2, name(b1));
        value(b2, value(b1));
        b2++;
      } 
      b1++;
    } 
    Arrays.fill((Object[])this.namesAndValues, b2 * 2, len(), (Object)null);
    this.size = b2;
    return arrayList;
  }
  
  @Nullable
  byte[][] serialize() {
    if (len() == cap())
      return this.namesAndValues; 
    byte[][] arrayOfByte = new byte[len()][];
    System.arraycopy(this.namesAndValues, 0, arrayOfByte, 0, len());
    return arrayOfByte;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("Metadata(");
    for (byte b = 0; b < this.size; b++) {
      if (b != 0)
        stringBuilder.append(','); 
      String str = new String(name(b), Charsets.US_ASCII);
      stringBuilder.append(str);
      stringBuilder.append('=');
      if (str.endsWith("-bin")) {
        stringBuilder.append(BaseEncoding.base64().encode(value(b)));
      } else {
        stringBuilder.append(new String(value(b), Charsets.US_ASCII));
      } 
    } 
    stringBuilder.append(')');
    return stringBuilder.toString();
  }
  
  private static class AsciiKey<T> extends Key<T> {
    private final Metadata.AsciiMarshaller<T> marshaller;
    
    private AsciiKey(String param1String, boolean param1Boolean, Metadata.AsciiMarshaller<T> param1AsciiMarshaller) {
      super(param1String, param1Boolean);
      Preconditions.checkArgument(param1String.endsWith("-bin") ^ true, "ASCII header is named %s.  Only binary headers may end with %s", param1String, "-bin");
      this.marshaller = (Metadata.AsciiMarshaller<T>)Preconditions.checkNotNull(param1AsciiMarshaller, "marshaller");
    }
    
    T parseBytes(byte[] param1ArrayOfbyte) {
      return this.marshaller.parseAsciiString(new String(param1ArrayOfbyte, Charsets.US_ASCII));
    }
    
    byte[] toBytes(T param1T) {
      return this.marshaller.toAsciiString(param1T).getBytes(Charsets.US_ASCII);
    }
  }
  
  public static interface AsciiMarshaller<T> {
    T parseAsciiString(String param1String);
    
    String toAsciiString(T param1T);
  }
  
  private static class BinaryKey<T> extends Key<T> {
    private final Metadata.BinaryMarshaller<T> marshaller;
    
    private BinaryKey(String param1String, Metadata.BinaryMarshaller<T> param1BinaryMarshaller) {
      super(param1String, false);
      Preconditions.checkArgument(param1String.endsWith("-bin"), "Binary header is named %s. It must end with %s", param1String, "-bin");
      if (param1String.length() > 4)
        bool = true; 
      Preconditions.checkArgument(bool, "empty key name");
      this.marshaller = (Metadata.BinaryMarshaller<T>)Preconditions.checkNotNull(param1BinaryMarshaller, "marshaller is null");
    }
    
    T parseBytes(byte[] param1ArrayOfbyte) {
      return this.marshaller.parseBytes(param1ArrayOfbyte);
    }
    
    byte[] toBytes(T param1T) {
      return this.marshaller.toBytes(param1T);
    }
  }
  
  public static interface BinaryMarshaller<T> {
    T parseBytes(byte[] param1ArrayOfbyte);
    
    byte[] toBytes(T param1T);
  }
  
  private final class IterableAt<T> implements Iterable<T> {
    private final Metadata.Key<T> key;
    
    private int startIdx;
    
    private IterableAt(Metadata.Key<T> param1Key, int param1Int) {
      this.key = param1Key;
      this.startIdx = param1Int;
    }
    
    public Iterator<T> iterator() {
      return new Iterator<T>() {
          private boolean hasNext = true;
          
          private int idx = Metadata.IterableAt.this.startIdx;
          
          public boolean hasNext() {
            if (this.hasNext)
              return true; 
            while (this.idx < Metadata.this.size) {
              if (Metadata.this.bytesEqual(Metadata.IterableAt.this.key.asciiName(), Metadata.this.name(this.idx))) {
                this.hasNext = true;
                return this.hasNext;
              } 
              this.idx++;
            } 
            return false;
          }
          
          public T next() {
            if (hasNext()) {
              this.hasNext = false;
              Metadata.Key<T> key = Metadata.IterableAt.this.key;
              Metadata metadata = Metadata.this;
              int i = this.idx;
              this.idx = i + 1;
              return key.parseBytes(metadata.value(i));
            } 
            throw new NoSuchElementException();
          }
          
          public void remove() {
            throw new UnsupportedOperationException();
          }
        };
    }
  }
  
  class null implements Iterator<T> {
    private boolean hasNext = true;
    
    private int idx = this.this$1.startIdx;
    
    public boolean hasNext() {
      if (this.hasNext)
        return true; 
      while (this.idx < Metadata.this.size) {
        if (Metadata.this.bytesEqual(this.this$1.key.asciiName(), Metadata.this.name(this.idx))) {
          this.hasNext = true;
          return this.hasNext;
        } 
        this.idx++;
      } 
      return false;
    }
    
    public T next() {
      if (hasNext()) {
        this.hasNext = false;
        Metadata.Key<T> key = this.this$1.key;
        Metadata metadata = Metadata.this;
        int i = this.idx;
        this.idx = i + 1;
        return key.parseBytes(metadata.value(i));
      } 
      throw new NoSuchElementException();
    }
    
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
  
  @Immutable
  public static abstract class Key<T> {
    private static final BitSet VALID_T_CHARS = generateValidTChars();
    
    private final String name;
    
    private final byte[] nameBytes;
    
    private final String originalName;
    
    private Key(String param1String, boolean param1Boolean) {
      this.originalName = (String)Preconditions.checkNotNull(param1String, "name");
      this.name = validateName(this.originalName.toLowerCase(Locale.ROOT), param1Boolean);
      this.nameBytes = this.name.getBytes(Charsets.US_ASCII);
    }
    
    private static BitSet generateValidTChars() {
      BitSet bitSet = new BitSet(127);
      bitSet.set(45);
      bitSet.set(95);
      bitSet.set(46);
      char c;
      for (c = '0'; c <= '9'; c = (char)(c + 1))
        bitSet.set(c); 
      for (c = 'a'; c <= 'z'; c = (char)(c + 1))
        bitSet.set(c); 
      return bitSet;
    }
    
    public static <T> Key<T> of(String param1String, Metadata.AsciiMarshaller<T> param1AsciiMarshaller) {
      return of(param1String, false, param1AsciiMarshaller);
    }
    
    public static <T> Key<T> of(String param1String, Metadata.BinaryMarshaller<T> param1BinaryMarshaller) {
      return new Metadata.BinaryKey<T>(param1String, param1BinaryMarshaller);
    }
    
    static <T> Key<T> of(String param1String, boolean param1Boolean, Metadata.AsciiMarshaller<T> param1AsciiMarshaller) {
      return new Metadata.AsciiKey<T>(param1String, param1Boolean, param1AsciiMarshaller);
    }
    
    static <T> Key<T> of(String param1String, boolean param1Boolean, Metadata.TrustedAsciiMarshaller<T> param1TrustedAsciiMarshaller) {
      return new Metadata.TrustedAsciiKey<T>(param1String, param1Boolean, param1TrustedAsciiMarshaller);
    }
    
    private static String validateName(String param1String, boolean param1Boolean) {
      Preconditions.checkNotNull(param1String, "name");
      Preconditions.checkArgument(param1String.isEmpty() ^ true, "token must have at least 1 tchar");
      for (byte b = 0; b < param1String.length(); b++) {
        char c = param1String.charAt(b);
        if (!param1Boolean || c != ':' || b != 0)
          Preconditions.checkArgument(VALID_T_CHARS.get(c), "Invalid character '%s' in key name '%s'", c, param1String); 
      } 
      return param1String;
    }
    
    @VisibleForTesting
    byte[] asciiName() {
      return this.nameBytes;
    }
    
    public boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (param1Object == null || getClass() != param1Object.getClass())
        return false; 
      param1Object = param1Object;
      return this.name.equals(((Key)param1Object).name);
    }
    
    public int hashCode() {
      return this.name.hashCode();
    }
    
    public final String name() {
      return this.name;
    }
    
    public final String originalName() {
      return this.originalName;
    }
    
    abstract T parseBytes(byte[] param1ArrayOfbyte);
    
    abstract byte[] toBytes(T param1T);
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Key{name='");
      stringBuilder.append(this.name);
      stringBuilder.append("'}");
      return stringBuilder.toString();
    }
  }
  
  private static final class TrustedAsciiKey<T> extends Key<T> {
    private final Metadata.TrustedAsciiMarshaller<T> marshaller;
    
    private TrustedAsciiKey(String param1String, boolean param1Boolean, Metadata.TrustedAsciiMarshaller<T> param1TrustedAsciiMarshaller) {
      super(param1String, param1Boolean);
      Preconditions.checkArgument(param1String.endsWith("-bin") ^ true, "ASCII header is named %s.  Only binary headers may end with %s", param1String, "-bin");
      this.marshaller = (Metadata.TrustedAsciiMarshaller<T>)Preconditions.checkNotNull(param1TrustedAsciiMarshaller, "marshaller");
    }
    
    T parseBytes(byte[] param1ArrayOfbyte) {
      return this.marshaller.parseAsciiString(param1ArrayOfbyte);
    }
    
    byte[] toBytes(T param1T) {
      return this.marshaller.toAsciiString(param1T);
    }
  }
  
  @Immutable
  static interface TrustedAsciiMarshaller<T> {
    T parseAsciiString(byte[] param1ArrayOfbyte);
    
    byte[] toAsciiString(T param1T);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\Metadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */