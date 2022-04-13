package br.com.nava.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nava.entities.EnderecoEntity;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

}
