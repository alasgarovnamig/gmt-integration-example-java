package az.unitedpayment.gmt_integration_example_java.dto.response;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBase <T extends Data>{
    private String status;
    private Long code;
    private String comment;
    private T data;
}
