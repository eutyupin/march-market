angular.module('market').controller('registerController', function ($scope, $http) {

    $scope.registration = function () {
        $http.post('http://localhost:5555/auth/register', $scope.newUser)
            .then(function (response) {

            });
    }

});