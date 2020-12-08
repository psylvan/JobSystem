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
public class AdminInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.INPUT)
    private String adminId;

    private String password;

    private String adminName;


}
