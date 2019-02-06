package syspadara.controller;

import java.util.List;

import javax.validation.Valid;

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
import syspadara.dto.produto.AlterarProdDto;
import syspadara.dto.produto.CadastroProdDto;
import syspadara.model.Estoque;
import syspadara.service.EstoqueService;

@Controller
@RequestMapping(path = "estoques")
public class EstoqueController {

	@Autowired
	private EstoqueService service;

	@ApiOperation(value = "Retorna os dados de um produto no estoque")
	@GetMapping("/{id}")
	public ResponseEntity<Estoque> readEstoque(@PathVariable(name = "id") Long id) {
		Estoque produto = service.readEstoque(id);
		return new ResponseEntity<Estoque>(produto, HttpStatus.OK);
	}

	@ApiOperation(value = "Cria um produto")
	@PostMapping("/")
	public ResponseEntity<Estoque> createEstoque(@RequestBody @Valid CadastroProdDto produtoCadastro) {
		service.createEstoque(produtoCadastro);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "Atualiza os dados de um produto")
	@PutMapping("/")
	public ResponseEntity<Estoque> updateEstoque(@RequestBody @Valid AlterarProdDto produtoAltera) {
		service.updateEstoque(produtoAltera);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Exclui um produto")
	@DeleteMapping("/{id}")
	public ResponseEntity<Estoque> removeEstoque(@PathVariable(name = "id") Long id) {
		service.deleteEstoque(id);
		return new ResponseEntity<Estoque>(HttpStatus.OK);
	}

	@ApiOperation(value = "Retorna os dados de todos os produto")
	@GetMapping("/")
	public ResponseEntity<List<Estoque>> listAll() {
		List<Estoque> produtos = service.readAll();
		return new ResponseEntity<List<Estoque>>(produtos, HttpStatus.OK);
	}

//	@ApiOperation(value = "Retonar os dados de de um produto pelo nome")
//	@GetMapping("find/{nome}")
//	public ResponseEntity<Produto> findByNome(@PathVariable(name = "nome") String nome) {
//		Produto produto = service.findByNome(nome);
//		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
//	}

	@ApiOperation(value = "Retorna os dados de produtos que possuem caracters em comum")
	@GetMapping("/find/{nome}")
	public ResponseEntity<List<Estoque>> findAllByNome(@PathVariable(name = "nome") String nome) {
		List<Estoque> produtos = service.findAllNomes(nome);
		return new ResponseEntity<List<Estoque>>(produtos, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Busca dinamica de produtos por nome, preço e qntd")
	@GetMapping("/find")
	public ResponseEntity<List<Estoque>> findEstoque(EstoqueQueryDto query){
		
		List<Estoque> produtos = service.findByParam(query);
		return new ResponseEntity<List<Estoque>>(produtos,HttpStatus.OK);
	}

}
