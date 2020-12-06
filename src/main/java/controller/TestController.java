package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.ResumeInfo;
import pojo.StudentInfo;
import service.ResumeInfoService;
import service.StudentInfoService;

@RestController
public class TestController {
    @Autowired
    private StudentInfoService studentInfoService;
    @Autowired
    private ResumeInfoService resumeInfoService;
    @RequestMapping("/t1")
    public void test1(){
        ResumeInfo resumeInfo = new ResumeInfo();
        resumeInfo.setResumeName("wodejianli");
        resumeInfoService.save(resumeInfo);
    }
    @RequestMapping("/t2")
    public void t2(){

    }
}
