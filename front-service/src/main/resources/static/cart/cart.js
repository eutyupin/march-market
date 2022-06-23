angular.module('market').controller('cartController', function ($scope, $http, $localStorage) {

    $scope.loadCart = function () {
        $http({
            url: 'http://localhost:5555/cart/api/v1/cart/' + $localStorage.marchMarketGuestCartId,
            method: 'GET'
        }).then(function (response) {
                $scope.cart = response.data;
            });
    };

    $scope.createOrder = function () {
        if ($scope.deliveryInformation.address !== '' && $scope.deliveryInformation.phone !== '') {
            $http({
                url: 'http://localhost:5555/core/api/v1/orders',
                body: $scope.deliveryInformation,
                method: 'POST'
            }).then(function (response) {
                    $scope.loadCart();
                });
        } else alert('Заполните все поля!');
    }

    $scope.guestCreateOrder = function () {
        alert('Для оформления заказа необходимо войти в учетную запись');
    }

    $scope.removeFromCart = function (id) {
        $http({
            url: 'http://localhost:5555/cart/api/v1/cart/' + $localStorage.marchMarketGuestCartId + '/remove/' + id,
            method: 'DELETE'
        }).then(function (response) {
                $scope.loadCart();
            });
    }

    $scope.incrementProductToCart = function (id) {
        $http({
            url: 'http://localhost:5555/cart/api/v1/cart/' + $localStorage.marchMarketGuestCartId + '/add/' + id,
            method: 'POST'
        }).then(function (response) {
                $scope.loadCart();
            });
    }

    $scope.decrementFromCart = function (id) {
        $http({
            url: 'http://localhost:5555/cart/api/v1/cart/' + $localStorage.marchMarketGuestCartId + '/decrement/' + id,
            method: 'POST'
        }).then(function (response) {
                $scope.loadCart();
            });
    }

    $scope.clearCart = function () {
        $http({
            url: 'http://localhost:555/cart/api/v1/cart/' + $localStorage.marchMarketGuestCartId + '/clear',
            method: 'DELETE'
        }).then(function (response) {
                $scope.loadCart();
            });
    }
    $scope.loadCart();
});