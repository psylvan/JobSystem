package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import pojo.AdminInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import pojo.CompanyInfo;
import pojo.StudentInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 560寝室
 * @since 2020-12-06
 */
public interface AdminInfoService extends IService<AdminInfo> {
    public List<CompanyInfo> selectUnsolvedCompany(String companyName, Integer status);
    public List<CompanyInfo> selectUnsolvedCompany(Integer status);
    public List<StudentInfo> selectAllStudent();
    public boolean insertStudent(StudentInfo stu);
    public CompanyInfo updateCompany(String companyId);
}
