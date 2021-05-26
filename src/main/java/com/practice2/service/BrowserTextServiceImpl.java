package com.practice2.service;

import com.practice2.model.BrowserTextModel;
import com.practice2.repository.BrowserTextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
public class BrowserTextServiceImpl implements BrowserTextService {

  @Autowired
  private BrowserTextRepository browserTextRepository;

  @Override
  @Transactional
  public BrowserTextModel saveBrowserText(BrowserTextModel browserTextModel) {
    return browserTextRepository.save(browserTextModel);
  }

  @Override
  @Transactional
  public List<BrowserTextModel> findBrowserTextById(String id) {
    return browserTextRepository.findBrowserTextById(id);
  }

  @Override
  @Transactional
  public void deleteBrowserTextById(String id) {
    browserTextRepository.deleteById(id);
  }

  @Override
  @Transactional
  public void deleteAll() {
    browserTextRepository.deleteAll();
  }

  @Override
  @Transactional
  public List<BrowserTextModel> findAll() {
    return browserTextRepository.findAll();
  }

  @Override
  @Transactional
  public void createBrowserText(String title, String text, Set<String> labels) {
    BrowserTextModel btm = new BrowserTextModel();
    LocalDateTime currentTime = LocalDateTime.now();
    btm.setTitle(title);
    btm.setTimestamp(currentTime);
    btm.setText(text);
    btm.setArchived(false);
    btm.setLabels(labels);
    browserTextRepository.save(btm);
  }

}
