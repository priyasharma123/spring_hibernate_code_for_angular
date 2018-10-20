package com.example.demo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.ImageMessageEntity;

public interface ImageMessageService {

	public List<ImageMessageEntity> getRandomData();
	public String insertMessageAndImage(MultipartFile file);

}
