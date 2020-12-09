package mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import pojo.DeliverRecordInfo;
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
public interface DeliverRecordInfoMapper extends BaseMapper<DeliverRecordInfo> {
    public List<DeliverRecordInfo> listDeliverRecordInfoWithJobNameAndCompanyName(@Param(Constants.WRAPPER) Wrapper wrapper);
}
