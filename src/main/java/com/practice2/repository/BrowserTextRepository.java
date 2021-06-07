package com.practice2.repository;

import com.practice2.model.BrowserTextModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrowserTextRepository
    extends JpaRepository<BrowserTextModel, Long>,
    QuerydslPredicateExecutor<BrowserTextModel> {
  List<BrowserTextModel> findBrowserTextById(Long id);

  List<BrowserTextModel> findAll();

  void deleteAll();

  List<BrowserTextModel> findAllByArchived(boolean archived);

}
