package com.google.firebase.inappmessaging.model;

final class AutoValue_RateLimit extends RateLimit {
  private final long limit;
  
  private final String limiterKey;
  
  private final long timeToLiveMillis;
  
  private AutoValue_RateLimit(String paramString, long paramLong1, long paramLong2) {
    this.limiterKey = paramString;
    this.limit = paramLong1;
    this.timeToLiveMillis = paramLong2;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof RateLimit) {
      paramObject = paramObject;
      if (!this.limiterKey.equals(paramObject.limiterKey()) || this.limit != paramObject.limit() || this.timeToLiveMillis != paramObject.timeToLiveMillis())
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public int hashCode() {
    int i = this.limiterKey.hashCode();
    long l = this.limit;
    int j = (int)(l ^ l >>> 32L);
    l = this.timeToLiveMillis;
    return ((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ (int)(l ^ l >>> 32L);
  }
  
  public long limit() {
    return this.limit;
  }
  
  public String limiterKey() {
    return this.limiterKey;
  }
  
  public long timeToLiveMillis() {
    return this.timeToLiveMillis;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("RateLimit{limiterKey=");
    stringBuilder.append(this.limiterKey);
    stringBuilder.append(", limit=");
    stringBuilder.append(this.limit);
    stringBuilder.append(", timeToLiveMillis=");
    stringBuilder.append(this.timeToLiveMillis);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  static final class Builder extends RateLimit.Builder {
    private Long limit;
    
    private String limiterKey;
    
    private Long timeToLiveMillis;
    
    public RateLimit build() {
      String str1 = "";
      if (this.limiterKey == null) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("");
        stringBuilder1.append(" limiterKey");
        str1 = stringBuilder1.toString();
      } 
      String str2 = str1;
      if (this.limit == null) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str1);
        stringBuilder1.append(" limit");
        str2 = stringBuilder1.toString();
      } 
      str1 = str2;
      if (this.timeToLiveMillis == null) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str2);
        stringBuilder1.append(" timeToLiveMillis");
        str1 = stringBuilder1.toString();
      } 
      if (str1.isEmpty())
        return new AutoValue_RateLimit(this.limiterKey, this.limit.longValue(), this.timeToLiveMillis.longValue()); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Missing required properties:");
      stringBuilder.append(str1);
      throw new IllegalStateException(stringBuilder.toString());
    }
    
    public RateLimit.Builder setLimit(long param1Long) {
      this.limit = Long.valueOf(param1Long);
      return this;
    }
    
    public RateLimit.Builder setLimiterKey(String param1String) {
      if (param1String != null) {
        this.limiterKey = param1String;
        return this;
      } 
      throw new NullPointerException("Null limiterKey");
    }
    
    public RateLimit.Builder setTimeToLiveMillis(long param1Long) {
      this.timeToLiveMillis = Long.valueOf(param1Long);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\model\AutoValue_RateLimit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */