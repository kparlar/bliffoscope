package com.kparlar.bliffoscope.util;

public class BliffoscopeTestConstantsUtil {

    public static final String TARGET_TYPE_NOT_VALID="not-valid";
    public static final String FOLDER_SAMPLE = "src/samples/";
    public static final String FILE_STAR_SHIP = "Starship.blf";
    public static final String FILE_TEST_DATA = "TestData.blf";
    public static final String FILE_TEST = "TEST.blf";

    public static final Double CONFIDENCE_PERCENTAGE_0_7= new Double(0.7);
    public static final Double CONFIDENCE_PERCENTAGE_0_2= new Double(0.2);
    public static final Double CONFIDENCE_PERCENTAGE_0_5= new Double(0.5);
    public static final Double CONFIDENCE_PERCENTAGE_0_54= new Double(0.54);
    public static final int MATCH_COORDINATE_X = 4;
    public static final int MATCH_COORDINATE_Y = 0;
    public static final String EXCEPTION = "Test Exception";
    public static final String EXCEPTION_TEXT = "An exception occurred.";
    public static final String EXCEPTION_FAILED_MESSAGE = "TEST EXCEPTION";
    public static final String EXCEPTION_FAILED_MESSAGE_ERROR_CODE = "Ex01";

    public static final char[][] CHAR_TEST_DATA_TWO_ROW = {
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','+',' ','+'},
            {' ','+',' ',' ','+','+',' ',' ',' ',' ',' ','+',' ',' ',' ','+',' '}
    };
    public static final char[][] CHAR_TARGET_DATA_TWO_ROW = {
            {' ','+','+','+','+','+','+','+','+','+','+',' '},
            {'+','+',' ',' ',' ',' ',' ',' ',' ',' ','+','+'}
    };
    public static final char[][] CHAR_TARGET_DATA_ONE_ROW = {
            {' ','+','+','+','+','+','+','+','+','+','+',' '}
    };



}
