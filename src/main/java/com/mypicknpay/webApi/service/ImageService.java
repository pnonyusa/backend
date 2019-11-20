package com.mypicknpay.webApi.service;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import com.mypicknpay.webApi.jwt.response.FileStoreException;
import com.mypicknpay.webApi.jwt.response.MyFileNotFoundException;
import com.mypicknpay.webApi.model.ProductImage;
import com.mypicknpay.webApi.repository.ImageRepository;



@Service
public class ImageService {
	
	@Autowired
	private ImageRepository imageRepository;
	
	
	
	public ProductImage storeImage(MultipartFile file) {
		     String fileName=StringUtils.cleanPath(file.getOriginalFilename());
		     try {
		    	 
		    	// Check if the file's name contains invalid characters
		    	  if(fileName.contains("..")) {
		                throw new FileStoreException("Sorry! Filename contains invalid path sequence " + fileName);
		            }
		    	  
		    	  ProductImage image=new ProductImage(fileName,file.getContentType(),file.getBytes());
		    	     
		    	   return imageRepository.save(image);
		     }catch(IOException ex){
		    	 throw new FileStoreException("Could not store file " + fileName + ". Please try again!", ex);	 
		     }     
	}
	
	
	
	/*
	 * retrieves an image from the database
	 * */
	public ProductImage getImage(Long id) {
		
		return imageRepository.findById(id)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + id));
			
	}
	
	
	
	
	

	
	
	

}
