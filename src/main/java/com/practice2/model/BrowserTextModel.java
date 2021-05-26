package com.practice2.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

@Data
@Entity
@Table(name = "browserText")
public class BrowserTextModel {

  public BrowserTextModel(){}

  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  private String id;
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
