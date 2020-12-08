package service;

import pojo.CheckInfo;
import pojo.CompanyInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import pojo.DeliverRecordInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 560寝室
 * @since 2020-12-06
 */
public interface CompanyInfoService extends IService<CompanyInfo> {

    public String register(CompanyInfo companyInfo, CheckInfo checkInfo);
}
