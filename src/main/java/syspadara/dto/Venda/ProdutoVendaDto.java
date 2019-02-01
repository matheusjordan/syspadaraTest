package syspadara.dto.Venda;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ProdutoVendaDto {
	
	@NotNull
	@Positive
	private Long id;
	
	@NotNull
	@Positive
	private Integer qntd;
	
	//Construtores
	public ProdutoVendaDto() {
	}
	
	public ProdutoVendaDto(Long id, Integer qntd) {
		this.id = id;
		this.qntd = qntd;
	}

	//Metodos
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getQntd() {
		return qntd;
	}
	public void setQntd(Integer qntd) {
		this.qntd = qntd;
	}
	
	
}
