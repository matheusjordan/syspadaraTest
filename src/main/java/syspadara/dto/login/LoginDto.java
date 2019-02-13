package syspadara.dto.login;

public class LoginDto {
	private String username;
	private String password;
	
	//Construtores
	public LoginDto() {
	}

	public LoginDto(String username, String password) {
		this.username = username;
		this.password = password;
	}

	//Metodos
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
