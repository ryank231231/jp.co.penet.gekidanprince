package com.google.protobuf;

import java.io.IOException;
import java.util.Arrays;

public final class UnknownFieldSetLite {
  private static final UnknownFieldSetLite DEFAULT_INSTANCE = new UnknownFieldSetLite(0, new int[0], new Object[0], false);
  
  private static final int MIN_CAPACITY = 8;
  
  private int count;
  
  private boolean isMutable;
  
  private int memoizedSerializedSize = -1;
  
  private Object[] objects;
  
  private int[] tags;
  
  private UnknownFieldSetLite() {
    this(0, new int[8], new Object[8], true);
  }
  
  private UnknownFieldSetLite(int paramInt, int[] paramArrayOfint, Object[] paramArrayOfObject, boolean paramBoolean) {
    this.count = paramInt;
    this.tags = paramArrayOfint;
    this.objects = paramArrayOfObject;
    this.isMutable = paramBoolean;
  }
  
  private void ensureCapacity() {
    int i = this.count;
    if (i == this.tags.length) {
      if (i < 4) {
        i = 8;
      } else {
        i >>= 1;
      } 
      i = this.count + i;
      this.tags = Arrays.copyOf(this.tags, i);
      this.objects = Arrays.copyOf(this.objects, i);
    } 
  }
  
  public static UnknownFieldSetLite getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private UnknownFieldSetLite mergeFrom(CodedInputStream paramCodedInputStream) throws IOException {
    int i;
    do {
      i = paramCodedInputStream.readTag();
    } while (i != 0 && mergeFieldFrom(i, paramCodedInputStream));
    return this;
  }
  
  static UnknownFieldSetLite mutableCopyOf(UnknownFieldSetLite paramUnknownFieldSetLite1, UnknownFieldSetLite paramUnknownFieldSetLite2) {
    int i = paramUnknownFieldSetLite1.count + paramUnknownFieldSetLite2.count;
    int[] arrayOfInt = Arrays.copyOf(paramUnknownFieldSetLite1.tags, i);
    System.arraycopy(paramUnknownFieldSetLite2.tags, 0, arrayOfInt, paramUnknownFieldSetLite1.count, paramUnknownFieldSetLite2.count);
    Object[] arrayOfObject = Arrays.copyOf(paramUnknownFieldSetLite1.objects, i);
    System.arraycopy(paramUnknownFieldSetLite2.objects, 0, arrayOfObject, paramUnknownFieldSetLite1.count, paramUnknownFieldSetLite2.count);
    return new UnknownFieldSetLite(i, arrayOfInt, arrayOfObject, true);
  }
  
  static UnknownFieldSetLite newInstance() {
    return new UnknownFieldSetLite();
  }
  
  private void storeField(int paramInt, Object paramObject) {
    ensureCapacity();
    int[] arrayOfInt = this.tags;
    int i = this.count;
    arrayOfInt[i] = paramInt;
    this.objects[i] = paramObject;
    this.count = i + 1;
  }
  
  void checkMutable() {
    if (this.isMutable)
      return; 
    throw new UnsupportedOperationException();
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (!(paramObject instanceof UnknownFieldSetLite))
      return false; 
    paramObject = paramObject;
    return !(this.count != ((UnknownFieldSetLite)paramObject).count || !Arrays.equals(this.tags, ((UnknownFieldSetLite)paramObject).tags) || !Arrays.deepEquals(this.objects, ((UnknownFieldSetLite)paramObject).objects));
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    byte b = 0;
    i = 0;
    while (b < this.count) {
      int j = this.tags[b];
      int k = WireFormat.getTagFieldNumber(j);
      j = WireFormat.getTagWireType(j);
      if (j != 5) {
        switch (j) {
          default:
            throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
          case 3:
            i += CodedOutputStream.computeTagSize(k) * 2 + ((UnknownFieldSetLite)this.objects[b]).getSerializedSize();
            break;
          case 2:
            i += CodedOutputStream.computeBytesSize(k, (ByteString)this.objects[b]);
            break;
          case 1:
            i += CodedOutputStream.computeFixed64Size(k, ((Long)this.objects[b]).longValue());
            break;
          case 0:
            i += CodedOutputStream.computeUInt64Size(k, ((Long)this.objects[b]).longValue());
            break;
        } 
      } else {
        i += CodedOutputStream.computeFixed32Size(k, ((Integer)this.objects[b]).intValue());
      } 
      b++;
    } 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public int hashCode() {
    return ((527 + this.count) * 31 + Arrays.hashCode(this.tags)) * 31 + Arrays.deepHashCode(this.objects);
  }
  
  public void makeImmutable() {
    this.isMutable = false;
  }
  
  boolean mergeFieldFrom(int paramInt, CodedInputStream paramCodedInputStream) throws IOException {
    UnknownFieldSetLite unknownFieldSetLite;
    checkMutable();
    int i = WireFormat.getTagFieldNumber(paramInt);
    switch (WireFormat.getTagWireType(paramInt)) {
      default:
        throw InvalidProtocolBufferException.invalidWireType();
      case 5:
        storeField(paramInt, Integer.valueOf(paramCodedInputStream.readFixed32()));
        return true;
      case 4:
        return false;
      case 3:
        unknownFieldSetLite = new UnknownFieldSetLite();
        unknownFieldSetLite.mergeFrom(paramCodedInputStream);
        paramCodedInputStream.checkLastTagWas(WireFormat.makeTag(i, 4));
        storeField(paramInt, unknownFieldSetLite);
        return true;
      case 2:
        storeField(paramInt, paramCodedInputStream.readBytes());
        return true;
      case 1:
        storeField(paramInt, Long.valueOf(paramCodedInputStream.readFixed64()));
        return true;
      case 0:
        break;
    } 
    storeField(paramInt, Long.valueOf(paramCodedInputStream.readInt64()));
    return true;
  }
  
  UnknownFieldSetLite mergeLengthDelimitedField(int paramInt, ByteString paramByteString) {
    checkMutable();
    if (paramInt != 0) {
      storeField(WireFormat.makeTag(paramInt, 2), paramByteString);
      return this;
    } 
    throw new IllegalArgumentException("Zero is not a valid field number.");
  }
  
  UnknownFieldSetLite mergeVarintField(int paramInt1, int paramInt2) {
    checkMutable();
    if (paramInt1 != 0) {
      storeField(WireFormat.makeTag(paramInt1, 0), Long.valueOf(paramInt2));
      return this;
    } 
    throw new IllegalArgumentException("Zero is not a valid field number.");
  }
  
  final void printWithIndent(StringBuilder paramStringBuilder, int paramInt) {
    for (byte b = 0; b < this.count; b++)
      MessageLiteToString.printField(paramStringBuilder, paramInt, String.valueOf(WireFormat.getTagFieldNumber(this.tags[b])), this.objects[b]); 
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (byte b = 0; b < this.count; b++) {
      int i = this.tags[b];
      int j = WireFormat.getTagFieldNumber(i);
      i = WireFormat.getTagWireType(i);
      if (i != 5) {
        switch (i) {
          default:
            throw InvalidProtocolBufferException.invalidWireType();
          case 3:
            paramCodedOutputStream.writeTag(j, 3);
            ((UnknownFieldSetLite)this.objects[b]).writeTo(paramCodedOutputStream);
            paramCodedOutputStream.writeTag(j, 4);
            break;
          case 2:
            paramCodedOutputStream.writeBytes(j, (ByteString)this.objects[b]);
            break;
          case 1:
            paramCodedOutputStream.writeFixed64(j, ((Long)this.objects[b]).longValue());
            break;
          case 0:
            paramCodedOutputStream.writeUInt64(j, ((Long)this.objects[b]).longValue());
            break;
        } 
      } else {
        paramCodedOutputStream.writeFixed32(j, ((Integer)this.objects[b]).intValue());
      } 
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\UnknownFieldSetLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */