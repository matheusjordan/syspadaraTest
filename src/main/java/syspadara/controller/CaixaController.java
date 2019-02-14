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
import syspadara.dto.caixa.AlterarCaixaDto;
import syspadara.dto.caixa.CadastroCaixaDto;
import syspadara.dto.pageament.CaixaPageDto;
import syspadara.dto.pageament.FindDto;
import syspadara.model.Caixa;
import syspadara.service.CaixaService;

@Controller 
@RequestMapping("/caixas")
@PreAuthorize("hasRole('ADMIN')")
public class CaixaController {

	@Autowired
	private CaixaService service;

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna os dados de um caixa pelo ID")
	public ResponseEntity<Caixa> readCaixa(@PathVariable(name = "id") Long id) {
		Caixa caixa = service.readCaixa(id);
		return new ResponseEntity<Caixa>(caixa, HttpStatus.OK);
	}

	@PostMapping("/")
	@ApiOperation(value = "Cria um novo caixa")
	public ResponseEntity<Caixa> createCaixa(@RequestBody @Valid CadastroCaixaDto caixaCadastro) throws Exception{
		service.createCaixa(caixaCadastro);
		return new ResponseEntity<Caixa>(HttpStatus.CREATED);
	}

	@PutMapping("/")
	@ApiOperation(value = "Atualiza os dados de um caixa")
	public ResponseEntity<Caixa> updateCaixa(@RequestBody @Valid AlterarCaixaDto caixaAlterar) throws Exception{
		service.updateCaixa(caixaAlterar);
		return new ResponseEntity<Caixa>(HttpStatus.OK);
	}
	
	@PutMapping("/venda")
	@ApiOperation(value = "Adiciona uma venda a um determinado caixa")
	public ResponseEntity<Caixa> addVenda(@RequestBody @Valid AlterarCaixaDto caixaAdd) throws Exception{
		service.addVenda(caixaAdd);
		return new ResponseEntity<Caixa>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta um caixa pelo ID")
	public ResponseEntity<Caixa> deleteCaixa(@PathVariable(name = "id") Long id) {
		service.deleteCaixa(id);
		return new ResponseEntity<Caixa>(HttpStatus.OK);
	}
	//**********
	@GetMapping("/")
	@ApiOperation(value = "Retorna todos os caixas registrados")
	public ResponseEntity<List<Caixa>> readAll() {
		List<Caixa> caixas = service.readAll();
		return new ResponseEntity<List<Caixa>>(caixas, HttpStatus.OK);
	}
	
	@GetMapping
	@ApiOperation(value = "retorna o pageamento de caixas")
	public ResponseEntity<CaixaPageDto> pageamentCaixa(FindDto find){
		CaixaPageDto caixaPage = null;
		return new ResponseEntity<CaixaPageDto>(caixaPage, HttpStatus.OK);
	}

}
