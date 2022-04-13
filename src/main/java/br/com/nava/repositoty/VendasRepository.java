package br.com.nava.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nava.entities.VendaEntity;

public interface VendasRepository extends JpaRepository<VendaEntity, Integer> {

}
