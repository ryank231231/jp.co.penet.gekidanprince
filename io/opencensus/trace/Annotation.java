package io.opencensus.trace;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class Annotation {
  private static final Map<String, AttributeValue> EMPTY_ATTRIBUTES = Collections.unmodifiableMap(Collections.emptyMap());
  
  public static Annotation fromDescription(String paramString) {
    return new AutoValue_Annotation(paramString, EMPTY_ATTRIBUTES);
  }
  
  public static Annotation fromDescriptionAndAttributes(String paramString, Map<String, AttributeValue> paramMap) {
    return new AutoValue_Annotation(paramString, Collections.unmodifiableMap(new HashMap<String, AttributeValue>((Map<? extends String, ? extends AttributeValue>)Preconditions.checkNotNull(paramMap, "attributes"))));
  }
  
  public abstract Map<String, AttributeValue> getAttributes();
  
  public abstract String getDescription();
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\Annotation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */