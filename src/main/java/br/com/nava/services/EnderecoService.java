package br.com.nava.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nava.dtos.EnderecoDTO;

import br.com.nava.entities.EnderecoEntity;

import br.com.nava.repositoty.EnderecoRepository;

@Service
public class EnderecoService {
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<EnderecoDTO> getAll(){
	List<EnderecoEntity> lista =  enderecoRepository.findAll();
		
		List<EnderecoDTO> listaDTO = new ArrayList<>();
		
		
		for (EnderecoEntity enderecoEntity : lista) {						
			
			
			
		listaDTO.add(enderecoEntity.toDTO());
			
		}
		
		return listaDTO;
	}
		
		
	
	
	
	public EnderecoDTO getOne(int id) {
		
		Optional<EnderecoEntity>  endereco =	enderecoRepository.findById(id);
		EnderecoEntity end = endereco.orElse(new EnderecoEntity());
		
		return end.toDTO();
	}
		
	
	public EnderecoDTO save(EnderecoEntity endereco) {
		return this.enderecoRepository.save(endereco).toDTO();
	}
	
	public EnderecoDTO update(int id, EnderecoEntity novoEndereco) {
		Optional<EnderecoEntity> enderecoBanco = enderecoRepository.findById(id);
		if (enderecoBanco.isPresent()) {
		EnderecoEntity obj = enderecoBanco.get();
		obj.setCep(novoEndereco.getCep());
		obj.setCidade(novoEndereco.getCidade());
		obj.setEstado(novoEndereco.getEstado());
		obj.setNumero(novoEndereco.getNumero());
		obj.setRua(novoEndereco.getRua());
		obj.setUsuario(novoEndereco.getUsuario());
		return enderecoRepository.save(obj).toDTO();
		
		}
		else {
			return new EnderecoDTO();
		
		}
		


	}
	
	
	public void delete(int id) {
		enderecoRepository.deleteById(id);
	}
	
	}
