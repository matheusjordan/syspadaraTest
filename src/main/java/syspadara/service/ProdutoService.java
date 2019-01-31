package syspadara.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.dto.venda.VendaProduto;
import syspadara.model.Produto;
import syspadara.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepo;

	// Funções CRUD***
	public void createProduto(Produto produto) {
		try {
			if (this.validateProduto(produto.getQntd(), produto.getValor())) {
				produtoRepo.save(produto);
				System.out.println("Criado");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}

	public Produto readProduto(Long id) {
		return produtoRepo.findById(id).get();
	}

	public void updateProduto(Produto produto) {
		try {
			if (this.validateProduto(produto.getQntd(), produto.getValor())) {
				produtoRepo.save(produto);
				System.out.println("Atualizado");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}

	public void deleteProduto(Long id) {
		Produto produto = produtoRepo.findById(id).get();
		produtoRepo.delete(produto);
		System.out.println("Deletado");
	}
	// *************

	public List<Produto> readAll() {
		return produtoRepo.findAll();
	}

	// Função para encontrar produtos pelo ID - new
	public List<Produto> findProdutos(List<Long> ids) {
		List<Produto> produtos = produtoRepo.findAllById(ids);
		return produtos;
	}

	// Função que retorna o valor de uma lista de produtos - new
	public double valueOfProducts(List<Produto> produtos) {
		double valor = 0;

		for (Produto produto : produtos) {
			valor += (produto.getValor() * produto.getQntd());
		}

		return valor;
	}

	// Função para validar qntd na criação de um produto - new
	public boolean validateProduto(Integer qntd, double valor) throws Exception {
		if (qntd >= 0 && valor >= 0) {
			return true;
		}
		throw new Exception("Erro! Quantidade ou Valor menor que zero");
	}

	// Função para validar a qntd vendida de um produto - new
	public boolean validateQntdVenda(Long id, Integer qntd) {
		Produto produto = produtoRepo.findById(id).get();

		// Valida se um produto possui qntd suficiente no estoque
		if (produto.getQntd() >= qntd && qntd > 0) {
			return true;
		}
		return false;
	}

	// Função para converter DtoProduto em Produto - new
	public List<Produto> changeToProduto(List<VendaProduto> produtosVenda) {
		List<Produto> produtos = new ArrayList<>();

		for (VendaProduto prodVenda : produtosVenda) {
			Produto produto = new Produto();
			Produto prod = this.readProduto(prodVenda.getId());

			produto.setId(prodVenda.getId());
			produto.setNome(prod.getNome());
			produto.setQntd(prodVenda.getQntd());
			produto.setValor(prod.getValor() * prodVenda.getQntd());
			produtos.add(produto);
		}

		return produtos;
	}

	// Função para atualizar qnd no estoque de um produto
	public void atualizaQnt(Long id, Integer qntd) {
		Produto produto = produtoRepo.findById(id).get();
		produto.setQntd(produto.getQntd() - qntd);
		produtoRepo.save(produto);
	}

	public List<Produto> findAllNomes(String nome) {
		return produtoRepo.buscarProduto(nome);
	}
}
