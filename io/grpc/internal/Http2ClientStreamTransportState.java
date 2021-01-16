package io.grpc.internal;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import io.grpc.InternalMetadata;
import io.grpc.InternalStatus;
import io.grpc.Metadata;
import io.grpc.Status;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

public abstract class Http2ClientStreamTransportState extends AbstractClientStream.TransportState {
  private static final Metadata.Key<Integer> HTTP2_STATUS;
  
  private static final InternalMetadata.TrustedAsciiMarshaller<Integer> HTTP_STATUS_MARSHALLER = new InternalMetadata.TrustedAsciiMarshaller<Integer>() {
      public Integer parseAsciiString(byte[] param1ArrayOfbyte) {
        if (param1ArrayOfbyte.length >= 3)
          return Integer.valueOf((param1ArrayOfbyte[0] - 48) * 100 + (param1ArrayOfbyte[1] - 48) * 10 + param1ArrayOfbyte[2] - 48); 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Malformed status code ");
        stringBuilder.append(new String(param1ArrayOfbyte, InternalMetadata.US_ASCII));
        throw new NumberFormatException(stringBuilder.toString());
      }
      
      public byte[] toAsciiString(Integer param1Integer) {
        throw new UnsupportedOperationException();
      }
    };
  
  private Charset errorCharset = Charsets.UTF_8;
  
  private boolean headersReceived;
  
  private Status transportError;
  
  private Metadata transportErrorMetadata;
  
  static {
    HTTP2_STATUS = InternalMetadata.keyOf(":status", HTTP_STATUS_MARSHALLER);
  }
  
  protected Http2ClientStreamTransportState(int paramInt, StatsTraceContext paramStatsTraceContext, TransportTracer paramTransportTracer) {
    super(paramInt, paramStatsTraceContext, paramTransportTracer);
  }
  
  private static Charset extractCharset(Metadata paramMetadata) {
    String str = (String)paramMetadata.get(GrpcUtil.CONTENT_TYPE_KEY);
    if (str != null) {
      String[] arrayOfString = str.split("charset=", 2);
      try {
        return Charset.forName(arrayOfString[arrayOfString.length - 1].trim());
      } catch (Exception exception) {}
    } 
    return Charsets.UTF_8;
  }
  
  private Status statusFromTrailers(Metadata paramMetadata) {
    Status status1;
    Status status2 = (Status)paramMetadata.get(InternalStatus.CODE_KEY);
    if (status2 != null)
      return status2.withDescription((String)paramMetadata.get(InternalStatus.MESSAGE_KEY)); 
    if (this.headersReceived)
      return Status.UNKNOWN.withDescription("missing GRPC status in response"); 
    Integer integer = (Integer)paramMetadata.get(HTTP2_STATUS);
    if (integer != null) {
      status1 = GrpcUtil.httpStatusToGrpcStatus(integer.intValue());
    } else {
      status1 = Status.INTERNAL.withDescription("missing HTTP status code");
    } 
    return status1.augmentDescription("missing GRPC status, inferred error from HTTP status code");
  }
  
  private static void stripTransportDetails(Metadata paramMetadata) {
    paramMetadata.discardAll(HTTP2_STATUS);
    paramMetadata.discardAll(InternalStatus.CODE_KEY);
    paramMetadata.discardAll(InternalStatus.MESSAGE_KEY);
  }
  
  @Nullable
  private Status validateInitialMetadata(Metadata paramMetadata) {
    Integer integer = (Integer)paramMetadata.get(HTTP2_STATUS);
    if (integer == null)
      return Status.INTERNAL.withDescription("Missing HTTP status code"); 
    String str = (String)paramMetadata.get(GrpcUtil.CONTENT_TYPE_KEY);
    if (!GrpcUtil.isGrpcContentType(str)) {
      Status status = GrpcUtil.httpStatusToGrpcStatus(integer.intValue());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("invalid content-type: ");
      stringBuilder.append(str);
      return status.augmentDescription(stringBuilder.toString());
    } 
    return null;
  }
  
  protected abstract void http2ProcessingFailed(Status paramStatus, boolean paramBoolean, Metadata paramMetadata);
  
  protected void transportDataReceived(ReadableBuffer paramReadableBuffer, boolean paramBoolean) {
    Status status = this.transportError;
    if (status != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("DATA-----------------------------\n");
      stringBuilder.append(ReadableBuffers.readAsString(paramReadableBuffer, this.errorCharset));
      this.transportError = status.augmentDescription(stringBuilder.toString());
      paramReadableBuffer.close();
      if (this.transportError.getDescription().length() > 1000 || paramBoolean)
        http2ProcessingFailed(this.transportError, false, this.transportErrorMetadata); 
    } else {
      if (!this.headersReceived) {
        http2ProcessingFailed(Status.INTERNAL.withDescription("headers not received before payload"), false, new Metadata());
        return;
      } 
      inboundDataReceived(paramReadableBuffer);
      if (paramBoolean) {
        this.transportError = Status.INTERNAL.withDescription("Received unexpected EOS on DATA frame from server.");
        this.transportErrorMetadata = new Metadata();
        transportReportStatus(this.transportError, false, this.transportErrorMetadata);
      } 
    } 
  }
  
  protected void transportHeadersReceived(Metadata paramMetadata) {
    Preconditions.checkNotNull(paramMetadata, "headers");
    Status status = this.transportError;
    if (status != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("headers: ");
      stringBuilder.append(paramMetadata);
      this.transportError = status.augmentDescription(stringBuilder.toString());
      return;
    } 
    try {
      if (this.headersReceived) {
        this.transportError = Status.INTERNAL.withDescription("Received headers twice");
        return;
      } 
      Integer integer = (Integer)paramMetadata.get(HTTP2_STATUS);
      if (integer != null && integer.intValue() >= 100) {
        int i = integer.intValue();
        if (i < 200)
          return; 
      } 
      this.headersReceived = true;
      this.transportError = validateInitialMetadata(paramMetadata);
      Status status1 = this.transportError;
      if (status1 != null)
        return; 
      stripTransportDetails(paramMetadata);
      inboundHeadersReceived(paramMetadata);
      return;
    } finally {
      Status status1 = this.transportError;
      if (status1 != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("headers: ");
        stringBuilder.append(paramMetadata);
        this.transportError = status1.augmentDescription(stringBuilder.toString());
        this.transportErrorMetadata = paramMetadata;
        this.errorCharset = extractCharset(paramMetadata);
      } 
    } 
  }
  
  protected void transportTrailersReceived(Metadata paramMetadata) {
    Preconditions.checkNotNull(paramMetadata, "trailers");
    if (this.transportError == null && !this.headersReceived) {
      this.transportError = validateInitialMetadata(paramMetadata);
      if (this.transportError != null)
        this.transportErrorMetadata = paramMetadata; 
    } 
    Status status = this.transportError;
    if (status != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("trailers: ");
      stringBuilder.append(paramMetadata);
      this.transportError = status.augmentDescription(stringBuilder.toString());
      http2ProcessingFailed(this.transportError, false, this.transportErrorMetadata);
    } else {
      status = statusFromTrailers(paramMetadata);
      stripTransportDetails(paramMetadata);
      inboundTrailersReceived(paramMetadata, status);
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\Http2ClientStreamTransportState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */