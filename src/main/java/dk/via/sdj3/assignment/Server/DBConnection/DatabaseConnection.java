package dk.via.sdj3.assignment.Server.DBConnection;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DatabaseConnection {
    public ArrayList<String> getPackageFromAnimalNumber(int animal) throws SQLException;
    public ArrayList<String> getAnimalFromProduct(int product) throws SQLException;
    public ArrayList<String> getPartsFromAnimalinproduct(int animalinproduct) throws SQLException;
    public void registerAnimal(int registrationNumber, int weight, String origin, String date) throws SQLException;
    public void registerPart(int originAnimal, String type, int weight) throws SQLException;
    public void addPartToPackage(int product, int animalinproduct) throws SQLException;
    public void addPartToTray(int partNumber, int animalinproduct) throws SQLException;
}
