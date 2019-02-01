package syspadara.dto.produto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

public class CadastroProdDto {
	
	@NotBlank
	private String nome;
	
	@NotNull
	@Positive
	private Double valor;
	
	@NotNull
	@PositiveOrZero
	private Integer qntd;
	
	//Construtores
	public CadastroProdDto() {
	}
	
	public CadastroProdDto(String nome, Double valor, Integer qntd) {
		this.nome = nome;
		this.valor = valor;
		this.qntd = qntd;
	}
	
	//Metodos
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Integer getQntd() {
		return qntd;
	}
	public void setQntd(Integer qntd) {
		this.qntd = qntd;
	}
	
	
}
