package com.milan.snapShot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.milan.snapShot.entities.Photo;
import com.milan.snapShot.entities.Root;
import com.milan.snapShot.services.SnapShotService;

@Controller
public class SnapShotController {

	@Autowired
	SnapShotService sss;

	
	@RequestMapping("/")
	public String showInitialPage(ModelMap modelMap) {
		Root root = sss.getResult("mountain");
		List<Photo> photos = root.getPhotos().getPhoto();
		modelMap.addAttribute("photos", photos);
		modelMap.addAttribute("tag", "Mountain");
		return "index";
	}
	
	@RequestMapping("/showPhotos") 
	public String showPhotos(@RequestParam("tag") String tag, ModelMap modelMap) {
		Root root = sss.getResult(tag);
		List<Photo> photos = root.getPhotos().getPhoto(); 
		modelMap.addAttribute("photos", photos);
		modelMap.addAttribute("tag", tag);
		return "index";
	}
	
	@RequestMapping("/showSearchedPhotos") 
	public String showShearchedPhotos(@RequestParam("search") String search, ModelMap modelMap) {
		Root root = sss.getResult(search);
		List<Photo> photos = root.getPhotos().getPhoto(); 
		if(photos.size() == 0) {
			modelMap.addAttribute("message", "noImages");
		} else {
			modelMap.addAttribute("photos", photos);
		}
		modelMap.addAttribute("tag", search);
		return "index";
	}
	
	
}
