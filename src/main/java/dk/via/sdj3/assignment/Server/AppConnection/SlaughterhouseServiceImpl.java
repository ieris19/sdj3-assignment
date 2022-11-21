package dk.via.sdj3.assignment.Server.AppConnection;

import dk.via.sdj3.assignment.database.DatabaseConnection;
import dk.via.sdj3.assignment.grpc.proto.QueryId;
import dk.via.sdj3.assignment.grpc.proto.ResponseIds;
import dk.via.sdj3.assignment.Server.DBConnection.SQL;
import dk.via.sdj3.assignment.grpc.proto.SlaughterhouseServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class implements the gRPC service for the slaughterhouse.
 */
@GRpcService
@Configuration
public class SlaughterhouseServiceImpl extends SlaughterhouseServiceGrpc.SlaughterhouseServiceImplBase {
	public SlaughterhouseServiceImpl(SQL sql) {
		this.sql = sql;
	}

	public SlaughterhouseServiceImpl() {
	}

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
	protected ResponseIds processRequest(QueryId request, String returned) {
		long id = request.getIdentificationNumber();
		String colToGet; // column to get
		String colToCompare; // column to compare
		switch (returned) {
			case "animal" -> {colToGet = "animalid"; colToCompare = "productid";}
			case "product" -> {colToGet = "productid"; colToCompare = "animalid";}
			default -> throw new IllegalArgumentException("Unexpected value: " + returned);
		}

		String sqlStatement = String.format("SELECT '%1$s' FROM animalinproduct WHERE '%2$s' = '%3$s';", colToGet, colToCompare, id);
		System.out.println(sqlStatement);
		ResponseIds.Builder response = ResponseIds.newBuilder();
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement("SELECT ? FROM AnimalInProduct WHERE ? = ?");
			statement.setString(1, colToGet);
			statement.setString(2, colToCompare);
			statement.setLong(3, id);
			System.out.println(statement);
			ResultSet queriedResults = statement.executeQuery();
			while (queriedResults.next()) {
				response.addIdentificationNumber(queriedResults.getLong(colToGet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database SQL Error!");
		}

		return response.build();
	}
}
