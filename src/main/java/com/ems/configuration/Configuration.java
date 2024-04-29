package com.ems.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ems.filters.Pre_filter;

@org.springframework.context.annotation.Configuration
@EnableWebSecurity
public class Configuration extends WebSecurityConfigurerAdapter{
		
		

		@Autowired
		private Pre_filter filters;
		 
		@Bean
		public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception
		{
			return configuration.getAuthenticationManager();
		}
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			 super.configure(auth);
		}
	 
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// TODO Auto-generated method stub
			http.cors(c->c.disable())
			.csrf(cr->cr.disable())
			.authorizeHttpRequests(auth->auth.antMatchers("/auth/**","/emp/register","/admin/register").permitAll()
					.antMatchers("/emp/**").hasRole("USER")
					.antMatchers("/admin/**").hasRole("ADMIN")
					.anyRequest().authenticated())
			.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
			
			http.addFilterBefore(filters, UsernamePasswordAuthenticationFilter.class);
			
		
		}


	 
	}

	

