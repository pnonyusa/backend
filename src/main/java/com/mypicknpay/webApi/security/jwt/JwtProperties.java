package com.mypicknpay.webApi.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;


@Component
@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtProperties {
	
	    private  String SECRET = "SecretKeyToGenJWTs";
	    private  long EXPIRATION_TIME = 864_000_000; // 10 days
	    private    String TOKEN_PREFIX = "Bearer ";
	    private  String HEADER_STRING = "Authorization";
	    
	    
	    public String getSECRET() {
			return SECRET;
		}
		
		public long getEXPIRATION_TIME() {
			return EXPIRATION_TIME;
		}
		
		public String getTOKEN_PREFIX() {
			return TOKEN_PREFIX;
		}
		
		public String getHEADER_STRING() {
			return HEADER_STRING;
		}
		
		
	    
		
}
