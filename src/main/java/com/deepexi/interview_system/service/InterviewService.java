package com.deepexi.interview_system.service;


import com.deepexi.interview_system.dto.PageResult;
import com.deepexi.interview_system.dto.RequestParam;
import com.deepexi.interview_system.model.Company;
import com.deepexi.interview_system.model.Interviewee;

import java.util.List;

public interface InterviewService {
    /**
     * 查询所有
     * @return
     */
    List<Interviewee> findAll();

    /**
     * 根据条件分页查询
     * @param pageNum
     * @param size
     * @param requestParam
     * @return
     */
    PageResult findPage(int pageNum , int size, RequestParam requestParam);

    /**
     * 根据id查询公司
     */
    List<Company> findCompanyById(Integer applicant_id);

    /**
     * 插入interview对象
     * @param interviewee
     */
    void insertInterview(Interviewee interviewee);

    /**
     * 更新interview对象
     * @param interviewee
     */
    void updateInterview(Interviewee interviewee);

    /**
     * 根据id查询所有信息
     * @param id
     * @return
     */
    Interviewee findInterviewById(int id);

    /**
     * 根据id删除信息
     * @param aids
     */
    void delete(int aids);

    /**
     * 批量删除
     * @param ids
     */
    void deleteIds(int[] ids);

    /**
     * 面试官下拉数据
     * @return
     */
    List<String> findInterviewer();

    /**
     * 面试职位下拉数据
     * @return
     */
    List<String> findInterviewpost();

}
