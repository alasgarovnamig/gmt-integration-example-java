package az.unitedpayment.gmt_integration_example_java.client;


import az.unitedpayment.gmt_integration_example_java.dto.request.search.SearchDto;
import az.unitedpayment.gmt_integration_example_java.dto.response.ResponseBase;
import az.unitedpayment.gmt_integration_example_java.dto.response.SearchBase;
import az.unitedpayment.gmt_integration_example_java.dto.response.card.CardData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "cardClient", url = "${app.base_url}/gateway/v1/card")
public interface CardClient {
    @PostMapping("/search")
    ResponseBase<SearchBase<CardData>> cardSearch(
            @RequestBody SearchDto request,
            @RequestHeader("Authorization") String authorization
    );
}
