package az.unitedpayment.gmt_integration_example_java.dto.response.country;


import az.unitedpayment.gmt_integration_example_java.dto.response.Data;
import az.unitedpayment.gmt_integration_example_java.dto.response.SearchMarker;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CountryData implements SearchMarker, Data {
    private Long id;
    @JsonProperty("iso_3166_name")
    private String isoName;
    @JsonProperty("official_name")
    private String officialName;
    @JsonProperty("iso_3166_code_alpha2")
    private String isoCodeAlpha2;
    @JsonProperty("iso_3166_code_alpha3")
    private String isoCodeAlpha3;
    @JsonProperty("official_currencies")
    private Set<CurrencyData> officialCurrencies;
    @JsonProperty("paysend_supported_country_currencies")
    private Set<CurrencyData> paysendSupportedCurrencies;
}
