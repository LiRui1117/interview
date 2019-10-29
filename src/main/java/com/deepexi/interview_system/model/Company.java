package com.deepexi.interview_system.model;


import java.util.List;

public class Company {
    private Integer id;
    private String company;//公司名称
    private Integer count;//相同公司的个数
    private List<String> intervieweeNameList;//面试人员姓名列表

    public Company() {
    }

    public Company(Integer id, String company, Integer count, List<String> intervieweeNameList) {
        this.id = id;
        this.company = company;
        this.count = count;
        this.intervieweeNameList = intervieweeNameList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<String> getIntervieweeNameList() {
        return intervieweeNameList;
    }

    public void setIntervieweeNameList(List<String> intervieweeNameList) {
        this.intervieweeNameList = intervieweeNameList;
    }
}
