package syspadara.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import syspadara.model.Usuario;
import syspadara.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioService usuarioSer;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario user = usuarioSer.readByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserSS(user.getId(), user.getUsername(), user.getPassword(), user.getTipo());
	}

}
