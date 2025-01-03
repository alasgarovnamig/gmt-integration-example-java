package az.unitedpayment.gmt_integration_example_java.dto.request.job;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JobCreateDto {
    @JsonProperty("partner_job_id")
    private String partnerJobId;
    @JsonProperty("tasks")
    private Set<TaskDto> taskSet;
}
