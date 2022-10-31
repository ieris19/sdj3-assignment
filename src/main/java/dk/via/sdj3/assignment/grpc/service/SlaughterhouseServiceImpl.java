package dk.via.sdj3.assignment.grpc.service;

import dk.via.sdj3.assignment.AssignmentApplication;
import dk.via.sdj3.assignment.grpc.proto.QueryId;
import dk.via.sdj3.assignment.grpc.proto.ResponseIds;
import dk.via.sdj3.assignment.grpc.proto.SlaughterhouseServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.sql.SQLException;

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
		responseObserver.onNext(processRequest(request, "animal"));
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
		responseObserver.onNext(processRequest(request, "product"));
		responseObserver.onCompleted();
	}

	/**
	 * This method is called to process server requests.
	 */
	private ResponseIds processRequest(QueryId request, String returned) {
		long id = request.getIdentificationNumber();
		String colToGet; // column to get
		String colToCompare; // column to compare
		switch (returned) {
			case "animal" -> {colToGet = "animalId"; colToCompare = "productId";}
			case "product" -> {colToGet = "productId"; colToCompare = "animalId";}
			default -> throw new IllegalArgumentException("Unexpected value: " + returned);
		}

		//String sql = String.format("SELECT %1$s FROM AnimalInProduct WHERE %2$s = %3$s;", colToGet, colToCompare, id);
		var response = ResponseIds.newBuilder();

		try {
			var connection = AssignmentApplication.database.getConnection();
			var statement = connection.prepareStatement("SELECT ? FROM AnimalInProduct WHERE ? = ?");
			statement.setString(1, colToGet);
			statement.setString(2, colToCompare);
			statement.setLong(3, id);

			var queriedResults = statement.executeQuery();
			while (queriedResults.next()) {
				response.addIdentificationNumber(queriedResults.getLong(colToGet));
			}
		} catch (SQLException e) {
			System.out.println("Database SQL Error!");
		}

		return response.build();
	}
}
