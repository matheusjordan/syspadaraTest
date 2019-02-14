package syspadara.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import syspadara.security.JWTAuthenticationFilter;
import syspadara.security.JWTAuthorizationFilter;
import syspadara.security.JWTUtil;

@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JWTUtil jwtUtil;
	
	private static final String[] PUBLIC_ENDPOINTS = { 
			"/swagger-ui.htm/"

	};

	private static final String[] PUBLIC_ENDPOINTS_GET = { 
			"/caixas/", 
			"/estoques/", 
			"/usuarios/", 
			"/vendas/"

	};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
		
		http.authorizeRequests()
			.antMatchers(PUBLIC_ENDPOINTS) // Configuração dos endpoint que posso acessar após estar												// authenticado
				.permitAll()
			.antMatchers(HttpMethod.GET, PUBLIC_ENDPOINTS_GET) // Configuração que autoriza meu acesso																// aos metodos GET
				.permitAll()								// dos endpoints pre configurados
				.anyRequest().authenticated();
	
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	
		//Filtro de authenticação
		http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
		
		//Filtro de authorização
		http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
}