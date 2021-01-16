package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

final class zzgf extends SSLSocket {
  private final SSLSocket zztg;
  
  zzgf(zzge paramzzge, SSLSocket paramSSLSocket) {
    this.zztg = paramSSLSocket;
  }
  
  public final void addHandshakeCompletedListener(HandshakeCompletedListener paramHandshakeCompletedListener) {
    this.zztg.addHandshakeCompletedListener(paramHandshakeCompletedListener);
  }
  
  public final void bind(SocketAddress paramSocketAddress) throws IOException {
    this.zztg.bind(paramSocketAddress);
  }
  
  public final void close() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zztg : Ljavax/net/ssl/SSLSocket;
    //   6: invokevirtual close : ()V
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	12	finally
  }
  
  public final void connect(SocketAddress paramSocketAddress) throws IOException {
    this.zztg.connect(paramSocketAddress);
  }
  
  public final void connect(SocketAddress paramSocketAddress, int paramInt) throws IOException {
    this.zztg.connect(paramSocketAddress, paramInt);
  }
  
  public final boolean equals(Object paramObject) {
    return this.zztg.equals(paramObject);
  }
  
  public final SocketChannel getChannel() {
    return this.zztg.getChannel();
  }
  
  public final boolean getEnableSessionCreation() {
    return this.zztg.getEnableSessionCreation();
  }
  
  public final String[] getEnabledCipherSuites() {
    return this.zztg.getEnabledCipherSuites();
  }
  
  public final String[] getEnabledProtocols() {
    return this.zztg.getEnabledProtocols();
  }
  
  public final InetAddress getInetAddress() {
    return this.zztg.getInetAddress();
  }
  
  public final InputStream getInputStream() throws IOException {
    return this.zztg.getInputStream();
  }
  
  public final boolean getKeepAlive() throws SocketException {
    return this.zztg.getKeepAlive();
  }
  
  public final InetAddress getLocalAddress() {
    return this.zztg.getLocalAddress();
  }
  
  public final int getLocalPort() {
    return this.zztg.getLocalPort();
  }
  
  public final SocketAddress getLocalSocketAddress() {
    return this.zztg.getLocalSocketAddress();
  }
  
  public final boolean getNeedClientAuth() {
    return this.zztg.getNeedClientAuth();
  }
  
  public final boolean getOOBInline() throws SocketException {
    return this.zztg.getOOBInline();
  }
  
  public final OutputStream getOutputStream() throws IOException {
    return this.zztg.getOutputStream();
  }
  
  public final int getPort() {
    return this.zztg.getPort();
  }
  
  public final int getReceiveBufferSize() throws SocketException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zztg : Ljavax/net/ssl/SSLSocket;
    //   6: invokevirtual getReceiveBufferSize : ()I
    //   9: istore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: iload_1
    //   13: ireturn
    //   14: astore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_2
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public final SocketAddress getRemoteSocketAddress() {
    return this.zztg.getRemoteSocketAddress();
  }
  
  public final boolean getReuseAddress() throws SocketException {
    return this.zztg.getReuseAddress();
  }
  
  public final int getSendBufferSize() throws SocketException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zztg : Ljavax/net/ssl/SSLSocket;
    //   6: invokevirtual getSendBufferSize : ()I
    //   9: istore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: iload_1
    //   13: ireturn
    //   14: astore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_2
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public final SSLSession getSession() {
    return this.zztg.getSession();
  }
  
  public final int getSoLinger() throws SocketException {
    return this.zztg.getSoLinger();
  }
  
  public final int getSoTimeout() throws SocketException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zztg : Ljavax/net/ssl/SSLSocket;
    //   6: invokevirtual getSoTimeout : ()I
    //   9: istore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: iload_1
    //   13: ireturn
    //   14: astore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_2
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public final String[] getSupportedCipherSuites() {
    return this.zztg.getSupportedCipherSuites();
  }
  
  public final String[] getSupportedProtocols() {
    return this.zztg.getSupportedProtocols();
  }
  
  public final boolean getTcpNoDelay() throws SocketException {
    return this.zztg.getTcpNoDelay();
  }
  
  public final int getTrafficClass() throws SocketException {
    return this.zztg.getTrafficClass();
  }
  
  public final boolean getUseClientMode() {
    return this.zztg.getUseClientMode();
  }
  
  public final boolean getWantClientAuth() {
    return this.zztg.getWantClientAuth();
  }
  
  public final boolean isBound() {
    return this.zztg.isBound();
  }
  
  public final boolean isClosed() {
    return this.zztg.isClosed();
  }
  
  public final boolean isConnected() {
    return this.zztg.isConnected();
  }
  
  public final boolean isInputShutdown() {
    return this.zztg.isInputShutdown();
  }
  
  public final boolean isOutputShutdown() {
    return this.zztg.isOutputShutdown();
  }
  
  public final void removeHandshakeCompletedListener(HandshakeCompletedListener paramHandshakeCompletedListener) {
    this.zztg.removeHandshakeCompletedListener(paramHandshakeCompletedListener);
  }
  
  public final void sendUrgentData(int paramInt) throws IOException {
    this.zztg.sendUrgentData(paramInt);
  }
  
  public final void setEnableSessionCreation(boolean paramBoolean) {
    this.zztg.setEnableSessionCreation(paramBoolean);
  }
  
  public final void setEnabledCipherSuites(String[] paramArrayOfString) {
    this.zztg.setEnabledCipherSuites(paramArrayOfString);
  }
  
  public final void setEnabledProtocols(String[] paramArrayOfString) {
    String[] arrayOfString = paramArrayOfString;
    if (paramArrayOfString != null) {
      arrayOfString = paramArrayOfString;
      if (Arrays.<String>asList(paramArrayOfString).contains("SSLv3")) {
        ArrayList arrayList = new ArrayList(Arrays.asList((Object[])this.zztg.getEnabledProtocols()));
        if (arrayList.size() > 1)
          arrayList.remove("SSLv3"); 
        arrayOfString = (String[])arrayList.toArray((Object[])new String[arrayList.size()]);
      } 
    } 
    this.zztg.setEnabledProtocols(arrayOfString);
  }
  
  public final void setKeepAlive(boolean paramBoolean) throws SocketException {
    this.zztg.setKeepAlive(paramBoolean);
  }
  
  public final void setNeedClientAuth(boolean paramBoolean) {
    this.zztg.setNeedClientAuth(paramBoolean);
  }
  
  public final void setOOBInline(boolean paramBoolean) throws SocketException {
    this.zztg.setOOBInline(paramBoolean);
  }
  
  public final void setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3) {
    this.zztg.setPerformancePreferences(paramInt1, paramInt2, paramInt3);
  }
  
  public final void setReceiveBufferSize(int paramInt) throws SocketException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zztg : Ljavax/net/ssl/SSLSocket;
    //   6: iload_1
    //   7: invokevirtual setReceiveBufferSize : (I)V
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: astore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_2
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	13	finally
  }
  
  public final void setReuseAddress(boolean paramBoolean) throws SocketException {
    this.zztg.setReuseAddress(paramBoolean);
  }
  
  public final void setSendBufferSize(int paramInt) throws SocketException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zztg : Ljavax/net/ssl/SSLSocket;
    //   6: iload_1
    //   7: invokevirtual setSendBufferSize : (I)V
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: astore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_2
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	13	finally
  }
  
  public final void setSoLinger(boolean paramBoolean, int paramInt) throws SocketException {
    this.zztg.setSoLinger(paramBoolean, paramInt);
  }
  
  public final void setSoTimeout(int paramInt) throws SocketException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zztg : Ljavax/net/ssl/SSLSocket;
    //   6: iload_1
    //   7: invokevirtual setSoTimeout : (I)V
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: astore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_2
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	13	finally
  }
  
  public final void setTcpNoDelay(boolean paramBoolean) throws SocketException {
    this.zztg.setTcpNoDelay(paramBoolean);
  }
  
  public final void setTrafficClass(int paramInt) throws SocketException {
    this.zztg.setTrafficClass(paramInt);
  }
  
  public final void setUseClientMode(boolean paramBoolean) {
    this.zztg.setUseClientMode(paramBoolean);
  }
  
  public final void setWantClientAuth(boolean paramBoolean) {
    this.zztg.setWantClientAuth(paramBoolean);
  }
  
  public final void shutdownInput() throws IOException {
    this.zztg.shutdownInput();
  }
  
  public final void shutdownOutput() throws IOException {
    this.zztg.shutdownOutput();
  }
  
  public final void startHandshake() throws IOException {
    this.zztg.startHandshake();
  }
  
  public final String toString() {
    return this.zztg.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzgf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */