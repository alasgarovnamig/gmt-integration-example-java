package az.unitedpayment.gmt_integration_example_java.dto.response.job.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum TaskStatus {
    CREATED("CREATED"),
    ACCEPTED("ACCEPTED"),
    PROCESSING("PROCESSING"),
    SUCCESS("SUCCESS"),
    FAILED("FAILED"),
    SKIPPED("SKIPPED");

    private final String value;

    // A Map to store the string representation of enum values
    private static final Map<String, TaskStatus> STRING_TO_ENUM = new HashMap<>();
    private static final Map<TaskStatus, String> ENUM_TO_STRING = new HashMap<>();


    static {
        for (TaskStatus status : values()) {
            STRING_TO_ENUM.put(status.value, status);
            ENUM_TO_STRING.put(status, status.value);
        }
    }

    // Constructor
    TaskStatus(String value) {
        this.value = value;
    }

    // JSON Serialize (Enum -> String)
    @JsonValue
    public String toJson() {
        return ENUM_TO_STRING.get(this);
    }

    // JSON Deserialize (String -> Enum)
    @JsonCreator
    public static TaskStatus fromJson(String value) {
        TaskStatus status = STRING_TO_ENUM.get(value);
        if (status == null) {
            throw new IllegalArgumentException("Invalid TasksStatus value: " + value);
        }
        return status;
    }

    //  Return the string representation of an enum
    @Override
    public String toString() {
        return value;
    }
}
