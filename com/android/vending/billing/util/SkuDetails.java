package com.android.vending.billing.util;

import org.json.JSONException;
import org.json.JSONObject;

public class SkuDetails {
  String mDescription;
  
  String mItemType;
  
  String mJson;
  
  String mPrice;
  
  String mSku;
  
  String mTitle;
  
  String mType;
  
  public SkuDetails(String paramString) throws JSONException {
    this("inapp", paramString);
  }
  
  public SkuDetails(String paramString1, String paramString2) throws JSONException {
    this.mItemType = paramString1;
    this.mJson = paramString2;
    JSONObject jSONObject = new JSONObject(this.mJson);
    this.mSku = jSONObject.optString("productId");
    this.mType = jSONObject.optString("type");
    this.mPrice = jSONObject.optString("price");
    this.mTitle = jSONObject.optString("title");
    this.mDescription = jSONObject.optString("description");
  }
  
  public String getDescription() {
    return this.mDescription;
  }
  
  public String getPrice() {
    return this.mPrice;
  }
  
  public String getSku() {
    return this.mSku;
  }
  
  public String getTitle() {
    return this.mTitle;
  }
  
  public String getType() {
    return this.mType;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SkuDetails:");
    stringBuilder.append(this.mJson);
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\android\vending\billin\\util\SkuDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */