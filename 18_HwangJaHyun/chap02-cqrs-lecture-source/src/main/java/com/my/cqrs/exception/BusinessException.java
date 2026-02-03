package com.my.cqrs.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

  private final com.my.cqrs.exception.ErrorCode errorCode;

  public BusinessException(com.my.cqrs.exception.ErrorCode errorCode) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }
}