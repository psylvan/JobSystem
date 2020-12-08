package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import pojo.CheckInfo;
import pojo.CompanyInfo;
import pojo.DeliverRecordInfo;
import service.CompanyInfoService;
import service.DeliverRecordInfoService;

import javax.servlet.http.HttpServletRequest;

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
}

