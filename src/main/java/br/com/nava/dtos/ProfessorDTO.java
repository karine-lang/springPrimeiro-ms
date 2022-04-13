package br.com.nava.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;

import br.com.nava.entities.ProfessorEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO {
	
	private int id;
	
	@NotEmpty(message = "Preenchimento Obrigatório")
	@NotNull(message = "Preenchimento Obrigatório")
	@Length(min=3, max=80, message = "O numero de caratcter deve ser entre 3 a 80")
	@Pattern( regexp = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]*$", message = "É valido apenas caracteres")
	private String nome;
	private String cep;
	private String rua;

	private int numero;
	
	public ProfessorEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this,ProfessorEntity.class);
		
	}


}
