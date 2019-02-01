package syspadara.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import syspadara.model.Produto;
import syspadara.service.ProdutoService;

@Controller
@RequestMapping(path = "produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService service;

	@ApiOperation(value = "Retorna os dados de um produto")
	@GetMapping("/{id}")
	public ResponseEntity<Produto> readProduto(@PathVariable(name = "id") Long id) {
		Produto produto = service.readProduto(id);
		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}

	@ApiOperation(value = "Cria um produto")
	@PostMapping("/")
	public ResponseEntity<Produto> createProduto(@RequestBody @Valid CadastroProdDto produtoCadastro) {
		service.createProduto(produtoCadastro);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "Atualiza os dados de um produto")
	@PutMapping("/")
	public ResponseEntity<Produto> updateProduto(@RequestBody @Valid AlterarProdDto produtoAltera) {
		service.updateProduto(produtoAltera);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Exclui um produto")
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')") //Habilita que apenas o ADMIN possa deletar algum produto
	public ResponseEntity<Produto> removeProduto(@PathVariable(name = "id") Long id) {
		service.deleteProduto(id);
		return new ResponseEntity<Produto>(HttpStatus.OK);
	}

	@ApiOperation(value = "Retorna os dados de todos os produto")
	@GetMapping("/")
	public ResponseEntity<List<Produto>> listAll() {
		List<Produto> produtos = service.readAll();
		return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
	}

//	@ApiOperation(value = "Retonar os dados de de um produto pelo nome")
//	@GetMapping("find/{nome}")
//	public ResponseEntity<Produto> findByNome(@PathVariable(name = "nome") String nome) {
//		Produto produto = service.findByNome(nome);
//		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
//	}

	@ApiOperation(value = "Retorna os dados de produtos que possuem caracters em comum")
	@GetMapping("find/{nome}")
	public ResponseEntity<List<Produto>> findAllByNome(@PathVariable(name = "nome") String nome) {
		List<Produto> produtos = service.findAllNomes(nome);
		return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
	}

}
