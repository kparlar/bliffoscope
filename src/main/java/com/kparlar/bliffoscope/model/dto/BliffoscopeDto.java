package com.kparlar.bliffoscope.model.dto;

import java.util.List;

public class BliffoscopeDto {

    List<MatchCoordinateDto> matchCoordinateDtos;
    char[][] testDataArr;
    char[][] targetDataArr;

    public char[][] getTestDataArr() {
        return testDataArr;
    }

    public char[][] getTargetDataArr() {
        return targetDataArr;
    }

    public List<MatchCoordinateDto> getMatchCoordinateDtos() {
        return matchCoordinateDtos;
    }

    public void setMatchCoordinateDtos(List<MatchCoordinateDto> matchCoordinateDtos) {
        this.matchCoordinateDtos = matchCoordinateDtos;
    }

    public void setTestDataArr(char[][] testDataArr) {
        this.testDataArr = testDataArr;
    }

    public void setTargetDataArr(char[][] targetDataArr) {
        this.targetDataArr = targetDataArr;
    }
}
