package syspadara.dto.pageament;

import java.util.List;

import syspadara.model.Caixa;

public class CaixaPageDto extends PageDto{
	private List<Caixa> caixas;
	
	
	//Construtores
	public CaixaPageDto() {
		super();
	}

	public CaixaPageDto(Integer firstPage, Integer finalPage, Integer acutalPage, Integer previousPage,
			Integer nextPage, Integer totalPages, List<Caixa> caixas) {
		super(firstPage, finalPage, acutalPage, previousPage, nextPage, totalPages, caixas.size());
	}

	public List<Caixa> getCaixas() {
		return caixas;
	}

	public void setCaixas(List<Caixa> caixas) {
		this.caixas = caixas;
	}
}
