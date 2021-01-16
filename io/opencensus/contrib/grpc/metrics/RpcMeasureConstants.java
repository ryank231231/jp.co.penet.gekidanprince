package io.opencensus.contrib.grpc.metrics;

import io.opencensus.stats.Measure;
import io.opencensus.tags.TagKey;

public final class RpcMeasureConstants {
  private static final String BYTE = "By";
  
  private static final String COUNT = "1";
  
  private static final String MILLISECOND = "ms";
  
  public static final Measure.MeasureLong RPC_CLIENT_ERROR_COUNT;
  
  public static final Measure.MeasureLong RPC_CLIENT_FINISHED_COUNT;
  
  public static final Measure.MeasureDouble RPC_CLIENT_REQUEST_BYTES;
  
  public static final Measure.MeasureLong RPC_CLIENT_REQUEST_COUNT;
  
  public static final Measure.MeasureDouble RPC_CLIENT_RESPONSE_BYTES;
  
  public static final Measure.MeasureLong RPC_CLIENT_RESPONSE_COUNT;
  
  public static final Measure.MeasureDouble RPC_CLIENT_ROUNDTRIP_LATENCY;
  
  public static final Measure.MeasureDouble RPC_CLIENT_SERVER_ELAPSED_TIME;
  
  public static final Measure.MeasureLong RPC_CLIENT_STARTED_COUNT;
  
  public static final Measure.MeasureDouble RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES;
  
  public static final Measure.MeasureDouble RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES;
  
  public static final TagKey RPC_METHOD;
  
  public static final Measure.MeasureLong RPC_SERVER_ERROR_COUNT;
  
  public static final Measure.MeasureLong RPC_SERVER_FINISHED_COUNT;
  
  public static final Measure.MeasureDouble RPC_SERVER_REQUEST_BYTES;
  
  public static final Measure.MeasureLong RPC_SERVER_REQUEST_COUNT;
  
  public static final Measure.MeasureDouble RPC_SERVER_RESPONSE_BYTES;
  
  public static final Measure.MeasureLong RPC_SERVER_RESPONSE_COUNT;
  
  public static final Measure.MeasureDouble RPC_SERVER_SERVER_ELAPSED_TIME;
  
  public static final Measure.MeasureDouble RPC_SERVER_SERVER_LATENCY;
  
  public static final Measure.MeasureLong RPC_SERVER_STARTED_COUNT;
  
  public static final Measure.MeasureDouble RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES;
  
  public static final Measure.MeasureDouble RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES;
  
  public static final TagKey RPC_STATUS = TagKey.create("canonical_status");
  
  static {
    RPC_METHOD = TagKey.create("method");
    RPC_CLIENT_ERROR_COUNT = Measure.MeasureLong.create("grpc.io/client/error_count", "RPC Errors", "1");
    RPC_CLIENT_REQUEST_BYTES = Measure.MeasureDouble.create("grpc.io/client/request_bytes", "Request bytes", "By");
    RPC_CLIENT_RESPONSE_BYTES = Measure.MeasureDouble.create("grpc.io/client/response_bytes", "Response bytes", "By");
    RPC_CLIENT_ROUNDTRIP_LATENCY = Measure.MeasureDouble.create("grpc.io/client/roundtrip_latency", "RPC roundtrip latency msec", "ms");
    RPC_CLIENT_SERVER_ELAPSED_TIME = Measure.MeasureDouble.create("grpc.io/client/server_elapsed_time", "Server elapsed time in msecs", "ms");
    RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES = Measure.MeasureDouble.create("grpc.io/client/uncompressed_request_bytes", "Uncompressed Request bytes", "By");
    RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES = Measure.MeasureDouble.create("grpc.io/client/uncompressed_response_bytes", "Uncompressed Response bytes", "By");
    RPC_CLIENT_STARTED_COUNT = Measure.MeasureLong.create("grpc.io/client/started_count", "Number of client RPCs (streams) started", "1");
    RPC_CLIENT_FINISHED_COUNT = Measure.MeasureLong.create("grpc.io/client/finished_count", "Number of client RPCs (streams) finished", "1");
    RPC_CLIENT_REQUEST_COUNT = Measure.MeasureLong.create("grpc.io/client/request_count", "Number of client RPC request messages", "1");
    RPC_CLIENT_RESPONSE_COUNT = Measure.MeasureLong.create("grpc.io/client/response_count", "Number of client RPC response messages", "1");
    RPC_SERVER_ERROR_COUNT = Measure.MeasureLong.create("grpc.io/server/error_count", "RPC Errors", "1");
    RPC_SERVER_REQUEST_BYTES = Measure.MeasureDouble.create("grpc.io/server/request_bytes", "Request bytes", "By");
    RPC_SERVER_RESPONSE_BYTES = Measure.MeasureDouble.create("grpc.io/server/response_bytes", "Response bytes", "By");
    RPC_SERVER_SERVER_ELAPSED_TIME = Measure.MeasureDouble.create("grpc.io/server/server_elapsed_time", "Server elapsed time in msecs", "ms");
    RPC_SERVER_SERVER_LATENCY = Measure.MeasureDouble.create("grpc.io/server/server_latency", "Latency in msecs", "ms");
    RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES = Measure.MeasureDouble.create("grpc.io/server/uncompressed_request_bytes", "Uncompressed Request bytes", "By");
    RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES = Measure.MeasureDouble.create("grpc.io/server/uncompressed_response_bytes", "Uncompressed Response bytes", "By");
    RPC_SERVER_STARTED_COUNT = Measure.MeasureLong.create("grpc.io/server/started_count", "Number of server RPCs (streams) started", "1");
    RPC_SERVER_FINISHED_COUNT = Measure.MeasureLong.create("grpc.io/server/finished_count", "Number of server RPCs (streams) finished", "1");
    RPC_SERVER_REQUEST_COUNT = Measure.MeasureLong.create("grpc.io/server/request_count", "Number of server RPC request messages", "1");
    RPC_SERVER_RESPONSE_COUNT = Measure.MeasureLong.create("grpc.io/server/response_count", "Number of server RPC response messages", "1");
  }
  
  RpcMeasureConstants() {
    throw new AssertionError();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\contrib\grpc\metrics\RpcMeasureConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */