package pojo.requestBody;

import lombok.Data;

@Data
public class GetJobsRequestBody {
    String jobName;
    String companyName;
    String jobType;
    int current;
    int size;
}
