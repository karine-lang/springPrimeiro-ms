package br.com.nava.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

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
		
		ProfessorEntity professorentidade = new ProfessorEntity();
		professorentidade.setCep("0325555");
		professorentidade.setNome("Fabrizio teste");
		professorentidade.setNumero(3);
		professorentidade.setRua("RUA X");
		professorentidade.setId(1);
		
		listaMockada.add(professorentidade);
		
		when(  professorRepository.findAll() ).thenReturn(listaMockada);
		
		List<ProfessorDTO> retorno = professorService.getAll();
		System.out.println(retorno);
		
		assertThat(listaMockada.get(0).getCep() ).isEqualTo(retorno.get(0).getCep());
		assertThat(listaMockada.get(0).getNome() ).isEqualTo(retorno.get(0).getNome());
		assertThat(listaMockada.get(0).getNumero() ).isEqualTo(retorno.get(0).getNumero());
		assertThat(listaMockada.get(0).getRua() ).isEqualTo(retorno.get(0).getRua());
		assertThat(listaMockada.get(0).getId() ).isEqualTo(retorno.get(0).getId());
		
	}
	@Test
	void getOneWhenFoundObjectTest() {
		
		ProfessorEntity professorEntidade = new ProfessorEntity();
		professorEntidade.setCep("0325555");
		professorEntidade.setNome("Fabrizio teste");
		professorEntidade.setNumero(3);
		professorEntidade.setRua("RUA X");
		professorEntidade.setId(1);
		
		Optional<ProfessorEntity> optional = Optional.of(professorEntidade);
		
		when( professorRepository.findById(1) ).thenReturn(optional);
		
		ProfessorDTO obj = professorService.getOne(1);
	
		assertThat( obj.getCep() ).isEqualTo( professorEntidade.getCep() );
		assertThat( obj.getNome() ).isEqualTo( professorEntidade.getNome() );
		assertThat( obj.getNumero() ).isEqualTo( professorEntidade.getNumero() );
		assertThat( obj.getRua() ).isEqualTo( professorEntidade.getRua() );
		assertThat( obj.getId() ).isEqualTo( professorEntidade.getId() );
	
	}
	
	@Test
	void getOneWhenNotFoundObjectTest() {
		
		Optional<ProfessorEntity> optional = Optional.empty();
		when(  professorRepository.findById(1)  ).thenReturn(optional);
		
		
		// execução
				ProfessorDTO obj = professorService.getOne(1);
				
				// objeto com valores "padrão"
				ProfessorEntity professorEntidade = new ProfessorEntity();
				
				//validação
				
				assertThat( obj.getCep() ).isEqualTo( professorEntidade.getCep() );
				assertThat( obj.getNome() ).isEqualTo( professorEntidade.getNome() );
				assertThat( obj.getNumero() ).isEqualTo( professorEntidade.getNumero() );
				assertThat( obj.getRua() ).isEqualTo( professorEntidade.getRua() );
				assertThat( obj.getId() ).isEqualTo( professorEntidade.getId() );
		
	}

}
