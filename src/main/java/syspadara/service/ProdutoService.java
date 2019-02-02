package syspadara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.dto.produto.AlterarProdDto;
import syspadara.dto.produto.CadastroProdDto;
import syspadara.model.Produto;
import syspadara.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepo;

	// Funções CRUD***
	public void createProduto(CadastroProdDto produtoCadastro) {
		Produto produto = new Produto();

		produto.setNome(produtoCadastro.getNome());
		produto.setValor(produtoCadastro.getValor());
		produto.setQntd(produtoCadastro.getQntd());

		produtoRepo.save(produto);
		System.out.println("Criado");
	}

	public Produto readProduto(Long id) {
		return produtoRepo.findById(id).get();
	}

	public void updateProduto(AlterarProdDto produtoAltera) {
		Produto produto = produtoRepo.findById(produtoAltera.getId()).get();

		produto.setNome(produtoAltera.getNome());
		produto.setValor(produtoAltera.getValor());
		produto.setQntd(produtoAltera.getQntd());
		
		produtoRepo.save(produto);
		System.out.println("Atualizado");
	}

	public void deleteProduto(Long id) {
		produtoRepo.deleteById(id);
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
	
	//Função Change to produto está em ProdutoVenda

	public List<Produto> findAllNomes(String nome) {
		return produtoRepo.buscarProduto(nome);
	}
}
