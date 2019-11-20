package com.mypicknpay.webApi.model.login;




import javax.validation.constraints.*;

public class SignUpUser {
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;
 
    @NotBlank
    @Size(min = 3, max = 50)
    private String c_Surname;
 
    @NotBlank
    @Size(max = 60)
    @Email
    private String emailAddress;
    
    private  String role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getC_Surname() {
        return c_Surname;
    }
 
    public void setC_Surname(String c_Surname) {
        this.c_Surname = c_Surname;
    }
 
    public String getEmailAddress() {
        return emailAddress;
    }
 
    public void setEmail(String emailAddress) {
        this.emailAddress = emailAddress;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public   String getRole() {
      return this.role;
    }
    
    public void setRole(String role) {
      this.role = role;
    }
	

}
