package mapper;

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
    public List<DeliverRecordInfo> getDeliverRecordBySnameCid(@Param("sname") String studentName,@Param("cid") String companyId);
    public List<DeliverRecordInfo> test();
}
