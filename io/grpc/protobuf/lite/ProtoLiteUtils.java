package io.grpc.protobuf.lite;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import io.grpc.ExperimentalApi;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

@ExperimentalApi("Experimental until Lite is stable in protobuf")
public class ProtoLiteUtils {
  private static final int BUF_SIZE = 8192;
  
  @VisibleForTesting
  static final int DEFAULT_MAX_MESSAGE_SIZE = 4194304;
  
  private static final ThreadLocal<Reference<byte[]>> bufs;
  
  private static volatile ExtensionRegistryLite globalRegistry = ExtensionRegistryLite.getEmptyRegistry();
  
  static {
    bufs = new ThreadLocal<Reference<byte[]>>() {
        protected Reference<byte[]> initialValue() {
          return (Reference)new WeakReference<byte>(new byte[4096]);
        }
      };
  }
  
  static long copy(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
    Preconditions.checkNotNull(paramInputStream);
    Preconditions.checkNotNull(paramOutputStream);
    byte[] arrayOfByte = new byte[8192];
    for (long l = 0L;; l += i) {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1)
        return l; 
      paramOutputStream.write(arrayOfByte, 0, i);
    } 
  }
  
  public static <T extends MessageLite> MethodDescriptor.Marshaller<T> marshaller(final T defaultInstance) {
    return (MethodDescriptor.Marshaller<T>)new MethodDescriptor.PrototypeMarshaller<T>() {
        private T parseFrom(CodedInputStream param1CodedInputStream) throws InvalidProtocolBufferException {
          MessageLite messageLite = (MessageLite)parser.parseFrom(param1CodedInputStream, ProtoLiteUtils.globalRegistry);
          try {
            param1CodedInputStream.checkLastTagWas(0);
            return (T)messageLite;
          } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            invalidProtocolBufferException.setUnfinishedMessage(messageLite);
            throw invalidProtocolBufferException;
          } 
        }
        
        public Class<T> getMessageClass() {
          return (Class)defaultInstance.getClass();
        }
        
        public T getMessagePrototype() {
          return (T)defaultInstance;
        }
        
        public T parse(InputStream param1InputStream) {
          // Byte code:
          //   0: aload_1
          //   1: instanceof io/grpc/protobuf/lite/ProtoInputStream
          //   4: ifeq -> 31
          //   7: aload_1
          //   8: checkcast io/grpc/protobuf/lite/ProtoInputStream
          //   11: invokevirtual parser : ()Lcom/google/protobuf/Parser;
          //   14: aload_0
          //   15: getfield val$parser : Lcom/google/protobuf/Parser;
          //   18: if_acmpne -> 31
          //   21: aload_1
          //   22: checkcast io/grpc/protobuf/lite/ProtoInputStream
          //   25: invokevirtual message : ()Lcom/google/protobuf/MessageLite;
          //   28: astore_2
          //   29: aload_2
          //   30: areturn
          //   31: aconst_null
          //   32: astore_3
          //   33: aload_3
          //   34: astore_2
          //   35: aload_1
          //   36: instanceof io/grpc/KnownLength
          //   39: ifeq -> 240
          //   42: aload_1
          //   43: invokevirtual available : ()I
          //   46: istore #4
          //   48: iload #4
          //   50: ifle -> 226
          //   53: iload #4
          //   55: ldc 4194304
          //   57: if_icmpgt -> 226
          //   60: invokestatic access$000 : ()Ljava/lang/ThreadLocal;
          //   63: invokevirtual get : ()Ljava/lang/Object;
          //   66: checkcast java/lang/ref/Reference
          //   69: invokevirtual get : ()Ljava/lang/Object;
          //   72: checkcast [B
          //   75: astore_3
          //   76: aload_3
          //   77: ifnull -> 89
          //   80: aload_3
          //   81: astore_2
          //   82: aload_3
          //   83: arraylength
          //   84: iload #4
          //   86: if_icmpge -> 115
          //   89: iload #4
          //   91: newarray byte
          //   93: astore_2
          //   94: invokestatic access$000 : ()Ljava/lang/ThreadLocal;
          //   97: astore_3
          //   98: new java/lang/ref/WeakReference
          //   101: astore #5
          //   103: aload #5
          //   105: aload_2
          //   106: invokespecial <init> : (Ljava/lang/Object;)V
          //   109: aload_3
          //   110: aload #5
          //   112: invokevirtual set : (Ljava/lang/Object;)V
          //   115: iload #4
          //   117: istore #6
          //   119: iload #6
          //   121: ifle -> 157
          //   124: aload_1
          //   125: aload_2
          //   126: iload #4
          //   128: iload #6
          //   130: isub
          //   131: iload #6
          //   133: invokevirtual read : ([BII)I
          //   136: istore #7
          //   138: iload #7
          //   140: iconst_m1
          //   141: if_icmpne -> 147
          //   144: goto -> 157
          //   147: iload #6
          //   149: iload #7
          //   151: isub
          //   152: istore #6
          //   154: goto -> 119
          //   157: iload #6
          //   159: ifne -> 173
          //   162: aload_2
          //   163: iconst_0
          //   164: iload #4
          //   166: invokestatic newInstance : ([BII)Lcom/google/protobuf/CodedInputStream;
          //   169: astore_2
          //   170: goto -> 240
          //   173: new java/lang/RuntimeException
          //   176: astore_1
          //   177: new java/lang/StringBuilder
          //   180: astore_2
          //   181: aload_2
          //   182: invokespecial <init> : ()V
          //   185: aload_2
          //   186: ldc 'size inaccurate: '
          //   188: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   191: pop
          //   192: aload_2
          //   193: iload #4
          //   195: invokevirtual append : (I)Ljava/lang/StringBuilder;
          //   198: pop
          //   199: aload_2
          //   200: ldc ' != '
          //   202: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   205: pop
          //   206: aload_2
          //   207: iload #4
          //   209: iload #6
          //   211: isub
          //   212: invokevirtual append : (I)Ljava/lang/StringBuilder;
          //   215: pop
          //   216: aload_1
          //   217: aload_2
          //   218: invokevirtual toString : ()Ljava/lang/String;
          //   221: invokespecial <init> : (Ljava/lang/String;)V
          //   224: aload_1
          //   225: athrow
          //   226: aload_3
          //   227: astore_2
          //   228: iload #4
          //   230: ifne -> 240
          //   233: aload_0
          //   234: getfield val$defaultInstance : Lcom/google/protobuf/MessageLite;
          //   237: astore_1
          //   238: aload_1
          //   239: areturn
          //   240: aload_2
          //   241: astore_3
          //   242: aload_2
          //   243: ifnonnull -> 251
          //   246: aload_1
          //   247: invokestatic newInstance : (Ljava/io/InputStream;)Lcom/google/protobuf/CodedInputStream;
          //   250: astore_3
          //   251: aload_3
          //   252: ldc 2147483647
          //   254: invokevirtual setSizeLimit : (I)I
          //   257: pop
          //   258: aload_0
          //   259: aload_3
          //   260: invokespecial parseFrom : (Lcom/google/protobuf/CodedInputStream;)Lcom/google/protobuf/MessageLite;
          //   263: astore_1
          //   264: aload_1
          //   265: areturn
          //   266: astore_1
          //   267: getstatic io/grpc/Status.INTERNAL : Lio/grpc/Status;
          //   270: ldc 'Invalid protobuf byte sequence'
          //   272: invokevirtual withDescription : (Ljava/lang/String;)Lio/grpc/Status;
          //   275: aload_1
          //   276: invokevirtual withCause : (Ljava/lang/Throwable;)Lio/grpc/Status;
          //   279: invokevirtual asRuntimeException : ()Lio/grpc/StatusRuntimeException;
          //   282: athrow
          //   283: astore_1
          //   284: new java/lang/RuntimeException
          //   287: dup
          //   288: aload_1
          //   289: invokespecial <init> : (Ljava/lang/Throwable;)V
          //   292: athrow
          //   293: astore_2
          //   294: goto -> 31
          // Exception table:
          //   from	to	target	type
          //   21	29	293	java/lang/IllegalStateException
          //   35	48	283	java/io/IOException
          //   60	76	283	java/io/IOException
          //   82	89	283	java/io/IOException
          //   89	115	283	java/io/IOException
          //   124	138	283	java/io/IOException
          //   162	170	283	java/io/IOException
          //   173	226	283	java/io/IOException
          //   233	238	283	java/io/IOException
          //   258	264	266	com/google/protobuf/InvalidProtocolBufferException
        }
        
        public InputStream stream(T param1T) {
          return new ProtoInputStream((MessageLite)param1T, parser);
        }
      };
  }
  
  public static <T extends MessageLite> Metadata.BinaryMarshaller<T> metadataMarshaller(final T instance) {
    return new Metadata.BinaryMarshaller<T>() {
        public T parseBytes(byte[] param1ArrayOfbyte) {
          try {
            return (T)instance.getParserForType().parseFrom(param1ArrayOfbyte, ProtoLiteUtils.globalRegistry);
          } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            throw new IllegalArgumentException(invalidProtocolBufferException);
          } 
        }
        
        public byte[] toBytes(T param1T) {
          return param1T.toByteArray();
        }
      };
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1787")
  public static void setExtensionRegistry(ExtensionRegistryLite paramExtensionRegistryLite) {
    globalRegistry = (ExtensionRegistryLite)Preconditions.checkNotNull(paramExtensionRegistryLite, "newRegistry");
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\protobuf\lite\ProtoLiteUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */