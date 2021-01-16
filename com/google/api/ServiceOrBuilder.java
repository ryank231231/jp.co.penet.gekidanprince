package com.google.api;

import com.google.protobuf.Api;
import com.google.protobuf.ByteString;
import com.google.protobuf.Enum;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Type;
import com.google.protobuf.UInt32Value;
import java.util.List;

public interface ServiceOrBuilder extends MessageLiteOrBuilder {
  Api getApis(int paramInt);
  
  int getApisCount();
  
  List<Api> getApisList();
  
  Authentication getAuthentication();
  
  Backend getBackend();
  
  Billing getBilling();
  
  UInt32Value getConfigVersion();
  
  Context getContext();
  
  Control getControl();
  
  Documentation getDocumentation();
  
  Endpoint getEndpoints(int paramInt);
  
  int getEndpointsCount();
  
  List<Endpoint> getEndpointsList();
  
  Enum getEnums(int paramInt);
  
  int getEnumsCount();
  
  List<Enum> getEnumsList();
  
  Experimental getExperimental();
  
  Http getHttp();
  
  String getId();
  
  ByteString getIdBytes();
  
  Logging getLogging();
  
  LogDescriptor getLogs(int paramInt);
  
  int getLogsCount();
  
  List<LogDescriptor> getLogsList();
  
  MetricDescriptor getMetrics(int paramInt);
  
  int getMetricsCount();
  
  List<MetricDescriptor> getMetricsList();
  
  MonitoredResourceDescriptor getMonitoredResources(int paramInt);
  
  int getMonitoredResourcesCount();
  
  List<MonitoredResourceDescriptor> getMonitoredResourcesList();
  
  Monitoring getMonitoring();
  
  String getName();
  
  ByteString getNameBytes();
  
  String getProducerProjectId();
  
  ByteString getProducerProjectIdBytes();
  
  Quota getQuota();
  
  SourceInfo getSourceInfo();
  
  SystemParameters getSystemParameters();
  
  String getTitle();
  
  ByteString getTitleBytes();
  
  Type getTypes(int paramInt);
  
  int getTypesCount();
  
  List<Type> getTypesList();
  
  Usage getUsage();
  
  boolean hasAuthentication();
  
  boolean hasBackend();
  
  boolean hasBilling();
  
  boolean hasConfigVersion();
  
  boolean hasContext();
  
  boolean hasControl();
  
  boolean hasDocumentation();
  
  boolean hasExperimental();
  
  boolean hasHttp();
  
  boolean hasLogging();
  
  boolean hasMonitoring();
  
  boolean hasQuota();
  
  boolean hasSourceInfo();
  
  boolean hasSystemParameters();
  
  boolean hasUsage();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\ServiceOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */