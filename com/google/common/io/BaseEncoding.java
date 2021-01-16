package com.google.common.io;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public abstract class BaseEncoding {
  private static final BaseEncoding BASE16;
  
  private static final BaseEncoding BASE32;
  
  private static final BaseEncoding BASE32_HEX;
  
  private static final BaseEncoding BASE64 = new Base64Encoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", Character.valueOf('='));
  
  private static final BaseEncoding BASE64_URL = new Base64Encoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", Character.valueOf('='));
  
  static {
    BASE32 = new StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", Character.valueOf('='));
    BASE32_HEX = new StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", Character.valueOf('='));
    BASE16 = new Base16Encoding("base16()", "0123456789ABCDEF");
  }
  
  public static BaseEncoding base16() {
    return BASE16;
  }
  
  public static BaseEncoding base32() {
    return BASE32;
  }
  
  public static BaseEncoding base32Hex() {
    return BASE32_HEX;
  }
  
  public static BaseEncoding base64() {
    return BASE64;
  }
  
  public static BaseEncoding base64Url() {
    return BASE64_URL;
  }
  
  private static byte[] extract(byte[] paramArrayOfbyte, int paramInt) {
    if (paramInt == paramArrayOfbyte.length)
      return paramArrayOfbyte; 
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(paramArrayOfbyte, 0, arrayOfByte, 0, paramInt);
    return arrayOfByte;
  }
  
  @GwtIncompatible
  static Reader ignoringReader(final Reader delegate, final CharMatcher toIgnore) {
    Preconditions.checkNotNull(delegate);
    Preconditions.checkNotNull(toIgnore);
    return new Reader() {
        public void close() throws IOException {
          delegate.close();
        }
        
        public int read() throws IOException {
          int i;
          do {
            i = delegate.read();
          } while (i != -1 && toIgnore.matches((char)i));
          return i;
        }
        
        public int read(char[] param1ArrayOfchar, int param1Int1, int param1Int2) throws IOException {
          throw new UnsupportedOperationException();
        }
      };
  }
  
  static Appendable separatingAppendable(final Appendable delegate, final String separator, final int afterEveryChars) {
    boolean bool;
    Preconditions.checkNotNull(delegate);
    Preconditions.checkNotNull(separator);
    if (afterEveryChars > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    return new Appendable() {
        int charsUntilSeparator = afterEveryChars;
        
        public Appendable append(char param1Char) throws IOException {
          if (this.charsUntilSeparator == 0) {
            delegate.append(separator);
            this.charsUntilSeparator = afterEveryChars;
          } 
          delegate.append(param1Char);
          this.charsUntilSeparator--;
          return this;
        }
        
        public Appendable append(CharSequence param1CharSequence) throws IOException {
          throw new UnsupportedOperationException();
        }
        
        public Appendable append(CharSequence param1CharSequence, int param1Int1, int param1Int2) throws IOException {
          throw new UnsupportedOperationException();
        }
      };
  }
  
  @GwtIncompatible
  static Writer separatingWriter(final Writer delegate, String paramString, int paramInt) {
    return new Writer() {
        public void close() throws IOException {
          delegate.close();
        }
        
        public void flush() throws IOException {
          delegate.flush();
        }
        
        public void write(int param1Int) throws IOException {
          seperatingAppendable.append((char)param1Int);
        }
        
        public void write(char[] param1ArrayOfchar, int param1Int1, int param1Int2) throws IOException {
          throw new UnsupportedOperationException();
        }
      };
  }
  
  public abstract boolean canDecode(CharSequence paramCharSequence);
  
  public final byte[] decode(CharSequence paramCharSequence) {
    try {
      return decodeChecked(paramCharSequence);
    } catch (DecodingException decodingException) {
      throw new IllegalArgumentException(decodingException);
    } 
  }
  
  final byte[] decodeChecked(CharSequence paramCharSequence) throws DecodingException {
    paramCharSequence = padding().trimTrailingFrom(paramCharSequence);
    byte[] arrayOfByte = new byte[maxDecodedSize(paramCharSequence.length())];
    return extract(arrayOfByte, decodeTo(arrayOfByte, paramCharSequence));
  }
  
  abstract int decodeTo(byte[] paramArrayOfbyte, CharSequence paramCharSequence) throws DecodingException;
  
  @GwtIncompatible
  public final ByteSource decodingSource(final CharSource encodedSource) {
    Preconditions.checkNotNull(encodedSource);
    return new ByteSource() {
        public InputStream openStream() throws IOException {
          return BaseEncoding.this.decodingStream(encodedSource.openStream());
        }
      };
  }
  
  @GwtIncompatible
  public abstract InputStream decodingStream(Reader paramReader);
  
  public String encode(byte[] paramArrayOfbyte) {
    return encode(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public final String encode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfbyte.length);
    StringBuilder stringBuilder = new StringBuilder(maxEncodedSize(paramInt2));
    try {
      encodeTo(stringBuilder, paramArrayOfbyte, paramInt1, paramInt2);
      return stringBuilder.toString();
    } catch (IOException iOException) {
      throw new AssertionError(iOException);
    } 
  }
  
  abstract void encodeTo(Appendable paramAppendable, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException;
  
  @GwtIncompatible
  public final ByteSink encodingSink(final CharSink encodedSink) {
    Preconditions.checkNotNull(encodedSink);
    return new ByteSink() {
        public OutputStream openStream() throws IOException {
          return BaseEncoding.this.encodingStream(encodedSink.openStream());
        }
      };
  }
  
  @GwtIncompatible
  public abstract OutputStream encodingStream(Writer paramWriter);
  
  public abstract BaseEncoding lowerCase();
  
  abstract int maxDecodedSize(int paramInt);
  
  abstract int maxEncodedSize(int paramInt);
  
  public abstract BaseEncoding omitPadding();
  
  abstract CharMatcher padding();
  
  public abstract BaseEncoding upperCase();
  
  public abstract BaseEncoding withPadChar(char paramChar);
  
  public abstract BaseEncoding withSeparator(String paramString, int paramInt);
  
  private static final class Alphabet extends CharMatcher {
    final int bitsPerChar;
    
    final int bytesPerChunk;
    
    private final char[] chars;
    
    final int charsPerChunk;
    
    private final byte[] decodabet;
    
    final int mask;
    
    private final String name;
    
    private final boolean[] validPadding;
    
    Alphabet(String param1String, char[] param1ArrayOfchar) {
      this.name = (String)Preconditions.checkNotNull(param1String);
      this.chars = (char[])Preconditions.checkNotNull(param1ArrayOfchar);
      try {
        this.bitsPerChar = IntMath.log2(param1ArrayOfchar.length, RoundingMode.UNNECESSARY);
        int i = Math.min(8, Integer.lowestOneBit(this.bitsPerChar));
        try {
          this.charsPerChunk = 8 / i;
          this.bytesPerChunk = this.bitsPerChar / i;
          this.mask = param1ArrayOfchar.length - 1;
          byte[] arrayOfByte = new byte[128];
          Arrays.fill(arrayOfByte, (byte)-1);
          boolean bool = false;
          for (i = 0; i < param1ArrayOfchar.length; i++) {
            boolean bool1;
            char c = param1ArrayOfchar[i];
            Preconditions.checkArgument(CharMatcher.ascii().matches(c), "Non-ASCII character: %s", c);
            if (arrayOfByte[c] == -1) {
              bool1 = true;
            } else {
              bool1 = false;
            } 
            Preconditions.checkArgument(bool1, "Duplicate character: %s", c);
            arrayOfByte[c] = (byte)(byte)i;
          } 
          this.decodabet = arrayOfByte;
          boolean[] arrayOfBoolean = new boolean[this.charsPerChunk];
          for (i = bool; i < this.bytesPerChunk; i++)
            arrayOfBoolean[IntMath.divide(i * 8, this.bitsPerChar, RoundingMode.CEILING)] = true; 
          this.validPadding = arrayOfBoolean;
          return;
        } catch (ArithmeticException arithmeticException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Illegal alphabet ");
          stringBuilder.append(new String(param1ArrayOfchar));
          throw new IllegalArgumentException(stringBuilder.toString(), arithmeticException);
        } 
      } catch (ArithmeticException arithmeticException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Illegal alphabet length ");
        stringBuilder.append(param1ArrayOfchar.length);
        throw new IllegalArgumentException(stringBuilder.toString(), arithmeticException);
      } 
    }
    
    private boolean hasLowerCase() {
      char[] arrayOfChar = this.chars;
      int i = arrayOfChar.length;
      for (byte b = 0; b < i; b++) {
        if (Ascii.isLowerCase(arrayOfChar[b]))
          return true; 
      } 
      return false;
    }
    
    private boolean hasUpperCase() {
      char[] arrayOfChar = this.chars;
      int i = arrayOfChar.length;
      for (byte b = 0; b < i; b++) {
        if (Ascii.isUpperCase(arrayOfChar[b]))
          return true; 
      } 
      return false;
    }
    
    boolean canDecode(char param1Char) {
      boolean bool;
      if (param1Char <= '' && this.decodabet[param1Char] != -1) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    int decode(char param1Char) throws BaseEncoding.DecodingException {
      Character character;
      if (param1Char <= '') {
        byte[] arrayOfByte = this.decodabet;
        if (arrayOfByte[param1Char] != -1)
          return arrayOfByte[param1Char]; 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unrecognized character: ");
      if (CharMatcher.invisible().matches(param1Char)) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("0x");
        stringBuilder1.append(Integer.toHexString(param1Char));
        String str = stringBuilder1.toString();
      } else {
        character = Character.valueOf(param1Char);
      } 
      stringBuilder.append(character);
      throw new BaseEncoding.DecodingException(stringBuilder.toString());
    }
    
    char encode(int param1Int) {
      return this.chars[param1Int];
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object instanceof Alphabet) {
        param1Object = param1Object;
        return Arrays.equals(this.chars, ((Alphabet)param1Object).chars);
      } 
      return false;
    }
    
    public int hashCode() {
      return Arrays.hashCode(this.chars);
    }
    
    boolean isValidPaddingStartPosition(int param1Int) {
      return this.validPadding[param1Int % this.charsPerChunk];
    }
    
    Alphabet lowerCase() {
      if (!hasUpperCase())
        return this; 
      Preconditions.checkState(hasLowerCase() ^ true, "Cannot call lowerCase() on a mixed-case alphabet");
      char[] arrayOfChar = new char[this.chars.length];
      byte b = 0;
      while (true) {
        char[] arrayOfChar1 = this.chars;
        if (b < arrayOfChar1.length) {
          arrayOfChar[b] = Ascii.toLowerCase(arrayOfChar1[b]);
          b++;
          continue;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name);
        stringBuilder.append(".lowerCase()");
        return new Alphabet(stringBuilder.toString(), arrayOfChar);
      } 
    }
    
    public boolean matches(char param1Char) {
      boolean bool;
      if (CharMatcher.ascii().matches(param1Char) && this.decodabet[param1Char] != -1) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public String toString() {
      return this.name;
    }
    
    Alphabet upperCase() {
      if (!hasLowerCase())
        return this; 
      Preconditions.checkState(hasUpperCase() ^ true, "Cannot call upperCase() on a mixed-case alphabet");
      char[] arrayOfChar = new char[this.chars.length];
      byte b = 0;
      while (true) {
        char[] arrayOfChar1 = this.chars;
        if (b < arrayOfChar1.length) {
          arrayOfChar[b] = Ascii.toUpperCase(arrayOfChar1[b]);
          b++;
          continue;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name);
        stringBuilder.append(".upperCase()");
        return new Alphabet(stringBuilder.toString(), arrayOfChar);
      } 
    }
  }
  
  static final class Base16Encoding extends StandardBaseEncoding {
    final char[] encoding;
    
    private Base16Encoding(BaseEncoding.Alphabet param1Alphabet) {
      super(param1Alphabet, null);
      boolean bool;
      this.encoding = new char[512];
      int i = param1Alphabet.chars.length;
      byte b = 0;
      if (i == 16) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool);
      while (b < 'Ā') {
        this.encoding[b] = param1Alphabet.encode(b >>> 4);
        this.encoding[b | 0x100] = param1Alphabet.encode(b & 0xF);
        b++;
      } 
    }
    
    Base16Encoding(String param1String1, String param1String2) {
      this(new BaseEncoding.Alphabet(param1String1, param1String2.toCharArray()));
    }
    
    int decodeTo(byte[] param1ArrayOfbyte, CharSequence param1CharSequence) throws BaseEncoding.DecodingException {
      Preconditions.checkNotNull(param1ArrayOfbyte);
      if (param1CharSequence.length() % 2 != 1) {
        byte b1 = 0;
        byte b2;
        for (b2 = 0; b1 < param1CharSequence.length(); b2++) {
          param1ArrayOfbyte[b2] = (byte)(byte)(this.alphabet.decode(param1CharSequence.charAt(b1)) << 4 | this.alphabet.decode(param1CharSequence.charAt(b1 + 1)));
          b1 += 2;
        } 
        return b2;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid input length ");
      stringBuilder.append(param1CharSequence.length());
      throw new BaseEncoding.DecodingException(stringBuilder.toString());
    }
    
    void encodeTo(Appendable param1Appendable, byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      Preconditions.checkNotNull(param1Appendable);
      Preconditions.checkPositionIndexes(param1Int1, param1Int1 + param1Int2, param1ArrayOfbyte.length);
      for (byte b = 0; b < param1Int2; b++) {
        int i = param1ArrayOfbyte[param1Int1 + b] & 0xFF;
        param1Appendable.append(this.encoding[i]);
        param1Appendable.append(this.encoding[i | 0x100]);
      } 
    }
    
    BaseEncoding newInstance(BaseEncoding.Alphabet param1Alphabet, @Nullable Character param1Character) {
      return new Base16Encoding(param1Alphabet);
    }
  }
  
  static final class Base64Encoding extends StandardBaseEncoding {
    private Base64Encoding(BaseEncoding.Alphabet param1Alphabet, @Nullable Character param1Character) {
      super(param1Alphabet, param1Character);
      boolean bool;
      if (param1Alphabet.chars.length == 64) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool);
    }
    
    Base64Encoding(String param1String1, String param1String2, @Nullable Character param1Character) {
      this(new BaseEncoding.Alphabet(param1String1, param1String2.toCharArray()), param1Character);
    }
    
    int decodeTo(byte[] param1ArrayOfbyte, CharSequence param1CharSequence) throws BaseEncoding.DecodingException {
      Preconditions.checkNotNull(param1ArrayOfbyte);
      param1CharSequence = padding().trimTrailingFrom(param1CharSequence);
      if (this.alphabet.isValidPaddingStartPosition(param1CharSequence.length())) {
        int i = 0;
        int j;
        for (j = 0; i < param1CharSequence.length(); j = k) {
          BaseEncoding.Alphabet alphabet = this.alphabet;
          int k = i + 1;
          int m = alphabet.decode(param1CharSequence.charAt(i));
          alphabet = this.alphabet;
          i = k + 1;
          m = m << 18 | alphabet.decode(param1CharSequence.charAt(k)) << 12;
          k = j + 1;
          param1ArrayOfbyte[j] = (byte)(byte)(m >>> 16);
          if (i < param1CharSequence.length()) {
            alphabet = this.alphabet;
            j = i + 1;
            i = m | alphabet.decode(param1CharSequence.charAt(i)) << 6;
            m = k + 1;
            param1ArrayOfbyte[k] = (byte)(byte)(i >>> 8 & 0xFF);
            if (j < param1CharSequence.length()) {
              param1ArrayOfbyte[m] = (byte)(byte)((i | this.alphabet.decode(param1CharSequence.charAt(j))) & 0xFF);
              k = m + 1;
              i = j + 1;
              j = k;
              continue;
            } 
            i = j;
            j = m;
            continue;
          } 
        } 
        return j;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid input length ");
      stringBuilder.append(param1CharSequence.length());
      throw new BaseEncoding.DecodingException(stringBuilder.toString());
    }
    
    void encodeTo(Appendable param1Appendable, byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      Preconditions.checkNotNull(param1Appendable);
      int i = param1Int1 + param1Int2;
      Preconditions.checkPositionIndexes(param1Int1, i, param1ArrayOfbyte.length);
      while (param1Int2 >= 3) {
        int j = param1Int1 + 1;
        byte b = param1ArrayOfbyte[param1Int1];
        param1Int1 = j + 1;
        j = (b & 0xFF) << 16 | (param1ArrayOfbyte[j] & 0xFF) << 8 | param1ArrayOfbyte[param1Int1] & 0xFF;
        param1Appendable.append(this.alphabet.encode(j >>> 18));
        param1Appendable.append(this.alphabet.encode(j >>> 12 & 0x3F));
        param1Appendable.append(this.alphabet.encode(j >>> 6 & 0x3F));
        param1Appendable.append(this.alphabet.encode(j & 0x3F));
        param1Int2 -= 3;
        param1Int1++;
      } 
      if (param1Int1 < i)
        encodeChunkTo(param1Appendable, param1ArrayOfbyte, param1Int1, i - param1Int1); 
    }
    
    BaseEncoding newInstance(BaseEncoding.Alphabet param1Alphabet, @Nullable Character param1Character) {
      return new Base64Encoding(param1Alphabet, param1Character);
    }
  }
  
  public static final class DecodingException extends IOException {
    DecodingException(String param1String) {
      super(param1String);
    }
    
    DecodingException(Throwable param1Throwable) {
      super(param1Throwable);
    }
  }
  
  static final class SeparatedBaseEncoding extends BaseEncoding {
    private final int afterEveryChars;
    
    private final BaseEncoding delegate;
    
    private final String separator;
    
    private final CharMatcher separatorChars;
    
    SeparatedBaseEncoding(BaseEncoding param1BaseEncoding, String param1String, int param1Int) {
      boolean bool;
      this.delegate = (BaseEncoding)Preconditions.checkNotNull(param1BaseEncoding);
      this.separator = (String)Preconditions.checkNotNull(param1String);
      this.afterEveryChars = param1Int;
      if (param1Int > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "Cannot add a separator after every %s chars", param1Int);
      this.separatorChars = CharMatcher.anyOf(param1String).precomputed();
    }
    
    public boolean canDecode(CharSequence param1CharSequence) {
      return this.delegate.canDecode(this.separatorChars.removeFrom(param1CharSequence));
    }
    
    int decodeTo(byte[] param1ArrayOfbyte, CharSequence param1CharSequence) throws BaseEncoding.DecodingException {
      return this.delegate.decodeTo(param1ArrayOfbyte, this.separatorChars.removeFrom(param1CharSequence));
    }
    
    @GwtIncompatible
    public InputStream decodingStream(Reader param1Reader) {
      return this.delegate.decodingStream(ignoringReader(param1Reader, this.separatorChars));
    }
    
    void encodeTo(Appendable param1Appendable, byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      this.delegate.encodeTo(separatingAppendable(param1Appendable, this.separator, this.afterEveryChars), param1ArrayOfbyte, param1Int1, param1Int2);
    }
    
    @GwtIncompatible
    public OutputStream encodingStream(Writer param1Writer) {
      return this.delegate.encodingStream(separatingWriter(param1Writer, this.separator, this.afterEveryChars));
    }
    
    public BaseEncoding lowerCase() {
      return this.delegate.lowerCase().withSeparator(this.separator, this.afterEveryChars);
    }
    
    int maxDecodedSize(int param1Int) {
      return this.delegate.maxDecodedSize(param1Int);
    }
    
    int maxEncodedSize(int param1Int) {
      param1Int = this.delegate.maxEncodedSize(param1Int);
      return param1Int + this.separator.length() * IntMath.divide(Math.max(0, param1Int - 1), this.afterEveryChars, RoundingMode.FLOOR);
    }
    
    public BaseEncoding omitPadding() {
      return this.delegate.omitPadding().withSeparator(this.separator, this.afterEveryChars);
    }
    
    CharMatcher padding() {
      return this.delegate.padding();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.delegate);
      stringBuilder.append(".withSeparator(\"");
      stringBuilder.append(this.separator);
      stringBuilder.append("\", ");
      stringBuilder.append(this.afterEveryChars);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
    
    public BaseEncoding upperCase() {
      return this.delegate.upperCase().withSeparator(this.separator, this.afterEveryChars);
    }
    
    public BaseEncoding withPadChar(char param1Char) {
      return this.delegate.withPadChar(param1Char).withSeparator(this.separator, this.afterEveryChars);
    }
    
    public BaseEncoding withSeparator(String param1String, int param1Int) {
      throw new UnsupportedOperationException("Already have a separator");
    }
  }
  
  static class StandardBaseEncoding extends BaseEncoding {
    final BaseEncoding.Alphabet alphabet;
    
    private transient BaseEncoding lowerCase;
    
    @Nullable
    final Character paddingChar;
    
    private transient BaseEncoding upperCase;
    
    StandardBaseEncoding(BaseEncoding.Alphabet param1Alphabet, @Nullable Character param1Character) {
      boolean bool;
      this.alphabet = (BaseEncoding.Alphabet)Preconditions.checkNotNull(param1Alphabet);
      if (param1Character == null || !param1Alphabet.matches(param1Character.charValue())) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "Padding character %s was already in alphabet", param1Character);
      this.paddingChar = param1Character;
    }
    
    StandardBaseEncoding(String param1String1, String param1String2, @Nullable Character param1Character) {
      this(new BaseEncoding.Alphabet(param1String1, param1String2.toCharArray()), param1Character);
    }
    
    public boolean canDecode(CharSequence param1CharSequence) {
      param1CharSequence = padding().trimTrailingFrom(param1CharSequence);
      if (!this.alphabet.isValidPaddingStartPosition(param1CharSequence.length()))
        return false; 
      for (byte b = 0; b < param1CharSequence.length(); b++) {
        if (!this.alphabet.canDecode(param1CharSequence.charAt(b)))
          return false; 
      } 
      return true;
    }
    
    int decodeTo(byte[] param1ArrayOfbyte, CharSequence param1CharSequence) throws BaseEncoding.DecodingException {
      Preconditions.checkNotNull(param1ArrayOfbyte);
      param1CharSequence = padding().trimTrailingFrom(param1CharSequence);
      if (this.alphabet.isValidPaddingStartPosition(param1CharSequence.length())) {
        int i = 0;
        byte b = 0;
        while (i < param1CharSequence.length()) {
          long l = 0L;
          int j = 0;
          int k;
          for (k = 0; j < this.alphabet.charsPerChunk; k = i1) {
            long l1 = l << this.alphabet.bitsPerChar;
            int i1 = k;
            l = l1;
            if (i + j < param1CharSequence.length()) {
              l = l1 | this.alphabet.decode(param1CharSequence.charAt(k + i));
              i1 = k + 1;
            } 
            j++;
          } 
          int n = this.alphabet.bytesPerChunk;
          j = this.alphabet.bitsPerChar;
          int m = (this.alphabet.bytesPerChunk - 1) * 8;
          while (m >= n * 8 - k * j) {
            param1ArrayOfbyte[b] = (byte)(byte)(int)(l >>> m & 0xFFL);
            m -= 8;
            b++;
          } 
          i += this.alphabet.charsPerChunk;
        } 
        return b;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid input length ");
      stringBuilder.append(param1CharSequence.length());
      throw new BaseEncoding.DecodingException(stringBuilder.toString());
    }
    
    @GwtIncompatible
    public InputStream decodingStream(final Reader reader) {
      Preconditions.checkNotNull(reader);
      return new InputStream() {
          int bitBuffer = 0;
          
          int bitBufferLength = 0;
          
          boolean hitPadding = false;
          
          final CharMatcher paddingMatcher = BaseEncoding.StandardBaseEncoding.this.padding();
          
          int readChars = 0;
          
          public void close() throws IOException {
            reader.close();
          }
          
          public int read() throws IOException {
            while (true) {
              int i = reader.read();
              if (i == -1) {
                if (this.hitPadding || BaseEncoding.StandardBaseEncoding.this.alphabet.isValidPaddingStartPosition(this.readChars))
                  return -1; 
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append("Invalid input length ");
                stringBuilder1.append(this.readChars);
                throw new BaseEncoding.DecodingException(stringBuilder1.toString());
              } 
              this.readChars++;
              char c = (char)i;
              if (this.paddingMatcher.matches(c)) {
                if (this.hitPadding || (this.readChars != 1 && BaseEncoding.StandardBaseEncoding.this.alphabet.isValidPaddingStartPosition(this.readChars - 1))) {
                  this.hitPadding = true;
                  continue;
                } 
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append("Padding cannot start at index ");
                stringBuilder1.append(this.readChars);
                throw new BaseEncoding.DecodingException(stringBuilder1.toString());
              } 
              if (!this.hitPadding) {
                this.bitBuffer <<= BaseEncoding.StandardBaseEncoding.this.alphabet.bitsPerChar;
                i = this.bitBuffer;
                this.bitBuffer = BaseEncoding.StandardBaseEncoding.this.alphabet.decode(c) | i;
                this.bitBufferLength += BaseEncoding.StandardBaseEncoding.this.alphabet.bitsPerChar;
                i = this.bitBufferLength;
                if (i >= 8) {
                  this.bitBufferLength = i - 8;
                  return this.bitBuffer >> this.bitBufferLength & 0xFF;
                } 
                continue;
              } 
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Expected padding character but found '");
              stringBuilder.append(c);
              stringBuilder.append("' at index ");
              stringBuilder.append(this.readChars);
              throw new BaseEncoding.DecodingException(stringBuilder.toString());
            } 
          }
        };
    }
    
    void encodeChunkTo(Appendable param1Appendable, byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      boolean bool;
      Preconditions.checkNotNull(param1Appendable);
      Preconditions.checkPositionIndexes(param1Int1, param1Int1 + param1Int2, param1ArrayOfbyte.length);
      int i = this.alphabet.bytesPerChunk;
      int j = 0;
      if (param1Int2 <= i) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool);
      long l = 0L;
      for (i = 0; i < param1Int2; i++)
        l = (l | (param1ArrayOfbyte[param1Int1 + i] & 0xFF)) << 8L; 
      i = this.alphabet.bitsPerChar;
      for (param1Int1 = j; param1Int1 < param1Int2 * 8; param1Int1 += this.alphabet.bitsPerChar) {
        int k = (int)(l >>> (param1Int2 + 1) * 8 - i - param1Int1);
        j = this.alphabet.mask;
        param1Appendable.append(this.alphabet.encode(k & j));
      } 
      if (this.paddingChar != null)
        while (param1Int1 < this.alphabet.bytesPerChunk * 8) {
          param1Appendable.append(this.paddingChar.charValue());
          param1Int1 += this.alphabet.bitsPerChar;
        }  
    }
    
    void encodeTo(Appendable param1Appendable, byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      Preconditions.checkNotNull(param1Appendable);
      Preconditions.checkPositionIndexes(param1Int1, param1Int1 + param1Int2, param1ArrayOfbyte.length);
      int i;
      for (i = 0; i < param1Int2; i += this.alphabet.bytesPerChunk)
        encodeChunkTo(param1Appendable, param1ArrayOfbyte, param1Int1 + i, Math.min(this.alphabet.bytesPerChunk, param1Int2 - i)); 
    }
    
    @GwtIncompatible
    public OutputStream encodingStream(final Writer out) {
      Preconditions.checkNotNull(out);
      return new OutputStream() {
          int bitBuffer = 0;
          
          int bitBufferLength = 0;
          
          int writtenChars = 0;
          
          public void close() throws IOException {
            if (this.bitBufferLength > 0) {
              int i = this.bitBuffer;
              int j = BaseEncoding.StandardBaseEncoding.this.alphabet.bitsPerChar;
              int k = this.bitBufferLength;
              int m = BaseEncoding.StandardBaseEncoding.this.alphabet.mask;
              out.write(BaseEncoding.StandardBaseEncoding.this.alphabet.encode(i << j - k & m));
              this.writtenChars++;
              if (BaseEncoding.StandardBaseEncoding.this.paddingChar != null)
                while (this.writtenChars % BaseEncoding.StandardBaseEncoding.this.alphabet.charsPerChunk != 0) {
                  out.write(BaseEncoding.StandardBaseEncoding.this.paddingChar.charValue());
                  this.writtenChars++;
                }  
            } 
            out.close();
          }
          
          public void flush() throws IOException {
            out.flush();
          }
          
          public void write(int param2Int) throws IOException {
            this.bitBuffer <<= 8;
            this.bitBuffer = param2Int & 0xFF | this.bitBuffer;
            this.bitBufferLength += 8;
            while (this.bitBufferLength >= BaseEncoding.StandardBaseEncoding.this.alphabet.bitsPerChar) {
              int i = this.bitBuffer;
              int j = this.bitBufferLength;
              int k = BaseEncoding.StandardBaseEncoding.this.alphabet.bitsPerChar;
              param2Int = BaseEncoding.StandardBaseEncoding.this.alphabet.mask;
              out.write(BaseEncoding.StandardBaseEncoding.this.alphabet.encode(i >> j - k & param2Int));
              this.writtenChars++;
              this.bitBufferLength -= BaseEncoding.StandardBaseEncoding.this.alphabet.bitsPerChar;
            } 
          }
        };
    }
    
    public boolean equals(@Nullable Object param1Object) {
      boolean bool = param1Object instanceof StandardBaseEncoding;
      boolean bool1 = false;
      if (bool) {
        param1Object = param1Object;
        bool = bool1;
        if (this.alphabet.equals(((StandardBaseEncoding)param1Object).alphabet)) {
          bool = bool1;
          if (Objects.equal(this.paddingChar, ((StandardBaseEncoding)param1Object).paddingChar))
            bool = true; 
        } 
        return bool;
      } 
      return false;
    }
    
    public int hashCode() {
      return this.alphabet.hashCode() ^ Objects.hashCode(new Object[] { this.paddingChar });
    }
    
    public BaseEncoding lowerCase() {
      BaseEncoding baseEncoding1 = this.lowerCase;
      BaseEncoding baseEncoding2 = baseEncoding1;
      if (baseEncoding1 == null) {
        BaseEncoding.Alphabet alphabet = this.alphabet.lowerCase();
        if (alphabet == this.alphabet) {
          baseEncoding2 = this;
        } else {
          baseEncoding2 = newInstance((BaseEncoding.Alphabet)baseEncoding2, this.paddingChar);
        } 
        this.lowerCase = baseEncoding2;
      } 
      return baseEncoding2;
    }
    
    int maxDecodedSize(int param1Int) {
      return (int)((this.alphabet.bitsPerChar * param1Int + 7L) / 8L);
    }
    
    int maxEncodedSize(int param1Int) {
      return this.alphabet.charsPerChunk * IntMath.divide(param1Int, this.alphabet.bytesPerChunk, RoundingMode.CEILING);
    }
    
    BaseEncoding newInstance(BaseEncoding.Alphabet param1Alphabet, @Nullable Character param1Character) {
      return new StandardBaseEncoding(param1Alphabet, param1Character);
    }
    
    public BaseEncoding omitPadding() {
      BaseEncoding baseEncoding;
      if (this.paddingChar == null) {
        baseEncoding = this;
      } else {
        baseEncoding = newInstance(this.alphabet, null);
      } 
      return baseEncoding;
    }
    
    CharMatcher padding() {
      CharMatcher charMatcher;
      Character character = this.paddingChar;
      if (character == null) {
        charMatcher = CharMatcher.none();
      } else {
        charMatcher = CharMatcher.is(charMatcher.charValue());
      } 
      return charMatcher;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder("BaseEncoding.");
      stringBuilder.append(this.alphabet.toString());
      if (8 % this.alphabet.bitsPerChar != 0)
        if (this.paddingChar == null) {
          stringBuilder.append(".omitPadding()");
        } else {
          stringBuilder.append(".withPadChar('");
          stringBuilder.append(this.paddingChar);
          stringBuilder.append("')");
        }  
      return stringBuilder.toString();
    }
    
    public BaseEncoding upperCase() {
      BaseEncoding baseEncoding1 = this.upperCase;
      BaseEncoding baseEncoding2 = baseEncoding1;
      if (baseEncoding1 == null) {
        BaseEncoding.Alphabet alphabet = this.alphabet.upperCase();
        if (alphabet == this.alphabet) {
          baseEncoding2 = this;
        } else {
          baseEncoding2 = newInstance((BaseEncoding.Alphabet)baseEncoding2, this.paddingChar);
        } 
        this.upperCase = baseEncoding2;
      } 
      return baseEncoding2;
    }
    
    public BaseEncoding withPadChar(char param1Char) {
      if (8 % this.alphabet.bitsPerChar != 0) {
        Character character = this.paddingChar;
        if (character == null || character.charValue() != param1Char)
          return newInstance(this.alphabet, Character.valueOf(param1Char)); 
      } 
      return this;
    }
    
    public BaseEncoding withSeparator(String param1String, int param1Int) {
      Preconditions.checkArgument(padding().or(this.alphabet).matchesNoneOf(param1String), "Separator (%s) cannot contain alphabet or padding characters", param1String);
      return new BaseEncoding.SeparatedBaseEncoding(this, param1String, param1Int);
    }
  }
  
  class null extends OutputStream {
    int bitBuffer = 0;
    
    int bitBufferLength = 0;
    
    int writtenChars = 0;
    
    public void close() throws IOException {
      if (this.bitBufferLength > 0) {
        int i = this.bitBuffer;
        int j = this.this$0.alphabet.bitsPerChar;
        int k = this.bitBufferLength;
        int m = this.this$0.alphabet.mask;
        out.write(this.this$0.alphabet.encode(i << j - k & m));
        this.writtenChars++;
        if (this.this$0.paddingChar != null)
          while (this.writtenChars % this.this$0.alphabet.charsPerChunk != 0) {
            out.write(this.this$0.paddingChar.charValue());
            this.writtenChars++;
          }  
      } 
      out.close();
    }
    
    public void flush() throws IOException {
      out.flush();
    }
    
    public void write(int param1Int) throws IOException {
      this.bitBuffer <<= 8;
      this.bitBuffer = param1Int & 0xFF | this.bitBuffer;
      this.bitBufferLength += 8;
      while (this.bitBufferLength >= this.this$0.alphabet.bitsPerChar) {
        int i = this.bitBuffer;
        int j = this.bitBufferLength;
        int k = this.this$0.alphabet.bitsPerChar;
        param1Int = this.this$0.alphabet.mask;
        out.write(this.this$0.alphabet.encode(i >> j - k & param1Int));
        this.writtenChars++;
        this.bitBufferLength -= this.this$0.alphabet.bitsPerChar;
      } 
    }
  }
  
  class null extends InputStream {
    int bitBuffer = 0;
    
    int bitBufferLength = 0;
    
    boolean hitPadding = false;
    
    final CharMatcher paddingMatcher = this.this$0.padding();
    
    int readChars = 0;
    
    public void close() throws IOException {
      reader.close();
    }
    
    public int read() throws IOException {
      while (true) {
        int i = reader.read();
        if (i == -1) {
          if (this.hitPadding || this.this$0.alphabet.isValidPaddingStartPosition(this.readChars))
            return -1; 
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Invalid input length ");
          stringBuilder1.append(this.readChars);
          throw new BaseEncoding.DecodingException(stringBuilder1.toString());
        } 
        this.readChars++;
        char c = (char)i;
        if (this.paddingMatcher.matches(c)) {
          if (this.hitPadding || (this.readChars != 1 && this.this$0.alphabet.isValidPaddingStartPosition(this.readChars - 1))) {
            this.hitPadding = true;
            continue;
          } 
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Padding cannot start at index ");
          stringBuilder1.append(this.readChars);
          throw new BaseEncoding.DecodingException(stringBuilder1.toString());
        } 
        if (!this.hitPadding) {
          this.bitBuffer <<= this.this$0.alphabet.bitsPerChar;
          i = this.bitBuffer;
          this.bitBuffer = this.this$0.alphabet.decode(c) | i;
          this.bitBufferLength += this.this$0.alphabet.bitsPerChar;
          i = this.bitBufferLength;
          if (i >= 8) {
            this.bitBufferLength = i - 8;
            return this.bitBuffer >> this.bitBufferLength & 0xFF;
          } 
          continue;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected padding character but found '");
        stringBuilder.append(c);
        stringBuilder.append("' at index ");
        stringBuilder.append(this.readChars);
        throw new BaseEncoding.DecodingException(stringBuilder.toString());
      } 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\io\BaseEncoding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */