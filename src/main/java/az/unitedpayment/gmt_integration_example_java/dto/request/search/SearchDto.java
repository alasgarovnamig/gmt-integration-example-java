package az.unitedpayment.gmt_integration_example_java.dto.request.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SearchDto {
    @JsonProperty("criteria")
    private Set<CriteriaDto> criteriaSet;
    @JsonProperty("page")
    private int page;
    @JsonProperty("size")
    private int size;
}
