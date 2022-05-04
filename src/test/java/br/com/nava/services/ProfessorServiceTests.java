package br.com.nava.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.nava.dtos.ProfessorDTO;
import br.com.nava.entities.ProfessorEntity;
import br.com.nava.repositoty.ProfessorRepository;


@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ProfessorServiceTests {
	@Autowired
	private ProfessorService professorService;
	
	@MockBean
	private ProfessorRepository professorRepository;
	
	@Test
	void getAllTest() {
		List<ProfessorEntity> listaMockada = new ArrayList<ProfessorEntity>();

		ProfessorEntity professorentidade = createValidProfessor();
		
		listaMockada.add(professorentidade);
		
		when(  professorRepository.findAll() ).thenReturn(listaMockada);
		
		List<ProfessorDTO> retorno = professorService.getAll();
		System.out.println(retorno);
		isProfessorValid(retorno.get(0), listaMockada.get(0));	
	}
	
	

	@Test
	void getOneWhenFoundObjectTest() {
		ProfessorEntity professorEntidade = createValidProfessor();
		
		Optional<ProfessorEntity> optional = Optional.of(professorEntidade);
		
		when( professorRepository.findById(1) ).thenReturn(optional);
		
		ProfessorDTO obj = professorService.getOne(1);
	

		isProfessorValid(obj, professorEntidade);
	}
	
	@Test
	void getOneWhenNotFoundObjectTest() {
		
		Optional<ProfessorEntity> optional = Optional.empty();
		when(  professorRepository.findById(1)  ).thenReturn(optional);
		
		
		// execução
				ProfessorDTO obj = professorService.getOne(1);
				
				// objeto com valores "padrão"
				ProfessorEntity professorEntidade = new ProfessorEntity();
				
				
				// validar a resposta
				isProfessorValid(obj, professorEntidade);
		
	}
	@Test
	void saveTest() {
		
		ProfessorEntity professorEntidade = createValidProfessor();
		when( professorRepository.save(professorEntidade) ).thenReturn(professorEntidade);
		
		ProfessorDTO professorSalvo = professorService.save(professorEntidade);
		
		isProfessorValid(professorSalvo, professorEntidade);
		
	}
	
	@Test
	void updateWhenFoundObj() {
		ProfessorEntity professorEntidade = createValidProfessor();
		Optional<ProfessorEntity> optional = Optional.of(professorEntidade);
		
		when(professorRepository.findById(professorEntidade.getId() ) ).thenReturn(optional);
		when(professorRepository.save(professorEntidade) ).thenReturn(professorEntidade);
		
		ProfessorDTO professorAlterado = professorService.update(professorEntidade.getId(), professorEntidade);
		
		isProfessorValid(professorAlterado, professorEntidade);
	}
	
	@Test
	void updateWhenNotFoundObj() {
		Optional<ProfessorEntity> optional = Optional.empty();
		ProfessorEntity professorEntidade = createValidProfessor();
		
		when(professorRepository.findById(1) ).thenReturn(optional);
		
		ProfessorDTO professorAlterado = professorService.update(1, professorEntidade);
		
		isProfessorValid(professorAlterado, new ProfessorEntity());
	}
	
	@Test
	void deleteTest() {
		assertDoesNotThrow( () -> professorService.delete(1) );
		
		verify(professorRepository, times(1) ).deleteById(1);
	}
	
	
	// metodo para criar professores
	private ProfessorEntity createValidProfessor() {
		ProfessorEntity professorentidade = new ProfessorEntity();
		professorentidade.setCep("0325555");
		professorentidade.setNome("Fabrizio teste");
		professorentidade.setNumero(3);
		professorentidade.setRua("RUA X");
		professorentidade.setId(1);
		return professorentidade;
		
	}
	// metodo de validação 
	private void isProfessorValid(ProfessorDTO obj, ProfessorEntity professorEntidade) {
	
		assertThat( obj.getCep() ).isEqualTo( professorEntidade.getCep() );
		assertThat( obj.getNome() ).isEqualTo( professorEntidade.getNome() );
		assertThat( obj.getNumero() ).isEqualTo( professorEntidade.getNumero() );
		assertThat( obj.getRua() ).isEqualTo( professorEntidade.getRua() );
		assertThat( obj.getId() ).isEqualTo( professorEntidade.getId() );
	
	}

}
