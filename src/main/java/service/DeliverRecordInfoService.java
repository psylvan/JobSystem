package service;

import pojo.DeliverRecordInfo;
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
public interface DeliverRecordInfoService extends IService<DeliverRecordInfo> {

    public String  getDeliverRecordBySnameCid(String studentName, String companyId);

}
