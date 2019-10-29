package com.deepexi.interview_system.dto;

import java.io.Serializable;

public class RequestParam implements Serializable {
    private String name; // 面试者姓名
    private String interviewpost;//面试职位
    private String interviewer;//面试官
    private String company; // 公司名称

    public RequestParam(String name, String interviewpost, String interviewer, String company) {
        this.name = name;
        this.interviewpost = interviewpost;
        this.interviewer = interviewer;
        this.company = company;
    }

    public RequestParam() {
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

    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
