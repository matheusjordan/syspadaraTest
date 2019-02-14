package syspadara.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import syspadara.enums.TipoUsuario;

public class UserSS implements UserDetails{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String username;
	private String pass;
	private Collection<? extends GrantedAuthority> authorities;
	
	//Construtores
	public UserSS () {
	}
	
	public UserSS(Long id, String username, String pass, Set<TipoUsuario> tipos) {
		this.id = id;
		this.username = username;
		this.pass = pass;
		this.authorities = tipos.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
	}

	//Metodos
	public Long getId() {
		return id;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return pass;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
