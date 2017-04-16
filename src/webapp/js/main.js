/**
 * Created by kadams on 24/03/17.
 */
var app = angular.module("mess", []);


app.controller('myCtrl', ['$scope','dataFetch', function($scope,dataFetch ) {
    $scope.firstName = "John";
    $scope.lastName = "Doe";
    $scope.vendor = dataFetch.getVendorServices();



}]);


app.config(function($httpProvider) {
    $httpProvider.defaults.headers.common['Authorization'] = 'Basic ' + 'dXNlcjpwYXNzd29yZEAx';
})


