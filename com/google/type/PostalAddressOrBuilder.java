package com.google.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface PostalAddressOrBuilder extends MessageLiteOrBuilder {
  String getAddressLines(int paramInt);
  
  ByteString getAddressLinesBytes(int paramInt);
  
  int getAddressLinesCount();
  
  List<String> getAddressLinesList();
  
  String getAdministrativeArea();
  
  ByteString getAdministrativeAreaBytes();
  
  String getLanguageCode();
  
  ByteString getLanguageCodeBytes();
  
  String getLocality();
  
  ByteString getLocalityBytes();
  
  String getOrganization();
  
  ByteString getOrganizationBytes();
  
  String getPostalCode();
  
  ByteString getPostalCodeBytes();
  
  String getRecipients(int paramInt);
  
  ByteString getRecipientsBytes(int paramInt);
  
  int getRecipientsCount();
  
  List<String> getRecipientsList();
  
  String getRegionCode();
  
  ByteString getRegionCodeBytes();
  
  int getRevision();
  
  String getSortingCode();
  
  ByteString getSortingCodeBytes();
  
  String getSublocality();
  
  ByteString getSublocalityBytes();
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\type\PostalAddressOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */