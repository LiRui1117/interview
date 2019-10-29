app.service("loginService",function ($http) {

    this.save=function (user) {
        return $http.post("/user/save",user);
    }

    this.findUserById=function (id) {
        return $http.get("/findUserById/id"+id)
    }

    this.getUsername = function () {
        return $http.get("/user/getUsername");
    }
    
    this.updatePassword = function (entity) {
        return $http.post("/user/updatePw",entity);
    }
});