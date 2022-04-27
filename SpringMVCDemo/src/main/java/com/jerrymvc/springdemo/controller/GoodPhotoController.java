package com.jerrymvc.springdemo.controller;

import java.io.IOException;
import java.util.List;

import org.apache.catalina.filters.HttpHeaderSecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jerrymvc.springdemo.model.GoodPhoto;
import com.jerrymvc.springdemo.service.GoodPhotoService;

@Controller
public class GoodPhotoController {
	
	@Autowired
	private GoodPhotoService goodPhotoService;

	@GetMapping("/newPhoto")
	public String newPhotoPage() {
		return "goodphoto/uploadPage";
	}

	@PostMapping("/fileUpload")
	public String postNewPhoto(@RequestParam(name = "photoName") String name,
			@RequestParam("file") MultipartFile file) {
		GoodPhoto goodPhoto = new GoodPhoto();

		try {
			goodPhoto.setPhotoName(name);
			byte[] bytes = file.getBytes();
			for (byte b : bytes) {
				System.out.println(b);
			}
			goodPhoto.setPhotoFile(bytes);
			
			
			goodPhotoService.insertGoodPhoto(goodPhoto);
			
			return "goodphoto/uploadSuccesssPage";
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "index";
		}
		

	

	}
	
	@GetMapping("/listGoodPhoto")
	public String listAllGoodPhotoPage(Model model) {
		List<GoodPhoto> list = goodPhotoService.listGoodPhoto();
		model.addAttribute("goodPhotoList",list);
		return "goodphoto/listPhoto";
		
	}
	
	@GetMapping("/downloadImage/{id}")
	@ResponseBody
	public ResponseEntity<byte[]> downloadImage(@PathVariable("id") Integer id){
		GoodPhoto photo1 = goodPhotoService.getPhotoById(id);
		byte[] photoFile = photo1.getPhotoFile();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		                                  //要回傳的物件，header,httpStatus回應
		return new ResponseEntity<byte[]>(photoFile,headers,HttpStatus.OK);
		
		
	}
}
