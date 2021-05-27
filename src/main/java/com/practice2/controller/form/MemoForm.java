package com.practice2.controller.form;

import lombok.Data;

@Data
public class MemoForm {

  String title;

  String text;

  String labels;

  boolean archived;
}
