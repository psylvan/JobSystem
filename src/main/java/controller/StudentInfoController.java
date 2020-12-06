package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.StudentInfo;
import service.StudentInfoService;
import util.RestResult;
import util.ResultCode;

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
public class StudentInfoController {
    @Autowired
    private StudentInfoService studentInfoService;

    @RequestMapping("/getInfo")
    @ResponseBody
    public String getStudentList(){
        List<StudentInfo> list = studentInfoService.list();
        return new RestResult()
                .setCode(ResultCode.SUCCESS)
                .setMessage("成功")
                .setData(list)
                .toString();
    }
}

