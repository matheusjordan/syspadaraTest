package syspadara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import syspadara.dto.caixa.AlterarCaixaDto;
import syspadara.dto.caixa.CadastroCaixaDto;
import syspadara.model.Caixa;
import syspadara.repository.CaixaRepository;

@Service
public class CaixaService {
	
	@Autowired
	private CaixaRepository caixaRepo;
	
	@Autowired
	private VendaService vendaSer;
	
	// Funções CRUD***
	public void createCaixa(CadastroCaixaDto cadastroCaixa) {
		Caixa caixa = new Caixa();
		caixa.setVendas(vendaSer.findVendas(cadastroCaixa.getVendas_id()));
		caixaRepo.save(caixa);
		System.out.println("Criado");
	}
	
	public Caixa readCaixa(Long id) {
		return caixaRepo.findById(id).get();
	}
	
	public void updateCaixa(AlterarCaixaDto updateCaixa) {
		Caixa caixa = caixaRepo.findById(updateCaixa.getCaixaId()).get();
		caixa.setVendas(vendaSer.findVendas(updateCaixa.getVendasId()));
		caixaRepo.save(caixa);
		System.out.println("Alterado");
	}
	
	public void deleteCaixa(Long id) {
		caixaRepo.deleteById(id);
	}
	// *************

	public List<Caixa> readAll(){
		return caixaRepo.findAll();
	}
	
	public void addVenda(AlterarCaixaDto updateCaixa) {
		Caixa caixa = caixaRepo.findById(updateCaixa.getCaixaId()).get();
		caixa.addVendas(vendaSer.findVendas(updateCaixa.getVendasId()));
		caixaRepo.save(caixa);
		System.out.println("Adicionado");
	}
}
