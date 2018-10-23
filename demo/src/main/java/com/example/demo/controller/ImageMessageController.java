package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.ImageMessageEntity;
import com.example.demo.service.ImageMessageService;

@RestController
@RequestMapping("/")
public class ImageMessageController {

	@Autowired
	ImageMessageService imageMessageService;

	@GetMapping("/getimages")
	public List<ImageMessageEntity> getImages() {
		return this.imageMessageService.getRandomData();
	}

	@PostMapping("/storeImage")
	public String storeImage(@RequestParam("file") MultipartFile file, @RequestParam("message")String message) {
		try {
			return this.imageMessageService.insertMessageAndImage(file,message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Bad request";
		}
	}

}
