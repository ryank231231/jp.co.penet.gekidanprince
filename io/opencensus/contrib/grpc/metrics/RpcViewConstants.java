package io.opencensus.contrib.grpc.metrics;

import com.google.common.annotations.VisibleForTesting;
import io.opencensus.common.Duration;
import io.opencensus.stats.Aggregation;
import io.opencensus.stats.BucketBoundaries;
import io.opencensus.stats.Measure;
import io.opencensus.stats.View;
import io.opencensus.tags.TagKey;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class RpcViewConstants {
  @VisibleForTesting
  static final Aggregation AGGREGATION_WITH_BYTES_HISTOGRAM;
  
  @VisibleForTesting
  static final Aggregation AGGREGATION_WITH_COUNT_HISTOGRAM;
  
  @VisibleForTesting
  static final Aggregation AGGREGATION_WITH_MILLIS_HISTOGRAM;
  
  @VisibleForTesting
  static final View.AggregationWindow CUMULATIVE;
  
  @VisibleForTesting
  static final Duration HOUR;
  
  @VisibleForTesting
  static final View.AggregationWindow INTERVAL_HOUR;
  
  @VisibleForTesting
  static final View.AggregationWindow INTERVAL_MINUTE;
  
  @VisibleForTesting
  static final Aggregation MEAN;
  
  @VisibleForTesting
  static final Duration MINUTE;
  
  @VisibleForTesting
  static final List<Double> RPC_BYTES_BUCKET_BOUNDARIES = Collections.unmodifiableList(Arrays.asList(new Double[] { 
          Double.valueOf(0.0D), Double.valueOf(1024.0D), Double.valueOf(2048.0D), Double.valueOf(4096.0D), Double.valueOf(16384.0D), Double.valueOf(65536.0D), Double.valueOf(262144.0D), Double.valueOf(1048576.0D), Double.valueOf(4194304.0D), Double.valueOf(1.6777216E7D), 
          Double.valueOf(6.7108864E7D), Double.valueOf(2.68435456E8D), Double.valueOf(1.073741824E9D), Double.valueOf(4.294967296E9D) }));
  
  public static final View RPC_CLIENT_ERROR_COUNT_HOUR_VIEW;
  
  public static final View RPC_CLIENT_ERROR_COUNT_MINUTE_VIEW;
  
  public static final View RPC_CLIENT_ERROR_COUNT_VIEW;
  
  public static final View RPC_CLIENT_FINISHED_COUNT_HOUR_VIEW;
  
  public static final View RPC_CLIENT_FINISHED_COUNT_MINUTE_VIEW;
  
  public static final View RPC_CLIENT_REQUEST_BYTES_HOUR_VIEW;
  
  public static final View RPC_CLIENT_REQUEST_BYTES_MINUTE_VIEW;
  
  public static final View RPC_CLIENT_REQUEST_BYTES_VIEW;
  
  public static final View RPC_CLIENT_REQUEST_COUNT_HOUR_VIEW;
  
  public static final View RPC_CLIENT_REQUEST_COUNT_MINUTE_VIEW;
  
  public static final View RPC_CLIENT_REQUEST_COUNT_VIEW;
  
  public static final View RPC_CLIENT_RESPONSE_BYTES_HOUR_VIEW;
  
  public static final View RPC_CLIENT_RESPONSE_BYTES_MINUTE_VIEW;
  
  public static final View RPC_CLIENT_RESPONSE_BYTES_VIEW;
  
  public static final View RPC_CLIENT_RESPONSE_COUNT_HOUR_VIEW;
  
  public static final View RPC_CLIENT_RESPONSE_COUNT_MINUTE_VIEW;
  
  public static final View RPC_CLIENT_RESPONSE_COUNT_VIEW;
  
  public static final View RPC_CLIENT_ROUNDTRIP_LATENCY_HOUR_VIEW;
  
  public static final View RPC_CLIENT_ROUNDTRIP_LATENCY_MINUTE_VIEW;
  
  public static final View RPC_CLIENT_ROUNDTRIP_LATENCY_VIEW;
  
  public static final View RPC_CLIENT_SERVER_ELAPSED_TIME_HOUR_VIEW;
  
  public static final View RPC_CLIENT_SERVER_ELAPSED_TIME_MINUTE_VIEW;
  
  public static final View RPC_CLIENT_SERVER_ELAPSED_TIME_VIEW;
  
  public static final View RPC_CLIENT_STARTED_COUNT_HOUR_VIEW;
  
  public static final View RPC_CLIENT_STARTED_COUNT_MINUTE_VIEW;
  
  public static final View RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES_HOUR_VIEW;
  
  public static final View RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES_MINUTE_VIEW;
  
  public static final View RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES_VIEW;
  
  public static final View RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES_HOUR_VIEW;
  
  public static final View RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES_MINUTE_VIEW;
  
  public static final View RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES_VIEW;
  
  @VisibleForTesting
  static final List<Double> RPC_COUNT_BUCKET_BOUNDARIES;
  
  @VisibleForTesting
  static final List<Double> RPC_MILLIS_BUCKET_BOUNDARIES = Collections.unmodifiableList(Arrays.asList(new Double[] { 
          Double.valueOf(0.0D), Double.valueOf(1.0D), Double.valueOf(2.0D), Double.valueOf(3.0D), Double.valueOf(4.0D), Double.valueOf(5.0D), Double.valueOf(6.0D), Double.valueOf(8.0D), Double.valueOf(10.0D), Double.valueOf(13.0D), 
          Double.valueOf(16.0D), Double.valueOf(20.0D), Double.valueOf(25.0D), Double.valueOf(30.0D), Double.valueOf(40.0D), Double.valueOf(50.0D), Double.valueOf(65.0D), Double.valueOf(80.0D), Double.valueOf(100.0D), Double.valueOf(130.0D), 
          Double.valueOf(160.0D), Double.valueOf(200.0D), Double.valueOf(250.0D), Double.valueOf(300.0D), Double.valueOf(400.0D), Double.valueOf(500.0D), Double.valueOf(650.0D), Double.valueOf(800.0D), Double.valueOf(1000.0D), Double.valueOf(2000.0D), 
          Double.valueOf(5000.0D), Double.valueOf(10000.0D), Double.valueOf(20000.0D), Double.valueOf(50000.0D), Double.valueOf(100000.0D) }));
  
  public static final View RPC_SERVER_ERROR_COUNT_HOUR_VIEW;
  
  public static final View RPC_SERVER_ERROR_COUNT_MINUTE_VIEW;
  
  public static final View RPC_SERVER_ERROR_COUNT_VIEW;
  
  public static final View RPC_SERVER_FINISHED_COUNT_HOUR_VIEW;
  
  public static final View RPC_SERVER_FINISHED_COUNT_MINUTE_VIEW;
  
  public static final View RPC_SERVER_REQUEST_BYTES_HOUR_VIEW;
  
  public static final View RPC_SERVER_REQUEST_BYTES_MINUTE_VIEW;
  
  public static final View RPC_SERVER_REQUEST_BYTES_VIEW;
  
  public static final View RPC_SERVER_REQUEST_COUNT_HOUR_VIEW;
  
  public static final View RPC_SERVER_REQUEST_COUNT_MINUTE_VIEW;
  
  public static final View RPC_SERVER_REQUEST_COUNT_VIEW;
  
  public static final View RPC_SERVER_RESPONSE_BYTES_HOUR_VIEW;
  
  public static final View RPC_SERVER_RESPONSE_BYTES_MINUTE_VIEW;
  
  public static final View RPC_SERVER_RESPONSE_BYTES_VIEW;
  
  public static final View RPC_SERVER_RESPONSE_COUNT_HOUR_VIEW;
  
  public static final View RPC_SERVER_RESPONSE_COUNT_MINUTE_VIEW;
  
  public static final View RPC_SERVER_RESPONSE_COUNT_VIEW;
  
  public static final View RPC_SERVER_SERVER_ELAPSED_TIME_HOUR_VIEW;
  
  public static final View RPC_SERVER_SERVER_ELAPSED_TIME_MINUTE_VIEW;
  
  public static final View RPC_SERVER_SERVER_ELAPSED_TIME_VIEW;
  
  public static final View RPC_SERVER_SERVER_LATENCY_HOUR_VIEW;
  
  public static final View RPC_SERVER_SERVER_LATENCY_MINUTE_VIEW;
  
  public static final View RPC_SERVER_SERVER_LATENCY_VIEW;
  
  public static final View RPC_SERVER_STARTED_COUNT_HOUR_VIEW;
  
  public static final View RPC_SERVER_STARTED_COUNT_MINUTE_VIEW;
  
  public static final View RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES_HOUR_VIEW;
  
  public static final View RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES_MINUTE_VIEW;
  
  public static final View RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES_VIEW;
  
  public static final View RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES_HOUR_VIEW;
  
  public static final View RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES_MINUTE_VIEW;
  
  public static final View RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES_VIEW;
  
  static {
    RPC_COUNT_BUCKET_BOUNDARIES = Collections.unmodifiableList(Arrays.asList(new Double[] { 
            Double.valueOf(0.0D), Double.valueOf(1.0D), Double.valueOf(2.0D), Double.valueOf(4.0D), Double.valueOf(8.0D), Double.valueOf(16.0D), Double.valueOf(32.0D), Double.valueOf(64.0D), Double.valueOf(128.0D), Double.valueOf(256.0D), 
            Double.valueOf(512.0D), Double.valueOf(1024.0D), Double.valueOf(2048.0D), Double.valueOf(4096.0D), Double.valueOf(8192.0D), Double.valueOf(16384.0D), Double.valueOf(32768.0D), Double.valueOf(65536.0D) }));
    MEAN = (Aggregation)Aggregation.Mean.create();
    AGGREGATION_WITH_BYTES_HISTOGRAM = (Aggregation)Aggregation.Distribution.create(BucketBoundaries.create(RPC_BYTES_BUCKET_BOUNDARIES));
    AGGREGATION_WITH_MILLIS_HISTOGRAM = (Aggregation)Aggregation.Distribution.create(BucketBoundaries.create(RPC_MILLIS_BUCKET_BOUNDARIES));
    AGGREGATION_WITH_COUNT_HISTOGRAM = (Aggregation)Aggregation.Distribution.create(BucketBoundaries.create(RPC_COUNT_BUCKET_BOUNDARIES));
    MINUTE = Duration.create(60L, 0);
    HOUR = Duration.create(3600L, 0);
    CUMULATIVE = (View.AggregationWindow)View.AggregationWindow.Cumulative.create();
    INTERVAL_MINUTE = (View.AggregationWindow)View.AggregationWindow.Interval.create(MINUTE);
    INTERVAL_HOUR = (View.AggregationWindow)View.AggregationWindow.Interval.create(HOUR);
    RPC_CLIENT_ERROR_COUNT_VIEW = View.create(View.Name.create("grpc.io/client/error_count/cumulative"), "RPC Errors", (Measure)RpcMeasureConstants.RPC_CLIENT_ERROR_COUNT, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_STATUS, RpcMeasureConstants.RPC_METHOD }, ), CUMULATIVE);
    RPC_CLIENT_ROUNDTRIP_LATENCY_VIEW = View.create(View.Name.create("grpc.io/client/roundtrip_latency/cumulative"), "Latency in msecs", (Measure)RpcMeasureConstants.RPC_CLIENT_ROUNDTRIP_LATENCY, AGGREGATION_WITH_MILLIS_HISTOGRAM, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), CUMULATIVE);
    RPC_CLIENT_SERVER_ELAPSED_TIME_VIEW = View.create(View.Name.create("grpc.io/client/server_elapsed_time/cumulative"), "Server elapsed time in msecs", (Measure)RpcMeasureConstants.RPC_CLIENT_SERVER_ELAPSED_TIME, AGGREGATION_WITH_MILLIS_HISTOGRAM, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), CUMULATIVE);
    RPC_CLIENT_REQUEST_BYTES_VIEW = View.create(View.Name.create("grpc.io/client/request_bytes/cumulative"), "Request bytes", (Measure)RpcMeasureConstants.RPC_CLIENT_REQUEST_BYTES, AGGREGATION_WITH_BYTES_HISTOGRAM, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), CUMULATIVE);
    RPC_CLIENT_RESPONSE_BYTES_VIEW = View.create(View.Name.create("grpc.io/client/response_bytes/cumulative"), "Response bytes", (Measure)RpcMeasureConstants.RPC_CLIENT_RESPONSE_BYTES, AGGREGATION_WITH_BYTES_HISTOGRAM, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), CUMULATIVE);
    RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES_VIEW = View.create(View.Name.create("grpc.io/client/uncompressed_request_bytes/cumulative"), "Uncompressed Request bytes", (Measure)RpcMeasureConstants.RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES, AGGREGATION_WITH_BYTES_HISTOGRAM, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), CUMULATIVE);
    RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES_VIEW = View.create(View.Name.create("grpc.io/client/uncompressed_response_bytes/cumulative"), "Uncompressed Response bytes", (Measure)RpcMeasureConstants.RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES, AGGREGATION_WITH_BYTES_HISTOGRAM, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), CUMULATIVE);
    RPC_CLIENT_REQUEST_COUNT_VIEW = View.create(View.Name.create("grpc.io/client/request_count/cumulative"), "Count of request messages per client RPC", (Measure)RpcMeasureConstants.RPC_CLIENT_REQUEST_COUNT, AGGREGATION_WITH_COUNT_HISTOGRAM, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), CUMULATIVE);
    RPC_CLIENT_RESPONSE_COUNT_VIEW = View.create(View.Name.create("grpc.io/client/response_count/cumulative"), "Count of response messages per client RPC", (Measure)RpcMeasureConstants.RPC_CLIENT_RESPONSE_COUNT, AGGREGATION_WITH_COUNT_HISTOGRAM, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), CUMULATIVE);
    RPC_SERVER_ERROR_COUNT_VIEW = View.create(View.Name.create("grpc.io/server/error_count/cumulative"), "RPC Errors", (Measure)RpcMeasureConstants.RPC_SERVER_ERROR_COUNT, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_STATUS, RpcMeasureConstants.RPC_METHOD }, ), CUMULATIVE);
    RPC_SERVER_SERVER_LATENCY_VIEW = View.create(View.Name.create("grpc.io/server/server_latency/cumulative"), "Latency in msecs", (Measure)RpcMeasureConstants.RPC_SERVER_SERVER_LATENCY, AGGREGATION_WITH_MILLIS_HISTOGRAM, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), CUMULATIVE);
    RPC_SERVER_SERVER_ELAPSED_TIME_VIEW = View.create(View.Name.create("grpc.io/server/elapsed_time/cumulative"), "Server elapsed time in msecs", (Measure)RpcMeasureConstants.RPC_SERVER_SERVER_ELAPSED_TIME, AGGREGATION_WITH_MILLIS_HISTOGRAM, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), CUMULATIVE);
    RPC_SERVER_REQUEST_BYTES_VIEW = View.create(View.Name.create("grpc.io/server/request_bytes/cumulative"), "Request bytes", (Measure)RpcMeasureConstants.RPC_SERVER_REQUEST_BYTES, AGGREGATION_WITH_BYTES_HISTOGRAM, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), CUMULATIVE);
    RPC_SERVER_RESPONSE_BYTES_VIEW = View.create(View.Name.create("grpc.io/server/response_bytes/cumulative"), "Response bytes", (Measure)RpcMeasureConstants.RPC_SERVER_RESPONSE_BYTES, AGGREGATION_WITH_BYTES_HISTOGRAM, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), CUMULATIVE);
    RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES_VIEW = View.create(View.Name.create("grpc.io/server/uncompressed_request_bytes/cumulative"), "Uncompressed Request bytes", (Measure)RpcMeasureConstants.RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES, AGGREGATION_WITH_BYTES_HISTOGRAM, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), CUMULATIVE);
    RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES_VIEW = View.create(View.Name.create("grpc.io/server/uncompressed_response_bytes/cumulative"), "Uncompressed Response bytes", (Measure)RpcMeasureConstants.RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES, AGGREGATION_WITH_BYTES_HISTOGRAM, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), CUMULATIVE);
    RPC_SERVER_REQUEST_COUNT_VIEW = View.create(View.Name.create("grpc.io/server/request_count/cumulative"), "Count of request messages per server RPC", (Measure)RpcMeasureConstants.RPC_SERVER_REQUEST_COUNT, AGGREGATION_WITH_COUNT_HISTOGRAM, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), CUMULATIVE);
    RPC_SERVER_RESPONSE_COUNT_VIEW = View.create(View.Name.create("grpc.io/server/response_count/cumulative"), "Count of response messages per server RPC", (Measure)RpcMeasureConstants.RPC_SERVER_RESPONSE_COUNT, AGGREGATION_WITH_COUNT_HISTOGRAM, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), CUMULATIVE);
    RPC_CLIENT_ROUNDTRIP_LATENCY_MINUTE_VIEW = View.create(View.Name.create("grpc.io/client/roundtrip_latency/minute"), "Minute stats for latency in msecs", (Measure)RpcMeasureConstants.RPC_CLIENT_ROUNDTRIP_LATENCY, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_MINUTE);
    RPC_CLIENT_REQUEST_BYTES_MINUTE_VIEW = View.create(View.Name.create("grpc.io/client/request_bytes/minute"), "Minute stats for request size in bytes", (Measure)RpcMeasureConstants.RPC_CLIENT_REQUEST_BYTES, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_MINUTE);
    RPC_CLIENT_RESPONSE_BYTES_MINUTE_VIEW = View.create(View.Name.create("grpc.io/client/response_bytes/minute"), "Minute stats for response size in bytes", (Measure)RpcMeasureConstants.RPC_CLIENT_RESPONSE_BYTES, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_MINUTE);
    RPC_CLIENT_ERROR_COUNT_MINUTE_VIEW = View.create(View.Name.create("grpc.io/client/error_count/minute"), "Minute stats for rpc errors", (Measure)RpcMeasureConstants.RPC_CLIENT_ERROR_COUNT, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_MINUTE);
    RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES_MINUTE_VIEW = View.create(View.Name.create("grpc.io/client/uncompressed_request_bytes/minute"), "Minute stats for uncompressed request size in bytes", (Measure)RpcMeasureConstants.RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_MINUTE);
    RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES_MINUTE_VIEW = View.create(View.Name.create("grpc.io/client/uncompressed_response_bytes/minute"), "Minute stats for uncompressed response size in bytes", (Measure)RpcMeasureConstants.RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_MINUTE);
    RPC_CLIENT_SERVER_ELAPSED_TIME_MINUTE_VIEW = View.create(View.Name.create("grpc.io/client/server_elapsed_time/minute"), "Minute stats for server elapsed time in msecs", (Measure)RpcMeasureConstants.RPC_CLIENT_SERVER_ELAPSED_TIME, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_MINUTE);
    RPC_CLIENT_STARTED_COUNT_MINUTE_VIEW = View.create(View.Name.create("grpc.io/client/started_count/minute"), "Minute stats on the number of client RPCs started", (Measure)RpcMeasureConstants.RPC_CLIENT_STARTED_COUNT, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_MINUTE);
    RPC_CLIENT_FINISHED_COUNT_MINUTE_VIEW = View.create(View.Name.create("grpc.io/client/finished_count/minute"), "Minute stats on the number of client RPCs finished", (Measure)RpcMeasureConstants.RPC_CLIENT_FINISHED_COUNT, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_MINUTE);
    RPC_CLIENT_REQUEST_COUNT_MINUTE_VIEW = View.create(View.Name.create("grpc.io/client/request_count/minute"), "Minute stats on the count of request messages per client RPC", (Measure)RpcMeasureConstants.RPC_CLIENT_REQUEST_COUNT, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_MINUTE);
    RPC_CLIENT_RESPONSE_COUNT_MINUTE_VIEW = View.create(View.Name.create("grpc.io/client/response_count/minute"), "Minute stats on the count of response messages per client RPC", (Measure)RpcMeasureConstants.RPC_CLIENT_RESPONSE_COUNT, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_MINUTE);
    RPC_CLIENT_ROUNDTRIP_LATENCY_HOUR_VIEW = View.create(View.Name.create("grpc.io/client/roundtrip_latency/hour"), "Hour stats for latency in msecs", (Measure)RpcMeasureConstants.RPC_CLIENT_ROUNDTRIP_LATENCY, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_HOUR);
    RPC_CLIENT_REQUEST_BYTES_HOUR_VIEW = View.create(View.Name.create("grpc.io/client/request_bytes/hour"), "Hour stats for request size in bytes", (Measure)RpcMeasureConstants.RPC_CLIENT_REQUEST_BYTES, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_HOUR);
    RPC_CLIENT_RESPONSE_BYTES_HOUR_VIEW = View.create(View.Name.create("grpc.io/client/response_bytes/hour"), "Hour stats for response size in bytes", (Measure)RpcMeasureConstants.RPC_CLIENT_RESPONSE_BYTES, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_HOUR);
    RPC_CLIENT_ERROR_COUNT_HOUR_VIEW = View.create(View.Name.create("grpc.io/client/error_count/hour"), "Hour stats for rpc errors", (Measure)RpcMeasureConstants.RPC_CLIENT_ERROR_COUNT, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_HOUR);
    RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES_HOUR_VIEW = View.create(View.Name.create("grpc.io/client/uncompressed_request_bytes/hour"), "Hour stats for uncompressed request size in bytes", (Measure)RpcMeasureConstants.RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_HOUR);
    RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES_HOUR_VIEW = View.create(View.Name.create("grpc.io/client/uncompressed_response_bytes/hour"), "Hour stats for uncompressed response size in bytes", (Measure)RpcMeasureConstants.RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_HOUR);
    RPC_CLIENT_SERVER_ELAPSED_TIME_HOUR_VIEW = View.create(View.Name.create("grpc.io/client/server_elapsed_time/hour"), "Hour stats for server elapsed time in msecs", (Measure)RpcMeasureConstants.RPC_CLIENT_SERVER_ELAPSED_TIME, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_HOUR);
    RPC_CLIENT_STARTED_COUNT_HOUR_VIEW = View.create(View.Name.create("grpc.io/client/started_count/hour"), "Hour stats on the number of client RPCs started", (Measure)RpcMeasureConstants.RPC_CLIENT_STARTED_COUNT, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_HOUR);
    RPC_CLIENT_FINISHED_COUNT_HOUR_VIEW = View.create(View.Name.create("grpc.io/client/finished_count/hour"), "Hour stats on the number of client RPCs finished", (Measure)RpcMeasureConstants.RPC_CLIENT_FINISHED_COUNT, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_HOUR);
    RPC_CLIENT_REQUEST_COUNT_HOUR_VIEW = View.create(View.Name.create("grpc.io/client/request_count/hour"), "Hour stats on the count of request messages per client RPC", (Measure)RpcMeasureConstants.RPC_CLIENT_REQUEST_COUNT, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_HOUR);
    RPC_CLIENT_RESPONSE_COUNT_HOUR_VIEW = View.create(View.Name.create("grpc.io/client/response_count/hour"), "Hour stats on the count of response messages per client RPC", (Measure)RpcMeasureConstants.RPC_CLIENT_RESPONSE_COUNT, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_HOUR);
    RPC_SERVER_SERVER_LATENCY_MINUTE_VIEW = View.create(View.Name.create("grpc.io/server/server_latency/minute"), "Minute stats for server latency in msecs", (Measure)RpcMeasureConstants.RPC_SERVER_SERVER_LATENCY, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_MINUTE);
    RPC_SERVER_REQUEST_BYTES_MINUTE_VIEW = View.create(View.Name.create("grpc.io/server/request_bytes/minute"), "Minute stats for request size in bytes", (Measure)RpcMeasureConstants.RPC_SERVER_REQUEST_BYTES, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_MINUTE);
    RPC_SERVER_RESPONSE_BYTES_MINUTE_VIEW = View.create(View.Name.create("grpc.io/server/response_bytes/minute"), "Minute stats for response size in bytes", (Measure)RpcMeasureConstants.RPC_SERVER_RESPONSE_BYTES, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_MINUTE);
    RPC_SERVER_ERROR_COUNT_MINUTE_VIEW = View.create(View.Name.create("grpc.io/server/error_count/minute"), "Minute stats for rpc errors", (Measure)RpcMeasureConstants.RPC_SERVER_ERROR_COUNT, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_MINUTE);
    RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES_MINUTE_VIEW = View.create(View.Name.create("grpc.io/server/uncompressed_request_bytes/minute"), "Minute stats for uncompressed request size in bytes", (Measure)RpcMeasureConstants.RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_MINUTE);
    RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES_MINUTE_VIEW = View.create(View.Name.create("grpc.io/server/uncompressed_response_bytes/minute"), "Minute stats for uncompressed response size in bytes", (Measure)RpcMeasureConstants.RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_MINUTE);
    RPC_SERVER_SERVER_ELAPSED_TIME_MINUTE_VIEW = View.create(View.Name.create("grpc.io/server/server_elapsed_time/minute"), "Minute stats for server elapsed time in msecs", (Measure)RpcMeasureConstants.RPC_SERVER_SERVER_ELAPSED_TIME, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_MINUTE);
    RPC_SERVER_STARTED_COUNT_MINUTE_VIEW = View.create(View.Name.create("grpc.io/server/started_count/minute"), "Minute stats on the number of server RPCs started", (Measure)RpcMeasureConstants.RPC_SERVER_STARTED_COUNT, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_MINUTE);
    RPC_SERVER_FINISHED_COUNT_MINUTE_VIEW = View.create(View.Name.create("grpc.io/server/finished_count/minute"), "Minute stats on the number of server RPCs finished", (Measure)RpcMeasureConstants.RPC_SERVER_FINISHED_COUNT, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_MINUTE);
    RPC_SERVER_REQUEST_COUNT_MINUTE_VIEW = View.create(View.Name.create("grpc.io/server/request_count/minute"), "Minute stats on the count of request messages per server RPC", (Measure)RpcMeasureConstants.RPC_SERVER_REQUEST_COUNT, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_MINUTE);
    RPC_SERVER_RESPONSE_COUNT_MINUTE_VIEW = View.create(View.Name.create("grpc.io/server/response_count/minute"), "Minute stats on the count of response messages per server RPC", (Measure)RpcMeasureConstants.RPC_SERVER_RESPONSE_COUNT, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_MINUTE);
    RPC_SERVER_SERVER_LATENCY_HOUR_VIEW = View.create(View.Name.create("grpc.io/server/server_latency/hour"), "Hour stats for server latency in msecs", (Measure)RpcMeasureConstants.RPC_SERVER_SERVER_LATENCY, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_HOUR);
    RPC_SERVER_REQUEST_BYTES_HOUR_VIEW = View.create(View.Name.create("grpc.io/server/request_bytes/hour"), "Hour stats for request size in bytes", (Measure)RpcMeasureConstants.RPC_SERVER_REQUEST_BYTES, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_HOUR);
    RPC_SERVER_RESPONSE_BYTES_HOUR_VIEW = View.create(View.Name.create("grpc.io/server/response_bytes/hour"), "Hour stats for response size in bytes", (Measure)RpcMeasureConstants.RPC_SERVER_RESPONSE_BYTES, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_HOUR);
    RPC_SERVER_ERROR_COUNT_HOUR_VIEW = View.create(View.Name.create("grpc.io/server/error_count/hour"), "Hour stats for rpc errors", (Measure)RpcMeasureConstants.RPC_SERVER_ERROR_COUNT, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_HOUR);
    RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES_HOUR_VIEW = View.create(View.Name.create("grpc.io/server/uncompressed_request_bytes/hour"), "Hour stats for uncompressed request size in bytes", (Measure)RpcMeasureConstants.RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_HOUR);
    RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES_HOUR_VIEW = View.create(View.Name.create("grpc.io/server/uncompressed_response_bytes/hour"), "Hour stats for uncompressed response size in bytes", (Measure)RpcMeasureConstants.RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_HOUR);
    RPC_SERVER_SERVER_ELAPSED_TIME_HOUR_VIEW = View.create(View.Name.create("grpc.io/server/server_elapsed_time/hour"), "Hour stats for server elapsed time in msecs", (Measure)RpcMeasureConstants.RPC_SERVER_SERVER_ELAPSED_TIME, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_HOUR);
    RPC_SERVER_STARTED_COUNT_HOUR_VIEW = View.create(View.Name.create("grpc.io/server/started_count/hour"), "Hour stats on the number of server RPCs started", (Measure)RpcMeasureConstants.RPC_SERVER_STARTED_COUNT, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_HOUR);
    RPC_SERVER_FINISHED_COUNT_HOUR_VIEW = View.create(View.Name.create("grpc.io/server/finished_count/hour"), "Hour stats on the number of server RPCs finished", (Measure)RpcMeasureConstants.RPC_SERVER_FINISHED_COUNT, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_HOUR);
    RPC_SERVER_REQUEST_COUNT_HOUR_VIEW = View.create(View.Name.create("grpc.io/server/request_count/hour"), "Hour stats on the count of request messages per server RPC", (Measure)RpcMeasureConstants.RPC_SERVER_REQUEST_COUNT, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_HOUR);
    RPC_SERVER_RESPONSE_COUNT_HOUR_VIEW = View.create(View.Name.create("grpc.io/server/response_count/hour"), "Hour stats on the count of response messages per server RPC", (Measure)RpcMeasureConstants.RPC_SERVER_RESPONSE_COUNT, MEAN, Arrays.asList(new TagKey[] { RpcMeasureConstants.RPC_METHOD }, ), INTERVAL_HOUR);
  }
  
  RpcViewConstants() {
    throw new AssertionError();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\contrib\grpc\metrics\RpcViewConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */