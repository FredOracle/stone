package com.example.demo.common;

import java.text.MessageFormat;

public abstract class GlobalException extends RuntimeException {

  private ErrorCode exceptionCode;

  private String exceptionMessage;

  private NoticeLevel noticeLevel;

  public GlobalException(ErrorCode code) {
    super(code.getCodeMessage());
    this.exceptionCode = code;
    this.exceptionMessage = code.getCodeMessage();
    this.noticeLevel = NoticeLevel.ERROR;
  }

  public GlobalException(String message) {
    super(message);
    this.exceptionMessage = message;
    this.noticeLevel = NoticeLevel.ERROR;
  }

  public GlobalException(ErrorCode code, String message) {
    super(MessageFormat.format(code.getCodeMessage(), message));
    this.exceptionCode = code;
    this.exceptionMessage = message;
  }

  public GlobalException(ErrorCode code, NoticeLevel noticeLevel) {
    super(code.getCodeMessage());
    this.exceptionCode = code;
    this.exceptionMessage = code.getCodeMessage();
    this.noticeLevel = noticeLevel;
  }

  public GlobalException(String message, NoticeLevel noticeLevel) {
    super(message);
    this.exceptionMessage = message;
    this.noticeLevel = noticeLevel;
  }

  public GlobalException(ErrorCode code, String message, NoticeLevel noticeLevel) {
    super(message);
    this.exceptionCode = code;
    this.exceptionMessage = message;
    this.noticeLevel = noticeLevel;
  }

  public String getExceptionMessage() {
    return exceptionMessage;
  }

  public void setExceptionMessage(String exceptionMessage) {
    this.exceptionMessage = exceptionMessage;
  }

  public NoticeLevel getNoticeLevel() {
    return noticeLevel;
  }

  public void setNoticeLevel(NoticeLevel noticeLevel) {
    this.noticeLevel = noticeLevel;
  }

  public void setExceptionCode(ErrorCode excetionCode) {
    this.exceptionCode = excetionCode;
  }

  public ErrorCode getExceptionCode() {
    return this.exceptionCode;
  }

}
