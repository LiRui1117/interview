package com.deepexi.interview_system.dao;

import com.deepexi.interview_system.dto.RequestParam;
import com.deepexi.interview_system.model.Company;
import com.deepexi.interview_system.model.Interviewee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CompanyDao {
    /**
     *查询所有
     */
    List<Company> findAll(RequestParam requestParam);

    /**
     * 根据公司名称查询面试者
     * @param companyId
     * @return
     */
    List<String> findByCompanyId(Integer companyId);
}
