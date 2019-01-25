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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import syspadara.model.Estoque;
import syspadara.service.EstoqueService;

@Controller
@RequestMapping("estoques")
public class EstoqueController {

	@Autowired
	private EstoqueService service;
	
	@GetMapping("{id}")
	public ResponseEntity<Estoque> readEstoque(@PathVariable(value = "id") Long id){
		Estoque estoque = service.readEstoque(id);
		return new ResponseEntity<Estoque>(estoque,HttpStatus.OK);
	}
	
	@PostMapping("novo")
	public ResponseEntity<Estoque> createEstoque(@RequestBody Estoque estoque){
		service.createEstoque(estoque);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping("atualizacao")
	public ResponseEntity<Estoque> updateEstoque(@RequestBody Estoque estoque){
		service.updateEstoque(estoque);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("{id}/exclusao")
	public ResponseEntity<Estoque> deleteEstoque(@PathVariable(value = "id") Long id){
		service.deleteEstoque(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("todos")
	public ResponseEntity<List<Estoque>> readAll(){
		List<Estoque> estoques = service.findAll();
		return new ResponseEntity<List<Estoque>>(estoques, HttpStatus.OK);
	}
	
}