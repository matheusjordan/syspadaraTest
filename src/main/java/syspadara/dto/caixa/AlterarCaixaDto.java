package syspadara.dto.caixa;

import java.util.List;

import javax.validation.constraints.Positive;

import syspadara.anotation.ListIdsValider;
import syspadara.anotation.ListValider;

public class AlterarCaixaDto {
	
	@Positive
	private Long caixaId;
	
	@ListValider
	@ListIdsValider
	private List<Long> vendasId;
	
	//Construtores
	public AlterarCaixaDto() {
	}
	
	public AlterarCaixaDto(Long caixaId, List<Long> vendasId) {
		this.caixaId = caixaId;
		this.setVendasId(vendasId);
	}

	//Metodos
	public Long getCaixaId() {
		return caixaId;
	}

	public void setCaixaId(Long caixaId) {
		this.caixaId = caixaId;
	}

	public List<Long> getVendasId() {
		return vendasId;
	}

	public void setVendasId(List<Long> vendasId) {
		this.vendasId = vendasId;
	}
	
}
