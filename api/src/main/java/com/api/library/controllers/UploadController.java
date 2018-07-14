package com.api.library.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.library.services.UploadFileService;

@RestController
public class UploadController {

	@Autowired
	private UploadFileService uploadFileService;

	@PostMapping("/upload")
	public ResponseEntity<?> upload(@RequestAttribute("file") MultipartFile file) {
		URI upload = this.uploadFileService.upload(file);
		return ResponseEntity.created(upload).build();
	}

}
