package az.unitedpayment.gmt_integration_example_java.service.impl;


import az.unitedpayment.gmt_integration_example_java.client.CountryClient;
import az.unitedpayment.gmt_integration_example_java.dto.request.search.SearchDto;
import az.unitedpayment.gmt_integration_example_java.dto.response.ResponseBase;
import az.unitedpayment.gmt_integration_example_java.dto.response.SearchBase;
import az.unitedpayment.gmt_integration_example_java.dto.response.country.CountryData;
import az.unitedpayment.gmt_integration_example_java.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryClient countryClient;

    @Override
    public ResponseBase<SearchBase<CountryData>> Search() {

        SearchDto request = SearchDto.builder()
                .page(1)
                .size(500)
                .build();

        return countryClient.countrySearch(request);
    }
}
