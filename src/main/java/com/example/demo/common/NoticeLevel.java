package com.example.demo.common;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum NoticeLevel {

  /**
   * 错误
   */
  ERROR("E", "错误"),

  /**
   * 警告
   */
  WARNING("W", "警告"),

  /**
   * 通知
   */
  NOTIFICATION("N", "通知"),

  /**
   * 信息
   */
  INFO("I", "信息");

  private String code;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  private String name;

}
