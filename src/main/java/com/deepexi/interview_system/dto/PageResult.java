package com.deepexi.interview_system.dto;

import com.deepexi.interview_system.model.Interviewee;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 查询结果集
 */
@Data
public class PageResult<T> implements Serializable {
    private Long total;//总记录数
    private List<T> list;//数据

    public PageResult(Long total, List<T> list) {
        this.total = total;
        this.list = list;
    }

    public PageResult() {}
}
