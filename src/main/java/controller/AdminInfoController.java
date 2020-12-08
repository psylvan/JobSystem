package controller;


import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 560寝室
 * @since 2020-12-06
 */
@RestController
public class AdminInfoController {
    @Autowired
    private StudentInfoService studentInfoService;
    @Autowired
    private CompanyInfoService companyInfoService;
    @Autowired
    private AdminInfoService adminInfoService;
    @RequestMapping("/doLogin")
    public String doLogin(String userId, String password, int identity, HttpSession session){
        RestResult result = new RestResult();
        //学生
        if(identity==1){
            StudentInfo stu = studentInfoService.getById(userId);
            if(stu==null)
                result.setCode(ResultCode.FAIL).setMessage("用户不存在");
            else if(stu.getPassword().equals(password)){
                session.setAttribute("user",userId);
                result.setCode(ResultCode.SUCCESS).setMessage("验证成功");
            }else {
                result.setCode(ResultCode.FAIL).setMessage("密码错误");
            }
        }
        //企业
        else if(identity == 2){
            CompanyInfo user = companyInfoService.getById(userId);
            if(user==null)
                result.setCode(ResultCode.FAIL).setMessage("用户不存在");
            else if(user.getPassword().equals(password)){
                session.setAttribute("user",userId);
                result.setCode(ResultCode.SUCCESS).setMessage("验证成功");
            }else {
                result.setCode(ResultCode.FAIL).setMessage("密码错误");
            }
        }
        //管理员
        else{
            AdminInfo user = adminInfoService.getById(userId);
            if(user==null)
                result.setCode(ResultCode.FAIL).setMessage("用户不存在");
            else if(user.getPassword().equals(password)){
                session.setAttribute("user",userId);
                result.setCode(ResultCode.SUCCESS).setMessage("验证成功");
            }else {
                result.setCode(ResultCode.FAIL).setMessage("密码错误");
            }
        }

        return result.toString();
    }
}

