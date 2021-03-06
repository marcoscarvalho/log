package com.marcoscarvalho;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LogTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnOk() throws Exception {

		mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.msg", "Ok").exists());
	}

	@Test
	public void shouldLog() throws Exception {

		mockMvc.perform(post("/").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content("{\"app\": \"CidadaoZen\", \"msg\":\"Primeira Mensagem\"}")).andExpect(status().isCreated())
				.andExpect(jsonPath("$.msg", "Primeira Mensagem").exists());
	}

}
