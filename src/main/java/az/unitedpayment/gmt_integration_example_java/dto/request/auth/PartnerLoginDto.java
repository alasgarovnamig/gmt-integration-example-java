package az.unitedpayment.gmt_integration_example_java.dto.request.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PartnerLoginDto {
    @JsonProperty("partner_unique_id")
    private String partnerUniqueId;

    private String password;

    @JsonProperty("remember_me")
    private boolean rememberMe;
}
