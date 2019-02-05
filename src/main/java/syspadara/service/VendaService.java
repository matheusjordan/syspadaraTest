package syspadara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.dto.Venda.AlterarVenDto;
import syspadara.dto.Venda.CadastroVenDto;
import syspadara.model.Venda;
import syspadara.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepo;

	@Autowired
	private ProdutoVendaService prodVendaSer;

	@Autowired
	private EstoqueService estoqueSer;

	// Funções CRUD***
	public void createVenda(CadastroVenDto vendaCadastro) throws Exception {
		Venda venda = new Venda();
		if (estoqueSer.isValid(vendaCadastro.getProdutos())) {
			venda.setProdutos(prodVendaSer.convertToProdutoVenda(vendaCadastro.getProdutos()));

			vendaRepo.save(venda);
			System.out.println("Criado");
		} else throw new Exception("Venda não realizada! Verifique se a quantidade vendida dos produtos é menor ou igual ao estoque!");

	}

	public Venda readVenda(Long id) {
		return vendaRepo.findById(id).get();
	}

	public void updateVenda(AlterarVenDto vendaAltera) throws Exception{
		Venda venda = vendaRepo.findById(vendaAltera.getId()).get();

		if (estoqueSer.isValid(vendaAltera.getProdutos())) {
			venda.setProdutos(prodVendaSer.convertToProdutoVenda(vendaAltera.getProdutos()));

			vendaRepo.save(venda);
			System.out.println("Atualizado");
		} else throw new Exception("Venda não realizada! Verifique se a quantidade vendida dos produtos é menor ou igual ao estoque!");

	}

	public void deleteVenda(Long id) {
		Venda venda = vendaRepo.findById(id).get();
		vendaRepo.delete(venda);
		System.out.println("Deletado");
	}
	// *************

	public List<Venda> readAll() {
		return vendaRepo.findAll();
	}

	// Buscar vendas pelo Id
	public List<Venda> findVendas(List<Long> vendasId) {
		return vendaRepo.findAllById(vendasId);
	}

	// Buscar venda pelo Id
	public Venda findVenda(Long vendaId) {
		return vendaRepo.findById(vendaId).get();
	}
	
	//Função que finaliza uma venda
	public void finalizeVenda(List<Venda> vendas) throws Exception{
		for(Venda venda : vendas) {
			venda.setStatus(1);
			estoqueSer.decrementaEstoque(venda.getProdutos());
			
		}
	}
}
