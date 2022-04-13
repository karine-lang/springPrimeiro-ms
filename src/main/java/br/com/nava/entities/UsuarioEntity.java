package br.com.nava.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="USUARIOS")
public class UsuarioEntity {


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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name= "nome")
	private String nome;
	private String email;
	@Override
	public String toString() {
		return "UsuarioEntity [nome=" + nome + ", email=" + email + ", id=" + id + ", endereco=" + endereco + "]";
	}
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "endereco_id")
	private EnderecoEntity endereco;
	
	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	
	private List<VendaEntity> vendas;
	
	
//	public UsuarioEntity() {
//		
//	}
	
//	public UsuarioEntity(int id, String nome,String email) {}
		
}

