app.controller("companyController",function ($scope,companyService) {
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.reload();
        }
    }

    //重新加载
    $scope.reload = function () {
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    }

    $scope.requestParam={};
    $scope.search = function (page, size) {
        companyService.search(page, size, $scope.requestParam).success(
            function (res) {
                $scope.CompanyList = res.list;
                $scope.paginationConf.totalItems = res.total;
            }
        )
    }
})