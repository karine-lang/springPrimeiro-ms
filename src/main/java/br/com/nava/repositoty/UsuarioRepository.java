package br.com.nava.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.com.nava.entities.UsuarioEntity;

@Repository
public interface UsuarioRepository extends  JpaRepository<UsuarioEntity, Integer>{

}
