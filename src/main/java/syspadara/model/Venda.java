package syspadara.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VENDA")
public class Venda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "venda_id")
	private int id;
	
	@Column(name = "venda_valor", nullable = false)
	private double valor;
	
	@OneToMany
	private List<Produto> produtos;

	// CONSTRUTORES
	protected Venda() {
	}

	public Venda(int id, double valor) {
		this.id = id;
		this.valor = valor;
	}

	// METODOS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
