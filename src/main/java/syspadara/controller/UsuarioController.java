package syspadara.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiOperation;
import syspadara.dto.usuario.AlterarUsuarioDto;
import syspadara.dto.usuario.CadastroUsuarioDto;
import syspadara.model.Usuario;
import syspadara.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@PostMapping("/")
	@ApiOperation("Cria um novo usuário")
	public ResponseEntity<Usuario> createUsuario(@RequestBody CadastroUsuarioDto usuarioDto){
		service.createUsuario(usuarioDto);
		return new ResponseEntity<Usuario>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	@ApiOperation("Retorna um usuário cadastrado no sistema")
	public ResponseEntity<Usuario> readUsuario(@PathVariable(name = "id") Long id){
		Usuario usuario = service.readUsuario(id);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@PutMapping("/")
	@ApiOperation("Atualiza os dados de um usuário")
	public ResponseEntity<Usuario> updateUsuario(@RequestBody AlterarUsuarioDto usuarioDto){
		service.updateUsuario(usuarioDto);
		return new ResponseEntity<Usuario>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation("Deleta os dados de um usuário")
	public ResponseEntity<Usuario> deleteUsuario(@PathVariable(name = "id") Long id){
		service.deleteUsuario(id);
		return new ResponseEntity<Usuario>(HttpStatus.OK);
	}
	//**********
	
	@GetMapping("/")
	@ApiOperation("Retorna os dados de todos os usuários")
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> usuarios = service.readAll();
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
}
