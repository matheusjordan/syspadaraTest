package syspadara.dto.Venda;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import syspadara.dto.produto.ProdutoVendaDto;

public class CadastroVenDto {
	
	@NotEmpty
	private List<ProdutoVendaDto> produtos;
	
	//Construtores
	public CadastroVenDto() {
	}

	public CadastroVenDto(List<ProdutoVendaDto> produtos) {
		this.produtos = produtos;
	}
	
	//Metodos
	public List<ProdutoVendaDto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoVendaDto> produtos) {
		this.produtos = produtos;
	}
}
