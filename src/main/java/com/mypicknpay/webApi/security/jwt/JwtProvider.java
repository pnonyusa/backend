package com.mypicknpay.webApi.security.jwt;


import java.util.Date;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.mypicknpay.webApi.security.service.UserPrinciple;

import io.jsonwebtoken.*;

@ComponentScan(basePackages= {"com.mypicknpay.webApi.security.service"})
@Component
public class JwtProvider {
  
	 private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    @Autowired 
    JwtProperties jwtProperties;
 

    public String generateJwtToken(Authentication authentication) {
    	 
        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
 
        return Jwts.builder()
                    .setSubject((userPrincipal.getUsername()))
                    .setIssuedAt(new Date())
                    .setExpiration(new Date((new Date()).getTime() + jwtProperties.getEXPIRATION_TIME()*1000))
                    .signWith(SignatureAlgorithm.HS512, jwtProperties.getSECRET())
                    .compact();
    }
    
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtProperties.getSECRET()).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature -> Message: {} ", e);
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token -> Message: {}", e);
        } catch (ExpiredJwtException e) {
            logger.error("Expired JWT token -> Message: {}", e);
        } catch (UnsupportedJwtException e) {
            logger.error("Unsupported JWT token -> Message: {}", e);
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty -> Message: {}", e);
        }
        
        return false;
    }
    
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()
                      .setSigningKey(jwtProperties.getSECRET())
                      .parseClaimsJws(token)
                      .getBody().getSubject();
    }
}
