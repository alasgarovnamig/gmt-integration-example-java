package az.unitedpayment.gmt_integration_example_java.client;


import az.unitedpayment.gmt_integration_example_java.dto.request.search.SearchDto;
import az.unitedpayment.gmt_integration_example_java.dto.response.ResponseBase;
import az.unitedpayment.gmt_integration_example_java.dto.response.SearchBase;
import az.unitedpayment.gmt_integration_example_java.dto.response.job.TaskCreateResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "taskClient", url = "${app.base_url}/gateway/v1/task")
public interface TaskClient {
    @PostMapping("/search")
    ResponseBase<SearchBase<TaskCreateResponseDto>> taskSearch(
            @RequestBody SearchDto request,
            @RequestHeader("Authorization") String authorization
    );
}
