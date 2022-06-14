angular.module('market').controller('storeController', function ($scope, $http, $localStorage) {
    $scope.loadProducts = function (pageIndex = 1) {
        $http.get('http://localhost:5555/core/api/v1/products?page=' + pageIndex)
            .then(function (response) {
                $scope.productsPage = response.data;
                $scope.generatePagesList($scope.productsPage.totalPages);
            });
    };

    $scope.addToCart = function (id) {
        $http.get('http://localhost:5555/cart/api/v1/cart/' + $localStorage.marchMarketGuestCartId + '/add/' + id)
            .then(function (response) {
            });
    }

    $scope.generatePagesList = function (totalPages) {
        out = [];
        for (let i = 0; i < totalPages; i++) {
            out.push(i + 1);
        }
        $scope.pagesList = out;
    }

    $scope.loadProducts();
});