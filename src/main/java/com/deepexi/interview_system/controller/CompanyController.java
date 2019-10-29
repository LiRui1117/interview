package com.deepexi.interview_system.controller;

import com.deepexi.interview_system.dto.PageResult;
import com.deepexi.interview_system.dto.RequestParam;
import com.deepexi.interview_system.model.Company;
import com.deepexi.interview_system.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/search/{page}/{size}")
    public PageResult<Company> search(@PathVariable int page , @PathVariable int size , @RequestBody RequestParam requestParam){
        return  companyService.findPage(page,size,requestParam);
    }
}
