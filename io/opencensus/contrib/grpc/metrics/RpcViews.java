package io.opencensus.contrib.grpc.metrics;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import io.opencensus.stats.Stats;
import io.opencensus.stats.View;
import io.opencensus.stats.ViewManager;

public final class RpcViews {
  @VisibleForTesting
  static final ImmutableSet<View> RPC_CUMULATIVE_VIEWS_SET = ImmutableSet.of(RpcViewConstants.RPC_CLIENT_ERROR_COUNT_VIEW, RpcViewConstants.RPC_CLIENT_ROUNDTRIP_LATENCY_VIEW, RpcViewConstants.RPC_CLIENT_REQUEST_BYTES_VIEW, RpcViewConstants.RPC_CLIENT_RESPONSE_BYTES_VIEW, RpcViewConstants.RPC_CLIENT_REQUEST_COUNT_VIEW, RpcViewConstants.RPC_CLIENT_RESPONSE_COUNT_VIEW, (Object[])new View[] { 
        RpcViewConstants.RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES_VIEW, RpcViewConstants.RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES_VIEW, RpcViewConstants.RPC_CLIENT_SERVER_ELAPSED_TIME_VIEW, RpcViewConstants.RPC_SERVER_ERROR_COUNT_VIEW, RpcViewConstants.RPC_SERVER_SERVER_LATENCY_VIEW, RpcViewConstants.RPC_SERVER_SERVER_ELAPSED_TIME_VIEW, RpcViewConstants.RPC_SERVER_REQUEST_BYTES_VIEW, RpcViewConstants.RPC_SERVER_RESPONSE_BYTES_VIEW, RpcViewConstants.RPC_SERVER_REQUEST_COUNT_VIEW, RpcViewConstants.RPC_SERVER_RESPONSE_COUNT_VIEW, 
        RpcViewConstants.RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES_VIEW, RpcViewConstants.RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES_VIEW });
  
  @VisibleForTesting
  static final ImmutableSet<View> RPC_INTERVAL_VIEWS_SET = ImmutableSet.of(RpcViewConstants.RPC_CLIENT_ERROR_COUNT_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_ROUNDTRIP_LATENCY_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_REQUEST_BYTES_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_RESPONSE_BYTES_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_REQUEST_COUNT_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_RESPONSE_COUNT_MINUTE_VIEW, (Object[])new View[] { 
        RpcViewConstants.RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_SERVER_ELAPSED_TIME_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_ERROR_COUNT_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_SERVER_LATENCY_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_SERVER_ELAPSED_TIME_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_REQUEST_BYTES_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_RESPONSE_BYTES_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_REQUEST_COUNT_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_RESPONSE_COUNT_MINUTE_VIEW, 
        RpcViewConstants.RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_ERROR_COUNT_HOUR_VIEW, RpcViewConstants.RPC_CLIENT_ROUNDTRIP_LATENCY_HOUR_VIEW, RpcViewConstants.RPC_CLIENT_REQUEST_BYTES_HOUR_VIEW, RpcViewConstants.RPC_CLIENT_RESPONSE_BYTES_HOUR_VIEW, RpcViewConstants.RPC_CLIENT_REQUEST_COUNT_HOUR_VIEW, RpcViewConstants.RPC_CLIENT_RESPONSE_COUNT_HOUR_VIEW, RpcViewConstants.RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES_HOUR_VIEW, RpcViewConstants.RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES_HOUR_VIEW, 
        RpcViewConstants.RPC_CLIENT_SERVER_ELAPSED_TIME_HOUR_VIEW, RpcViewConstants.RPC_SERVER_ERROR_COUNT_HOUR_VIEW, RpcViewConstants.RPC_SERVER_SERVER_LATENCY_HOUR_VIEW, RpcViewConstants.RPC_SERVER_SERVER_ELAPSED_TIME_HOUR_VIEW, RpcViewConstants.RPC_SERVER_REQUEST_BYTES_HOUR_VIEW, RpcViewConstants.RPC_SERVER_RESPONSE_BYTES_HOUR_VIEW, RpcViewConstants.RPC_SERVER_REQUEST_COUNT_HOUR_VIEW, RpcViewConstants.RPC_SERVER_RESPONSE_COUNT_HOUR_VIEW, RpcViewConstants.RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES_HOUR_VIEW, RpcViewConstants.RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES_HOUR_VIEW });
  
  public static void registerAllCumulativeViews() {
    registerAllCumulativeViews(Stats.getViewManager());
  }
  
  @VisibleForTesting
  static void registerAllCumulativeViews(ViewManager paramViewManager) {
    UnmodifiableIterator<View> unmodifiableIterator = RPC_CUMULATIVE_VIEWS_SET.iterator();
    while (unmodifiableIterator.hasNext())
      paramViewManager.registerView(unmodifiableIterator.next()); 
  }
  
  public static void registerAllIntervalViews() {
    registerAllIntervalViews(Stats.getViewManager());
  }
  
  @VisibleForTesting
  static void registerAllIntervalViews(ViewManager paramViewManager) {
    UnmodifiableIterator<View> unmodifiableIterator = RPC_INTERVAL_VIEWS_SET.iterator();
    while (unmodifiableIterator.hasNext())
      paramViewManager.registerView(unmodifiableIterator.next()); 
  }
  
  public static void registerAllViews() {
    registerAllViews(Stats.getViewManager());
  }
  
  @VisibleForTesting
  static void registerAllViews(ViewManager paramViewManager) {
    registerAllCumulativeViews(paramViewManager);
    registerAllIntervalViews(paramViewManager);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\contrib\grpc\metrics\RpcViews.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */