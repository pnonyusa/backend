package com.mypicknpay.webApi.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypicknpay.webApi.model.AppUser;
import com.mypicknpay.webApi.repository.AppUserRepository;



@Service
public class UserPrincipalService implements UserDetailsService {

	@Autowired
	private AppUserRepository userRepo;
	  @Override
	  @Transactional
	  public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
	 
	    AppUser user = userRepo.findByEmailAddress(emailAddress).orElseThrow(
	        () -> new UsernameNotFoundException("User Not Found with -> username or email : " + emailAddress));
	 
	    return UserPrinciple.build(user);
	  }
}
