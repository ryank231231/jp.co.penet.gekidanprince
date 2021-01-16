package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.ConnectivityState;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

public final class Channelz {
  private static final Channelz INSTANCE = new Channelz();
  
  private final ConcurrentMap<Long, Instrumented<SocketStats>> otherSockets = new ConcurrentHashMap<Long, Instrumented<SocketStats>>();
  
  private final ConcurrentMap<Long, ServerSocketMap> perServerSockets = new ConcurrentHashMap<Long, ServerSocketMap>();
  
  private final ConcurrentNavigableMap<Long, Instrumented<ChannelStats>> rootChannels = new ConcurrentSkipListMap<Long, Instrumented<ChannelStats>>();
  
  private final ConcurrentNavigableMap<Long, Instrumented<ServerStats>> servers = new ConcurrentSkipListMap<Long, Instrumented<ServerStats>>();
  
  private final ConcurrentMap<Long, Instrumented<ChannelStats>> subchannels = new ConcurrentHashMap<Long, Instrumented<ChannelStats>>();
  
  private static <T extends Instrumented<?>> void add(Map<Long, T> paramMap, T paramT) {
    Instrumented instrumented = (Instrumented)paramMap.put(Long.valueOf(paramT.getLogId().getId()), paramT);
  }
  
  private static <T extends Instrumented<?>> boolean contains(Map<Long, T> paramMap, LogId paramLogId) {
    return paramMap.containsKey(Long.valueOf(paramLogId.getId()));
  }
  
  private Instrumented<SocketStats> getServerSocket(long paramLong) {
    Iterator<ServerSocketMap> iterator = this.perServerSockets.values().iterator();
    while (iterator.hasNext()) {
      Instrumented<SocketStats> instrumented = ((ServerSocketMap)iterator.next()).get(Long.valueOf(paramLong));
      if (instrumented != null)
        return instrumented; 
    } 
    return null;
  }
  
  public static long id(WithLogId paramWithLogId) {
    return paramWithLogId.getLogId().getId();
  }
  
  public static Channelz instance() {
    return INSTANCE;
  }
  
  private static <T extends Instrumented<?>> void remove(Map<Long, T> paramMap, T paramT) {
    Instrumented instrumented = (Instrumented)paramMap.remove(Long.valueOf(id((WithLogId)paramT)));
  }
  
  public void addClientSocket(Instrumented<SocketStats> paramInstrumented) {
    add(this.otherSockets, paramInstrumented);
  }
  
  public void addListenSocket(Instrumented<SocketStats> paramInstrumented) {
    add(this.otherSockets, paramInstrumented);
  }
  
  public void addRootChannel(Instrumented<ChannelStats> paramInstrumented) {
    add(this.rootChannels, paramInstrumented);
  }
  
  public void addServer(Instrumented<ServerStats> paramInstrumented) {
    ServerSocketMap serverSocketMap = this.perServerSockets.put(Long.valueOf(id((WithLogId)paramInstrumented)), new ServerSocketMap());
    add(this.servers, paramInstrumented);
  }
  
  public void addServerSocket(Instrumented<ServerStats> paramInstrumented, Instrumented<SocketStats> paramInstrumented1) {
    add(this.perServerSockets.get(Long.valueOf(id((WithLogId)paramInstrumented))), paramInstrumented1);
  }
  
  public void addSubchannel(Instrumented<ChannelStats> paramInstrumented) {
    add(this.subchannels, paramInstrumented);
  }
  
  @VisibleForTesting
  public boolean containsClientSocket(LogId paramLogId) {
    return contains(this.otherSockets, paramLogId);
  }
  
  @VisibleForTesting
  public boolean containsServer(LogId paramLogId) {
    return contains(this.servers, paramLogId);
  }
  
  @VisibleForTesting
  public boolean containsSubchannel(LogId paramLogId) {
    return contains(this.subchannels, paramLogId);
  }
  
  @Nullable
  public Instrumented<ChannelStats> getChannel(long paramLong) {
    return this.rootChannels.get(Long.valueOf(paramLong));
  }
  
  public Instrumented<ChannelStats> getRootChannel(long paramLong) {
    return this.rootChannels.get(Long.valueOf(paramLong));
  }
  
  public RootChannelList getRootChannels(long paramLong, int paramInt) {
    ArrayList<Instrumented<ChannelStats>> arrayList = new ArrayList();
    Iterator iterator = this.rootChannels.tailMap(Long.valueOf(paramLong)).values().iterator();
    while (iterator.hasNext() && arrayList.size() < paramInt)
      arrayList.add(iterator.next()); 
    return new RootChannelList(arrayList, iterator.hasNext() ^ true);
  }
  
  @Nullable
  public ServerSocketsList getServerSockets(long paramLong1, long paramLong2, int paramInt) {
    ServerSocketMap serverSocketMap = this.perServerSockets.get(Long.valueOf(paramLong1));
    if (serverSocketMap == null)
      return null; 
    ArrayList<WithLogId> arrayList = new ArrayList(paramInt);
    Iterator iterator = serverSocketMap.tailMap(Long.valueOf(paramLong2)).values().iterator();
    while (arrayList.size() < paramInt && iterator.hasNext())
      arrayList.add(iterator.next()); 
    return new ServerSocketsList(arrayList, iterator.hasNext() ^ true);
  }
  
  public ServerList getServers(long paramLong, int paramInt) {
    ArrayList<Instrumented<ServerStats>> arrayList = new ArrayList(paramInt);
    Iterator iterator = this.servers.tailMap(Long.valueOf(paramLong)).values().iterator();
    while (iterator.hasNext() && arrayList.size() < paramInt)
      arrayList.add(iterator.next()); 
    return new ServerList(arrayList, iterator.hasNext() ^ true);
  }
  
  @Nullable
  public Instrumented<SocketStats> getSocket(long paramLong) {
    Instrumented<SocketStats> instrumented = this.otherSockets.get(Long.valueOf(paramLong));
    return (instrumented != null) ? instrumented : getServerSocket(paramLong);
  }
  
  @Nullable
  public Instrumented<ChannelStats> getSubchannel(long paramLong) {
    return this.subchannels.get(Long.valueOf(paramLong));
  }
  
  public void removeClientSocket(Instrumented<SocketStats> paramInstrumented) {
    remove(this.otherSockets, paramInstrumented);
  }
  
  public void removeListenSocket(Instrumented<SocketStats> paramInstrumented) {
    remove(this.otherSockets, paramInstrumented);
  }
  
  public void removeRootChannel(Instrumented<ChannelStats> paramInstrumented) {
    remove(this.rootChannels, paramInstrumented);
  }
  
  public void removeServer(Instrumented<ServerStats> paramInstrumented) {
    remove(this.servers, paramInstrumented);
    ServerSocketMap serverSocketMap = this.perServerSockets.remove(Long.valueOf(id((WithLogId)paramInstrumented)));
  }
  
  public void removeServerSocket(Instrumented<ServerStats> paramInstrumented, Instrumented<SocketStats> paramInstrumented1) {
    remove(this.perServerSockets.get(Long.valueOf(id((WithLogId)paramInstrumented))), paramInstrumented1);
  }
  
  public void removeSubchannel(Instrumented<ChannelStats> paramInstrumented) {
    remove(this.subchannels, paramInstrumented);
  }
  
  @Immutable
  public static final class ChannelStats {
    public final long callsFailed;
    
    public final long callsStarted;
    
    public final long callsSucceeded;
    
    public final long lastCallStartedMillis;
    
    public final List<WithLogId> sockets;
    
    public final ConnectivityState state;
    
    public final List<WithLogId> subchannels;
    
    public final String target;
    
    public ChannelStats(String param1String, ConnectivityState param1ConnectivityState, long param1Long1, long param1Long2, long param1Long3, long param1Long4, List<WithLogId> param1List1, List<WithLogId> param1List2) {
      boolean bool;
      if (param1List1.isEmpty() || param1List2.isEmpty()) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "channels can have subchannels only, subchannels can have either sockets OR subchannels, neither can have both");
      this.target = param1String;
      this.state = param1ConnectivityState;
      this.callsStarted = param1Long1;
      this.callsSucceeded = param1Long2;
      this.callsFailed = param1Long3;
      this.lastCallStartedMillis = param1Long4;
      this.subchannels = (List<WithLogId>)Preconditions.checkNotNull(param1List1);
      this.sockets = (List<WithLogId>)Preconditions.checkNotNull(param1List2);
    }
    
    public static final class Builder {
      private long callsFailed;
      
      private long callsStarted;
      
      private long callsSucceeded;
      
      private long lastCallStartedMillis;
      
      private List<WithLogId> sockets = Collections.emptyList();
      
      private ConnectivityState state;
      
      private List<WithLogId> subchannels = Collections.emptyList();
      
      private String target;
      
      public Channelz.ChannelStats build() {
        return new Channelz.ChannelStats(this.target, this.state, this.callsStarted, this.callsSucceeded, this.callsFailed, this.lastCallStartedMillis, this.subchannels, this.sockets);
      }
      
      public Builder setCallsFailed(long param2Long) {
        this.callsFailed = param2Long;
        return this;
      }
      
      public Builder setCallsStarted(long param2Long) {
        this.callsStarted = param2Long;
        return this;
      }
      
      public Builder setCallsSucceeded(long param2Long) {
        this.callsSucceeded = param2Long;
        return this;
      }
      
      public Builder setLastCallStartedMillis(long param2Long) {
        this.lastCallStartedMillis = param2Long;
        return this;
      }
      
      public Builder setSockets(List<WithLogId> param2List) {
        Preconditions.checkState(this.subchannels.isEmpty());
        this.sockets = Collections.unmodifiableList((List<? extends WithLogId>)Preconditions.checkNotNull(param2List));
        return this;
      }
      
      public Builder setState(ConnectivityState param2ConnectivityState) {
        this.state = param2ConnectivityState;
        return this;
      }
      
      public Builder setSubchannels(List<WithLogId> param2List) {
        Preconditions.checkState(this.sockets.isEmpty());
        this.subchannels = Collections.unmodifiableList((List<? extends WithLogId>)Preconditions.checkNotNull(param2List));
        return this;
      }
      
      public Builder setTarget(String param2String) {
        this.target = param2String;
        return this;
      }
    }
  }
  
  public static final class Builder {
    private long callsFailed;
    
    private long callsStarted;
    
    private long callsSucceeded;
    
    private long lastCallStartedMillis;
    
    private List<WithLogId> sockets = Collections.emptyList();
    
    private ConnectivityState state;
    
    private List<WithLogId> subchannels = Collections.emptyList();
    
    private String target;
    
    public Channelz.ChannelStats build() {
      return new Channelz.ChannelStats(this.target, this.state, this.callsStarted, this.callsSucceeded, this.callsFailed, this.lastCallStartedMillis, this.subchannels, this.sockets);
    }
    
    public Builder setCallsFailed(long param1Long) {
      this.callsFailed = param1Long;
      return this;
    }
    
    public Builder setCallsStarted(long param1Long) {
      this.callsStarted = param1Long;
      return this;
    }
    
    public Builder setCallsSucceeded(long param1Long) {
      this.callsSucceeded = param1Long;
      return this;
    }
    
    public Builder setLastCallStartedMillis(long param1Long) {
      this.lastCallStartedMillis = param1Long;
      return this;
    }
    
    public Builder setSockets(List<WithLogId> param1List) {
      Preconditions.checkState(this.subchannels.isEmpty());
      this.sockets = Collections.unmodifiableList((List<? extends WithLogId>)Preconditions.checkNotNull(param1List));
      return this;
    }
    
    public Builder setState(ConnectivityState param1ConnectivityState) {
      this.state = param1ConnectivityState;
      return this;
    }
    
    public Builder setSubchannels(List<WithLogId> param1List) {
      Preconditions.checkState(this.sockets.isEmpty());
      this.subchannels = Collections.unmodifiableList((List<? extends WithLogId>)Preconditions.checkNotNull(param1List));
      return this;
    }
    
    public Builder setTarget(String param1String) {
      this.target = param1String;
      return this;
    }
  }
  
  public static final class RootChannelList {
    public final List<Instrumented<Channelz.ChannelStats>> channels;
    
    public final boolean end;
    
    public RootChannelList(List<Instrumented<Channelz.ChannelStats>> param1List, boolean param1Boolean) {
      this.channels = (List<Instrumented<Channelz.ChannelStats>>)Preconditions.checkNotNull(param1List);
      this.end = param1Boolean;
    }
  }
  
  public static final class Security {}
  
  public static final class ServerList {
    public final boolean end;
    
    public final List<Instrumented<Channelz.ServerStats>> servers;
    
    public ServerList(List<Instrumented<Channelz.ServerStats>> param1List, boolean param1Boolean) {
      this.servers = (List<Instrumented<Channelz.ServerStats>>)Preconditions.checkNotNull(param1List);
      this.end = param1Boolean;
    }
  }
  
  private static final class ServerSocketMap extends ConcurrentSkipListMap<Long, Instrumented<SocketStats>> {
    private static final long serialVersionUID = -7883772124944661414L;
    
    private ServerSocketMap() {}
  }
  
  public static final class ServerSocketsList {
    public final boolean end;
    
    public final List<WithLogId> sockets;
    
    public ServerSocketsList(List<WithLogId> param1List, boolean param1Boolean) {
      this.sockets = param1List;
      this.end = param1Boolean;
    }
  }
  
  @Immutable
  public static final class ServerStats {
    public final long callsFailed;
    
    public final long callsStarted;
    
    public final long callsSucceeded;
    
    public final long lastCallStartedMillis;
    
    public final List<Instrumented<Channelz.SocketStats>> listenSockets;
    
    public ServerStats(long param1Long1, long param1Long2, long param1Long3, long param1Long4, List<Instrumented<Channelz.SocketStats>> param1List) {
      this.callsStarted = param1Long1;
      this.callsSucceeded = param1Long2;
      this.callsFailed = param1Long3;
      this.lastCallStartedMillis = param1Long4;
      this.listenSockets = (List<Instrumented<Channelz.SocketStats>>)Preconditions.checkNotNull(param1List);
    }
    
    public static final class Builder {
      private long callsFailed;
      
      private long callsStarted;
      
      private long callsSucceeded;
      
      private long lastCallStartedMillis;
      
      public List<Instrumented<Channelz.SocketStats>> listenSockets = Collections.emptyList();
      
      public Channelz.ServerStats build() {
        return new Channelz.ServerStats(this.callsStarted, this.callsSucceeded, this.callsFailed, this.lastCallStartedMillis, this.listenSockets);
      }
      
      public Builder setCallsFailed(long param2Long) {
        this.callsFailed = param2Long;
        return this;
      }
      
      public Builder setCallsStarted(long param2Long) {
        this.callsStarted = param2Long;
        return this;
      }
      
      public Builder setCallsSucceeded(long param2Long) {
        this.callsSucceeded = param2Long;
        return this;
      }
      
      public Builder setLastCallStartedMillis(long param2Long) {
        this.lastCallStartedMillis = param2Long;
        return this;
      }
      
      public Builder setListenSockets(List<Instrumented<Channelz.SocketStats>> param2List) {
        Preconditions.checkNotNull(param2List);
        this.listenSockets = Collections.unmodifiableList(new ArrayList<Instrumented<Channelz.SocketStats>>(param2List));
        return this;
      }
    }
  }
  
  public static final class Builder {
    private long callsFailed;
    
    private long callsStarted;
    
    private long callsSucceeded;
    
    private long lastCallStartedMillis;
    
    public List<Instrumented<Channelz.SocketStats>> listenSockets = Collections.emptyList();
    
    public Channelz.ServerStats build() {
      return new Channelz.ServerStats(this.callsStarted, this.callsSucceeded, this.callsFailed, this.lastCallStartedMillis, this.listenSockets);
    }
    
    public Builder setCallsFailed(long param1Long) {
      this.callsFailed = param1Long;
      return this;
    }
    
    public Builder setCallsStarted(long param1Long) {
      this.callsStarted = param1Long;
      return this;
    }
    
    public Builder setCallsSucceeded(long param1Long) {
      this.callsSucceeded = param1Long;
      return this;
    }
    
    public Builder setLastCallStartedMillis(long param1Long) {
      this.lastCallStartedMillis = param1Long;
      return this;
    }
    
    public Builder setListenSockets(List<Instrumented<Channelz.SocketStats>> param1List) {
      Preconditions.checkNotNull(param1List);
      this.listenSockets = Collections.unmodifiableList(new ArrayList<Instrumented<Channelz.SocketStats>>(param1List));
      return this;
    }
  }
  
  public static final class SocketOptions {
    @Nullable
    public final Integer lingerSeconds;
    
    public final Map<String, String> others;
    
    @Nullable
    public final Integer soTimeoutMillis;
    
    @Nullable
    public final Channelz.TcpInfo tcpInfo;
    
    public SocketOptions(@Nullable Integer param1Integer1, @Nullable Integer param1Integer2, @Nullable Channelz.TcpInfo param1TcpInfo, Map<String, String> param1Map) {
      Preconditions.checkNotNull(param1Map);
      this.soTimeoutMillis = param1Integer1;
      this.lingerSeconds = param1Integer2;
      this.tcpInfo = param1TcpInfo;
      this.others = Collections.unmodifiableMap(new HashMap<String, String>(param1Map));
    }
    
    public static final class Builder {
      private Integer lingerSeconds;
      
      private final Map<String, String> others = new HashMap<String, String>();
      
      private Channelz.TcpInfo tcpInfo;
      
      private Integer timeoutMillis;
      
      public Builder addOption(String param2String, int param2Int) {
        this.others.put(param2String, Integer.toString(param2Int));
        return this;
      }
      
      public Builder addOption(String param2String1, String param2String2) {
        this.others.put(param2String1, Preconditions.checkNotNull(param2String2));
        return this;
      }
      
      public Builder addOption(String param2String, boolean param2Boolean) {
        this.others.put(param2String, Boolean.toString(param2Boolean));
        return this;
      }
      
      public Channelz.SocketOptions build() {
        return new Channelz.SocketOptions(this.timeoutMillis, this.lingerSeconds, this.tcpInfo, this.others);
      }
      
      public Builder setSocketOptionLingerSeconds(Integer param2Integer) {
        this.lingerSeconds = param2Integer;
        return this;
      }
      
      public Builder setSocketOptionTimeoutMillis(Integer param2Integer) {
        this.timeoutMillis = param2Integer;
        return this;
      }
      
      public Builder setTcpInfo(Channelz.TcpInfo param2TcpInfo) {
        this.tcpInfo = param2TcpInfo;
        return this;
      }
    }
  }
  
  public static final class Builder {
    private Integer lingerSeconds;
    
    private final Map<String, String> others = new HashMap<String, String>();
    
    private Channelz.TcpInfo tcpInfo;
    
    private Integer timeoutMillis;
    
    public Builder addOption(String param1String, int param1Int) {
      this.others.put(param1String, Integer.toString(param1Int));
      return this;
    }
    
    public Builder addOption(String param1String1, String param1String2) {
      this.others.put(param1String1, Preconditions.checkNotNull(param1String2));
      return this;
    }
    
    public Builder addOption(String param1String, boolean param1Boolean) {
      this.others.put(param1String, Boolean.toString(param1Boolean));
      return this;
    }
    
    public Channelz.SocketOptions build() {
      return new Channelz.SocketOptions(this.timeoutMillis, this.lingerSeconds, this.tcpInfo, this.others);
    }
    
    public Builder setSocketOptionLingerSeconds(Integer param1Integer) {
      this.lingerSeconds = param1Integer;
      return this;
    }
    
    public Builder setSocketOptionTimeoutMillis(Integer param1Integer) {
      this.timeoutMillis = param1Integer;
      return this;
    }
    
    public Builder setTcpInfo(Channelz.TcpInfo param1TcpInfo) {
      this.tcpInfo = param1TcpInfo;
      return this;
    }
  }
  
  public static final class SocketStats {
    @Nullable
    public final Channelz.TransportStats data;
    
    public final SocketAddress local;
    
    @Nullable
    public final SocketAddress remote;
    
    @Nullable
    public final Channelz.Security security;
    
    public final Channelz.SocketOptions socketOptions;
    
    public SocketStats(Channelz.TransportStats param1TransportStats, SocketAddress param1SocketAddress1, SocketAddress param1SocketAddress2, Channelz.SocketOptions param1SocketOptions, Channelz.Security param1Security) {
      this.data = param1TransportStats;
      this.local = (SocketAddress)Preconditions.checkNotNull(param1SocketAddress1, "local socket");
      this.remote = param1SocketAddress2;
      this.socketOptions = (Channelz.SocketOptions)Preconditions.checkNotNull(param1SocketOptions);
      this.security = param1Security;
    }
  }
  
  public static final class TcpInfo {
    public final int advmss;
    
    public final int ato;
    
    public final int backoff;
    
    public final int caState;
    
    public final int fackets;
    
    public final int lastAckRecv;
    
    public final int lastAckSent;
    
    public final int lastDataRecv;
    
    public final int lastDataSent;
    
    public final int lost;
    
    public final int options;
    
    public final int pmtu;
    
    public final int probes;
    
    public final int rcvMss;
    
    public final int rcvSsthresh;
    
    public final int rcvWscale;
    
    public final int reordering;
    
    public final int retrans;
    
    public final int retransmits;
    
    public final int rto;
    
    public final int rtt;
    
    public final int rttvar;
    
    public final int sacked;
    
    public final int sndCwnd;
    
    public final int sndMss;
    
    public final int sndSsthresh;
    
    public final int sndWscale;
    
    public final int state;
    
    public final int unacked;
    
    TcpInfo(int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, int param1Int6, int param1Int7, int param1Int8, int param1Int9, int param1Int10, int param1Int11, int param1Int12, int param1Int13, int param1Int14, int param1Int15, int param1Int16, int param1Int17, int param1Int18, int param1Int19, int param1Int20, int param1Int21, int param1Int22, int param1Int23, int param1Int24, int param1Int25, int param1Int26, int param1Int27, int param1Int28, int param1Int29) {
      this.state = param1Int1;
      this.caState = param1Int2;
      this.retransmits = param1Int3;
      this.probes = param1Int4;
      this.backoff = param1Int5;
      this.options = param1Int6;
      this.sndWscale = param1Int7;
      this.rcvWscale = param1Int8;
      this.rto = param1Int9;
      this.ato = param1Int10;
      this.sndMss = param1Int11;
      this.rcvMss = param1Int12;
      this.unacked = param1Int13;
      this.sacked = param1Int14;
      this.lost = param1Int15;
      this.retrans = param1Int16;
      this.fackets = param1Int17;
      this.lastDataSent = param1Int18;
      this.lastAckSent = param1Int19;
      this.lastDataRecv = param1Int20;
      this.lastAckRecv = param1Int21;
      this.pmtu = param1Int22;
      this.rcvSsthresh = param1Int23;
      this.rtt = param1Int24;
      this.rttvar = param1Int25;
      this.sndSsthresh = param1Int26;
      this.sndCwnd = param1Int27;
      this.advmss = param1Int28;
      this.reordering = param1Int29;
    }
    
    public static final class Builder {
      private int advmss;
      
      private int ato;
      
      private int backoff;
      
      private int caState;
      
      private int fackets;
      
      private int lastAckRecv;
      
      private int lastAckSent;
      
      private int lastDataRecv;
      
      private int lastDataSent;
      
      private int lost;
      
      private int options;
      
      private int pmtu;
      
      private int probes;
      
      private int rcvMss;
      
      private int rcvSsthresh;
      
      private int rcvWscale;
      
      private int reordering;
      
      private int retrans;
      
      private int retransmits;
      
      private int rto;
      
      private int rtt;
      
      private int rttvar;
      
      private int sacked;
      
      private int sndCwnd;
      
      private int sndMss;
      
      private int sndSsthresh;
      
      private int sndWscale;
      
      private int state;
      
      private int unacked;
      
      public Channelz.TcpInfo build() {
        return new Channelz.TcpInfo(this.state, this.caState, this.retransmits, this.probes, this.backoff, this.options, this.sndWscale, this.rcvWscale, this.rto, this.ato, this.sndMss, this.rcvMss, this.unacked, this.sacked, this.lost, this.retrans, this.fackets, this.lastDataSent, this.lastAckSent, this.lastDataRecv, this.lastAckRecv, this.pmtu, this.rcvSsthresh, this.rtt, this.rttvar, this.sndSsthresh, this.sndCwnd, this.advmss, this.reordering);
      }
      
      public Builder setAdvmss(int param2Int) {
        this.advmss = param2Int;
        return this;
      }
      
      public Builder setAto(int param2Int) {
        this.ato = param2Int;
        return this;
      }
      
      public Builder setBackoff(int param2Int) {
        this.backoff = param2Int;
        return this;
      }
      
      public Builder setCaState(int param2Int) {
        this.caState = param2Int;
        return this;
      }
      
      public Builder setFackets(int param2Int) {
        this.fackets = param2Int;
        return this;
      }
      
      public Builder setLastAckRecv(int param2Int) {
        this.lastAckRecv = param2Int;
        return this;
      }
      
      public Builder setLastAckSent(int param2Int) {
        this.lastAckSent = param2Int;
        return this;
      }
      
      public Builder setLastDataRecv(int param2Int) {
        this.lastDataRecv = param2Int;
        return this;
      }
      
      public Builder setLastDataSent(int param2Int) {
        this.lastDataSent = param2Int;
        return this;
      }
      
      public Builder setLost(int param2Int) {
        this.lost = param2Int;
        return this;
      }
      
      public Builder setOptions(int param2Int) {
        this.options = param2Int;
        return this;
      }
      
      public Builder setPmtu(int param2Int) {
        this.pmtu = param2Int;
        return this;
      }
      
      public Builder setProbes(int param2Int) {
        this.probes = param2Int;
        return this;
      }
      
      public Builder setRcvMss(int param2Int) {
        this.rcvMss = param2Int;
        return this;
      }
      
      public Builder setRcvSsthresh(int param2Int) {
        this.rcvSsthresh = param2Int;
        return this;
      }
      
      public Builder setRcvWscale(int param2Int) {
        this.rcvWscale = param2Int;
        return this;
      }
      
      public Builder setReordering(int param2Int) {
        this.reordering = param2Int;
        return this;
      }
      
      public Builder setRetrans(int param2Int) {
        this.retrans = param2Int;
        return this;
      }
      
      public Builder setRetransmits(int param2Int) {
        this.retransmits = param2Int;
        return this;
      }
      
      public Builder setRto(int param2Int) {
        this.rto = param2Int;
        return this;
      }
      
      public Builder setRtt(int param2Int) {
        this.rtt = param2Int;
        return this;
      }
      
      public Builder setRttvar(int param2Int) {
        this.rttvar = param2Int;
        return this;
      }
      
      public Builder setSacked(int param2Int) {
        this.sacked = param2Int;
        return this;
      }
      
      public Builder setSndCwnd(int param2Int) {
        this.sndCwnd = param2Int;
        return this;
      }
      
      public Builder setSndMss(int param2Int) {
        this.sndMss = param2Int;
        return this;
      }
      
      public Builder setSndSsthresh(int param2Int) {
        this.sndSsthresh = param2Int;
        return this;
      }
      
      public Builder setSndWscale(int param2Int) {
        this.sndWscale = param2Int;
        return this;
      }
      
      public Builder setState(int param2Int) {
        this.state = param2Int;
        return this;
      }
      
      public Builder setUnacked(int param2Int) {
        this.unacked = param2Int;
        return this;
      }
    }
  }
  
  public static final class Builder {
    private int advmss;
    
    private int ato;
    
    private int backoff;
    
    private int caState;
    
    private int fackets;
    
    private int lastAckRecv;
    
    private int lastAckSent;
    
    private int lastDataRecv;
    
    private int lastDataSent;
    
    private int lost;
    
    private int options;
    
    private int pmtu;
    
    private int probes;
    
    private int rcvMss;
    
    private int rcvSsthresh;
    
    private int rcvWscale;
    
    private int reordering;
    
    private int retrans;
    
    private int retransmits;
    
    private int rto;
    
    private int rtt;
    
    private int rttvar;
    
    private int sacked;
    
    private int sndCwnd;
    
    private int sndMss;
    
    private int sndSsthresh;
    
    private int sndWscale;
    
    private int state;
    
    private int unacked;
    
    public Channelz.TcpInfo build() {
      return new Channelz.TcpInfo(this.state, this.caState, this.retransmits, this.probes, this.backoff, this.options, this.sndWscale, this.rcvWscale, this.rto, this.ato, this.sndMss, this.rcvMss, this.unacked, this.sacked, this.lost, this.retrans, this.fackets, this.lastDataSent, this.lastAckSent, this.lastDataRecv, this.lastAckRecv, this.pmtu, this.rcvSsthresh, this.rtt, this.rttvar, this.sndSsthresh, this.sndCwnd, this.advmss, this.reordering);
    }
    
    public Builder setAdvmss(int param1Int) {
      this.advmss = param1Int;
      return this;
    }
    
    public Builder setAto(int param1Int) {
      this.ato = param1Int;
      return this;
    }
    
    public Builder setBackoff(int param1Int) {
      this.backoff = param1Int;
      return this;
    }
    
    public Builder setCaState(int param1Int) {
      this.caState = param1Int;
      return this;
    }
    
    public Builder setFackets(int param1Int) {
      this.fackets = param1Int;
      return this;
    }
    
    public Builder setLastAckRecv(int param1Int) {
      this.lastAckRecv = param1Int;
      return this;
    }
    
    public Builder setLastAckSent(int param1Int) {
      this.lastAckSent = param1Int;
      return this;
    }
    
    public Builder setLastDataRecv(int param1Int) {
      this.lastDataRecv = param1Int;
      return this;
    }
    
    public Builder setLastDataSent(int param1Int) {
      this.lastDataSent = param1Int;
      return this;
    }
    
    public Builder setLost(int param1Int) {
      this.lost = param1Int;
      return this;
    }
    
    public Builder setOptions(int param1Int) {
      this.options = param1Int;
      return this;
    }
    
    public Builder setPmtu(int param1Int) {
      this.pmtu = param1Int;
      return this;
    }
    
    public Builder setProbes(int param1Int) {
      this.probes = param1Int;
      return this;
    }
    
    public Builder setRcvMss(int param1Int) {
      this.rcvMss = param1Int;
      return this;
    }
    
    public Builder setRcvSsthresh(int param1Int) {
      this.rcvSsthresh = param1Int;
      return this;
    }
    
    public Builder setRcvWscale(int param1Int) {
      this.rcvWscale = param1Int;
      return this;
    }
    
    public Builder setReordering(int param1Int) {
      this.reordering = param1Int;
      return this;
    }
    
    public Builder setRetrans(int param1Int) {
      this.retrans = param1Int;
      return this;
    }
    
    public Builder setRetransmits(int param1Int) {
      this.retransmits = param1Int;
      return this;
    }
    
    public Builder setRto(int param1Int) {
      this.rto = param1Int;
      return this;
    }
    
    public Builder setRtt(int param1Int) {
      this.rtt = param1Int;
      return this;
    }
    
    public Builder setRttvar(int param1Int) {
      this.rttvar = param1Int;
      return this;
    }
    
    public Builder setSacked(int param1Int) {
      this.sacked = param1Int;
      return this;
    }
    
    public Builder setSndCwnd(int param1Int) {
      this.sndCwnd = param1Int;
      return this;
    }
    
    public Builder setSndMss(int param1Int) {
      this.sndMss = param1Int;
      return this;
    }
    
    public Builder setSndSsthresh(int param1Int) {
      this.sndSsthresh = param1Int;
      return this;
    }
    
    public Builder setSndWscale(int param1Int) {
      this.sndWscale = param1Int;
      return this;
    }
    
    public Builder setState(int param1Int) {
      this.state = param1Int;
      return this;
    }
    
    public Builder setUnacked(int param1Int) {
      this.unacked = param1Int;
      return this;
    }
  }
  
  @Immutable
  public static final class TransportStats {
    public final long keepAlivesSent;
    
    public final long lastLocalStreamCreatedTimeNanos;
    
    public final long lastMessageReceivedTimeNanos;
    
    public final long lastMessageSentTimeNanos;
    
    public final long lastRemoteStreamCreatedTimeNanos;
    
    public final long localFlowControlWindow;
    
    public final long messagesReceived;
    
    public final long messagesSent;
    
    public final long remoteFlowControlWindow;
    
    public final long streamsFailed;
    
    public final long streamsStarted;
    
    public final long streamsSucceeded;
    
    public TransportStats(long param1Long1, long param1Long2, long param1Long3, long param1Long4, long param1Long5, long param1Long6, long param1Long7, long param1Long8, long param1Long9, long param1Long10, long param1Long11, long param1Long12) {
      this.streamsStarted = param1Long1;
      this.lastLocalStreamCreatedTimeNanos = param1Long2;
      this.lastRemoteStreamCreatedTimeNanos = param1Long3;
      this.streamsSucceeded = param1Long4;
      this.streamsFailed = param1Long5;
      this.messagesSent = param1Long6;
      this.messagesReceived = param1Long7;
      this.keepAlivesSent = param1Long8;
      this.lastMessageSentTimeNanos = param1Long9;
      this.lastMessageReceivedTimeNanos = param1Long10;
      this.localFlowControlWindow = param1Long11;
      this.remoteFlowControlWindow = param1Long12;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\Channelz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */