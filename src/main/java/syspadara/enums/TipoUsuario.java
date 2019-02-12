package syspadara.enums;

public enum TipoUsuario {

	ADMIN(1, "ROLE_ADMIN"), CONSULTA(2, "ROLE_CONSULTA");
	
	private Integer cod;
	private String descricao;
	
	//Construtores
	private TipoUsuario(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	//Metodos
	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static TipoUsuario toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(TipoUsuario tipo : TipoUsuario.values()) {
			if(cod.equals(tipo.getCod())) {
				return tipo;
			}
		}
		
		throw new IllegalArgumentException("id inválido: " + cod);
	}
}
