package com.practice2.service;

import com.practice2.model.BrowserTextModel;
import com.practice2.repository.BrowserTextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
  public List<BrowserTextModel> findBrowserTextById(Long id) {
    return browserTextRepository.findBrowserTextById(id);
  }

  @Override
  @Transactional
  public void deleteBrowserTextById(Long id) {
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

}
