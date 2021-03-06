package service;

import pojo.ResumeInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 560寝室
 * @since 2020-12-06
 */
public interface ResumeInfoService extends IService<ResumeInfo> {
    public String getResume(String studentName,String companyId);
    public void getResumeById();
}
