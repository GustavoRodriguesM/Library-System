package com.api.library.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

	@PostMapping(value="/upload/cover", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> upload(@RequestAttribute("file") MultipartFile file) {
		URI upload = this.uploadFileService.upload(file);
		String body = "{\"cover\" : \"" + upload.getPath() + "\"}";
		return ResponseEntity.created(upload).body(body);
	}

}
