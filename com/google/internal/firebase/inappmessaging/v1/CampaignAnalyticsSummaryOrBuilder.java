package com.google.internal.firebase.inappmessaging.v1;

import com.google.firebase.inappmessaging.CommonTypesProto;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface CampaignAnalyticsSummaryOrBuilder extends MessageLiteOrBuilder {
  String getCampaignId();
  
  ByteString getCampaignIdBytes();
  
  CommonTypesProto.DailyAnalyticsSummary getDailyAnalyticsSummary(int paramInt);
  
  int getDailyAnalyticsSummaryCount();
  
  List<CommonTypesProto.DailyAnalyticsSummary> getDailyAnalyticsSummaryList();
  
  CommonTypesProto.DailyConversionSummary getDailyConversionSummary(int paramInt);
  
  int getDailyConversionSummaryCount();
  
  List<CommonTypesProto.DailyConversionSummary> getDailyConversionSummaryList();
  
  DateRange getDateRange();
  
  int getTotalClicks();
  
  int getTotalConversions();
  
  int getTotalImpressions();
  
  boolean hasDateRange();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\internal\firebase\inappmessaging\v1\CampaignAnalyticsSummaryOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */