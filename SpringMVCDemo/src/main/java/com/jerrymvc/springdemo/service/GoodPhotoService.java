package com.jerrymvc.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jerrymvc.springdemo.model.GoodPhoto;
import com.jerrymvc.springdemo.model.GoodPhotoDao;

@Service
@Transactional
public class GoodPhotoService {

	@Autowired
	private GoodPhotoDao goodPhotoDao;

	public GoodPhoto insertGoodPhoto(GoodPhoto gp) {
		return goodPhotoDao.saveGoodPhoto(gp);
	}

	public List<GoodPhoto> listGoodPhoto() {
		return goodPhotoDao.getAllPhoto();
	}
	
	public GoodPhoto getPhotoById(Integer id) {
		return goodPhotoDao.getPhotoById(id);
	}

}
