package com.kparlar.bliffoscope.service;

import com.kparlar.bliffoscope.exception.BliffoscopeException;
import com.kparlar.bliffoscope.model.TargetItem;
import com.kparlar.bliffoscope.model.TestItem;
import com.kparlar.bliffoscope.model.dto.BliffoscopeDto;
import com.kparlar.bliffoscope.model.dto.MatchCoordinateDto;
import com.kparlar.bliffoscope.util.BliffoscopeConstantsUtil;
import com.kparlar.bliffoscope.util.BliffoscopeUtil;
import com.kparlar.bliffoscope.util.MessageCodeConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class TargetService {

    private BliffoscopeUtil bliffoscopeUtil;

    public TargetService(BliffoscopeUtil bliffoscopeUtil){
        this.bliffoscopeUtil = bliffoscopeUtil;
    }



    public BliffoscopeDto compare(String targetType, MultipartFile targetFile, MultipartFile testFile, double threshold) throws BliffoscopeException {
        validateCompare(targetType);
        try {
            return compareInner(targetType, targetFile.getInputStream(), testFile.getInputStream(), threshold);
        } catch (IOException e) {
           throw new BliffoscopeException(MessageCodeConstants.TEST_FILE_OR_TARGET_FILE_PARSE_EXCEPTION_MESSAGE, MessageCodeConstants.TEST_FILE_OR_TARGET_FILE_PARSE_EXCEPTION_CODE, HttpStatus.BAD_REQUEST);
        }
    }

    private BliffoscopeDto compareInner(String targetType, InputStream isTargetData, InputStream isTestData, double threshold)throws IOException, BliffoscopeException {
        TestItem testItem = new TestItem(isTestData);
        TargetItem targetItem = new TargetItem(isTargetData);
        List<MatchCoordinateDto> matchCoordinateDtos = bliffoscopeUtil.generateSimilarity(targetType, testItem.getMatrix(), targetItem.getMatrix(), threshold);
        BliffoscopeDto bliffoscopeDto = new BliffoscopeDto();
        bliffoscopeDto.setMatchCoordinateDtos(matchCoordinateDtos);
        bliffoscopeDto.setTargetDataArr(targetItem.getMatrix());
        bliffoscopeDto.setTestDataArr(testItem.getMatrix());
        return bliffoscopeDto;
    }


    private void validateCompare(String targetType) throws BliffoscopeException {
        switch (targetType) {
            case BliffoscopeConstantsUtil.SLIME_TORPEDO:
                break;
            case BliffoscopeConstantsUtil.STAR_SHIP:
                break;
            default:
                throw new BliffoscopeException(
                        MessageCodeConstants.REST_CLIENT_EXCEPTION_MESSAGE,
                        MessageCodeConstants.REST_CLIENT_EXCEPTION_CODE,
                        HttpStatus.NOT_FOUND);
        }
    }
}
