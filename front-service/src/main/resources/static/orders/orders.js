angular.module('market').controller('ordersController', function ($scope, $http) {
    $scope.loadOrders = function () {
        $http({
            url: 'http://localhost:5555/core/api/v1/orders',
            method: 'GET'
        }).then(function (response) {
                $scope.orders = response.data;
            });
    };

    $scope.loadOrders();
});