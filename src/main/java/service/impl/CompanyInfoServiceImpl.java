package service.impl;

import mapper.CheckInfoMapper;
import mapper.DeliverRecordInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.CheckInfo;
import pojo.CompanyInfo;
import mapper.CompanyInfoMapper;
import pojo.DeliverRecordInfo;
import service.CompanyInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import service.DeliverRecordInfoService;
import util.json.RestResult;
import util.json.ResultCode;

import javax.swing.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 560寝室
 * @since 2020-12-06
 */
@Service
public class CompanyInfoServiceImpl extends ServiceImpl<CompanyInfoMapper, CompanyInfo> implements CompanyInfoService {

    @Autowired
    CompanyInfoMapper mapper;
    @Autowired
    CheckInfoMapper checkInfoMapper;
    @Override
    public String register(CompanyInfo companyInfo, CheckInfo checkInfo) {
        if(mapper.selectById(companyInfo.getCompanyId()) != null){
            return new RestResult().
                    setCode(ResultCode.FAIL).setMessage("用户名已存在").toString();
        }

        mapper.insert(companyInfo);
        checkInfoMapper.insert(checkInfo);

        return new RestResult().
                setCode(ResultCode.SUCCESS).setMessage("注册成功").toString();
    }
}
