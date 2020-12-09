package service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
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

    public List<JobInfo> listJobsWithCompanyName(Wrapper wrapper);

    public String getJobs(String companyId,int current,int size);
}
