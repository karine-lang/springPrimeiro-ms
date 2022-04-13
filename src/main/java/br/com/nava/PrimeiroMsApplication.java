package br.com.nava;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.nava.entities.ProfessorEntity;
import br.com.nava.entities.UsuarioEntity;
import br.com.nava.repositoty.ProfessorRepository;
import br.com.nava.repositoty.UsuarioRepository;
import br.com.nava.services.BDService;

@SpringBootApplication
public class PrimeiroMsApplication implements CommandLineRunner {
	@Autowired
	private BDService bdService;
	
	//@Autowired
	//private UsuarioRepositoryusuarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PrimeiroMsApplication.class, args);
	}
/*
	@Override
	public void run(String... args) throws Exception {
		List<ProfessorEntity> listaprofessor = professorRepository.findAll();
		for (int i = 0; i < listaprofessor.size(); i++) {
			System.out.println(listaprofessor.get(i));
		}
		
	}
	*/

	@Override
	public void run(String... args) throws Exception {
	
		bdService.inserirVendas();
		
	}
	
	//@Override
	//public void run(String... args) throws Exception {
//		List<UsuarioEntity> listausuario = usuarioRepository.findAll();
	//	for (int i = 0; i < listausuario.size(); i++) {
	//		System.out.println(listausuario.get(i));
	//	}
		//List<ProfessorEntity> listaprofessor = professorRepository.findAll();
		//for (int i = 0; i < listaprofessor.size(); i++) {
			//System.out.println(listaprofessor.get(i));
		//}
		//UsuarioEntity usuario = new UsuarioEntity();
		//usuario.setEmail("user@user.com");
	//	usuario.setNome("user");
		//usuarioRepository.save(usuario);
		
		
	
	
	
	
	
	
	
	
	
	
	
	

	}

