package com.deepexi.interview_system.service;


import com.deepexi.interview_system.dto.PageResult;
import com.deepexi.interview_system.dto.RequestParam;
import com.deepexi.interview_system.model.Company;

import java.util.List;

public interface CompanyService {
    PageResult<Company> findPage(int page , int size , RequestParam requestParam);
}
