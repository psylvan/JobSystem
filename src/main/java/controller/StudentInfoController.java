package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import service.StudentInfoService;
import service.impl.StudentInfoServiceImpl;

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


}

