package dk.via.sdj3.assignment;

import dk.via.sdj3.assignment.database.DatabaseConnection;
import dk.via.sdj3.assignment.database.DatabaseCredentials;

import java.io.FileNotFoundException;
import java.io.FileWriter;

public class Manual {
	public static void main(String[] args) throws FileNotFoundException {
		String col = "Column";
		String table = "Table";
		int id = 100;
		String st1 = String.format("SELECT %1$s FROM %2$s WHERE %3$s = %4$s;", col, table, col, id);
		System.out.println(st1);

		try (FileWriter writer = new FileWriter("test.json")) {
			writer.write(DatabaseCredentials.parseFile().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
