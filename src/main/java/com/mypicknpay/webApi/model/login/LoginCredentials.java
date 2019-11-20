package com.mypicknpay.webApi.model.login;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginCredentials {
	    @NotBlank
	    private String emailAddress;
	 
	    @NotBlank
	    @Size(min = 4, max = 40)
	    private String password;
	 
	    public String getEmailAddress() {
	        return emailAddress;
	    }
	 
	    public void setgetEmailAddress(String emailAddress) {
	        this.emailAddress = emailAddress;
	    }
	 
	    public String getPassword() {
	        return password;
	    }
	 
	    public void setPassword(String password) {
	        this.password = password;
	    }
	    
	    
	    
}
