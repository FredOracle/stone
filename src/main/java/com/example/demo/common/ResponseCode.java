package com.example.demo.common;

public enum ResponseCode {

  /**
   * 成功
   */
  SUCCESS(200),

  /**
   * 失败
   */
  FAIL(400);

  ResponseCode(Integer code) {
    this.code= code;
  }

  /**
   * 状态码
   */
  private Integer code;

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

}
