package az.unitedpayment.gmt_integration_example_java.dto.request.search;

import az.unitedpayment.gmt_integration_example_java.dto.request.search.enums.SearchOperation;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CriteriaDto {
    private String key;
    private String value;
    @JsonProperty("search_operation")
    private SearchOperation operation;
    private String ChildKey;
    private String ChildTable;
    private String GrandChildKey;
    private String GrandChildTable;
}
