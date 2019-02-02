package syspadara.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProdutoVenda implements Serializable{

	private static final long serialVersionUID = 6065032451517215950L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long produtoId;
	
	private Integer qntd;
	
	@Column(name = "valor_venda")
	private Double valorTotal;

	//Construtores
	public ProdutoVenda() {
	}

	public ProdutoVenda(Long produtoId, Integer qntd) {
		this.produtoId = produtoId;
		this.qntd = qntd;
	}

	//MEtodos
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	public Integer getQntd() {
		return qntd;
	}

	public void setQntd(Integer qntd) {
		this.qntd = qntd;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
