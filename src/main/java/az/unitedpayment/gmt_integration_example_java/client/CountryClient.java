package az.unitedpayment.gmt_integration_example_java.client;


import az.unitedpayment.gmt_integration_example_java.dto.request.search.SearchDto;
import az.unitedpayment.gmt_integration_example_java.dto.response.ResponseBase;
import az.unitedpayment.gmt_integration_example_java.dto.response.SearchBase;
import az.unitedpayment.gmt_integration_example_java.dto.response.country.CountryData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "countryClient", url = "${app.base_url}/gateway/v1/country")
public interface CountryClient {
    @PostMapping("/search")
    ResponseBase<SearchBase<CountryData>> countrySearch(@RequestBody SearchDto request);
}

