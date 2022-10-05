package dk.via.sdj3.assignment.repository;

import dk.via.sdj3.assignment.model.Animal;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import static org.junit.Assert.*;

public class AnimalRepositoryTest {
    private static LocalDateTime templateDate;
    private AnimalRepository repository;
    private static Animal animal1;
    private static Animal animal2;
    private static Animal animal3;

    @BeforeClass
    public static void constSetUp() {
        templateDate = LocalDateTime.of(
                LocalDate.of(2020, 1, 10),
                LocalTime.of(0,0));
        animal1 = new Animal(templateDate, 25, 1, "farm");
        animal2 = new Animal(templateDate.plusYears(1), 5, 2, "farm");
        animal3 = new Animal(templateDate, 10, 3, "home");
    }

    @Before
    public void setUp() {
        repository = new AnimalRepository();
        repository.create(animal1);
        repository.create(animal2);
        repository.create(animal3);
    }

    @After
    public void tearDown() {
        repository = null;
    }

    @Test
    public void createTest() {
        Animal toCreate = new Animal(templateDate, 50, 10, "outside");
        assertEquals(Optional.of(toCreate), repository.create(toCreate));
        assertEquals(Optional.empty(), repository.create(null));
    }

    @Test
    public void getByIdTest() {
        assertEquals(Optional.empty(), repository.get(12957));
        assertFalse(repository.get(1).isEmpty());
        assertEquals(Optional.of(animal1), repository.get(1));
        assertEquals(Optional.of(animal2), repository.get(2));
        assertEquals(Optional.of(animal3), repository.get(3));
    }

    @Test
    public void getByArrivalDateTest() {
        assertTrue(repository.get(templateDate.plusYears(12)).get().isEmpty());
        // matching date
        assertFalse(repository.get(templateDate).get().isEmpty());
        assertEquals(2, repository.get(templateDate).get().size());
        // matching date but not time
        assertFalse(repository.get(templateDate.plusMinutes(12)).get().isEmpty());
        assertEquals(1, repository.get(templateDate.plusYears(1).plusMinutes(22)).get().size());
    }

    @Test
    public void getByOriginTest() {
        assertTrue(repository.get("wasd").get().isEmpty());
        assertEquals(2, repository.get("farm").get().size());
        assertEquals(1, repository.get("home").get().size());
    }
}