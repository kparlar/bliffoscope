'use strict';

angular.module('myApp.view1', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view1', {
    templateUrl: 'view1/view1.html',
    controller: 'View1Ctrl'
  });
}])
    .controller('View1Ctrl', ['$scope', '$http', function($scope, $http) {
        $scope.initiateSpaceArr = function(matrix, matrixArr) {
            for (var i = 0; i < matrix.length; i++) {
                var tempMatrix = matrix[i];
                var tempArr = [];
                for (var k = 0; k < tempMatrix.length; k++) {
                    tempArr.push(tempMatrix.charAt(k));
                }
                matrixArr.push(tempArr);
            }
            return matrixArr;
        };

        $scope.uploadFile = function() {
            if(!$scope.validate()){
                return;
            }
            var fd = new FormData();
            for (var i in $scope.files) {
                fd.append($scope.files[i].name, $scope.files[i].file)
            }
            fd.append("threshold", $scope.threshold2);
            var tmpurl = "http://localhost:8080/api/app/bliffoscope/v1/targets/"+ $scope.targetType;

            $http.post(tmpurl, fd,{
                transformRequest: angular.identity,
                headers: {'Access-Control-Allow-Origin': '*',
                    'Content-Type': undefined}
            }).then(function (response) {
                $scope.result = JSON.parse(JSON.stringify(response.data.matchCoordinateDtos));
                $scope.targetMatrix  = response.data.targetDataArr;
                $scope.testDataMatrix  = response.data.testDataArr;
                $scope.targetMatrixArr = $scope.initiateSpaceArr($scope.targetMatrix, []);
                $scope.testDataMatrixArr= $scope.initiateSpaceArr($scope.testDataMatrix, []);
                $scope.threshold = $scope.threshold2;
                $scope.flagresult = true;
                $scope.names= response.data;
            }, function (errorstatus) {
                if (status == 0)
                    $scope.error = "Server cannot be reached.";
                $log.error("Error while saving details",error);
            });




        };

        $scope.isFloat = function(x){
            return parseFloat(x) == x;
        };

        $scope.validate =  function () {
            if ($scope.threshold2  == null
                || $scope.threshold2  == ""
                || parseFloat($scope.threshold2 ) > 1
                || parseFloat($scope.threshold2 ) < 0) {
                alert("Please specify a valid value between 0 and 1");
                $scope.threshold2  = 0.7;
                return false;
            }
            if(!$scope.isFloat($scope.threshold2 )){
                alert("Please specify a valid value between 0 and 1");
                $scope.threshold2  = 0.7;
                return false;
            }

            if($scope.files.length < 2){
                alert("Please select Target and Test files");
                return false;
            }
            if($scope.targetType == undefined || $scope.targetType == ''){
                alert("Please select Target Type");
                return false;
            }
            return true;

        };




        $scope.files = [];
        $scope.setFiles = function(element) {
            $scope.$apply(function($scope) {
                var uploadFile = {};
                for (var i in $scope.files) {
                    if($scope.files[i].name === element.id){
                        $scope.files[i].file = element.files[0];
                        return;
                    }
                }

                uploadFile.name = element.id;
                uploadFile.file = element.files[0];
                $scope.files.push(uploadFile);
            });

        };



        $scope.openModel = function(x, y) {
            console.log("X value:"+x);
            console.log("y value:"+y);
            $scope.X = x;
            $scope.Y = y;
            $scope.showModal = true;
        };

        $scope.ok = function() {
            $scope.showModal = false;
        };

        $scope.cancel = function() {
            $scope.showModal = false;
        };

    }]);