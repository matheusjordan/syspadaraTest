package syspadara.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import syspadara.dto.pageament.EstoquePageDto;
import syspadara.dto.pageament.FindDto;
import syspadara.dto.produto.AlterarProdDto;
import syspadara.dto.produto.CadastroProdDto;
import syspadara.dto.produto.EstoqueQueryDto;
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
//	public List<Estoque> findProdutosEstoque(List<Long> ids) {
//		List<Estoque> produtos = estoqueRepo.findAllById(ids);
//		return produtos;
//	}

	// Função que retorna o valor de uma lista de produtos
//	public double valueOfProducts(List<Estoque> produtos) {
//		double valor = 0;
//
//		for (Estoque produto : produtos) {
//			valor += (produto.getValor() * produto.getQntd());
//		}
//
//		return valor;
//	}

	// Função que retorna os dados de um produto pelo nome
	public List<Estoque> findAllNomes(String nome) {
		return estoqueRepo.buscarProduto(nome);
	}

	// Função que verifica se uma venda é valida! - new
	public boolean isValid(List<ProdutoVendaDto> produtos) {
		List<Boolean> isvalid = new ArrayList<>();

		for (ProdutoVendaDto produto : produtos) {
			if (produto.getQntd() <= this.readEstoque(produto.getId()).getQntd()) {
				isvalid.add(true);
			} else {
				isvalid.add(false);
			}
		}

		return isvalid.contains(false) ? false : true;
	}

	// Função que verifica se um decremento é valido
	public boolean isValidDecremento(List<ProdutoVenda> produtos) {
		List<Boolean> isvalid = new ArrayList<>();

		for (ProdutoVenda produto : produtos) {
			Estoque prod = this.readEstoque(produto.getProdutoId());

			if (produto.getQntd() <= prod.getQntd()) {
				isvalid.add(true);
			} else {
				isvalid.add(false);
			}
		}

		return isvalid.contains(false) ? false : true;
	}

	// Função que decrementa o estoque de um produto após uma venda
	public void decrementaEstoque(List<ProdutoVenda> produtos) throws Exception {

		if (this.isValidDecremento(produtos)) {
			for (ProdutoVenda produto : produtos) {
				Estoque estoque = this.readEstoque(produto.getProdutoId());
				estoque.setQntd(estoque.getQntd() - produto.getQntd());
			}
		} else
			throw new Exception(
					"Venda não realizada! Verifique se a quantidade vendida dos produtos é menor ou igual ao estoque!");
	}

	// Função para retornar produtos que contenham um nome ou valor ou qntd em comum
	public List<Estoque> findByParam(EstoqueQueryDto query) {
		Estoque estoque = new Estoque(query.getNome(), query.getValor(), query.getQntd());

		// Classe que define os valores que irei utilizar no filtro
		ExampleMatcher matcher = ExampleMatcher.matchingAll().withMatcher("nome", match -> match.contains())
				.withMatcher("valor", match -> match.contains()).withMatcher("qntd", match -> match.contains())
				.withIgnoreNullValues();

		// Criação do meu exemplo que retorna uma lista de produtos de acordo com os
		// parametros de filtro
		Example<Estoque> searchExample = Example.of(estoque, matcher);
		return estoqueRepo.findAll(searchExample);
	}

	// Função de mapeamento do estoque
	public EstoquePageDto pageamentEstoque(FindDto find) {
		List<Estoque> estoque = this.readAll();
		List<Estoque> listagem = new ArrayList<>();
		
		Integer page = find.getPage();
		Integer size = find.getSize();
		
		for (int i = ((page * size) - size); i < (page * size); i++) {
			listagem.add(estoque.get(i));
		}

		Integer actualPage = page;
		Integer previousPage = page - 1;
		Integer nextPage = page + 1;
		Integer totalPages = estoque.size() / size;
		Integer firstPage = totalPages - (totalPages - 1);
		Integer finalPage = totalPages;
		
		return new EstoquePageDto(firstPage, finalPage,
									actualPage, previousPage,
									nextPage, totalPages,
									listagem);
	}
}
