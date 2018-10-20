package com.example.demo.dao;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.ImageMessageEntity;


@Repository
public class ImageMessageDaoImpl implements ImageMessageDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<ImageMessageEntity> getRandomImage() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from ImageMessageEntity");
		@SuppressWarnings("unchecked")
		List<ImageMessageEntity> list = query.getResultList();
		Collections.shuffle(list);
		return list;
	}

	@Override
	public String insertMessageAndImage(MultipartFile file) {
		Session session = sessionFactory.getCurrentSession();
		  
	        byte[] bFile = new byte[(int) file.getName().length()];
	 
	        try {
	            FileInputStream fileInputStream = new FileInputStream(file.getOriginalFilename());
	            fileInputStream.read(bFile);
	            fileInputStream.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	       ImageMessageEntity image = new ImageMessageEntity();
	       image.setImage(bFile);
	       image.setMessage("I am watch");
	       session.save(image);
		return "saved";

	}

}
