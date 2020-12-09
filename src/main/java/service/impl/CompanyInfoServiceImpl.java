package service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import mapper.CheckInfoMapper;
import mapper.DeliverRecordInfoMapper;
import mapper.JobInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.CheckInfo;
import pojo.CompanyInfo;
import mapper.CompanyInfoMapper;
import pojo.DeliverRecordInfo;
import pojo.JobInfo;
import service.CompanyInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import service.DeliverRecordInfoService;
import util.json.RestResult;
import util.json.ResultCode;

import javax.swing.*;
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
public class CompanyInfoServiceImpl extends ServiceImpl<CompanyInfoMapper, CompanyInfo> implements CompanyInfoService {

    @Autowired
    CompanyInfoMapper mapper;
    @Autowired
    CheckInfoMapper checkInfoMapper;
    @Autowired
    JobInfoMapper jobInfoMapper;
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
