package syspadara.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Venda implements Serializable {

	private static final long serialVersionUID = 1611715179517343039L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@ManyToMany
	@JoinTable(name = "venda_produtos")
	private List<Produto> produtos;

	@Column(name = "valor_total") 
	private double valor;
	
	@Column
	private int status;

	// CONSTRUTORES
	public Venda() {
	}
	
	public Venda(List<Produto> produtos, double valor, int status) {
		this.produtos = produtos;
		this.valor = valor;
		this.status = status;
	}

	// METODOS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public void addProduto(Produto produto) {
		this.produtos.add(produto);
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
