package com.practice2.service;

import com.practice2.model.BrowserTextModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface BrowserTextService {

  BrowserTextModel saveBrowserText(BrowserTextModel browserTextModel);

  void deleteBrowserTextById(Long id);

  void deleteAll();

  List<BrowserTextModel> findBrowserTextById(Long id);

  List<BrowserTextModel> findAll();

  void createBrowserText(String title, String text, Set<String> labels);
}