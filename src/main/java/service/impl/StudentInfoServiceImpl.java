package service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.StudentInfo;
import mapper.StudentInfoMapper;
import service.StudentInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 560寝室
 * @since 2020-12-06
 */
@Service
public class StudentInfoServiceImpl extends ServiceImpl<StudentInfoMapper, StudentInfo> implements StudentInfoService {
    @Autowired
    private StudentInfoMapper studentInfoMapper;
    public int testAdvice(){
        StudentInfo s = new StudentInfo();
        s.setStudentId("333");
        s.setStudentName("ddd");
        int i = studentInfoMapper.insert(s);

        int x = 5/0;

        return i;
    }
}
