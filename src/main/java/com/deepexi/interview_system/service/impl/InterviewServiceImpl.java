package com.deepexi.interview_system.service.impl;

import com.deepexi.interview_system.dao.InterviewDao;
import com.deepexi.interview_system.dto.PageResult;
import com.deepexi.interview_system.dto.RequestParam;
import com.deepexi.interview_system.model.Company;
import com.deepexi.interview_system.model.Connection;
import com.deepexi.interview_system.model.Interviewee;
import com.deepexi.interview_system.service.InterviewService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InterviewServiceImpl implements InterviewService {
    @Autowired
    private InterviewDao interviewDao;

    @Override
    public List<Interviewee> findAll() {
        return interviewDao.findAll(null);
    }

    @Override
    public PageResult<Interviewee> findPage(int pageNum, int size , RequestParam requestParam) {
        PageHelper.startPage(pageNum,size);
        Page<Interviewee> page = (Page<Interviewee>)interviewDao.findAll(requestParam);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public List<Company> findCompanyById(Integer applicant_id){
        return interviewDao.findCompanyById(applicant_id);
    }

    @Override
    @Transactional
    public void insertInterview(Interviewee interviewee) {
        if (interviewee == null){
            return;
        }
        interviewDao.insertApplicant(interviewee);
        List<Company> companyList = interviewee.getCompanyList();
        for (Company company : companyList) {
            Company company1 = interviewDao.findCompanyByName(company.getCompany());
            if (company1 != null){
                Connection connection = new Connection();
                connection.setApplicantId(interviewee.getId());
                connection.setCompanyId(company1.getId());
                interviewDao.insertConnection(connection);
            }else{
                interviewDao.insertCompany(company);
                Connection connection = new Connection();
                connection.setApplicantId(interviewee.getId());
                connection.setCompanyId(company.getId());
                interviewDao.insertConnection(connection);
            }
        }
    }



    @Override
    @Transactional
    public void updateInterview(Interviewee interviewee) {
        if(interviewee != null){
            delete(interviewee.getId());
            insertInterview(interviewee);
        }
    }

    @Override
    public Interviewee findInterviewById(int id) {
        return interviewDao.findIntervieweeById(id);
    }

    @Override
    @Transactional
    public void delete(int aid) {
            Interviewee interviewee = interviewDao.findIntervieweeById(aid);
            List<Company> companyList = interviewee.getCompanyList();
            interviewDao.deleteApplicant(aid);
            for (Company company : companyList) {
                List<Integer> list = interviewDao.findConnectionByCompanyId(company.getId());
                if(list.size() <= 1){
                    interviewDao.deleteCompany(company.getId());
                }
                interviewDao.deleteMiddleTable(aid);
            }
    }

    @Override
    @Transactional
    public void deleteIds(int[] ids) {
        if (ids != null && ids.length >0){
            for (int id : ids) {
                delete(id);
            }
        }
    }

    @Override
    public List<String> findInterviewer() {
        return interviewDao.findInterviewer();
    }

    @Override
    public List<String> findInterviewpost() {
        return interviewDao.findInterviewpost();
    }
}
