angular.module('market', []).controller('indexController', function ($scope, $http) {
    $scope.fillTable = function () {
        $http.get('http://localhost:8189/market/api/v1/products')
            .then(function (response) {
                $scope.products = response.data;
                // console.log(response);
            });
    };

    $scope.deleteProduct = function (id) {
        $http.delete('http://localhost:8189/market/api/v1/products/' + id)
            .then(function (response) {
                $scope.fillTable();
            });
    }

    $scope.createNewProduct = function () {
        // console.log($scope.newProduct);
        $http.post('http://localhost:8189/market/api/v1/products', $scope.newProduct)
            .then(function (response) {
                $scope.newProduct = null;
                $scope.fillTable();
            });
    }
    $scope.fillCart = function () {
        $http.get('http://localhost:8189/market/api/v1/cart')
            .then(function (response) {
                $scope.cartItems = response.data;
            });
    };

    $scope.addProductToCart = function (id) {
        $http.get('http://localhost:8189/market/api/v1/cart/add/' + id)
            .then(function (response) {
                $scope.fillCart();
            });
    }

    $scope.deleteFromCart = function (id) {
        $http.delete('http://localhost:8189/market/api/v1/cart/' + id)
            .then(function (response) {
                $scope.fillCart();
            });
    }

    $scope.decrementFromCart = function (id) {
        $http.delete('http://localhost:8189/market/api/v1/cart/decrement/' + id)
            .then(function (response) {
                $scope.fillCart();
            });
    }

    $scope.fillTable();
    $scope.fillCart();
});