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
	private ProdutoVendaRepository prodVendaSer;
	
	@Autowired
	private EstoqueService estoqueRepo;

	// Funções CRUD***
	public void createProdutoVenda(ProdutoVenda produto) {
		prodVendaSer.save(produto);
		System.out.println("Vendido");
	}

	public ProdutoVenda readProduto(Long id) {
		return prodVendaSer.findById(id).get();
	}

	public void updateProduto(ProdutoVenda produto) {
		prodVendaSer.save(produto);
		System.out.println("Alterado");
	}

	public void deleteProduto(Long id) {
		prodVendaSer.deleteById(id);
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
			produto.setValorTotal(prod.getQntd() * estoqueRepo.readEstoque(prod.getId()).getValor());
			produtos.add(produto);
			prodVendaSer.save(produto);
		}
		
		return produtos;
	}
}
