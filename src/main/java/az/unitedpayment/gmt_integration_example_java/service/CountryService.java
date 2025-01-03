package az.unitedpayment.gmt_integration_example_java.service;


import az.unitedpayment.gmt_integration_example_java.dto.response.ResponseBase;
import az.unitedpayment.gmt_integration_example_java.dto.response.SearchBase;
import az.unitedpayment.gmt_integration_example_java.dto.response.country.CountryData;

public interface CountryService {
    ResponseBase<SearchBase<CountryData>> Search();
}
