package com.google.api;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Api;
import com.google.protobuf.ApiOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Enum;
import com.google.protobuf.EnumOrBuilder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.Type;
import com.google.protobuf.TypeOrBuilder;
import com.google.protobuf.UInt32Value;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class Service extends GeneratedMessageLite<Service, Service.Builder> implements ServiceOrBuilder {
  public static final int APIS_FIELD_NUMBER = 3;
  
  public static final int AUTHENTICATION_FIELD_NUMBER = 11;
  
  public static final int BACKEND_FIELD_NUMBER = 8;
  
  public static final int BILLING_FIELD_NUMBER = 26;
  
  public static final int CONFIG_VERSION_FIELD_NUMBER = 20;
  
  public static final int CONTEXT_FIELD_NUMBER = 12;
  
  public static final int CONTROL_FIELD_NUMBER = 21;
  
  private static final Service DEFAULT_INSTANCE = new Service();
  
  public static final int DOCUMENTATION_FIELD_NUMBER = 6;
  
  public static final int ENDPOINTS_FIELD_NUMBER = 18;
  
  public static final int ENUMS_FIELD_NUMBER = 5;
  
  public static final int EXPERIMENTAL_FIELD_NUMBER = 101;
  
  public static final int HTTP_FIELD_NUMBER = 9;
  
  public static final int ID_FIELD_NUMBER = 33;
  
  public static final int LOGGING_FIELD_NUMBER = 27;
  
  public static final int LOGS_FIELD_NUMBER = 23;
  
  public static final int METRICS_FIELD_NUMBER = 24;
  
  public static final int MONITORED_RESOURCES_FIELD_NUMBER = 25;
  
  public static final int MONITORING_FIELD_NUMBER = 28;
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  private static volatile Parser<Service> PARSER;
  
  public static final int PRODUCER_PROJECT_ID_FIELD_NUMBER = 22;
  
  public static final int QUOTA_FIELD_NUMBER = 10;
  
  public static final int SOURCE_INFO_FIELD_NUMBER = 37;
  
  public static final int SYSTEM_PARAMETERS_FIELD_NUMBER = 29;
  
  public static final int TITLE_FIELD_NUMBER = 2;
  
  public static final int TYPES_FIELD_NUMBER = 4;
  
  public static final int USAGE_FIELD_NUMBER = 15;
  
  private Internal.ProtobufList<Api> apis_ = emptyProtobufList();
  
  private Authentication authentication_;
  
  private Backend backend_;
  
  private Billing billing_;
  
  private int bitField0_;
  
  private UInt32Value configVersion_;
  
  private Context context_;
  
  private Control control_;
  
  private Documentation documentation_;
  
  private Internal.ProtobufList<Endpoint> endpoints_ = emptyProtobufList();
  
  private Internal.ProtobufList<Enum> enums_ = emptyProtobufList();
  
  private Experimental experimental_;
  
  private Http http_;
  
  private String id_ = "";
  
  private Logging logging_;
  
  private Internal.ProtobufList<LogDescriptor> logs_ = emptyProtobufList();
  
  private Internal.ProtobufList<MetricDescriptor> metrics_ = emptyProtobufList();
  
  private Internal.ProtobufList<MonitoredResourceDescriptor> monitoredResources_ = emptyProtobufList();
  
  private Monitoring monitoring_;
  
  private String name_ = "";
  
  private String producerProjectId_ = "";
  
  private Quota quota_;
  
  private SourceInfo sourceInfo_;
  
  private SystemParameters systemParameters_;
  
  private String title_ = "";
  
  private Internal.ProtobufList<Type> types_ = emptyProtobufList();
  
  private Usage usage_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllApis(Iterable<? extends Api> paramIterable) {
    ensureApisIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.apis_);
  }
  
  private void addAllEndpoints(Iterable<? extends Endpoint> paramIterable) {
    ensureEndpointsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.endpoints_);
  }
  
  private void addAllEnums(Iterable<? extends Enum> paramIterable) {
    ensureEnumsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.enums_);
  }
  
  private void addAllLogs(Iterable<? extends LogDescriptor> paramIterable) {
    ensureLogsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.logs_);
  }
  
  private void addAllMetrics(Iterable<? extends MetricDescriptor> paramIterable) {
    ensureMetricsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.metrics_);
  }
  
  private void addAllMonitoredResources(Iterable<? extends MonitoredResourceDescriptor> paramIterable) {
    ensureMonitoredResourcesIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.monitoredResources_);
  }
  
  private void addAllTypes(Iterable<? extends Type> paramIterable) {
    ensureTypesIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.types_);
  }
  
  private void addApis(int paramInt, Api.Builder paramBuilder) {
    ensureApisIsMutable();
    this.apis_.add(paramInt, paramBuilder.build());
  }
  
  private void addApis(int paramInt, Api paramApi) {
    if (paramApi != null) {
      ensureApisIsMutable();
      this.apis_.add(paramInt, paramApi);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addApis(Api.Builder paramBuilder) {
    ensureApisIsMutable();
    this.apis_.add(paramBuilder.build());
  }
  
  private void addApis(Api paramApi) {
    if (paramApi != null) {
      ensureApisIsMutable();
      this.apis_.add(paramApi);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addEndpoints(int paramInt, Endpoint.Builder paramBuilder) {
    ensureEndpointsIsMutable();
    this.endpoints_.add(paramInt, paramBuilder.build());
  }
  
  private void addEndpoints(int paramInt, Endpoint paramEndpoint) {
    if (paramEndpoint != null) {
      ensureEndpointsIsMutable();
      this.endpoints_.add(paramInt, paramEndpoint);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addEndpoints(Endpoint.Builder paramBuilder) {
    ensureEndpointsIsMutable();
    this.endpoints_.add(paramBuilder.build());
  }
  
  private void addEndpoints(Endpoint paramEndpoint) {
    if (paramEndpoint != null) {
      ensureEndpointsIsMutable();
      this.endpoints_.add(paramEndpoint);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addEnums(int paramInt, Enum.Builder paramBuilder) {
    ensureEnumsIsMutable();
    this.enums_.add(paramInt, paramBuilder.build());
  }
  
  private void addEnums(int paramInt, Enum paramEnum) {
    if (paramEnum != null) {
      ensureEnumsIsMutable();
      this.enums_.add(paramInt, paramEnum);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addEnums(Enum.Builder paramBuilder) {
    ensureEnumsIsMutable();
    this.enums_.add(paramBuilder.build());
  }
  
  private void addEnums(Enum paramEnum) {
    if (paramEnum != null) {
      ensureEnumsIsMutable();
      this.enums_.add(paramEnum);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addLogs(int paramInt, LogDescriptor.Builder paramBuilder) {
    ensureLogsIsMutable();
    this.logs_.add(paramInt, paramBuilder.build());
  }
  
  private void addLogs(int paramInt, LogDescriptor paramLogDescriptor) {
    if (paramLogDescriptor != null) {
      ensureLogsIsMutable();
      this.logs_.add(paramInt, paramLogDescriptor);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addLogs(LogDescriptor.Builder paramBuilder) {
    ensureLogsIsMutable();
    this.logs_.add(paramBuilder.build());
  }
  
  private void addLogs(LogDescriptor paramLogDescriptor) {
    if (paramLogDescriptor != null) {
      ensureLogsIsMutable();
      this.logs_.add(paramLogDescriptor);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addMetrics(int paramInt, MetricDescriptor.Builder paramBuilder) {
    ensureMetricsIsMutable();
    this.metrics_.add(paramInt, paramBuilder.build());
  }
  
  private void addMetrics(int paramInt, MetricDescriptor paramMetricDescriptor) {
    if (paramMetricDescriptor != null) {
      ensureMetricsIsMutable();
      this.metrics_.add(paramInt, paramMetricDescriptor);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addMetrics(MetricDescriptor.Builder paramBuilder) {
    ensureMetricsIsMutable();
    this.metrics_.add(paramBuilder.build());
  }
  
  private void addMetrics(MetricDescriptor paramMetricDescriptor) {
    if (paramMetricDescriptor != null) {
      ensureMetricsIsMutable();
      this.metrics_.add(paramMetricDescriptor);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addMonitoredResources(int paramInt, MonitoredResourceDescriptor.Builder paramBuilder) {
    ensureMonitoredResourcesIsMutable();
    this.monitoredResources_.add(paramInt, paramBuilder.build());
  }
  
  private void addMonitoredResources(int paramInt, MonitoredResourceDescriptor paramMonitoredResourceDescriptor) {
    if (paramMonitoredResourceDescriptor != null) {
      ensureMonitoredResourcesIsMutable();
      this.monitoredResources_.add(paramInt, paramMonitoredResourceDescriptor);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addMonitoredResources(MonitoredResourceDescriptor.Builder paramBuilder) {
    ensureMonitoredResourcesIsMutable();
    this.monitoredResources_.add(paramBuilder.build());
  }
  
  private void addMonitoredResources(MonitoredResourceDescriptor paramMonitoredResourceDescriptor) {
    if (paramMonitoredResourceDescriptor != null) {
      ensureMonitoredResourcesIsMutable();
      this.monitoredResources_.add(paramMonitoredResourceDescriptor);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addTypes(int paramInt, Type.Builder paramBuilder) {
    ensureTypesIsMutable();
    this.types_.add(paramInt, paramBuilder.build());
  }
  
  private void addTypes(int paramInt, Type paramType) {
    if (paramType != null) {
      ensureTypesIsMutable();
      this.types_.add(paramInt, paramType);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addTypes(Type.Builder paramBuilder) {
    ensureTypesIsMutable();
    this.types_.add(paramBuilder.build());
  }
  
  private void addTypes(Type paramType) {
    if (paramType != null) {
      ensureTypesIsMutable();
      this.types_.add(paramType);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearApis() {
    this.apis_ = emptyProtobufList();
  }
  
  private void clearAuthentication() {
    this.authentication_ = null;
  }
  
  private void clearBackend() {
    this.backend_ = null;
  }
  
  private void clearBilling() {
    this.billing_ = null;
  }
  
  private void clearConfigVersion() {
    this.configVersion_ = null;
  }
  
  private void clearContext() {
    this.context_ = null;
  }
  
  private void clearControl() {
    this.control_ = null;
  }
  
  private void clearDocumentation() {
    this.documentation_ = null;
  }
  
  private void clearEndpoints() {
    this.endpoints_ = emptyProtobufList();
  }
  
  private void clearEnums() {
    this.enums_ = emptyProtobufList();
  }
  
  private void clearExperimental() {
    this.experimental_ = null;
  }
  
  private void clearHttp() {
    this.http_ = null;
  }
  
  private void clearId() {
    this.id_ = getDefaultInstance().getId();
  }
  
  private void clearLogging() {
    this.logging_ = null;
  }
  
  private void clearLogs() {
    this.logs_ = emptyProtobufList();
  }
  
  private void clearMetrics() {
    this.metrics_ = emptyProtobufList();
  }
  
  private void clearMonitoredResources() {
    this.monitoredResources_ = emptyProtobufList();
  }
  
  private void clearMonitoring() {
    this.monitoring_ = null;
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearProducerProjectId() {
    this.producerProjectId_ = getDefaultInstance().getProducerProjectId();
  }
  
  private void clearQuota() {
    this.quota_ = null;
  }
  
  private void clearSourceInfo() {
    this.sourceInfo_ = null;
  }
  
  private void clearSystemParameters() {
    this.systemParameters_ = null;
  }
  
  private void clearTitle() {
    this.title_ = getDefaultInstance().getTitle();
  }
  
  private void clearTypes() {
    this.types_ = emptyProtobufList();
  }
  
  private void clearUsage() {
    this.usage_ = null;
  }
  
  private void ensureApisIsMutable() {
    if (!this.apis_.isModifiable())
      this.apis_ = GeneratedMessageLite.mutableCopy(this.apis_); 
  }
  
  private void ensureEndpointsIsMutable() {
    if (!this.endpoints_.isModifiable())
      this.endpoints_ = GeneratedMessageLite.mutableCopy(this.endpoints_); 
  }
  
  private void ensureEnumsIsMutable() {
    if (!this.enums_.isModifiable())
      this.enums_ = GeneratedMessageLite.mutableCopy(this.enums_); 
  }
  
  private void ensureLogsIsMutable() {
    if (!this.logs_.isModifiable())
      this.logs_ = GeneratedMessageLite.mutableCopy(this.logs_); 
  }
  
  private void ensureMetricsIsMutable() {
    if (!this.metrics_.isModifiable())
      this.metrics_ = GeneratedMessageLite.mutableCopy(this.metrics_); 
  }
  
  private void ensureMonitoredResourcesIsMutable() {
    if (!this.monitoredResources_.isModifiable())
      this.monitoredResources_ = GeneratedMessageLite.mutableCopy(this.monitoredResources_); 
  }
  
  private void ensureTypesIsMutable() {
    if (!this.types_.isModifiable())
      this.types_ = GeneratedMessageLite.mutableCopy(this.types_); 
  }
  
  public static Service getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeAuthentication(Authentication paramAuthentication) {
    Authentication authentication = this.authentication_;
    if (authentication != null && authentication != Authentication.getDefaultInstance()) {
      this.authentication_ = (Authentication)((Authentication.Builder)Authentication.newBuilder(this.authentication_).mergeFrom(paramAuthentication)).buildPartial();
    } else {
      this.authentication_ = paramAuthentication;
    } 
  }
  
  private void mergeBackend(Backend paramBackend) {
    Backend backend = this.backend_;
    if (backend != null && backend != Backend.getDefaultInstance()) {
      this.backend_ = (Backend)((Backend.Builder)Backend.newBuilder(this.backend_).mergeFrom(paramBackend)).buildPartial();
    } else {
      this.backend_ = paramBackend;
    } 
  }
  
  private void mergeBilling(Billing paramBilling) {
    Billing billing = this.billing_;
    if (billing != null && billing != Billing.getDefaultInstance()) {
      this.billing_ = (Billing)((Billing.Builder)Billing.newBuilder(this.billing_).mergeFrom(paramBilling)).buildPartial();
    } else {
      this.billing_ = paramBilling;
    } 
  }
  
  private void mergeConfigVersion(UInt32Value paramUInt32Value) {
    UInt32Value uInt32Value = this.configVersion_;
    if (uInt32Value != null && uInt32Value != UInt32Value.getDefaultInstance()) {
      this.configVersion_ = (UInt32Value)((UInt32Value.Builder)UInt32Value.newBuilder(this.configVersion_).mergeFrom((GeneratedMessageLite)paramUInt32Value)).buildPartial();
    } else {
      this.configVersion_ = paramUInt32Value;
    } 
  }
  
  private void mergeContext(Context paramContext) {
    Context context = this.context_;
    if (context != null && context != Context.getDefaultInstance()) {
      this.context_ = (Context)((Context.Builder)Context.newBuilder(this.context_).mergeFrom(paramContext)).buildPartial();
    } else {
      this.context_ = paramContext;
    } 
  }
  
  private void mergeControl(Control paramControl) {
    Control control = this.control_;
    if (control != null && control != Control.getDefaultInstance()) {
      this.control_ = (Control)((Control.Builder)Control.newBuilder(this.control_).mergeFrom(paramControl)).buildPartial();
    } else {
      this.control_ = paramControl;
    } 
  }
  
  private void mergeDocumentation(Documentation paramDocumentation) {
    Documentation documentation = this.documentation_;
    if (documentation != null && documentation != Documentation.getDefaultInstance()) {
      this.documentation_ = (Documentation)((Documentation.Builder)Documentation.newBuilder(this.documentation_).mergeFrom(paramDocumentation)).buildPartial();
    } else {
      this.documentation_ = paramDocumentation;
    } 
  }
  
  private void mergeExperimental(Experimental paramExperimental) {
    Experimental experimental = this.experimental_;
    if (experimental != null && experimental != Experimental.getDefaultInstance()) {
      this.experimental_ = (Experimental)((Experimental.Builder)Experimental.newBuilder(this.experimental_).mergeFrom(paramExperimental)).buildPartial();
    } else {
      this.experimental_ = paramExperimental;
    } 
  }
  
  private void mergeHttp(Http paramHttp) {
    Http http = this.http_;
    if (http != null && http != Http.getDefaultInstance()) {
      this.http_ = (Http)((Http.Builder)Http.newBuilder(this.http_).mergeFrom(paramHttp)).buildPartial();
    } else {
      this.http_ = paramHttp;
    } 
  }
  
  private void mergeLogging(Logging paramLogging) {
    Logging logging = this.logging_;
    if (logging != null && logging != Logging.getDefaultInstance()) {
      this.logging_ = (Logging)((Logging.Builder)Logging.newBuilder(this.logging_).mergeFrom(paramLogging)).buildPartial();
    } else {
      this.logging_ = paramLogging;
    } 
  }
  
  private void mergeMonitoring(Monitoring paramMonitoring) {
    Monitoring monitoring = this.monitoring_;
    if (monitoring != null && monitoring != Monitoring.getDefaultInstance()) {
      this.monitoring_ = (Monitoring)((Monitoring.Builder)Monitoring.newBuilder(this.monitoring_).mergeFrom(paramMonitoring)).buildPartial();
    } else {
      this.monitoring_ = paramMonitoring;
    } 
  }
  
  private void mergeQuota(Quota paramQuota) {
    Quota quota = this.quota_;
    if (quota != null && quota != Quota.getDefaultInstance()) {
      this.quota_ = (Quota)((Quota.Builder)Quota.newBuilder(this.quota_).mergeFrom(paramQuota)).buildPartial();
    } else {
      this.quota_ = paramQuota;
    } 
  }
  
  private void mergeSourceInfo(SourceInfo paramSourceInfo) {
    SourceInfo sourceInfo = this.sourceInfo_;
    if (sourceInfo != null && sourceInfo != SourceInfo.getDefaultInstance()) {
      this.sourceInfo_ = (SourceInfo)((SourceInfo.Builder)SourceInfo.newBuilder(this.sourceInfo_).mergeFrom(paramSourceInfo)).buildPartial();
    } else {
      this.sourceInfo_ = paramSourceInfo;
    } 
  }
  
  private void mergeSystemParameters(SystemParameters paramSystemParameters) {
    SystemParameters systemParameters = this.systemParameters_;
    if (systemParameters != null && systemParameters != SystemParameters.getDefaultInstance()) {
      this.systemParameters_ = (SystemParameters)((SystemParameters.Builder)SystemParameters.newBuilder(this.systemParameters_).mergeFrom(paramSystemParameters)).buildPartial();
    } else {
      this.systemParameters_ = paramSystemParameters;
    } 
  }
  
  private void mergeUsage(Usage paramUsage) {
    Usage usage = this.usage_;
    if (usage != null && usage != Usage.getDefaultInstance()) {
      this.usage_ = (Usage)((Usage.Builder)Usage.newBuilder(this.usage_).mergeFrom(paramUsage)).buildPartial();
    } else {
      this.usage_ = paramUsage;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Service paramService) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramService);
  }
  
  public static Service parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Service)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Service parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Service)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Service parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Service)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Service parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Service)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Service parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Service)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Service parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Service)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Service parseFrom(InputStream paramInputStream) throws IOException {
    return (Service)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Service parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Service)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Service parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Service)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Service parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Service)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Service> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeApis(int paramInt) {
    ensureApisIsMutable();
    this.apis_.remove(paramInt);
  }
  
  private void removeEndpoints(int paramInt) {
    ensureEndpointsIsMutable();
    this.endpoints_.remove(paramInt);
  }
  
  private void removeEnums(int paramInt) {
    ensureEnumsIsMutable();
    this.enums_.remove(paramInt);
  }
  
  private void removeLogs(int paramInt) {
    ensureLogsIsMutable();
    this.logs_.remove(paramInt);
  }
  
  private void removeMetrics(int paramInt) {
    ensureMetricsIsMutable();
    this.metrics_.remove(paramInt);
  }
  
  private void removeMonitoredResources(int paramInt) {
    ensureMonitoredResourcesIsMutable();
    this.monitoredResources_.remove(paramInt);
  }
  
  private void removeTypes(int paramInt) {
    ensureTypesIsMutable();
    this.types_.remove(paramInt);
  }
  
  private void setApis(int paramInt, Api.Builder paramBuilder) {
    ensureApisIsMutable();
    this.apis_.set(paramInt, paramBuilder.build());
  }
  
  private void setApis(int paramInt, Api paramApi) {
    if (paramApi != null) {
      ensureApisIsMutable();
      this.apis_.set(paramInt, paramApi);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setAuthentication(Authentication.Builder paramBuilder) {
    this.authentication_ = (Authentication)paramBuilder.build();
  }
  
  private void setAuthentication(Authentication paramAuthentication) {
    if (paramAuthentication != null) {
      this.authentication_ = paramAuthentication;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setBackend(Backend.Builder paramBuilder) {
    this.backend_ = (Backend)paramBuilder.build();
  }
  
  private void setBackend(Backend paramBackend) {
    if (paramBackend != null) {
      this.backend_ = paramBackend;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setBilling(Billing.Builder paramBuilder) {
    this.billing_ = (Billing)paramBuilder.build();
  }
  
  private void setBilling(Billing paramBilling) {
    if (paramBilling != null) {
      this.billing_ = paramBilling;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setConfigVersion(UInt32Value.Builder paramBuilder) {
    this.configVersion_ = (UInt32Value)paramBuilder.build();
  }
  
  private void setConfigVersion(UInt32Value paramUInt32Value) {
    if (paramUInt32Value != null) {
      this.configVersion_ = paramUInt32Value;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setContext(Context.Builder paramBuilder) {
    this.context_ = (Context)paramBuilder.build();
  }
  
  private void setContext(Context paramContext) {
    if (paramContext != null) {
      this.context_ = paramContext;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setControl(Control.Builder paramBuilder) {
    this.control_ = (Control)paramBuilder.build();
  }
  
  private void setControl(Control paramControl) {
    if (paramControl != null) {
      this.control_ = paramControl;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDocumentation(Documentation.Builder paramBuilder) {
    this.documentation_ = (Documentation)paramBuilder.build();
  }
  
  private void setDocumentation(Documentation paramDocumentation) {
    if (paramDocumentation != null) {
      this.documentation_ = paramDocumentation;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setEndpoints(int paramInt, Endpoint.Builder paramBuilder) {
    ensureEndpointsIsMutable();
    this.endpoints_.set(paramInt, paramBuilder.build());
  }
  
  private void setEndpoints(int paramInt, Endpoint paramEndpoint) {
    if (paramEndpoint != null) {
      ensureEndpointsIsMutable();
      this.endpoints_.set(paramInt, paramEndpoint);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setEnums(int paramInt, Enum.Builder paramBuilder) {
    ensureEnumsIsMutable();
    this.enums_.set(paramInt, paramBuilder.build());
  }
  
  private void setEnums(int paramInt, Enum paramEnum) {
    if (paramEnum != null) {
      ensureEnumsIsMutable();
      this.enums_.set(paramInt, paramEnum);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setExperimental(Experimental.Builder paramBuilder) {
    this.experimental_ = (Experimental)paramBuilder.build();
  }
  
  private void setExperimental(Experimental paramExperimental) {
    if (paramExperimental != null) {
      this.experimental_ = paramExperimental;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setHttp(Http.Builder paramBuilder) {
    this.http_ = (Http)paramBuilder.build();
  }
  
  private void setHttp(Http paramHttp) {
    if (paramHttp != null) {
      this.http_ = paramHttp;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setId(String paramString) {
    if (paramString != null) {
      this.id_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setIdBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.id_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setLogging(Logging.Builder paramBuilder) {
    this.logging_ = (Logging)paramBuilder.build();
  }
  
  private void setLogging(Logging paramLogging) {
    if (paramLogging != null) {
      this.logging_ = paramLogging;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setLogs(int paramInt, LogDescriptor.Builder paramBuilder) {
    ensureLogsIsMutable();
    this.logs_.set(paramInt, paramBuilder.build());
  }
  
  private void setLogs(int paramInt, LogDescriptor paramLogDescriptor) {
    if (paramLogDescriptor != null) {
      ensureLogsIsMutable();
      this.logs_.set(paramInt, paramLogDescriptor);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setMetrics(int paramInt, MetricDescriptor.Builder paramBuilder) {
    ensureMetricsIsMutable();
    this.metrics_.set(paramInt, paramBuilder.build());
  }
  
  private void setMetrics(int paramInt, MetricDescriptor paramMetricDescriptor) {
    if (paramMetricDescriptor != null) {
      ensureMetricsIsMutable();
      this.metrics_.set(paramInt, paramMetricDescriptor);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setMonitoredResources(int paramInt, MonitoredResourceDescriptor.Builder paramBuilder) {
    ensureMonitoredResourcesIsMutable();
    this.monitoredResources_.set(paramInt, paramBuilder.build());
  }
  
  private void setMonitoredResources(int paramInt, MonitoredResourceDescriptor paramMonitoredResourceDescriptor) {
    if (paramMonitoredResourceDescriptor != null) {
      ensureMonitoredResourcesIsMutable();
      this.monitoredResources_.set(paramInt, paramMonitoredResourceDescriptor);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setMonitoring(Monitoring.Builder paramBuilder) {
    this.monitoring_ = (Monitoring)paramBuilder.build();
  }
  
  private void setMonitoring(Monitoring paramMonitoring) {
    if (paramMonitoring != null) {
      this.monitoring_ = paramMonitoring;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setName(String paramString) {
    if (paramString != null) {
      this.name_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setNameBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.name_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setProducerProjectId(String paramString) {
    if (paramString != null) {
      this.producerProjectId_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setProducerProjectIdBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.producerProjectId_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setQuota(Quota.Builder paramBuilder) {
    this.quota_ = (Quota)paramBuilder.build();
  }
  
  private void setQuota(Quota paramQuota) {
    if (paramQuota != null) {
      this.quota_ = paramQuota;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setSourceInfo(SourceInfo.Builder paramBuilder) {
    this.sourceInfo_ = (SourceInfo)paramBuilder.build();
  }
  
  private void setSourceInfo(SourceInfo paramSourceInfo) {
    if (paramSourceInfo != null) {
      this.sourceInfo_ = paramSourceInfo;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setSystemParameters(SystemParameters.Builder paramBuilder) {
    this.systemParameters_ = (SystemParameters)paramBuilder.build();
  }
  
  private void setSystemParameters(SystemParameters paramSystemParameters) {
    if (paramSystemParameters != null) {
      this.systemParameters_ = paramSystemParameters;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setTitle(String paramString) {
    if (paramString != null) {
      this.title_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setTitleBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.title_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setTypes(int paramInt, Type.Builder paramBuilder) {
    ensureTypesIsMutable();
    this.types_.set(paramInt, paramBuilder.build());
  }
  
  private void setTypes(int paramInt, Type paramType) {
    if (paramType != null) {
      ensureTypesIsMutable();
      this.types_.set(paramInt, paramType);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setUsage(Usage.Builder paramBuilder) {
    this.usage_ = (Usage)paramBuilder.build();
  }
  
  private void setUsage(Usage paramUsage) {
    if (paramUsage != null) {
      this.usage_ = paramUsage;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/Service$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 2489, 2 -> 2485, 3 -> 2420, 4 -> 2411, 5 -> 1794, 6 -> 110, 7 -> 1790, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/api/Service.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/api/Service
    //   72: monitorenter
    //   73: getstatic com/google/api/Service.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/api/Service.DEFAULT_INSTANCE : Lcom/google/api/Service;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/api/Service.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/api/Service
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/api/Service
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/api/Service.PARSER : Lcom/google/protobuf/Parser;
    //   109: areturn
    //   110: aload_2
    //   111: checkcast com/google/protobuf/CodedInputStream
    //   114: astore_2
    //   115: aload_3
    //   116: checkcast com/google/protobuf/ExtensionRegistryLite
    //   119: astore_3
    //   120: iconst_0
    //   121: istore #4
    //   123: iload #4
    //   125: ifne -> 1790
    //   128: aload_2
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: lookupswitch default -> 364, 0 -> 1723, 10 -> 1712, 18 -> 1701, 26 -> 1654, 34 -> 1607, 42 -> 1560, 50 -> 1495, 66 -> 1430, 74 -> 1365, 82 -> 1300, 90 -> 1235, 98 -> 1170, 122 -> 1105, 146 -> 1058, 162 -> 993, 170 -> 928, 178 -> 917, 186 -> 870, 194 -> 823, 202 -> 776, 210 -> 711, 218 -> 646, 226 -> 581, 234 -> 516, 266 -> 505, 298 -> 440, 810 -> 375
    //   364: aload_2
    //   365: iload #5
    //   367: invokevirtual skipField : (I)Z
    //   370: istore #6
    //   372: goto -> 1729
    //   375: aload_0
    //   376: getfield experimental_ : Lcom/google/api/Experimental;
    //   379: ifnull -> 396
    //   382: aload_0
    //   383: getfield experimental_ : Lcom/google/api/Experimental;
    //   386: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   389: checkcast com/google/api/Experimental$Builder
    //   392: astore_1
    //   393: goto -> 398
    //   396: aconst_null
    //   397: astore_1
    //   398: aload_0
    //   399: aload_2
    //   400: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   403: aload_3
    //   404: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   407: checkcast com/google/api/Experimental
    //   410: putfield experimental_ : Lcom/google/api/Experimental;
    //   413: aload_1
    //   414: ifnull -> 123
    //   417: aload_1
    //   418: aload_0
    //   419: getfield experimental_ : Lcom/google/api/Experimental;
    //   422: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   425: pop
    //   426: aload_0
    //   427: aload_1
    //   428: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   431: checkcast com/google/api/Experimental
    //   434: putfield experimental_ : Lcom/google/api/Experimental;
    //   437: goto -> 123
    //   440: aload_0
    //   441: getfield sourceInfo_ : Lcom/google/api/SourceInfo;
    //   444: ifnull -> 461
    //   447: aload_0
    //   448: getfield sourceInfo_ : Lcom/google/api/SourceInfo;
    //   451: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   454: checkcast com/google/api/SourceInfo$Builder
    //   457: astore_1
    //   458: goto -> 463
    //   461: aconst_null
    //   462: astore_1
    //   463: aload_0
    //   464: aload_2
    //   465: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   468: aload_3
    //   469: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   472: checkcast com/google/api/SourceInfo
    //   475: putfield sourceInfo_ : Lcom/google/api/SourceInfo;
    //   478: aload_1
    //   479: ifnull -> 123
    //   482: aload_1
    //   483: aload_0
    //   484: getfield sourceInfo_ : Lcom/google/api/SourceInfo;
    //   487: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   490: pop
    //   491: aload_0
    //   492: aload_1
    //   493: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   496: checkcast com/google/api/SourceInfo
    //   499: putfield sourceInfo_ : Lcom/google/api/SourceInfo;
    //   502: goto -> 123
    //   505: aload_0
    //   506: aload_2
    //   507: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   510: putfield id_ : Ljava/lang/String;
    //   513: goto -> 123
    //   516: aload_0
    //   517: getfield systemParameters_ : Lcom/google/api/SystemParameters;
    //   520: ifnull -> 537
    //   523: aload_0
    //   524: getfield systemParameters_ : Lcom/google/api/SystemParameters;
    //   527: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   530: checkcast com/google/api/SystemParameters$Builder
    //   533: astore_1
    //   534: goto -> 539
    //   537: aconst_null
    //   538: astore_1
    //   539: aload_0
    //   540: aload_2
    //   541: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   544: aload_3
    //   545: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   548: checkcast com/google/api/SystemParameters
    //   551: putfield systemParameters_ : Lcom/google/api/SystemParameters;
    //   554: aload_1
    //   555: ifnull -> 123
    //   558: aload_1
    //   559: aload_0
    //   560: getfield systemParameters_ : Lcom/google/api/SystemParameters;
    //   563: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   566: pop
    //   567: aload_0
    //   568: aload_1
    //   569: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   572: checkcast com/google/api/SystemParameters
    //   575: putfield systemParameters_ : Lcom/google/api/SystemParameters;
    //   578: goto -> 123
    //   581: aload_0
    //   582: getfield monitoring_ : Lcom/google/api/Monitoring;
    //   585: ifnull -> 602
    //   588: aload_0
    //   589: getfield monitoring_ : Lcom/google/api/Monitoring;
    //   592: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   595: checkcast com/google/api/Monitoring$Builder
    //   598: astore_1
    //   599: goto -> 604
    //   602: aconst_null
    //   603: astore_1
    //   604: aload_0
    //   605: aload_2
    //   606: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   609: aload_3
    //   610: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   613: checkcast com/google/api/Monitoring
    //   616: putfield monitoring_ : Lcom/google/api/Monitoring;
    //   619: aload_1
    //   620: ifnull -> 123
    //   623: aload_1
    //   624: aload_0
    //   625: getfield monitoring_ : Lcom/google/api/Monitoring;
    //   628: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   631: pop
    //   632: aload_0
    //   633: aload_1
    //   634: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   637: checkcast com/google/api/Monitoring
    //   640: putfield monitoring_ : Lcom/google/api/Monitoring;
    //   643: goto -> 123
    //   646: aload_0
    //   647: getfield logging_ : Lcom/google/api/Logging;
    //   650: ifnull -> 667
    //   653: aload_0
    //   654: getfield logging_ : Lcom/google/api/Logging;
    //   657: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   660: checkcast com/google/api/Logging$Builder
    //   663: astore_1
    //   664: goto -> 669
    //   667: aconst_null
    //   668: astore_1
    //   669: aload_0
    //   670: aload_2
    //   671: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   674: aload_3
    //   675: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   678: checkcast com/google/api/Logging
    //   681: putfield logging_ : Lcom/google/api/Logging;
    //   684: aload_1
    //   685: ifnull -> 123
    //   688: aload_1
    //   689: aload_0
    //   690: getfield logging_ : Lcom/google/api/Logging;
    //   693: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   696: pop
    //   697: aload_0
    //   698: aload_1
    //   699: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   702: checkcast com/google/api/Logging
    //   705: putfield logging_ : Lcom/google/api/Logging;
    //   708: goto -> 123
    //   711: aload_0
    //   712: getfield billing_ : Lcom/google/api/Billing;
    //   715: ifnull -> 732
    //   718: aload_0
    //   719: getfield billing_ : Lcom/google/api/Billing;
    //   722: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   725: checkcast com/google/api/Billing$Builder
    //   728: astore_1
    //   729: goto -> 734
    //   732: aconst_null
    //   733: astore_1
    //   734: aload_0
    //   735: aload_2
    //   736: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   739: aload_3
    //   740: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   743: checkcast com/google/api/Billing
    //   746: putfield billing_ : Lcom/google/api/Billing;
    //   749: aload_1
    //   750: ifnull -> 123
    //   753: aload_1
    //   754: aload_0
    //   755: getfield billing_ : Lcom/google/api/Billing;
    //   758: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   761: pop
    //   762: aload_0
    //   763: aload_1
    //   764: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   767: checkcast com/google/api/Billing
    //   770: putfield billing_ : Lcom/google/api/Billing;
    //   773: goto -> 123
    //   776: aload_0
    //   777: getfield monitoredResources_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   780: invokeinterface isModifiable : ()Z
    //   785: ifne -> 799
    //   788: aload_0
    //   789: aload_0
    //   790: getfield monitoredResources_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   793: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   796: putfield monitoredResources_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   799: aload_0
    //   800: getfield monitoredResources_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   803: aload_2
    //   804: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   807: aload_3
    //   808: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   811: checkcast com/google/api/MonitoredResourceDescriptor
    //   814: invokeinterface add : (Ljava/lang/Object;)Z
    //   819: pop
    //   820: goto -> 123
    //   823: aload_0
    //   824: getfield metrics_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   827: invokeinterface isModifiable : ()Z
    //   832: ifne -> 846
    //   835: aload_0
    //   836: aload_0
    //   837: getfield metrics_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   840: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   843: putfield metrics_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   846: aload_0
    //   847: getfield metrics_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   850: aload_2
    //   851: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   854: aload_3
    //   855: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   858: checkcast com/google/api/MetricDescriptor
    //   861: invokeinterface add : (Ljava/lang/Object;)Z
    //   866: pop
    //   867: goto -> 123
    //   870: aload_0
    //   871: getfield logs_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   874: invokeinterface isModifiable : ()Z
    //   879: ifne -> 893
    //   882: aload_0
    //   883: aload_0
    //   884: getfield logs_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   887: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   890: putfield logs_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   893: aload_0
    //   894: getfield logs_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   897: aload_2
    //   898: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   901: aload_3
    //   902: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   905: checkcast com/google/api/LogDescriptor
    //   908: invokeinterface add : (Ljava/lang/Object;)Z
    //   913: pop
    //   914: goto -> 123
    //   917: aload_0
    //   918: aload_2
    //   919: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   922: putfield producerProjectId_ : Ljava/lang/String;
    //   925: goto -> 123
    //   928: aload_0
    //   929: getfield control_ : Lcom/google/api/Control;
    //   932: ifnull -> 949
    //   935: aload_0
    //   936: getfield control_ : Lcom/google/api/Control;
    //   939: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   942: checkcast com/google/api/Control$Builder
    //   945: astore_1
    //   946: goto -> 951
    //   949: aconst_null
    //   950: astore_1
    //   951: aload_0
    //   952: aload_2
    //   953: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   956: aload_3
    //   957: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   960: checkcast com/google/api/Control
    //   963: putfield control_ : Lcom/google/api/Control;
    //   966: aload_1
    //   967: ifnull -> 123
    //   970: aload_1
    //   971: aload_0
    //   972: getfield control_ : Lcom/google/api/Control;
    //   975: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   978: pop
    //   979: aload_0
    //   980: aload_1
    //   981: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   984: checkcast com/google/api/Control
    //   987: putfield control_ : Lcom/google/api/Control;
    //   990: goto -> 123
    //   993: aload_0
    //   994: getfield configVersion_ : Lcom/google/protobuf/UInt32Value;
    //   997: ifnull -> 1014
    //   1000: aload_0
    //   1001: getfield configVersion_ : Lcom/google/protobuf/UInt32Value;
    //   1004: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   1007: checkcast com/google/protobuf/UInt32Value$Builder
    //   1010: astore_1
    //   1011: goto -> 1016
    //   1014: aconst_null
    //   1015: astore_1
    //   1016: aload_0
    //   1017: aload_2
    //   1018: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   1021: aload_3
    //   1022: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   1025: checkcast com/google/protobuf/UInt32Value
    //   1028: putfield configVersion_ : Lcom/google/protobuf/UInt32Value;
    //   1031: aload_1
    //   1032: ifnull -> 123
    //   1035: aload_1
    //   1036: aload_0
    //   1037: getfield configVersion_ : Lcom/google/protobuf/UInt32Value;
    //   1040: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   1043: pop
    //   1044: aload_0
    //   1045: aload_1
    //   1046: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   1049: checkcast com/google/protobuf/UInt32Value
    //   1052: putfield configVersion_ : Lcom/google/protobuf/UInt32Value;
    //   1055: goto -> 123
    //   1058: aload_0
    //   1059: getfield endpoints_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   1062: invokeinterface isModifiable : ()Z
    //   1067: ifne -> 1081
    //   1070: aload_0
    //   1071: aload_0
    //   1072: getfield endpoints_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   1075: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   1078: putfield endpoints_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   1081: aload_0
    //   1082: getfield endpoints_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   1085: aload_2
    //   1086: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   1089: aload_3
    //   1090: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   1093: checkcast com/google/api/Endpoint
    //   1096: invokeinterface add : (Ljava/lang/Object;)Z
    //   1101: pop
    //   1102: goto -> 123
    //   1105: aload_0
    //   1106: getfield usage_ : Lcom/google/api/Usage;
    //   1109: ifnull -> 1126
    //   1112: aload_0
    //   1113: getfield usage_ : Lcom/google/api/Usage;
    //   1116: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   1119: checkcast com/google/api/Usage$Builder
    //   1122: astore_1
    //   1123: goto -> 1128
    //   1126: aconst_null
    //   1127: astore_1
    //   1128: aload_0
    //   1129: aload_2
    //   1130: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   1133: aload_3
    //   1134: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   1137: checkcast com/google/api/Usage
    //   1140: putfield usage_ : Lcom/google/api/Usage;
    //   1143: aload_1
    //   1144: ifnull -> 123
    //   1147: aload_1
    //   1148: aload_0
    //   1149: getfield usage_ : Lcom/google/api/Usage;
    //   1152: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   1155: pop
    //   1156: aload_0
    //   1157: aload_1
    //   1158: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   1161: checkcast com/google/api/Usage
    //   1164: putfield usage_ : Lcom/google/api/Usage;
    //   1167: goto -> 123
    //   1170: aload_0
    //   1171: getfield context_ : Lcom/google/api/Context;
    //   1174: ifnull -> 1191
    //   1177: aload_0
    //   1178: getfield context_ : Lcom/google/api/Context;
    //   1181: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   1184: checkcast com/google/api/Context$Builder
    //   1187: astore_1
    //   1188: goto -> 1193
    //   1191: aconst_null
    //   1192: astore_1
    //   1193: aload_0
    //   1194: aload_2
    //   1195: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   1198: aload_3
    //   1199: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   1202: checkcast com/google/api/Context
    //   1205: putfield context_ : Lcom/google/api/Context;
    //   1208: aload_1
    //   1209: ifnull -> 123
    //   1212: aload_1
    //   1213: aload_0
    //   1214: getfield context_ : Lcom/google/api/Context;
    //   1217: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   1220: pop
    //   1221: aload_0
    //   1222: aload_1
    //   1223: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   1226: checkcast com/google/api/Context
    //   1229: putfield context_ : Lcom/google/api/Context;
    //   1232: goto -> 123
    //   1235: aload_0
    //   1236: getfield authentication_ : Lcom/google/api/Authentication;
    //   1239: ifnull -> 1256
    //   1242: aload_0
    //   1243: getfield authentication_ : Lcom/google/api/Authentication;
    //   1246: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   1249: checkcast com/google/api/Authentication$Builder
    //   1252: astore_1
    //   1253: goto -> 1258
    //   1256: aconst_null
    //   1257: astore_1
    //   1258: aload_0
    //   1259: aload_2
    //   1260: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   1263: aload_3
    //   1264: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   1267: checkcast com/google/api/Authentication
    //   1270: putfield authentication_ : Lcom/google/api/Authentication;
    //   1273: aload_1
    //   1274: ifnull -> 123
    //   1277: aload_1
    //   1278: aload_0
    //   1279: getfield authentication_ : Lcom/google/api/Authentication;
    //   1282: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   1285: pop
    //   1286: aload_0
    //   1287: aload_1
    //   1288: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   1291: checkcast com/google/api/Authentication
    //   1294: putfield authentication_ : Lcom/google/api/Authentication;
    //   1297: goto -> 123
    //   1300: aload_0
    //   1301: getfield quota_ : Lcom/google/api/Quota;
    //   1304: ifnull -> 1321
    //   1307: aload_0
    //   1308: getfield quota_ : Lcom/google/api/Quota;
    //   1311: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   1314: checkcast com/google/api/Quota$Builder
    //   1317: astore_1
    //   1318: goto -> 1323
    //   1321: aconst_null
    //   1322: astore_1
    //   1323: aload_0
    //   1324: aload_2
    //   1325: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   1328: aload_3
    //   1329: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   1332: checkcast com/google/api/Quota
    //   1335: putfield quota_ : Lcom/google/api/Quota;
    //   1338: aload_1
    //   1339: ifnull -> 123
    //   1342: aload_1
    //   1343: aload_0
    //   1344: getfield quota_ : Lcom/google/api/Quota;
    //   1347: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   1350: pop
    //   1351: aload_0
    //   1352: aload_1
    //   1353: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   1356: checkcast com/google/api/Quota
    //   1359: putfield quota_ : Lcom/google/api/Quota;
    //   1362: goto -> 123
    //   1365: aload_0
    //   1366: getfield http_ : Lcom/google/api/Http;
    //   1369: ifnull -> 1386
    //   1372: aload_0
    //   1373: getfield http_ : Lcom/google/api/Http;
    //   1376: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   1379: checkcast com/google/api/Http$Builder
    //   1382: astore_1
    //   1383: goto -> 1388
    //   1386: aconst_null
    //   1387: astore_1
    //   1388: aload_0
    //   1389: aload_2
    //   1390: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   1393: aload_3
    //   1394: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   1397: checkcast com/google/api/Http
    //   1400: putfield http_ : Lcom/google/api/Http;
    //   1403: aload_1
    //   1404: ifnull -> 123
    //   1407: aload_1
    //   1408: aload_0
    //   1409: getfield http_ : Lcom/google/api/Http;
    //   1412: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   1415: pop
    //   1416: aload_0
    //   1417: aload_1
    //   1418: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   1421: checkcast com/google/api/Http
    //   1424: putfield http_ : Lcom/google/api/Http;
    //   1427: goto -> 123
    //   1430: aload_0
    //   1431: getfield backend_ : Lcom/google/api/Backend;
    //   1434: ifnull -> 1451
    //   1437: aload_0
    //   1438: getfield backend_ : Lcom/google/api/Backend;
    //   1441: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   1444: checkcast com/google/api/Backend$Builder
    //   1447: astore_1
    //   1448: goto -> 1453
    //   1451: aconst_null
    //   1452: astore_1
    //   1453: aload_0
    //   1454: aload_2
    //   1455: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   1458: aload_3
    //   1459: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   1462: checkcast com/google/api/Backend
    //   1465: putfield backend_ : Lcom/google/api/Backend;
    //   1468: aload_1
    //   1469: ifnull -> 123
    //   1472: aload_1
    //   1473: aload_0
    //   1474: getfield backend_ : Lcom/google/api/Backend;
    //   1477: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   1480: pop
    //   1481: aload_0
    //   1482: aload_1
    //   1483: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   1486: checkcast com/google/api/Backend
    //   1489: putfield backend_ : Lcom/google/api/Backend;
    //   1492: goto -> 123
    //   1495: aload_0
    //   1496: getfield documentation_ : Lcom/google/api/Documentation;
    //   1499: ifnull -> 1516
    //   1502: aload_0
    //   1503: getfield documentation_ : Lcom/google/api/Documentation;
    //   1506: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   1509: checkcast com/google/api/Documentation$Builder
    //   1512: astore_1
    //   1513: goto -> 1518
    //   1516: aconst_null
    //   1517: astore_1
    //   1518: aload_0
    //   1519: aload_2
    //   1520: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   1523: aload_3
    //   1524: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   1527: checkcast com/google/api/Documentation
    //   1530: putfield documentation_ : Lcom/google/api/Documentation;
    //   1533: aload_1
    //   1534: ifnull -> 123
    //   1537: aload_1
    //   1538: aload_0
    //   1539: getfield documentation_ : Lcom/google/api/Documentation;
    //   1542: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   1545: pop
    //   1546: aload_0
    //   1547: aload_1
    //   1548: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   1551: checkcast com/google/api/Documentation
    //   1554: putfield documentation_ : Lcom/google/api/Documentation;
    //   1557: goto -> 123
    //   1560: aload_0
    //   1561: getfield enums_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   1564: invokeinterface isModifiable : ()Z
    //   1569: ifne -> 1583
    //   1572: aload_0
    //   1573: aload_0
    //   1574: getfield enums_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   1577: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   1580: putfield enums_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   1583: aload_0
    //   1584: getfield enums_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   1587: aload_2
    //   1588: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   1591: aload_3
    //   1592: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   1595: checkcast com/google/protobuf/Enum
    //   1598: invokeinterface add : (Ljava/lang/Object;)Z
    //   1603: pop
    //   1604: goto -> 123
    //   1607: aload_0
    //   1608: getfield types_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   1611: invokeinterface isModifiable : ()Z
    //   1616: ifne -> 1630
    //   1619: aload_0
    //   1620: aload_0
    //   1621: getfield types_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   1624: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   1627: putfield types_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   1630: aload_0
    //   1631: getfield types_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   1634: aload_2
    //   1635: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   1638: aload_3
    //   1639: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   1642: checkcast com/google/protobuf/Type
    //   1645: invokeinterface add : (Ljava/lang/Object;)Z
    //   1650: pop
    //   1651: goto -> 123
    //   1654: aload_0
    //   1655: getfield apis_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   1658: invokeinterface isModifiable : ()Z
    //   1663: ifne -> 1677
    //   1666: aload_0
    //   1667: aload_0
    //   1668: getfield apis_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   1671: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   1674: putfield apis_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   1677: aload_0
    //   1678: getfield apis_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   1681: aload_2
    //   1682: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   1685: aload_3
    //   1686: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   1689: checkcast com/google/protobuf/Api
    //   1692: invokeinterface add : (Ljava/lang/Object;)Z
    //   1697: pop
    //   1698: goto -> 123
    //   1701: aload_0
    //   1702: aload_2
    //   1703: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   1706: putfield title_ : Ljava/lang/String;
    //   1709: goto -> 123
    //   1712: aload_0
    //   1713: aload_2
    //   1714: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   1717: putfield name_ : Ljava/lang/String;
    //   1720: goto -> 123
    //   1723: iconst_1
    //   1724: istore #4
    //   1726: goto -> 123
    //   1729: iload #6
    //   1731: ifne -> 123
    //   1734: iconst_1
    //   1735: istore #4
    //   1737: goto -> 123
    //   1740: astore_1
    //   1741: goto -> 1788
    //   1744: astore_2
    //   1745: new java/lang/RuntimeException
    //   1748: astore_1
    //   1749: new com/google/protobuf/InvalidProtocolBufferException
    //   1752: astore_3
    //   1753: aload_3
    //   1754: aload_2
    //   1755: invokevirtual getMessage : ()Ljava/lang/String;
    //   1758: invokespecial <init> : (Ljava/lang/String;)V
    //   1761: aload_1
    //   1762: aload_3
    //   1763: aload_0
    //   1764: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   1767: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   1770: aload_1
    //   1771: athrow
    //   1772: astore_2
    //   1773: new java/lang/RuntimeException
    //   1776: astore_1
    //   1777: aload_1
    //   1778: aload_2
    //   1779: aload_0
    //   1780: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   1783: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   1786: aload_1
    //   1787: athrow
    //   1788: aload_1
    //   1789: athrow
    //   1790: getstatic com/google/api/Service.DEFAULT_INSTANCE : Lcom/google/api/Service;
    //   1793: areturn
    //   1794: aload_2
    //   1795: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   1798: astore_1
    //   1799: aload_3
    //   1800: checkcast com/google/api/Service
    //   1803: astore_2
    //   1804: aload_0
    //   1805: aload_1
    //   1806: aload_0
    //   1807: getfield configVersion_ : Lcom/google/protobuf/UInt32Value;
    //   1810: aload_2
    //   1811: getfield configVersion_ : Lcom/google/protobuf/UInt32Value;
    //   1814: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   1819: checkcast com/google/protobuf/UInt32Value
    //   1822: putfield configVersion_ : Lcom/google/protobuf/UInt32Value;
    //   1825: aload_0
    //   1826: aload_1
    //   1827: aload_0
    //   1828: getfield name_ : Ljava/lang/String;
    //   1831: invokevirtual isEmpty : ()Z
    //   1834: iconst_1
    //   1835: ixor
    //   1836: aload_0
    //   1837: getfield name_ : Ljava/lang/String;
    //   1840: aload_2
    //   1841: getfield name_ : Ljava/lang/String;
    //   1844: invokevirtual isEmpty : ()Z
    //   1847: iconst_1
    //   1848: ixor
    //   1849: aload_2
    //   1850: getfield name_ : Ljava/lang/String;
    //   1853: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   1858: putfield name_ : Ljava/lang/String;
    //   1861: aload_0
    //   1862: aload_1
    //   1863: aload_0
    //   1864: getfield id_ : Ljava/lang/String;
    //   1867: invokevirtual isEmpty : ()Z
    //   1870: iconst_1
    //   1871: ixor
    //   1872: aload_0
    //   1873: getfield id_ : Ljava/lang/String;
    //   1876: aload_2
    //   1877: getfield id_ : Ljava/lang/String;
    //   1880: invokevirtual isEmpty : ()Z
    //   1883: iconst_1
    //   1884: ixor
    //   1885: aload_2
    //   1886: getfield id_ : Ljava/lang/String;
    //   1889: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   1894: putfield id_ : Ljava/lang/String;
    //   1897: aload_0
    //   1898: aload_1
    //   1899: aload_0
    //   1900: getfield title_ : Ljava/lang/String;
    //   1903: invokevirtual isEmpty : ()Z
    //   1906: iconst_1
    //   1907: ixor
    //   1908: aload_0
    //   1909: getfield title_ : Ljava/lang/String;
    //   1912: aload_2
    //   1913: getfield title_ : Ljava/lang/String;
    //   1916: invokevirtual isEmpty : ()Z
    //   1919: iconst_1
    //   1920: ixor
    //   1921: aload_2
    //   1922: getfield title_ : Ljava/lang/String;
    //   1925: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   1930: putfield title_ : Ljava/lang/String;
    //   1933: aload_0
    //   1934: aload_1
    //   1935: aload_0
    //   1936: getfield producerProjectId_ : Ljava/lang/String;
    //   1939: invokevirtual isEmpty : ()Z
    //   1942: iconst_1
    //   1943: ixor
    //   1944: aload_0
    //   1945: getfield producerProjectId_ : Ljava/lang/String;
    //   1948: iconst_1
    //   1949: aload_2
    //   1950: getfield producerProjectId_ : Ljava/lang/String;
    //   1953: invokevirtual isEmpty : ()Z
    //   1956: ixor
    //   1957: aload_2
    //   1958: getfield producerProjectId_ : Ljava/lang/String;
    //   1961: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   1966: putfield producerProjectId_ : Ljava/lang/String;
    //   1969: aload_0
    //   1970: aload_1
    //   1971: aload_0
    //   1972: getfield apis_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   1975: aload_2
    //   1976: getfield apis_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   1979: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   1984: putfield apis_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   1987: aload_0
    //   1988: aload_1
    //   1989: aload_0
    //   1990: getfield types_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   1993: aload_2
    //   1994: getfield types_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   1997: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   2002: putfield types_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   2005: aload_0
    //   2006: aload_1
    //   2007: aload_0
    //   2008: getfield enums_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   2011: aload_2
    //   2012: getfield enums_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   2015: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   2020: putfield enums_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   2023: aload_0
    //   2024: aload_1
    //   2025: aload_0
    //   2026: getfield documentation_ : Lcom/google/api/Documentation;
    //   2029: aload_2
    //   2030: getfield documentation_ : Lcom/google/api/Documentation;
    //   2033: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   2038: checkcast com/google/api/Documentation
    //   2041: putfield documentation_ : Lcom/google/api/Documentation;
    //   2044: aload_0
    //   2045: aload_1
    //   2046: aload_0
    //   2047: getfield backend_ : Lcom/google/api/Backend;
    //   2050: aload_2
    //   2051: getfield backend_ : Lcom/google/api/Backend;
    //   2054: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   2059: checkcast com/google/api/Backend
    //   2062: putfield backend_ : Lcom/google/api/Backend;
    //   2065: aload_0
    //   2066: aload_1
    //   2067: aload_0
    //   2068: getfield http_ : Lcom/google/api/Http;
    //   2071: aload_2
    //   2072: getfield http_ : Lcom/google/api/Http;
    //   2075: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   2080: checkcast com/google/api/Http
    //   2083: putfield http_ : Lcom/google/api/Http;
    //   2086: aload_0
    //   2087: aload_1
    //   2088: aload_0
    //   2089: getfield quota_ : Lcom/google/api/Quota;
    //   2092: aload_2
    //   2093: getfield quota_ : Lcom/google/api/Quota;
    //   2096: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   2101: checkcast com/google/api/Quota
    //   2104: putfield quota_ : Lcom/google/api/Quota;
    //   2107: aload_0
    //   2108: aload_1
    //   2109: aload_0
    //   2110: getfield authentication_ : Lcom/google/api/Authentication;
    //   2113: aload_2
    //   2114: getfield authentication_ : Lcom/google/api/Authentication;
    //   2117: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   2122: checkcast com/google/api/Authentication
    //   2125: putfield authentication_ : Lcom/google/api/Authentication;
    //   2128: aload_0
    //   2129: aload_1
    //   2130: aload_0
    //   2131: getfield context_ : Lcom/google/api/Context;
    //   2134: aload_2
    //   2135: getfield context_ : Lcom/google/api/Context;
    //   2138: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   2143: checkcast com/google/api/Context
    //   2146: putfield context_ : Lcom/google/api/Context;
    //   2149: aload_0
    //   2150: aload_1
    //   2151: aload_0
    //   2152: getfield usage_ : Lcom/google/api/Usage;
    //   2155: aload_2
    //   2156: getfield usage_ : Lcom/google/api/Usage;
    //   2159: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   2164: checkcast com/google/api/Usage
    //   2167: putfield usage_ : Lcom/google/api/Usage;
    //   2170: aload_0
    //   2171: aload_1
    //   2172: aload_0
    //   2173: getfield endpoints_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   2176: aload_2
    //   2177: getfield endpoints_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   2180: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   2185: putfield endpoints_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   2188: aload_0
    //   2189: aload_1
    //   2190: aload_0
    //   2191: getfield control_ : Lcom/google/api/Control;
    //   2194: aload_2
    //   2195: getfield control_ : Lcom/google/api/Control;
    //   2198: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   2203: checkcast com/google/api/Control
    //   2206: putfield control_ : Lcom/google/api/Control;
    //   2209: aload_0
    //   2210: aload_1
    //   2211: aload_0
    //   2212: getfield logs_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   2215: aload_2
    //   2216: getfield logs_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   2219: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   2224: putfield logs_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   2227: aload_0
    //   2228: aload_1
    //   2229: aload_0
    //   2230: getfield metrics_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   2233: aload_2
    //   2234: getfield metrics_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   2237: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   2242: putfield metrics_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   2245: aload_0
    //   2246: aload_1
    //   2247: aload_0
    //   2248: getfield monitoredResources_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   2251: aload_2
    //   2252: getfield monitoredResources_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   2255: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   2260: putfield monitoredResources_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   2263: aload_0
    //   2264: aload_1
    //   2265: aload_0
    //   2266: getfield billing_ : Lcom/google/api/Billing;
    //   2269: aload_2
    //   2270: getfield billing_ : Lcom/google/api/Billing;
    //   2273: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   2278: checkcast com/google/api/Billing
    //   2281: putfield billing_ : Lcom/google/api/Billing;
    //   2284: aload_0
    //   2285: aload_1
    //   2286: aload_0
    //   2287: getfield logging_ : Lcom/google/api/Logging;
    //   2290: aload_2
    //   2291: getfield logging_ : Lcom/google/api/Logging;
    //   2294: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   2299: checkcast com/google/api/Logging
    //   2302: putfield logging_ : Lcom/google/api/Logging;
    //   2305: aload_0
    //   2306: aload_1
    //   2307: aload_0
    //   2308: getfield monitoring_ : Lcom/google/api/Monitoring;
    //   2311: aload_2
    //   2312: getfield monitoring_ : Lcom/google/api/Monitoring;
    //   2315: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   2320: checkcast com/google/api/Monitoring
    //   2323: putfield monitoring_ : Lcom/google/api/Monitoring;
    //   2326: aload_0
    //   2327: aload_1
    //   2328: aload_0
    //   2329: getfield systemParameters_ : Lcom/google/api/SystemParameters;
    //   2332: aload_2
    //   2333: getfield systemParameters_ : Lcom/google/api/SystemParameters;
    //   2336: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   2341: checkcast com/google/api/SystemParameters
    //   2344: putfield systemParameters_ : Lcom/google/api/SystemParameters;
    //   2347: aload_0
    //   2348: aload_1
    //   2349: aload_0
    //   2350: getfield sourceInfo_ : Lcom/google/api/SourceInfo;
    //   2353: aload_2
    //   2354: getfield sourceInfo_ : Lcom/google/api/SourceInfo;
    //   2357: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   2362: checkcast com/google/api/SourceInfo
    //   2365: putfield sourceInfo_ : Lcom/google/api/SourceInfo;
    //   2368: aload_0
    //   2369: aload_1
    //   2370: aload_0
    //   2371: getfield experimental_ : Lcom/google/api/Experimental;
    //   2374: aload_2
    //   2375: getfield experimental_ : Lcom/google/api/Experimental;
    //   2378: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   2383: checkcast com/google/api/Experimental
    //   2386: putfield experimental_ : Lcom/google/api/Experimental;
    //   2389: aload_1
    //   2390: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   2393: if_acmpne -> 2409
    //   2396: aload_0
    //   2397: aload_0
    //   2398: getfield bitField0_ : I
    //   2401: aload_2
    //   2402: getfield bitField0_ : I
    //   2405: ior
    //   2406: putfield bitField0_ : I
    //   2409: aload_0
    //   2410: areturn
    //   2411: new com/google/api/Service$Builder
    //   2414: dup
    //   2415: aconst_null
    //   2416: invokespecial <init> : (Lcom/google/api/Service$1;)V
    //   2419: areturn
    //   2420: aload_0
    //   2421: getfield apis_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   2424: invokeinterface makeImmutable : ()V
    //   2429: aload_0
    //   2430: getfield types_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   2433: invokeinterface makeImmutable : ()V
    //   2438: aload_0
    //   2439: getfield enums_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   2442: invokeinterface makeImmutable : ()V
    //   2447: aload_0
    //   2448: getfield endpoints_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   2451: invokeinterface makeImmutable : ()V
    //   2456: aload_0
    //   2457: getfield logs_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   2460: invokeinterface makeImmutable : ()V
    //   2465: aload_0
    //   2466: getfield metrics_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   2469: invokeinterface makeImmutable : ()V
    //   2474: aload_0
    //   2475: getfield monitoredResources_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   2478: invokeinterface makeImmutable : ()V
    //   2483: aconst_null
    //   2484: areturn
    //   2485: getstatic com/google/api/Service.DEFAULT_INSTANCE : Lcom/google/api/Service;
    //   2488: areturn
    //   2489: new com/google/api/Service
    //   2492: dup
    //   2493: invokespecial <init> : ()V
    //   2496: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	1772	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	1744	java/io/IOException
    //   128	134	1740	finally
    //   364	372	1772	com/google/protobuf/InvalidProtocolBufferException
    //   364	372	1744	java/io/IOException
    //   364	372	1740	finally
    //   375	393	1772	com/google/protobuf/InvalidProtocolBufferException
    //   375	393	1744	java/io/IOException
    //   375	393	1740	finally
    //   398	413	1772	com/google/protobuf/InvalidProtocolBufferException
    //   398	413	1744	java/io/IOException
    //   398	413	1740	finally
    //   417	437	1772	com/google/protobuf/InvalidProtocolBufferException
    //   417	437	1744	java/io/IOException
    //   417	437	1740	finally
    //   440	458	1772	com/google/protobuf/InvalidProtocolBufferException
    //   440	458	1744	java/io/IOException
    //   440	458	1740	finally
    //   463	478	1772	com/google/protobuf/InvalidProtocolBufferException
    //   463	478	1744	java/io/IOException
    //   463	478	1740	finally
    //   482	502	1772	com/google/protobuf/InvalidProtocolBufferException
    //   482	502	1744	java/io/IOException
    //   482	502	1740	finally
    //   505	513	1772	com/google/protobuf/InvalidProtocolBufferException
    //   505	513	1744	java/io/IOException
    //   505	513	1740	finally
    //   516	534	1772	com/google/protobuf/InvalidProtocolBufferException
    //   516	534	1744	java/io/IOException
    //   516	534	1740	finally
    //   539	554	1772	com/google/protobuf/InvalidProtocolBufferException
    //   539	554	1744	java/io/IOException
    //   539	554	1740	finally
    //   558	578	1772	com/google/protobuf/InvalidProtocolBufferException
    //   558	578	1744	java/io/IOException
    //   558	578	1740	finally
    //   581	599	1772	com/google/protobuf/InvalidProtocolBufferException
    //   581	599	1744	java/io/IOException
    //   581	599	1740	finally
    //   604	619	1772	com/google/protobuf/InvalidProtocolBufferException
    //   604	619	1744	java/io/IOException
    //   604	619	1740	finally
    //   623	643	1772	com/google/protobuf/InvalidProtocolBufferException
    //   623	643	1744	java/io/IOException
    //   623	643	1740	finally
    //   646	664	1772	com/google/protobuf/InvalidProtocolBufferException
    //   646	664	1744	java/io/IOException
    //   646	664	1740	finally
    //   669	684	1772	com/google/protobuf/InvalidProtocolBufferException
    //   669	684	1744	java/io/IOException
    //   669	684	1740	finally
    //   688	708	1772	com/google/protobuf/InvalidProtocolBufferException
    //   688	708	1744	java/io/IOException
    //   688	708	1740	finally
    //   711	729	1772	com/google/protobuf/InvalidProtocolBufferException
    //   711	729	1744	java/io/IOException
    //   711	729	1740	finally
    //   734	749	1772	com/google/protobuf/InvalidProtocolBufferException
    //   734	749	1744	java/io/IOException
    //   734	749	1740	finally
    //   753	773	1772	com/google/protobuf/InvalidProtocolBufferException
    //   753	773	1744	java/io/IOException
    //   753	773	1740	finally
    //   776	799	1772	com/google/protobuf/InvalidProtocolBufferException
    //   776	799	1744	java/io/IOException
    //   776	799	1740	finally
    //   799	820	1772	com/google/protobuf/InvalidProtocolBufferException
    //   799	820	1744	java/io/IOException
    //   799	820	1740	finally
    //   823	846	1772	com/google/protobuf/InvalidProtocolBufferException
    //   823	846	1744	java/io/IOException
    //   823	846	1740	finally
    //   846	867	1772	com/google/protobuf/InvalidProtocolBufferException
    //   846	867	1744	java/io/IOException
    //   846	867	1740	finally
    //   870	893	1772	com/google/protobuf/InvalidProtocolBufferException
    //   870	893	1744	java/io/IOException
    //   870	893	1740	finally
    //   893	914	1772	com/google/protobuf/InvalidProtocolBufferException
    //   893	914	1744	java/io/IOException
    //   893	914	1740	finally
    //   917	925	1772	com/google/protobuf/InvalidProtocolBufferException
    //   917	925	1744	java/io/IOException
    //   917	925	1740	finally
    //   928	946	1772	com/google/protobuf/InvalidProtocolBufferException
    //   928	946	1744	java/io/IOException
    //   928	946	1740	finally
    //   951	966	1772	com/google/protobuf/InvalidProtocolBufferException
    //   951	966	1744	java/io/IOException
    //   951	966	1740	finally
    //   970	990	1772	com/google/protobuf/InvalidProtocolBufferException
    //   970	990	1744	java/io/IOException
    //   970	990	1740	finally
    //   993	1011	1772	com/google/protobuf/InvalidProtocolBufferException
    //   993	1011	1744	java/io/IOException
    //   993	1011	1740	finally
    //   1016	1031	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1016	1031	1744	java/io/IOException
    //   1016	1031	1740	finally
    //   1035	1055	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1035	1055	1744	java/io/IOException
    //   1035	1055	1740	finally
    //   1058	1081	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1058	1081	1744	java/io/IOException
    //   1058	1081	1740	finally
    //   1081	1102	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1081	1102	1744	java/io/IOException
    //   1081	1102	1740	finally
    //   1105	1123	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1105	1123	1744	java/io/IOException
    //   1105	1123	1740	finally
    //   1128	1143	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1128	1143	1744	java/io/IOException
    //   1128	1143	1740	finally
    //   1147	1167	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1147	1167	1744	java/io/IOException
    //   1147	1167	1740	finally
    //   1170	1188	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1170	1188	1744	java/io/IOException
    //   1170	1188	1740	finally
    //   1193	1208	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1193	1208	1744	java/io/IOException
    //   1193	1208	1740	finally
    //   1212	1232	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1212	1232	1744	java/io/IOException
    //   1212	1232	1740	finally
    //   1235	1253	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1235	1253	1744	java/io/IOException
    //   1235	1253	1740	finally
    //   1258	1273	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1258	1273	1744	java/io/IOException
    //   1258	1273	1740	finally
    //   1277	1297	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1277	1297	1744	java/io/IOException
    //   1277	1297	1740	finally
    //   1300	1318	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1300	1318	1744	java/io/IOException
    //   1300	1318	1740	finally
    //   1323	1338	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1323	1338	1744	java/io/IOException
    //   1323	1338	1740	finally
    //   1342	1362	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1342	1362	1744	java/io/IOException
    //   1342	1362	1740	finally
    //   1365	1383	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1365	1383	1744	java/io/IOException
    //   1365	1383	1740	finally
    //   1388	1403	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1388	1403	1744	java/io/IOException
    //   1388	1403	1740	finally
    //   1407	1427	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1407	1427	1744	java/io/IOException
    //   1407	1427	1740	finally
    //   1430	1448	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1430	1448	1744	java/io/IOException
    //   1430	1448	1740	finally
    //   1453	1468	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1453	1468	1744	java/io/IOException
    //   1453	1468	1740	finally
    //   1472	1492	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1472	1492	1744	java/io/IOException
    //   1472	1492	1740	finally
    //   1495	1513	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1495	1513	1744	java/io/IOException
    //   1495	1513	1740	finally
    //   1518	1533	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1518	1533	1744	java/io/IOException
    //   1518	1533	1740	finally
    //   1537	1557	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1537	1557	1744	java/io/IOException
    //   1537	1557	1740	finally
    //   1560	1583	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1560	1583	1744	java/io/IOException
    //   1560	1583	1740	finally
    //   1583	1604	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1583	1604	1744	java/io/IOException
    //   1583	1604	1740	finally
    //   1607	1630	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1607	1630	1744	java/io/IOException
    //   1607	1630	1740	finally
    //   1630	1651	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1630	1651	1744	java/io/IOException
    //   1630	1651	1740	finally
    //   1654	1677	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1654	1677	1744	java/io/IOException
    //   1654	1677	1740	finally
    //   1677	1698	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1677	1698	1744	java/io/IOException
    //   1677	1698	1740	finally
    //   1701	1709	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1701	1709	1744	java/io/IOException
    //   1701	1709	1740	finally
    //   1712	1720	1772	com/google/protobuf/InvalidProtocolBufferException
    //   1712	1720	1744	java/io/IOException
    //   1712	1720	1740	finally
    //   1745	1772	1740	finally
    //   1773	1788	1740	finally
  }
  
  public Api getApis(int paramInt) {
    return (Api)this.apis_.get(paramInt);
  }
  
  public int getApisCount() {
    return this.apis_.size();
  }
  
  public List<Api> getApisList() {
    return (List<Api>)this.apis_;
  }
  
  public ApiOrBuilder getApisOrBuilder(int paramInt) {
    return (ApiOrBuilder)this.apis_.get(paramInt);
  }
  
  public List<? extends ApiOrBuilder> getApisOrBuilderList() {
    return (List)this.apis_;
  }
  
  public Authentication getAuthentication() {
    Authentication authentication1 = this.authentication_;
    Authentication authentication2 = authentication1;
    if (authentication1 == null)
      authentication2 = Authentication.getDefaultInstance(); 
    return authentication2;
  }
  
  public Backend getBackend() {
    Backend backend1 = this.backend_;
    Backend backend2 = backend1;
    if (backend1 == null)
      backend2 = Backend.getDefaultInstance(); 
    return backend2;
  }
  
  public Billing getBilling() {
    Billing billing1 = this.billing_;
    Billing billing2 = billing1;
    if (billing1 == null)
      billing2 = Billing.getDefaultInstance(); 
    return billing2;
  }
  
  public UInt32Value getConfigVersion() {
    UInt32Value uInt32Value1 = this.configVersion_;
    UInt32Value uInt32Value2 = uInt32Value1;
    if (uInt32Value1 == null)
      uInt32Value2 = UInt32Value.getDefaultInstance(); 
    return uInt32Value2;
  }
  
  public Context getContext() {
    Context context1 = this.context_;
    Context context2 = context1;
    if (context1 == null)
      context2 = Context.getDefaultInstance(); 
    return context2;
  }
  
  public Control getControl() {
    Control control1 = this.control_;
    Control control2 = control1;
    if (control1 == null)
      control2 = Control.getDefaultInstance(); 
    return control2;
  }
  
  public Documentation getDocumentation() {
    Documentation documentation1 = this.documentation_;
    Documentation documentation2 = documentation1;
    if (documentation1 == null)
      documentation2 = Documentation.getDefaultInstance(); 
    return documentation2;
  }
  
  public Endpoint getEndpoints(int paramInt) {
    return (Endpoint)this.endpoints_.get(paramInt);
  }
  
  public int getEndpointsCount() {
    return this.endpoints_.size();
  }
  
  public List<Endpoint> getEndpointsList() {
    return (List<Endpoint>)this.endpoints_;
  }
  
  public EndpointOrBuilder getEndpointsOrBuilder(int paramInt) {
    return (EndpointOrBuilder)this.endpoints_.get(paramInt);
  }
  
  public List<? extends EndpointOrBuilder> getEndpointsOrBuilderList() {
    return (List)this.endpoints_;
  }
  
  public Enum getEnums(int paramInt) {
    return (Enum)this.enums_.get(paramInt);
  }
  
  public int getEnumsCount() {
    return this.enums_.size();
  }
  
  public List<Enum> getEnumsList() {
    return (List<Enum>)this.enums_;
  }
  
  public EnumOrBuilder getEnumsOrBuilder(int paramInt) {
    return (EnumOrBuilder)this.enums_.get(paramInt);
  }
  
  public List<? extends EnumOrBuilder> getEnumsOrBuilderList() {
    return (List)this.enums_;
  }
  
  public Experimental getExperimental() {
    Experimental experimental1 = this.experimental_;
    Experimental experimental2 = experimental1;
    if (experimental1 == null)
      experimental2 = Experimental.getDefaultInstance(); 
    return experimental2;
  }
  
  public Http getHttp() {
    Http http1 = this.http_;
    Http http2 = http1;
    if (http1 == null)
      http2 = Http.getDefaultInstance(); 
    return http2;
  }
  
  public String getId() {
    return this.id_;
  }
  
  public ByteString getIdBytes() {
    return ByteString.copyFromUtf8(this.id_);
  }
  
  public Logging getLogging() {
    Logging logging1 = this.logging_;
    Logging logging2 = logging1;
    if (logging1 == null)
      logging2 = Logging.getDefaultInstance(); 
    return logging2;
  }
  
  public LogDescriptor getLogs(int paramInt) {
    return (LogDescriptor)this.logs_.get(paramInt);
  }
  
  public int getLogsCount() {
    return this.logs_.size();
  }
  
  public List<LogDescriptor> getLogsList() {
    return (List<LogDescriptor>)this.logs_;
  }
  
  public LogDescriptorOrBuilder getLogsOrBuilder(int paramInt) {
    return (LogDescriptorOrBuilder)this.logs_.get(paramInt);
  }
  
  public List<? extends LogDescriptorOrBuilder> getLogsOrBuilderList() {
    return (List)this.logs_;
  }
  
  public MetricDescriptor getMetrics(int paramInt) {
    return (MetricDescriptor)this.metrics_.get(paramInt);
  }
  
  public int getMetricsCount() {
    return this.metrics_.size();
  }
  
  public List<MetricDescriptor> getMetricsList() {
    return (List<MetricDescriptor>)this.metrics_;
  }
  
  public MetricDescriptorOrBuilder getMetricsOrBuilder(int paramInt) {
    return (MetricDescriptorOrBuilder)this.metrics_.get(paramInt);
  }
  
  public List<? extends MetricDescriptorOrBuilder> getMetricsOrBuilderList() {
    return (List)this.metrics_;
  }
  
  public MonitoredResourceDescriptor getMonitoredResources(int paramInt) {
    return (MonitoredResourceDescriptor)this.monitoredResources_.get(paramInt);
  }
  
  public int getMonitoredResourcesCount() {
    return this.monitoredResources_.size();
  }
  
  public List<MonitoredResourceDescriptor> getMonitoredResourcesList() {
    return (List<MonitoredResourceDescriptor>)this.monitoredResources_;
  }
  
  public MonitoredResourceDescriptorOrBuilder getMonitoredResourcesOrBuilder(int paramInt) {
    return (MonitoredResourceDescriptorOrBuilder)this.monitoredResources_.get(paramInt);
  }
  
  public List<? extends MonitoredResourceDescriptorOrBuilder> getMonitoredResourcesOrBuilderList() {
    return (List)this.monitoredResources_;
  }
  
  public Monitoring getMonitoring() {
    Monitoring monitoring1 = this.monitoring_;
    Monitoring monitoring2 = monitoring1;
    if (monitoring1 == null)
      monitoring2 = Monitoring.getDefaultInstance(); 
    return monitoring2;
  }
  
  public String getName() {
    return this.name_;
  }
  
  public ByteString getNameBytes() {
    return ByteString.copyFromUtf8(this.name_);
  }
  
  public String getProducerProjectId() {
    return this.producerProjectId_;
  }
  
  public ByteString getProducerProjectIdBytes() {
    return ByteString.copyFromUtf8(this.producerProjectId_);
  }
  
  public Quota getQuota() {
    Quota quota1 = this.quota_;
    Quota quota2 = quota1;
    if (quota1 == null)
      quota2 = Quota.getDefaultInstance(); 
    return quota2;
  }
  
  public int getSerializedSize() {
    byte b2;
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    boolean bool = this.name_.isEmpty();
    byte b1 = 0;
    if (!bool) {
      j = CodedOutputStream.computeStringSize(1, getName()) + 0;
    } else {
      j = 0;
    } 
    i = j;
    if (!this.title_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(2, getTitle()); 
    int j;
    for (j = 0; j < this.apis_.size(); j++)
      i += CodedOutputStream.computeMessageSize(3, (MessageLite)this.apis_.get(j)); 
    for (j = 0; j < this.types_.size(); j++)
      i += CodedOutputStream.computeMessageSize(4, (MessageLite)this.types_.get(j)); 
    for (j = 0; j < this.enums_.size(); j++)
      i += CodedOutputStream.computeMessageSize(5, (MessageLite)this.enums_.get(j)); 
    j = i;
    if (this.documentation_ != null)
      j = i + CodedOutputStream.computeMessageSize(6, (MessageLite)getDocumentation()); 
    int k = j;
    if (this.backend_ != null)
      k = j + CodedOutputStream.computeMessageSize(8, (MessageLite)getBackend()); 
    i = k;
    if (this.http_ != null)
      i = k + CodedOutputStream.computeMessageSize(9, (MessageLite)getHttp()); 
    j = i;
    if (this.quota_ != null)
      j = i + CodedOutputStream.computeMessageSize(10, (MessageLite)getQuota()); 
    i = j;
    if (this.authentication_ != null)
      i = j + CodedOutputStream.computeMessageSize(11, (MessageLite)getAuthentication()); 
    j = i;
    if (this.context_ != null)
      j = i + CodedOutputStream.computeMessageSize(12, (MessageLite)getContext()); 
    i = j;
    if (this.usage_ != null)
      i = j + CodedOutputStream.computeMessageSize(15, (MessageLite)getUsage()); 
    for (j = 0; j < this.endpoints_.size(); j++)
      i += CodedOutputStream.computeMessageSize(18, (MessageLite)this.endpoints_.get(j)); 
    j = i;
    if (this.configVersion_ != null)
      j = i + CodedOutputStream.computeMessageSize(20, (MessageLite)getConfigVersion()); 
    i = j;
    if (this.control_ != null)
      i = j + CodedOutputStream.computeMessageSize(21, (MessageLite)getControl()); 
    j = i;
    if (!this.producerProjectId_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(22, getProducerProjectId()); 
    for (i = 0; i < this.logs_.size(); i++)
      j += CodedOutputStream.computeMessageSize(23, (MessageLite)this.logs_.get(i)); 
    k = 0;
    while (true) {
      b2 = b1;
      i = j;
      if (k < this.metrics_.size()) {
        j += CodedOutputStream.computeMessageSize(24, (MessageLite)this.metrics_.get(k));
        k++;
        continue;
      } 
      break;
    } 
    while (b2 < this.monitoredResources_.size()) {
      i += CodedOutputStream.computeMessageSize(25, (MessageLite)this.monitoredResources_.get(b2));
      b2++;
    } 
    j = i;
    if (this.billing_ != null)
      j = i + CodedOutputStream.computeMessageSize(26, (MessageLite)getBilling()); 
    k = j;
    if (this.logging_ != null)
      k = j + CodedOutputStream.computeMessageSize(27, (MessageLite)getLogging()); 
    i = k;
    if (this.monitoring_ != null)
      i = k + CodedOutputStream.computeMessageSize(28, (MessageLite)getMonitoring()); 
    k = i;
    if (this.systemParameters_ != null)
      k = i + CodedOutputStream.computeMessageSize(29, (MessageLite)getSystemParameters()); 
    j = k;
    if (!this.id_.isEmpty())
      j = k + CodedOutputStream.computeStringSize(33, getId()); 
    i = j;
    if (this.sourceInfo_ != null)
      i = j + CodedOutputStream.computeMessageSize(37, (MessageLite)getSourceInfo()); 
    j = i;
    if (this.experimental_ != null)
      j = i + CodedOutputStream.computeMessageSize(101, (MessageLite)getExperimental()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public SourceInfo getSourceInfo() {
    SourceInfo sourceInfo1 = this.sourceInfo_;
    SourceInfo sourceInfo2 = sourceInfo1;
    if (sourceInfo1 == null)
      sourceInfo2 = SourceInfo.getDefaultInstance(); 
    return sourceInfo2;
  }
  
  public SystemParameters getSystemParameters() {
    SystemParameters systemParameters1 = this.systemParameters_;
    SystemParameters systemParameters2 = systemParameters1;
    if (systemParameters1 == null)
      systemParameters2 = SystemParameters.getDefaultInstance(); 
    return systemParameters2;
  }
  
  public String getTitle() {
    return this.title_;
  }
  
  public ByteString getTitleBytes() {
    return ByteString.copyFromUtf8(this.title_);
  }
  
  public Type getTypes(int paramInt) {
    return (Type)this.types_.get(paramInt);
  }
  
  public int getTypesCount() {
    return this.types_.size();
  }
  
  public List<Type> getTypesList() {
    return (List<Type>)this.types_;
  }
  
  public TypeOrBuilder getTypesOrBuilder(int paramInt) {
    return (TypeOrBuilder)this.types_.get(paramInt);
  }
  
  public List<? extends TypeOrBuilder> getTypesOrBuilderList() {
    return (List)this.types_;
  }
  
  public Usage getUsage() {
    Usage usage1 = this.usage_;
    Usage usage2 = usage1;
    if (usage1 == null)
      usage2 = Usage.getDefaultInstance(); 
    return usage2;
  }
  
  public boolean hasAuthentication() {
    boolean bool;
    if (this.authentication_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasBackend() {
    boolean bool;
    if (this.backend_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasBilling() {
    boolean bool;
    if (this.billing_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasConfigVersion() {
    boolean bool;
    if (this.configVersion_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasContext() {
    boolean bool;
    if (this.context_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasControl() {
    boolean bool;
    if (this.control_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasDocumentation() {
    boolean bool;
    if (this.documentation_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasExperimental() {
    boolean bool;
    if (this.experimental_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasHttp() {
    boolean bool;
    if (this.http_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasLogging() {
    boolean bool;
    if (this.logging_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasMonitoring() {
    boolean bool;
    if (this.monitoring_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasQuota() {
    boolean bool;
    if (this.quota_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasSourceInfo() {
    boolean bool;
    if (this.sourceInfo_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasSystemParameters() {
    boolean bool;
    if (this.systemParameters_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasUsage() {
    boolean bool;
    if (this.usage_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(1, getName()); 
    if (!this.title_.isEmpty())
      paramCodedOutputStream.writeString(2, getTitle()); 
    boolean bool = false;
    byte b1;
    for (b1 = 0; b1 < this.apis_.size(); b1++)
      paramCodedOutputStream.writeMessage(3, (MessageLite)this.apis_.get(b1)); 
    for (b1 = 0; b1 < this.types_.size(); b1++)
      paramCodedOutputStream.writeMessage(4, (MessageLite)this.types_.get(b1)); 
    for (b1 = 0; b1 < this.enums_.size(); b1++)
      paramCodedOutputStream.writeMessage(5, (MessageLite)this.enums_.get(b1)); 
    if (this.documentation_ != null)
      paramCodedOutputStream.writeMessage(6, (MessageLite)getDocumentation()); 
    if (this.backend_ != null)
      paramCodedOutputStream.writeMessage(8, (MessageLite)getBackend()); 
    if (this.http_ != null)
      paramCodedOutputStream.writeMessage(9, (MessageLite)getHttp()); 
    if (this.quota_ != null)
      paramCodedOutputStream.writeMessage(10, (MessageLite)getQuota()); 
    if (this.authentication_ != null)
      paramCodedOutputStream.writeMessage(11, (MessageLite)getAuthentication()); 
    if (this.context_ != null)
      paramCodedOutputStream.writeMessage(12, (MessageLite)getContext()); 
    if (this.usage_ != null)
      paramCodedOutputStream.writeMessage(15, (MessageLite)getUsage()); 
    for (b1 = 0; b1 < this.endpoints_.size(); b1++)
      paramCodedOutputStream.writeMessage(18, (MessageLite)this.endpoints_.get(b1)); 
    if (this.configVersion_ != null)
      paramCodedOutputStream.writeMessage(20, (MessageLite)getConfigVersion()); 
    if (this.control_ != null)
      paramCodedOutputStream.writeMessage(21, (MessageLite)getControl()); 
    if (!this.producerProjectId_.isEmpty())
      paramCodedOutputStream.writeString(22, getProducerProjectId()); 
    for (b1 = 0; b1 < this.logs_.size(); b1++)
      paramCodedOutputStream.writeMessage(23, (MessageLite)this.logs_.get(b1)); 
    byte b2 = 0;
    while (true) {
      b1 = bool;
      if (b2 < this.metrics_.size()) {
        paramCodedOutputStream.writeMessage(24, (MessageLite)this.metrics_.get(b2));
        b2++;
        continue;
      } 
      break;
    } 
    while (b1 < this.monitoredResources_.size()) {
      paramCodedOutputStream.writeMessage(25, (MessageLite)this.monitoredResources_.get(b1));
      b1++;
    } 
    if (this.billing_ != null)
      paramCodedOutputStream.writeMessage(26, (MessageLite)getBilling()); 
    if (this.logging_ != null)
      paramCodedOutputStream.writeMessage(27, (MessageLite)getLogging()); 
    if (this.monitoring_ != null)
      paramCodedOutputStream.writeMessage(28, (MessageLite)getMonitoring()); 
    if (this.systemParameters_ != null)
      paramCodedOutputStream.writeMessage(29, (MessageLite)getSystemParameters()); 
    if (!this.id_.isEmpty())
      paramCodedOutputStream.writeString(33, getId()); 
    if (this.sourceInfo_ != null)
      paramCodedOutputStream.writeMessage(37, (MessageLite)getSourceInfo()); 
    if (this.experimental_ != null)
      paramCodedOutputStream.writeMessage(101, (MessageLite)getExperimental()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Service, Builder> implements ServiceOrBuilder {
    private Builder() {
      super(Service.DEFAULT_INSTANCE);
    }
    
    public Builder addAllApis(Iterable<? extends Api> param1Iterable) {
      copyOnWrite();
      ((Service)this.instance).addAllApis(param1Iterable);
      return this;
    }
    
    public Builder addAllEndpoints(Iterable<? extends Endpoint> param1Iterable) {
      copyOnWrite();
      ((Service)this.instance).addAllEndpoints(param1Iterable);
      return this;
    }
    
    public Builder addAllEnums(Iterable<? extends Enum> param1Iterable) {
      copyOnWrite();
      ((Service)this.instance).addAllEnums(param1Iterable);
      return this;
    }
    
    public Builder addAllLogs(Iterable<? extends LogDescriptor> param1Iterable) {
      copyOnWrite();
      ((Service)this.instance).addAllLogs(param1Iterable);
      return this;
    }
    
    public Builder addAllMetrics(Iterable<? extends MetricDescriptor> param1Iterable) {
      copyOnWrite();
      ((Service)this.instance).addAllMetrics(param1Iterable);
      return this;
    }
    
    public Builder addAllMonitoredResources(Iterable<? extends MonitoredResourceDescriptor> param1Iterable) {
      copyOnWrite();
      ((Service)this.instance).addAllMonitoredResources(param1Iterable);
      return this;
    }
    
    public Builder addAllTypes(Iterable<? extends Type> param1Iterable) {
      copyOnWrite();
      ((Service)this.instance).addAllTypes(param1Iterable);
      return this;
    }
    
    public Builder addApis(int param1Int, Api.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).addApis(param1Int, param1Builder);
      return this;
    }
    
    public Builder addApis(int param1Int, Api param1Api) {
      copyOnWrite();
      ((Service)this.instance).addApis(param1Int, param1Api);
      return this;
    }
    
    public Builder addApis(Api.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).addApis(param1Builder);
      return this;
    }
    
    public Builder addApis(Api param1Api) {
      copyOnWrite();
      ((Service)this.instance).addApis(param1Api);
      return this;
    }
    
    public Builder addEndpoints(int param1Int, Endpoint.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).addEndpoints(param1Int, param1Builder);
      return this;
    }
    
    public Builder addEndpoints(int param1Int, Endpoint param1Endpoint) {
      copyOnWrite();
      ((Service)this.instance).addEndpoints(param1Int, param1Endpoint);
      return this;
    }
    
    public Builder addEndpoints(Endpoint.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).addEndpoints(param1Builder);
      return this;
    }
    
    public Builder addEndpoints(Endpoint param1Endpoint) {
      copyOnWrite();
      ((Service)this.instance).addEndpoints(param1Endpoint);
      return this;
    }
    
    public Builder addEnums(int param1Int, Enum.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).addEnums(param1Int, param1Builder);
      return this;
    }
    
    public Builder addEnums(int param1Int, Enum param1Enum) {
      copyOnWrite();
      ((Service)this.instance).addEnums(param1Int, param1Enum);
      return this;
    }
    
    public Builder addEnums(Enum.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).addEnums(param1Builder);
      return this;
    }
    
    public Builder addEnums(Enum param1Enum) {
      copyOnWrite();
      ((Service)this.instance).addEnums(param1Enum);
      return this;
    }
    
    public Builder addLogs(int param1Int, LogDescriptor.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).addLogs(param1Int, param1Builder);
      return this;
    }
    
    public Builder addLogs(int param1Int, LogDescriptor param1LogDescriptor) {
      copyOnWrite();
      ((Service)this.instance).addLogs(param1Int, param1LogDescriptor);
      return this;
    }
    
    public Builder addLogs(LogDescriptor.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).addLogs(param1Builder);
      return this;
    }
    
    public Builder addLogs(LogDescriptor param1LogDescriptor) {
      copyOnWrite();
      ((Service)this.instance).addLogs(param1LogDescriptor);
      return this;
    }
    
    public Builder addMetrics(int param1Int, MetricDescriptor.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).addMetrics(param1Int, param1Builder);
      return this;
    }
    
    public Builder addMetrics(int param1Int, MetricDescriptor param1MetricDescriptor) {
      copyOnWrite();
      ((Service)this.instance).addMetrics(param1Int, param1MetricDescriptor);
      return this;
    }
    
    public Builder addMetrics(MetricDescriptor.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).addMetrics(param1Builder);
      return this;
    }
    
    public Builder addMetrics(MetricDescriptor param1MetricDescriptor) {
      copyOnWrite();
      ((Service)this.instance).addMetrics(param1MetricDescriptor);
      return this;
    }
    
    public Builder addMonitoredResources(int param1Int, MonitoredResourceDescriptor.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).addMonitoredResources(param1Int, param1Builder);
      return this;
    }
    
    public Builder addMonitoredResources(int param1Int, MonitoredResourceDescriptor param1MonitoredResourceDescriptor) {
      copyOnWrite();
      ((Service)this.instance).addMonitoredResources(param1Int, param1MonitoredResourceDescriptor);
      return this;
    }
    
    public Builder addMonitoredResources(MonitoredResourceDescriptor.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).addMonitoredResources(param1Builder);
      return this;
    }
    
    public Builder addMonitoredResources(MonitoredResourceDescriptor param1MonitoredResourceDescriptor) {
      copyOnWrite();
      ((Service)this.instance).addMonitoredResources(param1MonitoredResourceDescriptor);
      return this;
    }
    
    public Builder addTypes(int param1Int, Type.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).addTypes(param1Int, param1Builder);
      return this;
    }
    
    public Builder addTypes(int param1Int, Type param1Type) {
      copyOnWrite();
      ((Service)this.instance).addTypes(param1Int, param1Type);
      return this;
    }
    
    public Builder addTypes(Type.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).addTypes(param1Builder);
      return this;
    }
    
    public Builder addTypes(Type param1Type) {
      copyOnWrite();
      ((Service)this.instance).addTypes(param1Type);
      return this;
    }
    
    public Builder clearApis() {
      copyOnWrite();
      ((Service)this.instance).clearApis();
      return this;
    }
    
    public Builder clearAuthentication() {
      copyOnWrite();
      ((Service)this.instance).clearAuthentication();
      return this;
    }
    
    public Builder clearBackend() {
      copyOnWrite();
      ((Service)this.instance).clearBackend();
      return this;
    }
    
    public Builder clearBilling() {
      copyOnWrite();
      ((Service)this.instance).clearBilling();
      return this;
    }
    
    public Builder clearConfigVersion() {
      copyOnWrite();
      ((Service)this.instance).clearConfigVersion();
      return this;
    }
    
    public Builder clearContext() {
      copyOnWrite();
      ((Service)this.instance).clearContext();
      return this;
    }
    
    public Builder clearControl() {
      copyOnWrite();
      ((Service)this.instance).clearControl();
      return this;
    }
    
    public Builder clearDocumentation() {
      copyOnWrite();
      ((Service)this.instance).clearDocumentation();
      return this;
    }
    
    public Builder clearEndpoints() {
      copyOnWrite();
      ((Service)this.instance).clearEndpoints();
      return this;
    }
    
    public Builder clearEnums() {
      copyOnWrite();
      ((Service)this.instance).clearEnums();
      return this;
    }
    
    public Builder clearExperimental() {
      copyOnWrite();
      ((Service)this.instance).clearExperimental();
      return this;
    }
    
    public Builder clearHttp() {
      copyOnWrite();
      ((Service)this.instance).clearHttp();
      return this;
    }
    
    public Builder clearId() {
      copyOnWrite();
      ((Service)this.instance).clearId();
      return this;
    }
    
    public Builder clearLogging() {
      copyOnWrite();
      ((Service)this.instance).clearLogging();
      return this;
    }
    
    public Builder clearLogs() {
      copyOnWrite();
      ((Service)this.instance).clearLogs();
      return this;
    }
    
    public Builder clearMetrics() {
      copyOnWrite();
      ((Service)this.instance).clearMetrics();
      return this;
    }
    
    public Builder clearMonitoredResources() {
      copyOnWrite();
      ((Service)this.instance).clearMonitoredResources();
      return this;
    }
    
    public Builder clearMonitoring() {
      copyOnWrite();
      ((Service)this.instance).clearMonitoring();
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      ((Service)this.instance).clearName();
      return this;
    }
    
    public Builder clearProducerProjectId() {
      copyOnWrite();
      ((Service)this.instance).clearProducerProjectId();
      return this;
    }
    
    public Builder clearQuota() {
      copyOnWrite();
      ((Service)this.instance).clearQuota();
      return this;
    }
    
    public Builder clearSourceInfo() {
      copyOnWrite();
      ((Service)this.instance).clearSourceInfo();
      return this;
    }
    
    public Builder clearSystemParameters() {
      copyOnWrite();
      ((Service)this.instance).clearSystemParameters();
      return this;
    }
    
    public Builder clearTitle() {
      copyOnWrite();
      ((Service)this.instance).clearTitle();
      return this;
    }
    
    public Builder clearTypes() {
      copyOnWrite();
      ((Service)this.instance).clearTypes();
      return this;
    }
    
    public Builder clearUsage() {
      copyOnWrite();
      ((Service)this.instance).clearUsage();
      return this;
    }
    
    public Api getApis(int param1Int) {
      return ((Service)this.instance).getApis(param1Int);
    }
    
    public int getApisCount() {
      return ((Service)this.instance).getApisCount();
    }
    
    public List<Api> getApisList() {
      return Collections.unmodifiableList(((Service)this.instance).getApisList());
    }
    
    public Authentication getAuthentication() {
      return ((Service)this.instance).getAuthentication();
    }
    
    public Backend getBackend() {
      return ((Service)this.instance).getBackend();
    }
    
    public Billing getBilling() {
      return ((Service)this.instance).getBilling();
    }
    
    public UInt32Value getConfigVersion() {
      return ((Service)this.instance).getConfigVersion();
    }
    
    public Context getContext() {
      return ((Service)this.instance).getContext();
    }
    
    public Control getControl() {
      return ((Service)this.instance).getControl();
    }
    
    public Documentation getDocumentation() {
      return ((Service)this.instance).getDocumentation();
    }
    
    public Endpoint getEndpoints(int param1Int) {
      return ((Service)this.instance).getEndpoints(param1Int);
    }
    
    public int getEndpointsCount() {
      return ((Service)this.instance).getEndpointsCount();
    }
    
    public List<Endpoint> getEndpointsList() {
      return Collections.unmodifiableList(((Service)this.instance).getEndpointsList());
    }
    
    public Enum getEnums(int param1Int) {
      return ((Service)this.instance).getEnums(param1Int);
    }
    
    public int getEnumsCount() {
      return ((Service)this.instance).getEnumsCount();
    }
    
    public List<Enum> getEnumsList() {
      return Collections.unmodifiableList(((Service)this.instance).getEnumsList());
    }
    
    public Experimental getExperimental() {
      return ((Service)this.instance).getExperimental();
    }
    
    public Http getHttp() {
      return ((Service)this.instance).getHttp();
    }
    
    public String getId() {
      return ((Service)this.instance).getId();
    }
    
    public ByteString getIdBytes() {
      return ((Service)this.instance).getIdBytes();
    }
    
    public Logging getLogging() {
      return ((Service)this.instance).getLogging();
    }
    
    public LogDescriptor getLogs(int param1Int) {
      return ((Service)this.instance).getLogs(param1Int);
    }
    
    public int getLogsCount() {
      return ((Service)this.instance).getLogsCount();
    }
    
    public List<LogDescriptor> getLogsList() {
      return Collections.unmodifiableList(((Service)this.instance).getLogsList());
    }
    
    public MetricDescriptor getMetrics(int param1Int) {
      return ((Service)this.instance).getMetrics(param1Int);
    }
    
    public int getMetricsCount() {
      return ((Service)this.instance).getMetricsCount();
    }
    
    public List<MetricDescriptor> getMetricsList() {
      return Collections.unmodifiableList(((Service)this.instance).getMetricsList());
    }
    
    public MonitoredResourceDescriptor getMonitoredResources(int param1Int) {
      return ((Service)this.instance).getMonitoredResources(param1Int);
    }
    
    public int getMonitoredResourcesCount() {
      return ((Service)this.instance).getMonitoredResourcesCount();
    }
    
    public List<MonitoredResourceDescriptor> getMonitoredResourcesList() {
      return Collections.unmodifiableList(((Service)this.instance).getMonitoredResourcesList());
    }
    
    public Monitoring getMonitoring() {
      return ((Service)this.instance).getMonitoring();
    }
    
    public String getName() {
      return ((Service)this.instance).getName();
    }
    
    public ByteString getNameBytes() {
      return ((Service)this.instance).getNameBytes();
    }
    
    public String getProducerProjectId() {
      return ((Service)this.instance).getProducerProjectId();
    }
    
    public ByteString getProducerProjectIdBytes() {
      return ((Service)this.instance).getProducerProjectIdBytes();
    }
    
    public Quota getQuota() {
      return ((Service)this.instance).getQuota();
    }
    
    public SourceInfo getSourceInfo() {
      return ((Service)this.instance).getSourceInfo();
    }
    
    public SystemParameters getSystemParameters() {
      return ((Service)this.instance).getSystemParameters();
    }
    
    public String getTitle() {
      return ((Service)this.instance).getTitle();
    }
    
    public ByteString getTitleBytes() {
      return ((Service)this.instance).getTitleBytes();
    }
    
    public Type getTypes(int param1Int) {
      return ((Service)this.instance).getTypes(param1Int);
    }
    
    public int getTypesCount() {
      return ((Service)this.instance).getTypesCount();
    }
    
    public List<Type> getTypesList() {
      return Collections.unmodifiableList(((Service)this.instance).getTypesList());
    }
    
    public Usage getUsage() {
      return ((Service)this.instance).getUsage();
    }
    
    public boolean hasAuthentication() {
      return ((Service)this.instance).hasAuthentication();
    }
    
    public boolean hasBackend() {
      return ((Service)this.instance).hasBackend();
    }
    
    public boolean hasBilling() {
      return ((Service)this.instance).hasBilling();
    }
    
    public boolean hasConfigVersion() {
      return ((Service)this.instance).hasConfigVersion();
    }
    
    public boolean hasContext() {
      return ((Service)this.instance).hasContext();
    }
    
    public boolean hasControl() {
      return ((Service)this.instance).hasControl();
    }
    
    public boolean hasDocumentation() {
      return ((Service)this.instance).hasDocumentation();
    }
    
    public boolean hasExperimental() {
      return ((Service)this.instance).hasExperimental();
    }
    
    public boolean hasHttp() {
      return ((Service)this.instance).hasHttp();
    }
    
    public boolean hasLogging() {
      return ((Service)this.instance).hasLogging();
    }
    
    public boolean hasMonitoring() {
      return ((Service)this.instance).hasMonitoring();
    }
    
    public boolean hasQuota() {
      return ((Service)this.instance).hasQuota();
    }
    
    public boolean hasSourceInfo() {
      return ((Service)this.instance).hasSourceInfo();
    }
    
    public boolean hasSystemParameters() {
      return ((Service)this.instance).hasSystemParameters();
    }
    
    public boolean hasUsage() {
      return ((Service)this.instance).hasUsage();
    }
    
    public Builder mergeAuthentication(Authentication param1Authentication) {
      copyOnWrite();
      ((Service)this.instance).mergeAuthentication(param1Authentication);
      return this;
    }
    
    public Builder mergeBackend(Backend param1Backend) {
      copyOnWrite();
      ((Service)this.instance).mergeBackend(param1Backend);
      return this;
    }
    
    public Builder mergeBilling(Billing param1Billing) {
      copyOnWrite();
      ((Service)this.instance).mergeBilling(param1Billing);
      return this;
    }
    
    public Builder mergeConfigVersion(UInt32Value param1UInt32Value) {
      copyOnWrite();
      ((Service)this.instance).mergeConfigVersion(param1UInt32Value);
      return this;
    }
    
    public Builder mergeContext(Context param1Context) {
      copyOnWrite();
      ((Service)this.instance).mergeContext(param1Context);
      return this;
    }
    
    public Builder mergeControl(Control param1Control) {
      copyOnWrite();
      ((Service)this.instance).mergeControl(param1Control);
      return this;
    }
    
    public Builder mergeDocumentation(Documentation param1Documentation) {
      copyOnWrite();
      ((Service)this.instance).mergeDocumentation(param1Documentation);
      return this;
    }
    
    public Builder mergeExperimental(Experimental param1Experimental) {
      copyOnWrite();
      ((Service)this.instance).mergeExperimental(param1Experimental);
      return this;
    }
    
    public Builder mergeHttp(Http param1Http) {
      copyOnWrite();
      ((Service)this.instance).mergeHttp(param1Http);
      return this;
    }
    
    public Builder mergeLogging(Logging param1Logging) {
      copyOnWrite();
      ((Service)this.instance).mergeLogging(param1Logging);
      return this;
    }
    
    public Builder mergeMonitoring(Monitoring param1Monitoring) {
      copyOnWrite();
      ((Service)this.instance).mergeMonitoring(param1Monitoring);
      return this;
    }
    
    public Builder mergeQuota(Quota param1Quota) {
      copyOnWrite();
      ((Service)this.instance).mergeQuota(param1Quota);
      return this;
    }
    
    public Builder mergeSourceInfo(SourceInfo param1SourceInfo) {
      copyOnWrite();
      ((Service)this.instance).mergeSourceInfo(param1SourceInfo);
      return this;
    }
    
    public Builder mergeSystemParameters(SystemParameters param1SystemParameters) {
      copyOnWrite();
      ((Service)this.instance).mergeSystemParameters(param1SystemParameters);
      return this;
    }
    
    public Builder mergeUsage(Usage param1Usage) {
      copyOnWrite();
      ((Service)this.instance).mergeUsage(param1Usage);
      return this;
    }
    
    public Builder removeApis(int param1Int) {
      copyOnWrite();
      ((Service)this.instance).removeApis(param1Int);
      return this;
    }
    
    public Builder removeEndpoints(int param1Int) {
      copyOnWrite();
      ((Service)this.instance).removeEndpoints(param1Int);
      return this;
    }
    
    public Builder removeEnums(int param1Int) {
      copyOnWrite();
      ((Service)this.instance).removeEnums(param1Int);
      return this;
    }
    
    public Builder removeLogs(int param1Int) {
      copyOnWrite();
      ((Service)this.instance).removeLogs(param1Int);
      return this;
    }
    
    public Builder removeMetrics(int param1Int) {
      copyOnWrite();
      ((Service)this.instance).removeMetrics(param1Int);
      return this;
    }
    
    public Builder removeMonitoredResources(int param1Int) {
      copyOnWrite();
      ((Service)this.instance).removeMonitoredResources(param1Int);
      return this;
    }
    
    public Builder removeTypes(int param1Int) {
      copyOnWrite();
      ((Service)this.instance).removeTypes(param1Int);
      return this;
    }
    
    public Builder setApis(int param1Int, Api.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).setApis(param1Int, param1Builder);
      return this;
    }
    
    public Builder setApis(int param1Int, Api param1Api) {
      copyOnWrite();
      ((Service)this.instance).setApis(param1Int, param1Api);
      return this;
    }
    
    public Builder setAuthentication(Authentication.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).setAuthentication(param1Builder);
      return this;
    }
    
    public Builder setAuthentication(Authentication param1Authentication) {
      copyOnWrite();
      ((Service)this.instance).setAuthentication(param1Authentication);
      return this;
    }
    
    public Builder setBackend(Backend.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).setBackend(param1Builder);
      return this;
    }
    
    public Builder setBackend(Backend param1Backend) {
      copyOnWrite();
      ((Service)this.instance).setBackend(param1Backend);
      return this;
    }
    
    public Builder setBilling(Billing.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).setBilling(param1Builder);
      return this;
    }
    
    public Builder setBilling(Billing param1Billing) {
      copyOnWrite();
      ((Service)this.instance).setBilling(param1Billing);
      return this;
    }
    
    public Builder setConfigVersion(UInt32Value.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).setConfigVersion(param1Builder);
      return this;
    }
    
    public Builder setConfigVersion(UInt32Value param1UInt32Value) {
      copyOnWrite();
      ((Service)this.instance).setConfigVersion(param1UInt32Value);
      return this;
    }
    
    public Builder setContext(Context.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).setContext(param1Builder);
      return this;
    }
    
    public Builder setContext(Context param1Context) {
      copyOnWrite();
      ((Service)this.instance).setContext(param1Context);
      return this;
    }
    
    public Builder setControl(Control.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).setControl(param1Builder);
      return this;
    }
    
    public Builder setControl(Control param1Control) {
      copyOnWrite();
      ((Service)this.instance).setControl(param1Control);
      return this;
    }
    
    public Builder setDocumentation(Documentation.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).setDocumentation(param1Builder);
      return this;
    }
    
    public Builder setDocumentation(Documentation param1Documentation) {
      copyOnWrite();
      ((Service)this.instance).setDocumentation(param1Documentation);
      return this;
    }
    
    public Builder setEndpoints(int param1Int, Endpoint.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).setEndpoints(param1Int, param1Builder);
      return this;
    }
    
    public Builder setEndpoints(int param1Int, Endpoint param1Endpoint) {
      copyOnWrite();
      ((Service)this.instance).setEndpoints(param1Int, param1Endpoint);
      return this;
    }
    
    public Builder setEnums(int param1Int, Enum.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).setEnums(param1Int, param1Builder);
      return this;
    }
    
    public Builder setEnums(int param1Int, Enum param1Enum) {
      copyOnWrite();
      ((Service)this.instance).setEnums(param1Int, param1Enum);
      return this;
    }
    
    public Builder setExperimental(Experimental.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).setExperimental(param1Builder);
      return this;
    }
    
    public Builder setExperimental(Experimental param1Experimental) {
      copyOnWrite();
      ((Service)this.instance).setExperimental(param1Experimental);
      return this;
    }
    
    public Builder setHttp(Http.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).setHttp(param1Builder);
      return this;
    }
    
    public Builder setHttp(Http param1Http) {
      copyOnWrite();
      ((Service)this.instance).setHttp(param1Http);
      return this;
    }
    
    public Builder setId(String param1String) {
      copyOnWrite();
      ((Service)this.instance).setId(param1String);
      return this;
    }
    
    public Builder setIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Service)this.instance).setIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setLogging(Logging.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).setLogging(param1Builder);
      return this;
    }
    
    public Builder setLogging(Logging param1Logging) {
      copyOnWrite();
      ((Service)this.instance).setLogging(param1Logging);
      return this;
    }
    
    public Builder setLogs(int param1Int, LogDescriptor.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).setLogs(param1Int, param1Builder);
      return this;
    }
    
    public Builder setLogs(int param1Int, LogDescriptor param1LogDescriptor) {
      copyOnWrite();
      ((Service)this.instance).setLogs(param1Int, param1LogDescriptor);
      return this;
    }
    
    public Builder setMetrics(int param1Int, MetricDescriptor.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).setMetrics(param1Int, param1Builder);
      return this;
    }
    
    public Builder setMetrics(int param1Int, MetricDescriptor param1MetricDescriptor) {
      copyOnWrite();
      ((Service)this.instance).setMetrics(param1Int, param1MetricDescriptor);
      return this;
    }
    
    public Builder setMonitoredResources(int param1Int, MonitoredResourceDescriptor.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).setMonitoredResources(param1Int, param1Builder);
      return this;
    }
    
    public Builder setMonitoredResources(int param1Int, MonitoredResourceDescriptor param1MonitoredResourceDescriptor) {
      copyOnWrite();
      ((Service)this.instance).setMonitoredResources(param1Int, param1MonitoredResourceDescriptor);
      return this;
    }
    
    public Builder setMonitoring(Monitoring.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).setMonitoring(param1Builder);
      return this;
    }
    
    public Builder setMonitoring(Monitoring param1Monitoring) {
      copyOnWrite();
      ((Service)this.instance).setMonitoring(param1Monitoring);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      ((Service)this.instance).setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Service)this.instance).setNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setProducerProjectId(String param1String) {
      copyOnWrite();
      ((Service)this.instance).setProducerProjectId(param1String);
      return this;
    }
    
    public Builder setProducerProjectIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Service)this.instance).setProducerProjectIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setQuota(Quota.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).setQuota(param1Builder);
      return this;
    }
    
    public Builder setQuota(Quota param1Quota) {
      copyOnWrite();
      ((Service)this.instance).setQuota(param1Quota);
      return this;
    }
    
    public Builder setSourceInfo(SourceInfo.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).setSourceInfo(param1Builder);
      return this;
    }
    
    public Builder setSourceInfo(SourceInfo param1SourceInfo) {
      copyOnWrite();
      ((Service)this.instance).setSourceInfo(param1SourceInfo);
      return this;
    }
    
    public Builder setSystemParameters(SystemParameters.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).setSystemParameters(param1Builder);
      return this;
    }
    
    public Builder setSystemParameters(SystemParameters param1SystemParameters) {
      copyOnWrite();
      ((Service)this.instance).setSystemParameters(param1SystemParameters);
      return this;
    }
    
    public Builder setTitle(String param1String) {
      copyOnWrite();
      ((Service)this.instance).setTitle(param1String);
      return this;
    }
    
    public Builder setTitleBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Service)this.instance).setTitleBytes(param1ByteString);
      return this;
    }
    
    public Builder setTypes(int param1Int, Type.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).setTypes(param1Int, param1Builder);
      return this;
    }
    
    public Builder setTypes(int param1Int, Type param1Type) {
      copyOnWrite();
      ((Service)this.instance).setTypes(param1Int, param1Type);
      return this;
    }
    
    public Builder setUsage(Usage.Builder param1Builder) {
      copyOnWrite();
      ((Service)this.instance).setUsage(param1Builder);
      return this;
    }
    
    public Builder setUsage(Usage param1Usage) {
      copyOnWrite();
      ((Service)this.instance).setUsage(param1Usage);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\Service.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */