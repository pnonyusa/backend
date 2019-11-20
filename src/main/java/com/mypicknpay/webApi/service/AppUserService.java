package com.mypicknpay.webApi.service;













import java.util.HashSet;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.mypicknpay.webApi.jwt.response.JwtResponse;

import com.mypicknpay.webApi.jwt.response.ResponseMessage;
import com.mypicknpay.webApi.model.AppUser;


import com.mypicknpay.webApi.model.Role;
import com.mypicknpay.webApi.model.login.LoginCredentials;
import com.mypicknpay.webApi.model.login.SignUpUser;
import com.mypicknpay.webApi.repository.AppUserRepository;
import com.mypicknpay.webApi.repository.RoleRepository;
import com.mypicknpay.webApi.security.jwt.JwtProvider;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;



 

//import com.mypicknpay.webApi.repository.RoleRepository;



@Service
@Component
@ComponentScan(basePackages= {"com.mypicknpay.webApi.repository","com.mypicknpay.webApi.security.jwt","com.mypicknpay.webApi.security.config"})
public class AppUserService {
      
	 @Autowired
	 PasswordEncoder encoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
    JwtProvider jwtProvider;
	
	@Autowired
	private AppUserRepository appUserRepo;
	
	@Autowired
	private RoleRepository userRole;

	
	
	

	
	
	//register the user and with specified role
	public ResponseEntity<?> addAppUser(SignUpUser userSignup) {
	   
		 if (appUserRepo.existsByEmailAddress(userSignup.getEmailAddress())) {
		      return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
		          HttpStatus.BAD_REQUEST);
		 }
		 
		 
		    AppUser user =new AppUser();
		    String strRoles = userSignup.getRole();
		    Set<Role> roles = new HashSet<>();
		 
		    
		      switch (strRoles) {
		      case "admin":
		        Role adminRole = userRole.findByRoleName("ADMIN")
		            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
		        roles.add(adminRole);
		        break;
		      case "user":
		        Role pmRole = userRole.findByRoleName("USER")
		            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
		        roles.add(pmRole);
		        break;
		      }
		    
		    
		     user.setRoles(roles);
		     user.setActive(1);
			 user.setC_Password(encoder.encode(userSignup.getPassword()));
			 user.setEmailAddress(userSignup.getEmailAddress());
			 user.setName(userSignup.getName());
			 user.setC_Surname(userSignup.getC_Surname());
			 appUserRepo.save(user);
			 
			  user=null;
			 return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
		   
		/* String userRoles = userSignup.getRole();
		 
		 Role adminRole=userRole.findByRoleName(RoleName.ROLE_ADMIN).get();
		 if(userRoles.equalsIgnoreCase(adminRole.getRoleName().name())){ 
			 user.setActive(1);
			 user.setC_Password(encoder.encode(userSignup.getPassword()));
			 user.setEmailAddress(userSignup.getEmailAddress());
			 user.setName(userSignup.getName());
			 user.setC_Surname(userSignup.getC_Surname());
			 appUserRepo.save(user);
			 return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);	 
		 }
		 else{ 
			 user.setActive(1);
			 user.setC_Password(encoder.encode(userSignup.getPassword()));
			 user.setEmailAddress(userSignup.getEmailAddress());
			 user.setName(userSignup.getName());
			 user.setC_Surname(userSignup.getC_Surname());
			 appUserRepo.save(user);
			 return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
		 }*/
		 
		  	  
	}
	
	
	
	
	
	//it authenticate the user credentials n role
	public ResponseEntity<?> isLoggedIn(LoginCredentials loginUser) {
		
	    Authentication authentication = authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(loginUser.getEmailAddress(), loginUser.getPassword()));
	     
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	     
	        String jwt = jwtProvider.generateJwtToken(authentication);
	        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	     
	        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));	   
	}
	
	
	
	/*
	 * These are the user and admin dashboards methods
	 * */
	

	  
	  
	  
	
	
}
