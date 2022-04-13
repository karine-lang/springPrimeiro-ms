package br.com.nava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.nava.entities.ProdutoEntity;

import br.com.nava.repositoty.ProdutoRepository;

@Service
public class ProdutoService {


	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<ProdutoEntity> getAll(){
		return this.produtoRepository.findAll();
	}
	
	
	public ProdutoEntity getOne(int id) {
		return this.produtoRepository.findById(id).orElse(new ProdutoEntity());
	}
	
	public ProdutoEntity save(ProdutoEntity produto) {
		return this.produtoRepository.save(produto);
	}
	
	public ProdutoEntity update(int id, ProdutoEntity novoProduto) {
		Optional<ProdutoEntity> produtoBD = produtoRepository.findById(id);
		if (produtoBD.isPresent()) {
		ProdutoEntity obj = produtoBD.get();
		obj.setDescicao(novoProduto.getDescicao());
		obj.setNome(novoProduto.getNome());
		obj.setPreco(novoProduto.getPreco());
		
		return produtoRepository.save(obj);
		
		}
		else {
			return new ProdutoEntity();
		
		}
		


	}
	
	
	public void delete(int id) {
		produtoRepository.deleteById(id);
	}
	
	}




