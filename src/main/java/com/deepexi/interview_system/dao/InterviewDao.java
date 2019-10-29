package com.deepexi.interview_system.dao;

import com.deepexi.interview_system.dto.RequestParam;
import com.deepexi.interview_system.model.Company;
import com.deepexi.interview_system.model.Connection;
import com.deepexi.interview_system.model.Interviewee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface InterviewDao {
   /**
    * 条件查询
    * @param requestParam
    * @return
    */
   List<Interviewee> findAll(RequestParam requestParam);

   /**
    * 根据id查询公司
    * @return
    */
   List<Company> findCompanyById(Integer applicant_id);
   /**
    * 根据名称查询公司
    * @param companyName
    * @return
    */
   Company findCompanyByName(String companyName);

   /**
    * 插入
    */
   int insertCompany(Company company);

   int insertApplicant(Interviewee interviewee);

   void  insertConnection(Connection connection);

   /**
    * 根据id查询所有信息
    */
   Interviewee findIntervieweeById(int id);

   /**
    * 删除
    */
   void  deleteCompany(int companyId);
   void  deleteApplicant(int aid);
   void  deleteMiddleTable(int aid);

   /**
    * 查询面试官信息
    * @return
    */
   List<String> findInterviewer();

   /**
    * 查询面试职位信息
    * @return
    */
   List<String> findInterviewpost();

   /**
    * 根据公司id查询中间表的面试者id
    * @param CompanyId
    * @return
    */
   List<Integer> findConnectionByCompanyId(Integer CompanyId);


}
