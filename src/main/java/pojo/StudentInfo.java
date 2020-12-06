package pojo;

import java.io.Serializable;
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

    private String studentId;

    private String password;

    private String studentName;

    private Integer sex;

    private String politicalStatus;

    private String hometown;


}
