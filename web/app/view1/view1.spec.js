'use strict';

describe('myApp.view1 module', function() {
    var view1Ctrl;
    var scope;
    var testMatrix = [
        "              + +",
        " +  ++     +   + "
    ];
    var expectedMatrix = [
        [' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','+',' ','+'],
        [' ','+',' ',' ','+','+',' ',' ',' ',' ',' ','+',' ',' ',' ','+',' ']
    ];
    var targetMatrix = [
        " ++++++++++ ",
        "++        ++"
        ];
    var expectedTargetMatrix = [
        [' ','+','+','+','+','+','+','+','+','+','+',' '],
        ['+','+',' ',' ',' ',' ',' ',' ',' ',' ','+','+']
    ];
    var $httpBackend;
    var response = {
        "matchCoordinateDtos": [
            {
                "target_type": "StarShip",
                "x": 56,
                "y": 26,
                "confidencepercentage": 0.75
            }
        ],
        "testDataArr": [
            "              + +",
            " +  ++     +   + "
        ],
        "targetDataArr": [
            " ++++++++++ ",
            "++        ++"
        ]
    };



    beforeEach(module('myApp.view1'));

    beforeEach(function() {

        inject(function(_$controller_, _$rootScope_, _$http_, _$injector_) {
            scope =  _$rootScope_.$new();
            view1Ctrl = _$controller_('View1Ctrl', {
                '$scope': scope,
                '$http': _$http_
            });

            $httpBackend  = _$injector_.get('$httpBackend');
        });

    });


    // 5. make sure no expectations were missed in your tests.
    afterEach(function () {
        $httpBackend.verifyNoOutstandingExpectation();
        $httpBackend.verifyNoOutstandingRequest();
    });

    describe('view1 controller', function(){

        it('exists', function () {
            expect(view1Ctrl).toBeDefined();
        });

    });

    describe('initiateSpaceArr method', function () {
        it('exists', function(){
            expect(scope.initiateSpaceArr).toBeDefined();
        });

        it('check method', function(){
            expect(scope.initiateSpaceArr(testMatrix, [])).toEqual(expectedMatrix);
        });
    });


    describe('uploadFile method', function(){
        it('exists', function(){
            expect(scope.uploadFile).toBeDefined();
        });

        it('check method', function(){
            scope.files = [];
            var fileInfo = {};
            fileInfo.name = 'test_file_name';
            fileInfo.file = 'test_file';
            scope.files.push(fileInfo);
            scope.targetType = 'StarShip';
            scope.targetMatrixArr = [];
            scope.testDataMatrixArr = [];
            scope.threshold2 = 0.7;
            //7. expectGET to make sure this is called once.
            $httpBackend.expectPOST("http://localhost:8080/api/app/bliffoscope/v1/targets/StarShip").respond(response);
            //8. make the call.
            // Use a Jasmine Spy to return the deferred promise
             spyOn(scope, "initiateSpaceArr").and.callFake( function(paramTargetMatrix,   paramTargetMatrixArr){
                 if(paramTargetMatrix[0] == targetMatrix[0]) {
                     return expectedTargetMatrix;
                 }else{
                     return expectedMatrix;
                }
             });

            spyOn(scope, "validate").and.callFake( function(){
                return true;
            });
            scope.uploadFile();
            $httpBackend.flush();
            expect(scope.targetMatrixArr[0]).toEqual(expectedTargetMatrix[0]);
            expect(scope.testDataMatrixArr[0]).toEqual(expectedMatrix[0]);
            expect(scope.threshold).toEqual(scope.threshold2);
            expect(scope.flagresult).toEqual(true);

        });
    });



    describe('isFloat method', function () {
        it('exists', function(){
            expect(scope.isFloat).toBeDefined();
        });
        it('check method', function(){

            expect(scope.isFloat(0.7)).toEqual(true);
            expect(scope.isFloat(null)).toEqual(false);
            expect(scope.isFloat('')).toEqual(false);
            expect(scope.isFloat(0)).toEqual(true);
        });

    });


    describe('validate method', function () {
        it('exists', function(){
            expect(scope.validate).toBeDefined();
        });
        it('check threshold value between 0 and 1', function(){
            spyOn(scope, "isFloat").and.callThrough();
            scope.threshold2 = 0;
            expect(scope.validate()).toEqual(false);
            scope.threshold2 = 1;
            expect(scope.validate()).toEqual(false);
            scope.threshold2 = null;
            expect(scope.validate()).toEqual(false);
            scope.threshold2 = "";
            expect(scope.validate()).toEqual(false);

        });
    });
});