package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.ImageMessageEntity;
import com.example.demo.service.ImageMessageService;

@RestController
@RequestMapping("/") 	
@CrossOrigin("*")
public class ImageMessageController {
	
	@Autowired
	ImageMessageService imageMessageService;
	
	@GetMapping("/getimages")
	public List<ImageMessageEntity> getImages() {
		return this.imageMessageService.getRandomData();
	}
	
	@GetMapping("/storeImage")
	public String storeImage(@RequestParam("file") MultipartFile file) {
		return this.imageMessageService.insertMessageAndImage(file);
	}
	
}
