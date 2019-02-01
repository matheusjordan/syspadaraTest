package syspadara.dto.Venda;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class AlterarVenDto extends CadastroVenDto{
	
	@NotNull
	@Positive
	private Long id;
	
	public AlterarVenDto(List<ProdutoVendaDto> produtos, Long id) {
		super(produtos);
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
