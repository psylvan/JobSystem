package service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
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

import javax.annotation.Resource;
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

    public List<CompanyInfo> selectUnsolvedCompany(Integer status){
        QueryWrapper<CompanyInfo> queryWrapper=new QueryWrapper<>();
        List<CompanyInfo> list=companyInfoMapper.selectList(queryWrapper.lambda().eq(CompanyInfo::getCompanyStatus,status));
        return list;
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

}
