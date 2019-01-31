package syspadara.dto.produto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import syspadara.anotations.NotNegative;

public class ProdutoDto {
	
	@NotEmpty
	@NotNull
	private String nome;
	
	@NotNull
	@PositiveOrZero
	private Integer qntd;
	
	@NotNegative
	private Double valor;

	//CONSTRUTORES
	public ProdutoDto() {
	}
	
	public ProdutoDto(String nome, Integer qntd, Double valor) {
		this.nome = nome;
		this.qntd = qntd;
		this.valor = valor;
	}

	//METODOS
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQntd() {
		return qntd;
	}

	public void setQntd(Integer qntd) {
		this.qntd = qntd;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	

}
