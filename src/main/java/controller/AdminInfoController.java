package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import pojo.AdminInfo;
import pojo.CompanyInfo;
import pojo.StudentInfo;
import service.AdminInfoService;
import service.CompanyInfoService;
import service.StudentInfoService;
import util.json.RestResult;
import util.json.ResultCode;

import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.CompanyInfo;
import pojo.StudentInfo;
import service.AdminInfoService;
import service.CompanyInfoService;
import service.StudentInfoService;
import util.json.RestResult;
import util.json.ResultCode;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 560寝室
 * @since 2020-12-06
 */

@Controller

public class AdminInfoController {
    @Autowired
    private StudentInfoService studentInfoService;
    @Autowired
    private CompanyInfoService companyInfoService;
    @Autowired
    private AdminInfoService adminInfoService;

    @RequestMapping("/doLogin")
    public String doLogin(String userId, String password, int identity, HttpSession session) {
        RestResult result = new RestResult();
        //学生
        if (identity == 1) {
            StudentInfo stu = studentInfoService.getById(userId);
            if (stu == null)
                result.setCode(ResultCode.FAIL).setMessage("用户不存在");
            else if (stu.getPassword().equals(password)) {
                session.setAttribute("user", userId);
                result.setCode(ResultCode.SUCCESS).setMessage("验证成功");
            } else {
                result.setCode(ResultCode.FAIL).setMessage("密码错误");
            }
        }
        //企业
        else if (identity == 2) {
            CompanyInfo user = companyInfoService.getById(userId);
            if (user == null)
                result.setCode(ResultCode.FAIL).setMessage("用户不存在");
            else if (user.getPassword().equals(password)) {
                session.setAttribute("user", userId);
                result.setCode(ResultCode.SUCCESS).setMessage("验证成功");
            } else {
                result.setCode(ResultCode.FAIL).setMessage("密码错误");
            }
        }
        //管理员
        else {
            AdminInfo user = adminInfoService.getById(userId);
            if (user == null)
                result.setCode(ResultCode.FAIL).setMessage("用户不存在");
            else if (user.getPassword().equals(password)) {
                session.setAttribute("user", userId);
                result.setCode(ResultCode.SUCCESS).setMessage("验证成功");
            } else {
                result.setCode(ResultCode.FAIL).setMessage("密码错误");
            }
        }
        return result.toString();
    }

    //    @Autowired
//    private StudentInfoService studentInfoService;
    @RequestMapping("/showUnsolved")
    @ResponseBody
    public String getUnsolvedCompany() {
        List<CompanyInfo> list = adminInfoService.selectUnsolvedCompany(-1);
        return new RestResult().setCode(ResultCode.SUCCESS).setMessage("成功").setData(list).toString();
    }

    @RequestMapping("/showAll")
    @ResponseBody
    public String getAllStudent() {
        List<StudentInfo> list = adminInfoService.selectAllStudent();
        return new RestResult().setCode(ResultCode.SUCCESS).setMessage("成功").setData(list).toString();
    }

    @RequestMapping("/insertStu")
    @ResponseBody
    public String getStudent(){
        StudentInfo student=new StudentInfo();
        student.setStudentId("2220172047");
        student.setPassword("111");
        student.setStudentName("aaa");
        student.setSex(1);
        student.setPoliticalStatus(null);
        student.setHometown("北京");
        if(adminInfoService.insertStudent(student)){
            return new RestResult().setCode(ResultCode.SUCCESS).setMessage("成功").setData(student).toString();
        }
        return new RestResult().setCode(ResultCode.FAIL).setMessage("失败").toString();
    }

    @RequestMapping("/company/{id}/{flag}")
    @ResponseBody
    public String checkCompany(@PathVariable("id") String companyId, @PathVariable("flag") boolean flag){
        if(flag){
            CompanyInfo companyInfo=adminInfoService.updateCompany(companyId);
            return new RestResult().setCode(ResultCode.SUCCESS).setMessage("已通过").setData(companyInfo).toString();
        }
        return new RestResult().setCode(ResultCode.SUCCESS).setMessage("未通过").toString();
    }
}

