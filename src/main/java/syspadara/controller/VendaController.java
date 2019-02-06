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
import syspadara.dto.Venda.AlterarVenDto;
import syspadara.dto.Venda.CadastroVenDto;
import syspadara.dto.pageament.FindDto;
import syspadara.dto.pageament.VendaPageDto;
import syspadara.model.Venda;
import syspadara.service.VendaService;

@Controller
@RequestMapping("vendas")
public class VendaController {

	@Autowired
	private VendaService service;
	
	@ApiOperation(value = "Retorna os dados de uma venda")
	@GetMapping("/{id}")
	public ResponseEntity<Venda> readVenda(@PathVariable(name = "id") Long id){
		Venda venda = service.readVenda(id);
		return new ResponseEntity<Venda>(venda, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Cria uma venda")
	@PostMapping("/")
	public ResponseEntity<Venda> createVenda(@RequestBody @Valid CadastroVenDto vendaCadastro) throws Exception {
		service.createVenda(vendaCadastro);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Atualiza os dados de uma venda")
	@PutMapping("/")
	public ResponseEntity<Venda> updateVenda(@RequestBody @Valid AlterarVenDto vendaAltera) throws Exception{
		service.updateVenda(vendaAltera);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Exclui uma venda")
	@DeleteMapping("/{id}")
	public ResponseEntity<Venda> deleteVenda(@PathVariable(name = "id") Long id){
		service.deleteVenda(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Retorna os dados de  todas as vendas")
	@GetMapping("/")
	public ResponseEntity<List<Venda>> readAll(){
		List<Venda> vendas = service.readAll();
		return new ResponseEntity<List<Venda>>(vendas, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Pageamento das vendas criadas")
	@GetMapping("/pageament")
	public ResponseEntity<VendaPageDto> pageamentVenda(FindDto find){
		VendaPageDto vendaPage = service.pageamentVenda(find);
		return new ResponseEntity<VendaPageDto>(vendaPage, HttpStatus.OK);
	}
}
