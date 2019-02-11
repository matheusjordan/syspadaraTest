package syspadara.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private static final String[] PUBLIC_ENDPOINTS = {
		"/swagger-ui.htm/**"
			
	};
	
	private static final String[] PUBLIC_ENDPOINTS_GET = {
			"/caixas/**",
			"/estoques/**",
			"/usuarios/**",
			"/vendas/**"
			
	};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.antMatchers(PUBLIC_ENDPOINTS) //Configuração dos endpoint que posso acessar após estar authenticado
				.permitAll()
			.antMatchers(HttpMethod.GET, PUBLIC_ENDPOINTS_GET) // Configuração que autoriza meu acesso aos metodos GET
				.permitAll()									// dos endpoints pre configurados 
			.anyRequest().authenticated()
			.and()
			.formLogin()
				.defaultSuccessUrl("/swagger-ui.htm/");
	}
}