package syspadara.dto.venda;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VendaDto implements Serializable{

	private static final long serialVersionUID = 4923813067800086493L;
	
	//@NotNull | @NotEmpty-> Bean Validation -> serve para validar dados que eu passo atrvés do dto
	
	@NotNull
	@NotEmpty
	private List<Long> produtosId;
	
	@NotNull
	@NotEmpty
	private List<Integer> produtosQntd;
	
	//Construtores
	private VendaDto() {};
	
	private VendaDto(List<Long> produtosId, List<Integer> produtosQntd) {
		this.produtosId = produtosId;
		this.produtosQntd = produtosQntd;
	}
	
	//Metodos Getts e Setts
	public List<Long> getProdutosId() {
		return produtosId;
	}
	public void setProdutosId(List<Long> produtosId) {
		this.produtosId = produtosId;
	}
	public List<Integer> getProdutosQntd() {
		return produtosQntd;
	}
	public void setProdutosQntd(List<Integer> produtosQntd) {
		this.produtosQntd = produtosQntd;
	}
}
