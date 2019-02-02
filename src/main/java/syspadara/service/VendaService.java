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

	// Funções CRUD***
	public void createVenda(CadastroVenDto vendaCadastro) {
		Venda venda = new Venda();
		
		venda.setProdutos(prodVendaSer.convertToProdutoVenda(vendaCadastro.getProdutos()));
		
		vendaRepo.save(venda);
		System.out.println("Criado");
	}

	public Venda readVenda(Long id) {
		return vendaRepo.findById(id).get();
	}

	public void updateVenda(AlterarVenDto vendaAltera) {
		Venda venda = vendaRepo.findById(vendaAltera.getId()).get();
		
		venda.setProdutos(prodVendaSer.convertToProdutoVenda(vendaAltera.getProdutos()));
		
		vendaRepo.save(venda);
		System.out.println("Atualizado");
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
}
