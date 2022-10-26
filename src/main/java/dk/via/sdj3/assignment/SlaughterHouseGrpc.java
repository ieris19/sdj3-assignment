package dk.via.sdj3.assignment;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: slaughterhouse.proto")
public final class SlaughterHouseGrpc {

  private SlaughterHouseGrpc() {}

  public static final String SERVICE_NAME = "slaughterhouse.SlaughterHouse";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<dk.via.sdj3.assignment.IdQuery,
      dk.via.sdj3.assignment.AnimalList> getGetAnimalsInProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAnimalsInProduct",
      requestType = dk.via.sdj3.assignment.IdQuery.class,
      responseType = dk.via.sdj3.assignment.AnimalList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dk.via.sdj3.assignment.IdQuery,
      dk.via.sdj3.assignment.AnimalList> getGetAnimalsInProductMethod() {
    io.grpc.MethodDescriptor<dk.via.sdj3.assignment.IdQuery, dk.via.sdj3.assignment.AnimalList> getGetAnimalsInProductMethod;
    if ((getGetAnimalsInProductMethod = SlaughterHouseGrpc.getGetAnimalsInProductMethod) == null) {
      synchronized (SlaughterHouseGrpc.class) {
        if ((getGetAnimalsInProductMethod = SlaughterHouseGrpc.getGetAnimalsInProductMethod) == null) {
          SlaughterHouseGrpc.getGetAnimalsInProductMethod = getGetAnimalsInProductMethod =
              io.grpc.MethodDescriptor.<dk.via.sdj3.assignment.IdQuery, dk.via.sdj3.assignment.AnimalList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAnimalsInProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dk.via.sdj3.assignment.IdQuery.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dk.via.sdj3.assignment.AnimalList.getDefaultInstance()))
              .setSchemaDescriptor(new SlaughterHouseMethodDescriptorSupplier("getAnimalsInProduct"))
              .build();
        }
      }
    }
    return getGetAnimalsInProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<dk.via.sdj3.assignment.IdQuery,
      dk.via.sdj3.assignment.ProductsList> getWhereAnimalHasBeenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "whereAnimalHasBeen",
      requestType = dk.via.sdj3.assignment.IdQuery.class,
      responseType = dk.via.sdj3.assignment.ProductsList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dk.via.sdj3.assignment.IdQuery,
      dk.via.sdj3.assignment.ProductsList> getWhereAnimalHasBeenMethod() {
    io.grpc.MethodDescriptor<dk.via.sdj3.assignment.IdQuery, dk.via.sdj3.assignment.ProductsList> getWhereAnimalHasBeenMethod;
    if ((getWhereAnimalHasBeenMethod = SlaughterHouseGrpc.getWhereAnimalHasBeenMethod) == null) {
      synchronized (SlaughterHouseGrpc.class) {
        if ((getWhereAnimalHasBeenMethod = SlaughterHouseGrpc.getWhereAnimalHasBeenMethod) == null) {
          SlaughterHouseGrpc.getWhereAnimalHasBeenMethod = getWhereAnimalHasBeenMethod =
              io.grpc.MethodDescriptor.<dk.via.sdj3.assignment.IdQuery, dk.via.sdj3.assignment.ProductsList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "whereAnimalHasBeen"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dk.via.sdj3.assignment.IdQuery.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dk.via.sdj3.assignment.ProductsList.getDefaultInstance()))
              .setSchemaDescriptor(new SlaughterHouseMethodDescriptorSupplier("whereAnimalHasBeen"))
              .build();
        }
      }
    }
    return getWhereAnimalHasBeenMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SlaughterHouseStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SlaughterHouseStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SlaughterHouseStub>() {
        @java.lang.Override
        public SlaughterHouseStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SlaughterHouseStub(channel, callOptions);
        }
      };
    return SlaughterHouseStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SlaughterHouseBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SlaughterHouseBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SlaughterHouseBlockingStub>() {
        @java.lang.Override
        public SlaughterHouseBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SlaughterHouseBlockingStub(channel, callOptions);
        }
      };
    return SlaughterHouseBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SlaughterHouseFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SlaughterHouseFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SlaughterHouseFutureStub>() {
        @java.lang.Override
        public SlaughterHouseFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SlaughterHouseFutureStub(channel, callOptions);
        }
      };
    return SlaughterHouseFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SlaughterHouseImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAnimalsInProduct(dk.via.sdj3.assignment.IdQuery request,
        io.grpc.stub.StreamObserver<dk.via.sdj3.assignment.AnimalList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAnimalsInProductMethod(), responseObserver);
    }

    /**
     */
    public void whereAnimalHasBeen(dk.via.sdj3.assignment.IdQuery request,
        io.grpc.stub.StreamObserver<dk.via.sdj3.assignment.ProductsList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWhereAnimalHasBeenMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAnimalsInProductMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                dk.via.sdj3.assignment.IdQuery,
                dk.via.sdj3.assignment.AnimalList>(
                  this, METHODID_GET_ANIMALS_IN_PRODUCT)))
          .addMethod(
            getWhereAnimalHasBeenMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                dk.via.sdj3.assignment.IdQuery,
                dk.via.sdj3.assignment.ProductsList>(
                  this, METHODID_WHERE_ANIMAL_HAS_BEEN)))
          .build();
    }
  }

  /**
   */
  public static final class SlaughterHouseStub extends io.grpc.stub.AbstractAsyncStub<SlaughterHouseStub> {
    private SlaughterHouseStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SlaughterHouseStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SlaughterHouseStub(channel, callOptions);
    }

    /**
     */
    public void getAnimalsInProduct(dk.via.sdj3.assignment.IdQuery request,
        io.grpc.stub.StreamObserver<dk.via.sdj3.assignment.AnimalList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAnimalsInProductMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void whereAnimalHasBeen(dk.via.sdj3.assignment.IdQuery request,
        io.grpc.stub.StreamObserver<dk.via.sdj3.assignment.ProductsList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getWhereAnimalHasBeenMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SlaughterHouseBlockingStub extends io.grpc.stub.AbstractBlockingStub<SlaughterHouseBlockingStub> {
    private SlaughterHouseBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SlaughterHouseBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SlaughterHouseBlockingStub(channel, callOptions);
    }

    /**
     */
    public dk.via.sdj3.assignment.AnimalList getAnimalsInProduct(dk.via.sdj3.assignment.IdQuery request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAnimalsInProductMethod(), getCallOptions(), request);
    }

    /**
     */
    public dk.via.sdj3.assignment.ProductsList whereAnimalHasBeen(dk.via.sdj3.assignment.IdQuery request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getWhereAnimalHasBeenMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SlaughterHouseFutureStub extends io.grpc.stub.AbstractFutureStub<SlaughterHouseFutureStub> {
    private SlaughterHouseFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SlaughterHouseFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SlaughterHouseFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dk.via.sdj3.assignment.AnimalList> getAnimalsInProduct(
        dk.via.sdj3.assignment.IdQuery request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAnimalsInProductMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dk.via.sdj3.assignment.ProductsList> whereAnimalHasBeen(
        dk.via.sdj3.assignment.IdQuery request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getWhereAnimalHasBeenMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ANIMALS_IN_PRODUCT = 0;
  private static final int METHODID_WHERE_ANIMAL_HAS_BEEN = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SlaughterHouseImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SlaughterHouseImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ANIMALS_IN_PRODUCT:
          serviceImpl.getAnimalsInProduct((dk.via.sdj3.assignment.IdQuery) request,
              (io.grpc.stub.StreamObserver<dk.via.sdj3.assignment.AnimalList>) responseObserver);
          break;
        case METHODID_WHERE_ANIMAL_HAS_BEEN:
          serviceImpl.whereAnimalHasBeen((dk.via.sdj3.assignment.IdQuery) request,
              (io.grpc.stub.StreamObserver<dk.via.sdj3.assignment.ProductsList>) responseObserver);
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

  private static abstract class SlaughterHouseBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SlaughterHouseBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return dk.via.sdj3.assignment.Slaughterhouse.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SlaughterHouse");
    }
  }

  private static final class SlaughterHouseFileDescriptorSupplier
      extends SlaughterHouseBaseDescriptorSupplier {
    SlaughterHouseFileDescriptorSupplier() {}
  }

  private static final class SlaughterHouseMethodDescriptorSupplier
      extends SlaughterHouseBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SlaughterHouseMethodDescriptorSupplier(String methodName) {
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
      synchronized (SlaughterHouseGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SlaughterHouseFileDescriptorSupplier())
              .addMethod(getGetAnimalsInProductMethod())
              .addMethod(getWhereAnimalHasBeenMethod())
              .build();
        }
      }
    }
    return result;
  }
}
