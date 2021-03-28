package com.telkom.finalproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.telkom.finalproject.jwt.JWTAuthenticationFilter;
import com.telkom.finalproject.jwt.JWTAuthorizationFilter;
import com.telkom.finalproject.service.AuthService;
import com.telkom.finalproject.utils.SecurityUtils;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	
	private AuthService authService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public WebSecurity(AuthService authService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.authService = authService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(authService).passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable().authorizeRequests()
		.antMatchers(SecurityUtils.SIGN_UP_URL).permitAll()
		.anyRequest().authenticated()
		.and()
		.addFilter(new JWTAuthenticationFilter(authenticationManager()))
		.addFilter(new JWTAuthorizationFilter(authenticationManager()))
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
//	@Bean
//	CorsConfigurationSource corsConfigurationSource(){
//		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
//		source.registerCorsConfiguration("/**", configuration);
//		return (CorsConfigurationSource) source;
//	}
}
