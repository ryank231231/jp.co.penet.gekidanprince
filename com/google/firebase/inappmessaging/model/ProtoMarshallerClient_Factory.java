package com.google.firebase.inappmessaging.model;

import dagger.internal.Factory;

public final class ProtoMarshallerClient_Factory implements Factory<ProtoMarshallerClient> {
  private static final ProtoMarshallerClient_Factory INSTANCE = new ProtoMarshallerClient_Factory();
  
  public static Factory<ProtoMarshallerClient> create() {
    return INSTANCE;
  }
  
  public static ProtoMarshallerClient newProtoMarshallerClient() {
    return new ProtoMarshallerClient();
  }
  
  public ProtoMarshallerClient get() {
    return new ProtoMarshallerClient();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\model\ProtoMarshallerClient_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */