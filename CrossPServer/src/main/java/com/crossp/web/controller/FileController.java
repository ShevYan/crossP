package com.crossp.web.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

	@RequestMapping("/download/{name}")
	public HttpEntity<byte[]> download(@PathVariable("name") String name) throws Exception {
		HttpHeaders httpHeaders = new HttpHeaders();
		Path path = Paths.get("download/test.txt");
		byte[] data = Files.readAllBytes(path);
		return new ResponseEntity<byte[]>(data, httpHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/upload", method=RequestMethod.POST)
	public void upload(@RequestParam(value="file", required=true) MultipartFile file) throws Exception {
		
	}
	
	
//	 @RequestMapping(value = "/upload", method = RequestMethod.POST)
//	    public @ResponseBody DocumentMetadata handleFileUpload(
//	            @RequestParam(value="file", required=true) MultipartFile file ,
//	            @RequestParam(value="person", required=true) String person,
//	            @RequestParam(value="date", required=true) @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
//	        
//	        try {
//	            Document document = new Document(file.getBytes(), file.getOriginalFilename(), date, person );
//	            getArchiveService().save(document);
//	            return document.getMetadata();
//	        } catch (RuntimeException e) {
//	            LOG.error("Error while uploading.", e);
//	            throw e;
//	        } catch (Exception e) {
//	            LOG.error("Error while uploading.", e);
//	            throw new RuntimeException(e);
//	        }      
//	    }
}
