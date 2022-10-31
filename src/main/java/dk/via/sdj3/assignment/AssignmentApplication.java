package dk.via.sdj3.assignment;

import dk.via.sdj3.assignment.database.DatabaseConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssignmentApplication {
    public static DatabaseConnection database;
    public static void main(String[] args) {
        database = new DatabaseConnection();
        SpringApplication.run(AssignmentApplication.class, args);
    }
}
