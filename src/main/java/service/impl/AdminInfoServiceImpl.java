package service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import mapper.CompanyInfoMapper;
import mapper.StudentInfoMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.AdminInfo;
import mapper.AdminInfoMapper;
import pojo.CompanyInfo;
import pojo.StudentInfo;
import service.AdminInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import util.json.RestResult;
import util.json.ResultCode;

import javax.annotation.Resource;
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
@Service("adminInfoService")
public class AdminInfoServiceImpl extends ServiceImpl<AdminInfoMapper, AdminInfo> implements AdminInfoService {
    @Resource
    private CompanyInfoMapper companyInfoMapper;
    @Resource
    private StudentInfoMapper studentInfoMapper;
    @Override
    public List<CompanyInfo> selectUnsolvedCompany(String companyName, Integer status) {
        QueryWrapper<CompanyInfo> queryWrapper=new QueryWrapper<>();
        List<CompanyInfo> list=companyInfoMapper.selectList(queryWrapper.lambda().eq(CompanyInfo::getCompanyName,companyName).eq(CompanyInfo::getCompanyStatus,status));
        return list;
    }

    public String selectUnsolvedCompany(Integer status,int current,int size){
        QueryWrapper<CompanyInfo> queryWrapper=new QueryWrapper<>();
//        List<CompanyInfo> list=companyInfoMapper.selectList(queryWrapper.lambda().eq(CompanyInfo::getCompanyStatus,status));
        Page<CompanyInfo> companyInfoPage=companyInfoMapper.selectPage(new Page<>(current,size),queryWrapper.lambda().eq(CompanyInfo::getCompanyStatus,status));

        List<CompanyInfo> records=companyInfoPage.getRecords();
        List<HashMap<String,Object>> list=new ArrayList<>();
        for(CompanyInfo companyInfo:records){
            HashMap<String,Object> hs = new HashMap<>();
            hs.put("companyId",companyInfo.getCompanyId());
            hs.put("companyStatus",companyInfo.getCompanyStatus());
            hs.put("companyName",companyInfo.getCompanyName());
            hs.put("companySize",companyInfo.getOcmpanySize());
            hs.put("companyProperty",companyInfo.getCompanyProperty());
            hs.put("companyLocation",companyInfo.getCompanyLocation());
            hs.put("total",companyInfoPage.getTotal());
            list.add(hs);
        }
        return new RestResult().setCode(ResultCode.SUCCESS).setData(list).toString();
    }

    public List<StudentInfo> selectAllStudent(){
        QueryWrapper<StudentInfo> queryWrapper=new QueryWrapper<>();
        List<StudentInfo> list=studentInfoMapper.selectList(queryWrapper);
        return list;
    }

    public boolean insertStudent(StudentInfo stu){
        QueryWrapper<StudentInfo> queryWrapper=new QueryWrapper<>();
        List<StudentInfo> list=studentInfoMapper.selectList(queryWrapper.lambda().eq(StudentInfo::getStudentId,stu.getStudentId()));
        if(list.size()>0){
            return false;
        }
        studentInfoMapper.insert(stu);
        return true;
    }

    public CompanyInfo updateCompany(String companyId) {
        LambdaUpdateWrapper<CompanyInfo> updateWrapper=new LambdaUpdateWrapper<>();
        CompanyInfo companyInfo=companyInfoMapper.selectById(companyId);
        updateWrapper.eq(CompanyInfo::getCompanyId,companyId).set(CompanyInfo::getCompanyStatus,1);
        Integer rows=companyInfoMapper.update(companyInfo,updateWrapper);
        return companyInfo;
    }

    public CompanyInfo rejectCompany(String companyId) {
        LambdaUpdateWrapper<CompanyInfo> updateWrapper=new LambdaUpdateWrapper<>();
        CompanyInfo companyInfo=companyInfoMapper.selectById(companyId);
        updateWrapper.eq(CompanyInfo::getCompanyId,companyId).set(CompanyInfo::getCompanyStatus,-1);
        Integer rows=companyInfoMapper.update(companyInfo,updateWrapper);
        return companyInfo;
    }

    public CompanyInfo searchCompany(String companyId){
        CompanyInfo companyInfo=companyInfoMapper.selectById(companyId);
        return companyInfo;
    }

}
