package com.api.library.services;

import java.net.URI;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {
	
	URI upload(MultipartFile file);

}
