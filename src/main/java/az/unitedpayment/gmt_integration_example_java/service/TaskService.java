package az.unitedpayment.gmt_integration_example_java.service;


import az.unitedpayment.gmt_integration_example_java.dto.request.search.SearchDto;
import az.unitedpayment.gmt_integration_example_java.dto.response.ResponseBase;
import az.unitedpayment.gmt_integration_example_java.dto.response.SearchBase;
import az.unitedpayment.gmt_integration_example_java.dto.response.job.TaskCreateResponseDto;

public interface TaskService {
    ResponseBase<SearchBase<TaskCreateResponseDto>> Search(SearchDto searchDto);
}
