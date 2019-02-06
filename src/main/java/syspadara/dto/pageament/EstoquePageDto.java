package syspadara.dto.pageament;

import java.util.List;

import syspadara.model.Estoque;

public class EstoquePageDto extends PageDto {
	private List<Estoque> estoques;

	//Construtores
	public EstoquePageDto() {
		super();
	}

	public EstoquePageDto(Integer firstPage, Integer finalPage, Integer actualPage, Integer previousPage,
			Integer nextPage, Integer totalPages, List<Estoque> estoques) {
		
		super(firstPage, finalPage, actualPage, previousPage, nextPage, totalPages, estoques.size());
		
		this.estoques = estoques;
	}

	//Metodos
	public List<Estoque> getEstoques() {
		return estoques;
	}

	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}
}