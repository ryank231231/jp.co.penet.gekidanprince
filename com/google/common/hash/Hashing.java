package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import javax.annotation.Nullable;
import javax.crypto.spec.SecretKeySpec;

@Beta
public final class Hashing {
  private static final int GOOD_FAST_HASH_SEED = (int)System.currentTimeMillis();
  
  public static HashFunction adler32() {
    return Adler32Holder.ADLER_32;
  }
  
  static int checkPositiveAndMakeMultipleOf32(int paramInt) {
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Number of bits must be positive");
    return paramInt + 31 & 0xFFFFFFE0;
  }
  
  private static HashFunction checksumHashFunction(ChecksumType paramChecksumType, String paramString) {
    return new ChecksumHashFunction(paramChecksumType, paramChecksumType.bits, paramString);
  }
  
  public static HashCode combineOrdered(Iterable<HashCode> paramIterable) {
    Iterator<HashCode> iterator2 = paramIterable.iterator();
    Preconditions.checkArgument(iterator2.hasNext(), "Must be at least 1 hash code to combine.");
    byte[] arrayOfByte = new byte[((HashCode)iterator2.next()).bits() / 8];
    Iterator<HashCode> iterator1 = paramIterable.iterator();
    while (iterator1.hasNext()) {
      boolean bool;
      byte[] arrayOfByte1 = ((HashCode)iterator1.next()).asBytes();
      int i = arrayOfByte1.length;
      int j = arrayOfByte.length;
      byte b = 0;
      if (i == j) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "All hashcodes must have the same bit length.");
      while (b < arrayOfByte1.length) {
        arrayOfByte[b] = (byte)(byte)(arrayOfByte[b] * 37 ^ arrayOfByte1[b]);
        b++;
      } 
    } 
    return HashCode.fromBytesNoCopy(arrayOfByte);
  }
  
  public static HashCode combineUnordered(Iterable<HashCode> paramIterable) {
    Iterator<HashCode> iterator2 = paramIterable.iterator();
    Preconditions.checkArgument(iterator2.hasNext(), "Must be at least 1 hash code to combine.");
    byte[] arrayOfByte = new byte[((HashCode)iterator2.next()).bits() / 8];
    Iterator<HashCode> iterator1 = paramIterable.iterator();
    while (iterator1.hasNext()) {
      boolean bool;
      byte[] arrayOfByte1 = ((HashCode)iterator1.next()).asBytes();
      int i = arrayOfByte1.length;
      int j = arrayOfByte.length;
      byte b = 0;
      if (i == j) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "All hashcodes must have the same bit length.");
      while (b < arrayOfByte1.length) {
        arrayOfByte[b] = (byte)(byte)(arrayOfByte[b] + arrayOfByte1[b]);
        b++;
      } 
    } 
    return HashCode.fromBytesNoCopy(arrayOfByte);
  }
  
  public static HashFunction concatenating(HashFunction paramHashFunction1, HashFunction paramHashFunction2, HashFunction... paramVarArgs) {
    ArrayList<HashFunction> arrayList = new ArrayList();
    arrayList.add(paramHashFunction1);
    arrayList.add(paramHashFunction2);
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++)
      arrayList.add(paramVarArgs[b]); 
    return new ConcatenatedHashFunction(arrayList.<HashFunction>toArray(new HashFunction[0]));
  }
  
  public static HashFunction concatenating(Iterable<HashFunction> paramIterable) {
    boolean bool;
    Preconditions.checkNotNull(paramIterable);
    ArrayList<HashFunction> arrayList = new ArrayList();
    Iterator<HashFunction> iterator = paramIterable.iterator();
    while (iterator.hasNext())
      arrayList.add(iterator.next()); 
    if (arrayList.size() > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "number of hash functions (%s) must be > 0", arrayList.size());
    return new ConcatenatedHashFunction(arrayList.<HashFunction>toArray(new HashFunction[0]));
  }
  
  public static int consistentHash(long paramLong, int paramInt) {
    boolean bool;
    int i = 0;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "buckets must be positive: %s", paramInt);
    LinearCongruentialGenerator linearCongruentialGenerator = new LinearCongruentialGenerator(paramLong);
    while (true) {
      double d1 = (i + 1);
      double d2 = linearCongruentialGenerator.nextDouble();
      Double.isNaN(d1);
      int j = (int)(d1 / d2);
      if (j >= 0 && j < paramInt) {
        i = j;
        continue;
      } 
      break;
    } 
    return i;
  }
  
  public static int consistentHash(HashCode paramHashCode, int paramInt) {
    return consistentHash(paramHashCode.padToLong(), paramInt);
  }
  
  public static HashFunction crc32() {
    return Crc32Holder.CRC_32;
  }
  
  public static HashFunction crc32c() {
    return Crc32cHolder.CRC_32_C;
  }
  
  public static HashFunction farmHashFingerprint64() {
    return FarmHashFingerprint64Holder.FARMHASH_FINGERPRINT_64;
  }
  
  public static HashFunction goodFastHash(int paramInt) {
    paramInt = checkPositiveAndMakeMultipleOf32(paramInt);
    if (paramInt == 32)
      return Murmur3_32Holder.GOOD_FAST_HASH_FUNCTION_32; 
    if (paramInt <= 128)
      return Murmur3_128Holder.GOOD_FAST_HASH_FUNCTION_128; 
    int i = (paramInt + 127) / 128;
    HashFunction[] arrayOfHashFunction = new HashFunction[i];
    arrayOfHashFunction[0] = Murmur3_128Holder.GOOD_FAST_HASH_FUNCTION_128;
    int j = GOOD_FAST_HASH_SEED;
    for (paramInt = 1; paramInt < i; paramInt++) {
      j += 1500450271;
      arrayOfHashFunction[paramInt] = murmur3_128(j);
    } 
    return new ConcatenatedHashFunction(arrayOfHashFunction);
  }
  
  public static HashFunction hmacMd5(Key paramKey) {
    return new MacHashFunction("HmacMD5", paramKey, hmacToString("hmacMd5", paramKey));
  }
  
  public static HashFunction hmacMd5(byte[] paramArrayOfbyte) {
    return hmacMd5(new SecretKeySpec((byte[])Preconditions.checkNotNull(paramArrayOfbyte), "HmacMD5"));
  }
  
  public static HashFunction hmacSha1(Key paramKey) {
    return new MacHashFunction("HmacSHA1", paramKey, hmacToString("hmacSha1", paramKey));
  }
  
  public static HashFunction hmacSha1(byte[] paramArrayOfbyte) {
    return hmacSha1(new SecretKeySpec((byte[])Preconditions.checkNotNull(paramArrayOfbyte), "HmacSHA1"));
  }
  
  public static HashFunction hmacSha256(Key paramKey) {
    return new MacHashFunction("HmacSHA256", paramKey, hmacToString("hmacSha256", paramKey));
  }
  
  public static HashFunction hmacSha256(byte[] paramArrayOfbyte) {
    return hmacSha256(new SecretKeySpec((byte[])Preconditions.checkNotNull(paramArrayOfbyte), "HmacSHA256"));
  }
  
  public static HashFunction hmacSha512(Key paramKey) {
    return new MacHashFunction("HmacSHA512", paramKey, hmacToString("hmacSha512", paramKey));
  }
  
  public static HashFunction hmacSha512(byte[] paramArrayOfbyte) {
    return hmacSha512(new SecretKeySpec((byte[])Preconditions.checkNotNull(paramArrayOfbyte), "HmacSHA512"));
  }
  
  private static String hmacToString(String paramString, Key paramKey) {
    return String.format("Hashing.%s(Key[algorithm=%s, format=%s])", new Object[] { paramString, paramKey.getAlgorithm(), paramKey.getFormat() });
  }
  
  public static HashFunction md5() {
    return Md5Holder.MD5;
  }
  
  public static HashFunction murmur3_128() {
    return Murmur3_128Holder.MURMUR3_128;
  }
  
  public static HashFunction murmur3_128(int paramInt) {
    return new Murmur3_128HashFunction(paramInt);
  }
  
  public static HashFunction murmur3_32() {
    return Murmur3_32Holder.MURMUR3_32;
  }
  
  public static HashFunction murmur3_32(int paramInt) {
    return new Murmur3_32HashFunction(paramInt);
  }
  
  public static HashFunction sha1() {
    return Sha1Holder.SHA_1;
  }
  
  public static HashFunction sha256() {
    return Sha256Holder.SHA_256;
  }
  
  public static HashFunction sha384() {
    return Sha384Holder.SHA_384;
  }
  
  public static HashFunction sha512() {
    return Sha512Holder.SHA_512;
  }
  
  public static HashFunction sipHash24() {
    return SipHash24Holder.SIP_HASH_24;
  }
  
  public static HashFunction sipHash24(long paramLong1, long paramLong2) {
    return new SipHashFunction(2, 4, paramLong1, paramLong2);
  }
  
  private static class Adler32Holder {
    static final HashFunction ADLER_32 = Hashing.checksumHashFunction(Hashing.ChecksumType.ADLER_32, "Hashing.adler32()");
  }
  
  enum ChecksumType implements Supplier<Checksum> {
    ADLER_32,
    CRC_32(32) {
      public Checksum get() {
        return new CRC32();
      }
    };
    
    private final int bits;
    
    static {
      $VALUES = new ChecksumType[] { CRC_32, ADLER_32 };
    }
    
    ChecksumType(int param1Int1) {
      this.bits = param1Int1;
    }
    
    public abstract Checksum get();
  }
  
  enum null {
    public Checksum get() {
      return new CRC32();
    }
  }
  
  enum null {
    public Checksum get() {
      return new Adler32();
    }
  }
  
  private static final class ConcatenatedHashFunction extends AbstractCompositeHashFunction {
    private final int bits;
    
    private ConcatenatedHashFunction(HashFunction... param1VarArgs) {
      super(param1VarArgs);
      int i = param1VarArgs.length;
      byte b = 0;
      int j = 0;
      while (b < i) {
        boolean bool;
        HashFunction hashFunction = param1VarArgs[b];
        j += hashFunction.bits();
        if (hashFunction.bits() % 8 == 0) {
          bool = true;
        } else {
          bool = false;
        } 
        Preconditions.checkArgument(bool, "the number of bits (%s) in hashFunction (%s) must be divisible by 8", hashFunction.bits(), hashFunction);
        b++;
      } 
      this.bits = j;
    }
    
    public int bits() {
      return this.bits;
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object instanceof ConcatenatedHashFunction) {
        param1Object = param1Object;
        return Arrays.equals((Object[])this.functions, (Object[])((ConcatenatedHashFunction)param1Object).functions);
      } 
      return false;
    }
    
    public int hashCode() {
      return Arrays.hashCode((Object[])this.functions) * 31 + this.bits;
    }
    
    HashCode makeHash(Hasher[] param1ArrayOfHasher) {
      byte[] arrayOfByte = new byte[this.bits / 8];
      int i = param1ArrayOfHasher.length;
      byte b = 0;
      int j = 0;
      while (b < i) {
        HashCode hashCode = param1ArrayOfHasher[b].hash();
        j += hashCode.writeBytesTo(arrayOfByte, j, hashCode.bits() / 8);
        b++;
      } 
      return HashCode.fromBytesNoCopy(arrayOfByte);
    }
  }
  
  private static class Crc32Holder {
    static final HashFunction CRC_32 = Hashing.checksumHashFunction(Hashing.ChecksumType.CRC_32, "Hashing.crc32()");
  }
  
  private static final class Crc32cHolder {
    static final HashFunction CRC_32_C = new Crc32cHashFunction();
  }
  
  private static class FarmHashFingerprint64Holder {
    static final HashFunction FARMHASH_FINGERPRINT_64 = new FarmHashFingerprint64();
  }
  
  private static final class LinearCongruentialGenerator {
    private long state;
    
    public LinearCongruentialGenerator(long param1Long) {
      this.state = param1Long;
    }
    
    public double nextDouble() {
      this.state = this.state * 2862933555777941757L + 1L;
      double d = ((int)(this.state >>> 33L) + 1);
      Double.isNaN(d);
      return d / 2.147483648E9D;
    }
  }
  
  private static class Md5Holder {
    static final HashFunction MD5 = new MessageDigestHashFunction("MD5", "Hashing.md5()");
  }
  
  private static class Murmur3_128Holder {
    static final HashFunction GOOD_FAST_HASH_FUNCTION_128 = Hashing.murmur3_128(Hashing.GOOD_FAST_HASH_SEED);
    
    static final HashFunction MURMUR3_128 = new Murmur3_128HashFunction(0);
    
    static {
    
    }
  }
  
  private static class Murmur3_32Holder {
    static final HashFunction GOOD_FAST_HASH_FUNCTION_32 = Hashing.murmur3_32(Hashing.GOOD_FAST_HASH_SEED);
    
    static final HashFunction MURMUR3_32 = new Murmur3_32HashFunction(0);
    
    static {
    
    }
  }
  
  private static class Sha1Holder {
    static final HashFunction SHA_1 = new MessageDigestHashFunction("SHA-1", "Hashing.sha1()");
  }
  
  private static class Sha256Holder {
    static final HashFunction SHA_256 = new MessageDigestHashFunction("SHA-256", "Hashing.sha256()");
  }
  
  private static class Sha384Holder {
    static final HashFunction SHA_384 = new MessageDigestHashFunction("SHA-384", "Hashing.sha384()");
  }
  
  private static class Sha512Holder {
    static final HashFunction SHA_512 = new MessageDigestHashFunction("SHA-512", "Hashing.sha512()");
  }
  
  private static class SipHash24Holder {
    static final HashFunction SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\hash\Hashing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */