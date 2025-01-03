package az.unitedpayment.gmt_integration_example_java.client;


import az.unitedpayment.gmt_integration_example_java.dto.request.job.JobCreateDto;
import az.unitedpayment.gmt_integration_example_java.dto.request.search.SearchDto;
import az.unitedpayment.gmt_integration_example_java.dto.response.ResponseBase;
import az.unitedpayment.gmt_integration_example_java.dto.response.SearchBase;
import az.unitedpayment.gmt_integration_example_java.dto.response.job.JobCreateResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "jobClient", url = "${app.base_url}/gateway/v1/job")
public interface JobClient {
    @PostMapping("/search")
    ResponseBase<SearchBase<JobCreateResponseDto>> jobSearch(
            @RequestBody SearchDto request,
            @RequestHeader("Authorization") String authorization
    );

    @PostMapping("/")
    ResponseBase<JobCreateResponseDto> jobCreate(
            @RequestBody JobCreateDto request,
            @RequestHeader("Authorization") String authorization
    );
}
