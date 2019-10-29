app.service("interviewService",function ($http) {
    //查询所有
    this.findAll = function () {
        return $http.get('/interview/findAll');
    }

    //分页查询
    this.findPage = function (page,size) {
        return $http.get("/interview/findPage/"+page+"/"+size);
    }

    //搜索
    this.search = function (page,size,requestParam) {
        return $http.post("/interview/search/"+page+"/"+size,requestParam);
    }

    //新增
    this.add = function (entity) {
        return $http.post("/interview/insert",entity);
    }

    //根据id查询
    this.findOne = function (id) {
        return $http.get("/interview/findOne/"+id);
    }

    // 修改
    this.update = function (entity) {
        return $http.post("/interview/update",entity);
    }

    this.deleteSelectIds = function (ids) {
        return $http.delete("/interview/delete/"+ids);
    }

    this.findInterviewer = function () {
        return $http.get("/interview/findInterviewer");
    }

    this.findInterviewpost = function () {
        return $http.get("/interview/findInterviewpost");
    }
})