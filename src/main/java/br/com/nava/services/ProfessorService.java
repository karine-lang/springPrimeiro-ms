package br.com.nava.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nava.dtos.ProfessorDTO;
import br.com.nava.entities.ProfessorEntity;
import br.com.nava.repositoty.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	public List<ProfessorDTO> getAll() {
		
		List<ProfessorEntity> lista =  professorRepository.findAll();
		
		List<ProfessorDTO> listaDTO = new ArrayList<>();
		
		/*
		 * for (int i = 0; i < lista.size(); i++) {
			ProfessorEntity professorEntity = lista.get(i);
		}*/
		// foreach
		// 1-) Tipo da variável de cada elemento da lista
		// 2-) nome local da variável 
		// - 3 lista com elementos a ser percorrido
		for (ProfessorEntity professorEntity : lista) {						
			
			//ProfessorDTO dto = new ProfessorDTO();
			
			//dto.setId( professorEntity.getId() );
			//dto.setCep( professorEntity.getCep() );
			//dto.setCpf( professorEntity.getCpf() );
			//dto.setNome( professorEntity.getNome() );
			//dto.setNumero( professorEntity.getNumero() );
			//dto.setRua( professorEntity.getRua() );
			
			//listaDTO.add(dto);
		listaDTO.add(professorEntity.toDTO());
			
		}
		
		return listaDTO;
	}

	
	
	public ProfessorDTO getOne(int id) {
		
		Optional<ProfessorEntity>  professor =	professorRepository.findById(id);
		ProfessorEntity professors = professor.orElse(new ProfessorEntity());
		
		return professors.toDTO();
		
	
	}
	
	public ProfessorDTO save(ProfessorEntity professor) {
		return professorRepository.save(professor).toDTO();
		
	}
	
	public ProfessorDTO update(int id, ProfessorEntity professor ) {	
		Optional<ProfessorEntity> optional = professorRepository.findById(id);
		
		if (optional.isPresent() == true ) {
			ProfessorEntity professorBD = optional.get();
			professorBD.setNome(professor.getNome());
			professorBD.setCep(professor.getCep());;
			professorBD.setCpf(professor.getCpf());
			professorBD.setNumero(professor.getNumero());
			professorBD.setRua(professor.getRua());
			
			
			
			return professorRepository.save(professorBD).toDTO();
			
		}
		else {
			return new ProfessorDTO();
		}
		
	}
	
	public void delete(int id) {
		professorRepository.deleteById(id);
	}
}
