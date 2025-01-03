package az.unitedpayment.gmt_integration_example_java.client;


import az.unitedpayment.gmt_integration_example_java.dto.request.auth.PartnerLoginDto;
import az.unitedpayment.gmt_integration_example_java.dto.response.ResponseBase;
import az.unitedpayment.gmt_integration_example_java.dto.response.auth.AuthResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "authClient", url = "${app.base_url}/authz/v1")
public interface AuthClient {
    @PostMapping("/auth/partner-login")
    ResponseBase<AuthResponse> partnerLogin(@RequestBody PartnerLoginDto request);
}
