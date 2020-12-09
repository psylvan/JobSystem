package service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.JobInfo;
import mapper.JobInfoMapper;
import service.JobInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import util.json.RestResult;
import util.json.ResultCode;

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
public class JobInfoServiceImpl extends ServiceImpl<JobInfoMapper, JobInfo> implements JobInfoService {

    @Autowired
    JobInfoMapper jobInfoMapper;
    public List<JobInfo> listJobsWithCompanyName(Wrapper wrapper){
        return jobInfoMapper.listJobsWithCompanyName(wrapper);
    }
    @Override
    public String getJobs(String companyId,int current,int size) {
        Page<JobInfo> jobInfoPage = jobInfoMapper.selectPage(new Page<>(current, size), new QueryWrapper<JobInfo>().eq("company_id", companyId));
        List<JobInfo> records = jobInfoPage.getRecords();
        return new RestResult().setCode(ResultCode.SUCCESS).setData(records).toString();
    }
}
