package service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.JobInfo;
import mapper.JobInfoMapper;
import service.JobInfoService;
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
public class JobInfoServiceImpl extends ServiceImpl<JobInfoMapper, JobInfo> implements JobInfoService {

    @Autowired
    JobInfoMapper jobInfoMapper;
    public IPage<JobInfo> listJobsWithCompanyName(Page<JobInfo> page, Wrapper wrapper){
        return jobInfoMapper.listJobsWithCompanyName(page, wrapper);
    }
    @Override
    public String getJobs(String companyId,int current,int size) {
        Page<JobInfo> jobInfoPage = jobInfoMapper.selectPage(new Page<>(current, size), new QueryWrapper<JobInfo>().eq("company_id", companyId));
        List<JobInfo> records = jobInfoPage.getRecords();
        List<HashMap<String,Object>> list = new ArrayList<>();
        for(JobInfo jobInfo : records){
            HashMap<String,Object> hs = new HashMap<>();
            hs.put("jobId",jobInfo.getJobId());
            hs.put("jobName",jobInfo.getJobName());
            hs.put("jobType",jobInfo.getJobType());
            hs.put("jobDescription",jobInfo.getJobDescription());
            hs.put("total",jobInfoPage.getTotal());
            list.add(hs);
        }
        return new RestResult().setCode(ResultCode.SUCCESS).setData(list).toString();
    }

    public boolean insertJob(JobInfo job){
        QueryWrapper<JobInfo> wrapper=new QueryWrapper<>();
        List<JobInfo> list=jobInfoMapper.selectList(wrapper.lambda().eq(JobInfo::getJobId,job.getJobId()));
        if(list.size()>0){
            return false;
        }
        jobInfoMapper.insert(job);
        return true;
    }

    @Override
    public void deleteJobById(String jobId) {
        jobInfoMapper.deleteById(jobId);
    }
}
