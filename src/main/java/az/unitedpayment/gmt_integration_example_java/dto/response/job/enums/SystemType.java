package az.unitedpayment.gmt_integration_example_java.dto.response.job.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum SystemType {
    DEFAULT("DEFAULT"),
    VISA("VISA"),
    MASTERCARD("MASTERCARD"),
    FINANCE("FINANCE"),
    ACCOUNT("ACCOUNT");

    private final String value;

    // A Map to store the string representation of enum values
    private static final Map<String, SystemType> STRING_TO_ENUM = new HashMap<>();
    private static final Map<SystemType, String> ENUM_TO_STRING = new HashMap<>();

    static {
        for (SystemType type : values()) {
            STRING_TO_ENUM.put(type.value, type);
            ENUM_TO_STRING.put(type, type.value);
        }
    }

    // Constructor
    SystemType(String value) {
        this.value = value;
    }

    // JSON Serialize (Enum -> String)
    @JsonValue
    public String toJson() {
        return ENUM_TO_STRING.get(this);
    }

    // JSON Deserialize (String -> Enum)
    @JsonCreator
    public static SystemType fromJson(String value) {
        SystemType type = STRING_TO_ENUM.get(value);
        if (type == null) {
            throw new IllegalArgumentException("Invalid SystemType value: " + value);
        }
        return type;
    }

    //  Return the string representation of an enum
    @Override
    public String toString() {
        return value;
    }
}