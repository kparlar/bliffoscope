package com.kparlar.bliffoscope.util;

import com.kparlar.bliffoscope.exception.BliffoscopeException;
import com.kparlar.bliffoscope.model.dto.MatchCoordinateDto;
import com.kparlar.bliffoscope.util.providers.MatchCoordinateDtoProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class BliffoscopeUtilTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @InjectMocks
    private BliffoscopeUtil bliffoscopeUtil;

    private MatchCoordinateDtoProvider matchCoordinateDtoProvider;

    @Before
    public void setupMock(){
        MockitoAnnotations.initMocks(this);
        matchCoordinateDtoProvider = new MatchCoordinateDtoProvider();
    }

    @Test
    public void generateSimilarityGivenWrongDataForDataCharArrWhenDataRowLessThanSampleRowThenBliffoscopeException() throws BliffoscopeException {
        this.thrown.expect(BliffoscopeException.class);
        this.thrown.expectMessage(MessageCodeConstants.TEST_FILE_SMALLER_THAN_TARGET_FILE_EXCEPTION_MESSAGE);

        bliffoscopeUtil.generateSimilarity(BliffoscopeConstantsUtil.STAR_SHIP, BliffoscopeTestConstantsUtil.CHAR_TARGET_DATA_ONE_ROW, BliffoscopeTestConstantsUtil.CHAR_TEST_DATA_TWO_ROW, BliffoscopeTestConstantsUtil.CONFIDENCE_PERCENTAGE_0_5.doubleValue());

    }
    @Test
    public void generateSimilarityGivenWrongDataForDataCharArrWhenDataColumnLessThanSampleColumnThenBliffoscopeException() throws BliffoscopeException {
        this.thrown.expect(BliffoscopeException.class);
        this.thrown.expectMessage(MessageCodeConstants.TEST_FILE_SMALLER_THAN_TARGET_FILE_EXCEPTION_MESSAGE);

        bliffoscopeUtil.generateSimilarity(BliffoscopeConstantsUtil.STAR_SHIP, BliffoscopeTestConstantsUtil.CHAR_TARGET_DATA_TWO_ROW, BliffoscopeTestConstantsUtil.CHAR_TEST_DATA_TWO_ROW, BliffoscopeTestConstantsUtil.CONFIDENCE_PERCENTAGE_0_5.doubleValue());
    }
    @Test
    public void generateSimilarityGivenValidDataThenMatchCoordinateDtos() throws BliffoscopeException {

        List<MatchCoordinateDto> response =  bliffoscopeUtil.generateSimilarity(BliffoscopeConstantsUtil.STAR_SHIP, BliffoscopeTestConstantsUtil.CHAR_TEST_DATA_TWO_ROW, BliffoscopeTestConstantsUtil.CHAR_TARGET_DATA_TWO_ROW, BliffoscopeTestConstantsUtil.CONFIDENCE_PERCENTAGE_0_5.doubleValue());

        List<MatchCoordinateDto> matchCoordinateDtos = matchCoordinateDtoProvider.getMatchCoordinateDtos();
        Assert.assertTrue(response.get(0).getTargetType().equalsIgnoreCase(matchCoordinateDtos.get(0).getTargetType()));
        Assert.assertTrue(response.get(0).getX() == matchCoordinateDtos.get(0).getX());
        Assert.assertTrue(response.get(0).getY() == matchCoordinateDtos.get(0).getY());
        Assert.assertTrue(response.get(0).getConfidencepercentage() == matchCoordinateDtos.get(0).getConfidencepercentage());

    }
}
