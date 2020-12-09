package service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.DeliverRecordInfo;
import mapper.DeliverRecordInfoMapper;
import service.DeliverRecordInfoService;
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
public class DeliverRecordInfoServiceImpl extends ServiceImpl<DeliverRecordInfoMapper, DeliverRecordInfo> implements DeliverRecordInfoService {
    @Autowired
    DeliverRecordInfoMapper deliverRecordInfoMapper;
    public List<DeliverRecordInfo> listDeliverRecordInfoWithJobNameAndCompanyName(Wrapper wrapper){
        return deliverRecordInfoMapper.listDeliverRecordInfoWithJobNameAndCompanyName(wrapper);
    }
}
