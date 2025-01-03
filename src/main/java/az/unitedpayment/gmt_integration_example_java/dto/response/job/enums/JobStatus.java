package az.unitedpayment.gmt_integration_example_java.dto.response.job.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum JobStatus {
    SAVED("SAVED"),
    PUBLISHED("PUBLISHED"),
    APPROVED("APPROVED"),
    FINISHED("FINISHED");

    private final String value;

    // A Map to store the string representation of enum values
    private static final Map<String, JobStatus> STRING_TO_ENUM = new HashMap<>();
    private static final Map<JobStatus, String> ENUM_TO_STRING = new HashMap<>();

    static {
        for (JobStatus status : values()) {
            STRING_TO_ENUM.put(status.value, status);
            ENUM_TO_STRING.put(status, status.value);
        }

        // Ek string eşlemeleri
        STRING_TO_ENUM.put("CREATED", SAVED);
        STRING_TO_ENUM.put("PROCESSING", PUBLISHED);
        STRING_TO_ENUM.put("ACCEPTED", APPROVED);
    }

    // Constructor
    JobStatus(String value) {
        this.value = value;
    }

    // JSON Serialize (Enum -> String)
    @JsonValue
    public String toJson() {
        return ENUM_TO_STRING.get(this);
    }

    // JSON Deserialize (String -> Enum)
    @JsonCreator
    public static JobStatus fromJson(String value) {
        JobStatus status = STRING_TO_ENUM.get(value);
        if (status == null) {
            throw new IllegalArgumentException("Invalid JobStatus value: " + value);
        }
        return status;
    }

    //  Return the string representation of an enum
    @Override
    public String toString() {
        return value;
    }
}