package com.example.demo.common;

public enum ErrorCode {

  /**
   * 测试内容带参数
   */
  E0("测试代码{0}"),

  /**
   * 测试内容无参数
   */
  E1("测试代码。"),
  /**
   *
   */
  E10000("AAAAAAAAAAAAAAAAa"),

  /**
   *
   */
  E20000("BBBBBBBBBBB"),

  /**
   *
   */
  E30000("CCCCCCCCCCCCCCCC");

  private String codeMessage;

  ErrorCode(String codeMessage) {
    this.codeMessage = codeMessage;
  }

  public String getCodeMessage() {
    return codeMessage;
  }

  public void setCodeMessage(String codeMessage) {
    this.codeMessage = codeMessage;
  }

}
