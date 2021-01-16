package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class ProtoStorageClient {
  private final Application application;
  
  private final String fileName;
  
  public ProtoStorageClient(Application paramApplication, String paramString) {
    this.application = paramApplication;
    this.fileName = paramString;
  }
  
  public <T extends AbstractMessageLite> Maybe<T> read(Parser<T> paramParser) {
    return Maybe.fromCallable(ProtoStorageClient$$Lambda$2.lambdaFactory$(this, paramParser));
  }
  
  public Completable write(AbstractMessageLite paramAbstractMessageLite) {
    return Completable.fromCallable(ProtoStorageClient$$Lambda$1.lambdaFactory$(this, paramAbstractMessageLite));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\ProtoStorageClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */