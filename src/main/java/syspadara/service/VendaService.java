package syspadara.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.dto.Venda.AlterarVenDto;
import syspadara.dto.Venda.CadastroVenDto;
import syspadara.dto.pageament.FindDto;
import syspadara.dto.pageament.VendaPageDto;
import syspadara.model.Venda;
import syspadara.repository.VendaRepository;

@Service 
public class VendaService {
	private final Logger LOG = LoggerFactory.getLogger(VendaService.class);
	
	@Autowired
	private VendaRepository vendaRepo;

	@Autowired
	private ProdutoVendaService prodVendaSer;

	@Autowired
	private EstoqueService estoqueSer;

	// Funções CRUD***
	public void createVenda(CadastroVenDto vendaCadastro) throws Exception {
		Venda venda = new Venda();
		if (estoqueSer.isValid(vendaCadastro.getProdutos())) {
			venda.setProdutos(prodVendaSer.convertToProdutoVenda(vendaCadastro.getProdutos()));

			vendaRepo.save(venda);
			LOG.info("Venda: " + venda.getId() + " criada com sucesso!");
		} else
			LOG.error("Venda não realizada!");
			throw new Exception(
					"Verifique se a quantidade vendida dos produtos é menor ou igual ao estoque!");

	}

	public Venda readVenda(Long id) {
		return vendaRepo.findById(id).get();
	}

	public void updateVenda(AlterarVenDto vendaAltera) throws Exception {
		Venda venda = vendaRepo.findById(vendaAltera.getId()).get();

		if (estoqueSer.isValid(vendaAltera.getProdutos())) {
			venda.setProdutos(prodVendaSer.convertToProdutoVenda(vendaAltera.getProdutos()));

			vendaRepo.save(venda);
			LOG.info("Venda: " + venda.getId() + " alterada com sucesso!");
		} else {
			LOG.error("Venda não realizada!");
			throw new Exception("Verifique se a quantidade vendida dos produtos é menor ou igual ao estoque!");
		}
	}

	public void deleteVenda(Long id) {
		vendaRepo.deleteById(id);
		LOG.info("Venda: " + id + " removida com sucesso!");
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

	// Função que finaliza uma venda
	public void finalizeVenda(List<Venda> vendas) throws Exception{
		for (Venda venda : vendas) {
			venda.setStatus(1);
			estoqueSer.decrementaEstoque(venda.getProdutos());
			LOG.info("Venda: " + venda.getId() + " finalizada com sucesso! STATUS: " + venda.getStatus());
		}
	}
	
	//Função de paginação de vendas
	public VendaPageDto pageamentVenda(FindDto find) {
		List<Venda> vendas = this.readAll();
		List<Venda> listagem = new ArrayList<>();
		
		Integer page = find.getPage();
		Integer size = find.getSize();
	
		for(int i = ((page * size) - size); i < (page * size); i++) {
			listagem.add(vendas.get(i));
		}
		
		Integer totalPages = vendas.size() / size;
		Integer firstPage = totalPages - (totalPages -1);
		Integer finalPage = totalPages;
		Integer actualPage = page;
		Integer nextPage = page == finalPage ? finalPage : page + 1;
		Integer previousPage = page == firstPage ? firstPage : page - 1;
		
		return new VendaPageDto(firstPage, finalPage, actualPage, previousPage, nextPage, totalPages, listagem);
	}
}
