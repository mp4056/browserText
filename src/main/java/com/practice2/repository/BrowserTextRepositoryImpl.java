package com.practice2.repository;

import com.practice2.model.BrowserTextModel;
import com.practice2.model.QBrowserTextModel;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;

@Component
public class BrowserTextRepositoryImpl {

  @Autowired
  EntityManager entityManager;

  public List<BrowserTextModel> findAllByArchivedAndLabelsIn(boolean archived,
      Collection<String> labels) {

    var qBrowserTextModel = QBrowserTextModel.browserTextModel;
    var archivedEq = qBrowserTextModel.archived.eq(archived);
    var labelsAny = qBrowserTextModel.labels.any().in(labels);

    JPAQuery query = new JPAQuery(entityManager);
    query.from(qBrowserTextModel).where(archivedEq.and(labelsAny));
    return query.fetch();
  }
}
