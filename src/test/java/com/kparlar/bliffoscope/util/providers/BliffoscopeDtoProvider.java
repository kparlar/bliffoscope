package com.kparlar.bliffoscope.util.providers;

import com.kparlar.bliffoscope.model.dto.BliffoscopeDto;

public class BliffoscopeDtoProvider {

    public BliffoscopeDto getBliffoscopeDto(){
        BliffoscopeDto bliffoscopeDto = new BliffoscopeDto();
        bliffoscopeDto.setTestDataArr(null);
        bliffoscopeDto.setTargetDataArr(null);
        MatchCoordinateDtoProvider matchCoordinateDtoProvider = new MatchCoordinateDtoProvider();
        bliffoscopeDto.setMatchCoordinateDtos(matchCoordinateDtoProvider.getMatchCoordinateDtos());
        return bliffoscopeDto;
    }
}
