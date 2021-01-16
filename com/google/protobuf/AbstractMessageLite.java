package com.google.protobuf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractMessageLite<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends AbstractMessageLite.Builder<MessageType, BuilderType>> implements MessageLite {
  protected int memoizedHashCode = 0;
  
  protected static <T> void addAll(Iterable<T> paramIterable, Collection<? super T> paramCollection) {
    Builder.addAll(paramIterable, paramCollection);
  }
  
  protected static void checkByteStringIsUtf8(ByteString paramByteString) throws IllegalArgumentException {
    if (paramByteString.isValidUtf8())
      return; 
    throw new IllegalArgumentException("Byte string is not UTF-8.");
  }
  
  private String getSerializingExceptionMessage(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Serializing ");
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" to a ");
    stringBuilder.append(paramString);
    stringBuilder.append(" threw an IOException (should never happen).");
    return stringBuilder.toString();
  }
  
  UninitializedMessageException newUninitializedMessageException() {
    return new UninitializedMessageException(this);
  }
  
  public byte[] toByteArray() {
    try {
      byte[] arrayOfByte = new byte[getSerializedSize()];
      CodedOutputStream codedOutputStream = CodedOutputStream.newInstance(arrayOfByte);
      writeTo(codedOutputStream);
      codedOutputStream.checkNoSpaceLeft();
      return arrayOfByte;
    } catch (IOException iOException) {
      throw new RuntimeException(getSerializingExceptionMessage("byte array"), iOException);
    } 
  }
  
  public ByteString toByteString() {
    try {
      ByteString.CodedBuilder codedBuilder = ByteString.newCodedBuilder(getSerializedSize());
      writeTo(codedBuilder.getCodedOutput());
      return codedBuilder.build();
    } catch (IOException iOException) {
      throw new RuntimeException(getSerializingExceptionMessage("ByteString"), iOException);
    } 
  }
  
  public void writeDelimitedTo(OutputStream paramOutputStream) throws IOException {
    int i = getSerializedSize();
    CodedOutputStream codedOutputStream = CodedOutputStream.newInstance(paramOutputStream, CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeRawVarint32Size(i) + i));
    codedOutputStream.writeRawVarint32(i);
    writeTo(codedOutputStream);
    codedOutputStream.flush();
  }
  
  public void writeTo(OutputStream paramOutputStream) throws IOException {
    CodedOutputStream codedOutputStream = CodedOutputStream.newInstance(paramOutputStream, CodedOutputStream.computePreferredBufferSize(getSerializedSize()));
    writeTo(codedOutputStream);
    codedOutputStream.flush();
  }
  
  public static abstract class Builder<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite.Builder {
    protected static <T> void addAll(Iterable<T> param1Iterable, Collection<? super T> param1Collection) {
      // Byte code:
      //   0: aload_0
      //   1: ifnull -> 109
      //   4: aload_0
      //   5: instanceof com/google/protobuf/LazyStringList
      //   8: ifeq -> 37
      //   11: aload_0
      //   12: checkcast com/google/protobuf/LazyStringList
      //   15: invokeinterface getUnderlyingElements : ()Ljava/util/List;
      //   20: invokestatic checkForNullValues : (Ljava/lang/Iterable;)V
      //   23: aload_1
      //   24: aload_0
      //   25: checkcast java/util/Collection
      //   28: invokeinterface addAll : (Ljava/util/Collection;)Z
      //   33: pop
      //   34: goto -> 108
      //   37: aload_0
      //   38: instanceof java/util/Collection
      //   41: ifeq -> 62
      //   44: aload_0
      //   45: invokestatic checkForNullValues : (Ljava/lang/Iterable;)V
      //   48: aload_1
      //   49: aload_0
      //   50: checkcast java/util/Collection
      //   53: invokeinterface addAll : (Ljava/util/Collection;)Z
      //   58: pop
      //   59: goto -> 108
      //   62: aload_0
      //   63: invokeinterface iterator : ()Ljava/util/Iterator;
      //   68: astore_0
      //   69: aload_0
      //   70: invokeinterface hasNext : ()Z
      //   75: ifeq -> 108
      //   78: aload_0
      //   79: invokeinterface next : ()Ljava/lang/Object;
      //   84: astore_2
      //   85: aload_2
      //   86: ifnull -> 100
      //   89: aload_1
      //   90: aload_2
      //   91: invokeinterface add : (Ljava/lang/Object;)Z
      //   96: pop
      //   97: goto -> 69
      //   100: new java/lang/NullPointerException
      //   103: dup
      //   104: invokespecial <init> : ()V
      //   107: athrow
      //   108: return
      //   109: new java/lang/NullPointerException
      //   112: dup
      //   113: invokespecial <init> : ()V
      //   116: athrow
    }
    
    private static void checkForNullValues(Iterable<?> param1Iterable) {
      Iterator<?> iterator = param1Iterable.iterator();
      while (iterator.hasNext()) {
        if (iterator.next() != null)
          continue; 
        throw new NullPointerException();
      } 
    }
    
    private String getReadingExceptionMessage(String param1String) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Reading ");
      stringBuilder.append(getClass().getName());
      stringBuilder.append(" from a ");
      stringBuilder.append(param1String);
      stringBuilder.append(" threw an IOException (should never happen).");
      return stringBuilder.toString();
    }
    
    protected static UninitializedMessageException newUninitializedMessageException(MessageLite param1MessageLite) {
      return new UninitializedMessageException(param1MessageLite);
    }
    
    public abstract BuilderType clone();
    
    protected abstract BuilderType internalMergeFrom(MessageType param1MessageType);
    
    public boolean mergeDelimitedFrom(InputStream param1InputStream) throws IOException {
      return mergeDelimitedFrom(param1InputStream, ExtensionRegistryLite.getEmptyRegistry());
    }
    
    public boolean mergeDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      int i = param1InputStream.read();
      if (i == -1)
        return false; 
      mergeFrom(new LimitedInputStream(param1InputStream, CodedInputStream.readRawVarint32(i, param1InputStream)), param1ExtensionRegistryLite);
      return true;
    }
    
    public BuilderType mergeFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      try {
        CodedInputStream codedInputStream = param1ByteString.newCodedInput();
        mergeFrom(codedInputStream);
        codedInputStream.checkLastTagWas(0);
        return (BuilderType)this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw invalidProtocolBufferException;
      } catch (IOException iOException) {
        throw new RuntimeException(getReadingExceptionMessage("ByteString"), iOException);
      } 
    }
    
    public BuilderType mergeFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      try {
        CodedInputStream codedInputStream = param1ByteString.newCodedInput();
        mergeFrom(codedInputStream, param1ExtensionRegistryLite);
        codedInputStream.checkLastTagWas(0);
        return (BuilderType)this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw invalidProtocolBufferException;
      } catch (IOException iOException) {
        throw new RuntimeException(getReadingExceptionMessage("ByteString"), iOException);
      } 
    }
    
    public BuilderType mergeFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return mergeFrom(param1CodedInputStream, ExtensionRegistryLite.getEmptyRegistry());
    }
    
    public abstract BuilderType mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException;
    
    public BuilderType mergeFrom(MessageLite param1MessageLite) {
      if (getDefaultInstanceForType().getClass().isInstance(param1MessageLite))
        return internalMergeFrom((MessageType)param1MessageLite); 
      throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
    
    public BuilderType mergeFrom(InputStream param1InputStream) throws IOException {
      CodedInputStream codedInputStream = CodedInputStream.newInstance(param1InputStream);
      mergeFrom(codedInputStream);
      codedInputStream.checkLastTagWas(0);
      return (BuilderType)this;
    }
    
    public BuilderType mergeFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = CodedInputStream.newInstance(param1InputStream);
      mergeFrom(codedInputStream, param1ExtensionRegistryLite);
      codedInputStream.checkLastTagWas(0);
      return (BuilderType)this;
    }
    
    public BuilderType mergeFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return mergeFrom(param1ArrayOfbyte, 0, param1ArrayOfbyte.length);
    }
    
    public BuilderType mergeFrom(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws InvalidProtocolBufferException {
      try {
        CodedInputStream codedInputStream = CodedInputStream.newInstance(param1ArrayOfbyte, param1Int1, param1Int2);
        mergeFrom(codedInputStream);
        codedInputStream.checkLastTagWas(0);
        return (BuilderType)this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw invalidProtocolBufferException;
      } catch (IOException iOException) {
        throw new RuntimeException(getReadingExceptionMessage("byte array"), iOException);
      } 
    }
    
    public BuilderType mergeFrom(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      try {
        CodedInputStream codedInputStream = CodedInputStream.newInstance(param1ArrayOfbyte, param1Int1, param1Int2);
        mergeFrom(codedInputStream, param1ExtensionRegistryLite);
        codedInputStream.checkLastTagWas(0);
        return (BuilderType)this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw invalidProtocolBufferException;
      } catch (IOException iOException) {
        throw new RuntimeException(getReadingExceptionMessage("byte array"), iOException);
      } 
    }
    
    public BuilderType mergeFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return mergeFrom(param1ArrayOfbyte, 0, param1ArrayOfbyte.length, param1ExtensionRegistryLite);
    }
    
    static final class LimitedInputStream extends FilterInputStream {
      private int limit;
      
      LimitedInputStream(InputStream param2InputStream, int param2Int) {
        super(param2InputStream);
        this.limit = param2Int;
      }
      
      public int available() throws IOException {
        return Math.min(super.available(), this.limit);
      }
      
      public int read() throws IOException {
        if (this.limit <= 0)
          return -1; 
        int i = super.read();
        if (i >= 0)
          this.limit--; 
        return i;
      }
      
      public int read(byte[] param2ArrayOfbyte, int param2Int1, int param2Int2) throws IOException {
        int i = this.limit;
        if (i <= 0)
          return -1; 
        param2Int1 = super.read(param2ArrayOfbyte, param2Int1, Math.min(param2Int2, i));
        if (param2Int1 >= 0)
          this.limit -= param2Int1; 
        return param2Int1;
      }
      
      public long skip(long param2Long) throws IOException {
        param2Long = super.skip(Math.min(param2Long, this.limit));
        if (param2Long >= 0L)
          this.limit = (int)(this.limit - param2Long); 
        return param2Long;
      }
    }
  }
  
  static final class LimitedInputStream extends FilterInputStream {
    private int limit;
    
    LimitedInputStream(InputStream param1InputStream, int param1Int) {
      super(param1InputStream);
      this.limit = param1Int;
    }
    
    public int available() throws IOException {
      return Math.min(super.available(), this.limit);
    }
    
    public int read() throws IOException {
      if (this.limit <= 0)
        return -1; 
      int i = super.read();
      if (i >= 0)
        this.limit--; 
      return i;
    }
    
    public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      int i = this.limit;
      if (i <= 0)
        return -1; 
      param1Int1 = super.read(param1ArrayOfbyte, param1Int1, Math.min(param1Int2, i));
      if (param1Int1 >= 0)
        this.limit -= param1Int1; 
      return param1Int1;
    }
    
    public long skip(long param1Long) throws IOException {
      param1Long = super.skip(Math.min(param1Long, this.limit));
      if (param1Long >= 0L)
        this.limit = (int)(this.limit - param1Long); 
      return param1Long;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\AbstractMessageLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */