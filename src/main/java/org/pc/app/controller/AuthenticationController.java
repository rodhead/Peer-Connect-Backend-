/**
 * 
 */
package org.pc.app.controller;

import org.pc.app.model.JwtRequest;
import org.pc.app.model.JwtResponse;
import org.pc.app.security.JwtTokenUtility;
import org.pc.app.service.JwtUserDetailsService;
import org.pc.app.utility.ResponseFormationUtil;
import org.pc.userRole.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author misbahRahman
 *
 */
@RestController
@CrossOrigin
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtility jwtTokenUtility;
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	ResponseFormationUtil responseFormationUtil;
	
	@RequestMapping(value="/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest autheticationRequest) throws Exception{
		authenticate(autheticationRequest.getUsername(), autheticationRequest.getPassword());
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(autheticationRequest.getUsername());
		final String token = jwtTokenUtility.generateTokenForUser(userDetails);
		UserResponse userResponse = responseFormationUtil.formUserResponse(autheticationRequest.getUsername());
		return ResponseEntity.ok(new JwtResponse(token,userResponse));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}
		catch(DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		}
		catch(BadCredentialsException e) {
			throw new Exception ("INVALID_CREDENTIALS", e);
		}
	}
	
	

}
