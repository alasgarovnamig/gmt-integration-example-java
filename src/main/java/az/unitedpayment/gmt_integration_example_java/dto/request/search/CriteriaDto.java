package az.unitedpayment.gmt_integration_example_java.dto.request.search;

import az.unitedpayment.gmt_integration_example_java.dto.request.search.enums.SearchOperation;
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
    private SearchOperation operation;
    private String ChildKey;
    private String ChildTable;
    private String GrandChildKey;
    private String GrandChildTable;
}
