package syspadara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.dto.produto.AlterarProdDto;
import syspadara.dto.produto.CadastroProdDto;
import syspadara.model.Estoque;
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

	// Função para encontrar produtos pelo ID - new
	public List<Estoque> findProdutosEstoque(List<Long> ids) {
		List<Estoque> produtos = estoqueRepo.findAllById(ids);
		return produtos;
	}

	// Função que retorna o valor de uma lista de produtos - new
	public double valueOfProducts(List<Estoque> produtos) {
		double valor = 0;

		for (Estoque produto : produtos) {
			valor += (produto.getValor() * produto.getQntd());
		}

		return valor;
	}
	
	//Função Change to produto está em ProdutoVenda

	public List<Estoque> findAllNomes(String nome) {
		return estoqueRepo.buscarProduto(nome);
	}
}
