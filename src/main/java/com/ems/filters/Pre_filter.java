package com.ems.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ems.userdetails.ProjectUserDetails;
import com.ems.utils.Jwtutil;

@Component
public class Pre_filter extends OncePerRequestFilter {
	@Autowired
	private Jwtutil jwtUtils;
	
	@Autowired
	private ProjectUserDetails projectUserDetails;
 
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String headerToken = request.getHeader("Authorization");
		String jwtToken = null;
		
//		System.err.println(headerToken);
		if(headerToken != null && headerToken.startsWith("Bearer "))
		{
			
			jwtToken = headerToken.substring(7);
			String username = jwtUtils.extractUsername(jwtToken);
			projectUserDetails.setRole(request.getHeader("role"));
//			System.err.println(request.getHeader("role"));
			UserDetails userDetails = projectUserDetails.loadUserByUsername(username);
			
			if(jwtUtils.validateToken(jwtToken, userDetails))
			{
//				System.err.println(userDetails+jwtToken);
				UsernamePasswordAuthenticationToken uAAToken = new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
				uAAToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(uAAToken);
			}
		}
		filterChain.doFilter(request, response);
		
	}
}
