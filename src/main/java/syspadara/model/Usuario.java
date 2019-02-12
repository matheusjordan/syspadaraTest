package syspadara.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import syspadara.enums.TipoUsuario;

@Entity 
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 3995257671521951839L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 20)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private Integer tipoUser;

	//Construtores
	public Usuario() {
	}

	public Usuario(String username, String password, Integer tipoUser) {
		this.username = username;
		this.password = password;
		this.tipoUser = tipoUser;
	}
	
	//Metodos
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
	
	public Set<TipoUsuario> getTipo(){
		Set<TipoUsuario> tipos = new HashSet<>();
		tipos.add(TipoUsuario.toEnum(this.getTipoUser()));
		return tipos;
	}
}
