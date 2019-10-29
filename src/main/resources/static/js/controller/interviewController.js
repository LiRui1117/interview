app.controller("interviewController", function ($scope, interviewService) {
    $scope.findAll = function () {
        interviewService.findAll().success(
            function (res) {
                $scope.list = res;
            }
        )
    }

    $scope.result = ["未通过", "通过", "待定"];
    $scope.options = [0, 1, 2];

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


    $scope.findPage = function (page, size) {
        interviewService.findPage(page, size).success(
            function (res) {
                $scope.itervieweeList = res.list;
                $scope.paginationConf.totalItems = res.total;
            }
        )
    }

    $scope.requestParam = {};
    $scope.search = function (page, size) {
        interviewService.search(page, size, $scope.requestParam).success(
            function (res) {
                $scope.itervieweeList = res.list;
                $scope.paginationConf.totalItems = res.total;
            }
        )
    }

    //保存的数据实体
    $scope.addTableRow = function () {
        $scope.entity.companyList.push({});
    }

    $scope.deleTableRow = function (index) {
        $scope.entity.companyList.splice(index, 1)
    }

    //新增
    $scope.add = function () {
        interviewService.add($scope.entity).success(
            function (response) {
                if (response.success) {
                    alert(response.message);
                    $scope.reload();
                } else {
                    alert(response.message);
                }
            }
        )
    }

    $scope.save = function () {
        var obj = null;
        if ($scope.entity.id != null) {
            obj = interviewService.update($scope.entity);
        } else {
            obj = interviewService.add($scope.entity);
        }
        obj.success(
            function (response) {
                if (response.success) {
                    $scope.reload();
                } else {
                    alert(response.message);
                }
            }
        )
    }


    //根据id查询
    $scope.findOne = function (id) {
        interviewService.findOne(id).success(
            function (response) {
                $scope.entity = response;
            }
        )
    }

    // 用来存放选中的复选框的id
    $scope.selectIds = [];

    $scope.updateSelection = function ($event, id) {
        if ($event.target.checked) {
            $scope.selectIds.push(id);
        } else {
            var index = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(index, 1);
        }
    }

    //根据选中的复选框删除
    $scope.deleteSelectIds = function () {
        interviewService.deleteSelectIds($scope.selectIds).success(
            function (response) {
                if (response.success){
                    $scope.selectIds=[];
                    $scope.reload();
                } else{
                    alert(response.message);
                }
            }
        )
    }

    $scope.findInterviewer = function () {
        interviewService.findInterviewer().success(
            function (response) {
                $scope.interviewerList = response;
            }
        )
    }

    $scope.findInterviewpost = function () {
        interviewService.findInterviewpost().success(
            function (response) {
                $scope.interviewpostList = response;
            }
        )
    }


});