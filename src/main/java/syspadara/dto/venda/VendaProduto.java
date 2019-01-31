package syspadara.dto.venda;


//new class

public class VendaProduto {
	
	private Long id;
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
