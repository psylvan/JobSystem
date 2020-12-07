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
public class StudentInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final int MAN = 1;
    private static final int WOMAN = 0;

    @TableId(type = IdType.ASSIGN_UUID)
    private String studentId;

    private String password;

    private String studentName;

    private Integer sex;

    private String politicalStatus;

    private String hometown;


}
