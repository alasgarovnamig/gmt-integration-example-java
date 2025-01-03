package az.unitedpayment.gmt_integration_example_java.controller;


import az.unitedpayment.gmt_integration_example_java.client.AuthClient;
import az.unitedpayment.gmt_integration_example_java.client.TaskClient;
import az.unitedpayment.gmt_integration_example_java.dto.request.auth.PartnerLoginDto;
import az.unitedpayment.gmt_integration_example_java.dto.request.search.CriteriaDto;
import az.unitedpayment.gmt_integration_example_java.dto.request.search.SearchDto;
import az.unitedpayment.gmt_integration_example_java.dto.request.search.enums.SearchOperation;
import az.unitedpayment.gmt_integration_example_java.dto.response.ResponseBase;
import az.unitedpayment.gmt_integration_example_java.dto.response.SearchBase;
import az.unitedpayment.gmt_integration_example_java.dto.response.auth.AuthResponse;
import az.unitedpayment.gmt_integration_example_java.dto.response.job.TaskCreateResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/callback")
public class CallbackApproverController {

    @Value("${app.partner_unique_id}")
    private String partnerUniqueId;

    @Value("${app.password}")
    private String password;


    private final AuthClient authClient;
    private final TaskClient taskClient;

    @GetMapping()
    public ResponseEntity<Void> get(@RequestParam(name = "job_partner_id", required = false) String jobPartnerId,
                                    @RequestParam(name = "job_task_id", required = false) String jobTaskId) {

        System.out.println(jobPartnerId);
        System.out.println(jobTaskId);
        ResponseBase<AuthResponse> resp = authClient.partnerLogin(PartnerLoginDto.builder()
                .partnerUniqueId(partnerUniqueId)
                .password(password)
                .build());

        AuthResponse authResponse = resp.getData();

        SearchDto request = SearchDto.builder()
                .criteriaSet(new HashSet<CriteriaDto>(Set.of(
                        CriteriaDto.builder()
                                .key("task_partner_id")
                                .value(jobTaskId)
                                .operation(SearchOperation.Equal)
                                .build()
                )))
                .page(1)
                .size(50)
                .build();

        ResponseBase<SearchBase<TaskCreateResponseDto>> searchBase = taskClient.taskSearch(request, String.format("Bearer %s", authResponse.getToken()));
        System.out.println(searchBase);
        return ResponseEntity.ok().build();
    }
}
