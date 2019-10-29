app.service("companyService",function ($http) {
    this.search = function (page,size,requestParam) {
        return $http.post("/company/search/"+page+"/"+size,requestParam);
    }

})