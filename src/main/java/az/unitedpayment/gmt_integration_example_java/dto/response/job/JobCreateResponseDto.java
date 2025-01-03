package az.unitedpayment.gmt_integration_example_java.dto.response.job;


import az.unitedpayment.gmt_integration_example_java.dto.response.Data;
import az.unitedpayment.gmt_integration_example_java.dto.response.SearchMarker;
import az.unitedpayment.gmt_integration_example_java.dto.response.job.enums.JobStatus;
import az.unitedpayment.gmt_integration_example_java.utils.MultiFormatDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JobCreateResponseDto implements SearchMarker, Data {

    private Long id;

    @JsonProperty("created_at")
    @JsonDeserialize(using = MultiFormatDateDeserializer.class)
    private ZonedDateTime createdAt;

    @JsonProperty("updated_at")
    @JsonDeserialize(using = MultiFormatDateDeserializer.class)
    private ZonedDateTime updatedAt;

    @JsonProperty("deleted_at")
    @JsonDeserialize(using = MultiFormatDateDeserializer.class)
    private ZonedDateTime deletedAt;

    @JsonProperty("up_reference")
    private String upReference;

    @JsonProperty("partner_job_id")
    private String partnerJobId;

    @JsonProperty("paysend_id")
    private String paysendId;

    @JsonProperty("paysend_global_id")
    private String paysendGlobalId;

    private JobStatus status;

    @JsonProperty("job_paysend_status")
    private String jobPaysendStatus;

    @JsonProperty("job_paysend_code")
    private int jobPaysendCode;

    @JsonProperty("job_paysend_accept_date")
    @JsonDeserialize(using = MultiFormatDateDeserializer.class)
    private ZonedDateTime jobPaysendAcceptDate;

    private List<TaskCreateResponseDto> tasks;

}
