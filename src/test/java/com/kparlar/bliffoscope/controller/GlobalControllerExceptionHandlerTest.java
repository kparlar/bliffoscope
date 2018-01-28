package com.kparlar.bliffoscope.controller;

import com.kparlar.bliffoscope.exception.ExceptionMessage;
import com.kparlar.bliffoscope.util.BliffoscopeTestConstantsUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import static org.junit.Assert.assertEquals;
public class GlobalControllerExceptionHandlerTest {
    @InjectMocks
    private GlobalControllerExceptionHandler globalControllerExceptionHandler;

    @Before
    public void setUpMock() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void handleExceptionGivenExceptionThenErrorStatus() {
        ResponseEntity<ExceptionMessage> response =
                globalControllerExceptionHandler.handleException(new Exception(
                        BliffoscopeTestConstantsUtil.EXCEPTION_TEXT));
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }


    @Test
    public void handleRestClientExceptionGivenExceptionThenErrorStatus() {
        ResponseEntity<ExceptionMessage> response =
                globalControllerExceptionHandler.handleRestClientException(new RestClientException(
                        BliffoscopeTestConstantsUtil.EXCEPTION_TEXT));
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }



}
