package dk.via.sdj3.assignment.grpc.service;

import dk.via.sdj3.assignment.grpc.proto.QueryId;
import dk.via.sdj3.assignment.grpc.proto.ResponseIds;
import dk.via.sdj3.assignment.grpc.proto.SlaughterhouseServiceGrpc;
import io.grpc.stub.StreamObserver;

/**
 * This class implements the gRPC service for the slaughterhouse.
 */
public class SlaughterhouseServiceImpl extends SlaughterhouseServiceGrpc.SlaughterhouseServiceImplBase {
	/**
	 * This method is called when the client sends a request to the server to get the ids of all animals involved in a
	 * specific product.
	 *
	 * @param request          The id of the product.
	 * @param responseObserver The response observer to send the response to.
	 */
	@Override public void getAnimalsFor(QueryId request, StreamObserver<ResponseIds> responseObserver) {
		responseObserver.onNext(processRequest(request, "product"));
		responseObserver.onCompleted();
	}

	/**
	 * This method is called when the client sends a request to the server to get the ids of all products involving a
	 * specific animal.
	 *
	 * @param request          The id of the animal.
	 * @param responseObserver The response observer to send the response to.
	 */
	@Override public void getProductsFor(QueryId request, StreamObserver<ResponseIds> responseObserver) {
		responseObserver.onNext(processRequest(request, "animal"));
		responseObserver.onCompleted();
	}

	/**
	 * This method is called to process server requests.
	 */
	private ResponseIds processRequest(QueryId request, String table) {
		long id = request.getIdentificationNumber();
		String col = switch (table) {
			case "animal" -> "animal_id";
			case "product" -> "product_id";
			default -> throw new IllegalArgumentException("Unexpected value: " + table);
		};
		String sql = String.format("SELECT %1$s FROM %2$s WHERE %3$s = %4$s;", col, table, col, id);
		return ResponseIds.newBuilder().build();
	}
}
