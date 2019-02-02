//package syspadara.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import syspadara.model.Caixa;
//import syspadara.repository.CaixaRepository;
//
//@Service
//public class CaixaService {
//	
//	@Autowired
//	private CaixaRepository caixaRepo;
//	
//	// Funções CRUD***
//	public void createCaixa(Caixa caixa) {
//		caixaRepo.save(caixa);
//	}
//	
//	public Caixa readCaixa(Long id) {
//		return caixaRepo.findById(id).get();
//	}
//	
//	public void updateCaixa(Caixa caixa) {
//		caixaRepo.save(caixa);
//	}
//	
//	public void deleteCaixa(Long id) {
//		caixaRepo.deleteById(id);
//	}
//	// *************
//
//	public List<Caixa> readAll(){
//		return caixaRepo.findAll();
//	}
//}
