package com.example.demo.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class GlobalResponse<T> {

  @Builder.Default
  private Boolean success = false;

  private T payload;

  private ResponseCode errorCode;

  private String errorMsg;

  private NoticeLevel level;


  /**
   * 成功.
   *
   * @param data 数据
   * @return {@link GlobalResponse}
   */
  public static <T> GlobalResponse success(T data) {
    GlobalResponse response = new GlobalResponse();
    response.setSuccess(true);
    response.setPayload(data);
    response.setLevel(NoticeLevel.INFO);
    return response;
  }

  /**
   * 成功.
   *
   * @return {@link GlobalResponse}
   */
  public static GlobalResponse success() {
    GlobalResponse response = new GlobalResponse();
    response.setSuccess(true);
    response.setLevel(NoticeLevel.INFO);
    return response;
  }

  /**
   * 失败.
   *
   * @param errorMsg  错误消息
   * @param errorCode 错误代码
   * @return {@link GlobalResponse}
   */
  public static <T> GlobalResponse fail(String errorMsg, ResponseCode errorCode) {
    GlobalResponse response = new GlobalResponse();
    response.setSuccess(false);
    response.setErrorCode(errorCode);
    response.setErrorMsg(errorMsg);
    response.setLevel(NoticeLevel.ERROR);
    log.error(response.toString());
    return response;
  }

  /**
   * 失败.
   *
   * @param exception
   * @param <T>
   * @return
   */
  public static <T> GlobalResponse fail(GlobalException exception) {
    GlobalResponse response = new GlobalResponse();
    response.setSuccess(false);
    response.setErrorCode(ResponseCode.FAIL);
    response.setErrorMsg(exception.getMessage());
    response.setLevel(exception.getNoticeLevel());
    return response;
  }

  /**
   * 失败.
   *
   * @param exception
   * @param errorCode
   * @param <T>
   * @return
   */
  public static <T> GlobalResponse fail(GlobalException exception, ResponseCode errorCode) {
    GlobalResponse response = new GlobalResponse();
    response.setSuccess(false);
    response.setErrorCode(errorCode);
    response.setErrorMsg(exception.getMessage());
    response.setLevel(exception.getNoticeLevel());
    log.error(response.toString());
    return response;
  }

  @Override
  public String toString() {
    return "GlobalResponse{" +
        "success=" + success +
        ", payload=" + payload +
        ", errorCode=" + errorCode +
        ", errorMsg='" + errorMsg + '\'' +
        ", level=" + level +
        '}';
  }


}
