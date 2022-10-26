package dk.via.sdj3.assignment.rest.model;

import java.time.LocalDateTime;

public record Animal(LocalDateTime storeDate, double weight, long registrationNumber, String origin) {
}
