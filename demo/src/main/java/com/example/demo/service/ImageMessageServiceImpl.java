package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.ImageMessageDao;
import com.example.demo.entity.ImageMessageEntity;

@Service
@Transactional
public class ImageMessageServiceImpl implements ImageMessageService {
	
	@Autowired
	ImageMessageDao imageMessageDao;

	@Override
	public List<ImageMessageEntity> getRandomData() {
		
		return this.imageMessageDao.getRandomImage();
	}

	

	@Override
	public String insertMessageAndImage(MultipartFile file,String message) throws IOException {
		// TODO Auto-generated method stub
		return this.imageMessageDao.insertMessageAndImage(file,message);
	}

}
