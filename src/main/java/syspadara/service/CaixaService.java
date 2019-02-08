package syspadara.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.dto.caixa.AlterarCaixaDto;
import syspadara.dto.caixa.CadastroCaixaDto;
import syspadara.model.Caixa;
import syspadara.repository.CaixaRepository;

@Service
public class CaixaService {
	
	private final Logger LOG = LoggerFactory.getLogger(CaixaService.class);

	@Autowired
	private CaixaRepository caixaRepo;

	@Autowired
	private VendaService vendaSer;

	// Funções CRUD***
	public void createCaixa(CadastroCaixaDto cadastroCaixa) throws Exception {
		Caixa caixa = new Caixa();

		// 1- Pega a lista de IDs //2- Tranformas os Ids em ProdutoVenda //3- Finaliza a
		// venda
		vendaSer.finalizeVenda(vendaSer.findVendas(cadastroCaixa.getVendasId()));

		caixa.setVendas(vendaSer.findVendas(cadastroCaixa.getVendasId()));
		caixaRepo.save(caixa);
		LOG.info("Caixa: " + caixa.getId() + " criado com sucesso!");
	}

	public Caixa readCaixa(Long id) {
		return caixaRepo.findById(id).get();
	}

	public void updateCaixa(AlterarCaixaDto updateCaixa) throws Exception{
		Caixa caixa = caixaRepo.findById(updateCaixa.getCaixaId()).get();

		vendaSer.finalizeVenda(vendaSer.findVendas(updateCaixa.getVendasId()));

		caixa.setVendas(vendaSer.findVendas(updateCaixa.getVendasId()));
		caixaRepo.save(caixa);
		LOG.info("Caixa: " + caixa.getId() + " alterado com sucesso!");
	}

	public void deleteCaixa(Long id) {
		caixaRepo.deleteById(id);
		LOG.info("Caixa: " + id + " removido com sucesso!");
	}
	// *************

	public List<Caixa> readAll() {
		return caixaRepo.findAll();
	}

	// Função que adiciona uma venda ao caixa
	public void addVenda(AlterarCaixaDto updateCaixa) throws Exception{
		Long caixaId = updateCaixa.getCaixaId();
		Caixa caixa = caixaRepo.findById(caixaId).get();

		vendaSer.finalizeVenda(vendaSer.findVendas(updateCaixa.getVendasId()));

		caixa.addVendas(vendaSer.findVendas(updateCaixa.getVendasId()));
		caixaRepo.save(caixa);
		LOG.info("Vendas foram adicionadas ao caixa: " + caixa.getId() + " com sucesso!");
	}
}
