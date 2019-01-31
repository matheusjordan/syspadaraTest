package syspadara.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.dto.venda.VendaDto;
import syspadara.dto.venda.VendaProduto;
import syspadara.model.Produto;
import syspadara.model.Venda;
import syspadara.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepo;

	@Autowired
	private ProdutoService produtoSer;

	// Funções CRUD***
	public void createVenda(VendaDto cadastro) {
		try {
			List<Produto> produtos = this.validateVenda(cadastro);
			Venda venda = new Venda();

			venda.setProdutos(produtos);
			venda.setValor(produtoSer.valueOfProducts(produtos));
			venda.setStatus(0);
			
			for(Produto prod : venda.getProdutos()) {
				System.out.println(prod.getNome() +"\n"+ prod.getValor() +"\n"+ prod.getQntd());
			}
			System.out.println("Criado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Venda readVenda(Long id) {
		return vendaRepo.findById(id).get();
	}

	public void updateVenda(VendaDto cadastro) {
		try {
			List<Produto> produtos = this.validateVenda(cadastro);
			Venda venda = new Venda();

			venda.setProdutos(produtos);
			venda.setValor(produtoSer.valueOfProducts(produtos));
			venda.setStatus(0);

			vendaRepo.save(venda);
			System.out.println("Atualizado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteVenda(Long id) {
		Venda venda = vendaRepo.findById(id).get();
		vendaRepo.delete(venda);
		System.out.println("Deletado");
	}
	// *************

	// Algoritmo de verificação de uma venda - new
	public List<Produto> validateVenda(VendaDto cadastro) throws Exception {
		List<Boolean> validas = new ArrayList<>();

		// Verifica o tamanho das listas
		if (cadastro.getProdutosId().size() == cadastro.getProdutosQntd().size()) {

			for (int i = 0; i < cadastro.getProdutosId().size(); i++) {

				if (produtoSer.validateQntdVenda(cadastro.getProdutosId().get(i), cadastro.getProdutosQntd().get(i))) {
					validas.add(true);
				} else {
					validas.add(false);
				}
			}

			// Verifica se uma venda foi válida
			if (validas.contains(false)) {
				throw new Exception("Erro! Verifique a quantidade de seus produtos!");
			} else {
				List<VendaProduto> produtosVenda = new ArrayList<>();

				for (int i = 0; i < cadastro.getProdutosId().size(); i++) {
					VendaProduto produto = new VendaProduto(cadastro.getProdutosId().get(i),
							cadastro.getProdutosQntd().get(i));
					produtosVenda.add(produto);
					produtoSer.atualizaQnt(produto.getId(), produto.getQntd());
				}

				List<Produto> produtos = produtoSer.changeToProduto(produtosVenda);

				return produtos;
			}
		}
		throw new Exception("Erro! Verifique os produtos adicionados e suas respectivas quantidades!");
	}

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
