package syspadara.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Venda implements Serializable {

	private static final long serialVersionUID = 1611715179517343039L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@OneToMany
	private List<ProdutoVenda> produtos;
	
	@Column
	private int status;

	// CONSTRUTORES
	public Venda() {
	}
	
	public Venda(List<ProdutoVenda> produtos) {
		this.produtos = produtos;
	}

	// METODOS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ProdutoVenda> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoVenda> produtos) {
		this.produtos = produtos;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
