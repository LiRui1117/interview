app.controller("loginController", function ($scope, loginService) {
    $scope.emailReg = "^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$";
    $scope.registerForm = {};
    $scope.user = {};

    $scope.register = function () {
        loginService.save($scope.user).success(
            function (response) {
                if (!response.success) {
                    alert(response.message);
                    window.location.reload();
                } else {
                    alert(response.message);
                    window.location.href = "login.html";
                }
            }
        )
    }


    $scope.getUsername = function () {
        loginService.getUsername().success(
            function (response) {
                $scope.username = response;
                $scope.entity.username = response;
            }
        )
    }



    $scope.changePassword = function () {
        loginService.updatePassword($scope.entity).success(
            function (response) {
                alert(response.message);
            }
        )
    }


})