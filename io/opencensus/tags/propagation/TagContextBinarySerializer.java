package io.opencensus.tags.propagation;

import io.opencensus.tags.TagContext;

public abstract class TagContextBinarySerializer {
  public abstract TagContext fromByteArray(byte[] paramArrayOfbyte) throws TagContextDeserializationException;
  
  public abstract byte[] toByteArray(TagContext paramTagContext) throws TagContextSerializationException;
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\tags\propagation\TagContextBinarySerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */