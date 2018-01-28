package com.kparlar.bliffoscope.util;

import com.kparlar.bliffoscope.exception.BliffoscopeException;
import com.kparlar.bliffoscope.model.dto.MatchCoordinateDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class BliffoscopeUtil {

    public List<MatchCoordinateDto> generateSimilarity(String sampleName, char[][] data, char[][] sample, double threshold) throws BliffoscopeException {
        List<MatchCoordinateDto> results = new ArrayList<>();
        int dataRow = data.length;
        int dataColumn = data[0].length;
        int sampleRow = sample.length;
        int sampleColumn = sample[0].length;

        checkRowColumnLength(dataRow, sampleRow);

        checkRowColumnLength(dataColumn, sampleColumn);

        int yLength = dataColumn - sampleColumn;
        int xLength = dataRow - sampleRow;

        for (int i = 0; i <= xLength; i++) {
            for (int j = 0; j <= yLength; j++) {
                MatchCoordinateDto matchCoordinaateDto = calculateConfidence(sampleName, i, j, data, sample);
                if(matchCoordinaateDto.getConfidencepercentage() >= threshold)
                    results.add(matchCoordinaateDto);
            }
        }
        return results;
    }

    private void checkRowColumnLength(int dataRow, int sampleRow) throws BliffoscopeException {
        if (dataRow < sampleRow)
            throw new BliffoscopeException(
                    MessageCodeConstants.TEST_FILE_SMALLER_THAN_TARGET_FILE_EXCEPTION_MESSAGE,
                    MessageCodeConstants.TEST_FILE_SMALLER_THAN_TARGET_FILE_EXCEPTION_CODE,
                    HttpStatus.BAD_REQUEST);
    }


    private MatchCoordinateDto calculateConfidence(String sampleName, int i, int j, char[][] data,
                                                   char[][] sample) {
        int sampleRow = sample.length;
        int sampleColumn = sample[0].length;

        int totalPixels = sampleRow * sampleColumn;
        int matchedPixels = 0;
        DecimalFormat df = new DecimalFormat("#,###.00");

        df.setRoundingMode(RoundingMode.FLOOR);
        DecimalFormatSymbols newSymbols = new DecimalFormatSymbols(Locale.US);
        df.setDecimalFormatSymbols(newSymbols);
        for (int m = 0; m < sampleRow; m++) {
            for (int n = 0; n < sampleColumn; n++) {
                //if (data[m + i][n + j] == sample[m][n] &&  sample[m][n] == '+')
                if (data[m + i][n + j] == sample[m][n])
                    matchedPixels++;
            }
        }

        double conf = (double) matchedPixels / (double) totalPixels;
        if(conf>0.0){
            conf= new Double(df.format(conf));
        }

        return new MatchCoordinateDto(sampleName, j, i, conf);

    }
}
