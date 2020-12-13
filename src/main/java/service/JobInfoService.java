package service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import pojo.JobInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 560寝室
 * @since 2020-12-06
 */
public interface JobInfoService extends IService<JobInfo> {

    public IPage<JobInfo> listJobsWithCompanyName(Page<JobInfo> page, Wrapper wrapper);
    public boolean insertJob(JobInfo job);
    public void deleteJobById(String jobId);

    public String getJobs(String companyId,int current,int size);
}
