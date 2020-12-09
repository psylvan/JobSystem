package service.impl;

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
    private DeliverRecordInfoMapper deliverRecordInfoMapper;
    @Override
    public String getDeliverRecordBySnameCid(String studentName, String companyId) {
        List<DeliverRecordInfo> list = deliverRecordInfoMapper.getDeliverRecordBySnameCid(studentName, companyId);
        System.out.println(list);
        return null;
    }
}
