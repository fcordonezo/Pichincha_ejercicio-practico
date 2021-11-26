package com.pichincha.ejerciciobackend.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
public class PersonControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Test
	void getAll() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("localhost:8080/people");
		MvcResult result = mvc.perform(request).andReturn();
		assertNotNull(result);
	}
}
