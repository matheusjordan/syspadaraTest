package syspadara.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.dto.produto.AlterarProdDto;
import syspadara.dto.produto.CadastroProdDto;
import syspadara.dto.produto.ProdutoVendaDto;
import syspadara.model.Estoque;
import syspadara.model.ProdutoVenda;
import syspadara.repository.EstoqueRepository;

@Service
public class EstoqueService {

	@Autowired
	private EstoqueRepository estoqueRepo;

	// Funções CRUD***
	public void createEstoque(CadastroProdDto produtoCadastro) {
		Estoque produto = new Estoque();

		produto.setNome(produtoCadastro.getNome());
		produto.setValor(produtoCadastro.getValor());
		produto.setQntd(produtoCadastro.getQntd());

		estoqueRepo.save(produto);
		System.out.println("Criado");
	}

	public Estoque readEstoque(Long id) {
		return estoqueRepo.findById(id).get();
	}

	public void updateEstoque(AlterarProdDto produtoAltera) {
		Estoque produto = estoqueRepo.findById(produtoAltera.getId()).get();

		produto.setNome(produtoAltera.getNome());
		produto.setValor(produtoAltera.getValor());
		produto.setQntd(produtoAltera.getQntd());
		
		estoqueRepo.save(produto);
		System.out.println("Atualizado");
	}

	public void deleteEstoque(Long id) {
		estoqueRepo.deleteById(id);
		System.out.println("Deletado");
	}
	// *************

	public List<Estoque> readAll() {
		return estoqueRepo.findAll();
	}

	// Função para encontrar produtos pelo ID
	public List<Estoque> findProdutosEstoque(List<Long> ids) {
		List<Estoque> produtos = estoqueRepo.findAllById(ids);
		return produtos;
	}

	// Função que retorna o valor de uma lista de produtos
	public double valueOfProducts(List<Estoque> produtos) {
		double valor = 0;

		for (Estoque produto : produtos) {
			valor += (produto.getValor() * produto.getQntd());
		}

		return valor;
	}
	
	//Função Change to produto está em ProdutoVenda

	//Função que retorna os dados de um produto pelo nome
	public List<Estoque> findAllNomes(String nome) {
		return estoqueRepo.buscarProduto(nome);
	}
	
	//Função que verifica se uma venda é valida! - new
	public boolean isValid(List<ProdutoVendaDto> produtos) {
		List<Boolean> isvalid = new ArrayList<>();
		
		for(ProdutoVendaDto produto : produtos) {
			if(produto.getQntd() <= this.readEstoque(produto.getId()).getQntd()) {
				isvalid.add(true);
			} else {
				isvalid.add(false);
			}
		}
		
		return isvalid.contains(false) ? false : true;
	}
	
	//Função que decrementa o estoque de um produto após uma venda - new
	public void decrementaEstoque(List<ProdutoVenda> produtos) {
		
		for(ProdutoVenda produto : produtos) {
			Estoque estoque = this.readEstoque(produto.getProdutoId());
			estoque.setQntd(estoque.getQntd() - produto.getQntd());
		}
	}
}
