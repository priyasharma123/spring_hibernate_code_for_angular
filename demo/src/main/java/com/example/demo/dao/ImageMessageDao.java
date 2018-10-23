package com.example.demo.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.ImageMessageEntity;

public interface ImageMessageDao {

	public List<ImageMessageEntity> getRandomImage();
	public String insertMessageAndImage(MultipartFile file,String message) throws IOException;
}
