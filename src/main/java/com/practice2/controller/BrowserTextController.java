package com.practice2.controller;

import com.practice2.controller.form.MemoForm;
import com.practice2.model.BrowserTextModel;
import com.practice2.repository.BrowserTextRepository;
import com.practice2.service.BrowserTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/memos")
public class BrowserTextController {

  @Autowired
  BrowserTextRepository browserTextRepository;

  @Autowired
  BrowserTextService browserTextService;

  boolean archived;
  String labelFilter;

  @ModelAttribute("labelFilter")
  String labelFilter(
      @RequestParam(required = false,
          defaultValue = "") String labelFilter) {
    return this.labelFilter = labelFilter;
  }

  @ModelAttribute("archived")
  boolean showArchived(@RequestParam(required = false) Boolean archived) {
    return this.archived = archived != null ? archived : false;
  }

  @GetMapping
  public String welcomePage(Model model) {
    model.addAttribute("browserTextModel", new BrowserTextModel());
    model.addAttribute("memoList",
        browserTextRepository.findAllByArchived(archived));
    return "index";

  }

  @PostMapping(path = "/{id}",
      params = "delete")
  public @ResponseBody
  ModelAndView deleteBrowserTextById(Model model, @PathVariable Long id) {
    BrowserTextModel browserTextModel =
        browserTextRepository.findById(id).get();
    browserTextRepository.delete(browserTextModel);
    model.addAttribute("browserTextModel", new BrowserTextModel());
    model.addAttribute("memoList",
        browserTextRepository.findAllByArchived(archived));
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
  ModelAndView saveBrowserText(Model model, @PathVariable Long id,
      @ModelAttribute
          MemoForm memoForm) {
    BrowserTextModel browserTextModel =
        browserTextRepository.findById(id).get();
    browserTextModel = new BrowserTextModel(memoForm);
    browserTextModel.setId(id);
    browserTextModel = browserTextRepository.save(browserTextModel);
    model.addAttribute("browserTextModel", new BrowserTextModel());
    model.addAttribute("memoList",
        browserTextRepository.findAllByArchived(archived));
    ModelAndView mv = new ModelAndView("index");
    return mv;
  }

  @GetMapping("/{id}")
  public @ResponseBody
  ModelAndView findBrowserTextById(@PathVariable Long id,
      Model model) {
    System.out.println("id=" + id);
    BrowserTextModel browserTextModel =
        browserTextRepository.findById(id).get();
    model.addAttribute("browserTextModel", browserTextModel);
    model.addAttribute("memoList",
        browserTextRepository.findAllByArchived(archived));
    ModelAndView mv = new ModelAndView("index");
    return mv;
  }

  @GetMapping("/search")
  public ModelAndView searchByLabels(Model model) {
    model.addAttribute("browserTextModel", new BrowserTextModel());
    model.addAttribute("memoList",
        browserTextService
            .findAllByByArchivedAndLabelFilter(archived, labelFilter));
    ModelAndView mv = new ModelAndView("index");
    return mv;
  }

  @PostMapping
  public @ResponseBody
  ModelAndView createBrowserText(
      @ModelAttribute BrowserTextModel browserTextModel) {
    browserTextRepository.save(browserTextModel);
    ModelAndView mv = new ModelAndView("redirect:/memos");
    return mv;
  }

}
