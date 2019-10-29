package com.deepexi.interview_system.model;

public class Connection {
    private Integer applicantId;
    private Integer companyId;

    public Connection(Integer applicantId, Integer companyId) {
        this.applicantId = applicantId;
        this.companyId = companyId;
    }

    public Connection() {
    }

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
