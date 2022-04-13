package br.com.nava.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="PRODUTOS")
public class ProdutoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescicao() {
		return descricao;
	}
	public void setDescicao(String descicao) {
		this.descricao = descicao;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	private String nome;
	private String descricao;
	private float preco;
	
	@ManyToMany
	@JoinTable (
			name = "VENDA_PRODUTO", 
			joinColumns = @JoinColumn(name = "PRODUTO_ID"),
			inverseJoinColumns = @JoinColumn(name = "VENDA_ID")
			
	)	
	private List<VendaEntity> vendas;
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<VendaEntity> getVendas() {
		return vendas;
	}
	public void setVendas(List<VendaEntity> vendas) {
		this.vendas = vendas;
	}

		// TODO Auto-generated method stub
		
	}


