package com.google.firebase.platforminfo;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import java.util.Iterator;
import java.util.Set;

public class DefaultUserAgentPublisher implements UserAgentPublisher {
  private final GlobalLibraryVersionRegistrar gamesSDKRegistrar;
  
  private final String javaSDKVersionUserAgent;
  
  DefaultUserAgentPublisher(Set<LibraryVersion> paramSet, GlobalLibraryVersionRegistrar paramGlobalLibraryVersionRegistrar) {
    this.javaSDKVersionUserAgent = toUserAgent(paramSet);
    this.gamesSDKRegistrar = paramGlobalLibraryVersionRegistrar;
  }
  
  public static Component<UserAgentPublisher> component() {
    return Component.builder(UserAgentPublisher.class).add(Dependency.setOf(LibraryVersion.class)).factory(DefaultUserAgentPublisher$$Lambda$1.lambdaFactory$()).build();
  }
  
  private static String toUserAgent(Set<LibraryVersion> paramSet) {
    StringBuilder stringBuilder = new StringBuilder();
    Iterator<LibraryVersion> iterator = paramSet.iterator();
    while (iterator.hasNext()) {
      LibraryVersion libraryVersion = iterator.next();
      stringBuilder.append(libraryVersion.getLibraryName());
      stringBuilder.append('/');
      stringBuilder.append(libraryVersion.getVersion());
      if (iterator.hasNext())
        stringBuilder.append(' '); 
    } 
    return stringBuilder.toString();
  }
  
  public String getUserAgent() {
    if (this.gamesSDKRegistrar.getRegisteredVersions().isEmpty())
      return this.javaSDKVersionUserAgent; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.javaSDKVersionUserAgent);
    stringBuilder.append(' ');
    stringBuilder.append(toUserAgent(this.gamesSDKRegistrar.getRegisteredVersions()));
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\platforminfo\DefaultUserAgentPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */