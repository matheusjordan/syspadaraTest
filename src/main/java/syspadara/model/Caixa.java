package syspadara.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import syspadara.model.Venda;

@Entity
public class Caixa implements Serializable{
	
	private static final long serialVersionUID = -283832230485002225L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany
	@JoinTable(name = "caixa_vendas")
	private List<Venda> vendas;

	public Caixa() {
	}
	
	public Caixa(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
		
	}
	
	public void addVendas(List<Venda> vendas) {
		for(Venda venda : vendas) {
			this.vendas.add(venda);
		}
	}
}
