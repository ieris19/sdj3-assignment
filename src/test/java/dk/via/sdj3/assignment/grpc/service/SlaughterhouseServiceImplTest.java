package dk.via.sdj3.assignment.grpc.service;

import dk.via.sdj3.assignment.grpc.proto.QueryId;
import dk.via.sdj3.assignment.grpc.proto.ResponseIds;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SlaughterhouseServiceTest {
	private static long sampleAnimalID;
	private static long sampleProductID;
	private static SlaughterhouseServiceImpl service;

	@BeforeAll static void setUp() {
		service = new SlaughterhouseServiceImpl();
		sampleAnimalID = 1231214;
		sampleProductID = 124151;
	}

	@Test void getProductFromAnimal() {
		QueryId id = QueryId.newBuilder().setIdentificationNumber(sampleAnimalID).build();
		ResponseIds response = service.processRequest(id, "animal");
		long[] ids = response.getIdentificationNumberList().stream().mapToLong(Long::longValue).toArray();
		System.out.println("Response: {" + "Length: " + ids.length + " Contents: " + Arrays.toString(ids) + "}");
		assertEquals(1, ids.length);
		assertEquals(sampleProductID, ids[0]);
	}

	@Test void getAnimalFromProduct() {
		QueryId id = QueryId.newBuilder().setIdentificationNumber(sampleProductID).build();
		ResponseIds response = service.processRequest(id, "product");
		long[] ids = response.getIdentificationNumberList().stream().mapToLong(Long::longValue).toArray();
		System.out.println("Response: {" + "Length: " + ids.length + " Contents: " + Arrays.toString(ids) + "}");
		assertEquals(1, ids.length);
		assertEquals(sampleAnimalID, ids[0]);
	}
}