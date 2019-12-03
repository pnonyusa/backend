package com.mypicknpay.webApi.controller;

import java.io.IOException;


import javax.annotation.security.PermitAll;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import com.mypicknpay.webApi.jwt.response.FileStoreException;
import org.springframework.core.io.ByteArrayResource;
import com.mypicknpay.webApi.jwt.response.UploadFileResponse;
import com.mypicknpay.webApi.model.ProductImage;
import com.mypicknpay.webApi.model.login.LoginCredentials;
import com.mypicknpay.webApi.model.login.Products;
import com.mypicknpay.webApi.model.login.SignUpUser;
import com.mypicknpay.webApi.service.AppUserService;
import com.mypicknpay.webApi.service.ImageService;
import com.mypicknpay.webApi.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;


@ComponentScan(basePackages= {"com.mypicknpay.webApi.service","com.mypicknpay.webApi.security.config"})
@Controller
@CrossOrigin(origins = "http://localhost:8082")
@RequestMapping("/picknpay")
public class AppUserController {
   
	private static final Logger logger = LoggerFactory.getLogger(AppUserController.class);
	
	@Autowired
	private AppUserService appUserService;
	
	
	@Autowired
	private ImageService imageSave;
	
	
	@Autowired
	private ProductService productService;
	
	/*save Customer or admin 
	 * 
	 */
	
	@PermitAll
	@PostMapping("/register")
	public ResponseEntity<?> addAppUser(@Valid @RequestBody SignUpUser user) {
		return appUserService.addAppUser(user);
	}
	
		
	/*
	 * enables the user to login
	 * */
	@PermitAll
	@PostMapping("/login")
	public ResponseEntity<?> isLoggedIn(@Valid @RequestBody LoginCredentials user) {
		return appUserService.isLoggedIn(user);
	}
	

	
	
	/*
	 * enables the admin to add product
	 * */
	 @PreAuthorize("hasRole('ROLE_ADMIN')")
	 @PostMapping("/admin/product")
	 public ResponseEntity<?> addProduct(Products product) throws JsonParseException, JsonMappingException, IOException { 
		 return productService.addProduct(product);	
	}
	
	
	 
	 
	 
		/*
		 * enables the admin to upload product image
		 * */
	 @PreAuthorize("hasRole('ROLE_ADMIN')")
	 @PostMapping("/uploadImage")
	 public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) throws FileStoreException{
		
		       ProductImage image=imageSave.storeImage(file);
		      
		      String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
		                .path("/downloadFile/")
		                .path(image.getId().toString())
		                .toUriString();
		      
		 return new UploadFileResponse(image.getFileName(),fileDownloadUri,file.getContentType(),file.getSize()); 
	 }
	 
	 
	 
	 
	 /*
		 * enables the admin to get product image from database
		 * */
	 @PreAuthorize("hasRole('ROLE_ADMIN')")
	 //@PermitAll
	 @GetMapping("/downloadFile/{id}")
	 public ResponseEntity<ByteArrayResource> downloadImage(@PathVariable Long id){
		    
		     ProductImage image=imageSave.getImage(id);
		    
		    
		 return ResponseEntity.ok()
				 .contentType(MediaType.parseMediaType(image.getFileType()))
				 .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getFileName() + "\"")
				 .body(new ByteArrayResource(image.getImgSize())); 
	 }
	 
	 
	 
	 
	 
		
}
