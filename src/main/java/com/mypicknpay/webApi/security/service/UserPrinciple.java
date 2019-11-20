package com.mypicknpay.webApi.security.service;


import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mypicknpay.webApi.model.AppUser;

public class UserPrinciple implements UserDetails {

	  private static final long serialVersionUID = 1L;
	  
	  private Long id;
	 
	    private String name;
	 
	    private String c_Surname;
	 
	    private String emailAddress;
	 
	    @JsonIgnore
	    private String password;
	 
	    private Collection<? extends GrantedAuthority> authorities;
	 
	    public UserPrinciple(Long id, String name, 
	              String c_Surname, String emailAddress, String password, 
	              Collection<? extends GrantedAuthority> authorities) {
	        this.id = id;
	        this.name = name;
	        this.c_Surname = c_Surname;
	        this.emailAddress = emailAddress;
	        this.password = password;
	        this.authorities = authorities;
	    }
	 
	    public static UserPrinciple build(AppUser user) {
	        List<SimpleGrantedAuthority> authorities = user.getRoles().stream().map(role ->
	                new SimpleGrantedAuthority(role.getRoleName())
	        ).collect(Collectors.toList());
	 
	        return new UserPrinciple(
	                user.getC_id(),
	                user.getName(),
	                user.getC_Surname(),
	                user.getEmailAddress(),
	                user.getC_Password(),
	                authorities
	        );
	    }
	 
	    public Long getId() {
	        return id;
	    }
	 
	    public String getName() {
	        return name;
	    }
	 
	    public String getC_Surname() {
	        return c_Surname;
	    }
	 
	    @Override
	    public String getUsername() {
	        return emailAddress ;
	    }
	 
	    @Override
	    public String getPassword() {
	        return password;
	    }
	 
	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return authorities;
	    }
	 
	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }
	 
	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }
	 
	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }
	 
	    @Override
	    public boolean isEnabled() {
	        return true;
	    }
	 
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        
	        UserPrinciple user = (UserPrinciple) o;
	        return Objects.equals(id, user.id);
	    }
}
