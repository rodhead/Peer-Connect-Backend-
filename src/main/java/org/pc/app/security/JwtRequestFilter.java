package org.pc.app.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pc.app.constants.SecurityConstants;
import org.pc.app.service.JwtUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{
	
	private static final Logger log = LoggerFactory.getLogger(JwtRequestFilter.class);
	
	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;
	
	@Autowired
	private JwtTokenUtility jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		log.info("Inside doFilterInternal method");
		final String requestTokenHeader = request.getHeader("Authorization");
		
		String userName = null;
		String jwtToken = null;
		
		if(requestTokenHeader != null && requestTokenHeader.startsWith(SecurityConstants.BEARER)) {
			jwtToken = requestTokenHeader.substring(SecurityConstants.BEARER_SUBSTRING_INDEX);
			try {
				userName = jwtTokenUtil.getUserNameFromToken(jwtToken);
			}catch(IllegalArgumentException e){
				log.error("Unable to get JWT Token", e);
			}catch(ExpiredJwtException e) {
				log.error("JWT Token has expired", e);
			}
		}
		else {
			log.warn("JWT Token does not begin with Bearer String");
		}
		
		if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			 UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(userName);
			 if(jwtTokenUtil.validateToken(jwtToken, userDetails)) {
				 UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
						 new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
				 usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				 SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			 }
		}
		chain.doFilter(request, response);
	}

}
