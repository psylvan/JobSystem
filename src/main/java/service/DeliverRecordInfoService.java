package service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
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
    public List<DeliverRecordInfo> listDeliverRecordInfoWithJobNameAndCompanyName(@Param(Constants.WRAPPER) Wrapper wrapper);
}
