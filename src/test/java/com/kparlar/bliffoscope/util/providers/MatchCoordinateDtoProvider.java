package com.kparlar.bliffoscope.util.providers;

import com.kparlar.bliffoscope.model.dto.MatchCoordinateDto;
import com.kparlar.bliffoscope.util.BliffoscopeConstantsUtil;
import com.kparlar.bliffoscope.util.BliffoscopeTestConstantsUtil;

import java.util.ArrayList;
import java.util.List;

public class MatchCoordinateDtoProvider {


    public MatchCoordinateDto getMatchCoordinateDto(){
        MatchCoordinateDto matchCoordinateDto = new MatchCoordinateDto();
        matchCoordinateDto.setConfidencepercentage(BliffoscopeTestConstantsUtil.CONFIDENCE_PERCENTAGE_0_54);
        matchCoordinateDto.setTargetType(BliffoscopeConstantsUtil.STAR_SHIP);
        matchCoordinateDto.setX(BliffoscopeTestConstantsUtil.MATCH_COORDINATE_X);
        matchCoordinateDto.setY(BliffoscopeTestConstantsUtil.MATCH_COORDINATE_Y);
        return matchCoordinateDto;
    }

    public List<MatchCoordinateDto> getMatchCoordinateDtos(){
        MatchCoordinateDto matchCoordinateDto = getMatchCoordinateDto();
        List<MatchCoordinateDto> matchCoordinateDtos = new ArrayList<>();
        matchCoordinateDtos.add(matchCoordinateDto);
        return matchCoordinateDtos;
    }
}
