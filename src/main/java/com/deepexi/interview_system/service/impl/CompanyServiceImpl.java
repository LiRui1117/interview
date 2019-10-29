package com.deepexi.interview_system.service.impl;

import com.deepexi.interview_system.dao.CompanyDao;
import com.deepexi.interview_system.dto.PageResult;
import com.deepexi.interview_system.dto.RequestParam;
import com.deepexi.interview_system.model.Company;
import com.deepexi.interview_system.service.CompanyService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDao companyDao;

    @Override
    public PageResult<Company> findPage(int pageNum, int size, RequestParam requestParam) {
        PageHelper.startPage(pageNum,size);
        Page<Company> page = (Page<Company>) companyDao.findAll(requestParam);
        return new PageResult<Company>(page.getTotal(),page.getResult());
    }
}
