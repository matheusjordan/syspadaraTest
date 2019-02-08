package syspadara.dto.usuario;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

public class CadastroUsuarioDto {
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	@PositiveOrZero
	private Integer tipoUser;
	
	//Construtores
	public CadastroUsuarioDto() {
	}
	
	public CadastroUsuarioDto(String username, String password, Integer tipoUser) {
		this.username = username;
		this.password = password;
		this.tipoUser = tipoUser;
	}

	//Metodos
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(Integer tipoUser) {
		this.tipoUser = tipoUser;
	}
}
