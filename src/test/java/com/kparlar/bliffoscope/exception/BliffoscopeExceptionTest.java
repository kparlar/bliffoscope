package com.kparlar.bliffoscope.exception;

import com.kparlar.bliffoscope.util.BliffoscopeTestConstantsUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

public class BliffoscopeExceptionTest {


  private BliffoscopeException bliffoscopeException;
  private String expectedString;

  @Before
  public void setUp() throws BliffoscopeException {
    expectedString = String.format("BliffoscopeException{status=%s, errorMessage='%s', errorCode='%s'}", HttpStatus.BAD_REQUEST, BliffoscopeTestConstantsUtil.EXCEPTION, BliffoscopeTestConstantsUtil.EXCEPTION_FAILED_MESSAGE_ERROR_CODE);
    bliffoscopeException = new BliffoscopeException(BliffoscopeTestConstantsUtil.EXCEPTION, BliffoscopeTestConstantsUtil.EXCEPTION_FAILED_MESSAGE_ERROR_CODE, HttpStatus.BAD_REQUEST);
  }
  @Test
  public void toStringGivenWhenInitializedExceptionWithPriorInfoThenGetGivenExceptionMessage(){
    Assert.assertEquals(expectedString, bliffoscopeException.toString());
  }
}
