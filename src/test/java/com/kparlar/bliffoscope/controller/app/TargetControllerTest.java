package com.kparlar.bliffoscope.controller.app;

import com.kparlar.bliffoscope.exception.BliffoscopeException;
import com.kparlar.bliffoscope.model.dto.BliffoscopeDto;
import com.kparlar.bliffoscope.service.TargetService;
import com.kparlar.bliffoscope.util.BliffoscopeConstantsUtil;
import com.kparlar.bliffoscope.util.BliffoscopeTestConstantsUtil;
import com.kparlar.bliffoscope.util.MessageCodeConstants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

public class TargetControllerTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    private TargetService targetService;

    @InjectMocks
    private TargetController targetController;

    @Before
    public void setupMock(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAllGivenNotValidTargetTypeWhenProcessingImageThenHttpStatusNotFound() throws BliffoscopeException {
        this.thrown.expect(BliffoscopeException.class);
        when(targetService.compare(eq(BliffoscopeTestConstantsUtil.TARGET_TYPE_NOT_VALID), any(MultipartFile.class), any(MultipartFile.class), any(Double.class))).thenThrow(BliffoscopeException.class);
        targetController.findAll(BliffoscopeTestConstantsUtil.TARGET_TYPE_NOT_VALID, null, null, new Double(0));
    }
    @Test
    public void findAllGivenValidDataWhenProcessingImageThenBliffoscopeDto() throws BliffoscopeException {
        BliffoscopeDto expectedResponse = new BliffoscopeDto();
        when(targetService.compare(eq(BliffoscopeConstantsUtil.STAR_SHIP), any(MultipartFile.class), any(MultipartFile.class), any(Double.class))).thenReturn(expectedResponse);
        ResponseEntity<BliffoscopeDto> responseEntity = targetController.findAll(BliffoscopeConstantsUtil.STAR_SHIP, null, null, new Double(0));
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(responseEntity.getBody(), expectedResponse);

    }



}
