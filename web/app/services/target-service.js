'use strict';

// Creating the module and factory we referenced in the beforeEach blocks in our test file
angular.module('myApp.targetService', []).config(['$provide',  function ($provide) {
    $provide.factory('TargetService', ['$http', '$q', '$log', function($http, $q, $log) {
        var targetService = {};

        targetService.findAll = function(targetType, files){
            var deferred = $q.defer();

            var url = "http://localhost:8080/api/app/bliffoscope/v1/targets/"+targetType;
            $http.post(url, files,{
                transformRequest: angular.identity,
                headers: {'Access-Control-Allow-Origin': '*',
                    'Content-Type': undefined}
            }).then(function (response) {
                if (response.data) {
                    deferred.resolve(response.data);

                } else {
                    deferred.reject(response);
                }
            },function (error) {
                $log.error("Error while saving task :",error);
                deferred.reject(error);
            });
            return deferred.promise;
        };
        // Users.method = function() {};

        return targetService;
}]);

}]);