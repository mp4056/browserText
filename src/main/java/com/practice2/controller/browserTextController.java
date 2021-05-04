package com.browserText.controller;
import java.util.List;

import javax.management.AttributeValueExp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.engine.AttributeName;

import com.browserText.model.BrowserTextModel;
import com.browserText.service.browserTextService;

@Controller
@RequestMapping("/")
public class browserTextController {

	@Autowired
	browserTextService service;
	
	@RequestMapping("/")
	public String welcomePage() {
		return "Frontend";
	}

	@DeleteMapping(value="/{id}")
	public @ResponseBody String deleteBrowserTextById(@PathVariable String id) {
		service.deleteBrowserTextById(id);
		return "Frontend";	
	}
	
	@DeleteMapping(value="/*")
	public @ResponseBody String deleteBrowserTextAll() {
		service.deleteAll();
		return "Frontend";
	}
	
	@PutMapping(value="/*")
	public @ResponseBody String saveBrowserText(BrowserTextModel browserTextModel) {
		service.saveBrowserText(browserTextModel);
		return "Frontend";
	}
	
	@GetMapping(value="/*")
	public String findAllBrowserText(ModelMap model){
		List<BrowserTextModel>allList=service.findAll();
		model.addAttribute("browserTextList", allList);
		return "Frontend";		 
	}
	
	@GetMapping(value="/{id}")
	public @ResponseBody String findBrowserTextById(@PathVariable String id,Model model) {
		Iterable<BrowserTextModel>allList=service.findBrowserTextById(id);
		model.addAttribute("designatedText", allList);
		return "Frontend";
	}
	
	@PostMapping(value="/")
	public @ResponseBody String createBrowserText(
			@RequestParam("title")String title,
			@RequestParam("text") String text,
			@RequestParam("label")String label) {
		
		service.createBrowserText(title,text,label);
		return "Frontend";
	}

}
