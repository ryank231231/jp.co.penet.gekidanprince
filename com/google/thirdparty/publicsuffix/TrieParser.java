package com.google.thirdparty.publicsuffix;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.List;

@GwtCompatible
final class TrieParser {
  private static final Joiner PREFIX_JOINER = Joiner.on("");
  
  private static int doParseTrieToBuilder(List<CharSequence> paramList, CharSequence paramCharSequence, ImmutableMap.Builder<String, PublicSuffixType> paramBuilder) {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface length : ()I
    //   6: istore_3
    //   7: iconst_0
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iload #5
    //   15: istore #6
    //   17: iload #4
    //   19: iload_3
    //   20: if_icmpge -> 97
    //   23: aload_1
    //   24: iload #4
    //   26: invokeinterface charAt : (I)C
    //   31: istore #5
    //   33: iload #5
    //   35: istore #6
    //   37: iload #5
    //   39: bipush #38
    //   41: if_icmpeq -> 97
    //   44: iload #5
    //   46: istore #6
    //   48: iload #5
    //   50: bipush #63
    //   52: if_icmpeq -> 97
    //   55: iload #5
    //   57: istore #6
    //   59: iload #5
    //   61: bipush #33
    //   63: if_icmpeq -> 97
    //   66: iload #5
    //   68: istore #6
    //   70: iload #5
    //   72: bipush #58
    //   74: if_icmpeq -> 97
    //   77: iload #5
    //   79: bipush #44
    //   81: if_icmpne -> 91
    //   84: iload #5
    //   86: istore #6
    //   88: goto -> 97
    //   91: iinc #4, 1
    //   94: goto -> 13
    //   97: aload_0
    //   98: iconst_0
    //   99: aload_1
    //   100: iconst_0
    //   101: iload #4
    //   103: invokeinterface subSequence : (II)Ljava/lang/CharSequence;
    //   108: invokestatic reverse : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   111: invokeinterface add : (ILjava/lang/Object;)V
    //   116: iload #6
    //   118: bipush #33
    //   120: if_icmpeq -> 144
    //   123: iload #6
    //   125: bipush #63
    //   127: if_icmpeq -> 144
    //   130: iload #6
    //   132: bipush #58
    //   134: if_icmpeq -> 144
    //   137: iload #6
    //   139: bipush #44
    //   141: if_icmpne -> 173
    //   144: getstatic com/google/thirdparty/publicsuffix/TrieParser.PREFIX_JOINER : Lcom/google/common/base/Joiner;
    //   147: aload_0
    //   148: invokevirtual join : (Ljava/lang/Iterable;)Ljava/lang/String;
    //   151: astore #7
    //   153: aload #7
    //   155: invokevirtual length : ()I
    //   158: ifle -> 173
    //   161: aload_2
    //   162: aload #7
    //   164: iload #6
    //   166: invokestatic fromCode : (C)Lcom/google/thirdparty/publicsuffix/PublicSuffixType;
    //   169: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;
    //   172: pop
    //   173: iload #4
    //   175: iconst_1
    //   176: iadd
    //   177: istore #5
    //   179: iload #5
    //   181: istore #4
    //   183: iload #6
    //   185: bipush #63
    //   187: if_icmpeq -> 263
    //   190: iload #5
    //   192: istore #4
    //   194: iload #6
    //   196: bipush #44
    //   198: if_icmpeq -> 263
    //   201: iload #5
    //   203: istore #4
    //   205: iload #5
    //   207: iload_3
    //   208: if_icmpge -> 263
    //   211: iload #5
    //   213: aload_0
    //   214: aload_1
    //   215: iload #5
    //   217: iload_3
    //   218: invokeinterface subSequence : (II)Ljava/lang/CharSequence;
    //   223: aload_2
    //   224: invokestatic doParseTrieToBuilder : (Ljava/util/List;Ljava/lang/CharSequence;Lcom/google/common/collect/ImmutableMap$Builder;)I
    //   227: iadd
    //   228: istore #4
    //   230: aload_1
    //   231: iload #4
    //   233: invokeinterface charAt : (I)C
    //   238: bipush #63
    //   240: if_icmpeq -> 260
    //   243: iload #4
    //   245: istore #5
    //   247: aload_1
    //   248: iload #4
    //   250: invokeinterface charAt : (I)C
    //   255: bipush #44
    //   257: if_icmpne -> 201
    //   260: iinc #4, 1
    //   263: aload_0
    //   264: iconst_0
    //   265: invokeinterface remove : (I)Ljava/lang/Object;
    //   270: pop
    //   271: iload #4
    //   273: ireturn
  }
  
  static ImmutableMap<String, PublicSuffixType> parseTrie(CharSequence paramCharSequence) {
    ImmutableMap.Builder<String, PublicSuffixType> builder = ImmutableMap.builder();
    int i = paramCharSequence.length();
    for (int j = 0; j < i; j += doParseTrieToBuilder(Lists.newLinkedList(), paramCharSequence.subSequence(j, i), builder));
    return builder.build();
  }
  
  private static CharSequence reverse(CharSequence paramCharSequence) {
    return (new StringBuilder(paramCharSequence)).reverse();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\thirdparty\publicsuffix\TrieParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */