package dk.via.sdj3.assignment.rest.controller;

import dk.via.sdj3.assignment.rest.model.Animal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// source: https://www.tutorialspoint.com/spring_boot/spring_boot_rest_controller_unit_test.htm
public class AnimalControllerTest extends ControllerTest {
	private static LocalDateTime templateDate;
	private static Animal defaultAnimal;

	@BeforeAll public static void setup() {
		templateDate = LocalDateTime.of(LocalDate.of(2020, 1, 10), LocalTime.of(0, 0));
		defaultAnimal = new Animal(templateDate, 25, 23, "farm");
	}

	@BeforeEach public void beforeTest() {
		super.setUp();
	}

	private void postDefaultAnimal() throws Exception {
		String inputJson = super.mapToJson(defaultAnimal);
		mvc.perform(
						MockMvcRequestBuilders.post("/animals/").contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
	}

	@Test public void getAnimalTest() throws Exception {
		MvcResult mvcResultInvalid1 = mvc.perform(
				MockMvcRequestBuilders.get("/animals/123").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int statusInvalid1 = mvcResultInvalid1.getResponse().getStatus();
		assertEquals(200, statusInvalid1);

		MvcResult mvcResultInvalid2 = mvc.perform(
				MockMvcRequestBuilders.get("/animals").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int statusInvalid2 = mvcResultInvalid2.getResponse().getStatus();
		assertEquals(404, statusInvalid2);

		MvcResult mvcResultInvalid3 = mvc.perform(
				MockMvcRequestBuilders.get("/animals/").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int statusInvalid3 = mvcResultInvalid3.getResponse().getStatus();
		assertEquals(405, statusInvalid3);

		MvcResult mvcResultInvalid4 = mvc.perform(
				MockMvcRequestBuilders.get("/animals/notanumber").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int statusInvalid4 = mvcResultInvalid4.getResponse().getStatus();
		assertEquals(400, statusInvalid4);

		// creating new animal to test valid case
		postDefaultAnimal();

		// testing with new existing animal
		MvcResult mvcResult23 = mvc.perform(
				MockMvcRequestBuilders.get("/animals/23").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status1 = mvcResult23.getResponse().getStatus();
		assertEquals(200, status1);
		String content = mvcResult23.getResponse().getContentAsString();
		Animal animal = super.mapFromJson(content, Animal.class);
		assertEquals(defaultAnimal, animal);
	}

	@Test public void getAnimalsByOriginTest() throws Exception {
		MvcResult mvcResultInvalid1 = mvc.perform(
				MockMvcRequestBuilders.get("/animals/origin").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int statusInvalid1 = mvcResultInvalid1.getResponse().getStatus();
		assertEquals(400, statusInvalid1);

		MvcResult mvcResultInvalid2 = mvc.perform(
				MockMvcRequestBuilders.get("/animals/origin/home").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int statusInvalid2 = mvcResultInvalid2.getResponse().getStatus();
		assertEquals(200, statusInvalid2);

		String content = mvcResultInvalid2.getResponse().getContentAsString();
		Animal[] animals = super.mapFromJson(content, Animal[].class);
		assertTrue(animals.length == 0);

		// creating new animal to test valid case
		postDefaultAnimal();

		// testing with new existing animal
		MvcResult mvcResultFarm = mvc.perform(
				MockMvcRequestBuilders.get("/animals/origin/farm").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status1 = mvcResultFarm.getResponse().getStatus();
		assertEquals(200, status1);
		content = mvcResultFarm.getResponse().getContentAsString();
		animals = super.mapFromJson(content, Animal[].class);
		assertTrue(animals.length == 1);
	}

	@Test public void getAnimalsByDate() throws Exception {
		MvcResult mvcResultInvalid1 = mvc.perform(
				MockMvcRequestBuilders.get("/animals/date").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int statusInvalid1 = mvcResultInvalid1.getResponse().getStatus();
		assertEquals(400, statusInvalid1);

		MvcResult mvcResultInvalid2 = mvc.perform(
				MockMvcRequestBuilders.get("/animals/date/").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int statusInvalid2 = mvcResultInvalid2.getResponse().getStatus();
		assertEquals(200, statusInvalid2);

		String content = mvcResultInvalid2.getResponse().getContentAsString();
		Animal[] animals = super.mapFromJson(content, Animal[].class);
		assertTrue(animals.length == 0);

		MvcResult mvcResultInvalid3 = mvc.perform(
				MockMvcRequestBuilders.get("/animals/date/?day=2222").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int statusInvalid3 = mvcResultInvalid3.getResponse().getStatus();
		assertEquals(200, statusInvalid3); // provides no list so we dont check it

		MvcResult mvcResultInvalid4 = mvc.perform(
						MockMvcRequestBuilders.get("/animals/date/?day=1&month=1&year=1950").accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int statusInvalid4 = mvcResultInvalid4.getResponse().getStatus();
		assertEquals(200, statusInvalid4);

		content = mvcResultInvalid4.getResponse().getContentAsString();
		animals = super.mapFromJson(content, Animal[].class);
		assertTrue(animals.length == 0);

		MvcResult mvcResult1 = mvc.perform(
						MockMvcRequestBuilders.get("/animals/date/?day=10&month=1&year=2020").accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status1 = mvcResult1.getResponse().getStatus();
		assertEquals(200, status1); // provides no list so we dont check it

		content = mvcResult1.getResponse().getContentAsString();
		animals = super.mapFromJson(content, Animal[].class);
		assertTrue(animals.length == 1);
	}

	@Test public void createAnimalTest() throws Exception {
		Animal newAnimal = new Animal(templateDate.plusYears(1), 99, 1, "outside");
		String inputJson = super.mapToJson(newAnimal);
		MvcResult mvcResult = mvc.perform(
						MockMvcRequestBuilders.post("/animals/").contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Animal insertedAnimal = super.mapFromJson(content, Animal.class);
		assertEquals(newAnimal, insertedAnimal);

		// testing with invalid object
		Date invalidObj = new Date();
		String invalidInputJson = super.mapToJson(invalidObj);
		MvcResult mvcResultInvalid = mvc.perform(
				MockMvcRequestBuilders.post("/animals/").contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(invalidInputJson)).andReturn();

		int statusInvalid = mvcResultInvalid.getResponse().getStatus();
		assertEquals(400, statusInvalid);
	}
}