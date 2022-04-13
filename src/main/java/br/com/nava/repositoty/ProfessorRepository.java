package br.com.nava.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nava.entities.ProfessorEntity;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Integer> {

 
 
 
}
