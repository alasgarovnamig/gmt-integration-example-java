package az.unitedpayment.gmt_integration_example_java.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SearchBase<T extends SearchMarker> implements Data {

    private Set<T> data;

    @JsonProperty("total_count")
    private int totalCount;

    private int page;

    private int size;
}
