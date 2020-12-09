package service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.corba.se.impl.ior.OldJIDLObjectKeyTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.DeliverRecordInfo;
import mapper.DeliverRecordInfoMapper;
import service.DeliverRecordInfoService;
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
public class DeliverRecordInfoServiceImpl extends ServiceImpl<DeliverRecordInfoMapper, DeliverRecordInfo> implements DeliverRecordInfoService {

    @Autowired
    private DeliverRecordInfoMapper deliverRecordInfoMapper;
    @Override
    public String getDeliverRecordBySnameCid(int current,int size,String studentName, String companyId) {
        Page<DeliverRecordInfo> page = new Page<>(current,size);
        IPage<DeliverRecordInfo> deliverRecordBySnameCid = deliverRecordInfoMapper.getDeliverRecordBySnameCid(page,studentName, companyId);
        List<DeliverRecordInfo> records = deliverRecordBySnameCid.getRecords();

        List<HashMap<String , Object>> restList = new ArrayList<>();
        for(DeliverRecordInfo record : records){
            HashMap<String , Object> hs = new HashMap<>();
            hs.put("jobName",record.getJobInfo().getJobName());
            hs.put("jobType",record.getJobInfo().getJobType());
            hs.put("resumeName",record.getResumeInfo().getResumeName());
            hs.put("studentName",record.getResumeInfo().getStudentInfo().getStudentName());
            hs.put("time",record.getCreateTime());

            restList.add(hs);
        }
        return new RestResult().setData(restList).setCode(ResultCode.SUCCESS).toString();
    }
}
