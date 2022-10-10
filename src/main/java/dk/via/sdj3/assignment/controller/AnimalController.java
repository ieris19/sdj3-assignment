package dk.via.sdj3.assignment.controller;

import dk.via.sdj3.assignment.model.Animal;
import dk.via.sdj3.assignment.repository.AnimalRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class AnimalController {
    private final AnimalRepository repository;

    public AnimalController(AnimalRepository repository) {
        this.repository = repository;
    }

    // get animal by id
    @GetMapping("/animals/{id}")
    public Animal getAnimal(@PathVariable Long id) {
        try {
            Optional<Animal> received = repository.get(id);
            return received.orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    // get animals by date
    @GetMapping("/animals/date/")
    public List<Animal> getAnimals(@RequestParam(value = "year", defaultValue = "2000") int year,
                           @RequestParam(value = "month", defaultValue = "1") int month,
                           @RequestParam(value = "day", defaultValue = "1") int day) {
        try {
            Optional<List<Animal>> received = repository.get(LocalDateTime.of(year, month, day, 0, 0));
            return received.orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    // Get animals by origin
    @GetMapping("/animals/origin/{origin}")
    public List<Animal> getAnimals(@PathVariable String origin) {
        try {
            Optional<List<Animal>> received = repository.get(origin);
            return received.orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    // Create animal
    @PostMapping("/animals/")
    public Animal createAnimal(@RequestBody Animal animal) {
        try {
            Optional<Animal> received = repository.create(animal);
            return received.orElse(null);
        } catch (Exception e) {
            return null;
        }
    }
}
