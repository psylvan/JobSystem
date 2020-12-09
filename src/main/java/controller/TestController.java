package controller;

import mapper.DeliverRecordInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.ResumeInfo;
import pojo.StudentInfo;
import service.DeliverRecordInfoService;
import service.ResumeInfoService;
import service.StudentInfoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public String t3(){
        deliverRecordInfoService.getDeliverRecordBySnameCid("dsj","123");
        return null;
    }

    @Autowired
    DeliverRecordInfoMapper mapper;
    @RequestMapping("/t4")
    public String t4(){
        System.out.println(mapper.test());
        return "123";
    }
}
