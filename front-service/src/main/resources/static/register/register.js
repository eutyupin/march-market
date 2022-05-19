angular.module('market').controller('registerController', function ($scope, $http, $location) {

    $scope.registerNewUser = function () {
        $http.post('http://localhost:5555/auth/register', $scope.newUser)
            .then(function (response) {
                $location.path('/');
            });
    }

});