package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Challenge;
import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.util.List;

public final class AuthenticatorAdapter implements Authenticator {
  public static final Authenticator INSTANCE = new AuthenticatorAdapter();
  
  private InetAddress getConnectToInetAddress(Proxy paramProxy, HttpUrl paramHttpUrl) throws IOException {
    InetAddress inetAddress;
    if (paramProxy != null && paramProxy.type() != Proxy.Type.DIRECT) {
      inetAddress = ((InetSocketAddress)paramProxy.address()).getAddress();
    } else {
      inetAddress = InetAddress.getByName(paramHttpUrl.host());
    } 
    return inetAddress;
  }
  
  public Request authenticate(Proxy paramProxy, Response paramResponse) throws IOException {
    List<Challenge> list = paramResponse.challenges();
    Request request = paramResponse.request();
    HttpUrl httpUrl = request.httpUrl();
    int i = list.size();
    for (byte b = 0; b < i; b++) {
      Challenge challenge = list.get(b);
      if ("Basic".equalsIgnoreCase(challenge.getScheme())) {
        PasswordAuthentication passwordAuthentication = Authenticator.requestPasswordAuthentication(httpUrl.host(), getConnectToInetAddress(paramProxy, httpUrl), httpUrl.port(), httpUrl.scheme(), challenge.getRealm(), challenge.getScheme(), httpUrl.url(), Authenticator.RequestorType.SERVER);
        if (passwordAuthentication != null) {
          String str = Credentials.basic(passwordAuthentication.getUserName(), new String(passwordAuthentication.getPassword()));
          return request.newBuilder().header("Authorization", str).build();
        } 
      } 
    } 
    return null;
  }
  
  public Request authenticateProxy(Proxy paramProxy, Response paramResponse) throws IOException {
    List<Challenge> list = paramResponse.challenges();
    Request request = paramResponse.request();
    HttpUrl httpUrl = request.httpUrl();
    int i = list.size();
    for (byte b = 0; b < i; b++) {
      Challenge challenge = list.get(b);
      if ("Basic".equalsIgnoreCase(challenge.getScheme())) {
        InetSocketAddress inetSocketAddress = (InetSocketAddress)paramProxy.address();
        PasswordAuthentication passwordAuthentication = Authenticator.requestPasswordAuthentication(inetSocketAddress.getHostName(), getConnectToInetAddress(paramProxy, httpUrl), inetSocketAddress.getPort(), httpUrl.scheme(), challenge.getRealm(), challenge.getScheme(), httpUrl.url(), Authenticator.RequestorType.PROXY);
        if (passwordAuthentication != null) {
          String str = Credentials.basic(passwordAuthentication.getUserName(), new String(passwordAuthentication.getPassword()));
          return request.newBuilder().header("Proxy-Authorization", str).build();
        } 
      } 
    } 
    return null;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\okhttp\internal\http\AuthenticatorAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */