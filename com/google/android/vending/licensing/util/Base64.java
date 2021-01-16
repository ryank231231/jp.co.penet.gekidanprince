package com.google.android.vending.licensing.util;

public class Base64 {
  private static final byte[] ALPHABET = new byte[] { 
      65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
      75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
      85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
      101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
      111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
      121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
      56, 57, 43, 47 };
  
  private static final byte[] DECODABET;
  
  public static final boolean DECODE = false;
  
  public static final boolean ENCODE = true;
  
  private static final byte EQUALS_SIGN = 61;
  
  private static final byte EQUALS_SIGN_ENC = -1;
  
  private static final byte NEW_LINE = 10;
  
  private static final byte[] WEBSAFE_ALPHABET = new byte[] { 
      65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
      75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
      85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
      101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
      111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
      121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
      56, 57, 45, 95 };
  
  private static final byte[] WEBSAFE_DECODABET;
  
  private static final byte WHITE_SPACE_ENC = -5;
  
  static {
    DECODABET = new byte[] { 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
        -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -9, -9, 
        -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51, -9, -9, -9, -9, -9 };
    WEBSAFE_DECODABET = new byte[] { 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
        -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -9, -9, 
        -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51, -9, -9, -9, -9, -9 };
  }
  
  public static byte[] decode(String paramString) throws Base64DecoderException {
    byte[] arrayOfByte = paramString.getBytes();
    return decode(arrayOfByte, 0, arrayOfByte.length);
  }
  
  public static byte[] decode(byte[] paramArrayOfbyte) throws Base64DecoderException {
    return decode(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public static byte[] decode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws Base64DecoderException {
    return decode(paramArrayOfbyte, paramInt1, paramInt2, DECODABET);
  }
  
  public static byte[] decode(byte[] paramArrayOfbyte1, int paramInt1, int paramInt2, byte[] paramArrayOfbyte2) throws Base64DecoderException {
    StringBuilder stringBuilder;
    byte[] arrayOfByte1 = new byte[paramInt2 * 3 / 4 + 2];
    byte[] arrayOfByte2 = new byte[4];
    byte b = 0;
    int i = 0;
    int j = 0;
    while (b < paramInt2) {
      StringBuilder stringBuilder1;
      int k = b + paramInt1;
      byte b1 = (byte)(paramArrayOfbyte1[k] & Byte.MAX_VALUE);
      byte b2 = paramArrayOfbyte2[b1];
      if (b2 >= -5) {
        k = i;
        int m = j;
        if (b2 >= -1) {
          if (b1 == 61) {
            k = paramInt2 - b;
            paramInt1 = (byte)(paramArrayOfbyte1[paramInt2 - 1 + paramInt1] & Byte.MAX_VALUE);
            if (i && i != 1) {
              if ((i != 3 || k <= 2) && (i != 4 || k <= 1)) {
                if (paramInt1 == 61 || paramInt1 == 10)
                  break; 
                throw new Base64DecoderException("encoded value has invalid trailing byte");
              } 
              StringBuilder stringBuilder2 = new StringBuilder();
              stringBuilder2.append("padding byte '=' falsely signals end of encoded value at offset ");
              stringBuilder2.append(b);
              throw new Base64DecoderException(stringBuilder2.toString());
            } 
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("invalid padding byte '=' at byte offset ");
            stringBuilder1.append(b);
            throw new Base64DecoderException(stringBuilder1.toString());
          } 
          k = i + 1;
          arrayOfByte2[i] = (byte)b1;
          if (k == 4) {
            m = j + decode4to3(arrayOfByte2, 0, arrayOfByte1, j, paramArrayOfbyte2);
            k = 0;
          } else {
            m = j;
          } 
        } 
        b++;
        i = k;
        j = m;
        continue;
      } 
      stringBuilder = new StringBuilder();
      stringBuilder.append("Bad Base64 input character at ");
      stringBuilder.append(b);
      stringBuilder.append(": ");
      stringBuilder.append(stringBuilder1[k]);
      stringBuilder.append("(decimal)");
      throw new Base64DecoderException(stringBuilder.toString());
    } 
    paramInt1 = j;
    if (i != 0)
      if (i != 1) {
        arrayOfByte2[i] = (byte)61;
        paramInt1 = j + decode4to3(arrayOfByte2, 0, arrayOfByte1, j, (byte[])stringBuilder);
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("single trailing character at offset ");
        stringBuilder1.append(paramInt2 - 1);
        throw new Base64DecoderException(stringBuilder1.toString());
      }  
    paramArrayOfbyte1 = new byte[paramInt1];
    System.arraycopy(arrayOfByte1, 0, paramArrayOfbyte1, 0, paramInt1);
    return paramArrayOfbyte1;
  }
  
  private static int decode4to3(byte[] paramArrayOfbyte1, int paramInt1, byte[] paramArrayOfbyte2, int paramInt2, byte[] paramArrayOfbyte3) {
    int i = paramInt1 + 2;
    if (paramArrayOfbyte1[i] == 61) {
      i = paramArrayOfbyte3[paramArrayOfbyte1[paramInt1]];
      paramArrayOfbyte2[paramInt2] = (byte)(byte)((paramArrayOfbyte3[paramArrayOfbyte1[paramInt1 + 1]] << 24 >>> 12 | i << 24 >>> 6) >>> 16);
      return 1;
    } 
    int j = paramInt1 + 3;
    if (paramArrayOfbyte1[j] == 61) {
      j = paramArrayOfbyte3[paramArrayOfbyte1[paramInt1]];
      paramInt1 = paramArrayOfbyte3[paramArrayOfbyte1[paramInt1 + 1]];
      paramInt1 = paramArrayOfbyte3[paramArrayOfbyte1[i]] << 24 >>> 18 | paramInt1 << 24 >>> 12 | j << 24 >>> 6;
      paramArrayOfbyte2[paramInt2] = (byte)(byte)(paramInt1 >>> 16);
      paramArrayOfbyte2[paramInt2 + 1] = (byte)(byte)(paramInt1 >>> 8);
      return 2;
    } 
    byte b = paramArrayOfbyte3[paramArrayOfbyte1[paramInt1]];
    paramInt1 = paramArrayOfbyte3[paramArrayOfbyte1[paramInt1 + 1]];
    i = paramArrayOfbyte3[paramArrayOfbyte1[i]];
    paramInt1 = paramArrayOfbyte3[paramArrayOfbyte1[j]] << 24 >>> 24 | paramInt1 << 24 >>> 12 | b << 24 >>> 6 | i << 24 >>> 18;
    paramArrayOfbyte2[paramInt2] = (byte)(byte)(paramInt1 >> 16);
    paramArrayOfbyte2[paramInt2 + 1] = (byte)(byte)(paramInt1 >> 8);
    paramArrayOfbyte2[paramInt2 + 2] = (byte)(byte)paramInt1;
    return 3;
  }
  
  public static byte[] decodeWebSafe(String paramString) throws Base64DecoderException {
    byte[] arrayOfByte = paramString.getBytes();
    return decodeWebSafe(arrayOfByte, 0, arrayOfByte.length);
  }
  
  public static byte[] decodeWebSafe(byte[] paramArrayOfbyte) throws Base64DecoderException {
    return decodeWebSafe(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public static byte[] decodeWebSafe(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws Base64DecoderException {
    return decode(paramArrayOfbyte, paramInt1, paramInt2, WEBSAFE_DECODABET);
  }
  
  public static String encode(byte[] paramArrayOfbyte) {
    return encode(paramArrayOfbyte, 0, paramArrayOfbyte.length, ALPHABET, true);
  }
  
  public static String encode(byte[] paramArrayOfbyte1, int paramInt1, int paramInt2, byte[] paramArrayOfbyte2, boolean paramBoolean) {
    paramArrayOfbyte1 = encode(paramArrayOfbyte1, paramInt1, paramInt2, paramArrayOfbyte2, 2147483647);
    for (paramInt1 = paramArrayOfbyte1.length; !paramBoolean && paramInt1 > 0 && paramArrayOfbyte1[paramInt1 - 1] == 61; paramInt1--);
    return new String(paramArrayOfbyte1, 0, paramInt1);
  }
  
  public static byte[] encode(byte[] paramArrayOfbyte1, int paramInt1, int paramInt2, byte[] paramArrayOfbyte2, int paramInt3) {
    int i = (paramInt2 + 2) / 3 * 4;
    byte[] arrayOfByte = new byte[i + i / paramInt3];
    byte b = 0;
    i = 0;
    int j = 0;
    while (b < paramInt2 - 2) {
      int k = paramArrayOfbyte1[b + paramInt1] << 24 >>> 8 | paramArrayOfbyte1[b + 1 + paramInt1] << 24 >>> 16 | paramArrayOfbyte1[b + 2 + paramInt1] << 24 >>> 24;
      arrayOfByte[i] = (byte)paramArrayOfbyte2[k >>> 18];
      int m = i + 1;
      arrayOfByte[m] = (byte)paramArrayOfbyte2[k >>> 12 & 0x3F];
      arrayOfByte[i + 2] = (byte)paramArrayOfbyte2[k >>> 6 & 0x3F];
      arrayOfByte[i + 3] = (byte)paramArrayOfbyte2[k & 0x3F];
      j += true;
      if (j == paramInt3) {
        arrayOfByte[i + 4] = (byte)10;
        j = 0;
        i = m;
      } 
      b += 3;
      i += 4;
    } 
    if (b < paramInt2) {
      encode3to4(paramArrayOfbyte1, b + paramInt1, paramInt2 - b, arrayOfByte, i, paramArrayOfbyte2);
      if (j + 4 == paramInt3)
        arrayOfByte[i + 4] = (byte)10; 
    } 
    return arrayOfByte;
  }
  
  private static byte[] encode3to4(byte[] paramArrayOfbyte1, int paramInt1, int paramInt2, byte[] paramArrayOfbyte2, int paramInt3, byte[] paramArrayOfbyte3) {
    boolean bool1;
    boolean bool2;
    int i = 0;
    if (paramInt2 > 0) {
      bool1 = paramArrayOfbyte1[paramInt1] << 24 >>> 8;
    } else {
      bool1 = false;
    } 
    if (paramInt2 > 1) {
      bool2 = paramArrayOfbyte1[paramInt1 + 1] << 24 >>> 16;
    } else {
      bool2 = false;
    } 
    if (paramInt2 > 2)
      i = paramArrayOfbyte1[paramInt1 + 2] << 24 >>> 24; 
    paramInt1 = bool1 | bool2 | i;
    switch (paramInt2) {
      default:
        return paramArrayOfbyte2;
      case 3:
        paramArrayOfbyte2[paramInt3] = (byte)paramArrayOfbyte3[paramInt1 >>> 18];
        paramArrayOfbyte2[paramInt3 + 1] = (byte)paramArrayOfbyte3[paramInt1 >>> 12 & 0x3F];
        paramArrayOfbyte2[paramInt3 + 2] = (byte)paramArrayOfbyte3[paramInt1 >>> 6 & 0x3F];
        paramArrayOfbyte2[paramInt3 + 3] = (byte)paramArrayOfbyte3[paramInt1 & 0x3F];
        return paramArrayOfbyte2;
      case 2:
        paramArrayOfbyte2[paramInt3] = (byte)paramArrayOfbyte3[paramInt1 >>> 18];
        paramArrayOfbyte2[paramInt3 + 1] = (byte)paramArrayOfbyte3[paramInt1 >>> 12 & 0x3F];
        paramArrayOfbyte2[paramInt3 + 2] = (byte)paramArrayOfbyte3[paramInt1 >>> 6 & 0x3F];
        paramArrayOfbyte2[paramInt3 + 3] = (byte)61;
        return paramArrayOfbyte2;
      case 1:
        break;
    } 
    paramArrayOfbyte2[paramInt3] = (byte)paramArrayOfbyte3[paramInt1 >>> 18];
    paramArrayOfbyte2[paramInt3 + 1] = (byte)paramArrayOfbyte3[paramInt1 >>> 12 & 0x3F];
    paramArrayOfbyte2[paramInt3 + 2] = (byte)61;
    paramArrayOfbyte2[paramInt3 + 3] = (byte)61;
    return paramArrayOfbyte2;
  }
  
  public static String encodeWebSafe(byte[] paramArrayOfbyte, boolean paramBoolean) {
    return encode(paramArrayOfbyte, 0, paramArrayOfbyte.length, WEBSAFE_ALPHABET, paramBoolean);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\vending\licensin\\util\Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */