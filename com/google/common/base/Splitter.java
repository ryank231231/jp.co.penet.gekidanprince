package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@GwtCompatible(emulated = true)
public final class Splitter {
  private final int limit;
  
  private final boolean omitEmptyStrings;
  
  private final Strategy strategy;
  
  private final CharMatcher trimmer;
  
  private Splitter(Strategy paramStrategy) {
    this(paramStrategy, false, CharMatcher.none(), 2147483647);
  }
  
  private Splitter(Strategy paramStrategy, boolean paramBoolean, CharMatcher paramCharMatcher, int paramInt) {
    this.strategy = paramStrategy;
    this.omitEmptyStrings = paramBoolean;
    this.trimmer = paramCharMatcher;
    this.limit = paramInt;
  }
  
  public static Splitter fixedLength(final int length) {
    boolean bool;
    if (length > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "The length may not be less than 1");
    return new Splitter(new Strategy() {
          public Splitter.SplittingIterator iterator(Splitter param1Splitter, CharSequence param1CharSequence) {
            return new Splitter.SplittingIterator(param1Splitter, param1CharSequence) {
                public int separatorEnd(int param2Int) {
                  return param2Int;
                }
                
                public int separatorStart(int param2Int) {
                  param2Int += length;
                  if (param2Int >= this.toSplit.length())
                    param2Int = -1; 
                  return param2Int;
                }
              };
          }
        });
  }
  
  public static Splitter on(char paramChar) {
    return on(CharMatcher.is(paramChar));
  }
  
  public static Splitter on(final CharMatcher separatorMatcher) {
    Preconditions.checkNotNull(separatorMatcher);
    return new Splitter(new Strategy() {
          public Splitter.SplittingIterator iterator(Splitter param1Splitter, CharSequence param1CharSequence) {
            return new Splitter.SplittingIterator(param1Splitter, param1CharSequence) {
                int separatorEnd(int param2Int) {
                  return param2Int + 1;
                }
                
                int separatorStart(int param2Int) {
                  return separatorMatcher.indexIn(this.toSplit, param2Int);
                }
              };
          }
        });
  }
  
  private static Splitter on(final CommonPattern separatorPattern) {
    Preconditions.checkArgument(separatorPattern.matcher("").matches() ^ true, "The pattern may not match the empty string: %s", separatorPattern);
    return new Splitter(new Strategy() {
          public Splitter.SplittingIterator iterator(Splitter param1Splitter, CharSequence param1CharSequence) {
            return new Splitter.SplittingIterator(param1Splitter, param1CharSequence) {
                public int separatorEnd(int param2Int) {
                  return matcher.end();
                }
                
                public int separatorStart(int param2Int) {
                  if (matcher.find(param2Int)) {
                    param2Int = matcher.start();
                  } else {
                    param2Int = -1;
                  } 
                  return param2Int;
                }
              };
          }
        });
  }
  
  public static Splitter on(final String separator) {
    boolean bool;
    if (separator.length() != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "The separator may not be the empty string.");
    return (separator.length() == 1) ? on(separator.charAt(0)) : new Splitter(new Strategy() {
          public Splitter.SplittingIterator iterator(Splitter param1Splitter, CharSequence param1CharSequence) {
            return new Splitter.SplittingIterator(param1Splitter, param1CharSequence) {
                public int separatorEnd(int param2Int) {
                  return param2Int + separator.length();
                }
                
                public int separatorStart(int param2Int) {
                  int i = separator.length();
                  int j = this.toSplit.length();
                  label14: while (param2Int <= j - i) {
                    for (byte b = 0; b < i; b++) {
                      if (this.toSplit.charAt(b + param2Int) != separator.charAt(b)) {
                        param2Int++;
                        continue label14;
                      } 
                    } 
                    return param2Int;
                  } 
                  return -1;
                }
              };
          }
        });
  }
  
  @GwtIncompatible
  public static Splitter on(Pattern paramPattern) {
    return on(new JdkPattern(paramPattern));
  }
  
  @GwtIncompatible
  public static Splitter onPattern(String paramString) {
    return on(Platform.compilePattern(paramString));
  }
  
  private Iterator<String> splittingIterator(CharSequence paramCharSequence) {
    return this.strategy.iterator(this, paramCharSequence);
  }
  
  public Splitter limit(int paramInt) {
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "must be greater than zero: %s", paramInt);
    return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, paramInt);
  }
  
  public Splitter omitEmptyStrings() {
    return new Splitter(this.strategy, true, this.trimmer, this.limit);
  }
  
  public Iterable<String> split(final CharSequence sequence) {
    Preconditions.checkNotNull(sequence);
    return new Iterable<String>() {
        public Iterator<String> iterator() {
          return Splitter.this.splittingIterator(sequence);
        }
        
        public String toString() {
          Joiner joiner = Joiner.on(", ");
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append('[');
          stringBuilder = joiner.appendTo(stringBuilder, this);
          stringBuilder.append(']');
          return stringBuilder.toString();
        }
      };
  }
  
  @Beta
  public List<String> splitToList(CharSequence paramCharSequence) {
    Preconditions.checkNotNull(paramCharSequence);
    Iterator<String> iterator = splittingIterator(paramCharSequence);
    ArrayList<? extends String> arrayList = new ArrayList();
    while (iterator.hasNext())
      arrayList.add(iterator.next()); 
    return Collections.unmodifiableList(arrayList);
  }
  
  public Splitter trimResults() {
    return trimResults(CharMatcher.whitespace());
  }
  
  public Splitter trimResults(CharMatcher paramCharMatcher) {
    Preconditions.checkNotNull(paramCharMatcher);
    return new Splitter(this.strategy, this.omitEmptyStrings, paramCharMatcher, this.limit);
  }
  
  @Beta
  public MapSplitter withKeyValueSeparator(char paramChar) {
    return withKeyValueSeparator(on(paramChar));
  }
  
  @Beta
  public MapSplitter withKeyValueSeparator(Splitter paramSplitter) {
    return new MapSplitter(this, paramSplitter);
  }
  
  @Beta
  public MapSplitter withKeyValueSeparator(String paramString) {
    return withKeyValueSeparator(on(paramString));
  }
  
  @Beta
  public static final class MapSplitter {
    private static final String INVALID_ENTRY_MESSAGE = "Chunk [%s] is not a valid entry";
    
    private final Splitter entrySplitter;
    
    private final Splitter outerSplitter;
    
    private MapSplitter(Splitter param1Splitter1, Splitter param1Splitter2) {
      this.outerSplitter = param1Splitter1;
      this.entrySplitter = Preconditions.<Splitter>checkNotNull(param1Splitter2);
    }
    
    public Map<String, String> split(CharSequence param1CharSequence) {
      LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
      for (String str : this.outerSplitter.split(param1CharSequence)) {
        Iterator<String> iterator = this.entrySplitter.splittingIterator(str);
        Preconditions.checkArgument(iterator.hasNext(), "Chunk [%s] is not a valid entry", str);
        param1CharSequence = iterator.next();
        Preconditions.checkArgument(linkedHashMap.containsKey(param1CharSequence) ^ true, "Duplicate key [%s] found.", param1CharSequence);
        Preconditions.checkArgument(iterator.hasNext(), "Chunk [%s] is not a valid entry", str);
        linkedHashMap.put(param1CharSequence, iterator.next());
        Preconditions.checkArgument(iterator.hasNext() ^ true, "Chunk [%s] is not a valid entry", str);
      } 
      return (Map)Collections.unmodifiableMap(linkedHashMap);
    }
  }
  
  private static abstract class SplittingIterator extends AbstractIterator<String> {
    int limit;
    
    int offset = 0;
    
    final boolean omitEmptyStrings;
    
    final CharSequence toSplit;
    
    final CharMatcher trimmer;
    
    protected SplittingIterator(Splitter param1Splitter, CharSequence param1CharSequence) {
      this.trimmer = param1Splitter.trimmer;
      this.omitEmptyStrings = param1Splitter.omitEmptyStrings;
      this.limit = param1Splitter.limit;
      this.toSplit = param1CharSequence;
    }
    
    protected String computeNext() {
      int i = this.offset;
      while (true) {
        int j = this.offset;
        if (j != -1) {
          j = separatorStart(j);
          if (j == -1) {
            j = this.toSplit.length();
            this.offset = -1;
          } else {
            this.offset = separatorEnd(j);
          } 
          int k = this.offset;
          int m = i;
          if (k == i) {
            this.offset = k + 1;
            if (this.offset >= this.toSplit.length())
              this.offset = -1; 
            continue;
          } 
          while (true) {
            i = j;
            if (m < j) {
              i = j;
              if (this.trimmer.matches(this.toSplit.charAt(m))) {
                m++;
                continue;
              } 
            } 
            break;
          } 
          while (i > m && this.trimmer.matches(this.toSplit.charAt(i - 1)))
            i--; 
          if (this.omitEmptyStrings) {
            if (m == i) {
              i = this.offset;
              continue;
            } 
            j = this.limit;
            if (j == 1) {
              i = this.toSplit.length();
              this.offset = -1;
              while (true) {
                j = i;
                if (i > m) {
                  j = i;
                  if (this.trimmer.matches(this.toSplit.charAt(i - 1))) {
                    i--;
                    continue;
                  } 
                } 
                break;
              } 
            } else {
              this.limit = j - 1;
              j = i;
            } 
            return this.toSplit.subSequence(m, j).toString();
          } 
          continue;
        } 
        return endOfData();
      } 
    }
    
    abstract int separatorEnd(int param1Int);
    
    abstract int separatorStart(int param1Int);
  }
  
  private static interface Strategy {
    Iterator<String> iterator(Splitter param1Splitter, CharSequence param1CharSequence);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\Splitter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */