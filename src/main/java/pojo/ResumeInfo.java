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
public class ResumeInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final int DELIVERD = 1;
    private static final int UNDELIVERED = 0;

    @TableId(type = IdType.ASSIGN_ID)
    private String resumeId;

    private String studentId;

    private String resumeName;

    private Integer resumeStatus;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    private String url;


}
