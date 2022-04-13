package br.com.nava.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.nava.dtos.ProfessorDTO;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ProfessorControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	ObjectMapper mapper = new ObjectMapper();

	
	@Test
	void getAllTest() throws Exception {
		ResultActions response =  mockMvc.perform(
				get("/professores").contentType("application/json")
				);
		MvcResult result = response.andReturn();
		
		String responseStr = result.getResponse().getContentAsString();
		
		System.out.println(responseStr);
		ObjectMapper mapper = new ObjectMapper();
		ProfessorDTO[] lista = mapper.readValue(responseStr, ProfessorDTO[].class);
			assertThat(lista).isNotEmpty();
}
	
	@Test
	void getOne() throws Exception {
		ResultActions response = mockMvc.perform(
				get("/professores/1").contentType("application/json")
				);
		MvcResult result = response.andReturn();
		String responseStr = result.getResponse().getContentAsString();
		
	
		System.out.println(responseStr);
		ProfessorDTO professores = mapper.readValue(responseStr, ProfessorDTO.class);
		assertThat(professores.getId()).isEqualTo(1);
		assertThat(result.getResponse().getStatus() ).isEqualTo( 200 );
		
	}
	
	@Test
	void saveTest() throws Exception {
		ProfessorDTO professor = new ProfessorDTO();
		professor.setCep("0325555");
		professor.setNome("Fabrizio");
		professor.setNumero(3);
		professor.setRua("RUA X");
		
		ResultActions response = mockMvc.perform(
				post("/professores")
				.content(mapper.writeValueAsString(professor))
				.contentType("application/json")
				);
		MvcResult result = response.andReturn();
		String responseStr = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
		
		System.out.println(responseStr);
		
		ProfessorDTO professorSalvo = mapper.readValue(responseStr, ProfessorDTO.class);
		
		assertThat(professorSalvo.getId() ).isPositive();
		assertThat(professorSalvo.getCep() ).isEqualTo(professor.getCep());
		assertThat(professorSalvo.getNome() ).isEqualTo(professor.getNome());
		assertThat(professorSalvo.getNumero() ).isEqualTo(professor.getNumero() );
		assertThat(professorSalvo.getRua() ).isEqualTo(professor.getRua());
		assertThat(result.getResponse().getStatus() ).isEqualTo( 200 );		
	}
	
	@Test
	void uptadeTest() throws Exception {
		ProfessorDTO professor = new ProfessorDTO();
		professor.setCep("03255552");
		professor.setNome("Fabrizio.teste");
		professor.setNumero(4);
		professor.setRua("RUA X");
		
		ResultActions response = mockMvc.perform(
				patch("/professores/1")
				.content(mapper.writeValueAsString(professor))
				.contentType("application/json")
				);
		MvcResult result = response.andReturn();
		String responseStr = result.getResponse().getContentAsString();
		
		
		
		System.out.println(responseStr);
		
		ProfessorDTO professorUpdate = mapper.readValue(responseStr, ProfessorDTO.class);
		
		assertThat(professorUpdate.getId() ).isPositive();
		assertThat(professorUpdate.getCep() ).isEqualTo(professor.getCep());
		assertThat(professorUpdate.getNome() ).isEqualTo(professor.getNome());
		assertThat(professorUpdate.getNumero() ).isEqualTo(professor.getNumero() );
		assertThat(professorUpdate.getRua() ).isEqualTo(professor.getRua());
		assertThat(result.getResponse().getStatus() ).isEqualTo( 200 );		
		}
	
	
	@Test
	void deleteTest() throws Exception  {
		ResultActions response = mockMvc.perform(
				delete("/professores/3")
				.contentType("application/json")
				);
	
		MvcResult result = response.andReturn();
		String responseStr = result.getResponse().getContentAsString();
		
		System.out.println(responseStr);
		
		assertThat(result.getResponse().getStatus() ).isEqualTo(200);
		
	}
	
	
}
