package syspadara.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.dto.produto.ProdutoVendaDto;
import syspadara.model.ProdutoVenda;
import syspadara.repository.ProdutoVendaRepository;

@Service 
public class ProdutoVendaService {
	private final Logger LOG = LoggerFactory.getLogger(ProdutoVendaService.class);

	@Autowired
	private ProdutoVendaRepository prodVendaRepo;
	
	@Autowired
	private EstoqueService estoqueSer;

	// Funções CRUD***
	public void createProdutoVenda(ProdutoVenda produto) {
		prodVendaRepo.save(produto);
		LOG.info("Produto: " + produto.getId() + " adicionado a venda com sucesso!");
	}

	public ProdutoVenda readProduto(Long id) {
		return prodVendaRepo.findById(id).get();
	}

	public void updateProduto(ProdutoVenda produto) {
		prodVendaRepo.save(produto);
		LOG.info("Produto: " + produto.getId() + " alterado na venda com sucesso!");
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
