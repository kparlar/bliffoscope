'use strict';
describe('Target Service Factory', function () {

    var targetService;
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
            "              + +    +              ++           +       +++    +     +               +    +    +   "
        ],
        "targetDataArr": [
            " ++++++++++ "
        ]
    };

    //Before each test load our myApp.targetService module
    beforeEach(module('myApp.targetService'));



    beforeEach(function() {
        inject(function($injector) {
            targetService = $injector.get('TargetService');
            $httpBackend  = $injector.get('$httpBackend');
        });

    });

    // 5. make sure no expectations were missed in your tests.
    afterEach(function () {
        $httpBackend.verifyNoOutstandingExpectation();
        $httpBackend.verifyNoOutstandingRequest();
    });



    // A Simple test to verify the targetService factory exists

    it('TargetService exist', function () {
        expect(targetService).toBeDefined();
    });

    //Test for finding all targets in test file
    describe('.findAll()', function(){
       //A Simple test to verify the method findAll exists;
       it('findAll Method exists', function(){
          expect(targetService.findAll).toBeDefined();
       });

         it('should return dummy response', function () {
             var targetType = 'StarShip';
             var tempFiles = new FormData();
             //7. expectGET to make sure this is called once.
             $httpBackend.expectPOST("http://localhost:8080/api/app/bliffoscope/v1/targets/StarShip").respond(response);
            //8. make the call.

             var returnedPromise = targetService.findAll(targetType, tempFiles);


             //9. set up a handler for the response, that will put the result
             // into a variable in this scope for you to test.
             var result;
             returnedPromise.then(function (response) {
                 result = response;
             });

             //10. flush the backend to "execute" the request to do the expectedGET assertion.
             $httpBackend.flush();


             //11. check the result.

             expect(result).toEqual(response);

         })
    });
});