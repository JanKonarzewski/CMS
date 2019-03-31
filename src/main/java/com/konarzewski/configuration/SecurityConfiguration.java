package com.konarzewski.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableJpaRepositories
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	AuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Autowired
	UserDetailsService myUserDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.POST ,"/register","/signup","/submitArticle").permitAll()
			.antMatchers("**/teacher/**").hasRole("ADMIN")
			.antMatchers("**/student/**").hasRole("ADMIN")
			.antMatchers("**/admin/**").hasRole("ADMIN")
			.and().formLogin().loginPage("/").permitAll().successHandler(authenticationSuccessHandler)
			.and().httpBasic();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/submitArticle");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
	  throws Exception {
	    auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder()); 
	}
	
	@Bean()
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
}