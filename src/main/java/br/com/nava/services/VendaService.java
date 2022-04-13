package br.com.nava.services;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nava.entities.ProdutoEntity;
import br.com.nava.entities.VendaEntity;
import br.com.nava.repositoty.ProdutoRepository;
import br.com.nava.repositoty.VendasRepository;

@Service
public class VendaService {
	
	
	
	@Autowired
	private VendasRepository vendaRepository;
	@Autowired
	private ProdutoRepository produtosRepository;
	
	public List<VendaEntity> getAll(){
		return vendaRepository.findAll();
	}
	
	
	public VendaEntity getOne(int id) {
		return vendaRepository.findById(id).orElse(new VendaEntity());
	}
	
	
	public VendaEntity save(VendaEntity venda) {
		
VendaEntity vendaSalva = vendaRepository.save(venda);
		
		// depois teremos que alterar a lista de vendas para cada produtos	
		// para cada produto da venda do body, temos que atualizar a venda salva no banco
		
		//todos os produtos da venda
		List<ProdutoEntity> listaProdutos = venda.getProdutos();
		
		// atualizando as vendas para cada produto acima
		
		for(int i = 0; i < listaProdutos.size(); i++) {
			// Arrays.asList(): converte um conjunto de objetos em uma lista
			listaProdutos.get(i).setVendas(Arrays.asList(vendaSalva));
		}
		
		//salvando as atualizações no banco de dados
		produtosRepository.saveAll(listaProdutos);
		
		return vendaSalva;
	}
	
	public VendaEntity update(int id, VendaEntity novaVenda) {

		Optional<VendaEntity> optional = vendaRepository.findById(id);
		
		if (optional.isPresent()) {
			VendaEntity venda = optional.get();
			
			venda.setValorTotal( novaVenda.getValorTotal());
			
			return vendaRepository.save(venda);
		}else {
			return new VendaEntity();
		}
	
	}

		
	
	
	public void delete(int id) {
		vendaRepository.deleteById(id);
	}

}
