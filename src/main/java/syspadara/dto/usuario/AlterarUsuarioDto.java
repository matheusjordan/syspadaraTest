package syspadara.dto.usuario;

import javax.validation.constraints.Positive;

public class AlterarUsuarioDto extends CadastroUsuarioDto{

	@Positive
	private Long id; 

	//Construtores
	public AlterarUsuarioDto() {
		super();
	}

	public AlterarUsuarioDto(Long id, String username, String password, Integer tipoUser) {
		super(username, password, tipoUser);
		this.id = id;
	}

	//Metodos
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
