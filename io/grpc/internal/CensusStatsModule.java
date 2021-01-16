package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ClientStreamTracer;
import io.grpc.Context;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.ServerStreamTracer;
import io.grpc.Status;
import io.opencensus.contrib.grpc.metrics.RpcMeasureConstants;
import io.opencensus.stats.Measure;
import io.opencensus.stats.MeasureMap;
import io.opencensus.stats.Stats;
import io.opencensus.stats.StatsRecorder;
import io.opencensus.tags.TagContext;
import io.opencensus.tags.TagValue;
import io.opencensus.tags.Tagger;
import io.opencensus.tags.Tags;
import io.opencensus.tags.propagation.TagContextBinarySerializer;
import io.opencensus.tags.propagation.TagContextSerializationException;
import io.opencensus.tags.unsafe.ContextUtils;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class CensusStatsModule {
  private static final ClientTracer BLANK_CLIENT_TRACER;
  
  private static final double NANOS_PER_MILLI;
  
  private static final Logger logger = Logger.getLogger(CensusStatsModule.class.getName());
  
  private final boolean propagateTags;
  
  @VisibleForTesting
  final Metadata.Key<TagContext> statsHeader;
  
  private final StatsRecorder statsRecorder;
  
  private final Supplier<Stopwatch> stopwatchSupplier;
  
  private final Tagger tagger;
  
  static {
    NANOS_PER_MILLI = TimeUnit.MILLISECONDS.toNanos(1L);
    BLANK_CLIENT_TRACER = new ClientTracer();
  }
  
  CensusStatsModule(Supplier<Stopwatch> paramSupplier, boolean paramBoolean) {
    this(Tags.getTagger(), Tags.getTagPropagationComponent().getBinarySerializer(), Stats.getStatsRecorder(), paramSupplier, paramBoolean);
  }
  
  public CensusStatsModule(final Tagger tagger, final TagContextBinarySerializer tagCtxSerializer, StatsRecorder paramStatsRecorder, Supplier<Stopwatch> paramSupplier, boolean paramBoolean) {
    this.tagger = (Tagger)Preconditions.checkNotNull(tagger, "tagger");
    this.statsRecorder = (StatsRecorder)Preconditions.checkNotNull(paramStatsRecorder, "statsRecorder");
    Preconditions.checkNotNull(tagCtxSerializer, "tagCtxSerializer");
    this.stopwatchSupplier = (Supplier<Stopwatch>)Preconditions.checkNotNull(paramSupplier, "stopwatchSupplier");
    this.propagateTags = paramBoolean;
    this.statsHeader = Metadata.Key.of("grpc-tags-bin", new Metadata.BinaryMarshaller<TagContext>() {
          public TagContext parseBytes(byte[] param1ArrayOfbyte) {
            try {
              return tagCtxSerializer.fromByteArray(param1ArrayOfbyte);
            } catch (Exception exception) {
              CensusStatsModule.logger.log(Level.FINE, "Failed to parse stats header", exception);
              return tagger.empty();
            } 
          }
          
          public byte[] toBytes(TagContext param1TagContext) {
            try {
              return tagCtxSerializer.toByteArray(param1TagContext);
            } catch (TagContextSerializationException tagContextSerializationException) {
              throw new RuntimeException(tagContextSerializationException);
            } 
          }
        });
  }
  
  ClientInterceptor getClientInterceptor(boolean paramBoolean1, boolean paramBoolean2) {
    return new StatsClientInterceptor(paramBoolean1, paramBoolean2);
  }
  
  ServerStreamTracer.Factory getServerTracerFactory(boolean paramBoolean1, boolean paramBoolean2) {
    return new ServerTracerFactory(paramBoolean1, paramBoolean2);
  }
  
  @VisibleForTesting
  ClientCallTracer newClientCallTracer(TagContext paramTagContext, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
    return new ClientCallTracer(this, paramTagContext, paramString, paramBoolean1, paramBoolean2);
  }
  
  @VisibleForTesting
  static final class ClientCallTracer extends ClientStreamTracer.Factory {
    @Nullable
    private static final AtomicIntegerFieldUpdater<ClientCallTracer> callEndedUpdater;
    
    @Nullable
    private static final AtomicReferenceFieldUpdater<ClientCallTracer, CensusStatsModule.ClientTracer> streamTracerUpdater;
    
    private volatile int callEnded;
    
    private final String fullMethodName;
    
    private final CensusStatsModule module;
    
    private final TagContext parentCtx;
    
    private final boolean recordFinishedRpcs;
    
    private final TagContext startCtx;
    
    private final Stopwatch stopwatch;
    
    private volatile CensusStatsModule.ClientTracer streamTracer;
    
    static {
      AtomicReferenceFieldUpdater<ClientCallTracer, CensusStatsModule.ClientTracer> atomicReferenceFieldUpdater = null;
      try {
        AtomicReferenceFieldUpdater<ClientCallTracer, CensusStatsModule.ClientTracer> atomicReferenceFieldUpdater1 = AtomicReferenceFieldUpdater.newUpdater(ClientCallTracer.class, CensusStatsModule.ClientTracer.class, "streamTracer");
        AtomicIntegerFieldUpdater<ClientCallTracer> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(ClientCallTracer.class, "callEnded");
        atomicReferenceFieldUpdater = atomicReferenceFieldUpdater1;
      } catch (Throwable throwable) {
        CensusStatsModule.logger.log(Level.SEVERE, "Creating atomic field updaters failed", throwable);
        throwable = null;
      } 
      streamTracerUpdater = atomicReferenceFieldUpdater;
      callEndedUpdater = (AtomicIntegerFieldUpdater<ClientCallTracer>)throwable;
    }
    
    ClientCallTracer(CensusStatsModule param1CensusStatsModule, TagContext param1TagContext, String param1String, boolean param1Boolean1, boolean param1Boolean2) {
      this.module = param1CensusStatsModule;
      this.fullMethodName = (String)Preconditions.checkNotNull(param1String, "fullMethodName");
      this.parentCtx = (TagContext)Preconditions.checkNotNull(param1TagContext);
      this.startCtx = param1CensusStatsModule.tagger.toBuilder(param1TagContext).put(RpcMeasureConstants.RPC_METHOD, TagValue.create(param1String)).build();
      this.stopwatch = ((Stopwatch)param1CensusStatsModule.stopwatchSupplier.get()).start();
      this.recordFinishedRpcs = param1Boolean2;
      if (param1Boolean1)
        param1CensusStatsModule.statsRecorder.newMeasureMap().put(RpcMeasureConstants.RPC_CLIENT_STARTED_COUNT, 1L).record(this.startCtx); 
    }
    
    void callEnded(Status param1Status) {
      AtomicIntegerFieldUpdater<ClientCallTracer> atomicIntegerFieldUpdater = callEndedUpdater;
      if (atomicIntegerFieldUpdater != null) {
        if (atomicIntegerFieldUpdater.getAndSet(this, 1) != 0)
          return; 
      } else {
        if (this.callEnded != 0)
          return; 
        this.callEnded = 1;
      } 
      if (!this.recordFinishedRpcs)
        return; 
      this.stopwatch.stop();
      long l = this.stopwatch.elapsed(TimeUnit.NANOSECONDS);
      CensusStatsModule.ClientTracer clientTracer2 = this.streamTracer;
      CensusStatsModule.ClientTracer clientTracer1 = clientTracer2;
      if (clientTracer2 == null)
        clientTracer1 = CensusStatsModule.BLANK_CLIENT_TRACER; 
      MeasureMap measureMap2 = this.module.statsRecorder.newMeasureMap().put(RpcMeasureConstants.RPC_CLIENT_FINISHED_COUNT, 1L);
      Measure.MeasureDouble measureDouble = RpcMeasureConstants.RPC_CLIENT_ROUNDTRIP_LATENCY;
      double d1 = l;
      double d2 = CensusStatsModule.NANOS_PER_MILLI;
      Double.isNaN(d1);
      MeasureMap measureMap1 = measureMap2.put(measureDouble, d1 / d2).put(RpcMeasureConstants.RPC_CLIENT_REQUEST_COUNT, clientTracer1.outboundMessageCount).put(RpcMeasureConstants.RPC_CLIENT_RESPONSE_COUNT, clientTracer1.inboundMessageCount).put(RpcMeasureConstants.RPC_CLIENT_REQUEST_BYTES, clientTracer1.outboundWireSize).put(RpcMeasureConstants.RPC_CLIENT_RESPONSE_BYTES, clientTracer1.inboundWireSize).put(RpcMeasureConstants.RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES, clientTracer1.outboundUncompressedSize).put(RpcMeasureConstants.RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES, clientTracer1.inboundUncompressedSize);
      if (!param1Status.isOk())
        measureMap1.put(RpcMeasureConstants.RPC_CLIENT_ERROR_COUNT, 1L); 
      measureMap1.record(this.module.tagger.toBuilder(this.startCtx).put(RpcMeasureConstants.RPC_STATUS, TagValue.create(param1Status.getCode().toString())).build());
    }
    
    public ClientStreamTracer newClientStreamTracer(CallOptions param1CallOptions, Metadata param1Metadata) {
      CensusStatsModule.ClientTracer clientTracer = new CensusStatsModule.ClientTracer();
      AtomicReferenceFieldUpdater<ClientCallTracer, CensusStatsModule.ClientTracer> atomicReferenceFieldUpdater = streamTracerUpdater;
      if (atomicReferenceFieldUpdater != null) {
        Preconditions.checkState(atomicReferenceFieldUpdater.compareAndSet(this, null, clientTracer), "Are you creating multiple streams per call? This class doesn't yet support this case");
      } else {
        boolean bool;
        if (this.streamTracer == null) {
          bool = true;
        } else {
          bool = false;
        } 
        Preconditions.checkState(bool, "Are you creating multiple streams per call? This class doesn't yet support this case");
        this.streamTracer = clientTracer;
      } 
      if (this.module.propagateTags) {
        param1Metadata.discardAll(this.module.statsHeader);
        if (!this.module.tagger.empty().equals(this.parentCtx))
          param1Metadata.put(this.module.statsHeader, this.parentCtx); 
      } 
      return clientTracer;
    }
  }
  
  private static final class ClientTracer extends ClientStreamTracer {
    @Nullable
    private static final AtomicLongFieldUpdater<ClientTracer> inboundMessageCountUpdater;
    
    @Nullable
    private static final AtomicLongFieldUpdater<ClientTracer> inboundUncompressedSizeUpdater;
    
    @Nullable
    private static final AtomicLongFieldUpdater<ClientTracer> inboundWireSizeUpdater;
    
    @Nullable
    private static final AtomicLongFieldUpdater<ClientTracer> outboundMessageCountUpdater;
    
    @Nullable
    private static final AtomicLongFieldUpdater<ClientTracer> outboundUncompressedSizeUpdater;
    
    @Nullable
    private static final AtomicLongFieldUpdater<ClientTracer> outboundWireSizeUpdater;
    
    volatile long inboundMessageCount;
    
    volatile long inboundUncompressedSize;
    
    volatile long inboundWireSize;
    
    volatile long outboundMessageCount;
    
    volatile long outboundUncompressedSize;
    
    volatile long outboundWireSize;
    
    static {
      Throwable throwable2;
      Throwable throwable3;
      Throwable throwable4;
      Throwable throwable5;
      Throwable throwable6;
      Throwable throwable1 = null;
      try {
        AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater1 = AtomicLongFieldUpdater.newUpdater(ClientTracer.class, "outboundMessageCount");
        AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater2 = AtomicLongFieldUpdater.newUpdater(ClientTracer.class, "inboundMessageCount");
        AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater3 = AtomicLongFieldUpdater.newUpdater(ClientTracer.class, "outboundWireSize");
        AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater4 = AtomicLongFieldUpdater.newUpdater(ClientTracer.class, "inboundWireSize");
        AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater5 = AtomicLongFieldUpdater.newUpdater(ClientTracer.class, "outboundUncompressedSize");
        AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater6 = AtomicLongFieldUpdater.newUpdater(ClientTracer.class, "inboundUncompressedSize");
      } catch (Throwable throwable7) {
        CensusStatsModule.logger.log(Level.SEVERE, "Creating atomic field updaters failed", throwable7);
        throwable2 = null;
        throwable7 = throwable2;
        throwable4 = throwable7;
        throwable3 = throwable4;
        throwable6 = throwable3;
        throwable5 = throwable3;
        throwable3 = throwable7;
        throwable7 = throwable2;
        throwable2 = throwable1;
      } 
      outboundMessageCountUpdater = (AtomicLongFieldUpdater<ClientTracer>)throwable2;
      inboundMessageCountUpdater = (AtomicLongFieldUpdater<ClientTracer>)throwable3;
      outboundWireSizeUpdater = (AtomicLongFieldUpdater<ClientTracer>)throwable4;
      inboundWireSizeUpdater = (AtomicLongFieldUpdater<ClientTracer>)throwable5;
      outboundUncompressedSizeUpdater = (AtomicLongFieldUpdater<ClientTracer>)throwable6;
      inboundUncompressedSizeUpdater = (AtomicLongFieldUpdater<ClientTracer>)throwable7;
    }
    
    private ClientTracer() {}
    
    public void inboundMessage(int param1Int) {
      AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater = inboundMessageCountUpdater;
      if (atomicLongFieldUpdater != null) {
        atomicLongFieldUpdater.getAndIncrement(this);
      } else {
        this.inboundMessageCount++;
      } 
    }
    
    public void inboundUncompressedSize(long param1Long) {
      AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater = inboundUncompressedSizeUpdater;
      if (atomicLongFieldUpdater != null) {
        atomicLongFieldUpdater.getAndAdd(this, param1Long);
      } else {
        this.inboundUncompressedSize += param1Long;
      } 
    }
    
    public void inboundWireSize(long param1Long) {
      AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater = inboundWireSizeUpdater;
      if (atomicLongFieldUpdater != null) {
        atomicLongFieldUpdater.getAndAdd(this, param1Long);
      } else {
        this.inboundWireSize += param1Long;
      } 
    }
    
    public void outboundMessage(int param1Int) {
      AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater = outboundMessageCountUpdater;
      if (atomicLongFieldUpdater != null) {
        atomicLongFieldUpdater.getAndIncrement(this);
      } else {
        this.outboundMessageCount++;
      } 
    }
    
    public void outboundUncompressedSize(long param1Long) {
      AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater = outboundUncompressedSizeUpdater;
      if (atomicLongFieldUpdater != null) {
        atomicLongFieldUpdater.getAndAdd(this, param1Long);
      } else {
        this.outboundUncompressedSize += param1Long;
      } 
    }
    
    public void outboundWireSize(long param1Long) {
      AtomicLongFieldUpdater<ClientTracer> atomicLongFieldUpdater = outboundWireSizeUpdater;
      if (atomicLongFieldUpdater != null) {
        atomicLongFieldUpdater.getAndAdd(this, param1Long);
      } else {
        this.outboundWireSize += param1Long;
      } 
    }
  }
  
  private static final class ServerTracer extends ServerStreamTracer {
    @Nullable
    private static final AtomicLongFieldUpdater<ServerTracer> inboundMessageCountUpdater;
    
    @Nullable
    private static final AtomicLongFieldUpdater<ServerTracer> inboundUncompressedSizeUpdater;
    
    @Nullable
    private static final AtomicLongFieldUpdater<ServerTracer> inboundWireSizeUpdater;
    
    @Nullable
    private static final AtomicLongFieldUpdater<ServerTracer> outboundMessageCountUpdater;
    
    @Nullable
    private static final AtomicLongFieldUpdater<ServerTracer> outboundUncompressedSizeUpdater;
    
    @Nullable
    private static final AtomicLongFieldUpdater<ServerTracer> outboundWireSizeUpdater;
    
    @Nullable
    private static final AtomicIntegerFieldUpdater<ServerTracer> streamClosedUpdater;
    
    private final String fullMethodName;
    
    private volatile long inboundMessageCount;
    
    private volatile long inboundUncompressedSize;
    
    private volatile long inboundWireSize;
    
    private final CensusStatsModule module;
    
    private volatile long outboundMessageCount;
    
    private volatile long outboundUncompressedSize;
    
    private volatile long outboundWireSize;
    
    private final TagContext parentCtx;
    
    private final boolean recordFinishedRpcs;
    
    private final Stopwatch stopwatch;
    
    private volatile int streamClosed;
    
    private final Tagger tagger;
    
    static {
      Throwable throwable2;
      Throwable throwable4;
      Throwable throwable5;
      Throwable throwable6;
      Throwable throwable7;
      Throwable throwable8;
      Throwable throwable1 = null;
      try {
        AtomicIntegerFieldUpdater<ServerTracer> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(ServerTracer.class, "streamClosed");
        AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater1 = AtomicLongFieldUpdater.newUpdater(ServerTracer.class, "outboundMessageCount");
        AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater2 = AtomicLongFieldUpdater.newUpdater(ServerTracer.class, "inboundMessageCount");
        AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater3 = AtomicLongFieldUpdater.newUpdater(ServerTracer.class, "outboundWireSize");
        AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater4 = AtomicLongFieldUpdater.newUpdater(ServerTracer.class, "inboundWireSize");
        AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater5 = AtomicLongFieldUpdater.newUpdater(ServerTracer.class, "outboundUncompressedSize");
        AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater6 = AtomicLongFieldUpdater.newUpdater(ServerTracer.class, "inboundUncompressedSize");
      } catch (Throwable throwable3) {
        CensusStatsModule.logger.log(Level.SEVERE, "Creating atomic field updaters failed", throwable3);
        throwable2 = null;
        throwable3 = throwable2;
        throwable4 = throwable3;
        throwable8 = throwable4;
        throwable6 = throwable8;
        throwable7 = throwable6;
        throwable5 = throwable8;
        throwable8 = throwable2;
        throwable2 = throwable1;
      } 
      streamClosedUpdater = (AtomicIntegerFieldUpdater<ServerTracer>)throwable2;
      outboundMessageCountUpdater = (AtomicLongFieldUpdater<ServerTracer>)throwable3;
      inboundMessageCountUpdater = (AtomicLongFieldUpdater<ServerTracer>)throwable4;
      outboundWireSizeUpdater = (AtomicLongFieldUpdater<ServerTracer>)throwable5;
      inboundWireSizeUpdater = (AtomicLongFieldUpdater<ServerTracer>)throwable6;
      outboundUncompressedSizeUpdater = (AtomicLongFieldUpdater<ServerTracer>)throwable7;
      inboundUncompressedSizeUpdater = (AtomicLongFieldUpdater<ServerTracer>)throwable8;
    }
    
    ServerTracer(CensusStatsModule param1CensusStatsModule, String param1String, TagContext param1TagContext, Supplier<Stopwatch> param1Supplier, Tagger param1Tagger, boolean param1Boolean1, boolean param1Boolean2) {
      this.module = param1CensusStatsModule;
      this.fullMethodName = (String)Preconditions.checkNotNull(param1String, "fullMethodName");
      this.parentCtx = (TagContext)Preconditions.checkNotNull(param1TagContext, "parentCtx");
      this.stopwatch = ((Stopwatch)param1Supplier.get()).start();
      this.tagger = param1Tagger;
      this.recordFinishedRpcs = param1Boolean2;
      if (param1Boolean1)
        param1CensusStatsModule.statsRecorder.newMeasureMap().put(RpcMeasureConstants.RPC_SERVER_STARTED_COUNT, 1L).record(param1TagContext); 
    }
    
    public Context filterContext(Context param1Context) {
      return !this.tagger.empty().equals(this.parentCtx) ? param1Context.withValue(ContextUtils.TAG_CONTEXT_KEY, this.parentCtx) : param1Context;
    }
    
    public void inboundMessage(int param1Int) {
      AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater = inboundMessageCountUpdater;
      if (atomicLongFieldUpdater != null) {
        atomicLongFieldUpdater.getAndIncrement(this);
      } else {
        this.inboundMessageCount++;
      } 
    }
    
    public void inboundUncompressedSize(long param1Long) {
      AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater = inboundUncompressedSizeUpdater;
      if (atomicLongFieldUpdater != null) {
        atomicLongFieldUpdater.getAndAdd(this, param1Long);
      } else {
        this.inboundUncompressedSize += param1Long;
      } 
    }
    
    public void inboundWireSize(long param1Long) {
      AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater = inboundWireSizeUpdater;
      if (atomicLongFieldUpdater != null) {
        atomicLongFieldUpdater.getAndAdd(this, param1Long);
      } else {
        this.inboundWireSize += param1Long;
      } 
    }
    
    public void outboundMessage(int param1Int) {
      AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater = outboundMessageCountUpdater;
      if (atomicLongFieldUpdater != null) {
        atomicLongFieldUpdater.getAndIncrement(this);
      } else {
        this.outboundMessageCount++;
      } 
    }
    
    public void outboundUncompressedSize(long param1Long) {
      AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater = outboundUncompressedSizeUpdater;
      if (atomicLongFieldUpdater != null) {
        atomicLongFieldUpdater.getAndAdd(this, param1Long);
      } else {
        this.outboundUncompressedSize += param1Long;
      } 
    }
    
    public void outboundWireSize(long param1Long) {
      AtomicLongFieldUpdater<ServerTracer> atomicLongFieldUpdater = outboundWireSizeUpdater;
      if (atomicLongFieldUpdater != null) {
        atomicLongFieldUpdater.getAndAdd(this, param1Long);
      } else {
        this.outboundWireSize += param1Long;
      } 
    }
    
    public void streamClosed(Status param1Status) {
      AtomicIntegerFieldUpdater<ServerTracer> atomicIntegerFieldUpdater = streamClosedUpdater;
      if (atomicIntegerFieldUpdater != null) {
        if (atomicIntegerFieldUpdater.getAndSet(this, 1) != 0)
          return; 
      } else {
        if (this.streamClosed != 0)
          return; 
        this.streamClosed = 1;
      } 
      if (!this.recordFinishedRpcs)
        return; 
      this.stopwatch.stop();
      long l = this.stopwatch.elapsed(TimeUnit.NANOSECONDS);
      MeasureMap measureMap = this.module.statsRecorder.newMeasureMap().put(RpcMeasureConstants.RPC_SERVER_FINISHED_COUNT, 1L);
      Measure.MeasureDouble measureDouble = RpcMeasureConstants.RPC_SERVER_SERVER_LATENCY;
      double d1 = l;
      double d2 = CensusStatsModule.NANOS_PER_MILLI;
      Double.isNaN(d1);
      measureMap = measureMap.put(measureDouble, d1 / d2).put(RpcMeasureConstants.RPC_SERVER_RESPONSE_COUNT, this.outboundMessageCount).put(RpcMeasureConstants.RPC_SERVER_REQUEST_COUNT, this.inboundMessageCount).put(RpcMeasureConstants.RPC_SERVER_RESPONSE_BYTES, this.outboundWireSize).put(RpcMeasureConstants.RPC_SERVER_REQUEST_BYTES, this.inboundWireSize).put(RpcMeasureConstants.RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES, this.outboundUncompressedSize).put(RpcMeasureConstants.RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES, this.inboundUncompressedSize);
      if (!param1Status.isOk())
        measureMap.put(RpcMeasureConstants.RPC_SERVER_ERROR_COUNT, 1L); 
      measureMap.record(this.module.tagger.toBuilder(this.parentCtx).put(RpcMeasureConstants.RPC_STATUS, TagValue.create(param1Status.getCode().toString())).build());
    }
  }
  
  @VisibleForTesting
  final class ServerTracerFactory extends ServerStreamTracer.Factory {
    private final boolean recordFinishedRpcs;
    
    private final boolean recordStartedRpcs;
    
    ServerTracerFactory(boolean param1Boolean1, boolean param1Boolean2) {
      this.recordStartedRpcs = param1Boolean1;
      this.recordFinishedRpcs = param1Boolean2;
    }
    
    public ServerStreamTracer newServerStreamTracer(String param1String, Metadata param1Metadata) {
      TagContext tagContext2 = (TagContext)param1Metadata.get(CensusStatsModule.this.statsHeader);
      TagContext tagContext1 = tagContext2;
      if (tagContext2 == null)
        tagContext1 = CensusStatsModule.this.tagger.empty(); 
      tagContext1 = CensusStatsModule.this.tagger.toBuilder(tagContext1).put(RpcMeasureConstants.RPC_METHOD, TagValue.create(param1String)).build();
      CensusStatsModule censusStatsModule = CensusStatsModule.this;
      return new CensusStatsModule.ServerTracer(censusStatsModule, param1String, tagContext1, censusStatsModule.stopwatchSupplier, CensusStatsModule.this.tagger, this.recordStartedRpcs, this.recordFinishedRpcs);
    }
  }
  
  @VisibleForTesting
  final class StatsClientInterceptor implements ClientInterceptor {
    private final boolean recordFinishedRpcs;
    
    private final boolean recordStartedRpcs;
    
    StatsClientInterceptor(boolean param1Boolean1, boolean param1Boolean2) {
      this.recordStartedRpcs = param1Boolean1;
      this.recordFinishedRpcs = param1Boolean2;
    }
    
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> param1MethodDescriptor, CallOptions param1CallOptions, Channel param1Channel) {
      TagContext tagContext = CensusStatsModule.this.tagger.getCurrentTagContext();
      final CensusStatsModule.ClientCallTracer tracerFactory = CensusStatsModule.this.newClientCallTracer(tagContext, param1MethodDescriptor.getFullMethodName(), this.recordStartedRpcs, this.recordFinishedRpcs);
      return (ClientCall<ReqT, RespT>)new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(param1Channel.newCall(param1MethodDescriptor, param1CallOptions.withStreamTracerFactory(clientCallTracer))) {
          public void start(ClientCall.Listener<RespT> param2Listener, Metadata param2Metadata) {
            delegate().start((ClientCall.Listener)new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(param2Listener) {
                  public void onClose(Status param3Status, Metadata param3Metadata) {
                    tracerFactory.callEnded(param3Status);
                    super.onClose(param3Status, param3Metadata);
                  }
                }param2Metadata);
          }
        };
    }
  }
  
  class null extends ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT> {
    null(ClientCall param1ClientCall) {
      super(param1ClientCall);
    }
    
    public void start(ClientCall.Listener<RespT> param1Listener, Metadata param1Metadata) {
      delegate().start((ClientCall.Listener)new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(param1Listener) {
            public void onClose(Status param3Status, Metadata param3Metadata) {
              tracerFactory.callEnded(param3Status);
              super.onClose(param3Status, param3Metadata);
            }
          }param1Metadata);
    }
  }
  
  class null extends ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT> {
    public void onClose(Status param1Status, Metadata param1Metadata) {
      tracerFactory.callEnded(param1Status);
      super.onClose(param1Status, param1Metadata);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\CensusStatsModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */