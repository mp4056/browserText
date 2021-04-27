package com.browserText.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@PostMapping(value="/delete/{id}")
	public @ResponseBody String deleteBrowserTextById(@PathVariable String id) {
		service.deleteBrowserTextById(id);
		return "Frontend";	
	}
	
	@PostMapping(value="/delete/*")
	public @ResponseBody String deleteBrowserTextAll() {
		service.deleteAll();
		return "Frontend";
	}
	
	@PostMapping(value="/save")
	public @ResponseBody String saveBrowserText(BrowserTextModel browserTextModel) {
		service.saveBrowserText(browserTextModel);
		return "Frontend";
	}
	
	@PostMapping(value="/find/*")
	public @ResponseBody String findAllBrowserText(Model model){
		List<BrowserTextModel>list=service.findAll();
		model.addAttribute("browserTextList",list);
		return "Frontend";		
	}
	
	@PostMapping(value="/find/{id}")
	public @ResponseBody String findBrowserTextById(@PathVariable String id,Model model) {
		List<BrowserTextModel>list=service.findBrowserTextById(id);
		model.addAttribute("designatedText",list);
		return "Frontend";
	}

}
