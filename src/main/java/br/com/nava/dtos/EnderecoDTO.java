package br.com.nava.dtos;

import javax.validation.constraints.Pattern;

import org.modelmapper.ModelMapper;

import br.com.nava.entities.EnderecoEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

	private String rua;
	private int numero;
	@Pattern(regexp  = "^[1-9]*$", message = "E valido apenas caracteres")
	private String cep;
	private String cidade;
	private String estado;
	
	
	public EnderecoEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this,EnderecoEntity.class);
	}
}
