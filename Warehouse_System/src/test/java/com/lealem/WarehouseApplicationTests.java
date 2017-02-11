package com.lealem;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.lealem.api.SKURequestController;
import com.lealem.controller.HomeController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WarehouseApplicationTests {
	private String BASE_PATH = "";

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private SKURequestController catRep;
	@Autowired
	private HomeController homeController;

	@Test
	public void contextLoads() {

	}

//	@Test
	public void shouldCreateEntity() throws Exception {
		mockMvc.perform(post(BASE_PATH + "/warehouse/skuCreationRequest")
				.content("{\"name\": \"profession\"," + "\"price\": \"123\"," + "\"quantitiy\": \"123\","
						+ " \"description\":\"related with my profession\"}"))
				.andExpect(status().isOk());
	}

	@Ignore
	@Test
	public void testHome() throws Exception {
		mockMvc.perform(get("\\home")).andExpect(status().isOk());
	}
}
