package az.unitedpayment.gmt_integration_example_java.service;


import az.unitedpayment.gmt_integration_example_java.dto.request.job.JobCreateDto;
import az.unitedpayment.gmt_integration_example_java.dto.response.ResponseBase;
import az.unitedpayment.gmt_integration_example_java.dto.response.SearchBase;
import az.unitedpayment.gmt_integration_example_java.dto.response.job.JobCreateResponseDto;

public interface JobService {
    ResponseBase<JobCreateResponseDto> Create(JobCreateDto jobCreateDto);

    ResponseBase<SearchBase<JobCreateResponseDto>> Search();
}
