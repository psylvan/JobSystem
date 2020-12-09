package mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public IPage<DeliverRecordInfo> getDeliverRecordBySnameCid(Page<?> page, @Param("sname") String studentName, @Param("cid") String companyId);
    public List<DeliverRecordInfo> test();
}
