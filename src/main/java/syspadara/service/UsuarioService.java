package syspadara.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.dto.usuario.AlterarUsuarioDto;
import syspadara.dto.usuario.CadastroUsuarioDto;
import syspadara.model.Usuario;
import syspadara.repository.UsuarioRepository;

@Service 
public class UsuarioService {
	private final Logger LOG = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	// Funções CRUD***
	public void createUsuario(CadastroUsuarioDto usuarioDto) {
		Usuario usuario = new Usuario();
		usuario.setUsername(usuarioDto.getUsername());
		usuario.setPassword(usuarioDto.getPassword());
		usuario.setTipoUser(usuarioDto.getTipoUser());
		
		usuarioRepo.save(usuario);
		
		LOG.info("Usuario: " + usuario.getUsername() + " criado com sucesso!");
	}
	
	public Usuario readUsuario(Long id) {
		return usuarioRepo.findById(id).get();
	}
	
	public void updateUsuario(AlterarUsuarioDto usuarioDto) {
		Usuario usuario = this.readUsuario(usuarioDto.getId());
		usuario.setUsername(usuarioDto.getUsername());
		usuario.setPassword(usuarioDto.getPassword());
		usuario.setTipoUser(usuarioDto.getTipoUser());
		
		usuarioRepo.save(usuario);
		
		LOG.info("Usuario: " + usuario.getUsername() + " alterado com sucesso!");
	}
	
	public void deleteUsuario(Long id) {
		Usuario usuario = this.readUsuario(id);
		usuarioRepo.deleteById(id);
		LOG.info("Usuario: " + usuario.getUsername() + " removido com sucesso!");
	}
	// *************
	
	public List<Usuario> readAll(){
		return usuarioRepo.findAll();
	}
}
