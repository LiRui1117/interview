package com.deepexi.interview_system.controller;

import com.deepexi.interview_system.dto.PageResult;
import com.deepexi.interview_system.dto.RequestParam;
import com.deepexi.interview_system.dto.Result;
import com.deepexi.interview_system.model.Company;
import com.deepexi.interview_system.model.Interviewee;
import com.deepexi.interview_system.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interview")
public class IntervieweeController {

    @Autowired
    private InterviewService interviewService;

    /**
     * 查询所有
     * @return
     */
    @GetMapping("/findAll")
    public List<Interviewee> findAll(){
        return interviewService.findAll();
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/findPage/{page}/{size}")
    public PageResult<Interviewee> findPage(@PathVariable int page , @PathVariable int size){
        return interviewService.findPage(page,size,null);
    }

    @PostMapping("/search/{page}/{size}")
    public PageResult<Interviewee> search(@PathVariable int page , @PathVariable int size , @RequestBody RequestParam requestParam){
        return interviewService.findPage(page,size,requestParam);
    }

    /**
     * 根据面试人id查询公司
     *
     * @param applicant_id
     * @return
     */
    @GetMapping("/findAllById/{applicant_id}")
    public List<Company> findAllById(@PathVariable Integer applicant_id) {
        return interviewService.findCompanyById(applicant_id);
    }

    /**
     * 插入数据
     *
     * @param interviewee
     */
    @PostMapping("/insert")
    public Result insert(@RequestBody Interviewee interviewee) {
        try {
            interviewService.insertInterview(interviewee);
            return new Result(true,"添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加失败");
        }
    }

    /**
     * 更新数据
     *
     * @param interviewee
     */
    @PostMapping("/update")
    public Result update(@RequestBody Interviewee interviewee) {
        try {
            interviewService.updateInterview(interviewee);
            return new Result(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失败");
        }
    }

    /**
     * 根据id查询所有信息
     *
     * @param id
     * @return
     */
    @GetMapping("/findOne/{id}")
    public Interviewee findOne(@PathVariable int id) {
        return interviewService.findInterviewById(id);
    }

    /**
     * 根据id批量删除数据
     * @param ids
     * @return
     */
    @DeleteMapping("/delete/{ids}")
    public Result delete(@PathVariable int[] ids){
        try {
            interviewService.deleteIds(ids);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

    @GetMapping("/findInterviewer")
    public List<String> findInterviewer(){
        return interviewService.findInterviewer();
    }

    @GetMapping("/findInterviewpost")
    public List<String> findInterviewpost(){
        return interviewService.findInterviewpost();
    }



}
