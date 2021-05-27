package com.practice2.model;

import com.practice2.controller.form.MemoForm;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Entity
@Table(name = "browserText")
public class BrowserTextModel {

  public BrowserTextModel(){}

  public BrowserTextModel(MemoForm memoForm){
    title = memoForm.getTitle();
    text = memoForm.getText();
    if (memoForm.getLabels() != null) {
      for (String label : memoForm.getLabels().split(",")) {
        labels.add(label.trim());
      }
    }
    archived = memoForm.isArchived();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "title")
  private String title;
  @Column(name = "text")
  private String text;

  @Column(name = "timeStamp")
//  @CreatedDate
  private LocalDateTime timestamp = LocalDateTime.now();
  @Column(name = "archived") // 封存不在網頁上顯示
  private boolean archived = false;

  @ElementCollection
  @Column(name = "labels")
  private Set<String> labels = new TreeSet<>();
}
