package az.unitedpayment.gmt_integration_example_java.dto.request.job;


import az.unitedpayment.gmt_integration_example_java.dto.request.job.enums.TaskType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaskDto {
    @JsonProperty("task_partner_id")
    private String taskPartnerId;

    @JsonProperty("task_type")
    private TaskType taskType;

    @JsonProperty("payload")
    private Payload payload;

    @JsonProperty("task_callback_uri")
    private String taskCallbackUri;
}
