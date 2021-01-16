package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Beta
@GwtCompatible
@Immutable
public final class MediaType {
  public static final MediaType AAC_AUDIO;
  
  public static final MediaType ANY_APPLICATION_TYPE;
  
  public static final MediaType ANY_AUDIO_TYPE;
  
  public static final MediaType ANY_IMAGE_TYPE;
  
  public static final MediaType ANY_TEXT_TYPE;
  
  public static final MediaType ANY_TYPE;
  
  public static final MediaType ANY_VIDEO_TYPE;
  
  public static final MediaType APPLE_MOBILE_CONFIG;
  
  public static final MediaType APPLE_PASSBOOK;
  
  public static final MediaType APPLICATION_BINARY;
  
  private static final String APPLICATION_TYPE = "application";
  
  public static final MediaType APPLICATION_XML_UTF_8;
  
  public static final MediaType ATOM_UTF_8;
  
  private static final String AUDIO_TYPE = "audio";
  
  public static final MediaType BASIC_AUDIO;
  
  public static final MediaType BMP;
  
  public static final MediaType BZIP2;
  
  public static final MediaType CACHE_MANIFEST_UTF_8;
  
  private static final String CHARSET_ATTRIBUTE = "charset";
  
  public static final MediaType CRW;
  
  public static final MediaType CSS_UTF_8;
  
  public static final MediaType CSV_UTF_8;
  
  public static final MediaType DART_UTF_8;
  
  public static final MediaType EOT;
  
  public static final MediaType EPUB;
  
  public static final MediaType FLV_VIDEO;
  
  public static final MediaType FORM_DATA;
  
  public static final MediaType GIF;
  
  public static final MediaType GZIP;
  
  public static final MediaType HTML_UTF_8;
  
  public static final MediaType ICO;
  
  private static final String IMAGE_TYPE = "image";
  
  public static final MediaType I_CALENDAR_UTF_8;
  
  public static final MediaType JAVASCRIPT_UTF_8;
  
  public static final MediaType JPEG;
  
  public static final MediaType JSON_UTF_8;
  
  public static final MediaType KEY_ARCHIVE;
  
  public static final MediaType KML;
  
  public static final MediaType KMZ;
  
  private static final Map<MediaType, MediaType> KNOWN_TYPES;
  
  public static final MediaType L24_AUDIO;
  
  private static final CharMatcher LINEAR_WHITE_SPACE;
  
  public static final MediaType MANIFEST_JSON_UTF_8;
  
  public static final MediaType MBOX;
  
  public static final MediaType MICROSOFT_EXCEL;
  
  public static final MediaType MICROSOFT_POWERPOINT;
  
  public static final MediaType MICROSOFT_WORD;
  
  public static final MediaType MP4_AUDIO;
  
  public static final MediaType MP4_VIDEO;
  
  public static final MediaType MPEG_AUDIO;
  
  public static final MediaType MPEG_VIDEO;
  
  public static final MediaType NACL_APPLICATION;
  
  public static final MediaType NACL_PORTABLE_APPLICATION;
  
  public static final MediaType OCTET_STREAM;
  
  public static final MediaType OGG_AUDIO;
  
  public static final MediaType OGG_CONTAINER;
  
  public static final MediaType OGG_VIDEO;
  
  public static final MediaType OOXML_DOCUMENT;
  
  public static final MediaType OOXML_PRESENTATION;
  
  public static final MediaType OOXML_SHEET;
  
  public static final MediaType OPENDOCUMENT_GRAPHICS;
  
  public static final MediaType OPENDOCUMENT_PRESENTATION;
  
  public static final MediaType OPENDOCUMENT_SPREADSHEET;
  
  public static final MediaType OPENDOCUMENT_TEXT;
  
  private static final Joiner.MapJoiner PARAMETER_JOINER;
  
  public static final MediaType PDF;
  
  public static final MediaType PLAIN_TEXT_UTF_8;
  
  public static final MediaType PNG;
  
  public static final MediaType POSTSCRIPT;
  
  public static final MediaType PROTOBUF;
  
  public static final MediaType PSD;
  
  public static final MediaType QUICKTIME;
  
  private static final CharMatcher QUOTED_TEXT_MATCHER;
  
  public static final MediaType RDF_XML_UTF_8;
  
  public static final MediaType RTF_UTF_8;
  
  public static final MediaType SFNT;
  
  public static final MediaType SHOCKWAVE_FLASH;
  
  public static final MediaType SKETCHUP;
  
  public static final MediaType SOAP_XML_UTF_8;
  
  public static final MediaType SVG_UTF_8;
  
  public static final MediaType TAR;
  
  public static final MediaType TEXT_JAVASCRIPT_UTF_8;
  
  private static final String TEXT_TYPE = "text";
  
  public static final MediaType THREE_GPP2_VIDEO;
  
  public static final MediaType THREE_GPP_VIDEO;
  
  public static final MediaType TIFF;
  
  private static final CharMatcher TOKEN_MATCHER;
  
  public static final MediaType TSV_UTF_8;
  
  private static final ImmutableListMultimap<String, String> UTF_8_CONSTANT_PARAMETERS = ImmutableListMultimap.of("charset", Ascii.toLowerCase(Charsets.UTF_8.name()));
  
  public static final MediaType VCARD_UTF_8;
  
  private static final String VIDEO_TYPE = "video";
  
  public static final MediaType VND_REAL_AUDIO;
  
  public static final MediaType VND_WAVE_AUDIO;
  
  public static final MediaType VORBIS_AUDIO;
  
  public static final MediaType VTT_UTF_8;
  
  public static final MediaType WAX_AUDIO;
  
  public static final MediaType WEBM_AUDIO;
  
  public static final MediaType WEBM_VIDEO;
  
  public static final MediaType WEBP;
  
  private static final String WILDCARD = "*";
  
  public static final MediaType WMA_AUDIO;
  
  public static final MediaType WML_UTF_8;
  
  public static final MediaType WMV;
  
  public static final MediaType WOFF;
  
  public static final MediaType WOFF2;
  
  public static final MediaType XHTML_UTF_8;
  
  public static final MediaType XML_UTF_8;
  
  public static final MediaType XRD_UTF_8;
  
  public static final MediaType ZIP;
  
  @LazyInit
  private int hashCode;
  
  private final ImmutableListMultimap<String, String> parameters;
  
  private final String subtype;
  
  @LazyInit
  private String toString;
  
  private final String type;
  
  static {
    TOKEN_MATCHER = CharMatcher.ascii().and(CharMatcher.javaIsoControl().negate()).and(CharMatcher.isNot(' ')).and(CharMatcher.noneOf("()<>@,;:\\\"/[]?="));
    QUOTED_TEXT_MATCHER = CharMatcher.ascii().and(CharMatcher.noneOf("\"\\\r"));
    LINEAR_WHITE_SPACE = CharMatcher.anyOf(" \t\r\n");
    KNOWN_TYPES = Maps.newHashMap();
    ANY_TYPE = createConstant("*", "*");
    ANY_TEXT_TYPE = createConstant("text", "*");
    ANY_IMAGE_TYPE = createConstant("image", "*");
    ANY_AUDIO_TYPE = createConstant("audio", "*");
    ANY_VIDEO_TYPE = createConstant("video", "*");
    ANY_APPLICATION_TYPE = createConstant("application", "*");
    CACHE_MANIFEST_UTF_8 = createConstantUtf8("text", "cache-manifest");
    CSS_UTF_8 = createConstantUtf8("text", "css");
    CSV_UTF_8 = createConstantUtf8("text", "csv");
    HTML_UTF_8 = createConstantUtf8("text", "html");
    I_CALENDAR_UTF_8 = createConstantUtf8("text", "calendar");
    PLAIN_TEXT_UTF_8 = createConstantUtf8("text", "plain");
    TEXT_JAVASCRIPT_UTF_8 = createConstantUtf8("text", "javascript");
    TSV_UTF_8 = createConstantUtf8("text", "tab-separated-values");
    VCARD_UTF_8 = createConstantUtf8("text", "vcard");
    WML_UTF_8 = createConstantUtf8("text", "vnd.wap.wml");
    XML_UTF_8 = createConstantUtf8("text", "xml");
    VTT_UTF_8 = createConstantUtf8("text", "vtt");
    BMP = createConstant("image", "bmp");
    CRW = createConstant("image", "x-canon-crw");
    GIF = createConstant("image", "gif");
    ICO = createConstant("image", "vnd.microsoft.icon");
    JPEG = createConstant("image", "jpeg");
    PNG = createConstant("image", "png");
    PSD = createConstant("image", "vnd.adobe.photoshop");
    SVG_UTF_8 = createConstantUtf8("image", "svg+xml");
    TIFF = createConstant("image", "tiff");
    WEBP = createConstant("image", "webp");
    MP4_AUDIO = createConstant("audio", "mp4");
    MPEG_AUDIO = createConstant("audio", "mpeg");
    OGG_AUDIO = createConstant("audio", "ogg");
    WEBM_AUDIO = createConstant("audio", "webm");
    L24_AUDIO = createConstant("audio", "l24");
    BASIC_AUDIO = createConstant("audio", "basic");
    AAC_AUDIO = createConstant("audio", "aac");
    VORBIS_AUDIO = createConstant("audio", "vorbis");
    WMA_AUDIO = createConstant("audio", "x-ms-wma");
    WAX_AUDIO = createConstant("audio", "x-ms-wax");
    VND_REAL_AUDIO = createConstant("audio", "vnd.rn-realaudio");
    VND_WAVE_AUDIO = createConstant("audio", "vnd.wave");
    MP4_VIDEO = createConstant("video", "mp4");
    MPEG_VIDEO = createConstant("video", "mpeg");
    OGG_VIDEO = createConstant("video", "ogg");
    QUICKTIME = createConstant("video", "quicktime");
    WEBM_VIDEO = createConstant("video", "webm");
    WMV = createConstant("video", "x-ms-wmv");
    FLV_VIDEO = createConstant("video", "x-flv");
    THREE_GPP_VIDEO = createConstant("video", "3gpp");
    THREE_GPP2_VIDEO = createConstant("video", "3gpp2");
    APPLICATION_XML_UTF_8 = createConstantUtf8("application", "xml");
    ATOM_UTF_8 = createConstantUtf8("application", "atom+xml");
    BZIP2 = createConstant("application", "x-bzip2");
    DART_UTF_8 = createConstantUtf8("application", "dart");
    APPLE_PASSBOOK = createConstant("application", "vnd.apple.pkpass");
    EOT = createConstant("application", "vnd.ms-fontobject");
    EPUB = createConstant("application", "epub+zip");
    FORM_DATA = createConstant("application", "x-www-form-urlencoded");
    KEY_ARCHIVE = createConstant("application", "pkcs12");
    APPLICATION_BINARY = createConstant("application", "binary");
    GZIP = createConstant("application", "x-gzip");
    JAVASCRIPT_UTF_8 = createConstantUtf8("application", "javascript");
    JSON_UTF_8 = createConstantUtf8("application", "json");
    MANIFEST_JSON_UTF_8 = createConstantUtf8("application", "manifest+json");
    KML = createConstant("application", "vnd.google-earth.kml+xml");
    KMZ = createConstant("application", "vnd.google-earth.kmz");
    MBOX = createConstant("application", "mbox");
    APPLE_MOBILE_CONFIG = createConstant("application", "x-apple-aspen-config");
    MICROSOFT_EXCEL = createConstant("application", "vnd.ms-excel");
    MICROSOFT_POWERPOINT = createConstant("application", "vnd.ms-powerpoint");
    MICROSOFT_WORD = createConstant("application", "msword");
    NACL_APPLICATION = createConstant("application", "x-nacl");
    NACL_PORTABLE_APPLICATION = createConstant("application", "x-pnacl");
    OCTET_STREAM = createConstant("application", "octet-stream");
    OGG_CONTAINER = createConstant("application", "ogg");
    OOXML_DOCUMENT = createConstant("application", "vnd.openxmlformats-officedocument.wordprocessingml.document");
    OOXML_PRESENTATION = createConstant("application", "vnd.openxmlformats-officedocument.presentationml.presentation");
    OOXML_SHEET = createConstant("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    OPENDOCUMENT_GRAPHICS = createConstant("application", "vnd.oasis.opendocument.graphics");
    OPENDOCUMENT_PRESENTATION = createConstant("application", "vnd.oasis.opendocument.presentation");
    OPENDOCUMENT_SPREADSHEET = createConstant("application", "vnd.oasis.opendocument.spreadsheet");
    OPENDOCUMENT_TEXT = createConstant("application", "vnd.oasis.opendocument.text");
    PDF = createConstant("application", "pdf");
    POSTSCRIPT = createConstant("application", "postscript");
    PROTOBUF = createConstant("application", "protobuf");
    RDF_XML_UTF_8 = createConstantUtf8("application", "rdf+xml");
    RTF_UTF_8 = createConstantUtf8("application", "rtf");
    SFNT = createConstant("application", "font-sfnt");
    SHOCKWAVE_FLASH = createConstant("application", "x-shockwave-flash");
    SKETCHUP = createConstant("application", "vnd.sketchup.skp");
    SOAP_XML_UTF_8 = createConstantUtf8("application", "soap+xml");
    TAR = createConstant("application", "x-tar");
    WOFF = createConstant("application", "font-woff");
    WOFF2 = createConstant("application", "font-woff2");
    XHTML_UTF_8 = createConstantUtf8("application", "xhtml+xml");
    XRD_UTF_8 = createConstantUtf8("application", "xrd+xml");
    ZIP = createConstant("application", "zip");
    PARAMETER_JOINER = Joiner.on("; ").withKeyValueSeparator("=");
  }
  
  private MediaType(String paramString1, String paramString2, ImmutableListMultimap<String, String> paramImmutableListMultimap) {
    this.type = paramString1;
    this.subtype = paramString2;
    this.parameters = paramImmutableListMultimap;
  }
  
  private static MediaType addKnownType(MediaType paramMediaType) {
    KNOWN_TYPES.put(paramMediaType, paramMediaType);
    return paramMediaType;
  }
  
  private String computeToString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.type);
    stringBuilder.append('/');
    stringBuilder.append(this.subtype);
    if (!this.parameters.isEmpty()) {
      stringBuilder.append("; ");
      ListMultimap listMultimap = Multimaps.transformValues((ListMultimap)this.parameters, new Function<String, String>() {
            public String apply(String param1String) {
              if (!MediaType.TOKEN_MATCHER.matchesAllOf(param1String))
                param1String = MediaType.escapeAndQuote(param1String); 
              return param1String;
            }
          });
      PARAMETER_JOINER.appendTo(stringBuilder, listMultimap.entries());
    } 
    return stringBuilder.toString();
  }
  
  public static MediaType create(String paramString1, String paramString2) {
    return create(paramString1, paramString2, (Multimap<String, String>)ImmutableListMultimap.of());
  }
  
  private static MediaType create(String paramString1, String paramString2, Multimap<String, String> paramMultimap) {
    boolean bool;
    Preconditions.checkNotNull(paramString1);
    Preconditions.checkNotNull(paramString2);
    Preconditions.checkNotNull(paramMultimap);
    paramString1 = normalizeToken(paramString1);
    paramString2 = normalizeToken(paramString2);
    if (!"*".equals(paramString1) || "*".equals(paramString2)) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "A wildcard type cannot be used with a non-wildcard subtype");
    ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
    for (Map.Entry entry : paramMultimap.entries()) {
      String str = normalizeToken((String)entry.getKey());
      builder.put(str, normalizeParameterValue(str, (String)entry.getValue()));
    } 
    MediaType mediaType = new MediaType(paramString1, paramString2, builder.build());
    return (MediaType)MoreObjects.firstNonNull(KNOWN_TYPES.get(mediaType), mediaType);
  }
  
  static MediaType createApplicationType(String paramString) {
    return create("application", paramString);
  }
  
  static MediaType createAudioType(String paramString) {
    return create("audio", paramString);
  }
  
  private static MediaType createConstant(String paramString1, String paramString2) {
    return addKnownType(new MediaType(paramString1, paramString2, ImmutableListMultimap.of()));
  }
  
  private static MediaType createConstantUtf8(String paramString1, String paramString2) {
    return addKnownType(new MediaType(paramString1, paramString2, UTF_8_CONSTANT_PARAMETERS));
  }
  
  static MediaType createImageType(String paramString) {
    return create("image", paramString);
  }
  
  static MediaType createTextType(String paramString) {
    return create("text", paramString);
  }
  
  static MediaType createVideoType(String paramString) {
    return create("video", paramString);
  }
  
  private static String escapeAndQuote(String paramString) {
    StringBuilder stringBuilder = new StringBuilder(paramString.length() + 16);
    stringBuilder.append('"');
    for (byte b = 0; b < paramString.length(); b++) {
      char c = paramString.charAt(b);
      if (c == '\r' || c == '\\' || c == '"')
        stringBuilder.append('\\'); 
      stringBuilder.append(c);
    } 
    stringBuilder.append('"');
    return stringBuilder.toString();
  }
  
  private static String normalizeParameterValue(String paramString1, String paramString2) {
    String str = paramString2;
    if ("charset".equals(paramString1))
      str = Ascii.toLowerCase(paramString2); 
    return str;
  }
  
  private static String normalizeToken(String paramString) {
    Preconditions.checkArgument(TOKEN_MATCHER.matchesAllOf(paramString));
    return Ascii.toLowerCase(paramString);
  }
  
  private Map<String, ImmutableMultiset<String>> parametersAsMap() {
    return Maps.transformValues((Map)this.parameters.asMap(), new Function<Collection<String>, ImmutableMultiset<String>>() {
          public ImmutableMultiset<String> apply(Collection<String> param1Collection) {
            return ImmutableMultiset.copyOf(param1Collection);
          }
        });
  }
  
  public static MediaType parse(String paramString) {
    Preconditions.checkNotNull(paramString);
    Tokenizer tokenizer = new Tokenizer(paramString);
    try {
      String str1 = tokenizer.consumeToken(TOKEN_MATCHER);
      tokenizer.consumeCharacter('/');
      String str2 = tokenizer.consumeToken(TOKEN_MATCHER);
      ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
      while (tokenizer.hasMore()) {
        String str4;
        tokenizer.consumeTokenIfPresent(LINEAR_WHITE_SPACE);
        tokenizer.consumeCharacter(';');
        tokenizer.consumeTokenIfPresent(LINEAR_WHITE_SPACE);
        String str3 = tokenizer.consumeToken(TOKEN_MATCHER);
        tokenizer.consumeCharacter('=');
        if ('"' == tokenizer.previewChar()) {
          tokenizer.consumeCharacter('"');
          StringBuilder stringBuilder = new StringBuilder();
          this();
          while ('"' != tokenizer.previewChar()) {
            if ('\\' == tokenizer.previewChar()) {
              tokenizer.consumeCharacter('\\');
              stringBuilder.append(tokenizer.consumeCharacter(CharMatcher.ascii()));
              continue;
            } 
            stringBuilder.append(tokenizer.consumeToken(QUOTED_TEXT_MATCHER));
          } 
          str4 = stringBuilder.toString();
          tokenizer.consumeCharacter('"');
        } else {
          str4 = tokenizer.consumeToken(TOKEN_MATCHER);
        } 
        builder.put(str3, str4);
      } 
      return create(str1, str2, (Multimap<String, String>)builder.build());
    } catch (IllegalStateException illegalStateException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not parse '");
      stringBuilder.append(paramString);
      stringBuilder.append("'");
      throw new IllegalArgumentException(stringBuilder.toString(), illegalStateException);
    } 
  }
  
  public Optional<Charset> charset() {
    StringBuilder stringBuilder;
    ImmutableSet immutableSet = ImmutableSet.copyOf((Collection)this.parameters.get("charset"));
    switch (immutableSet.size()) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("Multiple charset values defined: ");
        stringBuilder.append(immutableSet);
        throw new IllegalStateException(stringBuilder.toString());
      case 1:
        return Optional.of(Charset.forName((String)Iterables.getOnlyElement((Iterable)immutableSet)));
      case 0:
        break;
    } 
    return Optional.absent();
  }
  
  public boolean equals(@Nullable Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof MediaType) {
      paramObject = paramObject;
      if (!this.type.equals(((MediaType)paramObject).type) || !this.subtype.equals(((MediaType)paramObject).subtype) || !parametersAsMap().equals(paramObject.parametersAsMap()))
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public boolean hasWildcard() {
    return ("*".equals(this.type) || "*".equals(this.subtype));
  }
  
  public int hashCode() {
    int i = this.hashCode;
    int j = i;
    if (i == 0) {
      j = Objects.hashCode(new Object[] { this.type, this.subtype, parametersAsMap() });
      this.hashCode = j;
    } 
    return j;
  }
  
  public boolean is(MediaType paramMediaType) {
    boolean bool;
    if ((paramMediaType.type.equals("*") || paramMediaType.type.equals(this.type)) && (paramMediaType.subtype.equals("*") || paramMediaType.subtype.equals(this.subtype)) && this.parameters.entries().containsAll((Collection)paramMediaType.parameters.entries())) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public ImmutableListMultimap<String, String> parameters() {
    return this.parameters;
  }
  
  public String subtype() {
    return this.subtype;
  }
  
  public String toString() {
    String str1 = this.toString;
    String str2 = str1;
    if (str1 == null) {
      str2 = computeToString();
      this.toString = str2;
    } 
    return str2;
  }
  
  public String type() {
    return this.type;
  }
  
  public MediaType withCharset(Charset paramCharset) {
    Preconditions.checkNotNull(paramCharset);
    return withParameter("charset", paramCharset.name());
  }
  
  public MediaType withParameter(String paramString1, String paramString2) {
    Preconditions.checkNotNull(paramString1);
    Preconditions.checkNotNull(paramString2);
    String str = normalizeToken(paramString1);
    ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
    for (Map.Entry entry : this.parameters.entries()) {
      String str1 = (String)entry.getKey();
      if (!str.equals(str1))
        builder.put(str1, entry.getValue()); 
    } 
    builder.put(str, normalizeParameterValue(str, paramString2));
    MediaType mediaType = new MediaType(this.type, this.subtype, builder.build());
    return (MediaType)MoreObjects.firstNonNull(KNOWN_TYPES.get(mediaType), mediaType);
  }
  
  public MediaType withParameters(Multimap<String, String> paramMultimap) {
    return create(this.type, this.subtype, paramMultimap);
  }
  
  public MediaType withoutParameters() {
    MediaType mediaType;
    if (this.parameters.isEmpty()) {
      mediaType = this;
    } else {
      mediaType = create(this.type, this.subtype);
    } 
    return mediaType;
  }
  
  private static final class Tokenizer {
    final String input;
    
    int position = 0;
    
    Tokenizer(String param1String) {
      this.input = param1String;
    }
    
    char consumeCharacter(char param1Char) {
      boolean bool;
      Preconditions.checkState(hasMore());
      if (previewChar() == param1Char) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool);
      this.position++;
      return param1Char;
    }
    
    char consumeCharacter(CharMatcher param1CharMatcher) {
      Preconditions.checkState(hasMore());
      char c = previewChar();
      Preconditions.checkState(param1CharMatcher.matches(c));
      this.position++;
      return c;
    }
    
    String consumeToken(CharMatcher param1CharMatcher) {
      boolean bool;
      int i = this.position;
      String str = consumeTokenIfPresent(param1CharMatcher);
      if (this.position != i) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool);
      return str;
    }
    
    String consumeTokenIfPresent(CharMatcher param1CharMatcher) {
      String str;
      Preconditions.checkState(hasMore());
      int i = this.position;
      this.position = param1CharMatcher.negate().indexIn(this.input, i);
      if (hasMore()) {
        str = this.input.substring(i, this.position);
      } else {
        str = this.input.substring(i);
      } 
      return str;
    }
    
    boolean hasMore() {
      boolean bool;
      int i = this.position;
      if (i >= 0 && i < this.input.length()) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    char previewChar() {
      Preconditions.checkState(hasMore());
      return this.input.charAt(this.position);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\net\MediaType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */