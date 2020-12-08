package pojo;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 560寝室
 * @since 2020-12-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CompanyInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int PASSED = 1;
    public static final int CHECKING = 0;

    @TableId(type = IdType.INPUT)
    private String companyId;

    private String password;

    private Integer companyStatus;

    private String companyName;

    private Integer ocmpanySize;

    private String companyProperty;

    private String companyLocation;

    private List<JobInfo> jobInfos;
}
