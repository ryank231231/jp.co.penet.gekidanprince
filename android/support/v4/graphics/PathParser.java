package android.support.v4.graphics;

import android.graphics.Path;
import android.support.annotation.RestrictTo;
import android.util.Log;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class PathParser {
  private static final String LOGTAG = "PathParser";
  
  private static void addNode(ArrayList<PathDataNode> paramArrayList, char paramChar, float[] paramArrayOffloat) {
    paramArrayList.add(new PathDataNode(paramChar, paramArrayOffloat));
  }
  
  public static boolean canMorph(PathDataNode[] paramArrayOfPathDataNode1, PathDataNode[] paramArrayOfPathDataNode2) {
    if (paramArrayOfPathDataNode1 == null || paramArrayOfPathDataNode2 == null)
      return false; 
    if (paramArrayOfPathDataNode1.length != paramArrayOfPathDataNode2.length)
      return false; 
    for (byte b = 0; b < paramArrayOfPathDataNode1.length; b++) {
      if ((paramArrayOfPathDataNode1[b]).mType != (paramArrayOfPathDataNode2[b]).mType || (paramArrayOfPathDataNode1[b]).mParams.length != (paramArrayOfPathDataNode2[b]).mParams.length)
        return false; 
    } 
    return true;
  }
  
  static float[] copyOfRange(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
    if (paramInt1 <= paramInt2) {
      int i = paramArrayOffloat.length;
      if (paramInt1 >= 0 && paramInt1 <= i) {
        paramInt2 -= paramInt1;
        i = Math.min(paramInt2, i - paramInt1);
        float[] arrayOfFloat = new float[paramInt2];
        System.arraycopy(paramArrayOffloat, paramInt1, arrayOfFloat, 0, i);
        return arrayOfFloat;
      } 
      throw new ArrayIndexOutOfBoundsException();
    } 
    throw new IllegalArgumentException();
  }
  
  public static PathDataNode[] createNodesFromPathData(String paramString) {
    if (paramString == null)
      return null; 
    ArrayList<PathDataNode> arrayList = new ArrayList();
    int i = 1;
    int j = 0;
    while (i < paramString.length()) {
      i = nextStart(paramString, i);
      String str = paramString.substring(j, i).trim();
      if (str.length() > 0) {
        float[] arrayOfFloat = getFloats(str);
        addNode(arrayList, str.charAt(0), arrayOfFloat);
      } 
      j = i;
      i++;
    } 
    if (i - j == 1 && j < paramString.length())
      addNode(arrayList, paramString.charAt(j), new float[0]); 
    return arrayList.<PathDataNode>toArray(new PathDataNode[arrayList.size()]);
  }
  
  public static Path createPathFromPathData(String paramString) {
    Path path = new Path();
    PathDataNode[] arrayOfPathDataNode = createNodesFromPathData(paramString);
    if (arrayOfPathDataNode != null)
      try {
        PathDataNode.nodesToPath(arrayOfPathDataNode, path);
        return path;
      } catch (RuntimeException runtimeException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error in parsing ");
        stringBuilder.append(paramString);
        throw new RuntimeException(stringBuilder.toString(), runtimeException);
      }  
    return null;
  }
  
  public static PathDataNode[] deepCopyNodes(PathDataNode[] paramArrayOfPathDataNode) {
    if (paramArrayOfPathDataNode == null)
      return null; 
    PathDataNode[] arrayOfPathDataNode = new PathDataNode[paramArrayOfPathDataNode.length];
    for (byte b = 0; b < paramArrayOfPathDataNode.length; b++)
      arrayOfPathDataNode[b] = new PathDataNode(paramArrayOfPathDataNode[b]); 
    return arrayOfPathDataNode;
  }
  
  private static void extract(String paramString, int paramInt, ExtractFloatResult paramExtractFloatResult) {
    paramExtractFloatResult.mEndWithNegOrDot = false;
    int i = paramInt;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    while (i < paramString.length()) {
      char c = paramString.charAt(i);
      if (c != ' ') {
        if (c != 'E' && c != 'e') {
          switch (c) {
            default:
              bool1 = false;
              break;
            case '.':
              if (!bool2) {
                bool1 = false;
                bool2 = true;
                break;
              } 
              paramExtractFloatResult.mEndWithNegOrDot = true;
              bool1 = false;
              bool3 = true;
              break;
            case '-':
              if (i != paramInt && !bool1) {
                paramExtractFloatResult.mEndWithNegOrDot = true;
                bool1 = false;
                bool3 = true;
                break;
              } 
            case ',':
              bool1 = false;
              bool3 = true;
              break;
          } 
        } else {
          bool1 = true;
        } 
        if (bool3)
          break; 
        i++;
      } 
    } 
    paramExtractFloatResult.mEndPosition = i;
  }
  
  private static float[] getFloats(String paramString) {
    if (paramString.charAt(0) == 'z' || paramString.charAt(0) == 'Z')
      return new float[0]; 
    try {
      float[] arrayOfFloat = new float[paramString.length()];
      ExtractFloatResult extractFloatResult = new ExtractFloatResult();
      this();
      int i = paramString.length();
      int j = 1;
      int k;
      for (k = 0; j < i; k = n) {
        extract(paramString, j, extractFloatResult);
        int m = extractFloatResult.mEndPosition;
        int n = k;
        if (j < m) {
          arrayOfFloat[k] = Float.parseFloat(paramString.substring(j, m));
          n = k + 1;
        } 
        if (extractFloatResult.mEndWithNegOrDot) {
          j = m;
          k = n;
          continue;
        } 
        j = m + 1;
      } 
      return copyOfRange(arrayOfFloat, 0, k);
    } catch (NumberFormatException numberFormatException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("error in parsing \"");
      stringBuilder.append(paramString);
      stringBuilder.append("\"");
      throw new RuntimeException(stringBuilder.toString(), numberFormatException);
    } 
  }
  
  private static int nextStart(String paramString, int paramInt) {
    while (paramInt < paramString.length()) {
      char c = paramString.charAt(paramInt);
      if (((c - 65) * (c - 90) <= 0 || (c - 97) * (c - 122) <= 0) && c != 'e' && c != 'E')
        return paramInt; 
      paramInt++;
    } 
    return paramInt;
  }
  
  public static void updateNodes(PathDataNode[] paramArrayOfPathDataNode1, PathDataNode[] paramArrayOfPathDataNode2) {
    for (byte b = 0; b < paramArrayOfPathDataNode2.length; b++) {
      (paramArrayOfPathDataNode1[b]).mType = (char)(paramArrayOfPathDataNode2[b]).mType;
      for (byte b1 = 0; b1 < (paramArrayOfPathDataNode2[b]).mParams.length; b1++)
        (paramArrayOfPathDataNode1[b]).mParams[b1] = (paramArrayOfPathDataNode2[b]).mParams[b1]; 
    } 
  }
  
  private static class ExtractFloatResult {
    int mEndPosition;
    
    boolean mEndWithNegOrDot;
  }
  
  public static class PathDataNode {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float[] mParams;
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public char mType;
    
    PathDataNode(char param1Char, float[] param1ArrayOffloat) {
      this.mType = (char)param1Char;
      this.mParams = param1ArrayOffloat;
    }
    
    PathDataNode(PathDataNode param1PathDataNode) {
      this.mType = (char)param1PathDataNode.mType;
      float[] arrayOfFloat = param1PathDataNode.mParams;
      this.mParams = PathParser.copyOfRange(arrayOfFloat, 0, arrayOfFloat.length);
    }
    
    private static void addCommand(Path param1Path, float[] param1ArrayOffloat1, int param1Char1, int param1Char2, float[] param1ArrayOffloat2) {
      int i;
      byte b;
      Path path = param1Path;
      float f1 = param1ArrayOffloat1[0];
      float f2 = param1ArrayOffloat1[1];
      float f3 = param1ArrayOffloat1[2];
      float f4 = param1ArrayOffloat1[3];
      float f5 = param1ArrayOffloat1[4];
      float f6 = param1ArrayOffloat1[5];
      switch (param1Char2) {
        default:
          b = 2;
          break;
        case 'Z':
        case 'z':
          param1Path.close();
          path.moveTo(f5, f6);
          f1 = f5;
          f3 = f1;
          f2 = f6;
          f4 = f2;
          b = 2;
          break;
        case 'Q':
        case 'S':
        case 'q':
        case 's':
          b = 4;
          break;
        case 'L':
        case 'M':
        case 'T':
        case 'l':
        case 'm':
        case 't':
          b = 2;
          break;
        case 'H':
        case 'V':
        case 'h':
        case 'v':
          b = 1;
          break;
        case 'C':
        case 'c':
          b = 6;
          break;
        case 'A':
        case 'a':
          b = 7;
          break;
      } 
      float f7 = f5;
      int j = 0;
      int k = param1Char1;
      f5 = f6;
      f6 = f7;
      param1Char1 = j;
      while (i < param1ArrayOffloat2.length) {
        int m;
        int n;
        float f8;
        float f9;
        int i1;
        int i2;
        boolean bool1;
        boolean bool2;
        f7 = 0.0F;
        switch (param1Char2) {
          case 'v':
            k = i + 0;
            path.rLineTo(0.0F, param1ArrayOffloat2[k]);
            f2 += param1ArrayOffloat2[k];
            break;
          case 't':
            if (k == 113 || k == 116 || k == 81 || k == 84) {
              f3 = f1 - f3;
              f4 = f2 - f4;
            } else {
              f4 = 0.0F;
              f3 = f7;
            } 
            k = i + 0;
            f7 = param1ArrayOffloat2[k];
            j = i + 1;
            path.rQuadTo(f3, f4, f7, param1ArrayOffloat2[j]);
            f7 = f1 + param1ArrayOffloat2[k];
            f8 = f2 + param1ArrayOffloat2[j];
            f4 += f2;
            f3 += f1;
            f2 = f8;
            f1 = f7;
            break;
          case 's':
            if (k == 99 || k == 115 || k == 67 || k == 83) {
              f4 = f2 - f4;
              f3 = f1 - f3;
            } else {
              f3 = 0.0F;
              f4 = 0.0F;
            } 
            n = i + 0;
            f8 = param1ArrayOffloat2[n];
            m = i + 1;
            f9 = param1ArrayOffloat2[m];
            i1 = i + 2;
            f7 = param1ArrayOffloat2[i1];
            i2 = i + 3;
            param1Path.rCubicTo(f3, f4, f8, f9, f7, param1ArrayOffloat2[i2]);
            f3 = param1ArrayOffloat2[n];
            f4 = param1ArrayOffloat2[m];
            f7 = f1 + param1ArrayOffloat2[i1];
            f8 = f2 + param1ArrayOffloat2[i2];
            f3 += f1;
            f4 += f2;
            f2 = f8;
            f1 = f7;
            break;
          case 'q':
            i2 = i + 0;
            f3 = param1ArrayOffloat2[i2];
            m = i + 1;
            f7 = param1ArrayOffloat2[m];
            i1 = i + 2;
            f4 = param1ArrayOffloat2[i1];
            n = i + 3;
            path.rQuadTo(f3, f7, f4, param1ArrayOffloat2[n]);
            f3 = param1ArrayOffloat2[i2];
            f4 = param1ArrayOffloat2[m];
            f7 = f1 + param1ArrayOffloat2[i1];
            f8 = f2 + param1ArrayOffloat2[n];
            f3 += f1;
            f4 += f2;
            f2 = f8;
            f1 = f7;
            break;
          case 'm':
            m = i + 0;
            f1 += param1ArrayOffloat2[m];
            n = i + 1;
            f2 += param1ArrayOffloat2[n];
            if (i > 0) {
              path.rLineTo(param1ArrayOffloat2[m], param1ArrayOffloat2[n]);
              break;
            } 
            path.rMoveTo(param1ArrayOffloat2[m], param1ArrayOffloat2[n]);
            f5 = f2;
            f6 = f1;
            break;
          case 'l':
            n = i + 0;
            f7 = param1ArrayOffloat2[n];
            m = i + 1;
            path.rLineTo(f7, param1ArrayOffloat2[m]);
            f1 += param1ArrayOffloat2[n];
            f2 += param1ArrayOffloat2[m];
            break;
          case 'h':
            n = i + 0;
            path.rLineTo(param1ArrayOffloat2[n], 0.0F);
            f1 += param1ArrayOffloat2[n];
            break;
          case 'c':
            f3 = param1ArrayOffloat2[i + 0];
            f9 = param1ArrayOffloat2[i + 1];
            i1 = i + 2;
            f4 = param1ArrayOffloat2[i1];
            i2 = i + 3;
            f7 = param1ArrayOffloat2[i2];
            n = i + 4;
            f8 = param1ArrayOffloat2[n];
            m = i + 5;
            param1Path.rCubicTo(f3, f9, f4, f7, f8, param1ArrayOffloat2[m]);
            f3 = param1ArrayOffloat2[i1];
            f4 = param1ArrayOffloat2[i2];
            f7 = f1 + param1ArrayOffloat2[n];
            f8 = f2 + param1ArrayOffloat2[m];
            f3 += f1;
            f4 += f2;
            f2 = f8;
            f1 = f7;
            break;
          case 'a':
            n = i + 5;
            f3 = param1ArrayOffloat2[n];
            m = i + 6;
            f4 = param1ArrayOffloat2[m];
            f7 = param1ArrayOffloat2[i + 0];
            f8 = param1ArrayOffloat2[i + 1];
            f9 = param1ArrayOffloat2[i + 2];
            if (param1ArrayOffloat2[i + 3] != 0.0F) {
              bool1 = true;
            } else {
              bool1 = false;
            } 
            if (param1ArrayOffloat2[i + 4] != 0.0F) {
              bool2 = true;
            } else {
              bool2 = false;
            } 
            drawArc(param1Path, f1, f2, f3 + f1, f4 + f2, f7, f8, f9, bool1, bool2);
            f1 += param1ArrayOffloat2[n];
            f2 += param1ArrayOffloat2[m];
            f4 = f2;
            f3 = f1;
            path = param1Path;
            break;
          case 'V':
            n = i + 0;
            f2 = param1ArrayOffloat2[n];
            path = param1Path;
            path.lineTo(f1, f2);
            f2 = param1ArrayOffloat2[n];
            break;
          case 'T':
            f8 = f2;
            f7 = f1;
            m = i;
          case 'S':
            m = i;
            if (n == 99 || n == 115 || n == 67 || n == 83) {
              f2 = f2 * 2.0F - f4;
              f3 = f1 * 2.0F - f3;
              f1 = f2;
              f2 = f3;
            } else {
              f3 = f2;
              f2 = f1;
              f1 = f3;
            } 
            i2 = m + 0;
            f7 = param1ArrayOffloat2[i2];
            n = m + 1;
            f3 = param1ArrayOffloat2[n];
            i1 = m + 2;
            f4 = param1ArrayOffloat2[i1];
            m += 3;
            param1Path.cubicTo(f2, f1, f7, f3, f4, param1ArrayOffloat2[m]);
            f3 = param1ArrayOffloat2[i2];
            f4 = param1ArrayOffloat2[n];
            f1 = param1ArrayOffloat2[i1];
            f2 = param1ArrayOffloat2[m];
            break;
          case 'Q':
            n = i;
            i2 = n + 0;
            f3 = param1ArrayOffloat2[i2];
            m = n + 1;
            f1 = param1ArrayOffloat2[m];
            i1 = n + 2;
            f2 = param1ArrayOffloat2[i1];
            n += 3;
            path.quadTo(f3, f1, f2, param1ArrayOffloat2[n]);
            f3 = param1ArrayOffloat2[i2];
            f4 = param1ArrayOffloat2[m];
            f1 = param1ArrayOffloat2[i1];
            f2 = param1ArrayOffloat2[n];
            break;
          case 'M':
            n = i;
            m = n + 0;
            f1 = param1ArrayOffloat2[m];
            i1 = n + 1;
            f2 = param1ArrayOffloat2[i1];
            if (n > 0) {
              path.lineTo(param1ArrayOffloat2[m], param1ArrayOffloat2[i1]);
              break;
            } 
            path.moveTo(param1ArrayOffloat2[m], param1ArrayOffloat2[i1]);
            f5 = f2;
            f6 = f1;
            break;
          case 'L':
            n = i;
            m = n + 0;
            f2 = param1ArrayOffloat2[m];
            path.lineTo(f2, param1ArrayOffloat2[++n]);
            f1 = param1ArrayOffloat2[m];
            f2 = param1ArrayOffloat2[n];
            break;
          case 'H':
            n = i + 0;
            path.lineTo(param1ArrayOffloat2[n], f2);
            f1 = param1ArrayOffloat2[n];
            break;
          case 'C':
            n = i;
            f4 = param1ArrayOffloat2[n + 0];
            f7 = param1ArrayOffloat2[n + 1];
            i2 = n + 2;
            f2 = param1ArrayOffloat2[i2];
            m = n + 3;
            f3 = param1ArrayOffloat2[m];
            i1 = n + 4;
            f1 = param1ArrayOffloat2[i1];
            n += 5;
            param1Path.cubicTo(f4, f7, f2, f3, f1, param1ArrayOffloat2[n]);
            f1 = param1ArrayOffloat2[i1];
            f2 = param1ArrayOffloat2[n];
            f3 = param1ArrayOffloat2[i2];
            f4 = param1ArrayOffloat2[m];
            break;
          case 'A':
            n = i;
            m = n + 5;
            f8 = param1ArrayOffloat2[m];
            i1 = n + 6;
            f9 = param1ArrayOffloat2[i1];
            f3 = param1ArrayOffloat2[n + 0];
            f4 = param1ArrayOffloat2[n + 1];
            f7 = param1ArrayOffloat2[n + 2];
            if (param1ArrayOffloat2[n + 3] != 0.0F) {
              bool1 = true;
            } else {
              bool1 = false;
            } 
            if (param1ArrayOffloat2[n + 4] != 0.0F) {
              bool2 = true;
            } else {
              bool2 = false;
            } 
            drawArc(param1Path, f1, f2, f8, f9, f3, f4, f7, bool1, bool2);
            f1 = param1ArrayOffloat2[m];
            f2 = param1ArrayOffloat2[i1];
            f4 = f2;
            f3 = f1;
            break;
        } 
        continue;
        i = param1Char1 + b;
        k = param1Char2;
      } 
      param1ArrayOffloat1[0] = f1;
      param1ArrayOffloat1[1] = f2;
      param1ArrayOffloat1[2] = f3;
      param1ArrayOffloat1[3] = f4;
      param1ArrayOffloat1[4] = f6;
      param1ArrayOffloat1[5] = f5;
    }
    
    private static void arcToBezier(Path param1Path, double param1Double1, double param1Double2, double param1Double3, double param1Double4, double param1Double5, double param1Double6, double param1Double7, double param1Double8, double param1Double9) {
      int i = (int)Math.ceil(Math.abs(param1Double9 * 4.0D / Math.PI));
      double d1 = Math.cos(param1Double7);
      double d2 = Math.sin(param1Double7);
      param1Double7 = Math.cos(param1Double8);
      double d3 = Math.sin(param1Double8);
      double d4 = -param1Double3;
      double d5 = d4 * d1;
      double d6 = param1Double4 * d2;
      d4 *= d2;
      double d7 = param1Double4 * d1;
      param1Double4 = i;
      Double.isNaN(param1Double4);
      param1Double9 /= param1Double4;
      param1Double4 = param1Double6;
      param1Double6 = d3 * d4 + param1Double7 * d7;
      d3 = d5 * d3 - d6 * param1Double7;
      byte b = 0;
      double d8 = param1Double8;
      param1Double8 = param1Double4;
      param1Double7 = param1Double5;
      param1Double4 = d4;
      d4 = param1Double9;
      param1Double5 = d2;
      param1Double9 = d1;
      while (true) {
        d2 = param1Double3;
        if (b < i) {
          double d9 = d8 + d4;
          double d10 = Math.sin(d9);
          double d11 = Math.cos(d9);
          d1 = param1Double1 + d2 * param1Double9 * d11 - d6 * d10;
          double d12 = param1Double2 + d2 * param1Double5 * d11 + d7 * d10;
          d2 = d5 * d10 - d6 * d11;
          d11 = d10 * param1Double4 + d11 * d7;
          d10 = d9 - d8;
          d8 = Math.tan(d10 / 2.0D);
          d8 = Math.sin(d10) * (Math.sqrt(d8 * 3.0D * d8 + 4.0D) - 1.0D) / 3.0D;
          param1Path.rLineTo(0.0F, 0.0F);
          param1Path.cubicTo((float)(param1Double7 + d3 * d8), (float)(param1Double8 + param1Double6 * d8), (float)(d1 - d8 * d2), (float)(d12 - d8 * d11), (float)d1, (float)d12);
          b++;
          param1Double8 = d12;
          d8 = d9;
          param1Double6 = d11;
          d3 = d2;
          param1Double7 = d1;
          continue;
        } 
        break;
      } 
    }
    
    private static void drawArc(Path param1Path, float param1Float1, float param1Float2, float param1Float3, float param1Float4, float param1Float5, float param1Float6, float param1Float7, boolean param1Boolean1, boolean param1Boolean2) {
      double d1 = Math.toRadians(param1Float7);
      double d2 = Math.cos(d1);
      double d3 = Math.sin(d1);
      double d4 = param1Float1;
      Double.isNaN(d4);
      double d5 = param1Float2;
      Double.isNaN(d5);
      double d6 = param1Float5;
      Double.isNaN(d6);
      double d7 = (d4 * d2 + d5 * d3) / d6;
      double d8 = -param1Float1;
      Double.isNaN(d8);
      Double.isNaN(d5);
      double d9 = param1Float6;
      Double.isNaN(d9);
      double d10 = (d8 * d3 + d5 * d2) / d9;
      double d11 = param1Float3;
      Double.isNaN(d11);
      d8 = param1Float4;
      Double.isNaN(d8);
      Double.isNaN(d6);
      double d12 = (d11 * d2 + d8 * d3) / d6;
      d11 = -param1Float3;
      Double.isNaN(d11);
      Double.isNaN(d8);
      Double.isNaN(d9);
      double d13 = (d11 * d3 + d8 * d2) / d9;
      double d14 = d7 - d12;
      double d15 = d10 - d13;
      d11 = (d7 + d12) / 2.0D;
      d8 = (d10 + d13) / 2.0D;
      double d16 = d14 * d14 + d15 * d15;
      if (d16 == 0.0D) {
        Log.w("PathParser", " Points are coincident");
        return;
      } 
      double d17 = 1.0D / d16 - 0.25D;
      if (d17 < 0.0D) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Points are too far apart ");
        stringBuilder.append(d16);
        Log.w("PathParser", stringBuilder.toString());
        float f = (float)(Math.sqrt(d16) / 1.99999D);
        drawArc(param1Path, param1Float1, param1Float2, param1Float3, param1Float4, param1Float5 * f, param1Float6 * f, param1Float7, param1Boolean1, param1Boolean2);
        return;
      } 
      d17 = Math.sqrt(d17);
      d14 *= d17;
      d15 = d17 * d15;
      if (param1Boolean1 == param1Boolean2) {
        d11 -= d15;
        d8 += d14;
      } else {
        d11 += d15;
        d8 -= d14;
      } 
      d14 = Math.atan2(d10 - d8, d7 - d11);
      d10 = Math.atan2(d13 - d8, d12 - d11) - d14;
      if (d10 >= 0.0D) {
        param1Boolean1 = true;
      } else {
        param1Boolean1 = false;
      } 
      d7 = d10;
      if (param1Boolean2 != param1Boolean1)
        if (d10 > 0.0D) {
          d7 = d10 - 6.283185307179586D;
        } else {
          d7 = d10 + 6.283185307179586D;
        }  
      Double.isNaN(d6);
      d11 *= d6;
      Double.isNaN(d9);
      d8 *= d9;
      arcToBezier(param1Path, d11 * d2 - d8 * d3, d11 * d3 + d8 * d2, d6, d9, d4, d5, d1, d14, d7);
    }
    
    public static void nodesToPath(PathDataNode[] param1ArrayOfPathDataNode, Path param1Path) {
      float[] arrayOfFloat = new float[6];
      char c1 = 'm';
      byte b = 0;
      char c2;
      for (c2 = c1; b < param1ArrayOfPathDataNode.length; c2 = c1) {
        addCommand(param1Path, arrayOfFloat, c2, (param1ArrayOfPathDataNode[b]).mType, (param1ArrayOfPathDataNode[b]).mParams);
        c1 = (param1ArrayOfPathDataNode[b]).mType;
        b++;
      } 
    }
    
    public void interpolatePathDataNode(PathDataNode param1PathDataNode1, PathDataNode param1PathDataNode2, float param1Float) {
      byte b = 0;
      while (true) {
        float[] arrayOfFloat = param1PathDataNode1.mParams;
        if (b < arrayOfFloat.length) {
          this.mParams[b] = arrayOfFloat[b] * (1.0F - param1Float) + param1PathDataNode2.mParams[b] * param1Float;
          b++;
          continue;
        } 
        break;
      } 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\v4\graphics\PathParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */