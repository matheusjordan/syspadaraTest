package syspadara.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estoque implements Serializable {

	private static final long serialVersionUID = 8757157320173883249L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true, length = 50)
	private String nome;

	@Column(nullable = false)
	private Double valor;

	@Column(nullable = false)
	private Integer qntd;

	// CONSTRUTORES
	public Estoque() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Estoque(String nome, Double valor, Integer qntd) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.qntd = qntd;
	}

}
