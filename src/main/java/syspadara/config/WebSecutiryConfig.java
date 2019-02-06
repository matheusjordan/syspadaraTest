//Classe de configuração do spring security

package syspadara.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecutiryConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.
		
			//Configura as permissões de acesso as URLS
			authorizeRequests()		//O usuário precisa estar authenticado
				.anyRequest()		//Para poder enviar e receber
				.authenticated()	//requisições
			.and()
			.formLogin()
				.loginPage("/login")
				.permitAll();
	}
}
