package com.squareup.okhttp.internal.tls;

import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.security.auth.x500.X500Principal;

public final class RealTrustRootIndex implements TrustRootIndex {
  private final Map<X500Principal, List<X509Certificate>> subjectToCaCerts = new LinkedHashMap<X500Principal, List<X509Certificate>>();
  
  public RealTrustRootIndex(X509Certificate... paramVarArgs) {
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++) {
      X509Certificate x509Certificate = paramVarArgs[b];
      X500Principal x500Principal = x509Certificate.getSubjectX500Principal();
      List<X509Certificate> list1 = this.subjectToCaCerts.get(x500Principal);
      List<X509Certificate> list2 = list1;
      if (list1 == null) {
        list2 = new ArrayList(1);
        this.subjectToCaCerts.put(x500Principal, list2);
      } 
      list2.add(x509Certificate);
    } 
  }
  
  public X509Certificate findByIssuerAndSignature(X509Certificate paramX509Certificate) {
    X500Principal x500Principal = paramX509Certificate.getIssuerX500Principal();
    List list = this.subjectToCaCerts.get(x500Principal);
    if (list == null)
      return null; 
    Iterator<X509Certificate> iterator = list.iterator();
    while (true) {
      if (iterator.hasNext()) {
        X509Certificate x509Certificate = iterator.next();
        PublicKey publicKey = x509Certificate.getPublicKey();
        try {
          paramX509Certificate.verify(publicKey);
          return x509Certificate;
        } catch (Exception exception) {
          continue;
        } 
      } 
      return null;
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\okhttp\internal\tls\RealTrustRootIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */