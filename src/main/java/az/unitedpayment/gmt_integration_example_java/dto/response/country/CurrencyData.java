package az.unitedpayment.gmt_integration_example_java.dto.response.country;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CurrencyData {
    private Long id;
    @JsonProperty("iso_4217_num")
    private String isoNum;
    @JsonProperty("iso_4217_code")
    private String isoCode;
    @JsonProperty("currency_name")
    private String currencyName;
}