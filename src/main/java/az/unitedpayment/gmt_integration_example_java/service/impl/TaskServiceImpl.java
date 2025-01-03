package az.unitedpayment.gmt_integration_example_java.service.impl;


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
import az.unitedpayment.gmt_integration_example_java.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    @Value("${app.partner_unique_id}")
    private String partnerUniqueId;

    @Value("${app.password}")
    private String password;

    private final AuthClient authClient;
    private final TaskClient taskClient;

    @Override
    public ResponseBase<SearchBase<TaskCreateResponseDto>> Search(SearchDto searchDto) {
        ResponseBase<AuthResponse> resp = authClient.partnerLogin(PartnerLoginDto.builder()
                .partnerUniqueId(partnerUniqueId)
                .password(password)
                .build());

        AuthResponse authResponse = resp.getData();

        SearchDto request = SearchDto.builder()
                .criteriaSet(new HashSet<CriteriaDto>(Set.of(
                        CriteriaDto.builder()
                                .key("created_at")
                                .value("2024-12-07 11:38:15.8502419")
                                .operation(SearchOperation.GreaterThanEqual)
                                .build(),
                        CriteriaDto.builder()
                                .key("created_at")
                                .value(LocalDateTime.now().toString())
                                .operation(SearchOperation.LessThanEqual)
                                .build()
                )))
                .page(1)
                .size(50)
                .build();

        return taskClient.taskSearch(request, String.format("Bearer %s", authResponse.getToken()));
    }
}
