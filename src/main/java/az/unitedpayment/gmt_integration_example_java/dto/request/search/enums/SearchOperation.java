package az.unitedpayment.gmt_integration_example_java.dto.request.search.enums;

import lombok.Getter;

@Getter
public enum SearchOperation {
    GreaterThan("GreaterThan"),
    LessThan("LessThan"),
    GreaterThanEqual("GreaterThanEqual"),
    LessThanEqual("LessThanEqual"),
    NotEqual("NotEqual"),
    Equal("Equal"),
    In("In"),
    NotIn("NotIn"),
    Match("Match"),
    MatchStart("MatchStart"),
    MatchEnd("MatchEnd"),
    JoinChild("JoinChild"),
    JoinGrandChild("JoinGrandChild"),
    AnyOf("AnyOf"),
    IsMember("IsMember"),
    Is("Is"),
    IsNot("IsNot"),
    ManyToMany("ManyToMany");

    // Getter
    private final String operation;

    // Constructor
    SearchOperation(String operation) {
        this.operation = operation;
    }

    // Static method to get enum by string value
    public static SearchOperation fromString(String value) {
        for (SearchOperation op : SearchOperation.values()) {
            if (op.getOperation().equalsIgnoreCase(value)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Invalid SearchOperation value: " + value);
    }
}
