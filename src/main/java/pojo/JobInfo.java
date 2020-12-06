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
public class JobInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String jobId;

    private String companyId;

    private String jobName;

    private String jobType;

    private String jobDescription;


}
