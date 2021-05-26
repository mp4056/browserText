package com.practice2.controller;

import com.practice2.model.BrowserTextModel;
import com.practice2.repository.BrowserTextRepository;
import com.practice2.service.BrowserTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/memos")
public class BrowserTextController {

  @Autowired
  BrowserTextRepository browserTextRepository;

  @Autowired
  BrowserTextService browserTextService;

  //  @GetMapping
  //  public String welcomePage(ModelMap model) {
  //    List<BrowserTextModel> allList = service.findAll();
  //    model.addAttribute("browserTextList", allList);
  //    return "index";
  //  }

  @GetMapping
  public String welcomePage(Model model) {
    model.addAttribute("browserTextModel", new BrowserTextModel());
    model.addAttribute("memoList", browserTextRepository.findAll());
    return "index";

  }

  @PostMapping("/{id}")
  public @ResponseBody
  String deleteBrowserTextById(@PathVariable String id) {
    browserTextService.deleteBrowserTextById(id);
    return "memo-frontend";
  }

  @DeleteMapping("/all")
  public @ResponseBody
  String deleteBrowserTextAll() {
    browserTextService.deleteAll();
    return "memo-frontend";
  }

  @PutMapping
  public @ResponseBody
  String saveBrowserText(
      BrowserTextModel browserTextModel) {
    browserTextService.saveBrowserText(browserTextModel);
    return "memo-frontend";
  }

  @GetMapping("/all")
  public String findAllBrowserText(ModelMap model) {
    List<BrowserTextModel> allList = browserTextService.findAll();
    model.addAttribute("browserTextList", allList);
    return "memo-frontend";
  }

  @GetMapping("/{id}")
  public @ResponseBody
  String findBrowserTextById(@PathVariable String id,
      Model model) {
    System.out.println("id=" + id);
    List<BrowserTextModel> allList = browserTextService.findBrowserTextById(id);
    model.addAttribute("designatedText", allList);
    return "memo-frontend";
  }

  //  @PostMapping
  //  public @ResponseBody
  //  String createBrowserText(
  //      @RequestParam("title") String title, @RequestParam("text") String text,
  //      @RequestParam("labels") Set<String> labels) {
  //
  //    browserTextService.createBrowserText(title, text, labels);
  //    return "memo-frontend";
  //  }

  @PostMapping
  public @ResponseBody
  ModelAndView createBrowserText(
      @ModelAttribute BrowserTextModel browserTextModel) {
    browserTextRepository.save(browserTextModel);
    ModelAndView mv = new ModelAndView("redirect:/memos");
    return mv;
  }

}
