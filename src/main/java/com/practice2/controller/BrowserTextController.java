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

  @PostMapping(path = "/{id}",
      params = "delete")
  public @ResponseBody
  ModelAndView deleteBrowserTextById(Model model, @PathVariable Long id) {
    BrowserTextModel browserTextModel = browserTextRepository.findById(id).get();
    browserTextRepository.delete(browserTextModel);
    model.addAttribute("browserTextModel", new BrowserTextModel());
    model.addAttribute("memoList", browserTextRepository.findAll());
    ModelAndView mv = new ModelAndView("index");
    return mv;
  }

  @DeleteMapping("/all")
  public @ResponseBody
  String deleteBrowserTextAll() {
    browserTextService.deleteAll();
    return "memo-frontend";
  }

  @PostMapping(path = "/{id}",
      params = "update")
  public @ResponseBody
  ModelAndView saveBrowserText(Model model, @PathVariable Long id) {
    BrowserTextModel browserTextModel = browserTextRepository.findById(id).get();
//    browserTextModel.setId(id);
    browserTextRepository.save(browserTextModel);
    model.addAttribute("browserTextModel", browserTextModel);
    model.addAttribute("memoList", browserTextRepository.findAll());
    ModelAndView mv = new ModelAndView("index");
    return mv;
  }

  @GetMapping("/all")
  public String findAllBrowserText(ModelMap model) {
    List<BrowserTextModel> allList = browserTextService.findAll();
    model.addAttribute("browserTextList", allList);
    return "memo-frontend";
  }

  @GetMapping("/{id}")
  public @ResponseBody
  ModelAndView findBrowserTextById(@PathVariable Long id,
      Model model) {
    System.out.println("id=" + id);
    BrowserTextModel browserTextModel =
        browserTextRepository.findById(id).get();
    model.addAttribute("browserTextModel", browserTextModel);
    model.addAttribute("memoList", browserTextRepository.findAll());
    ModelAndView mv = new ModelAndView("index");
    return mv;
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
