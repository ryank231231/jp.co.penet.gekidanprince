package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import com.squareup.okhttp.CipherSuite;
import com.squareup.okhttp.ConnectionSpec;
import com.squareup.okhttp.TlsVersion;
import io.grpc.InternalMetadata;
import io.grpc.Metadata;
import io.grpc.internal.Channelz;
import io.grpc.internal.TransportFrameUtil;
import io.grpc.okhttp.internal.CipherSuite;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.framed.Header;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class Utils {
  static final int CONNECTION_STREAM_ID = 0;
  
  static final int DEFAULT_WINDOW_SIZE = 65535;
  
  private static final Logger log = Logger.getLogger(Utils.class.getName());
  
  public static Metadata convertHeaders(List<Header> paramList) {
    return InternalMetadata.newMetadata(convertHeadersToArray(paramList));
  }
  
  private static byte[][] convertHeadersToArray(List<Header> paramList) {
    byte[][] arrayOfByte = new byte[paramList.size() * 2][];
    Iterator<Header> iterator = paramList.iterator();
    int i = 0;
    while (iterator.hasNext()) {
      Header header = iterator.next();
      int j = i + 1;
      arrayOfByte[i] = header.name.toByteArray();
      i = j + 1;
      arrayOfByte[j] = header.value.toByteArray();
    } 
    return TransportFrameUtil.toRawSerializedHeaders(arrayOfByte);
  }
  
  static ConnectionSpec convertSpec(ConnectionSpec paramConnectionSpec) {
    Preconditions.checkArgument(paramConnectionSpec.isTls(), "plaintext ConnectionSpec is not accepted");
    List<TlsVersion> list = paramConnectionSpec.tlsVersions();
    String[] arrayOfString = new String[list.size()];
    boolean bool = false;
    byte b;
    for (b = 0; b < arrayOfString.length; b++)
      arrayOfString[b] = ((TlsVersion)list.get(b)).javaName(); 
    list = paramConnectionSpec.cipherSuites();
    CipherSuite[] arrayOfCipherSuite = new CipherSuite[list.size()];
    for (b = bool; b < arrayOfCipherSuite.length; b++)
      arrayOfCipherSuite[b] = CipherSuite.valueOf(((CipherSuite)list.get(b)).name()); 
    return (new ConnectionSpec.Builder(paramConnectionSpec.isTls())).supportsTlsExtensions(paramConnectionSpec.supportsTlsExtensions()).tlsVersions(arrayOfString).cipherSuites(arrayOfCipherSuite).build();
  }
  
  public static Metadata convertTrailers(List<Header> paramList) {
    return InternalMetadata.newMetadata(convertHeadersToArray(paramList));
  }
  
  static Channelz.SocketOptions getSocketOptions(Socket paramSocket) {
    Channelz.SocketOptions.Builder builder = new Channelz.SocketOptions.Builder();
    try {
      builder.setSocketOptionLingerSeconds(Integer.valueOf(paramSocket.getSoLinger()));
    } catch (SocketException socketException) {
      log.log(Level.SEVERE, "Exception caught while reading socket option", socketException);
      builder.addOption("SO_LINGER", "channelz_internal_error");
    } 
    try {
      builder.setSocketOptionTimeoutMillis(Integer.valueOf(paramSocket.getSoTimeout()));
    } catch (Exception exception) {
      log.log(Level.SEVERE, "Exception caught while reading socket option", exception);
      builder.addOption("SO_TIMEOUT", "channelz_internal_error");
    } 
    try {
      builder.addOption("TCP_NODELAY", paramSocket.getTcpNoDelay());
    } catch (SocketException socketException) {
      log.log(Level.SEVERE, "Exception caught while reading socket option", socketException);
      builder.addOption("TCP_NODELAY", "channelz_internal_error");
    } 
    try {
      builder.addOption("SO_REUSEADDR", paramSocket.getReuseAddress());
    } catch (SocketException socketException) {
      log.log(Level.SEVERE, "Exception caught while reading socket option", socketException);
      builder.addOption("SO_REUSEADDR", "channelz_internal_error");
    } 
    try {
      builder.addOption("SO_SNDBUF", paramSocket.getSendBufferSize());
    } catch (SocketException socketException) {
      log.log(Level.SEVERE, "Exception caught while reading socket option", socketException);
      builder.addOption("SO_SNDBUF", "channelz_internal_error");
    } 
    try {
      builder.addOption("SO_RECVBUF", paramSocket.getReceiveBufferSize());
    } catch (SocketException socketException) {
      log.log(Level.SEVERE, "Exception caught while reading socket option", socketException);
      builder.addOption("SO_RECVBUF", "channelz_internal_error");
    } 
    try {
      builder.addOption("SO_KEEPALIVE", paramSocket.getKeepAlive());
    } catch (SocketException socketException) {
      log.log(Level.SEVERE, "Exception caught while reading socket option", socketException);
      builder.addOption("SO_KEEPALIVE", "channelz_internal_error");
    } 
    try {
      builder.addOption("SO_OOBINLINE", paramSocket.getOOBInline());
    } catch (SocketException socketException) {
      log.log(Level.SEVERE, "Exception caught while reading socket option", socketException);
      builder.addOption("SO_OOBINLINE", "channelz_internal_error");
    } 
    try {
      builder.addOption("IP_TOS", paramSocket.getTrafficClass());
    } catch (SocketException socketException) {
      log.log(Level.SEVERE, "Exception caught while reading socket option", socketException);
      builder.addOption("IP_TOS", "channelz_internal_error");
    } 
    return builder.build();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\okhttp\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */