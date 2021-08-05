package br.com.zupacademy.victor.transacao.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import static org.springframework.http.HttpMethod.GET;

@Configuration
public class ConfiguracaoSeguranca extends WebSecurityConfigurerAdapter {

	  @Override
	    protected void configure(HttpSecurity http) throws Exception{
		  http.authorizeRequests(authorizeRequests ->
          authorizeRequests
          			.antMatchers(GET, "api/propostas/**").hasAuthority("SCOPE_cartao:read")
          			.anyRequest().authenticated()
				  )
		  .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
	  }

}