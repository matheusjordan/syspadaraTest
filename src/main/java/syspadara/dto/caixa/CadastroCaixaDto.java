package syspadara.dto.caixa;

import java.util.List;

import syspadara.anotation.ListIdsValider;
import syspadara.anotation.ListValider;

public class CadastroCaixaDto {
	
	@ListValider
	@ListIdsValider
	private List<Long> vendasId;
	
	public CadastroCaixaDto() {
	}

	public CadastroCaixaDto(List<Long> vendasId) {
		this.vendasId = vendasId;
	}

	public List<Long> getVendasId() {
		return vendasId;
	}

	public void setVendas_id(List<Long> vendasId) {
		this.vendasId = vendasId;
	}
}
