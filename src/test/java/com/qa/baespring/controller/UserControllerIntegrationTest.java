package com.qa.baespring.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.baespring.domain.User;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:testschema.sql",
		"classpath:testdata.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class UserControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	public void createTest() throws Exception {
		User entry = new User("Jim", "Jones", "jjones1");
		String entryAsJSON = mapper.writeValueAsString(entry);

		User result = new User(2L, "Jim", "Jones", "jjones1");
		String resultAsJSON = mapper.writeValueAsString(result);

		mvc.perform(post("/user/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(resultAsJSON));

	}

	@Test
	public void getAllTest() throws Exception {
		User user = new User(1L, "Tom", "Jones", "tjones1");
		List<User> output = new ArrayList<>();
		output.add(user);
		String outputAsJSON = mapper.writeValueAsString(output);
		
		mvc.perform(get("/user/getAll")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(outputAsJSON));
	}

	@Test
	public void getByIdTest() throws Exception {
		// Create a java object representing what you expect to get back
		// Convert that to JSON
		// Send your request and check for the right response code and content
		
	}

	@Test
	public void updateTest() throws Exception {
		// Create a java object representing your update object
		// Convert that to JSON
		
		// Create a java object representing what you expect to get back
		// Convert that to JSON
		
		// Send your request and check for the right response code and content
	}

	@Test
	public void deleteTest() throws Exception {
		// Send the request
		// Check the response code is as expected (likely no content)
	}
}
