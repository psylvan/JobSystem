package pojo;

import java.util.Date;
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
public class DeliverRecordInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final int ACCEPTED = 2;//接受OFFER
    private static final int ADOPTED = 1;//企业发放offer
    private static final int DELIVERED = 0; //简历已经投递
    private static final int UNADOPTED = -1; //未被企业录用
    private static final int UNACCEPTED = -2;//拒绝企业OFFER

    @TableId(type = IdType.ASSIGN_ID)
    private String deliverId;

    private String jobId;

    private String resumeId;

    private Date createTime;

    private Integer status;


}
