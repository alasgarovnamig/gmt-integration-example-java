package az.unitedpayment.gmt_integration_example_java.dto.response.card;


import az.unitedpayment.gmt_integration_example_java.dto.response.SearchMarker;
import az.unitedpayment.gmt_integration_example_java.utils.MultiFormatDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardData implements SearchMarker {

    private Long id;

    @JsonProperty("created_at")
    @JsonDeserialize(using = MultiFormatDateDeserializer.class)
    private ZonedDateTime createdAt;

    @JsonProperty("task_response_product_type")
    private String taskResponseProductType;

    @JsonProperty("task_response_currency_iso_num")
    private String taskResponseCurrencyISONum;

    @JsonProperty("task_response_currency_iso_code")
    private String taskResponseCurrencyISOCode;

    @JsonProperty("task_response_bank")
    private String taskResponseBank;

    @JsonProperty("task_response_country_iso_num")
    private String taskResponseCountryISONum;

    @JsonProperty("task_response_pay_system")
    private String taskResponsePaySystem;

    @JsonProperty("task_response_token")
    private String taskResponseToken;

    @JsonProperty("task_response_card_number")
    private String taskResponseCardNumber;

//    @JsonProperty("TaskID")
//    private Long taskId;
}
