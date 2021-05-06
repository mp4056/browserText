package com.practice2.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import lombok.Data;

@Data
@Entity
@Table(name="browserText")
public class BrowserTextModel{
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy="uuid")
	private String id;
	@Column(name="title")
	private String title;
	@Column(name="text")
	private String text;
	@Column(name="label")
	private String label;
	@Column(name="timeStamp")
	@CreatedDate
	private LocalDateTime timestamp;
	@Column(name="isArchived") //封存不在網頁上顯示
	private boolean isArchived;
	 
	
}
