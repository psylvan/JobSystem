package pojo;

import java.io.Serializable;

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
public class JobInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final int DELETED = -1;
    public static final int USED = 1;

    @TableId(type = IdType.ASSIGN_ID)
    private String jobId;

    private String companyId;

    private String companyName;

    private String jobName;

    private String jobType;

    private String jobDescription;


}
