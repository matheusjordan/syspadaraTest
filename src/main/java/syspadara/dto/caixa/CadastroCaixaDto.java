package syspadara.dto.caixa;

import java.util.List;

import syspadara.anotation.ListIdsValider;
import syspadara.anotation.ListValider;

public class CadastroCaixaDto {
	
	@ListValider
	@ListIdsValider
	private List<Long> vendas_id;
	
	public CadastroCaixaDto() {
	}

	public CadastroCaixaDto(List<Long> vendas_id) {
		this.vendas_id = vendas_id;
	}

	public List<Long> getVendas_id() {
		return vendas_id;
	}

	public void setVendas_id(List<Long> vendas_id) {
		this.vendas_id = vendas_id;
	}

	
}
