package syspadara.dto.venda;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

//new class
//https://www.baeldung.com/javax-validation

public class VendaProduto {
	
	@NotNull
	@Positive
	private Long id;
	
	@NotNull
	@PositiveOrZero
	private Integer qntd;
	
	//CONSTRUTORES
	public VendaProduto() {}
	
	public VendaProduto(Long id, Integer qntd) {
		this.id = id;
		this.qntd = qntd;
	}

	//METODOS
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
