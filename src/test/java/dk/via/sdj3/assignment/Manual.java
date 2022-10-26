package dk.via.sdj3.assignment;

public class Manual {
	public static void main(String[] args) {
		String col = "Column";
		String table = "Table";
		int id = 100;
		String st1 = String.format("SELECT %1$s FROM %2$s WHERE %3$s = %4$s;", col, table, col, id);
		System.out.println(st1);
	}
}
