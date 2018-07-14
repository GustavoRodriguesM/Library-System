package com.api.library.services.impl;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.api.library.services.UploadFileService;

@Service
public class UploadServiceImpl implements UploadFileService {

	@Autowired
	private ServletContext context;

	@Value("${application.path}")
	private String appPath;
	
	@Override
	public URI upload(MultipartFile file) {
		try {
			byte[] bytes = file.getBytes();
			String absolutePath = context.getRealPath("public");
			Path path = Paths.get(absolutePath + "/" + file.getOriginalFilename());
			Files.write(path, bytes);
			URI uri = new URI(appPath + "public/" + file.getOriginalFilename());
			return uri;
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}

		return null;

	}

}
