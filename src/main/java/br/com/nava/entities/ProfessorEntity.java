package br.com.nava.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.catalina.mapper.Mapper;
import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;

import br.com.nava.dtos.ProfessorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PROFESSORES")
public class ProfessorEntity {


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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRua() {
		return rua;
	}
	@Override
	public String toString() {
		return "ProfessorEntity [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rua=" + rua + ", cep=" + cep
				+ ", numero=" + numero + "]";
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	

	private String nome;	
	private String cpf;
	private String rua;
	private String cep;
	private int numero;
	
	public ProfessorDTO toDTO() {
		ModelMapper mapper = new ModelMapper();
		ProfessorDTO dto = mapper.map(this, ProfessorDTO.class);
		
		return dto;
		
	}
	
}
