package com.kparlar.bliffoscope.exception;

import org.springframework.http.HttpStatus;

public class BliffoscopeException extends Exception {

  private static final long serialVersionUID = 879477242374316609L;
  private final HttpStatus status;
  private final String errorMessage;
  private final String errorCode;
  private final Exception exception;




  public BliffoscopeException(String errorMessage, String errorCode, HttpStatus status) {
    super(errorMessage);
    this.errorMessage = errorMessage;
    this.errorCode = errorCode;
    this.status = status;
    this.exception = null;
  }


  @Override
  public String toString() {
    return "BliffoscopeException{" + "status=" + status + ", errorMessage='" + errorMessage + '\''
        + ", errorCode='" + errorCode + '\'' + '}';
  }


}
