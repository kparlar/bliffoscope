package com.kparlar.bliffoscope.service;

import com.kparlar.bliffoscope.exception.BliffoscopeException;
import com.kparlar.bliffoscope.model.TargetItem;
import com.kparlar.bliffoscope.model.TestItem;
import com.kparlar.bliffoscope.model.dto.BliffoscopeDto;
import com.kparlar.bliffoscope.util.BliffoscopeConstantsUtil;
import com.kparlar.bliffoscope.util.BliffoscopeTestConstantsUtil;
import com.kparlar.bliffoscope.util.BliffoscopeUtil;
import com.kparlar.bliffoscope.util.MessageCodeConstants;
import com.kparlar.bliffoscope.util.providers.BliffoscopeDtoProvider;
import com.kparlar.bliffoscope.util.providers.MatchCoordinateDtoProvider;
import com.kparlar.bliffoscope.util.providers.MultipartFileProviders;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.mockito.Matchers.*;

public class TargetServiceTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Spy
    @InjectMocks
    private TargetService targetService;

    @Mock
    private BliffoscopeUtil bliffoscopeUtil;

    private MultipartFileProviders multipartFileProviders;
    private MatchCoordinateDtoProvider matchCoordinateDtoProvider;
    private BliffoscopeDtoProvider bliffoscopeDtoProvider;

    @Before
    public void setupMock(){
        MockitoAnnotations.initMocks(this);
        multipartFileProviders = new MultipartFileProviders();
        matchCoordinateDtoProvider = new MatchCoordinateDtoProvider();
        bliffoscopeDtoProvider = new BliffoscopeDtoProvider();
    }


    @Test
    public void compareGivenNotValidTargetTypeWhenComparingThenThrowBliffoscopeException() throws BliffoscopeException{
        this.thrown.expect(BliffoscopeException.class);
        this.thrown.expectMessage(MessageCodeConstants.REST_CLIENT_EXCEPTION_MESSAGE);
        targetService.compare(BliffoscopeTestConstantsUtil.TARGET_TYPE_NOT_VALID, null, null, 0);
    }







    @Test
    public void compareGivenSpaceShipTargetWhenNotValidFileThenBliffoscopeDto() throws BliffoscopeException, IOException {
         BliffoscopeDto expectedResult = bliffoscopeDtoProvider.getBliffoscopeDto();


        MultipartFile multipartFileStarShip = multipartFileProviders.getStarShipMultipart();
        MultipartFile multipartFileTestData = multipartFileProviders.getTestDataMultipart();

        Mockito.when(bliffoscopeUtil.generateSimilarity(eq(BliffoscopeConstantsUtil.STAR_SHIP), any(), any(), eq(BliffoscopeTestConstantsUtil.CONFIDENCE_PERCENTAGE_0_7))).thenReturn(expectedResult.getMatchCoordinateDtos());

        BliffoscopeDto result = targetService.compare(BliffoscopeConstantsUtil.STAR_SHIP, multipartFileStarShip, multipartFileTestData, BliffoscopeTestConstantsUtil.CONFIDENCE_PERCENTAGE_0_7);

        Assert.assertTrue(result.getMatchCoordinateDtos().get(0).equals(expectedResult.getMatchCoordinateDtos().get(0)));


    }

    @Test
    public void compareGivenSlimeTorpedoTargetWhenNotValidFileThenBliffoscopeDto() throws BliffoscopeException, IOException {
        BliffoscopeDto expectedResult = bliffoscopeDtoProvider.getBliffoscopeDto();


        MultipartFile multipartFileStarShip = multipartFileProviders.getStarShipMultipart();
        MultipartFile multipartFileTestData = multipartFileProviders.getTestDataMultipart();

        Mockito.when(bliffoscopeUtil.generateSimilarity(eq(BliffoscopeConstantsUtil.SLIME_TORPEDO), any(), any(), eq(BliffoscopeTestConstantsUtil.CONFIDENCE_PERCENTAGE_0_7))).thenReturn(expectedResult.getMatchCoordinateDtos());

        BliffoscopeDto result = targetService.compare(BliffoscopeConstantsUtil.SLIME_TORPEDO, multipartFileStarShip, multipartFileTestData, BliffoscopeTestConstantsUtil.CONFIDENCE_PERCENTAGE_0_7);

        Assert.assertTrue(result.getMatchCoordinateDtos().get(0).equals(expectedResult.getMatchCoordinateDtos().get(0)));


    }

}

