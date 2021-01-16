package okio;

import java.io.UnsupportedEncodingException;

final class Base64 {
  private static final byte[] MAP = new byte[] { 
      65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
      75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
      85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
      101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
      111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
      121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
      56, 57, 43, 47 };
  
  private static final byte[] URL_MAP = new byte[] { 
      65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
      75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
      85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
      101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
      111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
      121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
      56, 57, 45, 95 };
  
  public static byte[] decode(String paramString) {
    int j;
    int i;
    for (i = paramString.length(); i > 0; i--) {
      j = paramString.charAt(i - 1);
      if (j != 61 && j != 10 && j != 13 && j != 32 && j != 9)
        break; 
    } 
    byte[] arrayOfByte2 = new byte[(int)(i * 6L / 8L)];
    int k = 0;
    byte b = 0;
    int m = 0;
    int n;
    for (n = 0;; n = i1) {
      byte b1;
      int i1;
      if (k < i) {
        char c = paramString.charAt(k);
        if (c >= 'A' && c <= 'Z') {
          j = c - 65;
        } else if (c >= 'a' && c <= 'z') {
          j = c - 71;
        } else if (c >= '0' && c <= '9') {
          j = c + 4;
        } else if (c == '+' || c == '-') {
          j = 62;
        } else if (c == '/' || c == '_') {
          j = 63;
        } else {
          byte b2 = b;
          j = m;
          int i2 = n;
          if (c != '\n') {
            b2 = b;
            j = m;
            i2 = n;
            if (c != '\r') {
              b2 = b;
              j = m;
              i2 = n;
              if (c != ' ')
                if (c == '\t') {
                  b2 = b;
                  j = m;
                  i2 = n;
                } else {
                  return null;
                }  
            } 
          } 
          k++;
          b = b2;
          m = j;
          n = i2;
        } 
        m = m << 6 | (byte)j;
        b1 = ++b;
        j = m;
        i1 = n;
        if (b % 4 == 0) {
          j = n + 1;
          arrayOfByte2[n] = (byte)(byte)(m >> 16);
          n = j + 1;
          arrayOfByte2[j] = (byte)(byte)(m >> 8);
          arrayOfByte2[n] = (byte)(byte)m;
          i1 = n + 1;
          j = m;
          b1 = b;
        } 
      } else {
        break;
      } 
      k++;
      b = b1;
      m = j;
    } 
    i = b % 4;
    if (i == 1)
      return null; 
    if (i == 2) {
      arrayOfByte2[n] = (byte)(byte)(m << 12 >> 16);
      j = n + 1;
    } else {
      j = n;
      if (i == 3) {
        i = m << 6;
        k = n + 1;
        arrayOfByte2[n] = (byte)(byte)(i >> 16);
        j = k + 1;
        arrayOfByte2[k] = (byte)(byte)(i >> 8);
      } 
    } 
    if (j == arrayOfByte2.length)
      return arrayOfByte2; 
    byte[] arrayOfByte1 = new byte[j];
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, j);
    return arrayOfByte1;
  }
  
  public static String encode(byte[] paramArrayOfbyte) {
    return encode(paramArrayOfbyte, MAP);
  }
  
  private static String encode(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    int m;
    byte[] arrayOfByte = new byte[(paramArrayOfbyte1.length + 2) / 3 * 4];
    int i = paramArrayOfbyte1.length - paramArrayOfbyte1.length % 3;
    int j = 0;
    int k = 0;
    while (j < i) {
      int n = k + 1;
      arrayOfByte[k] = (byte)paramArrayOfbyte2[(paramArrayOfbyte1[j] & 0xFF) >> 2];
      k = n + 1;
      byte b = paramArrayOfbyte1[j];
      int i1 = j + 1;
      arrayOfByte[n] = (byte)paramArrayOfbyte2[(b & 0x3) << 4 | (paramArrayOfbyte1[i1] & 0xFF) >> 4];
      n = k + 1;
      b = paramArrayOfbyte1[i1];
      i1 = j + 2;
      arrayOfByte[k] = (byte)paramArrayOfbyte2[(b & 0xF) << 2 | (paramArrayOfbyte1[i1] & 0xFF) >> 6];
      k = n + 1;
      arrayOfByte[n] = (byte)paramArrayOfbyte2[paramArrayOfbyte1[i1] & 0x3F];
      j += 3;
    } 
    switch (paramArrayOfbyte1.length % 3) {
      case 2:
        j = k + 1;
        arrayOfByte[k] = (byte)paramArrayOfbyte2[(paramArrayOfbyte1[i] & 0xFF) >> 2];
        m = j + 1;
        k = paramArrayOfbyte1[i];
        arrayOfByte[j] = (byte)paramArrayOfbyte2[(k & 0x3) << 4 | (paramArrayOfbyte1[++i] & 0xFF) >> 4];
        arrayOfByte[m] = (byte)paramArrayOfbyte2[(paramArrayOfbyte1[i] & 0xF) << 2];
        arrayOfByte[m + 1] = (byte)61;
        break;
      case 1:
        j = k + 1;
        arrayOfByte[k] = (byte)paramArrayOfbyte2[(paramArrayOfbyte1[i] & 0xFF) >> 2];
        k = j + 1;
        arrayOfByte[j] = (byte)paramArrayOfbyte2[(paramArrayOfbyte1[i] & 0x3) << 4];
        arrayOfByte[k] = (byte)61;
        arrayOfByte[k + 1] = (byte)61;
        break;
    } 
    try {
      return new String(arrayOfByte, "US-ASCII");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new AssertionError(unsupportedEncodingException);
    } 
  }
  
  public static String encodeUrl(byte[] paramArrayOfbyte) {
    return encode(paramArrayOfbyte, URL_MAP);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\okio\Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */