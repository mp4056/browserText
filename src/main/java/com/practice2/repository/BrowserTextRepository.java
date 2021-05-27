package com.practice2.repository;

import com.practice2.model.BrowserTextModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrowserTextRepository
    extends JpaRepository<BrowserTextModel, Long> {

  List<BrowserTextModel> findBrowserTextById(Long id);

  List<BrowserTextModel> findBrowserTextByTitle(String title);

  List<BrowserTextModel> findAll();

  List<BrowserTextModel> deleteBrowserTextById(Long id);

  void deleteAll();

  List<BrowserTextModel> findAllByArchived(boolean archived);

}
