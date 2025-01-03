package az.unitedpayment.gmt_integration_example_java.dto.response.job;


import az.unitedpayment.gmt_integration_example_java.utils.MultiFormatDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentResult {

    private int id;

    @JsonProperty("created_at")
    @JsonDeserialize(using = MultiFormatDateDeserializer.class)
    private ZonedDateTime createdAt;

    @JsonProperty("task_response_arn")
    private String taskResponseArn;

    @JsonProperty("task_response_rrn")
    private String taskResponseRrn;

}
