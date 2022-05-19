angular.module('market').controller('cartController', function ($scope, $http, $localStorage) {

    $scope.loadCart = function () {
        $http.get('http://localhost:5555/cart/api/v1/cart/' + $localStorage.marchMarketGuestCartId)
            .then(function (response) {
                $scope.cart = response.data;
            });
    };

    $scope.createOrder = function () {

        if ($scope.deliveryInformation.address !== '' && $scope.deliveryInformation.phone !== '') {
            $http.post('http://localhost:5555/core/api/v1/orders')
                .then(function (response) {
                    $scope.loadCart();
                });
        } else alert('Заполните все поля!');
    }

    $scope.guestCreateOrder = function () {
        alert('Для оформления заказа необходимо войти в учетную запись');
    }

    $scope.loadCart();
});