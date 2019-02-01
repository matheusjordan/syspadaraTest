package syspadara.dto.produto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class AlterarProdDto extends CadastroProdDto{
	
	@NotNull
	@Positive
	private Long id;

	public AlterarProdDto() {
		super();
	}

	public AlterarProdDto(String nome, Double preço, Integer qntd, Long id) {
		super(nome, preço, qntd);
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
