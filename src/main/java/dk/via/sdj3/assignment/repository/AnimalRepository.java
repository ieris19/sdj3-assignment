package dk.via.sdj3.assignment.repository;

import dk.via.sdj3.assignment.model.Animal;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class AnimalRepository {
    private final Map<Long, Animal> animalMap = new HashMap<>();

    // CRUD operations
    // Create
    public Optional<Animal> create(Animal animal) {
        if (animal != null)
            animalMap.put(animal.registrationNumber(), animal);

        return Optional.ofNullable(animal);
    }

    // Get singular animal
    public Optional<Animal> get(long registrationNumber) {
        return Optional.ofNullable(animalMap.get(registrationNumber));
    }

    // Get all animals by date
    public Optional<List<Animal>> get(LocalDateTime arrivalDate) {
        if (arrivalDate != null) {
            List<Animal> foundAnimals = new ArrayList<>();
            for (Animal a: animalMap.values()) {
                if (a.storeDate().getYear() == arrivalDate.getYear() &&
                        a.storeDate().getDayOfYear() == arrivalDate.getDayOfYear()) {
                    foundAnimals.add(a);
                }
            }
            return Optional.ofNullable(foundAnimals);
        } else {
            return Optional.empty();
        }
    }

    // Get all animals by origin
    public Optional<List<Animal>> get(String origin) {
        List<Animal> foundAnimals = new ArrayList<>();
        for (Animal a: animalMap.values()) {
            if (a.origin().equalsIgnoreCase(origin)) {
                foundAnimals.add(a);
            }
        }

        return Optional.ofNullable(foundAnimals);
    }
}
