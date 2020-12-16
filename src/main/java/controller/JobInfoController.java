package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
import pojo.JobInfo;
import service.JobInfoService;
import util.json.RestResult;
import util.json.ResultCode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 560寝室
 * @since 2020-12-06
 */
@Controller
public class JobInfoController {
    @Autowired
    private JobInfoService jobInfoService;

    @RequestMapping("/addJob")
    @ResponseBody
    public String addJob(HttpSession session, HttpServletRequest request){
        JobInfo job=new JobInfo();
        String companyId=(String)session.getAttribute("user");
        job.setCompanyId(companyId);
        String jobName=(String)request.getParameter("jobName");
        job.setJobName(jobName);
        String jobType=(String)request.getParameter("jobType");
        job.setJobType(jobType);
        String jobDescription=(String)request.getParameter("jobDescription");
        System.out.println(jobDescription);
        //转义HTML标签
        String processedJobDescription = HtmlUtils.htmlEscape(jobDescription);
        System.out.println(processedJobDescription);
        job.setJobDescription(processedJobDescription);
        //job.setJobDescription(jobDescription);
        boolean flag=jobInfoService.insertJob(job);
        if(flag){
            return new RestResult().setCode(ResultCode.SUCCESS).setMessage("新增职位成功").setData(job).toString();
        }
        return new RestResult().setCode(ResultCode.FAIL).setMessage("职位已存在").toString();
    }

    @RequestMapping("/removeJob")
    @ResponseBody
    public String removeJob(HttpServletRequest request){
        String jobId=request.getParameter("jobId");
        jobInfoService.deleteJobById(jobId);
        return new RestResult().setCode(ResultCode.SUCCESS).setMessage("删除职位成功").toString();
    }
}

