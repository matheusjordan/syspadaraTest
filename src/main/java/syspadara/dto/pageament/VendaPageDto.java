package syspadara.dto.pageament;

import java.util.List;

import syspadara.model.Venda;

public class VendaPageDto extends PageDto {
	private List<Venda> vendas;

	// Construtores
	public VendaPageDto() {
		super();
	}

	public VendaPageDto(Integer firstPage, Integer finalPage, Integer actualPage, Integer previousPage,
			Integer nextPage, Integer totalPages, List<Venda> vendas) {
		
		super(firstPage, finalPage, actualPage, previousPage, nextPage, totalPages, vendas.size());
		this.vendas = vendas;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}
}
