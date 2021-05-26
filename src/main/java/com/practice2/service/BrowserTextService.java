package com.practice2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practice2.model.BrowserTextModel;

@Service
public interface BrowserTextService {

  BrowserTextModel saveBrowserText(BrowserTextModel browserTextModel);

  void deleteBrowserTextById(String id);

  void deleteAll();

  List<BrowserTextModel> findBrowserTextById(String id);

  List<BrowserTextModel> findAll();

  void createBrowserText(String title, String text, String label);
}