package com.google.internal.firebase.inappmessaging.v1;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface ListCampaignsResponseOrBuilder extends MessageLiteOrBuilder {
  CampaignAnalyticsSummary getCampaignAnalyticsSummary(int paramInt);
  
  int getCampaignAnalyticsSummaryCount();
  
  List<CampaignAnalyticsSummary> getCampaignAnalyticsSummaryList();
  
  CampaignProto.Campaign getCampaigns(int paramInt);
  
  int getCampaignsCount();
  
  List<CampaignProto.Campaign> getCampaignsList();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\internal\firebase\inappmessaging\v1\ListCampaignsResponseOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */