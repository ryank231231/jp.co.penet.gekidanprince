package com.android.vending.billing.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
  Map<String, Purchase> mPurchaseMap = new HashMap<String, Purchase>();
  
  Map<String, SkuDetails> mSkuMap = new HashMap<String, SkuDetails>();
  
  void addPurchase(Purchase paramPurchase) {
    this.mPurchaseMap.put(paramPurchase.getSku(), paramPurchase);
  }
  
  void addSkuDetails(SkuDetails paramSkuDetails) {
    this.mSkuMap.put(paramSkuDetails.getSku(), paramSkuDetails);
  }
  
  public void erasePurchase(String paramString) {
    if (this.mPurchaseMap.containsKey(paramString))
      this.mPurchaseMap.remove(paramString); 
  }
  
  List<String> getAllOwnedSkus() {
    return new ArrayList<String>(this.mPurchaseMap.keySet());
  }
  
  List<String> getAllOwnedSkus(String paramString) {
    ArrayList<String> arrayList = new ArrayList();
    for (Purchase purchase : this.mPurchaseMap.values()) {
      if (purchase.getItemType().equals(paramString))
        arrayList.add(purchase.getSku()); 
    } 
    return arrayList;
  }
  
  List<Purchase> getAllPurchases() {
    return new ArrayList<Purchase>(this.mPurchaseMap.values());
  }
  
  public Purchase getPurchase(String paramString) {
    return this.mPurchaseMap.get(paramString);
  }
  
  public SkuDetails getSkuDetails(String paramString) {
    return this.mSkuMap.get(paramString);
  }
  
  public boolean hasDetails(String paramString) {
    return this.mSkuMap.containsKey(paramString);
  }
  
  public boolean hasPurchase(String paramString) {
    return this.mPurchaseMap.containsKey(paramString);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\android\vending\billin\\util\Inventory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */