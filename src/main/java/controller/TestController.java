package controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import mapper.DeliverRecordInfoMapper;
import mapper.JobInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pojo.JobInfo;
import pojo.ResumeInfo;
import pojo.StudentInfo;
import pojo.requestBody.GetJobsRequestBody;
import service.DeliverRecordInfoService;
import service.ResumeInfoService;
import service.StudentInfoService;
import util.json.RestResult;
import util.json.ResultCode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    @Autowired
    private StudentInfoService studentInfoService;
    @Autowired
    private ResumeInfoService resumeInfoService;
    @Autowired
    private DeliverRecordInfoService deliverRecordInfoService;
    @RequestMapping("/t1")
    public void test1(HttpSession session){
        session.setAttribute("user","dsj");
    }
    @RequestMapping("/t2")
    public String t2(HttpSession session){
        return session.getAttribute("user").toString();
    }

    @RequestMapping("/t3")
    public String t3(String studentName){
        return deliverRecordInfoService.getDeliverRecordBySnameCid(0,5,studentName,"123");
    }

    @RequestMapping("/t4")
    public String t4(@RequestBody List<Map> parmaMap){
        System.out.println(parmaMap);
        return null;
    }
//    @RequestMapping("/t4")
    public String t5(HttpServletRequest request){
        String[] values = request.getParameterValues("list[]");
        System.out.println(Arrays.asList(values));
        return null;
    }

    @RequestMapping("/welcome")
    public void t6(HttpServletResponse response) throws IOException {
        response.sendRedirect("html/index.html");
    }

    @Autowired
    JobInfoMapper jobInfoService;


    @RequestMapping("/getJobs2")
    public String getJobs(HttpSession session, HttpServletRequest request){
        //String studentId = (String) session.getAttribute("studentId");
        String studentId = "2220172361";
        String companyName = request.getParameter("companyName");
        String jobName = request.getParameter("jobName");
        String jobType = request.getParameter("jobType");
        System.out.println("=============");
        System.out.println(companyName);
        System.out.println(jobName);
        System.out.println(jobType);
        return  companyName+" "+jobName+" "+jobType;
        /*
        //设置分页器
        int current = 1;
        int size = 20;
        IPage<JobInfo> jobInfoIPage = new Page<>(current,size);
        //设置查询条件
        QueryWrapper<JobInfo> wrapper = new QueryWrapper<>();
        if (!companyName.equals("")) {
            wrapper.like("company_name",companyName);
        }
        if (!jobName.equals("")) {
            wrapper.like("job_name",jobName);
        }
        if (!jobType.equals("")) {
            wrapper.eq("job_type",jobType);
        }
        //执行查询
        List<JobInfo> jobInfos = jobInfoService.listJobsWithCompanyName(wrapper);
        //返回结果
        return new RestResult()
                .setCode(ResultCode.SUCCESS)
                .setData(jobInfos)
                .toString();
         */
    }
}
