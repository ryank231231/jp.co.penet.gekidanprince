package io.grpc.okhttp.internal;

import javax.security.auth.x500.X500Principal;

final class DistinguishedNameParser {
  private int beg;
  
  private char[] chars;
  
  private int cur;
  
  private final String dn;
  
  private int end;
  
  private final int length;
  
  private int pos;
  
  public DistinguishedNameParser(X500Principal paramX500Principal) {
    this.dn = paramX500Principal.getName("RFC2253");
    this.length = this.dn.length();
  }
  
  private String escapedAV() {
    int i = this.pos;
    this.beg = i;
    this.end = i;
    while (true) {
      i = this.pos;
      if (i >= this.length) {
        char[] arrayOfChar2 = this.chars;
        i = this.beg;
        return new String(arrayOfChar2, i, this.end - i);
      } 
      char[] arrayOfChar1 = this.chars;
      char c = arrayOfChar1[i];
      if (c != ' ')
        if (c != ';') {
          if (c != '\\') {
            switch (c) {
              case '+':
              case ',':
                arrayOfChar1 = this.chars;
                i = this.beg;
                return new String(arrayOfChar1, i, this.end - i);
            } 
            continue;
          } 
          i = this.end;
          this.end = i + 1;
          arrayOfChar1[i] = getEscaped();
          this.pos++;
          continue;
        }  
      int j = this.end;
      this.cur = j;
      this.pos = i + 1;
      this.end = j + 1;
      arrayOfChar1[j] = (char)' ';
      while (true) {
        i = this.pos;
        if (i < this.length) {
          arrayOfChar1 = this.chars;
          if (arrayOfChar1[i] == ' ') {
            j = this.end;
            this.end = j + 1;
            arrayOfChar1[j] = (char)' ';
            this.pos = i + 1;
            continue;
          } 
        } 
        break;
      } 
      i = this.pos;
      if (i != this.length) {
        arrayOfChar1 = this.chars;
        if (arrayOfChar1[i] == ',' || arrayOfChar1[i] == '+' || arrayOfChar1[i] == ';')
          break; 
        continue;
      } 
      break;
    } 
    char[] arrayOfChar = this.chars;
    i = this.beg;
    return new String(arrayOfChar, i, this.cur - i);
  }
  
  private int getByte(int paramInt) {
    int i = paramInt + 1;
    if (i < this.length) {
      paramInt = this.chars[paramInt];
      if (paramInt >= 48 && paramInt <= 57) {
        paramInt -= 48;
      } else if (paramInt >= 97 && paramInt <= 102) {
        paramInt -= 87;
      } else if (paramInt >= 65 && paramInt <= 70) {
        paramInt -= 55;
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Malformed DN: ");
        stringBuilder1.append(this.dn);
        throw new IllegalStateException(stringBuilder1.toString());
      } 
      i = this.chars[i];
      if (i >= 48 && i <= 57) {
        i -= 48;
      } else if (i >= 97 && i <= 102) {
        i -= 87;
      } else {
        if (i >= 65 && i <= 70) {
          i -= 55;
          return (paramInt << 4) + i;
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Malformed DN: ");
        stringBuilder1.append(this.dn);
        throw new IllegalStateException(stringBuilder1.toString());
      } 
      return (paramInt << 4) + i;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Malformed DN: ");
    stringBuilder.append(this.dn);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  private char getEscaped() {
    int i = ++this.pos;
    if (i != this.length) {
      i = this.chars[i];
      if (i != 32 && i != 37 && i != 92 && i != 95)
        switch (i) {
          default:
            switch (i) {
              default:
                switch (i) {
                  default:
                    return getUTF8();
                  case 59:
                  case 60:
                  case 61:
                  case 62:
                    break;
                } 
                break;
              case 42:
              case 43:
              case 44:
                break;
            } 
            break;
          case 34:
          case 35:
            break;
        }  
      return this.chars[this.pos];
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unexpected end of DN: ");
    stringBuilder.append(this.dn);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  private char getUTF8() {
    int i = getByte(this.pos);
    this.pos++;
    if (i < 128)
      return (char)i; 
    if (i >= 192 && i <= 247) {
      byte b1;
      if (i <= 223) {
        i &= 0x1F;
        b1 = 1;
      } else if (i <= 239) {
        b1 = 2;
        i &= 0xF;
      } else {
        b1 = 3;
        i &= 0x7;
      } 
      for (byte b2 = 0; b2 < b1; b2++) {
        int j = ++this.pos;
        if (j == this.length || this.chars[j] != '\\')
          return '?'; 
        this.pos = j + 1;
        j = getByte(this.pos);
        this.pos++;
        if ((j & 0xC0) != 128)
          return '?'; 
        i = (i << 6) + (j & 0x3F);
      } 
      return (char)i;
    } 
    return '?';
  }
  
  private String hexAV() {
    int i = this.pos;
    if (i + 4 < this.length) {
      this.beg = i;
      this.pos = i + 1;
      while (true) {
        i = this.pos;
        if (i != this.length) {
          char[] arrayOfChar = this.chars;
          if (arrayOfChar[i] != '+' && arrayOfChar[i] != ',' && arrayOfChar[i] != ';') {
            if (arrayOfChar[i] == ' ') {
              this.end = i;
              this.pos = i + 1;
              while (true) {
                i = this.pos;
                if (i < this.length && this.chars[i] == ' ') {
                  this.pos = i + 1;
                  continue;
                } 
                break;
              } 
              break;
            } 
            if (arrayOfChar[i] >= 'A' && arrayOfChar[i] <= 'F')
              arrayOfChar[i] = (char)(char)(arrayOfChar[i] + 32); 
            this.pos++;
            continue;
          } 
        } 
        this.end = this.pos;
        break;
      } 
      i = this.end;
      int j = this.beg;
      int k = i - j;
      if (k >= 5 && (k & 0x1) != 0) {
        byte[] arrayOfByte = new byte[k / 2];
        i = 0;
        j++;
        while (i < arrayOfByte.length) {
          arrayOfByte[i] = (byte)(byte)getByte(j);
          j += 2;
          i++;
        } 
        return new String(this.chars, this.beg, k);
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Unexpected end of DN: ");
      stringBuilder1.append(this.dn);
      throw new IllegalStateException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unexpected end of DN: ");
    stringBuilder.append(this.dn);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  private String nextAT() {
    while (true) {
      int j = this.pos;
      if (j < this.length && this.chars[j] == ' ') {
        this.pos = j + 1;
        continue;
      } 
      break;
    } 
    int i = this.pos;
    if (i == this.length)
      return null; 
    this.beg = i;
    this.pos = i + 1;
    while (true) {
      i = this.pos;
      if (i < this.length) {
        char[] arrayOfChar = this.chars;
        if (arrayOfChar[i] != '=' && arrayOfChar[i] != ' ') {
          this.pos = i + 1;
          continue;
        } 
      } 
      break;
    } 
    i = this.pos;
    if (i < this.length) {
      this.end = i;
      if (this.chars[i] == ' ') {
        while (true) {
          i = this.pos;
          if (i < this.length) {
            char[] arrayOfChar2 = this.chars;
            if (arrayOfChar2[i] != '=' && arrayOfChar2[i] == ' ') {
              this.pos = i + 1;
              continue;
            } 
          } 
          break;
        } 
        char[] arrayOfChar1 = this.chars;
        i = this.pos;
        if (arrayOfChar1[i] != '=' || i == this.length) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Unexpected end of DN: ");
          stringBuilder1.append(this.dn);
          throw new IllegalStateException(stringBuilder1.toString());
        } 
      } 
      this.pos++;
      while (true) {
        i = this.pos;
        if (i < this.length && this.chars[i] == ' ') {
          this.pos = i + 1;
          continue;
        } 
        break;
      } 
      i = this.end;
      int j = this.beg;
      if (i - j > 4) {
        char[] arrayOfChar1 = this.chars;
        if (arrayOfChar1[j + 3] == '.' && (arrayOfChar1[j] == 'O' || arrayOfChar1[j] == 'o')) {
          arrayOfChar1 = this.chars;
          i = this.beg;
          if (arrayOfChar1[i + 1] == 'I' || arrayOfChar1[i + 1] == 'i') {
            arrayOfChar1 = this.chars;
            i = this.beg;
            if (arrayOfChar1[i + 2] == 'D' || arrayOfChar1[i + 2] == 'd')
              this.beg += 4; 
          } 
        } 
      } 
      char[] arrayOfChar = this.chars;
      i = this.beg;
      return new String(arrayOfChar, i, this.end - i);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unexpected end of DN: ");
    stringBuilder.append(this.dn);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  private String quotedAV() {
    this.beg = ++this.pos;
    this.end = this.beg;
    while (true) {
      int i = this.pos;
      if (i != this.length) {
        char[] arrayOfChar = this.chars;
        if (arrayOfChar[i] == '"') {
          this.pos = i + 1;
          while (true) {
            i = this.pos;
            if (i < this.length && this.chars[i] == ' ') {
              this.pos = i + 1;
              continue;
            } 
            break;
          } 
          arrayOfChar = this.chars;
          i = this.beg;
          return new String(arrayOfChar, i, this.end - i);
        } 
        if (arrayOfChar[i] == '\\') {
          arrayOfChar[this.end] = getEscaped();
        } else {
          arrayOfChar[this.end] = (char)arrayOfChar[i];
        } 
        this.pos++;
        this.end++;
        continue;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unexpected end of DN: ");
      stringBuilder.append(this.dn);
      throw new IllegalStateException(stringBuilder.toString());
    } 
  }
  
  public String findMostSpecific(String paramString) {
    this.pos = 0;
    this.beg = 0;
    this.end = 0;
    this.cur = 0;
    this.chars = this.dn.toCharArray();
    String str1 = nextAT();
    String str2 = str1;
    if (str1 == null)
      return null; 
    while (true) {
      str1 = "";
      int i = this.pos;
      if (i == this.length)
        return null; 
      switch (this.chars[i]) {
        default:
          str1 = escapedAV();
          break;
        case '#':
          str1 = hexAV();
          break;
        case '"':
          str1 = quotedAV();
          break;
        case '+':
        case ',':
        case ';':
          break;
      } 
      if (paramString.equalsIgnoreCase(str2))
        return str1; 
      i = this.pos;
      if (i >= this.length)
        return null; 
      char[] arrayOfChar = this.chars;
      if (arrayOfChar[i] == ',' || arrayOfChar[i] == ';' || arrayOfChar[i] == '+') {
        this.pos++;
        str2 = nextAT();
        if (str2 != null)
          continue; 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Malformed DN: ");
        stringBuilder1.append(this.dn);
        throw new IllegalStateException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Malformed DN: ");
      stringBuilder.append(this.dn);
      throw new IllegalStateException(stringBuilder.toString());
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\okhttp\internal\DistinguishedNameParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */