package dk.via.sdj3.assignment.grpc.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: slaughterhouse.proto")
public final class SlaughterhouseServiceGrpc {

  private SlaughterhouseServiceGrpc() {}

  public static final String SERVICE_NAME = "SlaughterhouseService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<dk.via.sdj3.assignment.grpc.proto.QueryId,
      dk.via.sdj3.assignment.grpc.proto.ResponseIds> getGetAnimalsForMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAnimalsFor",
      requestType = dk.via.sdj3.assignment.grpc.proto.QueryId.class,
      responseType = dk.via.sdj3.assignment.grpc.proto.ResponseIds.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dk.via.sdj3.assignment.grpc.proto.QueryId,
      dk.via.sdj3.assignment.grpc.proto.ResponseIds> getGetAnimalsForMethod() {
    io.grpc.MethodDescriptor<dk.via.sdj3.assignment.grpc.proto.QueryId, dk.via.sdj3.assignment.grpc.proto.ResponseIds> getGetAnimalsForMethod;
    if ((getGetAnimalsForMethod = SlaughterhouseServiceGrpc.getGetAnimalsForMethod) == null) {
      synchronized (SlaughterhouseServiceGrpc.class) {
        if ((getGetAnimalsForMethod = SlaughterhouseServiceGrpc.getGetAnimalsForMethod) == null) {
          SlaughterhouseServiceGrpc.getGetAnimalsForMethod = getGetAnimalsForMethod =
              io.grpc.MethodDescriptor.<dk.via.sdj3.assignment.grpc.proto.QueryId, dk.via.sdj3.assignment.grpc.proto.ResponseIds>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAnimalsFor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dk.via.sdj3.assignment.grpc.proto.QueryId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dk.via.sdj3.assignment.grpc.proto.ResponseIds.getDefaultInstance()))
              .setSchemaDescriptor(new SlaughterhouseServiceMethodDescriptorSupplier("getAnimalsFor"))
              .build();
        }
      }
    }
    return getGetAnimalsForMethod;
  }

  private static volatile io.grpc.MethodDescriptor<dk.via.sdj3.assignment.grpc.proto.QueryId,
      dk.via.sdj3.assignment.grpc.proto.ResponseIds> getGetProductsForMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getProductsFor",
      requestType = dk.via.sdj3.assignment.grpc.proto.QueryId.class,
      responseType = dk.via.sdj3.assignment.grpc.proto.ResponseIds.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dk.via.sdj3.assignment.grpc.proto.QueryId,
      dk.via.sdj3.assignment.grpc.proto.ResponseIds> getGetProductsForMethod() {
    io.grpc.MethodDescriptor<dk.via.sdj3.assignment.grpc.proto.QueryId, dk.via.sdj3.assignment.grpc.proto.ResponseIds> getGetProductsForMethod;
    if ((getGetProductsForMethod = SlaughterhouseServiceGrpc.getGetProductsForMethod) == null) {
      synchronized (SlaughterhouseServiceGrpc.class) {
        if ((getGetProductsForMethod = SlaughterhouseServiceGrpc.getGetProductsForMethod) == null) {
          SlaughterhouseServiceGrpc.getGetProductsForMethod = getGetProductsForMethod =
              io.grpc.MethodDescriptor.<dk.via.sdj3.assignment.grpc.proto.QueryId, dk.via.sdj3.assignment.grpc.proto.ResponseIds>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getProductsFor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dk.via.sdj3.assignment.grpc.proto.QueryId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dk.via.sdj3.assignment.grpc.proto.ResponseIds.getDefaultInstance()))
              .setSchemaDescriptor(new SlaughterhouseServiceMethodDescriptorSupplier("getProductsFor"))
              .build();
        }
      }
    }
    return getGetProductsForMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SlaughterhouseServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceStub>() {
        @java.lang.Override
        public SlaughterhouseServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SlaughterhouseServiceStub(channel, callOptions);
        }
      };
    return SlaughterhouseServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SlaughterhouseServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceBlockingStub>() {
        @java.lang.Override
        public SlaughterhouseServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SlaughterhouseServiceBlockingStub(channel, callOptions);
        }
      };
    return SlaughterhouseServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SlaughterhouseServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceFutureStub>() {
        @java.lang.Override
        public SlaughterhouseServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SlaughterhouseServiceFutureStub(channel, callOptions);
        }
      };
    return SlaughterhouseServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SlaughterhouseServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAnimalsFor(dk.via.sdj3.assignment.grpc.proto.QueryId request,
        io.grpc.stub.StreamObserver<dk.via.sdj3.assignment.grpc.proto.ResponseIds> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAnimalsForMethod(), responseObserver);
    }

    /**
     */
    public void getProductsFor(dk.via.sdj3.assignment.grpc.proto.QueryId request,
        io.grpc.stub.StreamObserver<dk.via.sdj3.assignment.grpc.proto.ResponseIds> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProductsForMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAnimalsForMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                dk.via.sdj3.assignment.grpc.proto.QueryId,
                dk.via.sdj3.assignment.grpc.proto.ResponseIds>(
                  this, METHODID_GET_ANIMALS_FOR)))
          .addMethod(
            getGetProductsForMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                dk.via.sdj3.assignment.grpc.proto.QueryId,
                dk.via.sdj3.assignment.grpc.proto.ResponseIds>(
                  this, METHODID_GET_PRODUCTS_FOR)))
          .build();
    }
  }

  /**
   */
  public static final class SlaughterhouseServiceStub extends io.grpc.stub.AbstractAsyncStub<SlaughterhouseServiceStub> {
    private SlaughterhouseServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SlaughterhouseServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SlaughterhouseServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAnimalsFor(dk.via.sdj3.assignment.grpc.proto.QueryId request,
        io.grpc.stub.StreamObserver<dk.via.sdj3.assignment.grpc.proto.ResponseIds> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAnimalsForMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getProductsFor(dk.via.sdj3.assignment.grpc.proto.QueryId request,
        io.grpc.stub.StreamObserver<dk.via.sdj3.assignment.grpc.proto.ResponseIds> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProductsForMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SlaughterhouseServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SlaughterhouseServiceBlockingStub> {
    private SlaughterhouseServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SlaughterhouseServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SlaughterhouseServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public dk.via.sdj3.assignment.grpc.proto.ResponseIds getAnimalsFor(dk.via.sdj3.assignment.grpc.proto.QueryId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAnimalsForMethod(), getCallOptions(), request);
    }

    /**
     */
    public dk.via.sdj3.assignment.grpc.proto.ResponseIds getProductsFor(dk.via.sdj3.assignment.grpc.proto.QueryId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProductsForMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SlaughterhouseServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SlaughterhouseServiceFutureStub> {
    private SlaughterhouseServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SlaughterhouseServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SlaughterhouseServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dk.via.sdj3.assignment.grpc.proto.ResponseIds> getAnimalsFor(
        dk.via.sdj3.assignment.grpc.proto.QueryId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAnimalsForMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dk.via.sdj3.assignment.grpc.proto.ResponseIds> getProductsFor(
        dk.via.sdj3.assignment.grpc.proto.QueryId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProductsForMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ANIMALS_FOR = 0;
  private static final int METHODID_GET_PRODUCTS_FOR = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SlaughterhouseServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SlaughterhouseServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ANIMALS_FOR:
          serviceImpl.getAnimalsFor((dk.via.sdj3.assignment.grpc.proto.QueryId) request,
              (io.grpc.stub.StreamObserver<dk.via.sdj3.assignment.grpc.proto.ResponseIds>) responseObserver);
          break;
        case METHODID_GET_PRODUCTS_FOR:
          serviceImpl.getProductsFor((dk.via.sdj3.assignment.grpc.proto.QueryId) request,
              (io.grpc.stub.StreamObserver<dk.via.sdj3.assignment.grpc.proto.ResponseIds>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SlaughterhouseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SlaughterhouseServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return dk.via.sdj3.assignment.grpc.proto.Slaughterhouse.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SlaughterhouseService");
    }
  }

  private static final class SlaughterhouseServiceFileDescriptorSupplier
      extends SlaughterhouseServiceBaseDescriptorSupplier {
    SlaughterhouseServiceFileDescriptorSupplier() {}
  }

  private static final class SlaughterhouseServiceMethodDescriptorSupplier
      extends SlaughterhouseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SlaughterhouseServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SlaughterhouseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SlaughterhouseServiceFileDescriptorSupplier())
              .addMethod(getGetAnimalsForMethod())
              .addMethod(getGetProductsForMethod())
              .build();
        }
      }
    }
    return result;
  }
}
