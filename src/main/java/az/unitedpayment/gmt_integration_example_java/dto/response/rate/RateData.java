package az.unitedpayment.gmt_integration_example_java.dto.response.rate;


import az.unitedpayment.gmt_integration_example_java.dto.response.SearchMarker;
import az.unitedpayment.gmt_integration_example_java.dto.response.job.enums.SystemType;
import az.unitedpayment.gmt_integration_example_java.utils.MultiFormatDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RateData implements SearchMarker {

    private int id;

    @JsonProperty("created_at")
    @JsonDeserialize(using = MultiFormatDateDeserializer.class)
    private ZonedDateTime createdAt;

    @JsonProperty("task_response_to_amount")
    private BigDecimal taskResponseToAmount;

    @JsonProperty("task_response_to_currency")
    private String taskResponseToCurrency;

    @JsonProperty("task_response_from_amount")
    private BigDecimal taskResponseFromAmount;

    @JsonProperty("task_response_from_currency")
    private String taskResponseFromCurrency;

    @JsonProperty("task_response_rate")
    private BigDecimal taskResponseRate;

    @JsonProperty("system_type")
    private SystemType systemType;

    @JsonProperty("task_response_expiration_date")
    @JsonDeserialize(using = MultiFormatDateDeserializer.class)
    private ZonedDateTime taskResponseExpirationDate;

}