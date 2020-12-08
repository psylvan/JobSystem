package mapper;

import pojo.ResumeInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 560寝室
 * @since 2020-12-06
 */
public interface ResumeInfoMapper extends BaseMapper<ResumeInfo> {
    public List<ResumeInfo> getResumeInfoById(String studentId);
}
