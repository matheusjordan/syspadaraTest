package syspadara.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.dto.produto.ProdutoVendaDto;
import syspadara.model.ProdutoVenda;
import syspadara.repository.ProdutoVendaRepository;

@Service
public class ProdutoVendaService {

	@Autowired
	private ProdutoVendaRepository prodVendaRepo;
	
	@Autowired
	private EstoqueService estoqueSer;

	// Funções CRUD***
	public void createProdutoVenda(ProdutoVenda produto) {
		prodVendaRepo.save(produto);
		System.out.println("Vendido");
	}

	public ProdutoVenda readProduto(Long id) {
		return prodVendaRepo.findById(id).get();
	}

	public void updateProduto(ProdutoVenda produto) {
		prodVendaRepo.save(produto);
		System.out.println("Alterado");
	}

	public void deleteProduto(Long id) {
		prodVendaRepo.deleteById(id);
		System.out.println("Deletado");
	}
	// *************

	// Função que converte ProdutoVendaDto em ProdutoVenda
	public List<ProdutoVenda> convertToProdutoVenda(List<ProdutoVendaDto> produtosVenda) {
		List<ProdutoVenda> produtos = new ArrayList<>();

		for (ProdutoVendaDto prod : produtosVenda) {
			ProdutoVenda produto = new ProdutoVenda();
			
			produto.setProdutoId(prod.getId());
			produto.setQntd(prod.getQntd());
			produto.setValorTotal(prod.getQntd() * estoqueSer.readEstoque(prod.getId()).getValor());
			produtos.add(produto);
			
			prodVendaRepo.save(produto);
		}
		
		return produtos;
	}
}
