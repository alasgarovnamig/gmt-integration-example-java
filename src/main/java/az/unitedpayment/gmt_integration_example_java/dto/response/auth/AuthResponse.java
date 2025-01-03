package az.unitedpayment.gmt_integration_example_java.dto.response.auth;


import az.unitedpayment.gmt_integration_example_java.dto.response.Data;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthResponse implements Data {
    private String token;
}
