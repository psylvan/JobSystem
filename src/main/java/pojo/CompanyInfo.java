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
public class CompanyInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String companyId;

    private String password;

    private Integer companyStatus;

    private String companyName;

    private Integer ocmpanySize;

    private String companyProperty;

    private String companyLocation;

}
