package com.deepexi.interview_system.model;

import java.util.List;

public class Interviewee {
    private Integer id;
    private String name;
    private String interviewpost;
    private Integer examscore;
    private String interviewer;
    private Integer result;
    private List<Company> companyList;

    public Interviewee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInterviewpost() {
        return interviewpost;
    }

    public void setInterviewpost(String interviewpost) {
        this.interviewpost = interviewpost;
    }

    public Integer getExamscore() {
        return examscore;
    }

    public void setExamscore(Integer examscore) {
        this.examscore = examscore;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }
}
