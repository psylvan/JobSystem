package service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import mapper.DeliverRecordInfoMapper;
import mapper.JobInfoMapper;
import mapper.StudentInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.DeliverRecordInfo;
import pojo.JobInfo;
import pojo.ResumeInfo;
import mapper.ResumeInfoMapper;
import pojo.StudentInfo;
import service.JobInfoService;
import service.ResumeInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import util.json.RestResult;
import util.json.ResultCode;

import java.util.ArrayList;
import java.util.HashMap;
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
public class ResumeInfoServiceImpl extends ServiceImpl<ResumeInfoMapper, ResumeInfo> implements ResumeInfoService {

    @Autowired
    StudentInfoMapper studentInfoMapper;
    @Autowired
    ResumeInfoMapper resumeInfoMapper;
    @Autowired
    DeliverRecordInfoMapper deliverRecordMapper;
    @Autowired
    JobInfoMapper jobInfoMapper;
    //根据投递记录查询
    @Override
    public String getResume(String studentName,String companyId) {
        return null;
    }

    public void getResumeById(){
        String id = "2220172361";
        System.out.println(resumeInfoMapper.getResumeInfoById(id));

    }
}
