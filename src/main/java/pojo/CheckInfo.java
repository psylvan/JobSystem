package pojo;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class CheckInfo implements Serializable {

    public static final int PASSED = 1;
    public static final int CHECKING = 0;
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.ASSIGN_ID)
    private String checkId;

    private String companyId;
    @TableField(exist = false)
    private CompanyInfo companyInfo;

    private Integer checkStatus;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;


}
