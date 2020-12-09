package controller;


import mapper.DeliverRecordInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import pojo.CheckInfo;
import pojo.CompanyInfo;
import pojo.DeliverRecordInfo;
import service.CompanyInfoService;
import service.DeliverRecordInfoService;
import service.ResumeInfoService;
import util.json.RestResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static javax.swing.text.html.CSS.getAttribute;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 560寝室
 * @since 2020-12-06
 */
@RestController
public class CompanyInfoController {

    @Autowired
    CompanyInfoService companyInfoService;
    @Autowired
    ResumeInfoService resumeInfoService;
    @Autowired
    DeliverRecordInfoService deliverRecordInfoService;
    @RequestMapping("/doRegister")
    public String register(HttpServletRequest request){
        String companyId = (String) request.getParameter("companyId");
        String password = (String) request.getParameter("password");
        String companyName = (String) request.getParameter("companyName");
        int companySize = Integer.parseInt(request.getParameter("companySize"));
        String companyProperty = (String) request.getParameter("companyProperty");
        String companyLocation = (String) request.getParameter("companyLocation");

        CompanyInfo c = new CompanyInfo();
        c.setCompanyId(companyId);
        c.setPassword(password);
        c.setCompanyName(companyName);
        c.setCompanyProperty(companyProperty);
        c.setCompanyStatus(CompanyInfo.CHECKING);
        c.setOcmpanySize(companySize);
        c.setCompanyLocation(companyLocation);

        CheckInfo k = new CheckInfo();
        k.setCompanyId(companyId);
        k.setCheckStatus(CheckInfo.CHECKING);
        return companyInfoService.register(c,k);
    }
    
    @RequestMapping("/getDeliverRecord")
    public String getResume(String studentName,int current,int size, HttpSession session){
        String companyId = (String) session.getAttribute("user");

        return deliverRecordInfoService.getDeliverRecordBySnameCid(current,size,studentName,companyId);
    }
}

